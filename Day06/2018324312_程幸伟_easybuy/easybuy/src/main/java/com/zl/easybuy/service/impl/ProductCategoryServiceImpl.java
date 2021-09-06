package com.zl.easybuy.service.impl;

import com.zl.easybuy.bo.ProductBO;
import com.zl.easybuy.mapper.ProductCategoryMapper;
import com.zl.easybuy.mapper.ProductMapper;
import com.zl.easybuy.pojo.Product;
import com.zl.easybuy.pojo.ProductCategory;
import com.zl.easybuy.service.ProductCategoryService;
import com.zl.easybuy.vo.ProductCategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductCategoryVo> queryAllProductCategory() {
        List<ProductCategoryVo> firstProductCategoryVoList = new ArrayList<>();
        //商品的条件对象
        ProductBO productBO = new ProductBO();
        productBO.setPage(true);
        productBO.setStartIndex(0);
        productBO.setPageSize(6);

        Product product = new Product();
        productBO.setProduct(product);


        //1.得到一级分类的vo对象
        //查询一级分类
        List<ProductCategory> firstProductCategorylist = productCategoryMapper.queryByType(1);
        //遍历一级分类,   根据一级分类,查询该一级分类下所有的二级分类
        for (ProductCategory firstProductCategory : firstProductCategorylist) {
            //创建一级分类的vo对象
            ProductCategoryVo firstProductCategoryVo = new ProductCategoryVo();
            //添加一级分类的productCategory的属性
            firstProductCategoryVo.setProductCategory(firstProductCategory);

            //创建一个二级分类的vo的list集合
            List<ProductCategoryVo> secondProductCategoryVoList = new ArrayList<>();

            //得到该一级分类的二级分类的vo集合
            List<ProductCategory> secondProductCategoryList = productCategoryMapper.queryByParentId(firstProductCategory.getId());
            for (ProductCategory secondProductCategory : secondProductCategoryList) {
                //创建二级分类的vo对象
                ProductCategoryVo secondProductCategoryVo = new ProductCategoryVo();
                //设置二级分类信息
                secondProductCategoryVo.setProductCategory(secondProductCategory);

                //该二级分类的三级分类信息
                //创建三级分类的vo集合
                List<ProductCategoryVo> threeProductCategoryVoList = new ArrayList<>();
                //根据二级分类的id查询三级分类
                List<ProductCategory> threeProductCategoryList = productCategoryMapper.queryByParentId(secondProductCategory.getId());
                //构建三级分类的vo对象
                for (ProductCategory threeProductCategory : threeProductCategoryList) {
                    ProductCategoryVo threeProductCategoryVo = new ProductCategoryVo();
                    threeProductCategoryVo.setProductCategory(threeProductCategory);

                    //把三级分类的vo对象添加到threeProductCategoryVoList 中
                    threeProductCategoryVoList.add(threeProductCategoryVo);
                }

                //把三级vo集合添加到对应二级分类vo的productCategoryVoList属性
                secondProductCategoryVo.setProductCategoryVoList(threeProductCategoryVoList);

                //把二级分类的vo对象添加到secondProductCategoryList集合
                secondProductCategoryVoList.add(secondProductCategoryVo);
            }
            //设置一级分类vo对象的productCategoryVoList属性,  二级分类的vo集合
            firstProductCategoryVo.setProductCategoryVoList(secondProductCategoryVoList);

            //查询一级分类的商品集合  分页查询   查询6条数据
            product.setCategoryLevel1Id(firstProductCategory.getId());
            List<Product> productList = productMapper.queryByPages(productBO);
            //添加到一级分类的productList属性
            firstProductCategoryVo.setProductList(productList);

            //把一级分类的vo对象添加到返回的List集合中
            firstProductCategoryVoList.add(firstProductCategoryVo);
        }

        return firstProductCategoryVoList;
    }
}

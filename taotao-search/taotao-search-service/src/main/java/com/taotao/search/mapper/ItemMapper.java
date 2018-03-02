package com.taotao.search.mapper;


import java.util.List;

import com.taotao.common.pojo.SearchItem;

public interface  ItemMapper {
	//获取要导入到索引库中的数据
	List<SearchItem> getItemList();
	//根据商品ID查询商品详情
	SearchItem getItemById(long itemId);
}

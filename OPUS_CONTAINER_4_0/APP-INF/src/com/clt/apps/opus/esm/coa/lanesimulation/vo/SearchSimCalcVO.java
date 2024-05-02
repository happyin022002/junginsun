package com.clt.apps.opus.esm.coa.lanesimulation.vo;

import java.util.ArrayList;
import java.util.List;

public class SearchSimCalcVO {

	private SearchSimPortListVO  searchSimPortListVO = null;
	private List<SearchSimPortListVO> searchSimPortListVOs = null;
	
	public SearchSimCalcVO(){
		searchSimPortListVO = new SearchSimPortListVO();
		searchSimPortListVOs = new ArrayList<SearchSimPortListVO>();
	}
	
	public void setSearchSimPortListVO(SearchSimPortListVO SearchSimPortListVO){
		this.searchSimPortListVO = SearchSimPortListVO;
	}
	
	public SearchSimPortListVO getSearchSimPortListVO(){
		return this.searchSimPortListVO;
	}
	
	public void setSearchSimPortListVOs(List<SearchSimPortListVO> SearchSimPortListVOs){
		this.searchSimPortListVOs = SearchSimPortListVOs;
	}
	
	public List<SearchSimPortListVO> getSearchSimPortListVOs(){
		return this.searchSimPortListVOs;
	}
	
}

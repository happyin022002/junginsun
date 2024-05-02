/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : SearchPrnrScgListVO.java
 *@FileTitle : SearchPrnrScgListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.06.10
 *@LastModifier : Yona.Ha.
 *@LastVersion : 1.0
 * 2015.06.10 Yona.Ha. 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo;

import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;


/**
 * Table Value Object<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이도형
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SearchPrnrScgListVO {
	private List<SearchPrnrDGListVO> searchPrnrDGListVO = null;

	private SearchPrnrDGListVO[]  searchPrnrDGListVOs = null;
	
	public List<SearchPrnrDGListVO> getSearchPrnrDGListVO() {
		return searchPrnrDGListVO;
	}

	public void setSearchPrnrDGListVO(List<SearchPrnrDGListVO> searchPrnrDGListVO) {
		this.searchPrnrDGListVO = searchPrnrDGListVO;
	}

	public SearchPrnrDGListVO[] getSearchPrnrDGListVOs() {
		return searchPrnrDGListVOs;
	}

	public void setSearchPrnrDGListVOs(SearchPrnrDGListVO[] searchPrnrDGListVOs) {
		this.searchPrnrDGListVOs = searchPrnrDGListVOs;
	}	
}

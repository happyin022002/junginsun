/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UNNumberGrpVO.java
*@FileTitle : UNNumberGrpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.29
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.29 이도형 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo;

import java.util.ArrayList;
import java.util.List;
import com.hanjin.syscommon.common.table.ScgImdgUnNoVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnAWKListVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnBBListVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnDGListVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnRFListVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.syscommon.common.table.ScgImdgSubsRskLblVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이도형
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SearchOwnScgListVO {
	
//	SearchOwnDGListVO  searchOwnDGListVO  = getSearchOwnDGListVO();
//	SearchOwnAWKListVO searchOwnAWKListVO = getSearchOwnAWKListVO();
//	SearchOwnBBListVO  searchOwnBBListVO  = getSearchOwnBBListVO();
//	SearchOwnRFListVO  searchOwnRFListVO  = getSearchOwnRFListVO();

	private List<SearchOwnDGListVO> searchOwnDGListVO = null;
	private List<SearchOwnAWKListVO> searchOwnAWKListVO = null;
	private List<SearchOwnBBListVO> searchOwnBBListVO = null;
	private List<SearchOwnRFListVO> searchOwnRFListVO = null;

	private SearchOwnDGListVO[]  searchOwnDGListVOs = null;
	private SearchOwnAWKListVO[] searchOwnAWKListVOs = null;
	private SearchOwnBBListVO[]  searchOwnBBListVOs = null;
	private SearchOwnRFListVO[]  searchOwnRFListVOs = null;

	
	public List<SearchOwnDGListVO> getSearchOwnDGListVO() {
		return searchOwnDGListVO;
	}

	public List<SearchOwnAWKListVO> getSearchOwnAWKListVO() {
		return searchOwnAWKListVO;
	}

	public List<SearchOwnBBListVO> getSearchOwnBBListVO() {
		return searchOwnBBListVO;
	}

	public List<SearchOwnRFListVO> getSearchOwnRFListVO() {
		return searchOwnRFListVO;
	}
	
//	public SearchOwnAWKListVO getSearchOwnAWKListVO() {
//		return searchOwnAWKListVO;
//	}
//
//	public SearchOwnBBListVO getSearchOwnBBListVO() {
//		return searchOwnBBListVO;
//	}
//
//	public SearchOwnRFListVO getSearchOwnRFListVO() {
//		return searchOwnRFListVO;
//	}


	public void setSearchOwnDGListVO(List<SearchOwnDGListVO> searchOwnDGListVO) {
		this.searchOwnDGListVO = searchOwnDGListVO;
	}

	public void setSearchOwnAWKListVO(List<SearchOwnAWKListVO> searchOwnAWKListVO) {
		this.searchOwnAWKListVO = searchOwnAWKListVO;
	}

	public void setSearchOwnBBListVO(List<SearchOwnBBListVO> searchOwnBBListVO) {
		this.searchOwnBBListVO = searchOwnBBListVO;
	}

	public void setSearchOwnRFListVO(List<SearchOwnRFListVO> searchOwnRFListVO) {
		this.searchOwnRFListVO = searchOwnRFListVO;
	}
	
//	public void setSearchOwnDGListVO(SearchOwnDGListVO searchOwnDGListVO) {
//		this.searchOwnDGListVO = searchOwnDGListVO;
//	}

//	public void setSearchOwnAWKListVO(SearchOwnAWKListVO searchOwnAWKListVO) {
//		this.searchOwnAWKListVO = searchOwnAWKListVO;
//	}
//
//	public void setSearchOwnBBListVO(SearchOwnBBListVO searchOwnBBListVO) {
//		this.searchOwnBBListVO = searchOwnBBListVO;
//	}
//	
//	public void setSearchOwnRFListVO(SearchOwnRFListVO searchOwnRFListVO) {
//		this.searchOwnRFListVO = searchOwnRFListVO;
//	}
	
	
	
	public SearchOwnDGListVO[] getSearchOwnDGListVOs() {
		return searchOwnDGListVOs;
	}

	public SearchOwnAWKListVO[] getSearchOwnAWKListVOs() {
		return searchOwnAWKListVOs;
	}

	public SearchOwnBBListVO[] getSearchOwnBBListVOs() {
		return searchOwnBBListVOs;
	}

	public SearchOwnRFListVO[] getSearchOwnRFListVOs() {
		return searchOwnRFListVOs;
	}

	public void setSearchOwnDGListVOs(SearchOwnDGListVO[] searchOwnDGListVOs) {
		this.searchOwnDGListVOs = searchOwnDGListVOs;
	}	

	public void setSearchOwnAWKListVOs(SearchOwnAWKListVO[] searchOwnAWKListVOs) {
		this.searchOwnAWKListVOs = searchOwnAWKListVOs;
	}	

	public void setSearchOwnBBListVOs(SearchOwnBBListVO[] searchOwnBBListVOs) {
		this.searchOwnBBListVOs = searchOwnBBListVOs;
	}	

	public void setSearchOwnRFListVOs(SearchOwnRFListVO[] searchOwnRFListVOs) {
		this.searchOwnRFListVOs = searchOwnRFListVOs;
	}	
	
}

/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsmFms0089Event.java
*@FileTitle : EsmFms0089Event
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.02
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.01.02 민정호 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchRfStatusListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0089 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0089HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  JungHo Min
 * @see ESM_FMS_0089HTMLAction 참조
 * @since J2EE 1.5
 */

public class EsmFms0089Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String vvd = "";
		
	private String searchType = "";
	
	
	/** Table Value Object Multi Data 처리 */
	private SearchRfStatusListVO[] searchRfStatusListVOs = null;

	public EsmFms0089Event(){}
	
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	public String getVvd() {
		return vvd;
	}
		
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
	public String getSearchType() {
		return searchType;
	}
	
	public void setSearchRfStatusListVOS(SearchRfStatusListVO[] searchRfStatusListVOs){
		if (searchRfStatusListVOs != null) {
			SearchRfStatusListVO[] tmpVOs = Arrays.copyOf(searchRfStatusListVOs, searchRfStatusListVOs.length);
			this.searchRfStatusListVOs = tmpVOs;
		}
	}

	public SearchRfStatusListVO[] getSearchRfStatusListVOS(){
			SearchRfStatusListVO[] rtnVOs = null;
		if (this.searchRfStatusListVOs != null) {
			rtnVOs = Arrays.copyOf(searchRfStatusListVOs, searchRfStatusListVOs.length);
		}
		return rtnVOs;
	}
}
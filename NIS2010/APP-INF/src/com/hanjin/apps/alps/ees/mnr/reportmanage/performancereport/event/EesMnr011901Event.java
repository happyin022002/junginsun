/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0119_01Event.java
*@FileTitle : PFMC by CEDEX Code에 대한  Damge FQ 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.13
*@LastModifier : 이덕환
*@LastVersion : 1.0
* 2014.10.13 이덕환
* 1.0 Creation
* ---------------------------------------------------------
* history
* 2015.01.19 Chang Young Kim 품질결함으로 인한 소스명변경을 이유로 소스 수정(EesMnr0119_01Event.java -> EesMnr011901Event.java)
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event;

import java.util.List;

import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.SearchFoodQualityDetailKeyINVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_MNR_0119_01 에 대한 DTOP(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0119_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 이덕환
 * @see EES_MNR_0119HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr011901Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchFoodQualityDetailKeyINVO searchFoodQualityDetailKeyINVO = null;
	private List<SearchFoodQualityDetailKeyINVO> searchFoodQualityDetailMultiINVO 	= null;
	
	public EesMnr011901Event(){}
	
	public SearchFoodQualityDetailKeyINVO getSearchFoodQualityDetailKeyVO() {
		return searchFoodQualityDetailKeyINVO; 
	}
	
	public List<SearchFoodQualityDetailKeyINVO>  getSearchFoodQualityDetailMultiVO() {
		return searchFoodQualityDetailMultiINVO; 
	}
	
	public void setSearchFoodQualityDetailKeyVO(SearchFoodQualityDetailKeyINVO searchFoodQualityDetailKeyINVO) {
		this.searchFoodQualityDetailKeyINVO = searchFoodQualityDetailKeyINVO;
	}

	public void setSearchFoodQualityDetailMultiVOs(
			List<SearchFoodQualityDetailKeyINVO> searchFoodQualityDetailKeyINVOs) {
		this.searchFoodQualityDetailMultiINVO = searchFoodQualityDetailKeyINVOs;
	}
	
}
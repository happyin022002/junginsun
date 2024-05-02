/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0412Event.java
*@FileTitle : Queue Detail List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.BkgDpcsDocWeightVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueDetailListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchPerfVolByRegionGroupInVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0412 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0412HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김경섭
 * @see ESM_BKG_0412HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0432Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO = null;

	/** Table Value Object Multi Data 처리 */
	private SearchPerfVolByRegionGroupInVO[] searchPerfVolByRegionGroupInVOs = null;
	


	public SearchPerfVolByRegionGroupInVO getSearchPerfVolByRegionGroupInVO() {
		return searchPerfVolByRegionGroupInVO;
	}



	public void setSearchPerfVolByRegionGroupInVO(
			SearchPerfVolByRegionGroupInVO searchPerfVolByRegionGroupInVO) {
		this.searchPerfVolByRegionGroupInVO = searchPerfVolByRegionGroupInVO;
	}





	public SearchPerfVolByRegionGroupInVO[] getSearchPerfVolByRegionGroupInVOs() {
		SearchPerfVolByRegionGroupInVO[] rtnVOs = null;
		if (this.searchPerfVolByRegionGroupInVOs != null) {
			rtnVOs = Arrays.copyOf(searchPerfVolByRegionGroupInVOs, searchPerfVolByRegionGroupInVOs.length);
		}
		return rtnVOs;
	}





	public void setSearchPerfVolByRegionGroupInVOs(SearchPerfVolByRegionGroupInVO[] searchPerfVolByRegionGroupInVOs){
		if(searchPerfVolByRegionGroupInVOs != null){
			SearchPerfVolByRegionGroupInVO[] tmpVOs = Arrays.copyOf(searchPerfVolByRegionGroupInVOs, searchPerfVolByRegionGroupInVOs.length);
			this.searchPerfVolByRegionGroupInVOs = tmpVOs;
		}
	}





	public EsmBkg0432Event(){}


 
	
}
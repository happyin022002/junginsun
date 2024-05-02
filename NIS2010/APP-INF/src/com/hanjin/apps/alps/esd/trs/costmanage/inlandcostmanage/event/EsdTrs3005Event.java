/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdTrs3005Event.java
*@FileTitle : Inland Cost Management - Cost Detail
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.05.25 변종건 [CHM-201217633] Inland Cost Management - Cost Detail 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.event;

import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.SearchInlandCostAccountVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TRS_3005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TRS_3005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESD_TRS_3005HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTrs3005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	
	public EsdTrs3005Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchInlandCostAccountVO searchInlandCostAccountVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchInlandCostAccountVO[] searchInlandCostAccountVOs = null;

	
	public SearchInlandCostAccountVO getSearchInlandCostAccountVO() {
		return searchInlandCostAccountVO;
	}

	public void setSearchInlandCostAccountVO(
			SearchInlandCostAccountVO searchInlandCostAccountVO) {
		this.searchInlandCostAccountVO = searchInlandCostAccountVO;
	}

	public SearchInlandCostAccountVO[] getSearchInlandCostAccountVOs() {
		return searchInlandCostAccountVOs;
	}

	public void setSearchInlandCostAccountVOs(
			SearchInlandCostAccountVO[] searchInlandCostAccountVOs) {
		this.searchInlandCostAccountVOs = searchInlandCostAccountVOs;
	}
	
}

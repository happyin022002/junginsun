/*=========================================================
*Copyright(c) 2015 CyberLogitec 
*@FileName : EsdEas0319Event
*@FileTitle : Performance For Logistics Expense - S/P Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2015-02-02
*@LastModifier : 9014613
*@LastVersion : 1.0
* 2015-02-02
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.audperf.event;

import com.hanjin.apps.alps.esd.eas.expnaud.audperf.vo.SearchPerfCostDtlListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0319 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0319HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 9014613
 * @see ESD_EAS_0319HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0319Event extends EventSupport {
	/** Table Value Object MultiCombo 조회 조건 및 단건 처리  */
	SearchPerfCostDtlListVO searchPerfCostListVO = null;
	
	/** Table Value Object MultiCombo 다건 처리  */
	SearchPerfCostDtlListVO[] searchPerfCostListVOs = null;
	
	private static final long serialVersionUID = 1L;
	
	public SearchPerfCostDtlListVO getSearchPerfCostDtlListVO() {
		return searchPerfCostListVO;
	}
	public void setSearchPerfCostDtlListVO(SearchPerfCostDtlListVO searchPerfCostListVO) {
		this.searchPerfCostListVO = searchPerfCostListVO;
	}
	public SearchPerfCostDtlListVO[] getSearchPerfCostDtlListVOs() {
		SearchPerfCostDtlListVO[] rtnVOs = null;
		if (this.searchPerfCostListVOs != null) {
			rtnVOs = new SearchPerfCostDtlListVO[searchPerfCostListVOs.length];
			System.arraycopy(searchPerfCostListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	public void setSearchPerfCostDtlListVOs(SearchPerfCostDtlListVO[] searchPerfCostListVOs){
		if(searchPerfCostListVOs != null){
			SearchPerfCostDtlListVO[] tmpVOs = new SearchPerfCostDtlListVO[searchPerfCostListVOs.length];
			System.arraycopy(searchPerfCostListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchPerfCostListVOs = tmpVOs;
		}
	}
}
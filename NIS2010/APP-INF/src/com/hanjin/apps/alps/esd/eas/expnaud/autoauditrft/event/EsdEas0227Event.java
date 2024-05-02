/*=========================================================
*Copyright(c) 2015 CyberLogitec 
*@FileName : EsdEas0317Event.java
*@FileTitle : Performance For Logistics Expense
*Open Issues :
*Change history :
*@LastModifyDate : 2015-02-02
*@LastModifier : 9014613
*@LastVersion : 1.0
* 2015-02-02
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.autoauditrft.event;

import com.hanjin.apps.alps.esd.eas.expnaud.autoauditrft.vo.SearchAutoAuditChangeHistoryVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0227 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0227HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 9014613
 * @see ESD_EAS_0227HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0227Event extends EventSupport {
	/** Table Value Object MultiCombo 조회 조건 및 단건 처리  */
	SearchAutoAuditChangeHistoryVO searchAutoAuditChangeHistoryVO = null;
	
	/** Table Value Object MultiCombo 다건 처리  */
	SearchAutoAuditChangeHistoryVO[] searchAutoAuditChangeHistoryVOs = null;
	
	private static final long serialVersionUID = 1L;
	
	public  SearchAutoAuditChangeHistoryVO getSearchAutoAuditChangeHistoryVO() {
		return  searchAutoAuditChangeHistoryVO;
	}
	public void setSearchAutoAuditChangeHistoryVO(SearchAutoAuditChangeHistoryVO  searchAutoAuditChangeHistoryVO) {
		this.searchAutoAuditChangeHistoryVO = searchAutoAuditChangeHistoryVO;
	}
	public SearchAutoAuditChangeHistoryVO[] getSearchAutoAuditChangeHistoryVOs() {
		SearchAutoAuditChangeHistoryVO[] rtnVOs = null;
		if (this.searchAutoAuditChangeHistoryVOs != null) {
			rtnVOs = new SearchAutoAuditChangeHistoryVO[searchAutoAuditChangeHistoryVOs.length];
			System.arraycopy(searchAutoAuditChangeHistoryVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	public void setSearchAutoAuditChangeHistorys(SearchAutoAuditChangeHistoryVO[] searchAutoAuditChangeHistorVOs){
		if(searchAutoAuditChangeHistorVOs != null){
			SearchAutoAuditChangeHistoryVO[] tmpVOs = new SearchAutoAuditChangeHistoryVO[searchAutoAuditChangeHistorVOs.length];
			System.arraycopy(searchAutoAuditChangeHistorVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchAutoAuditChangeHistoryVOs = tmpVOs;
		}
	}
}
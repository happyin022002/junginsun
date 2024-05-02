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

import com.hanjin.apps.alps.esd.eas.expnaud.autoauditrft.vo.SearchAutoAuditStatisticsVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0228 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0228HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 9014613
 * @see ESD_EAS_0228HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0228Event extends EventSupport {
	/** Table Value Object MultiCombo 조회 조건 및 단건 처리  */
	SearchAutoAuditStatisticsVO searchAutoAuditStatisticsVO = null;
	
	/** Table Value Object MultiCombo 다건 처리  */
	SearchAutoAuditStatisticsVO[] searchAutoAuditStatisticsVOs = null;
	
	private static final long serialVersionUID = 1L;
	
	public  SearchAutoAuditStatisticsVO getSearchAutoAuditStatisticsVO() {
		return  searchAutoAuditStatisticsVO;
	}
	public void setSearchAutoAuditStatisticsVO(SearchAutoAuditStatisticsVO  searchAutoAuditStatisticsVO) {
		this.searchAutoAuditStatisticsVO = searchAutoAuditStatisticsVO;
	}
	public SearchAutoAuditStatisticsVO[] getSearchAutoAuditStatisticsVOs() {
		SearchAutoAuditStatisticsVO[] rtnVOs = null;
		if (this.searchAutoAuditStatisticsVOs != null) {
			rtnVOs = new SearchAutoAuditStatisticsVO[searchAutoAuditStatisticsVOs.length];
			System.arraycopy(searchAutoAuditStatisticsVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	public void setSearchAutoAuditStatisticss(SearchAutoAuditStatisticsVO[] searchAutoAuditStatisticsVOs){
		if(searchAutoAuditStatisticsVOs != null){
			SearchAutoAuditStatisticsVO[] tmpVOs = new SearchAutoAuditStatisticsVO[searchAutoAuditStatisticsVOs.length];
			System.arraycopy(searchAutoAuditStatisticsVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchAutoAuditStatisticsVOs = tmpVOs;
		}
	}
}
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_910Event.java
*@FileTitle : Currency Change Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-06
*@LastModifier : Lee_SangWoo
*@LastVersion : 1.0
* 2006-12-06 Lee_SangWoo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TrsTrspScgDtlVO;

/**
 * ESD_TRS_0910 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0910HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee_SangWoo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0910Event extends EventSupport {
	
	/** trs_trsp_scg_dtl Table  Value Object */
	private TrsTrspScgDtlVO trsTrspScgDtlVO = null;

	
	public EsdTrs0910Event(){}	
	
	
	public String getEventName() {
		return "EsdTrs0910Event";
	}

	public String toString() {
		return "EsdTrs0910Event";
	}


	public void setTrsTrspScgDtlVO(TrsTrspScgDtlVO trsTrspScgDtlVO) {
		this.trsTrspScgDtlVO = trsTrspScgDtlVO;
	}


	public TrsTrspScgDtlVO getTrsTrspScgDtlVO() {
		return trsTrspScgDtlVO;
	}

}

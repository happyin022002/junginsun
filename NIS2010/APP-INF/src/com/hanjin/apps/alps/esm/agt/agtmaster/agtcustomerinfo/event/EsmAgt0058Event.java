/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_025Event.java
*@FileTitle : Freight Forwarder VS Vendor Matching Info for Brokerage
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-22
*@LastModifier : Junghyung_kim
*@LastVersion : 1.0
* 2006-11-22 Junghyung_kim
* 1.0 최초 생성
* 1.1 2011.04.22 박성진 [CHM-201109104-01] Customer Vs Vendor for S. America 추가
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtmaster.agtcustomerinfo.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.AgtCmpnCustMtchVO;

/**
 * ESM_AGT_025 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_AGT_025HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Junghyung_kim
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmAgt0058Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	private AgtCmpnCustMtchVO agtCmpnCustMtchVO = null;
	
	private AgtCmpnCustMtchVO[] agtCmpnCustMtchVOs = null;

	public AgtCmpnCustMtchVO getAgtCmpnCustMtchVO() {
    	return agtCmpnCustMtchVO;
    }

	public void setAgtCmpnCustMtchVO(AgtCmpnCustMtchVO agtCmpnCustMtchVO) {
    	this.agtCmpnCustMtchVO = agtCmpnCustMtchVO;
    }

	public AgtCmpnCustMtchVO[] getAgtCmpnCustMtchVOs() {
    	return agtCmpnCustMtchVOs;
    }

	public void setAgtCmpnCustMtchVOs(AgtCmpnCustMtchVO[] agtCmpnCustMtchVOs) {
    	this.agtCmpnCustMtchVOs = agtCmpnCustMtchVOs;
    }
	
	

}

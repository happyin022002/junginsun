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
=========================================================*/
package com.clt.apps.opus.esm.agt.agtmaster.agtcustomerinfo.event;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.AgtBrogCustMtchVO;

/**
 * ESM_AGT_025 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_AGT_025HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Junghyung_kim
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmAgt0025Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	private AgtBrogCustMtchVO agtBrogCustMtchVO = null;
	
	private AgtBrogCustMtchVO[] agtBrogCustMtchVOs = null;

	public AgtBrogCustMtchVO getAgtBrogCustMtchVO() {
    	return agtBrogCustMtchVO;
    }

	public void setAgtBrogCustMtchVO(AgtBrogCustMtchVO agtBrogCustMtchVO) {
    	this.agtBrogCustMtchVO = agtBrogCustMtchVO;
    }

	public AgtBrogCustMtchVO[] getAgtBrogCustMtchVOs() {
    	return agtBrogCustMtchVOs;
    }

	public void setAgtBrogCustMtchVOs(AgtBrogCustMtchVO[] agtBrogCustMtchVOs) {
    	this.agtBrogCustMtchVOs = agtBrogCustMtchVOs;
    }
	
	

}

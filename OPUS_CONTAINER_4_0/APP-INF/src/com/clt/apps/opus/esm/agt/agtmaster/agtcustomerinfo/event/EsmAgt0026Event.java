/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_026Event.java
*@FileTitle : Brokerage Shipper 관계 관리 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-30
*@LastModifier : Sang-Jun Kwon
*@LastVersion : 1.0
* 2006-11-30 Sang-Jun Kwon
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.agt.agtmaster.agtcustomerinfo.event;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.AgtBrogCustIntVO;


/**
 * ESM_AGT_026 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_AGT_026HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sang-Jun Kwon
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmAgt0026Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private AgtBrogCustIntVO agtBrogCustIntVO = null;
	
	private AgtBrogCustIntVO[] agtBrogCustIntVOs = null;

	public AgtBrogCustIntVO getAgtBrogCustIntVO() {
    	return agtBrogCustIntVO;
    }

	public void setAgtBrogCustIntVO(AgtBrogCustIntVO agtBrogCustIntVO) {
    	this.agtBrogCustIntVO = agtBrogCustIntVO;
    }

	public AgtBrogCustIntVO[] getAgtBrogCustIntVOs() {
    	return agtBrogCustIntVOs;
    }

	public void setAgtBrogCustIntVOs(AgtBrogCustIntVO[] agtBrogCustIntVOs) {
    	this.agtBrogCustIntVOs = agtBrogCustIntVOs;
    }
	
	

}

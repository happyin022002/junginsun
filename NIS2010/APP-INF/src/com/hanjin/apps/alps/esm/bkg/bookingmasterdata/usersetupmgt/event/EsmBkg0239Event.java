/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0239Event.java
*@FileTitle : RDN Issuance by Regional Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.05.19 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.CustChkPntAttachVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0426 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0426HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung Jun Lee
 * @see ESM_BKG_0426HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0239Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	
	private CustChkPntAttachVO custChkPntAttachVO = null;
	public CustChkPntAttachVO[] custChkPntAttachVOs = null;
	public String[] keys = null;
	
	public EsmBkg0239Event(){}

	/* set */

	public void setCustChkPntAttachVO(CustChkPntAttachVO custChkPntAttachVO) {
		this.custChkPntAttachVO = custChkPntAttachVO;
	}
	public void setCustChkPntAttachVOS(CustChkPntAttachVO[] custChkPntAttachVOs) {
		this.custChkPntAttachVOs = custChkPntAttachVOs;
	}

	public void setKeys(String[] keys) {
		this.keys = keys;
	}
	
	/* get */

	public CustChkPntAttachVO getCustChkPntAttachVO() {
		return this.custChkPntAttachVO;
	}	
	public CustChkPntAttachVO[] getCustChkPntAttachVOS() {
		return this.custChkPntAttachVOs;
	}	
	public String[] getKeys() {
		return this.keys;
	}
	
}
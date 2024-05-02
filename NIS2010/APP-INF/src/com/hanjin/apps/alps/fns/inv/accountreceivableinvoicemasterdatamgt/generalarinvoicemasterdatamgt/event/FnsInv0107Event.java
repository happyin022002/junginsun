/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0107Event.java
*@FileTitle : Office Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.10.14 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.MdmOfcInPutVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0107 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0107HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Woo-Seok
 * @see FNS_INV_0107HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0107Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmOfcInPutVO mdmOfcInPutVO = null;
	
	public MdmOfcInPutVO getMdmOfcInPutVO(){
		return mdmOfcInPutVO;
	}

	public void setMdmOfcInPutVO(MdmOfcInPutVO mdmOfcInPutVO) {
		this.mdmOfcInPutVO = mdmOfcInPutVO;
	}
}
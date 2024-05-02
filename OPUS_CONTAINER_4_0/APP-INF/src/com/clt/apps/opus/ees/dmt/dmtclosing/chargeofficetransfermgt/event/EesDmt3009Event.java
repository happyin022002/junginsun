/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt3009Event.java
*@FileTitle : Office Transfer History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.07.14 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.event;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.vo.OfficeTransferParmVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_3009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_3009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang HyoKeun
 * @see EES_DMT_3009HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt3009Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OfficeTransferParmVO officeTransferParmVO = null;
	

	public EesDmt3009Event(){}
	
	public void setOfficeTransferParmVO(OfficeTransferParmVO officeTransferParmVO){
		this. officeTransferParmVO = officeTransferParmVO;
	}

	public OfficeTransferParmVO getOfficeTransferParmVO(){
		return officeTransferParmVO;
	}

}
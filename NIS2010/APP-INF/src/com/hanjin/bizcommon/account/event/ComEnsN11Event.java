/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ComEnsN11Event.java
*@FileTitle : Account Code
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.20
*@LastModifier : 김석준
*@LastVersion : 1.0
* 2009.04.20 김석준
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.account.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmAccountVO;


/**
 * COM_ENS_N11 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  COM_ENS_N11HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Suk Jun Kim
 * @see COM_ENS_N11HTMLAction 참조
 * @since J2EE 1.4
 */

public class ComEnsN11Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmAccountVO mdmaccountvo = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmAccountVO[] mdmaccountvos = null;

	public ComEnsN11Event(){}
	
	public void setMdmAccountVO(MdmAccountVO mdmaccountvo){
		this. mdmaccountvo = mdmaccountvo;
	}

	public void setMdmAccountVOS(MdmAccountVO[] mdmaccountvos){
		this. mdmaccountvos = mdmaccountvos;
	}

	public MdmAccountVO getMdmAccountVO(){
		return mdmaccountvo;
	}

	public MdmAccountVO[] getMdmAccountVOS(){
		return mdmaccountvos;
	}

}
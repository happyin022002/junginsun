/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmSam0100Event.java
*@FileTitle : Sales Activity Item
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.11
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2011.05.11 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.vo.SearchActItemMstVO;
import com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.vo.SamActTpMstVO;


/**
 * ESM_SAM_COM 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAM_COMHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author NAMKOONGJINHO
 * @see ESM_SAM_COMHTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSamComEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private String scrNo = null;
	
	public EsmSamComEvent(){}
	
	public void setScrNo(String scrNo){
		this. scrNo = scrNo;
	}

	public String getScrNo(){
		return scrNo;
	}

}
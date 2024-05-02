/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ComCsr0005Event.java
*@FileTitle : 계산서
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.07.09 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ApPayInvVO;


/**
 * COM_CSR_0005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  COM_CSR_0005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HAM DAE SUNG
 * @see COM_CSR_0005HTMLAction 참조
 * @since J2EE 1.6
 */

public class ComCsr0005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ApPayInvVO apPayInvVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ApPayInvVO[] apPayInvVOs = null;

	public ComCsr0005Event(){}
	
	public void setApPayInvVO(ApPayInvVO apPayInvVO){
		this. apPayInvVO = apPayInvVO;
	}

	public void setApPayInvVOS(ApPayInvVO[] apPayInvVOs){
		this. apPayInvVOs = apPayInvVOs;
	}

	public ApPayInvVO getApPayInvVO(){
		return apPayInvVO;
	}

	public ApPayInvVO[] getApPayInvVOS(){
		return apPayInvVOs;
	}

}
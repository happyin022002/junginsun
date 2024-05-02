/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ComCsr080Event.java
*@FileTitle : Terminal invoice CSR Creation -Preview
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.07.14 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ApPayInvVO;


/**
 * COM_CSR_080 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  COM_CSR_080HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HAM DAE SUNG
 * @see COM_CSR_0006HTMLAction 참조
 * @since J2EE 1.6
 */

public class ComCsr0006Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ApPayInvVO apPayInvVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ApPayInvVO[] apPayInvVOs = null;

	public ComCsr0006Event(){}
	
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
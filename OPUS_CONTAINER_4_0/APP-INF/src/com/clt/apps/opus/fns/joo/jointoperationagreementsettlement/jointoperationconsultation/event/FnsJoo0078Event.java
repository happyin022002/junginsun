/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0078Event.java
*@FileTitle : CSR Invoice Interface Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.17
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.12.17 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CsrVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0078 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0078HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Hee Dong
 * @see FNS_JOO_0078HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0078Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CsrVO csrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CsrVO[] csrVOs = null;

	public FnsJoo0078Event(){}
	
	public void setCsrVO(CsrVO csrVO){
		this. csrVO = csrVO;
	}

	public void setCsrVOS(CsrVO[] csrVOs){
		if (csrVOs != null) {
			CsrVO[] tmpVOs = new CsrVO[csrVOs.length];
			System.arraycopy(csrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.csrVOs = tmpVOs;
		}
	}

	public CsrVO getCsrVO(){
		return csrVO;
	}

	public CsrVO[] getCsrVOS(){
		CsrVO[] tmpVOs = null;
		if (this.csrVOs != null) {
			tmpVOs = new CsrVO[csrVOs.length];
			System.arraycopy(csrVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}
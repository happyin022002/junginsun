/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0068Event.java
*@FileTitle : CSR Inquiry Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.08.12 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CsrVO;


/**
 * FNS_JOO_0068 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0068HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Hee Dong
 * @see FNS_JOO_0068HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0068Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CsrVO csrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CsrVO[] csrVOs = null;

	public FnsJoo0068Event(){}
	
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
		CsrVO[] rtnVOs = null;
		if (this.csrVOs != null) {
			rtnVOs = new CsrVO[csrVOs.length];
			System.arraycopy(csrVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0032Event.java
*@FileTitle : Estimate Report - Account
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.08 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.event;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.ActRsltRVO;
import com.hanjin.framework.support.layer.event.EventSupport; 


/**
 * fns_joo_0032 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  fns_joo_0032HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HAM DAE SUNG
 * @see fns_joo_0032HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0032Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ActRsltRVO actRsltRVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ActRsltRVO[] actRsltRVOs = null;

	public FnsJoo0032Event(){}
	
	public void setActRsltRVO(ActRsltRVO actRsltRVO){
		this. actRsltRVO = actRsltRVO;
	}

	public void setActRsltRVOS(ActRsltRVO[] actRsltRVOs){
		if (actRsltRVOs != null) {
			ActRsltRVO[] tmpVOs = new ActRsltRVO[actRsltRVOs.length];
			System.arraycopy(actRsltRVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.actRsltRVOs = tmpVOs;
		}		
	}

	public ActRsltRVO getActRsltRVO(){
		return actRsltRVO;
	}

	public ActRsltRVO[] getActRsltRVOS(){
		ActRsltRVO[] rtnVOs = null;
		if (this.actRsltRVOs != null) {
			rtnVOs = new ActRsltRVO[actRsltRVOs.length];
			System.arraycopy(actRsltRVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;						
	}
}
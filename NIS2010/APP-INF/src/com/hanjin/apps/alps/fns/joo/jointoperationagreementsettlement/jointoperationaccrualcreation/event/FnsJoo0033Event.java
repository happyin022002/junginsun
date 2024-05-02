/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0033Event.java
*@FileTitle :  추정 관련 Report의 유형 중  MAS (관리회계)용 자료를 보여주는 화면이다.
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.17 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.event;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.ActRsltRVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0033 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0033HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HAM DAE SUNG
 * @see FNS_JOO_0033HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0033Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ActRsltRVO actRsltRVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ActRsltRVO[] actRsltRVOs = null;

	public FnsJoo0033Event(){}
	
	public void setActRsltRVO(ActRsltRVO actRsltRVO){
		this. actRsltRVO = actRsltRVO;
	}

	public void setEstmActRsltVOS(ActRsltRVO[] estmActRsltVOs){
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
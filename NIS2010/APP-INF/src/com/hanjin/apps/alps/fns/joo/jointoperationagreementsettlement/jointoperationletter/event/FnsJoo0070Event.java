/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0070Event.java
*@FileTitle : FNS_JOO_0070
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.15 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.event;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.InvMcsLetterVO;
import com.hanjin.framework.support.layer.event.EventSupport;

  
/**
 * FNS_JOO_0070 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0070HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HAM DAE SUNG
 * @see FNS_JOO_0070HTMLAction 참조
 * @since J2EE 1.6
 */ 
 
public class FnsJoo0070Event extends EventSupport {
 
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvMcsLetterVO letterVO = null;
	 
	/** Table Value Object Multi Data 처리 */
	private InvMcsLetterVO[] letterVOs = null;
	
	public FnsJoo0070Event(){}
	
	public void setLetterVO(InvMcsLetterVO LetterVO){
		this. letterVO = LetterVO;
	}

	public void setLetterVOS(InvMcsLetterVO[] LetterVOs){
		if (letterVOs != null) {
			InvMcsLetterVO[] tmpVOs = new InvMcsLetterVO[letterVOs.length];
			System.arraycopy(letterVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.letterVOs = tmpVOs;
		}				
	}

	public InvMcsLetterVO getLetterVO(){
		return letterVO;
	}

	public InvMcsLetterVO[] getLetterVOS(){
		InvMcsLetterVO[] rtnVOs = null;
		if (this.letterVOs != null) {
			rtnVOs = new InvMcsLetterVO[letterVOs.length];
			System.arraycopy(letterVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}
 

}
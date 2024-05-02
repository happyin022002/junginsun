/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopJoo0075Event.java
*@FileTitle : Bank detail & Signature
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.09.29 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.LetterVO;


/**
 * FNS_JOO_0075 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0075HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0075HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0075Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private LetterVO letterVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private LetterVO[] letterVOs = null;

	public FnsJoo0075Event(){}
	
	public void setLetterVO(LetterVO letterVO){
		this. letterVO = letterVO;
	}

	public void setLetterVOS(LetterVO[] letterVOs){
		if (letterVOs != null) {
			LetterVO[] tmpVOs = new LetterVO[letterVOs.length];
			System.arraycopy(letterVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.letterVOs = tmpVOs;
		}		
	}

	public LetterVO getLetterVO(){
		return letterVO;
	}

	public LetterVO[] getLetterVOS(){
		LetterVO[] rtnVOs = null;
		if (this.letterVOs != null) {
			rtnVOs = new LetterVO[letterVOs.length];
			System.arraycopy(letterVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

}
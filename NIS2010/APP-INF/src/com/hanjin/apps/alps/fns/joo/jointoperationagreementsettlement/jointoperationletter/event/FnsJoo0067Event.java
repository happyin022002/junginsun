/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0067Event.java
*@FileTitle : Inquiry of JO Member Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.22 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.event;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.CustMemberVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.JooCntcMbrVO;


/**
 * FNS_JOO_0067 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0067HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HAM DAE SUNG
 * @see FNS_JOO_0067HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0067Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private JooCntcMbrVO jooCntcMbrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private JooCntcMbrVO[] jooCntcMbrVOs = null;
	
	private CustMemberVO custMemberVO = null;
	
	private CustMemberVO[] custMemberVOs = null;

	public FnsJoo0067Event(){}
	
	public void setJooCntcMbrVO(JooCntcMbrVO jooCntcMbrVO){
		this. jooCntcMbrVO = jooCntcMbrVO;
	}

	public void setJooCntcMbrVOS(JooCntcMbrVO[] jooCntcMbrVOs){
		if (jooCntcMbrVOs != null) {
			JooCntcMbrVO[] tmpVOs = new JooCntcMbrVO[jooCntcMbrVOs.length];
			System.arraycopy(jooCntcMbrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.jooCntcMbrVOs = tmpVOs;
		}		
	}

	public JooCntcMbrVO getJooCntcMbrVO(){
		return jooCntcMbrVO;
	}

	public JooCntcMbrVO[] getJooCntcMbrVOS(){
		JooCntcMbrVO[] rtnVOs = null;
		if (this.jooCntcMbrVOs != null) {
			rtnVOs = new JooCntcMbrVO[jooCntcMbrVOs.length];
			System.arraycopy(jooCntcMbrVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
		
	}
	public CustMemberVO getCustMemberVO() {
		return custMemberVO;
	}

	public void setCustMemberVO(CustMemberVO custMemberVO) {
		this.custMemberVO = custMemberVO;
	}
	
	public CustMemberVO[] getCustMemberVOs() {
		CustMemberVO[] rtnVOs = null;
		if (this.custMemberVOs != null) {
			rtnVOs = new CustMemberVO[custMemberVOs.length];
			System.arraycopy(custMemberVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
		
	}

	public void setCustMemberVOS(CustMemberVO[] custMemberVOs) {
		if (custMemberVOs != null) {
			CustMemberVO[] tmpVOs = new CustMemberVO[custMemberVOs.length];
			System.arraycopy(custMemberVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.custMemberVOs = tmpVOs;
		}		
	}
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0073Event.java
*@FileTitle : MCS & Invoice Mail Address Select POP-UP
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.11 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.JooCntcMbrVO;


/**
 * FNS_JOO_0073 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0073HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HAM DAE SUNG
 * @see FNS_JOO_0073HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0073Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private JooCntcMbrVO jooCntcMbrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private JooCntcMbrVO[] jooCntcMbrVOs = null;

	public FnsJoo0073Event(){}
	
	private String joCrrCd = null;
	
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

	/**
	 * @return the joCrrCd
	 */
	public String getJoCrrCd() {
		return joCrrCd;
	}

	/**
	 * @param joCrrCd the joCrrCd to set
	 */
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
	}

}
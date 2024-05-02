/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0099Event.java
*@FileTitle : GW Contract Link
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.08
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2014.12.08 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.AgmtDocVO;


/**
 * FNS_JOO_0099 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0099HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Ho Min
 * @see FNS_JOO_0099HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0099Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgmtDocVO agmtDocVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AgmtDocVO[] agmtDocVOs = null;
	
	private String csrNo = "";
		
	public FnsJoo0099Event(){}
	
	public void setAgmtDocVO(AgmtDocVO agmtDocVO){
		this.agmtDocVO = agmtDocVO;
	}

	public void setAgmtDocVOS(AgmtDocVO[] agmtDocVOs){		
		if (agmtDocVOs != null) {
			AgmtDocVO[] tmpVOs = new AgmtDocVO[agmtDocVOs.length];
			System.arraycopy(agmtDocVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.agmtDocVOs = tmpVOs;
		}
		
	}

	public AgmtDocVO getAgmtDocVO(){
		return agmtDocVO;		
	}

	public AgmtDocVO[] getAgmtDocVOS(){
		AgmtDocVO[] rtnVOs = null;
		if (this.agmtDocVOs != null) {
			rtnVOs = new AgmtDocVO[agmtDocVOs.length];
			System.arraycopy(agmtDocVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;	
	}
	
	public String getCsrNo() {
		return csrNo;
	}

	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}	
}
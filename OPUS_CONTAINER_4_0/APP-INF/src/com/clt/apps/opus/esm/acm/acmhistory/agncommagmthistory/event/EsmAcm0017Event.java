/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0017Event.java
*@FileTitle : Agent Commission Agreement History (master)
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.15
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.15 김영오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmhistory.agncommagmthistory.event;

import com.clt.apps.opus.esm.acm.acmhistory.agncommagmthistory.vo.AgncommagmtDetailHistoryVO;
import com.clt.apps.opus.esm.acm.acmhistory.agncommagmthistory.vo.AgncommagmtMasterHistoryVO;
import com.clt.apps.opus.esm.acm.acmhistory.agncommagmthistory.vo.AgncommagmthistoryVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Young-Oh
 * @see ESM_ACM_0017HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0017Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	//Agreement List
	private AgncommagmthistoryVO agncommagmthistoryVO = null;

	//Master History
	private AgncommagmtMasterHistoryVO agncommagmtMasterHistoryVO = null;

	//Detail(Compensation) History
	private AgncommagmtDetailHistoryVO agncommagmtDetailHistoryVO = null;

	public EsmAcm0017Event() {}

	public AgncommagmthistoryVO getAgncommagmthistoryVO() {
		return agncommagmthistoryVO;
	}

	public void setAgncommagmthistoryVO(AgncommagmthistoryVO agncommagmthistoryVO) {
		this.agncommagmthistoryVO = agncommagmthistoryVO;
	}

	public AgncommagmtMasterHistoryVO getAgncommagmtMasterHistoryVO() {
		return agncommagmtMasterHistoryVO;
	}

	public void setAgncommagmtMasterHistoryVO(
			AgncommagmtMasterHistoryVO agncommagmtMasterHistoryVO) {
		this.agncommagmtMasterHistoryVO = agncommagmtMasterHistoryVO;
	}

	public AgncommagmtDetailHistoryVO getAgncommagmtDetailHistoryVO() {
		return agncommagmtDetailHistoryVO;
	}

	public void setAgncommagmtDetailHistoryVO(
			AgncommagmtDetailHistoryVO agncommagmtDetailHistoryVO) {
		this.agncommagmtDetailHistoryVO = agncommagmtDetailHistoryVO;
	}


}
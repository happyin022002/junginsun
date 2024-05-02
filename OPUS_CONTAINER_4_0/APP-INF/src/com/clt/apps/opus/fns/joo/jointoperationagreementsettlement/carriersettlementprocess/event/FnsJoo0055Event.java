/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0055Event.java
*@FileTitle :  RDR Upload Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : jang chang su
*@LastVersion : 1.0
* 2009.09.03 jang chang su
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.RdrByLaneVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0055 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0055HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang chang su
 * @see FNS_JOO_0055HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0055Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RdrByLaneVO rdrByLaneVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RdrByLaneVO[] rdrByLaneVOs = null;

	public FnsJoo0055Event(){}
	
	public void setRdrByLaneVO(RdrByLaneVO rdrByLaneVO){
		this. rdrByLaneVO = rdrByLaneVO;
	}

	public void setRdrByLaneVOS(RdrByLaneVO[] rdrByLaneVOs){
		if (rdrByLaneVOs != null) {
			RdrByLaneVO[] tmpVOs = new RdrByLaneVO[rdrByLaneVOs.length];
			System.arraycopy(rdrByLaneVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rdrByLaneVOs = tmpVOs;
		}
	}

	public RdrByLaneVO getRdrByLaneVO(){
		return rdrByLaneVO;
	}

	public RdrByLaneVO[] getRdrByLaneVOS(){
		RdrByLaneVO[] tmpVOs = null;
		if (this.rdrByLaneVOs != null) {
			tmpVOs = new RdrByLaneVO[rdrByLaneVOs.length];
			System.arraycopy(rdrByLaneVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}
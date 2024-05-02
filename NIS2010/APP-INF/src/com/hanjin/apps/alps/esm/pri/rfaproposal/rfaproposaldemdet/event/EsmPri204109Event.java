/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri204109Event.java
*@FileTitle : RFA Proposal Creation [Amend] (DEM&DET)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.24 공백진
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposaldemdet.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpDmdtVO;


/**
 * ESM_PRI_2041_09 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2041_09HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_2041_09HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri204109Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpDmdtVO priRpDmdtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpDmdtVO[] priRpDmdtVOs = null;

	public EsmPri204109Event(){}
	
	public void setPriRpDmdtVO(PriRpDmdtVO priRpDmdtVO){
		this. priRpDmdtVO = priRpDmdtVO;
	}

	public void setPriRpDmdtVOS(PriRpDmdtVO[] priRpDmdtVOs){
		if(priRpDmdtVOs != null){
			PriRpDmdtVO[] tmpVOs = new PriRpDmdtVO[priRpDmdtVOs.length];
			System.arraycopy(priRpDmdtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpDmdtVOs = tmpVOs;
		}
	}

	public PriRpDmdtVO getPriRpDmdtVO(){
		return priRpDmdtVO;
	}

	public PriRpDmdtVO[] getPriRpDmdtVOS(){
		PriRpDmdtVO[] rtnVOs = null;
		if (this.priRpDmdtVOs != null) {
			rtnVOs = new PriRpDmdtVO[priRpDmdtVOs.length];
			System.arraycopy(priRpDmdtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}
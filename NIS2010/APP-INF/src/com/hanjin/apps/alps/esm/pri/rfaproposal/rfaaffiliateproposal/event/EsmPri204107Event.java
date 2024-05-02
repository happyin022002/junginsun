/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri204107Event.java
*@FileTitle : Proposal Affiliate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.06.02 공백진
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaaffiliateproposal.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpAfilVO;


/**
 * ESM_PRI_2041_07 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2041_07HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kong Back Jin
 * @see ESM_PRI_2041_07HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri204107Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpAfilVO priRpAfilVO = null;
	/** Table Value Object Multi Data 처리 */
	private PriRpAfilVO[] priRpAfilVOs = null;

	public PriRpAfilVO getPriRpAfilVO() {
		return priRpAfilVO;
	}

	public void setPriRpAfilVO(PriRpAfilVO priRpAfilVO) {
		this.priRpAfilVO = priRpAfilVO;
	}

	public PriRpAfilVO[] getPriRpAfilVOs() {
		PriRpAfilVO[] rtnVOs = null;
		if (this.priRpAfilVOs != null) {
			rtnVOs = new PriRpAfilVO[priRpAfilVOs.length];
			System.arraycopy(priRpAfilVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setPriRpAfilVOs(PriRpAfilVO[] priRpAfilVOs){
		if(priRpAfilVOs != null){
			PriRpAfilVO[] tmpVOs = new PriRpAfilVO[priRpAfilVOs.length];
			System.arraycopy(priRpAfilVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpAfilVOs = tmpVOs;
		}
	}

	public EsmPri204107Event(){}
	


}
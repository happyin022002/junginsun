/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri2082Event.java
 *@FileTitle : RFA Proposal Creation - Rate (Actual Customer)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.21
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.08.21 박성수
 * 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event.ESM_PRI_0070HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpScpRtActCustVO;

/**
 * UI_PRI_0070 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0070HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_0070HTMLAction 참조
 * @since J2EE 1.4
 */
 
public class EsmPri2082Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriRpScpRtActCustVO[] priRpScpRtActCustVOS = null;
	
	private PriRpScpRtActCustVO priRpScpRtActCustVO = null;

	/** FIC_RT_TP_CD */
	private String ficRtTpCd;

	public EsmPri2082Event() {
	}

	/**
	 * @return the priRpScpRtActCustVOS
	 */
	public PriRpScpRtActCustVO[] getPriRpScpRtActCustVOS() {
		PriRpScpRtActCustVO[] rtnVOs = null;
		if (this.priRpScpRtActCustVOS != null) {
			rtnVOs = new PriRpScpRtActCustVO[priRpScpRtActCustVOS.length];
			System.arraycopy(priRpScpRtActCustVOS, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param priRpScpRtActCustVOS the priRpScpRtActCustVOS to set
	 */
	public void setPriRpScpRtActCustVOS(PriRpScpRtActCustVO[] priRpScpRtActCustVOS){
		if(priRpScpRtActCustVOS != null){
			PriRpScpRtActCustVO[] tmpVOs = new PriRpScpRtActCustVO[priRpScpRtActCustVOS.length];
			System.arraycopy(priRpScpRtActCustVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpRtActCustVOS = tmpVOs;
		}
	}

	public String getFicRtTpCd() {
		return ficRtTpCd;
	}

	public void setFicRtTpCd(String ficRtTpCd) {
		this.ficRtTpCd = ficRtTpCd;
	}

	public PriRpScpRtActCustVO getPriRpScpRtActCustVO() {
		return priRpScpRtActCustVO;
	}

	public void setPriRpScpRtActCustVO(PriRpScpRtActCustVO priRpScpRtActCustVO) {
		this.priRpScpRtActCustVO = priRpScpRtActCustVO;
	}
	
}
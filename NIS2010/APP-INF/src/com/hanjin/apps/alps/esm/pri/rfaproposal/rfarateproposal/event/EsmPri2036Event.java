/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri2036Event.java
 *@FileTitle : RFA Proposal Creation - Summary
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.21
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.08.21 박성수
 * 1.0 Creation
 * =========================================================
 * History
 * 2015.10.28 SELCMU/김현경 [CHM-201538236] RFA module 승인 절차 간소화 및 기능 개선
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RfaSummryAcceptAllVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriRpScpRtVO;

/**
 * UI_PRI_0093 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0093HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_2036HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri2036Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO = null;
	private PriRpScpRtVO priRpScpRtVO = null;
	private RfaSummryAcceptAllVO rfaSummryAcceptAllVO = null;

	public EsmPri2036Event() {
	}

	/**
	 * @return the priRpScpRtCmdtHdrVO
	 */
	public PriRpScpRtCmdtHdrVO getPriRpScpRtCmdtHdrVO() {
		return priRpScpRtCmdtHdrVO;
	}

	/**
	 * @param priRpScpRtCmdtHdrVO the priRpScpRtCmdtHdrVO to set
	 */
	public void setPriRpScpRtCmdtHdrVO(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) {
		this.priRpScpRtCmdtHdrVO = priRpScpRtCmdtHdrVO;
	}

	/**
	 * @return the priRpScpRtVO
	 */
	public PriRpScpRtVO getPriRpScpRtVO() {
		return priRpScpRtVO;
	}

	/**
	 * @param priRpScpRtVO the priRpScpRtVO to set
	 */
	public void setPriRpScpRtVO(PriRpScpRtVO priRpScpRtVO) {
		this.priRpScpRtVO = priRpScpRtVO;
	}

	/**
	 * @return the rfaSummryAcceptAllVO
	 */
	public RfaSummryAcceptAllVO getRfaSummryAcceptAllVO() {
		return rfaSummryAcceptAllVO;
	}

	/**
	 * @param rfaSummryAcceptAllVO the rfaSummryAcceptAllVO to set
	 */
	public void setRfaSummryAcceptAllVO(RfaSummryAcceptAllVO rfaSummryAcceptAllVO) {
		this.rfaSummryAcceptAllVO = rfaSummryAcceptAllVO;
	}

}
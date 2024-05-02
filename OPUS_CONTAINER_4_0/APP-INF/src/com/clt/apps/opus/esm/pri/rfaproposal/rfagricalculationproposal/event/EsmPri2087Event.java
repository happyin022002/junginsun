/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri2087Event.java
 *@FileTitle : GRI Calculation Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.23
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.09.23 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfagricalculationproposal.event;

import com.clt.apps.opus.esm.pri.rfaproposal.rfagricalculationproposal.vo.RfaGriCalcVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagricalculationproposal.vo.RsltGriCalcListVO;
import com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.event.ESM_PRI_0066HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriRpScpGriGrpVO;

/**
 * UI_PRI_0066 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0066HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_0066HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri2087Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriRpScpGriGrpVO priRpScpGriGrpVO = null;
	private RsltGriCalcListVO rsltGriCalcListVO = null;
	private RfaGriCalcVO rfaGriCalcVO = null;

	public EsmPri2087Event() {
	}

	/**
	 * @return the priRpScpGriGrpVO
	 */
	public PriRpScpGriGrpVO getPriRpScpGriGrpVO() {
		return priRpScpGriGrpVO;
	}

	/**
	 * @param priRpScpGriGrpVO the priRpScpGriGrpVO to set
	 */
	public void setPriRpScpGriGrpVO(PriRpScpGriGrpVO priRpScpGriGrpVO) {
		this.priRpScpGriGrpVO = priRpScpGriGrpVO;
	}

	/**
	 * @return the rsltGriCalcListVO
	 */
	public RsltGriCalcListVO getRsltGriCalcListVO() {
		return rsltGriCalcListVO;
	}

	/**
	 * @param rsltGriCalcListVO the rsltGriCalcListVO to set
	 */
	public void setRsltGriCalcListVO(RsltGriCalcListVO rsltGriCalcListVO) {
		this.rsltGriCalcListVO = rsltGriCalcListVO;
	}

	/**
	 * @return the rfaGriCalcVO
	 */
	public RfaGriCalcVO getRfaGriCalcVO() {
		return rfaGriCalcVO;
	}

	/**
	 * @param rfaGriCalcVO the rfaGriCalcVO to set
	 */
	public void setRfaGriCalcVO(RfaGriCalcVO rfaGriCalcVO) {
		this.rfaGriCalcVO = rfaGriCalcVO;
	}

}
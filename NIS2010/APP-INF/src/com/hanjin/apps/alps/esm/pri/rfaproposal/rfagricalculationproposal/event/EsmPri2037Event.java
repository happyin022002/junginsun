/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : EsmPri2037Event.java
 *@FileTitle : GRI Calculation - Rate For Add-on Tariff
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.10.19
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfagricalculationproposal.event;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagricalculationproposal.vo.RfaGriCalcVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagricalculationproposal.vo.RsltGriCalcListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.CheckGRICalculationValidationVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpScpGriGrpVO;

/**
 * UI_PRI_0066 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0066HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Eunsup, Lee
 * @see ESM_PRI_2037HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri2037Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriRpScpGriGrpVO priRpScpGriGrpVO = null;
	private RsltGriCalcListVO rsltGriCalcListVO = null;
	private CheckGRICalculationValidationVO[] checkGRICalculationValidationVOs = null;
	private RfaGriCalcVO rfaGriCalcVO = null;

	/** FIC_RT_TP_CD */
	private String ficRtTpCd;

	public EsmPri2037Event() {
	}

	public String getFicRtTpCd() {
		return ficRtTpCd;
	}

	public void setFicRtTpCd(String ficRtTpCd) {
		this.ficRtTpCd = ficRtTpCd;
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

	public CheckGRICalculationValidationVO[] getCheckGRICalculationValidationVOs() {
		CheckGRICalculationValidationVO[] rtnVOs = null;
		if (this.checkGRICalculationValidationVOs != null) {
			rtnVOs = new CheckGRICalculationValidationVO[checkGRICalculationValidationVOs.length];
			System.arraycopy(checkGRICalculationValidationVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setCheckGRICalculationValidationVOs(CheckGRICalculationValidationVO[] checkGRICalculationValidationVOs){
		if(checkGRICalculationValidationVOs != null){
			CheckGRICalculationValidationVO[] tmpVOs = new CheckGRICalculationValidationVO[checkGRICalculationValidationVOs.length];
			System.arraycopy(checkGRICalculationValidationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.checkGRICalculationValidationVOs = tmpVOs;
		}
	}

}
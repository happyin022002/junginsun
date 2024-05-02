/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : EsmPri2069Event.java
 *@FileTitle : RFA Proposal & Amendment Creation - Rate Tab Load Excel : Add-On Tariff Management)  (V Type)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.09.21
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2012.09.21
 * 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.FicRateLoadExcelGuidelineCheckVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListVerticalExcelForAddOnTariffVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;

/**
 * UI_PRI_0029 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0029HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Eun-Sup, Lee
 * @see ESM_PRI_2069HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri2069Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO = null;
	private RsltRtListVerticalExcelForAddOnTariffVO[] rsltRtListVerticalExcelForAddOnTariffVOs = null;
	private FicRateLoadExcelGuidelineCheckVO[] ficRateLoadExcelGuidelineCheckVOs = null;
	private FicRateLoadExcelGuidelineCheckVO ficRateLoadExcelGuidelineCheckVO = null;

	/** FIC_RT_TP_CD */
	private String ficRtTpCd;

	private String inOrgDestTpCd;

	public EsmPri2069Event() {
	}

	public String getFicRtTpCd() {
		return ficRtTpCd;
	}

	public void setFicRtTpCd(String ficRtTpCd) {
		this.ficRtTpCd = ficRtTpCd;
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

	public RsltRtListVerticalExcelForAddOnTariffVO[] getRsltRtListVerticalExcelForAddOnTariffVOs() {
		RsltRtListVerticalExcelForAddOnTariffVO[] rtnVOs = null;
		if (this.rsltRtListVerticalExcelForAddOnTariffVOs != null) {
			rtnVOs = new RsltRtListVerticalExcelForAddOnTariffVO[rsltRtListVerticalExcelForAddOnTariffVOs.length];
			System.arraycopy(rsltRtListVerticalExcelForAddOnTariffVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setRsltRtListVerticalExcelForAddOnTariffVOs(RsltRtListVerticalExcelForAddOnTariffVO[] rsltRtListVerticalExcelForAddOnTariffVOs){
		if(rsltRtListVerticalExcelForAddOnTariffVOs != null){
			RsltRtListVerticalExcelForAddOnTariffVO[] tmpVOs = new RsltRtListVerticalExcelForAddOnTariffVO[rsltRtListVerticalExcelForAddOnTariffVOs.length];
			System.arraycopy(rsltRtListVerticalExcelForAddOnTariffVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltRtListVerticalExcelForAddOnTariffVOs = tmpVOs;
		}
	}

	public FicRateLoadExcelGuidelineCheckVO[] getFicRateLoadExcelGuidelineCheckVOs() {
		FicRateLoadExcelGuidelineCheckVO[] rtnVOs = null;
		if (this.ficRateLoadExcelGuidelineCheckVOs != null) {
			rtnVOs = new FicRateLoadExcelGuidelineCheckVO[ficRateLoadExcelGuidelineCheckVOs.length];
			System.arraycopy(ficRateLoadExcelGuidelineCheckVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setFicRateLoadExcelGuidelineCheckVOs(FicRateLoadExcelGuidelineCheckVO[] ficRateLoadExcelGuidelineCheckVOs){
		if(ficRateLoadExcelGuidelineCheckVOs != null){
			FicRateLoadExcelGuidelineCheckVO[] tmpVOs = new FicRateLoadExcelGuidelineCheckVO[ficRateLoadExcelGuidelineCheckVOs.length];
			System.arraycopy(ficRateLoadExcelGuidelineCheckVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.ficRateLoadExcelGuidelineCheckVOs = tmpVOs;
		}
	}

	public FicRateLoadExcelGuidelineCheckVO getFicRateLoadExcelGuidelineCheckVO() {
		return ficRateLoadExcelGuidelineCheckVO;
	}

	public void setFicRateLoadExcelGuidelineCheckVO(FicRateLoadExcelGuidelineCheckVO ficRateLoadExcelGuidelineCheckVO) {
		this.ficRateLoadExcelGuidelineCheckVO = ficRateLoadExcelGuidelineCheckVO;
	}

	public String getInOrgDestTpCd() {
		return inOrgDestTpCd;
	}

	public void setInOrgDestTpCd(String inOrgDestTpCd) {
		this.inOrgDestTpCd = inOrgDestTpCd;
	}
}
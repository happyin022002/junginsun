/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : EsmPri2070Event.java
 *@FileTitle : RFA Proposal & Amendment Creation - Rate Tab Load Excel : Add-On Tariff Management)  (H Type)
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

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListHorizontalExcelForAddOnTariffVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;

/**
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Eun-Sup, Lee
 * @see ESM_PRI_2070HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri2070Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO = null;
	private RsltRtListHorizontalExcelForAddOnTariffVO[] rsltRtListHorizontalExcelForAddOnTariffVOs = null;

	/** FIC_RT_TP_CD */
	private String ficRtTpCd;

	public EsmPri2070Event() {
	}

	public PriRpScpRtCmdtHdrVO getPriRpScpRtCmdtHdrVO() {
		return priRpScpRtCmdtHdrVO;
	}

	public void setPriRpScpRtCmdtHdrVO(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) {
		this.priRpScpRtCmdtHdrVO = priRpScpRtCmdtHdrVO;
	}

	public RsltRtListHorizontalExcelForAddOnTariffVO[] getRsltRtListHorizontalExcelForAddOnTariffVOs() {
		RsltRtListHorizontalExcelForAddOnTariffVO[] rtnVOs = null;
		if (this.rsltRtListHorizontalExcelForAddOnTariffVOs != null) {
			rtnVOs = new RsltRtListHorizontalExcelForAddOnTariffVO[rsltRtListHorizontalExcelForAddOnTariffVOs.length];
			System.arraycopy(rsltRtListHorizontalExcelForAddOnTariffVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setRsltRtListHorizontalExcelForAddOnTariffVOs(RsltRtListHorizontalExcelForAddOnTariffVO[] rsltRtListHorizontalExcelForAddOnTariffVOs){
		if(rsltRtListHorizontalExcelForAddOnTariffVOs != null){
			RsltRtListHorizontalExcelForAddOnTariffVO[] tmpVOs = new RsltRtListHorizontalExcelForAddOnTariffVO[rsltRtListHorizontalExcelForAddOnTariffVOs.length];
			System.arraycopy(rsltRtListHorizontalExcelForAddOnTariffVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltRtListHorizontalExcelForAddOnTariffVOs = tmpVOs;
		}
	}

	public String getFicRtTpCd() {
		return ficRtTpCd;
	}

	public void setFicRtTpCd(String ficRtTpCd) {
		this.ficRtTpCd = ficRtTpCd;
	}
}
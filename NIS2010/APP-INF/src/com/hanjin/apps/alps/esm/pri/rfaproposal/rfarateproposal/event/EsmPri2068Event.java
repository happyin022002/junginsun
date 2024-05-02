/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri2068Event.java
 *@FileTitle : RFA Proposal Creation - Rate [Load Excel] (H Type)
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

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListHorizontalLoadExcelForAeeAewVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;

/**
 * UI_PRI_0099 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0099HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_2068HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri2068Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO = null;
	private RsltRtListHorizontalLoadExcelForAeeAewVO[] rsltRtListHorizontalLoadExcelForAeeAewVOs = null;

	/** FIC_RT_TP_CD */
	private String ficRtTpCd;

	public EsmPri2068Event() {
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

	public RsltRtListHorizontalLoadExcelForAeeAewVO[] getRsltRtListHorizontalLoadExcelForAeeAewVOs() {
		RsltRtListHorizontalLoadExcelForAeeAewVO[] rtnVOs = null;
		if (this.rsltRtListHorizontalLoadExcelForAeeAewVOs != null) {
			rtnVOs = new RsltRtListHorizontalLoadExcelForAeeAewVO[rsltRtListHorizontalLoadExcelForAeeAewVOs.length];
			System.arraycopy(rsltRtListHorizontalLoadExcelForAeeAewVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setRsltRtListHorizontalLoadExcelForAeeAewVOs(RsltRtListHorizontalLoadExcelForAeeAewVO[] rsltRtListHorizontalLoadExcelForAeeAewVOs){
		if(rsltRtListHorizontalLoadExcelForAeeAewVOs != null){
			RsltRtListHorizontalLoadExcelForAeeAewVO[] tmpVOs = new RsltRtListHorizontalLoadExcelForAeeAewVO[rsltRtListHorizontalLoadExcelForAeeAewVOs.length];
			System.arraycopy(rsltRtListHorizontalLoadExcelForAeeAewVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltRtListHorizontalLoadExcelForAeeAewVOs = tmpVOs;
		}
	}

}
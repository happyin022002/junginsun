/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri2066Event.java
 *@FileTitle : EsmPri2066Event
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.27
 *@LastModifier : 문동규
 *@LastVersion : 1.0
 * 2009.08.27 문동규
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.event;

import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RsltRfaRtListHorizontalExcelVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriRgRtCmdtHdrVO;

/**
 * ESM_PRI_2066 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_2066HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Moon Dong Gyu
 * @see ESM_PRI_2066HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri2066Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriRgRtCmdtHdrVO priRgRtCmdtHdrVO = null;
	private RsltRfaRtListHorizontalExcelVO[] rsltRfaRtListHorizontalExcelVOS = null;

	public EsmPri2066Event() {
	}

	/**
	 * @return the rsltRfaRtListHorizontalExcelVOS
	 */
	public RsltRfaRtListHorizontalExcelVO[] getRsltRfaRtListHorizontalExcelVOS() {
		RsltRfaRtListHorizontalExcelVO[] tmpVOs = null;
		if (this.rsltRfaRtListHorizontalExcelVOS != null) {
			tmpVOs = new RsltRfaRtListHorizontalExcelVO[rsltRfaRtListHorizontalExcelVOS.length];
			System.arraycopy(rsltRfaRtListHorizontalExcelVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param rsltRfaRtListHorizontalExcelVOS the rsltRfaRtListHorizontalExcelVOS to set
	 */
	public void setRsltRfaRtListHorizontalExcelVOS(RsltRfaRtListHorizontalExcelVO[] rsltRfaRtListHorizontalExcelVOS) {
		if (rsltRfaRtListHorizontalExcelVOS != null) {
			RsltRfaRtListHorizontalExcelVO[] tmpVOs = new RsltRfaRtListHorizontalExcelVO[rsltRfaRtListHorizontalExcelVOS.length];
			System.arraycopy(rsltRfaRtListHorizontalExcelVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltRfaRtListHorizontalExcelVOS = tmpVOs;
		}
	}

    /**
     * @return the priRgRtCmdtHdrVO
     */
    public PriRgRtCmdtHdrVO getPriRgRtCmdtHdrVO () {
        return priRgRtCmdtHdrVO;
    }

    /**
     * @param priRgRtCmdtHdrVO the priRgRtCmdtHdrVO to set
     */
    public void setPriRgRtCmdtHdrVO (PriRgRtCmdtHdrVO priRgRtCmdtHdrVO) {
        this.priRgRtCmdtHdrVO = priRgRtCmdtHdrVO;
    }

}
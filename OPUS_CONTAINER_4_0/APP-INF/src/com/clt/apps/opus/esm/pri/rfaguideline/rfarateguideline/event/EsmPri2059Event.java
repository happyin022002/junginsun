/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri2059Event.java
 *@FileTitle : EsmPri2059Event
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.25
 *@LastModifier : 문동규
 *@LastVersion : 1.0
 * 2009.08.25 문동규
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.event;

import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RsltRfaRtListVerticalExcelVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriRgRtCmdtHdrVO;

/**
 * ESM_PRI_2059 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_2059HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Moon Dong Gyu
 * @see ESM_PRI_2059HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri2059Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriRgRtCmdtHdrVO priRgRtCmdtHdrVO = null;
	private RsltRfaRtListVerticalExcelVO[] rsltRfaRtListVerticalExcelVOS = null;

	public EsmPri2059Event() {
	}

	/**
	 * @return the rsltRfaRtListVerticalExcelVOS
	 */
	public RsltRfaRtListVerticalExcelVO[] getRsltRfaRtListVerticalExcelVOS() {
		RsltRfaRtListVerticalExcelVO[] tmpVOs = null;
		if (this.rsltRfaRtListVerticalExcelVOS != null) {
			tmpVOs = new RsltRfaRtListVerticalExcelVO[rsltRfaRtListVerticalExcelVOS.length];
			System.arraycopy(rsltRfaRtListVerticalExcelVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param rsltRfaRtListVerticalExcelVOS the rsltRfaRtListVerticalExcelVOS to set
	 */
	public void setRsltRfaRtListVerticalExcelVOS(RsltRfaRtListVerticalExcelVO[] rsltRfaRtListVerticalExcelVOS) {
		if (rsltRfaRtListVerticalExcelVOS != null) {
			RsltRfaRtListVerticalExcelVO[] tmpVOs = new RsltRfaRtListVerticalExcelVO[rsltRfaRtListVerticalExcelVOS.length];
			System.arraycopy(rsltRfaRtListVerticalExcelVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltRfaRtListVerticalExcelVOS = tmpVOs;
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
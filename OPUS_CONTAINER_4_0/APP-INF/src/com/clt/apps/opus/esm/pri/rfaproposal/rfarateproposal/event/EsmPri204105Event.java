/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri200307Event.java
 *@FileTitle : RFA Search - Amendment History - Rate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.21
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.09.21 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event;

import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RfaGlineCopyVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RfaRtPropCmdtVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RfaRtPropRtVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtCmdtListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriRpScpGriGrpVO;
import com.clt.syscommon.common.table.PriRpScpRtCmdtHdrVO;
import com.clt.syscommon.common.table.PriRpScpRtCmdtRoutVO;
import com.clt.syscommon.common.table.PriRpScpRtVO;

/**
 * UI_PRI_0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_2003_07HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri204105Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO = null;
	private PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO = null;
	private PriRpScpRtVO priRpScpRtVO = null;
	private PriRpScpRtCmdtHdrVO[] priRpScpRtCmdtHdrVOS = null;
	private PriRpScpRtCmdtRoutVO[] priRpScpRtCmdtRoutVOS = null;
	private PriRpScpRtVO[] priRpScpRtVOS = null;
	private PriRpScpGriGrpVO priRpScpGriGrpVO = null;

	private RsltRtCmdtListVO rsltRtCmdtListVO = null;
	private RsltRtListVO rsltRtListVO = null;

	private RfaRtPropCmdtVO rfaRtPropCmdtVO = null;
	private RfaRtPropRtVO rfaRtPropRtVO = null;
	private RfaGlineCopyVO rfaGlineCopyVO = null;

	public EsmPri204105Event() {
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
	 * @return the priRpScpRtCmdtRoutVO
	 */
	public PriRpScpRtCmdtRoutVO getPriRpScpRtCmdtRoutVO() {
		return priRpScpRtCmdtRoutVO;
	}

	/**
	 * @param priRpScpRtCmdtRoutVO the priRpScpRtCmdtRoutVO to set
	 */
	public void setPriRpScpRtCmdtRoutVO(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) {
		this.priRpScpRtCmdtRoutVO = priRpScpRtCmdtRoutVO;
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
	 * @return the priRpScpRtCmdtHdrVOS
	 */
	public PriRpScpRtCmdtHdrVO[] getPriRpScpRtCmdtHdrVOS() {
		PriRpScpRtCmdtHdrVO[] tmpVOs = null;
		if (this.priRpScpRtCmdtHdrVOS != null) {
			tmpVOs = new PriRpScpRtCmdtHdrVO[priRpScpRtCmdtHdrVOS.length];
			System.arraycopy(priRpScpRtCmdtHdrVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param priRpScpRtCmdtHdrVOS the priRpScpRtCmdtHdrVOS to set
	 */
	public void setPriRpScpRtCmdtHdrVOS(PriRpScpRtCmdtHdrVO[] priRpScpRtCmdtHdrVOS) {
		if (priRpScpRtCmdtHdrVOS != null) {
			PriRpScpRtCmdtHdrVO[] tmpVOs = new PriRpScpRtCmdtHdrVO[priRpScpRtCmdtHdrVOS.length];
			System.arraycopy(priRpScpRtCmdtHdrVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpRtCmdtHdrVOS = tmpVOs;
		}
	}

	/**
	 * @return the priRpScpRtCmdtRoutVOS
	 */
	public PriRpScpRtCmdtRoutVO[] getPriRpScpRtCmdtRoutVOS() {
		PriRpScpRtCmdtRoutVO[] tmpVOs = null;
		if (this.priRpScpRtCmdtRoutVOS != null) {
			tmpVOs = new PriRpScpRtCmdtRoutVO[priRpScpRtCmdtRoutVOS.length];
			System.arraycopy(priRpScpRtCmdtRoutVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param priRpScpRtCmdtRoutVOS the priRpScpRtCmdtRoutVOS to set
	 */
	public void setPriRpScpRtCmdtRoutVOS(PriRpScpRtCmdtRoutVO[] priRpScpRtCmdtRoutVOS) {
		if (priRpScpRtCmdtRoutVOS != null) {
			PriRpScpRtCmdtRoutVO[] tmpVOs = new PriRpScpRtCmdtRoutVO[priRpScpRtCmdtRoutVOS.length];
			System.arraycopy(priRpScpRtCmdtRoutVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpRtCmdtRoutVOS = tmpVOs;
		}
	}

	/**
	 * @return the priRpScpRtVOS
	 */
	public PriRpScpRtVO[] getPriRpScpRtVOS() {
		PriRpScpRtVO[] tmpVOs = null;
		if (this.priRpScpRtVOS != null) {
			tmpVOs = new PriRpScpRtVO[priRpScpRtVOS.length];
			System.arraycopy(priRpScpRtVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param priRpScpRtVOS the priRpScpRtVOS to set
	 */
	public void setPriRpScpRtVOS(PriRpScpRtVO[] priRpScpRtVOS) {
		if (priRpScpRtVOS != null) {
			PriRpScpRtVO[] tmpVOs = new PriRpScpRtVO[priRpScpRtVOS.length];
			System.arraycopy(priRpScpRtVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpRtVOS = tmpVOs;
		}
	}

	/**
	 * @return the rsltRtCmdtListVO
	 */
	public RsltRtCmdtListVO getRsltRtCmdtListVO() {
		return rsltRtCmdtListVO;
	}

	/**
	 * @param rsltRtCmdtListVO the rsltRtCmdtListVO to set
	 */
	public void setRsltRtCmdtListVO(RsltRtCmdtListVO rsltRtCmdtListVO) {
		this.rsltRtCmdtListVO = rsltRtCmdtListVO;
	}

	/**
	 * @return the rsltRtListVO
	 */
	public RsltRtListVO getRsltRtListVO() {
		return rsltRtListVO;
	}

	/**
	 * @param rsltRtListVO the rsltRtListVO to set
	 */
	public void setRsltRtListVO(RsltRtListVO rsltRtListVO) {
		this.rsltRtListVO = rsltRtListVO;
	}

	/**
	 * @return the rfaRtPropCmdtVO
	 */
	public RfaRtPropCmdtVO getRfaRtPropCmdtVO() {
		return rfaRtPropCmdtVO;
	}

	/**
	 * @param rfaRtPropCmdtVO the rfaRtPropCmdtVO to set
	 */
	public void setRfaRtPropCmdtVO(RfaRtPropCmdtVO rfaRtPropCmdtVO) {
		this.rfaRtPropCmdtVO = rfaRtPropCmdtVO;
	}

	/**
	 * @return the rfaRtPropRtVO
	 */
	public RfaRtPropRtVO getRfaRtPropRtVO() {
		return rfaRtPropRtVO;
	}

	/**
	 * @param rfaRtPropRtVO the rfaRtPropRtVO to set
	 */
	public void setRfaRtPropRtVO(RfaRtPropRtVO rfaRtPropRtVO) {
		this.rfaRtPropRtVO = rfaRtPropRtVO;
	}

	/**
	 * @return the rfaGlineCopyVO
	 */
	public RfaGlineCopyVO getRfaGlineCopyVO() {
		return rfaGlineCopyVO;
	}

	/**
	 * @param rfaGlineCopyVO the rfaGlineCopyVO to set
	 */
	public void setRfaGlineCopyVO(RfaGlineCopyVO rfaGlineCopyVO) {
		this.rfaGlineCopyVO = rfaGlineCopyVO;
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

}
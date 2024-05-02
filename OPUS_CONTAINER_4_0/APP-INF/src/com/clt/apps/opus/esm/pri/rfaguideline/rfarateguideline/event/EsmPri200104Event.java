/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri200104Event.java
 *@FileTitle : RFA Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.06
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.08.06 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.event;


import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RfaRtGlineCmdtVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RfaRtGlineRoutVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RsltRtCmdtListVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RsltRtListVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RsltRtRoutListVO;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.event.ESM_PRI_0030HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriRgRtCmdtHdrVO;
import com.clt.syscommon.common.table.PriRgRtCmdtRoutVO;
import com.clt.syscommon.common.table.PriRgRtVO;


/**
 * UI_PRI_2001_04 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_2001_04HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Moon Dong Gyu
 * @see ESM_PRI_0030HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri200104Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriRgRtCmdtHdrVO priRgRtCmdtHdrVO = null;
	private PriRgRtCmdtHdrVO[] priRgRtCmdtHdrVOS = null;
	private PriRgRtCmdtRoutVO priRgRtCmdtRoutVO = null;
	private PriRgRtCmdtRoutVO[] priRgRtCmdtRoutVOS = null;
	private PriRgRtVO priRgRtVO = null;
	private PriRgRtVO[] priRgRtVOS = null;
	private RsltRtCmdtListVO rsltRtCmdtListVO = null;
	private RsltRtCmdtListVO[] rsltRtCmdtListVOS = null;
	private RsltRtRoutListVO rsltRtRoutListVO = null;
	private RsltRtRoutListVO[] rsltRtRoutListVOS = null;
	private RsltRtListVO rsltRtListVO = null;
	private RsltRtListVO[] rsltRtListVOS = null;
	private RfaRtGlineCmdtVO rfaRtGlineCmdtVO = null;
	private RfaRtGlineRoutVO rfaRtGlineRoutVO = null;

	public EsmPri200104Event() {
	}

	/**
	 * @return the priRgRtCmdtHdrVO
	 */
	public PriRgRtCmdtHdrVO getPriRgRtCmdtHdrVO() {
		return priRgRtCmdtHdrVO;
	}

	/**
	 * @param priRgRtCmdtHdrVO the priRgRtCmdtHdrVO to set
	 */
	public void setPriRgRtCmdtHdrVO(PriRgRtCmdtHdrVO priRgRtCmdtHdrVO) {
		this.priRgRtCmdtHdrVO = priRgRtCmdtHdrVO;
	}

	/**
	 * @return the priRgRtCmdtHdrVOS
	 */
	public PriRgRtCmdtHdrVO[] getPriRgRtCmdtHdrVOS() {
		PriRgRtCmdtHdrVO[] tmpVOs = null;
		if (this.priRgRtCmdtHdrVOS != null) {
			tmpVOs = new PriRgRtCmdtHdrVO[priRgRtCmdtHdrVOS.length];
			System.arraycopy(priRgRtCmdtHdrVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param priRgRtCmdtHdrVOS the priRgRtCmdtHdrVOS to set
	 */
	public void setPriRgRtCmdtHdrVOS(PriRgRtCmdtHdrVO[] priRgRtCmdtHdrVOS) {
		if (priRgRtCmdtHdrVOS != null) {
			PriRgRtCmdtHdrVO[] tmpVOs = new PriRgRtCmdtHdrVO[priRgRtCmdtHdrVOS.length];
			System.arraycopy(priRgRtCmdtHdrVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.priRgRtCmdtHdrVOS = tmpVOs;
		}
	}

	/**
	 * @return the priRgRtCmdtRoutVO
	 */
	public PriRgRtCmdtRoutVO getPriRgRtCmdtRoutVO() {
		return priRgRtCmdtRoutVO;
	}

	/**
	 * @param priRgRtCmdtRoutVO the priRgRtCmdtRoutVO to set
	 */
	public void setPriRgRtCmdtRoutVO(PriRgRtCmdtRoutVO priRgRtCmdtRoutVO) {
		this.priRgRtCmdtRoutVO = priRgRtCmdtRoutVO;
	}

	/**
	 * @return the priRgRtCmdtRoutVOS
	 */
	public PriRgRtCmdtRoutVO[] getPriRgRtCmdtRoutVOS() {
		PriRgRtCmdtRoutVO[] tmpVOs = null;
		if (this.priRgRtCmdtRoutVOS != null) {
			tmpVOs = new PriRgRtCmdtRoutVO[priRgRtCmdtRoutVOS.length];
			System.arraycopy(priRgRtCmdtRoutVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param priRgRtCmdtRoutVOS the priRgRtCmdtRoutVOS to set
	 */
	public void setPriRgRtCmdtRoutVOS(PriRgRtCmdtRoutVO[] priRgRtCmdtRoutVOS) {
		if (priRgRtCmdtRoutVOS != null) {
			PriRgRtCmdtRoutVO[] tmpVOs = new PriRgRtCmdtRoutVO[priRgRtCmdtRoutVOS.length];
			System.arraycopy(priRgRtCmdtRoutVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.priRgRtCmdtRoutVOS = tmpVOs;
		}
	}

	/**
	 * @return the priRgRtVO
	 */
	public PriRgRtVO getPriRgRtVO() {
		return priRgRtVO;
	}

	/**
	 * @param priRgRtVO the priRgRtVO to set
	 */
	public void setPriRgRtVO(PriRgRtVO priRgRtVO) {
		this.priRgRtVO = priRgRtVO;
	}

	/**
	 * @return the priRgRtVOS
	 */
	public PriRgRtVO[] getPriRgRtVOS() {
		PriRgRtVO[] tmpVOs = null;
		if (this.priRgRtVOS != null) {
			tmpVOs = new PriRgRtVO[priRgRtVOS.length];
			System.arraycopy(priRgRtVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param priRgRtVOS the priRgRtVOS to set
	 */
	public void setPriRgRtVOS(PriRgRtVO[] priRgRtVOS) {
		if (priRgRtVOS != null) {
			PriRgRtVO[] tmpVOs = new PriRgRtVO[priRgRtVOS.length];
			System.arraycopy(priRgRtVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.priRgRtVOS = tmpVOs;
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
	 * @return the rsltRtCmdtListVOS
	 */
	public RsltRtCmdtListVO[] getRsltRtCmdtListVOS() {
		RsltRtCmdtListVO[] tmpVOs = null;
		if (this.rsltRtCmdtListVOS != null) {
			tmpVOs = new RsltRtCmdtListVO[rsltRtCmdtListVOS.length];
			System.arraycopy(rsltRtCmdtListVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param rsltRtCmdtListVOS the rsltRtCmdtListVOS to set
	 */
	public void setRsltRtCmdtListVOS(RsltRtCmdtListVO[] rsltRtCmdtListVOS) {
		if (rsltRtCmdtListVOS != null) {
			RsltRtCmdtListVO[] tmpVOs = new RsltRtCmdtListVO[rsltRtCmdtListVOS.length];
			System.arraycopy(rsltRtCmdtListVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltRtCmdtListVOS = tmpVOs;
		}
	}

	/**
	 * @return the rsltRtRoutListVO
	 */
	public RsltRtRoutListVO getRsltRtRoutListVO() {
		return rsltRtRoutListVO;
	}

	/**
	 * @param rsltRtRoutListVO the rsltRtRoutListVO to set
	 */
	public void setRsltRtRoutListVO(RsltRtRoutListVO rsltRtRoutListVO) {
		this.rsltRtRoutListVO = rsltRtRoutListVO;
	}

	/**
	 * @return the rsltRtRoutListVOS
	 */
	public RsltRtRoutListVO[] getRsltRtRoutListVOS() {
		RsltRtRoutListVO[] tmpVOs = null;
		if (this.rsltRtRoutListVOS != null) {
			tmpVOs = new RsltRtRoutListVO[rsltRtRoutListVOS.length];
			System.arraycopy(rsltRtRoutListVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param rsltRtRoutListVOS the rsltRtRoutListVOS to set
	 */
	public void setRsltRtRoutListVOS(RsltRtRoutListVO[] rsltRtRoutListVOS) {
		if (rsltRtRoutListVOS != null) {
			RsltRtRoutListVO[] tmpVOs = new RsltRtRoutListVO[rsltRtRoutListVOS.length];
			System.arraycopy(rsltRtRoutListVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltRtRoutListVOS = tmpVOs;
		}
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
	 * @return the rsltRtListVOS
	 */
	public RsltRtListVO[] getRsltRtListVOS() {
		RsltRtListVO[] tmpVOs = null;
		if (this.rsltRtListVOS != null) {
			tmpVOs = new RsltRtListVO[rsltRtListVOS.length];
			System.arraycopy(rsltRtListVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param rsltRtListVOS the rsltRtListVOS to set
	 */
	public void setRsltRtListVOS(RsltRtListVO[] rsltRtListVOS) {
		if (rsltRtListVOS != null) {
			RsltRtListVO[] tmpVOs = new RsltRtListVO[rsltRtListVOS.length];
			System.arraycopy(rsltRtListVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltRtListVOS = tmpVOs;
		}
	}

	/**
	 * @return the rfaRtGlineCmdtVO
	 */
	public RfaRtGlineCmdtVO getRfaRtGlineCmdtVO() {
		return rfaRtGlineCmdtVO;
	}

	/**
	 * @param rfaRtGlineCmdtVO the rfaRtGlineCmdtVO to set
	 */
	public void setRfaRtGlineCmdtVO(RfaRtGlineCmdtVO rfaRtGlineCmdtVO) {
		this.rfaRtGlineCmdtVO = rfaRtGlineCmdtVO;
	}

	/**
	 * @return the rfaRtGlineRoutVO
	 */
	public RfaRtGlineRoutVO getRfaRtGlineRoutVO() {
		return rfaRtGlineRoutVO;
	}

	/**
	 * @param rfaRtGlineRoutVO the rfaRtGlineRoutVO to set
	 */
	public void setRfaRtGlineRoutVO(RfaRtGlineRoutVO rfaRtGlineRoutVO) {
		this.rfaRtGlineRoutVO = rfaRtGlineRoutVO;
	}

}
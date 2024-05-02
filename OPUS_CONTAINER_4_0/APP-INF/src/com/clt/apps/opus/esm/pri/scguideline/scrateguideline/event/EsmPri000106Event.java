/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UiPri0030Event.java
 *@FileTitle : Guideline MQC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.20
 *@LastModifier : 문동규
 *@LastVersion : 1.0
 * 2009.04.20 문동규
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scrateguideline.event;

import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.vo.RsltRtCmdtListVO;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.vo.RsltRtListVO;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.vo.RsltRtRoutListVO;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.vo.ScRtGlineCmdtVO;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.vo.ScRtGlineRoutVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSgRtCmdtHdrVO;
import com.clt.syscommon.common.table.PriSgRtCmdtRoutVO;
import com.clt.syscommon.common.table.PriSgRtVO;

/**
 * UI_PRI_0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Moon Dong Gyu
 * @see ESM_PRI_0030HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri000106Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriSgRtCmdtHdrVO prisgrtcmdthdrvo = null;
	private PriSgRtCmdtHdrVO[] prisgrtcmdthdrvos = null;
	private PriSgRtCmdtRoutVO prisgrtcmdtroutvo = null;
	private PriSgRtCmdtRoutVO[] prisgrtcmdtroutvos = null;
	private PriSgRtVO prisgrtvo = null;
	private PriSgRtVO[] prisgrtvos = null;
	private RsltRtCmdtListVO rsltrtcmdtlistvo = null;
	private RsltRtCmdtListVO[] rsltrtcmdtlistvos = null;
	private RsltRtRoutListVO rsltrtroutlistvo = null;
	private RsltRtRoutListVO[] rsltrtroutlistvos = null;
	private RsltRtListVO rsltrtlistvo = null;
	private RsltRtListVO[] rsltrtlistvos = null;
	private ScRtGlineCmdtVO scRtGlineCmdtVO = null;
	private ScRtGlineRoutVO scRtGlineRoutVO = null;

	public EsmPri000106Event() {
	}

	public PriSgRtCmdtHdrVO getPriSgRtCmdtHdrVO() {
		return prisgrtcmdthdrvo;
	}

	public void setPriSgRtCmdtHdrVO(PriSgRtCmdtHdrVO prisgrtcmdthdrvo) {
		this.prisgrtcmdthdrvo = prisgrtcmdthdrvo;
	}

	public PriSgRtCmdtHdrVO[] getPriSgRtCmdtHdrVOS() {
		PriSgRtCmdtHdrVO[] tmpVOs = null;
		if (this.prisgrtcmdthdrvos != null) {
			tmpVOs = new PriSgRtCmdtHdrVO[prisgrtcmdthdrvos.length];
			System.arraycopy(prisgrtcmdthdrvos, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriSgRtCmdtHdrVOS(PriSgRtCmdtHdrVO[] prisgrtcmdthdrvos) {
		if (prisgrtcmdthdrvos != null) {
			PriSgRtCmdtHdrVO[] tmpVOs = new PriSgRtCmdtHdrVO[prisgrtcmdthdrvos.length];
			System.arraycopy(prisgrtcmdthdrvos, 0, tmpVOs, 0, tmpVOs.length);
			this.prisgrtcmdthdrvos = tmpVOs;
		}
	}

	public PriSgRtCmdtRoutVO getPriSgRtCmdtRoutVO() {
		return prisgrtcmdtroutvo;
	}

	public void setPriSgRtCmdtRoutVO(PriSgRtCmdtRoutVO prisgrtcmdtroutvo) {
		this.prisgrtcmdtroutvo = prisgrtcmdtroutvo;
	}

	public PriSgRtCmdtRoutVO[] getPriSgRtCmdtRoutVOS() {
		PriSgRtCmdtRoutVO[] tmpVOs = null;
		if (this.prisgrtcmdtroutvos != null) {
			tmpVOs = new PriSgRtCmdtRoutVO[prisgrtcmdtroutvos.length];
			System.arraycopy(prisgrtcmdtroutvos, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriSgRtCmdtRoutVOS(PriSgRtCmdtRoutVO[] prisgrtcmdtroutvos) {
		if (prisgrtcmdtroutvos != null) {
			PriSgRtCmdtRoutVO[] tmpVOs = new PriSgRtCmdtRoutVO[prisgrtcmdtroutvos.length];
			System.arraycopy(prisgrtcmdtroutvos, 0, tmpVOs, 0, tmpVOs.length);
			this.prisgrtcmdtroutvos = tmpVOs;
		}
	}

	public PriSgRtVO getPriSgRtVO() {
		return prisgrtvo;
	}

	public void setPriSgRtVO(PriSgRtVO prisgrtvo) {
		this.prisgrtvo = prisgrtvo;
	}

	public PriSgRtVO[] getPriSgRtVOS() {
		PriSgRtVO[] tmpVOs = null;
		if (this.prisgrtvos != null) {
			tmpVOs = new PriSgRtVO[prisgrtvos.length];
			System.arraycopy(prisgrtvos, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriSgRtVOS(PriSgRtVO[] prisgrtvos) {
		if (prisgrtvos != null) {
			PriSgRtVO[] tmpVOs = new PriSgRtVO[prisgrtvos.length];
			System.arraycopy(prisgrtvos, 0, tmpVOs, 0, tmpVOs.length);
			this.prisgrtvos = tmpVOs;
		}
	}

	public RsltRtCmdtListVO getRsltRtCmdtListVO() {
		return rsltrtcmdtlistvo;
	}

	public void setRsltRtCmdtListVO(RsltRtCmdtListVO rsltrtcmdtlistvo) {
		this.rsltrtcmdtlistvo = rsltrtcmdtlistvo;
	}

	public RsltRtCmdtListVO[] getRsltRtCmdtListVOS() {
		RsltRtCmdtListVO[] tmpVOs = null;
		if (this.rsltrtcmdtlistvos != null) {
			tmpVOs = new RsltRtCmdtListVO[rsltrtcmdtlistvos.length];
			System.arraycopy(rsltrtcmdtlistvos, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setRsltRtCmdtListVOS(RsltRtCmdtListVO[] rsltrtcmdtlistvos) {
		if (rsltrtcmdtlistvos != null) {
			RsltRtCmdtListVO[] tmpVOs = new RsltRtCmdtListVO[rsltrtcmdtlistvos.length];
			System.arraycopy(rsltrtcmdtlistvos, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltrtcmdtlistvos = tmpVOs;
		}
	}

	public RsltRtRoutListVO getRsltRtRoutListVO() {
		return rsltrtroutlistvo;
	}

	public void setRsltRtRoutListVO(RsltRtRoutListVO rsltrtroutlistvo) {
		this.rsltrtroutlistvo = rsltrtroutlistvo;
	}

	public RsltRtRoutListVO[] getRsltRtRoutListVOS() {
		RsltRtRoutListVO[] tmpVOs = null;
		if (this.rsltrtroutlistvos != null) {
			tmpVOs = new RsltRtRoutListVO[rsltrtroutlistvos.length];
			System.arraycopy(rsltrtroutlistvos, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setRsltRtRoutListVOS(RsltRtRoutListVO[] rsltrtroutlistvos) {
		if (rsltrtroutlistvos != null) {
			RsltRtRoutListVO[] tmpVOs = new RsltRtRoutListVO[rsltrtroutlistvos.length];
			System.arraycopy(rsltrtroutlistvos, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltrtroutlistvos = tmpVOs;
		}
	}

	public RsltRtListVO getRsltRtListVO() {
		return rsltrtlistvo;
	}

	public void setRsltRtListVO(RsltRtListVO rsltrtlistvo) {
		this.rsltrtlistvo = rsltrtlistvo;
	}

	public RsltRtListVO[] getRsltRtListVOS() {
		RsltRtListVO[] tmpVOs = null;
		if (this.rsltrtlistvos != null) {
			tmpVOs = new RsltRtListVO[rsltrtlistvos.length];
			System.arraycopy(rsltrtlistvos, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setRsltRtListVOS(RsltRtListVO[] rsltrtlistvos) {
		if (rsltrtlistvos != null) {
			RsltRtListVO[] tmpVOs = new RsltRtListVO[rsltrtlistvos.length];
			System.arraycopy(rsltrtlistvos, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltrtlistvos = tmpVOs;
		}
	}

	public ScRtGlineCmdtVO getScRtGlineCmdtVO() {
		return scRtGlineCmdtVO;
	}

	public void setScRtGlineCmdtVO(ScRtGlineCmdtVO scRtGlineCmdtVO) {
		this.scRtGlineCmdtVO = scRtGlineCmdtVO;
	}

	public ScRtGlineRoutVO getScRtGlineRoutVO() {
		return scRtGlineRoutVO;
	}

	public void setScRtGlineRoutVO(ScRtGlineRoutVO scRtGlineRoutVO) {
		this.scRtGlineRoutVO = scRtGlineRoutVO;
	}

}
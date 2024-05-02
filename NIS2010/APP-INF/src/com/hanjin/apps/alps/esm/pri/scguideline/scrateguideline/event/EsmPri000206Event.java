/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri000206Event.java
 *@FileTitle : Rate Guideline Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.30
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.09.30 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.event;

import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo.RsltRtCmdtListVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo.RsltRtListVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo.RsltRtRoutListVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo.ScRtGlineCmdtVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo.ScRtGlineRoutVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSgRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriSgRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriSgRtVO;

/**
 * UI_PRI_0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Moon Dong Gyu
 * @see ESM_PRI_0030HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri000206Event extends EventSupport {

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

	public EsmPri000206Event() {
	}

	public PriSgRtCmdtHdrVO getPriSgRtCmdtHdrVO() {
		return prisgrtcmdthdrvo;
	}

	public void setPriSgRtCmdtHdrVO(PriSgRtCmdtHdrVO prisgrtcmdthdrvo) {
		this.prisgrtcmdthdrvo = prisgrtcmdthdrvo;
	}

	public PriSgRtCmdtHdrVO[] getPriSgRtCmdtHdrVOS() {
		return prisgrtcmdthdrvos;
	}

	public void setPriSgRtCmdtHdrVOS(PriSgRtCmdtHdrVO[] prisgrtcmdthdrvos) {
		this.prisgrtcmdthdrvos = prisgrtcmdthdrvos;
	}

	public PriSgRtCmdtRoutVO getPriSgRtCmdtRoutVO() {
		return prisgrtcmdtroutvo;
	}

	public void setPriSgRtCmdtRoutVO(PriSgRtCmdtRoutVO prisgrtcmdtroutvo) {
		this.prisgrtcmdtroutvo = prisgrtcmdtroutvo;
	}

	public PriSgRtCmdtRoutVO[] getPriSgRtCmdtRoutVOS() {
		return prisgrtcmdtroutvos;
	}

	public void setPriSgRtCmdtRoutVOS(PriSgRtCmdtRoutVO[] prisgrtcmdtroutvos) {
		this.prisgrtcmdtroutvos = prisgrtcmdtroutvos;
	}

	public PriSgRtVO getPriSgRtVO() {
		return prisgrtvo;
	}

	public void setPriSgRtVO(PriSgRtVO prisgrtvo) {
		this.prisgrtvo = prisgrtvo;
	}

	public PriSgRtVO[] getPriSgRtVOS() {
		return prisgrtvos;
	}

	public void setPriSgRtVOS(PriSgRtVO[] prisgrtvos) {
		this.prisgrtvos = prisgrtvos;
	}

	public RsltRtCmdtListVO getRsltRtCmdtListVO() {
		return rsltrtcmdtlistvo;
	}

	public void setRsltRtCmdtListVO(RsltRtCmdtListVO rsltrtcmdtlistvo) {
		this.rsltrtcmdtlistvo = rsltrtcmdtlistvo;
	}

	public RsltRtCmdtListVO[] getRsltRtCmdtListVOS() {
		return rsltrtcmdtlistvos;
	}

	public void setRsltRtCmdtListVOS(RsltRtCmdtListVO[] rsltrtcmdtlistvos) {
		this.rsltrtcmdtlistvos = rsltrtcmdtlistvos;
	}

	public RsltRtRoutListVO getRsltRtRoutListVO() {
		return rsltrtroutlistvo;
	}

	public void setRsltRtRoutListVO(RsltRtRoutListVO rsltrtroutlistvo) {
		this.rsltrtroutlistvo = rsltrtroutlistvo;
	}

	public RsltRtRoutListVO[] getRsltRtRoutListVOS() {
		return rsltrtroutlistvos;
	}

	public void setRsltRtRoutListVOS(RsltRtRoutListVO[] rsltrtroutlistvos) {
		this.rsltrtroutlistvos = rsltrtroutlistvos;
	}

	public RsltRtListVO getRsltRtListVO() {
		return rsltrtlistvo;
	}

	public void setRsltRtListVO(RsltRtListVO rsltrtlistvo) {
		this.rsltrtlistvo = rsltrtlistvo;
	}

	public RsltRtListVO[] getRsltRtListVOS() {
		return rsltrtlistvos;
	}

	public void setRsltRtListVOS(RsltRtListVO[] rsltrtlistvos) {
		this.rsltrtlistvos = rsltrtlistvos;
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
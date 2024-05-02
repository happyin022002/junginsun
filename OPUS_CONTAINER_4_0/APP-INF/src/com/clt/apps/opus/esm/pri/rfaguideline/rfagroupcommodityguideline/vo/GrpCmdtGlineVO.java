package com.clt.apps.opus.esm.pri.rfaguideline.rfagroupcommodityguideline.vo;

import java.util.List;

import com.clt.syscommon.common.table.PriRgGrpCmdtDtlVO;
import com.clt.syscommon.common.table.PriRgGrpCmdtVO;

public class GrpCmdtGlineVO {

	private PriRgGrpCmdtVO[] priSgGrpCmdtVOS = null;
	private PriRgGrpCmdtDtlVO[] priSgGrpCmdtDtlVOS = null;
	
	private List<PriRgGrpCmdtVO> rsltPriRgGrpCmdtVOS = null;
	private List<RsltPriRgGrpCmdtDtlVO> rsltPriRgGrpCmdtDtlVOS = null;		
	
	public PriRgGrpCmdtVO[] getPriRgGrpCmdtVOS() {
		return priSgGrpCmdtVOS;
	}
	public void setPriRgGrpCmdtVOS(PriRgGrpCmdtVO[] priSgGrpCmdtVOS) {
		this.priSgGrpCmdtVOS = priSgGrpCmdtVOS;
	}
	public PriRgGrpCmdtDtlVO[] getPriRgGrpCmdtDtlVOS() {
		return priSgGrpCmdtDtlVOS;
	}
	public void setPriRgGrpCmdtDtlVOS(PriRgGrpCmdtDtlVO[] priSgGrpCmdtDtlVOS) {
		this.priSgGrpCmdtDtlVOS = priSgGrpCmdtDtlVOS;
	}
	public List<PriRgGrpCmdtVO> getRsltPriRgGrpCmdtVOS() {
		return rsltPriRgGrpCmdtVOS;
	}
	public void setRsltPriRgGrpCmdtVOS(List<PriRgGrpCmdtVO> rsltPriRgGrpCmdtVOS) {
		this.rsltPriRgGrpCmdtVOS = rsltPriRgGrpCmdtVOS;
	}
	public List<RsltPriRgGrpCmdtDtlVO> getRsltPriRgGrpCmdtDtlVOS() {
		return rsltPriRgGrpCmdtDtlVOS;
	}
	public void setRsltPriRgGrpCmdtDtlVOS(
			List<RsltPriRgGrpCmdtDtlVO> rsltPriRgGrpCmdtDtlVOS) {
		this.rsltPriRgGrpCmdtDtlVOS = rsltPriRgGrpCmdtDtlVOS;
	}


	
}
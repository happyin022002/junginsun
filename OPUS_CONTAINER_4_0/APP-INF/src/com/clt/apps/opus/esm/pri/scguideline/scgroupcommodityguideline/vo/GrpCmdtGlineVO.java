package com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.vo;

import java.util.List;

import com.clt.syscommon.common.table.PriSgGrpCmdtDtlVO;
import com.clt.syscommon.common.table.PriSgGrpCmdtVO;

public class GrpCmdtGlineVO {

	private PriSgGrpCmdtVO[] priSgGrpCmdtVOS = null;
	private PriSgGrpCmdtDtlVO[] priSgGrpCmdtDtlVOS = null;
	
	private List<PriSgGrpCmdtVO> rsltPriSgGrpCmdtVOS = null;
	private List<RsltPriSgGrpCmdtDtlVO> rsltPriSgGrpCmdtDtlVOS = null;		
	
	public PriSgGrpCmdtVO[] getPriSgGrpCmdtVOS() {
		return priSgGrpCmdtVOS;
	}
	public void setPriSgGrpCmdtVOS(PriSgGrpCmdtVO[] priSgGrpCmdtVOS) {
		this.priSgGrpCmdtVOS = priSgGrpCmdtVOS;
	}
	public PriSgGrpCmdtDtlVO[] getPriSgGrpCmdtDtlVOS() {
		return priSgGrpCmdtDtlVOS;
	}
	public void setPriSgGrpCmdtDtlVOS(PriSgGrpCmdtDtlVO[] priSgGrpCmdtDtlVOS) {
		this.priSgGrpCmdtDtlVOS = priSgGrpCmdtDtlVOS;
	}
	public List<PriSgGrpCmdtVO> getRsltPriSgGrpCmdtVOS() {
		return rsltPriSgGrpCmdtVOS;
	}
	public void setRsltPriSgGrpCmdtVOS(List<PriSgGrpCmdtVO> rsltPriSgGrpCmdtVOS) {
		this.rsltPriSgGrpCmdtVOS = rsltPriSgGrpCmdtVOS;
	}
	public List<RsltPriSgGrpCmdtDtlVO> getRsltPriSgGrpCmdtDtlVOS() {
		return rsltPriSgGrpCmdtDtlVOS;
	}
	public void setRsltPriSgGrpCmdtDtlVOS(
			List<RsltPriSgGrpCmdtDtlVO> rsltPriSgGrpCmdtDtlVOS) {
		this.rsltPriSgGrpCmdtDtlVOS = rsltPriSgGrpCmdtDtlVOS;
	}


	
}
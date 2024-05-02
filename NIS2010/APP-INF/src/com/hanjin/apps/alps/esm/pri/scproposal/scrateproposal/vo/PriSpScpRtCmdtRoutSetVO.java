package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtRoutVO;

public class PriSpScpRtCmdtRoutSetVO implements Serializable{
	private static final long serialVersionUID = 1L;

	private PriSpScpRtCmdtRoutVO[] priSpScpRtCmdtRoutVOS = null;
	private String pfmcUnit = null;

	public PriSpScpRtCmdtRoutVO[] getPriSpScpRtCmdtRoutVOS() {
		return priSpScpRtCmdtRoutVOS;
	}

	public void setPriSpScpRtCmdtRoutVOS(PriSpScpRtCmdtRoutVO[] priSpScpRtCmdtRoutVOS) {
		this.priSpScpRtCmdtRoutVOS = priSpScpRtCmdtRoutVOS;
	}

	public String getPfmcUnit() {
		return pfmcUnit;
	}

	public void setPfmcUnit(String pfmcUnit) {
		this.pfmcUnit = pfmcUnit;
	}

	

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPfmcUnit(JSPUtil.getParameter(request, "pfmc_unit", ""));
	}	
}

package com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.syscommon.common.table.PriRpScpRtCmdtRoutVO;

public class PriRpScpRtCmdtRoutSetVO implements Serializable{
	private static final long serialVersionUID = 1L;

	private PriRpScpRtCmdtRoutVO[] priRpScpRtCmdtRoutVOS = null;
	private String pfmcUnit = null;

	public PriRpScpRtCmdtRoutVO[] getPriRpScpRtCmdtRoutVOS() {
		return priRpScpRtCmdtRoutVOS;
	}

	public void setPriRpScpRtCmdtRoutVOS(PriRpScpRtCmdtRoutVO[] priRpScpRtCmdtRoutVOS) {
		this.priRpScpRtCmdtRoutVOS = priRpScpRtCmdtRoutVOS;
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

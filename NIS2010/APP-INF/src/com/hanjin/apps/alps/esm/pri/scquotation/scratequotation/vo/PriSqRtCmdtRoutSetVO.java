package com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.syscommon.common.table.PriSqRtCmdtRoutVO;

public class PriSqRtCmdtRoutSetVO implements Serializable{
	private static final long serialVersionUID = 1L;

	private PriSqRtCmdtRoutVO[] priSqRtCmdtRoutVOS = null;
	private String pfmcUnit = null;

	public PriSqRtCmdtRoutVO[] getPriSqRtCmdtRoutVOS() {
		return priSqRtCmdtRoutVOS;
	}

	public void setPriSqRtCmdtRoutVOS(PriSqRtCmdtRoutVO[] priSqRtCmdtRoutVOS) {
		this.priSqRtCmdtRoutVOS = priSqRtCmdtRoutVOS;
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

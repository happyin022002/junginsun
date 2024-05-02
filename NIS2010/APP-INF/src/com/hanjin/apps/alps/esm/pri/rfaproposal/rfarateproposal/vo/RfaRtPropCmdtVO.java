/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RsltCdListVO.java
 *@FileTitle : RsltCdListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.16
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.04.16 박성수 
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo;

import java.io.Serializable;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.vo.PriRfaNoteConvListVO;
import com.hanjin.syscommon.common.table.PriRpScpRtActCustVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCnoteVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 박성수
 * @since J2EE 1.5
 */

public class RfaRtPropCmdtVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private PriRpScpRtCmdtHdrVO[] priRpScpRtCmdtHdrVOS = null;
	private PriRpScpRtCmdtVO[] priRpScpRtCmdtVOS = null;
	private PriRpScpRtCnoteVO[] priRpScpRtCnoteVOS = null;
	private PriRpScpRtActCustVO[] priRpScpRtActCustVOS = null;
	private PriRfaNoteConvListVO[] priRfaNoteConvListVOS = null;
	
	/**
	 * @return the priRpScpRtCmdtHdrVOS
	 */
	public PriRpScpRtCmdtHdrVO[] getPriRpScpRtCmdtHdrVOS() {
		return priRpScpRtCmdtHdrVOS;
	}
	
	/**
	 * @param priRpScpRtCmdtHdrVOS the priRpScpRtCmdtHdrVOS to set
	 */
	public void setPriRpScpRtCmdtHdrVOS(PriRpScpRtCmdtHdrVO[] priRpScpRtCmdtHdrVOS) {
		this.priRpScpRtCmdtHdrVOS = priRpScpRtCmdtHdrVOS;
	}
	
	/**
	 * @return the priRpScpRtCmdtVOS
	 */
	public PriRpScpRtCmdtVO[] getPriRpScpRtCmdtVOS() {
		return priRpScpRtCmdtVOS;
	}
	
	/**
	 * @param priRpScpRtCmdtVOS the priRpScpRtCmdtVOS to set
	 */
	public void setPriRpScpRtCmdtVOS(PriRpScpRtCmdtVO[] priRpScpRtCmdtVOS) {
		this.priRpScpRtCmdtVOS = priRpScpRtCmdtVOS;
	}
	
	/**
	 * @return the priRpScpRtCnoteVOS
	 */
	public PriRpScpRtCnoteVO[] getPriRpScpRtCnoteVOS() {
		return priRpScpRtCnoteVOS;
	}
	
	/**
	 * @param priRpScpRtCnoteVOS the priRpScpRtCnoteVOS to set
	 */
	public void setPriRpScpRtCnoteVOS(PriRpScpRtCnoteVO[] priRpScpRtCnoteVOS) {
		this.priRpScpRtCnoteVOS = priRpScpRtCnoteVOS;
	}
	
	/**
	 * @return the priRpScpRtActCustVOS
	 */
	public PriRpScpRtActCustVO[] getPriRpScpRtActCustVOS() {
		return priRpScpRtActCustVOS;
	}
	
	/**
	 * @param priRpScpRtActCustVOS the priRpScpRtActCustVOS to set
	 */
	public void setPriRpScpRtActCustVOS(PriRpScpRtActCustVO[] priRpScpRtActCustVOS) {
		this.priRpScpRtActCustVOS = priRpScpRtActCustVOS;
	}

	public PriRfaNoteConvListVO[] getPriRfaNoteConvListVOS() {
		return priRfaNoteConvListVOS;
	}

	public void setPriRfaNoteConvListVOS(
			PriRfaNoteConvListVO[] priRfaNoteConvListVOS) {
		this.priRfaNoteConvListVOS = priRfaNoteConvListVOS;
	}



}

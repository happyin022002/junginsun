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
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtRnoteVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriRpScpRtRoutPntVO;
import com.hanjin.syscommon.common.table.PriRpScpRtRoutViaVO;
import com.hanjin.syscommon.common.table.PriRpScpRtVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 박성수
 * @since J2EE 1.5
 */

public class RfaRtPropRtVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO = null;
	private PriRpScpRtCmdtRoutVO[] priRpScpRtCmdtRoutVOS = null;
	private PriRpScpRtRoutPntVO[] priRpScpRtRoutOrgPntVOS = null;
	private PriRpScpRtRoutViaVO[] priRpScpRtRoutOrgViaVOS = null;
	private PriRpScpRtRoutViaVO[] priRpScpRtRoutDestViaVOS = null;
	private PriRpScpRtRoutPntVO[] priRpScpRtRoutDestPntVOS = null;
	private PriRpScpRtCmdtRnoteVO[] priRpScpRtCmdtRnoteVOS = null;
	private PriRpScpRtVO[] priRpScpRtVOS = null;
	private PriRfaNoteConvListVO[] priRfaNoteConvListVOS = null;
	private String ficRtTpCd = null;

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
	 * @return the priRpScpRtCmdtRoutVOS
	 */
	public PriRpScpRtCmdtRoutVO[] getPriRpScpRtCmdtRoutVOS() {
		return priRpScpRtCmdtRoutVOS;
	}

	/**
	 * @param priRpScpRtCmdtRoutVOS the priRpScpRtCmdtRoutVOS to set
	 */
	public void setPriRpScpRtCmdtRoutVOS(PriRpScpRtCmdtRoutVO[] priRpScpRtCmdtRoutVOS) {
		this.priRpScpRtCmdtRoutVOS = priRpScpRtCmdtRoutVOS;
	}

	/**
	 * @return the priRpScpRtRoutOrgPntVOS
	 */
	public PriRpScpRtRoutPntVO[] getPriRpScpRtRoutOrgPntVOS() {
		return priRpScpRtRoutOrgPntVOS;
	}

	/**
	 * @param priRpScpRtRoutOrgPntVOS the priRpScpRtRoutOrgPntVOS to set
	 */
	public void setPriRpScpRtRoutOrgPntVOS(PriRpScpRtRoutPntVO[] priRpScpRtRoutOrgPntVOS) {
		this.priRpScpRtRoutOrgPntVOS = priRpScpRtRoutOrgPntVOS;
	}

	/**
	 * @return the priRpScpRtRoutOrgViaVOS
	 */
	public PriRpScpRtRoutViaVO[] getPriRpScpRtRoutOrgViaVOS() {
		return priRpScpRtRoutOrgViaVOS;
	}

	/**
	 * @param priRpScpRtRoutOrgViaVOS the priRpScpRtRoutOrgViaVOS to set
	 */
	public void setPriRpScpRtRoutOrgViaVOS(PriRpScpRtRoutViaVO[] priRpScpRtRoutOrgViaVOS) {
		this.priRpScpRtRoutOrgViaVOS = priRpScpRtRoutOrgViaVOS;
	}

	/**
	 * @return the priRpScpRtRoutDestViaVOS
	 */
	public PriRpScpRtRoutViaVO[] getPriRpScpRtRoutDestViaVOS() {
		return priRpScpRtRoutDestViaVOS;
	}

	/**
	 * @param priRpScpRtRoutDestViaVOS the priRpScpRtRoutDestViaVOS to set
	 */
	public void setPriRpScpRtRoutDestViaVOS(PriRpScpRtRoutViaVO[] priRpScpRtRoutDestViaVOS) {
		this.priRpScpRtRoutDestViaVOS = priRpScpRtRoutDestViaVOS;
	}

	/**
	 * @return the priRpScpRtRoutDestPntVOS
	 */
	public PriRpScpRtRoutPntVO[] getPriRpScpRtRoutDestPntVOS() {
		return priRpScpRtRoutDestPntVOS;
	}

	/**
	 * @param priRpScpRtRoutDestPntVOS the priRpScpRtRoutDestPntVOS to set
	 */
	public void setPriRpScpRtRoutDestPntVOS(PriRpScpRtRoutPntVO[] priRpScpRtRoutDestPntVOS) {
		this.priRpScpRtRoutDestPntVOS = priRpScpRtRoutDestPntVOS;
	}

	/**
	 * @return the priRpScpRtCmdtRnoteVOS
	 */
	public PriRpScpRtCmdtRnoteVO[] getPriRpScpRtCmdtRnoteVOS() {
		return priRpScpRtCmdtRnoteVOS;
	}

	/**
	 * @param priRpScpRtCmdtRnoteVOS the priRpScpRtCmdtRnoteVOS to set
	 */
	public void setPriRpScpRtCmdtRnoteVOS(PriRpScpRtCmdtRnoteVO[] priRpScpRtCmdtRnoteVOS) {
		this.priRpScpRtCmdtRnoteVOS = priRpScpRtCmdtRnoteVOS;
	}

	/**
	 * @return the priRpScpRtVOS
	 */
	public PriRpScpRtVO[] getPriRpScpRtVOS() {
		return priRpScpRtVOS;
	}

	/**
	 * @param priRpScpRtVOS the priRpScpRtVOS to set
	 */
	public void setPriRpScpRtVOS(PriRpScpRtVO[] priRpScpRtVOS) {
		this.priRpScpRtVOS = priRpScpRtVOS;
	}

	public PriRfaNoteConvListVO[] getPriRfaNoteConvListVOS() {
		return priRfaNoteConvListVOS;
	}

	public void setPriRfaNoteConvListVOS(PriRfaNoteConvListVO[] priRfaNoteConvListVOS) {
		this.priRfaNoteConvListVOS = priRfaNoteConvListVOS;
	}

	/**
	 * @return the ficRtTpCd
	 */
	public String getFicRtTpCd() {
		return ficRtTpCd;
	}

	/**
	 * @param ficRtTpCd the ficRtTpCd to set
	 */
	public void setFicRtTpCd(String ficRtTpCd) {
		this.ficRtTpCd = ficRtTpCd;
	}
}

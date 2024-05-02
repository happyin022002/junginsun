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

package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo;

import java.io.Serializable;

import com.hanjin.syscommon.common.table.PriSpScpRtActCustVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtRnoteVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCnoteVO;
import com.hanjin.syscommon.common.table.PriSpScpRtRoutDirVO;
import com.hanjin.syscommon.common.table.PriSpScpRtRoutPntVO;
import com.hanjin.syscommon.common.table.PriSpScpRtRoutViaVO;
import com.hanjin.syscommon.common.table.PriSpScpRtVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 박성수
 * @since J2EE 1.5
 */

public class ScRtPropTtlRtVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private PriSpScpRtCmdtHdrVO[] priSpScpRtCmdtHdrVOS = null;
	private PriSpScpRtCmdtVO[] priSpScpRtCmdtVOS = null;
	private PriSpScpRtCnoteVO[] priSpScpRtCnoteVOS = null;
	private PriSpScpRtActCustVO[] priSpScpRtActCustVOS = null;
	private PriSpScpRtCmdtRoutVO[] priSpScpRtCmdtRoutVOS = null;
	private PriSpScpRtRoutPntVO[] priSpScpRtRoutOrgPntVOS = null;
	private PriSpScpRtRoutViaVO[] priSpScpRtRoutOrgViaVOS = null;
	private PriSpScpRtRoutViaVO[] priSpScpRtRoutDestViaVOS = null;
	private PriSpScpRtRoutPntVO[] priSpScpRtRoutDestPntVOS = null;
	private PriSpScpRtRoutDirVO[] priSpScpRtRoutDirVOS = null;
	private PriSpScpRtCmdtRnoteVO[] priSpScpRtCmdtRnoteVOS = null;
	private PriSpScpRtVO[] priSpScpRtVOS = null;
	/**
	 * @return the priSpScpRtCmdtHdrVOS
	 */
	public PriSpScpRtCmdtHdrVO[] getPriSpScpRtCmdtHdrVOS() {
		return priSpScpRtCmdtHdrVOS;
	}
	/**
	 * @param priSpScpRtCmdtHdrVOS the priSpScpRtCmdtHdrVOS to set
	 */
	public void setPriSpScpRtCmdtHdrVOS(PriSpScpRtCmdtHdrVO[] priSpScpRtCmdtHdrVOS) {
		this.priSpScpRtCmdtHdrVOS = priSpScpRtCmdtHdrVOS;
	}
	/**
	 * @return the priSpScpRtCmdtVOS
	 */
	public PriSpScpRtCmdtVO[] getPriSpScpRtCmdtVOS() {
		return priSpScpRtCmdtVOS;
	}
	/**
	 * @param priSpScpRtCmdtVOS the priSpScpRtCmdtVOS to set
	 */
	public void setPriSpScpRtCmdtVOS(PriSpScpRtCmdtVO[] priSpScpRtCmdtVOS) {
		this.priSpScpRtCmdtVOS = priSpScpRtCmdtVOS;
	}
	/**
	 * @return the priSpScpRtCnoteVOS
	 */
	public PriSpScpRtCnoteVO[] getPriSpScpRtCnoteVOS() {
		return priSpScpRtCnoteVOS;
	}
	/**
	 * @param priSpScpRtCnoteVOS the priSpScpRtCnoteVOS to set
	 */
	public void setPriSpScpRtCnoteVOS(PriSpScpRtCnoteVO[] priSpScpRtCnoteVOS) {
		this.priSpScpRtCnoteVOS = priSpScpRtCnoteVOS;
	}
	/**
	 * @return the priSpScpRtActCustVOS
	 */
	public PriSpScpRtActCustVO[] getPriSpScpRtActCustVOS() {
		return priSpScpRtActCustVOS;
	}
	/**
	 * @param priSpScpRtActCustVOS the priSpScpRtActCustVOS to set
	 */
	public void setPriSpScpRtActCustVOS(PriSpScpRtActCustVO[] priSpScpRtActCustVOS) {
		this.priSpScpRtActCustVOS = priSpScpRtActCustVOS;
	}
	/**
	 * @return the priSpScpRtCmdtRoutVOS
	 */
	public PriSpScpRtCmdtRoutVO[] getPriSpScpRtCmdtRoutVOS() {
		return priSpScpRtCmdtRoutVOS;
	}
	/**
	 * @param priSpScpRtCmdtRoutVOS the priSpScpRtCmdtRoutVOS to set
	 */
	public void setPriSpScpRtCmdtRoutVOS(PriSpScpRtCmdtRoutVO[] priSpScpRtCmdtRoutVOS) {
		this.priSpScpRtCmdtRoutVOS = priSpScpRtCmdtRoutVOS;
	}
	/**
	 * @return the priSpScpRtRoutOrgPntVOS
	 */
	public PriSpScpRtRoutPntVO[] getPriSpScpRtRoutOrgPntVOS() {
		return priSpScpRtRoutOrgPntVOS;
	}
	/**
	 * @param priSpScpRtRoutOrgPntVOS the priSpScpRtRoutOrgPntVOS to set
	 */
	public void setPriSpScpRtRoutOrgPntVOS(PriSpScpRtRoutPntVO[] priSpScpRtRoutOrgPntVOS) {
		this.priSpScpRtRoutOrgPntVOS = priSpScpRtRoutOrgPntVOS;
	}
	/**
	 * @return the priSpScpRtRoutOrgViaVOS
	 */
	public PriSpScpRtRoutViaVO[] getPriSpScpRtRoutOrgViaVOS() {
		return priSpScpRtRoutOrgViaVOS;
	}
	/**
	 * @param priSpScpRtRoutOrgViaVOS the priSpScpRtRoutOrgViaVOS to set
	 */
	public void setPriSpScpRtRoutOrgViaVOS(PriSpScpRtRoutViaVO[] priSpScpRtRoutOrgViaVOS) {
		this.priSpScpRtRoutOrgViaVOS = priSpScpRtRoutOrgViaVOS;
	}
	/**
	 * @return the priSpScpRtRoutDestViaVOS
	 */
	public PriSpScpRtRoutViaVO[] getPriSpScpRtRoutDestViaVOS() {
		return priSpScpRtRoutDestViaVOS;
	}
	/**
	 * @param priSpScpRtRoutDestViaVOS the priSpScpRtRoutDestViaVOS to set
	 */
	public void setPriSpScpRtRoutDestViaVOS(PriSpScpRtRoutViaVO[] priSpScpRtRoutDestViaVOS) {
		this.priSpScpRtRoutDestViaVOS = priSpScpRtRoutDestViaVOS;
	}
	/**
	 * @return the priSpScpRtRoutDestPntVOS
	 */
	public PriSpScpRtRoutPntVO[] getPriSpScpRtRoutDestPntVOS() {
		return priSpScpRtRoutDestPntVOS;
	}
	/**
	 * @param priSpScpRtRoutDestPntVOS the priSpScpRtRoutDestPntVOS to set
	 */
	public void setPriSpScpRtRoutDestPntVOS(PriSpScpRtRoutPntVO[] priSpScpRtRoutDestPntVOS) {
		this.priSpScpRtRoutDestPntVOS = priSpScpRtRoutDestPntVOS;
	}
	/**
	 * @return the priSpScpRtRoutDirVOS
	 */
	public PriSpScpRtRoutDirVO[] getPriSpScpRtRoutDirVOS() {
		return priSpScpRtRoutDirVOS;
	}
	/**
	 * @param priSpScpRtRoutDirVOS the priSpScpRtRoutDirVOS to set
	 */
	public void setPriSpScpRtRoutDirVOS(PriSpScpRtRoutDirVO[] priSpScpRtRoutDirVOS) {
		this.priSpScpRtRoutDirVOS = priSpScpRtRoutDirVOS;
	}
	/**
	 * @return the priSpScpRtCmdtRnoteVOS
	 */
	public PriSpScpRtCmdtRnoteVO[] getPriSpScpRtCmdtRnoteVOS() {
		return priSpScpRtCmdtRnoteVOS;
	}
	/**
	 * @param priSpScpRtCmdtRnoteVOS the priSpScpRtCmdtRnoteVOS to set
	 */
	public void setPriSpScpRtCmdtRnoteVOS(PriSpScpRtCmdtRnoteVO[] priSpScpRtCmdtRnoteVOS) {
		this.priSpScpRtCmdtRnoteVOS = priSpScpRtCmdtRnoteVOS;
	}
	/**
	 * @return the priSpScpRtVOS
	 */
	public PriSpScpRtVO[] getPriSpScpRtVOS() {
		return priSpScpRtVOS;
	}
	/**
	 * @param priSpScpRtVOS the priSpScpRtVOS to set
	 */
	public void setPriSpScpRtVOS(PriSpScpRtVO[] priSpScpRtVOS) {
		this.priSpScpRtVOS = priSpScpRtVOS;
	}

}

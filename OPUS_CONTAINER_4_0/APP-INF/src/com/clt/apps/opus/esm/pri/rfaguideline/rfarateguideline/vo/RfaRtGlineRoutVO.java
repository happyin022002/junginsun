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

package com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo;

import java.io.Serializable;

import com.clt.syscommon.common.table.PriRgRtCmdtRoutVO;
import com.clt.syscommon.common.table.PriRgRtRoutPntVO;
import com.clt.syscommon.common.table.PriRgRtRoutViaVO;
import com.clt.syscommon.common.table.PriRgRtVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 박성수
 * @since J2EE 1.5
 */

public class RfaRtGlineRoutVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private PriRgRtCmdtRoutVO[] priRgRtCmdtRoutVOS = null;
	private PriRgRtRoutPntVO[] priRgRtRoutOrgPntVOS = null;
	private PriRgRtRoutViaVO[] priRgRtRoutOrgViaVOS = null;
	private PriRgRtRoutViaVO[] priRgRtRoutDestViaVOS = null;
	private PriRgRtRoutPntVO[] priRgRtRoutDestPntVOS = null;
	private PriRgRtVO[] priRgRtVOS = null;
	
	/**
	 * @return the priRgRtCmdtRoutVOS
	 */
	public PriRgRtCmdtRoutVO[] getPriRgRtCmdtRoutVOS() {
		return priRgRtCmdtRoutVOS;
	}
	
	/**
	 * @param priRgRtCmdtRoutVOS the priRgRtCmdtRoutVOS to set
	 */
	public void setPriRgRtCmdtRoutVOS(PriRgRtCmdtRoutVO[] priRgRtCmdtRoutVOS) {
		this.priRgRtCmdtRoutVOS = priRgRtCmdtRoutVOS;
	}
	
	/**
	 * @return the priRgRtRoutOrgPntVOS
	 */
	public PriRgRtRoutPntVO[] getPriRgRtRoutOrgPntVOS() {
		return priRgRtRoutOrgPntVOS;
	}
	
	/**
	 * @param priRgRtRoutOrgPntVOS the priRgRtRoutOrgPntVOS to set
	 */
	public void setPriRgRtRoutOrgPntVOS(PriRgRtRoutPntVO[] priRgRtRoutOrgPntVOS) {
		this.priRgRtRoutOrgPntVOS = priRgRtRoutOrgPntVOS;
	}
	
	/**
	 * @return the priRgRtRoutOrgViaVOS
	 */
	public PriRgRtRoutViaVO[] getPriRgRtRoutOrgViaVOS() {
		return priRgRtRoutOrgViaVOS;
	}
	
	/**
	 * @param priRgRtRoutOrgViaVOS the priRgRtRoutOrgViaVOS to set
	 */
	public void setPriRgRtRoutOrgViaVOS(PriRgRtRoutViaVO[] priRgRtRoutOrgViaVOS) {
		this.priRgRtRoutOrgViaVOS = priRgRtRoutOrgViaVOS;
	}
	
	/**
	 * @return the priRgRtRoutDestViaVOS
	 */
	public PriRgRtRoutViaVO[] getPriRgRtRoutDestViaVOS() {
		return priRgRtRoutDestViaVOS;
	}
	
	/**
	 * @param priRgRtRoutDestViaVOS the priRgRtRoutDestViaVOS to set
	 */
	public void setPriRgRtRoutDestViaVOS(PriRgRtRoutViaVO[] priRgRtRoutDestViaVOS) {
		this.priRgRtRoutDestViaVOS = priRgRtRoutDestViaVOS;
	}
	
	/**
	 * @return the priRgRtRoutDestPntVOS
	 */
	public PriRgRtRoutPntVO[] getPriRgRtRoutDestPntVOS() {
		return priRgRtRoutDestPntVOS;
	}
	
	/**
	 * @param priRgRtRoutDestPntVOS the priRgRtRoutDestPntVOS to set
	 */
	public void setPriRgRtRoutDestPntVOS(PriRgRtRoutPntVO[] priRgRtRoutDestPntVOS) {
		this.priRgRtRoutDestPntVOS = priRgRtRoutDestPntVOS;
	}
	
	/**
	 * @return the priRgRtVOS
	 */
	public PriRgRtVO[] getPriRgRtVOS() {
		return priRgRtVOS;
	}
	
	/**
	 * @param priRgRtVOS the priRgRtVOS to set
	 */
	public void setPriRgRtVOS(PriRgRtVO[] priRgRtVOS) {
		this.priRgRtVOS = priRgRtVOS;
	}

}

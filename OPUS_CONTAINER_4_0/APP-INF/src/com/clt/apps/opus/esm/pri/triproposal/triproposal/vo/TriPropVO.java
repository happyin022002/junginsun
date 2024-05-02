/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TriPropVO.java
 *@FileTitle : TriPropVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.16
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.11.16 박성수 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.triproposal.triproposal.vo;

import java.io.Serializable;

import com.clt.syscommon.common.table.PriTriMnVO;
import com.clt.syscommon.common.table.PriTriRtRoutPntVO;
import com.clt.syscommon.common.table.PriTriRtRoutViaVO;
import com.clt.syscommon.common.table.PriTriRtVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 박성수
 * @since J2EE 1.5
 */

public class TriPropVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private PriTriMnVO priTriMnVO = null;
	private PriTriRtRoutPntVO[] priTriRtRoutOrgPntVOS = null;
	private PriTriRtRoutViaVO[] priTriRtRoutOrgViaVOS = null;
	private PriTriRtRoutViaVO[] priTriRtRoutDestViaVOS = null;
	private PriTriRtRoutPntVO[] priTriRtRoutDestPntVOS = null;
	private PriTriRtVO[] priTriRtVOS = null;
	
	/**
	 * @return the priTriMnVO
	 */
	public PriTriMnVO getPriTriMnVO() {
		return priTriMnVO;
	}
	
	/**
	 * @param priTriMnVO the priTriMnVO to set
	 */
	public void setPriTriMnVO(PriTriMnVO priTriMnVO) {
		this.priTriMnVO = priTriMnVO;
	}
	
	/**
	 * @return the priTriRtRoutOrgPntVOS
	 */
	public PriTriRtRoutPntVO[] getPriTriRtRoutOrgPntVOS() {
		return priTriRtRoutOrgPntVOS;
	}
	
	/**
	 * @param priTriRtRoutOrgPntVOS the priTriRtRoutOrgPntVOS to set
	 */
	public void setPriTriRtRoutOrgPntVOS(PriTriRtRoutPntVO[] priTriRtRoutOrgPntVOS) {
		this.priTriRtRoutOrgPntVOS = priTriRtRoutOrgPntVOS;
	}
	
	/**
	 * @return the priTriRtRoutOrgViaVOS
	 */
	public PriTriRtRoutViaVO[] getPriTriRtRoutOrgViaVOS() {
		return priTriRtRoutOrgViaVOS;
	}
	
	/**
	 * @param priTriRtRoutOrgViaVOS the priTriRtRoutOrgViaVOS to set
	 */
	public void setPriTriRtRoutOrgViaVOS(PriTriRtRoutViaVO[] priTriRtRoutOrgViaVOS) {
		this.priTriRtRoutOrgViaVOS = priTriRtRoutOrgViaVOS;
	}
	
	/**
	 * @return the priTriRtRoutDestViaVOS
	 */
	public PriTriRtRoutViaVO[] getPriTriRtRoutDestViaVOS() {
		return priTriRtRoutDestViaVOS;
	}
	
	/**
	 * @param priTriRtRoutDestViaVOS the priTriRtRoutDestViaVOS to set
	 */
	public void setPriTriRtRoutDestViaVOS(PriTriRtRoutViaVO[] priTriRtRoutDestViaVOS) {
		this.priTriRtRoutDestViaVOS = priTriRtRoutDestViaVOS;
	}
	
	/**
	 * @return the priTriRtRoutDestPntVOS
	 */
	public PriTriRtRoutPntVO[] getPriTriRtRoutDestPntVOS() {
		return priTriRtRoutDestPntVOS;
	}
	
	/**
	 * @param priTriRtRoutDestPntVOS the priTriRtRoutDestPntVOS to set
	 */
	public void setPriTriRtRoutDestPntVOS(PriTriRtRoutPntVO[] priTriRtRoutDestPntVOS) {
		this.priTriRtRoutDestPntVOS = priTriRtRoutDestPntVOS;
	}
	
	/**
	 * @return the priTriRtVOS
	 */
	public PriTriRtVO[] getPriTriRtVOS() {
		return priTriRtVOS;
	}
	
	/**
	 * @param priTriRtVOS the priTriRtVOS to set
	 */
	public void setPriTriRtVOS(PriTriRtVO[] priTriRtVOS) {
		this.priTriRtVOS = priTriRtVOS;
	}

}

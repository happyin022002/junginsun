/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsGem0110Event.java
 *@FileTitle : Expense Matrix Copy
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.15
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.05.15 최정미
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.event;

import com.clt.framework.support.layer.event.EventSupport;

/**
 * CPS_GEM_0110 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - CPS_GEM_0110HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author choijungmi
 * @see CPS_GEM_0110HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsGem0110Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String matrixDiv = null;
	private String fromOfcCd = null;
	private String toOfcCd = null;

	public CpsGem0110Event() {
	}

	public String getMatrixDiv() {
		return matrixDiv;
	}

	public void setMatrixDiv(String matrixDiv) {
		this.matrixDiv = matrixDiv;
	}

	public String getFromOfcCd() {
		return fromOfcCd;
	}

	public void setFromOfcCd(String fromOfcCd) {
		this.fromOfcCd = fromOfcCd;
	}

	public String getToOfcCd() {
		return toOfcCd;
	}

	public void setToOfcCd(String toOfcCd) {
		this.toOfcCd = toOfcCd;
	}

}
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri6005Event.java
 *@FileTitle : S/C Quotation Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.06
 *@LastModifier : 이승준
 *@LastVersion : 1.0
 * 2009.08.06 이승준
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event;

import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.event.ESM_PRI_6014HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRqMnVO;

/**
 * ESM_PRI_6014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_6014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Seung-Jun,Lee
 * @see ESM_PRI_6014HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6045Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriRqMnVO priRqMnVO = null;

	private String ficRtTpCd = null;

	public EsmPri6045Event() {
	}

	/**
	 * @return the priRqMnVO
	 */
	public PriRqMnVO getPriRqMnVO() {
		return priRqMnVO;
	}

	/**
	 * @param priRqMnVO the priRqMnVO to set
	 */
	public void setPriRqMnVO(PriRqMnVO priRqMnVO) {
		this.priRqMnVO = priRqMnVO;
	}

	public String getFicRtTpCd() {
		return ficRtTpCd;
	}

	public void setFicRtTpCd(String ficRtTpCd) {
		this.ficRtTpCd = ficRtTpCd;
	}
}
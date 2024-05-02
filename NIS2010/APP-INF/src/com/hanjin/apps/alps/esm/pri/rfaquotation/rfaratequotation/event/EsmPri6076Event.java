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


import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRqMnVO;


/**
 * ESM_PRI_6076 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6076HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung-Jun,Lee
 * @see ESM_PRI_6076HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6076Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRqMnVO priRqMnVO = null;

	
	public EsmPri6076Event(){}
	
	
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

	
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScInformVO.java
*@FileTitle : ScInformVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.30 이진서
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo;

import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 * S/C에 입력된 운임 정보
 * @author 이진서
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class ScInformOutVO {

	private ScBkgInformVO scBkgInformVOs = null;
	private ScCustInformVO scCustInformVOs = null;


	/**
	 * @return the scBkgInformVOs
	 */
	public ScBkgInformVO getScBkgInformVOs() {
		return scBkgInformVOs;
	}
	/**
	 * @param scBkgInformVOs the scBkgInformVOs to set
	 */
	public void setScBkgInformVOs(ScBkgInformVO scBkgInformVOs) {
		this.scBkgInformVOs = scBkgInformVOs;
	}
	/**
	 * @return the scCustInformVOs
	 */
	public ScCustInformVO getScCustInformVOs() {
		return scCustInformVOs;
	}
	/**
	 * @param scCustInformVOs the scCustInformVOs to set
	 */
	public void setScCustInformVOs(ScCustInformVO scCustInformVOs) {
		this.scCustInformVOs = scCustInformVOs;
	}


}


/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TaaInformVO.java
*@FileTitle : TaaInformVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.18
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.06.30 김태경 
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
public class TaaInformOutVO {

	private TaaBkgInformVO taaBkgInformVOs = null;
	private TaaCustInformVO taaCustInformVOs = null;


	/**
	 * @return the taaBkgInformVOs
	 */
	public TaaBkgInformVO getTaaBkgInformVOs() {
		return taaBkgInformVOs;
	}
	/**
	 * @param taaBkgInformVOs the taaBkgInformVOs to set
	 */
	public void setTaaBkgInformVOs(TaaBkgInformVO taaBkgInformVOs) {
		this.taaBkgInformVOs = taaBkgInformVOs;
	}
	/**
	 * @return the taaCustInformVOs
	 */
	public TaaCustInformVO getTaaCustInformVOs() {
		return taaCustInformVOs;
	}
	/**
	 * @param taaCustInformVOs the taaCustInformVOs to set
	 */
	public void setTaaCustInformVOs(TaaCustInformVO taaCustInformVOs) {
		this.taaCustInformVOs = taaCustInformVOs;
	}


}


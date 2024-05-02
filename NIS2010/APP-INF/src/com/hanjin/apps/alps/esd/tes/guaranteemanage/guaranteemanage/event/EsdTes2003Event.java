/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTes2005Event.java
*@FileTitle : Vendor Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.14 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.event;

import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TES_2005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TES_2005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author yOng hO lEE
 * @see ESD_TES_2005HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTes2003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private GuaranteeCommonVO guaranteeCommonVO = null; 

	public EsdTes2003Event(){}

	/**
	 * @return the guaranteeCommonVO
	 */
	public GuaranteeCommonVO getGuaranteeCommonVO() {
		return guaranteeCommonVO;
	}

	/**
	 * @param guaranteeCommonVO the guaranteeCommonVO to set
	 */
	public void setGuaranteeCommonVO(GuaranteeCommonVO guaranteeCommonVO) {
		this.guaranteeCommonVO = guaranteeCommonVO;
	}


}
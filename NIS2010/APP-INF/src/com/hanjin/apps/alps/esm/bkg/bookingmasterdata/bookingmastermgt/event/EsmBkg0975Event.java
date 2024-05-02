/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0975Event.java
*@FileTitle : Charge_Charge code inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.26 이진서
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;


import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.CodeDescVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0975 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0975HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Jin Seo
 * @see ESM_BKG_0975HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0975Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EsmBkg0975Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CodeDescVO codeDescVO = null;
	/** Table Value Object Multi Data 처리 */
	private CodeDescVO[] codeDescVOs = null;

	/**
	 * @return the codeDescVO
	 */
	public CodeDescVO getCodeDescVO() {
		return codeDescVO;
	}

	/**
	 * @param codeDescVO the codeDescVO to set
	 */
	public void setCodeDescVO(CodeDescVO codeDescVO) {
		this.codeDescVO = codeDescVO;
	}

	/**
	 * @return the codeDescVOs
	 */
	public CodeDescVO[] getCodeDescVOs() {
		CodeDescVO[] rtnVOs = null;
		if (this.codeDescVOs != null) {
			rtnVOs = Arrays.copyOf(codeDescVOs, codeDescVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param codeDescVOs the codeDescVOs to set
	 */
	public void setCodeDescVOs(CodeDescVO[] codeDescVOs){
		if(codeDescVOs != null){
			CodeDescVO[] tmpVOs = Arrays.copyOf(codeDescVOs, codeDescVOs.length);
			this.codeDescVOs = tmpVOs;
		}
	}



}
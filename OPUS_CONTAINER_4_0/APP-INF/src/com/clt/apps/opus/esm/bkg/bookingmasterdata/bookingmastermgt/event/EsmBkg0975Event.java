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
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event;


import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.CodeDescVO;
import com.clt.framework.support.layer.event.EventSupport;


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
//	public CodeDescVO[] getCodeDescVOs() {
//		return codeDescVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public CodeDescVO[] getCodeDescVOs() {
		CodeDescVO[] tmpVOs = null;
		if (this.codeDescVOs != null) {
			tmpVOs = new CodeDescVO[codeDescVOs.length];
			System.arraycopy(codeDescVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}		

//	public void setCodeDescVOs(CodeDescVO[] codeDescVOs) {
//		this.codeDescVOs = codeDescVOs;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]
	/**
	 * @param codeDescVOs the codeDescVOs to set
	 */
	public void setCodeDescVOs(CodeDescVO[] codeDescVOs) {
		if (codeDescVOs != null) {
			CodeDescVO[] tmpVOs = new CodeDescVO[codeDescVOs.length];
			System.arraycopy(codeDescVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.codeDescVOs = tmpVOs;
		}		
	}

}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0354Event.java
*@FileTitle : Location of goods Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgcustomscanadagrouplocationVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.VskVslPortSkdConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0354 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0354HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김경섭
 * @see ESM_BKG_0354HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0354Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmBkg0354Event(){}
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgcustomscanadagrouplocationVO infoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgcustomscanadagrouplocationVO[] infoVOs = null;

	public BkgcustomscanadagrouplocationVO getInfoVO() {
		return infoVO;
	}

	public void setInfoVO(BkgcustomscanadagrouplocationVO infoVO) {
		this.infoVO = infoVO;
	}

//	public BkgcustomscanadagrouplocationVO[] getInfoVOs() {
//		return infoVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public BkgcustomscanadagrouplocationVO[] getInfoVOs() {
		BkgcustomscanadagrouplocationVO[] tmpVOs = null;
		if (this.infoVOs != null) {
			tmpVOs = new BkgcustomscanadagrouplocationVO[infoVOs.length];
			System.arraycopy(infoVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}	

//	public void setInfoVOs(BkgcustomscanadagrouplocationVO[] infoVOs) {
//		this.infoVOs = infoVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setInfoVOs(BkgcustomscanadagrouplocationVO[] infoVOs) {
		if (infoVOs != null) {
			BkgcustomscanadagrouplocationVO[] tmpVOs = new BkgcustomscanadagrouplocationVO[infoVOs.length];
			System.arraycopy(infoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.infoVOs = tmpVOs;
		}		
	}
	

	
}
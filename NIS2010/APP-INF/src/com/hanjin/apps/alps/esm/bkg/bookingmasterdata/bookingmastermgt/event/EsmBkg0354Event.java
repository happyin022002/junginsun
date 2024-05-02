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
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgcustomscanadagrouplocationVO;
import com.hanjin.framework.support.layer.event.EventSupport;


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

	public BkgcustomscanadagrouplocationVO[] getInfoVOs() {
		return infoVOs;
	}

	public void setInfoVOs(BkgcustomscanadagrouplocationVO[] infoVOs) {
		this.infoVOs = infoVOs;
	}
	

	

	
}
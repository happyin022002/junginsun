/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0374Event.java
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

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkganDestOfcStupVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.VskVslPortSkdConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0374 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0374HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김경섭
 * @see ESM_BKG_0374HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0374Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmBkg0374Event(){}
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkganDestOfcStupVO infoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkganDestOfcStupVO[] infoVOs = null;

	public BkganDestOfcStupVO getInfoVO() {
		return infoVO;
	}

	public void setInfoVO(BkganDestOfcStupVO infoVO) {
		this.infoVO = infoVO;
	}

//	public BkganDestOfcStupVO[] getInfoVOs() {
//		return infoVOs;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]
	public BkganDestOfcStupVO[] getInfoVOs() {
		BkganDestOfcStupVO[] tmpVOs = null;
		if (this.infoVOs != null) {
			tmpVOs = new BkganDestOfcStupVO[infoVOs.length];
			System.arraycopy(infoVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}	
	
//	public void setInfoVOs(BkganDestOfcStupVO[] infoVOs) {
//		this.infoVOs = infoVOs;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setInfoVOs(BkganDestOfcStupVO[] infoVOs) {
		if (infoVOs != null) {
			BkganDestOfcStupVO[] tmpVOs = new BkganDestOfcStupVO[infoVOs.length];
			System.arraycopy(infoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.infoVOs = tmpVOs;
		}		
	}	
}
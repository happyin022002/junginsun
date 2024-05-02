/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0071Event.java
*@FileTitle : CndManifestListDownload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.SearchActualCustomerVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.ESM_BKG_0071HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0071 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0071HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김경섭
 * @see ESM_BKG_0071HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0190Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;

	public EsmBkg0190Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchActualCustomerVO infoVO = null;
	public SearchActualCustomerVO getInfoVO() {
		return infoVO;
	}

	public void setInfoVO(SearchActualCustomerVO infoVO) {
		this.infoVO = infoVO;
	}
	
	/** Table Value Object Multi Data 처리 */
	private SearchActualCustomerVO[] infoVOs = null;

	public SearchActualCustomerVO[] getInfoVOs() {
		SearchActualCustomerVO[] tmpVOs = null;
		if (this. infoVOs != null) {
			tmpVOs = Arrays.copyOf(infoVOs, infoVOs .length);
		}
		return tmpVOs;
	}

	public void setInfoVOs(SearchActualCustomerVO[] infoVOs) {
		if (infoVOs != null) {
			SearchActualCustomerVO[] tmpVOs = Arrays.copyOf(infoVOs, infoVOs .length);
			this. infoVOs = tmpVOs;
		}
	}

}
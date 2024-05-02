/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0953Event.java
*@FileTitle : O/B & T/S Loading Report by Location
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.TsLoadingRptByLocListInVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0953 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0953HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김경섭
 * @see ESM_BKG_0953HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0953Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmBkg0953Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private  TsLoadingRptByLocListInVO infoVO = null;

	/** Table Value Object Multi Data 처리 */
	private  TsLoadingRptByLocListInVO[] infoVOs = null;

	public TsLoadingRptByLocListInVO getInfoVO() {
		return infoVO;
	}

	public void setInfoVO(TsLoadingRptByLocListInVO infoVO) {
		this.infoVO = infoVO;
	}

	public TsLoadingRptByLocListInVO[] getInfoVOs() {
		TsLoadingRptByLocListInVO[] rtnVOs = null;
		if (this.infoVOs != null) {
			rtnVOs = Arrays.copyOf(infoVOs, infoVOs.length);
		}
		return rtnVOs;
	}

	public void setInfoVOs(TsLoadingRptByLocListInVO[] infoVOs) {
		if (infoVOs != null) {
			TsLoadingRptByLocListInVO[] tmpVOs = Arrays.copyOf(infoVOs, infoVOs.length);
			this.infoVOs = tmpVOs;
		}
	}

}
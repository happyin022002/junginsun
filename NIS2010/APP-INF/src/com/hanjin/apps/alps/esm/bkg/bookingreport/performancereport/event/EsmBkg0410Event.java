/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0410Event.java
*@FileTitle : Performance Report by Volume
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchDPCSVolListInVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0410 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0410HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김경섭
 * @see ESM_BKG_0410HTMLAction 참조
 * @since J2EE 1.5
 */

public class EsmBkg0410Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmBkg0410Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private   SearchDPCSVolListInVO  infoVO = null;

	/** Table Value Object Multi Data 처리 */
	private   SearchDPCSVolListInVO [] infoVOs = null;

	public SearchDPCSVolListInVO getInfoVO() {
		return infoVO;
	}

	public void setInfoVO(SearchDPCSVolListInVO infoVO) {
		this.infoVO = infoVO;
	}

	public SearchDPCSVolListInVO[] getInfoVOs() {
		SearchDPCSVolListInVO[] rtnVOs = null;
		if (this.infoVOs != null) {
			rtnVOs = Arrays.copyOf(infoVOs, infoVOs.length);
		}
		return rtnVOs;
	}

	public void setInfoVOs(SearchDPCSVolListInVO[] infoVOs){
		if(infoVOs != null){
			SearchDPCSVolListInVO[] tmpVOs = Arrays.copyOf(infoVOs, infoVOs.length);
			this.infoVOs = tmpVOs;
		}
	}


	
}
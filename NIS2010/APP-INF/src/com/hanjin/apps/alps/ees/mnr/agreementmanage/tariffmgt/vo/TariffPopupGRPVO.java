/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TariffPopupGRPVO.java
*@FileTitle : TariffPopupGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.06.10 김완규 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo;

import java.util.List;

/**
 * TariffPopup GROUP VO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *
 * @author 김완규
 * @since J2EE 1.5
 * @see
 */
public class TariffPopupGRPVO {
	//조회조건을 받기위한
	private TariffPopupINVO tariffPopupINVO= null;
	//단건 조회결과를 받기위한
	private List<CustomMnrRprTrfHdrVO> customMnrRprTrfHdrVOs = null;
	
	public TariffPopupINVO getTariffPopupINVO() {
		return tariffPopupINVO;
	}
	public void setTariffPopupINVO(TariffPopupINVO tariffPopupINVO) {
		this.tariffPopupINVO = tariffPopupINVO;
	}
	public List<CustomMnrRprTrfHdrVO> getCustomMnrRprTrfHdrVOs() {
		return customMnrRprTrfHdrVOs;
	}
	public void setCustomMnrRprTrfHdrVOs(
			List<CustomMnrRprTrfHdrVO> customMnrRprTrfHdrVOs) {
		this.customMnrRprTrfHdrVOs = customMnrRprTrfHdrVOs;
	}

}

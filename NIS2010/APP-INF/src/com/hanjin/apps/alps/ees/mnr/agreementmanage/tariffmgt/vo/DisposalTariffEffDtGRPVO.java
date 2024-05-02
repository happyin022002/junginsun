/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DisposalTariffGRPVO.java
*@FileTitle : DisposalTariffGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.06.10 권영법 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo;

import java.util.List;

/**
 * DisposalTariff GROUP VO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *
 * @author 권영법
 * @since J2EE 1.5
 * @see
 */
public class DisposalTariffEffDtGRPVO {
	//조회조건을 받기위한
	private DisposalTariffEffDtINVO disposalTariffEffDtINVO = null;
	//단건조회 결과를 받기위한
	private List<DisposalTariffEffDtListVO> disposalTariffEffDtListVOs = null;
	
	public DisposalTariffEffDtINVO getDisposalTariffEffDtINVO() {
		return disposalTariffEffDtINVO;
	}
	public void setDisposalTariffEffDtINVO(DisposalTariffEffDtINVO disposalTariffEffDtINVO) {
		this.disposalTariffEffDtINVO = disposalTariffEffDtINVO;
	}
	public List<DisposalTariffEffDtListVO> getDisposalTariffEffDtListVOs() {
		return disposalTariffEffDtListVOs;
	}
	public void setDisposalTariffEffDtListVOs(
			List<DisposalTariffEffDtListVO> disposalTariffEffDtListVOs) {
		this.disposalTariffEffDtListVOs = disposalTariffEffDtListVOs;
	}
}

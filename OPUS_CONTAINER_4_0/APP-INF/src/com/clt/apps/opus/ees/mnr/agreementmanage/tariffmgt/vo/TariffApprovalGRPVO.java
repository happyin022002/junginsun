/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TariffApprovalGRPVO.java
*@FileTitle : TariffApprovalGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.07.20 김완규 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo;

import java.util.List;

/**
 * TariffApprovalGRPVO GROUP VO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *
 * @author 김완규
 * @since J2EE 1.5
 * @see
 */
public class TariffApprovalGRPVO {
	//조회조건을 받기위한
	private TariffApprovalINVO tariffApprovalINVO= null;
	//조회 결과를 받기위한
	private List<CustomTariffApprovalVO> listCustomTariffApprovalVO = null;
	//CUD처리를 위한 
	private CustomTariffApprovalVO[] arrayCustomTariffApprovalVOs = null;
	public TariffApprovalINVO getTariffApprovalINVO() {
		return tariffApprovalINVO;
	}
	public void setTariffApprovalINVO(TariffApprovalINVO tariffApprovalINVO) {
		this.tariffApprovalINVO = tariffApprovalINVO;
	}
	public List<CustomTariffApprovalVO> getListCustomTariffApprovalVO() {
		return listCustomTariffApprovalVO;
	}
	public void setListCustomTariffApprovalVO(
			List<CustomTariffApprovalVO> listCustomTariffApprovalVO) {
		this.listCustomTariffApprovalVO = listCustomTariffApprovalVO;
	}
	public CustomTariffApprovalVO[] getArrayCustomTariffApprovalVOs() {
		return arrayCustomTariffApprovalVOs;
	}
	public void setArrayCustomTariffApprovalVOs(
			CustomTariffApprovalVO[] arrayCustomTariffApprovalVOs) {
		this.arrayCustomTariffApprovalVOs = arrayCustomTariffApprovalVOs;
	}
	
}

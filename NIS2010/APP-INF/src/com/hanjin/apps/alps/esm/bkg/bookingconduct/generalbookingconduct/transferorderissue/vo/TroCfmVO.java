package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * ESM_BKG_0079_02A 화면에서, 조회용 Container VO
 * @author 이남경
 * @since J2EE 1.5
 */
public class TroCfmVO {

	EurPayerVO            eurPayerVO       = null;
	List<TroListForCfmVO> troListForCfmVOs = new ArrayList<TroListForCfmVO>();

	/** Table Value Object Multi Data 처리 */
	private TroListForCfmVO[] arrTroListForCfmVO = null;

	/**
	 * @return the eurPayerVO
	 */
	public EurPayerVO getEurPayerVO() {
		return eurPayerVO;
	}

	/**
	 * @param eurPayerVO the eurPayerVO to set
	 */
	public void setEurPayerVO(EurPayerVO eurPayerVO) {
		this.eurPayerVO = eurPayerVO;
	}

	/**
	 * @return the troListForCfmVOs
	 */
	public List<TroListForCfmVO> getTroListForCfmVOs() {
		return troListForCfmVOs;
	}

	/**
	 * @param troListForCfmVOs the troListForCfmVOs to set
	 */
	public void setTroListForCfmVOs(List<TroListForCfmVO> troListForCfmVOs) {
		this.troListForCfmVOs = troListForCfmVOs;
	}

	/**
	 * @return the arrTroListForCfmVO
	 */
	public TroListForCfmVO[] getArrTroListForCfmVO() {
		return arrTroListForCfmVO;
	}

	/**
	 * @param arrTroListForCfmVO the arrTroListForCfmVO to set
	 */
	public void setArrTroListForCfmVO(TroListForCfmVO[] arrTroListForCfmVO) {
		this.arrTroListForCfmVO = arrTroListForCfmVO;
	}
}
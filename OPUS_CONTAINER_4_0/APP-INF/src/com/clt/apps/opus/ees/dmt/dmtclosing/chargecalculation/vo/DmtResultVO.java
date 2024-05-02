package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChrgDtlVO;
import com.clt.framework.component.common.AbstractValueObject;

public class DmtResultVO extends AbstractValueObject {

	private static final long serialVersionUID = 6034129996047509961L;

	private List<ChargeCalculationContainerVO> chargeCalculationContainerVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private ChargeCalculationContainerVO[] chargeCalculationContainerVOArray = null;
	
	/** ChrgDtlVO 처리 */
	private List<ChrgDtlVO> chrgDtlVOs = null;
	
	/** Etc Data 처리 */
	private Map<String, String> etcData = null;
	
	private String resultCode = null;
	private String resultMsg = null;
	
	
	
	@Override
	public HashMap<String, String> getColumnValues() {
		return null;
	}

	@Override
	public HashMap<String, String> getFieldNames() {
		return null;
	}
	
	
	
	/**
	 * @return the chargeCalculationContainerVOs
	 */
	public ChargeCalculationContainerVO[] getChargeCalculationContainerVOArray() {
		return chargeCalculationContainerVOArray;
	}
	
	/**
	 * @param chargeCalculationContainerVOs the chargeCalculationContainerVOs to set
	 */
	public void setChargeCalculationContainerVOArray(ChargeCalculationContainerVO[] chargeCalculationContainerVOArray) {
		this.chargeCalculationContainerVOArray = chargeCalculationContainerVOArray;
	}
	

	/**
	 * @return the chargeCalculationContainerVOs
	 */
	public List<ChargeCalculationContainerVO> getChargeCalculationContainerVOs() {
		return chargeCalculationContainerVOs;
	}

	/**
	 * @param chargeCalculationContainerVOs the chargeCalculationContainerVOs to set
	 */
	public void setChargeCalculationContainerVOs(
			List<ChargeCalculationContainerVO> chargeCalculationContainerVOs) {
		this.chargeCalculationContainerVOs = chargeCalculationContainerVOs;
	}

	/**
	 * @return the resultCode
	 */
	public String getResultCode() {
		return resultCode;
	}

	/**
	 * @param resultCode the resultCode to set
	 */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	/**
	 * @return the resultMsg
	 */
	public String getResultMsg() {
		return resultMsg;
	}

	/**
	 * @param resultMsg the resultMsg to set
	 */
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	/**
	 * @return the etcData
	 */
	public Map<String, String> getEtcData() {
		return etcData;
	}

	/**
	 * @param etcData the etcData to set
	 */
	public void setEtcData(Map<String, String> etcData) {
		this.etcData = etcData;
	}

	/**
	 * @return the chrgDtlVOs
	 */
	public List<ChrgDtlVO> getChrgDtlVOs() {
		return chrgDtlVOs;
	}

	/**
	 * @param chrgDtlVOs the chrgDtlVOs to set
	 */
	public void setChrgDtlVOs(List<ChrgDtlVO> chrgDtlVOs) {
		this.chrgDtlVOs = chrgDtlVOs;
	}

}

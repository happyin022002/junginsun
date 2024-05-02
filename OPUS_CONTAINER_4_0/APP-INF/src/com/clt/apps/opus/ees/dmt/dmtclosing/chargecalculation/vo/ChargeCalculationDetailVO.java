package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo;

import java.util.HashMap;
import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;

public class ChargeCalculationDetailVO extends AbstractValueObject {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6017254220928224406L;

	private List<ChargeBasicFreeTimeVO> chargeBasicFreeTimeVOs = null;
	
	private List<CommodityGroupTariffVO> commodityGroupTariffVOs = null;
	
	private List<BeforeExceptionTariffVO> beforeExceptionTariffVOs = null;
	
	private List<SCExceptionTariffVO> scExceptionTariffVOs = null;
	
	private List<AfterExceptionTariffVO> afterExceptionTariffVOs = null;
	
	private List<ClockStopVO> clockStopVOs = null;
	
	private ChargeDetailVO chargeDetailVO = null;
	
	
	@Override
	public HashMap<String, String> getColumnValues() {
		return null;
	}

	@Override
	public HashMap<String, String> getFieldNames() {
		return null;
	}

	/**
	 * @return the chargeBasicFreeTimeVOs
	 */
	public List<ChargeBasicFreeTimeVO> getChargeBasicFreeTimeVOs() {
		return chargeBasicFreeTimeVOs;
	}

	/**
	 * @param chargeBasicFreeTimeVOs the chargeBasicFreeTimeVOs to set
	 */
	public void setChargeBasicFreeTimeVOs(
			List<ChargeBasicFreeTimeVO> chargeBasicFreeTimeVOs) {
		this.chargeBasicFreeTimeVOs = chargeBasicFreeTimeVOs;
	}

	/**
	 * @return the commodityGroupTariffVOs
	 */
	public List<CommodityGroupTariffVO> getCommodityGroupTariffVOs() {
		return commodityGroupTariffVOs;
	}

	/**
	 * @param commodityGroupTariffVOs the commodityGroupTariffVOs to set
	 */
	public void setCommodityGroupTariffVOs(
			List<CommodityGroupTariffVO> commodityGroupTariffVOs) {
		this.commodityGroupTariffVOs = commodityGroupTariffVOs;
	}

	/**
	 * @return the beforeExceptionTariffVOs
	 */
	public List<BeforeExceptionTariffVO> getBeforeExceptionTariffVOs() {
		return beforeExceptionTariffVOs;
	}

	/**
	 * @param beforeExceptionTariffVOs the beforeExceptionTariffVOs to set
	 */
	public void setBeforeExceptionTariffVOs(
			List<BeforeExceptionTariffVO> beforeExceptionTariffVOs) {
		this.beforeExceptionTariffVOs = beforeExceptionTariffVOs;
	}

	/**
	 * @return the scExceptionTariffVOs
	 */
	public List<SCExceptionTariffVO> getScExceptionTariffVOs() {
		return scExceptionTariffVOs;
	}

	/**
	 * @param scExceptionTariffVOs the scExceptionTariffVOs to set
	 */
	public void setScExceptionTariffVOs(
			List<SCExceptionTariffVO> scExceptionTariffVOs) {
		this.scExceptionTariffVOs = scExceptionTariffVOs;
	}

	/**
	 * @return the afterExceptionTariffVOs
	 */
	public List<AfterExceptionTariffVO> getAfterExceptionTariffVOs() {
		return afterExceptionTariffVOs;
	}

	/**
	 * @param afterExceptionTariffVOs the afterExceptionTariffVOs to set
	 */
	public void setAfterExceptionTariffVOs(
			List<AfterExceptionTariffVO> afterExceptionTariffVOs) {
		this.afterExceptionTariffVOs = afterExceptionTariffVOs;
	}

	/**
	 * @return the clockStopVOs
	 */
	public List<ClockStopVO> getClockStopVOs() {
		return clockStopVOs;
	}

	/**
	 * @param clockStopVOs the clockStopVOs to set
	 */
	public void setClockStopVOs(List<ClockStopVO> clockStopVOs) {
		this.clockStopVOs = clockStopVOs;
	}

	/**
	 * @return the chargeDetailVO
	 */
	public ChargeDetailVO getChargeDetailVO() {
		return chargeDetailVO;
	}

	/**
	 * @param chargeDetailVO the chargeDetailVO to set
	 */
	public void setChargeDetailVO(ChargeDetailVO chargeDetailVO) {
		this.chargeDetailVO = chargeDetailVO;
	}

}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0002Event.java
*@FileTitle : Service Provider Help
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.06.03 박명종
* 1.0 Creation
*
* History
* 2010.11.24 CHM-201006949-01 박희동 특정 Tariff가 존재하는 Yard List를 조회한다.
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event;

import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.ConditionVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.PortTariffCodeGRPVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffBaseVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffDiscountVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffSurchargeVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_PSO-0212 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO-0212HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park MyoungJong
 * @see VOP_PSO-0212HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopPso0212Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private String ofcCd = "";//mdm_vendor의 pk인 vndr_seq값
	private String psoObjCd = "";
	private String types = "";	
	private String combo1  = "";
	private String vndrSeq = "";
	private String acctCd  = "";
	private String portCd = "";
	private String costCd = "";
	
	private TariffBaseVO[] tariffBaseVO = null;
	private TariffSurchargeVO[] tariffSurchargeVO = null;
	private TariffDiscountVO[] tariffDiscountVO = null;
	
	private ConditionVO[] baseCondition = null;
	private ConditionVO[] surchargeCondition = null;
	private ConditionVO[] discountCondition = null;
	
	private PortTariffCodeGRPVO portTariffCodeGRPVO = null;
	
	
	
	/**
	 * @param ofcCd the ofcCd to set
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	/**
	 * @return the ofcCd
	 */
	public String getOfcCd() {
		return ofcCd;
	}

	/**
	 * @param tariffBaseVO the tariffBaseVO to set
	 */
	public void setTariffBaseVO(TariffBaseVO[] tariffBaseVO){
		if (tariffBaseVO != null) {
			TariffBaseVO[] tmpVOs = new TariffBaseVO[tariffBaseVO .length];
			System.arraycopy(tariffBaseVO, 0, tmpVOs, 0, tmpVOs.length);
			this. tariffBaseVO = tmpVOs;
		}
	}
	/**
	 * @return the tariffBaseVO
	 */
	public TariffBaseVO[] getTariffBaseVO(){
		TariffBaseVO[] tmpVOs = null;
		if (this. tariffBaseVO != null) {
			tmpVOs = new TariffBaseVO[tariffBaseVO .length];
			System.arraycopy(tariffBaseVO, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	/**
	 * @param tariffSurchargeVO the tariffSurchargeVO to set
	 */

	public void setTariffSurchargeVO(TariffSurchargeVO[] tariffSurchargeVO){
		if (tariffSurchargeVO != null) {
			TariffSurchargeVO[] tmpVOs = new TariffSurchargeVO[tariffSurchargeVO .length];
			System.arraycopy(tariffSurchargeVO, 0, tmpVOs, 0, tmpVOs.length);
			this. tariffSurchargeVO = tmpVOs;
		}
	}
	
	/**
	 * @return the tariffSurchargeVO
	 */
	public TariffSurchargeVO[] getTariffSurchargeVO(){
		TariffSurchargeVO[] tmpVOs = null;
		if (this. tariffSurchargeVO != null) {
			tmpVOs = new TariffSurchargeVO[tariffSurchargeVO .length];
			System.arraycopy(tariffSurchargeVO, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	/**
	 * @param tariffDiscountVO the tariffDiscountVO to set
	 */
	public void setTariffDiscountVO(TariffDiscountVO[] tariffDiscountVO){
		if (tariffDiscountVO != null) {
			TariffDiscountVO[] tmpVOs = new TariffDiscountVO[tariffDiscountVO .length];
			System.arraycopy(tariffDiscountVO, 0, tmpVOs, 0, tmpVOs.length);
			this. tariffDiscountVO = tmpVOs;
		}
	}
	/**
	 * @return the tariffDiscountVO
	 */
	public TariffDiscountVO[] getTariffDiscountVO(){
		TariffDiscountVO[] tmpVOs = null;
		if (this. tariffDiscountVO != null) {
			tmpVOs = new TariffDiscountVO[tariffDiscountVO .length];
			System.arraycopy(tariffDiscountVO, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	/**
	 * @param psoObjCd the psoObjCd to set
	 */
	public void setPsoObjCd(String psoObjCd) {
		this.psoObjCd = psoObjCd;
	}
	/**
	 * @return the psoObjCd
	 */
	public String getPsoObjCd() {
		return psoObjCd;
	}
	/**
	 * @param types the types to set
	 */
	public void setTypes(String types) {
		this.types = types;
	}
	/**
	 * @return the types
	 */
	public String getTypes() {
		return types;
	}
	/**
	 * @param baseCondition the baseCondition to set
	 */
	public void setBaseCondition(ConditionVO[] baseCondition){
		if (baseCondition != null) {
			ConditionVO[] tmpVOs = new ConditionVO[baseCondition .length];
			System.arraycopy(baseCondition, 0, tmpVOs, 0, tmpVOs.length);
			this. baseCondition = tmpVOs;
		}
	}
	/**
	 * @return the baseCondition
	 */
    public ConditionVO[] getBaseCondition(){
		ConditionVO[] tmpVOs = null;
		if (this. baseCondition != null) {
			tmpVOs = new ConditionVO[baseCondition .length];
			System.arraycopy(baseCondition, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	/**
	 * @param surchargeCondition the surchargeCondition to set
	 */
    public void setSurchargeCondition(ConditionVO[] surchargeCondition){
		if (surchargeCondition != null) {
			ConditionVO[] tmpVOs = new ConditionVO[surchargeCondition .length];
			System.arraycopy(surchargeCondition, 0, tmpVOs, 0, tmpVOs.length);
			this. surchargeCondition = tmpVOs;
		}
	}
	/**
	 * @return the surchargeCondition
	 */
	public ConditionVO[] getSurchargeCondition(){
		ConditionVO[] tmpVOs = null;
		if (this. surchargeCondition != null) {
			tmpVOs = new ConditionVO[surchargeCondition .length];
			System.arraycopy(surchargeCondition, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	/**
	 * @param discountCondition the discountCondition to set
	 */
	public void setDiscountCondition(ConditionVO[] discountCondition){
		if (discountCondition != null) {
			ConditionVO[] tmpVOs = new ConditionVO[discountCondition .length];
			System.arraycopy(discountCondition, 0, tmpVOs, 0, tmpVOs.length);
			this. discountCondition = tmpVOs;
		}
	}
	/**
	 * @return the discountCondition
	 */
	public ConditionVO[] getDiscountCondition(){
		ConditionVO[] tmpVOs = null;
		if (this. discountCondition != null) {
			tmpVOs = new ConditionVO[discountCondition .length];
			System.arraycopy(discountCondition, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	/**
	 * @param portTariffCodeGRPVO the portTariffCodeGRPVO to set
	 */
	public void setPortTariffCodeGRPVO(PortTariffCodeGRPVO portTariffCodeGRPVO) {
		this.portTariffCodeGRPVO = portTariffCodeGRPVO;
	}
	/**
	 * @return the portTariffCodeGRPVO
	 */
	public PortTariffCodeGRPVO getPortTariffCodeGRPVO() {
		return portTariffCodeGRPVO;
	}
	/**
	 * @param combo1 the combo1 to set
	 */
	public void setCombo1(String combo1) {
		this.combo1 = combo1;
	}
	/**
	 * @return the combo1
	 */
	public String getCombo1() {
		return combo1;
	}
	/**
	 * @param vndrSeq the vndrSeq to set
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	/**
	 * @return the vndrSeq
	 */
	public String getVndrSeq() {
		return vndrSeq;
	}
	/**
	 * @param acctCd the acctCd to set
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	/**
	 * @return the acctCd
	 */
	public String getAcctCd() {
		return acctCd;
	}
	/**
	 * @return the portCd
	 */
	public String getPortCd() {
		return portCd;
	}
	/**
	 * @param portCd the portCd to set
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * @return the costCd
	 */
	public String getCostCd() {
		return costCd;
	}
	/**
	 * @param portCd the costCd to set
	 */
	public void setCostCd(String costCd) {
		this.costCd = costCd;
	}
	
}
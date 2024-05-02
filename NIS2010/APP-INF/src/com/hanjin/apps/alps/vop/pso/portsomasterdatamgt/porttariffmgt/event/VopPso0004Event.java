/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0004Event.java
*@FileTitle : Service Provider Help
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.06.03 박명종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event;

import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.ConditionVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.PortTariffCodeGRPVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffBaseVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffDiscountVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffSurchargeVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_PSO-0004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO-0004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park MyoungJong
 * @see VOP_PSO-0004HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopPso0004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private String ofcCd = "";//mdm_vendor의 pk인 vndr_seq값
	private String ydCd1 = "";
	private String psoObjCd = "";
	private String types = "";	
	private String portCd = "";		//[2009.10.05:jmh]	
	private String vndrSeq = "";	//[2009.10.05:jmh]	
	private String acctCd = "";		//[2009.10.05:jmh]	
	
	private TariffBaseVO[] tariffBaseVO = null;
	private TariffBaseVO[] tariffListVO = null;
	private TariffBaseVO[] objListVO = null;

	private TariffSurchargeVO[] tariffSurchargeVO = null;
	private TariffDiscountVO[] tariffDiscountVO = null;
	
	private ConditionVO[] baseCondition = null;
	private ConditionVO[] tariffCondition = null;
	private ConditionVO[] surchargeCondition = null;
	private ConditionVO[] discountCondition = null;
	
	private PortTariffCodeGRPVO portTariffCodeGRPVO = null;
	
	/*New*/
	private TariffBaseVO[] tariffBaseFomlCondVOs = null;	//Base : Formula, Condtion
	private TariffBaseVO[] tariffBaseRegValVOs = null;		//Base : Regular Value
	private TariffBaseVO[] tariffBaseVOs = null;			//Base : Total (sheet6)
	private TariffBaseVO[] tariffSurchargeVOs = null;		//Surcharge
	private TariffBaseVO[] tariffDiscountVOs = null;		//Discount
	
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
	 * @param ydCd1 the ydCd1 to set
	 */
	public void setYdCd1(String ydCd1) {
		this.ydCd1 = ydCd1;
	}
	/**
	 * @return the ydCd1
	 */
	public String getYdCd1() {
		return ydCd1;
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
		String ver = portTariffCodeGRPVO.getCombo5();
		portTariffCodeGRPVO.setCombo5( ver.substring( ver.indexOf("_")+1));
		this.portTariffCodeGRPVO = portTariffCodeGRPVO;
	}
	/**
	 * @return the portTariffCodeGRPVO
	 */
	public PortTariffCodeGRPVO getPortTariffCodeGRPVO() {
		return portTariffCodeGRPVO;
	}
	
	
	/**
	 * @return the tariffListVO
	 */

	public TariffBaseVO[] getTariffListVO(){
		TariffBaseVO[] tmpVOs = null;
		if (this. tariffListVO != null) {
			tmpVOs = new TariffBaseVO[tariffListVO .length];
			System.arraycopy(tariffListVO, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	/**
	 * @param tariffListVO the tariffListVO to set
	 */

	public void setTariffListVO(TariffBaseVO[] tariffListVO){
		if (tariffListVO != null) {
			TariffBaseVO[] tmpVOs = new TariffBaseVO[tariffListVO .length];
			System.arraycopy(tariffListVO, 0, tmpVOs, 0, tmpVOs.length);
			this. tariffListVO = tmpVOs;
		}
	}
	
	/**
	 * @param tariffCondition the tariffCondition to set
	 */
	public void setTariffCondition(ConditionVO[] tariffCondition){
		if (tariffCondition != null) {
			ConditionVO[] tmpVOs = new ConditionVO[tariffCondition .length];
			System.arraycopy(tariffCondition, 0, tmpVOs, 0, tmpVOs.length);
			this. tariffCondition = tmpVOs;
		}
	}
	
	/**
	 * @return the tariffCondition
	 */
	public ConditionVO[] getTariffCondition(){
		ConditionVO[] tmpVOs = null;
		if (this. tariffCondition != null) {
			tmpVOs = new ConditionVO[tariffCondition .length];
			System.arraycopy(tariffCondition, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	/**
	 * @param objListVO the objListVO to set
	 */
	public void setObjListVO(TariffBaseVO[] objListVO){
		if (objListVO != null) {
			TariffBaseVO[] tmpVOs = new TariffBaseVO[objListVO .length];
			System.arraycopy(objListVO, 0, tmpVOs, 0, tmpVOs.length);
			this. objListVO = tmpVOs;
		}
	}
	/**
	 * @return the objListVO
	 */
	
	public TariffBaseVO[] getObjListVO(){
		TariffBaseVO[] tmpVOs = null;
		if (this. objListVO != null) {
			tmpVOs = new TariffBaseVO[objListVO .length];
			System.arraycopy(objListVO, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
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
	 * @return the vndrSeq
	 */
	public String getVndrSeq() {
		return vndrSeq;
	}
	/**
	 * @param vndrSeq the vndrSeq to set
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	/**
	 * @return the acctCd
	 */
	public String getAcctCd() {
		return acctCd;
	}
	/**
	 * @param acctCd the acctCd to set
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	/**
	 * @return the tariffBaseVOs
	 */
	public TariffBaseVO[] getTariffBaseVOs(){
		TariffBaseVO[] tmpVOs = null;
		if (this. tariffBaseVOs != null) {
			tmpVOs = new TariffBaseVO[tariffBaseVOs .length];
			System.arraycopy(tariffBaseVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	} 
	/**
	 * @param tariffBaseVOs the tariffBaseVOs to set
	 */
	public void setTariffBaseVOs(TariffBaseVO[] tariffBaseVOs){
		if (tariffBaseVOs != null) {
			TariffBaseVO[] tmpVOs = new TariffBaseVO[tariffBaseVOs .length];
			System.arraycopy(tariffBaseVOs, 0, tmpVOs, 0, tmpVOs.length);
			this. tariffBaseVOs = tmpVOs;
		}
	}
	
	/**
	 * @return the tariffSurchargeVOs
	 */
	public TariffBaseVO[] getTariffSurchargeVOs(){
		TariffBaseVO[] tmpVOs = null;
		if (this. tariffSurchargeVOs != null) {
			tmpVOs = new TariffBaseVO[tariffSurchargeVOs .length];
			System.arraycopy(tariffSurchargeVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	/**
	 * @param tariffSurchargeVOs the tariffSurchargeVOs to set
	 */
	public void setTariffSurchargeVOs(TariffBaseVO[] tariffSurchargeVOs){
		if (tariffSurchargeVOs != null) {
			TariffBaseVO[] tmpVOs = new TariffBaseVO[tariffSurchargeVOs .length];
			System.arraycopy(tariffSurchargeVOs, 0, tmpVOs, 0, tmpVOs.length);
			this. tariffSurchargeVOs = tmpVOs;
		}
	}
	/**
	 * @return the tariffDiscountVOs
	 */
	public TariffBaseVO[] getTariffDiscountVOs(){
		TariffBaseVO[] tmpVOs = null;
		if (this. tariffDiscountVOs != null) {
			tmpVOs = new TariffBaseVO[tariffDiscountVOs .length];
			System.arraycopy(tariffDiscountVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	/**
	 * @param tariffDiscountVOs the tariffDiscountVOs to set
	 */
	public void setTariffDiscountVOs(TariffBaseVO[] tariffDiscountVOs){
		if (tariffDiscountVOs != null) {
			TariffBaseVO[] tmpVOs = new TariffBaseVO[tariffDiscountVOs .length];
			System.arraycopy(tariffDiscountVOs, 0, tmpVOs, 0, tmpVOs.length);
			this. tariffDiscountVOs = tmpVOs;
		}
	}
	/**
	 * @return the tariffBaseFomlCondVOs
	 */
	public TariffBaseVO[] getTariffBaseFomlCondVOs(){
		TariffBaseVO[] tmpVOs = null;
		if (this. tariffBaseFomlCondVOs != null) {
			tmpVOs = new TariffBaseVO[tariffBaseFomlCondVOs .length];
			System.arraycopy(tariffBaseFomlCondVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	/**
	 * @param tariffBaseFomlCondVOs the tariffBaseFomlCondVOs to set
	 */
	public void setTariffBaseFomlCondVOs(TariffBaseVO[] tariffBaseFomlCondVOs){
		if (tariffBaseFomlCondVOs != null) {
			TariffBaseVO[] tmpVOs = new TariffBaseVO[tariffBaseFomlCondVOs .length];
			System.arraycopy(tariffBaseFomlCondVOs, 0, tmpVOs, 0, tmpVOs.length);
			this. tariffBaseFomlCondVOs = tmpVOs;
		}
	}
	
	/**
	 * @return the tariffBaseRegValVOs
	 */
	public TariffBaseVO[] getTariffBaseRegValVOs(){
		TariffBaseVO[] tmpVOs = null;
		if (this. tariffBaseRegValVOs != null) {
			tmpVOs = new TariffBaseVO[tariffBaseRegValVOs .length];
			System.arraycopy(tariffBaseRegValVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	/**
	 * @param tariffBaseRegValVOs the tariffBaseRegValVOs to set
	 */
	public void setTariffBaseRegValVOs(TariffBaseVO[] tariffBaseRegValVOs){
		if (tariffBaseRegValVOs != null) {
			TariffBaseVO[] tmpVOs = new TariffBaseVO[tariffBaseRegValVOs .length];
			System.arraycopy(tariffBaseRegValVOs, 0, tmpVOs, 0, tmpVOs.length);
			this. tariffBaseRegValVOs = tmpVOs;
		}
	}
	
}
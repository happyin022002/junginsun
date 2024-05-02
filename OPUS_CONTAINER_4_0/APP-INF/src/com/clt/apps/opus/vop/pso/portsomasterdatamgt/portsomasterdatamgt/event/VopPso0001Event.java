/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0001Event.java
*@FileTitle : Default Setting 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.05.22 박명종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.event;


import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.DefaultCostVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.DefaultVendorVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.PsoInvOfcYdVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_PSO-0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO-0001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author myoungjong park
 * @see VOP_PSO-0001HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private String ofcCd = "";//mdm_vendor의 pk인 vndr_seq값
	private String ydCd1 = "";
	private String vndrSeq = "";
	private String chargeType = "";
	
	private PsoInvOfcYdVO[] psoInvOfcYdVO = null;
	private DefaultCostVO[] defaultCostVO = null;
	private DefaultVendorVO[] defaultVendorVO = null;


	/**
	 * @param psoInvOfcYdVO the psoInvOfcYdVO to set
	 */
	public void setPsoInvOfcYdVO(PsoInvOfcYdVO[] psoInvOfcYdVO) {
		if (psoInvOfcYdVO != null) {
			PsoInvOfcYdVO[] tmpVOs = new PsoInvOfcYdVO[psoInvOfcYdVO.length];
			System.arraycopy(psoInvOfcYdVO, 0, tmpVOs, 0, tmpVOs.length);
			this.psoInvOfcYdVO = tmpVOs;
		}
	}

	/**
	 * @return the psoInvOfcYdVO
	 */
	public PsoInvOfcYdVO[] getPsoInvOfcYdVO() {
		PsoInvOfcYdVO[] tmpVOs = null;
		if (this.psoInvOfcYdVO != null) {
			tmpVOs = new PsoInvOfcYdVO[psoInvOfcYdVO.length];
			System.arraycopy(psoInvOfcYdVO, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param defaultCostVO the defaultCostVO to set
	 */
	public void setDefaultCostVO(DefaultCostVO[] defaultCostVO) {
		if (defaultCostVO != null) {
			DefaultCostVO[] tmpVOs = new DefaultCostVO[defaultCostVO.length];
			System.arraycopy(defaultCostVO, 0, tmpVOs, 0, tmpVOs.length);
			this.defaultCostVO = tmpVOs;
		}
	}

	/**
	 * @return the defaultCostVO
	 */
	public DefaultCostVO[] getDefaultCostVO() {
		DefaultCostVO[] tmpVOs = null;
		if (this.defaultCostVO != null) {
			tmpVOs = new DefaultCostVO[defaultCostVO.length];
			System.arraycopy(defaultCostVO, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param defaultVendorVO the defaultVendorVO to set
	 */
	public void setDefaultVendorVO(DefaultVendorVO[] defaultVendorVO) {
		if (defaultVendorVO != null) {
			DefaultVendorVO[] tmpVOs = new DefaultVendorVO[defaultVendorVO.length];
			System.arraycopy(defaultVendorVO, 0, tmpVOs, 0, tmpVOs.length);
			this.defaultVendorVO = tmpVOs;
		}
	}

	/**
	 * @return the defaultVendorVO
	 */
	public DefaultVendorVO[] getDefaultVendorVO() {
		DefaultVendorVO[] tmpVOs = null;
		if (this.defaultVendorVO != null) {
			tmpVOs = new DefaultVendorVO[defaultVendorVO.length];
			System.arraycopy(defaultVendorVO, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

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
	 * @param chargeType the chargeType to set
	 */
	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	/**
	 * @return the chargeType
	 */
	public String getChargeType() {
		return chargeType;
	}

}
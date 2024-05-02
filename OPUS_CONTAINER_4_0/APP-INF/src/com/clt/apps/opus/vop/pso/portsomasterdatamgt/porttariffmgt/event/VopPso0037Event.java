/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0037Event.java
*@FileTitle : Tariff Value Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.23
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.12.23 정명훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event;

import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffValueMgtGRPVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YardChargeVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YdChgObjVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_PSO_0037 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO_0037HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeong Myounghun
 * @see VOP_PSO_0037HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0037Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private YardChargeVO yardChargeVO = null;
	private YdChgObjVO ydChgObjVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private YardChargeVO[] yardChargeVOs = null;
	private YdChgObjVO[] ydChgObjVOs = null;
	
	private TariffValueMgtGRPVO tariffValueMgtGRPVO = null;

	public VopPso0037Event(){}
	
	/**
	 * @return the yardChargeVOs
	 */
	public YardChargeVO[] getYardChargeVOs() {
		YardChargeVO[] tmpVOs = null;
		if (this.yardChargeVOs != null) {
			tmpVOs = new YardChargeVO[yardChargeVOs.length];
			System.arraycopy(yardChargeVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param yardChargeVOs the yardChargeVOs to set
	 */
	public void setYardChargeVOs(YardChargeVO[] yardChargeVOs) {
		if (yardChargeVOs != null) {
			YardChargeVO[] tmpVOs = new YardChargeVO[yardChargeVOs.length];
			System.arraycopy(yardChargeVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.yardChargeVOs = tmpVOs;
		}
	}

	/**
	 * @return the yardChargeVO
	 */
	public YardChargeVO getYardChargeVO() {
		return yardChargeVO;
	}

	/**
	 * @param yardChargeVO the yardChargeVO to set
	 */
	public void setYardChargeVO(YardChargeVO yardChargeVO) {
		this.yardChargeVO = yardChargeVO;
	}

	/**
	 * @return the ydChgObjVO
	 */
	public YdChgObjVO getYdChgObjVO() {
		return ydChgObjVO;
	}

	/**
	 * @param ydChgObjVO the ydChgObjVO to set
	 */
	public void setYdChgObjVO(YdChgObjVO ydChgObjVO) {
		this.ydChgObjVO = ydChgObjVO;
	}

	/**
	 * @return the ydChgObjVOs
	 */
	public YdChgObjVO[] getYdChgObjVOs() {
		YdChgObjVO[] tmpVOs = null;
		if (this.ydChgObjVOs != null) {
			tmpVOs = new YdChgObjVO[ydChgObjVOs.length];
			System.arraycopy(ydChgObjVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param ydChgObjVOs the ydChgObjVOs to set
	 */
	public void setYdChgObjVOs(YdChgObjVO[] ydChgObjVOs) {
		if (ydChgObjVOs != null) {
			YdChgObjVO[] tmpVOs = new YdChgObjVO[ydChgObjVOs.length];
			System.arraycopy(ydChgObjVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.ydChgObjVOs = tmpVOs;
		}
	}

	/**
	 * @return the tariffValueMgtGRPVO
	 */
	public TariffValueMgtGRPVO getTariffValueMgtGRPVO() {
		return tariffValueMgtGRPVO;
	}

	/**
	 * @param tariffValueMgtGRPVO the tariffValueMgtGRPVO to set
	 */
	public void setTariffValueMgtGRPVO(TariffValueMgtGRPVO tariffValueMgtGRPVO) {
		this.tariffValueMgtGRPVO = tariffValueMgtGRPVO;
	}

}
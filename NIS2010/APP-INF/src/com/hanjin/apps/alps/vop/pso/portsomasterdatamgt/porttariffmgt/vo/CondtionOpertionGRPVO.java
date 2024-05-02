package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo;

import java.util.List;

import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.PsoObjListVO;

public class CondtionOpertionGRPVO {
	private List<PsoObjListVO> psoobjlistvo = null;
	private List<CondtionOpertionVO> condtionOpertionVO = null;

	/**
	 * @return the psoobjlistvo
	 */
	public List<PsoObjListVO> getPsoobjlistvo() {
		return psoobjlistvo;
	}

	/**
	 * @param psoObjList
	 */
	public void setPsoobjlistvo(List<PsoObjListVO> psoObjList) {
		this.psoobjlistvo = psoObjList;
	}

	/**
	 * @param condtionOpertionVO the condtionOpertionVO to set
	 */
	public void setCondtionOpertionVO(List<CondtionOpertionVO> condtionOpertionVO) {
		this.condtionOpertionVO = condtionOpertionVO;
	}

	/**
	 * @return the condtionOpertionVO
	 */
	public List<CondtionOpertionVO> getCondtionOpertionVO() {
		return condtionOpertionVO;
	}

	
	
	
}

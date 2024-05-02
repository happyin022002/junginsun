package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event;

import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffAtchFileVO;
import com.hanjin.framework.support.layer.event.EventSupport;

public class VopPso0041Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public VopPso0041Event(){}

	/** Table Value Object 조회 조건 및 단건 처리  입력VO   */
	private TariffAtchFileVO tariffAtchFileVO = null;
	
	/**
	 * @return the tariffAtchFileVO
	 */
	public TariffAtchFileVO getTariffAtchFileVO() {
		return tariffAtchFileVO;
	}
	/**
	 * @param tariffAtchFileVO the tariffAtchFileVO to set
	 */
	public void setTariffAtchFileVO(TariffAtchFileVO tariffAtchFileVO) {
		this.tariffAtchFileVO = tariffAtchFileVO;
	}
	
}
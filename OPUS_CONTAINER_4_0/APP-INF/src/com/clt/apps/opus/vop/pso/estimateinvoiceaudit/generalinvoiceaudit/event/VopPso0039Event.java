/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VopPso0039Event.java
*@FileTitle : Tariff Simulation by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.15
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.06.10 진마리아
* 1.0 Creation
* 
* History
* 2011.06.15 진마리아 CHM-201111910-01 [PSO] Tariff Simulation By VVD 신규화면 생성 
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.event;

import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.TariffSimByVvdVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_PSO_0039 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO_0039HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeong Myounghun
 * @see VOP_PSO_0039HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0039Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TariffSimByVvdVO tariffSimByVvdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TariffSimByVvdVO[] tariffSimByVvdVOs = null;

	public TariffSimByVvdVO getTariffSimByVvdVO() {
		return tariffSimByVvdVO;
	}

	public void setTariffSimByVvdVO(TariffSimByVvdVO tariffSimByVvdVO) {
		this.tariffSimByVvdVO = tariffSimByVvdVO;
	}

	public TariffSimByVvdVO[] getTariffSimByVvdVOs() {
		TariffSimByVvdVO[] tmpVOs = null;
		if (this.tariffSimByVvdVOs != null) {
			tmpVOs = new TariffSimByVvdVO[tariffSimByVvdVOs.length];
			System.arraycopy(tariffSimByVvdVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setTariffSimByVvdVOs(TariffSimByVvdVO[] tariffSimByVvdVOs) {
		if (tariffSimByVvdVOs != null) {
			TariffSimByVvdVO[] tmpVOs = new TariffSimByVvdVO[tariffSimByVvdVOs.length];
			System.arraycopy(tariffSimByVvdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.tariffSimByVvdVOs = tmpVOs;
		}
	}

}
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0010Event.java
*@FileTitle : Commission Agreement Creation_Master
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.26
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.26 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.vo.AGNCommSimulationVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_ACM_0010HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0010Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AGNCommSimulationVO agnCommSimulationVO = null;

	/** Table Value Object Multi Data 처리 */
	private AGNCommSimulationVO[] agnCommSimulationVOs = null;

	public EsmAcm0010Event() {}

	public AGNCommSimulationVO getAGNCommSimulationVO() {
		return agnCommSimulationVO;
	}

	public void setAGNCommSimulationVO(AGNCommSimulationVO agnCommSimulationVO) {
		this.agnCommSimulationVO = agnCommSimulationVO;
	}

	public AGNCommSimulationVO[] getAGNCommSimulationVOs() {
		AGNCommSimulationVO[] rtnVOs = null;
		if (this.agnCommSimulationVOs != null) {
			rtnVOs = Arrays.copyOf(agnCommSimulationVOs, agnCommSimulationVOs.length);
		}
		return rtnVOs;
	}

	public void setAGNCommSimulationVOs(AGNCommSimulationVO[] agnCommSimulationVOs) {
		if(agnCommSimulationVOs != null){
			AGNCommSimulationVO[] tmpVOs = Arrays.copyOf(agnCommSimulationVOs, agnCommSimulationVOs.length);
			this.agnCommSimulationVOs  = tmpVOs;
		}
	}

}
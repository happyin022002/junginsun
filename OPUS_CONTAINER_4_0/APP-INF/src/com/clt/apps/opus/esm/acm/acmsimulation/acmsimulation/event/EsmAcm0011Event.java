/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0011Event.java
*@FileTitle : Agent Commission Simulation Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.05
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.06.05 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.vo.SimAgnRateMasterVO;
import com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.vo.SimAgnRateDetailVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_ACM_0011HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0011Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SimAgnRateMasterVO simAgnRateMasterVO = null;

	/** Table Value Object Multi Data 처리 */
	private SimAgnRateMasterVO[] simAgnRateMasterVOs = null;

	/** Table Value Object Multi Data 처리 */
	private SimAgnRateDetailVO[] simAgnRateDetailVOs = null;

	public EsmAcm0011Event() {}

	public SimAgnRateMasterVO getSimAgnRateMasterVO() {
		return simAgnRateMasterVO;
	}

	public void setSimAgnRateMasterVO(SimAgnRateMasterVO simAgnRateMasterVO) {
		this.simAgnRateMasterVO = simAgnRateMasterVO;
	}

	public SimAgnRateMasterVO[] getSimAgnRateMasterVOs() {
		SimAgnRateMasterVO[] rtnVOs = null;
		if (this.simAgnRateMasterVOs != null) {
			rtnVOs = Arrays.copyOf(simAgnRateMasterVOs, simAgnRateMasterVOs.length);
		}
		return rtnVOs;
	}

	public void setSimAgnRateMasterVOs(SimAgnRateMasterVO[] simAgnRateMasterVOs) {
		if(simAgnRateMasterVOs != null){
			SimAgnRateMasterVO[] tmpVOs = Arrays.copyOf(simAgnRateMasterVOs, simAgnRateMasterVOs.length);
			this.simAgnRateMasterVOs  = tmpVOs;
		}
	}

	public SimAgnRateDetailVO[] getSimAgnRateDetailVOs() {
		SimAgnRateDetailVO[] rtnVOs = null;
		if (this.simAgnRateDetailVOs != null) {
			rtnVOs = Arrays.copyOf(simAgnRateDetailVOs, simAgnRateDetailVOs.length);
		}
		return rtnVOs;
	}

	public void setSimAgnRateDetailVOs(
			SimAgnRateDetailVO[] simAgnRateDetailVOs) {
		if(simAgnRateDetailVOs != null){
			SimAgnRateDetailVO[] tmpVOs = Arrays.copyOf(simAgnRateDetailVOs, simAgnRateDetailVOs.length);
			this.simAgnRateDetailVOs  = tmpVOs;
		}
	}

}
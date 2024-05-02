/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0040Event.java
*@FileTitle : Object List
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.26
*@LastModifier : Lee Hye Min
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event;

import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.PsoObjListVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * VOP_PSO_0040 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO_0040HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Hye Min
 * @see VOP_PSO_0040HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0040Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PsoObjListVO psoObjListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PsoObjListVO[] psoObjListVOs = null;
	
	private String objNm = "";
	
	public VopPso0040Event(){}
	
	
	public PsoObjListVO getPsoObjListVO(){
		return psoObjListVO;
	}
	
	public void setPsoObjListVO(PsoObjListVO psoObjListVO){
		this. psoObjListVO = psoObjListVO;
	}

	public PsoObjListVO[] getPsoObjListVOS(){
		PsoObjListVO[] tmpVOs = null;
		if (this.psoObjListVOs != null) {
			tmpVOs = new PsoObjListVO[psoObjListVOs.length];
			System.arraycopy(psoObjListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public void setPsoObjListVOS(PsoObjListVO[] psoObjListVOs){
		if (psoObjListVOs != null) {
			PsoObjListVO[] tmpVOs = new PsoObjListVO[psoObjListVOs.length];
			System.arraycopy(psoObjListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.psoObjListVOs = tmpVOs;
		}
	}

	public void setObjNm(String objNm) {
		this.objNm = objNm;
	}

	public String getObjNm() {
		return objNm;
	}

	
}
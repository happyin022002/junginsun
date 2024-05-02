/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0106Event.java
*@FileTitle : Budget VSL SKD Deletion
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.10 진마리아
* 1.0 Creation
* 
* History
* 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.event;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ActivationVvdVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.VskVslSkdHisVO;

/**
 * VOP_VSK_0106 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0106HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Maria Chin
 * @see VOP_VSK_0106HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk0106Event extends EventSupport {

private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ActivationVvdVO activationVvdVO = null;
	
	private VskVslSkdHisVO vskVslSkdHisVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ActivationVvdVO[] activationVvdVOs = null;
	
	private VskVslSkdHisVO[] vskVslSkdHisVOs = null;

	public VopVsk0106Event(){}
	
	public void setActivationVvdVO(ActivationVvdVO activationVvdVO){
		this.activationVvdVO = activationVvdVO;
	}
	
	public void setVskVslSkdHisVO(VskVslSkdHisVO vskVslSkdHisVO){
		this.vskVslSkdHisVO = vskVslSkdHisVO;
	}

	public void setActivationVvdVOS(ActivationVvdVO[] activationVvdVOs){
		if(activationVvdVOs != null){
			ActivationVvdVO[] tmpVOs = new ActivationVvdVO[activationVvdVOs.length];
			System.arraycopy(activationVvdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.activationVvdVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.activationVvdVOs = activationVvdVOs;
	}
	
	public void setVskVslSkdHisVOS(VskVslSkdHisVO[] vskVslSkdHisVOs){
		if(vskVslSkdHisVOs != null){
			VskVslSkdHisVO[] tmpVOs = new VskVslSkdHisVO[vskVslSkdHisVOs.length];
			System.arraycopy(vskVslSkdHisVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vskVslSkdHisVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.vskVslSkdHisVOs = vskVslSkdHisVOs;
	}

	public ActivationVvdVO getActivationVvdVO(){
		return activationVvdVO;
	}
	
	public VskVslSkdHisVO getVskVslSkdHisVO(){
		return vskVslSkdHisVO;
	}

	public ActivationVvdVO[] getActivationVvdVOS(){
		ActivationVvdVO[] rtnVOs =  null;
		if(this.activationVvdVOs != null){
			rtnVOs = new ActivationVvdVO[activationVvdVOs.length];
			System.arraycopy(activationVvdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return activationVvdVOs;
	}
	
	public VskVslSkdHisVO[] getVskVslSkdHisVOS(){
		VskVslSkdHisVO[] rtnVOs =  null;
		if(this.vskVslSkdHisVOs != null){
			rtnVOs = new VskVslSkdHisVO[vskVslSkdHisVOs.length];
			System.arraycopy(vskVslSkdHisVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return vskVslSkdHisVOs;
	}

	private String crrCd = null;

	public String getCrrCd() {
		return crrCd;
	}

	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
}
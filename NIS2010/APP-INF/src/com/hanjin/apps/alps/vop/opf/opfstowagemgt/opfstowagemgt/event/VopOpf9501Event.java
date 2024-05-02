/*=========================================================
*@FileName : VopOpf9501Event.java
*Copyright(c) 2009 CyberLogitec
*@FileTitle : COD Approve Main Screen
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.03
*@LastModifier : 김도현
*@LastVersion : 1.0
* 2015.06.03 김도현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.vo.OpfStowageBayPlanListVO;

/**
 * VOP_OPF_9501 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_9501HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong Ock
 * @see VOP_OPF_9501HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf9501Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpfStowageBayPlanListVO opfStowageBayPlanListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OpfStowageBayPlanListVO[] opfStowageBayPlanListVOs = null;
	
	public VopOpf9501Event(){}
	
	public void setOpfStowageBayPlanListVO(OpfStowageBayPlanListVO opfStowageBayPlanListVO){
		this. opfStowageBayPlanListVO = opfStowageBayPlanListVO;
	}

	public void setOpfStowageBayPlanListVOS(OpfStowageBayPlanListVO[] opfStowageBayPlanListVOs){
		if (opfStowageBayPlanListVOs != null) {
			OpfStowageBayPlanListVO[] tmpVOs = new OpfStowageBayPlanListVO[opfStowageBayPlanListVOs.length];
			System.arraycopy(opfStowageBayPlanListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.opfStowageBayPlanListVOs = tmpVOs;
		}		
	}

	public OpfStowageBayPlanListVO getOpfStowageBayPlanListVO(){
		return opfStowageBayPlanListVO;
	}

	public OpfStowageBayPlanListVO[] getOpfStowageBayPlanListVOS(){
		OpfStowageBayPlanListVO[] rtnVOs = null;
		if (this.opfStowageBayPlanListVOs != null) {
			rtnVOs = new OpfStowageBayPlanListVO[opfStowageBayPlanListVOs.length];
			System.arraycopy(opfStowageBayPlanListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}
}

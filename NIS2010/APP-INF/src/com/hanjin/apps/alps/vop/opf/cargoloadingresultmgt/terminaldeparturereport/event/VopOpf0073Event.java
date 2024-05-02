/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VopOpf0073Event.java
*@FileTitle : Vessel Not Operationally Ready Report Summary Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0 
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event;

import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.OpfVnorSummaryVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 *  VOP_OPF_0071에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0071HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 이병훈
 * @see VOP_OPF_0071HTMLAction 참조 
 * @since J2EE 1.6
 */
public class VopOpf0073Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpfVnorSummaryVO opfVnorSummaryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OpfVnorSummaryVO[] opfVnorSummaryVOs = null;
	

	public VopOpf0073Event(){}
	

	public OpfVnorSummaryVO getOpfVnorSummaryVO(){
		return opfVnorSummaryVO;
	}
	
	public OpfVnorSummaryVO[] getOpfVnorSummaryVOs() {
		OpfVnorSummaryVO[] rtnVOs = null;
		if (this.opfVnorSummaryVOs != null) {
			rtnVOs = new OpfVnorSummaryVO[opfVnorSummaryVOs.length];
			System.arraycopy(opfVnorSummaryVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setOpfVnorSummaryVO(OpfVnorSummaryVO opfVnorSummaryVO){
		this.opfVnorSummaryVO = opfVnorSummaryVO;
	}
	
	public void setOpfVnorSummaryVOs(OpfVnorSummaryVO[] opfVnorSummaryVOs) {
		if (opfVnorSummaryVOs != null) {
			OpfVnorSummaryVO[] tmpVOs = new OpfVnorSummaryVO[opfVnorSummaryVOs.length];
			System.arraycopy(opfVnorSummaryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.opfVnorSummaryVOs = tmpVOs;
		}
	}
	
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0047Event.java
*@FileTitle : RDR Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.20
*@LastModifier : 원종규
*@LastVersion : 1.0
* 1.0 Creation
* 2013.11.25 임옥영 [CHM-201327237] [VOP-OPF] RDR Summary 메뉴 추가 
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRListOptionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSummaryVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RdrCreatInfoVO;


/**
 * VOP_OPF_0047 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0047HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SunyoungLee
 * @see VOP_OPF_0047HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf0047Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RDRListOptionVO rdrListOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RDRListOptionVO[] rdrListOptionVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RDRSummaryVO rDRSummaryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RDRSummaryVO[] rDRSummaryVOs = null;

	public VopOpf0047Event(){}
	
	public void setRDRListOptionVO(RDRListOptionVO rdrListOptionVO){
		this. rdrListOptionVO = rdrListOptionVO;
	}

	public void setRDRListOptionVOS(RDRListOptionVO[] rdrListOptionVOs){
		if (rdrListOptionVOs != null) {
			RDRListOptionVO[] tmpVOs = new RDRListOptionVO[rdrListOptionVOs.length];
			System.arraycopy(rdrListOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rdrListOptionVOs = tmpVOs;
		}
	}

	public RDRListOptionVO getRDRListOptionVO(){
		return rdrListOptionVO;
	}

	public RDRListOptionVO[] getRDRListOptionVOS(){
		RDRListOptionVO[] rtnVOs = null;
 		
 		if (this.rdrListOptionVOs != null) {
 			rtnVOs = new RDRListOptionVO[rdrListOptionVOs.length];
 			System.arraycopy(rdrListOptionVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}
	//
	public void setRDRSummaryVO(RDRSummaryVO rDRSummaryVO){
		this. rDRSummaryVO = rDRSummaryVO;
	}

	public void setRDRSummaryVOS(RDRSummaryVO[] rDRSummaryVOs){
		if (rDRSummaryVOs != null) {
			RDRSummaryVO[] tmpVOs = new RDRSummaryVO[rDRSummaryVOs.length];
			System.arraycopy(rDRSummaryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rDRSummaryVOs = tmpVOs;
		}		
	}

	public RDRSummaryVO getRDRSummaryVO(){
		return rDRSummaryVO;
	}

	public RDRSummaryVO[] getRDRSummaryVOS(){
		RDRSummaryVO[] rtnVOs = null;
 		
 		if (this.rDRSummaryVOs != null) {
 			rtnVOs = new RDRSummaryVO[rDRSummaryVOs.length];
 			System.arraycopy(rDRSummaryVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}
}
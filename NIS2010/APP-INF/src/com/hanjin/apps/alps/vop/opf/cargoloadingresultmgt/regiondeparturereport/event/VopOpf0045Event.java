/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0045Event.java
*@FileTitle : RDR Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.07.20 이선영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.PodComboVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRListOptionVO;


/**
 * VOP_OPF_0045 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0045HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SunyoungLee
 * @see VOP_OPF_0045HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf0045Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RDRListOptionVO rdrListOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RDRListOptionVO[] rdrListOptionVOs = null;

	public VopOpf0045Event(){}
	
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

}
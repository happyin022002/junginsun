/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VopScg5822Event.java
*@FileTitle : Application Request & Approval Status for Partner Lines - DG
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.09
*@LastModifier : Yona.Ha.
*@LastVersion : 1.0
* 2015.06.09 Yona.Ha.
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrRequestListOptionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_SCG_5822 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_5822HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yona.Ha.
 * @see VOP_SCG_5822HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg5822Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgPrnrRequestListOptionVO scgPrnrRequestListOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgPrnrRequestListOptionVO[] scgPrnrRequestListOptionVOs = null;

	public VopScg5822Event(){}
	
	public void setScgPrnrRequestListOptionVO(ScgPrnrRequestListOptionVO scgPrnrRequestListOptionVO){
		this.scgPrnrRequestListOptionVO = scgPrnrRequestListOptionVO;
	}

	public void setScgPrnrRequestListOptionVOS(ScgPrnrRequestListOptionVO[] scgPrnrRequestListOptionVOs){
		if(scgPrnrRequestListOptionVOs != null){
			ScgPrnrRequestListOptionVO[] tmpVOs = Arrays.copyOf(scgPrnrRequestListOptionVOs, scgPrnrRequestListOptionVOs.length);
			this.scgPrnrRequestListOptionVOs = tmpVOs;
		}
	}

	public ScgPrnrRequestListOptionVO getScgPrnrRequestListOptionVO(){
		return scgPrnrRequestListOptionVO;
	}

	public ScgPrnrRequestListOptionVO[] getScgPrnrRequestListOptionVOS(){
		ScgPrnrRequestListOptionVO[] rtnVOs = null;
		if (this.scgPrnrRequestListOptionVOs != null) {
			rtnVOs = Arrays.copyOf(scgPrnrRequestListOptionVOs, scgPrnrRequestListOptionVOs.length);
		}
		return rtnVOs;
	}
	

}
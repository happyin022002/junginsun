/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0023Event.java
*@FileTitle : SPCL CGO Approved Details
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.06.26 김현욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.ScgRequestListOptionVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstCgoVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ScgAuthorizationVO;


/**
 * VOP_SCG_0023 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0023HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HyunUk Kim
 * @see VOP_SCG_0023HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0023Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgRequestListOptionVO scgRequestListOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgAuthorizationVO[] scgAuthorizationVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgPrnrAproRqstCgoVO[] scgPrnrAproRqstCgoVOs = null;

	public VopScg0023Event(){}
	
	public void setScgRequestListOptionVO(ScgRequestListOptionVO scgRequestListOptionVO){
		this. scgRequestListOptionVO = scgRequestListOptionVO;
	}

	public void setScgAuthorizationVOS(ScgAuthorizationVO[] scgAuthorizationVOs){
		if(scgAuthorizationVOs != null){
			ScgAuthorizationVO[] tmpVOs = Arrays.copyOf(scgAuthorizationVOs, scgAuthorizationVOs.length);
			this.scgAuthorizationVOs = tmpVOs;
		}
	}
	
	public void setScgPrnrAproRqstCgoVOS(ScgPrnrAproRqstCgoVO[] scgPrnrAproRqstCgoVOs){
		if(scgPrnrAproRqstCgoVOs != null){
			ScgPrnrAproRqstCgoVO[] tmpVOs = Arrays.copyOf(scgPrnrAproRqstCgoVOs, scgPrnrAproRqstCgoVOs.length);
			this.scgPrnrAproRqstCgoVOs = tmpVOs;
		}
	}

	public ScgRequestListOptionVO getScgRequestListOptionVO(){
		return scgRequestListOptionVO;
	}

	public ScgAuthorizationVO[] getScgAuthorizationVOS(){
		ScgAuthorizationVO[] rtnVOs = null;
		if (this.scgAuthorizationVOs != null) {
			rtnVOs = Arrays.copyOf(scgAuthorizationVOs, scgAuthorizationVOs.length);
		}
		return rtnVOs;
	}
	
	public ScgPrnrAproRqstCgoVO[] getScgPrnrAproRqstCgoVOS(){
		ScgPrnrAproRqstCgoVO[] rtnVOs = null;
		if (this.scgPrnrAproRqstCgoVOs != null) {
			rtnVOs = Arrays.copyOf(scgPrnrAproRqstCgoVOs, scgPrnrAproRqstCgoVOs.length);
		}
		return rtnVOs;
	}

}
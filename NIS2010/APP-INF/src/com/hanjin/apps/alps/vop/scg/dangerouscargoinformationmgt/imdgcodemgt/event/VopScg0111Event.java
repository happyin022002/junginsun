/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VopScg0111Event.java
*@FileTitle : DG Cargo Package Selection
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.07
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2013.06.07 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstVO;


/**
 * VOP_AOM_0111 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_AOM_0111HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM HYUN HWA
 * @see VOP_SCG_0111HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0111Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgPrnrAproRqstVO scgPrnrAproRqstVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgPrnrAproRqstVO[] scgPrnrAproRqstVOs = null;
 
	public VopScg0111Event(){}
	
	public void setScgPrnrAproRqstVO(ScgPrnrAproRqstVO scgPrnrAproRqstVO){
		this. scgPrnrAproRqstVO = scgPrnrAproRqstVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgPrnrAproRqstVOS(ScgPrnrAproRqstVO[] scgPrnrAproRqstVOs){
		if (scgPrnrAproRqstVOs != null) {
			ScgPrnrAproRqstVO[] tmpVOs = new ScgPrnrAproRqstVO[scgPrnrAproRqstVOs.length];
			System.arraycopy(scgPrnrAproRqstVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgPrnrAproRqstVOs = tmpVOs;
		}
	}

	public ScgPrnrAproRqstVO getScgPrnrAproRqstVO(){
		return scgPrnrAproRqstVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgPrnrAproRqstVO[] getScgPrnrAproRqstVOS(){
		ScgPrnrAproRqstVO[] rtnVOs = null;
		if (this.scgPrnrAproRqstVOs != null) {
			rtnVOs = new ScgPrnrAproRqstVO[scgPrnrAproRqstVOs.length];
			System.arraycopy(scgPrnrAproRqstVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}
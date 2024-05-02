/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0024Event.java
*@FileTitle : Systematic Inspection Filtering Text
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.24
*@LastModifier : 김도현
*@LastVersion : 1.0
* 2015.06.24 김도현
* 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event;

import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.ScgNonDcgoRequestVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;


/**
 * VOP_SCG-0024 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG-0024HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VOP_SCG-0024HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0024Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgNonDcgoRequestVO scgNonDcgoRequestVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgNonDcgoRequestVO[] scgNonDcgoRequestVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmVslSvcLaneVO mdmVslSvcLaneVO = null;
	
	public VopScg0024Event(){}
	
	public void setScgNonDcgoRequestVO(ScgNonDcgoRequestVO scgNonDcgoRequestVO){
		this. scgNonDcgoRequestVO = scgNonDcgoRequestVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgNonDcgoRequestVOS(ScgNonDcgoRequestVO[] scgNonDcgoRequestVOs){
		if (scgNonDcgoRequestVOs != null) {
			ScgNonDcgoRequestVO[] tmpVOs = new ScgNonDcgoRequestVO[scgNonDcgoRequestVOs.length];
			System.arraycopy(scgNonDcgoRequestVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgNonDcgoRequestVOs = tmpVOs;
		}
	}

	public ScgNonDcgoRequestVO getScgNonDcgoRequestVO(){
		return scgNonDcgoRequestVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgNonDcgoRequestVO[] getScgNonDcgoRequestVOS(){
		ScgNonDcgoRequestVO[] rtnVOs = null;
		if (this.scgNonDcgoRequestVOs != null) {
			rtnVOs = new ScgNonDcgoRequestVO[scgNonDcgoRequestVOs.length];
			System.arraycopy(scgNonDcgoRequestVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public MdmVslSvcLaneVO getMdmVslSvcLaneVO() {
		return mdmVslSvcLaneVO;
	}

	public void setMdmVslSvcLaneVO(MdmVslSvcLaneVO mdmVslSvcLaneVO) {
		this.mdmVslSvcLaneVO = mdmVslSvcLaneVO;
	}
	
}
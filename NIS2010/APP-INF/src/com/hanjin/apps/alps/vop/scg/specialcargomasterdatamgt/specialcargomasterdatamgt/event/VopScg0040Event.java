/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VmsScg0040Event.java
*@FileTitle : Packing Group (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.07
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.07 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ScgImdgPckGrpVO;


/**
 * VMS_SCG-0040 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VMS_SCG-0040HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VMS_SCG-0040HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopScg0040Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgPckGrpVO scgImdgPckGrpVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgImdgPckGrpVO[] scgImdgPckGrpVOs = null;

	public VopScg0040Event(){}
	
	public void setScgImdgPckGrpVO(ScgImdgPckGrpVO scgImdgPckGrpVO){
		this. scgImdgPckGrpVO = scgImdgPckGrpVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgImdgPckGrpVOS(ScgImdgPckGrpVO[] scgImdgPckGrpVOs){
		if (scgImdgPckGrpVOs != null) {
			ScgImdgPckGrpVO[] tmpVOs = new ScgImdgPckGrpVO[scgImdgPckGrpVOs.length];
			System.arraycopy(scgImdgPckGrpVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgImdgPckGrpVOs = tmpVOs;
		}
	}

	public ScgImdgPckGrpVO getScgImdgPckGrpVO(){
		return scgImdgPckGrpVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgImdgPckGrpVO[] getScgImdgPckGrpVOS(){
		ScgImdgPckGrpVO[] rtnVOs = null;
		if (this.scgImdgPckGrpVOs != null) {
			rtnVOs = new ScgImdgPckGrpVO[scgImdgPckGrpVOs.length];
			System.arraycopy(scgImdgPckGrpVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}
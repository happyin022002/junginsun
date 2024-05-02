/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VmsScg0047Event.java
*@FileTitle : Compatibility Groups of Class 1 (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.08 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ScgImdgCompGrpVO;


/**
 * VMS_SCG-0047 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VMS_SCG-0047HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VMS_SCG-0047HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopScg0047Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgCompGrpVO scgImdgCompGrpVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgImdgCompGrpVO[] scgImdgCompGrpVOs = null;

	public VopScg0047Event(){}
	
	public void setScgImdgCompGrpVO(ScgImdgCompGrpVO scgImdgCompGrpVO){
		this. scgImdgCompGrpVO = scgImdgCompGrpVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgImdgCompGrpVOS(ScgImdgCompGrpVO[] scgImdgCompGrpVOs){
		if (scgImdgCompGrpVOs != null) {
			ScgImdgCompGrpVO[] tmpVOs = new ScgImdgCompGrpVO[scgImdgCompGrpVOs.length];
			System.arraycopy(scgImdgCompGrpVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgImdgCompGrpVOs = tmpVOs;
		}
	}

	public ScgImdgCompGrpVO getScgImdgCompGrpVO(){
		return scgImdgCompGrpVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgImdgCompGrpVO[] getScgImdgCompGrpVOS(){
		ScgImdgCompGrpVO[] rtnVOs = null;
		if (this.scgImdgCompGrpVOs != null) {
			rtnVOs = new ScgImdgCompGrpVO[scgImdgCompGrpVOs.length];
			System.arraycopy(scgImdgCompGrpVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}
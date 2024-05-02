/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VmsScg0041Event.java
*@FileTitle : Packing Group (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.07
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.07 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import java.util.Arrays;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ScgImdgSpclProviVO;


/**
 * VMS_SCG-0041 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VMS_SCG-0041HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VMS_SCG-0041HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopScg0041Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgSpclProviVO scgImdgSpclProviVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgImdgSpclProviVO[] scgImdgSpclProviVOs = null;

	public VopScg0041Event(){}
	
	public void setScgImdgSpclProviVO(ScgImdgSpclProviVO scgImdgSpclProviVO){
		this. scgImdgSpclProviVO = scgImdgSpclProviVO;
	}

	public void setScgImdgSpclProviVOS(ScgImdgSpclProviVO[] scgImdgSpclProviVOs){
		if(scgImdgSpclProviVOs != null){
			ScgImdgSpclProviVO[] tmpVOs = Arrays.copyOf(scgImdgSpclProviVOs, scgImdgSpclProviVOs.length);
			this.scgImdgSpclProviVOs = tmpVOs;
		}
	}

	public ScgImdgSpclProviVO getScgImdgSpclProviVO(){
		return scgImdgSpclProviVO;
	}

	public ScgImdgSpclProviVO[] getScgImdgSpclProviVOS(){
		ScgImdgSpclProviVO[] rtnVOs = null;
		if (this.scgImdgSpclProviVOs != null) {
			rtnVOs = Arrays.copyOf(scgImdgSpclProviVOs, scgImdgSpclProviVOs.length);
		}
		return rtnVOs;
	}

}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VmsScg0031Event.java
*@FileTitle : Load Reject Reason (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.04.28 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import com.hanjin.syscommon.common.table.ScgSpclPckProviVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ScgLodRjctCdVO;


/**
 * VMS_SCG-0031 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VMS_SCG-0031HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VMS_SCG-0031HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopScg010305Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgSpclPckProviVO scgSpclPckProviVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgSpclPckProviVO[] scgSpclPckProviVOs = null;

	public VopScg010305Event(){}
	
	public void setScgSpclPckProviVO(ScgSpclPckProviVO scgSpclPckProviVO){
		this.scgSpclPckProviVO = scgSpclPckProviVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgSpclPckProviVOS(ScgSpclPckProviVO[] scgSpclPckProviVOs){
		if (scgSpclPckProviVOs != null) {
			ScgSpclPckProviVO[] tmpVOs = new ScgSpclPckProviVO[scgSpclPckProviVOs.length];
			System.arraycopy(scgSpclPckProviVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgSpclPckProviVOs = tmpVOs;
		}
	}

	public ScgSpclPckProviVO getScgSpclPckProviVO(){
		return scgSpclPckProviVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgSpclPckProviVO[] getScgSpclPckProviVOS(){
		ScgSpclPckProviVO[] rtnVOs = null;
		if (this.scgSpclPckProviVOs != null) {
			rtnVOs = new ScgSpclPckProviVO[scgSpclPckProviVOs.length];
			System.arraycopy(scgSpclPckProviVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}
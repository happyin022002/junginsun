/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg1015Event.java
*@FileTitle : Application Request & Approval Status - DG
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.06.26 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event;

import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.ScgRequestListOptionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ScgAuthorizationVO;
import com.hanjin.syscommon.common.table.ScgDgCgoVO;
import com.hanjin.syscommon.common.table.ScgLodRjctCdVO;


/**
 * VOP_SCG-1015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG-1015HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VOP_SCG-1015HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg1015Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgRequestListOptionVO scgRequestListOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgRequestListOptionVO[] scgRequestListOptionVOs = null;

	public VopScg1015Event(){}
	
	public void setScgRequestListOptionVO(ScgRequestListOptionVO scgRequestListOptionVO){
		this. scgRequestListOptionVO = scgRequestListOptionVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgRequestListOptionVOS(ScgRequestListOptionVO[] scgRequestListOptionVOs){
		if (scgRequestListOptionVOs != null) {
			ScgRequestListOptionVO[] tmpVOs = new ScgRequestListOptionVO[scgRequestListOptionVOs.length];
			System.arraycopy(scgRequestListOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgRequestListOptionVOs = tmpVOs;
		}
	}

	public ScgRequestListOptionVO getScgRequestListOptionVO(){
		return scgRequestListOptionVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgRequestListOptionVO[] getScgRequestListOptionVOS(){
		ScgRequestListOptionVO[] rtnVOs = null;
		if (this.scgRequestListOptionVOs != null) {
			rtnVOs = new ScgRequestListOptionVO[scgRequestListOptionVOs.length];
			System.arraycopy(scgRequestListOptionVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	

}
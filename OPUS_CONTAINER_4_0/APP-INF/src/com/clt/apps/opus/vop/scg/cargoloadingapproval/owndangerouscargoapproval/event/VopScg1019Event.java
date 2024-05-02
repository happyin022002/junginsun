/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg1019Event.java
*@FileTitle : Application Request & Approval Status - DG
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.06.26 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.ScgRequestListOptionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ScgAuthorizationVO;
import com.clt.syscommon.common.table.ScgDgCgoVO;
import com.clt.syscommon.common.table.ScgLodRjctCdVO;


/**
 * VOP_SCG-1019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG-1019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VOP_SCG-1019HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg1019Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgRequestListOptionVO scgRequestListOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgRequestListOptionVO[] scgRequestListOptionVOs = null;

	public VopScg1019Event(){}
	
	public void setScgRequestListOptionVO(ScgRequestListOptionVO scgRequestListOptionVO){
		this. scgRequestListOptionVO = scgRequestListOptionVO;
	}

	public void setScgRequestListOptionVOS(ScgRequestListOptionVO[] scgRequestListOptionVOs){
		if(scgRequestListOptionVOs != null){
			ScgRequestListOptionVO[] tmpVOs = Arrays.copyOf(scgRequestListOptionVOs, scgRequestListOptionVOs.length);
			this.scgRequestListOptionVOs = tmpVOs;
		}
	}

	public ScgRequestListOptionVO getScgRequestListOptionVO(){
		return scgRequestListOptionVO;
	}

	public ScgRequestListOptionVO[] getScgRequestListOptionVOS(){
		ScgRequestListOptionVO[] rtnVOs = null;
		if (this.scgRequestListOptionVOs != null) {
			rtnVOs = Arrays.copyOf(scgRequestListOptionVOs, scgRequestListOptionVOs.length);
		}
		return rtnVOs;
	}
	

}
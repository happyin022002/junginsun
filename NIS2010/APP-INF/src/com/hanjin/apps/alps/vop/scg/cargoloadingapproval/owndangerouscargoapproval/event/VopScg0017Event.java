/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0017Event.java
*@FileTitle : Break-Bulk CGO Application Details for Own BKG
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.07.13 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ScgDgCgoVO;


/**
 * VOP_SCG-0017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG-0017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VOP_SCG-0017HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0017Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgDgCgoVO scgDgCgoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgDgCgoVO[] scgDgCgoVOs = null;

	public VopScg0017Event(){}
	
	public void setScgDgCgoVO(ScgDgCgoVO scgDgCgoVO){
		this. scgDgCgoVO = scgDgCgoVO;
	}

	//2013.12.23 Secure Coding 적용 [CWE-495]
	public void setScgDgCgoVOS(ScgDgCgoVO[] scgDgCgoVOs){
		if (scgDgCgoVOs != null) {
			ScgDgCgoVO[] tmpVOs = new ScgDgCgoVO[scgDgCgoVOs.length];
			System.arraycopy(scgDgCgoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgDgCgoVOs = tmpVOs;
		}
	}

	public ScgDgCgoVO getScgDgCgoVO(){
		return scgDgCgoVO;
	}

	//2013.12.23 Secure Coding 적용 [CWE-495]
	public ScgDgCgoVO[] getScgDgCgoVOS(){
		ScgDgCgoVO[] rtnVOs = null;
		if (this.scgDgCgoVOs != null) {
			rtnVOs = new ScgDgCgoVO[scgDgCgoVOs.length];
			System.arraycopy(scgDgCgoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}
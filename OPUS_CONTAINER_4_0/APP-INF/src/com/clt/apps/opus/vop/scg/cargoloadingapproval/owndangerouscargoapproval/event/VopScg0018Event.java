/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0018Event.java
*@FileTitle : Reefer CGO Application Details for Own BKG
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.07.13 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event;

import java.util.Arrays;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ScgDgCgoVO;


/**
 * VOP_SCG-0018 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG-0018HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VOP_SCG-0018HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0018Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgDgCgoVO scgDgCgoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgDgCgoVO[] scgDgCgoVOs = null;

	public VopScg0018Event(){}
	
	public void setScgDgCgoVO(ScgDgCgoVO scgDgCgoVO){
		this. scgDgCgoVO = scgDgCgoVO;
	}

	public void setScgDgCgoVOS(ScgDgCgoVO[] scgDgCgoVOs){
		if(scgDgCgoVOs != null){
			ScgDgCgoVO[] tmpVOs = Arrays.copyOf(scgDgCgoVOs, scgDgCgoVOs.length);
			this.scgDgCgoVOs = tmpVOs;
		}
	}

	public ScgDgCgoVO getScgDgCgoVO(){
		return scgDgCgoVO;
	}

	public ScgDgCgoVO[] getScgDgCgoVOS(){
		ScgDgCgoVO[] rtnVOs = null;
		if (this.scgDgCgoVOs != null) {
			rtnVOs = Arrays.copyOf(scgDgCgoVOs, scgDgCgoVOs.length);
		}
		return rtnVOs;
	}

}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0016Event.java
*@FileTitle : Awkward CGO Application Details for Own BKG
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.07.06 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event;

import java.util.Arrays;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ScgAwkCgoVO;


/**
 * VOP_SCG_0016 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0016HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VOP_SCG_0016HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0016Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgAwkCgoVO scgAwkCgoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgAwkCgoVO[] scgAwkCgoVOs = null;

	public VopScg0016Event(){}
	
	public void setScgAwkCgoVO(ScgAwkCgoVO scgAwkCgoVO){
		this. scgAwkCgoVO = scgAwkCgoVO;
	}

	public void setScgAwkCgoVOS(ScgAwkCgoVO[] scgAwkCgoVOs){
		if(scgAwkCgoVOs != null){
			ScgAwkCgoVO[] tmpVOs = Arrays.copyOf(scgAwkCgoVOs, scgAwkCgoVOs.length);
			this.scgAwkCgoVOs = tmpVOs;
		}
	}

	public ScgAwkCgoVO getScgAwkCgoVO(){
		return scgAwkCgoVO;
	}

	public ScgAwkCgoVO[] getScgAwkCgoVOS(){
		ScgAwkCgoVO[] rtnVOs = null;
		if (this.scgAwkCgoVOs != null) {
			rtnVOs = Arrays.copyOf(scgAwkCgoVOs, scgAwkCgoVOs.length);
		}
		return rtnVOs;
	}

}
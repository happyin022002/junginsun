/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0518Event.java
*@FileTitle : Draft & Weight
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.26
*@LastModifier : Lee Hye Min
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.DraftWeightListVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * VOP_VSK_0518 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0518HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Hye Min
 * @see VOP_VSK_0518HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk0518Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DraftWeightListVO draftWeightListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DraftWeightListVO[] draftWeightListVOs = null;
	
	public VopVsk0518Event(){}
	
	
	public DraftWeightListVO getDraftWeightListVO(){
		return draftWeightListVO;
	}
	
	public void setDraftWeightListVO(DraftWeightListVO draftWeightListVO){
		this. draftWeightListVO = draftWeightListVO;
	}

	public DraftWeightListVO[] getDraftWeightListVOS(){
		DraftWeightListVO[] rtnVOs = null;
		if (this.draftWeightListVOs != null) {
			rtnVOs = Arrays.copyOf(draftWeightListVOs, draftWeightListVOs.length);
		}
		return rtnVOs;
	}
	
	public void setDraftWeightListVOS(DraftWeightListVO[] draftWeightListVOs){
		if(draftWeightListVOs != null){
			DraftWeightListVO[] tmpVOs = Arrays.copyOf(draftWeightListVOs, draftWeightListVOs.length);
			this.draftWeightListVOs = tmpVOs;
		}
	}
	
}
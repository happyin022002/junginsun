/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VopScg5912Event.java
*@FileTitle : IMDG Item Booking Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.01
*@LastModifier : dongsoo
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.vo.ImdgItemBkgSummaryVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_SCG-5912 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG-5912HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author dongsoo
 * @see VOP_SCG-5912HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg5912Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public VopScg5912Event(){}
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ImdgItemBkgSummaryVO ImdgItemBkgSummaryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ImdgItemBkgSummaryVO[] ImdgItemBkgSummaryVOs = null;

	public ImdgItemBkgSummaryVO getImdgItemBkgSummaryVO() {
		return ImdgItemBkgSummaryVO;
	}

	public void setImdgItemBkgSummaryVO(ImdgItemBkgSummaryVO imdgItemBkgSummaryVO) {
		ImdgItemBkgSummaryVO = imdgItemBkgSummaryVO;
	}

	public ImdgItemBkgSummaryVO[] getImdgItemBkgSummaryVOs() {
		ImdgItemBkgSummaryVO[] rtnVOs = null;
		if (this.ImdgItemBkgSummaryVOs != null) {
			rtnVOs = Arrays.copyOf(ImdgItemBkgSummaryVOs, ImdgItemBkgSummaryVOs.length);
		}
		return rtnVOs;
	}

	public void setImdgItemBkgSummaryVOs(
			ImdgItemBkgSummaryVO[] imdgItemBkgSummaryVOs) {
		if(imdgItemBkgSummaryVOs != null){
			ImdgItemBkgSummaryVO[] tmpVOs = Arrays.copyOf(imdgItemBkgSummaryVOs, imdgItemBkgSummaryVOs.length);
			this.ImdgItemBkgSummaryVOs = tmpVOs;
		}
	}
	
}
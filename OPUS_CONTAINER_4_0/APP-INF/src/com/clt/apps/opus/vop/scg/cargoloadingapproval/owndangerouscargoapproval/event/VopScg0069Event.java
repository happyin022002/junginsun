/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0069Event.java
*@FileTitle : Pre Checking Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.07.23 김현욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionInputVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SpecialRequestVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * VOP_SCG_0069 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0069HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Hyun Uk
 * @see VOP_SCG_0069HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0069Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PreRestrictionInputVO preRestrictionInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PreRestrictionInputVO[] preRestrictionInputVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpecialRequestVO specialRequestVO = null;

	public VopScg0069Event(){}
	
	public void setPreRestrictionInputVO(PreRestrictionInputVO preRestrictionInputVO){
		this. preRestrictionInputVO = preRestrictionInputVO;
	}

	public void setPreRestrictionInputVOS(PreRestrictionInputVO[] preRestrictionInputVOs){
		if(preRestrictionInputVOs != null){
			PreRestrictionInputVO[] tmpVOs = Arrays.copyOf(preRestrictionInputVOs, preRestrictionInputVOs.length);
			this.preRestrictionInputVOs = tmpVOs;
		}
	}
	
	public void setSpecialRequestVO(SpecialRequestVO specialRequestVO){
		this. specialRequestVO = specialRequestVO;
	}

	public PreRestrictionInputVO getPreRestrictionInputVO(){
		return preRestrictionInputVO;
	}

	public PreRestrictionInputVO[] getPreRestrictionInputVOS(){
		PreRestrictionInputVO[] rtnVOs = null;
		if (this.preRestrictionInputVOs != null) {
			rtnVOs = Arrays.copyOf(preRestrictionInputVOs, preRestrictionInputVOs.length);
		}
		return rtnVOs;
	}
	
	public SpecialRequestVO getSpecialRequestVO(){
		return specialRequestVO;
	}

}
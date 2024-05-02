/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0021Event.java
*@FileTitle : Restrictions
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.06.26 김현욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.RestrictionInputVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_SCG_0021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HyunUk Kim
 * @see VOP_SCG_0021HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0021Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RestrictionInputVO restrictionInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RestrictionInputVO[] restrictionInputVOs = null;
	
	public VopScg0021Event(){}
	
	/**
	 * @return RestrictionInputVO
	 */
	public RestrictionInputVO getRestrictionInputVO() {
		return restrictionInputVO;
	}

	/**
	 * @return RestrictionInputVO[]
	 */
	public RestrictionInputVO[] getRestrictionInputVOS() {
		RestrictionInputVO[] rtnVOs = null;
		if (this.restrictionInputVOs != null) {
			rtnVOs = Arrays.copyOf(restrictionInputVOs, restrictionInputVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param RestrictionInputVO restrictionInputVO
	 */
	public void setRestrictionInputVO(RestrictionInputVO restrictionInputVO) {
		this.restrictionInputVO = restrictionInputVO;
	}

	/**
	 * @param RestrictionInputVO[] restrictionInputVOs
	 */
	public void setRestrictionInputVO(RestrictionInputVO[] restrictionInputVOs) {
		if(restrictionInputVOs != null){
			RestrictionInputVO[] tmpVOs = Arrays.copyOf(restrictionInputVOs, restrictionInputVOs.length);
			this.restrictionInputVOs = tmpVOs;
		}
	}

}
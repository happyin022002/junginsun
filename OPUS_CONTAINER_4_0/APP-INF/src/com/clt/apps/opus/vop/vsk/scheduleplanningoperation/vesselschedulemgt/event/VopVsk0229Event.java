/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0251Event.java
*@FileTitle : VopVsk0229Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.07.22 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.BkgListByVvdVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK_0229 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0229HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_VSK_0229HTMLAction 참조
 * @since J2EE 1.5
 */
public class VopVsk0229Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgListByVvdVO bkgListByVvdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgListByVvdVO[] bkgListByVvdVOs = null;

	public VopVsk0229Event(){}

	/**
	 * @return the pfLaneTypeVO
	 */
	public BkgListByVvdVO getBkgListByVvdVO() {
		return bkgListByVvdVO;
	}

	/**
	 * @param pfLaneTypeVO the pfLaneTypeVO to set
	 */
	public void setBkgListByVvdVO(BkgListByVvdVO bkgListByVvdVO) {
		this.bkgListByVvdVO = bkgListByVvdVO;
	}

	/**
	 * @return the pfLaneTypeVOs
	 */
	public BkgListByVvdVO[] getBkgListByVvdVOS() {
		BkgListByVvdVO[] rtnVOs = null;
		if (this.bkgListByVvdVOs != null) {
			rtnVOs = Arrays.copyOf(this.bkgListByVvdVOs, this.bkgListByVvdVOs.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param pfLaneTypeVOs the pfLaneTypeVOs to set
	 */
	public void setBkgListByVvdVOS(BkgListByVvdVO[] bkgListByVvdVOs) {
		if (bkgListByVvdVOs != null) {
			BkgListByVvdVO[] tmpVOs = Arrays.copyOf(bkgListByVvdVOs, bkgListByVvdVOs.length);
			this.bkgListByVvdVOs = tmpVOs;
		} // end if
	}
}
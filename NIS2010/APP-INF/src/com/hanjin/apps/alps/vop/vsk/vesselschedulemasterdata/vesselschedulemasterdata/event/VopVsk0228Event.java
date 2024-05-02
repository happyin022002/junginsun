/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0228Event.java
*@FileTitle : Lane Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : Ryu Hyuk
*@LastVersion : 1.0
* 2009.09.03 Ryu Hyuk
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.event;

import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.UserLaneGroupVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK_0228 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0228HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_VSK_0228HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk0228Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private UserLaneGroupVO userLaneGroupVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private UserLaneGroupVO[] userLaneGroupVOs = null;
	
	public VopVsk0228Event(){}

	/**
	 * @return UserLaneGroupVO
	 */
	public UserLaneGroupVO getUserLaneGroupVO() {
		return userLaneGroupVO;
	}

	/**
	 * @param userLaneGroupVO UserLaneGroupVO
	 */
	public void setUserLaneGroupVO(UserLaneGroupVO userLaneGroupVO) {
		this.userLaneGroupVO = userLaneGroupVO;
	}

	/**
	 * @return UserLaneGroupVO[]
	 */
	public UserLaneGroupVO[] getUserLaneGroupVOs() {
		UserLaneGroupVO[] rtnVOs =  null;
		if(this.userLaneGroupVOs != null){
			rtnVOs = new UserLaneGroupVO[userLaneGroupVOs.length];
			System.arraycopy(userLaneGroupVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return userLaneGroupVOs;
	}

	/**
	 * @param userLaneGroupVOs UserLaneGroupVO[]
	 */
	public void setUserLaneGroupVOs(UserLaneGroupVO[] userLaneGroupVOs) {
		if(userLaneGroupVOs != null){
			UserLaneGroupVO[] tmpVOs = new UserLaneGroupVO[userLaneGroupVOs.length];
			System.arraycopy(userLaneGroupVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.userLaneGroupVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this.userLaneGroupVOs = userLaneGroupVOs;
	}
	
}
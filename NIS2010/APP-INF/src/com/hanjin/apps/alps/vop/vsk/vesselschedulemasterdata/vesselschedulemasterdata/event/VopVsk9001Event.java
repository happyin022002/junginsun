/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk9001Event.java
*@FileTitle : Lane/Port Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.03
*@LastModifier : Lee Hyemin
*@LastVersion : 1.0
* 2012.08.03 Lee Hyemin
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.event;

import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.UserDefinedLanePortGroupVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK_9001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_9001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Hyemin
 * @see VOP_VSK_9001HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk9001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private UserDefinedLanePortGroupVO userDefinedLanePortGroupVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private UserDefinedLanePortGroupVO[] userDefinedLanePortGroupVOs = null;
	
	public VopVsk9001Event(){}

	/**
	 * @return UserDefinedLanePortGroupVO
	 */
	public UserDefinedLanePortGroupVO getUserDefinedLanePortGroupVO() {
		return userDefinedLanePortGroupVO;
	}

	/**
	 * @param userDefinedLanePortGroupVO UserDefinedLanePortGroupVO
	 */
	public void setUserDefinedLanePortGroupVO(UserDefinedLanePortGroupVO userDefinedLanePortGroupVO) {
		this.userDefinedLanePortGroupVO = userDefinedLanePortGroupVO;
	}

	/**
	 * @return UserDefinedLanePortGroupVO[]
	 */
	public UserDefinedLanePortGroupVO[] getUserDefinedLanePortGroupVOs() {
		UserDefinedLanePortGroupVO[] rtnVOs =  null;
		if(this.userDefinedLanePortGroupVOs != null){
			rtnVOs = new UserDefinedLanePortGroupVO[userDefinedLanePortGroupVOs.length];
			System.arraycopy(userDefinedLanePortGroupVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return userDefinedLanePortGroupVOs;
	}

	/**
	 * @param userDefinedLanePortGroupVOs UserDefinedLanePortGroupVO[]
	 */
	public void setUserDefinedLanePortGroupVOs(UserDefinedLanePortGroupVO[] userDefinedLanePortGroupVOs) {
		if(userDefinedLanePortGroupVOs != null){
			UserDefinedLanePortGroupVO[] tmpVOs = new UserDefinedLanePortGroupVO[userDefinedLanePortGroupVOs.length];
			System.arraycopy(userDefinedLanePortGroupVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.userDefinedLanePortGroupVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this.userDefinedLanePortGroupVOs = userDefinedLanePortGroupVOs;
	}
	
}
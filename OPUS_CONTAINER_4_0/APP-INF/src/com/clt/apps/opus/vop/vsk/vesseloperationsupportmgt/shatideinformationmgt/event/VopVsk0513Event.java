/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0513Event.java
*@FileTitle : SHA Tide Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.06 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.vo.SHATideInformationMgtConditionVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.vo.VskPortTideVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * VOP_VSK_0513 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0513HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong Ock
 * @see VOP_VSK_0513HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk0513Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VskPortTideVO vskPortTideVO = null;
	private SHATideInformationMgtConditionVO sHATideInformationMgtConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VskPortTideVO[] vskPortTideVOs = null;

	public VopVsk0513Event(){}
	
	public void setVskPortTideVO(VskPortTideVO vskPortTideVO){
		this. vskPortTideVO = vskPortTideVO;
	}

	public void setVskPortTideVOS(VskPortTideVO[] vskPortTideVOs){
		if(vskPortTideVOs != null){
			VskPortTideVO[] tmpVOs = Arrays.copyOf(vskPortTideVOs, vskPortTideVOs.length);
			this.vskPortTideVOs = tmpVOs;
		}
	}

	public VskPortTideVO getVskPortTideVO(){
		return vskPortTideVO;
	}

	public VskPortTideVO[] getVskPortTideVOS(){
		VskPortTideVO[] rtnVOs = null;
		if (this.vskPortTideVOs != null) {
			rtnVOs = Arrays.copyOf(vskPortTideVOs, vskPortTideVOs.length);
		}
		return rtnVOs;
	}

	public void setSHATideInformationMgtConditionVO(SHATideInformationMgtConditionVO sHATideInformationMgtConditionVO) {
		this.sHATideInformationMgtConditionVO = sHATideInformationMgtConditionVO;
	}
	
	public SHATideInformationMgtConditionVO getSHATideInformationMgtConditionVO() {
		return sHATideInformationMgtConditionVO;
	}	
}
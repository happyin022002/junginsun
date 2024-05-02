/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0514Event.java
*@FileTitle : SHA Tide Information Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.06 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.event;

import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.vo.SHATideInformationMgtConditionVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.vo.VskPortTideVO;
import com.hanjin.framework.support.layer.event.EventSupport;
//import com.hanjin.syscommon.common.table.VskPortTideVO;

/**
 * VOP_VSK_0514 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0514HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong Ock
 * @see VOP_VSK_0514HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk0514Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VskPortTideVO vskPortTideVO = null;
	private SHATideInformationMgtConditionVO sHATideInformationMgtConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VskPortTideVO[] vskPortTideVOs = null;

	public VopVsk0514Event(){}
	
	public void setVskPortTideVO(VskPortTideVO vskPortTideVO){
		this. vskPortTideVO = vskPortTideVO;
	}

	public void setVskPortTideVOS(VskPortTideVO[] vskPortTideVOs){
		if(vskPortTideVOs != null){
			VskPortTideVO[] tmpVOs = new VskPortTideVO[vskPortTideVOs.length];
			System.arraycopy(vskPortTideVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vskPortTideVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this. vskPortTideVOs = vskPortTideVOs;
	}

	public VskPortTideVO getVskPortTideVO(){
		return vskPortTideVO;
	}

	public VskPortTideVO[] getVskPortTideVOS(){
		VskPortTideVO[] rtnVOs =  null;
		if(this.vskPortTideVOs != null){
			rtnVOs = new VskPortTideVO[vskPortTideVOs.length];
			System.arraycopy(vskPortTideVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return vskPortTideVOs;
	}

	public void setSHATideInformationMgtConditionVO(SHATideInformationMgtConditionVO sHATideInformationMgtConditionVO) {
		this.sHATideInformationMgtConditionVO = sHATideInformationMgtConditionVO;
	}
	
	public SHATideInformationMgtConditionVO getSHATideInformationMgtConditionVO() {
		
		return sHATideInformationMgtConditionVO;
	}	
}
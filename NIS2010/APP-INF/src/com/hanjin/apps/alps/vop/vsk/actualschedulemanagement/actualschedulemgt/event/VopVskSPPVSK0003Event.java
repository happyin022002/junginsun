/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0027Event.java
*@FileTitle : Actual SKD Report Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.07.28 정진우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.event;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdMgtVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.hanjin.framework.support.layer.event.EventSupport;



/**
 *입력 대상 VVD에 Actual Port Schedule 정보 조회  (SPP)
 *
 * @author 서창열
 * @see vop_vsk_0027HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVskSPPVSK0003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ActSkdMgtVO actSkdMgtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ActSkdMgtVO[] actSkdMgtVOs = null;
	
	private List<ActSkdMgtVO>actSkdMgtVOS = null;

	public VopVskSPPVSK0003Event(){
		actSkdMgtVO = new ActSkdMgtVO();
		actSkdMgtVOS = new ArrayList<ActSkdMgtVO>();
	}

	/**
	 * @return the actSkdMgtVO
	 */
	public ActSkdMgtVO getActSkdMgtVO() {
		return actSkdMgtVO;
	}

	/**
	 * @param actSkdMgtVO the ActSkdMgtVO to set
	 */
	public void setActSkdMgtVO(ActSkdMgtVO actSkdMgtVO) {
		this.actSkdMgtVO = actSkdMgtVO;
	}

	/**
	 * @return the actSkdMgtVOs
	 */
	public ActSkdMgtVO[] getActSkdMgtVOs() {
		ActSkdMgtVO[] rtnVOs =  null;
		if(this.actSkdMgtVOs != null){
			rtnVOs = new ActSkdMgtVO[actSkdMgtVOs.length];
			System.arraycopy(actSkdMgtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return actSkdMgtVOs;
	}

	/**
	 * @param actSkdMgtVOs the actSkdMgtVOs to set
	 */
	public void setActSkdMgtVOs(ActSkdMgtVO[] actSkdMgtVOs) {
		if(actSkdMgtVOs != null){
			ActSkdMgtVO[] tmpVOs = new ActSkdMgtVO[actSkdMgtVOs.length];
			System.arraycopy(actSkdMgtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.actSkdMgtVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this.actSkdMgtVOs = actSkdMgtVOs;
	}
}
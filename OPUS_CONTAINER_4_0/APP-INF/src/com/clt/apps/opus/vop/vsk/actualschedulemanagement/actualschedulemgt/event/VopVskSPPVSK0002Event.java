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
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdMgtVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 *입력 대상 VVD에 Actual Port Schedule 정보 조회  (SPP)
 *
 * @author 서창열
 * @see vop_vsk_0027HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVskSPPVSK0002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ActSkdMgtVO actSkdMgtVO = null;
	private YardVO yardVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ActSkdMgtVO[] actSkdMgtVOs = null;
	private YardVO[] yardVOs = null;
	
	private List<ActSkdMgtVO>actSkdMgtVOS = null;

	public VopVskSPPVSK0002Event(){
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
	 * @return the yardVO
	 */
	public YardVO getYardVO() {
		return yardVO;
	}

	/**
	 * @param yardVO the yardVO to set
	 */
	public void setYardVO(YardVO yardVO) {
		this.yardVO = yardVO;
	}

	/**
	 * @return the actSkdMgtVOs
	 */
	public ActSkdMgtVO[] getActSkdMgtVOs() {
		ActSkdMgtVO[] rtnVOs = null;
		if (this.actSkdMgtVOs != null) {
			rtnVOs = Arrays.copyOf(actSkdMgtVOs, actSkdMgtVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param actSkdMgtVOs the actSkdMgtVOs to set
	 */
	public void setActSkdMgtVOs(ActSkdMgtVO[] actSkdMgtVOs) {
		if(actSkdMgtVOs != null){
			ActSkdMgtVO[] tmpVOs = Arrays.copyOf(actSkdMgtVOs, actSkdMgtVOs.length);
			this.actSkdMgtVOs = tmpVOs;
		}
	}
	
	/**
	 * @return the yardVOs
	 */
	public YardVO[] getYardVOs() {
		YardVO[] rtnVOs = null;
		if (this.yardVOs != null) {
			rtnVOs = Arrays.copyOf(yardVOs, yardVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param yardVOs the yardVOs to set
	 */
	public void setYardVOs(YardVO[] yardVOs) {
		if(yardVOs != null){
			YardVO[] tmpVOs = Arrays.copyOf(yardVOs, yardVOs.length);
			this.yardVOs = tmpVOs;
		}
	}
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0109Event.java
*@FileTitle : Movement Event Date List
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.29
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.01.29 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.MvntEvntDtVO;


/**
 * FNS_JOO_0109 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0109HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0109HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0109Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MvntEvntDtVO mvntEvntDtVO = null;

	/** Table Value Object Multi Data 처리 */
	private MvntEvntDtVO[] mvntEvntDtVOs = null;
	
	public FnsJoo0109Event(){}
	
	public void setMvntEvntDtVO(MvntEvntDtVO mvntEvntDtVO){		
		this. mvntEvntDtVO = mvntEvntDtVO;
	}

	public MvntEvntDtVO getMvntEvntDtVO(){
		return mvntEvntDtVO;
	}

	public MvntEvntDtVO[] getMvntEvntDtVOs() {
		
		MvntEvntDtVO[] rtnVOs = null;
		if (this.mvntEvntDtVOs != null) {
			rtnVOs = new MvntEvntDtVO[mvntEvntDtVOs.length];
			System.arraycopy(mvntEvntDtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;							
	}

	public void setMvntEvntDtVOs(MvntEvntDtVO[] mvntEvntDtVOs) {
		if (mvntEvntDtVOs != null) {
			MvntEvntDtVO[] tmpVOs = new MvntEvntDtVO[mvntEvntDtVOs.length];
			System.arraycopy(mvntEvntDtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mvntEvntDtVOs = tmpVOs;
		}						
	}
}
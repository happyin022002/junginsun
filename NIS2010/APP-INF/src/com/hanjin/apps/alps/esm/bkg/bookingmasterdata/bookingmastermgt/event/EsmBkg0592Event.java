/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0592Event.java
*@FileTitle : User Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.25 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgDpcsUsrGrpVO;


/**
 * ESM_BKG_0592 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0592HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0592HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0592Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String usrId = null;
	private String dpcsWrkGrpCd = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgDpcsUsrGrpVO bkgDpcsUsrGrpVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgDpcsUsrGrpVO[] bkgDpcsUsrGrpVOs = null;

	public EsmBkg0592Event(){}
	
	/**
	 * @return the usrId
	 */
	public String getUsrId() {
		return usrId;
	}
	/**
	 * @param usrId the usrId to set
	 */
	public void setUsrId(String usr_id) {
		this.usrId = usr_id;
	}
	
	/**
	 * @return the dpcsWrkGrpCd
	 */
	public String getDpcsWrkGrpCd() {
		return dpcsWrkGrpCd;
	}
	/**
	 * @param dpcsWrkGrpCd the dpcsWrkGrpCd to set
	 */
	public void setDpcsWrkGrpCd(String dpcs_wrk_grp_cd) {
		this.dpcsWrkGrpCd = dpcs_wrk_grp_cd;
	}
	
	public void setBkgDpcsUsrGrpVO(BkgDpcsUsrGrpVO bkgDpcsUsrGrpVO){
		this. bkgDpcsUsrGrpVO = bkgDpcsUsrGrpVO;
	}

	public void setBkgDpcsUsrGrpVOS(BkgDpcsUsrGrpVO[] bkgDpcsUsrGrpVOs){
		this. bkgDpcsUsrGrpVOs = bkgDpcsUsrGrpVOs;
	}

	public BkgDpcsUsrGrpVO getBkgDpcsUsrGrpVO(){
		return bkgDpcsUsrGrpVO;
	}

	public BkgDpcsUsrGrpVO[] getBkgDpcsUsrGrpVOS(){
		return bkgDpcsUsrGrpVOs;
	}

}
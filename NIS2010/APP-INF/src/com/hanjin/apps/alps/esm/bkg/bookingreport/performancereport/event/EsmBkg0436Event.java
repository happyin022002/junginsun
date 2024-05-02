/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0436Event.java
*@FileTitle :Doc. user 를  조회합니다.
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.28
*@LastModifier : 금병주
*@LastVersion : 1.0
* 2011.11.28 금병주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgDpcsUsrGrpVO;


/**
 * ESM_BKG_0436 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0436HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Keum Byoung Joo
 * @see ESM_BKG_0436HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0436Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String usrId = null;
	private String dpcsWrkGrpCd = null;
	private String rgnOfcCd = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgDpcsUsrGrpVO bkgDpcsUsrGrpVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgDpcsUsrGrpVO[] bkgDpcsUsrGrpVOs = null;

	public EsmBkg0436Event(){}
	
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
	 * @return the rgnOfcCd
	 */
	public String getRgnOfcCd() {
		return rgnOfcCd;
	}
	/**
	 * @param usrId the usrId to rgnOfcCd
	 */
	public void setRgnOfcCd(String rgnOfcCd) {
		this.rgnOfcCd = rgnOfcCd;
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
		if(bkgDpcsUsrGrpVOs != null){
			BkgDpcsUsrGrpVO[] tmpVOs = Arrays.copyOf(bkgDpcsUsrGrpVOs, bkgDpcsUsrGrpVOs.length);
			this.bkgDpcsUsrGrpVOs = tmpVOs;
		}
	}

	public BkgDpcsUsrGrpVO getBkgDpcsUsrGrpVO(){
		return bkgDpcsUsrGrpVO;
	}

	public BkgDpcsUsrGrpVO[] getBkgDpcsUsrGrpVOS(){
		BkgDpcsUsrGrpVO[] rtnVOs = null;
		if (this.bkgDpcsUsrGrpVOs != null) {
			rtnVOs = Arrays.copyOf(bkgDpcsUsrGrpVOs, bkgDpcsUsrGrpVOs.length);
		}
		return rtnVOs;
	}

}
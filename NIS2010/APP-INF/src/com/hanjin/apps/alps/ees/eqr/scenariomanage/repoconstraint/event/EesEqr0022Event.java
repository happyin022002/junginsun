/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0022Event.java
*@FileTitle : Empty Repo Constraint 조회/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-03
*@LastModifier : ChungEunHo
*@LastVersion : 1.0
* 2006-11-03 ChungEunHo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.repoconstraint.event;


import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.syscommon.common.table.EqrScnrRepoCnstVO;


/**
 * EES_EQR_0022 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_EQR_0022HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChangHoChae
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesEqr0022Event extends EventSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	EqrScnrRepoCnstVO eqrScnrRepoCnstVO = null;
	EqrScnrRepoCnstVO[] eqrScnrRepoCnstVOS = null;

	private String cnsttype = "";

	private String maxInfoTable = "";
   	private String maxInfoCondition = "";
   	
	// Scenario ID
	private String scnrid   = "";
	
	private String tpsz = "";

	public EesEqr0022Event(){}

	/**
	 * 
	 * @param eqr_scnr_repo_cnst
	 */
	public EesEqr0022Event(EqrScnrRepoCnstVO eqr_scnr_repo_cnst) {
		this.eqrScnrRepoCnstVO = eqr_scnr_repo_cnst;
    }
	/**
	 * 
	 * @param eqr_scnr_repo_cnst
	 * @param eqr_scnr_repo_cnsts
	 */
	public EesEqr0022Event(EqrScnrRepoCnstVO eqr_scnr_repo_cnst, EqrScnrRepoCnstVO[] eqr_scnr_repo_cnsts) {
		this.eqrScnrRepoCnstVO = eqr_scnr_repo_cnst;
		this.eqrScnrRepoCnstVOS = eqr_scnr_repo_cnsts;
    }
	/**
	 * 
	 * @param eqr_scnr_repo_cnsts
	 * @param cnsttype
	 * @param scnrid
	 */
	public EesEqr0022Event(EqrScnrRepoCnstVO[]  eqr_scnr_repo_cnsts, String cnsttype, String scnrid) {
		this.eqrScnrRepoCnstVOS = eqr_scnr_repo_cnsts;
		this.cnsttype = cnsttype;
		this.scnrid = scnrid;
    }
	/**
	 * 
	 * @param eqr_scnr_repo_cnsts
	 * @param cnsttype
	 * @param scnrid
	 * @param tpsz
	 */
	public EesEqr0022Event(EqrScnrRepoCnstVO[]  eqr_scnr_repo_cnsts, String cnsttype, String scnrid, String tpsz) {
		this.eqrScnrRepoCnstVOS = eqr_scnr_repo_cnsts;
		this.cnsttype = cnsttype;
		this.scnrid = scnrid;
		this.tpsz = tpsz;
    }
	

	public String getCnsttype() {
		return cnsttype;
	}
	
	public String getScnrid() {
		return scnrid;
	}
	
	
	public String getMaxInfoTable() {
		return maxInfoTable;
	}
	
	public String getMaxInfoCondition() {
		return maxInfoCondition;
	}
	
	public void setMaxInfoTable(String maxInfoTable) {
		this.maxInfoTable = maxInfoTable;
	}
	
	public void setMaxInfoCondition(String maxInfoCondition) {
		this.maxInfoCondition = maxInfoCondition;
	}
	
	/**
	 * @return Returns the tpsz.
	 */
	public String getTpsz() {
		return tpsz;
	}

	/**
	 * @param tpsz The tpsz to set.
	 */
	public void setTpsz(String tpsz) {
		this.tpsz = tpsz;
	}

	public EqrScnrRepoCnstVO getEqrScnrRepoCnstVO() {
		return eqrScnrRepoCnstVO;
	}

	public void setEqrScnrRepoCnstVO(EqrScnrRepoCnstVO eqrScnrRepoCnstVO) {
		this.eqrScnrRepoCnstVO = eqrScnrRepoCnstVO;
	}

	public EqrScnrRepoCnstVO[] getEqrScnrRepoCnstVOS() {
		return eqrScnrRepoCnstVOS;
	}

	public void setEqrScnrRepoCnstVOS(EqrScnrRepoCnstVO[] eqrScnrRepoCnstVOS) {
		this.eqrScnrRepoCnstVOS = eqrScnrRepoCnstVOS;
	}
	

}
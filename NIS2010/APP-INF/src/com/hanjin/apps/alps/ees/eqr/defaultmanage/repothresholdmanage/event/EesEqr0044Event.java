/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0044Event.java
*@FileTitle : Red Light Alert 기준 조회/수정---컨테이너 이송 계획
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	yongchan shin		2006-09-26		1.0 최초 생성
* 2      	1.0      	Lee Byoung Hun	2009.07.17		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.07.17
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.07.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrRepoPlnRedLgtAltDtlVO;
import com.hanjin.syscommon.common.table.EqrRepoPlnRedLgtAltMstVO;


/**
 * EES_EQR_0044 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0044HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_0044HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0044Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object Multi Data 처리 */
	public EqrRepoPlnRedLgtAltMstVO[] eqrRepoPlnRedLgtAltMstVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqrRepoPlnRedLgtAltDtlVO[] eqrRepoPlnRedLgtAltDtlVOs = null;
	
	private String rccCd = null;
	
	private String tpsz = null;

	public EesEqr0044Event(){}

	public void setEqrRepoPlnRedLgtAltMstVOS(EqrRepoPlnRedLgtAltMstVO[] eqrRepoPlnRedLgtAltMstVOs){
		this. eqrRepoPlnRedLgtAltMstVOs = eqrRepoPlnRedLgtAltMstVOs;
	}

	public EqrRepoPlnRedLgtAltMstVO[] getEqrRepoPlnRedLgtAltMstVOS(){
		return eqrRepoPlnRedLgtAltMstVOs;
	}
	
	public void setEqrRepoPlnRedLgtAltDtlVOS(EqrRepoPlnRedLgtAltDtlVO[] eqrRepoPlnRedLgtAltDtlVOs){
		this. eqrRepoPlnRedLgtAltDtlVOs = eqrRepoPlnRedLgtAltDtlVOs;
	}

	public EqrRepoPlnRedLgtAltDtlVO[] getEqrRepoPlnRedLgtAltDtlVOS(){
		return eqrRepoPlnRedLgtAltDtlVOs;
	}

	/**
	 * @return the rccCd
	 */
	public String getRccCd() {
		return rccCd;
	}

	/**
	 * @param rccCd the rccCd to set
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
	}

	/**
	 * @return the tpsz
	 */
	public String getTpsz() {
		return tpsz;
	}

	/**
	 * @param tpsz the tpsz to set
	 */
	public void setTpsz(String tpsz) {
		this.tpsz = tpsz;
	}

}
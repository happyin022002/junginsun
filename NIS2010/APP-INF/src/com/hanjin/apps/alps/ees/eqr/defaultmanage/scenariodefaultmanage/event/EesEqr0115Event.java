/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0115Event.java
*@FileTitle : ECC 정보 조회/수정
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Lee Byoung Hun	2009.07.10		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.06.30
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.06.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrEccMstVO;
import com.hanjin.syscommon.common.table.EqrTsTmlVO;


/**
 * EES_EQR_0115 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0115HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_0115HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0115Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object Multi Data 처리 */
	public EqrEccMstVO[] eqrEccMstVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqrTsTmlVO[] eqrTsTmlVOs = null;
	
	private String status = null;
	
	private String location = null;
	
	private String eccCd = null;
	
	/**
	 * Default Constructor
	 */
	public EesEqr0115Event(){}

	/**
	 * @return the eccCd
	 */
	public String getEccCd() {
		return eccCd;
	}

	/**
	 * @param eccCd the eccCd to set
	 */
	public void setEccCd(String eccCd) {
		this.eccCd = eccCd;
	}

	/**
	 * @return the statue
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param statue the statue to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the eqrEccMstVOs
	 */
	public EqrEccMstVO[] getEqrEccMstVOS() {
		return eqrEccMstVOs;
	}

	/**
	 * @param eqrEccMstVOs the eqrEccMstVOs to set
	 */
	public void setEqrEccMstVOS(EqrEccMstVO[] eqrEccMstVOs) {
		this.eqrEccMstVOs = eqrEccMstVOs;
	}

	/**
	 * @return the eqrTsTmlVOs
	 */
	public EqrTsTmlVO[] getEqrTsTmlVOS() {
		return eqrTsTmlVOs;
	}

	/**
	 * @param eqrTsTmlVOs the eqrTsTmlVOs to set
	 */
	public void setEqrTsTmlVOS(EqrTsTmlVO[] eqrTsTmlVOs) {
		this.eqrTsTmlVOs = eqrTsTmlVOs;
	}

}
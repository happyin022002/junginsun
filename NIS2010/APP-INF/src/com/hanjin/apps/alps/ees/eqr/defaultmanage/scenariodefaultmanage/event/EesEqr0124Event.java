/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0124Event.java
*@FileTitle : S
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.07.13 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrRepoCnstVO;


/**
 * EES_EQR_124 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_124HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Haeng-ji,Lee
 * @see EES_EQR_0124HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0124Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private String cnsttype = null;
	private String tpsztype = null;
	
	public String getTpsztype() {
		return tpsztype;
	}

	public void setTpsztype(String tpsztype) {
		this.tpsztype = tpsztype;
	}

	public String getCnsttype() {
		return cnsttype;
	}

	public void setCnsttype(String cnsttype) {
		this.cnsttype = cnsttype;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private EqrRepoCnstVO eqrRepoCnstVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqrRepoCnstVO[] eqrRepoCnstVOs = null;

	public EesEqr0124Event(){}
	
	/**
	 * 검색조건이 4개 이하라서 Event에 Setting..
	 * @param cnsttype
	 * @param tpsztype
	 */
	public EesEqr0124Event(String cnsttype, String tpsztype){
		this.cnsttype = cnsttype;
		this.tpsztype = tpsztype;
	}
	
	public void setEqrRepoCnstVO(EqrRepoCnstVO eqrRepoCnstVO){
		this. eqrRepoCnstVO = eqrRepoCnstVO;
	}

	public void setEqrRepoCnstVOS(EqrRepoCnstVO[] eqrRepoCnstVOs){
		this. eqrRepoCnstVOs = eqrRepoCnstVOs;
	}

	public EqrRepoCnstVO getEqrRepoCnstVO(){
		return eqrRepoCnstVO;
	}

	public EqrRepoCnstVO[] getEqrRepoCnstVOS(){
		return eqrRepoCnstVOs;
	}

}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0119Event.java
*@FileTitle : S/T Off Hire
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.07.10 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event;

import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchShortTermOffHireInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrShrtTermOffhCondVO;


/**
 * EES_EQR_0119 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0119HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Haeng-ji,Lee
 * @see EES_EQR_0119HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0119Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String status = null;
	private String location = null;
	private String tpsztype = null;
	private String ecclist = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private EqrShrtTermOffhCondVO eqrShrtTermOffhCondVO = null;
	private SearchShortTermOffHireInfoVO searchShortTermOffHireInfoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqrShrtTermOffhCondVO[] eqrShrtTermOffhCondVOs = null;
	public SearchShortTermOffHireInfoVO[] searchShortTermOffHireInfoVOs = null;

	public EesEqr0119Event(){}
	
	/**
	 * 검색조건이 3개 이하인 경우 Event에 담기위한 메소드
	 * @param String status
	 * @param String location
	 * @param String tpsztype
	 * @return
	 */
	public EesEqr0119Event(String status, String location, String tpsztype){
		this.status = status;
		this.location = location;
		this.tpsztype = tpsztype;
	}
	
	public void setEqrShrtTermOffhCondVO(EqrShrtTermOffhCondVO eqrShrtTermOffhCondVO){
		this. eqrShrtTermOffhCondVO = eqrShrtTermOffhCondVO;
	}

	public void setEqrShrtTermOffhCondVOS(EqrShrtTermOffhCondVO[] eqrShrtTermOffhCondVOs){
		this. eqrShrtTermOffhCondVOs = eqrShrtTermOffhCondVOs;
	}
	public void setSearchShortTermOffHireInfoVO(SearchShortTermOffHireInfoVO searchShortTermOffHireInfoVO){
		this. searchShortTermOffHireInfoVO = searchShortTermOffHireInfoVO;
	}

	public void setsSearchShortTermOffHireInfoVOS(SearchShortTermOffHireInfoVO[] searchShortTermOffHireInfoVOs){
		this. searchShortTermOffHireInfoVOs = searchShortTermOffHireInfoVOs;
	}

	public EqrShrtTermOffhCondVO getEqrShrtTermOffhCondVO(){
		return eqrShrtTermOffhCondVO;
	}

	public EqrShrtTermOffhCondVO[] getEqrShrtTermOffhCondVOS(){
		return eqrShrtTermOffhCondVOs;
	}
	public SearchShortTermOffHireInfoVO getSearchShortTermOffHireInfoVO(){
		return searchShortTermOffHireInfoVO;
	}

	public SearchShortTermOffHireInfoVO[] getSearchShortTermOffHireInfoVOS(){
		return searchShortTermOffHireInfoVOs;
	}	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTpsztype() {
		return tpsztype;
	}

	public void setTpsztype(String tpsztype) {
		this.tpsztype = tpsztype;
	}
	
	public String getEcclist() {
		return ecclist;
	}

	public void setEcclist(String ecclist) {
		this.ecclist = ecclist;
	}

}
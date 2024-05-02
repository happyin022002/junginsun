/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1069Event.java
*@FileTitle : Awakward Cargo Application
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.10 이병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RouteDtlInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RouteDtlVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RouteDtlVvdVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1069 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1069HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Byung Kyu
 * @see ESM_BKG_1069HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1069Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RouteDtlInfoVO routeDtlInfoVO = null;
	private RouteDtlVvdVO routeDtlVvdVO = null;	
	private RouteDtlVO routeDtlVO = null;	
	private String bkgNo = null;    
    private String evntUsrId = null;
    private String evntDt = null;   
  
	/** Table Value Object Multi Data 처리 */
	private RouteDtlInfoVO[] routeDtlInfoVOs = null;
	private RouteDtlVvdVO[] routeDtlVvdVOs = null;
	private RouteDtlVO[] routeDtlVOs = null;
	



	public EsmBkg1069Event(){}




	/**
	 * @return the routeDtlInfoVO
	 */
	public RouteDtlInfoVO getRouteDtlInfoVO() {
		return routeDtlInfoVO;
	}




	/**
	 * @param routeDtlInfoVO the routeDtlInfoVO to set
	 */
	public void setRouteDtlInfoVO(RouteDtlInfoVO routeDtlInfoVO) {
		this.routeDtlInfoVO = routeDtlInfoVO;
	}




	/**
	 * @return the routeDtlVvdVO
	 */
	public RouteDtlVvdVO getRouteDtlVvdVO() {
		return routeDtlVvdVO;
	}




	/**
	 * @param routeDtlVvdVO the routeDtlVvdVO to set
	 */
	public void setRouteDtlVvdVO(RouteDtlVvdVO routeDtlVvdVO) {
		this.routeDtlVvdVO = routeDtlVvdVO;
	}




	/**
	 * @return the routeDtlVO
	 */
	public RouteDtlVO getRouteDtlVO() {
		return routeDtlVO;
	}




	/**
	 * @param routeDtlVO the routeDtlVO to set
	 */
	public void setRouteDtlVO(RouteDtlVO routeDtlVO) {
		this.routeDtlVO = routeDtlVO;
	}




	/**
	 * @return the bkgNo
	 */
	public String getBkgNo() {
		return bkgNo;
	}




	/**
	 * @param bkgNo the bkgNo to set
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}




	/**
	 * @return the evntUsrId
	 */
	public String getEvntUsrId() {
		return evntUsrId;
	}




	/**
	 * @param evntUsrId the evntUsrId to set
	 */
	public void setEvntUsrId(String evntUsrId) {
		this.evntUsrId = evntUsrId;
	}




	/**
	 * @return the evntDt
	 */
	public String getEvntDt() {
		return evntDt;
	}




	/**
	 * @param evntDt the evntDt to set
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
	}




	/**
	 * @return the routeDtlInfoVOs
	 */
	public RouteDtlInfoVO[] getRouteDtlInfoVOs() {
		return routeDtlInfoVOs;
	}




	/**
	 * @param routeDtlInfoVOs the routeDtlInfoVOs to set
	 */
	public void setRouteDtlInfoVOs(RouteDtlInfoVO[] routeDtlInfoVOs) {
		this.routeDtlInfoVOs = routeDtlInfoVOs;
	}




	/**
	 * @return the routeDtlVvdVOs
	 */
	public RouteDtlVvdVO[] getRouteDtlVvdVOs() {
		return routeDtlVvdVOs;
	}




	/**
	 * @param routeDtlVvdVOs the routeDtlVvdVOs to set
	 */
	public void setRouteDtlVvdVOs(RouteDtlVvdVO[] routeDtlVvdVOs) {
		this.routeDtlVvdVOs = routeDtlVvdVOs;
	}




	/**
	 * @return the routeDtlVOs
	 */
	public RouteDtlVO[] getRouteDtlVOs() {
		return routeDtlVOs;
	}




	/**
	 * @param routeDtlVOs the routeDtlVOs to set
	 */
	public void setRouteDtlVOs(RouteDtlVO[] routeDtlVOs) {
		this.routeDtlVOs = routeDtlVOs;
	}

	

}
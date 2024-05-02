/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_ENS_0A1Event.java
*@FileTitle : Vessel조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-02
*@LastModifier : sangyool pak
*@LastVersion : 1.0
* 2006-08-02 sangyool pak
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.vessel.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * COM_ENS_0A1 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - COM_ENS_0A1HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author sangyool pak
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class ComEns0A1Event extends EventSupport {

    private String vslCd     = "";
    private String vslEngNm = "";
    private String carCd     = "";
    private String callSgnNo = "";
    private String lloydNo = "";
    private int iPage = 0;

    /**
     * Constructor<br>
     */
    public ComEns0A1Event(){}

   /**
    * Constructor<br>
    * @param vsl_cd
    * @param vsl_eng_nm
    * @param car_cd
    * @param iPage
    * @param call_sgn_no
    * @param lloyd_no
    */
    public ComEns0A1Event(String vsl_cd, String vsl_eng_nm, String car_cd, int iPage, String call_sgn_no, String lloyd_no) {
    	this.vslCd     = vsl_cd;
    	this.vslEngNm = vsl_eng_nm;
    	this.carCd     = car_cd;
    	this.iPage      = iPage;
    	this.callSgnNo = call_sgn_no;
    	this.lloydNo	= lloyd_no;
    }
    
    /**
     * Event 명을 반환<br>
     * @return String
     */
    public String getEventName() {
        return "ComEns0A1Event";
    }

    /**
     * Class 명을 반환<br>
     * @return String
     */
    public String toString() {
        return "ComEns0A1Event";
    }

	/**
	 * Carrier Code 반환<br>
	 * @return
	 */
	public String getCar_cd() {
		return carCd;
	}

	/**
	 * Carrier Code 세팅<br>
	 * @param car_cd
	 */
	public void setCar_cd(String car_cd) {
		this.carCd = car_cd;
	}

	/**
	 * Vessel Code 반환<br>
	 * @return
	 */
	public String getVsl_cd() {
		return vslCd;
	}

	/**
	 * Vessel Code 세팅<br>
	 * @param vsl_cd
	 */
	public void setVsl_cd(String vsl_cd) {
		this.vslCd = vsl_cd;
	}

	/**
	 * Vessel Name 반환<br>
	 * @return
	 */
	public String getVsl_eng_nm() {
		return vslEngNm;
	}

	/**
	 * Vessel Name 세팅<br>
	 * @param vsl_eng_nm
	 */
	public void setVsl_eng_nm(String vsl_eng_nm) {
		this.vslEngNm = vsl_eng_nm;
	}

	/**
	 * Page No 반환<br>
	 * @return
	 */
	public int getIPage() {
		return iPage;
	}

	/**
	 * Page No 세팅<br>
	 * @param page
	 */
	public void setIPage(int page) {
		iPage = page;
	}

	public String getCall_sgn_no() {
		return callSgnNo;
	}

	public String getLloyd_no() {
		return lloydNo;
	}

}

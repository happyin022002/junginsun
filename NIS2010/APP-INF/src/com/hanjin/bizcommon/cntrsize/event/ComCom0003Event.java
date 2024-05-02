/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_ENS_0G1Event.java
*@FileTitle : CntrTpSz
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-17
*@LastModifier : Hyung Choon_Roh
*@LastVersion : 1.0
* 2006-10-17 Hyung Choon_Roh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.cntrsize.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * COM_ENS_0G1 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - COM_ENS_0G1HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hyung Choon_Roh
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class ComCom0003Event extends EventSupport {

	private String cntrSzCd 	= "";
	private String cntrSzDesc 	= "";
    private int iPage = 0;

    /**
     * Constructor<br>
     */
    public ComCom0003Event(){}
    
    /**
     * Constructor<br>
     * @param cntr_tpsz_cd
     * @param cntr_tpsz_desc
     * @param iPage
     */
    public ComCom0003Event(String cntr_sz_cd, String cntr_sz_desc, int iPage) {
		this.cntrSzCd = cntr_sz_cd;
		this.cntrSzDesc = cntr_sz_desc;
		this.iPage = iPage;
    }

	/**
	 * Container Size Code 반환<br>
	 * @return
	 */
	public String getCntr_sz_cd() {
		return cntrSzCd;
	}

	/**
	 * Cotainer Size Code 세팅<br>
	 * @param cntr_sz_cd
	 */
	public void setCntr_sz_cd(String cntr_sz_cd) {
		this.cntrSzCd = cntr_sz_cd;
	}

	/**
	 * Container Type Size Desc 반환<br>
	 * @return
	 */
	public String getCntr_sz_desc() {
		return cntrSzDesc;
	}

	/**
	 * Container Type Size Desc 세팅<br>
	 * @param cntr_tpsz_desc
	 */
	public void setCntr_sz_desc(String cntr_sz_desc) {
		this.cntrSzDesc = cntr_sz_desc;
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

	/**
     * Event 명을 반환<br>
     * @return String
     */
	public String getEventName() {
		return "ComCom0003Event";
	}

	/**
     * Class 명을 반환<br>
     * @return String
     */
	public String toString() {
		return "ComCom0003Event";
	}

}

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
package com.hanjin.bizcommon.cntrtpsz.event;

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
public class ComEns0G1Event extends EventSupport {

	private String cntrTpszCd 	= "";
	private String cntrTpszDesc 	= "";
    private int iPage = 0;

    /**
     * Constructor<br>
     */
    public ComEns0G1Event(){}
    
    /**
     * Constructor<br>
     * @param cntr_tpsz_cd
     * @param cntr_tpsz_desc
     * @param iPage
     */
    public ComEns0G1Event(String cntr_tpsz_cd, String cntr_tpsz_desc, int iPage) {
		this.cntrTpszCd = cntr_tpsz_cd;
		this.cntrTpszDesc = cntr_tpsz_desc;
		this.iPage = iPage;
    }

	/**
	 * Container Type Size Code 반환<br>
	 * @return
	 */
	public String getCntr_tpsz_cd() {
		return cntrTpszCd;
	}

	/**
	 * Cotainer Type Size Code 세팅<br>
	 * @param cntr_tpsz_cd
	 */
	public void setCntr_tpsz_cd(String cntr_tpsz_cd) {
		this.cntrTpszCd = cntr_tpsz_cd;
	}

	/**
	 * Container Type Size Desc 반환<br>
	 * @return
	 */
	public String getCntr_tpsz_desc() {
		return cntrTpszDesc;
	}

	/**
	 * Container Type Size Desc 세팅<br>
	 * @param cntr_tpsz_desc
	 */
	public void setCntr_tpsz_desc(String cntr_tpsz_desc) {
		this.cntrTpszDesc = cntr_tpsz_desc;
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
		return "ComEns0G1Event";
	}

	/**
     * Class 명을 반환<br>
     * @return String
     */
	public String toString() {
		return "ComEns0G1Event";
	}

}

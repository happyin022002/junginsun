/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_COM_0002Event.java
*@FileTitle : CntrTp
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-17
*@LastModifier : Hyung Choon_Roh
*@LastVersion : 1.0
* 2006-10-17 Hyung Choon_Roh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.cntrtype.event;

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
public class ComCom0002Event extends EventSupport {

	private String cntrTpCd 	= "";
	private String cntrTpDesc 	= "";
    private int iPage = 0;

    /**
     * Constructor<br>
     */
    public ComCom0002Event(){}
    
    /**
     * Constructor<br>
     * @param cntr_tpsz_cd
     * @param cntr_tpsz_desc
     * @param iPage
     */
    public ComCom0002Event(String cntr_tp_cd, String cntr_tp_desc, int iPage) {
		this.cntrTpCd = cntr_tp_cd;
		this.cntrTpDesc = cntr_tp_desc;
		this.iPage = iPage;
    }

	/**
	 * Container Size Code 반환<br>
	 * @return
	 */
	public String getCntr_tp_cd() {
		return cntrTpCd;
	}

	/**
	 * Cotainer Size Code 세팅<br>
	 * @param cntr_sz_cd
	 */
	public void setCntr_tp_cd(String cntr_tp_cd) {
		this.cntrTpCd = cntr_tp_cd;
	}

	/**
	 * Container Type Size Desc 반환<br>
	 * @return
	 */
	public String getCntr_tp_desc() {
		return cntrTpDesc;
	}

	/**
	 * Container Type Size Desc 세팅<br>
	 * @param cntr_tpsz_desc
	 */
	public void setCntr_tp_desc(String cntr_tp_desc) {
		this.cntrTpDesc = cntr_tp_desc;
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
		return "ComCom0002Event";
	}

	/**
     * Class 명을 반환<br>
     * @return String
     */
	public String toString() {
		return "ComCom0002Event";
	}

}

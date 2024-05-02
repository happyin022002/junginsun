/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0607Event.java
*@FileTitle : Harmonized Tariff Code(HT Code 조회 화면)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.08 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgHamoTrfVO;


/**
 * esm_bkg_0607 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  esm_bkg_0607HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see esm_bkg_0607HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0607Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgHamoTrfVO bkgHamoTrfVO = null;
	
	private String hamoTpCd = "";
	private int iPage 			= 0;
	
	/** Table Value Object Multi Data 처리 */
	private BkgHamoTrfVO[] bkgHamoTrfVOs = null;         
	/**
	 * @return the hamoTpCd
	 */
	public String getHamoTpCd() {
		return hamoTpCd;                 
	}
	
	/**
	 * Page No 반환<br>
	 * @return
	 */
	public int getIPage() {
		return iPage;
	}

	/**
	 * @param hamoTpCd the hamoTpCd to set
	 */
	public void setHamoTpCd(String hamoTpCd) {
		this.hamoTpCd = hamoTpCd;        
	}
	
	/**
	 * Page No 세팅<br>
	 * @param page
	 */
	public void setIPage(int page) {
		iPage = page;
	}
	
	public EsmBkg0607Event(){}
	
	
	
	public void setBkgHamoTrfVO(BkgHamoTrfVO bkgHamoTrfVO){
		this. bkgHamoTrfVO = bkgHamoTrfVO;
	}

	public void setBkgHamoTrfVOS(BkgHamoTrfVO[] bkgHamoTrfVOs){
		this. bkgHamoTrfVOs = bkgHamoTrfVOs;
	}

	public BkgHamoTrfVO getBkgHamoTrfVO(){
		return bkgHamoTrfVO;
	}

	public BkgHamoTrfVO[] getBkgHamoTrfVOS(){
		return bkgHamoTrfVOs;
	}
	
}
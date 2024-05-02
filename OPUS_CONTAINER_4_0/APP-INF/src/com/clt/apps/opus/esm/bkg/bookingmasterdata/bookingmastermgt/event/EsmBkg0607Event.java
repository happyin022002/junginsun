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
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgHamoTrfVO;


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
	
	/** Table Value Object Multi Data 처리 */
	private BkgHamoTrfVO[] bkgHamoTrfVOs = null;         
	/**
	 * @return the hamoTpCd
	 */
	public String getHamoTpCd() {
		return hamoTpCd;                 
	}

	/**
	 * @param hamoTpCd the hamoTpCd to set
	 */
	public void setHamoTpCd(String hamoTpCd) {
		this.hamoTpCd = hamoTpCd;        
	}
	
	
	public EsmBkg0607Event(){}
	
	
	
	public void setBkgHamoTrfVO(BkgHamoTrfVO bkgHamoTrfVO){
		this. bkgHamoTrfVO = bkgHamoTrfVO;
	}

//	public void setBkgHamoTrfVOS(BkgHamoTrfVO[] bkgHamoTrfVOs){
//		this. bkgHamoTrfVOs = bkgHamoTrfVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setBkgHamoTrfVOS(BkgHamoTrfVO[] bkgHamoTrfVOs){
		if (bkgHamoTrfVOs != null) {
			BkgHamoTrfVO[] tmpVOs = new BkgHamoTrfVO[bkgHamoTrfVOs.length];
			System.arraycopy(bkgHamoTrfVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgHamoTrfVOs = tmpVOs;
		}		
	}	

	public BkgHamoTrfVO getBkgHamoTrfVO(){
		return bkgHamoTrfVO;
	}

//	public BkgHamoTrfVO[] getBkgHamoTrfVOS(){
//		return bkgHamoTrfVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public BkgHamoTrfVO[] getBkgHamoTrfVOS(){
		BkgHamoTrfVO[] tmpVOs = null;
		if (this.bkgHamoTrfVOs != null) {
			tmpVOs = new BkgHamoTrfVO[bkgHamoTrfVOs.length];
			System.arraycopy(bkgHamoTrfVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}	
	
}
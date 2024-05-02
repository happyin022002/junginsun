/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CLMInquiryRequest.java
*@FileTitle : ServiceProvicerVisibility Web-Service
*Open Issues :
*Change history :
*@LastModifyDate : 2008-07-02
*@LastModifier : Park Yeon-Jin
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.servicesio.serviceprovidervisibility.clm.event;

/**
 * SPP-SCE PDTO(Data Transfer Object including Parameters)<br>
 * - SPP-SCE에 대한 데이터 전달하는 PDTO로 사용<br>
 *
 * @author yeon-jin park
 * @see SppSce0003EventResponse 참조
 * @since J2EE 1.4
 */
public class ClmInquiryRequest implements java.io.Serializable {

	private String bkgNo = "";
	private String cntrNo = ""; 
	private String copNo = "";
	
    /**
     * get bkg_no
     * 
     * @return String bkg_no
     */
	public String getBkg_no(){
		return bkgNo;
	}
    /**
     * set bkg_no
     * @param bkg_no String
     */
	public void setBkg_no(String bkg_no){
		this.bkgNo = bkg_no;
	}
	
    /**
     * get cntr_no
     * 
     * @return String cntr_no
     */
	public String getCntr_no(){
		return cntrNo;
	}
	
    /**
     * set cntr_no
     * @param cntr_no String
     */
	public void setCntr_no(String cntr_no){
		this.cntrNo = cntr_no;
	}
    /**
     * get cop_no
     * 
     * @return String cntr_no
     */
	public String getCop_no(){
		return copNo;
	}
	
    /**
     * set cop_no
     * @param cop_no String
     */
	public void setCop_no(String cop_no){
		this.copNo = cop_no;
	}
	
}

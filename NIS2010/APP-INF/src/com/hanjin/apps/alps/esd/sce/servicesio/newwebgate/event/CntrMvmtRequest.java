/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : CntrMvmtRequest.java
*@FileTitle : CntrMvmtRequest Request
*Open Issues :
*Change history :
*@LastModifyDate : 2008-05-30
*@LastModifier : ahn jun sang
*@LastVersion : 1.0
* 2007-07-10 hrmall73@naver.com
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.servicesio.newwebgate.event;

/**
 * SPP_SCE_001 에 대한 WebService Document Object including Parameters<br>
 * - WebGateIWSProxy의 Input Parameter<br>
 * - SPP_SCE_002Event로 변환하여 사용<br>
 *
 * @author ahn jun sang
 * @see WebGateIWSProxy 참조
 * @since J2EE 1.4
 */
public class CntrMvmtRequest {
    /** (Header) */
    /** (Param 객체) */
	
    private String bkblNo 		= null;
    private String cntrNo 		= null;
    /**
     * get bkbl_no
     * 
     * @return String bkbl_no
     */
    public String getBkbl_no() {
    	return bkblNo;
    }
    /**
     * set bkbl_no
     * @param bkg_no String
     */
    public void setBkbl_no(String bkbl_no) {
    	this.bkblNo = bkbl_no;
    }
    
    /**
     * get cntr_no
     * 
     * @return String cntr_no
     */
    public String getCntr_no() {
    	return cntrNo;
    }
    /**
     * set cntr_no
     * 
     * @param cntr_no String
     */
    public void setCntr_no(String cntr_no) {
    	this.cntrNo = cntr_no;
    }
}
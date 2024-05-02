/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1409Event.java
*@FileTitle : Container And Booking Comparison
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.09.04 김영출
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1409 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1409HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Youngchul
 * @see ESM_BKG_1409HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1409Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private String bkgNo = null;
	

	public EsmBkg1409Event(){}


    
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
	

}
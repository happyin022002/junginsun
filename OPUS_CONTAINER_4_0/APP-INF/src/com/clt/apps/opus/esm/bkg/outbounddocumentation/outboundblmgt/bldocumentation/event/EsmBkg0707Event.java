/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0707Event.java
*@FileTitle : Mark And Description for C/M
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.06.11 김영출
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0707 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0707HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Youngchul
 * @see ESM_BKG_0707HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0707Event extends EventSupport {

	private static final long serialVersionUID = 1L;

    private String bkgNo = null;

	public EsmBkg0707Event(){}

    /**
     * @param bkgNo the bkgNo to set
     */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
     * @return the bkgNo
     */
    public String getBkgNo() {
        return bkgNo;
    }

}
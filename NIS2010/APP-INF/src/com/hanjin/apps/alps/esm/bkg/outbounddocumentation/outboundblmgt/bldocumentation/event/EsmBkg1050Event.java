/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg1050Event.java
 *@FileTitle : Container Vol. Adjustment
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.04
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.09.04 김영출
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1050 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1050HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Youngchul
 * @see ESM_BKG_1050HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1050Event extends EventSupport {

    private static final long serialVersionUID = 1L;

    /** Table Value Object 조회 조건 및 단건 처리 */
    private String            bkgNo            = null;
    private String            cntrNo           = null;
    private String            cntrVol          = null;

    public EsmBkg1050Event() {}

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

    /**
     * @return the cntrNo
     */
    public String getCntrNo() {
        return cntrNo;
    }

    /**
     * @param cntrNo the cntrNo to set
     */
    public void setCntrNo(String cntrNo) {
        this.cntrNo = cntrNo;
    }

    /**
     * @param cntrVol the cntrVol to set
     */
    public void setCntrVol(String cntrVol) {
        this.cntrVol = cntrVol;
    }

    /**
     * @return the cntrVol
     */
    public String getCntrVol() {
        return cntrVol;
    }

}
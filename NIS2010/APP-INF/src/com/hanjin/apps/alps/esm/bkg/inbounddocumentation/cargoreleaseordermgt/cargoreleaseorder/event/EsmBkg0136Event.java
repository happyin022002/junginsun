/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0136Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2009.05.12 안진응
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_0136 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0136HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author An Jin Eung
 * @see ESM_BKG_0136HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0136Event extends EventSupport {

    /**
     *
     */
    private static final long serialVersionUID = 6505397460113280378L;

    private String rqstNo      = "";
    private String tpCd = "";


    public EsmBkg0136Event(){}

    /**
     * @return the rqstNo
     */
    public String getRqstNo() {
        return rqstNo;
    }

    /**
     * @param rqstNo the rqstNo to set
     */
    public void setRqstNo(String rqstNo) {
        this.rqstNo = rqstNo;
    }

    /**
     * @return the tpCd
     */
    public String getTpCd() {
        return tpCd;
    }

    /**
     * @param tpCd the tpCd to set
     */
    public void setTpCd(String tpCd) {
        this.tpCd = tpCd;
    }
    
}
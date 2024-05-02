/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0133Event.java
*@FileTitle : Attorney Create Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.clt.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_0133 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0133HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_0133HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0133Event extends EventSupport {

    /**
     *
     */
    private static final long serialVersionUID = 6505397460113280378L;

    private String rqstNo      = "";
    private String tpCd = "";


    public EsmBkg0133Event(){}

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
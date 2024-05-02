/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg1075Event.java
 *@FileTitle : Booking Receipt Notice And Draft B/L Setup
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.12.24
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.12.24 김영출
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.RptItmStupVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.TroRmkStupVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1173 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1173HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Youngchul
 * @see ESM_BKG_1075HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1173Event extends EventSupport {

    private static final long serialVersionUID = 1L;

    /** Table Value Object 조회 조건 및 단건 처리 */
    private String            ofcCd            = null;
    private String            custCd           = null;
    private String            custCntCd        = null;
    private String            custSeq          = null;
    
    private String            bkgTroOfcCd          = null;

    private RptItmStupVO[]    rptItmStupVOs    = null;
    
    private TroRmkStupVO[]    troRmkStupVOs    = null;  

    public EsmBkg1173Event() {}
    
    /**
     * @return the orgCntCd
     */
    public String getOfcCd() {
        return ofcCd;
    }

    
    /**
     * @param orgCntCd the orgCntCd to set
     */
    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
    }
    
    /**
     * @return  bkgTroOfcCd
     */
    public String getBkgTroOfcCd() {
        return bkgTroOfcCd;
    }

    
    /**
     * @param bkgTroOfcCd
     */
    public void setBkgTroOfcCd(String bkgTroOfcCd) {
        this.bkgTroOfcCd = bkgTroOfcCd;
    }

    
    /**
     * @return the custCd
     */
    public String getCustCd() {
        return custCd;
    }

    
    /**
     * @param custCd the custCd to set
     */
    public void setCustCd(String custCd) {
        this.custCd = custCd;
    }

    
    /**
     * @return the custCntCd
     */
    public String getCustCntCd() {
        return custCntCd;
    }

    
    /**
     * @param custCntCd the custCntCd to set
     */
    public void setCustCntCd(String custCntCd) {
        this.custCntCd = custCntCd;
    }

    
    /**
     * @return the custSeq
     */
    public String getCustSeq() {
        return custSeq;
    }

    
    /**
     * @param custSeq the custSeq to set
     */
    public void setCustSeq(String custSeq) {
        this.custSeq = custSeq;
    }


    
    /**
     * @return the rptItmStupVOs
     */
    public RptItmStupVO[] getRptItmStupVOs() {
        return rptItmStupVOs;
    }


    
    /**
     * @param rptItmStupVOs the rptItmStupVOs to set
     */
    public void setRptItmStupVOs(RptItmStupVO[] rptItmStupVOs) {
        this.rptItmStupVOs = rptItmStupVOs;
    }
    
    /**
     * @return the troRmkStupVOs
     */
    public TroRmkStupVO[] getTroRmkStupVOs() {
        return troRmkStupVOs;
    }


    
    /**
     * @param rptItmStupVOs the rptItmStupVOs to set
     */
    public void setTroRmkStupVOs(TroRmkStupVO[] troRmkStupVOs) {
        this.troRmkStupVOs = troRmkStupVOs;
    }

    
}
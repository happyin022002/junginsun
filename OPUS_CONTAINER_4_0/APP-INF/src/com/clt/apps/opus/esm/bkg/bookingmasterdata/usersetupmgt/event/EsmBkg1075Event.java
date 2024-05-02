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

package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.vo.RptItmStupVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1075 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1075HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Youngchul
 * @see ESM_BKG_1075HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1075Event extends EventSupport {

    private static final long serialVersionUID = 1L;

    /** Table Value Object 조회 조건 및 단건 처리 */
    private String            ofcCd            = null;
    private String            custCd           = null;
    private String            custCntCd        = null;
    private String            custSeq          = null;

    private RptItmStupVO[]    rptItmStupVOs    = null;

    public EsmBkg1075Event() {}
    
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
//    public RptItmStupVO[] getRptItmStupVOs() {
//        return rptItmStupVOs;
//    }

	//2015.04.10 Secure Coding 적용[CWE-496]
    public RptItmStupVO[] getRptItmStupVOs() {
    	RptItmStupVO[] tmpVOs = null;
		if (this.rptItmStupVOs != null) {
			tmpVOs = new RptItmStupVO[rptItmStupVOs.length];
			System.arraycopy(rptItmStupVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}	
    
    /**
     * @param rptItmStupVOs the rptItmStupVOs to set
     */
//    public void setRptItmStupVOs(RptItmStupVO[] rptItmStupVOs) {
//        this.rptItmStupVOs = rptItmStupVOs;
//    }

	//2015.04.10 Secure Coding 적용[CWE-496]
    public void setRptItmStupVOs(RptItmStupVO[] rptItmStupVOs) {
		if (rptItmStupVOs != null) {
			RptItmStupVO[] tmpVOs = new RptItmStupVO[rptItmStupVOs.length];
			System.arraycopy(rptItmStupVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rptItmStupVOs = tmpVOs;
		}		
	}	
}
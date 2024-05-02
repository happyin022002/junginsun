/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : EsmBkg1215Event.java
*@FileTitle : Booking Allocation Master Table
*Open Issues :
 *Change history :
 *@LastModifyDate : 2013.12.30
 *@LastModifier : 최문환
 *@LastVersion : 1.0
 * 2013.12.30 최문환
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgAlocMgmtVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1215 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1215HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Choi Moon Hwan
 * @see ESM_BKG_1215HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1215Event extends EventSupport {

    private static final long serialVersionUID = 1L;

    /** Table Value Object 조회 조건 및 단건 처리 */
    private BkgAlocMgmtVO      bkgAlocMgmtVO     = null;
    private BkgAlocMgmtVO[]    bkgAlocMgmtVOs    = null;

    public EsmBkg1215Event() {}
    
    
    /**
     * @return the bkgAlocMgmtVO
     */
    public BkgAlocMgmtVO getBkgAlocMgmtVO() {
        return bkgAlocMgmtVO;
    }
    
    /**
     * @return the bkgAlocMgmtVOs
     */
    public BkgAlocMgmtVO[] getBkgAlocMgmtVOs() {
        return bkgAlocMgmtVOs;
    }
    
    /**
     * @param bkgAlocMgmtVO the bkgAlocMgmtVO to set
     */
    public void setBkgAlocMgmtVO(BkgAlocMgmtVO bkgAlocMgmtVO) {
        this.bkgAlocMgmtVO = bkgAlocMgmtVO;
    }
    
    /**
     * @param bkgAlocMgmtVOs the bkgAlocMgmtVOs to set
     */
    public void setBkgAlocMgmtVOs(BkgAlocMgmtVO[] bkgAlocMgmtVOs) {
        this.bkgAlocMgmtVOs = bkgAlocMgmtVOs;
    }
  
    
}
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

import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.vo.BlCluzStupVO;
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
 
public class EsmBkg1606Event extends EventSupport {

    private static final long serialVersionUID = 1L;

    /** Table Value Object 조회 조건 및 단건 처리 */
    private String		orgCntCd          = null;

    private BlCluzStupVO[]	blCluzStupVOs    = null;

    public EsmBkg1606Event() {}
    

    
    /**
     * @return the orgCntCd
     */
   public String getOrgCntCd() {
		return orgCntCd;
	}

   /**
    * @param orgCntCd the orgCntCd to set
    */
	public void setOrgCntCd(String orgCntCd) {
		this.orgCntCd = orgCntCd;
	}


    
    /**
     * @return the cntClauseVOs
     */

	//2015.04.10 Secure Coding 적용[CWE-496]
    public BlCluzStupVO[] getBlCluzStupVOs() {
    	BlCluzStupVO[] tmpVOs = null;
		if (this.blCluzStupVOs != null) {
			tmpVOs = new BlCluzStupVO[blCluzStupVOs.length];
			System.arraycopy(blCluzStupVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}	
    
    /**
     * @param cntClauseVOs the cntClauseVOs to set
     */

	//2015.04.10 Secure Coding 적용[CWE-496]
    public void setBlCluzStupVOs(BlCluzStupVO[] blCluzStupVOs) {
		if (blCluzStupVOs != null) {
			BlCluzStupVO[] tmpVOs = new BlCluzStupVO[blCluzStupVOs.length];
			System.arraycopy(blCluzStupVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.blCluzStupVOs = tmpVOs;
		}		
	}	
}
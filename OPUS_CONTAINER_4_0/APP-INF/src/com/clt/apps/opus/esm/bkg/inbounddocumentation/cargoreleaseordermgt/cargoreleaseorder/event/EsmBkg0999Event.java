/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0999Event.java
*@FileTitle : Attorney Create Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoAttorneyDtlVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * esm_bkg_0999 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * esm_bkg_0999HTMLAction에서 작성<br>
 * ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_0999HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0999Event extends EventSupport {

    /**
     *
     */
    private static final long serialVersionUID = -2261069293441189767L;

    /** Table Value Object 조회 조건 및 단건 처리  */
    private KorDoAttorneyDtlVO bkgKorDoAttorneyDtlVO = null;

    /** Table Value Object Multi Data 처리 */
    private KorDoAttorneyDtlVO[] bkgKorDoAttorneyDtlVOs = null;

    public EsmBkg0999Event(){}

    /**
     * @return the bkgKorDoAttorneyDtlVO
     */
    public KorDoAttorneyDtlVO getBkgKorDoAttorneyDtlVO() {
        return bkgKorDoAttorneyDtlVO;
    }

    /**
     * @param bkgKorDoAttorneyDtlVO the bkgKorDoAttorneyDtlVO to set
     */
    public void setBkgKorDoAttorneyDtlVO(KorDoAttorneyDtlVO bkgKorDoAttorneyDtlVO) {
        this.bkgKorDoAttorneyDtlVO = bkgKorDoAttorneyDtlVO;
    }

    /**
     * @return the bkgKorDoAttorneyDtlVOs
     */
//    public KorDoAttorneyDtlVO[] getBkgKorDoAttorneyDtlVOs() {
//        return bkgKorDoAttorneyDtlVOs;
//    }

	//2015.04.14 Secure Coding 적용[CWE-496]
    public KorDoAttorneyDtlVO[] getBkgKorDoAttorneyDtlVOs() {
    	KorDoAttorneyDtlVO[] tmpVOs = null;
		if (this.bkgKorDoAttorneyDtlVOs != null) {
			tmpVOs = new KorDoAttorneyDtlVO[bkgKorDoAttorneyDtlVOs.length];
			System.arraycopy(bkgKorDoAttorneyDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 
    
    /**
     * @param bkgKorDoAttorneyDtlVOs the bkgKorDoAttorneyDtlVOs to set
     */
//    public void setBkgKorDoAttorneyDtlVOs(
//            KorDoAttorneyDtlVO[] bkgKorDoAttorneyDtlVOs) {
//        this.bkgKorDoAttorneyDtlVOs = bkgKorDoAttorneyDtlVOs;
//    }
    
	//2015.04.14 Secure Coding 적용[CWE-496]
    public void setBkgKorDoAttorneyDtlVOs(KorDoAttorneyDtlVO[] bkgKorDoAttorneyDtlVOs) {
		if (bkgKorDoAttorneyDtlVOs != null) {
			KorDoAttorneyDtlVO[] tmpVOs = new KorDoAttorneyDtlVO[bkgKorDoAttorneyDtlVOs.length];
			System.arraycopy(bkgKorDoAttorneyDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgKorDoAttorneyDtlVOs = tmpVOs;
		}		
	} 
}
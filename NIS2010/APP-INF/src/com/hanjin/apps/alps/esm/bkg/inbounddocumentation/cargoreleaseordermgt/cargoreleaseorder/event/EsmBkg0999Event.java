/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0999Event.java
*@FileTitle : Attorney Create Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 임진영
*@LastVersion : 1.0
* 2009.05.12 임진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoAttorneyDtlVO;


/**
 * esm_bkg_0999 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * esm_bkg_0999HTMLAction에서 작성<br>
 * ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lim Jin Young
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
    public KorDoAttorneyDtlVO[] getBkgKorDoAttorneyDtlVOs() {
        return bkgKorDoAttorneyDtlVOs;
    }

    /**
     * @param bkgKorDoAttorneyDtlVOs the bkgKorDoAttorneyDtlVOs to set
     */
    public void setBkgKorDoAttorneyDtlVOs(
            KorDoAttorneyDtlVO[] bkgKorDoAttorneyDtlVOs) {
        this.bkgKorDoAttorneyDtlVOs = bkgKorDoAttorneyDtlVOs;
    }
}
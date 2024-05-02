/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0901Event.java
 *@FileTitle : Container Repor
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.18
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.05.18 김영출
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.EdiNotUpdCntrVO;

/**
 * ESM_BKG_0901 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0901HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Youngchul
 * @see ESM_BKG_0901HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0901Event extends EventSupport {

    private static final long serialVersionUID = 1L;

    /** Table Value Object 조회 조건 및 단건 처리 */
    private EdiNotUpdCntrVO   ediNotUpdCntrVO  = null;

    /** Table Value Object Multi Data 처리 */
    private EdiNotUpdCntrVO[] ediNotUpdCntrVOs = null;

    private String            bkgNo            = null;
    private String            bkgNoSplit       = null;

    public EsmBkg0901Event() {}

    /**
     *
     * @param ediNotUpdCntrVO
     */
    public void setEdiNotUpdCntrVO(EdiNotUpdCntrVO ediNotUpdCntrVO) {
        this.ediNotUpdCntrVO = ediNotUpdCntrVO;
    }

    /**
     *
     * @param ediNotUpdCntrVO
     */
    public String getBkgNo() {
        return bkgNo;
    }

    /**
     *
     * @param ediNotUpdCntrVO
     */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
     *
     * @param ediNotUpdCntrVO
     */
    public String getBkgNoSplit() {
        return bkgNoSplit;
    }

    /**
     *
     * @param ediNotUpdCntrVO
     */
    public void setBkgNoSplit(String bkgNoSplit) {
        this.bkgNoSplit = bkgNoSplit;
    }

    /**
     *
     * @param ediNotUpdCntrVO
     */
    public void setEdiNotUpdCntrVOS(EdiNotUpdCntrVO[] ediNotUpdCntrVOs) {
        this.ediNotUpdCntrVOs = ediNotUpdCntrVOs;
    }

    /**
     *
     * @param ediNotUpdCntrVO
     */
    public EdiNotUpdCntrVO getEdiNotUpdCntrVO() {
        return ediNotUpdCntrVO;
    }

    /**
     *
     * @param ediNotUpdCntrVO
     */
    public EdiNotUpdCntrVO[] getEdiNotUpdCntrVOS() {
        return ediNotUpdCntrVOs;
    }

}
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

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.EdiNotUpdCntrVO;
import com.clt.framework.support.layer.event.EventSupport;

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
		if(ediNotUpdCntrVOs != null){
			EdiNotUpdCntrVO[] tmpVOs = Arrays.copyOf(ediNotUpdCntrVOs, ediNotUpdCntrVOs.length);
			this.ediNotUpdCntrVOs = tmpVOs;
		}
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
    	EdiNotUpdCntrVO[] rtnVOs = null;
		if(this.ediNotUpdCntrVOs != null){
			rtnVOs = Arrays.copyOf(ediNotUpdCntrVOs, ediNotUpdCntrVOs.length);
		}
		return rtnVOs;		
    }

}
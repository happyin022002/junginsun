/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg399Event.java
 *@FileTitle : NVOCC House B/L Information
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.22
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.07.22 김영출
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblTmpltVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_399 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_399HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Youngchul
 * @see ESM_BKG_399HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0399Event extends EventSupport {

    private static final long serialVersionUID = 1L;

    /** Table Value Object 조회 조건 및 단건 처리 */
    private HblTmpltVO        hblTmpltVO       = null;
    
    private String cneeNm = null;
    private String shprNm = null;

    public EsmBkg0399Event() {}

    /**
     * 
     * @param hblTmpltVO
     */
    public void setHblTmpltVO(HblTmpltVO hblTmpltVO) {
        this.hblTmpltVO = hblTmpltVO;
    }

    /**
     * 
     * @return
     */
    public HblTmpltVO getHblTmpltVO() {
        return hblTmpltVO;
    }

    
    /**
     * @return the cneeNm
     */
    public String getCneeNm() {
        return cneeNm;
    }

    
    /**
     * @param cneeNm the cneeNm to set
     */
    public void setCneeNm(String cneeNm) {
        this.cneeNm = cneeNm;
    }

    
    /**
     * @return the shprNm
     */
    public String getShprNm() {
        return shprNm;
    }

    
    /**
     * @param shprNm the shprNm to set
     */
    public void setShprNm(String shprNm) {
        this.shprNm = shprNm;
    }

}
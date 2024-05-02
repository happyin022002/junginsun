/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg366Event.java
 *@FileTitle : Marks And Number/Description of Goods
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.22
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.07.22 김영출
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.NvoccFileNoVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_366 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_366HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Youngchul
 * @see ESM_BKG_366HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0366Event extends EventSupport {

    private static final long serialVersionUID = 1L;

    /** Table Value Object 조회 조건 및 단건 처리 */
    private HblVO             hblVO            = null;
    private NvoccFileNoVO     nvoccFileNoVO    = null;

    private String            bkgNo            = null;
    private String            blNo             = null;
    private String            blTpCd           = null;

    public EsmBkg0366Event() {}

    /**
     * 
     * @param hblVO
     */
    public void setHblVO(HblVO hblVO) {
        this.hblVO = hblVO;
    }

    /**
     * 
     * @return
     */
    public HblVO getHblVO() {
        return hblVO;
    }

    /**
     * @param nVOFileNumberVO the nVOFileNumberVO to set
     */
    public void setNvoccFileNoVO(NvoccFileNoVO nvoccFileNoVO) {
        this.nvoccFileNoVO = nvoccFileNoVO;
    }

    /**
     * @return the nVOFileNumberVO
     */
    public NvoccFileNoVO getNvoccFileNoVO() {
        return nvoccFileNoVO;
    }

    /**
     * @return the bkgNo
     */
    public String getBkgNo() {
        return bkgNo;
    }

    /**
     * @param bkgNo the bkgNo to set
     */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
     * @return the blNo
     */
    public String getBlNo() {
        return blNo;
    }

    /**
     * @param blNo the blNo to set
     */
    public void setBlNo(String blNo) {
        this.blNo = blNo;
    }

    /**
     * 
     * @return
     */
    public String getBlTpCd() {
        return blTpCd;
    }

    /**
     * 
     * @return
     */
    public void setBlTpCd(String blTpCd) {
        this.blTpCd = blTpCd;
    }

}
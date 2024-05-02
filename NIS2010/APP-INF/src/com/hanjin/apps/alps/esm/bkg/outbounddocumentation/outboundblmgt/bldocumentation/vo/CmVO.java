/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DGCargoVO.java
*@FileTitle : DGCargoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.06.30 김영출
* 1.0 Creation
===============================================================================
 History
* 2010.12.07 최도순 [CHM-201007310] BKG C/M 화면에 DG SEQ 선택 필드 (구주 24 HR)
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo;

import java.util.List;

import com.hanjin.syscommon.common.table.BkgCntrMfDescVO;
import com.hanjin.syscommon.common.table.BkgCntrSealNoVO;
import com.hanjin.syscommon.common.table.BkgDgCgoVO;

public class CmVO {

    private CmBkgInfoVO cmInfoVO = null;
    private List<CmCntrInfoVO> cmCntrInfoVOs = null;
    private List<BkgCntrSealNoVO> cntrSealNoVOs = null;
    private List<BkgCntrMfDescVO> cntrMfDescVOs = null;
    private List<BkgDgCgoVO> bkgDgCgoVOs = null;


    /**
     * @return
     */
    public CmBkgInfoVO getCmBkgInfoVO() {
        return cmInfoVO;
    }

    /**
     * @param cmInfoVO
     */
    public void setCmBkgInfoVO(CmBkgInfoVO cmInfoVO) {
        this.cmInfoVO = cmInfoVO;
    }

    /**
     * @return
     */
    public List<CmCntrInfoVO> getCmCntrInfoVOs() {
        return cmCntrInfoVOs;
    }

    /**
     * @param cmCntrInfoVOs
     */
    public void setCmCntrInfoVOs(List<CmCntrInfoVO> cmCntrInfoVOs) {
        this.cmCntrInfoVOs = cmCntrInfoVOs;
    }

    /**
     * @param cmInfoVO
     */

    public List<BkgCntrSealNoVO> getCntrSealNoVOs() {
        return cntrSealNoVOs;
    }

    /**
     * @return
     */
    public void setCntrSealNoVOs(List<BkgCntrSealNoVO> cntrSealNoVOs) {
        this.cntrSealNoVOs = cntrSealNoVOs;
    }

    /**
     * @return
     */
    public List<BkgCntrMfDescVO> getBkgCntrMfDescVOs() {
        return cntrMfDescVOs;
    }

    /**
     * @param cntrMfDescVOs
     */
    public void setCntrMfDescVOs(List<BkgCntrMfDescVO> cntrMfDescVOs) {
        this.cntrMfDescVOs = cntrMfDescVOs;
    }
    
    /**
     * @return
     */
    public List<BkgDgCgoVO> getBkgDgCgoVOs() {
        return bkgDgCgoVOs;
    }

    /**
     * @param bkgDgCgoVOs
     */
    public void setBkgDgCgoVOs(List<BkgDgCgoVO> bkgDgCgoVOs) {
        this.bkgDgCgoVOs = bkgDgCgoVOs;
    }

}
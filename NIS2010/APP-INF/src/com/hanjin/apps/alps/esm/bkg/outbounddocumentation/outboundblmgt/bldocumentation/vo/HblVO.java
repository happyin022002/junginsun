package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo;


import java.util.List;

import com.hanjin.syscommon.common.table.BkgCntrMfDescVO;
import com.hanjin.syscommon.common.table.BkgHblCustVO;

public class HblVO {

    private HblBkgInfoVO          hblBkgInfoVO    = null;
    private List<HblDtlInfoVO>        hblDtlInfoVOs       = null;
    private List<HblCntrVO>       hblCntrVOs      = null;
    private List<BkgCntrMfDescVO> bkgCntrMfDescVOs = null;    
    private List<BkgHblCustVO>    bkgHblCustVOs   = null;

    public HblVO(){
    }

    
    /**
     * @return the hblBkgInfoVO
     */
    public HblBkgInfoVO getHblBkgInfoVO() {
        return hblBkgInfoVO;
    }

    
    /**
     * @param hblBkgInfoVO the hblBkgInfoVO to set
     */
    public void setHblBkgInfoVO(HblBkgInfoVO hblBkgInfoVO) {
        this.hblBkgInfoVO = hblBkgInfoVO;
    }

    
    /**
     * @return the bkgHblVOs
     */
    public List<HblDtlInfoVO> getHblDtlInfoVOs() {
        return hblDtlInfoVOs;
    }

    
    /**
     * @param bkgHblVOs the bkgHblVOs to set
     */
    public void setHblDtlInfoVOs(List<HblDtlInfoVO> bkgHblVOs) {
        this.hblDtlInfoVOs = bkgHblVOs;
    }

    
    /**
     * @return the hblCntrVOs
     */
    public List<HblCntrVO> getHblCntrVOs() {
        return hblCntrVOs;
    }

    
    /**
     * @param hblCntrVOs the hblCntrVOs to set
     */
    public void setHblCntrVOs(List<HblCntrVO> hblCntrVOs) {
        this.hblCntrVOs = hblCntrVOs;
    }

    
    /**
     * @return the bkgCntrMfDescVO
     */
    public List<BkgCntrMfDescVO> getBkgCntrMfDescVOs() {
        return bkgCntrMfDescVOs;
    }

    
    /**
     * @param bkgCntrMfDescVO the bkgCntrMfDescVO to set
     */
    public void setBkgCntrMfDescVOs(List<BkgCntrMfDescVO> bkgCntrMfDescVO) {
        this.bkgCntrMfDescVOs = bkgCntrMfDescVO;
    }


    /**
     * @return the bkgHblCustVOs
     */
    public List<BkgHblCustVO> getBkgHblCustVOs() {
        return bkgHblCustVOs;
    }

    
    /**
     * @param bkgHblCustVOs the bkgHblCustVOs to set
     */
    public void setBkgHblCustVOs(List<BkgHblCustVO> bkgHblCustVOs) {
        this.bkgHblCustVOs = bkgHblCustVOs;
    }

}
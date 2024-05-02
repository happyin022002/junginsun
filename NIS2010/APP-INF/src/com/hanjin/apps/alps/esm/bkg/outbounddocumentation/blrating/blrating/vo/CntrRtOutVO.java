/**
 * 
 */
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo;

import java.util.List;


/**
 * @author Sarang
 *
 */
public class CntrRtOutVO {
    
    private CntrRtBkgInfoVO cntrRtBkgInfoVO = null;
    private List<CntrRtQtyVO> cntrRtQtyVOs = null;
    private List<CntrRtVO> cntrRtVOs = null;
    private List<CntrRtAmtVO> cntrRtAmtVOs  = null;
    private List<CntrRtCustVO> cntrRtCustVOs  = null;
    
    public CntrRtOutVO(){}

    
    /**
     * @return the cntrRtBkgInfoVO
     */
    public CntrRtBkgInfoVO getCntrRtBkgInfoVO() {
        return cntrRtBkgInfoVO;
    }

    
    /**
     * @param cntrRtBkgInfoVO the cntrRtBkgInfoVO to set
     */
    public void setCntrRtBkgInfoVO(CntrRtBkgInfoVO cntrRtBkgInfoVO) {
        this.cntrRtBkgInfoVO = cntrRtBkgInfoVO;
    }

    
    /**
     * @return the cntrRtQtyVOs
     */
    public List<CntrRtQtyVO> getCntrRtQtyVOs() {
        return cntrRtQtyVOs;
    }

    
    /**
     * @param cntrRtQtyVOs the cntrRtQtyVOs to set
     */
    public void setCntrRtQtyVOs(List<CntrRtQtyVO> cntrRtQtyVOs) {
        this.cntrRtQtyVOs = cntrRtQtyVOs;
    }

    
    /**
     * @return the cntrRtVOs
     */
    public List<CntrRtVO> getCntrRtVOs() {
        return cntrRtVOs;
    }

    
    /**
     * @param cntrRtVOs the cntrRtVOs to set
     */
    public void setCntrRtVOs(List<CntrRtVO> cntrRtVOs) {
        this.cntrRtVOs = cntrRtVOs;
    }

    
    /**
     * @return the cntrRtAmtVOs
     */
    public List<CntrRtAmtVO> getCntrRtAmtVOs() {
        return cntrRtAmtVOs;
    }

    
    /**
     * @param cntrRtAmtVOs the cntrRtAmtVOs to set
     */
    public void setCntrRtAmtVOs(List<CntrRtAmtVO> cntrRtAmtVOs) {
        this.cntrRtAmtVOs = cntrRtAmtVOs;
    }

    
    /**
     * @return the cntrRtCustVOs
     */
    public List<CntrRtCustVO> getCntrRtCustVOs() {
        return cntrRtCustVOs;
    }

    
    /**
     * @param cntrRtCustVOs the cntrRtCustVOs to set
     */
    public void setCntrRtCustVOs(List<CntrRtCustVO> cntrRtCustVOs) {
        this.cntrRtCustVOs = cntrRtCustVOs;
    }
}

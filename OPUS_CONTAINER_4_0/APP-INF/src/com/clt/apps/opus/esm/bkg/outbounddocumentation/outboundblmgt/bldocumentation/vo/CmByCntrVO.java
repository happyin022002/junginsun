/**
 * 
 */
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo;

import java.util.List;


/**
 * @author Sarang
 *
 */
public class CmByCntrVO {
    List<CntrCmBkgInfoVO> cntrCmBkgInfoVOs = null;
    CntrCmEtcInfoVO cntrCmEtcInfoVO = null;
    List<CntrCmDescInfoVO> cntrCmDescInfoVOs = null;
    
    /**
     * @return the cntrCmBkgInfoVOs
     */
    public List<CntrCmBkgInfoVO> getCntrCmBkgInfoVOs() {
        return cntrCmBkgInfoVOs;
    }
    
    /**
     * @param cntrCmBkgInfoVOs the cntrCmBkgInfoVOs to set
     */
    public void setCntrCmBkgInfoVOs(List<CntrCmBkgInfoVO> cntrCmBkgInfoVOs) {
        this.cntrCmBkgInfoVOs = cntrCmBkgInfoVOs;
    }
    
    /**
     * @return the cntrCmEtcInfoVO
     */
    public CntrCmEtcInfoVO getCntrCmEtcInfoVO() {
        return cntrCmEtcInfoVO;
    }
    
    /**
     * @param cntrCmEtcInfoVO the cntrCmEtcInfoVO to set
     */
    public void setCntrCmEtcInfoVO(CntrCmEtcInfoVO cntrCmEtcInfoVO) {
        this.cntrCmEtcInfoVO = cntrCmEtcInfoVO;
    }
    
    /**
     * @return the cntrCmDescInfoVOs
     */
    public List<CntrCmDescInfoVO> getCntrCmDescInfoVOs() {
        return cntrCmDescInfoVOs;
    }
    
    /**
     * @param cntrCmDescInfoVOs the cntrCmDescInfoVOs to set
     */
    public void setCntrCmDescInfoVOs(List<CntrCmDescInfoVO> cntrCmDescInfoVOs) {
        this.cntrCmDescInfoVOs = cntrCmDescInfoVOs;
    }

}

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo;


import java.util.List;

import com.clt.syscommon.common.table.BkgNvoccProfCntrMfVO;
import com.clt.syscommon.common.table.BkgNvoccProfVO;

public class HblTmpltVO {
    
    
    private List<BkgNvoccProfCntrMfVO> bkgNvoccProfCntrMfVOs = null;
    private List<BkgNvoccProfVO> bkgNvoccProfVOs = null;
    
    public HblTmpltVO(){
        
    }

    
    /**
     * @return the bkgNvoccProfCntrMfVOs
     */
    public List<BkgNvoccProfCntrMfVO> getBkgNvoccProfCntrMfVOs() {
        return bkgNvoccProfCntrMfVOs;
    }

    
    /**
     * @param bkgNvoccProfCntrMfVOs the bkgNvoccProfCntrMfVOs to set
     */
    public void setBkgNvoccProfCntrMfVOs(List<BkgNvoccProfCntrMfVO> bkgNvoccProfCntrMfVOs) {
        this.bkgNvoccProfCntrMfVOs = bkgNvoccProfCntrMfVOs;
    }

    
    /**
     * @return the bkgNvoccProfVOs
     */
    public List<BkgNvoccProfVO> getBkgNvoccProfVOs() {
        return bkgNvoccProfVOs;
    }

    
    /**
     * @param bkgNvoccProfVOs the bkgNvoccProfVOs to set
     */
    public void setBkgNvoccProfVOs(List<BkgNvoccProfVO> bkgNvoccProfVOs) {
        this.bkgNvoccProfVOs = bkgNvoccProfVOs;
    }

}
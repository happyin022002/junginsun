/**
 * 
 */
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

import java.util.List;


/**
 * @author Sarang
 *
 */
public class GrpBlDtVO {
    
    private static final long serialVersionUID = 1L;
    
    private GrpBlDtInVO grpBlDtInVO = null;
    private List<GrpBlDtListVO> grpBlDtListVOs = null;
    
    public GrpBlDtVO(){
    }

    
    /**
     * @return the grpBlEtcVO
     */
    public GrpBlDtInVO getGrpBlDtInVO() {
        return grpBlDtInVO;
    }

    
    /**
     * @param grpBlEtcVO the grpBlEtcVO to set
     */
    public void setGrpBlDtInVO(GrpBlDtInVO grpBlDtInVO) {
        this.grpBlDtInVO = grpBlDtInVO;
    }

    
    /**
     * @return the grpBlDtListVOs
     */
    public List<GrpBlDtListVO> getGrpBlDtListVOs() {
        return grpBlDtListVOs;
    }

    
    /**
     * @param grpBlDtListVOs the grpBlDtListVOs to set
     */
    public void setGrpBlDtListVOs(List<GrpBlDtListVO> grpBlDtListVOs) {
        this.grpBlDtListVOs = grpBlDtListVOs;
    }
    
    
}

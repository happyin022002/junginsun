/**
 * 
 */
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

import java.util.List;

import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.FlatFileAckVO;


/**
 * @author Sarang
 *
 */
public class DblEdiVO {

    private String dblEdiSamf = null;
    private List<FlatFileAckVO> flatFileAckVOs = null;
    
    public DblEdiVO(){
        
    }
    
    /**
     * @return the dblEdiSamf
     */
    public String getDblEdiSamf() {
        return dblEdiSamf;
    }
    
    /**
     * @param dblEdiSamf the dblEdiSamf to set
     */
    public void setDblEdiSamf(String dblEdiSamf) {
        this.dblEdiSamf = dblEdiSamf;
    }
    
    /**
     * @return the flatFileAckVOs
     */
    public List<FlatFileAckVO> getFlatFileAckVOs() {
        return flatFileAckVOs;
    }
    
    /**
     * @param flatFileAckVOs the flatFileAckVOs to set
     */
    public void setFlatFileAckVOs(List<FlatFileAckVO> flatFileAckVOs) {
        this.flatFileAckVOs = flatFileAckVOs;
    }
    
    
}

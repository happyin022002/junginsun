package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

import java.util.List;

public class SheetOptionMasterSetVO {
    
    private List<SheetOptionTermTitleListUpVO> sheetOptionTermTitleListUpVO = null;
    
    private List<SheetOptionTermTitleListDwVO> sheetOptionTermTitleListDwVO = null;   
    
    private String shOptInfo = "";

    /**
    * @return the sheetOptionTermTitleListUpVO
    */
    public List<SheetOptionTermTitleListUpVO> getSheetOptionTermTitleListUpVO() {
        return sheetOptionTermTitleListUpVO;
    }

    /**
    * @param sheetOptionTermTitleListUpVO the sheetOptionTermTitleListUpVO to set
    */
    public void setSheetOptionTermTitleListUpVO(
            List<SheetOptionTermTitleListUpVO> sheetOptionTermTitleListUpVO) {
        this.sheetOptionTermTitleListUpVO = sheetOptionTermTitleListUpVO;
    }

    /**
    * @return the sheetOptionTermTitleListDwVO
    */
    public List<SheetOptionTermTitleListDwVO> getSheetOptionTermTitleListDwVO() {
        return sheetOptionTermTitleListDwVO;
    }

    /**
    * @param sheetOptionTermTitleListDwVO the sheetOptionTermTitleListDwVO to set
    */
    public void setSheetOptionTermTitleListDwVO(
            List<SheetOptionTermTitleListDwVO> sheetOptionTermTitleListDwVO) {
        this.sheetOptionTermTitleListDwVO = sheetOptionTermTitleListDwVO;
    }

    /**
    * @return the shOptInfo
    */
    public String getShOptInfo() {
        return shOptInfo;
    }

    /**
    * @param shOptInfo the shOptInfo to set
    */
    public void setShOptInfo(String shOptInfo) {
        this.shOptInfo = shOptInfo;
    }    

    
}

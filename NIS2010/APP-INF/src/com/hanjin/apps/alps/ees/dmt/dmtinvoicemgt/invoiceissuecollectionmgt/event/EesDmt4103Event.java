/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt4103Event.java
*@FileTitle : Sheet Option
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.09.29 mun jung cheol
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionSearchOptionVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionTermTitleListUpVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_DMT_4103 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_4103HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Mun Jung Cheol
 * @see EES_DMT_4105HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt4103Event extends EventSupport {
    
    private static final long serialVersionUID = 1L;
    
    private SheetOptionSearchOptionVO sheetOptionSearchOptionVO  = null;
    
    private SheetOptionSearchOptionVO[] sheetOptionSearchOptionVOs  = null;
    
    private SheetOptionTermTitleListUpVO sheetOptionTermTitleListUpVO  = null;
    
    private SheetOptionTermTitleListUpVO[] sheetOptionTermTitleListUpVOs  = null;    
    
    public EesDmt4103Event(){}

    /**
    * @return the sheetOptionSearchOptionVO
    */
    public SheetOptionSearchOptionVO getSheetOptionSearchOptionVO() {
        return sheetOptionSearchOptionVO;
    }

    /**
    * @param sheetOptionSearchOptionVO the sheetOptionSearchOptionVO to set
    */
    public void setSheetOptionSearchOptionVO(
            SheetOptionSearchOptionVO sheetOptionSearchOptionVO) {
        this.sheetOptionSearchOptionVO = sheetOptionSearchOptionVO;
    }

    /**
    * @return the sheetOptionSearchOptionVOs
    */
    public SheetOptionSearchOptionVO[] getSheetOptionSearchOptionVOs() {
        return sheetOptionSearchOptionVOs;
    }

    /**
    * @param sheetOptionSearchOptionVOs the sheetOptionSearchOptionVOs to set
    */
    public void setSheetOptionSearchOptionVOs(
            SheetOptionSearchOptionVO[] sheetOptionSearchOptionVOs) {
        this.sheetOptionSearchOptionVOs = sheetOptionSearchOptionVOs;
    }

    /**
    * @return the serialVersionUID
    */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
    * @return the sheetOptionTermTitleListUpVO
    */
    public SheetOptionTermTitleListUpVO getSheetOptionTermTitleListUpVO() {
        return sheetOptionTermTitleListUpVO;
    }

    /**
    * @param sheetOptionTermTitleListUpVO the sheetOptionTermTitleListUpVO to set
    */
    public void setSheetOptionTermTitleListUpVO(
            SheetOptionTermTitleListUpVO sheetOptionTermTitleListUpVO) {
        this.sheetOptionTermTitleListUpVO = sheetOptionTermTitleListUpVO;
    }

    /**
    * @return the sheetOptionTermTitleListUpVOs
    */
    public SheetOptionTermTitleListUpVO[] getSheetOptionTermTitleListUpVOs() {
        return sheetOptionTermTitleListUpVOs;
    }

    /**
    * @param sheetOptionTermTitleListUpVOs the sheetOptionTermTitleListUpVOs to set
    */
    public void setSheetOptionTermTitleListUpVOs(
            SheetOptionTermTitleListUpVO[] sheetOptionTermTitleListUpVOs) {
        this.sheetOptionTermTitleListUpVOs = sheetOptionTermTitleListUpVOs;
    }

    

}

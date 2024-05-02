/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt4101Event.java
*@FileTitle : Remark(s)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.10.01 mun jung cheol
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetSetSearchOptionVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetSettingInfoListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_DMT_4105 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_4105HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Mun Jung Cheol
 * @see EES_DMT_4105HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt4101Event extends EventSupport {
    
    private static final long serialVersionUID = 1L;
    
    private SheetSetSearchOptionVO sheetSetSearchOptionVO  = null;
    
    private SheetSetSearchOptionVO[] sheetSetSearchOptionVOs  = null;
    
    private SheetSettingInfoListVO sheetSettingInfoListVO  = null;
    
    private SheetSettingInfoListVO[] sheetSettingInfoListVOs  = null;    
    
    public EesDmt4101Event(){}

    /**
    * @return the sheetSetSearchOptionVO
    */
    public SheetSetSearchOptionVO getSheetSetSearchOptionVO() {
        return sheetSetSearchOptionVO;
    }

    /**
    * @param sheetSetSearchOptionVO the sheetSetSearchOptionVO to set
    */
    public void setSheetSetSearchOptionVO(
            SheetSetSearchOptionVO sheetSetSearchOptionVO) {
        this.sheetSetSearchOptionVO = sheetSetSearchOptionVO;
    }

    /**
    * @return the sheetSetSearchOptionVOs
    */
    public SheetSetSearchOptionVO[] getSheetSetSearchOptionVOs() {
        return sheetSetSearchOptionVOs;
    }

    /**
    * @param sheetSetSearchOptionVOs the sheetSetSearchOptionVOs to set
    */
    public void setSheetSetSearchOptionVOs(
            SheetSetSearchOptionVO[] sheetSetSearchOptionVOs) {
        this.sheetSetSearchOptionVOs = sheetSetSearchOptionVOs;
    }

    /**
    * @return the sheetSettingInfoListVO
    */
    public SheetSettingInfoListVO getSheetSettingInfoListVO() {
        return sheetSettingInfoListVO;
    }

    /**
    * @param sheetSettingInfoListVO the sheetSettingInfoListVO to set
    */
    public void setSheetSettingInfoListVO(
            SheetSettingInfoListVO sheetSettingInfoListVO) {
        this.sheetSettingInfoListVO = sheetSettingInfoListVO;
    }

    /**
    * @return the sheetSettingInfoListVOs
    */
    public SheetSettingInfoListVO[] getSheetSettingInfoListVOs() {
        return sheetSettingInfoListVOs;
    }

    /**
    * @param sheetSettingInfoListVOs the sheetSettingInfoListVOs to set
    */
    public void setSheetSettingInfoListVOs(
            SheetSettingInfoListVO[] sheetSettingInfoListVOs) {
        this.sheetSettingInfoListVOs = sheetSettingInfoListVOs;
    }


}

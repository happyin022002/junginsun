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

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetSetSearchOptionVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetSettingInfoListVO;
import com.clt.framework.support.layer.event.EventSupport;

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
    	SheetSetSearchOptionVO[] tmpVOs = null;
		if (this.sheetSetSearchOptionVOs != null) {
			tmpVOs = new SheetSetSearchOptionVO[sheetSetSearchOptionVOs.length];
			System.arraycopy(sheetSetSearchOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
    * @param sheetSetSearchOptionVOs the sheetSetSearchOptionVOs to set
    */
    public void setSheetSetSearchOptionVOs(
            SheetSetSearchOptionVO[] sheetSetSearchOptionVOs) {
    	if (sheetSetSearchOptionVOs != null) {
    		SheetSetSearchOptionVO[] tmpVOs = new SheetSetSearchOptionVO[sheetSetSearchOptionVOs.length];
			System.arraycopy(sheetSetSearchOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.sheetSetSearchOptionVOs = tmpVOs;
		}
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
    	SheetSettingInfoListVO[] tmpVOs = null;
		if (this.sheetSettingInfoListVOs != null) {
			tmpVOs = new SheetSettingInfoListVO[sheetSettingInfoListVOs.length];
			System.arraycopy(sheetSettingInfoListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
    * @param sheetSettingInfoListVOs the sheetSettingInfoListVOs to set
    */
    public void setSheetSettingInfoListVOs(
            SheetSettingInfoListVO[] sheetSettingInfoListVOs) {
    	if (sheetSettingInfoListVOs != null) {
    		SheetSettingInfoListVO[] tmpVOs = new SheetSettingInfoListVO[sheetSettingInfoListVOs.length];
			System.arraycopy(sheetSettingInfoListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.sheetSettingInfoListVOs = tmpVOs;
		}
    }


}

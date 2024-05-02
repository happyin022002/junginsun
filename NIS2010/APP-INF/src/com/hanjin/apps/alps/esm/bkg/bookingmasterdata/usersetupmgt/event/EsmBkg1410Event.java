/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : EsmBkg1215Event.java
*@FileTitle : Booking Allocation Master Table
*Open Issues :
 *Change history :
 *@LastModifyDate : 2013.12.30
 *@LastModifier : 최문환
 *@LastVersion : 1.0
 * 2013.12.30 최문환
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.WebBkgManualUploadSetupVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**\
 * ESM_BKG_1215 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1215HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Choi Moon Hwan
 * @see ESM_BKG_1215HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1410Event extends EventSupport {

    private static final long serialVersionUID = 1L;

    /** Table Value Object 조회 조건 및 단건 처리 */
    private WebBkgManualUploadSetupVO      webBkgManualUploadSetupVO     = null;
    private WebBkgManualUploadSetupVO[]    webBkgManualUploadSetupVOs    = null;

    public EsmBkg1410Event() {}
    
    
    /**
     * @return the webBkgManualUploadSetupVO
     */
    public WebBkgManualUploadSetupVO getWebBkgManualUploadSetupVO() {
        return webBkgManualUploadSetupVO;
    }
    
    /**
     * @return the webBkgManualUploadSetupVOs
     */
    public WebBkgManualUploadSetupVO[] getWebBkgManualUploadSetupVOs() {
        return webBkgManualUploadSetupVOs;
    }
    
    /**
     * @param webBkgManualUploadSetupVO the webBkgManualUploadSetupVO to set
     */
    public void setWebBkgManualUploadSetupVO(WebBkgManualUploadSetupVO webBkgManualUploadSetupVO) {
        this.webBkgManualUploadSetupVO = webBkgManualUploadSetupVO;
    }
    
    /**
     * @param webBkgManualUploadSetupVOs the webBkgManualUploadSetupVOs to set
     */
    public void setWebBkgManualUploadSetupVOs(WebBkgManualUploadSetupVO[] webBkgManualUploadSetupVOs) {
        this.webBkgManualUploadSetupVOs = webBkgManualUploadSetupVOs;
    }
  
    
}
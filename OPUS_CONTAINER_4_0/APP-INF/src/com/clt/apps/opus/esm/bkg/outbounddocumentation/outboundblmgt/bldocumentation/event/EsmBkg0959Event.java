/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg959Event.java
 *@FileTitle : Original AMS File No. for Split BL
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.22
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.07.22 김영출
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_959 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_959HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Youngchul
 * @see ESM_BKG_959HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0959Event extends EventSupport {

    private static final long serialVersionUID = 1L;
    
    private String orgCntrMfNo = null;

    public EsmBkg0959Event() {}

    /**
     * @param orgCntrMfNo the orgCntrMfNo to set
     */
    public void setOrgCntrMfNo(String orgCntrMfNo) {
        this.orgCntrMfNo = orgCntrMfNo;
    }

    /**
     * @return the orgCntrMfNo
     * @return String
     */
    public String getOrgCntrMfNo() {
        return orgCntrMfNo;
    }

}
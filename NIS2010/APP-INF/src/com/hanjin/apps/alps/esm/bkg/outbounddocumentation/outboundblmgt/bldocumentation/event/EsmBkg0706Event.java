/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0706Event.java
*@FileTitle : Mark And Description for C/M
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.06.16 김영출
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0706 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0706HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Youngchul
 * @see ESM_BKG_0706HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0706Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String mkDesc = null;
	private String gdsDesc = null;
	
	public EsmBkg0706Event(){}

    /**
     * @return the mkDesc
     */
    public String getMkDesc() {
        return mkDesc;
    }
    
    /**
     * @param mkDesc the mkDesc to set
     */
    public void setMkDesc(String mkDesc) {
        this.mkDesc = mkDesc;
    }
    
    /**
     * @return the gdsDesc
     */
    public String getGdsDesc() {
        return gdsDesc;
    }

    /**
     * @param gdsDesc the gdsDesc to set
     */
    public void setGdsDesc(String gdsDesc) {
        this.gdsDesc = gdsDesc;
    }

}
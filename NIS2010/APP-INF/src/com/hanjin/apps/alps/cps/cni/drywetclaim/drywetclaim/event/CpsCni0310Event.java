/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0310Event.java
 *@FileTitle : Handler History
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.04.19
 *@LastModifier : 정행룡
 *@LastVersion : 1.0
 * 2010.04.19 정행룡 
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0310] Handler History
 * @author 정행룡
 * @see CPS_CNI_0310HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0310Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    /* DW Case No */
    private String dwClmNo;
    
    public String getDwClmNo() {                    
        return dwClmNo;                                        
    }                     
    
    public void setDwClmNo(String dwClmNo) {
        this.dwClmNo = dwClmNo;   
    }    
    
}
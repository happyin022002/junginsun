/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0006Event.java
 *@FileTitle : Cargo Claim Report
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.20
 *@LastModifier : 정행룡
 *@LastVersion : 1.0
 * 2009.11.20 정행룡
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0006] Cargo Claim Report
 * @author 정행룡
 * @see CPS_CNI_0006HTMLAction 참조
 * @since J2EE 1.6
 */

public class CpsCni0006Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    /* Cargo Claim Number */
    private String cgoClmNo;
    
    /* Status */
    private String status;
    /**                                                                
     * Cargo Claim Number 
     * @return Cargo Claim Number
     */                                                                
    public String getCgoClmNo() {                    
        return cgoClmNo;                                        
    }
    
    public void setCgoClmNo(String cgoClmNo) {
        this.cgoClmNo = cgoClmNo;                        
    }
    
    public String getStatus() {                    
        return status;                                        
    }
    
    public void setStatus(String status) {
        this.status = status;                        
    }

    
	
}
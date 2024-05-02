/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0025Event.java
 *@FileTitle : Main Code Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.06
 *@LastModifier : 정행룡
 *@LastVersion : 1.0
 * 2009.10.06 정행룡 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.codemgt.codemgt.event;

import com.clt.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0004] Handler History
 * @author 정행룡
 * @see CPS_CNI_0004HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    /* CLAIM NUMBER */
    private String cgoClmNo;
    
    /* Manager Handler Division Cd*/
    private String mgrHdlrDivCd;
    
	/**                                                                
     * CLAIM NUMBER 가져오기
     * @return CLAIM NUMBER
     */                                                                
    public String getCgoClmNo() {                    
        return cgoClmNo;                                        
    }                     
    
    /**                                                                
     * CLAIM NUMBER 설정
     * @param cgoClmNo CARGO CLAIM NUMBER
     */                                                                
    public void setCgoClmNo(String cgoClmNo) {
        this.cgoClmNo = cgoClmNo;                        
    }
    
    /**                                                                
     *  Manager Handler Division Cd 가져오기
     * @return mgrHdlrDivCd
     */                                                                
    public String getMgrHdlrDivCd() {                    
        return mgrHdlrDivCd;                                        
    }                     
    
    /**                                                                
     *  Manager Handler Division Cd 설정
     * @param mgrHdlrDivCd
     */                                                                
    public void setMgrHdlrDivCd(String mgrHdlrDivCd) {
        this.mgrHdlrDivCd = mgrHdlrDivCd;                        
    }

}
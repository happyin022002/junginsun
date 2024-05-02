/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0311Event.java
 *@FileTitle : Manager History
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.04.19
 *@LastModifier : 정행룡
 *@LastVersion : 1.0
 * 2010.04.19 정행룡
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.event;

import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.HandlerHistoryVO;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0311] Manager History
 * @author 정행룡
 * @see CPS_CNI_0311HTMLAction 참조
 * @since J2EE 1.6
 */

public class CpsCni0311Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    /* DW Claim Number */
    private String dwClmNo;
    
    /* Handler History VO Multi Data 처리 */
    private HandlerHistoryVO[] handlerHistoryVOs = null;
    
    /**                                                                
     * DW Claim Number 
     * @return DW Claim Number
     */                                                                
    public String getDwClmNo() {                    
        return dwClmNo;                                        
    }                     
    
    /**                                                                
     * DW Claim Number 설정
     */                                                                
    public void setDwClmNo(String dwClmNo) {
        this.dwClmNo = dwClmNo;                        
    }
    
    
    /**                                                                
     * CniClassCodeVO 취득
     * @return CniClassCodeVO[]
     */   
	public HandlerHistoryVO[] handlerHistoryVOs() {
		return handlerHistoryVOs;
	}
    
    /**                                                                
     * set HandlerHistoryVO
     * @param handlerHistoryVOs
     * @return handlerHistoryVOs
     */ 
	public void setHandlerHistoryVOs(HandlerHistoryVO[] handlerHistoryVOs) {
		this.handlerHistoryVOs = handlerHistoryVOs;
	}

}
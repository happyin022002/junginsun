/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0005Event.java
 *@FileTitle : Manager History
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.08
 *@LastModifier : 정행룡
 *@LastVersion : 1.0
 * 2009.10.08 정행룡
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.codemgt.codemgt.event;


import java.util.Arrays;

import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.HandlerHistoryVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * [CPS_CNI_0005] Manager History
 * @author 정행룡
 * @see CPS_CNI_0005HTMLAction 참조
 * @since J2EE 1.6
 */

public class CpsCni0005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    /* Cargo Claim Number */
    private String cgoClmNo;
    
    /* Manager Handler Division Cd - "H", "M" */
    private String mgrHdlrDivCd;
    
    /* Handler History VO Multi Data 처리 */
    private HandlerHistoryVO[] handlerHistoryVOs = null;
    
    /**                                                                
     * Cargo Claim Number 
     * @return Cargo Claim Number
     */                                                                
    public String getCgoClmNo() {                    
        return cgoClmNo;                                        
    }                     
    
    /**                                                                
     * Cargo Claim Number 설정
     * @param cgoClmNo Cargo Claim Number
     */                                                                
    public void setCgoClmNo(String cgoClmNo) {
        this.cgoClmNo = cgoClmNo;                        
    }
    
    /**                                                                
     * Cargo Claim Number 
     * @return Cargo Claim Number
     */                                                                
    public String getMgrHdlrDivCd() {                    
        return mgrHdlrDivCd;                                        
    }                     
    
    /**                                                                
     * Cargo Claim Number 설정
     * @param cgoClmNo Cargo Claim Number
     */                                                                
    public void setMgrHdlrDivCd(String mgrHdlrDivCd) {
        this.mgrHdlrDivCd = mgrHdlrDivCd;                        
    }
    
    /**                                                                
     * CniClassCodeVO 취득
     * @return CniClassCodeVO[]
     */   
	public HandlerHistoryVO[] handlerHistoryVOs() {
		HandlerHistoryVO[] rtnVOs = null;
		if(this.handlerHistoryVOs != null){
			rtnVOs = Arrays.copyOf(handlerHistoryVOs, handlerHistoryVOs.length);
		}
		return rtnVOs;
	}
    
    /**                                                                
     * set HandlerHistoryVO
     * @param handlerHistoryVOs
     * @return handlerHistoryVOs
     */ 
	public void setHandlerHistoryVOs(HandlerHistoryVO[] handlerHistoryVOs) {
		if(handlerHistoryVOs !=null){
			HandlerHistoryVO[] tmpVOs = Arrays.copyOf(handlerHistoryVOs, handlerHistoryVOs.length);
			this.handlerHistoryVOs = tmpVOs;
		}
	}

}
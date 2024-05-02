/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0037Event.java
 *@FileTitle : Claim Reopen
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.19
 *@LastModifier : 정행룡
 *@LastVersion : 1.0
 * 2009.11.19 정행룡
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.event;

import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.HandlerHistoryVO;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0037] Claim Reopen
 * @author 정행룡
 * @see CPS_CNI_0037HTMLAction 참조
 * @since J2EE 1.6
 */

public class CpsCni0037Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    /* Cargo Claim Number */
    private String cgoClmNo;
    
    private CniCgoClmVO cniCgoClmVO;
    
    private String cgoClmStlTpCd; 
    
    private String smnsSveDt; 
    
    private HandlerHistoryVO handlerHistoryVO;
    
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

    
	public CniCgoClmVO getCniCgoClmVO() {
		return cniCgoClmVO;
	}
    
	public void setCniCgoClmVO(CniCgoClmVO cniCgoClmVO) {
		this.cniCgoClmVO = cniCgoClmVO;
	}
	
	public HandlerHistoryVO getHandlerHistoryVO() {
		return handlerHistoryVO;
	}
    
	public void setHandlerHistoryVO(HandlerHistoryVO handlerHistoryVO) {
		this.handlerHistoryVO = handlerHistoryVO;
	}
	
    public String getCgoClmStlTpCd() { 
        return cgoClmStlTpCd;
    }  

    public void setCgoClmStlTpCd(String cgoClmStlTpCd) { 
        this.cgoClmStlTpCd= cgoClmStlTpCd;
    } 

    public String getSmnsSveDt() { 
        return smnsSveDt;
    }  

    public void setSmnsSveDt(String smnsSveDt) { 
        this.smnsSveDt= smnsSveDt;
    }  

}	
	
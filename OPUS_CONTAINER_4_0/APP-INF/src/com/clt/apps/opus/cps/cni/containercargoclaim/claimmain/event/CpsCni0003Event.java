/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0003Event.java
 *@FileTitle : Claim Main
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.13
 *@LastModifier : 정행룡
 *@LastVersion : 1.0
 * 2009.10.13 정행룡
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.event;

import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.HandlerHistoryVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.BlGetVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.ClaimMainCntVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.ClaimMainVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniAreaOfcVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * [CPS_CNI_0003] Claim Main
 * @author 정행룡
 * @see CPS_CNI_0003HTMLAction 참조
 * @since J2EE 1.6
 */

public class CpsCni0003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    /* Cargo Claim Number */
    private String cgoClmNo;
    
    /* Office Cd */
    private String ofcCd;
    
    /* Class Code */
    private String clssClmMiscCd;
    
    private String clmMiscCd; 
    
    private String fmalClmRcvOfcCd; 
    
    /* B/L No */
    private String cgoClmRefBlNo;
    
    /* Incident No */
    private String cgoClmInciNo;
    
    /* Area Office Cd VO */
    private CniAreaOfcVO cniAreaOfcVO;
    
    /* Claim Main VO */
    private ClaimMainVO claimMainVO;
    
    /* B/L VO */
    private BlGetVO blGetVO;
    
    private ClaimMainCntVO claimMainCntVO;
    
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

    public String getOfcCd() {                    
        return ofcCd;                                        
    }
    
    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;                        
    }
    
    public String getClssClmMiscCd() {                    
        return clssClmMiscCd;                                        
    }
    
    public void setClssClmMiscCd(String clssClmMiscCd) {
        this.clssClmMiscCd = clssClmMiscCd;                        
    }
    
    public String getCgoClmInciNo() {                    
        return cgoClmInciNo;                                        
    }
    
    public void setCgoClmInciNo(String cgoClmInciNo) {
        this.cgoClmInciNo = cgoClmInciNo;                        
    }
    
    public String getCgoClmRefBlNo() {                    
        return cgoClmRefBlNo;                                        
    }
    
    public void setCgoClmRefBlNo(String cgoClmRefBlNo) {
        this.cgoClmRefBlNo = cgoClmRefBlNo;                        
    }
 
	public ClaimMainVO getClaimMainVO() {
		return claimMainVO;
	}
    
	public void setClaimMainVO(ClaimMainVO claimMainVO) {
		this.claimMainVO = claimMainVO;
	}
	
	public CniAreaOfcVO getCniAreaOfcVO() {
		return cniAreaOfcVO;
	}
    
	public void setCniAreaOfcVO(CniAreaOfcVO cniAreaOfcVO) {
		this.cniAreaOfcVO = cniAreaOfcVO;
	}
	
	public BlGetVO getBlGetVO() {
		return blGetVO;
	}
    
	public void setBlGetVO(BlGetVO blGetVO) {
		this.blGetVO = blGetVO;
	}
	
	public ClaimMainCntVO getClaimMainCntVO() {
		return claimMainCntVO;
	}
    
	public void setClaimMainCntVO(ClaimMainCntVO claimMainCntVO) {
		this.claimMainCntVO = claimMainCntVO;
	}
	
	public HandlerHistoryVO getHandlerHistoryVO() {
		return handlerHistoryVO;
	}
    
	public void setHandlerHistoryVO(HandlerHistoryVO handlerHistoryVO) {
		this.handlerHistoryVO = handlerHistoryVO;
	}
	
    
    public String getClmMiscCd() { 
        return clmMiscCd;
    }  

    public void setClmMiscCd(String clmMiscCd) { 
        this.clmMiscCd= clmMiscCd;
    }  
    
    public String getFmalClmRcvOfcCd() { 
        return fmalClmRcvOfcCd;
    }  

    public void setFmalClmRcvOfcCd(String fmalClmRcvOfcCd) { 
        this.fmalClmRcvOfcCd= fmalClmRcvOfcCd;
    }  
}
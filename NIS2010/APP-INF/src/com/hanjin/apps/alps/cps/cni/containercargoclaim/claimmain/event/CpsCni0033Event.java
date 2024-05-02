/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0033Event.java
 *@FileTitle : View Claim Main
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.29
 *@LastModifier : 정행룡
 *@LastVersion : 1.0
 * 2009.10.29 정행룡
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.event;

import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.ClaimMainVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniAreaOfcVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.ClaimMainCntVO;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0033] View Claim Main
 * @author 정행룡
 * @see CPS_CNI_0033HTMLAction 참조
 * @since J2EE 1.6
 */

public class CpsCni0033Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    /* Cargo Claim Number */
    private String cgoClmNo;
    
    /* Office Cd */
    private String ofcCd;
    
    /* Class Code */
    private String clssClmMiscCd;
    
    /* B/L No */
    private String cgoClmRefBlNo;
    
    /* Area Office Cd VO */
    private CniAreaOfcVO cniAreaOfcVO;
    
    /* Claim Main VO */
    private ClaimMainVO claimMainVO;
    
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
}	
	
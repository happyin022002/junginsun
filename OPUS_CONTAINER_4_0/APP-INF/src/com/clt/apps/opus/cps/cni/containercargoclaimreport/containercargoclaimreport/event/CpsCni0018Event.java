/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0018Event.java
 *@FileTitle : Status
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.09
 *@LastModifier : 정행룡
 *@LastVersion : 1.0
 * 2009.10.13 정행룡
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.event;

import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.StatusCondVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.StatusVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0018] Status
 * @author 정행룡
 * @see CPS_CNI_0018HTMLAction 참조
 * @since J2EE 1.6
 */

public class CpsCni0018Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    /* Cargo Claim Number */
    private String cgoClmNo;
    
    /* Office Cd */
    private String ofcCd;
    
    /* Class Code */
    private String clssClmMiscCd;
    
    /* B/L No */
    private String cgoClmRefBlNo;
    
    /* Incident No */
    private String cgoClmInciNo;
    

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
 
	 /* VO */
    private StatusVO statusVO;
    
    public StatusVO getStatusVO() {
		return statusVO;
	}

	public void setStatusVO(StatusVO statusVO) {
		this.statusVO = statusVO;
	}
    
    private StatusCondVO statusCondVO;
    
    public StatusCondVO getStatusCondVO() {
		return statusCondVO;
	}

	public void setStatusCondVO(StatusCondVO statusCondVO) {
		this.statusCondVO = statusCondVO;
	}
	
	private String pageNo;

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
}
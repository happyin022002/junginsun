/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0028Event.java
 *@FileTitle : Misc Code Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.14
 *@LastModifier : 박제성
 *@LastVersion : 1.0
 * 2009.10.14 박제성 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.codemgt.codemgt.event;


import java.util.Arrays;

import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.CniMiscCodeVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0028] Misc Code Creation
 * @author 박제성
 * @see CPS_CNI_0028HTMLAction 참조
 * @since J2EE 1.6
 */ 

public class CpsCni0028Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Com Code Id */
	private String comCdId = "";
	
	/** Com Code */
	private String comCode = "";
	
	/** Com Text */
	private String comText = "";
	
	/* CLASS MISC CD */
    private String clssClmMiscCd;
    
	/* MISC CD */
    private String clmMiscCd;
    
	/* MISC NAME */
    private String clmMiscNm;
    
	/** Table Value Object Multi Data 처리 */
	private CniMiscCodeVO[] cniMiscCodeVOs = null;
    
	
	/**                                                                
     * clssClmMiscCd 취득
     * @return clssClmMiscCd
     */                                                                
    public String getClssClmMiscCd() {                    
        return clssClmMiscCd;                                        
    }                     
    
    /**                                                                
     * clssClmMiscCd 설정
     * @param clssClmMiscCd
     */                                                                
    public void setClssClmMiscCd(String clssClmMiscCd) {
        this.clssClmMiscCd = clssClmMiscCd;                        
    }
    
    
	/**                                                                
     * clmMiscCd 취득
     * @return clmMiscCd
     */                                                                
    public String getClmMiscCd() {                    
        return clmMiscCd;                                        
    }                     
    
    /**                                                                
     * clmMiscCd 설정
     * @param clmMiscCd
     */                                                                
    public void setClmMiscCd(String clmMiscCd) {
        this.clmMiscCd = clmMiscCd;                        
    }
    
	/**                                                                
     * clmMiscNm 취득
     * @return clmMiscNm
     */                                                                
    public String getClmMiscNm() {                    
        return clmMiscNm;                                        
    }                     
    
    /**                                                                
     * clmMiscNm 설정
     * @param clmMiscNm
     */                                                                
    public void setClmMiscNm(String clmMiscNm) {
        this.clmMiscNm = clmMiscNm;                        
    }  

    
	/**                                                                
     * CniMiscCodeVO 취득
     * @return CniMiscCodeVO[]
     */   
	public CniMiscCodeVO[] getCniMiscCodeVOs() {
		CniMiscCodeVO[] rtnVOs = null;
		if (this.cniMiscCodeVOs != null) {
			rtnVOs = Arrays.copyOf(cniMiscCodeVOs, cniMiscCodeVOs.length);
		}
		return rtnVOs;
	}
	

	/**                                                                
     * CniMiscCodeVO 설정
     * @param CniMiscCodeVO[]
     */   
	
	public void setCniMiscCodeVOs(CniMiscCodeVO[] cniMiscCodeVOs){
		if(cniMiscCodeVOs != null){
			CniMiscCodeVO[] tmpVOs = Arrays.copyOf(cniMiscCodeVOs, cniMiscCodeVOs.length);
			this.cniMiscCodeVOs = tmpVOs;
		}
	}
	
	public void setComCdId(String comCdId) {
		this.comCdId = comCdId;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public void setComText(String comText) {
		this.comText = comText;
	}
	public String getComCdId() {
		return comCdId;
	}
	
	public String getComCode() {
		return comCode;
	}
	
	public String getComText() {
		return comText;
	}
}
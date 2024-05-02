/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0025Event.java
 *@FileTitle : Main Code Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.10.05 진윤오 
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.codemgt.codemgt.event;


import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.CniCntcPntVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.CniPartyVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.PartyCntVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0025] Main Code Creation
 * @author choijungmi
 * @see CPS_CNI_0025HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0025Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    /* CLAIM PARTY NUMBER */
    private String clmPtyNo;

    /* Party Container VO */
    private PartyCntVO partyCntVO;
    

	public PartyCntVO getPartyCntVO() {
		return partyCntVO;
	}

	public void setPartyCntVO(PartyCntVO partyCntVO) {
		this.partyCntVO = partyCntVO;
	}

	/**                                                                
     * CLAIM PARTY NUMBER 취득
     * @return CLAIM PARTY NUMBER
     */                                                                
    public String getClmPtyNo() {                    
        return clmPtyNo;                                        
    }                     
    
    /**                                                                
     * CLAIM PARTY NUMBER 설정
     * @param clmPtyNo CLAIM PARTY NUMBER
     */                                                                
    public void setClmPtyNo(String clmPtyNo) {
        this.clmPtyNo = clmPtyNo;                        
    }  

}
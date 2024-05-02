/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0010Event.java
 *@FileTitle : ContractCarriage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.04
 *@LastModifier : 박제성
 *@LastVersion : 1.0
 * 2009.11.04 박제성
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.event;


import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmBlDtlVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmCntrDtlVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.ContractCarriageVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmCtrtVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0010] ContractCarriage
 * @author 박제성
 * @see CPS_CNI_0010HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0010Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    /* Cargo Claim Number */
    private String cgoClmNo;
    private String cgoClmRefBlNo;

    /* VO */
    private ContractCarriageVO contractCarriageVO;
    private CniCgoClmCtrtVO cniCgoClmCtrtVO;
    
    /* B/L NO */
    private String blNo;
    
	/** Table Value Object Multi Data 처리 */
	private CniCgoClmBlDtlVO[] cniCgoClmBlDtlVOs = null;
	
	private CniCgoClmCntrDtlVO[] cniCgoClmCntrDtlVOs = null;
	
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
    
    
    public String getCgoClmRefBlNo() {                    
        return cgoClmRefBlNo;                                        
    }
    
    public void setCgoClmRefBlNo(String cgoClmRefBlNo) {
        this.cgoClmRefBlNo = cgoClmRefBlNo;                        
    }
    
    public ContractCarriageVO getContractCarriageVO() {
		return contractCarriageVO;
	}

	public void setContractCarriageVO(ContractCarriageVO contractCarriageVO) {
		this.contractCarriageVO = contractCarriageVO;
	}



	public CniCgoClmCtrtVO getCniCgoClmCtrtVO() {
		return cniCgoClmCtrtVO;
	}

	public void setCniCgoClmCtrtVO(CniCgoClmCtrtVO cniCgoClmCtrtVO) {
		this.cniCgoClmCtrtVO = cniCgoClmCtrtVO;
	}
	
	/**                                                                
     * CniCgoClmBlDtlVO 취득
     * @return CniCgoClmBlDtlVO[]
     */   
	public CniCgoClmBlDtlVO[] getCniCgoClmBlDtlVOs() {
		return cniCgoClmBlDtlVOs;
	}
	

	/**                                                                
     * CniCgoClmBlDtlVO 설정
     * @param CniCgoClmBlDtlVO[]
     */   
	public void setCniCgoClmBlDtlVOs(CniCgoClmBlDtlVO[] cniCgoClmBlDtlVOs) {
		this.cniCgoClmBlDtlVOs = cniCgoClmBlDtlVOs;
	}
	
	
	/**                                                                
     * CniCgoClmCntrDtlVO 취득
     * @return CniCgoClmCntrDtlVO[]
     */   
	public CniCgoClmCntrDtlVO[] getCniCgoClmCntrDtlVOs() {
		return cniCgoClmCntrDtlVOs;
	}
	

	/**                                                                
     * CniCgoClmCntrDtlVO 설정
     * @param CniCgoClmCntrDtlVO[]
     */   
	public void setCniCgoClmCntrDtlVOs(CniCgoClmCntrDtlVO[] cniCgoClmCntrDtlVOs) {
		this.cniCgoClmCntrDtlVOs = cniCgoClmCntrDtlVOs;
	}
	
	public String getBlNo() {
		return blNo;
	}

	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

}
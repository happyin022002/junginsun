/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0034Event.java
 *@FileTitle : View-ContractCarriage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.23
 *@LastModifier : 박제성
 *@LastVersion : 1.0
 * 2009.11.23 박제성
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.event;


import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmBlDtlVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmCntrDtlVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmCtrtVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.ContractCarriageVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0034] View-ContractCarriage
 * @author 박제성
 * @see CPS_CNI_0034HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0034Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    /* Cargo Claim Number */
    private String cgoClmNo;
    private String cgoClmRefBlNo;

    /* VO */
    private ContractCarriageVO contractCarriageVO;
    private CniCgoClmCtrtVO cniCgoClmCtrtVO;
    
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
		CniCgoClmBlDtlVO[] rtnVOs = null;
		if (this.cniCgoClmBlDtlVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(cniCgoClmBlDtlVOs, cniCgoClmBlDtlVOs.length);
		}
		return rtnVOs;
	}
	

	/**                                                                
     * CniCgoClmBlDtlVO 설정
     * @param CniCgoClmBlDtlVO[]
     */   
	public void setCniCgoClmBlDtlVOs(CniCgoClmBlDtlVO[] cniCgoClmBlDtlVOs){
		if(cniCgoClmBlDtlVOs != null){
			CniCgoClmBlDtlVO[] tmpVOs = java.util.Arrays.copyOf(cniCgoClmBlDtlVOs, cniCgoClmBlDtlVOs.length);
			this.cniCgoClmBlDtlVOs = tmpVOs;
		}
	}
	
	
	/**                                                                
     * CniCgoClmCntrDtlVO 취득
     * @return CniCgoClmCntrDtlVO[]
     */   
	public CniCgoClmCntrDtlVO[] getCniCgoClmCntrDtlVOs() {
		CniCgoClmCntrDtlVO[] rtnVOs = null;
		if (this.cniCgoClmCntrDtlVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(cniCgoClmCntrDtlVOs, cniCgoClmCntrDtlVOs.length);
		}
		return rtnVOs;
	}
	

	/**                                                                
     * CniCgoClmCntrDtlVO 설정
     * @param CniCgoClmCntrDtlVO[]
     */   
	public void setCniCgoClmCntrDtlVOs(CniCgoClmCntrDtlVO[] cniCgoClmCntrDtlVOs){
		if(cniCgoClmCntrDtlVOs != null){
			CniCgoClmCntrDtlVO[] tmpVOs = java.util.Arrays.copyOf(cniCgoClmCntrDtlVOs, cniCgoClmCntrDtlVOs.length);
			this.cniCgoClmCntrDtlVOs = tmpVOs;
		}
	}



}
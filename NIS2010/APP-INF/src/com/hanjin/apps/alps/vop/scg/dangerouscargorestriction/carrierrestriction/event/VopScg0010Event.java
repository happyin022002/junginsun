/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0010Event.java
*@FileTitle : VSL OPR's Restriction on DG (Inquiry)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.15 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ScgImdgCrrRstrVO;


/**
 * VOP_SCG_0010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see VOP_SCG_0010HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0010Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String pCrrCd = "";
	private String pImdgClssCd = "";
	private String pImdgClssCdDesc = "";
	private String pImdgUnNo = "";
	private String pImdgUnNoSeq = "";	
    private String pPrpShpNm = "";    
    private String pSearchMethod = "";    
    
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgCrrRstrVO scgImdgCrrRstrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgImdgCrrRstrVO[] scgImdgCrrRstrVOs = null;

	public VopScg0010Event(){}
	
	public void setScgImdgCrrRstrVO(ScgImdgCrrRstrVO scgImdgCrrRstrVO){
		this. scgImdgCrrRstrVO = scgImdgCrrRstrVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgImdgCrrRstrVOS(ScgImdgCrrRstrVO[] scgImdgCrrRstrVOs){
		if (scgImdgCrrRstrVOs != null) {
			ScgImdgCrrRstrVO[] tmpVOs = new ScgImdgCrrRstrVO[scgImdgCrrRstrVOs.length];
			System.arraycopy(scgImdgCrrRstrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgImdgCrrRstrVOs = tmpVOs;
		}
	}

	public ScgImdgCrrRstrVO getScgImdgCrrRstrVO(){
		return scgImdgCrrRstrVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgImdgCrrRstrVO[] getScgImdgCrrRstrVOS(){
		ScgImdgCrrRstrVO[] rtnVOs = null;
		if (this.scgImdgCrrRstrVOs != null) {
			rtnVOs = new ScgImdgCrrRstrVO[scgImdgCrrRstrVOs.length];
			System.arraycopy(scgImdgCrrRstrVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

    /**
     * @return the pCrrCd
     */
    public String getPCrrCd() {
        return pCrrCd;
    }

    /**
     * @return the pImdgClssCd
     */
    public String getPImdgClssCd() {
        return pImdgClssCd;
    }

    /**
     * @return the pImdgClssCd_desc
     */
    public String getPImdgClssCdDesc() {
        return pImdgClssCdDesc;
    }

    /**
     * @return the pImdgUnNo
     */
    public String getPImdgUnNo() {
        return pImdgUnNo;
    }

    /**
     * @return the pImdgUnNoSeq
     */
    public String getPImdgUnNoSeq() {
        return pImdgUnNoSeq;
    }

    /**
     * @return the pPrpShpNm
     */
    public String getPPrpShpNm() {
        return pPrpShpNm;
    }

    /**
     * @return the scgImdgCrrRstrVOs
     */
    //2015.08.17 Secure Coding 적용 [CWE-495]
    public ScgImdgCrrRstrVO[] getScgImdgCrrRstrVOs() {
		ScgImdgCrrRstrVO[] rtnVOs = null;
		if (this.scgImdgCrrRstrVOs != null) {
			rtnVOs = new ScgImdgCrrRstrVO[scgImdgCrrRstrVOs.length];
			System.arraycopy(scgImdgCrrRstrVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
    }

    /**
     * @param crrCd the pCrrCd to set
     */
    public void setPCrrCd(String crrCd) {
        pCrrCd = crrCd;
    }

    /**
     * @param imdgClssCd the pImdgClssCd to set
     */
    public void setPImdgClssCd(String imdgClssCd) {
        pImdgClssCd = imdgClssCd;
    }

    /**
     * @param imdgClssCd_desc the pImdgClssCd_desc to set
     */
    public void setPImdgClssCd_desc(String imdgClssCdDesc) {
        pImdgClssCdDesc = imdgClssCdDesc;
    }

    /**
     * @param imdgUnNo the pImdgUnNo to set
     */
    public void setPImdgUnNo(String imdgUnNo) {
        pImdgUnNo = imdgUnNo;
    }

    /**
     * @param imdgUnNoSeq the pImdgUnNoSeq to set
     */
    public void setPImdgUnNoSeq(String imdgUnNoSeq) {
        pImdgUnNoSeq = imdgUnNoSeq;
    }

    /**
     * @param prpShpNm the pPrpShpNm to set
     */
    public void setPPrpShpNm(String prpShpNm) {
        pPrpShpNm = prpShpNm;
    }

    /**
     * @param scgImdgCrrRstrVOs the scgImdgCrrRstrVOs to set
     */
    //2015.08.17 Secure Coding 적용 [CWE-495]
    public void setScgImdgCrrRstrVOs(ScgImdgCrrRstrVO[] scgImdgCrrRstrVOs) {
		if (scgImdgCrrRstrVOs != null) {
			ScgImdgCrrRstrVO[] tmpVOs = new ScgImdgCrrRstrVO[scgImdgCrrRstrVOs.length];
			System.arraycopy(scgImdgCrrRstrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgImdgCrrRstrVOs = tmpVOs;
		}
    }

    /**
     * @return the pSearchMethod
     */
    public String getPSearchMethod() {
        return pSearchMethod;
    }

    /**
     * @param searchMethod the pSearchMethod to set
     */
    public void setPSearchMethod(String searchMethod) {
        pSearchMethod = searchMethod;
    }

    

}
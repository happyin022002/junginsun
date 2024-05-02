/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0006Event.java
*@FileTitle : DG Restriction by Port (Inquiry)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.08 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.event;

import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.vo.PortRestrictionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_SCG_0006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see VOP_SCG_0006HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0006Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    private String pPortCd = "";
    private String pImdgClssCd = "";
    private String pImdgClssCdDesc = "";
    private String pImdgUnNo = "";
    private String pImdgUnNoSeq = "";    
    private String pPrpShpNm = "";    
    
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PortRestrictionVO portRestrictionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PortRestrictionVO[] portRestrictionVOs = null;

	public VopScg0006Event(){}
	
	public void setSearchScgImdgPortRstrVO(PortRestrictionVO PortRestrictionVO){
		this. portRestrictionVO = PortRestrictionVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setSearchScgImdgPortRstrVOS(PortRestrictionVO[] portRestrictionVOs){
		if (portRestrictionVOs != null) {
			PortRestrictionVO[] tmpVOs = new PortRestrictionVO[portRestrictionVOs.length];
			System.arraycopy(portRestrictionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.portRestrictionVOs = tmpVOs;
		}
	}

	public PortRestrictionVO getSearchScgImdgPortRstrVO(){
		return portRestrictionVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public PortRestrictionVO[] getSearchScgImdgPortRstrVOS(){
		PortRestrictionVO[] rtnVOs = null;
		if (this.portRestrictionVOs != null) {
			rtnVOs = new PortRestrictionVO[portRestrictionVOs.length];
			System.arraycopy(portRestrictionVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

    /**
     * @return the pPortCd
     */
    public String getPPortCd() {
        return pPortCd;
    }

    /**
     * @return the pImdgClssCd
     */
    public String getPImdgClssCd() {
        return pImdgClssCd;
    }

    /**
     * @return the pImdgClssCdDesc
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
     * @return the portRestrictionVO
     */
    public PortRestrictionVO getPortRestrictionVO() {
        return portRestrictionVO;
    }

    /**
     * @return the portRestrictionVOs
     */
    //2015.08.17 Secure Coding 적용 [CWE-495]
    public PortRestrictionVO[] getPortRestrictionVOs() {
		PortRestrictionVO[] rtnVOs = null;
		if (this.portRestrictionVOs != null) {
			rtnVOs = new PortRestrictionVO[portRestrictionVOs.length];
			System.arraycopy(portRestrictionVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
    }

    /**
     * @param portCd the pPortCd to set
     */
    public void setPPortCd(String portCd) {
        pPortCd = portCd;
    }

    /**
     * @param imdgClssCd the pImdgClssCd to set
     */
    public void setPImdgClssCd(String imdgClssCd) {
        pImdgClssCd = imdgClssCd;
    }

    /**
     * @param imdgClssCdDesc the pImdgClssCdDesc to set
     */
    public void setPImdgClssCdDesc(String imdgClssCdDesc) {
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
     * @param portRestrictionVO the portRestrictionVO to set
     */
    public void setPortRestrictionVO(PortRestrictionVO portRestrictionVO) {
        this.portRestrictionVO = portRestrictionVO;
    }

    /**
     * @param portRestrictionVOs the portRestrictionVOs to set
     */
    //2015.08.17 Secure Coding 적용 [CWE-495]
    public void setPortRestrictionVOs(PortRestrictionVO[] portRestrictionVOs) {
		if (portRestrictionVOs != null) {
			PortRestrictionVO[] tmpVOs = new PortRestrictionVO[portRestrictionVOs.length];
			System.arraycopy(portRestrictionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.portRestrictionVOs = tmpVOs;
		}
   }
 
 
}
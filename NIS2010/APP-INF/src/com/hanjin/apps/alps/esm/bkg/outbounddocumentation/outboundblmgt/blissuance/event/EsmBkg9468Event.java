/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmBkg9468Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.23
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2014.09.23 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgCustBlPprMgmtHisVO;


/**
 * ESM_BKG_9468 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_9468HTMLAction에서 작성<br>
 * - ServiceCommand Layer 로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong-ho
 * @see ESM_BKG_9468HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg9468Event extends EventSupport {

    private static final long serialVersionUID = 1L;
    
    /** Table Value Object 조회 조건 및 단건 처리  */
    private BkgCustBlPprMgmtHisVO blPprMgmtHisVO = null;
    /** Table Value Object Multi Data 처리 */
    private BkgCustBlPprMgmtHisVO[] blPprMgmtHisVOs = null;
	private String bkgNo = null;
	private String ofcCd = null;

    
    
    
    public EsmBkg9468Event() {}

    /**
	 * @return BkgCustBlPprMgmtHisVO
	 */
    public BkgCustBlPprMgmtHisVO getBkgCustBlPprMgmtHisVO() {
        return blPprMgmtHisVO;
    }

	/**
	 * @param BkgCustBlPprMgmtHisVO blPprMgmtHisVO
	 */
    public void setBkgCustBlPprMgmtHisVO(BkgCustBlPprMgmtHisVO blPprMgmtHisVO) {
        this.blPprMgmtHisVO = blPprMgmtHisVO;
    }

	/**
	 * @return BkgCustBlPprMgmtHisVO[]
	 */
    public BkgCustBlPprMgmtHisVO[] getBkgCustBlPprMgmtHisVOs() {
		BkgCustBlPprMgmtHisVO[] rtnVOs = null;
		if (this.blPprMgmtHisVOs != null) {
			rtnVOs = new BkgCustBlPprMgmtHisVO[blPprMgmtHisVOs.length];
			System.arraycopy(blPprMgmtHisVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
    }

	/**
	 * @param BkgCustBlPprMgmtHisVO[] blPprMgmtHisVOs
	 */
    public void setBkgCustBlPprMgmtHisVOs(BkgCustBlPprMgmtHisVO[] blPprMgmtHisVOs){
		if(blPprMgmtHisVOs != null){
			BkgCustBlPprMgmtHisVO[] tmpVOs = new BkgCustBlPprMgmtHisVO[blPprMgmtHisVOs.length];
			System.arraycopy(blPprMgmtHisVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.blPprMgmtHisVOs = tmpVOs;
		}
    }

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}


    
    
    
}
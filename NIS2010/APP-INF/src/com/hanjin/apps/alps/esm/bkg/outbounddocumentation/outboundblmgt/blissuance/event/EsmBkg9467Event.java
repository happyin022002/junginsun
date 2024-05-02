/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmBkg9467Event.java
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
import com.hanjin.syscommon.common.table.BkgCustBlPprMgmtVO;


/**
 * ESM_BKG_9467 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_9467HTMLAction에서 작성<br>
 * - ServiceCommand Layer 로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong-ho
 * @see ESM_BKG_9467HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg9467Event extends EventSupport {

    private static final long serialVersionUID = 1L;
    
    /** Table Value Object 조회 조건 및 단건 처리  */
    private BkgCustBlPprMgmtVO blPprMgmtVO = null;
    /** Table Value Object Multi Data 처리 */
    private BkgCustBlPprMgmtVO[] blPprMgmtVOs = null;
	private String bkgNo = null;
	private String ofcCd = null;

    
    
    
    public EsmBkg9467Event() {}

    /**
	 * @return BkgCustBlPprMgmtVO
	 */
    public BkgCustBlPprMgmtVO getBkgCustBlPprMgmtVO() {
        return blPprMgmtVO;
    }

	/**
	 * @param BkgCustBlPprMgmtVO blPprMgmtVO
	 */
    public void setBkgCustBlPprMgmtVO(BkgCustBlPprMgmtVO blPprMgmtVO) {
        this.blPprMgmtVO = blPprMgmtVO;
    }

	/**
	 * @return BlPprMgmtVO[]
	 */
    public BkgCustBlPprMgmtVO[] getBkgCustBlPprMgmtVOs() {
		BkgCustBlPprMgmtVO[] rtnVOs = null;
		if (this.blPprMgmtVOs != null) {
			rtnVOs = new BkgCustBlPprMgmtVO[blPprMgmtVOs.length];
			System.arraycopy(blPprMgmtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
    }

	/**
	 * @param BkgCustBlPprMgmtVO[] blPprMgmtVOs
	 */
    public void setBkgCustBlPprMgmtVOs(BkgCustBlPprMgmtVO[] blPprMgmtVOs){
		if(blPprMgmtVOs != null){
			BkgCustBlPprMgmtVO[] tmpVOs = new BkgCustBlPprMgmtVO[blPprMgmtVOs.length];
			System.arraycopy(blPprMgmtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.blPprMgmtVOs = tmpVOs;
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
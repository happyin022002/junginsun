/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : DoMstVO.java
*@FileTitle      :
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009-09-16
*@LastModifier   : 
*@LastVersion    : 1.0
* 2009-09-16 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.syscommon.common.table.BkgDoRefVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DoMstVO {

    private DoBlInfoVO blInfo;
    private EdoRqstStsVO edoRqstSts;
    private BlIssVO blIss;
    private OtsRcvInfoVO otsRcvInfoVO; //운임 결재 여부와 Outstanding Amounts 정보를 ERP 시스템으로 부터 수신 받는 Value Object
    private String[] cntrNo;
    private String mrdId;
    private String localLangFlg;
    private BkgDoRefVO bkgDoRefVO;
    private String splitFlg;
    private int cntrCnt;
    private List<DoRlseStsVO> doRlseStsVOs;
    private List<DoCntrRlseStsVO> doCntrRlseStsVOs;
    private GenDoBlInfoVO genBlInfo;
    
    private List<EuDoRlseStsVO> euDoRlseStsVOs;
    private List<EuDoCntrRlseStsVO> euDoCntrRlseStsVOs;
    /**
     * Dor Interface 발행 실적 및 상태정보
     */
    private String dorStsCd = "";

    /**
     * DOR I/F된 DOR들 중 DOR Transmit이 되지 않은 B/L의 개수
     */
    private String dorStowage = "";
    
    /**
     * 생성자
     */
    public DoMstVO() {
    }

    /**
     * @return the otsRcvInfoVO
     */
    public OtsRcvInfoVO getOtsRcvInfoVO() {
        return otsRcvInfoVO;
    }

    /**
     * @param otsRcvInfoVO the otsRcvInfoVO to set
     */
    public void setOtsRcvInfoVO(OtsRcvInfoVO otsRcvInfoVO) {
        this.otsRcvInfoVO = otsRcvInfoVO;
    }

    /**
     * @param blInfo the blInfo to set
     */
    public void setBlInfo(DoBlInfoVO blInfo) {
        this.blInfo = blInfo;
    }

    /**
     * @return the blInfo
     */
    public DoBlInfoVO getBlInfo() {
        return blInfo;
    }

	/**
     * @param edoRqstSts the edoRqstSts to set
     */
    public void setEdoRqstSts(EdoRqstStsVO edoRqstSts) {
        this.edoRqstSts = edoRqstSts;
    }

    /**
     * @return the edoRqstSts
     */
    public EdoRqstStsVO getEdoRqstSts() {
        return edoRqstSts;
    }

    /**
     * @param cntrNo the cntrNo to set
     */
    public void setCntrNo(String[] cntrNo) {
        this.cntrNo = cntrNo;
    }

    /**
     * @return the cntrNo
     */
    public String[] getCntrNo() {
        return cntrNo;
    }


	/**
	 * @param mrdId the mrdId to set
	 */
	public void setMrdId(String mrdId) {
		this.mrdId = mrdId;
	}

	/**
	 * @return the mrdId
	 */
	public String getMrdId() {
		return mrdId;
	}

	/**
	 * @return the dorStsCd
	 */
	public String getDorStsCd() {
		return dorStsCd;
	}

	/**
	 * @param dorStsCd the dorStsCd to set
	 */
	public void setDorStsCd(String dorStsCd) {
		this.dorStsCd = dorStsCd;
	}

	/**
	 * @return the dorStowage
	 */
	public String getDorStowage() {
		return dorStowage;
	}

	/**
	 * @param dorStowage the dorStowage to set
	 */
	public void setDorStowage(String dorStowage) {
		this.dorStowage = dorStowage;
	}

	public BkgDoRefVO getBkgDoRefVO() {
		return bkgDoRefVO;
	}

	public void setBkgDoRefVO(BkgDoRefVO bkgDoRefVO) {
		this.bkgDoRefVO = bkgDoRefVO;
	}

	public String getSplitFlg() {
		return splitFlg;
	}

	public void setSplitFlg(String splitFlg) {
		this.splitFlg = splitFlg;
	}

	public int getCntrCnt() {
		return cntrCnt;
	}

	public void setCntrCnt(int cntrCnt) {
		this.cntrCnt = cntrCnt;
	}

	public BlIssVO getBlIss() {
		return blIss;
	}

	public void setBlIss(BlIssVO blIss) {
		this.blIss = blIss;
	}

	public String getLocalLangFlg() {
		return localLangFlg;
	}

	public void setLocalLangFlg(String localLangFlg) {
		this.localLangFlg = localLangFlg;
	}

	public List<DoRlseStsVO> getDoRlseStsVOs() {
		return doRlseStsVOs;
	}

	public void setDoRlseStsVOs(List<DoRlseStsVO> doRlseStsVOs) {
		this.doRlseStsVOs = doRlseStsVOs;
	}

	public List<DoCntrRlseStsVO> getDoCntrRlseStsVOs() {
		return doCntrRlseStsVOs;
	}

	public void setDoCntrRlseStsVOs(List<DoCntrRlseStsVO> doCntrRlseStsVOs) {
		this.doCntrRlseStsVOs = doCntrRlseStsVOs;
	}

	public GenDoBlInfoVO getGenBlInfo() {
		return genBlInfo;
	}

	public void setGenBlInfo(GenDoBlInfoVO genBlInfo) {
		this.genBlInfo = genBlInfo;
	}

	public List<EuDoRlseStsVO> getGenDoRlseStsVOs() {
		return euDoRlseStsVOs;
	}

	public void setGenDoRlseStsVOs(List<EuDoRlseStsVO> euDoRlseStsVOs) {
		this.euDoRlseStsVOs = euDoRlseStsVOs;
	}
	
	public List<EuDoCntrRlseStsVO> getGenDoCntrRlseStsVOs() {
		return euDoCntrRlseStsVOs;
	}

	public void setGenDoCntrRlseStsVOs(List<EuDoCntrRlseStsVO> euDoCntrRlseStsVOs) {
		this.euDoCntrRlseStsVOs = euDoCntrRlseStsVOs;
	}	
}
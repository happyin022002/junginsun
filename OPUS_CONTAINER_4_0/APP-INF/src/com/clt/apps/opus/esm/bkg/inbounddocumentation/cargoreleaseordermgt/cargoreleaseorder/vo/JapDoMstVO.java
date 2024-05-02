/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : JapDoMstVO.java
*@FileTitle      :
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009-09-04
*@LastModifier   : 
*@LastVersion    : 1.0
* 2009-09-04 
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

public class JapDoMstVO {

    private DoBlInfoVO blInfo;
    private BkgDoRefVO doRef;
    private List<DoRlseStsVO> doRlseSts;
    private JapCstmsVO japCstms;
    private EdoRqstStsVO edoRqstSts;
    private BlIssVO blIss;
    private OtsRcvInfoVO otsRcvInfoVO; //운임 결재 여부와 Outstanding Amounts 정보를 ERP 시스템으로 부터 수신 받는 Value Object
    private String mrdId;
    private JapDorStatusVO japDorStatus;

    /**
     * DOR I/F된 DOR들 중 DOR Transmit이 되지 않은 B/L의 개수
     */
    private String dorStowage = "";

    /**
     * 생성자
     */
    public JapDoMstVO() {
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
     * @param doRef the doRef to set
     */
    public void setDoRef(BkgDoRefVO doRef) {
        this.doRef = doRef;
    }

    /**
     * @return the doRef
     */
    public BkgDoRefVO getDoRef() {
        return doRef;
    }
    
    /**
     * @param doStss the doStss to set
     */
    public void setDoRlseSts(List<DoRlseStsVO> doRlseSts) {
        this.doRlseSts = doRlseSts;
    }

    /**
     * @return the doStss
     */
    public List<DoRlseStsVO> getDoRlseSts() {
        return doRlseSts;
    }

    /**
	 * @param japCstms the japCstms to set
	 */
	public void setJapCstms(JapCstmsVO japCstms) {
		this.japCstms = japCstms;
	}

	/**
	 * @return the japCstms
	 */
	public JapCstmsVO getJapCstms() {
		return japCstms;
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
     * @param blIss the blIss to set
     */
    public void setBlIss(BlIssVO blIss) {
        this.blIss = blIss;
    }

    /**
     * @return the blIss
     */
    public BlIssVO getBlIss() {
        return blIss;
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

	/**
	 * @param japDorStatusVO the japDorStatus to set
	 */
	public void setJapDorStatus(JapDorStatusVO japDorStatus) {
		this.japDorStatus = japDorStatus;
	}

	/**
	 * @return the japDorStatusVO
	 */
	public JapDorStatusVO getJapDorStatus() {
		return japDorStatus;
	}
}
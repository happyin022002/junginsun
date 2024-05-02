/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : BkgDoRefVOVO.java
*@FileTitle      : BkgDoRefVOVO
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.05.25
*@LastModifier   : 임진영
*@LastVersion    : 1.0
* 2009.05.25 임진영
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.syscommon.common.table.BkgDoRefVO;
import com.hanjin.syscommon.common.table.BkgQuantityVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 임진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorDoMstVO {
        
    private DoBlInfoVO blInfo;
    private BkgDoRefVO doRef;
    private List<DoRlseStsVO> doRlseSts;
    private KorCstmsVO korCstms;
    private EdoRqstStsVO edoRqstSts;
    private BlIssVO blIss;
    private OtsRcvInfoVO otsRcvInfo; //운임 결재 여부와 Outstanding Amounts 정보를 ERP 시스템으로 부터 수신 받는 Value Object
    private String mrdId;
    private KorDoBlInfoVO korDoBlInfo;
    private List<BkgQuantityVO> bkgQuantity;
    
    /**
     * 생성자
     */
    public KorDoMstVO() {
    }

    /**
     * @return the otsRcvInfo
     */
    public OtsRcvInfoVO getOtsRcvInfo() {
        return otsRcvInfo;
    }

    /**
     * @param otsRcvInfo the otsRcvInfo to set
     */
    public void setOtsRcvInfo(OtsRcvInfoVO otsRcvInfo) {
        this.otsRcvInfo = otsRcvInfo;
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
     * @param korCstms the korCstms to set
     */
    public void setKorCstms(KorCstmsVO korCstms) {
        this.korCstms = korCstms;
    }

    /**
     * @return the korCstms
     */
    public KorCstmsVO getKorCstms() {
        return korCstms;
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
     * @return the doRef
     */
    public BkgDoRefVO getDoRef() {
        return doRef;
    }

    /**
     * @param doRef the doRef to set
     */
    public void setDoRef(BkgDoRefVO doRef) {
        this.doRef = doRef;
    }

    /**
     * @return the doRlseSts
     */
    public List<DoRlseStsVO> getDoRlseSts() {
        return doRlseSts;
    }

    /**
     * @param doRlseSts the doRlseSts to set
     */
    public void setDoRlseSts(List<DoRlseStsVO> doRlseSts) {
        this.doRlseSts = doRlseSts;
    }

    /**
     * @return the blIss
     */
    public BlIssVO getBlIss() {
        return blIss;
    }

    /**
     * @param blIss the blIss to set
     */
    public void setBlIss(BlIssVO blIss) {
        this.blIss = blIss;
    }

    public void setOtsRcvInfoVO(OtsRcvInfoVO otsRcvInfoVO) {
        // TODO Auto-generated method stub
    }

    public Object getOtsRcvInfoVO() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return the korDoBlInfo
     */
    public KorDoBlInfoVO getKorDoBlInfo() {
        return korDoBlInfo;
    }

    /**
     * @param korDoBlInfo the korDoBlInfo to set
     */
    public void setKorDoBlInfo(KorDoBlInfoVO korDoBlInfo) {
        this.korDoBlInfo = korDoBlInfo;
    }

	public List<BkgQuantityVO> getBkgQuantity() {
		return bkgQuantity;
	}

	public void setBkgQuantity(List<BkgQuantityVO> bkgQuantity) {
		this.bkgQuantity = bkgQuantity;
	}
}
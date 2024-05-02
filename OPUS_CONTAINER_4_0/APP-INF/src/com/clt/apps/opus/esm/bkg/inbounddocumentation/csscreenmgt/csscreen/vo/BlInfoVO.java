/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BlInfoVO.java
*@FileTitle : BlInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.08
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.08  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo;

import java.util.List;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OtsRcvInfoVO;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BlInfoVO {

    private BlInfosVO blInfosVO;
    private UsBlInfosVO usBlInfosVO;
	private List<TpszQtyVO> tpszQtyVOs;
	private List<CntrInfoVO> cntrInfoVOs;
	private String customsRefNo = null;
	private String blNo = null;
    private String[] cntrs;
    private OtsRcvInfoVO otsRcvInfoVO;           //운임 결재 여부와 Outstanding Amounts 정보를 ERP 시스템으로 부터 수신 받는 Value Object
	private List<CntrBySealNoVO> cntrBySealNoVOs;
	private String bkgStsCd = null;
	private String bkgNo = null;
    private CstmsAdvRsltsVO cstmsAdvRsltsVO;
	private List<CntrPkupNtcInfoVO> cntrPkupNtcInfoVOs;
	private UsCstmsRefInfoVO usCstmsRefVO;
	private CstmsClearInfoVO cstmsClearInfoVO;
	private String frtTermCd = null;
    private BkgInfoVO bkgInfoVO;
    private UsFreigtInfoVO usFreigtInfoVO;
    
    /**
	 * @return the blNo
	 */
	public String getBlNo() {
		return blNo;
	}
	
	/**
	 * @param blNo the blNo to set
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * @return the customsRefNo
	 */
	public String getCustomsRefNo() {
		return customsRefNo;
	}
	
	/**
	 * @param customsRefNo the customsRefNo to set
	 */
	public void setCustomsRefNo(String customsRefNo) {
		this.customsRefNo = customsRefNo;
	}

	public BlInfoVO() {
	}
	

    /**
	 * @return the tpszQtyVOs
	 */
	public List<TpszQtyVO> getTpszQtyVOs() {
		return tpszQtyVOs;
	}

	/**
	 * @param tpszQtyVOs the tpszQtyVOs to set
	 */
	public void setTpszQtyVOs(List<TpszQtyVO> tpszQtyVOs) {
		this.tpszQtyVOs = tpszQtyVOs;
	}

	/**
	 * @return the cntrInfoVOs
	 */
	public List<CntrInfoVO> getCntrInfoVOs() {
		return cntrInfoVOs;
	}

	/**
	 * @param cntrInfoVOs the cntrInfoVOs to set
	 */
	public void setCntrInfoVOs(List<CntrInfoVO> cntrInfoVOs) {
		this.cntrInfoVOs = cntrInfoVOs;
	}

	/**
	 * @return the cntrs
	 */
	public String[] getCntrs() {
		return cntrs;
	}
	/**
	 * @param cntrs the cntrs to set
	 */
	public void setCntrs(String[] cntrs) {
		this.cntrs = cntrs;
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
	 * @return the cntrBySealNoVOs
	 */
	public List<CntrBySealNoVO> getCntrBySealNoVOs() {
		return cntrBySealNoVOs;
	}

	/**
	 * @param cntrBySealNoVOs the cntrBySealNoVOs to set
	 */
	public void setCntrBySealNoVOs(List<CntrBySealNoVO> cntrBySealNoVOs) {
		this.cntrBySealNoVOs = cntrBySealNoVOs;
	}

	public String getBkgStsCd() {
		return bkgStsCd;
	}

	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}

	public BlInfosVO getBlInfosVO() {
		return blInfosVO;
	}

	public void setBlInfosVO(BlInfosVO blInfosVO) {
		this.blInfosVO = blInfosVO;
	}

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public CstmsAdvRsltsVO getCstmsAdvRsltsVO() {
		return cstmsAdvRsltsVO;
	}

	public void setCstmsAdvRsltsVO(CstmsAdvRsltsVO cstmsAdvRsltsVO) {
		this.cstmsAdvRsltsVO = cstmsAdvRsltsVO;
	}

	public List<CntrPkupNtcInfoVO> getCntrPkupNtcInfoVOs() {
		return cntrPkupNtcInfoVOs;
	}

	public void setCntrPkupNtcInfoVOs(List<CntrPkupNtcInfoVO> cntrPkupNtcInfoVOs) {
		this.cntrPkupNtcInfoVOs = cntrPkupNtcInfoVOs;
	}

	public UsCstmsRefInfoVO getUsCstmsRefVO() {
		return usCstmsRefVO;
	}

	public void setUsCstmsRefVO(UsCstmsRefInfoVO usCstmsRefVO) {
		this.usCstmsRefVO = usCstmsRefVO;
	}

	public CstmsClearInfoVO getCstmsClearInfoVO() {
		return cstmsClearInfoVO;
	}

	public void setCstmsClearInfoVO(CstmsClearInfoVO cstmsClearInfoVO) {
		this.cstmsClearInfoVO = cstmsClearInfoVO;
	}

	public String getFrtTermCd() {
		return frtTermCd;
	}

	public void setFrtTermCd(String frtTermCd) {
		this.frtTermCd = frtTermCd;
	}

	public BkgInfoVO getBkgInfoVO() {
		return bkgInfoVO;
	}

	public void setBkgInfoVO(BkgInfoVO bkgInfoVO) {
		this.bkgInfoVO = bkgInfoVO;
	}

	public UsFreigtInfoVO getUsFreigtInfoVO() {
		return usFreigtInfoVO;
	}

	public void setUsFreigtInfoVO(UsFreigtInfoVO usFreigtInfoVO) {
		this.usFreigtInfoVO = usFreigtInfoVO;
	}

	public UsBlInfosVO getUsBlInfosVO() {
		return usBlInfosVO;
	}

	public void setUsBlInfosVO(UsBlInfosVO usBlInfosVO) {
		this.usBlInfosVO = usBlInfosVO;
	}
	
	
}

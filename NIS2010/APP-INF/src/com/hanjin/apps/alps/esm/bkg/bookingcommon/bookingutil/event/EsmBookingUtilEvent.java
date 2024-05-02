/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UiBookingUtilEvent.java
 *@FileTitle : Booking Page
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.23
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.04.23 김영출
 * 1.0 Creation
 * ------------------------------------------------------
 * HISTORY 
 * 2012.03.14 김경섭 [CHM-201216605] ANCS Main Menu 관련 ESM_BKG_0044,0494,0965,0970 화면의 POD조회 추가.
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgCstmsHrdCdgCtntVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.CntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.ProductCatalogPoupCheckVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVvdBdrLogVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * UI_Booking_Util 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_Booking_UtilHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Youngchul
 * @see ESM_Booking_UtilHTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBookingUtilEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	/** Table Value Object Multi Data 처리 */
	private BkgBlNoVO[] bkgBlNoVOs = null;
	/** Table Value Object 조회 조건 및 단건 처리 */
	private BkgBlNoVO bkgBlNoVO = null;
	private String comboCd = null;
	private String bkgNo = null;
	private String bkgTrunkVvd = null;
	private String polCd = null;
	private String podCd = null;
	private String rfaNo = null;
	private String scNo = null;
	private String taaNo = null;
	private String inputText = null; // by leejinseo 
	private String inputText1 = null;
	private String sql = null; // input Sql  
	private String caFlg = null; 
	private String ctrtNo = null;
	private String ctrtType = null;
	private String ofcCd = null;
	private String HtsCd = null;
	private String blckTpCd = null; //block type code
	private String blckKwNm = null; //block keyword name
	private String serNo = null;
	private String uiId = null;
	private String idaSacCd = null;//인도 SAC 코드
	private String securitySearchId = null;
	private String porCd = null;
	private String cntCd = null;//국가 코드
	
	private ProductCatalogPoupCheckVO productCatalogPoupCheckVO = null;
	
	public String getCntCd() {
		return cntCd;
	}
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	public String getFlatFile() {
		return flatFile;
	}
	public void setFlatFile(String flatFile) {
		this.flatFile = flatFile;
	}
	public String getCommitYn() { 
		return commitYn;
	}
	public void setCommitYn(String commitYn) {
		this.commitYn = commitYn;
	}
	public String flatFile = null; 
	public String commitYn = null;
	
	private BkgVvdBdrLogVO bkgVvdBdrLogVO = null;
	private BkgVvdBdrLogVO[] bkgVvdBdrLogVOs = null;
	
	private BkgCstmsHrdCdgCtntVO bkgCstmsHrdCdgCtntVO = null;
	
	private CntrInfoVO cntrInfoVO = null;
	private CntrInfoVO[] cntrInfoVOs = null;
	

	public CntrInfoVO getCntrInfoVO() {
		return cntrInfoVO;
	}
	public void setCntrInfoVO(CntrInfoVO cntrInfoVO) {
		this.cntrInfoVO = cntrInfoVO;
	}
	public CntrInfoVO[] getCntrInfoVOs() {
		CntrInfoVO[] rtnVOs = null;
		if(this.cntrInfoVOs != null){
			rtnVOs = Arrays.copyOf(cntrInfoVOs, cntrInfoVOs.length);
		}
		return rtnVOs;
	}
	public void setCntrInfoVOs(CntrInfoVO[] cntrInfoVOs) {
		if(cntrInfoVOs != null){
			CntrInfoVO[] tmpVOs = Arrays.copyOf(cntrInfoVOs, cntrInfoVOs.length);
			this.cntrInfoVOs = tmpVOs;
		}
	}
	/**
	 * @return String
	 */
	public String getCtrtNo() {
		return ctrtNo;
	}
	/**
	 * @param String sql
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
	}
	
	/**
	 * @return String
	 */
	public String getCtrtType() {
		return ctrtType;
	}
	/**
	 * @param String sql
	 */
	public void setCtrtType(String ctrtType) {
		this.ctrtType = ctrtType;
	}
	/**
	 * @return String
	 */
	public String getSql() {
		return sql;
	}
	/**
	 * @param String sql
	 */
	public void setSql(String sql) {
		this.sql = sql;
	}
	/**
	 * @return String
	 */
	public String getInputText() {
		return inputText;
	}
	/**
	 * @return String
	 */
	public String getInputText1() {
		return inputText1;
	}
	/**
	 * the inputText to set
	 * @param String inputText
	 */
	public void setInputText(String inputText) {
		this.inputText = inputText;
	}
	/**
	 * the inputText to set
	 * @param String inputText1
	 */
	public void setInputText1(String inputText1) {
		this.inputText1 = inputText1;
	}
	
	public EsmBookingUtilEvent() {
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	public void setBkgBlNoVOS(BkgBlNoVO[] bkgBlNoVOs){
		if(bkgBlNoVOs != null){
			BkgBlNoVO[] tmpVOs = Arrays.copyOf(bkgBlNoVOs, bkgBlNoVOs.length);
			this.bkgBlNoVOs = tmpVOs;
		}
	}

	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	public BkgBlNoVO[] getBkgBlNoVOS() {
		BkgBlNoVO[] rtnVOs = null;
		if (this.bkgBlNoVOs != null) {
			rtnVOs = Arrays.copyOf(bkgBlNoVOs, bkgBlNoVOs.length);
		}
		return rtnVOs;
	}

	public void setComboCd(String comboCd) {
		this.comboCd = comboCd;
	}

	public String getComboCd() {
		return comboCd;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public String getBkgNo() {
		return bkgNo;
	}
	public String getCaFlg() {
		return caFlg;
	}

	public void setBkgTrunkVvd(String bkgTrunkVvd) {
		this.bkgTrunkVvd = bkgTrunkVvd;
	}

	public String getBkgTrunkVvd() {
		return bkgTrunkVvd;
	}

	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	public String getPolCd() {
		return polCd;
	}

	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	public String getPodCd() {
		return podCd;
	}

	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}

	public String getOfcCd() {
		return ofcCd;
	}
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	public String getRfaNo() {
		return rfaNo;
	}

	public void setScNo(String scNo) {
		this.scNo = scNo;
	}

	public String getScNo() {
		return scNo;
	}
	public void setTaaNo(String taaNo) {
		this.taaNo = taaNo;
	}

	public String getTaaNo() {
		return taaNo;
	}
	
	
	public String getHtsCd() {
		return HtsCd;
	}
	public void setHtsCd(String htsCd) {
		HtsCd = htsCd;
	}
	
	public void setCaFlg(String caFlg) {
		this.caFlg = caFlg;
	}
	public BkgVvdBdrLogVO getBkgVvdBdrLogVO() {
		return bkgVvdBdrLogVO;
	}
	public void setBkgVvdBdrLogVO(BkgVvdBdrLogVO bkgVvdBdrLogVO) {
		this.bkgVvdBdrLogVO = bkgVvdBdrLogVO;
	}
	public BkgVvdBdrLogVO[] getBkgVvdBdrLogVOs() {
		BkgVvdBdrLogVO[] rtnVOs = null;
		if (this.bkgVvdBdrLogVOs != null) {
			rtnVOs = Arrays.copyOf(bkgVvdBdrLogVOs, bkgVvdBdrLogVOs.length);
		}
		return rtnVOs;
	}
	public void setBkgVvdBdrLogVOs(BkgVvdBdrLogVO[] bkgVvdBdrLogVOs){
		if(bkgVvdBdrLogVOs != null){
			BkgVvdBdrLogVO[] tmpVOs = Arrays.copyOf(bkgVvdBdrLogVOs, bkgVvdBdrLogVOs.length);
			this.bkgVvdBdrLogVOs = tmpVOs;
		}
	}
	public BkgCstmsHrdCdgCtntVO getBkgCstmsHrdCdgCtntVO() {
		return bkgCstmsHrdCdgCtntVO;
	}
	public void setBkgCstmsHrdCdgCtntVO(BkgCstmsHrdCdgCtntVO bkgCstmsHrdCdgCtntVO) {
		this.bkgCstmsHrdCdgCtntVO = bkgCstmsHrdCdgCtntVO;
	}
	public String getBlckTpCd() {
		return blckTpCd;
	}
	public void setBlckTpCd(String blckTpCd) {
		this.blckTpCd = blckTpCd;
	}
	public String getBlckKwNm() {
		return blckKwNm;
	}
	public void setBlckKwNm(String blckKwNm) {
		this.blckKwNm = blckKwNm;
	}
	public String getSerNo() {
		return serNo;
	}
	public void setSerNo(String serNo) {
		this.serNo = serNo;
	}
	public String getUiId() {
		return uiId;
	}
	public void setUiId(String uiId) {
		this.uiId = uiId;
	}
	
   public String getIdaSacCd() {
        return idaSacCd;
    }
    public void setIdaSacCd(String idaSacCd) {
        this.idaSacCd = idaSacCd;
    }
	public String getSecuritySearchId() {
		return securitySearchId;
	}
	public void setSecuritySearchId(String securitySearchId) {
		this.securitySearchId = securitySearchId;
	}
	public String getPorCd() {
		return porCd;
	}
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	public ProductCatalogPoupCheckVO getProductCatalogPoupCheckVO() {
		return productCatalogPoupCheckVO;
	}
	public void setProductCatalogPoupCheckVO(ProductCatalogPoupCheckVO productCatalogPoupCheckVO) {
		this.productCatalogPoupCheckVO = productCatalogPoupCheckVO;
	}
}
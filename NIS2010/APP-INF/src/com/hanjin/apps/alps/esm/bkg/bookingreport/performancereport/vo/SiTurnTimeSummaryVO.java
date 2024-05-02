/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SiTurnTimeSummaryVO.java
*@FileTitle : SiTurnTimeSummaryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.16
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.16  
* 1.0 Creation
* 2011.11.22 정선용 [CHM-201114286-01] DPCS-SI Turn Time레포트 및 Draft B/L전송후 Amendment S/I PIC변경관련 개발요구사항 송부
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SiTurnTimeSummaryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SiTurnTimeSummaryVO> models = new ArrayList<SiTurnTimeSummaryVO>();
	
	/* Column Info */
	private String idOvt = null;
	/* Column Info */
	private String adActTm = null;
	/* Column Info */
	private String rdSrCnt = null;
	/* Column Info */
	private String idSrCnt = null;
	/* Column Info */
	private String ttlPic = null;
	/* Column Info */
	private String idActTm = null;
	/* Column Info */
	private String ttlSr = null;
	/* Column Info */
	private String ttlIdlTt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rdActTm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String adOvt = null;
	/* Column Info */
	private String srAmdTpCd = null;
	/* Column Info */
	private String idPic = null;
	/* Column Info */
	private String adBizTm = null;
	/* Column Info */
	private String adPic = null;
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String idBizTm = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String ttlTt = null;
	/* Column Info */
	private String ttlOvtTt = null;
	/* Column Info */
	private String rdPic = null;
	/* Column Info */
	private String idlToRd = null;
	/* Column Info */
	private String rdBizTm = null;
	/* Column Info */
	private String idlToAd = null;
	/* Column Info */
	private String rdOvt = null;
	/* Column Info */
	private String ttlBizTt = null;
	/* Column Info */
	private String adSrCnt = null;
	/* Column Info */
	private String idlToId = null;
	/* Column Info */
	private String ttlActTt = null;
	/* Column Info */
	private String idTt = null;
	/* Column Info */
	private String rdTt = null;
	/* Column Info */
	private String adTt = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SiTurnTimeSummaryVO() {}

	public SiTurnTimeSummaryVO(String ibflag, String pagerows, String srAmdTpCd, String rgnOfcCd, String ttlSr, String ttlPic, String bkgOfcCd, String ttlTt, String ttlBizTt, String ttlActTt, String ttlIdlTt, String ttlOvtTt, String idSrCnt, String idPic, String idlToId, String idBizTm, String idActTm, String idOvt, String rdSrCnt, String rdPic, String idlToRd, String rdBizTm, String rdActTm, String rdOvt, String adSrCnt, String adPic, String idlToAd, String adBizTm, String adActTm, String adOvt, String idTt, String rdTt, String adTt) {
		this.idOvt = idOvt;
		this.adActTm = adActTm;
		this.rdSrCnt = rdSrCnt;
		this.idSrCnt = idSrCnt;
		this.ttlPic = ttlPic;
		this.idActTm = idActTm;
		this.ttlSr = ttlSr;
		this.ttlIdlTt = ttlIdlTt;
		this.pagerows = pagerows;
		this.rdActTm = rdActTm;
		this.ibflag = ibflag;
		this.adOvt = adOvt;
		this.srAmdTpCd = srAmdTpCd;
		this.idPic = idPic;
		this.adBizTm = adBizTm;
		this.adPic = adPic;
		this.rgnOfcCd = rgnOfcCd;
		this.idBizTm = idBizTm;
		this.bkgOfcCd = bkgOfcCd;
		this.ttlTt = ttlTt;
		this.ttlOvtTt = ttlOvtTt;
		this.rdPic = rdPic;
		this.idlToRd = idlToRd;
		this.rdBizTm = rdBizTm;
		this.idlToAd = idlToAd;
		this.rdOvt = rdOvt;
		this.ttlBizTt = ttlBizTt;
		this.adSrCnt = adSrCnt;
		this.idlToId = idlToId;
		this.ttlActTt = ttlActTt;
		this.idTt = idTt;
		this.rdTt = rdTt;
		this.adTt = adTt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("id_ovt", getIdOvt());
		this.hashColumns.put("ad_act_tm", getAdActTm());
		this.hashColumns.put("rd_sr_cnt", getRdSrCnt());
		this.hashColumns.put("id_sr_cnt", getIdSrCnt());
		this.hashColumns.put("ttl_pic", getTtlPic());
		this.hashColumns.put("id_act_tm", getIdActTm());
		this.hashColumns.put("ttl_sr", getTtlSr());
		this.hashColumns.put("ttl_idl_tt", getTtlIdlTt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rd_act_tm", getRdActTm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ad_ovt", getAdOvt());
		this.hashColumns.put("sr_amd_tp_cd", getSrAmdTpCd());
		this.hashColumns.put("id_pic", getIdPic());
		this.hashColumns.put("ad_biz_tm", getAdBizTm());
		this.hashColumns.put("ad_pic", getAdPic());
		this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
		this.hashColumns.put("id_biz_tm", getIdBizTm());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("ttl_tt", getTtlTt());
		this.hashColumns.put("ttl_ovt_tt", getTtlOvtTt());
		this.hashColumns.put("rd_pic", getRdPic());
		this.hashColumns.put("idl_to_rd", getIdlToRd());
		this.hashColumns.put("rd_biz_tm", getRdBizTm());
		this.hashColumns.put("idl_to_ad", getIdlToAd());
		this.hashColumns.put("rd_ovt", getRdOvt());
		this.hashColumns.put("ttl_biz_tt", getTtlBizTt());
		this.hashColumns.put("ad_sr_cnt", getAdSrCnt());
		this.hashColumns.put("idl_to_id", getIdlToId());
		this.hashColumns.put("ttl_act_tt", getTtlActTt());
		this.hashColumns.put("id_tt", getIdTt());
		this.hashColumns.put("rd_tt", getRdTt());
		this.hashColumns.put("ad_tt", getAdTt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("id_ovt", "idOvt");
		this.hashFields.put("ad_act_tm", "adActTm");
		this.hashFields.put("rd_sr_cnt", "rdSrCnt");
		this.hashFields.put("id_sr_cnt", "idSrCnt");
		this.hashFields.put("ttl_pic", "ttlPic");
		this.hashFields.put("id_act_tm", "idActTm");
		this.hashFields.put("ttl_sr", "ttlSr");
		this.hashFields.put("ttl_idl_tt", "ttlIdlTt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rd_act_tm", "rdActTm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ad_ovt", "adOvt");
		this.hashFields.put("sr_amd_tp_cd", "srAmdTpCd");
		this.hashFields.put("id_pic", "idPic");
		this.hashFields.put("ad_biz_tm", "adBizTm");
		this.hashFields.put("ad_pic", "adPic");
		this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
		this.hashFields.put("id_biz_tm", "idBizTm");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("ttl_tt", "ttlTt");
		this.hashFields.put("ttl_ovt_tt", "ttlOvtTt");
		this.hashFields.put("rd_pic", "rdPic");
		this.hashFields.put("idl_to_rd", "idlToRd");
		this.hashFields.put("rd_biz_tm", "rdBizTm");
		this.hashFields.put("idl_to_ad", "idlToAd");
		this.hashFields.put("rd_ovt", "rdOvt");
		this.hashFields.put("ttl_biz_tt", "ttlBizTt");
		this.hashFields.put("ad_sr_cnt", "adSrCnt");
		this.hashFields.put("idl_to_id", "idlToId");
		this.hashFields.put("ttl_act_tt", "ttlActTt");
		this.hashFields.put("id_tt", "idTt");
		this.hashFields.put("rd_tt", "rdTt");
		this.hashFields.put("ad_tt", "adTt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return idOvt
	 */
	public String getIdOvt() {
		return this.idOvt;
	}
	
	/**
	 * Column Info
	 * @return adActTm
	 */
	public String getAdActTm() {
		return this.adActTm;
	}
	
	/**
	 * Column Info
	 * @return rdSrCnt
	 */
	public String getRdSrCnt() {
		return this.rdSrCnt;
	}
	
	/**
	 * Column Info
	 * @return idSrCnt
	 */
	public String getIdSrCnt() {
		return this.idSrCnt;
	}
	
	/**
	 * Column Info
	 * @return ttlPic
	 */
	public String getTtlPic() {
		return this.ttlPic;
	}
	
	/**
	 * Column Info
	 * @return idActTm
	 */
	public String getIdActTm() {
		return this.idActTm;
	}
	
	/**
	 * Column Info
	 * @return ttlSr
	 */
	public String getTtlSr() {
		return this.ttlSr;
	}
	
	/**
	 * Column Info
	 * @return ttlIdlTt
	 */
	public String getTtlIdlTt() {
		return this.ttlIdlTt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return rdActTm
	 */
	public String getRdActTm() {
		return this.rdActTm;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return adOvt
	 */
	public String getAdOvt() {
		return this.adOvt;
	}
	
	/**
	 * Column Info
	 * @return srAmdTpCd
	 */
	public String getSrAmdTpCd() {
		return this.srAmdTpCd;
	}
	
	/**
	 * Column Info
	 * @return idPic
	 */
	public String getIdPic() {
		return this.idPic;
	}
	
	/**
	 * Column Info
	 * @return adBizTm
	 */
	public String getAdBizTm() {
		return this.adBizTm;
	}
	
	/**
	 * Column Info
	 * @return adPic
	 */
	public String getAdPic() {
		return this.adPic;
	}
	
	/**
	 * Column Info
	 * @return rgnOfcCd
	 */
	public String getRgnOfcCd() {
		return this.rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return idBizTm
	 */
	public String getIdBizTm() {
		return this.idBizTm;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ttlTt
	 */
	public String getTtlTt() {
		return this.ttlTt;
	}
	
	/**
	 * Column Info
	 * @return ttlOvtTt
	 */
	public String getTtlOvtTt() {
		return this.ttlOvtTt;
	}
	
	/**
	 * Column Info
	 * @return rdPic
	 */
	public String getRdPic() {
		return this.rdPic;
	}
	
	/**
	 * Column Info
	 * @return idlToRd
	 */
	public String getIdlToRd() {
		return this.idlToRd;
	}
	
	/**
	 * Column Info
	 * @return rdBizTm
	 */
	public String getRdBizTm() {
		return this.rdBizTm;
	}
	
	/**
	 * Column Info
	 * @return idlToAd
	 */
	public String getIdlToAd() {
		return this.idlToAd;
	}
	
	/**
	 * Column Info
	 * @return rdOvt
	 */
	public String getRdOvt() {
		return this.rdOvt;
	}
	
	/**
	 * Column Info
	 * @return ttlBizTt
	 */
	public String getTtlBizTt() {
		return this.ttlBizTt;
	}
	
	/**
	 * Column Info
	 * @return adSrCnt
	 */
	public String getAdSrCnt() {
		return this.adSrCnt;
	}
	
	/**
	 * Column Info
	 * @return idlToId
	 */
	public String getIdlToId() {
		return this.idlToId;
	}
	
	/**
	 * Column Info
	 * @return ttlActTt
	 */
	public String getTtlActTt() {
		return this.ttlActTt;
	}
	
	/**
	 * Column Info
	 * @return idTt
	 */
	public String getIdTt() {
		return this.idTt;
	}
	
	/**
	 * Column Info
	 * @return rdTt
	 */
	public String getRdTt() {
		return this.rdTt;
	}
	
	/**
	 * Column Info
	 * @return adTt
	 */
	public String getAdTt() {
		return this.adTt;
	}
	

	/**
	 * Column Info
	 * @param idOvt
	 */
	public void setIdOvt(String idOvt) {
		this.idOvt = idOvt;
	}
	
	/**
	 * Column Info
	 * @param adActTm
	 */
	public void setAdActTm(String adActTm) {
		this.adActTm = adActTm;
	}
	
	/**
	 * Column Info
	 * @param rdSrCnt
	 */
	public void setRdSrCnt(String rdSrCnt) {
		this.rdSrCnt = rdSrCnt;
	}
	
	/**
	 * Column Info
	 * @param idSrCnt
	 */
	public void setIdSrCnt(String idSrCnt) {
		this.idSrCnt = idSrCnt;
	}
	
	/**
	 * Column Info
	 * @param ttlPic
	 */
	public void setTtlPic(String ttlPic) {
		this.ttlPic = ttlPic;
	}
	
	/**
	 * Column Info
	 * @param idActTm
	 */
	public void setIdActTm(String idActTm) {
		this.idActTm = idActTm;
	}
	
	/**
	 * Column Info
	 * @param ttlSr
	 */
	public void setTtlSr(String ttlSr) {
		this.ttlSr = ttlSr;
	}
	
	/**
	 * Column Info
	 * @param ttlIdlTt
	 */
	public void setTtlIdlTt(String ttlIdlTt) {
		this.ttlIdlTt = ttlIdlTt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param rdActTm
	 */
	public void setRdActTm(String rdActTm) {
		this.rdActTm = rdActTm;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param adOvt
	 */
	public void setAdOvt(String adOvt) {
		this.adOvt = adOvt;
	}
	
	/**
	 * Column Info
	 * @param srAmdTpCd
	 */
	public void setSrAmdTpCd(String srAmdTpCd) {
		this.srAmdTpCd = srAmdTpCd;
	}
	
	/**
	 * Column Info
	 * @param idPic
	 */
	public void setIdPic(String idPic) {
		this.idPic = idPic;
	}
	
	/**
	 * Column Info
	 * @param adBizTm
	 */
	public void setAdBizTm(String adBizTm) {
		this.adBizTm = adBizTm;
	}
	
	/**
	 * Column Info
	 * @param adPic
	 */
	public void setAdPic(String adPic) {
		this.adPic = adPic;
	}
	
	/**
	 * Column Info
	 * @param rgnOfcCd
	 */
	public void setRgnOfcCd(String rgnOfcCd) {
		this.rgnOfcCd = rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param idBizTm
	 */
	public void setIdBizTm(String idBizTm) {
		this.idBizTm = idBizTm;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ttlTt
	 */
	public void setTtlTt(String ttlTt) {
		this.ttlTt = ttlTt;
	}
	
	/**
	 * Column Info
	 * @param ttlOvtTt
	 */
	public void setTtlOvtTt(String ttlOvtTt) {
		this.ttlOvtTt = ttlOvtTt;
	}
	
	/**
	 * Column Info
	 * @param rdPic
	 */
	public void setRdPic(String rdPic) {
		this.rdPic = rdPic;
	}
	
	/**
	 * Column Info
	 * @param idlToRd
	 */
	public void setIdlToRd(String idlToRd) {
		this.idlToRd = idlToRd;
	}
	
	/**
	 * Column Info
	 * @param rdBizTm
	 */
	public void setRdBizTm(String rdBizTm) {
		this.rdBizTm = rdBizTm;
	}
	
	/**
	 * Column Info
	 * @param idlToAd
	 */
	public void setIdlToAd(String idlToAd) {
		this.idlToAd = idlToAd;
	}
	
	/**
	 * Column Info
	 * @param rdOvt
	 */
	public void setRdOvt(String rdOvt) {
		this.rdOvt = rdOvt;
	}
	
	/**
	 * Column Info
	 * @param ttlBizTt
	 */
	public void setTtlBizTt(String ttlBizTt) {
		this.ttlBizTt = ttlBizTt;
	}
	
	/**
	 * Column Info
	 * @param adSrCnt
	 */
	public void setAdSrCnt(String adSrCnt) {
		this.adSrCnt = adSrCnt;
	}
	
	/**
	 * Column Info
	 * @param idlToId
	 */
	public void setIdlToId(String idlToId) {
		this.idlToId = idlToId;
	}
	
	/**
	 * Column Info
	 * @param ttlActTt
	 */
	public void setTtlActTt(String ttlActTt) {
		this.ttlActTt = ttlActTt;
	}
	
	/**
	 * Column Info
	 * @param idTt
	 */
	public void setIdTt(String idTt) {
		this.idTt = idTt;
	}
	
	/**
	 * Column Info
	 * @param rdTt
	 */
	public void setRdTt(String rdTt) {
		this.rdTt = rdTt;
	}
	
	/**
	 * Column Info
	 * @param adTt
	 */
	public void setAdTt(String adTt) {
		this.adTt = adTt;
	}
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setIdOvt(JSPUtil.getParameter(request, prefix + "id_ovt", ""));
		setAdActTm(JSPUtil.getParameter(request, prefix + "ad_act_tm", ""));
		setRdSrCnt(JSPUtil.getParameter(request, prefix + "rd_sr_cnt", ""));
		setIdSrCnt(JSPUtil.getParameter(request, prefix + "id_sr_cnt", ""));
		setTtlPic(JSPUtil.getParameter(request, prefix + "ttl_pic", ""));
		setIdActTm(JSPUtil.getParameter(request, prefix + "id_act_tm", ""));
		setTtlSr(JSPUtil.getParameter(request, prefix + "ttl_sr", ""));
		setTtlIdlTt(JSPUtil.getParameter(request, prefix + "ttl_idl_tt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRdActTm(JSPUtil.getParameter(request, prefix + "rd_act_tm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAdOvt(JSPUtil.getParameter(request, prefix + "ad_ovt", ""));
		setSrAmdTpCd(JSPUtil.getParameter(request, prefix + "sr_amd_tp_cd", ""));
		setIdPic(JSPUtil.getParameter(request, prefix + "id_pic", ""));
		setAdBizTm(JSPUtil.getParameter(request, prefix + "ad_biz_tm", ""));
		setAdPic(JSPUtil.getParameter(request, prefix + "ad_pic", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, prefix + "rgn_ofc_cd", ""));
		setIdBizTm(JSPUtil.getParameter(request, prefix + "id_biz_tm", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setTtlTt(JSPUtil.getParameter(request, prefix + "ttl_tt", ""));
		setTtlOvtTt(JSPUtil.getParameter(request, prefix + "ttl_ovt_tt", ""));
		setRdPic(JSPUtil.getParameter(request, prefix + "rd_pic", ""));
		setIdlToRd(JSPUtil.getParameter(request, prefix + "idl_to_rd", ""));
		setRdBizTm(JSPUtil.getParameter(request, prefix + "rd_biz_tm", ""));
		setIdlToAd(JSPUtil.getParameter(request, prefix + "idl_to_ad", ""));
		setRdOvt(JSPUtil.getParameter(request, prefix + "rd_ovt", ""));
		setTtlBizTt(JSPUtil.getParameter(request, prefix + "ttl_biz_tt", ""));
		setAdSrCnt(JSPUtil.getParameter(request, prefix + "ad_sr_cnt", ""));
		setIdlToId(JSPUtil.getParameter(request, prefix + "idl_to_id", ""));
		setTtlActTt(JSPUtil.getParameter(request, prefix + "ttl_act_tt", ""));
		setTtlActTt(JSPUtil.getParameter(request, prefix + "id_tt", ""));
		setTtlActTt(JSPUtil.getParameter(request, prefix + "rd_tt", ""));
		setTtlActTt(JSPUtil.getParameter(request, prefix + "ad_tt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SiTurnTimeSummaryVO[]
	 */
	public SiTurnTimeSummaryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SiTurnTimeSummaryVO[]
	 */
	public SiTurnTimeSummaryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SiTurnTimeSummaryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] idOvt = (JSPUtil.getParameter(request, prefix	+ "id_ovt", length));
			String[] adActTm = (JSPUtil.getParameter(request, prefix	+ "ad_act_tm", length));
			String[] rdSrCnt = (JSPUtil.getParameter(request, prefix	+ "rd_sr_cnt", length));
			String[] idSrCnt = (JSPUtil.getParameter(request, prefix	+ "id_sr_cnt", length));
			String[] ttlPic = (JSPUtil.getParameter(request, prefix	+ "ttl_pic", length));
			String[] idActTm = (JSPUtil.getParameter(request, prefix	+ "id_act_tm", length));
			String[] ttlSr = (JSPUtil.getParameter(request, prefix	+ "ttl_sr", length));
			String[] ttlIdlTt = (JSPUtil.getParameter(request, prefix	+ "ttl_idl_tt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rdActTm = (JSPUtil.getParameter(request, prefix	+ "rd_act_tm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] adOvt = (JSPUtil.getParameter(request, prefix	+ "ad_ovt", length));
			String[] srAmdTpCd = (JSPUtil.getParameter(request, prefix	+ "sr_amd_tp_cd", length));
			String[] idPic = (JSPUtil.getParameter(request, prefix	+ "id_pic", length));
			String[] adBizTm = (JSPUtil.getParameter(request, prefix	+ "ad_biz_tm", length));
			String[] adPic = (JSPUtil.getParameter(request, prefix	+ "ad_pic", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_cd", length));
			String[] idBizTm = (JSPUtil.getParameter(request, prefix	+ "id_biz_tm", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] ttlTt = (JSPUtil.getParameter(request, prefix	+ "ttl_tt", length));
			String[] ttlOvtTt = (JSPUtil.getParameter(request, prefix	+ "ttl_ovt_tt", length));
			String[] rdPic = (JSPUtil.getParameter(request, prefix	+ "rd_pic", length));
			String[] idlToRd = (JSPUtil.getParameter(request, prefix	+ "idl_to_rd", length));
			String[] rdBizTm = (JSPUtil.getParameter(request, prefix	+ "rd_biz_tm", length));
			String[] idlToAd = (JSPUtil.getParameter(request, prefix	+ "idl_to_ad", length));
			String[] rdOvt = (JSPUtil.getParameter(request, prefix	+ "rd_ovt", length));
			String[] ttlBizTt = (JSPUtil.getParameter(request, prefix	+ "ttl_biz_tt", length));
			String[] adSrCnt = (JSPUtil.getParameter(request, prefix	+ "ad_sr_cnt", length));
			String[] idlToId = (JSPUtil.getParameter(request, prefix	+ "idl_to_id", length));
			String[] ttlActTt = (JSPUtil.getParameter(request, prefix	+ "ttl_act_tt", length));
			String[] idTt = (JSPUtil.getParameter(request, prefix	+ "id_tt", length));
			String[] rdTt = (JSPUtil.getParameter(request, prefix	+ "rd_tt", length));
			String[] adTt = (JSPUtil.getParameter(request, prefix	+ "ad_tt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SiTurnTimeSummaryVO();
				if (idOvt[i] != null)
					model.setIdOvt(idOvt[i]);
				if (adActTm[i] != null)
					model.setAdActTm(adActTm[i]);
				if (rdSrCnt[i] != null)
					model.setRdSrCnt(rdSrCnt[i]);
				if (idSrCnt[i] != null)
					model.setIdSrCnt(idSrCnt[i]);
				if (ttlPic[i] != null)
					model.setTtlPic(ttlPic[i]);
				if (idActTm[i] != null)
					model.setIdActTm(idActTm[i]);
				if (ttlSr[i] != null)
					model.setTtlSr(ttlSr[i]);
				if (ttlIdlTt[i] != null)
					model.setTtlIdlTt(ttlIdlTt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rdActTm[i] != null)
					model.setRdActTm(rdActTm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (adOvt[i] != null)
					model.setAdOvt(adOvt[i]);
				if (srAmdTpCd[i] != null)
					model.setSrAmdTpCd(srAmdTpCd[i]);
				if (idPic[i] != null)
					model.setIdPic(idPic[i]);
				if (adBizTm[i] != null)
					model.setAdBizTm(adBizTm[i]);
				if (adPic[i] != null)
					model.setAdPic(adPic[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (idBizTm[i] != null)
					model.setIdBizTm(idBizTm[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (ttlTt[i] != null)
					model.setTtlTt(ttlTt[i]);
				if (ttlOvtTt[i] != null)
					model.setTtlOvtTt(ttlOvtTt[i]);
				if (rdPic[i] != null)
					model.setRdPic(rdPic[i]);
				if (idlToRd[i] != null)
					model.setIdlToRd(idlToRd[i]);
				if (rdBizTm[i] != null)
					model.setRdBizTm(rdBizTm[i]);
				if (idlToAd[i] != null)
					model.setIdlToAd(idlToAd[i]);
				if (rdOvt[i] != null)
					model.setRdOvt(rdOvt[i]);
				if (ttlBizTt[i] != null)
					model.setTtlBizTt(ttlBizTt[i]);
				if (adSrCnt[i] != null)
					model.setAdSrCnt(adSrCnt[i]);
				if (idlToId[i] != null)
					model.setIdlToId(idlToId[i]);
				if (ttlActTt[i] != null)
					model.setTtlActTt(ttlActTt[i]);
				if (idTt[i] != null)
					model.setIdTt(idTt[i]);
				if (rdTt[i] != null)
					model.setRdTt(rdTt[i]);
				if (adTt[i] != null)
					model.setAdTt(adTt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSiTurnTimeSummaryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SiTurnTimeSummaryVO[]
	 */
	public SiTurnTimeSummaryVO[] getSiTurnTimeSummaryVOs(){
		SiTurnTimeSummaryVO[] vos = (SiTurnTimeSummaryVO[])models.toArray(new SiTurnTimeSummaryVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.idOvt = this.idOvt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adActTm = this.adActTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdSrCnt = this.rdSrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idSrCnt = this.idSrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPic = this.ttlPic .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idActTm = this.idActTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlSr = this.ttlSr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlIdlTt = this.ttlIdlTt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdActTm = this.rdActTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adOvt = this.adOvt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdTpCd = this.srAmdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idPic = this.idPic .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adBizTm = this.adBizTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adPic = this.adPic .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idBizTm = this.idBizTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlTt = this.ttlTt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlOvtTt = this.ttlOvtTt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdPic = this.rdPic .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idlToRd = this.idlToRd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdBizTm = this.rdBizTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idlToAd = this.idlToAd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdOvt = this.rdOvt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlBizTt = this.ttlBizTt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adSrCnt = this.adSrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idlToId = this.idlToId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlActTt = this.ttlActTt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idTt = this.idTt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdTt = this.rdTt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adTt = this.adTt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RestrictCmdtListVO.java
*@FileTitle : RestrictCmdtListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.26
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.26  Lee InYoung
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

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
 * @author Lee InYoung
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RestrictCmdtListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RestrictCmdtListVO> models = new ArrayList<RestrictCmdtListVO>();
	
	/* Column Info */
	private String dpSeq = null;
	/* Column Info */
	private String fileUpldNm = null;
	/* Column Info */
	private String fileSavId = null;
	/* Column Info */
	private String prohiCmdtNm = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String webSiteUrl = null;
	/* Column Info */
	private String rstrCmdtNm = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String commodities = null;
	/* Column Info */
	private String rstrCmdtGrpNm = null;
	/* Column Info */
	private String tsFlg = null;
	/* Column Info */
	private String frobFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RestrictCmdtListVO() {}

	public RestrictCmdtListVO(String ibflag, String pagerows, String rgnOfcCd, String locCd, String cntCd, String dpSeq, String rstrCmdtNm, String prohiCmdtNm, String effDt, String expDt, String webSiteUrl, String interRmk, String fileUpldNm, String fileSavId, String creUsrId, String updUsrId, String updDt, String commodities, String rstrCmdtGrpNm, String tsFlg, String frobFlg) {
		this.dpSeq = dpSeq;
		this.fileUpldNm = fileUpldNm;
		this.fileSavId = fileSavId;
		this.prohiCmdtNm = prohiCmdtNm;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.effDt = effDt;
		this.interRmk = interRmk;
		this.cntCd = cntCd;
		this.expDt = expDt;
		this.rgnOfcCd = rgnOfcCd;
		this.webSiteUrl = webSiteUrl;
		this.rstrCmdtNm = rstrCmdtNm;
		this.creUsrId = creUsrId;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.commodities = commodities;
		this.rstrCmdtGrpNm = rstrCmdtGrpNm;
		this.tsFlg = tsFlg;
		this.frobFlg = frobFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dp_seq", getDpSeq());
		this.hashColumns.put("file_upld_nm", getFileUpldNm());
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("prohi_cmdt_nm", getProhiCmdtNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
		this.hashColumns.put("web_site_url", getWebSiteUrl());
		this.hashColumns.put("rstr_cmdt_nm", getRstrCmdtNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("commodities", getCommodities());
		this.hashColumns.put("rstr_cmdt_grp_nm", getRstrCmdtGrpNm());
		this.hashColumns.put("ts_flg", getTsFlg());
		this.hashColumns.put("frob_flg", getFrobFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dp_seq", "dpSeq");
		this.hashFields.put("file_upld_nm", "fileUpldNm");
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("prohi_cmdt_nm", "prohiCmdtNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
		this.hashFields.put("web_site_url", "webSiteUrl");
		this.hashFields.put("rstr_cmdt_nm", "rstrCmdtNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("commodities", "commodities");
		this.hashFields.put("rstr_cmdt_grp_nm", "rstrCmdtGrpNm");
		this.hashFields.put("ts_flg", "tsFlg");
		this.hashFields.put("frob_flg", "frobFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dpSeq
	 */
	public String getDpSeq() {
		return this.dpSeq;
	}
	
	/**
	 * Column Info
	 * @return fileUpldNm
	 */
	public String getFileUpldNm() {
		return this.fileUpldNm;
	}
	
	/**
	 * Column Info
	 * @return fileSavId
	 */
	public String getFileSavId() {
		return this.fileSavId;
	}
	
	/**
	 * Column Info
	 * @return prohiCmdtNm
	 */
	public String getProhiCmdtNm() {
		return this.prohiCmdtNm;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return interRmk
	 */
	public String getInterRmk() {
		return this.interRmk;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
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
	 * @return webSiteUrl
	 */
	public String getWebSiteUrl() {
		return this.webSiteUrl;
	}
	
	/**
	 * Column Info
	 * @return rstrCmdtNm
	 */
	public String getRstrCmdtNm() {
		return this.rstrCmdtNm;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}

	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return commodities
	 */
	public String getCommodities() {
		return this.commodities;
	}
	
	/**
	 * Column Info
	 * @return rstrCmdtGrpNm
	 */
	public String getRstrCmdtGrpNm() {
		return this.rstrCmdtGrpNm;
	}
	
	/**
	 * Column Info
	 * @return tsFlg
	 */
	public String getTsFlg() {
		return this.tsFlg;
	}
	
	/**
	 * Column Info
	 * @return frobFlg
	 */
	public String getFrobFlg() {
		return this.frobFlg;
	}
	
	/**
	 * Column Info
	 * @param dpSeq
	 */
	public void setDpSeq(String dpSeq) {
		this.dpSeq = dpSeq;
	}
	
	/**
	 * Column Info
	 * @param fileUpldNm
	 */
	public void setFileUpldNm(String fileUpldNm) {
		this.fileUpldNm = fileUpldNm;
	}
	
	/**
	 * Column Info
	 * @param fileSavId
	 */
	public void setFileSavId(String fileSavId) {
		this.fileSavId = fileSavId;
	}
	
	/**
	 * Column Info
	 * @param prohiCmdtNm
	 */
	public void setProhiCmdtNm(String prohiCmdtNm) {
		this.prohiCmdtNm = prohiCmdtNm;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param interRmk
	 */
	public void setInterRmk(String interRmk) {
		this.interRmk = interRmk;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
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
	 * @param webSiteUrl
	 */
	public void setWebSiteUrl(String webSiteUrl) {
		this.webSiteUrl = webSiteUrl;
	}
	
	/**
	 * Column Info
	 * @param rstrCmdtNm
	 */
	public void setRstrCmdtNm(String rstrCmdtNm) {
		this.rstrCmdtNm = rstrCmdtNm;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param commodities
	 */
	public void setCommodities(String commodities) {
		this.commodities = commodities;
	}
	
	/**
	 * Column Info
	 * @param rstrCmdtGrpNm
	 */
	public void setRstrCmdtGrpNm(String rstrCmdtGrpNm) {
		this.rstrCmdtGrpNm = rstrCmdtGrpNm;
	}
	
	/**
	 * Column Info
	 * @param tsFlg
	 */
	public void setTsFlg(String tsFlg) {
		this.tsFlg = tsFlg;
	}
	
	/**
	 * Column Info
	 * @param frobFlg
	 */
	public void setFrobFlg(String frobFlg) {
		this.frobFlg = frobFlg;
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
		setDpSeq(JSPUtil.getParameter(request, prefix + "dp_seq", ""));
		setFileUpldNm(JSPUtil.getParameter(request, prefix + "file_upld_nm", ""));
		setFileSavId(JSPUtil.getParameter(request, prefix + "file_sav_id", ""));
		setProhiCmdtNm(JSPUtil.getParameter(request, prefix + "prohi_cmdt_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setInterRmk(JSPUtil.getParameter(request, prefix + "inter_rmk", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, prefix + "rgn_ofc_cd", ""));
		setWebSiteUrl(JSPUtil.getParameter(request, prefix + "web_site_url", ""));
		setRstrCmdtNm(JSPUtil.getParameter(request, prefix + "rstr_cmdt_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCommodities(JSPUtil.getParameter(request, prefix + "commodities", ""));
		setRstrCmdtGrpNm(JSPUtil.getParameter(request, prefix + "rstr_cmdt_grp_nm", ""));
		setTsFlg(JSPUtil.getParameter(request, prefix + "ts_flg", ""));
		setFrobFlg(JSPUtil.getParameter(request, prefix + "frob_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RestrictCmdtListVO[]
	 */
	public RestrictCmdtListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RestrictCmdtListVO[]
	 */
	public RestrictCmdtListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RestrictCmdtListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dpSeq = (JSPUtil.getParameter(request, prefix	+ "dp_seq", length));
			String[] fileUpldNm = (JSPUtil.getParameter(request, prefix	+ "file_upld_nm", length));
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] prohiCmdtNm = (JSPUtil.getParameter(request, prefix	+ "prohi_cmdt_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_cd", length));
			String[] webSiteUrl = (JSPUtil.getParameter(request, prefix	+ "web_site_url", length));
			String[] rstrCmdtNm = (JSPUtil.getParameter(request, prefix	+ "rstr_cmdt_nm", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] commodities = (JSPUtil.getParameter(request, prefix	+ "commodities", length));
			String[] rstrCmdtGrpNm = (JSPUtil.getParameter(request, prefix	+ "rstr_cmdt_grp_nm", length));
			String[] tsFlg = (JSPUtil.getParameter(request, prefix	+ "ts_flg", length));
			String[] frobFlg = (JSPUtil.getParameter(request, prefix	+ "frob_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new RestrictCmdtListVO();
				if (dpSeq[i] != null)
					model.setDpSeq(dpSeq[i]);
				if (fileUpldNm[i] != null)
					model.setFileUpldNm(fileUpldNm[i]);
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (prohiCmdtNm[i] != null)
					model.setProhiCmdtNm(prohiCmdtNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (webSiteUrl[i] != null)
					model.setWebSiteUrl(webSiteUrl[i]);
				if (rstrCmdtNm[i] != null)
					model.setRstrCmdtNm(rstrCmdtNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (commodities[i] != null)
					model.setCommodities(commodities[i]);
				if (rstrCmdtGrpNm[i] != null)
					model.setRstrCmdtGrpNm(rstrCmdtGrpNm[i]);
				if (tsFlg[i] != null)
					model.setTsFlg(tsFlg[i]);
				if (frobFlg[i] != null)
					model.setFrobFlg(frobFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRestrictCmdtListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RestrictCmdtListVO[]
	 */
	public RestrictCmdtListVO[] getRestrictCmdtListVOs(){
		RestrictCmdtListVO[] vos = (RestrictCmdtListVO[])models.toArray(new RestrictCmdtListVO[models.size()]);
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
		this.dpSeq = this.dpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileUpldNm = this.fileUpldNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSavId = this.fileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prohiCmdtNm = this.prohiCmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webSiteUrl = this.webSiteUrl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrCmdtNm = this.rstrCmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commodities = this.commodities .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrCmdtGrpNm = this.rstrCmdtGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsFlg = this.tsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frobFlg = this.frobFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

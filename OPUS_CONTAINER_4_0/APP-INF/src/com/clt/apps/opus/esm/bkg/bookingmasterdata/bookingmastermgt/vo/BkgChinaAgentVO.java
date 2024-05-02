/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgChinaAgentVO.java
*@FileTitle : BkgChinaAgentVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.09.04 김태경 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김태경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgChinaAgentVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgChinaAgentVO> models = new ArrayList<BkgChinaAgentVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String autoEmlFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String autoDpChkFlg = null;
	/* Column Info */
	private String agnEml = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgBlckFlg = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String agnNm = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String chnAgnCd = null;
	/* Column Info */
	private String fincOfcCd = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String dirPayOfcCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String originVndr = null;
	/* Column Info */
	private String originCust = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgChinaAgentVO() {}

	public BkgChinaAgentVO(String ibflag, String pagerows, String chnAgnCd, String agnNm, String diffRmk, String vndrCntCd, String vndrSeq, String originVndr, String custCntCd, String custSeq, String originCust, String autoDpChkFlg, String agnEml, String ofcCd, String fincOfcCd, String arOfcCd, String dirPayOfcCd, String autoEmlFlg, String creUsrId, String creDt, String updUsrId, String updDt, String updOfcCd, String bkgBlckFlg) {
		this.updDt = updDt;
		this.vndrCntCd = vndrCntCd;
		this.autoEmlFlg = autoEmlFlg;
		this.creDt = creDt;
		this.autoDpChkFlg = autoDpChkFlg;
		this.agnEml = agnEml;
		this.custSeq = custSeq;
		this.arOfcCd = arOfcCd;
		this.pagerows = pagerows;
		this.bkgBlckFlg = bkgBlckFlg;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.diffRmk = diffRmk;
		this.agnNm = agnNm;
		this.vndrSeq = vndrSeq;
		this.chnAgnCd = chnAgnCd;
		this.fincOfcCd = fincOfcCd;
		this.updOfcCd = updOfcCd;
		this.updUsrId = updUsrId;
		this.dirPayOfcCd = dirPayOfcCd;
		this.custCntCd = custCntCd;
		this.originVndr = originVndr;
		this.originCust = originCust;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("auto_eml_flg", getAutoEmlFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("auto_dp_chk_flg", getAutoDpChkFlg());
		this.hashColumns.put("agn_eml", getAgnEml());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_blck_flg", getBkgBlckFlg());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("agn_nm", getAgnNm());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("chn_agn_cd", getChnAgnCd());
		this.hashColumns.put("finc_ofc_cd", getFincOfcCd());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dir_pay_ofc_cd", getDirPayOfcCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("origin_vndr", getOriginVndr());
		this.hashColumns.put("origin_cust", getOriginCust());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("auto_eml_flg", "autoEmlFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("auto_dp_chk_flg", "autoDpChkFlg");
		this.hashFields.put("agn_eml", "agnEml");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_blck_flg", "bkgBlckFlg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("agn_nm", "agnNm");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("chn_agn_cd", "chnAgnCd");
		this.hashFields.put("finc_ofc_cd", "fincOfcCd");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dir_pay_ofc_cd", "dirPayOfcCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("origin_vndr", "originVndr");
		this.hashFields.put("origin_cust", "originCust");
		return this.hashFields;
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
	 * @return vndrCntCd
	 */
	public String getVndrCntCd() {
		return this.vndrCntCd;
	}
	
	/**
	 * Column Info
	 * @return autoEmlFlg
	 */
	public String getAutoEmlFlg() {
		return this.autoEmlFlg;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return autoDpChkFlg
	 */
	public String getAutoDpChkFlg() {
		return this.autoDpChkFlg;
	}
	
	/**
	 * Column Info
	 * @return agnEml
	 */
	public String getAgnEml() {
		return this.agnEml;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @return bkgBlckFlg
	 */
	public String getBkgBlckFlg() {
		return this.bkgBlckFlg;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return agnNm
	 */
	public String getAgnNm() {
		return this.agnNm;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return chnAgnCd
	 */
	public String getChnAgnCd() {
		return this.chnAgnCd;
	}
	
	/**
	 * Column Info
	 * @return fincOfcCd
	 */
	public String getFincOfcCd() {
		return this.fincOfcCd;
	}
	
	/**
	 * Column Info
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
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
	 * @return dirPayOfcCd
	 */
	public String getDirPayOfcCd() {
		return this.dirPayOfcCd;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return originVndr
	 */
	public String getOriginVndr() {
		return this.originVndr;
	}
	
	/**
	 * Column Info
	 * @return originCust
	 */
	public String getOriginCust() {
		return this.originCust;
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
	 * @param vndrCntCd
	 */
	public void setVndrCntCd(String vndrCntCd) {
		this.vndrCntCd = vndrCntCd;
	}
	
	/**
	 * Column Info
	 * @param autoEmlFlg
	 */
	public void setAutoEmlFlg(String autoEmlFlg) {
		this.autoEmlFlg = autoEmlFlg;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param autoDpChkFlg
	 */
	public void setAutoDpChkFlg(String autoDpChkFlg) {
		this.autoDpChkFlg = autoDpChkFlg;
	}
	
	/**
	 * Column Info
	 * @param agnEml
	 */
	public void setAgnEml(String agnEml) {
		this.agnEml = agnEml;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
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
	 * @param bkgBlckFlg
	 */
	public void setBkgBlckFlg(String bkgBlckFlg) {
		this.bkgBlckFlg = bkgBlckFlg;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param agnNm
	 */
	public void setAgnNm(String agnNm) {
		this.agnNm = agnNm;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param chnAgnCd
	 */
	public void setChnAgnCd(String chnAgnCd) {
		this.chnAgnCd = chnAgnCd;
	}
	
	/**
	 * Column Info
	 * @param fincOfcCd
	 */
	public void setFincOfcCd(String fincOfcCd) {
		this.fincOfcCd = fincOfcCd;
	}
	
	/**
	 * Column Info
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
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
	 * @param dirPayOfcCd
	 */
	public void setDirPayOfcCd(String dirPayOfcCd) {
		this.dirPayOfcCd = dirPayOfcCd;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param originVndr
	 */
	public void setOriginVndr(String originVndr) {
		this.originVndr = originVndr;
	}
	
	/**
	 * Column Info
	 * @param originCust
	 */
	public void setOriginCust(String originCust) {
		this.originCust = originCust;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setVndrCntCd(JSPUtil.getParameter(request, "vndr_cnt_cd", ""));
		setAutoEmlFlg(JSPUtil.getParameter(request, "auto_eml_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setAutoDpChkFlg(JSPUtil.getParameter(request, "auto_dp_chk_flg", ""));
		setAgnEml(JSPUtil.getParameter(request, "agn_eml", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBkgBlckFlg(JSPUtil.getParameter(request, "bkg_blck_flg", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setAgnNm(JSPUtil.getParameter(request, "agn_nm", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setChnAgnCd(JSPUtil.getParameter(request, "chn_agn_cd", ""));
		setFincOfcCd(JSPUtil.getParameter(request, "finc_ofc_cd", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setDirPayOfcCd(JSPUtil.getParameter(request, "dir_pay_ofc_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setOriginVndr(JSPUtil.getParameter(request, "origin_vndr", ""));
		setOriginCust(JSPUtil.getParameter(request, "origin_cust", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgChinaAgentVO[]
	 */
	public BkgChinaAgentVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgChinaAgentVO[]
	 */
	public BkgChinaAgentVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgChinaAgentVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] autoEmlFlg = (JSPUtil.getParameter(request, prefix	+ "auto_eml_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] autoDpChkFlg = (JSPUtil.getParameter(request, prefix	+ "auto_dp_chk_flg", length));
			String[] agnEml = (JSPUtil.getParameter(request, prefix	+ "agn_eml", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgBlckFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_blck_flg", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] agnNm = (JSPUtil.getParameter(request, prefix	+ "agn_nm", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] chnAgnCd = (JSPUtil.getParameter(request, prefix	+ "chn_agn_cd", length));
			String[] fincOfcCd = (JSPUtil.getParameter(request, prefix	+ "finc_ofc_cd", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] dirPayOfcCd = (JSPUtil.getParameter(request, prefix	+ "dir_pay_ofc_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] originVndr = (JSPUtil.getParameter(request, prefix	+ "origin_vndr", length));
			String[] originCust = (JSPUtil.getParameter(request, prefix	+ "origin_cust", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgChinaAgentVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (autoEmlFlg[i] != null)
					model.setAutoEmlFlg(autoEmlFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (autoDpChkFlg[i] != null)
					model.setAutoDpChkFlg(autoDpChkFlg[i]);
				if (agnEml[i] != null)
					model.setAgnEml(agnEml[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgBlckFlg[i] != null)
					model.setBkgBlckFlg(bkgBlckFlg[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (agnNm[i] != null)
					model.setAgnNm(agnNm[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (chnAgnCd[i] != null)
					model.setChnAgnCd(chnAgnCd[i]);
				if (fincOfcCd[i] != null)
					model.setFincOfcCd(fincOfcCd[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (dirPayOfcCd[i] != null)
					model.setDirPayOfcCd(dirPayOfcCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (originVndr[i] != null)
					model.setOriginVndr(originVndr[i]);
				if (originCust[i] != null)
					model.setOriginCust(originCust[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgChinaAgentVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgChinaAgentVO[]
	 */
	public BkgChinaAgentVO[] getBkgChinaAgentVOs(){
		BkgChinaAgentVO[] vos = (BkgChinaAgentVO[])models.toArray(new BkgChinaAgentVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoEmlFlg = this.autoEmlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoDpChkFlg = this.autoDpChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnEml = this.agnEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBlckFlg = this.bkgBlckFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnNm = this.agnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chnAgnCd = this.chnAgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincOfcCd = this.fincOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirPayOfcCd = this.dirPayOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.originVndr = this.originVndr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.originCust = this.originCust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

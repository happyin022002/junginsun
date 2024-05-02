/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CgoClzTmStupVO.java
*@FileTitle : CgoClzTmStupVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.06
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.06  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

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

public class CgoClzTmStupVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CgoClzTmStupVO> models = new ArrayList<CgoClzTmStupVO>();
	
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String ctrtOfcPhnNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cntcEml = null;
	/* Column Info */
	private String laneCnt = null;
	/* Column Info */
	private String emlSndFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String autoNtcFlg = null;
	/* Column Info */
	private String polCnt = null;
	/* Column Info */
	private String srepNtcFlg = null;
	/* Column Info */
	private String chkLaneCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String shprNtcFlg = null;
	/* Column Info */
	private String cntcMphnNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String setupCnt = null;
	/* Column Info */
	private String chkPolCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String mblSndFlg = null;
	/* Column Info */
	private String bkgPicNtcFlg = null;
	/* Column Info */
	private String obPicNtcFlg = null;
	/* Column Info */
	private String cctHrs = null;
	/* Column Info */
	private String dirCnt = null;
	/* Column Info */
	private String chkDirCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CgoClzTmStupVO() {}

	public CgoClzTmStupVO(String ibflag, String pagerows, String polCd, String laneCd, String dirCd, String cctHrs, String emlSndFlg, String mblSndFlg, String shprNtcFlg, String bkgPicNtcFlg, String srepNtcFlg, String obPicNtcFlg, String cntcEml, String cntcMphnNo, String ctrtOfcPhnNo, String autoNtcFlg, String creUsrId, String creDt, String updUsrId, String updDt, String chkPolCd, String chkLaneCd, String setupCnt, String polCnt, String laneCnt, String dirCnt, String chkDirCd) {
		this.laneCd = laneCd;
		this.ctrtOfcPhnNo = ctrtOfcPhnNo;
		this.creDt = creDt;
		this.cntcEml = cntcEml;
		this.laneCnt = laneCnt;
		this.emlSndFlg = emlSndFlg;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.autoNtcFlg = autoNtcFlg;
		this.polCnt = polCnt;
		this.srepNtcFlg = srepNtcFlg;
		this.chkLaneCd = chkLaneCd;
		this.dirCd = dirCd;
		this.shprNtcFlg = shprNtcFlg;
		this.cntcMphnNo = cntcMphnNo;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.setupCnt = setupCnt;
		this.chkPolCd = chkPolCd;
		this.creUsrId = creUsrId;
		this.mblSndFlg = mblSndFlg;
		this.bkgPicNtcFlg = bkgPicNtcFlg;
		this.obPicNtcFlg = obPicNtcFlg;
		this.cctHrs = cctHrs;
		this.dirCnt = dirCnt;
		this.chkDirCd = chkDirCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("ctrt_ofc_phn_no", getCtrtOfcPhnNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cntc_eml", getCntcEml());
		this.hashColumns.put("lane_cnt", getLaneCnt());
		this.hashColumns.put("eml_snd_flg", getEmlSndFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("auto_ntc_flg", getAutoNtcFlg());
		this.hashColumns.put("pol_cnt", getPolCnt());
		this.hashColumns.put("srep_ntc_flg", getSrepNtcFlg());
		this.hashColumns.put("chk_lane_cd", getChkLaneCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("shpr_ntc_flg", getShprNtcFlg());
		this.hashColumns.put("cntc_mphn_no", getCntcMphnNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("setup_cnt", getSetupCnt());
		this.hashColumns.put("chk_pol_cd", getChkPolCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("mbl_snd_flg", getMblSndFlg());
		this.hashColumns.put("bkg_pic_ntc_flg", getBkgPicNtcFlg());
		this.hashColumns.put("ob_pic_ntc_flg", getObPicNtcFlg());
		this.hashColumns.put("cct_hrs", getCctHrs());
		this.hashColumns.put("dir_cnt", getDirCnt());
		this.hashColumns.put("chk_dir_cd", getChkDirCd());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("ctrt_ofc_phn_no", "ctrtOfcPhnNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cntc_eml", "cntcEml");
		this.hashFields.put("lane_cnt", "laneCnt");
		this.hashFields.put("eml_snd_flg", "emlSndFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("auto_ntc_flg", "autoNtcFlg");
		this.hashFields.put("pol_cnt", "polCnt");
		this.hashFields.put("srep_ntc_flg", "srepNtcFlg");
		this.hashFields.put("chk_lane_cd", "chkLaneCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("shpr_ntc_flg", "shprNtcFlg");
		this.hashFields.put("cntc_mphn_no", "cntcMphnNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("setup_cnt", "setupCnt");
		this.hashFields.put("chk_pol_cd", "chkPolCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("mbl_snd_flg", "mblSndFlg");
		this.hashFields.put("bkg_pic_ntc_flg", "bkgPicNtcFlg");
		this.hashFields.put("ob_pic_ntc_flg", "obPicNtcFlg");
		this.hashFields.put("cct_hrs", "cctHrs");
		this.hashFields.put("dir_cnt", "dirCnt");
		this.hashFields.put("chk_dir_cd", "chkDirCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return laneCd
	 */
	public String getLaneCd() {
		return this.laneCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcPhnNo
	 */
	public String getCtrtOfcPhnNo() {
		return this.ctrtOfcPhnNo;
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
	 * @return cntcEml
	 */
	public String getCntcEml() {
		return this.cntcEml;
	}
	
	/**
	 * Column Info
	 * @return laneCnt
	 */
	public String getLaneCnt() {
		return this.laneCnt;
	}
	
	/**
	 * Column Info
	 * @return emlSndFlg
	 */
	public String getEmlSndFlg() {
		return this.emlSndFlg;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return autoNtcFlg
	 */
	public String getAutoNtcFlg() {
		return this.autoNtcFlg;
	}
	
	/**
	 * Column Info
	 * @return polCnt
	 */
	public String getPolCnt() {
		return this.polCnt;
	}
	
	/**
	 * Column Info
	 * @return srepNtcFlg
	 */
	public String getSrepNtcFlg() {
		return this.srepNtcFlg;
	}
	
	/**
	 * Column Info
	 * @return chkLaneCd
	 */
	public String getChkLaneCd() {
		return this.chkLaneCd;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return shprNtcFlg
	 */
	public String getShprNtcFlg() {
		return this.shprNtcFlg;
	}
	
	/**
	 * Column Info
	 * @return cntcMphnNo
	 */
	public String getCntcMphnNo() {
		return this.cntcMphnNo;
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
	 * @return setupCnt
	 */
	public String getSetupCnt() {
		return this.setupCnt;
	}
	
	/**
	 * Column Info
	 * @return chkPolCd
	 */
	public String getChkPolCd() {
		return this.chkPolCd;
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
	 * @return mblSndFlg
	 */
	public String getMblSndFlg() {
		return this.mblSndFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgPicNtcFlg
	 */
	public String getBkgPicNtcFlg() {
		return this.bkgPicNtcFlg;
	}
	
	/**
	 * Column Info
	 * @return obPicNtcFlg
	 */
	public String getObPicNtcFlg() {
		return this.obPicNtcFlg;
	}
	
	/**
	 * Column Info
	 * @return cctHrs
	 */
	public String getCctHrs() {
		return this.cctHrs;
	}
	
	/**
	 * Column Info
	 * @return dirCnt
	 */
	public String getDirCnt() {
		return this.dirCnt;
	}

	/**
	 * Column Info
	 * @return chkDirCd
	 */
	public String getChkDirCd() {
		return this.chkDirCd;
	}
	
	/**
	 * Column Info
	 * @param laneCd
	 */
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcPhnNo
	 */
	public void setCtrtOfcPhnNo(String ctrtOfcPhnNo) {
		this.ctrtOfcPhnNo = ctrtOfcPhnNo;
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
	 * @param cntcEml
	 */
	public void setCntcEml(String cntcEml) {
		this.cntcEml = cntcEml;
	}
	
	/**
	 * Column Info
	 * @param laneCnt
	 */
	public void setLaneCnt(String laneCnt) {
		this.laneCnt = laneCnt;
	}
	
	/**
	 * Column Info
	 * @param emlSndFlg
	 */
	public void setEmlSndFlg(String emlSndFlg) {
		this.emlSndFlg = emlSndFlg;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param autoNtcFlg
	 */
	public void setAutoNtcFlg(String autoNtcFlg) {
		this.autoNtcFlg = autoNtcFlg;
	}
	
	/**
	 * Column Info
	 * @param polCnt
	 */
	public void setPolCnt(String polCnt) {
		this.polCnt = polCnt;
	}
	
	/**
	 * Column Info
	 * @param srepNtcFlg
	 */
	public void setSrepNtcFlg(String srepNtcFlg) {
		this.srepNtcFlg = srepNtcFlg;
	}
	
	/**
	 * Column Info
	 * @param chkLaneCd
	 */
	public void setChkLaneCd(String chkLaneCd) {
		this.chkLaneCd = chkLaneCd;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param shprNtcFlg
	 */
	public void setShprNtcFlg(String shprNtcFlg) {
		this.shprNtcFlg = shprNtcFlg;
	}
	
	/**
	 * Column Info
	 * @param cntcMphnNo
	 */
	public void setCntcMphnNo(String cntcMphnNo) {
		this.cntcMphnNo = cntcMphnNo;
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
	 * @param setupCnt
	 */
	public void setSetupCnt(String setupCnt) {
		this.setupCnt = setupCnt;
	}
	
	/**
	 * Column Info
	 * @param chkPolCd
	 */
	public void setChkPolCd(String chkPolCd) {
		this.chkPolCd = chkPolCd;
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
	 * @param mblSndFlg
	 */
	public void setMblSndFlg(String mblSndFlg) {
		this.mblSndFlg = mblSndFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgPicNtcFlg
	 */
	public void setBkgPicNtcFlg(String bkgPicNtcFlg) {
		this.bkgPicNtcFlg = bkgPicNtcFlg;
	}
	
	/**
	 * Column Info
	 * @param obPicNtcFlg
	 */
	public void setObPicNtcFlg(String obPicNtcFlg) {
		this.obPicNtcFlg = obPicNtcFlg;
	}
	
	/**
	 * Column Info
	 * @param cctHrs
	 */
	public void setCctHrs(String cctHrs) {
		this.cctHrs = cctHrs;
	}
	
	/**
	 * Column Info
	 * @param dirCnt
	 */
	public void setDirCnt(String dirCnt) {
		this.dirCnt = dirCnt;
	}
	
	/**
	 * Column Info
	 * @param chkDirCd
	 */
	public void setChkDirCd(String chkDirCd) {
		this.chkDirCd = chkDirCd;
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
		setLaneCd(JSPUtil.getParameter(request, prefix + "lane_cd", ""));
		setCtrtOfcPhnNo(JSPUtil.getParameter(request, prefix + "ctrt_ofc_phn_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCntcEml(JSPUtil.getParameter(request, prefix + "cntc_eml", ""));
		setLaneCnt(JSPUtil.getParameter(request, prefix + "lane_cnt", ""));
		setEmlSndFlg(JSPUtil.getParameter(request, prefix + "eml_snd_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAutoNtcFlg(JSPUtil.getParameter(request, prefix + "auto_ntc_flg", ""));
		setPolCnt(JSPUtil.getParameter(request, prefix + "pol_cnt", ""));
		setSrepNtcFlg(JSPUtil.getParameter(request, prefix + "srep_ntc_flg", ""));
		setChkLaneCd(JSPUtil.getParameter(request, prefix + "chk_lane_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setShprNtcFlg(JSPUtil.getParameter(request, prefix + "shpr_ntc_flg", ""));
		setCntcMphnNo(JSPUtil.getParameter(request, prefix + "cntc_mphn_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setSetupCnt(JSPUtil.getParameter(request, prefix + "setup_cnt", ""));
		setChkPolCd(JSPUtil.getParameter(request, prefix + "chk_pol_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setMblSndFlg(JSPUtil.getParameter(request, prefix + "mbl_snd_flg", ""));
		setBkgPicNtcFlg(JSPUtil.getParameter(request, prefix + "bkg_pic_ntc_flg", ""));
		setObPicNtcFlg(JSPUtil.getParameter(request, prefix + "ob_pic_ntc_flg", ""));
		setCctHrs(JSPUtil.getParameter(request, prefix + "cct_hrs", ""));
		setDirCnt(JSPUtil.getParameter(request, prefix + "dir_cnt", ""));
		setChkDirCd(JSPUtil.getParameter(request, prefix + "chk_dir_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CgoClzTmStupVO[]
	 */
	public CgoClzTmStupVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CgoClzTmStupVO[]
	 */
	public CgoClzTmStupVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CgoClzTmStupVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
			String[] ctrtOfcPhnNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_phn_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cntcEml = (JSPUtil.getParameter(request, prefix	+ "cntc_eml", length));
			String[] laneCnt = (JSPUtil.getParameter(request, prefix	+ "lane_cnt", length));
			String[] emlSndFlg = (JSPUtil.getParameter(request, prefix	+ "eml_snd_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] autoNtcFlg = (JSPUtil.getParameter(request, prefix	+ "auto_ntc_flg", length));
			String[] polCnt = (JSPUtil.getParameter(request, prefix	+ "pol_cnt", length));
			String[] srepNtcFlg = (JSPUtil.getParameter(request, prefix	+ "srep_ntc_flg", length));
			String[] chkLaneCd = (JSPUtil.getParameter(request, prefix	+ "chk_lane_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] shprNtcFlg = (JSPUtil.getParameter(request, prefix	+ "shpr_ntc_flg", length));
			String[] cntcMphnNo = (JSPUtil.getParameter(request, prefix	+ "cntc_mphn_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] setupCnt = (JSPUtil.getParameter(request, prefix	+ "setup_cnt", length));
			String[] chkPolCd = (JSPUtil.getParameter(request, prefix	+ "chk_pol_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] mblSndFlg = (JSPUtil.getParameter(request, prefix	+ "mbl_snd_flg", length));
			String[] bkgPicNtcFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_pic_ntc_flg", length));
			String[] obPicNtcFlg = (JSPUtil.getParameter(request, prefix	+ "ob_pic_ntc_flg", length));
			String[] cctHrs = (JSPUtil.getParameter(request, prefix	+ "cct_hrs", length));
			String[] dirCnt = (JSPUtil.getParameter(request, prefix	+ "dir_cnt", length));
			String[] chkDirCd = (JSPUtil.getParameter(request, prefix	+ "chk_dir_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CgoClzTmStupVO();
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (ctrtOfcPhnNo[i] != null)
					model.setCtrtOfcPhnNo(ctrtOfcPhnNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cntcEml[i] != null)
					model.setCntcEml(cntcEml[i]);
				if (laneCnt[i] != null)
					model.setLaneCnt(laneCnt[i]);
				if (emlSndFlg[i] != null)
					model.setEmlSndFlg(emlSndFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (autoNtcFlg[i] != null)
					model.setAutoNtcFlg(autoNtcFlg[i]);
				if (polCnt[i] != null)
					model.setPolCnt(polCnt[i]);
				if (srepNtcFlg[i] != null)
					model.setSrepNtcFlg(srepNtcFlg[i]);
				if (chkLaneCd[i] != null)
					model.setChkLaneCd(chkLaneCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (shprNtcFlg[i] != null)
					model.setShprNtcFlg(shprNtcFlg[i]);
				if (cntcMphnNo[i] != null)
					model.setCntcMphnNo(cntcMphnNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (setupCnt[i] != null)
					model.setSetupCnt(setupCnt[i]);
				if (chkPolCd[i] != null)
					model.setChkPolCd(chkPolCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (mblSndFlg[i] != null)
					model.setMblSndFlg(mblSndFlg[i]);
				if (bkgPicNtcFlg[i] != null)
					model.setBkgPicNtcFlg(bkgPicNtcFlg[i]);
				if (obPicNtcFlg[i] != null)
					model.setObPicNtcFlg(obPicNtcFlg[i]);
				if (cctHrs[i] != null)
					model.setCctHrs(cctHrs[i]);
				if (dirCnt[i] != null)
					model.setDirCnt(dirCnt[i]);
				if (chkDirCd[i] != null)
					model.setChkDirCd(chkDirCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCgoClzTmStupVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CgoClzTmStupVO[]
	 */
	public CgoClzTmStupVO[] getCgoClzTmStupVOs(){
		CgoClzTmStupVO[] vos = (CgoClzTmStupVO[])models.toArray(new CgoClzTmStupVO[models.size()]);
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
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcPhnNo = this.ctrtOfcPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcEml = this.cntcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCnt = this.laneCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndFlg = this.emlSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoNtcFlg = this.autoNtcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCnt = this.polCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepNtcFlg = this.srepNtcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkLaneCd = this.chkLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNtcFlg = this.shprNtcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcMphnNo = this.cntcMphnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.setupCnt = this.setupCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkPolCd = this.chkPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mblSndFlg = this.mblSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPicNtcFlg = this.bkgPicNtcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obPicNtcFlg = this.obPicNtcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctHrs = this.cctHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCnt = this.dirCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDirCd = this.chkDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

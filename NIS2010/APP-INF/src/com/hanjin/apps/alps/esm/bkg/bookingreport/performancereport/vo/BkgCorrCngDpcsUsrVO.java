/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BkgCorrCngDpcsUsrVO.java
*@FileTitle : BkgCorrCngDpcsUsrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.15
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2011.10.15 김태경 
* 1.0 Creation
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
 * @author 김태경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgCorrCngDpcsUsrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCorrCngDpcsUsrVO> models = new ArrayList<BkgCorrCngDpcsUsrVO>();
	
	/* Column Info */
	private String dpcsWrkSts = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String srAmdSeq = null;
	/* Column Info */
	private String picId = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String uiGrpCd = null;
	/* Column Info */
	private String changeUsrId = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String dpcsWrkDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String srNo = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String srcCd = null;
	/* Column Info */
	private String dpcsPsnCd = null;
	/* Column Info */
	private String dpcsWrkSvcCd = null;
	/* Column Info */
	private String picNm = null;
	/* Column Info */
	private String dpcsWrkGrpCd = null;
	/* Column Info */
	private String dpcsWrkPrtCd = null;
	/* Column Info */
	private String beforeUsrId = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String srKnd = null;
	/* Column Info */
	private String dpcsWrkGrpNm = null;
	/* Column Info */
	private String wrkStTm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgCorrCngDpcsUsrVO() {}

	public BkgCorrCngDpcsUsrVO(String ibflag, String pagerows, String creUsrId, String dpcsWrkSvcCd, String dpcsPsnCd, String usrNm, String creDt, String updDt, String updUsrId, String usrId, String dpcsWrkPrtCd, String dpcsWrkGrpCd, String dpcsWrkSts, String dpcsWrkDt, String picNm, String picId, String dpcsWrkGrpNm, String wrkStTm, String bkgNo, String srcCd, String srNo, String beforeUsrId, String srKnd, String srAmdSeq, String uiGrpCd, String changeUsrId) {
		this.dpcsWrkSts = dpcsWrkSts;
		this.creDt = creDt;
		this.srAmdSeq = srAmdSeq;
		this.picId = picId;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.uiGrpCd = uiGrpCd;
		this.changeUsrId = changeUsrId;
		this.usrId = usrId;
		this.usrNm = usrNm;
		this.dpcsWrkDt = dpcsWrkDt;
		this.updUsrId = updUsrId;
		this.srNo = srNo;
		this.updDt = updDt;
		this.srcCd = srcCd;
		this.dpcsPsnCd = dpcsPsnCd;
		this.dpcsWrkSvcCd = dpcsWrkSvcCd;
		this.picNm = picNm;
		this.dpcsWrkGrpCd = dpcsWrkGrpCd;
		this.dpcsWrkPrtCd = dpcsWrkPrtCd;
		this.beforeUsrId = beforeUsrId;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.srKnd = srKnd;
		this.dpcsWrkGrpNm = dpcsWrkGrpNm;
		this.wrkStTm = wrkStTm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dpcs_wrk_sts", getDpcsWrkSts());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("sr_amd_seq", getSrAmdSeq());
		this.hashColumns.put("pic_id", getPicId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ui_grp_cd", getUiGrpCd());
		this.hashColumns.put("change_usr_id", getChangeUsrId());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("dpcs_wrk_dt", getDpcsWrkDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("sr_no", getSrNo());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("src_cd", getSrcCd());
		this.hashColumns.put("dpcs_psn_cd", getDpcsPsnCd());
		this.hashColumns.put("dpcs_wrk_svc_cd", getDpcsWrkSvcCd());
		this.hashColumns.put("pic_nm", getPicNm());
		this.hashColumns.put("dpcs_wrk_grp_cd", getDpcsWrkGrpCd());
		this.hashColumns.put("dpcs_wrk_prt_cd", getDpcsWrkPrtCd());
		this.hashColumns.put("before_usr_id", getBeforeUsrId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("sr_knd", getSrKnd());
		this.hashColumns.put("dpcs_wrk_grp_nm", getDpcsWrkGrpNm());
		this.hashColumns.put("wrk_st_tm", getWrkStTm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dpcs_wrk_sts", "dpcsWrkSts");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("sr_amd_seq", "srAmdSeq");
		this.hashFields.put("pic_id", "picId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ui_grp_cd", "uiGrpCd");
		this.hashFields.put("change_usr_id", "changeUsrId");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("dpcs_wrk_dt", "dpcsWrkDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("sr_no", "srNo");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("src_cd", "srcCd");
		this.hashFields.put("dpcs_psn_cd", "dpcsPsnCd");
		this.hashFields.put("dpcs_wrk_svc_cd", "dpcsWrkSvcCd");
		this.hashFields.put("pic_nm", "picNm");
		this.hashFields.put("dpcs_wrk_grp_cd", "dpcsWrkGrpCd");
		this.hashFields.put("dpcs_wrk_prt_cd", "dpcsWrkPrtCd");
		this.hashFields.put("before_usr_id", "beforeUsrId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("sr_knd", "srKnd");
		this.hashFields.put("dpcs_wrk_grp_nm", "dpcsWrkGrpNm");
		this.hashFields.put("wrk_st_tm", "wrkStTm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dpcsWrkSts
	 */
	public String getDpcsWrkSts() {
		return this.dpcsWrkSts;
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
	 * @return srAmdSeq
	 */
	public String getSrAmdSeq() {
		return this.srAmdSeq;
	}
	
	/**
	 * Column Info
	 * @return picId
	 */
	public String getPicId() {
		return this.picId;
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
	 * @return uiGrpCd
	 */
	public String getUiGrpCd() {
		return this.uiGrpCd;
	}
	
	/**
	 * Column Info
	 * @return changeUsrId
	 */
	public String getChangeUsrId() {
		return this.changeUsrId;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return dpcsWrkDt
	 */
	public String getDpcsWrkDt() {
		return this.dpcsWrkDt;
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
	 * @return srNo
	 */
	public String getSrNo() {
		return this.srNo;
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
	 * @return srcCd
	 */
	public String getSrcCd() {
		return this.srcCd;
	}
	
	/**
	 * Column Info
	 * @return dpcsPsnCd
	 */
	public String getDpcsPsnCd() {
		return this.dpcsPsnCd;
	}
	
	/**
	 * Column Info
	 * @return dpcsWrkSvcCd
	 */
	public String getDpcsWrkSvcCd() {
		return this.dpcsWrkSvcCd;
	}
	
	/**
	 * Column Info
	 * @return picNm
	 */
	public String getPicNm() {
		return this.picNm;
	}
	
	/**
	 * Column Info
	 * @return dpcsWrkGrpCd
	 */
	public String getDpcsWrkGrpCd() {
		return this.dpcsWrkGrpCd;
	}
	
	/**
	 * Column Info
	 * @return dpcsWrkPrtCd
	 */
	public String getDpcsWrkPrtCd() {
		return this.dpcsWrkPrtCd;
	}
	
	/**
	 * Column Info
	 * @return beforeUsrId
	 */
	public String getBeforeUsrId() {
		return this.beforeUsrId;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return srKnd
	 */
	public String getSrKnd() {
		return this.srKnd;
	}
	
	/**
	 * Column Info
	 * @return dpcsWrkGrpNm
	 */
	public String getDpcsWrkGrpNm() {
		return this.dpcsWrkGrpNm;
	}
	
	/**
	 * Column Info
	 * @return wrkStTm
	 */
	public String getWrkStTm() {
		return this.wrkStTm;
	}
	

	/**
	 * Column Info
	 * @param dpcsWrkSts
	 */
	public void setDpcsWrkSts(String dpcsWrkSts) {
		this.dpcsWrkSts = dpcsWrkSts;
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
	 * @param srAmdSeq
	 */
	public void setSrAmdSeq(String srAmdSeq) {
		this.srAmdSeq = srAmdSeq;
	}
	
	/**
	 * Column Info
	 * @param picId
	 */
	public void setPicId(String picId) {
		this.picId = picId;
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
	 * @param uiGrpCd
	 */
	public void setUiGrpCd(String uiGrpCd) {
		this.uiGrpCd = uiGrpCd;
	}
	
	/**
	 * Column Info
	 * @param changeUsrId
	 */
	public void setChangeUsrId(String changeUsrId) {
		this.changeUsrId = changeUsrId;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param dpcsWrkDt
	 */
	public void setDpcsWrkDt(String dpcsWrkDt) {
		this.dpcsWrkDt = dpcsWrkDt;
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
	 * @param srNo
	 */
	public void setSrNo(String srNo) {
		this.srNo = srNo;
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
	 * @param srcCd
	 */
	public void setSrcCd(String srcCd) {
		this.srcCd = srcCd;
	}
	
	/**
	 * Column Info
	 * @param dpcsPsnCd
	 */
	public void setDpcsPsnCd(String dpcsPsnCd) {
		this.dpcsPsnCd = dpcsPsnCd;
	}
	
	/**
	 * Column Info
	 * @param dpcsWrkSvcCd
	 */
	public void setDpcsWrkSvcCd(String dpcsWrkSvcCd) {
		this.dpcsWrkSvcCd = dpcsWrkSvcCd;
	}
	
	/**
	 * Column Info
	 * @param picNm
	 */
	public void setPicNm(String picNm) {
		this.picNm = picNm;
	}
	
	/**
	 * Column Info
	 * @param dpcsWrkGrpCd
	 */
	public void setDpcsWrkGrpCd(String dpcsWrkGrpCd) {
		this.dpcsWrkGrpCd = dpcsWrkGrpCd;
	}
	
	/**
	 * Column Info
	 * @param dpcsWrkPrtCd
	 */
	public void setDpcsWrkPrtCd(String dpcsWrkPrtCd) {
		this.dpcsWrkPrtCd = dpcsWrkPrtCd;
	}
	
	/**
	 * Column Info
	 * @param beforeUsrId
	 */
	public void setBeforeUsrId(String beforeUsrId) {
		this.beforeUsrId = beforeUsrId;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param srKnd
	 */
	public void setSrKnd(String srKnd) {
		this.srKnd = srKnd;
	}
	
	/**
	 * Column Info
	 * @param dpcsWrkGrpNm
	 */
	public void setDpcsWrkGrpNm(String dpcsWrkGrpNm) {
		this.dpcsWrkGrpNm = dpcsWrkGrpNm;
	}
	
	/**
	 * Column Info
	 * @param wrkStTm
	 */
	public void setWrkStTm(String wrkStTm) {
		this.wrkStTm = wrkStTm;
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
		setDpcsWrkSts(JSPUtil.getParameter(request, prefix + "dpcs_wrk_sts", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSrAmdSeq(JSPUtil.getParameter(request, prefix + "sr_amd_seq", ""));
		setPicId(JSPUtil.getParameter(request, prefix + "pic_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUiGrpCd(JSPUtil.getParameter(request, prefix + "ui_grp_cd", ""));
		setChangeUsrId(JSPUtil.getParameter(request, prefix + "change_usr_id", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setDpcsWrkDt(JSPUtil.getParameter(request, prefix + "dpcs_wrk_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setSrNo(JSPUtil.getParameter(request, prefix + "sr_no", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setSrcCd(JSPUtil.getParameter(request, prefix + "src_cd", ""));
		setDpcsPsnCd(JSPUtil.getParameter(request, prefix + "dpcs_psn_cd", ""));
		setDpcsWrkSvcCd(JSPUtil.getParameter(request, prefix + "dpcs_wrk_svc_cd", ""));
		setPicNm(JSPUtil.getParameter(request, prefix + "pic_nm", ""));
		setDpcsWrkGrpCd(JSPUtil.getParameter(request, prefix + "dpcs_wrk_grp_cd", ""));
		setDpcsWrkPrtCd(JSPUtil.getParameter(request, prefix + "dpcs_wrk_prt_cd", ""));
		setBeforeUsrId(JSPUtil.getParameter(request, prefix + "before_usr_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setSrKnd(JSPUtil.getParameter(request, prefix + "sr_knd", ""));
		setDpcsWrkGrpNm(JSPUtil.getParameter(request, prefix + "dpcs_wrk_grp_nm", ""));
		setWrkStTm(JSPUtil.getParameter(request, prefix + "wrk_st_tm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCorrCngDpcsUsrVO[]
	 */
	public BkgCorrCngDpcsUsrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCorrCngDpcsUsrVO[]
	 */
	public BkgCorrCngDpcsUsrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCorrCngDpcsUsrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dpcsWrkSts = (JSPUtil.getParameter(request, prefix	+ "dpcs_wrk_sts", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] srAmdSeq = (JSPUtil.getParameter(request, prefix	+ "sr_amd_seq", length));
			String[] picId = (JSPUtil.getParameter(request, prefix	+ "pic_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] uiGrpCd = (JSPUtil.getParameter(request, prefix	+ "ui_grp_cd", length));
			String[] changeUsrId = (JSPUtil.getParameter(request, prefix	+ "change_usr_id", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] dpcsWrkDt = (JSPUtil.getParameter(request, prefix	+ "dpcs_wrk_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] srNo = (JSPUtil.getParameter(request, prefix	+ "sr_no", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] srcCd = (JSPUtil.getParameter(request, prefix	+ "src_cd", length));
			String[] dpcsPsnCd = (JSPUtil.getParameter(request, prefix	+ "dpcs_psn_cd", length));
			String[] dpcsWrkSvcCd = (JSPUtil.getParameter(request, prefix	+ "dpcs_wrk_svc_cd", length));
			String[] picNm = (JSPUtil.getParameter(request, prefix	+ "pic_nm", length));
			String[] dpcsWrkGrpCd = (JSPUtil.getParameter(request, prefix	+ "dpcs_wrk_grp_cd", length));
			String[] dpcsWrkPrtCd = (JSPUtil.getParameter(request, prefix	+ "dpcs_wrk_prt_cd", length));
			String[] beforeUsrId = (JSPUtil.getParameter(request, prefix	+ "before_usr_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] srKnd = (JSPUtil.getParameter(request, prefix	+ "sr_knd", length));
			String[] dpcsWrkGrpNm = (JSPUtil.getParameter(request, prefix	+ "dpcs_wrk_grp_nm", length));
			String[] wrkStTm = (JSPUtil.getParameter(request, prefix	+ "wrk_st_tm", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCorrCngDpcsUsrVO();
				if (dpcsWrkSts[i] != null)
					model.setDpcsWrkSts(dpcsWrkSts[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (srAmdSeq[i] != null)
					model.setSrAmdSeq(srAmdSeq[i]);
				if (picId[i] != null)
					model.setPicId(picId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (uiGrpCd[i] != null)
					model.setUiGrpCd(uiGrpCd[i]);
				if (changeUsrId[i] != null)
					model.setChangeUsrId(changeUsrId[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (dpcsWrkDt[i] != null)
					model.setDpcsWrkDt(dpcsWrkDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (srNo[i] != null)
					model.setSrNo(srNo[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (srcCd[i] != null)
					model.setSrcCd(srcCd[i]);
				if (dpcsPsnCd[i] != null)
					model.setDpcsPsnCd(dpcsPsnCd[i]);
				if (dpcsWrkSvcCd[i] != null)
					model.setDpcsWrkSvcCd(dpcsWrkSvcCd[i]);
				if (picNm[i] != null)
					model.setPicNm(picNm[i]);
				if (dpcsWrkGrpCd[i] != null)
					model.setDpcsWrkGrpCd(dpcsWrkGrpCd[i]);
				if (dpcsWrkPrtCd[i] != null)
					model.setDpcsWrkPrtCd(dpcsWrkPrtCd[i]);
				if (beforeUsrId[i] != null)
					model.setBeforeUsrId(beforeUsrId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (srKnd[i] != null)
					model.setSrKnd(srKnd[i]);
				if (dpcsWrkGrpNm[i] != null)
					model.setDpcsWrkGrpNm(dpcsWrkGrpNm[i]);
				if (wrkStTm[i] != null)
					model.setWrkStTm(wrkStTm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCorrCngDpcsUsrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCorrCngDpcsUsrVO[]
	 */
	public BkgCorrCngDpcsUsrVO[] getBkgCorrCngDpcsUsrVOs(){
		BkgCorrCngDpcsUsrVO[] vos = (BkgCorrCngDpcsUsrVO[])models.toArray(new BkgCorrCngDpcsUsrVO[models.size()]);
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
		this.dpcsWrkSts = this.dpcsWrkSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdSeq = this.srAmdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picId = this.picId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uiGrpCd = this.uiGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.changeUsrId = this.changeUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpcsWrkDt = this.dpcsWrkDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srNo = this.srNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcCd = this.srcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpcsPsnCd = this.dpcsPsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpcsWrkSvcCd = this.dpcsWrkSvcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picNm = this.picNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpcsWrkGrpCd = this.dpcsWrkGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpcsWrkPrtCd = this.dpcsWrkPrtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.beforeUsrId = this.beforeUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKnd = this.srKnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpcsWrkGrpNm = this.dpcsWrkGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrkStTm = this.wrkStTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

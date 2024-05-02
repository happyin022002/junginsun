/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BkgEmlAcctStupVO.java
*@FileTitle : BkgEmlAcctStupVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.26
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.04.26 김기종 
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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgEmlAcctStupVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgEmlAcctStupVO> models = new ArrayList<BkgEmlAcctStupVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String delDpcsEmlLocGrpTpCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String dpcsEmlSvcKndCd = null;
	/* Column Info */
	private String inclSubOfcFlg = null;
	/* Column Info */
	private String emlAcctSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String emlPrioNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String polDpcsEmlLocGrpTpCd = null;
	/* Column Info */
	private String vbsCtnt = null;
	/* Column Info */
	private String dpcsEmlStndGrpTpCd = null;
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String emlCpyToEml = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgEmlAcctStupVO() {}

	public BkgEmlAcctStupVO(String ibflag, String pagerows, String emlCpyToEml, String emlAcctSeq, String bkgOfcCd, String emlPrioNo, String inclSubOfcFlg, String dpcsEmlSvcKndCd, String dpcsEmlStndGrpTpCd, String vbsCtnt, String polDpcsEmlLocGrpTpCd, String polCd, String delDpcsEmlLocGrpTpCd, String delCd, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String rgnOfcCd) {
		this.updDt = updDt;
		this.bkgOfcCd = bkgOfcCd;
		this.delDpcsEmlLocGrpTpCd = delDpcsEmlLocGrpTpCd;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.delCd = delCd;
		this.dpcsEmlSvcKndCd = dpcsEmlSvcKndCd;
		this.inclSubOfcFlg = inclSubOfcFlg;
		this.emlAcctSeq = emlAcctSeq;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.emlPrioNo = emlPrioNo;
		this.polCd = polCd;
		this.polDpcsEmlLocGrpTpCd = polDpcsEmlLocGrpTpCd;
		this.vbsCtnt = vbsCtnt;
		this.dpcsEmlStndGrpTpCd = dpcsEmlStndGrpTpCd;
		this.rgnOfcCd = rgnOfcCd;
		this.emlCpyToEml = emlCpyToEml;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("del_dpcs_eml_loc_grp_tp_cd", getDelDpcsEmlLocGrpTpCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("dpcs_eml_svc_knd_cd", getDpcsEmlSvcKndCd());
		this.hashColumns.put("incl_sub_ofc_flg", getInclSubOfcFlg());
		this.hashColumns.put("eml_acct_seq", getEmlAcctSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eml_prio_no", getEmlPrioNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pol_dpcs_eml_loc_grp_tp_cd", getPolDpcsEmlLocGrpTpCd());
		this.hashColumns.put("vbs_ctnt", getVbsCtnt());
		this.hashColumns.put("dpcs_eml_stnd_grp_tp_cd", getDpcsEmlStndGrpTpCd());
		this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
		this.hashColumns.put("eml_cpy_to_eml", getEmlCpyToEml());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("del_dpcs_eml_loc_grp_tp_cd", "delDpcsEmlLocGrpTpCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("dpcs_eml_svc_knd_cd", "dpcsEmlSvcKndCd");
		this.hashFields.put("incl_sub_ofc_flg", "inclSubOfcFlg");
		this.hashFields.put("eml_acct_seq", "emlAcctSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eml_prio_no", "emlPrioNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pol_dpcs_eml_loc_grp_tp_cd", "polDpcsEmlLocGrpTpCd");
		this.hashFields.put("vbs_ctnt", "vbsCtnt");
		this.hashFields.put("dpcs_eml_stnd_grp_tp_cd", "dpcsEmlStndGrpTpCd");
		this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
		this.hashFields.put("eml_cpy_to_eml", "emlCpyToEml");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return delDpcsEmlLocGrpTpCd
	 */
	public String getDelDpcsEmlLocGrpTpCd() {
		return this.delDpcsEmlLocGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return dpcsEmlSvcKndCd
	 */
	public String getDpcsEmlSvcKndCd() {
		return this.dpcsEmlSvcKndCd;
	}
	
	/**
	 * Column Info
	 * @return inclSubOfcFlg
	 */
	public String getInclSubOfcFlg() {
		return this.inclSubOfcFlg;
	}
	
	/**
	 * Column Info
	 * @return emlAcctSeq
	 */
	public String getEmlAcctSeq() {
		return this.emlAcctSeq;
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
	 * @return emlPrioNo
	 */
	public String getEmlPrioNo() {
		return this.emlPrioNo;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return polDpcsEmlLocGrpTpCd
	 */
	public String getPolDpcsEmlLocGrpTpCd() {
		return this.polDpcsEmlLocGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @return vbsCtnt
	 */
	public String getVbsCtnt() {
		return this.vbsCtnt;
	}
	
	/**
	 * Column Info
	 * @return dpcsEmlStndGrpTpCd
	 */
	public String getDpcsEmlStndGrpTpCd() {
		return this.dpcsEmlStndGrpTpCd;
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
	 * @return emlCpyToEml
	 */
	public String getEmlCpyToEml() {
		return this.emlCpyToEml;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param delDpcsEmlLocGrpTpCd
	 */
	public void setDelDpcsEmlLocGrpTpCd(String delDpcsEmlLocGrpTpCd) {
		this.delDpcsEmlLocGrpTpCd = delDpcsEmlLocGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param dpcsEmlSvcKndCd
	 */
	public void setDpcsEmlSvcKndCd(String dpcsEmlSvcKndCd) {
		this.dpcsEmlSvcKndCd = dpcsEmlSvcKndCd;
	}
	
	/**
	 * Column Info
	 * @param inclSubOfcFlg
	 */
	public void setInclSubOfcFlg(String inclSubOfcFlg) {
		this.inclSubOfcFlg = inclSubOfcFlg;
	}
	
	/**
	 * Column Info
	 * @param emlAcctSeq
	 */
	public void setEmlAcctSeq(String emlAcctSeq) {
		this.emlAcctSeq = emlAcctSeq;
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
	 * @param emlPrioNo
	 */
	public void setEmlPrioNo(String emlPrioNo) {
		this.emlPrioNo = emlPrioNo;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param polDpcsEmlLocGrpTpCd
	 */
	public void setPolDpcsEmlLocGrpTpCd(String polDpcsEmlLocGrpTpCd) {
		this.polDpcsEmlLocGrpTpCd = polDpcsEmlLocGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param vbsCtnt
	 */
	public void setVbsCtnt(String vbsCtnt) {
		this.vbsCtnt = vbsCtnt;
	}
	
	/**
	 * Column Info
	 * @param dpcsEmlStndGrpTpCd
	 */
	public void setDpcsEmlStndGrpTpCd(String dpcsEmlStndGrpTpCd) {
		this.dpcsEmlStndGrpTpCd = dpcsEmlStndGrpTpCd;
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
	 * @param emlCpyToEml
	 */
	public void setEmlCpyToEml(String emlCpyToEml) {
		this.emlCpyToEml = emlCpyToEml;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setDelDpcsEmlLocGrpTpCd(JSPUtil.getParameter(request, prefix + "del_dpcs_eml_loc_grp_tp_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setDpcsEmlSvcKndCd(JSPUtil.getParameter(request, prefix + "dpcs_eml_svc_knd_cd", ""));
		setInclSubOfcFlg(JSPUtil.getParameter(request, prefix + "incl_sub_ofc_flg", ""));
		setEmlAcctSeq(JSPUtil.getParameter(request, prefix + "eml_acct_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEmlPrioNo(JSPUtil.getParameter(request, prefix + "eml_prio_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPolDpcsEmlLocGrpTpCd(JSPUtil.getParameter(request, prefix + "pol_dpcs_eml_loc_grp_tp_cd", ""));
		setVbsCtnt(JSPUtil.getParameter(request, prefix + "vbs_ctnt", ""));
		setDpcsEmlStndGrpTpCd(JSPUtil.getParameter(request, prefix + "dpcs_eml_stnd_grp_tp_cd", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, prefix + "rgn_ofc_cd", ""));
		setEmlCpyToEml(JSPUtil.getParameter(request, prefix + "eml_cpy_to_eml", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgEmlAcctStupVO[]
	 */
	public BkgEmlAcctStupVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgEmlAcctStupVO[]
	 */
	public BkgEmlAcctStupVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgEmlAcctStupVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] delDpcsEmlLocGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "del_dpcs_eml_loc_grp_tp_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] dpcsEmlSvcKndCd = (JSPUtil.getParameter(request, prefix	+ "dpcs_eml_svc_knd_cd", length));
			String[] inclSubOfcFlg = (JSPUtil.getParameter(request, prefix	+ "incl_sub_ofc_flg", length));
			String[] emlAcctSeq = (JSPUtil.getParameter(request, prefix	+ "eml_acct_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] emlPrioNo = (JSPUtil.getParameter(request, prefix	+ "eml_prio_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] polDpcsEmlLocGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "pol_dpcs_eml_loc_grp_tp_cd", length));
			String[] vbsCtnt = (JSPUtil.getParameter(request, prefix	+ "vbs_ctnt", length));
			String[] dpcsEmlStndGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "dpcs_eml_stnd_grp_tp_cd", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_cd", length));
			String[] emlCpyToEml = (JSPUtil.getParameter(request, prefix	+ "eml_cpy_to_eml", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgEmlAcctStupVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (delDpcsEmlLocGrpTpCd[i] != null)
					model.setDelDpcsEmlLocGrpTpCd(delDpcsEmlLocGrpTpCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (dpcsEmlSvcKndCd[i] != null)
					model.setDpcsEmlSvcKndCd(dpcsEmlSvcKndCd[i]);
				if (inclSubOfcFlg[i] != null)
					model.setInclSubOfcFlg(inclSubOfcFlg[i]);
				if (emlAcctSeq[i] != null)
					model.setEmlAcctSeq(emlAcctSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (emlPrioNo[i] != null)
					model.setEmlPrioNo(emlPrioNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (polDpcsEmlLocGrpTpCd[i] != null)
					model.setPolDpcsEmlLocGrpTpCd(polDpcsEmlLocGrpTpCd[i]);
				if (vbsCtnt[i] != null)
					model.setVbsCtnt(vbsCtnt[i]);
				if (dpcsEmlStndGrpTpCd[i] != null)
					model.setDpcsEmlStndGrpTpCd(dpcsEmlStndGrpTpCd[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (emlCpyToEml[i] != null)
					model.setEmlCpyToEml(emlCpyToEml[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgEmlAcctStupVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgEmlAcctStupVO[]
	 */
	public BkgEmlAcctStupVO[] getBkgEmlAcctStupVOs(){
		BkgEmlAcctStupVO[] vos = (BkgEmlAcctStupVO[])models.toArray(new BkgEmlAcctStupVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delDpcsEmlLocGrpTpCd = this.delDpcsEmlLocGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpcsEmlSvcKndCd = this.dpcsEmlSvcKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inclSubOfcFlg = this.inclSubOfcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlAcctSeq = this.emlAcctSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlPrioNo = this.emlPrioNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polDpcsEmlLocGrpTpCd = this.polDpcsEmlLocGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vbsCtnt = this.vbsCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpcsEmlStndGrpTpCd = this.dpcsEmlStndGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlCpyToEml = this.emlCpyToEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VslSkdCngHisVO.java
*@FileTitle : VslSkdCngHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.18  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VslSkdCngHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VslSkdCngHisVO> models = new ArrayList<VslSkdCngHisVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String pfSkdTpCd = null;
	/* Column Info */
	private String hisDtlDeltDt = null;
	/* Column Info */
	private String hisVvdSeq = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String skdCngId = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String vskdCngTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvdUpdDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String skdCngDesc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actCrrCd = null;
	/* Column Info */
	private String hisDeltProhiFlg = null;
	/* Column Info */
	private String vvdCreUsrId = null;
	/* Column Info */
	private String vvdUpdUsrId = null;
	/* Column Info */
	private String vvdCreDt = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VslSkdCngHisVO() {}

	public VslSkdCngHisVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String hisVvdSeq, String vskdCngTpCd, String vslSlanCd, String pfSkdTpCd, String actCrrCd, String hisDtlDeltDt, String hisDeltProhiFlg, String vvdCreUsrId, String vvdCreDt, String vvdUpdUsrId, String vvdUpdDt, String skdCngId, String skdCngDesc, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.vslCd = vslCd;
		this.creDt = creDt;
		this.skdVoyNo = skdVoyNo;
		this.pfSkdTpCd = pfSkdTpCd;
		this.hisDtlDeltDt = hisDtlDeltDt;
		this.hisVvdSeq = hisVvdSeq;
		this.vslSlanCd = vslSlanCd;
		this.skdCngId = skdCngId;
		this.skdDirCd = skdDirCd;
		this.vskdCngTpCd = vskdCngTpCd;
		this.pagerows = pagerows;
		this.vvdUpdDt = vvdUpdDt;
		this.creUsrId = creUsrId;
		this.skdCngDesc = skdCngDesc;
		this.ibflag = ibflag;
		this.actCrrCd = actCrrCd;
		this.hisDeltProhiFlg = hisDeltProhiFlg;
		this.vvdCreUsrId = vvdCreUsrId;
		this.vvdUpdUsrId = vvdUpdUsrId;
		this.vvdCreDt = vvdCreDt;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("pf_skd_tp_cd", getPfSkdTpCd());
		this.hashColumns.put("his_dtl_delt_dt", getHisDtlDeltDt());
		this.hashColumns.put("his_vvd_seq", getHisVvdSeq());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("skd_cng_id", getSkdCngId());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("vskd_cng_tp_cd", getVskdCngTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd_upd_dt", getVvdUpdDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("skd_cng_desc", getSkdCngDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_crr_cd", getActCrrCd());
		this.hashColumns.put("his_delt_prohi_flg", getHisDeltProhiFlg());
		this.hashColumns.put("vvd_cre_usr_id", getVvdCreUsrId());
		this.hashColumns.put("vvd_upd_usr_id", getVvdUpdUsrId());
		this.hashColumns.put("vvd_cre_dt", getVvdCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("pf_skd_tp_cd", "pfSkdTpCd");
		this.hashFields.put("his_dtl_delt_dt", "hisDtlDeltDt");
		this.hashFields.put("his_vvd_seq", "hisVvdSeq");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("skd_cng_id", "skdCngId");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("vskd_cng_tp_cd", "vskdCngTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd_upd_dt", "vvdUpdDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("skd_cng_desc", "skdCngDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_crr_cd", "actCrrCd");
		this.hashFields.put("his_delt_prohi_flg", "hisDeltProhiFlg");
		this.hashFields.put("vvd_cre_usr_id", "vvdCreUsrId");
		this.hashFields.put("vvd_upd_usr_id", "vvdUpdUsrId");
		this.hashFields.put("vvd_cre_dt", "vvdCreDt");
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return pfSkdTpCd
	 */
	public String getPfSkdTpCd() {
		return this.pfSkdTpCd;
	}
	
	/**
	 * Column Info
	 * @return hisDtlDeltDt
	 */
	public String getHisDtlDeltDt() {
		return this.hisDtlDeltDt;
	}
	
	/**
	 * Column Info
	 * @return hisVvdSeq
	 */
	public String getHisVvdSeq() {
		return this.hisVvdSeq;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return skdCngId
	 */
	public String getSkdCngId() {
		return this.skdCngId;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return vskdCngTpCd
	 */
	public String getVskdCngTpCd() {
		return this.vskdCngTpCd;
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
	 * @return vvdUpdDt
	 */
	public String getVvdUpdDt() {
		return this.vvdUpdDt;
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
	 * @return skdCngDesc
	 */
	public String getSkdCngDesc() {
		return this.skdCngDesc;
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
	 * @return actCrrCd
	 */
	public String getActCrrCd() {
		return this.actCrrCd;
	}
	
	/**
	 * Column Info
	 * @return hisDeltProhiFlg
	 */
	public String getHisDeltProhiFlg() {
		return this.hisDeltProhiFlg;
	}
	
	/**
	 * Column Info
	 * @return vvdCreUsrId
	 */
	public String getVvdCreUsrId() {
		return this.vvdCreUsrId;
	}
	
	/**
	 * Column Info
	 * @return vvdUpdUsrId
	 */
	public String getVvdUpdUsrId() {
		return this.vvdUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @return vvdCreDt
	 */
	public String getVvdCreDt() {
		return this.vvdCreDt;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param pfSkdTpCd
	 */
	public void setPfSkdTpCd(String pfSkdTpCd) {
		this.pfSkdTpCd = pfSkdTpCd;
	}
	
	/**
	 * Column Info
	 * @param hisDtlDeltDt
	 */
	public void setHisDtlDeltDt(String hisDtlDeltDt) {
		this.hisDtlDeltDt = hisDtlDeltDt;
	}
	
	/**
	 * Column Info
	 * @param hisVvdSeq
	 */
	public void setHisVvdSeq(String hisVvdSeq) {
		this.hisVvdSeq = hisVvdSeq;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param skdCngId
	 */
	public void setSkdCngId(String skdCngId) {
		this.skdCngId = skdCngId;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param vskdCngTpCd
	 */
	public void setVskdCngTpCd(String vskdCngTpCd) {
		this.vskdCngTpCd = vskdCngTpCd;
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
	 * @param vvdUpdDt
	 */
	public void setVvdUpdDt(String vvdUpdDt) {
		this.vvdUpdDt = vvdUpdDt;
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
	 * @param skdCngDesc
	 */
	public void setSkdCngDesc(String skdCngDesc) {
		this.skdCngDesc = skdCngDesc;
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
	 * @param actCrrCd
	 */
	public void setActCrrCd(String actCrrCd) {
		this.actCrrCd = actCrrCd;
	}
	
	/**
	 * Column Info
	 * @param hisDeltProhiFlg
	 */
	public void setHisDeltProhiFlg(String hisDeltProhiFlg) {
		this.hisDeltProhiFlg = hisDeltProhiFlg;
	}
	
	/**
	 * Column Info
	 * @param vvdCreUsrId
	 */
	public void setVvdCreUsrId(String vvdCreUsrId) {
		this.vvdCreUsrId = vvdCreUsrId;
	}
	
	/**
	 * Column Info
	 * @param vvdUpdUsrId
	 */
	public void setVvdUpdUsrId(String vvdUpdUsrId) {
		this.vvdUpdUsrId = vvdUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @param vvdCreDt
	 */
	public void setVvdCreDt(String vvdCreDt) {
		this.vvdCreDt = vvdCreDt;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setPfSkdTpCd(JSPUtil.getParameter(request, prefix + "pf_skd_tp_cd", ""));
		setHisDtlDeltDt(JSPUtil.getParameter(request, prefix + "his_dtl_delt_dt", ""));
		setHisVvdSeq(JSPUtil.getParameter(request, prefix + "his_vvd_seq", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setSkdCngId(JSPUtil.getParameter(request, prefix + "skd_cng_id", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setVskdCngTpCd(JSPUtil.getParameter(request, prefix + "vskd_cng_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvdUpdDt(JSPUtil.getParameter(request, prefix + "vvd_upd_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSkdCngDesc(JSPUtil.getParameter(request, prefix + "skd_cng_desc", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setActCrrCd(JSPUtil.getParameter(request, prefix + "act_crr_cd", ""));
		setHisDeltProhiFlg(JSPUtil.getParameter(request, prefix + "his_delt_prohi_flg", ""));
		setVvdCreUsrId(JSPUtil.getParameter(request, prefix + "vvd_cre_usr_id", ""));
		setVvdUpdUsrId(JSPUtil.getParameter(request, prefix + "vvd_upd_usr_id", ""));
		setVvdCreDt(JSPUtil.getParameter(request, prefix + "vvd_cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VslSkdCngHisVO[]
	 */
	public VslSkdCngHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VslSkdCngHisVO[]
	 */
	public VslSkdCngHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VslSkdCngHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] pfSkdTpCd = (JSPUtil.getParameter(request, prefix	+ "pf_skd_tp_cd", length));
			String[] hisDtlDeltDt = (JSPUtil.getParameter(request, prefix	+ "his_dtl_delt_dt", length));
			String[] hisVvdSeq = (JSPUtil.getParameter(request, prefix	+ "his_vvd_seq", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] skdCngId = (JSPUtil.getParameter(request, prefix	+ "skd_cng_id", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] vskdCngTpCd = (JSPUtil.getParameter(request, prefix	+ "vskd_cng_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvdUpdDt = (JSPUtil.getParameter(request, prefix	+ "vvd_upd_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] skdCngDesc = (JSPUtil.getParameter(request, prefix	+ "skd_cng_desc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actCrrCd = (JSPUtil.getParameter(request, prefix	+ "act_crr_cd", length));
			String[] hisDeltProhiFlg = (JSPUtil.getParameter(request, prefix	+ "his_delt_prohi_flg", length));
			String[] vvdCreUsrId = (JSPUtil.getParameter(request, prefix	+ "vvd_cre_usr_id", length));
			String[] vvdUpdUsrId = (JSPUtil.getParameter(request, prefix	+ "vvd_upd_usr_id", length));
			String[] vvdCreDt = (JSPUtil.getParameter(request, prefix	+ "vvd_cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new VslSkdCngHisVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (pfSkdTpCd[i] != null)
					model.setPfSkdTpCd(pfSkdTpCd[i]);
				if (hisDtlDeltDt[i] != null)
					model.setHisDtlDeltDt(hisDtlDeltDt[i]);
				if (hisVvdSeq[i] != null)
					model.setHisVvdSeq(hisVvdSeq[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (skdCngId[i] != null)
					model.setSkdCngId(skdCngId[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (vskdCngTpCd[i] != null)
					model.setVskdCngTpCd(vskdCngTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvdUpdDt[i] != null)
					model.setVvdUpdDt(vvdUpdDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (skdCngDesc[i] != null)
					model.setSkdCngDesc(skdCngDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actCrrCd[i] != null)
					model.setActCrrCd(actCrrCd[i]);
				if (hisDeltProhiFlg[i] != null)
					model.setHisDeltProhiFlg(hisDeltProhiFlg[i]);
				if (vvdCreUsrId[i] != null)
					model.setVvdCreUsrId(vvdCreUsrId[i]);
				if (vvdUpdUsrId[i] != null)
					model.setVvdUpdUsrId(vvdUpdUsrId[i]);
				if (vvdCreDt[i] != null)
					model.setVvdCreDt(vvdCreDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVslSkdCngHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VslSkdCngHisVO[]
	 */
	public VslSkdCngHisVO[] getVslSkdCngHisVOs(){
		VslSkdCngHisVO[] vos = (VslSkdCngHisVO[])models.toArray(new VslSkdCngHisVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSkdTpCd = this.pfSkdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisDtlDeltDt = this.hisDtlDeltDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisVvdSeq = this.hisVvdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdCngId = this.skdCngId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vskdCngTpCd = this.vskdCngTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdUpdDt = this.vvdUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdCngDesc = this.skdCngDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCrrCd = this.actCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisDeltProhiFlg = this.hisDeltProhiFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCreUsrId = this.vvdCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdUpdUsrId = this.vvdUpdUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCreDt = this.vvdCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

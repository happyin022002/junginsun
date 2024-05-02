/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : searchRlaneCodeVO.java
*@FileTitle : searchRlaneCodeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.23  
* 1.0 Creation
=========================================================*/
  
package com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo;

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

public class RLaneDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RLaneDtlVO> models = new ArrayList<RLaneDtlVO>();
	
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String vslTpCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String repTrdCd = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmContiCd = null;
	/* Column Info */
	private String dtlDeltFlg = null;
	/* Column Info */
	private String rlaneNm = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String toContiCd = null;
	/* Column Info */
	private String addFlg = null;
	/* Column Info */
	private String vslSlanDirCd = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String rqstNo = null;

	private String creUsrId = null;
	private String creDt = null;
	private String updUsrId = null;
	private String updDt = null;
	
	private String dmntLegFlg = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RLaneDtlVO() {}

	public RLaneDtlVO(String ibflag, String pagerows, String rlaneNm, String vslTpCd, String repTrdCd, String vslSlanCd, String vslSlanDirCd, String iocCd, String trdCd, String subTrdCd, String fmContiCd, String toContiCd, String dtlDeltFlg, String deltFlg, String userId, String addFlg, String rlaneCd, String rqstNo, String creUsrId, String creDt, String updUsrId, String updDt, String dmntLegFlg) {
		this.iocCd = iocCd;
		this.deltFlg = deltFlg;
		this.vslTpCd = vslTpCd;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.repTrdCd = repTrdCd;
		this.vslSlanCd = vslSlanCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.fmContiCd = fmContiCd;
		this.dtlDeltFlg = dtlDeltFlg;
		this.rlaneNm = rlaneNm;
		this.userId = userId;
		this.toContiCd = toContiCd;
		this.addFlg = addFlg;
		this.vslSlanDirCd = vslSlanDirCd;
		this.subTrdCd = subTrdCd;
		this.rqstNo = rqstNo;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.dmntLegFlg = dmntLegFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("vsl_tp_cd", getVslTpCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("rep_trd_cd", getRepTrdCd());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_conti_cd", getFmContiCd());
		this.hashColumns.put("dtl_delt_flg", getDtlDeltFlg());
		this.hashColumns.put("rlane_nm", getRlaneNm());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("to_conti_cd", getToContiCd());
		this.hashColumns.put("add_flg", getAddFlg());
		this.hashColumns.put("vsl_slan_dir_cd", getVslSlanDirCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("rqst_no", getRqstNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dmnt_leg_flg", getDmntLegFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("vsl_tp_cd", "vslTpCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("rep_trd_cd", "repTrdCd");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_conti_cd", "fmContiCd");
		this.hashFields.put("dtl_delt_flg", "dtlDeltFlg");
		this.hashFields.put("rlane_nm", "rlaneNm");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("to_conti_cd", "toContiCd");
		this.hashFields.put("add_flg", "addFlg");
		this.hashFields.put("vsl_slan_dir_cd", "vslSlanDirCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("rqst_no", "rqstNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dmnt_leg_flg", "dmntLegFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
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
	 * @return vslTpCd
	 */
	public String getVslTpCd() {
		return this.vslTpCd;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return repTrdCd
	 */
	public String getRepTrdCd() {
		return this.repTrdCd;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
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
	 * @return fmContiCd
	 */
	public String getFmContiCd() {
		return this.fmContiCd;
	}
	
	/**
	 * Column Info
	 * @return dtlDeltFlg
	 */
	public String getDtlDeltFlg() {
		return this.dtlDeltFlg;
	}
	
	/**
	 * Column Info
	 * @return rlaneNm
	 */
	public String getRlaneNm() {
		return this.rlaneNm;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return toContiCd
	 */
	public String getToContiCd() {
		return this.toContiCd;
	}
	
	/**
	 * Column Info
	 * @return addFlg
	 */
	public String getAddFlg() {
		return this.addFlg;
	}
	
	/**
	 * Column Info
	 * @return vslSlanDirCd
	 */
	public String getVslSlanDirCd() {
		return this.vslSlanDirCd;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return rqstNo
	 */
	public String getRqstNo() {
		return this.rqstNo;
	}

	/**
	 * Column Info
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
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
	 * @param vslTpCd
	 */
	public void setVslTpCd(String vslTpCd) {
		this.vslTpCd = vslTpCd;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param repTrdCd
	 */
	public void setRepTrdCd(String repTrdCd) {
		this.repTrdCd = repTrdCd;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
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
	 * @param fmContiCd
	 */
	public void setFmContiCd(String fmContiCd) {
		this.fmContiCd = fmContiCd;
	}
	
	/**
	 * Column Info
	 * @param dtlDeltFlg
	 */
	public void setDtlDeltFlg(String dtlDeltFlg) {
		this.dtlDeltFlg = dtlDeltFlg;
	}
	
	/**
	 * Column Info
	 * @param rlaneNm
	 */
	public void setRlaneNm(String rlaneNm) {
		this.rlaneNm = rlaneNm;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param toContiCd
	 */
	public void setToContiCd(String toContiCd) {
		this.toContiCd = toContiCd;
	}
	
	/**
	 * Column Info
	 * @param addFlg
	 */
	public void setAddFlg(String addFlg) {
		this.addFlg = addFlg;
	}
	
	/**
	 * Column Info
	 * @param vslSlanDirCd
	 */
	public void setVslSlanDirCd(String vslSlanDirCd) {
		this.vslSlanDirCd = vslSlanDirCd;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param rqstNo
	 */
	public void setRqstNo(String rqstNo) {
		this.rqstNo = rqstNo;
	}
	
	public String getCreUsrId() {
		return creUsrId;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	public String getCreDt() {
		return creDt;
	}

	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	public String getUpdDt() {
		return updDt;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	public String getDmntLegFlg() {
		return dmntLegFlg;
	}

	public void setDmntLegFlg(String dmntLegFlg) {
		this.dmntLegFlg = dmntLegFlg;
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
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setVslTpCd(JSPUtil.getParameter(request, prefix + "vsl_tp_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setRepTrdCd(JSPUtil.getParameter(request, prefix + "rep_trd_cd", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFmContiCd(JSPUtil.getParameter(request, prefix + "fm_conti_cd", ""));
		setDtlDeltFlg(JSPUtil.getParameter(request, prefix + "dtl_delt_flg", ""));
		setRlaneNm(JSPUtil.getParameter(request, prefix + "rlane_nm", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setToContiCd(JSPUtil.getParameter(request, prefix + "to_conti_cd", ""));
		setAddFlg(JSPUtil.getParameter(request, prefix + "add_flg", ""));
		setVslSlanDirCd(JSPUtil.getParameter(request, prefix + "vsl_slan_dir_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setRqstNo(JSPUtil.getParameter(request, prefix + "rqst_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDmntLegFlg(JSPUtil.getParameter(request, prefix + "dmnt_leg_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return searchRlaneCodeVO[]
	 */
	public RLaneDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchRlaneCodeVO[]
	 */
	public RLaneDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RLaneDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] vslTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_tp_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] repTrdCd = (JSPUtil.getParameter(request, prefix	+ "rep_trd_cd", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmContiCd = (JSPUtil.getParameter(request, prefix	+ "fm_conti_cd", length));
			String[] dtlDeltFlg = (JSPUtil.getParameter(request, prefix	+ "dtl_delt_flg", length));
			String[] rlaneNm = (JSPUtil.getParameter(request, prefix	+ "rlane_nm", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] toContiCd = (JSPUtil.getParameter(request, prefix	+ "to_conti_cd", length));
			String[] addFlg = (JSPUtil.getParameter(request, prefix	+ "add_flg", length));
			String[] vslSlanDirCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_dir_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] rqstNo = (JSPUtil.getParameter(request, prefix	+ "rqst_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dmntLegFlg = (JSPUtil.getParameter(request, prefix	+ "dmnt_leg_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new RLaneDtlVO();
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (vslTpCd[i] != null)
					model.setVslTpCd(vslTpCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (repTrdCd[i] != null)
					model.setRepTrdCd(repTrdCd[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmContiCd[i] != null)
					model.setFmContiCd(fmContiCd[i]);
				if (dtlDeltFlg[i] != null)
					model.setDtlDeltFlg(dtlDeltFlg[i]);
				if (rlaneNm[i] != null)
					model.setRlaneNm(rlaneNm[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (toContiCd[i] != null)
					model.setToContiCd(toContiCd[i]);
				if (addFlg[i] != null)
					model.setAddFlg(addFlg[i]);
				if (vslSlanDirCd[i] != null)
					model.setVslSlanDirCd(vslSlanDirCd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (rqstNo[i] != null)
					model.setRqstNo(rqstNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dmntLegFlg[i] != null)
					model.setDmntLegFlg(dmntLegFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getsearchRlaneCodeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return searchRlaneCodeVO[]
	 */
	public RLaneDtlVO[] getsearchRlaneCodeVOs(){
		RLaneDtlVO[] vos = (RLaneDtlVO[])models.toArray(new RLaneDtlVO[models.size()]);
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
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslTpCd = this.vslTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repTrdCd = this.repTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmContiCd = this.fmContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlDeltFlg = this.dtlDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneNm = this.rlaneNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toContiCd = this.toContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addFlg = this.addFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanDirCd = this.vslSlanDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstNo = this.rqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmntLegFlg = this.dmntLegFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

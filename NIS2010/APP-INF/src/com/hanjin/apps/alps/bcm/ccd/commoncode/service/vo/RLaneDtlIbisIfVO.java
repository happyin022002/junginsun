/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RLaneDtlIbisIfVO.java
*@FileTitle : RLaneDtlIbisIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.08  
* 1.0 Creation
=========================================================*/
 
package com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class RLaneDtlIbisIfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RLaneDtlIbisIfVO> models = new ArrayList<RLaneDtlIbisIfVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String ifSndDt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String dmntLegFlg = null;
	/* Column Info */
	private String dtlRlaneIbisIfSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmContiCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ifMnplCd = null;
	/* Column Info */
	private String ifSndCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String toContiCd = null;
	/* Column Info */
	private String vslSlanDirCd = null;
	/* Column Info */
	private String ifErrCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String subTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RLaneDtlIbisIfVO() {}

	public RLaneDtlIbisIfVO(String ibflag, String pagerows, String dtlRlaneIbisIfSeq, String rlaneCd, String vslSlanDirCd, String iocCd, String fmContiCd, String toContiCd, String trdCd, String subTrdCd, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String dmntLegFlg, String ifSndCd, String ifSndDt, String ifErrCd, String ifMnplCd, String userId) {
		this.updDt = updDt;
		this.iocCd = iocCd;
		this.ifSndDt = ifSndDt;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.dmntLegFlg = dmntLegFlg;
		this.dtlRlaneIbisIfSeq = dtlRlaneIbisIfSeq;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.fmContiCd = fmContiCd;
		this.creUsrId = creUsrId;
		this.ifMnplCd = ifMnplCd;
		this.ifSndCd = ifSndCd;
		this.userId = userId;
		this.toContiCd = toContiCd;
		this.vslSlanDirCd = vslSlanDirCd;
		this.ifErrCd = ifErrCd;
		this.updUsrId = updUsrId;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("if_snd_dt", getIfSndDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("dmnt_leg_flg", getDmntLegFlg());
		this.hashColumns.put("dtl_rlane_ibis_if_seq", getDtlRlaneIbisIfSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_conti_cd", getFmContiCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("if_mnpl_cd", getIfMnplCd());
		this.hashColumns.put("if_snd_cd", getIfSndCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("to_conti_cd", getToContiCd());
		this.hashColumns.put("vsl_slan_dir_cd", getVslSlanDirCd());
		this.hashColumns.put("if_err_cd", getIfErrCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("if_snd_dt", "ifSndDt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("dmnt_leg_flg", "dmntLegFlg");
		this.hashFields.put("dtl_rlane_ibis_if_seq", "dtlRlaneIbisIfSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_conti_cd", "fmContiCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("if_mnpl_cd", "ifMnplCd");
		this.hashFields.put("if_snd_cd", "ifSndCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("to_conti_cd", "toContiCd");
		this.hashFields.put("vsl_slan_dir_cd", "vslSlanDirCd");
		this.hashFields.put("if_err_cd", "ifErrCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
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
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return ifSndDt
	 */
	public String getIfSndDt() {
		return this.ifSndDt;
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
	 * @return dmntLegFlg
	 */
	public String getDmntLegFlg() {
		return this.dmntLegFlg;
	}
	
	/**
	 * Column Info
	 * @return dtlRlaneIbisIfSeq
	 */
	public String getDtlRlaneIbisIfSeq() {
		return this.dtlRlaneIbisIfSeq;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return ifMnplCd
	 */
	public String getIfMnplCd() {
		return this.ifMnplCd;
	}
	
	/**
	 * Column Info
	 * @return ifSndCd
	 */
	public String getIfSndCd() {
		return this.ifSndCd;
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
	 * @return vslSlanDirCd
	 */
	public String getVslSlanDirCd() {
		return this.vslSlanDirCd;
	}
	
	/**
	 * Column Info
	 * @return ifErrCd
	 */
	public String getIfErrCd() {
		return this.ifErrCd;
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
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
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
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param ifSndDt
	 */
	public void setIfSndDt(String ifSndDt) {
		this.ifSndDt = ifSndDt;
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
	 * @param dmntLegFlg
	 */
	public void setDmntLegFlg(String dmntLegFlg) {
		this.dmntLegFlg = dmntLegFlg;
	}
	
	/**
	 * Column Info
	 * @param dtlRlaneIbisIfSeq
	 */
	public void setDtlRlaneIbisIfSeq(String dtlRlaneIbisIfSeq) {
		this.dtlRlaneIbisIfSeq = dtlRlaneIbisIfSeq;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param ifMnplCd
	 */
	public void setIfMnplCd(String ifMnplCd) {
		this.ifMnplCd = ifMnplCd;
	}
	
	/**
	 * Column Info
	 * @param ifSndCd
	 */
	public void setIfSndCd(String ifSndCd) {
		this.ifSndCd = ifSndCd;
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
	 * @param vslSlanDirCd
	 */
	public void setVslSlanDirCd(String vslSlanDirCd) {
		this.vslSlanDirCd = vslSlanDirCd;
	}
	
	/**
	 * Column Info
	 * @param ifErrCd
	 */
	public void setIfErrCd(String ifErrCd) {
		this.ifErrCd = ifErrCd;
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
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
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
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setIfSndDt(JSPUtil.getParameter(request, prefix + "if_snd_dt", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setDmntLegFlg(JSPUtil.getParameter(request, prefix + "dmnt_leg_flg", ""));
		setDtlRlaneIbisIfSeq(JSPUtil.getParameter(request, prefix + "dtl_rlane_ibis_if_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFmContiCd(JSPUtil.getParameter(request, prefix + "fm_conti_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIfMnplCd(JSPUtil.getParameter(request, prefix + "if_mnpl_cd", ""));
		setIfSndCd(JSPUtil.getParameter(request, prefix + "if_snd_cd", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setToContiCd(JSPUtil.getParameter(request, prefix + "to_conti_cd", ""));
		setVslSlanDirCd(JSPUtil.getParameter(request, prefix + "vsl_slan_dir_cd", ""));
		setIfErrCd(JSPUtil.getParameter(request, prefix + "if_err_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RLaneDtlIbisIfVO[]
	 */
	public RLaneDtlIbisIfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RLaneDtlIbisIfVO[]
	 */
	public RLaneDtlIbisIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RLaneDtlIbisIfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] ifSndDt = (JSPUtil.getParameter(request, prefix	+ "if_snd_dt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] dmntLegFlg = (JSPUtil.getParameter(request, prefix	+ "dmnt_leg_flg", length));
			String[] dtlRlaneIbisIfSeq = (JSPUtil.getParameter(request, prefix	+ "dtl_rlane_ibis_if_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmContiCd = (JSPUtil.getParameter(request, prefix	+ "fm_conti_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ifMnplCd = (JSPUtil.getParameter(request, prefix	+ "if_mnpl_cd", length));
			String[] ifSndCd = (JSPUtil.getParameter(request, prefix	+ "if_snd_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] toContiCd = (JSPUtil.getParameter(request, prefix	+ "to_conti_cd", length));
			String[] vslSlanDirCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_dir_cd", length));
			String[] ifErrCd = (JSPUtil.getParameter(request, prefix	+ "if_err_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RLaneDtlIbisIfVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (ifSndDt[i] != null)
					model.setIfSndDt(ifSndDt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (dmntLegFlg[i] != null)
					model.setDmntLegFlg(dmntLegFlg[i]);
				if (dtlRlaneIbisIfSeq[i] != null)
					model.setDtlRlaneIbisIfSeq(dtlRlaneIbisIfSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmContiCd[i] != null)
					model.setFmContiCd(fmContiCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ifMnplCd[i] != null)
					model.setIfMnplCd(ifMnplCd[i]);
				if (ifSndCd[i] != null)
					model.setIfSndCd(ifSndCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (toContiCd[i] != null)
					model.setToContiCd(toContiCd[i]);
				if (vslSlanDirCd[i] != null)
					model.setVslSlanDirCd(vslSlanDirCd[i]);
				if (ifErrCd[i] != null)
					model.setIfErrCd(ifErrCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRLaneDtlIbisIfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RLaneDtlIbisIfVO[]
	 */
	public RLaneDtlIbisIfVO[] getRLaneDtlIbisIfVOs(){
		RLaneDtlIbisIfVO[] vos = (RLaneDtlIbisIfVO[])models.toArray(new RLaneDtlIbisIfVO[models.size()]);
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
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifSndDt = this.ifSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmntLegFlg = this.dmntLegFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlRlaneIbisIfSeq = this.dtlRlaneIbisIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmContiCd = this.fmContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifMnplCd = this.ifMnplCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifSndCd = this.ifSndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toContiCd = this.toContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanDirCd = this.vslSlanDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifErrCd = this.ifErrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

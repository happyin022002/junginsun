/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RLaneIbisIfVO.java
*@FileTitle : RLaneIbisIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.08  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.bcm.ccd.commoncode.service.vo;

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

public class RLaneIbisIfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RLaneIbisIfVO> models = new ArrayList<RLaneIbisIfVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ifSndDt = null;
	/* Column Info */
	private String modiRlaneCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vslTpCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String repTrdCd = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rlaneIbisIfSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ifMnplCd = null;
	/* Column Info */
	private String ifSndCd = null;
	/* Column Info */
	private String rlaneNm = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String ifErrCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RLaneIbisIfVO() {}

	public RLaneIbisIfVO(String ibflag, String pagerows, String rlaneIbisIfSeq, String rlaneCd, String rlaneNm, String vslTpCd, String repTrdCd, String vslSlanCd, String modiRlaneCd, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String ifSndCd, String ifSndDt, String ifErrCd, String ifMnplCd, String userId) {
		this.updDt = updDt;
		this.ifSndDt = ifSndDt;
		this.modiRlaneCd = modiRlaneCd;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.vslTpCd = vslTpCd;
		this.rlaneCd = rlaneCd;
		this.repTrdCd = repTrdCd;
		this.vslSlanCd = vslSlanCd;
		this.pagerows = pagerows;
		this.rlaneIbisIfSeq = rlaneIbisIfSeq;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.ifMnplCd = ifMnplCd;
		this.ifSndCd = ifSndCd;
		this.rlaneNm = rlaneNm;
		this.userId = userId;
		this.ifErrCd = ifErrCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("if_snd_dt", getIfSndDt());
		this.hashColumns.put("modi_rlane_cd", getModiRlaneCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vsl_tp_cd", getVslTpCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("rep_trd_cd", getRepTrdCd());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rlane_ibis_if_seq", getRlaneIbisIfSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("if_mnpl_cd", getIfMnplCd());
		this.hashColumns.put("if_snd_cd", getIfSndCd());
		this.hashColumns.put("rlane_nm", getRlaneNm());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("if_err_cd", getIfErrCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("if_snd_dt", "ifSndDt");
		this.hashFields.put("modi_rlane_cd", "modiRlaneCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vsl_tp_cd", "vslTpCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("rep_trd_cd", "repTrdCd");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rlane_ibis_if_seq", "rlaneIbisIfSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("if_mnpl_cd", "ifMnplCd");
		this.hashFields.put("if_snd_cd", "ifSndCd");
		this.hashFields.put("rlane_nm", "rlaneNm");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("if_err_cd", "ifErrCd");
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
	 * @return ifSndDt
	 */
	public String getIfSndDt() {
		return this.ifSndDt;
	}
	
	/**
	 * Column Info
	 * @return modiRlaneCd
	 */
	public String getModiRlaneCd() {
		return this.modiRlaneCd;
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
	 * @return vslTpCd
	 */
	public String getVslTpCd() {
		return this.vslTpCd;
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
	 * Column Info
	 * @return rlaneIbisIfSeq
	 */
	public String getRlaneIbisIfSeq() {
		return this.rlaneIbisIfSeq;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param modiRlaneCd
	 */
	public void setModiRlaneCd(String modiRlaneCd) {
		this.modiRlaneCd = modiRlaneCd;
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
	 * @param vslTpCd
	 */
	public void setVslTpCd(String vslTpCd) {
		this.vslTpCd = vslTpCd;
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
	 * Column Info
	 * @param rlaneIbisIfSeq
	 */
	public void setRlaneIbisIfSeq(String rlaneIbisIfSeq) {
		this.rlaneIbisIfSeq = rlaneIbisIfSeq;
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
		setIfSndDt(JSPUtil.getParameter(request, prefix + "if_snd_dt", ""));
		setModiRlaneCd(JSPUtil.getParameter(request, prefix + "modi_rlane_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setVslTpCd(JSPUtil.getParameter(request, prefix + "vsl_tp_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setRepTrdCd(JSPUtil.getParameter(request, prefix + "rep_trd_cd", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRlaneIbisIfSeq(JSPUtil.getParameter(request, prefix + "rlane_ibis_if_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIfMnplCd(JSPUtil.getParameter(request, prefix + "if_mnpl_cd", ""));
		setIfSndCd(JSPUtil.getParameter(request, prefix + "if_snd_cd", ""));
		setRlaneNm(JSPUtil.getParameter(request, prefix + "rlane_nm", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setIfErrCd(JSPUtil.getParameter(request, prefix + "if_err_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RLaneIbisIfVO[]
	 */
	public RLaneIbisIfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RLaneIbisIfVO[]
	 */
	public RLaneIbisIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RLaneIbisIfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ifSndDt = (JSPUtil.getParameter(request, prefix	+ "if_snd_dt", length));
			String[] modiRlaneCd = (JSPUtil.getParameter(request, prefix	+ "modi_rlane_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vslTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_tp_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] repTrdCd = (JSPUtil.getParameter(request, prefix	+ "rep_trd_cd", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rlaneIbisIfSeq = (JSPUtil.getParameter(request, prefix	+ "rlane_ibis_if_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ifMnplCd = (JSPUtil.getParameter(request, prefix	+ "if_mnpl_cd", length));
			String[] ifSndCd = (JSPUtil.getParameter(request, prefix	+ "if_snd_cd", length));
			String[] rlaneNm = (JSPUtil.getParameter(request, prefix	+ "rlane_nm", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] ifErrCd = (JSPUtil.getParameter(request, prefix	+ "if_err_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new RLaneIbisIfVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ifSndDt[i] != null)
					model.setIfSndDt(ifSndDt[i]);
				if (modiRlaneCd[i] != null)
					model.setModiRlaneCd(modiRlaneCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vslTpCd[i] != null)
					model.setVslTpCd(vslTpCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (repTrdCd[i] != null)
					model.setRepTrdCd(repTrdCd[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rlaneIbisIfSeq[i] != null)
					model.setRlaneIbisIfSeq(rlaneIbisIfSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ifMnplCd[i] != null)
					model.setIfMnplCd(ifMnplCd[i]);
				if (ifSndCd[i] != null)
					model.setIfSndCd(ifSndCd[i]);
				if (rlaneNm[i] != null)
					model.setRlaneNm(rlaneNm[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (ifErrCd[i] != null)
					model.setIfErrCd(ifErrCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRLaneIbisIfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RLaneIbisIfVO[]
	 */
	public RLaneIbisIfVO[] getRLaneIbisIfVOs(){
		RLaneIbisIfVO[] vos = (RLaneIbisIfVO[])models.toArray(new RLaneIbisIfVO[models.size()]);
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
		this.ifSndDt = this.ifSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiRlaneCd = this.modiRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslTpCd = this.vslTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repTrdCd = this.repTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneIbisIfSeq = this.rlaneIbisIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifMnplCd = this.ifMnplCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifSndCd = this.ifSndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneNm = this.rlaneNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifErrCd = this.ifErrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

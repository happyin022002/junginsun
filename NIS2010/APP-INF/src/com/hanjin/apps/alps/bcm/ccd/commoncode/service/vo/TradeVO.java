/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchTrdCodeVO.java
*@FileTitle : SearchTrdCodeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.07  
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

public class TradeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TradeVO> models = new ArrayList<TradeVO>();
	
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String fmContiCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trdNm = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String stEffDt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String endEffDt = null;
	/* Column Info */
	private String toContiCd = null;
	/* Column Info */
	private String vslTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String rqstNo = null;
	/* Column Info */
	private String modiCostCtrCd = null;
	
	private String creUsrId = null;
	private String creDt = null;
	private String updUsrId = null;
	private String updDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TradeVO() {}

	public TradeVO(String ibflag, String pagerows, String trdNm, String vslTpCd, String fmContiCd, String toContiCd, String ofcCd, String stEffDt, String endEffDt, String deltFlg, String trdCd, String userId, String rqstNo, String modiCostCtrCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.ofcCd = ofcCd;
		this.fmContiCd = fmContiCd;
		this.ibflag = ibflag;
		this.trdNm = trdNm;
		this.deltFlg = deltFlg;
		this.userId = userId;
		this.stEffDt = stEffDt;
		this.trdCd = trdCd;
		this.endEffDt = endEffDt;
		this.toContiCd = toContiCd;
		this.vslTpCd = vslTpCd;
		this.pagerows = pagerows;
		this.rqstNo = rqstNo;
		this.modiCostCtrCd = modiCostCtrCd;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("fm_conti_cd", getFmContiCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trd_nm", getTrdNm());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("st_eff_dt", getStEffDt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("end_eff_dt", getEndEffDt());
		this.hashColumns.put("to_conti_cd", getToContiCd());
		this.hashColumns.put("vsl_tp_cd", getVslTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rqst_no", getRqstNo());
		this.hashColumns.put("modi_cost_ctr_cd", getModiCostCtrCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("fm_conti_cd", "fmContiCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trd_nm", "trdNm");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("st_eff_dt", "stEffDt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("end_eff_dt", "endEffDt");
		this.hashFields.put("to_conti_cd", "toContiCd");
		this.hashFields.put("vsl_tp_cd", "vslTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rqst_no", "rqst_no");
		this.hashFields.put("modi_cost_ctr_cd", "modiCostCtrCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		return this.hashFields;
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
	 * @return fmContiCd
	 */
	public String getFmContiCd() {
		return this.fmContiCd;
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
	 * @return trdNm
	 */
	public String getTrdNm() {
		return this.trdNm;
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
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return stEffDt
	 */
	public String getStEffDt() {
		return this.stEffDt;
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
	 * @return endEffDt
	 */
	public String getEndEffDt() {
		return this.endEffDt;
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
	 * @return vslTpCd
	 */
	public String getVslTpCd() {
		return this.vslTpCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Request Number
	 * @return rqstNo
	 */
	public String getRqstNo() {
		return this.rqstNo;
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
	 * @param fmContiCd
	 */
	public void setFmContiCd(String fmContiCd) {
		this.fmContiCd = fmContiCd;
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
	 * @param trdNm
	 */
	public void setTrdNm(String trdNm) {
		this.trdNm = trdNm;
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
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param stEffDt
	 */
	public void setStEffDt(String stEffDt) {
		this.stEffDt = stEffDt;
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
	 * @param endEffDt
	 */
	public void setEndEffDt(String endEffDt) {
		this.endEffDt = endEffDt;
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
	 * @param vslTpCd
	 */
	public void setVslTpCd(String vslTpCd) {
		this.vslTpCd = vslTpCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request Number
	 * @param rqstNo
	 */
	public void setRqstNo(String rqstNo) {
		this.rqstNo = rqstNo;
	}

	public String getModiCostCtrCd() {
		return modiCostCtrCd;
	}

	public void setModiCostCtrCd(String modiCostCtrCd) {
		this.modiCostCtrCd = modiCostCtrCd;
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
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setFmContiCd(JSPUtil.getParameter(request, prefix + "fm_conti_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTrdNm(JSPUtil.getParameter(request, prefix + "trd_nm", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setStEffDt(JSPUtil.getParameter(request, prefix + "st_eff_dt", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setEndEffDt(JSPUtil.getParameter(request, prefix + "end_eff_dt", ""));
		setToContiCd(JSPUtil.getParameter(request, prefix + "to_conti_cd", ""));
		setVslTpCd(JSPUtil.getParameter(request, prefix + "vsl_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRqstNo(JSPUtil.getParameter(request, prefix + "rqstNo", ""));
		setModiCostCtrCd(JSPUtil.getParameter(request, prefix + "modi_cost_ctr_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchTrdCodeVO[]
	 */
	public TradeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchTrdCodeVO[]
	 */
	public TradeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TradeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] fmContiCd = (JSPUtil.getParameter(request, prefix	+ "fm_conti_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] trdNm = (JSPUtil.getParameter(request, prefix	+ "trd_nm", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] stEffDt = (JSPUtil.getParameter(request, prefix	+ "st_eff_dt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] endEffDt = (JSPUtil.getParameter(request, prefix	+ "end_eff_dt", length));
			String[] toContiCd = (JSPUtil.getParameter(request, prefix	+ "to_conti_cd", length));
			String[] vslTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rqstNo = (JSPUtil.getParameter(request, prefix	+ "rqstNo", length));
			String[] modiCostCtrCd = (JSPUtil.getParameter(request, prefix	+ "modi_cost_ctr_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new TradeVO();
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (fmContiCd[i] != null)
					model.setFmContiCd(fmContiCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trdNm[i] != null)
					model.setTrdNm(trdNm[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (stEffDt[i] != null)
					model.setStEffDt(stEffDt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (endEffDt[i] != null)
					model.setEndEffDt(endEffDt[i]);
				if (toContiCd[i] != null)
					model.setToContiCd(toContiCd[i]);
				if (vslTpCd[i] != null)
					model.setVslTpCd(vslTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rqstNo[i] != null)
					model.setRqstNo(rqstNo[i]);
				if (modiCostCtrCd[i] != null)
					model.setModiCostCtrCd(modiCostCtrCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchTrdCodeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchTrdCodeVO[]
	 */
	public TradeVO[] getSearchTrdCodeVOs(){
		TradeVO[] vos = (TradeVO[])models.toArray(new TradeVO[models.size()]);
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
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmContiCd = this.fmContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdNm = this.trdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stEffDt = this.stEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endEffDt = this.endEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toContiCd = this.toContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslTpCd = this.vslTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstNo = this.rqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiCostCtrCd = this.modiCostCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

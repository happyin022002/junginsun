/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TradeIbisIfVO.java
*@FileTitle : TradeIbisIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.07  
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

public class TradeIbisIfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TradeIbisIfVO> models = new ArrayList<TradeIbisIfVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ifSndDt = null;
	/* Column Info */
	private String trdNm = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String modiTrdCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String stEffDt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String vslTpCd = null;
	/* Column Info */
	private String endEffDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmContiCd = null;
	/* Column Info */
	private String ifMnplCd = null;
	/* Column Info */
	private String ifSndCd = null;
	/* Column Info */
	private String trdIbisIfSeq = null;
	/* Column Info */
	private String modiCostCtrCd = null;
	/* Column Info */
	private String toContiCd = null;
	/* Column Info */
	private String ifErrCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TradeIbisIfVO() {}

	public TradeIbisIfVO(String ibflag, String pagerows, String trdIbisIfSeq, String trdCd, String trdNm, String vslTpCd, String fmContiCd, String toContiCd, String modiTrdCd, String ofcCd, String stEffDt, String endEffDt, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String modiCostCtrCd, String ifSndCd, String ifSndDt, String ifErrCd, String ifMnplCd) {
		this.updDt = updDt;
		this.ifSndDt = ifSndDt;
		this.trdNm = trdNm;
		this.deltFlg = deltFlg;
		this.modiTrdCd = modiTrdCd;
		this.creDt = creDt;
		this.stEffDt = stEffDt;
		this.trdCd = trdCd;
		this.vslTpCd = vslTpCd;
		this.endEffDt = endEffDt;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.fmContiCd = fmContiCd;
		this.ifMnplCd = ifMnplCd;
		this.ifSndCd = ifSndCd;
		this.trdIbisIfSeq = trdIbisIfSeq;
		this.modiCostCtrCd = modiCostCtrCd;
		this.toContiCd = toContiCd;
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
		this.hashColumns.put("trd_nm", getTrdNm());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("modi_trd_cd", getModiTrdCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("st_eff_dt", getStEffDt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("vsl_tp_cd", getVslTpCd());
		this.hashColumns.put("end_eff_dt", getEndEffDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_conti_cd", getFmContiCd());
		this.hashColumns.put("if_mnpl_cd", getIfMnplCd());
		this.hashColumns.put("if_snd_cd", getIfSndCd());
		this.hashColumns.put("trd_ibis_if_seq", getTrdIbisIfSeq());
		this.hashColumns.put("modi_cost_ctr_cd", getModiCostCtrCd());
		this.hashColumns.put("to_conti_cd", getToContiCd());
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
		this.hashFields.put("trd_nm", "trdNm");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("modi_trd_cd", "modiTrdCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("st_eff_dt", "stEffDt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("vsl_tp_cd", "vslTpCd");
		this.hashFields.put("end_eff_dt", "endEffDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_conti_cd", "fmContiCd");
		this.hashFields.put("if_mnpl_cd", "ifMnplCd");
		this.hashFields.put("if_snd_cd", "ifSndCd");
		this.hashFields.put("trd_ibis_if_seq", "trdIbisIfSeq");
		this.hashFields.put("modi_cost_ctr_cd", "modiCostCtrCd");
		this.hashFields.put("to_conti_cd", "toContiCd");
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
	 * @return modiTrdCd
	 */
	public String getModiTrdCd() {
		return this.modiTrdCd;
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
	 * @return vslTpCd
	 */
	public String getVslTpCd() {
		return this.vslTpCd;
	}
	
	/**
	 * Column Info
	 * @return endEffDt
	 */
	public String getEndEffDt() {
		return this.endEffDt;
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
	 * @return fmContiCd
	 */
	public String getFmContiCd() {
		return this.fmContiCd;
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
	 * @return trdIbisIfSeq
	 */
	public String getTrdIbisIfSeq() {
		return this.trdIbisIfSeq;
	}
	
	/**
	 * Column Info
	 * @return modiCostCtrCd
	 */
	public String getModiCostCtrCd() {
		return this.modiCostCtrCd;
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
	 * @param modiTrdCd
	 */
	public void setModiTrdCd(String modiTrdCd) {
		this.modiTrdCd = modiTrdCd;
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
	 * @param vslTpCd
	 */
	public void setVslTpCd(String vslTpCd) {
		this.vslTpCd = vslTpCd;
	}
	
	/**
	 * Column Info
	 * @param endEffDt
	 */
	public void setEndEffDt(String endEffDt) {
		this.endEffDt = endEffDt;
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
	 * @param fmContiCd
	 */
	public void setFmContiCd(String fmContiCd) {
		this.fmContiCd = fmContiCd;
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
	 * @param trdIbisIfSeq
	 */
	public void setTrdIbisIfSeq(String trdIbisIfSeq) {
		this.trdIbisIfSeq = trdIbisIfSeq;
	}
	
	/**
	 * Column Info
	 * @param modiCostCtrCd
	 */
	public void setModiCostCtrCd(String modiCostCtrCd) {
		this.modiCostCtrCd = modiCostCtrCd;
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
		setTrdNm(JSPUtil.getParameter(request, prefix + "trd_nm", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setModiTrdCd(JSPUtil.getParameter(request, prefix + "modi_trd_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setStEffDt(JSPUtil.getParameter(request, prefix + "st_eff_dt", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setVslTpCd(JSPUtil.getParameter(request, prefix + "vsl_tp_cd", ""));
		setEndEffDt(JSPUtil.getParameter(request, prefix + "end_eff_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFmContiCd(JSPUtil.getParameter(request, prefix + "fm_conti_cd", ""));
		setIfMnplCd(JSPUtil.getParameter(request, prefix + "if_mnpl_cd", ""));
		setIfSndCd(JSPUtil.getParameter(request, prefix + "if_snd_cd", ""));
		setTrdIbisIfSeq(JSPUtil.getParameter(request, prefix + "trd_ibis_if_seq", ""));
		setModiCostCtrCd(JSPUtil.getParameter(request, prefix + "modi_cost_ctr_cd", ""));
		setToContiCd(JSPUtil.getParameter(request, prefix + "to_conti_cd", ""));
		setIfErrCd(JSPUtil.getParameter(request, prefix + "if_err_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TradeIbisIfVO[]
	 */
	public TradeIbisIfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TradeIbisIfVO[]
	 */
	public TradeIbisIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TradeIbisIfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ifSndDt = (JSPUtil.getParameter(request, prefix	+ "if_snd_dt", length));
			String[] trdNm = (JSPUtil.getParameter(request, prefix	+ "trd_nm", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] modiTrdCd = (JSPUtil.getParameter(request, prefix	+ "modi_trd_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] stEffDt = (JSPUtil.getParameter(request, prefix	+ "st_eff_dt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] vslTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_tp_cd", length));
			String[] endEffDt = (JSPUtil.getParameter(request, prefix	+ "end_eff_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmContiCd = (JSPUtil.getParameter(request, prefix	+ "fm_conti_cd", length));
			String[] ifMnplCd = (JSPUtil.getParameter(request, prefix	+ "if_mnpl_cd", length));
			String[] ifSndCd = (JSPUtil.getParameter(request, prefix	+ "if_snd_cd", length));
			String[] trdIbisIfSeq = (JSPUtil.getParameter(request, prefix	+ "trd_ibis_if_seq", length));
			String[] modiCostCtrCd = (JSPUtil.getParameter(request, prefix	+ "modi_cost_ctr_cd", length));
			String[] toContiCd = (JSPUtil.getParameter(request, prefix	+ "to_conti_cd", length));
			String[] ifErrCd = (JSPUtil.getParameter(request, prefix	+ "if_err_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new TradeIbisIfVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ifSndDt[i] != null)
					model.setIfSndDt(ifSndDt[i]);
				if (trdNm[i] != null)
					model.setTrdNm(trdNm[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (modiTrdCd[i] != null)
					model.setModiTrdCd(modiTrdCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (stEffDt[i] != null)
					model.setStEffDt(stEffDt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (vslTpCd[i] != null)
					model.setVslTpCd(vslTpCd[i]);
				if (endEffDt[i] != null)
					model.setEndEffDt(endEffDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmContiCd[i] != null)
					model.setFmContiCd(fmContiCd[i]);
				if (ifMnplCd[i] != null)
					model.setIfMnplCd(ifMnplCd[i]);
				if (ifSndCd[i] != null)
					model.setIfSndCd(ifSndCd[i]);
				if (trdIbisIfSeq[i] != null)
					model.setTrdIbisIfSeq(trdIbisIfSeq[i]);
				if (modiCostCtrCd[i] != null)
					model.setModiCostCtrCd(modiCostCtrCd[i]);
				if (toContiCd[i] != null)
					model.setToContiCd(toContiCd[i]);
				if (ifErrCd[i] != null)
					model.setIfErrCd(ifErrCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTradeIbisIfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TradeIbisIfVO[]
	 */
	public TradeIbisIfVO[] getTradeIbisIfVOs(){
		TradeIbisIfVO[] vos = (TradeIbisIfVO[])models.toArray(new TradeIbisIfVO[models.size()]);
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
		this.trdNm = this.trdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiTrdCd = this.modiTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stEffDt = this.stEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslTpCd = this.vslTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endEffDt = this.endEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmContiCd = this.fmContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifMnplCd = this.ifMnplCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifSndCd = this.ifSndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdIbisIfSeq = this.trdIbisIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiCostCtrCd = this.modiCostCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toContiCd = this.toContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifErrCd = this.ifErrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

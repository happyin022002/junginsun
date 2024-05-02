/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPriCmpbGlineAmtVO.java
*@FileTitle : RsltPriCmpbGlineAmtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.04
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.07.04 이승준 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이승준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPriCmpbGlineAmtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriCmpbGlineAmtVO> models = new ArrayList<RsltPriCmpbGlineAmtVO>();
	
	/* Column Info */
	private String bseSeq = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String mqcRngToQty = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cmpbSeq = null;
	/* Column Info */
	private String glineSeq = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String prsCustTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cmpbAmt = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String mqcRngFmQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriCmpbGlineAmtVO() {}

	public RsltPriCmpbGlineAmtVO(String ibflag, String pagerows, String mqcRngToQty, String ratUtCd, String prcCgoTpCd, String currCd, String cmpbAmt, String creUsrId, String creDt, String updUsrId, String updDt, String svcScpCd, String creOfcCd, String glineSeq, String prsCustTpCd, String bseSeq, String cmpbSeq, String mqcRngFmQty, String effDt, String expDt) {
		this.bseSeq = bseSeq;
		this.updDt = updDt;
		this.currCd = currCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.mqcRngToQty = mqcRngToQty;
		this.svcScpCd = svcScpCd;
		this.creDt = creDt;
		this.cmpbSeq = cmpbSeq;
		this.glineSeq = glineSeq;
		this.ratUtCd = ratUtCd;
		this.pagerows = pagerows;
		this.effDt = effDt;
		this.prsCustTpCd = prsCustTpCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.cmpbAmt = cmpbAmt;
		this.creOfcCd = creOfcCd;
		this.expDt = expDt;
		this.updUsrId = updUsrId;
		this.mqcRngFmQty = mqcRngFmQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bse_seq", getBseSeq());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("mqc_rng_to_qty", getMqcRngToQty());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cmpb_seq", getCmpbSeq());
		this.hashColumns.put("gline_seq", getGlineSeq());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("prs_cust_tp_cd", getPrsCustTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cmpb_amt", getCmpbAmt());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mqc_rng_fm_qty", getMqcRngFmQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bse_seq", "bseSeq");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("mqc_rng_to_qty", "mqcRngToQty");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cmpb_seq", "cmpbSeq");
		this.hashFields.put("gline_seq", "glineSeq");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("prs_cust_tp_cd", "prsCustTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cmpb_amt", "cmpbAmt");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mqc_rng_fm_qty", "mqcRngFmQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bseSeq
	 */
	public String getBseSeq() {
		return this.bseSeq;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return prcCgoTpCd
	 */
	public String getPrcCgoTpCd() {
		return this.prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return mqcRngToQty
	 */
	public String getMqcRngToQty() {
		return this.mqcRngToQty;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
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
	 * @return cmpbSeq
	 */
	public String getCmpbSeq() {
		return this.cmpbSeq;
	}
	
	/**
	 * Column Info
	 * @return glineSeq
	 */
	public String getGlineSeq() {
		return this.glineSeq;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return prsCustTpCd
	 */
	public String getPrsCustTpCd() {
		return this.prsCustTpCd;
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
	 * @return cmpbAmt
	 */
	public String getCmpbAmt() {
		return this.cmpbAmt;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
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
	 * @return mqcRngFmQty
	 */
	public String getMqcRngFmQty() {
		return this.mqcRngFmQty;
	}
	

	/**
	 * Column Info
	 * @param bseSeq
	 */
	public void setBseSeq(String bseSeq) {
		this.bseSeq = bseSeq;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param prcCgoTpCd
	 */
	public void setPrcCgoTpCd(String prcCgoTpCd) {
		this.prcCgoTpCd = prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param mqcRngToQty
	 */
	public void setMqcRngToQty(String mqcRngToQty) {
		this.mqcRngToQty = mqcRngToQty;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
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
	 * @param cmpbSeq
	 */
	public void setCmpbSeq(String cmpbSeq) {
		this.cmpbSeq = cmpbSeq;
	}
	
	/**
	 * Column Info
	 * @param glineSeq
	 */
	public void setGlineSeq(String glineSeq) {
		this.glineSeq = glineSeq;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param prsCustTpCd
	 */
	public void setPrsCustTpCd(String prsCustTpCd) {
		this.prsCustTpCd = prsCustTpCd;
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
	 * @param cmpbAmt
	 */
	public void setCmpbAmt(String cmpbAmt) {
		this.cmpbAmt = cmpbAmt;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
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
	 * @param mqcRngFmQty
	 */
	public void setMqcRngFmQty(String mqcRngFmQty) {
		this.mqcRngFmQty = mqcRngFmQty;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBseSeq(JSPUtil.getParameter(request, "bse_seq", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, "prc_cgo_tp_cd", ""));
		setMqcRngToQty(JSPUtil.getParameter(request, "mqc_rng_to_qty", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCmpbSeq(JSPUtil.getParameter(request, "cmpb_seq", ""));
		setGlineSeq(JSPUtil.getParameter(request, "gline_seq", ""));
		setRatUtCd(JSPUtil.getParameter(request, "rat_ut_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setPrsCustTpCd(JSPUtil.getParameter(request, "prs_cust_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCmpbAmt(JSPUtil.getParameter(request, "cmpb_amt", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setMqcRngFmQty(JSPUtil.getParameter(request, "mqc_rng_fm_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriCmpbGlineAmtVO[]
	 */
	public RsltPriCmpbGlineAmtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriCmpbGlineAmtVO[]
	 */
	public RsltPriCmpbGlineAmtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriCmpbGlineAmtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bseSeq = (JSPUtil.getParameter(request, prefix	+ "bse_seq", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] mqcRngToQty = (JSPUtil.getParameter(request, prefix	+ "mqc_rng_to_qty", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cmpbSeq = (JSPUtil.getParameter(request, prefix	+ "cmpb_seq", length));
			String[] glineSeq = (JSPUtil.getParameter(request, prefix	+ "gline_seq", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] prsCustTpCd = (JSPUtil.getParameter(request, prefix	+ "prs_cust_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cmpbAmt = (JSPUtil.getParameter(request, prefix	+ "cmpb_amt", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] mqcRngFmQty = (JSPUtil.getParameter(request, prefix	+ "mqc_rng_fm_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriCmpbGlineAmtVO();
				if (bseSeq[i] != null)
					model.setBseSeq(bseSeq[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (mqcRngToQty[i] != null)
					model.setMqcRngToQty(mqcRngToQty[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cmpbSeq[i] != null)
					model.setCmpbSeq(cmpbSeq[i]);
				if (glineSeq[i] != null)
					model.setGlineSeq(glineSeq[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (prsCustTpCd[i] != null)
					model.setPrsCustTpCd(prsCustTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cmpbAmt[i] != null)
					model.setCmpbAmt(cmpbAmt[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (mqcRngFmQty[i] != null)
					model.setMqcRngFmQty(mqcRngFmQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriCmpbGlineAmtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriCmpbGlineAmtVO[]
	 */
	public RsltPriCmpbGlineAmtVO[] getRsltPriCmpbGlineAmtVOs(){
		RsltPriCmpbGlineAmtVO[] vos = (RsltPriCmpbGlineAmtVO[])models.toArray(new RsltPriCmpbGlineAmtVO[models.size()]);
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
		this.bseSeq = this.bseSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqcRngToQty = this.mqcRngToQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpbSeq = this.cmpbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineSeq = this.glineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsCustTpCd = this.prsCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpbAmt = this.cmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqcRngFmQty = this.mqcRngFmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

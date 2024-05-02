/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomMktRtVO.java
*@FileTitle : CustomMktRtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.16
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.04.16 최우석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 최우석
 * @see
 * @since J2EE 1.5
 */

public class CustomMktRtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMktRtVO> models = new ArrayList<CustomMktRtVO>();
	
	/* 而щ읆 �ㅻ챸 */
	private String mktRtAmt = null;
	/* �곹깭 */
	private String ibflag = null;
	/* 而щ읆 �ㅻ챸 */
	private String mktRtSeq = null;
	/* 而щ읆 �ㅻ챸 */
	private String rngToQty = null;
	/* 而щ읆 �ㅻ챸 */
	private String bldTpNm = null;
	/* 而щ읆 �ㅻ챸 */
	private String updUsrId = null;
	/* 而щ읆 �ㅻ챸 */
	private String rngFmQty = null;
	/* 而щ읆 �ㅻ챸 */
	private String updDt = null;
	/* 而щ읆 �ㅻ챸 */
	private String mktRtYrmon = null;
	/* 而щ읆 �ㅻ챸 */
	private String creDt = null;
	/* 而щ읆 �ㅻ챸 */
	private String deltFlg = null;
	/* 而щ읆 �ㅻ챸 */
	private String creUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomMktRtVO() {}

	public CustomMktRtVO(String ibflag, String pagerows, String mktRtYrmon, String mktRtSeq, String rngFmQty, String rngToQty, String bldTpNm, String mktRtAmt, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.mktRtAmt = mktRtAmt;
		this.ibflag = ibflag;
		this.mktRtSeq = mktRtSeq;
		this.rngToQty = rngToQty;
		this.bldTpNm = bldTpNm;
		this.updUsrId = updUsrId;
		this.rngFmQty = rngFmQty;
		this.updDt = updDt;
		this.mktRtYrmon = mktRtYrmon;
		this.creDt = creDt;
		this.deltFlg = deltFlg;
		this.creUsrId = creUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mkt_rt_amt", getMktRtAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mkt_rt_seq", getMktRtSeq());
		this.hashColumns.put("rng_to_qty", getRngToQty());
		this.hashColumns.put("bld_tp_nm", getBldTpNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rng_fm_qty", getRngFmQty());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("mkt_rt_yrmon", getMktRtYrmon());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mkt_rt_amt", "mktRtAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mkt_rt_seq", "mktRtSeq");
		this.hashFields.put("rng_to_qty", "rngToQty");
		this.hashFields.put("bld_tp_nm", "bldTpNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rng_fm_qty", "rngFmQty");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("mkt_rt_yrmon", "mktRtYrmon");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getMktRtAmt() {
		return this.mktRtAmt;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getMktRtSeq() {
		return this.mktRtSeq;
	}
	public String getRngToQty() {
		return this.rngToQty;
	}
	public String getBldTpNm() {
		return this.bldTpNm;
	}
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getRngFmQty() {
		return this.rngFmQty;
	}
	public String getUpdDt() {
		return this.updDt;
	}
	public String getMktRtYrmon() {
		return this.mktRtYrmon;
	}
	public String getCreDt() {
		return this.creDt;
	}
	public String getDeltFlg() {
		return this.deltFlg;
	}
	public String getCreUsrId() {
		return this.creUsrId;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setMktRtAmt(String mktRtAmt) {
		this.mktRtAmt = mktRtAmt;
		//this.mktRtAmt=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setMktRtSeq(String mktRtSeq) {
		this.mktRtSeq = mktRtSeq;
		//this.mktRtSeq=true;
	}
	public void setRngToQty(String rngToQty) {
		this.rngToQty = rngToQty;
		//this.rngToQty=true;
	}
	public void setBldTpNm(String bldTpNm) {
		this.bldTpNm = bldTpNm;
		//this.bldTpNm=true;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setRngFmQty(String rngFmQty) {
		this.rngFmQty = rngFmQty;
		//this.rngFmQty=true;
	}
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
		//this.updDt=true;
	}
	public void setMktRtYrmon(String mktRtYrmon) {
		this.mktRtYrmon = mktRtYrmon;
		//this.mktRtYrmon=true;
	}
	public void setCreDt(String creDt) {
		this.creDt = creDt;
		//this.creDt=true;
	}
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
		//this.deltFlg=true;
	}
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		//this.creUsrId=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setMktRtAmt(JSPUtil.getParameter(request, "mkt_rt_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMktRtSeq(JSPUtil.getParameter(request, "mkt_rt_seq", ""));
		setRngToQty(JSPUtil.getParameter(request, "rng_to_qty", ""));
		setBldTpNm(JSPUtil.getParameter(request, "bld_tp_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setRngFmQty(JSPUtil.getParameter(request, "rng_fm_qty", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setMktRtYrmon(JSPUtil.getParameter(request, "mkt_rt_yrmon", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public CustomMktRtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CustomMktRtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMktRtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mktRtAmt = (JSPUtil.getParameter(request, prefix	+ "mkt_rt_amt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] mktRtSeq = (JSPUtil.getParameter(request, prefix	+ "mkt_rt_seq".trim(), length));
			String[] rngToQty = (JSPUtil.getParameter(request, prefix	+ "rng_to_qty".trim(), length));
			String[] bldTpNm = (JSPUtil.getParameter(request, prefix	+ "bld_tp_nm".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] rngFmQty = (JSPUtil.getParameter(request, prefix	+ "rng_fm_qty".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] mktRtYrmon = (JSPUtil.getParameter(request, prefix	+ "mkt_rt_yrmon".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMktRtVO();
				if (mktRtAmt[i] != null)
					model.setMktRtAmt(mktRtAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mktRtSeq[i] != null)
					model.setMktRtSeq(mktRtSeq[i]);
				if (rngToQty[i] != null)
					model.setRngToQty(rngToQty[i]);
				if (bldTpNm[i] != null)
					model.setBldTpNm(bldTpNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rngFmQty[i] != null)
					model.setRngFmQty(rngFmQty[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (mktRtYrmon[i] != null)
					model.setMktRtYrmon(mktRtYrmon[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getCustomMktRtVOs();
	}

	public CustomMktRtVO[] getCustomMktRtVOs(){
		CustomMktRtVO[] vos = (CustomMktRtVO[])models.toArray(new CustomMktRtVO[models.size()]);
		return vos;
	}
	
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
		} catch (Exception ex) {}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.mktRtAmt = this.mktRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mktRtSeq = this.mktRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rngToQty = this.rngToQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bldTpNm = this.bldTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rngFmQty = this.rngFmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mktRtYrmon = this.mktRtYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

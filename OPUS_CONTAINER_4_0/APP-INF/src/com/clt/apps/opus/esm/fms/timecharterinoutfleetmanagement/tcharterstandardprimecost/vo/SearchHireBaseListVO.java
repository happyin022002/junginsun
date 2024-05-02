/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchHireBaseListVO.java
*@FileTitle : SearchHireBaseListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.08.20 최우석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최우석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchHireBaseListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchHireBaseListVO> models = new ArrayList<SearchHireBaseListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String prevMktRtYtmon = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String rngToQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mktRtSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mktRtAmt = null;
	/* Column Info */
	private String rngFmQty = null;
	/* Column Info */
	private String bldTpNm = null;
	/* Column Info */
	private String mktRtYrmon = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchHireBaseListVO() {}

	public SearchHireBaseListVO(String ibflag, String pagerows, String mktRtAmt, String mktRtSeq, String rngToQty, String bldTpNm, String updUsrId, String rngFmQty, String updDt, String mktRtYrmon, String prevMktRtYtmon, String creDt, String deltFlg, String creUsrId) {
		this.updDt = updDt;
		this.prevMktRtYtmon = prevMktRtYtmon;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.rngToQty = rngToQty;
		this.pagerows = pagerows;
		this.mktRtSeq = mktRtSeq;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.mktRtAmt = mktRtAmt;
		this.rngFmQty = rngFmQty;
		this.bldTpNm = bldTpNm;
		this.mktRtYrmon = mktRtYrmon;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("prev_mkt_rt_ytmon", getPrevMktRtYtmon());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rng_to_qty", getRngToQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mkt_rt_seq", getMktRtSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mkt_rt_amt", getMktRtAmt());
		this.hashColumns.put("rng_fm_qty", getRngFmQty());
		this.hashColumns.put("bld_tp_nm", getBldTpNm());
		this.hashColumns.put("mkt_rt_yrmon", getMktRtYrmon());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("prev_mkt_rt_ytmon", "prevMktRtYtmon");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rng_to_qty", "rngToQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mkt_rt_seq", "mktRtSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mkt_rt_amt", "mktRtAmt");
		this.hashFields.put("rng_fm_qty", "rngFmQty");
		this.hashFields.put("bld_tp_nm", "bldTpNm");
		this.hashFields.put("mkt_rt_yrmon", "mktRtYrmon");
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
	 * @return prevMktRtYtmon
	 */
	public String getPrevMktRtYtmon() {
		return this.prevMktRtYtmon;
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
	 * @return rngToQty
	 */
	public String getRngToQty() {
		return this.rngToQty;
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
	 * @return mktRtSeq
	 */
	public String getMktRtSeq() {
		return this.mktRtSeq;
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
	 * @return mktRtAmt
	 */
	public String getMktRtAmt() {
		return this.mktRtAmt;
	}
	
	/**
	 * Column Info
	 * @return rngFmQty
	 */
	public String getRngFmQty() {
		return this.rngFmQty;
	}
	
	/**
	 * Column Info
	 * @return bldTpNm
	 */
	public String getBldTpNm() {
		return this.bldTpNm;
	}
	
	/**
	 * Column Info
	 * @return mktRtYrmon
	 */
	public String getMktRtYrmon() {
		return this.mktRtYrmon;
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
	 * @param prevMktRtYtmon
	 */
	public void setPrevMktRtYtmon(String prevMktRtYtmon) {
		this.prevMktRtYtmon = prevMktRtYtmon;
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
	 * @param rngToQty
	 */
	public void setRngToQty(String rngToQty) {
		this.rngToQty = rngToQty;
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
	 * @param mktRtSeq
	 */
	public void setMktRtSeq(String mktRtSeq) {
		this.mktRtSeq = mktRtSeq;
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
	 * @param mktRtAmt
	 */
	public void setMktRtAmt(String mktRtAmt) {
		this.mktRtAmt = mktRtAmt;
	}
	
	/**
	 * Column Info
	 * @param rngFmQty
	 */
	public void setRngFmQty(String rngFmQty) {
		this.rngFmQty = rngFmQty;
	}
	
	/**
	 * Column Info
	 * @param bldTpNm
	 */
	public void setBldTpNm(String bldTpNm) {
		this.bldTpNm = bldTpNm;
	}
	
	/**
	 * Column Info
	 * @param mktRtYrmon
	 */
	public void setMktRtYrmon(String mktRtYrmon) {
		this.mktRtYrmon = mktRtYrmon;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setPrevMktRtYtmon(JSPUtil.getParameter(request, "prev_mkt_rt_ytmon", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setRngToQty(JSPUtil.getParameter(request, "rng_to_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMktRtSeq(JSPUtil.getParameter(request, "mkt_rt_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMktRtAmt(JSPUtil.getParameter(request, "mkt_rt_amt", ""));
		setRngFmQty(JSPUtil.getParameter(request, "rng_fm_qty", ""));
		setBldTpNm(JSPUtil.getParameter(request, "bld_tp_nm", ""));
		setMktRtYrmon(JSPUtil.getParameter(request, "mkt_rt_yrmon", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchHireBaseListVO[]
	 */
	public SearchHireBaseListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchHireBaseListVO[]
	 */
	public SearchHireBaseListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchHireBaseListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] prevMktRtYtmon = (JSPUtil.getParameter(request, prefix	+ "prev_mkt_rt_ytmon", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] rngToQty = (JSPUtil.getParameter(request, prefix	+ "rng_to_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mktRtSeq = (JSPUtil.getParameter(request, prefix	+ "mkt_rt_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mktRtAmt = (JSPUtil.getParameter(request, prefix	+ "mkt_rt_amt", length));
			String[] rngFmQty = (JSPUtil.getParameter(request, prefix	+ "rng_fm_qty", length));
			String[] bldTpNm = (JSPUtil.getParameter(request, prefix	+ "bld_tp_nm", length));
			String[] mktRtYrmon = (JSPUtil.getParameter(request, prefix	+ "mkt_rt_yrmon", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchHireBaseListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (prevMktRtYtmon[i] != null)
					model.setPrevMktRtYtmon(prevMktRtYtmon[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (rngToQty[i] != null)
					model.setRngToQty(rngToQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mktRtSeq[i] != null)
					model.setMktRtSeq(mktRtSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mktRtAmt[i] != null)
					model.setMktRtAmt(mktRtAmt[i]);
				if (rngFmQty[i] != null)
					model.setRngFmQty(rngFmQty[i]);
				if (bldTpNm[i] != null)
					model.setBldTpNm(bldTpNm[i]);
				if (mktRtYrmon[i] != null)
					model.setMktRtYrmon(mktRtYrmon[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchHireBaseListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchHireBaseListVO[]
	 */
	public SearchHireBaseListVO[] getSearchHireBaseListVOs(){
		SearchHireBaseListVO[] vos = (SearchHireBaseListVO[])models.toArray(new SearchHireBaseListVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevMktRtYtmon = this.prevMktRtYtmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rngToQty = this.rngToQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mktRtSeq = this.mktRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mktRtAmt = this.mktRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rngFmQty = this.rngFmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bldTpNm = this.bldTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mktRtYrmon = this.mktRtYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

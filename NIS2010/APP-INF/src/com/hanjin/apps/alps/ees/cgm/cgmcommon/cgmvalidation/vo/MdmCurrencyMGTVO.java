/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MdmCurrencyMGTVO.java
*@FileTitle : MdmCurrencyMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.09.07 최민회 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo;

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
 * @author 최민회
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MdmCurrencyMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MdmCurrencyMGTVO> models = new ArrayList<MdmCurrencyMGTVO>();
	
	/* Column Info */
	private String dpPrcsKnt = null;
	/* Column Info */
	private String currDesc = null;
	/* Column Info */
	private String xtdPrcsKnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String currNm = null;
	/* Column Info */
	private String fmEffDt = null;
	/* Column Info */
	private String toEffDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MdmCurrencyMGTVO() {}

	public MdmCurrencyMGTVO(String ibflag, String pagerows, String currCd, String currNm, String currDesc, String cntCd, String fmEffDt, String toEffDt, String dpPrcsKnt, String xtdPrcsKnt) {
		this.dpPrcsKnt = dpPrcsKnt;
		this.currDesc = currDesc;
		this.xtdPrcsKnt = xtdPrcsKnt;
		this.ibflag = ibflag;
		this.currCd = currCd;
		this.cntCd = cntCd;
		this.currNm = currNm;
		this.fmEffDt = fmEffDt;
		this.toEffDt = toEffDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());
		this.hashColumns.put("curr_desc", getCurrDesc());
		this.hashColumns.put("xtd_prcs_knt", getXtdPrcsKnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("curr_nm", getCurrNm());
		this.hashColumns.put("fm_eff_dt", getFmEffDt());
		this.hashColumns.put("to_eff_dt", getToEffDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("curr_desc", "currDesc");
		this.hashFields.put("xtd_prcs_knt", "xtdPrcsKnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("curr_nm", "currNm");
		this.hashFields.put("fm_eff_dt", "fmEffDt");
		this.hashFields.put("to_eff_dt", "toEffDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dpPrcsKnt
	 */
	public String getDpPrcsKnt() {
		return this.dpPrcsKnt;
	}
	
	/**
	 * Column Info
	 * @return currDesc
	 */
	public String getCurrDesc() {
		return this.currDesc;
	}
	
	/**
	 * Column Info
	 * @return xtdPrcsKnt
	 */
	public String getXtdPrcsKnt() {
		return this.xtdPrcsKnt;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return currNm
	 */
	public String getCurrNm() {
		return this.currNm;
	}
	
	/**
	 * Column Info
	 * @return fmEffDt
	 */
	public String getFmEffDt() {
		return this.fmEffDt;
	}
	
	/**
	 * Column Info
	 * @return toEffDt
	 */
	public String getToEffDt() {
		return this.toEffDt;
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
	 * @param dpPrcsKnt
	 */
	public void setDpPrcsKnt(String dpPrcsKnt) {
		this.dpPrcsKnt = dpPrcsKnt;
	}
	
	/**
	 * Column Info
	 * @param currDesc
	 */
	public void setCurrDesc(String currDesc) {
		this.currDesc = currDesc;
	}
	
	/**
	 * Column Info
	 * @param xtdPrcsKnt
	 */
	public void setXtdPrcsKnt(String xtdPrcsKnt) {
		this.xtdPrcsKnt = xtdPrcsKnt;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param currNm
	 */
	public void setCurrNm(String currNm) {
		this.currNm = currNm;
	}
	
	/**
	 * Column Info
	 * @param fmEffDt
	 */
	public void setFmEffDt(String fmEffDt) {
		this.fmEffDt = fmEffDt;
	}
	
	/**
	 * Column Info
	 * @param toEffDt
	 */
	public void setToEffDt(String toEffDt) {
		this.toEffDt = toEffDt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDpPrcsKnt(JSPUtil.getParameter(request, "dp_prcs_knt", ""));
		setCurrDesc(JSPUtil.getParameter(request, "curr_desc", ""));
		setXtdPrcsKnt(JSPUtil.getParameter(request, "xtd_prcs_knt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setCurrNm(JSPUtil.getParameter(request, "curr_nm", ""));
		setFmEffDt(JSPUtil.getParameter(request, "fm_eff_dt", ""));
		setToEffDt(JSPUtil.getParameter(request, "to_eff_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MdmCurrencyMGTVO[]
	 */
	public MdmCurrencyMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MdmCurrencyMGTVO[]
	 */
	public MdmCurrencyMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MdmCurrencyMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dpPrcsKnt = (JSPUtil.getParameter(request, prefix	+ "dp_prcs_knt", length));
			String[] currDesc = (JSPUtil.getParameter(request, prefix	+ "curr_desc", length));
			String[] xtdPrcsKnt = (JSPUtil.getParameter(request, prefix	+ "xtd_prcs_knt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] currNm = (JSPUtil.getParameter(request, prefix	+ "curr_nm", length));
			String[] fmEffDt = (JSPUtil.getParameter(request, prefix	+ "fm_eff_dt", length));
			String[] toEffDt = (JSPUtil.getParameter(request, prefix	+ "to_eff_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new MdmCurrencyMGTVO();
				if (dpPrcsKnt[i] != null)
					model.setDpPrcsKnt(dpPrcsKnt[i]);
				if (currDesc[i] != null)
					model.setCurrDesc(currDesc[i]);
				if (xtdPrcsKnt[i] != null)
					model.setXtdPrcsKnt(xtdPrcsKnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (currNm[i] != null)
					model.setCurrNm(currNm[i]);
				if (fmEffDt[i] != null)
					model.setFmEffDt(fmEffDt[i]);
				if (toEffDt[i] != null)
					model.setToEffDt(toEffDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMdmCurrencyMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MdmCurrencyMGTVO[]
	 */
	public MdmCurrencyMGTVO[] getMdmCurrencyMGTVOs(){
		MdmCurrencyMGTVO[] vos = (MdmCurrencyMGTVO[])models.toArray(new MdmCurrencyMGTVO[models.size()]);
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
		this.dpPrcsKnt = this.dpPrcsKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currDesc = this.currDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xtdPrcsKnt = this.xtdPrcsKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currNm = this.currNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEffDt = this.fmEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEffDt = this.toEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

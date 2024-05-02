/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : SearchMonthlyQuotaInquiry0127Tab10VO.java
*@FileTitle      : SearchMonthlyQuotaInquiry0127Tab10VO
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo;

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
 * @author 김종호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMonthlyQuotaInquiry0127Tab10VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMonthlyQuotaInquiry0127Tab10VO> models = new ArrayList<SearchMonthlyQuotaInquiry0127Tab10VO>();
	
	/* Column Info */
	private String text = null;
	/* Column Info */
	private String saqTgtGrpCd = null;
	/* Column Info */
	private String grpCd = null;
	/* Column Info */
	private String calTot = null;
	/* Column Info */
	private String grpAqCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String grpDirCd = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String code = null;
	/* Column Info */
	private String grpTrdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String grpSaqTgtGrpCd = null;
	/* Column Info */
	private String calVal03 = null;
	/* Column Info */
	private String calVal02 = null;
	/* Column Info */
	private String calVal01 = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String aqCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMonthlyQuotaInquiry0127Tab10VO() {}

	public SearchMonthlyQuotaInquiry0127Tab10VO(String ibflag, String pagerows, String bseYr, String bseQtrCd, String aqCd, String saqTgtGrpCd, String trdCd, String dirCd, String text, String code, String grpCd, String grpAqCd, String grpSaqTgtGrpCd, String grpTrdCd, String grpDirCd, String calVal01, String calVal02, String calVal03, String calTot) {
		this.text = text;
		this.saqTgtGrpCd = saqTgtGrpCd;
		this.grpCd = grpCd;
		this.calTot = calTot;
		this.grpAqCd = grpAqCd;
		this.trdCd = trdCd;
		this.grpDirCd = grpDirCd;
		this.bseYr = bseYr;
		this.code = code;
		this.grpTrdCd = grpTrdCd;
		this.pagerows = pagerows;
		this.bseQtrCd = bseQtrCd;
		this.ibflag = ibflag;
		this.grpSaqTgtGrpCd = grpSaqTgtGrpCd;
		this.calVal03 = calVal03;
		this.calVal02 = calVal02;
		this.calVal01 = calVal01;
		this.dirCd = dirCd;
		this.aqCd = aqCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("text", getText());
		this.hashColumns.put("saq_tgt_grp_cd", getSaqTgtGrpCd());
		this.hashColumns.put("grp_cd", getGrpCd());
		this.hashColumns.put("cal_tot", getCalTot());
		this.hashColumns.put("grp_aq_cd", getGrpAqCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("grp_dir_cd", getGrpDirCd());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("code", getCode());
		this.hashColumns.put("grp_trd_cd", getGrpTrdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("grp_saq_tgt_grp_cd", getGrpSaqTgtGrpCd());
		this.hashColumns.put("cal_val_03", getCalVal03());
		this.hashColumns.put("cal_val_02", getCalVal02());
		this.hashColumns.put("cal_val_01", getCalVal01());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("aq_cd", getAqCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("text", "text");
		this.hashFields.put("saq_tgt_grp_cd", "saqTgtGrpCd");
		this.hashFields.put("grp_cd", "grpCd");
		this.hashFields.put("cal_tot", "calTot");
		this.hashFields.put("grp_aq_cd", "grpAqCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("grp_dir_cd", "grpDirCd");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("code", "code");
		this.hashFields.put("grp_trd_cd", "grpTrdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("grp_saq_tgt_grp_cd", "grpSaqTgtGrpCd");
		this.hashFields.put("cal_val_03", "calVal03");
		this.hashFields.put("cal_val_02", "calVal02");
		this.hashFields.put("cal_val_01", "calVal01");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("aq_cd", "aqCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return text
	 */
	public String getText() {
		return this.text;
	}
	
	/**
	 * Column Info
	 * @return saqTgtGrpCd
	 */
	public String getSaqTgtGrpCd() {
		return this.saqTgtGrpCd;
	}
	
	/**
	 * Column Info
	 * @return grpCd
	 */
	public String getGrpCd() {
		return this.grpCd;
	}
	
	/**
	 * Column Info
	 * @return calTot
	 */
	public String getCalTot() {
		return this.calTot;
	}
	
	/**
	 * Column Info
	 * @return grpAqCd
	 */
	public String getGrpAqCd() {
		return this.grpAqCd;
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
	 * @return grpDirCd
	 */
	public String getGrpDirCd() {
		return this.grpDirCd;
	}
	
	/**
	 * Column Info
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
	}
	
	/**
	 * Column Info
	 * @return code
	 */
	public String getCode() {
		return this.code;
	}
	
	/**
	 * Column Info
	 * @return grpTrdCd
	 */
	public String getGrpTrdCd() {
		return this.grpTrdCd;
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
	 * @return bseQtrCd
	 */
	public String getBseQtrCd() {
		return this.bseQtrCd;
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
	 * @return grpSaqTgtGrpCd
	 */
	public String getGrpSaqTgtGrpCd() {
		return this.grpSaqTgtGrpCd;
	}
	
	/**
	 * Column Info
	 * @return calVal03
	 */
	public String getCalVal03() {
		return this.calVal03;
	}
	
	/**
	 * Column Info
	 * @return calVal02
	 */
	public String getCalVal02() {
		return this.calVal02;
	}
	
	/**
	 * Column Info
	 * @return calVal01
	 */
	public String getCalVal01() {
		return this.calVal01;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return aqCd
	 */
	public String getAqCd() {
		return this.aqCd;
	}
	

	/**
	 * Column Info
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * Column Info
	 * @param saqTgtGrpCd
	 */
	public void setSaqTgtGrpCd(String saqTgtGrpCd) {
		this.saqTgtGrpCd = saqTgtGrpCd;
	}
	
	/**
	 * Column Info
	 * @param grpCd
	 */
	public void setGrpCd(String grpCd) {
		this.grpCd = grpCd;
	}
	
	/**
	 * Column Info
	 * @param calTot
	 */
	public void setCalTot(String calTot) {
		this.calTot = calTot;
	}
	
	/**
	 * Column Info
	 * @param grpAqCd
	 */
	public void setGrpAqCd(String grpAqCd) {
		this.grpAqCd = grpAqCd;
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
	 * @param grpDirCd
	 */
	public void setGrpDirCd(String grpDirCd) {
		this.grpDirCd = grpDirCd;
	}
	
	/**
	 * Column Info
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
	}
	
	/**
	 * Column Info
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Column Info
	 * @param grpTrdCd
	 */
	public void setGrpTrdCd(String grpTrdCd) {
		this.grpTrdCd = grpTrdCd;
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
	 * @param bseQtrCd
	 */
	public void setBseQtrCd(String bseQtrCd) {
		this.bseQtrCd = bseQtrCd;
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
	 * @param grpSaqTgtGrpCd
	 */
	public void setGrpSaqTgtGrpCd(String grpSaqTgtGrpCd) {
		this.grpSaqTgtGrpCd = grpSaqTgtGrpCd;
	}
	
	/**
	 * Column Info
	 * @param calVal03
	 */
	public void setCalVal03(String calVal03) {
		this.calVal03 = calVal03;
	}
	
	/**
	 * Column Info
	 * @param calVal02
	 */
	public void setCalVal02(String calVal02) {
		this.calVal02 = calVal02;
	}
	
	/**
	 * Column Info
	 * @param calVal01
	 */
	public void setCalVal01(String calVal01) {
		this.calVal01 = calVal01;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param aqCd
	 */
	public void setAqCd(String aqCd) {
		this.aqCd = aqCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setText(JSPUtil.getParameter(request, "text", ""));
		setSaqTgtGrpCd(JSPUtil.getParameter(request, "saq_tgt_grp_cd", ""));
		setGrpCd(JSPUtil.getParameter(request, "grp_cd", ""));
		setCalTot(JSPUtil.getParameter(request, "cal_tot", ""));
		setGrpAqCd(JSPUtil.getParameter(request, "grp_aq_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setGrpDirCd(JSPUtil.getParameter(request, "grp_dir_cd", ""));
		setBseYr(JSPUtil.getParameter(request, "bse_yr", ""));
		setCode(JSPUtil.getParameter(request, "code", ""));
		setGrpTrdCd(JSPUtil.getParameter(request, "grp_trd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBseQtrCd(JSPUtil.getParameter(request, "bse_qtr_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGrpSaqTgtGrpCd(JSPUtil.getParameter(request, "grp_saq_tgt_grp_cd", ""));
		setCalVal03(JSPUtil.getParameter(request, "cal_val_03", ""));
		setCalVal02(JSPUtil.getParameter(request, "cal_val_02", ""));
		setCalVal01(JSPUtil.getParameter(request, "cal_val_01", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setAqCd(JSPUtil.getParameter(request, "aq_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMonthlyQuotaInquiry0127Tab10VO[]
	 */
	public SearchMonthlyQuotaInquiry0127Tab10VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMonthlyQuotaInquiry0127Tab10VO[]
	 */
	public SearchMonthlyQuotaInquiry0127Tab10VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMonthlyQuotaInquiry0127Tab10VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] text = (JSPUtil.getParameter(request, prefix	+ "text", length));
			String[] saqTgtGrpCd = (JSPUtil.getParameter(request, prefix	+ "saq_tgt_grp_cd", length));
			String[] grpCd = (JSPUtil.getParameter(request, prefix	+ "grp_cd", length));
			String[] calTot = (JSPUtil.getParameter(request, prefix	+ "cal_tot", length));
			String[] grpAqCd = (JSPUtil.getParameter(request, prefix	+ "grp_aq_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] grpDirCd = (JSPUtil.getParameter(request, prefix	+ "grp_dir_cd", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code", length));
			String[] grpTrdCd = (JSPUtil.getParameter(request, prefix	+ "grp_trd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] grpSaqTgtGrpCd = (JSPUtil.getParameter(request, prefix	+ "grp_saq_tgt_grp_cd", length));
			String[] calVal03 = (JSPUtil.getParameter(request, prefix	+ "cal_val_03", length));
			String[] calVal02 = (JSPUtil.getParameter(request, prefix	+ "cal_val_02", length));
			String[] calVal01 = (JSPUtil.getParameter(request, prefix	+ "cal_val_01", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] aqCd = (JSPUtil.getParameter(request, prefix	+ "aq_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMonthlyQuotaInquiry0127Tab10VO();
				if (text[i] != null)
					model.setText(text[i]);
				if (saqTgtGrpCd[i] != null)
					model.setSaqTgtGrpCd(saqTgtGrpCd[i]);
				if (grpCd[i] != null)
					model.setGrpCd(grpCd[i]);
				if (calTot[i] != null)
					model.setCalTot(calTot[i]);
				if (grpAqCd[i] != null)
					model.setGrpAqCd(grpAqCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (grpDirCd[i] != null)
					model.setGrpDirCd(grpDirCd[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (code[i] != null)
					model.setCode(code[i]);
				if (grpTrdCd[i] != null)
					model.setGrpTrdCd(grpTrdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (grpSaqTgtGrpCd[i] != null)
					model.setGrpSaqTgtGrpCd(grpSaqTgtGrpCd[i]);
				if (calVal03[i] != null)
					model.setCalVal03(calVal03[i]);
				if (calVal02[i] != null)
					model.setCalVal02(calVal02[i]);
				if (calVal01[i] != null)
					model.setCalVal01(calVal01[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (aqCd[i] != null)
					model.setAqCd(aqCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMonthlyQuotaInquiry0127Tab10VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMonthlyQuotaInquiry0127Tab10VO[]
	 */
	public SearchMonthlyQuotaInquiry0127Tab10VO[] getSearchMonthlyQuotaInquiry0127Tab10VOs(){
		SearchMonthlyQuotaInquiry0127Tab10VO[] vos = (SearchMonthlyQuotaInquiry0127Tab10VO[])models.toArray(new SearchMonthlyQuotaInquiry0127Tab10VO[models.size()]);
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
		this.text = this.text .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saqTgtGrpCd = this.saqTgtGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpCd = this.grpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calTot = this.calTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpAqCd = this.grpAqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpDirCd = this.grpDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpTrdCd = this.grpTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpSaqTgtGrpCd = this.grpSaqTgtGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calVal03 = this.calVal03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calVal02 = this.calVal02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calVal01 = this.calVal01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aqCd = this.aqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

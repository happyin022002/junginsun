/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ReportSearchConditionVO.java
*@FileTitle : ReportSearchConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.24
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2011.05.24 남궁진호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo;

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
 * @author 남궁진호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ReportSearchConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ReportSearchConditionVO> models = new ArrayList<ReportSearchConditionVO>();
	
	/* Column Info */
	private String dio = null;
	/* Column Info */
	private String locTp = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String termChange = null;
	/* Column Info */
	private String arrTpszCd = null;
	/* Column Info */
	private String np = null;
	/* Column Info */
	private String crntLocCd = null;
	/* Column Info */
	private String dii = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String periodStdt = null;
	/* Column Info */
	private String periodEddt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eqKndCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ReportSearchConditionVO() {}

	public ReportSearchConditionVO(String ibflag, String pagerows, String periodStdt, String periodEddt, String lstmCd, String locTp, String crntLocCd, String termChange, String dii, String dio, String np, String arrTpszCd, String eqKndCd) {
		this.dio = dio;
		this.locTp = locTp;
		this.ibflag = ibflag;
		this.termChange = termChange;
		this.arrTpszCd = arrTpszCd;
		this.np = np;
		this.crntLocCd = crntLocCd;
		this.dii = dii;
		this.lstmCd = lstmCd;
		this.periodStdt = periodStdt;
		this.periodEddt = periodEddt;
		this.pagerows = pagerows;
		this.eqKndCd  = eqKndCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dio", getDio());
		this.hashColumns.put("loc_tp", getLocTp());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("term_change", getTermChange());
		this.hashColumns.put("arr_tpsz_cd", getArrTpszCd());
		this.hashColumns.put("np", getNp());
		this.hashColumns.put("crnt_loc_cd", getCrntLocCd());
		this.hashColumns.put("dii", getDii());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("period_stdt", getPeriodStdt());
		this.hashColumns.put("period_eddt", getPeriodEddt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dio", "dio");
		this.hashFields.put("loc_tp", "locTp");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("term_change", "termChange");
		this.hashFields.put("arr_tpsz_cd", "arrTpszCd");
		this.hashFields.put("np", "np");
		this.hashFields.put("crnt_loc_cd", "crntLocCd");
		this.hashFields.put("dii", "dii");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("period_stdt", "periodStdt");
		this.hashFields.put("period_eddt", "periodEddt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dio
	 */
	public String getDio() {
		return this.dio;
	}
	
	/**
	 * Column Info
	 * @return locTp
	 */
	public String getLocTp() {
		return this.locTp;
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
	 * @return termChange
	 */
	public String getTermChange() {
		return this.termChange;
	}
	
	/**
	 * Column Info
	 * @return arrTpszCd
	 */
	public String getArrTpszCd() {
		return this.arrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return np
	 */
	public String getNp() {
		return this.np;
	}
	
	/**
	 * Column Info
	 * @return crntLocCd
	 */
	public String getCrntLocCd() {
		return this.crntLocCd;
	}
	
	/**
	 * Column Info
	 * @return dii
	 */
	public String getDii() {
		return this.dii;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}
	
	/**
	 * Column Info
	 * @return periodStdt
	 */
	public String getPeriodStdt() {
		return this.periodStdt;
	}
	
	/**
	 * Column Info
	 * @return periodEddt
	 */
	public String getPeriodEddt() {
		return this.periodEddt;
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
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}

	/**
	 * Column Info
	 * @param dio
	 */
	public void setDio(String dio) {
		this.dio = dio;
	}
	
	/**
	 * Column Info
	 * @param locTp
	 */
	public void setLocTp(String locTp) {
		this.locTp = locTp;
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
	 * @param termChange
	 */
	public void setTermChange(String termChange) {
		this.termChange = termChange;
	}
	
	/**
	 * Column Info
	 * @param arrTpszCd
	 */
	public void setArrTpszCd(String arrTpszCd) {
		this.arrTpszCd = arrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param np
	 */
	public void setNp(String np) {
		this.np = np;
	}
	
	/**
	 * Column Info
	 * @param crntLocCd
	 */
	public void setCrntLocCd(String crntLocCd) {
		this.crntLocCd = crntLocCd;
	}
	
	/**
	 * Column Info
	 * @param dii
	 */
	public void setDii(String dii) {
		this.dii = dii;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	
	/**
	 * Column Info
	 * @param periodStdt
	 */
	public void setPeriodStdt(String periodStdt) {
		this.periodStdt = periodStdt;
	}
	
	/**
	 * Column Info
	 * @param periodEddt
	 */
	public void setPeriodEddt(String periodEddt) {
		this.periodEddt = periodEddt;
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
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
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
		setDio(JSPUtil.getParameter(request, prefix + "dio", ""));
		setLocTp(JSPUtil.getParameter(request, prefix + "loc_tp", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTermChange(JSPUtil.getParameter(request, prefix + "term_change", ""));
		setArrTpszCd(JSPUtil.getParameter(request, prefix + "arr_tpsz_cd", ""));
		setNp(JSPUtil.getParameter(request, prefix + "np", ""));
		setCrntLocCd(JSPUtil.getParameter(request, prefix + "crnt_loc_cd", ""));
		setDii(JSPUtil.getParameter(request, prefix + "dii", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setPeriodStdt(JSPUtil.getParameter(request, prefix + "period_stdt", ""));
		setPeriodEddt(JSPUtil.getParameter(request, prefix + "period_eddt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ReportSearchConditionVO[]
	 */
	public ReportSearchConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ReportSearchConditionVO[]
	 */
	public ReportSearchConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ReportSearchConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dio = (JSPUtil.getParameter(request, prefix	+ "dio", length));
			String[] locTp = (JSPUtil.getParameter(request, prefix	+ "loc_tp", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] termChange = (JSPUtil.getParameter(request, prefix	+ "term_change", length));
			String[] arrTpszCd = (JSPUtil.getParameter(request, prefix	+ "arr_tpsz_cd", length));
			String[] np = (JSPUtil.getParameter(request, prefix	+ "np", length));
			String[] crntLocCd = (JSPUtil.getParameter(request, prefix	+ "crnt_loc_cd", length));
			String[] dii = (JSPUtil.getParameter(request, prefix	+ "dii", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] periodStdt = (JSPUtil.getParameter(request, prefix	+ "period_stdt", length));
			String[] periodEddt = (JSPUtil.getParameter(request, prefix	+ "period_eddt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ReportSearchConditionVO();
				if (dio[i] != null)
					model.setDio(dio[i]);
				if (locTp[i] != null)
					model.setLocTp(locTp[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (termChange[i] != null)
					model.setTermChange(termChange[i]);
				if (arrTpszCd[i] != null)
					model.setArrTpszCd(arrTpszCd[i]);
				if (np[i] != null)
					model.setNp(np[i]);
				if (crntLocCd[i] != null)
					model.setCrntLocCd(crntLocCd[i]);
				if (dii[i] != null)
					model.setDii(dii[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (periodStdt[i] != null)
					model.setPeriodStdt(periodStdt[i]);
				if (periodEddt[i] != null)
					model.setPeriodEddt(periodEddt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getReportSearchConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ReportSearchConditionVO[]
	 */
	public ReportSearchConditionVO[] getReportSearchConditionVOs(){
		ReportSearchConditionVO[] vos = (ReportSearchConditionVO[])models.toArray(new ReportSearchConditionVO[models.size()]);
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
		this.dio = this.dio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTp = this.locTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termChange = this.termChange .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrTpszCd = this.arrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.np = this.np .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntLocCd = this.crntLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dii = this.dii .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodStdt = this.periodStdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodEddt = this.periodEddt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

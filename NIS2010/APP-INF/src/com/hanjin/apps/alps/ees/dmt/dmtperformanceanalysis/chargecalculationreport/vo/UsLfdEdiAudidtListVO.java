/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsLfdEdiAudidtListVO.java
*@FileTitle : UsLfdEdiAudidtListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.14  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo;

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

public class UsLfdEdiAudidtListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsLfdEdiAudidtListVO> models = new ArrayList<UsLfdEdiAudidtListVO>();
	
	/* Column Info */
	private String result = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String days = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String gndTotal = null;
	/* Column Info */
	private String ftEndDt = null;
	/* Column Info */
	private String receDt = null;
	/* Column Info */
	private String evntDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String alpsBkgNo = null;
	/* Page Number */
	private String dmdtTrfCd = null;
	/* Page Number */
	private String vvd = null;
	/* Page Number */
	private String bkgFlg = null;
	/* Page Number */
	private String gnteFlg = null;
	/* Page Number */
	private String gnteDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public UsLfdEdiAudidtListVO() {}

	public UsLfdEdiAudidtListVO(String ibflag, String pagerows, String cntrNo, String cntrTpszCd, String ydCd, String evntDt, String receDt, String bkgNo, String ftEndDt, String days, String result, String gndTotal, String alpsBkgNo, String dmdtTrfCd, String vvd, String bkgFlg, String gnteFlg, String gnteDt) {
		this.result = result;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.days = days;
		this.ydCd = ydCd;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.gndTotal = gndTotal;
		this.ftEndDt = ftEndDt;
		this.receDt = receDt;
		this.evntDt = evntDt;
		this.pagerows = pagerows;
		this.alpsBkgNo = alpsBkgNo;
		this.dmdtTrfCd = dmdtTrfCd;
		this.vvd = vvd;
		this.bkgFlg = bkgFlg;
		this.gnteFlg = gnteFlg;
		this.gnteDt = gnteDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("result", getResult());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("days", getDays());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("gnd_total", getGndTotal());
		this.hashColumns.put("ft_end_dt", getFtEndDt());
		this.hashColumns.put("rece_dt", getReceDt());
		this.hashColumns.put("evnt_dt", getEvntDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("alps_bkg_no", getAlpsBkgNo());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bkg_flg", getBkgFlg());
		this.hashColumns.put("gnte_flg", getGnteFlg());
		this.hashColumns.put("gnte_dt", getGnteDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("result", "result");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("days", "days");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("gnd_total", "gndTotal");
		this.hashFields.put("ft_end_dt", "ftEndDt");
		this.hashFields.put("rece_dt", "receDt");
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("alps_bkg_no", "alpsBkgNo");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bkg_flg", "bkgFlg");
		this.hashFields.put("gnte_flg", "gnteFlg");
		this.hashFields.put("gnte_dt", "gnteDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return result
	 */
	public String getResult() {
		return this.result;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return days
	 */
	public String getDays() {
		return this.days;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return gndTotal
	 */
	public String getGndTotal() {
		return this.gndTotal;
	}
	
	/**
	 * Column Info
	 * @return ftEndDt
	 */
	public String getFtEndDt() {
		return this.ftEndDt;
	}
	
	/**
	 * Column Info
	 * @return receDt
	 */
	public String getReceDt() {
		return this.receDt;
	}
	
	/**
	 * Column Info
	 * @return evntDt
	 */
	public String getEvntDt() {
		return this.evntDt;
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
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param days
	 */
	public void setDays(String days) {
		this.days = days;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param gndTotal
	 */
	public void setGndTotal(String gndTotal) {
		this.gndTotal = gndTotal;
	}
	
	/**
	 * Column Info
	 * @param ftEndDt
	 */
	public void setFtEndDt(String ftEndDt) {
		this.ftEndDt = ftEndDt;
	}
	
	/**
	 * Column Info
	 * @param receDt
	 */
	public void setReceDt(String receDt) {
		this.receDt = receDt;
	}
	
	/**
	 * Column Info
	 * @param evntDt
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	public String getAlpsBkgNo() {
		return alpsBkgNo;
	}

	public void setAlpsBkgNo(String alpsBkgNo) {
		this.alpsBkgNo = alpsBkgNo;
	}

	public String getDmdtTrfCd() {
		return dmdtTrfCd;
	}

	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}

	public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	public String getBkgFlg() {
		return bkgFlg;
	}

	public void setBkgFlg(String bkgFlg) {
		this.bkgFlg = bkgFlg;
	}

	public String getGnteFlg() {
		return gnteFlg;
	}

	public void setGnteFlg(String gnteFlg) {
		this.gnteFlg = gnteFlg;
	}

	public String getGnteDt() {
		return gnteDt;
	}

	public void setGnteDt(String gnteDt) {
		this.gnteDt = gnteDt;
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
		setResult(JSPUtil.getParameter(request, prefix + "result", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDays(JSPUtil.getParameter(request, prefix + "days", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setGndTotal(JSPUtil.getParameter(request, prefix + "gnd_total", ""));
		setFtEndDt(JSPUtil.getParameter(request, prefix + "ft_end_dt", ""));
		setReceDt(JSPUtil.getParameter(request, prefix + "rece_dt", ""));
		setEvntDt(JSPUtil.getParameter(request, prefix + "evnt_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAlpsBkgNo(JSPUtil.getParameter(request, prefix + "alps_bkg_no", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setBkgFlg(JSPUtil.getParameter(request, prefix + "bkg_flg", ""));
		setGnteFlg(JSPUtil.getParameter(request, prefix + "gnte_flg", ""));
		setGnteDt(JSPUtil.getParameter(request, prefix + "gnte_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsLfdEdiAudidtListVO[]
	 */
	public UsLfdEdiAudidtListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsLfdEdiAudidtListVO[]
	 */
	public UsLfdEdiAudidtListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsLfdEdiAudidtListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] result = (JSPUtil.getParameter(request, prefix	+ "result", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] days = (JSPUtil.getParameter(request, prefix	+ "days", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] gndTotal = (JSPUtil.getParameter(request, prefix	+ "gnd_total", length));
			String[] ftEndDt = (JSPUtil.getParameter(request, prefix	+ "ft_end_dt", length));
			String[] receDt = (JSPUtil.getParameter(request, prefix	+ "rece_dt", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] alpsBkgNo = (JSPUtil.getParameter(request, prefix	+ "alps_bkg_no", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bkgFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_flg", length));
			String[] gnteFlg = (JSPUtil.getParameter(request, prefix	+ "gnte_flg", length));
			String[] gnteDt = (JSPUtil.getParameter(request, prefix	+ "gnte_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsLfdEdiAudidtListVO();
				if (result[i] != null)
					model.setResult(result[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (days[i] != null)
					model.setDays(days[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (gndTotal[i] != null)
					model.setGndTotal(gndTotal[i]);
				if (ftEndDt[i] != null)
					model.setFtEndDt(ftEndDt[i]);
				if (receDt[i] != null)
					model.setReceDt(receDt[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (alpsBkgNo[i] != null)
					model.setAlpsBkgNo(alpsBkgNo[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bkgFlg[i] != null)
					model.setBkgFlg(bkgFlg[i]);
				if (gnteFlg[i] != null)
					model.setGnteFlg(gnteFlg[i]);
				if (gnteDt[i] != null)
					model.setGnteDt(gnteDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsLfdEdiAudidtListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsLfdEdiAudidtListVO[]
	 */
	public UsLfdEdiAudidtListVO[] getUsLfdEdiAudidtListVOs(){
		UsLfdEdiAudidtListVO[] vos = (UsLfdEdiAudidtListVO[])models.toArray(new UsLfdEdiAudidtListVO[models.size()]);
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
		this.result = this.result .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.days = this.days .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gndTotal = this.gndTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftEndDt = this.ftEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.receDt = this.receDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alpsBkgNo = this.alpsBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFlg = this.bkgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnteFlg = this.gnteFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnteDt = this.gnteDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

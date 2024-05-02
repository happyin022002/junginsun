/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CHSPoolSCCReportMGTVO.java
*@FileTitle : CHSPoolSCCReportMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.18  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo;

import java.lang.reflect.Field;
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

public class CHSPoolSCCReportMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSPoolSCCReportMGTVO> models = new ArrayList<CHSPoolSCCReportMGTVO>();
	
	/* Column Info */
	private String year10 = null;
	/* Column Info */
	private String year11 = null;
	/* Column Info */
	private String year12 = null;
	/* Column Info */
	private String div = null;
	/* Column Info */
	private String ttl = null;
	/* Column Info */
	private String poolCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bseDt = null;
	/* Column Info */
	private String scc = null;
	/* Column Info */
	private String year6 = null;
	/* Column Info */
	private String year5 = null;
	/* Column Info */
	private String year8 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String year7 = null;
	/* Column Info */
	private String year9 = null;
	/* Column Info */
	private String year2 = null;
	/* Column Info */
	private String year1 = null;
	/* Column Info */
	private String year4 = null;
	/* Column Info */
	private String year3 = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String ydCd = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSPoolSCCReportMGTVO() {}

	public CHSPoolSCCReportMGTVO(String ibflag, String pagerows, String poolCd, String scc, String div, String ttl, String year1, String year2, String year3, String year4, String year5, String year6, String year7, String year8, String year9, String year10, String year11, String year12, String bseDt, String vndrSeq, String vndrNm, String ydCd) {
		this.year10 = year10;
		this.year11 = year11;
		this.year12 = year12;
		this.div = div;
		this.ttl = ttl;
		this.poolCd = poolCd;
		this.pagerows = pagerows;
		this.bseDt = bseDt;
		this.scc = scc;
		this.year6 = year6;
		this.year5 = year5;
		this.year8 = year8;
		this.ibflag = ibflag;
		this.year7 = year7;
		this.year9 = year9;
		this.year2 = year2;
		this.year1 = year1;
		this.year4 = year4;
		this.year3 = year3;
		this.vndrSeq = vndrSeq;
		this.vndrNm  = vndrNm;
		this.ydCd    = ydCd;

	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("year10", getYear10());
		this.hashColumns.put("year11", getYear11());
		this.hashColumns.put("year12", getYear12());
		this.hashColumns.put("div", getDiv());
		this.hashColumns.put("ttl", getTtl());
		this.hashColumns.put("pool_cd", getPoolCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bse_dt", getBseDt());
		this.hashColumns.put("scc", getScc());
		this.hashColumns.put("year6", getYear6());
		this.hashColumns.put("year5", getYear5());
		this.hashColumns.put("year8", getYear8());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("year7", getYear7());
		this.hashColumns.put("year9", getYear9());
		this.hashColumns.put("year2", getYear2());
		this.hashColumns.put("year1", getYear1());
		this.hashColumns.put("year4", getYear4());
		this.hashColumns.put("year3", getYear3());
		this.hashColumns.put("vndr_seq", getVndrSeq());	
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("yd_cd", getYdCd());		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("year10", "year10");
		this.hashFields.put("year11", "year11");
		this.hashFields.put("year12", "year12");
		this.hashFields.put("div", "div");
		this.hashFields.put("ttl", "ttl");
		this.hashFields.put("pool_cd", "poolCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bse_dt", "bseDt");
		this.hashFields.put("scc", "scc");
		this.hashFields.put("year6", "year6");
		this.hashFields.put("year5", "year5");
		this.hashFields.put("year8", "year8");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("year7", "year7");
		this.hashFields.put("year9", "year9");
		this.hashFields.put("year2", "year2");
		this.hashFields.put("year1", "year1");
		this.hashFields.put("year4", "year4");
		this.hashFields.put("year3", "year3");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("yd_cd", "ydCd");		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return year10
	 */
	public String getYear10() {
		return this.year10;
	}
	
	/**
	 * Column Info
	 * @return year11
	 */
	public String getYear11() {
		return this.year11;
	}
	
	/**
	 * Column Info
	 * @return year12
	 */
	public String getYear12() {
		return this.year12;
	}
	
	/**
	 * Column Info
	 * @return div
	 */
	public String getDiv() {
		return this.div;
	}
	
	/**
	 * Column Info
	 * @return ttl
	 */
	public String getTtl() {
		return this.ttl;
	}
	
	/**
	 * Column Info
	 * @return poolCd
	 */
	public String getPoolCd() {
		return this.poolCd;
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
	 * @return bseDt
	 */
	public String getBseDt() {
		return this.bseDt;
	}
	
	/**
	 * Column Info
	 * @return scc
	 */
	public String getScc() {
		return this.scc;
	}
	
	/**
	 * Column Info
	 * @return year6
	 */
	public String getYear6() {
		return this.year6;
	}
	
	/**
	 * Column Info
	 * @return year5
	 */
	public String getYear5() {
		return this.year5;
	}
	
	/**
	 * Column Info
	 * @return year8
	 */
	public String getYear8() {
		return this.year8;
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
	 * @return year7
	 */
	public String getYear7() {
		return this.year7;
	}
	
	/**
	 * Column Info
	 * @return year9
	 */
	public String getYear9() {
		return this.year9;
	}
	
	/**
	 * Column Info
	 * @return year2
	 */
	public String getYear2() {
		return this.year2;
	}
	
	/**
	 * Column Info
	 * @return year1
	 */
	public String getYear1() {
		return this.year1;
	}
	
	/**
	 * Column Info
	 * @return year4
	 */
	public String getYear4() {
		return this.year4;
	}
	
	/**
	 * Column Info
	 * @return year3
	 */
	public String getYear3() {
		return this.year3;
	}
	

	/**
	 * Column Info
	 * @param year10
	 */
	public void setYear10(String year10) {
		this.year10 = year10;
	}
	
	/**
	 * Column Info
	 * @param year11
	 */
	public void setYear11(String year11) {
		this.year11 = year11;
	}
	
	/**
	 * Column Info
	 * @param year12
	 */
	public void setYear12(String year12) {
		this.year12 = year12;
	}
	
	/**
	 * Column Info
	 * @param div
	 */
	public void setDiv(String div) {
		this.div = div;
	}
	
	/**
	 * Column Info
	 * @param ttl
	 */
	public void setTtl(String ttl) {
		this.ttl = ttl;
	}
	
	/**
	 * Column Info
	 * @param poolCd
	 */
	public void setPoolCd(String poolCd) {
		this.poolCd = poolCd;
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
	 * @param bseDt
	 */
	public void setBseDt(String bseDt) {
		this.bseDt = bseDt;
	}
	
	/**
	 * Column Info
	 * @param scc
	 */
	public void setScc(String scc) {
		this.scc = scc;
	}
	
	/**
	 * Column Info
	 * @param year6
	 */
	public void setYear6(String year6) {
		this.year6 = year6;
	}
	
	/**
	 * Column Info
	 * @param year5
	 */
	public void setYear5(String year5) {
		this.year5 = year5;
	}
	
	/**
	 * Column Info
	 * @param year8
	 */
	public void setYear8(String year8) {
		this.year8 = year8;
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
	 * @param year7
	 */
	public void setYear7(String year7) {
		this.year7 = year7;
	}
	
	/**
	 * Column Info
	 * @param year9
	 */
	public void setYear9(String year9) {
		this.year9 = year9;
	}
	
	/**
	 * Column Info
	 * @param year2
	 */
	public void setYear2(String year2) {
		this.year2 = year2;
	}
	
	/**
	 * Column Info
	 * @param year1
	 */
	public void setYear1(String year1) {
		this.year1 = year1;
	}
	
	/**
	 * Column Info
	 * @param year4
	 */
	public void setYear4(String year4) {
		this.year4 = year4;
	}
	
	/**
	 * Column Info
	 * @param year3
	 */
	public void setYear3(String year3) {
		this.year3 = year3;
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
		setYear10(JSPUtil.getParameter(request, prefix + "year10", ""));
		setYear11(JSPUtil.getParameter(request, prefix + "year11", ""));
		setYear12(JSPUtil.getParameter(request, prefix + "year12", ""));
		setDiv(JSPUtil.getParameter(request, prefix + "div", ""));
		setTtl(JSPUtil.getParameter(request, prefix + "ttl", ""));
		setPoolCd(JSPUtil.getParameter(request, prefix + "pool_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBseDt(JSPUtil.getParameter(request, prefix + "bse_dt", ""));
		setScc(JSPUtil.getParameter(request, prefix + "scc", ""));
		setYear6(JSPUtil.getParameter(request, prefix + "year6", ""));
		setYear5(JSPUtil.getParameter(request, prefix + "year5", ""));
		setYear8(JSPUtil.getParameter(request, prefix + "year8", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setYear7(JSPUtil.getParameter(request, prefix + "year7", ""));
		setYear9(JSPUtil.getParameter(request, prefix + "year9", ""));
		setYear2(JSPUtil.getParameter(request, prefix + "year2", ""));
		setYear1(JSPUtil.getParameter(request, prefix + "year1", ""));
		setYear4(JSPUtil.getParameter(request, prefix + "year4", ""));
		setYear3(JSPUtil.getParameter(request, prefix + "year3", ""));
		
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSPoolSCCReportMGTVO[]
	 */
	public CHSPoolSCCReportMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSPoolSCCReportMGTVO[]
	 */
	public CHSPoolSCCReportMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSPoolSCCReportMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] year10 = (JSPUtil.getParameter(request, prefix	+ "year10", length));
			String[] year11 = (JSPUtil.getParameter(request, prefix	+ "year11", length));
			String[] year12 = (JSPUtil.getParameter(request, prefix	+ "year12", length));
			String[] div = (JSPUtil.getParameter(request, prefix	+ "div", length));
			String[] ttl = (JSPUtil.getParameter(request, prefix	+ "ttl", length));
			String[] poolCd = (JSPUtil.getParameter(request, prefix	+ "pool_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bseDt = (JSPUtil.getParameter(request, prefix	+ "bse_dt", length));
			String[] scc = (JSPUtil.getParameter(request, prefix	+ "scc", length));
			String[] year6 = (JSPUtil.getParameter(request, prefix	+ "year6", length));
			String[] year5 = (JSPUtil.getParameter(request, prefix	+ "year5", length));
			String[] year8 = (JSPUtil.getParameter(request, prefix	+ "year8", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] year7 = (JSPUtil.getParameter(request, prefix	+ "year7", length));
			String[] year9 = (JSPUtil.getParameter(request, prefix	+ "year9", length));
			String[] year2 = (JSPUtil.getParameter(request, prefix	+ "year2", length));
			String[] year1 = (JSPUtil.getParameter(request, prefix	+ "year1", length));
			String[] year4 = (JSPUtil.getParameter(request, prefix	+ "year4", length));
			String[] year3 = (JSPUtil.getParameter(request, prefix	+ "year3", length));

			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vdnr_seq", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vdnr_nm", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSPoolSCCReportMGTVO();
				if (year10[i] != null)
					model.setYear10(year10[i]);
				if (year11[i] != null)
					model.setYear11(year11[i]);
				if (year12[i] != null)
					model.setYear12(year12[i]);
				if (div[i] != null)
					model.setDiv(div[i]);
				if (ttl[i] != null)
					model.setTtl(ttl[i]);
				if (poolCd[i] != null)
					model.setPoolCd(poolCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bseDt[i] != null)
					model.setBseDt(bseDt[i]);
				if (scc[i] != null)
					model.setScc(scc[i]);
				if (year6[i] != null)
					model.setYear6(year6[i]);
				if (year5[i] != null)
					model.setYear5(year5[i]);
				if (year8[i] != null)
					model.setYear8(year8[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (year7[i] != null)
					model.setYear7(year7[i]);
				if (year9[i] != null)
					model.setYear9(year9[i]);
				if (year2[i] != null)
					model.setYear2(year2[i]);
				if (year1[i] != null)
					model.setYear1(year1[i]);
				if (year4[i] != null)
					model.setYear4(year4[i]);
				if (year3[i] != null)
					model.setYear3(year3[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSPoolSCCReportMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSPoolSCCReportMGTVO[]
	 */
	public CHSPoolSCCReportMGTVO[] getCHSPoolSCCReportMGTVOs(){
		CHSPoolSCCReportMGTVO[] vos = (CHSPoolSCCReportMGTVO[])models.toArray(new CHSPoolSCCReportMGTVO[models.size()]);
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
		this.year10 = this.year10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year11 = this.year11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year12 = this.year12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.div = this.div .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttl = this.ttl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poolCd = this.poolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseDt = this.bseDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc = this.scc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year6 = this.year6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year5 = this.year5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year8 = this.year8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year7 = this.year7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year9 = this.year9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year2 = this.year2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year1 = this.year1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year4 = this.year4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year3 = this.year3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm  = this.vndrNm  .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd    = this.ydCd    .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	public String getVndrSeq() {
		return vndrSeq;
	}

	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}

	public String getVndrNm() {
		return vndrNm;
	}

	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}

	public String getYdCd() {
		return ydCd;
	}

	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}


}

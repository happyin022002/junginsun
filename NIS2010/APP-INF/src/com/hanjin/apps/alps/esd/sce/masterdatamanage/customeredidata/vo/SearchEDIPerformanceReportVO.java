/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchEDIPerformanceReportVO.java
*@FileTitle : SearchEDIPerformanceReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.08.20 전병석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo;

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
 * @author 전병석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchEDIPerformanceReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchEDIPerformanceReportVO> models = new ArrayList<SearchEDIPerformanceReportVO>();
	
	/* Column Info */
	private String nt = null;
	/* Column Info */
	private String vat = null;
	/* Column Info */
	private String rln = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String missing = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oan = null;
	/* Column Info */
	private String ediNo = null;
	/* Column Info */
	private String avn = null;
	/* Column Info */
	private String avl = null;
	/* Column Info */
	private String vdl = null;
	/* Column Info */
	private String arn = null;
	/* Column Info */
	private String aln = null;
	/* Column Info */
	private String d = null;
	/* Column Info */
	private String ael = null;
	/* Column Info */
	private String mt = null;
	/* Column Info */
	private String uvd = null;
	/* Column Info */
	private String vdt = null;
	/* Column Info */
	private String in = null;
	/* Column Info */
	private String io = null;
	/* Column Info */
	private String ct = null;
	/* Column Info */
	private String urn = null;
	/* Column Info */
	private String cr = null;
	/* Column Info */
	private String ee = null;
	/* Column Info */
	private String pa = null;
	/* Column Info */
	private String pn = null;
	/* Column Info */
	private String aet = null;
	/* Column Info */
	private String uvt = null;
	/* Column Info */
	private String vad = null;
	/* Column Info */
	private String pq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchEDIPerformanceReportVO() {}

	public SearchEDIPerformanceReportVO(String ibflag, String pagerows, String missing, String ediNo, String ee, String io, String ael, String vdl, String vat, String uvt, String aet, String vdt, String vad, String uvd, String in, String aln, String rln, String arn, String urn, String oan, String d, String mt, String ct, String cr, String pa, String pq, String pn, String avl, String avn, String nt) {
		this.nt = nt;
		this.vat = vat;
		this.rln = rln;
		this.pagerows = pagerows;
		this.missing = missing;
		this.ibflag = ibflag;
		this.oan = oan;
		this.ediNo = ediNo;
		this.avn = avn;
		this.avl = avl;
		this.vdl = vdl;
		this.arn = arn;
		this.aln = aln;
		this.d = d;
		this.ael = ael;
		this.mt = mt;
		this.uvd = uvd;
		this.vdt = vdt;
		this.in = in;
		this.io = io;
		this.ct = ct;
		this.urn = urn;
		this.cr = cr;
		this.ee = ee;
		this.pa = pa;
		this.pn = pn;
		this.aet = aet;
		this.uvt = uvt;
		this.vad = vad;
		this.pq = pq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("nt_", getNt());
		this.hashColumns.put("vat_", getVat());
		this.hashColumns.put("rln_", getRln());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("missing", getMissing());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("oan_", getOan());
		this.hashColumns.put("edi_no", getEdiNo());
		this.hashColumns.put("avn_", getAvn());
		this.hashColumns.put("avl_", getAvl());
		this.hashColumns.put("vdl_", getVdl());
		this.hashColumns.put("arn_", getArn());
		this.hashColumns.put("aln_", getAln());
		this.hashColumns.put("d_", getD());
		this.hashColumns.put("ael_", getAel());
		this.hashColumns.put("mt_", getMt());
		this.hashColumns.put("uvd_", getUvd());
		this.hashColumns.put("vdt_", getVdt());
		this.hashColumns.put("in_", getIn());
		this.hashColumns.put("io_", getIo());
		this.hashColumns.put("ct_", getCt());
		this.hashColumns.put("urn_", getUrn());
		this.hashColumns.put("cr_", getCr());
		this.hashColumns.put("ee_", getEe());
		this.hashColumns.put("pa_", getPa());
		this.hashColumns.put("pn_", getPn());
		this.hashColumns.put("aet_", getAet());
		this.hashColumns.put("uvt_", getUvt());
		this.hashColumns.put("vad_", getVad());
		this.hashColumns.put("pq_", getPq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("nt_", "nt");
		this.hashFields.put("vat_", "vat");
		this.hashFields.put("rln_", "rln");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("missing", "missing");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("oan_", "oan");
		this.hashFields.put("edi_no", "ediNo");
		this.hashFields.put("avn_", "avn");
		this.hashFields.put("avl_", "avl");
		this.hashFields.put("vdl_", "vdl");
		this.hashFields.put("arn_", "arn");
		this.hashFields.put("aln_", "aln");
		this.hashFields.put("d_", "d");
		this.hashFields.put("ael_", "ael");
		this.hashFields.put("mt_", "mt");
		this.hashFields.put("uvd_", "uvd");
		this.hashFields.put("vdt_", "vdt");
		this.hashFields.put("in_", "in");
		this.hashFields.put("io_", "io");
		this.hashFields.put("ct_", "ct");
		this.hashFields.put("urn_", "urn");
		this.hashFields.put("cr_", "cr");
		this.hashFields.put("ee_", "ee");
		this.hashFields.put("pa_", "pa");
		this.hashFields.put("pn_", "pn");
		this.hashFields.put("aet_", "aet");
		this.hashFields.put("uvt_", "uvt");
		this.hashFields.put("vad_", "vad");
		this.hashFields.put("pq_", "pq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return nt
	 */
	public String getNt() {
		return this.nt;
	}
	
	/**
	 * Column Info
	 * @return vat
	 */
	public String getVat() {
		return this.vat;
	}
	
	/**
	 * Column Info
	 * @return rln
	 */
	public String getRln() {
		return this.rln;
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
	 * @return missing
	 */
	public String getMissing() {
		return this.missing;
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
	 * @return oan
	 */
	public String getOan() {
		return this.oan;
	}
	
	/**
	 * Column Info
	 * @return ediNo
	 */
	public String getEdiNo() {
		return this.ediNo;
	}
	
	/**
	 * Column Info
	 * @return avn
	 */
	public String getAvn() {
		return this.avn;
	}
	
	/**
	 * Column Info
	 * @return avl
	 */
	public String getAvl() {
		return this.avl;
	}
	
	/**
	 * Column Info
	 * @return vdl
	 */
	public String getVdl() {
		return this.vdl;
	}
	
	/**
	 * Column Info
	 * @return arn
	 */
	public String getArn() {
		return this.arn;
	}
	
	/**
	 * Column Info
	 * @return aln
	 */
	public String getAln() {
		return this.aln;
	}
	
	/**
	 * Column Info
	 * @return d
	 */
	public String getD() {
		return this.d;
	}
	
	/**
	 * Column Info
	 * @return ael
	 */
	public String getAel() {
		return this.ael;
	}
	
	/**
	 * Column Info
	 * @return mt
	 */
	public String getMt() {
		return this.mt;
	}
	
	/**
	 * Column Info
	 * @return uvd
	 */
	public String getUvd() {
		return this.uvd;
	}
	
	/**
	 * Column Info
	 * @return vdt
	 */
	public String getVdt() {
		return this.vdt;
	}
	
	/**
	 * Column Info
	 * @return in
	 */
	public String getIn() {
		return this.in;
	}
	
	/**
	 * Column Info
	 * @return io
	 */
	public String getIo() {
		return this.io;
	}
	
	/**
	 * Column Info
	 * @return ct
	 */
	public String getCt() {
		return this.ct;
	}
	
	/**
	 * Column Info
	 * @return urn
	 */
	public String getUrn() {
		return this.urn;
	}
	
	/**
	 * Column Info
	 * @return cr
	 */
	public String getCr() {
		return this.cr;
	}
	
	/**
	 * Column Info
	 * @return ee
	 */
	public String getEe() {
		return this.ee;
	}
	
	/**
	 * Column Info
	 * @return pa
	 */
	public String getPa() {
		return this.pa;
	}
	
	/**
	 * Column Info
	 * @return pn
	 */
	public String getPn() {
		return this.pn;
	}
	
	/**
	 * Column Info
	 * @return aet
	 */
	public String getAet() {
		return this.aet;
	}
	
	/**
	 * Column Info
	 * @return uvt
	 */
	public String getUvt() {
		return this.uvt;
	}
	
	/**
	 * Column Info
	 * @return vad
	 */
	public String getVad() {
		return this.vad;
	}
	
	/**
	 * Column Info
	 * @return pq
	 */
	public String getPq() {
		return this.pq;
	}
	

	/**
	 * Column Info
	 * @param nt
	 */
	public void setNt(String nt) {
		this.nt = nt;
	}
	
	/**
	 * Column Info
	 * @param vat
	 */
	public void setVat(String vat) {
		this.vat = vat;
	}
	
	/**
	 * Column Info
	 * @param rln
	 */
	public void setRln(String rln) {
		this.rln = rln;
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
	 * @param missing
	 */
	public void setMissing(String missing) {
		this.missing = missing;
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
	 * @param oan
	 */
	public void setOan(String oan) {
		this.oan = oan;
	}
	
	/**
	 * Column Info
	 * @param ediNo
	 */
	public void setEdiNo(String ediNo) {
		this.ediNo = ediNo;
	}
	
	/**
	 * Column Info
	 * @param avn
	 */
	public void setAvn(String avn) {
		this.avn = avn;
	}
	
	/**
	 * Column Info
	 * @param avl
	 */
	public void setAvl(String avl) {
		this.avl = avl;
	}
	
	/**
	 * Column Info
	 * @param vdl
	 */
	public void setVdl(String vdl) {
		this.vdl = vdl;
	}
	
	/**
	 * Column Info
	 * @param arn
	 */
	public void setArn(String arn) {
		this.arn = arn;
	}
	
	/**
	 * Column Info
	 * @param aln
	 */
	public void setAln(String aln) {
		this.aln = aln;
	}
	
	/**
	 * Column Info
	 * @param d
	 */
	public void setD(String d) {
		this.d = d;
	}
	
	/**
	 * Column Info
	 * @param ael
	 */
	public void setAel(String ael) {
		this.ael = ael;
	}
	
	/**
	 * Column Info
	 * @param mt
	 */
	public void setMt(String mt) {
		this.mt = mt;
	}
	
	/**
	 * Column Info
	 * @param uvd
	 */
	public void setUvd(String uvd) {
		this.uvd = uvd;
	}
	
	/**
	 * Column Info
	 * @param vdt
	 */
	public void setVdt(String vdt) {
		this.vdt = vdt;
	}
	
	/**
	 * Column Info
	 * @param in
	 */
	public void setIn(String in) {
		this.in = in;
	}
	
	/**
	 * Column Info
	 * @param io
	 */
	public void setIo(String io) {
		this.io = io;
	}
	
	/**
	 * Column Info
	 * @param ct
	 */
	public void setCt(String ct) {
		this.ct = ct;
	}
	
	/**
	 * Column Info
	 * @param urn
	 */
	public void setUrn(String urn) {
		this.urn = urn;
	}
	
	/**
	 * Column Info
	 * @param cr
	 */
	public void setCr(String cr) {
		this.cr = cr;
	}
	
	/**
	 * Column Info
	 * @param ee
	 */
	public void setEe(String ee) {
		this.ee = ee;
	}
	
	/**
	 * Column Info
	 * @param pa
	 */
	public void setPa(String pa) {
		this.pa = pa;
	}
	
	/**
	 * Column Info
	 * @param pn
	 */
	public void setPn(String pn) {
		this.pn = pn;
	}
	
	/**
	 * Column Info
	 * @param aet
	 */
	public void setAet(String aet) {
		this.aet = aet;
	}
	
	/**
	 * Column Info
	 * @param uvt
	 */
	public void setUvt(String uvt) {
		this.uvt = uvt;
	}
	
	/**
	 * Column Info
	 * @param vad
	 */
	public void setVad(String vad) {
		this.vad = vad;
	}
	
	/**
	 * Column Info
	 * @param pq
	 */
	public void setPq(String pq) {
		this.pq = pq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setNt(JSPUtil.getParameter(request, "nt_", ""));
		setVat(JSPUtil.getParameter(request, "vat_", ""));
		setRln(JSPUtil.getParameter(request, "rln_", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMissing(JSPUtil.getParameter(request, "missing", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOan(JSPUtil.getParameter(request, "oan_", ""));
		setEdiNo(JSPUtil.getParameter(request, "edi_no", ""));
		setAvn(JSPUtil.getParameter(request, "avn_", ""));
		setAvl(JSPUtil.getParameter(request, "avl_", ""));
		setVdl(JSPUtil.getParameter(request, "vdl_", ""));
		setArn(JSPUtil.getParameter(request, "arn_", ""));
		setAln(JSPUtil.getParameter(request, "aln_", ""));
		setD(JSPUtil.getParameter(request, "d_", ""));
		setAel(JSPUtil.getParameter(request, "ael_", ""));
		setMt(JSPUtil.getParameter(request, "mt_", ""));
		setUvd(JSPUtil.getParameter(request, "uvd_", ""));
		setVdt(JSPUtil.getParameter(request, "vdt_", ""));
		setIn(JSPUtil.getParameter(request, "in_", ""));
		setIo(JSPUtil.getParameter(request, "io_", ""));
		setCt(JSPUtil.getParameter(request, "ct_", ""));
		setUrn(JSPUtil.getParameter(request, "urn_", ""));
		setCr(JSPUtil.getParameter(request, "cr_", ""));
		setEe(JSPUtil.getParameter(request, "ee_", ""));
		setPa(JSPUtil.getParameter(request, "pa_", ""));
		setPn(JSPUtil.getParameter(request, "pn_", ""));
		setAet(JSPUtil.getParameter(request, "aet_", ""));
		setUvt(JSPUtil.getParameter(request, "uvt_", ""));
		setVad(JSPUtil.getParameter(request, "vad_", ""));
		setPq(JSPUtil.getParameter(request, "pq_", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEDIPerformanceReportVO[]
	 */
	public SearchEDIPerformanceReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchEDIPerformanceReportVO[]
	 */
	public SearchEDIPerformanceReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchEDIPerformanceReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] nt = (JSPUtil.getParameter(request, prefix	+ "nt_", length));
			String[] vat = (JSPUtil.getParameter(request, prefix	+ "vat_", length));
			String[] rln = (JSPUtil.getParameter(request, prefix	+ "rln_", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] missing = (JSPUtil.getParameter(request, prefix	+ "missing", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oan = (JSPUtil.getParameter(request, prefix	+ "oan_", length));
			String[] ediNo = (JSPUtil.getParameter(request, prefix	+ "edi_no", length));
			String[] avn = (JSPUtil.getParameter(request, prefix	+ "avn_", length));
			String[] avl = (JSPUtil.getParameter(request, prefix	+ "avl_", length));
			String[] vdl = (JSPUtil.getParameter(request, prefix	+ "vdl_", length));
			String[] arn = (JSPUtil.getParameter(request, prefix	+ "arn_", length));
			String[] aln = (JSPUtil.getParameter(request, prefix	+ "aln_", length));
			String[] d = (JSPUtil.getParameter(request, prefix	+ "d_", length));
			String[] ael = (JSPUtil.getParameter(request, prefix	+ "ael_", length));
			String[] mt = (JSPUtil.getParameter(request, prefix	+ "mt_", length));
			String[] uvd = (JSPUtil.getParameter(request, prefix	+ "uvd_", length));
			String[] vdt = (JSPUtil.getParameter(request, prefix	+ "vdt_", length));
			String[] in = (JSPUtil.getParameter(request, prefix	+ "in_", length));
			String[] io = (JSPUtil.getParameter(request, prefix	+ "io_", length));
			String[] ct = (JSPUtil.getParameter(request, prefix	+ "ct_", length));
			String[] urn = (JSPUtil.getParameter(request, prefix	+ "urn_", length));
			String[] cr = (JSPUtil.getParameter(request, prefix	+ "cr_", length));
			String[] ee = (JSPUtil.getParameter(request, prefix	+ "ee_", length));
			String[] pa = (JSPUtil.getParameter(request, prefix	+ "pa_", length));
			String[] pn = (JSPUtil.getParameter(request, prefix	+ "pn_", length));
			String[] aet = (JSPUtil.getParameter(request, prefix	+ "aet_", length));
			String[] uvt = (JSPUtil.getParameter(request, prefix	+ "uvt_", length));
			String[] vad = (JSPUtil.getParameter(request, prefix	+ "vad_", length));
			String[] pq = (JSPUtil.getParameter(request, prefix	+ "pq_", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchEDIPerformanceReportVO();
				if (nt[i] != null)
					model.setNt(nt[i]);
				if (vat[i] != null)
					model.setVat(vat[i]);
				if (rln[i] != null)
					model.setRln(rln[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (missing[i] != null)
					model.setMissing(missing[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oan[i] != null)
					model.setOan(oan[i]);
				if (ediNo[i] != null)
					model.setEdiNo(ediNo[i]);
				if (avn[i] != null)
					model.setAvn(avn[i]);
				if (avl[i] != null)
					model.setAvl(avl[i]);
				if (vdl[i] != null)
					model.setVdl(vdl[i]);
				if (arn[i] != null)
					model.setArn(arn[i]);
				if (aln[i] != null)
					model.setAln(aln[i]);
				if (d[i] != null)
					model.setD(d[i]);
				if (ael[i] != null)
					model.setAel(ael[i]);
				if (mt[i] != null)
					model.setMt(mt[i]);
				if (uvd[i] != null)
					model.setUvd(uvd[i]);
				if (vdt[i] != null)
					model.setVdt(vdt[i]);
				if (in[i] != null)
					model.setIn(in[i]);
				if (io[i] != null)
					model.setIo(io[i]);
				if (ct[i] != null)
					model.setCt(ct[i]);
				if (urn[i] != null)
					model.setUrn(urn[i]);
				if (cr[i] != null)
					model.setCr(cr[i]);
				if (ee[i] != null)
					model.setEe(ee[i]);
				if (pa[i] != null)
					model.setPa(pa[i]);
				if (pn[i] != null)
					model.setPn(pn[i]);
				if (aet[i] != null)
					model.setAet(aet[i]);
				if (uvt[i] != null)
					model.setUvt(uvt[i]);
				if (vad[i] != null)
					model.setVad(vad[i]);
				if (pq[i] != null)
					model.setPq(pq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEDIPerformanceReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEDIPerformanceReportVO[]
	 */
	public SearchEDIPerformanceReportVO[] getSearchEDIPerformanceReportVOs(){
		SearchEDIPerformanceReportVO[] vos = (SearchEDIPerformanceReportVO[])models.toArray(new SearchEDIPerformanceReportVO[models.size()]);
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
		this.nt = this.nt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vat = this.vat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rln = this.rln .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.missing = this.missing .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oan = this.oan .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediNo = this.ediNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avn = this.avn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avl = this.avl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vdl = this.vdl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arn = this.arn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aln = this.aln .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d = this.d .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ael = this.ael .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mt = this.mt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uvd = this.uvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vdt = this.vdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.in = this.in .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.io = this.io .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ct = this.ct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.urn = this.urn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cr = this.cr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ee = this.ee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pa = this.pa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pn = this.pn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aet = this.aet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uvt = this.uvt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vad = this.vad .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pq = this.pq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

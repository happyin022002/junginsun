/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : MTYCNTRPERFInDetailVO.java
 *@FileTitle : MTYCNTRPERFInDetailVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.05.08
 *@LastModifier : Chang Young Kim
 *@LastVersion : 1.0
 * 2011.04.07 나상보
 * 1.0 Creation
* --------------------------------------------------------
* History
* 2011.11.21 신자영 [CHM-201114577-01] MVMT BY CY 기능 보완
* 2014.05.08 Chang Young Kim [CHM-201429600] fvvd 추가
=========================================================*/

package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo;

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
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object<br>
 *
 * @author 나상보
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MTYCNTRPERFInDetailVO extends AbstractValueObject { 

	private static final long serialVersionUID = 1L;
	
	private Collection<MTYCNTRPERFInDetailVO> models = new ArrayList<MTYCNTRPERFInDetailVO>();
	
	/* Column Info */
	private String yard = null;
	/* Column Info */
	private String por = null;
	/* Column Info */
	private String scRfaNoTaa = null;
	/* Column Info */
	private String preVvdCd = null;
	/* Column Info */
	private String pstVvdCd = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String disposal = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String postEventdate = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String imdtexit = null;
	/* Column Info */
	private String bkgno = null;
	/* Column Info */
	private String mvmt = null;
	/* Column Info */
	private String damage = null;
	/* Column Info */
	private String tvvd = null;
	/* Column Info */
	private String cntrno = null;
	/* Column Info */
	private String hngrrack = null;
	/* Column Info */
	private String hngrbarknt = null;
	/* Column Info */
	private String tpsz = null;
	/* Column Info */
	private String company = null;
	/* Column Info */
	private String cnee = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String eventdate = null;
	/* Column Info */
	private String autoflag = null;
	/* Column Info */
	private String shpr = null;
	/* Column Info */
	private String preEventdate = null;
	/* Column Info */
	private String rcvTerm = null;
	/* Column Info */
	private String deTerm = null;
	/*	Column Info	*/
	private String fvvd = null;
	/*	Column Info	*/
	private String vndrSeq = null;
	/*	Column Info	*/
	private String vndrAbbrNm = null;
	/*	Column Info	*/
	private String lsTmCd = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MTYCNTRPERFInDetailVO() {}

	public MTYCNTRPERFInDetailVO(String ibflag, String pagerows, String lane, String imdtexit, String yard, String bkgno, String damage, String mvmt, String cntrno, String tvvd, String hngrrack, String hngrbarknt, String tpsz, String disposal, String company, String pol, String seq, String eventdate, String autoflag, String pod, String por, String del, String preEventdate, String postEventdate, String scRfaNoTaa, String preVvdCd, String pstVvdCd, String shpr, String cnee, String rcvTerm, String deTerm, String fvvd, String vndrSeq, String vndrAbbrNm, String lsTmCd) {
		this.yard = yard;
		this.por = por;
		this.scRfaNoTaa = scRfaNoTaa;
		this.preVvdCd = preVvdCd;
		this.pstVvdCd = pstVvdCd;
		this.lane = lane;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.disposal = disposal;
		this.pol = pol;
		this.del = del;
		this.postEventdate = postEventdate;
		this.pod = pod;
		this.imdtexit = imdtexit;
		this.bkgno = bkgno;
		this.mvmt = mvmt;
		this.damage = damage;
		this.tvvd = tvvd;
		this.cntrno = cntrno;
		this.hngrrack = hngrrack;
		this.hngrbarknt = hngrbarknt;
		this.tpsz = tpsz;
		this.company = company;
		this.cnee = cnee;
		this.seq = seq;
		this.eventdate = eventdate;
		this.autoflag = autoflag;
		this.shpr = shpr;
		this.preEventdate = preEventdate;
		this.rcvTerm = rcvTerm;
		this.deTerm = deTerm;
		this.fvvd = fvvd;
		this.vndrSeq = vndrSeq;
		this.vndrAbbrNm = vndrAbbrNm;
		this.lsTmCd = lsTmCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("yard", getYard());
		this.hashColumns.put("por", getPor());
		this.hashColumns.put("sc_rfa_no_taa", getScRfaNoTaa());
		this.hashColumns.put("pre_vvd_cd", getPreVvdCd());
		this.hashColumns.put("pst_vvd_cd", getPstVvdCd());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("disposal", getDisposal());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("post_eventdate", getPostEventdate());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("imdtexit", getImdtexit());
		this.hashColumns.put("bkgno", getBkgno());
		this.hashColumns.put("mvmt", getMvmt());
		this.hashColumns.put("damage", getDamage());
		this.hashColumns.put("tvvd", getTvvd());
		this.hashColumns.put("cntrno", getCntrno());
		this.hashColumns.put("hngrrack", getHngrrack());
		this.hashColumns.put("hngrbarknt", getHngrbarknt());
		this.hashColumns.put("tpsz", getTpsz());
		this.hashColumns.put("company", getCompany());
		this.hashColumns.put("cnee", getCnee());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("eventdate", getEventdate());
		this.hashColumns.put("autoflag", getAutoflag());
		this.hashColumns.put("shpr", getShpr());
		this.hashColumns.put("pre_eventdate", getPreEventdate());
		this.hashColumns.put("rcvterm", getRcvTerm());
		this.hashColumns.put("determ", getDeTerm());
		this.hashColumns.put("fvvd", getFvvd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("lstm_cd", getLsTmCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("yard", "yard");
		this.hashFields.put("por", "por");
		this.hashFields.put("sc_rfa_no_taa", "scRfaNoTaa");
		this.hashFields.put("pre_vvd_cd", "preVvdCd");
		this.hashFields.put("pst_vvd_cd", "pstVvdCd");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("disposal", "disposal");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("del", "del");
		this.hashFields.put("post_eventdate", "postEventdate");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("imdtexit", "imdtexit");
		this.hashFields.put("bkgno", "bkgno");
		this.hashFields.put("mvmt", "mvmt");
		this.hashFields.put("damage", "damage");
		this.hashFields.put("tvvd", "tvvd");
		this.hashFields.put("cntrno", "cntrno");
		this.hashFields.put("hngrrack", "hngrrack");
		this.hashFields.put("hngrbarknt", "hngrbarknt");
		this.hashFields.put("tpsz", "tpsz");
		this.hashFields.put("company", "company");
		this.hashFields.put("cnee", "cnee");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("eventdate", "eventdate");
		this.hashFields.put("autoflag", "autoflag");
		this.hashFields.put("shpr", "shpr");
		this.hashFields.put("pre_eventdate", "preEventdate");
		this.hashFields.put("rcvterm", "rcvTerm");
		this.hashFields.put("determ", "deTerm");
		this.hashFields.put("fvvd", "fvvd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("lstm_cd", "lsTmCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return yard
	 */
	public String getYard() {
		return this.yard;
	}
	
	/**
	 * Column Info
	 * @return por
	 */
	public String getPor() {
		return this.por;
	}
	
	/**
	 * Column Info
	 * @return scRfaNoTaa
	 */
	public String getScRfaNoTaa() {
		return this.scRfaNoTaa;
	}
	
	/**
	 * Column Info
	 * @return preVvdCd
	 */
	public String getPreVvdCd() {
		return this.preVvdCd;
	}
	
	/**
	 * Column Info
	 * @return pstVvdCd
	 */
	public String getPstVvdCd() {
		return this.pstVvdCd;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return disposal
	 */
	public String getDisposal() {
		return this.disposal;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return del
	 */
	public String getDel() {
		return this.del;
	}
	
	/**
	 * Column Info
	 * @return postEventdate
	 */
	public String getPostEventdate() {
		return this.postEventdate;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return imdtexit
	 */
	public String getImdtexit() {
		return this.imdtexit;
	}
	
	/**
	 * Column Info
	 * @return bkgno
	 */
	public String getBkgno() {
		return this.bkgno;
	}
	
	/**
	 * Column Info
	 * @return mvmt
	 */
	public String getMvmt() {
		return this.mvmt;
	}
	
	/**
	 * Column Info
	 * @return damage
	 */
	public String getDamage() {
		return this.damage;
	}
	
	/**
	 * Column Info
	 * @return tvvd
	 */
	public String getTvvd() {
		return this.tvvd;
	}
	
	/**
	 * Column Info
	 * @return cntrno
	 */
	public String getCntrno() {
		return this.cntrno;
	}
	
	/**
	 * Column Info
	 * @return hngrrack
	 */
	public String getHngrrack() {
		return this.hngrrack;
	}

	/**
	 * Column Info
	 * @return hngrbarknt
	 */
	public String getHngrbarknt() {
		return this.hngrbarknt;
	}
	
	/**
	 * Column Info
	 * @return tpsz
	 */
	public String getTpsz() {
		return this.tpsz;
	}
	
	/**
	 * Column Info
	 * @return company
	 */
	public String getCompany() {
		return this.company;
	}
	
	/**
	 * Column Info
	 * @return cnee
	 */
	public String getCnee() {
		return this.cnee;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return eventdate
	 */
	public String getEventdate() {
		return this.eventdate;
	}
	
	/**
	 * Column Info
	 * @return autoflag
	 */
	public String getAutoflag() {
		return this.autoflag;
	}
	
	/**
	 * Column Info
	 * @return shpr
	 */
	public String getShpr() {
		return this.shpr;
	}
	
	/**
	 * Column Info
	 * @return preEventdate
	 */
	public String getPreEventdate() {
		return this.preEventdate;
	}
	
	/**
	 * Column Info
	 * @return rcvTerm
	 */
	public String getRcvTerm() {
		return this.rcvTerm;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}

	/**
	 * Column Info
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return lsTmCd
	 */
	public String getLsTmCd() {
		return this.lsTmCd;
	}
	
	/**
	 * Column Info
	 * @return deTerm
	 */
	public String getDeTerm() {
		return this.deTerm;
	}
	
	/**
	 * Column Info
	 * @param yard
	 */
	public void setYard(String yard) {
		this.yard = yard;
	}
	
	/**
	 * Column Info
	 * @param por
	 */
	public void setPor(String por) {
		this.por = por;
	}
	
	/**
	 * Column Info
	 * @param scRfaNoTaa
	 */
	public void setScRfaNoTaa(String scRfaNoTaa) {
		this.scRfaNoTaa = scRfaNoTaa;
	}
	
	/**
	 * Column Info
	 * @param preVvdCd
	 */
	public void setPreVvdCd(String preVvdCd) {
		this.preVvdCd = preVvdCd;
	}
	
	/**
	 * Column Info
	 * @param pstVvdCd
	 */
	public void setPstVvdCd(String pstVvdCd) {
		this.pstVvdCd = pstVvdCd;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param disposal
	 */
	public void setDisposal(String disposal) {
		this.disposal = disposal;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
	}
	
	/**
	 * Column Info
	 * @param postEventdate
	 */
	public void setPostEventdate(String postEventdate) {
		this.postEventdate = postEventdate;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param imdtexit
	 */
	public void setImdtexit(String imdtexit) {
		this.imdtexit = imdtexit;
	}
	
	/**
	 * Column Info
	 * @param bkgno
	 */
	public void setBkgno(String bkgno) {
		this.bkgno = bkgno;
	}
	
	/**
	 * Column Info
	 * @param mvmt
	 */
	public void setMvmt(String mvmt) {
		this.mvmt = mvmt;
	}
	
	/**
	 * Column Info
	 * @param damage
	 */
	public void setDamage(String damage) {
		this.damage = damage;
	}
	
	/**
	 * Column Info
	 * @param tvvd
	 */
	public void setTvvd(String tvvd) {
		this.tvvd = tvvd;
	}
	
	/**
	 * Column Info
	 * @param cntrno
	 */
	public void setCntrno(String cntrno) {
		this.cntrno = cntrno;
	}
	
	/**
	 * Column Info
	 * @param hngrrack
	 */
	public void setHngrrack(String hngrrack) {
		this.hngrrack = hngrrack;
	}

	/**
	 * Column Info
	 * @param hngrrack
	 */
	public void setHngrbarknt(String hngrbarknt) {
		this.hngrbarknt = hngrbarknt;
	}
	
	/**
	 * Column Info
	 * @param tpsz
	 */
	public void setTpsz(String tpsz) {
		this.tpsz = tpsz;
	}
	
	/**
	 * Column Info
	 * @param company
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	
	/**
	 * Column Info
	 * @param cnee
	 */
	public void setCnee(String cnee) {
		this.cnee = cnee;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param eventdate
	 */
	public void setEventdate(String eventdate) {
		this.eventdate = eventdate;
	}
	
	/**
	 * Column Info
	 * @param autoflag
	 */
	public void setAutoflag(String autoflag) {
		this.autoflag = autoflag;
	}
	
	/**
	 * Column Info
	 * @param shpr
	 */
	public void setShpr(String shpr) {
		this.shpr = shpr;
	}
	
	/**
	 * Column Info
	 * @param preEventdate
	 */
	public void setPreEventdate(String preEventdate) {
		this.preEventdate = preEventdate;
	}
	
	/**
	 * Column Info
	 * @param rcvTerm
	 */
	public void setRcvTerm(String rcvTerm) {
		this.rcvTerm = rcvTerm;
	}
	
	/**
	 * Column Info
	 * @param deTerm
	 */
	public void setDeTerm(String deTerm) {
		this.deTerm = deTerm;
	}
		
 	/**
	* Column Info
	* @param fvvd
	*/
	public void setFvvd(String fvvd) {
		this.fvvd = fvvd;
	}
 
	/**
	 * Column Info
	 * @return fvvd
	 */
	public String getFvvd() {
		return this.fvvd;
	}
	
 	/**
	* Column Info
	* @param vndrSeq
	*/
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
 	/**
	* Column Info
	* @param vndrAbbrNm
	*/
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}

 	/**
	* Column Info
	* @param lsTmCd
	*/
	public void setLsTmCd(String lsTmCd) {
		this.lsTmCd = lsTmCd;
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
		setYard(JSPUtil.getParameter(request, prefix + "yard", ""));
		setPor(JSPUtil.getParameter(request, prefix + "por", ""));
		setScRfaNoTaa(JSPUtil.getParameter(request, prefix + "sc_rfa_no_taa", ""));
		setPreVvdCd(JSPUtil.getParameter(request, prefix + "pre_vvd_cd", ""));
		setPstVvdCd(JSPUtil.getParameter(request, prefix + "pst_vvd_cd", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDisposal(JSPUtil.getParameter(request, prefix + "disposal", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setDel(JSPUtil.getParameter(request, prefix + "del", ""));
		setPostEventdate(JSPUtil.getParameter(request, prefix + "post_eventdate", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setImdtexit(JSPUtil.getParameter(request, prefix + "imdtexit", ""));
		setBkgno(JSPUtil.getParameter(request, prefix + "bkgno", ""));
		setMvmt(JSPUtil.getParameter(request, prefix + "mvmt", ""));
		setDamage(JSPUtil.getParameter(request, prefix + "damage", ""));
		setTvvd(JSPUtil.getParameter(request, prefix + "tvvd", ""));
		setCntrno(JSPUtil.getParameter(request, prefix + "cntrno", ""));
		setHngrrack(JSPUtil.getParameter(request, prefix + "hngrrack", ""));
		setHngrbarknt(JSPUtil.getParameter(request, prefix + "hngrbarknt", ""));
		setTpsz(JSPUtil.getParameter(request, prefix + "tpsz", ""));
		setCompany(JSPUtil.getParameter(request, prefix + "company", ""));
		setCnee(JSPUtil.getParameter(request, prefix + "cnee", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setEventdate(JSPUtil.getParameter(request, prefix + "eventdate", ""));
		setAutoflag(JSPUtil.getParameter(request, prefix + "autoflag", ""));
		setShpr(JSPUtil.getParameter(request, prefix + "shpr", ""));
		setPreEventdate(JSPUtil.getParameter(request, prefix + "pre_eventdate", ""));
		setRcvTerm(JSPUtil.getParameter(request, prefix + "rcvterm", ""));
		setDeTerm(JSPUtil.getParameter(request, prefix + "determ", ""));
		setFvvd(JSPUtil.getParameter(request, prefix + "fvvd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vnd_rseq", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, prefix + "vndr_abbr_nm", ""));
		setLsTmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MTYCNTRPERFInDetailVO[]
	 */
	public MTYCNTRPERFInDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MTYCNTRPERFInDetailVO[]
	 */
	public MTYCNTRPERFInDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MTYCNTRPERFInDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] yard = (JSPUtil.getParameter(request, prefix	+ "yard", length));
			String[] por = (JSPUtil.getParameter(request, prefix	+ "por", length));
			String[] scRfaNoTaa = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_no_taa", length));
			String[] preVvdCd = (JSPUtil.getParameter(request, prefix	+ "pre_vvd_cd", length));
			String[] pstVvdCd = (JSPUtil.getParameter(request, prefix	+ "pst_vvd_cd", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] disposal = (JSPUtil.getParameter(request, prefix	+ "disposal", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] postEventdate = (JSPUtil.getParameter(request, prefix	+ "post_eventdate", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] imdtexit = (JSPUtil.getParameter(request, prefix	+ "imdtexit", length));
			String[] bkgno = (JSPUtil.getParameter(request, prefix	+ "bkgno", length));
			String[] mvmt = (JSPUtil.getParameter(request, prefix	+ "mvmt", length));
			String[] damage = (JSPUtil.getParameter(request, prefix	+ "damage", length));
			String[] tvvd = (JSPUtil.getParameter(request, prefix	+ "tvvd", length));
			String[] cntrno = (JSPUtil.getParameter(request, prefix	+ "cntrno", length));
			String[] hngrrack = (JSPUtil.getParameter(request, prefix	+ "hngrrack", length));
			String[] hngrbarknt = (JSPUtil.getParameter(request, prefix	+ "hngrbarknt", length));
			String[] tpsz = (JSPUtil.getParameter(request, prefix	+ "tpsz", length));
			String[] company = (JSPUtil.getParameter(request, prefix	+ "company", length));
			String[] cnee = (JSPUtil.getParameter(request, prefix	+ "cnee", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] eventdate = (JSPUtil.getParameter(request, prefix	+ "eventdate", length));
			String[] autoflag = (JSPUtil.getParameter(request, prefix	+ "autoflag", length));
			String[] shpr = (JSPUtil.getParameter(request, prefix	+ "shpr", length));
			String[] preEventdate = (JSPUtil.getParameter(request, prefix	+ "pre_eventdate", length));
			String[] rcvTerm = (JSPUtil.getParameter(request, prefix	+ "rcvterm", length));
			String[] deTerm = (JSPUtil.getParameter(request, prefix	+ "determ", length));
			String[] fvvd = (JSPUtil.getParameter(request, prefix	+ "fvvd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] lsTmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			
			
			for (int i = 0; i < length; i++) {
				model = new MTYCNTRPERFInDetailVO();
				if (yard[i] != null)
					model.setYard(yard[i]);
				if (por[i] != null)
					model.setPor(por[i]);
				if (scRfaNoTaa[i] != null)
					model.setScRfaNoTaa(scRfaNoTaa[i]);
				if (preVvdCd[i] != null)
					model.setPreVvdCd(preVvdCd[i]);
				if (pstVvdCd[i] != null)
					model.setPstVvdCd(pstVvdCd[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (disposal[i] != null)
					model.setDisposal(disposal[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (postEventdate[i] != null)
					model.setPostEventdate(postEventdate[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (imdtexit[i] != null)
					model.setImdtexit(imdtexit[i]);
				if (bkgno[i] != null)
					model.setBkgno(bkgno[i]);
				if (mvmt[i] != null)
					model.setMvmt(mvmt[i]);
				if (damage[i] != null)
					model.setDamage(damage[i]);
				if (tvvd[i] != null)
					model.setTvvd(tvvd[i]);
				if (cntrno[i] != null)
					model.setCntrno(cntrno[i]);
				if (hngrrack[i] != null)
					model.setHngrrack(hngrrack[i]);
				if (hngrbarknt[i] != null)
					model.setHngrbarknt(hngrbarknt[i]);
				if (tpsz[i] != null)
					model.setTpsz(tpsz[i]);
				if (company[i] != null)
					model.setCompany(company[i]);
				if (cnee[i] != null)
					model.setCnee(cnee[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (eventdate[i] != null)
					model.setEventdate(eventdate[i]);
				if (autoflag[i] != null)
					model.setAutoflag(autoflag[i]);
				if (shpr[i] != null)
					model.setShpr(shpr[i]);
				if (preEventdate[i] != null)
					model.setPreEventdate(preEventdate[i]);
				if (rcvTerm[i] != null)
					model.setRcvTerm(rcvTerm[i]);
				if (deTerm[i] != null)
					model.setDeTerm(deTerm[i]);
				if ( fvvd[i] != null)
					model.setFvvd(fvvd[i]);
				if ( vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if ( vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);		
				if ( lsTmCd[i] != null)
					model.setLsTmCd(lsTmCd[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMTYCNTRPERFInDetailVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return MTYCNTRPERFInDetailVO[]
	 */
	public MTYCNTRPERFInDetailVO[]	 getMTYCNTRPERFInDetailVOs(){
		MTYCNTRPERFInDetailVO[] vos = (MTYCNTRPERFInDetailVO[])models.toArray(new	MTYCNTRPERFInDetailVO[models.size()]);
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
		this.yard = this.yard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por = this.por .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaNoTaa = this.scRfaNoTaa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preVvdCd = this.preVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstVvdCd = this.pstVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disposal = this.disposal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postEventdate = this.postEventdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdtexit = this.imdtexit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgno = this.bkgno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmt = this.mvmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.damage = this.damage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvvd = this.tvvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrno = this.cntrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrrack = this.hngrrack .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrbarknt = this.hngrbarknt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsz = this.tpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.company = this.company .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee = this.cnee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eventdate = this.eventdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoflag = this.autoflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr = this.shpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preEventdate = this.preEventdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTerm = this.rcvTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTerm = this.deTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fvvd = this.fvvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsTmCd = this.lsTmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

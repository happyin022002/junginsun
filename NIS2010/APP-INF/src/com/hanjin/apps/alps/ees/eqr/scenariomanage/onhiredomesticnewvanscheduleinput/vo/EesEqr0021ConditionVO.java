/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0021ConditionVO.java
*@FileTitle : EesEqr0021ConditionVO
*Open Issues :
*Change history :
* No.	Ver.		Modifier           			modifier date    explanation
* 1		1.0		Lee Byoung Hun		2009.08.06		1.0 최초 생성
*
*@LastModifyDate : 2009.08.06
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.08.06  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0021ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0021ConditionVO> models = new ArrayList<EesEqr0021ConditionVO>();
	
	/* Column Info */
	private String statusType = null;
	/* Column Info */
	private String toplnwk = null;
	/* Column Info */
	private String fmtypeby = null;
	/* Column Info */
	private String attypeby = null;
	/* Column Info */
	private String atfmplnmm = null;
	/* Column Info */
	private String cntrtpszcd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String scnrRmk = null;
	/* Column Info */
	private String fmecccd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String toplnyr = null;
	/* Column Info */
	private String fmplnmm = null;
	/* Column Info */
	private String attoplnmm = null;
	/* Column Info */
	private String scnrId = null;
	/* Column Info */
	private String atfmplnyr = null;
	/* Column Info */
	private String toecccd = null;
	/* Column Info */
	private String atecccd = null;
	/* Column Info */
	private String fmtype = null;
	/* Column Info */
	private String toplnmm = null;
	/* Column Info */
	private String yyyyww = null;
	/* Column Info */
	private String attype = null;
	/* Column Info */
	private String attoplnwk = null;
	/* Column Info */
	private String atfmplnwk = null;
	/* Column Info */
	private String fmplnyr = null;
	/* Column Info */
	private String attoplnyr = null;
	/* Column Info */
	private String fmtoat = null;
	/* Column Info */
	private String totype = null;
	/* Column Info */
	private String totypeby = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String fmplnwk = null;
	
	@SuppressWarnings("unchecked")
	private List month = null;
	
	@SuppressWarnings("unchecked")
	private List week = null;
	
	@SuppressWarnings("unchecked")
	private List monthWeekCnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0021ConditionVO() {}

	public EesEqr0021ConditionVO(String ibflag, String pagerows, String yyyyww, String seq, String statusType, String scnrId, String scnrRmk, String fmtoat, String fmtype, String fmecccd, String fmtypeby, String fmplnyr, String fmplnmm, String fmplnwk, String toplnyr, String toplnmm, String toplnwk, String totype, String toecccd, String totypeby, String attype, String atecccd, String attypeby, String atfmplnyr, String atfmplnmm, String atfmplnwk, String attoplnyr, String attoplnmm, String attoplnwk, String cntrtpszcd) {
		this.statusType = statusType;
		this.toplnwk = toplnwk;
		this.fmtypeby = fmtypeby;
		this.attypeby = attypeby;
		this.atfmplnmm = atfmplnmm;
		this.cntrtpszcd = cntrtpszcd;
		this.pagerows = pagerows;
		this.scnrRmk = scnrRmk;
		this.fmecccd = fmecccd;
		this.ibflag = ibflag;
		this.toplnyr = toplnyr;
		this.fmplnmm = fmplnmm;
		this.attoplnmm = attoplnmm;
		this.scnrId = scnrId;
		this.atfmplnyr = atfmplnyr;
		this.toecccd = toecccd;
		this.atecccd = atecccd;
		this.fmtype = fmtype;
		this.toplnmm = toplnmm;
		this.yyyyww = yyyyww;
		this.attype = attype;
		this.attoplnwk = attoplnwk;
		this.atfmplnwk = atfmplnwk;
		this.fmplnyr = fmplnyr;
		this.attoplnyr = attoplnyr;
		this.fmtoat = fmtoat;
		this.totype = totype;
		this.totypeby = totypeby;
		this.seq = seq;
		this.fmplnwk = fmplnwk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("status_type", getStatusType());
		this.hashColumns.put("toplnwk", getToplnwk());
		this.hashColumns.put("fmtypeby", getFmtypeby());
		this.hashColumns.put("attypeby", getAttypeby());
		this.hashColumns.put("atfmplnmm", getAtfmplnmm());
		this.hashColumns.put("cntrtpszcd", getCntrtpszcd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("scnr_rmk", getScnrRmk());
		this.hashColumns.put("fmecccd", getFmecccd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("toplnyr", getToplnyr());
		this.hashColumns.put("fmplnmm", getFmplnmm());
		this.hashColumns.put("attoplnmm", getAttoplnmm());
		this.hashColumns.put("scnr_id", getScnrId());
		this.hashColumns.put("atfmplnyr", getAtfmplnyr());
		this.hashColumns.put("toecccd", getToecccd());
		this.hashColumns.put("atecccd", getAtecccd());
		this.hashColumns.put("fmtype", getFmtype());
		this.hashColumns.put("toplnmm", getToplnmm());
		this.hashColumns.put("yyyyww", getYyyyww());
		this.hashColumns.put("attype", getAttype());
		this.hashColumns.put("attoplnwk", getAttoplnwk());
		this.hashColumns.put("atfmplnwk", getAtfmplnwk());
		this.hashColumns.put("fmplnyr", getFmplnyr());
		this.hashColumns.put("attoplnyr", getAttoplnyr());
		this.hashColumns.put("fmtoat", getFmtoat());
		this.hashColumns.put("totype", getTotype());
		this.hashColumns.put("totypeby", getTotypeby());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("fmplnwk", getFmplnwk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("status_type", "statusType");
		this.hashFields.put("toplnwk", "toplnwk");
		this.hashFields.put("fmtypeby", "fmtypeby");
		this.hashFields.put("attypeby", "attypeby");
		this.hashFields.put("atfmplnmm", "atfmplnmm");
		this.hashFields.put("cntrtpszcd", "cntrtpszcd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("scnr_rmk", "scnrRmk");
		this.hashFields.put("fmecccd", "fmecccd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("toplnyr", "toplnyr");
		this.hashFields.put("fmplnmm", "fmplnmm");
		this.hashFields.put("attoplnmm", "attoplnmm");
		this.hashFields.put("scnr_id", "scnrId");
		this.hashFields.put("atfmplnyr", "atfmplnyr");
		this.hashFields.put("toecccd", "toecccd");
		this.hashFields.put("atecccd", "atecccd");
		this.hashFields.put("fmtype", "fmtype");
		this.hashFields.put("toplnmm", "toplnmm");
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("attype", "attype");
		this.hashFields.put("attoplnwk", "attoplnwk");
		this.hashFields.put("atfmplnwk", "atfmplnwk");
		this.hashFields.put("fmplnyr", "fmplnyr");
		this.hashFields.put("attoplnyr", "attoplnyr");
		this.hashFields.put("fmtoat", "fmtoat");
		this.hashFields.put("totype", "totype");
		this.hashFields.put("totypeby", "totypeby");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("fmplnwk", "fmplnwk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return statusType
	 */
	public String getStatusType() {
		return this.statusType;
	}
	
	/**
	 * Column Info
	 * @return toplnwk
	 */
	public String getToplnwk() {
		return this.toplnwk;
	}
	
	/**
	 * Column Info
	 * @return fmtypeby
	 */
	public String getFmtypeby() {
		return this.fmtypeby;
	}
	
	/**
	 * Column Info
	 * @return attypeby
	 */
	public String getAttypeby() {
		return this.attypeby;
	}
	
	/**
	 * Column Info
	 * @return atfmplnmm
	 */
	public String getAtfmplnmm() {
		return this.atfmplnmm;
	}
	
	/**
	 * Column Info
	 * @return cntrtpszcd
	 */
	public String getCntrtpszcd() {
		return this.cntrtpszcd;
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
	 * @return scnrRmk
	 */
	public String getScnrRmk() {
		return this.scnrRmk;
	}
	
	/**
	 * Column Info
	 * @return fmecccd
	 */
	public String getFmecccd() {
		return this.fmecccd;
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
	 * @return toplnyr
	 */
	public String getToplnyr() {
		return this.toplnyr;
	}
	
	/**
	 * Column Info
	 * @return fmplnmm
	 */
	public String getFmplnmm() {
		return this.fmplnmm;
	}
	
	/**
	 * Column Info
	 * @return attoplnmm
	 */
	public String getAttoplnmm() {
		return this.attoplnmm;
	}
	
	/**
	 * Column Info
	 * @return scnrId
	 */
	public String getScnrId() {
		return this.scnrId;
	}
	
	/**
	 * Column Info
	 * @return atfmplnyr
	 */
	public String getAtfmplnyr() {
		return this.atfmplnyr;
	}
	
	/**
	 * Column Info
	 * @return toecccd
	 */
	public String getToecccd() {
		return this.toecccd;
	}
	
	/**
	 * Column Info
	 * @return atecccd
	 */
	public String getAtecccd() {
		return this.atecccd;
	}
	
	/**
	 * Column Info
	 * @return fmtype
	 */
	public String getFmtype() {
		return this.fmtype;
	}
	
	/**
	 * Column Info
	 * @return toplnmm
	 */
	public String getToplnmm() {
		return this.toplnmm;
	}
	
	/**
	 * Column Info
	 * @return yyyyww
	 */
	public String getYyyyww() {
		return this.yyyyww;
	}
	
	/**
	 * Column Info
	 * @return attype
	 */
	public String getAttype() {
		return this.attype;
	}
	
	/**
	 * Column Info
	 * @return attoplnwk
	 */
	public String getAttoplnwk() {
		return this.attoplnwk;
	}
	
	/**
	 * Column Info
	 * @return atfmplnwk
	 */
	public String getAtfmplnwk() {
		return this.atfmplnwk;
	}
	
	/**
	 * Column Info
	 * @return fmplnyr
	 */
	public String getFmplnyr() {
		return this.fmplnyr;
	}
	
	/**
	 * Column Info
	 * @return attoplnyr
	 */
	public String getAttoplnyr() {
		return this.attoplnyr;
	}
	
	/**
	 * Column Info
	 * @return fmtoat
	 */
	public String getFmtoat() {
		return this.fmtoat;
	}
	
	/**
	 * Column Info
	 * @return totype
	 */
	public String getTotype() {
		return this.totype;
	}
	
	/**
	 * Column Info
	 * @return totypeby
	 */
	public String getTotypeby() {
		return this.totypeby;
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
	 * @return fmplnwk
	 */
	public String getFmplnwk() {
		return this.fmplnwk;
	}
	

	/**
	 * Column Info
	 * @param statusType
	 */
	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}
	
	/**
	 * Column Info
	 * @param toplnwk
	 */
	public void setToplnwk(String toplnwk) {
		this.toplnwk = toplnwk;
	}
	
	/**
	 * Column Info
	 * @param fmtypeby
	 */
	public void setFmtypeby(String fmtypeby) {
		this.fmtypeby = fmtypeby;
	}
	
	/**
	 * Column Info
	 * @param attypeby
	 */
	public void setAttypeby(String attypeby) {
		this.attypeby = attypeby;
	}
	
	/**
	 * Column Info
	 * @param atfmplnmm
	 */
	public void setAtfmplnmm(String atfmplnmm) {
		this.atfmplnmm = atfmplnmm;
	}
	
	/**
	 * Column Info
	 * @param cntrtpszcd
	 */
	public void setCntrtpszcd(String cntrtpszcd) {
		this.cntrtpszcd = cntrtpszcd;
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
	 * @param scnrRmk
	 */
	public void setScnrRmk(String scnrRmk) {
		this.scnrRmk = scnrRmk;
	}
	
	/**
	 * Column Info
	 * @param fmecccd
	 */
	public void setFmecccd(String fmecccd) {
		this.fmecccd = fmecccd;
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
	 * @param toplnyr
	 */
	public void setToplnyr(String toplnyr) {
		this.toplnyr = toplnyr;
	}
	
	/**
	 * Column Info
	 * @param fmplnmm
	 */
	public void setFmplnmm(String fmplnmm) {
		this.fmplnmm = fmplnmm;
	}
	
	/**
	 * Column Info
	 * @param attoplnmm
	 */
	public void setAttoplnmm(String attoplnmm) {
		this.attoplnmm = attoplnmm;
	}
	
	/**
	 * Column Info
	 * @param scnrId
	 */
	public void setScnrId(String scnrId) {
		this.scnrId = scnrId;
	}
	
	/**
	 * Column Info
	 * @param atfmplnyr
	 */
	public void setAtfmplnyr(String atfmplnyr) {
		this.atfmplnyr = atfmplnyr;
	}
	
	/**
	 * Column Info
	 * @param toecccd
	 */
	public void setToecccd(String toecccd) {
		this.toecccd = toecccd;
	}
	
	/**
	 * Column Info
	 * @param atecccd
	 */
	public void setAtecccd(String atecccd) {
		this.atecccd = atecccd;
	}
	
	/**
	 * Column Info
	 * @param fmtype
	 */
	public void setFmtype(String fmtype) {
		this.fmtype = fmtype;
	}
	
	/**
	 * Column Info
	 * @param toplnmm
	 */
	public void setToplnmm(String toplnmm) {
		this.toplnmm = toplnmm;
	}
	
	/**
	 * Column Info
	 * @param yyyyww
	 */
	public void setYyyyww(String yyyyww) {
		this.yyyyww = yyyyww;
	}
	
	/**
	 * Column Info
	 * @param attype
	 */
	public void setAttype(String attype) {
		this.attype = attype;
	}
	
	/**
	 * Column Info
	 * @param attoplnwk
	 */
	public void setAttoplnwk(String attoplnwk) {
		this.attoplnwk = attoplnwk;
	}
	
	/**
	 * Column Info
	 * @param atfmplnwk
	 */
	public void setAtfmplnwk(String atfmplnwk) {
		this.atfmplnwk = atfmplnwk;
	}
	
	/**
	 * Column Info
	 * @param fmplnyr
	 */
	public void setFmplnyr(String fmplnyr) {
		this.fmplnyr = fmplnyr;
	}
	
	/**
	 * Column Info
	 * @param attoplnyr
	 */
	public void setAttoplnyr(String attoplnyr) {
		this.attoplnyr = attoplnyr;
	}
	
	/**
	 * Column Info
	 * @param fmtoat
	 */
	public void setFmtoat(String fmtoat) {
		this.fmtoat = fmtoat;
	}
	
	/**
	 * Column Info
	 * @param totype
	 */
	public void setTotype(String totype) {
		this.totype = totype;
	}
	
	/**
	 * Column Info
	 * @param totypeby
	 */
	public void setTotypeby(String totypeby) {
		this.totypeby = totypeby;
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
	 * @param fmplnwk
	 */
	public void setFmplnwk(String fmplnwk) {
		this.fmplnwk = fmplnwk;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setStatusType(JSPUtil.getParameter(request, "status_type", ""));
		setToplnwk(JSPUtil.getParameter(request, "toPlnWk", ""));
		setFmtypeby(JSPUtil.getParameter(request, "fmTypeBy", ""));
		setAttypeby(JSPUtil.getParameter(request, "atTypeBy", ""));
		setAtfmplnmm(JSPUtil.getParameter(request, "atFmPlnMm", ""));
		setCntrtpszcd(JSPUtil.getParameter(request, "cntrTpszCd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setScnrRmk(JSPUtil.getParameter(request, "scnr_rmk", ""));
		setFmecccd(JSPUtil.getParameter(request, "fmEccCd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setToplnyr(JSPUtil.getParameter(request, "toPlnYr", ""));
		setFmplnmm(JSPUtil.getParameter(request, "fmPlnMm", ""));
		setAttoplnmm(JSPUtil.getParameter(request, "atToPlnMm", ""));
		setScnrId(JSPUtil.getParameter(request, "scnr_id", ""));
		setAtfmplnyr(JSPUtil.getParameter(request, "atFmPlnYr", ""));
		setToecccd(JSPUtil.getParameter(request, "toEccCd", ""));
		setAtecccd(JSPUtil.getParameter(request, "atEccCd", ""));
		setFmtype(JSPUtil.getParameter(request, "fmType", ""));
		setToplnmm(JSPUtil.getParameter(request, "toPlnMm", ""));
		setYyyyww(JSPUtil.getParameter(request, "yyyyww", ""));
		setAttype(JSPUtil.getParameter(request, "atType", ""));
		setAttoplnwk(JSPUtil.getParameter(request, "atToPlnWk", ""));
		setAtfmplnwk(JSPUtil.getParameter(request, "atFmPlnWk", ""));
		setFmplnyr(JSPUtil.getParameter(request, "fmPlnYr", ""));
		setAttoplnyr(JSPUtil.getParameter(request, "atToPlnYr", ""));
		setFmtoat(JSPUtil.getParameter(request, "fmToAt", ""));
		setTotype(JSPUtil.getParameter(request, "toType", ""));
		setTotypeby(JSPUtil.getParameter(request, "toTypeBy", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setFmplnwk(JSPUtil.getParameter(request, "fmPlnWk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0021ConditionVO[]
	 */
	public EesEqr0021ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0021ConditionVO[]
	 */
	public EesEqr0021ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0021ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] statusType = (JSPUtil.getParameter(request, prefix	+ "status_type", length));
			String[] toplnwk = (JSPUtil.getParameter(request, prefix	+ "toplnwk", length));
			String[] fmtypeby = (JSPUtil.getParameter(request, prefix	+ "fmtypeby", length));
			String[] attypeby = (JSPUtil.getParameter(request, prefix	+ "attypeby", length));
			String[] atfmplnmm = (JSPUtil.getParameter(request, prefix	+ "atfmplnmm", length));
			String[] cntrtpszcd = (JSPUtil.getParameter(request, prefix	+ "cntrtpszcd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] scnrRmk = (JSPUtil.getParameter(request, prefix	+ "scnr_rmk", length));
			String[] fmecccd = (JSPUtil.getParameter(request, prefix	+ "fmecccd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] toplnyr = (JSPUtil.getParameter(request, prefix	+ "toplnyr", length));
			String[] fmplnmm = (JSPUtil.getParameter(request, prefix	+ "fmplnmm", length));
			String[] attoplnmm = (JSPUtil.getParameter(request, prefix	+ "attoplnmm", length));
			String[] scnrId = (JSPUtil.getParameter(request, prefix	+ "scnr_id", length));
			String[] atfmplnyr = (JSPUtil.getParameter(request, prefix	+ "atfmplnyr", length));
			String[] toecccd = (JSPUtil.getParameter(request, prefix	+ "toecccd", length));
			String[] atecccd = (JSPUtil.getParameter(request, prefix	+ "atecccd", length));
			String[] fmtype = (JSPUtil.getParameter(request, prefix	+ "fmtype", length));
			String[] toplnmm = (JSPUtil.getParameter(request, prefix	+ "toplnmm", length));
			String[] yyyyww = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] attype = (JSPUtil.getParameter(request, prefix	+ "attype", length));
			String[] attoplnwk = (JSPUtil.getParameter(request, prefix	+ "attoplnwk", length));
			String[] atfmplnwk = (JSPUtil.getParameter(request, prefix	+ "atfmplnwk", length));
			String[] fmplnyr = (JSPUtil.getParameter(request, prefix	+ "fmplnyr", length));
			String[] attoplnyr = (JSPUtil.getParameter(request, prefix	+ "attoplnyr", length));
			String[] fmtoat = (JSPUtil.getParameter(request, prefix	+ "fmtoat", length));
			String[] totype = (JSPUtil.getParameter(request, prefix	+ "totype", length));
			String[] totypeby = (JSPUtil.getParameter(request, prefix	+ "totypeby", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] fmplnwk = (JSPUtil.getParameter(request, prefix	+ "fmplnwk", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0021ConditionVO();
				if (statusType[i] != null)
					model.setStatusType(statusType[i]);
				if (toplnwk[i] != null)
					model.setToplnwk(toplnwk[i]);
				if (fmtypeby[i] != null)
					model.setFmtypeby(fmtypeby[i]);
				if (attypeby[i] != null)
					model.setAttypeby(attypeby[i]);
				if (atfmplnmm[i] != null)
					model.setAtfmplnmm(atfmplnmm[i]);
				if (cntrtpszcd[i] != null)
					model.setCntrtpszcd(cntrtpszcd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (scnrRmk[i] != null)
					model.setScnrRmk(scnrRmk[i]);
				if (fmecccd[i] != null)
					model.setFmecccd(fmecccd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (toplnyr[i] != null)
					model.setToplnyr(toplnyr[i]);
				if (fmplnmm[i] != null)
					model.setFmplnmm(fmplnmm[i]);
				if (attoplnmm[i] != null)
					model.setAttoplnmm(attoplnmm[i]);
				if (scnrId[i] != null)
					model.setScnrId(scnrId[i]);
				if (atfmplnyr[i] != null)
					model.setAtfmplnyr(atfmplnyr[i]);
				if (toecccd[i] != null)
					model.setToecccd(toecccd[i]);
				if (atecccd[i] != null)
					model.setAtecccd(atecccd[i]);
				if (fmtype[i] != null)
					model.setFmtype(fmtype[i]);
				if (toplnmm[i] != null)
					model.setToplnmm(toplnmm[i]);
				if (yyyyww[i] != null)
					model.setYyyyww(yyyyww[i]);
				if (attype[i] != null)
					model.setAttype(attype[i]);
				if (attoplnwk[i] != null)
					model.setAttoplnwk(attoplnwk[i]);
				if (atfmplnwk[i] != null)
					model.setAtfmplnwk(atfmplnwk[i]);
				if (fmplnyr[i] != null)
					model.setFmplnyr(fmplnyr[i]);
				if (attoplnyr[i] != null)
					model.setAttoplnyr(attoplnyr[i]);
				if (fmtoat[i] != null)
					model.setFmtoat(fmtoat[i]);
				if (totype[i] != null)
					model.setTotype(totype[i]);
				if (totypeby[i] != null)
					model.setTotypeby(totypeby[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (fmplnwk[i] != null)
					model.setFmplnwk(fmplnwk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0021ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0021ConditionVO[]
	 */
	public EesEqr0021ConditionVO[] getEesEqr0021ConditionVOs(){
		EesEqr0021ConditionVO[] vos = (EesEqr0021ConditionVO[])models.toArray(new EesEqr0021ConditionVO[models.size()]);
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
		this.statusType = this.statusType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toplnwk = this.toplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtypeby = this.fmtypeby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attypeby = this.attypeby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atfmplnmm = this.atfmplnmm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtpszcd = this.cntrtpszcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrRmk = this.scnrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmecccd = this.fmecccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toplnyr = this.toplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmplnmm = this.fmplnmm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attoplnmm = this.attoplnmm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrId = this.scnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atfmplnyr = this.atfmplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toecccd = this.toecccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atecccd = this.atecccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtype = this.fmtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toplnmm = this.toplnmm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww = this.yyyyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attype = this.attype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attoplnwk = this.attoplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atfmplnwk = this.atfmplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmplnyr = this.fmplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attoplnyr = this.attoplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtoat = this.fmtoat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totype = this.totype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totypeby = this.totypeby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmplnwk = this.fmplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	/**
	 * @return the month
	 */
	@SuppressWarnings("unchecked")
	public List getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	@SuppressWarnings("unchecked")
	public void setMonth(List month) {
		this.month = month;
	}

	/**
	 * @return the week
	 */
	@SuppressWarnings("unchecked")
	public List getWeek() {
		return week;
	}

	/**
	 * @param week the week to set
	 */
	@SuppressWarnings("unchecked")
	public void setWeek(List week) {
		this.week = week;
	}

	/**
	 * @return the monthWeekCnt
	 */
	@SuppressWarnings("unchecked")
	public List getMonthWeekCnt() {
		return monthWeekCnt;
	}

	/**
	 * @param monthWeekCnt the monthWeekCnt to set
	 */
	@SuppressWarnings("unchecked")
	public void setMonthWeekCnt(List monthWeekCnt) {
		this.monthWeekCnt = monthWeekCnt;
	}
}

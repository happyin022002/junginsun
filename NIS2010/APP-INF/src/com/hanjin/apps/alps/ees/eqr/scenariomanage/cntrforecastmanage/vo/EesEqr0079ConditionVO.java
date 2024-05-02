/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0079ConditionVO.java
*@FileTitle : EesEqr0079ConditionVO
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Lee Byoung Hun	2009.08.07		1.0 최초 생성
*
*@LastModifyDate : 2009.08.07
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.08.07  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0079ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0079ConditionVO> models = new ArrayList<EesEqr0079ConditionVO>();
	
	/* Column Info */
	private String statusType = null;
	/* Column Info */
	private String fmsfcastyr = null;
	/* Column Info */
	private String cocd = null;
	/* Column Info */
	private String fmtypeby = null;
	/* Column Info */
	private String attypeby = null;
	/* Column Info */
	private String cntrtpszcd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fmecccd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String atefcastwk = null;
	/* Column Info */
	private String fmsfcastwk = null;
	/* Column Info */
	private String atefcastyr = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String fmefcastyr = null;
	/* Column Info */
	private String toecccd = null;
	/* Column Info */
	private String atecccd = null;
	/* Column Info */
	private String fmefcastwk = null;
	/* Column Info */
	private String fmtype = null;
	/* Column Info */
	private String yyyyww = null;
	/* Column Info */
	private String attype = null;
	/* Column Info */
	private String atsfcastyr = null;
	/* Column Info */
	private String atsfcastwk = null;
	/* Column Info */
	private String totype = null;
	/* Column Info */
	private String fmtoat = null;
	/* Column Info */
	private String totypeby = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String day = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0079ConditionVO() {}

	public EesEqr0079ConditionVO(String ibflag, String pagerows, String yyyyww, String seq, String fmtoat, String fmtype, String fmecccd, String fmtypeby, String fmsfcastyr, String fmsfcastwk, String fmefcastyr, String fmefcastwk, String totype, String toecccd, String totypeby, String attype, String atecccd, String attypeby, String atsfcastyr, String atsfcastwk, String atefcastyr, String atefcastwk, String cntrtpszcd, String cocd, String day, String status, String statusType) {
		this.statusType = statusType;
		this.fmsfcastyr = fmsfcastyr;
		this.cocd = cocd;
		this.fmtypeby = fmtypeby;
		this.attypeby = attypeby;
		this.cntrtpszcd = cntrtpszcd;
		this.pagerows = pagerows;
		this.fmecccd = fmecccd;
		this.ibflag = ibflag;
		this.atefcastwk = atefcastwk;
		this.fmsfcastwk = fmsfcastwk;
		this.atefcastyr = atefcastyr;
		this.status = status;
		this.fmefcastyr = fmefcastyr;
		this.toecccd = toecccd;
		this.atecccd = atecccd;
		this.fmefcastwk = fmefcastwk;
		this.fmtype = fmtype;
		this.yyyyww = yyyyww;
		this.attype = attype;
		this.atsfcastyr = atsfcastyr;
		this.atsfcastwk = atsfcastwk;
		this.totype = totype;
		this.fmtoat = fmtoat;
		this.totypeby = totypeby;
		this.seq = seq;
		this.day = day;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("status_type", getStatusType());
		this.hashColumns.put("fmSFcastYr", getFmsfcastyr());
		this.hashColumns.put("coCd", getCocd());
		this.hashColumns.put("fmTypeBy", getFmtypeby());
		this.hashColumns.put("atTypeBy", getAttypeby());
		this.hashColumns.put("cntrTpszCd", getCntrtpszcd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fmEccCd", getFmecccd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("atEFcastWk", getAtefcastwk());
		this.hashColumns.put("fmSFcastWk", getFmsfcastwk());
		this.hashColumns.put("atEFcastYr", getAtefcastyr());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("fmEFcastYr", getFmefcastyr());
		this.hashColumns.put("toEccCd", getToecccd());
		this.hashColumns.put("atEccCd", getAtecccd());
		this.hashColumns.put("fmEFcastWk", getFmefcastwk());
		this.hashColumns.put("fmType", getFmtype());
		this.hashColumns.put("yyyyww", getYyyyww());
		this.hashColumns.put("atType", getAttype());
		this.hashColumns.put("atSFcastYr", getAtsfcastyr());
		this.hashColumns.put("atSFcastWk", getAtsfcastwk());
		this.hashColumns.put("toType", getTotype());
		this.hashColumns.put("fmToAt", getFmtoat());
		this.hashColumns.put("toTypeBy", getTotypeby());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("day", getDay());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("status_type", "statusType");
		this.hashFields.put("fmsfcastyr", "fmsfcastyr");
		this.hashFields.put("cocd", "cocd");
		this.hashFields.put("fmtypeby", "fmtypeby");
		this.hashFields.put("attypeby", "attypeby");
		this.hashFields.put("cntrtpszcd", "cntrtpszcd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fmecccd", "fmecccd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("atefcastwk", "atefcastwk");
		this.hashFields.put("fmsfcastwk", "fmsfcastwk");
		this.hashFields.put("atefcastyr", "atefcastyr");
		this.hashFields.put("status", "status");
		this.hashFields.put("fmefcastyr", "fmefcastyr");
		this.hashFields.put("toecccd", "toecccd");
		this.hashFields.put("atecccd", "atecccd");
		this.hashFields.put("fmefcastwk", "fmefcastwk");
		this.hashFields.put("fmtype", "fmtype");
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("attype", "attype");
		this.hashFields.put("atsfcastyr", "atsfcastyr");
		this.hashFields.put("atsfcastwk", "atsfcastwk");
		this.hashFields.put("totype", "totype");
		this.hashFields.put("fmtoat", "fmtoat");
		this.hashFields.put("totypeby", "totypeby");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("day", "day");
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
	 * @return fmsfcastyr
	 */
	public String getFmsfcastyr() {
		return this.fmsfcastyr;
	}
	
	/**
	 * Column Info
	 * @return cocd
	 */
	public String getCocd() {
		return this.cocd;
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
	 * @return atefcastwk
	 */
	public String getAtefcastwk() {
		return this.atefcastwk;
	}
	
	/**
	 * Column Info
	 * @return fmsfcastwk
	 */
	public String getFmsfcastwk() {
		return this.fmsfcastwk;
	}
	
	/**
	 * Column Info
	 * @return atefcastyr
	 */
	public String getAtefcastyr() {
		return this.atefcastyr;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return fmefcastyr
	 */
	public String getFmefcastyr() {
		return this.fmefcastyr;
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
	 * @return fmefcastwk
	 */
	public String getFmefcastwk() {
		return this.fmefcastwk;
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
	 * @return atsfcastyr
	 */
	public String getAtsfcastyr() {
		return this.atsfcastyr;
	}
	
	/**
	 * Column Info
	 * @return atsfcastwk
	 */
	public String getAtsfcastwk() {
		return this.atsfcastwk;
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
	 * @return fmtoat
	 */
	public String getFmtoat() {
		return this.fmtoat;
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
	 * @return day
	 */
	public String getDay() {
		return this.day;
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
	 * @param fmsfcastyr
	 */
	public void setFmsfcastyr(String fmsfcastyr) {
		this.fmsfcastyr = fmsfcastyr;
	}
	
	/**
	 * Column Info
	 * @param cocd
	 */
	public void setCocd(String cocd) {
		this.cocd = cocd;
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
	 * @param atefcastwk
	 */
	public void setAtefcastwk(String atefcastwk) {
		this.atefcastwk = atefcastwk;
	}
	
	/**
	 * Column Info
	 * @param fmsfcastwk
	 */
	public void setFmsfcastwk(String fmsfcastwk) {
		this.fmsfcastwk = fmsfcastwk;
	}
	
	/**
	 * Column Info
	 * @param atefcastyr
	 */
	public void setAtefcastyr(String atefcastyr) {
		this.atefcastyr = atefcastyr;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param fmefcastyr
	 */
	public void setFmefcastyr(String fmefcastyr) {
		this.fmefcastyr = fmefcastyr;
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
	 * @param fmefcastwk
	 */
	public void setFmefcastwk(String fmefcastwk) {
		this.fmefcastwk = fmefcastwk;
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
	 * @param atsfcastyr
	 */
	public void setAtsfcastyr(String atsfcastyr) {
		this.atsfcastyr = atsfcastyr;
	}
	
	/**
	 * Column Info
	 * @param atsfcastwk
	 */
	public void setAtsfcastwk(String atsfcastwk) {
		this.atsfcastwk = atsfcastwk;
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
	 * @param fmtoat
	 */
	public void setFmtoat(String fmtoat) {
		this.fmtoat = fmtoat;
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
	 * @param day
	 */
	public void setDay(String day) {
		this.day = day;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setStatusType(JSPUtil.getParameter(request, "status_type", ""));
		setFmsfcastyr(JSPUtil.getParameter(request, "fmSFcastYr", ""));
		setCocd(JSPUtil.getParameter(request, "coCd", ""));
		setFmtypeby(JSPUtil.getParameter(request, "fmTypeBy", ""));
		setAttypeby(JSPUtil.getParameter(request, "atTypeBy", ""));
		setCntrtpszcd(JSPUtil.getParameter(request, "cntrTpszCd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFmecccd(JSPUtil.getParameter(request, "fmEccCd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAtefcastwk(JSPUtil.getParameter(request, "atEFcastWk", ""));
		setFmsfcastwk(JSPUtil.getParameter(request, "fmSFcastWk", ""));
		setAtefcastyr(JSPUtil.getParameter(request, "atEFcastYr", ""));
		setStatus(JSPUtil.getParameter(request, "status", ""));
		setFmefcastyr(JSPUtil.getParameter(request, "fmEFcastYr", ""));
		setToecccd(JSPUtil.getParameter(request, "toEccCd", ""));
		setAtecccd(JSPUtil.getParameter(request, "atEccCd", ""));
		setFmefcastwk(JSPUtil.getParameter(request, "fmEFcastWk", ""));
		setFmtype(JSPUtil.getParameter(request, "fmType", ""));
		setYyyyww(JSPUtil.getParameter(request, "yyyyww", ""));
		setAttype(JSPUtil.getParameter(request, "atType", ""));
		setAtsfcastyr(JSPUtil.getParameter(request, "atSFcastYr", ""));
		setAtsfcastwk(JSPUtil.getParameter(request, "atSFcastWk", ""));
		setTotype(JSPUtil.getParameter(request, "toType", ""));
		setFmtoat(JSPUtil.getParameter(request, "fmToAt", ""));
		setTotypeby(JSPUtil.getParameter(request, "toTypeBy", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setDay(JSPUtil.getParameter(request, "day", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0079ConditionVO[]
	 */
	public EesEqr0079ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0079ConditionVO[]
	 */
	public EesEqr0079ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0079ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] statusType = (JSPUtil.getParameter(request, prefix	+ "status_type", length));
			String[] fmsfcastyr = (JSPUtil.getParameter(request, prefix	+ "fmsfcastyr", length));
			String[] cocd = (JSPUtil.getParameter(request, prefix	+ "cocd", length));
			String[] fmtypeby = (JSPUtil.getParameter(request, prefix	+ "fmtypeby", length));
			String[] attypeby = (JSPUtil.getParameter(request, prefix	+ "attypeby", length));
			String[] cntrtpszcd = (JSPUtil.getParameter(request, prefix	+ "cntrtpszcd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fmecccd = (JSPUtil.getParameter(request, prefix	+ "fmecccd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] atefcastwk = (JSPUtil.getParameter(request, prefix	+ "atefcastwk", length));
			String[] fmsfcastwk = (JSPUtil.getParameter(request, prefix	+ "fmsfcastwk", length));
			String[] atefcastyr = (JSPUtil.getParameter(request, prefix	+ "atefcastyr", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] fmefcastyr = (JSPUtil.getParameter(request, prefix	+ "fmefcastyr", length));
			String[] toecccd = (JSPUtil.getParameter(request, prefix	+ "toecccd", length));
			String[] atecccd = (JSPUtil.getParameter(request, prefix	+ "atecccd", length));
			String[] fmefcastwk = (JSPUtil.getParameter(request, prefix	+ "fmefcastwk", length));
			String[] fmtype = (JSPUtil.getParameter(request, prefix	+ "fmtype", length));
			String[] yyyyww = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] attype = (JSPUtil.getParameter(request, prefix	+ "attype", length));
			String[] atsfcastyr = (JSPUtil.getParameter(request, prefix	+ "atsfcastyr", length));
			String[] atsfcastwk = (JSPUtil.getParameter(request, prefix	+ "atsfcastwk", length));
			String[] totype = (JSPUtil.getParameter(request, prefix	+ "totype", length));
			String[] fmtoat = (JSPUtil.getParameter(request, prefix	+ "fmtoat", length));
			String[] totypeby = (JSPUtil.getParameter(request, prefix	+ "totypeby", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] day = (JSPUtil.getParameter(request, prefix	+ "day", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0079ConditionVO();
				if (statusType[i] != null)
					model.setStatusType(statusType[i]);
				if (fmsfcastyr[i] != null)
					model.setFmsfcastyr(fmsfcastyr[i]);
				if (cocd[i] != null)
					model.setCocd(cocd[i]);
				if (fmtypeby[i] != null)
					model.setFmtypeby(fmtypeby[i]);
				if (attypeby[i] != null)
					model.setAttypeby(attypeby[i]);
				if (cntrtpszcd[i] != null)
					model.setCntrtpszcd(cntrtpszcd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fmecccd[i] != null)
					model.setFmecccd(fmecccd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (atefcastwk[i] != null)
					model.setAtefcastwk(atefcastwk[i]);
				if (fmsfcastwk[i] != null)
					model.setFmsfcastwk(fmsfcastwk[i]);
				if (atefcastyr[i] != null)
					model.setAtefcastyr(atefcastyr[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (fmefcastyr[i] != null)
					model.setFmefcastyr(fmefcastyr[i]);
				if (toecccd[i] != null)
					model.setToecccd(toecccd[i]);
				if (atecccd[i] != null)
					model.setAtecccd(atecccd[i]);
				if (fmefcastwk[i] != null)
					model.setFmefcastwk(fmefcastwk[i]);
				if (fmtype[i] != null)
					model.setFmtype(fmtype[i]);
				if (yyyyww[i] != null)
					model.setYyyyww(yyyyww[i]);
				if (attype[i] != null)
					model.setAttype(attype[i]);
				if (atsfcastyr[i] != null)
					model.setAtsfcastyr(atsfcastyr[i]);
				if (atsfcastwk[i] != null)
					model.setAtsfcastwk(atsfcastwk[i]);
				if (totype[i] != null)
					model.setTotype(totype[i]);
				if (fmtoat[i] != null)
					model.setFmtoat(fmtoat[i]);
				if (totypeby[i] != null)
					model.setTotypeby(totypeby[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (day[i] != null)
					model.setDay(day[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0079ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0079ConditionVO[]
	 */
	public EesEqr0079ConditionVO[] getEesEqr0079ConditionVOs(){
		EesEqr0079ConditionVO[] vos = (EesEqr0079ConditionVO[])models.toArray(new EesEqr0079ConditionVO[models.size()]);
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
		this.fmsfcastyr = this.fmsfcastyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cocd = this.cocd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtypeby = this.fmtypeby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attypeby = this.attypeby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtpszcd = this.cntrtpszcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmecccd = this.fmecccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atefcastwk = this.atefcastwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmsfcastwk = this.fmsfcastwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atefcastyr = this.atefcastyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmefcastyr = this.fmefcastyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toecccd = this.toecccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atecccd = this.atecccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmefcastwk = this.fmefcastwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtype = this.fmtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww = this.yyyyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attype = this.attype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atsfcastyr = this.atsfcastyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atsfcastwk = this.atsfcastwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totype = this.totype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtoat = this.fmtoat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totypeby = this.totypeby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.day = this.day .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

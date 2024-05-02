/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0072ConditionVO.java
*@FileTitle : Forecasted M/B
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.10.07 정은호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.apps.alps.ees.eqr.common.Constants;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정은호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0072ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0072ConditionVO> models = new ArrayList<EesEqr0072ConditionVO>();
	
	/* Column Info */
	private String ts = null;
	/* Column Info */
	private String trade = null;
	/* Column Info */
	private String bylocation = null;
	/* Column Info */
	private String toplnwk = null;
	/* Column Info */
	private String plnYrwk = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String yyyyww = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmplnyr = null;
	/* Column Info */
	private String atstatus = null;
	/* Column Info */
	private String company = null;
	/* Column Info */
	private String toplnyr = null;
	/* Column Info */
	private String report = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String locortrade = null;
	/* Column Info */
	private String atlocation = null;
	/* Column Info */
	private String repoplanid = null;
	/* Column Info */
	private String fmplnwk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0072ConditionVO() {}

	public EesEqr0072ConditionVO(String ibflag, String pagerows, String report, String company, String locortrade, String yyyyww, String seq, String repoplanid, String fmplnyr, String fmplnwk, String toplnyr, String toplnwk, String atstatus, String atlocation, String bylocation, String trade, String ts, String lane, String vvd, String plnYrwk) {
		this.ts = ts;
		this.trade = trade;
		this.bylocation = bylocation;
		this.toplnwk = toplnwk;
		this.plnYrwk = plnYrwk;
		this.lane = lane;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.yyyyww = yyyyww;
		this.ibflag = ibflag;
		this.fmplnyr = fmplnyr;
		this.atstatus = atstatus;
		this.company = company;
		this.toplnyr = toplnyr;
		this.report = report;
		this.seq = seq;
		this.locortrade = locortrade;
		this.atlocation = atlocation;
		this.repoplanid = repoplanid;
		this.fmplnwk = fmplnwk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ts", getTs());
		this.hashColumns.put("trade", getTrade());
		this.hashColumns.put("bylocation", getBylocation());
		this.hashColumns.put("toplnwk", getToplnwk());
		this.hashColumns.put("pln_yrwk", getPlnYrwk());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("yyyyww", getYyyyww());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fmplnyr", getFmplnyr());
		this.hashColumns.put("atstatus", getAtstatus());
		this.hashColumns.put("company", getCompany());
		this.hashColumns.put("toplnyr", getToplnyr());
		this.hashColumns.put("report", getReport());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("locortrade", getLocortrade());
		this.hashColumns.put("atlocation", getAtlocation());
		this.hashColumns.put("repoplanid", getRepoplanid());
		this.hashColumns.put("fmplnwk", getFmplnwk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ts", "ts");
		this.hashFields.put("trade", "trade");
		this.hashFields.put("bylocation", "bylocation");
		this.hashFields.put("toplnwk", "toplnwk");
		this.hashFields.put("pln_yrwk", "plnYrwk");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fmplnyr", "fmplnyr");
		this.hashFields.put("atstatus", "atstatus");
		this.hashFields.put("company", "company");
		this.hashFields.put("toplnyr", "toplnyr");
		this.hashFields.put("report", "report");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("locortrade", "locortrade");
		this.hashFields.put("atlocation", "atlocation");
		this.hashFields.put("repoplanid", "repoplanid");
		this.hashFields.put("fmplnwk", "fmplnwk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ts
	 */
	public String getTs() {
		return this.ts;
	}
	
	/**
	 * Column Info
	 * @return trade
	 */
	public String getTrade() {
		return this.trade;
	}
	
	/**
	 * Column Info
	 * @return bylocation
	 */
	public String getBylocation() {
		return this.bylocation;
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
	 * @return plnYrwk
	 */
	public String getPlnYrwk() {
		return this.plnYrwk;
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
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return yyyyww
	 */
	public String getYyyyww() {
		return this.yyyyww;
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
	 * @return fmplnyr
	 */
	public String getFmplnyr() {
		return this.fmplnyr;
	}
	
	/**
	 * Column Info
	 * @return atstatus
	 */
	public String getAtstatus() {
		return this.atstatus;
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
	 * @return toplnyr
	 */
	public String getToplnyr() {
		return this.toplnyr;
	}
	
	/**
	 * Column Info
	 * @return report
	 */
	public String getReport() {
		return this.report;
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
	 * @return locortrade
	 */
	public String getLocortrade() {
		return this.locortrade;
	}
	
	/**
	 * Column Info
	 * @return atlocation
	 */
	public String getAtlocation() {
		return this.atlocation;
	}
	
	/**
	 * Column Info
	 * @return repoplanid
	 */
	public String getRepoplanid() {
		return this.repoplanid;
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
	 * @param ts
	 */
	public void setTs(String ts) {
		this.ts = ts;
	}
	
	/**
	 * Column Info
	 * @param trade
	 */
	public void setTrade(String trade) {
		this.trade = trade;
	}
	
	/**
	 * Column Info
	 * @param bylocation
	 */
	public void setBylocation(String bylocation) {
		this.bylocation = bylocation;
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
	 * @param plnYrwk
	 */
	public void setPlnYrwk(String plnYrwk) {
		this.plnYrwk = plnYrwk;
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
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param yyyyww
	 */
	public void setYyyyww(String yyyyww) {
		this.yyyyww = yyyyww;
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
	 * @param fmplnyr
	 */
	public void setFmplnyr(String fmplnyr) {
		this.fmplnyr = fmplnyr;
	}
	
	/**
	 * Column Info
	 * @param atstatus
	 */
	public void setAtstatus(String atstatus) {
		this.atstatus = atstatus;
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
	 * @param toplnyr
	 */
	public void setToplnyr(String toplnyr) {
		this.toplnyr = toplnyr;
	}
	
	/**
	 * Column Info
	 * @param report
	 */
	public void setReport(String report) {
		this.report = report;
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
	 * @param locortrade
	 */
	public void setLocortrade(String locortrade) {
		this.locortrade = locortrade;
	}
	
	/**
	 * Column Info
	 * @param atlocation
	 */
	public void setAtlocation(String atlocation) {
		this.atlocation = atlocation;
	}
	
	/**
	 * Column Info
	 * @param repoplanid
	 */
	public void setRepoplanid(String repoplanid) {
		this.repoplanid = repoplanid;
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
		setTs(JSPUtil.getParameter(request, "ts", ""));
		setTrade(JSPUtil.getParameter(request, "trade", ""));
		setBylocation(JSPUtil.getParameter(request, "typeBy_1", ""));
		setToplnwk(JSPUtil.getParameter(request, "perfToPlnWk", ""));
		setPlnYrwk(JSPUtil.getParameter(request, "pln_yrwk", ""));
		setLane(JSPUtil.getParameter(request, "vslSlanCd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setYyyyww(JSPUtil.getParameter(request, "yyyyww", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFmplnyr(JSPUtil.getParameter(request, "perfFmPlnYr", ""));
		setAtstatus(JSPUtil.getParameter(request, "type_1", ""));
		setCompany(JSPUtil.getParameter(request, "company", ""));
		setToplnyr(JSPUtil.getParameter(request, "perfToPlnYr", ""));
		setReport(JSPUtil.getParameter(request, "report", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setLocortrade(JSPUtil.getParameter(request, "locOrTrade", ""));
		setAtlocation(JSPUtil.getParameter(request, "eccCd_1", ""));
		//setRepoplanid(JSPUtil.getParameter(request, "repoplanid", ""));
		setRepoplanid(Constants.REPO_WORD + yyyyww + Constants.SCNR_WEEK + this.seq);
		setFmplnwk(JSPUtil.getParameter(request, "perfFmPlnWk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0072ConditionVO[]
	 */
	public EesEqr0072ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0072ConditionVO[]
	 */
	public EesEqr0072ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0072ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ts = (JSPUtil.getParameter(request, prefix	+ "ts", length));
			String[] trade = (JSPUtil.getParameter(request, prefix	+ "trade", length));
			String[] bylocation = (JSPUtil.getParameter(request, prefix	+ "bylocation", length));
			String[] toplnwk = (JSPUtil.getParameter(request, prefix	+ "toplnwk", length));
			String[] plnYrwk = (JSPUtil.getParameter(request, prefix	+ "pln_yrwk", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] yyyyww = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmplnyr = (JSPUtil.getParameter(request, prefix	+ "fmplnyr", length));
			String[] atstatus = (JSPUtil.getParameter(request, prefix	+ "atstatus", length));
			String[] company = (JSPUtil.getParameter(request, prefix	+ "company", length));
			String[] toplnyr = (JSPUtil.getParameter(request, prefix	+ "toplnyr", length));
			String[] report = (JSPUtil.getParameter(request, prefix	+ "report", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] locortrade = (JSPUtil.getParameter(request, prefix	+ "locortrade", length));
			String[] atlocation = (JSPUtil.getParameter(request, prefix	+ "atlocation", length));
			String[] repoplanid = (JSPUtil.getParameter(request, prefix	+ "repoplanid", length));
			String[] fmplnwk = (JSPUtil.getParameter(request, prefix	+ "fmplnwk", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0072ConditionVO();
				if (ts[i] != null)
					model.setTs(ts[i]);
				if (trade[i] != null)
					model.setTrade(trade[i]);
				if (bylocation[i] != null)
					model.setBylocation(bylocation[i]);
				if (toplnwk[i] != null)
					model.setToplnwk(toplnwk[i]);
				if (plnYrwk[i] != null)
					model.setPlnYrwk(plnYrwk[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (yyyyww[i] != null)
					model.setYyyyww(yyyyww[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmplnyr[i] != null)
					model.setFmplnyr(fmplnyr[i]);
				if (atstatus[i] != null)
					model.setAtstatus(atstatus[i]);
				if (company[i] != null)
					model.setCompany(company[i]);
				if (toplnyr[i] != null)
					model.setToplnyr(toplnyr[i]);
				if (report[i] != null)
					model.setReport(report[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (locortrade[i] != null)
					model.setLocortrade(locortrade[i]);
				if (atlocation[i] != null)
					model.setAtlocation(atlocation[i]);
				if (repoplanid[i] != null)
					model.setRepoplanid(repoplanid[i]);
				if (fmplnwk[i] != null)
					model.setFmplnwk(fmplnwk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0072ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0072ConditionVO[]
	 */
	public EesEqr0072ConditionVO[] getEesEqr0072ConditionVOs(){
		EesEqr0072ConditionVO[] vos = (EesEqr0072ConditionVO[])models.toArray(new EesEqr0072ConditionVO[models.size()]);
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
		this.ts = this.ts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade = this.trade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bylocation = this.bylocation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toplnwk = this.toplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrwk = this.plnYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww = this.yyyyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmplnyr = this.fmplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atstatus = this.atstatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.company = this.company .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toplnyr = this.toplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.report = this.report .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locortrade = this.locortrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atlocation = this.atlocation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoplanid = this.repoplanid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmplnwk = this.fmplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

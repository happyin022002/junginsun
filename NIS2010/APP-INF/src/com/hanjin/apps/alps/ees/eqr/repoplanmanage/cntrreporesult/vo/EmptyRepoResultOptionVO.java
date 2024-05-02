/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EmptyRepoResultOptionVO.java
*@FileTitle : EmptyRepoResultOptionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.01
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2010.12.01 양봉준 
* 1.0 Creation
* 
* =========================================================
* 2010.12.23 이병훈 [CHM-201007931-01] [EQR] - Empty Repo Result 기능 보완
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrreporesult.vo;

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
 * @author 양봉준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EmptyRepoResultOptionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EmptyRepoResultOptionVO> models = new ArrayList<EmptyRepoResultOptionVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tpsz = null;
	/* Column Info */
	private String fmloctp = null;
	/* Column Info */
	private String fmdate = null;
	/* Column Info */
	private String toloctp = null;
	/* Column Info */
	private String toloc = null;
	/* Column Info */
	private String fmloc = null;
	/* Column Info */
	private String transmode = null;
	/* Column Info */
	private String todate = null;
	/* Column Info */
	private String cntrtpszcd = null;
	/* Column Info */
	private String period = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EmptyRepoResultOptionVO() {}

	public EmptyRepoResultOptionVO(String ibflag, String pagerows, String period, String fmdate, String todate, String transmode, String fmloc, String toloc, String fmloctp, String toloctp, String tpsz, String cntrtpszcd) {
		this.ibflag = ibflag;
		this.tpsz = tpsz;
		this.fmloctp = fmloctp;
		this.fmdate = fmdate;
		this.toloctp = toloctp;
		this.toloc = toloc;
		this.fmloc = fmloc;
		this.transmode = transmode;
		this.todate = todate;
		this.cntrtpszcd = cntrtpszcd;
		this.period = period;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tpsz", getTpsz());
		this.hashColumns.put("fmloctp", getFmloctp());
		this.hashColumns.put("fmdate", getFmdate());
		this.hashColumns.put("toloctp", getToloctp());
		this.hashColumns.put("toloc", getToloc());
		this.hashColumns.put("fmloc", getFmloc());
		this.hashColumns.put("transmode", getTransmode());
		this.hashColumns.put("todate", getTodate());
		this.hashColumns.put("cntrtpszcd", getCntrtpszcd());
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tpsz", "tpsz");
		this.hashFields.put("fmloctp", "fmloctp");
		this.hashFields.put("fmdate", "fmdate");
		this.hashFields.put("toloctp", "toloctp");
		this.hashFields.put("toloc", "toloc");
		this.hashFields.put("fmloc", "fmloc");
		this.hashFields.put("transmode", "transmode");
		this.hashFields.put("todate", "todate");
		this.hashFields.put("cntrtpszcd", "cntrtpszcd");
		this.hashFields.put("period", "period");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return tpsz
	 */
	public String getTpsz() {
		return this.tpsz;
	}
	
	/**
	 * Column Info
	 * @return fmloctp
	 */
	public String getFmloctp() {
		return this.fmloctp;
	}
	
	/**
	 * Column Info
	 * @return fmdate
	 */
	public String getFmdate() {
		return this.fmdate;
	}
	
	/**
	 * Column Info
	 * @return toloctp
	 */
	public String getToloctp() {
		return this.toloctp;
	}
	
	/**
	 * Column Info
	 * @return toloc
	 */
	public String getToloc() {
		return this.toloc;
	}
	
	/**
	 * Column Info
	 * @return fmloc
	 */
	public String getFmloc() {
		return this.fmloc;
	}
	
	/**
	 * Column Info
	 * @return transmode
	 */
	public String getTransmode() {
		return this.transmode;
	}
	
	/**
	 * Column Info
	 * @return todate
	 */
	public String getTodate() {
		return this.todate;
	}
	
	/**
	 * Column Info
	 * @return cntrtpszcd
	 */
	public String getCntrtpszcd() {
		return this.cntrtpszcd;
	}
	
	/**
	 * Column Info
	 * @return period
	 */
	public String getPeriod() {
		return this.period;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param fmloctp
	 */
	public void setFmloctp(String fmloctp) {
		this.fmloctp = fmloctp;
	}
	
	/**
	 * Column Info
	 * @param fmdate
	 */
	public void setFmdate(String fmdate) {
		this.fmdate = fmdate;
	}
	
	/**
	 * Column Info
	 * @param toloctp
	 */
	public void setToloctp(String toloctp) {
		this.toloctp = toloctp;
	}
	
	/**
	 * Column Info
	 * @param toloc
	 */
	public void setToloc(String toloc) {
		this.toloc = toloc;
	}
	
	/**
	 * Column Info
	 * @param fmloc
	 */
	public void setFmloc(String fmloc) {
		this.fmloc = fmloc;
	}
	
	/**
	 * Column Info
	 * @param transmode
	 */
	public void setTransmode(String transmode) {
		this.transmode = transmode;
	}
	
	/**
	 * Column Info
	 * @param todate
	 */
	public void setTodate(String todate) {
		this.todate = todate;
	}
	
	/**
	 * Column Info
	 * @param cntrtpszcd
	 */
	public void setCntrtpszcd(String cntrtpszcd) {
		this.cntrtpszcd = cntrtpszcd;
	}
	
	/**
	 * Column Info
	 * @param period
	 */
	public void setPeriod(String period) {
		this.period = period;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTpsz(JSPUtil.getParameter(request, prefix + "tpsz", ""));
		setFmloctp(JSPUtil.getParameter(request, prefix + "fmType", ""));
		setFmdate(JSPUtil.getParameter(request, prefix + "fmdate", ""));
		setToloctp(JSPUtil.getParameter(request, prefix + "toType", ""));
		setToloc(JSPUtil.getParameter(request, prefix + "toloc", ""));
		setFmloc(JSPUtil.getParameter(request, prefix + "fmloc", ""));
		setTransmode(JSPUtil.getParameter(request, prefix + "transmode", ""));
		setTodate(JSPUtil.getParameter(request, prefix + "todate", ""));
		setCntrtpszcd(JSPUtil.getParameter(request, prefix + "cntrtpszcd", ""));
		setPeriod(JSPUtil.getParameter(request, prefix + "period", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EmptyRepoResultOptionVO[]
	 */
	public EmptyRepoResultOptionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EmptyRepoResultOptionVO[]
	 */
	public EmptyRepoResultOptionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EmptyRepoResultOptionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tpsz = (JSPUtil.getParameter(request, prefix	+ "tpsz", length));
			String[] fmloctp = (JSPUtil.getParameter(request, prefix	+ "fmType", length));
			String[] fmdate = (JSPUtil.getParameter(request, prefix	+ "fmdate", length));
			String[] toloctp = (JSPUtil.getParameter(request, prefix	+ "toType", length));
			String[] toloc = (JSPUtil.getParameter(request, prefix	+ "toloc", length));
			String[] fmloc = (JSPUtil.getParameter(request, prefix	+ "fmloc", length));
			String[] transmode = (JSPUtil.getParameter(request, prefix	+ "transmode", length));
			String[] todate = (JSPUtil.getParameter(request, prefix	+ "todate", length));
			String[] cntrtpszcd = (JSPUtil.getParameter(request, prefix	+ "cntrtpszcd", length));
			String[] period = (JSPUtil.getParameter(request, prefix	+ "period", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EmptyRepoResultOptionVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tpsz[i] != null)
					model.setTpsz(tpsz[i]);
				if (fmloctp[i] != null)
					model.setFmloctp(fmloctp[i]);
				if (fmdate[i] != null)
					model.setFmdate(fmdate[i]);
				if (toloctp[i] != null)
					model.setToloctp(toloctp[i]);
				if (toloc[i] != null)
					model.setToloc(toloc[i]);
				if (fmloc[i] != null)
					model.setFmloc(fmloc[i]);
				if (transmode[i] != null)
					model.setTransmode(transmode[i]);
				if (todate[i] != null)
					model.setTodate(todate[i]);
				if (cntrtpszcd[i] != null)
					model.setCntrtpszcd(cntrtpszcd[i]);
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEmptyRepoResultOptionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EmptyRepoResultOptionVO[]
	 */
	public EmptyRepoResultOptionVO[] getEmptyRepoResultOptionVOs(){
		EmptyRepoResultOptionVO[] vos = (EmptyRepoResultOptionVO[])models.toArray(new EmptyRepoResultOptionVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsz = this.tpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmloctp = this.fmloctp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmdate = this.fmdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toloctp = this.toloctp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toloc = this.toloc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmloc = this.fmloc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transmode = this.transmode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.todate = this.todate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtpszcd = this.cntrtpszcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period = this.period .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchTransportationInfoVO.java
*@FileTitle : SearchTransportationInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.30
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2011.08.30 김인수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo;

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
 * @author 김인수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchTransportationInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchTransportationInfoVO> models = new ArrayList<SearchTransportationInfoVO>();
	
	/* Column Info */
	private String actCd = null;
	/* Column Info */
	private String railRcvCoffFmDt = null;
	/* Column Info */
	private String actRcvTpCd = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String copDtlSeq = null;
	/* Column Info */
	private String estmTime = null;
	/* Column Info */
	private String actStsCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String plnDate = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actNm = null;
	/* Column Info */
	private String actTime = null;
	/* Column Info */
	private String estmDate = null;
	/* Column Info */
	private String actDate = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String plnTime = null;
	/* Column Info */
	private String fxPlnDate = null;
	/* Column Info */
	private String fxPlnTime = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchTransportationInfoVO() {}

	public SearchTransportationInfoVO(String ibflag, String pagerows, String copNo, String copDtlSeq, String railRcvCoffFmDt, String actCd, String actNm, String vvd, String nodCd, String plnDate, String plnTime, String estmDate, String estmTime, String actDate, String actTime, String actRcvTpCd, String actStsCd, String fxPlnTime, String fxPlnDate) {
		this.actCd = actCd;
		this.railRcvCoffFmDt = railRcvCoffFmDt;
		this.actRcvTpCd = actRcvTpCd;
		this.copNo = copNo;
		this.copDtlSeq = copDtlSeq;
		this.estmTime = estmTime;
		this.actStsCd = actStsCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.plnDate = plnDate;
		this.ibflag = ibflag;
		this.actNm = actNm;
		this.actTime = actTime;
		this.estmDate = estmDate;
		this.actDate = actDate;
		this.nodCd = nodCd;
		this.plnTime = plnTime;
		this.fxPlnTime = fxPlnTime;
		this.fxPlnDate = fxPlnDate;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("act_cd", getActCd());
		this.hashColumns.put("rail_rcv_coff_fm_dt", getRailRcvCoffFmDt());
		this.hashColumns.put("act_rcv_tp_cd", getActRcvTpCd());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("cop_dtl_seq", getCopDtlSeq());
		this.hashColumns.put("estm_time", getEstmTime());
		this.hashColumns.put("act_sts_cd", getActStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pln_date", getPlnDate());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_nm", getActNm());
		this.hashColumns.put("act_time", getActTime());
		this.hashColumns.put("estm_date", getEstmDate());
		this.hashColumns.put("act_date", getActDate());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("pln_time", getPlnTime());
		this.hashColumns.put("fx_pln_date", getFxPlnDate());
		this.hashColumns.put("fx_pln_time", getFxPlnTime());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("act_cd", "actCd");
		this.hashFields.put("rail_rcv_coff_fm_dt", "railRcvCoffFmDt");
		this.hashFields.put("act_rcv_tp_cd", "actRcvTpCd");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("cop_dtl_seq", "copDtlSeq");
		this.hashFields.put("estm_time", "estmTime");
		this.hashFields.put("act_sts_cd", "actStsCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pln_date", "plnDate");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_nm", "actNm");
		this.hashFields.put("act_time", "actTime");
		this.hashFields.put("estm_date", "estmDate");
		this.hashFields.put("act_date", "actDate");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("pln_time", "plnTime");
		this.hashFields.put("fx_pln_time", "fxPlnTime");
		this.hashFields.put("fx_pln_date", "fxPlnDate");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return actCd
	 */
	public String getActCd() {
		return this.actCd;
	}
	
	/**
	 * Column Info
	 * @return railRcvCoffFmDt
	 */
	public String getRailRcvCoffFmDt() {
		return this.railRcvCoffFmDt;
	}
	
	/**
	 * Column Info
	 * @return actRcvTpCd
	 */
	public String getActRcvTpCd() {
		return this.actRcvTpCd;
	}
	
	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return copDtlSeq
	 */
	public String getCopDtlSeq() {
		return this.copDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return estmTime
	 */
	public String getEstmTime() {
		return this.estmTime;
	}
	
	/**
	 * Column Info
	 * @return actStsCd
	 */
	public String getActStsCd() {
		return this.actStsCd;
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
	 * @return plnDate
	 */
	public String getPlnDate() {
		return this.plnDate;
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
	 * @return actNm
	 */
	public String getActNm() {
		return this.actNm;
	}
	
	/**
	 * Column Info
	 * @return actTime
	 */
	public String getActTime() {
		return this.actTime;
	}
	
	/**
	 * Column Info
	 * @return estmDate
	 */
	public String getEstmDate() {
		return this.estmDate;
	}
	
	/**
	 * Column Info
	 * @return actDate
	 */
	public String getActDate() {
		return this.actDate;
	}
	
	/**
	 * Column Info
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}
	
	/**
	 * Column Info
	 * @return plnTime
	 */
	public String getPlnTime() {
		return this.plnTime;
	}
	
	/**
	 * Column Info
	 * @return plnTime
	 */
	public String getFxPlnDate() {
		return this.fxPlnDate;
	}
	
	/**
	 * Column Info
	 * @return plnTime
	 */
	public String getFxPlnTime() {
		return this.fxPlnTime;
	}
	

	/**
	 * Column Info
	 * @param actCd
	 */
	public void setActCd(String actCd) {
		this.actCd = actCd;
	}
	
	/**
	 * Column Info
	 * @param railRcvCoffFmDt
	 */
	public void setRailRcvCoffFmDt(String railRcvCoffFmDt) {
		this.railRcvCoffFmDt = railRcvCoffFmDt;
	}
	
	/**
	 * Column Info
	 * @param actRcvTpCd
	 */
	public void setActRcvTpCd(String actRcvTpCd) {
		this.actRcvTpCd = actRcvTpCd;
	}
	
	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param copDtlSeq
	 */
	public void setCopDtlSeq(String copDtlSeq) {
		this.copDtlSeq = copDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param estmTime
	 */
	public void setEstmTime(String estmTime) {
		this.estmTime = estmTime;
	}
	
	/**
	 * Column Info
	 * @param actStsCd
	 */
	public void setActStsCd(String actStsCd) {
		this.actStsCd = actStsCd;
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
	 * @param plnDate
	 */
	public void setPlnDate(String plnDate) {
		this.plnDate = plnDate;
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
	 * @param actNm
	 */
	public void setActNm(String actNm) {
		this.actNm = actNm;
	}
	
	/**
	 * Column Info
	 * @param actTime
	 */
	public void setActTime(String actTime) {
		this.actTime = actTime;
	}
	
	/**
	 * Column Info
	 * @param estmDate
	 */
	public void setEstmDate(String estmDate) {
		this.estmDate = estmDate;
	}
	
	/**
	 * Column Info
	 * @param actDate
	 */
	public void setActDate(String actDate) {
		this.actDate = actDate;
	}
	
	/**
	 * Column Info
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
	}
	
	/**
	 * Column Info
	 * @param plnTime
	 */
	public void setPlnTime(String plnTime) {
		this.plnTime = plnTime;
	}
	
	/**
	 * Column Info
	 * @param fxPlnDate
	 */
	public void setFxPlnDate(String fxPlnDate) {
		this.fxPlnDate = fxPlnDate;
	}
	
	/**
	 * Column Info
	 * @param fxPlnTime
	 */
	public void setFxPlnTime(String fxPlnTime) {
		this.fxPlnTime = fxPlnTime;
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
		setActCd(JSPUtil.getParameter(request, prefix + "act_cd", ""));
		setRailRcvCoffFmDt(JSPUtil.getParameter(request, prefix + "rail_rcv_coff_fm_dt", ""));
		setActRcvTpCd(JSPUtil.getParameter(request, prefix + "act_rcv_tp_cd", ""));
		setCopNo(JSPUtil.getParameter(request, prefix + "cop_no", ""));
		setCopDtlSeq(JSPUtil.getParameter(request, prefix + "cop_dtl_seq", ""));
		setEstmTime(JSPUtil.getParameter(request, prefix + "estm_time", ""));
		setActStsCd(JSPUtil.getParameter(request, prefix + "act_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPlnDate(JSPUtil.getParameter(request, prefix + "pln_date", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setActNm(JSPUtil.getParameter(request, prefix + "act_nm", ""));
		setActTime(JSPUtil.getParameter(request, prefix + "act_time", ""));
		setEstmDate(JSPUtil.getParameter(request, prefix + "estm_date", ""));
		setActDate(JSPUtil.getParameter(request, prefix + "act_date", ""));
		setNodCd(JSPUtil.getParameter(request, prefix + "nod_cd", ""));
		setPlnTime(JSPUtil.getParameter(request, prefix + "pln_time", ""));
		setFxPlnDate(JSPUtil.getParameter(request, prefix + "fx_pln_date", ""));
		setFxPlnTime(JSPUtil.getParameter(request, prefix + "fx_pln_time", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchTransportationInfoVO[]
	 */
	public SearchTransportationInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchTransportationInfoVO[]
	 */
	public SearchTransportationInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchTransportationInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] actCd = (JSPUtil.getParameter(request, prefix	+ "act_cd", length));
			String[] railRcvCoffFmDt = (JSPUtil.getParameter(request, prefix	+ "rail_rcv_coff_fm_dt", length));
			String[] actRcvTpCd = (JSPUtil.getParameter(request, prefix	+ "act_rcv_tp_cd", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] copDtlSeq = (JSPUtil.getParameter(request, prefix	+ "cop_dtl_seq", length));
			String[] estmTime = (JSPUtil.getParameter(request, prefix	+ "estm_time", length));
			String[] actStsCd = (JSPUtil.getParameter(request, prefix	+ "act_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] plnDate = (JSPUtil.getParameter(request, prefix	+ "pln_date", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actNm = (JSPUtil.getParameter(request, prefix	+ "act_nm", length));
			String[] actTime = (JSPUtil.getParameter(request, prefix	+ "act_time", length));
			String[] estmDate = (JSPUtil.getParameter(request, prefix	+ "estm_date", length));
			String[] actDate = (JSPUtil.getParameter(request, prefix	+ "act_date", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] plnTime = (JSPUtil.getParameter(request, prefix	+ "pln_time", length));
			String[] fxPlnDate = (JSPUtil.getParameter(request, prefix	+ "fx_pln_Date", length));
			String[] fxPlnTime = (JSPUtil.getParameter(request, prefix	+ "fx_pln_time", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchTransportationInfoVO();
				if (actCd[i] != null)
					model.setActCd(actCd[i]);
				if (railRcvCoffFmDt[i] != null)
					model.setRailRcvCoffFmDt(railRcvCoffFmDt[i]);
				if (actRcvTpCd[i] != null)
					model.setActRcvTpCd(actRcvTpCd[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (copDtlSeq[i] != null)
					model.setCopDtlSeq(copDtlSeq[i]);
				if (estmTime[i] != null)
					model.setEstmTime(estmTime[i]);
				if (actStsCd[i] != null)
					model.setActStsCd(actStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (plnDate[i] != null)
					model.setPlnDate(plnDate[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actNm[i] != null)
					model.setActNm(actNm[i]);
				if (actTime[i] != null)
					model.setActTime(actTime[i]);
				if (estmDate[i] != null)
					model.setEstmDate(estmDate[i]);
				if (actDate[i] != null)
					model.setActDate(actDate[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (plnTime[i] != null)
					model.setPlnTime(plnTime[i]);
				if (fxPlnDate[i] != null)
					model.setFxPlnDate(fxPlnDate[i]);
				if (fxPlnTime[i] != null)
					model.setFxPlnTime(fxPlnTime[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchTransportationInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchTransportationInfoVO[]
	 */
	public SearchTransportationInfoVO[] getSearchTransportationInfoVOs(){
		SearchTransportationInfoVO[] vos = (SearchTransportationInfoVO[])models.toArray(new SearchTransportationInfoVO[models.size()]);
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
		this.actCd = this.actCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railRcvCoffFmDt = this.railRcvCoffFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRcvTpCd = this.actRcvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copDtlSeq = this.copDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmTime = this.estmTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actStsCd = this.actStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnDate = this.plnDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actNm = this.actNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actTime = this.actTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmDate = this.estmDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDate = this.actDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnTime = this.plnTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fxPlnDate = this.fxPlnTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fxPlnTime = this.fxPlnTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

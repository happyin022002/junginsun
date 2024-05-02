/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchTransportationInfoVO.java
*@FileTitle : SearchTransportationInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.27
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2009.11.27 오현경 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.copmanage.copsearch.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 오현경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchTransportationInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchTransportationInfoVO> models = new ArrayList<SearchTransportationInfoVO>();
	
	/* Column Info */
	private String actCd = null;
	/* Column Info */
	private String exptInfo = null;
	/* Column Info */
	private String railRcvCoffFmDt = null;
	/* Column Info */
	private String actRcvTpCd = null;
	/* Column Info */
	private String copExptSts = null;
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
	/* Column Info */
	private String copExptNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actNm = null;
	/* Column Info */
	private String copExptTpCd = null;
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

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchTransportationInfoVO() {}

	public SearchTransportationInfoVO(String ibflag, String pagerows, String copNo, String copDtlSeq, String railRcvCoffFmDt, String actCd, String actNm, String vvd, String nodCd, String plnDate, String plnTime, String estmDate, String estmTime, String actDate, String actTime, String actRcvTpCd, String exptInfo, String copExptSts, String copExptNo, String copExptTpCd, String actStsCd) {
		this.actCd = actCd;
		this.exptInfo = exptInfo;
		this.railRcvCoffFmDt = railRcvCoffFmDt;
		this.actRcvTpCd = actRcvTpCd;
		this.copExptSts = copExptSts;
		this.copNo = copNo;
		this.copDtlSeq = copDtlSeq;
		this.estmTime = estmTime;
		this.actStsCd = actStsCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.plnDate = plnDate;
		this.copExptNo = copExptNo;
		this.ibflag = ibflag;
		this.actNm = actNm;
		this.copExptTpCd = copExptTpCd;
		this.actTime = actTime;
		this.estmDate = estmDate;
		this.actDate = actDate;
		this.nodCd = nodCd;
		this.plnTime = plnTime;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("act_cd", getActCd());
		this.hashColumns.put("expt_info", getExptInfo());
		this.hashColumns.put("rail_rcv_coff_fm_dt", getRailRcvCoffFmDt());
		this.hashColumns.put("act_rcv_tp_cd", getActRcvTpCd());
		this.hashColumns.put("cop_expt_sts", getCopExptSts());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("cop_dtl_seq", getCopDtlSeq());
		this.hashColumns.put("estm_time", getEstmTime());
		this.hashColumns.put("act_sts_cd", getActStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pln_date", getPlnDate());
		this.hashColumns.put("cop_expt_no", getCopExptNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_nm", getActNm());
		this.hashColumns.put("cop_expt_tp_cd", getCopExptTpCd());
		this.hashColumns.put("act_time", getActTime());
		this.hashColumns.put("estm_date", getEstmDate());
		this.hashColumns.put("act_date", getActDate());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("pln_time", getPlnTime());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("act_cd", "actCd");
		this.hashFields.put("expt_info", "exptInfo");
		this.hashFields.put("rail_rcv_coff_fm_dt", "railRcvCoffFmDt");
		this.hashFields.put("act_rcv_tp_cd", "actRcvTpCd");
		this.hashFields.put("cop_expt_sts", "copExptSts");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("cop_dtl_seq", "copDtlSeq");
		this.hashFields.put("estm_time", "estmTime");
		this.hashFields.put("act_sts_cd", "actStsCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pln_date", "plnDate");
		this.hashFields.put("cop_expt_no", "copExptNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_nm", "actNm");
		this.hashFields.put("cop_expt_tp_cd", "copExptTpCd");
		this.hashFields.put("act_time", "actTime");
		this.hashFields.put("estm_date", "estmDate");
		this.hashFields.put("act_date", "actDate");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("pln_time", "plnTime");
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
	 * @return exptInfo
	 */
	public String getExptInfo() {
		return this.exptInfo;
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
	 * @return copExptSts
	 */
	public String getCopExptSts() {
		return this.copExptSts;
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
	 * Column Info
	 * @return copExptNo
	 */
	public String getCopExptNo() {
		return this.copExptNo;
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
	 * @return copExptTpCd
	 */
	public String getCopExptTpCd() {
		return this.copExptTpCd;
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
	 * @param actCd
	 */
	public void setActCd(String actCd) {
		this.actCd = actCd;
	}
	
	/**
	 * Column Info
	 * @param exptInfo
	 */
	public void setExptInfo(String exptInfo) {
		this.exptInfo = exptInfo;
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
	 * @param copExptSts
	 */
	public void setCopExptSts(String copExptSts) {
		this.copExptSts = copExptSts;
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
	 * Column Info
	 * @param copExptNo
	 */
	public void setCopExptNo(String copExptNo) {
		this.copExptNo = copExptNo;
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
	 * @param copExptTpCd
	 */
	public void setCopExptTpCd(String copExptTpCd) {
		this.copExptTpCd = copExptTpCd;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setActCd(JSPUtil.getParameter(request, "act_cd", ""));
		setExptInfo(JSPUtil.getParameter(request, "expt_info", ""));
		setRailRcvCoffFmDt(JSPUtil.getParameter(request, "rail_rcv_coff_fm_dt", ""));
		setActRcvTpCd(JSPUtil.getParameter(request, "act_rcv_tp_cd", ""));
		setCopExptSts(JSPUtil.getParameter(request, "cop_expt_sts", ""));
		setCopNo(JSPUtil.getParameter(request, "cop_no", ""));
		setCopDtlSeq(JSPUtil.getParameter(request, "cop_dtl_seq", ""));
		setEstmTime(JSPUtil.getParameter(request, "estm_time", ""));
		setActStsCd(JSPUtil.getParameter(request, "act_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPlnDate(JSPUtil.getParameter(request, "pln_date", ""));
		setCopExptNo(JSPUtil.getParameter(request, "cop_expt_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setActNm(JSPUtil.getParameter(request, "act_nm", ""));
		setCopExptTpCd(JSPUtil.getParameter(request, "cop_expt_tp_cd", ""));
		setActTime(JSPUtil.getParameter(request, "act_time", ""));
		setEstmDate(JSPUtil.getParameter(request, "estm_date", ""));
		setActDate(JSPUtil.getParameter(request, "act_date", ""));
		setNodCd(JSPUtil.getParameter(request, "nod_cd", ""));
		setPlnTime(JSPUtil.getParameter(request, "pln_time", ""));
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
			String[] exptInfo = (JSPUtil.getParameter(request, prefix	+ "expt_info", length));
			String[] railRcvCoffFmDt = (JSPUtil.getParameter(request, prefix	+ "rail_rcv_coff_fm_dt", length));
			String[] actRcvTpCd = (JSPUtil.getParameter(request, prefix	+ "act_rcv_tp_cd", length));
			String[] copExptSts = (JSPUtil.getParameter(request, prefix	+ "cop_expt_sts", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] copDtlSeq = (JSPUtil.getParameter(request, prefix	+ "cop_dtl_seq", length));
			String[] estmTime = (JSPUtil.getParameter(request, prefix	+ "estm_time", length));
			String[] actStsCd = (JSPUtil.getParameter(request, prefix	+ "act_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] plnDate = (JSPUtil.getParameter(request, prefix	+ "pln_date", length));
			String[] copExptNo = (JSPUtil.getParameter(request, prefix	+ "cop_expt_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actNm = (JSPUtil.getParameter(request, prefix	+ "act_nm", length));
			String[] copExptTpCd = (JSPUtil.getParameter(request, prefix	+ "cop_expt_tp_cd", length));
			String[] actTime = (JSPUtil.getParameter(request, prefix	+ "act_time", length));
			String[] estmDate = (JSPUtil.getParameter(request, prefix	+ "estm_date", length));
			String[] actDate = (JSPUtil.getParameter(request, prefix	+ "act_date", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] plnTime = (JSPUtil.getParameter(request, prefix	+ "pln_time", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchTransportationInfoVO();
				if (actCd[i] != null)
					model.setActCd(actCd[i]);
				if (exptInfo[i] != null)
					model.setExptInfo(exptInfo[i]);
				if (railRcvCoffFmDt[i] != null)
					model.setRailRcvCoffFmDt(railRcvCoffFmDt[i]);
				if (actRcvTpCd[i] != null)
					model.setActRcvTpCd(actRcvTpCd[i]);
				if (copExptSts[i] != null)
					model.setCopExptSts(copExptSts[i]);
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
				if (copExptNo[i] != null)
					model.setCopExptNo(copExptNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actNm[i] != null)
					model.setActNm(actNm[i]);
				if (copExptTpCd[i] != null)
					model.setCopExptTpCd(copExptTpCd[i]);
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
		this.exptInfo = this.exptInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railRcvCoffFmDt = this.railRcvCoffFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRcvTpCd = this.actRcvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copExptSts = this.copExptSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copDtlSeq = this.copDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmTime = this.estmTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actStsCd = this.actStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnDate = this.plnDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copExptNo = this.copExptNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actNm = this.actNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copExptTpCd = this.copExptTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actTime = this.actTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmDate = this.estmDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDate = this.actDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnTime = this.plnTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

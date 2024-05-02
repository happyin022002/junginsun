/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchEdiActivityInquiryDataVO.java
*@FileTitle : SearchEdiActivityInquiryDataVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.11.04 전병석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo;

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
 * @author 전병석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchEdiActivityInquiryDataVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchEdiActivityInquiryDataVO> models = new ArrayList<SearchEdiActivityInquiryDataVO>();
	
	/* Column Info */
	private String actCd = null;
	/* Column Info */
	private String eventDate = null;
	/* Column Info */
	private String ediLclDt = null;
	/* Column Info */
	private String ediSubStsCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String estmDt = null;
	/* Column Info */
	private String sndTp2 = null;
	/* Column Info */
	private String eventDt = null;
	/* Column Info */
	private String sndTp1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ediSts = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String updId = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String ediSndRmk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchEdiActivityInquiryDataVO() {}

	public SearchEdiActivityInquiryDataVO(String ibflag, String pagerows, String actCd, String ediSts, String ediSubStsCd, String seq, String estmDt, String eventDt, String nodCd, String eventDate, String ediLclDt, String ediSndRmk, String sndTp1, String sndTp2, String updId) {
		this.actCd = actCd;
		this.eventDate = eventDate;
		this.ediLclDt = ediLclDt;
		this.ediSubStsCd = ediSubStsCd;
		this.pagerows = pagerows;
		this.estmDt = estmDt;
		this.sndTp2 = sndTp2;
		this.eventDt = eventDt;
		this.sndTp1 = sndTp1;
		this.ibflag = ibflag;
		this.ediSts = ediSts;
		this.seq = seq;
		this.updId = updId;
		this.nodCd = nodCd;
		this.ediSndRmk = ediSndRmk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("act_cd", getActCd());
		this.hashColumns.put("event_date", getEventDate());
		this.hashColumns.put("edi_lcl_dt", getEdiLclDt());
		this.hashColumns.put("edi_sub_sts_cd", getEdiSubStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("estm_dt", getEstmDt());
		this.hashColumns.put("snd_tp2", getSndTp2());
		this.hashColumns.put("event_dt", getEventDt());
		this.hashColumns.put("snd_tp1", getSndTp1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("edi_sts", getEdiSts());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("upd_id", getUpdId());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("edi_snd_rmk", getEdiSndRmk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("act_cd", "actCd");
		this.hashFields.put("event_date", "eventDate");
		this.hashFields.put("edi_lcl_dt", "ediLclDt");
		this.hashFields.put("edi_sub_sts_cd", "ediSubStsCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("estm_dt", "estmDt");
		this.hashFields.put("snd_tp2", "sndTp2");
		this.hashFields.put("event_dt", "eventDt");
		this.hashFields.put("snd_tp1", "sndTp1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("edi_sts", "ediSts");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("upd_id", "updId");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("edi_snd_rmk", "ediSndRmk");
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
	 * @return eventDate
	 */
	public String getEventDate() {
		return this.eventDate;
	}
	
	/**
	 * Column Info
	 * @return ediLclDt
	 */
	public String getEdiLclDt() {
		return this.ediLclDt;
	}
	
	/**
	 * Column Info
	 * @return ediSubStsCd
	 */
	public String getEdiSubStsCd() {
		return this.ediSubStsCd;
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
	 * @return estmDt
	 */
	public String getEstmDt() {
		return this.estmDt;
	}
	
	/**
	 * Column Info
	 * @return sndTp2
	 */
	public String getSndTp2() {
		return this.sndTp2;
	}
	
	/**
	 * Column Info
	 * @return eventDt
	 */
	public String getEventDt() {
		return this.eventDt;
	}
	
	/**
	 * Column Info
	 * @return sndTp1
	 */
	public String getSndTp1() {
		return this.sndTp1;
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
	 * @return ediSts
	 */
	public String getEdiSts() {
		return this.ediSts;
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
	 * @return updId
	 */
	public String getUpdId() {
		return this.updId;
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
	 * @return ediSndRmk
	 */
	public String getEdiSndRmk() {
		return this.ediSndRmk;
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
	 * @param eventDate
	 */
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	
	/**
	 * Column Info
	 * @param ediLclDt
	 */
	public void setEdiLclDt(String ediLclDt) {
		this.ediLclDt = ediLclDt;
	}
	
	/**
	 * Column Info
	 * @param ediSubStsCd
	 */
	public void setEdiSubStsCd(String ediSubStsCd) {
		this.ediSubStsCd = ediSubStsCd;
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
	 * @param estmDt
	 */
	public void setEstmDt(String estmDt) {
		this.estmDt = estmDt;
	}
	
	/**
	 * Column Info
	 * @param sndTp2
	 */
	public void setSndTp2(String sndTp2) {
		this.sndTp2 = sndTp2;
	}
	
	/**
	 * Column Info
	 * @param eventDt
	 */
	public void setEventDt(String eventDt) {
		this.eventDt = eventDt;
	}
	
	/**
	 * Column Info
	 * @param sndTp1
	 */
	public void setSndTp1(String sndTp1) {
		this.sndTp1 = sndTp1;
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
	 * @param ediSts
	 */
	public void setEdiSts(String ediSts) {
		this.ediSts = ediSts;
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
	 * @param updId
	 */
	public void setUpdId(String updId) {
		this.updId = updId;
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
	 * @param ediSndRmk
	 */
	public void setEdiSndRmk(String ediSndRmk) {
		this.ediSndRmk = ediSndRmk;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setActCd(JSPUtil.getParameter(request, "act_cd", ""));
		setEventDate(JSPUtil.getParameter(request, "event_date", ""));
		setEdiLclDt(JSPUtil.getParameter(request, "edi_lcl_dt", ""));
		setEdiSubStsCd(JSPUtil.getParameter(request, "edi_sub_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEstmDt(JSPUtil.getParameter(request, "estm_dt", ""));
		setSndTp2(JSPUtil.getParameter(request, "snd_tp2", ""));
		setEventDt(JSPUtil.getParameter(request, "event_dt", ""));
		setSndTp1(JSPUtil.getParameter(request, "snd_tp1", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEdiSts(JSPUtil.getParameter(request, "edi_sts", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setUpdId(JSPUtil.getParameter(request, "upd_id", ""));
		setNodCd(JSPUtil.getParameter(request, "nod_cd", ""));
		setEdiSndRmk(JSPUtil.getParameter(request, "edi_snd_rmk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEdiActivityInquiryDataVO[]
	 */
	public SearchEdiActivityInquiryDataVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchEdiActivityInquiryDataVO[]
	 */
	public SearchEdiActivityInquiryDataVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchEdiActivityInquiryDataVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] actCd = (JSPUtil.getParameter(request, prefix	+ "act_cd", length));
			String[] eventDate = (JSPUtil.getParameter(request, prefix	+ "event_date", length));
			String[] ediLclDt = (JSPUtil.getParameter(request, prefix	+ "edi_lcl_dt", length));
			String[] ediSubStsCd = (JSPUtil.getParameter(request, prefix	+ "edi_sub_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] estmDt = (JSPUtil.getParameter(request, prefix	+ "estm_dt", length));
			String[] sndTp2 = (JSPUtil.getParameter(request, prefix	+ "snd_tp2", length));
			String[] eventDt = (JSPUtil.getParameter(request, prefix	+ "event_dt", length));
			String[] sndTp1 = (JSPUtil.getParameter(request, prefix	+ "snd_tp1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ediSts = (JSPUtil.getParameter(request, prefix	+ "edi_sts", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] updId = (JSPUtil.getParameter(request, prefix	+ "upd_id", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] ediSndRmk = (JSPUtil.getParameter(request, prefix	+ "edi_snd_rmk", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchEdiActivityInquiryDataVO();
				if (actCd[i] != null)
					model.setActCd(actCd[i]);
				if (eventDate[i] != null)
					model.setEventDate(eventDate[i]);
				if (ediLclDt[i] != null)
					model.setEdiLclDt(ediLclDt[i]);
				if (ediSubStsCd[i] != null)
					model.setEdiSubStsCd(ediSubStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (estmDt[i] != null)
					model.setEstmDt(estmDt[i]);
				if (sndTp2[i] != null)
					model.setSndTp2(sndTp2[i]);
				if (eventDt[i] != null)
					model.setEventDt(eventDt[i]);
				if (sndTp1[i] != null)
					model.setSndTp1(sndTp1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ediSts[i] != null)
					model.setEdiSts(ediSts[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (updId[i] != null)
					model.setUpdId(updId[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (ediSndRmk[i] != null)
					model.setEdiSndRmk(ediSndRmk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEdiActivityInquiryDataVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEdiActivityInquiryDataVO[]
	 */
	public SearchEdiActivityInquiryDataVO[] getSearchEdiActivityInquiryDataVOs(){
		SearchEdiActivityInquiryDataVO[] vos = (SearchEdiActivityInquiryDataVO[])models.toArray(new SearchEdiActivityInquiryDataVO[models.size()]);
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
		this.eventDate = this.eventDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediLclDt = this.ediLclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSubStsCd = this.ediSubStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmDt = this.estmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndTp2 = this.sndTp2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eventDt = this.eventDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndTp1 = this.sndTp1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSts = this.ediSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updId = this.updId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndRmk = this.ediSndRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

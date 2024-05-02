/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Edi315CurrInfoIsCurrCopDtlVO.java
*@FileTitle : Edi315CurrInfoIsCurrCopDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.23
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2009.11.23 이윤정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.edi315send.vo;

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
 * @author 이윤정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Edi315CurrInfoIsCurrCopDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Edi315CurrInfoIsCurrCopDtlVO> models = new ArrayList<Edi315CurrInfoIsCurrCopDtlVO>();
	
	/* Column Info */
	private String currEventDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String currCopNo = null;
	/* Column Info */
	private String currEventYard = null;
	/* Column Info */
	private String currActCd = null;
	/* Column Info */
	private String currActStsMapgCd = null;
	/* Column Info */
	private String currStndEdiStsCd = null;
	/* Column Info */
	private String currCopDtlSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Edi315CurrInfoIsCurrCopDtlVO() {}

	public Edi315CurrInfoIsCurrCopDtlVO(String ibflag, String pagerows, String currCopNo, String currCopDtlSeq, String currEventDt, String currEventYard, String currStndEdiStsCd, String currActCd, String currActStsMapgCd) {
		this.currEventDt = currEventDt;
		this.ibflag = ibflag;
		this.currCopNo = currCopNo;
		this.currEventYard = currEventYard;
		this.currActCd = currActCd;
		this.currActStsMapgCd = currActStsMapgCd;
		this.currStndEdiStsCd = currStndEdiStsCd;
		this.currCopDtlSeq = currCopDtlSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_event_dt", getCurrEventDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("curr_cop_no", getCurrCopNo());
		this.hashColumns.put("curr_event_yard", getCurrEventYard());
		this.hashColumns.put("curr_act_cd", getCurrActCd());
		this.hashColumns.put("curr_act_sts_mapg_cd", getCurrActStsMapgCd());
		this.hashColumns.put("curr_stnd_edi_sts_cd", getCurrStndEdiStsCd());
		this.hashColumns.put("curr_cop_dtl_seq", getCurrCopDtlSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_event_dt", "currEventDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr_cop_no", "currCopNo");
		this.hashFields.put("curr_event_yard", "currEventYard");
		this.hashFields.put("curr_act_cd", "currActCd");
		this.hashFields.put("curr_act_sts_mapg_cd", "currActStsMapgCd");
		this.hashFields.put("curr_stnd_edi_sts_cd", "currStndEdiStsCd");
		this.hashFields.put("curr_cop_dtl_seq", "currCopDtlSeq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return currEventDt
	 */
	public String getCurrEventDt() {
		return this.currEventDt;
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
	 * @return currCopNo
	 */
	public String getCurrCopNo() {
		return this.currCopNo;
	}
	
	/**
	 * Column Info
	 * @return currEventYard
	 */
	public String getCurrEventYard() {
		return this.currEventYard;
	}
	
	/**
	 * Column Info
	 * @return currActCd
	 */
	public String getCurrActCd() {
		return this.currActCd;
	}
	
	/**
	 * Column Info
	 * @return currActStsMapgCd
	 */
	public String getCurrActStsMapgCd() {
		return this.currActStsMapgCd;
	}
	
	/**
	 * Column Info
	 * @return currStndEdiStsCd
	 */
	public String getCurrStndEdiStsCd() {
		return this.currStndEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @return currCopDtlSeq
	 */
	public String getCurrCopDtlSeq() {
		return this.currCopDtlSeq;
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
	 * @param currEventDt
	 */
	public void setCurrEventDt(String currEventDt) {
		this.currEventDt = currEventDt;
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
	 * @param currCopNo
	 */
	public void setCurrCopNo(String currCopNo) {
		this.currCopNo = currCopNo;
	}
	
	/**
	 * Column Info
	 * @param currEventYard
	 */
	public void setCurrEventYard(String currEventYard) {
		this.currEventYard = currEventYard;
	}
	
	/**
	 * Column Info
	 * @param currActCd
	 */
	public void setCurrActCd(String currActCd) {
		this.currActCd = currActCd;
	}
	
	/**
	 * Column Info
	 * @param currActStsMapgCd
	 */
	public void setCurrActStsMapgCd(String currActStsMapgCd) {
		this.currActStsMapgCd = currActStsMapgCd;
	}
	
	/**
	 * Column Info
	 * @param currStndEdiStsCd
	 */
	public void setCurrStndEdiStsCd(String currStndEdiStsCd) {
		this.currStndEdiStsCd = currStndEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @param currCopDtlSeq
	 */
	public void setCurrCopDtlSeq(String currCopDtlSeq) {
		this.currCopDtlSeq = currCopDtlSeq;
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
		setCurrEventDt(JSPUtil.getParameter(request, "curr_event_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCurrCopNo(JSPUtil.getParameter(request, "curr_cop_no", ""));
		setCurrEventYard(JSPUtil.getParameter(request, "curr_event_yard", ""));
		setCurrActCd(JSPUtil.getParameter(request, "curr_act_cd", ""));
		setCurrActStsMapgCd(JSPUtil.getParameter(request, "curr_act_sts_mapg_cd", ""));
		setCurrStndEdiStsCd(JSPUtil.getParameter(request, "curr_stnd_edi_sts_cd", ""));
		setCurrCopDtlSeq(JSPUtil.getParameter(request, "curr_cop_dtl_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Edi315CurrInfoIsCurrCopDtlVO[]
	 */
	public Edi315CurrInfoIsCurrCopDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Edi315CurrInfoIsCurrCopDtlVO[]
	 */
	public Edi315CurrInfoIsCurrCopDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Edi315CurrInfoIsCurrCopDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currEventDt = (JSPUtil.getParameter(request, prefix	+ "curr_event_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] currCopNo = (JSPUtil.getParameter(request, prefix	+ "curr_cop_no", length));
			String[] currEventYard = (JSPUtil.getParameter(request, prefix	+ "curr_event_yard", length));
			String[] currActCd = (JSPUtil.getParameter(request, prefix	+ "curr_act_cd", length));
			String[] currActStsMapgCd = (JSPUtil.getParameter(request, prefix	+ "curr_act_sts_mapg_cd", length));
			String[] currStndEdiStsCd = (JSPUtil.getParameter(request, prefix	+ "curr_stnd_edi_sts_cd", length));
			String[] currCopDtlSeq = (JSPUtil.getParameter(request, prefix	+ "curr_cop_dtl_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new Edi315CurrInfoIsCurrCopDtlVO();
				if (currEventDt[i] != null)
					model.setCurrEventDt(currEventDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (currCopNo[i] != null)
					model.setCurrCopNo(currCopNo[i]);
				if (currEventYard[i] != null)
					model.setCurrEventYard(currEventYard[i]);
				if (currActCd[i] != null)
					model.setCurrActCd(currActCd[i]);
				if (currActStsMapgCd[i] != null)
					model.setCurrActStsMapgCd(currActStsMapgCd[i]);
				if (currStndEdiStsCd[i] != null)
					model.setCurrStndEdiStsCd(currStndEdiStsCd[i]);
				if (currCopDtlSeq[i] != null)
					model.setCurrCopDtlSeq(currCopDtlSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdi315CurrInfoIsCurrCopDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Edi315CurrInfoIsCurrCopDtlVO[]
	 */
	public Edi315CurrInfoIsCurrCopDtlVO[] getEdi315CurrInfoIsCurrCopDtlVOs(){
		Edi315CurrInfoIsCurrCopDtlVO[] vos = (Edi315CurrInfoIsCurrCopDtlVO[])models.toArray(new Edi315CurrInfoIsCurrCopDtlVO[models.size()]);
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
		this.currEventDt = this.currEventDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCopNo = this.currCopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currEventYard = this.currEventYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currActCd = this.currActCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currActStsMapgCd = this.currActStsMapgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currStndEdiStsCd = this.currStndEdiStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCopDtlSeq = this.currCopDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

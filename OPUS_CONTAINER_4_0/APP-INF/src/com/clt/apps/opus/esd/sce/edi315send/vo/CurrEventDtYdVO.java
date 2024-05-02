/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CurrEventDtYdVO.java
*@FileTitle : CurrEventDtYdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.07
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.04.07 이윤정 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.edi315send.vo;

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
 * @author 이윤정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CurrEventDtYdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CurrEventDtYdVO> models = new ArrayList<CurrEventDtYdVO>();
	
	/* Column Info */
	private String currEventDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String currEventYard = null;
	/* Column Info */
	private String currSts = null;
	/* Column Info */
	private String currCopDtlSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CurrEventDtYdVO() {}

	public CurrEventDtYdVO(String ibflag, String pagerows, String currEventDt, String currEventYard, String currCopDtlSeq, String currSts) {
		this.currEventDt = currEventDt;
		this.ibflag = ibflag;
		this.currEventYard = currEventYard;
		this.currSts = currSts;
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
		this.hashColumns.put("curr_event_yard", getCurrEventYard());
		this.hashColumns.put("curr_sts", getCurrSts());
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
		this.hashFields.put("curr_event_yard", "currEventYard");
		this.hashFields.put("curr_sts", "currSts");
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
	 * @return currEventYard
	 */
	public String getCurrEventYard() {
		return this.currEventYard;
	}
	
	/**
	 * Column Info
	 * @return currSts
	 */
	public String getCurrSts() {
		return this.currSts;
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
	 * @param currEventYard
	 */
	public void setCurrEventYard(String currEventYard) {
		this.currEventYard = currEventYard;
	}
	
	/**
	 * Column Info
	 * @param currSts
	 */
	public void setCurrSts(String currSts) {
		this.currSts = currSts;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setCurrEventDt(JSPUtil.getParameter(request, prefix + "curr_event_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCurrEventYard(JSPUtil.getParameter(request, prefix + "curr_event_yard", ""));
		setCurrSts(JSPUtil.getParameter(request, prefix + "curr_sts", ""));
		setCurrCopDtlSeq(JSPUtil.getParameter(request, prefix + "curr_cop_dtl_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CurrEventDtYdVO[]
	 */
	public CurrEventDtYdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CurrEventDtYdVO[]
	 */
	public CurrEventDtYdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CurrEventDtYdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currEventDt = (JSPUtil.getParameter(request, prefix	+ "curr_event_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] currEventYard = (JSPUtil.getParameter(request, prefix	+ "curr_event_yard", length));
			String[] currSts = (JSPUtil.getParameter(request, prefix	+ "curr_sts", length));
			String[] currCopDtlSeq = (JSPUtil.getParameter(request, prefix	+ "curr_cop_dtl_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CurrEventDtYdVO();
				if (currEventDt[i] != null)
					model.setCurrEventDt(currEventDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (currEventYard[i] != null)
					model.setCurrEventYard(currEventYard[i]);
				if (currSts[i] != null)
					model.setCurrSts(currSts[i]);
				if (currCopDtlSeq[i] != null)
					model.setCurrCopDtlSeq(currCopDtlSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCurrEventDtYdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CurrEventDtYdVO[]
	 */
	public CurrEventDtYdVO[] getCurrEventDtYdVOs(){
		CurrEventDtYdVO[] vos = (CurrEventDtYdVO[])models.toArray(new CurrEventDtYdVO[models.size()]);
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
		this.currEventYard = this.currEventYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currSts = this.currSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCopDtlSeq = this.currCopDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

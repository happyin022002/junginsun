/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQWorkOrderHistoryListINVO.java
*@FileTitle : EQWorkOrderHistoryListINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.09
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.12.09 박명신 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo;
	
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EQWorkOrderHistoryListINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EQWorkOrderHistoryListINVO> models = new ArrayList<EQWorkOrderHistoryListINVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String fmMnrInpDt = null;
	/* Column Info */
	private String toMnrInpDt = null;
	/* Column Info */
	private String mnrWoTpCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EQWorkOrderHistoryListINVO() {}

	public EQWorkOrderHistoryListINVO(String ibflag, String pagerows, String eqNo, String toMnrInpDt, String fmMnrInpDt, String mnrWoTpCd) {
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.fmMnrInpDt = fmMnrInpDt;
		this.toMnrInpDt = toMnrInpDt;
		this.mnrWoTpCd = mnrWoTpCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("fm_mnr_inp_dt", getFmMnrInpDt());
		this.hashColumns.put("to_mnr_inp_dt", getToMnrInpDt());
		this.hashColumns.put("mnr_wo_tp_cd", getMnrWoTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("fm_mnr_inp_dt", "fmMnrInpDt");
		this.hashFields.put("to_mnr_inp_dt", "toMnrInpDt");
		this.hashFields.put("mnr_wo_tp_cd", "mnrWoTpCd");
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return fmMnrInpDt
	 */
	public String getFmMnrInpDt() {
		return this.fmMnrInpDt;
	}
	
	/**
	 * Column Info
	 * @return toMnrInpDt
	 */
	public String getToMnrInpDt() {
		return this.toMnrInpDt;
	}
	
	/**
	 * Column Info
	 * @return mnrWoTpCd
	 */
	public String getMnrWoTpCd() {
		return this.mnrWoTpCd;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param fmMnrInpDt
	 */
	public void setFmMnrInpDt(String fmMnrInpDt) {
		this.fmMnrInpDt = fmMnrInpDt;
	}
	
	/**
	 * Column Info
	 * @param toMnrInpDt
	 */
	public void setToMnrInpDt(String toMnrInpDt) {
		this.toMnrInpDt = toMnrInpDt;
	}
	
	/**
	 * Column Info
	 * @param mnrWoTpCd
	 */
	public void setMnrWoTpCd(String mnrWoTpCd) {
		this.mnrWoTpCd = mnrWoTpCd;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setFmMnrInpDt(JSPUtil.getParameter(request, "fm_mnr_inp_dt", ""));
		setToMnrInpDt(JSPUtil.getParameter(request, "to_mnr_inp_dt", ""));
		setMnrWoTpCd(JSPUtil.getParameter(request, "mnr_wo_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EQWorkOrderHistoryListINVO[]
	 */
	public EQWorkOrderHistoryListINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EQWorkOrderHistoryListINVO[]
	 */
	public EQWorkOrderHistoryListINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EQWorkOrderHistoryListINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] fmMnrInpDt = (JSPUtil.getParameter(request, prefix	+ "fm_mnr_inp_dt", length));
			String[] toMnrInpDt = (JSPUtil.getParameter(request, prefix	+ "to_mnr_inp_dt", length));
			String[] mnrWoTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_wo_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EQWorkOrderHistoryListINVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (fmMnrInpDt[i] != null)
					model.setFmMnrInpDt(fmMnrInpDt[i]);
				if (toMnrInpDt[i] != null)
					model.setToMnrInpDt(toMnrInpDt[i]);
				if (mnrWoTpCd[i] != null)
					model.setMnrWoTpCd(mnrWoTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEQWorkOrderHistoryListINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EQWorkOrderHistoryListINVO[]
	 */
	public EQWorkOrderHistoryListINVO[] getEQWorkOrderHistoryListINVOs(){
		EQWorkOrderHistoryListINVO[] vos = (EQWorkOrderHistoryListINVO[])models.toArray(new EQWorkOrderHistoryListINVO[models.size()]);
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
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMnrInpDt = this.fmMnrInpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMnrInpDt = this.toMnrInpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrWoTpCd = this.mnrWoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

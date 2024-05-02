/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TotalLossInfoINVO.java
*@FileTitle : TotalLossInfoINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.03
*@LastModifier :
*@LastVersion : 1.0
* 2009.11.03
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TotalLossInfoINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<TotalLossInfoINVO> models = new ArrayList<TotalLossInfoINVO>();

	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rqstEqNo = null;
	/* Column Info */
	private String rqstDtTo = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String workType = null;
	/* Column Info */
	private String rqstDtFr = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

	public TotalLossInfoINVO() {}

	public TotalLossInfoINVO(String ibflag, String pagerows, String rqstEqNo, String rqstDtTo, String rqstOfcCd, String rqstDtFr, String workType) {
		this.ibflag = ibflag;
		this.rqstEqNo = rqstEqNo;
		this.rqstDtTo = rqstDtTo;
		this.rqstOfcCd = rqstOfcCd;
		this.workType = workType;
		this.rqstDtFr = rqstDtFr;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rqst_eq_no", getRqstEqNo());
		this.hashColumns.put("rqst_dt_to", getRqstDtTo());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("work_type", getWorkType());
		this.hashColumns.put("rqst_dt_fr", getRqstDtFr());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rqst_eq_no", "rqstEqNo");
		this.hashFields.put("rqst_dt_to", "rqstDtTo");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("work_type", "workType");
		this.hashFields.put("rqst_dt_fr", "rqstDtFr");
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
	 * @return rqstEqNo
	 */
	public String getRqstEqNo() {
		return this.rqstEqNo;
	}

	/**
	 * Column Info
	 * @return rqstDtTo
	 */
	public String getRqstDtTo() {
		return this.rqstDtTo;
	}

	/**
	 * Column Info
	 * @return rqstOfcCd
	 */
	public String getRqstOfcCd() {
		return this.rqstOfcCd;
	}

	/**
	 * Column Info
	 * @return workType
	 */
	public String getWorkType() {
		return this.workType;
	}

	/**
	 * Column Info
	 * @return rqstDtFr
	 */
	public String getRqstDtFr() {
		return this.rqstDtFr;
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
	 * @param rqstEqNo
	 */
	public void setRqstEqNo(String rqstEqNo) {
		this.rqstEqNo = rqstEqNo;
	}

	/**
	 * Column Info
	 * @param rqstDtTo
	 */
	public void setRqstDtTo(String rqstDtTo) {
		this.rqstDtTo = rqstDtTo;
	}

	/**
	 * Column Info
	 * @param rqstOfcCd
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}

	/**
	 * Column Info
	 * @param workType
	 */
	public void setWorkType(String workType) {
		this.workType = workType;
	}

	/**
	 * Column Info
	 * @param rqstDtFr
	 */
	public void setRqstDtFr(String rqstDtFr) {
		this.rqstDtFr = rqstDtFr;
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
		setRqstEqNo(JSPUtil.getParameter(request, "rqst_eq_no", ""));
		setRqstDtTo(JSPUtil.getParameter(request, "rqst_dt_to", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, "rqst_ofc_cd", ""));
		setWorkType(JSPUtil.getParameter(request, "work_type", ""));
		setRqstDtFr(JSPUtil.getParameter(request, "rqst_dt_fr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TotalLossInfoINVO[]
	 */
	public TotalLossInfoINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return TotalLossInfoINVO[]
	 */
	public TotalLossInfoINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TotalLossInfoINVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rqstEqNo = (JSPUtil.getParameter(request, prefix	+ "rqst_eq_no", length));
			String[] rqstDtTo = (JSPUtil.getParameter(request, prefix	+ "rqst_dt_to", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] workType = (JSPUtil.getParameter(request, prefix	+ "work_type", length));
			String[] rqstDtFr = (JSPUtil.getParameter(request, prefix	+ "rqst_dt_fr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new TotalLossInfoINVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rqstEqNo[i] != null)
					model.setRqstEqNo(rqstEqNo[i]);
				if (rqstDtTo[i] != null)
					model.setRqstDtTo(rqstDtTo[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (workType[i] != null)
					model.setWorkType(workType[i]);
				if (rqstDtFr[i] != null)
					model.setRqstDtFr(rqstDtFr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTotalLossInfoINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TotalLossInfoINVO[]
	 */
	public TotalLossInfoINVO[] getTotalLossInfoINVOs(){
		TotalLossInfoINVO[] vos = (TotalLossInfoINVO[])models.toArray(new TotalLossInfoINVO[models.size()]);
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
		this.rqstEqNo = this.rqstEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDtTo = this.rqstDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.workType = this.workType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDtFr = this.rqstDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TotalLossLessorReportINVO.java
*@FileTitle : TotalLossLessorReportINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.20  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo;

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

public class TotalLossLessorReportINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TotalLossLessorReportINVO> models = new ArrayList<TotalLossLessorReportINVO>();
	
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String totalLossNo = null;
	/* Column Info */
	private String fromDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String lessor = null;
	/* Column Info */
	private String ttlLssStsCd = null;
	/* Column Info */
	private String eqType = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TotalLossLessorReportINVO() {}

	public TotalLossLessorReportINVO(String ibflag, String pagerows, String totalLossNo, String toDt, String fromDt, String ttlLssStsCd, String eqNo, String lessor, String eqType) {
		this.toDt = toDt;
		this.totalLossNo = totalLossNo;
		this.fromDt = fromDt;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.lessor = lessor;
		this.ttlLssStsCd = ttlLssStsCd;
		this.eqType = eqType;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("total_loss_no", getTotalLossNo());
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("lessor", getLessor());
		this.hashColumns.put("ttl_lss_sts_cd", getTtlLssStsCd());
		this.hashColumns.put("eq_type", getEqType());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("total_loss_no", "totalLossNo");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("lessor", "lessor");
		this.hashFields.put("ttl_lss_sts_cd", "ttlLssStsCd");
		this.hashFields.put("eq_type", "eqType");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return totalLossNo
	 */
	public String getTotalLossNo() {
		return this.totalLossNo;
	}
	
	/**
	 * Column Info
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
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
	 * @return lessor
	 */
	public String getLessor() {
		return this.lessor;
	}
	
	/**
	 * Column Info
	 * @return ttlLssStsCd
	 */
	public String getTtlLssStsCd() {
		return this.ttlLssStsCd;
	}
	
	/**
	 * Column Info
	 * @return eqType
	 */
	public String getEqType() {
		return this.eqType;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param totalLossNo
	 */
	public void setTotalLossNo(String totalLossNo) {
		this.totalLossNo = totalLossNo;
	}
	
	/**
	 * Column Info
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
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
	 * @param lessor
	 */
	public void setLessor(String lessor) {
		this.lessor = lessor;
	}
	
	/**
	 * Column Info
	 * @param ttlLssStsCd
	 */
	public void setTtlLssStsCd(String ttlLssStsCd) {
		this.ttlLssStsCd = ttlLssStsCd;
	}
	
	/**
	 * Column Info
	 * @param eqType
	 */
	public void setEqType(String eqType) {
		this.eqType = eqType;
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
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setTotalLossNo(JSPUtil.getParameter(request, "total_loss_no", ""));
		setFromDt(JSPUtil.getParameter(request, "from_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setLessor(JSPUtil.getParameter(request, "lessor", ""));
		setTtlLssStsCd(JSPUtil.getParameter(request, "ttl_lss_sts_cd", ""));
		setEqType(JSPUtil.getParameter(request, "eq_type", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TotalLossLessorReportINVO[]
	 */
	public TotalLossLessorReportINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TotalLossLessorReportINVO[]
	 */
	public TotalLossLessorReportINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TotalLossLessorReportINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] totalLossNo = (JSPUtil.getParameter(request, prefix	+ "total_loss_no", length));
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] lessor = (JSPUtil.getParameter(request, prefix	+ "lessor", length));
			String[] ttlLssStsCd = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_sts_cd", length));
			String[] eqType = (JSPUtil.getParameter(request, prefix	+ "eq_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new TotalLossLessorReportINVO();
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (totalLossNo[i] != null)
					model.setTotalLossNo(totalLossNo[i]);
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (lessor[i] != null)
					model.setLessor(lessor[i]);
				if (ttlLssStsCd[i] != null)
					model.setTtlLssStsCd(ttlLssStsCd[i]);
				if (eqType[i] != null)
					model.setEqType(eqType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTotalLossLessorReportINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TotalLossLessorReportINVO[]
	 */
	public TotalLossLessorReportINVO[] getTotalLossLessorReportINVOs(){
		TotalLossLessorReportINVO[] vos = (TotalLossLessorReportINVO[])models.toArray(new TotalLossLessorReportINVO[models.size()]);
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
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalLossNo = this.totalLossNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lessor = this.lessor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssStsCd = this.ttlLssStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqType = this.eqType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

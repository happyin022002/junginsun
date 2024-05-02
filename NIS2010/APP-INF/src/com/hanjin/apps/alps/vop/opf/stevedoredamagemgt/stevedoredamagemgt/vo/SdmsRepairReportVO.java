/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SdmsRepairReportVO.java
*@FileTitle : SdmsRepairReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.07.02 이선영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo;

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
 * @author 이선영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SdmsRepairReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SdmsRepairReportVO> models = new ArrayList<SdmsRepairReportVO>();
	
	/* Column Info */
	private String grp = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String orderCnt = null;
	/* Column Info */
	private String reprCnt = null;
	/* Column Info */
	private String compAmt = null;
	/* Column Info */
	private String quoAmt = null;
	/* Column Info */
	private String compCnt = null;
	/* Column Info */
	private String period = null;
	/* Column Info */
	private String quoCnt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SdmsRepairReportVO() {}

	public SdmsRepairReportVO(String ibflag, String pagerows, String grp, String period, String orderCnt, String reprCnt, String compCnt, String compAmt, String quoCnt, String quoAmt) {
		this.grp = grp;
		this.ibflag = ibflag;
		this.orderCnt = orderCnt;
		this.reprCnt = reprCnt;
		this.compAmt = compAmt;
		this.quoAmt = quoAmt;
		this.compCnt = compCnt;
		this.period = period;
		this.quoCnt = quoCnt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("grp", getGrp());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("order_cnt", getOrderCnt());
		this.hashColumns.put("repr_cnt", getReprCnt());
		this.hashColumns.put("comp_amt", getCompAmt());
		this.hashColumns.put("quo_amt", getQuoAmt());
		this.hashColumns.put("comp_cnt", getCompCnt());
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("quo_cnt", getQuoCnt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("grp", "grp");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("order_cnt", "orderCnt");
		this.hashFields.put("repr_cnt", "reprCnt");
		this.hashFields.put("comp_amt", "compAmt");
		this.hashFields.put("quo_amt", "quoAmt");
		this.hashFields.put("comp_cnt", "compCnt");
		this.hashFields.put("period", "period");
		this.hashFields.put("quo_cnt", "quoCnt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return grp
	 */
	public String getGrp() {
		return this.grp;
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
	 * @return orderCnt
	 */
	public String getOrderCnt() {
		return this.orderCnt;
	}

	/**
	 * Column Info
	 * @return reprCnt
	 */
	public String getReprCnt() {
		return this.reprCnt;
	}
	
	/**
	 * Column Info
	 * @return compAmt
	 */
	public String getCompAmt() {
		return this.compAmt;
	}
	
	/**
	 * Column Info
	 * @return quoAmt
	 */
	public String getQuoAmt() {
		return this.quoAmt;
	}
	
	/**
	 * Column Info
	 * @return compCnt
	 */
	public String getCompCnt() {
		return this.compCnt;
	}
	
	/**
	 * Column Info
	 * @return period
	 */
	public String getPeriod() {
		return this.period;
	}
	
	/**
	 * Column Info
	 * @return quoCnt
	 */
	public String getQuoCnt() {
		return this.quoCnt;
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
	 * @param grp
	 */
	public void setGrp(String grp) {
		this.grp = grp;
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
	 * @param orderCnt
	 */
	public void setOrderCnt(String orderCnt) {
		this.orderCnt = orderCnt;
	}

	/**
	 * Column Info
	 * @param reprCnt
	 */
	public void setReprCnt(String reprCnt) {
		this.reprCnt = reprCnt;
	}
	
	/**
	 * Column Info
	 * @param compAmt
	 */
	public void setCompAmt(String compAmt) {
		this.compAmt = compAmt;
	}
	
	/**
	 * Column Info
	 * @param quoAmt
	 */
	public void setQuoAmt(String quoAmt) {
		this.quoAmt = quoAmt;
	}
	
	/**
	 * Column Info
	 * @param compCnt
	 */
	public void setCompCnt(String compCnt) {
		this.compCnt = compCnt;
	}
	
	/**
	 * Column Info
	 * @param period
	 */
	public void setPeriod(String period) {
		this.period = period;
	}
	
	/**
	 * Column Info
	 * @param quoCnt
	 */
	public void setQuoCnt(String quoCnt) {
		this.quoCnt = quoCnt;
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
		setGrp(JSPUtil.getParameter(request, "grp", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOrderCnt(JSPUtil.getParameter(request, "order_cnt", ""));
		setReprCnt(JSPUtil.getParameter(request, "repr_cnt", ""));
		setCompAmt(JSPUtil.getParameter(request, "comp_amt", ""));
		setQuoAmt(JSPUtil.getParameter(request, "quo_amt", ""));
		setCompCnt(JSPUtil.getParameter(request, "comp_cnt", ""));
		setPeriod(JSPUtil.getParameter(request, "period", ""));
		setQuoCnt(JSPUtil.getParameter(request, "quo_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SdmsRepairReportVO[]
	 */
	public SdmsRepairReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SdmsRepairReportVO[]
	 */
	public SdmsRepairReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SdmsRepairReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] grp = (JSPUtil.getParameter(request, prefix	+ "grp", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] orderCnt = (JSPUtil.getParameter(request, prefix	+ "order_cnt", length));
			String[] reprCnt = (JSPUtil.getParameter(request, prefix	+ "repr_cnt", length));
			String[] compAmt = (JSPUtil.getParameter(request, prefix	+ "comp_amt", length));
			String[] quoAmt = (JSPUtil.getParameter(request, prefix	+ "quo_amt", length));
			String[] compCnt = (JSPUtil.getParameter(request, prefix	+ "comp_cnt", length));
			String[] period = (JSPUtil.getParameter(request, prefix	+ "period", length));
			String[] quoCnt = (JSPUtil.getParameter(request, prefix	+ "quo_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SdmsRepairReportVO();
				if (grp[i] != null)
					model.setGrp(grp[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (orderCnt[i] != null)
					model.setOrderCnt(orderCnt[i]);
				if (reprCnt[i] != null)
					model.setReprCnt(reprCnt[i]);
				if (compAmt[i] != null)
					model.setCompAmt(compAmt[i]);
				if (quoAmt[i] != null)
					model.setQuoAmt(quoAmt[i]);
				if (compCnt[i] != null)
					model.setCompCnt(compCnt[i]);
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (quoCnt[i] != null)
					model.setQuoCnt(quoCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSdmsRepairReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SdmsRepairReportVO[]
	 */
	public SdmsRepairReportVO[] getSdmsRepairReportVOs(){
		SdmsRepairReportVO[] vos = (SdmsRepairReportVO[])models.toArray(new SdmsRepairReportVO[models.size()]);
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
		this.grp = this.grp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderCnt = this.orderCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reprCnt = this.reprCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.compAmt = this.compAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.quoAmt = this.quoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.compCnt = this.compCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period = this.period .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.quoCnt = this.quoCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

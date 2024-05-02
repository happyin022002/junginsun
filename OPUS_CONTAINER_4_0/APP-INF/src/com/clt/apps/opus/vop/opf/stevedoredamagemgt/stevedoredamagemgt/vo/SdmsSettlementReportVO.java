/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SdmsSettlementReportVO.java
*@FileTitle : SdmsSettlementReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.07.02 이선영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이선영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SdmsSettlementReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SdmsSettlementReportVO> models = new ArrayList<SdmsSettlementReportVO>();
	
	/* Column Info */
	private String payCnt = null;
	/* Column Info */
	private String grp = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String recAmt = null;
	/* Column Info */
	private String payAmt = null;
	/* Column Info */
	private String rejCnt = null;
	/* Column Info */
	private String rejAmt = null;
	/* Column Info */
	private String recCnt = null;
	/* Column Info */
	private String period = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SdmsSettlementReportVO() {}

	public SdmsSettlementReportVO(String ibflag, String pagerows, String grp, String period, String recCnt, String recAmt, String rejCnt, String rejAmt, String payCnt, String payAmt) {
		this.payCnt = payCnt;
		this.grp = grp;
		this.ibflag = ibflag;
		this.recAmt = recAmt;
		this.payAmt = payAmt;
		this.rejCnt = rejCnt;
		this.rejAmt = rejAmt;
		this.recCnt = recCnt;
		this.period = period;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pay_cnt", getPayCnt());
		this.hashColumns.put("grp", getGrp());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rec_amt", getRecAmt());
		this.hashColumns.put("pay_amt", getPayAmt());
		this.hashColumns.put("rej_cnt", getRejCnt());
		this.hashColumns.put("rej_amt", getRejAmt());
		this.hashColumns.put("rec_cnt", getRecCnt());
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pay_cnt", "payCnt");
		this.hashFields.put("grp", "grp");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rec_amt", "recAmt");
		this.hashFields.put("pay_amt", "payAmt");
		this.hashFields.put("rej_cnt", "rejCnt");
		this.hashFields.put("rej_amt", "rejAmt");
		this.hashFields.put("rec_cnt", "recCnt");
		this.hashFields.put("period", "period");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return payCnt
	 */
	public String getPayCnt() {
		return this.payCnt;
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
	 * @return recAmt
	 */
	public String getRecAmt() {
		return this.recAmt;
	}
	
	/**
	 * Column Info
	 * @return payAmt
	 */
	public String getPayAmt() {
		return this.payAmt;
	}
	
	/**
	 * Column Info
	 * @return rejCnt
	 */
	public String getRejCnt() {
		return this.rejCnt;
	}
	
	/**
	 * Column Info
	 * @return rejAmt
	 */
	public String getRejAmt() {
		return this.rejAmt;
	}
	
	/**
	 * Column Info
	 * @return recCnt
	 */
	public String getRecCnt() {
		return this.recCnt;
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
	 * Column Info
	 * @param payCnt
	 */
	public void setPayCnt(String payCnt) {
		this.payCnt = payCnt;
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
	 * @param recAmt
	 */
	public void setRecAmt(String recAmt) {
		this.recAmt = recAmt;
	}
	
	/**
	 * Column Info
	 * @param payAmt
	 */
	public void setPayAmt(String payAmt) {
		this.payAmt = payAmt;
	}
	
	/**
	 * Column Info
	 * @param rejCnt
	 */
	public void setRejCnt(String rejCnt) {
		this.rejCnt = rejCnt;
	}
	
	/**
	 * Column Info
	 * @param rejAmt
	 */
	public void setRejAmt(String rejAmt) {
		this.rejAmt = rejAmt;
	}
	
	/**
	 * Column Info
	 * @param recCnt
	 */
	public void setRecCnt(String recCnt) {
		this.recCnt = recCnt;
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
		setPayCnt(JSPUtil.getParameter(request, "pay_cnt", ""));
		setGrp(JSPUtil.getParameter(request, "grp", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRecAmt(JSPUtil.getParameter(request, "rec_amt", ""));
		setPayAmt(JSPUtil.getParameter(request, "pay_amt", ""));
		setRejCnt(JSPUtil.getParameter(request, "rej_cnt", ""));
		setRejAmt(JSPUtil.getParameter(request, "rej_amt", ""));
		setRecCnt(JSPUtil.getParameter(request, "rec_cnt", ""));
		setPeriod(JSPUtil.getParameter(request, "period", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SdmsSettlementReportVO[]
	 */
	public SdmsSettlementReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SdmsSettlementReportVO[]
	 */
	public SdmsSettlementReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SdmsSettlementReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] payCnt = (JSPUtil.getParameter(request, prefix	+ "pay_cnt", length));
			String[] grp = (JSPUtil.getParameter(request, prefix	+ "grp", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] recAmt = (JSPUtil.getParameter(request, prefix	+ "rec_amt", length));
			String[] payAmt = (JSPUtil.getParameter(request, prefix	+ "pay_amt", length));
			String[] rejCnt = (JSPUtil.getParameter(request, prefix	+ "rej_cnt", length));
			String[] rejAmt = (JSPUtil.getParameter(request, prefix	+ "rej_amt", length));
			String[] recCnt = (JSPUtil.getParameter(request, prefix	+ "rec_cnt", length));
			String[] period = (JSPUtil.getParameter(request, prefix	+ "period", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SdmsSettlementReportVO();
				if (payCnt[i] != null)
					model.setPayCnt(payCnt[i]);
				if (grp[i] != null)
					model.setGrp(grp[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (recAmt[i] != null)
					model.setRecAmt(recAmt[i]);
				if (payAmt[i] != null)
					model.setPayAmt(payAmt[i]);
				if (rejCnt[i] != null)
					model.setRejCnt(rejCnt[i]);
				if (rejAmt[i] != null)
					model.setRejAmt(rejAmt[i]);
				if (recCnt[i] != null)
					model.setRecCnt(recCnt[i]);
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSdmsSettlementReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SdmsSettlementReportVO[]
	 */
	public SdmsSettlementReportVO[] getSdmsSettlementReportVOs(){
		SdmsSettlementReportVO[] vos = (SdmsSettlementReportVO[])models.toArray(new SdmsSettlementReportVO[models.size()]);
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
		this.payCnt = this.payCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grp = this.grp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recAmt = this.recAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payAmt = this.payAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rejCnt = this.rejCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rejAmt = this.rejAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recCnt = this.recCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period = this.period .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

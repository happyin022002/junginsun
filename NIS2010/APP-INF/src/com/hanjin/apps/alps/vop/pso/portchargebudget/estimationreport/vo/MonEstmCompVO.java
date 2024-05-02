/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MonEstmCompVO.java
*@FileTitle : MonEstmCompVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.09
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2013.04.09 조정민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.vo;

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
 * @author 조정민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MonEstmCompVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MonEstmCompVO> models = new ArrayList<MonEstmCompVO>();
	
	/* Column Info */
	private String sumAmt1 = null;
	/* Column Info */
	private String sumAmt2 = null;
	/* Column Info */
	private String sumCnt2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String totalSumAmt = null;
	/* Column Info */
	private String sumCnt1 = null;
	/* Column Info */
	private String sumCntPort = null;
	/* Column Info */
	private String sumActPort = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MonEstmCompVO() {}

	public MonEstmCompVO(String ibflag, String pagerows, String rlaneCd, String sumCnt1, String sumCntPort, String sumActPort, String sumAmt1, String sumCnt2, String sumAmt2, String totalSumAmt) {
		this.sumAmt1 = sumAmt1;
		this.sumAmt2 = sumAmt2;
		this.sumCnt2 = sumCnt2;
		this.ibflag = ibflag;
		this.totalSumAmt = totalSumAmt;
		this.sumCnt1 = sumCnt1;
		this.sumCntPort = sumCntPort;
		this.sumActPort = sumActPort;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sum_amt1", getSumAmt1());
		this.hashColumns.put("sum_amt2", getSumAmt2());
		this.hashColumns.put("sum_cnt2", getSumCnt2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("total_sum_amt", getTotalSumAmt());
		this.hashColumns.put("sum_cnt1", getSumCnt1());
		this.hashColumns.put("sum_cnt_port", getSumCntPort());
		this.hashColumns.put("sum_act_port", getSumActPort());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sum_amt1", "sumAmt1");
		this.hashFields.put("sum_amt2", "sumAmt2");
		this.hashFields.put("sum_cnt2", "sumCnt2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("total_sum_amt", "totalSumAmt");
		this.hashFields.put("sum_cnt1", "sumCnt1");
		this.hashFields.put("sum_cnt_port", "sumCntPort");
		this.hashFields.put("sum_act_port", "sumActPort");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sumAmt1
	 */
	public String getSumAmt1() {
		return this.sumAmt1;
	}
	
	/**
	 * Column Info
	 * @return sumAmt2
	 */
	public String getSumAmt2() {
		return this.sumAmt2;
	}
	
	/**
	 * Column Info
	 * @return sumCnt2
	 */
	public String getSumCnt2() {
		return this.sumCnt2;
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
	 * @return totalSumAmt
	 */
	public String getTotalSumAmt() {
		return this.totalSumAmt;
	}
	
	/**
	 * Column Info
	 * @return sumCnt1
	 */
	public String getSumCnt1() {
		return this.sumCnt1;
	}
	
	/**
	 * Column Info
	 * @return sumCntPort
	 */
	public String getSumCntPort() {
		return this.sumCntPort;
	}
	
	/**
	 * Column Info
	 * @return sumActPort
	 */
	public String getSumActPort() {
		return this.sumActPort;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @param sumAmt1
	 */
	public void setSumAmt1(String sumAmt1) {
		this.sumAmt1 = sumAmt1;
	}
	
	/**
	 * Column Info
	 * @param sumAmt2
	 */
	public void setSumAmt2(String sumAmt2) {
		this.sumAmt2 = sumAmt2;
	}
	
	/**
	 * Column Info
	 * @param sumCnt2
	 */
	public void setSumCnt2(String sumCnt2) {
		this.sumCnt2 = sumCnt2;
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
	 * @param totalSumAmt
	 */
	public void setTotalSumAmt(String totalSumAmt) {
		this.totalSumAmt = totalSumAmt;
	}
	
	/**
	 * Column Info
	 * @param sumCnt1
	 */
	public void setSumCnt1(String sumCnt1) {
		this.sumCnt1 = sumCnt1;
	}
	
	/**
	 * Column Info
	 * @param sumCntPort
	 */
	public void setSumCntPort(String sumCntPort) {
		this.sumCntPort = sumCntPort;
	}
	
	/**
	 * Column Info
	 * @param sumActPort
	 */
	public void setSumActPort(String sumActPort) {
		this.sumActPort = sumActPort;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
		setSumAmt1(JSPUtil.getParameter(request, prefix + "sum_amt1", ""));
		setSumAmt2(JSPUtil.getParameter(request, prefix + "sum_amt2", ""));
		setSumCnt2(JSPUtil.getParameter(request, prefix + "sum_cnt2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTotalSumAmt(JSPUtil.getParameter(request, prefix + "total_sum_amt", ""));
		setSumCnt1(JSPUtil.getParameter(request, prefix + "sum_cnt1", ""));
		setSumCntPort(JSPUtil.getParameter(request, prefix + "sum_cnt_port", ""));
		setSumActPort(JSPUtil.getParameter(request, prefix + "sum_act_port", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MonEstmCompVO[]
	 */
	public MonEstmCompVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MonEstmCompVO[]
	 */
	public MonEstmCompVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MonEstmCompVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sumAmt1 = (JSPUtil.getParameter(request, prefix	+ "sum_amt1", length));
			String[] sumAmt2 = (JSPUtil.getParameter(request, prefix	+ "sum_amt2", length));
			String[] sumCnt2 = (JSPUtil.getParameter(request, prefix	+ "sum_cnt2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] totalSumAmt = (JSPUtil.getParameter(request, prefix	+ "total_sum_amt", length));
			String[] sumCnt1 = (JSPUtil.getParameter(request, prefix	+ "sum_cnt1", length));
			String[] sumCntPort = (JSPUtil.getParameter(request, prefix	+ "sum_cnt_port", length));
			String[] sumActPort = (JSPUtil.getParameter(request, prefix	+ "sum_act_port", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new MonEstmCompVO();
				if (sumAmt1[i] != null)
					model.setSumAmt1(sumAmt1[i]);
				if (sumAmt2[i] != null)
					model.setSumAmt2(sumAmt2[i]);
				if (sumCnt2[i] != null)
					model.setSumCnt2(sumCnt2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (totalSumAmt[i] != null)
					model.setTotalSumAmt(totalSumAmt[i]);
				if (sumCnt1[i] != null)
					model.setSumCnt1(sumCnt1[i]);
				if (sumCntPort[i] != null)
					model.setSumCntPort(sumCntPort[i]);
				if (sumActPort[i] != null)
					model.setSumActPort(sumActPort[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMonEstmCompVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MonEstmCompVO[]
	 */
	public MonEstmCompVO[] getMonEstmCompVOs(){
		MonEstmCompVO[] vos = (MonEstmCompVO[])models.toArray(new MonEstmCompVO[models.size()]);
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
		this.sumAmt1 = this.sumAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumAmt2 = this.sumAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumCnt2 = this.sumCnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSumAmt = this.totalSumAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumCnt1 = this.sumCnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumCntPort = this.sumCntPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumActPort = this.sumActPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

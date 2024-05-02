/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CanalTzFeeHdVO.java
*@FileTitle : CanalTzFeeHdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.06.25 김진일 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo;

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
 * @author 김진일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CanalTzFeeHdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CanalTzFeeHdVO> models = new ArrayList<CanalTzFeeHdVO>();
	
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String callSeq = null;
	/* Column Info */
	private String cnlTzBztpCd = null;
	/* Column Info */
	private String calcAmtSum = null;
	/* Column Info */
	private String rqstAmtSum = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CanalTzFeeHdVO() {}

	public CanalTzFeeHdVO(String ibflag, String pagerows, String vndrSeq, String vvd, String callSeq, String cnlTzBztpCd, String rqstAmtSum, String calcAmtSum) {
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.vndrSeq = vndrSeq;
		this.callSeq = callSeq;
		this.cnlTzBztpCd = cnlTzBztpCd;
		this.calcAmtSum = calcAmtSum;
		this.rqstAmtSum = rqstAmtSum;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("call_seq", getCallSeq());
		this.hashColumns.put("cnl_tz_bztp_cd", getCnlTzBztpCd());
		this.hashColumns.put("calc_amt_sum", getCalcAmtSum());
		this.hashColumns.put("rqst_amt_sum", getRqstAmtSum());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("call_seq", "callSeq");
		this.hashFields.put("cnl_tz_bztp_cd", "cnlTzBztpCd");
		this.hashFields.put("calc_amt_sum", "calcAmtSum");
		this.hashFields.put("rqst_amt_sum", "rqstAmtSum");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return callSeq
	 */
	public String getCallSeq() {
		return this.callSeq;
	}
	
	/**
	 * Column Info
	 * @return cnlTzBztpCd
	 */
	public String getCnlTzBztpCd() {
		return this.cnlTzBztpCd;
	}
	
	/**
	 * Column Info
	 * @return calcAmtSum
	 */
	public String getCalcAmtSum() {
		return this.calcAmtSum;
	}
	
	/**
	 * Column Info
	 * @return rqstAmtSum
	 */
	public String getRqstAmtSum() {
		return this.rqstAmtSum;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param callSeq
	 */
	public void setCallSeq(String callSeq) {
		this.callSeq = callSeq;
	}
	
	/**
	 * Column Info
	 * @param cnlTzBztpCd
	 */
	public void setCnlTzBztpCd(String cnlTzBztpCd) {
		this.cnlTzBztpCd = cnlTzBztpCd;
	}
	
	/**
	 * Column Info
	 * @param calcAmtSum
	 */
	public void setCalcAmtSum(String calcAmtSum) {
		this.calcAmtSum = calcAmtSum;
	}
	
	/**
	 * Column Info
	 * @param rqstAmtSum
	 */
	public void setRqstAmtSum(String rqstAmtSum) {
		this.rqstAmtSum = rqstAmtSum;
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
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setCallSeq(JSPUtil.getParameter(request, "call_seq", ""));
		setCnlTzBztpCd(JSPUtil.getParameter(request, "cnl_tz_bztp_cd", ""));
		setCalcAmtSum(JSPUtil.getParameter(request, "calc_amt_sum", ""));
		setRqstAmtSum(JSPUtil.getParameter(request, "rqst_amt_sum", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CanalTzFeeHdVO[]
	 */
	public CanalTzFeeHdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CanalTzFeeHdVO[]
	 */
	public CanalTzFeeHdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CanalTzFeeHdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] callSeq = (JSPUtil.getParameter(request, prefix	+ "call_seq", length));
			String[] cnlTzBztpCd = (JSPUtil.getParameter(request, prefix	+ "cnl_tz_bztp_cd", length));
			String[] calcAmtSum = (JSPUtil.getParameter(request, prefix	+ "calc_amt_sum", length));
			String[] rqstAmtSum = (JSPUtil.getParameter(request, prefix	+ "rqst_amt_sum", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CanalTzFeeHdVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (callSeq[i] != null)
					model.setCallSeq(callSeq[i]);
				if (cnlTzBztpCd[i] != null)
					model.setCnlTzBztpCd(cnlTzBztpCd[i]);
				if (calcAmtSum[i] != null)
					model.setCalcAmtSum(calcAmtSum[i]);
				if (rqstAmtSum[i] != null)
					model.setRqstAmtSum(rqstAmtSum[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCanalTzFeeHdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CanalTzFeeHdVO[]
	 */
	public CanalTzFeeHdVO[] getCanalTzFeeHdVOs(){
		CanalTzFeeHdVO[] vos = (CanalTzFeeHdVO[])models.toArray(new CanalTzFeeHdVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSeq = this.callSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlTzBztpCd = this.cnlTzBztpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcAmtSum = this.calcAmtSum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstAmtSum = this.rqstAmtSum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

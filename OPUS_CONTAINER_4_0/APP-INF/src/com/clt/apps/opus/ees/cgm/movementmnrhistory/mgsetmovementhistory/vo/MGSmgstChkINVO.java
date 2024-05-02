/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CHSmgstChkINVO.java
*@FileTitle : CHSmgstChkINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.29
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2010.01.29 최민회 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo;

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
 * @author 최민회
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MGSmgstChkINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MGSmgstChkINVO> models = new ArrayList<MGSmgstChkINVO>();
	
	/* Column Info */
	private String result = null;
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String aciacDivCd = null;
	/* Column Info */
	private String mgstNo = null;
	/* Column Info */
	private String cntrTpsz = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String toDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String tpszCheck = null;
	/* Column Info */
	private String cntrNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MGSmgstChkINVO() {}

	public MGSmgstChkINVO(String ibflag, String pagerows, String result, String fromDt, String chssNo, String eqKndCd, String aciacDivCd, String mgstNo, String eqTpszCd, String toDt, String chk, String tpszCheck, String cntrNo, String cntrTpsz) {
		this.result = result;
		this.fromDt = fromDt;
		this.chssNo = chssNo;
		this.eqKndCd = eqKndCd;
		this.aciacDivCd = aciacDivCd;
		this.mgstNo = mgstNo;
		this.cntrTpsz = cntrTpsz;
		this.pagerows = pagerows;
		this.eqTpszCd = eqTpszCd;
		this.toDt = toDt;
		this.ibflag = ibflag;
		this.chk = chk;
		this.tpszCheck = tpszCheck;
		this.cntrNo = cntrNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("result", getResult());
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("aciac_div_cd", getAciacDivCd());
		this.hashColumns.put("mgst_no", getMgstNo());
		this.hashColumns.put("cntr_tpsz", getCntrTpsz());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("tpsz_check", getTpszCheck());
		this.hashColumns.put("cntr_no", getCntrNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("result", "result");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("aciac_div_cd", "aciacDivCd");
		this.hashFields.put("mgst_no", "mgstNo");
		this.hashFields.put("cntr_tpsz", "cntrTpsz");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("tpsz_check", "tpszCheck");
		this.hashFields.put("cntr_no", "cntrNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return result
	 */
	public String getResult() {
		return this.result;
	}
	
	/**
	 * Column Info
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
	}
	
	/**
	 * Column Info
	 * @return chssNo
	 */
	public String getChssNo() {
		return this.chssNo;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return aciacDivCd
	 */
	public String getAciacDivCd() {
		return this.aciacDivCd;
	}
	
	/**
	 * Column Info
	 * @return mgstNo
	 */
	public String getMgstNo() {
		return this.mgstNo;
	}
	
	/**
	 * Column Info
	 * @return cntrTpsz
	 */
	public String getCntrTpsz() {
		return this.cntrTpsz;
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
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
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
	 * @return chk
	 */
	public String getChk() {
		return this.chk;
	}
	
	/**
	 * Column Info
	 * @return tpszCheck
	 */
	public String getTpszCheck() {
		return this.tpszCheck;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	

	/**
	 * Column Info
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
	}
	
	/**
	 * Column Info
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}
	
	/**
	 * Column Info
	 * @param chssNo
	 */
	public void setChssNo(String chssNo) {
		this.chssNo = chssNo;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param aciacDivCd
	 */
	public void setAciacDivCd(String aciacDivCd) {
		this.aciacDivCd = aciacDivCd;
	}
	
	/**
	 * Column Info
	 * @param mgstNo
	 */
	public void setMgstNo(String mgstNo) {
		this.mgstNo = mgstNo;
	}
	
	/**
	 * Column Info
	 * @param cntrTpsz
	 */
	public void setCntrTpsz(String cntrTpsz) {
		this.cntrTpsz = cntrTpsz;
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
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
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
	 * @param chk
	 */
	public void setChk(String chk) {
		this.chk = chk;
	}
	
	/**
	 * Column Info
	 * @param tpszCheck
	 */
	public void setTpszCheck(String tpszCheck) {
		this.tpszCheck = tpszCheck;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
		setResult(JSPUtil.getParameter(request, prefix + "result", ""));
		setFromDt(JSPUtil.getParameter(request, prefix + "from_dt", ""));
		setChssNo(JSPUtil.getParameter(request, prefix + "chss_no", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setAciacDivCd(JSPUtil.getParameter(request, prefix + "aciac_div_cd", ""));
		setMgstNo(JSPUtil.getParameter(request, prefix + "mgst_no", ""));
		setCntrTpsz(JSPUtil.getParameter(request, prefix + "cntr_tpsz", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setChk(JSPUtil.getParameter(request, prefix + "chk", ""));
		setTpszCheck(JSPUtil.getParameter(request, prefix + "tpsz_check", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSmgstChkINVO[]
	 */
	public MGSmgstChkINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSmgstChkINVO[]
	 */
	public MGSmgstChkINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MGSmgstChkINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] result = (JSPUtil.getParameter(request, prefix	+ "result", length));
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] aciacDivCd = (JSPUtil.getParameter(request, prefix	+ "aciac_div_cd", length));
			String[] mgstNo = (JSPUtil.getParameter(request, prefix	+ "mgst_no", length));
			String[] cntrTpsz = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk", length));
			String[] tpszCheck = (JSPUtil.getParameter(request, prefix	+ "tpsz_check", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new MGSmgstChkINVO();
				if (result[i] != null)
					model.setResult(result[i]);
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (chssNo[i] != null)
					model.setChssNo(chssNo[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (aciacDivCd[i] != null)
					model.setAciacDivCd(aciacDivCd[i]);
				if (mgstNo[i] != null)
					model.setMgstNo(mgstNo[i]);
				if (cntrTpsz[i] != null)
					model.setCntrTpsz(cntrTpsz[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (tpszCheck[i] != null)
					model.setTpszCheck(tpszCheck[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSmgstChkINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSmgstChkINVO[]
	 */
	public MGSmgstChkINVO[] getCHSmgstChkINVOs(){
		MGSmgstChkINVO[] vos = (MGSmgstChkINVO[])models.toArray(new MGSmgstChkINVO[models.size()]);
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
		this.result = this.result .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aciacDivCd = this.aciacDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstNo = this.mgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpsz = this.cntrTpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszCheck = this.tpszCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

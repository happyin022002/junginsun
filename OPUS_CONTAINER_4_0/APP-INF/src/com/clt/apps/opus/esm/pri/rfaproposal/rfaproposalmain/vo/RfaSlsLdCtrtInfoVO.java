/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RfaSlsLdCtrtInfoVO.java
*@FileTitle : RfaSlsLdCtrtInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.07.31 문동규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo;

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
 * @author 문동규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RfaSlsLdCtrtInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RfaSlsLdCtrtInfoVO> models = new ArrayList<RfaSlsLdCtrtInfoVO>();
	
	/* Column Info */
	private String ctrtCustCntCd = null;
	/* Column Info */
	private String fileDt = null;
	/* Column Info */
	private String ctrtCustSeq = null;
	/* Column Info */
	private String propSrepCd = null;
	/* Column Info */
	private String fnlMqcQty = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String propOfcCd = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String custCode = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String slsLdNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RfaSlsLdCtrtInfoVO() {}

	public RfaSlsLdCtrtInfoVO(String ibflag, String pagerows, String propNo, String rfaNo, String amdtSeq, String ctrtCustCntCd, String ctrtCustSeq, String custCode, String svcScpCd, String effDt, String expDt, String propSrepCd, String propOfcCd, String slsLdNo, String fnlMqcQty, String fileDt) {
		this.ctrtCustCntCd = ctrtCustCntCd;
		this.fileDt = fileDt;
		this.ctrtCustSeq = ctrtCustSeq;
		this.propSrepCd = propSrepCd;
		this.fnlMqcQty = fnlMqcQty;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.pagerows = pagerows;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.propOfcCd = propOfcCd;
		this.propNo = propNo;
		this.custCode = custCode;
		this.expDt = expDt;
		this.slsLdNo = slsLdNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ctrt_cust_cnt_cd", getCtrtCustCntCd());
		this.hashColumns.put("file_dt", getFileDt());
		this.hashColumns.put("ctrt_cust_seq", getCtrtCustSeq());
		this.hashColumns.put("prop_srep_cd", getPropSrepCd());
		this.hashColumns.put("fnl_mqc_qty", getFnlMqcQty());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("prop_ofc_cd", getPropOfcCd());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("cust_code", getCustCode());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("sls_ld_no", getSlsLdNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ctrt_cust_cnt_cd", "ctrtCustCntCd");
		this.hashFields.put("file_dt", "fileDt");
		this.hashFields.put("ctrt_cust_seq", "ctrtCustSeq");
		this.hashFields.put("prop_srep_cd", "propSrepCd");
		this.hashFields.put("fnl_mqc_qty", "fnlMqcQty");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("prop_ofc_cd", "propOfcCd");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("cust_code", "custCode");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("sls_ld_no", "slsLdNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustCntCd
	 */
	public String getCtrtCustCntCd() {
		return this.ctrtCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return fileDt
	 */
	public String getFileDt() {
		return this.fileDt;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustSeq
	 */
	public String getCtrtCustSeq() {
		return this.ctrtCustSeq;
	}
	
	/**
	 * Column Info
	 * @return propSrepCd
	 */
	public String getPropSrepCd() {
		return this.propSrepCd;
	}
	
	/**
	 * Column Info
	 * @return fnlMqcQty
	 */
	public String getFnlMqcQty() {
		return this.fnlMqcQty;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
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
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return propOfcCd
	 */
	public String getPropOfcCd() {
		return this.propOfcCd;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return custCode
	 */
	public String getCustCode() {
		return this.custCode;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return slsLdNo
	 */
	public String getSlsLdNo() {
		return this.slsLdNo;
	}
	

	/**
	 * Column Info
	 * @param ctrtCustCntCd
	 */
	public void setCtrtCustCntCd(String ctrtCustCntCd) {
		this.ctrtCustCntCd = ctrtCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param fileDt
	 */
	public void setFileDt(String fileDt) {
		this.fileDt = fileDt;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustSeq
	 */
	public void setCtrtCustSeq(String ctrtCustSeq) {
		this.ctrtCustSeq = ctrtCustSeq;
	}
	
	/**
	 * Column Info
	 * @param propSrepCd
	 */
	public void setPropSrepCd(String propSrepCd) {
		this.propSrepCd = propSrepCd;
	}
	
	/**
	 * Column Info
	 * @param fnlMqcQty
	 */
	public void setFnlMqcQty(String fnlMqcQty) {
		this.fnlMqcQty = fnlMqcQty;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
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
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param propOfcCd
	 */
	public void setPropOfcCd(String propOfcCd) {
		this.propOfcCd = propOfcCd;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param custCode
	 */
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param slsLdNo
	 */
	public void setSlsLdNo(String slsLdNo) {
		this.slsLdNo = slsLdNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCtrtCustCntCd(JSPUtil.getParameter(request, "ctrt_cust_cnt_cd", ""));
		setFileDt(JSPUtil.getParameter(request, "file_dt", ""));
		setCtrtCustSeq(JSPUtil.getParameter(request, "ctrt_cust_seq", ""));
		setPropSrepCd(JSPUtil.getParameter(request, "prop_srep_cd", ""));
		setFnlMqcQty(JSPUtil.getParameter(request, "fnl_mqc_qty", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setPropOfcCd(JSPUtil.getParameter(request, "prop_ofc_cd", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setCustCode(JSPUtil.getParameter(request, "cust_code", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setSlsLdNo(JSPUtil.getParameter(request, "sls_ld_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RfaSlsLdCtrtInfoVO[]
	 */
	public RfaSlsLdCtrtInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RfaSlsLdCtrtInfoVO[]
	 */
	public RfaSlsLdCtrtInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RfaSlsLdCtrtInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ctrtCustCntCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_cnt_cd", length));
			String[] fileDt = (JSPUtil.getParameter(request, prefix	+ "file_dt", length));
			String[] ctrtCustSeq = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_seq", length));
			String[] propSrepCd = (JSPUtil.getParameter(request, prefix	+ "prop_srep_cd", length));
			String[] fnlMqcQty = (JSPUtil.getParameter(request, prefix	+ "fnl_mqc_qty", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] propOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_ofc_cd", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] custCode = (JSPUtil.getParameter(request, prefix	+ "cust_code", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] slsLdNo = (JSPUtil.getParameter(request, prefix	+ "sls_ld_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new RfaSlsLdCtrtInfoVO();
				if (ctrtCustCntCd[i] != null)
					model.setCtrtCustCntCd(ctrtCustCntCd[i]);
				if (fileDt[i] != null)
					model.setFileDt(fileDt[i]);
				if (ctrtCustSeq[i] != null)
					model.setCtrtCustSeq(ctrtCustSeq[i]);
				if (propSrepCd[i] != null)
					model.setPropSrepCd(propSrepCd[i]);
				if (fnlMqcQty[i] != null)
					model.setFnlMqcQty(fnlMqcQty[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (propOfcCd[i] != null)
					model.setPropOfcCd(propOfcCd[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (custCode[i] != null)
					model.setCustCode(custCode[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (slsLdNo[i] != null)
					model.setSlsLdNo(slsLdNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRfaSlsLdCtrtInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RfaSlsLdCtrtInfoVO[]
	 */
	public RfaSlsLdCtrtInfoVO[] getRfaSlsLdCtrtInfoVOs(){
		RfaSlsLdCtrtInfoVO[] vos = (RfaSlsLdCtrtInfoVO[])models.toArray(new RfaSlsLdCtrtInfoVO[models.size()]);
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
		this.ctrtCustCntCd = this.ctrtCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDt = this.fileDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSeq = this.ctrtCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propSrepCd = this.propSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlMqcQty = this.fnlMqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propOfcCd = this.propOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCode = this.custCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsLdNo = this.slsLdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

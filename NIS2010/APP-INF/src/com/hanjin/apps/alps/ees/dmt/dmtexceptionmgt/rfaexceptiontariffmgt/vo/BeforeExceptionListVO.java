/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BeforeExceptionListVO.java
*@FileTitle : BeforeExceptionListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.25  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo;

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

public class BeforeExceptionListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BeforeExceptionListVO> models = new ArrayList<BeforeExceptionListVO>();
	
	/* Column Info */
	private String apvlDt = null;
	/* Column Info */
	private String reqOfcCd = null;
	/* Column Info */
	private String rfaExptAproNo = null;
	/* Column Info */
	private String reqUsrNm = null;
	/* Column Info */
	private String reqDt = null;
	/* Column Info */
	private String aproOfcCd = null;
	/* Column Info */
	private String dmdtExptRqstStsDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rfaExptMapgSeq = null;
	/* Column Info */
	private String rfaExptDarNo = null;
	/* Column Info */
	private String apvlUsrNm = null;
	/* Column Info */
	private String rfaExptVerSeq = null;
	/* Column Info */
	private String apvlOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BeforeExceptionListVO() {}

	public BeforeExceptionListVO(String ibflag, String pagerows, String rfaNo, String aproOfcCd, String rfaExptDarNo, String rfaExptMapgSeq, String rfaExptVerSeq, String rfaExptAproNo, String dmdtExptRqstStsDesc, String reqOfcCd, String reqUsrNm, String reqDt, String apvlOfcCd, String apvlUsrNm, String apvlDt) {
		this.apvlDt = apvlDt;
		this.reqOfcCd = reqOfcCd;
		this.rfaExptAproNo = rfaExptAproNo;
		this.reqUsrNm = reqUsrNm;
		this.reqDt = reqDt;
		this.aproOfcCd = aproOfcCd;
		this.dmdtExptRqstStsDesc = dmdtExptRqstStsDesc;
		this.pagerows = pagerows;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.rfaExptMapgSeq = rfaExptMapgSeq;
		this.rfaExptDarNo = rfaExptDarNo;
		this.apvlUsrNm = apvlUsrNm;
		this.rfaExptVerSeq = rfaExptVerSeq;
		this.apvlOfcCd = apvlOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("apvl_dt", getApvlDt());
		this.hashColumns.put("req_ofc_cd", getReqOfcCd());
		this.hashColumns.put("rfa_expt_apro_no", getRfaExptAproNo());
		this.hashColumns.put("req_usr_nm", getReqUsrNm());
		this.hashColumns.put("req_dt", getReqDt());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("dmdt_expt_rqst_sts_desc", getDmdtExptRqstStsDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rfa_expt_mapg_seq", getRfaExptMapgSeq());
		this.hashColumns.put("rfa_expt_dar_no", getRfaExptDarNo());
		this.hashColumns.put("apvl_usr_nm", getApvlUsrNm());
		this.hashColumns.put("rfa_expt_ver_seq", getRfaExptVerSeq());
		this.hashColumns.put("apvl_ofc_cd", getApvlOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("apvl_dt", "apvlDt");
		this.hashFields.put("req_ofc_cd", "reqOfcCd");
		this.hashFields.put("rfa_expt_apro_no", "rfaExptAproNo");
		this.hashFields.put("req_usr_nm", "reqUsrNm");
		this.hashFields.put("req_dt", "reqDt");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("dmdt_expt_rqst_sts_desc", "dmdtExptRqstStsDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rfa_expt_mapg_seq", "rfaExptMapgSeq");
		this.hashFields.put("rfa_expt_dar_no", "rfaExptDarNo");
		this.hashFields.put("apvl_usr_nm", "apvlUsrNm");
		this.hashFields.put("rfa_expt_ver_seq", "rfaExptVerSeq");
		this.hashFields.put("apvl_ofc_cd", "apvlOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return apvlDt
	 */
	public String getApvlDt() {
		return this.apvlDt;
	}
	
	/**
	 * Column Info
	 * @return reqOfcCd
	 */
	public String getReqOfcCd() {
		return this.reqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rfaExptAproNo
	 */
	public String getRfaExptAproNo() {
		return this.rfaExptAproNo;
	}
	
	/**
	 * Column Info
	 * @return reqUsrNm
	 */
	public String getReqUsrNm() {
		return this.reqUsrNm;
	}
	
	/**
	 * Column Info
	 * @return reqDt
	 */
	public String getReqDt() {
		return this.reqDt;
	}
	
	/**
	 * Column Info
	 * @return aproOfcCd
	 */
	public String getAproOfcCd() {
		return this.aproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtExptRqstStsDesc
	 */
	public String getDmdtExptRqstStsDesc() {
		return this.dmdtExptRqstStsDesc;
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
	 * @return rfaExptMapgSeq
	 */
	public String getRfaExptMapgSeq() {
		return this.rfaExptMapgSeq;
	}
	
	/**
	 * Column Info
	 * @return rfaExptDarNo
	 */
	public String getRfaExptDarNo() {
		return this.rfaExptDarNo;
	}
	
	/**
	 * Column Info
	 * @return apvlUsrNm
	 */
	public String getApvlUsrNm() {
		return this.apvlUsrNm;
	}
	
	/**
	 * Column Info
	 * @return rfaExptVerSeq
	 */
	public String getRfaExptVerSeq() {
		return this.rfaExptVerSeq;
	}
	
	/**
	 * Column Info
	 * @return apvlOfcCd
	 */
	public String getApvlOfcCd() {
		return this.apvlOfcCd;
	}
	

	/**
	 * Column Info
	 * @param apvlDt
	 */
	public void setApvlDt(String apvlDt) {
		this.apvlDt = apvlDt;
	}
	
	/**
	 * Column Info
	 * @param reqOfcCd
	 */
	public void setReqOfcCd(String reqOfcCd) {
		this.reqOfcCd = reqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rfaExptAproNo
	 */
	public void setRfaExptAproNo(String rfaExptAproNo) {
		this.rfaExptAproNo = rfaExptAproNo;
	}
	
	/**
	 * Column Info
	 * @param reqUsrNm
	 */
	public void setReqUsrNm(String reqUsrNm) {
		this.reqUsrNm = reqUsrNm;
	}
	
	/**
	 * Column Info
	 * @param reqDt
	 */
	public void setReqDt(String reqDt) {
		this.reqDt = reqDt;
	}
	
	/**
	 * Column Info
	 * @param aproOfcCd
	 */
	public void setAproOfcCd(String aproOfcCd) {
		this.aproOfcCd = aproOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtExptRqstStsDesc
	 */
	public void setDmdtExptRqstStsDesc(String dmdtExptRqstStsDesc) {
		this.dmdtExptRqstStsDesc = dmdtExptRqstStsDesc;
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
	 * @param rfaExptMapgSeq
	 */
	public void setRfaExptMapgSeq(String rfaExptMapgSeq) {
		this.rfaExptMapgSeq = rfaExptMapgSeq;
	}
	
	/**
	 * Column Info
	 * @param rfaExptDarNo
	 */
	public void setRfaExptDarNo(String rfaExptDarNo) {
		this.rfaExptDarNo = rfaExptDarNo;
	}
	
	/**
	 * Column Info
	 * @param apvlUsrNm
	 */
	public void setApvlUsrNm(String apvlUsrNm) {
		this.apvlUsrNm = apvlUsrNm;
	}
	
	/**
	 * Column Info
	 * @param rfaExptVerSeq
	 */
	public void setRfaExptVerSeq(String rfaExptVerSeq) {
		this.rfaExptVerSeq = rfaExptVerSeq;
	}
	
	/**
	 * Column Info
	 * @param apvlOfcCd
	 */
	public void setApvlOfcCd(String apvlOfcCd) {
		this.apvlOfcCd = apvlOfcCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setApvlDt(JSPUtil.getParameter(request, "apvl_dt", ""));
		setReqOfcCd(JSPUtil.getParameter(request, "req_ofc_cd", ""));
		setRfaExptAproNo(JSPUtil.getParameter(request, "rfa_expt_apro_no", ""));
		setReqUsrNm(JSPUtil.getParameter(request, "req_usr_nm", ""));
		setReqDt(JSPUtil.getParameter(request, "req_dt", ""));
		setAproOfcCd(JSPUtil.getParameter(request, "apro_ofc_cd", ""));
		setDmdtExptRqstStsDesc(JSPUtil.getParameter(request, "dmdt_expt_rqst_sts_desc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRfaExptMapgSeq(JSPUtil.getParameter(request, "rfa_expt_mapg_seq", ""));
		setRfaExptDarNo(JSPUtil.getParameter(request, "rfa_expt_dar_no", ""));
		setApvlUsrNm(JSPUtil.getParameter(request, "apvl_usr_nm", ""));
		setRfaExptVerSeq(JSPUtil.getParameter(request, "rfa_expt_ver_seq", ""));
		setApvlOfcCd(JSPUtil.getParameter(request, "apvl_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BeforeExceptionListVO[]
	 */
	public BeforeExceptionListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BeforeExceptionListVO[]
	 */
	public BeforeExceptionListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BeforeExceptionListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] apvlDt = (JSPUtil.getParameter(request, prefix	+ "apvl_dt", length));
			String[] reqOfcCd = (JSPUtil.getParameter(request, prefix	+ "req_ofc_cd", length));
			String[] rfaExptAproNo = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_apro_no", length));
			String[] reqUsrNm = (JSPUtil.getParameter(request, prefix	+ "req_usr_nm", length));
			String[] reqDt = (JSPUtil.getParameter(request, prefix	+ "req_dt", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] dmdtExptRqstStsDesc = (JSPUtil.getParameter(request, prefix	+ "dmdt_expt_rqst_sts_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rfaExptMapgSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_mapg_seq", length));
			String[] rfaExptDarNo = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_dar_no", length));
			String[] apvlUsrNm = (JSPUtil.getParameter(request, prefix	+ "apvl_usr_nm", length));
			String[] rfaExptVerSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_ver_seq", length));
			String[] apvlOfcCd = (JSPUtil.getParameter(request, prefix	+ "apvl_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BeforeExceptionListVO();
				if (apvlDt[i] != null)
					model.setApvlDt(apvlDt[i]);
				if (reqOfcCd[i] != null)
					model.setReqOfcCd(reqOfcCd[i]);
				if (rfaExptAproNo[i] != null)
					model.setRfaExptAproNo(rfaExptAproNo[i]);
				if (reqUsrNm[i] != null)
					model.setReqUsrNm(reqUsrNm[i]);
				if (reqDt[i] != null)
					model.setReqDt(reqDt[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (dmdtExptRqstStsDesc[i] != null)
					model.setDmdtExptRqstStsDesc(dmdtExptRqstStsDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rfaExptMapgSeq[i] != null)
					model.setRfaExptMapgSeq(rfaExptMapgSeq[i]);
				if (rfaExptDarNo[i] != null)
					model.setRfaExptDarNo(rfaExptDarNo[i]);
				if (apvlUsrNm[i] != null)
					model.setApvlUsrNm(apvlUsrNm[i]);
				if (rfaExptVerSeq[i] != null)
					model.setRfaExptVerSeq(rfaExptVerSeq[i]);
				if (apvlOfcCd[i] != null)
					model.setApvlOfcCd(apvlOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBeforeExceptionListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BeforeExceptionListVO[]
	 */
	public BeforeExceptionListVO[] getBeforeExceptionListVOs(){
		BeforeExceptionListVO[] vos = (BeforeExceptionListVO[])models.toArray(new BeforeExceptionListVO[models.size()]);
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
		this.apvlDt = this.apvlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqOfcCd = this.reqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptAproNo = this.rfaExptAproNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqUsrNm = this.reqUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqDt = this.reqDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtExptRqstStsDesc = this.dmdtExptRqstStsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptMapgSeq = this.rfaExptMapgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptDarNo = this.rfaExptDarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apvlUsrNm = this.apvlUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptVerSeq = this.rfaExptVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apvlOfcCd = this.apvlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

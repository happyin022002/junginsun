/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AddSceEdiHisDtlLogVO.java
*@FileTitle : AddSceEdiHisDtlLogVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.10.27 전병석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.edi315send.vo;

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
 * @author 전병석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AddSceEdiHisDtlLogVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AddSceEdiHisDtlLogVO> models = new ArrayList<AddSceEdiHisDtlLogVO>();
	
	/* Column Info */
	private String mvmtSts = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String rcvSeq = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String ediStatus = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String copActCd = null;
	/* Column Info */
	private String rsltRmk = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String rcvDtlSeq = null;
	/* Column Info */
	private String custStatus = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AddSceEdiHisDtlLogVO() {}

	public AddSceEdiHisDtlLogVO(String ibflag, String pagerows, String rcvDt, String rcvSeq, String rcvDtlSeq, String bkgNo, String blNo, String cntrNo, String copNo, String ediStatus, String custStatus, String mvmtSts, String copActCd, String rsltRmk) {
		this.mvmtSts = mvmtSts;
		this.copNo = copNo;
		this.rcvSeq = rcvSeq;
		this.blNo = blNo;
		this.ediStatus = ediStatus;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.copActCd = copActCd;
		this.rsltRmk = rsltRmk;
		this.rcvDt = rcvDt;
		this.cntrNo = cntrNo;
		this.rcvDtlSeq = rcvDtlSeq;
		this.custStatus = custStatus;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mvmt_sts", getMvmtSts());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("rcv_seq", getRcvSeq());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("edi_status", getEdiStatus());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cop_act_cd", getCopActCd());
		this.hashColumns.put("rslt_rmk", getRsltRmk());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("rcv_dtl_seq", getRcvDtlSeq());
		this.hashColumns.put("cust_status", getCustStatus());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mvmt_sts", "mvmtSts");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("rcv_seq", "rcvSeq");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("edi_status", "ediStatus");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cop_act_cd", "copActCd");
		this.hashFields.put("rslt_rmk", "rsltRmk");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("rcv_dtl_seq", "rcvDtlSeq");
		this.hashFields.put("cust_status", "custStatus");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mvmtSts
	 */
	public String getMvmtSts() {
		return this.mvmtSts;
	}
	
	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return rcvSeq
	 */
	public String getRcvSeq() {
		return this.rcvSeq;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return ediStatus
	 */
	public String getEdiStatus() {
		return this.ediStatus;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return copActCd
	 */
	public String getCopActCd() {
		return this.copActCd;
	}
	
	/**
	 * Column Info
	 * @return rsltRmk
	 */
	public String getRsltRmk() {
		return this.rsltRmk;
	}
	
	/**
	 * Column Info
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
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
	 * @return rcvDtlSeq
	 */
	public String getRcvDtlSeq() {
		return this.rcvDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return custStatus
	 */
	public String getCustStatus() {
		return this.custStatus;
	}
	

	/**
	 * Column Info
	 * @param mvmtSts
	 */
	public void setMvmtSts(String mvmtSts) {
		this.mvmtSts = mvmtSts;
	}
	
	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param rcvSeq
	 */
	public void setRcvSeq(String rcvSeq) {
		this.rcvSeq = rcvSeq;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param ediStatus
	 */
	public void setEdiStatus(String ediStatus) {
		this.ediStatus = ediStatus;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param copActCd
	 */
	public void setCopActCd(String copActCd) {
		this.copActCd = copActCd;
	}
	
	/**
	 * Column Info
	 * @param rsltRmk
	 */
	public void setRsltRmk(String rsltRmk) {
		this.rsltRmk = rsltRmk;
	}
	
	/**
	 * Column Info
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param rcvDtlSeq
	 */
	public void setRcvDtlSeq(String rcvDtlSeq) {
		this.rcvDtlSeq = rcvDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param custStatus
	 */
	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setMvmtSts(JSPUtil.getParameter(request, "mvmt_sts", ""));
		setCopNo(JSPUtil.getParameter(request, "cop_no", ""));
		setRcvSeq(JSPUtil.getParameter(request, "rcv_seq", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setEdiStatus(JSPUtil.getParameter(request, "edi_status", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCopActCd(JSPUtil.getParameter(request, "cop_act_cd", ""));
		setRsltRmk(JSPUtil.getParameter(request, "rslt_rmk", ""));
		setRcvDt(JSPUtil.getParameter(request, "rcv_dt", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setRcvDtlSeq(JSPUtil.getParameter(request, "rcv_dtl_seq", ""));
		setCustStatus(JSPUtil.getParameter(request, "cust_status", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AddSceEdiHisDtlLogVO[]
	 */
	public AddSceEdiHisDtlLogVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AddSceEdiHisDtlLogVO[]
	 */
	public AddSceEdiHisDtlLogVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AddSceEdiHisDtlLogVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mvmtSts = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] rcvSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_seq", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] ediStatus = (JSPUtil.getParameter(request, prefix	+ "edi_status", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] copActCd = (JSPUtil.getParameter(request, prefix	+ "cop_act_cd", length));
			String[] rsltRmk = (JSPUtil.getParameter(request, prefix	+ "rslt_rmk", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] rcvDtlSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_dtl_seq", length));
			String[] custStatus = (JSPUtil.getParameter(request, prefix	+ "cust_status", length));
			
			for (int i = 0; i < length; i++) {
				model = new AddSceEdiHisDtlLogVO();
				if (mvmtSts[i] != null)
					model.setMvmtSts(mvmtSts[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (rcvSeq[i] != null)
					model.setRcvSeq(rcvSeq[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (ediStatus[i] != null)
					model.setEdiStatus(ediStatus[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (copActCd[i] != null)
					model.setCopActCd(copActCd[i]);
				if (rsltRmk[i] != null)
					model.setRsltRmk(rsltRmk[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (rcvDtlSeq[i] != null)
					model.setRcvDtlSeq(rcvDtlSeq[i]);
				if (custStatus[i] != null)
					model.setCustStatus(custStatus[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAddSceEdiHisDtlLogVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AddSceEdiHisDtlLogVO[]
	 */
	public AddSceEdiHisDtlLogVO[] getAddSceEdiHisDtlLogVOs(){
		AddSceEdiHisDtlLogVO[] vos = (AddSceEdiHisDtlLogVO[])models.toArray(new AddSceEdiHisDtlLogVO[models.size()]);
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
		this.mvmtSts = this.mvmtSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvSeq = this.rcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediStatus = this.ediStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copActCd = this.copActCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltRmk = this.rsltRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDtlSeq = this.rcvDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custStatus = this.custStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

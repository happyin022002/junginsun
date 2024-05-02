/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Multi01USA404EDIStatusInquiryVO.java
*@FileTitle : Multi01USA404EDIStatusInquiryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 최진오
*@LastVersion : 1.0
* 2009.09.02 최진오 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.vo;

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
 * @author 최진오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Multi01USA404EDIStatusInquiryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Multi01USA404EDIStatusInquiryVO> models = new ArrayList<Multi01USA404EDIStatusInquiryVO>();
	
	/* Column Info */
	private String shprCustNm = null;
	/* Column Info */
	private String rltTrkrFaxNo = null;
	/* Column Info */
	private String sndOfcCd = null;
	/* Column Info */
	private String trspSoSeq = null;
	/* Column Info */
	private String sndYn = null;
	/* Column Info */
	private String rltTrkrSeq = null;
	/* Column Info */
	private String msgTpCd = null;
	/* Column Info */
	private String rltTrkrEml = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String shprEml = null;
	/* Column Info */
	private String sndTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* Column Info */
	private String sndUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sndSeq = null;
	/* Column Info */
	private String rltTrkrNm = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String shprFaxNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Multi01USA404EDIStatusInquiryVO() {}

	public Multi01USA404EDIStatusInquiryVO(String ibflag, String pagerows, String eqNo, String eqTpszCd, String trspSoOfcCtyCd, String trspSoSeq, String sndSeq, String msgTpCd, String sndTpCd, String rltTrkrSeq, String rltTrkrNm, String rltTrkrFaxNo, String rltTrkrEml, String shprCustNm, String shprFaxNo, String shprEml, String sndDt, String sndOfcCd, String sndUsrId, String sndYn) {
		this.shprCustNm = shprCustNm;
		this.rltTrkrFaxNo = rltTrkrFaxNo;
		this.sndOfcCd = sndOfcCd;
		this.trspSoSeq = trspSoSeq;
		this.sndYn = sndYn;
		this.rltTrkrSeq = rltTrkrSeq;
		this.msgTpCd = msgTpCd;
		this.rltTrkrEml = rltTrkrEml;
		this.sndDt = sndDt;
		this.shprEml = shprEml;
		this.sndTpCd = sndTpCd;
		this.pagerows = pagerows;
		this.eqTpszCd = eqTpszCd;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.sndUsrId = sndUsrId;
		this.ibflag = ibflag;
		this.sndSeq = sndSeq;
		this.rltTrkrNm = rltTrkrNm;
		this.eqNo = eqNo;
		this.shprFaxNo = shprFaxNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("shpr_cust_nm", getShprCustNm());
		this.hashColumns.put("rlt_trkr_fax_no", getRltTrkrFaxNo());
		this.hashColumns.put("snd_ofc_cd", getSndOfcCd());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("snd_yn", getSndYn());
		this.hashColumns.put("rlt_trkr_seq", getRltTrkrSeq());
		this.hashColumns.put("msg_tp_cd", getMsgTpCd());
		this.hashColumns.put("rlt_trkr_eml", getRltTrkrEml());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("shpr_eml", getShprEml());
		this.hashColumns.put("snd_tp_cd", getSndTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("snd_usr_id", getSndUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("snd_seq", getSndSeq());
		this.hashColumns.put("rlt_trkr_nm", getRltTrkrNm());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("shpr_fax_no", getShprFaxNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("shpr_cust_nm", "shprCustNm");
		this.hashFields.put("rlt_trkr_fax_no", "rltTrkrFaxNo");
		this.hashFields.put("snd_ofc_cd", "sndOfcCd");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("snd_yn", "sndYn");
		this.hashFields.put("rlt_trkr_seq", "rltTrkrSeq");
		this.hashFields.put("msg_tp_cd", "msgTpCd");
		this.hashFields.put("rlt_trkr_eml", "rltTrkrEml");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("shpr_eml", "shprEml");
		this.hashFields.put("snd_tp_cd", "sndTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("snd_usr_id", "sndUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("snd_seq", "sndSeq");
		this.hashFields.put("rlt_trkr_nm", "rltTrkrNm");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("shpr_fax_no", "shprFaxNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return shprCustNm
	 */
	public String getShprCustNm() {
		return this.shprCustNm;
	}
	
	/**
	 * Column Info
	 * @return rltTrkrFaxNo
	 */
	public String getRltTrkrFaxNo() {
		return this.rltTrkrFaxNo;
	}
	
	/**
	 * Column Info
	 * @return sndOfcCd
	 */
	public String getSndOfcCd() {
		return this.sndOfcCd;
	}
	
	/**
	 * Column Info
	 * @return trspSoSeq
	 */
	public String getTrspSoSeq() {
		return this.trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @return sndYn
	 */
	public String getSndYn() {
		return this.sndYn;
	}
	
	/**
	 * Column Info
	 * @return rltTrkrSeq
	 */
	public String getRltTrkrSeq() {
		return this.rltTrkrSeq;
	}
	
	/**
	 * Column Info
	 * @return msgTpCd
	 */
	public String getMsgTpCd() {
		return this.msgTpCd;
	}
	
	/**
	 * Column Info
	 * @return rltTrkrEml
	 */
	public String getRltTrkrEml() {
		return this.rltTrkrEml;
	}
	
	/**
	 * Column Info
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
	}
	
	/**
	 * Column Info
	 * @return shprEml
	 */
	public String getShprEml() {
		return this.shprEml;
	}
	
	/**
	 * Column Info
	 * @return sndTpCd
	 */
	public String getSndTpCd() {
		return this.sndTpCd;
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
	 * @return trspSoOfcCtyCd
	 */
	public String getTrspSoOfcCtyCd() {
		return this.trspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return sndUsrId
	 */
	public String getSndUsrId() {
		return this.sndUsrId;
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
	 * @return sndSeq
	 */
	public String getSndSeq() {
		return this.sndSeq;
	}
	
	/**
	 * Column Info
	 * @return rltTrkrNm
	 */
	public String getRltTrkrNm() {
		return this.rltTrkrNm;
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
	 * @return shprFaxNo
	 */
	public String getShprFaxNo() {
		return this.shprFaxNo;
	}
	

	/**
	 * Column Info
	 * @param shprCustNm
	 */
	public void setShprCustNm(String shprCustNm) {
		this.shprCustNm = shprCustNm;
	}
	
	/**
	 * Column Info
	 * @param rltTrkrFaxNo
	 */
	public void setRltTrkrFaxNo(String rltTrkrFaxNo) {
		this.rltTrkrFaxNo = rltTrkrFaxNo;
	}
	
	/**
	 * Column Info
	 * @param sndOfcCd
	 */
	public void setSndOfcCd(String sndOfcCd) {
		this.sndOfcCd = sndOfcCd;
	}
	
	/**
	 * Column Info
	 * @param trspSoSeq
	 */
	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @param sndYn
	 */
	public void setSndYn(String sndYn) {
		this.sndYn = sndYn;
	}
	
	/**
	 * Column Info
	 * @param rltTrkrSeq
	 */
	public void setRltTrkrSeq(String rltTrkrSeq) {
		this.rltTrkrSeq = rltTrkrSeq;
	}
	
	/**
	 * Column Info
	 * @param msgTpCd
	 */
	public void setMsgTpCd(String msgTpCd) {
		this.msgTpCd = msgTpCd;
	}
	
	/**
	 * Column Info
	 * @param rltTrkrEml
	 */
	public void setRltTrkrEml(String rltTrkrEml) {
		this.rltTrkrEml = rltTrkrEml;
	}
	
	/**
	 * Column Info
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
	}
	
	/**
	 * Column Info
	 * @param shprEml
	 */
	public void setShprEml(String shprEml) {
		this.shprEml = shprEml;
	}
	
	/**
	 * Column Info
	 * @param sndTpCd
	 */
	public void setSndTpCd(String sndTpCd) {
		this.sndTpCd = sndTpCd;
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
	 * @param trspSoOfcCtyCd
	 */
	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param sndUsrId
	 */
	public void setSndUsrId(String sndUsrId) {
		this.sndUsrId = sndUsrId;
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
	 * @param sndSeq
	 */
	public void setSndSeq(String sndSeq) {
		this.sndSeq = sndSeq;
	}
	
	/**
	 * Column Info
	 * @param rltTrkrNm
	 */
	public void setRltTrkrNm(String rltTrkrNm) {
		this.rltTrkrNm = rltTrkrNm;
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
	 * @param shprFaxNo
	 */
	public void setShprFaxNo(String shprFaxNo) {
		this.shprFaxNo = shprFaxNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setShprCustNm(JSPUtil.getParameter(request, "shpr_cust_nm", ""));
		setRltTrkrFaxNo(JSPUtil.getParameter(request, "rlt_trkr_fax_no", ""));
		setSndOfcCd(JSPUtil.getParameter(request, "snd_ofc_cd", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, "trsp_so_seq", ""));
		setSndYn(JSPUtil.getParameter(request, "snd_yn", ""));
		setRltTrkrSeq(JSPUtil.getParameter(request, "rlt_trkr_seq", ""));
		setMsgTpCd(JSPUtil.getParameter(request, "msg_tp_cd", ""));
		setRltTrkrEml(JSPUtil.getParameter(request, "rlt_trkr_eml", ""));
		setSndDt(JSPUtil.getParameter(request, "snd_dt", ""));
		setShprEml(JSPUtil.getParameter(request, "shpr_eml", ""));
		setSndTpCd(JSPUtil.getParameter(request, "snd_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, "trsp_so_ofc_cty_cd", ""));
		setSndUsrId(JSPUtil.getParameter(request, "snd_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSndSeq(JSPUtil.getParameter(request, "snd_seq", ""));
		setRltTrkrNm(JSPUtil.getParameter(request, "rlt_trkr_nm", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setShprFaxNo(JSPUtil.getParameter(request, "shpr_fax_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Multi01USA404EDIStatusInquiryVO[]
	 */
	public Multi01USA404EDIStatusInquiryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Multi01USA404EDIStatusInquiryVO[]
	 */
	public Multi01USA404EDIStatusInquiryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Multi01USA404EDIStatusInquiryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] shprCustNm = (JSPUtil.getParameter(request, prefix	+ "shpr_cust_nm", length));
			String[] rltTrkrFaxNo = (JSPUtil.getParameter(request, prefix	+ "rlt_trkr_fax_no", length));
			String[] sndOfcCd = (JSPUtil.getParameter(request, prefix	+ "snd_ofc_cd", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_seq", length));
			String[] sndYn = (JSPUtil.getParameter(request, prefix	+ "snd_yn", length));
			String[] rltTrkrSeq = (JSPUtil.getParameter(request, prefix	+ "rlt_trkr_seq", length));
			String[] msgTpCd = (JSPUtil.getParameter(request, prefix	+ "msg_tp_cd", length));
			String[] rltTrkrEml = (JSPUtil.getParameter(request, prefix	+ "rlt_trkr_eml", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] shprEml = (JSPUtil.getParameter(request, prefix	+ "shpr_eml", length));
			String[] sndTpCd = (JSPUtil.getParameter(request, prefix	+ "snd_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd", length));
			String[] sndUsrId = (JSPUtil.getParameter(request, prefix	+ "snd_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sndSeq = (JSPUtil.getParameter(request, prefix	+ "snd_seq", length));
			String[] rltTrkrNm = (JSPUtil.getParameter(request, prefix	+ "rlt_trkr_nm", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] shprFaxNo = (JSPUtil.getParameter(request, prefix	+ "shpr_fax_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new Multi01USA404EDIStatusInquiryVO();
				if (shprCustNm[i] != null)
					model.setShprCustNm(shprCustNm[i]);
				if (rltTrkrFaxNo[i] != null)
					model.setRltTrkrFaxNo(rltTrkrFaxNo[i]);
				if (sndOfcCd[i] != null)
					model.setSndOfcCd(sndOfcCd[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (sndYn[i] != null)
					model.setSndYn(sndYn[i]);
				if (rltTrkrSeq[i] != null)
					model.setRltTrkrSeq(rltTrkrSeq[i]);
				if (msgTpCd[i] != null)
					model.setMsgTpCd(msgTpCd[i]);
				if (rltTrkrEml[i] != null)
					model.setRltTrkrEml(rltTrkrEml[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (shprEml[i] != null)
					model.setShprEml(shprEml[i]);
				if (sndTpCd[i] != null)
					model.setSndTpCd(sndTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (sndUsrId[i] != null)
					model.setSndUsrId(sndUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sndSeq[i] != null)
					model.setSndSeq(sndSeq[i]);
				if (rltTrkrNm[i] != null)
					model.setRltTrkrNm(rltTrkrNm[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (shprFaxNo[i] != null)
					model.setShprFaxNo(shprFaxNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMulti01USA404EDIStatusInquiryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Multi01USA404EDIStatusInquiryVO[]
	 */
	public Multi01USA404EDIStatusInquiryVO[] getMulti01USA404EDIStatusInquiryVOs(){
		Multi01USA404EDIStatusInquiryVO[] vos = (Multi01USA404EDIStatusInquiryVO[])models.toArray(new Multi01USA404EDIStatusInquiryVO[models.size()]);
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
		this.shprCustNm = this.shprCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rltTrkrFaxNo = this.rltTrkrFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndOfcCd = this.sndOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndYn = this.sndYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rltTrkrSeq = this.rltTrkrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgTpCd = this.msgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rltTrkrEml = this.rltTrkrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprEml = this.shprEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndTpCd = this.sndTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrId = this.sndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndSeq = this.sndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rltTrkrNm = this.rltTrkrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprFaxNo = this.shprFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

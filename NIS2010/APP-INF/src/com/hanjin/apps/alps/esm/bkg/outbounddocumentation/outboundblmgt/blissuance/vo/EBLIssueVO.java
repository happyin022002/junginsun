/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EBLIssueVO.java
*@FileTitle : EBLIssueVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.06
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.04.06 최도순 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

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
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EBLIssueVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EBLIssueVO> models = new ArrayList<EBLIssueVO>();
	
	/* Column Info */
	private String authCfm = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String srStsCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String srRqstTpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String eblRjctRsn = null;
	/* Column Info */
	private String cntcEml = null;
	/* Column Info */
	private String sndDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ackRcvFlg = null;
	/* Column Info */
	private String sndUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String srRqstNo = null;
	/* Column Info */
	private String srRqstDt = null;
	/* Column Info */
	private String eblCfmUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EBLIssueVO() {}

	public EBLIssueVO(String ibflag, String pagerows, String srRqstTpCd, String srStsCd, String srRqstNo, String bkgNo, String srRqstDt, String custCd, String custNm, String cntcEml, String phnNo, String eblRjctRsn, String authCfm, String sndUsrId, String sndDt, String ackRcvFlg, String eblCfmUsrId, String creDt) {
		this.authCfm = authCfm;
		this.phnNo = phnNo;
		this.srStsCd = srStsCd;
		this.custNm = custNm;
		this.srRqstTpCd = srRqstTpCd;
		this.creDt = creDt;
		this.eblRjctRsn = eblRjctRsn;
		this.cntcEml = cntcEml;
		this.sndDt = sndDt;
		this.pagerows = pagerows;
		this.ackRcvFlg = ackRcvFlg;
		this.sndUsrId = sndUsrId;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.custCd = custCd;
		this.srRqstNo = srRqstNo;
		this.srRqstDt = srRqstDt;
		this.eblCfmUsrId = eblCfmUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("auth_cfm", getAuthCfm());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("sr_sts_cd", getSrStsCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("sr_rqst_tp_cd", getSrRqstTpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ebl_rjct_rsn", getEblRjctRsn());
		this.hashColumns.put("cntc_eml", getCntcEml());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ack_rcv_flg", getAckRcvFlg());
		this.hashColumns.put("snd_usr_id", getSndUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("sr_rqst_no", getSrRqstNo());
		this.hashColumns.put("sr_rqst_dt", getSrRqstDt());
		this.hashColumns.put("ebl_cfm_usr_id", getEblCfmUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("auth_cfm", "authCfm");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("sr_sts_cd", "srStsCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("sr_rqst_tp_cd", "srRqstTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ebl_rjct_rsn", "eblRjctRsn");
		this.hashFields.put("cntc_eml", "cntcEml");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ack_rcv_flg", "ackRcvFlg");
		this.hashFields.put("snd_usr_id", "sndUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("sr_rqst_no", "srRqstNo");
		this.hashFields.put("sr_rqst_dt", "srRqstDt");
		this.hashFields.put("ebl_cfm_usr_id", "eblCfmUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return authCfm
	 */
	public String getAuthCfm() {
		return this.authCfm;
	}
	
	/**
	 * Column Info
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 * Column Info
	 * @return srStsCd
	 */
	public String getSrStsCd() {
		return this.srStsCd;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return srRqstTpCd
	 */
	public String getSrRqstTpCd() {
		return this.srRqstTpCd;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return eblRjctRsn
	 */
	public String getEblRjctRsn() {
		return this.eblRjctRsn;
	}
	
	/**
	 * Column Info
	 * @return cntcEml
	 */
	public String getCntcEml() {
		return this.cntcEml;
	}
	
	/**
	 * Column Info
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
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
	 * @return ackRcvFlg
	 */
	public String getAckRcvFlg() {
		return this.ackRcvFlg;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return srRqstNo
	 */
	public String getSrRqstNo() {
		return this.srRqstNo;
	}
	
	/**
	 * Column Info
	 * @return srRqstDt
	 */
	public String getSrRqstDt() {
		return this.srRqstDt;
	}
	
	/**
	 * Column Info
	 * @return eblCfmUsrId
	 */
	public String getEblCfmUsrId() {
		return this.eblCfmUsrId;
	}
	

	/**
	 * Column Info
	 * @param authCfm
	 */
	public void setAuthCfm(String authCfm) {
		this.authCfm = authCfm;
	}
	
	/**
	 * Column Info
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * Column Info
	 * @param srStsCd
	 */
	public void setSrStsCd(String srStsCd) {
		this.srStsCd = srStsCd;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param srRqstTpCd
	 */
	public void setSrRqstTpCd(String srRqstTpCd) {
		this.srRqstTpCd = srRqstTpCd;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param eblRjctRsn
	 */
	public void setEblRjctRsn(String eblRjctRsn) {
		this.eblRjctRsn = eblRjctRsn;
	}
	
	/**
	 * Column Info
	 * @param cntcEml
	 */
	public void setCntcEml(String cntcEml) {
		this.cntcEml = cntcEml;
	}
	
	/**
	 * Column Info
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
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
	 * @param ackRcvFlg
	 */
	public void setAckRcvFlg(String ackRcvFlg) {
		this.ackRcvFlg = ackRcvFlg;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param srRqstNo
	 */
	public void setSrRqstNo(String srRqstNo) {
		this.srRqstNo = srRqstNo;
	}
	
	/**
	 * Column Info
	 * @param srRqstDt
	 */
	public void setSrRqstDt(String srRqstDt) {
		this.srRqstDt = srRqstDt;
	}
	
	/**
	 * Column Info
	 * @param eblCfmUsrId
	 */
	public void setEblCfmUsrId(String eblCfmUsrId) {
		this.eblCfmUsrId = eblCfmUsrId;
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
		setAuthCfm(JSPUtil.getParameter(request, prefix + "auth_cfm", ""));
		setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
		setSrStsCd(JSPUtil.getParameter(request, prefix + "sr_sts_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setSrRqstTpCd(JSPUtil.getParameter(request, prefix + "sr_rqst_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEblRjctRsn(JSPUtil.getParameter(request, prefix + "ebl_rjct_rsn", ""));
		setCntcEml(JSPUtil.getParameter(request, prefix + "cntc_eml", ""));
		setSndDt(JSPUtil.getParameter(request, prefix + "snd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAckRcvFlg(JSPUtil.getParameter(request, prefix + "ack_rcv_flg", ""));
		setSndUsrId(JSPUtil.getParameter(request, prefix + "snd_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setSrRqstNo(JSPUtil.getParameter(request, prefix + "sr_rqst_no", ""));
		setSrRqstDt(JSPUtil.getParameter(request, prefix + "sr_rqst_dt", ""));
		setEblCfmUsrId(JSPUtil.getParameter(request, prefix + "ebl_cfm_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EBLIssueVO[]
	 */
	public EBLIssueVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EBLIssueVO[]
	 */
	public EBLIssueVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EBLIssueVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] authCfm = (JSPUtil.getParameter(request, prefix	+ "auth_cfm", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] srStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_sts_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] srRqstTpCd = (JSPUtil.getParameter(request, prefix	+ "sr_rqst_tp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] eblRjctRsn = (JSPUtil.getParameter(request, prefix	+ "ebl_rjct_rsn", length));
			String[] cntcEml = (JSPUtil.getParameter(request, prefix	+ "cntc_eml", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ackRcvFlg = (JSPUtil.getParameter(request, prefix	+ "ack_rcv_flg", length));
			String[] sndUsrId = (JSPUtil.getParameter(request, prefix	+ "snd_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] srRqstNo = (JSPUtil.getParameter(request, prefix	+ "sr_rqst_no", length));
			String[] srRqstDt = (JSPUtil.getParameter(request, prefix	+ "sr_rqst_dt", length));
			String[] eblCfmUsrId = (JSPUtil.getParameter(request, prefix	+ "ebl_cfm_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new EBLIssueVO();
				if (authCfm[i] != null)
					model.setAuthCfm(authCfm[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (srStsCd[i] != null)
					model.setSrStsCd(srStsCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (srRqstTpCd[i] != null)
					model.setSrRqstTpCd(srRqstTpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (eblRjctRsn[i] != null)
					model.setEblRjctRsn(eblRjctRsn[i]);
				if (cntcEml[i] != null)
					model.setCntcEml(cntcEml[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ackRcvFlg[i] != null)
					model.setAckRcvFlg(ackRcvFlg[i]);
				if (sndUsrId[i] != null)
					model.setSndUsrId(sndUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (srRqstNo[i] != null)
					model.setSrRqstNo(srRqstNo[i]);
				if (srRqstDt[i] != null)
					model.setSrRqstDt(srRqstDt[i]);
				if (eblCfmUsrId[i] != null)
					model.setEblCfmUsrId(eblCfmUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEBLIssueVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EBLIssueVO[]
	 */
	public EBLIssueVO[] getEBLIssueVOs(){
		EBLIssueVO[] vos = (EBLIssueVO[])models.toArray(new EBLIssueVO[models.size()]);
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
		this.authCfm = this.authCfm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srStsCd = this.srStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srRqstTpCd = this.srRqstTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eblRjctRsn = this.eblRjctRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcEml = this.cntcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackRcvFlg = this.ackRcvFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrId = this.sndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srRqstNo = this.srRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srRqstDt = this.srRqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eblCfmUsrId = this.eblCfmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

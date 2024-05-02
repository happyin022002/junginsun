/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltRfaAproRqstRefVO.java
*@FileTitle : RsltRfaAproRqstRefVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.12
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2010.05.12 문동규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo;

import java.lang.reflect.Field;
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
 * @author 문동규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltRfaAproRqstRefVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltRfaAproRqstRefVO> models = new ArrayList<RsltRfaAproRqstRefVO>();
	
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String transTpCd = null;
	/* Column Info */
	private String srepCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String propStsNm = null;
	/* Column Info */
	private String progDt = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String propStsCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String rqstTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltRfaAproRqstRefVO() {}

	public RsltRfaAproRqstRefVO(String ibflag, String pagerows, String rqstTpCd, String propStsCd, String propStsNm, String propNo, String rfaNo, String amdtSeq, String ofcCd, String usrId, String srepCd, String usrNm, String progDt, String transTpCd, String effDt, String expDt) {
		this.amdtSeq = amdtSeq;
		this.transTpCd = transTpCd;
		this.srepCd = srepCd;
		this.pagerows = pagerows;
		this.rfaNo = rfaNo;
		this.ofcCd = ofcCd;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.propStsNm = propStsNm;
		this.progDt = progDt;
		this.propNo = propNo;
		this.usrId = usrId;
		this.usrNm = usrNm;
		this.propStsCd = propStsCd;
		this.expDt = expDt;
		this.rqstTpCd = rqstTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("trans_tp_cd", getTransTpCd());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("prop_sts_nm", getPropStsNm());
		this.hashColumns.put("prog_dt", getProgDt());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("prop_sts_cd", getPropStsCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("rqst_tp_cd", getRqstTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("trans_tp_cd", "transTpCd");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prop_sts_nm", "propStsNm");
		this.hashFields.put("prog_dt", "progDt");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("prop_sts_cd", "propStsCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("rqst_tp_cd", "rqstTpCd");
		return this.hashFields;
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
	 * @return transTpCd
	 */
	public String getTransTpCd() {
		return this.transTpCd;
	}
	
	/**
	 * Column Info
	 * @return srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
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
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return propStsNm
	 */
	public String getPropStsNm() {
		return this.propStsNm;
	}
	
	/**
	 * Column Info
	 * @return progDt
	 */
	public String getProgDt() {
		return this.progDt;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return propStsCd
	 */
	public String getPropStsCd() {
		return this.propStsCd;
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
	 * @return rqstTpCd
	 */
	public String getRqstTpCd() {
		return this.rqstTpCd;
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
	 * @param transTpCd
	 */
	public void setTransTpCd(String transTpCd) {
		this.transTpCd = transTpCd;
	}
	
	/**
	 * Column Info
	 * @param srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
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
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param propStsNm
	 */
	public void setPropStsNm(String propStsNm) {
		this.propStsNm = propStsNm;
	}
	
	/**
	 * Column Info
	 * @param progDt
	 */
	public void setProgDt(String progDt) {
		this.progDt = progDt;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param propStsCd
	 */
	public void setPropStsCd(String propStsCd) {
		this.propStsCd = propStsCd;
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
	 * @param rqstTpCd
	 */
	public void setRqstTpCd(String rqstTpCd) {
		this.rqstTpCd = rqstTpCd;
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
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setTransTpCd(JSPUtil.getParameter(request, prefix + "trans_tp_cd", ""));
		setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPropStsNm(JSPUtil.getParameter(request, prefix + "prop_sts_nm", ""));
		setProgDt(JSPUtil.getParameter(request, prefix + "prog_dt", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setPropStsCd(JSPUtil.getParameter(request, prefix + "prop_sts_cd", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setRqstTpCd(JSPUtil.getParameter(request, prefix + "rqst_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltRfaAproRqstRefVO[]
	 */
	public RsltRfaAproRqstRefVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltRfaAproRqstRefVO[]
	 */
	public RsltRfaAproRqstRefVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltRfaAproRqstRefVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] transTpCd = (JSPUtil.getParameter(request, prefix	+ "trans_tp_cd", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] propStsNm = (JSPUtil.getParameter(request, prefix	+ "prop_sts_nm", length));
			String[] progDt = (JSPUtil.getParameter(request, prefix	+ "prog_dt", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] propStsCd = (JSPUtil.getParameter(request, prefix	+ "prop_sts_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] rqstTpCd = (JSPUtil.getParameter(request, prefix	+ "rqst_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltRfaAproRqstRefVO();
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (transTpCd[i] != null)
					model.setTransTpCd(transTpCd[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (propStsNm[i] != null)
					model.setPropStsNm(propStsNm[i]);
				if (progDt[i] != null)
					model.setProgDt(progDt[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (propStsCd[i] != null)
					model.setPropStsCd(propStsCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (rqstTpCd[i] != null)
					model.setRqstTpCd(rqstTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltRfaAproRqstRefVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltRfaAproRqstRefVO[]
	 */
	public RsltRfaAproRqstRefVO[] getRsltRfaAproRqstRefVOs(){
		RsltRfaAproRqstRefVO[] vos = (RsltRfaAproRqstRefVO[])models.toArray(new RsltRfaAproRqstRefVO[models.size()]);
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
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transTpCd = this.transTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propStsNm = this.propStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progDt = this.progDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propStsCd = this.propStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstTpCd = this.rqstTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

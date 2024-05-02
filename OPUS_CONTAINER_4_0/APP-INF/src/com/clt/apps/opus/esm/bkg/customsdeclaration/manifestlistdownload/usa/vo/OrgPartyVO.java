/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OrgPartyVO.java
*@FileTitle : OrgPartyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.26
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2012.03.26 KIM HYUN HWA 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo;

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
 * @author KIM HYUN HWA
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OrgPartyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OrgPartyVO> models = new ArrayList<OrgPartyVO>();
	
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String cstmsPtySeq = null;
	/* Column Info */
	private String cstmsPtyTpCd = null;
	/* Column Info */
	private String cstmsPtyNm = null;
	/* Column Info */
	private String cstmsPtyId = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String podYdNo = null;
	/* Column Info */
    private String delYdNo = null;
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;	

	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OrgPartyVO() {}

	public OrgPartyVO(String ibflag, String pagerows, String custCntCd, String custSeq, String custCd, String custNm, String scNo, String podCd, String delCd, String cstmsPtySeq, String cstmsPtyTpCd, String cstmsPtyNm, String cstmsPtyId, String deltFlg, String creOfcCd, String updOfcCd, String creUsrId, String creDt, String updUsrId, String updDt, String podYdNo, String delYdNo) {
		this.updDt = updDt;
		this.custNm = custNm;
		this.cstmsPtySeq = cstmsPtySeq;
		this.cstmsPtyNm = cstmsPtyNm;
		this.cstmsPtyId = cstmsPtyId;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.delCd = delCd;
		this.custSeq = custSeq;
		this.pagerows = pagerows;
		this.cstmsPtyTpCd = cstmsPtyTpCd;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.creOfcCd = creOfcCd;
		this.custCd = custCd;
		this.scNo = scNo;
		this.updUsrId = updUsrId;
		this.updOfcCd = updOfcCd;
		this.custCntCd = custCntCd;
		this.podYdNo = podYdNo;
		this.delYdNo = delYdNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("cstms_pty_seq", getCstmsPtySeq());
		this.hashColumns.put("cstms_pty_nm", getCstmsPtyNm());
		this.hashColumns.put("cstms_pty_id", getCstmsPtyId());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cstms_pty_tp_cd", getCstmsPtyTpCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("pod_yd_no", getPodYdNo());
		this.hashColumns.put("del_yd_no", getDelYdNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("cstms_pty_seq", "cstmsPtySeq");
		this.hashFields.put("cstms_pty_nm", "cstmsPtyNm");
		this.hashFields.put("cstms_pty_id", "cstmsPtyId");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cstms_pty_tp_cd", "cstmsPtyTpCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("pod_yd_no", "podYdNo");
		this.hashFields.put("del_yd_no", "delYdNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return cstmsPtySeq
	 */
	public String getCstmsPtySeq() {
		return this.cstmsPtySeq;
	}
	
	/**
	 * Column Info
	 * @return cstmsPtyNm
	 */
	public String getCstmsPtyNm() {
		return this.cstmsPtyNm;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
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
	 * @return cstmsPtyTpCd
	 */
	public String getCstmsPtyTpCd() {
		return this.cstmsPtyTpCd;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsPtyId
	 */
	public String getCstmsPtyId() {
		return cstmsPtyId;
	}

	/**
	 * Column Info
	 * @return podYdNo
	 */
	public String getPodYdNo() {
		return this.podYdNo;
	}
	
		/**
	 * Column Info
	 * @return delYdNo
	 */
	public String getDelYdNo() {
		return this.delYdNo;
	}

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param cstmsPtySeq
	 */
	public void setCstmsPtySeq(String cstmsPtySeq) {
		this.cstmsPtySeq = cstmsPtySeq;
	}
	
	/**
	 * Column Info
	 * @param cstmsPtyNm
	 */
	public void setCstmsPtyNm(String cstmsPtyNm) {
		this.cstmsPtyNm = cstmsPtyNm;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
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
	 * @param cstmsPtyTpCd
	 */
	public void setCstmsPtyTpCd(String cstmsPtyTpCd) {
		this.cstmsPtyTpCd = cstmsPtyTpCd;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsPtyId
	 */
	public void setCstmsPtyId(String cstmsPtyId) {
		this.cstmsPtyId = cstmsPtyId;
	}
	
	/**
	 * Column Info
	 * @param podYdNo
	 */
	public void setPodYdNo(String podYdNo) {
		this.podYdNo = podYdNo;
	}
	
	/**
	 * Column Info
	 * @param delYdNo
	 */
	public void setDelYdNo(String delYdNo) {
		this.delYdNo = delYdNo;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setCstmsPtySeq(JSPUtil.getParameter(request, prefix + "cstms_pty_seq", ""));
		setCstmsPtyNm(JSPUtil.getParameter(request, prefix + "cstms_pty_nm", ""));
		setCstmsPtyId(JSPUtil.getParameter(request, prefix + "cstms_pty_id", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCstmsPtyTpCd(JSPUtil.getParameter(request, prefix + "cstms_pty_tp_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setPodYdNo(JSPUtil.getParameter(request, prefix + "pod_yd_no", ""));
		setDelYdNo(JSPUtil.getParameter(request, prefix + "del_yd_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OrgPartyVO[]
	 */
	public OrgPartyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OrgPartyVO[]
	 */
	public OrgPartyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OrgPartyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] cstmsPtySeq = (JSPUtil.getParameter(request, prefix	+ "cstms_pty_seq", length));
			String[] cstmsPtyNm = (JSPUtil.getParameter(request, prefix	+ "cstms_pty_nm", length));
			String[] cstmsPtyId = (JSPUtil.getParameter(request, prefix	+ "cstms_pty_id", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cstmsPtyTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_pty_tp_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] podYdNo = (JSPUtil.getParameter(request, prefix	+ "pod_yd_no", length));
			String[] delYdNo = (JSPUtil.getParameter(request, prefix	+ "del_yd_no", length));

			
			for (int i = 0; i < length; i++) {
				model = new OrgPartyVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (cstmsPtySeq[i] != null)
					model.setCstmsPtySeq(cstmsPtySeq[i]);
				if (cstmsPtyNm[i] != null)
					model.setCstmsPtyNm(cstmsPtyNm[i]);
				if (cstmsPtyId[i] != null)
					model.setCstmsPtyId(cstmsPtyId[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cstmsPtyTpCd[i] != null)
					model.setCstmsPtyTpCd(cstmsPtyTpCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (podYdNo[i] != null)
					model.setPodYdNo(podYdNo[i]);
				if (delYdNo[i] != null)
					model.setDelYdNo(delYdNo[i]);	
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOrgPartyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OrgPartyVO[]
	 */
	public OrgPartyVO[] getOrgPartyVOs(){
		OrgPartyVO[] vos = (OrgPartyVO[])models.toArray(new OrgPartyVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPtySeq = this.cstmsPtySeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPtyNm = this.cstmsPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPtyId = this.cstmsPtyId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPtyTpCd = this.cstmsPtyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdNo = this.podYdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delYdNo = this.delYdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Search315DetailListVO.java
*@FileTitle : Search315DetailListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.10.28 전병석 
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

public class Search315DetailListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Search315DetailListVO> models = new ArrayList<Search315DetailListVO>();
	
	/* Column Info */
	private String custNo = null;
	/* Column Info */
	private String ediCntrSndTpCd = null;
	/* Column Info */
	private String ediVslTpCd = null;
	/* Column Info */
	private String destCntDesc = null;
	/* Column Info */
	private String custEdiStsCd = null;
	/* Column Info */
	private String rcvSeq = null;
	/* Column Info */
	private String coDivCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ediEvntCd = null;
	/* Column Info */
	private String ediCgoRmk = null;
	/* Column Info */
	private String custTpId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String orgDestCntDesc = null;
	/* Column Info */
	private String destContiDesc = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String ediAutoSndFlg = null;
	/* Column Info */
	private String sendFlg = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String orgSts = null;
	/* Column Info */
	private String ediGrpCd = null;
	/* Column Info */
	private String ediSndItvalHrmnt = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String orgContiDesc = null;
	/* Column Info */
	private String ediSts = null;
	/* Column Info */
	private String hostTpId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Search315DetailListVO() {}

	public Search315DetailListVO(String ibflag, String pagerows, String rcvDt, String rcvSeq, String ediGrpCd, String hostTpId, String custTpId, String custCntCd, String custSeq, String custNo, String scNo, String orgSts, String sendFlg, String ediSts, String custEdiStsCd, String coDivCd, String ediEvntCd, String ediVslTpCd, String ediSndItvalHrmnt, String ediCntrSndTpCd, String orgContiDesc, String orgDestCntDesc, String destContiDesc, String destCntDesc, String ediCgoRmk, String ediAutoSndFlg) {
		this.custNo = custNo;
		this.ediCntrSndTpCd = ediCntrSndTpCd;
		this.ediVslTpCd = ediVslTpCd;
		this.destCntDesc = destCntDesc;
		this.custEdiStsCd = custEdiStsCd;
		this.rcvSeq = rcvSeq;
		this.coDivCd = coDivCd;
		this.pagerows = pagerows;
		this.ediEvntCd = ediEvntCd;
		this.ediCgoRmk = ediCgoRmk;
		this.custTpId = custTpId;
		this.ibflag = ibflag;
		this.orgDestCntDesc = orgDestCntDesc;
		this.destContiDesc = destContiDesc;
		this.scNo = scNo;
		this.rcvDt = rcvDt;
		this.ediAutoSndFlg = ediAutoSndFlg;
		this.sendFlg = sendFlg;
		this.custCntCd = custCntCd;
		this.orgSts = orgSts;
		this.ediGrpCd = ediGrpCd;
		this.ediSndItvalHrmnt = ediSndItvalHrmnt;
		this.custSeq = custSeq;
		this.orgContiDesc = orgContiDesc;
		this.ediSts = ediSts;
		this.hostTpId = hostTpId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_no", getCustNo());
		this.hashColumns.put("edi_cntr_snd_tp_cd", getEdiCntrSndTpCd());
		this.hashColumns.put("edi_vsl_tp_cd", getEdiVslTpCd());
		this.hashColumns.put("dest_cnt_desc", getDestCntDesc());
		this.hashColumns.put("cust_edi_sts_cd", getCustEdiStsCd());
		this.hashColumns.put("rcv_seq", getRcvSeq());
		this.hashColumns.put("co_div_cd", getCoDivCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("edi_evnt_cd", getEdiEvntCd());
		this.hashColumns.put("edi_cgo_rmk", getEdiCgoRmk());
		this.hashColumns.put("cust_tp_id", getCustTpId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("org_dest_cnt_desc", getOrgDestCntDesc());
		this.hashColumns.put("dest_conti_desc", getDestContiDesc());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("edi_auto_snd_flg", getEdiAutoSndFlg());
		this.hashColumns.put("send_flg", getSendFlg());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("org_sts", getOrgSts());
		this.hashColumns.put("edi_grp_cd", getEdiGrpCd());
		this.hashColumns.put("edi_snd_itval_hrmnt", getEdiSndItvalHrmnt());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("org_conti_desc", getOrgContiDesc());
		this.hashColumns.put("edi_sts", getEdiSts());
		this.hashColumns.put("host_tp_id", getHostTpId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_no", "custNo");
		this.hashFields.put("edi_cntr_snd_tp_cd", "ediCntrSndTpCd");
		this.hashFields.put("edi_vsl_tp_cd", "ediVslTpCd");
		this.hashFields.put("dest_cnt_desc", "destCntDesc");
		this.hashFields.put("cust_edi_sts_cd", "custEdiStsCd");
		this.hashFields.put("rcv_seq", "rcvSeq");
		this.hashFields.put("co_div_cd", "coDivCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("edi_evnt_cd", "ediEvntCd");
		this.hashFields.put("edi_cgo_rmk", "ediCgoRmk");
		this.hashFields.put("cust_tp_id", "custTpId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("org_dest_cnt_desc", "orgDestCntDesc");
		this.hashFields.put("dest_conti_desc", "destContiDesc");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("edi_auto_snd_flg", "ediAutoSndFlg");
		this.hashFields.put("send_flg", "sendFlg");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("org_sts", "orgSts");
		this.hashFields.put("edi_grp_cd", "ediGrpCd");
		this.hashFields.put("edi_snd_itval_hrmnt", "ediSndItvalHrmnt");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("org_conti_desc", "orgContiDesc");
		this.hashFields.put("edi_sts", "ediSts");
		this.hashFields.put("host_tp_id", "hostTpId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return custNo
	 */
	public String getCustNo() {
		return this.custNo;
	}
	
	/**
	 * Column Info
	 * @return ediCntrSndTpCd
	 */
	public String getEdiCntrSndTpCd() {
		return this.ediCntrSndTpCd;
	}
	
	/**
	 * Column Info
	 * @return ediVslTpCd
	 */
	public String getEdiVslTpCd() {
		return this.ediVslTpCd;
	}
	
	/**
	 * Column Info
	 * @return destCntDesc
	 */
	public String getDestCntDesc() {
		return this.destCntDesc;
	}
	
	/**
	 * Column Info
	 * @return custEdiStsCd
	 */
	public String getCustEdiStsCd() {
		return this.custEdiStsCd;
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
	 * @return coDivCd
	 */
	public String getCoDivCd() {
		return this.coDivCd;
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
	 * @return ediEvntCd
	 */
	public String getEdiEvntCd() {
		return this.ediEvntCd;
	}
	
	/**
	 * Column Info
	 * @return ediCgoRmk
	 */
	public String getEdiCgoRmk() {
		return this.ediCgoRmk;
	}
	
	/**
	 * Column Info
	 * @return custTpId
	 */
	public String getCustTpId() {
		return this.custTpId;
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
	 * @return orgDestCntDesc
	 */
	public String getOrgDestCntDesc() {
		return this.orgDestCntDesc;
	}
	
	/**
	 * Column Info
	 * @return destContiDesc
	 */
	public String getDestContiDesc() {
		return this.destContiDesc;
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
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
	}
	
	/**
	 * Column Info
	 * @return ediAutoSndFlg
	 */
	public String getEdiAutoSndFlg() {
		return this.ediAutoSndFlg;
	}
	
	/**
	 * Column Info
	 * @return sendFlg
	 */
	public String getSendFlg() {
		return this.sendFlg;
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
	 * @return orgSts
	 */
	public String getOrgSts() {
		return this.orgSts;
	}
	
	/**
	 * Column Info
	 * @return ediGrpCd
	 */
	public String getEdiGrpCd() {
		return this.ediGrpCd;
	}
	
	/**
	 * Column Info
	 * @return ediSndItvalHrmnt
	 */
	public String getEdiSndItvalHrmnt() {
		return this.ediSndItvalHrmnt;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return orgContiDesc
	 */
	public String getOrgContiDesc() {
		return this.orgContiDesc;
	}
	
	/**
	 * Column Info
	 * @return ediSts
	 */
	public String getEdiSts() {
		return this.ediSts;
	}
	
	/**
	 * Column Info
	 * @return hostTpId
	 */
	public String getHostTpId() {
		return this.hostTpId;
	}
	

	/**
	 * Column Info
	 * @param custNo
	 */
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}
	
	/**
	 * Column Info
	 * @param ediCntrSndTpCd
	 */
	public void setEdiCntrSndTpCd(String ediCntrSndTpCd) {
		this.ediCntrSndTpCd = ediCntrSndTpCd;
	}
	
	/**
	 * Column Info
	 * @param ediVslTpCd
	 */
	public void setEdiVslTpCd(String ediVslTpCd) {
		this.ediVslTpCd = ediVslTpCd;
	}
	
	/**
	 * Column Info
	 * @param destCntDesc
	 */
	public void setDestCntDesc(String destCntDesc) {
		this.destCntDesc = destCntDesc;
	}
	
	/**
	 * Column Info
	 * @param custEdiStsCd
	 */
	public void setCustEdiStsCd(String custEdiStsCd) {
		this.custEdiStsCd = custEdiStsCd;
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
	 * @param coDivCd
	 */
	public void setCoDivCd(String coDivCd) {
		this.coDivCd = coDivCd;
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
	 * @param ediEvntCd
	 */
	public void setEdiEvntCd(String ediEvntCd) {
		this.ediEvntCd = ediEvntCd;
	}
	
	/**
	 * Column Info
	 * @param ediCgoRmk
	 */
	public void setEdiCgoRmk(String ediCgoRmk) {
		this.ediCgoRmk = ediCgoRmk;
	}
	
	/**
	 * Column Info
	 * @param custTpId
	 */
	public void setCustTpId(String custTpId) {
		this.custTpId = custTpId;
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
	 * @param orgDestCntDesc
	 */
	public void setOrgDestCntDesc(String orgDestCntDesc) {
		this.orgDestCntDesc = orgDestCntDesc;
	}
	
	/**
	 * Column Info
	 * @param destContiDesc
	 */
	public void setDestContiDesc(String destContiDesc) {
		this.destContiDesc = destContiDesc;
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
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
	}
	
	/**
	 * Column Info
	 * @param ediAutoSndFlg
	 */
	public void setEdiAutoSndFlg(String ediAutoSndFlg) {
		this.ediAutoSndFlg = ediAutoSndFlg;
	}
	
	/**
	 * Column Info
	 * @param sendFlg
	 */
	public void setSendFlg(String sendFlg) {
		this.sendFlg = sendFlg;
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
	 * @param orgSts
	 */
	public void setOrgSts(String orgSts) {
		this.orgSts = orgSts;
	}
	
	/**
	 * Column Info
	 * @param ediGrpCd
	 */
	public void setEdiGrpCd(String ediGrpCd) {
		this.ediGrpCd = ediGrpCd;
	}
	
	/**
	 * Column Info
	 * @param ediSndItvalHrmnt
	 */
	public void setEdiSndItvalHrmnt(String ediSndItvalHrmnt) {
		this.ediSndItvalHrmnt = ediSndItvalHrmnt;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param orgContiDesc
	 */
	public void setOrgContiDesc(String orgContiDesc) {
		this.orgContiDesc = orgContiDesc;
	}
	
	/**
	 * Column Info
	 * @param ediSts
	 */
	public void setEdiSts(String ediSts) {
		this.ediSts = ediSts;
	}
	
	/**
	 * Column Info
	 * @param hostTpId
	 */
	public void setHostTpId(String hostTpId) {
		this.hostTpId = hostTpId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCustNo(JSPUtil.getParameter(request, "cust_no", ""));
		setEdiCntrSndTpCd(JSPUtil.getParameter(request, "edi_cntr_snd_tp_cd", ""));
		setEdiVslTpCd(JSPUtil.getParameter(request, "edi_vsl_tp_cd", ""));
		setDestCntDesc(JSPUtil.getParameter(request, "dest_cnt_desc", ""));
		setCustEdiStsCd(JSPUtil.getParameter(request, "cust_edi_sts_cd", ""));
		setRcvSeq(JSPUtil.getParameter(request, "rcv_seq", ""));
		setCoDivCd(JSPUtil.getParameter(request, "co_div_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEdiEvntCd(JSPUtil.getParameter(request, "edi_evnt_cd", ""));
		setEdiCgoRmk(JSPUtil.getParameter(request, "edi_cgo_rmk", ""));
		setCustTpId(JSPUtil.getParameter(request, "cust_tp_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOrgDestCntDesc(JSPUtil.getParameter(request, "org_dest_cnt_desc", ""));
		setDestContiDesc(JSPUtil.getParameter(request, "dest_conti_desc", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setRcvDt(JSPUtil.getParameter(request, "rcv_dt", ""));
		setEdiAutoSndFlg(JSPUtil.getParameter(request, "edi_auto_snd_flg", ""));
		setSendFlg(JSPUtil.getParameter(request, "send_flg", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setOrgSts(JSPUtil.getParameter(request, "org_sts", ""));
		setEdiGrpCd(JSPUtil.getParameter(request, "edi_grp_cd", ""));
		setEdiSndItvalHrmnt(JSPUtil.getParameter(request, "edi_snd_itval_hrmnt", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setOrgContiDesc(JSPUtil.getParameter(request, "org_conti_desc", ""));
		setEdiSts(JSPUtil.getParameter(request, "edi_sts", ""));
		setHostTpId(JSPUtil.getParameter(request, "host_tp_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Search315DetailListVO[]
	 */
	public Search315DetailListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Search315DetailListVO[]
	 */
	public Search315DetailListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Search315DetailListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custNo = (JSPUtil.getParameter(request, prefix	+ "cust_no", length));
			String[] ediCntrSndTpCd = (JSPUtil.getParameter(request, prefix	+ "edi_cntr_snd_tp_cd", length));
			String[] ediVslTpCd = (JSPUtil.getParameter(request, prefix	+ "edi_vsl_tp_cd", length));
			String[] destCntDesc = (JSPUtil.getParameter(request, prefix	+ "dest_cnt_desc", length));
			String[] custEdiStsCd = (JSPUtil.getParameter(request, prefix	+ "cust_edi_sts_cd", length));
			String[] rcvSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_seq", length));
			String[] coDivCd = (JSPUtil.getParameter(request, prefix	+ "co_div_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ediEvntCd = (JSPUtil.getParameter(request, prefix	+ "edi_evnt_cd", length));
			String[] ediCgoRmk = (JSPUtil.getParameter(request, prefix	+ "edi_cgo_rmk", length));
			String[] custTpId = (JSPUtil.getParameter(request, prefix	+ "cust_tp_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] orgDestCntDesc = (JSPUtil.getParameter(request, prefix	+ "org_dest_cnt_desc", length));
			String[] destContiDesc = (JSPUtil.getParameter(request, prefix	+ "dest_conti_desc", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] ediAutoSndFlg = (JSPUtil.getParameter(request, prefix	+ "edi_auto_snd_flg", length));
			String[] sendFlg = (JSPUtil.getParameter(request, prefix	+ "send_flg", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] orgSts = (JSPUtil.getParameter(request, prefix	+ "org_sts", length));
			String[] ediGrpCd = (JSPUtil.getParameter(request, prefix	+ "edi_grp_cd", length));
			String[] ediSndItvalHrmnt = (JSPUtil.getParameter(request, prefix	+ "edi_snd_itval_hrmnt", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] orgContiDesc = (JSPUtil.getParameter(request, prefix	+ "org_conti_desc", length));
			String[] ediSts = (JSPUtil.getParameter(request, prefix	+ "edi_sts", length));
			String[] hostTpId = (JSPUtil.getParameter(request, prefix	+ "host_tp_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new Search315DetailListVO();
				if (custNo[i] != null)
					model.setCustNo(custNo[i]);
				if (ediCntrSndTpCd[i] != null)
					model.setEdiCntrSndTpCd(ediCntrSndTpCd[i]);
				if (ediVslTpCd[i] != null)
					model.setEdiVslTpCd(ediVslTpCd[i]);
				if (destCntDesc[i] != null)
					model.setDestCntDesc(destCntDesc[i]);
				if (custEdiStsCd[i] != null)
					model.setCustEdiStsCd(custEdiStsCd[i]);
				if (rcvSeq[i] != null)
					model.setRcvSeq(rcvSeq[i]);
				if (coDivCd[i] != null)
					model.setCoDivCd(coDivCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ediEvntCd[i] != null)
					model.setEdiEvntCd(ediEvntCd[i]);
				if (ediCgoRmk[i] != null)
					model.setEdiCgoRmk(ediCgoRmk[i]);
				if (custTpId[i] != null)
					model.setCustTpId(custTpId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (orgDestCntDesc[i] != null)
					model.setOrgDestCntDesc(orgDestCntDesc[i]);
				if (destContiDesc[i] != null)
					model.setDestContiDesc(destContiDesc[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (ediAutoSndFlg[i] != null)
					model.setEdiAutoSndFlg(ediAutoSndFlg[i]);
				if (sendFlg[i] != null)
					model.setSendFlg(sendFlg[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (orgSts[i] != null)
					model.setOrgSts(orgSts[i]);
				if (ediGrpCd[i] != null)
					model.setEdiGrpCd(ediGrpCd[i]);
				if (ediSndItvalHrmnt[i] != null)
					model.setEdiSndItvalHrmnt(ediSndItvalHrmnt[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (orgContiDesc[i] != null)
					model.setOrgContiDesc(orgContiDesc[i]);
				if (ediSts[i] != null)
					model.setEdiSts(ediSts[i]);
				if (hostTpId[i] != null)
					model.setHostTpId(hostTpId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearch315DetailListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Search315DetailListVO[]
	 */
	public Search315DetailListVO[] getSearch315DetailListVOs(){
		Search315DetailListVO[] vos = (Search315DetailListVO[])models.toArray(new Search315DetailListVO[models.size()]);
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
		this.custNo = this.custNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediCntrSndTpCd = this.ediCntrSndTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediVslTpCd = this.ediVslTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destCntDesc = this.destCntDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEdiStsCd = this.custEdiStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvSeq = this.rcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coDivCd = this.coDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediEvntCd = this.ediEvntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediCgoRmk = this.ediCgoRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpId = this.custTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestCntDesc = this.orgDestCntDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destContiDesc = this.destContiDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediAutoSndFlg = this.ediAutoSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendFlg = this.sendFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSts = this.orgSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGrpCd = this.ediGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndItvalHrmnt = this.ediSndItvalHrmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgContiDesc = this.orgContiDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSts = this.ediSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hostTpId = this.hostTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

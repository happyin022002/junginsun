/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BlIssVO.java
*@FileTitle : BlIssVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 임진영
*@LastVersion : 1.0
* 2009.11.17 임진영 
* 1.0 Creation
* -----------------------------------------------------
* History
* 2012.02.21 김보배 [CHM-201216109] [BKG] Japan Cargo Release 의 History 기능 개선 요청
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author 임진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BlIssVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BlIssVO> models = new ArrayList<BlIssVO>();
	
	/* Column Info */
	private String oblIssDt = null;
	/* Column Info */
	private String ibdDocRcvOfcCd = null;
	/* Column Info */
	private String oblIssTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String otrDocRcvOfcCd = null;
	/* Column Info */
	private String otrDocRcvUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String otrDocCgorFlg = null;
	/* Column Info */
	private String oblRdemDt = null;
	/* Column Info */
	private String oblIssUsrId = null;
	/* Column Info */
	private String oblCpyKnt = null;
	/* Column Info */
	private String ibdDocRcvUsrId = null;
	/* Column Info */
	private String ibdDocRcvDt = null;
	/* Column Info */
	private String blOtrDocRcvCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String oblIssOfcCd = null;
	/* Column Info */
	private String delCntCd = null;
	/* Column Info */
	private String oblRdemFlg = null;
	/* Column Info */
	private String oblIssKnt = null;
	/* Column Info */
	private String ibdDocRcvFlg = null;
	/* Column Info */
	private String otrDocRcvDt = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String oblRdemKnt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String oblRdemUsrId = null;
	/* Column Info */
	private String oblTtlKnt = null;
	/* Column Info */
	private String oblRdemUpdUsrId = null;
	/* Column Info */
	private String oblRdemOfcCd = null;
	/* Column Info */
	private String oldIbdDocRcvFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BlIssVO() {}

	public BlIssVO(String ibflag, String pagerows, String oblIssDt, String oblIssOfcCd, String oblIssUsrId, String oblIssTpCd, String oblIssKnt, String oblRdemOfcCd, String oblRdemUsrId, String oblRdemUpdUsrId, String oblRdemDt, String oblRdemKnt, String otrDocCgorFlg, String blOtrDocRcvCd, String otrDocRcvOfcCd, String otrDocRcvUsrId, String otrDocRcvDt, String ibdDocRcvFlg, String ibdDocRcvOfcCd, String ibdDocRcvUsrId, String ibdDocRcvDt, String oblTtlKnt, String oblCpyKnt, String blTpCd, String delCntCd, String oblRdemFlg, String bkgNo, String creUsrId, String updUsrId, String oldIbdDocRcvFlg) {
		this.oblIssDt = oblIssDt;
		this.ibdDocRcvOfcCd = ibdDocRcvOfcCd;
		this.oblIssTpCd = oblIssTpCd;
		this.pagerows = pagerows;
		this.otrDocRcvOfcCd = otrDocRcvOfcCd;
		this.otrDocRcvUsrId = otrDocRcvUsrId;
		this.ibflag = ibflag;
		this.otrDocCgorFlg = otrDocCgorFlg;
		this.oblRdemDt = oblRdemDt;
		this.oblIssUsrId = oblIssUsrId;
		this.oblCpyKnt = oblCpyKnt;
		this.ibdDocRcvUsrId = ibdDocRcvUsrId;
		this.ibdDocRcvDt = ibdDocRcvDt;
		this.blOtrDocRcvCd = blOtrDocRcvCd;
		this.updUsrId = updUsrId;
		this.oblIssOfcCd = oblIssOfcCd;
		this.delCntCd = delCntCd;
		this.oblRdemFlg = oblRdemFlg;
		this.oblIssKnt = oblIssKnt;
		this.ibdDocRcvFlg = ibdDocRcvFlg;
		this.otrDocRcvDt = otrDocRcvDt;
		this.blTpCd = blTpCd;
		this.oblRdemKnt = oblRdemKnt;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.oblRdemUsrId = oblRdemUsrId;
		this.oblTtlKnt = oblTtlKnt;
		this.oblRdemUpdUsrId = oblRdemUpdUsrId;
		this.oblRdemOfcCd = oblRdemOfcCd;
		this.oldIbdDocRcvFlg = oldIbdDocRcvFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("obl_iss_dt", getOblIssDt());
		this.hashColumns.put("ibd_doc_rcv_ofc_cd", getIbdDocRcvOfcCd());
		this.hashColumns.put("obl_iss_tp_cd", getOblIssTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("otr_doc_rcv_ofc_cd", getOtrDocRcvOfcCd());
		this.hashColumns.put("otr_doc_rcv_usr_id", getOtrDocRcvUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("otr_doc_cgor_flg", getOtrDocCgorFlg());
		this.hashColumns.put("obl_rdem_dt", getOblRdemDt());
		this.hashColumns.put("obl_iss_usr_id", getOblIssUsrId());
		this.hashColumns.put("obl_cpy_knt", getOblCpyKnt());
		this.hashColumns.put("ibd_doc_rcv_usr_id", getIbdDocRcvUsrId());
		this.hashColumns.put("ibd_doc_rcv_dt", getIbdDocRcvDt());
		this.hashColumns.put("bl_otr_doc_rcv_cd", getBlOtrDocRcvCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("obl_iss_ofc_cd", getOblIssOfcCd());
		this.hashColumns.put("del_cnt_cd", getDelCntCd());
		this.hashColumns.put("obl_rdem_flg", getOblRdemFlg());
		this.hashColumns.put("obl_iss_knt", getOblIssKnt());
		this.hashColumns.put("ibd_doc_rcv_flg", getIbdDocRcvFlg());
		this.hashColumns.put("otr_doc_rcv_dt", getOtrDocRcvDt());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("obl_rdem_knt", getOblRdemKnt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("obl_rdem_usr_id", getOblRdemUsrId());
		this.hashColumns.put("obl_ttl_knt", getOblTtlKnt());
		this.hashColumns.put("obl_rdem_upd_usr_id", getOblRdemUpdUsrId());
		this.hashColumns.put("obl_rdem_ofc_cd", getOblRdemOfcCd());
		this.hashColumns.put("old_ibd_doc_rcv_flg", getOldIbdDocRcvFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("obl_iss_dt", "oblIssDt");
		this.hashFields.put("ibd_doc_rcv_ofc_cd", "ibdDocRcvOfcCd");
		this.hashFields.put("obl_iss_tp_cd", "oblIssTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("otr_doc_rcv_ofc_cd", "otrDocRcvOfcCd");
		this.hashFields.put("otr_doc_rcv_usr_id", "otrDocRcvUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("otr_doc_cgor_flg", "otrDocCgorFlg");
		this.hashFields.put("obl_rdem_dt", "oblRdemDt");
		this.hashFields.put("obl_iss_usr_id", "oblIssUsrId");
		this.hashFields.put("obl_cpy_knt", "oblCpyKnt");
		this.hashFields.put("ibd_doc_rcv_usr_id", "ibdDocRcvUsrId");
		this.hashFields.put("ibd_doc_rcv_dt", "ibdDocRcvDt");
		this.hashFields.put("bl_otr_doc_rcv_cd", "blOtrDocRcvCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("obl_iss_ofc_cd", "oblIssOfcCd");
		this.hashFields.put("del_cnt_cd", "delCntCd");
		this.hashFields.put("obl_rdem_flg", "oblRdemFlg");
		this.hashFields.put("obl_iss_knt", "oblIssKnt");
		this.hashFields.put("ibd_doc_rcv_flg", "ibdDocRcvFlg");
		this.hashFields.put("otr_doc_rcv_dt", "otrDocRcvDt");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("obl_rdem_knt", "oblRdemKnt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("obl_rdem_usr_id", "oblRdemUsrId");
		this.hashFields.put("obl_ttl_knt", "oblTtlKnt");
		this.hashFields.put("obl_rdem_upd_usr_id", "oblRdemUpdUsrId");
		this.hashFields.put("obl_rdem_ofc_cd", "oblRdemOfcCd");
		this.hashFields.put("old_ibd_doc_rcv_flg", "oldIbdDocRcvFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return oblIssDt
	 */
	public String getOblIssDt() {
		return this.oblIssDt;
	}
	
	/**
	 * Column Info
	 * @return ibdDocRcvOfcCd
	 */
	public String getIbdDocRcvOfcCd() {
		return this.ibdDocRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return oblIssTpCd
	 */
	public String getOblIssTpCd() {
		return this.oblIssTpCd;
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
	 * @return otrDocRcvOfcCd
	 */
	public String getOtrDocRcvOfcCd() {
		return this.otrDocRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return otrDocRcvUsrId
	 */
	public String getOtrDocRcvUsrId() {
		return this.otrDocRcvUsrId;
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
	 * @return otrDocCgorFlg
	 */
	public String getOtrDocCgorFlg() {
		return this.otrDocCgorFlg;
	}
	
	/**
	 * Column Info
	 * @return oblRdemDt
	 */
	public String getOblRdemDt() {
		return this.oblRdemDt;
	}
	
	/**
	 * Column Info
	 * @return oblIssUsrId
	 */
	public String getOblIssUsrId() {
		return this.oblIssUsrId;
	}
	
	/**
	 * Column Info
	 * @return oblCpyKnt
	 */
	public String getOblCpyKnt() {
		return this.oblCpyKnt;
	}
	
	/**
	 * Column Info
	 * @return ibdDocRcvUsrId
	 */
	public String getIbdDocRcvUsrId() {
		return this.ibdDocRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @return ibdDocRcvDt
	 */
	public String getIbdDocRcvDt() {
		return this.ibdDocRcvDt;
	}
	
	/**
	 * Column Info
	 * @return blOtrDocRcvCd
	 */
	public String getBlOtrDocRcvCd() {
		return this.blOtrDocRcvCd;
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
	 * @return oblIssOfcCd
	 */
	public String getOblIssOfcCd() {
		return this.oblIssOfcCd;
	}
	
	/**
	 * Column Info
	 * @return delCntCd
	 */
	public String getDelCntCd() {
		return this.delCntCd;
	}
	
	/**
	 * Column Info
	 * @return oblRdemFlg
	 */
	public String getOblRdemFlg() {
		return this.oblRdemFlg;
	}
	
	/**
	 * Column Info
	 * @return oblIssKnt
	 */
	public String getOblIssKnt() {
		return this.oblIssKnt;
	}
	
	/**
	 * Column Info
	 * @return ibdDocRcvFlg
	 */
	public String getIbdDocRcvFlg() {
		return this.ibdDocRcvFlg;
	}
	
	/**
	 * Column Info
	 * @return otrDocRcvDt
	 */
	public String getOtrDocRcvDt() {
		return this.otrDocRcvDt;
	}
	
	/**
	 * Column Info
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
	}
	
	/**
	 * Column Info
	 * @return oblRdemKnt
	 */
	public String getOblRdemKnt() {
		return this.oblRdemKnt;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return oblRdemUsrId
	 */
	public String getOblRdemUsrId() {
		return this.oblRdemUsrId;
	}
	
	/**
	 * Column Info
	 * @return oblTtlKnt
	 */
	public String getOblTtlKnt() {
		return this.oblTtlKnt;
	}
	
	/**
	 * Column Info
	 * @return oblRdemUpdUsrId
	 */
	public String getOblRdemUpdUsrId() {
		return this.oblRdemUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @return oblRdemOfcCd
	 */
	public String getOblRdemOfcCd() {
		return this.oblRdemOfcCd;
	}
	
	/**
	 * Column Info
	 * @return oldIbdDocRcvFlg
	 */
	public String getOldIbdDocRcvFlg() {
		return this.oldIbdDocRcvFlg;
	}
	

	/**
	 * Column Info
	 * @param oblIssDt
	 */
	public void setOblIssDt(String oblIssDt) {
		this.oblIssDt = oblIssDt;
	}
	
	/**
	 * Column Info
	 * @param ibdDocRcvOfcCd
	 */
	public void setIbdDocRcvOfcCd(String ibdDocRcvOfcCd) {
		this.ibdDocRcvOfcCd = ibdDocRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param oblIssTpCd
	 */
	public void setOblIssTpCd(String oblIssTpCd) {
		this.oblIssTpCd = oblIssTpCd;
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
	 * @param otrDocRcvOfcCd
	 */
	public void setOtrDocRcvOfcCd(String otrDocRcvOfcCd) {
		this.otrDocRcvOfcCd = otrDocRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param otrDocRcvUsrId
	 */
	public void setOtrDocRcvUsrId(String otrDocRcvUsrId) {
		this.otrDocRcvUsrId = otrDocRcvUsrId;
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
	 * @param otrDocCgorFlg
	 */
	public void setOtrDocCgorFlg(String otrDocCgorFlg) {
		this.otrDocCgorFlg = otrDocCgorFlg;
	}
	
	/**
	 * Column Info
	 * @param oblRdemDt
	 */
	public void setOblRdemDt(String oblRdemDt) {
		this.oblRdemDt = oblRdemDt;
	}
	
	/**
	 * Column Info
	 * @param oblIssUsrId
	 */
	public void setOblIssUsrId(String oblIssUsrId) {
		this.oblIssUsrId = oblIssUsrId;
	}
	
	/**
	 * Column Info
	 * @param oblCpyKnt
	 */
	public void setOblCpyKnt(String oblCpyKnt) {
		this.oblCpyKnt = oblCpyKnt;
	}
	
	/**
	 * Column Info
	 * @param ibdDocRcvUsrId
	 */
	public void setIbdDocRcvUsrId(String ibdDocRcvUsrId) {
		this.ibdDocRcvUsrId = ibdDocRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @param ibdDocRcvDt
	 */
	public void setIbdDocRcvDt(String ibdDocRcvDt) {
		this.ibdDocRcvDt = ibdDocRcvDt;
	}
	
	/**
	 * Column Info
	 * @param blOtrDocRcvCd
	 */
	public void setBlOtrDocRcvCd(String blOtrDocRcvCd) {
		this.blOtrDocRcvCd = blOtrDocRcvCd;
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
	 * @param oblIssOfcCd
	 */
	public void setOblIssOfcCd(String oblIssOfcCd) {
		this.oblIssOfcCd = oblIssOfcCd;
	}
	
	/**
	 * Column Info
	 * @param delCntCd
	 */
	public void setDelCntCd(String delCntCd) {
		this.delCntCd = delCntCd;
	}
	
	/**
	 * Column Info
	 * @param oblRdemFlg
	 */
	public void setOblRdemFlg(String oblRdemFlg) {
		this.oblRdemFlg = oblRdemFlg;
	}
	
	/**
	 * Column Info
	 * @param oblIssKnt
	 */
	public void setOblIssKnt(String oblIssKnt) {
		this.oblIssKnt = oblIssKnt;
	}
	
	/**
	 * Column Info
	 * @param ibdDocRcvFlg
	 */
	public void setIbdDocRcvFlg(String ibdDocRcvFlg) {
		this.ibdDocRcvFlg = ibdDocRcvFlg;
	}
	
	/**
	 * Column Info
	 * @param otrDocRcvDt
	 */
	public void setOtrDocRcvDt(String otrDocRcvDt) {
		this.otrDocRcvDt = otrDocRcvDt;
	}
	
	/**
	 * Column Info
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}
	
	/**
	 * Column Info
	 * @param oblRdemKnt
	 */
	public void setOblRdemKnt(String oblRdemKnt) {
		this.oblRdemKnt = oblRdemKnt;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param oblRdemUsrId
	 */
	public void setOblRdemUsrId(String oblRdemUsrId) {
		this.oblRdemUsrId = oblRdemUsrId;
	}
	
	/**
	 * Column Info
	 * @param oblTtlKnt
	 */
	public void setOblTtlKnt(String oblTtlKnt) {
		this.oblTtlKnt = oblTtlKnt;
	}
	
	/**
	 * Column Info
	 * @param oblRdemUpdUsrId
	 */
	public void setOblRdemUpdUsrId(String oblRdemUpdUsrId) {
		this.oblRdemUpdUsrId = oblRdemUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @param oldIbdDocRcvFlg
	 */
	public void setOldIbdDocRcvFlg(String oldIbdDocRcvFlg) {
		this.oldIbdDocRcvFlg = oldIbdDocRcvFlg;
	}
	
	/**
	 * Column Info
	 * @param oblRdemOfcCd
	 */
	public void setOblRdemOfcCd(String oblRdemOfcCd) {
		this.oblRdemOfcCd = oblRdemOfcCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOblIssDt(JSPUtil.getParameter(request, "obl_iss_dt", ""));
		setIbdDocRcvOfcCd(JSPUtil.getParameter(request, "ibd_doc_rcv_ofc_cd", ""));
		setOblIssTpCd(JSPUtil.getParameter(request, "obl_iss_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOtrDocRcvOfcCd(JSPUtil.getParameter(request, "otr_doc_rcv_ofc_cd", ""));
		setOtrDocRcvUsrId(JSPUtil.getParameter(request, "otr_doc_rcv_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOtrDocCgorFlg(JSPUtil.getParameter(request, "otr_doc_cgor_flg", ""));
		setOblRdemDt(JSPUtil.getParameter(request, "obl_rdem_dt", ""));
		setOblIssUsrId(JSPUtil.getParameter(request, "obl_iss_usr_id", ""));
		setOblCpyKnt(JSPUtil.getParameter(request, "obl_cpy_knt", ""));
		setIbdDocRcvUsrId(JSPUtil.getParameter(request, "ibd_doc_rcv_usr_id", ""));
		setIbdDocRcvDt(JSPUtil.getParameter(request, "ibd_doc_rcv_dt", ""));
		setBlOtrDocRcvCd(JSPUtil.getParameter(request, "bl_otr_doc_rcv_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setOblIssOfcCd(JSPUtil.getParameter(request, "obl_iss_ofc_cd", ""));
		setDelCntCd(JSPUtil.getParameter(request, "del_cnt_cd", ""));
		setOblRdemFlg(JSPUtil.getParameter(request, "obl_rdem_flg", ""));
		setOblIssKnt(JSPUtil.getParameter(request, "obl_iss_knt", ""));
		setIbdDocRcvFlg(JSPUtil.getParameter(request, "ibd_doc_rcv_flg", ""));
		setOtrDocRcvDt(JSPUtil.getParameter(request, "otr_doc_rcv_dt", ""));
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
		setOblRdemKnt(JSPUtil.getParameter(request, "obl_rdem_knt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setOblRdemUsrId(JSPUtil.getParameter(request, "obl_rdem_usr_id", ""));
		setOblTtlKnt(JSPUtil.getParameter(request, "obl_ttl_knt", ""));
		setOblRdemUpdUsrId(JSPUtil.getParameter(request, "obl_rdem_upd_usr_id", ""));
		setOblRdemOfcCd(JSPUtil.getParameter(request, "obl_rdem_ofc_cd", ""));
		setOldIbdDocRcvFlg(JSPUtil.getParameter(request, "old_ibd_doc_rcv_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BlIssVO[]
	 */
	public BlIssVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BlIssVO[]
	 */
	public BlIssVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BlIssVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] oblIssDt = (JSPUtil.getParameter(request, prefix	+ "obl_iss_dt", length));
			String[] ibdDocRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "ibd_doc_rcv_ofc_cd", length));
			String[] oblIssTpCd = (JSPUtil.getParameter(request, prefix	+ "obl_iss_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] otrDocRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "otr_doc_rcv_ofc_cd", length));
			String[] otrDocRcvUsrId = (JSPUtil.getParameter(request, prefix	+ "otr_doc_rcv_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] otrDocCgorFlg = (JSPUtil.getParameter(request, prefix	+ "otr_doc_cgor_flg", length));
			String[] oblRdemDt = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_dt", length));
			String[] oblIssUsrId = (JSPUtil.getParameter(request, prefix	+ "obl_iss_usr_id", length));
			String[] oblCpyKnt = (JSPUtil.getParameter(request, prefix	+ "obl_cpy_knt", length));
			String[] ibdDocRcvUsrId = (JSPUtil.getParameter(request, prefix	+ "ibd_doc_rcv_usr_id", length));
			String[] ibdDocRcvDt = (JSPUtil.getParameter(request, prefix	+ "ibd_doc_rcv_dt", length));
			String[] blOtrDocRcvCd = (JSPUtil.getParameter(request, prefix	+ "bl_otr_doc_rcv_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] oblIssOfcCd = (JSPUtil.getParameter(request, prefix	+ "obl_iss_ofc_cd", length));
			String[] delCntCd = (JSPUtil.getParameter(request, prefix	+ "del_cnt_cd", length));
			String[] oblRdemFlg = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_flg", length));
			String[] oblIssKnt = (JSPUtil.getParameter(request, prefix	+ "obl_iss_knt", length));
			String[] ibdDocRcvFlg = (JSPUtil.getParameter(request, prefix	+ "ibd_doc_rcv_flg", length));
			String[] otrDocRcvDt = (JSPUtil.getParameter(request, prefix	+ "otr_doc_rcv_dt", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] oblRdemKnt = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_knt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] oblRdemUsrId = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_usr_id", length));
			String[] oblTtlKnt = (JSPUtil.getParameter(request, prefix	+ "obl_ttl_knt", length));
			String[] oblRdemUpdUsrId = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_upd_usr_id", length));
			String[] oblRdemOfcCd = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_ofc_cd", length));
			String[] oldIbdDocRcvFlg = (JSPUtil.getParameter(request, prefix	+ "old_ibd_doc_rcv_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new BlIssVO();
				if (oblIssDt[i] != null)
					model.setOblIssDt(oblIssDt[i]);
				if (ibdDocRcvOfcCd[i] != null)
					model.setIbdDocRcvOfcCd(ibdDocRcvOfcCd[i]);
				if (oblIssTpCd[i] != null)
					model.setOblIssTpCd(oblIssTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (otrDocRcvOfcCd[i] != null)
					model.setOtrDocRcvOfcCd(otrDocRcvOfcCd[i]);
				if (otrDocRcvUsrId[i] != null)
					model.setOtrDocRcvUsrId(otrDocRcvUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (otrDocCgorFlg[i] != null)
					model.setOtrDocCgorFlg(otrDocCgorFlg[i]);
				if (oblRdemDt[i] != null)
					model.setOblRdemDt(oblRdemDt[i]);
				if (oblIssUsrId[i] != null)
					model.setOblIssUsrId(oblIssUsrId[i]);
				if (oblCpyKnt[i] != null)
					model.setOblCpyKnt(oblCpyKnt[i]);
				if (ibdDocRcvUsrId[i] != null)
					model.setIbdDocRcvUsrId(ibdDocRcvUsrId[i]);
				if (ibdDocRcvDt[i] != null)
					model.setIbdDocRcvDt(ibdDocRcvDt[i]);
				if (blOtrDocRcvCd[i] != null)
					model.setBlOtrDocRcvCd(blOtrDocRcvCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (oblIssOfcCd[i] != null)
					model.setOblIssOfcCd(oblIssOfcCd[i]);
				if (delCntCd[i] != null)
					model.setDelCntCd(delCntCd[i]);
				if (oblRdemFlg[i] != null)
					model.setOblRdemFlg(oblRdemFlg[i]);
				if (oblIssKnt[i] != null)
					model.setOblIssKnt(oblIssKnt[i]);
				if (ibdDocRcvFlg[i] != null)
					model.setIbdDocRcvFlg(ibdDocRcvFlg[i]);
				if (otrDocRcvDt[i] != null)
					model.setOtrDocRcvDt(otrDocRcvDt[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (oblRdemKnt[i] != null)
					model.setOblRdemKnt(oblRdemKnt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (oblRdemUsrId[i] != null)
					model.setOblRdemUsrId(oblRdemUsrId[i]);
				if (oblTtlKnt[i] != null)
					model.setOblTtlKnt(oblTtlKnt[i]);
				if (oblRdemUpdUsrId[i] != null)
					model.setOblRdemUpdUsrId(oblRdemUpdUsrId[i]);
				if (oblRdemOfcCd[i] != null)
					model.setOblRdemOfcCd(oblRdemOfcCd[i]);
				if (oldIbdDocRcvFlg[i] != null)
					model.setOldIbdDocRcvFlg(oldIbdDocRcvFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBlIssVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlIssVO[]
	 */
	public BlIssVO[] getBlIssVOs(){
		BlIssVO[] vos = (BlIssVO[])models.toArray(new BlIssVO[models.size()]);
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
		this.oblIssDt = this.oblIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdDocRcvOfcCd = this.ibdDocRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssTpCd = this.oblIssTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrDocRcvOfcCd = this.otrDocRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrDocRcvUsrId = this.otrDocRcvUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrDocCgorFlg = this.otrDocCgorFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemDt = this.oblRdemDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssUsrId = this.oblIssUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblCpyKnt = this.oblCpyKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdDocRcvUsrId = this.ibdDocRcvUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdDocRcvDt = this.ibdDocRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blOtrDocRcvCd = this.blOtrDocRcvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssOfcCd = this.oblIssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCntCd = this.delCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemFlg = this.oblRdemFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssKnt = this.oblIssKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdDocRcvFlg = this.ibdDocRcvFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrDocRcvDt = this.otrDocRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemKnt = this.oblRdemKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemUsrId = this.oblRdemUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblTtlKnt = this.oblTtlKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemUpdUsrId = this.oblRdemUpdUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemOfcCd = this.oblRdemOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldIbdDocRcvFlg = this.oldIbdDocRcvFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorDoSaveVO.java
*@FileTitle : KorDoSaveVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.10
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.10  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

import java.util.ArrayList;

import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorDoSaveVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorDoSaveVO> models = new ArrayList<KorDoSaveVO>();

	private SignOnUserAccount acount = null;

	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String oblCngFlg = null;
	/* Column Info */
	private String cyOpCd = null;
	/* Column Info */
	private String doSplitFlg = null;
	/* Column Info */
	private String idaImpGenMfNo = null;
	/* Column Info */
	private String infoCgoFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String idaCstmsAsgnLineNo = null;
	/* Column Info */
	private String newOblRdemKnt = null;
	/* Column Info */
	private String doHldFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cstmsRefNm = null;
	/* Column Info */
	private String idaCgorOrdYr = null;
	/* Column Info */
	private String cstmsAsgnCtnt = null;
	/* Column Info */
	private String doCngEvntCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String oldOblRdemKnt = null;
	/* Column Info */
	private String cstmsRefCtnt = null;
	/* Column Info */
	private String cstmsAsgnNm = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorDoSaveVO() {}

	public KorDoSaveVO(String ibflag, String pagerows, String bkgNo, String cstmsRefNm, String cstmsRefCtnt, String cstmsAsgnNm, String cstmsAsgnCtnt, String interRmk, String doHldFlg, String creUsrId, String creDt, String updUsrId, String updDt, String cyOpCd, String infoCgoFlg, String idaImpGenMfNo, String idaCgorOrdYr, String idaCstmsAsgnLineNo, String doSplitFlg, String oblCngFlg, String doCngEvntCd, String oldOblRdemKnt, String newOblRdemKnt) {
		this.updDt = updDt;
		this.oblCngFlg = oblCngFlg;
		this.cyOpCd = cyOpCd;
		this.doSplitFlg = doSplitFlg;
		this.idaImpGenMfNo = idaImpGenMfNo;
		this.infoCgoFlg = infoCgoFlg;
		this.creDt = creDt;
		this.idaCstmsAsgnLineNo = idaCstmsAsgnLineNo;
		this.newOblRdemKnt = newOblRdemKnt;
		this.doHldFlg = doHldFlg;
		this.pagerows = pagerows;
		this.cstmsRefNm = cstmsRefNm;
		this.idaCgorOrdYr = idaCgorOrdYr;
		this.cstmsAsgnCtnt = cstmsAsgnCtnt;
		this.doCngEvntCd = doCngEvntCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.interRmk = interRmk;
		this.oldOblRdemKnt = oldOblRdemKnt;
		this.cstmsRefCtnt = cstmsRefCtnt;
		this.cstmsAsgnNm = cstmsAsgnNm;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("obl_cng_flg", getOblCngFlg());
		this.hashColumns.put("cy_op_cd", getCyOpCd());
		this.hashColumns.put("do_split_flg", getDoSplitFlg());
		this.hashColumns.put("ida_imp_gen_mf_no", getIdaImpGenMfNo());
		this.hashColumns.put("info_cgo_flg", getInfoCgoFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ida_cstms_asgn_line_no", getIdaCstmsAsgnLineNo());
		this.hashColumns.put("new_obl_rdem_knt", getNewOblRdemKnt());
		this.hashColumns.put("do_hld_flg", getDoHldFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cstms_ref_nm", getCstmsRefNm());
		this.hashColumns.put("ida_cgor_ord_yr", getIdaCgorOrdYr());
		this.hashColumns.put("cstms_asgn_ctnt", getCstmsAsgnCtnt());
		this.hashColumns.put("do_cng_evnt_cd", getDoCngEvntCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("old_obl_rdem_knt", getOldOblRdemKnt());
		this.hashColumns.put("cstms_ref_ctnt", getCstmsRefCtnt());
		this.hashColumns.put("cstms_asgn_nm", getCstmsAsgnNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("obl_cng_flg", "oblCngFlg");
		this.hashFields.put("cy_op_cd", "cyOpCd");
		this.hashFields.put("do_split_flg", "doSplitFlg");
		this.hashFields.put("ida_imp_gen_mf_no", "idaImpGenMfNo");
		this.hashFields.put("info_cgo_flg", "infoCgoFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ida_cstms_asgn_line_no", "idaCstmsAsgnLineNo");
		this.hashFields.put("new_obl_rdem_knt", "newOblRdemKnt");
		this.hashFields.put("do_hld_flg", "doHldFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cstms_ref_nm", "cstmsRefNm");
		this.hashFields.put("ida_cgor_ord_yr", "idaCgorOrdYr");
		this.hashFields.put("cstms_asgn_ctnt", "cstmsAsgnCtnt");
		this.hashFields.put("do_cng_evnt_cd", "doCngEvntCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("old_obl_rdem_knt", "oldOblRdemKnt");
		this.hashFields.put("cstms_ref_ctnt", "cstmsRefCtnt");
		this.hashFields.put("cstms_asgn_nm", "cstmsAsgnNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return oblCngFlg
	 */
	public String getOblCngFlg() {
		return this.oblCngFlg;
	}
	
	/**
	 * Column Info
	 * @return cyOpCd
	 */
	public String getCyOpCd() {
		return this.cyOpCd;
	}
	
	/**
	 * Column Info
	 * @return doSplitFlg
	 */
	public String getDoSplitFlg() {
		return this.doSplitFlg;
	}
	
	/**
	 * Column Info
	 * @return idaImpGenMfNo
	 */
	public String getIdaImpGenMfNo() {
		return this.idaImpGenMfNo;
	}
	
	/**
	 * Column Info
	 * @return infoCgoFlg
	 */
	public String getInfoCgoFlg() {
		return this.infoCgoFlg;
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
	 * @return idaCstmsAsgnLineNo
	 */
	public String getIdaCstmsAsgnLineNo() {
		return this.idaCstmsAsgnLineNo;
	}
	
	/**
	 * Column Info
	 * @return newOblRdemKnt
	 */
	public String getNewOblRdemKnt() {
		return this.newOblRdemKnt;
	}
	
	/**
	 * Column Info
	 * @return doHldFlg
	 */
	public String getDoHldFlg() {
		return this.doHldFlg;
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
	 * @return cstmsRefNm
	 */
	public String getCstmsRefNm() {
		return this.cstmsRefNm;
	}
	
	/**
	 * Column Info
	 * @return idaCgorOrdYr
	 */
	public String getIdaCgorOrdYr() {
		return this.idaCgorOrdYr;
	}
	
	/**
	 * Column Info
	 * @return cstmsAsgnCtnt
	 */
	public String getCstmsAsgnCtnt() {
		return this.cstmsAsgnCtnt;
	}
	
	/**
	 * Column Info
	 * @return doCngEvntCd
	 */
	public String getDoCngEvntCd() {
		return this.doCngEvntCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return interRmk
	 */
	public String getInterRmk() {
		return this.interRmk;
	}
	
	/**
	 * Column Info
	 * @return oldOblRdemKnt
	 */
	public String getOldOblRdemKnt() {
		return this.oldOblRdemKnt;
	}
	
	/**
	 * Column Info
	 * @return cstmsRefCtnt
	 */
	public String getCstmsRefCtnt() {
		return this.cstmsRefCtnt;
	}
	
	/**
	 * Column Info
	 * @return cstmsAsgnNm
	 */
	public String getCstmsAsgnNm() {
		return this.cstmsAsgnNm;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param oblCngFlg
	 */
	public void setOblCngFlg(String oblCngFlg) {
		this.oblCngFlg = oblCngFlg;
	}
	
	/**
	 * Column Info
	 * @param cyOpCd
	 */
	public void setCyOpCd(String cyOpCd) {
		this.cyOpCd = cyOpCd;
	}
	
	/**
	 * Column Info
	 * @param doSplitFlg
	 */
	public void setDoSplitFlg(String doSplitFlg) {
		this.doSplitFlg = doSplitFlg;
	}
	
	/**
	 * Column Info
	 * @param idaImpGenMfNo
	 */
	public void setIdaImpGenMfNo(String idaImpGenMfNo) {
		this.idaImpGenMfNo = idaImpGenMfNo;
	}
	
	/**
	 * Column Info
	 * @param infoCgoFlg
	 */
	public void setInfoCgoFlg(String infoCgoFlg) {
		this.infoCgoFlg = infoCgoFlg;
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
	 * @param idaCstmsAsgnLineNo
	 */
	public void setIdaCstmsAsgnLineNo(String idaCstmsAsgnLineNo) {
		this.idaCstmsAsgnLineNo = idaCstmsAsgnLineNo;
	}
	
	/**
	 * Column Info
	 * @param newOblRdemKnt
	 */
	public void setNewOblRdemKnt(String newOblRdemKnt) {
		this.newOblRdemKnt = newOblRdemKnt;
	}
	
	/**
	 * Column Info
	 * @param doHldFlg
	 */
	public void setDoHldFlg(String doHldFlg) {
		this.doHldFlg = doHldFlg;
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
	 * @param cstmsRefNm
	 */
	public void setCstmsRefNm(String cstmsRefNm) {
		this.cstmsRefNm = cstmsRefNm;
	}
	
	/**
	 * Column Info
	 * @param idaCgorOrdYr
	 */
	public void setIdaCgorOrdYr(String idaCgorOrdYr) {
		this.idaCgorOrdYr = idaCgorOrdYr;
	}
	
	/**
	 * Column Info
	 * @param cstmsAsgnCtnt
	 */
	public void setCstmsAsgnCtnt(String cstmsAsgnCtnt) {
		this.cstmsAsgnCtnt = cstmsAsgnCtnt;
	}
	
	/**
	 * Column Info
	 * @param doCngEvntCd
	 */
	public void setDoCngEvntCd(String doCngEvntCd) {
		this.doCngEvntCd = doCngEvntCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param interRmk
	 */
	public void setInterRmk(String interRmk) {
		this.interRmk = interRmk;
	}
	
	/**
	 * Column Info
	 * @param oldOblRdemKnt
	 */
	public void setOldOblRdemKnt(String oldOblRdemKnt) {
		this.oldOblRdemKnt = oldOblRdemKnt;
	}
	
	/**
	 * Column Info
	 * @param cstmsRefCtnt
	 */
	public void setCstmsRefCtnt(String cstmsRefCtnt) {
		this.cstmsRefCtnt = cstmsRefCtnt;
	}
	
	/**
	 * Column Info
	 * @param cstmsAsgnNm
	 */
	public void setCstmsAsgnNm(String cstmsAsgnNm) {
		this.cstmsAsgnNm = cstmsAsgnNm;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setOblCngFlg(JSPUtil.getParameter(request, "obl_cng_flg", ""));
		setCyOpCd(JSPUtil.getParameter(request, "cy_op_cd", ""));
		setDoSplitFlg(JSPUtil.getParameter(request, "do_split_flg", ""));
		setIdaImpGenMfNo(JSPUtil.getParameter(request, "ida_imp_gen_mf_no", ""));
		setInfoCgoFlg(JSPUtil.getParameter(request, "info_cgo_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setIdaCstmsAsgnLineNo(JSPUtil.getParameter(request, "ida_cstms_asgn_line_no", ""));
		setNewOblRdemKnt(JSPUtil.getParameter(request, "new_obl_rdem_knt", ""));
		setDoHldFlg(JSPUtil.getParameter(request, "do_hld_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCstmsRefNm(JSPUtil.getParameter(request, "cstms_ref_nm", ""));
		setIdaCgorOrdYr(JSPUtil.getParameter(request, "ida_cgor_ord_yr", ""));
		setCstmsAsgnCtnt(JSPUtil.getParameter(request, "cstms_asgn_ctnt", ""));
		setDoCngEvntCd(JSPUtil.getParameter(request, "do_cng_evnt_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setInterRmk(JSPUtil.getParameter(request, "inter_rmk", ""));
		setOldOblRdemKnt(JSPUtil.getParameter(request, "old_obl_rdem_knt", ""));
		setCstmsRefCtnt(JSPUtil.getParameter(request, "cstms_ref_ctnt", ""));
		setCstmsAsgnNm(JSPUtil.getParameter(request, "cstms_asgn_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorDoSaveVO[]
	 */
	public KorDoSaveVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorDoSaveVO[]
	 */
	public KorDoSaveVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorDoSaveVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] oblCngFlg = (JSPUtil.getParameter(request, prefix	+ "obl_cng_flg", length));
			String[] cyOpCd = (JSPUtil.getParameter(request, prefix	+ "cy_op_cd", length));
			String[] doSplitFlg = (JSPUtil.getParameter(request, prefix	+ "do_split_flg", length));
			String[] idaImpGenMfNo = (JSPUtil.getParameter(request, prefix	+ "ida_imp_gen_mf_no", length));
			String[] infoCgoFlg = (JSPUtil.getParameter(request, prefix	+ "info_cgo_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] idaCstmsAsgnLineNo = (JSPUtil.getParameter(request, prefix	+ "ida_cstms_asgn_line_no", length));
			String[] newOblRdemKnt = (JSPUtil.getParameter(request, prefix	+ "new_obl_rdem_knt", length));
			String[] doHldFlg = (JSPUtil.getParameter(request, prefix	+ "do_hld_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cstmsRefNm = (JSPUtil.getParameter(request, prefix	+ "cstms_ref_nm", length));
			String[] idaCgorOrdYr = (JSPUtil.getParameter(request, prefix	+ "ida_cgor_ord_yr", length));
			String[] cstmsAsgnCtnt = (JSPUtil.getParameter(request, prefix	+ "cstms_asgn_ctnt", length));
			String[] doCngEvntCd = (JSPUtil.getParameter(request, prefix	+ "do_cng_evnt_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] oldOblRdemKnt = (JSPUtil.getParameter(request, prefix	+ "old_obl_rdem_knt", length));
			String[] cstmsRefCtnt = (JSPUtil.getParameter(request, prefix	+ "cstms_ref_ctnt", length));
			String[] cstmsAsgnNm = (JSPUtil.getParameter(request, prefix	+ "cstms_asgn_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorDoSaveVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (oblCngFlg[i] != null)
					model.setOblCngFlg(oblCngFlg[i]);
				if (cyOpCd[i] != null)
					model.setCyOpCd(cyOpCd[i]);
				if (doSplitFlg[i] != null)
					model.setDoSplitFlg(doSplitFlg[i]);
				if (idaImpGenMfNo[i] != null)
					model.setIdaImpGenMfNo(idaImpGenMfNo[i]);
				if (infoCgoFlg[i] != null)
					model.setInfoCgoFlg(infoCgoFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (idaCstmsAsgnLineNo[i] != null)
					model.setIdaCstmsAsgnLineNo(idaCstmsAsgnLineNo[i]);
				if (newOblRdemKnt[i] != null)
					model.setNewOblRdemKnt(newOblRdemKnt[i]);
				if (doHldFlg[i] != null)
					model.setDoHldFlg(doHldFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cstmsRefNm[i] != null)
					model.setCstmsRefNm(cstmsRefNm[i]);
				if (idaCgorOrdYr[i] != null)
					model.setIdaCgorOrdYr(idaCgorOrdYr[i]);
				if (cstmsAsgnCtnt[i] != null)
					model.setCstmsAsgnCtnt(cstmsAsgnCtnt[i]);
				if (doCngEvntCd[i] != null)
					model.setDoCngEvntCd(doCngEvntCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (oldOblRdemKnt[i] != null)
					model.setOldOblRdemKnt(oldOblRdemKnt[i]);
				if (cstmsRefCtnt[i] != null)
					model.setCstmsRefCtnt(cstmsRefCtnt[i]);
				if (cstmsAsgnNm[i] != null)
					model.setCstmsAsgnNm(cstmsAsgnNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorDoSaveVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorDoSaveVO[]
	 */
	public KorDoSaveVO[] getKorDoSaveVOs(){
		KorDoSaveVO[] vos = (KorDoSaveVO[])models.toArray(new KorDoSaveVO[models.size()]);
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
		this.oblCngFlg = this.oblCngFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cyOpCd = this.cyOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doSplitFlg = this.doSplitFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaImpGenMfNo = this.idaImpGenMfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.infoCgoFlg = this.infoCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaCstmsAsgnLineNo = this.idaCstmsAsgnLineNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newOblRdemKnt = this.newOblRdemKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doHldFlg = this.doHldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsRefNm = this.cstmsRefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaCgorOrdYr = this.idaCgorOrdYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsAsgnCtnt = this.cstmsAsgnCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doCngEvntCd = this.doCngEvntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldOblRdemKnt = this.oldOblRdemKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsRefCtnt = this.cstmsRefCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsAsgnNm = this.cstmsAsgnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	/**
	 * @param acount the acount to set
	 */
	public void setAcount(SignOnUserAccount acount) {
		this.acount = acount;
	}

	/**
	 * @return the acount
	 */
	public SignOnUserAccount getAcount() {
		return acount;
	}
}

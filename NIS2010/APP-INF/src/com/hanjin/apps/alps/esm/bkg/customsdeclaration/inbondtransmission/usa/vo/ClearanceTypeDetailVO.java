/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ClearanceTypeDetailVO.java
*@FileTitle : ClearanceTypeDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.12
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.05.12 김민정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.vo.InbondManifestDetailVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ClearanceTypeDetailVO extends InbondManifestDetailVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<ClearanceTypeDetailVO> models = new ArrayList<ClearanceTypeDetailVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String clrTpSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String deltDt = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrTpCd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String etrTp = null;
	/* Column Info */
	private String itTp = null;
	/* Column Info */
	private String ftzFlg = null;
	/* Column Info */
	private String hubLocCd = null;
	/* Column Info */
	private String cstmsLocCd = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String deltUsrId = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String dirDeFlg = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ClearanceTypeDetailVO() {}

	public ClearanceTypeDetailVO(String ibflag, String pagerows, String custCd, String custNm, String scNo, String podCd, String delCd, String clrTpSeq, String cmdtCd, String cmdtNm, String cntrTpCd, String ftzFlg, String etrTp, String itTp, String creDt, String creUsrId, String creOfcCd, String updDt, String updUsrId, String updOfcCd, String deltFlg, String deltDt, String deltUsrId, String hubLocCd, String cstmsLocCd, String deTermCd, String dirDeFlg) {
		this.updDt = updDt;
		this.custNm = custNm;
		this.deltFlg = deltFlg;
		this.clrTpSeq = clrTpSeq;
		this.creDt = creDt;
		this.delCd = delCd;
		this.deltDt = deltDt;
		this.cmdtNm = cmdtNm;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.cntrTpCd = cntrTpCd;
		this.cmdtCd = cmdtCd;
		this.creOfcCd = creOfcCd;
		this.custCd = custCd;
		this.scNo = scNo;
		this.etrTp = etrTp;
		this.itTp = itTp;
		this.ftzFlg = ftzFlg;
		this.hubLocCd = hubLocCd;
		this.cstmsLocCd = cstmsLocCd;
		this.updOfcCd = updOfcCd;
		this.updUsrId = updUsrId;
		this.deltUsrId = deltUsrId;
		this.deTermCd = deTermCd;
		this.dirDeFlg = dirDeFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("clr_tp_seq", getClrTpSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("delt_dt", getDeltDt());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_tp_cd", getCntrTpCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("etr_tp", getEtrTp());
		this.hashColumns.put("it_tp", getItTp());
		this.hashColumns.put("ftz_flg", getFtzFlg());
		this.hashColumns.put("hub_loc_cd", getHubLocCd());
		this.hashColumns.put("cstms_loc_cd", getCstmsLocCd());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("delt_usr_id", getDeltUsrId());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("dir_de_flg", getDirDeFlg());		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("clr_tp_seq", "clrTpSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("delt_dt", "deltDt");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_tp_cd", "cntrTpCd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("etr_tp", "etrTp");
		this.hashFields.put("it_tp", "itTp");
		this.hashFields.put("ftz_flg", "ftzFlg");
		this.hashFields.put("hub_loc_cd", "hubLocCd");
		this.hashFields.put("cstms_loc_cd", "cstmsLocCd");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("delt_usr_id", "deltUsrId");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("dir_de_flg", "dirDeFlg");		

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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return clrTpSeq
	 */
	public String getClrTpSeq() {
		return this.clrTpSeq;
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
	 * @return deltDt
	 */
	public String getDeltDt() {
		return this.deltDt;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
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
	 * @return cntrTpCd
	 */
	public String getCntrTpCd() {
		return this.cntrTpCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
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
	 * @return etrTp
	 */
	public String getEtrTp() {
		return this.etrTp;
	}
	
	/**
	 * Column Info
	 * @return itTp
	 */
	public String getItTp() {
		return this.itTp;
	}
	
	/**
	 * Column Info
	 * @return ftzFlg
	 */
	public String getFtzFlg() {
		return this.ftzFlg;
	}
	
	/**
	 * Column Info
	 * @return hubLocCd
	 */
	public String getHubLocCd() {
		return this.hubLocCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsLocCd
	 */
	public String getCstmsLocCd() {
		return this.cstmsLocCd;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return deltUsrId
	 */
	public String getDeltUsrId() {
		return this.deltUsrId;
	}

	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}

	/**
	 * Column Info
	 * @return dirDeFlg
	 */
	public String getDirDeFlg() {
		return this.dirDeFlg;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param clrTpSeq
	 */
	public void setClrTpSeq(String clrTpSeq) {
		this.clrTpSeq = clrTpSeq;
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
	 * @param deltDt
	 */
	public void setDeltDt(String deltDt) {
		this.deltDt = deltDt;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
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
	 * @param cntrTpCd
	 */
	public void setCntrTpCd(String cntrTpCd) {
		this.cntrTpCd = cntrTpCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
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
	 * @param etrTp
	 */
	public void setEtrTp(String etrTp) {
		this.etrTp = etrTp;
	}
	
	/**
	 * Column Info
	 * @param itTp
	 */
	public void setItTp(String itTp) {
		this.itTp = itTp;
	}
	
	/**
	 * Column Info
	 * @param ftzFlg
	 */
	public void setFtzFlg(String ftzFlg) {
		this.ftzFlg = ftzFlg;
	}
	
	/**
	 * Column Info
	 * @param hubLocCd
	 */
	public void setHubLocCd(String hubLocCd) {
		this.hubLocCd = hubLocCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsLocCd
	 */
	public void setCstmsLocCd(String cstmsLocCd) {
		this.cstmsLocCd = cstmsLocCd;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * Column Info
	 * @param deltUsrId
	 */
	public void setDeltUsrId(String deltUsrId) {
		this.deltUsrId = deltUsrId;
	}

	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param dirDeFlg
	 */
	public void setDirDeFlg(String dirDeFlg) {
		this.dirDeFlg = dirDeFlg;
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
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setClrTpSeq(JSPUtil.getParameter(request, prefix + "clr_tp_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setDeltDt(JSPUtil.getParameter(request, prefix + "delt_dt", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrTpCd(JSPUtil.getParameter(request, prefix + "cntr_tp_cd", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setEtrTp(JSPUtil.getParameter(request, prefix + "etr_tp", ""));
		setItTp(JSPUtil.getParameter(request, prefix + "it_tp", ""));
		setFtzFlg(JSPUtil.getParameter(request, prefix + "ftz_flg", ""));
		setHubLocCd(JSPUtil.getParameter(request, prefix + "hub_loc_cd", ""));
		setCstmsLocCd(JSPUtil.getParameter(request, prefix + "cstms_loc_cd", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setDeltUsrId(JSPUtil.getParameter(request, prefix + "delt_usr_id", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setDirDeFlg(JSPUtil.getParameter(request, prefix + "dir_de_flg", ""));		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ClearanceTypeDetailVO[]
	 */
	public ClearanceTypeDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ClearanceTypeDetailVO[]
	 */
	public ClearanceTypeDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ClearanceTypeDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] clrTpSeq = (JSPUtil.getParameter(request, prefix	+ "clr_tp_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] deltDt = (JSPUtil.getParameter(request, prefix	+ "delt_dt", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrTpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tp_cd", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] etrTp = (JSPUtil.getParameter(request, prefix	+ "etr_tp", length));
			String[] itTp = (JSPUtil.getParameter(request, prefix	+ "it_tp", length));
			String[] ftzFlg = (JSPUtil.getParameter(request, prefix	+ "ftz_flg", length));
			String[] hubLocCd = (JSPUtil.getParameter(request, prefix	+ "hub_loc_cd", length));
			String[] cstmsLocCd = (JSPUtil.getParameter(request, prefix	+ "cstms_loc_cd", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] deltUsrId = (JSPUtil.getParameter(request, prefix	+ "delt_usr_id", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] dirDeFlg = (JSPUtil.getParameter(request, prefix	+ "dir_de_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new ClearanceTypeDetailVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (clrTpSeq[i] != null)
					model.setClrTpSeq(clrTpSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (deltDt[i] != null)
					model.setDeltDt(deltDt[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrTpCd[i] != null)
					model.setCntrTpCd(cntrTpCd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (etrTp[i] != null)
					model.setEtrTp(etrTp[i]);
				if (itTp[i] != null)
					model.setItTp(itTp[i]);
				if (ftzFlg[i] != null)
					model.setFtzFlg(ftzFlg[i]);
				if (hubLocCd[i] != null)
					model.setHubLocCd(hubLocCd[i]);
				if (cstmsLocCd[i] != null)
					model.setCstmsLocCd(cstmsLocCd[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (deltUsrId[i] != null)
					model.setDeltUsrId(deltUsrId[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);				
				if (dirDeFlg[i] != null)
					model.setDirDeFlg(dirDeFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getClearanceTypeDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ClearanceTypeDetailVO[]
	 */
	public ClearanceTypeDetailVO[] getClearanceTypeDetailVOs(){
		ClearanceTypeDetailVO[] vos = (ClearanceTypeDetailVO[])models.toArray(new ClearanceTypeDetailVO[models.size()]);
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
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clrTpSeq = this.clrTpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltDt = this.deltDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpCd = this.cntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etrTp = this.etrTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itTp = this.itTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftzFlg = this.ftzFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubLocCd = this.hubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsLocCd = this.cstmsLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltUsrId = this.deltUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirDeFlg = this.dirDeFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
	}
}

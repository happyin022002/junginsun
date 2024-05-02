/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BrCmModiVO.java
*@FileTitle : BrCmModiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.17
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.17  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BrCmModiVO extends ManifestModificationVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<BrCmModiVO> models = new ArrayList<BrCmModiVO>();
	
	/* Column Info */
	private String ncmNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String shprTaxNo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cntrMfSeq = null;
	/* Column Info */
	private String obCneeTaxNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String obShprTaxNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String blNoChk = null;
	/* Column Info */
	private String blNoTp = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String brzCmdtCd = null;
	/* Column Info */
	private String obNtfyTaxNo = null;
	/* Column Info */
	private String cneeTaxNo = null;
	/* Column Info */
	private String brzDeclNo = null;
	/* Column Info */
	private String obBrzDeclNo = null;
	/* Column Info */
	private String ifFlag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String ioType = null;
	/* Column Info */
	private String keyBlNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String ntfyTaxNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BrCmModiVO() {}

	public BrCmModiVO(String ibflag, String pagerows, String ifFlag, String updDt, String brzCmdtCd, String ncmNo, String shprTaxNo, String cneeTaxNo, String ntfyTaxNo, String obShprTaxNo, String obCneeTaxNo, String obNtfyTaxNo, String creDt, String brzDeclNo, String obBrzDeclNo, String blNo, String keyBlNo, String cntrMfSeq, String blNoChk, String creUsrId, String cntrNo, String blNoTp, String updUsrId, String bkgNo, String ioType) {
		this.ncmNo = ncmNo;
		this.creDt = creDt;
		this.shprTaxNo = shprTaxNo;
		this.blNo = blNo;
		this.cntrMfSeq = cntrMfSeq;
		this.obCneeTaxNo = obCneeTaxNo;
		this.pagerows = pagerows;
		this.obShprTaxNo = obShprTaxNo;
		this.ibflag = ibflag;
		this.blNoChk = blNoChk;
		this.blNoTp = blNoTp;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.brzCmdtCd = brzCmdtCd;
		this.obNtfyTaxNo = obNtfyTaxNo;
		this.cneeTaxNo = cneeTaxNo;
		this.brzDeclNo = brzDeclNo;
		this.obBrzDeclNo = obBrzDeclNo;
		this.ifFlag = ifFlag;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.ioType = ioType;
		this.keyBlNo = keyBlNo;
		this.cntrNo = cntrNo;
		this.ntfyTaxNo = ntfyTaxNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ncm_no", getNcmNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("shpr_tax_no", getShprTaxNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cntr_mf_seq", getCntrMfSeq());
		this.hashColumns.put("ob_cnee_tax_no", getObCneeTaxNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ob_shpr_tax_no", getObShprTaxNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bl_no_chk", getBlNoChk());
		this.hashColumns.put("bl_no_tp", getBlNoTp());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("brz_cmdt_cd", getBrzCmdtCd());
		this.hashColumns.put("ob_ntfy_tax_no", getObNtfyTaxNo());
		this.hashColumns.put("cnee_tax_no", getCneeTaxNo());
		this.hashColumns.put("brz_decl_no", getBrzDeclNo());
		this.hashColumns.put("ob_brz_decl_no", getObBrzDeclNo());
		this.hashColumns.put("if_flag", getIfFlag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("io_type", getIoType());
		this.hashColumns.put("key_bl_no", getKeyBlNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ntfy_tax_no", getNtfyTaxNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ncm_no", "ncmNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("shpr_tax_no", "shprTaxNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cntr_mf_seq", "cntrMfSeq");
		this.hashFields.put("ob_cnee_tax_no", "obCneeTaxNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ob_shpr_tax_no", "obShprTaxNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bl_no_chk", "blNoChk");
		this.hashFields.put("bl_no_tp", "blNoTp");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("brz_cmdt_cd", "brzCmdtCd");
		this.hashFields.put("ob_ntfy_tax_no", "obNtfyTaxNo");
		this.hashFields.put("cnee_tax_no", "cneeTaxNo");
		this.hashFields.put("brz_decl_no", "brzDeclNo");
		this.hashFields.put("ob_brz_decl_no", "obBrzDeclNo");
		this.hashFields.put("if_flag", "ifFlag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("io_type", "ioType");
		this.hashFields.put("key_bl_no", "keyBlNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ntfy_tax_no", "ntfyTaxNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ncmNo
	 */
	public String getNcmNo() {
		return this.ncmNo;
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
	 * @return shprTaxNo
	 */
	public String getShprTaxNo() {
		return this.shprTaxNo;
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
	 * @return cntrMfSeq
	 */
	public String getCntrMfSeq() {
		return this.cntrMfSeq;
	}
	
	/**
	 * Column Info
	 * @return obCneeTaxNo
	 */
	public String getObCneeTaxNo() {
		return this.obCneeTaxNo;
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
	 * @return obShprTaxNo
	 */
	public String getObShprTaxNo() {
		return this.obShprTaxNo;
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
	 * @return blNoChk
	 */
	public String getBlNoChk() {
		return this.blNoChk;
	}
	
	/**
	 * Column Info
	 * @return blNoTp
	 */
	public String getBlNoTp() {
		return this.blNoTp;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return brzCmdtCd
	 */
	public String getBrzCmdtCd() {
		return this.brzCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return obNtfyTaxNo
	 */
	public String getObNtfyTaxNo() {
		return this.obNtfyTaxNo;
	}
	
	/**
	 * Column Info
	 * @return cneeTaxNo
	 */
	public String getCneeTaxNo() {
		return this.cneeTaxNo;
	}
	
	/**
	 * Column Info
	 * @return brzDeclNo
	 */
	public String getBrzDeclNo() {
		return this.brzDeclNo;
	}
	
	/**
	 * Column Info
	 * @return obBrzDeclNo
	 */
	public String getObBrzDeclNo() {
		return this.obBrzDeclNo;
	}
	
	/**
	 * Column Info
	 * @return ifFlag
	 */
	public String getIfFlag() {
		return this.ifFlag;
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
	 * @return ioType
	 */
	public String getIoType() {
		return this.ioType;
	}
	
	/**
	 * Column Info
	 * @return keyBlNo
	 */
	public String getKeyBlNo() {
		return this.keyBlNo;
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
	 * @return ntfyTaxNo
	 */
	public String getNtfyTaxNo() {
		return this.ntfyTaxNo;
	}
	

	/**
	 * Column Info
	 * @param ncmNo
	 */
	public void setNcmNo(String ncmNo) {
		this.ncmNo = ncmNo;
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
	 * @param shprTaxNo
	 */
	public void setShprTaxNo(String shprTaxNo) {
		this.shprTaxNo = shprTaxNo;
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
	 * @param cntrMfSeq
	 */
	public void setCntrMfSeq(String cntrMfSeq) {
		this.cntrMfSeq = cntrMfSeq;
	}
	
	/**
	 * Column Info
	 * @param obCneeTaxNo
	 */
	public void setObCneeTaxNo(String obCneeTaxNo) {
		this.obCneeTaxNo = obCneeTaxNo;
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
	 * @param obShprTaxNo
	 */
	public void setObShprTaxNo(String obShprTaxNo) {
		this.obShprTaxNo = obShprTaxNo;
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
	 * @param blNoChk
	 */
	public void setBlNoChk(String blNoChk) {
		this.blNoChk = blNoChk;
	}
	
	/**
	 * Column Info
	 * @param blNoTp
	 */
	public void setBlNoTp(String blNoTp) {
		this.blNoTp = blNoTp;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param brzCmdtCd
	 */
	public void setBrzCmdtCd(String brzCmdtCd) {
		this.brzCmdtCd = brzCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param obNtfyTaxNo
	 */
	public void setObNtfyTaxNo(String obNtfyTaxNo) {
		this.obNtfyTaxNo = obNtfyTaxNo;
	}
	
	/**
	 * Column Info
	 * @param cneeTaxNo
	 */
	public void setCneeTaxNo(String cneeTaxNo) {
		this.cneeTaxNo = cneeTaxNo;
	}
	
	/**
	 * Column Info
	 * @param brzDeclNo
	 */
	public void setBrzDeclNo(String brzDeclNo) {
		this.brzDeclNo = brzDeclNo;
	}
	
	/**
	 * Column Info
	 * @param obBrzDeclNo
	 */
	public void setObBrzDeclNo(String obBrzDeclNo) {
		this.obBrzDeclNo = obBrzDeclNo;
	}
	
	/**
	 * Column Info
	 * @param ifFlag
	 */
	public void setIfFlag(String ifFlag) {
		this.ifFlag = ifFlag;
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
	 * @param ioType
	 */
	public void setIoType(String ioType) {
		this.ioType = ioType;
	}
	
	/**
	 * Column Info
	 * @param keyBlNo
	 */
	public void setKeyBlNo(String keyBlNo) {
		this.keyBlNo = keyBlNo;
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
	 * @param ntfyTaxNo
	 */
	public void setNtfyTaxNo(String ntfyTaxNo) {
		this.ntfyTaxNo = ntfyTaxNo;
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
		setNcmNo(JSPUtil.getParameter(request, prefix + "ncm_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setShprTaxNo(JSPUtil.getParameter(request, prefix + "shpr_tax_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCntrMfSeq(JSPUtil.getParameter(request, prefix + "cntr_mf_seq", ""));
		setObCneeTaxNo(JSPUtil.getParameter(request, prefix + "ob_cnee_tax_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setObShprTaxNo(JSPUtil.getParameter(request, prefix + "ob_shpr_tax_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBlNoChk(JSPUtil.getParameter(request, prefix + "bl_no_chk", ""));
		setBlNoTp(JSPUtil.getParameter(request, prefix + "bl_no_tp", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setBrzCmdtCd(JSPUtil.getParameter(request, prefix + "brz_cmdt_cd", ""));
		setObNtfyTaxNo(JSPUtil.getParameter(request, prefix + "ob_ntfy_tax_no", ""));
		setCneeTaxNo(JSPUtil.getParameter(request, prefix + "cnee_tax_no", ""));
		setBrzDeclNo(JSPUtil.getParameter(request, prefix + "brz_decl_no", ""));
		setObBrzDeclNo(JSPUtil.getParameter(request, prefix + "ob_brz_decl_no", ""));
		setIfFlag(JSPUtil.getParameter(request, prefix + "if_flag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIoType(JSPUtil.getParameter(request, prefix + "io_type", ""));
		setKeyBlNo(JSPUtil.getParameter(request, prefix + "key_bl_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setNtfyTaxNo(JSPUtil.getParameter(request, prefix + "ntfy_tax_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BrCmModiVO[]
	 */
	public BrCmModiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BrCmModiVO[]
	 */
	public BrCmModiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BrCmModiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ncmNo = (JSPUtil.getParameter(request, prefix	+ "ncm_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] shprTaxNo = (JSPUtil.getParameter(request, prefix	+ "shpr_tax_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cntrMfSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_seq", length));
			String[] obCneeTaxNo = (JSPUtil.getParameter(request, prefix	+ "ob_cnee_tax_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] obShprTaxNo = (JSPUtil.getParameter(request, prefix	+ "ob_shpr_tax_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] blNoChk = (JSPUtil.getParameter(request, prefix	+ "bl_no_chk", length));
			String[] blNoTp = (JSPUtil.getParameter(request, prefix	+ "bl_no_tp", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] brzCmdtCd = (JSPUtil.getParameter(request, prefix	+ "brz_cmdt_cd", length));
			String[] obNtfyTaxNo = (JSPUtil.getParameter(request, prefix	+ "ob_ntfy_tax_no", length));
			String[] cneeTaxNo = (JSPUtil.getParameter(request, prefix	+ "cnee_tax_no", length));
			String[] brzDeclNo = (JSPUtil.getParameter(request, prefix	+ "brz_decl_no", length));
			String[] obBrzDeclNo = (JSPUtil.getParameter(request, prefix	+ "ob_brz_decl_no", length));
			String[] ifFlag = (JSPUtil.getParameter(request, prefix	+ "if_flag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ioType = (JSPUtil.getParameter(request, prefix	+ "io_type", length));
			String[] keyBlNo = (JSPUtil.getParameter(request, prefix	+ "key_bl_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] ntfyTaxNo = (JSPUtil.getParameter(request, prefix	+ "ntfy_tax_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new BrCmModiVO();
				if (ncmNo[i] != null)
					model.setNcmNo(ncmNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (shprTaxNo[i] != null)
					model.setShprTaxNo(shprTaxNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cntrMfSeq[i] != null)
					model.setCntrMfSeq(cntrMfSeq[i]);
				if (obCneeTaxNo[i] != null)
					model.setObCneeTaxNo(obCneeTaxNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (obShprTaxNo[i] != null)
					model.setObShprTaxNo(obShprTaxNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (blNoChk[i] != null)
					model.setBlNoChk(blNoChk[i]);
				if (blNoTp[i] != null)
					model.setBlNoTp(blNoTp[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (brzCmdtCd[i] != null)
					model.setBrzCmdtCd(brzCmdtCd[i]);
				if (obNtfyTaxNo[i] != null)
					model.setObNtfyTaxNo(obNtfyTaxNo[i]);
				if (cneeTaxNo[i] != null)
					model.setCneeTaxNo(cneeTaxNo[i]);
				if (brzDeclNo[i] != null)
					model.setBrzDeclNo(brzDeclNo[i]);
				if (obBrzDeclNo[i] != null)
					model.setObBrzDeclNo(obBrzDeclNo[i]);
				if (ifFlag[i] != null)
					model.setIfFlag(ifFlag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ioType[i] != null)
					model.setIoType(ioType[i]);
				if (keyBlNo[i] != null)
					model.setKeyBlNo(keyBlNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (ntfyTaxNo[i] != null)
					model.setNtfyTaxNo(ntfyTaxNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBrCmModiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BrCmModiVO[]
	 */
	public BrCmModiVO[] getBrCmModiVOs(){
		BrCmModiVO[] vos = (BrCmModiVO[])models.toArray(new BrCmModiVO[models.size()]);
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
		this.ncmNo = this.ncmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprTaxNo = this.shprTaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfSeq = this.cntrMfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCneeTaxNo = this.obCneeTaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obShprTaxNo = this.obShprTaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoChk = this.blNoChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoTp = this.blNoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brzCmdtCd = this.brzCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obNtfyTaxNo = this.obNtfyTaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeTaxNo = this.cneeTaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brzDeclNo = this.brzDeclNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obBrzDeclNo = this.obBrzDeclNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFlag = this.ifFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioType = this.ioType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyBlNo = this.keyBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyTaxNo = this.ntfyTaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

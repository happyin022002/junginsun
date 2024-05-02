/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BrCnpiNcmByCntrModiVO.java
*@FileTitle : BrCnpiNcmByCntrModiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.05.22 경종윤 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ConatinerModificationtVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 경종윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BrCnpiNcmByCntrModiVO extends ConatinerModificationtVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<BrCnpiNcmByCntrModiVO> models = new ArrayList<BrCnpiNcmByCntrModiVO>();
	
	/* Column Info */
	private String iFFlag = null;
	/* Column Info */
	private String check = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String brzCmdtCd = null;
	/* Column Info */
	private String ncmNo = null;
	/* Column Info */
	private String shprTaxNo = null;
	/* Column Info */
	private String cneeTaxNo = null;
	/* Column Info */
	private String ntfyTaxNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String brzDeclNo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String keyBlNo = null;
	/* Column Info */
	private String cntrMfSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String blNoChk = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String blNoTp = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String brDuv = null;
	/* Column Info */
	private String brMid = null;
	/* Column Info */
	private String ncmMultiNo = null;
	/* Column Info */
	private String mfDtlSeq = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BrCnpiNcmByCntrModiVO() {}

	public BrCnpiNcmByCntrModiVO(String ibflag, String pagerows, String iFFlag, String check, String ncmNo, String blNo, String keyBlNo, String blNoTp, String blNoChk, String cntrMfSeq, String cntrNo, String shprTaxNo, String cneeTaxNo, String ntfyTaxNo, String brzDeclNo, String brzCmdtCd, String creUsrId, String creDt, String updUsrId, String updDt, String brDuv, String brMid, String ncmMultiNo, String mfDtlSeq) {
		this.iFFlag = iFFlag;
		this.check = check;
		this.updDt = updDt;
		this.brzCmdtCd = brzCmdtCd;
		this.ncmNo = ncmNo;
		this.shprTaxNo = shprTaxNo;
		this.cneeTaxNo = cneeTaxNo;
		this.ntfyTaxNo = ntfyTaxNo;
		this.creDt = creDt;
		this.brzDeclNo = brzDeclNo;
		this.blNo = blNo;
		this.keyBlNo = keyBlNo;
		this.cntrMfSeq = cntrMfSeq;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.blNoChk = blNoChk;
		this.creUsrId = creUsrId;
		this.cntrNo = cntrNo;
		this.blNoTp = blNoTp;
		this.updUsrId = updUsrId;
		this.brDuv = brDuv;
		this.brMid = brMid;
		this.ncmMultiNo = ncmMultiNo;
		this.mfDtlSeq = mfDtlSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("if_flag", getIfFlag());
		this.hashColumns.put("check", getCheck());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("brz_cmdt_cd", getBrzCmdtCd());
		this.hashColumns.put("ncm_no", getNcmNo());
		this.hashColumns.put("shpr_tax_no", getShprTaxNo());
		this.hashColumns.put("cnee_tax_no", getCneeTaxNo());
		this.hashColumns.put("ntfy_tax_no", getNtfyTaxNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("brz_decl_no", getBrzDeclNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("key_bl_no", getKeyBlNo());
		this.hashColumns.put("cntr_mf_seq", getCntrMfSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bl_no_chk", getBlNoChk());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("bl_no_tp", getBlNoTp());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("br_duv", getBrDuv());
		this.hashColumns.put("br_mid", getBrMid());
		this.hashColumns.put("ncm_multi_no", getNcmMultiNo());
		this.hashColumns.put("mf_dtl_seq", getMfDtlSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("if_flag", "if_flag");
		this.hashFields.put("check", "check");
		this.hashFields.put("brz_cmdt_cd", "brzCmdtCd");
		this.hashFields.put("ncm_no", "ncmNo");
		this.hashFields.put("shpr_tax_no", "shprTaxNo");
		this.hashFields.put("cnee_tax_no", "cneeTaxNo");
		this.hashFields.put("ntfy_tax_no", "ntfyTaxNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("brz_decl_no", "brzDeclNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("key_bl_no", "keyBlNo");
		this.hashFields.put("cntr_mf_seq", "cntrMfSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bl_no_chk", "blNoChk");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("bl_no_tp", "blNoTp");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("br_duv", "brDuv");
		this.hashFields.put("br_mid", "brMid");
		this.hashFields.put("ncm_multi_no", "ncmMultiNo");
		this.hashFields.put("mf_dtl_seq", "mfDtlSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return iFFlag
	 */
	public String getIfFlag() {
		return this.iFFlag;
	}

	/**
	 * Column Info
	 * @return check
	 */
	public String getCheck() {
		return this.check;
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
	 * @return ncmCd
	 */
	public String getNcmNo() {
		return this.ncmNo;
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
	 * @return cneeTaxNo
	 */
	public String getShprTaxNo() {
		return this.shprTaxNo;
	}
	/**
	 * Column Info
	 * @return cneeTaxNo
	 */
	public String getNtfyTaxNo() {
		return this.ntfyTaxNo;
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
	 * @return brzDeclNo
	 */
	public String getBrzDeclNo() {
		return this.brzDeclNo;
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
	 * @return keyBlNo
	 */
	public String getKeyBlNo() {
		return this.keyBlNo;
	}
	
	/**
	 * Column Info
	 * @return cntrMfSeq
	 */
	public String getCntrMfSeq() {
		return this.cntrMfSeq;
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
	 * @return blNoChk
	 */
	public String getBlNoChk() {
		return this.blNoChk;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @return brDuv
	 */
	public String getBrDuv() {
		return this.brDuv;
	}
	
	/**
	 * Column Info
	 * @return brMid
	 */
	public String getBrMid() {
		return this.brMid;
	}
	
	/**
	 * Column Info
	 * @return ncmMultiNo
	 */
	public String getNcmMultiNo() {
		return this.ncmMultiNo;
	}
	
	/**
	 * Column Info
	 * @return mfDtlSeq
	 */
	public String getMfDtlSeq() {
		return this.mfDtlSeq;
	}
	
	
	/**
	 * Column Info
	 * @param iFFlag
	 */
	public void setIfFlag(String iFFlag) {
		this.iFFlag = iFFlag;
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
	 * @param updDt
	 */
	public void setCheck(String check) {
		this.check = check;
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
	 * @param ncmNo
	 */
	public void setNcmNo(String ncmNo) {
		this.ncmNo = ncmNo;
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
	 * @param cneeTaxNo
	 */
	public void setShprTaxNo(String shprTaxNo) {
		this.shprTaxNo = shprTaxNo;
	}
	/**
	 * Column Info
	 * @param cneeTaxNo
	 */
	public void setNtfyTaxNo(String ntfyTaxNo) {
		this.ntfyTaxNo = ntfyTaxNo;
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
	 * @param brzDeclNo
	 */
	public void setBrzDeclNo(String brzDeclNo) {
		this.brzDeclNo = brzDeclNo;
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
	 * @param keyBlNo
	 */
	public void setKeyBlNo(String keyBlNo) {
		this.keyBlNo = keyBlNo;
	}

	/**
	 * Column Info
	 * @param cntrMfSeq
	 */
	public void setCntrMfSeq(String cntrMfSeq) {
		this.cntrMfSeq = cntrMfSeq;
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
	 * @param blNoChk
	 */
	public void setBlNoChk(String blNoChk) {
		this.blNoChk = blNoChk;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
	 * @param brDuv
	 */
	public void setBrDuv(String brDuv) {
		this.brDuv = brDuv;
	}
	
	/**
	 * Column Info
	 * @param brMid
	 */
	public void setBrMid(String brMid) {
		this.brMid = brMid;
	}
	
	/**
	 * Column Info
	 * @param ncmMultiNo
	 */
	public void setNcmMultiNo(String ncmMultiNo) {
		this.ncmMultiNo = ncmMultiNo;
	}
	
	/**
	 * Column Info
	 * @param mfDtlSeq
	 */
	public void setMfDtlSeq(String mfDtlSeq) {
		this.mfDtlSeq = mfDtlSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIfFlag(JSPUtil.getParameter(request, "if_flag", ""));
		setCheck(JSPUtil.getParameter(request, "check", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setBrzCmdtCd(JSPUtil.getParameter(request, "brz_cmdt_cd", ""));
		setNcmNo(JSPUtil.getParameter(request, "ncm_no", ""));
		setCneeTaxNo(JSPUtil.getParameter(request, "cnee_tax_no", ""));
		setCneeTaxNo(JSPUtil.getParameter(request, "shpr_tax_no", ""));
		setCneeTaxNo(JSPUtil.getParameter(request, "mtfy_tax_no", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setBrzDeclNo(JSPUtil.getParameter(request, "brz_decl_no", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setKeyBlNo(JSPUtil.getParameter(request, "key_bl_no", ""));
		setCntrMfSeq(JSPUtil.getParameter(request, "cntr_mf_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBlNoChk(JSPUtil.getParameter(request, "bl_no_chk", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setBlNoTp(JSPUtil.getParameter(request, "bl_no_tp", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setBrDuv(JSPUtil.getParameter(request, "br_duv", ""));
		setBrMid(JSPUtil.getParameter(request, "br_mid", ""));
		setNcmMultiNo(JSPUtil.getParameter(request, "ncm_multi_no", ""));
		setMfDtlSeq(JSPUtil.getParameter(request, "mf_dtl_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BrCmModiVO[]
	 */
	public BrCnpiNcmByCntrModiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BrCmModiVO[]
	 */
	public BrCnpiNcmByCntrModiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BrCnpiNcmByCntrModiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] iFFlag = (JSPUtil.getParameter(request, prefix	+ "if_flag".trim(), length));
			String[] check = (JSPUtil.getParameter(request, prefix	+ "check".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] brzCmdtCd = (JSPUtil.getParameter(request, prefix	+ "brz_cmdt_cd".trim(), length));
			String[] ncmNo = (JSPUtil.getParameter(request, prefix	+ "ncm_no".trim(), length));
			String[] cneeTaxNo = (JSPUtil.getParameter(request, prefix	+ "cnee_tax_no".trim(), length));
			String[] shprTaxNo = (JSPUtil.getParameter(request, prefix	+ "shpr_tax_no".trim(), length));
			String[] ntfyTaxNo = (JSPUtil.getParameter(request, prefix	+ "ntfy_tax_no".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] brzDeclNo = (JSPUtil.getParameter(request, prefix	+ "brz_decl_no".trim(), length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no".trim(), length));
			String[] keyBlNo = (JSPUtil.getParameter(request, prefix	+ "key_bl_no".trim(), length));
			String[] cntrMfSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_seq".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] blNoChk = (JSPUtil.getParameter(request, prefix	+ "bl_no_chk".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no".trim(), length));
			String[] blNoTp = (JSPUtil.getParameter(request, prefix	+ "bl_no_tp".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] brDuv = (JSPUtil.getParameter(request, prefix	+ "br_duv".trim(), length));
			String[] brMid = (JSPUtil.getParameter(request, prefix	+ "br_mid".trim(), length));
			String[] ncmMultiNo = (JSPUtil.getParameter(request, prefix	+ "ncm_multi_no".trim(), length));
			String[] mfDtlSeq = (JSPUtil.getParameter(request, prefix	+ "mf_dtl_seq".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new BrCnpiNcmByCntrModiVO();
				if (iFFlag[i] != null)
					model.setIfFlag(iFFlag[i]);
				if (check[i] != null)
					model.setCheck(check[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (brzCmdtCd[i] != null)
					model.setBrzCmdtCd(brzCmdtCd[i]);
				if (ncmNo[i] != null)
					model.setNcmNo(ncmNo[i]);
				if (cneeTaxNo[i] != null)
					model.setCneeTaxNo(cneeTaxNo[i]);
				if (shprTaxNo[i] != null)
					model.setShprTaxNo(shprTaxNo[i]);
				if (ntfyTaxNo[i] != null)
					model.setNtfyTaxNo(ntfyTaxNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (brzDeclNo[i] != null)
					model.setBrzDeclNo(brzDeclNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (keyBlNo[i] != null)
					model.setKeyBlNo(keyBlNo[i]);
				if (cntrMfSeq[i] != null)
					model.setCntrMfSeq(cntrMfSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (blNoChk[i] != null)
					model.setBlNoChk(blNoChk[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (blNoTp[i] != null)
					model.setBlNoTp(blNoTp[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (brDuv[i] != null)
					model.setBrDuv(brDuv[i]);
				if (brMid[i] != null)
					model.setBrMid(brMid[i]);
				if (ncmMultiNo[i] != null)
					model.setNcmMultiNo(ncmMultiNo[i]);
				if (mfDtlSeq[i] != null)
					model.setMfDtlSeq(mfDtlSeq[i]);
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
	public BrCnpiNcmByCntrModiVO[] getBrCmModiVOs(){
		BrCnpiNcmByCntrModiVO[] vos = (BrCnpiNcmByCntrModiVO[])models.toArray(new BrCnpiNcmByCntrModiVO[models.size()]);
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
		this.iFFlag = this.iFFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.check = this.check .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brzCmdtCd = this.brzCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ncmNo = this.ncmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeTaxNo = this.cneeTaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprTaxNo = this.shprTaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyTaxNo = this.ntfyTaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brzDeclNo = this.brzDeclNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyBlNo = this.keyBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfSeq = this.cntrMfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoChk = this.blNoChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoTp = this.blNoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brDuv = this.brDuv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brMid = this.brMid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ncmMultiNo = this.ncmMultiNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfDtlSeq = this.mfDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

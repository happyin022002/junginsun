/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PoolUseddysINVO.java
*@FileTitle : PoolUseddysINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.18
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2010.01.18 최민회 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo;

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
 * @author 최민회
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PoolUseddysINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PoolUseddysINVO> models = new ArrayList<PoolUseddysINVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String chssPoolCd = null;
	/* Column Info */
	private String fileImpDt = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String saveChk = null;
	/* Column Info */
	private String savFileNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String impRsltDesc = null;
	/* Column Info */
	private String orgFileNm = null;
	/* Column Info */
	private String fileSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String fileImpProcStsCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PoolUseddysINVO() {}

	public PoolUseddysINVO(String ibflag, String pagerows, String saveChk, String fileSeq, String orgFileNm, String savFileNm, String chssPoolCd, String costYrmon, String fileImpProcStsCd, String impRsltDesc, String fileImpDt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.chssPoolCd = chssPoolCd;
		this.fileImpDt = fileImpDt;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.saveChk = saveChk;
		this.savFileNm = savFileNm;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.costYrmon = costYrmon;
		this.impRsltDesc = impRsltDesc;
		this.orgFileNm = orgFileNm;
		this.fileSeq = fileSeq;
		this.updUsrId = updUsrId;
		this.fileImpProcStsCd = fileImpProcStsCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("chss_pool_cd", getChssPoolCd());
		this.hashColumns.put("file_imp_dt", getFileImpDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("save_chk", getSaveChk());
		this.hashColumns.put("sav_file_nm", getSavFileNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("imp_rslt_desc", getImpRsltDesc());
		this.hashColumns.put("org_file_nm", getOrgFileNm());
		this.hashColumns.put("file_seq", getFileSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("file_imp_proc_sts_cd", getFileImpProcStsCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("chss_pool_cd", "chssPoolCd");
		this.hashFields.put("file_imp_dt", "fileImpDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("save_chk", "saveChk");
		this.hashFields.put("sav_file_nm", "savFileNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("imp_rslt_desc", "impRsltDesc");
		this.hashFields.put("org_file_nm", "orgFileNm");
		this.hashFields.put("file_seq", "fileSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("file_imp_proc_sts_cd", "fileImpProcStsCd");
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
	 * @return chssPoolCd
	 */
	public String getChssPoolCd() {
		return this.chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @return fileImpDt
	 */
	public String getFileImpDt() {
		return this.fileImpDt;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return saveChk
	 */
	public String getSaveChk() {
		return this.saveChk;
	}
	
	/**
	 * Column Info
	 * @return savFileNm
	 */
	public String getSavFileNm() {
		return this.savFileNm;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return impRsltDesc
	 */
	public String getImpRsltDesc() {
		return this.impRsltDesc;
	}
	
	/**
	 * Column Info
	 * @return orgFileNm
	 */
	public String getOrgFileNm() {
		return this.orgFileNm;
	}
	
	/**
	 * Column Info
	 * @return fileSeq
	 */
	public String getFileSeq() {
		return this.fileSeq;
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
	 * @return fileImpProcStsCd
	 */
	public String getFileImpProcStsCd() {
		return this.fileImpProcStsCd;
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
	 * @param chssPoolCd
	 */
	public void setChssPoolCd(String chssPoolCd) {
		this.chssPoolCd = chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @param fileImpDt
	 */
	public void setFileImpDt(String fileImpDt) {
		this.fileImpDt = fileImpDt;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param saveChk
	 */
	public void setSaveChk(String saveChk) {
		this.saveChk = saveChk;
	}
	
	/**
	 * Column Info
	 * @param savFileNm
	 */
	public void setSavFileNm(String savFileNm) {
		this.savFileNm = savFileNm;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param impRsltDesc
	 */
	public void setImpRsltDesc(String impRsltDesc) {
		this.impRsltDesc = impRsltDesc;
	}
	
	/**
	 * Column Info
	 * @param orgFileNm
	 */
	public void setOrgFileNm(String orgFileNm) {
		this.orgFileNm = orgFileNm;
	}
	
	/**
	 * Column Info
	 * @param fileSeq
	 */
	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
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
	 * @param fileImpProcStsCd
	 */
	public void setFileImpProcStsCd(String fileImpProcStsCd) {
		this.fileImpProcStsCd = fileImpProcStsCd;
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
		setChssPoolCd(JSPUtil.getParameter(request, prefix + "chss_pool_cd", ""));
		setFileImpDt(JSPUtil.getParameter(request, prefix + "file_imp_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSaveChk(JSPUtil.getParameter(request, prefix + "save_chk", ""));
		setSavFileNm(JSPUtil.getParameter(request, prefix + "sav_file_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setImpRsltDesc(JSPUtil.getParameter(request, prefix + "imp_rslt_desc", ""));
		setOrgFileNm(JSPUtil.getParameter(request, prefix + "org_file_nm", ""));
		setFileSeq(JSPUtil.getParameter(request, prefix + "file_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setFileImpProcStsCd(JSPUtil.getParameter(request, prefix + "file_imp_proc_sts_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PoolUseddysINVO[]
	 */
	public PoolUseddysINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PoolUseddysINVO[]
	 */
	public PoolUseddysINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PoolUseddysINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] chssPoolCd = (JSPUtil.getParameter(request, prefix	+ "chss_pool_cd", length));
			String[] fileImpDt = (JSPUtil.getParameter(request, prefix	+ "file_imp_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] saveChk = (JSPUtil.getParameter(request, prefix	+ "save_chk", length));
			String[] savFileNm = (JSPUtil.getParameter(request, prefix	+ "sav_file_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] impRsltDesc = (JSPUtil.getParameter(request, prefix	+ "imp_rslt_desc", length));
			String[] orgFileNm = (JSPUtil.getParameter(request, prefix	+ "org_file_nm", length));
			String[] fileSeq = (JSPUtil.getParameter(request, prefix	+ "file_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] fileImpProcStsCd = (JSPUtil.getParameter(request, prefix	+ "file_imp_proc_sts_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PoolUseddysINVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (chssPoolCd[i] != null)
					model.setChssPoolCd(chssPoolCd[i]);
				if (fileImpDt[i] != null)
					model.setFileImpDt(fileImpDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (saveChk[i] != null)
					model.setSaveChk(saveChk[i]);
				if (savFileNm[i] != null)
					model.setSavFileNm(savFileNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (impRsltDesc[i] != null)
					model.setImpRsltDesc(impRsltDesc[i]);
				if (orgFileNm[i] != null)
					model.setOrgFileNm(orgFileNm[i]);
				if (fileSeq[i] != null)
					model.setFileSeq(fileSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (fileImpProcStsCd[i] != null)
					model.setFileImpProcStsCd(fileImpProcStsCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPoolUseddysINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PoolUseddysINVO[]
	 */
	public PoolUseddysINVO[] getPoolUseddysINVOs(){
		PoolUseddysINVO[] vos = (PoolUseddysINVO[])models.toArray(new PoolUseddysINVO[models.size()]);
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
		this.chssPoolCd = this.chssPoolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileImpDt = this.fileImpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saveChk = this.saveChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.savFileNm = this.savFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.impRsltDesc = this.impRsltDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgFileNm = this.orgFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq = this.fileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileImpProcStsCd = this.fileImpProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

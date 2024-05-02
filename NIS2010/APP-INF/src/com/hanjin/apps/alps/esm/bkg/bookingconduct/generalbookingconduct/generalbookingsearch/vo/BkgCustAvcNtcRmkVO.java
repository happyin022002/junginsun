/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BkgCustAvcNtcRmkVO.java
*@FileTitle : BkgCustAvcNtcRmkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.19
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.19  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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

public class BkgCustAvcNtcRmkVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCustAvcNtcRmkVO> models = new ArrayList<BkgCustAvcNtcRmkVO>();
	
	/* Column Info */
	private String fileSavId = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String fileDesc = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String emlSubjCtntSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String btnType = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String imptNtcRmk = null;
	/* Column Info */
	private String preEmlSubjCtntSeq = null;
	/* Column Info */
	private String rmkUseFlg = null;
	/* Column Info */
	private String filePathRmk = null;
	/* Column Info */
	private String emlSubjCtnt = null;
	/* Column Info */
	private String fileNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgCustAvcNtcRmkVO() {}

	public BkgCustAvcNtcRmkVO(String ibflag, String pagerows, String vvd, String creDt, String imptNtcRmk, String emlSubjCtnt, String deltFlg, String ofcCd, String rmkUseFlg, String emlSubjCtntSeq, String preEmlSubjCtntSeq, String btnType, String fileNm, String filePathRmk, String fileSavId, String fileDesc) {
		this.fileSavId = fileSavId;
		this.deltFlg = deltFlg;
		this.fileDesc = fileDesc;
		this.creDt = creDt;
		this.emlSubjCtntSeq = emlSubjCtntSeq;
		this.pagerows = pagerows;
		this.btnType = btnType;
		this.vvd = vvd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.imptNtcRmk = imptNtcRmk;
		this.preEmlSubjCtntSeq = preEmlSubjCtntSeq;
		this.rmkUseFlg = rmkUseFlg;
		this.filePathRmk = filePathRmk;
		this.emlSubjCtnt = emlSubjCtnt;
		this.fileNm = fileNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("file_desc", getFileDesc());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("eml_subj_ctnt_seq", getEmlSubjCtntSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("btn_type", getBtnType());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("impt_ntc_rmk", getImptNtcRmk());
		this.hashColumns.put("pre_eml_subj_ctnt_seq", getPreEmlSubjCtntSeq());
		this.hashColumns.put("rmk_use_flg", getRmkUseFlg());
		this.hashColumns.put("file_path_rmk", getFilePathRmk());
		this.hashColumns.put("eml_subj_ctnt", getEmlSubjCtnt());
		this.hashColumns.put("file_nm", getFileNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("file_desc", "fileDesc");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eml_subj_ctnt_seq", "emlSubjCtntSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("btn_type", "btnType");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("impt_ntc_rmk", "imptNtcRmk");
		this.hashFields.put("pre_eml_subj_ctnt_seq", "preEmlSubjCtntSeq");
		this.hashFields.put("rmk_use_flg", "rmkUseFlg");
		this.hashFields.put("file_path_rmk", "filePathRmk");
		this.hashFields.put("eml_subj_ctnt", "emlSubjCtnt");
		this.hashFields.put("file_nm", "fileNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fileSavId
	 */
	public String getFileSavId() {
		return this.fileSavId;
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
	 * @return fileDesc
	 */
	public String getFileDesc() {
		return this.fileDesc;
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
	 * @return emlSubjCtntSeq
	 */
	public String getEmlSubjCtntSeq() {
		return this.emlSubjCtntSeq;
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
	 * @return btnType
	 */
	public String getBtnType() {
		return this.btnType;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return imptNtcRmk
	 */
	public String getImptNtcRmk() {
		return this.imptNtcRmk;
	}
	
	/**
	 * Column Info
	 * @return preEmlSubjCtntSeq
	 */
	public String getPreEmlSubjCtntSeq() {
		return this.preEmlSubjCtntSeq;
	}
	
	/**
	 * Column Info
	 * @return rmkUseFlg
	 */
	public String getRmkUseFlg() {
		return this.rmkUseFlg;
	}
	
	/**
	 * Column Info
	 * @return filePathRmk
	 */
	public String getFilePathRmk() {
		return this.filePathRmk;
	}
	
	/**
	 * Column Info
	 * @return emlSubjCtnt
	 */
	public String getEmlSubjCtnt() {
		return this.emlSubjCtnt;
	}
	
	/**
	 * Column Info
	 * @return fileNm
	 */
	public String getFileNm() {
		return this.fileNm;
	}
	

	/**
	 * Column Info
	 * @param fileSavId
	 */
	public void setFileSavId(String fileSavId) {
		this.fileSavId = fileSavId;
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
	 * @param fileDesc
	 */
	public void setFileDesc(String fileDesc) {
		this.fileDesc = fileDesc;
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
	 * @param emlSubjCtntSeq
	 */
	public void setEmlSubjCtntSeq(String emlSubjCtntSeq) {
		this.emlSubjCtntSeq = emlSubjCtntSeq;
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
	 * @param btnType
	 */
	public void setBtnType(String btnType) {
		this.btnType = btnType;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param imptNtcRmk
	 */
	public void setImptNtcRmk(String imptNtcRmk) {
		this.imptNtcRmk = imptNtcRmk;
	}
	
	/**
	 * Column Info
	 * @param preEmlSubjCtntSeq
	 */
	public void setPreEmlSubjCtntSeq(String preEmlSubjCtntSeq) {
		this.preEmlSubjCtntSeq = preEmlSubjCtntSeq;
	}
	
	/**
	 * Column Info
	 * @param rmkUseFlg
	 */
	public void setRmkUseFlg(String rmkUseFlg) {
		this.rmkUseFlg = rmkUseFlg;
	}
	
	/**
	 * Column Info
	 * @param filePathRmk
	 */
	public void setFilePathRmk(String filePathRmk) {
		this.filePathRmk = filePathRmk;
	}
	
	/**
	 * Column Info
	 * @param emlSubjCtnt
	 */
	public void setEmlSubjCtnt(String emlSubjCtnt) {
		this.emlSubjCtnt = emlSubjCtnt;
	}
	
	/**
	 * Column Info
	 * @param fileNm
	 */
	public void setFileNm(String fileNm) {
		this.fileNm = fileNm;
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
		setFileSavId(JSPUtil.getParameter(request, prefix + "file_sav_id", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setFileDesc(JSPUtil.getParameter(request, prefix + "file_desc", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEmlSubjCtntSeq(JSPUtil.getParameter(request, prefix + "eml_subj_ctnt_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBtnType(JSPUtil.getParameter(request, prefix + "btn_type", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setImptNtcRmk(JSPUtil.getParameter(request, prefix + "impt_ntc_rmk", ""));
		setPreEmlSubjCtntSeq(JSPUtil.getParameter(request, prefix + "pre_eml_subj_ctnt_seq", ""));
		setRmkUseFlg(JSPUtil.getParameter(request, prefix + "rmk_use_flg", ""));
		setFilePathRmk(JSPUtil.getParameter(request, prefix + "file_path_rmk", ""));
		setEmlSubjCtnt(JSPUtil.getParameter(request, prefix + "eml_subj_ctnt", ""));
		setFileNm(JSPUtil.getParameter(request, prefix + "file_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCustAvcNtcRmkVO[]
	 */
	public BkgCustAvcNtcRmkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCustAvcNtcRmkVO[]
	 */
	public BkgCustAvcNtcRmkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCustAvcNtcRmkVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] fileDesc = (JSPUtil.getParameter(request, prefix	+ "file_desc", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] emlSubjCtntSeq = (JSPUtil.getParameter(request, prefix	+ "eml_subj_ctnt_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] btnType = (JSPUtil.getParameter(request, prefix	+ "btn_type", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] imptNtcRmk = (JSPUtil.getParameter(request, prefix	+ "impt_ntc_rmk", length));
			String[] preEmlSubjCtntSeq = (JSPUtil.getParameter(request, prefix	+ "pre_eml_subj_ctnt_seq", length));
			String[] rmkUseFlg = (JSPUtil.getParameter(request, prefix	+ "rmk_use_flg", length));
			String[] filePathRmk = (JSPUtil.getParameter(request, prefix	+ "file_path_rmk", length));
			String[] emlSubjCtnt = (JSPUtil.getParameter(request, prefix	+ "eml_subj_ctnt", length));
			String[] fileNm = (JSPUtil.getParameter(request, prefix	+ "file_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCustAvcNtcRmkVO();
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (fileDesc[i] != null)
					model.setFileDesc(fileDesc[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (emlSubjCtntSeq[i] != null)
					model.setEmlSubjCtntSeq(emlSubjCtntSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (btnType[i] != null)
					model.setBtnType(btnType[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (imptNtcRmk[i] != null)
					model.setImptNtcRmk(imptNtcRmk[i]);
				if (preEmlSubjCtntSeq[i] != null)
					model.setPreEmlSubjCtntSeq(preEmlSubjCtntSeq[i]);
				if (rmkUseFlg[i] != null)
					model.setRmkUseFlg(rmkUseFlg[i]);
				if (filePathRmk[i] != null)
					model.setFilePathRmk(filePathRmk[i]);
				if (emlSubjCtnt[i] != null)
					model.setEmlSubjCtnt(emlSubjCtnt[i]);
				if (fileNm[i] != null)
					model.setFileNm(fileNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCustAvcNtcRmkVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCustAvcNtcRmkVO[]
	 */
	public BkgCustAvcNtcRmkVO[] getBkgCustAvcNtcRmkVOs(){
		BkgCustAvcNtcRmkVO[] vos = (BkgCustAvcNtcRmkVO[])models.toArray(new BkgCustAvcNtcRmkVO[models.size()]);
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
		this.fileSavId = this.fileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDesc = this.fileDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSubjCtntSeq = this.emlSubjCtntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btnType = this.btnType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imptNtcRmk = this.imptNtcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preEmlSubjCtntSeq = this.preEmlSubjCtntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmkUseFlg = this.rmkUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.filePathRmk = this.filePathRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSubjCtnt = this.emlSubjCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileNm = this.fileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

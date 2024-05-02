/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PanamaManifestTransmitVO.java
*@FileTitle : PanamaManifestTransmitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.07
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.12.07 김승민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.panama.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김승민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PanamaManifestTransmitVO extends ManifestTransmitVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<PanamaManifestTransmitVO> models = new ArrayList<PanamaManifestTransmitVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String errorType = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String mvmtSeq = null;
	/* Column Info */
	private String dgpackage = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pnmVslOprCd = null;
	/* Column Info */
	private String clptSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pnmDestCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String pnmOrgCd = null;
	/* Column Info */
	private String ediSndDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String vstNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PanamaManifestTransmitVO() {}

	public PanamaManifestTransmitVO(String ibflag, String pagerows, String pnmVslOprCd, String clptSeq, String skdDirCd, String dgpackage, String errorType, String pnmOrgCd, String pnmDestCd, String vstNo, String mvmtSeq, String vvdCd, String vslCd, String skdVoyNo, String updUsrId, String ediSndDt) {
		this.vslCd = vslCd;
		this.errorType = errorType;
		this.skdVoyNo = skdVoyNo;
		this.mvmtSeq = mvmtSeq;
		this.dgpackage = dgpackage;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.pnmVslOprCd = pnmVslOprCd;
		this.clptSeq = clptSeq;
		this.ibflag = ibflag;
		this.pnmDestCd = pnmDestCd;
		this.vvdCd = vvdCd;
		this.pnmOrgCd = pnmOrgCd;
		this.ediSndDt = ediSndDt;
		this.updUsrId = updUsrId;
		this.vstNo = vstNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("error_type", getErrorType());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("mvmt_seq", getMvmtSeq());
		this.hashColumns.put("dgpackage", getDgpackage());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pnm_vsl_opr_cd", getPnmVslOprCd());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pnm_dest_cd", getPnmDestCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("pnm_org_cd", getPnmOrgCd());
		this.hashColumns.put("edi_snd_dt", getEdiSndDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("vst_no", getVstNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("error_type", "errorType");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("mvmt_seq", "mvmtSeq");
		this.hashFields.put("dgpackage", "dgpackage");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pnm_vsl_opr_cd", "pnmVslOprCd");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pnm_dest_cd", "pnmDestCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("pnm_org_cd", "pnmOrgCd");
		this.hashFields.put("edi_snd_dt", "ediSndDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("vst_no", "vstNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return errorType
	 */
	public String getErrorType() {
		return this.errorType;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return mvmtSeq
	 */
	public String getMvmtSeq() {
		return this.mvmtSeq;
	}
	
	/**
	 * Column Info
	 * @return dgpackage
	 */
	public String getDgpackage() {
		return this.dgpackage;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return pnmVslOprCd
	 */
	public String getPnmVslOprCd() {
		return this.pnmVslOprCd;
	}
	
	/**
	 * Column Info
	 * @return clptSeq
	 */
	public String getClptSeq() {
		return this.clptSeq;
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
	 * @return pnmDestCd
	 */
	public String getPnmDestCd() {
		return this.pnmDestCd;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return pnmOrgCd
	 */
	public String getPnmOrgCd() {
		return this.pnmOrgCd;
	}
	
	/**
	 * Column Info
	 * @return ediSndDt
	 */
	public String getEdiSndDt() {
		return this.ediSndDt;
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
	 * @return vstNo
	 */
	public String getVstNo() {
		return this.vstNo;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param errorType
	 */
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param mvmtSeq
	 */
	public void setMvmtSeq(String mvmtSeq) {
		this.mvmtSeq = mvmtSeq;
	}
	
	/**
	 * Column Info
	 * @param dgpackage
	 */
	public void setDgpackage(String dgpackage) {
		this.dgpackage = dgpackage;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param pnmVslOprCd
	 */
	public void setPnmVslOprCd(String pnmVslOprCd) {
		this.pnmVslOprCd = pnmVslOprCd;
	}
	
	/**
	 * Column Info
	 * @param clptSeq
	 */
	public void setClptSeq(String clptSeq) {
		this.clptSeq = clptSeq;
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
	 * @param pnmDestCd
	 */
	public void setPnmDestCd(String pnmDestCd) {
		this.pnmDestCd = pnmDestCd;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param pnmOrgCd
	 */
	public void setPnmOrgCd(String pnmOrgCd) {
		this.pnmOrgCd = pnmOrgCd;
	}
	
	/**
	 * Column Info
	 * @param ediSndDt
	 */
	public void setEdiSndDt(String ediSndDt) {
		this.ediSndDt = ediSndDt;
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
	 * @param vstNo
	 */
	public void setVstNo(String vstNo) {
		this.vstNo = vstNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setErrorType(JSPUtil.getParameter(request, "error_type", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setMvmtSeq(JSPUtil.getParameter(request, "mvmt_seq", ""));
		setDgpackage(JSPUtil.getParameter(request, "dgpackage", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPnmVslOprCd(JSPUtil.getParameter(request, "pnm_vsl_opr_cd", ""));
		setClptSeq(JSPUtil.getParameter(request, "clpt_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPnmDestCd(JSPUtil.getParameter(request, "pnm_dest_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setPnmOrgCd(JSPUtil.getParameter(request, "pnm_org_cd", ""));
		setEdiSndDt(JSPUtil.getParameter(request, "edi_snd_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setVstNo(JSPUtil.getParameter(request, "vst_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PanamaManifestTransmitVO[]
	 */
	public PanamaManifestTransmitVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PanamaManifestTransmitVO[]
	 */
	public PanamaManifestTransmitVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PanamaManifestTransmitVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] errorType = (JSPUtil.getParameter(request, prefix	+ "error_type", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] mvmtSeq = (JSPUtil.getParameter(request, prefix	+ "mvmt_seq", length));
			String[] dgpackage = (JSPUtil.getParameter(request, prefix	+ "dgpackage", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pnmVslOprCd = (JSPUtil.getParameter(request, prefix	+ "pnm_vsl_opr_cd", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pnmDestCd = (JSPUtil.getParameter(request, prefix	+ "pnm_dest_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] pnmOrgCd = (JSPUtil.getParameter(request, prefix	+ "pnm_org_cd", length));
			String[] ediSndDt = (JSPUtil.getParameter(request, prefix	+ "edi_snd_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] vstNo = (JSPUtil.getParameter(request, prefix	+ "vst_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new PanamaManifestTransmitVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (errorType[i] != null)
					model.setErrorType(errorType[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (mvmtSeq[i] != null)
					model.setMvmtSeq(mvmtSeq[i]);
				if (dgpackage[i] != null)
					model.setDgpackage(dgpackage[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pnmVslOprCd[i] != null)
					model.setPnmVslOprCd(pnmVslOprCd[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pnmDestCd[i] != null)
					model.setPnmDestCd(pnmDestCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (pnmOrgCd[i] != null)
					model.setPnmOrgCd(pnmOrgCd[i]);
				if (ediSndDt[i] != null)
					model.setEdiSndDt(ediSndDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (vstNo[i] != null)
					model.setVstNo(vstNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPanamaManifestTransmitVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PanamaManifestTransmitVO[]
	 */
	public PanamaManifestTransmitVO[] getPanamaManifestTransmitVOs(){
		PanamaManifestTransmitVO[] vos = (PanamaManifestTransmitVO[])models.toArray(new PanamaManifestTransmitVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errorType = this.errorType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtSeq = this.mvmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgpackage = this.dgpackage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pnmVslOprCd = this.pnmVslOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pnmDestCd = this.pnmDestCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pnmOrgCd = this.pnmOrgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndDt = this.ediSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vstNo = this.vstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

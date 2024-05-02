/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RocsManifestTransmitVO.java
*@FileTitle : RocsManifestTransmitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.07  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RocsManifestTransmitVO extends ManifestTransmitVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<RocsManifestTransmitVO> models = new ArrayList<RocsManifestTransmitVO>();
	
	/* Column Info */
	private String msgTp = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String frmCrnNumber = null;
	/* Column Info */
	private String msgDt = null;
	/* Column Info */
	private String preRlyPortCd = null;
	/* Column Info */
	private String errorDesc = null;
	/* Column Info */
	private String errorRff = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String blDatCfmDt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String kind = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String difChar = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String flag = null;
	/* Column Info */
	private String usertId = null;
	/* Column Info */
	private String errorCd = null;
	/* Column Info */
	private String dataCtnt = null;
	/* Column Info */
	private String varj = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RocsManifestTransmitVO() {}

	public RocsManifestTransmitVO(String ibflag, String pagerows, String vslCd, String frmCrnNumber, String msgDt, String msgTp, String dataCtnt, String skdVoyNo, String skdDirCd, String blNo, String kind, String varj, String podCd, String difChar, String ofcCd, String polCd, String bkgNo, String usertId, String flag, String errorCd, String errorDesc, String errorRff, String blDatCfmDt, String preRlyPortCd) {
		this.msgTp = msgTp;
		this.vslCd = vslCd;
		this.frmCrnNumber = frmCrnNumber;
		this.msgDt = msgDt;
		this.preRlyPortCd = preRlyPortCd;
		this.errorDesc = errorDesc;
		this.errorRff = errorRff;
		this.skdVoyNo = skdVoyNo;
		this.blDatCfmDt = blDatCfmDt;
		this.blNo = blNo;
		this.skdDirCd = skdDirCd;
		this.kind = kind;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.difChar = difChar;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.flag = flag;
		this.usertId = usertId;
		this.errorCd = errorCd;
		this.dataCtnt = dataCtnt;
		this.varj = varj;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("msg_tp", getMsgTp());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("frm_crn_number", getFrmCrnNumber());
		this.hashColumns.put("msg_dt", getMsgDt());
		this.hashColumns.put("pre_rly_port_cd", getPreRlyPortCd());
		this.hashColumns.put("error_desc", getErrorDesc());
		this.hashColumns.put("error_rff", getErrorRff());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("bl_dat_cfm_dt", getBlDatCfmDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("kind", getKind());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("dif_char", getDifChar());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("flag", getFlag());
		this.hashColumns.put("usert_id", getUsertId());
		this.hashColumns.put("error_cd", getErrorCd());
		this.hashColumns.put("data_ctnt", getDataCtnt());
		this.hashColumns.put("varj", getVarj());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("msg_tp", "msgTp");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("frm_crn_number", "frmCrnNumber");
		this.hashFields.put("msg_dt", "msgDt");
		this.hashFields.put("pre_rly_port_cd", "preRlyPortCd");
		this.hashFields.put("error_desc", "errorDesc");
		this.hashFields.put("error_rff", "errorRff");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("bl_dat_cfm_dt", "blDatCfmDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("kind", "kind");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("dif_char", "difChar");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("flag", "flag");
		this.hashFields.put("usert_id", "usertId");
		this.hashFields.put("error_cd", "errorCd");
		this.hashFields.put("data_ctnt", "dataCtnt");
		this.hashFields.put("varj", "varj");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return msgTp
	 */
	public String getMsgTp() {
		return this.msgTp;
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
	 * @return frmCrnNumber
	 */
	public String getFrmCrnNumber() {
		return this.frmCrnNumber;
	}
	
	/**
	 * Column Info
	 * @return msgDt
	 */
	public String getMsgDt() {
		return this.msgDt;
	}
	
	/**
	 * Column Info
	 * @return preRlyPortCd
	 */
	public String getPreRlyPortCd() {
		return this.preRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @return errorDesc
	 */
	public String getErrorDesc() {
		return this.errorDesc;
	}
	
	/**
	 * Column Info
	 * @return errorRff
	 */
	public String getErrorRff() {
		return this.errorRff;
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
	 * @return blDatCfmDt
	 */
	public String getBlDatCfmDt() {
		return this.blDatCfmDt;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return kind
	 */
	public String getKind() {
		return this.kind;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return difChar
	 */
	public String getDifChar() {
		return this.difChar;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return flag
	 */
	public String getFlag() {
		return this.flag;
	}
	
	/**
	 * Column Info
	 * @return usertId
	 */
	public String getUsertId() {
		return this.usertId;
	}
	
	/**
	 * Column Info
	 * @return errorCd
	 */
	public String getErrorCd() {
		return this.errorCd;
	}
	
	/**
	 * Column Info
	 * @return dataCtnt
	 */
	public String getDataCtnt() {
		return this.dataCtnt;
	}
	
	/**
	 * Column Info
	 * @return varj
	 */
	public String getVarj() {
		return this.varj;
	}
	

	/**
	 * Column Info
	 * @param msgTp
	 */
	public void setMsgTp(String msgTp) {
		this.msgTp = msgTp;
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
	 * @param frmCrnNumber
	 */
	public void setFrmCrnNumber(String frmCrnNumber) {
		this.frmCrnNumber = frmCrnNumber;
	}
	
	/**
	 * Column Info
	 * @param msgDt
	 */
	public void setMsgDt(String msgDt) {
		this.msgDt = msgDt;
	}
	
	/**
	 * Column Info
	 * @param preRlyPortCd
	 */
	public void setPreRlyPortCd(String preRlyPortCd) {
		this.preRlyPortCd = preRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @param errorDesc
	 */
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	
	/**
	 * Column Info
	 * @param errorRff
	 */
	public void setErrorRff(String errorRff) {
		this.errorRff = errorRff;
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
	 * @param blDatCfmDt
	 */
	public void setBlDatCfmDt(String blDatCfmDt) {
		this.blDatCfmDt = blDatCfmDt;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param kind
	 */
	public void setKind(String kind) {
		this.kind = kind;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param difChar
	 */
	public void setDifChar(String difChar) {
		this.difChar = difChar;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	/**
	 * Column Info
	 * @param usertId
	 */
	public void setUsertId(String usertId) {
		this.usertId = usertId;
	}
	
	/**
	 * Column Info
	 * @param errorCd
	 */
	public void setErrorCd(String errorCd) {
		this.errorCd = errorCd;
	}
	
	/**
	 * Column Info
	 * @param dataCtnt
	 */
	public void setDataCtnt(String dataCtnt) {
		this.dataCtnt = dataCtnt;
	}
	
	/**
	 * Column Info
	 * @param varj
	 */
	public void setVarj(String varj) {
		this.varj = varj;
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
		setMsgTp(JSPUtil.getParameter(request, prefix + "msg_tp", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setFrmCrnNumber(JSPUtil.getParameter(request, prefix + "frm_crn_number", ""));
		setMsgDt(JSPUtil.getParameter(request, prefix + "msg_dt", ""));
		setPreRlyPortCd(JSPUtil.getParameter(request, prefix + "pre_rly_port_cd", ""));
		setErrorDesc(JSPUtil.getParameter(request, prefix + "error_desc", ""));
		setErrorRff(JSPUtil.getParameter(request, prefix + "error_rff", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setBlDatCfmDt(JSPUtil.getParameter(request, prefix + "bl_dat_cfm_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setKind(JSPUtil.getParameter(request, prefix + "kind", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setDifChar(JSPUtil.getParameter(request, prefix + "dif_char", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFlag(JSPUtil.getParameter(request, prefix + "flag", ""));
		setUsertId(JSPUtil.getParameter(request, prefix + "usert_id", ""));
		setErrorCd(JSPUtil.getParameter(request, prefix + "error_cd", ""));
		setDataCtnt(JSPUtil.getParameter(request, prefix + "data_ctnt", ""));
		setVarj(JSPUtil.getParameter(request, prefix + "varj", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RocsManifestTransmitVO[]
	 */
	public RocsManifestTransmitVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RocsManifestTransmitVO[]
	 */
	public RocsManifestTransmitVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RocsManifestTransmitVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] msgTp = (JSPUtil.getParameter(request, prefix	+ "msg_tp", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] frmCrnNumber = (JSPUtil.getParameter(request, prefix	+ "frm_crn_number", length));
			String[] msgDt = (JSPUtil.getParameter(request, prefix	+ "msg_dt", length));
			String[] preRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pre_rly_port_cd", length));
			String[] errorDesc = (JSPUtil.getParameter(request, prefix	+ "error_desc", length));
			String[] errorRff = (JSPUtil.getParameter(request, prefix	+ "error_rff", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] blDatCfmDt = (JSPUtil.getParameter(request, prefix	+ "bl_dat_cfm_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] kind = (JSPUtil.getParameter(request, prefix	+ "kind", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] difChar = (JSPUtil.getParameter(request, prefix	+ "dif_char", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] flag = (JSPUtil.getParameter(request, prefix	+ "flag", length));
			String[] usertId = (JSPUtil.getParameter(request, prefix	+ "usert_id", length));
			String[] errorCd = (JSPUtil.getParameter(request, prefix	+ "error_cd", length));
			String[] dataCtnt = (JSPUtil.getParameter(request, prefix	+ "data_ctnt", length));
			String[] varj = (JSPUtil.getParameter(request, prefix	+ "varj", length));
			
			for (int i = 0; i < length; i++) {
				model = new RocsManifestTransmitVO();
				if (msgTp[i] != null)
					model.setMsgTp(msgTp[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (frmCrnNumber[i] != null)
					model.setFrmCrnNumber(frmCrnNumber[i]);
				if (msgDt[i] != null)
					model.setMsgDt(msgDt[i]);
				if (preRlyPortCd[i] != null)
					model.setPreRlyPortCd(preRlyPortCd[i]);
				if (errorDesc[i] != null)
					model.setErrorDesc(errorDesc[i]);
				if (errorRff[i] != null)
					model.setErrorRff(errorRff[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (blDatCfmDt[i] != null)
					model.setBlDatCfmDt(blDatCfmDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (kind[i] != null)
					model.setKind(kind[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (difChar[i] != null)
					model.setDifChar(difChar[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (flag[i] != null)
					model.setFlag(flag[i]);
				if (usertId[i] != null)
					model.setUsertId(usertId[i]);
				if (errorCd[i] != null)
					model.setErrorCd(errorCd[i]);
				if (dataCtnt[i] != null)
					model.setDataCtnt(dataCtnt[i]);
				if (varj[i] != null)
					model.setVarj(varj[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRocsManifestTransmitVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RocsManifestTransmitVO[]
	 */
	public RocsManifestTransmitVO[] getRocsManifestTransmitVOs(){
		RocsManifestTransmitVO[] vos = (RocsManifestTransmitVO[])models.toArray(new RocsManifestTransmitVO[models.size()]);
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
		this.msgTp = this.msgTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCrnNumber = this.frmCrnNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgDt = this.msgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRlyPortCd = this.preRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errorDesc = this.errorDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errorRff = this.errorRff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDatCfmDt = this.blDatCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kind = this.kind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.difChar = this.difChar .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flag = this.flag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usertId = this.usertId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errorCd = this.errorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dataCtnt = this.dataCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.varj = this.varj .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

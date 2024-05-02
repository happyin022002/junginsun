/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SceVpsIfVO.java
*@FileTitle : SceVpsIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.09
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.09  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.copdetailreceive.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SceVpsIfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SceVpsIfVO> models = new ArrayList<SceVpsIfVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vpsRcvNo = null;
	/* Column Info */
	private String vpsEvntDt = null;
	/* Column Info */
	private String vpsIfStsCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vpsLocCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vpsRcvDt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String umchChkDt = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String errMsg = null;
	/* Column Info */
	private String vslDlayRsnCd = null;
	/* Column Info */
	private String vpsEvntTpCd = null;
	/* Column Info */
	private String vslDlayRsnDesc = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info For History */
	private String dupFlg = null;
	/* EDI Column Info */
	private String ediKeyCd = null;	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SceVpsIfVO() {}

	public SceVpsIfVO(String ibflag, String pagerows, String vpsRcvDt, String vpsRcvNo, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String clptIndSeq, String vpsEvntTpCd, String vpsEvntDt, String vpsIfStsCd, String errMsg, String creUsrId, String creDt, String updUsrId, String updDt, String umchChkDt, String vslDlayRsnCd, String vslDlayRsnDesc, String vpsLocCd, String ediKeyCd, String dupFlg) {
		this.updDt = updDt;
		this.vslCd = vslCd;
		this.vpsRcvNo = vpsRcvNo;
		this.vpsEvntDt = vpsEvntDt;
		this.vpsIfStsCd = vpsIfStsCd;
		this.creDt = creDt;
		this.vpsLocCd = vpsLocCd;
		this.skdVoyNo = skdVoyNo;
		this.vpsRcvDt = vpsRcvDt;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.vpsPortCd = vpsPortCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.umchChkDt = umchChkDt;
		this.clptIndSeq = clptIndSeq;
		this.errMsg = errMsg;
		this.vslDlayRsnCd = vslDlayRsnCd;
		this.vpsEvntTpCd = vpsEvntTpCd;
		this.vslDlayRsnDesc = vslDlayRsnDesc;
		this.updUsrId = updUsrId;
		this.ediKeyCd = ediKeyCd;
		this.dupFlg = dupFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vps_rcv_no", getVpsRcvNo());
		this.hashColumns.put("vps_evnt_dt", getVpsEvntDt());
		this.hashColumns.put("vps_if_sts_cd", getVpsIfStsCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vps_loc_cd", getVpsLocCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vps_rcv_dt", getVpsRcvDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("umch_chk_dt", getUmchChkDt());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("err_msg", getErrMsg());
		this.hashColumns.put("vsl_dlay_rsn_cd", getVslDlayRsnCd());
		this.hashColumns.put("vps_evnt_tp_cd", getVpsEvntTpCd());
		this.hashColumns.put("vsl_dlay_rsn_desc", getVslDlayRsnDesc());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dup_flg", getUpdUsrId());
		this.hashColumns.put("edi_key_cd", getEdiKeyCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vps_rcv_no", "vpsRcvNo");
		this.hashFields.put("vps_evnt_dt", "vpsEvntDt");
		this.hashFields.put("vps_if_sts_cd", "vpsIfStsCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vps_loc_cd", "vpsLocCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vps_rcv_dt", "vpsRcvDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("umch_chk_dt", "umchChkDt");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("err_msg", "errMsg");
		this.hashFields.put("vsl_dlay_rsn_cd", "vslDlayRsnCd");
		this.hashFields.put("vps_evnt_tp_cd", "vpsEvntTpCd");
		this.hashFields.put("vsl_dlay_rsn_desc", "vslDlayRsnDesc");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("edi_key_cd", "ediKeyCd");
		this.hashFields.put("dup_flg", "dupFlg");
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return vpsRcvNo
	 */
	public String getVpsRcvNo() {
		return this.vpsRcvNo;
	}
	
	/**
	 * Column Info
	 * @return vpsEvntDt
	 */
	public String getVpsEvntDt() {
		return this.vpsEvntDt;
	}
	
	/**
	 * Column Info
	 * @return vpsIfStsCd
	 */
	public String getVpsIfStsCd() {
		return this.vpsIfStsCd;
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
	 * @return vpsLocCd
	 */
	public String getVpsLocCd() {
		return this.vpsLocCd;
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
	 * @return vpsRcvDt
	 */
	public String getVpsRcvDt() {
		return this.vpsRcvDt;
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
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
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
	 * @return umchChkDt
	 */
	public String getUmchChkDt() {
		return this.umchChkDt;
	}
	
	/**
	 * Column Info
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return errMsg
	 */
	public String getErrMsg() {
		return this.errMsg;
	}
	
	/**
	 * Column Info
	 * @return vslDlayRsnCd
	 */
	public String getVslDlayRsnCd() {
		return this.vslDlayRsnCd;
	}
	
	/**
	 * Column Info
	 * @return vpsEvntTpCd
	 */
	public String getVpsEvntTpCd() {
		return this.vpsEvntTpCd;
	}
	
	/**
	 * Column Info
	 * @return vslDlayRsnDesc
	 */
	public String getVslDlayRsnDesc() {
		return this.vslDlayRsnDesc;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * EDI Column Info
	 * @return ediKeyCd
	 */
	public String getEdiKeyCd() {
		return this.ediKeyCd;
	}
	
	/**
	 * Column Info
	 * @return dupFlg
	 */
	public String getDupFlg() {
		return this.dupFlg;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param vpsRcvNo
	 */
	public void setVpsRcvNo(String vpsRcvNo) {
		this.vpsRcvNo = vpsRcvNo;
	}
	
	/**
	 * Column Info
	 * @param vpsEvntDt
	 */
	public void setVpsEvntDt(String vpsEvntDt) {
		this.vpsEvntDt = vpsEvntDt;
	}
	
	/**
	 * Column Info
	 * @param vpsIfStsCd
	 */
	public void setVpsIfStsCd(String vpsIfStsCd) {
		this.vpsIfStsCd = vpsIfStsCd;
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
	 * @param vpsLocCd
	 */
	public void setVpsLocCd(String vpsLocCd) {
		this.vpsLocCd = vpsLocCd;
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
	 * @param vpsRcvDt
	 */
	public void setVpsRcvDt(String vpsRcvDt) {
		this.vpsRcvDt = vpsRcvDt;
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
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
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
	 * @param umchChkDt
	 */
	public void setUmchChkDt(String umchChkDt) {
		this.umchChkDt = umchChkDt;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param errMsg
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	/**
	 * Column Info
	 * @param vslDlayRsnCd
	 */
	public void setVslDlayRsnCd(String vslDlayRsnCd) {
		this.vslDlayRsnCd = vslDlayRsnCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEvntTpCd
	 */
	public void setVpsEvntTpCd(String vpsEvntTpCd) {
		this.vpsEvntTpCd = vpsEvntTpCd;
	}
	
	/**
	 * Column Info
	 * @param vslDlayRsnDesc
	 */
	public void setVslDlayRsnDesc(String vslDlayRsnDesc) {
		this.vslDlayRsnDesc = vslDlayRsnDesc;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * EDI Column Info
	 * @param ediKeyCd
	 */
	public void setEdiKeyCd(String ediKeyCd) {
		this.ediKeyCd = ediKeyCd;
	}
	
	/**
	 * Column Info
	 * @param dupFlg
	 */
	public void setDupFlg(String dupFlg) {
		this.dupFlg = dupFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setVpsRcvNo(JSPUtil.getParameter(request, "vps_rcv_no", ""));
		setVpsEvntDt(JSPUtil.getParameter(request, "vps_evnt_dt", ""));
		setVpsIfStsCd(JSPUtil.getParameter(request, "vps_if_sts_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setVpsLocCd(JSPUtil.getParameter(request, "vps_loc_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setVpsRcvDt(JSPUtil.getParameter(request, "vps_rcv_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUmchChkDt(JSPUtil.getParameter(request, "umch_chk_dt", ""));
		setClptIndSeq(JSPUtil.getParameter(request, "clpt_ind_seq", ""));
		setErrMsg(JSPUtil.getParameter(request, "err_msg", ""));
		setVslDlayRsnCd(JSPUtil.getParameter(request, "vsl_dlay_rsn_cd", ""));
		setVpsEvntTpCd(JSPUtil.getParameter(request, "vps_evnt_tp_cd", ""));
		setVslDlayRsnDesc(JSPUtil.getParameter(request, "vsl_dlay_rsn_desc", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setEdiKeyCd(JSPUtil.getParameter(request, "edi_key_cd", ""));
		setDupFlg(JSPUtil.getParameter(request, "dup_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SceVpsIfVO[]
	 */
	public SceVpsIfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SceVpsIfVO[]
	 */
	public SceVpsIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SceVpsIfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vpsRcvNo = (JSPUtil.getParameter(request, prefix	+ "vps_rcv_no", length));
			String[] vpsEvntDt = (JSPUtil.getParameter(request, prefix	+ "vps_evnt_dt", length));
			String[] vpsIfStsCd = (JSPUtil.getParameter(request, prefix	+ "vps_if_sts_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vpsLocCd = (JSPUtil.getParameter(request, prefix	+ "vps_loc_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vpsRcvDt = (JSPUtil.getParameter(request, prefix	+ "vps_rcv_dt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] umchChkDt = (JSPUtil.getParameter(request, prefix	+ "umch_chk_dt", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] errMsg = (JSPUtil.getParameter(request, prefix	+ "err_msg", length));
			String[] vslDlayRsnCd = (JSPUtil.getParameter(request, prefix	+ "vsl_dlay_rsn_cd", length));
			String[] vpsEvntTpCd = (JSPUtil.getParameter(request, prefix	+ "vps_evnt_tp_cd", length));
			String[] vslDlayRsnDesc = (JSPUtil.getParameter(request, prefix	+ "vsl_dlay_rsn_desc", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ediKeyCd = (JSPUtil.getParameter(request, prefix	+ "edi_key_cd", length));
			String[] dupFlg = (JSPUtil.getParameter(request, prefix	+ "dup_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SceVpsIfVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vpsRcvNo[i] != null)
					model.setVpsRcvNo(vpsRcvNo[i]);
				if (vpsEvntDt[i] != null)
					model.setVpsEvntDt(vpsEvntDt[i]);
				if (vpsIfStsCd[i] != null)
					model.setVpsIfStsCd(vpsIfStsCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vpsLocCd[i] != null)
					model.setVpsLocCd(vpsLocCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vpsRcvDt[i] != null)
					model.setVpsRcvDt(vpsRcvDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (umchChkDt[i] != null)
					model.setUmchChkDt(umchChkDt[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (errMsg[i] != null)
					model.setErrMsg(errMsg[i]);
				if (vslDlayRsnCd[i] != null)
					model.setVslDlayRsnCd(vslDlayRsnCd[i]);
				if (vpsEvntTpCd[i] != null)
					model.setVpsEvntTpCd(vpsEvntTpCd[i]);
				if (vslDlayRsnDesc[i] != null)
					model.setVslDlayRsnDesc(vslDlayRsnDesc[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ediKeyCd[i] != null)
					model.setEdiKeyCd(ediKeyCd[i]);
				if (dupFlg[i] != null)
					model.setDupFlg(dupFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSceVpsIfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SceVpsIfVO[]
	 */
	public SceVpsIfVO[] getSceVpsIfVOs(){
		SceVpsIfVO[] vos = (SceVpsIfVO[])models.toArray(new SceVpsIfVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsRcvNo = this.vpsRcvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEvntDt = this.vpsEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsIfStsCd = this.vpsIfStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsLocCd = this.vpsLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsRcvDt = this.vpsRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchChkDt = this.umchChkDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errMsg = this.errMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDlayRsnCd = this.vslDlayRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEvntTpCd = this.vpsEvntTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDlayRsnDesc = this.vslDlayRsnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediKeyCd = this.ediKeyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dupFlg = this.dupFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

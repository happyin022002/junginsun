/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BllSprtCmbnVO.java
*@FileTitle : BllSprtCmbnVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.16
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.16  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class BllSprtCmbnVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BllSprtCmbnVO> models = new ArrayList<BllSprtCmbnVO>();
	
	/* Column Info */
	private String corrRsnCd = null;
	/* Column Info */
	private String bllSndStsCd = null;
	/* Column Info */
	private String newBlNo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String sDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bllSndTpCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String corrRsn = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String fncTp = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String aSType = null;
	/* Column Info */
	private String bllSndDt = null;
	/* Column Info */
	private String delTrasmitFlag = null;
	/* Column Info */
	private String grsWgt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BllSprtCmbnVO() {}

	public BllSprtCmbnVO(String ibflag, String pagerows, String aSType, String bllSndDt, String bllSndStsCd, String bllSndTpCd, String blNo, String corrRsn, String corrRsnCd, String delTrasmitFlag, String fncTp, String grsWgt, String newBlNo, String pckQty, String podCd, String polCd, String sDt, String usrId, String vvd) {
		this.corrRsnCd = corrRsnCd;
		this.bllSndStsCd = bllSndStsCd;
		this.newBlNo = newBlNo;
		this.blNo = blNo;
		this.sDt = sDt;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.podCd = podCd;
		this.bllSndTpCd = bllSndTpCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.corrRsn = corrRsn;
		this.usrId = usrId;
		this.fncTp = fncTp;
		this.pckQty = pckQty;
		this.aSType = aSType;
		this.bllSndDt = bllSndDt;
		this.delTrasmitFlag = delTrasmitFlag;
		this.grsWgt = grsWgt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("corr_rsn_cd", getCorrRsnCd());
		this.hashColumns.put("bll_snd_sts_cd", getBllSndStsCd());
		this.hashColumns.put("new_bl_no", getNewBlNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("s_dt", getSDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bll_snd_tp_cd", getBllSndTpCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("corr_rsn", getCorrRsn());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("fnc_tp", getFncTp());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("a_s_type", getASType());
		this.hashColumns.put("bll_snd_dt", getBllSndDt());
		this.hashColumns.put("del_trasmit_flag", getDelTrasmitFlag());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("corr_rsn_cd", "corrRsnCd");
		this.hashFields.put("bll_snd_sts_cd", "bllSndStsCd");
		this.hashFields.put("new_bl_no", "newBlNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("s_dt", "sDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bll_snd_tp_cd", "bllSndTpCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("corr_rsn", "corrRsn");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("fnc_tp", "fncTp");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("a_s_type", "aSType");
		this.hashFields.put("bll_snd_dt", "bllSndDt");
		this.hashFields.put("del_trasmit_flag", "delTrasmitFlag");
		this.hashFields.put("grs_wgt", "grsWgt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return corrRsnCd
	 */
	public String getCorrRsnCd() {
		return this.corrRsnCd;
	}
	
	/**
	 * Column Info
	 * @return bllSndStsCd
	 */
	public String getBllSndStsCd() {
		return this.bllSndStsCd;
	}
	
	/**
	 * Column Info
	 * @return newBlNo
	 */
	public String getNewBlNo() {
		return this.newBlNo;
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
	 * @return sDt
	 */
	public String getSDt() {
		return this.sDt;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return bllSndTpCd
	 */
	public String getBllSndTpCd() {
		return this.bllSndTpCd;
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
	 * @return corrRsn
	 */
	public String getCorrRsn() {
		return this.corrRsn;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return fncTp
	 */
	public String getFncTp() {
		return this.fncTp;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return aSType
	 */
	public String getASType() {
		return this.aSType;
	}
	
	/**
	 * Column Info
	 * @return bllSndDt
	 */
	public String getBllSndDt() {
		return this.bllSndDt;
	}
	
	/**
	 * Column Info
	 * @return delTrasmitFlag
	 */
	public String getDelTrasmitFlag() {
		return this.delTrasmitFlag;
	}
	
	/**
	 * Column Info
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
	}
	

	/**
	 * Column Info
	 * @param corrRsnCd
	 */
	public void setCorrRsnCd(String corrRsnCd) {
		this.corrRsnCd = corrRsnCd;
	}
	
	/**
	 * Column Info
	 * @param bllSndStsCd
	 */
	public void setBllSndStsCd(String bllSndStsCd) {
		this.bllSndStsCd = bllSndStsCd;
	}
	
	/**
	 * Column Info
	 * @param newBlNo
	 */
	public void setNewBlNo(String newBlNo) {
		this.newBlNo = newBlNo;
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
	 * @param sDt
	 */
	public void setSDt(String sDt) {
		this.sDt = sDt;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param bllSndTpCd
	 */
	public void setBllSndTpCd(String bllSndTpCd) {
		this.bllSndTpCd = bllSndTpCd;
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
	 * @param corrRsn
	 */
	public void setCorrRsn(String corrRsn) {
		this.corrRsn = corrRsn;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param fncTp
	 */
	public void setFncTp(String fncTp) {
		this.fncTp = fncTp;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param aSType
	 */
	public void setASType(String aSType) {
		this.aSType = aSType;
	}
	
	/**
	 * Column Info
	 * @param bllSndDt
	 */
	public void setBllSndDt(String bllSndDt) {
		this.bllSndDt = bllSndDt;
	}
	
	/**
	 * Column Info
	 * @param delTrasmitFlag
	 */
	public void setDelTrasmitFlag(String delTrasmitFlag) {
		this.delTrasmitFlag = delTrasmitFlag;
	}
	
	/**
	 * Column Info
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
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
		setCorrRsnCd(JSPUtil.getParameter(request, prefix + "corr_rsn_cd", ""));
		setBllSndStsCd(JSPUtil.getParameter(request, prefix + "bll_snd_sts_cd", ""));
		setNewBlNo(JSPUtil.getParameter(request, prefix + "new_bl_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setSDt(JSPUtil.getParameter(request, prefix + "s_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBllSndTpCd(JSPUtil.getParameter(request, prefix + "bll_snd_tp_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCorrRsn(JSPUtil.getParameter(request, prefix + "corr_rsn", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setFncTp(JSPUtil.getParameter(request, prefix + "fnc_tp", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setASType(JSPUtil.getParameter(request, prefix + "a_s_type", ""));
		setBllSndDt(JSPUtil.getParameter(request, prefix + "bll_snd_dt", ""));
		setDelTrasmitFlag(JSPUtil.getParameter(request, prefix + "del_trasmit_flag", ""));
		setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BllSprtCmbnVO[]
	 */
	public BllSprtCmbnVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BllSprtCmbnVO[]
	 */
	public BllSprtCmbnVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BllSprtCmbnVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] corrRsnCd = (JSPUtil.getParameter(request, prefix	+ "corr_rsn_cd", length));
			String[] bllSndStsCd = (JSPUtil.getParameter(request, prefix	+ "bll_snd_sts_cd", length));
			String[] newBlNo = (JSPUtil.getParameter(request, prefix	+ "new_bl_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] sDt = (JSPUtil.getParameter(request, prefix	+ "s_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bllSndTpCd = (JSPUtil.getParameter(request, prefix	+ "bll_snd_tp_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] corrRsn = (JSPUtil.getParameter(request, prefix	+ "corr_rsn", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] fncTp = (JSPUtil.getParameter(request, prefix	+ "fnc_tp", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] aSType = (JSPUtil.getParameter(request, prefix	+ "a_s_type", length));
			String[] bllSndDt = (JSPUtil.getParameter(request, prefix	+ "bll_snd_dt", length));
			String[] delTrasmitFlag = (JSPUtil.getParameter(request, prefix	+ "del_trasmit_flag", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			
			for (int i = 0; i < length; i++) {
				model = new BllSprtCmbnVO();
				if (corrRsnCd[i] != null)
					model.setCorrRsnCd(corrRsnCd[i]);
				if (bllSndStsCd[i] != null)
					model.setBllSndStsCd(bllSndStsCd[i]);
				if (newBlNo[i] != null)
					model.setNewBlNo(newBlNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (sDt[i] != null)
					model.setSDt(sDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bllSndTpCd[i] != null)
					model.setBllSndTpCd(bllSndTpCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (corrRsn[i] != null)
					model.setCorrRsn(corrRsn[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (fncTp[i] != null)
					model.setFncTp(fncTp[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (aSType[i] != null)
					model.setASType(aSType[i]);
				if (bllSndDt[i] != null)
					model.setBllSndDt(bllSndDt[i]);
				if (delTrasmitFlag[i] != null)
					model.setDelTrasmitFlag(delTrasmitFlag[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBllSprtCmbnVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BllSprtCmbnVO[]
	 */
	public BllSprtCmbnVO[] getBllSprtCmbnVOs(){
		BllSprtCmbnVO[] vos = (BllSprtCmbnVO[])models.toArray(new BllSprtCmbnVO[models.size()]);
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
		this.corrRsnCd = this.corrRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bllSndStsCd = this.bllSndStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newBlNo = this.newBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDt = this.sDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bllSndTpCd = this.bllSndTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrRsn = this.corrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fncTp = this.fncTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aSType = this.aSType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bllSndDt = this.bllSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delTrasmitFlag = this.delTrasmitFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

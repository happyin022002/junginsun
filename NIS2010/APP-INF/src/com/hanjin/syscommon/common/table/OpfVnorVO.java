/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OpfVnorVO.java
*@FileTitle : OpfVnorVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.17  
* 1.0 Creation
* 
* History
* 2015.04.21 이병훈 [CHM-201535480] VNOR Report Creation 화면 기능 개선(Remark Submit)
=========================================================*/

package com.hanjin.syscommon.common.table;

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

public class OpfVnorVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OpfVnorVO> models = new ArrayList<OpfVnorVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String vnorOffhTpCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vnorOffhKndCd = null;
	/* Column Info */
	private String vnorFmPortCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vnorVslStsCd = null;
	/* Column Info */
	private String vnorStupStsCd = null;
	/* Column Info */
	private String crChkFlg = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vnorToPortCd = null;
	/* Column Info */
	private String vnorSeq = null;
	/* Column Info */
	private String vnorOffhFmDt = null;
	/* Column Info */
	private String vnorOffhToDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String vnorRmk = null;
	/* Column Info */
	private String emlSndNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OpfVnorVO() {}

	public OpfVnorVO(String ibflag, String pagerows, String vslCd, String vnorSeq, String vnorOffhFmDt, String vnorOffhToDt, String crChkFlg, String skdVoyNo, String skdDirCd, String vnorStupStsCd, String vnorOffhKndCd, String vnorOffhTpCd, String vnorVslStsCd, String vnorFmPortCd, String vnorToPortCd, String creUsrId, String creDt, String updUsrId, String updDt, String vnorRmk, String emlSndNo) {
		this.updDt = updDt;
		this.vnorOffhTpCd = vnorOffhTpCd;
		this.vslCd = vslCd;
		this.vnorOffhKndCd = vnorOffhKndCd;
		this.vnorFmPortCd = vnorFmPortCd;
		this.creDt = creDt;
		this.skdVoyNo = skdVoyNo;
		this.vnorVslStsCd = vnorVslStsCd;
		this.vnorStupStsCd = vnorStupStsCd;
		this.crChkFlg = crChkFlg;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.vnorToPortCd = vnorToPortCd;
		this.vnorSeq = vnorSeq;
		this.vnorOffhFmDt = vnorOffhFmDt;
		this.vnorOffhToDt = vnorOffhToDt;
		this.updUsrId = updUsrId;
		this.vnorRmk = vnorRmk;
		this.emlSndNo = emlSndNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vnor_offh_tp_cd", getVnorOffhTpCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vnor_offh_knd_cd", getVnorOffhKndCd());
		this.hashColumns.put("vnor_fm_port_cd", getVnorFmPortCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vnor_vsl_sts_cd", getVnorVslStsCd());
		this.hashColumns.put("vnor_stup_sts_cd", getVnorStupStsCd());
		this.hashColumns.put("cr_chk_flg", getCrChkFlg());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vnor_to_port_cd", getVnorToPortCd());
		this.hashColumns.put("vnor_seq", getVnorSeq());
		this.hashColumns.put("vnor_offh_fm_dt", getVnorOffhFmDt());
		this.hashColumns.put("vnor_offh_to_dt", getVnorOffhToDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("vnor_rmk", getVnorRmk());
		this.hashColumns.put("eml_snd_no", getEmlSndNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vnor_offh_tp_cd", "vnorOffhTpCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vnor_offh_knd_cd", "vnorOffhKndCd");
		this.hashFields.put("vnor_fm_port_cd", "vnorFmPortCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vnor_vsl_sts_cd", "vnorVslStsCd");
		this.hashFields.put("vnor_stup_sts_cd", "vnorStupStsCd");
		this.hashFields.put("cr_chk_flg", "crChkFlg");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vnor_to_port_cd", "vnorToPortCd");
		this.hashFields.put("vnor_seq", "vnorSeq");
		this.hashFields.put("vnor_offh_fm_dt", "vnorOffhFmDt");
		this.hashFields.put("vnor_offh_to_dt", "vnorOffhToDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("vnor_rmk", "vnorRmk");
		this.hashFields.put("eml_snd_no", "emlSndNo");
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
	 * @return vnorOffhTpCd
	 */
	public String getVnorOffhTpCd() {
		return this.vnorOffhTpCd;
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
	 * @return vnorOffhKndCd
	 */
	public String getVnorOffhKndCd() {
		return this.vnorOffhKndCd;
	}
	
	/**
	 * Column Info
	 * @return vnorFmPortCd
	 */
	public String getVnorFmPortCd() {
		return this.vnorFmPortCd;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return vnorVslStsCd
	 */
	public String getVnorVslStsCd() {
		return this.vnorVslStsCd;
	}
	
	/**
	 * Column Info
	 * @return vnorStupStsCd
	 */
	public String getVnorStupStsCd() {
		return this.vnorStupStsCd;
	}
	
	/**
	 * Column Info
	 * @return crChkFlg
	 */
	public String getCrChkFlg() {
		return this.crChkFlg;
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
	 * @return vnorToPortCd
	 */
	public String getVnorToPortCd() {
		return this.vnorToPortCd;
	}
	
	/**
	 * Column Info
	 * @return vnorSeq
	 */
	public String getVnorSeq() {
		return this.vnorSeq;
	}
	
	/**
	 * Column Info
	 * @return vnorOffhFmDt
	 */
	public String getVnorOffhFmDt() {
		return this.vnorOffhFmDt;
	}
	
	/**
	 * Column Info
	 * @return vnorOffhToDt
	 */
	public String getVnorOffhToDt() {
		return this.vnorOffhToDt;
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
	 * @return vnorRmk
	 */
	public String getVnorRmk() {
		return this.vnorRmk;
	}
	
	/**
	 * Column Info
	 * @return emlSndNo
	 */
	public String getEmlSndNo() {
		return this.emlSndNo;
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
	 * @param vnorOffhTpCd
	 */
	public void setVnorOffhTpCd(String vnorOffhTpCd) {
		this.vnorOffhTpCd = vnorOffhTpCd;
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
	 * @param vnorOffhKndCd
	 */
	public void setVnorOffhKndCd(String vnorOffhKndCd) {
		this.vnorOffhKndCd = vnorOffhKndCd;
	}
	
	/**
	 * Column Info
	 * @param vnorFmPortCd
	 */
	public void setVnorFmPortCd(String vnorFmPortCd) {
		this.vnorFmPortCd = vnorFmPortCd;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param vnorVslStsCd
	 */
	public void setVnorVslStsCd(String vnorVslStsCd) {
		this.vnorVslStsCd = vnorVslStsCd;
	}
	
	/**
	 * Column Info
	 * @param vnorStupStsCd
	 */
	public void setVnorStupStsCd(String vnorStupStsCd) {
		this.vnorStupStsCd = vnorStupStsCd;
	}
	
	/**
	 * Column Info
	 * @param crChkFlg
	 */
	public void setCrChkFlg(String crChkFlg) {
		this.crChkFlg = crChkFlg;
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
	 * @param vnorToPortCd
	 */
	public void setVnorToPortCd(String vnorToPortCd) {
		this.vnorToPortCd = vnorToPortCd;
	}
	
	/**
	 * Column Info
	 * @param vnorSeq
	 */
	public void setVnorSeq(String vnorSeq) {
		this.vnorSeq = vnorSeq;
	}
	
	/**
	 * Column Info
	 * @param vnorOffhFmDt
	 */
	public void setVnorOffhFmDt(String vnorOffhFmDt) {
		this.vnorOffhFmDt = vnorOffhFmDt;
	}
	
	/**
	 * Column Info
	 * @param vnorOffhToDt
	 */
	public void setVnorOffhToDt(String vnorOffhToDt) {
		this.vnorOffhToDt = vnorOffhToDt;
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
	 * @param vnorRmk
	 */
	public void setVnorRmk(String vnorRmk) {
		this.vnorRmk = vnorRmk;
	}
	
	/**
	 * Column Info
	 * @param emlSndNo
	 */
	public void setEmlSndNo(String emlSndNo) {
		this.emlSndNo = emlSndNo;
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
		setVnorOffhTpCd(JSPUtil.getParameter(request, prefix + "vnor_offh_tp_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setVnorOffhKndCd(JSPUtil.getParameter(request, prefix + "vnor_offh_knd_cd", ""));
		setVnorFmPortCd(JSPUtil.getParameter(request, prefix + "vnor_fm_port_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setVnorVslStsCd(JSPUtil.getParameter(request, prefix + "vnor_vsl_sts_cd", ""));
		setVnorStupStsCd(JSPUtil.getParameter(request, prefix + "vnor_stup_sts_cd", ""));
		setCrChkFlg(JSPUtil.getParameter(request, prefix + "cr_chk_flg", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVnorToPortCd(JSPUtil.getParameter(request, prefix + "vnor_to_port_cd", ""));
		setVnorSeq(JSPUtil.getParameter(request, prefix + "vnor_seq", ""));
		setVnorOffhFmDt(JSPUtil.getParameter(request, prefix + "vnor_offh_fm_dt", ""));
		setVnorOffhToDt(JSPUtil.getParameter(request, prefix + "vnor_offh_to_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setVnorRmk(JSPUtil.getParameter(request, prefix + "vnor_rmk", ""));
		setEmlSndNo(JSPUtil.getParameter(request, prefix + "eml_snd_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OpfVnorVO[]
	 */
	public OpfVnorVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OpfVnorVO[]
	 */
	public OpfVnorVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OpfVnorVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] vnorOffhTpCd = (JSPUtil.getParameter(request, prefix	+ "vnor_offh_tp_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vnorOffhKndCd = (JSPUtil.getParameter(request, prefix	+ "vnor_offh_knd_cd", length));
			String[] vnorFmPortCd = (JSPUtil.getParameter(request, prefix	+ "vnor_fm_port_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vnorVslStsCd = (JSPUtil.getParameter(request, prefix	+ "vnor_vsl_sts_cd", length));
			String[] vnorStupStsCd = (JSPUtil.getParameter(request, prefix	+ "vnor_stup_sts_cd", length));
			String[] crChkFlg = (JSPUtil.getParameter(request, prefix	+ "cr_chk_flg", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vnorToPortCd = (JSPUtil.getParameter(request, prefix	+ "vnor_to_port_cd", length));
			String[] vnorSeq = (JSPUtil.getParameter(request, prefix	+ "vnor_seq", length));
			String[] vnorOffhFmDt = (JSPUtil.getParameter(request, prefix	+ "vnor_offh_fm_dt", length));
			String[] vnorOffhToDt = (JSPUtil.getParameter(request, prefix	+ "vnor_offh_to_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] vnorRmk = (JSPUtil.getParameter(request, prefix	+ "vnor_rmk", length));
			String[] emlSndNo = (JSPUtil.getParameter(request, prefix	+ "eml_snd_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new OpfVnorVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (vnorOffhTpCd[i] != null)
					model.setVnorOffhTpCd(vnorOffhTpCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vnorOffhKndCd[i] != null)
					model.setVnorOffhKndCd(vnorOffhKndCd[i]);
				if (vnorFmPortCd[i] != null)
					model.setVnorFmPortCd(vnorFmPortCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vnorVslStsCd[i] != null)
					model.setVnorVslStsCd(vnorVslStsCd[i]);
				if (vnorStupStsCd[i] != null)
					model.setVnorStupStsCd(vnorStupStsCd[i]);
				if (crChkFlg[i] != null)
					model.setCrChkFlg(crChkFlg[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vnorToPortCd[i] != null)
					model.setVnorToPortCd(vnorToPortCd[i]);
				if (vnorSeq[i] != null)
					model.setVnorSeq(vnorSeq[i]);
				if (vnorOffhFmDt[i] != null)
					model.setVnorOffhFmDt(vnorOffhFmDt[i]);
				if (vnorOffhToDt[i] != null)
					model.setVnorOffhToDt(vnorOffhToDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (vnorRmk[i] != null)
					model.setVnorRmk(vnorRmk[i]);
				if (emlSndNo[i] != null)
					model.setEmlSndNo(emlSndNo[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOpfVnorVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OpfVnorVO[]
	 */
	public OpfVnorVO[] getOpfVnorVOs(){
		OpfVnorVO[] vos = (OpfVnorVO[])models.toArray(new OpfVnorVO[models.size()]);
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
		this.vnorOffhTpCd = this.vnorOffhTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorOffhKndCd = this.vnorOffhKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorFmPortCd = this.vnorFmPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorVslStsCd = this.vnorVslStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorStupStsCd = this.vnorStupStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crChkFlg = this.crChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorToPortCd = this.vnorToPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorSeq = this.vnorSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorOffhFmDt = this.vnorOffhFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorOffhToDt = this.vnorOffhToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorRmk = this.vnorRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndNo = this.emlSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

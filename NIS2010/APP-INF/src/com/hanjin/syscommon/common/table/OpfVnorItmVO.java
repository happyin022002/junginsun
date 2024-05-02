/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OpfVnorItmVO.java
*@FileTitle : OpfVnorItmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.18  
* 1.0 Creation
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

public class OpfVnorItmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OpfVnorItmVO> models = new ArrayList<OpfVnorItmVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vnorItmSeq = null;
	/* Column Info */
	private String vnorItmUtCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vnorMnItmFlg = null;
	/* Column Info */
	private String vnorItmOfcCd = null;
	/* Column Info */
	private String vnorItmVal = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String atchFileLnkId = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vnorSeq = null;
	/* Column Info */
	private String atchFileKnt = null;
	/* Column Info */
	private String vnorItmStsCd = null;
	/* Column Info */
	private String vnorItmRmk = null;
	/* Column Info */
	private String vnorItmCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OpfVnorItmVO() {}

	public OpfVnorItmVO(String ibflag, String pagerows, String vslCd, String vnorSeq, String vnorItmSeq, String vnorMnItmFlg, String vnorItmCd, String vnorItmOfcCd, String vnorItmUtCd, String vnorItmVal, String vnorItmStsCd, String vnorItmRmk, String atchFileLnkId, String atchFileKnt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.vslCd = vslCd;
		this.vnorItmSeq = vnorItmSeq;
		this.vnorItmUtCd = vnorItmUtCd;
		this.creDt = creDt;
		this.vnorMnItmFlg = vnorMnItmFlg;
		this.vnorItmOfcCd = vnorItmOfcCd;
		this.vnorItmVal = vnorItmVal;
		this.pagerows = pagerows;
		this.atchFileLnkId = atchFileLnkId;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.vnorSeq = vnorSeq;
		this.atchFileKnt = atchFileKnt;
		this.vnorItmStsCd = vnorItmStsCd;
		this.vnorItmRmk = vnorItmRmk;
		this.vnorItmCd = vnorItmCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vnor_itm_seq", getVnorItmSeq());
		this.hashColumns.put("vnor_itm_ut_cd", getVnorItmUtCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vnor_mn_itm_flg", getVnorMnItmFlg());
		this.hashColumns.put("vnor_itm_ofc_cd", getVnorItmOfcCd());
		this.hashColumns.put("vnor_itm_val", getVnorItmVal());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("atch_file_lnk_id", getAtchFileLnkId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vnor_seq", getVnorSeq());
		this.hashColumns.put("atch_file_knt", getAtchFileKnt());
		this.hashColumns.put("vnor_itm_sts_cd", getVnorItmStsCd());
		this.hashColumns.put("vnor_itm_rmk", getVnorItmRmk());
		this.hashColumns.put("vnor_itm_cd", getVnorItmCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vnor_itm_seq", "vnorItmSeq");
		this.hashFields.put("vnor_itm_ut_cd", "vnorItmUtCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vnor_mn_itm_flg", "vnorMnItmFlg");
		this.hashFields.put("vnor_itm_ofc_cd", "vnorItmOfcCd");
		this.hashFields.put("vnor_itm_val", "vnorItmVal");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("atch_file_lnk_id", "atchFileLnkId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vnor_seq", "vnorSeq");
		this.hashFields.put("atch_file_knt", "atchFileKnt");
		this.hashFields.put("vnor_itm_sts_cd", "vnorItmStsCd");
		this.hashFields.put("vnor_itm_rmk", "vnorItmRmk");
		this.hashFields.put("vnor_itm_cd", "vnorItmCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return vnorItmSeq
	 */
	public String getVnorItmSeq() {
		return this.vnorItmSeq;
	}
	
	/**
	 * Column Info
	 * @return vnorItmUtCd
	 */
	public String getVnorItmUtCd() {
		return this.vnorItmUtCd;
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
	 * @return vnorMnItmFlg
	 */
	public String getVnorMnItmFlg() {
		return this.vnorMnItmFlg;
	}
	
	/**
	 * Column Info
	 * @return vnorItmOfcCd
	 */
	public String getVnorItmOfcCd() {
		return this.vnorItmOfcCd;
	}
	
	/**
	 * Column Info
	 * @return vnorItmVal
	 */
	public String getVnorItmVal() {
		return this.vnorItmVal;
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
	 * @return atchFileLnkId
	 */
	public String getAtchFileLnkId() {
		return this.atchFileLnkId;
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
	 * @return vnorSeq
	 */
	public String getVnorSeq() {
		return this.vnorSeq;
	}
	
	/**
	 * Column Info
	 * @return atchFileKnt
	 */
	public String getAtchFileKnt() {
		return this.atchFileKnt;
	}
	
	/**
	 * Column Info
	 * @return vnorItmStsCd
	 */
	public String getVnorItmStsCd() {
		return this.vnorItmStsCd;
	}
	
	/**
	 * Column Info
	 * @return vnorItmRmk
	 */
	public String getVnorItmRmk() {
		return this.vnorItmRmk;
	}
	
	/**
	 * Column Info
	 * @return vnorItmCd
	 */
	public String getVnorItmCd() {
		return this.vnorItmCd;
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
	 * @param vnorItmSeq
	 */
	public void setVnorItmSeq(String vnorItmSeq) {
		this.vnorItmSeq = vnorItmSeq;
	}
	
	/**
	 * Column Info
	 * @param vnorItmUtCd
	 */
	public void setVnorItmUtCd(String vnorItmUtCd) {
		this.vnorItmUtCd = vnorItmUtCd;
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
	 * @param vnorMnItmFlg
	 */
	public void setVnorMnItmFlg(String vnorMnItmFlg) {
		this.vnorMnItmFlg = vnorMnItmFlg;
	}
	
	/**
	 * Column Info
	 * @param vnorItmOfcCd
	 */
	public void setVnorItmOfcCd(String vnorItmOfcCd) {
		this.vnorItmOfcCd = vnorItmOfcCd;
	}
	
	/**
	 * Column Info
	 * @param vnorItmVal
	 */
	public void setVnorItmVal(String vnorItmVal) {
		this.vnorItmVal = vnorItmVal;
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
	 * @param atchFileLnkId
	 */
	public void setAtchFileLnkId(String atchFileLnkId) {
		this.atchFileLnkId = atchFileLnkId;
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
	 * @param vnorSeq
	 */
	public void setVnorSeq(String vnorSeq) {
		this.vnorSeq = vnorSeq;
	}
	
	/**
	 * Column Info
	 * @param atchFileKnt
	 */
	public void setAtchFileKnt(String atchFileKnt) {
		this.atchFileKnt = atchFileKnt;
	}
	
	/**
	 * Column Info
	 * @param vnorItmStsCd
	 */
	public void setVnorItmStsCd(String vnorItmStsCd) {
		this.vnorItmStsCd = vnorItmStsCd;
	}
	
	/**
	 * Column Info
	 * @param vnorItmRmk
	 */
	public void setVnorItmRmk(String vnorItmRmk) {
		this.vnorItmRmk = vnorItmRmk;
	}
	
	/**
	 * Column Info
	 * @param vnorItmCd
	 */
	public void setVnorItmCd(String vnorItmCd) {
		this.vnorItmCd = vnorItmCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setVnorItmSeq(JSPUtil.getParameter(request, prefix + "vnor_itm_seq", ""));
		setVnorItmUtCd(JSPUtil.getParameter(request, prefix + "vnor_itm_ut_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setVnorMnItmFlg(JSPUtil.getParameter(request, prefix + "vnor_mn_itm_flg", ""));
		setVnorItmOfcCd(JSPUtil.getParameter(request, prefix + "vnor_itm_ofc_cd", ""));
		setVnorItmVal(JSPUtil.getParameter(request, prefix + "vnor_itm_val", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAtchFileLnkId(JSPUtil.getParameter(request, prefix + "atch_file_lnk_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVnorSeq(JSPUtil.getParameter(request, prefix + "vnor_seq", ""));
		setAtchFileKnt(JSPUtil.getParameter(request, prefix + "atch_file_knt", ""));
		setVnorItmStsCd(JSPUtil.getParameter(request, prefix + "vnor_itm_sts_cd", ""));
		setVnorItmRmk(JSPUtil.getParameter(request, prefix + "vnor_itm_rmk", ""));
		setVnorItmCd(JSPUtil.getParameter(request, prefix + "vnor_itm_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OpfVnorItmVO[]
	 */
	public OpfVnorItmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OpfVnorItmVO[]
	 */
	public OpfVnorItmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OpfVnorItmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vnorItmSeq = (JSPUtil.getParameter(request, prefix	+ "vnor_itm_seq", length));
			String[] vnorItmUtCd = (JSPUtil.getParameter(request, prefix	+ "vnor_itm_ut_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vnorMnItmFlg = (JSPUtil.getParameter(request, prefix	+ "vnor_mn_itm_flg", length));
			String[] vnorItmOfcCd = (JSPUtil.getParameter(request, prefix	+ "vnor_itm_ofc_cd", length));
			String[] vnorItmVal = (JSPUtil.getParameter(request, prefix	+ "vnor_itm_val", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] atchFileLnkId = (JSPUtil.getParameter(request, prefix	+ "atch_file_lnk_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vnorSeq = (JSPUtil.getParameter(request, prefix	+ "vnor_seq", length));
			String[] atchFileKnt = (JSPUtil.getParameter(request, prefix	+ "atch_file_knt", length));
			String[] vnorItmStsCd = (JSPUtil.getParameter(request, prefix	+ "vnor_itm_sts_cd", length));
			String[] vnorItmRmk = (JSPUtil.getParameter(request, prefix	+ "vnor_itm_rmk", length));
			String[] vnorItmCd = (JSPUtil.getParameter(request, prefix	+ "vnor_itm_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new OpfVnorItmVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vnorItmSeq[i] != null)
					model.setVnorItmSeq(vnorItmSeq[i]);
				if (vnorItmUtCd[i] != null)
					model.setVnorItmUtCd(vnorItmUtCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vnorMnItmFlg[i] != null)
					model.setVnorMnItmFlg(vnorMnItmFlg[i]);
				if (vnorItmOfcCd[i] != null)
					model.setVnorItmOfcCd(vnorItmOfcCd[i]);
				if (vnorItmVal[i] != null)
					model.setVnorItmVal(vnorItmVal[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (atchFileLnkId[i] != null)
					model.setAtchFileLnkId(atchFileLnkId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vnorSeq[i] != null)
					model.setVnorSeq(vnorSeq[i]);
				if (atchFileKnt[i] != null)
					model.setAtchFileKnt(atchFileKnt[i]);
				if (vnorItmStsCd[i] != null)
					model.setVnorItmStsCd(vnorItmStsCd[i]);
				if (vnorItmRmk[i] != null)
					model.setVnorItmRmk(vnorItmRmk[i]);
				if (vnorItmCd[i] != null)
					model.setVnorItmCd(vnorItmCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOpfVnorItmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OpfVnorItmVO[]
	 */
	public OpfVnorItmVO[] getOpfVnorItmVOs(){
		OpfVnorItmVO[] vos = (OpfVnorItmVO[])models.toArray(new OpfVnorItmVO[models.size()]);
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
		this.vnorItmSeq = this.vnorItmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorItmUtCd = this.vnorItmUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorMnItmFlg = this.vnorMnItmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorItmOfcCd = this.vnorItmOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorItmVal = this.vnorItmVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileLnkId = this.atchFileLnkId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorSeq = this.vnorSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileKnt = this.atchFileKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorItmStsCd = this.vnorItmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorItmRmk = this.vnorItmRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorItmCd = this.vnorItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

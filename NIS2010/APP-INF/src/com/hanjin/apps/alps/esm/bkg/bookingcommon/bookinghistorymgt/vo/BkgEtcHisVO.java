/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BkgEtcHisVO.java
*@FileTitle : BkgEtcHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.24
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.04.24 김보배 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김보배
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgEtcHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgEtcHisVO> models = new ArrayList<BkgEtcHisVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String corrNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String crntCtnt = null;
	/* Column Info */
	private String bkgHisIssUiId = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String hisCateNm = null;
	/* Column Info */
	private String hisSeq = null;
	/* Column Info */
	private String caFlg = null;
	/* Column Info */
	private String hisDtlSeq = null;
	/* Column Info */
	private String preCtnt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String evntDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgEtcHisVO() {}

	public BkgEtcHisVO(String ibflag, String pagerows, String bkgNo, String hisSeq, String hisDtlSeq, String preCtnt, String crntCtnt, String hisCateNm, String caFlg, String creUsrId, String creDt, String updUsrId, String updDt, String bkgHisIssUiId, String corrNo, String evntDt) {
		this.updDt = updDt;
		this.corrNo = corrNo;
		this.creDt = creDt;
		this.crntCtnt = crntCtnt;
		this.bkgHisIssUiId = bkgHisIssUiId;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.hisCateNm = hisCateNm;
		this.hisSeq = hisSeq;
		this.caFlg = caFlg;
		this.hisDtlSeq = hisDtlSeq;
		this.preCtnt = preCtnt;
		this.updUsrId = updUsrId;
		this.evntDt = evntDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("corr_no", getCorrNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("crnt_ctnt", getCrntCtnt());
		this.hashColumns.put("bkg_his_iss_ui_id", getBkgHisIssUiId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("his_cate_nm", getHisCateNm());
		this.hashColumns.put("his_seq", getHisSeq());
		this.hashColumns.put("ca_flg", getCaFlg());
		this.hashColumns.put("his_dtl_seq", getHisDtlSeq());
		this.hashColumns.put("pre_ctnt", getPreCtnt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("evnt_dt", getEvntDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("corr_no", "corrNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("crnt_ctnt", "crntCtnt");
		this.hashFields.put("bkg_his_iss_ui_id", "bkgHisIssUiId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("his_cate_nm", "hisCateNm");
		this.hashFields.put("his_seq", "hisSeq");
		this.hashFields.put("ca_flg", "caFlg");
		this.hashFields.put("his_dtl_seq", "hisDtlSeq");
		this.hashFields.put("pre_ctnt", "preCtnt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("evnt_dt", "evntDt");
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
	 * @return corrNo
	 */
	public String getCorrNo() {
		return this.corrNo;
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
	 * @return crntCtnt
	 */
	public String getCrntCtnt() {
		return this.crntCtnt;
	}
	
	/**
	 * Column Info
	 * @return bkgHisIssUiId
	 */
	public String getBkgHisIssUiId() {
		return this.bkgHisIssUiId;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return hisCateNm
	 */
	public String getHisCateNm() {
		return this.hisCateNm;
	}
	
	/**
	 * Column Info
	 * @return hisSeq
	 */
	public String getHisSeq() {
		return this.hisSeq;
	}
	
	/**
	 * Column Info
	 * @return caFlg
	 */
	public String getCaFlg() {
		return this.caFlg;
	}
	
	/**
	 * Column Info
	 * @return hisDtlSeq
	 */
	public String getHisDtlSeq() {
		return this.hisDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return preCtnt
	 */
	public String getPreCtnt() {
		return this.preCtnt;
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
	 * @return evntDt
	 */
	public String getEvntDt() {
		return this.evntDt;
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
	 * @param corrNo
	 */
	public void setCorrNo(String corrNo) {
		this.corrNo = corrNo;
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
	 * @param crntCtnt
	 */
	public void setCrntCtnt(String crntCtnt) {
		this.crntCtnt = crntCtnt;
	}
	
	/**
	 * Column Info
	 * @param bkgHisIssUiId
	 */
	public void setBkgHisIssUiId(String bkgHisIssUiId) {
		this.bkgHisIssUiId = bkgHisIssUiId;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param hisCateNm
	 */
	public void setHisCateNm(String hisCateNm) {
		this.hisCateNm = hisCateNm;
	}
	
	/**
	 * Column Info
	 * @param hisSeq
	 */
	public void setHisSeq(String hisSeq) {
		this.hisSeq = hisSeq;
	}
	
	/**
	 * Column Info
	 * @param caFlg
	 */
	public void setCaFlg(String caFlg) {
		this.caFlg = caFlg;
	}
	
	/**
	 * Column Info
	 * @param hisDtlSeq
	 */
	public void setHisDtlSeq(String hisDtlSeq) {
		this.hisDtlSeq = hisDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param preCtnt
	 */
	public void setPreCtnt(String preCtnt) {
		this.preCtnt = preCtnt;
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
	 * @param evntDt
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
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
		setCorrNo(JSPUtil.getParameter(request, prefix + "corr_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCrntCtnt(JSPUtil.getParameter(request, prefix + "crnt_ctnt", ""));
		setBkgHisIssUiId(JSPUtil.getParameter(request, prefix + "bkg_his_iss_ui_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setHisCateNm(JSPUtil.getParameter(request, prefix + "his_cate_nm", ""));
		setHisSeq(JSPUtil.getParameter(request, prefix + "his_seq", ""));
		setCaFlg(JSPUtil.getParameter(request, prefix + "ca_flg", ""));
		setHisDtlSeq(JSPUtil.getParameter(request, prefix + "his_dtl_seq", ""));
		setPreCtnt(JSPUtil.getParameter(request, prefix + "pre_ctnt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setEvntDt(JSPUtil.getParameter(request, prefix + "evnt_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgEtcHisVO[]
	 */
	public BkgEtcHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgEtcHisVO[]
	 */
	public BkgEtcHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgEtcHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] corrNo = (JSPUtil.getParameter(request, prefix	+ "corr_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] crntCtnt = (JSPUtil.getParameter(request, prefix	+ "crnt_ctnt", length));
			String[] bkgHisIssUiId = (JSPUtil.getParameter(request, prefix	+ "bkg_his_iss_ui_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] hisCateNm = (JSPUtil.getParameter(request, prefix	+ "his_cate_nm", length));
			String[] hisSeq = (JSPUtil.getParameter(request, prefix	+ "his_seq", length));
			String[] caFlg = (JSPUtil.getParameter(request, prefix	+ "ca_flg", length));
			String[] hisDtlSeq = (JSPUtil.getParameter(request, prefix	+ "his_dtl_seq", length));
			String[] preCtnt = (JSPUtil.getParameter(request, prefix	+ "pre_ctnt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgEtcHisVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (corrNo[i] != null)
					model.setCorrNo(corrNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (crntCtnt[i] != null)
					model.setCrntCtnt(crntCtnt[i]);
				if (bkgHisIssUiId[i] != null)
					model.setBkgHisIssUiId(bkgHisIssUiId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (hisCateNm[i] != null)
					model.setHisCateNm(hisCateNm[i]);
				if (hisSeq[i] != null)
					model.setHisSeq(hisSeq[i]);
				if (caFlg[i] != null)
					model.setCaFlg(caFlg[i]);
				if (hisDtlSeq[i] != null)
					model.setHisDtlSeq(hisDtlSeq[i]);
				if (preCtnt[i] != null)
					model.setPreCtnt(preCtnt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgEtcHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgEtcHisVO[]
	 */
	public BkgEtcHisVO[] getBkgEtcHisVOs(){
		BkgEtcHisVO[] vos = (BkgEtcHisVO[])models.toArray(new BkgEtcHisVO[models.size()]);
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
		this.corrNo = this.corrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntCtnt = this.crntCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgHisIssUiId = this.bkgHisIssUiId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisCateNm = this.hisCateNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisSeq = this.hisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caFlg = this.caFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisDtlSeq = this.hisDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCtnt = this.preCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

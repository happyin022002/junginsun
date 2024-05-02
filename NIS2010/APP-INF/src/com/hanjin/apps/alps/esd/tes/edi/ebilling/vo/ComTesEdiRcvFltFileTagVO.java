/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TesEdiRcvFltFileTagMgmtVO.java
*@FileTitle : TesEdiRcvFltFileTagMgmtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tes.edi.ebilling.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

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

public class ComTesEdiRcvFltFileTagVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ComTesEdiRcvFltFileTagVO> models = new ArrayList<ComTesEdiRcvFltFileTagVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String hdrTagFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String tagVldKnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ediVndrSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fltFileTagNm = null;
	/* Column Info */
	private String tblVoNm = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String savSeq = null;
	/* Column Info */
	private String ediRcvRuleMnSeq = null;
	/* Column Info */
	private String tblNm = null;
	/* Column Info */
	private String prntTagNm = null;
	/* Column Info */
	private String mnlCntrRcvTagFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* EDI VNDR TAG EXCLUDE info - TABLE로 VO만들고 반드시 추가해야 한다. */
	private List<ComTesEdiRcvFltFileXcldVO> tesEdiFltFileXcldVOlist = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ComTesEdiRcvFltFileTagVO() {}

	public ComTesEdiRcvFltFileTagVO(String ibflag, String pagerows, String ediRcvRuleMnSeq, String ediVndrSeq, String fltFileTagNm, String tblNm, String tblVoNm, String hdrTagFlg, String savSeq, String prntTagNm, String tagVldKnt, String creUsrId, String creDt, String updUsrId, String updDt, String mnlCntrRcvTagFlg) {
		this.updDt = updDt;
		this.hdrTagFlg = hdrTagFlg;
		this.creDt = creDt;
		this.tagVldKnt = tagVldKnt;
		this.pagerows = pagerows;
		this.ediVndrSeq = ediVndrSeq;
		this.ibflag = ibflag;
		this.fltFileTagNm = fltFileTagNm;
		this.tblVoNm = tblVoNm;
		this.creUsrId = creUsrId;
		this.savSeq = savSeq;
		this.ediRcvRuleMnSeq = ediRcvRuleMnSeq;
		this.tblNm = tblNm;
		this.prntTagNm = prntTagNm;
		this.mnlCntrRcvTagFlg = mnlCntrRcvTagFlg;
		this.updUsrId = updUsrId;
	}

	/**
	 * EDI VNDR TAG EXCLUDE RULE SETTER
	 * @param tesEdiFltFileTagMgmtVOlist
	 */
	public void setComTesEdiRcvFltFileXcldVOlist(List<ComTesEdiRcvFltFileXcldVO> tesEdiFltFileXcldVOlist){
		this.tesEdiFltFileXcldVOlist = tesEdiFltFileXcldVOlist;
	}

	/**
	 * EDI VNDR TAG EXCLUDE RULE GETTER
	 * @return
	 */
	public List<ComTesEdiRcvFltFileXcldVO> getComTesEdiRcvFltFileXcldVOlist(){
		return this.tesEdiFltFileXcldVOlist;
	}

	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("hdr_tag_flg", getHdrTagFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("tag_vld_knt", getTagVldKnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("edi_vndr_seq", getEdiVndrSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("flt_file_tag_nm", getFltFileTagNm());
		this.hashColumns.put("tbl_vo_nm", getTblVoNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("sav_seq", getSavSeq());
		this.hashColumns.put("edi_rcv_rule_mn_seq", getEdiRcvRuleMnSeq());
		this.hashColumns.put("tbl_nm", getTblNm());
		this.hashColumns.put("prnt_tag_nm", getPrntTagNm());
		this.hashColumns.put("mnl_cntr_rcv_tag_flg", getMnlCntrRcvTagFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("hdr_tag_flg", "hdrTagFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("tag_vld_knt", "tagVldKnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("edi_vndr_seq", "ediVndrSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("flt_file_tag_nm", "fltFileTagNm");
		this.hashFields.put("tbl_vo_nm", "tblVoNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("sav_seq", "savSeq");
		this.hashFields.put("edi_rcv_rule_mn_seq", "ediRcvRuleMnSeq");
		this.hashFields.put("tbl_nm", "tblNm");
		this.hashFields.put("prnt_tag_nm", "prntTagNm");
		this.hashFields.put("mnl_cntr_rcv_tag_flg", "mnlCntrRcvTagFlg");
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
	 * @return hdrTagFlg
	 */
	public String getHdrTagFlg() {
		return this.hdrTagFlg;
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
	 * @return tagVldKnt
	 */
	public String getTagVldKnt() {
		return this.tagVldKnt;
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
	 * @return ediVndrSeq
	 */
	public String getEdiVndrSeq() {
		return this.ediVndrSeq;
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
	 * @return fltFileTagNm
	 */
	public String getFltFileTagNm() {
		return this.fltFileTagNm;
	}
	
	/**
	 * Column Info
	 * @return tblVoNm
	 */
	public String getTblVoNm() {
		return this.tblVoNm;
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
	 * @return savSeq
	 */
	public String getSavSeq() {
		return this.savSeq;
	}
	
	/**
	 * Column Info
	 * @return ediRcvRuleMnSeq
	 */
	public String getEdiRcvRuleMnSeq() {
		return this.ediRcvRuleMnSeq;
	}
	
	/**
	 * Column Info
	 * @return tblNm
	 */
	public String getTblNm() {
		return this.tblNm;
	}
	
	/**
	 * Column Info
	 * @return prntTagNm
	 */
	public String getPrntTagNm() {
		return this.prntTagNm;
	}
	
	/**
	 * Column Info
	 * @return mnlCntrRcvTagFlg
	 */
	public String getMnlCntrRcvTagFlg() {
		return this.mnlCntrRcvTagFlg;
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
	 * @param hdrTagFlg
	 */
	public void setHdrTagFlg(String hdrTagFlg) {
		this.hdrTagFlg = hdrTagFlg;
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
	 * @param tagVldKnt
	 */
	public void setTagVldKnt(String tagVldKnt) {
		this.tagVldKnt = tagVldKnt;
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
	 * @param ediVndrSeq
	 */
	public void setEdiVndrSeq(String ediVndrSeq) {
		this.ediVndrSeq = ediVndrSeq;
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
	 * @param fltFileTagNm
	 */
	public void setFltFileTagNm(String fltFileTagNm) {
		this.fltFileTagNm = fltFileTagNm;
	}
	
	/**
	 * Column Info
	 * @param tblVoNm
	 */
	public void setTblVoNm(String tblVoNm) {
		this.tblVoNm = tblVoNm;
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
	 * @param savSeq
	 */
	public void setSavSeq(String savSeq) {
		this.savSeq = savSeq;
	}
	
	/**
	 * Column Info
	 * @param ediRcvRuleMnSeq
	 */
	public void setEdiRcvRuleMnSeq(String ediRcvRuleMnSeq) {
		this.ediRcvRuleMnSeq = ediRcvRuleMnSeq;
	}
	
	/**
	 * Column Info
	 * @param tblNm
	 */
	public void setTblNm(String tblNm) {
		this.tblNm = tblNm;
	}
	
	/**
	 * Column Info
	 * @param prntTagNm
	 */
	public void setPrntTagNm(String prntTagNm) {
		this.prntTagNm = prntTagNm;
	}
	
	/**
	 * Column Info
	 * @param mnlCntrRcvTagFlg
	 */
	public void setMnlCntrRcvTagFlg(String mnlCntrRcvTagFlg) {
		this.mnlCntrRcvTagFlg = mnlCntrRcvTagFlg;
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
		setHdrTagFlg(JSPUtil.getParameter(request, prefix + "hdr_tag_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTagVldKnt(JSPUtil.getParameter(request, prefix + "tag_vld_knt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEdiVndrSeq(JSPUtil.getParameter(request, prefix + "edi_vndr_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFltFileTagNm(JSPUtil.getParameter(request, prefix + "flt_file_tag_nm", ""));
		setTblVoNm(JSPUtil.getParameter(request, prefix + "tbl_vo_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSavSeq(JSPUtil.getParameter(request, prefix + "sav_seq", ""));
		setEdiRcvRuleMnSeq(JSPUtil.getParameter(request, prefix + "edi_rcv_rule_mn_seq", ""));
		setTblNm(JSPUtil.getParameter(request, prefix + "tbl_nm", ""));
		setPrntTagNm(JSPUtil.getParameter(request, prefix + "prnt_tag_nm", ""));
		setMnlCntrRcvTagFlg(JSPUtil.getParameter(request, prefix + "mnl_cntr_rcv_tag_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesEdiRcvFltFileTagMgmtVO[]
	 */
	public ComTesEdiRcvFltFileTagVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesEdiRcvFltFileTagMgmtVO[]
	 */
	public ComTesEdiRcvFltFileTagVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ComTesEdiRcvFltFileTagVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] hdrTagFlg = (JSPUtil.getParameter(request, prefix	+ "hdr_tag_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] tagVldKnt = (JSPUtil.getParameter(request, prefix	+ "tag_vld_knt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ediVndrSeq = (JSPUtil.getParameter(request, prefix	+ "edi_vndr_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fltFileTagNm = (JSPUtil.getParameter(request, prefix	+ "flt_file_tag_nm", length));
			String[] tblVoNm = (JSPUtil.getParameter(request, prefix	+ "tbl_vo_nm", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] savSeq = (JSPUtil.getParameter(request, prefix	+ "sav_seq", length));
			String[] ediRcvRuleMnSeq = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_rule_mn_seq", length));
			String[] tblNm = (JSPUtil.getParameter(request, prefix	+ "tbl_nm", length));
			String[] prntTagNm = (JSPUtil.getParameter(request, prefix	+ "prnt_tag_nm", length));
			String[] mnlCntrRcvTagFlg = (JSPUtil.getParameter(request, prefix	+ "mnl_cntr_rcv_tag_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new ComTesEdiRcvFltFileTagVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (hdrTagFlg[i] != null)
					model.setHdrTagFlg(hdrTagFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (tagVldKnt[i] != null)
					model.setTagVldKnt(tagVldKnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ediVndrSeq[i] != null)
					model.setEdiVndrSeq(ediVndrSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fltFileTagNm[i] != null)
					model.setFltFileTagNm(fltFileTagNm[i]);
				if (tblVoNm[i] != null)
					model.setTblVoNm(tblVoNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (savSeq[i] != null)
					model.setSavSeq(savSeq[i]);
				if (ediRcvRuleMnSeq[i] != null)
					model.setEdiRcvRuleMnSeq(ediRcvRuleMnSeq[i]);
				if (tblNm[i] != null)
					model.setTblNm(tblNm[i]);
				if (prntTagNm[i] != null)
					model.setPrntTagNm(prntTagNm[i]);
				if (mnlCntrRcvTagFlg[i] != null)
					model.setMnlCntrRcvTagFlg(mnlCntrRcvTagFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesEdiRcvFltFileTagMgmtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesEdiRcvFltFileTagMgmtVO[]
	 */
	public ComTesEdiRcvFltFileTagVO[] getTesEdiRcvFltFileTagMgmtVOs(){
		ComTesEdiRcvFltFileTagVO[] vos = (ComTesEdiRcvFltFileTagVO[])models.toArray(new ComTesEdiRcvFltFileTagVO[models.size()]);
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
		this.hdrTagFlg = this.hdrTagFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tagVldKnt = this.tagVldKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediVndrSeq = this.ediVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fltFileTagNm = this.fltFileTagNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tblVoNm = this.tblVoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.savSeq = this.savSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvRuleMnSeq = this.ediRcvRuleMnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tblNm = this.tblNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prntTagNm = this.prntTagNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlCntrRcvTagFlg = this.mnlCntrRcvTagFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

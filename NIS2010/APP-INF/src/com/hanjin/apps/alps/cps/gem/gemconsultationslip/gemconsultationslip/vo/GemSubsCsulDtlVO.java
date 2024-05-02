/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GemSubsCsulDtlVO.java
*@FileTitle : GemSubsCsulDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.27  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo;

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

public class GemSubsCsulDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GemSubsCsulDtlVO> models = new ArrayList<GemSubsCsulDtlVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String invUsdAmt = null;
	/* Column Info */
	private String subsCsrNo = null;
	/* Column Info */
	private String genExpnNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String invLoclAmt = null;
	/* Column Info */
	private String genExpnCd = null;
	/* Column Info */
	private String invSlpDesc = null;
	/* Column Info */
	private String genExpn = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String subsOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String subsCsrSeq = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public GemSubsCsulDtlVO() {}

	public GemSubsCsulDtlVO(String ibflag, String pagerows, String subsCsrNo, String subsOfcCd, String subsCsrSeq, String genExpnCd, String genExpnNm, String invLoclAmt, String invUsdAmt, String invSlpDesc, String creUsrId, String creDt, String updUsrId, String updDt, String genExpn) {
		this.updDt = updDt;
		this.invUsdAmt = invUsdAmt;
		this.subsCsrNo = subsCsrNo;
		this.genExpnNm = genExpnNm;
		this.creDt = creDt;
		this.invLoclAmt = invLoclAmt;
		this.genExpnCd = genExpnCd;
		this.invSlpDesc = invSlpDesc;
		this.genExpn = genExpn;
		this.pagerows = pagerows;
		this.subsOfcCd = subsOfcCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.subsCsrSeq = subsCsrSeq;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("inv_usd_amt", getInvUsdAmt());
		this.hashColumns.put("subs_csr_no", getSubsCsrNo());
		this.hashColumns.put("gen_expn_nm", getGenExpnNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("inv_locl_amt", getInvLoclAmt());
		this.hashColumns.put("gen_expn_cd", getGenExpnCd());
		this.hashColumns.put("inv_slp_desc", getInvSlpDesc());
		this.hashColumns.put("gen_expn", getGenExpn());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("subs_ofc_cd", getSubsOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("subs_csr_seq", getSubsCsrSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("inv_usd_amt", "invUsdAmt");
		this.hashFields.put("subs_csr_no", "subsCsrNo");
		this.hashFields.put("gen_expn_nm", "genExpnNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("inv_locl_amt", "invLoclAmt");
		this.hashFields.put("gen_expn_cd", "genExpnCd");
		this.hashFields.put("inv_slp_desc", "invSlpDesc");
		this.hashFields.put("gen_expn", "genExpn");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("subs_ofc_cd", "subsOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("subs_csr_seq", "subsCsrSeq");
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
	 * @return invUsdAmt
	 */
	public String getInvUsdAmt() {
		return this.invUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return subsCsrNo
	 */
	public String getSubsCsrNo() {
		return this.subsCsrNo;
	}
	
	/**
	 * Column Info
	 * @return genExpnNm
	 */
	public String getGenExpnNm() {
		return this.genExpnNm;
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
	 * @return invLoclAmt
	 */
	public String getInvLoclAmt() {
		return this.invLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return genExpnCd
	 */
	public String getGenExpnCd() {
		return this.genExpnCd;
	}
	
	/**
	 * Column Info
	 * @return invSlpDesc
	 */
	public String getInvSlpDesc() {
		return this.invSlpDesc;
	}
	
	/**
	 * Column Info
	 * @return genExpn
	 */
	public String getGenExpn() {
		return this.genExpn;
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
	 * @return subsOfcCd
	 */
	public String getSubsOfcCd() {
		return this.subsOfcCd;
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
	 * @return subsCsrSeq
	 */
	public String getSubsCsrSeq() {
		return this.subsCsrSeq;
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
	 * @param invUsdAmt
	 */
	public void setInvUsdAmt(String invUsdAmt) {
		this.invUsdAmt = invUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param subsCsrNo
	 */
	public void setSubsCsrNo(String subsCsrNo) {
		this.subsCsrNo = subsCsrNo;
	}
	
	/**
	 * Column Info
	 * @param genExpnNm
	 */
	public void setGenExpnNm(String genExpnNm) {
		this.genExpnNm = genExpnNm;
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
	 * @param invLoclAmt
	 */
	public void setInvLoclAmt(String invLoclAmt) {
		this.invLoclAmt = invLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param genExpnCd
	 */
	public void setGenExpnCd(String genExpnCd) {
		this.genExpnCd = genExpnCd;
	}
	
	/**
	 * Column Info
	 * @param invSlpDesc
	 */
	public void setInvSlpDesc(String invSlpDesc) {
		this.invSlpDesc = invSlpDesc;
	}
	
	/**
	 * Column Info
	 * @param genExpn
	 */
	public void setGenExpn(String genExpn) {
		this.genExpn = genExpn;
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
	 * @param subsOfcCd
	 */
	public void setSubsOfcCd(String subsOfcCd) {
		this.subsOfcCd = subsOfcCd;
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
	 * @param subsCsrSeq
	 */
	public void setSubsCsrSeq(String subsCsrSeq) {
		this.subsCsrSeq = subsCsrSeq;
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
		setInvUsdAmt(JSPUtil.getParameter(request, prefix + "inv_usd_amt", ""));
		setSubsCsrNo(JSPUtil.getParameter(request, prefix + "subs_csr_no", ""));
		setGenExpnNm(JSPUtil.getParameter(request, prefix + "gen_expn_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setInvLoclAmt(JSPUtil.getParameter(request, prefix + "inv_locl_amt", ""));
		setGenExpnCd(JSPUtil.getParameter(request, prefix + "gen_expn_cd", ""));
		setInvSlpDesc(JSPUtil.getParameter(request, prefix + "inv_slp_desc", ""));
		setGenExpn(JSPUtil.getParameter(request, prefix + "gen_expn", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSubsOfcCd(JSPUtil.getParameter(request, prefix + "subs_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSubsCsrSeq(JSPUtil.getParameter(request, prefix + "subs_csr_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GemSubsCsulDtlVO[]
	 */
	public GemSubsCsulDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GemSubsCsulDtlVO[]
	 */
	public GemSubsCsulDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GemSubsCsulDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] invUsdAmt = (JSPUtil.getParameter(request, prefix	+ "inv_usd_amt", length));
			String[] subsCsrNo = (JSPUtil.getParameter(request, prefix	+ "subs_csr_no", length));
			String[] genExpnNm = (JSPUtil.getParameter(request, prefix	+ "gen_expn_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] invLoclAmt = (JSPUtil.getParameter(request, prefix	+ "inv_locl_amt", length));
			String[] genExpnCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_cd", length));
			String[] invSlpDesc = (JSPUtil.getParameter(request, prefix	+ "inv_slp_desc", length));
			String[] genExpn = (JSPUtil.getParameter(request, prefix	+ "gen_expn", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] subsOfcCd = (JSPUtil.getParameter(request, prefix	+ "subs_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] subsCsrSeq = (JSPUtil.getParameter(request, prefix	+ "subs_csr_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new GemSubsCsulDtlVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (invUsdAmt[i] != null)
					model.setInvUsdAmt(invUsdAmt[i]);
				if (subsCsrNo[i] != null)
					model.setSubsCsrNo(subsCsrNo[i]);
				if (genExpnNm[i] != null)
					model.setGenExpnNm(genExpnNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (invLoclAmt[i] != null)
					model.setInvLoclAmt(invLoclAmt[i]);
				if (genExpnCd[i] != null)
					model.setGenExpnCd(genExpnCd[i]);
				if (invSlpDesc[i] != null)
					model.setInvSlpDesc(invSlpDesc[i]);
				if (genExpn[i] != null)
					model.setGenExpn(genExpn[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (subsOfcCd[i] != null)
					model.setSubsOfcCd(subsOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (subsCsrSeq[i] != null)
					model.setSubsCsrSeq(subsCsrSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGemSubsCsulDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GemSubsCsulDtlVO[]
	 */
	public GemSubsCsulDtlVO[] getGemSubsCsulDtlVOs(){
		GemSubsCsulDtlVO[] vos = (GemSubsCsulDtlVO[])models.toArray(new GemSubsCsulDtlVO[models.size()]);
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
		this.invUsdAmt = this.invUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsCsrNo = this.subsCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnNm = this.genExpnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invLoclAmt = this.invLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnCd = this.genExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSlpDesc = this.invSlpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpn = this.genExpn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsOfcCd = this.subsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsCsrSeq = this.subsCsrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchPerRepPupModiVO.java
*@FileTitle : SearchPerRepPupModiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.09
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.09  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchPerRepPupModiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchPerRepPupModiVO> models = new ArrayList<SearchPerRepPupModiVO>();
	
	/* Column Info */
	private String text = null;
	/* Column Info */
	private String sHiddenFlg = null;
	/* Column Info */
	private String sUseFlg = null;
	/* Column Info */
	private String ediGrpCd = null;
	/* Column Info */
	private String sRptColNm = null;
	/* Column Info */
	private String sRptColSeq = null;
	/* Column Info */
	private String useFlg = null;
	/* Column Info */
	private String sCustEdiStsCd = null;
	/* Column Info */
	private String sRptColDesc = null;
	/* Column Info */
	private String custEdiStsCd = null;
	/* Column Info */
	private String code = null;
	/* Column Info */
	private String sEdiStsFlg = null;
	/* Column Info */
	private String ediStsDesc = null;
	/* Column Info */
	private String ediStndStsCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sEdiGrpCd = null;
	/* Column Info */
	private String sCreUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String rptColSeq = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String rptColNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchPerRepPupModiVO() {}

	public SearchPerRepPupModiVO(String ibflag, String pagerows, String ediGrpCd, String custEdiStsCd, String ediStsDesc, String ediStndStsCd, String useFlg, String rptColSeq, String rptColNm, String code, String text, String userId, String creUsrId, String sCreUsrId, String sEdiGrpCd, String sRptColSeq, String sRptColNm, String sRptColDesc, String sEdiStsFlg, String sUseFlg, String sCustEdiStsCd, String sHiddenFlg) {
		this.text = text;
		this.sHiddenFlg = sHiddenFlg;
		this.sUseFlg = sUseFlg;
		this.ediGrpCd = ediGrpCd;
		this.sRptColNm = sRptColNm;
		this.sRptColSeq = sRptColSeq;
		this.useFlg = useFlg;
		this.sCustEdiStsCd = sCustEdiStsCd;
		this.sRptColDesc = sRptColDesc;
		this.custEdiStsCd = custEdiStsCd;
		this.code = code;
		this.sEdiStsFlg = sEdiStsFlg;
		this.ediStsDesc = ediStsDesc;
		this.ediStndStsCd = ediStndStsCd;
		this.pagerows = pagerows;
		this.sEdiGrpCd = sEdiGrpCd;
		this.sCreUsrId = sCreUsrId;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.rptColSeq = rptColSeq;
		this.userId = userId;
		this.rptColNm = rptColNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("text", getText());
		this.hashColumns.put("s_hidden_flg", getSHiddenFlg());
		this.hashColumns.put("s_use_flg", getSUseFlg());
		this.hashColumns.put("edi_grp_cd", getEdiGrpCd());
		this.hashColumns.put("s_rpt_col_nm", getSRptColNm());
		this.hashColumns.put("s_rpt_col_seq", getSRptColSeq());
		this.hashColumns.put("use_flg", getUseFlg());
		this.hashColumns.put("s_cust_edi_sts_cd", getSCustEdiStsCd());
		this.hashColumns.put("s_rpt_col_desc", getSRptColDesc());
		this.hashColumns.put("cust_edi_sts_cd", getCustEdiStsCd());
		this.hashColumns.put("code", getCode());
		this.hashColumns.put("s_edi_sts_flg", getSEdiStsFlg());
		this.hashColumns.put("edi_sts_desc", getEdiStsDesc());
		this.hashColumns.put("edi_stnd_sts_cd", getEdiStndStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s_edi_grp_cd", getSEdiGrpCd());
		this.hashColumns.put("s_cre_usr_id", getSCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("rpt_col_seq", getRptColSeq());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("rpt_col_nm", getRptColNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("text", "text");
		this.hashFields.put("s_hidden_flg", "sHiddenFlg");
		this.hashFields.put("s_use_flg", "sUseFlg");
		this.hashFields.put("edi_grp_cd", "ediGrpCd");
		this.hashFields.put("s_rpt_col_nm", "sRptColNm");
		this.hashFields.put("s_rpt_col_seq", "sRptColSeq");
		this.hashFields.put("use_flg", "useFlg");
		this.hashFields.put("s_cust_edi_sts_cd", "sCustEdiStsCd");
		this.hashFields.put("s_rpt_col_desc", "sRptColDesc");
		this.hashFields.put("cust_edi_sts_cd", "custEdiStsCd");
		this.hashFields.put("code", "code");
		this.hashFields.put("s_edi_sts_flg", "sEdiStsFlg");
		this.hashFields.put("edi_sts_desc", "ediStsDesc");
		this.hashFields.put("edi_stnd_sts_cd", "ediStndStsCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s_edi_grp_cd", "sEdiGrpCd");
		this.hashFields.put("s_cre_usr_id", "sCreUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("rpt_col_seq", "rptColSeq");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("rpt_col_nm", "rptColNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return text
	 */
	public String getText() {
		return this.text;
	}
	
	/**
	 * Column Info
	 * @return sHiddenFlg
	 */
	public String getSHiddenFlg() {
		return this.sHiddenFlg;
	}
	
	/**
	 * Column Info
	 * @return sUseFlg
	 */
	public String getSUseFlg() {
		return this.sUseFlg;
	}
	
	/**
	 * Column Info
	 * @return ediGrpCd
	 */
	public String getEdiGrpCd() {
		return this.ediGrpCd;
	}
	
	/**
	 * Column Info
	 * @return sRptColNm
	 */
	public String getSRptColNm() {
		return this.sRptColNm;
	}
	
	/**
	 * Column Info
	 * @return sRptColSeq
	 */
	public String getSRptColSeq() {
		return this.sRptColSeq;
	}
	
	/**
	 * Column Info
	 * @return useFlg
	 */
	public String getUseFlg() {
		return this.useFlg;
	}
	
	/**
	 * Column Info
	 * @return sCustEdiStsCd
	 */
	public String getSCustEdiStsCd() {
		return this.sCustEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @return sRptColDesc
	 */
	public String getSRptColDesc() {
		return this.sRptColDesc;
	}
	
	/**
	 * Column Info
	 * @return custEdiStsCd
	 */
	public String getCustEdiStsCd() {
		return this.custEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @return code
	 */
	public String getCode() {
		return this.code;
	}
	
	/**
	 * Column Info
	 * @return sEdiStsFlg
	 */
	public String getSEdiStsFlg() {
		return this.sEdiStsFlg;
	}
	
	/**
	 * Column Info
	 * @return ediStsDesc
	 */
	public String getEdiStsDesc() {
		return this.ediStsDesc;
	}
	
	/**
	 * Column Info
	 * @return ediStndStsCd
	 */
	public String getEdiStndStsCd() {
		return this.ediStndStsCd;
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
	 * @return sEdiGrpCd
	 */
	public String getSEdiGrpCd() {
		return this.sEdiGrpCd;
	}
	
	/**
	 * Column Info
	 * @return sCreUsrId
	 */
	public String getSCreUsrId() {
		return this.sCreUsrId;
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
	 * @return rptColSeq
	 */
	public String getRptColSeq() {
		return this.rptColSeq;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return rptColNm
	 */
	public String getRptColNm() {
		return this.rptColNm;
	}
	

	/**
	 * Column Info
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * Column Info
	 * @param sHiddenFlg
	 */
	public void setSHiddenFlg(String sHiddenFlg) {
		this.sHiddenFlg = sHiddenFlg;
	}
	
	/**
	 * Column Info
	 * @param sUseFlg
	 */
	public void setSUseFlg(String sUseFlg) {
		this.sUseFlg = sUseFlg;
	}
	
	/**
	 * Column Info
	 * @param ediGrpCd
	 */
	public void setEdiGrpCd(String ediGrpCd) {
		this.ediGrpCd = ediGrpCd;
	}
	
	/**
	 * Column Info
	 * @param sRptColNm
	 */
	public void setSRptColNm(String sRptColNm) {
		this.sRptColNm = sRptColNm;
	}
	
	/**
	 * Column Info
	 * @param sRptColSeq
	 */
	public void setSRptColSeq(String sRptColSeq) {
		this.sRptColSeq = sRptColSeq;
	}
	
	/**
	 * Column Info
	 * @param useFlg
	 */
	public void setUseFlg(String useFlg) {
		this.useFlg = useFlg;
	}
	
	/**
	 * Column Info
	 * @param sCustEdiStsCd
	 */
	public void setSCustEdiStsCd(String sCustEdiStsCd) {
		this.sCustEdiStsCd = sCustEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @param sRptColDesc
	 */
	public void setSRptColDesc(String sRptColDesc) {
		this.sRptColDesc = sRptColDesc;
	}
	
	/**
	 * Column Info
	 * @param custEdiStsCd
	 */
	public void setCustEdiStsCd(String custEdiStsCd) {
		this.custEdiStsCd = custEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Column Info
	 * @param sEdiStsFlg
	 */
	public void setSEdiStsFlg(String sEdiStsFlg) {
		this.sEdiStsFlg = sEdiStsFlg;
	}
	
	/**
	 * Column Info
	 * @param ediStsDesc
	 */
	public void setEdiStsDesc(String ediStsDesc) {
		this.ediStsDesc = ediStsDesc;
	}
	
	/**
	 * Column Info
	 * @param ediStndStsCd
	 */
	public void setEdiStndStsCd(String ediStndStsCd) {
		this.ediStndStsCd = ediStndStsCd;
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
	 * @param sEdiGrpCd
	 */
	public void setSEdiGrpCd(String sEdiGrpCd) {
		this.sEdiGrpCd = sEdiGrpCd;
	}
	
	/**
	 * Column Info
	 * @param sCreUsrId
	 */
	public void setSCreUsrId(String sCreUsrId) {
		this.sCreUsrId = sCreUsrId;
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
	 * @param rptColSeq
	 */
	public void setRptColSeq(String rptColSeq) {
		this.rptColSeq = rptColSeq;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param rptColNm
	 */
	public void setRptColNm(String rptColNm) {
		this.rptColNm = rptColNm;
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
		setText(JSPUtil.getParameter(request, prefix + "text", ""));
		setSHiddenFlg(JSPUtil.getParameter(request, prefix + "s_hidden_flg", ""));
		setSUseFlg(JSPUtil.getParameter(request, prefix + "s_use_flg", ""));
		setEdiGrpCd(JSPUtil.getParameter(request, prefix + "edi_grp_cd", ""));
		setSRptColNm(JSPUtil.getParameter(request, prefix + "s_rpt_col_nm", ""));
		setSRptColSeq(JSPUtil.getParameter(request, prefix + "s_rpt_col_seq", ""));
		setUseFlg(JSPUtil.getParameter(request, prefix + "use_flg", ""));
		setSCustEdiStsCd(JSPUtil.getParameter(request, prefix + "s_cust_edi_sts_cd", ""));
		setSRptColDesc(JSPUtil.getParameter(request, prefix + "s_rpt_col_desc", ""));
		setCustEdiStsCd(JSPUtil.getParameter(request, prefix + "cust_edi_sts_cd", ""));
		setCode(JSPUtil.getParameter(request, prefix + "code", ""));
		setSEdiStsFlg(JSPUtil.getParameter(request, prefix + "s_edi_sts_flg", ""));
		setEdiStsDesc(JSPUtil.getParameter(request, prefix + "edi_sts_desc", ""));
		setEdiStndStsCd(JSPUtil.getParameter(request, prefix + "edi_stnd_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSEdiGrpCd(JSPUtil.getParameter(request, prefix + "s_edi_grp_cd", ""));
		setSCreUsrId(JSPUtil.getParameter(request, prefix + "s_cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setRptColSeq(JSPUtil.getParameter(request, prefix + "rpt_col_seq", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setRptColNm(JSPUtil.getParameter(request, prefix + "rpt_col_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchPerRepPupModiVO[]
	 */
	public SearchPerRepPupModiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchPerRepPupModiVO[]
	 */
	public SearchPerRepPupModiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchPerRepPupModiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] text = (JSPUtil.getParameter(request, prefix	+ "text", length));
			String[] sHiddenFlg = (JSPUtil.getParameter(request, prefix	+ "s_hidden_flg", length));
			String[] sUseFlg = (JSPUtil.getParameter(request, prefix	+ "s_use_flg", length));
			String[] ediGrpCd = (JSPUtil.getParameter(request, prefix	+ "edi_grp_cd", length));
			String[] sRptColNm = (JSPUtil.getParameter(request, prefix	+ "s_rpt_col_nm", length));
			String[] sRptColSeq = (JSPUtil.getParameter(request, prefix	+ "s_rpt_col_seq", length));
			String[] useFlg = (JSPUtil.getParameter(request, prefix	+ "use_flg", length));
			String[] sCustEdiStsCd = (JSPUtil.getParameter(request, prefix	+ "s_cust_edi_sts_cd", length));
			String[] sRptColDesc = (JSPUtil.getParameter(request, prefix	+ "s_rpt_col_desc", length));
			String[] custEdiStsCd = (JSPUtil.getParameter(request, prefix	+ "cust_edi_sts_cd", length));
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code", length));
			String[] sEdiStsFlg = (JSPUtil.getParameter(request, prefix	+ "s_edi_sts_flg", length));
			String[] ediStsDesc = (JSPUtil.getParameter(request, prefix	+ "edi_sts_desc", length));
			String[] ediStndStsCd = (JSPUtil.getParameter(request, prefix	+ "edi_stnd_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sEdiGrpCd = (JSPUtil.getParameter(request, prefix	+ "s_edi_grp_cd", length));
			String[] sCreUsrId = (JSPUtil.getParameter(request, prefix	+ "s_cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] rptColSeq = (JSPUtil.getParameter(request, prefix	+ "rpt_col_seq", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] rptColNm = (JSPUtil.getParameter(request, prefix	+ "rpt_col_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchPerRepPupModiVO();
				if (text[i] != null)
					model.setText(text[i]);
				if (sHiddenFlg[i] != null)
					model.setSHiddenFlg(sHiddenFlg[i]);
				if (sUseFlg[i] != null)
					model.setSUseFlg(sUseFlg[i]);
				if (ediGrpCd[i] != null)
					model.setEdiGrpCd(ediGrpCd[i]);
				if (sRptColNm[i] != null)
					model.setSRptColNm(sRptColNm[i]);
				if (sRptColSeq[i] != null)
					model.setSRptColSeq(sRptColSeq[i]);
				if (useFlg[i] != null)
					model.setUseFlg(useFlg[i]);
				if (sCustEdiStsCd[i] != null)
					model.setSCustEdiStsCd(sCustEdiStsCd[i]);
				if (sRptColDesc[i] != null)
					model.setSRptColDesc(sRptColDesc[i]);
				if (custEdiStsCd[i] != null)
					model.setCustEdiStsCd(custEdiStsCd[i]);
				if (code[i] != null)
					model.setCode(code[i]);
				if (sEdiStsFlg[i] != null)
					model.setSEdiStsFlg(sEdiStsFlg[i]);
				if (ediStsDesc[i] != null)
					model.setEdiStsDesc(ediStsDesc[i]);
				if (ediStndStsCd[i] != null)
					model.setEdiStndStsCd(ediStndStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sEdiGrpCd[i] != null)
					model.setSEdiGrpCd(sEdiGrpCd[i]);
				if (sCreUsrId[i] != null)
					model.setSCreUsrId(sCreUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (rptColSeq[i] != null)
					model.setRptColSeq(rptColSeq[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (rptColNm[i] != null)
					model.setRptColNm(rptColNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchPerRepPupModiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchPerRepPupModiVO[]
	 */
	public SearchPerRepPupModiVO[] getSearchPerRepPupModiVOs(){
		SearchPerRepPupModiVO[] vos = (SearchPerRepPupModiVO[])models.toArray(new SearchPerRepPupModiVO[models.size()]);
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
		this.text = this.text .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sHiddenFlg = this.sHiddenFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sUseFlg = this.sUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGrpCd = this.ediGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRptColNm = this.sRptColNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRptColSeq = this.sRptColSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.useFlg = this.useFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustEdiStsCd = this.sCustEdiStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRptColDesc = this.sRptColDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEdiStsCd = this.custEdiStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEdiStsFlg = this.sEdiStsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediStsDesc = this.ediStsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediStndStsCd = this.ediStndStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEdiGrpCd = this.sEdiGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCreUsrId = this.sCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptColSeq = this.rptColSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptColNm = this.rptColNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ScgNonDgCgoKwVO.java
*@FileTitle : ScgNonDgCgoKwVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.12  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo;

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

public class ScgNonDgCgoKwVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgNonDgCgoKwVO> models = new ArrayList<ScgNonDgCgoKwVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String nonDcgoCateGrpCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String nonDcgoKwSeq = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String nonDcgoKwNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String deltDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String deltUsrId = null;
	/* Page Number */
	private String pagerows = null;	
	/* Column Info */
	private String nonDcgoCateCd= null;
	/* Column Info */
	private String nonDcgoNm= null;
	/* Column Info */
	private String cmtCtnt= null;
	/* Column Info */
	private String kwInclFlg= null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ScgNonDgCgoKwVO() {}

	public ScgNonDgCgoKwVO(String ibflag, String pagerows, String nonDcgoKwSeq, String nonDcgoKwNm, String nonDcgoCateGrpCd, String deltFlg, String deltUsrId, String deltDt, String creUsrId, String creDt, String updUsrId, String updDt,String nonDcgoCateCd, String nonDcgoNm, String cmtCtnt, String kwInclFlg) {
		this.updDt = updDt;
		this.nonDcgoCateGrpCd = nonDcgoCateGrpCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.nonDcgoKwSeq = nonDcgoKwSeq;
		this.deltFlg = deltFlg;
		this.nonDcgoKwNm = nonDcgoKwNm;
		this.creDt = creDt;
		this.deltDt = deltDt;
		this.updUsrId = updUsrId;
		this.deltUsrId = deltUsrId;
		this.nonDcgoCateCd = nonDcgoCateCd;
		this.nonDcgoNm     = nonDcgoNm;
		this.pagerows = pagerows;
		this.cmtCtnt  = cmtCtnt;
		this.kwInclFlg  = kwInclFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("non_dcgo_cate_grp_cd", getNonDcgoCateGrpCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("non_dcgo_kw_seq", getNonDcgoKwSeq());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("non_dcgo_kw_nm", getNonDcgoKwNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("delt_dt", getDeltDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("delt_usr_id", getDeltUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("non_dcgo_cate_cd", getNonDcgoCateCd());
		this.hashColumns.put("non_dcgo_nm", getNonDcgoNm());
		this.hashColumns.put("cmt_ctnt", getCmtCtnt());
		this.hashColumns.put("kw_incl_flg", getKwInclFlg());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("non_dcgo_cate_grp_cd", "nonDcgoCateGrpCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("non_dcgo_kw_seq", "nonDcgoKwSeq");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("non_dcgo_kw_nm", "nonDcgoKwNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("delt_dt", "deltDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("delt_usr_id", "deltUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("non_dcgo_nm", "nonDcgoNm");
		this.hashFields.put("non_dcgo_cate_cd", "nonDcgoCateCd");
		this.hashFields.put("cmt_ctnt", "cmtCtnt");
		this.hashFields.put("kw_incl_flg", "kwInclFlg");
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
	 * @return cmtCtnt
	 */
	public String getCmtCtnt() {
		return this.cmtCtnt;
	}
	
	/**
	 * Column Info
	 * @return nonDcgoCateGrpCd
	 */
	public String getNonDcgoCateGrpCd() {
		return this.nonDcgoCateGrpCd;
	}
	
	/**
	 * Column Info
	 * @return nonDcgoCateCd
	 */
	public String getNonDcgoCateCd() {
		return this.nonDcgoCateCd;
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
	 * @return nonDcgoKwSeq
	 */
	public String getNonDcgoKwSeq() {
		return this.nonDcgoKwSeq;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return nonDcgoKwNm
	 */
	public String getNonDcgoKwNm() {
		return this.nonDcgoKwNm;
	}
	
	/**
	 * Column Info
	 * @return nonDcgoNm
	 */
	public String getNonDcgoNm() {
		return this.nonDcgoNm;
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
	 * @return deltDt
	 */
	public String getDeltDt() {
		return this.deltDt;
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
	 * @return deltUsrId
	 */
	public String getDeltUsrId() {
		return this.deltUsrId;
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
	 * @param kwInclFlg
	 * @return
	 */
	public String getKwInclFlg() {
		return kwInclFlg;
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
	 * @param nonDcgoCateGrpCd
	 */
	public void setNonDcgoCateGrpCd(String nonDcgoCateGrpCd) {
		this.nonDcgoCateGrpCd = nonDcgoCateGrpCd;
	}
	
	/**
	 * Column Info
	 * @param cmtCtnt
	 */
	public void setCmtCtnt(String cmtCtnt) {
		this.cmtCtnt = cmtCtnt;
	}
	
	/**
	 * Column Info
	 * @param nonDcgoCateCd
	 */
	public void setNonDcgoCateCd(String nonDcgoCateCd) {
		this.nonDcgoCateCd = nonDcgoCateCd;
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
	 * @param nonDcgoKwSeq
	 */
	public void setNonDcgoKwSeq(String nonDcgoKwSeq) {
		this.nonDcgoKwSeq = nonDcgoKwSeq;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param nonDcgoKwNm
	 */
	public void setNonDcgoKwNm(String nonDcgoKwNm) {
		this.nonDcgoKwNm = nonDcgoKwNm;
	}
	
	/**
	 * Column Info
	 * @param nonDcgoNm
	 */
	public void setNonDcgoNm(String nonDcgoNm) {
		this.nonDcgoNm = nonDcgoNm;
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
	 * @param deltDt
	 */
	public void setDeltDt(String deltDt) {
		this.deltDt = deltDt;
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
	 * @param deltUsrId
	 */
	public void setDeltUsrId(String deltUsrId) {
		this.deltUsrId = deltUsrId;
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
	 * @param kwInclFlg
	 */
	public void setKwInclFlg(String kwInclFlg) {
		this.kwInclFlg = kwInclFlg;
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
		setNonDcgoCateGrpCd(JSPUtil.getParameter(request, prefix + "non_dcgo_cate_grp_cd", ""));
		setNonDcgoCateCd(JSPUtil.getParameter(request, prefix + "non_dcgo_cate_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setNonDcgoKwSeq(JSPUtil.getParameter(request, prefix + "non_dcgo_kw_seq", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setNonDcgoKwNm(JSPUtil.getParameter(request, prefix + "non_dcgo_kw_nm", ""));
		setNonDcgoNm(JSPUtil.getParameter(request, prefix + "non_dcgo_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDeltDt(JSPUtil.getParameter(request, prefix + "delt_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setDeltUsrId(JSPUtil.getParameter(request, prefix + "delt_usr_id", ""));
		setCmtCtnt(JSPUtil.getParameter(request, prefix + "cmt_ctnt", ""));
		setKwInclFlg(JSPUtil.getParameter(request, prefix + "kw_incl_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgNonDgCgoKwVO[]
	 */
	public ScgNonDgCgoKwVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgNonDgCgoKwVO[]
	 */
	public ScgNonDgCgoKwVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgNonDgCgoKwVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] nonDcgoCateGrpCd = (JSPUtil.getParameter(request, prefix	+ "non_dcgo_cate_grp_cd", length));
			String[] nonDcgoCateCd = (JSPUtil.getParameter(request, prefix	+ "non_dcgo_cate_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] nonDcgoKwSeq = (JSPUtil.getParameter(request, prefix	+ "non_dcgo_kw_seq", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] nonDcgoKwNm = (JSPUtil.getParameter(request, prefix	+ "non_dcgo_kw_nm", length));
			String[] nonDcgoNm = (JSPUtil.getParameter(request, prefix	+ "non_dcgo_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] deltDt = (JSPUtil.getParameter(request, prefix	+ "delt_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] deltUsrId = (JSPUtil.getParameter(request, prefix	+ "delt_usr_id", length));
			String[] cmtCtnt = (JSPUtil.getParameter(request, prefix	+ "cmt_ctnt", length));
			String[] kwInclFlg = (JSPUtil.getParameter(request, prefix	+ "kw_incl_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgNonDgCgoKwVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (nonDcgoCateGrpCd[i] != null)
					model.setNonDcgoCateGrpCd(nonDcgoCateGrpCd[i]);
				if (nonDcgoCateCd[i] != null)
					model.setNonDcgoCateCd(nonDcgoCateCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (nonDcgoKwSeq[i] != null)
					model.setNonDcgoKwSeq(nonDcgoKwSeq[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (nonDcgoKwNm[i] != null)
					model.setNonDcgoKwNm(nonDcgoKwNm[i]);
				if (nonDcgoNm[i] != null)
					model.setNonDcgoNm(nonDcgoNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (deltDt[i] != null)
					model.setDeltDt(deltDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (deltUsrId[i] != null)
					model.setDeltUsrId(deltUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cmtCtnt[i] != null)
					model.setCmtCtnt(cmtCtnt[i]);
				if (kwInclFlg[i] != null)
					model.setKwInclFlg(kwInclFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgNonDgCgoKwVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgNonDgCgoKwVO[]
	 */
	public ScgNonDgCgoKwVO[] getScgNonDgCgoKwVOs(){
		ScgNonDgCgoKwVO[] vos = (ScgNonDgCgoKwVO[])models.toArray(new ScgNonDgCgoKwVO[models.size()]);
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
		this.nonDcgoCateGrpCd = this.nonDcgoCateGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonDcgoCateCd = this.nonDcgoCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonDcgoKwSeq = this.nonDcgoKwSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonDcgoKwNm = this.nonDcgoKwNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonDcgoNm = this.nonDcgoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltDt = this.deltDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltUsrId = this.deltUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmtCtnt = this.cmtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kwInclFlg = this.kwInclFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}

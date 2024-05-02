/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CniDwTrnsVO.java
*@FileTitle : CniDwTrnsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.19
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2010.04.19 양정란 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo;

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
 * @author 양정란
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CniDwTrnsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CniDwTrnsVO> models = new ArrayList<CniDwTrnsVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String trnsFmOfcCd = null;
	/* Column Info */
	private String trnsUsrId = null;
	/* Column Info */
	private String trnsFmDt = null;
	/* Column Info */
	private String trnsToUsrId = null;
	/* Column Info */
	private String trnsKnt = null;
	/* Column Info */
	private String trnsSeq = null;
	/* Column Info */
	private String clmTrnsAuthCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trnsRmk = null;
	/* Column Info */
	private String trnsFmUsrId = null;
	/* Column Info */
	private String trnsToDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trnsToOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String dwClmNo = null;
	/* Column Info */
	private String trnsOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CniDwTrnsVO() {}

	public CniDwTrnsVO(String ibflag, String pagerows, String dwClmNo, String trnsSeq, String trnsOfcCd, String trnsUsrId, String trnsFmOfcCd, String trnsFmUsrId, String trnsFmDt, String clmTrnsAuthCd, String trnsToOfcCd, String trnsToUsrId, String trnsToDt, String trnsRmk, String trnsKnt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.trnsFmOfcCd = trnsFmOfcCd;
		this.trnsUsrId = trnsUsrId;
		this.trnsFmDt = trnsFmDt;
		this.trnsToUsrId = trnsToUsrId;
		this.trnsKnt = trnsKnt;
		this.trnsSeq = trnsSeq;
		this.clmTrnsAuthCd = clmTrnsAuthCd;
		this.creDt = creDt;
		this.trnsRmk = trnsRmk;
		this.trnsFmUsrId = trnsFmUsrId;
		this.trnsToDt = trnsToDt;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.trnsToOfcCd = trnsToOfcCd;
		this.updUsrId = updUsrId;
		this.dwClmNo = dwClmNo;
		this.trnsOfcCd = trnsOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("trns_fm_ofc_cd", getTrnsFmOfcCd());
		this.hashColumns.put("trns_usr_id", getTrnsUsrId());
		this.hashColumns.put("trns_fm_dt", getTrnsFmDt());
		this.hashColumns.put("trns_to_usr_id", getTrnsToUsrId());
		this.hashColumns.put("trns_knt", getTrnsKnt());
		this.hashColumns.put("trns_seq", getTrnsSeq());
		this.hashColumns.put("clm_trns_auth_cd", getClmTrnsAuthCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trns_rmk", getTrnsRmk());
		this.hashColumns.put("trns_fm_usr_id", getTrnsFmUsrId());
		this.hashColumns.put("trns_to_dt", getTrnsToDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trns_to_ofc_cd", getTrnsToOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dw_clm_no", getDwClmNo());
		this.hashColumns.put("trns_ofc_cd", getTrnsOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("trns_fm_ofc_cd", "trnsFmOfcCd");
		this.hashFields.put("trns_usr_id", "trnsUsrId");
		this.hashFields.put("trns_fm_dt", "trnsFmDt");
		this.hashFields.put("trns_to_usr_id", "trnsToUsrId");
		this.hashFields.put("trns_knt", "trnsKnt");
		this.hashFields.put("trns_seq", "trnsSeq");
		this.hashFields.put("clm_trns_auth_cd", "clmTrnsAuthCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trns_rmk", "trnsRmk");
		this.hashFields.put("trns_fm_usr_id", "trnsFmUsrId");
		this.hashFields.put("trns_to_dt", "trnsToDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trns_to_ofc_cd", "trnsToOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dw_clm_no", "dwClmNo");
		this.hashFields.put("trns_ofc_cd", "trnsOfcCd");
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
	 * @return trnsFmOfcCd
	 */
	public String getTrnsFmOfcCd() {
		return this.trnsFmOfcCd;
	}
	
	/**
	 * Column Info
	 * @return trnsUsrId
	 */
	public String getTrnsUsrId() {
		return this.trnsUsrId;
	}
	
	/**
	 * Column Info
	 * @return trnsFmDt
	 */
	public String getTrnsFmDt() {
		return this.trnsFmDt;
	}
	
	/**
	 * Column Info
	 * @return trnsToUsrId
	 */
	public String getTrnsToUsrId() {
		return this.trnsToUsrId;
	}
	
	/**
	 * Column Info
	 * @return trnsKnt
	 */
	public String getTrnsKnt() {
		return this.trnsKnt;
	}
	
	/**
	 * Column Info
	 * @return trnsSeq
	 */
	public String getTrnsSeq() {
		return this.trnsSeq;
	}
	
	/**
	 * Column Info
	 * @return clmTrnsAuthCd
	 */
	public String getClmTrnsAuthCd() {
		return this.clmTrnsAuthCd;
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
	 * @return trnsRmk
	 */
	public String getTrnsRmk() {
		return this.trnsRmk;
	}
	
	/**
	 * Column Info
	 * @return trnsFmUsrId
	 */
	public String getTrnsFmUsrId() {
		return this.trnsFmUsrId;
	}
	
	/**
	 * Column Info
	 * @return trnsToDt
	 */
	public String getTrnsToDt() {
		return this.trnsToDt;
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
	 * @return trnsToOfcCd
	 */
	public String getTrnsToOfcCd() {
		return this.trnsToOfcCd;
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
	 * @return dwClmNo
	 */
	public String getDwClmNo() {
		return this.dwClmNo;
	}
	
	/**
	 * Column Info
	 * @return trnsOfcCd
	 */
	public String getTrnsOfcCd() {
		return this.trnsOfcCd;
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
	 * @param trnsFmOfcCd
	 */
	public void setTrnsFmOfcCd(String trnsFmOfcCd) {
		this.trnsFmOfcCd = trnsFmOfcCd;
	}
	
	/**
	 * Column Info
	 * @param trnsUsrId
	 */
	public void setTrnsUsrId(String trnsUsrId) {
		this.trnsUsrId = trnsUsrId;
	}
	
	/**
	 * Column Info
	 * @param trnsFmDt
	 */
	public void setTrnsFmDt(String trnsFmDt) {
		this.trnsFmDt = trnsFmDt;
	}
	
	/**
	 * Column Info
	 * @param trnsToUsrId
	 */
	public void setTrnsToUsrId(String trnsToUsrId) {
		this.trnsToUsrId = trnsToUsrId;
	}
	
	/**
	 * Column Info
	 * @param trnsKnt
	 */
	public void setTrnsKnt(String trnsKnt) {
		this.trnsKnt = trnsKnt;
	}
	
	/**
	 * Column Info
	 * @param trnsSeq
	 */
	public void setTrnsSeq(String trnsSeq) {
		this.trnsSeq = trnsSeq;
	}
	
	/**
	 * Column Info
	 * @param clmTrnsAuthCd
	 */
	public void setClmTrnsAuthCd(String clmTrnsAuthCd) {
		this.clmTrnsAuthCd = clmTrnsAuthCd;
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
	 * @param trnsRmk
	 */
	public void setTrnsRmk(String trnsRmk) {
		this.trnsRmk = trnsRmk;
	}
	
	/**
	 * Column Info
	 * @param trnsFmUsrId
	 */
	public void setTrnsFmUsrId(String trnsFmUsrId) {
		this.trnsFmUsrId = trnsFmUsrId;
	}
	
	/**
	 * Column Info
	 * @param trnsToDt
	 */
	public void setTrnsToDt(String trnsToDt) {
		this.trnsToDt = trnsToDt;
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
	 * @param trnsToOfcCd
	 */
	public void setTrnsToOfcCd(String trnsToOfcCd) {
		this.trnsToOfcCd = trnsToOfcCd;
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
	 * @param dwClmNo
	 */
	public void setDwClmNo(String dwClmNo) {
		this.dwClmNo = dwClmNo;
	}
	
	/**
	 * Column Info
	 * @param trnsOfcCd
	 */
	public void setTrnsOfcCd(String trnsOfcCd) {
		this.trnsOfcCd = trnsOfcCd;
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
		setTrnsFmOfcCd(JSPUtil.getParameter(request, prefix + "trns_fm_ofc_cd", ""));
		setTrnsUsrId(JSPUtil.getParameter(request, prefix + "trns_usr_id", ""));
		setTrnsFmDt(JSPUtil.getParameter(request, prefix + "trns_fm_dt", ""));
		setTrnsToUsrId(JSPUtil.getParameter(request, prefix + "trns_to_usr_id", ""));
		setTrnsKnt(JSPUtil.getParameter(request, prefix + "trns_knt", ""));
		setTrnsSeq(JSPUtil.getParameter(request, prefix + "trns_seq", ""));
		setClmTrnsAuthCd(JSPUtil.getParameter(request, prefix + "clm_trns_auth_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTrnsRmk(JSPUtil.getParameter(request, prefix + "trns_rmk", ""));
		setTrnsFmUsrId(JSPUtil.getParameter(request, prefix + "trns_fm_usr_id", ""));
		setTrnsToDt(JSPUtil.getParameter(request, prefix + "trns_to_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTrnsToOfcCd(JSPUtil.getParameter(request, prefix + "trns_to_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setDwClmNo(JSPUtil.getParameter(request, prefix + "dw_clm_no", ""));
		setTrnsOfcCd(JSPUtil.getParameter(request, prefix + "trns_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CniDwTrnsVO[]
	 */
	public CniDwTrnsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CniDwTrnsVO[]
	 */
	public CniDwTrnsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CniDwTrnsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] trnsFmOfcCd = (JSPUtil.getParameter(request, prefix	+ "trns_fm_ofc_cd", length));
			String[] trnsUsrId = (JSPUtil.getParameter(request, prefix	+ "trns_usr_id", length));
			String[] trnsFmDt = (JSPUtil.getParameter(request, prefix	+ "trns_fm_dt", length));
			String[] trnsToUsrId = (JSPUtil.getParameter(request, prefix	+ "trns_to_usr_id", length));
			String[] trnsKnt = (JSPUtil.getParameter(request, prefix	+ "trns_knt", length));
			String[] trnsSeq = (JSPUtil.getParameter(request, prefix	+ "trns_seq", length));
			String[] clmTrnsAuthCd = (JSPUtil.getParameter(request, prefix	+ "clm_trns_auth_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trnsRmk = (JSPUtil.getParameter(request, prefix	+ "trns_rmk", length));
			String[] trnsFmUsrId = (JSPUtil.getParameter(request, prefix	+ "trns_fm_usr_id", length));
			String[] trnsToDt = (JSPUtil.getParameter(request, prefix	+ "trns_to_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] trnsToOfcCd = (JSPUtil.getParameter(request, prefix	+ "trns_to_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] dwClmNo = (JSPUtil.getParameter(request, prefix	+ "dw_clm_no", length));
			String[] trnsOfcCd = (JSPUtil.getParameter(request, prefix	+ "trns_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CniDwTrnsVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (trnsFmOfcCd[i] != null)
					model.setTrnsFmOfcCd(trnsFmOfcCd[i]);
				if (trnsUsrId[i] != null)
					model.setTrnsUsrId(trnsUsrId[i]);
				if (trnsFmDt[i] != null)
					model.setTrnsFmDt(trnsFmDt[i]);
				if (trnsToUsrId[i] != null)
					model.setTrnsToUsrId(trnsToUsrId[i]);
				if (trnsKnt[i] != null)
					model.setTrnsKnt(trnsKnt[i]);
				if (trnsSeq[i] != null)
					model.setTrnsSeq(trnsSeq[i]);
				if (clmTrnsAuthCd[i] != null)
					model.setClmTrnsAuthCd(clmTrnsAuthCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trnsRmk[i] != null)
					model.setTrnsRmk(trnsRmk[i]);
				if (trnsFmUsrId[i] != null)
					model.setTrnsFmUsrId(trnsFmUsrId[i]);
				if (trnsToDt[i] != null)
					model.setTrnsToDt(trnsToDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trnsToOfcCd[i] != null)
					model.setTrnsToOfcCd(trnsToOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (dwClmNo[i] != null)
					model.setDwClmNo(dwClmNo[i]);
				if (trnsOfcCd[i] != null)
					model.setTrnsOfcCd(trnsOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCniDwTrnsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CniDwTrnsVO[]
	 */
	public CniDwTrnsVO[] getCniDwTrnsVOs(){
		CniDwTrnsVO[] vos = (CniDwTrnsVO[])models.toArray(new CniDwTrnsVO[models.size()]);
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
		this.trnsFmOfcCd = this.trnsFmOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsUsrId = this.trnsUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsFmDt = this.trnsFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsToUsrId = this.trnsToUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsKnt = this.trnsKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsSeq = this.trnsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmTrnsAuthCd = this.clmTrnsAuthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsRmk = this.trnsRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsFmUsrId = this.trnsFmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsToDt = this.trnsToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsToOfcCd = this.trnsToOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmNo = this.dwClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsOfcCd = this.trnsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

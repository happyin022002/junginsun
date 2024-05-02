/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VskPortNworkIbisIfVO.java
*@FileTitle : VskPortNworkIbisIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.18  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.vo;

import java.lang.reflect.Field;
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

public class VskPortNworkIbisIfVO extends AbstractValueObject {

private static final long serialVersionUID = 1L;
	
	private Collection<VskPortNworkIbisIfVO> models = new ArrayList<VskPortNworkIbisIfVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ifMnplCd = null;
	/* Column Info */
	private String insfCnqeVal = null;
	/* Column Info */
	private String holRmk = null;
	/* Column Info */
	private String insfDvCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String insfId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String holEndDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String insfDttm = null;
	/* Column Info */
	private String holSeq = null;
	/* Column Info */
	private String insfPrsId = null;
	/* Column Info */
	private String holStDt = null;
	/* Column Info */
	private String holNm = null;
	/* Column Info */
	private String ibisIfSeq = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VskPortNworkIbisIfVO() {}

	public VskPortNworkIbisIfVO(String ibflag, String pagerows, String locCd, String holSeq, String ibisIfSeq, String insfId, String insfPrsId, String insfDttm, String insfCnqeVal, String insfDvCd, String ifMnplCd, String holStDt, String holEndDt, String holNm, String holRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.ifMnplCd = ifMnplCd;
		this.insfCnqeVal = insfCnqeVal;
		this.holRmk = holRmk;
		this.insfDvCd = insfDvCd;
		this.creDt = creDt;
		this.insfId = insfId;
		this.pagerows = pagerows;
		this.holEndDt = holEndDt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.insfDttm = insfDttm;
		this.holSeq = holSeq;
		this.insfPrsId = insfPrsId;
		this.holStDt = holStDt;
		this.holNm = holNm;
		this.ibisIfSeq = ibisIfSeq;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("if_mnpl_cd", getIfMnplCd());
		this.hashColumns.put("insf_cnqe_val", getInsfCnqeVal());
		this.hashColumns.put("hol_rmk", getHolRmk());
		this.hashColumns.put("insf_dv_cd", getInsfDvCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("insf_id", getInsfId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("hol_end_dt", getHolEndDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("insf_dttm", getInsfDttm());
		this.hashColumns.put("hol_seq", getHolSeq());
		this.hashColumns.put("insf_prs_id", getInsfPrsId());
		this.hashColumns.put("hol_st_dt", getHolStDt());
		this.hashColumns.put("hol_nm", getHolNm());
		this.hashColumns.put("ibis_if_seq", getIbisIfSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("if_mnpl_cd", "ifMnplCd");
		this.hashFields.put("insf_cnqe_val", "insfCnqeVal");
		this.hashFields.put("hol_rmk", "holRmk");
		this.hashFields.put("insf_dv_cd", "insfDvCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("insf_id", "insfId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("hol_end_dt", "holEndDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("insf_dttm", "insfDttm");
		this.hashFields.put("hol_seq", "holSeq");
		this.hashFields.put("insf_prs_id", "insfPrsId");
		this.hashFields.put("hol_st_dt", "holStDt");
		this.hashFields.put("hol_nm", "holNm");
		this.hashFields.put("ibis_if_seq", "ibisIfSeq");
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
	 * @return ifMnplCd
	 */
	public String getIfMnplCd() {
		return this.ifMnplCd;
	}
	
	/**
	 * Column Info
	 * @return insfCnqeVal
	 */
	public String getInsfCnqeVal() {
		return this.insfCnqeVal;
	}
	
	/**
	 * Column Info
	 * @return holRmk
	 */
	public String getHolRmk() {
		return this.holRmk;
	}
	
	/**
	 * Column Info
	 * @return insfDvCd
	 */
	public String getInsfDvCd() {
		return this.insfDvCd;
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
	 * @return insfId
	 */
	public String getInsfId() {
		return this.insfId;
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
	 * @return holEndDt
	 */
	public String getHolEndDt() {
		return this.holEndDt;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return insfDttm
	 */
	public String getInsfDttm() {
		return this.insfDttm;
	}
	
	/**
	 * Column Info
	 * @return holSeq
	 */
	public String getHolSeq() {
		return this.holSeq;
	}
	
	/**
	 * Column Info
	 * @return insfPrsId
	 */
	public String getInsfPrsId() {
		return this.insfPrsId;
	}
	
	/**
	 * Column Info
	 * @return holStDt
	 */
	public String getHolStDt() {
		return this.holStDt;
	}
	
	/**
	 * Column Info
	 * @return holNm
	 */
	public String getHolNm() {
		return this.holNm;
	}
	
	/**
	 * Column Info
	 * @return ibisIfSeq
	 */
	public String getIbisIfSeq() {
		return this.ibisIfSeq;
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
	 * @param ifMnplCd
	 */
	public void setIfMnplCd(String ifMnplCd) {
		this.ifMnplCd = ifMnplCd;
	}
	
	/**
	 * Column Info
	 * @param insfCnqeVal
	 */
	public void setInsfCnqeVal(String insfCnqeVal) {
		this.insfCnqeVal = insfCnqeVal;
	}
	
	/**
	 * Column Info
	 * @param holRmk
	 */
	public void setHolRmk(String holRmk) {
		this.holRmk = holRmk;
	}
	
	/**
	 * Column Info
	 * @param insfDvCd
	 */
	public void setInsfDvCd(String insfDvCd) {
		this.insfDvCd = insfDvCd;
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
	 * @param insfId
	 */
	public void setInsfId(String insfId) {
		this.insfId = insfId;
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
	 * @param holEndDt
	 */
	public void setHolEndDt(String holEndDt) {
		this.holEndDt = holEndDt;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param insfDttm
	 */
	public void setInsfDttm(String insfDttm) {
		this.insfDttm = insfDttm;
	}
	
	/**
	 * Column Info
	 * @param holSeq
	 */
	public void setHolSeq(String holSeq) {
		this.holSeq = holSeq;
	}
	
	/**
	 * Column Info
	 * @param insfPrsId
	 */
	public void setInsfPrsId(String insfPrsId) {
		this.insfPrsId = insfPrsId;
	}
	
	/**
	 * Column Info
	 * @param holStDt
	 */
	public void setHolStDt(String holStDt) {
		this.holStDt = holStDt;
	}
	
	/**
	 * Column Info
	 * @param holNm
	 */
	public void setHolNm(String holNm) {
		this.holNm = holNm;
	}
	
	/**
	 * Column Info
	 * @param ibisIfSeq
	 */
	public void setIbisIfSeq(String ibisIfSeq) {
		this.ibisIfSeq = ibisIfSeq;
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
		setIfMnplCd(JSPUtil.getParameter(request, prefix + "if_mnpl_cd", ""));
		setInsfCnqeVal(JSPUtil.getParameter(request, prefix + "insf_cnqe_val", ""));
		setHolRmk(JSPUtil.getParameter(request, prefix + "hol_rmk", ""));
		setInsfDvCd(JSPUtil.getParameter(request, prefix + "insf_dv_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setInsfId(JSPUtil.getParameter(request, prefix + "insf_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setHolEndDt(JSPUtil.getParameter(request, prefix + "hol_end_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setInsfDttm(JSPUtil.getParameter(request, prefix + "insf_dttm", ""));
		setHolSeq(JSPUtil.getParameter(request, prefix + "hol_seq", ""));
		setInsfPrsId(JSPUtil.getParameter(request, prefix + "insf_prs_id", ""));
		setHolStDt(JSPUtil.getParameter(request, prefix + "hol_st_dt", ""));
		setHolNm(JSPUtil.getParameter(request, prefix + "hol_nm", ""));
		setIbisIfSeq(JSPUtil.getParameter(request, prefix + "ibis_if_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VskPortNworkIbisIfVO[]
	 */
	public VskPortNworkIbisIfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VskPortNworkIbisIfVO[]
	 */
	public VskPortNworkIbisIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VskPortNworkIbisIfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ifMnplCd = (JSPUtil.getParameter(request, prefix	+ "if_mnpl_cd", length));
			String[] insfCnqeVal = (JSPUtil.getParameter(request, prefix	+ "insf_cnqe_val", length));
			String[] holRmk = (JSPUtil.getParameter(request, prefix	+ "hol_rmk", length));
			String[] insfDvCd = (JSPUtil.getParameter(request, prefix	+ "insf_dv_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] insfId = (JSPUtil.getParameter(request, prefix	+ "insf_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] holEndDt = (JSPUtil.getParameter(request, prefix	+ "hol_end_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] insfDttm = (JSPUtil.getParameter(request, prefix	+ "insf_dttm", length));
			String[] holSeq = (JSPUtil.getParameter(request, prefix	+ "hol_seq", length));
			String[] insfPrsId = (JSPUtil.getParameter(request, prefix	+ "insf_prs_id", length));
			String[] holStDt = (JSPUtil.getParameter(request, prefix	+ "hol_st_dt", length));
			String[] holNm = (JSPUtil.getParameter(request, prefix	+ "hol_nm", length));
			String[] ibisIfSeq = (JSPUtil.getParameter(request, prefix	+ "ibis_if_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new VskPortNworkIbisIfVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ifMnplCd[i] != null)
					model.setIfMnplCd(ifMnplCd[i]);
				if (insfCnqeVal[i] != null)
					model.setInsfCnqeVal(insfCnqeVal[i]);
				if (holRmk[i] != null)
					model.setHolRmk(holRmk[i]);
				if (insfDvCd[i] != null)
					model.setInsfDvCd(insfDvCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (insfId[i] != null)
					model.setInsfId(insfId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (holEndDt[i] != null)
					model.setHolEndDt(holEndDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (insfDttm[i] != null)
					model.setInsfDttm(insfDttm[i]);
				if (holSeq[i] != null)
					model.setHolSeq(holSeq[i]);
				if (insfPrsId[i] != null)
					model.setInsfPrsId(insfPrsId[i]);
				if (holStDt[i] != null)
					model.setHolStDt(holStDt[i]);
				if (holNm[i] != null)
					model.setHolNm(holNm[i]);
				if (ibisIfSeq[i] != null)
					model.setIbisIfSeq(ibisIfSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVskPortNworkIbisIfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VskPortNworkIbisIfVO[]
	 */
	public VskPortNworkIbisIfVO[] getVskPortNworkIbisIfVOs(){
		VskPortNworkIbisIfVO[] vos = (VskPortNworkIbisIfVO[])models.toArray(new VskPortNworkIbisIfVO[models.size()]);
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
		this.ifMnplCd = this.ifMnplCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insfCnqeVal = this.insfCnqeVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holRmk = this.holRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insfDvCd = this.insfDvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insfId = this.insfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holEndDt = this.holEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insfDttm = this.insfDttm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holSeq = this.holSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insfPrsId = this.insfPrsId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holStDt = this.holStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holNm = this.holNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibisIfSeq = this.ibisIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

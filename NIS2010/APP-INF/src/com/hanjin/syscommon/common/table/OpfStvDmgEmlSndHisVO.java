/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : OpfStvDmgEmlSndHisVO.java
*@FileTitle : OpfStvDmgEmlSndHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.19
*@LastModifier : 
*@LastVersion : 1.0
* 2011.12.19  
* 1.0 Creation
* 2011.12.20 김민아 [CHM-201215700-01] SDMS내 Mail 에러 사항 : CLM_HNDL_USR_NM 추가
=========================================================*/

package com.hanjin.syscommon.common.table;

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

public class OpfStvDmgEmlSndHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OpfStvDmgEmlSndHisVO> models = new ArrayList<OpfStvDmgEmlSndHisVO>();
	
	/* Column Info */
	private String clmHndlUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String emlSndDt = null;
	/* Column Info */
	private String clmHndlUsrNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String emlSndNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String clmHndlOfcNm = null;
	/* Column Info */
	private String clmHndlUsrEml = null;
	/* Column Info */
	private String stvDmgEmlSndSeq = null;
	/* Column Info */
	private String stvDmgProcCd = null;
	/* Column Info */
	private String stvDmgNo = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OpfStvDmgEmlSndHisVO() {}

	public OpfStvDmgEmlSndHisVO(String ibflag, String pagerows, String stvDmgNo, String stvDmgProcCd, String stvDmgEmlSndSeq, String clmHndlUsrId, String clmHndlUsrEml, String emlSndNo, String emlSndDt, String creUsrId, String creDt, String updUsrId, String updDt, String clmHndlOfcNm, String clmHndlUsrNm) {
		this.clmHndlUsrId = clmHndlUsrId;
		this.updDt = updDt;
		this.emlSndDt = emlSndDt;
		this.clmHndlUsrNm = clmHndlUsrNm;
		this.creDt = creDt;
		this.emlSndNo = emlSndNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.clmHndlOfcNm = clmHndlOfcNm;
		this.clmHndlUsrEml = clmHndlUsrEml;
		this.stvDmgEmlSndSeq = stvDmgEmlSndSeq;
		this.stvDmgProcCd = stvDmgProcCd;
		this.stvDmgNo = stvDmgNo;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("clm_hndl_usr_id", getClmHndlUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("eml_snd_dt", getEmlSndDt());
		this.hashColumns.put("clm_hndl_usr_nm", getClmHndlUsrNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("eml_snd_no", getEmlSndNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("clm_hndl_ofc_nm", getClmHndlOfcNm());
		this.hashColumns.put("clm_hndl_usr_eml", getClmHndlUsrEml());
		this.hashColumns.put("stv_dmg_eml_snd_seq", getStvDmgEmlSndSeq());
		this.hashColumns.put("stv_dmg_proc_cd", getStvDmgProcCd());
		this.hashColumns.put("stv_dmg_no", getStvDmgNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("clm_hndl_usr_id", "clmHndlUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("eml_snd_dt", "emlSndDt");
		this.hashFields.put("clm_hndl_usr_nm", "clmHndlUsrNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eml_snd_no", "emlSndNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("clm_hndl_ofc_nm", "clmHndlOfcNm");
		this.hashFields.put("clm_hndl_usr_eml", "clmHndlUsrEml");
		this.hashFields.put("stv_dmg_eml_snd_seq", "stvDmgEmlSndSeq");
		this.hashFields.put("stv_dmg_proc_cd", "stvDmgProcCd");
		this.hashFields.put("stv_dmg_no", "stvDmgNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return clmHndlUsrId
	 */
	public String getClmHndlUsrId() {
		return this.clmHndlUsrId;
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
	 * @return emlSndDt
	 */
	public String getEmlSndDt() {
		return this.emlSndDt;
	}
	
	/**
	 * Column Info
	 * @return clmHndlUsrNm
	 */
	public String getClmHndlUsrNm() {
		return this.clmHndlUsrNm;
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
	 * @return emlSndNo
	 */
	public String getEmlSndNo() {
		return this.emlSndNo;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return clmHndlOfcNm
	 */
	public String getClmHndlOfcNm() {
		return this.clmHndlOfcNm;
	}
	
	/**
	 * Column Info
	 * @return clmHndlUsrEml
	 */
	public String getClmHndlUsrEml() {
		return this.clmHndlUsrEml;
	}
	
	/**
	 * Column Info
	 * @return stvDmgEmlSndSeq
	 */
	public String getStvDmgEmlSndSeq() {
		return this.stvDmgEmlSndSeq;
	}
	
	/**
	 * Column Info
	 * @return stvDmgProcCd
	 */
	public String getStvDmgProcCd() {
		return this.stvDmgProcCd;
	}
	
	/**
	 * Column Info
	 * @return stvDmgNo
	 */
	public String getStvDmgNo() {
		return this.stvDmgNo;
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
	 * @param clmHndlUsrId
	 */
	public void setClmHndlUsrId(String clmHndlUsrId) {
		this.clmHndlUsrId = clmHndlUsrId;
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
	 * @param emlSndDt
	 */
	public void setEmlSndDt(String emlSndDt) {
		this.emlSndDt = emlSndDt;
	}
	
	/**
	 * Column Info
	 * @param clmHndlUsrNm
	 */
	public void setClmHndlUsrNm(String clmHndlUsrNm) {
		this.clmHndlUsrNm = clmHndlUsrNm;
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
	 * @param emlSndNo
	 */
	public void setEmlSndNo(String emlSndNo) {
		this.emlSndNo = emlSndNo;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param clmHndlOfcNm
	 */
	public void setClmHndlOfcNm(String clmHndlOfcNm) {
		this.clmHndlOfcNm = clmHndlOfcNm;
	}
	
	/**
	 * Column Info
	 * @param clmHndlUsrEml
	 */
	public void setClmHndlUsrEml(String clmHndlUsrEml) {
		this.clmHndlUsrEml = clmHndlUsrEml;
	}
	
	/**
	 * Column Info
	 * @param stvDmgEmlSndSeq
	 */
	public void setStvDmgEmlSndSeq(String stvDmgEmlSndSeq) {
		this.stvDmgEmlSndSeq = stvDmgEmlSndSeq;
	}
	
	/**
	 * Column Info
	 * @param stvDmgProcCd
	 */
	public void setStvDmgProcCd(String stvDmgProcCd) {
		this.stvDmgProcCd = stvDmgProcCd;
	}
	
	/**
	 * Column Info
	 * @param stvDmgNo
	 */
	public void setStvDmgNo(String stvDmgNo) {
		this.stvDmgNo = stvDmgNo;
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
		setClmHndlUsrId(JSPUtil.getParameter(request, prefix + "clm_hndl_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setEmlSndDt(JSPUtil.getParameter(request, prefix + "eml_snd_dt", ""));
		setClmHndlUsrNm(JSPUtil.getParameter(request, prefix + "clm_hndl_usr_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEmlSndNo(JSPUtil.getParameter(request, prefix + "eml_snd_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setClmHndlOfcNm(JSPUtil.getParameter(request, prefix + "clm_hndl_ofc_nm", ""));
		setClmHndlUsrEml(JSPUtil.getParameter(request, prefix + "clm_hndl_usr_eml", ""));
		setStvDmgEmlSndSeq(JSPUtil.getParameter(request, prefix + "stv_dmg_eml_snd_seq", ""));
		setStvDmgProcCd(JSPUtil.getParameter(request, prefix + "stv_dmg_proc_cd", ""));
		setStvDmgNo(JSPUtil.getParameter(request, prefix + "stv_dmg_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OpfStvDmgEmlSndHisVO[]
	 */
	public OpfStvDmgEmlSndHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OpfStvDmgEmlSndHisVO[]
	 */
	public OpfStvDmgEmlSndHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OpfStvDmgEmlSndHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] clmHndlUsrId = (JSPUtil.getParameter(request, prefix	+ "clm_hndl_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] emlSndDt = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dt", length));
			String[] clmHndlUsrNm = (JSPUtil.getParameter(request, prefix	+ "clm_hndl_usr_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] emlSndNo = (JSPUtil.getParameter(request, prefix	+ "eml_snd_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] clmHndlOfcNm = (JSPUtil.getParameter(request, prefix	+ "clm_hndl_ofc_nm", length));
			String[] clmHndlUsrEml = (JSPUtil.getParameter(request, prefix	+ "clm_hndl_usr_eml", length));
			String[] stvDmgEmlSndSeq = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_eml_snd_seq", length));
			String[] stvDmgProcCd = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_proc_cd", length));
			String[] stvDmgNo = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new OpfStvDmgEmlSndHisVO();
				if (clmHndlUsrId[i] != null)
					model.setClmHndlUsrId(clmHndlUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (emlSndDt[i] != null)
					model.setEmlSndDt(emlSndDt[i]);
				if (clmHndlUsrNm[i] != null)
					model.setClmHndlUsrNm(clmHndlUsrNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (emlSndNo[i] != null)
					model.setEmlSndNo(emlSndNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (clmHndlOfcNm[i] != null)
					model.setClmHndlOfcNm(clmHndlOfcNm[i]);
				if (clmHndlUsrEml[i] != null)
					model.setClmHndlUsrEml(clmHndlUsrEml[i]);
				if (stvDmgEmlSndSeq[i] != null)
					model.setStvDmgEmlSndSeq(stvDmgEmlSndSeq[i]);
				if (stvDmgProcCd[i] != null)
					model.setStvDmgProcCd(stvDmgProcCd[i]);
				if (stvDmgNo[i] != null)
					model.setStvDmgNo(stvDmgNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOpfStvDmgEmlSndHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OpfStvDmgEmlSndHisVO[]
	 */
	public OpfStvDmgEmlSndHisVO[] getOpfStvDmgEmlSndHisVOs(){
		OpfStvDmgEmlSndHisVO[] vos = (OpfStvDmgEmlSndHisVO[])models.toArray(new OpfStvDmgEmlSndHisVO[models.size()]);
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
		this.clmHndlUsrId = this.clmHndlUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDt = this.emlSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmHndlUsrNm = this.clmHndlUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndNo = this.emlSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmHndlOfcNm = this.clmHndlOfcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmHndlUsrEml = this.clmHndlUsrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgEmlSndSeq = this.stvDmgEmlSndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgProcCd = this.stvDmgProcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgNo = this.stvDmgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

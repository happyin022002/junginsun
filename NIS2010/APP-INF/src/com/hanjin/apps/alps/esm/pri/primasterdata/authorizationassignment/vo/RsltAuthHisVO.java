/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RsltAuthHisVO.java
*@FileTitle : RsltAuthHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.29  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo;

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

public class RsltAuthHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltAuthHisVO> models = new ArrayList<RsltAuthHisVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String progGdt = null;
	/* Column Info */
	private String authAproUseFlg = null;
	/* Column Info */
	private String progUsrId = null;
	/* Column Info */
	private String prcUsrAuthTpCd = null;
	/* Column Info */
	private String authAproUsrNm = null;
	/* Column Info */
	private String authAproOfcCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String authAproOfcNm = null;
	/* Column Info */
	private String authAproDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String prcOfcAuthTpCd = null;
	/* Column Info */
	private String authAproUsrOfcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String progOfcCd = null;
	/* Column Info */
	private String progUsrNm = null;
	/* Column Info */
	private String authAproUsrId = null;
	/* Column Info */
	private String authAproHisSeq = null;
	/* Column Info */
	private String prcCtrtTpCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RsltAuthHisVO() {}

	public RsltAuthHisVO(String ibflag, String pagerows, String authAproHisSeq, String prcCtrtTpCd, String prcUsrAuthTpCd, String prcOfcAuthTpCd, String authAproUsrId, String authAproUsrNm, String authAproUsrOfcCd, String authAproOfcCd, String authAproOfcNm, String authAproDesc, String authAproUseFlg, String progUsrId, String progUsrNm, String progOfcCd, String progGdt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.progGdt = progGdt;
		this.authAproUseFlg = authAproUseFlg;
		this.progUsrId = progUsrId;
		this.prcUsrAuthTpCd = prcUsrAuthTpCd;
		this.authAproUsrNm = authAproUsrNm;
		this.authAproOfcCd = authAproOfcCd;
		this.creDt = creDt;
		this.authAproOfcNm = authAproOfcNm;
		this.authAproDesc = authAproDesc;
		this.pagerows = pagerows;
		this.prcOfcAuthTpCd = prcOfcAuthTpCd;
		this.authAproUsrOfcCd = authAproUsrOfcCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.progOfcCd = progOfcCd;
		this.progUsrNm = progUsrNm;
		this.authAproUsrId = authAproUsrId;
		this.authAproHisSeq = authAproHisSeq;
		this.prcCtrtTpCd = prcCtrtTpCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("prog_gdt", getProgGdt());
		this.hashColumns.put("auth_apro_use_flg", getAuthAproUseFlg());
		this.hashColumns.put("prog_usr_id", getProgUsrId());
		this.hashColumns.put("prc_usr_auth_tp_cd", getPrcUsrAuthTpCd());
		this.hashColumns.put("auth_apro_usr_nm", getAuthAproUsrNm());
		this.hashColumns.put("auth_apro_ofc_cd", getAuthAproOfcCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("auth_apro_ofc_nm", getAuthAproOfcNm());
		this.hashColumns.put("auth_apro_desc", getAuthAproDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("prc_ofc_auth_tp_cd", getPrcOfcAuthTpCd());
		this.hashColumns.put("auth_apro_usr_ofc_cd", getAuthAproUsrOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("prog_ofc_cd", getProgOfcCd());
		this.hashColumns.put("prog_usr_nm", getProgUsrNm());
		this.hashColumns.put("auth_apro_usr_id", getAuthAproUsrId());
		this.hashColumns.put("auth_apro_his_seq", getAuthAproHisSeq());
		this.hashColumns.put("prc_ctrt_tp_cd", getPrcCtrtTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("prog_gdt", "progGdt");
		this.hashFields.put("auth_apro_use_flg", "authAproUseFlg");
		this.hashFields.put("prog_usr_id", "progUsrId");
		this.hashFields.put("prc_usr_auth_tp_cd", "prcUsrAuthTpCd");
		this.hashFields.put("auth_apro_usr_nm", "authAproUsrNm");
		this.hashFields.put("auth_apro_ofc_cd", "authAproOfcCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("auth_apro_ofc_nm", "authAproOfcNm");
		this.hashFields.put("auth_apro_desc", "authAproDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prc_ofc_auth_tp_cd", "prcOfcAuthTpCd");
		this.hashFields.put("auth_apro_usr_ofc_cd", "authAproUsrOfcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prog_ofc_cd", "progOfcCd");
		this.hashFields.put("prog_usr_nm", "progUsrNm");
		this.hashFields.put("auth_apro_usr_id", "authAproUsrId");
		this.hashFields.put("auth_apro_his_seq", "authAproHisSeq");
		this.hashFields.put("prc_ctrt_tp_cd", "prcCtrtTpCd");
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
	 * @return progGdt
	 */
	public String getProgGdt() {
		return this.progGdt;
	}
	
	/**
	 * Column Info
	 * @return authAproUseFlg
	 */
	public String getAuthAproUseFlg() {
		return this.authAproUseFlg;
	}
	
	/**
	 * Column Info
	 * @return progUsrId
	 */
	public String getProgUsrId() {
		return this.progUsrId;
	}
	
	/**
	 * Column Info
	 * @return prcUsrAuthTpCd
	 */
	public String getPrcUsrAuthTpCd() {
		return this.prcUsrAuthTpCd;
	}
	
	/**
	 * Column Info
	 * @return authAproUsrNm
	 */
	public String getAuthAproUsrNm() {
		return this.authAproUsrNm;
	}
	
	/**
	 * Column Info
	 * @return authAproOfcCd
	 */
	public String getAuthAproOfcCd() {
		return this.authAproOfcCd;
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
	 * @return authAproOfcNm
	 */
	public String getAuthAproOfcNm() {
		return this.authAproOfcNm;
	}
	
	/**
	 * Column Info
	 * @return authAproDesc
	 */
	public String getAuthAproDesc() {
		return this.authAproDesc;
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
	 * @return prcOfcAuthTpCd
	 */
	public String getPrcOfcAuthTpCd() {
		return this.prcOfcAuthTpCd;
	}
	
	/**
	 * Column Info
	 * @return authAproUsrOfcCd
	 */
	public String getAuthAproUsrOfcCd() {
		return this.authAproUsrOfcCd;
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
	 * @return progOfcCd
	 */
	public String getProgOfcCd() {
		return this.progOfcCd;
	}
	
	/**
	 * Column Info
	 * @return progUsrNm
	 */
	public String getProgUsrNm() {
		return this.progUsrNm;
	}
	
	/**
	 * Column Info
	 * @return authAproUsrId
	 */
	public String getAuthAproUsrId() {
		return this.authAproUsrId;
	}
	
	/**
	 * Column Info
	 * @return authAproHisSeq
	 */
	public String getAuthAproHisSeq() {
		return this.authAproHisSeq;
	}
	
	/**
	 * Column Info
	 * @return prcCtrtTpCd
	 */
	public String getPrcCtrtTpCd() {
		return this.prcCtrtTpCd;
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
	 * @param progGdt
	 */
	public void setProgGdt(String progGdt) {
		this.progGdt = progGdt;
	}
	
	/**
	 * Column Info
	 * @param authAproUseFlg
	 */
	public void setAuthAproUseFlg(String authAproUseFlg) {
		this.authAproUseFlg = authAproUseFlg;
	}
	
	/**
	 * Column Info
	 * @param progUsrId
	 */
	public void setProgUsrId(String progUsrId) {
		this.progUsrId = progUsrId;
	}
	
	/**
	 * Column Info
	 * @param prcUsrAuthTpCd
	 */
	public void setPrcUsrAuthTpCd(String prcUsrAuthTpCd) {
		this.prcUsrAuthTpCd = prcUsrAuthTpCd;
	}
	
	/**
	 * Column Info
	 * @param authAproUsrNm
	 */
	public void setAuthAproUsrNm(String authAproUsrNm) {
		this.authAproUsrNm = authAproUsrNm;
	}
	
	/**
	 * Column Info
	 * @param authAproOfcCd
	 */
	public void setAuthAproOfcCd(String authAproOfcCd) {
		this.authAproOfcCd = authAproOfcCd;
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
	 * @param authAproOfcNm
	 */
	public void setAuthAproOfcNm(String authAproOfcNm) {
		this.authAproOfcNm = authAproOfcNm;
	}
	
	/**
	 * Column Info
	 * @param authAproDesc
	 */
	public void setAuthAproDesc(String authAproDesc) {
		this.authAproDesc = authAproDesc;
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
	 * @param prcOfcAuthTpCd
	 */
	public void setPrcOfcAuthTpCd(String prcOfcAuthTpCd) {
		this.prcOfcAuthTpCd = prcOfcAuthTpCd;
	}
	
	/**
	 * Column Info
	 * @param authAproUsrOfcCd
	 */
	public void setAuthAproUsrOfcCd(String authAproUsrOfcCd) {
		this.authAproUsrOfcCd = authAproUsrOfcCd;
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
	 * @param progOfcCd
	 */
	public void setProgOfcCd(String progOfcCd) {
		this.progOfcCd = progOfcCd;
	}
	
	/**
	 * Column Info
	 * @param progUsrNm
	 */
	public void setProgUsrNm(String progUsrNm) {
		this.progUsrNm = progUsrNm;
	}
	
	/**
	 * Column Info
	 * @param authAproUsrId
	 */
	public void setAuthAproUsrId(String authAproUsrId) {
		this.authAproUsrId = authAproUsrId;
	}
	
	/**
	 * Column Info
	 * @param authAproHisSeq
	 */
	public void setAuthAproHisSeq(String authAproHisSeq) {
		this.authAproHisSeq = authAproHisSeq;
	}
	
	/**
	 * Column Info
	 * @param prcCtrtTpCd
	 */
	public void setPrcCtrtTpCd(String prcCtrtTpCd) {
		this.prcCtrtTpCd = prcCtrtTpCd;
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
		setProgGdt(JSPUtil.getParameter(request, prefix + "prog_gdt", ""));
		setAuthAproUseFlg(JSPUtil.getParameter(request, prefix + "auth_apro_use_flg", ""));
		setProgUsrId(JSPUtil.getParameter(request, prefix + "prog_usr_id", ""));
		setPrcUsrAuthTpCd(JSPUtil.getParameter(request, prefix + "prc_usr_auth_tp_cd", ""));
		setAuthAproUsrNm(JSPUtil.getParameter(request, prefix + "auth_apro_usr_nm", ""));
		setAuthAproOfcCd(JSPUtil.getParameter(request, prefix + "auth_apro_ofc_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setAuthAproOfcNm(JSPUtil.getParameter(request, prefix + "auth_apro_ofc_nm", ""));
		setAuthAproDesc(JSPUtil.getParameter(request, prefix + "auth_apro_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPrcOfcAuthTpCd(JSPUtil.getParameter(request, prefix + "prc_ofc_auth_tp_cd", ""));
		setAuthAproUsrOfcCd(JSPUtil.getParameter(request, prefix + "auth_apro_usr_ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setProgOfcCd(JSPUtil.getParameter(request, prefix + "prog_ofc_cd", ""));
		setProgUsrNm(JSPUtil.getParameter(request, prefix + "prog_usr_nm", ""));
		setAuthAproUsrId(JSPUtil.getParameter(request, prefix + "auth_apro_usr_id", ""));
		setAuthAproHisSeq(JSPUtil.getParameter(request, prefix + "auth_apro_his_seq", ""));
		setPrcCtrtTpCd(JSPUtil.getParameter(request, prefix + "prc_ctrt_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltAuthHisVO[]
	 */
	public RsltAuthHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltAuthHisVO[]
	 */
	public RsltAuthHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltAuthHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] progGdt = (JSPUtil.getParameter(request, prefix	+ "prog_gdt", length));
			String[] authAproUseFlg = (JSPUtil.getParameter(request, prefix	+ "auth_apro_use_flg", length));
			String[] progUsrId = (JSPUtil.getParameter(request, prefix	+ "prog_usr_id", length));
			String[] prcUsrAuthTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_usr_auth_tp_cd", length));
			String[] authAproUsrNm = (JSPUtil.getParameter(request, prefix	+ "auth_apro_usr_nm", length));
			String[] authAproOfcCd = (JSPUtil.getParameter(request, prefix	+ "auth_apro_ofc_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] authAproOfcNm = (JSPUtil.getParameter(request, prefix	+ "auth_apro_ofc_nm", length));
			String[] authAproDesc = (JSPUtil.getParameter(request, prefix	+ "auth_apro_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] prcOfcAuthTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_ofc_auth_tp_cd", length));
			String[] authAproUsrOfcCd = (JSPUtil.getParameter(request, prefix	+ "auth_apro_usr_ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] progOfcCd = (JSPUtil.getParameter(request, prefix	+ "prog_ofc_cd", length));
			String[] progUsrNm = (JSPUtil.getParameter(request, prefix	+ "prog_usr_nm", length));
			String[] authAproUsrId = (JSPUtil.getParameter(request, prefix	+ "auth_apro_usr_id", length));
			String[] authAproHisSeq = (JSPUtil.getParameter(request, prefix	+ "auth_apro_his_seq", length));
			String[] prcCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltAuthHisVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (progGdt[i] != null)
					model.setProgGdt(progGdt[i]);
				if (authAproUseFlg[i] != null)
					model.setAuthAproUseFlg(authAproUseFlg[i]);
				if (progUsrId[i] != null)
					model.setProgUsrId(progUsrId[i]);
				if (prcUsrAuthTpCd[i] != null)
					model.setPrcUsrAuthTpCd(prcUsrAuthTpCd[i]);
				if (authAproUsrNm[i] != null)
					model.setAuthAproUsrNm(authAproUsrNm[i]);
				if (authAproOfcCd[i] != null)
					model.setAuthAproOfcCd(authAproOfcCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (authAproOfcNm[i] != null)
					model.setAuthAproOfcNm(authAproOfcNm[i]);
				if (authAproDesc[i] != null)
					model.setAuthAproDesc(authAproDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (prcOfcAuthTpCd[i] != null)
					model.setPrcOfcAuthTpCd(prcOfcAuthTpCd[i]);
				if (authAproUsrOfcCd[i] != null)
					model.setAuthAproUsrOfcCd(authAproUsrOfcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (progOfcCd[i] != null)
					model.setProgOfcCd(progOfcCd[i]);
				if (progUsrNm[i] != null)
					model.setProgUsrNm(progUsrNm[i]);
				if (authAproUsrId[i] != null)
					model.setAuthAproUsrId(authAproUsrId[i]);
				if (authAproHisSeq[i] != null)
					model.setAuthAproHisSeq(authAproHisSeq[i]);
				if (prcCtrtTpCd[i] != null)
					model.setPrcCtrtTpCd(prcCtrtTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltAuthHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltAuthHisVO[]
	 */
	public RsltAuthHisVO[] getRsltAuthHisVOs(){
		RsltAuthHisVO[] vos = (RsltAuthHisVO[])models.toArray(new RsltAuthHisVO[models.size()]);
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
		this.progGdt = this.progGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproUseFlg = this.authAproUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progUsrId = this.progUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcUsrAuthTpCd = this.prcUsrAuthTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproUsrNm = this.authAproUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproOfcCd = this.authAproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproOfcNm = this.authAproOfcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproDesc = this.authAproDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcOfcAuthTpCd = this.prcOfcAuthTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproUsrOfcCd = this.authAproUsrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progOfcCd = this.progOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progUsrNm = this.progUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproUsrId = this.authAproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproHisSeq = this.authAproHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtTpCd = this.prcCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

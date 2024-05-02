/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomsSetupVO.java
*@FileTitle : CustomsSetupVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.28
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.09.28 박성진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomsSetupVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomsSetupVO> models = new ArrayList<CustomsSetupVO>();
	
	/* Column Info */
	private String svcExsYn = null;
	/* Column Info */
	private String svcDrYn = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String tmlCd = null;
	/* Column Info */
	private String customsCd = null;
	/* Column Info */
	private String customsNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String portNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctTel = null;
	/* Column Info */
	private String svcAnYn = null;
	/* Column Info */
	private String pPort = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String ctPosition = null;
	/* Column Info */
	private String portsCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ctName = null;
	/* Column Info */
	private String pCstmsCd = null;
	/* Column Info */
	private String ctFax = null;
	/* Column Info */
	private String tmlsCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String n1stEurPortFlg = null;
	/* Column Info */
	private String svcEnsYn = null;
	/* Column Info */
	private String pCntCd = null;
	/* Column Info */
	private String pTml = null;
	/* Column Info */
	private String ctEmail = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomsSetupVO() {}

	public CustomsSetupVO(String ibflag, String pagerows, String pCntCd, String pPort, String pTml, String pCstmsCd, String portCd, String portNm, String portsCd, String tmlCd, String tmlsCd, String cntCd, String ydCd, String n1stEurPortFlg, String customsCd, String customsNm, String creUsrId, String creDt, String updUsrId, String updDt, String svcExsYn, String svcEnsYn, String svcAnYn, String svcDrYn, String ctName, String ctPosition, String ctEmail, String ctTel, String ctFax) {
		this.svcExsYn = svcExsYn;
		this.svcDrYn = svcDrYn;
		this.creDt = creDt;
		this.tmlCd = tmlCd;
		this.customsCd = customsCd;
		this.customsNm = customsNm;
		this.pagerows = pagerows;
		this.portNm = portNm;
		this.ibflag = ibflag;
		this.ctTel = ctTel;
		this.svcAnYn = svcAnYn;
		this.pPort = pPort;
		this.cntCd = cntCd;
		this.portCd = portCd;
		this.ctPosition = ctPosition;
		this.portsCd = portsCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.ctName = ctName;
		this.pCstmsCd = pCstmsCd;
		this.ctFax = ctFax;
		this.tmlsCd = tmlsCd;
		this.creUsrId = creUsrId;
		this.ydCd = ydCd;
		this.n1stEurPortFlg = n1stEurPortFlg;
		this.svcEnsYn = svcEnsYn;
		this.pCntCd = pCntCd;
		this.pTml = pTml;
		this.ctEmail = ctEmail;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("svc_exs_yn", getSvcExsYn());
		this.hashColumns.put("svc_dr_yn", getSvcDrYn());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("tml_cd", getTmlCd());
		this.hashColumns.put("customs_cd", getCustomsCd());
		this.hashColumns.put("customs_nm", getCustomsNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("port_nm", getPortNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ct_tel", getCtTel());
		this.hashColumns.put("svc_an_yn", getSvcAnYn());
		this.hashColumns.put("p_port", getPPort());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("ct_position", getCtPosition());
		this.hashColumns.put("ports_cd", getPortsCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ct_name", getCtName());
		this.hashColumns.put("p_cstms_cd", getPCstmsCd());
		this.hashColumns.put("ct_fax", getCtFax());
		this.hashColumns.put("tmls_cd", getTmlsCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("n1st_eur_port_flg", getN1stEurPortFlg());
		this.hashColumns.put("svc_ens_yn", getSvcEnsYn());
		this.hashColumns.put("p_cnt_cd", getPCntCd());
		this.hashColumns.put("p_tml", getPTml());
		this.hashColumns.put("ct_email", getCtEmail());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("svc_exs_yn", "svcExsYn");
		this.hashFields.put("svc_dr_yn", "svcDrYn");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("tml_cd", "tmlCd");
		this.hashFields.put("customs_cd", "customsCd");
		this.hashFields.put("customs_nm", "customsNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("port_nm", "portNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ct_tel", "ctTel");
		this.hashFields.put("svc_an_yn", "svcAnYn");
		this.hashFields.put("p_port", "pPort");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("ct_position", "ctPosition");
		this.hashFields.put("ports_cd", "portsCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ct_name", "ctName");
		this.hashFields.put("p_cstms_cd", "pCstmsCd");
		this.hashFields.put("ct_fax", "ctFax");
		this.hashFields.put("tmls_cd", "tmlsCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("n1st_eur_port_flg", "n1stEurPortFlg");
		this.hashFields.put("svc_ens_yn", "svcEnsYn");
		this.hashFields.put("p_cnt_cd", "pCntCd");
		this.hashFields.put("p_tml", "pTml");
		this.hashFields.put("ct_email", "ctEmail");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return svcExsYn
	 */
	public String getSvcExsYn() {
		return this.svcExsYn;
	}
	
	/**
	 * Column Info
	 * @return svcDrYn
	 */
	public String getSvcDrYn() {
		return this.svcDrYn;
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
	 * @return tmlCd
	 */
	public String getTmlCd() {
		return this.tmlCd;
	}
	
	/**
	 * Column Info
	 * @return customsCd
	 */
	public String getCustomsCd() {
		return this.customsCd;
	}

	/**
	 * Column Info
	 * @return customsNm
	 */
	public String getCustomsNm() {
		return this.customsNm;
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
	 * @return portNm
	 */
	public String getPortNm() {
		return this.portNm;
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
	 * @return ctTel
	 */
	public String getCtTel() {
		return this.ctTel;
	}
	
	/**
	 * Column Info
	 * @return svcAnYn
	 */
	public String getSvcAnYn() {
		return this.svcAnYn;
	}
	
	/**
	 * Column Info
	 * @return pPort
	 */
	public String getPPort() {
		return this.pPort;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return ctPosition
	 */
	public String getCtPosition() {
		return this.ctPosition;
	}
	
	/**
	 * Column Info
	 * @return portsCd
	 */
	public String getPortsCd() {
		return this.portsCd;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return ctName
	 */
	public String getCtName() {
		return this.ctName;
	}
	
	/**
	 * Column Info
	 * @return pCstmsCd
	 */
	public String getPCstmsCd() {
		return this.pCstmsCd;
	}
	
	/**
	 * Column Info
	 * @return ctFax
	 */
	public String getCtFax() {
		return this.ctFax;
	}
	
	/**
	 * Column Info
	 * @return tmlsCd
	 */
	public String getTmlsCd() {
		return this.tmlsCd;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return n1stEurPortFlg
	 */
	public String getN1stEurPortFlg() {
		return this.n1stEurPortFlg;
	}
	
	/**
	 * Column Info
	 * @return svcEnsYn
	 */
	public String getSvcEnsYn() {
		return this.svcEnsYn;
	}
	
	/**
	 * Column Info
	 * @return pCntCd
	 */
	public String getPCntCd() {
		return this.pCntCd;
	}
	
	/**
	 * Column Info
	 * @return pTml
	 */
	public String getPTml() {
		return this.pTml;
	}
	
	/**
	 * Column Info
	 * @return ctEmail
	 */
	public String getCtEmail() {
		return this.ctEmail;
	}
	

	/**
	 * Column Info
	 * @param svcExsYn
	 */
	public void setSvcExsYn(String svcExsYn) {
		this.svcExsYn = svcExsYn;
	}
	
	/**
	 * Column Info
	 * @param svcDrYn
	 */
	public void setSvcDrYn(String svcDrYn) {
		this.svcDrYn = svcDrYn;
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
	 * @param tmlCd
	 */
	public void setTmlCd(String tmlCd) {
		this.tmlCd = tmlCd;
	}
	
	/**
	 * Column Info
	 * @param customsCd
	 */
	public void setCustomsCd(String customsCd) {
		this.customsCd = customsCd;
	}

	/**
	 * Column Info
	 * @param customsNm
	 */
	public void setCustomsNm(String customsNm) {
		this.customsNm = customsNm;
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
	 * @param portNm
	 */
	public void setPortNm(String portNm) {
		this.portNm = portNm;
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
	 * @param ctTel
	 */
	public void setCtTel(String ctTel) {
		this.ctTel = ctTel;
	}
	
	/**
	 * Column Info
	 * @param svcAnYn
	 */
	public void setSvcAnYn(String svcAnYn) {
		this.svcAnYn = svcAnYn;
	}
	
	/**
	 * Column Info
	 * @param pPort
	 */
	public void setPPort(String pPort) {
		this.pPort = pPort;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param ctPosition
	 */
	public void setCtPosition(String ctPosition) {
		this.ctPosition = ctPosition;
	}
	
	/**
	 * Column Info
	 * @param portsCd
	 */
	public void setPortsCd(String portsCd) {
		this.portsCd = portsCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param ctName
	 */
	public void setCtName(String ctName) {
		this.ctName = ctName;
	}
	
	/**
	 * Column Info
	 * @param pCstmsCd
	 */
	public void setPCstmsCd(String pCstmsCd) {
		this.pCstmsCd = pCstmsCd;
	}
	
	/**
	 * Column Info
	 * @param ctFax
	 */
	public void setCtFax(String ctFax) {
		this.ctFax = ctFax;
	}
	
	/**
	 * Column Info
	 * @param tmlsCd
	 */
	public void setTmlsCd(String tmlsCd) {
		this.tmlsCd = tmlsCd;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param n1stEurPortFlg
	 */
	public void setN1stEurPortFlg(String n1stEurPortFlg) {
		this.n1stEurPortFlg = n1stEurPortFlg;
	}
	
	/**
	 * Column Info
	 * @param svcEnsYn
	 */
	public void setSvcEnsYn(String svcEnsYn) {
		this.svcEnsYn = svcEnsYn;
	}
	
	/**
	 * Column Info
	 * @param pCntCd
	 */
	public void setPCntCd(String pCntCd) {
		this.pCntCd = pCntCd;
	}
	
	/**
	 * Column Info
	 * @param pTml
	 */
	public void setPTml(String pTml) {
		this.pTml = pTml;
	}
	
	/**
	 * Column Info
	 * @param ctEmail
	 */
	public void setCtEmail(String ctEmail) {
		this.ctEmail = ctEmail;
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
		setSvcExsYn(JSPUtil.getParameter(request, prefix + "svc_exs_yn", ""));
		setSvcDrYn(JSPUtil.getParameter(request, prefix + "svc_dr_yn", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTmlCd(JSPUtil.getParameter(request, prefix + "tml_cd", ""));
		setCustomsCd(JSPUtil.getParameter(request, prefix + "customs_cd", ""));
		setCustomsNm(JSPUtil.getParameter(request, prefix + "customs_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPortNm(JSPUtil.getParameter(request, prefix + "port_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCtTel(JSPUtil.getParameter(request, prefix + "ct_tel", ""));
		setSvcAnYn(JSPUtil.getParameter(request, prefix + "svc_an_yn", ""));
		setPPort(JSPUtil.getParameter(request, prefix + "p_port", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setCtPosition(JSPUtil.getParameter(request, prefix + "ct_position", ""));
		setPortsCd(JSPUtil.getParameter(request, prefix + "ports_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCtName(JSPUtil.getParameter(request, prefix + "ct_name", ""));
		setPCstmsCd(JSPUtil.getParameter(request, prefix + "p_cstms_cd", ""));
		setCtFax(JSPUtil.getParameter(request, prefix + "ct_fax", ""));
		setTmlsCd(JSPUtil.getParameter(request, prefix + "tmls_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setN1stEurPortFlg(JSPUtil.getParameter(request, prefix + "n1st_eur_port_flg", ""));
		setSvcEnsYn(JSPUtil.getParameter(request, prefix + "svc_ens_yn", ""));
		setPCntCd(JSPUtil.getParameter(request, prefix + "p_cnt_cd", ""));
		setPTml(JSPUtil.getParameter(request, prefix + "p_tml", ""));
		setCtEmail(JSPUtil.getParameter(request, prefix + "ct_email", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomsSetupVO[]
	 */
	public CustomsSetupVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomsSetupVO[]
	 */
	public CustomsSetupVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomsSetupVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] svcExsYn = (JSPUtil.getParameter(request, prefix	+ "svc_exs_yn", length));
			String[] svcDrYn = (JSPUtil.getParameter(request, prefix	+ "svc_dr_yn", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] tmlCd = (JSPUtil.getParameter(request, prefix	+ "tml_cd", length));
			String[] customsCd = (JSPUtil.getParameter(request, prefix	+ "customs_cd", length));
			String[] customsNm = (JSPUtil.getParameter(request, prefix	+ "customs_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] portNm = (JSPUtil.getParameter(request, prefix	+ "port_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctTel = (JSPUtil.getParameter(request, prefix	+ "ct_tel", length));
			String[] svcAnYn = (JSPUtil.getParameter(request, prefix	+ "svc_an_yn", length));
			String[] pPort = (JSPUtil.getParameter(request, prefix	+ "p_port", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] ctPosition = (JSPUtil.getParameter(request, prefix	+ "ct_position", length));
			String[] portsCd = (JSPUtil.getParameter(request, prefix	+ "ports_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ctName = (JSPUtil.getParameter(request, prefix	+ "ct_name", length));
			String[] pCstmsCd = (JSPUtil.getParameter(request, prefix	+ "p_cstms_cd", length));
			String[] ctFax = (JSPUtil.getParameter(request, prefix	+ "ct_fax", length));
			String[] tmlsCd = (JSPUtil.getParameter(request, prefix	+ "tmls_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] n1stEurPortFlg = (JSPUtil.getParameter(request, prefix	+ "n1st_eur_port_flg", length));
			String[] svcEnsYn = (JSPUtil.getParameter(request, prefix	+ "svc_ens_yn", length));
			String[] pCntCd = (JSPUtil.getParameter(request, prefix	+ "p_cnt_cd", length));
			String[] pTml = (JSPUtil.getParameter(request, prefix	+ "p_tml", length));
			String[] ctEmail = (JSPUtil.getParameter(request, prefix	+ "ct_email", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomsSetupVO();
				if (svcExsYn[i] != null)
					model.setSvcExsYn(svcExsYn[i]);
				if (svcDrYn[i] != null)
					model.setSvcDrYn(svcDrYn[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (tmlCd[i] != null)
					model.setTmlCd(tmlCd[i]);
				if (customsCd[i] != null)
					model.setCustomsCd(customsCd[i]);
				if (customsNm[i] != null)
					model.setCustomsNm(customsNm[i]);				
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (portNm[i] != null)
					model.setPortNm(portNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctTel[i] != null)
					model.setCtTel(ctTel[i]);
				if (svcAnYn[i] != null)
					model.setSvcAnYn(svcAnYn[i]);
				if (pPort[i] != null)
					model.setPPort(pPort[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (ctPosition[i] != null)
					model.setCtPosition(ctPosition[i]);
				if (portsCd[i] != null)
					model.setPortsCd(portsCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ctName[i] != null)
					model.setCtName(ctName[i]);
				if (pCstmsCd[i] != null)
					model.setPCstmsCd(pCstmsCd[i]);
				if (ctFax[i] != null)
					model.setCtFax(ctFax[i]);
				if (tmlsCd[i] != null)
					model.setTmlsCd(tmlsCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (n1stEurPortFlg[i] != null)
					model.setN1stEurPortFlg(n1stEurPortFlg[i]);
				if (svcEnsYn[i] != null)
					model.setSvcEnsYn(svcEnsYn[i]);
				if (pCntCd[i] != null)
					model.setPCntCd(pCntCd[i]);
				if (pTml[i] != null)
					model.setPTml(pTml[i]);
				if (ctEmail[i] != null)
					model.setCtEmail(ctEmail[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomsSetupVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomsSetupVO[]
	 */
	public CustomsSetupVO[] getCustomsSetupVOs(){
		CustomsSetupVO[] vos = (CustomsSetupVO[])models.toArray(new CustomsSetupVO[models.size()]);
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
		this.svcExsYn = this.svcExsYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcDrYn = this.svcDrYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCd = this.tmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customsCd = this.customsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customsNm = this.customsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portNm = this.portNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctTel = this.ctTel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcAnYn = this.svcAnYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPort = this.pPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctPosition = this.ctPosition .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portsCd = this.portsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctName = this.ctName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCstmsCd = this.pCstmsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctFax = this.ctFax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlsCd = this.tmlsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stEurPortFlg = this.n1stEurPortFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcEnsYn = this.svcEnsYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCntCd = this.pCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pTml = this.pTml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctEmail = this.ctEmail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

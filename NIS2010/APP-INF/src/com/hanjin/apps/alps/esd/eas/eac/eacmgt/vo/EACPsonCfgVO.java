/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EACPsonCfgVO.java
*@FileTitle : EACPsonCfgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.17
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.03.17 최종혁 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo;

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
 * @author 최종혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EACPsonCfgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EACPsonCfgVO> models = new ArrayList<EACPsonCfgVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String kpiOfcCd = null;
	/* Column Info */
	private String sRhqOfcCd = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String eacUsrCode = null;
	/* Column Info */
	private String expnAudScpDesc = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String sOfcCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String eacUsrNm = null;
	/* Column Info */
	private String emlCtnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ntcCcRcvEml = null;
	/* Column Info */
	private String rhqOfcCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eacUsrId = null;
	/* Column Info */
	private String usrEml = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String emlSubjCtnt = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EACPsonCfgVO() {}

	public EACPsonCfgVO(String ibflag, String pagerows, String sRhqOfcCd, String sOfcCd, String phnNo, String eacUsrCode, String expnAudScpDesc, String deltFlg, String creDt, String eacUsrNm, String emlCtnt, String ntcCcRcvEml, String rhqOfcCd, String ofcCd, String creUsrId, String eacUsrId, String faxNo, String usrEml, String emlSubjCtnt, String updUsrId, String updDt, String kpiOfcCd) {
		this.updDt = updDt;
		this.kpiOfcCd = kpiOfcCd;
		this.sRhqOfcCd = sRhqOfcCd;
		this.phnNo = phnNo;
		this.eacUsrCode = eacUsrCode;
		this.expnAudScpDesc = expnAudScpDesc;
		this.deltFlg = deltFlg;
		this.sOfcCd = sOfcCd;
		this.creDt = creDt;
		this.eacUsrNm = eacUsrNm;
		this.emlCtnt = emlCtnt;
		this.pagerows = pagerows;
		this.ntcCcRcvEml = ntcCcRcvEml;
		this.rhqOfcCd = rhqOfcCd;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.eacUsrId = eacUsrId;
		this.usrEml = usrEml;
		this.faxNo = faxNo;
		this.emlSubjCtnt = emlSubjCtnt;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("kpi_ofc_cd", getKpiOfcCd());
		this.hashColumns.put("s_rhq_ofc_cd", getSRhqOfcCd());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("eac_usr_code", getEacUsrCode());
		this.hashColumns.put("expn_aud_scp_desc", getExpnAudScpDesc());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("s_ofc_cd", getSOfcCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("eac_usr_nm", getEacUsrNm());
		this.hashColumns.put("eml_ctnt", getEmlCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ntc_cc_rcv_eml", getNtcCcRcvEml());
		this.hashColumns.put("rhq_ofc_cd", getRhqOfcCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eac_usr_id", getEacUsrId());
		this.hashColumns.put("usr_eml", getUsrEml());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("eml_subj_ctnt", getEmlSubjCtnt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("kpi_ofc_cd", "kpiOfcCd");
		this.hashFields.put("s_rhq_ofc_cd", "sRhqOfcCd");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("eac_usr_code", "eacUsrCode");
		this.hashFields.put("expn_aud_scp_desc", "expnAudScpDesc");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("s_ofc_cd", "sOfcCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eac_usr_nm", "eacUsrNm");
		this.hashFields.put("eml_ctnt", "emlCtnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ntc_cc_rcv_eml", "ntcCcRcvEml");
		this.hashFields.put("rhq_ofc_cd", "rhqOfcCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eac_usr_id", "eacUsrId");
		this.hashFields.put("usr_eml", "usrEml");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("eml_subj_ctnt", "emlSubjCtnt");
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
	 * @return kpiOfcCd
	 */
	public String getKpiOfcCd() {
		return this.kpiOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sRhqOfcCd
	 */
	public String getSRhqOfcCd() {
		return this.sRhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 * Column Info
	 * @return eacUsrCode
	 */
	public String getEacUsrCode() {
		return this.eacUsrCode;
	}
	
	/**
	 * Column Info
	 * @return expnAudScpDesc
	 */
	public String getExpnAudScpDesc() {
		return this.expnAudScpDesc;
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
	 * @return sOfcCd
	 */
	public String getSOfcCd() {
		return this.sOfcCd;
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
	 * @return eacUsrNm
	 */
	public String getEacUsrNm() {
		return this.eacUsrNm;
	}
	
	/**
	 * Column Info
	 * @return emlCtnt
	 */
	public String getEmlCtnt() {
		return this.emlCtnt;
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
	 * @return ntcCcRcvEml
	 */
	public String getNtcCcRcvEml() {
		return this.ntcCcRcvEml;
	}
	
	/**
	 * Column Info
	 * @return rhqOfcCd
	 */
	public String getRhqOfcCd() {
		return this.rhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return eacUsrId
	 */
	public String getEacUsrId() {
		return this.eacUsrId;
	}
	
	/**
	 * Column Info
	 * @return usrEml
	 */
	public String getUsrEml() {
		return this.usrEml;
	}
	
	/**
	 * Column Info
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 * Column Info
	 * @return emlSubjCtnt
	 */
	public String getEmlSubjCtnt() {
		return this.emlSubjCtnt;
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
	 * @param kpiOfcCd
	 */
	public void setKpiOfcCd(String kpiOfcCd) {
		this.kpiOfcCd = kpiOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sRhqOfcCd
	 */
	public void setSRhqOfcCd(String sRhqOfcCd) {
		this.sRhqOfcCd = sRhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * Column Info
	 * @param eacUsrCode
	 */
	public void setEacUsrCode(String eacUsrCode) {
		this.eacUsrCode = eacUsrCode;
	}
	
	/**
	 * Column Info
	 * @param expnAudScpDesc
	 */
	public void setExpnAudScpDesc(String expnAudScpDesc) {
		this.expnAudScpDesc = expnAudScpDesc;
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
	 * @param sOfcCd
	 */
	public void setSOfcCd(String sOfcCd) {
		this.sOfcCd = sOfcCd;
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
	 * @param eacUsrNm
	 */
	public void setEacUsrNm(String eacUsrNm) {
		this.eacUsrNm = eacUsrNm;
	}
	
	/**
	 * Column Info
	 * @param emlCtnt
	 */
	public void setEmlCtnt(String emlCtnt) {
		this.emlCtnt = emlCtnt;
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
	 * @param ntcCcRcvEml
	 */
	public void setNtcCcRcvEml(String ntcCcRcvEml) {
		this.ntcCcRcvEml = ntcCcRcvEml;
	}
	
	/**
	 * Column Info
	 * @param rhqOfcCd
	 */
	public void setRhqOfcCd(String rhqOfcCd) {
		this.rhqOfcCd = rhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param eacUsrId
	 */
	public void setEacUsrId(String eacUsrId) {
		this.eacUsrId = eacUsrId;
	}
	
	/**
	 * Column Info
	 * @param usrEml
	 */
	public void setUsrEml(String usrEml) {
		this.usrEml = usrEml;
	}
	
	/**
	 * Column Info
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	/**
	 * Column Info
	 * @param emlSubjCtnt
	 */
	public void setEmlSubjCtnt(String emlSubjCtnt) {
		this.emlSubjCtnt = emlSubjCtnt;
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
		setKpiOfcCd(JSPUtil.getParameter(request, prefix + "kpi_ofc_cd", ""));
		setSRhqOfcCd(JSPUtil.getParameter(request, prefix + "s_rhq_ofc_cd", ""));
		setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
		setEacUsrCode(JSPUtil.getParameter(request, prefix + "eac_usr_code", ""));
		setExpnAudScpDesc(JSPUtil.getParameter(request, prefix + "expn_aud_scp_desc", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setSOfcCd(JSPUtil.getParameter(request, prefix + "s_ofc_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEacUsrNm(JSPUtil.getParameter(request, prefix + "eac_usr_nm", ""));
		setEmlCtnt(JSPUtil.getParameter(request, prefix + "eml_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setNtcCcRcvEml(JSPUtil.getParameter(request, prefix + "ntc_cc_rcv_eml", ""));
		setRhqOfcCd(JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEacUsrId(JSPUtil.getParameter(request, prefix + "eac_usr_id", ""));
		setUsrEml(JSPUtil.getParameter(request, prefix + "usr_eml", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
		setEmlSubjCtnt(JSPUtil.getParameter(request, prefix + "eml_subj_ctnt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EACPsonCfgVO[]
	 */
	public EACPsonCfgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EACPsonCfgVO[]
	 */
	public EACPsonCfgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EACPsonCfgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] kpiOfcCd = (JSPUtil.getParameter(request, prefix	+ "kpi_ofc_cd", length));
			String[] sRhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_rhq_ofc_cd", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] eacUsrCode = (JSPUtil.getParameter(request, prefix	+ "eac_usr_code", length));
			String[] expnAudScpDesc = (JSPUtil.getParameter(request, prefix	+ "expn_aud_scp_desc", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] sOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] eacUsrNm = (JSPUtil.getParameter(request, prefix	+ "eac_usr_nm", length));
			String[] emlCtnt = (JSPUtil.getParameter(request, prefix	+ "eml_ctnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ntcCcRcvEml = (JSPUtil.getParameter(request, prefix	+ "ntc_cc_rcv_eml", length));
			String[] rhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "rhq_ofc_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eacUsrId = (JSPUtil.getParameter(request, prefix	+ "eac_usr_id", length));
			String[] usrEml = (JSPUtil.getParameter(request, prefix	+ "usr_eml", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] emlSubjCtnt = (JSPUtil.getParameter(request, prefix	+ "eml_subj_ctnt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new EACPsonCfgVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (kpiOfcCd[i] != null)
					model.setKpiOfcCd(kpiOfcCd[i]);
				if (sRhqOfcCd[i] != null)
					model.setSRhqOfcCd(sRhqOfcCd[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (eacUsrCode[i] != null)
					model.setEacUsrCode(eacUsrCode[i]);
				if (expnAudScpDesc[i] != null)
					model.setExpnAudScpDesc(expnAudScpDesc[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (sOfcCd[i] != null)
					model.setSOfcCd(sOfcCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (eacUsrNm[i] != null)
					model.setEacUsrNm(eacUsrNm[i]);
				if (emlCtnt[i] != null)
					model.setEmlCtnt(emlCtnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ntcCcRcvEml[i] != null)
					model.setNtcCcRcvEml(ntcCcRcvEml[i]);
				if (rhqOfcCd[i] != null)
					model.setRhqOfcCd(rhqOfcCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eacUsrId[i] != null)
					model.setEacUsrId(eacUsrId[i]);
				if (usrEml[i] != null)
					model.setUsrEml(usrEml[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (emlSubjCtnt[i] != null)
					model.setEmlSubjCtnt(emlSubjCtnt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEACPsonCfgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EACPsonCfgVO[]
	 */
	public EACPsonCfgVO[] getEACPsonCfgVOs(){
		EACPsonCfgVO[] vos = (EACPsonCfgVO[])models.toArray(new EACPsonCfgVO[models.size()]);
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
		this.kpiOfcCd = this.kpiOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRhqOfcCd = this.sRhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacUsrCode = this.eacUsrCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnAudScpDesc = this.expnAudScpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCd = this.sOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacUsrNm = this.eacUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlCtnt = this.emlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcCcRcvEml = this.ntcCcRcvEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqOfcCd = this.rhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacUsrId = this.eacUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrEml = this.usrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSubjCtnt = this.emlSubjCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

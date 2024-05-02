/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchRelredMasterForEdiVO.java
*@FileTitle : SearchRelredMasterForEdiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.09  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.vo;

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

public class SearchRelredMasterForEdiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchRelredMasterForEdiVO> models = new ArrayList<SearchRelredMasterForEdiVO>();
	
	/* Column Info */
	private String ntfy = null;
	/* Column Info */
	private String stkIssCd = null;
	/* Column Info */
	private String cb = null;
	/* Column Info */
	private String mtyCyDesc = null;
	/* Column Info */
	private String tp = null;
	/* Column Info */
	private String cgoTpCd = null;
	/* Column Info */
	private String drInd = null;
	/* Column Info */
	private String type = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntrRtnYdCd = null;
	/* Column Info */
	private String haulType = null;
	/* Column Info */
	private String spclInst = null;
	/* Column Info */
	private String bdDisp = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String trspSoTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String bd = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String vvdEta = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String stkJbSeq = null;
	/* Column Info */
	private String vslName = null;
	/* Column Info */
	private String eqrelLoc = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String userOfc = null;
	/* Column Info */
	private String rfInd = null;
	/* Column Info */
	private String email = null;
	/* Column Info */
	private String ydNm = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String faxSndNo = null;
	/* Column Info */
	private String vvdEtd = null;
	/* Column Info */
	private String eqrelName = null;
	/* Column Info */
	private String sP = null;
	/* Column Info */
	private String consortVoy = null;
	/* Column Info */
	private String soSeq = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String podDesc = null;
	/* Column Info */
	private String sendKey = null;
	/* Column Info */
	private String modeCd = null;
	/* Column Info */
	private String polDesc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslCall = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String vslLoyd = null;
	/* Column Info */
	private String msgId = null;
	/* Column Info */
	private String akInd = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String trspSoStsCd = null;
	/* Column Info */
	private String shipOpr = null;
	/* Column Info */
	private String pdDate = null;
	/* Column Info */
	private String emptyCy = null;
	/* Column Info */
	private String issueDt = null;
	/* Column Info */
	private String typeDisp = null;
	/* Column Info */
	private String office = null;
	/* Column Info */
	private String faxEmailRst = null;
	/* Column Info */
	private String soOfcCtyCd = null;
	/* Column Info */
	private String eqresLoc = null;
	/* Column Info */
	private String orgEmptyCy = null;
	/* Column Info */
	private String emptyDest = null;
	/* Column Info */
	private String eqres = null;
	/* Column Info */
	private String pdDateDisp = null;
	/* Column Info */
	private String eqrel = null;
	/* Column Info */
	private String cntrPkupDt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String iOffice = null;
	/* Column Info */
	private String cnee = null;
	/* Column Info */
	private String eqresName = null;
	/* Column Info */
	private String shpr = null;
	/* Column Info */
	private String typeCd = null;
	/* Column Info */
	private String stkOfcCd = null;
	/* Column Info */
	private String eppRef = null;
	/* Column Info */
	private String dest = null;
	/* Column Info */
	private String destDesc = null;
	/* Column Info */
	private String trspBndCd = null;
	/* Column Info */
	private String trspCostDtlModCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchRelredMasterForEdiVO() {}

	public SearchRelredMasterForEdiVO(String ibflag, String pagerows, String iOffice, String bd, String trspSoStsCd, String bdDisp, String bkgNo, String blNo, String modeCd, String typeCd, String typeDisp, String pol, String polDesc, String pod, String podDesc, String emptyCy, String mtyCyDesc, String orgEmptyCy, String sP, String vndrLglEngNm, String pdDateDisp, String pdDate, String cntrNo, String eqNo, 
			String tp, String cb, String emptyDest, String ydNm, String faxNo, String email, String office, String userId, String issueDt, String faxEmailRst, String vvd, String woNo, String spclInst, String shpr, String cnee, String ntfy, String status, String eqrel, String eqrelLoc, String eqrelName, String eqres, String eqresLoc, String eqresName, String vslCall, String vslLoyd, String vslName, 
			String consortVoy, String vvdEtd, String vvdEta, String haulType, String shipOpr, String drInd, String rfInd, String akInd, String cntrPkupDt, String cntrRtnYdCd, String trspSoTpCd, String cgoTpCd, String soOfcCtyCd, String soSeq, String stkOfcCd, String stkJbSeq, String creUsrId, String updUsrId, String faxSndNo, String type, String sendKey, String stkIssCd, String userOfc, String msgId, 
			String eppRef, String dest, String destDesc, String trspBndCd, String trspCostDtlModCd) {
		this.ntfy = ntfy;
		this.stkIssCd = stkIssCd;
		this.cb = cb;
		this.mtyCyDesc = mtyCyDesc;
		this.tp = tp;
		this.cgoTpCd = cgoTpCd;
		this.drInd = drInd;
		this.type = type;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.cntrRtnYdCd = cntrRtnYdCd;
		this.haulType = haulType;
		this.spclInst = spclInst;
		this.bdDisp = bdDisp;
		this.pol = pol;
		this.userId = userId;
		this.trspSoTpCd = trspSoTpCd;
		this.updUsrId = updUsrId;
		this.bd = bd;
		this.pod = pod;
		this.vvdEta = vvdEta;
		this.status = status;
		this.stkJbSeq = stkJbSeq;
		this.vslName = vslName;
		this.eqrelLoc = eqrelLoc;
		this.vvd = vvd;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.userOfc = userOfc;
		this.rfInd = rfInd;
		this.email = email;
		this.ydNm = ydNm;
		this.faxNo = faxNo;
		this.faxSndNo = faxSndNo;
		this.vvdEtd = vvdEtd;
		this.eqrelName = eqrelName;
		this.sP = sP;
		this.consortVoy = consortVoy;
		this.soSeq = soSeq;
		this.vndrLglEngNm = vndrLglEngNm;
		this.podDesc = podDesc;
		this.sendKey = sendKey;
		this.modeCd = modeCd;
		this.polDesc = polDesc;
		this.ibflag = ibflag;
		this.vslCall = vslCall;
		this.eqNo = eqNo;
		this.vslLoyd = vslLoyd;
		this.msgId = msgId;
		this.akInd = akInd;
		this.woNo = woNo;
		this.trspSoStsCd = trspSoStsCd;
		this.shipOpr = shipOpr;
		this.pdDate = pdDate;
		this.emptyCy = emptyCy;
		this.issueDt = issueDt;
		this.typeDisp = typeDisp;
		this.office = office;
		this.faxEmailRst = faxEmailRst;
		this.soOfcCtyCd = soOfcCtyCd;
		this.eqresLoc = eqresLoc;
		this.orgEmptyCy = orgEmptyCy;
		this.emptyDest = emptyDest;
		this.eqres = eqres;
		this.pdDateDisp = pdDateDisp;
		this.eqrel = eqrel;
		this.cntrPkupDt = cntrPkupDt;
		this.cntrNo = cntrNo;
		this.iOffice = iOffice;
		this.cnee = cnee;
		this.eqresName = eqresName;
		this.shpr = shpr;
		this.typeCd = typeCd;
		this.stkOfcCd = stkOfcCd;
		this.eppRef = eppRef;
		this.dest = dest;
		this.destDesc = destDesc;
		this.trspBndCd = trspBndCd;
		this.trspCostDtlModCd = trspCostDtlModCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ntfy", getNtfy());
		this.hashColumns.put("stk_iss_cd", getStkIssCd());
		this.hashColumns.put("cb", getCb());
		this.hashColumns.put("mty_cy_desc", getMtyCyDesc());
		this.hashColumns.put("tp", getTp());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("dr_ind", getDrInd());
		this.hashColumns.put("type", getType());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_rtn_yd_cd", getCntrRtnYdCd());
		this.hashColumns.put("haul_type", getHaulType());
		this.hashColumns.put("spcl_inst", getSpclInst());
		this.hashColumns.put("bd_disp", getBdDisp());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("trsp_so_tp_cd", getTrspSoTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("bd", getBd());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("vvd_eta", getVvdEta());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("stk_jb_seq", getStkJbSeq());
		this.hashColumns.put("vsl_name", getVslName());
		this.hashColumns.put("eqrel_loc", getEqrelLoc());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("user_ofc", getUserOfc());
		this.hashColumns.put("rf_ind", getRfInd());
		this.hashColumns.put("email", getEmail());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("fax_snd_no", getFaxSndNo());
		this.hashColumns.put("vvd_etd", getVvdEtd());
		this.hashColumns.put("eqrel_name", getEqrelName());
		this.hashColumns.put("s_p", getSP());
		this.hashColumns.put("consort_voy", getConsortVoy());
		this.hashColumns.put("so_seq", getSoSeq());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("pod_desc", getPodDesc());
		this.hashColumns.put("send_key", getSendKey());
		this.hashColumns.put("mode_cd", getModeCd());
		this.hashColumns.put("pol_desc", getPolDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_call", getVslCall());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("vsl_loyd", getVslLoyd());
		this.hashColumns.put("msg_id", getMsgId());
		this.hashColumns.put("ak_ind", getAkInd());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("trsp_so_sts_cd", getTrspSoStsCd());
		this.hashColumns.put("ship_opr", getShipOpr());
		this.hashColumns.put("pd_date", getPdDate());
		this.hashColumns.put("empty_cy", getEmptyCy());
		this.hashColumns.put("issue_dt", getIssueDt());
		this.hashColumns.put("type_disp", getTypeDisp());
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("fax_email_rst", getFaxEmailRst());
		this.hashColumns.put("so_ofc_cty_cd", getSoOfcCtyCd());
		this.hashColumns.put("eqres_loc", getEqresLoc());
		this.hashColumns.put("org_empty_cy", getOrgEmptyCy());
		this.hashColumns.put("empty_dest", getEmptyDest());
		this.hashColumns.put("eqres", getEqres());
		this.hashColumns.put("pd_date_disp", getPdDateDisp());
		this.hashColumns.put("eqrel", getEqrel());
		this.hashColumns.put("cntr_pkup_dt", getCntrPkupDt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("i_office", getIOffice());
		this.hashColumns.put("cnee", getCnee());
		this.hashColumns.put("eqres_name", getEqresName());
		this.hashColumns.put("shpr", getShpr());
		this.hashColumns.put("type_cd", getTypeCd());
		this.hashColumns.put("stk_ofc_cd", getStkOfcCd());
		this.hashColumns.put("epp_ref", getEppRef());
		this.hashColumns.put("dest", getDest());
		this.hashColumns.put("dest_desc", getDestDesc());
		this.hashColumns.put("trsp_bnd_cd", getTrspBndCd());
		this.hashColumns.put("trsp_cost_dtl_mod_cd", getTrspCostDtlModCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ntfy", "ntfy");
		this.hashFields.put("stk_iss_cd", "stkIssCd");
		this.hashFields.put("cb", "cb");
		this.hashFields.put("mty_cy_desc", "mtyCyDesc");
		this.hashFields.put("tp", "tp");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("dr_ind", "drInd");
		this.hashFields.put("type", "type");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_rtn_yd_cd", "cntrRtnYdCd");
		this.hashFields.put("haul_type", "haulType");
		this.hashFields.put("spcl_inst", "spclInst");
		this.hashFields.put("bd_disp", "bdDisp");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("trsp_so_tp_cd", "trspSoTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("bd", "bd");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("vvd_eta", "vvdEta");
		this.hashFields.put("status", "status");
		this.hashFields.put("stk_jb_seq", "stkJbSeq");
		this.hashFields.put("vsl_name", "vslName");
		this.hashFields.put("eqrel_loc", "eqrelLoc");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("user_ofc", "userOfc");
		this.hashFields.put("rf_ind", "rfInd");
		this.hashFields.put("email", "email");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("fax_snd_no", "faxSndNo");
		this.hashFields.put("vvd_etd", "vvdEtd");
		this.hashFields.put("eqrel_name", "eqrelName");
		this.hashFields.put("s_p", "sP");
		this.hashFields.put("consort_voy", "consortVoy");
		this.hashFields.put("so_seq", "soSeq");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("pod_desc", "podDesc");
		this.hashFields.put("send_key", "sendKey");
		this.hashFields.put("mode_cd", "modeCd");
		this.hashFields.put("pol_desc", "polDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_call", "vslCall");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("vsl_loyd", "vslLoyd");
		this.hashFields.put("msg_id", "msgId");
		this.hashFields.put("ak_ind", "akInd");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("trsp_so_sts_cd", "trspSoStsCd");
		this.hashFields.put("ship_opr", "shipOpr");
		this.hashFields.put("pd_date", "pdDate");
		this.hashFields.put("empty_cy", "emptyCy");
		this.hashFields.put("issue_dt", "issueDt");
		this.hashFields.put("type_disp", "typeDisp");
		this.hashFields.put("office", "office");
		this.hashFields.put("fax_email_rst", "faxEmailRst");
		this.hashFields.put("so_ofc_cty_cd", "soOfcCtyCd");
		this.hashFields.put("eqres_loc", "eqresLoc");
		this.hashFields.put("org_empty_cy", "orgEmptyCy");
		this.hashFields.put("empty_dest", "emptyDest");
		this.hashFields.put("eqres", "eqres");
		this.hashFields.put("pd_date_disp", "pdDateDisp");
		this.hashFields.put("eqrel", "eqrel");
		this.hashFields.put("cntr_pkup_dt", "cntrPkupDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("i_office", "iOffice");
		this.hashFields.put("cnee", "cnee");
		this.hashFields.put("eqres_name", "eqresName");
		this.hashFields.put("shpr", "shpr");
		this.hashFields.put("type_cd", "typeCd");
		this.hashFields.put("stk_ofc_cd", "stkOfcCd");
		this.hashFields.put("epp_ref", "eppRef");
		this.hashFields.put("dest", "dest");
		this.hashFields.put("dest_desc", "destDesc");
		this.hashFields.put("trsp_bnd_cd", "trspBndCd");
		this.hashFields.put("trsp_cost_dtl_mod_cd", "trspCostDtlModCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ntfy
	 */
	public String getNtfy() {
		return this.ntfy;
	}
	
	/**
	 * Column Info
	 * @return stkIssCd
	 */
	public String getStkIssCd() {
		return this.stkIssCd;
	}
	
	/**
	 * Column Info
	 * @return cb
	 */
	public String getCb() {
		return this.cb;
	}
	
	/**
	 * Column Info
	 * @return mtyCyDesc
	 */
	public String getMtyCyDesc() {
		return this.mtyCyDesc;
	}
	
	/**
	 * Column Info
	 * @return tp
	 */
	public String getTp() {
		return this.tp;
	}
	
	/**
	 * Column Info
	 * @return cgoTpCd
	 */
	public String getCgoTpCd() {
		return this.cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return drInd
	 */
	public String getDrInd() {
		return this.drInd;
	}
	
	/**
	 * Column Info
	 * @return type
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return cntrRtnYdCd
	 */
	public String getCntrRtnYdCd() {
		return this.cntrRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @return haulType
	 */
	public String getHaulType() {
		return this.haulType;
	}
	
	/**
	 * Column Info
	 * @return spclInst
	 */
	public String getSpclInst() {
		return this.spclInst;
	}
	
	/**
	 * Column Info
	 * @return bdDisp
	 */
	public String getBdDisp() {
		return this.bdDisp;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
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
	 * @return trspSoTpCd
	 */
	public String getTrspSoTpCd() {
		return this.trspSoTpCd;
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
	 * @return bd
	 */
	public String getBd() {
		return this.bd;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return vvdEta
	 */
	public String getVvdEta() {
		return this.vvdEta;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return stkJbSeq
	 */
	public String getStkJbSeq() {
		return this.stkJbSeq;
	}
	
	/**
	 * Column Info
	 * @return vslName
	 */
	public String getVslName() {
		return this.vslName;
	}
	
	/**
	 * Column Info
	 * @return eqrelLoc
	 */
	public String getEqrelLoc() {
		return this.eqrelLoc;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return userOfc
	 */
	public String getUserOfc() {
		return this.userOfc;
	}
	
	/**
	 * Column Info
	 * @return rfInd
	 */
	public String getRfInd() {
		return this.rfInd;
	}
	
	/**
	 * Column Info
	 * @return email
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Column Info
	 * @return ydNm
	 */
	public String getYdNm() {
		return this.ydNm;
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
	 * @return faxSndNo
	 */
	public String getFaxSndNo() {
		return this.faxSndNo;
	}
	
	/**
	 * Column Info
	 * @return vvdEtd
	 */
	public String getVvdEtd() {
		return this.vvdEtd;
	}
	
	/**
	 * Column Info
	 * @return eqrelName
	 */
	public String getEqrelName() {
		return this.eqrelName;
	}
	
	/**
	 * Column Info
	 * @return sP
	 */
	public String getSP() {
		return this.sP;
	}
	
	/**
	 * Column Info
	 * @return consortVoy
	 */
	public String getConsortVoy() {
		return this.consortVoy;
	}
	
	/**
	 * Column Info
	 * @return soSeq
	 */
	public String getSoSeq() {
		return this.soSeq;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return podDesc
	 */
	public String getPodDesc() {
		return this.podDesc;
	}
	
	/**
	 * Column Info
	 * @return sendKey
	 */
	public String getSendKey() {
		return this.sendKey;
	}
	
	/**
	 * Column Info
	 * @return modeCd
	 */
	public String getModeCd() {
		return this.modeCd;
	}
	
	/**
	 * Column Info
	 * @return polDesc
	 */
	public String getPolDesc() {
		return this.polDesc;
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
	 * @return vslCall
	 */
	public String getVslCall() {
		return this.vslCall;
	}
	
	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return vslLoyd
	 */
	public String getVslLoyd() {
		return this.vslLoyd;
	}
	
	/**
	 * Column Info
	 * @return msgId
	 */
	public String getMsgId() {
		return this.msgId;
	}
	
	/**
	 * Column Info
	 * @return akInd
	 */
	public String getAkInd() {
		return this.akInd;
	}
	
	/**
	 * Column Info
	 * @return woNo
	 */
	public String getWoNo() {
		return this.woNo;
	}
	
	/**
	 * Column Info
	 * @return trspSoStsCd
	 */
	public String getTrspSoStsCd() {
		return this.trspSoStsCd;
	}
	
	/**
	 * Column Info
	 * @return shipOpr
	 */
	public String getShipOpr() {
		return this.shipOpr;
	}
	
	/**
	 * Column Info
	 * @return pdDate
	 */
	public String getPdDate() {
		return this.pdDate;
	}
	
	/**
	 * Column Info
	 * @return emptyCy
	 */
	public String getEmptyCy() {
		return this.emptyCy;
	}
	
	/**
	 * Column Info
	 * @return issueDt
	 */
	public String getIssueDt() {
		return this.issueDt;
	}
	
	/**
	 * Column Info
	 * @return typeDisp
	 */
	public String getTypeDisp() {
		return this.typeDisp;
	}
	
	/**
	 * Column Info
	 * @return office
	 */
	public String getOffice() {
		return this.office;
	}
	
	/**
	 * Column Info
	 * @return faxEmailRst
	 */
	public String getFaxEmailRst() {
		return this.faxEmailRst;
	}
	
	/**
	 * Column Info
	 * @return soOfcCtyCd
	 */
	public String getSoOfcCtyCd() {
		return this.soOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return eqresLoc
	 */
	public String getEqresLoc() {
		return this.eqresLoc;
	}
	
	/**
	 * Column Info
	 * @return orgEmptyCy
	 */
	public String getOrgEmptyCy() {
		return this.orgEmptyCy;
	}
	
	/**
	 * Column Info
	 * @return emptyDest
	 */
	public String getEmptyDest() {
		return this.emptyDest;
	}
	
	/**
	 * Column Info
	 * @return eqres
	 */
	public String getEqres() {
		return this.eqres;
	}
	
	/**
	 * Column Info
	 * @return pdDateDisp
	 */
	public String getPdDateDisp() {
		return this.pdDateDisp;
	}
	
	/**
	 * Column Info
	 * @return eqrel
	 */
	public String getEqrel() {
		return this.eqrel;
	}
	
	/**
	 * Column Info
	 * @return cntrPkupDt
	 */
	public String getCntrPkupDt() {
		return this.cntrPkupDt;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return iOffice
	 */
	public String getIOffice() {
		return this.iOffice;
	}
	
	/**
	 * Column Info
	 * @return cnee
	 */
	public String getCnee() {
		return this.cnee;
	}
	
	/**
	 * Column Info
	 * @return eqresName
	 */
	public String getEqresName() {
		return this.eqresName;
	}
	
	/**
	 * Column Info
	 * @return shpr
	 */
	public String getShpr() {
		return this.shpr;
	}
	
	/**
	 * Column Info
	 * @return typeCd
	 */
	public String getTypeCd() {
		return this.typeCd;
	}
	
	/**
	 * Column Info
	 * @return stkOfcCd
	 */
	public String getStkOfcCd() {
		return this.stkOfcCd;
	}
	
	/**
	 * Column Info
	 * @return eppRef
	 */
	public String getEppRef() {
		return eppRef;
	}

	/**
	 * Column Info
	 * @return dest
	 */
	public String getDest() {
		return dest;
	}
	
	/**
	 * Column Info
	 * @return destDesc
	 */
	public String getDestDesc() {
		return destDesc;
	}
	
	/**
	 * Column Info
	 * @return trspCostDtlModCd
	 */
	public String getTrspCostDtlModCd() {
		return trspCostDtlModCd;
	}

	/**
	 * Column Info
	 * @param ntfy
	 */
	public void setNtfy(String ntfy) {
		this.ntfy = ntfy;
	}
	
	/**
	 * Column Info
	 * @param stkIssCd
	 */
	public void setStkIssCd(String stkIssCd) {
		this.stkIssCd = stkIssCd;
	}
	
	/**
	 * Column Info
	 * @param cb
	 */
	public void setCb(String cb) {
		this.cb = cb;
	}
	
	/**
	 * Column Info
	 * @param mtyCyDesc
	 */
	public void setMtyCyDesc(String mtyCyDesc) {
		this.mtyCyDesc = mtyCyDesc;
	}
	
	/**
	 * Column Info
	 * @param tp
	 */
	public void setTp(String tp) {
		this.tp = tp;
	}
	
	/**
	 * Column Info
	 * @param cgoTpCd
	 */
	public void setCgoTpCd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param drInd
	 */
	public void setDrInd(String drInd) {
		this.drInd = drInd;
	}
	
	/**
	 * Column Info
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param cntrRtnYdCd
	 */
	public void setCntrRtnYdCd(String cntrRtnYdCd) {
		this.cntrRtnYdCd = cntrRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @param haulType
	 */
	public void setHaulType(String haulType) {
		this.haulType = haulType;
	}
	
	/**
	 * Column Info
	 * @param spclInst
	 */
	public void setSpclInst(String spclInst) {
		this.spclInst = spclInst;
	}
	
	/**
	 * Column Info
	 * @param bdDisp
	 */
	public void setBdDisp(String bdDisp) {
		this.bdDisp = bdDisp;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
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
	 * @param trspSoTpCd
	 */
	public void setTrspSoTpCd(String trspSoTpCd) {
		this.trspSoTpCd = trspSoTpCd;
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
	 * @param bd
	 */
	public void setBd(String bd) {
		this.bd = bd;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param vvdEta
	 */
	public void setVvdEta(String vvdEta) {
		this.vvdEta = vvdEta;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param stkJbSeq
	 */
	public void setStkJbSeq(String stkJbSeq) {
		this.stkJbSeq = stkJbSeq;
	}
	
	/**
	 * Column Info
	 * @param vslName
	 */
	public void setVslName(String vslName) {
		this.vslName = vslName;
	}
	
	/**
	 * Column Info
	 * @param eqrelLoc
	 */
	public void setEqrelLoc(String eqrelLoc) {
		this.eqrelLoc = eqrelLoc;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param userOfc
	 */
	public void setUserOfc(String userOfc) {
		this.userOfc = userOfc;
	}
	
	/**
	 * Column Info
	 * @param rfInd
	 */
	public void setRfInd(String rfInd) {
		this.rfInd = rfInd;
	}
	
	/**
	 * Column Info
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Column Info
	 * @param ydNm
	 */
	public void setYdNm(String ydNm) {
		this.ydNm = ydNm;
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
	 * @param faxSndNo
	 */
	public void setFaxSndNo(String faxSndNo) {
		this.faxSndNo = faxSndNo;
	}
	
	/**
	 * Column Info
	 * @param vvdEtd
	 */
	public void setVvdEtd(String vvdEtd) {
		this.vvdEtd = vvdEtd;
	}
	
	/**
	 * Column Info
	 * @param eqrelName
	 */
	public void setEqrelName(String eqrelName) {
		this.eqrelName = eqrelName;
	}
	
	/**
	 * Column Info
	 * @param sP
	 */
	public void setSP(String sP) {
		this.sP = sP;
	}
	
	/**
	 * Column Info
	 * @param consortVoy
	 */
	public void setConsortVoy(String consortVoy) {
		this.consortVoy = consortVoy;
	}
	
	/**
	 * Column Info
	 * @param soSeq
	 */
	public void setSoSeq(String soSeq) {
		this.soSeq = soSeq;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param podDesc
	 */
	public void setPodDesc(String podDesc) {
		this.podDesc = podDesc;
	}
	
	/**
	 * Column Info
	 * @param sendKey
	 */
	public void setSendKey(String sendKey) {
		this.sendKey = sendKey;
	}
	
	/**
	 * Column Info
	 * @param modeCd
	 */
	public void setModeCd(String modeCd) {
		this.modeCd = modeCd;
	}
	
	/**
	 * Column Info
	 * @param polDesc
	 */
	public void setPolDesc(String polDesc) {
		this.polDesc = polDesc;
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
	 * @param vslCall
	 */
	public void setVslCall(String vslCall) {
		this.vslCall = vslCall;
	}
	
	/**
	 * Column Info
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param vslLoyd
	 */
	public void setVslLoyd(String vslLoyd) {
		this.vslLoyd = vslLoyd;
	}
	
	/**
	 * Column Info
	 * @param msgId
	 */
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
	/**
	 * Column Info
	 * @param akInd
	 */
	public void setAkInd(String akInd) {
		this.akInd = akInd;
	}
	
	/**
	 * Column Info
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}
	
	/**
	 * Column Info
	 * @param trspSoStsCd
	 */
	public void setTrspSoStsCd(String trspSoStsCd) {
		this.trspSoStsCd = trspSoStsCd;
	}
	
	/**
	 * Column Info
	 * @param shipOpr
	 */
	public void setShipOpr(String shipOpr) {
		this.shipOpr = shipOpr;
	}
	
	/**
	 * Column Info
	 * @param pdDate
	 */
	public void setPdDate(String pdDate) {
		this.pdDate = pdDate;
	}
	
	/**
	 * Column Info
	 * @param emptyCy
	 */
	public void setEmptyCy(String emptyCy) {
		this.emptyCy = emptyCy;
	}
	
	/**
	 * Column Info
	 * @param issueDt
	 */
	public void setIssueDt(String issueDt) {
		this.issueDt = issueDt;
	}
	
	/**
	 * Column Info
	 * @param typeDisp
	 */
	public void setTypeDisp(String typeDisp) {
		this.typeDisp = typeDisp;
	}
	
	/**
	 * Column Info
	 * @param office
	 */
	public void setOffice(String office) {
		this.office = office;
	}
	
	/**
	 * Column Info
	 * @param faxEmailRst
	 */
	public void setFaxEmailRst(String faxEmailRst) {
		this.faxEmailRst = faxEmailRst;
	}
	
	/**
	 * Column Info
	 * @param soOfcCtyCd
	 */
	public void setSoOfcCtyCd(String soOfcCtyCd) {
		this.soOfcCtyCd = soOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param eqresLoc
	 */
	public void setEqresLoc(String eqresLoc) {
		this.eqresLoc = eqresLoc;
	}
	
	/**
	 * Column Info
	 * @param orgEmptyCy
	 */
	public void setOrgEmptyCy(String orgEmptyCy) {
		this.orgEmptyCy = orgEmptyCy;
	}
	
	/**
	 * Column Info
	 * @param emptyDest
	 */
	public void setEmptyDest(String emptyDest) {
		this.emptyDest = emptyDest;
	}
	
	/**
	 * Column Info
	 * @param eqres
	 */
	public void setEqres(String eqres) {
		this.eqres = eqres;
	}
	
	/**
	 * Column Info
	 * @param pdDateDisp
	 */
	public void setPdDateDisp(String pdDateDisp) {
		this.pdDateDisp = pdDateDisp;
	}
	
	/**
	 * Column Info
	 * @param eqrel
	 */
	public void setEqrel(String eqrel) {
		this.eqrel = eqrel;
	}
	
	/**
	 * Column Info
	 * @param cntrPkupDt
	 */
	public void setCntrPkupDt(String cntrPkupDt) {
		this.cntrPkupDt = cntrPkupDt;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param iOffice
	 */
	public void setIOffice(String iOffice) {
		this.iOffice = iOffice;
	}
	
	/**
	 * Column Info
	 * @param cnee
	 */
	public void setCnee(String cnee) {
		this.cnee = cnee;
	}
	
	/**
	 * Column Info
	 * @param eqresName
	 */
	public void setEqresName(String eqresName) {
		this.eqresName = eqresName;
	}
	
	/**
	 * Column Info
	 * @param shpr
	 */
	public void setShpr(String shpr) {
		this.shpr = shpr;
	}
	
	/**
	 * Column Info
	 * @param typeCd
	 */
	public void setTypeCd(String typeCd) {
		this.typeCd = typeCd;
	}
	
	/**
	 * Column Info
	 * @param stkOfcCd
	 */
	public void setStkOfcCd(String stkOfcCd) {
		this.stkOfcCd = stkOfcCd;
	}
	
	/**
	 * Column Info
	 * @param eppRef
	 */
	public void setEppRef(String eppRef) {
		this.eppRef = eppRef;
	}
	
	/**
	 * Column Info
	 * @param dest
	 */
	public void setDest(String dest) {
		this.dest = dest;
	}

	/**
	 * Column Info
	 * @param destDesc
	 */
	public void setDestDesc(String destDesc) {
		this.destDesc = destDesc;
	}
	
	/**
	 * Column Info
	 * @param trspCostDtlModCd
	 */
	public void setTrspCostDtlModCd(String trspCostDtlModCd) {
		this.trspCostDtlModCd = trspCostDtlModCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * 
	 * @return
	 */
	public String getTrspBndCd() {
		return trspBndCd;
	}

	/**
	 * 
	 * @param trspBndCd
	 */
	public void setTrspBndCd(String trspBndCd) {
		this.trspBndCd = trspBndCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setNtfy(JSPUtil.getParameter(request, prefix + "ntfy", ""));
		setStkIssCd(JSPUtil.getParameter(request, prefix + "stk_iss_cd", ""));
		setCb(JSPUtil.getParameter(request, prefix + "cb", ""));
		setMtyCyDesc(JSPUtil.getParameter(request, prefix + "mty_cy_desc", ""));
		setTp(JSPUtil.getParameter(request, prefix + "tp", ""));
		setCgoTpCd(JSPUtil.getParameter(request, prefix + "cgo_tp_cd", ""));
		setDrInd(JSPUtil.getParameter(request, prefix + "dr_ind", ""));
		setType(JSPUtil.getParameter(request, prefix + "type", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCntrRtnYdCd(JSPUtil.getParameter(request, prefix + "cntr_rtn_yd_cd", ""));
		setHaulType(JSPUtil.getParameter(request, prefix + "haul_type", ""));
		setSpclInst(JSPUtil.getParameter(request, prefix + "spcl_inst", ""));
		setBdDisp(JSPUtil.getParameter(request, prefix + "bd_disp", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setTrspSoTpCd(JSPUtil.getParameter(request, prefix + "trsp_so_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setBd(JSPUtil.getParameter(request, prefix + "bd", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setVvdEta(JSPUtil.getParameter(request, prefix + "vvd_eta", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setStkJbSeq(JSPUtil.getParameter(request, prefix + "stk_jb_seq", ""));
		setVslName(JSPUtil.getParameter(request, prefix + "vsl_name", ""));
		setEqrelLoc(JSPUtil.getParameter(request, prefix + "eqrel_loc", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setUserOfc(JSPUtil.getParameter(request, prefix + "user_ofc", ""));
		setRfInd(JSPUtil.getParameter(request, prefix + "rf_ind", ""));
		setEmail(JSPUtil.getParameter(request, prefix + "email", ""));
		setYdNm(JSPUtil.getParameter(request, prefix + "yd_nm", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
		setFaxSndNo(JSPUtil.getParameter(request, prefix + "fax_snd_no", ""));
		setVvdEtd(JSPUtil.getParameter(request, prefix + "vvd_etd", ""));
		setEqrelName(JSPUtil.getParameter(request, prefix + "eqrel_name", ""));
		setSP(JSPUtil.getParameter(request, prefix + "s_p", ""));
		setConsortVoy(JSPUtil.getParameter(request, prefix + "consort_voy", ""));
		setSoSeq(JSPUtil.getParameter(request, prefix + "so_seq", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setPodDesc(JSPUtil.getParameter(request, prefix + "pod_desc", ""));
		setSendKey(JSPUtil.getParameter(request, prefix + "send_key", ""));
		setModeCd(JSPUtil.getParameter(request, prefix + "mode_cd", ""));
		setPolDesc(JSPUtil.getParameter(request, prefix + "pol_desc", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVslCall(JSPUtil.getParameter(request, prefix + "vsl_call", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setVslLoyd(JSPUtil.getParameter(request, prefix + "vsl_loyd", ""));
		setMsgId(JSPUtil.getParameter(request, prefix + "msg_id", ""));
		setAkInd(JSPUtil.getParameter(request, prefix + "ak_ind", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setTrspSoStsCd(JSPUtil.getParameter(request, prefix + "trsp_so_sts_cd", ""));
		setShipOpr(JSPUtil.getParameter(request, prefix + "ship_opr", ""));
		setPdDate(JSPUtil.getParameter(request, prefix + "pd_date", ""));
		setEmptyCy(JSPUtil.getParameter(request, prefix + "empty_cy", ""));
		setIssueDt(JSPUtil.getParameter(request, prefix + "issue_dt", ""));
		setTypeDisp(JSPUtil.getParameter(request, prefix + "type_disp", ""));
		setOffice(JSPUtil.getParameter(request, prefix + "office", ""));
		setFaxEmailRst(JSPUtil.getParameter(request, prefix + "fax_email_rst", ""));
		setSoOfcCtyCd(JSPUtil.getParameter(request, prefix + "so_ofc_cty_cd", ""));
		setEqresLoc(JSPUtil.getParameter(request, prefix + "eqres_loc", ""));
		setOrgEmptyCy(JSPUtil.getParameter(request, prefix + "org_empty_cy", ""));
		setEmptyDest(JSPUtil.getParameter(request, prefix + "empty_dest", ""));
		setEqres(JSPUtil.getParameter(request, prefix + "eqres", ""));
		setPdDateDisp(JSPUtil.getParameter(request, prefix + "pd_date_disp", ""));
		setEqrel(JSPUtil.getParameter(request, prefix + "eqrel", ""));
		setCntrPkupDt(JSPUtil.getParameter(request, prefix + "cntr_pkup_dt", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setIOffice(JSPUtil.getParameter(request, prefix + "i_office", ""));
		setCnee(JSPUtil.getParameter(request, prefix + "cnee", ""));
		setEqresName(JSPUtil.getParameter(request, prefix + "eqres_name", ""));
		setShpr(JSPUtil.getParameter(request, prefix + "shpr", ""));
		setTypeCd(JSPUtil.getParameter(request, prefix + "type_cd", ""));
		setStkOfcCd(JSPUtil.getParameter(request, prefix + "stk_ofc_cd", ""));
		setEppRef(JSPUtil.getParameter(request, prefix + "epp_ref", ""));
		setDest(JSPUtil.getParameter(request, prefix + "dest", ""));
		setDestDesc(JSPUtil.getParameter(request, prefix + "dest_desc", ""));
		setTrspBndCd(JSPUtil.getParameter(request, prefix + "trsp_bnd_cd", ""));
		setTrspCostDtlModCd(JSPUtil.getParameter(request, prefix + "trsp_cost_dtl_mod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchRelredMasterForEdiVO[]
	 */
	public SearchRelredMasterForEdiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchRelredMasterForEdiVO[]
	 */
	public SearchRelredMasterForEdiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchRelredMasterForEdiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ntfy = (JSPUtil.getParameter(request, prefix	+ "ntfy", length));
			String[] stkIssCd = (JSPUtil.getParameter(request, prefix	+ "stk_iss_cd", length));
			String[] cb = (JSPUtil.getParameter(request, prefix	+ "cb", length));
			String[] mtyCyDesc = (JSPUtil.getParameter(request, prefix	+ "mty_cy_desc", length));
			String[] tp = (JSPUtil.getParameter(request, prefix	+ "tp", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			String[] drInd = (JSPUtil.getParameter(request, prefix	+ "dr_ind", length));
			String[] type = (JSPUtil.getParameter(request, prefix	+ "type", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "cntr_rtn_yd_cd", length));
			String[] haulType = (JSPUtil.getParameter(request, prefix	+ "haul_type", length));
			String[] spclInst = (JSPUtil.getParameter(request, prefix	+ "spcl_inst", length));
			String[] bdDisp = (JSPUtil.getParameter(request, prefix	+ "bd_disp", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] trspSoTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] bd = (JSPUtil.getParameter(request, prefix	+ "bd", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] vvdEta = (JSPUtil.getParameter(request, prefix	+ "vvd_eta", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] stkJbSeq = (JSPUtil.getParameter(request, prefix	+ "stk_jb_seq", length));
			String[] vslName = (JSPUtil.getParameter(request, prefix	+ "vsl_name", length));
			String[] eqrelLoc = (JSPUtil.getParameter(request, prefix	+ "eqrel_loc", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] userOfc = (JSPUtil.getParameter(request, prefix	+ "user_ofc", length));
			String[] rfInd = (JSPUtil.getParameter(request, prefix	+ "rf_ind", length));
			String[] email = (JSPUtil.getParameter(request, prefix	+ "email", length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] faxSndNo = (JSPUtil.getParameter(request, prefix	+ "fax_snd_no", length));
			String[] vvdEtd = (JSPUtil.getParameter(request, prefix	+ "vvd_etd", length));
			String[] eqrelName = (JSPUtil.getParameter(request, prefix	+ "eqrel_name", length));
			String[] sP = (JSPUtil.getParameter(request, prefix	+ "s_p", length));
			String[] consortVoy = (JSPUtil.getParameter(request, prefix	+ "consort_voy", length));
			String[] soSeq = (JSPUtil.getParameter(request, prefix	+ "so_seq", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] podDesc = (JSPUtil.getParameter(request, prefix	+ "pod_desc", length));
			String[] sendKey = (JSPUtil.getParameter(request, prefix	+ "send_key", length));
			String[] modeCd = (JSPUtil.getParameter(request, prefix	+ "mode_cd", length));
			String[] polDesc = (JSPUtil.getParameter(request, prefix	+ "pol_desc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslCall = (JSPUtil.getParameter(request, prefix	+ "vsl_call", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] vslLoyd = (JSPUtil.getParameter(request, prefix	+ "vsl_loyd", length));
			String[] msgId = (JSPUtil.getParameter(request, prefix	+ "msg_id", length));
			String[] akInd = (JSPUtil.getParameter(request, prefix	+ "ak_ind", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] trspSoStsCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_sts_cd", length));
			String[] shipOpr = (JSPUtil.getParameter(request, prefix	+ "ship_opr", length));
			String[] pdDate = (JSPUtil.getParameter(request, prefix	+ "pd_date", length));
			String[] emptyCy = (JSPUtil.getParameter(request, prefix	+ "empty_cy", length));
			String[] issueDt = (JSPUtil.getParameter(request, prefix	+ "issue_dt", length));
			String[] typeDisp = (JSPUtil.getParameter(request, prefix	+ "type_disp", length));
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office", length));
			String[] faxEmailRst = (JSPUtil.getParameter(request, prefix	+ "fax_email_rst", length));
			String[] soOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "so_ofc_cty_cd", length));
			String[] eqresLoc = (JSPUtil.getParameter(request, prefix	+ "eqres_loc", length));
			String[] orgEmptyCy = (JSPUtil.getParameter(request, prefix	+ "org_empty_cy", length));
			String[] emptyDest = (JSPUtil.getParameter(request, prefix	+ "empty_dest", length));
			String[] eqres = (JSPUtil.getParameter(request, prefix	+ "eqres", length));
			String[] pdDateDisp = (JSPUtil.getParameter(request, prefix	+ "pd_date_disp", length));
			String[] eqrel = (JSPUtil.getParameter(request, prefix	+ "eqrel", length));
			String[] cntrPkupDt = (JSPUtil.getParameter(request, prefix	+ "cntr_pkup_dt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] iOffice = (JSPUtil.getParameter(request, prefix	+ "i_office", length));
			String[] cnee = (JSPUtil.getParameter(request, prefix	+ "cnee", length));
			String[] eqresName = (JSPUtil.getParameter(request, prefix	+ "eqres_name", length));
			String[] shpr = (JSPUtil.getParameter(request, prefix	+ "shpr", length));
			String[] typeCd = (JSPUtil.getParameter(request, prefix	+ "type_cd", length));
			String[] stkOfcCd = (JSPUtil.getParameter(request, prefix	+ "stk_ofc_cd", length));
			String[] eppRef = (JSPUtil.getParameter(request, prefix	+ "epp_ref", length));
			String[] dest = (JSPUtil.getParameter(request, prefix	+ "dest", length));
			String[] destDesc = (JSPUtil.getParameter(request, prefix	+ "dest_desc", length));
			String[] trspBndCd = (JSPUtil.getParameter(request, prefix	+ "trsp_bnd_cd", length));
			String[] trspCostDtlModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_cost_dtl_mod_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchRelredMasterForEdiVO();
				if (ntfy[i] != null)
					model.setNtfy(ntfy[i]);
				if (stkIssCd[i] != null)
					model.setStkIssCd(stkIssCd[i]);
				if (cb[i] != null)
					model.setCb(cb[i]);
				if (mtyCyDesc[i] != null)
					model.setMtyCyDesc(mtyCyDesc[i]);
				if (tp[i] != null)
					model.setTp(tp[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (drInd[i] != null)
					model.setDrInd(drInd[i]);
				if (type[i] != null)
					model.setType(type[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrRtnYdCd[i] != null)
					model.setCntrRtnYdCd(cntrRtnYdCd[i]);
				if (haulType[i] != null)
					model.setHaulType(haulType[i]);
				if (spclInst[i] != null)
					model.setSpclInst(spclInst[i]);
				if (bdDisp[i] != null)
					model.setBdDisp(bdDisp[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (trspSoTpCd[i] != null)
					model.setTrspSoTpCd(trspSoTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (bd[i] != null)
					model.setBd(bd[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (vvdEta[i] != null)
					model.setVvdEta(vvdEta[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (stkJbSeq[i] != null)
					model.setStkJbSeq(stkJbSeq[i]);
				if (vslName[i] != null)
					model.setVslName(vslName[i]);
				if (eqrelLoc[i] != null)
					model.setEqrelLoc(eqrelLoc[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (userOfc[i] != null)
					model.setUserOfc(userOfc[i]);
				if (rfInd[i] != null)
					model.setRfInd(rfInd[i]);
				if (email[i] != null)
					model.setEmail(email[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (faxSndNo[i] != null)
					model.setFaxSndNo(faxSndNo[i]);
				if (vvdEtd[i] != null)
					model.setVvdEtd(vvdEtd[i]);
				if (eqrelName[i] != null)
					model.setEqrelName(eqrelName[i]);
				if (sP[i] != null)
					model.setSP(sP[i]);
				if (consortVoy[i] != null)
					model.setConsortVoy(consortVoy[i]);
				if (soSeq[i] != null)
					model.setSoSeq(soSeq[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (podDesc[i] != null)
					model.setPodDesc(podDesc[i]);
				if (sendKey[i] != null)
					model.setSendKey(sendKey[i]);
				if (modeCd[i] != null)
					model.setModeCd(modeCd[i]);
				if (polDesc[i] != null)
					model.setPolDesc(polDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslCall[i] != null)
					model.setVslCall(vslCall[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (vslLoyd[i] != null)
					model.setVslLoyd(vslLoyd[i]);
				if (msgId[i] != null)
					model.setMsgId(msgId[i]);
				if (akInd[i] != null)
					model.setAkInd(akInd[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (trspSoStsCd[i] != null)
					model.setTrspSoStsCd(trspSoStsCd[i]);
				if (shipOpr[i] != null)
					model.setShipOpr(shipOpr[i]);
				if (pdDate[i] != null)
					model.setPdDate(pdDate[i]);
				if (emptyCy[i] != null)
					model.setEmptyCy(emptyCy[i]);
				if (issueDt[i] != null)
					model.setIssueDt(issueDt[i]);
				if (typeDisp[i] != null)
					model.setTypeDisp(typeDisp[i]);
				if (office[i] != null)
					model.setOffice(office[i]);
				if (faxEmailRst[i] != null)
					model.setFaxEmailRst(faxEmailRst[i]);
				if (soOfcCtyCd[i] != null)
					model.setSoOfcCtyCd(soOfcCtyCd[i]);
				if (eqresLoc[i] != null)
					model.setEqresLoc(eqresLoc[i]);
				if (orgEmptyCy[i] != null)
					model.setOrgEmptyCy(orgEmptyCy[i]);
				if (emptyDest[i] != null)
					model.setEmptyDest(emptyDest[i]);
				if (eqres[i] != null)
					model.setEqres(eqres[i]);
				if (pdDateDisp[i] != null)
					model.setPdDateDisp(pdDateDisp[i]);
				if (eqrel[i] != null)
					model.setEqrel(eqrel[i]);
				if (cntrPkupDt[i] != null)
					model.setCntrPkupDt(cntrPkupDt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (iOffice[i] != null)
					model.setIOffice(iOffice[i]);
				if (cnee[i] != null)
					model.setCnee(cnee[i]);
				if (eqresName[i] != null)
					model.setEqresName(eqresName[i]);
				if (shpr[i] != null)
					model.setShpr(shpr[i]);
				if (typeCd[i] != null)
					model.setTypeCd(typeCd[i]);
				if (stkOfcCd[i] != null)
					model.setStkOfcCd(stkOfcCd[i]);
				if (eppRef[i] != null)
					model.setEppRef(eppRef[i]);
				if (dest[i] != null)
					model.setDest(dest[i]);
				if (destDesc[i] != null)
					model.setDestDesc(destDesc[i]);
				if (trspBndCd[i] != null)
					model.setTrspBndCd(trspBndCd[i]);
				if (trspCostDtlModCd[i] != null)
					model.setTrspCostDtlModCd(trspCostDtlModCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchRelredMasterForEdiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchRelredMasterForEdiVO[]
	 */
	public SearchRelredMasterForEdiVO[] getSearchRelredMasterForEdiVOs(){
		SearchRelredMasterForEdiVO[] vos = (SearchRelredMasterForEdiVO[])models.toArray(new SearchRelredMasterForEdiVO[models.size()]);
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
		this.ntfy = this.ntfy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stkIssCd = this.stkIssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cb = this.cb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyCyDesc = this.mtyCyDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tp = this.tp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drInd = this.drInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type = this.type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRtnYdCd = this.cntrRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.haulType = this.haulType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclInst = this.spclInst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdDisp = this.bdDisp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoTpCd = this.trspSoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bd = this.bd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdEta = this.vvdEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stkJbSeq = this.stkJbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslName = this.vslName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqrelLoc = this.eqrelLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userOfc = this.userOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfInd = this.rfInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.email = this.email .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndNo = this.faxSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdEtd = this.vvdEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqrelName = this.eqrelName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sP = this.sP .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consortVoy = this.consortVoy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soSeq = this.soSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podDesc = this.podDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendKey = this.sendKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modeCd = this.modeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polDesc = this.polDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCall = this.vslCall .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLoyd = this.vslLoyd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgId = this.msgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akInd = this.akInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoStsCd = this.trspSoStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipOpr = this.shipOpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pdDate = this.pdDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emptyCy = this.emptyCy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueDt = this.issueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeDisp = this.typeDisp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxEmailRst = this.faxEmailRst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soOfcCtyCd = this.soOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqresLoc = this.eqresLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgEmptyCy = this.orgEmptyCy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emptyDest = this.emptyDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqres = this.eqres .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pdDateDisp = this.pdDateDisp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqrel = this.eqrel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkupDt = this.cntrPkupDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iOffice = this.iOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee = this.cnee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqresName = this.eqresName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr = this.shpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeCd = this.typeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stkOfcCd = this.stkOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eppRef = this.eppRef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dest = this.dest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destDesc = this.destDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspBndCd = this.trspBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostDtlModCd = this.trspCostDtlModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

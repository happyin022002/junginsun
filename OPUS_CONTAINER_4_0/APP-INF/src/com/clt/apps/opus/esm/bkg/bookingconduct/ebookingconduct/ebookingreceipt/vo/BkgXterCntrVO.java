/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BkgXterCntrVO.java
*@FileTitle : BkgXterCntrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
public class BkgXterCntrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgXterCntrVO> models = new ArrayList<BkgXterCntrVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String xterSndrId = null;

	/* Column Info */
	private String xterRqstNo = null;

	/* Column Info */
	private String xterRqstSeq = null;

	/* Column Info */
	private String cntrNo = null;

	/* Column Info */
	private String cntrSeq = null;

	/* Column Info */
	private String cntrTpszCd = null;

	/* Column Info */
	private String pckQty = null;

	/* Column Info */
	private String pckTpCd = null;

	/* Column Info */
	private String cntrWgt = null;

	/* Column Info */
	private String wgtUtCd = null;

	/* Column Info */
	private String measQty = null;

	/* Column Info */
	private String measUtCd = null;

	/* Column Info */
	private String socFlg = null;

	/* Column Info */
	private String prtFlg = null;

	/* Column Info */
	private String cstFlg = null;

	/* Column Info */
	private String shpRefNo = null;

	/* Column Info */
	private String poNo = null;

	/* Column Info */
	private String creUsrId = null;

	/* Column Info */
	private String creDt = null;

	/* Column Info */
	private String updUsrId = null;

	/* Column Info */
	private String updDt = null;

	/* Column Info */
	private String netWgtQty = null;

	/* Column Info */
	private String netWgtUtCd = null;

	/* Column Info */
	private String obHlgTpCd = null;

	/* Column Info */
	private String ibHlgTpCd = null;

	/* Column Info */
	private String edwUpdDt = null;

	/* Column Info */
	private String vgmDocIdNo = null;

	/* Column Info */
	private String vgmWgt = null;

	/* Column Info */
	private String vgmWgtUtCd = null;

	/* Column Info */
	private String vgmDocTpCd = null;

	/* Column Info */
	private String vgmDtTpCd = null;

	/* Column Info */
	private String vgmHndlDt = null;

	/* Column Info */
	private String vgmCustCntcTpCd = null;

	/* Column Info */
	private String vgmCustCntcNm = null;

	/* Column Info */
	private String vgmCustFaxNo = null;

	/* Column Info */
	private String vgmCustEml = null;

	/* Column Info */
	private String vgmCustPhnNo = null;

	/* Column Info */
	private String vgmCustAddr = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgXterCntrVO() {}

	public BkgXterCntrVO(String ibflag, String pagerows, String xterSndrId, String xterRqstNo, String xterRqstSeq, String cntrNo, String cntrSeq, String cntrTpszCd, String pckQty, String pckTpCd, String cntrWgt, String wgtUtCd, String measQty, String measUtCd, String socFlg, String prtFlg, String cstFlg, String shpRefNo, String poNo, String creUsrId, String creDt, String updUsrId, String updDt, String netWgtQty, String netWgtUtCd, String obHlgTpCd, String ibHlgTpCd, String edwUpdDt, String vgmDocIdNo, String vgmWgt, String vgmWgtUtCd, String vgmDocTpCd, String vgmDtTpCd, String vgmHndlDt, String vgmCustCntcTpCd, String vgmCustCntcNm, String vgmCustFaxNo, String vgmCustEml, String vgmCustPhnNo, String vgmCustAddr) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.xterSndrId = xterSndrId;
		this.xterRqstNo = xterRqstNo;
		this.xterRqstSeq = xterRqstSeq;
		this.cntrNo = cntrNo;
		this.cntrSeq = cntrSeq;
		this.cntrTpszCd = cntrTpszCd;
		this.pckQty = pckQty;
		this.pckTpCd = pckTpCd;
		this.cntrWgt = cntrWgt;
		this.wgtUtCd = wgtUtCd;
		this.measQty = measQty;
		this.measUtCd = measUtCd;
		this.socFlg = socFlg;
		this.prtFlg = prtFlg;
		this.cstFlg = cstFlg;
		this.shpRefNo = shpRefNo;
		this.poNo = poNo;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.netWgtQty = netWgtQty;
		this.netWgtUtCd = netWgtUtCd;
		this.obHlgTpCd = obHlgTpCd;
		this.ibHlgTpCd = ibHlgTpCd;
		this.edwUpdDt = edwUpdDt;
		this.vgmDocIdNo = vgmDocIdNo;
		this.vgmWgt = vgmWgt;
		this.vgmWgtUtCd = vgmWgtUtCd;
		this.vgmDocTpCd = vgmDocTpCd;
		this.vgmDtTpCd = vgmDtTpCd;
		this.vgmHndlDt = vgmHndlDt;
		this.vgmCustCntcTpCd = vgmCustCntcTpCd;
		this.vgmCustCntcNm = vgmCustCntcNm;
		this.vgmCustFaxNo = vgmCustFaxNo;
		this.vgmCustEml = vgmCustEml;
		this.vgmCustPhnNo = vgmCustPhnNo;
		this.vgmCustAddr = vgmCustAddr;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("xter_sndr_id", getXterSndrId());
		this.hashColumns.put("xter_rqst_no", getXterRqstNo());
		this.hashColumns.put("xter_rqst_seq", getXterRqstSeq());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_seq", getCntrSeq());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("prt_flg", getPrtFlg());
		this.hashColumns.put("cst_flg", getCstFlg());
		this.hashColumns.put("shp_ref_no", getShpRefNo());
		this.hashColumns.put("po_no", getPoNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("net_wgt_qty", getNetWgtQty());
		this.hashColumns.put("net_wgt_ut_cd", getNetWgtUtCd());
		this.hashColumns.put("ob_hlg_tp_cd", getObHlgTpCd());
		this.hashColumns.put("ib_hlg_tp_cd", getIbHlgTpCd());
		this.hashColumns.put("edw_upd_dt", getEdwUpdDt());
		this.hashColumns.put("vgm_doc_id_no", getVgmDocIdNo());
		this.hashColumns.put("vgm_wgt", getVgmWgt());
		this.hashColumns.put("vgm_wgt_ut_cd", getVgmWgtUtCd());
		this.hashColumns.put("vgm_doc_tp_cd", getVgmDocTpCd());
		this.hashColumns.put("vgm_dt_tp_cd", getVgmDtTpCd());
		this.hashColumns.put("vgm_hndl_dt", getVgmHndlDt());
		this.hashColumns.put("vgm_cust_cntc_tp_cd", getVgmCustCntcTpCd());
		this.hashColumns.put("vgm_cust_cntc_nm", getVgmCustCntcNm());
		this.hashColumns.put("vgm_cust_fax_no", getVgmCustFaxNo());
		this.hashColumns.put("vgm_cust_eml", getVgmCustEml());
		this.hashColumns.put("vgm_cust_phn_no", getVgmCustPhnNo());
		this.hashColumns.put("vgm_cust_addr", getVgmCustAddr());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("xter_sndr_id", "xterSndrId");
		this.hashFields.put("xter_rqst_no", "xterRqstNo");
		this.hashFields.put("xter_rqst_seq", "xterRqstSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_seq", "cntrSeq");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("prt_flg", "prtFlg");
		this.hashFields.put("cst_flg", "cstFlg");
		this.hashFields.put("shp_ref_no", "shpRefNo");
		this.hashFields.put("po_no", "poNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("net_wgt_qty", "netWgtQty");
		this.hashFields.put("net_wgt_ut_cd", "netWgtUtCd");
		this.hashFields.put("ob_hlg_tp_cd", "obHlgTpCd");
		this.hashFields.put("ib_hlg_tp_cd", "ibHlgTpCd");
		this.hashFields.put("edw_upd_dt", "edwUpdDt");
		this.hashFields.put("vgm_doc_id_no", "vgmDocIdNo");
		this.hashFields.put("vgm_wgt", "vgmWgt");
		this.hashFields.put("vgm_wgt_ut_cd", "vgmWgtUtCd");
		this.hashFields.put("vgm_doc_tp_cd", "vgmDocTpCd");
		this.hashFields.put("vgm_dt_tp_cd", "vgmDtTpCd");
		this.hashFields.put("vgm_hndl_dt", "vgmHndlDt");
		this.hashFields.put("vgm_cust_cntc_tp_cd", "vgmCustCntcTpCd");
		this.hashFields.put("vgm_cust_cntc_nm", "vgmCustCntcNm");
		this.hashFields.put("vgm_cust_fax_no", "vgmCustFaxNo");
		this.hashFields.put("vgm_cust_eml", "vgmCustEml");
		this.hashFields.put("vgm_cust_phn_no", "vgmCustPhnNo");
		this.hashFields.put("vgm_cust_addr", "vgmCustAddr");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String xterSndrId
	 */
	public void setXterSndrId(String xterSndrId) {
		this.xterSndrId = xterSndrId;
	}
	
	/**
	 * 
	 * @return String xterSndrId
	 */
	public String getXterSndrId() {
		return this.xterSndrId;
	}
	
	/**
	 *
	 * @param String xterRqstNo
	 */
	public void setXterRqstNo(String xterRqstNo) {
		this.xterRqstNo = xterRqstNo;
	}
	
	/**
	 * 
	 * @return String xterRqstNo
	 */
	public String getXterRqstNo() {
		return this.xterRqstNo;
	}
	
	/**
	 *
	 * @param String xterRqstSeq
	 */
	public void setXterRqstSeq(String xterRqstSeq) {
		this.xterRqstSeq = xterRqstSeq;
	}
	
	/**
	 * 
	 * @return String xterRqstSeq
	 */
	public String getXterRqstSeq() {
		return this.xterRqstSeq;
	}
	
	/**
	 *
	 * @param String cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * 
	 * @return String cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 *
	 * @param String cntrSeq
	 */
	public void setCntrSeq(String cntrSeq) {
		this.cntrSeq = cntrSeq;
	}
	
	/**
	 * 
	 * @return String cntrSeq
	 */
	public String getCntrSeq() {
		return this.cntrSeq;
	}
	
	/**
	 *
	 * @param String cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * 
	 * @return String cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 *
	 * @param String pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * 
	 * @return String pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 *
	 * @param String pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * 
	 * @return String pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 *
	 * @param String cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}
	
	/**
	 * 
	 * @return String cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}
	
	/**
	 *
	 * @param String wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * 
	 * @return String wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 *
	 * @param String measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}
	
	/**
	 * 
	 * @return String measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}
	
	/**
	 *
	 * @param String measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
	}
	
	/**
	 * 
	 * @return String measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
	}
	
	/**
	 *
	 * @param String socFlg
	 */
	public void setSocFlg(String socFlg) {
		this.socFlg = socFlg;
	}
	
	/**
	 * 
	 * @return String socFlg
	 */
	public String getSocFlg() {
		return this.socFlg;
	}
	
	/**
	 *
	 * @param String prtFlg
	 */
	public void setPrtFlg(String prtFlg) {
		this.prtFlg = prtFlg;
	}
	
	/**
	 * 
	 * @return String prtFlg
	 */
	public String getPrtFlg() {
		return this.prtFlg;
	}
	
	/**
	 *
	 * @param String cstFlg
	 */
	public void setCstFlg(String cstFlg) {
		this.cstFlg = cstFlg;
	}
	
	/**
	 * 
	 * @return String cstFlg
	 */
	public String getCstFlg() {
		return this.cstFlg;
	}
	
	/**
	 *
	 * @param String shpRefNo
	 */
	public void setShpRefNo(String shpRefNo) {
		this.shpRefNo = shpRefNo;
	}
	
	/**
	 * 
	 * @return String shpRefNo
	 */
	public String getShpRefNo() {
		return this.shpRefNo;
	}
	
	/**
	 *
	 * @param String poNo
	 */
	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}
	
	/**
	 * 
	 * @return String poNo
	 */
	public String getPoNo() {
		return this.poNo;
	}
	
	/**
	 *
	 * @param String creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * 
	 * @return String creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 *
	 * @param String creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * 
	 * @return String creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 *
	 * @param String updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 
	 * @return String updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 *
	 * @param String updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * 
	 * @return String updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 *
	 * @param String netWgtQty
	 */
	public void setNetWgtQty(String netWgtQty) {
		this.netWgtQty = netWgtQty;
	}
	
	/**
	 * 
	 * @return String netWgtQty
	 */
	public String getNetWgtQty() {
		return this.netWgtQty;
	}
	
	/**
	 *
	 * @param String netWgtUtCd
	 */
	public void setNetWgtUtCd(String netWgtUtCd) {
		this.netWgtUtCd = netWgtUtCd;
	}
	
	/**
	 * 
	 * @return String netWgtUtCd
	 */
	public String getNetWgtUtCd() {
		return this.netWgtUtCd;
	}
	
	/**
	 *
	 * @param String obHlgTpCd
	 */
	public void setObHlgTpCd(String obHlgTpCd) {
		this.obHlgTpCd = obHlgTpCd;
	}
	
	/**
	 * 
	 * @return String obHlgTpCd
	 */
	public String getObHlgTpCd() {
		return this.obHlgTpCd;
	}
	
	/**
	 *
	 * @param String ibHlgTpCd
	 */
	public void setIbHlgTpCd(String ibHlgTpCd) {
		this.ibHlgTpCd = ibHlgTpCd;
	}
	
	/**
	 * 
	 * @return String ibHlgTpCd
	 */
	public String getIbHlgTpCd() {
		return this.ibHlgTpCd;
	}
	
	/**
	 *
	 * @param String edwUpdDt
	 */
	public void setEdwUpdDt(String edwUpdDt) {
		this.edwUpdDt = edwUpdDt;
	}
	
	/**
	 * 
	 * @return String edwUpdDt
	 */
	public String getEdwUpdDt() {
		return this.edwUpdDt;
	}
	
	/**
	 *
	 * @param String vgmDocIdNo
	 */
	public void setVgmDocIdNo(String vgmDocIdNo) {
		this.vgmDocIdNo = vgmDocIdNo;
	}
	
	/**
	 * 
	 * @return String vgmDocIdNo
	 */
	public String getVgmDocIdNo() {
		return this.vgmDocIdNo;
	}
	
	/**
	 *
	 * @param String vgmWgt
	 */
	public void setVgmWgt(String vgmWgt) {
		this.vgmWgt = vgmWgt;
	}
	
	/**
	 * 
	 * @return String vgmWgt
	 */
	public String getVgmWgt() {
		return this.vgmWgt;
	}
	
	/**
	 *
	 * @param String vgmWgtUtCd
	 */
	public void setVgmWgtUtCd(String vgmWgtUtCd) {
		this.vgmWgtUtCd = vgmWgtUtCd;
	}
	
	/**
	 * 
	 * @return String vgmWgtUtCd
	 */
	public String getVgmWgtUtCd() {
		return this.vgmWgtUtCd;
	}
	
	/**
	 *
	 * @param String vgmDocTpCd
	 */
	public void setVgmDocTpCd(String vgmDocTpCd) {
		this.vgmDocTpCd = vgmDocTpCd;
	}
	
	/**
	 * 
	 * @return String vgmDocTpCd
	 */
	public String getVgmDocTpCd() {
		return this.vgmDocTpCd;
	}
	
	/**
	 *
	 * @param String vgmDtTpCd
	 */
	public void setVgmDtTpCd(String vgmDtTpCd) {
		this.vgmDtTpCd = vgmDtTpCd;
	}
	
	/**
	 * 
	 * @return String vgmDtTpCd
	 */
	public String getVgmDtTpCd() {
		return this.vgmDtTpCd;
	}
	
	/**
	 *
	 * @param String vgmHndlDt
	 */
	public void setVgmHndlDt(String vgmHndlDt) {
		this.vgmHndlDt = vgmHndlDt;
	}
	
	/**
	 * 
	 * @return String vgmHndlDt
	 */
	public String getVgmHndlDt() {
		return this.vgmHndlDt;
	}
	
	/**
	 *
	 * @param String vgmCustCntcTpCd
	 */
	public void setVgmCustCntcTpCd(String vgmCustCntcTpCd) {
		this.vgmCustCntcTpCd = vgmCustCntcTpCd;
	}
	
	/**
	 * 
	 * @return String vgmCustCntcTpCd
	 */
	public String getVgmCustCntcTpCd() {
		return this.vgmCustCntcTpCd;
	}
	
	/**
	 *
	 * @param String vgmCustCntcNm
	 */
	public void setVgmCustCntcNm(String vgmCustCntcNm) {
		this.vgmCustCntcNm = vgmCustCntcNm;
	}
	
	/**
	 * 
	 * @return String vgmCustCntcNm
	 */
	public String getVgmCustCntcNm() {
		return this.vgmCustCntcNm;
	}
	
	/**
	 *
	 * @param String vgmCustFaxNo
	 */
	public void setVgmCustFaxNo(String vgmCustFaxNo) {
		this.vgmCustFaxNo = vgmCustFaxNo;
	}
	
	/**
	 * 
	 * @return String vgmCustFaxNo
	 */
	public String getVgmCustFaxNo() {
		return this.vgmCustFaxNo;
	}
	
	/**
	 *
	 * @param String vgmCustEml
	 */
	public void setVgmCustEml(String vgmCustEml) {
		this.vgmCustEml = vgmCustEml;
	}
	
	/**
	 * 
	 * @return String vgmCustEml
	 */
	public String getVgmCustEml() {
		return this.vgmCustEml;
	}
	
	/**
	 *
	 * @param String vgmCustPhnNo
	 */
	public void setVgmCustPhnNo(String vgmCustPhnNo) {
		this.vgmCustPhnNo = vgmCustPhnNo;
	}
	
	/**
	 * 
	 * @return String vgmCustPhnNo
	 */
	public String getVgmCustPhnNo() {
		return this.vgmCustPhnNo;
	}
	
	/**
	 *
	 * @param String vgmCustAddr
	 */
	public void setVgmCustAddr(String vgmCustAddr) {
		this.vgmCustAddr = vgmCustAddr;
	}
	
	/**
	 * 
	 * @return String vgmCustAddr
	 */
	public String getVgmCustAddr() {
		return this.vgmCustAddr;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setXterSndrId(JSPUtil.getParameter(request, prefix + "xter_sndr_id", ""));
		setXterRqstNo(JSPUtil.getParameter(request, prefix + "xter_rqst_no", ""));
		setXterRqstSeq(JSPUtil.getParameter(request, prefix + "xter_rqst_seq", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrSeq(JSPUtil.getParameter(request, prefix + "cntr_seq", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setSocFlg(JSPUtil.getParameter(request, prefix + "soc_flg", ""));
		setPrtFlg(JSPUtil.getParameter(request, prefix + "prt_flg", ""));
		setCstFlg(JSPUtil.getParameter(request, prefix + "cst_flg", ""));
		setShpRefNo(JSPUtil.getParameter(request, prefix + "shp_ref_no", ""));
		setPoNo(JSPUtil.getParameter(request, prefix + "po_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setNetWgtQty(JSPUtil.getParameter(request, prefix + "net_wgt_qty", ""));
		setNetWgtUtCd(JSPUtil.getParameter(request, prefix + "net_wgt_ut_cd", ""));
		setObHlgTpCd(JSPUtil.getParameter(request, prefix + "ob_hlg_tp_cd", ""));
		setIbHlgTpCd(JSPUtil.getParameter(request, prefix + "ib_hlg_tp_cd", ""));
		setEdwUpdDt(JSPUtil.getParameter(request, prefix + "edw_upd_dt", ""));
		setVgmDocIdNo(JSPUtil.getParameter(request, prefix + "vgm_doc_id_no", ""));
		setVgmWgt(JSPUtil.getParameter(request, prefix + "vgm_wgt", ""));
		setVgmWgtUtCd(JSPUtil.getParameter(request, prefix + "vgm_wgt_ut_cd", ""));
		setVgmDocTpCd(JSPUtil.getParameter(request, prefix + "vgm_doc_tp_cd", ""));
		setVgmDtTpCd(JSPUtil.getParameter(request, prefix + "vgm_dt_tp_cd", ""));
		setVgmHndlDt(JSPUtil.getParameter(request, prefix + "vgm_hndl_dt", ""));
		setVgmCustCntcTpCd(JSPUtil.getParameter(request, prefix + "vgm_cust_cntc_tp_cd", ""));
		setVgmCustCntcNm(JSPUtil.getParameter(request, prefix + "vgm_cust_cntc_nm", ""));
		setVgmCustFaxNo(JSPUtil.getParameter(request, prefix + "vgm_cust_fax_no", ""));
		setVgmCustEml(JSPUtil.getParameter(request, prefix + "vgm_cust_eml", ""));
		setVgmCustPhnNo(JSPUtil.getParameter(request, prefix + "vgm_cust_phn_no", ""));
		setVgmCustAddr(JSPUtil.getParameter(request, prefix + "vgm_cust_addr", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgXterCntrVO[]
	 */
	public BkgXterCntrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgXterCntrVO[]
	 */
	public BkgXterCntrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgXterCntrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] xterSndrId = (JSPUtil.getParameter(request, prefix	+ "xter_sndr_id", length));
			String[] xterRqstNo = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_no", length));
			String[] xterRqstSeq = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_seq", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_seq", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] prtFlg = (JSPUtil.getParameter(request, prefix	+ "prt_flg", length));
			String[] cstFlg = (JSPUtil.getParameter(request, prefix	+ "cst_flg", length));
			String[] shpRefNo = (JSPUtil.getParameter(request, prefix	+ "shp_ref_no", length));
			String[] poNo = (JSPUtil.getParameter(request, prefix	+ "po_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] netWgtQty = (JSPUtil.getParameter(request, prefix	+ "net_wgt_qty", length));
			String[] netWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "net_wgt_ut_cd", length));
			String[] obHlgTpCd = (JSPUtil.getParameter(request, prefix	+ "ob_hlg_tp_cd", length));
			String[] ibHlgTpCd = (JSPUtil.getParameter(request, prefix	+ "ib_hlg_tp_cd", length));
			String[] edwUpdDt = (JSPUtil.getParameter(request, prefix	+ "edw_upd_dt", length));
			String[] vgmDocIdNo = (JSPUtil.getParameter(request, prefix	+ "vgm_doc_id_no", length));
			String[] vgmWgt = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt", length));
			String[] vgmWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt_ut_cd", length));
			String[] vgmDocTpCd = (JSPUtil.getParameter(request, prefix	+ "vgm_doc_tp_cd", length));
			String[] vgmDtTpCd = (JSPUtil.getParameter(request, prefix	+ "vgm_dt_tp_cd", length));
			String[] vgmHndlDt = (JSPUtil.getParameter(request, prefix	+ "vgm_hndl_dt", length));
			String[] vgmCustCntcTpCd = (JSPUtil.getParameter(request, prefix	+ "vgm_cust_cntc_tp_cd", length));
			String[] vgmCustCntcNm = (JSPUtil.getParameter(request, prefix	+ "vgm_cust_cntc_nm", length));
			String[] vgmCustFaxNo = (JSPUtil.getParameter(request, prefix	+ "vgm_cust_fax_no", length));
			String[] vgmCustEml = (JSPUtil.getParameter(request, prefix	+ "vgm_cust_eml", length));
			String[] vgmCustPhnNo = (JSPUtil.getParameter(request, prefix	+ "vgm_cust_phn_no", length));
			String[] vgmCustAddr = (JSPUtil.getParameter(request, prefix	+ "vgm_cust_addr", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new BkgXterCntrVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (xterSndrId[i] != null) 
					model.setXterSndrId(xterSndrId[i]);
				if (xterRqstNo[i] != null) 
					model.setXterRqstNo(xterRqstNo[i]);
				if (xterRqstSeq[i] != null) 
					model.setXterRqstSeq(xterRqstSeq[i]);
				if (cntrNo[i] != null) 
					model.setCntrNo(cntrNo[i]);
				if (cntrSeq[i] != null) 
					model.setCntrSeq(cntrSeq[i]);
				if (cntrTpszCd[i] != null) 
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (pckQty[i] != null) 
					model.setPckQty(pckQty[i]);
				if (pckTpCd[i] != null) 
					model.setPckTpCd(pckTpCd[i]);
				if (cntrWgt[i] != null) 
					model.setCntrWgt(cntrWgt[i]);
				if (wgtUtCd[i] != null) 
					model.setWgtUtCd(wgtUtCd[i]);
				if (measQty[i] != null) 
					model.setMeasQty(measQty[i]);
				if (measUtCd[i] != null) 
					model.setMeasUtCd(measUtCd[i]);
				if (socFlg[i] != null) 
					model.setSocFlg(socFlg[i]);
				if (prtFlg[i] != null) 
					model.setPrtFlg(prtFlg[i]);
				if (cstFlg[i] != null) 
					model.setCstFlg(cstFlg[i]);
				if (shpRefNo[i] != null) 
					model.setShpRefNo(shpRefNo[i]);
				if (poNo[i] != null) 
					model.setPoNo(poNo[i]);
				if (creUsrId[i] != null) 
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null) 
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null) 
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null) 
					model.setUpdDt(updDt[i]);
				if (netWgtQty[i] != null) 
					model.setNetWgtQty(netWgtQty[i]);
				if (netWgtUtCd[i] != null) 
					model.setNetWgtUtCd(netWgtUtCd[i]);
				if (obHlgTpCd[i] != null) 
					model.setObHlgTpCd(obHlgTpCd[i]);
				if (ibHlgTpCd[i] != null) 
					model.setIbHlgTpCd(ibHlgTpCd[i]);
				if (edwUpdDt[i] != null) 
					model.setEdwUpdDt(edwUpdDt[i]);
				if (vgmDocIdNo[i] != null) 
					model.setVgmDocIdNo(vgmDocIdNo[i]);
				if (vgmWgt[i] != null) 
					model.setVgmWgt(vgmWgt[i]);
				if (vgmWgtUtCd[i] != null) 
					model.setVgmWgtUtCd(vgmWgtUtCd[i]);
				if (vgmDocTpCd[i] != null) 
					model.setVgmDocTpCd(vgmDocTpCd[i]);
				if (vgmDtTpCd[i] != null) 
					model.setVgmDtTpCd(vgmDtTpCd[i]);
				if (vgmHndlDt[i] != null) 
					model.setVgmHndlDt(vgmHndlDt[i]);
				if (vgmCustCntcTpCd[i] != null) 
					model.setVgmCustCntcTpCd(vgmCustCntcTpCd[i]);
				if (vgmCustCntcNm[i] != null) 
					model.setVgmCustCntcNm(vgmCustCntcNm[i]);
				if (vgmCustFaxNo[i] != null) 
					model.setVgmCustFaxNo(vgmCustFaxNo[i]);
				if (vgmCustEml[i] != null) 
					model.setVgmCustEml(vgmCustEml[i]);
				if (vgmCustPhnNo[i] != null) 
					model.setVgmCustPhnNo(vgmCustPhnNo[i]);
				if (vgmCustAddr[i] != null) 
					model.setVgmCustAddr(vgmCustAddr[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgXterCntrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgXterCntrVO[]
	 */
	public BkgXterCntrVO[] getBkgXterCntrVOs(){
		BkgXterCntrVO[] vos = (BkgXterCntrVO[])models.toArray(new BkgXterCntrVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterSndrId = this.xterSndrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstNo = this.xterRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstSeq = this.xterRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSeq = this.cntrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtFlg = this.prtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstFlg = this.cstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpRefNo = this.shpRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poNo = this.poNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWgtQty = this.netWgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWgtUtCd = this.netWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obHlgTpCd = this.obHlgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibHlgTpCd = this.ibHlgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edwUpdDt = this.edwUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmDocIdNo = this.vgmDocIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgt = this.vgmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtUtCd = this.vgmWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmDocTpCd = this.vgmDocTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmDtTpCd = this.vgmDtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmHndlDt = this.vgmHndlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCustCntcTpCd = this.vgmCustCntcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCustCntcNm = this.vgmCustCntcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCustFaxNo = this.vgmCustFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCustEml = this.vgmCustEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCustPhnNo = this.vgmCustPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCustAddr = this.vgmCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
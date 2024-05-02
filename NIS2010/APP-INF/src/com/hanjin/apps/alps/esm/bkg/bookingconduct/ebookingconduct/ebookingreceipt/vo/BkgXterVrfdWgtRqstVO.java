/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : BkgXterVrfdWgtRqstVO.java
 *@FileTitle : BkgXterVrfdWgtRqstVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.06.10
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.06.10  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class BkgXterVrfdWgtRqstVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<BkgXterVrfdWgtRqstVO>  models =	new	ArrayList<BkgXterVrfdWgtRqstVO>();


	/*	Column Info	*/
	private  String	 upldDt   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 smtAddr   =  null;
	/*	Column Info	*/
	private  String	 xterSndrId   =  null;
	/*	Column Info	*/
	private  String	 xterVgmRqstNo   =  null;
	/*	Column Info	*/
	private  String	 xterVgmSeq   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 smtDt   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 upldUsrId   =  null;
	/*	Column Info	*/
	private  String	 xterSiRefNo   =  null;
	/*	Column Info	*/
	private  String	 vgmUpldStsCd   =  null;
	/*	Column Info	*/
	private  String	 vgmWgt   =  null;
	/*	Column Info	*/
	private  String	 xterRqstViaCd   =  null;
	/*	Column Info	*/
	private  String	 vgmDtmnDt   =  null;
	/*	Column Info	*/
	private  String	 custId   =  null;
	/*	Column Info	*/
	private  String	 vgmVrfyDt   =  null;
	/*	Column Info	*/
	private  String	 upldGdt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 smtCntcDesc   =  null;
	/*	Column Info	*/
	private  String	 xterCntrSealNo   =  null;
	/*	Column Info	*/
	private  String	 vgmMzdTpCd   =  null;
	/*	Column Info	*/
	private  String	 smtPhnNo   =  null;
	/*	Column Info	*/
	private  String	 rqstDt   =  null;
	/*	Column Info	*/
	private  String	 vgmWgtUtCd   =  null;
	/*	Column Info	*/
	private  String	 xterBkgRqstRefNo   =  null;
	/*	Column Info	*/
	private  String	 rqstDeltFlg   =  null;
	/*	Column Info	*/
	private  String	 rjctRsnRmk   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 vgmEdiTpCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 smtEml   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 smtNm   =  null;
	/*	Column Info	*/
	private  String	 vgmDocId   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public BkgXterVrfdWgtRqstVO(){}

	public BkgXterVrfdWgtRqstVO(String upldDt,String ibflag,String smtAddr,String xterSndrId,String xterVgmRqstNo,String xterVgmSeq,String bkgNo,String smtDt,String updUsrId,String creUsrId,String upldUsrId,String xterSiRefNo,String vgmUpldStsCd,String vgmWgt,String xterRqstViaCd,String vgmDtmnDt,String custId,String vgmVrfyDt,String upldGdt,String pagerows,String smtCntcDesc,String xterCntrSealNo,String vgmMzdTpCd,String smtPhnNo,String rqstDt,String vgmWgtUtCd,String xterBkgRqstRefNo,String rqstDeltFlg,String rjctRsnRmk,String creDt,String vgmEdiTpCd,String cntrTpszCd,String smtEml,String updDt,String cntrNo,String smtNm,String vgmDocId)	{
		this.upldDt  = upldDt ;
		this.ibflag  = ibflag ;
		this.smtAddr  = smtAddr ;
		this.xterSndrId  = xterSndrId ;
		this.xterVgmRqstNo  = xterVgmRqstNo ;
		this.xterVgmSeq  = xterVgmSeq ;
		this.bkgNo  = bkgNo ;
		this.smtDt  = smtDt ;
		this.updUsrId  = updUsrId ;
		this.creUsrId  = creUsrId ;
		this.upldUsrId  = upldUsrId ;
		this.xterSiRefNo  = xterSiRefNo ;
		this.vgmUpldStsCd  = vgmUpldStsCd ;
		this.vgmWgt  = vgmWgt ;
		this.xterRqstViaCd  = xterRqstViaCd ;
		this.vgmDtmnDt  = vgmDtmnDt ;
		this.custId  = custId ;
		this.vgmVrfyDt  = vgmVrfyDt ;
		this.upldGdt  = upldGdt ;
		this.pagerows  = pagerows ;
		this.smtCntcDesc  = smtCntcDesc ;
		this.xterCntrSealNo  = xterCntrSealNo ;
		this.vgmMzdTpCd  = vgmMzdTpCd ;
		this.smtPhnNo  = smtPhnNo ;
		this.rqstDt  = rqstDt ;
		this.vgmWgtUtCd  = vgmWgtUtCd ;
		this.xterBkgRqstRefNo  = xterBkgRqstRefNo ;
		this.rqstDeltFlg  = rqstDeltFlg ;
		this.rjctRsnRmk  = rjctRsnRmk ;
		this.creDt  = creDt ;
		this.vgmEdiTpCd  = vgmEdiTpCd ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.smtEml  = smtEml ;
		this.updDt  = updDt ;
		this.cntrNo  = cntrNo ;
		this.smtNm  = smtNm ;
		this.vgmDocId  = vgmDocId ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upld_dt", getUpldDt());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("smt_addr", getSmtAddr());		
		this.hashColumns.put("xter_sndr_id", getXterSndrId());		
		this.hashColumns.put("xter_vgm_rqst_no", getXterVgmRqstNo());		
		this.hashColumns.put("xter_vgm_seq", getXterVgmSeq());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("smt_dt", getSmtDt());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("upld_usr_id", getUpldUsrId());		
		this.hashColumns.put("xter_si_ref_no", getXterSiRefNo());		
		this.hashColumns.put("vgm_upld_sts_cd", getVgmUpldStsCd());		
		this.hashColumns.put("vgm_wgt", getVgmWgt());		
		this.hashColumns.put("xter_rqst_via_cd", getXterRqstViaCd());		
		this.hashColumns.put("vgm_dtmn_dt", getVgmDtmnDt());		
		this.hashColumns.put("cust_id", getCustId());		
		this.hashColumns.put("vgm_vrfy_dt", getVgmVrfyDt());		
		this.hashColumns.put("upld_gdt", getUpldGdt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("smt_cntc_desc", getSmtCntcDesc());		
		this.hashColumns.put("xter_cntr_seal_no", getXterCntrSealNo());		
		this.hashColumns.put("vgm_mzd_tp_cd", getVgmMzdTpCd());		
		this.hashColumns.put("smt_phn_no", getSmtPhnNo());		
		this.hashColumns.put("rqst_dt", getRqstDt());		
		this.hashColumns.put("vgm_wgt_ut_cd", getVgmWgtUtCd());		
		this.hashColumns.put("xter_bkg_rqst_ref_no", getXterBkgRqstRefNo());		
		this.hashColumns.put("rqst_delt_flg", getRqstDeltFlg());		
		this.hashColumns.put("rjct_rsn_rmk", getRjctRsnRmk());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("vgm_edi_tp_cd", getVgmEdiTpCd());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("smt_eml", getSmtEml());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("smt_nm", getSmtNm());		
		this.hashColumns.put("vgm_doc_id", getVgmDocId());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("upld_dt", "upldDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("smt_addr", "smtAddr");
		this.hashFields.put("xter_sndr_id", "xterSndrId");
		this.hashFields.put("xter_vgm_rqst_no", "xterVgmRqstNo");
		this.hashFields.put("xter_vgm_seq", "xterVgmSeq");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("smt_dt", "smtDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("upld_usr_id", "upldUsrId");
		this.hashFields.put("xter_si_ref_no", "xterSiRefNo");
		this.hashFields.put("vgm_upld_sts_cd", "vgmUpldStsCd");
		this.hashFields.put("vgm_wgt", "vgmWgt");
		this.hashFields.put("xter_rqst_via_cd", "xterRqstViaCd");
		this.hashFields.put("vgm_dtmn_dt", "vgmDtmnDt");
		this.hashFields.put("cust_id", "custId");
		this.hashFields.put("vgm_vrfy_dt", "vgmVrfyDt");
		this.hashFields.put("upld_gdt", "upldGdt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("smt_cntc_desc", "smtCntcDesc");
		this.hashFields.put("xter_cntr_seal_no", "xterCntrSealNo");
		this.hashFields.put("vgm_mzd_tp_cd", "vgmMzdTpCd");
		this.hashFields.put("smt_phn_no", "smtPhnNo");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("vgm_wgt_ut_cd", "vgmWgtUtCd");
		this.hashFields.put("xter_bkg_rqst_ref_no", "xterBkgRqstRefNo");
		this.hashFields.put("rqst_delt_flg", "rqstDeltFlg");
		this.hashFields.put("rjct_rsn_rmk", "rjctRsnRmk");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vgm_edi_tp_cd", "vgmEdiTpCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("smt_eml", "smtEml");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("smt_nm", "smtNm");
		this.hashFields.put("vgm_doc_id", "vgmDocId");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  upldDt
	*/
	public void	setUpldDt( String	upldDt ) {
		this.upldDt =	upldDt;
	}
 
	/**
	 * Column Info
	 * @return	upldDt
	 */
	 public	String	getUpldDt() {
		 return	this.upldDt;
	 } 
 	/**
	* Column Info
	* @param  ibflag
	*/
	public void	setIbflag( String	ibflag ) {
		this.ibflag =	ibflag;
	}
 
	/**
	 * Column Info
	 * @return	ibflag
	 */
	 public	String	getIbflag() {
		 return	this.ibflag;
	 } 
 	/**
	* Column Info
	* @param  smtAddr
	*/
	public void	setSmtAddr( String	smtAddr ) {
		this.smtAddr =	smtAddr;
	}
 
	/**
	 * Column Info
	 * @return	smtAddr
	 */
	 public	String	getSmtAddr() {
		 return	this.smtAddr;
	 } 
 	/**
	* Column Info
	* @param  xterSndrId
	*/
	public void	setXterSndrId( String	xterSndrId ) {
		this.xterSndrId =	xterSndrId;
	}
 
	/**
	 * Column Info
	 * @return	xterSndrId
	 */
	 public	String	getXterSndrId() {
		 return	this.xterSndrId;
	 } 
 	/**
	* Column Info
	* @param  xterVgmRqstNo
	*/
	public void	setXterVgmRqstNo( String	xterVgmRqstNo ) {
		this.xterVgmRqstNo =	xterVgmRqstNo;
	}
 
	/**
	 * Column Info
	 * @return	xterVgmRqstNo
	 */
	 public	String	getXterVgmRqstNo() {
		 return	this.xterVgmRqstNo;
	 } 
 	/**
	* Column Info
	* @param  xterVgmSeq
	*/
	public void	setXterVgmSeq( String	xterVgmSeq ) {
		this.xterVgmSeq =	xterVgmSeq;
	}
 
	/**
	 * Column Info
	 * @return	xterVgmSeq
	 */
	 public	String	getXterVgmSeq() {
		 return	this.xterVgmSeq;
	 } 
 	/**
	* Column Info
	* @param  bkgNo
	*/
	public void	setBkgNo( String	bkgNo ) {
		this.bkgNo =	bkgNo;
	}
 
	/**
	 * Column Info
	 * @return	bkgNo
	 */
	 public	String	getBkgNo() {
		 return	this.bkgNo;
	 } 
 	/**
	* Column Info
	* @param  smtDt
	*/
	public void	setSmtDt( String	smtDt ) {
		this.smtDt =	smtDt;
	}
 
	/**
	 * Column Info
	 * @return	smtDt
	 */
	 public	String	getSmtDt() {
		 return	this.smtDt;
	 } 
 	/**
	* Column Info
	* @param  updUsrId
	*/
	public void	setUpdUsrId( String	updUsrId ) {
		this.updUsrId =	updUsrId;
	}
 
	/**
	 * Column Info
	 * @return	updUsrId
	 */
	 public	String	getUpdUsrId() {
		 return	this.updUsrId;
	 } 
 	/**
	* Column Info
	* @param  creUsrId
	*/
	public void	setCreUsrId( String	creUsrId ) {
		this.creUsrId =	creUsrId;
	}
 
	/**
	 * Column Info
	 * @return	creUsrId
	 */
	 public	String	getCreUsrId() {
		 return	this.creUsrId;
	 } 
 	/**
	* Column Info
	* @param  upldUsrId
	*/
	public void	setUpldUsrId( String	upldUsrId ) {
		this.upldUsrId =	upldUsrId;
	}
 
	/**
	 * Column Info
	 * @return	upldUsrId
	 */
	 public	String	getUpldUsrId() {
		 return	this.upldUsrId;
	 } 
 	/**
	* Column Info
	* @param  xterSiRefNo
	*/
	public void	setXterSiRefNo( String	xterSiRefNo ) {
		this.xterSiRefNo =	xterSiRefNo;
	}
 
	/**
	 * Column Info
	 * @return	xterSiRefNo
	 */
	 public	String	getXterSiRefNo() {
		 return	this.xterSiRefNo;
	 } 
 	/**
	* Column Info
	* @param  vgmUpldStsCd
	*/
	public void	setVgmUpldStsCd( String	vgmUpldStsCd ) {
		this.vgmUpldStsCd =	vgmUpldStsCd;
	}
 
	/**
	 * Column Info
	 * @return	vgmUpldStsCd
	 */
	 public	String	getVgmUpldStsCd() {
		 return	this.vgmUpldStsCd;
	 } 
 	/**
	* Column Info
	* @param  vgmWgt
	*/
	public void	setVgmWgt( String	vgmWgt ) {
		this.vgmWgt =	vgmWgt;
	}
 
	/**
	 * Column Info
	 * @return	vgmWgt
	 */
	 public	String	getVgmWgt() {
		 return	this.vgmWgt;
	 } 
 	/**
	* Column Info
	* @param  xterRqstViaCd
	*/
	public void	setXterRqstViaCd( String	xterRqstViaCd ) {
		this.xterRqstViaCd =	xterRqstViaCd;
	}
 
	/**
	 * Column Info
	 * @return	xterRqstViaCd
	 */
	 public	String	getXterRqstViaCd() {
		 return	this.xterRqstViaCd;
	 } 
 	/**
	* Column Info
	* @param  vgmDtmnDt
	*/
	public void	setVgmDtmnDt( String	vgmDtmnDt ) {
		this.vgmDtmnDt =	vgmDtmnDt;
	}
 
	/**
	 * Column Info
	 * @return	vgmDtmnDt
	 */
	 public	String	getVgmDtmnDt() {
		 return	this.vgmDtmnDt;
	 } 
 	/**
	* Column Info
	* @param  custId
	*/
	public void	setCustId( String	custId ) {
		this.custId =	custId;
	}
 
	/**
	 * Column Info
	 * @return	custId
	 */
	 public	String	getCustId() {
		 return	this.custId;
	 } 
 	/**
	* Column Info
	* @param  vgmVrfyDt
	*/
	public void	setVgmVrfyDt( String	vgmVrfyDt ) {
		this.vgmVrfyDt =	vgmVrfyDt;
	}
 
	/**
	 * Column Info
	 * @return	vgmVrfyDt
	 */
	 public	String	getVgmVrfyDt() {
		 return	this.vgmVrfyDt;
	 } 
 	/**
	* Column Info
	* @param  upldGdt
	*/
	public void	setUpldGdt( String	upldGdt ) {
		this.upldGdt =	upldGdt;
	}
 
	/**
	 * Column Info
	 * @return	upldGdt
	 */
	 public	String	getUpldGdt() {
		 return	this.upldGdt;
	 } 
 	/**
	* Column Info
	* @param  pagerows
	*/
	public void	setPagerows( String	pagerows ) {
		this.pagerows =	pagerows;
	}
 
	/**
	 * Column Info
	 * @return	pagerows
	 */
	 public	String	getPagerows() {
		 return	this.pagerows;
	 } 
 	/**
	* Column Info
	* @param  smtCntcDesc
	*/
	public void	setSmtCntcDesc( String	smtCntcDesc ) {
		this.smtCntcDesc =	smtCntcDesc;
	}
 
	/**
	 * Column Info
	 * @return	smtCntcDesc
	 */
	 public	String	getSmtCntcDesc() {
		 return	this.smtCntcDesc;
	 } 
 	/**
	* Column Info
	* @param  xterCntrSealNo
	*/
	public void	setXterCntrSealNo( String	xterCntrSealNo ) {
		this.xterCntrSealNo =	xterCntrSealNo;
	}
 
	/**
	 * Column Info
	 * @return	xterCntrSealNo
	 */
	 public	String	getXterCntrSealNo() {
		 return	this.xterCntrSealNo;
	 } 
 	/**
	* Column Info
	* @param  vgmMzdTpCd
	*/
	public void	setVgmMzdTpCd( String	vgmMzdTpCd ) {
		this.vgmMzdTpCd =	vgmMzdTpCd;
	}
 
	/**
	 * Column Info
	 * @return	vgmMzdTpCd
	 */
	 public	String	getVgmMzdTpCd() {
		 return	this.vgmMzdTpCd;
	 } 
 	/**
	* Column Info
	* @param  smtPhnNo
	*/
	public void	setSmtPhnNo( String	smtPhnNo ) {
		this.smtPhnNo =	smtPhnNo;
	}
 
	/**
	 * Column Info
	 * @return	smtPhnNo
	 */
	 public	String	getSmtPhnNo() {
		 return	this.smtPhnNo;
	 } 
 	/**
	* Column Info
	* @param  rqstDt
	*/
	public void	setRqstDt( String	rqstDt ) {
		this.rqstDt =	rqstDt;
	}
 
	/**
	 * Column Info
	 * @return	rqstDt
	 */
	 public	String	getRqstDt() {
		 return	this.rqstDt;
	 } 
 	/**
	* Column Info
	* @param  vgmWgtUtCd
	*/
	public void	setVgmWgtUtCd( String	vgmWgtUtCd ) {
		this.vgmWgtUtCd =	vgmWgtUtCd;
	}
 
	/**
	 * Column Info
	 * @return	vgmWgtUtCd
	 */
	 public	String	getVgmWgtUtCd() {
		 return	this.vgmWgtUtCd;
	 } 
 	/**
	* Column Info
	* @param  xterBkgRqstRefNo
	*/
	public void	setXterBkgRqstRefNo( String	xterBkgRqstRefNo ) {
		this.xterBkgRqstRefNo =	xterBkgRqstRefNo;
	}
 
	/**
	 * Column Info
	 * @return	xterBkgRqstRefNo
	 */
	 public	String	getXterBkgRqstRefNo() {
		 return	this.xterBkgRqstRefNo;
	 } 
 	/**
	* Column Info
	* @param  rqstDeltFlg
	*/
	public void	setRqstDeltFlg( String	rqstDeltFlg ) {
		this.rqstDeltFlg =	rqstDeltFlg;
	}
 
	/**
	 * Column Info
	 * @return	rqstDeltFlg
	 */
	 public	String	getRqstDeltFlg() {
		 return	this.rqstDeltFlg;
	 } 
 	/**
	* Column Info
	* @param  rjctRsnRmk
	*/
	public void	setRjctRsnRmk( String	rjctRsnRmk ) {
		this.rjctRsnRmk =	rjctRsnRmk;
	}
 
	/**
	 * Column Info
	 * @return	rjctRsnRmk
	 */
	 public	String	getRjctRsnRmk() {
		 return	this.rjctRsnRmk;
	 } 
 	/**
	* Column Info
	* @param  creDt
	*/
	public void	setCreDt( String	creDt ) {
		this.creDt =	creDt;
	}
 
	/**
	 * Column Info
	 * @return	creDt
	 */
	 public	String	getCreDt() {
		 return	this.creDt;
	 } 
 	/**
	* Column Info
	* @param  vgmEdiTpCd
	*/
	public void	setVgmEdiTpCd( String	vgmEdiTpCd ) {
		this.vgmEdiTpCd =	vgmEdiTpCd;
	}
 
	/**
	 * Column Info
	 * @return	vgmEdiTpCd
	 */
	 public	String	getVgmEdiTpCd() {
		 return	this.vgmEdiTpCd;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd
	*/
	public void	setCntrTpszCd( String	cntrTpszCd ) {
		this.cntrTpszCd =	cntrTpszCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd
	 */
	 public	String	getCntrTpszCd() {
		 return	this.cntrTpszCd;
	 } 
 	/**
	* Column Info
	* @param  smtEml
	*/
	public void	setSmtEml( String	smtEml ) {
		this.smtEml =	smtEml;
	}
 
	/**
	 * Column Info
	 * @return	smtEml
	 */
	 public	String	getSmtEml() {
		 return	this.smtEml;
	 } 
 	/**
	* Column Info
	* @param  updDt
	*/
	public void	setUpdDt( String	updDt ) {
		this.updDt =	updDt;
	}
 
	/**
	 * Column Info
	 * @return	updDt
	 */
	 public	String	getUpdDt() {
		 return	this.updDt;
	 } 
 	/**
	* Column Info
	* @param  cntrNo
	*/
	public void	setCntrNo( String	cntrNo ) {
		this.cntrNo =	cntrNo;
	}
 
	/**
	 * Column Info
	 * @return	cntrNo
	 */
	 public	String	getCntrNo() {
		 return	this.cntrNo;
	 } 
 	/**
	* Column Info
	* @param  smtNm
	*/
	public void	setSmtNm( String	smtNm ) {
		this.smtNm =	smtNm;
	}
 
	/**
	 * Column Info
	 * @return	smtNm
	 */
	 public	String	getSmtNm() {
		 return	this.smtNm;
	 } 
 	/**
	* Column Info
	* @param  vgmDocId
	*/
	public void	setVgmDocId( String	vgmDocId ) {
		this.vgmDocId =	vgmDocId;
	}
 
	/**
	 * Column Info
	 * @return	vgmDocId
	 */
	 public	String	getVgmDocId() {
		 return	this.vgmDocId;
	 } 

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setUpldDt(JSPUtil.getParameter(request,	prefix + "upld_dt", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setSmtAddr(JSPUtil.getParameter(request,	prefix + "smt_addr", ""));
		setXterSndrId(JSPUtil.getParameter(request,	prefix + "xter_sndr_id", ""));
		setXterVgmRqstNo(JSPUtil.getParameter(request,	prefix + "xter_vgm_rqst_no", ""));
		setXterVgmSeq(JSPUtil.getParameter(request,	prefix + "xter_vgm_seq", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setSmtDt(JSPUtil.getParameter(request,	prefix + "smt_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setUpldUsrId(JSPUtil.getParameter(request,	prefix + "upld_usr_id", ""));
		setXterSiRefNo(JSPUtil.getParameter(request,	prefix + "xter_si_ref_no", ""));
		setVgmUpldStsCd(JSPUtil.getParameter(request,	prefix + "vgm_upld_sts_cd", ""));
		setVgmWgt(JSPUtil.getParameter(request,	prefix + "vgm_wgt", ""));
		setXterRqstViaCd(JSPUtil.getParameter(request,	prefix + "xter_rqst_via_cd", ""));
		setVgmDtmnDt(JSPUtil.getParameter(request,	prefix + "vgm_dtmn_dt", ""));
		setCustId(JSPUtil.getParameter(request,	prefix + "cust_id", ""));
		setVgmVrfyDt(JSPUtil.getParameter(request,	prefix + "vgm_vrfy_dt", ""));
		setUpldGdt(JSPUtil.getParameter(request,	prefix + "upld_gdt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setSmtCntcDesc(JSPUtil.getParameter(request,	prefix + "smt_cntc_desc", ""));
		setXterCntrSealNo(JSPUtil.getParameter(request,	prefix + "xter_cntr_seal_no", ""));
		setVgmMzdTpCd(JSPUtil.getParameter(request,	prefix + "vgm_mzd_tp_cd", ""));
		setSmtPhnNo(JSPUtil.getParameter(request,	prefix + "smt_phn_no", ""));
		setRqstDt(JSPUtil.getParameter(request,	prefix + "rqst_dt", ""));
		setVgmWgtUtCd(JSPUtil.getParameter(request,	prefix + "vgm_wgt_ut_cd", ""));
		setXterBkgRqstRefNo(JSPUtil.getParameter(request,	prefix + "xter_bkg_rqst_ref_no", ""));
		setRqstDeltFlg(JSPUtil.getParameter(request,	prefix + "rqst_delt_flg", ""));
		setRjctRsnRmk(JSPUtil.getParameter(request,	prefix + "rjct_rsn_rmk", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setVgmEdiTpCd(JSPUtil.getParameter(request,	prefix + "vgm_edi_tp_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setSmtEml(JSPUtil.getParameter(request,	prefix + "smt_eml", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setSmtNm(JSPUtil.getParameter(request,	prefix + "smt_nm", ""));
		setVgmDocId(JSPUtil.getParameter(request,	prefix + "vgm_doc_id", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgXterVrfdWgtRqstVO[]
	 */
	public BkgXterVrfdWgtRqstVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BkgXterVrfdWgtRqstVO[]
	 */
	public BkgXterVrfdWgtRqstVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		BkgXterVrfdWgtRqstVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] upldDt =	(JSPUtil.getParameter(request, prefix +	"upld_dt".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] smtAddr =	(JSPUtil.getParameter(request, prefix +	"smt_addr".trim(),	length));
				String[] xterSndrId =	(JSPUtil.getParameter(request, prefix +	"xter_sndr_id".trim(),	length));
				String[] xterVgmRqstNo =	(JSPUtil.getParameter(request, prefix +	"xter_vgm_rqst_no".trim(),	length));
				String[] xterVgmSeq =	(JSPUtil.getParameter(request, prefix +	"xter_vgm_seq".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] smtDt =	(JSPUtil.getParameter(request, prefix +	"smt_dt".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] upldUsrId =	(JSPUtil.getParameter(request, prefix +	"upld_usr_id".trim(),	length));
				String[] xterSiRefNo =	(JSPUtil.getParameter(request, prefix +	"xter_si_ref_no".trim(),	length));
				String[] vgmUpldStsCd =	(JSPUtil.getParameter(request, prefix +	"vgm_upld_sts_cd".trim(),	length));
				String[] vgmWgt =	(JSPUtil.getParameter(request, prefix +	"vgm_wgt".trim(),	length));
				String[] xterRqstViaCd =	(JSPUtil.getParameter(request, prefix +	"xter_rqst_via_cd".trim(),	length));
				String[] vgmDtmnDt =	(JSPUtil.getParameter(request, prefix +	"vgm_dtmn_dt".trim(),	length));
				String[] custId =	(JSPUtil.getParameter(request, prefix +	"cust_id".trim(),	length));
				String[] vgmVrfyDt =	(JSPUtil.getParameter(request, prefix +	"vgm_vrfy_dt".trim(),	length));
				String[] upldGdt =	(JSPUtil.getParameter(request, prefix +	"upld_gdt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] smtCntcDesc =	(JSPUtil.getParameter(request, prefix +	"smt_cntc_desc".trim(),	length));
				String[] xterCntrSealNo =	(JSPUtil.getParameter(request, prefix +	"xter_cntr_seal_no".trim(),	length));
				String[] vgmMzdTpCd =	(JSPUtil.getParameter(request, prefix +	"vgm_mzd_tp_cd".trim(),	length));
				String[] smtPhnNo =	(JSPUtil.getParameter(request, prefix +	"smt_phn_no".trim(),	length));
				String[] rqstDt =	(JSPUtil.getParameter(request, prefix +	"rqst_dt".trim(),	length));
				String[] vgmWgtUtCd =	(JSPUtil.getParameter(request, prefix +	"vgm_wgt_ut_cd".trim(),	length));
				String[] xterBkgRqstRefNo =	(JSPUtil.getParameter(request, prefix +	"xter_bkg_rqst_ref_no".trim(),	length));
				String[] rqstDeltFlg =	(JSPUtil.getParameter(request, prefix +	"rqst_delt_flg".trim(),	length));
				String[] rjctRsnRmk =	(JSPUtil.getParameter(request, prefix +	"rjct_rsn_rmk".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] vgmEdiTpCd =	(JSPUtil.getParameter(request, prefix +	"vgm_edi_tp_cd".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] smtEml =	(JSPUtil.getParameter(request, prefix +	"smt_eml".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] smtNm =	(JSPUtil.getParameter(request, prefix +	"smt_nm".trim(),	length));
				String[] vgmDocId =	(JSPUtil.getParameter(request, prefix +	"vgm_doc_id".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	BkgXterVrfdWgtRqstVO();
						if ( upldDt[i] !=	null)
						model.setUpldDt( upldDt[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( smtAddr[i] !=	null)
						model.setSmtAddr( smtAddr[i]);
						if ( xterSndrId[i] !=	null)
						model.setXterSndrId( xterSndrId[i]);
						if ( xterVgmRqstNo[i] !=	null)
						model.setXterVgmRqstNo( xterVgmRqstNo[i]);
						if ( xterVgmSeq[i] !=	null)
						model.setXterVgmSeq( xterVgmSeq[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( smtDt[i] !=	null)
						model.setSmtDt( smtDt[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( upldUsrId[i] !=	null)
						model.setUpldUsrId( upldUsrId[i]);
						if ( xterSiRefNo[i] !=	null)
						model.setXterSiRefNo( xterSiRefNo[i]);
						if ( vgmUpldStsCd[i] !=	null)
						model.setVgmUpldStsCd( vgmUpldStsCd[i]);
						if ( vgmWgt[i] !=	null)
						model.setVgmWgt( vgmWgt[i]);
						if ( xterRqstViaCd[i] !=	null)
						model.setXterRqstViaCd( xterRqstViaCd[i]);
						if ( vgmDtmnDt[i] !=	null)
						model.setVgmDtmnDt( vgmDtmnDt[i]);
						if ( custId[i] !=	null)
						model.setCustId( custId[i]);
						if ( vgmVrfyDt[i] !=	null)
						model.setVgmVrfyDt( vgmVrfyDt[i]);
						if ( upldGdt[i] !=	null)
						model.setUpldGdt( upldGdt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( smtCntcDesc[i] !=	null)
						model.setSmtCntcDesc( smtCntcDesc[i]);
						if ( xterCntrSealNo[i] !=	null)
						model.setXterCntrSealNo( xterCntrSealNo[i]);
						if ( vgmMzdTpCd[i] !=	null)
						model.setVgmMzdTpCd( vgmMzdTpCd[i]);
						if ( smtPhnNo[i] !=	null)
						model.setSmtPhnNo( smtPhnNo[i]);
						if ( rqstDt[i] !=	null)
						model.setRqstDt( rqstDt[i]);
						if ( vgmWgtUtCd[i] !=	null)
						model.setVgmWgtUtCd( vgmWgtUtCd[i]);
						if ( xterBkgRqstRefNo[i] !=	null)
						model.setXterBkgRqstRefNo( xterBkgRqstRefNo[i]);
						if ( rqstDeltFlg[i] !=	null)
						model.setRqstDeltFlg( rqstDeltFlg[i]);
						if ( rjctRsnRmk[i] !=	null)
						model.setRjctRsnRmk( rjctRsnRmk[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( vgmEdiTpCd[i] !=	null)
						model.setVgmEdiTpCd( vgmEdiTpCd[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( smtEml[i] !=	null)
						model.setSmtEml( smtEml[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
						if ( smtNm[i] !=	null)
						model.setSmtNm( smtNm[i]);
						if ( vgmDocId[i] !=	null)
						model.setVgmDocId( vgmDocId[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getBkgXterVrfdWgtRqstVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return BkgXterVrfdWgtRqstVO[]
	 */
	public BkgXterVrfdWgtRqstVO[]	 getBkgXterVrfdWgtRqstVOs(){
		BkgXterVrfdWgtRqstVO[] vos = (BkgXterVrfdWgtRqstVO[])models.toArray(new	BkgXterVrfdWgtRqstVO[models.size()]);
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
	public void	unDataFormat(){
		this.upldDt =	this.upldDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smtAddr =	this.smtAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterSndrId =	this.xterSndrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterVgmRqstNo =	this.xterVgmRqstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterVgmSeq =	this.xterVgmSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smtDt =	this.smtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.upldUsrId =	this.upldUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterSiRefNo =	this.xterSiRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmUpldStsCd =	this.vgmUpldStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgt =	this.vgmWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstViaCd =	this.xterRqstViaCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmDtmnDt =	this.vgmDtmnDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custId =	this.custId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmVrfyDt =	this.vgmVrfyDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.upldGdt =	this.upldGdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smtCntcDesc =	this.smtCntcDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterCntrSealNo =	this.xterCntrSealNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmMzdTpCd =	this.vgmMzdTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smtPhnNo =	this.smtPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt =	this.rqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtUtCd =	this.vgmWgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterBkgRqstRefNo =	this.xterBkgRqstRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDeltFlg =	this.rqstDeltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rjctRsnRmk =	this.rjctRsnRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmEdiTpCd =	this.vgmEdiTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smtEml =	this.smtEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smtNm =	this.smtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmDocId =	this.vgmDocId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}
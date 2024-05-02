/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : EBookingControlMgmtVO.java
 *@FileTitle : EBookingControlMgmtVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.08.24
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.08.24  
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
public class EBookingControlMgmtVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<EBookingControlMgmtVO>  models =	new	ArrayList<EBookingControlMgmtVO>();


	/*	Column Info	*/
	private  String	 vslCd   =  null;
	/*	Column Info	*/
	private  String	 sumUld   =  null;
	/*	Column Info	*/
	private  String	 xterPodCd   =  null;
	/*	Column Info	*/
	private  String	 sumFeu   =  null;
	/*	Column Info	*/
	private  String	 docTpCd   =  null;
	/*	Column Info	*/
	private  String	 hndlOfcCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 polCd   =  null;
	/*	Column Info	*/
	private  String	 bkgPodCd   =  null;
	/*	Column Info	*/
	private  String	 sumTtl   =  null;
	/*	Column Info	*/
	private  String	 scNo   =  null;
	/*	Column Info	*/
	private  String	 sumWgt   =  null;
	/*	Column Info	*/
	private  String	 xterPorCd   =  null;
	/*	Column Info	*/
	private  String	 chnAgnCd   =  null;
	/*	Column Info	*/
	private  String	 feu   =  null;
	/*	Column Info	*/
	private  String	 upldUsrId   =  null;
	/*	Column Info	*/
	private  String	 xterSndrId   =  null;
	/*	Column Info	*/
	private  String	 estWgt   =  null;
	/*	Column Info	*/
	private  String	 snaccsSplitNo   =  null;
	/*	Column Info	*/
	private  String	 skdVoyNo   =  null;
	/*	Column Info	*/
	private  String	 vvd   =  null;
	/*	Column Info	*/
	private  String	 podCd   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 xterRqstAcptCd   =  null;
	/*	Column Info	*/
	private  String	 poNo   =  null;
	/*	Column Info	*/
	private  String	 rqstToDt   =  null;
	/*	Column Info	*/
	private  String	 teu   =  null;
	/*	Column Info	*/
	private  String	 delivery   =  null;
	/*	Column Info	*/
	private  String	 rowNum   =  null;
	/*	Column Info	*/
	private  String	 reject   =  null;
	/*	Column Info	*/
	private  String	 bkgStsCd   =  null;
	/*	Column Info	*/
	private  String	 sumTeu   =  null;
	/*	Column Info	*/
	private  String	 cntcEml   =  null;
	/*	Column Info	*/
	private  String	 bkgUpldStsCd   =  null;
	/*	Column Info	*/
	private  String	 xterBkgRqstStsCd   =  null;
	/*	Column Info	*/
	private  String	 xterDelCd   =  null;
	/*	Column Info	*/
	private  String	 xterPolCd   =  null;
	/*	Column Info	*/
	private  String	 rfaNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 vslEngNm   =  null;
	/*	Column Info	*/
	private  String	 sumUnu   =  null;
	/*	Column Info	*/
	private  String	 shNm   =  null;
	/*	Column Info	*/
	private  String	 xterRqstViaCd   =  null;
	/*	Column Info	*/
	private  String	 upldDt   =  null;
	/*	Column Info	*/
	private  String	 rqstDt   =  null;
	/*	Column Info	*/
	private  String	 mdfyXterRqstNo   =  null;
	/*	Column Info	*/
	private  String	 rqstDepDt   =  null;
	/*	Column Info	*/
	private  String	 rqstFromDt   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 upldUsrNm   =  null;
	/*	Column Info	*/
	private  String	 frtTerm   =  null;
	/*	Column Info	*/
	private  String	 xterRqstSeq   =  null;
	/*	Column Info	*/
	private  String	 xterRqstNo   =  null;
	/*	Column Info	*/
	private  String	 confirm   =  null;
	/*	Column Info	*/
	private  String	 cnNm   =  null;
	/*	Column Info	*/
	private  String	 spcCtrlrRmk   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public EBookingControlMgmtVO(){}

	public EBookingControlMgmtVO(String vslCd,String sumUld,String xterPodCd,String sumFeu,String docTpCd,String hndlOfcCd,String pagerows,String polCd,String bkgPodCd,String sumTtl,String scNo,String sumWgt,String xterPorCd,String chnAgnCd,String feu,String upldUsrId,String xterSndrId,String estWgt,String snaccsSplitNo,String skdVoyNo,String vvd,String podCd,String bkgNo,String xterRqstAcptCd,String poNo,String rqstToDt,String teu,String delivery,String rowNum,String reject,String bkgStsCd,String sumTeu,String cntcEml,String bkgUpldStsCd,String xterBkgRqstStsCd,String xterDelCd,String xterPolCd,String rfaNo,String ibflag,String vslEngNm,String sumUnu,String shNm,String xterRqstViaCd,String upldDt,String rqstDt,String mdfyXterRqstNo,String rqstDepDt,String rqstFromDt,String ofcCd,String upldUsrNm,String frtTerm,String xterRqstSeq,String xterRqstNo,String confirm,String cnNm,String spcCtrlrRmk)	{
		this.vslCd  = vslCd ;
		this.sumUld  = sumUld ;
		this.xterPodCd  = xterPodCd ;
		this.sumFeu  = sumFeu ;
		this.docTpCd  = docTpCd ;
		this.hndlOfcCd  = hndlOfcCd ;
		this.pagerows  = pagerows ;
		this.polCd  = polCd ;
		this.bkgPodCd  = bkgPodCd ;
		this.sumTtl  = sumTtl ;
		this.scNo  = scNo ;
		this.sumWgt  = sumWgt ;
		this.xterPorCd  = xterPorCd ;
		this.chnAgnCd  = chnAgnCd ;
		this.feu  = feu ;
		this.upldUsrId  = upldUsrId ;
		this.xterSndrId  = xterSndrId ;
		this.estWgt  = estWgt ;
		this.snaccsSplitNo  = snaccsSplitNo ;
		this.skdVoyNo  = skdVoyNo ;
		this.vvd  = vvd ;
		this.podCd  = podCd ;
		this.bkgNo  = bkgNo ;
		this.xterRqstAcptCd  = xterRqstAcptCd ;
		this.poNo  = poNo ;
		this.rqstToDt  = rqstToDt ;
		this.teu  = teu ;
		this.delivery  = delivery ;
		this.rowNum  = rowNum ;
		this.reject  = reject ;
		this.bkgStsCd  = bkgStsCd ;
		this.sumTeu  = sumTeu ;
		this.cntcEml  = cntcEml ;
		this.bkgUpldStsCd  = bkgUpldStsCd ;
		this.xterBkgRqstStsCd  = xterBkgRqstStsCd ;
		this.xterDelCd  = xterDelCd ;
		this.xterPolCd  = xterPolCd ;
		this.rfaNo  = rfaNo ;
		this.ibflag  = ibflag ;
		this.vslEngNm  = vslEngNm ;
		this.sumUnu  = sumUnu ;
		this.shNm  = shNm ;
		this.xterRqstViaCd  = xterRqstViaCd ;
		this.upldDt  = upldDt ;
		this.rqstDt  = rqstDt ;
		this.mdfyXterRqstNo  = mdfyXterRqstNo ;
		this.rqstDepDt  = rqstDepDt ;
		this.rqstFromDt  = rqstFromDt ;
		this.ofcCd  = ofcCd ;
		this.upldUsrNm  = upldUsrNm ;
		this.frtTerm  = frtTerm ;
		this.xterRqstSeq  = xterRqstSeq ;
		this.xterRqstNo  = xterRqstNo ;
		this.confirm  = confirm ;
		this.cnNm  = cnNm ;
		this.spcCtrlrRmk  = spcCtrlrRmk ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());		
		this.hashColumns.put("sum_uld", getSumUld());		
		this.hashColumns.put("xter_pod_cd", getXterPodCd());		
		this.hashColumns.put("sum_feu", getSumFeu());		
		this.hashColumns.put("doc_tp_cd", getDocTpCd());		
		this.hashColumns.put("hndl_ofc_cd", getHndlOfcCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("pol_cd", getPolCd());		
		this.hashColumns.put("bkg_pod_cd", getBkgPodCd());		
		this.hashColumns.put("sum_ttl", getSumTtl());		
		this.hashColumns.put("sc_no", getScNo());		
		this.hashColumns.put("sum_wgt", getSumWgt());		
		this.hashColumns.put("xter_por_cd", getXterPorCd());		
		this.hashColumns.put("chn_agn_cd", getChnAgnCd());		
		this.hashColumns.put("feu", getFeu());		
		this.hashColumns.put("upld_usr_id", getUpldUsrId());		
		this.hashColumns.put("xter_sndr_id", getXterSndrId());		
		this.hashColumns.put("est_wgt", getEstWgt());		
		this.hashColumns.put("snaccs_split_no", getSnaccsSplitNo());		
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());		
		this.hashColumns.put("vvd", getVvd());		
		this.hashColumns.put("pod_cd", getPodCd());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("xter_rqst_acpt_cd", getXterRqstAcptCd());		
		this.hashColumns.put("po_no", getPoNo());		
		this.hashColumns.put("rqst_to_dt", getRqstToDt());		
		this.hashColumns.put("teu", getTeu());		
		this.hashColumns.put("delivery", getDelivery());		
		this.hashColumns.put("row_num", getRowNum());		
		this.hashColumns.put("reject", getReject());		
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());		
		this.hashColumns.put("sum_teu", getSumTeu());		
		this.hashColumns.put("cntc_eml", getCntcEml());		
		this.hashColumns.put("bkg_upld_sts_cd", getBkgUpldStsCd());		
		this.hashColumns.put("xter_bkg_rqst_sts_cd", getXterBkgRqstStsCd());		
		this.hashColumns.put("xter_del_cd", getXterDelCd());		
		this.hashColumns.put("xter_pol_cd", getXterPolCd());		
		this.hashColumns.put("rfa_no", getRfaNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());		
		this.hashColumns.put("sum_unu", getSumUnu());		
		this.hashColumns.put("sh_nm", getShNm());		
		this.hashColumns.put("xter_rqst_via_cd", getXterRqstViaCd());		
		this.hashColumns.put("upld_dt", getUpldDt());		
		this.hashColumns.put("rqst_dt", getRqstDt());		
		this.hashColumns.put("mdfy_xter_rqst_no", getMdfyXterRqstNo());		
		this.hashColumns.put("rqst_dep_dt", getRqstDepDt());		
		this.hashColumns.put("rqst_from_dt", getRqstFromDt());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("upld_usr_nm", getUpldUsrNm());		
		this.hashColumns.put("frt_term", getFrtTerm());		
		this.hashColumns.put("xter_rqst_seq", getXterRqstSeq());		
		this.hashColumns.put("xter_rqst_no", getXterRqstNo());		
		this.hashColumns.put("confirm", getConfirm());		
		this.hashColumns.put("cn_nm", getCnNm());		
		this.hashColumns.put("spc_ctrlr_rmk", getSpcCtrlrRmk());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("sum_uld", "sumUld");
		this.hashFields.put("xter_pod_cd", "xterPodCd");
		this.hashFields.put("sum_feu", "sumFeu");
		this.hashFields.put("doc_tp_cd", "docTpCd");
		this.hashFields.put("hndl_ofc_cd", "hndlOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("bkg_pod_cd", "bkgPodCd");
		this.hashFields.put("sum_ttl", "sumTtl");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("sum_wgt", "sumWgt");
		this.hashFields.put("xter_por_cd", "xterPorCd");
		this.hashFields.put("chn_agn_cd", "chnAgnCd");
		this.hashFields.put("feu", "feu");
		this.hashFields.put("upld_usr_id", "upldUsrId");
		this.hashFields.put("xter_sndr_id", "xterSndrId");
		this.hashFields.put("est_wgt", "estWgt");
		this.hashFields.put("snaccs_split_no", "snaccsSplitNo");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("xter_rqst_acpt_cd", "xterRqstAcptCd");
		this.hashFields.put("po_no", "poNo");
		this.hashFields.put("rqst_to_dt", "rqstToDt");
		this.hashFields.put("teu", "teu");
		this.hashFields.put("delivery", "delivery");
		this.hashFields.put("row_num", "rowNum");
		this.hashFields.put("reject", "reject");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("sum_teu", "sumTeu");
		this.hashFields.put("cntc_eml", "cntcEml");
		this.hashFields.put("bkg_upld_sts_cd", "bkgUpldStsCd");
		this.hashFields.put("xter_bkg_rqst_sts_cd", "xterBkgRqstStsCd");
		this.hashFields.put("xter_del_cd", "xterDelCd");
		this.hashFields.put("xter_pol_cd", "xterPolCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("sum_unu", "sumUnu");
		this.hashFields.put("sh_nm", "shNm");
		this.hashFields.put("xter_rqst_via_cd", "xterRqstViaCd");
		this.hashFields.put("upld_dt", "upldDt");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("mdfy_xter_rqst_no", "mdfyXterRqstNo");
		this.hashFields.put("rqst_dep_dt", "rqstDepDt");
		this.hashFields.put("rqst_from_dt", "rqstFromDt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("upld_usr_nm", "upldUsrNm");
		this.hashFields.put("frt_term", "frtTerm");
		this.hashFields.put("xter_rqst_seq", "xterRqstSeq");
		this.hashFields.put("xter_rqst_no", "xterRqstNo");
		this.hashFields.put("confirm", "confirm");
		this.hashFields.put("cn_nm", "cnNm");
		this.hashFields.put("spc_ctrlr_rmk", "spcCtrlrRmk");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  vslCd
	*/
	public void	setVslCd( String	vslCd ) {
		this.vslCd =	vslCd;
	}
 
	/**
	 * Column Info
	 * @return	vslCd
	 */
	 public	String	getVslCd() {
		 return	this.vslCd;
	 } 
 	/**
	* Column Info
	* @param  sumUld
	*/
	public void	setSumUld( String	sumUld ) {
		this.sumUld =	sumUld;
	}
 
	/**
	 * Column Info
	 * @return	sumUld
	 */
	 public	String	getSumUld() {
		 return	this.sumUld;
	 } 
 	/**
	* Column Info
	* @param  xterPodCd
	*/
	public void	setXterPodCd( String	xterPodCd ) {
		this.xterPodCd =	xterPodCd;
	}
 
	/**
	 * Column Info
	 * @return	xterPodCd
	 */
	 public	String	getXterPodCd() {
		 return	this.xterPodCd;
	 } 
 	/**
	* Column Info
	* @param  sumFeu
	*/
	public void	setSumFeu( String	sumFeu ) {
		this.sumFeu =	sumFeu;
	}
 
	/**
	 * Column Info
	 * @return	sumFeu
	 */
	 public	String	getSumFeu() {
		 return	this.sumFeu;
	 } 
 	/**
	* Column Info
	* @param  docTpCd
	*/
	public void	setDocTpCd( String	docTpCd ) {
		this.docTpCd =	docTpCd;
	}
 
	/**
	 * Column Info
	 * @return	docTpCd
	 */
	 public	String	getDocTpCd() {
		 return	this.docTpCd;
	 } 
 	/**
	* Column Info
	* @param  hndlOfcCd
	*/
	public void	setHndlOfcCd( String	hndlOfcCd ) {
		this.hndlOfcCd =	hndlOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	hndlOfcCd
	 */
	 public	String	getHndlOfcCd() {
		 return	this.hndlOfcCd;
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
	* @param  polCd
	*/
	public void	setPolCd( String	polCd ) {
		this.polCd =	polCd;
	}
 
	/**
	 * Column Info
	 * @return	polCd
	 */
	 public	String	getPolCd() {
		 return	this.polCd;
	 } 
 	/**
	* Column Info
	* @param  bkgPodCd
	*/
	public void	setBkgPodCd( String	bkgPodCd ) {
		this.bkgPodCd =	bkgPodCd;
	}
 
	/**
	 * Column Info
	 * @return	bkgPodCd
	 */
	 public	String	getBkgPodCd() {
		 return	this.bkgPodCd;
	 } 
 	/**
	* Column Info
	* @param  sumTtl
	*/
	public void	setSumTtl( String	sumTtl ) {
		this.sumTtl =	sumTtl;
	}
 
	/**
	 * Column Info
	 * @return	sumTtl
	 */
	 public	String	getSumTtl() {
		 return	this.sumTtl;
	 } 
 	/**
	* Column Info
	* @param  scNo
	*/
	public void	setScNo( String	scNo ) {
		this.scNo =	scNo;
	}
 
	/**
	 * Column Info
	 * @return	scNo
	 */
	 public	String	getScNo() {
		 return	this.scNo;
	 } 
 	/**
	* Column Info
	* @param  sumWgt
	*/
	public void	setSumWgt( String	sumWgt ) {
		this.sumWgt =	sumWgt;
	}
 
	/**
	 * Column Info
	 * @return	sumWgt
	 */
	 public	String	getSumWgt() {
		 return	this.sumWgt;
	 } 
 	/**
	* Column Info
	* @param  xterPorCd
	*/
	public void	setXterPorCd( String	xterPorCd ) {
		this.xterPorCd =	xterPorCd;
	}
 
	/**
	 * Column Info
	 * @return	xterPorCd
	 */
	 public	String	getXterPorCd() {
		 return	this.xterPorCd;
	 } 
 	/**
	* Column Info
	* @param  chnAgnCd
	*/
	public void	setChnAgnCd( String	chnAgnCd ) {
		this.chnAgnCd =	chnAgnCd;
	}
 
	/**
	 * Column Info
	 * @return	chnAgnCd
	 */
	 public	String	getChnAgnCd() {
		 return	this.chnAgnCd;
	 } 
 	/**
	* Column Info
	* @param  feu
	*/
	public void	setFeu( String	feu ) {
		this.feu =	feu;
	}
 
	/**
	 * Column Info
	 * @return	feu
	 */
	 public	String	getFeu() {
		 return	this.feu;
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
	* @param  estWgt
	*/
	public void	setEstWgt( String	estWgt ) {
		this.estWgt =	estWgt;
	}
 
	/**
	 * Column Info
	 * @return	estWgt
	 */
	 public	String	getEstWgt() {
		 return	this.estWgt;
	 } 
 	/**
	* Column Info
	* @param  snaccsSplitNo
	*/
	public void	setSnaccsSplitNo( String	snaccsSplitNo ) {
		this.snaccsSplitNo =	snaccsSplitNo;
	}
 
	/**
	 * Column Info
	 * @return	snaccsSplitNo
	 */
	 public	String	getSnaccsSplitNo() {
		 return	this.snaccsSplitNo;
	 } 
 	/**
	* Column Info
	* @param  skdVoyNo
	*/
	public void	setSkdVoyNo( String	skdVoyNo ) {
		this.skdVoyNo =	skdVoyNo;
	}
 
	/**
	 * Column Info
	 * @return	skdVoyNo
	 */
	 public	String	getSkdVoyNo() {
		 return	this.skdVoyNo;
	 } 
 	/**
	* Column Info
	* @param  vvd
	*/
	public void	setVvd( String	vvd ) {
		this.vvd =	vvd;
	}
 
	/**
	 * Column Info
	 * @return	vvd
	 */
	 public	String	getVvd() {
		 return	this.vvd;
	 } 
 	/**
	* Column Info
	* @param  podCd
	*/
	public void	setPodCd( String	podCd ) {
		this.podCd =	podCd;
	}
 
	/**
	 * Column Info
	 * @return	podCd
	 */
	 public	String	getPodCd() {
		 return	this.podCd;
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
	* @param  xterRqstAcptCd
	*/
	public void	setXterRqstAcptCd( String	xterRqstAcptCd ) {
		this.xterRqstAcptCd =	xterRqstAcptCd;
	}
 
	/**
	 * Column Info
	 * @return	xterRqstAcptCd
	 */
	 public	String	getXterRqstAcptCd() {
		 return	this.xterRqstAcptCd;
	 } 
 	/**
	* Column Info
	* @param  poNo
	*/
	public void	setPoNo( String	poNo ) {
		this.poNo =	poNo;
	}
 
	/**
	 * Column Info
	 * @return	poNo
	 */
	 public	String	getPoNo() {
		 return	this.poNo;
	 } 
 	/**
	* Column Info
	* @param  rqstToDt
	*/
	public void	setRqstToDt( String	rqstToDt ) {
		this.rqstToDt =	rqstToDt;
	}
 
	/**
	 * Column Info
	 * @return	rqstToDt
	 */
	 public	String	getRqstToDt() {
		 return	this.rqstToDt;
	 } 
 	/**
	* Column Info
	* @param  teu
	*/
	public void	setTeu( String	teu ) {
		this.teu =	teu;
	}
 
	/**
	 * Column Info
	 * @return	teu
	 */
	 public	String	getTeu() {
		 return	this.teu;
	 } 
 	/**
	* Column Info
	* @param  delivery
	*/
	public void	setDelivery( String	delivery ) {
		this.delivery =	delivery;
	}
 
	/**
	 * Column Info
	 * @return	delivery
	 */
	 public	String	getDelivery() {
		 return	this.delivery;
	 } 
 	/**
	* Column Info
	* @param  rowNum
	*/
	public void	setRowNum( String	rowNum ) {
		this.rowNum =	rowNum;
	}
 
	/**
	 * Column Info
	 * @return	rowNum
	 */
	 public	String	getRowNum() {
		 return	this.rowNum;
	 } 
 	/**
	* Column Info
	* @param  reject
	*/
	public void	setReject( String	reject ) {
		this.reject =	reject;
	}
 
	/**
	 * Column Info
	 * @return	reject
	 */
	 public	String	getReject() {
		 return	this.reject;
	 } 
 	/**
	* Column Info
	* @param  bkgStsCd
	*/
	public void	setBkgStsCd( String	bkgStsCd ) {
		this.bkgStsCd =	bkgStsCd;
	}
 
	/**
	 * Column Info
	 * @return	bkgStsCd
	 */
	 public	String	getBkgStsCd() {
		 return	this.bkgStsCd;
	 } 
 	/**
	* Column Info
	* @param  sumTeu
	*/
	public void	setSumTeu( String	sumTeu ) {
		this.sumTeu =	sumTeu;
	}
 
	/**
	 * Column Info
	 * @return	sumTeu
	 */
	 public	String	getSumTeu() {
		 return	this.sumTeu;
	 } 
 	/**
	* Column Info
	* @param  cntcEml
	*/
	public void	setCntcEml( String	cntcEml ) {
		this.cntcEml =	cntcEml;
	}
 
	/**
	 * Column Info
	 * @return	cntcEml
	 */
	 public	String	getCntcEml() {
		 return	this.cntcEml;
	 } 
 	/**
	* Column Info
	* @param  bkgUpldStsCd
	*/
	public void	setBkgUpldStsCd( String	bkgUpldStsCd ) {
		this.bkgUpldStsCd =	bkgUpldStsCd;
	}
 
	/**
	 * Column Info
	 * @return	bkgUpldStsCd
	 */
	 public	String	getBkgUpldStsCd() {
		 return	this.bkgUpldStsCd;
	 } 
 	/**
	* Column Info
	* @param  xterBkgRqstStsCd
	*/
	public void	setXterBkgRqstStsCd( String	xterBkgRqstStsCd ) {
		this.xterBkgRqstStsCd =	xterBkgRqstStsCd;
	}
 
	/**
	 * Column Info
	 * @return	xterBkgRqstStsCd
	 */
	 public	String	getXterBkgRqstStsCd() {
		 return	this.xterBkgRqstStsCd;
	 } 
 	/**
	* Column Info
	* @param  xterDelCd
	*/
	public void	setXterDelCd( String	xterDelCd ) {
		this.xterDelCd =	xterDelCd;
	}
 
	/**
	 * Column Info
	 * @return	xterDelCd
	 */
	 public	String	getXterDelCd() {
		 return	this.xterDelCd;
	 } 
 	/**
	* Column Info
	* @param  xterPolCd
	*/
	public void	setXterPolCd( String	xterPolCd ) {
		this.xterPolCd =	xterPolCd;
	}
 
	/**
	 * Column Info
	 * @return	xterPolCd
	 */
	 public	String	getXterPolCd() {
		 return	this.xterPolCd;
	 } 
 	/**
	* Column Info
	* @param  rfaNo
	*/
	public void	setRfaNo( String	rfaNo ) {
		this.rfaNo =	rfaNo;
	}
 
	/**
	 * Column Info
	 * @return	rfaNo
	 */
	 public	String	getRfaNo() {
		 return	this.rfaNo;
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
	* @param  vslEngNm
	*/
	public void	setVslEngNm( String	vslEngNm ) {
		this.vslEngNm =	vslEngNm;
	}
 
	/**
	 * Column Info
	 * @return	vslEngNm
	 */
	 public	String	getVslEngNm() {
		 return	this.vslEngNm;
	 } 
 	/**
	* Column Info
	* @param  sumUnu
	*/
	public void	setSumUnu( String	sumUnu ) {
		this.sumUnu =	sumUnu;
	}
 
	/**
	 * Column Info
	 * @return	sumUnu
	 */
	 public	String	getSumUnu() {
		 return	this.sumUnu;
	 } 
 	/**
	* Column Info
	* @param  shNm
	*/
	public void	setShNm( String	shNm ) {
		this.shNm =	shNm;
	}
 
	/**
	 * Column Info
	 * @return	shNm
	 */
	 public	String	getShNm() {
		 return	this.shNm;
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
	* @param  mdfyXterRqstNo
	*/
	public void	setMdfyXterRqstNo( String	mdfyXterRqstNo ) {
		this.mdfyXterRqstNo =	mdfyXterRqstNo;
	}
 
	/**
	 * Column Info
	 * @return	mdfyXterRqstNo
	 */
	 public	String	getMdfyXterRqstNo() {
		 return	this.mdfyXterRqstNo;
	 } 
 	/**
	* Column Info
	* @param  rqstDepDt
	*/
	public void	setRqstDepDt( String	rqstDepDt ) {
		this.rqstDepDt =	rqstDepDt;
	}
 
	/**
	 * Column Info
	 * @return	rqstDepDt
	 */
	 public	String	getRqstDepDt() {
		 return	this.rqstDepDt;
	 } 
 	/**
	* Column Info
	* @param  rqstFromDt
	*/
	public void	setRqstFromDt( String	rqstFromDt ) {
		this.rqstFromDt =	rqstFromDt;
	}
 
	/**
	 * Column Info
	 * @return	rqstFromDt
	 */
	 public	String	getRqstFromDt() {
		 return	this.rqstFromDt;
	 } 
 	/**
	* Column Info
	* @param  ofcCd
	*/
	public void	setOfcCd( String	ofcCd ) {
		this.ofcCd =	ofcCd;
	}
 
	/**
	 * Column Info
	 * @return	ofcCd
	 */
	 public	String	getOfcCd() {
		 return	this.ofcCd;
	 } 
 	/**
	* Column Info
	* @param  upldUsrNm
	*/
	public void	setUpldUsrNm( String	upldUsrNm ) {
		this.upldUsrNm =	upldUsrNm;
	}
 
	/**
	 * Column Info
	 * @return	upldUsrNm
	 */
	 public	String	getUpldUsrNm() {
		 return	this.upldUsrNm;
	 } 
 	/**
	* Column Info
	* @param  frtTerm
	*/
	public void	setFrtTerm( String	frtTerm ) {
		this.frtTerm =	frtTerm;
	}
 
	/**
	 * Column Info
	 * @return	frtTerm
	 */
	 public	String	getFrtTerm() {
		 return	this.frtTerm;
	 } 
 	/**
	* Column Info
	* @param  xterRqstSeq
	*/
	public void	setXterRqstSeq( String	xterRqstSeq ) {
		this.xterRqstSeq =	xterRqstSeq;
	}
 
	/**
	 * Column Info
	 * @return	xterRqstSeq
	 */
	 public	String	getXterRqstSeq() {
		 return	this.xterRqstSeq;
	 } 
 	/**
	* Column Info
	* @param  xterRqstNo
	*/
	public void	setXterRqstNo( String	xterRqstNo ) {
		this.xterRqstNo =	xterRqstNo;
	}
 
	/**
	 * Column Info
	 * @return	xterRqstNo
	 */
	 public	String	getXterRqstNo() {
		 return	this.xterRqstNo;
	 } 
 	/**
	* Column Info
	* @param  confirm
	*/
	public void	setConfirm( String	confirm ) {
		this.confirm =	confirm;
	}
 
	/**
	 * Column Info
	 * @return	confirm
	 */
	 public	String	getConfirm() {
		 return	this.confirm;
	 } 
 	/**
	* Column Info
	* @param  cnNm
	*/
	public void	setCnNm( String	cnNm ) {
		this.cnNm =	cnNm;
	}
 
	/**
	 * Column Info
	 * @return	cnNm
	 */
	 public	String	getCnNm() {
		 return	this.cnNm;
	 } 
 	/**
	* Column Info
	* @param  spcCtrlrRmk
	*/
	public void	setSpcCtrlrRmk( String	spcCtrlrRmk ) {
		this.spcCtrlrRmk =	spcCtrlrRmk;
	}
 
	/**
	 * Column Info
	 * @return	spcCtrlrRmk
	 */
	 public	String	getSpcCtrlrRmk() {
		 return	this.spcCtrlrRmk;
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
		setVslCd(JSPUtil.getParameter(request,	prefix + "vsl_cd", ""));
		setSumUld(JSPUtil.getParameter(request,	prefix + "sum_uld", ""));
		setXterPodCd(JSPUtil.getParameter(request,	prefix + "xter_pod_cd", ""));
		setSumFeu(JSPUtil.getParameter(request,	prefix + "sum_feu", ""));
		setDocTpCd(JSPUtil.getParameter(request,	prefix + "doc_tp_cd", ""));
		setHndlOfcCd(JSPUtil.getParameter(request,	prefix + "hndl_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setBkgPodCd(JSPUtil.getParameter(request,	prefix + "bkg_pod_cd", ""));
		setSumTtl(JSPUtil.getParameter(request,	prefix + "sum_ttl", ""));
		setScNo(JSPUtil.getParameter(request,	prefix + "sc_no", ""));
		setSumWgt(JSPUtil.getParameter(request,	prefix + "sum_wgt", ""));
		setXterPorCd(JSPUtil.getParameter(request,	prefix + "xter_por_cd", ""));
		setChnAgnCd(JSPUtil.getParameter(request,	prefix + "chn_agn_cd", ""));
		setFeu(JSPUtil.getParameter(request,	prefix + "feu", ""));
		setUpldUsrId(JSPUtil.getParameter(request,	prefix + "upld_usr_id", ""));
		setXterSndrId(JSPUtil.getParameter(request,	prefix + "xter_sndr_id", ""));
		setEstWgt(JSPUtil.getParameter(request,	prefix + "est_wgt", ""));
		setSnaccsSplitNo(JSPUtil.getParameter(request,	prefix + "snaccs_split_no", ""));
		setSkdVoyNo(JSPUtil.getParameter(request,	prefix + "skd_voy_no", ""));
		setVvd(JSPUtil.getParameter(request,	prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setXterRqstAcptCd(JSPUtil.getParameter(request,	prefix + "xter_rqst_acpt_cd", ""));
		setPoNo(JSPUtil.getParameter(request,	prefix + "po_no", ""));
		setRqstToDt(JSPUtil.getParameter(request,	prefix + "rqst_to_dt", ""));
		setTeu(JSPUtil.getParameter(request,	prefix + "teu", ""));
		setDelivery(JSPUtil.getParameter(request,	prefix + "delivery", ""));
		setRowNum(JSPUtil.getParameter(request,	prefix + "row_num", ""));
		setReject(JSPUtil.getParameter(request,	prefix + "reject", ""));
		setBkgStsCd(JSPUtil.getParameter(request,	prefix + "bkg_sts_cd", ""));
		setSumTeu(JSPUtil.getParameter(request,	prefix + "sum_teu", ""));
		setCntcEml(JSPUtil.getParameter(request,	prefix + "cntc_eml", ""));
		setBkgUpldStsCd(JSPUtil.getParameter(request,	prefix + "bkg_upld_sts_cd", ""));
		setXterBkgRqstStsCd(JSPUtil.getParameter(request,	prefix + "xter_bkg_rqst_sts_cd", ""));
		setXterDelCd(JSPUtil.getParameter(request,	prefix + "xter_del_cd", ""));
		setXterPolCd(JSPUtil.getParameter(request,	prefix + "xter_pol_cd", ""));
		setRfaNo(JSPUtil.getParameter(request,	prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setVslEngNm(JSPUtil.getParameter(request,	prefix + "vsl_eng_nm", ""));
		setSumUnu(JSPUtil.getParameter(request,	prefix + "sum_unu", ""));
		setShNm(JSPUtil.getParameter(request,	prefix + "sh_nm", ""));
		setXterRqstViaCd(JSPUtil.getParameter(request,	prefix + "xter_rqst_via_cd", ""));
		setUpldDt(JSPUtil.getParameter(request,	prefix + "upld_dt", ""));
		setRqstDt(JSPUtil.getParameter(request,	prefix + "rqst_dt", ""));
		setMdfyXterRqstNo(JSPUtil.getParameter(request,	prefix + "mdfy_xter_rqst_no", ""));
		setRqstDepDt(JSPUtil.getParameter(request,	prefix + "rqst_dep_dt", ""));
		setRqstFromDt(JSPUtil.getParameter(request,	prefix + "rqst_from_dt", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setUpldUsrNm(JSPUtil.getParameter(request,	prefix + "upld_usr_nm", ""));
		setFrtTerm(JSPUtil.getParameter(request,	prefix + "frt_term", ""));
		setXterRqstSeq(JSPUtil.getParameter(request,	prefix + "xter_rqst_seq", ""));
		setXterRqstNo(JSPUtil.getParameter(request,	prefix + "xter_rqst_no", ""));
		setConfirm(JSPUtil.getParameter(request,	prefix + "confirm", ""));
		setCnNm(JSPUtil.getParameter(request,	prefix + "cn_nm", ""));
		setSpcCtrlrRmk(JSPUtil.getParameter(request,	prefix + "spc_ctrlr_rmk", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EBookingControlMgmtVO[]
	 */
	public EBookingControlMgmtVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return EBookingControlMgmtVO[]
	 */
	public EBookingControlMgmtVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		EBookingControlMgmtVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] vslCd =	(JSPUtil.getParameter(request, prefix +	"vsl_cd".trim(),	length));
				String[] sumUld =	(JSPUtil.getParameter(request, prefix +	"sum_uld".trim(),	length));
				String[] xterPodCd =	(JSPUtil.getParameter(request, prefix +	"xter_pod_cd".trim(),	length));
				String[] sumFeu =	(JSPUtil.getParameter(request, prefix +	"sum_feu".trim(),	length));
				String[] docTpCd =	(JSPUtil.getParameter(request, prefix +	"doc_tp_cd".trim(),	length));
				String[] hndlOfcCd =	(JSPUtil.getParameter(request, prefix +	"hndl_ofc_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd".trim(),	length));
				String[] bkgPodCd =	(JSPUtil.getParameter(request, prefix +	"bkg_pod_cd".trim(),	length));
				String[] sumTtl =	(JSPUtil.getParameter(request, prefix +	"sum_ttl".trim(),	length));
				String[] scNo =	(JSPUtil.getParameter(request, prefix +	"sc_no".trim(),	length));
				String[] sumWgt =	(JSPUtil.getParameter(request, prefix +	"sum_wgt".trim(),	length));
				String[] xterPorCd =	(JSPUtil.getParameter(request, prefix +	"xter_por_cd".trim(),	length));
				String[] chnAgnCd =	(JSPUtil.getParameter(request, prefix +	"chn_agn_cd".trim(),	length));
				String[] feu =	(JSPUtil.getParameter(request, prefix +	"feu".trim(),	length));
				String[] upldUsrId =	(JSPUtil.getParameter(request, prefix +	"upld_usr_id".trim(),	length));
				String[] xterSndrId =	(JSPUtil.getParameter(request, prefix +	"xter_sndr_id".trim(),	length));
				String[] estWgt =	(JSPUtil.getParameter(request, prefix +	"est_wgt".trim(),	length));
				String[] snaccsSplitNo =	(JSPUtil.getParameter(request, prefix +	"snaccs_split_no".trim(),	length));
				String[] skdVoyNo =	(JSPUtil.getParameter(request, prefix +	"skd_voy_no".trim(),	length));
				String[] vvd =	(JSPUtil.getParameter(request, prefix +	"vvd".trim(),	length));
				String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] xterRqstAcptCd =	(JSPUtil.getParameter(request, prefix +	"xter_rqst_acpt_cd".trim(),	length));
				String[] poNo =	(JSPUtil.getParameter(request, prefix +	"po_no".trim(),	length));
				String[] rqstToDt =	(JSPUtil.getParameter(request, prefix +	"rqst_to_dt".trim(),	length));
				String[] teu =	(JSPUtil.getParameter(request, prefix +	"teu".trim(),	length));
				String[] delivery =	(JSPUtil.getParameter(request, prefix +	"delivery".trim(),	length));
				String[] rowNum =	(JSPUtil.getParameter(request, prefix +	"row_num".trim(),	length));
				String[] reject =	(JSPUtil.getParameter(request, prefix +	"reject".trim(),	length));
				String[] bkgStsCd =	(JSPUtil.getParameter(request, prefix +	"bkg_sts_cd".trim(),	length));
				String[] sumTeu =	(JSPUtil.getParameter(request, prefix +	"sum_teu".trim(),	length));
				String[] cntcEml =	(JSPUtil.getParameter(request, prefix +	"cntc_eml".trim(),	length));
				String[] bkgUpldStsCd =	(JSPUtil.getParameter(request, prefix +	"bkg_upld_sts_cd".trim(),	length));
				String[] xterBkgRqstStsCd =	(JSPUtil.getParameter(request, prefix +	"xter_bkg_rqst_sts_cd".trim(),	length));
				String[] xterDelCd =	(JSPUtil.getParameter(request, prefix +	"xter_del_cd".trim(),	length));
				String[] xterPolCd =	(JSPUtil.getParameter(request, prefix +	"xter_pol_cd".trim(),	length));
				String[] rfaNo =	(JSPUtil.getParameter(request, prefix +	"rfa_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] vslEngNm =	(JSPUtil.getParameter(request, prefix +	"vsl_eng_nm".trim(),	length));
				String[] sumUnu =	(JSPUtil.getParameter(request, prefix +	"sum_unu".trim(),	length));
				String[] shNm =	(JSPUtil.getParameter(request, prefix +	"sh_nm".trim(),	length));
				String[] xterRqstViaCd =	(JSPUtil.getParameter(request, prefix +	"xter_rqst_via_cd".trim(),	length));
				String[] upldDt =	(JSPUtil.getParameter(request, prefix +	"upld_dt".trim(),	length));
				String[] rqstDt =	(JSPUtil.getParameter(request, prefix +	"rqst_dt".trim(),	length));
				String[] mdfyXterRqstNo =	(JSPUtil.getParameter(request, prefix +	"mdfy_xter_rqst_no".trim(),	length));
				String[] rqstDepDt =	(JSPUtil.getParameter(request, prefix +	"rqst_dep_dt".trim(),	length));
				String[] rqstFromDt =	(JSPUtil.getParameter(request, prefix +	"rqst_from_dt".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] upldUsrNm =	(JSPUtil.getParameter(request, prefix +	"upld_usr_nm".trim(),	length));
				String[] frtTerm =	(JSPUtil.getParameter(request, prefix +	"frt_term".trim(),	length));
				String[] xterRqstSeq =	(JSPUtil.getParameter(request, prefix +	"xter_rqst_seq".trim(),	length));
				String[] xterRqstNo =	(JSPUtil.getParameter(request, prefix +	"xter_rqst_no".trim(),	length));
				String[] confirm =	(JSPUtil.getParameter(request, prefix +	"confirm".trim(),	length));
				String[] cnNm =	(JSPUtil.getParameter(request, prefix +	"cn_nm".trim(),	length));
				String[] spcCtrlrRmk =	(JSPUtil.getParameter(request, prefix +	"spc_ctrlr_rmk".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	EBookingControlMgmtVO();
						if ( vslCd[i] !=	null)
						model.setVslCd( vslCd[i]);
						if ( sumUld[i] !=	null)
						model.setSumUld( sumUld[i]);
						if ( xterPodCd[i] !=	null)
						model.setXterPodCd( xterPodCd[i]);
						if ( sumFeu[i] !=	null)
						model.setSumFeu( sumFeu[i]);
						if ( docTpCd[i] !=	null)
						model.setDocTpCd( docTpCd[i]);
						if ( hndlOfcCd[i] !=	null)
						model.setHndlOfcCd( hndlOfcCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( polCd[i] !=	null)
						model.setPolCd( polCd[i]);
						if ( bkgPodCd[i] !=	null)
						model.setBkgPodCd( bkgPodCd[i]);
						if ( sumTtl[i] !=	null)
						model.setSumTtl( sumTtl[i]);
						if ( scNo[i] !=	null)
						model.setScNo( scNo[i]);
						if ( sumWgt[i] !=	null)
						model.setSumWgt( sumWgt[i]);
						if ( xterPorCd[i] !=	null)
						model.setXterPorCd( xterPorCd[i]);
						if ( chnAgnCd[i] !=	null)
						model.setChnAgnCd( chnAgnCd[i]);
						if ( feu[i] !=	null)
						model.setFeu( feu[i]);
						if ( upldUsrId[i] !=	null)
						model.setUpldUsrId( upldUsrId[i]);
						if ( xterSndrId[i] !=	null)
						model.setXterSndrId( xterSndrId[i]);
						if ( estWgt[i] !=	null)
						model.setEstWgt( estWgt[i]);
						if ( snaccsSplitNo[i] !=	null)
						model.setSnaccsSplitNo( snaccsSplitNo[i]);
						if ( skdVoyNo[i] !=	null)
						model.setSkdVoyNo( skdVoyNo[i]);
						if ( vvd[i] !=	null)
						model.setVvd( vvd[i]);
						if ( podCd[i] !=	null)
						model.setPodCd( podCd[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( xterRqstAcptCd[i] !=	null)
						model.setXterRqstAcptCd( xterRqstAcptCd[i]);
						if ( poNo[i] !=	null)
						model.setPoNo( poNo[i]);
						if ( rqstToDt[i] !=	null)
						model.setRqstToDt( rqstToDt[i]);
						if ( teu[i] !=	null)
						model.setTeu( teu[i]);
						if ( delivery[i] !=	null)
						model.setDelivery( delivery[i]);
						if ( rowNum[i] !=	null)
						model.setRowNum( rowNum[i]);
						if ( reject[i] !=	null)
						model.setReject( reject[i]);
						if ( bkgStsCd[i] !=	null)
						model.setBkgStsCd( bkgStsCd[i]);
						if ( sumTeu[i] !=	null)
						model.setSumTeu( sumTeu[i]);
						if ( cntcEml[i] !=	null)
						model.setCntcEml( cntcEml[i]);
						if ( bkgUpldStsCd[i] !=	null)
						model.setBkgUpldStsCd( bkgUpldStsCd[i]);
						if ( xterBkgRqstStsCd[i] !=	null)
						model.setXterBkgRqstStsCd( xterBkgRqstStsCd[i]);
						if ( xterDelCd[i] !=	null)
						model.setXterDelCd( xterDelCd[i]);
						if ( xterPolCd[i] !=	null)
						model.setXterPolCd( xterPolCd[i]);
						if ( rfaNo[i] !=	null)
						model.setRfaNo( rfaNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( vslEngNm[i] !=	null)
						model.setVslEngNm( vslEngNm[i]);
						if ( sumUnu[i] !=	null)
						model.setSumUnu( sumUnu[i]);
						if ( shNm[i] !=	null)
						model.setShNm( shNm[i]);
						if ( xterRqstViaCd[i] !=	null)
						model.setXterRqstViaCd( xterRqstViaCd[i]);
						if ( upldDt[i] !=	null)
						model.setUpldDt( upldDt[i]);
						if ( rqstDt[i] !=	null)
						model.setRqstDt( rqstDt[i]);
						if ( mdfyXterRqstNo[i] !=	null)
						model.setMdfyXterRqstNo( mdfyXterRqstNo[i]);
						if ( rqstDepDt[i] !=	null)
						model.setRqstDepDt( rqstDepDt[i]);
						if ( rqstFromDt[i] !=	null)
						model.setRqstFromDt( rqstFromDt[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( upldUsrNm[i] !=	null)
						model.setUpldUsrNm( upldUsrNm[i]);
						if ( frtTerm[i] !=	null)
						model.setFrtTerm( frtTerm[i]);
						if ( xterRqstSeq[i] !=	null)
						model.setXterRqstSeq( xterRqstSeq[i]);
						if ( xterRqstNo[i] !=	null)
						model.setXterRqstNo( xterRqstNo[i]);
						if ( confirm[i] !=	null)
						model.setConfirm( confirm[i]);
						if ( cnNm[i] !=	null)
						model.setCnNm( cnNm[i]);
						if ( spcCtrlrRmk[i] !=	null)
						model.setSpcCtrlrRmk( spcCtrlrRmk[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getEBookingControlMgmtVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return EBookingControlMgmtVO[]
	 */
	public EBookingControlMgmtVO[]	 getEBookingControlMgmtVOs(){
		EBookingControlMgmtVO[] vos = (EBookingControlMgmtVO[])models.toArray(new	EBookingControlMgmtVO[models.size()]);
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
		this.vslCd =	this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumUld =	this.sumUld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterPodCd =	this.xterPodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumFeu =	this.sumFeu.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docTpCd =	this.docTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hndlOfcCd =	this.hndlOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCd =	this.bkgPodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumTtl =	this.sumTtl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo =	this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumWgt =	this.sumWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterPorCd =	this.xterPorCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chnAgnCd =	this.chnAgnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feu =	this.feu.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.upldUsrId =	this.upldUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterSndrId =	this.xterSndrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estWgt =	this.estWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.snaccsSplitNo =	this.snaccsSplitNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo =	this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd =	this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstAcptCd =	this.xterRqstAcptCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poNo =	this.poNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstToDt =	this.rqstToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu =	this.teu.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delivery =	this.delivery.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowNum =	this.rowNum.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reject =	this.reject.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd =	this.bkgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumTeu =	this.sumTeu.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcEml =	this.cntcEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgUpldStsCd =	this.bkgUpldStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterBkgRqstStsCd =	this.xterBkgRqstStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterDelCd =	this.xterDelCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterPolCd =	this.xterPolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo =	this.rfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm =	this.vslEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumUnu =	this.sumUnu.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shNm =	this.shNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstViaCd =	this.xterRqstViaCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.upldDt =	this.upldDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt =	this.rqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdfyXterRqstNo =	this.mdfyXterRqstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDepDt =	this.rqstDepDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstFromDt =	this.rqstFromDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.upldUsrNm =	this.upldUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTerm =	this.frtTerm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstSeq =	this.xterRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstNo =	this.xterRqstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.confirm =	this.confirm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnNm =	this.cnNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcCtrlrRmk =	this.spcCtrlrRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}
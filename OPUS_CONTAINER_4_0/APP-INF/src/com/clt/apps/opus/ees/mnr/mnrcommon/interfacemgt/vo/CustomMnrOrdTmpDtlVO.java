/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : CustomMnrOrdTmpDtlVO.java
 *@FileTitle : CustomMnrOrdTmpDtlVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.11.26
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2014.11.26 박광석 
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo;

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
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 박광석
 * @since J2EE 1.6
 * @see	..
 */
public class CustomMnrOrdTmpDtlVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<CustomMnrOrdTmpDtlVO>  models =	new	ArrayList<CustomMnrOrdTmpDtlVO>();


	/*	Column Info	*/
	private  String	 mnrHngrTrfOtrDesc   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 mnrOrdOfcCtyCd   =  null;
	/*	Column Info	*/
	private  String	 costCd   =  null;
	/*	Column Info	*/
	private  String	 mnrHngrBarTpCd   =  null;
	/*	Column Info	*/
	private  String	 mnrLostHngrQty   =  null;
	/*	Column Info	*/
	private  String	 rprOffhFlg   =  null;
	/*	Column Info	*/
	private  String	 n3ptyBilTtlAmt   =  null;
	/*	Column Info	*/
	private  String	 mnrDispHngrQty   =  null;
	/*	Column Info	*/
	private  String	 sprPrtUcAmt   =  null;
	/*	Column Info	*/
	private  String	 rprRqstSeq   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 ordDtlRmk   =  null;
	/*	Column Info	*/
	private  String	 mnrOrgHngrBarTpCd   =  null;
	/*	Column Info	*/
	private  String	 mnrHngrFlgDt   =  null;
	/*	Column Info	*/
	private  String	 mnrExpnDtlNm   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd   =  null;
	/*	Column Info	*/
	private  String	 slsTaxAmt   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 fileSeq   =  null;
	/*	Column Info	*/
	private  String	 sprPrtUtTpNm   =  null;
	/*	Column Info	*/
	private  String	 mnrHngrDmgQty   =  null;
	/*	Column Info	*/
	private  String	 rprRsltDt   =  null;
	/*	Column Info	*/
	private  String	 recentRprQty   =  null;
	/*	Column Info	*/
	private  String	 mnrVrfyTpCd   =  null;
	/*	Column Info	*/
	private  String	 payInvSeq   =  null;
	/*	Column Info	*/
	private  String	 rprRqstVerNo   =  null;
	/*	Column Info	*/
	private  String	 barIfChk   =  null;
	/*	Column Info	*/
	private  String	 rqstRefNo   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 sprPrtNo   =  null;
	/*	Column Info	*/
	private  String	 mnrRtTpCd   =  null;
	/*	Column Info	*/
	private  String	 sprPrtNm   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 eqNo   =  null;
	/*	Column Info	*/
	private  String	 costAmt   =  null;
	/*	Column Info	*/
	private  String	 acctCd   =  null;
	/*	Column Info	*/
	private  String	 rprQty   =  null;
	/*	Column Info	*/
	private  String	 invAmt   =  null;
	/*	Column Info	*/
	private  String	 mnrHngrDtlOffrDesc   =  null;
	/*	Column Info	*/
	private  String	 n3ptyFlg   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 mnrHngrFlgYdCd   =  null;
	/*	Column Info	*/
	private  String	 ordDtlSeq   =  null;
	/*	Column Info	*/
	private  String	 costDtlCd   =  null;
	/*	Column Info	*/
	private  String	 eqKndCd   =  null;
	/*	Column Info	*/
	private  String	 bzcAmt   =  null;
	/*	Column Info	*/
	private  String	 actInvtQty   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 mnrOrdSeq   =  null;
	/*	Column Info	*/
	private  String	 ydCd   =  null;
	/*	Column Info	*/
	private  String	 mnrHngrRckCd   =  null;
	/*	Column Info	*/
	private  String	 mnrHngrTrfCd   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 trdCd   =  null;
	/*	Column Info	*/
	private  String	 mnrRcvOrdInvTmpSeq   =  null;
	/*	Column Info	*/
	private  String	 mnrRcvOrdInvTmpDtlSeq   =  null;
	/*	Column Info	*/
	private  String	 eqStsCd   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 vrfyRsltDesc   =  null;
	/*	Column Info	*/
	private  String  jbOrdrSeq  =  null;
	/*	Column Info	*/
	private  String  vslCd  =  null;
	/*	Column Info	*/
	private  String  skdVoyNo  =  null;
	/*	Column Info	*/
	private  String  portCd  =  null;
	/*	Column Info	*/
	private  String  slanCd  =  null;
	/*	Column Info	*/
	private  String  type  =  null;
	/*	Column Info	*/
	private  String  costCdAll  =  null;
	/*	Column Info	*/
	private  String  qtyFlg  =  null;
	/*	Column Info	*/
	private  String  vvd  =  null;
	/*	Column Info	*/
	private  String  skdDirCd  =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public CustomMnrOrdTmpDtlVO(){}

	public CustomMnrOrdTmpDtlVO(String mnrHngrTrfOtrDesc,String pagerows,String mnrOrdOfcCtyCd,String costCd,String mnrHngrBarTpCd,String mnrLostHngrQty,String rprOffhFlg,String n3ptyBilTtlAmt,String mnrDispHngrQty,String sprPrtUcAmt,String rprRqstSeq,String updUsrId,String ordDtlRmk,String mnrOrgHngrBarTpCd,String mnrHngrFlgDt,String mnrExpnDtlNm,String eqTpszCd,String slsTaxAmt,String creUsrId,String fileSeq,String sprPrtUtTpNm,String mnrHngrDmgQty,String rprRsltDt,String recentRprQty,String mnrVrfyTpCd,String payInvSeq,String rprRqstVerNo,String barIfChk,String rqstRefNo,String creDt,String sprPrtNo,String mnrRtTpCd,String sprPrtNm,String ibflag,String eqNo,String costAmt,String acctCd,String rprQty,String invAmt,String mnrHngrDtlOffrDesc,String n3ptyFlg,String updDt,String mnrHngrFlgYdCd,String ordDtlSeq,String costDtlCd,String eqKndCd,String bzcAmt,String actInvtQty,String invNo,String mnrOrdSeq,String ydCd,String mnrHngrRckCd,String mnrHngrTrfCd,String bkgNo,String trdCd,String mnrRcvOrdInvTmpSeq,String mnrRcvOrdInvTmpDtlSeq,String eqStsCd,String vndrSeq,String currCd,String vrfyRsltDesc, String jbOrdrSeq, String vslCd, String skdVoyNo, String portCd, String slanCd, String costCdAll, String vvd, String skdDirCd)	{
		this.mnrHngrTrfOtrDesc  = mnrHngrTrfOtrDesc ;
		this.pagerows  = pagerows ;
		this.mnrOrdOfcCtyCd  = mnrOrdOfcCtyCd ;
		this.costCd  = costCd ;
		this.mnrHngrBarTpCd  = mnrHngrBarTpCd ;
		this.mnrLostHngrQty  = mnrLostHngrQty ;
		this.rprOffhFlg  = rprOffhFlg ;
		this.n3ptyBilTtlAmt  = n3ptyBilTtlAmt ;
		this.mnrDispHngrQty  = mnrDispHngrQty ;
		this.sprPrtUcAmt  = sprPrtUcAmt ;
		this.rprRqstSeq  = rprRqstSeq ;
		this.updUsrId  = updUsrId ;
		this.ordDtlRmk  = ordDtlRmk ;
		this.mnrOrgHngrBarTpCd  = mnrOrgHngrBarTpCd ;
		this.mnrHngrFlgDt  = mnrHngrFlgDt ;
		this.mnrExpnDtlNm  = mnrExpnDtlNm ;
		this.eqTpszCd  = eqTpszCd ;
		this.slsTaxAmt  = slsTaxAmt ;
		this.creUsrId  = creUsrId ;
		this.fileSeq  = fileSeq ;
		this.sprPrtUtTpNm  = sprPrtUtTpNm ;
		this.mnrHngrDmgQty  = mnrHngrDmgQty ;
		this.rprRsltDt  = rprRsltDt ;
		this.recentRprQty  = recentRprQty ;
		this.mnrVrfyTpCd  = mnrVrfyTpCd ;
		this.payInvSeq  = payInvSeq ;
		this.rprRqstVerNo  = rprRqstVerNo ;
		this.barIfChk  = barIfChk ;
		this.rqstRefNo  = rqstRefNo ;
		this.creDt  = creDt ;
		this.sprPrtNo  = sprPrtNo ;
		this.mnrRtTpCd  = mnrRtTpCd ;
		this.sprPrtNm  = sprPrtNm ;
		this.ibflag  = ibflag ;
		this.eqNo  = eqNo ;
		this.costAmt  = costAmt ;
		this.acctCd  = acctCd ;
		this.rprQty  = rprQty ;
		this.invAmt  = invAmt ;
		this.mnrHngrDtlOffrDesc  = mnrHngrDtlOffrDesc ;
		this.n3ptyFlg  = n3ptyFlg ;
		this.updDt  = updDt ;
		this.mnrHngrFlgYdCd  = mnrHngrFlgYdCd ;
		this.ordDtlSeq  = ordDtlSeq ;
		this.costDtlCd  = costDtlCd ;
		this.eqKndCd  = eqKndCd ;
		this.bzcAmt  = bzcAmt ;
		this.actInvtQty  = actInvtQty ;
		this.invNo  = invNo ;
		this.mnrOrdSeq  = mnrOrdSeq ;
		this.ydCd  = ydCd ;
		this.mnrHngrRckCd  = mnrHngrRckCd ;
		this.mnrHngrTrfCd  = mnrHngrTrfCd ;
		this.bkgNo  = bkgNo ;
		this.trdCd  = trdCd ;
		this.mnrRcvOrdInvTmpSeq  = mnrRcvOrdInvTmpSeq ;
		this.mnrRcvOrdInvTmpDtlSeq  = mnrRcvOrdInvTmpDtlSeq ;
		this.eqStsCd  = eqStsCd ;
		this.vndrSeq  = vndrSeq ;
		this.currCd  = currCd ;
		this.vrfyRsltDesc  = vrfyRsltDesc ;
		this.jbOrdrSeq = jbOrdrSeq;
		this.vslCd = vslCd;
		this.skdVoyNo = skdVoyNo;
		this.portCd = portCd;
		this.slanCd = slanCd;
		this.costCdAll = costCdAll;
		this.vvd = vvd;
		this.skdDirCd = skdDirCd;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mnr_hngr_trf_otr_desc", getMnrHngrTrfOtrDesc());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("mnr_ord_ofc_cty_cd", getMnrOrdOfcCtyCd());		
		this.hashColumns.put("cost_cd", getCostCd());		
		this.hashColumns.put("mnr_hngr_bar_tp_cd", getMnrHngrBarTpCd());		
		this.hashColumns.put("mnr_lost_hngr_qty", getMnrLostHngrQty());		
		this.hashColumns.put("rpr_offh_flg", getRprOffhFlg());		
		this.hashColumns.put("n3pty_bil_ttl_amt", getN3ptyBilTtlAmt());		
		this.hashColumns.put("mnr_disp_hngr_qty", getMnrDispHngrQty());		
		this.hashColumns.put("spr_prt_uc_amt", getSprPrtUcAmt());		
		this.hashColumns.put("rpr_rqst_seq", getRprRqstSeq());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("ord_dtl_rmk", getOrdDtlRmk());		
		this.hashColumns.put("mnr_org_hngr_bar_tp_cd", getMnrOrgHngrBarTpCd());		
		this.hashColumns.put("mnr_hngr_flg_dt", getMnrHngrFlgDt());		
		this.hashColumns.put("mnr_expn_dtl_nm", getMnrExpnDtlNm());		
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());		
		this.hashColumns.put("sls_tax_amt", getSlsTaxAmt());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("file_seq", getFileSeq());		
		this.hashColumns.put("spr_prt_ut_tp_nm", getSprPrtUtTpNm());		
		this.hashColumns.put("mnr_hngr_dmg_qty", getMnrHngrDmgQty());		
		this.hashColumns.put("rpr_rslt_dt", getRprRsltDt());		
		this.hashColumns.put("recent_rpr_qty", getRecentRprQty());		
		this.hashColumns.put("mnr_vrfy_tp_cd", getMnrVrfyTpCd());		
		this.hashColumns.put("pay_inv_seq", getPayInvSeq());		
		this.hashColumns.put("rpr_rqst_ver_no", getRprRqstVerNo());		
		this.hashColumns.put("bar_if_chk", getBarIfChk());		
		this.hashColumns.put("rqst_ref_no", getRqstRefNo());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("spr_prt_no", getSprPrtNo());		
		this.hashColumns.put("mnr_rt_tp_cd", getMnrRtTpCd());		
		this.hashColumns.put("spr_prt_nm", getSprPrtNm());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("eq_no", getEqNo());		
		this.hashColumns.put("cost_amt", getCostAmt());		
		this.hashColumns.put("acct_cd", getAcctCd());		
		this.hashColumns.put("rpr_qty", getRprQty());		
		this.hashColumns.put("inv_amt", getInvAmt());		
		this.hashColumns.put("mnr_hngr_dtl_offr_desc", getMnrHngrDtlOffrDesc());		
		this.hashColumns.put("n3pty_flg", getN3ptyFlg());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("mnr_hngr_flg_yd_cd", getMnrHngrFlgYdCd());		
		this.hashColumns.put("ord_dtl_seq", getOrdDtlSeq());		
		this.hashColumns.put("cost_dtl_cd", getCostDtlCd());		
		this.hashColumns.put("eq_knd_cd", getEqKndCd());		
		this.hashColumns.put("bzc_amt", getBzcAmt());		
		this.hashColumns.put("act_invt_qty", getActInvtQty());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("mnr_ord_seq", getMnrOrdSeq());		
		this.hashColumns.put("yd_cd", getYdCd());		
		this.hashColumns.put("mnr_hngr_rck_cd", getMnrHngrRckCd());		
		this.hashColumns.put("mnr_hngr_trf_cd", getMnrHngrTrfCd());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("trd_cd", getTrdCd());		
		this.hashColumns.put("mnr_rcv_ord_inv_tmp_seq", getMnrRcvOrdInvTmpSeq());		
		this.hashColumns.put("mnr_rcv_ord_inv_tmp_dtl_seq", getMnrRcvOrdInvTmpDtlSeq());		
		this.hashColumns.put("eq_sts_cd", getEqStsCd());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("vrfy_rslt_desc", getVrfyRsltDesc());
		this.hashColumns.put("jb_ordr_seq", getJbOrdrSeq());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("cost_cd_all", getCostCdAll());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("mnr_hngr_trf_otr_desc", "mnrHngrTrfOtrDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mnr_ord_ofc_cty_cd", "mnrOrdOfcCtyCd");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("mnr_hngr_bar_tp_cd", "mnrHngrBarTpCd");
		this.hashFields.put("mnr_lost_hngr_qty", "mnrLostHngrQty");
		this.hashFields.put("rpr_offh_flg", "rprOffhFlg");
		this.hashFields.put("n3pty_bil_ttl_amt", "n3ptyBilTtlAmt");
		this.hashFields.put("mnr_disp_hngr_qty", "mnrDispHngrQty");
		this.hashFields.put("spr_prt_uc_amt", "sprPrtUcAmt");
		this.hashFields.put("rpr_rqst_seq", "rprRqstSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ord_dtl_rmk", "ordDtlRmk");
		this.hashFields.put("mnr_org_hngr_bar_tp_cd", "mnrOrgHngrBarTpCd");
		this.hashFields.put("mnr_hngr_flg_dt", "mnrHngrFlgDt");
		this.hashFields.put("mnr_expn_dtl_nm", "mnrExpnDtlNm");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("sls_tax_amt", "slsTaxAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("file_seq", "fileSeq");
		this.hashFields.put("spr_prt_ut_tp_nm", "sprPrtUtTpNm");
		this.hashFields.put("mnr_hngr_dmg_qty", "mnrHngrDmgQty");
		this.hashFields.put("rpr_rslt_dt", "rprRsltDt");
		this.hashFields.put("recent_rpr_qty", "recentRprQty");
		this.hashFields.put("mnr_vrfy_tp_cd", "mnrVrfyTpCd");
		this.hashFields.put("pay_inv_seq", "payInvSeq");
		this.hashFields.put("rpr_rqst_ver_no", "rprRqstVerNo");
		this.hashFields.put("bar_if_chk", "barIfChk");
		this.hashFields.put("rqst_ref_no", "rqstRefNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("spr_prt_no", "sprPrtNo");
		this.hashFields.put("mnr_rt_tp_cd", "mnrRtTpCd");
		this.hashFields.put("spr_prt_nm", "sprPrtNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("cost_amt", "costAmt");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("rpr_qty", "rprQty");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("mnr_hngr_dtl_offr_desc", "mnrHngrDtlOffrDesc");
		this.hashFields.put("n3pty_flg", "n3ptyFlg");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("mnr_hngr_flg_yd_cd", "mnrHngrFlgYdCd");
		this.hashFields.put("ord_dtl_seq", "ordDtlSeq");
		this.hashFields.put("cost_dtl_cd", "costDtlCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("bzc_amt", "bzcAmt");
		this.hashFields.put("act_invt_qty", "actInvtQty");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("mnr_ord_seq", "mnrOrdSeq");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("mnr_hngr_rck_cd", "mnrHngrRckCd");
		this.hashFields.put("mnr_hngr_trf_cd", "mnrHngrTrfCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("mnr_rcv_ord_inv_tmp_seq", "mnrRcvOrdInvTmpSeq");
		this.hashFields.put("mnr_rcv_ord_inv_tmp_dtl_seq", "mnrRcvOrdInvTmpDtlSeq");
		this.hashFields.put("eq_sts_cd", "eqStsCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("vrfy_rslt_desc", "vrfyRsltDesc");
		this.hashFields.put("jb_ordr_seq", "jbOrdrSeq");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("cost_cd_all", "costCdAll");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  mnrHngrTrfOtrDesc
	*/
	public void	setMnrHngrTrfOtrDesc( String	mnrHngrTrfOtrDesc ) {
		this.mnrHngrTrfOtrDesc =	mnrHngrTrfOtrDesc;
	}
 
	/**
	 * Column Info
	 * @return	mnrHngrTrfOtrDesc
	 */
	 public	 String	getMnrHngrTrfOtrDesc() {
		 return	this.mnrHngrTrfOtrDesc;
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
	 public	 String	getPagerows() {
		 return	this.pagerows;
	 } 
 	/**
	* Column Info
	* @param  mnrOrdOfcCtyCd
	*/
	public void	setMnrOrdOfcCtyCd( String	mnrOrdOfcCtyCd ) {
		this.mnrOrdOfcCtyCd =	mnrOrdOfcCtyCd;
	}
 
	/**
	 * Column Info
	 * @return	mnrOrdOfcCtyCd
	 */
	 public	 String	getMnrOrdOfcCtyCd() {
		 return	this.mnrOrdOfcCtyCd;
	 } 
 	/**
	* Column Info
	* @param  costCd
	*/
	public void	setCostCd( String	costCd ) {
		this.costCd =	costCd;
	}
 
	/**
	 * Column Info
	 * @return	costCd
	 */
	 public	 String	getCostCd() {
		 return	this.costCd;
	 } 
 	/**
	* Column Info
	* @param  mnrHngrBarTpCd
	*/
	public void	setMnrHngrBarTpCd( String	mnrHngrBarTpCd ) {
		this.mnrHngrBarTpCd =	mnrHngrBarTpCd;
	}
 
	/**
	 * Column Info
	 * @return	mnrHngrBarTpCd
	 */
	 public	 String	getMnrHngrBarTpCd() {
		 return	this.mnrHngrBarTpCd;
	 } 
 	/**
	* Column Info
	* @param  mnrLostHngrQty
	*/
	public void	setMnrLostHngrQty( String	mnrLostHngrQty ) {
		this.mnrLostHngrQty =	mnrLostHngrQty;
	}
 
	/**
	 * Column Info
	 * @return	mnrLostHngrQty
	 */
	 public	 String	getMnrLostHngrQty() {
		 return	this.mnrLostHngrQty;
	 } 
 	/**
	* Column Info
	* @param  rprOffhFlg
	*/
	public void	setRprOffhFlg( String	rprOffhFlg ) {
		this.rprOffhFlg =	rprOffhFlg;
	}
 
	/**
	 * Column Info
	 * @return	rprOffhFlg
	 */
	 public	 String	getRprOffhFlg() {
		 return	this.rprOffhFlg;
	 } 
 	/**
	* Column Info
	* @param  n3ptyBilTtlAmt
	*/
	public void	setN3ptyBilTtlAmt( String	n3ptyBilTtlAmt ) {
		this.n3ptyBilTtlAmt =	n3ptyBilTtlAmt;
	}
 
	/**
	 * Column Info
	 * @return	n3ptyBilTtlAmt
	 */
	 public	 String	getN3ptyBilTtlAmt() {
		 return	this.n3ptyBilTtlAmt;
	 } 
 	/**
	* Column Info
	* @param  mnrDispHngrQty
	*/
	public void	setMnrDispHngrQty( String	mnrDispHngrQty ) {
		this.mnrDispHngrQty =	mnrDispHngrQty;
	}
 
	/**
	 * Column Info
	 * @return	mnrDispHngrQty
	 */
	 public	 String	getMnrDispHngrQty() {
		 return	this.mnrDispHngrQty;
	 } 
 	/**
	* Column Info
	* @param  sprPrtUcAmt
	*/
	public void	setSprPrtUcAmt( String	sprPrtUcAmt ) {
		this.sprPrtUcAmt =	sprPrtUcAmt;
	}
 
	/**
	 * Column Info
	 * @return	sprPrtUcAmt
	 */
	 public	 String	getSprPrtUcAmt() {
		 return	this.sprPrtUcAmt;
	 } 
 	/**
	* Column Info
	* @param  rprRqstSeq
	*/
	public void	setRprRqstSeq( String	rprRqstSeq ) {
		this.rprRqstSeq =	rprRqstSeq;
	}
 
	/**
	 * Column Info
	 * @return	rprRqstSeq
	 */
	 public	 String	getRprRqstSeq() {
		 return	this.rprRqstSeq;
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
	 public	 String	getUpdUsrId() {
		 return	this.updUsrId;
	 } 
 	/**
	* Column Info
	* @param  ordDtlRmk
	*/
	public void	setOrdDtlRmk( String	ordDtlRmk ) {
		this.ordDtlRmk =	ordDtlRmk;
	}
 
	/**
	 * Column Info
	 * @return	ordDtlRmk
	 */
	 public	 String	getOrdDtlRmk() {
		 return	this.ordDtlRmk;
	 } 
 	/**
	* Column Info
	* @param  mnrOrgHngrBarTpCd
	*/
	public void	setMnrOrgHngrBarTpCd( String	mnrOrgHngrBarTpCd ) {
		this.mnrOrgHngrBarTpCd =	mnrOrgHngrBarTpCd;
	}
 
	/**
	 * Column Info
	 * @return	mnrOrgHngrBarTpCd
	 */
	 public	 String	getMnrOrgHngrBarTpCd() {
		 return	this.mnrOrgHngrBarTpCd;
	 } 
 	/**
	* Column Info
	* @param  mnrHngrFlgDt
	*/
	public void	setMnrHngrFlgDt( String	mnrHngrFlgDt ) {
		this.mnrHngrFlgDt =	mnrHngrFlgDt;
	}
 
	/**
	 * Column Info
	 * @return	mnrHngrFlgDt
	 */
	 public	 String	getMnrHngrFlgDt() {
		 return	this.mnrHngrFlgDt;
	 } 
 	/**
	* Column Info
	* @param  mnrExpnDtlNm
	*/
	public void	setMnrExpnDtlNm( String	mnrExpnDtlNm ) {
		this.mnrExpnDtlNm =	mnrExpnDtlNm;
	}
 
	/**
	 * Column Info
	 * @return	mnrExpnDtlNm
	 */
	 public	 String	getMnrExpnDtlNm() {
		 return	this.mnrExpnDtlNm;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd
	*/
	public void	setEqTpszCd( String	eqTpszCd ) {
		this.eqTpszCd =	eqTpszCd;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd
	 */
	 public	 String	getEqTpszCd() {
		 return	this.eqTpszCd;
	 } 
 	/**
	* Column Info
	* @param  slsTaxAmt
	*/
	public void	setSlsTaxAmt( String	slsTaxAmt ) {
		this.slsTaxAmt =	slsTaxAmt;
	}
 
	/**
	 * Column Info
	 * @return	slsTaxAmt
	 */
	 public	 String	getSlsTaxAmt() {
		 return	this.slsTaxAmt;
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
	 public	 String	getCreUsrId() {
		 return	this.creUsrId;
	 } 
 	/**
	* Column Info
	* @param  fileSeq
	*/
	public void	setFileSeq( String	fileSeq ) {
		this.fileSeq =	fileSeq;
	}
 
	/**
	 * Column Info
	 * @return	fileSeq
	 */
	 public	 String	getFileSeq() {
		 return	this.fileSeq;
	 } 
 	/**
	* Column Info
	* @param  sprPrtUtTpNm
	*/
	public void	setSprPrtUtTpNm( String	sprPrtUtTpNm ) {
		this.sprPrtUtTpNm =	sprPrtUtTpNm;
	}
 
	/**
	 * Column Info
	 * @return	sprPrtUtTpNm
	 */
	 public	 String	getSprPrtUtTpNm() {
		 return	this.sprPrtUtTpNm;
	 } 
 	/**
	* Column Info
	* @param  mnrHngrDmgQty
	*/
	public void	setMnrHngrDmgQty( String	mnrHngrDmgQty ) {
		this.mnrHngrDmgQty =	mnrHngrDmgQty;
	}
 
	/**
	 * Column Info
	 * @return	mnrHngrDmgQty
	 */
	 public	 String	getMnrHngrDmgQty() {
		 return	this.mnrHngrDmgQty;
	 } 
 	/**
	* Column Info
	* @param  rprRsltDt
	*/
	public void	setRprRsltDt( String	rprRsltDt ) {
		this.rprRsltDt =	rprRsltDt;
	}
 
	/**
	 * Column Info
	 * @return	rprRsltDt
	 */
	 public	 String	getRprRsltDt() {
		 return	this.rprRsltDt;
	 } 
 	/**
	* Column Info
	* @param  recentRprQty
	*/
	public void	setRecentRprQty( String	recentRprQty ) {
		this.recentRprQty =	recentRprQty;
	}
 
	/**
	 * Column Info
	 * @return	recentRprQty
	 */
	 public	 String	getRecentRprQty() {
		 return	this.recentRprQty;
	 } 
 	/**
	* Column Info
	* @param  mnrVrfyTpCd
	*/
	public void	setMnrVrfyTpCd( String	mnrVrfyTpCd ) {
		this.mnrVrfyTpCd =	mnrVrfyTpCd;
	}
 
	/**
	 * Column Info
	 * @return	mnrVrfyTpCd
	 */
	 public	 String	getMnrVrfyTpCd() {
		 return	this.mnrVrfyTpCd;
	 } 
 	/**
	* Column Info
	* @param  payInvSeq
	*/
	public void	setPayInvSeq( String	payInvSeq ) {
		this.payInvSeq =	payInvSeq;
	}
 
	/**
	 * Column Info
	 * @return	payInvSeq
	 */
	 public	 String	getPayInvSeq() {
		 return	this.payInvSeq;
	 } 
 	/**
	* Column Info
	* @param  rprRqstVerNo
	*/
	public void	setRprRqstVerNo( String	rprRqstVerNo ) {
		this.rprRqstVerNo =	rprRqstVerNo;
	}
 
	/**
	 * Column Info
	 * @return	rprRqstVerNo
	 */
	 public	 String	getRprRqstVerNo() {
		 return	this.rprRqstVerNo;
	 } 
 	/**
	* Column Info
	* @param  barIfChk
	*/
	public void	setBarIfChk( String	barIfChk ) {
		this.barIfChk =	barIfChk;
	}
 
	/**
	 * Column Info
	 * @return	barIfChk
	 */
	 public	 String	getBarIfChk() {
		 return	this.barIfChk;
	 } 
 	/**
	* Column Info
	* @param  rqstRefNo
	*/
	public void	setRqstRefNo( String	rqstRefNo ) {
		this.rqstRefNo =	rqstRefNo;
	}
 
	/**
	 * Column Info
	 * @return	rqstRefNo
	 */
	 public	 String	getRqstRefNo() {
		 return	this.rqstRefNo;
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
	 public	 String	getCreDt() {
		 return	this.creDt;
	 } 
 	/**
	* Column Info
	* @param  sprPrtNo
	*/
	public void	setSprPrtNo( String	sprPrtNo ) {
		this.sprPrtNo =	sprPrtNo;
	}
 
	/**
	 * Column Info
	 * @return	sprPrtNo
	 */
	 public	 String	getSprPrtNo() {
		 return	this.sprPrtNo;
	 } 
 	/**
	* Column Info
	* @param  mnrRtTpCd
	*/
	public void	setMnrRtTpCd( String	mnrRtTpCd ) {
		this.mnrRtTpCd =	mnrRtTpCd;
	}
 
	/**
	 * Column Info
	 * @return	mnrRtTpCd
	 */
	 public	 String	getMnrRtTpCd() {
		 return	this.mnrRtTpCd;
	 } 
 	/**
	* Column Info
	* @param  sprPrtNm
	*/
	public void	setSprPrtNm( String	sprPrtNm ) {
		this.sprPrtNm =	sprPrtNm;
	}
 
	/**
	 * Column Info
	 * @return	sprPrtNm
	 */
	 public	 String	getSprPrtNm() {
		 return	this.sprPrtNm;
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
	 public	 String	getIbflag() {
		 return	this.ibflag;
	 } 
 	/**
	* Column Info
	* @param  eqNo
	*/
	public void	setEqNo( String	eqNo ) {
		this.eqNo =	eqNo;
	}
 
	/**
	 * Column Info
	 * @return	eqNo
	 */
	 public	 String	getEqNo() {
		 return	this.eqNo;
	 } 
 	/**
	* Column Info
	* @param  costAmt
	*/
	public void	setCostAmt( String	costAmt ) {
		this.costAmt =	costAmt;
	}
 
	/**
	 * Column Info
	 * @return	costAmt
	 */
	 public	 String	getCostAmt() {
		 return	this.costAmt;
	 } 
 	/**
	* Column Info
	* @param  acctCd
	*/
	public void	setAcctCd( String	acctCd ) {
		this.acctCd =	acctCd;
	}
 
	/**
	 * Column Info
	 * @return	acctCd
	 */
	 public	 String	getAcctCd() {
		 return	this.acctCd;
	 } 
 	/**
	* Column Info
	* @param  rprQty
	*/
	public void	setRprQty( String	rprQty ) {
		this.rprQty =	rprQty;
	}
 
	/**
	 * Column Info
	 * @return	rprQty
	 */
	 public	 String	getRprQty() {
		 return	this.rprQty;
	 } 
 	/**
	* Column Info
	* @param  invAmt
	*/
	public void	setInvAmt( String	invAmt ) {
		this.invAmt =	invAmt;
	}
 
	/**
	 * Column Info
	 * @return	invAmt
	 */
	 public	 String	getInvAmt() {
		 return	this.invAmt;
	 } 
 	/**
	* Column Info
	* @param  mnrHngrDtlOffrDesc
	*/
	public void	setMnrHngrDtlOffrDesc( String	mnrHngrDtlOffrDesc ) {
		this.mnrHngrDtlOffrDesc =	mnrHngrDtlOffrDesc;
	}
 
	/**
	 * Column Info
	 * @return	mnrHngrDtlOffrDesc
	 */
	 public	 String	getMnrHngrDtlOffrDesc() {
		 return	this.mnrHngrDtlOffrDesc;
	 } 
 	/**
	* Column Info
	* @param  n3ptyFlg
	*/
	public void	setN3ptyFlg( String	n3ptyFlg ) {
		this.n3ptyFlg =	n3ptyFlg;
	}
 
	/**
	 * Column Info
	 * @return	n3ptyFlg
	 */
	 public	 String	getN3ptyFlg() {
		 return	this.n3ptyFlg;
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
	 public	 String	getUpdDt() {
		 return	this.updDt;
	 } 
 	/**
	* Column Info
	* @param  mnrHngrFlgYdCd
	*/
	public void	setMnrHngrFlgYdCd( String	mnrHngrFlgYdCd ) {
		this.mnrHngrFlgYdCd =	mnrHngrFlgYdCd;
	}
 
	/**
	 * Column Info
	 * @return	mnrHngrFlgYdCd
	 */
	 public	 String	getMnrHngrFlgYdCd() {
		 return	this.mnrHngrFlgYdCd;
	 } 
 	/**
	* Column Info
	* @param  ordDtlSeq
	*/
	public void	setOrdDtlSeq( String	ordDtlSeq ) {
		this.ordDtlSeq =	ordDtlSeq;
	}
 
	/**
	 * Column Info
	 * @return	ordDtlSeq
	 */
	 public	 String	getOrdDtlSeq() {
		 return	this.ordDtlSeq;
	 } 
 	/**
	* Column Info
	* @param  costDtlCd
	*/
	public void	setCostDtlCd( String	costDtlCd ) {
		this.costDtlCd =	costDtlCd;
	}
 
	/**
	 * Column Info
	 * @return	costDtlCd
	 */
	 public	 String	getCostDtlCd() {
		 return	this.costDtlCd;
	 } 
 	/**
	* Column Info
	* @param  eqKndCd
	*/
	public void	setEqKndCd( String	eqKndCd ) {
		this.eqKndCd =	eqKndCd;
	}
 
	/**
	 * Column Info
	 * @return	eqKndCd
	 */
	 public	 String	getEqKndCd() {
		 return	this.eqKndCd;
	 } 
 	/**
	* Column Info
	* @param  bzcAmt
	*/
	public void	setBzcAmt( String	bzcAmt ) {
		this.bzcAmt =	bzcAmt;
	}
 
	/**
	 * Column Info
	 * @return	bzcAmt
	 */
	 public	 String	getBzcAmt() {
		 return	this.bzcAmt;
	 } 
 	/**
	* Column Info
	* @param  actInvtQty
	*/
	public void	setActInvtQty( String	actInvtQty ) {
		this.actInvtQty =	actInvtQty;
	}
 
	/**
	 * Column Info
	 * @return	actInvtQty
	 */
	 public	 String	getActInvtQty() {
		 return	this.actInvtQty;
	 } 
 	/**
	* Column Info
	* @param  invNo
	*/
	public void	setInvNo( String	invNo ) {
		this.invNo =	invNo;
	}
 
	/**
	 * Column Info
	 * @return	invNo
	 */
	 public	 String	getInvNo() {
		 return	this.invNo;
	 } 
 	/**
	* Column Info
	* @param  mnrOrdSeq
	*/
	public void	setMnrOrdSeq( String	mnrOrdSeq ) {
		this.mnrOrdSeq =	mnrOrdSeq;
	}
 
	/**
	 * Column Info
	 * @return	mnrOrdSeq
	 */
	 public	 String	getMnrOrdSeq() {
		 return	this.mnrOrdSeq;
	 } 
 	/**
	* Column Info
	* @param  ydCd
	*/
	public void	setYdCd( String	ydCd ) {
		this.ydCd =	ydCd;
	}
 
	/**
	 * Column Info
	 * @return	ydCd
	 */
	 public	 String	getYdCd() {
		 return	this.ydCd;
	 } 
 	/**
	* Column Info
	* @param  mnrHngrRckCd
	*/
	public void	setMnrHngrRckCd( String	mnrHngrRckCd ) {
		this.mnrHngrRckCd =	mnrHngrRckCd;
	}
 
	/**
	 * Column Info
	 * @return	mnrHngrRckCd
	 */
	 public	 String	getMnrHngrRckCd() {
		 return	this.mnrHngrRckCd;
	 } 
 	/**
	* Column Info
	* @param  mnrHngrTrfCd
	*/
	public void	setMnrHngrTrfCd( String	mnrHngrTrfCd ) {
		this.mnrHngrTrfCd =	mnrHngrTrfCd;
	}
 
	/**
	 * Column Info
	 * @return	mnrHngrTrfCd
	 */
	 public	 String	getMnrHngrTrfCd() {
		 return	this.mnrHngrTrfCd;
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
	 public	 String	getBkgNo() {
		 return	this.bkgNo;
	 } 
 	/**
	* Column Info
	* @param  trdCd
	*/
	public void	setTrdCd( String	trdCd ) {
		this.trdCd =	trdCd;
	}
 
	/**
	 * Column Info
	 * @return	trdCd
	 */
	 public	 String	getTrdCd() {
		 return	this.trdCd;
	 }  
 	/**
	* Column Info
	* @param  mnrRcvOrdInvTmpSeq
	*/
	public void	setMnrRcvOrdInvTmpSeq( String	mnrRcvOrdInvTmpSeq ) {
		this.mnrRcvOrdInvTmpSeq =	mnrRcvOrdInvTmpSeq;
	}
 
	/**
	 * Column Info
	 * @return	mnrRcvOrdInvTmpSeq
	 */
	 public	 String	getMnrRcvOrdInvTmpSeq() {
		 return	this.mnrRcvOrdInvTmpSeq;
	 } 
 	/**
	* Column Info
	* @param  mnrRcvOrdInvTmpDtlSeq
	*/
	public void	setMnrRcvOrdInvTmpDtlSeq( String	mnrRcvOrdInvTmpDtlSeq ) {
		this.mnrRcvOrdInvTmpDtlSeq =	mnrRcvOrdInvTmpDtlSeq;
	}
 
	/**
	 * Column Info
	 * @return	mnrRcvOrdInvTmpDtlSeq
	 */
	 public	 String	getMnrRcvOrdInvTmpDtlSeq() {
		 return	this.mnrRcvOrdInvTmpDtlSeq;
	 } 
 	/**
	* Column Info
	* @param  eqStsCd
	*/
	public void	setEqStsCd( String	eqStsCd ) {
		this.eqStsCd =	eqStsCd;
	}
 
	/**
	 * Column Info
	 * @return	eqStsCd
	 */
	 public	 String	getEqStsCd() {
		 return	this.eqStsCd;
	 } 
 	/**
	* Column Info
	* @param  vndrSeq
	*/
	public void	setVndrSeq( String	vndrSeq ) {
		this.vndrSeq =	vndrSeq;
	}
 
	/**
	 * Column Info
	 * @return	vndrSeq
	 */
	 public	 String	getVndrSeq() {
		 return	this.vndrSeq;
	 } 
 	/**
	* Column Info
	* @param  currCd
	*/
	public void	setCurrCd( String	currCd ) {
		this.currCd =	currCd;
	}
 
	/**
	 * Column Info
	 * @return	currCd
	 */
	 public	 String	getCurrCd() {
		 return	this.currCd;
	 } 
 	/**
	* Column Info
	* @param  vrfyRsltDesc
	*/
	public void	setVrfyRsltDesc( String	vrfyRsltDesc ) {
		this.vrfyRsltDesc =	vrfyRsltDesc;
	}
 
	/**
	 * Column Info
	 * @return	vrfyRsltDesc
	 */
	 public	 String	getVrfyRsltDesc() {
		 return	this.vrfyRsltDesc;
	 } 
 
	public String getVslCd() {
		return vslCd;
	}

	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	public String getSkdVoyNo() {
		return skdVoyNo;
	}

	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}

	public String getPortCd() {
		return portCd;
	}

	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}

	public String getSlanCd() {
		return slanCd;
	}

	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}

	/**
	 * Column Info
	 * @param vrfyRsltDesc
	 */
	public void setJbOrdrSeq(String jbOrdrSeq) {
		this.jbOrdrSeq = jbOrdrSeq;
	}

	/**
	 * Column Info
	 * @return jbOrdrSeq
	 */
	public String getJbOrdrSeq() {
		return this.jbOrdrSeq;
	}
 
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCostCdAll() {
		return costCdAll;
	}

	public void setCostCdAll(String costCdAll) {
		this.costCdAll = costCdAll;
	}
	
	public String getQtyFlg() {
		return qtyFlg;
	}

	public void setQtyFlg(String qtyFlg) {
		this.qtyFlg = qtyFlg;
	}

	public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	public String getSkdDirCd() {
		return skdDirCd;
	}

	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
		setMnrHngrTrfOtrDesc(JSPUtil.getParameter(request,	prefix + "mnr_hngr_trf_otr_desc", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setMnrOrdOfcCtyCd(JSPUtil.getParameter(request,	prefix + "mnr_ord_ofc_cty_cd", ""));
		setCostCd(JSPUtil.getParameter(request,	prefix + "cost_cd", ""));
		setMnrHngrBarTpCd(JSPUtil.getParameter(request,	prefix + "mnr_hngr_bar_tp_cd", ""));
		setMnrLostHngrQty(JSPUtil.getParameter(request,	prefix + "mnr_lost_hngr_qty", ""));
		setRprOffhFlg(JSPUtil.getParameter(request,	prefix + "rpr_offh_flg", ""));
		setN3ptyBilTtlAmt(JSPUtil.getParameter(request,	prefix + "n3pty_bil_ttl_amt", ""));
		setMnrDispHngrQty(JSPUtil.getParameter(request,	prefix + "mnr_disp_hngr_qty", ""));
		setSprPrtUcAmt(JSPUtil.getParameter(request,	prefix + "spr_prt_uc_amt", ""));
		setRprRqstSeq(JSPUtil.getParameter(request,	prefix + "rpr_rqst_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setOrdDtlRmk(JSPUtil.getParameter(request,	prefix + "ord_dtl_rmk", ""));
		setMnrOrgHngrBarTpCd(JSPUtil.getParameter(request,	prefix + "mnr_org_hngr_bar_tp_cd", ""));
		setMnrHngrFlgDt(JSPUtil.getParameter(request,	prefix + "mnr_hngr_flg_dt", ""));
		setMnrExpnDtlNm(JSPUtil.getParameter(request,	prefix + "mnr_expn_dtl_nm", ""));
		setEqTpszCd(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd", ""));
		setSlsTaxAmt(JSPUtil.getParameter(request,	prefix + "sls_tax_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setFileSeq(JSPUtil.getParameter(request,	prefix + "file_seq", ""));
		setSprPrtUtTpNm(JSPUtil.getParameter(request,	prefix + "spr_prt_ut_tp_nm", ""));
		setMnrHngrDmgQty(JSPUtil.getParameter(request,	prefix + "mnr_hngr_dmg_qty", ""));
		setRprRsltDt(JSPUtil.getParameter(request,	prefix + "rpr_rslt_dt", ""));
		setRecentRprQty(JSPUtil.getParameter(request,	prefix + "recent_rpr_qty", ""));
		setMnrVrfyTpCd(JSPUtil.getParameter(request,	prefix + "mnr_vrfy_tp_cd", ""));
		setPayInvSeq(JSPUtil.getParameter(request,	prefix + "pay_inv_seq", ""));
		setRprRqstVerNo(JSPUtil.getParameter(request,	prefix + "rpr_rqst_ver_no", ""));
		setBarIfChk(JSPUtil.getParameter(request,	prefix + "bar_if_chk", ""));
		setRqstRefNo(JSPUtil.getParameter(request,	prefix + "rqst_ref_no", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setSprPrtNo(JSPUtil.getParameter(request,	prefix + "spr_prt_no", ""));
		setMnrRtTpCd(JSPUtil.getParameter(request,	prefix + "mnr_rt_tp_cd", ""));
		setSprPrtNm(JSPUtil.getParameter(request,	prefix + "spr_prt_nm", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request,	prefix + "eq_no", ""));
		setCostAmt(JSPUtil.getParameter(request,	prefix + "cost_amt", ""));
		setAcctCd(JSPUtil.getParameter(request,	prefix + "acct_cd", ""));
		setRprQty(JSPUtil.getParameter(request,	prefix + "rpr_qty", ""));
		setInvAmt(JSPUtil.getParameter(request,	prefix + "inv_amt", ""));
		setMnrHngrDtlOffrDesc(JSPUtil.getParameter(request,	prefix + "mnr_hngr_dtl_offr_desc", ""));
		setN3ptyFlg(JSPUtil.getParameter(request,	prefix + "n3pty_flg", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setMnrHngrFlgYdCd(JSPUtil.getParameter(request,	prefix + "mnr_hngr_flg_yd_cd", ""));
		setOrdDtlSeq(JSPUtil.getParameter(request,	prefix + "ord_dtl_seq", ""));
		setCostDtlCd(JSPUtil.getParameter(request,	prefix + "cost_dtl_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request,	prefix + "eq_knd_cd", ""));
		setBzcAmt(JSPUtil.getParameter(request,	prefix + "bzc_amt", ""));
		setActInvtQty(JSPUtil.getParameter(request,	prefix + "act_invt_qty", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setMnrOrdSeq(JSPUtil.getParameter(request,	prefix + "mnr_ord_seq", ""));
		setYdCd(JSPUtil.getParameter(request,	prefix + "yd_cd", ""));
		setMnrHngrRckCd(JSPUtil.getParameter(request,	prefix + "mnr_hngr_rck_cd", ""));
		setMnrHngrTrfCd(JSPUtil.getParameter(request,	prefix + "mnr_hngr_trf_cd", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setTrdCd(JSPUtil.getParameter(request,	prefix + "trd_cd", ""));
		setMnrRcvOrdInvTmpSeq(JSPUtil.getParameter(request,	prefix + "mnr_rcv_ord_inv_tmp_seq", ""));
		setMnrRcvOrdInvTmpDtlSeq(JSPUtil.getParameter(request,	prefix + "mnr_rcv_ord_inv_tmp_dtl_seq", ""));
		setEqStsCd(JSPUtil.getParameter(request,	prefix + "eq_sts_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setVrfyRsltDesc(JSPUtil.getParameter(request,	prefix + "vrfy_rslt_desc", ""));
		setJbOrdrSeq(JSPUtil.getParameter(request,	prefix + "jb_ordr_seq", ""));
		setVslCd(JSPUtil.getParameter(request,	prefix + "vsl_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request,	prefix + "skd_voy_no", ""));
		setPortCd(JSPUtil.getParameter(request,	prefix + "port_cd", ""));
		setSlanCd(JSPUtil.getParameter(request,	prefix + "slan_cd", ""));
		setCostCdAll(JSPUtil.getParameter(request,	prefix + "cost_cd_all", ""));
		setVvd(JSPUtil.getParameter(request,	prefix + "vvd", ""));
		setSkdDirCd(JSPUtil.getParameter(request,	prefix + "skd_dir_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrOrdTmpDtlVO[]
	 */
	public CustomMnrOrdTmpDtlVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CustomMnrOrdTmpDtlVO[]
	 */
	public CustomMnrOrdTmpDtlVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		CustomMnrOrdTmpDtlVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] mnrHngrTrfOtrDesc =	(JSPUtil.getParameter(request, prefix +	"mnr_hngr_trf_otr_desc".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] mnrOrdOfcCtyCd =	(JSPUtil.getParameter(request, prefix +	"mnr_ord_ofc_cty_cd".trim(),	length));
				String[] costCd =	(JSPUtil.getParameter(request, prefix +	"cost_cd".trim(),	length));
				String[] mnrHngrBarTpCd =	(JSPUtil.getParameter(request, prefix +	"mnr_hngr_bar_tp_cd".trim(),	length));
				String[] mnrLostHngrQty =	(JSPUtil.getParameter(request, prefix +	"mnr_lost_hngr_qty".trim(),	length));
				String[] rprOffhFlg =	(JSPUtil.getParameter(request, prefix +	"rpr_offh_flg".trim(),	length));
				String[] n3ptyBilTtlAmt =	(JSPUtil.getParameter(request, prefix +	"n3pty_bil_ttl_amt".trim(),	length));
				String[] mnrDispHngrQty =	(JSPUtil.getParameter(request, prefix +	"mnr_disp_hngr_qty".trim(),	length));
				String[] sprPrtUcAmt =	(JSPUtil.getParameter(request, prefix +	"spr_prt_uc_amt".trim(),	length));
				String[] rprRqstSeq =	(JSPUtil.getParameter(request, prefix +	"rpr_rqst_seq".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] ordDtlRmk =	(JSPUtil.getParameter(request, prefix +	"ord_dtl_rmk".trim(),	length));
				String[] mnrOrgHngrBarTpCd =	(JSPUtil.getParameter(request, prefix +	"mnr_org_hngr_bar_tp_cd".trim(),	length));
				String[] mnrHngrFlgDt =	(JSPUtil.getParameter(request, prefix +	"mnr_hngr_flg_dt".trim(),	length));
				String[] mnrExpnDtlNm =	(JSPUtil.getParameter(request, prefix +	"mnr_expn_dtl_nm".trim(),	length));
				String[] eqTpszCd =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd".trim(),	length));
				String[] slsTaxAmt =	(JSPUtil.getParameter(request, prefix +	"sls_tax_amt".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] fileSeq =	(JSPUtil.getParameter(request, prefix +	"file_seq".trim(),	length));
				String[] sprPrtUtTpNm =	(JSPUtil.getParameter(request, prefix +	"spr_prt_ut_tp_nm".trim(),	length));
				String[] mnrHngrDmgQty =	(JSPUtil.getParameter(request, prefix +	"mnr_hngr_dmg_qty".trim(),	length));
				String[] rprRsltDt =	(JSPUtil.getParameter(request, prefix +	"rpr_rslt_dt".trim(),	length));
				String[] recentRprQty =	(JSPUtil.getParameter(request, prefix +	"recent_rpr_qty".trim(),	length));
				String[] mnrVrfyTpCd =	(JSPUtil.getParameter(request, prefix +	"mnr_vrfy_tp_cd".trim(),	length));
				String[] payInvSeq =	(JSPUtil.getParameter(request, prefix +	"pay_inv_seq".trim(),	length));
				String[] rprRqstVerNo =	(JSPUtil.getParameter(request, prefix +	"rpr_rqst_ver_no".trim(),	length));
				String[] barIfChk =	(JSPUtil.getParameter(request, prefix +	"bar_if_chk".trim(),	length));
				String[] rqstRefNo =	(JSPUtil.getParameter(request, prefix +	"rqst_ref_no".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] sprPrtNo =	(JSPUtil.getParameter(request, prefix +	"spr_prt_no".trim(),	length));
				String[] mnrRtTpCd =	(JSPUtil.getParameter(request, prefix +	"mnr_rt_tp_cd".trim(),	length));
				String[] sprPrtNm =	(JSPUtil.getParameter(request, prefix +	"spr_prt_nm".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] eqNo =	(JSPUtil.getParameter(request, prefix +	"eq_no".trim(),	length));
				String[] costAmt =	(JSPUtil.getParameter(request, prefix +	"cost_amt".trim(),	length));
				String[] acctCd =	(JSPUtil.getParameter(request, prefix +	"acct_cd".trim(),	length));
				String[] rprQty =	(JSPUtil.getParameter(request, prefix +	"rpr_qty".trim(),	length));
				String[] invAmt =	(JSPUtil.getParameter(request, prefix +	"inv_amt".trim(),	length));
				String[] mnrHngrDtlOffrDesc =	(JSPUtil.getParameter(request, prefix +	"mnr_hngr_dtl_offr_desc".trim(),	length));
				String[] n3ptyFlg =	(JSPUtil.getParameter(request, prefix +	"n3pty_flg".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] mnrHngrFlgYdCd =	(JSPUtil.getParameter(request, prefix +	"mnr_hngr_flg_yd_cd".trim(),	length));
				String[] ordDtlSeq =	(JSPUtil.getParameter(request, prefix +	"ord_dtl_seq".trim(),	length));
				String[] costDtlCd =	(JSPUtil.getParameter(request, prefix +	"cost_dtl_cd".trim(),	length));
				String[] eqKndCd =	(JSPUtil.getParameter(request, prefix +	"eq_knd_cd".trim(),	length));
				String[] bzcAmt =	(JSPUtil.getParameter(request, prefix +	"bzc_amt".trim(),	length));
				String[] actInvtQty =	(JSPUtil.getParameter(request, prefix +	"act_invt_qty".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] mnrOrdSeq =	(JSPUtil.getParameter(request, prefix +	"mnr_ord_seq".trim(),	length));
				String[] ydCd =	(JSPUtil.getParameter(request, prefix +	"yd_cd".trim(),	length));
				String[] mnrHngrRckCd =	(JSPUtil.getParameter(request, prefix +	"mnr_hngr_rck_cd".trim(),	length));
				String[] mnrHngrTrfCd =	(JSPUtil.getParameter(request, prefix +	"mnr_hngr_trf_cd".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] trdCd =	(JSPUtil.getParameter(request, prefix +	"trd_cd".trim(),	length));
				String[] mnrRcvOrdInvTmpSeq =	(JSPUtil.getParameter(request, prefix +	"mnr_rcv_ord_inv_tmp_seq".trim(),	length));
				String[] mnrRcvOrdInvTmpDtlSeq =	(JSPUtil.getParameter(request, prefix +	"mnr_rcv_ord_inv_tmp_dtl_seq".trim(),	length));
				String[] eqStsCd =	(JSPUtil.getParameter(request, prefix +	"eq_sts_cd".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] vrfyRsltDesc =	(JSPUtil.getParameter(request, prefix +	"vrfy_rslt_desc".trim(),	length));
				String[] jbOrdrSeq =	(JSPUtil.getParameter(request, prefix +	"jb_ordr_seq".trim(),	length));
				String[] vslCd =	(JSPUtil.getParameter(request, prefix +	"vsl_cd".trim(),	length));
				String[] skdVoyNo =	(JSPUtil.getParameter(request, prefix +	"skd_voy_no".trim(),	length));
				String[] portCd =	(JSPUtil.getParameter(request, prefix +	"port_cd".trim(),	length));
				String[] slanCd =	(JSPUtil.getParameter(request, prefix +	"slan_cd".trim(),	length));
				String[] costCdAll =	(JSPUtil.getParameter(request, prefix +	"cost_cd_all".trim(),	length));
				String[] vvd =	(JSPUtil.getParameter(request, prefix +	"vvd".trim(),	length));
				String[] skdDirCd =	(JSPUtil.getParameter(request, prefix +	"skd_dir_cd".trim(),	length));
				
				for	(int i = 0;	i <	length;	i++) {
					model =	new	CustomMnrOrdTmpDtlVO();
						if ( mnrHngrTrfOtrDesc[i] !=	null)
						model.setMnrHngrTrfOtrDesc( mnrHngrTrfOtrDesc[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( mnrOrdOfcCtyCd[i] !=	null)
						model.setMnrOrdOfcCtyCd( mnrOrdOfcCtyCd[i]);
						if ( costCd[i] !=	null)
						model.setCostCd( costCd[i]);
						if ( mnrHngrBarTpCd[i] !=	null)
						model.setMnrHngrBarTpCd( mnrHngrBarTpCd[i]);
						if ( mnrLostHngrQty[i] !=	null)
						model.setMnrLostHngrQty( mnrLostHngrQty[i]);
						if ( rprOffhFlg[i] !=	null)
						model.setRprOffhFlg( rprOffhFlg[i]);
						if ( n3ptyBilTtlAmt[i] !=	null)
						model.setN3ptyBilTtlAmt( n3ptyBilTtlAmt[i]);
						if ( mnrDispHngrQty[i] !=	null)
						model.setMnrDispHngrQty( mnrDispHngrQty[i]);
						if ( sprPrtUcAmt[i] !=	null)
						model.setSprPrtUcAmt( sprPrtUcAmt[i]);
						if ( rprRqstSeq[i] !=	null)
						model.setRprRqstSeq( rprRqstSeq[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( ordDtlRmk[i] !=	null)
						model.setOrdDtlRmk( ordDtlRmk[i]);
						if ( mnrOrgHngrBarTpCd[i] !=	null)
						model.setMnrOrgHngrBarTpCd( mnrOrgHngrBarTpCd[i]);
						if ( mnrHngrFlgDt[i] !=	null)
						model.setMnrHngrFlgDt( mnrHngrFlgDt[i]);
						if ( mnrExpnDtlNm[i] !=	null)
						model.setMnrExpnDtlNm( mnrExpnDtlNm[i]);
						if ( eqTpszCd[i] !=	null)
						model.setEqTpszCd( eqTpszCd[i]);
						if ( slsTaxAmt[i] !=	null)
						model.setSlsTaxAmt( slsTaxAmt[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( fileSeq[i] !=	null)
						model.setFileSeq( fileSeq[i]);
						if ( sprPrtUtTpNm[i] !=	null)
						model.setSprPrtUtTpNm( sprPrtUtTpNm[i]);
						if ( mnrHngrDmgQty[i] !=	null)
						model.setMnrHngrDmgQty( mnrHngrDmgQty[i]);
						if ( rprRsltDt[i] !=	null)
						model.setRprRsltDt( rprRsltDt[i]);
						if ( recentRprQty[i] !=	null)
						model.setRecentRprQty( recentRprQty[i]);
						if ( mnrVrfyTpCd[i] !=	null)
						model.setMnrVrfyTpCd( mnrVrfyTpCd[i]);
						if ( payInvSeq[i] !=	null)
						model.setPayInvSeq( payInvSeq[i]);
						if ( rprRqstVerNo[i] !=	null)
						model.setRprRqstVerNo( rprRqstVerNo[i]);
						if ( barIfChk[i] !=	null)
						model.setBarIfChk( barIfChk[i]);
						if ( rqstRefNo[i] !=	null)
						model.setRqstRefNo( rqstRefNo[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( sprPrtNo[i] !=	null)
						model.setSprPrtNo( sprPrtNo[i]);
						if ( mnrRtTpCd[i] !=	null)
						model.setMnrRtTpCd( mnrRtTpCd[i]);
						if ( sprPrtNm[i] !=	null)
						model.setSprPrtNm( sprPrtNm[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( eqNo[i] !=	null)
						model.setEqNo( eqNo[i]);
						if ( costAmt[i] !=	null)
						model.setCostAmt( costAmt[i]);
						if ( acctCd[i] !=	null)
						model.setAcctCd( acctCd[i]);
						if ( rprQty[i] !=	null)
						model.setRprQty( rprQty[i]);
						if ( invAmt[i] !=	null)
						model.setInvAmt( invAmt[i]);
						if ( mnrHngrDtlOffrDesc[i] !=	null)
						model.setMnrHngrDtlOffrDesc( mnrHngrDtlOffrDesc[i]);
						if ( n3ptyFlg[i] !=	null)
						model.setN3ptyFlg( n3ptyFlg[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( mnrHngrFlgYdCd[i] !=	null)
						model.setMnrHngrFlgYdCd( mnrHngrFlgYdCd[i]);
						if ( ordDtlSeq[i] !=	null)
						model.setOrdDtlSeq( ordDtlSeq[i]);
						if ( costDtlCd[i] !=	null)
						model.setCostDtlCd( costDtlCd[i]);
						if ( eqKndCd[i] !=	null)
						model.setEqKndCd( eqKndCd[i]);
						if ( bzcAmt[i] !=	null)
						model.setBzcAmt( bzcAmt[i]);
						if ( actInvtQty[i] !=	null)
						model.setActInvtQty( actInvtQty[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( mnrOrdSeq[i] !=	null)
						model.setMnrOrdSeq( mnrOrdSeq[i]);
						if ( ydCd[i] !=	null)
						model.setYdCd( ydCd[i]);
						if ( mnrHngrRckCd[i] !=	null)
						model.setMnrHngrRckCd( mnrHngrRckCd[i]);
						if ( mnrHngrTrfCd[i] !=	null)
						model.setMnrHngrTrfCd( mnrHngrTrfCd[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( trdCd[i] !=	null)
						model.setTrdCd( trdCd[i]);
						if ( mnrRcvOrdInvTmpSeq[i] !=	null)
						model.setMnrRcvOrdInvTmpSeq( mnrRcvOrdInvTmpSeq[i]);
						if ( mnrRcvOrdInvTmpDtlSeq[i] !=	null)
						model.setMnrRcvOrdInvTmpDtlSeq( mnrRcvOrdInvTmpDtlSeq[i]);
						if ( eqStsCd[i] !=	null)
						model.setEqStsCd( eqStsCd[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( vrfyRsltDesc[i] !=	null)
						model.setVrfyRsltDesc( vrfyRsltDesc[i]);
						if ( jbOrdrSeq[i] !=	null)
							model.setJbOrdrSeq( jbOrdrSeq[i]);
						if ( vslCd[i] !=	null)
							model.setVslCd( vslCd[i]);
						if ( skdVoyNo[i] !=	null)
							model.setSkdVoyNo( skdVoyNo[i]);
						if ( portCd[i] !=	null)
							model.setPortCd( portCd[i]);
						if ( slanCd[i] !=	null)
							model.setSlanCd( slanCd[i]);
						if ( costCdAll[i] !=	null)
							model.setCostCdAll( costCdAll[i]);
						if ( vvd[i] !=	null)
							model.setVvd( vvd[i]);
						if ( skdDirCd[i] !=	null)
							model.setSkdDirCd( skdDirCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getCustomMnrOrdTmpDtlVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return CustomMnrOrdTmpDtlVO[]
	 */
	public CustomMnrOrdTmpDtlVO[]	 getCustomMnrOrdTmpDtlVOs(){
		CustomMnrOrdTmpDtlVO[] vos = (CustomMnrOrdTmpDtlVO[])models.toArray(new	CustomMnrOrdTmpDtlVO[models.size()]);
		return vos;
		}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String  toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}
	

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void	unDataFormat(){
		this.mnrHngrTrfOtrDesc =	this.mnrHngrTrfOtrDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdOfcCtyCd =	this.mnrOrdOfcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd =	this.costCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrBarTpCd =	this.mnrHngrBarTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrLostHngrQty =	this.mnrLostHngrQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprOffhFlg =	this.rprOffhFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTtlAmt =	this.n3ptyBilTtlAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispHngrQty =	this.mnrDispHngrQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtUcAmt =	this.sprPrtUcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstSeq =	this.rprRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ordDtlRmk =	this.ordDtlRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrgHngrBarTpCd =	this.mnrOrgHngrBarTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrFlgDt =	this.mnrHngrFlgDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrExpnDtlNm =	this.mnrExpnDtlNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd =	this.eqTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsTaxAmt =	this.slsTaxAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq =	this.fileSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtUtTpNm =	this.sprPrtUtTpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrDmgQty =	this.mnrHngrDmgQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRsltDt =	this.rprRsltDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recentRprQty =	this.recentRprQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrVrfyTpCd =	this.mnrVrfyTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payInvSeq =	this.payInvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstVerNo =	this.rprRqstVerNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.barIfChk =	this.barIfChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstRefNo =	this.rqstRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtNo =	this.sprPrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrRtTpCd =	this.mnrRtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtNm =	this.sprPrtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo =	this.eqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costAmt =	this.costAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd =	this.acctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprQty =	this.rprQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt =	this.invAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrDtlOffrDesc =	this.mnrHngrDtlOffrDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyFlg =	this.n3ptyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrFlgYdCd =	this.mnrHngrFlgYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ordDtlSeq =	this.ordDtlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costDtlCd =	this.costDtlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd =	this.eqKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcAmt =	this.bzcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actInvtQty =	this.actInvtQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdSeq =	this.mnrOrdSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd =	this.ydCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrRckCd =	this.mnrHngrRckCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrTrfCd =	this.mnrHngrTrfCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd =	this.trdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrRcvOrdInvTmpSeq =	this.mnrRcvOrdInvTmpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrRcvOrdInvTmpDtlSeq =	this.mnrRcvOrdInvTmpDtlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqStsCd =	this.eqStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vrfyRsltDesc =	this.vrfyRsltDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jbOrdrSeq =	this.jbOrdrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd =	this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo =	this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd =	this.portCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd =	this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCdAll =	this.costCdAll.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd =	this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd =	this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}
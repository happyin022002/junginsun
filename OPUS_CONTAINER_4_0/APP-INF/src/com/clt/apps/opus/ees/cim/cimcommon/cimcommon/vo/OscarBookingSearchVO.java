/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : OscarBookingSearchVO.java
 *@FileTitle : OscarBookingSearchVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.10.07
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.10.07  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.cim.cimcommon.cimcommon.vo;

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
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author  
 * @since J2EE 1.6
 * @see	..
 */
public class OscarBookingSearchVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<OscarBookingSearchVO>  models =	new	ArrayList<OscarBookingSearchVO>();

 
	/*	Column Info	*/
	private  String	 podCd   =  null;
	/*	Column Info	*/
	private  String	 porCd   =  null;
	/*	Column Info	*/
	private  String	 bkgCgoTpCd   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 polCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 cnmvCycNo   =  null;
	/*	Column Info	*/
	private  String	 delCd   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 sCntrNo   =  null;
	/*	Column Info	*/
	private  String	 sBkgNo   =  null;
	/*	Column Info	*/
	private  String	 hBkgNo   =  null;
	/*	Column Info	*/
	private  String	 hCntrNo   =  null;
	/*	Column Info	*/
	private  String	 vslOscaUpdDt   =  null;
	/*	Column Info	*/
	private  String	 vslVvd   =  null;
	/*	Column Info	*/
	private  String	 vslEtb   =  null;
	/*	Column Info	*/
	private  String	 vslOscaCreDt   =  null;
	/*	Column Info	*/
	private  String	 vslEtd   =  null;
	/*	Column Info	*/
	private  String	 vslPodYdCd   =  null;
	/*	Column Info	*/
	private  String	 vslPrePstCd   =  null;
	/*	Column Info	*/
	private  String	 vslSlanCd   =  null;
	/*	Column Info	*/
	private  String	 vslPolYdCd   =  null;
	/*	Column Info	*/
	private  String	 cntrAgmtSeq   =  null;
	/*	Column Info	*/
	private  String	 cntrDeTermCd   =  null;
	/*	Column Info	*/
	private  String	 cntrCnmvStsCd   =  null;
	/*	Column Info	*/
	private  String	 cntrStsCd   =  null;
	/*	Column Info	*/
	private  String	 cntrRowSeq   =  null;
	/*	Column Info	*/
	private  String	 cntrMinOnhDys   =  null;
	/*	Column Info	*/
	private  String	 cntrRdCgoFlg   =  null;
	/*	Column Info	*/
	private  String	 cntrRcvTermCd   =  null;
	/*	Column Info	*/
	private  String	 cntrAgmtCtyCd   =  null;
	/*	Column Info	*/
	private  String	 cntrAwkCgoFlg   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 cntrCrntYdCd   =  null;
	/*	Column Info	*/
	private  String	 cntrDcgoFlg   =  null;
	/*	Column Info	*/
	private  String	 cntrOnhYdCd   =  null;
	/*	Column Info	*/
	private  String	 cntrRefNo   =  null;
	/*	Column Info	*/
	private  String	 cntrCfmFlg   =  null;
	/*	Column Info	*/
	private  String	 cntrOnhDt   =  null;
	/*	Column Info	*/
	private  String	 cntrVndrAbbrNm   =  null;
	/*	Column Info	*/
	private  String	 cntrUsedDys   =  null;
	/*	Column Info	*/
	private  String	 cntrCnmvDt   =  null;
	/*	Column Info	*/
	private  String	 cntrRcFlg   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 cntrVolQty   =  null;
	/*	Column Info	*/
	private  String	 cntrCnmvCycNo   =  null;
	/*	Column Info	*/
	private  String	 cntrOnhFreeDys   =  null;
	/*	Column Info	*/
	private  String	 cntrVndrSeq   =  null;
	/*	Column Info	*/
	private  String	 cntrLstmCd   =  null;
	/*	Column Info	*/
	private  String	 cntrBbCgoFlg   =  null;
	/*	Column Info	*/
	private  String	 pCntrno   =  null;
	/*	Column Info	*/
	private  String	 checkDigit   =  null;
	/*	Column Info	*/
	private  String	 pDate1   =  null;
	/*	Column Info	*/
	private  String	 pDate2   =  null;
	/*	Column Info	*/
	private  String	 appCd   =  null;
	/*	Column Info	*/
	private  String	 slanCd   =  null;
	/*	Column Info	*/
	private  String	 bkgStsCd   =  null;
	/*	Column Info	*/
	private  String	 rcvTermCd   =  null;
	/*	Column Info	*/
	private  String	 deTermCd   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 oscaBkgFlg   =  null;
	/*	Column Info	*/
	private  String	 ediGateIoCd   =  null;
	/*	Column Info	*/
	private  String	 fcntrFlg   =  null;
	/*	Column Info	*/
	private  String	 inpDt   =  null;
	/*	Column Info	*/
	private  String	 mvmtEdiRmk   =  null;
	/*	Column Info	*/
	private  String	 vvdCd   =  null;
	/*	Column Info	*/
	private  String	 rtyKnt   =  null;
	/*	Column Info	*/
	private  String	 mvmtEdiSghtCd   =  null;
	/*	Column Info	*/
	private  String	 status   =  null;
	/*	Column Info	*/
	private  String	 callSgnNo   =  null;
	/*	Column Info	*/
	private  String	 cnmvEvntDt   =  null;
	/*	Column Info	*/
	private  String	 mvmtCreTpCd   =  null;
	/*	Column Info	*/
	private  String	 orgYdCd   =  null;
	/*	Column Info	*/
	private  String	 obCntrFlg   =  null;
	/*	Column Info	*/
	private  String	 mvmtStsCd   =  null;
	/*	Column Info	*/
	private  String	 inpTpCd   =  null;
	/*	Column Info	*/
	private  String	 refNo   =  null;
	/*	Column Info	*/
	private  String	 cntrFullStsCd   =  null;
	/*	Column Info	*/
	private  String	 ediBkgNo   =  null;
	/*	Column Info	*/
	private  String	 cntrSealNo   =  null;
	/*	Column Info	*/
	private  String	 cntrErrCnt   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 bkgKnt   =  null;
	/*	Column Info	*/
	private  String	 cntrDmgFlg   =  null;
	/*	Column Info	*/
	private  String	 chssNo   =  null;
	/*	Column Info	*/
	private  String	 mgstNo   =  null;
	/*	Column Info	*/
	private  String	 destYdCd   =  null;
	/*	Column Info	*/
	private  String	 lloydNo   =  null;
	/*	Column Info	*/
	private  String	 woNo   =  null;
	/*	Column Info	*/
	private  String	 ediVvdCd   =  null;
	/*	Column Info	*/
	private  String	 tirNo   =  null;
	/*	Column Info	*/
	private  String	 mtyPlnNo   =  null;
	/*	Column Info	*/
	private  String	 mtyRepoNo   =  null;
	/*	Column Info	*/
	private  String	 ediCrrNo   =  null;
	/*	Column Info	*/
	private  String	 trspDocNo   =  null;
	/*	Column Info	*/
	private  String	 crntVslCd   =  null;
	/*	Column Info	*/
	private  String	 crntSkdVoyNo   =  null;
	/*	Column Info	*/
	private  String	 crntSkdDirCd   =  null;
	/*	Column Info	*/
	private  String	 cnmvRmk   =  null;
	/*	Column Info	*/
	private  String	 mvmtEdiMsgAreaCd   =  null;
	/*	Column Info	*/
	private  String	 mvmtEdiMsgSeq   =  null;
	/*	Column Info	*/
	private  String	 mvmtEdiMsgTpId   =  null;
	/*	Column Info	*/
	private  String	 mvmtEdiMsgYrmondy   =  null;
	/*	Column Info	*/
	private  String	 mvmtEdiTpCd   =  null;
	/*	Column Info	*/
	private  String	 mvmtTrspModCd   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 chkFlg   =  null;
	/*	Column Info	*/
	private  String	 hCntrStsCd   =  null;
	/*	Column Info	*/
	private  String	 hOnhYdCd   =  null;
	/*	Column Info	*/
	private  String	 hCnmvEvntDt   =  null;
	/*	Column Info	*/
	private  String	 hChk1   =  null;
	/*	Column Info	*/
	private  String	 hChk2   =  null;
	/*	Column Info	*/
	private  String	 hChk3   =  null;
	/*	Column Info	*/
	private  String	 cnmvCycNoChg   =  null;
	/*	Column Info	*/
	private  String	 tvvd   =  null;
	/*	Column Info	*/
	private  String	 rowNum   =  null;
	/*	Column Info	*/
	private  String	 usrNm   =  null;
	/*	Column Info	*/
	private  String	 cnmvYr   =  null;
	/*	Column Info	*/
	private  String	 cnmvSeq   =  null;
	/*	Column Info	*/
	private  String	 cnmvSplitNo   =  null;
	/*	Column Info	*/
	private  String	 cnmvIdNo   =  null;
	/*	Column Info	*/
	private  String	 sEventDate1   =  null;
	/*	Column Info	*/
	private  String	 sEventDate2   =  null;
	/*	Column Info	*/
	private  String	 polEtdDt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public OscarBookingSearchVO(){}

	public OscarBookingSearchVO(String podCd,String porCd,String bkgCgoTpCd,String bkgNo,String polCd,String ibflag,String cnmvCycNo,String delCd,String blNo,String pagerows,String sCntrNo,String sBkgNo,String hBkgNo,String hCntrNo,String vslOscaUpdDt,String vslVvd,String vslEtb,String vslOscaCreDt,String vslEtd,String vslPodYdCd,String vslPrePstCd,String vslSlanCd,String vslPolYdCd,String cntrAgmtSeq,String cntrDeTermCd,String cntrCnmvStsCd,String cntrStsCd,String cntrRowSeq,String cntrMinOnhDys,String cntrRdCgoFlg,String cntrRcvTermCd,String cntrAgmtCtyCd,String cntrAwkCgoFlg,String cntrTpszCd,String cntrCrntYdCd,String cntrDcgoFlg,String cntrOnhYdCd,String cntrRefNo,String cntrCfmFlg,String cntrOnhDt,String cntrVndrAbbrNm,String cntrUsedDys,String cntrCnmvDt,String cntrRcFlg,String cntrNo,String cntrVolQty,String cntrCnmvCycNo,String cntrOnhFreeDys,String cntrVndrSeq,String cntrLstmCd,String cntrBbCgoFlg,String pCntrno,String checkDigit,String pDate1,String pDate2,String appCd,String slanCd,String bkgStsCd,String rcvTermCd,String deTermCd,String creDt,String updDt,String oscaBkgFlg,String ediGateIoCd,String fcntrFlg,String inpDt,String mvmtEdiRmk,String vvdCd,String rtyKnt,String mvmtEdiSghtCd,String status,String callSgnNo,String cnmvEvntDt,String mvmtCreTpCd,String orgYdCd,String obCntrFlg,String mvmtStsCd,String inpTpCd,String refNo,String cntrFullStsCd,String ediBkgNo,String cntrSealNo,String cntrErrCnt,String vndrSeq,String bkgKnt,String cntrDmgFlg,String chssNo,String mgstNo,String destYdCd,String lloydNo,String woNo,String ediVvdCd,String tirNo,String mtyPlnNo,String mtyRepoNo,String ediCrrNo,String trspDocNo,String crntVslCd,String crntSkdVoyNo,String crntSkdDirCd,String cnmvRmk,String mvmtEdiMsgAreaCd,String mvmtEdiMsgSeq,String mvmtEdiMsgTpId,String mvmtEdiMsgYrmondy,String mvmtEdiTpCd,String mvmtTrspModCd,String ofcCd,String updUsrId,String creUsrId,String chkFlg,String hCntrStsCd,String hOnhYdCd,String hCnmvEvntDt,String hChk1,String hChk2,String hChk3,String cnmvCycNoChg,String tvvd,String rowNum,String usrNm,String cnmvYr,String cnmvSeq,String cnmvSplitNo,String cnmvIdNo,String sEventDate1,String sEventDate2,String polEtdDt)	{
		this.podCd  = podCd ;
		this.porCd  = porCd ;
		this.bkgCgoTpCd  = bkgCgoTpCd ;
		this.bkgNo  = bkgNo ;
		this.polCd  = polCd ;
		this.ibflag  = ibflag ;
		this.cnmvCycNo  = cnmvCycNo ;
		this.delCd  = delCd ;
		this.blNo  = blNo ;
		this.pagerows  = pagerows ;
		this.sCntrNo  = sCntrNo ;
		this.sBkgNo  = sBkgNo ;
		this.hBkgNo  = hBkgNo ;
		this.hCntrNo  = hCntrNo ;
		this.vslOscaUpdDt  = vslOscaUpdDt ;
		this.vslVvd  = vslVvd ;
		this.vslEtb  = vslEtb ;
		this.vslOscaCreDt  = vslOscaCreDt ;
		this.vslEtd  = vslEtd ;
		this.vslPodYdCd  = vslPodYdCd ;
		this.vslPrePstCd  = vslPrePstCd ;
		this.vslSlanCd  = vslSlanCd ;
		this.vslPolYdCd  = vslPolYdCd ;
		this.cntrAgmtSeq  = cntrAgmtSeq ;
		this.cntrDeTermCd  = cntrDeTermCd ;
		this.cntrCnmvStsCd  = cntrCnmvStsCd ;
		this.cntrStsCd  = cntrStsCd ;
		this.cntrRowSeq  = cntrRowSeq ;
		this.cntrMinOnhDys  = cntrMinOnhDys ;
		this.cntrRdCgoFlg  = cntrRdCgoFlg ;
		this.cntrRcvTermCd  = cntrRcvTermCd ;
		this.cntrAgmtCtyCd  = cntrAgmtCtyCd ;
		this.cntrAwkCgoFlg  = cntrAwkCgoFlg ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.cntrCrntYdCd  = cntrCrntYdCd ;
		this.cntrDcgoFlg  = cntrDcgoFlg ;
		this.cntrOnhYdCd  = cntrOnhYdCd ;
		this.cntrRefNo  = cntrRefNo ;
		this.cntrCfmFlg  = cntrCfmFlg ;
		this.cntrOnhDt  = cntrOnhDt ;
		this.cntrVndrAbbrNm  = cntrVndrAbbrNm ;
		this.cntrUsedDys  = cntrUsedDys ;
		this.cntrCnmvDt  = cntrCnmvDt ;
		this.cntrRcFlg  = cntrRcFlg ;
		this.cntrNo  = cntrNo ;
		this.cntrVolQty  = cntrVolQty ;
		this.cntrCnmvCycNo  = cntrCnmvCycNo ;
		this.cntrOnhFreeDys  = cntrOnhFreeDys ;
		this.cntrVndrSeq  = cntrVndrSeq ;
		this.cntrLstmCd  = cntrLstmCd ;
		this.cntrBbCgoFlg  = cntrBbCgoFlg ;
		this.pCntrno  = pCntrno ;
		this.checkDigit  = checkDigit ;
		this.pDate1  = pDate1 ;
		this.pDate2  = pDate2 ;
		this.appCd  = appCd ;
		this.slanCd  = slanCd ;
		this.bkgStsCd  = bkgStsCd ;
		this.rcvTermCd  = rcvTermCd ;
		this.deTermCd  = deTermCd ;
		this.creDt  = creDt ;
		this.updDt  = updDt ;
		this.oscaBkgFlg  = oscaBkgFlg ;
		this.ediGateIoCd  = ediGateIoCd ;
		this.fcntrFlg  = fcntrFlg ;
		this.inpDt  = inpDt ;
		this.mvmtEdiRmk  = mvmtEdiRmk ;
		this.vvdCd  = vvdCd ;
		this.rtyKnt  = rtyKnt ;
		this.mvmtEdiSghtCd  = mvmtEdiSghtCd ;
		this.status  = status ;
		this.callSgnNo  = callSgnNo ;
		this.cnmvEvntDt  = cnmvEvntDt ;
		this.mvmtCreTpCd  = mvmtCreTpCd ;
		this.orgYdCd  = orgYdCd ;
		this.obCntrFlg  = obCntrFlg ;
		this.mvmtStsCd  = mvmtStsCd ;
		this.inpTpCd  = inpTpCd ;
		this.refNo  = refNo ;
		this.cntrFullStsCd  = cntrFullStsCd ;
		this.ediBkgNo  = ediBkgNo ;
		this.cntrSealNo  = cntrSealNo ;
		this.cntrErrCnt  = cntrErrCnt ;
		this.vndrSeq  = vndrSeq ;
		this.bkgKnt  = bkgKnt ;
		this.cntrDmgFlg  = cntrDmgFlg ;
		this.chssNo  = chssNo ;
		this.mgstNo  = mgstNo ;
		this.destYdCd  = destYdCd ;
		this.lloydNo  = lloydNo ;
		this.woNo  = woNo ;
		this.ediVvdCd  = ediVvdCd ;
		this.tirNo  = tirNo ;
		this.mtyPlnNo  = mtyPlnNo ;
		this.mtyRepoNo  = mtyRepoNo ;
		this.ediCrrNo  = ediCrrNo ;
		this.trspDocNo  = trspDocNo ;
		this.crntVslCd  = crntVslCd ;
		this.crntSkdVoyNo  = crntSkdVoyNo ;
		this.crntSkdDirCd  = crntSkdDirCd ;
		this.cnmvRmk  = cnmvRmk ;
		this.mvmtEdiMsgAreaCd  = mvmtEdiMsgAreaCd ;
		this.mvmtEdiMsgSeq  = mvmtEdiMsgSeq ;
		this.mvmtEdiMsgTpId  = mvmtEdiMsgTpId ;
		this.mvmtEdiMsgYrmondy  = mvmtEdiMsgYrmondy ;
		this.mvmtEdiTpCd  = mvmtEdiTpCd ;
		this.mvmtTrspModCd  = mvmtTrspModCd ;
		this.ofcCd  = ofcCd ;
		this.updUsrId  = updUsrId ;
		this.creUsrId  = creUsrId ;
		this.chkFlg  = chkFlg ;
		this.hCntrStsCd  = hCntrStsCd ;
		this.hOnhYdCd  = hOnhYdCd ;
		this.hCnmvEvntDt  = hCnmvEvntDt ;
		this.hChk1  = hChk1 ;
		this.hChk2  = hChk2 ;
		this.hChk3  = hChk3 ;
		this.cnmvCycNoChg  = cnmvCycNoChg ;
		this.tvvd  = tvvd ;
		this.rowNum  = rowNum ;
		this.usrNm  = usrNm ;
		this.cnmvYr  = cnmvYr ;
		this.cnmvSeq  = cnmvSeq ;
		this.cnmvSplitNo  = cnmvSplitNo ;
		this.cnmvIdNo  = cnmvIdNo ;
		this.sEventDate1  = sEventDate1 ;
		this.sEventDate2  = sEventDate2 ;
		this.polEtdDt  = polEtdDt ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod_cd", getPodCd());		
		this.hashColumns.put("por_cd", getPorCd());		
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("pol_cd", getPolCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("cnmv_cyc_no", getCnmvCycNo());		
		this.hashColumns.put("del_cd", getDelCd());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("s_cntr_no", getSCntrNo());		
		this.hashColumns.put("s_bkg_no", getSBkgNo());		
		this.hashColumns.put("h_bkg_no", getHBkgNo());		
		this.hashColumns.put("h_cntr_no", getHCntrNo());		
		this.hashColumns.put("vsl_osca_upd_dt", getVslOscaUpdDt());		
		this.hashColumns.put("vsl_vvd", getVslVvd());		
		this.hashColumns.put("vsl_etb", getVslEtb());		
		this.hashColumns.put("vsl_osca_cre_dt", getVslOscaCreDt());		
		this.hashColumns.put("vsl_etd", getVslEtd());		
		this.hashColumns.put("vsl_pod_yd_cd", getVslPodYdCd());		
		this.hashColumns.put("vsl_pre_pst_cd", getVslPrePstCd());		
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());		
		this.hashColumns.put("vsl_pol_yd_cd", getVslPolYdCd());		
		this.hashColumns.put("cntr_agmt_seq", getCntrAgmtSeq());		
		this.hashColumns.put("cntr_de_term_cd", getCntrDeTermCd());		
		this.hashColumns.put("cntr_cnmv_sts_cd", getCntrCnmvStsCd());		
		this.hashColumns.put("cntr_sts_cd", getCntrStsCd());		
		this.hashColumns.put("cntr_row_seq", getCntrRowSeq());		
		this.hashColumns.put("cntr_min_onh_dys", getCntrMinOnhDys());		
		this.hashColumns.put("cntr_rd_cgo_flg", getCntrRdCgoFlg());		
		this.hashColumns.put("cntr_rcv_term_cd", getCntrRcvTermCd());		
		this.hashColumns.put("cntr_agmt_cty_cd", getCntrAgmtCtyCd());		
		this.hashColumns.put("cntr_awk_cgo_flg", getCntrAwkCgoFlg());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("cntr_crnt_yd_cd", getCntrCrntYdCd());		
		this.hashColumns.put("cntr_dcgo_flg", getCntrDcgoFlg());		
		this.hashColumns.put("cntr_onh_yd_cd", getCntrOnhYdCd());		
		this.hashColumns.put("cntr_ref_no", getCntrRefNo());		
		this.hashColumns.put("cntr_cfm_flg", getCntrCfmFlg());		
		this.hashColumns.put("cntr_onh_dt", getCntrOnhDt());		
		this.hashColumns.put("cntr_vndr_abbr_nm", getCntrVndrAbbrNm());		
		this.hashColumns.put("cntr_used_dys", getCntrUsedDys());		
		this.hashColumns.put("cntr_cnmv_dt", getCntrCnmvDt());		
		this.hashColumns.put("cntr_rc_flg", getCntrRcFlg());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("cntr_vol_qty", getCntrVolQty());		
		this.hashColumns.put("cntr_cnmv_cyc_no", getCntrCnmvCycNo());		
		this.hashColumns.put("cntr_onh_free_dys", getCntrOnhFreeDys());		
		this.hashColumns.put("cntr_vndr_seq", getCntrVndrSeq());		
		this.hashColumns.put("cntr_lstm_cd", getCntrLstmCd());		
		this.hashColumns.put("cntr_bb_cgo_flg", getCntrBbCgoFlg());		
		this.hashColumns.put("p_cntrno", getPCntrno());		
		this.hashColumns.put("check_digit", getCheckDigit());		
		this.hashColumns.put("p_date1", getPDate1());		
		this.hashColumns.put("p_date2", getPDate2());		
		this.hashColumns.put("app_cd", getAppCd());		
		this.hashColumns.put("slan_cd", getSlanCd());		
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());		
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());		
		this.hashColumns.put("de_term_cd", getDeTermCd());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("osca_bkg_flg", getOscaBkgFlg());		
		this.hashColumns.put("edi_gate_io_cd", getEdiGateIoCd());		
		this.hashColumns.put("fcntr_flg", getFcntrFlg());		
		this.hashColumns.put("inp_dt", getInpDt());		
		this.hashColumns.put("mvmt_edi_rmk", getMvmtEdiRmk());		
		this.hashColumns.put("vvd_cd", getVvdCd());		
		this.hashColumns.put("rty_knt", getRtyKnt());		
		this.hashColumns.put("mvmt_edi_sght_cd", getMvmtEdiSghtCd());		
		this.hashColumns.put("status", getStatus());		
		this.hashColumns.put("call_sgn_no", getCallSgnNo());		
		this.hashColumns.put("cnmv_evnt_dt", getCnmvEvntDt());		
		this.hashColumns.put("mvmt_cre_tp_cd", getMvmtCreTpCd());		
		this.hashColumns.put("org_yd_cd", getOrgYdCd());		
		this.hashColumns.put("ob_cntr_flg", getObCntrFlg());		
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());		
		this.hashColumns.put("inp_tp_cd", getInpTpCd());		
		this.hashColumns.put("ref_no", getRefNo());		
		this.hashColumns.put("cntr_full_sts_cd", getCntrFullStsCd());		
		this.hashColumns.put("edi_bkg_no", getEdiBkgNo());		
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());		
		this.hashColumns.put("cntr_err_cnt", getCntrErrCnt());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("bkg_knt", getBkgKnt());		
		this.hashColumns.put("cntr_dmg_flg", getCntrDmgFlg());		
		this.hashColumns.put("chss_no", getChssNo());		
		this.hashColumns.put("mgst_no", getMgstNo());		
		this.hashColumns.put("dest_yd_cd", getDestYdCd());		
		this.hashColumns.put("lloyd_no", getLloydNo());		
		this.hashColumns.put("wo_no", getWoNo());		
		this.hashColumns.put("edi_vvd_cd", getEdiVvdCd());		
		this.hashColumns.put("tir_no", getTirNo());		
		this.hashColumns.put("mty_pln_no", getMtyPlnNo());		
		this.hashColumns.put("mty_repo_no", getMtyRepoNo());		
		this.hashColumns.put("edi_crr_no", getEdiCrrNo());		
		this.hashColumns.put("trsp_doc_no", getTrspDocNo());		
		this.hashColumns.put("crnt_vsl_cd", getCrntVslCd());		
		this.hashColumns.put("crnt_skd_voy_no", getCrntSkdVoyNo());		
		this.hashColumns.put("crnt_skd_dir_cd", getCrntSkdDirCd());		
		this.hashColumns.put("cnmv_rmk", getCnmvRmk());		
		this.hashColumns.put("mvmt_edi_msg_area_cd", getMvmtEdiMsgAreaCd());		
		this.hashColumns.put("mvmt_edi_msg_seq", getMvmtEdiMsgSeq());		
		this.hashColumns.put("mvmt_edi_msg_tp_id", getMvmtEdiMsgTpId());		
		this.hashColumns.put("mvmt_edi_msg_yrmondy", getMvmtEdiMsgYrmondy());		
		this.hashColumns.put("mvmt_edi_tp_cd", getMvmtEdiTpCd());		
		this.hashColumns.put("mvmt_trsp_mod_cd", getMvmtTrspModCd());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("chk_flg", getChkFlg());		
		this.hashColumns.put("h_cntr_sts_cd", getHCntrStsCd());		
		this.hashColumns.put("h_onh_yd_cd", getHOnhYdCd());		
		this.hashColumns.put("h_cnmv_evnt_dt", getHCnmvEvntDt());		
		this.hashColumns.put("h_chk1", getHChk1());		
		this.hashColumns.put("h_chk2", getHChk2());		
		this.hashColumns.put("h_chk3", getHChk3());		
		this.hashColumns.put("cnmv_cyc_no_chg", getCnmvCycNoChg());		
		this.hashColumns.put("tvvd", getTvvd());		
		this.hashColumns.put("row_num", getRowNum());		
		this.hashColumns.put("usr_nm", getUsrNm());		
		this.hashColumns.put("cnmv_yr", getCnmvYr());		
		this.hashColumns.put("cnmv_seq", getCnmvSeq());		
		this.hashColumns.put("cnmv_split_no", getCnmvSplitNo());		
		this.hashColumns.put("cnmv_id_no", getCnmvIdNo());		
		this.hashColumns.put("s_event_date1", getSEventDate1());		
		this.hashColumns.put("s_event_date2", getSEventDate2());	
		this.hashColumns.put("pol_etd_dt", getPolEtdDt());	
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnmv_cyc_no", "cnmvCycNo");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s_cntr_no", "sCntrNo");
		this.hashFields.put("s_bkg_no", "sBkgNo");
		this.hashFields.put("h_bkg_no", "hBkgNo");
		this.hashFields.put("h_cntr_no", "hCntrNo");
		this.hashFields.put("vsl_osca_upd_dt", "vslOscaUpdDt");
		this.hashFields.put("vsl_vvd", "vslVvd");
		this.hashFields.put("vsl_etb", "vslEtb");
		this.hashFields.put("vsl_osca_cre_dt", "vslOscaCreDt");
		this.hashFields.put("vsl_etd", "vslEtd");
		this.hashFields.put("vsl_pod_yd_cd", "vslPodYdCd");
		this.hashFields.put("vsl_pre_pst_cd", "vslPrePstCd");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("vsl_pol_yd_cd", "vslPolYdCd");
		this.hashFields.put("cntr_agmt_seq", "cntrAgmtSeq");
		this.hashFields.put("cntr_de_term_cd", "cntrDeTermCd");
		this.hashFields.put("cntr_cnmv_sts_cd", "cntrCnmvStsCd");
		this.hashFields.put("cntr_sts_cd", "cntrStsCd");
		this.hashFields.put("cntr_row_seq", "cntrRowSeq");
		this.hashFields.put("cntr_min_onh_dys", "cntrMinOnhDys");
		this.hashFields.put("cntr_rd_cgo_flg", "cntrRdCgoFlg");
		this.hashFields.put("cntr_rcv_term_cd", "cntrRcvTermCd");
		this.hashFields.put("cntr_agmt_cty_cd", "cntrAgmtCtyCd");
		this.hashFields.put("cntr_awk_cgo_flg", "cntrAwkCgoFlg");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_crnt_yd_cd", "cntrCrntYdCd");
		this.hashFields.put("cntr_dcgo_flg", "cntrDcgoFlg");
		this.hashFields.put("cntr_onh_yd_cd", "cntrOnhYdCd");
		this.hashFields.put("cntr_ref_no", "cntrRefNo");
		this.hashFields.put("cntr_cfm_flg", "cntrCfmFlg");
		this.hashFields.put("cntr_onh_dt", "cntrOnhDt");
		this.hashFields.put("cntr_vndr_abbr_nm", "cntrVndrAbbrNm");
		this.hashFields.put("cntr_used_dys", "cntrUsedDys");
		this.hashFields.put("cntr_cnmv_dt", "cntrCnmvDt");
		this.hashFields.put("cntr_rc_flg", "cntrRcFlg");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_vol_qty", "cntrVolQty");
		this.hashFields.put("cntr_cnmv_cyc_no", "cntrCnmvCycNo");
		this.hashFields.put("cntr_onh_free_dys", "cntrOnhFreeDys");
		this.hashFields.put("cntr_vndr_seq", "cntrVndrSeq");
		this.hashFields.put("cntr_lstm_cd", "cntrLstmCd");
		this.hashFields.put("cntr_bb_cgo_flg", "cntrBbCgoFlg");
		this.hashFields.put("p_cntrno", "pCntrno");
		this.hashFields.put("check_digit", "checkDigit");
		this.hashFields.put("p_date1", "pDate1");
		this.hashFields.put("p_date2", "pDate2");
		this.hashFields.put("app_cd", "appCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("osca_bkg_flg", "oscaBkgFlg");
		this.hashFields.put("edi_gate_io_cd", "ediGateIoCd");
		this.hashFields.put("fcntr_flg", "fcntrFlg");
		this.hashFields.put("inp_dt", "inpDt");
		this.hashFields.put("mvmt_edi_rmk", "mvmtEdiRmk");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("rty_knt", "rtyKnt");
		this.hashFields.put("mvmt_edi_sght_cd", "mvmtEdiSghtCd");
		this.hashFields.put("status", "status");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("cnmv_evnt_dt", "cnmvEvntDt");
		this.hashFields.put("mvmt_cre_tp_cd", "mvmtCreTpCd");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("ob_cntr_flg", "obCntrFlg");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("inp_tp_cd", "inpTpCd");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("cntr_full_sts_cd", "cntrFullStsCd");
		this.hashFields.put("edi_bkg_no", "ediBkgNo");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("cntr_err_cnt", "cntrErrCnt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("bkg_knt", "bkgKnt");
		this.hashFields.put("cntr_dmg_flg", "cntrDmgFlg");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("mgst_no", "mgstNo");
		this.hashFields.put("dest_yd_cd", "destYdCd");
		this.hashFields.put("lloyd_no", "lloydNo");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("edi_vvd_cd", "ediVvdCd");
		this.hashFields.put("tir_no", "tirNo");
		this.hashFields.put("mty_pln_no", "mtyPlnNo");
		this.hashFields.put("mty_repo_no", "mtyRepoNo");
		this.hashFields.put("edi_crr_no", "ediCrrNo");
		this.hashFields.put("trsp_doc_no", "trspDocNo");
		this.hashFields.put("crnt_vsl_cd", "crntVslCd");
		this.hashFields.put("crnt_skd_voy_no", "crntSkdVoyNo");
		this.hashFields.put("crnt_skd_dir_cd", "crntSkdDirCd");
		this.hashFields.put("cnmv_rmk", "cnmvRmk");
		this.hashFields.put("mvmt_edi_msg_area_cd", "mvmtEdiMsgAreaCd");
		this.hashFields.put("mvmt_edi_msg_seq", "mvmtEdiMsgSeq");
		this.hashFields.put("mvmt_edi_msg_tp_id", "mvmtEdiMsgTpId");
		this.hashFields.put("mvmt_edi_msg_yrmondy", "mvmtEdiMsgYrmondy");
		this.hashFields.put("mvmt_edi_tp_cd", "mvmtEdiTpCd");
		this.hashFields.put("mvmt_trsp_mod_cd", "mvmtTrspModCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("chk_flg", "chkFlg");
		this.hashFields.put("h_cntr_sts_cd", "hCntrStsCd");
		this.hashFields.put("h_onh_yd_cd", "hOnhYdCd");
		this.hashFields.put("h_cnmv_evnt_dt", "hCnmvEvntDt");
		this.hashFields.put("h_chk1", "hChk1");
		this.hashFields.put("h_chk2", "hChk2");
		this.hashFields.put("h_chk3", "hChk3");
		this.hashFields.put("cnmv_cyc_no_chg", "cnmvCycNoChg");
		this.hashFields.put("tvvd", "tvvd");
		this.hashFields.put("row_num", "rowNum");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("cnmv_seq", "cnmvSeq");
		this.hashFields.put("cnmv_split_no", "cnmvSplitNo");
		this.hashFields.put("cnmv_id_no", "cnmvIdNo");
		this.hashFields.put("s_event_date1", "sEventDate1");
		this.hashFields.put("s_event_date2", "sEventDate2");
		this.hashFields.put("pol_etd_dt", "polEtdDt");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	 public	 String	getPodCd() {
		 return	this.podCd;
	 } 
 	/**
	* Column Info
	* @param  porCd
	*/
	public void	setPorCd( String	porCd ) {
		this.porCd =	porCd;
	}
 
	/**
	 * Column Info
	 * @return	porCd
	 */
	 public	 String	getPorCd() {
		 return	this.porCd;
	 } 
 	/**
	* Column Info
	* @param  bkgCgoTpCd
	*/
	public void	setBkgCgoTpCd( String	bkgCgoTpCd ) {
		this.bkgCgoTpCd =	bkgCgoTpCd;
	}
 
	/**
	 * Column Info
	 * @return	bkgCgoTpCd
	 */
	 public	 String	getBkgCgoTpCd() {
		 return	this.bkgCgoTpCd;
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
	* @param  polCd
	*/
	public void	setPolCd( String	polCd ) {
		this.polCd =	polCd;
	}
 
	/**
	 * Column Info
	 * @return	polCd
	 */
	 public	 String	getPolCd() {
		 return	this.polCd;
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
	* @param  cnmvCycNo
	*/
	public void	setCnmvCycNo( String	cnmvCycNo ) {
		this.cnmvCycNo =	cnmvCycNo;
	}
 
	/**
	 * Column Info
	 * @return	cnmvCycNo
	 */
	 public	 String	getCnmvCycNo() {
		 return	this.cnmvCycNo;
	 } 
 	/**
	* Column Info
	* @param  delCd
	*/
	public void	setDelCd( String	delCd ) {
		this.delCd =	delCd;
	}
 
	/**
	 * Column Info
	 * @return	delCd
	 */
	 public	 String	getDelCd() {
		 return	this.delCd;
	 } 
 	/**
	* Column Info
	* @param  blNo
	*/
	public void	setBlNo( String	blNo ) {
		this.blNo =	blNo;
	}
 
	/**
	 * Column Info
	 * @return	blNo
	 */
	 public	 String	getBlNo() {
		 return	this.blNo;
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
	* @param  sCntrNo
	*/
	public void	setSCntrNo( String	sCntrNo ) {
		this.sCntrNo =	sCntrNo;
	}
 
	/**
	 * Column Info
	 * @return	sCntrNo
	 */
	 public	 String	getSCntrNo() {
		 return	this.sCntrNo;
	 } 
 	/**
	* Column Info
	* @param  sBkgNo
	*/
	public void	setSBkgNo( String	sBkgNo ) {
		this.sBkgNo =	sBkgNo;
	}
 
	/**
	 * Column Info
	 * @return	sBkgNo
	 */
	 public	 String	getSBkgNo() {
		 return	this.sBkgNo;
	 } 
 	/**
	* Column Info
	* @param  hBkgNo
	*/
	public void	setHBkgNo( String	hBkgNo ) {
		this.hBkgNo =	hBkgNo;
	}
 
	/**
	 * Column Info
	 * @return	hBkgNo
	 */
	 public	 String	getHBkgNo() {
		 return	this.hBkgNo;
	 } 
 	/**
	* Column Info
	* @param  hCntrNo
	*/
	public void	setHCntrNo( String	hCntrNo ) {
		this.hCntrNo =	hCntrNo;
	}
 
	/**
	 * Column Info
	 * @return	hCntrNo
	 */
	 public	 String	getHCntrNo() {
		 return	this.hCntrNo;
	 } 
 	/**
	* Column Info
	* @param  vslOscaUpdDt
	*/
	public void	setVslOscaUpdDt( String	vslOscaUpdDt ) {
		this.vslOscaUpdDt =	vslOscaUpdDt;
	}
 
	/**
	 * Column Info
	 * @return	vslOscaUpdDt
	 */
	 public	 String	getVslOscaUpdDt() {
		 return	this.vslOscaUpdDt;
	 } 
 	/**
	* Column Info
	* @param  vslVvd
	*/
	public void	setVslVvd( String	vslVvd ) {
		this.vslVvd =	vslVvd;
	}
 
	/**
	 * Column Info
	 * @return	vslVvd
	 */
	 public	 String	getVslVvd() {
		 return	this.vslVvd;
	 } 
 	/**
	* Column Info
	* @param  vslEtb
	*/
	public void	setVslEtb( String	vslEtb ) {
		this.vslEtb =	vslEtb;
	}
 
	/**
	 * Column Info
	 * @return	vslEtb
	 */
	 public	 String	getVslEtb() {
		 return	this.vslEtb;
	 } 
 	/**
	* Column Info
	* @param  vslOscaCreDt
	*/
	public void	setVslOscaCreDt( String	vslOscaCreDt ) {
		this.vslOscaCreDt =	vslOscaCreDt;
	}
 
	/**
	 * Column Info
	 * @return	vslOscaCreDt
	 */
	 public	 String	getVslOscaCreDt() {
		 return	this.vslOscaCreDt;
	 } 
 	/**
	* Column Info
	* @param  vslEtd
	*/
	public void	setVslEtd( String	vslEtd ) {
		this.vslEtd =	vslEtd;
	}
 
	/**
	 * Column Info
	 * @return	vslEtd
	 */
	 public	 String	getVslEtd() {
		 return	this.vslEtd;
	 } 
 	/**
	* Column Info
	* @param  vslPodYdCd
	*/
	public void	setVslPodYdCd( String	vslPodYdCd ) {
		this.vslPodYdCd =	vslPodYdCd;
	}
 
	/**
	 * Column Info
	 * @return	vslPodYdCd
	 */
	 public	 String	getVslPodYdCd() {
		 return	this.vslPodYdCd;
	 } 
 	/**
	* Column Info
	* @param  vslPrePstCd
	*/
	public void	setVslPrePstCd( String	vslPrePstCd ) {
		this.vslPrePstCd =	vslPrePstCd;
	}
 
	/**
	 * Column Info
	 * @return	vslPrePstCd
	 */
	 public	 String	getVslPrePstCd() {
		 return	this.vslPrePstCd;
	 } 
 	/**
	* Column Info
	* @param  vslSlanCd
	*/
	public void	setVslSlanCd( String	vslSlanCd ) {
		this.vslSlanCd =	vslSlanCd;
	}
 
	/**
	 * Column Info
	 * @return	vslSlanCd
	 */
	 public	 String	getVslSlanCd() {
		 return	this.vslSlanCd;
	 } 
 	/**
	* Column Info
	* @param  vslPolYdCd
	*/
	public void	setVslPolYdCd( String	vslPolYdCd ) {
		this.vslPolYdCd =	vslPolYdCd;
	}
 
	/**
	 * Column Info
	 * @return	vslPolYdCd
	 */
	 public	 String	getVslPolYdCd() {
		 return	this.vslPolYdCd;
	 } 
 	/**
	* Column Info
	* @param  cntrAgmtSeq
	*/
	public void	setCntrAgmtSeq( String	cntrAgmtSeq ) {
		this.cntrAgmtSeq =	cntrAgmtSeq;
	}
 
	/**
	 * Column Info
	 * @return	cntrAgmtSeq
	 */
	 public	 String	getCntrAgmtSeq() {
		 return	this.cntrAgmtSeq;
	 } 
 	/**
	* Column Info
	* @param  cntrDeTermCd
	*/
	public void	setCntrDeTermCd( String	cntrDeTermCd ) {
		this.cntrDeTermCd =	cntrDeTermCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrDeTermCd
	 */
	 public	 String	getCntrDeTermCd() {
		 return	this.cntrDeTermCd;
	 } 
 	/**
	* Column Info
	* @param  cntrCnmvStsCd
	*/
	public void	setCntrCnmvStsCd( String	cntrCnmvStsCd ) {
		this.cntrCnmvStsCd =	cntrCnmvStsCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrCnmvStsCd
	 */
	 public	 String	getCntrCnmvStsCd() {
		 return	this.cntrCnmvStsCd;
	 } 
 	/**
	* Column Info
	* @param  cntrStsCd
	*/
	public void	setCntrStsCd( String	cntrStsCd ) {
		this.cntrStsCd =	cntrStsCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrStsCd
	 */
	 public	 String	getCntrStsCd() {
		 return	this.cntrStsCd;
	 } 
 	/**
	* Column Info
	* @param  cntrRowSeq
	*/
	public void	setCntrRowSeq( String	cntrRowSeq ) {
		this.cntrRowSeq =	cntrRowSeq;
	}
 
	/**
	 * Column Info
	 * @return	cntrRowSeq
	 */
	 public	 String	getCntrRowSeq() {
		 return	this.cntrRowSeq;
	 } 
 	/**
	* Column Info
	* @param  cntrMinOnhDys
	*/
	public void	setCntrMinOnhDys( String	cntrMinOnhDys ) {
		this.cntrMinOnhDys =	cntrMinOnhDys;
	}
 
	/**
	 * Column Info
	 * @return	cntrMinOnhDys
	 */
	 public	 String	getCntrMinOnhDys() {
		 return	this.cntrMinOnhDys;
	 } 
 	/**
	* Column Info
	* @param  cntrRdCgoFlg
	*/
	public void	setCntrRdCgoFlg( String	cntrRdCgoFlg ) {
		this.cntrRdCgoFlg =	cntrRdCgoFlg;
	}
 
	/**
	 * Column Info
	 * @return	cntrRdCgoFlg
	 */
	 public	 String	getCntrRdCgoFlg() {
		 return	this.cntrRdCgoFlg;
	 } 
 	/**
	* Column Info
	* @param  cntrRcvTermCd
	*/
	public void	setCntrRcvTermCd( String	cntrRcvTermCd ) {
		this.cntrRcvTermCd =	cntrRcvTermCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrRcvTermCd
	 */
	 public	 String	getCntrRcvTermCd() {
		 return	this.cntrRcvTermCd;
	 } 
 	/**
	* Column Info
	* @param  cntrAgmtCtyCd
	*/
	public void	setCntrAgmtCtyCd( String	cntrAgmtCtyCd ) {
		this.cntrAgmtCtyCd =	cntrAgmtCtyCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrAgmtCtyCd
	 */
	 public	 String	getCntrAgmtCtyCd() {
		 return	this.cntrAgmtCtyCd;
	 } 
 	/**
	* Column Info
	* @param  cntrAwkCgoFlg
	*/
	public void	setCntrAwkCgoFlg( String	cntrAwkCgoFlg ) {
		this.cntrAwkCgoFlg =	cntrAwkCgoFlg;
	}
 
	/**
	 * Column Info
	 * @return	cntrAwkCgoFlg
	 */
	 public	 String	getCntrAwkCgoFlg() {
		 return	this.cntrAwkCgoFlg;
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
	 public	 String	getCntrTpszCd() {
		 return	this.cntrTpszCd;
	 } 
 	/**
	* Column Info
	* @param  cntrCrntYdCd
	*/
	public void	setCntrCrntYdCd( String	cntrCrntYdCd ) {
		this.cntrCrntYdCd =	cntrCrntYdCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrCrntYdCd
	 */
	 public	 String	getCntrCrntYdCd() {
		 return	this.cntrCrntYdCd;
	 } 
 	/**
	* Column Info
	* @param  cntrDcgoFlg
	*/
	public void	setCntrDcgoFlg( String	cntrDcgoFlg ) {
		this.cntrDcgoFlg =	cntrDcgoFlg;
	}
 
	/**
	 * Column Info
	 * @return	cntrDcgoFlg
	 */
	 public	 String	getCntrDcgoFlg() {
		 return	this.cntrDcgoFlg;
	 } 
 	/**
	* Column Info
	* @param  cntrOnhYdCd
	*/
	public void	setCntrOnhYdCd( String	cntrOnhYdCd ) {
		this.cntrOnhYdCd =	cntrOnhYdCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrOnhYdCd
	 */
	 public	 String	getCntrOnhYdCd() {
		 return	this.cntrOnhYdCd;
	 } 
 	/**
	* Column Info
	* @param  cntrRefNo
	*/
	public void	setCntrRefNo( String	cntrRefNo ) {
		this.cntrRefNo =	cntrRefNo;
	}
 
	/**
	 * Column Info
	 * @return	cntrRefNo
	 */
	 public	 String	getCntrRefNo() {
		 return	this.cntrRefNo;
	 } 
 	/**
	* Column Info
	* @param  cntrCfmFlg
	*/
	public void	setCntrCfmFlg( String	cntrCfmFlg ) {
		this.cntrCfmFlg =	cntrCfmFlg;
	}
 
	/**
	 * Column Info
	 * @return	cntrCfmFlg
	 */
	 public	 String	getCntrCfmFlg() {
		 return	this.cntrCfmFlg;
	 } 
 	/**
	* Column Info
	* @param  cntrOnhDt
	*/
	public void	setCntrOnhDt( String	cntrOnhDt ) {
		this.cntrOnhDt =	cntrOnhDt;
	}
 
	/**
	 * Column Info
	 * @return	cntrOnhDt
	 */
	 public	 String	getCntrOnhDt() {
		 return	this.cntrOnhDt;
	 } 
 	/**
	* Column Info
	* @param  cntrVndrAbbrNm
	*/
	public void	setCntrVndrAbbrNm( String	cntrVndrAbbrNm ) {
		this.cntrVndrAbbrNm =	cntrVndrAbbrNm;
	}
 
	/**
	 * Column Info
	 * @return	cntrVndrAbbrNm
	 */
	 public	 String	getCntrVndrAbbrNm() {
		 return	this.cntrVndrAbbrNm;
	 } 
 	/**
	* Column Info
	* @param  cntrUsedDys
	*/
	public void	setCntrUsedDys( String	cntrUsedDys ) {
		this.cntrUsedDys =	cntrUsedDys;
	}
 
	/**
	 * Column Info
	 * @return	cntrUsedDys
	 */
	 public	 String	getCntrUsedDys() {
		 return	this.cntrUsedDys;
	 } 
 	/**
	* Column Info
	* @param  cntrCnmvDt
	*/
	public void	setCntrCnmvDt( String	cntrCnmvDt ) {
		this.cntrCnmvDt =	cntrCnmvDt;
	}
 
	/**
	 * Column Info
	 * @return	cntrCnmvDt
	 */
	 public	 String	getCntrCnmvDt() {
		 return	this.cntrCnmvDt;
	 } 
 	/**
	* Column Info
	* @param  cntrRcFlg
	*/
	public void	setCntrRcFlg( String	cntrRcFlg ) {
		this.cntrRcFlg =	cntrRcFlg;
	}
 
	/**
	 * Column Info
	 * @return	cntrRcFlg
	 */
	 public	 String	getCntrRcFlg() {
		 return	this.cntrRcFlg;
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
	 public	 String	getCntrNo() {
		 return	this.cntrNo;
	 } 
 	/**
	* Column Info
	* @param  cntrVolQty
	*/
	public void	setCntrVolQty( String	cntrVolQty ) {
		this.cntrVolQty =	cntrVolQty;
	}
 
	/**
	 * Column Info
	 * @return	cntrVolQty
	 */
	 public	 String	getCntrVolQty() {
		 return	this.cntrVolQty;
	 } 
 	/**
	* Column Info
	* @param  cntrCnmvCycNo
	*/
	public void	setCntrCnmvCycNo( String	cntrCnmvCycNo ) {
		this.cntrCnmvCycNo =	cntrCnmvCycNo;
	}
 
	/**
	 * Column Info
	 * @return	cntrCnmvCycNo
	 */
	 public	 String	getCntrCnmvCycNo() {
		 return	this.cntrCnmvCycNo;
	 } 
 	/**
	* Column Info
	* @param  cntrOnhFreeDys
	*/
	public void	setCntrOnhFreeDys( String	cntrOnhFreeDys ) {
		this.cntrOnhFreeDys =	cntrOnhFreeDys;
	}
 
	/**
	 * Column Info
	 * @return	cntrOnhFreeDys
	 */
	 public	 String	getCntrOnhFreeDys() {
		 return	this.cntrOnhFreeDys;
	 } 
 	/**
	* Column Info
	* @param  cntrVndrSeq
	*/
	public void	setCntrVndrSeq( String	cntrVndrSeq ) {
		this.cntrVndrSeq =	cntrVndrSeq;
	}
 
	/**
	 * Column Info
	 * @return	cntrVndrSeq
	 */
	 public	 String	getCntrVndrSeq() {
		 return	this.cntrVndrSeq;
	 } 
 	/**
	* Column Info
	* @param  cntrLstmCd
	*/
	public void	setCntrLstmCd( String	cntrLstmCd ) {
		this.cntrLstmCd =	cntrLstmCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrLstmCd
	 */
	 public	 String	getCntrLstmCd() {
		 return	this.cntrLstmCd;
	 } 
 	/**
	* Column Info
	* @param  cntrBbCgoFlg
	*/
	public void	setCntrBbCgoFlg( String	cntrBbCgoFlg ) {
		this.cntrBbCgoFlg =	cntrBbCgoFlg;
	}
 
	/**
	 * Column Info
	 * @return	cntrBbCgoFlg
	 */
	 public	 String	getCntrBbCgoFlg() {
		 return	this.cntrBbCgoFlg;
	 } 
 	/**
	* Column Info
	* @param  pCntrno
	*/
	public void	setPCntrno( String	pCntrno ) {
		this.pCntrno =	pCntrno;
	}
 
	/**
	 * Column Info
	 * @return	pCntrno
	 */
	 public	 String	getPCntrno() {
		 return	this.pCntrno;
	 } 
 	/**
	* Column Info
	* @param  checkDigit
	*/
	public void	setCheckDigit( String	checkDigit ) {
		this.checkDigit =	checkDigit;
	}
 
	/**
	 * Column Info
	 * @return	checkDigit
	 */
	 public	 String	getCheckDigit() {
		 return	this.checkDigit;
	 } 
 	/**
	* Column Info
	* @param  pDate1
	*/
	public void	setPDate1( String	pDate1 ) {
		this.pDate1 =	pDate1;
	}
 
	/**
	 * Column Info
	 * @return	pDate1
	 */
	 public	 String	getPDate1() {
		 return	this.pDate1;
	 } 
 	/**
	* Column Info
	* @param  pDate2
	*/
	public void	setPDate2( String	pDate2 ) {
		this.pDate2 =	pDate2;
	}
 
	/**
	 * Column Info
	 * @return	pDate2
	 */
	 public	 String	getPDate2() {
		 return	this.pDate2;
	 } 
 	/**
	* Column Info
	* @param  appCd
	*/
	public void	setAppCd( String	appCd ) {
		this.appCd =	appCd;
	}
 
	/**
	 * Column Info
	 * @return	appCd
	 */
	 public	 String	getAppCd() {
		 return	this.appCd;
	 } 
 	/**
	* Column Info
	* @param  slanCd
	*/
	public void	setSlanCd( String	slanCd ) {
		this.slanCd =	slanCd;
	}
 
	/**
	 * Column Info
	 * @return	slanCd
	 */
	 public	 String	getSlanCd() {
		 return	this.slanCd;
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
	 public	 String	getBkgStsCd() {
		 return	this.bkgStsCd;
	 } 
 	/**
	* Column Info
	* @param  rcvTermCd
	*/
	public void	setRcvTermCd( String	rcvTermCd ) {
		this.rcvTermCd =	rcvTermCd;
	}
 
	/**
	 * Column Info
	 * @return	rcvTermCd
	 */
	 public	 String	getRcvTermCd() {
		 return	this.rcvTermCd;
	 } 
 	/**
	* Column Info
	* @param  deTermCd
	*/
	public void	setDeTermCd( String	deTermCd ) {
		this.deTermCd =	deTermCd;
	}
 
	/**
	 * Column Info
	 * @return	deTermCd
	 */
	 public	 String	getDeTermCd() {
		 return	this.deTermCd;
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
	* @param  oscaBkgFlg
	*/
	public void	setOscaBkgFlg( String	oscaBkgFlg ) {
		this.oscaBkgFlg =	oscaBkgFlg;
	}
 
	/**
	 * Column Info
	 * @return	oscaBkgFlg
	 */
	 public	 String	getOscaBkgFlg() {
		 return	this.oscaBkgFlg;
	 } 
 	/**
	* Column Info
	* @param  ediGateIoCd
	*/
	public void	setEdiGateIoCd( String	ediGateIoCd ) {
		this.ediGateIoCd =	ediGateIoCd;
	}
 
	/**
	 * Column Info
	 * @return	ediGateIoCd
	 */
	 public	 String	getEdiGateIoCd() {
		 return	this.ediGateIoCd;
	 } 
 	/**
	* Column Info
	* @param  fcntrFlg
	*/
	public void	setFcntrFlg( String	fcntrFlg ) {
		this.fcntrFlg =	fcntrFlg;
	}
 
	/**
	 * Column Info
	 * @return	fcntrFlg
	 */
	 public	 String	getFcntrFlg() {
		 return	this.fcntrFlg;
	 } 
 	/**
	* Column Info
	* @param  inpDt
	*/
	public void	setInpDt( String	inpDt ) {
		this.inpDt =	inpDt;
	}
 
	/**
	 * Column Info
	 * @return	inpDt
	 */
	 public	 String	getInpDt() {
		 return	this.inpDt;
	 } 
 	/**
	* Column Info
	* @param  mvmtEdiRmk
	*/
	public void	setMvmtEdiRmk( String	mvmtEdiRmk ) {
		this.mvmtEdiRmk =	mvmtEdiRmk;
	}
 
	/**
	 * Column Info
	 * @return	mvmtEdiRmk
	 */
	 public	 String	getMvmtEdiRmk() {
		 return	this.mvmtEdiRmk;
	 } 
 	/**
	* Column Info
	* @param  vvdCd
	*/
	public void	setVvdCd( String	vvdCd ) {
		this.vvdCd =	vvdCd;
	}
 
	/**
	 * Column Info
	 * @return	vvdCd
	 */
	 public	 String	getVvdCd() {
		 return	this.vvdCd;
	 } 
 	/**
	* Column Info
	* @param  rtyKnt
	*/
	public void	setRtyKnt( String	rtyKnt ) {
		this.rtyKnt =	rtyKnt;
	}
 
	/**
	 * Column Info
	 * @return	rtyKnt
	 */
	 public	 String	getRtyKnt() {
		 return	this.rtyKnt;
	 } 
 	/**
	* Column Info
	* @param  mvmtEdiSghtCd
	*/
	public void	setMvmtEdiSghtCd( String	mvmtEdiSghtCd ) {
		this.mvmtEdiSghtCd =	mvmtEdiSghtCd;
	}
 
	/**
	 * Column Info
	 * @return	mvmtEdiSghtCd
	 */
	 public	 String	getMvmtEdiSghtCd() {
		 return	this.mvmtEdiSghtCd;
	 } 
 	/**
	* Column Info
	* @param  status
	*/
	public void	setStatus( String	status ) {
		this.status =	status;
	}
 
	/**
	 * Column Info
	 * @return	status
	 */
	 public	 String	getStatus() {
		 return	this.status;
	 } 
 	/**
	* Column Info
	* @param  callSgnNo
	*/
	public void	setCallSgnNo( String	callSgnNo ) {
		this.callSgnNo =	callSgnNo;
	}
 
	/**
	 * Column Info
	 * @return	callSgnNo
	 */
	 public	 String	getCallSgnNo() {
		 return	this.callSgnNo;
	 } 
 	/**
	* Column Info
	* @param  cnmvEvntDt
	*/
	public void	setCnmvEvntDt( String	cnmvEvntDt ) {
		this.cnmvEvntDt =	cnmvEvntDt;
	}
 
	/**
	 * Column Info
	 * @return	cnmvEvntDt
	 */
	 public	 String	getCnmvEvntDt() {
		 return	this.cnmvEvntDt;
	 } 
 	/**
	* Column Info
	* @param  mvmtCreTpCd
	*/
	public void	setMvmtCreTpCd( String	mvmtCreTpCd ) {
		this.mvmtCreTpCd =	mvmtCreTpCd;
	}
 
	/**
	 * Column Info
	 * @return	mvmtCreTpCd
	 */
	 public	 String	getMvmtCreTpCd() {
		 return	this.mvmtCreTpCd;
	 } 
 	/**
	* Column Info
	* @param  orgYdCd
	*/
	public void	setOrgYdCd( String	orgYdCd ) {
		this.orgYdCd =	orgYdCd;
	}
 
	/**
	 * Column Info
	 * @return	orgYdCd
	 */
	 public	 String	getOrgYdCd() {
		 return	this.orgYdCd;
	 } 
 	/**
	* Column Info
	* @param  obCntrFlg
	*/
	public void	setObCntrFlg( String	obCntrFlg ) {
		this.obCntrFlg =	obCntrFlg;
	}
 
	/**
	 * Column Info
	 * @return	obCntrFlg
	 */
	 public	 String	getObCntrFlg() {
		 return	this.obCntrFlg;
	 } 
 	/**
	* Column Info
	* @param  mvmtStsCd
	*/
	public void	setMvmtStsCd( String	mvmtStsCd ) {
		this.mvmtStsCd =	mvmtStsCd;
	}
 
	/**
	 * Column Info
	 * @return	mvmtStsCd
	 */
	 public	 String	getMvmtStsCd() {
		 return	this.mvmtStsCd;
	 } 
 	/**
	* Column Info
	* @param  inpTpCd
	*/
	public void	setInpTpCd( String	inpTpCd ) {
		this.inpTpCd =	inpTpCd;
	}
 
	/**
	 * Column Info
	 * @return	inpTpCd
	 */
	 public	 String	getInpTpCd() {
		 return	this.inpTpCd;
	 } 
 	/**
	* Column Info
	* @param  refNo
	*/
	public void	setRefNo( String	refNo ) {
		this.refNo =	refNo;
	}
 
	/**
	 * Column Info
	 * @return	refNo
	 */
	 public	 String	getRefNo() {
		 return	this.refNo;
	 } 
 	/**
	* Column Info
	* @param  cntrFullStsCd
	*/
	public void	setCntrFullStsCd( String	cntrFullStsCd ) {
		this.cntrFullStsCd =	cntrFullStsCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrFullStsCd
	 */
	 public	 String	getCntrFullStsCd() {
		 return	this.cntrFullStsCd;
	 } 
 	/**
	* Column Info
	* @param  ediBkgNo
	*/
	public void	setEdiBkgNo( String	ediBkgNo ) {
		this.ediBkgNo =	ediBkgNo;
	}
 
	/**
	 * Column Info
	 * @return	ediBkgNo
	 */
	 public	 String	getEdiBkgNo() {
		 return	this.ediBkgNo;
	 } 
 	/**
	* Column Info
	* @param  cntrSealNo
	*/
	public void	setCntrSealNo( String	cntrSealNo ) {
		this.cntrSealNo =	cntrSealNo;
	}
 
	/**
	 * Column Info
	 * @return	cntrSealNo
	 */
	 public	 String	getCntrSealNo() {
		 return	this.cntrSealNo;
	 } 
 	/**
	* Column Info
	* @param  cntrErrCnt
	*/
	public void	setCntrErrCnt( String	cntrErrCnt ) {
		this.cntrErrCnt =	cntrErrCnt;
	}
 
	/**
	 * Column Info
	 * @return	cntrErrCnt
	 */
	 public	 String	getCntrErrCnt() {
		 return	this.cntrErrCnt;
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
	* @param  bkgKnt
	*/
	public void	setBkgKnt( String	bkgKnt ) {
		this.bkgKnt =	bkgKnt;
	}
 
	/**
	 * Column Info
	 * @return	bkgKnt
	 */
	 public	 String	getBkgKnt() {
		 return	this.bkgKnt;
	 } 
 	/**
	* Column Info
	* @param  cntrDmgFlg
	*/
	public void	setCntrDmgFlg( String	cntrDmgFlg ) {
		this.cntrDmgFlg =	cntrDmgFlg;
	}
 
	/**
	 * Column Info
	 * @return	cntrDmgFlg
	 */
	 public	 String	getCntrDmgFlg() {
		 return	this.cntrDmgFlg;
	 } 
 	/**
	* Column Info
	* @param  chssNo
	*/
	public void	setChssNo( String	chssNo ) {
		this.chssNo =	chssNo;
	}
 
	/**
	 * Column Info
	 * @return	chssNo
	 */
	 public	 String	getChssNo() {
		 return	this.chssNo;
	 } 
 	/**
	* Column Info
	* @param  mgstNo
	*/
	public void	setMgstNo( String	mgstNo ) {
		this.mgstNo =	mgstNo;
	}
 
	/**
	 * Column Info
	 * @return	mgstNo
	 */
	 public	 String	getMgstNo() {
		 return	this.mgstNo;
	 } 
 	/**
	* Column Info
	* @param  destYdCd
	*/
	public void	setDestYdCd( String	destYdCd ) {
		this.destYdCd =	destYdCd;
	}
 
	/**
	 * Column Info
	 * @return	destYdCd
	 */
	 public	 String	getDestYdCd() {
		 return	this.destYdCd;
	 } 
 	/**
	* Column Info
	* @param  lloydNo
	*/
	public void	setLloydNo( String	lloydNo ) {
		this.lloydNo =	lloydNo;
	}
 
	/**
	 * Column Info
	 * @return	lloydNo
	 */
	 public	 String	getLloydNo() {
		 return	this.lloydNo;
	 } 
 	/**
	* Column Info
	* @param  woNo
	*/
	public void	setWoNo( String	woNo ) {
		this.woNo =	woNo;
	}
 
	/**
	 * Column Info
	 * @return	woNo
	 */
	 public	 String	getWoNo() {
		 return	this.woNo;
	 } 
 	/**
	* Column Info
	* @param  ediVvdCd
	*/
	public void	setEdiVvdCd( String	ediVvdCd ) {
		this.ediVvdCd =	ediVvdCd;
	}
 
	/**
	 * Column Info
	 * @return	ediVvdCd
	 */
	 public	 String	getEdiVvdCd() {
		 return	this.ediVvdCd;
	 } 
 	/**
	* Column Info
	* @param  tirNo
	*/
	public void	setTirNo( String	tirNo ) {
		this.tirNo =	tirNo;
	}
 
	/**
	 * Column Info
	 * @return	tirNo
	 */
	 public	 String	getTirNo() {
		 return	this.tirNo;
	 } 
 	/**
	* Column Info
	* @param  mtyPlnNo
	*/
	public void	setMtyPlnNo( String	mtyPlnNo ) {
		this.mtyPlnNo =	mtyPlnNo;
	}
 
	/**
	 * Column Info
	 * @return	mtyPlnNo
	 */
	 public	 String	getMtyPlnNo() {
		 return	this.mtyPlnNo;
	 } 
 	/**
	* Column Info
	* @param  mtyRepoNo
	*/
	public void	setMtyRepoNo( String	mtyRepoNo ) {
		this.mtyRepoNo =	mtyRepoNo;
	}
 
	/**
	 * Column Info
	 * @return	mtyRepoNo
	 */
	 public	 String	getMtyRepoNo() {
		 return	this.mtyRepoNo;
	 } 
 	/**
	* Column Info
	* @param  ediCrrNo
	*/
	public void	setEdiCrrNo( String	ediCrrNo ) {
		this.ediCrrNo =	ediCrrNo;
	}
 
	/**
	 * Column Info
	 * @return	ediCrrNo
	 */
	 public	 String	getEdiCrrNo() {
		 return	this.ediCrrNo;
	 } 
 	/**
	* Column Info
	* @param  trspDocNo
	*/
	public void	setTrspDocNo( String	trspDocNo ) {
		this.trspDocNo =	trspDocNo;
	}
 
	/**
	 * Column Info
	 * @return	trspDocNo
	 */
	 public	 String	getTrspDocNo() {
		 return	this.trspDocNo;
	 } 
 	/**
	* Column Info
	* @param  crntVslCd
	*/
	public void	setCrntVslCd( String	crntVslCd ) {
		this.crntVslCd =	crntVslCd;
	}
 
	/**
	 * Column Info
	 * @return	crntVslCd
	 */
	 public	 String	getCrntVslCd() {
		 return	this.crntVslCd;
	 } 
 	/**
	* Column Info
	* @param  crntSkdVoyNo
	*/
	public void	setCrntSkdVoyNo( String	crntSkdVoyNo ) {
		this.crntSkdVoyNo =	crntSkdVoyNo;
	}
 
	/**
	 * Column Info
	 * @return	crntSkdVoyNo
	 */
	 public	 String	getCrntSkdVoyNo() {
		 return	this.crntSkdVoyNo;
	 } 
 	/**
	* Column Info
	* @param  crntSkdDirCd
	*/
	public void	setCrntSkdDirCd( String	crntSkdDirCd ) {
		this.crntSkdDirCd =	crntSkdDirCd;
	}
 
	/**
	 * Column Info
	 * @return	crntSkdDirCd
	 */
	 public	 String	getCrntSkdDirCd() {
		 return	this.crntSkdDirCd;
	 } 
 	/**
	* Column Info
	* @param  cnmvRmk
	*/
	public void	setCnmvRmk( String	cnmvRmk ) {
		this.cnmvRmk =	cnmvRmk;
	}
 
	/**
	 * Column Info
	 * @return	cnmvRmk
	 */
	 public	 String	getCnmvRmk() {
		 return	this.cnmvRmk;
	 } 
 	/**
	* Column Info
	* @param  mvmtEdiMsgAreaCd
	*/
	public void	setMvmtEdiMsgAreaCd( String	mvmtEdiMsgAreaCd ) {
		this.mvmtEdiMsgAreaCd =	mvmtEdiMsgAreaCd;
	}
 
	/**
	 * Column Info
	 * @return	mvmtEdiMsgAreaCd
	 */
	 public	 String	getMvmtEdiMsgAreaCd() {
		 return	this.mvmtEdiMsgAreaCd;
	 } 
 	/**
	* Column Info
	* @param  mvmtEdiMsgSeq
	*/
	public void	setMvmtEdiMsgSeq( String	mvmtEdiMsgSeq ) {
		this.mvmtEdiMsgSeq =	mvmtEdiMsgSeq;
	}
 
	/**
	 * Column Info
	 * @return	mvmtEdiMsgSeq
	 */
	 public	 String	getMvmtEdiMsgSeq() {
		 return	this.mvmtEdiMsgSeq;
	 } 
 	/**
	* Column Info
	* @param  mvmtEdiMsgTpId
	*/
	public void	setMvmtEdiMsgTpId( String	mvmtEdiMsgTpId ) {
		this.mvmtEdiMsgTpId =	mvmtEdiMsgTpId;
	}
 
	/**
	 * Column Info
	 * @return	mvmtEdiMsgTpId
	 */
	 public	 String	getMvmtEdiMsgTpId() {
		 return	this.mvmtEdiMsgTpId;
	 } 
 	/**
	* Column Info
	* @param  mvmtEdiMsgYrmondy
	*/
	public void	setMvmtEdiMsgYrmondy( String	mvmtEdiMsgYrmondy ) {
		this.mvmtEdiMsgYrmondy =	mvmtEdiMsgYrmondy;
	}
 
	/**
	 * Column Info
	 * @return	mvmtEdiMsgYrmondy
	 */
	 public	 String	getMvmtEdiMsgYrmondy() {
		 return	this.mvmtEdiMsgYrmondy;
	 } 
 	/**
	* Column Info
	* @param  mvmtEdiTpCd
	*/
	public void	setMvmtEdiTpCd( String	mvmtEdiTpCd ) {
		this.mvmtEdiTpCd =	mvmtEdiTpCd;
	}
 
	/**
	 * Column Info
	 * @return	mvmtEdiTpCd
	 */
	 public	 String	getMvmtEdiTpCd() {
		 return	this.mvmtEdiTpCd;
	 } 
 	/**
	* Column Info
	* @param  mvmtTrspModCd
	*/
	public void	setMvmtTrspModCd( String	mvmtTrspModCd ) {
		this.mvmtTrspModCd =	mvmtTrspModCd;
	}
 
	/**
	 * Column Info
	 * @return	mvmtTrspModCd
	 */
	 public	 String	getMvmtTrspModCd() {
		 return	this.mvmtTrspModCd;
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
	 public	 String	getOfcCd() {
		 return	this.ofcCd;
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
	* @param  chkFlg
	*/
	public void	setChkFlg( String	chkFlg ) {
		this.chkFlg =	chkFlg;
	}
 
	/**
	 * Column Info
	 * @return	chkFlg
	 */
	 public	 String	getChkFlg() {
		 return	this.chkFlg;
	 } 
 	/**
	* Column Info
	* @param  hCntrStsCd
	*/
	public void	setHCntrStsCd( String	hCntrStsCd ) {
		this.hCntrStsCd =	hCntrStsCd;
	}
 
	/**
	 * Column Info
	 * @return	hCntrStsCd
	 */
	 public	 String	getHCntrStsCd() {
		 return	this.hCntrStsCd;
	 } 
 	/**
	* Column Info
	* @param  hOnhYdCd
	*/
	public void	setHOnhYdCd( String	hOnhYdCd ) {
		this.hOnhYdCd =	hOnhYdCd;
	}
 
	/**
	 * Column Info
	 * @return	hOnhYdCd
	 */
	 public	 String	getHOnhYdCd() {
		 return	this.hOnhYdCd;
	 } 
 	/**
	* Column Info
	* @param  hCnmvEvntDt
	*/
	public void	setHCnmvEvntDt( String	hCnmvEvntDt ) {
		this.hCnmvEvntDt =	hCnmvEvntDt;
	}
 
	/**
	 * Column Info
	 * @return	hCnmvEvntDt
	 */
	 public	 String	getHCnmvEvntDt() {
		 return	this.hCnmvEvntDt;
	 } 
 	/**
	* Column Info
	* @param  hChk1
	*/
	public void	setHChk1( String	hChk1 ) {
		this.hChk1 =	hChk1;
	}
 
	/**
	 * Column Info
	 * @return	hChk1
	 */
	 public	 String	getHChk1() {
		 return	this.hChk1;
	 } 
 	/**
	* Column Info
	* @param  hChk2
	*/
	public void	setHChk2( String	hChk2 ) {
		this.hChk2 =	hChk2;
	}
 
	/**
	 * Column Info
	 * @return	hChk2
	 */
	 public	 String	getHChk2() {
		 return	this.hChk2;
	 } 
 	/**
	* Column Info
	* @param  hChk3
	*/
	public void	setHChk3( String	hChk3 ) {
		this.hChk3 =	hChk3;
	}
 
	/**
	 * Column Info
	 * @return	hChk3
	 */
	 public	 String	getHChk3() {
		 return	this.hChk3;
	 } 
 	/**
	* Column Info
	* @param  cnmvCycNoChg
	*/
	public void	setCnmvCycNoChg( String	cnmvCycNoChg ) {
		this.cnmvCycNoChg =	cnmvCycNoChg;
	}
 
	/**
	 * Column Info
	 * @return	cnmvCycNoChg
	 */
	 public	 String	getCnmvCycNoChg() {
		 return	this.cnmvCycNoChg;
	 } 
 	/**
	* Column Info
	* @param  tvvd
	*/
	public void	setTvvd( String	tvvd ) {
		this.tvvd =	tvvd;
	}
 
	/**
	 * Column Info
	 * @return	tvvd
	 */
	 public	 String	getTvvd() {
		 return	this.tvvd;
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
	 public	 String	getRowNum() {
		 return	this.rowNum;
	 } 
 	/**
	* Column Info
	* @param  usrNm
	*/
	public void	setUsrNm( String	usrNm ) {
		this.usrNm =	usrNm;
	}
 
	/**
	 * Column Info
	 * @return	usrNm
	 */
	 public	 String	getUsrNm() {
		 return	this.usrNm;
	 } 
 	/**
	* Column Info
	* @param  cnmvYr
	*/
	public void	setCnmvYr( String	cnmvYr ) {
		this.cnmvYr =	cnmvYr;
	}
 
	/**
	 * Column Info
	 * @return	cnmvYr
	 */
	 public	 String	getCnmvYr() {
		 return	this.cnmvYr;
	 } 
 	/**
	* Column Info
	* @param  cnmvSeq
	*/
	public void	setCnmvSeq( String	cnmvSeq ) {
		this.cnmvSeq =	cnmvSeq;
	}
 
	/**
	 * Column Info
	 * @return	cnmvSeq
	 */
	 public	 String	getCnmvSeq() {
		 return	this.cnmvSeq;
	 } 
 	/**
	* Column Info
	* @param  cnmvSplitNo
	*/
	public void	setCnmvSplitNo( String	cnmvSplitNo ) {
		this.cnmvSplitNo =	cnmvSplitNo;
	}
 
	/**
	 * Column Info
	 * @return	cnmvSplitNo
	 */
	 public	 String	getCnmvSplitNo() {
		 return	this.cnmvSplitNo;
	 } 
 	/**
	* Column Info
	* @param  cnmvIdNo
	*/
	public void	setCnmvIdNo( String	cnmvIdNo ) {
		this.cnmvIdNo =	cnmvIdNo;
	}
 
	/**
	 * Column Info
	 * @return	cnmvIdNo
	 */
	 public	 String	getCnmvIdNo() {
		 return	this.cnmvIdNo;
	 } 
 	/**
	* Column Info
	* @param  sEventDate1
	*/
	public void	setSEventDate1( String	sEventDate1 ) {
		this.sEventDate1 =	sEventDate1;
	}
 
	/**
	 * Column Info
	 * @return	sEventDate1
	 */
	 public	 String	getSEventDate1() {
		 return	this.sEventDate1;
	 } 
 	/**
	* Column Info
	* @param  sEventDate2
	*/
	public void	setSEventDate2( String	sEventDate2 ) {
		this.sEventDate2 =	sEventDate2;
	}
 
	/**
	 * Column Info
	 * @return	sEventDate2
	 */
	 public	 String	getSEventDate2() {
		 return	this.sEventDate2;
	 } 
	 
	 /**
	* Column Info
	* @param  polEtdDt
	*/
	public void	setPolEtdDt( String	polEtdDt ) {
		this.polEtdDt =	polEtdDt;
	}
 
	/**
	 * Column Info
	 * @return	polEtdDt
	 */
	 public	 String	getPolEtdDt() {
		 return	this.polEtdDt;
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
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setPorCd(JSPUtil.getParameter(request,	prefix + "por_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request,	prefix + "bkg_cgo_tp_cd", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCnmvCycNo(JSPUtil.getParameter(request,	prefix + "cnmv_cyc_no", ""));
		setDelCd(JSPUtil.getParameter(request,	prefix + "del_cd", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setSCntrNo(JSPUtil.getParameter(request,	prefix + "s_cntr_no", ""));
		setSBkgNo(JSPUtil.getParameter(request,	prefix + "s_bkg_no", ""));
		setHBkgNo(JSPUtil.getParameter(request,	prefix + "h_bkg_no", ""));
		setHCntrNo(JSPUtil.getParameter(request,	prefix + "h_cntr_no", ""));
		setVslOscaUpdDt(JSPUtil.getParameter(request,	prefix + "vsl_osca_upd_dt", ""));
		setVslVvd(JSPUtil.getParameter(request,	prefix + "vsl_vvd", ""));
		setVslEtb(JSPUtil.getParameter(request,	prefix + "vsl_etb", ""));
		setVslOscaCreDt(JSPUtil.getParameter(request,	prefix + "vsl_osca_cre_dt", ""));
		setVslEtd(JSPUtil.getParameter(request,	prefix + "vsl_etd", ""));
		setVslPodYdCd(JSPUtil.getParameter(request,	prefix + "vsl_pod_yd_cd", ""));
		setVslPrePstCd(JSPUtil.getParameter(request,	prefix + "vsl_pre_pst_cd", ""));
		setVslSlanCd(JSPUtil.getParameter(request,	prefix + "vsl_slan_cd", ""));
		setVslPolYdCd(JSPUtil.getParameter(request,	prefix + "vsl_pol_yd_cd", ""));
		setCntrAgmtSeq(JSPUtil.getParameter(request,	prefix + "cntr_agmt_seq", ""));
		setCntrDeTermCd(JSPUtil.getParameter(request,	prefix + "cntr_de_term_cd", ""));
		setCntrCnmvStsCd(JSPUtil.getParameter(request,	prefix + "cntr_cnmv_sts_cd", ""));
		setCntrStsCd(JSPUtil.getParameter(request,	prefix + "cntr_sts_cd", ""));
		setCntrRowSeq(JSPUtil.getParameter(request,	prefix + "cntr_row_seq", ""));
		setCntrMinOnhDys(JSPUtil.getParameter(request,	prefix + "cntr_min_onh_dys", ""));
		setCntrRdCgoFlg(JSPUtil.getParameter(request,	prefix + "cntr_rd_cgo_flg", ""));
		setCntrRcvTermCd(JSPUtil.getParameter(request,	prefix + "cntr_rcv_term_cd", ""));
		setCntrAgmtCtyCd(JSPUtil.getParameter(request,	prefix + "cntr_agmt_cty_cd", ""));
		setCntrAwkCgoFlg(JSPUtil.getParameter(request,	prefix + "cntr_awk_cgo_flg", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setCntrCrntYdCd(JSPUtil.getParameter(request,	prefix + "cntr_crnt_yd_cd", ""));
		setCntrDcgoFlg(JSPUtil.getParameter(request,	prefix + "cntr_dcgo_flg", ""));
		setCntrOnhYdCd(JSPUtil.getParameter(request,	prefix + "cntr_onh_yd_cd", ""));
		setCntrRefNo(JSPUtil.getParameter(request,	prefix + "cntr_ref_no", ""));
		setCntrCfmFlg(JSPUtil.getParameter(request,	prefix + "cntr_cfm_flg", ""));
		setCntrOnhDt(JSPUtil.getParameter(request,	prefix + "cntr_onh_dt", ""));
		setCntrVndrAbbrNm(JSPUtil.getParameter(request,	prefix + "cntr_vndr_abbr_nm", ""));
		setCntrUsedDys(JSPUtil.getParameter(request,	prefix + "cntr_used_dys", ""));
		setCntrCnmvDt(JSPUtil.getParameter(request,	prefix + "cntr_cnmv_dt", ""));
		setCntrRcFlg(JSPUtil.getParameter(request,	prefix + "cntr_rc_flg", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setCntrVolQty(JSPUtil.getParameter(request,	prefix + "cntr_vol_qty", ""));
		setCntrCnmvCycNo(JSPUtil.getParameter(request,	prefix + "cntr_cnmv_cyc_no", ""));
		setCntrOnhFreeDys(JSPUtil.getParameter(request,	prefix + "cntr_onh_free_dys", ""));
		setCntrVndrSeq(JSPUtil.getParameter(request,	prefix + "cntr_vndr_seq", ""));
		setCntrLstmCd(JSPUtil.getParameter(request,	prefix + "cntr_lstm_cd", ""));
		setCntrBbCgoFlg(JSPUtil.getParameter(request,	prefix + "cntr_bb_cgo_flg", ""));
		setPCntrno(JSPUtil.getParameter(request,	prefix + "p_cntrno", ""));
		setCheckDigit(JSPUtil.getParameter(request,	prefix + "check_digit", ""));
		setPDate1(JSPUtil.getParameter(request,	prefix + "p_date1", ""));
		setPDate2(JSPUtil.getParameter(request,	prefix + "p_date2", ""));
		setAppCd(JSPUtil.getParameter(request,	prefix + "app_cd", ""));
		setSlanCd(JSPUtil.getParameter(request,	prefix + "slan_cd", ""));
		setBkgStsCd(JSPUtil.getParameter(request,	prefix + "bkg_sts_cd", ""));
		setRcvTermCd(JSPUtil.getParameter(request,	prefix + "rcv_term_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request,	prefix + "de_term_cd", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setOscaBkgFlg(JSPUtil.getParameter(request,	prefix + "osca_bkg_flg", ""));
		setEdiGateIoCd(JSPUtil.getParameter(request,	prefix + "edi_gate_io_cd", ""));
		setFcntrFlg(JSPUtil.getParameter(request,	prefix + "fcntr_flg", ""));
		setInpDt(JSPUtil.getParameter(request,	prefix + "inp_dt", ""));
		setMvmtEdiRmk(JSPUtil.getParameter(request,	prefix + "mvmt_edi_rmk", ""));
		setVvdCd(JSPUtil.getParameter(request,	prefix + "vvd_cd", ""));
		setRtyKnt(JSPUtil.getParameter(request,	prefix + "rty_knt", ""));
		setMvmtEdiSghtCd(JSPUtil.getParameter(request,	prefix + "mvmt_edi_sght_cd", ""));
		setStatus(JSPUtil.getParameter(request,	prefix + "status", ""));
		setCallSgnNo(JSPUtil.getParameter(request,	prefix + "call_sgn_no", ""));
		setCnmvEvntDt(JSPUtil.getParameter(request,	prefix + "cnmv_evnt_dt", ""));
		setMvmtCreTpCd(JSPUtil.getParameter(request,	prefix + "mvmt_cre_tp_cd", ""));
		setOrgYdCd(JSPUtil.getParameter(request,	prefix + "org_yd_cd", ""));
		setObCntrFlg(JSPUtil.getParameter(request,	prefix + "ob_cntr_flg", ""));
		setMvmtStsCd(JSPUtil.getParameter(request,	prefix + "mvmt_sts_cd", ""));
		setInpTpCd(JSPUtil.getParameter(request,	prefix + "inp_tp_cd", ""));
		setRefNo(JSPUtil.getParameter(request,	prefix + "ref_no", ""));
		setCntrFullStsCd(JSPUtil.getParameter(request,	prefix + "cntr_full_sts_cd", ""));
		setEdiBkgNo(JSPUtil.getParameter(request,	prefix + "edi_bkg_no", ""));
		setCntrSealNo(JSPUtil.getParameter(request,	prefix + "cntr_seal_no", ""));
		setCntrErrCnt(JSPUtil.getParameter(request,	prefix + "cntr_err_cnt", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setBkgKnt(JSPUtil.getParameter(request,	prefix + "bkg_knt", ""));
		setCntrDmgFlg(JSPUtil.getParameter(request,	prefix + "cntr_dmg_flg", ""));
		setChssNo(JSPUtil.getParameter(request,	prefix + "chss_no", ""));
		setMgstNo(JSPUtil.getParameter(request,	prefix + "mgst_no", ""));
		setDestYdCd(JSPUtil.getParameter(request,	prefix + "dest_yd_cd", ""));
		setLloydNo(JSPUtil.getParameter(request,	prefix + "lloyd_no", ""));
		setWoNo(JSPUtil.getParameter(request,	prefix + "wo_no", ""));
		setEdiVvdCd(JSPUtil.getParameter(request,	prefix + "edi_vvd_cd", ""));
		setTirNo(JSPUtil.getParameter(request,	prefix + "tir_no", ""));
		setMtyPlnNo(JSPUtil.getParameter(request,	prefix + "mty_pln_no", ""));
		setMtyRepoNo(JSPUtil.getParameter(request,	prefix + "mty_repo_no", ""));
		setEdiCrrNo(JSPUtil.getParameter(request,	prefix + "edi_crr_no", ""));
		setTrspDocNo(JSPUtil.getParameter(request,	prefix + "trsp_doc_no", ""));
		setCrntVslCd(JSPUtil.getParameter(request,	prefix + "crnt_vsl_cd", ""));
		setCrntSkdVoyNo(JSPUtil.getParameter(request,	prefix + "crnt_skd_voy_no", ""));
		setCrntSkdDirCd(JSPUtil.getParameter(request,	prefix + "crnt_skd_dir_cd", ""));
		setCnmvRmk(JSPUtil.getParameter(request,	prefix + "cnmv_rmk", ""));
		setMvmtEdiMsgAreaCd(JSPUtil.getParameter(request,	prefix + "mvmt_edi_msg_area_cd", ""));
		setMvmtEdiMsgSeq(JSPUtil.getParameter(request,	prefix + "mvmt_edi_msg_seq", ""));
		setMvmtEdiMsgTpId(JSPUtil.getParameter(request,	prefix + "mvmt_edi_msg_tp_id", ""));
		setMvmtEdiMsgYrmondy(JSPUtil.getParameter(request,	prefix + "mvmt_edi_msg_yrmondy", ""));
		setMvmtEdiTpCd(JSPUtil.getParameter(request,	prefix + "mvmt_edi_tp_cd", ""));
		setMvmtTrspModCd(JSPUtil.getParameter(request,	prefix + "mvmt_trsp_mod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setChkFlg(JSPUtil.getParameter(request,	prefix + "chk_flg", ""));
		setHCntrStsCd(JSPUtil.getParameter(request,	prefix + "h_cntr_sts_cd", ""));
		setHOnhYdCd(JSPUtil.getParameter(request,	prefix + "h_onh_yd_cd", ""));
		setHCnmvEvntDt(JSPUtil.getParameter(request,	prefix + "h_cnmv_evnt_dt", ""));
		setHChk1(JSPUtil.getParameter(request,	prefix + "h_chk1", ""));
		setHChk2(JSPUtil.getParameter(request,	prefix + "h_chk2", ""));
		setHChk3(JSPUtil.getParameter(request,	prefix + "h_chk3", ""));
		setCnmvCycNoChg(JSPUtil.getParameter(request,	prefix + "cnmv_cyc_no_chg", ""));
		setTvvd(JSPUtil.getParameter(request,	prefix + "tvvd", ""));
		setRowNum(JSPUtil.getParameter(request,	prefix + "row_num", ""));
		setUsrNm(JSPUtil.getParameter(request,	prefix + "usr_nm", ""));
		setCnmvYr(JSPUtil.getParameter(request,	prefix + "cnmv_yr", ""));
		setCnmvSeq(JSPUtil.getParameter(request,	prefix + "cnmv_seq", ""));
		setCnmvSplitNo(JSPUtil.getParameter(request,	prefix + "cnmv_split_no", ""));
		setCnmvIdNo(JSPUtil.getParameter(request,	prefix + "cnmv_id_no", ""));
		setSEventDate1(JSPUtil.getParameter(request,	prefix + "s_event_date1", ""));
		setSEventDate2(JSPUtil.getParameter(request,	prefix + "s_event_date2", ""));
		setPolEtdDt(JSPUtil.getParameter(request,	prefix + "pol_etd_dt", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OscarBookingSearchVO[]
	 */
	public OscarBookingSearchVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	  * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return OscarBookingSearchVO[]
	 */
	public OscarBookingSearchVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		OscarBookingSearchVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd".trim(),	length));
				String[] porCd =	(JSPUtil.getParameter(request, prefix +	"por_cd".trim(),	length));
				String[] bkgCgoTpCd =	(JSPUtil.getParameter(request, prefix +	"bkg_cgo_tp_cd".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] cnmvCycNo =	(JSPUtil.getParameter(request, prefix +	"cnmv_cyc_no".trim(),	length));
				String[] delCd =	(JSPUtil.getParameter(request, prefix +	"del_cd".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] sCntrNo =	(JSPUtil.getParameter(request, prefix +	"s_cntr_no".trim(),	length));
				String[] sBkgNo =	(JSPUtil.getParameter(request, prefix +	"s_bkg_no".trim(),	length));
				String[] hBkgNo =	(JSPUtil.getParameter(request, prefix +	"h_bkg_no".trim(),	length));
				String[] hCntrNo =	(JSPUtil.getParameter(request, prefix +	"h_cntr_no".trim(),	length));
				String[] vslOscaUpdDt =	(JSPUtil.getParameter(request, prefix +	"vsl_osca_upd_dt".trim(),	length));
				String[] vslVvd =	(JSPUtil.getParameter(request, prefix +	"vsl_vvd".trim(),	length));
				String[] vslEtb =	(JSPUtil.getParameter(request, prefix +	"vsl_etb".trim(),	length));
				String[] vslOscaCreDt =	(JSPUtil.getParameter(request, prefix +	"vsl_osca_cre_dt".trim(),	length));
				String[] vslEtd =	(JSPUtil.getParameter(request, prefix +	"vsl_etd".trim(),	length));
				String[] vslPodYdCd =	(JSPUtil.getParameter(request, prefix +	"vsl_pod_yd_cd".trim(),	length));
				String[] vslPrePstCd =	(JSPUtil.getParameter(request, prefix +	"vsl_pre_pst_cd".trim(),	length));
				String[] vslSlanCd =	(JSPUtil.getParameter(request, prefix +	"vsl_slan_cd".trim(),	length));
				String[] vslPolYdCd =	(JSPUtil.getParameter(request, prefix +	"vsl_pol_yd_cd".trim(),	length));
				String[] cntrAgmtSeq =	(JSPUtil.getParameter(request, prefix +	"cntr_agmt_seq".trim(),	length));
				String[] cntrDeTermCd =	(JSPUtil.getParameter(request, prefix +	"cntr_de_term_cd".trim(),	length));
				String[] cntrCnmvStsCd =	(JSPUtil.getParameter(request, prefix +	"cntr_cnmv_sts_cd".trim(),	length));
				String[] cntrStsCd =	(JSPUtil.getParameter(request, prefix +	"cntr_sts_cd".trim(),	length));
				String[] cntrRowSeq =	(JSPUtil.getParameter(request, prefix +	"cntr_row_seq".trim(),	length));
				String[] cntrMinOnhDys =	(JSPUtil.getParameter(request, prefix +	"cntr_min_onh_dys".trim(),	length));
				String[] cntrRdCgoFlg =	(JSPUtil.getParameter(request, prefix +	"cntr_rd_cgo_flg".trim(),	length));
				String[] cntrRcvTermCd =	(JSPUtil.getParameter(request, prefix +	"cntr_rcv_term_cd".trim(),	length));
				String[] cntrAgmtCtyCd =	(JSPUtil.getParameter(request, prefix +	"cntr_agmt_cty_cd".trim(),	length));
				String[] cntrAwkCgoFlg =	(JSPUtil.getParameter(request, prefix +	"cntr_awk_cgo_flg".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] cntrCrntYdCd =	(JSPUtil.getParameter(request, prefix +	"cntr_crnt_yd_cd".trim(),	length));
				String[] cntrDcgoFlg =	(JSPUtil.getParameter(request, prefix +	"cntr_dcgo_flg".trim(),	length));
				String[] cntrOnhYdCd =	(JSPUtil.getParameter(request, prefix +	"cntr_onh_yd_cd".trim(),	length));
				String[] cntrRefNo =	(JSPUtil.getParameter(request, prefix +	"cntr_ref_no".trim(),	length));
				String[] cntrCfmFlg =	(JSPUtil.getParameter(request, prefix +	"cntr_cfm_flg".trim(),	length));
				String[] cntrOnhDt =	(JSPUtil.getParameter(request, prefix +	"cntr_onh_dt".trim(),	length));
				String[] cntrVndrAbbrNm =	(JSPUtil.getParameter(request, prefix +	"cntr_vndr_abbr_nm".trim(),	length));
				String[] cntrUsedDys =	(JSPUtil.getParameter(request, prefix +	"cntr_used_dys".trim(),	length));
				String[] cntrCnmvDt =	(JSPUtil.getParameter(request, prefix +	"cntr_cnmv_dt".trim(),	length));
				String[] cntrRcFlg =	(JSPUtil.getParameter(request, prefix +	"cntr_rc_flg".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] cntrVolQty =	(JSPUtil.getParameter(request, prefix +	"cntr_vol_qty".trim(),	length));
				String[] cntrCnmvCycNo =	(JSPUtil.getParameter(request, prefix +	"cntr_cnmv_cyc_no".trim(),	length));
				String[] cntrOnhFreeDys =	(JSPUtil.getParameter(request, prefix +	"cntr_onh_free_dys".trim(),	length));
				String[] cntrVndrSeq =	(JSPUtil.getParameter(request, prefix +	"cntr_vndr_seq".trim(),	length));
				String[] cntrLstmCd =	(JSPUtil.getParameter(request, prefix +	"cntr_lstm_cd".trim(),	length));
				String[] cntrBbCgoFlg =	(JSPUtil.getParameter(request, prefix +	"cntr_bb_cgo_flg".trim(),	length));
				String[] pCntrno =	(JSPUtil.getParameter(request, prefix +	"p_cntrno".trim(),	length));
				String[] checkDigit =	(JSPUtil.getParameter(request, prefix +	"check_digit".trim(),	length));
				String[] pDate1 =	(JSPUtil.getParameter(request, prefix +	"p_date1".trim(),	length));
				String[] pDate2 =	(JSPUtil.getParameter(request, prefix +	"p_date2".trim(),	length));
				String[] appCd =	(JSPUtil.getParameter(request, prefix +	"app_cd".trim(),	length));
				String[] slanCd =	(JSPUtil.getParameter(request, prefix +	"slan_cd".trim(),	length));
				String[] bkgStsCd =	(JSPUtil.getParameter(request, prefix +	"bkg_sts_cd".trim(),	length));
				String[] rcvTermCd =	(JSPUtil.getParameter(request, prefix +	"rcv_term_cd".trim(),	length));
				String[] deTermCd =	(JSPUtil.getParameter(request, prefix +	"de_term_cd".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] oscaBkgFlg =	(JSPUtil.getParameter(request, prefix +	"osca_bkg_flg".trim(),	length));
				String[] ediGateIoCd =	(JSPUtil.getParameter(request, prefix +	"edi_gate_io_cd".trim(),	length));
				String[] fcntrFlg =	(JSPUtil.getParameter(request, prefix +	"fcntr_flg".trim(),	length));
				String[] inpDt =	(JSPUtil.getParameter(request, prefix +	"inp_dt".trim(),	length));
				String[] mvmtEdiRmk =	(JSPUtil.getParameter(request, prefix +	"mvmt_edi_rmk".trim(),	length));
				String[] vvdCd =	(JSPUtil.getParameter(request, prefix +	"vvd_cd".trim(),	length));
				String[] rtyKnt =	(JSPUtil.getParameter(request, prefix +	"rty_knt".trim(),	length));
				String[] mvmtEdiSghtCd =	(JSPUtil.getParameter(request, prefix +	"mvmt_edi_sght_cd".trim(),	length));
				String[] status =	(JSPUtil.getParameter(request, prefix +	"status".trim(),	length));
				String[] callSgnNo =	(JSPUtil.getParameter(request, prefix +	"call_sgn_no".trim(),	length));
				String[] cnmvEvntDt =	(JSPUtil.getParameter(request, prefix +	"cnmv_evnt_dt".trim(),	length));
				String[] mvmtCreTpCd =	(JSPUtil.getParameter(request, prefix +	"mvmt_cre_tp_cd".trim(),	length));
				String[] orgYdCd =	(JSPUtil.getParameter(request, prefix +	"org_yd_cd".trim(),	length));
				String[] obCntrFlg =	(JSPUtil.getParameter(request, prefix +	"ob_cntr_flg".trim(),	length));
				String[] mvmtStsCd =	(JSPUtil.getParameter(request, prefix +	"mvmt_sts_cd".trim(),	length));
				String[] inpTpCd =	(JSPUtil.getParameter(request, prefix +	"inp_tp_cd".trim(),	length));
				String[] refNo =	(JSPUtil.getParameter(request, prefix +	"ref_no".trim(),	length));
				String[] cntrFullStsCd =	(JSPUtil.getParameter(request, prefix +	"cntr_full_sts_cd".trim(),	length));
				String[] ediBkgNo =	(JSPUtil.getParameter(request, prefix +	"edi_bkg_no".trim(),	length));
				String[] cntrSealNo =	(JSPUtil.getParameter(request, prefix +	"cntr_seal_no".trim(),	length));
				String[] cntrErrCnt =	(JSPUtil.getParameter(request, prefix +	"cntr_err_cnt".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] bkgKnt =	(JSPUtil.getParameter(request, prefix +	"bkg_knt".trim(),	length));
				String[] cntrDmgFlg =	(JSPUtil.getParameter(request, prefix +	"cntr_dmg_flg".trim(),	length));
				String[] chssNo =	(JSPUtil.getParameter(request, prefix +	"chss_no".trim(),	length));
				String[] mgstNo =	(JSPUtil.getParameter(request, prefix +	"mgst_no".trim(),	length));
				String[] destYdCd =	(JSPUtil.getParameter(request, prefix +	"dest_yd_cd".trim(),	length));
				String[] lloydNo =	(JSPUtil.getParameter(request, prefix +	"lloyd_no".trim(),	length));
				String[] woNo =	(JSPUtil.getParameter(request, prefix +	"wo_no".trim(),	length));
				String[] ediVvdCd =	(JSPUtil.getParameter(request, prefix +	"edi_vvd_cd".trim(),	length));
				String[] tirNo =	(JSPUtil.getParameter(request, prefix +	"tir_no".trim(),	length));
				String[] mtyPlnNo =	(JSPUtil.getParameter(request, prefix +	"mty_pln_no".trim(),	length));
				String[] mtyRepoNo =	(JSPUtil.getParameter(request, prefix +	"mty_repo_no".trim(),	length));
				String[] ediCrrNo =	(JSPUtil.getParameter(request, prefix +	"edi_crr_no".trim(),	length));
				String[] trspDocNo =	(JSPUtil.getParameter(request, prefix +	"trsp_doc_no".trim(),	length));
				String[] crntVslCd =	(JSPUtil.getParameter(request, prefix +	"crnt_vsl_cd".trim(),	length));
				String[] crntSkdVoyNo =	(JSPUtil.getParameter(request, prefix +	"crnt_skd_voy_no".trim(),	length));
				String[] crntSkdDirCd =	(JSPUtil.getParameter(request, prefix +	"crnt_skd_dir_cd".trim(),	length));
				String[] cnmvRmk =	(JSPUtil.getParameter(request, prefix +	"cnmv_rmk".trim(),	length));
				String[] mvmtEdiMsgAreaCd =	(JSPUtil.getParameter(request, prefix +	"mvmt_edi_msg_area_cd".trim(),	length));
				String[] mvmtEdiMsgSeq =	(JSPUtil.getParameter(request, prefix +	"mvmt_edi_msg_seq".trim(),	length));
				String[] mvmtEdiMsgTpId =	(JSPUtil.getParameter(request, prefix +	"mvmt_edi_msg_tp_id".trim(),	length));
				String[] mvmtEdiMsgYrmondy =	(JSPUtil.getParameter(request, prefix +	"mvmt_edi_msg_yrmondy".trim(),	length));
				String[] mvmtEdiTpCd =	(JSPUtil.getParameter(request, prefix +	"mvmt_edi_tp_cd".trim(),	length));
				String[] mvmtTrspModCd =	(JSPUtil.getParameter(request, prefix +	"mvmt_trsp_mod_cd".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] chkFlg =	(JSPUtil.getParameter(request, prefix +	"chk_flg".trim(),	length));
				String[] hCntrStsCd =	(JSPUtil.getParameter(request, prefix +	"h_cntr_sts_cd".trim(),	length));
				String[] hOnhYdCd =	(JSPUtil.getParameter(request, prefix +	"h_onh_yd_cd".trim(),	length));
				String[] hCnmvEvntDt =	(JSPUtil.getParameter(request, prefix +	"h_cnmv_evnt_dt".trim(),	length));
				String[] hChk1 =	(JSPUtil.getParameter(request, prefix +	"h_chk1".trim(),	length));
				String[] hChk2 =	(JSPUtil.getParameter(request, prefix +	"h_chk2".trim(),	length));
				String[] hChk3 =	(JSPUtil.getParameter(request, prefix +	"h_chk3".trim(),	length));
				String[] cnmvCycNoChg =	(JSPUtil.getParameter(request, prefix +	"cnmv_cyc_no_chg".trim(),	length));
				String[] tvvd =	(JSPUtil.getParameter(request, prefix +	"tvvd".trim(),	length));
				String[] rowNum =	(JSPUtil.getParameter(request, prefix +	"row_num".trim(),	length));
				String[] usrNm =	(JSPUtil.getParameter(request, prefix +	"usr_nm".trim(),	length));
				String[] cnmvYr =	(JSPUtil.getParameter(request, prefix +	"cnmv_yr".trim(),	length));
				String[] cnmvSeq =	(JSPUtil.getParameter(request, prefix +	"cnmv_seq".trim(),	length));
				String[] cnmvSplitNo =	(JSPUtil.getParameter(request, prefix +	"cnmv_split_no".trim(),	length));
				String[] cnmvIdNo =	(JSPUtil.getParameter(request, prefix +	"cnmv_id_no".trim(),	length));
				String[] sEventDate1 =	(JSPUtil.getParameter(request, prefix +	"s_event_date1".trim(),	length));
				String[] sEventDate2 =	(JSPUtil.getParameter(request, prefix +	"s_event_date2".trim(),	length));
				String[] polEtdDt =	(JSPUtil.getParameter(request, prefix +	"pol_etd_dt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	OscarBookingSearchVO();
						if ( podCd[i] !=	null)
						model.setPodCd( podCd[i]);
						if ( porCd[i] !=	null)
						model.setPorCd( porCd[i]);
						if ( bkgCgoTpCd[i] !=	null)
						model.setBkgCgoTpCd( bkgCgoTpCd[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( polCd[i] !=	null)
						model.setPolCd( polCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( cnmvCycNo[i] !=	null)
						model.setCnmvCycNo( cnmvCycNo[i]);
						if ( delCd[i] !=	null)
						model.setDelCd( delCd[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( sCntrNo[i] !=	null)
						model.setSCntrNo( sCntrNo[i]);
						if ( sBkgNo[i] !=	null)
						model.setSBkgNo( sBkgNo[i]);
						if ( hBkgNo[i] !=	null)
						model.setHBkgNo( hBkgNo[i]);
						if ( hCntrNo[i] !=	null)
						model.setHCntrNo( hCntrNo[i]);
						if ( vslOscaUpdDt[i] !=	null)
						model.setVslOscaUpdDt( vslOscaUpdDt[i]);
						if ( vslVvd[i] !=	null)
						model.setVslVvd( vslVvd[i]);
						if ( vslEtb[i] !=	null)
						model.setVslEtb( vslEtb[i]);
						if ( vslOscaCreDt[i] !=	null)
						model.setVslOscaCreDt( vslOscaCreDt[i]);
						if ( vslEtd[i] !=	null)
						model.setVslEtd( vslEtd[i]);
						if ( vslPodYdCd[i] !=	null)
						model.setVslPodYdCd( vslPodYdCd[i]);
						if ( vslPrePstCd[i] !=	null)
						model.setVslPrePstCd( vslPrePstCd[i]);
						if ( vslSlanCd[i] !=	null)
						model.setVslSlanCd( vslSlanCd[i]);
						if ( vslPolYdCd[i] !=	null)
						model.setVslPolYdCd( vslPolYdCd[i]);
						if ( cntrAgmtSeq[i] !=	null)
						model.setCntrAgmtSeq( cntrAgmtSeq[i]);
						if ( cntrDeTermCd[i] !=	null)
						model.setCntrDeTermCd( cntrDeTermCd[i]);
						if ( cntrCnmvStsCd[i] !=	null)
						model.setCntrCnmvStsCd( cntrCnmvStsCd[i]);
						if ( cntrStsCd[i] !=	null)
						model.setCntrStsCd( cntrStsCd[i]);
						if ( cntrRowSeq[i] !=	null)
						model.setCntrRowSeq( cntrRowSeq[i]);
						if ( cntrMinOnhDys[i] !=	null)
						model.setCntrMinOnhDys( cntrMinOnhDys[i]);
						if ( cntrRdCgoFlg[i] !=	null)
						model.setCntrRdCgoFlg( cntrRdCgoFlg[i]);
						if ( cntrRcvTermCd[i] !=	null)
						model.setCntrRcvTermCd( cntrRcvTermCd[i]);
						if ( cntrAgmtCtyCd[i] !=	null)
						model.setCntrAgmtCtyCd( cntrAgmtCtyCd[i]);
						if ( cntrAwkCgoFlg[i] !=	null)
						model.setCntrAwkCgoFlg( cntrAwkCgoFlg[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( cntrCrntYdCd[i] !=	null)
						model.setCntrCrntYdCd( cntrCrntYdCd[i]);
						if ( cntrDcgoFlg[i] !=	null)
						model.setCntrDcgoFlg( cntrDcgoFlg[i]);
						if ( cntrOnhYdCd[i] !=	null)
						model.setCntrOnhYdCd( cntrOnhYdCd[i]);
						if ( cntrRefNo[i] !=	null)
						model.setCntrRefNo( cntrRefNo[i]);
						if ( cntrCfmFlg[i] !=	null)
						model.setCntrCfmFlg( cntrCfmFlg[i]);
						if ( cntrOnhDt[i] !=	null)
						model.setCntrOnhDt( cntrOnhDt[i]);
						if ( cntrVndrAbbrNm[i] !=	null)
						model.setCntrVndrAbbrNm( cntrVndrAbbrNm[i]);
						if ( cntrUsedDys[i] !=	null)
						model.setCntrUsedDys( cntrUsedDys[i]);
						if ( cntrCnmvDt[i] !=	null)
						model.setCntrCnmvDt( cntrCnmvDt[i]);
						if ( cntrRcFlg[i] !=	null)
						model.setCntrRcFlg( cntrRcFlg[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
						if ( cntrVolQty[i] !=	null)
						model.setCntrVolQty( cntrVolQty[i]);
						if ( cntrCnmvCycNo[i] !=	null)
						model.setCntrCnmvCycNo( cntrCnmvCycNo[i]);
						if ( cntrOnhFreeDys[i] !=	null)
						model.setCntrOnhFreeDys( cntrOnhFreeDys[i]);
						if ( cntrVndrSeq[i] !=	null)
						model.setCntrVndrSeq( cntrVndrSeq[i]);
						if ( cntrLstmCd[i] !=	null)
						model.setCntrLstmCd( cntrLstmCd[i]);
						if ( cntrBbCgoFlg[i] !=	null)
						model.setCntrBbCgoFlg( cntrBbCgoFlg[i]);
						if ( pCntrno[i] !=	null)
						model.setPCntrno( pCntrno[i]);
						if ( checkDigit[i] !=	null)
						model.setCheckDigit( checkDigit[i]);
						if ( pDate1[i] !=	null)
						model.setPDate1( pDate1[i]);
						if ( pDate2[i] !=	null)
						model.setPDate2( pDate2[i]);
						if ( appCd[i] !=	null)
						model.setAppCd( appCd[i]);
						if ( slanCd[i] !=	null)
						model.setSlanCd( slanCd[i]);
						if ( bkgStsCd[i] !=	null)
						model.setBkgStsCd( bkgStsCd[i]);
						if ( rcvTermCd[i] !=	null)
						model.setRcvTermCd( rcvTermCd[i]);
						if ( deTermCd[i] !=	null)
						model.setDeTermCd( deTermCd[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( oscaBkgFlg[i] !=	null)
						model.setOscaBkgFlg( oscaBkgFlg[i]);
						if ( ediGateIoCd[i] !=	null)
						model.setEdiGateIoCd( ediGateIoCd[i]);
						if ( fcntrFlg[i] !=	null)
						model.setFcntrFlg( fcntrFlg[i]);
						if ( inpDt[i] !=	null)
						model.setInpDt( inpDt[i]);
						if ( mvmtEdiRmk[i] !=	null)
						model.setMvmtEdiRmk( mvmtEdiRmk[i]);
						if ( vvdCd[i] !=	null)
						model.setVvdCd( vvdCd[i]);
						if ( rtyKnt[i] !=	null)
						model.setRtyKnt( rtyKnt[i]);
						if ( mvmtEdiSghtCd[i] !=	null)
						model.setMvmtEdiSghtCd( mvmtEdiSghtCd[i]);
						if ( status[i] !=	null)
						model.setStatus( status[i]);
						if ( callSgnNo[i] !=	null)
						model.setCallSgnNo( callSgnNo[i]);
						if ( cnmvEvntDt[i] !=	null)
						model.setCnmvEvntDt( cnmvEvntDt[i]);
						if ( mvmtCreTpCd[i] !=	null)
						model.setMvmtCreTpCd( mvmtCreTpCd[i]);
						if ( orgYdCd[i] !=	null)
						model.setOrgYdCd( orgYdCd[i]);
						if ( obCntrFlg[i] !=	null)
						model.setObCntrFlg( obCntrFlg[i]);
						if ( mvmtStsCd[i] !=	null)
						model.setMvmtStsCd( mvmtStsCd[i]);
						if ( inpTpCd[i] !=	null)
						model.setInpTpCd( inpTpCd[i]);
						if ( refNo[i] !=	null)
						model.setRefNo( refNo[i]);
						if ( cntrFullStsCd[i] !=	null)
						model.setCntrFullStsCd( cntrFullStsCd[i]);
						if ( ediBkgNo[i] !=	null)
						model.setEdiBkgNo( ediBkgNo[i]);
						if ( cntrSealNo[i] !=	null)
						model.setCntrSealNo( cntrSealNo[i]);
						if ( cntrErrCnt[i] !=	null)
						model.setCntrErrCnt( cntrErrCnt[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( bkgKnt[i] !=	null)
						model.setBkgKnt( bkgKnt[i]);
						if ( cntrDmgFlg[i] !=	null)
						model.setCntrDmgFlg( cntrDmgFlg[i]);
						if ( chssNo[i] !=	null)
						model.setChssNo( chssNo[i]);
						if ( mgstNo[i] !=	null)
						model.setMgstNo( mgstNo[i]);
						if ( destYdCd[i] !=	null)
						model.setDestYdCd( destYdCd[i]);
						if ( lloydNo[i] !=	null)
						model.setLloydNo( lloydNo[i]);
						if ( woNo[i] !=	null)
						model.setWoNo( woNo[i]);
						if ( ediVvdCd[i] !=	null)
						model.setEdiVvdCd( ediVvdCd[i]);
						if ( tirNo[i] !=	null)
						model.setTirNo( tirNo[i]);
						if ( mtyPlnNo[i] !=	null)
						model.setMtyPlnNo( mtyPlnNo[i]);
						if ( mtyRepoNo[i] !=	null)
						model.setMtyRepoNo( mtyRepoNo[i]);
						if ( ediCrrNo[i] !=	null)
						model.setEdiCrrNo( ediCrrNo[i]);
						if ( trspDocNo[i] !=	null)
						model.setTrspDocNo( trspDocNo[i]);
						if ( crntVslCd[i] !=	null)
						model.setCrntVslCd( crntVslCd[i]);
						if ( crntSkdVoyNo[i] !=	null)
						model.setCrntSkdVoyNo( crntSkdVoyNo[i]);
						if ( crntSkdDirCd[i] !=	null)
						model.setCrntSkdDirCd( crntSkdDirCd[i]);
						if ( cnmvRmk[i] !=	null)
						model.setCnmvRmk( cnmvRmk[i]);
						if ( mvmtEdiMsgAreaCd[i] !=	null)
						model.setMvmtEdiMsgAreaCd( mvmtEdiMsgAreaCd[i]);
						if ( mvmtEdiMsgSeq[i] !=	null)
						model.setMvmtEdiMsgSeq( mvmtEdiMsgSeq[i]);
						if ( mvmtEdiMsgTpId[i] !=	null)
						model.setMvmtEdiMsgTpId( mvmtEdiMsgTpId[i]);
						if ( mvmtEdiMsgYrmondy[i] !=	null)
						model.setMvmtEdiMsgYrmondy( mvmtEdiMsgYrmondy[i]);
						if ( mvmtEdiTpCd[i] !=	null)
						model.setMvmtEdiTpCd( mvmtEdiTpCd[i]);
						if ( mvmtTrspModCd[i] !=	null)
						model.setMvmtTrspModCd( mvmtTrspModCd[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( chkFlg[i] !=	null)
						model.setChkFlg( chkFlg[i]);
						if ( hCntrStsCd[i] !=	null)
						model.setHCntrStsCd( hCntrStsCd[i]);
						if ( hOnhYdCd[i] !=	null)
						model.setHOnhYdCd( hOnhYdCd[i]);
						if ( hCnmvEvntDt[i] !=	null)
						model.setHCnmvEvntDt( hCnmvEvntDt[i]);
						if ( hChk1[i] !=	null)
						model.setHChk1( hChk1[i]);
						if ( hChk2[i] !=	null)
						model.setHChk2( hChk2[i]);
						if ( hChk3[i] !=	null)
						model.setHChk3( hChk3[i]);
						if ( cnmvCycNoChg[i] !=	null)
						model.setCnmvCycNoChg( cnmvCycNoChg[i]);
						if ( tvvd[i] !=	null)
						model.setTvvd( tvvd[i]);
						if ( rowNum[i] !=	null)
						model.setRowNum( rowNum[i]);
						if ( usrNm[i] !=	null)
						model.setUsrNm( usrNm[i]);
						if ( cnmvYr[i] !=	null)
						model.setCnmvYr( cnmvYr[i]);
						if ( cnmvSeq[i] !=	null)
						model.setCnmvSeq( cnmvSeq[i]);
						if ( cnmvSplitNo[i] !=	null)
						model.setCnmvSplitNo( cnmvSplitNo[i]);
						if ( cnmvIdNo[i] !=	null)
						model.setCnmvIdNo( cnmvIdNo[i]);
						if ( sEventDate1[i] !=	null)
						model.setSEventDate1( sEventDate1[i]);
						if ( sEventDate2[i] !=	null)
						model.setSEventDate2( sEventDate2[i]);
						if ( polEtdDt[i] !=	null)
						model.setPolEtdDt( polEtdDt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getOscarBookingSearchVOs();
	}

	/**
	  *  VO 배열을 반환
	 * @return OscarBookingSearchVO[]
	 */
	public OscarBookingSearchVO[]	 getOscarBookingSearchVOs(){
		OscarBookingSearchVO[] vos = (OscarBookingSearchVO[])models.toArray(new	OscarBookingSearchVO[models.size()]);
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
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd =	this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd =	this.bkgCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCycNo =	this.cnmvCycNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd =	this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCntrNo =	this.sCntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgNo =	this.sBkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hBkgNo =	this.hBkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hCntrNo =	this.hCntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOscaUpdDt =	this.vslOscaUpdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslVvd =	this.vslVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEtb =	this.vslEtb.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOscaCreDt =	this.vslOscaCreDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEtd =	this.vslEtd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPodYdCd =	this.vslPodYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPrePstCd =	this.vslPrePstCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd =	this.vslSlanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPolYdCd =	this.vslPolYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrAgmtSeq =	this.cntrAgmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDeTermCd =	this.cntrDeTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCnmvStsCd =	this.cntrCnmvStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsCd =	this.cntrStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRowSeq =	this.cntrRowSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMinOnhDys =	this.cntrMinOnhDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRdCgoFlg =	this.cntrRdCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRcvTermCd =	this.cntrRcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrAgmtCtyCd =	this.cntrAgmtCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrAwkCgoFlg =	this.cntrAwkCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCrntYdCd =	this.cntrCrntYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDcgoFlg =	this.cntrDcgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrOnhYdCd =	this.cntrOnhYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRefNo =	this.cntrRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCfmFlg =	this.cntrCfmFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrOnhDt =	this.cntrOnhDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVndrAbbrNm =	this.cntrVndrAbbrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrUsedDys =	this.cntrUsedDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCnmvDt =	this.cntrCnmvDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRcFlg =	this.cntrRcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVolQty =	this.cntrVolQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCnmvCycNo =	this.cntrCnmvCycNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrOnhFreeDys =	this.cntrOnhFreeDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVndrSeq =	this.cntrVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLstmCd =	this.cntrLstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrBbCgoFlg =	this.cntrBbCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCntrno =	this.pCntrno.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkDigit =	this.checkDigit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate1 =	this.pDate1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate2 =	this.pDate2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.appCd =	this.appCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd =	this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd =	this.bkgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd =	this.rcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd =	this.deTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oscaBkgFlg =	this.oscaBkgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGateIoCd =	this.ediGateIoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcntrFlg =	this.fcntrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpDt =	this.inpDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiRmk =	this.mvmtEdiRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd =	this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtyKnt =	this.rtyKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiSghtCd =	this.mvmtEdiSghtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status =	this.status.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo =	this.callSgnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvEvntDt =	this.cnmvEvntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtCreTpCd =	this.mvmtCreTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd =	this.orgYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCntrFlg =	this.obCntrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd =	this.mvmtStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpTpCd =	this.inpTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo =	this.refNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFullStsCd =	this.cntrFullStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediBkgNo =	this.ediBkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo =	this.cntrSealNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrErrCnt =	this.cntrErrCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgKnt =	this.bkgKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDmgFlg =	this.cntrDmgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo =	this.chssNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstNo =	this.mgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destYdCd =	this.destYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydNo =	this.lloydNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo =	this.woNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediVvdCd =	this.ediVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tirNo =	this.tirNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPlnNo =	this.mtyPlnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyRepoNo =	this.mtyRepoNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediCrrNo =	this.ediCrrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspDocNo =	this.trspDocNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntVslCd =	this.crntVslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntSkdVoyNo =	this.crntSkdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntSkdDirCd =	this.crntSkdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvRmk =	this.cnmvRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgAreaCd =	this.mvmtEdiMsgAreaCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgSeq =	this.mvmtEdiMsgSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgTpId =	this.mvmtEdiMsgTpId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgYrmondy =	this.mvmtEdiMsgYrmondy.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiTpCd =	this.mvmtEdiTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtTrspModCd =	this.mvmtTrspModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkFlg =	this.chkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hCntrStsCd =	this.hCntrStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hOnhYdCd =	this.hOnhYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hCnmvEvntDt =	this.hCnmvEvntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hChk1 =	this.hChk1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hChk2 =	this.hChk2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hChk3 =	this.hChk3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCycNoChg =	this.cnmvCycNoChg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvvd =	this.tvvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowNum =	this.rowNum.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm =	this.usrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr =	this.cnmvYr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSeq =	this.cnmvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSplitNo =	this.cnmvSplitNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvIdNo =	this.cnmvIdNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEventDate1 =	this.sEventDate1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEventDate2 =	this.sEventDate2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtdDt =	this.polEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}
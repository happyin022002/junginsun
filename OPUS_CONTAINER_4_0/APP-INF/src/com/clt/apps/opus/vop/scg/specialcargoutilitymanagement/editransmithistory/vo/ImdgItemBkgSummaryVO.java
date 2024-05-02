/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ImdgItemBkgSummaryVO.java
 *@FileTitle : ImdgItemBkgSummaryVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.02
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.12.02 dongsoo 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.vo;

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
 * @author dongsoo
 * @since J2EE 1.6
 * @see	..
 */
public class ImdgItemBkgSummaryVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ImdgItemBkgSummaryVO>  models =	new	ArrayList<ImdgItemBkgSummaryVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String seq = null;
	/*	Column Info	*/
	private String rankSeq = null;
	/*	Column Info	*/
	private String bkgRefNo = null;
	/*	Column Info	*/
	private String ediMsgStsCd = null;
	/*	Column Info	*/
	private String refNo = null;
	/*	Column Info	*/
	private String lstRqstDatFlg = null;
	/*	Column Info	*/
	private String imdgUnNoCtnt = null;
	/*	Column Info	*/
	private String imdgClssCdCtnt = null;
	/*	Column Info	*/
	private String imdgPckGrpCdCtnt = null;
	/*	Column Info	*/
	private String prpShpNm = null;
	/*	Column Info	*/
	private String dcgoStsCdCtnt = null;
	/*	Column Info	*/
	private String cgoSeq = null;
	/*	Column Info	*/
	private String cntrSeq = null;
	/*	Column Info	*/
	private String grsWgtCtnt = null;
	/*	Column Info	*/
	private String netWgtCtnt = null;
	/*	Column Info	*/
	private String ifDate = null;
	
	/*	Column Info	*/
	private String dcgoRefNo = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public ImdgItemBkgSummaryVO(){}

	public ImdgItemBkgSummaryVO(String ibflag,String pagerows,String seq,String rankSeq,String bkgRefNo,String ediMsgStsCd,String refNo,String lstRqstDatFlg,String imdgUnNoCtnt,String imdgClssCdCtnt,String imdgPckGrpCdCtnt,String prpShpNm,String dcgoStsCdCtnt,String cgoSeq,String cntrSeq,String grsWgtCtnt,String netWgtCtnt,String ifDate)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.seq = seq;
		this.rankSeq = rankSeq;
		this.bkgRefNo = bkgRefNo;
		this.ediMsgStsCd = ediMsgStsCd;
		this.refNo = refNo;
		this.lstRqstDatFlg = lstRqstDatFlg;
		this.imdgUnNoCtnt = imdgUnNoCtnt;
		this.imdgClssCdCtnt = imdgClssCdCtnt;
		this.imdgPckGrpCdCtnt = imdgPckGrpCdCtnt;
		this.prpShpNm = prpShpNm;
		this.dcgoStsCdCtnt = dcgoStsCdCtnt;
		this.cgoSeq = cgoSeq;
		this.cntrSeq = cntrSeq;
		this.grsWgtCtnt = grsWgtCtnt;
		this.netWgtCtnt = netWgtCtnt;
		this.ifDate = ifDate;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("rank_seq", getRankSeq());
		this.hashColumns.put("bkg_ref_no", getBkgRefNo());
		this.hashColumns.put("edi_msg_sts_cd", getEdiMsgStsCd());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("lst_rqst_dat_flg", getLstRqstDatFlg());
		this.hashColumns.put("imdg_un_no_ctnt", getImdgUnNoCtnt());
		this.hashColumns.put("imdg_clss_cd_ctnt", getImdgClssCdCtnt());
		this.hashColumns.put("imdg_pck_grp_cd_ctnt", getImdgPckGrpCdCtnt());
		this.hashColumns.put("prp_shp_nm", getPrpShpNm());
		this.hashColumns.put("dcgo_sts_cd_ctnt", getDcgoStsCdCtnt());
		this.hashColumns.put("cgo_seq", getCgoSeq());
		this.hashColumns.put("cntr_seq", getCntrSeq());
		this.hashColumns.put("grs_wgt_ctnt", getGrsWgtCtnt());
		this.hashColumns.put("net_wgt_ctnt", getNetWgtCtnt());
		this.hashColumns.put("if_date", getIfDate());
		
		this.hashColumns.put("dcgo_ref_no", getDcgoRefNo());
		
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("rank_seq", "rankSeq");
		this.hashFields.put("bkg_ref_no", "bkgRefNo");
		this.hashFields.put("edi_msg_sts_cd", "ediMsgStsCd");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("lst_rqst_dat_flg", "lstRqstDatFlg");
		this.hashFields.put("imdg_un_no_ctnt", "imdgUnNoCtnt");
		this.hashFields.put("imdg_clss_cd_ctnt", "imdgClssCdCtnt");
		this.hashFields.put("imdg_pck_grp_cd_ctnt", "imdgPckGrpCdCtnt");
		this.hashFields.put("prp_shp_nm", "prpShpNm");
		this.hashFields.put("dcgo_sts_cd_ctnt", "dcgoStsCdCtnt");
		this.hashFields.put("cgo_seq", "cgoSeq");
		this.hashFields.put("cntr_seq", "cntrSeq");
		this.hashFields.put("grs_wgt_ctnt", "grsWgtCtnt");
		this.hashFields.put("net_wgt_ctnt", "netWgtCtnt");
		this.hashFields.put("if_date", "ifDate");
		
		this.hashFields.put("dcgo_ref_no", "dcgoRefNo");
		
		return this.hashFields;
	}

	//	Getters	and	Setters

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public	String getIbflag() {
		return	this.ibflag;
	}

	/**
	 * Page Number
	 * @return pagerows
	 */
	public	String getPagerows() {
		return	this.pagerows;
	}

	/**
	 * Column Info
	 * @return seq
	 */
	public	String getSeq() {
		return	this.seq;
	}

	/**
	 * Column Info
	 * @return rankSeq
	 */
	public	String getRankSeq() {
		return	this.rankSeq;
	}

	/**
	 * Column Info
	 * @return bkgRefNo
	 */
	public	String getBkgRefNo() {
		return	this.bkgRefNo;
	}

	/**
	 * Column Info
	 * @return ediMsgStsCd
	 */
	public	String getEdiMsgStsCd() {
		return	this.ediMsgStsCd;
	}

	/**
	 * Column Info
	 * @return refNo
	 */
	public	String getRefNo() {
		return	this.refNo;
	}

	/**
	 * Column Info
	 * @return lstRqstDatFlg
	 */
	public	String getLstRqstDatFlg() {
		return	this.lstRqstDatFlg;
	}

	/**
	 * Column Info
	 * @return imdgUnNoCtnt
	 */
	public	String getImdgUnNoCtnt() {
		return	this.imdgUnNoCtnt;
	}

	/**
	 * Column Info
	 * @return imdgClssCdCtnt
	 */
	public	String getImdgClssCdCtnt() {
		return	this.imdgClssCdCtnt;
	}

	/**
	 * Column Info
	 * @return imdgPckGrpCdCtnt
	 */
	public	String getImdgPckGrpCdCtnt() {
		return	this.imdgPckGrpCdCtnt;
	}

	/**
	 * Column Info
	 * @return prpShpNm
	 */
	public	String getPrpShpNm() {
		return	this.prpShpNm;
	}

	/**
	 * Column Info
	 * @return dcgoStsCdCtnt
	 */
	public	String getDcgoStsCdCtnt() {
		return	this.dcgoStsCdCtnt;
	}

	/**
	 * Column Info
	 * @return cgoSeq
	 */
	public	String getCgoSeq() {
		return	this.cgoSeq;
	}

	/**
	 * Column Info
	 * @return cntrSeq
	 */
	public	String getCntrSeq() {
		return	this.cntrSeq;
	}

	/**
	 * Column Info
	 * @return grsWgtCtnt
	 */
	public	String getGrsWgtCtnt() {
		return	this.grsWgtCtnt;
	}

	/**
	 * Column Info
	 * @return netWgtCtnt
	 */
	public	String getNetWgtCtnt() {
		return	this.netWgtCtnt;
	}

	/**
	 * Column Info
	 * @return ifDate
	 */
	public	String getIfDate() {
		return	this.ifDate;
	}

	
	
	/**
	 * Column Info
	 * @return dcgoRefNo
	 */
	public	String getDcgoRefNo() {
		return	this.dcgoRefNo;
	}

 	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  dcgoRefNo
 	 */
	public void	setDcgoRefNo(String dcgoRefNo ) {
		this.dcgoRefNo =	dcgoRefNo;
	}
	
	
	
 	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  ibflag
 	 */
	public void	setIbflag(String ibflag ) {
		this.ibflag =	ibflag;
	}
 	/**
	 * Page Number
	 * @param  pagerows
 	 */
	public void	setPagerows(String pagerows ) {
		this.pagerows =	pagerows;
	}
 	/**
	 * Column Info
	 * @param  seq
 	 */
	public void	setSeq(String seq ) {
		this.seq =	seq;
	}
 	/**
	 * Column Info
	 * @param  rankSeq
 	 */
	public void	setRankSeq(String rankSeq ) {
		this.rankSeq =	rankSeq;
	}
 	/**
	 * Column Info
	 * @param  bkgRefNo
 	 */
	public void	setBkgRefNo(String bkgRefNo ) {
		this.bkgRefNo =	bkgRefNo;
	}
 	/**
	 * Column Info
	 * @param  ediMsgStsCd
 	 */
	public void	setEdiMsgStsCd(String ediMsgStsCd ) {
		this.ediMsgStsCd =	ediMsgStsCd;
	}
 	/**
	 * Column Info
	 * @param  refNo
 	 */
	public void	setRefNo(String refNo ) {
		this.refNo =	refNo;
	}
 	/**
	 * Column Info
	 * @param  lstRqstDatFlg
 	 */
	public void	setLstRqstDatFlg(String lstRqstDatFlg ) {
		this.lstRqstDatFlg =	lstRqstDatFlg;
	}
 	/**
	 * Column Info
	 * @param  imdgUnNoCtnt
 	 */
	public void	setImdgUnNoCtnt(String imdgUnNoCtnt ) {
		this.imdgUnNoCtnt =	imdgUnNoCtnt;
	}
 	/**
	 * Column Info
	 * @param  imdgClssCdCtnt
 	 */
	public void	setImdgClssCdCtnt(String imdgClssCdCtnt ) {
		this.imdgClssCdCtnt =	imdgClssCdCtnt;
	}
 	/**
	 * Column Info
	 * @param  imdgPckGrpCdCtnt
 	 */
	public void	setImdgPckGrpCdCtnt(String imdgPckGrpCdCtnt ) {
		this.imdgPckGrpCdCtnt =	imdgPckGrpCdCtnt;
	}
 	/**
	 * Column Info
	 * @param  prpShpNm
 	 */
	public void	setPrpShpNm(String prpShpNm ) {
		this.prpShpNm =	prpShpNm;
	}
 	/**
	 * Column Info
	 * @param  dcgoStsCdCtnt
 	 */
	public void	setDcgoStsCdCtnt(String dcgoStsCdCtnt ) {
		this.dcgoStsCdCtnt =	dcgoStsCdCtnt;
	}
 	/**
	 * Column Info
	 * @param  cgoSeq
 	 */
	public void	setCgoSeq(String cgoSeq ) {
		this.cgoSeq =	cgoSeq;
	}
 	/**
	 * Column Info
	 * @param  cntrSeq
 	 */
	public void	setCntrSeq(String cntrSeq ) {
		this.cntrSeq =	cntrSeq;
	}
 	/**
	 * Column Info
	 * @param  grsWgtCtnt
 	 */
	public void	setGrsWgtCtnt(String grsWgtCtnt ) {
		this.grsWgtCtnt =	grsWgtCtnt;
	}
 	/**
	 * Column Info
	 * @param  netWgtCtnt
 	 */
	public void	setNetWgtCtnt(String netWgtCtnt ) {
		this.netWgtCtnt =	netWgtCtnt;
	}
 	/**
	 * Column Info
	 * @param  ifDate
 	 */
	public void	setIfDate(String ifDate ) {
		this.ifDate =	ifDate;
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
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setSeq(JSPUtil.getParameter(request,	prefix + "seq", ""));
		setRankSeq(JSPUtil.getParameter(request,	prefix + "rank_seq", ""));
		setBkgRefNo(JSPUtil.getParameter(request,	prefix + "bkg_ref_no", ""));
		setEdiMsgStsCd(JSPUtil.getParameter(request,	prefix + "edi_msg_sts_cd", ""));
		setRefNo(JSPUtil.getParameter(request,	prefix + "ref_no", ""));
		setLstRqstDatFlg(JSPUtil.getParameter(request,	prefix + "lst_rqst_dat_flg", ""));
		setImdgUnNoCtnt(JSPUtil.getParameter(request,	prefix + "imdg_un_no_ctnt", ""));
		setImdgClssCdCtnt(JSPUtil.getParameter(request,	prefix + "imdg_clss_cd_ctnt", ""));
		setImdgPckGrpCdCtnt(JSPUtil.getParameter(request,	prefix + "imdg_pck_grp_cd_ctnt", ""));
		setPrpShpNm(JSPUtil.getParameter(request,	prefix + "prp_shp_nm", ""));
		setDcgoStsCdCtnt(JSPUtil.getParameter(request,	prefix + "dcgo_sts_cd_ctnt", ""));
		setCgoSeq(JSPUtil.getParameter(request,	prefix + "cgo_seq", ""));
		setCntrSeq(JSPUtil.getParameter(request,	prefix + "cntr_seq", ""));
		setGrsWgtCtnt(JSPUtil.getParameter(request,	prefix + "grs_wgt_ctnt", ""));
		setNetWgtCtnt(JSPUtil.getParameter(request,	prefix + "net_wgt_ctnt", ""));
		setIfDate(JSPUtil.getParameter(request,	prefix + "if_date", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ImdgItemBkgSummaryVO[]
	 */
	public ImdgItemBkgSummaryVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ImdgItemBkgSummaryVO[]
	 */
	public ImdgItemBkgSummaryVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ImdgItemBkgSummaryVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] seq =	(JSPUtil.getParameter(request, prefix +	"seq",	length));
			String[] rankSeq =	(JSPUtil.getParameter(request, prefix +	"rank_seq",	length));
			String[] bkgRefNo =	(JSPUtil.getParameter(request, prefix +	"bkg_ref_no",	length));
			String[] ediMsgStsCd =	(JSPUtil.getParameter(request, prefix +	"edi_msg_sts_cd",	length));
			String[] refNo =	(JSPUtil.getParameter(request, prefix +	"ref_no",	length));
			String[] lstRqstDatFlg =	(JSPUtil.getParameter(request, prefix +	"lst_rqst_dat_flg",	length));
			String[] imdgUnNoCtnt =	(JSPUtil.getParameter(request, prefix +	"imdg_un_no_ctnt",	length));
			String[] imdgClssCdCtnt =	(JSPUtil.getParameter(request, prefix +	"imdg_clss_cd_ctnt",	length));
			String[] imdgPckGrpCdCtnt =	(JSPUtil.getParameter(request, prefix +	"imdg_pck_grp_cd_ctnt",	length));
			String[] prpShpNm =	(JSPUtil.getParameter(request, prefix +	"prp_shp_nm",	length));
			String[] dcgoStsCdCtnt =	(JSPUtil.getParameter(request, prefix +	"dcgo_sts_cd_ctnt",	length));
			String[] cgoSeq =	(JSPUtil.getParameter(request, prefix +	"cgo_seq",	length));
			String[] cntrSeq =	(JSPUtil.getParameter(request, prefix +	"cntr_seq",	length));
			String[] grsWgtCtnt =	(JSPUtil.getParameter(request, prefix +	"grs_wgt_ctnt",	length));
			String[] netWgtCtnt =	(JSPUtil.getParameter(request, prefix +	"net_wgt_ctnt",	length));
			String[] ifDate =	(JSPUtil.getParameter(request, prefix +	"if_date",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	ImdgItemBkgSummaryVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( seq[i] !=	null)
					model.setSeq( seq[i]);
				if ( rankSeq[i] !=	null)
					model.setRankSeq( rankSeq[i]);
				if ( bkgRefNo[i] !=	null)
					model.setBkgRefNo( bkgRefNo[i]);
				if ( ediMsgStsCd[i] !=	null)
					model.setEdiMsgStsCd( ediMsgStsCd[i]);
				if ( refNo[i] !=	null)
					model.setRefNo( refNo[i]);
				if ( lstRqstDatFlg[i] !=	null)
					model.setLstRqstDatFlg( lstRqstDatFlg[i]);
				if ( imdgUnNoCtnt[i] !=	null)
					model.setImdgUnNoCtnt( imdgUnNoCtnt[i]);
				if ( imdgClssCdCtnt[i] !=	null)
					model.setImdgClssCdCtnt( imdgClssCdCtnt[i]);
				if ( imdgPckGrpCdCtnt[i] !=	null)
					model.setImdgPckGrpCdCtnt( imdgPckGrpCdCtnt[i]);
				if ( prpShpNm[i] !=	null)
					model.setPrpShpNm( prpShpNm[i]);
				if ( dcgoStsCdCtnt[i] !=	null)
					model.setDcgoStsCdCtnt( dcgoStsCdCtnt[i]);
				if ( cgoSeq[i] !=	null)
					model.setCgoSeq( cgoSeq[i]);
				if ( cntrSeq[i] !=	null)
					model.setCntrSeq( cntrSeq[i]);
				if ( grsWgtCtnt[i] !=	null)
					model.setGrsWgtCtnt( grsWgtCtnt[i]);
				if ( netWgtCtnt[i] !=	null)
					model.setNetWgtCtnt( netWgtCtnt[i]);
				if ( ifDate[i] !=	null)
					model.setIfDate( ifDate[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getImdgItemBkgSummaryVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return ImdgItemBkgSummaryVO[]
	 */
	public ImdgItemBkgSummaryVO[]	 getImdgItemBkgSummaryVOs(){
		ImdgItemBkgSummaryVO[] vos = (ImdgItemBkgSummaryVO[])models.toArray(new	ImdgItemBkgSummaryVO[models.size()]);
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
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq =	this.seq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rankSeq =	this.rankSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRefNo =	this.bkgRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMsgStsCd =	this.ediMsgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo =	this.refNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstRqstDatFlg =	this.lstRqstDatFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoCtnt =	this.imdgUnNoCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCdCtnt =	this.imdgClssCdCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckGrpCdCtnt =	this.imdgPckGrpCdCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prpShpNm =	this.prpShpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoStsCdCtnt =	this.dcgoStsCdCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoSeq =	this.cgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSeq =	this.cntrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgtCtnt =	this.grsWgtCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWgtCtnt =	this.netWgtCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifDate =	this.ifDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
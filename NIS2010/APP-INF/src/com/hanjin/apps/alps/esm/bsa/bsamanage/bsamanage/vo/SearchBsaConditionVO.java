/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSlotPrcConditionVO.java
*@FileTitle : SearchSlotPrcConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : �④턿吏꾪샇
*@LastVersion : 1.0
* 2009.09.08 �④턿吏꾪샇 
* 1.0 Creation
=========================================================
* History :
* 2011.07.15 �댄뻾吏�[CHM-201112101-01] ESM_PRI_0028 �붾㈃ 寃�깋議곌굔 Currency Code 異붽�
=========================================================*/

package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 愿�젴 Event �먯꽌 �앹꽦, �쒕쾭�ㅽ뻾�붿껌��Data �꾨떖��븷���섑뻾�섎뒗 Value Object
 *
 * @author �④턿吏꾪샇
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
  
public class SearchBsaConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBsaConditionVO> models = new ArrayList<SearchBsaConditionVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String txtedate = null;
	/* Column Info */
	private String crrcd = null;
	/* Column Info */
	private String rdotype = null;
	/* Column Info */
	private String txtsdate = null;
	/* Column Info */
	private String bsaopjbcd = null;
	/* Column Info */
	private String bsaopjbcd2 = null;
	/* Column Info */
	private String itrkey2 = null;
	/* Column Info */
	private String itrkey1 = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String header2 = null;
	/* Page Number */
	private String rdotype2 = null;
	/* Page Number */
	private String jheader = null;
	/* Page Number */
	private String sheader = null;
	/* Page Number */
	private String rdoopcd = null;
	/* Page Number */
	private String rdoopjbcd = null;
	/* Page Number */
	private String rdoopjbcd2 = null;
	/* Column Info */
	private String cobtrade = null;
	/* Column Info */
	private String coblane = null;
	/* Column Info */
	private String cobcapa = null;
	/* Column Info */
	private String cobdir = null;
	/* Column Info */
	private String cobvop = null;
	/* Page Number */
	private String cobcurr = null;
	/* Page Number */
	private String cobCarrier = null;
	/* Page Number */
	private String excludVslCapa = null;	
	
	/********* ESM_BSA_0122 ***********/
	/* Page Number */
	private String pbsafmdt = null;
	/* Page Number */
	private String pbsatodt = null;
	/* Page Number */
	private String ptrdcd = null;
	/* Page Number */
	private String prlanecd = null;
	/* Page Number */
	private String pdircd = null;
	/* Page Number */
	private String pvopcd = null;
	/* Page Number */
	private String pvslcapa = null;
	/* Page Number */
	private String pbsaseq = null;
	/* Page Number */
	private String pbsaopjbcd = null;
	/* Page Number */
	private String pbsaopcd = null;
	
	/********* ESM_BSA_0026�ъ슜 ***********/
	/* Page Number */
	private String mBsaSeq = null;
	/* Page Number */
	private String mTrdCd = null;
	/* Page Number */
	private String mRlaneCd = null;
	/* Page Number */
	private String mDirCd = null;
	/* Page Number */
	private String mVopCd = null;
	/* Page Number */
	private String mVslSeq = null;
	/* Page Number */
	private String mVslCapa = null;
	/* Page Number */
	private String mBsaOpCd = null;
	/* Page Number */
	private String mBsaOpJbCd = null;
	/* Page Number */
	private String mCrrCd = null;
	
	

	/*	�뚯씠釉�而щ읆��媛믪쓣 ��옣�섎뒗 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	�뚯씠釉�而щ읆����쓳�섎뒗 硫ㅻ쾭蹂�닔瑜���옣�섎뒗 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchBsaConditionVO() {}

	public SearchBsaConditionVO(
			String ibflag, String pagerows, String txtsdate, String txtedate, 
			String cobtrade, String coblane, String cobcapa, String cobdir, String cobvop,String rdotype, 
			String bsaopjbcd, String bsaopjbcd2,String crrcd, String itrkey1, String itrkey2,
			String ptrdcd, String prlanecd, String pdircd, String pvopcd,
			String pvslcapa, String pbsaseq, String pbsaopjbcd, String pbsaopcd,
			String pbsafmdt, String pbsatodt, String cobcurr) {
		this.txtedate = txtedate;
		this.ibflag = ibflag;
		this.crrcd = crrcd;
		this.rdotype = rdotype;
		this.txtsdate = txtsdate;
		this.bsaopjbcd = bsaopjbcd;
		this.bsaopjbcd2 = bsaopjbcd2;
		this.itrkey2 = itrkey2;
		this.itrkey1 = itrkey1;
		this.cobtrade = cobtrade;
		this.coblane = coblane;
		this.cobcapa = cobcapa;
		this.cobdir = cobdir;
		this.cobvop = cobvop;
		this.cobcurr = cobcurr;
		this.pagerows = pagerows;
		
		this.ptrdcd = ptrdcd;
		this.prlanecd = prlanecd;
		this.pdircd = pdircd;
		this.pvopcd = pvopcd;
		this.pvslcapa = pvslcapa;
		this.pbsaseq = pbsaseq;
		this.pbsaopjbcd = pbsaopjbcd;
		this.pbsaopcd = pbsaopcd;
		this.pbsafmdt = pbsafmdt;
		this.pbsatodt = pbsatodt;
	}
	
	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value"> 濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("txtedate", getTxtedate());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("coblane", getCoblane());
		this.hashColumns.put("cobcapa", getCobcapa());
		this.hashColumns.put("crrcd", getCrrcd());
		this.hashColumns.put("rdotype", getRdotype());
		this.hashColumns.put("txtsdate", getTxtsdate());
		this.hashColumns.put("bsaopjbcd", getBsaopjbcd());
		this.hashColumns.put("bsaopjbcd2", getBsaopjbcd2());
		this.hashColumns.put("cobdir", getCobdir());
		this.hashColumns.put("cobvop", getCobvop());
		this.hashColumns.put("itrkey2", getItrkey2());
		this.hashColumns.put("itrkey1", getItrkey1());
		this.hashColumns.put("cobtrade", getCobtrade());
		this.hashColumns.put("rdoopcd", getRdoopcd());
		this.hashColumns.put("rdoopjbcd", getRdoopjbcd());
		this.hashColumns.put("rdoopjbcd2", getRdoopjbcd2());
		this.hashColumns.put("cobCarrier", getCobCarrier());
		this.hashColumns.put("excludVslCapa", getExcludVslCapa());
		
		this.hashColumns.put("cobcurr", getCobcurr());
		this.hashColumns.put("pagerows", getPagerows());
		
		this.hashColumns.put("ptrdcd", getPtrdcd());
		this.hashColumns.put("prlanecd", getPrlanecd());
		this.hashColumns.put("pdircd", getPdircd());
		this.hashColumns.put("pvopcd", getPvopcd());
		this.hashColumns.put("pvslcapa", getPvslcapa());
		this.hashColumns.put("pbsaseq", getPbsaseq());
		this.hashColumns.put("pbsaopjbcd", getPbsaopjbcd());
		this.hashColumns.put("pbsaopcd", getPbsaopcd());
		this.hashColumns.put("pbsafmdt", getPbsafmdt());
		this.hashColumns.put("pbsatodt", getPbsatodt());
		
		this.hashColumns.put("bsa_seq", getMBsaSeq());
		this.hashColumns.put("trd_cd", getMTrdCd());
		this.hashColumns.put("rlane_cd", getMRlaneCd());
		this.hashColumns.put("dir_cd", getMDirCd());
		this.hashColumns.put("vop_cd", getMVopCd());
		this.hashColumns.put("vsl_seq", getMVslSeq());
		this.hashColumns.put("vsl_capa", getMVslCapa());
		this.hashColumns.put("bsa_op_cd", getMBsaOpCd());
		this.hashColumns.put("bsa_op_jb_cd", getMBsaOpJbCd());
		this.hashColumns.put("crr_cd", getMCrrCd());
		return this.hashColumns;
	}
	
	/**
	 * 而щ읆紐낆뿉 ��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣 ��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("txtedate", "txtedate");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("coblane", "coblane");
		this.hashFields.put("cobcapa", "cobcapa");
		this.hashFields.put("crrcd", "crrcd");
		this.hashFields.put("rdotype", "rdotype");
		this.hashFields.put("txtsdate", "txtsdate");
		this.hashFields.put("bsaopjbcd", "bsaopjbcd");
		this.hashFields.put("bsaopjbcd2", "bsaopjbcd2");
		this.hashFields.put("cobdir", "cobdir");
		this.hashFields.put("cobvop", "cobvop");
		this.hashFields.put("itrkey2", "itrkey2");
		this.hashFields.put("itrkey1", "itrkey1");
		this.hashFields.put("cobtrade", "cobtrade");
		this.hashFields.put("rdoopcd", "rdoopcd");
		this.hashFields.put("rdoopjbcd", "rdoopjbcd");
		this.hashFields.put("rdoopjbcd2", "rdoopjbcd2");
		this.hashFields.put("cobCarrier", "cobCarrier");
		this.hashFields.put("excludVslCapa", "excludVslCapa");
		
		this.hashFields.put("cobcurr", "cobcurr");
		this.hashFields.put("pagerows", "pagerows");
		
		this.hashFields.put("ptrdcd", "ptrdcd");
		this.hashFields.put("prlanecd", "prlanecd");
		this.hashFields.put("pdircd", "pdircd");
		this.hashFields.put("pvopcd", "pvopcd");
		this.hashFields.put("pvslcapa", "pvslcapa");
		this.hashFields.put("pbsaseq", "pbsaseq");
		this.hashFields.put("pbsaopjbcd", "pbsaopjbcd");
		this.hashFields.put("pbsaopcd", "pbsaopcd");
		this.hashFields.put("pbsafmdt", "pbsafmdt");
		this.hashFields.put("pbsatodt", "pbsatodt");
		
		this.hashFields.put("mBsaSeq", "mBsaSeq");
		this.hashFields.put("mTrdCd", "mTrdCd");
		this.hashFields.put("mRlaneCd", "mRlaneCd");
		this.hashFields.put("mDirCd", "mDirCd");
		this.hashFields.put("mVopCd", "mVopCd");
		this.hashFields.put("mVslSeq", "mVslSeq");
		this.hashFields.put("mVslCapa", "mVslCapa");
		this.hashFields.put("mBsaOpCd", "mBsaOpCd");
		this.hashFields.put("mBsaOpJbCd", "mBsaOpJbCd");
		this.hashFields.put("mCrrCd", "mCrrCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return txtedate
	 */
	public String getTxtedate() {
		return this.txtedate;
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
	 * @return coblane
	 */
	public String getCoblane() {
		return this.coblane;
	}
	
	/**
	 * Column Info
	 * @return cobcapa
	 */
	public String getCobcapa() {
		return this.cobcapa;
	}
	
	/**
	 * Column Info
	 * @return crrcd
	 */
	public String getCrrcd() {
		return this.crrcd;
	}
	
	/**
	 * Column Info
	 * @return rdotype
	 */
	public String getRdotype() {
		return this.rdotype;
	}
	
	/**
	 * Column Info
	 * @return txtsdate
	 */
	public String getTxtsdate() {
		return this.txtsdate;
	}
	
	/**
	 * Column Info
	 * @return bsaopjbcd
	 */
	public String getBsaopjbcd() {
		return this.bsaopjbcd;
	}
	
	/**
	 * Column Info
	 * @return cobdir
	 */
	public String getCobdir() {
		return this.cobdir;
	}

	/**
	 * Column Info
	 * @return cobvop
	 */
	public String getCobvop() {
		return this.cobvop;
	}
	
	/**
	 * Column Info
	 * @return itrkey2
	 */
	public String getItrkey2() {
		return this.itrkey2;
	}
	
	/**
	 * Column Info
	 * @return itrkey1
	 */
	public String getItrkey1() {
		return this.itrkey1;
	}
	
	/**
	 * Column Info
	 * @return cobtrade
	 */
	public String getCobtrade() {
		return this.cobtrade;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Page Number
	 * @param header2
	 */
	public String getHeader2() {
		return header2;
	}
	
	/**
	 * Page Number
	 * @param rdotype2
	 */
	public String getRdotype2() {
		return rdotype2;
	}
	
	public String getPtrdcd() {
		return ptrdcd;
	}

	public void setPtrdcd(String ptrdcd) {
		this.ptrdcd = ptrdcd;
	}

	public String getPrlanecd() {
		return prlanecd;
	}

	public void setPrlanecd(String prlanecd) {
		this.prlanecd = prlanecd;
	}

	public String getPdircd() {
		return pdircd;
	}

	public void setPdircd(String pdircd) {
		this.pdircd = pdircd;
	}

	public String getPvopcd() {
		return pvopcd;
	}

	public void setPvopcd(String pvopcd) {
		this.pvopcd = pvopcd;
	}

	public String getPvslcapa() {
		return pvslcapa;
	}

	public void setPvslcapa(String pvslcapa) {
		this.pvslcapa = pvslcapa;
	}

	public String getPbsaseq() {
		return pbsaseq;
	}

	public void setPbsaseq(String pbsaseq) {
		this.pbsaseq = pbsaseq;
	}

	public String getPbsaopjbcd() {
		return pbsaopjbcd;
	}

	public void setPbsaopjbcd(String pbsaopjbcd) {
		this.pbsaopjbcd = pbsaopjbcd;
	}

	public String getPbsaopcd() {
		return pbsaopcd;
	}

	public void setPbsaopcd(String pbsaopcd) {
		this.pbsaopcd = pbsaopcd;
	}

	/**
	 * Column Info
	 * @param txtedate
	 */
	public void setTxtedate(String txtedate) {
		this.txtedate = txtedate;
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
	 * @param coblane
	 */
	public void setCoblane(String coblane) {
		this.coblane = coblane;
	}
	
	/**
	 * Column Info
	 * @param cobcapa
	 */
	public void setCobcapa(String cobcapa) {
		this.cobcapa = cobcapa;
	}
	
	/**
	 * Column Info
	 * @param crrcd
	 */
	public void setCrrcd(String crrcd) {
		this.crrcd = crrcd;
	}
	
	/**
	 * Column Info
	 * @param rdotype
	 */
	public void setRdotype(String rdotype) {
		this.rdotype = rdotype;
	}
	
	/**
	 * Column Info
	 * @param txtsdate
	 */
	public void setTxtsdate(String txtsdate) {
		this.txtsdate = txtsdate;
	}
	
	/**
	 * Column Info
	 * @param bsaopjbcd
	 */
	public void setBsaopjbcd(String bsaopjbcd) {
		this.bsaopjbcd = bsaopjbcd;
	}
	
	/**
	 * Column Info
	 * @param cobdir
	 */
	public void setCobdir(String cobdir) {
		this.cobdir = cobdir;
	}
	
	/**
	 * Column Info
	 * @param cobvop
	 */
	public void setCobvop(String cobvop) {
		this.cobvop = cobvop;
	}
	
	/**
	 * Column Info
	 * @param itrkey2
	 */
	public void setItrkey2(String itrkey2) {
		this.itrkey2 = itrkey2;
	}
	
	/**
	 * Column Info
	 * @param itrkey1
	 */
	public void setItrkey1(String itrkey1) {
		this.itrkey1 = itrkey1;
	}
	
	/**
	 * Column Info
	 * @param cobtrade
	 */
	public void setCobtrade(String cobtrade) {
		this.cobtrade = cobtrade;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Page Number
	 * @param header2
	 */
	public void setHeader2(String header2) {
		this.header2 = header2;
	}
	
	/**
	 * Page Number
	 * @param rdotype2
	 */
	public void setRdotype2(String rdotype2) {
		this.rdotype2 = rdotype2;
	}
	
	
	public String getPbsafmdt() {
		return pbsafmdt;
	}

	public void setPbsafmdt(String pbsafmdt) {
		this.pbsafmdt = pbsafmdt;
	}

	public String getPbsatodt() {
		return pbsatodt;
	}

	public void setPbsatodt(String pbsatodt) {
		this.pbsatodt = pbsatodt;
	}
	
	
	public String getJheader() {
		return jheader;
	}

	public void setJheader(String jheader) {
		this.jheader = jheader;
	}

	public String getSheader() {
		return sheader;
	}

	public void setSheader(String sheader) {
		this.sheader = sheader;
	}
	
	
	public String getRdoopcd() {
		return rdoopcd;
	}

	public void setRdoopcd(String rdoopcd) {
		this.rdoopcd = rdoopcd;
	}

	public String getRdoopjbcd() {
		return rdoopjbcd;
	}

	public void setRdoopjbcd(String rdoopjbcd) {
		this.rdoopjbcd = rdoopjbcd;
	}

	public String getRdoopjbcd2() {
		return rdoopjbcd2;
	}

	public void setRdoopjbcd2(String rdoopjbcd2) {
		this.rdoopjbcd2 = rdoopjbcd2;
	}
	
	
	public String getCobCarrier() {
		return cobCarrier;
	}
	
	
	public void setCobCarrier(String cobCarrier) {
		this.cobCarrier = cobCarrier;
	}
	
	
	public String getExcludVslCapa() {
		return excludVslCapa;
	}
	
	public void setExcludVslCapa(String excludVslCapa) {
		this.excludVslCapa = excludVslCapa;
	}
	
	
	public Collection<SearchBsaConditionVO> getModels() {
		return models;
	}

	public void setModels(Collection<SearchBsaConditionVO> models) {
		this.models = models;
	}

	public String getMBsaSeq() {
		return mBsaSeq;
	}

	public void setMBsaSeq(String bsaSeq) {
		mBsaSeq = bsaSeq;
	}

	public String getMTrdCd() {
		return mTrdCd;
	}

	public void setMTrdCd(String trdCd) {
		mTrdCd = trdCd;
	}

	public String getMRlaneCd() {
		return mRlaneCd;
	}

	public void setMRlaneCd(String rlaneCd) {
		mRlaneCd = rlaneCd;
	}

	public String getMDirCd() {
		return mDirCd;
	}

	public void setMDirCd(String dirCd) {
		mDirCd = dirCd;
	}

	public String getMVopCd() {
		return mVopCd;
	}

	public void setMVopCd(String vopCd) {
		mVopCd = vopCd;
	}
	
	
	public String getMVslSeq() {
		return mVslSeq;
	}

	public void setMVslSeq(String vslSeq) {
		mVslSeq = vslSeq;
	}

	public String getMVslCapa() {
		return mVslCapa;
	}

	public void setMVslCapa(String vslCapa) {
		mVslCapa = vslCapa;
	}

	public String getMBsaOpCd() {
		return mBsaOpCd;
	}

	public void setMBsaOpCd(String bsaOpCd) {
		mBsaOpCd = bsaOpCd;
	}

	public String getMBsaOpJbCd() {
		return mBsaOpJbCd;
	}

	public void setMBsaOpJbCd(String bsaOpJbCd) {
		mBsaOpJbCd = bsaOpJbCd;
	}

	public String getMCrrCd() {
		return mCrrCd;
	}

	public void setMCrrCd(String crrCd) {
		mCrrCd = crrCd;
	}
	
	public String getBsaopjbcd2() {
		return bsaopjbcd2;
	}
	
	public void setBsaopjbcd2(String bsaopjbcd2) {
		this.bsaopjbcd2 = bsaopjbcd2;
	}
	
	public String getCobcurr() {
		return cobcurr;
	}

	/*
	 * Column Info
	 * @param cobcurr
	 */
	public void setCobcurr(String cobcurr) {
		this.cobcurr = cobcurr;
	}

	/**
	 * Request ���곗씠�곕� 異붿텧�섏뿬 VO ��硫ㅻ쾭蹂�닔���ㅼ젙.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTxtsdate(JSPUtil.getParameter(request, "txtSDate", ""));
		setTxtedate(JSPUtil.getParameter(request, "txtEDate", ""));
		setCobtrade(JSPUtil.getParameter(request, "cobTrade", ""));
		setCoblane(JSPUtil.getParameter(request, "cobLane", ""));
		setCobcapa(JSPUtil.getParameter(request, "cobCapa", ""));
		setCobdir(JSPUtil.getParameter(request, "cobDir", ""));
		setCobvop(JSPUtil.getParameter(request, "cobVop", ""));
		setCobcurr(JSPUtil.getParameter(request, "cobCurr", ""));
		setItrkey2(JSPUtil.getParameter(request, "itrkey2", ""));
		setItrkey1(JSPUtil.getParameter(request, "itrkey1", ""));
		setRdoopcd(JSPUtil.getParameter(request, "rdoOp_cd", ""));
		setRdotype(JSPUtil.getParameter(request, "rdoType", ""));
		setRdotype2(JSPUtil.getParameter(request, "rdoType2", ""));
		setCobCarrier(JSPUtil.getParameter(request, "cobCarrier", ""));
		setExcludVslCapa(JSPUtil.getParameter(request, "excludVslCapa", ""));
		
		setCrrcd(JSPUtil.getParameter(request, "crr_cd", ""));
		setHeader2(JSPUtil.getParameter(request, "header2", ""));
		setJheader(JSPUtil.getParameter(request, "jHeader", ""));
		setSheader(JSPUtil.getParameter(request, "sHeader", ""));
		setBsaopjbcd(JSPUtil.getParameter(request, "bsa_op_jb_cd", ""));
		setBsaopjbcd2(JSPUtil.getParameter(request, "bsa_op_jb_cd2", ""));
		setRdoopjbcd(JSPUtil.getParameter(request, "rdoOp_jb_cd", ""));
		setRdoopjbcd2(JSPUtil.getParameter(request, "rdoOp_jb_cd2", ""));
		
		setPbsafmdt(JSPUtil.getParameter(request, "pBsa_fm_dt", ""));
		setPbsatodt(JSPUtil.getParameter(request, "pBsa_to_dt", ""));
		setPtrdcd(JSPUtil.getParameter(request, "pTrd_cd", ""));
		setPrlanecd(JSPUtil.getParameter(request, "pRlane_cd", ""));
		setPdircd(JSPUtil.getParameter(request, "pDir_cd", ""));
		setPvopcd(JSPUtil.getParameter(request, "pVop_cd", ""));
		setPvslcapa(JSPUtil.getParameter(request, "pVsl_capa", ""));
		setPbsaseq(JSPUtil.getParameter(request, "pBsa_seq", ""));
		setPbsaopjbcd(JSPUtil.getParameter(request, "pBsa_op_jb_cd", ""));
		setPbsaopcd(JSPUtil.getParameter(request, "pBsa_op_cd", ""));
		
		setMBsaSeq(JSPUtil.getParameter(request, 	"M_bsa_seq", ""));
		setMTrdCd(JSPUtil.getParameter(request,  	"M_trd_cd", ""));
		setMRlaneCd(JSPUtil.getParameter(request, 	"M_rlane_cd", ""));
		setMDirCd(JSPUtil.getParameter(request, 	"M_dir_cd", ""));
		setMVopCd(JSPUtil.getParameter(request, 	"M_vop_cd", ""));
		setMVslSeq(JSPUtil.getParameter(request, 	"M_vsl_seq", ""));
		setMVslCapa(JSPUtil.getParameter(request, 	"M_vsl_capa", ""));
		setMBsaOpCd(JSPUtil.getParameter(request, 	"M_bsa_op_cd", ""));
		setMBsaOpJbCd(JSPUtil.getParameter(request, "M_bsa_op_jb_cd", ""));
		setMCrrCd(JSPUtil.getParameter(request, 	"M_crr_cd", ""));
	}
	

		
		


	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return SearchSlotPrcConditionVO[]
	 */
	public SearchBsaConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗�� 
	 * @param request
	 * @param prefix
	 * @return SearchSlotPrcConditionVO[]
	 */
	public SearchBsaConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBsaConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] txtedate = (JSPUtil.getParameter(request, prefix	+ "txtedate", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] coblane = (JSPUtil.getParameter(request, prefix	+ "coblane", length));
			String[] cobcapa = (JSPUtil.getParameter(request, prefix	+ "cobcapa", length));
			String[] crrcd = (JSPUtil.getParameter(request, prefix	+ "crrcd", length));
			String[] rdotype = (JSPUtil.getParameter(request, prefix	+ "rdotype", length));
			String[] txtsdate = (JSPUtil.getParameter(request, prefix	+ "txtsdate", length));
			String[] bsaopjbcd = (JSPUtil.getParameter(request, prefix	+ "bsaopjbcd", length));
			String[] cobdir = (JSPUtil.getParameter(request, prefix	+ "cobdir", length));
			String[] cobvop = (JSPUtil.getParameter(request, prefix	+ "cobvop", length));
			String[] cobcurr = (JSPUtil.getParameter(request, prefix	+ "cobcurr", length));
			String[] itrkey2 = (JSPUtil.getParameter(request, prefix	+ "itrkey2", length));
			String[] itrkey1 = (JSPUtil.getParameter(request, prefix	+ "itrkey1", length));
			String[] cobtrade = (JSPUtil.getParameter(request, prefix	+ "cobtrade", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchBsaConditionVO();
				if (txtedate[i] != null)
					model.setTxtedate(txtedate[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (coblane[i] != null)
					model.setCoblane(coblane[i]);
				if (cobcapa[i] != null)
					model.setCobcapa(cobcapa[i]);
				if (crrcd[i] != null)
					model.setCrrcd(crrcd[i]);
				if (rdotype[i] != null)
					model.setRdotype(rdotype[i]);
				if (txtsdate[i] != null)
					model.setTxtsdate(txtsdate[i]);
				if (bsaopjbcd[i] != null)
					model.setBsaopjbcd(bsaopjbcd[i]);
				if (cobdir[i] != null)
					model.setCobdir(cobdir[i]);
				if (cobvop[i] != null)
					model.setCobvop(cobvop[i]);
				if (itrkey2[i] != null)
					model.setItrkey2(itrkey2[i]);
				if (itrkey1[i] != null)
					model.setItrkey1(itrkey1[i]);
				if (cobtrade[i] != null)
					model.setCobtrade(cobtrade[i]);
				if (cobcurr[i] != null)
					model.setCobcurr(cobcurr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSlotPrcConditionVOs();
	}

	/**
	 * VO 諛곗뿴��諛섑솚
	 * @return SearchSlotPrcConditionVO[]
	 */
	public SearchBsaConditionVO[] getSearchSlotPrcConditionVOs(){
		SearchBsaConditionVO[] vos = (SearchBsaConditionVO[])models.toArray(new SearchBsaConditionVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class���댁슜��String�쇰줈 蹂�솚
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * �꾨뱶���덈뒗 媛믪쓣 �ㅽ듃留�諛곗뿴濡�諛섑솚.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* �щ㎎�낅맂 臾몄옄�댁뿉���뱀닔臾몄옄 �쒓굅("-","/",",",":")
	*/ 
	public void unDataFormat(){
		this.txtedate = this.txtedate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coblane = this.coblane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cobcapa = this.cobcapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrcd = this.crrcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdotype = this.rdotype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txtsdate = this.txtsdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaopjbcd = this.bsaopjbcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cobdir = this.cobdir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cobvop = this.cobvop .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itrkey2 = this.itrkey2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itrkey1 = this.itrkey1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cobtrade = this.cobtrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cobcurr = this.cobcurr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

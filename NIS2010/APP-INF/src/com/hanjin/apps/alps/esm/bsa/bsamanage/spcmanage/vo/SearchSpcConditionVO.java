/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSpcConditionVO.java
*@FileTitle : SearchSpcConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.10.05 남궁진호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 남궁진호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSpcConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpcConditionVO> models = new ArrayList<SearchSpcConditionVO>();
	
	/* Column Info */
	private String rdoperf = null;
	/* Column Info */
	private String txttomonth = null;
	/* Column Info */
	private String sheetrlaneCd = null;
	/* Column Info */
	private String chkprd = null;
	/* Column Info */
	private String txttoweek = null;
	/* Column Info */
	private String sheetskdVoyNo = null;
	/* Column Info */
	private String txtdirCd = null;
	/* Column Info */
	private String sheetbsaOpJbCd = null;
	/* Column Info */
	private String sheetcrrCd = null;
	/* Column Info */
	private String cobtrade = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cobdir = null;
	/* Column Info */
	private String txtskdVoyNo = null;
	/* Column Info */
	private String sheettrdCd = null;
	/* Column Info */
	private String txtfmmonth = null;
	/* Column Info */
	private String rdocode = null;
	/* Column Info */
	private String cobcarrier = null;
	/* Column Info */
	private String sheetvslCd = null;
	/* Column Info */
	private String coblane = null;
	/* Column Info */
	private String sheetskdDirCd = null;
	/* Column Info */
	private String cobioc = null;
	/* Column Info */
	private String txtfmweek = null;
	/* Column Info */
	private String txtvslCd = null;
	/* Column Info */
	private String txtyear = null;
	/* Column Info */
	private String header = null;
	/* Column Info */
	private String rdoopjob = null;
	/* Column Info */
	private String isexcludzero = null;
	
	/************** ESM_BSA_0121 사용 Param ************/
	/* Column Info */
	private String pportEtdDt = null;
	/* Column Info */
	private String ptrdCd = null;
	/* Column Info */
	private String prlaneCd = null;
	/* Column Info */
	private String pvslCd = null;
	/* Column Info */
	private String pskdVoyNo = null;
	/* Column Info */
	private String pdirCd = null;
	/* Column Info */
	private String srow = null;
	/* Column Info */
	private String pbsaOpJbCd = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSpcConditionVO() {}

	public SearchSpcConditionVO(
			String ibflag, String pagerows, String txtyear, String txtfmmonth, 
			String txttomonth, String txtfmweek, String txttoweek, String chkprd, 
			String cobtrade, String coblane, String cobdir, String cobioc, 
			String txtvslCd, String txtskdVoyNo, String txtdirCd, String rdoperf, 
			String cobcarrier, String rdocode, String sheettrdCd, String sheetrlaneCd, 
			String sheetvslCd, String sheetskdVoyNo, String sheetskdDirCd, 
			String sheetbsaOpJbCd, String sheetcrrCd, String header, String rdoopjob,
			String pportEtdDt, String ptrdCd, String prlaneCd, String pvslCd, String pskdVoyNo,
			String pdirCd, String srow, String pbsaOpJbCd, String isexcludzero
			){
		this.rdoperf = rdoperf;
		this.txttomonth = txttomonth;
		this.sheetrlaneCd = sheetrlaneCd;
		this.chkprd = chkprd;
		this.txttoweek = txttoweek;
		this.sheetskdVoyNo = sheetskdVoyNo;
		this.txtdirCd = txtdirCd;
		this.sheetbsaOpJbCd = sheetbsaOpJbCd;
		this.sheetcrrCd = sheetcrrCd;
		this.cobtrade = cobtrade;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cobdir = cobdir;
		this.txtskdVoyNo = txtskdVoyNo;
		this.sheettrdCd = sheettrdCd;
		this.txtfmmonth = txtfmmonth;
		this.rdocode = rdocode;
		this.cobcarrier = cobcarrier;
		this.sheetvslCd = sheetvslCd;
		this.coblane = coblane;
		this.sheetskdDirCd = sheetskdDirCd;
		this.cobioc = cobioc;
		this.txtfmweek = txtfmweek;
		this.txtvslCd = txtvslCd;
		this.txtyear = txtyear;
		this.header = header;
		this.rdoopjob = rdoopjob;
		this.pportEtdDt = pportEtdDt;
		this.ptrdCd = ptrdCd;
		this.prlaneCd = prlaneCd;
		this.pvslCd = pvslCd;
		this.pskdVoyNo = pskdVoyNo;
		this.pdirCd = pdirCd;
		this.srow = srow;
		this.pbsaOpJbCd = pbsaOpJbCd;
		this.isexcludzero = isexcludzero;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rdoperf", getRdoperf());
		this.hashColumns.put("txttomonth", getTxttomonth());
		this.hashColumns.put("sheetrlane_cd", getSheetrlaneCd());
		this.hashColumns.put("chkprd", getChkprd());
		this.hashColumns.put("txttoweek", getTxttoweek());
		this.hashColumns.put("sheetskd_voy_no", getSheetskdVoyNo());
		this.hashColumns.put("txtdir_cd", getTxtdirCd());
		this.hashColumns.put("sheetbsa_op_jb_cd", getSheetbsaOpJbCd());
		this.hashColumns.put("sheetcrr_cd", getSheetcrrCd());
		this.hashColumns.put("cobtrade", getCobtrade());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cobdir", getCobdir());
		this.hashColumns.put("txtskd_voy_no", getTxtskdVoyNo());
		this.hashColumns.put("sheettrd_cd", getSheettrdCd());
		this.hashColumns.put("txtfmmonth", getTxtfmmonth());
		this.hashColumns.put("rdocode", getRdocode());
		this.hashColumns.put("cobcarrier", getCobcarrier());
		this.hashColumns.put("sheetvsl_cd", getSheetvslCd());
		this.hashColumns.put("coblane", getCoblane());
		this.hashColumns.put("sheetskd_dir_cd", getSheetskdDirCd());
		this.hashColumns.put("cobioc", getCobioc());
		this.hashColumns.put("txtfmweek", getTxtfmweek());
		this.hashColumns.put("txtvsl_cd", getTxtvslCd());
		this.hashColumns.put("txtyear", getTxtyear());
		this.hashColumns.put("header", getHeader());
		this.hashColumns.put("rdoopjob", getRdoopjob());
		
		this.hashColumns.put("ptrd_cd", getPtrdCd());
		this.hashColumns.put("prlane_cd", getPrlaneCd());
		this.hashColumns.put("pvsl_cd", getPvslCd());
		this.hashColumns.put("pskd_voy_no", getPskdVoyNo());
		this.hashColumns.put("pdir_cd", getPdirCd());
		this.hashColumns.put("srow", getSrow());
		this.hashColumns.put("pbsa_op_jb_cd", getPbsaOpJbCd());
		this.hashColumns.put("pport_etd_dt", getPportEtdDt());
		this.hashColumns.put("isExcludZero", getIsexcludzero());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rdoperf", "rdoperf");
		this.hashFields.put("txttomonth", "txttomonth");
		this.hashFields.put("sheetrlane_cd", "sheetrlaneCd");
		this.hashFields.put("chkprd", "chkprd");
		this.hashFields.put("txttoweek", "txttoweek");
		this.hashFields.put("sheetskd_voy_no", "sheetskdVoyNo");
		this.hashFields.put("txtdir_cd", "txtdirCd");
		this.hashFields.put("sheetbsa_op_jb_cd", "sheetbsaOpJbCd");
		this.hashFields.put("sheetcrr_cd", "sheetcrrCd");
		this.hashFields.put("cobtrade", "cobtrade");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cobdir", "cobdir");
		this.hashFields.put("txtskd_voy_no", "txtskdVoyNo");
		this.hashFields.put("sheettrd_cd", "sheettrdCd");
		this.hashFields.put("txtfmmonth", "txtfmmonth");
		this.hashFields.put("rdocode", "rdocode");
		this.hashFields.put("cobcarrier", "cobcarrier");
		this.hashFields.put("sheetvsl_cd", "sheetvslCd");
		this.hashFields.put("coblane", "coblane");
		this.hashFields.put("sheetskd_dir_cd", "sheetskdDirCd");
		this.hashFields.put("cobioc", "cobioc");
		this.hashFields.put("txtfmweek", "txtfmweek");
		this.hashFields.put("txtvsl_cd", "txtvslCd");
		this.hashFields.put("txtyear", "txtyear");
		this.hashFields.put("header", "header");
		this.hashFields.put("rdoopjob", "rdoopjob");
				
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rdoperf
	 */
	public String getRdoperf() {
		return this.rdoperf;
	}
	
	/**
	 * Column Info
	 * @return txttomonth
	 */
	public String getTxttomonth() {
		return this.txttomonth;
	}
	
	/**
	 * Column Info
	 * @return sheetrlaneCd
	 */
	public String getSheetrlaneCd() {
		return this.sheetrlaneCd;
	}
	
	/**
	 * Column Info
	 * @return chkprd
	 */
	public String getChkprd() {
		return this.chkprd;
	}
	
	/**
	 * Column Info
	 * @return txttoweek
	 */
	public String getTxttoweek() {
		return this.txttoweek;
	}
	
	/**
	 * Column Info
	 * @return sheetskdVoyNo
	 */
	public String getSheetskdVoyNo() {
		return this.sheetskdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return txtdirCd
	 */
	public String getTxtdirCd() {
		return this.txtdirCd;
	}
	
	/**
	 * Column Info
	 * @return sheetbsaOpJbCd
	 */
	public String getSheetbsaOpJbCd() {
		return this.sheetbsaOpJbCd;
	}
	
	/**
	 * Column Info
	 * @return sheetcrrCd
	 */
	public String getSheetcrrCd() {
		return this.sheetcrrCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return txtskdVoyNo
	 */
	public String getTxtskdVoyNo() {
		return this.txtskdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return sheettrdCd
	 */
	public String getSheettrdCd() {
		return this.sheettrdCd;
	}
	
	/**
	 * Column Info
	 * @return txtfmmonth
	 */
	public String getTxtfmmonth() {
		return this.txtfmmonth;
	}
	
	/**
	 * Column Info
	 * @return rdocode
	 */
	public String getRdocode() {
		return this.rdocode;
	}
	
	/**
	 * Column Info
	 * @return cobcarrier
	 */
	public String getCobcarrier() {
		return this.cobcarrier;
	}
	
	/**
	 * Column Info
	 * @return sheetvslCd
	 */
	public String getSheetvslCd() {
		return this.sheetvslCd;
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
	 * @return sheetskdDirCd
	 */
	public String getSheetskdDirCd() {
		return this.sheetskdDirCd;
	}
	
	/**
	 * Column Info
	 * @return cobioc
	 */
	public String getCobioc() {
		return this.cobioc;
	}
	
	/**
	 * Column Info
	 * @return txtfmweek
	 */
	public String getTxtfmweek() {
		return this.txtfmweek;
	}
	
	/**
	 * Column Info
	 * @return txtvslCd
	 */
	public String getTxtvslCd() {
		return this.txtvslCd;
	}
	
	/**
	 * Column Info
	 * @return txtyear
	 */
	public String getTxtyear() {
		return this.txtyear;
	}
	

	/**
	 * Column Info
	 * @return header
	 */
	public String getHeader() {
		return this.header;
	}
	
	
	/**
	 * Column Info
	 * @return rdoopjob
	 */
	public String getRdoopjob() {
		return this.rdoopjob;
	}
	
	
	/**
	 * Column Info
	 * @param rdoperf
	 */
	public void setRdoperf(String rdoperf) {
		this.rdoperf = rdoperf;
	}
	
	/**
	 * Column Info
	 * @param txttomonth
	 */
	public void setTxttomonth(String txttomonth) {
		this.txttomonth = txttomonth;
	}
	
	/**
	 * Column Info
	 * @param sheetrlaneCd
	 */
	public void setSheetrlaneCd(String sheetrlaneCd) {
		this.sheetrlaneCd = sheetrlaneCd;
	}
	
	/**
	 * Column Info
	 * @param chkprd
	 */
	public void setChkprd(String chkprd) {
		this.chkprd = chkprd;
	}
	
	/**
	 * Column Info
	 * @param txttoweek
	 */
	public void setTxttoweek(String txttoweek) {
		this.txttoweek = txttoweek;
	}
	
	/**
	 * Column Info
	 * @param sheetskdVoyNo
	 */
	public void setSheetskdVoyNo(String sheetskdVoyNo) {
		this.sheetskdVoyNo = sheetskdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param txtdirCd
	 */
	public void setTxtdirCd(String txtdirCd) {
		this.txtdirCd = txtdirCd;
	}
	
	/**
	 * Column Info
	 * @param sheetbsaOpJbCd
	 */
	public void setSheetbsaOpJbCd(String sheetbsaOpJbCd) {
		this.sheetbsaOpJbCd = sheetbsaOpJbCd;
	}
	
	/**
	 * Column Info
	 * @param sheetcrrCd
	 */
	public void setSheetcrrCd(String sheetcrrCd) {
		this.sheetcrrCd = sheetcrrCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param txtskdVoyNo
	 */
	public void setTxtskdVoyNo(String txtskdVoyNo) {
		this.txtskdVoyNo = txtskdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param sheettrdCd
	 */
	public void setSheettrdCd(String sheettrdCd) {
		this.sheettrdCd = sheettrdCd;
	}
	
	/**
	 * Column Info
	 * @param txtfmmonth
	 */
	public void setTxtfmmonth(String txtfmmonth) {
		this.txtfmmonth = txtfmmonth;
	}
	
	/**
	 * Column Info
	 * @param rdocode
	 */
	public void setRdocode(String rdocode) {
		this.rdocode = rdocode;
	}
	
	/**
	 * Column Info
	 * @param cobcarrier
	 */
	public void setCobcarrier(String cobcarrier) {
		this.cobcarrier = cobcarrier;
	}
	
	/**
	 * Column Info
	 * @param sheetvslCd
	 */
	public void setSheetvslCd(String sheetvslCd) {
		this.sheetvslCd = sheetvslCd;
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
	 * @param sheetskdDirCd
	 */
	public void setSheetskdDirCd(String sheetskdDirCd) {
		this.sheetskdDirCd = sheetskdDirCd;
	}
	
	/**
	 * Column Info
	 * @param cobioc
	 */
	public void setCobioc(String cobioc) {
		this.cobioc = cobioc;
	}
	
	/**
	 * Column Info
	 * @param txtfmweek
	 */
	public void setTxtfmweek(String txtfmweek) {
		this.txtfmweek = txtfmweek;
	}
	
	/**
	 * Column Info
	 * @param txtvslCd
	 */
	public void setTxtvslCd(String txtvslCd) {
		this.txtvslCd = txtvslCd;
	}
	
	
	/**
	 * Column Info
	 * @param txtyear
	 */
	public void setTxtyear(String txtyear) {
		this.txtyear = txtyear;
	}
	
	
	/**
	 * Column Info
	 * @param header
	 */
	public void setHeader(String header) {
		this.header = header;
	}
	
	
	/**
	 * Column Info
	 * @param rdoopjob
	 */
	public void setRdoopjob(String rdoopjob) {
		this.rdoopjob = rdoopjob;
	}
	
	public String getIsexcludzero() {
		return isexcludzero;
	}

	public void setIsexcludzero(String isexcludzero) {
		this.isexcludzero = isexcludzero;
	}

	/******************* ESM_BSA_0121 사용 Param ***************/
	public String getPportEtdDt() {
		return pportEtdDt;
	}

	public void setPportEtdDt(String pportEtdDt) {
		this.pportEtdDt = pportEtdDt;
	}

	public String getPtrdCd() {
		return ptrdCd;
	}

	public void setPtrdCd(String ptrdCd) {
		this.ptrdCd = ptrdCd;
	}

	public String getPrlaneCd() {
		return prlaneCd;
	}

	public void setPrlaneCd(String prlaneCd) {
		this.prlaneCd = prlaneCd;
	}

	public String getPvslCd() {
		return pvslCd;
	}

	public void setPvslCd(String pvslCd) {
		this.pvslCd = pvslCd;
	}

	public String getPskdVoyNo() {
		return pskdVoyNo;
	}

	public void setPskdVoyNo(String pskdVoyNo) {
		this.pskdVoyNo = pskdVoyNo;
	}

	public String getPdirCd() {
		return pdirCd;
	}

	public void setPdirCd(String pdirCd) {
		this.pdirCd = pdirCd;
	}

	public String getSrow() {
		return srow;
	}

	public void setSrow(String srow) {
		this.srow = srow;
	}

	public String getPbsaOpJbCd() {
		return pbsaOpJbCd;
	}

	public void setPbsaOpJbCd(String pbsaOpJbCd) {
		this.pbsaOpJbCd = pbsaOpJbCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		
		setChkprd(JSPUtil.getParameter(request, "chkPrd", ""));
		setTxtyear(JSPUtil.getParameter(request, "txtYear", ""));
		setTxtfmmonth(JSPUtil.getParameter(request, "txtFmMonth", ""));
		setTxttomonth(JSPUtil.getParameter(request, "txtToMonth", ""));
		setTxtfmweek(JSPUtil.getParameter(request, "txtFmWeek", ""));
		setTxttoweek(JSPUtil.getParameter(request, "txtToWeek", ""));
		
		setCobtrade(JSPUtil.getParameter(request, "cobTrade", ""));
		setCoblane(JSPUtil.getParameter(request, "cobLane", ""));
		setCobdir(JSPUtil.getParameter(request, "cobDir", ""));
		setCobcarrier(JSPUtil.getParameter(request, "cobCarrier", ""));
		setCobioc(JSPUtil.getParameter(request, "cobIOC", ""));
		
		setTxtvslCd(JSPUtil.getParameter(request, "txtVsl_cd", ""));		
		setTxtskdVoyNo(JSPUtil.getParameter(request, "txtSkd_voy_no", ""));
		setTxtdirCd(JSPUtil.getParameter(request, "txtDir_cd", ""));
		
		setRdoperf(JSPUtil.getParameter(request, "rdoPerf", ""));
		setRdocode(JSPUtil.getParameter(request, "rdoCode", ""));
		
		setIsexcludzero(JSPUtil.getParameter(request, "isExcludZero", ""));
		
		/******* ESM_BSA_0032 Detail 조회시 사용하는 Sheet Param *********************/
		setSheettrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setSheetrlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setSheetvslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSheetskdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSheetskdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setSheetbsaOpJbCd(JSPUtil.getParameter(request, "bsa_op_jb_cd", ""));
		setSheetcrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
		
		/************* ESM_BSA_0104 ****************************************/
		setRdoopjob(JSPUtil.getParameter(request, "rdoOpJob", ""));
		setHeader(JSPUtil.getParameter(request, "header", ""));
		
		/************* ESM_BSA_0121 ****************************************/
		setPportEtdDt(JSPUtil.getParameter(request, "pPort_etd_dt", ""));
		setPtrdCd(JSPUtil.getParameter(request, "pTrd_cd", ""));
		setPrlaneCd(JSPUtil.getParameter(request, "pRlane_cd", ""));
		setPvslCd(JSPUtil.getParameter(request, "pVsl_cd", ""));
		setPskdVoyNo(JSPUtil.getParameter(request, "pSkd_voy_no", ""));
		setPdirCd(JSPUtil.getParameter(request, "pDir_cd", ""));
		setSrow(JSPUtil.getParameter(request, "sRow", ""));
		setPbsaOpJbCd(JSPUtil.getParameter(request, "pBsa_op_jb_cd", ""));
	}

	

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpcConditionVO[]
	 */
	public SearchSpcConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpcConditionVO[]
	 */
	public SearchSpcConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpcConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rdoperf = (JSPUtil.getParameter(request, prefix	+ "rdoperf", length));
			String[] txttomonth = (JSPUtil.getParameter(request, prefix	+ "txttomonth", length));
			String[] sheetrlaneCd = (JSPUtil.getParameter(request, prefix	+ "sheetrlane_cd", length));
			String[] chkprd = (JSPUtil.getParameter(request, prefix	+ "chkprd", length));
			String[] txttoweek = (JSPUtil.getParameter(request, prefix	+ "txttoweek", length));
			String[] sheetskdVoyNo = (JSPUtil.getParameter(request, prefix	+ "sheetskd_voy_no", length));
			String[] txtdirCd = (JSPUtil.getParameter(request, prefix	+ "txtdir_cd", length));
			String[] sheetbsaOpJbCd = (JSPUtil.getParameter(request, prefix	+ "sheetbsa_op_jb_cd", length));
			String[] sheetcrrCd = (JSPUtil.getParameter(request, prefix	+ "sheetcrr_cd", length));
			String[] cobtrade = (JSPUtil.getParameter(request, prefix	+ "cobtrade", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cobdir = (JSPUtil.getParameter(request, prefix	+ "cobdir", length));
			String[] txtskdVoyNo = (JSPUtil.getParameter(request, prefix	+ "txtskd_voy_no", length));
			String[] sheettrdCd = (JSPUtil.getParameter(request, prefix	+ "sheettrd_cd", length));
			String[] txtfmmonth = (JSPUtil.getParameter(request, prefix	+ "txtfmmonth", length));
			String[] rdocode = (JSPUtil.getParameter(request, prefix	+ "rdocode", length));
			String[] cobcarrier = (JSPUtil.getParameter(request, prefix	+ "cobcarrier", length));
			String[] sheetvslCd = (JSPUtil.getParameter(request, prefix	+ "sheetvsl_cd", length));
			String[] coblane = (JSPUtil.getParameter(request, prefix	+ "coblane", length));
			String[] sheetskdDirCd = (JSPUtil.getParameter(request, prefix	+ "sheetskd_dir_cd", length));
			String[] cobioc = (JSPUtil.getParameter(request, prefix	+ "cobioc", length));
			String[] txtfmweek = (JSPUtil.getParameter(request, prefix	+ "txtfmweek", length));
			String[] txtvslCd = (JSPUtil.getParameter(request, prefix	+ "txtvsl_cd", length));
			String[] txtyear = (JSPUtil.getParameter(request, prefix	+ "txtyear", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpcConditionVO();
				if (rdoperf[i] != null)
					model.setRdoperf(rdoperf[i]);
				if (txttomonth[i] != null)
					model.setTxttomonth(txttomonth[i]);
				if (sheetrlaneCd[i] != null)
					model.setSheetrlaneCd(sheetrlaneCd[i]);
				if (chkprd[i] != null)
					model.setChkprd(chkprd[i]);
				if (txttoweek[i] != null)
					model.setTxttoweek(txttoweek[i]);
				if (sheetskdVoyNo[i] != null)
					model.setSheetskdVoyNo(sheetskdVoyNo[i]);
				if (txtdirCd[i] != null)
					model.setTxtdirCd(txtdirCd[i]);
				if (sheetbsaOpJbCd[i] != null)
					model.setSheetbsaOpJbCd(sheetbsaOpJbCd[i]);
				if (sheetcrrCd[i] != null)
					model.setSheetcrrCd(sheetcrrCd[i]);
				if (cobtrade[i] != null)
					model.setCobtrade(cobtrade[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cobdir[i] != null)
					model.setCobdir(cobdir[i]);
				if (txtskdVoyNo[i] != null)
					model.setTxtskdVoyNo(txtskdVoyNo[i]);
				if (sheettrdCd[i] != null)
					model.setSheettrdCd(sheettrdCd[i]);
				if (txtfmmonth[i] != null)
					model.setTxtfmmonth(txtfmmonth[i]);
				if (rdocode[i] != null)
					model.setRdocode(rdocode[i]);
				if (cobcarrier[i] != null)
					model.setCobcarrier(cobcarrier[i]);
				if (sheetvslCd[i] != null)
					model.setSheetvslCd(sheetvslCd[i]);
				if (coblane[i] != null)
					model.setCoblane(coblane[i]);
				if (sheetskdDirCd[i] != null)
					model.setSheetskdDirCd(sheetskdDirCd[i]);
				if (cobioc[i] != null)
					model.setCobioc(cobioc[i]);
				if (txtfmweek[i] != null)
					model.setTxtfmweek(txtfmweek[i]);
				if (txtvslCd[i] != null)
					model.setTxtvslCd(txtvslCd[i]);
				if (txtyear[i] != null)
					model.setTxtyear(txtyear[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpcConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpcConditionVO[]
	 */
	public SearchSpcConditionVO[] getSearchSpcConditionVOs(){
		SearchSpcConditionVO[] vos = (SearchSpcConditionVO[])models.toArray(new SearchSpcConditionVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
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
	 * 필드에 있는 값을 스트링 배열로 반환.
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
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.rdoperf = this.rdoperf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txttomonth = this.txttomonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetrlaneCd = this.sheetrlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkprd = this.chkprd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txttoweek = this.txttoweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetskdVoyNo = this.sheetskdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txtdirCd = this.txtdirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetbsaOpJbCd = this.sheetbsaOpJbCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetcrrCd = this.sheetcrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cobtrade = this.cobtrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cobdir = this.cobdir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txtskdVoyNo = this.txtskdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheettrdCd = this.sheettrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txtfmmonth = this.txtfmmonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdocode = this.rdocode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cobcarrier = this.cobcarrier .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetvslCd = this.sheetvslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coblane = this.coblane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetskdDirCd = this.sheetskdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cobioc = this.cobioc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txtfmweek = this.txtfmweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txtvslCd = this.txtvslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txtyear = this.txtyear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

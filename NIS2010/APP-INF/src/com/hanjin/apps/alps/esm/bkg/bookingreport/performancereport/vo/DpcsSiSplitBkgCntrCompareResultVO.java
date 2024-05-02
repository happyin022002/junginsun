/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DpcsSiSplitBkgCntrCompareResultVO.java
*@FileTitle : DpcsSiSplitBkgCntrCompareResultVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.03
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.06.03 김기종 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

import java.lang.reflect.Field;
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
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DpcsSiSplitBkgCntrCompareResultVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DpcsSiSplitBkgCntrCompareResultVO> models = new ArrayList<DpcsSiSplitBkgCntrCompareResultVO>();
	
	/* Column Info */
	private String cntrTotMasterCnt = null;
	/* Column Info */
	private String xterSndrId = null;
	/* Column Info */
	private String masterExistFlg = null;
	/* Column Info */
	private String dupSiRef = null;
	/* Column Info */
	private String cntrList = null;
	/* Column Info */
	private String matchFlg = null;
	/* Column Info */
	private String origin = null;
	/* Column Info */
	private String totSplistSiPartLoadCnt = null;
	/* Column Info */
	private String searchType = null;
	/* Column Info */
	private String shareVol = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sumColVal = null;
	/* Column Info */
	private String cntrTotSplitSiDistinctCnt = null;
	/* Column Info */
	private String cntrTotSplitSiAllCnt = null;
	/* Column Info */
	private String title = null;
	/* Column Info */
	private String num = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrDesc = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String esiExistFlg = null;
	/* Column Info */
	private String xterRqstSeq = null;
	/* Column Info */
	private String xterRqstNo = null;
	/* Column Info */
	private String partLoadCnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DpcsSiSplitBkgCntrCompareResultVO() {}

	public DpcsSiSplitBkgCntrCompareResultVO(String ibflag, String pagerows, String origin, String bkgNo, String xterSndrId, String xterRqstNo, String xterRqstSeq, String cntrNo, String shareVol, String matchFlg, String masterExistFlg, String esiExistFlg, String partLoadCnt, String dupSiRef, String cntrDesc, String cntrList, String searchType, String cntrTotMasterCnt, String cntrTotSplitSiAllCnt, String cntrTotSplitSiDistinctCnt, String totSplistSiPartLoadCnt, String sumColVal, String num, String title) {
		this.cntrTotMasterCnt = cntrTotMasterCnt;
		this.xterSndrId = xterSndrId;
		this.masterExistFlg = masterExistFlg;
		this.dupSiRef = dupSiRef;
		this.cntrList = cntrList;
		this.matchFlg = matchFlg;
		this.origin = origin;
		this.totSplistSiPartLoadCnt = totSplistSiPartLoadCnt;
		this.searchType = searchType;
		this.shareVol = shareVol;
		this.pagerows = pagerows;
		this.sumColVal = sumColVal;
		this.cntrTotSplitSiDistinctCnt = cntrTotSplitSiDistinctCnt;
		this.cntrTotSplitSiAllCnt = cntrTotSplitSiAllCnt;
		this.title = title;
		this.num = num;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.cntrDesc = cntrDesc;
		this.cntrNo = cntrNo;
		this.esiExistFlg = esiExistFlg;
		this.xterRqstSeq = xterRqstSeq;
		this.xterRqstNo = xterRqstNo;
		this.partLoadCnt = partLoadCnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_tot_master_cnt", getCntrTotMasterCnt());
		this.hashColumns.put("xter_sndr_id", getXterSndrId());
		this.hashColumns.put("master_exist_flg", getMasterExistFlg());
		this.hashColumns.put("dup_si_ref", getDupSiRef());
		this.hashColumns.put("cntr_list", getCntrList());
		this.hashColumns.put("match_flg", getMatchFlg());
		this.hashColumns.put("origin", getOrigin());
		this.hashColumns.put("tot_splist_si_part_load_cnt", getTotSplistSiPartLoadCnt());
		this.hashColumns.put("search_type", getSearchType());
		this.hashColumns.put("share_vol", getShareVol());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sum_col_val", getSumColVal());
		this.hashColumns.put("cntr_tot_split_si_distinct_cnt", getCntrTotSplitSiDistinctCnt());
		this.hashColumns.put("cntr_tot_split_si_all_cnt", getCntrTotSplitSiAllCnt());
		this.hashColumns.put("title", getTitle());
		this.hashColumns.put("num", getNum());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_desc", getCntrDesc());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("esi_exist_flg", getEsiExistFlg());
		this.hashColumns.put("xter_rqst_seq", getXterRqstSeq());
		this.hashColumns.put("xter_rqst_no", getXterRqstNo());
		this.hashColumns.put("part_load_cnt", getPartLoadCnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_tot_master_cnt", "cntrTotMasterCnt");
		this.hashFields.put("xter_sndr_id", "xterSndrId");
		this.hashFields.put("master_exist_flg", "masterExistFlg");
		this.hashFields.put("dup_si_ref", "dupSiRef");
		this.hashFields.put("cntr_list", "cntrList");
		this.hashFields.put("match_flg", "matchFlg");
		this.hashFields.put("origin", "origin");
		this.hashFields.put("tot_splist_si_part_load_cnt", "totSplistSiPartLoadCnt");
		this.hashFields.put("search_type", "searchType");
		this.hashFields.put("share_vol", "shareVol");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sum_col_val", "sumColVal");
		this.hashFields.put("cntr_tot_split_si_distinct_cnt", "cntrTotSplitSiDistinctCnt");
		this.hashFields.put("cntr_tot_split_si_all_cnt", "cntrTotSplitSiAllCnt");
		this.hashFields.put("title", "title");
		this.hashFields.put("num", "num");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_desc", "cntrDesc");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("esi_exist_flg", "esiExistFlg");
		this.hashFields.put("xter_rqst_seq", "xterRqstSeq");
		this.hashFields.put("xter_rqst_no", "xterRqstNo");
		this.hashFields.put("part_load_cnt", "partLoadCnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrTotMasterCnt
	 */
	public String getCntrTotMasterCnt() {
		return this.cntrTotMasterCnt;
	}
	
	/**
	 * Column Info
	 * @return xterSndrId
	 */
	public String getXterSndrId() {
		return this.xterSndrId;
	}
	
	/**
	 * Column Info
	 * @return masterExistFlg
	 */
	public String getMasterExistFlg() {
		return this.masterExistFlg;
	}
	
	/**
	 * Column Info
	 * @return dupSiRef
	 */
	public String getDupSiRef() {
		return this.dupSiRef;
	}
	
	/**
	 * Column Info
	 * @return cntrList
	 */
	public String getCntrList() {
		return this.cntrList;
	}
	
	/**
	 * Column Info
	 * @return matchFlg
	 */
	public String getMatchFlg() {
		return this.matchFlg;
	}
	
	/**
	 * Column Info
	 * @return origin
	 */
	public String getOrigin() {
		return this.origin;
	}
	
	/**
	 * Column Info
	 * @return totSplistSiPartLoadCnt
	 */
	public String getTotSplistSiPartLoadCnt() {
		return this.totSplistSiPartLoadCnt;
	}
	
	/**
	 * Column Info
	 * @return searchType
	 */
	public String getSearchType() {
		return this.searchType;
	}
	
	/**
	 * Column Info
	 * @return shareVol
	 */
	public String getShareVol() {
		return this.shareVol;
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
	 * @return sumColVal
	 */
	public String getSumColVal() {
		return this.sumColVal;
	}
	
	/**
	 * Column Info
	 * @return cntrTotSplitSiDistinctCnt
	 */
	public String getCntrTotSplitSiDistinctCnt() {
		return this.cntrTotSplitSiDistinctCnt;
	}
	
	/**
	 * Column Info
	 * @return cntrTotSplitSiAllCnt
	 */
	public String getCntrTotSplitSiAllCnt() {
		return this.cntrTotSplitSiAllCnt;
	}
	
	/**
	 * Column Info
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Column Info
	 * @return num
	 */
	public String getNum() {
		return this.num;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return cntrDesc
	 */
	public String getCntrDesc() {
		return this.cntrDesc;
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
	 * @return esiExistFlg
	 */
	public String getEsiExistFlg() {
		return this.esiExistFlg;
	}
	
	/**
	 * Column Info
	 * @return xterRqstSeq
	 */
	public String getXterRqstSeq() {
		return this.xterRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return xterRqstNo
	 */
	public String getXterRqstNo() {
		return this.xterRqstNo;
	}
	
	/**
	 * Column Info
	 * @return partLoadCnt
	 */
	public String getPartLoadCnt() {
		return this.partLoadCnt;
	}
	

	/**
	 * Column Info
	 * @param cntrTotMasterCnt
	 */
	public void setCntrTotMasterCnt(String cntrTotMasterCnt) {
		this.cntrTotMasterCnt = cntrTotMasterCnt;
	}
	
	/**
	 * Column Info
	 * @param xterSndrId
	 */
	public void setXterSndrId(String xterSndrId) {
		this.xterSndrId = xterSndrId;
	}
	
	/**
	 * Column Info
	 * @param masterExistFlg
	 */
	public void setMasterExistFlg(String masterExistFlg) {
		this.masterExistFlg = masterExistFlg;
	}
	
	/**
	 * Column Info
	 * @param dupSiRef
	 */
	public void setDupSiRef(String dupSiRef) {
		this.dupSiRef = dupSiRef;
	}
	
	/**
	 * Column Info
	 * @param cntrList
	 */
	public void setCntrList(String cntrList) {
		this.cntrList = cntrList;
	}
	
	/**
	 * Column Info
	 * @param matchFlg
	 */
	public void setMatchFlg(String matchFlg) {
		this.matchFlg = matchFlg;
	}
	
	/**
	 * Column Info
	 * @param origin
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	/**
	 * Column Info
	 * @param totSplistSiPartLoadCnt
	 */
	public void setTotSplistSiPartLoadCnt(String totSplistSiPartLoadCnt) {
		this.totSplistSiPartLoadCnt = totSplistSiPartLoadCnt;
	}
	
	/**
	 * Column Info
	 * @param searchType
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
	/**
	 * Column Info
	 * @param shareVol
	 */
	public void setShareVol(String shareVol) {
		this.shareVol = shareVol;
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
	 * @param sumColVal
	 */
	public void setSumColVal(String sumColVal) {
		this.sumColVal = sumColVal;
	}
	
	/**
	 * Column Info
	 * @param cntrTotSplitSiDistinctCnt
	 */
	public void setCntrTotSplitSiDistinctCnt(String cntrTotSplitSiDistinctCnt) {
		this.cntrTotSplitSiDistinctCnt = cntrTotSplitSiDistinctCnt;
	}
	
	/**
	 * Column Info
	 * @param cntrTotSplitSiAllCnt
	 */
	public void setCntrTotSplitSiAllCnt(String cntrTotSplitSiAllCnt) {
		this.cntrTotSplitSiAllCnt = cntrTotSplitSiAllCnt;
	}
	
	/**
	 * Column Info
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Column Info
	 * @param num
	 */
	public void setNum(String num) {
		this.num = num;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param cntrDesc
	 */
	public void setCntrDesc(String cntrDesc) {
		this.cntrDesc = cntrDesc;
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
	 * @param esiExistFlg
	 */
	public void setEsiExistFlg(String esiExistFlg) {
		this.esiExistFlg = esiExistFlg;
	}
	
	/**
	 * Column Info
	 * @param xterRqstSeq
	 */
	public void setXterRqstSeq(String xterRqstSeq) {
		this.xterRqstSeq = xterRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param xterRqstNo
	 */
	public void setXterRqstNo(String xterRqstNo) {
		this.xterRqstNo = xterRqstNo;
	}
	
	/**
	 * Column Info
	 * @param partLoadCnt
	 */
	public void setPartLoadCnt(String partLoadCnt) {
		this.partLoadCnt = partLoadCnt;
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
		setCntrTotMasterCnt(JSPUtil.getParameter(request, prefix + "cntr_tot_master_cnt", ""));
		setXterSndrId(JSPUtil.getParameter(request, prefix + "xter_sndr_id", ""));
		setMasterExistFlg(JSPUtil.getParameter(request, prefix + "master_exist_flg", ""));
		setDupSiRef(JSPUtil.getParameter(request, prefix + "dup_si_ref", ""));
		setCntrList(JSPUtil.getParameter(request, prefix + "cntr_list", ""));
		setMatchFlg(JSPUtil.getParameter(request, prefix + "match_flg", ""));
		setOrigin(JSPUtil.getParameter(request, prefix + "origin", ""));
		setTotSplistSiPartLoadCnt(JSPUtil.getParameter(request, prefix + "tot_splist_si_part_load_cnt", ""));
		setSearchType(JSPUtil.getParameter(request, prefix + "search_type", ""));
		setShareVol(JSPUtil.getParameter(request, prefix + "share_vol", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSumColVal(JSPUtil.getParameter(request, prefix + "sum_col_val", ""));
		setCntrTotSplitSiDistinctCnt(JSPUtil.getParameter(request, prefix + "cntr_tot_split_si_distinct_cnt", ""));
		setCntrTotSplitSiAllCnt(JSPUtil.getParameter(request, prefix + "cntr_tot_split_si_all_cnt", ""));
		setTitle(JSPUtil.getParameter(request, prefix + "title", ""));
		setNum(JSPUtil.getParameter(request, prefix + "num", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCntrDesc(JSPUtil.getParameter(request, prefix + "cntr_desc", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setEsiExistFlg(JSPUtil.getParameter(request, prefix + "esi_exist_flg", ""));
		setXterRqstSeq(JSPUtil.getParameter(request, prefix + "xter_rqst_seq", ""));
		setXterRqstNo(JSPUtil.getParameter(request, prefix + "xter_rqst_no", ""));
		setPartLoadCnt(JSPUtil.getParameter(request, prefix + "part_load_cnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DpcsSiSplitBkgCntrCompareResultVO[]
	 */
	public DpcsSiSplitBkgCntrCompareResultVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DpcsSiSplitBkgCntrCompareResultVO[]
	 */
	public DpcsSiSplitBkgCntrCompareResultVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DpcsSiSplitBkgCntrCompareResultVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrTotMasterCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_tot_master_cnt", length));
			String[] xterSndrId = (JSPUtil.getParameter(request, prefix	+ "xter_sndr_id", length));
			String[] masterExistFlg = (JSPUtil.getParameter(request, prefix	+ "master_exist_flg", length));
			String[] dupSiRef = (JSPUtil.getParameter(request, prefix	+ "dup_si_ref", length));
			String[] cntrList = (JSPUtil.getParameter(request, prefix	+ "cntr_list", length));
			String[] matchFlg = (JSPUtil.getParameter(request, prefix	+ "match_flg", length));
			String[] origin = (JSPUtil.getParameter(request, prefix	+ "origin", length));
			String[] totSplistSiPartLoadCnt = (JSPUtil.getParameter(request, prefix	+ "tot_splist_si_part_load_cnt", length));
			String[] searchType = (JSPUtil.getParameter(request, prefix	+ "search_type", length));
			String[] shareVol = (JSPUtil.getParameter(request, prefix	+ "share_vol", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sumColVal = (JSPUtil.getParameter(request, prefix	+ "sum_col_val", length));
			String[] cntrTotSplitSiDistinctCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_tot_split_si_distinct_cnt", length));
			String[] cntrTotSplitSiAllCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_tot_split_si_all_cnt", length));
			String[] title = (JSPUtil.getParameter(request, prefix	+ "title", length));
			String[] num = (JSPUtil.getParameter(request, prefix	+ "num", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_desc", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] esiExistFlg = (JSPUtil.getParameter(request, prefix	+ "esi_exist_flg", length));
			String[] xterRqstSeq = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_seq", length));
			String[] xterRqstNo = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_no", length));
			String[] partLoadCnt = (JSPUtil.getParameter(request, prefix	+ "part_load_cnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new DpcsSiSplitBkgCntrCompareResultVO();
				if (cntrTotMasterCnt[i] != null)
					model.setCntrTotMasterCnt(cntrTotMasterCnt[i]);
				if (xterSndrId[i] != null)
					model.setXterSndrId(xterSndrId[i]);
				if (masterExistFlg[i] != null)
					model.setMasterExistFlg(masterExistFlg[i]);
				if (dupSiRef[i] != null)
					model.setDupSiRef(dupSiRef[i]);
				if (cntrList[i] != null)
					model.setCntrList(cntrList[i]);
				if (matchFlg[i] != null)
					model.setMatchFlg(matchFlg[i]);
				if (origin[i] != null)
					model.setOrigin(origin[i]);
				if (totSplistSiPartLoadCnt[i] != null)
					model.setTotSplistSiPartLoadCnt(totSplistSiPartLoadCnt[i]);
				if (searchType[i] != null)
					model.setSearchType(searchType[i]);
				if (shareVol[i] != null)
					model.setShareVol(shareVol[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sumColVal[i] != null)
					model.setSumColVal(sumColVal[i]);
				if (cntrTotSplitSiDistinctCnt[i] != null)
					model.setCntrTotSplitSiDistinctCnt(cntrTotSplitSiDistinctCnt[i]);
				if (cntrTotSplitSiAllCnt[i] != null)
					model.setCntrTotSplitSiAllCnt(cntrTotSplitSiAllCnt[i]);
				if (title[i] != null)
					model.setTitle(title[i]);
				if (num[i] != null)
					model.setNum(num[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrDesc[i] != null)
					model.setCntrDesc(cntrDesc[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (esiExistFlg[i] != null)
					model.setEsiExistFlg(esiExistFlg[i]);
				if (xterRqstSeq[i] != null)
					model.setXterRqstSeq(xterRqstSeq[i]);
				if (xterRqstNo[i] != null)
					model.setXterRqstNo(xterRqstNo[i]);
				if (partLoadCnt[i] != null)
					model.setPartLoadCnt(partLoadCnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDpcsSiSplitBkgCntrCompareResultVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DpcsSiSplitBkgCntrCompareResultVO[]
	 */
	public DpcsSiSplitBkgCntrCompareResultVO[] getDpcsSiSplitBkgCntrCompareResultVOs(){
		DpcsSiSplitBkgCntrCompareResultVO[] vos = (DpcsSiSplitBkgCntrCompareResultVO[])models.toArray(new DpcsSiSplitBkgCntrCompareResultVO[models.size()]);
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
		this.cntrTotMasterCnt = this.cntrTotMasterCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterSndrId = this.xterSndrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masterExistFlg = this.masterExistFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dupSiRef = this.dupSiRef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrList = this.cntrList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.matchFlg = this.matchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.origin = this.origin .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSplistSiPartLoadCnt = this.totSplistSiPartLoadCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchType = this.searchType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shareVol = this.shareVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumColVal = this.sumColVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTotSplitSiDistinctCnt = this.cntrTotSplitSiDistinctCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTotSplitSiAllCnt = this.cntrTotSplitSiAllCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.title = this.title .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.num = this.num .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDesc = this.cntrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.esiExistFlg = this.esiExistFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstSeq = this.xterRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstNo = this.xterRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partLoadCnt = this.partLoadCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

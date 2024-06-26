/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : SearchMonthlyQuotaInquiryListVO.java
*@FileTitle      : SearchMonthlyQuotaInquiryListVO
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author Choi.M.C
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMonthlyQuotaInquiryListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMonthlyQuotaInquiryListVO> models = new ArrayList<SearchMonthlyQuotaInquiryListVO>();
	
	/* Column Info */
	private String val01 = null;
	/* Column Info */
	private String val02 = null;
	/* Column Info */
	private String val00 = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String val03 = null;
	/* Column Info */
	private String slevel = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String convDirCd = null;
	/* Column Info */
	private String rowSeq = null;
	/* Column Info */
	private String item = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String itemText = null;
	/* Column Info */
	private String aqCd = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String key = null;
	/* Column Info */
	private String ofcCd2 = null;
	/* Column Info */
	private String ofcCd1 = null;
	/* Column Info */
	private String val = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String bseWk = null;
	/* Page Number */
	private String vvdCd = null;
	/* Column Info */
	private String vvdGrpCd = null;
	/* Column Info */
	private String ofcCd = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMonthlyQuotaInquiryListVO() {}

	public SearchMonthlyQuotaInquiryListVO(String ibflag, String pagerows, String slevel, String dirCd, String rhqCd, String aqCd, String subTrdCd, String rlaneCd, String convDirCd, String rowSeq, String itemText, String item, String val00, String val01, String val02, String val03, String key,String ofcCd1,String ofcCd2,String val,String bseYr,String bseWk,String vvdCd,String vvdGrpCd,String ofcCd,String trdCd) {
		this.val01 = val01;
		this.val02 = val02;
		this.val00 = val00;
		this.rhqCd = rhqCd;
		this.val03 = val03;
		this.slevel = slevel;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.convDirCd = convDirCd;
		this.rowSeq = rowSeq;
		this.item = item;
		this.dirCd = dirCd;
		this.itemText = itemText;
		this.aqCd = aqCd;
		this.subTrdCd = subTrdCd;
		this.key = key;
		this.ofcCd1 = ofcCd1;
		this.ofcCd2 = ofcCd2;
		this.val = val;
		this.bseYr = bseYr;
		this.bseWk = bseWk;
		this.vvdCd = vvdCd;
		this.vvdGrpCd = vvdGrpCd;
		this.ofcCd = ofcCd;
		this.trdCd = trdCd;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("val_01", getVal01());
		this.hashColumns.put("val_02", getVal02());
		this.hashColumns.put("val_00", getVal00());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("val_03", getVal03());
		this.hashColumns.put("slevel", getSlevel());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("conv_dir_cd", getConvDirCd());
		this.hashColumns.put("row_seq", getRowSeq());
		this.hashColumns.put("item", getItem());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("item_text", getItemText());
		this.hashColumns.put("aq_cd", getAqCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("key", getKey());
		this.hashColumns.put("ofc_cd_2", getOfcCd2());
		this.hashColumns.put("ofc_cd_1", getOfcCd1());
		this.hashColumns.put("val", getVal());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("bse_wk", getBseWk());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("vvd_grp_cd", getVvdGrpCd());
		this.hashColumns.put("ofc_cd", getOfcCd());	
		this.hashColumns.put("trd_cd", getTrdCd());	
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("val_01", "val01");
		this.hashFields.put("val_02", "val02");
		this.hashFields.put("val_00", "val00");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("val_03", "val03");
		this.hashFields.put("slevel", "slevel");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("conv_dir_cd", "convDirCd");
		this.hashFields.put("row_seq", "rowSeq");
		this.hashFields.put("item", "item");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("item_text", "itemText");
		this.hashFields.put("aq_cd", "aqCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("key", "key");
		this.hashFields.put("ofc_cd_2", "ofcCd2");
		this.hashFields.put("ofc_cd_1", "ofcCd1");
		this.hashFields.put("val", "val");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("bse_wk", "bseWk");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("vvd_grp_cd", "vvdGrpCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("trd_cd", "trdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return val01
	 */
	public String getVal01() {
		return this.val01;
	}
	
	/**
	 * Column Info
	 * @return val02
	 */
	public String getVal02() {
		return this.val02;
	}
	
	/**
	 * Column Info
	 * @return val00
	 */
	public String getVal00() {
		return this.val00;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return val03
	 */
	public String getVal03() {
		return this.val03;
	}
	
	/**
	 * Column Info
	 * @return slevel
	 */
	public String getSlevel() {
		return this.slevel;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @return convDirCd
	 */
	public String getConvDirCd() {
		return this.convDirCd;
	}
	
	/**
	 * Column Info
	 * @return rowSeq
	 */
	public String getRowSeq() {
		return this.rowSeq;
	}
	
	/**
	 * Column Info
	 * @return item
	 */
	public String getItem() {
		return this.item;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return itemText
	 */
	public String getItemText() {
		return this.itemText;
	}
	
	/**
	 * Column Info
	 * @return aqCd
	 */
	public String getAqCd() {
		return this.aqCd;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd2
	 */
	public String getOfcCd2() {
		return ofcCd2;
	}
	
	/**
	 * Column Info
	 * @param ofcCd2
	 */
	public void setOfcCd2(String ofcCd2) {
		this.ofcCd2 = ofcCd2;
	}
	
	/**
	 * Column Info
	 * @return ofcCd1
	 */
	public String getOfcCd1() {
		return ofcCd1;
	}
	
	/**
	 * Column Info
	 * @param ofcCd1
	 */
	public void setOfcCd1(String ofcCd1) {
		this.ofcCd1 = ofcCd1;
	}
	
	/**
	 * Column Info
	 * @return bseYr
	 */
	public String getBseYr() {
		return bseYr;
	}
	
	/**
	 * Column Info
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
	}
	
	/**
	 * Column Info
	 * @return vvdGrpCd
	 */
	public String getVvdGrpCd() {
		return vvdGrpCd;
	}
	
	/**
	 * Column Info
	 * @param vvdGrpCd
	 */
	public void setVvdGrpCd(String vvdGrpCd) {
		this.vvdGrpCd = vvdGrpCd;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return trdCd;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @return key
	 */
	public String getKey() {
		return key;
	}
	
	/**
	 * Column Info
	 * @param key
	 */
	public void setKey(String key) {
		this.key = key;
	}
	
	/**
	 * Column Info
	 * @return val
	 */
	public String getVal() {
		return val;
	}
	
	/**
	 * Column Info
	 * @param val
	 */
	public void setVal(String val) {
		this.val = val;
	}
	
	/**
	 * Column Info
	 * @return bseWk
	 */
	public String getBseWk() {
		return bseWk;
	}
	
	/**
	 * Column Info
	 * @param bseWk
	 */
	public void setBseWk(String bseWk) {
		this.bseWk = bseWk;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return vvdCd;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return ofcCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	/**
	 * Column Info
	 * @param val01
	 */
	public void setVal01(String val01) {
		this.val01 = val01;
	}
	
	/**
	 * Column Info
	 * @param val02
	 */
	public void setVal02(String val02) {
		this.val02 = val02;
	}
	
	/**
	 * Column Info
	 * @param val00
	 */
	public void setVal00(String val00) {
		this.val00 = val00;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param val03
	 */
	public void setVal03(String val03) {
		this.val03 = val03;
	}
	
	/**
	 * Column Info
	 * @param slevel
	 */
	public void setSlevel(String slevel) {
		this.slevel = slevel;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param convDirCd
	 */
	public void setConvDirCd(String convDirCd) {
		this.convDirCd = convDirCd;
	}
	
	/**
	 * Column Info
	 * @param rowSeq
	 */
	public void setRowSeq(String rowSeq) {
		this.rowSeq = rowSeq;
	}
	
	/**
	 * Column Info
	 * @param item
	 */
	public void setItem(String item) {
		this.item = item;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param itemText
	 */
	public void setItemText(String itemText) {
		this.itemText = itemText;
	}
	
	/**
	 * Column Info
	 * @param aqCd
	 */
	public void setAqCd(String aqCd) {
		this.aqCd = aqCd;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVal01(JSPUtil.getParameter(request, "val_01", ""));
		setVal02(JSPUtil.getParameter(request, "val_02", ""));
		setVal00(JSPUtil.getParameter(request, "val_00", ""));
		setRhqCd(JSPUtil.getParameter(request, "rhq_cd", ""));
		setVal03(JSPUtil.getParameter(request, "val_03", ""));
		setSlevel(JSPUtil.getParameter(request, "slevel", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setConvDirCd(JSPUtil.getParameter(request, "conv_dir_cd", ""));
		setRowSeq(JSPUtil.getParameter(request, "row_seq", ""));
		setItem(JSPUtil.getParameter(request, "item", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setItemText(JSPUtil.getParameter(request, "item_text", ""));
		setAqCd(JSPUtil.getParameter(request, "aq_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
		setKey(JSPUtil.getParameter(request, "key", ""));
		setOfcCd2(JSPUtil.getParameter(request, "ofc_cd_2", ""));
		setOfcCd1(JSPUtil.getParameter(request, "ofc_cd_1", ""));
		setVal(JSPUtil.getParameter(request, "val", ""));
		setBseYr(JSPUtil.getParameter(request, "bse_yr", ""));
		setBseWk(JSPUtil.getParameter(request, "bse_wk", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setVvdGrpCd(JSPUtil.getParameter(request, "vvd_grp_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMonthlyQuotaInquiry0088Tab03ChildVO[]
	 */
	public SearchMonthlyQuotaInquiryListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMonthlyQuotaInquiry0088Tab03ChildVO[]
	 */
	public SearchMonthlyQuotaInquiryListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMonthlyQuotaInquiryListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] val01 = (JSPUtil.getParameter(request, prefix	+ "val_01", length));
			String[] val02 = (JSPUtil.getParameter(request, prefix	+ "val_02", length));
			String[] val00 = (JSPUtil.getParameter(request, prefix	+ "val_00", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] val03 = (JSPUtil.getParameter(request, prefix	+ "val_03", length));
			String[] slevel = (JSPUtil.getParameter(request, prefix	+ "slevel", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] convDirCd = (JSPUtil.getParameter(request, prefix	+ "conv_dir_cd", length));
			String[] rowSeq = (JSPUtil.getParameter(request, prefix	+ "row_seq", length));
			String[] item = (JSPUtil.getParameter(request, prefix	+ "item", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] itemText = (JSPUtil.getParameter(request, prefix	+ "item_text", length));
			String[] aqCd = (JSPUtil.getParameter(request, prefix	+ "aq_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] key = (JSPUtil.getParameter(request, prefix	+ "key", length));
			String[] val = (JSPUtil.getParameter(request, prefix	+ "val", length));
			String[] ofcCd2 = (JSPUtil.getParameter(request, prefix	+ "ofc_cd_2", length));
			String[] ofcCd1 = (JSPUtil.getParameter(request, prefix	+ "ofc_cd_1", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] bseWk = (JSPUtil.getParameter(request, prefix	+ "bse_wk", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] vvdGrpCd = (JSPUtil.getParameter(request, prefix	+ "vvd_grp_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMonthlyQuotaInquiryListVO();
				if (val01[i] != null)
					model.setVal01(val01[i]);
				if (val02[i] != null)
					model.setVal02(val02[i]);
				if (val00[i] != null)
					model.setVal00(val00[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (val03[i] != null)
					model.setVal03(val03[i]);
				if (slevel[i] != null)
					model.setSlevel(slevel[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (convDirCd[i] != null)
					model.setConvDirCd(convDirCd[i]);
				if (rowSeq[i] != null)
					model.setRowSeq(rowSeq[i]);
				if (item[i] != null)
					model.setItem(item[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (itemText[i] != null)
					model.setItemText(itemText[i]);
				if (aqCd[i] != null)
					model.setAqCd(aqCd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (key[i] != null)
					model.setKey(key[i]);
				if (val[i] != null)
					model.setVal(val[i]);
				if (ofcCd2[i] != null)
					model.setOfcCd2(ofcCd2[i]);
				if (ofcCd1[i] != null)
					model.setOfcCd1(ofcCd1[i]);
				if (bseWk[i] != null)
					model.setBseWk(bseWk[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (vvdGrpCd[i] != null)
					model.setVvdGrpCd(vvdGrpCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMonthlyQuotaInquiry0088Tab03ChildVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMonthlyQuotaInquiry0088Tab03ChildVO[]
	 */
	public SearchMonthlyQuotaInquiryListVO[] getSearchMonthlyQuotaInquiry0088Tab03ChildVOs(){
		SearchMonthlyQuotaInquiryListVO[] vos = (SearchMonthlyQuotaInquiryListVO[])models.toArray(new SearchMonthlyQuotaInquiryListVO[models.size()]);
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
		this.val01 = this.val01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.val02 = this.val02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.val00 = this.val00 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.val03 = this.val03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slevel = this.slevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convDirCd = this.convDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowSeq = this.rowSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.item = this.item .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemText = this.itemText .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aqCd = this.aqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.key = this.key .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.val = this.val .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd2 = this.ofcCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd1 = this.ofcCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseWk = this.bseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdGrpCd = this.vvdGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

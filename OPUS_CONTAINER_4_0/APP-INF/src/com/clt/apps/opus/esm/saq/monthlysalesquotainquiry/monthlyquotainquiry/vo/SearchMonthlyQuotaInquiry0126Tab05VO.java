/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : SearchMonthlyQuotaInquiry0126Tab05VO.java
*@FileTitle      : SearchMonthlyQuotaInquiry0126Tab05VO
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김종호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMonthlyQuotaInquiry0126Tab05VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMonthlyQuotaInquiry0126Tab05VO> models = new ArrayList<SearchMonthlyQuotaInquiry0126Tab05VO>();
	
	/* Column Info */
	private String val = null;
	/* Column Info */
	private String ofcCd2 = null;
	/* Column Info */
	private String ofcCd1 = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String slevel = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String bseWk = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rowSeq = null;
	/* Column Info */
	private String convDirCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String item = null;
	/* Column Info */
	private String vvdGrpCd = null;
	/* Column Info */
	private String itemText = null;
	/* Column Info */
	private String aqCd = null;
	/* Column Info */
	private String key = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String val00 = null;
	/* Column Info */
	private String val01 = null;
	/* Column Info */
	private String val02 = null;
	/* Column Info */
	private String val03 = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String from_wk = null;
	/* Column Info */
	private String to_wk = null;
	/* Column Info */
	private String vvd_grp_cd = null;
	/* Column Info */
	private String bse_wk = null;
	/* Column Info */
	private String vvd_cd = null;
	/* Column Info */
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMonthlyQuotaInquiry0126Tab05VO() {}

	public SearchMonthlyQuotaInquiry0126Tab05VO(String ibflag, String pagerows, String key, String slevel, String bseYr, String bseWk, 
			String subTrdCd, String rlaneCd, String convDirCd, String vvdGrpCd, String vvdCd, String rhqCd, String aqCd, String ofcCd1, 
			String ofcCd2, String rowSeq, String itemText, String item, String val, String val00, String val01, String val02, String val03, 
			String lane, String from_wk, String to_wk, String vvd_grp_cd, String bse_wk, String vvd_cd) {
		
		this.val = val;
		this.ofcCd2 = ofcCd2;
		this.ofcCd1 = ofcCd1;
		this.rhqCd = rhqCd;
		this.slevel = slevel;
		this.bseYr = bseYr;
		this.rlaneCd = rlaneCd;
		this.bseWk = bseWk;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.rowSeq = rowSeq;
		this.convDirCd = convDirCd;
		this.vvdCd = vvdCd;
		this.item = item;
		this.vvdGrpCd = vvdGrpCd;
		this.itemText = itemText;
		this.aqCd = aqCd;
		this.key = key;
		this.subTrdCd = subTrdCd;
		this.val00 = val00;
		this.val01 = val01;
		this.val02 = val02;
		this.val03 = val03;
		this.lane = lane;
		this.from_wk = from_wk;
		this.to_wk = to_wk;
		this.vvd_grp_cd = vvd_grp_cd;
		this.bse_wk = bse_wk;
		this.vvd_cd = vvd_cd;
		
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("val", getVal());
		this.hashColumns.put("ofc_cd_1", getOfcCd1());
		this.hashColumns.put("ofc_cd_2", getOfcCd2());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("slevel", getSlevel());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("bse_wk", getBseWk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("row_seq", getRowSeq());
		this.hashColumns.put("conv_dir_cd", getConvDirCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("item", getItem());
		this.hashColumns.put("vvd_grp_cd", getVvdGrpCd());
		this.hashColumns.put("item_text", getItemText());
		this.hashColumns.put("aq_cd", getAqCd());
		this.hashColumns.put("key", getKey());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("val_00", getVal00());
		this.hashColumns.put("val_01", getVal01());
		this.hashColumns.put("val_02", getVal02());
		this.hashColumns.put("val_03", getVal03());
		this.hashColumns.put("row_seq", getRowSeq());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("from_wk", getFrom_wk());
		this.hashColumns.put("to_wk", getTo_wk());
		
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("val", "val");
		this.hashFields.put("val_00", "val00");
		this.hashFields.put("val_01", "val01");
		this.hashFields.put("val_02", "val02");
		this.hashFields.put("val_03", "val03");
		this.hashFields.put("ofc_cd_1", "ofcCd1");
		this.hashFields.put("ofc_cd_2", "ofcCd2");		
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("slevel", "slevel");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("bse_wk", "bseWk");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("row_seq", "rowSeq");
		this.hashFields.put("conv_dir_cd", "convDirCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("item", "item");
		this.hashFields.put("vvd_grp_cd", "vvdGrpCd");
		this.hashFields.put("item_text", "itemText");
		this.hashFields.put("aq_cd", "aqCd");
		this.hashFields.put("key", "key");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("from_wk", "from_wk");
		this.hashFields.put("to_wk", "to_wk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return val
	 */
	public String getVal() {
		return this.val;
	}
	
	/**
	 * Column Info
	 * @return ofcCd2
	 */
	public String getOfcCd2() {
		return this.ofcCd2;
	}
	
	/**
	 * Column Info
	 * @return ofcCd1
	 */
	public String getOfcCd1() {
		return this.ofcCd1;
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
	 * @return slevel
	 */
	public String getSlevel() {
		return this.slevel;
	}
	
	/**
	 * Column Info
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return bseWk
	 */
	public String getBseWk() {
		return this.bseWk;
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
	 * @return rowSeq
	 */
	public String getRowSeq() {
		return this.rowSeq;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
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
	 * @return vvdGrpCd
	 */
	public String getVvdGrpCd() {
		return this.vvdGrpCd;
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
	 * @return key
	 */
	public String getKey() {
		return this.key;
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
	 * @param val
	 */
	public void setVal(String val) {
		this.val = val;
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
	 * @param ofcCd1
	 */
	public void setOfcCd1(String ofcCd1) {
		this.ofcCd1 = ofcCd1;
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
	 * @param slevel
	 */
	public void setSlevel(String slevel) {
		this.slevel = slevel;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param bseWk
	 */
	public void setBseWk(String bseWk) {
		this.bseWk = bseWk;
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
	 * @param rowSeq
	 */
	public void setRowSeq(String rowSeq) {
		this.rowSeq = rowSeq;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
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
	 * @param vvdGrpCd
	 */
	public void setVvdGrpCd(String vvdGrpCd) {
		this.vvdGrpCd = vvdGrpCd;
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
	 * @param key
	 */
	public void setKey(String key) {
		this.key = key;
	}
	
	
	public String getVal00() {
		return val00;
	}

	public void setVal00(String val00) {
		this.val00 = val00;
	}

	public String getVal01() {
		return val01;
	}

	public void setVal01(String val01) {
		this.val01 = val01;
	}

	public String getVal02() {
		return val02;
	}

	public void setVal02(String val02) {
		this.val02 = val02;
	}

	public String getVal03() {
		return val03;
	}

	public void setVal03(String val03) {
		this.val03 = val03;
	}

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

	public String getFrom_wk() {
		return from_wk;
	}

	public void setFrom_wk(String from_wk) {
		this.from_wk = from_wk;
	}

	public String getTo_wk() {
		return to_wk;
	}

	public void setTo_wk(String to_wk) {
		this.to_wk = to_wk;
	}

	public String getVvd_grp_cd() {
		return vvd_grp_cd;
	}

	public void setVvd_grp_cd(String vvd_grp_cd) {
		this.vvd_grp_cd = vvd_grp_cd;
	}

	public String getBse_wk() {
		return bse_wk;
	}

	public void setBse_wk(String bse_wk) {
		this.bse_wk = bse_wk;
	}

	public String getVvd_cd() {
		return vvd_cd;
	}

	public void setVvd_cd(String vvd_cd) {
		this.vvd_cd = vvd_cd;
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
		setVal(JSPUtil.getParameter(request, "val", ""));
		setVal00(JSPUtil.getParameter(request, "val_00", ""));
		setVal01(JSPUtil.getParameter(request, "val_01", ""));
		setVal02(JSPUtil.getParameter(request, "val_02", ""));
		setVal03(JSPUtil.getParameter(request, "val_03", ""));
		setOfcCd2(JSPUtil.getParameter(request, "ofc_cd_2", ""));
		setOfcCd1(JSPUtil.getParameter(request, "ofc_cd_1", ""));
		setRhqCd(JSPUtil.getParameter(request, "rhq_cd", ""));
		setSlevel(JSPUtil.getParameter(request, "slevel", ""));
		setBseYr(JSPUtil.getParameter(request, "bse_yr", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setBseWk(JSPUtil.getParameter(request, "bse_wk", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRowSeq(JSPUtil.getParameter(request, "row_seq", ""));
		setConvDirCd(JSPUtil.getParameter(request, "conv_dir_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setItem(JSPUtil.getParameter(request, "item", ""));
		setVvdGrpCd(JSPUtil.getParameter(request, "vvd_grp_cd", ""));
		setItemText(JSPUtil.getParameter(request, "item_text", ""));
		setAqCd(JSPUtil.getParameter(request, "aq_cd", ""));
		setKey(JSPUtil.getParameter(request, "key", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
		setFrom_wk(JSPUtil.getParameter(request, "from_wk", ""));
		setTo_wk(JSPUtil.getParameter(request, "to_wk", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMonthlyQuotaInquiry0126Tab05VO[]
	 */
	public SearchMonthlyQuotaInquiry0126Tab05VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMonthlyQuotaInquiry0126Tab05VO[]
	 */
	public SearchMonthlyQuotaInquiry0126Tab05VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMonthlyQuotaInquiry0126Tab05VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] val = (JSPUtil.getParameter(request, prefix	+ "val", length));
			String[] ofcCd2 = (JSPUtil.getParameter(request, prefix	+ "ofc_cd_2", length));
			String[] ofcCd1 = (JSPUtil.getParameter(request, prefix	+ "ofc_cd_1", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] slevel = (JSPUtil.getParameter(request, prefix	+ "slevel", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] bseWk = (JSPUtil.getParameter(request, prefix	+ "bse_wk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rowSeq = (JSPUtil.getParameter(request, prefix	+ "row_seq", length));
			String[] convDirCd = (JSPUtil.getParameter(request, prefix	+ "conv_dir_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] item = (JSPUtil.getParameter(request, prefix	+ "item", length));
			String[] vvdGrpCd = (JSPUtil.getParameter(request, prefix	+ "vvd_grp_cd", length));
			String[] itemText = (JSPUtil.getParameter(request, prefix	+ "item_text", length));
			String[] aqCd = (JSPUtil.getParameter(request, prefix	+ "aq_cd", length));
			String[] key = (JSPUtil.getParameter(request, prefix	+ "key", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMonthlyQuotaInquiry0126Tab05VO();
				if (val[i] != null)
					model.setVal(val[i]);
				if (ofcCd2[i] != null)
					model.setOfcCd2(ofcCd2[i]);
				if (ofcCd1[i] != null)
					model.setOfcCd1(ofcCd1[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (slevel[i] != null)
					model.setSlevel(slevel[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (bseWk[i] != null)
					model.setBseWk(bseWk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rowSeq[i] != null)
					model.setRowSeq(rowSeq[i]);
				if (convDirCd[i] != null)
					model.setConvDirCd(convDirCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (item[i] != null)
					model.setItem(item[i]);
				if (vvdGrpCd[i] != null)
					model.setVvdGrpCd(vvdGrpCd[i]);
				if (itemText[i] != null)
					model.setItemText(itemText[i]);
				if (aqCd[i] != null)
					model.setAqCd(aqCd[i]);
				if (key[i] != null)
					model.setKey(key[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMonthlyQuotaInquiry0126Tab05VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMonthlyQuotaInquiry0126Tab05VO[]
	 */
	public SearchMonthlyQuotaInquiry0126Tab05VO[] getSearchMonthlyQuotaInquiry0126Tab05VOs(){
		SearchMonthlyQuotaInquiry0126Tab05VO[] vos = (SearchMonthlyQuotaInquiry0126Tab05VO[])models.toArray(new SearchMonthlyQuotaInquiry0126Tab05VO[models.size()]);
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
		this.val = this.val .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd2 = this.ofcCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd1 = this.ofcCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slevel = this.slevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseWk = this.bseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowSeq = this.rowSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convDirCd = this.convDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.item = this.item .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdGrpCd = this.vvdGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemText = this.itemText .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aqCd = this.aqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.key = this.key .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

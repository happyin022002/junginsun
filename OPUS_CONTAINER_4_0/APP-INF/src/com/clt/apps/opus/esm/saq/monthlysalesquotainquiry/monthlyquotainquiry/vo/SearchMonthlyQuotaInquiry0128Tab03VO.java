/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : SearchMonthlyQuotaInquiry0128Tab03VO.java
*@FileTitle      : SearchMonthlyQuotaInquiry0128Tab03VO
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo;

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
 * @author 김종호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMonthlyQuotaInquiry0128Tab03VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMonthlyQuotaInquiry0128Tab03VO> models = new ArrayList<SearchMonthlyQuotaInquiry0128Tab03VO>();
	
	/* Column Info */
	private String val = null;
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
	/* Column Info */
	private String ofcCd = null;
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

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMonthlyQuotaInquiry0128Tab03VO() {}

	public SearchMonthlyQuotaInquiry0128Tab03VO(String ibflag, String pagerows, String key, String slevel, String bseYr, String bseWk, String subTrdCd, String rlaneCd, String convDirCd, String vvdGrpCd, String vvdCd, String rhqCd, String aqCd, String ofcCd, String rowSeq, String itemText, String item, String val) {
		this.val = val;
		this.rhqCd = rhqCd;
		this.slevel = slevel;
		this.bseYr = bseYr;
		this.rlaneCd = rlaneCd;
		this.bseWk = bseWk;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
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
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("val", getVal());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("slevel", getSlevel());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("bse_wk", getBseWk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
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
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("val", "val");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("slevel", "slevel");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("bse_wk", "bseWk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
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
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
		setRhqCd(JSPUtil.getParameter(request, "rhq_cd", ""));
		setSlevel(JSPUtil.getParameter(request, "slevel", ""));
		setBseYr(JSPUtil.getParameter(request, "bse_yr", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setBseWk(JSPUtil.getParameter(request, "bse_wk", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
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
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMonthlyQuotaInquiry0128Tab03VO[]
	 */
	public SearchMonthlyQuotaInquiry0128Tab03VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMonthlyQuotaInquiry0128Tab03VO[]
	 */
	public SearchMonthlyQuotaInquiry0128Tab03VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMonthlyQuotaInquiry0128Tab03VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] val = (JSPUtil.getParameter(request, prefix	+ "val", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] slevel = (JSPUtil.getParameter(request, prefix	+ "slevel", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] bseWk = (JSPUtil.getParameter(request, prefix	+ "bse_wk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
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
				model = new SearchMonthlyQuotaInquiry0128Tab03VO();
				if (val[i] != null)
					model.setVal(val[i]);
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
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
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
		return getSearchMonthlyQuotaInquiry0128Tab03VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMonthlyQuotaInquiry0128Tab03VO[]
	 */
	public SearchMonthlyQuotaInquiry0128Tab03VO[] getSearchMonthlyQuotaInquiry0128Tab03VOs(){
		SearchMonthlyQuotaInquiry0128Tab03VO[] vos = (SearchMonthlyQuotaInquiry0128Tab03VO[])models.toArray(new SearchMonthlyQuotaInquiry0128Tab03VO[models.size()]);
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
		this.val = this.val .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slevel = this.slevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseWk = this.bseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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

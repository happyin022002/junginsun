/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SheetSettingInfoListVO.java
*@FileTitle : SheetSettingInfoListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.10.01 문중철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

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
 * @author 문중철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SheetSettingInfoListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SheetSettingInfoListVO> models = new ArrayList<SheetSettingInfoListVO>();
	
	/* Column Info */
	private String foot01 = null;
	/* Column Info */
	private String ofad01 = null;
	/* Column Info */
	private String ofad03 = null;
	/* Column Info */
	private String ofad02 = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String foot04 = null;
	/* Column Info */
	private String foot05 = null;
	/* Column Info */
	private String foot02 = null;
	/* Column Info */
	private String foot03 = null;
	/* Column Info */
	private String foot08 = null;
	/* Column Info */
	private String foot09 = null;
	/* Column Info */
	private String foot06 = null;
	/* Column Info */
	private String foot07 = null;
	/* Column Info */
	private String head04 = null;
	/* Column Info */
	private String head05 = null;
	/* Column Info */
	private String head06 = null;
	/* Column Info */
	private String head07 = null;
	/* Column Info */
	private String head01 = null;
	/* Column Info */
	private String foot14 = null;
	/* Column Info */
	private String head02 = null;
	/* Column Info */
	private String foot13 = null;
	/* Column Info */
	private String head03 = null;
	/* Column Info */
	private String head08 = null;
	/* Column Info */
	private String head09 = null;
	/* Column Info */
	private String foot11 = null;
	/* Column Info */
	private String foot12 = null;
	/* Column Info */
	private String head10 = null;
	/* Column Info */
	private String foot10 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SheetSettingInfoListVO() {}

	public SheetSettingInfoListVO(String ibflag, String pagerows, String ofad01, String ofad02, String ofad03, String head01, String head02, String head03, String head04, String head05, String head06, String head07, String head08, String head09, String head10, String foot01, String foot02, String foot03, String foot04, String foot05, String foot06, String foot07, String foot08, String foot09, String foot10, String foot11, String foot12, String foot13, String foot14) {
		this.foot01 = foot01;
		this.ofad01 = ofad01;
		this.ofad03 = ofad03;
		this.ofad02 = ofad02;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.foot04 = foot04;
		this.foot05 = foot05;
		this.foot02 = foot02;
		this.foot03 = foot03;
		this.foot08 = foot08;
		this.foot09 = foot09;
		this.foot06 = foot06;
		this.foot07 = foot07;
		this.head04 = head04;
		this.head05 = head05;
		this.head06 = head06;
		this.head07 = head07;
		this.head01 = head01;
		this.foot14 = foot14;
		this.head02 = head02;
		this.foot13 = foot13;
		this.head03 = head03;
		this.head08 = head08;
		this.head09 = head09;
		this.foot11 = foot11;
		this.foot12 = foot12;
		this.head10 = head10;
		this.foot10 = foot10;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("foot01", getFoot01());
		this.hashColumns.put("ofad01", getOfad01());
		this.hashColumns.put("ofad03", getOfad03());
		this.hashColumns.put("ofad02", getOfad02());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("foot04", getFoot04());
		this.hashColumns.put("foot05", getFoot05());
		this.hashColumns.put("foot02", getFoot02());
		this.hashColumns.put("foot03", getFoot03());
		this.hashColumns.put("foot08", getFoot08());
		this.hashColumns.put("foot09", getFoot09());
		this.hashColumns.put("foot06", getFoot06());
		this.hashColumns.put("foot07", getFoot07());
		this.hashColumns.put("head04", getHead04());
		this.hashColumns.put("head05", getHead05());
		this.hashColumns.put("head06", getHead06());
		this.hashColumns.put("head07", getHead07());
		this.hashColumns.put("head01", getHead01());
		this.hashColumns.put("foot14", getFoot14());
		this.hashColumns.put("head02", getHead02());
		this.hashColumns.put("foot13", getFoot13());
		this.hashColumns.put("head03", getHead03());
		this.hashColumns.put("head08", getHead08());
		this.hashColumns.put("head09", getHead09());
		this.hashColumns.put("foot11", getFoot11());
		this.hashColumns.put("foot12", getFoot12());
		this.hashColumns.put("head10", getHead10());
		this.hashColumns.put("foot10", getFoot10());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("foot01", "foot01");
		this.hashFields.put("ofad01", "ofad01");
		this.hashFields.put("ofad03", "ofad03");
		this.hashFields.put("ofad02", "ofad02");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("foot04", "foot04");
		this.hashFields.put("foot05", "foot05");
		this.hashFields.put("foot02", "foot02");
		this.hashFields.put("foot03", "foot03");
		this.hashFields.put("foot08", "foot08");
		this.hashFields.put("foot09", "foot09");
		this.hashFields.put("foot06", "foot06");
		this.hashFields.put("foot07", "foot07");
		this.hashFields.put("head04", "head04");
		this.hashFields.put("head05", "head05");
		this.hashFields.put("head06", "head06");
		this.hashFields.put("head07", "head07");
		this.hashFields.put("head01", "head01");
		this.hashFields.put("foot14", "foot14");
		this.hashFields.put("head02", "head02");
		this.hashFields.put("foot13", "foot13");
		this.hashFields.put("head03", "head03");
		this.hashFields.put("head08", "head08");
		this.hashFields.put("head09", "head09");
		this.hashFields.put("foot11", "foot11");
		this.hashFields.put("foot12", "foot12");
		this.hashFields.put("head10", "head10");
		this.hashFields.put("foot10", "foot10");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return foot01
	 */
	public String getFoot01() {
		return this.foot01;
	}
	
	/**
	 * Column Info
	 * @return ofad01
	 */
	public String getOfad01() {
		return this.ofad01;
	}
	
	/**
	 * Column Info
	 * @return ofad03
	 */
	public String getOfad03() {
		return this.ofad03;
	}
	
	/**
	 * Column Info
	 * @return ofad02
	 */
	public String getOfad02() {
		return this.ofad02;
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
	 * @return foot04
	 */
	public String getFoot04() {
		return this.foot04;
	}
	
	/**
	 * Column Info
	 * @return foot05
	 */
	public String getFoot05() {
		return this.foot05;
	}
	
	/**
	 * Column Info
	 * @return foot02
	 */
	public String getFoot02() {
		return this.foot02;
	}
	
	/**
	 * Column Info
	 * @return foot03
	 */
	public String getFoot03() {
		return this.foot03;
	}
	
	/**
	 * Column Info
	 * @return foot08
	 */
	public String getFoot08() {
		return this.foot08;
	}
	
	/**
	 * Column Info
	 * @return foot09
	 */
	public String getFoot09() {
		return this.foot09;
	}
	
	/**
	 * Column Info
	 * @return foot06
	 */
	public String getFoot06() {
		return this.foot06;
	}
	
	/**
	 * Column Info
	 * @return foot07
	 */
	public String getFoot07() {
		return this.foot07;
	}
	
	/**
	 * Column Info
	 * @return head04
	 */
	public String getHead04() {
		return this.head04;
	}
	
	/**
	 * Column Info
	 * @return head05
	 */
	public String getHead05() {
		return this.head05;
	}
	
	/**
	 * Column Info
	 * @return head06
	 */
	public String getHead06() {
		return this.head06;
	}
	
	/**
	 * Column Info
	 * @return head07
	 */
	public String getHead07() {
		return this.head07;
	}
	
	/**
	 * Column Info
	 * @return head01
	 */
	public String getHead01() {
		return this.head01;
	}
	
	/**
	 * Column Info
	 * @return foot14
	 */
	public String getFoot14() {
		return this.foot14;
	}
	
	/**
	 * Column Info
	 * @return head02
	 */
	public String getHead02() {
		return this.head02;
	}
	
	/**
	 * Column Info
	 * @return foot13
	 */
	public String getFoot13() {
		return this.foot13;
	}
	
	/**
	 * Column Info
	 * @return head03
	 */
	public String getHead03() {
		return this.head03;
	}
	
	/**
	 * Column Info
	 * @return head08
	 */
	public String getHead08() {
		return this.head08;
	}
	
	/**
	 * Column Info
	 * @return head09
	 */
	public String getHead09() {
		return this.head09;
	}
	
	/**
	 * Column Info
	 * @return foot11
	 */
	public String getFoot11() {
		return this.foot11;
	}
	
	/**
	 * Column Info
	 * @return foot12
	 */
	public String getFoot12() {
		return this.foot12;
	}
	
	/**
	 * Column Info
	 * @return head10
	 */
	public String getHead10() {
		return this.head10;
	}
	
	/**
	 * Column Info
	 * @return foot10
	 */
	public String getFoot10() {
		return this.foot10;
	}
	

	/**
	 * Column Info
	 * @param foot01
	 */
	public void setFoot01(String foot01) {
		this.foot01 = foot01;
	}
	
	/**
	 * Column Info
	 * @param ofad01
	 */
	public void setOfad01(String ofad01) {
		this.ofad01 = ofad01;
	}
	
	/**
	 * Column Info
	 * @param ofad03
	 */
	public void setOfad03(String ofad03) {
		this.ofad03 = ofad03;
	}
	
	/**
	 * Column Info
	 * @param ofad02
	 */
	public void setOfad02(String ofad02) {
		this.ofad02 = ofad02;
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
	 * @param foot04
	 */
	public void setFoot04(String foot04) {
		this.foot04 = foot04;
	}
	
	/**
	 * Column Info
	 * @param foot05
	 */
	public void setFoot05(String foot05) {
		this.foot05 = foot05;
	}
	
	/**
	 * Column Info
	 * @param foot02
	 */
	public void setFoot02(String foot02) {
		this.foot02 = foot02;
	}
	
	/**
	 * Column Info
	 * @param foot03
	 */
	public void setFoot03(String foot03) {
		this.foot03 = foot03;
	}
	
	/**
	 * Column Info
	 * @param foot08
	 */
	public void setFoot08(String foot08) {
		this.foot08 = foot08;
	}
	
	/**
	 * Column Info
	 * @param foot09
	 */
	public void setFoot09(String foot09) {
		this.foot09 = foot09;
	}
	
	/**
	 * Column Info
	 * @param foot06
	 */
	public void setFoot06(String foot06) {
		this.foot06 = foot06;
	}
	
	/**
	 * Column Info
	 * @param foot07
	 */
	public void setFoot07(String foot07) {
		this.foot07 = foot07;
	}
	
	/**
	 * Column Info
	 * @param head04
	 */
	public void setHead04(String head04) {
		this.head04 = head04;
	}
	
	/**
	 * Column Info
	 * @param head05
	 */
	public void setHead05(String head05) {
		this.head05 = head05;
	}
	
	/**
	 * Column Info
	 * @param head06
	 */
	public void setHead06(String head06) {
		this.head06 = head06;
	}
	
	/**
	 * Column Info
	 * @param head07
	 */
	public void setHead07(String head07) {
		this.head07 = head07;
	}
	
	/**
	 * Column Info
	 * @param head01
	 */
	public void setHead01(String head01) {
		this.head01 = head01;
	}
	
	/**
	 * Column Info
	 * @param foot14
	 */
	public void setFoot14(String foot14) {
		this.foot14 = foot14;
	}
	
	/**
	 * Column Info
	 * @param head02
	 */
	public void setHead02(String head02) {
		this.head02 = head02;
	}
	
	/**
	 * Column Info
	 * @param foot13
	 */
	public void setFoot13(String foot13) {
		this.foot13 = foot13;
	}
	
	/**
	 * Column Info
	 * @param head03
	 */
	public void setHead03(String head03) {
		this.head03 = head03;
	}
	
	/**
	 * Column Info
	 * @param head08
	 */
	public void setHead08(String head08) {
		this.head08 = head08;
	}
	
	/**
	 * Column Info
	 * @param head09
	 */
	public void setHead09(String head09) {
		this.head09 = head09;
	}
	
	/**
	 * Column Info
	 * @param foot11
	 */
	public void setFoot11(String foot11) {
		this.foot11 = foot11;
	}
	
	/**
	 * Column Info
	 * @param foot12
	 */
	public void setFoot12(String foot12) {
		this.foot12 = foot12;
	}
	
	/**
	 * Column Info
	 * @param head10
	 */
	public void setHead10(String head10) {
		this.head10 = head10;
	}
	
	/**
	 * Column Info
	 * @param foot10
	 */
	public void setFoot10(String foot10) {
		this.foot10 = foot10;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFoot01(JSPUtil.getParameter(request, "foot01", ""));
		setOfad01(JSPUtil.getParameter(request, "ofad01", ""));
		setOfad03(JSPUtil.getParameter(request, "ofad03", ""));
		setOfad02(JSPUtil.getParameter(request, "ofad02", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFoot04(JSPUtil.getParameter(request, "foot04", ""));
		setFoot05(JSPUtil.getParameter(request, "foot05", ""));
		setFoot02(JSPUtil.getParameter(request, "foot02", ""));
		setFoot03(JSPUtil.getParameter(request, "foot03", ""));
		setFoot08(JSPUtil.getParameter(request, "foot08", ""));
		setFoot09(JSPUtil.getParameter(request, "foot09", ""));
		setFoot06(JSPUtil.getParameter(request, "foot06", ""));
		setFoot07(JSPUtil.getParameter(request, "foot07", ""));
		setHead04(JSPUtil.getParameter(request, "head04", ""));
		setHead05(JSPUtil.getParameter(request, "head05", ""));
		setHead06(JSPUtil.getParameter(request, "head06", ""));
		setHead07(JSPUtil.getParameter(request, "head07", ""));
		setHead01(JSPUtil.getParameter(request, "head01", ""));
		setFoot14(JSPUtil.getParameter(request, "foot14", ""));
		setHead02(JSPUtil.getParameter(request, "head02", ""));
		setFoot13(JSPUtil.getParameter(request, "foot13", ""));
		setHead03(JSPUtil.getParameter(request, "head03", ""));
		setHead08(JSPUtil.getParameter(request, "head08", ""));
		setHead09(JSPUtil.getParameter(request, "head09", ""));
		setFoot11(JSPUtil.getParameter(request, "foot11", ""));
		setFoot12(JSPUtil.getParameter(request, "foot12", ""));
		setHead10(JSPUtil.getParameter(request, "head10", ""));
		setFoot10(JSPUtil.getParameter(request, "foot10", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SheetSettingInfoListVO[]
	 */
	public SheetSettingInfoListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SheetSettingInfoListVO[]
	 */
	public SheetSettingInfoListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SheetSettingInfoListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] foot01 = (JSPUtil.getParameter(request, prefix	+ "foot01", length));
			String[] ofad01 = (JSPUtil.getParameter(request, prefix	+ "ofad01", length));
			String[] ofad03 = (JSPUtil.getParameter(request, prefix	+ "ofad03", length));
			String[] ofad02 = (JSPUtil.getParameter(request, prefix	+ "ofad02", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] foot04 = (JSPUtil.getParameter(request, prefix	+ "foot04", length));
			String[] foot05 = (JSPUtil.getParameter(request, prefix	+ "foot05", length));
			String[] foot02 = (JSPUtil.getParameter(request, prefix	+ "foot02", length));
			String[] foot03 = (JSPUtil.getParameter(request, prefix	+ "foot03", length));
			String[] foot08 = (JSPUtil.getParameter(request, prefix	+ "foot08", length));
			String[] foot09 = (JSPUtil.getParameter(request, prefix	+ "foot09", length));
			String[] foot06 = (JSPUtil.getParameter(request, prefix	+ "foot06", length));
			String[] foot07 = (JSPUtil.getParameter(request, prefix	+ "foot07", length));
			String[] head04 = (JSPUtil.getParameter(request, prefix	+ "head04", length));
			String[] head05 = (JSPUtil.getParameter(request, prefix	+ "head05", length));
			String[] head06 = (JSPUtil.getParameter(request, prefix	+ "head06", length));
			String[] head07 = (JSPUtil.getParameter(request, prefix	+ "head07", length));
			String[] head01 = (JSPUtil.getParameter(request, prefix	+ "head01", length));
			String[] foot14 = (JSPUtil.getParameter(request, prefix	+ "foot14", length));
			String[] head02 = (JSPUtil.getParameter(request, prefix	+ "head02", length));
			String[] foot13 = (JSPUtil.getParameter(request, prefix	+ "foot13", length));
			String[] head03 = (JSPUtil.getParameter(request, prefix	+ "head03", length));
			String[] head08 = (JSPUtil.getParameter(request, prefix	+ "head08", length));
			String[] head09 = (JSPUtil.getParameter(request, prefix	+ "head09", length));
			String[] foot11 = (JSPUtil.getParameter(request, prefix	+ "foot11", length));
			String[] foot12 = (JSPUtil.getParameter(request, prefix	+ "foot12", length));
			String[] head10 = (JSPUtil.getParameter(request, prefix	+ "head10", length));
			String[] foot10 = (JSPUtil.getParameter(request, prefix	+ "foot10", length));
			
			for (int i = 0; i < length; i++) {
				model = new SheetSettingInfoListVO();
				if (foot01[i] != null)
					model.setFoot01(foot01[i]);
				if (ofad01[i] != null)
					model.setOfad01(ofad01[i]);
				if (ofad03[i] != null)
					model.setOfad03(ofad03[i]);
				if (ofad02[i] != null)
					model.setOfad02(ofad02[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (foot04[i] != null)
					model.setFoot04(foot04[i]);
				if (foot05[i] != null)
					model.setFoot05(foot05[i]);
				if (foot02[i] != null)
					model.setFoot02(foot02[i]);
				if (foot03[i] != null)
					model.setFoot03(foot03[i]);
				if (foot08[i] != null)
					model.setFoot08(foot08[i]);
				if (foot09[i] != null)
					model.setFoot09(foot09[i]);
				if (foot06[i] != null)
					model.setFoot06(foot06[i]);
				if (foot07[i] != null)
					model.setFoot07(foot07[i]);
				if (head04[i] != null)
					model.setHead04(head04[i]);
				if (head05[i] != null)
					model.setHead05(head05[i]);
				if (head06[i] != null)
					model.setHead06(head06[i]);
				if (head07[i] != null)
					model.setHead07(head07[i]);
				if (head01[i] != null)
					model.setHead01(head01[i]);
				if (foot14[i] != null)
					model.setFoot14(foot14[i]);
				if (head02[i] != null)
					model.setHead02(head02[i]);
				if (foot13[i] != null)
					model.setFoot13(foot13[i]);
				if (head03[i] != null)
					model.setHead03(head03[i]);
				if (head08[i] != null)
					model.setHead08(head08[i]);
				if (head09[i] != null)
					model.setHead09(head09[i]);
				if (foot11[i] != null)
					model.setFoot11(foot11[i]);
				if (foot12[i] != null)
					model.setFoot12(foot12[i]);
				if (head10[i] != null)
					model.setHead10(head10[i]);
				if (foot10[i] != null)
					model.setFoot10(foot10[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSheetSettingInfoListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SheetSettingInfoListVO[]
	 */
	public SheetSettingInfoListVO[] getSheetSettingInfoListVOs(){
		SheetSettingInfoListVO[] vos = (SheetSettingInfoListVO[])models.toArray(new SheetSettingInfoListVO[models.size()]);
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
		this.foot01 = this.foot01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofad01 = this.ofad01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofad03 = this.ofad03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofad02 = this.ofad02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foot04 = this.foot04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foot05 = this.foot05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foot02 = this.foot02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foot03 = this.foot03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foot08 = this.foot08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foot09 = this.foot09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foot06 = this.foot06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foot07 = this.foot07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.head04 = this.head04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.head05 = this.head05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.head06 = this.head06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.head07 = this.head07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.head01 = this.head01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foot14 = this.foot14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.head02 = this.head02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foot13 = this.foot13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.head03 = this.head03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.head08 = this.head08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.head09 = this.head09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foot11 = this.foot11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foot12 = this.foot12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.head10 = this.head10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foot10 = this.foot10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

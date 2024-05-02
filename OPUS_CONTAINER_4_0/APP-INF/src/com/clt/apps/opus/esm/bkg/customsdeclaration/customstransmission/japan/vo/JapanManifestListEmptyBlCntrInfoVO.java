/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanManifestListEmptyBlCntrInfoVO.java
*@FileTitle : JapanManifestListEmptyBlCntrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier :
*@LastVersion : 1.0
* 2009.06.01
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class JapanManifestListEmptyBlCntrInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<JapanManifestListEmptyBlCntrInfoVO> models = new ArrayList<JapanManifestListEmptyBlCntrInfoVO>();

	/* Column Info */
	private String data1 = null;
	/* Column Info */
	private String data4 = null;
	/* Column Info */
	private String data5 = null;
	/* Column Info */
	private String data2 = null;
	/* Column Info */
	private String data3 = null;
	/* Column Info */
	private String data8 = null;
	/* Column Info */
	private String data9 = null;
	/* Column Info */
	private String data6 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String data7 = null;
	/* Column Info */
	private String data12 = null;
	/* Column Info */
	private String data11 = null;
	/* Column Info */
	private String data10 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String data13 = null;
	/* Column Info */
	private String cntrSealNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public JapanManifestListEmptyBlCntrInfoVO() {}

	public JapanManifestListEmptyBlCntrInfoVO(String ibflag, String pagerows, String cntrNo, String cntrSealNo, String data1, String data2, String data3, String data4, String data5, String data6, String data7, String data8, String data9, String data10, String data11, String data12, String data13) {
		this.data1 = data1;
		this.data4 = data4;
		this.data5 = data5;
		this.data2 = data2;
		this.data3 = data3;
		this.data8 = data8;
		this.data9 = data9;
		this.data6 = data6;
		this.pagerows = pagerows;
		this.data7 = data7;
		this.data12 = data12;
		this.data11 = data11;
		this.data10 = data10;
		this.ibflag = ibflag;
		this.cntrNo = cntrNo;
		this.data13 = data13;
		this.cntrSealNo = cntrSealNo;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("data1", getData1());
		this.hashColumns.put("data4", getData4());
		this.hashColumns.put("data5", getData5());
		this.hashColumns.put("data2", getData2());
		this.hashColumns.put("data3", getData3());
		this.hashColumns.put("data8", getData8());
		this.hashColumns.put("data9", getData9());
		this.hashColumns.put("data6", getData6());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("data7", getData7());
		this.hashColumns.put("data12", getData12());
		this.hashColumns.put("data11", getData11());
		this.hashColumns.put("data10", getData10());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("data13", getData13());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("data1", "data1");
		this.hashFields.put("data4", "data4");
		this.hashFields.put("data5", "data5");
		this.hashFields.put("data2", "data2");
		this.hashFields.put("data3", "data3");
		this.hashFields.put("data8", "data8");
		this.hashFields.put("data9", "data9");
		this.hashFields.put("data6", "data6");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("data7", "data7");
		this.hashFields.put("data12", "data12");
		this.hashFields.put("data11", "data11");
		this.hashFields.put("data10", "data10");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("data13", "data13");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return data1
	 */
	public String getData1() {
		return this.data1;
	}

	/**
	 * Column Info
	 * @return data4
	 */
	public String getData4() {
		return this.data4;
	}

	/**
	 * Column Info
	 * @return data5
	 */
	public String getData5() {
		return this.data5;
	}

	/**
	 * Column Info
	 * @return data2
	 */
	public String getData2() {
		return this.data2;
	}

	/**
	 * Column Info
	 * @return data3
	 */
	public String getData3() {
		return this.data3;
	}

	/**
	 * Column Info
	 * @return data8
	 */
	public String getData8() {
		return this.data8;
	}

	/**
	 * Column Info
	 * @return data9
	 */
	public String getData9() {
		return this.data9;
	}

	/**
	 * Column Info
	 * @return data6
	 */
	public String getData6() {
		return this.data6;
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
	 * @return data7
	 */
	public String getData7() {
		return this.data7;
	}

	/**
	 * Column Info
	 * @return data12
	 */
	public String getData12() {
		return this.data12;
	}

	/**
	 * Column Info
	 * @return data11
	 */
	public String getData11() {
		return this.data11;
	}

	/**
	 * Column Info
	 * @return data10
	 */
	public String getData10() {
		return this.data10;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}

	/**
	 * Column Info
	 * @return data13
	 */
	public String getData13() {
		return this.data13;
	}

	/**
	 * Column Info
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
	}


	/**
	 * Column Info
	 * @param data1
	 */
	public void setData1(String data1) {
		this.data1 = data1;
	}

	/**
	 * Column Info
	 * @param data4
	 */
	public void setData4(String data4) {
		this.data4 = data4;
	}

	/**
	 * Column Info
	 * @param data5
	 */
	public void setData5(String data5) {
		this.data5 = data5;
	}

	/**
	 * Column Info
	 * @param data2
	 */
	public void setData2(String data2) {
		this.data2 = data2;
	}

	/**
	 * Column Info
	 * @param data3
	 */
	public void setData3(String data3) {
		this.data3 = data3;
	}

	/**
	 * Column Info
	 * @param data8
	 */
	public void setData8(String data8) {
		this.data8 = data8;
	}

	/**
	 * Column Info
	 * @param data9
	 */
	public void setData9(String data9) {
		this.data9 = data9;
	}

	/**
	 * Column Info
	 * @param data6
	 */
	public void setData6(String data6) {
		this.data6 = data6;
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
	 * @param data7
	 */
	public void setData7(String data7) {
		this.data7 = data7;
	}

	/**
	 * Column Info
	 * @param data12
	 */
	public void setData12(String data12) {
		this.data12 = data12;
	}

	/**
	 * Column Info
	 * @param data11
	 */
	public void setData11(String data11) {
		this.data11 = data11;
	}

	/**
	 * Column Info
	 * @param data10
	 */
	public void setData10(String data10) {
		this.data10 = data10;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	/**
	 * Column Info
	 * @param data13
	 */
	public void setData13(String data13) {
		this.data13 = data13;
	}

	/**
	 * Column Info
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setData1(JSPUtil.getParameter(request, "data1", ""));
		setData4(JSPUtil.getParameter(request, "data4", ""));
		setData5(JSPUtil.getParameter(request, "data5", ""));
		setData2(JSPUtil.getParameter(request, "data2", ""));
		setData3(JSPUtil.getParameter(request, "data3", ""));
		setData8(JSPUtil.getParameter(request, "data8", ""));
		setData9(JSPUtil.getParameter(request, "data9", ""));
		setData6(JSPUtil.getParameter(request, "data6", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setData7(JSPUtil.getParameter(request, "data7", ""));
		setData12(JSPUtil.getParameter(request, "data12", ""));
		setData11(JSPUtil.getParameter(request, "data11", ""));
		setData10(JSPUtil.getParameter(request, "data10", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setData13(JSPUtil.getParameter(request, "data13", ""));
		setCntrSealNo(JSPUtil.getParameter(request, "cntr_seal_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapanManifestListEmptyBlCntrInfoVO[]
	 */
	public JapanManifestListEmptyBlCntrInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return JapanManifestListEmptyBlCntrInfoVO[]
	 */
	public JapanManifestListEmptyBlCntrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapanManifestListEmptyBlCntrInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] data1 = (JSPUtil.getParameter(request, prefix	+ "data1".trim(), length));
			String[] data4 = (JSPUtil.getParameter(request, prefix	+ "data4".trim(), length));
			String[] data5 = (JSPUtil.getParameter(request, prefix	+ "data5".trim(), length));
			String[] data2 = (JSPUtil.getParameter(request, prefix	+ "data2".trim(), length));
			String[] data3 = (JSPUtil.getParameter(request, prefix	+ "data3".trim(), length));
			String[] data8 = (JSPUtil.getParameter(request, prefix	+ "data8".trim(), length));
			String[] data9 = (JSPUtil.getParameter(request, prefix	+ "data9".trim(), length));
			String[] data6 = (JSPUtil.getParameter(request, prefix	+ "data6".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] data7 = (JSPUtil.getParameter(request, prefix	+ "data7".trim(), length));
			String[] data12 = (JSPUtil.getParameter(request, prefix	+ "data12".trim(), length));
			String[] data11 = (JSPUtil.getParameter(request, prefix	+ "data11".trim(), length));
			String[] data10 = (JSPUtil.getParameter(request, prefix	+ "data10".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no".trim(), length));
			String[] data13 = (JSPUtil.getParameter(request, prefix	+ "data13".trim(), length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new JapanManifestListEmptyBlCntrInfoVO();
				if (data1[i] != null)
					model.setData1(data1[i]);
				if (data4[i] != null)
					model.setData4(data4[i]);
				if (data5[i] != null)
					model.setData5(data5[i]);
				if (data2[i] != null)
					model.setData2(data2[i]);
				if (data3[i] != null)
					model.setData3(data3[i]);
				if (data8[i] != null)
					model.setData8(data8[i]);
				if (data9[i] != null)
					model.setData9(data9[i]);
				if (data6[i] != null)
					model.setData6(data6[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (data7[i] != null)
					model.setData7(data7[i]);
				if (data12[i] != null)
					model.setData12(data12[i]);
				if (data11[i] != null)
					model.setData11(data11[i]);
				if (data10[i] != null)
					model.setData10(data10[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (data13[i] != null)
					model.setData13(data13[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapanManifestListEmptyBlCntrInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapanManifestListEmptyBlCntrInfoVO[]
	 */
	public JapanManifestListEmptyBlCntrInfoVO[] getJapanManifestListEmptyBlCntrInfoVOs(){
		JapanManifestListEmptyBlCntrInfoVO[] vos = (JapanManifestListEmptyBlCntrInfoVO[])models.toArray(new JapanManifestListEmptyBlCntrInfoVO[models.size()]);
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
		this.data1 = this.data1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data4 = this.data4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data5 = this.data5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data2 = this.data2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data3 = this.data3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data8 = this.data8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data9 = this.data9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data6 = this.data6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data7 = this.data7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data12 = this.data12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data11 = this.data11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data10 = this.data10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data13 = this.data13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

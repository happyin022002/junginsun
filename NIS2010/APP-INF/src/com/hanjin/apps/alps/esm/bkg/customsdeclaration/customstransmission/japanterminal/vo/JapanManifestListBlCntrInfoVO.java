/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanManifestListBlCntrInfoVO.java
*@FileTitle : JapanManifestListBlCntrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.07.23 김승민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo;

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
 * @author 김승민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class JapanManifestListBlCntrInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<JapanManifestListBlCntrInfoVO> models = new ArrayList<JapanManifestListBlCntrInfoVO>();
	
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
	private String jpCntrOwnrCd = null;
	/* Column Info */
	private String data6 = null;
	/* Column Info */
	private String data7 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String deTermCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String cntrTpszCd2 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public JapanManifestListBlCntrInfoVO() {}

	public JapanManifestListBlCntrInfoVO(String ibflag, String pagerows, String cntrNo, String cntrSealNo, String data2, String data3, String data4, String data5, String data6, String fullMtyCd, String cntrTpszCd, String cntrTpszCd2, String deTermCd, String jpCntrOwnrCd, String rcvTermCd, String data7, String data8) {
		this.data4 = data4;
		this.data5 = data5;
		this.data2 = data2;
		this.data3 = data3;
		this.data8 = data8;
		this.jpCntrOwnrCd = jpCntrOwnrCd;
		this.data6 = data6;
		this.data7 = data7;
		this.pagerows = pagerows;
		this.deTermCd = deTermCd;
		this.ibflag = ibflag;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.fullMtyCd = fullMtyCd;
		this.cntrSealNo = cntrSealNo;
		this.rcvTermCd = rcvTermCd;
		this.cntrTpszCd2 = cntrTpszCd2;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("data4", getData4());
		this.hashColumns.put("data5", getData5());
		this.hashColumns.put("data2", getData2());
		this.hashColumns.put("data3", getData3());
		this.hashColumns.put("data8", getData8());
		this.hashColumns.put("jp_cntr_ownr_cd", getJpCntrOwnrCd());
		this.hashColumns.put("data6", getData6());
		this.hashColumns.put("data7", getData7());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("cntr_tpsz_cd2", getCntrTpszCd2());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("data4", "data4");
		this.hashFields.put("data5", "data5");
		this.hashFields.put("data2", "data2");
		this.hashFields.put("data3", "data3");
		this.hashFields.put("data8", "data8");
		this.hashFields.put("jp_cntr_ownr_cd", "jpCntrOwnrCd");
		this.hashFields.put("data6", "data6");
		this.hashFields.put("data7", "data7");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("cntr_tpsz_cd2", "cntrTpszCd2");
		return this.hashFields;
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
	 * @return jpCntrOwnrCd
	 */
	public String getJpCntrOwnrCd() {
		return this.jpCntrOwnrCd;
	}
	
	/**
	 * Column Info
	 * @return data6
	 */
	public String getData6() {
		return this.data6;
	}
	
	/**
	 * Column Info
	 * @return data7
	 */
	public String getData7() {
		return this.data7;
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
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return fullMtyCd
	 */
	public String getFullMtyCd() {
		return this.fullMtyCd;
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
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd2
	 */
	public String getCntrTpszCd2() {
		return this.cntrTpszCd2;
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
	 * @param jpCntrOwnrCd
	 */
	public void setJpCntrOwnrCd(String jpCntrOwnrCd) {
		this.jpCntrOwnrCd = jpCntrOwnrCd;
	}
	
	/**
	 * Column Info
	 * @param data6
	 */
	public void setData6(String data6) {
		this.data6 = data6;
	}
	
	/**
	 * Column Info
	 * @param data7
	 */
	public void setData7(String data7) {
		this.data7 = data7;
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
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param fullMtyCd
	 */
	public void setFullMtyCd(String fullMtyCd) {
		this.fullMtyCd = fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd2
	 */
	public void setCntrTpszCd2(String cntrTpszCd2) {
		this.cntrTpszCd2 = cntrTpszCd2;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setData4(JSPUtil.getParameter(request, "data4", ""));
		setData5(JSPUtil.getParameter(request, "data5", ""));
		setData2(JSPUtil.getParameter(request, "data2", ""));
		setData3(JSPUtil.getParameter(request, "data3", ""));
		setData8(JSPUtil.getParameter(request, "data8", ""));
		setJpCntrOwnrCd(JSPUtil.getParameter(request, "jp_cntr_ownr_cd", ""));
		setData6(JSPUtil.getParameter(request, "data6", ""));
		setData7(JSPUtil.getParameter(request, "data7", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setFullMtyCd(JSPUtil.getParameter(request, "full_mty_cd", ""));
		setCntrSealNo(JSPUtil.getParameter(request, "cntr_seal_no", ""));
		setRcvTermCd(JSPUtil.getParameter(request, "rcv_term_cd", ""));
		setCntrTpszCd2(JSPUtil.getParameter(request, "cntr_tpsz_cd2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapanManifestListBlCntrInfoVO[]
	 */
	public JapanManifestListBlCntrInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JapanManifestListBlCntrInfoVO[]
	 */
	public JapanManifestListBlCntrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapanManifestListBlCntrInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] data4 = (JSPUtil.getParameter(request, prefix	+ "data4", length));
			String[] data5 = (JSPUtil.getParameter(request, prefix	+ "data5", length));
			String[] data2 = (JSPUtil.getParameter(request, prefix	+ "data2", length));
			String[] data3 = (JSPUtil.getParameter(request, prefix	+ "data3", length));
			String[] data8 = (JSPUtil.getParameter(request, prefix	+ "data8", length));
			String[] jpCntrOwnrCd = (JSPUtil.getParameter(request, prefix	+ "jp_cntr_ownr_cd", length));
			String[] data6 = (JSPUtil.getParameter(request, prefix	+ "data6", length));
			String[] data7 = (JSPUtil.getParameter(request, prefix	+ "data7", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] cntrTpszCd2 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd2", length));
			
			for (int i = 0; i < length; i++) {
				model = new JapanManifestListBlCntrInfoVO();
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
				if (jpCntrOwnrCd[i] != null)
					model.setJpCntrOwnrCd(jpCntrOwnrCd[i]);
				if (data6[i] != null)
					model.setData6(data6[i]);
				if (data7[i] != null)
					model.setData7(data7[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (cntrTpszCd2[i] != null)
					model.setCntrTpszCd2(cntrTpszCd2[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapanManifestListBlCntrInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapanManifestListBlCntrInfoVO[]
	 */
	public JapanManifestListBlCntrInfoVO[] getJapanManifestListBlCntrInfoVOs(){
		JapanManifestListBlCntrInfoVO[] vos = (JapanManifestListBlCntrInfoVO[])models.toArray(new JapanManifestListBlCntrInfoVO[models.size()]);
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
		this.data4 = this.data4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data5 = this.data5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data2 = this.data2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data3 = this.data3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data8 = this.data8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpCntrOwnrCd = this.jpCntrOwnrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data6 = this.data6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data7 = this.data7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd2 = this.cntrTpszCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanManifestListBkgCntrInfoVO.java
*@FileTitle : JapanManifestListBkgCntrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.19  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class JapanManifestListBkgCntrInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<JapanManifestListBkgCntrInfoVO> models = new ArrayList<JapanManifestListBkgCntrInfoVO>();
	
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String cntrPrtFlg = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String cntrSealNo2 = null;
	/* Column Info */
	private String cntrSealNo3 = null;
	/* Column Info */
	private String cntrSealNo4 = null;
	/* Column Info */
	private String cntrSealNo5 = null;
	/* Column Info */
	private String cntrSealNo6 = null;
	
	
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String blSplitNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public JapanManifestListBkgCntrInfoVO() {}

	public JapanManifestListBkgCntrInfoVO(String ibflag, String pagerows, String blNo, String blSplitNo, String cntrNo, String cntrTpszCd, String cntrSealNo, String cntrSealNo2, String cntrSealNo3, String cntrSealNo4, String cntrSealNo5, String cntrSealNo6, String cntrPrtFlg, String rcvTermCd, String deTermCd, String bkgCgoTpCd, String lstmCd) {
		this.deTermCd = deTermCd;
		this.cntrPrtFlg = cntrPrtFlg;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.ibflag = ibflag;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.cntrSealNo = cntrSealNo;
		this.cntrSealNo2 = cntrSealNo2;
		this.cntrSealNo3 = cntrSealNo3;
		this.cntrSealNo4 = cntrSealNo4;
		this.cntrSealNo5 = cntrSealNo5;
		this.cntrSealNo6 = cntrSealNo6;
		
		this.rcvTermCd = rcvTermCd;
		this.lstmCd = lstmCd;
		this.blNo = blNo;
		this.blSplitNo = blSplitNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("cntr_prt_flg", getCntrPrtFlg());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("cntr_seal_no2", getCntrSealNo2());
		this.hashColumns.put("cntr_seal_no3", getCntrSealNo3());
		this.hashColumns.put("cntr_seal_no4", getCntrSealNo4());
		this.hashColumns.put("cntr_seal_no5", getCntrSealNo5());
		this.hashColumns.put("cntr_seal_no6", getCntrSealNo6());
		
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bl_split_no", getBlSplitNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("cntr_prt_flg", "cntrPrtFlg");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("cntr_seal_no2", "cntrSealNo2");
		this.hashFields.put("cntr_seal_no3", "cntrSealNo3");
		this.hashFields.put("cntr_seal_no4", "cntrSealNo4");
		this.hashFields.put("cntr_seal_no5", "cntrSealNo5");
		this.hashFields.put("cntr_seal_no6", "cntrSealNo6");
		
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("bl_split_no", "blSplitNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return cntrPrtFlg
	 */
	public String getCntrPrtFlg() {
		return this.cntrPrtFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
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
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
	}

	/**
	 * Column Info
	 * @return cntrSealNo2
	 */
	public String getCntrSealNo2() {
		return this.cntrSealNo2;
	}

	/**
	 * Column Info
	 * @return cntrSealNo3
	 */
	public String getCntrSealNo3() {
		return this.cntrSealNo3;
	}

	/**
	 * Column Info
	 * @return cntrSealNo4
	 */
	public String getCntrSealNo4() {
		return this.cntrSealNo4;
	}

	/**
	 * Column Info
	 * @return cntrSealNo5
	 */
	public String getCntrSealNo5() {
		return this.cntrSealNo5;
	}

	/**
	 * Column Info
	 * @return cntrSealNo6
	 */
	public String getCntrSealNo6() {
		return this.cntrSealNo6;
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
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return blSplitNo
	 */
	public String getBlSplitNo() {
		return this.blSplitNo;
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
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param cntrPrtFlg
	 */
	public void setCntrPrtFlg(String cntrPrtFlg) {
		this.cntrPrtFlg = cntrPrtFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
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
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}

	/**
	 * Column Info
	 * @param cntrSealNo2
	 */
	public void setCntrSealNo2(String cntrSealNo2) {
		this.cntrSealNo2 = cntrSealNo2;
	}

	/**
	 * Column Info
	 * @param cntrSealNo3
	 */
	public void setCntrSealNo3(String cntrSealNo3) {
		this.cntrSealNo3 = cntrSealNo3;
	}

	/**
	 * Column Info
	 * @param cntrSealNo4
	 */
	public void setCntrSealNo4(String cntrSealNo4) {
		this.cntrSealNo4 = cntrSealNo4;
	}

	/**
	 * Column Info
	 * @param cntrSealNo5
	 */
	public void setCntrSealNo5(String cntrSealNo5) {
		this.cntrSealNo5 = cntrSealNo5;
	}

	/**
	 * Column Info
	 * @param cntrSealNo6
	 */
	public void setCntrSealNo6(String cntrSealNo6) {
		this.cntrSealNo6 = cntrSealNo6;
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
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param blSplitNo
	 */
	public void setBlSplitNo(String blSplitNo) {
		this.blSplitNo = blSplitNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setCntrPrtFlg(JSPUtil.getParameter(request, "cntr_prt_flg", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, "bkg_cgo_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCntrSealNo(JSPUtil.getParameter(request, "cntr_seal_no", ""));
		setCntrSealNo2(JSPUtil.getParameter(request, "cntr_seal_no2", ""));
		setCntrSealNo3(JSPUtil.getParameter(request, "cntr_seal_no3", ""));
		setCntrSealNo4(JSPUtil.getParameter(request, "cntr_seal_no4", ""));
		setCntrSealNo5(JSPUtil.getParameter(request, "cntr_seal_no5", ""));
		setCntrSealNo6(JSPUtil.getParameter(request, "cntr_seal_no6", ""));
		
		setRcvTermCd(JSPUtil.getParameter(request, "rcv_term_cd", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setBlSplitNo(JSPUtil.getParameter(request, "bl_split_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapanManifestListBkgCntrInfoVO[]
	 */
	public JapanManifestListBkgCntrInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JapanManifestListBkgCntrInfoVO[]
	 */
	public JapanManifestListBkgCntrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapanManifestListBkgCntrInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] cntrPrtFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_prt_flg", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] cntrSealNo2 = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no2", length));
			String[] cntrSealNo3 = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no3", length));
			String[] cntrSealNo4 = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no4", length));
			String[] cntrSealNo5 = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no5", length));
			String[] cntrSealNo6 = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no6", length));
			
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] blSplitNo = (JSPUtil.getParameter(request, prefix	+ "bl_split_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new JapanManifestListBkgCntrInfoVO();
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (cntrPrtFlg[i] != null)
					model.setCntrPrtFlg(cntrPrtFlg[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (cntrSealNo2[i] != null)
					model.setCntrSealNo2(cntrSealNo2[i]);
				if (cntrSealNo3[i] != null)
					model.setCntrSealNo3(cntrSealNo3[i]);
				if (cntrSealNo4[i] != null)
					model.setCntrSealNo4(cntrSealNo4[i]);
				if (cntrSealNo5[i] != null)
					model.setCntrSealNo5(cntrSealNo5[i]);
				if (cntrSealNo6[i] != null)
					model.setCntrSealNo6(cntrSealNo6[i]);
				
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (blSplitNo[i] != null)
					model.setBlSplitNo(blSplitNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapanManifestListBkgCntrInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapanManifestListBkgCntrInfoVO[]
	 */
	public JapanManifestListBkgCntrInfoVO[] getJapanManifestListBkgCntrInfoVOs(){
		JapanManifestListBkgCntrInfoVO[] vos = (JapanManifestListBkgCntrInfoVO[])models.toArray(new JapanManifestListBkgCntrInfoVO[models.size()]);
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
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPrtFlg = this.cntrPrtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo2 = this.cntrSealNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo3 = this.cntrSealNo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo4 = this.cntrSealNo4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo5 = this.cntrSealNo5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo6 = this.cntrSealNo6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSplitNo = this.blSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanMfrMndCondVO.java
*@FileTitle : JapanMfrMndCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.12  
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

public class JapanMfrMndCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<JapanMfrMndCondVO> models = new ArrayList<JapanMfrMndCondVO>();
	
	/* Column Info */
	private String cyOprCd = null;
	/* Column Info */
	private String lmtNo = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String blNumber = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	//private String blNoChk = null;
	/* Column Info */
	private String jpCstmsTrnsCd = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	//private String blNoTp = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String blSplitNo = null;
	/* Column Info */
	private String grsWgt = null;
	/* Column Info */
	private String loclTsFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public JapanMfrMndCondVO() {}

	//public JapanMfrMndCondVO(String ibflag, String pagerows, String blNumber, String blNo, String blNoTp, String blNoChk, String blSplitNo, String pckQty, String pckTpCd, String grsWgt, String wgtUtCd, String measQty, String measUtCd, String loclTsFlg, String jpCstmsTrnsCd, String lmtNo, String cyOprCd) {
	public JapanMfrMndCondVO(String ibflag, String pagerows, String blNumber, String blNo, String blSplitNo, String pckQty, String pckTpCd, String grsWgt, String wgtUtCd, String measQty, String measUtCd, String loclTsFlg, String jpCstmsTrnsCd, String lmtNo, String cyOprCd) {
		this.cyOprCd = cyOprCd;
		this.lmtNo = lmtNo;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.blNumber = blNumber;
		this.ibflag = ibflag;
		//this.blNoChk = blNoChk;
		this.jpCstmsTrnsCd = jpCstmsTrnsCd;
		this.wgtUtCd = wgtUtCd;
		this.measQty = measQty;
		this.pckQty = pckQty;
		//this.blNoTp = blNoTp;
		this.pckTpCd = pckTpCd;
		this.measUtCd = measUtCd;
		this.blSplitNo = blSplitNo;
		this.grsWgt = grsWgt;
		this.loclTsFlg = loclTsFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cy_opr_cd", getCyOprCd());
		this.hashColumns.put("lmt_no", getLmtNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_number", getBlNumber());
		this.hashColumns.put("ibflag", getIbflag());
		//this.hashColumns.put("bl_no_chk", getBlNoChk());
		this.hashColumns.put("jp_cstms_trns_cd", getJpCstmsTrnsCd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		//this.hashColumns.put("bl_no_tp", getBlNoTp());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("bl_split_no", getBlSplitNo());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		this.hashColumns.put("locl_ts_flg", getLoclTsFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cy_opr_cd", "cyOprCd");
		this.hashFields.put("lmt_no", "lmtNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_number", "blNumber");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bl_no_chk", "blNoChk");
		this.hashFields.put("jp_cstms_trns_cd", "jpCstmsTrnsCd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("bl_no_tp", "blNoTp");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("bl_split_no", "blSplitNo");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("locl_ts_flg", "loclTsFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cyOprCd
	 */
	public String getCyOprCd() {
		return this.cyOprCd;
	}
	
	/**
	 * Column Info
	 * @return lmtNo
	 */
	public String getLmtNo() {
		return this.lmtNo;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return blNumber
	 */
	public String getBlNumber() {
		return this.blNumber;
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
	 * @return blNoChk
	 */
	//public String getBlNoChk() {
	//	return this.blNoChk;
	//}
	
	/**
	 * Column Info
	 * @return jpCstmsTrnsCd
	 */
	public String getJpCstmsTrnsCd() {
		return this.jpCstmsTrnsCd;
	}
	
	/**
	 * Column Info
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return blNoTp
	 */
	//public String getBlNoTp() {
	//	return this.blNoTp;
	//}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
	}
	
	/**
	 * Column Info
	 * @return blSplitNo
	 */
	public String getBlSplitNo() {
		return this.blSplitNo;
	}
	
	/**
	 * Column Info
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
	}
	
	/**
	 * Column Info
	 * @return loclTsFlg
	 */
	public String getLoclTsFlg() {
		return this.loclTsFlg;
	}
	

	/**
	 * Column Info
	 * @param cyOprCd
	 */
	public void setCyOprCd(String cyOprCd) {
		this.cyOprCd = cyOprCd;
	}
	
	/**
	 * Column Info
	 * @param lmtNo
	 */
	public void setLmtNo(String lmtNo) {
		this.lmtNo = lmtNo;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param blNumber
	 */
	public void setBlNumber(String blNumber) {
		this.blNumber = blNumber;
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
	 * @param blNoChk
	 */
	//public void setBlNoChk(String blNoChk) {
	//	this.blNoChk = blNoChk;
	//}
	
	/**
	 * Column Info
	 * @param jpCstmsTrnsCd
	 */
	public void setJpCstmsTrnsCd(String jpCstmsTrnsCd) {
		this.jpCstmsTrnsCd = jpCstmsTrnsCd;
	}
	
	/**
	 * Column Info
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param blNoTp
	 */
	//public void setBlNoTp(String blNoTp) {
	//	this.blNoTp = blNoTp;
	//}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
	}
	
	/**
	 * Column Info
	 * @param blSplitNo
	 */
	public void setBlSplitNo(String blSplitNo) {
		this.blSplitNo = blSplitNo;
	}
	
	/**
	 * Column Info
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
	}
	
	/**
	 * Column Info
	 * @param loclTsFlg
	 */
	public void setLoclTsFlg(String loclTsFlg) {
		this.loclTsFlg = loclTsFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCyOprCd(JSPUtil.getParameter(request, "cy_opr_cd", ""));
		setLmtNo(JSPUtil.getParameter(request, "lmt_no", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBlNumber(JSPUtil.getParameter(request, "bl_number", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		//setBlNoChk(JSPUtil.getParameter(request, "bl_no_chk", ""));
		setJpCstmsTrnsCd(JSPUtil.getParameter(request, "jp_cstms_trns_cd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		//setBlNoTp(JSPUtil.getParameter(request, "bl_no_tp", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, "meas_ut_cd", ""));
		setBlSplitNo(JSPUtil.getParameter(request, "bl_split_no", ""));
		setGrsWgt(JSPUtil.getParameter(request, "grs_wgt", ""));
		setLoclTsFlg(JSPUtil.getParameter(request, "locl_ts_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapanMfrMndCondVO[]
	 */
	public JapanMfrMndCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JapanMfrMndCondVO[]
	 */
	public JapanMfrMndCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapanMfrMndCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cyOprCd = (JSPUtil.getParameter(request, prefix	+ "cy_opr_cd", length));
			String[] lmtNo = (JSPUtil.getParameter(request, prefix	+ "lmt_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blNumber = (JSPUtil.getParameter(request, prefix	+ "bl_number", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			//String[] blNoChk = (JSPUtil.getParameter(request, prefix	+ "bl_no_chk", length));
			String[] jpCstmsTrnsCd = (JSPUtil.getParameter(request, prefix	+ "jp_cstms_trns_cd", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			//String[] blNoTp = (JSPUtil.getParameter(request, prefix	+ "bl_no_tp", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] blSplitNo = (JSPUtil.getParameter(request, prefix	+ "bl_split_no", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			String[] loclTsFlg = (JSPUtil.getParameter(request, prefix	+ "locl_ts_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new JapanMfrMndCondVO();
				if (cyOprCd[i] != null)
					model.setCyOprCd(cyOprCd[i]);
				if (lmtNo[i] != null)
					model.setLmtNo(lmtNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blNumber[i] != null)
					model.setBlNumber(blNumber[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				//if (blNoChk[i] != null)
				//	model.setBlNoChk(blNoChk[i]);
				if (jpCstmsTrnsCd[i] != null)
					model.setJpCstmsTrnsCd(jpCstmsTrnsCd[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				//if (blNoTp[i] != null)
				//	model.setBlNoTp(blNoTp[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (blSplitNo[i] != null)
					model.setBlSplitNo(blSplitNo[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				if (loclTsFlg[i] != null)
					model.setLoclTsFlg(loclTsFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapanMfrMndCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapanMfrMndCondVO[]
	 */
	public JapanMfrMndCondVO[] getJapanMfrMndCondVOs(){
		JapanMfrMndCondVO[] vos = (JapanMfrMndCondVO[])models.toArray(new JapanMfrMndCondVO[models.size()]);
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
		this.cyOprCd = this.cyOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lmtNo = this.lmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNumber = this.blNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		//this.blNoChk = this.blNoChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpCstmsTrnsCd = this.jpCstmsTrnsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		//this.blNoTp = this.blNoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSplitNo = this.blSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclTsFlg = this.loclTsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

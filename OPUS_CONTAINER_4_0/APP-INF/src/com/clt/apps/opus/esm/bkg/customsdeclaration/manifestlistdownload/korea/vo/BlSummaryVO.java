/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BlSummaryVO.java
*@FileTitle : BlSummaryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.08.05 박상훈
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BlSummaryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<BlSummaryVO> models = new ArrayList<BlSummaryVO>();

	/* Column Info */
	private String blCCnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String transChkCnt = null;
	/* Column Info */
	private String blTotCnt = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String blECnt = null;
	/* Column Info */
	private String blSCnt = null;
	/* Column Info */
	private String wgtQty = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public BlSummaryVO() {}

	public BlSummaryVO(String ibflag, String pagerows, String blTotCnt, String blCCnt, String blECnt, String pckQty, String wgtQty, String measQty, String blSCnt, String transChkCnt) {
		this.blCCnt = blCCnt;
		this.ibflag = ibflag;
		this.transChkCnt = transChkCnt;
		this.blTotCnt = blTotCnt;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.blECnt = blECnt;
		this.blSCnt = blSCnt;
		this.wgtQty = wgtQty;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_c_cnt", getBlCCnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trans_chk_cnt", getTransChkCnt());
		this.hashColumns.put("bl_tot_cnt", getBlTotCnt());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("bl_e_cnt", getBlECnt());
		this.hashColumns.put("bl_s_cnt", getBlSCnt());
		this.hashColumns.put("wgt_qty", getWgtQty());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_c_cnt", "blCCnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trans_chk_cnt", "transChkCnt");
		this.hashFields.put("bl_tot_cnt", "blTotCnt");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("bl_e_cnt", "blECnt");
		this.hashFields.put("bl_s_cnt", "blSCnt");
		this.hashFields.put("wgt_qty", "wgtQty");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return blCCnt
	 */
	public String getBlCCnt() {
		return this.blCCnt;
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
	 * @return transChkCnt
	 */
	public String getTransChkCnt() {
		return this.transChkCnt;
	}

	/**
	 * Column Info
	 * @return blTotCnt
	 */
	public String getBlTotCnt() {
		return this.blTotCnt;
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
	 * @return blECnt
	 */
	public String getBlECnt() {
		return this.blECnt;
	}

	/**
	 * Column Info
	 * @return blSCnt
	 */
	public String getBlSCnt() {
		return this.blSCnt;
	}

	/**
	 * Column Info
	 * @return wgtQty
	 */
	public String getWgtQty() {
		return this.wgtQty;
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
	 * @param blCCnt
	 */
	public void setBlCCnt(String blCCnt) {
		this.blCCnt = blCCnt;
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
	 * @param transChkCnt
	 */
	public void setTransChkCnt(String transChkCnt) {
		this.transChkCnt = transChkCnt;
	}

	/**
	 * Column Info
	 * @param blTotCnt
	 */
	public void setBlTotCnt(String blTotCnt) {
		this.blTotCnt = blTotCnt;
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
	 * @param blECnt
	 */
	public void setBlECnt(String blECnt) {
		this.blECnt = blECnt;
	}

	/**
	 * Column Info
	 * @param blSCnt
	 */
	public void setBlSCnt(String blSCnt) {
		this.blSCnt = blSCnt;
	}

	/**
	 * Column Info
	 * @param wgtQty
	 */
	public void setWgtQty(String wgtQty) {
		this.wgtQty = wgtQty;
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
		setBlCCnt(JSPUtil.getParameter(request, "bl_c_cnt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTransChkCnt(JSPUtil.getParameter(request, "trans_chk_cnt", ""));
		setBlTotCnt(JSPUtil.getParameter(request, "bl_tot_cnt", ""));
		setMeasQty(JSPUtil.getParameter(request, "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setBlECnt(JSPUtil.getParameter(request, "bl_e_cnt", ""));
		setBlSCnt(JSPUtil.getParameter(request, "bl_s_cnt", ""));
		setWgtQty(JSPUtil.getParameter(request, "wgt_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BlSummaryVO[]
	 */
	public BlSummaryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BlSummaryVO[]
	 */
	public BlSummaryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BlSummaryVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] blCCnt = (JSPUtil.getParameter(request, prefix	+ "bl_c_cnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] transChkCnt = (JSPUtil.getParameter(request, prefix	+ "trans_chk_cnt", length));
			String[] blTotCnt = (JSPUtil.getParameter(request, prefix	+ "bl_tot_cnt", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] blECnt = (JSPUtil.getParameter(request, prefix	+ "bl_e_cnt", length));
			String[] blSCnt = (JSPUtil.getParameter(request, prefix	+ "bl_s_cnt", length));
			String[] wgtQty = (JSPUtil.getParameter(request, prefix	+ "wgt_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new BlSummaryVO();
				if (blCCnt[i] != null)
					model.setBlCCnt(blCCnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (transChkCnt[i] != null)
					model.setTransChkCnt(transChkCnt[i]);
				if (blTotCnt[i] != null)
					model.setBlTotCnt(blTotCnt[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (blECnt[i] != null)
					model.setBlECnt(blECnt[i]);
				if (blSCnt[i] != null)
					model.setBlSCnt(blSCnt[i]);
				if (wgtQty[i] != null)
					model.setWgtQty(wgtQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBlSummaryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlSummaryVO[]
	 */
	public BlSummaryVO[] getBlSummaryVOs(){
		BlSummaryVO[] vos = (BlSummaryVO[])models.toArray(new BlSummaryVO[models.size()]);
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
		this.blCCnt = this.blCCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transChkCnt = this.transChkCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTotCnt = this.blTotCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blECnt = this.blECnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSCnt = this.blSCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtQty = this.wgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

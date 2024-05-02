/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchExportInfoDNVO.java
*@FileTitle : SearchExportInfoDNVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.06.09 손윤석
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
 * @author 손윤석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorExportInfoDNVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorExportInfoDNVO> models = new ArrayList<KorExportInfoDNVO>();

	/* Column Info */
	private String eBmePkgTp = null;
	/* Column Info */
	private String eBmeWgtQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eBmeDpkgQty = null;
	/* Column Info */
	private String eBmeWgtTp = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eBmeDivInd = null;
	/* Column Info */
	private String eBmeDwgtTp = null;
	/* Column Info */
	private String eBmeElno = null;
	/* Column Info */
	private String eBmeDivSeq = null;
	/* Column Info */
	private String eBmeSmpSeq = null;
	/* Column Info */
	private String eBmeDpkgTp = null;
	/* Column Info */
	private String eBmeDwgtQty = null;
	/* Column Info */
	private String eBmePkgQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorExportInfoDNVO() {}

	public KorExportInfoDNVO(String ibflag, String pagerows, String eBmeElno, String eBmePkgQty, String eBmePkgTp, String eBmeWgtQty, String eBmeWgtTp, String eBmeDivInd, String eBmeDivSeq, String eBmeDpkgQty, String eBmeDpkgTp, String eBmeDwgtQty, String eBmeDwgtTp, String eBmeSmpSeq) {
		this.eBmePkgTp = eBmePkgTp;
		this.eBmeWgtQty = eBmeWgtQty;
		this.pagerows = pagerows;
		this.eBmeDpkgQty = eBmeDpkgQty;
		this.eBmeWgtTp = eBmeWgtTp;
		this.ibflag = ibflag;
		this.eBmeDivInd = eBmeDivInd;
		this.eBmeDwgtTp = eBmeDwgtTp;
		this.eBmeElno = eBmeElno;
		this.eBmeDivSeq = eBmeDivSeq;
		this.eBmeSmpSeq = eBmeSmpSeq;
		this.eBmeDpkgTp = eBmeDpkgTp;
		this.eBmeDwgtQty = eBmeDwgtQty;
		this.eBmePkgQty = eBmePkgQty;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("e_bme_pkg_tp", getEBmePkgTp());
		this.hashColumns.put("e_bme_wgt_qty", getEBmeWgtQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("e_bme_dpkg_qty", getEBmeDpkgQty());
		this.hashColumns.put("e_bme_wgt_tp", getEBmeWgtTp());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("e_bme_div_ind", getEBmeDivInd());
		this.hashColumns.put("e_bme_dwgt_tp", getEBmeDwgtTp());
		this.hashColumns.put("e_bme_elno", getEBmeElno());
		this.hashColumns.put("e_bme_div_seq", getEBmeDivSeq());
		this.hashColumns.put("e_bme_smp_seq", getEBmeSmpSeq());
		this.hashColumns.put("e_bme_dpkg_tp", getEBmeDpkgTp());
		this.hashColumns.put("e_bme_dwgt_qty", getEBmeDwgtQty());
		this.hashColumns.put("e_bme_pkg_qty", getEBmePkgQty());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("e_bme_pkg_tp", "eBmePkgTp");
		this.hashFields.put("e_bme_wgt_qty", "eBmeWgtQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("e_bme_dpkg_qty", "eBmeDpkgQty");
		this.hashFields.put("e_bme_wgt_tp", "eBmeWgtTp");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("e_bme_div_ind", "eBmeDivInd");
		this.hashFields.put("e_bme_dwgt_tp", "eBmeDwgtTp");
		this.hashFields.put("e_bme_elno", "eBmeElno");
		this.hashFields.put("e_bme_div_seq", "eBmeDivSeq");
		this.hashFields.put("e_bme_smp_seq", "eBmeSmpSeq");
		this.hashFields.put("e_bme_dpkg_tp", "eBmeDpkgTp");
		this.hashFields.put("e_bme_dwgt_qty", "eBmeDwgtQty");
		this.hashFields.put("e_bme_pkg_qty", "eBmePkgQty");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return eBmePkgTp
	 */
	public String getEBmePkgTp() {
		return this.eBmePkgTp;
	}

	/**
	 * Column Info
	 * @return eBmeWgtQty
	 */
	public String getEBmeWgtQty() {
		return this.eBmeWgtQty;
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
	 * @return eBmeDpkgQty
	 */
	public String getEBmeDpkgQty() {
		return this.eBmeDpkgQty;
	}

	/**
	 * Column Info
	 * @return eBmeWgtTp
	 */
	public String getEBmeWgtTp() {
		return this.eBmeWgtTp;
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
	 * @return eBmeDivInd
	 */
	public String getEBmeDivInd() {
		return this.eBmeDivInd;
	}

	/**
	 * Column Info
	 * @return eBmeDwgtTp
	 */
	public String getEBmeDwgtTp() {
		return this.eBmeDwgtTp;
	}

	/**
	 * Column Info
	 * @return eBmeElno
	 */
	public String getEBmeElno() {
		return this.eBmeElno;
	}

	/**
	 * Column Info
	 * @return eBmeDivSeq
	 */
	public String getEBmeDivSeq() {
		return this.eBmeDivSeq;
	}

	/**
	 * Column Info
	 * @return eBmeSmpSeq
	 */
	public String getEBmeSmpSeq() {
		return this.eBmeSmpSeq;
	}

	/**
	 * Column Info
	 * @return eBmeDpkgTp
	 */
	public String getEBmeDpkgTp() {
		return this.eBmeDpkgTp;
	}

	/**
	 * Column Info
	 * @return eBmeDwgtQty
	 */
	public String getEBmeDwgtQty() {
		return this.eBmeDwgtQty;
	}

	/**
	 * Column Info
	 * @return eBmePkgQty
	 */
	public String getEBmePkgQty() {
		return this.eBmePkgQty;
	}


	/**
	 * Column Info
	 * @param eBmePkgTp
	 */
	public void setEBmePkgTp(String eBmePkgTp) {
		this.eBmePkgTp = eBmePkgTp;
	}

	/**
	 * Column Info
	 * @param eBmeWgtQty
	 */
	public void setEBmeWgtQty(String eBmeWgtQty) {
		this.eBmeWgtQty = eBmeWgtQty;
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
	 * @param eBmeDpkgQty
	 */
	public void setEBmeDpkgQty(String eBmeDpkgQty) {
		this.eBmeDpkgQty = eBmeDpkgQty;
	}

	/**
	 * Column Info
	 * @param eBmeWgtTp
	 */
	public void setEBmeWgtTp(String eBmeWgtTp) {
		this.eBmeWgtTp = eBmeWgtTp;
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
	 * @param eBmeDivInd
	 */
	public void setEBmeDivInd(String eBmeDivInd) {
		this.eBmeDivInd = eBmeDivInd;
	}

	/**
	 * Column Info
	 * @param eBmeDwgtTp
	 */
	public void setEBmeDwgtTp(String eBmeDwgtTp) {
		this.eBmeDwgtTp = eBmeDwgtTp;
	}

	/**
	 * Column Info
	 * @param eBmeElno
	 */
	public void setEBmeElno(String eBmeElno) {
		this.eBmeElno = eBmeElno;
	}

	/**
	 * Column Info
	 * @param eBmeDivSeq
	 */
	public void setEBmeDivSeq(String eBmeDivSeq) {
		this.eBmeDivSeq = eBmeDivSeq;
	}

	/**
	 * Column Info
	 * @param eBmeSmpSeq
	 */
	public void setEBmeSmpSeq(String eBmeSmpSeq) {
		this.eBmeSmpSeq = eBmeSmpSeq;
	}

	/**
	 * Column Info
	 * @param eBmeDpkgTp
	 */
	public void setEBmeDpkgTp(String eBmeDpkgTp) {
		this.eBmeDpkgTp = eBmeDpkgTp;
	}

	/**
	 * Column Info
	 * @param eBmeDwgtQty
	 */
	public void setEBmeDwgtQty(String eBmeDwgtQty) {
		this.eBmeDwgtQty = eBmeDwgtQty;
	}

	/**
	 * Column Info
	 * @param eBmePkgQty
	 */
	public void setEBmePkgQty(String eBmePkgQty) {
		this.eBmePkgQty = eBmePkgQty;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEBmePkgTp(JSPUtil.getParameter(request, "e_bme_pkg_tp", ""));
		setEBmeWgtQty(JSPUtil.getParameter(request, "e_bme_wgt_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEBmeDpkgQty(JSPUtil.getParameter(request, "e_bme_dpkg_qty", ""));
		setEBmeWgtTp(JSPUtil.getParameter(request, "e_bme_wgt_tp", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEBmeDivInd(JSPUtil.getParameter(request, "e_bme_div_ind", ""));
		setEBmeDwgtTp(JSPUtil.getParameter(request, "e_bme_dwgt_tp", ""));
		setEBmeElno(JSPUtil.getParameter(request, "e_bme_elno", ""));
		setEBmeDivSeq(JSPUtil.getParameter(request, "e_bme_div_seq", ""));
		setEBmeSmpSeq(JSPUtil.getParameter(request, "e_bme_smp_seq", ""));
		setEBmeDpkgTp(JSPUtil.getParameter(request, "e_bme_dpkg_tp", ""));
		setEBmeDwgtQty(JSPUtil.getParameter(request, "e_bme_dwgt_qty", ""));
		setEBmePkgQty(JSPUtil.getParameter(request, "e_bme_pkg_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchExportInfoDNVO[]
	 */
	public KorExportInfoDNVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SearchExportInfoDNVO[]
	 */
	public KorExportInfoDNVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorExportInfoDNVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] eBmePkgTp = (JSPUtil.getParameter(request, prefix	+ "e_bme_pkg_tp".trim(), length));
			String[] eBmeWgtQty = (JSPUtil.getParameter(request, prefix	+ "e_bme_wgt_qty".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] eBmeDpkgQty = (JSPUtil.getParameter(request, prefix	+ "e_bme_dpkg_qty".trim(), length));
			String[] eBmeWgtTp = (JSPUtil.getParameter(request, prefix	+ "e_bme_wgt_tp".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] eBmeDivInd = (JSPUtil.getParameter(request, prefix	+ "e_bme_div_ind".trim(), length));
			String[] eBmeDwgtTp = (JSPUtil.getParameter(request, prefix	+ "e_bme_dwgt_tp".trim(), length));
			String[] eBmeElno = (JSPUtil.getParameter(request, prefix	+ "e_bme_elno".trim(), length));
			String[] eBmeDivSeq = (JSPUtil.getParameter(request, prefix	+ "e_bme_div_seq".trim(), length));
			String[] eBmeSmpSeq = (JSPUtil.getParameter(request, prefix	+ "e_bme_smp_seq".trim(), length));
			String[] eBmeDpkgTp = (JSPUtil.getParameter(request, prefix	+ "e_bme_dpkg_tp".trim(), length));
			String[] eBmeDwgtQty = (JSPUtil.getParameter(request, prefix	+ "e_bme_dwgt_qty".trim(), length));
			String[] eBmePkgQty = (JSPUtil.getParameter(request, prefix	+ "e_bme_pkg_qty".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new KorExportInfoDNVO();
				if (eBmePkgTp[i] != null)
					model.setEBmePkgTp(eBmePkgTp[i]);
				if (eBmeWgtQty[i] != null)
					model.setEBmeWgtQty(eBmeWgtQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eBmeDpkgQty[i] != null)
					model.setEBmeDpkgQty(eBmeDpkgQty[i]);
				if (eBmeWgtTp[i] != null)
					model.setEBmeWgtTp(eBmeWgtTp[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eBmeDivInd[i] != null)
					model.setEBmeDivInd(eBmeDivInd[i]);
				if (eBmeDwgtTp[i] != null)
					model.setEBmeDwgtTp(eBmeDwgtTp[i]);
				if (eBmeElno[i] != null)
					model.setEBmeElno(eBmeElno[i]);
				if (eBmeDivSeq[i] != null)
					model.setEBmeDivSeq(eBmeDivSeq[i]);
				if (eBmeSmpSeq[i] != null)
					model.setEBmeSmpSeq(eBmeSmpSeq[i]);
				if (eBmeDpkgTp[i] != null)
					model.setEBmeDpkgTp(eBmeDpkgTp[i]);
				if (eBmeDwgtQty[i] != null)
					model.setEBmeDwgtQty(eBmeDwgtQty[i]);
				if (eBmePkgQty[i] != null)
					model.setEBmePkgQty(eBmePkgQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchExportInfoDNVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchExportInfoDNVO[]
	 */
	public KorExportInfoDNVO[] getSearchExportInfoDNVOs(){
		KorExportInfoDNVO[] vos = (KorExportInfoDNVO[])models.toArray(new KorExportInfoDNVO[models.size()]);
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
		this.eBmePkgTp = this.eBmePkgTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eBmeWgtQty = this.eBmeWgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eBmeDpkgQty = this.eBmeDpkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eBmeWgtTp = this.eBmeWgtTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eBmeDivInd = this.eBmeDivInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eBmeDwgtTp = this.eBmeDwgtTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eBmeElno = this.eBmeElno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eBmeDivSeq = this.eBmeDivSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eBmeSmpSeq = this.eBmeSmpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eBmeDpkgTp = this.eBmeDpkgTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eBmeDwgtQty = this.eBmeDwgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eBmePkgQty = this.eBmePkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

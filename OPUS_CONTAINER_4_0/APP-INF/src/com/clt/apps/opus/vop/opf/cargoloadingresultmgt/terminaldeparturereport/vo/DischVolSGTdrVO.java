/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DischVolSGTdrVO.java
*@FileTitle : DischVolSGTdrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.23  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DischVolSGTdrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DischVolSGTdrVO> models = new ArrayList<DischVolSGTdrVO>();
	
	/* Column Info */
	private String ak20Wgt = null;
	/* Column Info */
	private String dg40Qty = null;
	/* Column Info */
	private String rf40Wgt = null;
	/* Column Info */
	private String rf20Qty = null;
	/* Column Info */
	private String rf40Qty = null;
	/* Column Info */
	private String dg20Wgt = null;
	/* Column Info */
	private String dg20Qty = null;
	/* Column Info */
	private String rf20Wgt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ak40Qty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ak40Wgt = null;
	/* Column Info */
	private String oprCd = null;
	/* Column Info */
	private String dg40Wgt = null;
	/* Column Info */
	private String idxSheet = null;
	/* Column Info */
	private String ak20Qty = null;
	/* Column Info */
	private String pod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DischVolSGTdrVO() {}

	public DischVolSGTdrVO(String ibflag, String pagerows, String oprCd, String pod, String dg20Qty, String dg20Wgt, String dg40Qty, String dg40Wgt, String rf20Qty, String rf20Wgt, String rf40Qty, String rf40Wgt, String ak20Qty, String ak20Wgt, String ak40Qty, String ak40Wgt, String idxSheet) {
		this.ak20Wgt = ak20Wgt;
		this.dg40Qty = dg40Qty;
		this.rf40Wgt = rf40Wgt;
		this.rf20Qty = rf20Qty;
		this.rf40Qty = rf40Qty;
		this.dg20Wgt = dg20Wgt;
		this.dg20Qty = dg20Qty;
		this.rf20Wgt = rf20Wgt;
		this.pagerows = pagerows;
		this.ak40Qty = ak40Qty;
		this.ibflag = ibflag;
		this.ak40Wgt = ak40Wgt;
		this.oprCd = oprCd;
		this.dg40Wgt = dg40Wgt;
		this.idxSheet = idxSheet;
		this.ak20Qty = ak20Qty;
		this.pod = pod;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ak_20_wgt", getAk20Wgt());
		this.hashColumns.put("dg_40_qty", getDg40Qty());
		this.hashColumns.put("rf_40_wgt", getRf40Wgt());
		this.hashColumns.put("rf_20_qty", getRf20Qty());
		this.hashColumns.put("rf_40_qty", getRf40Qty());
		this.hashColumns.put("dg_20_wgt", getDg20Wgt());
		this.hashColumns.put("dg_20_qty", getDg20Qty());
		this.hashColumns.put("rf_20_wgt", getRf20Wgt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ak_40_qty", getAk40Qty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ak_40_wgt", getAk40Wgt());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("dg_40_wgt", getDg40Wgt());
		this.hashColumns.put("idx_sheet", getIdxSheet());
		this.hashColumns.put("ak_20_qty", getAk20Qty());
		this.hashColumns.put("pod", getPod());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ak_20_wgt", "ak20Wgt");
		this.hashFields.put("dg_40_qty", "dg40Qty");
		this.hashFields.put("rf_40_wgt", "rf40Wgt");
		this.hashFields.put("rf_20_qty", "rf20Qty");
		this.hashFields.put("rf_40_qty", "rf40Qty");
		this.hashFields.put("dg_20_wgt", "dg20Wgt");
		this.hashFields.put("dg_20_qty", "dg20Qty");
		this.hashFields.put("rf_20_wgt", "rf20Wgt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ak_40_qty", "ak40Qty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ak_40_wgt", "ak40Wgt");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("dg_40_wgt", "dg40Wgt");
		this.hashFields.put("idx_sheet", "idxSheet");
		this.hashFields.put("ak_20_qty", "ak20Qty");
		this.hashFields.put("pod", "pod");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ak20Wgt
	 */
	public String getAk20Wgt() {
		return this.ak20Wgt;
	}
	
	/**
	 * Column Info
	 * @return dg40Qty
	 */
	public String getDg40Qty() {
		return this.dg40Qty;
	}
	
	/**
	 * Column Info
	 * @return rf40Wgt
	 */
	public String getRf40Wgt() {
		return this.rf40Wgt;
	}
	
	/**
	 * Column Info
	 * @return rf20Qty
	 */
	public String getRf20Qty() {
		return this.rf20Qty;
	}
	
	/**
	 * Column Info
	 * @return rf40Qty
	 */
	public String getRf40Qty() {
		return this.rf40Qty;
	}
	
	/**
	 * Column Info
	 * @return dg20Wgt
	 */
	public String getDg20Wgt() {
		return this.dg20Wgt;
	}
	
	/**
	 * Column Info
	 * @return dg20Qty
	 */
	public String getDg20Qty() {
		return this.dg20Qty;
	}
	
	/**
	 * Column Info
	 * @return rf20Wgt
	 */
	public String getRf20Wgt() {
		return this.rf20Wgt;
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
	 * @return ak40Qty
	 */
	public String getAk40Qty() {
		return this.ak40Qty;
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
	 * @return ak40Wgt
	 */
	public String getAk40Wgt() {
		return this.ak40Wgt;
	}
	
	/**
	 * Column Info
	 * @return oprCd
	 */
	public String getOprCd() {
		return this.oprCd;
	}
	
	/**
	 * Column Info
	 * @return dg40Wgt
	 */
	public String getDg40Wgt() {
		return this.dg40Wgt;
	}
	
	/**
	 * Column Info
	 * @return idxSheet
	 */
	public String getIdxSheet() {
		return this.idxSheet;
	}
	
	/**
	 * Column Info
	 * @return ak20Qty
	 */
	public String getAk20Qty() {
		return this.ak20Qty;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	

	/**
	 * Column Info
	 * @param ak20Wgt
	 */
	public void setAk20Wgt(String ak20Wgt) {
		this.ak20Wgt = ak20Wgt;
	}
	
	/**
	 * Column Info
	 * @param dg40Qty
	 */
	public void setDg40Qty(String dg40Qty) {
		this.dg40Qty = dg40Qty;
	}
	
	/**
	 * Column Info
	 * @param rf40Wgt
	 */
	public void setRf40Wgt(String rf40Wgt) {
		this.rf40Wgt = rf40Wgt;
	}
	
	/**
	 * Column Info
	 * @param rf20Qty
	 */
	public void setRf20Qty(String rf20Qty) {
		this.rf20Qty = rf20Qty;
	}
	
	/**
	 * Column Info
	 * @param rf40Qty
	 */
	public void setRf40Qty(String rf40Qty) {
		this.rf40Qty = rf40Qty;
	}
	
	/**
	 * Column Info
	 * @param dg20Wgt
	 */
	public void setDg20Wgt(String dg20Wgt) {
		this.dg20Wgt = dg20Wgt;
	}
	
	/**
	 * Column Info
	 * @param dg20Qty
	 */
	public void setDg20Qty(String dg20Qty) {
		this.dg20Qty = dg20Qty;
	}
	
	/**
	 * Column Info
	 * @param rf20Wgt
	 */
	public void setRf20Wgt(String rf20Wgt) {
		this.rf20Wgt = rf20Wgt;
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
	 * @param ak40Qty
	 */
	public void setAk40Qty(String ak40Qty) {
		this.ak40Qty = ak40Qty;
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
	 * @param ak40Wgt
	 */
	public void setAk40Wgt(String ak40Wgt) {
		this.ak40Wgt = ak40Wgt;
	}
	
	/**
	 * Column Info
	 * @param oprCd
	 */
	public void setOprCd(String oprCd) {
		this.oprCd = oprCd;
	}
	
	/**
	 * Column Info
	 * @param dg40Wgt
	 */
	public void setDg40Wgt(String dg40Wgt) {
		this.dg40Wgt = dg40Wgt;
	}
	
	/**
	 * Column Info
	 * @param idxSheet
	 */
	public void setIdxSheet(String idxSheet) {
		this.idxSheet = idxSheet;
	}
	
	/**
	 * Column Info
	 * @param ak20Qty
	 */
	public void setAk20Qty(String ak20Qty) {
		this.ak20Qty = ak20Qty;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAk20Wgt(JSPUtil.getParameter(request, "ak_20_wgt", ""));
		setDg40Qty(JSPUtil.getParameter(request, "dg_40_qty", ""));
		setRf40Wgt(JSPUtil.getParameter(request, "rf_40_wgt", ""));
		setRf20Qty(JSPUtil.getParameter(request, "rf_20_qty", ""));
		setRf40Qty(JSPUtil.getParameter(request, "rf_40_qty", ""));
		setDg20Wgt(JSPUtil.getParameter(request, "dg_20_wgt", ""));
		setDg20Qty(JSPUtil.getParameter(request, "dg_20_qty", ""));
		setRf20Wgt(JSPUtil.getParameter(request, "rf_20_wgt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setAk40Qty(JSPUtil.getParameter(request, "ak_40_qty", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAk40Wgt(JSPUtil.getParameter(request, "ak_40_wgt", ""));
		setOprCd(JSPUtil.getParameter(request, "opr_cd", ""));
		setDg40Wgt(JSPUtil.getParameter(request, "dg_40_wgt", ""));
		setIdxSheet(JSPUtil.getParameter(request, "idx_sheet", ""));
		setAk20Qty(JSPUtil.getParameter(request, "ak_20_qty", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DischVolSGTdrVO[]
	 */
	public DischVolSGTdrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DischVolSGTdrVO[]
	 */
	public DischVolSGTdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DischVolSGTdrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ak20Wgt = (JSPUtil.getParameter(request, prefix	+ "ak_20_wgt", length));
			String[] dg40Qty = (JSPUtil.getParameter(request, prefix	+ "dg_40_qty", length));
			String[] rf40Wgt = (JSPUtil.getParameter(request, prefix	+ "rf_40_wgt", length));
			String[] rf20Qty = (JSPUtil.getParameter(request, prefix	+ "rf_20_qty", length));
			String[] rf40Qty = (JSPUtil.getParameter(request, prefix	+ "rf_40_qty", length));
			String[] dg20Wgt = (JSPUtil.getParameter(request, prefix	+ "dg_20_wgt", length));
			String[] dg20Qty = (JSPUtil.getParameter(request, prefix	+ "dg_20_qty", length));
			String[] rf20Wgt = (JSPUtil.getParameter(request, prefix	+ "rf_20_wgt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ak40Qty = (JSPUtil.getParameter(request, prefix	+ "ak_40_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ak40Wgt = (JSPUtil.getParameter(request, prefix	+ "ak_40_wgt", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] dg40Wgt = (JSPUtil.getParameter(request, prefix	+ "dg_40_wgt", length));
			String[] idxSheet = (JSPUtil.getParameter(request, prefix	+ "idx_sheet", length));
			String[] ak20Qty = (JSPUtil.getParameter(request, prefix	+ "ak_20_qty", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			
			for (int i = 0; i < length; i++) {
				model = new DischVolSGTdrVO();
				if (ak20Wgt[i] != null)
					model.setAk20Wgt(ak20Wgt[i]);
				if (dg40Qty[i] != null)
					model.setDg40Qty(dg40Qty[i]);
				if (rf40Wgt[i] != null)
					model.setRf40Wgt(rf40Wgt[i]);
				if (rf20Qty[i] != null)
					model.setRf20Qty(rf20Qty[i]);
				if (rf40Qty[i] != null)
					model.setRf40Qty(rf40Qty[i]);
				if (dg20Wgt[i] != null)
					model.setDg20Wgt(dg20Wgt[i]);
				if (dg20Qty[i] != null)
					model.setDg20Qty(dg20Qty[i]);
				if (rf20Wgt[i] != null)
					model.setRf20Wgt(rf20Wgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ak40Qty[i] != null)
					model.setAk40Qty(ak40Qty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ak40Wgt[i] != null)
					model.setAk40Wgt(ak40Wgt[i]);
				if (oprCd[i] != null)
					model.setOprCd(oprCd[i]);
				if (dg40Wgt[i] != null)
					model.setDg40Wgt(dg40Wgt[i]);
				if (idxSheet[i] != null)
					model.setIdxSheet(idxSheet[i]);
				if (ak20Qty[i] != null)
					model.setAk20Qty(ak20Qty[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDischVolSGTdrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DischVolSGTdrVO[]
	 */
	public DischVolSGTdrVO[] getDischVolSGTdrVOs(){
		DischVolSGTdrVO[] vos = (DischVolSGTdrVO[])models.toArray(new DischVolSGTdrVO[models.size()]);
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
		this.ak20Wgt = this.ak20Wgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg40Qty = this.dg40Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40Wgt = this.rf40Wgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20Qty = this.rf20Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40Qty = this.rf40Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg20Wgt = this.dg20Wgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg20Qty = this.dg20Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20Wgt = this.rf20Wgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak40Qty = this.ak40Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak40Wgt = this.ak40Wgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg40Wgt = this.dg40Wgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idxSheet = this.idxSheet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak20Qty = this.ak20Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

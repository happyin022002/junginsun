/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RDRSlotUtilVO.java
*@FileTitle : RDRSlotUtilVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.07.22 이선영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo;

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
 * @author 이선영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RDRSlotUtilVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RDRSlotUtilVO> models = new ArrayList<RDRSlotUtilVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String full = null;
	/* Column Info */
	private String oprCd = null;
	/* Column Info */
	private String empty = null;
	/* Column Info */
	private String totalWgt = null;
	/* Column Info */
	private String totalSlot = null;
	/* Column Info */
	private String akbb = null;
	/* Column Info */
	private String hc45 = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RDRSlotUtilVO() {}

	public RDRSlotUtilVO(String ibflag, String pagerows, String oprCd, String full, String empty, String akbb, String hc45, String totalSlot, String totalWgt) {
		this.ibflag = ibflag;
		this.full = full;
		this.oprCd = oprCd;
		this.empty = empty;
		this.totalWgt = totalWgt;
		this.totalSlot = totalSlot;
		this.akbb = akbb;
		this.hc45 = hc45;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("full", getFull());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("empty", getEmpty());
		this.hashColumns.put("total_wgt", getTotalWgt());
		this.hashColumns.put("total_slot", getTotalSlot());
		this.hashColumns.put("akbb", getAkbb());
		this.hashColumns.put("hc45", getHc45());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("full", "full");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("empty", "empty");
		this.hashFields.put("total_wgt", "totalWgt");
		this.hashFields.put("total_slot", "totalSlot");
		this.hashFields.put("akbb", "akbb");
		this.hashFields.put("hc45", "hc45");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return full
	 */
	public String getFull() {
		return this.full;
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
	 * @return empty
	 */
	public String getEmpty() {
		return this.empty;
	}
	
	/**
	 * Column Info
	 * @return totalWgt
	 */
	public String getTotalWgt() {
		return this.totalWgt;
	}
	
	/**
	 * Column Info
	 * @return totalSlot
	 */
	public String getTotalSlot() {
		return this.totalSlot;
	}
	
	/**
	 * Column Info
	 * @return akbb
	 */
	public String getAkbb() {
		return this.akbb;
	}
	
	/**
	 * Column Info
	 * @return hc45
	 */
	public String getHc45() {
		return this.hc45;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param full
	 */
	public void setFull(String full) {
		this.full = full;
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
	 * @param empty
	 */
	public void setEmpty(String empty) {
		this.empty = empty;
	}
	
	/**
	 * Column Info
	 * @param totalWgt
	 */
	public void setTotalWgt(String totalWgt) {
		this.totalWgt = totalWgt;
	}
	
	/**
	 * Column Info
	 * @param totalSlot
	 */
	public void setTotalSlot(String totalSlot) {
		this.totalSlot = totalSlot;
	}
	
	/**
	 * Column Info
	 * @param akbb
	 */
	public void setAkbb(String akbb) {
		this.akbb = akbb;
	}
	
	/**
	 * Column Info
	 * @param hc45
	 */
	public void setHc45(String hc45) {
		this.hc45 = hc45;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFull(JSPUtil.getParameter(request, "full", ""));
		setOprCd(JSPUtil.getParameter(request, "opr_cd", ""));
		setEmpty(JSPUtil.getParameter(request, "empty", ""));
		setTotalWgt(JSPUtil.getParameter(request, "total_wgt", ""));
		setTotalSlot(JSPUtil.getParameter(request, "total_slot", ""));
		setAkbb(JSPUtil.getParameter(request, "akbb", ""));
		setHc45(JSPUtil.getParameter(request, "hc45", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RDRSlotUtilVO[]
	 */
	public RDRSlotUtilVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RDRSlotUtilVO[]
	 */
	public RDRSlotUtilVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RDRSlotUtilVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] full = (JSPUtil.getParameter(request, prefix	+ "full", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] empty = (JSPUtil.getParameter(request, prefix	+ "empty", length));
			String[] totalWgt = (JSPUtil.getParameter(request, prefix	+ "total_wgt", length));
			String[] totalSlot = (JSPUtil.getParameter(request, prefix	+ "total_slot", length));
			String[] akbb = (JSPUtil.getParameter(request, prefix	+ "akbb", length));
			String[] hc45 = (JSPUtil.getParameter(request, prefix	+ "hc45", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RDRSlotUtilVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (full[i] != null)
					model.setFull(full[i]);
				if (oprCd[i] != null)
					model.setOprCd(oprCd[i]);
				if (empty[i] != null)
					model.setEmpty(empty[i]);
				if (totalWgt[i] != null)
					model.setTotalWgt(totalWgt[i]);
				if (totalSlot[i] != null)
					model.setTotalSlot(totalSlot[i]);
				if (akbb[i] != null)
					model.setAkbb(akbb[i]);
				if (hc45[i] != null)
					model.setHc45(hc45[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRDRSlotUtilVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RDRSlotUtilVO[]
	 */
	public RDRSlotUtilVO[] getRDRSlotUtilVOs(){
		RDRSlotUtilVO[] vos = (RDRSlotUtilVO[])models.toArray(new RDRSlotUtilVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full = this.full .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.empty = this.empty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalWgt = this.totalWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSlot = this.totalSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akbb = this.akbb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hc45 = this.hc45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

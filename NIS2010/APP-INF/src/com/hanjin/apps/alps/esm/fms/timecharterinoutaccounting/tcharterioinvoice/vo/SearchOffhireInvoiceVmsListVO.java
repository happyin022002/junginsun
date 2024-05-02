/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchOffhireInvoiceVmsListVO.java
*@FileTitle : SearchOffhireInvoiceVmsListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.05.13 정윤태 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 정윤태
 * @since J2EE 1.5
 * @see ESM_FMS_0073HTMLAction
 */

public class SearchOffhireInvoiceVmsListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOffhireInvoiceVmsListVO> models = new ArrayList<SearchOffhireInvoiceVmsListVO>();
	
	/* Column Info */
	private String csrSlpFlg = null;
	/* Column Info */
	private String offhDurDys = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String onhDtDay = null;
	/* Column Info */
	private String foilQty = null;
	/* Column Info */
	private String offhDesc = null;
	/* Column Info */
	private String doilQty = null;
	/* Column Info */
	private String foilPrc = null;
	/* Column Info */
	private String onhDtTime = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String offhSeq = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String doilPrc = null;
	/* Column Info */
	private String fletAccTpCd = null;
	/* Column Info */
	private String offhRsn = null;
	/* Column Info */
	private String offhDtDay = null;
	/* Column Info */
	private String offhDtTime = null;
	/* Column Info */
	private String useFlg = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public SearchOffhireInvoiceVmsListVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String vslCd, String offhDtDay, String offhDtTime, String onhDtDay, String onhDtTime, String offhDurDys, String fletAccTpCd, String foilQty, String foilPrc, String doilQty, String doilPrc, String csrSlpFlg, String offhRsn, String offhDesc, String offhSeq, String useFlg
	 * @return 
	 */
	public SearchOffhireInvoiceVmsListVO(String ibflag, String pagerows, String vslCd, String offhDtDay, String offhDtTime, String onhDtDay, String onhDtTime, String offhDurDys, String fletAccTpCd, String foilQty, String foilPrc, String doilQty, String doilPrc, String csrSlpFlg, String offhRsn, String offhDesc, String offhSeq, String useFlg) {
		this.csrSlpFlg = csrSlpFlg;
		this.offhDurDys = offhDurDys;
		this.vslCd = vslCd;
		this.onhDtDay = onhDtDay;
		this.foilQty = foilQty;
		this.offhDesc = offhDesc;
		this.doilQty = doilQty;
		this.foilPrc = foilPrc;
		this.onhDtTime = onhDtTime;
		this.pagerows = pagerows;
		this.offhSeq = offhSeq;
		this.ibflag = ibflag;
		this.doilPrc = doilPrc;
		this.fletAccTpCd = fletAccTpCd;
		this.offhRsn = offhRsn;
		this.offhDtDay = offhDtDay;
		this.offhDtTime = offhDtTime;
		this.useFlg = useFlg;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("csr_slp_flg", getCsrSlpFlg());
		this.hashColumns.put("offh_dur_dys", getOffhDurDys());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("onh_dt_day", getOnhDtDay());
		this.hashColumns.put("foil_qty", getFoilQty());
		this.hashColumns.put("offh_desc", getOffhDesc());
		this.hashColumns.put("doil_qty", getDoilQty());
		this.hashColumns.put("foil_prc", getFoilPrc());
		this.hashColumns.put("onh_dt_time", getOnhDtTime());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("offh_seq", getOffhSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("doil_prc", getDoilPrc());
		this.hashColumns.put("flet_acc_tp_cd", getFletAccTpCd());
		this.hashColumns.put("offh_rsn", getOffhRsn());
		this.hashColumns.put("offh_dt_day", getOffhDtDay());
		this.hashColumns.put("offh_dt_time", getOffhDtTime());
		this.hashColumns.put("use_flg", getUseFlg());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("csr_slp_flg", "csrSlpFlg");
		this.hashFields.put("offh_dur_dys", "offhDurDys");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("onh_dt_day", "onhDtDay");
		this.hashFields.put("foil_qty", "foilQty");
		this.hashFields.put("offh_desc", "offhDesc");
		this.hashFields.put("doil_qty", "doilQty");
		this.hashFields.put("foil_prc", "foilPrc");
		this.hashFields.put("onh_dt_time", "onhDtTime");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("offh_seq", "offhSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("doil_prc", "doilPrc");
		this.hashFields.put("flet_acc_tp_cd", "fletAccTpCd");
		this.hashFields.put("offh_rsn", "offhRsn");
		this.hashFields.put("offh_dt_day", "offhDtDay");
		this.hashFields.put("offh_dt_time", "offhDtTime");
		this.hashFields.put("use_flg", "useFlg");
		return this.hashFields;
	}
	
	public String getCsrSlpFlg() {
		return this.csrSlpFlg;
	}
	public String getOffhDurDys() {
		return this.offhDurDys;
	}
	public String getVslCd() {
		return this.vslCd;
	}
	public String getOnhDtDay() {
		return this.onhDtDay;
	}
	public String getFoilQty() {
		return this.foilQty;
	}
	public String getOffhDesc() {
		return this.offhDesc;
	}
	public String getDoilQty() {
		return this.doilQty;
	}
	public String getFoilPrc() {
		return this.foilPrc;
	}
	public String getOnhDtTime() {
		return this.onhDtTime;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getOffhSeq() {
		return this.offhSeq;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getDoilPrc() {
		return this.doilPrc;
	}
	public String getFletAccTpCd() {
		return this.fletAccTpCd;
	}
	public String getOffhRsn() {
		return this.offhRsn;
	}
	public String getOffhDtDay() {
		return this.offhDtDay;
	}
	public String getOffhDtTime() {
		return this.offhDtTime;
	}
	public String getUseFlg() {
		return this.useFlg;
	}

	public void setCsrSlpFlg(String csrSlpFlg) {
		this.csrSlpFlg = csrSlpFlg;
		//this.csrSlpFlg=true;
	}
	public void setOffhDurDys(String offhDurDys) {
		this.offhDurDys = offhDurDys;
		//this.offhDurDys=true;
	}
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
		//this.vslCd=true;
	}
	public void setOnhDtDay(String onhDtDay) {
		this.onhDtDay = onhDtDay;
		//this.onhDtDay=true;
	}
	public void setFoilQty(String foilQty) {
		this.foilQty = foilQty;
		//this.foilQty=true;
	}
	public void setOffhDesc(String offhDesc) {
		this.offhDesc = offhDesc;
		//this.offhDesc=true;
	}
	public void setDoilQty(String doilQty) {
		this.doilQty = doilQty;
		//this.doilQty=true;
	}
	public void setFoilPrc(String foilPrc) {
		this.foilPrc = foilPrc;
		//this.foilPrc=true;
	}
	public void setOnhDtTime(String onhDtTime) {
		this.onhDtTime = onhDtTime;
		//this.onhDtTime=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setOffhSeq(String offhSeq) {
		this.offhSeq = offhSeq;
		//this.offhSeq=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setDoilPrc(String doilPrc) {
		this.doilPrc = doilPrc;
		//this.doilPrc=true;
	}
	public void setFletAccTpCd(String fletAccTpCd) {
		this.fletAccTpCd = fletAccTpCd;
		//this.fletAccTpCd=true;
	}
	public void setOffhRsn(String offhRsn) {
		this.offhRsn = offhRsn;
		//this.offhRsn=true;
	}
	public void setOffhDtDay(String offhDtDay) {
		this.offhDtDay = offhDtDay;
		//this.offhDtDay=true;
	}
	public void setOffhDtTime(String offhDtTime) {
		this.offhDtTime = offhDtTime;
		//this.offhDtTime=true;
	}
	public void setUseFlg(String useFlg) {
		this.useFlg = useFlg;
		//this.useFlg=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setCsrSlpFlg(JSPUtil.getParameter(request, "csr_slp_flg", ""));
		setOffhDurDys(JSPUtil.getParameter(request, "offh_dur_dys", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setOnhDtDay(JSPUtil.getParameter(request, "onh_dt_day", ""));
		setFoilQty(JSPUtil.getParameter(request, "foil_qty", ""));
		setOffhDesc(JSPUtil.getParameter(request, "offh_desc", ""));
		setDoilQty(JSPUtil.getParameter(request, "doil_qty", ""));
		setFoilPrc(JSPUtil.getParameter(request, "foil_prc", ""));
		setOnhDtTime(JSPUtil.getParameter(request, "onh_dt_time", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOffhSeq(JSPUtil.getParameter(request, "offh_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDoilPrc(JSPUtil.getParameter(request, "doil_prc", ""));
		setFletAccTpCd(JSPUtil.getParameter(request, "flet_acc_tp_cd", ""));
		setOffhRsn(JSPUtil.getParameter(request, "offh_rsn", ""));
		setOffhDtDay(JSPUtil.getParameter(request, "offh_dt_day", ""));
		setOffhDtTime(JSPUtil.getParameter(request, "offh_dt_time", ""));
		setUseFlg(JSPUtil.getParameter(request, "use_flg", ""));
	}

	public SearchOffhireInvoiceVmsListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public SearchOffhireInvoiceVmsListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOffhireInvoiceVmsListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] csrSlpFlg = (JSPUtil.getParameter(request, prefix	+ "csr_slp_flg".trim(), length));
			String[] offhDurDys = (JSPUtil.getParameter(request, prefix	+ "offh_dur_dys".trim(), length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] onhDtDay = (JSPUtil.getParameter(request, prefix	+ "onh_dt_day".trim(), length));
			String[] foilQty = (JSPUtil.getParameter(request, prefix	+ "foil_qty".trim(), length));
			String[] offhDesc = (JSPUtil.getParameter(request, prefix	+ "offh_desc".trim(), length));
			String[] doilQty = (JSPUtil.getParameter(request, prefix	+ "doil_qty".trim(), length));
			String[] foilPrc = (JSPUtil.getParameter(request, prefix	+ "foil_prc".trim(), length));
			String[] onhDtTime = (JSPUtil.getParameter(request, prefix	+ "onh_dt_time".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] offhSeq = (JSPUtil.getParameter(request, prefix	+ "offh_seq".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] doilPrc = (JSPUtil.getParameter(request, prefix	+ "doil_prc".trim(), length));
			String[] fletAccTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_acc_tp_cd".trim(), length));
			String[] offhRsn = (JSPUtil.getParameter(request, prefix	+ "offh_rsn".trim(), length));
			String[] offhDtDay = (JSPUtil.getParameter(request, prefix	+ "offh_dt_day".trim(), length));
			String[] offhDtTime = (JSPUtil.getParameter(request, prefix	+ "offh_dt_time".trim(), length));
			String[] useFlg = (JSPUtil.getParameter(request, prefix	+ "use_flg".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOffhireInvoiceVmsListVO();
				if (csrSlpFlg[i] != null)
					model.setCsrSlpFlg(csrSlpFlg[i]);
				if (offhDurDys[i] != null)
					model.setOffhDurDys(offhDurDys[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (onhDtDay[i] != null)
					model.setOnhDtDay(onhDtDay[i]);
				if (foilQty[i] != null)
					model.setFoilQty(foilQty[i]);
				if (offhDesc[i] != null)
					model.setOffhDesc(offhDesc[i]);
				if (doilQty[i] != null)
					model.setDoilQty(doilQty[i]);
				if (foilPrc[i] != null)
					model.setFoilPrc(foilPrc[i]);
				if (onhDtTime[i] != null)
					model.setOnhDtTime(onhDtTime[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (offhSeq[i] != null)
					model.setOffhSeq(offhSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (doilPrc[i] != null)
					model.setDoilPrc(doilPrc[i]);
				if (fletAccTpCd[i] != null)
					model.setFletAccTpCd(fletAccTpCd[i]);
				if (offhRsn[i] != null)
					model.setOffhRsn(offhRsn[i]);
				if (offhDtDay[i] != null)
					model.setOffhDtDay(offhDtDay[i]);
				if (offhDtTime[i] != null)
					model.setOffhDtTime(offhDtTime[i]);
				if (useFlg[i] != null)
					model.setUseFlg(useFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getSearchOffhireInvoiceVmsListVOs();
	}

	public SearchOffhireInvoiceVmsListVO[] getSearchOffhireInvoiceVmsListVOs(){
		SearchOffhireInvoiceVmsListVO[] vos = (SearchOffhireInvoiceVmsListVO[])models.toArray(new SearchOffhireInvoiceVmsListVO[models.size()]);
		return vos;
	}
	
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
		} catch (Exception ex) {}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.csrSlpFlg = this.csrSlpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhDurDys = this.offhDurDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDtDay = this.onhDtDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilQty = this.foilQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhDesc = this.offhDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilQty = this.doilQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilPrc = this.foilPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDtTime = this.onhDtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhSeq = this.offhSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilPrc = this.doilPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletAccTpCd = this.fletAccTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhRsn = this.offhRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhDtDay = this.offhDtDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhDtTime = this.offhDtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.useFlg = this.useFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

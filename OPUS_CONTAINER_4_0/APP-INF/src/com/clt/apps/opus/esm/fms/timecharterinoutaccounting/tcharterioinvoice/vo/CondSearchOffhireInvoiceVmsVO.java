/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CondSearchOffhireInvoiceVmsVO.java
*@FileTitle : CondSearchOffhireInvoiceVmsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.05.13 정윤태 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 정윤태
 * @since J2EE 1.5
 * @see ESM_FMS_0073HTMLAction
 */

public class CondSearchOffhireInvoiceVmsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CondSearchOffhireInvoiceVmsVO> models = new ArrayList<CondSearchOffhireInvoiceVmsVO>();
	
	/* Column Info */
	private String csrSlpFlg = null;
	/* Column Info */
	private String vslCd = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String fletAccTpCd = null;
	/* Column Info */
	private String offhDt = null;
	/* Column Info */
	private String onhDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public CondSearchOffhireInvoiceVmsVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String vslCd, String offhDt, String onhDt, String fletAccTpCd, String csrSlpFlg
	 * @return 
	 */
	public CondSearchOffhireInvoiceVmsVO(String ibflag, String pagerows, String vslCd, String offhDt, String onhDt, String fletAccTpCd, String csrSlpFlg) {
		this.csrSlpFlg = csrSlpFlg;
		this.vslCd = vslCd;
		this.ibflag = ibflag;
		this.fletAccTpCd = fletAccTpCd;
		this.offhDt = offhDt;
		this.onhDt = onhDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("csr_slp_flg", getCsrSlpFlg());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("flet_acc_tp_cd", getFletAccTpCd());
		this.hashColumns.put("offh_dt", getOffhDt());
		this.hashColumns.put("onh_dt", getOnhDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("csr_slp_flg", "csrSlpFlg");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("flet_acc_tp_cd", "fletAccTpCd");
		this.hashFields.put("offh_dt", "offhDt");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getCsrSlpFlg() {
		return this.csrSlpFlg;
	}
	public String getVslCd() {
		return this.vslCd;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getFletAccTpCd() {
		return this.fletAccTpCd;
	}
	public String getOffhDt() {
		return this.offhDt;
	}
	public String getOnhDt() {
		return this.onhDt;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setCsrSlpFlg(String csrSlpFlg) {
		this.csrSlpFlg = csrSlpFlg;
		//this.csrSlpFlg=true;
	}
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
		//this.vslCd=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setFletAccTpCd(String fletAccTpCd) {
		this.fletAccTpCd = fletAccTpCd;
		//this.fletAccTpCd=true;
	}
	public void setOffhDt(String offhDt) {
		this.offhDt = offhDt;
		//this.offhDt=true;
	}
	public void setOnhDt(String onhDt) {
		this.onhDt = onhDt;
		//this.onhDt=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setCsrSlpFlg(JSPUtil.getParameter(request, "csr_slp_flg", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFletAccTpCd(JSPUtil.getParameter(request, "flet_acc_tp_cd", ""));
		setOffhDt(JSPUtil.getParameter(request, "offh_dt", ""));
		setOnhDt(JSPUtil.getParameter(request, "onh_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public CondSearchOffhireInvoiceVmsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CondSearchOffhireInvoiceVmsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CondSearchOffhireInvoiceVmsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] csrSlpFlg = (JSPUtil.getParameter(request, prefix	+ "csr_slp_flg".trim(), length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] fletAccTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_acc_tp_cd".trim(), length));
			String[] offhDt = (JSPUtil.getParameter(request, prefix	+ "offh_dt".trim(), length));
			String[] onhDt = (JSPUtil.getParameter(request, prefix	+ "onh_dt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CondSearchOffhireInvoiceVmsVO();
				if (csrSlpFlg[i] != null)
					model.setCsrSlpFlg(csrSlpFlg[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fletAccTpCd[i] != null)
					model.setFletAccTpCd(fletAccTpCd[i]);
				if (offhDt[i] != null)
					model.setOffhDt(offhDt[i]);
				if (onhDt[i] != null)
					model.setOnhDt(onhDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getCondSearchOffhireInvoiceVmsVOs();
	}

	public CondSearchOffhireInvoiceVmsVO[] getCondSearchOffhireInvoiceVmsVOs(){
		CondSearchOffhireInvoiceVmsVO[] vos = (CondSearchOffhireInvoiceVmsVO[])models.toArray(new CondSearchOffhireInvoiceVmsVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletAccTpCd = this.fletAccTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhDt = this.offhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt = this.onhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

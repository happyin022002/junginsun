/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VVDCustomerVO.java
*@FileTitle : VVDCustomerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.05.27 정휘택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo;

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
 * @author 정휘택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VVDCustomerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VVDCustomerVO> models = new ArrayList<VVDCustomerVO>();
	
	/* Column Info */
	private String invCntryCd = null;
	/* Column Info */
	private String invCustCd = null;
	/* Column Info */
	private String voy = null;
	/* Column Info */
	private String lclCurr = null;
	/* Column Info */
	private String svcScp = null;
	/* Column Info */
	private String bnd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String saDt = null;
	/* Column Info */
	private String vsl = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String curr = null;
	/* Column Info */
	private String dep = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String por = null;
	/* Column Info */
	private String blSrcNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VVDCustomerVO() {}

	public VVDCustomerVO(String ibflag, String pagerows, String invCntryCd, String invCustCd, String ofcCd, String lclCurr, String curr, String bnd, String vsl, String voy, String dep, String pol, String pod, String arIfNo, String saDt, String bkgNo, String svcScp, String del,String por, String blSrcNo) {
		this.invCntryCd = invCntryCd;
		this.invCustCd = invCustCd;
		this.voy = voy;
		this.lclCurr = lclCurr;
		this.svcScp = svcScp;
		this.bnd = bnd;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.saDt = saDt;
		this.vsl = vsl;
		this.pol = pol;
		this.curr = curr;
		this.dep = dep;
		this.pod = pod;
		this.arIfNo = arIfNo;
		this.del = del;
		this.por = por;
		this.blSrcNo = blSrcNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_cntry_cd", getInvCntryCd());
		this.hashColumns.put("inv_cust_cd", getInvCustCd());
		this.hashColumns.put("voy", getVoy());
		this.hashColumns.put("lcl_curr", getLclCurr());
		this.hashColumns.put("svc_scp", getSvcScp());
		this.hashColumns.put("bnd", getBnd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sa_dt", getSaDt());
		this.hashColumns.put("vsl", getVsl());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("curr", getCurr());
		this.hashColumns.put("dep", getDep());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("por", getPor());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inv_cntry_cd", "invCntryCd");
		this.hashFields.put("inv_cust_cd", "invCustCd");
		this.hashFields.put("voy", "voy");
		this.hashFields.put("lcl_curr", "lclCurr");
		this.hashFields.put("svc_scp", "svcScp");
		this.hashFields.put("bnd", "bnd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sa_dt", "saDt");
		this.hashFields.put("vsl", "vsl");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("curr", "curr");
		this.hashFields.put("dep", "dep");
		this.hashFields.put("pod", "pod");
		this.hashColumns.put("ar_if_no", arIfNo);
		this.hashColumns.put("del", del);
		this.hashColumns.put("por", por);
		this.hashColumns.put("bl_src_no", blSrcNo);
		return this.hashFields;
	}
	
	
	/**
	 * @return the blSrcNo
	 */
	public String getBlSrcNo() {
		return blSrcNo;
	}

	/**
	 * @param blSrcNo the blSrcNo to set
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}

	/**
	 * @return the del
	 */
	public String getDel() {
		return del;
	}

	/**
	 * @param del the del to set
	 */
	public void setDel(String del) {
		this.del = del;
	}

	/**
	 * @return the por
	 */
	public String getPor() {
		return por;
	}

	/**
	 * @param por the por to set
	 */
	public void setPor(String por) {
		this.por = por;
	}

	/**
	 * Column Info
	 * @return invCntryCd
	 */
	public String getInvCntryCd() {
		return this.invCntryCd;
	}
	
	/**
	 * Column Info
	 * @return invCustCd
	 */
	public String getInvCustCd() {
		return this.invCustCd;
	}
	
	/**
	 * Column Info
	 * @return voy
	 */
	public String getVoy() {
		return this.voy;
	}
	
	/**
	 * Column Info
	 * @return lclCurr
	 */
	public String getLclCurr() {
		return this.lclCurr;
	}
	
	/**
	 * Column Info
	 * @return svcScp
	 */
	public String getSvcScp() {
		return this.svcScp;
	}
	
	/**
	 * Column Info
	 * @return bnd
	 */
	public String getBnd() {
		return this.bnd;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return saDt
	 */
	public String getSaDt() {
		return this.saDt;
	}
	
	/**
	 * Column Info
	 * @return vsl
	 */
	public String getVsl() {
		return this.vsl;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return curr
	 */
	public String getCurr() {
		return this.curr;
	}
	
	/**
	 * Column Info
	 * @return dep
	 */
	public String getDep() {
		return this.dep;
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
	 * @param invCntryCd
	 */
	public void setInvCntryCd(String invCntryCd) {
		this.invCntryCd = invCntryCd;
	}
	
	/**
	 * Column Info
	 * @param invCustCd
	 */
	public void setInvCustCd(String invCustCd) {
		this.invCustCd = invCustCd;
	}
	
	/**
	 * Column Info
	 * @param voy
	 */
	public void setVoy(String voy) {
		this.voy = voy;
	}
	
	/**
	 * Column Info
	 * @param lclCurr
	 */
	public void setLclCurr(String lclCurr) {
		this.lclCurr = lclCurr;
	}
	
	/**
	 * Column Info
	 * @param svcScp
	 */
	public void setSvcScp(String svcScp) {
		this.svcScp = svcScp;
	}
	
	/**
	 * Column Info
	 * @param bnd
	 */
	public void setBnd(String bnd) {
		this.bnd = bnd;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param saDt
	 */
	public void setSaDt(String saDt) {
		this.saDt = saDt;
	}
	
	/**
	 * Column Info
	 * @param vsl
	 */
	public void setVsl(String vsl) {
		this.vsl = vsl;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param curr
	 */
	public void setCurr(String curr) {
		this.curr = curr;
	}
	
	/**
	 * Column Info
	 * @param dep
	 */
	public void setDep(String dep) {
		this.dep = dep;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * @return the arIfNo
	 */
	public String getArIfNo() {
		return arIfNo;
	}

	/**
	 * @param arIfNo the arIfNo to set
	 */
	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setInvCntryCd(JSPUtil.getParameter(request, "inv_cntry_cd", ""));
		setInvCustCd(JSPUtil.getParameter(request, "inv_cust_cd", ""));
		setVoy(JSPUtil.getParameter(request, "voy", ""));
		setLclCurr(JSPUtil.getParameter(request, "lcl_curr", ""));
		setSvcScp(JSPUtil.getParameter(request, "svc_scp", ""));
		setBnd(JSPUtil.getParameter(request, "bnd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSaDt(JSPUtil.getParameter(request, "sa_dt", ""));
		setVsl(JSPUtil.getParameter(request, "vsl", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setCurr(JSPUtil.getParameter(request, "curr", ""));
		setDep(JSPUtil.getParameter(request, "dep", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setArIfNo(JSPUtil.getParameter(request, "ar_if_no", ""));
		setDel(JSPUtil.getParameter(request, "del", ""));
		setPor(JSPUtil.getParameter(request, "por", ""));
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VVDCustomerVO[]
	 */
	public VVDCustomerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VVDCustomerVO[]
	 */
	public VVDCustomerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VVDCustomerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] invCntryCd = (JSPUtil.getParameter(request, prefix	+ "inv_cntry_cd".trim(), length));
			String[] invCustCd = (JSPUtil.getParameter(request, prefix	+ "inv_cust_cd".trim(), length));
			String[] voy = (JSPUtil.getParameter(request, prefix	+ "voy".trim(), length));
			String[] lclCurr = (JSPUtil.getParameter(request, prefix	+ "lcl_curr".trim(), length));
			String[] svcScp = (JSPUtil.getParameter(request, prefix	+ "svc_scp".trim(), length));
			String[] bnd = (JSPUtil.getParameter(request, prefix	+ "bnd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] saDt = (JSPUtil.getParameter(request, prefix	+ "sa_dt".trim(), length));
			String[] vsl = (JSPUtil.getParameter(request, prefix	+ "vsl".trim(), length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol".trim(), length));
			String[] curr = (JSPUtil.getParameter(request, prefix	+ "curr".trim(), length));
			String[] dep = (JSPUtil.getParameter(request, prefix	+ "dep".trim(), length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod".trim(), length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no".trim(), length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del".trim(), length));
			String[] por = (JSPUtil.getParameter(request, prefix	+ "por".trim(), length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new VVDCustomerVO();
				if (invCntryCd[i] != null)
					model.setInvCntryCd(invCntryCd[i]);
				if (invCustCd[i] != null)
					model.setInvCustCd(invCustCd[i]);
				if (voy[i] != null)
					model.setVoy(voy[i]);
				if (lclCurr[i] != null)
					model.setLclCurr(lclCurr[i]);
				if (svcScp[i] != null)
					model.setSvcScp(svcScp[i]);
				if (bnd[i] != null)
					model.setBnd(bnd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (saDt[i] != null)
					model.setSaDt(saDt[i]);
				if (vsl[i] != null)
					model.setVsl(vsl[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (curr[i] != null)
					model.setCurr(curr[i]);
				if (dep[i] != null)
					model.setDep(dep[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (por[i] != null)
					model.setPor(por[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVVDCustomerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VVDCustomerVO[]
	 */
	public VVDCustomerVO[] getVVDCustomerVOs(){
		VVDCustomerVO[] vos = (VVDCustomerVO[])models.toArray(new VVDCustomerVO[models.size()]);
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
		this.invCntryCd = this.invCntryCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustCd = this.invCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voy = this.voy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclCurr = this.lclCurr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScp = this.svcScp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnd = this.bnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saDt = this.saDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vsl = this.vsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curr = this.curr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dep = this.dep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por = this.por .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}

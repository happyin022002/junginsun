/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgListForPortAssignVO.java
*@FileTitle : BkgListForPortAssignVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.10.14 최영희 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최영희
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgListForPortAssignVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgListForPortAssignVO> models = new ArrayList<BkgListForPortAssignVO>();
	
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String result = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ts3 = null;
	/* Column Info */
	private String ts2 = null;
	/* Column Info */
	private String ts1 = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String porNodCd = null;
	/* Column Info */
	private String polNodCd = null;
	/* Column Info */
	private String podNodCd = null;
	/* Column Info */
	private String delNodCd = null;
	/* Column Info */
	private String orgTrnsModCd = null;
	/* Column Info */
	private String destTrnsModCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgListForPortAssignVO() {}

	public BkgListForPortAssignVO(String ibflag, String pagerows, String bkgNo, String blNo, String pol, String ts1, String ts2, String ts3, String podCd, String result, String porCd, String delCd, String porNodCd, String polNodCd, String podNodCd, String delNodCd, String orgTrnsModCd, String destTrnsModCd) {
		this.podCd = podCd;
		this.result = result;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.ts3 = ts3;
		this.ts2 = ts2;
		this.ts1 = ts1;
		this.pol = pol;
		this.blNo = blNo;
		this.porCd = porCd;
		this.delCd = delCd;
		this.porNodCd = porNodCd;
		this.polNodCd = polNodCd;
		this.podNodCd = podNodCd;
		this.delNodCd = delNodCd;
		this.orgTrnsModCd = orgTrnsModCd;
		this.destTrnsModCd = destTrnsModCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("result", getResult());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ts3", getTs3());
		this.hashColumns.put("ts2", getTs2());
		this.hashColumns.put("ts1", getTs1());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("por_nod_cd", getPorNodCd());
		this.hashColumns.put("pol_nod_cd", getPolNodCd());
		this.hashColumns.put("pod_nod_cd", getPodNodCd());
		this.hashColumns.put("del_nod_cd", getDelNodCd());
		this.hashColumns.put("org_trns_mod_cd", getOrgTrnsModCd());
		this.hashColumns.put("dest_trns_mod_cd", getDestTrnsModCd());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("result", "result");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ts3", "ts3");
		this.hashFields.put("ts2", "ts2");
		this.hashFields.put("ts1", "ts1");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("por_nod_cd", "porNodCd");
		this.hashFields.put("pol_nod_cd", "polNodCd");
		this.hashFields.put("pod_nod_cd", "podNodCd");
		this.hashFields.put("del_nod_cd", "delNodCd");
		this.hashFields.put("org_trns_mod_cd", "orgTrnsModCd");
		this.hashFields.put("dest_trns_mod_cd", "destTrnsModCd");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return orgTrnsModCd
	 */
	public String getOrgTrnsModCd() {
		return this.orgTrnsModCd;
	}
	/**
	 * Column Info
	 * @return destTrnsModCd
	 */
	public String getDestTrnsModCd() {
		return this.destTrnsModCd;
	}
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}	
	
	/**
	 * Column Info
	 * @return result
	 */
	public String getResult() {
		return this.result;
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
	 * @return ts3
	 */
	public String getTs3() {
		return this.ts3;
	}
	
	/**
	 * Column Info
	 * @return ts2
	 */
	public String getTs2() {
		return this.ts2;
	}
	
	/**
	 * Column Info
	 * @return ts1
	 */
	public String getTs1() {
		return this.ts1;
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
	 * @return porNodCd
	 */
	public String getPorNodCd() {
		return this.porNodCd;
	}
	
	/**
	 * Column Info
	 * @return polNodCd
	 */
	public String getPolNodCd() {
		return this.polNodCd;
	}
	
	/**
	 * Column Info
	 * @return delNodCd
	 */
	public String getDelNodCd() {
		return this.delNodCd;
	}
	
	/**
	 * Column Info
	 * @return porNodCd
	 */
	public String getPodNodCd() {
		return this.podNodCd;
	}
	

	/**
	 * Column Info
	 * @param porNodCd
	 */
	public void setPorNodCd(String porNodCd) {
		this.porNodCd = porNodCd;
	}
	
	/**
	 * Column Info
	 * @param polNodCd
	 */
	public void setPolNodCd(String polNodCd) {
		this.polNodCd = polNodCd;
	}
	
	/**
	 * Column Info
	 * @param podNodCd
	 */
	public void setPodNodCd(String podNodCd) {
		this.podNodCd = podNodCd;
	}
	
	/**
	 * Column Info
	 * @param delNodCd
	 */
	public void setDelNodCd(String delNodCd) {
		this.delNodCd = delNodCd;
	}
	
	/**
	 * Column Info
	 * @param orgTrnsModCd
	 */
	public void setOrgTrnsModCd(String orgTrnsModCd) {
		this.orgTrnsModCd = orgTrnsModCd;
	}
	
	/**
	 * Column Info
	 * @param destTrnsModCd
	 */
	public void setDestTrnsModCd(String destTrnsModCd) {
		this.destTrnsModCd = destTrnsModCd;
	}
	
	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	

	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	

	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
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
	 * @param ts3
	 */
	public void setTs3(String ts3) {
		this.ts3 = ts3;
	}
	
	/**
	 * Column Info
	 * @param ts2
	 */
	public void setTs2(String ts2) {
		this.ts2 = ts2;
	}
	
	/**
	 * Column Info
	 * @param ts1
	 */
	public void setTs1(String ts1) {
		this.ts1 = ts1;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setPorNodCd(JSPUtil.getParameter(request, "por_nod_cd", ""));
		setPolNodCd(JSPUtil.getParameter(request, "pol_nod_cd", ""));
		setPodNodCd(JSPUtil.getParameter(request, "pod_nod_cd", ""));
		setDelNodCd(JSPUtil.getParameter(request, "del_nod_cd", ""));
		setOrgTrnsModCd(JSPUtil.getParameter(request, "org_trns_mod_cd", ""));
		setDestTrnsModCd(JSPUtil.getParameter(request, "dest_trns_mod_cd", ""));
		setResult(JSPUtil.getParameter(request, "result", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTs3(JSPUtil.getParameter(request, "ts3", ""));
		setTs2(JSPUtil.getParameter(request, "ts2", ""));
		setTs1(JSPUtil.getParameter(request, "ts1", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgListForPortAssignVO[]
	 */
	public BkgListForPortAssignVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgListForPortAssignVO[]
	 */
	public BkgListForPortAssignVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgListForPortAssignVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] porNodCd = (JSPUtil.getParameter(request, prefix	+ "por_nod_cd", length));
			String[] polNodCd = (JSPUtil.getParameter(request, prefix	+ "pol_nod_cd", length));
			String[] podNodCd = (JSPUtil.getParameter(request, prefix	+ "pod_nod_cd", length));
			String[] delNodCd = (JSPUtil.getParameter(request, prefix	+ "del_nod_cd", length));
			String[] orgTrnsModCd = (JSPUtil.getParameter(request, prefix	+ "org_trns_mod_cd", length));
			String[] destTrnsModCd = (JSPUtil.getParameter(request, prefix	+ "dest_trns_mod_cd", length));			
			String[] result = (JSPUtil.getParameter(request, prefix	+ "result", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ts3 = (JSPUtil.getParameter(request, prefix	+ "ts3", length));
			String[] ts2 = (JSPUtil.getParameter(request, prefix	+ "ts2", length));
			String[] ts1 = (JSPUtil.getParameter(request, prefix	+ "ts1", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgListForPortAssignVO();
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (result[i] != null)
					model.setResult(result[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ts3[i] != null)
					model.setTs3(ts3[i]);
				if (ts2[i] != null)
					model.setTs2(ts2[i]);
				if (ts1[i] != null)
					model.setTs1(ts1[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (porNodCd[i] != null)
					model.setPorNodCd(porNodCd[i]);
				if (polNodCd[i] != null)
					model.setPolNodCd(polNodCd[i]);
				if (podNodCd[i] != null)
					model.setPodNodCd(podNodCd[i]);
				if (delNodCd[i] != null)
					model.setDelNodCd(delNodCd[i]);
				if (orgTrnsModCd[i] != null)
					model.setOrgTrnsModCd(orgTrnsModCd[i]);
				if (destTrnsModCd[i] != null)
					model.setDestTrnsModCd(destTrnsModCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgListForPortAssignVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgListForPortAssignVO[]
	 */
	public BkgListForPortAssignVO[] getBkgListForPortAssignVOs(){
		BkgListForPortAssignVO[] vos = (BkgListForPortAssignVO[])models.toArray(new BkgListForPortAssignVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNodCd = this.porNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNodCd = this.polNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNodCd = this.podNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNodCd = this.delNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgTrnsModCd = this.orgTrnsModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destTrnsModCd = this.destTrnsModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.result = this.result .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts3 = this.ts3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts2 = this.ts2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts1 = this.ts1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

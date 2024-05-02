/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GlovisInputVO.java
*@FileTitle : GlovisInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.14
*@LastModifier : 이석준
*@LastVersion : 1.0
* 2010.12.14 이석준 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이석준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GlovisInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GlovisInputVO> models = new ArrayList<GlovisInputVO>();
	
	/* Column Info */
	private String rtvOpt = null;
	/* Column Info */
	private String creToDt = null;
	/* Column Info */
	private String blSrcNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creFmDt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String ediSendInd = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eurGubun = null;
	/* Column Info */
	private String userOfcCd = null;
	



	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GlovisInputVO() {}

	public GlovisInputVO(String ibflag, String pagerows, String blSrcNo, String creToDt, String rtvOpt, String creFmDt, String ioBndCd, String ediSendInd, String arOfcCd, String eurGubun, String userOfcCd) {
		this.rtvOpt = rtvOpt;
		this.creToDt = creToDt;
		this.blSrcNo = blSrcNo;
		this.ibflag = ibflag;
		this.creFmDt = creFmDt;
		this.ioBndCd = ioBndCd;
		this.ediSendInd = ediSendInd;
		this.arOfcCd = arOfcCd;
		this.eurGubun = eurGubun;
		this.pagerows = pagerows;
		this.userOfcCd = userOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rtv_opt", getRtvOpt());
		this.hashColumns.put("cre_to_dt", getCreToDt());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_fm_dt", getCreFmDt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("edi_send_ind", getEdiSendInd());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("eur_gubun", getEurGubun());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rtv_opt", "rtvOpt");
		this.hashFields.put("cre_to_dt", "creToDt");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_fm_dt", "creFmDt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("edi_send_ind", "ediSendInd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("eur_gubun", "eurGubun");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		return this.hashFields;
	}
	

	/**
	 * Column Info
	 * @return rtvOpt
	 */
	public String getRtvOpt() {
		return this.rtvOpt;
	}
	
	/**
	 * Column Info
	 * @return creToDt
	 */
	public String getCreToDt() {
		return this.creToDt;
	}
	
	/**
	 * Column Info
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
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
	 * @return creFmDt
	 */
	public String getCreFmDt() {
		return this.creFmDt;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return ediSendInd
	 */
	public String getEdiSendInd() {
		return this.ediSendInd;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @return eurGubun
	 */
	public String getEurGubun() {
		return eurGubun;
	}
	
	/**
	 * Column Info
	 * @return userOfcCd
	 */
	public String getUserOfcCd() {
		return userOfcCd;
	}

	/**
	 * Column Info
	 * @param eurGubun eurGubun
	 */
	public void setEurGubun(String eurGubun) {
		this.eurGubun = eurGubun;
	}
	
	/**
	 * Column Info
	 * @param rtvOpt
	 */
	public void setRtvOpt(String rtvOpt) {
		this.rtvOpt = rtvOpt;
	}
	
	/**
	 * Column Info
	 * @param creToDt
	 */
	public void setCreToDt(String creToDt) {
		this.creToDt = creToDt;
	}
	
	/**
	 * Column Info
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
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
	 * @param creFmDt
	 */
	public void setCreFmDt(String creFmDt) {
		this.creFmDt = creFmDt;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param ediSendInd
	 */
	public void setEdiSendInd(String ediSendInd) {
		this.ediSendInd = ediSendInd;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * User Office Code
	 * @param userOfcCd
	 */
	public void setUserOfcCd(String userOfcCd) {
		this.userOfcCd = userOfcCd;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setRtvOpt(JSPUtil.getParameter(request, prefix + "rtv_opt", ""));
		setCreToDt(JSPUtil.getParameter(request, prefix + "cre_to_dt", ""));
		setBlSrcNo(JSPUtil.getParameter(request, prefix + "bl_src_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreFmDt(JSPUtil.getParameter(request, prefix + "cre_fm_dt", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setEdiSendInd(JSPUtil.getParameter(request, prefix + "edi_send_ind", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEurGubun(JSPUtil.getParameter(request, prefix + "eur_gubun", ""));
		setUserOfcCd(JSPUtil.getParameter(request, prefix + "user_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GlovisInputVO[]
	 */
	public GlovisInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GlovisInputVO[]
	 */
	public GlovisInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GlovisInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rtvOpt = (JSPUtil.getParameter(request, prefix	+ "rtv_opt", length));
			String[] creToDt = (JSPUtil.getParameter(request, prefix	+ "cre_to_dt", length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creFmDt = (JSPUtil.getParameter(request, prefix	+ "cre_fm_dt", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] ediSendInd = (JSPUtil.getParameter(request, prefix	+ "edi_send_ind", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eurGubun = (JSPUtil.getParameter(request, prefix	+ "eur_gubun", length));
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new GlovisInputVO();
				if (rtvOpt[i] != null)
					model.setRtvOpt(rtvOpt[i]);
				if (creToDt[i] != null)
					model.setCreToDt(creToDt[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creFmDt[i] != null)
					model.setCreFmDt(creFmDt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (ediSendInd[i] != null)
					model.setEdiSendInd(ediSendInd[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (eurGubun[i] != null)
					model.setEurGubun(eurGubun[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGlovisInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GlovisInputVO[]
	 */
	public GlovisInputVO[] getGlovisInputVOs(){
		GlovisInputVO[] vos = (GlovisInputVO[])models.toArray(new GlovisInputVO[models.size()]);
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
		this.rtvOpt = this.rtvOpt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creToDt = this.creToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creFmDt = this.creFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSendInd = this.ediSendInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurGubun = this.eurGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

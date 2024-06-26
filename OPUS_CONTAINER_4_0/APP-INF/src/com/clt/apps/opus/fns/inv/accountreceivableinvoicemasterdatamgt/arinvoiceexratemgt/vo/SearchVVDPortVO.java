/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchVVDPortVO.java
*@FileTitle : SearchVVDPortVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.01  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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

public class SearchVVDPortVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchVVDPortVO> models = new ArrayList<SearchVVDPortVO>();
	
	/* Column Info */
	private String etdaCd = null;
	/* Column Info */
	private String etdaDtFm = null;
	/* Column Info */
	private String xchRtRvsFlg = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String etdaDtTo = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String optType = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String invXchRt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchVVDPortVO() {}

	public SearchVVDPortVO(String ibflag, String pagerows, String etdaCd, String xchRtRvsFlg, String svcScpCd, String loclCurrCd, String skdVoyNo, String ioBndCd, String skdDirCd, String etdaDtFm, String etdaDtTo, String optType, String vpsPortCd, String ofcCd, String svrId, String vvdCd, String invXchRt) {
		this.etdaCd = etdaCd;
		this.etdaDtFm = etdaDtFm;
		this.xchRtRvsFlg = xchRtRvsFlg;
		this.svcScpCd = svcScpCd;
		this.loclCurrCd = loclCurrCd;
		this.skdVoyNo = skdVoyNo;
		this.etdaDtTo = etdaDtTo;
		this.ioBndCd = ioBndCd;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.optType = optType;
		this.svrId = svrId;
		this.ofcCd = ofcCd;
		this.vpsPortCd = vpsPortCd;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.invXchRt = invXchRt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("etda_cd", getEtdaCd());
		this.hashColumns.put("etda_dt_fm", getEtdaDtFm());
		this.hashColumns.put("xch_rt_rvs_flg", getXchRtRvsFlg());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("etda_dt_to", getEtdaDtTo());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("opt_type", getOptType());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("etda_cd", "etdaCd");
		this.hashFields.put("etda_dt_fm", "etdaDtFm");
		this.hashFields.put("xch_rt_rvs_flg", "xchRtRvsFlg");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("etda_dt_to", "etdaDtTo");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("opt_type", "optType");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return etdaCd
	 */
	public String getEtdaCd() {
		return this.etdaCd;
	}
	
	/**
	 * Column Info
	 * @return etdaDtFm
	 */
	public String getEtdaDtFm() {
		return this.etdaDtFm;
	}
	
	/**
	 * Column Info
	 * @return xchRtRvsFlg
	 */
	public String getXchRtRvsFlg() {
		return this.xchRtRvsFlg;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return etdaDtTo
	 */
	public String getEtdaDtTo() {
		return this.etdaDtTo;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return optType
	 */
	public String getOptType() {
		return this.optType;
	}
	
	/**
	 * Column Info
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
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
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
	}
	

	/**
	 * Column Info
	 * @param etdaCd
	 */
	public void setEtdaCd(String etdaCd) {
		this.etdaCd = etdaCd;
	}
	
	/**
	 * Column Info
	 * @param etdaDtFm
	 */
	public void setEtdaDtFm(String etdaDtFm) {
		this.etdaDtFm = etdaDtFm;
	}
	
	/**
	 * Column Info
	 * @param xchRtRvsFlg
	 */
	public void setXchRtRvsFlg(String xchRtRvsFlg) {
		this.xchRtRvsFlg = xchRtRvsFlg;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param etdaDtTo
	 */
	public void setEtdaDtTo(String etdaDtTo) {
		this.etdaDtTo = etdaDtTo;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param optType
	 */
	public void setOptType(String optType) {
		this.optType = optType;
	}
	
	/**
	 * Column Info
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
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
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
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
		setEtdaCd(JSPUtil.getParameter(request, prefix + "etda_cd", ""));
		setEtdaDtFm(JSPUtil.getParameter(request, prefix + "etda_dt_fm", ""));
		setXchRtRvsFlg(JSPUtil.getParameter(request, prefix + "xch_rt_rvs_flg", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setEtdaDtTo(JSPUtil.getParameter(request, prefix + "etda_dt_to", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOptType(JSPUtil.getParameter(request, prefix + "opt_type", ""));
		setSvrId(JSPUtil.getParameter(request, prefix + "svr_id", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setInvXchRt(JSPUtil.getParameter(request, prefix + "inv_xch_rt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchVVDPortVO[]
	 */
	public SearchVVDPortVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchVVDPortVO[]
	 */
	public SearchVVDPortVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchVVDPortVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] etdaCd = (JSPUtil.getParameter(request, prefix	+ "etda_cd", length));
			String[] etdaDtFm = (JSPUtil.getParameter(request, prefix	+ "etda_dt_fm", length));
			String[] xchRtRvsFlg = (JSPUtil.getParameter(request, prefix	+ "xch_rt_rvs_flg", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] etdaDtTo = (JSPUtil.getParameter(request, prefix	+ "etda_dt_to", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] optType = (JSPUtil.getParameter(request, prefix	+ "opt_type", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchVVDPortVO();
				if (etdaCd[i] != null)
					model.setEtdaCd(etdaCd[i]);
				if (etdaDtFm[i] != null)
					model.setEtdaDtFm(etdaDtFm[i]);
				if (xchRtRvsFlg[i] != null)
					model.setXchRtRvsFlg(xchRtRvsFlg[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (etdaDtTo[i] != null)
					model.setEtdaDtTo(etdaDtTo[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (optType[i] != null)
					model.setOptType(optType[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchVVDPortVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchVVDPortVO[]
	 */
	public SearchVVDPortVO[] getSearchVVDPortVOs(){
		SearchVVDPortVO[] vos = (SearchVVDPortVO[])models.toArray(new SearchVVDPortVO[models.size()]);
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
		this.etdaCd = this.etdaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdaDtFm = this.etdaDtFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtRvsFlg = this.xchRtRvsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdaDtTo = this.etdaDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optType = this.optType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

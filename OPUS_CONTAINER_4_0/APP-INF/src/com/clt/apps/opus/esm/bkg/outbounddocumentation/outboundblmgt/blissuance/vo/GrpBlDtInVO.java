/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GrpBlDtInVO.java
*@FileTitle : GrpBlDtInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.12.15 김영출 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

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
 * @author 김영출
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GrpBlDtInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GrpBlDtInVO> models = new ArrayList<GrpBlDtInVO>();
	
	/* Column Info */
	private String obSrepCd = null;
	/* Column Info */
	private String oblRlseFlg = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String actDepDt = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oblIssFlg = null;
	/* Column Info */
	private String shipperCd = null;
	/* Column Info */
	private String chkdIss = null;
	/* Column Info */
	private String actArrDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GrpBlDtInVO() {}

	public GrpBlDtInVO(String ibflag, String pagerows, String vvd, String polCd, String bkgOfcCd, String oblIssFlg, String oblRlseFlg, String shipperCd, String obSrepCd, String actArrDt, String actDepDt, String chkdIss) {
		this.obSrepCd = obSrepCd;
		this.oblRlseFlg = oblRlseFlg;
		this.bkgOfcCd = bkgOfcCd;
		this.vvd = vvd;
		this.actDepDt = actDepDt;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.oblIssFlg = oblIssFlg;
		this.shipperCd = shipperCd;
		this.chkdIss = chkdIss;
		this.actArrDt = actArrDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ob_srep_cd", getObSrepCd());
		this.hashColumns.put("obl_rlse_flg", getOblRlseFlg());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("act_dep_dt", getActDepDt());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("obl_iss_flg", getOblIssFlg());
		this.hashColumns.put("shipper_cd", getShipperCd());
		this.hashColumns.put("chkd_iss", getChkdIss());
		this.hashColumns.put("act_arr_dt", getActArrDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ob_srep_cd", "obSrepCd");
		this.hashFields.put("obl_rlse_flg", "oblRlseFlg");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("act_dep_dt", "actDepDt");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("obl_iss_flg", "oblIssFlg");
		this.hashFields.put("shipper_cd", "shipperCd");
		this.hashFields.put("chkd_iss", "chkdIss");
		this.hashFields.put("act_arr_dt", "actArrDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return obSrepCd
	 */
	public String getObSrepCd() {
		return this.obSrepCd;
	}
	
	/**
	 * Column Info
	 * @return oblRlseFlg
	 */
	public String getOblRlseFlg() {
		return this.oblRlseFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return actDepDt
	 */
	public String getActDepDt() {
		return this.actDepDt;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return oblIssFlg
	 */
	public String getOblIssFlg() {
		return this.oblIssFlg;
	}
	
	/**
	 * Column Info
	 * @return shipperCd
	 */
	public String getShipperCd() {
		return this.shipperCd;
	}
	
	/**
	 * Column Info
	 * @return chkdIss
	 */
	public String getChkdIss() {
		return this.chkdIss;
	}
	
	/**
	 * Column Info
	 * @return actArrDt
	 */
	public String getActArrDt() {
		return this.actArrDt;
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
	 * @param obSrepCd
	 */
	public void setObSrepCd(String obSrepCd) {
		this.obSrepCd = obSrepCd;
	}
	
	/**
	 * Column Info
	 * @param oblRlseFlg
	 */
	public void setOblRlseFlg(String oblRlseFlg) {
		this.oblRlseFlg = oblRlseFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param actDepDt
	 */
	public void setActDepDt(String actDepDt) {
		this.actDepDt = actDepDt;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param oblIssFlg
	 */
	public void setOblIssFlg(String oblIssFlg) {
		this.oblIssFlg = oblIssFlg;
	}
	
	/**
	 * Column Info
	 * @param shipperCd
	 */
	public void setShipperCd(String shipperCd) {
		this.shipperCd = shipperCd;
	}
	
	/**
	 * Column Info
	 * @param chkdIss
	 */
	public void setChkdIss(String chkdIss) {
		this.chkdIss = chkdIss;
	}
	
	/**
	 * Column Info
	 * @param actArrDt
	 */
	public void setActArrDt(String actArrDt) {
		this.actArrDt = actArrDt;
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
		setObSrepCd(JSPUtil.getParameter(request, "ob_srep_cd", ""));
		setOblRlseFlg(JSPUtil.getParameter(request, "obl_rlse_flg", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, "bkg_ofc_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setActDepDt(JSPUtil.getParameter(request, "act_dep_dt", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOblIssFlg(JSPUtil.getParameter(request, "obl_iss_flg", ""));
		setShipperCd(JSPUtil.getParameter(request, "shipper_cd", ""));
		setChkdIss(JSPUtil.getParameter(request, "chkd_iss", ""));
		setActArrDt(JSPUtil.getParameter(request, "act_arr_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GrpBlDtInVO[]
	 */
	public GrpBlDtInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GrpBlDtInVO[]
	 */
	public GrpBlDtInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GrpBlDtInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] obSrepCd = (JSPUtil.getParameter(request, prefix	+ "ob_srep_cd", length));
			String[] oblRlseFlg = (JSPUtil.getParameter(request, prefix	+ "obl_rlse_flg", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] actDepDt = (JSPUtil.getParameter(request, prefix	+ "act_dep_dt", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oblIssFlg = (JSPUtil.getParameter(request, prefix	+ "obl_iss_flg", length));
			String[] shipperCd = (JSPUtil.getParameter(request, prefix	+ "shipper_cd", length));
			String[] chkdIss = (JSPUtil.getParameter(request, prefix	+ "chkd_iss", length));
			String[] actArrDt = (JSPUtil.getParameter(request, prefix	+ "act_arr_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new GrpBlDtInVO();
				if (obSrepCd[i] != null)
					model.setObSrepCd(obSrepCd[i]);
				if (oblRlseFlg[i] != null)
					model.setOblRlseFlg(oblRlseFlg[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (actDepDt[i] != null)
					model.setActDepDt(actDepDt[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oblIssFlg[i] != null)
					model.setOblIssFlg(oblIssFlg[i]);
				if (shipperCd[i] != null)
					model.setShipperCd(shipperCd[i]);
				if (chkdIss[i] != null)
					model.setChkdIss(chkdIss[i]);
				if (actArrDt[i] != null)
					model.setActArrDt(actArrDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGrpBlDtInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GrpBlDtInVO[]
	 */
	public GrpBlDtInVO[] getGrpBlDtInVOs(){
		GrpBlDtInVO[] vos = (GrpBlDtInVO[])models.toArray(new GrpBlDtInVO[models.size()]);
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
		this.obSrepCd = this.obSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRlseFlg = this.oblRlseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDepDt = this.actDepDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssFlg = this.oblIssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperCd = this.shipperCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkdIss = this.chkdIss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actArrDt = this.actArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

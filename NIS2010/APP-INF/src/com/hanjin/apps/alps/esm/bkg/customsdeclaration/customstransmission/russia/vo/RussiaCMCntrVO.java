/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RussiaCMCntrVO.java
*@FileTitle : RussiaCMCntrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.14  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RussiaCMCntrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RussiaCMCntrVO> models = new ArrayList<RussiaCMCntrVO>();
	
	/* Column Info */
	private String tempUn = null;
	/* Column Info */
	private String doTemp = null;
	/* Column Info */
	private String cntrMfMkDesc5 = null;
	/* Column Info */
	private String cntrMfWgt = null;
	/* Column Info */
	private String cntrMfMkDesc = null;
	/* Column Info */
	private String cntrMfMkDesc2 = null;
	/* Column Info */
	private String cntrMfMkDesc1 = null;
	/* Column Info */
	private String cntrMfMkDesc4 = null;
	/* Column Info */
	private String cntrMfSeq = null;
	/* Column Info */
	private String goodno = null;
	/* Column Info */
	private String cntrMfMkDesc3 = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String cntrMfGdsDesc = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String pckTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RussiaCMCntrVO() {}

	public RussiaCMCntrVO(String ibflag, String pagerows, String tempUn, String doTemp, String cntrMfMkDesc5, String cntrMfWgt, String cntrMfMkDesc, String cntrMfMkDesc2, String cntrMfMkDesc1, String cntrMfMkDesc4, String cntrMfSeq, String goodno, String cntrMfMkDesc3, String measQty, String pckQty, String cntrMfGdsDesc, String pckTpCd, String rcFlg) {
		this.tempUn = tempUn;
		this.doTemp = doTemp;
		this.cntrMfMkDesc5 = cntrMfMkDesc5;
		this.cntrMfWgt = cntrMfWgt;
		this.cntrMfMkDesc = cntrMfMkDesc;
		this.cntrMfMkDesc2 = cntrMfMkDesc2;
		this.cntrMfMkDesc1 = cntrMfMkDesc1;
		this.cntrMfMkDesc4 = cntrMfMkDesc4;
		this.cntrMfSeq = cntrMfSeq;
		this.goodno = goodno;
		this.cntrMfMkDesc3 = cntrMfMkDesc3;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.cntrMfGdsDesc = cntrMfGdsDesc;
		this.rcFlg = rcFlg;
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("temp_un", getTempUn());
		this.hashColumns.put("do_temp", getDoTemp());
		this.hashColumns.put("cntr_mf_mk_desc5", getCntrMfMkDesc5());
		this.hashColumns.put("cntr_mf_wgt", getCntrMfWgt());
		this.hashColumns.put("cntr_mf_mk_desc", getCntrMfMkDesc());
		this.hashColumns.put("cntr_mf_mk_desc2", getCntrMfMkDesc2());
		this.hashColumns.put("cntr_mf_mk_desc1", getCntrMfMkDesc1());
		this.hashColumns.put("cntr_mf_mk_desc4", getCntrMfMkDesc4());
		this.hashColumns.put("cntr_mf_seq", getCntrMfSeq());
		this.hashColumns.put("goodno", getGoodno());
		this.hashColumns.put("cntr_mf_mk_desc3", getCntrMfMkDesc3());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("cntr_mf_gds_desc", getCntrMfGdsDesc());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("temp_un", "tempUn");
		this.hashFields.put("do_temp", "doTemp");
		this.hashFields.put("cntr_mf_mk_desc5", "cntrMfMkDesc5");
		this.hashFields.put("cntr_mf_wgt", "cntrMfWgt");
		this.hashFields.put("cntr_mf_mk_desc", "cntrMfMkDesc");
		this.hashFields.put("cntr_mf_mk_desc2", "cntrMfMkDesc2");
		this.hashFields.put("cntr_mf_mk_desc1", "cntrMfMkDesc1");
		this.hashFields.put("cntr_mf_mk_desc4", "cntrMfMkDesc4");
		this.hashFields.put("cntr_mf_seq", "cntrMfSeq");
		this.hashFields.put("goodno", "goodno");
		this.hashFields.put("cntr_mf_mk_desc3", "cntrMfMkDesc3");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("cntr_mf_gds_desc", "cntrMfGdsDesc");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tempUn
	 */
	public String getTempUn() {
		return this.tempUn;
	}
	
	/**
	 * Column Info
	 * @return doTemp
	 */
	public String getDoTemp() {
		return this.doTemp;
	}
	
	/**
	 * Column Info
	 * @return cntrMfMkDesc5
	 */
	public String getCntrMfMkDesc5() {
		return this.cntrMfMkDesc5;
	}
	
	/**
	 * Column Info
	 * @return cntrMfWgt
	 */
	public String getCntrMfWgt() {
		return this.cntrMfWgt;
	}
	
	/**
	 * Column Info
	 * @return cntrMfMkDesc
	 */
	public String getCntrMfMkDesc() {
		return this.cntrMfMkDesc;
	}
	
	/**
	 * Column Info
	 * @return cntrMfMkDesc2
	 */
	public String getCntrMfMkDesc2() {
		return this.cntrMfMkDesc2;
	}
	
	/**
	 * Column Info
	 * @return cntrMfMkDesc1
	 */
	public String getCntrMfMkDesc1() {
		return this.cntrMfMkDesc1;
	}
	
	/**
	 * Column Info
	 * @return cntrMfMkDesc4
	 */
	public String getCntrMfMkDesc4() {
		return this.cntrMfMkDesc4;
	}
	
	/**
	 * Column Info
	 * @return cntrMfSeq
	 */
	public String getCntrMfSeq() {
		return this.cntrMfSeq;
	}
	
	/**
	 * Column Info
	 * @return goodno
	 */
	public String getGoodno() {
		return this.goodno;
	}
	
	/**
	 * Column Info
	 * @return cntrMfMkDesc3
	 */
	public String getCntrMfMkDesc3() {
		return this.cntrMfMkDesc3;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return cntrMfGdsDesc
	 */
	public String getCntrMfGdsDesc() {
		return this.cntrMfGdsDesc;
	}
	
	/**
	 * Column Info
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	

	/**
	 * Column Info
	 * @param tempUn
	 */
	public void setTempUn(String tempUn) {
		this.tempUn = tempUn;
	}
	
	/**
	 * Column Info
	 * @param doTemp
	 */
	public void setDoTemp(String doTemp) {
		this.doTemp = doTemp;
	}
	
	/**
	 * Column Info
	 * @param cntrMfMkDesc5
	 */
	public void setCntrMfMkDesc5(String cntrMfMkDesc5) {
		this.cntrMfMkDesc5 = cntrMfMkDesc5;
	}
	
	/**
	 * Column Info
	 * @param cntrMfWgt
	 */
	public void setCntrMfWgt(String cntrMfWgt) {
		this.cntrMfWgt = cntrMfWgt;
	}
	
	/**
	 * Column Info
	 * @param cntrMfMkDesc
	 */
	public void setCntrMfMkDesc(String cntrMfMkDesc) {
		this.cntrMfMkDesc = cntrMfMkDesc;
	}
	
	/**
	 * Column Info
	 * @param cntrMfMkDesc2
	 */
	public void setCntrMfMkDesc2(String cntrMfMkDesc2) {
		this.cntrMfMkDesc2 = cntrMfMkDesc2;
	}
	
	/**
	 * Column Info
	 * @param cntrMfMkDesc1
	 */
	public void setCntrMfMkDesc1(String cntrMfMkDesc1) {
		this.cntrMfMkDesc1 = cntrMfMkDesc1;
	}
	
	/**
	 * Column Info
	 * @param cntrMfMkDesc4
	 */
	public void setCntrMfMkDesc4(String cntrMfMkDesc4) {
		this.cntrMfMkDesc4 = cntrMfMkDesc4;
	}
	
	/**
	 * Column Info
	 * @param cntrMfSeq
	 */
	public void setCntrMfSeq(String cntrMfSeq) {
		this.cntrMfSeq = cntrMfSeq;
	}
	
	/**
	 * Column Info
	 * @param goodno
	 */
	public void setGoodno(String goodno) {
		this.goodno = goodno;
	}
	
	/**
	 * Column Info
	 * @param cntrMfMkDesc3
	 */
	public void setCntrMfMkDesc3(String cntrMfMkDesc3) {
		this.cntrMfMkDesc3 = cntrMfMkDesc3;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param cntrMfGdsDesc
	 */
	public void setCntrMfGdsDesc(String cntrMfGdsDesc) {
		this.cntrMfGdsDesc = cntrMfGdsDesc;
	}
	
	/**
	 * Column Info
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
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
		setTempUn(JSPUtil.getParameter(request, prefix + "temp_un", ""));
		setDoTemp(JSPUtil.getParameter(request, prefix + "do_temp", ""));
		setCntrMfMkDesc5(JSPUtil.getParameter(request, prefix + "cntr_mf_mk_desc5", ""));
		setCntrMfWgt(JSPUtil.getParameter(request, prefix + "cntr_mf_wgt", ""));
		setCntrMfMkDesc(JSPUtil.getParameter(request, prefix + "cntr_mf_mk_desc", ""));
		setCntrMfMkDesc2(JSPUtil.getParameter(request, prefix + "cntr_mf_mk_desc2", ""));
		setCntrMfMkDesc1(JSPUtil.getParameter(request, prefix + "cntr_mf_mk_desc1", ""));
		setCntrMfMkDesc4(JSPUtil.getParameter(request, prefix + "cntr_mf_mk_desc4", ""));
		setCntrMfSeq(JSPUtil.getParameter(request, prefix + "cntr_mf_seq", ""));
		setGoodno(JSPUtil.getParameter(request, prefix + "goodno", ""));
		setCntrMfMkDesc3(JSPUtil.getParameter(request, prefix + "cntr_mf_mk_desc3", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setCntrMfGdsDesc(JSPUtil.getParameter(request, prefix + "cntr_mf_gds_desc", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RussiaCMCntrVO[]
	 */
	public RussiaCMCntrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RussiaCMCntrVO[]
	 */
	public RussiaCMCntrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RussiaCMCntrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tempUn = (JSPUtil.getParameter(request, prefix	+ "temp_un", length));
			String[] doTemp = (JSPUtil.getParameter(request, prefix	+ "do_temp", length));
			String[] cntrMfMkDesc5 = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_mk_desc5", length));
			String[] cntrMfWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_wgt", length));
			String[] cntrMfMkDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_mk_desc", length));
			String[] cntrMfMkDesc2 = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_mk_desc2", length));
			String[] cntrMfMkDesc1 = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_mk_desc1", length));
			String[] cntrMfMkDesc4 = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_mk_desc4", length));
			String[] cntrMfSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_seq", length));
			String[] goodno = (JSPUtil.getParameter(request, prefix	+ "goodno", length));
			String[] cntrMfMkDesc3 = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_mk_desc3", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] cntrMfGdsDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_gds_desc", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RussiaCMCntrVO();
				if (tempUn[i] != null)
					model.setTempUn(tempUn[i]);
				if (doTemp[i] != null)
					model.setDoTemp(doTemp[i]);
				if (cntrMfMkDesc5[i] != null)
					model.setCntrMfMkDesc5(cntrMfMkDesc5[i]);
				if (cntrMfWgt[i] != null)
					model.setCntrMfWgt(cntrMfWgt[i]);
				if (cntrMfMkDesc[i] != null)
					model.setCntrMfMkDesc(cntrMfMkDesc[i]);
				if (cntrMfMkDesc2[i] != null)
					model.setCntrMfMkDesc2(cntrMfMkDesc2[i]);
				if (cntrMfMkDesc1[i] != null)
					model.setCntrMfMkDesc1(cntrMfMkDesc1[i]);
				if (cntrMfMkDesc4[i] != null)
					model.setCntrMfMkDesc4(cntrMfMkDesc4[i]);
				if (cntrMfSeq[i] != null)
					model.setCntrMfSeq(cntrMfSeq[i]);
				if (goodno[i] != null)
					model.setGoodno(goodno[i]);
				if (cntrMfMkDesc3[i] != null)
					model.setCntrMfMkDesc3(cntrMfMkDesc3[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (cntrMfGdsDesc[i] != null)
					model.setCntrMfGdsDesc(cntrMfGdsDesc[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRussiaCMCntrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RussiaCMCntrVO[]
	 */
	public RussiaCMCntrVO[] getRussiaCMCntrVOs(){
		RussiaCMCntrVO[] vos = (RussiaCMCntrVO[])models.toArray(new RussiaCMCntrVO[models.size()]);
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
		this.tempUn = this.tempUn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doTemp = this.doTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfMkDesc5 = this.cntrMfMkDesc5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfWgt = this.cntrMfWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfMkDesc = this.cntrMfMkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfMkDesc2 = this.cntrMfMkDesc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfMkDesc1 = this.cntrMfMkDesc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfMkDesc4 = this.cntrMfMkDesc4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfSeq = this.cntrMfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.goodno = this.goodno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfMkDesc3 = this.cntrMfMkDesc3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfGdsDesc = this.cntrMfGdsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

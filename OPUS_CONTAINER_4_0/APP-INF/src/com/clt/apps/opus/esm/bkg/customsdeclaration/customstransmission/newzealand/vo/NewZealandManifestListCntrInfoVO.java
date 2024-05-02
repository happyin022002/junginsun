/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NewZealandManifestListCntrInfoVO.java
*@FileTitle : NewZealandManifestListCntrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.18  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo;

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

public class NewZealandManifestListCntrInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<NewZealandManifestListCntrInfoVO> models = new ArrayList<NewZealandManifestListCntrInfoVO>();
	
	/* Column Info */
	private String cgoTmpUnit = null;
	/* Column Info */
	private String cntrsize = null;
	/* Column Info */
	private String cntrnbr = null;
	/* Column Info */
	private String cntrGWgt = null;
	/* Column Info */
	private String cntrTmp = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrtype = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String cntrTWgtUnit = null;
	/* Column Info */
	private String cntrGWgtUnit = null;
	/* Column Info */
	private String cntrTWgt = null;
	/* Column Info */
	private String cntrFmInd = null;
	/* Column Info */
	private String measUtCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public NewZealandManifestListCntrInfoVO() {}

	public NewZealandManifestListCntrInfoVO(String ibflag, String pagerows, String cntrnbr, String cntrsize, String cntrtype, String cntrFmInd, String cntrGWgt, String cntrGWgtUnit, String measQty, String measUtCd, String cntrTWgt, String cntrTWgtUnit, String cntrTmp, String cgoTmpUnit) {
		this.cgoTmpUnit = cgoTmpUnit;
		this.cntrsize = cntrsize;
		this.cntrnbr = cntrnbr;
		this.cntrGWgt = cntrGWgt;
		this.cntrTmp = cntrTmp;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cntrtype = cntrtype;
		this.measQty = measQty;
		this.cntrTWgtUnit = cntrTWgtUnit;
		this.cntrGWgtUnit = cntrGWgtUnit;
		this.cntrTWgt = cntrTWgt;
		this.cntrFmInd = cntrFmInd;
		this.measUtCd = measUtCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cgo_tmp_unit", getCgoTmpUnit());
		this.hashColumns.put("cntrsize", getCntrsize());
		this.hashColumns.put("cntrnbr", getCntrnbr());
		this.hashColumns.put("cntr_g_wgt", getCntrGWgt());
		this.hashColumns.put("cntr_tmp", getCntrTmp());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntrtype", getCntrtype());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("cntr_t_wgt_unit", getCntrTWgtUnit());
		this.hashColumns.put("cntr_g_wgt_unit", getCntrGWgtUnit());
		this.hashColumns.put("cntr_t_wgt", getCntrTWgt());
		this.hashColumns.put("cntr_fm_ind", getCntrFmInd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cgo_tmp_unit", "cgoTmpUnit");
		this.hashFields.put("cntrsize", "cntrsize");
		this.hashFields.put("cntrnbr", "cntrnbr");
		this.hashFields.put("cntr_g_wgt", "cntrGWgt");
		this.hashFields.put("cntr_tmp", "cntrTmp");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntrtype", "cntrtype");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("cntr_t_wgt_unit", "cntrTWgtUnit");
		this.hashFields.put("cntr_g_wgt_unit", "cntrGWgtUnit");
		this.hashFields.put("cntr_t_wgt", "cntrTWgt");
		this.hashFields.put("cntr_fm_ind", "cntrFmInd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cgoTmpUnit
	 */
	public String getCgoTmpUnit() {
		return this.cgoTmpUnit;
	}
	
	/**
	 * Column Info
	 * @return cntrsize
	 */
	public String getCntrsize() {
		return this.cntrsize;
	}
	
	/**
	 * Column Info
	 * @return cntrnbr
	 */
	public String getCntrnbr() {
		return this.cntrnbr;
	}
	
	/**
	 * Column Info
	 * @return cntrGWgt
	 */
	public String getCntrGWgt() {
		return this.cntrGWgt;
	}
	
	/**
	 * Column Info
	 * @return cntrTmp
	 */
	public String getCntrTmp() {
		return this.cntrTmp;
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
	 * @return cntrtype
	 */
	public String getCntrtype() {
		return this.cntrtype;
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
	 * @return cntrTWgtUnit
	 */
	public String getCntrTWgtUnit() {
		return this.cntrTWgtUnit;
	}
	
	/**
	 * Column Info
	 * @return cntrGWgtUnit
	 */
	public String getCntrGWgtUnit() {
		return this.cntrGWgtUnit;
	}
	
	/**
	 * Column Info
	 * @return cntrTWgt
	 */
	public String getCntrTWgt() {
		return this.cntrTWgt;
	}
	
	/**
	 * Column Info
	 * @return cntrFmInd
	 */
	public String getCntrFmInd() {
		return this.cntrFmInd;
	}
	
	/**
	 * Column Info
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
	}
	

	/**
	 * Column Info
	 * @param cgoTmpUnit
	 */
	public void setCgoTmpUnit(String cgoTmpUnit) {
		this.cgoTmpUnit = cgoTmpUnit;
	}
	
	/**
	 * Column Info
	 * @param cntrsize
	 */
	public void setCntrsize(String cntrsize) {
		this.cntrsize = cntrsize;
	}
	
	/**
	 * Column Info
	 * @param cntrnbr
	 */
	public void setCntrnbr(String cntrnbr) {
		this.cntrnbr = cntrnbr;
	}
	
	/**
	 * Column Info
	 * @param cntrGWgt
	 */
	public void setCntrGWgt(String cntrGWgt) {
		this.cntrGWgt = cntrGWgt;
	}
	
	/**
	 * Column Info
	 * @param cntrTmp
	 */
	public void setCntrTmp(String cntrTmp) {
		this.cntrTmp = cntrTmp;
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
	 * @param cntrtype
	 */
	public void setCntrtype(String cntrtype) {
		this.cntrtype = cntrtype;
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
	 * @param cntrTWgtUnit
	 */
	public void setCntrTWgtUnit(String cntrTWgtUnit) {
		this.cntrTWgtUnit = cntrTWgtUnit;
	}
	
	/**
	 * Column Info
	 * @param cntrGWgtUnit
	 */
	public void setCntrGWgtUnit(String cntrGWgtUnit) {
		this.cntrGWgtUnit = cntrGWgtUnit;
	}
	
	/**
	 * Column Info
	 * @param cntrTWgt
	 */
	public void setCntrTWgt(String cntrTWgt) {
		this.cntrTWgt = cntrTWgt;
	}
	
	/**
	 * Column Info
	 * @param cntrFmInd
	 */
	public void setCntrFmInd(String cntrFmInd) {
		this.cntrFmInd = cntrFmInd;
	}
	
	/**
	 * Column Info
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
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
		setCgoTmpUnit(JSPUtil.getParameter(request, prefix + "cgo_tmp_unit", ""));
		setCntrsize(JSPUtil.getParameter(request, prefix + "cntrsize", ""));
		setCntrnbr(JSPUtil.getParameter(request, prefix + "cntrnbr", ""));
		setCntrGWgt(JSPUtil.getParameter(request, prefix + "cntr_g_wgt", ""));
		setCntrTmp(JSPUtil.getParameter(request, prefix + "cntr_tmp", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrtype(JSPUtil.getParameter(request, prefix + "cntrtype", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setCntrTWgtUnit(JSPUtil.getParameter(request, prefix + "cntr_t_wgt_unit", ""));
		setCntrGWgtUnit(JSPUtil.getParameter(request, prefix + "cntr_g_wgt_unit", ""));
		setCntrTWgt(JSPUtil.getParameter(request, prefix + "cntr_t_wgt", ""));
		setCntrFmInd(JSPUtil.getParameter(request, prefix + "cntr_fm_ind", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return NewZealandManifestListCntrInfoVO[]
	 */
	public NewZealandManifestListCntrInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return NewZealandManifestListCntrInfoVO[]
	 */
	public NewZealandManifestListCntrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		NewZealandManifestListCntrInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cgoTmpUnit = (JSPUtil.getParameter(request, prefix	+ "cgo_tmp_unit", length));
			String[] cntrsize = (JSPUtil.getParameter(request, prefix	+ "cntrsize", length));
			String[] cntrnbr = (JSPUtil.getParameter(request, prefix	+ "cntrnbr", length));
			String[] cntrGWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_g_wgt", length));
			String[] cntrTmp = (JSPUtil.getParameter(request, prefix	+ "cntr_tmp", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrtype = (JSPUtil.getParameter(request, prefix	+ "cntrtype", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] cntrTWgtUnit = (JSPUtil.getParameter(request, prefix	+ "cntr_t_wgt_unit", length));
			String[] cntrGWgtUnit = (JSPUtil.getParameter(request, prefix	+ "cntr_g_wgt_unit", length));
			String[] cntrTWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_t_wgt", length));
			String[] cntrFmInd = (JSPUtil.getParameter(request, prefix	+ "cntr_fm_ind", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new NewZealandManifestListCntrInfoVO();
				if (cgoTmpUnit[i] != null)
					model.setCgoTmpUnit(cgoTmpUnit[i]);
				if (cntrsize[i] != null)
					model.setCntrsize(cntrsize[i]);
				if (cntrnbr[i] != null)
					model.setCntrnbr(cntrnbr[i]);
				if (cntrGWgt[i] != null)
					model.setCntrGWgt(cntrGWgt[i]);
				if (cntrTmp[i] != null)
					model.setCntrTmp(cntrTmp[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrtype[i] != null)
					model.setCntrtype(cntrtype[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (cntrTWgtUnit[i] != null)
					model.setCntrTWgtUnit(cntrTWgtUnit[i]);
				if (cntrGWgtUnit[i] != null)
					model.setCntrGWgtUnit(cntrGWgtUnit[i]);
				if (cntrTWgt[i] != null)
					model.setCntrTWgt(cntrTWgt[i]);
				if (cntrFmInd[i] != null)
					model.setCntrFmInd(cntrFmInd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getNewZealandManifestListCntrInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return NewZealandManifestListCntrInfoVO[]
	 */
	public NewZealandManifestListCntrInfoVO[] getNewZealandManifestListCntrInfoVOs(){
		NewZealandManifestListCntrInfoVO[] vos = (NewZealandManifestListCntrInfoVO[])models.toArray(new NewZealandManifestListCntrInfoVO[models.size()]);
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
		this.cgoTmpUnit = this.cgoTmpUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrsize = this.cntrsize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrnbr = this.cntrnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrGWgt = this.cntrGWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTmp = this.cntrTmp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtype = this.cntrtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTWgtUnit = this.cntrTWgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrGWgtUnit = this.cntrGWgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTWgt = this.cntrTWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFmInd = this.cntrFmInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

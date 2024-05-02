/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COPDetailVO.java
*@FileTitle : COPDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2009.09.16 오현경 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.copmanage.copsearch.vo;

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
 * @author 오현경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class COPDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<COPDetailVO> models = new ArrayList<COPDetailVO>();
	
	/* Column Info */
	private String actCd = null;
	/* Column Info */
	private String strBlNo = null;
	/* Column Info */
	private String cntrNoV = null;
	/* Column Info */
	private String aniDt = null;
	/* Column Info */
	private String caiDt = null;
	/* Column Info */
	private String clickBtnNm = null;
	/* Column Info */
	private String copSts = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String fCmd = null;
	/* Column Info */
	private String copMstBkg = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String dblDt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String nivDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public COPDetailVO() {}

	public COPDetailVO(String ibflag, String pagerows, String cntrNoV, String cntrNo, String copNo, String copSts, String copMstBkg, String bkgNo, String fCmd, String clickBtnNm, String actCd, String dblDt, String aniDt, String nivDt, String caiDt, String strBlNo) {
		this.actCd = actCd;
		this.strBlNo = strBlNo;
		this.cntrNoV = cntrNoV;
		this.aniDt = aniDt;
		this.caiDt = caiDt;
		this.clickBtnNm = clickBtnNm;
		this.copSts = copSts;
		this.copNo = copNo;
		this.fCmd = fCmd;
		this.copMstBkg = copMstBkg;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.dblDt = dblDt;
		this.cntrNo = cntrNo;
		this.nivDt = nivDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("act_cd", getActCd());
		this.hashColumns.put("str_bl_no", getStrBlNo());
		this.hashColumns.put("cntr_no_v", getCntrNoV());
		this.hashColumns.put("ani_dt", getAniDt());
		this.hashColumns.put("cai_dt", getCaiDt());
		this.hashColumns.put("click_btn_nm", getClickBtnNm());
		this.hashColumns.put("cop_sts", getCopSts());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("f_cmd", getFCmd());
		this.hashColumns.put("cop_mst_bkg", getCopMstBkg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("dbl_dt", getDblDt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("niv_dt", getNivDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("act_cd", "actCd");
		this.hashFields.put("str_bl_no", "strBlNo");
		this.hashFields.put("cntr_no_v", "cntrNoV");
		this.hashFields.put("ani_dt", "aniDt");
		this.hashFields.put("cai_dt", "caiDt");
		this.hashFields.put("click_btn_nm", "clickBtnNm");
		this.hashFields.put("cop_sts", "copSts");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("f_cmd", "fCmd");
		this.hashFields.put("cop_mst_bkg", "copMstBkg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("dbl_dt", "dblDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("niv_dt", "nivDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return actCd
	 */
	public String getActCd() {
		return this.actCd;
	}
	
	/**
	 * Column Info
	 * @return strBlNo
	 */
	public String getStrBlNo() {
		return this.strBlNo;
	}
	
	/**
	 * Column Info
	 * @return cntrNoV
	 */
	public String getCntrNoV() {
		return this.cntrNoV;
	}
	
	/**
	 * Column Info
	 * @return aniDt
	 */
	public String getAniDt() {
		return this.aniDt;
	}
	
	/**
	 * Column Info
	 * @return caiDt
	 */
	public String getCaiDt() {
		return this.caiDt;
	}
	
	/**
	 * Column Info
	 * @return clickBtnNm
	 */
	public String getClickBtnNm() {
		return this.clickBtnNm;
	}
	
	/**
	 * Column Info
	 * @return copSts
	 */
	public String getCopSts() {
		return this.copSts;
	}
	
	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return fCmd
	 */
	public String getFCmd() {
		return this.fCmd;
	}
	
	/**
	 * Column Info
	 * @return copMstBkg
	 */
	public String getCopMstBkg() {
		return this.copMstBkg;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return dblDt
	 */
	public String getDblDt() {
		return this.dblDt;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return nivDt
	 */
	public String getNivDt() {
		return this.nivDt;
	}
	

	/**
	 * Column Info
	 * @param actCd
	 */
	public void setActCd(String actCd) {
		this.actCd = actCd;
	}
	
	/**
	 * Column Info
	 * @param strBlNo
	 */
	public void setStrBlNo(String strBlNo) {
		this.strBlNo = strBlNo;
	}
	
	/**
	 * Column Info
	 * @param cntrNoV
	 */
	public void setCntrNoV(String cntrNoV) {
		this.cntrNoV = cntrNoV;
	}
	
	/**
	 * Column Info
	 * @param aniDt
	 */
	public void setAniDt(String aniDt) {
		this.aniDt = aniDt;
	}
	
	/**
	 * Column Info
	 * @param caiDt
	 */
	public void setCaiDt(String caiDt) {
		this.caiDt = caiDt;
	}
	
	/**
	 * Column Info
	 * @param clickBtnNm
	 */
	public void setClickBtnNm(String clickBtnNm) {
		this.clickBtnNm = clickBtnNm;
	}
	
	/**
	 * Column Info
	 * @param copSts
	 */
	public void setCopSts(String copSts) {
		this.copSts = copSts;
	}
	
	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param fCmd
	 */
	public void setFCmd(String fCmd) {
		this.fCmd = fCmd;
	}
	
	/**
	 * Column Info
	 * @param copMstBkg
	 */
	public void setCopMstBkg(String copMstBkg) {
		this.copMstBkg = copMstBkg;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param dblDt
	 */
	public void setDblDt(String dblDt) {
		this.dblDt = dblDt;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param nivDt
	 */
	public void setNivDt(String nivDt) {
		this.nivDt = nivDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setActCd(JSPUtil.getParameter(request, "act_cd", ""));
		setStrBlNo(JSPUtil.getParameter(request, "str_bl_no", ""));
		setCntrNoV(JSPUtil.getParameter(request, "cntr_no_v", ""));
		setAniDt(JSPUtil.getParameter(request, "ani_dt", ""));
		setCaiDt(JSPUtil.getParameter(request, "cai_dt", ""));
		setClickBtnNm(JSPUtil.getParameter(request, "click_btn_nm", ""));
		setCopSts(JSPUtil.getParameter(request, "cop_sts", ""));
		setCopNo(JSPUtil.getParameter(request, "cop_no", ""));
		setFCmd(JSPUtil.getParameter(request, "f_cmd", ""));
		setCopMstBkg(JSPUtil.getParameter(request, "cop_mst_bkg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setDblDt(JSPUtil.getParameter(request, "dbl_dt", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setNivDt(JSPUtil.getParameter(request, "niv_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return COPDetailVO[]
	 */
	public COPDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return COPDetailVO[]
	 */
	public COPDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		COPDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] actCd = (JSPUtil.getParameter(request, prefix	+ "act_cd", length));
			String[] strBlNo = (JSPUtil.getParameter(request, prefix	+ "str_bl_no", length));
			String[] cntrNoV = (JSPUtil.getParameter(request, prefix	+ "cntr_no_v", length));
			String[] aniDt = (JSPUtil.getParameter(request, prefix	+ "ani_dt", length));
			String[] caiDt = (JSPUtil.getParameter(request, prefix	+ "cai_dt", length));
			String[] clickBtnNm = (JSPUtil.getParameter(request, prefix	+ "click_btn_nm", length));
			String[] copSts = (JSPUtil.getParameter(request, prefix	+ "cop_sts", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] fCmd = (JSPUtil.getParameter(request, prefix	+ "f_cmd", length));
			String[] copMstBkg = (JSPUtil.getParameter(request, prefix	+ "cop_mst_bkg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] dblDt = (JSPUtil.getParameter(request, prefix	+ "dbl_dt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] nivDt = (JSPUtil.getParameter(request, prefix	+ "niv_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new COPDetailVO();
				if (actCd[i] != null)
					model.setActCd(actCd[i]);
				if (strBlNo[i] != null)
					model.setStrBlNo(strBlNo[i]);
				if (cntrNoV[i] != null)
					model.setCntrNoV(cntrNoV[i]);
				if (aniDt[i] != null)
					model.setAniDt(aniDt[i]);
				if (caiDt[i] != null)
					model.setCaiDt(caiDt[i]);
				if (clickBtnNm[i] != null)
					model.setClickBtnNm(clickBtnNm[i]);
				if (copSts[i] != null)
					model.setCopSts(copSts[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (fCmd[i] != null)
					model.setFCmd(fCmd[i]);
				if (copMstBkg[i] != null)
					model.setCopMstBkg(copMstBkg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (dblDt[i] != null)
					model.setDblDt(dblDt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (nivDt[i] != null)
					model.setNivDt(nivDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCOPDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return COPDetailVO[]
	 */
	public COPDetailVO[] getCOPDetailVOs(){
		COPDetailVO[] vos = (COPDetailVO[])models.toArray(new COPDetailVO[models.size()]);
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
		this.actCd = this.actCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strBlNo = this.strBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNoV = this.cntrNoV .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aniDt = this.aniDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caiDt = this.caiDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clickBtnNm = this.clickBtnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copSts = this.copSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCmd = this.fCmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copMstBkg = this.copMstBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dblDt = this.dblDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nivDt = this.nivDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

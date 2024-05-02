/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PreConfirmBkgVO.java
*@FileTitle : PreConfirmBkgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.21
*@LastModifier : 
*@LastVersion : 1.0
* 2010.06.21  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PreConfirmBkgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PreConfirmBkgVO> models = new ArrayList<PreConfirmBkgVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String preVvd = null;
	/* Column Info */
	private String preBkgStsCd = null;
	/* Column Info */
	private String preCntrPrtFlg = null;
	/* Column Info */
	private String preBkgNo = null;
	/* Column Info */
	private String porStsVvd = null;
	/* Column Info */
	private String prePorCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PreConfirmBkgVO() {}

	public PreConfirmBkgVO(String ibflag, String pagerows, String porStsVvd, String prePorCd, String preBkgStsCd, String preVvd, String preBkgNo, String porCd, String vvd, String bkgNo, String preCntrPrtFlg) {
		this.vvd = vvd;
		this.porCd = porCd;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.preVvd = preVvd;
		this.preBkgStsCd = preBkgStsCd;
		this.preCntrPrtFlg = preCntrPrtFlg;
		this.preBkgNo = preBkgNo;
		this.porStsVvd = porStsVvd;
		this.prePorCd = prePorCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pre_vvd", getPreVvd());
		this.hashColumns.put("pre_bkg_sts_cd", getPreBkgStsCd());
		this.hashColumns.put("pre_cntr_prt_flg", getPreCntrPrtFlg());
		this.hashColumns.put("pre_bkg_no", getPreBkgNo());
		this.hashColumns.put("por_sts_vvd", getPorStsVvd());
		this.hashColumns.put("pre_por_cd", getPrePorCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pre_vvd", "preVvd");
		this.hashFields.put("pre_bkg_sts_cd", "preBkgStsCd");
		this.hashFields.put("pre_cntr_prt_flg", "preCntrPrtFlg");
		this.hashFields.put("pre_bkg_no", "preBkgNo");
		this.hashFields.put("por_sts_vvd", "porStsVvd");
		this.hashFields.put("pre_por_cd", "prePorCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
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
	 * @return preVvd
	 */
	public String getPreVvd() {
		return this.preVvd;
	}
	
	/**
	 * Column Info
	 * @return preBkgStsCd
	 */
	public String getPreBkgStsCd() {
		return this.preBkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return preCntrPrtFlg
	 */
	public String getPreCntrPrtFlg() {
		return this.preCntrPrtFlg;
	}
	
	/**
	 * Column Info
	 * @return preBkgNo
	 */
	public String getPreBkgNo() {
		return this.preBkgNo;
	}
	
	/**
	 * Column Info
	 * @return porStsVvd
	 */
	public String getPorStsVvd() {
		return this.porStsVvd;
	}
	
	/**
	 * Column Info
	 * @return prePorCd
	 */
	public String getPrePorCd() {
		return this.prePorCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param preVvd
	 */
	public void setPreVvd(String preVvd) {
		this.preVvd = preVvd;
	}
	
	/**
	 * Column Info
	 * @param preBkgStsCd
	 */
	public void setPreBkgStsCd(String preBkgStsCd) {
		this.preBkgStsCd = preBkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param preCntrPrtFlg
	 */
	public void setPreCntrPrtFlg(String preCntrPrtFlg) {
		this.preCntrPrtFlg = preCntrPrtFlg;
	}
	
	/**
	 * Column Info
	 * @param preBkgNo
	 */
	public void setPreBkgNo(String preBkgNo) {
		this.preBkgNo = preBkgNo;
	}
	
	/**
	 * Column Info
	 * @param porStsVvd
	 */
	public void setPorStsVvd(String porStsVvd) {
		this.porStsVvd = porStsVvd;
	}
	
	/**
	 * Column Info
	 * @param prePorCd
	 */
	public void setPrePorCd(String prePorCd) {
		this.prePorCd = prePorCd;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPreVvd(JSPUtil.getParameter(request, prefix + "pre_vvd", ""));
		setPreBkgStsCd(JSPUtil.getParameter(request, prefix + "pre_bkg_sts_cd", ""));
		setPreCntrPrtFlg(JSPUtil.getParameter(request, prefix + "pre_cntr_prt_flg", ""));
		setPreBkgNo(JSPUtil.getParameter(request, prefix + "pre_bkg_no", ""));
		setPorStsVvd(JSPUtil.getParameter(request, prefix + "por_sts_vvd", ""));
		setPrePorCd(JSPUtil.getParameter(request, prefix + "pre_por_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PreConfirmBkgVO[]
	 */
	public PreConfirmBkgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PreConfirmBkgVO[]
	 */
	public PreConfirmBkgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PreConfirmBkgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] preVvd = (JSPUtil.getParameter(request, prefix	+ "pre_vvd", length));
			String[] preBkgStsCd = (JSPUtil.getParameter(request, prefix	+ "pre_bkg_sts_cd", length));
			String[] preCntrPrtFlg = (JSPUtil.getParameter(request, prefix	+ "pre_cntr_prt_flg", length));
			String[] preBkgNo = (JSPUtil.getParameter(request, prefix	+ "pre_bkg_no", length));
			String[] porStsVvd = (JSPUtil.getParameter(request, prefix	+ "por_sts_vvd", length));
			String[] prePorCd = (JSPUtil.getParameter(request, prefix	+ "pre_por_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PreConfirmBkgVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (preVvd[i] != null)
					model.setPreVvd(preVvd[i]);
				if (preBkgStsCd[i] != null)
					model.setPreBkgStsCd(preBkgStsCd[i]);
				if (preCntrPrtFlg[i] != null)
					model.setPreCntrPrtFlg(preCntrPrtFlg[i]);
				if (preBkgNo[i] != null)
					model.setPreBkgNo(preBkgNo[i]);
				if (porStsVvd[i] != null)
					model.setPorStsVvd(porStsVvd[i]);
				if (prePorCd[i] != null)
					model.setPrePorCd(prePorCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPreConfirmBkgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PreConfirmBkgVO[]
	 */
	public PreConfirmBkgVO[] getPreConfirmBkgVOs(){
		PreConfirmBkgVO[] vos = (PreConfirmBkgVO[])models.toArray(new PreConfirmBkgVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preVvd = this.preVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preBkgStsCd = this.preBkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCntrPrtFlg = this.preCntrPrtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preBkgNo = this.preBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porStsVvd = this.porStsVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePorCd = this.prePorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

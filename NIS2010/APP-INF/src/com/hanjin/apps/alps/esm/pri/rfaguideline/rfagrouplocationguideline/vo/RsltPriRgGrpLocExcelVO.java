/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPriRgGrpLocExcelVO.java
*@FileTitle : RsltPriRgGrpLocExcelVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.07.27 최성민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaguideline.rfagrouplocationguideline.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPriRgGrpLocExcelVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriRgGrpLocExcelVO> models = new ArrayList<RsltPriRgGrpLocExcelVO>();
	
	/* Column Info */
	private String scontiNm = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String grpLocSeq = null;
	/* Column Info */
	private String prcGrpLocDesc = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String glineSeq = null;
	/* Column Info */
	private String locNm = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String orgDestTpDesc = null;
	/* Column Info */
	private String grpLocDtlSeq = null;
	/* Column Info */
	private String prcGrpLocCd = null;
	/* Column Info */
	private String scontiCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriRgGrpLocExcelVO() {}

	public RsltPriRgGrpLocExcelVO(String ibflag, String pagerows, String svcScpCd, String glineSeq, String grpLocSeq, String grpLocDtlSeq, String orgDestTpCd, String orgDestTpDesc, String prcGrpLocCd, String prcGrpLocDesc, String locCd, String locNm, String scontiCd, String scontiNm) {
		this.scontiNm = scontiNm;
		this.svcScpCd = svcScpCd;
		this.grpLocSeq = grpLocSeq;
		this.prcGrpLocDesc = prcGrpLocDesc;
		this.orgDestTpCd = orgDestTpCd;
		this.glineSeq = glineSeq;
		this.locNm = locNm;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.orgDestTpDesc = orgDestTpDesc;
		this.grpLocDtlSeq = grpLocDtlSeq;
		this.prcGrpLocCd = prcGrpLocCd;
		this.scontiCd = scontiCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sconti_nm", getScontiNm());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("grp_loc_seq", getGrpLocSeq());
		this.hashColumns.put("prc_grp_loc_desc", getPrcGrpLocDesc());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("gline_seq", getGlineSeq());
		this.hashColumns.put("loc_nm", getLocNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("org_dest_tp_desc", getOrgDestTpDesc());
		this.hashColumns.put("grp_loc_dtl_seq", getGrpLocDtlSeq());
		this.hashColumns.put("prc_grp_loc_cd", getPrcGrpLocCd());
		this.hashColumns.put("sconti_cd", getScontiCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sconti_nm", "scontiNm");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("grp_loc_seq", "grpLocSeq");
		this.hashFields.put("prc_grp_loc_desc", "prcGrpLocDesc");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("gline_seq", "glineSeq");
		this.hashFields.put("loc_nm", "locNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("org_dest_tp_desc", "orgDestTpDesc");
		this.hashFields.put("grp_loc_dtl_seq", "grpLocDtlSeq");
		this.hashFields.put("prc_grp_loc_cd", "prcGrpLocCd");
		this.hashFields.put("sconti_cd", "scontiCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return scontiNm
	 */
	public String getScontiNm() {
		return this.scontiNm;
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
	 * @return grpLocSeq
	 */
	public String getGrpLocSeq() {
		return this.grpLocSeq;
	}
	
	/**
	 * Column Info
	 * @return prcGrpLocDesc
	 */
	public String getPrcGrpLocDesc() {
		return this.prcGrpLocDesc;
	}
	
	/**
	 * Column Info
	 * @return orgDestTpCd
	 */
	public String getOrgDestTpCd() {
		return this.orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @return glineSeq
	 */
	public String getGlineSeq() {
		return this.glineSeq;
	}
	
	/**
	 * Column Info
	 * @return locNm
	 */
	public String getLocNm() {
		return this.locNm;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return orgDestTpDesc
	 */
	public String getOrgDestTpDesc() {
		return this.orgDestTpDesc;
	}
	
	/**
	 * Column Info
	 * @return grpLocDtlSeq
	 */
	public String getGrpLocDtlSeq() {
		return this.grpLocDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return prcGrpLocCd
	 */
	public String getPrcGrpLocCd() {
		return this.prcGrpLocCd;
	}
	
	/**
	 * Column Info
	 * @return scontiCd
	 */
	public String getScontiCd() {
		return this.scontiCd;
	}
	

	/**
	 * Column Info
	 * @param scontiNm
	 */
	public void setScontiNm(String scontiNm) {
		this.scontiNm = scontiNm;
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
	 * @param grpLocSeq
	 */
	public void setGrpLocSeq(String grpLocSeq) {
		this.grpLocSeq = grpLocSeq;
	}
	
	/**
	 * Column Info
	 * @param prcGrpLocDesc
	 */
	public void setPrcGrpLocDesc(String prcGrpLocDesc) {
		this.prcGrpLocDesc = prcGrpLocDesc;
	}
	
	/**
	 * Column Info
	 * @param orgDestTpCd
	 */
	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @param glineSeq
	 */
	public void setGlineSeq(String glineSeq) {
		this.glineSeq = glineSeq;
	}
	
	/**
	 * Column Info
	 * @param locNm
	 */
	public void setLocNm(String locNm) {
		this.locNm = locNm;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param orgDestTpDesc
	 */
	public void setOrgDestTpDesc(String orgDestTpDesc) {
		this.orgDestTpDesc = orgDestTpDesc;
	}
	
	/**
	 * Column Info
	 * @param grpLocDtlSeq
	 */
	public void setGrpLocDtlSeq(String grpLocDtlSeq) {
		this.grpLocDtlSeq = grpLocDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param prcGrpLocCd
	 */
	public void setPrcGrpLocCd(String prcGrpLocCd) {
		this.prcGrpLocCd = prcGrpLocCd;
	}
	
	/**
	 * Column Info
	 * @param scontiCd
	 */
	public void setScontiCd(String scontiCd) {
		this.scontiCd = scontiCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setScontiNm(JSPUtil.getParameter(request, "sconti_nm", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setGrpLocSeq(JSPUtil.getParameter(request, "grp_loc_seq", ""));
		setPrcGrpLocDesc(JSPUtil.getParameter(request, "prc_grp_loc_desc", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, "org_dest_tp_cd", ""));
		setGlineSeq(JSPUtil.getParameter(request, "gline_seq", ""));
		setLocNm(JSPUtil.getParameter(request, "loc_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setOrgDestTpDesc(JSPUtil.getParameter(request, "org_dest_tp_desc", ""));
		setGrpLocDtlSeq(JSPUtil.getParameter(request, "grp_loc_dtl_seq", ""));
		setPrcGrpLocCd(JSPUtil.getParameter(request, "prc_grp_loc_cd", ""));
		setScontiCd(JSPUtil.getParameter(request, "sconti_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriRgGrpLocExcelVO[]
	 */
	public RsltPriRgGrpLocExcelVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriRgGrpLocExcelVO[]
	 */
	public RsltPriRgGrpLocExcelVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriRgGrpLocExcelVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] scontiNm = (JSPUtil.getParameter(request, prefix	+ "sconti_nm", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] grpLocSeq = (JSPUtil.getParameter(request, prefix	+ "grp_loc_seq", length));
			String[] prcGrpLocDesc = (JSPUtil.getParameter(request, prefix	+ "prc_grp_loc_desc", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] glineSeq = (JSPUtil.getParameter(request, prefix	+ "gline_seq", length));
			String[] locNm = (JSPUtil.getParameter(request, prefix	+ "loc_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] orgDestTpDesc = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_desc", length));
			String[] grpLocDtlSeq = (JSPUtil.getParameter(request, prefix	+ "grp_loc_dtl_seq", length));
			String[] prcGrpLocCd = (JSPUtil.getParameter(request, prefix	+ "prc_grp_loc_cd", length));
			String[] scontiCd = (JSPUtil.getParameter(request, prefix	+ "sconti_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriRgGrpLocExcelVO();
				if (scontiNm[i] != null)
					model.setScontiNm(scontiNm[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (grpLocSeq[i] != null)
					model.setGrpLocSeq(grpLocSeq[i]);
				if (prcGrpLocDesc[i] != null)
					model.setPrcGrpLocDesc(prcGrpLocDesc[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (glineSeq[i] != null)
					model.setGlineSeq(glineSeq[i]);
				if (locNm[i] != null)
					model.setLocNm(locNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (orgDestTpDesc[i] != null)
					model.setOrgDestTpDesc(orgDestTpDesc[i]);
				if (grpLocDtlSeq[i] != null)
					model.setGrpLocDtlSeq(grpLocDtlSeq[i]);
				if (prcGrpLocCd[i] != null)
					model.setPrcGrpLocCd(prcGrpLocCd[i]);
				if (scontiCd[i] != null)
					model.setScontiCd(scontiCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriRgGrpLocExcelVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriRgGrpLocExcelVO[]
	 */
	public RsltPriRgGrpLocExcelVO[] getRsltPriRgGrpLocExcelVOs(){
		RsltPriRgGrpLocExcelVO[] vos = (RsltPriRgGrpLocExcelVO[])models.toArray(new RsltPriRgGrpLocExcelVO[models.size()]);
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
		this.scontiNm = this.scontiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpLocSeq = this.grpLocSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcGrpLocDesc = this.prcGrpLocDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineSeq = this.glineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNm = this.locNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpDesc = this.orgDestTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpLocDtlSeq = this.grpLocDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcGrpLocCd = this.prcGrpLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontiCd = this.scontiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

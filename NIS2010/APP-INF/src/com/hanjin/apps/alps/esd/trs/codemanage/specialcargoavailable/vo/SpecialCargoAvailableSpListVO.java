/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialCargoAvailableSpListVO.java
*@FileTitle : SpecialCargoAvailableSpListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.07
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2015.01.07 DONG- IL, SHIN 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.codemanage.specialcargoavailable.vo;

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
 * @author DONG- IL, SHIN
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SpecialCargoAvailableSpListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpecialCargoAvailableSpListVO> models = new ArrayList<SpecialCargoAvailableSpListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String hzdMtrlFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ovwtTriAxlFlg = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String soCreOfcCd = null;
	/* Column Info */
	private String trspSpclCgoSpSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SpecialCargoAvailableSpListVO() {}

	public SpecialCargoAvailableSpListVO(String ibflag, String pagerows, String trspSpclCgoSpSeq, String vndrSeq, String soCreOfcCd, String hzdMtrlFlg, String ovwtTriAxlFlg, String creOfcCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.hzdMtrlFlg = hzdMtrlFlg;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.ovwtTriAxlFlg = ovwtTriAxlFlg;
		this.creOfcCd = creOfcCd;
		this.vndrSeq = vndrSeq;
		this.creDt = creDt;
		this.soCreOfcCd = soCreOfcCd;
		this.trspSpclCgoSpSeq = trspSpclCgoSpSeq;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("hzd_mtrl_flg", getHzdMtrlFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ovwt_tri_axl_flg", getOvwtTriAxlFlg());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("so_cre_ofc_cd", getSoCreOfcCd());
		this.hashColumns.put("trsp_spcl_cgo_sp_seq", getTrspSpclCgoSpSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("hzd_mtrl_flg", "hzdMtrlFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ovwt_tri_axl_flg", "ovwtTriAxlFlg");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("so_cre_ofc_cd", "soCreOfcCd");
		this.hashFields.put("trsp_spcl_cgo_sp_seq", "trspSpclCgoSpSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return hzdMtrlFlg
	 */
	public String getHzdMtrlFlg() {
		return this.hzdMtrlFlg;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return ovwtTriAxlFlg
	 */
	public String getOvwtTriAxlFlg() {
		return this.ovwtTriAxlFlg;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return soCreOfcCd
	 */
	public String getSoCreOfcCd() {
		return this.soCreOfcCd;
	}
	
	/**
	 * Column Info
	 * @return trspSpclCgoSpSeq
	 */
	public String getTrspSpclCgoSpSeq() {
		return this.trspSpclCgoSpSeq;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param hzdMtrlFlg
	 */
	public void setHzdMtrlFlg(String hzdMtrlFlg) {
		this.hzdMtrlFlg = hzdMtrlFlg;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param ovwtTriAxlFlg
	 */
	public void setOvwtTriAxlFlg(String ovwtTriAxlFlg) {
		this.ovwtTriAxlFlg = ovwtTriAxlFlg;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param soCreOfcCd
	 */
	public void setSoCreOfcCd(String soCreOfcCd) {
		this.soCreOfcCd = soCreOfcCd;
	}
	
	/**
	 * Column Info
	 * @param trspSpclCgoSpSeq
	 */
	public void setTrspSpclCgoSpSeq(String trspSpclCgoSpSeq) {
		this.trspSpclCgoSpSeq = trspSpclCgoSpSeq;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setHzdMtrlFlg(JSPUtil.getParameter(request, prefix + "hzd_mtrl_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOvwtTriAxlFlg(JSPUtil.getParameter(request, prefix + "ovwt_tri_axl_flg", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSoCreOfcCd(JSPUtil.getParameter(request, prefix + "so_cre_ofc_cd", ""));
		setTrspSpclCgoSpSeq(JSPUtil.getParameter(request, prefix + "trsp_spcl_cgo_sp_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpecialCargoAvailableSpListVO[]
	 */
	public SpecialCargoAvailableSpListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpecialCargoAvailableSpListVO[]
	 */
	public SpecialCargoAvailableSpListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpecialCargoAvailableSpListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] hzdMtrlFlg = (JSPUtil.getParameter(request, prefix	+ "hzd_mtrl_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ovwtTriAxlFlg = (JSPUtil.getParameter(request, prefix	+ "ovwt_tri_axl_flg", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] soCreOfcCd = (JSPUtil.getParameter(request, prefix	+ "so_cre_ofc_cd", length));
			String[] trspSpclCgoSpSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_spcl_cgo_sp_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpecialCargoAvailableSpListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (hzdMtrlFlg[i] != null)
					model.setHzdMtrlFlg(hzdMtrlFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ovwtTriAxlFlg[i] != null)
					model.setOvwtTriAxlFlg(ovwtTriAxlFlg[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (soCreOfcCd[i] != null)
					model.setSoCreOfcCd(soCreOfcCd[i]);
				if (trspSpclCgoSpSeq[i] != null)
					model.setTrspSpclCgoSpSeq(trspSpclCgoSpSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpecialCargoAvailableSpListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpecialCargoAvailableSpListVO[]
	 */
	public SpecialCargoAvailableSpListVO[] getSpecialCargoAvailableSpListVOs(){
		SpecialCargoAvailableSpListVO[] vos = (SpecialCargoAvailableSpListVO[])models.toArray(new SpecialCargoAvailableSpListVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hzdMtrlFlg = this.hzdMtrlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovwtTriAxlFlg = this.ovwtTriAxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soCreOfcCd = this.soCreOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSpclCgoSpSeq = this.trspSpclCgoSpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

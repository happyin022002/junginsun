/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BisManualListVO.java
*@FileTitle : BisManualListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.10
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2011.10.10 김태경 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo;

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
 * @author 김태경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BisManualListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BisManualListVO> models = new ArrayList<BisManualListVO>();
	
	/* Column Info */
	private String oblRlseFlg = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oblSrndFlg = null;
	/* Column Info */
	private String oblIssFlg = null;
	/* Column Info */
	private String oblPrnFlg = null;
	/* Column Info */
	private String bisSysFlg = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String oblRdemFlg = null;
	/* Column Info */
	private String chgFlg = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BisManualListVO() {}

	public BisManualListVO(String ibflag, String pagerows, String bkgNo, String bdrFlg, String bisSysFlg, String oblIssFlg, String oblPrnFlg, String oblRlseFlg, String oblSrndFlg, String oblRdemFlg, String chgFlg) {
		this.oblRlseFlg = oblRlseFlg;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.oblSrndFlg = oblSrndFlg;
		this.oblIssFlg = oblIssFlg;
		this.oblPrnFlg = oblPrnFlg;
		this.bisSysFlg = bisSysFlg;
		this.bdrFlg = bdrFlg;
		this.oblRdemFlg = oblRdemFlg;
		this.chgFlg = chgFlg;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("obl_rlse_flg", getOblRlseFlg());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("obl_srnd_flg", getOblSrndFlg());
		this.hashColumns.put("obl_iss_flg", getOblIssFlg());
		this.hashColumns.put("obl_prn_flg", getOblPrnFlg());
		this.hashColumns.put("bis_sys_flg", getBisSysFlg());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("obl_rdem_flg", getOblRdemFlg());
		this.hashColumns.put("chg_flg", getChgFlg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("obl_rlse_flg", "oblRlseFlg");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("obl_srnd_flg", "oblSrndFlg");
		this.hashFields.put("obl_iss_flg", "oblIssFlg");
		this.hashFields.put("obl_prn_flg", "oblPrnFlg");
		this.hashFields.put("bis_sys_flg", "bisSysFlg");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("obl_rdem_flg", "oblRdemFlg");
		this.hashFields.put("chg_flg", "chgFlg");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return oblSrndFlg
	 */
	public String getOblSrndFlg() {
		return this.oblSrndFlg;
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
	 * @return oblPrnFlg
	 */
	public String getOblPrnFlg() {
		return this.oblPrnFlg;
	}
	
	/**
	 * Column Info
	 * @return bisSysFlg
	 */
	public String getBisSysFlg() {
		return this.bisSysFlg;
	}
	
	/**
	 * Column Info
	 * @return bdrFlg
	 */
	public String getBdrFlg() {
		return this.bdrFlg;
	}
	
	/**
	 * Column Info
	 * @return oblRdemFlg
	 */
	public String getOblRdemFlg() {
		return this.oblRdemFlg;
	}
	
	/**
	 * Column Info
	 * @return chgFlg
	 */
	public String getChgFlg() {
		return this.chgFlg;
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
	 * @param oblRlseFlg
	 */
	public void setOblRlseFlg(String oblRlseFlg) {
		this.oblRlseFlg = oblRlseFlg;
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
	 * @param oblSrndFlg
	 */
	public void setOblSrndFlg(String oblSrndFlg) {
		this.oblSrndFlg = oblSrndFlg;
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
	 * @param oblPrnFlg
	 */
	public void setOblPrnFlg(String oblPrnFlg) {
		this.oblPrnFlg = oblPrnFlg;
	}
	
	/**
	 * Column Info
	 * @param bisSysFlg
	 */
	public void setBisSysFlg(String bisSysFlg) {
		this.bisSysFlg = bisSysFlg;
	}
	
	/**
	 * Column Info
	 * @param bdrFlg
	 */
	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
	}
	
	/**
	 * Column Info
	 * @param oblRdemFlg
	 */
	public void setOblRdemFlg(String oblRdemFlg) {
		this.oblRdemFlg = oblRdemFlg;
	}
	
	/**
	 * Column Info
	 * @param chgFlg
	 */
	public void setChgFlg(String chgFlg) {
		this.chgFlg = chgFlg;
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
		setOblRlseFlg(JSPUtil.getParameter(request, prefix + "obl_rlse_flg", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOblSrndFlg(JSPUtil.getParameter(request, prefix + "obl_srnd_flg", ""));
		setOblIssFlg(JSPUtil.getParameter(request, prefix + "obl_iss_flg", ""));
		setOblPrnFlg(JSPUtil.getParameter(request, prefix + "obl_prn_flg", ""));
		setBisSysFlg(JSPUtil.getParameter(request, prefix + "bis_sys_flg", ""));
		setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
		setOblRdemFlg(JSPUtil.getParameter(request, prefix + "obl_rdem_flg", ""));
		setChgFlg(JSPUtil.getParameter(request, prefix + "chg_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BisManualListVO[]
	 */
	public BisManualListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BisManualListVO[]
	 */
	public BisManualListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BisManualListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] oblRlseFlg = (JSPUtil.getParameter(request, prefix	+ "obl_rlse_flg", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oblSrndFlg = (JSPUtil.getParameter(request, prefix	+ "obl_srnd_flg", length));
			String[] oblIssFlg = (JSPUtil.getParameter(request, prefix	+ "obl_iss_flg", length));
			String[] oblPrnFlg = (JSPUtil.getParameter(request, prefix	+ "obl_prn_flg", length));
			String[] bisSysFlg = (JSPUtil.getParameter(request, prefix	+ "bis_sys_flg", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] oblRdemFlg = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_flg", length));
			String[] chgFlg = (JSPUtil.getParameter(request, prefix	+ "chg_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BisManualListVO();
				if (oblRlseFlg[i] != null)
					model.setOblRlseFlg(oblRlseFlg[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oblSrndFlg[i] != null)
					model.setOblSrndFlg(oblSrndFlg[i]);
				if (oblIssFlg[i] != null)
					model.setOblIssFlg(oblIssFlg[i]);
				if (oblPrnFlg[i] != null)
					model.setOblPrnFlg(oblPrnFlg[i]);
				if (bisSysFlg[i] != null)
					model.setBisSysFlg(bisSysFlg[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (oblRdemFlg[i] != null)
					model.setOblRdemFlg(oblRdemFlg[i]);
				if (chgFlg[i] != null)
					model.setChgFlg(chgFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBisManualListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BisManualListVO[]
	 */
	public BisManualListVO[] getBisManualListVOs(){
		BisManualListVO[] vos = (BisManualListVO[])models.toArray(new BisManualListVO[models.size()]);
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
		this.oblRlseFlg = this.oblRlseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblSrndFlg = this.oblSrndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssFlg = this.oblIssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblPrnFlg = this.oblPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bisSysFlg = this.bisSysFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemFlg = this.oblRdemFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgFlg = this.chgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

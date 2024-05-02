/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchQtaAdjustmentListVO.java
*@FileTitle : SearchQtaAdjustmentListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.19
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.19  
* 1.0 Creation
* 2015.11.06 김용습 [CHM-201538494] [CSR 전환건] SKD Adjustment by VVD 화면 보완 (Trade Direction, Adjusting VVD Select, BSA Flag 칼럼 추가)
=========================================================*/

package com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.vo;

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

public class SearchQtaAdjustmentListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchQtaAdjustmentListVO> models = new ArrayList<SearchQtaAdjustmentListVO>();
	
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String masBseWk = null;
	/* Column Info */
	private String stsFlag = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String masBseMon = null;
	/* Column Info */
	private String bseWk = null;
	/* Column Info */
	private String masFnlBsaCapa = null;
	/* Column Info */
	private String masVvd = null;
	/* Column Info */
	private String fnlBsaCapa = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bseMon = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String flag = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String hulBndCd = null;
	/* Column Info */
	private String bsaZrFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchQtaAdjustmentListVO() {}

	public SearchQtaAdjustmentListVO(String ibflag, String pagerows, String trdCd, String rlaneCd, String subTrdCd, String dirCd, String iocCd, String bseMon, String bseWk, String vvd, String fnlBsaCapa, String masBseMon, String masBseWk, String masVvd, String masFnlBsaCapa, String stsFlag, String flag, String hulBndCd, String bsaZrFlg) {
		this.iocCd = iocCd;
		this.masBseWk = masBseWk;
		this.stsFlag = stsFlag;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.masBseMon = masBseMon;
		this.bseWk = bseWk;
		this.masFnlBsaCapa = masFnlBsaCapa;
		this.masVvd = masVvd;
		this.fnlBsaCapa = fnlBsaCapa;
		this.pagerows = pagerows;
		this.bseMon = bseMon;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.flag = flag;
		this.dirCd = dirCd;
		this.subTrdCd = subTrdCd;
		this.hulBndCd = hulBndCd;
		this.bsaZrFlg = bsaZrFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("mas_bse_wk", getMasBseWk());
		this.hashColumns.put("sts_flag", getStsFlag());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("mas_bse_mon", getMasBseMon());
		this.hashColumns.put("bse_wk", getBseWk());
		this.hashColumns.put("mas_fnl_bsa_capa", getMasFnlBsaCapa());
		this.hashColumns.put("mas_vvd", getMasVvd());
		this.hashColumns.put("fnl_bsa_capa", getFnlBsaCapa());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bse_mon", getBseMon());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("flag", getFlag());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());
		this.hashColumns.put("bsa_zr_flg", getBsaZrFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("mas_bse_wk", "masBseWk");
		this.hashFields.put("sts_flag", "stsFlag");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("mas_bse_mon", "masBseMon");
		this.hashFields.put("bse_wk", "bseWk");
		this.hashFields.put("mas_fnl_bsa_capa", "masFnlBsaCapa");
		this.hashFields.put("mas_vvd", "masVvd");
		this.hashFields.put("fnl_bsa_capa", "fnlBsaCapa");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bse_mon", "bseMon");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("flag", "flag");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("bsa_zr_flg", "bsaZrFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return masBseWk
	 */
	public String getMasBseWk() {
		return this.masBseWk;
	}
	
	/**
	 * Column Info
	 * @return stsFlag
	 */
	public String getStsFlag() {
		return this.stsFlag;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return masBseMon
	 */
	public String getMasBseMon() {
		return this.masBseMon;
	}
	
	/**
	 * Column Info
	 * @return bseWk
	 */
	public String getBseWk() {
		return this.bseWk;
	}
	
	/**
	 * Column Info
	 * @return masFnlBsaCapa
	 */
	public String getMasFnlBsaCapa() {
		return this.masFnlBsaCapa;
	}
	
	/**
	 * Column Info
	 * @return masVvd
	 */
	public String getMasVvd() {
		return this.masVvd;
	}
	
	/**
	 * Column Info
	 * @return fnlBsaCapa
	 */
	public String getFnlBsaCapa() {
		return this.fnlBsaCapa;
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
	 * @return bseMon
	 */
	public String getBseMon() {
		return this.bseMon;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return flag
	 */
	public String getFlag() {
		return this.flag;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return hulBndCd
	 */
	public String getHulBndCd() {
		return this.hulBndCd;
	}
	
	/**
	 * Column Info
	 * @return bsaZrFlg
	 */
	public String getBsaZrFlg() {
		return this.bsaZrFlg;
	}
	

	/**
	 * Column Info
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param masBseWk
	 */
	public void setMasBseWk(String masBseWk) {
		this.masBseWk = masBseWk;
	}
	
	/**
	 * Column Info
	 * @param stsFlag
	 */
	public void setStsFlag(String stsFlag) {
		this.stsFlag = stsFlag;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param masBseMon
	 */
	public void setMasBseMon(String masBseMon) {
		this.masBseMon = masBseMon;
	}
	
	/**
	 * Column Info
	 * @param bseWk
	 */
	public void setBseWk(String bseWk) {
		this.bseWk = bseWk;
	}
	
	/**
	 * Column Info
	 * @param masFnlBsaCapa
	 */
	public void setMasFnlBsaCapa(String masFnlBsaCapa) {
		this.masFnlBsaCapa = masFnlBsaCapa;
	}
	
	/**
	 * Column Info
	 * @param masVvd
	 */
	public void setMasVvd(String masVvd) {
		this.masVvd = masVvd;
	}
	
	/**
	 * Column Info
	 * @param fnlBsaCapa
	 */
	public void setFnlBsaCapa(String fnlBsaCapa) {
		this.fnlBsaCapa = fnlBsaCapa;
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
	 * @param bseMon
	 */
	public void setBseMon(String bseMon) {
		this.bseMon = bseMon;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param hulBndCd
	 */
	public void setHulBndCd(String hulBndCd) {
		this.hulBndCd = hulBndCd;
	}
	
	/**
	 * Column Info
	 * @param bsaZrFlg
	 */
	public void setBsaZrFlg(String bsaZrFlg) {
		this.bsaZrFlg = bsaZrFlg;
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
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setMasBseWk(JSPUtil.getParameter(request, prefix + "mas_bse_wk", ""));
		setStsFlag(JSPUtil.getParameter(request, prefix + "sts_flag", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setMasBseMon(JSPUtil.getParameter(request, prefix + "mas_bse_mon", ""));
		setBseWk(JSPUtil.getParameter(request, prefix + "bse_wk", ""));
		setMasFnlBsaCapa(JSPUtil.getParameter(request, prefix + "mas_fnl_bsa_capa", ""));
		setMasVvd(JSPUtil.getParameter(request, prefix + "mas_vvd", ""));
		setFnlBsaCapa(JSPUtil.getParameter(request, prefix + "fnl_bsa_capa", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBseMon(JSPUtil.getParameter(request, prefix + "bse_mon", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFlag(JSPUtil.getParameter(request, prefix + "flag", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setHulBndCd(JSPUtil.getParameter(request, prefix + "hul_bnd_cd", ""));
		setBsaZrFlg(JSPUtil.getParameter(request, prefix + "bsa_zr_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchQtaAdjustmentListVO[]
	 */
	public SearchQtaAdjustmentListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchQtaAdjustmentListVO[]
	 */
	public SearchQtaAdjustmentListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchQtaAdjustmentListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] masBseWk = (JSPUtil.getParameter(request, prefix	+ "mas_bse_wk", length));
			String[] stsFlag = (JSPUtil.getParameter(request, prefix	+ "sts_flag", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] masBseMon = (JSPUtil.getParameter(request, prefix	+ "mas_bse_mon", length));
			String[] bseWk = (JSPUtil.getParameter(request, prefix	+ "bse_wk", length));
			String[] masFnlBsaCapa = (JSPUtil.getParameter(request, prefix	+ "mas_fnl_bsa_capa", length));
			String[] masVvd = (JSPUtil.getParameter(request, prefix	+ "mas_vvd", length));
			String[] fnlBsaCapa = (JSPUtil.getParameter(request, prefix	+ "fnl_bsa_capa", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bseMon = (JSPUtil.getParameter(request, prefix	+ "bse_mon", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] flag = (JSPUtil.getParameter(request, prefix	+ "flag", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] hulBndCd = (JSPUtil.getParameter(request, prefix	+ "hul_bnd_cd", length));
			String[] bsaZrFlg = (JSPUtil.getParameter(request, prefix	+ "bsa_zr_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchQtaAdjustmentListVO();
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (masBseWk[i] != null)
					model.setMasBseWk(masBseWk[i]);
				if (stsFlag[i] != null)
					model.setStsFlag(stsFlag[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (masBseMon[i] != null)
					model.setMasBseMon(masBseMon[i]);
				if (bseWk[i] != null)
					model.setBseWk(bseWk[i]);
				if (masFnlBsaCapa[i] != null)
					model.setMasFnlBsaCapa(masFnlBsaCapa[i]);
				if (masVvd[i] != null)
					model.setMasVvd(masVvd[i]);
				if (fnlBsaCapa[i] != null)
					model.setFnlBsaCapa(fnlBsaCapa[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bseMon[i] != null)
					model.setBseMon(bseMon[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (flag[i] != null)
					model.setFlag(flag[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (hulBndCd[i] != null)
					model.setHulBndCd(hulBndCd[i]);
				if (bsaZrFlg[i] != null)
					model.setBsaZrFlg(bsaZrFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchQtaAdjustmentListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchQtaAdjustmentListVO[]
	 */
	public SearchQtaAdjustmentListVO[] getSearchQtaAdjustmentListVOs(){
		SearchQtaAdjustmentListVO[] vos = (SearchQtaAdjustmentListVO[])models.toArray(new SearchQtaAdjustmentListVO[models.size()]);
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
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masBseWk = this.masBseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsFlag = this.stsFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masBseMon = this.masBseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseWk = this.bseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masFnlBsaCapa = this.masFnlBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masVvd = this.masVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlBsaCapa = this.fnlBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseMon = this.bseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flag = this.flag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd = this.hulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaZrFlg = this.bsaZrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

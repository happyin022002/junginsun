/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BisMonitorListVO.java
*@FileTitle : BisMonitorListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.27
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.01.27 김태경 
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

public class BisMonitorListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BisMonitorListVO> models = new ArrayList<BisMonitorListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String bisBkgCnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String nisCorrCnt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ckFlg = null;
	/* Column Info */
	private String keyDate = null;
	/* Column Info */
	private String nisBkgCnt = null;
	/* Column Info */
	private String bisCorrCnt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BisMonitorListVO() {}

	public BisMonitorListVO(String ibflag, String pagerows, String keyDate, String nisBkgCnt, String nisCorrCnt, String ckFlg, String bisBkgCnt, String bisCorrCnt, String creDt, String updDt) {
		this.updDt = updDt;
		this.bisBkgCnt = bisBkgCnt;
		this.ibflag = ibflag;
		this.nisCorrCnt = nisCorrCnt;
		this.creDt = creDt;
		this.ckFlg = ckFlg;
		this.keyDate = keyDate;
		this.nisBkgCnt = nisBkgCnt;
		this.bisCorrCnt = bisCorrCnt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("bis_bkg_cnt", getBisBkgCnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("nis_corr_cnt", getNisCorrCnt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ck_flg", getCkFlg());
		this.hashColumns.put("key_date", getKeyDate());
		this.hashColumns.put("nis_bkg_cnt", getNisBkgCnt());
		this.hashColumns.put("bis_corr_cnt", getBisCorrCnt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("bis_bkg_cnt", "bisBkgCnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("nis_corr_cnt", "nisCorrCnt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ck_flg", "ckFlg");
		this.hashFields.put("key_date", "keyDate");
		this.hashFields.put("nis_bkg_cnt", "nisBkgCnt");
		this.hashFields.put("bis_corr_cnt", "bisCorrCnt");
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
	 * @return bisBkgCnt
	 */
	public String getBisBkgCnt() {
		return this.bisBkgCnt;
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
	 * @return nisCorrCnt
	 */
	public String getNisCorrCnt() {
		return this.nisCorrCnt;
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
	 * @return ckFlg
	 */
	public String getCkFlg() {
		return this.ckFlg;
	}
	
	/**
	 * Column Info
	 * @return keyDate
	 */
	public String getKeyDate() {
		return this.keyDate;
	}
	
	/**
	 * Column Info
	 * @return nisBkgCnt
	 */
	public String getNisBkgCnt() {
		return this.nisBkgCnt;
	}
	
	/**
	 * Column Info
	 * @return bisCorrCnt
	 */
	public String getBisCorrCnt() {
		return this.bisCorrCnt;
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
	 * @param bisBkgCnt
	 */
	public void setBisBkgCnt(String bisBkgCnt) {
		this.bisBkgCnt = bisBkgCnt;
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
	 * @param nisCorrCnt
	 */
	public void setNisCorrCnt(String nisCorrCnt) {
		this.nisCorrCnt = nisCorrCnt;
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
	 * @param ckFlg
	 */
	public void setCkFlg(String ckFlg) {
		this.ckFlg = ckFlg;
	}
	
	/**
	 * Column Info
	 * @param keyDate
	 */
	public void setKeyDate(String keyDate) {
		this.keyDate = keyDate;
	}
	
	/**
	 * Column Info
	 * @param nisBkgCnt
	 */
	public void setNisBkgCnt(String nisBkgCnt) {
		this.nisBkgCnt = nisBkgCnt;
	}
	
	/**
	 * Column Info
	 * @param bisCorrCnt
	 */
	public void setBisCorrCnt(String bisCorrCnt) {
		this.bisCorrCnt = bisCorrCnt;
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
		setBisBkgCnt(JSPUtil.getParameter(request, prefix + "bis_bkg_cnt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setNisCorrCnt(JSPUtil.getParameter(request, prefix + "nis_corr_cnt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCkFlg(JSPUtil.getParameter(request, prefix + "ck_flg", ""));
		setKeyDate(JSPUtil.getParameter(request, prefix + "key_date", ""));
		setNisBkgCnt(JSPUtil.getParameter(request, prefix + "nis_bkg_cnt", ""));
		setBisCorrCnt(JSPUtil.getParameter(request, prefix + "bis_corr_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BisMonitorListVO[]
	 */
	public BisMonitorListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BisMonitorListVO[]
	 */
	public BisMonitorListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BisMonitorListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] bisBkgCnt = (JSPUtil.getParameter(request, prefix	+ "bis_bkg_cnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] nisCorrCnt = (JSPUtil.getParameter(request, prefix	+ "nis_corr_cnt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ckFlg = (JSPUtil.getParameter(request, prefix	+ "ck_flg", length));
			String[] keyDate = (JSPUtil.getParameter(request, prefix	+ "key_date", length));
			String[] nisBkgCnt = (JSPUtil.getParameter(request, prefix	+ "nis_bkg_cnt", length));
			String[] bisCorrCnt = (JSPUtil.getParameter(request, prefix	+ "bis_corr_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BisMonitorListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (bisBkgCnt[i] != null)
					model.setBisBkgCnt(bisBkgCnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (nisCorrCnt[i] != null)
					model.setNisCorrCnt(nisCorrCnt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ckFlg[i] != null)
					model.setCkFlg(ckFlg[i]);
				if (keyDate[i] != null)
					model.setKeyDate(keyDate[i]);
				if (nisBkgCnt[i] != null)
					model.setNisBkgCnt(nisBkgCnt[i]);
				if (bisCorrCnt[i] != null)
					model.setBisCorrCnt(bisCorrCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBisMonitorListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BisMonitorListVO[]
	 */
	public BisMonitorListVO[] getBisMonitorListVOs(){
		BisMonitorListVO[] vos = (BisMonitorListVO[])models.toArray(new BisMonitorListVO[models.size()]);
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
		this.bisBkgCnt = this.bisBkgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nisCorrCnt = this.nisCorrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ckFlg = this.ckFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyDate = this.keyDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nisBkgCnt = this.nisBkgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bisCorrCnt = this.bisCorrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

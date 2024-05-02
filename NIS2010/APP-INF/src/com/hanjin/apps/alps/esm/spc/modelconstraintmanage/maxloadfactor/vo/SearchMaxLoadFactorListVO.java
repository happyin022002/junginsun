/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMaxLoadFactorListVO.java
*@FileTitle : SearchMaxLoadFactorListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.08.27 이현주 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.maxloadfactor.vo;

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
 * @author 이현주
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMaxLoadFactorListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMaxLoadFactorListVO> models = new ArrayList<SearchMaxLoadFactorListVO>();
	
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String statCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ldf01 = null;
	/* Column Info */
	private String ldf03 = null;
	/* Column Info */
	private String ldf02 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ldf05 = null;
	/* Column Info */
	private String ldf04 = null;
	/* Column Info */
	private String protectFlg = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String subTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMaxLoadFactorListVO() {}

	public SearchMaxLoadFactorListVO(String ibflag, String pagerows, String trdCd, String subTrdCd, String rlaneCd, String dirCd, String ldf01, String ldf02, String ldf03, String ldf04, String ldf05, String statCd, String protectFlg, String bseYr) {
		this.trdCd = trdCd;
		this.bseYr = bseYr;
		this.rlaneCd = rlaneCd;
		this.statCd = statCd;
		this.pagerows = pagerows;
		this.ldf01 = ldf01;
		this.ldf03 = ldf03;
		this.ldf02 = ldf02;
		this.ibflag = ibflag;
		this.ldf05 = ldf05;
		this.ldf04 = ldf04;
		this.protectFlg = protectFlg;
		this.dirCd = dirCd;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("stat_cd", getStatCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ldf_01", getLdf01());
		this.hashColumns.put("ldf_03", getLdf03());
		this.hashColumns.put("ldf_02", getLdf02());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ldf_05", getLdf05());
		this.hashColumns.put("ldf_04", getLdf04());
		this.hashColumns.put("protect_flg", getProtectFlg());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("stat_cd", "statCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ldf_01", "ldf01");
		this.hashFields.put("ldf_03", "ldf03");
		this.hashFields.put("ldf_02", "ldf02");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ldf_05", "ldf05");
		this.hashFields.put("ldf_04", "ldf04");
		this.hashFields.put("protect_flg", "protectFlg");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		return this.hashFields;
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
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
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
	 * @return statCd
	 */
	public String getStatCd() {
		return this.statCd;
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
	 * @return ldf01
	 */
	public String getLdf01() {
		return this.ldf01;
	}
	
	/**
	 * Column Info
	 * @return ldf03
	 */
	public String getLdf03() {
		return this.ldf03;
	}
	
	/**
	 * Column Info
	 * @return ldf02
	 */
	public String getLdf02() {
		return this.ldf02;
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
	 * @return ldf05
	 */
	public String getLdf05() {
		return this.ldf05;
	}
	
	/**
	 * Column Info
	 * @return ldf04
	 */
	public String getLdf04() {
		return this.ldf04;
	}
	
	/**
	 * Column Info
	 * @return protectFlg
	 */
	public String getProtectFlg() {
		return this.protectFlg;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
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
	 * @param statCd
	 */
	public void setStatCd(String statCd) {
		this.statCd = statCd;
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
	 * @param ldf01
	 */
	public void setLdf01(String ldf01) {
		this.ldf01 = ldf01;
	}
	
	/**
	 * Column Info
	 * @param ldf03
	 */
	public void setLdf03(String ldf03) {
		this.ldf03 = ldf03;
	}
	
	/**
	 * Column Info
	 * @param ldf02
	 */
	public void setLdf02(String ldf02) {
		this.ldf02 = ldf02;
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
	 * @param ldf05
	 */
	public void setLdf05(String ldf05) {
		this.ldf05 = ldf05;
	}
	
	/**
	 * Column Info
	 * @param ldf04
	 */
	public void setLdf04(String ldf04) {
		this.ldf04 = ldf04;
	}
	
	/**
	 * Column Info
	 * @param protectFlg
	 */
	public void setProtectFlg(String protectFlg) {
		this.protectFlg = protectFlg;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setBseYr(JSPUtil.getParameter(request, "bse_yr", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setStatCd(JSPUtil.getParameter(request, "stat_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLdf01(JSPUtil.getParameter(request, "ldf_01", ""));
		setLdf03(JSPUtil.getParameter(request, "ldf_03", ""));
		setLdf02(JSPUtil.getParameter(request, "ldf_02", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLdf05(JSPUtil.getParameter(request, "ldf_05", ""));
		setLdf04(JSPUtil.getParameter(request, "ldf_04", ""));
		setProtectFlg(JSPUtil.getParameter(request, "protect_flg", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMaxLoadFactorListVO[]
	 */
	public SearchMaxLoadFactorListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMaxLoadFactorListVO[]
	 */
	public SearchMaxLoadFactorListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMaxLoadFactorListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] statCd = (JSPUtil.getParameter(request, prefix	+ "stat_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ldf01 = (JSPUtil.getParameter(request, prefix	+ "ldf_01", length));
			String[] ldf03 = (JSPUtil.getParameter(request, prefix	+ "ldf_03", length));
			String[] ldf02 = (JSPUtil.getParameter(request, prefix	+ "ldf_02", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ldf05 = (JSPUtil.getParameter(request, prefix	+ "ldf_05", length));
			String[] ldf04 = (JSPUtil.getParameter(request, prefix	+ "ldf_04", length));
			String[] protectFlg = (JSPUtil.getParameter(request, prefix	+ "protect_flg", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMaxLoadFactorListVO();
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (statCd[i] != null)
					model.setStatCd(statCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ldf01[i] != null)
					model.setLdf01(ldf01[i]);
				if (ldf03[i] != null)
					model.setLdf03(ldf03[i]);
				if (ldf02[i] != null)
					model.setLdf02(ldf02[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ldf05[i] != null)
					model.setLdf05(ldf05[i]);
				if (ldf04[i] != null)
					model.setLdf04(ldf04[i]);
				if (protectFlg[i] != null)
					model.setProtectFlg(protectFlg[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMaxLoadFactorListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMaxLoadFactorListVO[]
	 */
	public SearchMaxLoadFactorListVO[] getSearchMaxLoadFactorListVOs(){
		SearchMaxLoadFactorListVO[] vos = (SearchMaxLoadFactorListVO[])models.toArray(new SearchMaxLoadFactorListVO[models.size()]);
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
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.statCd = this.statCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldf01 = this.ldf01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldf03 = this.ldf03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldf02 = this.ldf02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldf05 = this.ldf05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldf04 = this.ldf04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.protectFlg = this.protectFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

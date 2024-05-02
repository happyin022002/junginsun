/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CoveredBlVO.java
*@FileTitle : CoveredBlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.10.21 이진서 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo;

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
 * @author 이진서
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CoveredBlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CoveredBlVO> models = new ArrayList<CoveredBlVO>();
	
	/* Column Info */
	private String coverBkgSts = null;
	/* Column Info */
	private String coverDelCd = null;
	/* Column Info */
	private String mstPorCd = null;
	/* Column Info */
	private String coverShipper = null;
	/* Column Info */
	private String mstVvd = null;
	/* Column Info */
	private String chgCd = null;
	/* Column Info */
	private String mstDelCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mstBkgSts = null;
	/* Column Info */
	private String coverPorCd = null;
	/* Column Info */
	private String coverVvd = null;
	/* Column Info */
	private String mstShipper = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CoveredBlVO() {}

	public CoveredBlVO(String ibflag, String pagerows, String coverDelCd, String mstBkgSts, String coverBkgSts, String mstPorCd, String coverShipper, String coverPorCd, String coverVvd, String mstVvd, String chgCd, String mstDelCd, String mstShipper) {
		this.coverBkgSts = coverBkgSts;
		this.coverDelCd = coverDelCd;
		this.mstPorCd = mstPorCd;
		this.coverShipper = coverShipper;
		this.mstVvd = mstVvd;
		this.chgCd = chgCd;
		this.mstDelCd = mstDelCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.mstBkgSts = mstBkgSts;
		this.coverPorCd = coverPorCd;
		this.coverVvd = coverVvd;
		this.mstShipper = mstShipper;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cover_bkg_sts", getCoverBkgSts());
		this.hashColumns.put("cover_del_cd", getCoverDelCd());
		this.hashColumns.put("mst_por_cd", getMstPorCd());
		this.hashColumns.put("cover_shipper", getCoverShipper());
		this.hashColumns.put("mst_vvd", getMstVvd());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("mst_del_cd", getMstDelCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mst_bkg_sts", getMstBkgSts());
		this.hashColumns.put("cover_por_cd", getCoverPorCd());
		this.hashColumns.put("cover_vvd", getCoverVvd());
		this.hashColumns.put("mst_shipper", getMstShipper());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cover_bkg_sts", "coverBkgSts");
		this.hashFields.put("cover_del_cd", "coverDelCd");
		this.hashFields.put("mst_por_cd", "mstPorCd");
		this.hashFields.put("cover_shipper", "coverShipper");
		this.hashFields.put("mst_vvd", "mstVvd");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("mst_del_cd", "mstDelCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mst_bkg_sts", "mstBkgSts");
		this.hashFields.put("cover_por_cd", "coverPorCd");
		this.hashFields.put("cover_vvd", "coverVvd");
		this.hashFields.put("mst_shipper", "mstShipper");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return coverBkgSts
	 */
	public String getCoverBkgSts() {
		return this.coverBkgSts;
	}
	
	/**
	 * Column Info
	 * @return coverDelCd
	 */
	public String getCoverDelCd() {
		return this.coverDelCd;
	}
	
	/**
	 * Column Info
	 * @return mstPorCd
	 */
	public String getMstPorCd() {
		return this.mstPorCd;
	}
	
	/**
	 * Column Info
	 * @return coverShipper
	 */
	public String getCoverShipper() {
		return this.coverShipper;
	}
	
	/**
	 * Column Info
	 * @return mstVvd
	 */
	public String getMstVvd() {
		return this.mstVvd;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
	}
	
	/**
	 * Column Info
	 * @return mstDelCd
	 */
	public String getMstDelCd() {
		return this.mstDelCd;
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
	 * @return mstBkgSts
	 */
	public String getMstBkgSts() {
		return this.mstBkgSts;
	}
	
	/**
	 * Column Info
	 * @return coverPorCd
	 */
	public String getCoverPorCd() {
		return this.coverPorCd;
	}
	
	/**
	 * Column Info
	 * @return coverVvd
	 */
	public String getCoverVvd() {
		return this.coverVvd;
	}
	
	/**
	 * Column Info
	 * @return mstShipper
	 */
	public String getMstShipper() {
		return this.mstShipper;
	}
	

	/**
	 * Column Info
	 * @param coverBkgSts
	 */
	public void setCoverBkgSts(String coverBkgSts) {
		this.coverBkgSts = coverBkgSts;
	}
	
	/**
	 * Column Info
	 * @param coverDelCd
	 */
	public void setCoverDelCd(String coverDelCd) {
		this.coverDelCd = coverDelCd;
	}
	
	/**
	 * Column Info
	 * @param mstPorCd
	 */
	public void setMstPorCd(String mstPorCd) {
		this.mstPorCd = mstPorCd;
	}
	
	/**
	 * Column Info
	 * @param coverShipper
	 */
	public void setCoverShipper(String coverShipper) {
		this.coverShipper = coverShipper;
	}
	
	/**
	 * Column Info
	 * @param mstVvd
	 */
	public void setMstVvd(String mstVvd) {
		this.mstVvd = mstVvd;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	
	/**
	 * Column Info
	 * @param mstDelCd
	 */
	public void setMstDelCd(String mstDelCd) {
		this.mstDelCd = mstDelCd;
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
	 * @param mstBkgSts
	 */
	public void setMstBkgSts(String mstBkgSts) {
		this.mstBkgSts = mstBkgSts;
	}
	
	/**
	 * Column Info
	 * @param coverPorCd
	 */
	public void setCoverPorCd(String coverPorCd) {
		this.coverPorCd = coverPorCd;
	}
	
	/**
	 * Column Info
	 * @param coverVvd
	 */
	public void setCoverVvd(String coverVvd) {
		this.coverVvd = coverVvd;
	}
	
	/**
	 * Column Info
	 * @param mstShipper
	 */
	public void setMstShipper(String mstShipper) {
		this.mstShipper = mstShipper;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCoverBkgSts(JSPUtil.getParameter(request, "cover_bkg_sts", ""));
		setCoverDelCd(JSPUtil.getParameter(request, "cover_del_cd", ""));
		setMstPorCd(JSPUtil.getParameter(request, "mst_por_cd", ""));
		setCoverShipper(JSPUtil.getParameter(request, "cover_shipper", ""));
		setMstVvd(JSPUtil.getParameter(request, "mst_vvd", ""));
		setChgCd(JSPUtil.getParameter(request, "chg_cd", ""));
		setMstDelCd(JSPUtil.getParameter(request, "mst_del_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMstBkgSts(JSPUtil.getParameter(request, "mst_bkg_sts", ""));
		setCoverPorCd(JSPUtil.getParameter(request, "cover_por_cd", ""));
		setCoverVvd(JSPUtil.getParameter(request, "cover_vvd", ""));
		setMstShipper(JSPUtil.getParameter(request, "mst_shipper", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CoveredBlVO[]
	 */
	public CoveredBlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CoveredBlVO[]
	 */
	public CoveredBlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CoveredBlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] coverBkgSts = (JSPUtil.getParameter(request, prefix	+ "cover_bkg_sts", length));
			String[] coverDelCd = (JSPUtil.getParameter(request, prefix	+ "cover_del_cd", length));
			String[] mstPorCd = (JSPUtil.getParameter(request, prefix	+ "mst_por_cd", length));
			String[] coverShipper = (JSPUtil.getParameter(request, prefix	+ "cover_shipper", length));
			String[] mstVvd = (JSPUtil.getParameter(request, prefix	+ "mst_vvd", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] mstDelCd = (JSPUtil.getParameter(request, prefix	+ "mst_del_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mstBkgSts = (JSPUtil.getParameter(request, prefix	+ "mst_bkg_sts", length));
			String[] coverPorCd = (JSPUtil.getParameter(request, prefix	+ "cover_por_cd", length));
			String[] coverVvd = (JSPUtil.getParameter(request, prefix	+ "cover_vvd", length));
			String[] mstShipper = (JSPUtil.getParameter(request, prefix	+ "mst_shipper", length));
			
			for (int i = 0; i < length; i++) {
				model = new CoveredBlVO();
				if (coverBkgSts[i] != null)
					model.setCoverBkgSts(coverBkgSts[i]);
				if (coverDelCd[i] != null)
					model.setCoverDelCd(coverDelCd[i]);
				if (mstPorCd[i] != null)
					model.setMstPorCd(mstPorCd[i]);
				if (coverShipper[i] != null)
					model.setCoverShipper(coverShipper[i]);
				if (mstVvd[i] != null)
					model.setMstVvd(mstVvd[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (mstDelCd[i] != null)
					model.setMstDelCd(mstDelCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mstBkgSts[i] != null)
					model.setMstBkgSts(mstBkgSts[i]);
				if (coverPorCd[i] != null)
					model.setCoverPorCd(coverPorCd[i]);
				if (coverVvd[i] != null)
					model.setCoverVvd(coverVvd[i]);
				if (mstShipper[i] != null)
					model.setMstShipper(mstShipper[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCoveredBlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CoveredBlVO[]
	 */
	public CoveredBlVO[] getCoveredBlVOs(){
		CoveredBlVO[] vos = (CoveredBlVO[])models.toArray(new CoveredBlVO[models.size()]);
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
		this.coverBkgSts = this.coverBkgSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coverDelCd = this.coverDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstPorCd = this.mstPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coverShipper = this.coverShipper .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstVvd = this.mstVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstDelCd = this.mstDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstBkgSts = this.mstBkgSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coverPorCd = this.coverPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coverVvd = this.coverVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstShipper = this.mstShipper .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

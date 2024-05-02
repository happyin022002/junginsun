/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RocsSearchCRNVO.java
*@FileTitle : RocsSearchCRNVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.06.03 임재택 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CrnVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 임재택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RocsSearchCRNVO extends CrnVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<RocsSearchCRNVO> models = new ArrayList<RocsSearchCRNVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String crnNumber = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdEtaDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vvdNumber = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String vvdNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RocsSearchCRNVO() {}

	public RocsSearchCRNVO(String ibflag, String pagerows, String crnNumber, String vslCd, String skdVoyNo, String skdDirCd, String vvdEtaDt, String vvdNm, String vvdNumber) {
		this.vslCd = vslCd;
		this.crnNumber = crnNumber;
		this.ibflag = ibflag;
		this.vvdEtaDt = vvdEtaDt;
		this.skdVoyNo = skdVoyNo;
		this.vvdNumber = vvdNumber;
		this.skdDirCd = skdDirCd;
		this.vvdNm = vvdNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("crn_number", getCrnNumber());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_eta_dt", getVvdEtaDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vvd_number", getVvdNumber());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("vvd_nm", getVvdNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("crn_number", "crnNumber");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_eta_dt", "vvdEtaDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vvd_number", "vvdNumber");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("vvd_nm", "vvdNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return crnNumber
	 */
	public String getCrnNumber() {
		return this.crnNumber;
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
	 * @return vvdEtaDt
	 */
	public String getVvdEtaDt() {
		return this.vvdEtaDt;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return vvdNumber
	 */
	public String getVvdNumber() {
		return this.vvdNumber;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return vvdNm
	 */
	public String getVvdNm() {
		return this.vvdNm;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param crnNumber
	 */
	public void setCrnNumber(String crnNumber) {
		this.crnNumber = crnNumber;
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
	 * @param vvdEtaDt
	 */
	public void setVvdEtaDt(String vvdEtaDt) {
		this.vvdEtaDt = vvdEtaDt;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param vvdNumber
	 */
	public void setVvdNumber(String vvdNumber) {
		this.vvdNumber = vvdNumber;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param vvdNm
	 */
	public void setVvdNm(String vvdNm) {
		this.vvdNm = vvdNm;
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
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setCrnNumber(JSPUtil.getParameter(request, "crn_number", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVvdEtaDt(JSPUtil.getParameter(request, "vvd_eta_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setVvdNumber(JSPUtil.getParameter(request, "vvd_number", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setVvdNm(JSPUtil.getParameter(request, "vvd_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RocsSearchCRNVO[]
	 */
	public RocsSearchCRNVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RocsSearchCRNVO[]
	 */
	public RocsSearchCRNVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RocsSearchCRNVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] crnNumber = (JSPUtil.getParameter(request, prefix	+ "crn_number".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] vvdEtaDt = (JSPUtil.getParameter(request, prefix	+ "vvd_eta_dt".trim(), length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no".trim(), length));
			String[] vvdNumber = (JSPUtil.getParameter(request, prefix	+ "vvd_number".trim(), length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd".trim(), length));
			String[] vvdNm = (JSPUtil.getParameter(request, prefix	+ "vvd_nm".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new RocsSearchCRNVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (crnNumber[i] != null)
					model.setCrnNumber(crnNumber[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdEtaDt[i] != null)
					model.setVvdEtaDt(vvdEtaDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vvdNumber[i] != null)
					model.setVvdNumber(vvdNumber[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (vvdNm[i] != null)
					model.setVvdNm(vvdNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRocsSearchCRNVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RocsSearchCRNVO[]
	 */
	public RocsSearchCRNVO[] getRocsSearchCRNVOs(){
		RocsSearchCRNVO[] vos = (RocsSearchCRNVO[])models.toArray(new RocsSearchCRNVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crnNumber = this.crnNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdEtaDt = this.vvdEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdNumber = this.vvdNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdNm = this.vvdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

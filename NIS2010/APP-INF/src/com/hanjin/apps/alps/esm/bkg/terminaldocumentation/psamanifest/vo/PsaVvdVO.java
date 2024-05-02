/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PsaVvdVO.java
*@FileTitle : PsaVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.09.07 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PsaVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PsaVvdVO> models = new ArrayList<PsaVvdVO>();
	
	/* Column Info */
	private String psaVoyDirCd = null;
	/* Column Info */
	private String vslCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String etbDt2 = null;
	/* Column Info */
	private String etbDt1 = null;
	/* Column Info */
	private String psaVslNm = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PsaVvdVO() {}

	public PsaVvdVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String psaVslNm, String psaVoyDirCd, String userId, String vslNm, String portCd, String etbDt1, String etbDt2) {
		this.psaVoyDirCd = psaVoyDirCd;
		this.vslCd = vslCd;
		this.ibflag = ibflag;
		this.etbDt2 = etbDt2;
		this.etbDt1 = etbDt1;
		this.psaVslNm = psaVslNm;
		this.userId = userId;
		this.skdVoyNo = skdVoyNo;
		this.vslNm = vslNm;
		this.portCd = portCd;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("psa_voy_dir_cd", getPsaVoyDirCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("etb_dt2", getEtbDt2());
		this.hashColumns.put("etb_dt1", getEtbDt1());
		this.hashColumns.put("psa_vsl_nm", getPsaVslNm());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("psa_voy_dir_cd", "psaVoyDirCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("etb_dt2", "etbDt2");
		this.hashFields.put("etb_dt1", "etbDt1");
		this.hashFields.put("psa_vsl_nm", "psaVslNm");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return psaVoyDirCd
	 */
	public String getPsaVoyDirCd() {
		return this.psaVoyDirCd;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return etbDt2
	 */
	public String getEtbDt2() {
		return this.etbDt2;
	}
	
	/**
	 * Column Info
	 * @return etbDt1
	 */
	public String getEtbDt1() {
		return this.etbDt1;
	}
	
	/**
	 * Column Info
	 * @return psaVslNm
	 */
	public String getPsaVslNm() {
		return this.psaVslNm;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
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
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @param psaVoyDirCd
	 */
	public void setPsaVoyDirCd(String psaVoyDirCd) {
		this.psaVoyDirCd = psaVoyDirCd;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param etbDt2
	 */
	public void setEtbDt2(String etbDt2) {
		this.etbDt2 = etbDt2;
	}
	
	/**
	 * Column Info
	 * @param etbDt1
	 */
	public void setEtbDt1(String etbDt1) {
		this.etbDt1 = etbDt1;
	}
	
	/**
	 * Column Info
	 * @param psaVslNm
	 */
	public void setPsaVslNm(String psaVslNm) {
		this.psaVslNm = psaVslNm;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
		setPsaVoyDirCd(JSPUtil.getParameter(request, "psa_voy_dir_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEtbDt2(JSPUtil.getParameter(request, "etb_dt2", ""));
		setEtbDt1(JSPUtil.getParameter(request, "etb_dt1", ""));
		setPsaVslNm(JSPUtil.getParameter(request, "psa_vsl_nm", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setVslNm(JSPUtil.getParameter(request, "vsl_nm", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsaVvdVO[]
	 */
	public PsaVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PsaVvdVO[]
	 */
	public PsaVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PsaVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] psaVoyDirCd = (JSPUtil.getParameter(request, prefix	+ "psa_voy_dir_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] etbDt2 = (JSPUtil.getParameter(request, prefix	+ "etb_dt2", length));
			String[] etbDt1 = (JSPUtil.getParameter(request, prefix	+ "etb_dt1", length));
			String[] psaVslNm = (JSPUtil.getParameter(request, prefix	+ "psa_vsl_nm", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PsaVvdVO();
				if (psaVoyDirCd[i] != null)
					model.setPsaVoyDirCd(psaVoyDirCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (etbDt2[i] != null)
					model.setEtbDt2(etbDt2[i]);
				if (etbDt1[i] != null)
					model.setEtbDt1(etbDt1[i]);
				if (psaVslNm[i] != null)
					model.setPsaVslNm(psaVslNm[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPsaVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PsaVvdVO[]
	 */
	public PsaVvdVO[] getPsaVvdVOs(){
		PsaVvdVO[] vos = (PsaVvdVO[])models.toArray(new PsaVvdVO[models.size()]);
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
		this.psaVoyDirCd = this.psaVoyDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbDt2 = this.etbDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbDt1 = this.etbDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaVslNm = this.psaVslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

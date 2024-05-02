/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHSUtilizationINVO.java
*@FileTitle : CHSUtilizationINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.08.13 조재성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo;

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
 * @author 조재성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSUtilizationINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSUtilizationINVO> models = new ArrayList<CHSUtilizationINVO>();
	
	/* Column Info */
	private String chss45ftVolQty = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String chss20ftVolQty = null;
	/* Column Info */
	private String inqToDys = null;
	/* Column Info */
	private String chss40ftVolQty = null;
	/* Column Info */
	private String inqFmDys = null;
	/* Column Info */
	private String crntLocCd = null;
	/* Column Info */
	private String cntrPsnStsCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSUtilizationINVO() {}

	public CHSUtilizationINVO(String ibflag, String pagerows, String crntLocCd, String sccCd, String inqFmDys, String inqToDys, String cntrPsnStsCd, String cnmvStsCd, String chss20ftVolQty, String chss40ftVolQty, String chss45ftVolQty) {
		this.chss45ftVolQty = chss45ftVolQty;
		this.cnmvStsCd = cnmvStsCd;
		this.ibflag = ibflag;
		this.sccCd = sccCd;
		this.chss20ftVolQty = chss20ftVolQty;
		this.inqToDys = inqToDys;
		this.chss40ftVolQty = chss40ftVolQty;
		this.inqFmDys = inqFmDys;
		this.crntLocCd = crntLocCd;
		this.cntrPsnStsCd = cntrPsnStsCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chss_45ft_vol_qty", getChss45ftVolQty());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("chss_20ft_vol_qty", getChss20ftVolQty());
		this.hashColumns.put("inq_to_dys", getInqToDys());
		this.hashColumns.put("chss_40ft_vol_qty", getChss40ftVolQty());
		this.hashColumns.put("inq_fm_dys", getInqFmDys());
		this.hashColumns.put("crnt_loc_cd", getCrntLocCd());
		this.hashColumns.put("cntr_psn_sts_cd", getCntrPsnStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("chss_45ft_vol_qty", "chss45ftVolQty");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("chss_20ft_vol_qty", "chss20ftVolQty");
		this.hashFields.put("inq_to_dys", "inqToDys");
		this.hashFields.put("chss_40ft_vol_qty", "chss40ftVolQty");
		this.hashFields.put("inq_fm_dys", "inqFmDys");
		this.hashFields.put("crnt_loc_cd", "crntLocCd");
		this.hashFields.put("cntr_psn_sts_cd", "cntrPsnStsCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return chss45ftVolQty
	 */
	public String getChss45ftVolQty() {
		return this.chss45ftVolQty;
	}
	
	/**
	 * Column Info
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
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
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
	}
	
	/**
	 * Column Info
	 * @return chss20ftVolQty
	 */
	public String getChss20ftVolQty() {
		return this.chss20ftVolQty;
	}
	
	/**
	 * Column Info
	 * @return inqToDys
	 */
	public String getInqToDys() {
		return this.inqToDys;
	}
	
	/**
	 * Column Info
	 * @return chss40ftVolQty
	 */
	public String getChss40ftVolQty() {
		return this.chss40ftVolQty;
	}
	
	/**
	 * Column Info
	 * @return inqFmDys
	 */
	public String getInqFmDys() {
		return this.inqFmDys;
	}
	
	/**
	 * Column Info
	 * @return crntLocCd
	 */
	public String getCrntLocCd() {
		return this.crntLocCd;
	}
	
	/**
	 * Column Info
	 * @return cntrPsnStsCd
	 */
	public String getCntrPsnStsCd() {
		return this.cntrPsnStsCd;
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
	 * @param chss45ftVolQty
	 */
	public void setChss45ftVolQty(String chss45ftVolQty) {
		this.chss45ftVolQty = chss45ftVolQty;
	}
	
	/**
	 * Column Info
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
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
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}
	
	/**
	 * Column Info
	 * @param chss20ftVolQty
	 */
	public void setChss20ftVolQty(String chss20ftVolQty) {
		this.chss20ftVolQty = chss20ftVolQty;
	}
	
	/**
	 * Column Info
	 * @param inqToDys
	 */
	public void setInqToDys(String inqToDys) {
		this.inqToDys = inqToDys;
	}
	
	/**
	 * Column Info
	 * @param chss40ftVolQty
	 */
	public void setChss40ftVolQty(String chss40ftVolQty) {
		this.chss40ftVolQty = chss40ftVolQty;
	}
	
	/**
	 * Column Info
	 * @param inqFmDys
	 */
	public void setInqFmDys(String inqFmDys) {
		this.inqFmDys = inqFmDys;
	}
	
	/**
	 * Column Info
	 * @param crntLocCd
	 */
	public void setCrntLocCd(String crntLocCd) {
		this.crntLocCd = crntLocCd;
	}
	
	/**
	 * Column Info
	 * @param cntrPsnStsCd
	 */
	public void setCntrPsnStsCd(String cntrPsnStsCd) {
		this.cntrPsnStsCd = cntrPsnStsCd;
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
		setChss45ftVolQty(JSPUtil.getParameter(request, "chss_45ft_vol_qty", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, "cnmv_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSccCd(JSPUtil.getParameter(request, "scc_cd", ""));
		setChss20ftVolQty(JSPUtil.getParameter(request, "chss_20ft_vol_qty", ""));
		setInqToDys(JSPUtil.getParameter(request, "inq_to_dys", ""));
		setChss40ftVolQty(JSPUtil.getParameter(request, "chss_40ft_vol_qty", ""));
		setInqFmDys(JSPUtil.getParameter(request, "inq_fm_dys", ""));
		setCrntLocCd(JSPUtil.getParameter(request, "crnt_loc_cd", ""));
		setCntrPsnStsCd(JSPUtil.getParameter(request, "cntr_psn_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSUtilizationINVO[]
	 */
	public CHSUtilizationINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSUtilizationINVO[]
	 */
	public CHSUtilizationINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSUtilizationINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] chss45ftVolQty = (JSPUtil.getParameter(request, prefix	+ "chss_45ft_vol_qty", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] chss20ftVolQty = (JSPUtil.getParameter(request, prefix	+ "chss_20ft_vol_qty", length));
			String[] inqToDys = (JSPUtil.getParameter(request, prefix	+ "inq_to_dys", length));
			String[] chss40ftVolQty = (JSPUtil.getParameter(request, prefix	+ "chss_40ft_vol_qty", length));
			String[] inqFmDys = (JSPUtil.getParameter(request, prefix	+ "inq_fm_dys", length));
			String[] crntLocCd = (JSPUtil.getParameter(request, prefix	+ "crnt_loc_cd", length));
			String[] cntrPsnStsCd = (JSPUtil.getParameter(request, prefix	+ "cntr_psn_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSUtilizationINVO();
				if (chss45ftVolQty[i] != null)
					model.setChss45ftVolQty(chss45ftVolQty[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (chss20ftVolQty[i] != null)
					model.setChss20ftVolQty(chss20ftVolQty[i]);
				if (inqToDys[i] != null)
					model.setInqToDys(inqToDys[i]);
				if (chss40ftVolQty[i] != null)
					model.setChss40ftVolQty(chss40ftVolQty[i]);
				if (inqFmDys[i] != null)
					model.setInqFmDys(inqFmDys[i]);
				if (crntLocCd[i] != null)
					model.setCrntLocCd(crntLocCd[i]);
				if (cntrPsnStsCd[i] != null)
					model.setCntrPsnStsCd(cntrPsnStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSUtilizationINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSUtilizationINVO[]
	 */
	public CHSUtilizationINVO[] getCHSUtilizationINVOs(){
		CHSUtilizationINVO[] vos = (CHSUtilizationINVO[])models.toArray(new CHSUtilizationINVO[models.size()]);
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
		this.chss45ftVolQty = this.chss45ftVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chss20ftVolQty = this.chss20ftVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inqToDys = this.inqToDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chss40ftVolQty = this.chss40ftVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inqFmDys = this.inqFmDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntLocCd = this.crntLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPsnStsCd = this.cntrPsnStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

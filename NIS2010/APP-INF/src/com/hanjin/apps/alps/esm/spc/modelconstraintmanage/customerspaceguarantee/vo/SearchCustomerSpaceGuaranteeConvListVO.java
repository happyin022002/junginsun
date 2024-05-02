/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCustomerSpaceGuaranteeConvListVO.java
*@FileTitle : SearchCustomerSpaceGuaranteeConvListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.09.09 이현주 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.customerspaceguarantee.vo;

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

public class SearchCustomerSpaceGuaranteeConvListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCustomerSpaceGuaranteeConvListVO> models = new ArrayList<SearchCustomerSpaceGuaranteeConvListVO>();
	
	/* Column Info */
	private String teu40ftConvRto = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ovrTeu20ftConvRto = null;
	/* Column Info */
	private String teu20ftConvRto = null;
	/* Column Info */
	private String ovrTeu40ftHcConvRto = null;
	/* Column Info */
	private String ovrTeu45ftHcConvRto = null;
	/* Column Info */
	private String teu45ftHcConvRto = null;
	/* Column Info */
	private String ovrTeu40ftConvRto = null;
	/* Column Info */
	private String teu40ftHcConvRto = null;
	/* Column Info */
	private String vslOwnIndCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCustomerSpaceGuaranteeConvListVO() {}

	public SearchCustomerSpaceGuaranteeConvListVO(String ibflag, String pagerows, String vslOwnIndCd, String teu20ftConvRto, String teu40ftConvRto, String teu40ftHcConvRto, String teu45ftHcConvRto, String ovrTeu20ftConvRto, String ovrTeu40ftConvRto, String ovrTeu40ftHcConvRto, String ovrTeu45ftHcConvRto) {
		this.teu40ftConvRto = teu40ftConvRto;
		this.ibflag = ibflag;
		this.ovrTeu20ftConvRto = ovrTeu20ftConvRto;
		this.teu20ftConvRto = teu20ftConvRto;
		this.ovrTeu40ftHcConvRto = ovrTeu40ftHcConvRto;
		this.ovrTeu45ftHcConvRto = ovrTeu45ftHcConvRto;
		this.teu45ftHcConvRto = teu45ftHcConvRto;
		this.ovrTeu40ftConvRto = ovrTeu40ftConvRto;
		this.teu40ftHcConvRto = teu40ftHcConvRto;
		this.vslOwnIndCd = vslOwnIndCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("teu_40ft_conv_rto", getTeu40ftConvRto());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ovr_teu_20ft_conv_rto", getOvrTeu20ftConvRto());
		this.hashColumns.put("teu_20ft_conv_rto", getTeu20ftConvRto());
		this.hashColumns.put("ovr_teu_40ft_hc_conv_rto", getOvrTeu40ftHcConvRto());
		this.hashColumns.put("ovr_teu_45ft_hc_conv_rto", getOvrTeu45ftHcConvRto());
		this.hashColumns.put("teu_45ft_hc_conv_rto", getTeu45ftHcConvRto());
		this.hashColumns.put("ovr_teu_40ft_conv_rto", getOvrTeu40ftConvRto());
		this.hashColumns.put("teu_40ft_hc_conv_rto", getTeu40ftHcConvRto());
		this.hashColumns.put("vsl_own_ind_cd", getVslOwnIndCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("teu_40ft_conv_rto", "teu40ftConvRto");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ovr_teu_20ft_conv_rto", "ovrTeu20ftConvRto");
		this.hashFields.put("teu_20ft_conv_rto", "teu20ftConvRto");
		this.hashFields.put("ovr_teu_40ft_hc_conv_rto", "ovrTeu40ftHcConvRto");
		this.hashFields.put("ovr_teu_45ft_hc_conv_rto", "ovrTeu45ftHcConvRto");
		this.hashFields.put("teu_45ft_hc_conv_rto", "teu45ftHcConvRto");
		this.hashFields.put("ovr_teu_40ft_conv_rto", "ovrTeu40ftConvRto");
		this.hashFields.put("teu_40ft_hc_conv_rto", "teu40ftHcConvRto");
		this.hashFields.put("vsl_own_ind_cd", "vslOwnIndCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return teu40ftConvRto
	 */
	public String getTeu40ftConvRto() {
		return this.teu40ftConvRto;
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
	 * @return ovrTeu20ftConvRto
	 */
	public String getOvrTeu20ftConvRto() {
		return this.ovrTeu20ftConvRto;
	}
	
	/**
	 * Column Info
	 * @return teu20ftConvRto
	 */
	public String getTeu20ftConvRto() {
		return this.teu20ftConvRto;
	}
	
	/**
	 * Column Info
	 * @return ovrTeu40ftHcConvRto
	 */
	public String getOvrTeu40ftHcConvRto() {
		return this.ovrTeu40ftHcConvRto;
	}
	
	/**
	 * Column Info
	 * @return ovrTeu45ftHcConvRto
	 */
	public String getOvrTeu45ftHcConvRto() {
		return this.ovrTeu45ftHcConvRto;
	}
	
	/**
	 * Column Info
	 * @return teu45ftHcConvRto
	 */
	public String getTeu45ftHcConvRto() {
		return this.teu45ftHcConvRto;
	}
	
	/**
	 * Column Info
	 * @return ovrTeu40ftConvRto
	 */
	public String getOvrTeu40ftConvRto() {
		return this.ovrTeu40ftConvRto;
	}
	
	/**
	 * Column Info
	 * @return teu40ftHcConvRto
	 */
	public String getTeu40ftHcConvRto() {
		return this.teu40ftHcConvRto;
	}
	
	/**
	 * Column Info
	 * @return vslOwnIndCd
	 */
	public String getVslOwnIndCd() {
		return this.vslOwnIndCd;
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
	 * @param teu40ftConvRto
	 */
	public void setTeu40ftConvRto(String teu40ftConvRto) {
		this.teu40ftConvRto = teu40ftConvRto;
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
	 * @param ovrTeu20ftConvRto
	 */
	public void setOvrTeu20ftConvRto(String ovrTeu20ftConvRto) {
		this.ovrTeu20ftConvRto = ovrTeu20ftConvRto;
	}
	
	/**
	 * Column Info
	 * @param teu20ftConvRto
	 */
	public void setTeu20ftConvRto(String teu20ftConvRto) {
		this.teu20ftConvRto = teu20ftConvRto;
	}
	
	/**
	 * Column Info
	 * @param ovrTeu40ftHcConvRto
	 */
	public void setOvrTeu40ftHcConvRto(String ovrTeu40ftHcConvRto) {
		this.ovrTeu40ftHcConvRto = ovrTeu40ftHcConvRto;
	}
	
	/**
	 * Column Info
	 * @param ovrTeu45ftHcConvRto
	 */
	public void setOvrTeu45ftHcConvRto(String ovrTeu45ftHcConvRto) {
		this.ovrTeu45ftHcConvRto = ovrTeu45ftHcConvRto;
	}
	
	/**
	 * Column Info
	 * @param teu45ftHcConvRto
	 */
	public void setTeu45ftHcConvRto(String teu45ftHcConvRto) {
		this.teu45ftHcConvRto = teu45ftHcConvRto;
	}
	
	/**
	 * Column Info
	 * @param ovrTeu40ftConvRto
	 */
	public void setOvrTeu40ftConvRto(String ovrTeu40ftConvRto) {
		this.ovrTeu40ftConvRto = ovrTeu40ftConvRto;
	}
	
	/**
	 * Column Info
	 * @param teu40ftHcConvRto
	 */
	public void setTeu40ftHcConvRto(String teu40ftHcConvRto) {
		this.teu40ftHcConvRto = teu40ftHcConvRto;
	}
	
	/**
	 * Column Info
	 * @param vslOwnIndCd
	 */
	public void setVslOwnIndCd(String vslOwnIndCd) {
		this.vslOwnIndCd = vslOwnIndCd;
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
		setTeu40ftConvRto(JSPUtil.getParameter(request, "teu_40ft_conv_rto", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOvrTeu20ftConvRto(JSPUtil.getParameter(request, "ovr_teu_20ft_conv_rto", ""));
		setTeu20ftConvRto(JSPUtil.getParameter(request, "teu_20ft_conv_rto", ""));
		setOvrTeu40ftHcConvRto(JSPUtil.getParameter(request, "ovr_teu_40ft_hc_conv_rto", ""));
		setOvrTeu45ftHcConvRto(JSPUtil.getParameter(request, "ovr_teu_45ft_hc_conv_rto", ""));
		setTeu45ftHcConvRto(JSPUtil.getParameter(request, "teu_45ft_hc_conv_rto", ""));
		setOvrTeu40ftConvRto(JSPUtil.getParameter(request, "ovr_teu_40ft_conv_rto", ""));
		setTeu40ftHcConvRto(JSPUtil.getParameter(request, "teu_40ft_hc_conv_rto", ""));
		setVslOwnIndCd(JSPUtil.getParameter(request, "vsl_own_ind_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCustomerSpaceGuaranteeConvListVO[]
	 */
	public SearchCustomerSpaceGuaranteeConvListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCustomerSpaceGuaranteeConvListVO[]
	 */
	public SearchCustomerSpaceGuaranteeConvListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCustomerSpaceGuaranteeConvListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] teu40ftConvRto = (JSPUtil.getParameter(request, prefix	+ "teu_40ft_conv_rto", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ovrTeu20ftConvRto = (JSPUtil.getParameter(request, prefix	+ "ovr_teu_20ft_conv_rto", length));
			String[] teu20ftConvRto = (JSPUtil.getParameter(request, prefix	+ "teu_20ft_conv_rto", length));
			String[] ovrTeu40ftHcConvRto = (JSPUtil.getParameter(request, prefix	+ "ovr_teu_40ft_hc_conv_rto", length));
			String[] ovrTeu45ftHcConvRto = (JSPUtil.getParameter(request, prefix	+ "ovr_teu_45ft_hc_conv_rto", length));
			String[] teu45ftHcConvRto = (JSPUtil.getParameter(request, prefix	+ "teu_45ft_hc_conv_rto", length));
			String[] ovrTeu40ftConvRto = (JSPUtil.getParameter(request, prefix	+ "ovr_teu_40ft_conv_rto", length));
			String[] teu40ftHcConvRto = (JSPUtil.getParameter(request, prefix	+ "teu_40ft_hc_conv_rto", length));
			String[] vslOwnIndCd = (JSPUtil.getParameter(request, prefix	+ "vsl_own_ind_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCustomerSpaceGuaranteeConvListVO();
				if (teu40ftConvRto[i] != null)
					model.setTeu40ftConvRto(teu40ftConvRto[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ovrTeu20ftConvRto[i] != null)
					model.setOvrTeu20ftConvRto(ovrTeu20ftConvRto[i]);
				if (teu20ftConvRto[i] != null)
					model.setTeu20ftConvRto(teu20ftConvRto[i]);
				if (ovrTeu40ftHcConvRto[i] != null)
					model.setOvrTeu40ftHcConvRto(ovrTeu40ftHcConvRto[i]);
				if (ovrTeu45ftHcConvRto[i] != null)
					model.setOvrTeu45ftHcConvRto(ovrTeu45ftHcConvRto[i]);
				if (teu45ftHcConvRto[i] != null)
					model.setTeu45ftHcConvRto(teu45ftHcConvRto[i]);
				if (ovrTeu40ftConvRto[i] != null)
					model.setOvrTeu40ftConvRto(ovrTeu40ftConvRto[i]);
				if (teu40ftHcConvRto[i] != null)
					model.setTeu40ftHcConvRto(teu40ftHcConvRto[i]);
				if (vslOwnIndCd[i] != null)
					model.setVslOwnIndCd(vslOwnIndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCustomerSpaceGuaranteeConvListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCustomerSpaceGuaranteeConvListVO[]
	 */
	public SearchCustomerSpaceGuaranteeConvListVO[] getSearchCustomerSpaceGuaranteeConvListVOs(){
		SearchCustomerSpaceGuaranteeConvListVO[] vos = (SearchCustomerSpaceGuaranteeConvListVO[])models.toArray(new SearchCustomerSpaceGuaranteeConvListVO[models.size()]);
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
		this.teu40ftConvRto = this.teu40ftConvRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrTeu20ftConvRto = this.ovrTeu20ftConvRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu20ftConvRto = this.teu20ftConvRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrTeu40ftHcConvRto = this.ovrTeu40ftHcConvRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrTeu45ftHcConvRto = this.ovrTeu45ftHcConvRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu45ftHcConvRto = this.teu45ftHcConvRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrTeu40ftConvRto = this.ovrTeu40ftConvRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu40ftHcConvRto = this.teu40ftHcConvRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOwnIndCd = this.vslOwnIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

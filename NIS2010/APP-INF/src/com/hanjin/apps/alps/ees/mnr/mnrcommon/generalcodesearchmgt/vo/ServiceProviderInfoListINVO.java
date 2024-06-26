/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ServiceProviderInfoListINVO.java
*@FileTitle : ServiceProviderInfoListINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 정영훈
*@LastVersion : 1.0
* 2009.06.16 정영훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo;

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
 * @author 정영훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ServiceProviderInfoListINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ServiceProviderInfoListINVO> models = new ArrayList<ServiceProviderInfoListINVO>();
	
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String costcontrolofc = null;
	/* Column Info */
	private String picEngNm = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	 /**
	 * ServiceProviderInfoListINVO을 생성함
	 */
	public ServiceProviderInfoListINVO() {}

     /**
     * ServiceProviderInfoListINVO을 생성함
     */
	public ServiceProviderInfoListINVO(String ibflag, String pagerows, String costcontrolofc, String vndrSeq, String picEngNm) {
		this.picEngNm = picEngNm;
		this.ibflag = ibflag;
		this.vndrSeq = vndrSeq;
		this.costcontrolofc = costcontrolofc;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pic_eng_nm", getPicEngNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("costcontrolofc", getCostcontrolofc());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pic_eng_nm", "picEngNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("costcontrolofc", "costcontrolofc");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return picEngNm
	 */
	public String getPicEngNm() {
		return this.picEngNm;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return costcontrolofc
	 */
	public String getCostcontrolofc() {
		return this.costcontrolofc;
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
	 * @param picEngNm
	 */
	public void setPicEngNm(String picEngNm) {
		this.picEngNm = picEngNm;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param costcontrolofc
	 */
	public void setCostcontrolofc(String costcontrolofc) {
		this.costcontrolofc = costcontrolofc;
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
		setPicEngNm(JSPUtil.getParameter(request, "pic_eng_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setCostcontrolofc(JSPUtil.getParameter(request, "costcontrolofc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ServiceProviderInfoListINVO[]
	 */
	public ServiceProviderInfoListINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ServiceProviderInfoListINVO[]
	 */
	public ServiceProviderInfoListINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ServiceProviderInfoListINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] picEngNm = (JSPUtil.getParameter(request, prefix	+ "pic_eng_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] costcontrolofc = (JSPUtil.getParameter(request, prefix	+ "costcontrolofc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ServiceProviderInfoListINVO();
				if (picEngNm[i] != null)
					model.setPicEngNm(picEngNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (costcontrolofc[i] != null)
					model.setCostcontrolofc(costcontrolofc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getServiceProviderInfoListINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ServiceProviderInfoListINVO[]
	 */
	public ServiceProviderInfoListINVO[] getServiceProviderInfoListINVOs(){
		ServiceProviderInfoListINVO[] vos = (ServiceProviderInfoListINVO[])models.toArray(new ServiceProviderInfoListINVO[models.size()]);
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
		this.picEngNm = this.picEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costcontrolofc = this.costcontrolofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

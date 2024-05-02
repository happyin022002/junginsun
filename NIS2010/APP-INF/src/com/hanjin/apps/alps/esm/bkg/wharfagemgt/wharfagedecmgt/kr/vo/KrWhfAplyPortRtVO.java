/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWhfAplyPortRtVO.java
*@FileTitle : KrWhfAplyPortRtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.09.07 정재엽 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo;

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
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KrWhfAplyPortRtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KrWhfAplyPortRtVO> models = new ArrayList<KrWhfAplyPortRtVO>();
	
	/* Column Info */
	private String krWhfCntr45ftRt = null;
	/* Column Info */
	private String krWhfCntr40ftRt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String krWhfBlkRt = null;
	/* Column Info */
	private String krWhfCntr20ftRt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KrWhfAplyPortRtVO() {}

	public KrWhfAplyPortRtVO(String ibflag, String pagerows, String krWhfCntr20ftRt, String krWhfCntr40ftRt, String krWhfCntr45ftRt, String krWhfBlkRt) {
		this.krWhfCntr45ftRt = krWhfCntr45ftRt;
		this.krWhfCntr40ftRt = krWhfCntr40ftRt;
		this.ibflag = ibflag;
		this.krWhfBlkRt = krWhfBlkRt;
		this.krWhfCntr20ftRt = krWhfCntr20ftRt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("kr_whf_cntr_45ft_rt", getKrWhfCntr45ftRt());
		this.hashColumns.put("kr_whf_cntr_40ft_rt", getKrWhfCntr40ftRt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("kr_whf_blk_rt", getKrWhfBlkRt());
		this.hashColumns.put("kr_whf_cntr_20ft_rt", getKrWhfCntr20ftRt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("kr_whf_cntr_45ft_rt", "krWhfCntr45ftRt");
		this.hashFields.put("kr_whf_cntr_40ft_rt", "krWhfCntr40ftRt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("kr_whf_blk_rt", "krWhfBlkRt");
		this.hashFields.put("kr_whf_cntr_20ft_rt", "krWhfCntr20ftRt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return krWhfCntr45ftRt
	 */
	public String getKrWhfCntr45ftRt() {
		return this.krWhfCntr45ftRt;
	}
	
	/**
	 * Column Info
	 * @return krWhfCntr40ftRt
	 */
	public String getKrWhfCntr40ftRt() {
		return this.krWhfCntr40ftRt;
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
	 * @return krWhfBlkRt
	 */
	public String getKrWhfBlkRt() {
		return this.krWhfBlkRt;
	}
	
	/**
	 * Column Info
	 * @return krWhfCntr20ftRt
	 */
	public String getKrWhfCntr20ftRt() {
		return this.krWhfCntr20ftRt;
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
	 * @param krWhfCntr45ftRt
	 */
	public void setKrWhfCntr45ftRt(String krWhfCntr45ftRt) {
		this.krWhfCntr45ftRt = krWhfCntr45ftRt;
	}
	
	/**
	 * Column Info
	 * @param krWhfCntr40ftRt
	 */
	public void setKrWhfCntr40ftRt(String krWhfCntr40ftRt) {
		this.krWhfCntr40ftRt = krWhfCntr40ftRt;
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
	 * @param krWhfBlkRt
	 */
	public void setKrWhfBlkRt(String krWhfBlkRt) {
		this.krWhfBlkRt = krWhfBlkRt;
	}
	
	/**
	 * Column Info
	 * @param krWhfCntr20ftRt
	 */
	public void setKrWhfCntr20ftRt(String krWhfCntr20ftRt) {
		this.krWhfCntr20ftRt = krWhfCntr20ftRt;
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
		setKrWhfCntr45ftRt(JSPUtil.getParameter(request, "kr_whf_cntr_45ft_rt", ""));
		setKrWhfCntr40ftRt(JSPUtil.getParameter(request, "kr_whf_cntr_40ft_rt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setKrWhfBlkRt(JSPUtil.getParameter(request, "kr_whf_blk_rt", ""));
		setKrWhfCntr20ftRt(JSPUtil.getParameter(request, "kr_whf_cntr_20ft_rt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KrWhfAplyPortRtVO[]
	 */
	public KrWhfAplyPortRtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KrWhfAplyPortRtVO[]
	 */
	public KrWhfAplyPortRtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KrWhfAplyPortRtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] krWhfCntr45ftRt = (JSPUtil.getParameter(request, prefix	+ "kr_whf_cntr_45ft_rt", length));
			String[] krWhfCntr40ftRt = (JSPUtil.getParameter(request, prefix	+ "kr_whf_cntr_40ft_rt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] krWhfBlkRt = (JSPUtil.getParameter(request, prefix	+ "kr_whf_blk_rt", length));
			String[] krWhfCntr20ftRt = (JSPUtil.getParameter(request, prefix	+ "kr_whf_cntr_20ft_rt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new KrWhfAplyPortRtVO();
				if (krWhfCntr45ftRt[i] != null)
					model.setKrWhfCntr45ftRt(krWhfCntr45ftRt[i]);
				if (krWhfCntr40ftRt[i] != null)
					model.setKrWhfCntr40ftRt(krWhfCntr40ftRt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (krWhfBlkRt[i] != null)
					model.setKrWhfBlkRt(krWhfBlkRt[i]);
				if (krWhfCntr20ftRt[i] != null)
					model.setKrWhfCntr20ftRt(krWhfCntr20ftRt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKrWhfAplyPortRtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KrWhfAplyPortRtVO[]
	 */
	public KrWhfAplyPortRtVO[] getKrWhfAplyPortRtVOs(){
		KrWhfAplyPortRtVO[] vos = (KrWhfAplyPortRtVO[])models.toArray(new KrWhfAplyPortRtVO[models.size()]);
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
		this.krWhfCntr45ftRt = this.krWhfCntr45ftRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krWhfCntr40ftRt = this.krWhfCntr40ftRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krWhfBlkRt = this.krWhfBlkRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krWhfCntr20ftRt = this.krWhfCntr20ftRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

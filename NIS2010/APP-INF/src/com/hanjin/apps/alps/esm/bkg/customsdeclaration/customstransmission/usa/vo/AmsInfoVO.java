/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AmsInfoVO.java
*@FileTitle : AmsInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.06.04 김도완 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo;

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
 * @author 김도완
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AmsInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AmsInfoVO> models = new ArrayList<AmsInfoVO>();
	
	/* Column Info */
	private String polLastLoc = null;
	/* Column Info */
	private String polFirstLoc = null;	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polLastAms = null;
	/* Column Info */
	private String polFirstAms = null;	
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AmsInfoVO() {}

	public AmsInfoVO(String ibflag, String pagerows, String polLastLoc, String polLastAms, String polFirstLoc, String polFirstAms ) {
		this.polLastLoc = polLastLoc;
		this.ibflag = ibflag;
		this.polLastAms = polLastAms;
		this.pagerows = pagerows;
		this.polFirstLoc = polFirstLoc;
		this.polFirstAms = polFirstAms;		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pol_last_loc", getPolLastLoc());
		this.hashColumns.put("pol_first_loc", getPolFirstLoc());		
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_last_ams", getPolLastAms());
		this.hashColumns.put("pol_first_ams", getPolFirstAms());		
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pol_last_loc", "polLastLoc");
		this.hashFields.put("pol_first_loc", "polFirstLoc");		
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_last_ams", "polLastAms");
		this.hashFields.put("pol_first_ams", "polFirstAms");		
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	
	/**
	 * Column Info
	 * @return polLastLoc
	 */
	public String getPolLastLoc() {
		return this.polLastLoc;
	}
	
	/**
	 * Column Info
	 * @return polFirstLoc
	 */
	public String getPolFirstLoc() {
		return this.polFirstLoc;
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
	 * @return polLastAms
	 */
	public String getPolLastAms() {
		return this.polLastAms;
	}
	
	/**
	 * Column Info
	 * @return polFirstAms
	 */
	public String getPolFirstAms() {
		return this.polFirstAms;
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
	 * @param polLastLoc
	 */
	public void setPolLastLoc(String polLastLoc) {
		this.polLastLoc = polLastLoc;
	}
	
	
	/**
	 * Column Info
	 * @param PolFirstLoc
	 */
	public void setPolFirstLoc(String polFirstLoc) {
		this.polFirstLoc = polFirstLoc;
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
	 * @param polLastAms
	 */
	public void setPolLastAms(String polLastAms) {
		this.polLastAms = polLastAms;
	}
	
	/**
	 * Column Info
	 * @param polFirstAms
	 */
	public void setPolFirstAms(String polFirstAms) {
		this.polFirstAms = polFirstAms;
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
		setPolLastLoc(JSPUtil.getParameter(request, "pol_last_loc", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolLastAms(JSPUtil.getParameter(request, "pol_last_ams", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolFirstLoc(JSPUtil.getParameter(request, "pol_first_loc", ""));
		setPolFirstAms(JSPUtil.getParameter(request, "pol_first_ams", ""));		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AmsInfoVO[]
	 */
	public AmsInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AmsInfoVO[]
	 */
	public AmsInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AmsInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] polLastLoc = (JSPUtil.getParameter(request, prefix	+ "pol_last_loc".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] polLastAms = (JSPUtil.getParameter(request, prefix	+ "pol_last_ams".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] polFirstLoc = (JSPUtil.getParameter(request, prefix	+ "pol_first_loc".trim(), length));
			String[] polFirstAms = (JSPUtil.getParameter(request, prefix	+ "pol_first_ams".trim(), length));			
			
			for (int i = 0; i < length; i++) {
				model = new AmsInfoVO();
				if (polLastLoc[i] != null)
					model.setPolLastLoc(polLastLoc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polLastAms[i] != null)
					model.setPolLastAms(polLastAms[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polFirstAms[i] != null)
					model.setPolFirstAms(polFirstAms[i]);				
				if (polFirstLoc[i] != null)
					model.setPolFirstLoc(polFirstLoc[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAmsInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AmsInfoVO[]
	 */
	public AmsInfoVO[] getAmsInfoVOs(){
		AmsInfoVO[] vos = (AmsInfoVO[])models.toArray(new AmsInfoVO[models.size()]);
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
		this.polLastLoc = this.polLastLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polLastAms = this.polLastAms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polFirstLoc = this.polFirstLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polFirstAms = this.polFirstAms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
	}
}

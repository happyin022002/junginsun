/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCustInfoVO.java
*@FileTitle : SearchCustInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.05.27 손윤석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

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
 * @author 손윤석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorCustInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorCustInfoVO> models = new ArrayList<KorCustInfoVO>();
	
	/* Column Info */
	private String shprName = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrs14 = null;
	/* Column Info */
	private String cneeAddr = null;
	/* Column Info */
	private String shprAddr = null;
	/* Column Info */
	private String cneeName = null;
	/* Column Info */
	private String ntfyName = null;
	/* Column Info */
	private String ntfyAddr = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorCustInfoVO() {}

	public KorCustInfoVO(String ibflag, String pagerows, String shprName, String shprAddr, String cneeName, String cneeAddr, String ntfyName, String ntfyAddr, String usrs14) {
		this.shprName = shprName;
		this.ibflag = ibflag;
		this.usrs14 = usrs14;
		this.cneeAddr = cneeAddr;
		this.shprAddr = shprAddr;
		this.cneeName = cneeName;
		this.ntfyName = ntfyName;
		this.ntfyAddr = ntfyAddr;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("shpr_name", getShprName());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usrs14", getUsrs14());
		this.hashColumns.put("cnee_addr", getCneeAddr());
		this.hashColumns.put("shpr_addr", getShprAddr());
		this.hashColumns.put("cnee_name", getCneeName());
		this.hashColumns.put("ntfy_name", getNtfyName());
		this.hashColumns.put("ntfy_addr", getNtfyAddr());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("shpr_name", "shprName");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usrs14", "usrs14");
		this.hashFields.put("cnee_addr", "cneeAddr");
		this.hashFields.put("shpr_addr", "shprAddr");
		this.hashFields.put("cnee_name", "cneeName");
		this.hashFields.put("ntfy_name", "ntfyName");
		this.hashFields.put("ntfy_addr", "ntfyAddr");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return shprName
	 */
	public String getShprName() {
		return this.shprName;
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
	 * @return usrs14
	 */
	public String getUsrs14() {
		return this.usrs14;
	}
	
	/**
	 * Column Info
	 * @return cneeAddr
	 */
	public String getCneeAddr() {
		return this.cneeAddr;
	}
	
	/**
	 * Column Info
	 * @return shprAddr
	 */
	public String getShprAddr() {
		return this.shprAddr;
	}
	
	/**
	 * Column Info
	 * @return cneeName
	 */
	public String getCneeName() {
		return this.cneeName;
	}
	
	/**
	 * Column Info
	 * @return ntfyName
	 */
	public String getNtfyName() {
		return this.ntfyName;
	}
	
	/**
	 * Column Info
	 * @return ntfyAddr
	 */
	public String getNtfyAddr() {
		return this.ntfyAddr;
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
	 * @param shprName
	 */
	public void setShprName(String shprName) {
		this.shprName = shprName;
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
	 * @param usrs14
	 */
	public void setUsrs14(String usrs14) {
		this.usrs14 = usrs14;
	}
	
	/**
	 * Column Info
	 * @param cneeAddr
	 */
	public void setCneeAddr(String cneeAddr) {
		this.cneeAddr = cneeAddr;
	}
	
	/**
	 * Column Info
	 * @param shprAddr
	 */
	public void setShprAddr(String shprAddr) {
		this.shprAddr = shprAddr;
	}
	
	/**
	 * Column Info
	 * @param cneeName
	 */
	public void setCneeName(String cneeName) {
		this.cneeName = cneeName;
	}
	
	/**
	 * Column Info
	 * @param ntfyName
	 */
	public void setNtfyName(String ntfyName) {
		this.ntfyName = ntfyName;
	}
	
	/**
	 * Column Info
	 * @param ntfyAddr
	 */
	public void setNtfyAddr(String ntfyAddr) {
		this.ntfyAddr = ntfyAddr;
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
		setShprName(JSPUtil.getParameter(request, "shpr_name", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUsrs14(JSPUtil.getParameter(request, "usrs14", ""));
		setCneeAddr(JSPUtil.getParameter(request, "cnee_addr", ""));
		setShprAddr(JSPUtil.getParameter(request, "shpr_addr", ""));
		setCneeName(JSPUtil.getParameter(request, "cnee_name", ""));
		setNtfyName(JSPUtil.getParameter(request, "ntfy_name", ""));
		setNtfyAddr(JSPUtil.getParameter(request, "ntfy_addr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCustInfoVO[]
	 */
	public KorCustInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCustInfoVO[]
	 */
	public KorCustInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorCustInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] shprName = (JSPUtil.getParameter(request, prefix	+ "shpr_name".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] usrs14 = (JSPUtil.getParameter(request, prefix	+ "usrs14".trim(), length));
			String[] cneeAddr = (JSPUtil.getParameter(request, prefix	+ "cnee_addr".trim(), length));
			String[] shprAddr = (JSPUtil.getParameter(request, prefix	+ "shpr_addr".trim(), length));
			String[] cneeName = (JSPUtil.getParameter(request, prefix	+ "cnee_name".trim(), length));
			String[] ntfyName = (JSPUtil.getParameter(request, prefix	+ "ntfy_name".trim(), length));
			String[] ntfyAddr = (JSPUtil.getParameter(request, prefix	+ "ntfy_addr".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new KorCustInfoVO();
				if (shprName[i] != null)
					model.setShprName(shprName[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrs14[i] != null)
					model.setUsrs14(usrs14[i]);
				if (cneeAddr[i] != null)
					model.setCneeAddr(cneeAddr[i]);
				if (shprAddr[i] != null)
					model.setShprAddr(shprAddr[i]);
				if (cneeName[i] != null)
					model.setCneeName(cneeName[i]);
				if (ntfyName[i] != null)
					model.setNtfyName(ntfyName[i]);
				if (ntfyAddr[i] != null)
					model.setNtfyAddr(ntfyAddr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCustInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCustInfoVO[]
	 */
	public KorCustInfoVO[] getSearchCustInfoVOs(){
		KorCustInfoVO[] vos = (KorCustInfoVO[])models.toArray(new KorCustInfoVO[models.size()]);
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
		this.shprName = this.shprName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrs14 = this.usrs14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddr = this.cneeAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddr = this.shprAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeName = this.cneeName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyName = this.ntfyName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAddr = this.ntfyAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EurEtaInfoVO.java
*@FileTitle : EurEtaInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.27  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EurEtaInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EurEtaInfoVO> models = new ArrayList<EurEtaInfoVO>();
	
	/* Column Info */
	private String bvvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bpol = null;
	/* Column Info */
	private String bpod = null;
	/* Column Info */
	private String bpolName = null;
	/* Column Info */
	private String bpodName = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EurEtaInfoVO() {}

	public EurEtaInfoVO(String ibflag, String pagerows, String bvvd, String bpol, String bpod, String bpolName, String bpodName) {
		this.bvvd = bvvd;
		this.ibflag = ibflag;
		this.bpol = bpol;
		this.bpod = bpod;
		this.bpodName = bpodName;
		this.bpolName = bpolName;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bvvd", getBvvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bpol", getBpol());
		this.hashColumns.put("bpod", getBpod());
		this.hashColumns.put("bpol_name", getBpolName());
		this.hashColumns.put("bpod_name", getBpodName());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bvvd", "bvvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bpol", "bpol");
		this.hashFields.put("bpod", "bpod");
		this.hashFields.put("bpol_name", "bpolName");
		this.hashFields.put("bpod_name", "bpodName");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bvvd
	 */
	public String getBvvd() {
		return this.bvvd;
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
	 * @return bpol
	 */
	public String getBpol() {
		return this.bpol;
	}
	
	/**
	 * Column Info
	 * @return bpod
	 */
	public String getBpod() {
		return this.bpod;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Page Number
	 * @return bpolName
	 */
	public String getBpolName() {
		return this.bpolName;
	}
	
	/**
	 * Page Number
	 * @return bpodName
	 */
	public String getBpodName() {
		return this.bpodName;
	}

	/**
	 * Column Info
	 * @param bvvd
	 */
	public void setBvvd(String bvvd) {
		this.bvvd = bvvd;
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
	 * @param bpol
	 */
	public void setBpol(String bpol) {
		this.bpol = bpol;
	}
	
	/**
	 * Column Info
	 * @param bpod
	 */
	public void setBpod(String bpod) {
		this.bpod = bpod;
	}
	
	/**
	 * Column Info
	 * @param bpodName
	 */
	public void setBpodName(String bpodName) {
		this.bpodName = bpodName;
	}
	
	/**
	 * Column Info
	 * @param bpolName
	 */
	public void setBpolName(String bpolName) {
		this.bpolName = bpolName;
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
		setBvvd(JSPUtil.getParameter(request, "bvvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBpol(JSPUtil.getParameter(request, "bpol", ""));
		setBpod(JSPUtil.getParameter(request, "bpod", ""));
		setPagerows(JSPUtil.getParameter(request, "bpol_name", ""));
		setPagerows(JSPUtil.getParameter(request, "bpod_name", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EurEtaInfoVO[]
	 */
	public EurEtaInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EurEtaInfoVO[]
	 */
	public EurEtaInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EurEtaInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bvvd = (JSPUtil.getParameter(request, prefix	+ "bvvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bpol = (JSPUtil.getParameter(request, prefix	+ "bpol", length));
			String[] bpod = (JSPUtil.getParameter(request, prefix	+ "bpod", length));
			String[] bpodName = (JSPUtil.getParameter(request, prefix	+ "bpod_name", length));
			String[] bpolName = (JSPUtil.getParameter(request, prefix	+ "bpol_name", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EurEtaInfoVO();
				if (bvvd[i] != null)
					model.setBvvd(bvvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bpol[i] != null)
					model.setBpol(bpol[i]);
				if (bpod[i] != null)
					model.setBpod(bpod[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bpolName[i] != null)
					model.setBpolName(pagerows[i]);
				if (bpodName[i] != null)
					model.setBpodName(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEurEtaInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EurEtaInfoVO[]
	 */
	public EurEtaInfoVO[] getEurEtaInfoVOs(){
		EurEtaInfoVO[] vos = (EurEtaInfoVO[])models.toArray(new EurEtaInfoVO[models.size()]);
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
		this.bvvd = this.bvvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bpol = this.bpol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bpod = this.bpod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bpolName = this.bpolName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bpodName = this.bpodName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaEDADetailVO.java
*@FileTitle : UsaEDADetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.08.10 김도완 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo;

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
 * @author 김도완
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaEDADetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaEDADetailVO> models = new ArrayList<UsaEDADetailVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String eta = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String edaOnMi = null;
	/* Column Info */
	private String blCount = null;
	/* Column Info */
	private String pod = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaEDADetailVO() {}

	public UsaEDADetailVO(String ibflag, String pagerows, String vvd, String pod, String eta, String edaOnMi, String blCount) {
		this.vvd = vvd;
		this.eta = eta;
		this.ibflag = ibflag;
		this.edaOnMi = edaOnMi;
		this.blCount = blCount;
		this.pod = pod;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eda_on_mi", getEdaOnMi());
		this.hashColumns.put("bl_count", getBlCount());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("eta", "eta");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eda_on_mi", "edaOnMi");
		this.hashFields.put("bl_count", "blCount");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return eta
	 */
	public String getEta() {
		return this.eta;
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
	 * @return edaOnMi
	 */
	public String getEdaOnMi() {
		return this.edaOnMi;
	}
	
	/**
	 * Column Info
	 * @return blCount
	 */
	public String getBlCount() {
		return this.blCount;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param eta
	 */
	public void setEta(String eta) {
		this.eta = eta;
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
	 * @param edaOnMi
	 */
	public void setEdaOnMi(String edaOnMi) {
		this.edaOnMi = edaOnMi;
	}
	
	/**
	 * Column Info
	 * @param blCount
	 */
	public void setBlCount(String blCount) {
		this.blCount = blCount;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
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
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setEta(JSPUtil.getParameter(request, "eta", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEdaOnMi(JSPUtil.getParameter(request, "eda_on_mi", ""));
		setBlCount(JSPUtil.getParameter(request, "bl_count", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaEDADetailVO[]
	 */
	public UsaEDADetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaEDADetailVO[]
	 */
	public UsaEDADetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaEDADetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] edaOnMi = (JSPUtil.getParameter(request, prefix	+ "eda_on_mi", length));
			String[] blCount = (JSPUtil.getParameter(request, prefix	+ "bl_count", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaEDADetailVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (edaOnMi[i] != null)
					model.setEdaOnMi(edaOnMi[i]);
				if (blCount[i] != null)
					model.setBlCount(blCount[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaEDADetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaEDADetailVO[]
	 */
	public UsaEDADetailVO[] getUsaEDADetailVOs(){
		UsaEDADetailVO[] vos = (UsaEDADetailVO[])models.toArray(new UsaEDADetailVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edaOnMi = this.edaOnMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCount = this.blCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

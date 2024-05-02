/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScacReportCondVO.java
*@FileTitle : ScacReportCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.05.25 김도완 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo;

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

public class ScacReportCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScacReportCondVO> models = new ArrayList<ScacReportCondVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String mbl = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String hbl = null;
	/* Column Info */
	private String scac = null;
	/* Column Info */
	private String err = null;
	/* Column Info */
	private String pod = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScacReportCondVO() {}

	public ScacReportCondVO(String ibflag, String pagerows, String vvd, String pod, String scac, String mbl, String hbl, String err) {
		this.vvd = vvd;
		this.mbl = mbl;
		this.ibflag = ibflag;
		this.hbl = hbl;
		this.scac = scac;
		this.err = err;
		this.pod = pod;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("mbl", getMbl());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("hbl", getHbl());
		this.hashColumns.put("scac", getScac());
		this.hashColumns.put("err", getErr());
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
		this.hashFields.put("mbl", "mbl");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("hbl", "hbl");
		this.hashFields.put("scac", "scac");
		this.hashFields.put("err", "err");
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
	 * @return mbl
	 */
	public String getMbl() {
		return this.mbl;
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
	 * @return hbl
	 */
	public String getHbl() {
		return this.hbl;
	}
	
	/**
	 * Column Info
	 * @return scac
	 */
	public String getScac() {
		return this.scac;
	}
	
	/**
	 * Column Info
	 * @return err
	 */
	public String getErr() {
		return this.err;
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
	 * @param mbl
	 */
	public void setMbl(String mbl) {
		this.mbl = mbl;
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
	 * @param hbl
	 */
	public void setHbl(String hbl) {
		this.hbl = hbl;
	}
	
	/**
	 * Column Info
	 * @param scac
	 */
	public void setScac(String scac) {
		this.scac = scac;
	}
	
	/**
	 * Column Info
	 * @param err
	 */
	public void setErr(String err) {
		this.err = err;
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
		setMbl(JSPUtil.getParameter(request, "mbl", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setHbl(JSPUtil.getParameter(request, "hbl", ""));
		setScac(JSPUtil.getParameter(request, "scac", ""));
		setErr(JSPUtil.getParameter(request, "err", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScacReportCondVO[]
	 */
	public ScacReportCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScacReportCondVO[]
	 */
	public ScacReportCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScacReportCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd".trim(), length));
			String[] mbl = (JSPUtil.getParameter(request, prefix	+ "mbl".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] hbl = (JSPUtil.getParameter(request, prefix	+ "hbl".trim(), length));
			String[] scac = (JSPUtil.getParameter(request, prefix	+ "scac".trim(), length));
			String[] err = (JSPUtil.getParameter(request, prefix	+ "err".trim(), length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ScacReportCondVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (mbl[i] != null)
					model.setMbl(mbl[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (hbl[i] != null)
					model.setHbl(hbl[i]);
				if (scac[i] != null)
					model.setScac(scac[i]);
				if (err[i] != null)
					model.setErr(err[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScacReportCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScacReportCondVO[]
	 */
	public ScacReportCondVO[] getScacReportCondVOs(){
		ScacReportCondVO[] vos = (ScacReportCondVO[])models.toArray(new ScacReportCondVO[models.size()]);
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
		this.mbl = this.mbl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hbl = this.hbl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scac = this.scac .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.err = this.err .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

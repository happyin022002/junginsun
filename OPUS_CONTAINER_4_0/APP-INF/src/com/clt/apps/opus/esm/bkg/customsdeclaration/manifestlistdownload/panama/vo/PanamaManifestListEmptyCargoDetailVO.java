/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PanamaManifestListEmptyCargoDetailVO.java
*@FileTitle : PanamaManifestListEmptyCargoDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.22  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo;

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

public class PanamaManifestListEmptyCargoDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PanamaManifestListEmptyCargoDetailVO> models = new ArrayList<PanamaManifestListEmptyCargoDetailVO>();
	
	/* Column Info */
	private String xMtTs = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String xMtLoc = null;
	/* Column Info */
	private String xMtTotal = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PanamaManifestListEmptyCargoDetailVO() {}

	public PanamaManifestListEmptyCargoDetailVO(String ibflag, String pagerows, String xMtTotal, String xMtLoc, String xMtTs) {
		this.xMtTs = xMtTs;
		this.ibflag = ibflag;
		this.xMtLoc = xMtLoc;
		this.xMtTotal = xMtTotal;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("x_mt_ts", getXMtTs());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("x_mt_loc", getXMtLoc());
		this.hashColumns.put("x_mt_total", getXMtTotal());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("x_mt_ts", "xMtTs");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("x_mt_loc", "xMtLoc");
		this.hashFields.put("x_mt_total", "xMtTotal");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return xMtTs
	 */
	public String getXMtTs() {
		return this.xMtTs;
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
	 * @return xMtLoc
	 */
	public String getXMtLoc() {
		return this.xMtLoc;
	}
	
	/**
	 * Column Info
	 * @return xMtTotal
	 */
	public String getXMtTotal() {
		return this.xMtTotal;
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
	 * @param xMtTs
	 */
	public void setXMtTs(String xMtTs) {
		this.xMtTs = xMtTs;
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
	 * @param xMtLoc
	 */
	public void setXMtLoc(String xMtLoc) {
		this.xMtLoc = xMtLoc;
	}
	
	/**
	 * Column Info
	 * @param xMtTotal
	 */
	public void setXMtTotal(String xMtTotal) {
		this.xMtTotal = xMtTotal;
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
		setXMtTs(JSPUtil.getParameter(request, "x_mt_ts", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setXMtLoc(JSPUtil.getParameter(request, "x_mt_loc", ""));
		setXMtTotal(JSPUtil.getParameter(request, "x_mt_total", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PanamaManifestListEmptyCargoDetailVO[]
	 */
	public PanamaManifestListEmptyCargoDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PanamaManifestListEmptyCargoDetailVO[]
	 */
	public PanamaManifestListEmptyCargoDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PanamaManifestListEmptyCargoDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] xMtTs = (JSPUtil.getParameter(request, prefix	+ "x_mt_ts".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] xMtLoc = (JSPUtil.getParameter(request, prefix	+ "x_mt_loc".trim(), length));
			String[] xMtTotal = (JSPUtil.getParameter(request, prefix	+ "x_mt_total".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new PanamaManifestListEmptyCargoDetailVO();
				if (xMtTs[i] != null)
					model.setXMtTs(xMtTs[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (xMtLoc[i] != null)
					model.setXMtLoc(xMtLoc[i]);
				if (xMtTotal[i] != null)
					model.setXMtTotal(xMtTotal[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPanamaManifestListEmptyCargoDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PanamaManifestListEmptyCargoDetailVO[]
	 */
	public PanamaManifestListEmptyCargoDetailVO[] getPanamaManifestListEmptyCargoDetailVOs(){
		PanamaManifestListEmptyCargoDetailVO[] vos = (PanamaManifestListEmptyCargoDetailVO[])models.toArray(new PanamaManifestListEmptyCargoDetailVO[models.size()]);
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
		this.xMtTs = this.xMtTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xMtLoc = this.xMtLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xMtTotal = this.xMtTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

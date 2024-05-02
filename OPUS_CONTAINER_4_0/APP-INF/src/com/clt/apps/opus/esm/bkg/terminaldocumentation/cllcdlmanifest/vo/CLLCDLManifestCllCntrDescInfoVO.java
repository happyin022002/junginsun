/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestCllCntrDescInfoVO.java
*@FileTitle : CLLCDLManifestCllCntrDescInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.22
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CLLCDLManifestCllCntrDescInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CLLCDLManifestCllCntrDescInfoVO> models = new ArrayList<CLLCDLManifestCllCntrDescInfoVO>();

	/* Column Info */
	private String cntrDescEnd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrDesc = null;
	/* Column Info */
	private String cusMark = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CLLCDLManifestCllCntrDescInfoVO() {}

	public CLLCDLManifestCllCntrDescInfoVO(String ibflag, String pagerows, String cntrDesc, String cusMark, String cntrDescEnd) {
		this.cntrDescEnd = cntrDescEnd;
		this.ibflag = ibflag;
		this.cntrDesc = cntrDesc;
		this.cusMark = cusMark;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_desc_end", getCntrDescEnd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_desc", getCntrDesc());
		this.hashColumns.put("cus_mark", getCusMark());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_desc_end", "cntrDescEnd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_desc", "cntrDesc");
		this.hashFields.put("cus_mark", "cusMark");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return cntrDescEnd
	 */
	public String getCntrDescEnd() {
		return this.cntrDescEnd;
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
	 * @return cntrDesc
	 */
	public String getCntrDesc() {
		return this.cntrDesc;
	}

	/**
	 * Column Info
	 * @return cusMark
	 */
	public String getCusMark() {
		return this.cusMark;
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
	 * @param cntrDescEnd
	 */
	public void setCntrDescEnd(String cntrDescEnd) {
		this.cntrDescEnd = cntrDescEnd;
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
	 * @param cntrDesc
	 */
	public void setCntrDesc(String cntrDesc) {
		this.cntrDesc = cntrDesc;
	}

	/**
	 * Column Info
	 * @param cusMark
	 */
	public void setCusMark(String cusMark) {
		this.cusMark = cusMark;
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
		setCntrDescEnd(JSPUtil.getParameter(request, "cntr_desc_end", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrDesc(JSPUtil.getParameter(request, "cntr_desc", ""));
		setCusMark(JSPUtil.getParameter(request, "cus_mark", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CLLCDLManifestCllCntrDescInfoVO[]
	 */
	public CLLCDLManifestCllCntrDescInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CLLCDLManifestCllCntrDescInfoVO[]
	 */
	public CLLCDLManifestCllCntrDescInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CLLCDLManifestCllCntrDescInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] cntrDescEnd = (JSPUtil.getParameter(request, prefix	+ "cntr_desc_end", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_desc", length));
			String[] cusMark = (JSPUtil.getParameter(request, prefix	+ "cus_mark", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new CLLCDLManifestCllCntrDescInfoVO();
				if (cntrDescEnd[i] != null)
					model.setCntrDescEnd(cntrDescEnd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrDesc[i] != null)
					model.setCntrDesc(cntrDesc[i]);
				if (cusMark[i] != null)
					model.setCusMark(cusMark[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCLLCDLManifestCllCntrDescInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CLLCDLManifestCllCntrDescInfoVO[]
	 */
	public CLLCDLManifestCllCntrDescInfoVO[] getCLLCDLManifestCllCntrDescInfoVOs(){
		CLLCDLManifestCllCntrDescInfoVO[] vos = (CLLCDLManifestCllCntrDescInfoVO[])models.toArray(new CLLCDLManifestCllCntrDescInfoVO[models.size()]);
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
		this.cntrDescEnd = this.cntrDescEnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDesc = this.cntrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cusMark = this.cusMark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

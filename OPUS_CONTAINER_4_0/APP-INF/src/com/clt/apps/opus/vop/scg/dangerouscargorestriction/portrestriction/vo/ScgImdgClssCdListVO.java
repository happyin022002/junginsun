/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScgImdgClssCdListVO.java
*@FileTitle : ScgImdgClssCdListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.08 장강철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.vo;

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
 * @author 장강철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ScgImdgClssCdListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgImdgClssCdListVO> models = new ArrayList<ScgImdgClssCdListVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String imdgClssCdDesc = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScgImdgClssCdListVO() {}

	public ScgImdgClssCdListVO(String ibflag, String pagerows, String imdgClssCd, String imdgClssCdDesc) {
		this.ibflag = ibflag;
		this.imdgClssCdDesc = imdgClssCdDesc;
		this.imdgClssCd = imdgClssCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("imdg_clss_cd_desc", getImdgClssCdDesc());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("imdg_clss_cd_desc", "imdgClssCdDesc");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Status
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCdDesc
	 */
	public String getImdgClssCdDesc() {
		return this.imdgClssCdDesc;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	

	/**
	 * Status
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCdDesc
	 */
	public void setImdgClssCdDesc(String imdgClssCdDesc) {
		this.imdgClssCdDesc = imdgClssCdDesc;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setImdgClssCdDesc(JSPUtil.getParameter(request, "imdg_clss_cd_desc", ""));
		setImdgClssCd(JSPUtil.getParameter(request, "imdg_clss_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgImdgClssCdListVO[]
	 */
	public ScgImdgClssCdListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgImdgClssCdListVO[]
	 */
	public ScgImdgClssCdListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgImdgClssCdListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] imdgClssCdDesc = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd_desc".trim(), length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgImdgClssCdListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (imdgClssCdDesc[i] != null)
					model.setImdgClssCdDesc(imdgClssCdDesc[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgImdgClssCdListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgImdgClssCdListVO[]
	 */
	public ScgImdgClssCdListVO[] getScgImdgClssCdListVOs(){
		ScgImdgClssCdListVO[] vos = (ScgImdgClssCdListVO[])models.toArray(new ScgImdgClssCdListVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCdDesc = this.imdgClssCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CtmMvmtXchRsnVO.java
*@FileTitle : CtmMvmtXchRsnVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.06.10 김상수
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CtmMvmtXchRsnVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CtmMvmtXchRsnVO> models = new ArrayList<CtmMvmtXchRsnVO>();

	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String xchRsnCd = null;
	/* Column Info */
	private String xchAbbrNm = null;
	/* Column Info */
	private String xchDesc = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CtmMvmtXchRsnVO() {}

	public CtmMvmtXchRsnVO(String ibflag, String pagerows, String xchRsnCd, String xchAbbrNm, String xchDesc) {
		this.ibflag = ibflag;
		this.xchRsnCd = xchRsnCd;
		this.xchAbbrNm = xchAbbrNm;
		this.xchDesc = xchDesc;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("xch_rsn_cd", getXchRsnCd());
		this.hashColumns.put("xch_abbr_nm", getXchAbbrNm());
		this.hashColumns.put("xch_desc", getXchDesc());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("xch_rsn_cd", "xchRsnCd");
		this.hashFields.put("xch_abbr_nm", "xchAbbrNm");
		this.hashFields.put("xch_desc", "xchDesc");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return xchRsnCd
	 */
	public String getXchRsnCd() {
		return this.xchRsnCd;
	}

	/**
	 * Column Info
	 * @return xchAbbrNm
	 */
	public String getXchAbbrNm() {
		return this.xchAbbrNm;
	}

	/**
	 * Column Info
	 * @return xchDesc
	 */
	public String getXchDesc() {
		return this.xchDesc;
	}

	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param xchRsnCd
	 */
	public void setXchRsnCd(String xchRsnCd) {
		this.xchRsnCd = xchRsnCd;
	}

	/**
	 * Column Info
	 * @param xchAbbrNm
	 */
	public void setXchAbbrNm(String xchAbbrNm) {
		this.xchAbbrNm = xchAbbrNm;
	}

	/**
	 * Column Info
	 * @param xchDesc
	 */
	public void setXchDesc(String xchDesc) {
		this.xchDesc = xchDesc;
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
		setXchRsnCd(JSPUtil.getParameter(request, "xch_rsn_cd", ""));
		setXchAbbrNm(JSPUtil.getParameter(request, "xch_abbr_nm", ""));
		setXchDesc(JSPUtil.getParameter(request, "xch_desc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CtmMvmtXchRsnVO[]
	 */
	public CtmMvmtXchRsnVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CtmMvmtXchRsnVO[]
	 */
	public CtmMvmtXchRsnVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CtmMvmtXchRsnVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] xchRsnCd = (JSPUtil.getParameter(request, prefix	+ "xch_rsn_cd", length));
			String[] xchAbbrNm = (JSPUtil.getParameter(request, prefix	+ "xch_abbr_nm", length));
			String[] xchDesc = (JSPUtil.getParameter(request, prefix	+ "xch_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new CtmMvmtXchRsnVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (xchRsnCd[i] != null)
					model.setXchRsnCd(xchRsnCd[i]);
				if (xchAbbrNm[i] != null)
					model.setXchAbbrNm(xchAbbrNm[i]);
				if (xchDesc[i] != null)
					model.setXchDesc(xchDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCtmMvmtXchRsnVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CtmMvmtXchRsnVO[]
	 */
	public CtmMvmtXchRsnVO[] getCtmMvmtXchRsnVOs(){
		CtmMvmtXchRsnVO[] vos = (CtmMvmtXchRsnVO[])models.toArray(new CtmMvmtXchRsnVO[models.size()]);
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
		this.xchRsnCd = this.xchRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchAbbrNm = this.xchAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchDesc = this.xchDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

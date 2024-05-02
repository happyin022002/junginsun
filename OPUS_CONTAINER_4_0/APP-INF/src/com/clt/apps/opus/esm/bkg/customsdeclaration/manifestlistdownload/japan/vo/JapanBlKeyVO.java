/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanBlKeyVO.java
*@FileTitle : JapanBlKeyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier :
*@LastVersion : 1.0
* 2009.06.16
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlKeyVO;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see BlKeyVO
 */

public class JapanBlKeyVO extends BlKeyVO {

	private static final long serialVersionUID = 1L;

	private Collection<JapanBlKeyVO> models = new ArrayList<JapanBlKeyVO>();

	/* Column Info */
	private String inBlNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inBlSplitNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public JapanBlKeyVO() {}

	public JapanBlKeyVO(String ibflag, String pagerows, String inBlNo, String inBlSplitNo) {
		this.inBlNo = inBlNo;
		this.ibflag = ibflag;
		this.inBlSplitNo = inBlSplitNo;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_bl_no", getInBlNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_bl_split_no", getInBlSplitNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_bl_no", "inBlNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_bl_split_no", "inBlSplitNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return inBlNo
	 */
	public String getInBlNo() {
		return this.inBlNo;
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
	 * @return inBlSplitNo
	 */
	public String getInBlSplitNo() {
		return this.inBlSplitNo;
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
	 * @param inBlNo
	 */
	public void setInBlNo(String inBlNo) {
		this.inBlNo = inBlNo;
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
	 * @param inBlSplitNo
	 */
	public void setInBlSplitNo(String inBlSplitNo) {
		this.inBlSplitNo = inBlSplitNo;
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
		setInBlNo(JSPUtil.getParameter(request, "in_bl_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInBlSplitNo(JSPUtil.getParameter(request, "in_bl_split_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapanBlKeyVO[]
	 */
	public JapanBlKeyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return JapanBlKeyVO[]
	 */
	public JapanBlKeyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapanBlKeyVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] inBlNo = (JSPUtil.getParameter(request, prefix	+ "in_bl_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inBlSplitNo = (JSPUtil.getParameter(request, prefix	+ "in_bl_split_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new JapanBlKeyVO();
				if (inBlNo[i] != null)
					model.setInBlNo(inBlNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inBlSplitNo[i] != null)
					model.setInBlSplitNo(inBlSplitNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapanBlKeyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapanBlKeyVO[]
	 */
	public JapanBlKeyVO[] getJapanBlKeyVOs(){
		JapanBlKeyVO[] vos = (JapanBlKeyVO[])models.toArray(new JapanBlKeyVO[models.size()]);
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
		this.inBlNo = this.inBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBlSplitNo = this.inBlSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

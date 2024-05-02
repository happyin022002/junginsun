/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileTitle : <Kor24UNLocVO.java
*@FileTitle : Kor24UNLocVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.07 손윤석
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo;

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

public class Kor24UNLocVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<Kor24UNLocVO> models = new ArrayList<Kor24UNLocVO>();

	/* Column Info */
	private String polUn = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String podUn = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public Kor24UNLocVO() {}

	public Kor24UNLocVO(String ibflag, String pagerows, String polUn, String podUn) {
		this.polUn = polUn;
		this.ibflag = ibflag;
		this.podUn = podUn;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pol_un", getPolUn());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pod_un", getPodUn());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pol_un", "polUn");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pod_un", "podUn");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return polUn
	 */
	public String getPolUn() {
		return this.polUn;
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
	 * @return podUn
	 */
	public String getPodUn() {
		return this.podUn;
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
	 * @param polUn
	 */
	public void setPolUn(String polUn) {
		this.polUn = polUn;
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
	 * @param podUn
	 */
	public void setPodUn(String podUn) {
		this.podUn = podUn;
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
		setPolUn(JSPUtil.getParameter(request, "pol_un", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPodUn(JSPUtil.getParameter(request, "pod_un", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Kor24UNLocVO[]
	 */
	public Kor24UNLocVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return Kor24UNLocVO[]
	 */
	public Kor24UNLocVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Kor24UNLocVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] polUn = (JSPUtil.getParameter(request, prefix	+ "pol_un", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] podUn = (JSPUtil.getParameter(request, prefix	+ "pod_un", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new Kor24UNLocVO();
				if (polUn[i] != null)
					model.setPolUn(polUn[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (podUn[i] != null)
					model.setPodUn(podUn[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKor24UNLocVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Kor24UNLocVO[]
	 */
	public Kor24UNLocVO[] getKor24UNLocVOs(){
		Kor24UNLocVO[] vos = (Kor24UNLocVO[])models.toArray(new Kor24UNLocVO[models.size()]);
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
		this.polUn = this.polUn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podUn = this.podUn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
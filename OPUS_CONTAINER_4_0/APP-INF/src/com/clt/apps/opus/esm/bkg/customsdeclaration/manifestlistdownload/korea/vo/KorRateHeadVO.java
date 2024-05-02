/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchExemptWhfVO.java
*@FileTitle : SearchExemptWhfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.06.04 손윤석
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

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
 * @author 손윤석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorRateHeadVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorRateHeadVO> models = new ArrayList<KorRateHeadVO>();

	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String whfInd = null;
	/* Column Info */
	private String kcdTp = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorRateHeadVO() {}

	public KorRateHeadVO(String ibflag, String pagerows, String kcdTp, String whfInd) {
		this.ibflag = ibflag;
		this.whfInd = whfInd;
		this.kcdTp = kcdTp;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("whf_ind", getWhfInd());
		this.hashColumns.put("kcd_tp", getKcdTp());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("whf_ind", "whfInd");
		this.hashFields.put("kcd_tp", "kcdTp");
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
	 * @return whfInd
	 */
	public String getWhfInd() {
		return this.whfInd;
	}

	/**
	 * Column Info
	 * @return kcdTp
	 */
	public String getKcdTp() {
		return this.kcdTp;
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
	 * @param whfInd
	 */
	public void setWhfInd(String whfInd) {
		this.whfInd = whfInd;
	}

	/**
	 * Column Info
	 * @param kcdTp
	 */
	public void setKcdTp(String kcdTp) {
		this.kcdTp = kcdTp;
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
		setWhfInd(JSPUtil.getParameter(request, "whf_ind", ""));
		setKcdTp(JSPUtil.getParameter(request, "kcd_tp", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchExemptWhfVO[]
	 */
	public KorRateHeadVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SearchExemptWhfVO[]
	 */
	public KorRateHeadVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorRateHeadVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] whfInd = (JSPUtil.getParameter(request, prefix	+ "whf_ind".trim(), length));
			String[] kcdTp = (JSPUtil.getParameter(request, prefix	+ "kcd_tp".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new KorRateHeadVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (whfInd[i] != null)
					model.setWhfInd(whfInd[i]);
				if (kcdTp[i] != null)
					model.setKcdTp(kcdTp[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchExemptWhfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchExemptWhfVO[]
	 */
	public KorRateHeadVO[] getSearchExemptWhfVOs(){
		KorRateHeadVO[] vos = (KorRateHeadVO[])models.toArray(new KorRateHeadVO[models.size()]);
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
		this.whfInd = this.whfInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kcdTp = this.kcdTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

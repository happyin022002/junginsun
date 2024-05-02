/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChinaVslInfoVO.java
*@FileTitle : ChinaVslInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.21
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo;

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

public class ChinaVslInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<ChinaVslInfoVO> models = new ArrayList<ChinaVslInfoVO>();

	/* Column Info */
	private String fstPortNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fstArrDt = null;
	/* Column Info */
	private String fstPort = null;
	/* Column Info */
	private String nationCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public ChinaVslInfoVO() {}

	public ChinaVslInfoVO(String ibflag, String pagerows, String fstPort, String fstPortNm, String fstArrDt, String nationCd) {
		this.fstPortNm = fstPortNm;
		this.ibflag = ibflag;
		this.fstArrDt = fstArrDt;
		this.fstPort = fstPort;
		this.nationCd = nationCd;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fst_port_nm", getFstPortNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fst_arr_dt", getFstArrDt());
		this.hashColumns.put("fst_port", getFstPort());
		this.hashColumns.put("nation_cd", getNationCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fst_port_nm", "fstPortNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fst_arr_dt", "fstArrDt");
		this.hashFields.put("fst_port", "fstPort");
		this.hashFields.put("nation_cd", "nationCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return fstPortNm
	 */
	public String getFstPortNm() {
		return this.fstPortNm;
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
	 * @return fstArrDt
	 */
	public String getFstArrDt() {
		return this.fstArrDt;
	}

	/**
	 * Column Info
	 * @return fstPort
	 */
	public String getFstPort() {
		return this.fstPort;
	}

	/**
	 * Column Info
	 * @return nationCd
	 */
	public String getNationCd() {
		return this.nationCd;
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
	 * @param fstPortNm
	 */
	public void setFstPortNm(String fstPortNm) {
		this.fstPortNm = fstPortNm;
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
	 * @param fstArrDt
	 */
	public void setFstArrDt(String fstArrDt) {
		this.fstArrDt = fstArrDt;
	}

	/**
	 * Column Info
	 * @param fstPort
	 */
	public void setFstPort(String fstPort) {
		this.fstPort = fstPort;
	}

	/**
	 * Column Info
	 * @param nationCd
	 */
	public void setNationCd(String nationCd) {
		this.nationCd = nationCd;
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
		setFstPortNm(JSPUtil.getParameter(request, "fst_port_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFstArrDt(JSPUtil.getParameter(request, "fst_arr_dt", ""));
		setFstPort(JSPUtil.getParameter(request, "fst_port", ""));
		setNationCd(JSPUtil.getParameter(request, "nation_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChinaVslInfoVO[]
	 */
	public ChinaVslInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ChinaVslInfoVO[]
	 */
	public ChinaVslInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChinaVslInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] fstPortNm = (JSPUtil.getParameter(request, prefix	+ "fst_port_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fstArrDt = (JSPUtil.getParameter(request, prefix	+ "fst_arr_dt", length));
			String[] fstPort = (JSPUtil.getParameter(request, prefix	+ "fst_port", length));
			String[] nationCd = (JSPUtil.getParameter(request, prefix	+ "nation_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new ChinaVslInfoVO();
				if (fstPortNm[i] != null)
					model.setFstPortNm(fstPortNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fstArrDt[i] != null)
					model.setFstArrDt(fstArrDt[i]);
				if (fstPort[i] != null)
					model.setFstPort(fstPort[i]);
				if (nationCd[i] != null)
					model.setNationCd(nationCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChinaVslInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChinaVslInfoVO[]
	 */
	public ChinaVslInfoVO[] getChinaVslInfoVOs(){
		ChinaVslInfoVO[] vos = (ChinaVslInfoVO[])models.toArray(new ChinaVslInfoVO[models.size()]);
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
		this.fstPortNm = this.fstPortNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fstArrDt = this.fstArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fstPort = this.fstPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nationCd = this.nationCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

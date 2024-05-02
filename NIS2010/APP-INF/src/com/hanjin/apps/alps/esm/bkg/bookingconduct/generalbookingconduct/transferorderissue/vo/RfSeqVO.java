/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RfSeqVO.java
*@FileTitle : RfSeqVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.05.25 이남경
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo;

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
 * @author 이남경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RfSeqVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<RfSeqVO> models = new ArrayList<RfSeqVO>();

	/* Column Info */
	private String displayNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rfTroRmk = null;
	/* Column Info */
	private String rfSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public RfSeqVO() {}

	public RfSeqVO(String ibflag, String pagerows, String rfSeq, String rfTroRmk, String displayNm) {
		this.displayNm = displayNm;
		this.ibflag = ibflag;
		this.rfTroRmk = rfTroRmk;
		this.rfSeq = rfSeq;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("display_nm", getDisplayNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rf_tro_rmk", getRfTroRmk());
		this.hashColumns.put("rf_seq", getRfSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("display_nm", "displayNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rf_tro_rmk", "rfTroRmk");
		this.hashFields.put("rf_seq", "rfSeq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return displayNm
	 */
	public String getDisplayNm() {
		return this.displayNm;
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
	 * @return rfTroRmk
	 */
	public String getRfTroRmk() {
		return this.rfTroRmk;
	}

	/**
	 * Column Info
	 * @return rfSeq
	 */
	public String getRfSeq() {
		return this.rfSeq;
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
	 * @param displayNm
	 */
	public void setDisplayNm(String displayNm) {
		this.displayNm = displayNm;
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
	 * @param rfTroRmk
	 */
	public void setRfTroRmk(String rfTroRmk) {
		this.rfTroRmk = rfTroRmk;
	}

	/**
	 * Column Info
	 * @param rfSeq
	 */
	public void setRfSeq(String rfSeq) {
		this.rfSeq = rfSeq;
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
		setDisplayNm(JSPUtil.getParameter(request, "display_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRfTroRmk(JSPUtil.getParameter(request, "rf_tro_rmk", ""));
		setRfSeq(JSPUtil.getParameter(request, "rf_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RfSeqVO[]
	 */
	public RfSeqVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return RfSeqVO[]
	 */
	public RfSeqVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RfSeqVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] displayNm = (JSPUtil.getParameter(request, prefix	+ "display_nm".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] rfTroRmk = (JSPUtil.getParameter(request, prefix	+ "rf_tro_rmk".trim(), length));
			String[] rfSeq = (JSPUtil.getParameter(request, prefix	+ "rf_seq".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new RfSeqVO();
				if (displayNm[i] != null)
					model.setDisplayNm(displayNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rfTroRmk[i] != null)
					model.setRfTroRmk(rfTroRmk[i]);
				if (rfSeq[i] != null)
					model.setRfSeq(rfSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRfSeqVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RfSeqVO[]
	 */
	public RfSeqVO[] getRfSeqVOs(){
		RfSeqVO[] vos = (RfSeqVO[])models.toArray(new RfSeqVO[models.size()]);
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
		this.displayNm = this.displayNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTroRmk = this.rfTroRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfSeq = this.rfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

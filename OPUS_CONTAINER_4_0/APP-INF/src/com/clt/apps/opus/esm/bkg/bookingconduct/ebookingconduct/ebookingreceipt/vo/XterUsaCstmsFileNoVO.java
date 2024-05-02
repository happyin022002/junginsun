/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : XterUsaCstmsFileNoVO.java
*@FileTitle : XterUsaCstmsFileNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.12 전용진
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * @author 전용진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class XterUsaCstmsFileNoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<XterUsaCstmsFileNoVO> models = new ArrayList<XterUsaCstmsFileNoVO>();

	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String scacCd = null;
	/* Column Info */
	private String usaCstmsFileNo = null;
	/* Column Info */
	private String pckQty = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public XterUsaCstmsFileNoVO() {}

	public XterUsaCstmsFileNoVO(String ibflag, String pagerows, String usaCstmsFileNo, String scacCd, String pckQty) {
		this.ibflag = ibflag;
		this.scacCd = scacCd;
		this.usaCstmsFileNo = usaCstmsFileNo;
		this.pckQty = pckQty;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("scac_cd", getScacCd());
		this.hashColumns.put("usa_cstms_file_no", getUsaCstmsFileNo());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("scac_cd", "scacCd");
		this.hashFields.put("usa_cstms_file_no", "usaCstmsFileNo");
		this.hashFields.put("pck_qty", "pckQty");
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
	 * @return scacCd
	 */
	public String getScacCd() {
		return this.scacCd;
	}

	/**
	 * Column Info
	 * @return usaCstmsFileNo
	 */
	public String getUsaCstmsFileNo() {
		return this.usaCstmsFileNo;
	}

	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
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
	 * @param scacCd
	 */
	public void setScacCd(String scacCd) {
		this.scacCd = scacCd;
	}

	/**
	 * Column Info
	 * @param usaCstmsFileNo
	 */
	public void setUsaCstmsFileNo(String usaCstmsFileNo) {
		this.usaCstmsFileNo = usaCstmsFileNo;
	}

	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
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
		setScacCd(JSPUtil.getParameter(request, "scac_cd", ""));
		setUsaCstmsFileNo(JSPUtil.getParameter(request, "usa_cstms_file_no", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return XterUsaCstmsFileNoVO[]
	 */
	public XterUsaCstmsFileNoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return XterUsaCstmsFileNoVO[]
	 */
	public XterUsaCstmsFileNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		XterUsaCstmsFileNoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] scacCd = (JSPUtil.getParameter(request, prefix	+ "scac_cd".trim(), length));
			String[] usaCstmsFileNo = (JSPUtil.getParameter(request, prefix	+ "usa_cstms_file_no".trim(), length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new XterUsaCstmsFileNoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (scacCd[i] != null)
					model.setScacCd(scacCd[i]);
				if (usaCstmsFileNo[i] != null)
					model.setUsaCstmsFileNo(usaCstmsFileNo[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getXterUsaCstmsFileNoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return XterUsaCstmsFileNoVO[]
	 */
	public XterUsaCstmsFileNoVO[] getXterUsaCstmsFileNoVOs(){
		XterUsaCstmsFileNoVO[] vos = (XterUsaCstmsFileNoVO[])models.toArray(new XterUsaCstmsFileNoVO[models.size()]);
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
		this.scacCd = this.scacCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaCstmsFileNo = this.usaCstmsFileNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

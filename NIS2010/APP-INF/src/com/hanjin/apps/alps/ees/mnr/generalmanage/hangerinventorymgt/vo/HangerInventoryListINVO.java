/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HangerInventoryListINVO.java
*@FileTitle : HangerInventoryListINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.10.13 함형석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.vo;

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
 * @author 함형석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class HangerInventoryListINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<HangerInventoryListINVO> models = new ArrayList<HangerInventoryListINVO>();
	
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String userOfcCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String month = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String arHdQtrCd = null;
	/* Column Info */
	private String arHdQtrOfcCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public HangerInventoryListINVO() {}

	public HangerInventoryListINVO(String ibflag, String pagerows, String userOfcCd, String ofcCd, String arHdQtrCd, String arHdQtrOfcCd, String fromDt, String month, String toDt) {
		this.toDt = toDt;
		this.userOfcCd = userOfcCd;
		this.ofcCd = ofcCd;
		this.fromDt = fromDt;
		this.month = month;
		this.ibflag = ibflag;
		this.arHdQtrCd = arHdQtrCd;
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("month", getMonth());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ar_hd_qtr_cd", getArHdQtrCd());
		this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("month", "month");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ar_hd_qtr_cd", "arHdQtrCd");
		this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return userOfcCd
	 */
	public String getUserOfcCd() {
		return this.userOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
	}

	/**
	 * Column Info
	 * @return month
	 */
	public String getMonth() {
		return this.month;
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
	 * @return arHdQtrCd
	 */
	public String getArHdQtrCd() {
		return this.arHdQtrCd;
	}

	/**
	 * Column Info
	 * @return arHdQtrOfcCd
	 */
	public String getArHdQtrOfcCd() {
		return this.arHdQtrOfcCd;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param userOfcCd
	 */
	public void setUserOfcCd(String userOfcCd) {
		this.userOfcCd = userOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}
	
	/**
	 * Column Info
//	 * @param month
	 */
	public void setMonth(String month) {
		this.month = month;
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
	 * @param arHdQtrCd
	 */
	public void setArHdQtrCd(String arHdQtrCd) {
		this.arHdQtrCd = arHdQtrCd;
	}

	/**
	 * Column Info
	 * @param arHdQtrOfcCd
	 */
	public void setArHdQtrOfcCd(String arHdQtrOfcCd) {
		this.arHdQtrOfcCd = arHdQtrOfcCd;
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
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setUserOfcCd(JSPUtil.getParameter(request, "user_ofc_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setFromDt(JSPUtil.getParameter(request, "from_dt", ""));
		setMonth(JSPUtil.getParameter(request, "month", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setArHdQtrCd(JSPUtil.getParameter(request, "ar_hd_qtr_cd", ""));
		setArHdQtrOfcCd(JSPUtil.getParameter(request, "ar_hd_qtr_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return HangerInventoryListINVO[]
	 */
	public HangerInventoryListINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return HangerInventoryListINVO[]
	 */
	public HangerInventoryListINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		HangerInventoryListINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] month = (JSPUtil.getParameter(request, prefix	+ "month", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] arHdQtrCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_cd", length));
			String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new HangerInventoryListINVO();
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (month[i] != null)
					model.setMonth(month[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (arHdQtrCd[i] != null)
					model.setArHdQtrCd(arHdQtrCd[i]);
				if (arHdQtrOfcCd[i] != null)
					model.setArHdQtrOfcCd(arHdQtrOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getHangerInventoryListINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return HangerInventoryListINVO[]
	 */
	public HangerInventoryListINVO[] getHangerInventoryListINVOs(){
		HangerInventoryListINVO[] vos = (HangerInventoryListINVO[])models.toArray(new HangerInventoryListINVO[models.size()]);
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
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.month = this.month .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrCd = this.arHdQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrOfcCd = this.arHdQtrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

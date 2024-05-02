/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MRIRevenueVVDLaneVO.java
*@FileTitle : MRIRevenueVVDLaneVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.06.03 정휘택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo;

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
 * @author 정휘택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MRIRevenueVVDLaneVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MRIRevenueVVDLaneVO> models = new ArrayList<MRIRevenueVVDLaneVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String revVvd = null;
	/* Column Info */
	private String revLane = null;
	/* Column Info */
	private String slaneCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MRIRevenueVVDLaneVO() {}

	public MRIRevenueVVDLaneVO(String ibflag, String pagerows, String revLane, String revVvd, String slaneCd) {
		this.ibflag = ibflag;
		this.revVvd = revVvd;
		this.revLane = revLane;
		this.slaneCd = slaneCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rev_vvd", getRevVvd());
		this.hashColumns.put("rev_lane", getRevLane());
		this.hashColumns.put("slan_cd", getSlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rev_vvd", "revVvd");
		this.hashFields.put("rev_lane", "revLane");
		this.hashColumns.put("slan_cd", "slaneCd");
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
	 * @return revVvd
	 */
	public String getRevVvd() {
		return this.revVvd;
	}
	
	/**
	 * Column Info
	 * @return revLane
	 */
	public String getRevLane() {
		return this.revLane;
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
	 * @param revVvd
	 */
	public void setRevVvd(String revVvd) {
		this.revVvd = revVvd;
	}
	
	/**
	 * Column Info
	 * @param revLane
	 */
	public void setRevLane(String revLane) {
		this.revLane = revLane;
	}

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * @return the slaneCd
	 */
	public String getSlaneCd() {
		return slaneCd;
	}

	/**
	 * @param slaneCd the slaneCd to set
	 */
	public void setSlaneCd(String slaneCd) {
		this.slaneCd = slaneCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRevVvd(JSPUtil.getParameter(request, "rev_vvd", ""));
		setRevLane(JSPUtil.getParameter(request, "rev_lane", ""));
		setSlaneCd(JSPUtil.getParameter(request, "slane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MRIRevenueVVDLaneVO[]
	 */
	public MRIRevenueVVDLaneVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MRIRevenueVVDLaneVO[]
	 */
	public MRIRevenueVVDLaneVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MRIRevenueVVDLaneVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] revVvd = (JSPUtil.getParameter(request, prefix	+ "rev_vvd".trim(), length));
			String[] revLane = (JSPUtil.getParameter(request, prefix	+ "rev_lane".trim(), length));
			String[] slaneCd = (JSPUtil.getParameter(request, prefix	+ "slane_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new MRIRevenueVVDLaneVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (revVvd[i] != null)
					model.setRevVvd(revVvd[i]);
				if (revLane[i] != null)
					model.setRevLane(revLane[i]);
				if (slaneCd[i] != null)
					model.setSlaneCd(slaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMRIRevenueVVDLaneVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MRIRevenueVVDLaneVO[]
	 */
	public MRIRevenueVVDLaneVO[] getMRIRevenueVVDLaneVOs(){
		MRIRevenueVVDLaneVO[] vos = (MRIRevenueVVDLaneVO[])models.toArray(new MRIRevenueVVDLaneVO[models.size()]);
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
		this.revVvd = this.revVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revLane = this.revLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slaneCd = this.slaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

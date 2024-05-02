/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChrgDtlVO.java
*@FileTitle : ChrgDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.07.01 최성환 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo;

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
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChrgDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChrgDtlVO> models = new ArrayList<ChrgDtlVO>();
	
	/* Column Info */
	private String rtChrg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rtRate = null;
	/* Column Info */
	private String rtCurCd = null;
	/* Column Info */
	private String rtOver = null;
	/* Column Info */
	private String rtUnder = null;
	/* Column Info */
	private String rtDay = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ChrgDtlVO() {}

	public ChrgDtlVO(String ibflag, String pagerows, String rtOver, String rtUnder, String rtRate, String rtDay, String rtChrg, String rtCurCd) {
		this.rtChrg = rtChrg;
		this.ibflag = ibflag;
		this.rtRate = rtRate;
		this.rtCurCd = rtCurCd;
		this.rtOver = rtOver;
		this.rtUnder = rtUnder;
		this.rtDay = rtDay;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rt_chrg", getRtChrg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rt_rate", getRtRate());
		this.hashColumns.put("rt_cur_cd", getRtCurCd());
		this.hashColumns.put("rt_over", getRtOver());
		this.hashColumns.put("rt_under", getRtUnder());
		this.hashColumns.put("rt_day", getRtDay());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rt_chrg", "rtChrg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rt_rate", "rtRate");
		this.hashFields.put("rt_cur_cd", "rtCurCd");
		this.hashFields.put("rt_over", "rtOver");
		this.hashFields.put("rt_under", "rtUnder");
		this.hashFields.put("rt_day", "rtDay");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rtChrg
	 */
	public String getRtChrg() {
		return this.rtChrg;
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
	 * @return rtRate
	 */
	public String getRtRate() {
		return this.rtRate;
	}
	
	/**
	 * Column Info
	 * @return rtCurCd
	 */
	public String getRtCurCd() {
		return this.rtCurCd;
	}
	
	/**
	 * Column Info
	 * @return rtOver
	 */
	public String getRtOver() {
		return this.rtOver;
	}
	
	/**
	 * Column Info
	 * @return rtUnder
	 */
	public String getRtUnder() {
		return this.rtUnder;
	}
	
	/**
	 * Column Info
	 * @return rtDay
	 */
	public String getRtDay() {
		return this.rtDay;
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
	 * @param rtChrg
	 */
	public void setRtChrg(String rtChrg) {
		this.rtChrg = rtChrg;
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
	 * @param rtRate
	 */
	public void setRtRate(String rtRate) {
		this.rtRate = rtRate;
	}
	
	/**
	 * Column Info
	 * @param rtCurCd
	 */
	public void setRtCurCd(String rtCurCd) {
		this.rtCurCd = rtCurCd;
	}
	
	/**
	 * Column Info
	 * @param rtOver
	 */
	public void setRtOver(String rtOver) {
		this.rtOver = rtOver;
	}
	
	/**
	 * Column Info
	 * @param rtUnder
	 */
	public void setRtUnder(String rtUnder) {
		this.rtUnder = rtUnder;
	}
	
	/**
	 * Column Info
	 * @param rtDay
	 */
	public void setRtDay(String rtDay) {
		this.rtDay = rtDay;
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
		setRtChrg(JSPUtil.getParameter(request, "rt_chrg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRtRate(JSPUtil.getParameter(request, "rt_rate", ""));
		setRtCurCd(JSPUtil.getParameter(request, "rt_cur_cd", ""));
		setRtOver(JSPUtil.getParameter(request, "rt_over", ""));
		setRtUnder(JSPUtil.getParameter(request, "rt_under", ""));
		setRtDay(JSPUtil.getParameter(request, "rt_day", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChrgDtlVO[]
	 */
	public ChrgDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChrgDtlVO[]
	 */
	public ChrgDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChrgDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rtChrg = (JSPUtil.getParameter(request, prefix	+ "rt_chrg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rtRate = (JSPUtil.getParameter(request, prefix	+ "rt_rate", length));
			String[] rtCurCd = (JSPUtil.getParameter(request, prefix	+ "rt_cur_cd", length));
			String[] rtOver = (JSPUtil.getParameter(request, prefix	+ "rt_over", length));
			String[] rtUnder = (JSPUtil.getParameter(request, prefix	+ "rt_under", length));
			String[] rtDay = (JSPUtil.getParameter(request, prefix	+ "rt_day", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChrgDtlVO();
				if (rtChrg[i] != null)
					model.setRtChrg(rtChrg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rtRate[i] != null)
					model.setRtRate(rtRate[i]);
				if (rtCurCd[i] != null)
					model.setRtCurCd(rtCurCd[i]);
				if (rtOver[i] != null)
					model.setRtOver(rtOver[i]);
				if (rtUnder[i] != null)
					model.setRtUnder(rtUnder[i]);
				if (rtDay[i] != null)
					model.setRtDay(rtDay[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChrgDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChrgDtlVO[]
	 */
	public ChrgDtlVO[] getChrgDtlVOs(){
		ChrgDtlVO[] vos = (ChrgDtlVO[])models.toArray(new ChrgDtlVO[models.size()]);
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
		this.rtChrg = this.rtChrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRate = this.rtRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtCurCd = this.rtCurCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtOver = this.rtOver .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtUnder = this.rtUnder .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtDay = this.rtDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

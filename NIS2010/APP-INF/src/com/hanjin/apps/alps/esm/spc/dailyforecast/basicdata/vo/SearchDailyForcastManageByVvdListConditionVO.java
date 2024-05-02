/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchDailyForcastManageByVvdListConditionVO.java
*@FileTitle : SearchDailyForcastManageByVvdListConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.07.27 한상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.vo;

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
 * @author 한상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchDailyForcastManageByVvdListConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchDailyForcastManageByVvdListConditionVO> models = new ArrayList<SearchDailyForcastManageByVvdListConditionVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String subtrade = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trade = null;
	/* Column Info */
	private String ocnipc = null;
	/* Column Info */
	private String bound = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String rhq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchDailyForcastManageByVvdListConditionVO() {}

	public SearchDailyForcastManageByVvdListConditionVO(String ibflag, String pagerows, String vvd, String trade, String rhq, String subtrade, String lane, String bound, String ocnipc) {
		this.vvd = vvd;
		this.subtrade = subtrade;
		this.ibflag = ibflag;
		this.trade = trade;
		this.ocnipc = ocnipc;
		this.bound = bound;
		this.lane = lane;
		this.rhq = rhq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("subtrade", getSubtrade());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trade", getTrade());
		this.hashColumns.put("ocnipc", getOcnipc());
		this.hashColumns.put("bound", getBound());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("subtrade", "subtrade");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trade", "trade");
		this.hashFields.put("ocnipc", "ocnipc");
		this.hashFields.put("bound", "bound");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return subtrade
	 */
	public String getSubtrade() {
		return this.subtrade;
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
	 * @return trade
	 */
	public String getTrade() {
		return this.trade;
	}
	
	/**
	 * Column Info
	 * @return ocnipc
	 */
	public String getOcnipc() {
		return this.ocnipc;
	}
	
	/**
	 * Column Info
	 * @return bound
	 */
	public String getBound() {
		return this.bound;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param subtrade
	 */
	public void setSubtrade(String subtrade) {
		this.subtrade = subtrade;
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
	 * @param trade
	 */
	public void setTrade(String trade) {
		this.trade = trade;
	}
	
	/**
	 * Column Info
	 * @param ocnipc
	 */
	public void setOcnipc(String ocnipc) {
		this.ocnipc = ocnipc;
	}
	
	/**
	 * Column Info
	 * @param bound
	 */
	public void setBound(String bound) {
		this.bound = bound;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
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
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setSubtrade(JSPUtil.getParameter(request, "subtrade", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTrade(JSPUtil.getParameter(request, "trade", ""));
		setOcnipc(JSPUtil.getParameter(request, "ocnipc", ""));
		setBound(JSPUtil.getParameter(request, "bound", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setRhq(JSPUtil.getParameter(request, "rhq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchDailyForcastManageByVvdListConditionVO[]
	 */
	public SearchDailyForcastManageByVvdListConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchDailyForcastManageByVvdListConditionVO[]
	 */
	public SearchDailyForcastManageByVvdListConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchDailyForcastManageByVvdListConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] subtrade = (JSPUtil.getParameter(request, prefix	+ "subtrade", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] trade = (JSPUtil.getParameter(request, prefix	+ "trade", length));
			String[] ocnipc = (JSPUtil.getParameter(request, prefix	+ "ocnipc", length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchDailyForcastManageByVvdListConditionVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (subtrade[i] != null)
					model.setSubtrade(subtrade[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trade[i] != null)
					model.setTrade(trade[i]);
				if (ocnipc[i] != null)
					model.setOcnipc(ocnipc[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchDailyForcastManageByVvdListConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchDailyForcastManageByVvdListConditionVO[]
	 */
	public SearchDailyForcastManageByVvdListConditionVO[] getSearchDailyForcastManageByVvdListConditionVOs(){
		SearchDailyForcastManageByVvdListConditionVO[] vos = (SearchDailyForcastManageByVvdListConditionVO[])models.toArray(new SearchDailyForcastManageByVvdListConditionVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subtrade = this.subtrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade = this.trade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocnipc = this.ocnipc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

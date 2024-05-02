/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0138ConditionVO.java
*@FileTitle : Constraint by Lane/ECC
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Lee Byoung Hun	2009.08.12		1.0 최초 생성
*
*@LastModifyDate : 2009.08.12
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.08.12  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.scenariomanage.repoconstraint.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0138ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0138ConditionVO> models = new ArrayList<EesEqr0138ConditionVO>();
	
	/* Column Info */
	private String yyyyww = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tpsz = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String loctype = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String loc = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0138ConditionVO() {}

	public EesEqr0138ConditionVO(String ibflag, String pagerows, String yyyyww, String seq, String loc, String loctype, String status, String lane, String tpsz) {
		this.yyyyww = yyyyww;
		this.ibflag = ibflag;
		this.tpsz = tpsz;
		this.status = status;
		this.loctype = loctype;
		this.seq = seq;
		this.loc = loc;
		this.lane = lane;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("yyyyww", getYyyyww());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tpsz", getTpsz());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("loctype", getLoctype());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("loc", getLoc());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tpsz", "tpsz");
		this.hashFields.put("status", "status");
		this.hashFields.put("loctype", "loctype");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("loc", "loc");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return yyyyww
	 */
	public String getYyyyww() {
		return this.yyyyww;
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
	 * @return tpsz
	 */
	public String getTpsz() {
		return this.tpsz;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return loctype
	 */
	public String getLoctype() {
		return this.loctype;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return loc
	 */
	public String getLoc() {
		return this.loc;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @param yyyyww
	 */
	public void setYyyyww(String yyyyww) {
		this.yyyyww = yyyyww;
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
	 * @param tpsz
	 */
	public void setTpsz(String tpsz) {
		this.tpsz = tpsz;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param loctype
	 */
	public void setLoctype(String loctype) {
		this.loctype = loctype;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param loc
	 */
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
		setYyyyww(JSPUtil.getParameter(request, "yyyyww", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTpsz(JSPUtil.getParameter(request, "tpsz", ""));
		setStatus(JSPUtil.getParameter(request, "status_type", ""));
		setLoctype(JSPUtil.getParameter(request, "loctype", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setLoc(JSPUtil.getParameter(request, "LOC", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0138ConditionVO[]
	 */
	public EesEqr0138ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0138ConditionVO[]
	 */
	public EesEqr0138ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0138ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] yyyyww = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tpsz = (JSPUtil.getParameter(request, prefix	+ "tpsz", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] loctype = (JSPUtil.getParameter(request, prefix	+ "loctype", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] loc = (JSPUtil.getParameter(request, prefix	+ "loc", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0138ConditionVO();
				if (yyyyww[i] != null)
					model.setYyyyww(yyyyww[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tpsz[i] != null)
					model.setTpsz(tpsz[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (loctype[i] != null)
					model.setLoctype(loctype[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (loc[i] != null)
					model.setLoc(loc[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0138ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0138ConditionVO[]
	 */
	public EesEqr0138ConditionVO[] getEesEqr0138ConditionVOs(){
		EesEqr0138ConditionVO[] vos = (EesEqr0138ConditionVO[])models.toArray(new EesEqr0138ConditionVO[models.size()]);
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
		this.yyyyww = this.yyyyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsz = this.tpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loctype = this.loctype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loc = this.loc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

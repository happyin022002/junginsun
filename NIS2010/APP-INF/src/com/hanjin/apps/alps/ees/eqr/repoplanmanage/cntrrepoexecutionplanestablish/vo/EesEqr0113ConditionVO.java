/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0113ConditionVO.java
*@FileTitle : EesEqr0113ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.20 정은호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo;

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
 * @author 정은호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0113ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0113ConditionVO> models = new ArrayList<EesEqr0113ConditionVO>();
	
	/* Column Info */
	private String frdtYY = null;
	/* Column Info */
	private String comp = null;
	/* Column Info */
	private String locList = null;
	/* Column Info */
	private String frdtMM = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String yyyyww = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String todtMM = null;
	/* Column Info */
	private String todtYY = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String loccd = null;
	/* Column Info */
	private String TypeBy = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0113ConditionVO() {}

	public EesEqr0113ConditionVO(String ibflag, String pagerows, String yyyyww, String seq, String loccd, String locList, String TypeBy, String frdtYY, String frdtMM, String todtYY, String todtMM, String lane, String vvd, String comp) {
		this.frdtYY = frdtYY;
		this.comp = comp;
		this.locList = locList;
		this.frdtMM = frdtMM;
		this.pagerows = pagerows;
		this.lane = lane;
		this.yyyyww = yyyyww;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.todtMM = todtMM;
		this.todtYY = todtYY;
		this.seq = seq;
		this.loccd = loccd;
		this.TypeBy = TypeBy;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("frdtYY", getFrdtYY());
		this.hashColumns.put("comp", getComp());
		this.hashColumns.put("locList", getLocList());
		this.hashColumns.put("frdtMM", getFrdtMM());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("yyyyww", getYyyyww());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("todtMM", getTodtMM());
		this.hashColumns.put("todtYY", getTodtYY());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("locCd", getLoccd());
		this.hashColumns.put("TypeBy", getTypeBy());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("frdtYY", "frdtYY");
		this.hashFields.put("comp", "comp");
		this.hashFields.put("locList", "locList");
		this.hashFields.put("frdtMM", "frdtMM");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("todtMM", "todtMM");
		this.hashFields.put("todtYY", "todtYY");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("locCd", "loccd");
		this.hashFields.put("TypeBy", "TypeBy");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return frdtYY
	 */
	public String getFrdtYY() {
		return this.frdtYY;
	}
	
	/**
	 * Column Info
	 * @return comp
	 */
	public String getComp() {
		return this.comp;
	}
	
	/**
	 * Column Info
	 * @return locList
	 */
	public String getLocList() {
		return this.locList;
	}
	
	/**
	 * Column Info
	 * @return frdtMM
	 */
	public String getFrdtMM() {
		return this.frdtMM;
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
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
	}
	
	/**
	 * Column Info
	 * @return yyyyww
	 */
	public String getYyyyww() {
		return this.yyyyww;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return todtMM
	 */
	public String getTodtMM() {
		return this.todtMM;
	}
	
	/**
	 * Column Info
	 * @return todtYY
	 */
	public String getTodtYY() {
		return this.todtYY;
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
	 * @return loccd
	 */
	public String getLoccd() {
		return this.loccd;
	}
	
	/**
	 * Column Info
	 * @return TypeBy
	 */
	public String getTypeBy() {
		return this.TypeBy;
	}
	

	/**
	 * Column Info
	 * @param frdtYY
	 */
	public void setFrdtYY(String frdtYY) {
		this.frdtYY = frdtYY;
	}
	
	/**
	 * Column Info
	 * @param comp
	 */
	public void setComp(String comp) {
		this.comp = comp;
	}
	
	/**
	 * Column Info
	 * @param locList
	 */
	public void setLocList(String locList) {
		this.locList = locList;
	}
	
	/**
	 * Column Info
	 * @param frdtMM
	 */
	public void setFrdtMM(String frdtMM) {
		this.frdtMM = frdtMM;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param yyyyww
	 */
	public void setYyyyww(String yyyyww) {
		this.yyyyww = yyyyww;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param todtMM
	 */
	public void setTodtMM(String todtMM) {
		this.todtMM = todtMM;
	}
	
	/**
	 * Column Info
	 * @param todtYY
	 */
	public void setTodtYY(String todtYY) {
		this.todtYY = todtYY;
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
	 * @param loccd
	 */
	public void setLoccd(String loccd) {
		this.loccd = loccd;
	}
	
	/**
	 * Column Info
	 * @param TypeBy
	 */
	public void setTypeBy(String TypeBy) {
		this.TypeBy = TypeBy;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFrdtYY(JSPUtil.getParameter(request, "frdtYY", ""));
		setComp(JSPUtil.getParameter(request, "comp", ""));
		setLocList(JSPUtil.getParameter(request, "locList", ""));
		setFrdtMM(JSPUtil.getParameter(request, "frdtMM", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setYyyyww(JSPUtil.getParameter(request, "yyyyww", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTodtMM(JSPUtil.getParameter(request, "todtMM", ""));
		setTodtYY(JSPUtil.getParameter(request, "todtYY", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setLoccd(JSPUtil.getParameter(request, "loccd", ""));
		setTypeBy(JSPUtil.getParameter(request, "TypeBy", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0113ConditionVO[]
	 */
	public EesEqr0113ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0113ConditionVO[]
	 */
	public EesEqr0113ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0113ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] frdtYY = (JSPUtil.getParameter(request, prefix	+ "frdtYY", length));
			String[] comp = (JSPUtil.getParameter(request, prefix	+ "comp", length));
			String[] locList = (JSPUtil.getParameter(request, prefix	+ "locList", length));
			String[] frdtMM = (JSPUtil.getParameter(request, prefix	+ "frdtMM", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] yyyyww = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] todtMM = (JSPUtil.getParameter(request, prefix	+ "todtMM", length));
			String[] todtYY = (JSPUtil.getParameter(request, prefix	+ "todtYY", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] loccd = (JSPUtil.getParameter(request, prefix	+ "loccd", length));
			String[] TypeBy = (JSPUtil.getParameter(request, prefix	+ "TypeBy", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0113ConditionVO();
				if (frdtYY[i] != null)
					model.setFrdtYY(frdtYY[i]);
				if (comp[i] != null)
					model.setComp(comp[i]);
				if (locList[i] != null)
					model.setLocList(locList[i]);
				if (frdtMM[i] != null)
					model.setFrdtMM(frdtMM[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (yyyyww[i] != null)
					model.setYyyyww(yyyyww[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (todtMM[i] != null)
					model.setTodtMM(todtMM[i]);
				if (todtYY[i] != null)
					model.setTodtYY(todtYY[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (loccd[i] != null)
					model.setLoccd(loccd[i]);
				if (TypeBy[i] != null)
					model.setTypeBy(TypeBy[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0113ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0113ConditionVO[]
	 */
	public EesEqr0113ConditionVO[] getEesEqr0113ConditionVOs(){
		EesEqr0113ConditionVO[] vos = (EesEqr0113ConditionVO[])models.toArray(new EesEqr0113ConditionVO[models.size()]);
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
		this.frdtYY = this.frdtYY .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comp = this.comp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locList = this.locList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frdtMM = this.frdtMM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww = this.yyyyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.todtMM = this.todtMM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.todtYY = this.todtYY .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loccd = this.loccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.TypeBy = this.TypeBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

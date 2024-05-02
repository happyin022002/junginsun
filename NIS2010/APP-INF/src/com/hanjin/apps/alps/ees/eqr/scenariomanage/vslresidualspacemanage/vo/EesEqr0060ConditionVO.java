/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0060ConditionVO.java
*@FileTitle : EesEqr0060ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.11 이행지 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.vo;

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
 * @author 이행지
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0060ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0060ConditionVO> models = new ArrayList<EesEqr0060ConditionVO>();
	
	/* Column Info */
	private String frdtyy = null;
	/* Column Info */
	private String gubun = null;
	/* Column Info */
	private String scnrId = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String location = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String frdtmm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String vslLaneCd = null;
	/* Column Info */
	private String frweek = null;
	/* Column Info */
	private String yyyyww = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String toweek = null;
	/* Column Info */
	private String todtmm = null;
	/* Column Info */
	private String todtyy = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String typeby = null;
	/* Column Info */
	private String row = null;
	/* Column Info */
	private String col = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0060ConditionVO() {}

	public EesEqr0060ConditionVO(String ibflag, String pagerows, String yyyyww, String seq, String scnrId, String status, String location, String typeby, String lane, String vvd, String frdtyy, String frdtmm, String todtyy, String todtmm, String frweek, String toweek, String gubun, String eccCd, String vslLaneCd, String row, String col) {
		this.frdtyy = frdtyy;
		this.gubun = gubun;
		this.scnrId = scnrId;
		this.status = status;
		this.location = location;
		this.eccCd = eccCd;
		this.frdtmm = frdtmm;
		this.pagerows = pagerows;
		this.lane = lane;
		this.vslLaneCd = vslLaneCd;
		this.frweek = frweek;
		this.yyyyww = yyyyww;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.toweek = toweek;
		this.todtmm = todtmm;
		this.todtyy = todtyy;
		this.seq = seq;
		this.typeby = typeby;
		this.row = row;
		this.col = col;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("frdtyy", getFrdtyy());
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("scnr_id", getScnrId());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("location", getLocation());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("frdtmm", getFrdtmm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("vsl_lane_cd", getVslLaneCd());
		this.hashColumns.put("frweek", getFrweek());
		this.hashColumns.put("yyyyww", getYyyyww());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("toweek", getToweek());
		this.hashColumns.put("todtmm", getTodtmm());
		this.hashColumns.put("todtyy", getTodtyy());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("typeby", getTypeby());
		this.hashColumns.put("row", getRow());
		this.hashColumns.put("col", getCol());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("frdtyy", "frdtyy");
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("scnr_id", "scnrId");
		this.hashFields.put("status", "status");
		this.hashFields.put("location", "location");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("frdtmm", "frdtmm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("vsl_lane_cd", "vslLaneCd");
		this.hashFields.put("frweek", "frweek");
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("toweek", "toweek");
		this.hashFields.put("todtmm", "todtmm");
		this.hashFields.put("todtyy", "todtyy");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("typeby", "typeby");
		this.hashFields.put("row", "row");
		this.hashFields.put("col", "col");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return frdtyy
	 */
	public String getFrdtyy() {
		return this.frdtyy;
	}
	
	/**
	 * Column Info
	 * @return gubun
	 */
	public String getGubun() {
		return this.gubun;
	}
	
	/**
	 * Column Info
	 * @return scnrId
	 */
	public String getScnrId() {
		return this.scnrId;
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
	 * @return location
	 */
	public String getLocation() {
		return this.location;
	}
	
	/**
	 * Column Info
	 * @return eccCd
	 */
	public String getEccCd() {
		return this.eccCd;
	}
	
	/**
	 * Column Info
	 * @return frdtmm
	 */
	public String getFrdtmm() {
		return this.frdtmm;
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
	 * @return vslLaneCd
	 */
	public String getVslLaneCd() {
		return this.vslLaneCd;
	}
	
	/**
	 * Column Info
	 * @return frweek
	 */
	public String getFrweek() {
		return this.frweek;
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
	 * @return toweek
	 */
	public String getToweek() {
		return this.toweek;
	}
	
	/**
	 * Column Info
	 * @return todtmm
	 */
	public String getTodtmm() {
		return this.todtmm;
	}
	
	/**
	 * Column Info
	 * @return todtyy
	 */
	public String getTodtyy() {
		return this.todtyy;
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
	 * @return typeby
	 */
	public String getTypeby() {
		return this.typeby;
	}
	

	public String getRow() {
		return row;
	}

	
	public String getCol() {
		return col;
	}

	public void setCol(String col) {
		this.col = col;
	}

	public void setRow(String row) {
		this.row = row;
	}

	/**
	 * Column Info
	 * @param frdtyy
	 */
	public void setFrdtyy(String frdtyy) {
		this.frdtyy = frdtyy;
	}
	
	/**
	 * Column Info
	 * @param gubun
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	
	/**
	 * Column Info
	 * @param scnrId
	 */
	public void setScnrId(String scnrId) {
		this.scnrId = scnrId;
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
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Column Info
	 * @param eccCd
	 */
	public void setEccCd(String eccCd) {
		this.eccCd = eccCd;
	}
	
	/**
	 * Column Info
	 * @param frdtmm
	 */
	public void setFrdtmm(String frdtmm) {
		this.frdtmm = frdtmm;
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
	 * @param vslLaneCd
	 */
	public void setVslLaneCd(String vslLaneCd) {
		this.vslLaneCd = vslLaneCd;
	}
	
	/**
	 * Column Info
	 * @param frweek
	 */
	public void setFrweek(String frweek) {
		this.frweek = frweek;
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
	 * @param toweek
	 */
	public void setToweek(String toweek) {
		this.toweek = toweek;
	}
	
	/**
	 * Column Info
	 * @param todtmm
	 */
	public void setTodtmm(String todtmm) {
		this.todtmm = todtmm;
	}
	
	/**
	 * Column Info
	 * @param todtyy
	 */
	public void setTodtyy(String todtyy) {
		this.todtyy = todtyy;
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
	 * @param typeby
	 */
	public void setTypeby(String typeby) {
		this.typeby = typeby;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setYyyyww(JSPUtil.getParameter(request, "yyyyww", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setScnrId(JSPUtil.getParameter(request, "scnr_id", ""));
		setStatus(JSPUtil.getParameter(request, "status", ""));
		setLocation(JSPUtil.getParameter(request, "location", ""));
		setTypeby(JSPUtil.getParameter(request, "TypeBy", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));		
		setFrdtyy(JSPUtil.getParameter(request, "frdtYY", ""));
		setFrdtmm(JSPUtil.getParameter(request, "frdtMM", ""));
		setTodtmm(JSPUtil.getParameter(request, "todtMM", ""));
		setTodtyy(JSPUtil.getParameter(request, "todtYY", ""));		
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));		
		setFrweek(JSPUtil.getParameter(request, "frweek", ""));
		setToweek(JSPUtil.getParameter(request, "toweek", ""));		
		setGubun(JSPUtil.getParameter(request, "gubun", ""));
		setEccCd(JSPUtil.getParameter(request, "ecc_cd", ""));
		setVslLaneCd(JSPUtil.getParameter(request, "vsl_lane_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setRow(JSPUtil.getParameter(request, "row", ""));
		setCol(JSPUtil.getParameter(request, "col", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0060ConditionVO[]
	 */
	public EesEqr0060ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0060ConditionVO[]
	 */
	public EesEqr0060ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0060ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] frdtyy = (JSPUtil.getParameter(request, prefix	+ "frdtyy", length));
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun", length));
			String[] scnrId = (JSPUtil.getParameter(request, prefix	+ "scnr_id", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] location = (JSPUtil.getParameter(request, prefix	+ "location", length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd", length));
			String[] frdtmm = (JSPUtil.getParameter(request, prefix	+ "frdtmm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] vslLaneCd = (JSPUtil.getParameter(request, prefix	+ "vsl_lane_cd", length));
			String[] frweek = (JSPUtil.getParameter(request, prefix	+ "frweek", length));
			String[] yyyyww = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] toweek = (JSPUtil.getParameter(request, prefix	+ "toweek", length));
			String[] todtmm = (JSPUtil.getParameter(request, prefix	+ "todtmm", length));
			String[] todtyy = (JSPUtil.getParameter(request, prefix	+ "todtyy", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] typeby = (JSPUtil.getParameter(request, prefix	+ "typeby", length));
			String[] row = (JSPUtil.getParameter(request, prefix	+ "row", length));
			String[] col = (JSPUtil.getParameter(request, prefix	+ "col", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0060ConditionVO();
				if (frdtyy[i] != null)
					model.setFrdtyy(frdtyy[i]);
				if (gubun[i] != null)
					model.setGubun(gubun[i]);
				if (scnrId[i] != null)
					model.setScnrId(scnrId[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (location[i] != null)
					model.setLocation(location[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (frdtmm[i] != null)
					model.setFrdtmm(frdtmm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (vslLaneCd[i] != null)
					model.setVslLaneCd(vslLaneCd[i]);
				if (frweek[i] != null)
					model.setFrweek(frweek[i]);
				if (yyyyww[i] != null)
					model.setYyyyww(yyyyww[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (toweek[i] != null)
					model.setToweek(toweek[i]);
				if (todtmm[i] != null)
					model.setTodtmm(todtmm[i]);
				if (todtyy[i] != null)
					model.setTodtyy(todtyy[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (typeby[i] != null)
					model.setTypeby(typeby[i]);
				if (row[i] != null)
					model.setRow(row[i]);
				if (col[i] != null)
					model.setCol(col[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0060ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0060ConditionVO[]
	 */
	public EesEqr0060ConditionVO[] getEesEqr0060ConditionVOs(){
		EesEqr0060ConditionVO[] vos = (EesEqr0060ConditionVO[])models.toArray(new EesEqr0060ConditionVO[models.size()]);
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
		this.frdtyy = this.frdtyy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubun = this.gubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrId = this.scnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.location = this.location .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frdtmm = this.frdtmm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLaneCd = this.vslLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frweek = this.frweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww = this.yyyyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toweek = this.toweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.todtmm = this.todtmm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.todtyy = this.todtyy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeby = this.typeby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.row = this.row .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col = this.col .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

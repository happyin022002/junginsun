/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0026ConditionVO.java
*@FileTitle : EesEqr0026ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.12 이행지 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrsafetystockmanage.vo;

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

public class EesEqr0026ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0026ConditionVO> models = new ArrayList<EesEqr0026ConditionVO>();
	
	/* Column Info */
	private String col = null;
	/* Column Info */
	private String scnrId = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String location = null;
	/* Column Info */
	private String statusType = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String fCmd = null;
	/* Column Info */
	private String sfstkLvlCd = null;
	/* Column Info */
	private String row = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String yyyyww = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String levelCd = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String tpsztype = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0026ConditionVO() {}

	public EesEqr0026ConditionVO(String ibflag, String pagerows, String yyyyww, String seq, String scnrId, String status, String location, String tpsztype, String levelCd, String statusType, String col, String sfstkLvlCd, String eccCd, String fCmd, String row) {
		this.col = col;
		this.scnrId = scnrId;
		this.status = status;
		this.location = location;
		this.statusType = statusType;
		this.eccCd = eccCd;
		this.fCmd = fCmd;
		this.sfstkLvlCd = sfstkLvlCd;
		this.row = row;
		this.pagerows = pagerows;
		this.yyyyww = yyyyww;
		this.ibflag = ibflag;
		this.levelCd = levelCd;
		this.seq = seq;
		this.tpsztype = tpsztype;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("col", getCol());
		this.hashColumns.put("scnr_id", getScnrId());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("location", getLocation());
		this.hashColumns.put("status_type", getStatusType());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("f_cmd", getFCmd());
		this.hashColumns.put("sfstk_lvl_cd", getSfstkLvlCd());
		this.hashColumns.put("row", getRow());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("yyyyww", getYyyyww());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("level_cd", getLevelCd());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("tpsztype", getTpsztype());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("col", "col");
		this.hashFields.put("scnr_id", "scnrId");
		this.hashFields.put("status", "status");
		this.hashFields.put("location", "location");
		this.hashFields.put("status_type", "statusType");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("f_cmd", "fCmd");
		this.hashFields.put("sfstk_lvl_cd", "sfstkLvlCd");
		this.hashFields.put("row", "row");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("level_cd", "levelCd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("tpsztype", "tpsztype");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return col
	 */
	public String getCol() {
		return this.col;
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
	 * @return statusType
	 */
	public String getStatusType() {
		return this.statusType;
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
	 * @return fCmd
	 */
	public String getFCmd() {
		return this.fCmd;
	}
	
	/**
	 * Column Info
	 * @return sfstkLvlCd
	 */
	public String getSfstkLvlCd() {
		return this.sfstkLvlCd;
	}
	
	/**
	 * Column Info
	 * @return row
	 */
	public String getRow() {
		return this.row;
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
	 * @return levelCd
	 */
	public String getLevelCd() {
		return this.levelCd;
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
	 * @return tpsztype
	 */
	public String getTpsztype() {
		return this.tpsztype;
	}
	

	/**
	 * Column Info
	 * @param col
	 */
	public void setCol(String col) {
		this.col = col;
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
	 * @param statusType
	 */
	public void setStatusType(String statusType) {
		this.statusType = statusType;
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
	 * @param fCmd
	 */
	public void setFCmd(String fCmd) {
		this.fCmd = fCmd;
	}
	
	/**
	 * Column Info
	 * @param sfstkLvlCd
	 */
	public void setSfstkLvlCd(String sfstkLvlCd) {
		this.sfstkLvlCd = sfstkLvlCd;
	}
	
	/**
	 * Column Info
	 * @param row
	 */
	public void setRow(String row) {
		this.row = row;
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
	 * @param levelCd
	 */
	public void setLevelCd(String levelCd) {
		this.levelCd = levelCd;
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
	 * @param tpsztype
	 */
	public void setTpsztype(String tpsztype) {
		this.tpsztype = tpsztype;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCol(JSPUtil.getParameter(request, "col", ""));
		setScnrId(JSPUtil.getParameter(request, "scnr_id", ""));
		setStatus(JSPUtil.getParameter(request, "status", ""));
		setLocation(JSPUtil.getParameter(request, "location", ""));
		setStatusType(JSPUtil.getParameter(request, "status_type", ""));
		setEccCd(JSPUtil.getParameter(request, "ecc_cd", ""));
		setFCmd(JSPUtil.getParameter(request, "f_cmd", ""));
		setSfstkLvlCd(JSPUtil.getParameter(request, "sfstk_lvl_cd", ""));
		setRow(JSPUtil.getParameter(request, "row", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setYyyyww(JSPUtil.getParameter(request, "yyyyww", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLevelCd(JSPUtil.getParameter(request, "level_cd", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setTpsztype(JSPUtil.getParameter(request, "tpsztype", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0026ConditionVO[]
	 */
	public EesEqr0026ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0026ConditionVO[]
	 */
	public EesEqr0026ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0026ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] col = (JSPUtil.getParameter(request, prefix	+ "col", length));
			String[] scnrId = (JSPUtil.getParameter(request, prefix	+ "scnr_id", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] location = (JSPUtil.getParameter(request, prefix	+ "location", length));
			String[] statusType = (JSPUtil.getParameter(request, prefix	+ "status_type", length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd", length));
			String[] fCmd = (JSPUtil.getParameter(request, prefix	+ "f_cmd", length));
			String[] sfstkLvlCd = (JSPUtil.getParameter(request, prefix	+ "sfstk_lvl_cd", length));
			String[] row = (JSPUtil.getParameter(request, prefix	+ "row", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] yyyyww = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] levelCd = (JSPUtil.getParameter(request, prefix	+ "level_cd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] tpsztype = (JSPUtil.getParameter(request, prefix	+ "tpsztype", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0026ConditionVO();
				if (col[i] != null)
					model.setCol(col[i]);
				if (scnrId[i] != null)
					model.setScnrId(scnrId[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (location[i] != null)
					model.setLocation(location[i]);
				if (statusType[i] != null)
					model.setStatusType(statusType[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (fCmd[i] != null)
					model.setFCmd(fCmd[i]);
				if (sfstkLvlCd[i] != null)
					model.setSfstkLvlCd(sfstkLvlCd[i]);
				if (row[i] != null)
					model.setRow(row[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (yyyyww[i] != null)
					model.setYyyyww(yyyyww[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (levelCd[i] != null)
					model.setLevelCd(levelCd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (tpsztype[i] != null)
					model.setTpsztype(tpsztype[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0026ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0026ConditionVO[]
	 */
	public EesEqr0026ConditionVO[] getEesEqr0026ConditionVOs(){
		EesEqr0026ConditionVO[] vos = (EesEqr0026ConditionVO[])models.toArray(new EesEqr0026ConditionVO[models.size()]);
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
		this.col = this.col .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrId = this.scnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.location = this.location .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.statusType = this.statusType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCmd = this.fCmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sfstkLvlCd = this.sfstkLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.row = this.row .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww = this.yyyyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.levelCd = this.levelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsztype = this.tpsztype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

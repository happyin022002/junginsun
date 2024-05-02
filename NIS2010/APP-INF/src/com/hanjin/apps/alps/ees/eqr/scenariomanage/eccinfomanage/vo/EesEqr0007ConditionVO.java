/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0007ConditionVO.java
*@FileTitle : EesEqr0007ConditionVO
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Lee Byoung Hun	2009.07.21		1.0 최초 생성
*
*@LastModifyDate : 2009.07.21
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.07.21  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.scenariomanage.eccinfomanage.vo;

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

public class EesEqr0007ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0007ConditionVO> models = new ArrayList<EesEqr0007ConditionVO>();
	
	/* Column Info */
	private String scnrRmk = null;
	/* Column Info */
	private String yyyyww = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String scnrId = null;
	/* Column Info */
	private String location = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String seq = null;
	/* Page Number */
	private String pagerows = null;
	/* ETC Data */
	private String statusType = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0007ConditionVO() {}

	public EesEqr0007ConditionVO(String ibflag, String pagerows, String status, String location, String yyyyww, String seq, String eccCd, String scnrId, String scnrRmk) {
		this.scnrRmk = scnrRmk;
		this.yyyyww = yyyyww;
		this.ibflag = ibflag;
		this.scnrId = scnrId;
		this.location = location;
		this.status = status;
		this.eccCd = eccCd;
		this.seq = seq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("scnr_rmk", getScnrRmk());
		this.hashColumns.put("yyyyww", getYyyyww());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("scnr_id", getScnrId());
		this.hashColumns.put("location", getLocation());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("scnr_rmk", "scnrRmk");
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("scnr_id", "scnrId");
		this.hashFields.put("location", "location");
		this.hashFields.put("status", "status");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return scnrRmk
	 */
	public String getScnrRmk() {
		return this.scnrRmk;
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
	 * @return scnrId
	 */
	public String getScnrId() {
		return this.scnrId;
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
	 * @return status
	 */
	public String getStatus() {
		return this.status;
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
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
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
	 * @param scnrRmk
	 */
	public void setScnrRmk(String scnrRmk) {
		this.scnrRmk = scnrRmk;
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
	 * @param scnrId
	 */
	public void setScnrId(String scnrId) {
		this.scnrId = scnrId;
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
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
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
		setScnrRmk(JSPUtil.getParameter(request, "scnr_rmk", ""));
		setYyyyww(JSPUtil.getParameter(request, "yyyyww", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setScnrId(JSPUtil.getParameter(request, "scnr_id", ""));
		setLocation(JSPUtil.getParameter(request, "location", ""));
		setStatus(JSPUtil.getParameter(request, "status", ""));
		setEccCd(JSPUtil.getParameter(request, "ecc_cd", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return aaVO[]
	 */
	public EesEqr0007ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return aaVO[]
	 */
	public EesEqr0007ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0007ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] scnrRmk = (JSPUtil.getParameter(request, prefix	+ "scnr_rmk", length));
			String[] yyyyww = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] scnrId = (JSPUtil.getParameter(request, prefix	+ "scnr_id", length));
			String[] location = (JSPUtil.getParameter(request, prefix	+ "location", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0007ConditionVO();
				if (scnrRmk[i] != null)
					model.setScnrRmk(scnrRmk[i]);
				if (yyyyww[i] != null)
					model.setYyyyww(yyyyww[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (scnrId[i] != null)
					model.setScnrId(scnrId[i]);
				if (location[i] != null)
					model.setLocation(location[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getaaVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return aaVO[]
	 */
	public EesEqr0007ConditionVO[] getaaVOs(){
		EesEqr0007ConditionVO[] vos = (EesEqr0007ConditionVO[])models.toArray(new EesEqr0007ConditionVO[models.size()]);
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
		this.scnrRmk = this.scnrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww = this.yyyyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrId = this.scnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.location = this.location .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	/**
	 * @return the statusType
	 */
	public String getStatusType() {
		return statusType;
	}

	/**
	 * @param statusType the statusType to set
	 */
	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}
}

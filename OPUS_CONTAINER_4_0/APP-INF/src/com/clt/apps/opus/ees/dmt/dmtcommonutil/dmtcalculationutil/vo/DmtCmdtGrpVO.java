/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DmtCmdtGrpVO.java
*@FileTitle : DmtCmdtGrpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.10 최성환 
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

public class DmtCmdtGrpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DmtCmdtGrpVO> models = new ArrayList<DmtCmdtGrpVO>();
	
	/* Column Info */
	private String ttlDay = null;
	/* Column Info */
	private String exclHoli = null;
	/* Column Info */
	private String exclSat = null;
	/* Column Info */
	private String msgCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String msgDesc = null;
	/* Column Info */
	private String exclSun = null;
	/* Column Info */
	private String dcrSeq = null;
	/* Column Info */
	private String addDay = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DmtCmdtGrpVO() {}

	public DmtCmdtGrpVO(String ibflag, String pagerows, String dcrSeq, String exclSat, String exclSun, String exclHoli, String addDay, String ttlDay, String msgCd, String msgDesc) {
		this.ttlDay = ttlDay;
		this.exclHoli = exclHoli;
		this.exclSat = exclSat;
		this.msgCd = msgCd;
		this.ibflag = ibflag;
		this.msgDesc = msgDesc;
		this.exclSun = exclSun;
		this.dcrSeq = dcrSeq;
		this.addDay = addDay;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ttl_day", getTtlDay());
		this.hashColumns.put("excl_holi", getExclHoli());
		this.hashColumns.put("excl_sat", getExclSat());
		this.hashColumns.put("msg_cd", getMsgCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("msg_desc", getMsgDesc());
		this.hashColumns.put("excl_sun", getExclSun());
		this.hashColumns.put("dcr_seq", getDcrSeq());
		this.hashColumns.put("add_day", getAddDay());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ttl_day", "ttlDay");
		this.hashFields.put("excl_holi", "exclHoli");
		this.hashFields.put("excl_sat", "exclSat");
		this.hashFields.put("msg_cd", "msgCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("msg_desc", "msgDesc");
		this.hashFields.put("excl_sun", "exclSun");
		this.hashFields.put("dcr_seq", "dcrSeq");
		this.hashFields.put("add_day", "addDay");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ttlDay
	 */
	public String getTtlDay() {
		return this.ttlDay;
	}
	
	/**
	 * Column Info
	 * @return exclHoli
	 */
	public String getExclHoli() {
		return this.exclHoli;
	}
	
	/**
	 * Column Info
	 * @return exclSat
	 */
	public String getExclSat() {
		return this.exclSat;
	}
	
	/**
	 * Column Info
	 * @return msgCd
	 */
	public String getMsgCd() {
		return this.msgCd;
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
	 * @return msgDesc
	 */
	public String getMsgDesc() {
		return this.msgDesc;
	}
	
	/**
	 * Column Info
	 * @return exclSun
	 */
	public String getExclSun() {
		return this.exclSun;
	}
	
	/**
	 * Column Info
	 * @return dcrSeq
	 */
	public String getDcrSeq() {
		return this.dcrSeq;
	}
	
	/**
	 * Column Info
	 * @return addDay
	 */
	public String getAddDay() {
		return this.addDay;
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
	 * @param ttlDay
	 */
	public void setTtlDay(String ttlDay) {
		this.ttlDay = ttlDay;
	}
	
	/**
	 * Column Info
	 * @param exclHoli
	 */
	public void setExclHoli(String exclHoli) {
		this.exclHoli = exclHoli;
	}
	
	/**
	 * Column Info
	 * @param exclSat
	 */
	public void setExclSat(String exclSat) {
		this.exclSat = exclSat;
	}
	
	/**
	 * Column Info
	 * @param msgCd
	 */
	public void setMsgCd(String msgCd) {
		this.msgCd = msgCd;
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
	 * @param msgDesc
	 */
	public void setMsgDesc(String msgDesc) {
		this.msgDesc = msgDesc;
	}
	
	/**
	 * Column Info
	 * @param exclSun
	 */
	public void setExclSun(String exclSun) {
		this.exclSun = exclSun;
	}
	
	/**
	 * Column Info
	 * @param dcrSeq
	 */
	public void setDcrSeq(String dcrSeq) {
		this.dcrSeq = dcrSeq;
	}
	
	/**
	 * Column Info
	 * @param addDay
	 */
	public void setAddDay(String addDay) {
		this.addDay = addDay;
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
		setTtlDay(JSPUtil.getParameter(request, "ttl_day", ""));
		setExclHoli(JSPUtil.getParameter(request, "excl_holi", ""));
		setExclSat(JSPUtil.getParameter(request, "excl_sat", ""));
		setMsgCd(JSPUtil.getParameter(request, "msg_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMsgDesc(JSPUtil.getParameter(request, "msg_desc", ""));
		setExclSun(JSPUtil.getParameter(request, "excl_sun", ""));
		setDcrSeq(JSPUtil.getParameter(request, "dcr_seq", ""));
		setAddDay(JSPUtil.getParameter(request, "add_day", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DmtCmdtGrpVO[]
	 */
	public DmtCmdtGrpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DmtCmdtGrpVO[]
	 */
	public DmtCmdtGrpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DmtCmdtGrpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ttlDay = (JSPUtil.getParameter(request, prefix	+ "ttl_day", length));
			String[] exclHoli = (JSPUtil.getParameter(request, prefix	+ "excl_holi", length));
			String[] exclSat = (JSPUtil.getParameter(request, prefix	+ "excl_sat", length));
			String[] msgCd = (JSPUtil.getParameter(request, prefix	+ "msg_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] msgDesc = (JSPUtil.getParameter(request, prefix	+ "msg_desc", length));
			String[] exclSun = (JSPUtil.getParameter(request, prefix	+ "excl_sun", length));
			String[] dcrSeq = (JSPUtil.getParameter(request, prefix	+ "dcr_seq", length));
			String[] addDay = (JSPUtil.getParameter(request, prefix	+ "add_day", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DmtCmdtGrpVO();
				if (ttlDay[i] != null)
					model.setTtlDay(ttlDay[i]);
				if (exclHoli[i] != null)
					model.setExclHoli(exclHoli[i]);
				if (exclSat[i] != null)
					model.setExclSat(exclSat[i]);
				if (msgCd[i] != null)
					model.setMsgCd(msgCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (msgDesc[i] != null)
					model.setMsgDesc(msgDesc[i]);
				if (exclSun[i] != null)
					model.setExclSun(exclSun[i]);
				if (dcrSeq[i] != null)
					model.setDcrSeq(dcrSeq[i]);
				if (addDay[i] != null)
					model.setAddDay(addDay[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDmtCmdtGrpVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DmtCmdtGrpVO[]
	 */
	public DmtCmdtGrpVO[] getDmtCmdtGrpVOs(){
		DmtCmdtGrpVO[] vos = (DmtCmdtGrpVO[])models.toArray(new DmtCmdtGrpVO[models.size()]);
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
		this.ttlDay = this.ttlDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exclHoli = this.exclHoli .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exclSat = this.exclSat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgCd = this.msgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgDesc = this.msgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exclSun = this.exclSun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcrSeq = this.dcrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addDay = this.addDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

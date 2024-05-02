/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DmtSCGrpVO.java
*@FileTitle : DmtSCGrpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.16 최성환 
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

public class DmtSCGrpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DmtSCGrpVO> models = new ArrayList<DmtSCGrpVO>();
	
	/* Column Info */
	private String ftAdjMk = null;
	/* Column Info */
	private String msgDesc = null;
	/* Column Info */
	private String curCd = null;
	/* Column Info */
	private String ftAddDay = null;
	/* Column Info */
	private String exclSun = null;
	/* Column Info */
	private String ftAddMk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String verSeq = null;
	/* Column Info */
	private String rtAdjMk = null;
	/* Column Info */
	private String exclSat = null;
	/* Column Info */
	private String exclHoli = null;
	/* Column Info */
	private String msgCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ftimeMk = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String grpSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DmtSCGrpVO() {}

	public DmtSCGrpVO(String ibflag, String pagerows, String propNo, String verSeq, String grpSeq, String ftimeMk, String exclSat, String exclSun, String exclHoli, String ftAddMk, String ftAddDay, String ftAdjMk, String rtAdjMk, String curCd, String msgCd, String msgDesc) {
		this.ftAdjMk = ftAdjMk;
		this.msgDesc = msgDesc;
		this.curCd = curCd;
		this.ftAddDay = ftAddDay;
		this.exclSun = exclSun;
		this.ftAddMk = ftAddMk;
		this.pagerows = pagerows;
		this.verSeq = verSeq;
		this.rtAdjMk = rtAdjMk;
		this.exclSat = exclSat;
		this.exclHoli = exclHoli;
		this.msgCd = msgCd;
		this.ibflag = ibflag;
		this.ftimeMk = ftimeMk;
		this.propNo = propNo;
		this.grpSeq = grpSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ft_adj_mk", getFtAdjMk());
		this.hashColumns.put("msg_desc", getMsgDesc());
		this.hashColumns.put("cur_cd", getCurCd());
		this.hashColumns.put("ft_add_day", getFtAddDay());
		this.hashColumns.put("excl_sun", getExclSun());
		this.hashColumns.put("ft_add_mk", getFtAddMk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ver_seq", getVerSeq());
		this.hashColumns.put("rt_adj_mk", getRtAdjMk());
		this.hashColumns.put("excl_sat", getExclSat());
		this.hashColumns.put("excl_holi", getExclHoli());
		this.hashColumns.put("msg_cd", getMsgCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ftime_mk", getFtimeMk());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("grp_seq", getGrpSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ft_adj_mk", "ftAdjMk");
		this.hashFields.put("msg_desc", "msgDesc");
		this.hashFields.put("cur_cd", "curCd");
		this.hashFields.put("ft_add_day", "ftAddDay");
		this.hashFields.put("excl_sun", "exclSun");
		this.hashFields.put("ft_add_mk", "ftAddMk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ver_seq", "verSeq");
		this.hashFields.put("rt_adj_mk", "rtAdjMk");
		this.hashFields.put("excl_sat", "exclSat");
		this.hashFields.put("excl_holi", "exclHoli");
		this.hashFields.put("msg_cd", "msgCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ftime_mk", "ftimeMk");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("grp_seq", "grpSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ftAdjMk
	 */
	public String getFtAdjMk() {
		return this.ftAdjMk;
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
	 * @return curCd
	 */
	public String getCurCd() {
		return this.curCd;
	}
	
	/**
	 * Column Info
	 * @return ftAddDay
	 */
	public String getFtAddDay() {
		return this.ftAddDay;
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
	 * @return ftAddMk
	 */
	public String getFtAddMk() {
		return this.ftAddMk;
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
	 * @return verSeq
	 */
	public String getVerSeq() {
		return this.verSeq;
	}
	
	/**
	 * Column Info
	 * @return rtAdjMk
	 */
	public String getRtAdjMk() {
		return this.rtAdjMk;
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
	 * @return exclHoli
	 */
	public String getExclHoli() {
		return this.exclHoli;
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
	 * @return ftimeMk
	 */
	public String getFtimeMk() {
		return this.ftimeMk;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return grpSeq
	 */
	public String getGrpSeq() {
		return this.grpSeq;
	}
	

	/**
	 * Column Info
	 * @param ftAdjMk
	 */
	public void setFtAdjMk(String ftAdjMk) {
		this.ftAdjMk = ftAdjMk;
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
	 * @param curCd
	 */
	public void setCurCd(String curCd) {
		this.curCd = curCd;
	}
	
	/**
	 * Column Info
	 * @param ftAddDay
	 */
	public void setFtAddDay(String ftAddDay) {
		this.ftAddDay = ftAddDay;
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
	 * @param ftAddMk
	 */
	public void setFtAddMk(String ftAddMk) {
		this.ftAddMk = ftAddMk;
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
	 * @param verSeq
	 */
	public void setVerSeq(String verSeq) {
		this.verSeq = verSeq;
	}
	
	/**
	 * Column Info
	 * @param rtAdjMk
	 */
	public void setRtAdjMk(String rtAdjMk) {
		this.rtAdjMk = rtAdjMk;
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
	 * @param exclHoli
	 */
	public void setExclHoli(String exclHoli) {
		this.exclHoli = exclHoli;
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
	 * @param ftimeMk
	 */
	public void setFtimeMk(String ftimeMk) {
		this.ftimeMk = ftimeMk;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param grpSeq
	 */
	public void setGrpSeq(String grpSeq) {
		this.grpSeq = grpSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFtAdjMk(JSPUtil.getParameter(request, "ft_adj_mk", ""));
		setMsgDesc(JSPUtil.getParameter(request, "msg_desc", ""));
		setCurCd(JSPUtil.getParameter(request, "cur_cd", ""));
		setFtAddDay(JSPUtil.getParameter(request, "ft_add_day", ""));
		setExclSun(JSPUtil.getParameter(request, "excl_sun", ""));
		setFtAddMk(JSPUtil.getParameter(request, "ft_add_mk", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVerSeq(JSPUtil.getParameter(request, "ver_seq", ""));
		setRtAdjMk(JSPUtil.getParameter(request, "rt_adj_mk", ""));
		setExclSat(JSPUtil.getParameter(request, "excl_sat", ""));
		setExclHoli(JSPUtil.getParameter(request, "excl_holi", ""));
		setMsgCd(JSPUtil.getParameter(request, "msg_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFtimeMk(JSPUtil.getParameter(request, "ftime_mk", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setGrpSeq(JSPUtil.getParameter(request, "grp_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DmtSCGrpVO[]
	 */
	public DmtSCGrpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DmtSCGrpVO[]
	 */
	public DmtSCGrpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DmtSCGrpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ftAdjMk = (JSPUtil.getParameter(request, prefix	+ "ft_adj_mk", length));
			String[] msgDesc = (JSPUtil.getParameter(request, prefix	+ "msg_desc", length));
			String[] curCd = (JSPUtil.getParameter(request, prefix	+ "cur_cd", length));
			String[] ftAddDay = (JSPUtil.getParameter(request, prefix	+ "ft_add_day", length));
			String[] exclSun = (JSPUtil.getParameter(request, prefix	+ "excl_sun", length));
			String[] ftAddMk = (JSPUtil.getParameter(request, prefix	+ "ft_add_mk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] verSeq = (JSPUtil.getParameter(request, prefix	+ "ver_seq", length));
			String[] rtAdjMk = (JSPUtil.getParameter(request, prefix	+ "rt_adj_mk", length));
			String[] exclSat = (JSPUtil.getParameter(request, prefix	+ "excl_sat", length));
			String[] exclHoli = (JSPUtil.getParameter(request, prefix	+ "excl_holi", length));
			String[] msgCd = (JSPUtil.getParameter(request, prefix	+ "msg_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ftimeMk = (JSPUtil.getParameter(request, prefix	+ "ftime_mk", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] grpSeq = (JSPUtil.getParameter(request, prefix	+ "grp_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new DmtSCGrpVO();
				if (ftAdjMk[i] != null)
					model.setFtAdjMk(ftAdjMk[i]);
				if (msgDesc[i] != null)
					model.setMsgDesc(msgDesc[i]);
				if (curCd[i] != null)
					model.setCurCd(curCd[i]);
				if (ftAddDay[i] != null)
					model.setFtAddDay(ftAddDay[i]);
				if (exclSun[i] != null)
					model.setExclSun(exclSun[i]);
				if (ftAddMk[i] != null)
					model.setFtAddMk(ftAddMk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (verSeq[i] != null)
					model.setVerSeq(verSeq[i]);
				if (rtAdjMk[i] != null)
					model.setRtAdjMk(rtAdjMk[i]);
				if (exclSat[i] != null)
					model.setExclSat(exclSat[i]);
				if (exclHoli[i] != null)
					model.setExclHoli(exclHoli[i]);
				if (msgCd[i] != null)
					model.setMsgCd(msgCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ftimeMk[i] != null)
					model.setFtimeMk(ftimeMk[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (grpSeq[i] != null)
					model.setGrpSeq(grpSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDmtSCGrpVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DmtSCGrpVO[]
	 */
	public DmtSCGrpVO[] getDmtSCGrpVOs(){
		DmtSCGrpVO[] vos = (DmtSCGrpVO[])models.toArray(new DmtSCGrpVO[models.size()]);
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
		this.ftAdjMk = this.ftAdjMk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgDesc = this.msgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curCd = this.curCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftAddDay = this.ftAddDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exclSun = this.exclSun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftAddMk = this.ftAddMk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verSeq = this.verSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAdjMk = this.rtAdjMk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exclSat = this.exclSat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exclHoli = this.exclHoli .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgCd = this.msgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftimeMk = this.ftimeMk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpSeq = this.grpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

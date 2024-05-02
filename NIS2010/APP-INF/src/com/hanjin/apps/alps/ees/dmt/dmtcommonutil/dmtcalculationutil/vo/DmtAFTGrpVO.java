/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DmtAFTGrpVO.java
*@FileTitle : DmtAFTGrpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.22 최성환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo;

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
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DmtAFTGrpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DmtAFTGrpVO> models = new ArrayList<DmtAFTGrpVO>();
	
	/* Column Info */
	private String msgDesc = null;
	/* Column Info */
	private String curCd = null;
	/* Column Info */
	private String darNo = null;
	/* Column Info */
	private String exclSun = null;
	/* Column Info */
	private String addDay = null;
	/* Column Info */
	private String adjSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dcRate = null;
	/* Column Info */
	private String ttlDay = null;
	/* Column Info */
	private String exclSat = null;
	/* Column Info */
	private String exclHoli = null;
	/* Column Info */
	private String msgCd = null;
	/* Column Info */
	private String dcAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ftimeMk = null;
	/* Column Info */
	private String dcMk = null;
	/* Column Info */
	private String apprNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DmtAFTGrpVO() {}

	public DmtAFTGrpVO(String ibflag, String pagerows, String apprNo, String darNo, String adjSeq, String ftimeMk, String addDay, String ttlDay, String exclSat, String exclSun, String exclHoli, String dcMk, String curCd, String dcAmt, String dcRate, String msgCd, String msgDesc) {
		this.msgDesc = msgDesc;
		this.curCd = curCd;
		this.darNo = darNo;
		this.exclSun = exclSun;
		this.addDay = addDay;
		this.adjSeq = adjSeq;
		this.pagerows = pagerows;
		this.dcRate = dcRate;
		this.ttlDay = ttlDay;
		this.exclSat = exclSat;
		this.exclHoli = exclHoli;
		this.msgCd = msgCd;
		this.dcAmt = dcAmt;
		this.ibflag = ibflag;
		this.ftimeMk = ftimeMk;
		this.dcMk = dcMk;
		this.apprNo = apprNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("msg_desc", getMsgDesc());
		this.hashColumns.put("cur_cd", getCurCd());
		this.hashColumns.put("dar_no", getDarNo());
		this.hashColumns.put("excl_sun", getExclSun());
		this.hashColumns.put("add_day", getAddDay());
		this.hashColumns.put("adj_seq", getAdjSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dc_rate", getDcRate());
		this.hashColumns.put("ttl_day", getTtlDay());
		this.hashColumns.put("excl_sat", getExclSat());
		this.hashColumns.put("excl_holi", getExclHoli());
		this.hashColumns.put("msg_cd", getMsgCd());
		this.hashColumns.put("dc_amt", getDcAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ftime_mk", getFtimeMk());
		this.hashColumns.put("dc_mk", getDcMk());
		this.hashColumns.put("appr_no", getApprNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("msg_desc", "msgDesc");
		this.hashFields.put("cur_cd", "curCd");
		this.hashFields.put("dar_no", "darNo");
		this.hashFields.put("excl_sun", "exclSun");
		this.hashFields.put("add_day", "addDay");
		this.hashFields.put("adj_seq", "adjSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dc_rate", "dcRate");
		this.hashFields.put("ttl_day", "ttlDay");
		this.hashFields.put("excl_sat", "exclSat");
		this.hashFields.put("excl_holi", "exclHoli");
		this.hashFields.put("msg_cd", "msgCd");
		this.hashFields.put("dc_amt", "dcAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ftime_mk", "ftimeMk");
		this.hashFields.put("dc_mk", "dcMk");
		this.hashFields.put("appr_no", "apprNo");
		return this.hashFields;
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
	 * @return darNo
	 */
	public String getDarNo() {
		return this.darNo;
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
	 * @return addDay
	 */
	public String getAddDay() {
		return this.addDay;
	}
	
	/**
	 * Column Info
	 * @return adjSeq
	 */
	public String getAdjSeq() {
		return this.adjSeq;
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
	 * @return dcRate
	 */
	public String getDcRate() {
		return this.dcRate;
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
	 * Column Info
	 * @return dcAmt
	 */
	public String getDcAmt() {
		return this.dcAmt;
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
	 * @return dcMk
	 */
	public String getDcMk() {
		return this.dcMk;
	}
	
	/**
	 * Column Info
	 * @return apprNo
	 */
	public String getApprNo() {
		return this.apprNo;
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
	 * @param darNo
	 */
	public void setDarNo(String darNo) {
		this.darNo = darNo;
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
	 * @param addDay
	 */
	public void setAddDay(String addDay) {
		this.addDay = addDay;
	}
	
	/**
	 * Column Info
	 * @param adjSeq
	 */
	public void setAdjSeq(String adjSeq) {
		this.adjSeq = adjSeq;
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
	 * @param dcRate
	 */
	public void setDcRate(String dcRate) {
		this.dcRate = dcRate;
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
	 * Column Info
	 * @param dcAmt
	 */
	public void setDcAmt(String dcAmt) {
		this.dcAmt = dcAmt;
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
	 * @param dcMk
	 */
	public void setDcMk(String dcMk) {
		this.dcMk = dcMk;
	}
	
	/**
	 * Column Info
	 * @param apprNo
	 */
	public void setApprNo(String apprNo) {
		this.apprNo = apprNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setMsgDesc(JSPUtil.getParameter(request, "msg_desc", ""));
		setCurCd(JSPUtil.getParameter(request, "cur_cd", ""));
		setDarNo(JSPUtil.getParameter(request, "dar_no", ""));
		setExclSun(JSPUtil.getParameter(request, "excl_sun", ""));
		setAddDay(JSPUtil.getParameter(request, "add_day", ""));
		setAdjSeq(JSPUtil.getParameter(request, "adj_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDcRate(JSPUtil.getParameter(request, "dc_rate", ""));
		setTtlDay(JSPUtil.getParameter(request, "ttl_day", ""));
		setExclSat(JSPUtil.getParameter(request, "excl_sat", ""));
		setExclHoli(JSPUtil.getParameter(request, "excl_holi", ""));
		setMsgCd(JSPUtil.getParameter(request, "msg_cd", ""));
		setDcAmt(JSPUtil.getParameter(request, "dc_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFtimeMk(JSPUtil.getParameter(request, "ftime_mk", ""));
		setDcMk(JSPUtil.getParameter(request, "dc_mk", ""));
		setApprNo(JSPUtil.getParameter(request, "appr_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DmtAFTGrpVO[]
	 */
	public DmtAFTGrpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DmtAFTGrpVO[]
	 */
	public DmtAFTGrpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DmtAFTGrpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] msgDesc = (JSPUtil.getParameter(request, prefix	+ "msg_desc", length));
			String[] curCd = (JSPUtil.getParameter(request, prefix	+ "cur_cd", length));
			String[] darNo = (JSPUtil.getParameter(request, prefix	+ "dar_no", length));
			String[] exclSun = (JSPUtil.getParameter(request, prefix	+ "excl_sun", length));
			String[] addDay = (JSPUtil.getParameter(request, prefix	+ "add_day", length));
			String[] adjSeq = (JSPUtil.getParameter(request, prefix	+ "adj_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dcRate = (JSPUtil.getParameter(request, prefix	+ "dc_rate", length));
			String[] ttlDay = (JSPUtil.getParameter(request, prefix	+ "ttl_day", length));
			String[] exclSat = (JSPUtil.getParameter(request, prefix	+ "excl_sat", length));
			String[] exclHoli = (JSPUtil.getParameter(request, prefix	+ "excl_holi", length));
			String[] msgCd = (JSPUtil.getParameter(request, prefix	+ "msg_cd", length));
			String[] dcAmt = (JSPUtil.getParameter(request, prefix	+ "dc_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ftimeMk = (JSPUtil.getParameter(request, prefix	+ "ftime_mk", length));
			String[] dcMk = (JSPUtil.getParameter(request, prefix	+ "dc_mk", length));
			String[] apprNo = (JSPUtil.getParameter(request, prefix	+ "appr_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new DmtAFTGrpVO();
				if (msgDesc[i] != null)
					model.setMsgDesc(msgDesc[i]);
				if (curCd[i] != null)
					model.setCurCd(curCd[i]);
				if (darNo[i] != null)
					model.setDarNo(darNo[i]);
				if (exclSun[i] != null)
					model.setExclSun(exclSun[i]);
				if (addDay[i] != null)
					model.setAddDay(addDay[i]);
				if (adjSeq[i] != null)
					model.setAdjSeq(adjSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dcRate[i] != null)
					model.setDcRate(dcRate[i]);
				if (ttlDay[i] != null)
					model.setTtlDay(ttlDay[i]);
				if (exclSat[i] != null)
					model.setExclSat(exclSat[i]);
				if (exclHoli[i] != null)
					model.setExclHoli(exclHoli[i]);
				if (msgCd[i] != null)
					model.setMsgCd(msgCd[i]);
				if (dcAmt[i] != null)
					model.setDcAmt(dcAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ftimeMk[i] != null)
					model.setFtimeMk(ftimeMk[i]);
				if (dcMk[i] != null)
					model.setDcMk(dcMk[i]);
				if (apprNo[i] != null)
					model.setApprNo(apprNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDmtAFTGrpVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DmtAFTGrpVO[]
	 */
	public DmtAFTGrpVO[] getDmtAFTGrpVOs(){
		DmtAFTGrpVO[] vos = (DmtAFTGrpVO[])models.toArray(new DmtAFTGrpVO[models.size()]);
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
		this.msgDesc = this.msgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curCd = this.curCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.darNo = this.darNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exclSun = this.exclSun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addDay = this.addDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjSeq = this.adjSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcRate = this.dcRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDay = this.ttlDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exclSat = this.exclSat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exclHoli = this.exclHoli .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgCd = this.msgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcAmt = this.dcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftimeMk = this.ftimeMk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcMk = this.dcMk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apprNo = this.apprNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

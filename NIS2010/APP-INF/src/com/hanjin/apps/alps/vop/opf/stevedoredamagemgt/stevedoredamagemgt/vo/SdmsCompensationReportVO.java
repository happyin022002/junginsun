/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SdmsCompensationReportVO.java
*@FileTitle : SdmsCompensationReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.07.02 이선영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo;

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
 * @author 이선영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SdmsCompensationReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SdmsCompensationReportVO> models = new ArrayList<SdmsCompensationReportVO>();
	
	/* Column Info */
	private String notAmt = null;
	/* Column Info */
	private String claimCnt = null;
	/* Column Info */
	private String readyCnt = null;
	/* Column Info */
	private String canAmt = null;
	/* Column Info */
	private String comCnt = null;
	/* Column Info */
	private String rejAmt = null;
	/* Column Info */
	private String period = null;
	/* Column Info */
	private String accCnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String canCnt = null;
	/* Column Info */
	private String claimAmt = null;
	/* Column Info */
	private String notCnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String grp = null;
	/* Column Info */
	private String rejCnt = null;
	/* Column Info */
	private String accAmt = null;
	/* Column Info */
	private String comAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SdmsCompensationReportVO() {}

	public SdmsCompensationReportVO(String ibflag, String pagerows, String grp, String period, String claimCnt, String readyCnt, String claimAmt, String notCnt, String notAmt, String rejCnt, String rejAmt, String accCnt, String accAmt, String comCnt, String comAmt, String canCnt, String canAmt) {
		this.notAmt = notAmt;
		this.claimCnt = claimCnt;
		this.readyCnt = readyCnt;
		this.canAmt = canAmt;
		this.comCnt = comCnt;
		this.rejAmt = rejAmt;
		this.period = period;
		this.accCnt = accCnt;
		this.pagerows = pagerows;
		this.canCnt = canCnt;
		this.claimAmt = claimAmt;
		this.notCnt = notCnt;
		this.ibflag = ibflag;
		this.grp = grp;
		this.rejCnt = rejCnt;
		this.accAmt = accAmt;
		this.comAmt = comAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("not_amt", getNotAmt());
		this.hashColumns.put("claim_cnt", getClaimCnt());
		this.hashColumns.put("ready_cnt", getReadyCnt());
		this.hashColumns.put("can_amt", getCanAmt());
		this.hashColumns.put("com_cnt", getComCnt());
		this.hashColumns.put("rej_amt", getRejAmt());
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("acc_cnt", getAccCnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("can_cnt", getCanCnt());
		this.hashColumns.put("claim_amt", getClaimAmt());
		this.hashColumns.put("not_cnt", getNotCnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("grp", getGrp());
		this.hashColumns.put("rej_cnt", getRejCnt());
		this.hashColumns.put("acc_amt", getAccAmt());
		this.hashColumns.put("com_amt", getComAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("not_amt", "notAmt");
		this.hashFields.put("claim_cnt", "claimCnt");
		this.hashFields.put("ready_cnt", "readyCnt");
		this.hashFields.put("can_amt", "canAmt");
		this.hashFields.put("com_cnt", "comCnt");
		this.hashFields.put("rej_amt", "rejAmt");
		this.hashFields.put("period", "period");
		this.hashFields.put("acc_cnt", "accCnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("can_cnt", "canCnt");
		this.hashFields.put("claim_amt", "claimAmt");
		this.hashFields.put("not_cnt", "notCnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("grp", "grp");
		this.hashFields.put("rej_cnt", "rejCnt");
		this.hashFields.put("acc_amt", "accAmt");
		this.hashFields.put("com_amt", "comAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return notAmt
	 */
	public String getNotAmt() {
		return this.notAmt;
	}
	
	/**
	 * Column Info
	 * @return claimCnt
	 */
	public String getClaimCnt() {
		return this.claimCnt;
	}

	/**
	 * Column Info
	 * @return readyCnt
	 */
	public String getReadyCnt() {
		return this.readyCnt;
	}
	
	/**
	 * Column Info
	 * @return canAmt
	 */
	public String getCanAmt() {
		return this.canAmt;
	}
	
	/**
	 * Column Info
	 * @return comCnt
	 */
	public String getComCnt() {
		return this.comCnt;
	}
	
	/**
	 * Column Info
	 * @return rejAmt
	 */
	public String getRejAmt() {
		return this.rejAmt;
	}
	
	/**
	 * Column Info
	 * @return period
	 */
	public String getPeriod() {
		return this.period;
	}
	
	/**
	 * Column Info
	 * @return accCnt
	 */
	public String getAccCnt() {
		return this.accCnt;
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
	 * @return canCnt
	 */
	public String getCanCnt() {
		return this.canCnt;
	}
	
	/**
	 * Column Info
	 * @return claimAmt
	 */
	public String getClaimAmt() {
		return this.claimAmt;
	}
	
	/**
	 * Column Info
	 * @return notCnt
	 */
	public String getNotCnt() {
		return this.notCnt;
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
	 * @return grp
	 */
	public String getGrp() {
		return this.grp;
	}
	
	/**
	 * Column Info
	 * @return rejCnt
	 */
	public String getRejCnt() {
		return this.rejCnt;
	}
	
	/**
	 * Column Info
	 * @return accAmt
	 */
	public String getAccAmt() {
		return this.accAmt;
	}
	
	/**
	 * Column Info
	 * @return comAmt
	 */
	public String getComAmt() {
		return this.comAmt;
	}
	

	/**
	 * Column Info
	 * @param notAmt
	 */
	public void setNotAmt(String notAmt) {
		this.notAmt = notAmt;
	}
	
	/**
	 * Column Info
	 * @param claimCnt
	 */
	public void setClaimCnt(String claimCnt) {
		this.claimCnt = claimCnt;
	}
	
	/**
	 * Column Info
	 * @param readyCnt
	 */
	public void setReadyCnt(String readyCnt) {
		this.readyCnt = readyCnt;
	}
	
	/**
	 * Column Info
	 * @param canAmt
	 */
	public void setCanAmt(String canAmt) {
		this.canAmt = canAmt;
	}
	
	/**
	 * Column Info
	 * @param comCnt
	 */
	public void setComCnt(String comCnt) {
		this.comCnt = comCnt;
	}
	
	/**
	 * Column Info
	 * @param rejAmt
	 */
	public void setRejAmt(String rejAmt) {
		this.rejAmt = rejAmt;
	}
	
	/**
	 * Column Info
	 * @param period
	 */
	public void setPeriod(String period) {
		this.period = period;
	}
	
	/**
	 * Column Info
	 * @param accCnt
	 */
	public void setAccCnt(String accCnt) {
		this.accCnt = accCnt;
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
	 * @param canCnt
	 */
	public void setCanCnt(String canCnt) {
		this.canCnt = canCnt;
	}
	
	/**
	 * Column Info
	 * @param claimAmt
	 */
	public void setClaimAmt(String claimAmt) {
		this.claimAmt = claimAmt;
	}
	
	/**
	 * Column Info
	 * @param notCnt
	 */
	public void setNotCnt(String notCnt) {
		this.notCnt = notCnt;
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
	 * @param grp
	 */
	public void setGrp(String grp) {
		this.grp = grp;
	}
	
	/**
	 * Column Info
	 * @param rejCnt
	 */
	public void setRejCnt(String rejCnt) {
		this.rejCnt = rejCnt;
	}
	
	/**
	 * Column Info
	 * @param accAmt
	 */
	public void setAccAmt(String accAmt) {
		this.accAmt = accAmt;
	}
	
	/**
	 * Column Info
	 * @param comAmt
	 */
	public void setComAmt(String comAmt) {
		this.comAmt = comAmt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setNotAmt(JSPUtil.getParameter(request, "not_amt", ""));
		setClaimCnt(JSPUtil.getParameter(request, "claim_cnt", ""));
		setReadyCnt(JSPUtil.getParameter(request, "ready_cnt", ""));
		setCanAmt(JSPUtil.getParameter(request, "can_amt", ""));
		setComCnt(JSPUtil.getParameter(request, "com_cnt", ""));
		setRejAmt(JSPUtil.getParameter(request, "rej_amt", ""));
		setPeriod(JSPUtil.getParameter(request, "period", ""));
		setAccCnt(JSPUtil.getParameter(request, "acc_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCanCnt(JSPUtil.getParameter(request, "can_cnt", ""));
		setClaimAmt(JSPUtil.getParameter(request, "claim_amt", ""));
		setNotCnt(JSPUtil.getParameter(request, "not_cnt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGrp(JSPUtil.getParameter(request, "grp", ""));
		setRejCnt(JSPUtil.getParameter(request, "rej_cnt", ""));
		setAccAmt(JSPUtil.getParameter(request, "acc_amt", ""));
		setComAmt(JSPUtil.getParameter(request, "com_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SdmsCompensationReportVO[]
	 */
	public SdmsCompensationReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SdmsCompensationReportVO[]
	 */
	public SdmsCompensationReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SdmsCompensationReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] notAmt = (JSPUtil.getParameter(request, prefix	+ "not_amt", length));
			String[] claimCnt = (JSPUtil.getParameter(request, prefix	+ "claim_cnt", length));
			String[] readyCnt = (JSPUtil.getParameter(request, prefix	+ "ready_cnt", length));
			String[] canAmt = (JSPUtil.getParameter(request, prefix	+ "can_amt", length));
			String[] comCnt = (JSPUtil.getParameter(request, prefix	+ "com_cnt", length));
			String[] rejAmt = (JSPUtil.getParameter(request, prefix	+ "rej_amt", length));
			String[] period = (JSPUtil.getParameter(request, prefix	+ "period", length));
			String[] accCnt = (JSPUtil.getParameter(request, prefix	+ "acc_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] canCnt = (JSPUtil.getParameter(request, prefix	+ "can_cnt", length));
			String[] claimAmt = (JSPUtil.getParameter(request, prefix	+ "claim_amt", length));
			String[] notCnt = (JSPUtil.getParameter(request, prefix	+ "not_cnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] grp = (JSPUtil.getParameter(request, prefix	+ "grp", length));
			String[] rejCnt = (JSPUtil.getParameter(request, prefix	+ "rej_cnt", length));
			String[] accAmt = (JSPUtil.getParameter(request, prefix	+ "acc_amt", length));
			String[] comAmt = (JSPUtil.getParameter(request, prefix	+ "com_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SdmsCompensationReportVO();
				if (notAmt[i] != null)
					model.setNotAmt(notAmt[i]);
				if (claimCnt[i] != null)
					model.setClaimCnt(claimCnt[i]);
				if (readyCnt[i] != null)
					model.setReadyCnt(readyCnt[i]);
				if (canAmt[i] != null)
					model.setCanAmt(canAmt[i]);
				if (comCnt[i] != null)
					model.setComCnt(comCnt[i]);
				if (rejAmt[i] != null)
					model.setRejAmt(rejAmt[i]);
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (accCnt[i] != null)
					model.setAccCnt(accCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (canCnt[i] != null)
					model.setCanCnt(canCnt[i]);
				if (claimAmt[i] != null)
					model.setClaimAmt(claimAmt[i]);
				if (notCnt[i] != null)
					model.setNotCnt(notCnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (grp[i] != null)
					model.setGrp(grp[i]);
				if (rejCnt[i] != null)
					model.setRejCnt(rejCnt[i]);
				if (accAmt[i] != null)
					model.setAccAmt(accAmt[i]);
				if (comAmt[i] != null)
					model.setComAmt(comAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSdmsCompensationReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SdmsCompensationReportVO[]
	 */
	public SdmsCompensationReportVO[] getSdmsCompensationReportVOs(){
		SdmsCompensationReportVO[] vos = (SdmsCompensationReportVO[])models.toArray(new SdmsCompensationReportVO[models.size()]);
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
		this.notAmt = this.notAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimCnt = this.claimCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.readyCnt = this.readyCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.canAmt = this.canAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comCnt = this.comCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rejAmt = this.rejAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period = this.period .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accCnt = this.accCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.canCnt = this.canCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimAmt = this.claimAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notCnt = this.notCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grp = this.grp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rejCnt = this.rejCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accAmt = this.accAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comAmt = this.comAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

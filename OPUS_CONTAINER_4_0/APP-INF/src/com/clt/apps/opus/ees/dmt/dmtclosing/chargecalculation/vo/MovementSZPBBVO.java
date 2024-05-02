/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MovementSZPBBVO.java
*@FileTitle : MovementSZPBBVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.10.20 황효근 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo;

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
 * @author 황효근
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MovementSZPBBVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MovementSZPBBVO> models = new ArrayList<MovementSZPBBVO>();
	
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String toMvmtSplitNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String toMvmtSeq = null;
	/* Column Info */
	private String toMvmtDt = null;
	/* Column Info */
	private String toMvmtYdCd = null;
	/* Column Info */
	private String toMvmtYr = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MovementSZPBBVO() {}

	public MovementSZPBBVO(String ibflag, String pagerows, String seq, String cntrNo, String bkgNo, String toMvmtYdCd, String toMvmtDt, String toMvmtYr, String toMvmtSeq, String toMvmtSplitNo) {
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.toMvmtSplitNo = toMvmtSplitNo;
		this.cntrNo = cntrNo;
		this.seq = seq;
		this.toMvmtSeq = toMvmtSeq;
		this.toMvmtDt = toMvmtDt;
		this.toMvmtYdCd = toMvmtYdCd;
		this.toMvmtYr = toMvmtYr;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("to_mvmt_split_no", getToMvmtSplitNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("to_mvmt_seq", getToMvmtSeq());
		this.hashColumns.put("to_mvmt_dt", getToMvmtDt());
		this.hashColumns.put("to_mvmt_yd_cd", getToMvmtYdCd());
		this.hashColumns.put("to_mvmt_yr", getToMvmtYr());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("to_mvmt_split_no", "toMvmtSplitNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("to_mvmt_seq", "toMvmtSeq");
		this.hashFields.put("to_mvmt_dt", "toMvmtDt");
		this.hashFields.put("to_mvmt_yd_cd", "toMvmtYdCd");
		this.hashFields.put("to_mvmt_yr", "toMvmtYr");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return toMvmtSplitNo
	 */
	public String getToMvmtSplitNo() {
		return this.toMvmtSplitNo;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @return toMvmtSeq
	 */
	public String getToMvmtSeq() {
		return this.toMvmtSeq;
	}
	
	/**
	 * Column Info
	 * @return toMvmtDt
	 */
	public String getToMvmtDt() {
		return this.toMvmtDt;
	}
	
	/**
	 * Column Info
	 * @return toMvmtYdCd
	 */
	public String getToMvmtYdCd() {
		return this.toMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @return toMvmtYr
	 */
	public String getToMvmtYr() {
		return this.toMvmtYr;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param toMvmtSplitNo
	 */
	public void setToMvmtSplitNo(String toMvmtSplitNo) {
		this.toMvmtSplitNo = toMvmtSplitNo;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
	 * @param toMvmtSeq
	 */
	public void setToMvmtSeq(String toMvmtSeq) {
		this.toMvmtSeq = toMvmtSeq;
	}
	
	/**
	 * Column Info
	 * @param toMvmtDt
	 */
	public void setToMvmtDt(String toMvmtDt) {
		this.toMvmtDt = toMvmtDt;
	}
	
	/**
	 * Column Info
	 * @param toMvmtYdCd
	 */
	public void setToMvmtYdCd(String toMvmtYdCd) {
		this.toMvmtYdCd = toMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @param toMvmtYr
	 */
	public void setToMvmtYr(String toMvmtYr) {
		this.toMvmtYr = toMvmtYr;
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
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setToMvmtSplitNo(JSPUtil.getParameter(request, "to_mvmt_split_no", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setToMvmtSeq(JSPUtil.getParameter(request, "to_mvmt_seq", ""));
		setToMvmtDt(JSPUtil.getParameter(request, "to_mvmt_dt", ""));
		setToMvmtYdCd(JSPUtil.getParameter(request, "to_mvmt_yd_cd", ""));
		setToMvmtYr(JSPUtil.getParameter(request, "to_mvmt_yr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MovementSZPBBVO[]
	 */
	public MovementSZPBBVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MovementSZPBBVO[]
	 */
	public MovementSZPBBVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MovementSZPBBVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] toMvmtSplitNo = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_split_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] toMvmtSeq = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_seq", length));
			String[] toMvmtDt = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_dt", length));
			String[] toMvmtYdCd = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_yd_cd", length));
			String[] toMvmtYr = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_yr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new MovementSZPBBVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (toMvmtSplitNo[i] != null)
					model.setToMvmtSplitNo(toMvmtSplitNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (toMvmtSeq[i] != null)
					model.setToMvmtSeq(toMvmtSeq[i]);
				if (toMvmtDt[i] != null)
					model.setToMvmtDt(toMvmtDt[i]);
				if (toMvmtYdCd[i] != null)
					model.setToMvmtYdCd(toMvmtYdCd[i]);
				if (toMvmtYr[i] != null)
					model.setToMvmtYr(toMvmtYr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMovementSZPBBVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MovementSZPBBVO[]
	 */
	public MovementSZPBBVO[] getMovementSZPBBVOs(){
		MovementSZPBBVO[] vos = (MovementSZPBBVO[])models.toArray(new MovementSZPBBVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtSplitNo = this.toMvmtSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtSeq = this.toMvmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtDt = this.toMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtYdCd = this.toMvmtYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtYr = this.toMvmtYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

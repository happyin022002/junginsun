/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CalculationAMTVO.java
*@FileTitle : CalculationAMTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.26 최성환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CalculationAMTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CalculationAMTVO> models = new ArrayList<CalculationAMTVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String msgCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String msgDesc = null;
	/* Column Info */
	private String dtlCnt = null;
	/* Column Info */
	private String rateCurCd = null;
	/* Page Number */
	private String pagerows = null;
	
	/* Column Info */
	private List<ChrgDtlVO> chrgDtlVOS = null;
	
	/**
	 * Column Info
	 * @return this.chargeByBookingCustomerCntrVOS 
	 */
	public void setChrgDtlVOS(List<ChrgDtlVO> chrgDtlVOS) {
		this.chrgDtlVOS = chrgDtlVOS;
	}
	
	/**
	 * Column Info
	 * @return List<ChargeByBookingCustomerCntrVO>
	 */
	public List<ChrgDtlVO> getChrgDtlVOS() {
		return chrgDtlVOS;
	}

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CalculationAMTVO() {}

	public CalculationAMTVO(String ibflag, String pagerows, String total, String dtlCnt, String rateCurCd, String msgCd, String msgDesc) {
		this.total = total;
		this.msgCd = msgCd;
		this.ibflag = ibflag;
		this.msgDesc = msgDesc;
		this.dtlCnt = dtlCnt;
		this.rateCurCd = rateCurCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("msg_cd", getMsgCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("msg_desc", getMsgDesc());
		this.hashColumns.put("dtl_cnt", getDtlCnt());
		this.hashColumns.put("rate_cur_cd", getRateCurCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("msg_cd", "msgCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("msg_desc", "msgDesc");
		this.hashFields.put("dtl_cnt", "dtlCnt");
		this.hashFields.put("rate_cur_cd", "rateCurCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return total
	 */
	public String getTotal() {
		return this.total;
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
	 * @return dtlCnt
	 */
	public String getDtlCnt() {
		return this.dtlCnt;
	}
	
	/**
	 * Column Info
	 * @return rateCurCd
	 */
	public String getRateCurCd() {
		return this.rateCurCd;
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
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
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
	 * @param dtlCnt
	 */
	public void setDtlCnt(String dtlCnt) {
		this.dtlCnt = dtlCnt;
	}
	
	/**
	 * Column Info
	 * @param rateCurCd
	 */
	public void setRateCurCd(String rateCurCd) {
		this.rateCurCd = rateCurCd;
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
		setTotal(JSPUtil.getParameter(request, "total", ""));
		setMsgCd(JSPUtil.getParameter(request, "msg_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMsgDesc(JSPUtil.getParameter(request, "msg_desc", ""));
		setDtlCnt(JSPUtil.getParameter(request, "dtl_cnt", ""));
		setRateCurCd(JSPUtil.getParameter(request, "rate_cur_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CalculationAMTVO[]
	 */
	public CalculationAMTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CalculationAMTVO[]
	 */
	public CalculationAMTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CalculationAMTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] msgCd = (JSPUtil.getParameter(request, prefix	+ "msg_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] msgDesc = (JSPUtil.getParameter(request, prefix	+ "msg_desc", length));
			String[] dtlCnt = (JSPUtil.getParameter(request, prefix	+ "dtl_cnt", length));
			String[] rateCurCd = (JSPUtil.getParameter(request, prefix	+ "rate_cur_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CalculationAMTVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (msgCd[i] != null)
					model.setMsgCd(msgCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (msgDesc[i] != null)
					model.setMsgDesc(msgDesc[i]);
				if (dtlCnt[i] != null)
					model.setDtlCnt(dtlCnt[i]);
				if (rateCurCd[i] != null)
					model.setRateCurCd(rateCurCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCalculationAMTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CalculationAMTVO[]
	 */
	public CalculationAMTVO[] getCalculationAMTVOs(){
		CalculationAMTVO[] vos = (CalculationAMTVO[])models.toArray(new CalculationAMTVO[models.size()]);
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
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgCd = this.msgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgDesc = this.msgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlCnt = this.dtlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateCurCd = this.rateCurCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

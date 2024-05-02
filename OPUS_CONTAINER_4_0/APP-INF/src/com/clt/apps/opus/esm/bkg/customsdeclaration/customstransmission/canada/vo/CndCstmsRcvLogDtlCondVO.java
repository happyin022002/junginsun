/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CndCstmsRcvLogDtlCondVO.java
*@FileTitle : CndCstmsRcvLogDtlCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.05.28 김민정 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvLogDtlCondVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CndCstmsRcvLogDtlCondVO extends CstmsRcvLogDtlCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<CndCstmsRcvLogDtlCondVO> models = new ArrayList<CndCstmsRcvLogDtlCondVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String cstmsBatNo = null;
	/* Column Info */
	private String rcvSeq = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CndCstmsRcvLogDtlCondVO() {}

	public CndCstmsRcvLogDtlCondVO(String ibflag, String pagerows, String cntCd, String ioBndCd, String rcvDt, String rcvSeq, String cstmsBatNo) {
		this.ibflag = ibflag;
		this.rcvDt = rcvDt;
		this.cntCd = cntCd;
		this.cstmsBatNo = cstmsBatNo;
		this.rcvSeq = rcvSeq;
		this.ioBndCd = ioBndCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("cstms_bat_no", getCstmsBatNo());
		this.hashColumns.put("rcv_seq", getRcvSeq());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rcv_dtl_seq", "rcvDtlSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("cstms_bat_no", "cstmsBatNo");
		this.hashFields.put("rcv_seq", "rcvSeq");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsBatNo
	 */
	public String getCstmsBatNo() {
		return this.cstmsBatNo;
	}
	
	/**
	 * Column Info
	 * @return rcvSeq
	 */
	public String getRcvSeq() {
		return this.rcvSeq;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsBatNo
	 */
	public void setCstmsBatNo(String cstmsBatNo) {
		this.cstmsBatNo = cstmsBatNo;
	}
	
	/**
	 * Column Info
	 * @param rcvSeq
	 */
	public void setRcvSeq(String rcvSeq) {
		this.rcvSeq = rcvSeq;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRcvDt(JSPUtil.getParameter(request, "rcv_dt", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setCstmsBatNo(JSPUtil.getParameter(request, "cstms_bat_no", ""));
		setRcvSeq(JSPUtil.getParameter(request, "rcv_seq", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CndCstmsRcvLogDtlCondVO[]
	 */
	public CndCstmsRcvLogDtlCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CndCstmsRcvLogDtlCondVO[]
	 */
	public CndCstmsRcvLogDtlCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CndCstmsRcvLogDtlCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt".trim(), length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd".trim(), length));
			String[] cstmsBatNo = (JSPUtil.getParameter(request, prefix	+ "cstms_bat_no".trim(), length));
			String[] rcvSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_seq".trim(), length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CndCstmsRcvLogDtlCondVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (cstmsBatNo[i] != null)
					model.setCstmsBatNo(cstmsBatNo[i]);
				if (rcvSeq[i] != null)
					model.setRcvSeq(rcvSeq[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCndCstmsRcvLogDtlCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CndCstmsRcvLogDtlCondVO[]
	 */
	public CndCstmsRcvLogDtlCondVO[] getCndCstmsRcvLogDtlCondVOs(){
		CndCstmsRcvLogDtlCondVO[] vos = (CndCstmsRcvLogDtlCondVO[])models.toArray(new CndCstmsRcvLogDtlCondVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsBatNo = this.cstmsBatNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvSeq = this.rcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

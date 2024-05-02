/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanManifestListRcvLogDetailVO.java
*@FileTitle : JapanManifestListRcvLogDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.07  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class JapanManifestListRcvLogDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<JapanManifestListRcvLogDetailVO> models = new ArrayList<JapanManifestListRcvLogDetailVO>();
	
	/* Column Info */
	private String total = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rn = null;
	/* Column Info */
	private String ediRcvMsg = null;
	/* Column Info */
	private String rcvDtlSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public JapanManifestListRcvLogDetailVO() {}

	public JapanManifestListRcvLogDetailVO(String ibflag, String pagerows, String rcvDtlSeq, String ediRcvMsg, String rn, String total) {
		this.total = total;
		this.ibflag = ibflag;
		this.rn = rn;
		this.ediRcvMsg = ediRcvMsg;
		this.rcvDtlSeq = rcvDtlSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rn", getRn());
		this.hashColumns.put("edi_rcv_msg", getEdiRcvMsg());
		this.hashColumns.put("rcv_dtl_seq", getRcvDtlSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rn", "rn");
		this.hashFields.put("edi_rcv_msg", "ediRcvMsg");
		this.hashFields.put("rcv_dtl_seq", "rcvDtlSeq");
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return rn
	 */
	public String getRn() {
		return this.rn;
	}
	
	/**
	 * Column Info
	 * @return ediRcvMsg
	 */
	public String getEdiRcvMsg() {
		return this.ediRcvMsg;
	}
	
	/**
	 * Column Info
	 * @return rcvDtlSeq
	 */
	public String getRcvDtlSeq() {
		return this.rcvDtlSeq;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param rn
	 */
	public void setRn(String rn) {
		this.rn = rn;
	}
	
	/**
	 * Column Info
	 * @param ediRcvMsg
	 */
	public void setEdiRcvMsg(String ediRcvMsg) {
		this.ediRcvMsg = ediRcvMsg;
	}
	
	/**
	 * Column Info
	 * @param rcvDtlSeq
	 */
	public void setRcvDtlSeq(String rcvDtlSeq) {
		this.rcvDtlSeq = rcvDtlSeq;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRn(JSPUtil.getParameter(request, "rn", ""));
		setEdiRcvMsg(JSPUtil.getParameter(request, "edi_rcv_msg", ""));
		setRcvDtlSeq(JSPUtil.getParameter(request, "rcv_dtl_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapanManifestListRcvLogDetailVO[]
	 */
	public JapanManifestListRcvLogDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JapanManifestListRcvLogDetailVO[]
	 */
	public JapanManifestListRcvLogDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapanManifestListRcvLogDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rn = (JSPUtil.getParameter(request, prefix	+ "rn", length));
			String[] ediRcvMsg = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_msg", length));
			String[] rcvDtlSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_dtl_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new JapanManifestListRcvLogDetailVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rn[i] != null)
					model.setRn(rn[i]);
				if (ediRcvMsg[i] != null)
					model.setEdiRcvMsg(ediRcvMsg[i]);
				if (rcvDtlSeq[i] != null)
					model.setRcvDtlSeq(rcvDtlSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapanManifestListRcvLogDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapanManifestListRcvLogDetailVO[]
	 */
	public JapanManifestListRcvLogDetailVO[] getJapanManifestListRcvLogDetailVOs(){
		JapanManifestListRcvLogDetailVO[] vos = (JapanManifestListRcvLogDetailVO[])models.toArray(new JapanManifestListRcvLogDetailVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rn = this.rn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvMsg = this.ediRcvMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDtlSeq = this.rcvDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IndiaIgmVslResultVO.java
*@FileTitle : IndiaIgmVslResultVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.06.24 경종윤 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.vo;

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
 * @author 경종윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IndiaIgmVslResultVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IndiaIgmVslResultVO> models = new ArrayList<IndiaIgmVslResultVO>();
	
	/* Column Info */
	private String idaAgnId = "";
	/* Column Info */
	private String vslDeclDt = "";
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = "";
	/* Column Info */
	private String idaLineNo = "";
	/* Column Info */
	private String callSgnNo = "";
	/* Column Info */
	private String arrDt = "";
	/* Column Info */
	private String skdVoyNo = "";
	/* Column Info */
	private String vslNm = "";
	/* Column Info */
	private String portCd = "";
	/* Column Info */
	private String idaDeclVslNo = "";
	/* Page Number */
	private String pagerows = "";

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IndiaIgmVslResultVO() {}

	public IndiaIgmVslResultVO(String ibflag, String pagerows, String idaDeclVslNo, String vslDeclDt, String vslNm, String callSgnNo, String skdVoyNo, String idaLineNo, String idaAgnId, String portCd, String arrDt) {
		this.idaAgnId = idaAgnId;
		this.vslDeclDt = vslDeclDt;
		this.ibflag = ibflag;
		this.idaLineNo = idaLineNo;
		this.callSgnNo = callSgnNo;
		this.arrDt = arrDt;
		this.skdVoyNo = skdVoyNo;
		this.vslNm = vslNm;
		this.portCd = portCd;
		this.idaDeclVslNo = idaDeclVslNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ida_agn_id", getIdaAgnId());
		this.hashColumns.put("vsl_decl_dt", getVslDeclDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ida_line_no", getIdaLineNo());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("arr_dt", getArrDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("ida_decl_vsl_no", getIdaDeclVslNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ida_agn_id", "idaAgnId");
		this.hashFields.put("vsl_decl_dt", "vslDeclDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ida_line_no", "idaLineNo");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("arr_dt", "arrDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("ida_decl_vsl_no", "idaDeclVslNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return idaAgnId
	 */
	public String getIdaAgnId() {
		return this.idaAgnId;
	}
	
	/**
	 * Column Info
	 * @return vslDeclDt
	 */
	public String getVslDeclDt() {
		return this.vslDeclDt;
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
	 * @return idaLineNo
	 */
	public String getIdaLineNo() {
		return this.idaLineNo;
	}
	
	/**
	 * Column Info
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
	}
	
	/**
	 * Column Info
	 * @return arrDt
	 */
	public String getArrDt() {
		return this.arrDt;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return idaDeclVslNo
	 */
	public String getIdaDeclVslNo() {
		return this.idaDeclVslNo;
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
	 * @param idaAgnId
	 */
	public void setIdaAgnId(String idaAgnId) {
		this.idaAgnId = idaAgnId;
	}
	
	/**
	 * Column Info
	 * @param vslDeclDt
	 */
	public void setVslDeclDt(String vslDeclDt) {
		this.vslDeclDt = vslDeclDt;
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
	 * @param idaLineNo
	 */
	public void setIdaLineNo(String idaLineNo) {
		this.idaLineNo = idaLineNo;
	}
	
	/**
	 * Column Info
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
	}
	
	/**
	 * Column Info
	 * @param arrDt
	 */
	public void setArrDt(String arrDt) {
		this.arrDt = arrDt;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param idaDeclVslNo
	 */
	public void setIdaDeclVslNo(String idaDeclVslNo) {
		this.idaDeclVslNo = idaDeclVslNo;
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
		setIdaAgnId(JSPUtil.getParameter(request, "ida_agn_id", ""));
		setVslDeclDt(JSPUtil.getParameter(request, "vsl_decl_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setIdaLineNo(JSPUtil.getParameter(request, "ida_line_no", ""));
		setCallSgnNo(JSPUtil.getParameter(request, "call_sgn_no", ""));
		setArrDt(JSPUtil.getParameter(request, "arr_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setVslNm(JSPUtil.getParameter(request, "vsl_nm", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setIdaDeclVslNo(JSPUtil.getParameter(request, "ida_decl_vsl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IndiaIgmVslResultVO[]
	 */
	public IndiaIgmVslResultVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IndiaIgmVslResultVO[]
	 */
	public IndiaIgmVslResultVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IndiaIgmVslResultVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] idaAgnId = (JSPUtil.getParameter(request, prefix	+ "ida_agn_id", length));
			String[] vslDeclDt = (JSPUtil.getParameter(request, prefix	+ "vsl_decl_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] idaLineNo = (JSPUtil.getParameter(request, prefix	+ "ida_line_no", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] arrDt = (JSPUtil.getParameter(request, prefix	+ "arr_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] idaDeclVslNo = (JSPUtil.getParameter(request, prefix	+ "ida_decl_vsl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new IndiaIgmVslResultVO();
				if (idaAgnId[i] != null)
					model.setIdaAgnId(idaAgnId[i]);
				if (vslDeclDt[i] != null)
					model.setVslDeclDt(vslDeclDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (idaLineNo[i] != null)
					model.setIdaLineNo(idaLineNo[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (arrDt[i] != null)
					model.setArrDt(arrDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (idaDeclVslNo[i] != null)
					model.setIdaDeclVslNo(idaDeclVslNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIndiaIgmVslResultVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IndiaIgmVslResultVO[]
	 */
	public IndiaIgmVslResultVO[] getIndiaIgmVslResultVOs(){
		IndiaIgmVslResultVO[] vos = (IndiaIgmVslResultVO[])models.toArray(new IndiaIgmVslResultVO[models.size()]);
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
		this.idaAgnId = this.idaAgnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDeclDt = this.vslDeclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaLineNo = this.idaLineNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDt = this.arrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaDeclVslNo = this.idaDeclVslNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

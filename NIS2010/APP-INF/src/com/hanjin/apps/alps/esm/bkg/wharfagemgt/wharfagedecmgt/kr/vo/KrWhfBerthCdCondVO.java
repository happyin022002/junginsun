/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WhfBerthCdCondVO.java
*@FileTitle : WhfBerthCdCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.07.21 정재엽 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBerthCdCondVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KrWhfBerthCdCondVO extends WhfBerthCdCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<KrWhfBerthCdCondVO> models = new ArrayList<KrWhfBerthCdCondVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String brthKrNm = null;
	/* Column Info */
	private String brthCd = null;
	/* Column Info */
	private String ioPortCd = null;
	/* Column Info */
	private String portCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KrWhfBerthCdCondVO() {}

	public KrWhfBerthCdCondVO(String ibflag, String pagerows, String portCd, String brthCd, String brthKrNm, String ioPortCd) {
		this.ibflag = ibflag;
		this.brthKrNm = brthKrNm;
		this.brthCd = brthCd;
		this.portCd = portCd;
		this.ioPortCd = ioPortCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("brth_kr_nm", getBrthKrNm());
		this.hashColumns.put("brth_cd", getBrthCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("io_port_cd", getIoPortCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("brth_kr_nm", "brthKrNm");
		this.hashFields.put("brth_cd", "brthCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("io_port_cd", "ioPortCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	
	
	public String getIoPortCd() {
		return ioPortCd;
	}

	public void setIoPortCd(String ioPortCd) {
		this.ioPortCd = ioPortCd;
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
	 * @return brthKrNm
	 */
	public String getBrthKrNm() {
		return this.brthKrNm;
	}
	
	/**
	 * Column Info
	 * @return brthCd
	 */
	public String getBrthCd() {
		return this.brthCd;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
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
	 * @param brthKrNm
	 */
	public void setBrthKrNm(String brthKrNm) {
		this.brthKrNm = brthKrNm;
	}
	
	/**
	 * Column Info
	 * @param brthCd
	 */
	public void setBrthCd(String brthCd) {
		this.brthCd = brthCd;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
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
		setBrthKrNm(JSPUtil.getParameter(request, "brth_kr_nm", ""));
		setBrthCd(JSPUtil.getParameter(request, "brth_cd", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setIoPortCd(JSPUtil.getParameter(request, "io_port_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return WhfBerthCdCondVO[]
	 */
	public KrWhfBerthCdCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return WhfBerthCdCondVO[]
	 */
	public KrWhfBerthCdCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KrWhfBerthCdCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] brthKrNm = (JSPUtil.getParameter(request, prefix	+ "brth_kr_nm", length));
			String[] brthCd = (JSPUtil.getParameter(request, prefix	+ "brth_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] ioPortCd = (JSPUtil.getParameter(request, prefix	+ "io_port_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new KrWhfBerthCdCondVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (brthKrNm[i] != null)
					model.setBrthKrNm(brthKrNm[i]);
				if (brthCd[i] != null)
					model.setBrthCd(brthCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (ioPortCd[i] != null)
					model.setIoPortCd(ioPortCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getWhfBerthCdCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return WhfBerthCdCondVO[]
	 */
	public KrWhfBerthCdCondVO[] getWhfBerthCdCondVOs(){
		KrWhfBerthCdCondVO[] vos = (KrWhfBerthCdCondVO[])models.toArray(new KrWhfBerthCdCondVO[models.size()]);
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
		this.brthKrNm = this.brthKrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brthCd = this.brthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioPortCd = this.ioPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsWhfEmlListCondVO.java
*@FileTitle : UsWhfEmlListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.07.31 김민정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfEmlListCondVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsWhfEmlListCondVO extends WhfEmlListCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsWhfEmlListCondVO> models = new ArrayList<UsWhfEmlListCondVO>();
	
	/* Column Info */
	private String ydEml3 = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String ydEml2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ydEml1 = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String brthDesc = null;
	/* Column Info */
	private String bilRcvPtyNm = null;
	/* Column Info */
	private String portCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsWhfEmlListCondVO() {}

	public UsWhfEmlListCondVO(String ibflag, String pagerows, String ofcCd, String portCd, String ydCd, String brthDesc, String bilRcvPtyNm, String ydEml1, String ydEml2, String ydEml3) {
		this.ydEml3 = ydEml3;
		this.ofcCd = ofcCd;
		this.ydEml2 = ydEml2;
		this.ibflag = ibflag;
		this.ydEml1 = ydEml1;
		this.ydCd = ydCd;
		this.brthDesc = brthDesc;
		this.bilRcvPtyNm = bilRcvPtyNm;
		this.portCd = portCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("yd_eml3", getYdEml3());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("yd_eml2", getYdEml2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yd_eml1", getYdEml1());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("brth_desc", getBrthDesc());
		this.hashColumns.put("bil_rcv_pty_nm", getBilRcvPtyNm());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("yd_eml3", "ydEml3");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("yd_eml2", "ydEml2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yd_eml1", "ydEml1");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("brth_desc", "brthDesc");
		this.hashFields.put("bil_rcv_pty_nm", "bilRcvPtyNm");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ydEml3
	 */
	public String getYdEml3() {
		return this.ydEml3;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return ydEml2
	 */
	public String getYdEml2() {
		return this.ydEml2;
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
	 * @return ydEml1
	 */
	public String getYdEml1() {
		return this.ydEml1;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return brthDesc
	 */
	public String getBrthDesc() {
		return this.brthDesc;
	}
	
	/**
	 * Column Info
	 * @return bilRcvPtyNm
	 */
	public String getBilRcvPtyNm() {
		return this.bilRcvPtyNm;
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
	 * Column Info
	 * @param ydEml3
	 */
	public void setYdEml3(String ydEml3) {
		this.ydEml3 = ydEml3;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param ydEml2
	 */
	public void setYdEml2(String ydEml2) {
		this.ydEml2 = ydEml2;
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
	 * @param ydEml1
	 */
	public void setYdEml1(String ydEml1) {
		this.ydEml1 = ydEml1;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param brthDesc
	 */
	public void setBrthDesc(String brthDesc) {
		this.brthDesc = brthDesc;
	}
	
	/**
	 * Column Info
	 * @param bilRcvPtyNm
	 */
	public void setBilRcvPtyNm(String bilRcvPtyNm) {
		this.bilRcvPtyNm = bilRcvPtyNm;
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
		setYdEml3(JSPUtil.getParameter(request, "yd_eml3", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setYdEml2(JSPUtil.getParameter(request, "yd_eml2", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setYdEml1(JSPUtil.getParameter(request, "yd_eml1", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setBrthDesc(JSPUtil.getParameter(request, "brth_desc", ""));
		setBilRcvPtyNm(JSPUtil.getParameter(request, "bil_rcv_pty_nm", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsWhfEmlListCondVO[]
	 */
	public UsWhfEmlListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsWhfEmlListCondVO[]
	 */
	public UsWhfEmlListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsWhfEmlListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ydEml3 = (JSPUtil.getParameter(request, prefix	+ "yd_eml3", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ydEml2 = (JSPUtil.getParameter(request, prefix	+ "yd_eml2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ydEml1 = (JSPUtil.getParameter(request, prefix	+ "yd_eml1", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] brthDesc = (JSPUtil.getParameter(request, prefix	+ "brth_desc", length));
			String[] bilRcvPtyNm = (JSPUtil.getParameter(request, prefix	+ "bil_rcv_pty_nm", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsWhfEmlListCondVO();
				if (ydEml3[i] != null)
					model.setYdEml3(ydEml3[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ydEml2[i] != null)
					model.setYdEml2(ydEml2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ydEml1[i] != null)
					model.setYdEml1(ydEml1[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (brthDesc[i] != null)
					model.setBrthDesc(brthDesc[i]);
				if (bilRcvPtyNm[i] != null)
					model.setBilRcvPtyNm(bilRcvPtyNm[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsWhfEmlListCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsWhfEmlListCondVO[]
	 */
	public UsWhfEmlListCondVO[] getUsWhfEmlListCondVOs(){
		UsWhfEmlListCondVO[] vos = (UsWhfEmlListCondVO[])models.toArray(new UsWhfEmlListCondVO[models.size()]);
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
		this.ydEml3 = this.ydEml3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydEml2 = this.ydEml2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydEml1 = this.ydEml1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brthDesc = this.brthDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilRcvPtyNm = this.bilRcvPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

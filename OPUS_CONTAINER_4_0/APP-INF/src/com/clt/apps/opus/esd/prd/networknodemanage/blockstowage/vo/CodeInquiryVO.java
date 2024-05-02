/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodeInquiryVO.java
*@FileTitle : CodeInquiryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 노승배
*@LastVersion : 1.0
* 2009.08.04 노승배 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.prd.networknodemanage.blockstowage.vo;

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
 * @author 노승배
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CodeInquiryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CodeInquiryVO> models = new ArrayList<CodeInquiryVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dest = null;
	/* Column Info */
	private String portCode = null;
	/* Column Info */
	private String bsCode = null;
	/* Column Info */
	private String laneCode = null;
	/* Column Info */
	private String hubCode = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CodeInquiryVO() {}

	public CodeInquiryVO(String ibflag, String pagerows, String portCode, String laneCode, String hubCode, String bsCode, String dest) {
		this.ibflag = ibflag;
		this.dest = dest;
		this.portCode = portCode;
		this.bsCode = bsCode;
		this.laneCode = laneCode;
		this.hubCode = hubCode;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dest", getDest());
		this.hashColumns.put("port_code", getPortCode());
		this.hashColumns.put("bs_code", getBsCode());
		this.hashColumns.put("lane_code", getLaneCode());
		this.hashColumns.put("hub_code", getHubCode());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dest", "dest");
		this.hashFields.put("port_code", "portCode");
		this.hashFields.put("bs_code", "bsCode");
		this.hashFields.put("lane_code", "laneCode");
		this.hashFields.put("hub_code", "hubCode");
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
	 * @return dest
	 */
	public String getDest() {
		return this.dest;
	}
	
	/**
	 * Column Info
	 * @return portCode
	 */
	public String getPortCode() {
		return this.portCode;
	}
	
	/**
	 * Column Info
	 * @return bsCode
	 */
	public String getBsCode() {
		return this.bsCode;
	}
	
	/**
	 * Column Info
	 * @return laneCode
	 */
	public String getLaneCode() {
		return this.laneCode;
	}
	
	/**
	 * Column Info
	 * @return hubCode
	 */
	public String getHubCode() {
		return this.hubCode;
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
	 * @param dest
	 */
	public void setDest(String dest) {
		this.dest = dest;
	}
	
	/**
	 * Column Info
	 * @param portCode
	 */
	public void setPortCode(String portCode) {
		this.portCode = portCode;
	}
	
	/**
	 * Column Info
	 * @param bsCode
	 */
	public void setBsCode(String bsCode) {
		this.bsCode = bsCode;
	}
	
	/**
	 * Column Info
	 * @param laneCode
	 */
	public void setLaneCode(String laneCode) {
		this.laneCode = laneCode;
	}
	
	/**
	 * Column Info
	 * @param hubCode
	 */
	public void setHubCode(String hubCode) {
		this.hubCode = hubCode;
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
		setDest(JSPUtil.getParameter(request, "dest", ""));
		setPortCode(JSPUtil.getParameter(request, "port_code", ""));
		setBsCode(JSPUtil.getParameter(request, "bs_code", ""));
		setLaneCode(JSPUtil.getParameter(request, "lane_code", ""));
		setHubCode(JSPUtil.getParameter(request, "hub_code", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CodeInquiryVO[]
	 */
	public CodeInquiryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CodeInquiryVO[]
	 */
	public CodeInquiryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CodeInquiryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dest = (JSPUtil.getParameter(request, prefix	+ "dest", length));
			String[] portCode = (JSPUtil.getParameter(request, prefix	+ "port_code", length));
			String[] bsCode = (JSPUtil.getParameter(request, prefix	+ "bs_code", length));
			String[] laneCode = (JSPUtil.getParameter(request, prefix	+ "lane_code", length));
			String[] hubCode = (JSPUtil.getParameter(request, prefix	+ "hub_code", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CodeInquiryVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dest[i] != null)
					model.setDest(dest[i]);
				if (portCode[i] != null)
					model.setPortCode(portCode[i]);
				if (bsCode[i] != null)
					model.setBsCode(bsCode[i]);
				if (laneCode[i] != null)
					model.setLaneCode(laneCode[i]);
				if (hubCode[i] != null)
					model.setHubCode(hubCode[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCodeInquiryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CodeInquiryVO[]
	 */
	public CodeInquiryVO[] getCodeInquiryVOs(){
		CodeInquiryVO[] vos = (CodeInquiryVO[])models.toArray(new CodeInquiryVO[models.size()]);
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
		this.dest = this.dest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCode = this.portCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsCode = this.bsCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCode = this.laneCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubCode = this.hubCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

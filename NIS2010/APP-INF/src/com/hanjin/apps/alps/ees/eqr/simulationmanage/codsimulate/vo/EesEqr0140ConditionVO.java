/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0140ConditionVO.java
*@FileTitle : EesEqr0140ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.04 채창호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.vo;

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
 * @author 채창호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0140ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0140ConditionVO> models = new ArrayList<EesEqr0140ConditionVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String basisPort = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bayport = null;
	/* Column Info */
	private String tpsztypeall = null;
	/* Column Info */
	private String row = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0140ConditionVO() {}

	public EesEqr0140ConditionVO(String ibflag, String pagerows, String vvd, String basisPort, String bayport, String tpsztypeall, String row) {
		this.vvd = vvd;
		this.basisPort = basisPort;
		this.ibflag = ibflag;
		this.bayport = bayport;
		this.tpsztypeall = tpsztypeall;
		this.row = row;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("basis_port", getBasisPort());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bayport", getBayport());
		this.hashColumns.put("tpsztypeall", getTpsztypeall());
		this.hashColumns.put("row", getRow());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("basis_port", "basisPort");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bayport", "bayport");
		this.hashFields.put("tpsztypeall", "tpsztypeall");
		this.hashFields.put("row", "row");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return basisPort
	 */
	public String getBasisPort() {
		return this.basisPort;
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
	 * @return bayport
	 */
	public String getBayport() {
		return this.bayport;
	}
	
	/**
	 * Column Info
	 * @return tpsztypeall
	 */
	public String getTpsztypeall() {
		return this.tpsztypeall;
	}
	
	/**
	 * Column Info
	 * @return row
	 */
	public String getRow() {
		return this.row;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param basisPort
	 */
	public void setBasisPort(String basisPort) {
		this.basisPort = basisPort;
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
	 * @param bayport
	 */
	public void setBayport(String bayport) {
		this.bayport = bayport;
	}
	
	/**
	 * Column Info
	 * @param tpsztypeall
	 */
	public void setTpsztypeall(String tpsztypeall) {
		this.tpsztypeall = tpsztypeall;
	}
	
	/**
	 * Column Info
	 * @param row
	 */
	public void setRow(String row) {
		this.row = row;
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
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setBasisPort(JSPUtil.getParameter(request, "basis_port", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBayport(JSPUtil.getParameter(request, "bayport", ""));
		setTpsztypeall(JSPUtil.getParameter(request, "tpsztypeall", ""));
		setRow(JSPUtil.getParameter(request, "row", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0140ConditionVO[]
	 */
	public EesEqr0140ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0140ConditionVO[]
	 */
	public EesEqr0140ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0140ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] basisPort = (JSPUtil.getParameter(request, prefix	+ "basis_port", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bayport = (JSPUtil.getParameter(request, prefix	+ "bayport", length));
			String[] tpsztypeall = (JSPUtil.getParameter(request, prefix	+ "tpsztypeall", length));
			String[] row = (JSPUtil.getParameter(request, prefix	+ "row", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0140ConditionVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (basisPort[i] != null)
					model.setBasisPort(basisPort[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bayport[i] != null)
					model.setBayport(bayport[i]);
				if (tpsztypeall[i] != null)
					model.setTpsztypeall(tpsztypeall[i]);
				if (row[i] != null)
					model.setRow(row[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0140ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0140ConditionVO[]
	 */
	public EesEqr0140ConditionVO[] getEesEqr0140ConditionVOs(){
		EesEqr0140ConditionVO[] vos = (EesEqr0140ConditionVO[])models.toArray(new EesEqr0140ConditionVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.basisPort = this.basisPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bayport = this.bayport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsztypeall = this.tpsztypeall .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.row = this.row .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

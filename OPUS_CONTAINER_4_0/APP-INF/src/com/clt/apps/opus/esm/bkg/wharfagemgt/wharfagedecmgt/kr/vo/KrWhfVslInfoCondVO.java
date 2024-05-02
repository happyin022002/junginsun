/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWhfVslInfoCondVO.java
*@FileTitle : KrWhfVslInfoCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.07.31 정재엽 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfVslInfoCondVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KrWhfVslInfoCondVO extends WhfVslInfoCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<KrWhfVslInfoCondVO> models = new ArrayList<KrWhfVslInfoCondVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Page Number */
	private String pagerows = null;

	private String portCd = null;

	private String whfBndCd = null;

	private String blNo = null;
	
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KrWhfVslInfoCondVO() {}

	public KrWhfVslInfoCondVO( String ibflag, String pagerows, String ioBndCd, String vvd, String vpsPortCd, String portCd, 
								String whfBndCd, String blNo ) {
		this.vvd = vvd;
		this.vpsPortCd = vpsPortCd;
		this.ibflag    = ibflag;
		this.ioBndCd   = ioBndCd;
		this.pagerows  = pagerows;
		this.portCd    = portCd;
		this.whfBndCd  = whfBndCd;	
		this.blNo  	   = blNo;	
	}	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("whf_bnd_cd", getWhfBndCd());
		this.hashColumns.put("bl_no", getBlNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("whf_bnd_cd", "whfBndCd");
		this.hashFields.put("bl_no", "blNo");
		return this.hashFields;
	}
	
	public String getBlNo() {
		return blNo;
	}

	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	public String getWhfBndCd() {
		return whfBndCd;
	}

	public void setWhfBndCd(String whfBndCd) {
		this.whfBndCd = whfBndCd;
	}

	public String getPortCd() {
		return portCd;
	}

	public void setPortCd(String portCd) {
		this.portCd = portCd;
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
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
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
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
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
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setWhfBndCd(JSPUtil.getParameter(request, "whf_bnd_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KrWhfVslInfoCondVO[]
	 */
	public KrWhfVslInfoCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KrWhfVslInfoCondVO[]
	 */
	public KrWhfVslInfoCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KrWhfVslInfoCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] whfBndCd = (JSPUtil.getParameter(request, prefix	+ "whf_bnd_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new KrWhfVslInfoCondVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (whfBndCd[i] != null)
					model.setWhfBndCd( whfBndCd[i] );
				if (blNo[i] != null)
					model.setBlNo( blNo[i] );
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKrWhfVslInfoCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KrWhfVslInfoCondVO[]
	 */
	public KrWhfVslInfoCondVO[] getKrWhfVslInfoCondVOs(){
		KrWhfVslInfoCondVO[] vos = (KrWhfVslInfoCondVO[])models.toArray(new KrWhfVslInfoCondVO[models.size()]);
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
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag   = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd  = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd   = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfBndCd = this.whfBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo 	  = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

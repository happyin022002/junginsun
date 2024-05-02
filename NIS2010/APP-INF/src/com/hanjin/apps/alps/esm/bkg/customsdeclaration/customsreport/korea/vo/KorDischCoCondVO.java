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

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.DischCoCondVO;
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

public class KorDischCoCondVO extends DischCoCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorDischCoCondVO> models = new ArrayList<KorDischCoCondVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cstmsDchgCoNm = null;
	/* Column Info */
	private String cstmsDchgCoId = null;
	/* Column Info */
	private String ioPortCd = null;
	/* Column Info */
	private String portCd = null;
	/* Page Number */
	private String pagerows = null;

	private String usrId = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorDischCoCondVO() {}

	public KorDischCoCondVO(String ibflag, String pagerows, String portCd, String cstmsDchgCoId, String cstmsDchgCoNm, String ioPortCd, String usrId) {
		this.ibflag = ibflag;
		this.cstmsDchgCoNm = cstmsDchgCoNm;
		this.cstmsDchgCoId = cstmsDchgCoId;
		this.portCd = portCd;
		this.ioPortCd = ioPortCd;
		this.pagerows = pagerows;
		this.usrId = usrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cstms_dchg_co_nm", getCstmsDchgCoNm());
		this.hashColumns.put("cstms_dchg_co_id", getCstmsDchgCoId());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("io_port_cd", getIoPortCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("usr_id", getUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cstms_dchg_co_nm", "cstmsDchgCoNm");
		this.hashFields.put("cstms_dchg_co_id", "cstmsDchgCoId");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("io_port_cd", "ioPortCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("usr_id", "usrId");
		return this.hashFields;
	}
	

	/**
	 * @return the usrId
	 */
	public String getUsrId() {
		return usrId;
	}

	/**
	 * @param usrId the usrId to set
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
	 * @return cstmsDchgCoNm
	 */
	public String getCstmsDchgCoNm() {
		return this.cstmsDchgCoNm;
	}
	
	/**
	 * Column Info
	 * @return cstmsDchgCoId
	 */
	public String getCstmsDchgCoId() {
		return this.cstmsDchgCoId;
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
	 * @param cstmsDchgCoNm
	 */
	public void setCstmsDchgCoNm(String cstmsDchgCoNm) {
		this.cstmsDchgCoNm = cstmsDchgCoNm;
	}
	
	/**
	 * Column Info
	 * @param cstmsDchgCoId
	 */
	public void setCstmsDchgCoId(String cstmsDchgCoId) {
		this.cstmsDchgCoId = cstmsDchgCoId;
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
		setCstmsDchgCoNm(JSPUtil.getParameter(request, "cstms_dchg_co_nm", ""));
		setCstmsDchgCoId(JSPUtil.getParameter(request, "cstms_dchg_co_id", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setIoPortCd(JSPUtil.getParameter(request, "io_port_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return WhfBerthCdCondVO[]
	 */
	public KorDischCoCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return WhfBerthCdCondVO[]
	 */
	public KorDischCoCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorDischCoCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cstmsDchgCoNm = (JSPUtil.getParameter(request, prefix	+ "cstms_dchg_co_nm", length));
			String[] cstmsDchgCoId = (JSPUtil.getParameter(request, prefix	+ "cstms_dchg_co_id", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] ioPortCd = (JSPUtil.getParameter(request, prefix	+ "io_port_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorDischCoCondVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cstmsDchgCoNm[i] != null)
					model.setCstmsDchgCoNm(cstmsDchgCoNm[i]);
				if (cstmsDchgCoId[i] != null)
					model.setCstmsDchgCoId(cstmsDchgCoId[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (ioPortCd[i] != null)
					model.setIoPortCd(ioPortCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDischCoCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return WhfBerthCdCondVO[]
	 */
	public KorDischCoCondVO[] getDischCoCondVOs(){
		KorDischCoCondVO[] vos = (KorDischCoCondVO[])models.toArray(new KorDischCoCondVO[models.size()]);
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
		this.cstmsDchgCoNm = this.cstmsDchgCoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDchgCoId = this.cstmsDchgCoId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioPortCd = this.ioPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWhfCommInvListCondVO.java
*@FileTitle : KrWhfCommInvListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.09.01 정재엽 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfCommInvListCondVO;
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

public class KrWhfCommInvListCondVO extends WhfCommInvListCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<KrWhfCommInvListCondVO> models = new ArrayList<KrWhfCommInvListCondVO>();
	
	/* Column Info */
	private String portNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String whfNtcDt1 = null;
	/* Column Info */
	private String whfBndCd = null;
	/* Column Info */
	private String whfNtcDt2 = null;
	/* Date 조건 Flag(Y: 허가일자, N:납기일자) */
	private String whfNtcFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String portCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KrWhfCommInvListCondVO() {}

	public KrWhfCommInvListCondVO(String ibflag, String pagerows, String whfNtcDt1, String whfNtcDt2, String portNm, String whfBndCd, String portCd, String whfNtcFlg) {
		this.portNm = portNm;
		this.ibflag = ibflag;
		this.whfNtcDt1 = whfNtcDt1;
		this.whfBndCd = whfBndCd;
		this.whfNtcDt2 = whfNtcDt2;
		this.pagerows = pagerows;
		this.portCd = portCd;
		this.whfNtcFlg = whfNtcFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("port_nm", getPortNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("whf_ntc_dt1", getWhfNtcDt1());
		this.hashColumns.put("whf_bnd_cd", getWhfBndCd());
		this.hashColumns.put("whf_ntc_dt2", getWhfNtcDt2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("whf_ntc_flg", getWhfNtcFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("port_nm", "portNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("whf_ntc_dt1", "whfNtcDt1");
		this.hashFields.put("whf_bnd_cd", "whfBndCd");
		this.hashFields.put("whf_ntc_dt2", "whfNtcDt2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("whf_ntc_flg", "whfNtcFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return portNm
	 */
	public String getPortNm() {
		return this.portNm;
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
	 * @return whfNtcDt1
	 */
	public String getWhfNtcDt1() {
		return this.whfNtcDt1;
	}
	
	/**
	 * Column Info
	 * @return whfBndCd
	 */
	public String getWhfBndCd() {
		return this.whfBndCd;
	}
	
	/**
	 * Column Info
	 * @return whfNtcDt2
	 */
	public String getWhfNtcDt2() {
		return this.whfNtcDt2;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	

	public String getPortCd() {
		return portCd;
	}

	public String getWhfNtcFlg() {
		return whfNtcFlg;
	}
	
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}

	/**
	 * Column Info
	 * @param portNm
	 */
	public void setPortNm(String portNm) {
		this.portNm = portNm;
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
	 * @param whfNtcDt1
	 */
	public void setWhfNtcDt1(String whfNtcDt1) {
		this.whfNtcDt1 = whfNtcDt1;
	}
	
	/**
	 * Column Info
	 * @param whfBndCd
	 */
	public void setWhfBndCd(String whfBndCd) {
		this.whfBndCd = whfBndCd;
	}
	
	/**
	 * Column Info
	 * @param whfNtcDt2
	 */
	public void setWhfNtcDt2(String whfNtcDt2) {
		this.whfNtcDt2 = whfNtcDt2;
	}
	
	/**
	 * whfNtcFlg
	 * @param whfNtcFlg
	 */
	public void setWhfNtcFlg(String whfNtcFlg) {
		this.whfNtcFlg = whfNtcFlg;
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
		setPortNm(JSPUtil.getParameter(request, "port_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setWhfNtcDt1(JSPUtil.getParameter(request, "whf_ntc_dt1", ""));
		setWhfBndCd(JSPUtil.getParameter(request, "whf_bnd_cd", ""));
		setWhfNtcDt2(JSPUtil.getParameter(request, "whf_ntc_dt2", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setWhfNtcFlg(JSPUtil.getParameter(request, "whf_ntc_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return WhfCommInvListCondVO[]
	 */
	public KrWhfCommInvListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return WhfCommInvListCondVO[]
	 */
	public KrWhfCommInvListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KrWhfCommInvListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] portNm = (JSPUtil.getParameter(request, prefix	+ "port_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] whfNtcDt1 = (JSPUtil.getParameter(request, prefix	+ "whf_ntc_dt1", length));
			String[] whfBndCd = (JSPUtil.getParameter(request, prefix	+ "whf_bnd_cd", length));
			String[] whfNtcDt2 = (JSPUtil.getParameter(request, prefix	+ "whf_ntc_dt2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] whfNtcFlg = (JSPUtil.getParameter(request, prefix	+ "whf_ntc_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new KrWhfCommInvListCondVO();
				if (portNm[i] != null)
					model.setPortNm(portNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (whfNtcDt1[i] != null)
					model.setWhfNtcDt1(whfNtcDt1[i]);
				if (whfBndCd[i] != null)
					model.setWhfBndCd(whfBndCd[i]);
				if (whfNtcDt2[i] != null)
					model.setWhfNtcDt2(whfNtcDt2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (whfNtcFlg[i] != null)
					model.setWhfNtcFlg(whfNtcFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getWhfCommInvListCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return WhfCommInvListCondVO[]
	 */
	public KrWhfCommInvListCondVO[] getWhfCommInvListCondVOs(){
		KrWhfCommInvListCondVO[] vos = (KrWhfCommInvListCondVO[])models.toArray(new KrWhfCommInvListCondVO[models.size()]);
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
		this.portNm = this.portNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfNtcDt1 = this.whfNtcDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfBndCd = this.whfBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfNtcDt2 = this.whfNtcDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfNtcFlg = this.whfNtcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

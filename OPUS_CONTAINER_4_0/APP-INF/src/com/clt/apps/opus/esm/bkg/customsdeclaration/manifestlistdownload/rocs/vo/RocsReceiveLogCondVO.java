/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RocsReceiveLogCondVO.java
*@FileTitle : RocsReceiveLogCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.09.02 임재택 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ReceiveLogCondVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 임재택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RocsReceiveLogCondVO extends ReceiveLogCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<RocsReceiveLogCondVO> models = new ArrayList<RocsReceiveLogCondVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sheetMsgSndDt = null;
	/* Column Info */
	private String rcvSndDivCd = null;
	/* Column Info */
	private String sheetBlNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RocsReceiveLogCondVO() {}

	public RocsReceiveLogCondVO(String ibflag, String pagerows, String rcvSndDivCd, String sheetMsgSndDt, String sheetBlNo) {
		this.ibflag = ibflag;
		this.sheetMsgSndDt = sheetMsgSndDt;
		this.rcvSndDivCd = rcvSndDivCd;
		this.sheetBlNo = sheetBlNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sheet_msg_snd_dt", getSheetMsgSndDt());
		this.hashColumns.put("rcv_snd_div_cd", getRcvSndDivCd());
		this.hashColumns.put("sheet_bl_no", getSheetBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sheet_msg_snd_dt", "sheetMsgSndDt");
		this.hashFields.put("rcv_snd_div_cd", "rcvSndDivCd");
		this.hashFields.put("sheet_bl_no", "sheetBlNo");
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
	 * @return sheetMsgSndDt
	 */
	public String getSheetMsgSndDt() {
		return this.sheetMsgSndDt;
	}
	
	/**
	 * Column Info
	 * @return rcvSndDivCd
	 */
	public String getRcvSndDivCd() {
		return this.rcvSndDivCd;
	}
	
	/**
	 * Column Info
	 * @return sheetBlNo
	 */
	public String getSheetBlNo() {
		return this.sheetBlNo;
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
	 * @param sheetMsgSndDt
	 */
	public void setSheetMsgSndDt(String sheetMsgSndDt) {
		this.sheetMsgSndDt = sheetMsgSndDt;
	}
	
	/**
	 * Column Info
	 * @param rcvSndDivCd
	 */
	public void setRcvSndDivCd(String rcvSndDivCd) {
		this.rcvSndDivCd = rcvSndDivCd;
	}
	
	/**
	 * Column Info
	 * @param sheetBlNo
	 */
	public void setSheetBlNo(String sheetBlNo) {
		this.sheetBlNo = sheetBlNo;
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
		setSheetMsgSndDt(JSPUtil.getParameter(request, "sheet_msg_snd_dt", ""));
		setRcvSndDivCd(JSPUtil.getParameter(request, "rcv_snd_div_cd", ""));
		setSheetBlNo(JSPUtil.getParameter(request, "sheet_bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RocsReceiveLogCondVO[]
	 */
	public RocsReceiveLogCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RocsReceiveLogCondVO[]
	 */
	public RocsReceiveLogCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RocsReceiveLogCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sheetMsgSndDt = (JSPUtil.getParameter(request, prefix	+ "sheet_msg_snd_dt", length));
			String[] rcvSndDivCd = (JSPUtil.getParameter(request, prefix	+ "rcv_snd_div_cd", length));
			String[] sheetBlNo = (JSPUtil.getParameter(request, prefix	+ "sheet_bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RocsReceiveLogCondVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sheetMsgSndDt[i] != null)
					model.setSheetMsgSndDt(sheetMsgSndDt[i]);
				if (rcvSndDivCd[i] != null)
					model.setRcvSndDivCd(rcvSndDivCd[i]);
				if (sheetBlNo[i] != null)
					model.setSheetBlNo(sheetBlNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRocsReceiveLogCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RocsReceiveLogCondVO[]
	 */
	public RocsReceiveLogCondVO[] getRocsReceiveLogCondVOs(){
		RocsReceiveLogCondVO[] vos = (RocsReceiveLogCondVO[])models.toArray(new RocsReceiveLogCondVO[models.size()]);
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
		this.sheetMsgSndDt = this.sheetMsgSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvSndDivCd = this.rcvSndDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetBlNo = this.sheetBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

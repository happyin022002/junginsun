/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrMfLineInfoVO.java
*@FileTitle : CntrMfLineInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.06
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.06.06 김도완 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김도완
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaCMVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaCMVO> models = new ArrayList<UsaCMVO>();
	

	/* Column Info */
	private String cmdSeq = null;
	/* Column Info */
	private String icmHtCd = null;
	/* Column Info */
	private String icmWgtVal = null;
	/* Column Info */
	private String icmWgtQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String icmWgtTp = null;
	/* Column Info */
	private String icmPkgQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String icmDesc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaCMVO() {}

	public UsaCMVO(String ibflag, String pagerows, String cmdSeq, String icmWgtTp, String icmWgtVal, String icmWgtQty, String icmDesc, String icmPkgQty, String icmHtCd) {

		this.cmdSeq = cmdSeq;
		this.icmHtCd = icmHtCd;
		this.icmWgtVal = icmWgtVal;
		this.icmWgtQty = icmWgtQty;
		this.pagerows = pagerows;
		this.icmWgtTp = icmWgtTp;
		this.icmPkgQty = icmPkgQty;
		this.ibflag = ibflag;
		this.icmDesc = icmDesc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cmd_seq", getCmdSeq());
		this.hashColumns.put("icm_ht_cd", getIcmHtCd());
		this.hashColumns.put("icm_wgt_val", getIcmWgtVal());
		this.hashColumns.put("icm_wgt_qty", getIcmWgtQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("icm_wgt_tp", getIcmWgtTp());
		this.hashColumns.put("icm_pkg_qty", getIcmPkgQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("icm_desc", getIcmDesc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cmd_seq", "cmdSeq");
		this.hashFields.put("icm_ht_cd", "icmHtCd");
		this.hashFields.put("icm_wgt_val", "icmWgtVal");
		this.hashFields.put("icm_wgt_qty", "icmWgtQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("icm_wgt_tp", "icmWgtTp");
		this.hashFields.put("icm_pkg_qty", "icmPkgQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("icm_desc", "icmDesc");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cmdSeq
	 */
	public String getCmdSeq() {
		return this.cmdSeq;
	}
		
	/**
	 * Column Info
	 * @return icmHtCd
	 */
	public String getIcmHtCd() {
		return this.icmHtCd;
	}
	
	/**
	 * Column Info
	 * @return icmWgtVal
	 */
	public String getIcmWgtVal() {
		return this.icmWgtVal;
	}
	
	/**
	 * Column Info
	 * @return icmWgtQty
	 */
	public String getIcmWgtQty() {
		return this.icmWgtQty;
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
	 * @return icmWgtTp
	 */
	public String getIcmWgtTp() {
		return this.icmWgtTp;
	}
	
	/**
	 * Column Info
	 * @return icmPkgQty
	 */
	public String getIcmPkgQty() {
		return this.icmPkgQty;
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
	 * @return icmDesc
	 */
	public String getIcmDesc() {
		return this.icmDesc;
	}
	
	/**
	 * Column Info
	 * @param cmdSeq
	 */
	public void setCmdSeq(String cmdSeq) {
		this.cmdSeq = cmdSeq;
	}
	
	/**
	 * Column Info
	 * @param icmHtCd
	 */
	public void setIcmHtCd(String icmHtCd) {
		this.icmHtCd = icmHtCd;
	}
	
	/**
	 * Column Info
	 * @param icmWgtVal
	 */
	public void setIcmWgtVal(String icmWgtVal) {
		this.icmWgtVal = icmWgtVal;
	}
	
	/**
	 * Column Info
	 * @param icmWgtQty
	 */
	public void setIcmWgtQty(String icmWgtQty) {
		this.icmWgtQty = icmWgtQty;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param icmWgtTp
	 */
	public void setIcmWgtTp(String icmWgtTp) {
		this.icmWgtTp = icmWgtTp;
	}
	
	/**
	 * Column Info
	 * @param icmPkgQty
	 */
	public void setIcmPkgQty(String icmPkgQty) {
		this.icmPkgQty = icmPkgQty;
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
	 * @param icmDesc
	 */
	public void setIcmDesc(String icmDesc) {
		this.icmDesc = icmDesc;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCmdSeq(JSPUtil.getParameter(request, "cmd_seq", ""));
		setIcmHtCd(JSPUtil.getParameter(request, "icm_ht_cd", ""));
		setIcmWgtVal(JSPUtil.getParameter(request, "icm_wgt_val", ""));
		setIcmWgtQty(JSPUtil.getParameter(request, "icm_wgt_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIcmWgtTp(JSPUtil.getParameter(request, "icm_wgt_tp", ""));
		setIcmPkgQty(JSPUtil.getParameter(request, "icm_pkg_qty", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setIcmDesc(JSPUtil.getParameter(request, "icm_desc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaCMVO[]
	 */
	public UsaCMVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaCMVO[]
	 */
	public UsaCMVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaCMVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cmdSeq = (JSPUtil.getParameter(request, prefix	+ "cmd_seq".trim(), length));
			String[] icmHtCd = (JSPUtil.getParameter(request, prefix	+ "icm_ht_cd".trim(), length));
			String[] icmWgtVal = (JSPUtil.getParameter(request, prefix	+ "icm_wgt_val".trim(), length));
			String[] icmWgtQty = (JSPUtil.getParameter(request, prefix	+ "icm_wgt_qty".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] icmWgtTp = (JSPUtil.getParameter(request, prefix	+ "icm_wgt_tp".trim(), length));
			String[] icmPkgQty = (JSPUtil.getParameter(request, prefix	+ "icm_pkg_qty".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] icmDesc = (JSPUtil.getParameter(request, prefix	+ "icm_desc".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaCMVO();
				if (cmdSeq[i] != null)
					model.setCmdSeq(cmdSeq[i]);
				if (icmHtCd[i] != null)
					model.setIcmHtCd(icmHtCd[i]);
				if (icmWgtVal[i] != null)
					model.setIcmWgtVal(icmWgtVal[i]);
				if (icmWgtQty[i] != null)
					model.setIcmWgtQty(icmWgtQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (icmWgtTp[i] != null)
					model.setIcmWgtTp(icmWgtTp[i]);
				if (icmPkgQty[i] != null)
					model.setIcmPkgQty(icmPkgQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (icmDesc[i] != null)
					model.setIcmDesc(icmDesc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaCMVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaCMVO[]
	 */
	public UsaCMVO[] getUsaCMVOs(){
		UsaCMVO[] vos = (UsaCMVO[])models.toArray(new UsaCMVO[models.size()]);
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
		this.cmdSeq = this.cmdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.icmHtCd = this.icmHtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.icmWgtVal = this.icmWgtVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.icmWgtQty = this.icmWgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.icmWgtTp = this.icmWgtTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.icmPkgQty = this.icmPkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.icmDesc = this.icmDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

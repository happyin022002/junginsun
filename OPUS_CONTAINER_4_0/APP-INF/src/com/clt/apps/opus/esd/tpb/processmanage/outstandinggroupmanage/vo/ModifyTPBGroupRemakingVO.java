/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ModifyTPBGroupRemakingVO.java
*@FileTitle : ModifyTPBGroupRemakingVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.09.01 최 선 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.vo;

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
 * @author 최 선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ModifyTPBGroupRemakingVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ModifyTPBGroupRemakingVO> models = new ArrayList<ModifyTPBGroupRemakingVO>();
	
	/* Column Info */
	private String sUserOfcCd = null;
	/* Column Info */
	private String sUserId = null;
	/* Column Info */
	private String n3ptyNo = null;
	/* Column Info */
	private String n3ptyNoOrg = null;
	/* Column Info */
	private String otsDtlSeq = null;
	/* Column Info */
	private String ibflag = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ModifyTPBGroupRemakingVO() {}

	public ModifyTPBGroupRemakingVO(String sUserOfcCd, String sUserId, String n3ptyNo, String n3ptyNoOrg, String otsDtlSeq, String ibflag) {
		this.sUserOfcCd = sUserOfcCd;
		this.sUserId = sUserId;
		this.n3ptyNo = n3ptyNo;
		this.n3ptyNoOrg = n3ptyNoOrg;
		this.otsDtlSeq = otsDtlSeq;
		this.ibflag = ibflag;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_user_ofc_cd", getSUserOfcCd());
		this.hashColumns.put("s_user_id", getSUserId());
		this.hashColumns.put("n3pty_no", getN3ptyNo());
		this.hashColumns.put("n3pty_no_org", getN3ptyNoOrg());
		this.hashColumns.put("ots_dtl_seq", getOtsDtlSeq());
		this.hashColumns.put("ibflag", getIbflag());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_user_ofc_cd", "sUserOfcCd");
		this.hashFields.put("s_user_id", "sUserId");
		this.hashFields.put("n3pty_no", "n3ptyNo");
		this.hashFields.put("n3pty_no_org", "n3ptyNoOrg");
		this.hashFields.put("ots_dtl_seq", "otsDtlSeq");
		this.hashFields.put("ibflag", "ibflag");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sUserOfcCd
	 */
	public String getSUserOfcCd() {
		return this.sUserOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sUserId
	 */
	public String getSUserId() {
		return this.sUserId;
	}
	
	/**
	 * Column Info
	 * @return n3ptyNo
	 */
	public String getN3ptyNo() {
		return this.n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @return n3ptyNoOrg
	 */
	public String getN3ptyNoOrg() {
		return this.n3ptyNoOrg;
	}
	
	/**
	 * Column Info
	 * @return otsDtlSeq
	 */
	public String getOtsDtlSeq() {
		return this.otsDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @param sUserOfcCd
	 */
	public void setSUserOfcCd(String sUserOfcCd) {
		this.sUserOfcCd = sUserOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sUserId
	 */
	public void setSUserId(String sUserId) {
		this.sUserId = sUserId;
	}
	
	/**
	 * Column Info
	 * @param n3ptyNo
	 */
	public void setN3ptyNo(String n3ptyNo) {
		this.n3ptyNo = n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @param n3ptyNoOrg
	 */
	public void setN3ptyNoOrg(String n3ptyNoOrg) {
		this.n3ptyNoOrg = n3ptyNoOrg;
	}
	
	/**
	 * Column Info
	 * @param sOtsDtlSeq
	 */
	public void setOtsDtlSeq(String otsDtlSeq) {
		this.otsDtlSeq = otsDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSUserOfcCd(JSPUtil.getParameter(request, "s_user_ofc_cd", ""));
		setSUserId(JSPUtil.getParameter(request, "s_user_id", ""));
		setN3ptyNo(JSPUtil.getParameter(request, "n3pty_no", ""));
		setN3ptyNoOrg(JSPUtil.getParameter(request, "n3pty_no_org", ""));
		setOtsDtlSeq(JSPUtil.getParameter(request, "ots_dtl_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchTPBGroupRemakingVO[]
	 */
	public ModifyTPBGroupRemakingVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchTPBGroupRemakingVO[]
	 */
	public ModifyTPBGroupRemakingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ModifyTPBGroupRemakingVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sUserOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_user_ofc_cd", length));
			String[] sUserId = (JSPUtil.getParameter(request, prefix	+ "s_user_id", length));
			String[] n3ptyNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_no", length));
			String[] n3ptyNoOrg = (JSPUtil.getParameter(request, prefix	+ "n3pty_no_org", length));
			String[] otsDtlSeq = (JSPUtil.getParameter(request, prefix	+ "ots_dtl_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));

			for (int i = 0; i < length; i++) {
				model = new ModifyTPBGroupRemakingVO();
				if (sUserOfcCd[i] != null)
					model.setSUserOfcCd(sUserOfcCd[i]);
				if (sUserId[i] != null)
					model.setSUserId(sUserId[i]);
				if (n3ptyNo[i] != null)
					model.setN3ptyNo(n3ptyNo[i]);
				if (n3ptyNoOrg[i] != null)
					model.setN3ptyNoOrg(n3ptyNoOrg[i]);
				if (otsDtlSeq[i] != null)
					model.setOtsDtlSeq(otsDtlSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchTPBGroupRemakingVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchTPBGroupRemakingVO[]
	 */
	public ModifyTPBGroupRemakingVO[] getSearchTPBGroupRemakingVOs(){
		ModifyTPBGroupRemakingVO[] vos = (ModifyTPBGroupRemakingVO[])models.toArray(new ModifyTPBGroupRemakingVO[models.size()]);
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
		this.sUserOfcCd = this.sUserOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sUserId = this.sUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNo = this.n3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNoOrg = this.n3ptyNoOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsDtlSeq = this.otsDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

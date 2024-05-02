/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PrdCnstRemarkVO.java
*@FileTitle : PrdCnstRemarkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.22
*@LastModifier : 이재위
*@LastVersion : 1.0
* 2009.08.22 이재위 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo;

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
 * @author 정선용
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PrdCnstRemarkVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PrdCnstRemarkVO> models = new ArrayList<PrdCnstRemarkVO>();
	
	/* Column Info */
	private String prdCtlNo = null;
	/* Column Info */
	private String trnkLane = null;
	/* Column Info */
	private String pol  = null;
	/* Column Info */
	private String pod  = null;
	/* Column Info */
	private String del  = null;
	/* Column Info */
	private String cnst_seq = null;
	/* Column Info */
	private String cnstFlg = null;
	/* Column Info */
	private String nod_cd  = null;
	/* Column Info */
	private String org_nod_cd  = null;
	/* Column Info */
	private String dest_nod_cd  = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PrdCnstRemarkVO() {}

	public PrdCnstRemarkVO(String prdCtlNo, String trnkLane, String pol, String pod, String del, String cnst_seq, String cnstFlg, String nod_cd, String org_nod_cd, String dest_nod_cd) {
		this.prdCtlNo = prdCtlNo;
		this.trnkLane = trnkLane;
		this.pol = pol;
		this.pod = pod;
		this.del = del;
		this.cnst_seq = cnst_seq;
		this.cnstFlg = cnstFlg;
		this.nod_cd = nod_cd;
		this.org_nod_cd = org_nod_cd;
		this.dest_nod_cd = dest_nod_cd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("prdCtlNo", getPrdCtlNo());
		this.hashColumns.put("trnkLane", getTrnkLane());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("cnst_seq", getCnst_seq());
		this.hashColumns.put("cnstFlg", getCnstFlg());
		this.hashColumns.put("nod_cd", getNod_cd());
		this.hashColumns.put("org_nod_cd", getOrg_nod_cd());
		this.hashColumns.put("dest_nod_cd", getDest_nod_cd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("prdCtlNo", "prdCtlNo");
		this.hashFields.put("trnkLane", "trnkLane");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("del", "del");
		this.hashFields.put("cnst_seq", "cnst_seq");
		this.hashFields.put("cnstFlg", "cnstFlg");
		this.hashFields.put("nod_cd", "nod_cd");
		this.hashFields.put("org_nod_cd", "org_nod_cd");
		this.hashFields.put("dest_nod_cd", "dest_nod_cd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return prdCtlNo
	 */
	public String getPrdCtlNo() {
		return this.prdCtlNo;
	}
	
	/**
	 * Column Info
	 * @return trnkLane
	 */
	public String getTrnkLane() {
		return this.trnkLane;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Page Number
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Page Number
	 * @return del
	 */
	public String getDel() {
		return this.del;
	}
	
	/**
	 * Column Info
	 * @return cnst_seq
	 */
	public String getCnst_seq() {
		return this.cnst_seq;
	}
	
	/**
	 * Column Info
	 * @return cnstFlg
	 */
	public String getCnstFlg() {
		return this.cnstFlg;
	}
	
	/**
	 * Column Info
	 * @return nod_cd
	 */
	public String getNod_cd() {
		return this.nod_cd;
	}
	
	/**
	 * Page Number
	 * @return org_nod_cd
	 */
	public String getOrg_nod_cd() {
		return this.org_nod_cd;
	}
	
	/**
	 * Page Number
	 * @return dest_nod_cd
	 */
	public String getDest_nod_cd() {
		return this.dest_nod_cd;
	}


	/**
	 * Column Info
	 * @param pcno
	 */
	public void setPrdCtlNo(String prdCtlNo) {
		this.prdCtlNo = prdCtlNo;
	}
	
	/**
	 * Column Info
	 * @param trnkLane
	 */
	public void setTrnkLane(String trnkLane) {
		this.trnkLane = trnkLane;
	}
	
	/**
	 * Page Number
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Page Number
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Page Number
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
	}
	
	/**
	 * Column Info
	 * @param cnst_seq
	 */
	public void setCnst_seq(String cnst_seq) {
		this.cnst_seq = cnst_seq;
	}
	
	/**
	 * Column Info
	 * @param cnstFlg
	 */
	public void setCnstFlg(String cnstFlg) {
		this.cnstFlg = cnstFlg;
	}
	
	/**
	 * Page Number
	 * @param nod_cd
	 */
	public void setNod_cd(String nod_cd) {
		this.nod_cd = nod_cd;
	}
	
	/**
	 * Page Number
	 * @param org_nod_cd
	 */
	public void setOrg_nod_cd(String org_nod_cd) {
		this.org_nod_cd = org_nod_cd;
	}
	
	/**
	 * Page Number
	 * @param dest_nod_cd
	 */
	public void setDest_nod_cd(String dest_nod_cd) {
		this.dest_nod_cd = dest_nod_cd;
	}
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPrdCtlNo(JSPUtil.getParameter(request, "prdCtlNo", ""));
		setTrnkLane(JSPUtil.getParameter(request, "trnkLane", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setDel(JSPUtil.getParameter(request, "del", ""));
		setCnst_seq(JSPUtil.getParameter(request, "cnst_seq", ""));
		setCnstFlg(JSPUtil.getParameter(request, "cnstFlg", ""));
		setNod_cd(JSPUtil.getParameter(request, "nod_cd", ""));
		setOrg_nod_cd(JSPUtil.getParameter(request, "org_nod_cd", ""));
		setDest_nod_cd(JSPUtil.getParameter(request, "dest_nod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PrdCnstRemarkVO[]
	 */
	public PrdCnstRemarkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	
	public PrdCnstRemarkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PrdCnstRemarkVO model = null;

		try {

			String[] prdCtlNo = request.getParameterValues("prdCtlNo");
			String[] trnkLane = request.getParameterValues("trnkLane");
			String[] pol = request.getParameterValues("pol");
			String[] pod = request.getParameterValues("pod");
			String[] del = request.getParameterValues("del");
			String[] cnst_seq = request.getParameterValues("cnst_seq");
			String[] cnstFlg = request.getParameterValues("cnstFlg");
			String[] nod_cd = request.getParameterValues("nod_cd");
			String[] org_nod_cd = request.getParameterValues("org_nod_cd");
			String[] dest_nod_cd = request.getParameterValues("dest_nod_cd");

		} catch (Exception e) {
			return null;
		}
		return getPrdCnstRemarkVOs();
	}
	/**
	 * VO 배열을 반환
	 * @return PrdCnstRemarkVO[]
	 */
	public PrdCnstRemarkVO[] getPrdCnstRemarkVOs(){
		PrdCnstRemarkVO[] vos = (PrdCnstRemarkVO[])models.toArray(new PrdCnstRemarkVO[models.size()]);
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
		this.prdCtlNo = this.prdCtlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkLane = this.trnkLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnst_seq = this.cnst_seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnstFlg = this.cnstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nod_cd = this.nod_cd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.org_nod_cd = this.org_nod_cd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dest_nod_cd = this.dest_nod_cd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

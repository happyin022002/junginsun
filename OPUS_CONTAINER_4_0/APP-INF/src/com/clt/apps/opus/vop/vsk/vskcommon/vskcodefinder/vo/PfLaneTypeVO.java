/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PfLaneTypeVO.java
*@FileTitle : PfLaneTypeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.06.02 정진우 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo;

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
 * @author 정진우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PfLaneTypeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PfLaneTypeVO> models = new ArrayList<PfLaneTypeVO>();
	
	/* Column Info */
	private String vslSvcTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslSlanNm = null;
	/* Column Info */
	private String pfSvcTpCd = null;
	/* Column Info */
	private String rnum = null;
	/* Column Info */
	private String slanStndFlg = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PfLaneTypeVO() {}

	public PfLaneTypeVO(String ibflag, String pagerows, String rnum, String vslSlanCd, String vslSlanNm, String pfSvcTpCd, String slanStndFlg, String vslSvcTpCd) {
		this.vslSvcTpCd = vslSvcTpCd;
		this.ibflag = ibflag;
		this.vslSlanNm = vslSlanNm;
		this.pfSvcTpCd = pfSvcTpCd;
		this.rnum = rnum;
		this.slanStndFlg = slanStndFlg;
		this.vslSlanCd = vslSlanCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_svc_tp_cd", getVslSvcTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_slan_nm", getVslSlanNm());
		this.hashColumns.put("pf_svc_tp_cd", getPfSvcTpCd());
		this.hashColumns.put("rnum", getRnum());
		this.hashColumns.put("slan_stnd_flg", getSlanStndFlg());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_svc_tp_cd", "vslSvcTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_slan_nm", "vslSlanNm");
		this.hashFields.put("pf_svc_tp_cd", "pfSvcTpCd");
		this.hashFields.put("rnum", "rnum");
		this.hashFields.put("slan_stnd_flg", "slanStndFlg");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslSvcTpCd
	 */
	public String getVslSvcTpCd() {
		return this.vslSvcTpCd;
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
	 * @return vslSlanNm
	 */
	public String getVslSlanNm() {
		return this.vslSlanNm;
	}
	
	/**
	 * Column Info
	 * @return pfSvcTpCd
	 */
	public String getPfSvcTpCd() {
		return this.pfSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @return rnum
	 */
	public String getRnum() {
		return this.rnum;
	}
	
	/**
	 * Column Info
	 * @return slanStndFlg
	 */
	public String getSlanStndFlg() {
		return this.slanStndFlg;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
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
	 * @param vslSvcTpCd
	 */
	public void setVslSvcTpCd(String vslSvcTpCd) {
		this.vslSvcTpCd = vslSvcTpCd;
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
	 * @param vslSlanNm
	 */
	public void setVslSlanNm(String vslSlanNm) {
		this.vslSlanNm = vslSlanNm;
	}
	
	/**
	 * Column Info
	 * @param pfSvcTpCd
	 */
	public void setPfSvcTpCd(String pfSvcTpCd) {
		this.pfSvcTpCd = pfSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @param rnum
	 */
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	
	/**
	 * Column Info
	 * @param slanStndFlg
	 */
	public void setSlanStndFlg(String slanStndFlg) {
		this.slanStndFlg = slanStndFlg;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
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
		setVslSvcTpCd(JSPUtil.getParameter(request, "vsl_svc_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslSlanNm(JSPUtil.getParameter(request, "vsl_slan_nm", ""));
		setPfSvcTpCd(JSPUtil.getParameter(request, "pf_svc_tp_cd", ""));
		setRnum(JSPUtil.getParameter(request, "rnum", ""));
		setSlanStndFlg(JSPUtil.getParameter(request, "slan_stnd_flg", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PfLaneTypeVO[]
	 */
	public PfLaneTypeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PfLaneTypeVO[]
	 */
	public PfLaneTypeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PfLaneTypeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_svc_tp_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] vslSlanNm = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_nm".trim(), length));
			String[] pfSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "pf_svc_tp_cd".trim(), length));
			String[] rnum = (JSPUtil.getParameter(request, prefix	+ "rnum".trim(), length));
			String[] slanStndFlg = (JSPUtil.getParameter(request, prefix	+ "slan_stnd_flg".trim(), length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new PfLaneTypeVO();
				if (vslSvcTpCd[i] != null)
					model.setVslSvcTpCd(vslSvcTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslSlanNm[i] != null)
					model.setVslSlanNm(vslSlanNm[i]);
				if (pfSvcTpCd[i] != null)
					model.setPfSvcTpCd(pfSvcTpCd[i]);
				if (rnum[i] != null)
					model.setRnum(rnum[i]);
				if (slanStndFlg[i] != null)
					model.setSlanStndFlg(slanStndFlg[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPfLaneTypeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PfLaneTypeVO[]
	 */
	public PfLaneTypeVO[] getPfLaneTypeVOs(){
		PfLaneTypeVO[] vos = (PfLaneTypeVO[])models.toArray(new PfLaneTypeVO[models.size()]);
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
		this.vslSvcTpCd = this.vslSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanNm = this.vslSlanNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSvcTpCd = this.pfSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnum = this.rnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanStndFlg = this.slanStndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

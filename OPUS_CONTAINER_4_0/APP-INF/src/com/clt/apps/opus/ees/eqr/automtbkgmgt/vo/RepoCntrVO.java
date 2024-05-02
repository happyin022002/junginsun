/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepoCntrVO.java
*@FileTitle : RepoCntrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.16
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.12.16 김병규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.automtbkgmgt.vo;

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
 * @author 김병규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RepoCntrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RepoCntrVO> models = new ArrayList<RepoCntrVO>(); 
	
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String stsCd = null;
	/* Column Info */
	private String bdlBtmFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrNoPst = null;
	/* Column Info */
	private String fullCntrNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String bdlNo = null;
	/* Column Info */
	private String preStsFlg = null;
	/* Column Info */
	private String tpszCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RepoCntrVO() {}

	public RepoCntrVO(String ibflag, String pagerows, String cntrNo, String cntrNoPst, String fullCntrNo, String tpszCd, String stsCd, String bdlNo, String podCd, String preStsFlg, String bdlBtmFlg) {
		this.podCd = podCd;
		this.stsCd = stsCd;
		this.bdlBtmFlg = bdlBtmFlg;
		this.ibflag = ibflag;
		this.cntrNoPst = cntrNoPst;
		this.fullCntrNo = fullCntrNo;
		this.cntrNo = cntrNo;
		this.bdlNo = bdlNo;
		this.preStsFlg = preStsFlg;
		this.tpszCd = tpszCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("sts_cd", getStsCd());
		this.hashColumns.put("bdl_btm_flg", getBdlBtmFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_no_pst", getCntrNoPst());
		this.hashColumns.put("full_cntr_no", getFullCntrNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("bdl_no", getBdlNo());
		this.hashColumns.put("pre_sts_flg", getPreStsFlg());
		this.hashColumns.put("tpsz_cd", getTpszCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("sts_cd", "stsCd");
		this.hashFields.put("bdl_btm_flg", "bdlBtmFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no_pst", "cntrNoPst");
		this.hashFields.put("full_cntr_no", "fullCntrNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("bdl_no", "bdlNo");
		this.hashFields.put("pre_sts_flg", "preStsFlg");
		this.hashFields.put("tpsz_cd", "tpszCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return stsCd
	 */
	public String getStsCd() {
		return this.stsCd;
	}
	
	/**
	 * Column Info
	 * @return bdlBtmFlg
	 */
	public String getBdlBtmFlg() {
		return this.bdlBtmFlg;
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
	 * @return cntrNoPst
	 */
	public String getCntrNoPst() {
		return this.cntrNoPst;
	}
	
	/**
	 * Column Info
	 * @return fullCntrNo
	 */
	public String getFullCntrNo() {
		return this.fullCntrNo;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return bdlNo
	 */
	public String getBdlNo() {
		return this.bdlNo;
	}
	
	/**
	 * Column Info
	 * @return preStsFlg
	 */
	public String getPreStsFlg() {
		return this.preStsFlg;
	}
	
	/**
	 * Column Info
	 * @return tpszCd
	 */
	public String getTpszCd() {
		return this.tpszCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param stsCd
	 */
	public void setStsCd(String stsCd) {
		this.stsCd = stsCd;
	}
	
	/**
	 * Column Info
	 * @param bdlBtmFlg
	 */
	public void setBdlBtmFlg(String bdlBtmFlg) {
		this.bdlBtmFlg = bdlBtmFlg;
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
	 * @param cntrNoPst
	 */
	public void setCntrNoPst(String cntrNoPst) {
		this.cntrNoPst = cntrNoPst;
	}
	
	/**
	 * Column Info
	 * @param fullCntrNo
	 */
	public void setFullCntrNo(String fullCntrNo) {
		this.fullCntrNo = fullCntrNo;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param bdlNo
	 */
	public void setBdlNo(String bdlNo) {
		this.bdlNo = bdlNo;
	}
	
	/**
	 * Column Info
	 * @param preStsFlg
	 */
	public void setPreStsFlg(String preStsFlg) {
		this.preStsFlg = preStsFlg;
	}
	
	/**
	 * Column Info
	 * @param tpszCd
	 */
	public void setTpszCd(String tpszCd) {
		this.tpszCd = tpszCd;
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
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setStsCd(JSPUtil.getParameter(request, "sts_cd", ""));
		setBdlBtmFlg(JSPUtil.getParameter(request, "bdl_btm_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrNoPst(JSPUtil.getParameter(request, "cntr_no_pst", ""));
		setFullCntrNo(JSPUtil.getParameter(request, "full_cntr_no", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setBdlNo(JSPUtil.getParameter(request, "bdl_no", ""));
		setPreStsFlg(JSPUtil.getParameter(request, "pre_sts_flg", ""));
		setTpszCd(JSPUtil.getParameter(request, "tpsz_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RepoCntrVO[]
	 */
	public RepoCntrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RepoCntrVO[]
	 */
	public RepoCntrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RepoCntrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] stsCd = (JSPUtil.getParameter(request, prefix	+ "sts_cd", length));
			String[] bdlBtmFlg = (JSPUtil.getParameter(request, prefix	+ "bdl_btm_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrNoPst = (JSPUtil.getParameter(request, prefix	+ "cntr_no_pst", length));
			String[] fullCntrNo = (JSPUtil.getParameter(request, prefix	+ "full_cntr_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] bdlNo = (JSPUtil.getParameter(request, prefix	+ "bdl_no", length));
			String[] preStsFlg = (JSPUtil.getParameter(request, prefix	+ "pre_sts_flg", length));
			String[] tpszCd = (JSPUtil.getParameter(request, prefix	+ "tpsz_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RepoCntrVO();
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (stsCd[i] != null)
					model.setStsCd(stsCd[i]);
				if (bdlBtmFlg[i] != null)
					model.setBdlBtmFlg(bdlBtmFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNoPst[i] != null)
					model.setCntrNoPst(cntrNoPst[i]);
				if (fullCntrNo[i] != null)
					model.setFullCntrNo(fullCntrNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (bdlNo[i] != null)
					model.setBdlNo(bdlNo[i]);
				if (preStsFlg[i] != null)
					model.setPreStsFlg(preStsFlg[i]);
				if (tpszCd[i] != null)
					model.setTpszCd(tpszCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRepoCntrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RepoCntrVO[]
	 */
	public RepoCntrVO[] getRepoCntrVOs(){
		RepoCntrVO[] vos = (RepoCntrVO[])models.toArray(new RepoCntrVO[models.size()]);
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
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsCd = this.stsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdlBtmFlg = this.bdlBtmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNoPst = this.cntrNoPst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullCntrNo = this.fullCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdlNo = this.bdlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preStsFlg = this.preStsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszCd = this.tpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

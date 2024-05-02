/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSimConditionVO.java
*@FileTitle : SearchSimConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.13  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.coa.lanesimulation.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSimConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSimConditionVO> models = new ArrayList<SearchSimConditionVO>();
	
	/* Column Info */
	private String fDeptCd2 = null;
	/* Column Info */
	private String fExtFlg = null;
	/* Column Info */
	private String fHeader = null;
	/* Column Info */
	private String fSlanCd = null;
	/* Column Info */
	private String fTmlCd = null;
	/* Column Info */
	private String fCmHeader = null;
	/* Column Info */
	private String fSgrpCostCd = null;
	/* Column Info */
	private String fSectNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fSimDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String fOpHeader = null;
	/* Column Info */
	private String fDeptCd = null;
	/* Column Info */
	private String fSimNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSimConditionVO() {}

	public SearchSimConditionVO(String ibflag, String pagerows, String fSlanCd, String fSimDt, String fSimNo, String fSectNo, String fDeptCd, String fDeptCd2, String fCmHeader, String fOpHeader, String fHeader, String fTmlCd, String fExtFlg, String fSgrpCostCd, String usrId) {
		this.fDeptCd2 = fDeptCd2;
		this.fExtFlg = fExtFlg;
		this.fHeader = fHeader;
		this.fSlanCd = fSlanCd;
		this.fTmlCd = fTmlCd;
		this.fCmHeader = fCmHeader;
		this.fSgrpCostCd = fSgrpCostCd;
		this.fSectNo = fSectNo;
		this.pagerows = pagerows;
		this.fSimDt = fSimDt;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.fOpHeader = fOpHeader;
		this.fDeptCd = fDeptCd;
		this.fSimNo = fSimNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_dept_cd2", getFDeptCd2());
		this.hashColumns.put("f_ext_flg", getFExtFlg());
		this.hashColumns.put("f_header", getFHeader());
		this.hashColumns.put("f_slan_cd", getFSlanCd());
		this.hashColumns.put("f_tml_cd", getFTmlCd());
		this.hashColumns.put("f_cm_header", getFCmHeader());
		this.hashColumns.put("f_sgrp_cost_cd", getFSgrpCostCd());
		this.hashColumns.put("f_sect_no", getFSectNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("f_sim_dt", getFSimDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("f_op_header", getFOpHeader());
		this.hashColumns.put("f_dept_cd", getFDeptCd());
		this.hashColumns.put("f_sim_no", getFSimNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_dept_cd2", "fDeptCd2");
		this.hashFields.put("f_ext_flg", "fExtFlg");
		this.hashFields.put("f_header", "fHeader");
		this.hashFields.put("f_slan_cd", "fSlanCd");
		this.hashFields.put("f_tml_cd", "fTmlCd");
		this.hashFields.put("f_cm_header", "fCmHeader");
		this.hashFields.put("f_sgrp_cost_cd", "fSgrpCostCd");
		this.hashFields.put("f_sect_no", "fSectNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("f_sim_dt", "fSimDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("f_op_header", "fOpHeader");
		this.hashFields.put("f_dept_cd", "fDeptCd");
		this.hashFields.put("f_sim_no", "fSimNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fDeptCd2
	 */
	public String getFDeptCd2() {
		return this.fDeptCd2;
	}
	
	/**
	 * Column Info
	 * @return fExtFlg
	 */
	public String getFExtFlg() {
		return this.fExtFlg;
	}
	
	/**
	 * Column Info
	 * @return fHeader
	 */
	public String getFHeader() {
		return this.fHeader;
	}
	
	/**
	 * Column Info
	 * @return fSlanCd
	 */
	public String getFSlanCd() {
		return this.fSlanCd;
	}
	
	/**
	 * Column Info
	 * @return fTmlCd
	 */
	public String getFTmlCd() {
		return this.fTmlCd;
	}
	
	/**
	 * Column Info
	 * @return fCmHeader
	 */
	public String getFCmHeader() {
		return this.fCmHeader;
	}
	
	/**
	 * Column Info
	 * @return fSgrpCostCd
	 */
	public String getFSgrpCostCd() {
		return this.fSgrpCostCd;
	}
	
	/**
	 * Column Info
	 * @return fSectNo
	 */
	public String getFSectNo() {
		return this.fSectNo;
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
	 * @return fSimDt
	 */
	public String getFSimDt() {
		return this.fSimDt;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return fOpHeader
	 */
	public String getFOpHeader() {
		return this.fOpHeader;
	}
	
	/**
	 * Column Info
	 * @return fDeptCd
	 */
	public String getFDeptCd() {
		return this.fDeptCd;
	}
	
	/**
	 * Column Info
	 * @return fSimNo
	 */
	public String getFSimNo() {
		return this.fSimNo;
	}
	

	/**
	 * Column Info
	 * @param fDeptCd2
	 */
	public void setFDeptCd2(String fDeptCd2) {
		this.fDeptCd2 = fDeptCd2;
	}
	
	/**
	 * Column Info
	 * @param fExtFlg
	 */
	public void setFExtFlg(String fExtFlg) {
		this.fExtFlg = fExtFlg;
	}
	
	/**
	 * Column Info
	 * @param fHeader
	 */
	public void setFHeader(String fHeader) {
		this.fHeader = fHeader;
	}
	
	/**
	 * Column Info
	 * @param fSlanCd
	 */
	public void setFSlanCd(String fSlanCd) {
		this.fSlanCd = fSlanCd;
	}
	
	/**
	 * Column Info
	 * @param fTmlCd
	 */
	public void setFTmlCd(String fTmlCd) {
		this.fTmlCd = fTmlCd;
	}
	
	/**
	 * Column Info
	 * @param fCmHeader
	 */
	public void setFCmHeader(String fCmHeader) {
		this.fCmHeader = fCmHeader;
	}
	
	/**
	 * Column Info
	 * @param fSgrpCostCd
	 */
	public void setFSgrpCostCd(String fSgrpCostCd) {
		this.fSgrpCostCd = fSgrpCostCd;
	}
	
	/**
	 * Column Info
	 * @param fSectNo
	 */
	public void setFSectNo(String fSectNo) {
		this.fSectNo = fSectNo;
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
	 * @param fSimDt
	 */
	public void setFSimDt(String fSimDt) {
		this.fSimDt = fSimDt;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param fOpHeader
	 */
	public void setFOpHeader(String fOpHeader) {
		this.fOpHeader = fOpHeader;
	}
	
	/**
	 * Column Info
	 * @param fDeptCd
	 */
	public void setFDeptCd(String fDeptCd) {
		this.fDeptCd = fDeptCd;
	}
	
	/**
	 * Column Info
	 * @param fSimNo
	 */
	public void setFSimNo(String fSimNo) {
		this.fSimNo = fSimNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFDeptCd2(JSPUtil.getParameter(request, "f_dept_cd2", ""));
		setFExtFlg(JSPUtil.getParameter(request, "f_ext_flg", ""));
		setFHeader(JSPUtil.getParameter(request, "f_header", ""));
		setFSlanCd(JSPUtil.getParameter(request, "f_slan_cd", ""));
		setFTmlCd(JSPUtil.getParameter(request, "f_tml_cd", ""));
		setFCmHeader(JSPUtil.getParameter(request, "f_cm_header", ""));
		setFSgrpCostCd(JSPUtil.getParameter(request, "f_sgrp_cost_cd", ""));
		setFSectNo(JSPUtil.getParameter(request, "f_sect_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFSimDt(JSPUtil.getParameter(request, "f_sim_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setFOpHeader(JSPUtil.getParameter(request, "f_op_header", ""));
		setFDeptCd(JSPUtil.getParameter(request, "f_dept_cd", ""));
		setFSimNo(JSPUtil.getParameter(request, "f_sim_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSimConditionVO[]
	 */
	public SearchSimConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSimConditionVO[]
	 */
	public SearchSimConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSimConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fDeptCd2 = (JSPUtil.getParameter(request, prefix	+ "f_dept_cd2", length));
			String[] fExtFlg = (JSPUtil.getParameter(request, prefix	+ "f_ext_flg", length));
			String[] fHeader = (JSPUtil.getParameter(request, prefix	+ "f_header", length));
			String[] fSlanCd = (JSPUtil.getParameter(request, prefix	+ "f_slan_cd", length));
			String[] fTmlCd = (JSPUtil.getParameter(request, prefix	+ "f_tml_cd", length));
			String[] fCmHeader = (JSPUtil.getParameter(request, prefix	+ "f_cm_header", length));
			String[] fSgrpCostCd = (JSPUtil.getParameter(request, prefix	+ "f_sgrp_cost_cd", length));
			String[] fSectNo = (JSPUtil.getParameter(request, prefix	+ "f_sect_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fSimDt = (JSPUtil.getParameter(request, prefix	+ "f_sim_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] fOpHeader = (JSPUtil.getParameter(request, prefix	+ "f_op_header", length));
			String[] fDeptCd = (JSPUtil.getParameter(request, prefix	+ "f_dept_cd", length));
			String[] fSimNo = (JSPUtil.getParameter(request, prefix	+ "f_sim_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSimConditionVO();
				if (fDeptCd2[i] != null)
					model.setFDeptCd2(fDeptCd2[i]);
				if (fExtFlg[i] != null)
					model.setFExtFlg(fExtFlg[i]);
				if (fHeader[i] != null)
					model.setFHeader(fHeader[i]);
				if (fSlanCd[i] != null)
					model.setFSlanCd(fSlanCd[i]);
				if (fTmlCd[i] != null)
					model.setFTmlCd(fTmlCd[i]);
				if (fCmHeader[i] != null)
					model.setFCmHeader(fCmHeader[i]);
				if (fSgrpCostCd[i] != null)
					model.setFSgrpCostCd(fSgrpCostCd[i]);
				if (fSectNo[i] != null)
					model.setFSectNo(fSectNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fSimDt[i] != null)
					model.setFSimDt(fSimDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (fOpHeader[i] != null)
					model.setFOpHeader(fOpHeader[i]);
				if (fDeptCd[i] != null)
					model.setFDeptCd(fDeptCd[i]);
				if (fSimNo[i] != null)
					model.setFSimNo(fSimNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSimConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSimConditionVO[]
	 */
	public SearchSimConditionVO[] getSearchSimConditionVOs(){
		SearchSimConditionVO[] vos = (SearchSimConditionVO[])models.toArray(new SearchSimConditionVO[models.size()]);
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
		this.fDeptCd2 = this.fDeptCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fExtFlg = this.fExtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fHeader = this.fHeader .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSlanCd = this.fSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTmlCd = this.fTmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCmHeader = this.fCmHeader .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSgrpCostCd = this.fSgrpCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSectNo = this.fSectNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSimDt = this.fSimDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOpHeader = this.fOpHeader .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDeptCd = this.fDeptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSimNo = this.fSimNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

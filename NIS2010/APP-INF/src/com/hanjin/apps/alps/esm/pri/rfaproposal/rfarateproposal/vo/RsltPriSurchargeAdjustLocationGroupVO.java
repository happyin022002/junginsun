/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPriSurchargeAdjustLocationGroupVO.java
*@FileTitle : RsltPriSurchargeAdjustLocationGroupVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.08.04 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo;

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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPriSurchargeAdjustLocationGroupVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriSurchargeAdjustLocationGroupVO> models = new ArrayList<RsltPriSurchargeAdjustLocationGroupVO>();
	
	/* Column Info */
	private String locDefCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String grpLocSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String prcGrpLocDesc = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String routLocTpCd = null;
	/* Column Info */
	private String selectType = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriSurchargeAdjustLocationGroupVO() {}

	public RsltPriSurchargeAdjustLocationGroupVO(String ibflag, String pagerows, String locDefCd, String prcGrpLocDesc, String propNo, String amdtSeq, String svcScpCd, String grpLocSeq, String routLocTpCd, String orgDestTpCd, String selectType) {
		this.locDefCd = locDefCd;
		this.ibflag = ibflag;
		this.amdtSeq = amdtSeq;
		this.propNo = propNo;
		this.grpLocSeq = grpLocSeq;
		this.svcScpCd = svcScpCd;
		this.prcGrpLocDesc = prcGrpLocDesc;
		this.orgDestTpCd = orgDestTpCd;
		this.routLocTpCd = routLocTpCd;
		this.selectType = selectType;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("loc_def_cd", getLocDefCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("grp_loc_seq", getGrpLocSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("prc_grp_loc_desc", getPrcGrpLocDesc());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("rout_loc_tp_cd", getRoutLocTpCd());
		this.hashColumns.put("select_type", getSelectType());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("loc_def_cd", "locDefCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("grp_loc_seq", "grpLocSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("prc_grp_loc_desc", "prcGrpLocDesc");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("rout_loc_tp_cd", "routLocTpCd");
		this.hashFields.put("select_type", "selectType");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return locDefCd
	 */
	public String getLocDefCd() {
		return this.locDefCd;
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
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return grpLocSeq
	 */
	public String getGrpLocSeq() {
		return this.grpLocSeq;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return prcGrpLocDesc
	 */
	public String getPrcGrpLocDesc() {
		return this.prcGrpLocDesc;
	}
	
	/**
	 * Column Info
	 * @return orgDestTpCd
	 */
	public String getOrgDestTpCd() {
		return this.orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @return routLocTpCd
	 */
	public String getRoutLocTpCd() {
		return this.routLocTpCd;
	}
	
	/**
	 * Column Info
	 * @return selectType
	 */
	public String getSelectType() {
		return this.selectType;
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
	 * @param locDefCd
	 */
	public void setLocDefCd(String locDefCd) {
		this.locDefCd = locDefCd;
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
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param grpLocSeq
	 */
	public void setGrpLocSeq(String grpLocSeq) {
		this.grpLocSeq = grpLocSeq;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param prcGrpLocDesc
	 */
	public void setPrcGrpLocDesc(String prcGrpLocDesc) {
		this.prcGrpLocDesc = prcGrpLocDesc;
	}
	
	/**
	 * Column Info
	 * @param orgDestTpCd
	 */
	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @param routLocTpCd
	 */
	public void setRoutLocTpCd(String routLocTpCd) {
		this.routLocTpCd = routLocTpCd;
	}
	
	/**
	 * Column Info
	 * @param selectType
	 */
	public void setSelectType(String selectType) {
		this.selectType = selectType;
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
		setLocDefCd(JSPUtil.getParameter(request, "loc_def_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setGrpLocSeq(JSPUtil.getParameter(request, "grp_loc_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setPrcGrpLocDesc(JSPUtil.getParameter(request, "prc_grp_loc_desc", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, "org_dest_tp_cd", ""));
		setRoutLocTpCd(JSPUtil.getParameter(request, "rout_loc_tp_cd", ""));
		setSelectType(JSPUtil.getParameter(request, "select_type", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriSurchargeAdjustLocationGroupVO[]
	 */
	public RsltPriSurchargeAdjustLocationGroupVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriSurchargeAdjustLocationGroupVO[]
	 */
	public RsltPriSurchargeAdjustLocationGroupVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriSurchargeAdjustLocationGroupVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] locDefCd = (JSPUtil.getParameter(request, prefix	+ "loc_def_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] grpLocSeq = (JSPUtil.getParameter(request, prefix	+ "grp_loc_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] prcGrpLocDesc = (JSPUtil.getParameter(request, prefix	+ "prc_grp_loc_desc", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] routLocTpCd = (JSPUtil.getParameter(request, prefix	+ "rout_loc_tp_cd", length));
			String[] selectType = (JSPUtil.getParameter(request, prefix	+ "select_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriSurchargeAdjustLocationGroupVO();
				if (locDefCd[i] != null)
					model.setLocDefCd(locDefCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (grpLocSeq[i] != null)
					model.setGrpLocSeq(grpLocSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (prcGrpLocDesc[i] != null)
					model.setPrcGrpLocDesc(prcGrpLocDesc[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (routLocTpCd[i] != null)
					model.setRoutLocTpCd(routLocTpCd[i]);
				if (selectType[i] != null)
					model.setSelectType(selectType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriSurchargeAdjustLocationGroupVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriSurchargeAdjustLocationGroupVO[]
	 */
	public RsltPriSurchargeAdjustLocationGroupVO[] getRsltPriSurchargeAdjustLocationGroupVOs(){
		RsltPriSurchargeAdjustLocationGroupVO[] vos = (RsltPriSurchargeAdjustLocationGroupVO[])models.toArray(new RsltPriSurchargeAdjustLocationGroupVO[models.size()]);
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
		this.locDefCd = this.locDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpLocSeq = this.grpLocSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcGrpLocDesc = this.prcGrpLocDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routLocTpCd = this.routLocTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selectType = this.selectType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

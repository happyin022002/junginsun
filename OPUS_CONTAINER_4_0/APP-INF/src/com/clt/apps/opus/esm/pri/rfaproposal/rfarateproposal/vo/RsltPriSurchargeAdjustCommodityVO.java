/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPriSurchargeAdjustCommodityVO.java
*@FileTitle : RsltPriSurchargeAdjustCommodityVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.08.04 송민석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo;

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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPriSurchargeAdjustCommodityVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriSurchargeAdjustCommodityVO> models = new ArrayList<RsltPriSurchargeAdjustCommodityVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String prcGrpCmdtDesc = null;
	/* Column Info */
	private String prcCmdtTpCd = null;
	/* Column Info */
	private String grpCmdtSeq = null;
	/* Column Info */
	private String prcCmdtDefCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriSurchargeAdjustCommodityVO() {}

	public RsltPriSurchargeAdjustCommodityVO(String ibflag, String pagerows, String prcCmdtDefCd, String prcGrpCmdtDesc, String propNo, String amdtSeq, String svcScpCd, String grpCmdtSeq, String prcCmdtTpCd) {
		this.ibflag = ibflag;
		this.amdtSeq = amdtSeq;
		this.propNo = propNo;
		this.svcScpCd = svcScpCd;
		this.prcGrpCmdtDesc = prcGrpCmdtDesc;
		this.prcCmdtTpCd = prcCmdtTpCd;
		this.grpCmdtSeq = grpCmdtSeq;
		this.prcCmdtDefCd = prcCmdtDefCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("prc_grp_cmdt_desc", getPrcGrpCmdtDesc());
		this.hashColumns.put("prc_cmdt_tp_cd", getPrcCmdtTpCd());
		this.hashColumns.put("grp_cmdt_seq", getGrpCmdtSeq());
		this.hashColumns.put("prc_cmdt_def_cd", getPrcCmdtDefCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("prc_grp_cmdt_desc", "prcGrpCmdtDesc");
		this.hashFields.put("prc_cmdt_tp_cd", "prcCmdtTpCd");
		this.hashFields.put("grp_cmdt_seq", "grpCmdtSeq");
		this.hashFields.put("prc_cmdt_def_cd", "prcCmdtDefCd");
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
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return prcGrpCmdtDesc
	 */
	public String getPrcGrpCmdtDesc() {
		return this.prcGrpCmdtDesc;
	}
	
	/**
	 * Column Info
	 * @return prcCmdtTpCd
	 */
	public String getPrcCmdtTpCd() {
		return this.prcCmdtTpCd;
	}
	
	/**
	 * Column Info
	 * @return grpCmdtSeq
	 */
	public String getGrpCmdtSeq() {
		return this.grpCmdtSeq;
	}
	
	/**
	 * Column Info
	 * @return prcCmdtDefCd
	 */
	public String getPrcCmdtDefCd() {
		return this.prcCmdtDefCd;
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
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param prcGrpCmdtDesc
	 */
	public void setPrcGrpCmdtDesc(String prcGrpCmdtDesc) {
		this.prcGrpCmdtDesc = prcGrpCmdtDesc;
	}
	
	/**
	 * Column Info
	 * @param prcCmdtTpCd
	 */
	public void setPrcCmdtTpCd(String prcCmdtTpCd) {
		this.prcCmdtTpCd = prcCmdtTpCd;
	}
	
	/**
	 * Column Info
	 * @param grpCmdtSeq
	 */
	public void setGrpCmdtSeq(String grpCmdtSeq) {
		this.grpCmdtSeq = grpCmdtSeq;
	}
	
	/**
	 * Column Info
	 * @param prcCmdtDefCd
	 */
	public void setPrcCmdtDefCd(String prcCmdtDefCd) {
		this.prcCmdtDefCd = prcCmdtDefCd;
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
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setPrcGrpCmdtDesc(JSPUtil.getParameter(request, "prc_grp_cmdt_desc", ""));
		setPrcCmdtTpCd(JSPUtil.getParameter(request, "prc_cmdt_tp_cd", ""));
		setGrpCmdtSeq(JSPUtil.getParameter(request, "grp_cmdt_seq", ""));
		setPrcCmdtDefCd(JSPUtil.getParameter(request, "prc_cmdt_def_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriSurchargeAdjustCommodityVO[]
	 */
	public RsltPriSurchargeAdjustCommodityVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriSurchargeAdjustCommodityVO[]
	 */
	public RsltPriSurchargeAdjustCommodityVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriSurchargeAdjustCommodityVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] prcGrpCmdtDesc = (JSPUtil.getParameter(request, prefix	+ "prc_grp_cmdt_desc", length));
			String[] prcCmdtTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_tp_cd", length));
			String[] grpCmdtSeq = (JSPUtil.getParameter(request, prefix	+ "grp_cmdt_seq", length));
			String[] prcCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriSurchargeAdjustCommodityVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (prcGrpCmdtDesc[i] != null)
					model.setPrcGrpCmdtDesc(prcGrpCmdtDesc[i]);
				if (prcCmdtTpCd[i] != null)
					model.setPrcCmdtTpCd(prcCmdtTpCd[i]);
				if (grpCmdtSeq[i] != null)
					model.setGrpCmdtSeq(grpCmdtSeq[i]);
				if (prcCmdtDefCd[i] != null)
					model.setPrcCmdtDefCd(prcCmdtDefCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriSurchargeAdjustCommodityVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriSurchargeAdjustCommodityVO[]
	 */
	public RsltPriSurchargeAdjustCommodityVO[] getRsltPriSurchargeAdjustCommodityVOs(){
		RsltPriSurchargeAdjustCommodityVO[] vos = (RsltPriSurchargeAdjustCommodityVO[])models.toArray(new RsltPriSurchargeAdjustCommodityVO[models.size()]);
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
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcGrpCmdtDesc = this.prcGrpCmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtTpCd = this.prcCmdtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpCmdtSeq = this.grpCmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefCd = this.prcCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

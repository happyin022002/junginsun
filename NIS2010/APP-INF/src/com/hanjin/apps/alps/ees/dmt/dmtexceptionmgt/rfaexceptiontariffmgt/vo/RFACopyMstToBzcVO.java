/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : RFAExceptionCopyMstToBzcVO.java
*@FileTitle : RFAExceptionCopyMstToBzcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.07
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;



/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class RFACopyMstToBzcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RFACopyMstToBzcVO> models = new ArrayList<RFACopyMstToBzcVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String rfaExptDarNo = null;

	/* Column Info */
	private String mstPropNo = null;

	/* Column Info */
	private String bzcPropNo = null;

	/* Column Info */
	private String creUsrId = null;

	/* Column Info */
	private String creOfcCd = null;
	
	/* Column Info */
	private String progRmk = null;	

	/* Column Info */
	private String cpyTpCd = null;	
	
	/* Column Info */
	private String aproOfcCd = null;		
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RFACopyMstToBzcVO() {}

	public RFACopyMstToBzcVO(String ibflag, String pagerows, String rfaExptDarNo, String mstPropNo, String bzcPropNo, String creUsrId, String creOfcCd, String progRmk, String cpyTpCd, String aproOfcCd) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.rfaExptDarNo = rfaExptDarNo;
		this.mstPropNo = mstPropNo;
		this.bzcPropNo = bzcPropNo;
		this.creUsrId = creUsrId;
		this.creOfcCd = creOfcCd;
		this.progRmk = progRmk;
		this.cpyTpCd = cpyTpCd;
		this.aproOfcCd = aproOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rfa_expt_dar_no", getRfaExptDarNo());
		this.hashColumns.put("mst_prop_no", getMstPropNo());
		this.hashColumns.put("bzc_prop_no", getBzcPropNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("prog_rmk", getProgRmk());
		this.hashColumns.put("cpy_tp_cd", getCpyTpCd());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rfa_expt_dar_no", "rfaExptDarNo");
		this.hashFields.put("mst_prop_no", "mstPropNo");
		this.hashFields.put("bzc_prop_no", "bzcPropNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("prog_rmk", "progRmk");
		this.hashFields.put("cpy_tp_cd", "cpyTpCd");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String rfaExptDarNo
	 */
	public void setRfaExptDarNo(String rfaExptDarNo) {
		this.rfaExptDarNo = rfaExptDarNo;
	}
	
	/**
	 * 
	 * @return String rfaExptDarNo
	 */
	public String getRfaExptDarNo() {
		return this.rfaExptDarNo;
	}
	
	/**
	 *
	 * @param String mstPropNo
	 */
	public void setMstPropNo(String mstPropNo) {
		this.mstPropNo = mstPropNo;
	}
	
	/**
	 * 
	 * @return String mstPropNo
	 */
	public String getMstPropNo() {
		return this.mstPropNo;
	}
	
	/**
	 *
	 * @param String bzcPropNo
	 */
	public void setBzcPropNo(String bzcPropNo) {
		this.bzcPropNo = bzcPropNo;
	}
	
	/**
	 * 
	 * @return String bzcPropNo
	 */
	public String getBzcPropNo() {
		return this.bzcPropNo;
	}
	
	/**
	 *
	 * @param String creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * 
	 * @return String creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 *
	 * @param String creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * 
	 * @return String creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 *
	 * @param String progRmk
	 */
	public void setProgRmk(String progRmk) {
		this.progRmk = progRmk;
	}
	
	/**
	 * 
	 * @return String progRmk
	 */
	public String getProgRmk() {
		return this.progRmk;
	}
	
	/**
	 *
	 * @param String cpyTpCd
	 */
	public void setCpyTpCd(String cpyTpCd) {
		this.cpyTpCd = cpyTpCd;
	}
	
	/**
	 * 
	 * @return String cpyTpCd
	 */
	public String getCpyTpCd() {
		return this.cpyTpCd;
	}	
	
	/**
	 *
	 * @param String aproOfcCd
	 */
	public void setAproOfcCd(String aproOfcCd) {
		this.aproOfcCd = aproOfcCd;
	}
	
	/**
	 * 
	 * @return String aproOfcCd
	 */
	public String getAproOfcCd() {
		return this.aproOfcCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRfaExptDarNo(JSPUtil.getParameter(request, prefix + "rfa_expt_dar_no", ""));
		setMstPropNo(JSPUtil.getParameter(request, prefix + "mst_prop_no", ""));
		setBzcPropNo(JSPUtil.getParameter(request, prefix + "bzc_prop_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setProgRmk(JSPUtil.getParameter(request, prefix + "prog_rmk", ""));
		setCpyTpCd(JSPUtil.getParameter(request, prefix + "cpy_tp_cd", ""));
		setAproOfcCd(JSPUtil.getParameter(request, prefix + "apro_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RFAExceptionCopyMstToBzcVO[]
	 */
	public RFACopyMstToBzcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RFAExceptionCopyMstToBzcVO[]
	 */
	public RFACopyMstToBzcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RFACopyMstToBzcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rfaExptDarNo = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_dar_no", length));
			String[] mstPropNo = (JSPUtil.getParameter(request, prefix	+ "mst_prop_no", length));
			String[] bzcPropNo = (JSPUtil.getParameter(request, prefix	+ "bzc_prop_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] progRmk = (JSPUtil.getParameter(request, prefix	+ "prog_rmk", length));
			String[] cpyTpCd = (JSPUtil.getParameter(request, prefix	+ "cpy_tp_cd", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new RFACopyMstToBzcVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (rfaExptDarNo[i] != null) 
					model.setRfaExptDarNo(rfaExptDarNo[i]);
				if (mstPropNo[i] != null) 
					model.setMstPropNo(mstPropNo[i]);
				if (bzcPropNo[i] != null) 
					model.setBzcPropNo(bzcPropNo[i]);
				if (creUsrId[i] != null) 
					model.setCreUsrId(creUsrId[i]);
				if (creOfcCd[i] != null) 
					model.setCreOfcCd(creOfcCd[i]);
				if (progRmk[i] != null) 
					model.setProgRmk(progRmk[i]);
				if (cpyTpCd[i] != null) 
					model.setCpyTpCd(cpyTpCd[i]);				
				if (aproOfcCd[i] != null) 
					model.setAproOfcCd(aproOfcCd[i]);					
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRFAExceptionCopyMstToBzcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RFAExceptionCopyMstToBzcVO[]
	 */
	public RFACopyMstToBzcVO[] getRFAExceptionCopyMstToBzcVOs(){
		RFACopyMstToBzcVO[] vos = (RFACopyMstToBzcVO[])models.toArray(new RFACopyMstToBzcVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
	public void unDataFormat(){
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptDarNo = this.rfaExptDarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstPropNo = this.mstPropNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcPropNo = this.bzcPropNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progRmk = this.progRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cpyTpCd = this.cpyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
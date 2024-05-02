/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PriPrsInCalculateVO.java
*@FileTitle : PriPrsInCalculateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.03.29 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PriPrsInCalculateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriPrsInCalculateVO> models = new ArrayList<PriPrsInCalculateVO>();
	
	/* Column Info */
	private String prsRoutCsBatRsltCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String routCsSrcDt = null;
	/* Column Info */
	private String triPropNo = null;
	/* Column Info */
	private String routCsClssNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String routCsNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PriPrsInCalculateVO() {}

	public PriPrsInCalculateVO(String ibflag, String pagerows, String routCsNo, String routCsClssNo, String routCsSrcDt, String triPropNo, String amdtSeq, String prsRoutCsBatRsltCd, String updUsrId) {
		this.prsRoutCsBatRsltCd = prsRoutCsBatRsltCd;
		this.ibflag = ibflag;
		this.amdtSeq = amdtSeq;
		this.routCsSrcDt = routCsSrcDt;
		this.triPropNo = triPropNo;
		this.routCsClssNo = routCsClssNo;
		this.updUsrId = updUsrId;
		this.routCsNo = routCsNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("prs_rout_cs_bat_rslt_cd", getPrsRoutCsBatRsltCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("rout_cs_src_dt", getRoutCsSrcDt());
		this.hashColumns.put("tri_prop_no", getTriPropNo());
		this.hashColumns.put("rout_cs_clss_no", getRoutCsClssNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rout_cs_no", getRoutCsNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("prs_rout_cs_bat_rslt_cd", "prsRoutCsBatRsltCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("rout_cs_src_dt", "routCsSrcDt");
		this.hashFields.put("tri_prop_no", "triPropNo");
		this.hashFields.put("rout_cs_clss_no", "routCsClssNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rout_cs_no", "routCsNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return prsRoutCsBatRsltCd
	 */
	public String getPrsRoutCsBatRsltCd() {
		return this.prsRoutCsBatRsltCd;
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
	 * @return routCsSrcDt
	 */
	public String getRoutCsSrcDt() {
		return this.routCsSrcDt;
	}
	
	/**
	 * Column Info
	 * @return triPropNo
	 */
	public String getTriPropNo() {
		return this.triPropNo;
	}
	
	/**
	 * Column Info
	 * @return routCsClssNo
	 */
	public String getRoutCsClssNo() {
		return this.routCsClssNo;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return routCsNo
	 */
	public String getRoutCsNo() {
		return this.routCsNo;
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
	 * @param prsRoutCsBatRsltCd
	 */
	public void setPrsRoutCsBatRsltCd(String prsRoutCsBatRsltCd) {
		this.prsRoutCsBatRsltCd = prsRoutCsBatRsltCd;
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
	 * @param routCsSrcDt
	 */
	public void setRoutCsSrcDt(String routCsSrcDt) {
		this.routCsSrcDt = routCsSrcDt;
	}
	
	/**
	 * Column Info
	 * @param triPropNo
	 */
	public void setTriPropNo(String triPropNo) {
		this.triPropNo = triPropNo;
	}
	
	/**
	 * Column Info
	 * @param routCsClssNo
	 */
	public void setRoutCsClssNo(String routCsClssNo) {
		this.routCsClssNo = routCsClssNo;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param routCsNo
	 */
	public void setRoutCsNo(String routCsNo) {
		this.routCsNo = routCsNo;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setPrsRoutCsBatRsltCd(JSPUtil.getParameter(request, prefix + "prs_rout_cs_bat_rslt_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setRoutCsSrcDt(JSPUtil.getParameter(request, prefix + "rout_cs_src_dt", ""));
		setTriPropNo(JSPUtil.getParameter(request, prefix + "tri_prop_no", ""));
		setRoutCsClssNo(JSPUtil.getParameter(request, prefix + "rout_cs_clss_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setRoutCsNo(JSPUtil.getParameter(request, prefix + "rout_cs_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriPrsInCalculateVO[]
	 */
	public PriPrsInCalculateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriPrsInCalculateVO[]
	 */
	public PriPrsInCalculateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriPrsInCalculateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] prsRoutCsBatRsltCd = (JSPUtil.getParameter(request, prefix	+ "prs_rout_cs_bat_rslt_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] routCsSrcDt = (JSPUtil.getParameter(request, prefix	+ "rout_cs_src_dt", length));
			String[] triPropNo = (JSPUtil.getParameter(request, prefix	+ "tri_prop_no", length));
			String[] routCsClssNo = (JSPUtil.getParameter(request, prefix	+ "rout_cs_clss_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] routCsNo = (JSPUtil.getParameter(request, prefix	+ "rout_cs_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriPrsInCalculateVO();
				if (prsRoutCsBatRsltCd[i] != null)
					model.setPrsRoutCsBatRsltCd(prsRoutCsBatRsltCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (routCsSrcDt[i] != null)
					model.setRoutCsSrcDt(routCsSrcDt[i]);
				if (triPropNo[i] != null)
					model.setTriPropNo(triPropNo[i]);
				if (routCsClssNo[i] != null)
					model.setRoutCsClssNo(routCsClssNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (routCsNo[i] != null)
					model.setRoutCsNo(routCsNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriPrsInCalculateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriPrsInCalculateVO[]
	 */
	public PriPrsInCalculateVO[] getPriPrsInCalculateVOs(){
		PriPrsInCalculateVO[] vos = (PriPrsInCalculateVO[])models.toArray(new PriPrsInCalculateVO[models.size()]);
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
		this.prsRoutCsBatRsltCd = this.prsRoutCsBatRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routCsSrcDt = this.routCsSrcDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triPropNo = this.triPropNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routCsClssNo = this.routCsClssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routCsNo = this.routCsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

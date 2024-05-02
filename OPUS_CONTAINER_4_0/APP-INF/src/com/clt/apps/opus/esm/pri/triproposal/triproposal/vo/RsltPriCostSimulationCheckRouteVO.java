/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltPriCostSimulationCheckRouteVO.java
*@FileTitle : RsltPriCostSimulationCheckRouteVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.23
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.03.23 송민석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.triproposal.triproposal.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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

public class RsltPriCostSimulationCheckRouteVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriCostSimulationCheckRouteVO> models = new ArrayList<RsltPriCostSimulationCheckRouteVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String triPropNo = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String routPntSeq = null;
	/* Column Info */
	private String routPntLocCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriCostSimulationCheckRouteVO() {}

	public RsltPriCostSimulationCheckRouteVO(String ibflag, String pagerows, String routPntLocCd, String triPropNo, String orgDestTpCd, String routPntSeq, String rcvDeTermCd) {
		this.ibflag = ibflag;
		this.orgDestTpCd = orgDestTpCd;
		this.triPropNo = triPropNo;
		this.rcvDeTermCd = rcvDeTermCd;
		this.routPntSeq = routPntSeq;
		this.routPntLocCd = routPntLocCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("tri_prop_no", getTriPropNo());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("rout_pnt_seq", getRoutPntSeq());
		this.hashColumns.put("rout_pnt_loc_cd", getRoutPntLocCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("tri_prop_no", "triPropNo");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("rout_pnt_seq", "routPntSeq");
		this.hashFields.put("rout_pnt_loc_cd", "routPntLocCd");
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
	 * @return orgDestTpCd
	 */
	public String getOrgDestTpCd() {
		return this.orgDestTpCd;
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
	 * @return rcvDeTermCd
	 */
	public String getRcvDeTermCd() {
		return this.rcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return routPntSeq
	 */
	public String getRoutPntSeq() {
		return this.routPntSeq;
	}
	
	/**
	 * Column Info
	 * @return routPntLocCd
	 */
	public String getRoutPntLocCd() {
		return this.routPntLocCd;
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
	 * @param orgDestTpCd
	 */
	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
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
	 * @param rcvDeTermCd
	 */
	public void setRcvDeTermCd(String rcvDeTermCd) {
		this.rcvDeTermCd = rcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param routPntSeq
	 */
	public void setRoutPntSeq(String routPntSeq) {
		this.routPntSeq = routPntSeq;
	}
	
	/**
	 * Column Info
	 * @param routPntLocCd
	 */
	public void setRoutPntLocCd(String routPntLocCd) {
		this.routPntLocCd = routPntLocCd;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, prefix + "org_dest_tp_cd", ""));
		setTriPropNo(JSPUtil.getParameter(request, prefix + "tri_prop_no", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", ""));
		setRoutPntSeq(JSPUtil.getParameter(request, prefix + "rout_pnt_seq", ""));
		setRoutPntLocCd(JSPUtil.getParameter(request, prefix + "rout_pnt_loc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriCostSimulationCheckRouteVO[]
	 */
	public RsltPriCostSimulationCheckRouteVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriCostSimulationCheckRouteVO[]
	 */
	public RsltPriCostSimulationCheckRouteVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriCostSimulationCheckRouteVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] triPropNo = (JSPUtil.getParameter(request, prefix	+ "tri_prop_no", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] routPntSeq = (JSPUtil.getParameter(request, prefix	+ "rout_pnt_seq", length));
			String[] routPntLocCd = (JSPUtil.getParameter(request, prefix	+ "rout_pnt_loc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriCostSimulationCheckRouteVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (triPropNo[i] != null)
					model.setTriPropNo(triPropNo[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (routPntSeq[i] != null)
					model.setRoutPntSeq(routPntSeq[i]);
				if (routPntLocCd[i] != null)
					model.setRoutPntLocCd(routPntLocCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriCostSimulationCheckRouteVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriCostSimulationCheckRouteVO[]
	 */
	public RsltPriCostSimulationCheckRouteVO[] getRsltPriCostSimulationCheckRouteVOs(){
		RsltPriCostSimulationCheckRouteVO[] vos = (RsltPriCostSimulationCheckRouteVO[])models.toArray(new RsltPriCostSimulationCheckRouteVO[models.size()]);
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
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triPropNo = this.triPropNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntSeq = this.routPntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocCd = this.routPntLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

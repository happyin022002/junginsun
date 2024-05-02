/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IdaCstmsVO.java
*@FileTitle : IdaCstmsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2009.10.14 박만건 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author 박만건
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IdaCstmsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IdaCstmsVO> models = new ArrayList<IdaCstmsVO>();
	
	/* Column Info */
	private String idaCgorOrdYr = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String idaImpGenMfNo = null;
	/* Column Info */
	private String troiFlg = null;
	/* Column Info */
	private String idaCstmsAsgnLineNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IdaCstmsVO() {}

	public IdaCstmsVO(String ibflag, String pagerows, String idaImpGenMfNo, String idaCgorOrdYr, String idaCstmsAsgnLineNo, String troiFlg) {
		this.idaCgorOrdYr = idaCgorOrdYr;
		this.ibflag = ibflag;
		this.idaImpGenMfNo = idaImpGenMfNo;
		this.troiFlg = troiFlg;
		this.idaCstmsAsgnLineNo = idaCstmsAsgnLineNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ida_cgor_ord_yr", getIdaCgorOrdYr());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ida_imp_gen_mf_no", getIdaImpGenMfNo());
		this.hashColumns.put("troi_flg", getTroiFlg());
		this.hashColumns.put("ida_cstms_asgn_line_no", getIdaCstmsAsgnLineNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ida_cgor_ord_yr", "idaCgorOrdYr");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ida_imp_gen_mf_no", "idaImpGenMfNo");
		this.hashFields.put("troi_flg", "troiFlg");
		this.hashFields.put("ida_cstms_asgn_line_no", "idaCstmsAsgnLineNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return idaCgorOrdYr
	 */
	public String getIdaCgorOrdYr() {
		return this.idaCgorOrdYr;
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
	 * @return idaImpGenMfNo
	 */
	public String getIdaImpGenMfNo() {
		return this.idaImpGenMfNo;
	}
	
	/**
	 * Column Info
	 * @return troiFlg
	 */
	public String getTroiFlg() {
		return this.troiFlg;
	}
	
	/**
	 * Column Info
	 * @return idaCstmsAsgnLineNo
	 */
	public String getIdaCstmsAsgnLineNo() {
		return this.idaCstmsAsgnLineNo;
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
	 * @param idaCgorOrdYr
	 */
	public void setIdaCgorOrdYr(String idaCgorOrdYr) {
		this.idaCgorOrdYr = idaCgorOrdYr;
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
	 * @param idaImpGenMfNo
	 */
	public void setIdaImpGenMfNo(String idaImpGenMfNo) {
		this.idaImpGenMfNo = idaImpGenMfNo;
	}
	
	/**
	 * Column Info
	 * @param troiFlg
	 */
	public void setTroiFlg(String troiFlg) {
		this.troiFlg = troiFlg;
	}
	
	/**
	 * Column Info
	 * @param idaCstmsAsgnLineNo
	 */
	public void setIdaCstmsAsgnLineNo(String idaCstmsAsgnLineNo) {
		this.idaCstmsAsgnLineNo = idaCstmsAsgnLineNo;
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
		setIdaCgorOrdYr(JSPUtil.getParameter(request, "ida_cgor_ord_yr", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setIdaImpGenMfNo(JSPUtil.getParameter(request, "ida_imp_gen_mf_no", ""));
		setTroiFlg(JSPUtil.getParameter(request, "troi_flg", ""));
		setIdaCstmsAsgnLineNo(JSPUtil.getParameter(request, "ida_cstms_asgn_line_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IdaCstmsVO[]
	 */
	public IdaCstmsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IdaCstmsVO[]
	 */
	public IdaCstmsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IdaCstmsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] idaCgorOrdYr = (JSPUtil.getParameter(request, prefix	+ "ida_cgor_ord_yr", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] idaImpGenMfNo = (JSPUtil.getParameter(request, prefix	+ "ida_imp_gen_mf_no", length));
			String[] troiFlg = (JSPUtil.getParameter(request, prefix	+ "troi_flg", length));
			String[] idaCstmsAsgnLineNo = (JSPUtil.getParameter(request, prefix	+ "ida_cstms_asgn_line_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new IdaCstmsVO();
				if (idaCgorOrdYr[i] != null)
					model.setIdaCgorOrdYr(idaCgorOrdYr[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (idaImpGenMfNo[i] != null)
					model.setIdaImpGenMfNo(idaImpGenMfNo[i]);
				if (troiFlg[i] != null)
					model.setTroiFlg(troiFlg[i]);
				if (idaCstmsAsgnLineNo[i] != null)
					model.setIdaCstmsAsgnLineNo(idaCstmsAsgnLineNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIdaCstmsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IdaCstmsVO[]
	 */
	public IdaCstmsVO[] getIdaCstmsVOs(){
		IdaCstmsVO[] vos = (IdaCstmsVO[])models.toArray(new IdaCstmsVO[models.size()]);
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
		this.idaCgorOrdYr = this.idaCgorOrdYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaImpGenMfNo = this.idaImpGenMfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troiFlg = this.troiFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaCstmsAsgnLineNo = this.idaCstmsAsgnLineNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

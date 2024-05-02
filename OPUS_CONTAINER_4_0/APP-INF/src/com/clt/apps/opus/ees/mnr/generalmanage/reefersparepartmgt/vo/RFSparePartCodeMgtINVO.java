/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFSparePartCodeMgtINVO.java
*@FileTitle : RFSparePartCodeMgtINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.18
*@LastModifier : 이용태
*@LastVersion : 1.0
* 2010.06.18 이용태 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이용태
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RFSparePartCodeMgtINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RFSparePartCodeMgtINVO> models = new ArrayList<RFSparePartCodeMgtINVO>();
	
	/* Column Info */
	private String sprUtTpNm = null;
	/* Column Info */
	private String sprTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sprPrtNo = null;
	/* Column Info */
	private String sprWorkType = null;
	/* Column Info */
	private String sprPrtSplTpCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RFSparePartCodeMgtINVO() {}

	public RFSparePartCodeMgtINVO(String ibflag, String pagerows, String sprUtTpNm, String sprTpCd, String sprPrtNo, String sprPrtSplTpCd, String sprWorkType) {
		this.sprUtTpNm = sprUtTpNm;
		this.sprTpCd = sprTpCd;
		this.ibflag = ibflag;
		this.sprPrtNo = sprPrtNo;
		this.sprWorkType = sprWorkType;
		this.sprPrtSplTpCd = sprPrtSplTpCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("spr_ut_tp_nm", getSprUtTpNm());
		this.hashColumns.put("spr_tp_cd", getSprTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("spr_prt_no", getSprPrtNo());
		this.hashColumns.put("spr_work_type", getSprWorkType());
		this.hashColumns.put("spr_prt_spl_tp_cd", getSprPrtSplTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("spr_ut_tp_nm", "sprUtTpNm");
		this.hashFields.put("spr_tp_cd", "sprTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("spr_prt_no", "sprPrtNo");
		this.hashFields.put("spr_work_type", "sprWorkType");
		this.hashFields.put("spr_prt_spl_tp_cd", "sprPrtSplTpCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sprUtTpNm
	 */
	public String getSprUtTpNm() {
		return this.sprUtTpNm;
	}
	
	/**
	 * Column Info
	 * @return sprTpCd
	 */
	public String getSprTpCd() {
		return this.sprTpCd;
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
	 * @return sprPrtNo
	 */
	public String getSprPrtNo() {
		return this.sprPrtNo;
	}
	
	/**
	 * Column Info
	 * @return sprWorkType
	 */
	public String getSprWorkType() {
		return this.sprWorkType;
	}
	
	/**
	 * Column Info
	 * @return sprPrtSplTpCd
	 */
	public String getSprPrtSplTpCd() {
		return this.sprPrtSplTpCd;
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
	 * @param sprUtTpNm
	 */
	public void setSprUtTpNm(String sprUtTpNm) {
		this.sprUtTpNm = sprUtTpNm;
	}
	
	/**
	 * Column Info
	 * @param sprTpCd
	 */
	public void setSprTpCd(String sprTpCd) {
		this.sprTpCd = sprTpCd;
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
	 * @param sprPrtNo
	 */
	public void setSprPrtNo(String sprPrtNo) {
		this.sprPrtNo = sprPrtNo;
	}
	
	/**
	 * Column Info
	 * @param sprWorkType
	 */
	public void setSprWorkType(String sprWorkType) {
		this.sprWorkType = sprWorkType;
	}
	
	/**
	 * Column Info
	 * @param sprPrtSplTpCd
	 */
	public void setSprPrtSplTpCd(String sprPrtSplTpCd) {
		this.sprPrtSplTpCd = sprPrtSplTpCd;
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
		setSprUtTpNm(JSPUtil.getParameter(request, prefix + "spr_ut_tp_nm", ""));
		setSprTpCd(JSPUtil.getParameter(request, prefix + "spr_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSprPrtNo(JSPUtil.getParameter(request, prefix + "spr_prt_no", ""));
		setSprWorkType(JSPUtil.getParameter(request, prefix + "spr_work_type", ""));
		setSprPrtSplTpCd(JSPUtil.getParameter(request, prefix + "spr_prt_spl_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RFSparePartCodeMgtINVO[]
	 */
	public RFSparePartCodeMgtINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RFSparePartCodeMgtINVO[]
	 */
	public RFSparePartCodeMgtINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RFSparePartCodeMgtINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sprUtTpNm = (JSPUtil.getParameter(request, prefix	+ "spr_ut_tp_nm", length));
			String[] sprTpCd = (JSPUtil.getParameter(request, prefix	+ "spr_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sprPrtNo = (JSPUtil.getParameter(request, prefix	+ "spr_prt_no", length));
			String[] sprWorkType = (JSPUtil.getParameter(request, prefix	+ "spr_work_type", length));
			String[] sprPrtSplTpCd = (JSPUtil.getParameter(request, prefix	+ "spr_prt_spl_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RFSparePartCodeMgtINVO();
				if (sprUtTpNm[i] != null)
					model.setSprUtTpNm(sprUtTpNm[i]);
				if (sprTpCd[i] != null)
					model.setSprTpCd(sprTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sprPrtNo[i] != null)
					model.setSprPrtNo(sprPrtNo[i]);
				if (sprWorkType[i] != null)
					model.setSprWorkType(sprWorkType[i]);
				if (sprPrtSplTpCd[i] != null)
					model.setSprPrtSplTpCd(sprPrtSplTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRFSparePartCodeMgtINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RFSparePartCodeMgtINVO[]
	 */
	public RFSparePartCodeMgtINVO[] getRFSparePartCodeMgtINVOs(){
		RFSparePartCodeMgtINVO[] vos = (RFSparePartCodeMgtINVO[])models.toArray(new RFSparePartCodeMgtINVO[models.size()]);
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
		this.sprUtTpNm = this.sprUtTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprTpCd = this.sprTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtNo = this.sprPrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprWorkType = this.sprWorkType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtSplTpCd = this.sprPrtSplTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AgnReqCalCondVO.java
*@FileTitle : AgnReqCalCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.02
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.08.02 김봉균 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.vo;

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
 * @author 김봉균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AgnReqCalCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AgnReqCalCondVO> models = new ArrayList<AgnReqCalCondVO>();
	
	/* Column Info */
	private String calcNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String obSaDt = null;
	/* Column Info */
	private String bkgCreDt = null;
	/* Column Info */
	private String revMon = null;
	/* Column Info */
	private String ibSaDt = null;
	/* Column Info */
	private String simNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AgnReqCalCondVO() {}

	public AgnReqCalCondVO(String ibflag, String pagerows, String bkgNo, String obSaDt, String ibSaDt, String bkgCreDt, String revMon, String calcNo, String usrId, String simNo) {
		this.calcNo = calcNo;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.obSaDt = obSaDt;
		this.bkgCreDt = bkgCreDt;
		this.revMon = revMon;
		this.ibSaDt = ibSaDt;
		this.simNo = simNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("calc_no", getCalcNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("ob_sa_dt", getObSaDt());
		this.hashColumns.put("bkg_cre_dt", getBkgCreDt());
		this.hashColumns.put("rev_mon", getRevMon());
		this.hashColumns.put("ib_sa_dt", getIbSaDt());
		this.hashColumns.put("sim_no", getSimNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("calc_no", "calcNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("ob_sa_dt", "obSaDt");
		this.hashFields.put("bkg_cre_dt", "bkgCreDt");
		this.hashFields.put("rev_mon", "revMon");
		this.hashFields.put("ib_sa_dt", "ibSaDt");
		this.hashFields.put("sim_no", "simNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return calcNo
	 */
	public String getCalcNo() {
		return this.calcNo;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return obSaDt
	 */
	public String getObSaDt() {
		return this.obSaDt;
	}
	
	/**
	 * Column Info
	 * @return bkgCreDt
	 */
	public String getBkgCreDt() {
		return this.bkgCreDt;
	}
	
	/**
	 * Column Info
	 * @return revMon
	 */
	public String getRevMon() {
		return this.revMon;
	}
	
	/**
	 * Column Info
	 * @return ibSaDt
	 */
	public String getIbSaDt() {
		return this.ibSaDt;
	}
	
	/**
	 * Column Info
	 * @return simNo
	 */
	public String getSimNo() {
		return this.simNo;
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
	 * @param calcNo
	 */
	public void setCalcNo(String calcNo) {
		this.calcNo = calcNo;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param obSaDt
	 */
	public void setObSaDt(String obSaDt) {
		this.obSaDt = obSaDt;
	}
	
	/**
	 * Column Info
	 * @param bkgCreDt
	 */
	public void setBkgCreDt(String bkgCreDt) {
		this.bkgCreDt = bkgCreDt;
	}
	
	/**
	 * Column Info
	 * @param revMon
	 */
	public void setRevMon(String revMon) {
		this.revMon = revMon;
	}
	
	/**
	 * Column Info
	 * @param ibSaDt
	 */
	public void setIbSaDt(String ibSaDt) {
		this.ibSaDt = ibSaDt;
	}
	
	/**
	 * Column Info
	 * @param simNo
	 */
	public void setSimNo(String simNo) {
		this.simNo = simNo;
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
		setCalcNo(JSPUtil.getParameter(request, prefix + "calc_no", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setObSaDt(JSPUtil.getParameter(request, prefix + "ob_sa_dt", ""));
		setBkgCreDt(JSPUtil.getParameter(request, prefix + "bkg_cre_dt", ""));
		setRevMon(JSPUtil.getParameter(request, prefix + "rev_mon", ""));
		setIbSaDt(JSPUtil.getParameter(request, prefix + "ib_sa_dt", ""));
		setSimNo(JSPUtil.getParameter(request, prefix + "sim_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AgnReqCalCondVO[]
	 */
	public AgnReqCalCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AgnReqCalCondVO[]
	 */
	public AgnReqCalCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AgnReqCalCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] calcNo = (JSPUtil.getParameter(request, prefix	+ "calc_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] obSaDt = (JSPUtil.getParameter(request, prefix	+ "ob_sa_dt", length));
			String[] bkgCreDt = (JSPUtil.getParameter(request, prefix	+ "bkg_cre_dt", length));
			String[] revMon = (JSPUtil.getParameter(request, prefix	+ "rev_mon", length));
			String[] ibSaDt = (JSPUtil.getParameter(request, prefix	+ "ib_sa_dt", length));
			String[] simNo = (JSPUtil.getParameter(request, prefix	+ "sim_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new AgnReqCalCondVO();
				if (calcNo[i] != null)
					model.setCalcNo(calcNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (obSaDt[i] != null)
					model.setObSaDt(obSaDt[i]);
				if (bkgCreDt[i] != null)
					model.setBkgCreDt(bkgCreDt[i]);
				if (revMon[i] != null)
					model.setRevMon(revMon[i]);
				if (ibSaDt[i] != null)
					model.setIbSaDt(ibSaDt[i]);
				if (simNo[i] != null)
					model.setSimNo(simNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAgnReqCalCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AgnReqCalCondVO[]
	 */
	public AgnReqCalCondVO[] getAgnReqCalCondVOs(){
		AgnReqCalCondVO[] vos = (AgnReqCalCondVO[])models.toArray(new AgnReqCalCondVO[models.size()]);
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
		this.calcNo = this.calcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSaDt = this.obSaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCreDt = this.bkgCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revMon = this.revMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibSaDt = this.ibSaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simNo = this.simNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

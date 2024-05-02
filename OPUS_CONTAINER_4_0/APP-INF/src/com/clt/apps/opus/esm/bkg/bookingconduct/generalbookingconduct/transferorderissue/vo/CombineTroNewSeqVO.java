/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CombineTroNewSeqVO.java
*@FileTitle : CombineTroNewSeqVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.30
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.03.30 류대영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo;

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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CombineTroNewSeqVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CombineTroNewSeqVO> models = new ArrayList<CombineTroNewSeqVO>();
	
	/* Column Info */
	private String newBkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String orgBkgNo = null;
	/* Column Info */
	private String orgTroSeq = null;
	/* Column Info */
	private String newTroSeq = null;
	/* Column Info */
	private String troTp = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CombineTroNewSeqVO() {}

	public CombineTroNewSeqVO(String ibflag, String pagerows, String newBkgNo, String newTroSeq, String orgBkgNo, String orgTroSeq, String TroTp) {
		this.newBkgNo = newBkgNo;
		this.ibflag = ibflag;
		this.orgBkgNo = orgBkgNo;
		this.orgTroSeq = orgTroSeq;
		this.newTroSeq = newTroSeq;
		this.pagerows = pagerows;
		this.troTp = troTp;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("new_bkg_no", getNewBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("org_bkg_no", getOrgBkgNo());
		this.hashColumns.put("org_tro_seq", getOrgTroSeq());
		this.hashColumns.put("new_tro_seq", getNewTroSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tro_tp", getTroTp());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("new_bkg_no", "newBkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("org_bkg_no", "orgBkgNo");
		this.hashFields.put("org_tro_seq", "orgTroSeq");
		this.hashFields.put("new_tro_seq", "newTroSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tro_tp", "troTp");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return newBkgNo
	 */
	public String getNewBkgNo() {
		return this.newBkgNo;
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
	 * @return orgBkgNo
	 */
	public String getOrgBkgNo() {
		return this.orgBkgNo;
	}
	
	/**
	 * Column Info
	 * @return orgTroSeq
	 */
	public String getOrgTroSeq() {
		return this.orgTroSeq;
	}
	
	/**
	 * Column Info
	 * @return newTroSeq
	 */
	public String getNewTroSeq() {
		return this.newTroSeq;
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
	 * @return troTp
	 */
	public String getTroTp() {
		return this.troTp;
	}

	/**
	 * Column Info
	 * @param newBkgNo
	 */
	public void setNewBkgNo(String newBkgNo) {
		this.newBkgNo = newBkgNo;
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
	 * @param orgBkgNo
	 */
	public void setOrgBkgNo(String orgBkgNo) {
		this.orgBkgNo = orgBkgNo;
	}
	
	/**
	 * Column Info
	 * @param orgTroSeq
	 */
	public void setOrgTroSeq(String orgTroSeq) {
		this.orgTroSeq = orgTroSeq;
	}
	
	/**
	 * Column Info
	 * @param newTroSeq
	 */
	public void setNewTroSeq(String newTroSeq) {
		this.newTroSeq = newTroSeq;
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
	 * @param troTp
	 */
	public void setTroTp(String troTp) {
		this.troTp = troTp;
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
		setNewBkgNo(JSPUtil.getParameter(request, prefix + "new_bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOrgBkgNo(JSPUtil.getParameter(request, prefix + "org_bkg_no", ""));
		setOrgTroSeq(JSPUtil.getParameter(request, prefix + "org_tro_seq", ""));
		setNewTroSeq(JSPUtil.getParameter(request, prefix + "new_tro_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTroTp(JSPUtil.getParameter(request, prefix + "tro_tp", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CombineTroNewSeqVO[]
	 */
	public CombineTroNewSeqVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CombineTroNewSeqVO[]
	 */
	public CombineTroNewSeqVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CombineTroNewSeqVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] newBkgNo = (JSPUtil.getParameter(request, prefix	+ "new_bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] orgBkgNo = (JSPUtil.getParameter(request, prefix	+ "org_bkg_no", length));
			String[] orgTroSeq = (JSPUtil.getParameter(request, prefix	+ "org_tro_seq", length));
			String[] newTroSeq = (JSPUtil.getParameter(request, prefix	+ "new_tro_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] troTp = (JSPUtil.getParameter(request, prefix	+ "tro_tp", length));
			
			for (int i = 0; i < length; i++) {
				model = new CombineTroNewSeqVO();
				if (newBkgNo[i] != null)
					model.setNewBkgNo(newBkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (orgBkgNo[i] != null)
					model.setOrgBkgNo(orgBkgNo[i]);
				if (orgTroSeq[i] != null)
					model.setOrgTroSeq(orgTroSeq[i]);
				if (newTroSeq[i] != null)
					model.setNewTroSeq(newTroSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (troTp[i] != null)
					model.setTroTp(troTp[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCombineTroNewSeqVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CombineTroNewSeqVO[]
	 */
	public CombineTroNewSeqVO[] getCombineTroNewSeqVOs(){
		CombineTroNewSeqVO[] vos = (CombineTroNewSeqVO[])models.toArray(new CombineTroNewSeqVO[models.size()]);
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
		this.newBkgNo = this.newBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgBkgNo = this.orgBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgTroSeq = this.orgTroSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newTroSeq = this.newTroSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troTp = this.troTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

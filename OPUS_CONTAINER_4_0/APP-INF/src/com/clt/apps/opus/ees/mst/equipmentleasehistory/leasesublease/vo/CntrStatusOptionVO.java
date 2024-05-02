/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CntrStatusOptionVO.java
*@FileTitle : CntrStatusOptionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.30
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.04.30 이호선 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo;

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
 * @author 이호선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CntrStatusOptionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CntrStatusOptionVO> models = new ArrayList<CntrStatusOptionVO>();
	
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String evntDt2 = null;
	/* Column Info */
	private String chklen = null;
	/* Column Info */
	private String evntDt1 = null;
	/* Column Info */
	private String lsFlg = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String locTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private  String	 pCntrno   =  null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CntrStatusOptionVO() {}

	public CntrStatusOptionVO(String ibflag, String pagerows, String locCd, String evntDt2, String evntDt1, String chklen, String cntrNo, String locTpCd, String lsFlg,String pCntrno) {
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.evntDt2 = evntDt2;
		this.chklen = chklen;
		this.evntDt1 = evntDt1;
		this.lsFlg = lsFlg;
		this.cntrNo = cntrNo;
		this.locTpCd = locTpCd;
		this.pagerows = pagerows;
		this.pCntrno  = pCntrno ;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("evnt_dt2", getEvntDt2());
		this.hashColumns.put("chklen", getChklen());
		this.hashColumns.put("evnt_dt1", getEvntDt1());
		this.hashColumns.put("ls_flg", getLsFlg());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("loc_tp_cd", getLocTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("p_cntrno", getPCntrno());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("evnt_dt2", "evntDt2");
		this.hashFields.put("chklen", "chklen");
		this.hashFields.put("evnt_dt1", "evntDt1");
		this.hashFields.put("ls_flg", "lsFlg");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("loc_tp_cd", "locTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("p_cntrno", "pCntrno");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return evntDt2
	 */
	public String getEvntDt2() {
		return this.evntDt2;
	}
	
	/**
	 * Column Info
	 * @return chklen
	 */
	public String getChklen() {
		return this.chklen;
	}
	
	/**
	 * Column Info
	 * @return evntDt1
	 */
	public String getEvntDt1() {
		return this.evntDt1;
	}
	
	/**
	 * Column Info
	 * @return lsFlg
	 */
	public String getLsFlg() {
		return this.lsFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return locTpCd
	 */
	public String getLocTpCd() {
		return this.locTpCd;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param evntDt2
	 */
	public void setEvntDt2(String evntDt2) {
		this.evntDt2 = evntDt2;
	}
	
	/**
	 * Column Info
	 * @param chklen
	 */
	public void setChklen(String chklen) {
		this.chklen = chklen;
	}
	
	/**
	 * Column Info
	 * @param evntDt1
	 */
	public void setEvntDt1(String evntDt1) {
		this.evntDt1 = evntDt1;
	}
	
	/**
	 * Column Info
	 * @param lsFlg
	 */
	public void setLsFlg(String lsFlg) {
		this.lsFlg = lsFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param locTpCd
	 */
	public void setLocTpCd(String locTpCd) {
		this.locTpCd = locTpCd;
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
	* @param  pCntrno
	*/
	public void	setPCntrno( String	pCntrno ) {
		this.pCntrno =	pCntrno;
	}
 
	/**
	 * Column Info
	 * @return	pCntrno
	 */
	 public	 String	getPCntrno() {
		 return	this.pCntrno;
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
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEvntDt2(JSPUtil.getParameter(request, prefix + "evnt_dt2", ""));
		setChklen(JSPUtil.getParameter(request, prefix + "chklen", ""));
		setEvntDt1(JSPUtil.getParameter(request, prefix + "evnt_dt1", ""));
		setLsFlg(JSPUtil.getParameter(request, prefix + "ls_flg", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setLocTpCd(JSPUtil.getParameter(request, prefix + "loc_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPCntrno(JSPUtil.getParameter(request,	prefix + "p_cntrno", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrStatusOptionVO[]
	 */
	public CntrStatusOptionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrStatusOptionVO[]
	 */
	public CntrStatusOptionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CntrStatusOptionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] evntDt2 = (JSPUtil.getParameter(request, prefix	+ "evnt_dt2", length));
			String[] chklen = (JSPUtil.getParameter(request, prefix	+ "chklen", length));
			String[] evntDt1 = (JSPUtil.getParameter(request, prefix	+ "evnt_dt1", length));
			String[] lsFlg = (JSPUtil.getParameter(request, prefix	+ "ls_flg", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] locTpCd = (JSPUtil.getParameter(request, prefix	+ "loc_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pCntrno =	(JSPUtil.getParameter(request, prefix +	"p_cntrno".trim(),	length));
			
			for (int i = 0; i < length; i++) {
				model = new CntrStatusOptionVO();
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (evntDt2[i] != null)
					model.setEvntDt2(evntDt2[i]);
				if (chklen[i] != null)
					model.setChklen(chklen[i]);
				if (evntDt1[i] != null)
					model.setEvntDt1(evntDt1[i]);
				if (lsFlg[i] != null)
					model.setLsFlg(lsFlg[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (locTpCd[i] != null)
					model.setLocTpCd(locTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if ( pCntrno[i] !=	null)
					model.setPCntrno( pCntrno[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCntrStatusOptionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CntrStatusOptionVO[]
	 */
	public CntrStatusOptionVO[] getCntrStatusOptionVOs(){
		CntrStatusOptionVO[] vos = (CntrStatusOptionVO[])models.toArray(new CntrStatusOptionVO[models.size()]);
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
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt2 = this.evntDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chklen = this.chklen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt1 = this.evntDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsFlg = this.lsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTpCd = this.locTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCntrno =	this.pCntrno.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

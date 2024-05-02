/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RHContainerVO.java
*@FileTitle : RHContainerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.01  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo;

import java.lang.reflect.Field;
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

public class RHContainerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RHContainerVO> models = new ArrayList<RHContainerVO>();
	
	/* Column Info */
	private String position = null;
	/* Column Info */
	private String precell = null;
	/* Column Info */
	private String shiftRsn = null;
	/* Column Info */
	private String party = null;
	/* Column Info */
	private String fe = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fileAtch = null;
	/* Column Info */
	private String respbCntrNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oprCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String account = null;
	/* Column Info */
	private String sztp = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RHContainerVO() {}

	public RHContainerVO(String ibflag, String pagerows, String cntrNo, String sztp, String pol, String oprCd, String precell, String position, String shiftRsn, String account, String party, String respbCntrNo, String fileAtch, String fe) {
		this.position = position;
		this.precell = precell;
		this.shiftRsn = shiftRsn;
		this.party = party;
		this.fe = fe;
		this.pagerows = pagerows;
		this.fileAtch = fileAtch;
		this.respbCntrNo = respbCntrNo;
		this.ibflag = ibflag;
		this.oprCd = oprCd;
		this.cntrNo = cntrNo;
		this.pol = pol;
		this.account = account;
		this.sztp = sztp;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("position", getPosition());
		this.hashColumns.put("precell", getPrecell());
		this.hashColumns.put("shift_rsn", getShiftRsn());
		this.hashColumns.put("party", getParty());
		this.hashColumns.put("fe", getFe());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("file_atch", getFileAtch());
		this.hashColumns.put("respb_cntr_no", getRespbCntrNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("account", getAccount());
		this.hashColumns.put("sztp", getSztp());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("position", "position");
		this.hashFields.put("precell", "precell");
		this.hashFields.put("shift_rsn", "shiftRsn");
		this.hashFields.put("party", "party");
		this.hashFields.put("fe", "fe");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("file_atch", "fileAtch");
		this.hashFields.put("respb_cntr_no", "respbCntrNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("account", "account");
		this.hashFields.put("sztp", "sztp");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return position
	 */
	public String getPosition() {
		return this.position;
	}
	
	/**
	 * Column Info
	 * @return precell
	 */
	public String getPrecell() {
		return this.precell;
	}
	
	/**
	 * Column Info
	 * @return shiftRsn
	 */
	public String getShiftRsn() {
		return this.shiftRsn;
	}
	
	/**
	 * Column Info
	 * @return party
	 */
	public String getParty() {
		return this.party;
	}
	
	/**
	 * Column Info
	 * @return fe
	 */
	public String getFe() {
		return this.fe;
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
	 * @return fileAtch
	 */
	public String getFileAtch() {
		return this.fileAtch;
	}
	
	/**
	 * Column Info
	 * @return respbCntrNo
	 */
	public String getRespbCntrNo() {
		return this.respbCntrNo;
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
	 * @return oprCd
	 */
	public String getOprCd() {
		return this.oprCd;
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
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return account
	 */
	public String getAccount() {
		return this.account;
	}
	
	/**
	 * Column Info
	 * @return sztp
	 */
	public String getSztp() {
		return this.sztp;
	}
	

	/**
	 * Column Info
	 * @param position
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	
	/**
	 * Column Info
	 * @param precell
	 */
	public void setPrecell(String precell) {
		this.precell = precell;
	}
	
	/**
	 * Column Info
	 * @param shiftRsn
	 */
	public void setShiftRsn(String shiftRsn) {
		this.shiftRsn = shiftRsn;
	}
	
	/**
	 * Column Info
	 * @param party
	 */
	public void setParty(String party) {
		this.party = party;
	}
	
	/**
	 * Column Info
	 * @param fe
	 */
	public void setFe(String fe) {
		this.fe = fe;
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
	 * @param fileAtch
	 */
	public void setFileAtch(String fileAtch) {
		this.fileAtch = fileAtch;
	}
	
	/**
	 * Column Info
	 * @param respbCntrNo
	 */
	public void setRespbCntrNo(String respbCntrNo) {
		this.respbCntrNo = respbCntrNo;
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
	 * @param oprCd
	 */
	public void setOprCd(String oprCd) {
		this.oprCd = oprCd;
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
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param account
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	
	/**
	 * Column Info
	 * @param sztp
	 */
	public void setSztp(String sztp) {
		this.sztp = sztp;
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
		setPosition(JSPUtil.getParameter(request, prefix + "position", ""));
		setPrecell(JSPUtil.getParameter(request, prefix + "precell", ""));
		setShiftRsn(JSPUtil.getParameter(request, prefix + "shift_rsn", ""));
		setParty(JSPUtil.getParameter(request, prefix + "party", ""));
		setFe(JSPUtil.getParameter(request, prefix + "fe", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFileAtch(JSPUtil.getParameter(request, prefix + "file_atch", ""));
		setRespbCntrNo(JSPUtil.getParameter(request, prefix + "respb_cntr_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOprCd(JSPUtil.getParameter(request, prefix + "opr_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setAccount(JSPUtil.getParameter(request, prefix + "account", ""));
		setSztp(JSPUtil.getParameter(request, prefix + "sztp", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RHContainerVO[]
	 */
	public RHContainerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RHContainerVO[]
	 */
	public RHContainerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RHContainerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] position = (JSPUtil.getParameter(request, prefix	+ "position", length));
			String[] precell = (JSPUtil.getParameter(request, prefix	+ "precell", length));
			String[] shiftRsn = (JSPUtil.getParameter(request, prefix	+ "shift_rsn", length));
			String[] party = (JSPUtil.getParameter(request, prefix	+ "party", length));
			String[] fe = (JSPUtil.getParameter(request, prefix	+ "fe", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fileAtch = (JSPUtil.getParameter(request, prefix	+ "file_atch", length));
			String[] respbCntrNo = (JSPUtil.getParameter(request, prefix	+ "respb_cntr_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] account = (JSPUtil.getParameter(request, prefix	+ "account", length));
			String[] sztp = (JSPUtil.getParameter(request, prefix	+ "sztp", length));
			
			for (int i = 0; i < length; i++) {
				model = new RHContainerVO();
				if (position[i] != null)
					model.setPosition(position[i]);
				if (precell[i] != null)
					model.setPrecell(precell[i]);
				if (shiftRsn[i] != null)
					model.setShiftRsn(shiftRsn[i]);
				if (party[i] != null)
					model.setParty(party[i]);
				if (fe[i] != null)
					model.setFe(fe[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fileAtch[i] != null)
					model.setFileAtch(fileAtch[i]);
				if (respbCntrNo[i] != null)
					model.setRespbCntrNo(respbCntrNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oprCd[i] != null)
					model.setOprCd(oprCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (account[i] != null)
					model.setAccount(account[i]);
				if (sztp[i] != null)
					model.setSztp(sztp[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRHContainerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RHContainerVO[]
	 */
	public RHContainerVO[] getRHContainerVOs(){
		RHContainerVO[] vos = (RHContainerVO[])models.toArray(new RHContainerVO[models.size()]);
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
		this.position = this.position .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.precell = this.precell .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shiftRsn = this.shiftRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.party = this.party .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fe = this.fe .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileAtch = this.fileAtch .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbCntrNo = this.respbCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.account = this.account .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sztp = this.sztp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

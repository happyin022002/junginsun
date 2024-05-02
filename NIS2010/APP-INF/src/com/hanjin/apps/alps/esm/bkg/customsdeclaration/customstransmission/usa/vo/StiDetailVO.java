/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : StiDetailVO.java
*@FileTitle : StiDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.22
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
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

public class StiDetailVO extends ManifestTransmitVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<StiDetailVO> models = new ArrayList<StiDetailVO>();
	
	/* Column Info */
	private String excludeca = null;
	/* Column Info */
	private String imdg = null;
	/* Column Info */
	private String crrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String stiPos = null;
	/* Column Info */
	private String unno = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sentTime = null;
	/* Column Info */
	private String lPol = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String searchVvdCd = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String custResult = null;
	/* Column Info */
	private String fe = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String oPod = null;
	/* Column Info */
	private String tmp2 = null;
	/* Column Info */
	private String tmp1 = null;
	/* Column Info */
	private String tmp4 = null;
	/* Column Info */
	private String oprCd = null;
	/* Column Info */
	private String tmp3 = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String tmp5 = null;
	/* Column Info */
	private String vslVoy = null;
	/* Column Info */
	private String sztp = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public StiDetailVO() {}

	public StiDetailVO(String ibflag, String pagerows, String cntrNo, String oprCd, String pol, String pod, String sztp, String fe, String stiPos, String imdg, String unno, String searchVvdCd, String lPol, String sentTime, String custResult, String oPod, String vvd, String excludeca, String vslEngNm, String vslVoy, String crrCd, String tmp1, String tmp2, String tmp3, String tmp4, String tmp5) {
		this.excludeca = excludeca;
		this.imdg = imdg;
		this.crrCd = crrCd;
		this.pagerows = pagerows;
		this.stiPos = stiPos;
		this.unno = unno;
		this.ibflag = ibflag;
		this.sentTime = sentTime;
		this.lPol = lPol;
		this.vslEngNm = vslEngNm;
		this.pol = pol;
		this.searchVvdCd = searchVvdCd;
		this.pod = pod;
		this.custResult = custResult;
		this.fe = fe;
		this.vvd = vvd;
		this.oPod = oPod;
		this.tmp2 = tmp2;
		this.tmp1 = tmp1;
		this.tmp4 = tmp4;
		this.oprCd = oprCd;
		this.tmp3 = tmp3;
		this.cntrNo = cntrNo;
		this.tmp5 = tmp5;
		this.vslVoy = vslVoy;
		this.sztp = sztp;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("excludeca", getExcludeca());
		this.hashColumns.put("imdg", getImdg());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sti_pos", getStiPos());
		this.hashColumns.put("unno", getUnno());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sent_time", getSentTime());
		this.hashColumns.put("l_pol", getLPol());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("search_vvd_cd", getSearchVvdCd());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("cust_result", getCustResult());
		this.hashColumns.put("fe", getFe());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("o_pod", getOPod());
		this.hashColumns.put("tmp2", getTmp2());
		this.hashColumns.put("tmp1", getTmp1());
		this.hashColumns.put("tmp4", getTmp4());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("tmp3", getTmp3());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("tmp5", getTmp5());
		this.hashColumns.put("vsl_voy", getVslVoy());
		this.hashColumns.put("sztp", getSztp());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("excludeca", "excludeca");
		this.hashFields.put("imdg", "imdg");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sti_pos", "stiPos");
		this.hashFields.put("unno", "unno");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sent_time", "sentTime");
		this.hashFields.put("l_pol", "lPol");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("search_vvd_cd", "searchVvdCd");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("cust_result", "custResult");
		this.hashFields.put("fe", "fe");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("o_pod", "oPod");
		this.hashFields.put("tmp2", "tmp2");
		this.hashFields.put("tmp1", "tmp1");
		this.hashFields.put("tmp4", "tmp4");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("tmp3", "tmp3");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("tmp5", "tmp5");
		this.hashFields.put("vsl_voy", "vslVoy");
		this.hashFields.put("sztp", "sztp");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return excludeca
	 */
	public String getExcludeca() {
		return this.excludeca;
	}
	
	/**
	 * Column Info
	 * @return imdg
	 */
	public String getImdg() {
		return this.imdg;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
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
	 * @return stiPos
	 */
	public String getStiPos() {
		return this.stiPos;
	}
	
	/**
	 * Column Info
	 * @return unno
	 */
	public String getUnno() {
		return this.unno;
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
	 * @return sentTime
	 */
	public String getSentTime() {
		return this.sentTime;
	}
	
	/**
	 * Column Info
	 * @return lPol
	 */
	public String getLPol() {
		return this.lPol;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
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
	 * @return searchVvdCd
	 */
	public String getSearchVvdCd() {
		return this.searchVvdCd;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return custResult
	 */
	public String getCustResult() {
		return this.custResult;
	}
	
	/**
	 * Column Info
	 * @return fe
	 */
	public String getFe() {
		return this.fe;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return oPod
	 */
	public String getOPod() {
		return this.oPod;
	}
	
	/**
	 * Column Info
	 * @return tmp2
	 */
	public String getTmp2() {
		return this.tmp2;
	}
	
	/**
	 * Column Info
	 * @return tmp1
	 */
	public String getTmp1() {
		return this.tmp1;
	}
	
	/**
	 * Column Info
	 * @return tmp4
	 */
	public String getTmp4() {
		return this.tmp4;
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
	 * @return tmp3
	 */
	public String getTmp3() {
		return this.tmp3;
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
	 * @return tmp5
	 */
	public String getTmp5() {
		return this.tmp5;
	}
	
	/**
	 * Column Info
	 * @return vslVoy
	 */
	public String getVslVoy() {
		return this.vslVoy;
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
	 * @param excludeca
	 */
	public void setExcludeca(String excludeca) {
		this.excludeca = excludeca;
	}
	
	/**
	 * Column Info
	 * @param imdg
	 */
	public void setImdg(String imdg) {
		this.imdg = imdg;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
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
	 * @param stiPos
	 */
	public void setStiPos(String stiPos) {
		this.stiPos = stiPos;
	}
	
	/**
	 * Column Info
	 * @param unno
	 */
	public void setUnno(String unno) {
		this.unno = unno;
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
	 * @param sentTime
	 */
	public void setSentTime(String sentTime) {
		this.sentTime = sentTime;
	}
	
	/**
	 * Column Info
	 * @param lPol
	 */
	public void setLPol(String lPol) {
		this.lPol = lPol;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
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
	 * @param searchVvdCd
	 */
	public void setSearchVvdCd(String searchVvdCd) {
		this.searchVvdCd = searchVvdCd;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param custResult
	 */
	public void setCustResult(String custResult) {
		this.custResult = custResult;
	}
	
	/**
	 * Column Info
	 * @param fe
	 */
	public void setFe(String fe) {
		this.fe = fe;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param oPod
	 */
	public void setOPod(String oPod) {
		this.oPod = oPod;
	}
	
	/**
	 * Column Info
	 * @param tmp2
	 */
	public void setTmp2(String tmp2) {
		this.tmp2 = tmp2;
	}
	
	/**
	 * Column Info
	 * @param tmp1
	 */
	public void setTmp1(String tmp1) {
		this.tmp1 = tmp1;
	}
	
	/**
	 * Column Info
	 * @param tmp4
	 */
	public void setTmp4(String tmp4) {
		this.tmp4 = tmp4;
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
	 * @param tmp3
	 */
	public void setTmp3(String tmp3) {
		this.tmp3 = tmp3;
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
	 * @param tmp5
	 */
	public void setTmp5(String tmp5) {
		this.tmp5 = tmp5;
	}
	
	/**
	 * Column Info
	 * @param vslVoy
	 */
	public void setVslVoy(String vslVoy) {
		this.vslVoy = vslVoy;
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
		setExcludeca(JSPUtil.getParameter(request, prefix + "excludeca", ""));
		setImdg(JSPUtil.getParameter(request, prefix + "imdg", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setStiPos(JSPUtil.getParameter(request, prefix + "sti_pos", ""));
		setUnno(JSPUtil.getParameter(request, prefix + "unno", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSentTime(JSPUtil.getParameter(request, prefix + "sent_time", ""));
		setLPol(JSPUtil.getParameter(request, prefix + "l_pol", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setSearchVvdCd(JSPUtil.getParameter(request, prefix + "search_vvd_cd", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setCustResult(JSPUtil.getParameter(request, prefix + "cust_result", ""));
		setFe(JSPUtil.getParameter(request, prefix + "fe", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setOPod(JSPUtil.getParameter(request, prefix + "o_pod", ""));
		setTmp2(JSPUtil.getParameter(request, prefix + "tmp2", ""));
		setTmp1(JSPUtil.getParameter(request, prefix + "tmp1", ""));
		setTmp4(JSPUtil.getParameter(request, prefix + "tmp4", ""));
		setOprCd(JSPUtil.getParameter(request, prefix + "opr_cd", ""));
		setTmp3(JSPUtil.getParameter(request, prefix + "tmp3", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setTmp5(JSPUtil.getParameter(request, prefix + "tmp5", ""));
		setVslVoy(JSPUtil.getParameter(request, prefix + "vsl_voy", ""));
		setSztp(JSPUtil.getParameter(request, prefix + "sztp", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return StiDetailVO[]
	 */
	public StiDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return StiDetailVO[]
	 */
	public StiDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		StiDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] excludeca = (JSPUtil.getParameter(request, prefix	+ "excludeca", length));
			String[] imdg = (JSPUtil.getParameter(request, prefix	+ "imdg", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] stiPos = (JSPUtil.getParameter(request, prefix	+ "sti_pos", length));
			String[] unno = (JSPUtil.getParameter(request, prefix	+ "unno", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sentTime = (JSPUtil.getParameter(request, prefix	+ "sent_time", length));
			String[] lPol = (JSPUtil.getParameter(request, prefix	+ "l_pol", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] searchVvdCd = (JSPUtil.getParameter(request, prefix	+ "search_vvd_cd", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] custResult = (JSPUtil.getParameter(request, prefix	+ "cust_result", length));
			String[] fe = (JSPUtil.getParameter(request, prefix	+ "fe", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] oPod = (JSPUtil.getParameter(request, prefix	+ "o_pod", length));
			String[] tmp2 = (JSPUtil.getParameter(request, prefix	+ "tmp2", length));
			String[] tmp1 = (JSPUtil.getParameter(request, prefix	+ "tmp1", length));
			String[] tmp4 = (JSPUtil.getParameter(request, prefix	+ "tmp4", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] tmp3 = (JSPUtil.getParameter(request, prefix	+ "tmp3", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] tmp5 = (JSPUtil.getParameter(request, prefix	+ "tmp5", length));
			String[] vslVoy = (JSPUtil.getParameter(request, prefix	+ "vsl_voy", length));
			String[] sztp = (JSPUtil.getParameter(request, prefix	+ "sztp", length));
			
			for (int i = 0; i < length; i++) {
				model = new StiDetailVO();
				if (excludeca[i] != null)
					model.setExcludeca(excludeca[i]);
				if (imdg[i] != null)
					model.setImdg(imdg[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (stiPos[i] != null)
					model.setStiPos(stiPos[i]);
				if (unno[i] != null)
					model.setUnno(unno[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sentTime[i] != null)
					model.setSentTime(sentTime[i]);
				if (lPol[i] != null)
					model.setLPol(lPol[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (searchVvdCd[i] != null)
					model.setSearchVvdCd(searchVvdCd[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (custResult[i] != null)
					model.setCustResult(custResult[i]);
				if (fe[i] != null)
					model.setFe(fe[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (oPod[i] != null)
					model.setOPod(oPod[i]);
				if (tmp2[i] != null)
					model.setTmp2(tmp2[i]);
				if (tmp1[i] != null)
					model.setTmp1(tmp1[i]);
				if (tmp4[i] != null)
					model.setTmp4(tmp4[i]);
				if (oprCd[i] != null)
					model.setOprCd(oprCd[i]);
				if (tmp3[i] != null)
					model.setTmp3(tmp3[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (tmp5[i] != null)
					model.setTmp5(tmp5[i]);
				if (vslVoy[i] != null)
					model.setVslVoy(vslVoy[i]);
				if (sztp[i] != null)
					model.setSztp(sztp[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getStiDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return StiDetailVO[]
	 */
	public StiDetailVO[] getStiDetailVOs(){
		StiDetailVO[] vos = (StiDetailVO[])models.toArray(new StiDetailVO[models.size()]);
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
		this.excludeca = this.excludeca .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdg = this.imdg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stiPos = this.stiPos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unno = this.unno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sentTime = this.sentTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lPol = this.lPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchVvdCd = this.searchVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custResult = this.custResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fe = this.fe .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oPod = this.oPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp2 = this.tmp2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp1 = this.tmp1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp4 = this.tmp4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp3 = this.tmp3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp5 = this.tmp5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslVoy = this.vslVoy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sztp = this.sztp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

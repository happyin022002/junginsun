/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorAmdTransVO.java
*@FileTitle : KorAmdTransVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.10.12 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorAmdTransVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorAmdTransVO> models = new ArrayList<KorAmdTransVO>();
	
	/* Column Info */
	private String smtAmdNo = null;
	/* Column Info */
	private String rn = null;
	/* Column Info */
	private String p4 = null;
	/* Column Info */
	private String p3 = null;
	/* Column Info */
	private String sendDt = null;
	/* Column Info */
	private String p2 = null;
	/* Column Info */
	private String p1 = null;
	/* Column Info */
	private String msnNo = null;
	/* Column Info */
	private String b2 = null;
	/* Column Info */
	private String c4 = null;
	/* Column Info */
	private String c3 = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String id = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cstmsDeclTpCd = null;
	/* Column Info */
	private String c1 = null;
	/* Column Info */
	private String c2 = null;
	/* Column Info */
	private String b1 = null;
	/* Column Info */
	private String portCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorAmdTransVO() {}

	public KorAmdTransVO(String ibflag, String pagerows, String msnNo, String blNo, String b1, String b2, String p1, String c1, String p2, String c2, String p3, String c3, String p4, String c4, String id, String rn, String sendDt, String vvd, String bkgNo, String portCd, String cstmsDeclTpCd, String smtAmdNo) {
		this.smtAmdNo = smtAmdNo;
		this.rn = rn;
		this.p4 = p4;
		this.p3 = p3;
		this.sendDt = sendDt;
		this.p2 = p2;
		this.p1 = p1;
		this.msnNo = msnNo;
		this.b2 = b2;
		this.c4 = c4;
		this.c3 = c3;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.id = id;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.cstmsDeclTpCd = cstmsDeclTpCd;
		this.c1 = c1;
		this.c2 = c2;
		this.b1 = b1;
		this.portCd = portCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("smt_amd_no", getSmtAmdNo());
		this.hashColumns.put("rn", getRn());
		this.hashColumns.put("p4", getP4());
		this.hashColumns.put("p3", getP3());
		this.hashColumns.put("send_dt", getSendDt());
		this.hashColumns.put("p2", getP2());
		this.hashColumns.put("p1", getP1());
		this.hashColumns.put("msn_no", getMsnNo());
		this.hashColumns.put("b2", getB2());
		this.hashColumns.put("c4", getC4());
		this.hashColumns.put("c3", getC3());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("id", getId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cstms_decl_tp_cd", getCstmsDeclTpCd());
		this.hashColumns.put("c1", getC1());
		this.hashColumns.put("c2", getC2());
		this.hashColumns.put("b1", getB1());
		this.hashColumns.put("port_cd", getPortCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("smt_amd_no", "smtAmdNo");
		this.hashFields.put("rn", "rn");
		this.hashFields.put("p4", "p4");
		this.hashFields.put("p3", "p3");
		this.hashFields.put("send_dt", "sendDt");
		this.hashFields.put("p2", "p2");
		this.hashFields.put("p1", "p1");
		this.hashFields.put("msn_no", "msnNo");
		this.hashFields.put("b2", "b2");
		this.hashFields.put("c4", "c4");
		this.hashFields.put("c3", "c3");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("id", "id");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cstms_decl_tp_cd", "cstmsDeclTpCd");
		this.hashFields.put("c1", "c1");
		this.hashFields.put("c2", "c2");
		this.hashFields.put("b1", "b1");
		this.hashFields.put("port_cd", "portCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return smtAmdNo
	 */
	public String getSmtAmdNo() {
		return this.smtAmdNo;
	}
	
	/**
	 * Column Info
	 * @return rn
	 */
	public String getRn() {
		return this.rn;
	}
	
	/**
	 * Column Info
	 * @return p4
	 */
	public String getP4() {
		return this.p4;
	}
	
	/**
	 * Column Info
	 * @return p3
	 */
	public String getP3() {
		return this.p3;
	}
	
	/**
	 * Column Info
	 * @return sendDt
	 */
	public String getSendDt() {
		return this.sendDt;
	}
	
	/**
	 * Column Info
	 * @return p2
	 */
	public String getP2() {
		return this.p2;
	}
	
	/**
	 * Column Info
	 * @return p1
	 */
	public String getP1() {
		return this.p1;
	}
	
	/**
	 * Column Info
	 * @return msnNo
	 */
	public String getMsnNo() {
		return this.msnNo;
	}
	
	/**
	 * Column Info
	 * @return b2
	 */
	public String getB2() {
		return this.b2;
	}
	
	/**
	 * Column Info
	 * @return c4
	 */
	public String getC4() {
		return this.c4;
	}
	
	/**
	 * Column Info
	 * @return c3
	 */
	public String getC3() {
		return this.c3;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return id
	 */
	public String getId() {
		return this.id;
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
	 * @return cstmsDeclTpCd
	 */
	public String getCstmsDeclTpCd() {
		return this.cstmsDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @return c1
	 */
	public String getC1() {
		return this.c1;
	}
	
	/**
	 * Column Info
	 * @return c2
	 */
	public String getC2() {
		return this.c2;
	}
	
	/**
	 * Column Info
	 * @return b1
	 */
	public String getB1() {
		return this.b1;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	

	/**
	 * Column Info
	 * @param smtAmdNo
	 */
	public void setSmtAmdNo(String smtAmdNo) {
		this.smtAmdNo = smtAmdNo;
	}
	
	/**
	 * Column Info
	 * @param rn
	 */
	public void setRn(String rn) {
		this.rn = rn;
	}
	
	/**
	 * Column Info
	 * @param p4
	 */
	public void setP4(String p4) {
		this.p4 = p4;
	}
	
	/**
	 * Column Info
	 * @param p3
	 */
	public void setP3(String p3) {
		this.p3 = p3;
	}
	
	/**
	 * Column Info
	 * @param sendDt
	 */
	public void setSendDt(String sendDt) {
		this.sendDt = sendDt;
	}
	
	/**
	 * Column Info
	 * @param p2
	 */
	public void setP2(String p2) {
		this.p2 = p2;
	}
	
	/**
	 * Column Info
	 * @param p1
	 */
	public void setP1(String p1) {
		this.p1 = p1;
	}
	
	/**
	 * Column Info
	 * @param msnNo
	 */
	public void setMsnNo(String msnNo) {
		this.msnNo = msnNo;
	}
	
	/**
	 * Column Info
	 * @param b2
	 */
	public void setB2(String b2) {
		this.b2 = b2;
	}
	
	/**
	 * Column Info
	 * @param c4
	 */
	public void setC4(String c4) {
		this.c4 = c4;
	}
	
	/**
	 * Column Info
	 * @param c3
	 */
	public void setC3(String c3) {
		this.c3 = c3;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @param cstmsDeclTpCd
	 */
	public void setCstmsDeclTpCd(String cstmsDeclTpCd) {
		this.cstmsDeclTpCd = cstmsDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @param c1
	 */
	public void setC1(String c1) {
		this.c1 = c1;
	}
	
	/**
	 * Column Info
	 * @param c2
	 */
	public void setC2(String c2) {
		this.c2 = c2;
	}
	
	/**
	 * Column Info
	 * @param b1
	 */
	public void setB1(String b1) {
		this.b1 = b1;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSmtAmdNo(JSPUtil.getParameter(request, "smt_amd_no", ""));
		setRn(JSPUtil.getParameter(request, "rn", ""));
		setP4(JSPUtil.getParameter(request, "p4", ""));
		setP3(JSPUtil.getParameter(request, "p3", ""));
		setSendDt(JSPUtil.getParameter(request, "send_dt", ""));
		setP2(JSPUtil.getParameter(request, "p2", ""));
		setP1(JSPUtil.getParameter(request, "p1", ""));
		setMsnNo(JSPUtil.getParameter(request, "msn_no", ""));
		setB2(JSPUtil.getParameter(request, "b2", ""));
		setC4(JSPUtil.getParameter(request, "c4", ""));
		setC3(JSPUtil.getParameter(request, "c3", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setId(JSPUtil.getParameter(request, "id", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCstmsDeclTpCd(JSPUtil.getParameter(request, "cstms_decl_tp_cd", ""));
		setC1(JSPUtil.getParameter(request, "c1", ""));
		setC2(JSPUtil.getParameter(request, "c2", ""));
		setB1(JSPUtil.getParameter(request, "b1", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorAmdTransVO[]
	 */
	public KorAmdTransVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorAmdTransVO[]
	 */
	public KorAmdTransVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorAmdTransVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] smtAmdNo = (JSPUtil.getParameter(request, prefix	+ "smt_amd_no", length));
			String[] rn = (JSPUtil.getParameter(request, prefix	+ "rn", length));
			String[] p4 = (JSPUtil.getParameter(request, prefix	+ "p4", length));
			String[] p3 = (JSPUtil.getParameter(request, prefix	+ "p3", length));
			String[] sendDt = (JSPUtil.getParameter(request, prefix	+ "send_dt", length));
			String[] p2 = (JSPUtil.getParameter(request, prefix	+ "p2", length));
			String[] p1 = (JSPUtil.getParameter(request, prefix	+ "p1", length));
			String[] msnNo = (JSPUtil.getParameter(request, prefix	+ "msn_no", length));
			String[] b2 = (JSPUtil.getParameter(request, prefix	+ "b2", length));
			String[] c4 = (JSPUtil.getParameter(request, prefix	+ "c4", length));
			String[] c3 = (JSPUtil.getParameter(request, prefix	+ "c3", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] id = (JSPUtil.getParameter(request, prefix	+ "id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cstmsDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_tp_cd", length));
			String[] c1 = (JSPUtil.getParameter(request, prefix	+ "c1", length));
			String[] c2 = (JSPUtil.getParameter(request, prefix	+ "c2", length));
			String[] b1 = (JSPUtil.getParameter(request, prefix	+ "b1", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorAmdTransVO();
				if (smtAmdNo[i] != null)
					model.setSmtAmdNo(smtAmdNo[i]);
				if (rn[i] != null)
					model.setRn(rn[i]);
				if (p4[i] != null)
					model.setP4(p4[i]);
				if (p3[i] != null)
					model.setP3(p3[i]);
				if (sendDt[i] != null)
					model.setSendDt(sendDt[i]);
				if (p2[i] != null)
					model.setP2(p2[i]);
				if (p1[i] != null)
					model.setP1(p1[i]);
				if (msnNo[i] != null)
					model.setMsnNo(msnNo[i]);
				if (b2[i] != null)
					model.setB2(b2[i]);
				if (c4[i] != null)
					model.setC4(c4[i]);
				if (c3[i] != null)
					model.setC3(c3[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (id[i] != null)
					model.setId(id[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cstmsDeclTpCd[i] != null)
					model.setCstmsDeclTpCd(cstmsDeclTpCd[i]);
				if (c1[i] != null)
					model.setC1(c1[i]);
				if (c2[i] != null)
					model.setC2(c2[i]);
				if (b1[i] != null)
					model.setB1(b1[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorAmdTransVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorAmdTransVO[]
	 */
	public KorAmdTransVO[] getKorAmdTransVOs(){
		KorAmdTransVO[] vos = (KorAmdTransVO[])models.toArray(new KorAmdTransVO[models.size()]);
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
		this.smtAmdNo = this.smtAmdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rn = this.rn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p4 = this.p4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p3 = this.p3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendDt = this.sendDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p2 = this.p2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p1 = this.p1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msnNo = this.msnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b2 = this.b2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c4 = this.c4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c3 = this.c3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.id = this.id .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclTpCd = this.cstmsDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c1 = this.c1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c2 = this.c2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b1 = this.b1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

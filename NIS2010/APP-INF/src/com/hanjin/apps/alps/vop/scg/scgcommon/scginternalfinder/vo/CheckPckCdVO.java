/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CheckPckCdVO.java
*@FileTitle : CheckPckCdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.04
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.06.04 원종규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.vo;

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
 * @author 원종규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CheckPckCdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CheckPckCdVO> models = new ArrayList<CheckPckCdVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String pckCdSeqMin = null;
	/* Column Info */
	private String pckCdSeqCnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String imdgPckInstrCd = null;
	/* Column Info */
	private String pckCdSeqMax = null;
	/* Column Info */
	private String imdgPckInstrSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CheckPckCdVO() {}

	public CheckPckCdVO(String ibflag, String pagerows, String imdgPckInstrCd, String imdgPckInstrSeq, String pckCdSeqMax, String pckCdSeqMin, String pckCdSeqCnt, String updDt) {
		this.updDt = updDt;
		this.pckCdSeqMin = pckCdSeqMin;
		this.pckCdSeqCnt = pckCdSeqCnt;
		this.ibflag = ibflag;
		this.imdgPckInstrCd = imdgPckInstrCd;
		this.pckCdSeqMax = pckCdSeqMax;
		this.imdgPckInstrSeq = imdgPckInstrSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("pck_cd_seq_min", getPckCdSeqMin());
		this.hashColumns.put("pck_cd_seq_cnt", getPckCdSeqCnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("imdg_pck_instr_cd", getImdgPckInstrCd());
		this.hashColumns.put("pck_cd_seq_max", getPckCdSeqMax());
		this.hashColumns.put("imdg_pck_instr_seq", getImdgPckInstrSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("pck_cd_seq_min", "pckCdSeqMin");
		this.hashFields.put("pck_cd_seq_cnt", "pckCdSeqCnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("imdg_pck_instr_cd", "imdgPckInstrCd");
		this.hashFields.put("pck_cd_seq_max", "pckCdSeqMax");
		this.hashFields.put("imdg_pck_instr_seq", "imdgPckInstrSeq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return pckCdSeqMin
	 */
	public String getPckCdSeqMin() {
		return this.pckCdSeqMin;
	}
	
	/**
	 * Column Info
	 * @return pckCdSeqCnt
	 */
	public String getPckCdSeqCnt() {
		return this.pckCdSeqCnt;
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
	 * @return imdgPckInstrCd
	 */
	public String getImdgPckInstrCd() {
		return this.imdgPckInstrCd;
	}
	
	/**
	 * Column Info
	 * @return pckCdSeqMax
	 */
	public String getPckCdSeqMax() {
		return this.pckCdSeqMax;
	}
	
	/**
	 * Column Info
	 * @return imdgPckInstrSeq
	 */
	public String getImdgPckInstrSeq() {
		return this.imdgPckInstrSeq;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param pckCdSeqMin
	 */
	public void setPckCdSeqMin(String pckCdSeqMin) {
		this.pckCdSeqMin = pckCdSeqMin;
	}
	
	/**
	 * Column Info
	 * @param pckCdSeqCnt
	 */
	public void setPckCdSeqCnt(String pckCdSeqCnt) {
		this.pckCdSeqCnt = pckCdSeqCnt;
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
	 * @param imdgPckInstrCd
	 */
	public void setImdgPckInstrCd(String imdgPckInstrCd) {
		this.imdgPckInstrCd = imdgPckInstrCd;
	}
	
	/**
	 * Column Info
	 * @param pckCdSeqMax
	 */
	public void setPckCdSeqMax(String pckCdSeqMax) {
		this.pckCdSeqMax = pckCdSeqMax;
	}
	
	/**
	 * Column Info
	 * @param imdgPckInstrSeq
	 */
	public void setImdgPckInstrSeq(String imdgPckInstrSeq) {
		this.imdgPckInstrSeq = imdgPckInstrSeq;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setPckCdSeqMin(JSPUtil.getParameter(request, prefix + "pck_cd_seq_min", ""));
		setPckCdSeqCnt(JSPUtil.getParameter(request, prefix + "pck_cd_seq_cnt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setImdgPckInstrCd(JSPUtil.getParameter(request, prefix + "imdg_pck_instr_cd", ""));
		setPckCdSeqMax(JSPUtil.getParameter(request, prefix + "pck_cd_seq_max", ""));
		setImdgPckInstrSeq(JSPUtil.getParameter(request, prefix + "imdg_pck_instr_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CheckPckCdVO[]
	 */
	public CheckPckCdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CheckPckCdVO[]
	 */
	public CheckPckCdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CheckPckCdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] pckCdSeqMin = (JSPUtil.getParameter(request, prefix	+ "pck_cd_seq_min", length));
			String[] pckCdSeqCnt = (JSPUtil.getParameter(request, prefix	+ "pck_cd_seq_cnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] imdgPckInstrCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_instr_cd", length));
			String[] pckCdSeqMax = (JSPUtil.getParameter(request, prefix	+ "pck_cd_seq_max", length));
			String[] imdgPckInstrSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_instr_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CheckPckCdVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (pckCdSeqMin[i] != null)
					model.setPckCdSeqMin(pckCdSeqMin[i]);
				if (pckCdSeqCnt[i] != null)
					model.setPckCdSeqCnt(pckCdSeqCnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (imdgPckInstrCd[i] != null)
					model.setImdgPckInstrCd(imdgPckInstrCd[i]);
				if (pckCdSeqMax[i] != null)
					model.setPckCdSeqMax(pckCdSeqMax[i]);
				if (imdgPckInstrSeq[i] != null)
					model.setImdgPckInstrSeq(imdgPckInstrSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCheckPckCdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CheckPckCdVO[]
	 */
	public CheckPckCdVO[] getCheckPckCdVOs(){
		CheckPckCdVO[] vos = (CheckPckCdVO[])models.toArray(new CheckPckCdVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckCdSeqMin = this.pckCdSeqMin .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckCdSeqCnt = this.pckCdSeqCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckInstrCd = this.imdgPckInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckCdSeqMax = this.pckCdSeqMax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckInstrSeq = this.imdgPckInstrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

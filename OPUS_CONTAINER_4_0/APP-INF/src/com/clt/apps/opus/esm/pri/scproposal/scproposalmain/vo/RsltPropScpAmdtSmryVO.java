/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPropScpAmdtSmryVO.java
*@FileTitle : RsltPropScpAmdtSmryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.07.02 변영주 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 변영주
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPropScpAmdtSmryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPropScpAmdtSmryVO> models = new ArrayList<RsltPropScpAmdtSmryVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String datFlg = null;
	/* Column Info */
	private String amdtFlg = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String propScpTermTpCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String acptFlg = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPropScpAmdtSmryVO() {}

	public RsltPropScpAmdtSmryVO(String ibflag, String pagerows, String propNo, String amdtSeq, String svcScpCd, String propScpTermTpCd, String amdtFlg, String acptFlg, String datFlg) {
		this.ibflag = ibflag;
		this.datFlg = datFlg;
		this.amdtFlg = amdtFlg;
		this.amdtSeq = amdtSeq;
		this.propNo = propNo;
		this.propScpTermTpCd = propScpTermTpCd;
		this.svcScpCd = svcScpCd;
		this.acptFlg = acptFlg;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dat_flg", getDatFlg());
		this.hashColumns.put("amdt_flg", getAmdtFlg());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("prop_scp_term_tp_cd", getPropScpTermTpCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("acpt_flg", getAcptFlg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dat_flg", "datFlg");
		this.hashFields.put("amdt_flg", "amdtFlg");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("prop_scp_term_tp_cd", "propScpTermTpCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("acpt_flg", "acptFlg");
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
	 * @return datFlg
	 */
	public String getDatFlg() {
		return this.datFlg;
	}
	
	/**
	 * Column Info
	 * @return amdtFlg
	 */
	public String getAmdtFlg() {
		return this.amdtFlg;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return propScpTermTpCd
	 */
	public String getPropScpTermTpCd() {
		return this.propScpTermTpCd;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return acptFlg
	 */
	public String getAcptFlg() {
		return this.acptFlg;
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
	 * @param datFlg
	 */
	public void setDatFlg(String datFlg) {
		this.datFlg = datFlg;
	}
	
	/**
	 * Column Info
	 * @param amdtFlg
	 */
	public void setAmdtFlg(String amdtFlg) {
		this.amdtFlg = amdtFlg;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param propScpTermTpCd
	 */
	public void setPropScpTermTpCd(String propScpTermTpCd) {
		this.propScpTermTpCd = propScpTermTpCd;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param acptFlg
	 */
	public void setAcptFlg(String acptFlg) {
		this.acptFlg = acptFlg;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDatFlg(JSPUtil.getParameter(request, "dat_flg", ""));
		setAmdtFlg(JSPUtil.getParameter(request, "amdt_flg", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setPropScpTermTpCd(JSPUtil.getParameter(request, "prop_scp_term_tp_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setAcptFlg(JSPUtil.getParameter(request, "acpt_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPropScpAmdtSmryVO[]
	 */
	public RsltPropScpAmdtSmryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPropScpAmdtSmryVO[]
	 */
	public RsltPropScpAmdtSmryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPropScpAmdtSmryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] datFlg = (JSPUtil.getParameter(request, prefix	+ "dat_flg", length));
			String[] amdtFlg = (JSPUtil.getParameter(request, prefix	+ "amdt_flg", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] propScpTermTpCd = (JSPUtil.getParameter(request, prefix	+ "prop_scp_term_tp_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] acptFlg = (JSPUtil.getParameter(request, prefix	+ "acpt_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPropScpAmdtSmryVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (datFlg[i] != null)
					model.setDatFlg(datFlg[i]);
				if (amdtFlg[i] != null)
					model.setAmdtFlg(amdtFlg[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (propScpTermTpCd[i] != null)
					model.setPropScpTermTpCd(propScpTermTpCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (acptFlg[i] != null)
					model.setAcptFlg(acptFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPropScpAmdtSmryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPropScpAmdtSmryVO[]
	 */
	public RsltPropScpAmdtSmryVO[] getRsltPropScpAmdtSmryVOs(){
		RsltPropScpAmdtSmryVO[] vos = (RsltPropScpAmdtSmryVO[])models.toArray(new RsltPropScpAmdtSmryVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.datFlg = this.datFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtFlg = this.amdtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propScpTermTpCd = this.propScpTermTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptFlg = this.acptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

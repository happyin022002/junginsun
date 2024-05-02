/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ScGlineCopyVO.java
 *@FileTitle : ScGlineCopyVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.29
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.05.29 박성수 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo;

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
 * @author 박성수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RfaGlineCopyVO extends AbstractValueObject {
 
	private static final long serialVersionUID = 1L;

	private Collection<RfaGlineCopyVO> models = new ArrayList<RfaGlineCopyVO>();

	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public RfaGlineCopyVO() {
	}

	public RfaGlineCopyVO(String ibflag, String pagerows, String propNo, String amdtSeq, String svcScpCd,
			String effDt, String creUsrId, String updUsrId) {
		this.creUsrId = creUsrId;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.amdtSeq = amdtSeq;
		this.propNo = propNo;
		this.svcScpCd = svcScpCd;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * 
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}

	/**
	 * Column Info
	 * 
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Page Number
	 * 
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}

	/**
	 * Column Info
	 * 
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * Page Number
	 * 
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * 
	 * @param request
	 * @return ScGlineCopyVO[]
	 */
	public RfaGlineCopyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 * @param prefix
	 * @return ScGlineCopyVO[]
	 */
	public RfaGlineCopyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RfaGlineCopyVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id".trim(), length));
			String[] effDt = (JSPUtil.getParameter(request, prefix + "eff_dt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix + "amdt_seq".trim(), length));
			String[] propNo = (JSPUtil.getParameter(request, prefix + "prop_no".trim(), length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix + "svc_scp_cd".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new RfaGlineCopyVO();
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScGlineCopyVOs();
	}

	/**
	 * VO 배열을 반환
	 * 
	 * @return ScGlineCopyVO[]
	 */
	public RfaGlineCopyVO[] getScGlineCopyVOs() {
		RfaGlineCopyVO[] vos = (RfaGlineCopyVO[]) models.toArray(new RfaGlineCopyVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try {
			for (int i = 0; i < field.length; i++) {
				String[] arr = null;
				arr = getField(field, i);
				if (arr != null) {
					for (int j = 0; j < arr.length; j++) {
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
	 * 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try {
			arr = (String[]) field[i].get(this);
		} catch (Exception ex) {
			arr = null;
		}
		return arr;
	}

	/**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
	public void unDataFormat() {
		this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

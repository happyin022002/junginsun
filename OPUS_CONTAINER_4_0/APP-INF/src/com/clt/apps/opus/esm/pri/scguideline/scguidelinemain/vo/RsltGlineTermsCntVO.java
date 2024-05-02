/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RsltGlineTermsCntVO.java
 *@FileTitle : RsltGlineTermsCntVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.17
 *@LastModifier : 김재연
 *@LastVersion : 1.0
 * 2009.06.17 김재연 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.vo;

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
 * @author 김재연
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltGlineTermsCntVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<RsltGlineTermsCntVO> models = new ArrayList<RsltGlineTermsCntVO>();

	/* Column Info */
	private String gohCnt = null;
	/* Column Info */
	private String grpLocCnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String destArbCnt = null;
	/* Column Info */
	private String rateCnt = null;
	/* Column Info */
	private String slsRefCnt = null;
	/* Column Info */
	private String orgArbCnt = null;
	/* Column Info */
	private String arbCnt = null;
	/* Column Info */
	private String grpCmdtCnt = null;
	/* Column Info */
	private String ctrtCluzCnt = null;
	/* Page Number */
	private String pagerows = null;

	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public RsltGlineTermsCntVO() {
	}

	public RsltGlineTermsCntVO(String ibflag, String pagerows, String slsRefCnt, String grpLocCnt, String grpCmdtCnt,
			String arbCnt, String rateCnt, String gohCnt, String ctrtCluzCnt, String orgArbCnt, String destArbCnt) {
		this.gohCnt = gohCnt;
		this.grpLocCnt = grpLocCnt;
		this.ibflag = ibflag;
		this.destArbCnt = destArbCnt;
		this.rateCnt = rateCnt;
		this.slsRefCnt = slsRefCnt;
		this.orgArbCnt = orgArbCnt;
		this.arbCnt = arbCnt;
		this.grpCmdtCnt = grpCmdtCnt;
		this.ctrtCluzCnt = ctrtCluzCnt;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("goh_cnt", getGohCnt());
		this.hashColumns.put("grp_loc_cnt", getGrpLocCnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dest_arb_cnt", getDestArbCnt());
		this.hashColumns.put("rate_cnt", getRateCnt());
		this.hashColumns.put("sls_ref_cnt", getSlsRefCnt());
		this.hashColumns.put("org_arb_cnt", getOrgArbCnt());
		this.hashColumns.put("arb_cnt", getArbCnt());
		this.hashColumns.put("grp_cmdt_cnt", getGrpCmdtCnt());
		this.hashColumns.put("ctrt_cluz_cnt", getCtrtCluzCnt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("goh_cnt", "gohCnt");
		this.hashFields.put("grp_loc_cnt", "grpLocCnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dest_arb_cnt", "destArbCnt");
		this.hashFields.put("rate_cnt", "rateCnt");
		this.hashFields.put("sls_ref_cnt", "slsRefCnt");
		this.hashFields.put("org_arb_cnt", "orgArbCnt");
		this.hashFields.put("arb_cnt", "arbCnt");
		this.hashFields.put("grp_cmdt_cnt", "grpCmdtCnt");
		this.hashFields.put("ctrt_cluz_cnt", "ctrtCluzCnt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * 
	 * @return gohCnt
	 */
	public String getGohCnt() {
		return this.gohCnt;
	}

	/**
	 * Column Info
	 * 
	 * @return grpLocCnt
	 */
	public String getGrpLocCnt() {
		return this.grpLocCnt;
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
	 * @return destArbCnt
	 */
	public String getDestArbCnt() {
		return this.destArbCnt;
	}

	/**
	 * Column Info
	 * 
	 * @return rateCnt
	 */
	public String getRateCnt() {
		return this.rateCnt;
	}

	/**
	 * Column Info
	 * 
	 * @return slsRefCnt
	 */
	public String getSlsRefCnt() {
		return this.slsRefCnt;
	}

	/**
	 * Column Info
	 * 
	 * @return orgArbCnt
	 */
	public String getOrgArbCnt() {
		return this.orgArbCnt;
	}

	/**
	 * Column Info
	 * 
	 * @return arbCnt
	 */
	public String getArbCnt() {
		return this.arbCnt;
	}

	/**
	 * Column Info
	 * 
	 * @return grpCmdtCnt
	 */
	public String getGrpCmdtCnt() {
		return this.grpCmdtCnt;
	}

	/**
	 * Column Info
	 * 
	 * @return ctrtCluzCnt
	 */
	public String getCtrtCluzCnt() {
		return this.ctrtCluzCnt;
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
	 * @param gohCnt
	 */
	public void setGohCnt(String gohCnt) {
		this.gohCnt = gohCnt;
	}

	/**
	 * Column Info
	 * 
	 * @param grpLocCnt
	 */
	public void setGrpLocCnt(String grpLocCnt) {
		this.grpLocCnt = grpLocCnt;
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
	 * @param destArbCnt
	 */
	public void setDestArbCnt(String destArbCnt) {
		this.destArbCnt = destArbCnt;
	}

	/**
	 * Column Info
	 * 
	 * @param rateCnt
	 */
	public void setRateCnt(String rateCnt) {
		this.rateCnt = rateCnt;
	}

	/**
	 * Column Info
	 * 
	 * @param slsRefCnt
	 */
	public void setSlsRefCnt(String slsRefCnt) {
		this.slsRefCnt = slsRefCnt;
	}

	/**
	 * Column Info
	 * 
	 * @param orgArbCnt
	 */
	public void setOrgArbCnt(String orgArbCnt) {
		this.orgArbCnt = orgArbCnt;
	}

	/**
	 * Column Info
	 * 
	 * @param arbCnt
	 */
	public void setArbCnt(String arbCnt) {
		this.arbCnt = arbCnt;
	}

	/**
	 * Column Info
	 * 
	 * @param grpCmdtCnt
	 */
	public void setGrpCmdtCnt(String grpCmdtCnt) {
		this.grpCmdtCnt = grpCmdtCnt;
	}

	/**
	 * Column Info
	 * 
	 * @param ctrtCluzCnt
	 */
	public void setCtrtCluzCnt(String ctrtCluzCnt) {
		this.ctrtCluzCnt = ctrtCluzCnt;
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
		setGohCnt(JSPUtil.getParameter(request, "goh_cnt", ""));
		setGrpLocCnt(JSPUtil.getParameter(request, "grp_loc_cnt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDestArbCnt(JSPUtil.getParameter(request, "dest_arb_cnt", ""));
		setRateCnt(JSPUtil.getParameter(request, "rate_cnt", ""));
		setSlsRefCnt(JSPUtil.getParameter(request, "sls_ref_cnt", ""));
		setOrgArbCnt(JSPUtil.getParameter(request, "org_arb_cnt", ""));
		setArbCnt(JSPUtil.getParameter(request, "arb_cnt", ""));
		setGrpCmdtCnt(JSPUtil.getParameter(request, "grp_cmdt_cnt", ""));
		setCtrtCluzCnt(JSPUtil.getParameter(request, "ctrt_cluz_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * 
	 * @param request
	 * @return RsltGlineTermsCntVO[]
	 */
	public RsltGlineTermsCntVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 * @param prefix
	 * @return RsltGlineTermsCntVO[]
	 */
	public RsltGlineTermsCntVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltGlineTermsCntVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] gohCnt = (JSPUtil.getParameter(request, prefix + "goh_cnt", length));
			String[] grpLocCnt = (JSPUtil.getParameter(request, prefix + "grp_loc_cnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
			String[] destArbCnt = (JSPUtil.getParameter(request, prefix + "dest_arb_cnt", length));
			String[] rateCnt = (JSPUtil.getParameter(request, prefix + "rate_cnt", length));
			String[] slsRefCnt = (JSPUtil.getParameter(request, prefix + "sls_ref_cnt", length));
			String[] orgArbCnt = (JSPUtil.getParameter(request, prefix + "org_arb_cnt", length));
			String[] arbCnt = (JSPUtil.getParameter(request, prefix + "arb_cnt", length));
			String[] grpCmdtCnt = (JSPUtil.getParameter(request, prefix + "grp_cmdt_cnt", length));
			String[] ctrtCluzCnt = (JSPUtil.getParameter(request, prefix + "ctrt_cluz_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new RsltGlineTermsCntVO();
				if (gohCnt[i] != null)
					model.setGohCnt(gohCnt[i]);
				if (grpLocCnt[i] != null)
					model.setGrpLocCnt(grpLocCnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (destArbCnt[i] != null)
					model.setDestArbCnt(destArbCnt[i]);
				if (rateCnt[i] != null)
					model.setRateCnt(rateCnt[i]);
				if (slsRefCnt[i] != null)
					model.setSlsRefCnt(slsRefCnt[i]);
				if (orgArbCnt[i] != null)
					model.setOrgArbCnt(orgArbCnt[i]);
				if (arbCnt[i] != null)
					model.setArbCnt(arbCnt[i]);
				if (grpCmdtCnt[i] != null)
					model.setGrpCmdtCnt(grpCmdtCnt[i]);
				if (ctrtCluzCnt[i] != null)
					model.setCtrtCluzCnt(ctrtCluzCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltGlineTermsCntVOs();
	}

	/**
	 * VO 배열을 반환
	 * 
	 * @return RsltGlineTermsCntVO[]
	 */
	public RsltGlineTermsCntVO[] getRsltGlineTermsCntVOs() {
		RsltGlineTermsCntVO[] vos = (RsltGlineTermsCntVO[]) models.toArray(new RsltGlineTermsCntVO[models.size()]);
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
		this.gohCnt = this.gohCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpLocCnt = this.grpLocCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destArbCnt = this.destArbCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":",
				"");
		this.rateCnt = this.rateCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRefCnt = this.slsRefCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgArbCnt = this.orgArbCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arbCnt = this.arbCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpCmdtCnt = this.grpCmdtCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":",
				"");
		this.ctrtCluzCnt = this.ctrtCluzCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":",
				"");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AdvJpMarkDescVO.java
*@FileTitle : AdvJpMarkDescVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.05
*@LastModifier :
*@LastVersion : 1.0
* 2013.09.05
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AdvJpMarkDescVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<AdvJpMarkDescVO> models = new ArrayList<AdvJpMarkDescVO>();

	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String blSeq = null;
	/* Column Info */
	private String cmdtHsCd = null;
	/* Column Info */
	private String blDesc = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String blSplitNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public AdvJpMarkDescVO() {}

	public AdvJpMarkDescVO(String ibflag, String pagerows, String blNo, String blSplitNo, String blSeq, String diffRmk, String blDesc, String cmdtHsCd, String usrId) {
		this.ibflag = ibflag;
		this.diffRmk = diffRmk;
		this.usrId = usrId;
		this.blSeq = blSeq;
		this.cmdtHsCd = cmdtHsCd;
		this.blDesc = blDesc;
		this.blNo = blNo;
		this.blSplitNo = blSplitNo;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("bl_seq", getBlSeq());
		this.hashColumns.put("cmdt_hs_cd", getCmdtHsCd());
		this.hashColumns.put("bl_desc", getBlDesc());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bl_split_no", getBlSplitNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("bl_seq", "blSeq");
		this.hashFields.put("cmdt_hs_cd", "cmdtHsCd");
		this.hashFields.put("bl_desc", "blDesc");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("bl_split_no", "blSplitNo");
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
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
	 * @return blSeq
	 */
	public String getBlSeq() {
		return this.blSeq;
	}

	/**
	 * Column Info
	 * @return cmdtHsCd
	 */
	public String getCmdtHsCd() {
		return this.cmdtHsCd;
	}

	/**
	 * Column Info
	 * @return blDesc
	 */
	public String getBlDesc() {
		return this.blDesc;
	}

	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}

	/**
	 * Column Info
	 * @return blSplitNo
	 */
	public String getBlSplitNo() {
		return this.blSplitNo;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
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
	 * @param blSeq
	 */
	public void setBlSeq(String blSeq) {
		this.blSeq = blSeq;
	}

	/**
	 * Column Info
	 * @param cmdtHsCd
	 */
	public void setCmdtHsCd(String cmdtHsCd) {
		this.cmdtHsCd = cmdtHsCd;
	}

	/**
	 * Column Info
	 * @param blDesc
	 */
	public void setBlDesc(String blDesc) {
		this.blDesc = blDesc;
	}

	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	/**
	 * Column Info
	 * @param blSplitNo
	 */
	public void setBlSplitNo(String blSplitNo) {
		this.blSplitNo = blSplitNo;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setBlSeq(JSPUtil.getParameter(request, prefix + "bl_seq", ""));
		setCmdtHsCd(JSPUtil.getParameter(request, prefix + "cmdt_hs_cd", ""));
		setBlDesc(JSPUtil.getParameter(request, prefix + "bl_desc", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setBlSplitNo(JSPUtil.getParameter(request, prefix + "bl_split_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AdvJpMarkDescVO[]
	 */
	public AdvJpMarkDescVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AdvJpMarkDescVO[]
	 */
	public AdvJpMarkDescVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AdvJpMarkDescVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] blSeq = (JSPUtil.getParameter(request, prefix	+ "bl_seq", length));
			String[] cmdtHsCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_hs_cd", length));
			String[] blDesc = (JSPUtil.getParameter(request, prefix	+ "bl_desc", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] blSplitNo = (JSPUtil.getParameter(request, prefix	+ "bl_split_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new AdvJpMarkDescVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (blSeq[i] != null)
					model.setBlSeq(blSeq[i]);
				if (cmdtHsCd[i] != null)
					model.setCmdtHsCd(cmdtHsCd[i]);
				if (blDesc[i] != null)
					model.setBlDesc(blDesc[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (blSplitNo[i] != null)
					model.setBlSplitNo(blSplitNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAdvJpMarkDescVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AdvJpMarkDescVO[]
	 */
	public AdvJpMarkDescVO[] getAdvJpMarkDescVOs(){
		AdvJpMarkDescVO[] vos = (AdvJpMarkDescVO[])models.toArray(new AdvJpMarkDescVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSeq = this.blSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHsCd = this.cmdtHsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDesc = this.blDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSplitNo = this.blSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

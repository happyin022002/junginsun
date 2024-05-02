/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AutoCreItemVO.java
*@FileTitle : AutoCreItemVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier :
*@LastVersion : 1.0
* 2009.06.29
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AutoCreItemVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<AutoCreItemVO> models = new ArrayList<AutoCreItemVO>();

	/* Column Info */
	private String result = null;
	/* Column Info */
	private String asSts = null;
	/* Column Info */
	private String n1stMvmtFullFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String stsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String stsCd1 = null;
	/* Column Info */
	private String fmFlg = null;
	/* Column Info */
	private String stsCd2 = null;
	/* Column Info */
	private String auto = null;
	/* Column Info */
	private String autoMvmtStsSeq = null;
	/* Column Info */
	private String tar = null;
	/* Column Info */
	private String orgYd = null;
	/* Column Info */
	private String autoCreSeq = null;
	/* Column Info */
	private String fmFlg1 = null;
	/* Column Info */
	private String creUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public AutoCreItemVO() {}

	public AutoCreItemVO(String ibflag, String pagerows, String auto, String asSts, String tar, String result, String autoCreSeq, String n1stMvmtFullFlg, String autoMvmtStsSeq, String stsCd1, String stsCd2, String stsCd, String fmFlg1, String fmFlg, String orgYd, String creUsrId) {
		this.result = result;
		this.asSts = asSts;
		this.n1stMvmtFullFlg = n1stMvmtFullFlg;
		this.pagerows = pagerows;
		this.stsCd = stsCd;
		this.ibflag = ibflag;
		this.stsCd1 = stsCd1;
		this.fmFlg = fmFlg;
		this.stsCd2 = stsCd2;
		this.auto = auto;
		this.autoMvmtStsSeq = autoMvmtStsSeq;
		this.tar = tar;
		this.orgYd = orgYd;
		this.autoCreSeq = autoCreSeq;
		this.fmFlg1 = fmFlg1;
		this.creUsrId = creUsrId;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("result", getResult());
		this.hashColumns.put("as_sts", getAsSts());
		this.hashColumns.put("n1st_mvmt_full_flg", getN1stMvmtFullFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sts_cd", getStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sts_cd1", getStsCd1());
		this.hashColumns.put("fm_flg", getFmFlg());
		this.hashColumns.put("sts_cd2", getStsCd2());
		this.hashColumns.put("auto", getAuto());
		this.hashColumns.put("auto_mvmt_sts_seq", getAutoMvmtStsSeq());
		this.hashColumns.put("tar", getTar());
		this.hashColumns.put("org_yd", getOrgYd());
		this.hashColumns.put("auto_cre_seq", getAutoCreSeq());
		this.hashColumns.put("fm_flg1", getFmFlg1());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("result", "result");
		this.hashFields.put("as_sts", "asSts");
		this.hashFields.put("n1st_mvmt_full_flg", "n1stMvmtFullFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sts_cd", "stsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sts_cd1", "stsCd1");
		this.hashFields.put("fm_flg", "fmFlg");
		this.hashFields.put("sts_cd2", "stsCd2");
		this.hashFields.put("auto", "auto");
		this.hashFields.put("auto_mvmt_sts_seq", "autoMvmtStsSeq");
		this.hashFields.put("tar", "tar");
		this.hashFields.put("org_yd", "orgYd");
		this.hashFields.put("auto_cre_seq", "autoCreSeq");
		this.hashFields.put("fm_flg1", "fmFlg1");
		this.hashFields.put("cre_usr_id", "creUsrId");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return result
	 */
	public String getResult() {
		return this.result;
	}

	/**
	 * Column Info
	 * @return asSts
	 */
	public String getAsSts() {
		return this.asSts;
	}

	/**
	 * Column Info
	 * @return n1stMvmtFullFlg
	 */
	public String getN1stMvmtFullFlg() {
		return this.n1stMvmtFullFlg;
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
	 * @return stsCd
	 */
	public String getStsCd() {
		return this.stsCd;
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
	 * @return stsCd1
	 */
	public String getStsCd1() {
		return this.stsCd1;
	}

	/**
	 * Column Info
	 * @return fmFlg
	 */
	public String getFmFlg() {
		return this.fmFlg;
	}

	/**
	 * Column Info
	 * @return stsCd2
	 */
	public String getStsCd2() {
		return this.stsCd2;
	}

	/**
	 * Column Info
	 * @return auto
	 */
	public String getAuto() {
		return this.auto;
	}

	/**
	 * Column Info
	 * @return autoMvmtStsSeq
	 */
	public String getAutoMvmtStsSeq() {
		return this.autoMvmtStsSeq;
	}

	/**
	 * Column Info
	 * @return tar
	 */
	public String getTar() {
		return this.tar;
	}

	/**
	 * Column Info
	 * @return orgYd
	 */
	public String getOrgYd() {
		return this.orgYd;
	}

	/**
	 * Column Info
	 * @return autoCreSeq
	 */
	public String getAutoCreSeq() {
		return this.autoCreSeq;
	}

	/**
	 * Column Info
	 * @return fmFlg1
	 */
	public String getFmFlg1() {
		return this.fmFlg1;
	}

	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}


	/**
	 * Column Info
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * Column Info
	 * @param asSts
	 */
	public void setAsSts(String asSts) {
		this.asSts = asSts;
	}

	/**
	 * Column Info
	 * @param n1stMvmtFullFlg
	 */
	public void setN1stMvmtFullFlg(String n1stMvmtFullFlg) {
		this.n1stMvmtFullFlg = n1stMvmtFullFlg;
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
	 * @param stsCd
	 */
	public void setStsCd(String stsCd) {
		this.stsCd = stsCd;
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
	 * @param stsCd1
	 */
	public void setStsCd1(String stsCd1) {
		this.stsCd1 = stsCd1;
	}

	/**
	 * Column Info
	 * @param fmFlg
	 */
	public void setFmFlg(String fmFlg) {
		this.fmFlg = fmFlg;
	}

	/**
	 * Column Info
	 * @param stsCd2
	 */
	public void setStsCd2(String stsCd2) {
		this.stsCd2 = stsCd2;
	}

	/**
	 * Column Info
	 * @param auto
	 */
	public void setAuto(String auto) {
		this.auto = auto;
	}

	/**
	 * Column Info
	 * @param autoMvmtStsSeq
	 */
	public void setAutoMvmtStsSeq(String autoMvmtStsSeq) {
		this.autoMvmtStsSeq = autoMvmtStsSeq;
	}

	/**
	 * Column Info
	 * @param tar
	 */
	public void setTar(String tar) {
		this.tar = tar;
	}

	/**
	 * Column Info
	 * @param orgYd
	 */
	public void setOrgYd(String orgYd) {
		this.orgYd = orgYd;
	}

	/**
	 * Column Info
	 * @param autoCreSeq
	 */
	public void setAutoCreSeq(String autoCreSeq) {
		this.autoCreSeq = autoCreSeq;
	}

	/**
	 * Column Info
	 * @param fmFlg1
	 */
	public void setFmFlg1(String fmFlg1) {
		this.fmFlg1 = fmFlg1;
	}

	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setResult(JSPUtil.getParameter(request, "result", ""));
		setAsSts(JSPUtil.getParameter(request, "as_sts", ""));
		setN1stMvmtFullFlg(JSPUtil.getParameter(request, "n1st_mvmt_full_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setStsCd(JSPUtil.getParameter(request, "sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setStsCd1(JSPUtil.getParameter(request, "sts_cd1", ""));
		setFmFlg(JSPUtil.getParameter(request, "fm_flg", ""));
		setStsCd2(JSPUtil.getParameter(request, "sts_cd2", ""));
		setAuto(JSPUtil.getParameter(request, "auto", ""));
		setAutoMvmtStsSeq(JSPUtil.getParameter(request, "auto_mvmt_sts_seq", ""));
		setTar(JSPUtil.getParameter(request, "tar", ""));
		setOrgYd(JSPUtil.getParameter(request, "org_yd", ""));
		setAutoCreSeq(JSPUtil.getParameter(request, "auto_cre_seq", ""));
		setFmFlg1(JSPUtil.getParameter(request, "fm_flg1", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AutoCreItemVO[]
	 */
	public AutoCreItemVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AutoCreItemVO[]
	 */
	public AutoCreItemVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AutoCreItemVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] result = (JSPUtil.getParameter(request, prefix	+ "result", length));
			String[] asSts = (JSPUtil.getParameter(request, prefix	+ "as_sts", length));
			String[] n1stMvmtFullFlg = (JSPUtil.getParameter(request, prefix	+ "n1st_mvmt_full_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] stsCd = (JSPUtil.getParameter(request, prefix	+ "sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] stsCd1 = (JSPUtil.getParameter(request, prefix	+ "sts_cd1", length));
			String[] fmFlg = (JSPUtil.getParameter(request, prefix	+ "fm_flg", length));
			String[] stsCd2 = (JSPUtil.getParameter(request, prefix	+ "sts_cd2", length));
			String[] auto = (JSPUtil.getParameter(request, prefix	+ "auto", length));
			String[] autoMvmtStsSeq = (JSPUtil.getParameter(request, prefix	+ "auto_mvmt_sts_seq", length));
			String[] tar = (JSPUtil.getParameter(request, prefix	+ "tar", length));
			String[] orgYd = (JSPUtil.getParameter(request, prefix	+ "org_yd", length));
			String[] autoCreSeq = (JSPUtil.getParameter(request, prefix	+ "auto_cre_seq", length));
			String[] fmFlg1 = (JSPUtil.getParameter(request, prefix	+ "fm_flg1", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			for (int i = 0; i < length; i++) {
				model = new AutoCreItemVO();
				if (result[i] != null)
					model.setResult(result[i]);
				if (asSts[i] != null)
					model.setAsSts(asSts[i]);
				if (n1stMvmtFullFlg[i] != null)
					model.setN1stMvmtFullFlg(n1stMvmtFullFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (stsCd[i] != null)
					model.setStsCd(stsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (stsCd1[i] != null)
					model.setStsCd1(stsCd1[i]);
				if (fmFlg[i] != null)
					model.setFmFlg(fmFlg[i]);
				if (stsCd2[i] != null)
					model.setStsCd2(stsCd2[i]);
				if (auto[i] != null)
					model.setAuto(auto[i]);
				if (autoMvmtStsSeq[i] != null)
					model.setAutoMvmtStsSeq(autoMvmtStsSeq[i]);
				if (tar[i] != null)
					model.setTar(tar[i]);
				if (orgYd[i] != null)
					model.setOrgYd(orgYd[i]);
				if (autoCreSeq[i] != null)
					model.setAutoCreSeq(autoCreSeq[i]);
				if (fmFlg1[i] != null)
					model.setFmFlg1(fmFlg1[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAutoCreItemVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AutoCreItemVO[]
	 */
	public AutoCreItemVO[] getAutoCreItemVOs(){
		AutoCreItemVO[] vos = (AutoCreItemVO[])models.toArray(new AutoCreItemVO[models.size()]);
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
		this.result = this.result .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asSts = this.asSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stMvmtFullFlg = this.n1stMvmtFullFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsCd = this.stsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsCd1 = this.stsCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmFlg = this.fmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsCd2 = this.stsCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.auto = this.auto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoMvmtStsSeq = this.autoMvmtStsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tar = this.tar .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYd = this.orgYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoCreSeq = this.autoCreSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmFlg1 = this.fmFlg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

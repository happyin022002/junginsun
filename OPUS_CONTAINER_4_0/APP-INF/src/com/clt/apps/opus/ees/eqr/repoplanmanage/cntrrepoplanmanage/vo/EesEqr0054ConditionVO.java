/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0054ConditionVO.java
*@FileTitle : EesEqr0054ConditionVO
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1		1.0		Lee Byoung Hun				2009.09.09		1.0 최초 생성
*
*@LastModifyDate : 2009.09.09
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.09.09  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo;

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

public class EesEqr0054ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0054ConditionVO> models = new ArrayList<EesEqr0054ConditionVO>();
	
	/* Column Info */
	private String cntrtpszcd4 = null;
	/* Column Info */
	private String toplnwk4 = null;
	/* Column Info */
	private String scnrId = null;
	/* Column Info */
	private String term4 = null;
	/* Column Info */
	private String statusType = null;
	/* Column Info */
	private String toplnyr4 = null;
	/* Column Info */
	private String typeby4 = null;
	/* Column Info */
	private String fmplnyr4 = null;
	/* Column Info */
	private String tpszall = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String radiovol4 = null;
	/* Column Info */
	private String yyyyww = null;
	/* Column Info */
	private String repoPlnId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmplnwk4 = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String repoRmk = null;
	/* Column Info */
	private String ecccd4 = null;
	/* Column Info */
	private String type4 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0054ConditionVO() {}

	public EesEqr0054ConditionVO(String ibflag, String pagerows, String yyyyww, String seq, String statusType, String scnrId, String repoRmk, String repoPlnId, String tpszall, String type4, String ecccd4, String typeby4, String fmplnyr4, String fmplnwk4, String toplnyr4, String toplnwk4, String cntrtpszcd4, String term4, String radiovol4) {
		this.cntrtpszcd4 = cntrtpszcd4;
		this.toplnwk4 = toplnwk4;
		this.scnrId = scnrId;
		this.term4 = term4;
		this.statusType = statusType;
		this.toplnyr4 = toplnyr4;
		this.typeby4 = typeby4;
		this.fmplnyr4 = fmplnyr4;
		this.tpszall = tpszall;
		this.pagerows = pagerows;
		this.radiovol4 = radiovol4;
		this.yyyyww = yyyyww;
		this.repoPlnId = repoPlnId;
		this.ibflag = ibflag;
		this.fmplnwk4 = fmplnwk4;
		this.seq = seq;
		this.repoRmk = repoRmk;
		this.ecccd4 = ecccd4;
		this.type4 = type4;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntrtpszcd_4", getCntrtpszcd4());
		this.hashColumns.put("toplnwk_4", getToplnwk4());
		this.hashColumns.put("scnr_id", getScnrId());
		this.hashColumns.put("term_4", getTerm4());
		this.hashColumns.put("status_type", getStatusType());
		this.hashColumns.put("toplnyr_4", getToplnyr4());
		this.hashColumns.put("typeby_4", getTypeby4());
		this.hashColumns.put("fmplnyr_4", getFmplnyr4());
		this.hashColumns.put("tpszall", getTpszall());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("radiovol_4", getRadiovol4());
		this.hashColumns.put("yyyyww", getYyyyww());
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fmplnwk_4", getFmplnwk4());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("repo_rmk", getRepoRmk());
		this.hashColumns.put("ecccd_4", getEcccd4());
		this.hashColumns.put("type_4", getType4());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntrtpszcd_4", "cntrtpszcd4");
		this.hashFields.put("toplnwk_4", "toplnwk4");
		this.hashFields.put("scnr_id", "scnrId");
		this.hashFields.put("term_4", "term4");
		this.hashFields.put("status_type", "statusType");
		this.hashFields.put("toplnyr_4", "toplnyr4");
		this.hashFields.put("typeby_4", "typeby4");
		this.hashFields.put("fmplnyr_4", "fmplnyr4");
		this.hashFields.put("tpszall", "tpszall");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("radiovol_4", "radiovol4");
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fmplnwk_4", "fmplnwk4");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("repo_rmk", "repoRmk");
		this.hashFields.put("ecccd_4", "ecccd4");
		this.hashFields.put("type_4", "type4");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrtpszcd4
	 */
	public String getCntrtpszcd4() {
		return this.cntrtpszcd4;
	}
	
	/**
	 * Column Info
	 * @return toplnwk4
	 */
	public String getToplnwk4() {
		return this.toplnwk4;
	}
	
	/**
	 * Column Info
	 * @return scnrId
	 */
	public String getScnrId() {
		return this.scnrId;
	}
	
	/**
	 * Column Info
	 * @return term4
	 */
	public String getTerm4() {
		return this.term4;
	}
	
	/**
	 * Column Info
	 * @return statusType
	 */
	public String getStatusType() {
		return this.statusType;
	}
	
	/**
	 * Column Info
	 * @return toplnyr4
	 */
	public String getToplnyr4() {
		return this.toplnyr4;
	}
	
	/**
	 * Column Info
	 * @return typeby4
	 */
	public String getTypeby4() {
		return this.typeby4;
	}
	
	/**
	 * Column Info
	 * @return fmplnyr4
	 */
	public String getFmplnyr4() {
		return this.fmplnyr4;
	}
	
	/**
	 * Column Info
	 * @return tpszall
	 */
	public String getTpszall() {
		return this.tpszall;
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
	 * @return radiovol4
	 */
	public String getRadiovol4() {
		return this.radiovol4;
	}
	
	/**
	 * Column Info
	 * @return yyyyww
	 */
	public String getYyyyww() {
		return this.yyyyww;
	}
	
	/**
	 * Column Info
	 * @return repoPlnId
	 */
	public String getRepoPlnId() {
		return this.repoPlnId;
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
	 * @return fmplnwk4
	 */
	public String getFmplnwk4() {
		return this.fmplnwk4;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return repoRmk
	 */
	public String getRepoRmk() {
		return this.repoRmk;
	}
	
	/**
	 * Column Info
	 * @return ecccd4
	 */
	public String getEcccd4() {
		return this.ecccd4;
	}
	
	/**
	 * Column Info
	 * @return type4
	 */
	public String getType4() {
		return this.type4;
	}
	

	/**
	 * Column Info
	 * @param cntrtpszcd4
	 */
	public void setCntrtpszcd4(String cntrtpszcd4) {
		this.cntrtpszcd4 = cntrtpszcd4;
	}
	
	/**
	 * Column Info
	 * @param toplnwk4
	 */
	public void setToplnwk4(String toplnwk4) {
		this.toplnwk4 = toplnwk4;
	}
	
	/**
	 * Column Info
	 * @param scnrId
	 */
	public void setScnrId(String scnrId) {
		this.scnrId = scnrId;
	}
	
	/**
	 * Column Info
	 * @param term4
	 */
	public void setTerm4(String term4) {
		this.term4 = term4;
	}
	
	/**
	 * Column Info
	 * @param statusType
	 */
	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}
	
	/**
	 * Column Info
	 * @param toplnyr4
	 */
	public void setToplnyr4(String toplnyr4) {
		this.toplnyr4 = toplnyr4;
	}
	
	/**
	 * Column Info
	 * @param typeby4
	 */
	public void setTypeby4(String typeby4) {
		this.typeby4 = typeby4;
	}
	
	/**
	 * Column Info
	 * @param fmplnyr4
	 */
	public void setFmplnyr4(String fmplnyr4) {
		this.fmplnyr4 = fmplnyr4;
	}
	
	/**
	 * Column Info
	 * @param tpszall
	 */
	public void setTpszall(String tpszall) {
		this.tpszall = tpszall;
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
	 * @param radiovol4
	 */
	public void setRadiovol4(String radiovol4) {
		this.radiovol4 = radiovol4;
	}
	
	/**
	 * Column Info
	 * @param yyyyww
	 */
	public void setYyyyww(String yyyyww) {
		this.yyyyww = yyyyww;
	}
	
	/**
	 * Column Info
	 * @param repoPlnId
	 */
	public void setRepoPlnId(String repoPlnId) {
		this.repoPlnId = repoPlnId;
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
	 * @param fmplnwk4
	 */
	public void setFmplnwk4(String fmplnwk4) {
		this.fmplnwk4 = fmplnwk4;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param repoRmk
	 */
	public void setRepoRmk(String repoRmk) {
		this.repoRmk = repoRmk;
	}
	
	/**
	 * Column Info
	 * @param ecccd4
	 */
	public void setEcccd4(String ecccd4) {
		this.ecccd4 = ecccd4;
	}
	
	/**
	 * Column Info
	 * @param type4
	 */
	public void setType4(String type4) {
		this.type4 = type4;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCntrtpszcd4(JSPUtil.getParameter(request, "cntrTpszCd_4", ""));
		setToplnwk4(JSPUtil.getParameter(request, "toPlnWk_4", ""));
		setScnrId(JSPUtil.getParameter(request, "scnr_id", ""));
		setTerm4(JSPUtil.getParameter(request, "term_4", ""));
		setStatusType(JSPUtil.getParameter(request, "status_type", ""));
		setToplnyr4(JSPUtil.getParameter(request, "toPlnYr_4", ""));
		setTypeby4(JSPUtil.getParameter(request, "typeBy_4", ""));
		setFmplnyr4(JSPUtil.getParameter(request, "fmPlnYr_4", ""));
		setTpszall(JSPUtil.getParameter(request, "tpszall", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRadiovol4(JSPUtil.getParameter(request, "radioVol_4", ""));
		setYyyyww(JSPUtil.getParameter(request, "yyyyww", ""));
		setRepoPlnId(JSPUtil.getParameter(request, "repo_pln_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFmplnwk4(JSPUtil.getParameter(request, "fmPlnWk_4", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setRepoRmk(JSPUtil.getParameter(request, "repo_rmk", ""));
		setEcccd4(JSPUtil.getParameter(request, "eccCd_4", ""));
		setType4(JSPUtil.getParameter(request, "type_4", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0054ConditionVO[]
	 */
	public EesEqr0054ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0054ConditionVO[]
	 */
	public EesEqr0054ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0054ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrtpszcd4 = (JSPUtil.getParameter(request, prefix	+ "cntrtpszcd_4", length));
			String[] toplnwk4 = (JSPUtil.getParameter(request, prefix	+ "toplnwk_4", length));
			String[] scnrId = (JSPUtil.getParameter(request, prefix	+ "scnr_id", length));
			String[] term4 = (JSPUtil.getParameter(request, prefix	+ "term_4", length));
			String[] statusType = (JSPUtil.getParameter(request, prefix	+ "status_type", length));
			String[] toplnyr4 = (JSPUtil.getParameter(request, prefix	+ "toplnyr_4", length));
			String[] typeby4 = (JSPUtil.getParameter(request, prefix	+ "typeby_4", length));
			String[] fmplnyr4 = (JSPUtil.getParameter(request, prefix	+ "fmplnyr_4", length));
			String[] tpszall = (JSPUtil.getParameter(request, prefix	+ "tpszall", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] radiovol4 = (JSPUtil.getParameter(request, prefix	+ "radiovol_4", length));
			String[] yyyyww = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix	+ "repo_pln_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmplnwk4 = (JSPUtil.getParameter(request, prefix	+ "fmplnwk_4", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] repoRmk = (JSPUtil.getParameter(request, prefix	+ "repo_rmk", length));
			String[] ecccd4 = (JSPUtil.getParameter(request, prefix	+ "ecccd_4", length));
			String[] type4 = (JSPUtil.getParameter(request, prefix	+ "type_4", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0054ConditionVO();
				if (cntrtpszcd4[i] != null)
					model.setCntrtpszcd4(cntrtpszcd4[i]);
				if (toplnwk4[i] != null)
					model.setToplnwk4(toplnwk4[i]);
				if (scnrId[i] != null)
					model.setScnrId(scnrId[i]);
				if (term4[i] != null)
					model.setTerm4(term4[i]);
				if (statusType[i] != null)
					model.setStatusType(statusType[i]);
				if (toplnyr4[i] != null)
					model.setToplnyr4(toplnyr4[i]);
				if (typeby4[i] != null)
					model.setTypeby4(typeby4[i]);
				if (fmplnyr4[i] != null)
					model.setFmplnyr4(fmplnyr4[i]);
				if (tpszall[i] != null)
					model.setTpszall(tpszall[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (radiovol4[i] != null)
					model.setRadiovol4(radiovol4[i]);
				if (yyyyww[i] != null)
					model.setYyyyww(yyyyww[i]);
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmplnwk4[i] != null)
					model.setFmplnwk4(fmplnwk4[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (repoRmk[i] != null)
					model.setRepoRmk(repoRmk[i]);
				if (ecccd4[i] != null)
					model.setEcccd4(ecccd4[i]);
				if (type4[i] != null)
					model.setType4(type4[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0054ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0054ConditionVO[]
	 */
	public EesEqr0054ConditionVO[] getEesEqr0054ConditionVOs(){
		EesEqr0054ConditionVO[] vos = (EesEqr0054ConditionVO[])models.toArray(new EesEqr0054ConditionVO[models.size()]);
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
		this.cntrtpszcd4 = this.cntrtpszcd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toplnwk4 = this.toplnwk4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrId = this.scnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.term4 = this.term4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.statusType = this.statusType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toplnyr4 = this.toplnyr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeby4 = this.typeby4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmplnyr4 = this.fmplnyr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszall = this.tpszall .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.radiovol4 = this.radiovol4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww = this.yyyyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId = this.repoPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmplnwk4 = this.fmplnwk4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoRmk = this.repoRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ecccd4 = this.ecccd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type4 = this.type4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

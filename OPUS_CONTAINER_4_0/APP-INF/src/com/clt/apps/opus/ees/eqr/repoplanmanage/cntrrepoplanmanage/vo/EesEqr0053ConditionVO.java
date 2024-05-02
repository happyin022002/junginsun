/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0053ConditionVO.java
*@FileTitle : EesEqr0053ConditionVO
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1		1.0		Lee Byoung Hun				2009.09.07		1.0 최초 생성
*
*@LastModifyDate : 2009.09.07
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.09.07  
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

public class EesEqr0053ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0053ConditionVO> models = new ArrayList<EesEqr0053ConditionVO>();
	
	/* Column Info */
	private String cntrtsCd = null;
	/* Column Info */
	private String cntrtpszcd3 = null;
	/* Column Info */
	private String toplnyr3 = null;
	/* Column Info */
	private String toplnwk3 = null;
	/* Column Info */
	private String scnrId = null;
	/* Column Info */
	private String statusType = null;
	/* Column Info */
	private String typeby3 = null;
	/* Column Info */
	private String term3 = null;
	/* Column Info */
	private String tpszall = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String yyyyww = null;
	/* Column Info */
	private String repoPlnId = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmplnyr3 = null;
	/* Column Info */
	private String radiovol3 = null;
	/* Column Info */
	private String fmplnwk3 = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String type3 = null;
	/* Column Info */
	private String repoRmk = null;
	/* Column Info */
	private String ecccd3 = null;
	/* Column Info */
	private String week = null;
	/* Column Info */
	private String sheetFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0053ConditionVO() {}

	public EesEqr0053ConditionVO(String ibflag, String pagerows, String yyyyww, String seq, String statusType, String scnrId, String repoRmk, String repoPlnId, String tpszall, String type3, String ecccd3, String typeby3, String fmplnyr3, String fmplnwk3, String toplnyr3, String toplnwk3, String cntrtpszcd3, String term3, String radiovol3, String locCd, String week, String cntrtsCd) {
		this.cntrtsCd = cntrtsCd;
		this.cntrtpszcd3 = cntrtpszcd3;
		this.toplnyr3 = toplnyr3;
		this.toplnwk3 = toplnwk3;
		this.scnrId = scnrId;
		this.statusType = statusType;
		this.typeby3 = typeby3;
		this.term3 = term3;
		this.tpszall = tpszall;
		this.pagerows = pagerows;
		this.yyyyww = yyyyww;
		this.repoPlnId = repoPlnId;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.fmplnyr3 = fmplnyr3;
		this.radiovol3 = radiovol3;
		this.fmplnwk3 = fmplnwk3;
		this.seq = seq;
		this.type3 = type3;
		this.repoRmk = repoRmk;
		this.ecccd3 = ecccd3;
		this.week = week;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntrts_cd", getCntrtsCd());
		this.hashColumns.put("cntrtpszcd_3", getCntrtpszcd3());
		this.hashColumns.put("toplnyr_3", getToplnyr3());
		this.hashColumns.put("toplnwk_3", getToplnwk3());
		this.hashColumns.put("scnr_id", getScnrId());
		this.hashColumns.put("status_type", getStatusType());
		this.hashColumns.put("typeby_3", getTypeby3());
		this.hashColumns.put("term_3", getTerm3());
		this.hashColumns.put("tpszall", getTpszall());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("yyyyww", getYyyyww());
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fmplnyr_3", getFmplnyr3());
		this.hashColumns.put("radiovol_3", getRadiovol3());
		this.hashColumns.put("fmplnwk_3", getFmplnwk3());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("type_3", getType3());
		this.hashColumns.put("repo_rmk", getRepoRmk());
		this.hashColumns.put("ecccd_3", getEcccd3());
		this.hashColumns.put("week", getWeek());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntrts_cd", "cntrtsCd");
		this.hashFields.put("cntrtpszcd_3", "cntrtpszcd3");
		this.hashFields.put("toplnyr_3", "toplnyr3");
		this.hashFields.put("toplnwk_3", "toplnwk3");
		this.hashFields.put("scnr_id", "scnrId");
		this.hashFields.put("status_type", "statusType");
		this.hashFields.put("typeby_3", "typeby3");
		this.hashFields.put("term_3", "term3");
		this.hashFields.put("tpszall", "tpszall");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fmplnyr_3", "fmplnyr3");
		this.hashFields.put("radiovol_3", "radiovol3");
		this.hashFields.put("fmplnwk_3", "fmplnwk3");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("type_3", "type3");
		this.hashFields.put("repo_rmk", "repoRmk");
		this.hashFields.put("ecccd_3", "ecccd3");
		this.hashFields.put("week", "week");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrtsCd
	 */
	public String getCntrtsCd() {
		return this.cntrtsCd;
	}
	
	/**
	 * Column Info
	 * @return cntrtpszcd3
	 */
	public String getCntrtpszcd3() {
		return this.cntrtpszcd3;
	}
	
	/**
	 * Column Info
	 * @return toplnyr3
	 */
	public String getToplnyr3() {
		return this.toplnyr3;
	}
	
	/**
	 * Column Info
	 * @return toplnwk3
	 */
	public String getToplnwk3() {
		return this.toplnwk3;
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
	 * @return statusType
	 */
	public String getStatusType() {
		return this.statusType;
	}
	
	/**
	 * Column Info
	 * @return typeby3
	 */
	public String getTypeby3() {
		return this.typeby3;
	}
	
	/**
	 * Column Info
	 * @return term3
	 */
	public String getTerm3() {
		return this.term3;
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
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return fmplnyr3
	 */
	public String getFmplnyr3() {
		return this.fmplnyr3;
	}
	
	/**
	 * Column Info
	 * @return radiovol3
	 */
	public String getRadiovol3() {
		return this.radiovol3;
	}
	
	/**
	 * Column Info
	 * @return fmplnwk3
	 */
	public String getFmplnwk3() {
		return this.fmplnwk3;
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
	 * @return type3
	 */
	public String getType3() {
		return this.type3;
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
	 * @return ecccd3
	 */
	public String getEcccd3() {
		return this.ecccd3;
	}
	
	/**
	 * Column Info
	 * @return week
	 */
	public String getWeek() {
		return this.week;
	}
	

	/**
	 * Column Info
	 * @param cntrtsCd
	 */
	public void setCntrtsCd(String cntrtsCd) {
		this.cntrtsCd = cntrtsCd;
	}
	
	/**
	 * Column Info
	 * @param cntrtpszcd3
	 */
	public void setCntrtpszcd3(String cntrtpszcd3) {
		this.cntrtpszcd3 = cntrtpszcd3;
	}
	
	/**
	 * Column Info
	 * @param toplnyr3
	 */
	public void setToplnyr3(String toplnyr3) {
		this.toplnyr3 = toplnyr3;
	}
	
	/**
	 * Column Info
	 * @param toplnwk3
	 */
	public void setToplnwk3(String toplnwk3) {
		this.toplnwk3 = toplnwk3;
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
	 * @param statusType
	 */
	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}
	
	/**
	 * Column Info
	 * @param typeby3
	 */
	public void setTypeby3(String typeby3) {
		this.typeby3 = typeby3;
	}
	
	/**
	 * Column Info
	 * @param term3
	 */
	public void setTerm3(String term3) {
		this.term3 = term3;
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
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param fmplnyr3
	 */
	public void setFmplnyr3(String fmplnyr3) {
		this.fmplnyr3 = fmplnyr3;
	}
	
	/**
	 * Column Info
	 * @param radiovol3
	 */
	public void setRadiovol3(String radiovol3) {
		this.radiovol3 = radiovol3;
	}
	
	/**
	 * Column Info
	 * @param fmplnwk3
	 */
	public void setFmplnwk3(String fmplnwk3) {
		this.fmplnwk3 = fmplnwk3;
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
	 * @param type3
	 */
	public void setType3(String type3) {
		this.type3 = type3;
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
	 * @param ecccd3
	 */
	public void setEcccd3(String ecccd3) {
		this.ecccd3 = ecccd3;
	}
	
	/**
	 * Column Info
	 * @param week
	 */
	public void setWeek(String week) {
		this.week = week;
	}
	

	/**
	 * @return the sheetFlg
	 */
	public String getSheetFlg() {
		return sheetFlg;
	}

	/**
	 * @param sheetFlg the sheetFlg to set
	 */
	public void setSheetFlg(String sheetFlg) {
		this.sheetFlg = sheetFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCntrtsCd(JSPUtil.getParameter(request, "cntrts_cd", ""));
		setCntrtpszcd3(JSPUtil.getParameter(request, "cntrTpszCd_3", ""));
		setToplnyr3(JSPUtil.getParameter(request, "toPlnYr_3", ""));
		setToplnwk3(JSPUtil.getParameter(request, "toPlnWk_3", ""));
		setScnrId(JSPUtil.getParameter(request, "scnr_id", ""));
		setStatusType(JSPUtil.getParameter(request, "status_type", ""));
		setTypeby3(JSPUtil.getParameter(request, "typeBy_3", ""));
		setTerm3(JSPUtil.getParameter(request, "term_3", ""));
		setTpszall(JSPUtil.getParameter(request, "tpszall", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setYyyyww(JSPUtil.getParameter(request, "yyyyww", ""));
		setRepoPlnId(JSPUtil.getParameter(request, "repo_pln_id", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFmplnyr3(JSPUtil.getParameter(request, "fmPlnYr_3", ""));
		setRadiovol3(JSPUtil.getParameter(request, "radioVol_3", ""));
		setFmplnwk3(JSPUtil.getParameter(request, "fmPlnWk_3", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setType3(JSPUtil.getParameter(request, "type_3", ""));
		setRepoRmk(JSPUtil.getParameter(request, "repo_rmk", ""));
		setEcccd3(JSPUtil.getParameter(request, "eccCd_3", ""));
		setWeek(JSPUtil.getParameter(request, "week", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0053ConditionVO[]
	 */
	public EesEqr0053ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0053ConditionVO[]
	 */
	public EesEqr0053ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0053ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrtsCd = (JSPUtil.getParameter(request, prefix	+ "cntrts_cd", length));
			String[] cntrtpszcd3 = (JSPUtil.getParameter(request, prefix	+ "cntrtpszcd_3", length));
			String[] toplnyr3 = (JSPUtil.getParameter(request, prefix	+ "toplnyr_3", length));
			String[] toplnwk3 = (JSPUtil.getParameter(request, prefix	+ "toplnwk_3", length));
			String[] scnrId = (JSPUtil.getParameter(request, prefix	+ "scnr_id", length));
			String[] statusType = (JSPUtil.getParameter(request, prefix	+ "status_type", length));
			String[] typeby3 = (JSPUtil.getParameter(request, prefix	+ "typeby_3", length));
			String[] term3 = (JSPUtil.getParameter(request, prefix	+ "term_3", length));
			String[] tpszall = (JSPUtil.getParameter(request, prefix	+ "tpszall", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] yyyyww = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix	+ "repo_pln_id", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmplnyr3 = (JSPUtil.getParameter(request, prefix	+ "fmplnyr_3", length));
			String[] radiovol3 = (JSPUtil.getParameter(request, prefix	+ "radiovol_3", length));
			String[] fmplnwk3 = (JSPUtil.getParameter(request, prefix	+ "fmplnwk_3", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] type3 = (JSPUtil.getParameter(request, prefix	+ "type_3", length));
			String[] repoRmk = (JSPUtil.getParameter(request, prefix	+ "repo_rmk", length));
			String[] ecccd3 = (JSPUtil.getParameter(request, prefix	+ "ecccd_3", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0053ConditionVO();
				if (cntrtsCd[i] != null)
					model.setCntrtsCd(cntrtsCd[i]);
				if (cntrtpszcd3[i] != null)
					model.setCntrtpszcd3(cntrtpszcd3[i]);
				if (toplnyr3[i] != null)
					model.setToplnyr3(toplnyr3[i]);
				if (toplnwk3[i] != null)
					model.setToplnwk3(toplnwk3[i]);
				if (scnrId[i] != null)
					model.setScnrId(scnrId[i]);
				if (statusType[i] != null)
					model.setStatusType(statusType[i]);
				if (typeby3[i] != null)
					model.setTypeby3(typeby3[i]);
				if (term3[i] != null)
					model.setTerm3(term3[i]);
				if (tpszall[i] != null)
					model.setTpszall(tpszall[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (yyyyww[i] != null)
					model.setYyyyww(yyyyww[i]);
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmplnyr3[i] != null)
					model.setFmplnyr3(fmplnyr3[i]);
				if (radiovol3[i] != null)
					model.setRadiovol3(radiovol3[i]);
				if (fmplnwk3[i] != null)
					model.setFmplnwk3(fmplnwk3[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (type3[i] != null)
					model.setType3(type3[i]);
				if (repoRmk[i] != null)
					model.setRepoRmk(repoRmk[i]);
				if (ecccd3[i] != null)
					model.setEcccd3(ecccd3[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0053ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0053ConditionVO[]
	 */
	public EesEqr0053ConditionVO[] getEesEqr0053ConditionVOs(){
		EesEqr0053ConditionVO[] vos = (EesEqr0053ConditionVO[])models.toArray(new EesEqr0053ConditionVO[models.size()]);
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
		this.cntrtsCd = this.cntrtsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtpszcd3 = this.cntrtpszcd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toplnyr3 = this.toplnyr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toplnwk3 = this.toplnwk3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrId = this.scnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.statusType = this.statusType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeby3 = this.typeby3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.term3 = this.term3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszall = this.tpszall .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww = this.yyyyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId = this.repoPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmplnyr3 = this.fmplnyr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.radiovol3 = this.radiovol3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmplnwk3 = this.fmplnwk3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type3 = this.type3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoRmk = this.repoRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ecccd3 = this.ecccd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

}

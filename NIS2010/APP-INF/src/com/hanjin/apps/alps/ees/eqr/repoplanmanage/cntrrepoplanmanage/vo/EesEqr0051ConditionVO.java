/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0051ConditionVO.java
*@FileTitle : EesEqr0051ConditionVO
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Lee Byoung Hun	2009.08.17		1.0 최초 생성
*
*@LastModifyDate : 2009.08.17
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.08.17  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0051ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0051ConditionVO> models = new ArrayList<EesEqr0051ConditionVO>();
	
	/* Column Info */
	private String item1 = null;
	/* Column Info */
	private String cntrtpszcd1 = null;
	/* Column Info */
	private String toplnyr1 = null;
	/* Column Info */
	private String typeby1 = null;
	/* Column Info */
	private String scnrId = null;
	/* Column Info */
	private String statusType = null;
	/* Column Info */
	private String inclexecplan1 = null;
	/* Column Info */
	private String toplnwk1 = null;
	/* Column Info */
	private String type = null;
	/* Column Info */
	private String tpszall = null;
	/* Column Info */
	private String vvd1 = null;
	/* Column Info */
	private String lane1 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String yyyyww = null;
	/* Column Info */
	private String repoPlnId = null;
	/* Column Info */
	private String fmplnwk1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String yyyywwold = null;
	/* Column Info */
	private String type1 = null;
	/* Column Info */
	private String fmplnyr1 = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String repoRmk = null;
	/* Column Info */
	private String ecccd1 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0051ConditionVO() {}

	public EesEqr0051ConditionVO(String ibflag, String pagerows, String type, String yyyyww, String yyyywwold, String seq, String statusType, String scnrId, String repoRmk, String repoPlnId, String tpszall, String type1, String ecccd1, String typeby1, String fmplnyr1, String fmplnwk1, String toplnyr1, String toplnwk1, String cntrtpszcd1, String item1, String lane1, String vvd1, String inclexecplan1) {
		this.item1 = item1;
		this.cntrtpszcd1 = cntrtpszcd1;
		this.toplnyr1 = toplnyr1;
		this.typeby1 = typeby1;
		this.scnrId = scnrId;
		this.statusType = statusType;
		this.inclexecplan1 = inclexecplan1;
		this.toplnwk1 = toplnwk1;
		this.type = type;
		this.tpszall = tpszall;
		this.vvd1 = vvd1;
		this.lane1 = lane1;
		this.pagerows = pagerows;
		this.yyyyww = yyyyww;
		this.repoPlnId = repoPlnId;
		this.fmplnwk1 = fmplnwk1;
		this.ibflag = ibflag;
		this.yyyywwold = yyyywwold;
		this.type1 = type1;
		this.fmplnyr1 = fmplnyr1;
		this.seq = seq;
		this.repoRmk = repoRmk;
		this.ecccd1 = ecccd1;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("item_1", getItem1());
		this.hashColumns.put("cntrtpszcd_1", getCntrtpszcd1());
		this.hashColumns.put("toplnyr_1", getToplnyr1());
		this.hashColumns.put("typeby_1", getTypeby1());
		this.hashColumns.put("scnr_id", getScnrId());
		this.hashColumns.put("status_type", getStatusType());
		this.hashColumns.put("inclexecplan_1", getInclexecplan1());
		this.hashColumns.put("toplnwk_1", getToplnwk1());
		this.hashColumns.put("type", getType());
		this.hashColumns.put("tpszall", getTpszall());
		this.hashColumns.put("vvd_1", getVvd1());
		this.hashColumns.put("lane_1", getLane1());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("yyyyww", getYyyyww());
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("fmplnwk_1", getFmplnwk1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yyyywwold", getYyyywwold());
		this.hashColumns.put("type_1", getType1());
		this.hashColumns.put("fmplnyr_1", getFmplnyr1());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("repo_rmk", getRepoRmk());
		this.hashColumns.put("ecccd_1", getEcccd1());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("item_1", "item1");
		this.hashFields.put("cntrtpszcd_1", "cntrtpszcd1");
		this.hashFields.put("toplnyr_1", "toplnyr1");
		this.hashFields.put("typeby_1", "typeby1");
		this.hashFields.put("scnr_id", "scnrId");
		this.hashFields.put("status_type", "statusType");
		this.hashFields.put("inclexecplan_1", "inclexecplan1");
		this.hashFields.put("toplnwk_1", "toplnwk1");
		this.hashFields.put("type", "type");
		this.hashFields.put("tpszall", "tpszall");
		this.hashFields.put("vvd_1", "vvd1");
		this.hashFields.put("lane_1", "lane1");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("fmplnwk_1", "fmplnwk1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yyyywwold", "yyyywwold");
		this.hashFields.put("type_1", "type1");
		this.hashFields.put("fmplnyr_1", "fmplnyr1");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("repo_rmk", "repoRmk");
		this.hashFields.put("ecccd_1", "ecccd1");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return item1
	 */
	public String getItem1() {
		return this.item1;
	}
	
	/**
	 * Column Info
	 * @return cntrtpszcd1
	 */
	public String getCntrtpszcd1() {
		return this.cntrtpszcd1;
	}
	
	/**
	 * Column Info
	 * @return toplnyr1
	 */
	public String getToplnyr1() {
		return this.toplnyr1;
	}
	
	/**
	 * Column Info
	 * @return typeby1
	 */
	public String getTypeby1() {
		return this.typeby1;
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
	 * @return inclexecplan1
	 */
	public String getInclexecplan1() {
		return this.inclexecplan1;
	}
	
	/**
	 * Column Info
	 * @return toplnwk1
	 */
	public String getToplnwk1() {
		return this.toplnwk1;
	}
	
	/**
	 * Column Info
	 * @return type
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Column Info
	 * @return tpszall
	 */
	public String getTpszall() {
		return this.tpszall;
	}
	
	/**
	 * Column Info
	 * @return vvd1
	 */
	public String getVvd1() {
		return this.vvd1;
	}
	
	/**
	 * Column Info
	 * @return lane1
	 */
	public String getLane1() {
		return this.lane1;
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
	 * @return fmplnwk1
	 */
	public String getFmplnwk1() {
		return this.fmplnwk1;
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
	 * @return yyyywwold
	 */
	public String getYyyywwold() {
		return this.yyyywwold;
	}
	
	/**
	 * Column Info
	 * @return type1
	 */
	public String getType1() {
		return this.type1;
	}
	
	/**
	 * Column Info
	 * @return fmplnyr1
	 */
	public String getFmplnyr1() {
		return this.fmplnyr1;
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
	 * @return ecccd1
	 */
	public String getEcccd1() {
		return this.ecccd1;
	}
	

	/**
	 * Column Info
	 * @param item1
	 */
	public void setItem1(String item1) {
		this.item1 = item1;
	}
	
	/**
	 * Column Info
	 * @param cntrtpszcd1
	 */
	public void setCntrtpszcd1(String cntrtpszcd1) {
		this.cntrtpszcd1 = cntrtpszcd1;
	}
	
	/**
	 * Column Info
	 * @param toplnyr1
	 */
	public void setToplnyr1(String toplnyr1) {
		this.toplnyr1 = toplnyr1;
	}
	
	/**
	 * Column Info
	 * @param typeby1
	 */
	public void setTypeby1(String typeby1) {
		this.typeby1 = typeby1;
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
	 * @param inclexecplan1
	 */
	public void setInclexecplan1(String inclexecplan1) {
		this.inclexecplan1 = inclexecplan1;
	}
	
	/**
	 * Column Info
	 * @param toplnwk1
	 */
	public void setToplnwk1(String toplnwk1) {
		this.toplnwk1 = toplnwk1;
	}
	
	/**
	 * Column Info
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Column Info
	 * @param tpszall
	 */
	public void setTpszall(String tpszall) {
		this.tpszall = tpszall;
	}
	
	/**
	 * Column Info
	 * @param vvd1
	 */
	public void setVvd1(String vvd1) {
		this.vvd1 = vvd1;
	}
	
	/**
	 * Column Info
	 * @param lane1
	 */
	public void setLane1(String lane1) {
		this.lane1 = lane1;
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
	 * @param fmplnwk1
	 */
	public void setFmplnwk1(String fmplnwk1) {
		this.fmplnwk1 = fmplnwk1;
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
	 * @param yyyywwold
	 */
	public void setYyyywwold(String yyyywwold) {
		this.yyyywwold = yyyywwold;
	}
	
	/**
	 * Column Info
	 * @param type1
	 */
	public void setType1(String type1) {
		this.type1 = type1;
	}
	
	/**
	 * Column Info
	 * @param fmplnyr1
	 */
	public void setFmplnyr1(String fmplnyr1) {
		this.fmplnyr1 = fmplnyr1;
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
	 * @param ecccd1
	 */
	public void setEcccd1(String ecccd1) {
		this.ecccd1 = ecccd1;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setItem1(JSPUtil.getParameter(request, "item_1", ""));
		setCntrtpszcd1(JSPUtil.getParameter(request, "cntrTpszCd_1", ""));
		setToplnyr1(JSPUtil.getParameter(request, "toPlnYr_1", ""));
		setTypeby1(JSPUtil.getParameter(request, "typeBy_1", ""));
		setScnrId(JSPUtil.getParameter(request, "scnr_id", ""));
		setStatusType(JSPUtil.getParameter(request, "status_type", ""));
		setInclexecplan1(JSPUtil.getParameter(request, "inclExecPlan_1", ""));
		setToplnwk1(JSPUtil.getParameter(request, "toPlnWk_1", ""));
		setType(JSPUtil.getParameter(request, "type", ""));
		setTpszall(JSPUtil.getParameter(request, "tpszall", ""));
		setVvd1(JSPUtil.getParameter(request, "vvd_1", ""));
		setLane1(JSPUtil.getParameter(request, "lane_1", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setYyyyww(JSPUtil.getParameter(request, "yyyyww", ""));
		setRepoPlnId(JSPUtil.getParameter(request, "repo_pln_id", ""));
		setFmplnwk1(JSPUtil.getParameter(request, "fmPlnWk_1", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setYyyywwold(JSPUtil.getParameter(request, "yyyywwOld", ""));
		setType1(JSPUtil.getParameter(request, "type_1", ""));
		setFmplnyr1(JSPUtil.getParameter(request, "fmPlnYr_1", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setRepoRmk(JSPUtil.getParameter(request, "repo_rmk", ""));
		setEcccd1(JSPUtil.getParameter(request, "eccCd_1", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0051ConditionVO[]
	 */
	public EesEqr0051ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0051ConditionVO[]
	 */
	public EesEqr0051ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0051ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] item1 = (JSPUtil.getParameter(request, prefix	+ "item_1", length));
			String[] cntrtpszcd1 = (JSPUtil.getParameter(request, prefix	+ "cntrtpszcd_1", length));
			String[] toplnyr1 = (JSPUtil.getParameter(request, prefix	+ "toplnyr_1", length));
			String[] typeby1 = (JSPUtil.getParameter(request, prefix	+ "typeby_1", length));
			String[] scnrId = (JSPUtil.getParameter(request, prefix	+ "scnr_id", length));
			String[] statusType = (JSPUtil.getParameter(request, prefix	+ "status_type", length));
			String[] inclexecplan1 = (JSPUtil.getParameter(request, prefix	+ "inclexecplan_1", length));
			String[] toplnwk1 = (JSPUtil.getParameter(request, prefix	+ "toplnwk_1", length));
			String[] type = (JSPUtil.getParameter(request, prefix	+ "type", length));
			String[] tpszall = (JSPUtil.getParameter(request, prefix	+ "tpszall", length));
			String[] vvd1 = (JSPUtil.getParameter(request, prefix	+ "vvd_1", length));
			String[] lane1 = (JSPUtil.getParameter(request, prefix	+ "lane_1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] yyyyww = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix	+ "repo_pln_id", length));
			String[] fmplnwk1 = (JSPUtil.getParameter(request, prefix	+ "fmplnwk_1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] yyyywwold = (JSPUtil.getParameter(request, prefix	+ "yyyywwold", length));
			String[] type1 = (JSPUtil.getParameter(request, prefix	+ "type_1", length));
			String[] fmplnyr1 = (JSPUtil.getParameter(request, prefix	+ "fmplnyr_1", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] repoRmk = (JSPUtil.getParameter(request, prefix	+ "repo_rmk", length));
			String[] ecccd1 = (JSPUtil.getParameter(request, prefix	+ "ecccd_1", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0051ConditionVO();
				if (item1[i] != null)
					model.setItem1(item1[i]);
				if (cntrtpszcd1[i] != null)
					model.setCntrtpszcd1(cntrtpszcd1[i]);
				if (toplnyr1[i] != null)
					model.setToplnyr1(toplnyr1[i]);
				if (typeby1[i] != null)
					model.setTypeby1(typeby1[i]);
				if (scnrId[i] != null)
					model.setScnrId(scnrId[i]);
				if (statusType[i] != null)
					model.setStatusType(statusType[i]);
				if (inclexecplan1[i] != null)
					model.setInclexecplan1(inclexecplan1[i]);
				if (toplnwk1[i] != null)
					model.setToplnwk1(toplnwk1[i]);
				if (type[i] != null)
					model.setType(type[i]);
				if (tpszall[i] != null)
					model.setTpszall(tpszall[i]);
				if (vvd1[i] != null)
					model.setVvd1(vvd1[i]);
				if (lane1[i] != null)
					model.setLane1(lane1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (yyyyww[i] != null)
					model.setYyyyww(yyyyww[i]);
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (fmplnwk1[i] != null)
					model.setFmplnwk1(fmplnwk1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (yyyywwold[i] != null)
					model.setYyyywwold(yyyywwold[i]);
				if (type1[i] != null)
					model.setType1(type1[i]);
				if (fmplnyr1[i] != null)
					model.setFmplnyr1(fmplnyr1[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (repoRmk[i] != null)
					model.setRepoRmk(repoRmk[i]);
				if (ecccd1[i] != null)
					model.setEcccd1(ecccd1[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0051ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0051ConditionVO[]
	 */
	public EesEqr0051ConditionVO[] getEesEqr0051ConditionVOs(){
		EesEqr0051ConditionVO[] vos = (EesEqr0051ConditionVO[])models.toArray(new EesEqr0051ConditionVO[models.size()]);
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
		this.item1 = this.item1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtpszcd1 = this.cntrtpszcd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toplnyr1 = this.toplnyr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeby1 = this.typeby1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrId = this.scnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.statusType = this.statusType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inclexecplan1 = this.inclexecplan1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toplnwk1 = this.toplnwk1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type = this.type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszall = this.tpszall .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd1 = this.vvd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane1 = this.lane1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww = this.yyyyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId = this.repoPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmplnwk1 = this.fmplnwk1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyywwold = this.yyyywwold .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type1 = this.type1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmplnyr1 = this.fmplnyr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoRmk = this.repoRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ecccd1 = this.ecccd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

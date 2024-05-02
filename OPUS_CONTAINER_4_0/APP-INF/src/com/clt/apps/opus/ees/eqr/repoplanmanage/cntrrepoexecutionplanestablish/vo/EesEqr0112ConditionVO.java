/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0112ConditionVO.java
*@FileTitle : EesEqr0112ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.09.28 이행지 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo;

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
 * @author 이행지
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0112ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0112ConditionVO> models = new ArrayList<EesEqr0112ConditionVO>();
	
	/* Column Info */
	private String scnrId = null;
	/* Column Info */
	private String inclexecplan = null;
	/* Column Info */
	private String toplnwk = null;
	/* Column Info */
	private String ecccd = null;
	/* Column Info */
	private String cntrtpszcd = null;
	/* Column Info */
	private String type = null;
	/* Column Info */
	private String tpszall = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String yyyyww = null;
	/* Column Info */
	private String repoPlnId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmplnyr = null;
	/* Column Info */
	private String item = null;
	/* Column Info */
	private String toplnyr = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String repoRmk = null;
	/* Column Info */
	private String tpsztype = null;
	/* Column Info */
	private String statustype = null;
	/* Column Info */
	private String typeby = null;
	/* Column Info */
	private String fmplnwk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0112ConditionVO() {}

	public EesEqr0112ConditionVO(String ibflag, String pagerows, String yyyyww, String seq, String statustype, String scnrId, String repoPlnId, String repoRmk, String tpszall, String tpsztype, String type, String ecccd, String typeby, String fmplnyr, String fmplnwk, String toplnyr, String toplnwk, String cntrtpszcd, String item, String lane, String vvd, String inclexecplan) {
		this.scnrId = scnrId;
		this.inclexecplan = inclexecplan;
		this.toplnwk = toplnwk;
		this.ecccd = ecccd;
		this.cntrtpszcd = cntrtpszcd;
		this.type = type;
		this.tpszall = tpszall;
		this.lane = lane;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.yyyyww = yyyyww;
		this.repoPlnId = repoPlnId;
		this.ibflag = ibflag;
		this.fmplnyr = fmplnyr;
		this.item = item;
		this.toplnyr = toplnyr;
		this.seq = seq;
		this.repoRmk = repoRmk;
		this.tpsztype = tpsztype;
		this.statustype = statustype;
		this.typeby = typeby;
		this.fmplnwk = fmplnwk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("scnr_id", getScnrId());
		this.hashColumns.put("inclExecPlan", getInclexecplan());
		this.hashColumns.put("toplnwk", getToplnwk());
		this.hashColumns.put("ecccd", getEcccd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrtpszcd());
		this.hashColumns.put("type", getType());
		this.hashColumns.put("tpszall", getTpszall());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("yyyyww", getYyyyww());
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fmplnyr", getFmplnyr());
		this.hashColumns.put("item", getItem());
		this.hashColumns.put("toplnyr", getToplnyr());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("repo_rmk", getRepoRmk());
		this.hashColumns.put("tpsztype", getTpsztype());
		this.hashColumns.put("statustype", getStatustype());
		this.hashColumns.put("typeby", getTypeby());
		this.hashColumns.put("fmplnwk", getFmplnwk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("scnr_id", "scnrId");
		this.hashFields.put("inclexecplan", "inclexecplan");
		this.hashFields.put("toplnwk", "toplnwk");
		this.hashFields.put("ecccd", "ecccd");
		this.hashFields.put("cntrtpszcd", "cntrtpszcd");
		this.hashFields.put("type", "type");
		this.hashFields.put("tpszall", "tpszall");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fmplnyr", "fmplnyr");
		this.hashFields.put("item", "item");
		this.hashFields.put("toplnyr", "toplnyr");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("repo_rmk", "repoRmk");
		this.hashFields.put("tpsztype", "tpsztype");
		this.hashFields.put("statustype", "statustype");
		this.hashFields.put("typeby", "typeby");
		this.hashFields.put("fmplnwk", "fmplnwk");
		return this.hashFields;
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
	 * @return inclexecplan
	 */
	public String getInclexecplan() {
		return this.inclexecplan;
	}
	
	/**
	 * Column Info
	 * @return toplnwk
	 */
	public String getToplnwk() {
		return this.toplnwk;
	}
	
	/**
	 * Column Info
	 * @return ecccd
	 */
	public String getEcccd() {
		return this.ecccd;
	}
	
	/**
	 * Column Info
	 * @return cntrtpszcd
	 */
	public String getCntrtpszcd() {
		return this.cntrtpszcd;
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
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @return fmplnyr
	 */
	public String getFmplnyr() {
		return this.fmplnyr;
	}
	
	/**
	 * Column Info
	 * @return item
	 */
	public String getItem() {
		return this.item;
	}
	
	/**
	 * Column Info
	 * @return toplnyr
	 */
	public String getToplnyr() {
		return this.toplnyr;
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
	 * @return tpsztype
	 */
	public String getTpsztype() {
		return this.tpsztype;
	}
	
	/**
	 * Column Info
	 * @return statustype
	 */
	public String getStatustype() {
		return this.statustype;
	}
	
	/**
	 * Column Info
	 * @return typeby
	 */
	public String getTypeby() {
		return this.typeby;
	}
	
	/**
	 * Column Info
	 * @return fmplnwk
	 */
	public String getFmplnwk() {
		return this.fmplnwk;
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
	 * @param inclexecplan
	 */
	public void setInclexecplan(String inclexecplan) {
		this.inclexecplan = inclexecplan;
	}
	
	/**
	 * Column Info
	 * @param toplnwk
	 */
	public void setToplnwk(String toplnwk) {
		this.toplnwk = toplnwk;
	}
	
	/**
	 * Column Info
	 * @param ecccd
	 */
	public void setEcccd(String ecccd) {
		this.ecccd = ecccd;
	}
	
	/**
	 * Column Info
	 * @param cntrtpszcd
	 */
	public void setCntrtpszcd(String cntrtpszcd) {
		this.cntrtpszcd = cntrtpszcd;
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
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
	 * @param fmplnyr
	 */
	public void setFmplnyr(String fmplnyr) {
		this.fmplnyr = fmplnyr;
	}
	
	/**
	 * Column Info
	 * @param item
	 */
	public void setItem(String item) {
		this.item = item;
	}
	
	/**
	 * Column Info
	 * @param toplnyr
	 */
	public void setToplnyr(String toplnyr) {
		this.toplnyr = toplnyr;
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
	 * @param tpsztype
	 */
	public void setTpsztype(String tpsztype) {
		this.tpsztype = tpsztype;
	}
	
	/**
	 * Column Info
	 * @param statustype
	 */
	public void setStatustype(String statustype) {
		this.statustype = statustype;
	}
	
	/**
	 * Column Info
	 * @param typeby
	 */
	public void setTypeby(String typeby) {
		this.typeby = typeby;
	}
	
	/**
	 * Column Info
	 * @param fmplnwk
	 */
	public void setFmplnwk(String fmplnwk) {
		this.fmplnwk = fmplnwk;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		
		setYyyyww(JSPUtil.getParameter(request, "yyyyww", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setRepoRmk(JSPUtil.getParameter(request, "repo_rmk", ""));
		setEcccd(JSPUtil.getParameter(request, "eccCd_1", ""));
		setFmplnyr(JSPUtil.getParameter(request, "fmPlnYr_1", ""));
		setFmplnwk(JSPUtil.getParameter(request, "fmPlnWk_1", ""));
		setToplnyr(JSPUtil.getParameter(request, "toPlnYr_1", ""));
		setToplnwk(JSPUtil.getParameter(request, "toPlnWk_1", ""));
		setLane(JSPUtil.getParameter(request, "lane_1", ""));
		setVvd(JSPUtil.getParameter(request, "vvd_1", ""));
		setInclexecplan(JSPUtil.getParameter(request, "inclExecPlan_1", ""));
		setCntrtpszcd(JSPUtil.getParameter(request, "cntrTpszCd_1", ""));
		setItem(JSPUtil.getParameter(request, "item_1", ""));

		setTpszall(JSPUtil.getParameter(request, "tpszall", ""));
		setScnrId(JSPUtil.getParameter(request, "scnr_id", ""));
		setRepoPlnId(JSPUtil.getParameter(request, "repo_pln_id", ""));
		setTypeby(JSPUtil.getParameter(request, "typeBy_1", ""));
		setType(JSPUtil.getParameter(request, "type_1", ""));
		setStatustype(JSPUtil.getParameter(request, "status_type", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0112ConditionVO[]
	 */
	public EesEqr0112ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0112ConditionVO[]
	 */
	public EesEqr0112ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0112ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] scnrId = (JSPUtil.getParameter(request, prefix	+ "scnr_id", length));
			String[] inclexecplan = (JSPUtil.getParameter(request, prefix	+ "inclexecplan", length));
			String[] toplnwk = (JSPUtil.getParameter(request, prefix	+ "toplnwk", length));
			String[] ecccd = (JSPUtil.getParameter(request, prefix	+ "ecccd", length));
			String[] cntrtpszcd = (JSPUtil.getParameter(request, prefix	+ "cntrtpszcd", length));
			String[] type = (JSPUtil.getParameter(request, prefix	+ "type", length));
			String[] tpszall = (JSPUtil.getParameter(request, prefix	+ "tpszall", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] yyyyww = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix	+ "repo_pln_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmplnyr = (JSPUtil.getParameter(request, prefix	+ "fmplnyr", length));
			String[] item = (JSPUtil.getParameter(request, prefix	+ "item", length));
			String[] toplnyr = (JSPUtil.getParameter(request, prefix	+ "toplnyr", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] repoRmk = (JSPUtil.getParameter(request, prefix	+ "repo_rmk", length));
			String[] tpsztype = (JSPUtil.getParameter(request, prefix	+ "tpsztype", length));
			String[] statustype = (JSPUtil.getParameter(request, prefix	+ "statustype", length));
			String[] typeby = (JSPUtil.getParameter(request, prefix	+ "typeby", length));
			String[] fmplnwk = (JSPUtil.getParameter(request, prefix	+ "fmplnwk", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0112ConditionVO();
				if (scnrId[i] != null)
					model.setScnrId(scnrId[i]);
				if (inclexecplan[i] != null)
					model.setInclexecplan(inclexecplan[i]);
				if (toplnwk[i] != null)
					model.setToplnwk(toplnwk[i]);
				if (ecccd[i] != null)
					model.setEcccd(ecccd[i]);
				if (cntrtpszcd[i] != null)
					model.setCntrtpszcd(cntrtpszcd[i]);
				if (type[i] != null)
					model.setType(type[i]);
				if (tpszall[i] != null)
					model.setTpszall(tpszall[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (yyyyww[i] != null)
					model.setYyyyww(yyyyww[i]);
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmplnyr[i] != null)
					model.setFmplnyr(fmplnyr[i]);
				if (item[i] != null)
					model.setItem(item[i]);
				if (toplnyr[i] != null)
					model.setToplnyr(toplnyr[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (repoRmk[i] != null)
					model.setRepoRmk(repoRmk[i]);
				if (tpsztype[i] != null)
					model.setTpsztype(tpsztype[i]);
				if (statustype[i] != null)
					model.setStatustype(statustype[i]);
				if (typeby[i] != null)
					model.setTypeby(typeby[i]);
				if (fmplnwk[i] != null)
					model.setFmplnwk(fmplnwk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0112ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0112ConditionVO[]
	 */
	public EesEqr0112ConditionVO[] getEesEqr0112ConditionVOs(){
		EesEqr0112ConditionVO[] vos = (EesEqr0112ConditionVO[])models.toArray(new EesEqr0112ConditionVO[models.size()]);
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
		this.scnrId = this.scnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inclexecplan = this.inclexecplan .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toplnwk = this.toplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ecccd = this.ecccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtpszcd = this.cntrtpszcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type = this.type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszall = this.tpszall .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww = this.yyyyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId = this.repoPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmplnyr = this.fmplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.item = this.item .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toplnyr = this.toplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoRmk = this.repoRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsztype = this.tpsztype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.statustype = this.statustype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeby = this.typeby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmplnwk = this.fmplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

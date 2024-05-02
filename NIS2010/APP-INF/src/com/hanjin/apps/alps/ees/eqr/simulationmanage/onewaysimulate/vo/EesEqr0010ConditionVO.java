/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0010ConditionVO.java
*@FileTitle : EesEqr0010ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.14 채창호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.simulationmanage.onewaysimulate.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.vo.CommonVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 채창호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0010ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0010ConditionVO> models = new ArrayList<EesEqr0010ConditionVO>();
	
	/* Column Info */
	private String cntrtpsztype = null;
	/* Column Info */
	private String toplnwk = null;
	/* Column Info */
	private String cntrtpszcd = null;
	/* Column Info */
	private String runIdNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String newRepoPlan = null;
	/* Column Info */
	private String newScnrId = null;
	/* Column Info */
	private String fmecccd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String toplnyr = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String totoplnwk = null;
	/* Column Info */
	private String scnrId = null;
	/* Column Info */
	private String toecccd = null;
	/* Column Info */
	private String fmtoplnwk = null;
	/* Column Info */
	private String fmtype = null;
	/* Column Info */
	private String totoplnyr = null;
	/* Column Info */
	private String fmtoplnyr = null;
	/* Column Info */
	private String yyyyww = null;
	/* Column Info */
	private String fmplnyr = null;
	/* Column Info */
	private String totype = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String fmplnwk = null;
	
	private String[] gapInfo = null;
	
	private String[] maxInfo = null;
	
	private String[] volInfo = null;
	/* Column Info */
	private List<CommonVO> cntrTpList = new ArrayList<CommonVO>();
	
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0010ConditionVO() {}

	public EesEqr0010ConditionVO(String ibflag, String pagerows, String yyyyww, String seq, String fmtype, String fmecccd, String totype, String toecccd, String userId, String fmplnyr, String fmplnwk, String toplnyr, String toplnwk, String fmtoplnyr, String fmtoplnwk, String totoplnyr, String totoplnwk, String scnrId, String cntrtpszcd, String cntrtpsztype, String newScnrId, String newRepoPlan, String runIdNo) {
		this.cntrtpsztype = cntrtpsztype;
		this.toplnwk = toplnwk;
		this.cntrtpszcd = cntrtpszcd;
		this.runIdNo = runIdNo;
		this.pagerows = pagerows;
		this.newRepoPlan = newRepoPlan;
		this.newScnrId = newScnrId;
		this.fmecccd = fmecccd;
		this.ibflag = ibflag;
		this.toplnyr = toplnyr;
		this.userId = userId;
		this.totoplnwk = totoplnwk;
		this.scnrId = scnrId;
		this.toecccd = toecccd;
		this.fmtoplnwk = fmtoplnwk;
		this.fmtype = fmtype;
		this.totoplnyr = totoplnyr;
		this.fmtoplnyr = fmtoplnyr;
		this.yyyyww = yyyyww;
		this.fmplnyr = fmplnyr;
		this.totype = totype;
		this.seq = seq;
		this.fmplnwk = fmplnwk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntrtpsztype", getCntrtpsztype());
		this.hashColumns.put("toplnwk", getToplnwk());
		this.hashColumns.put("cntrtpszcd", getCntrtpszcd());
		this.hashColumns.put("run_id_no", getRunIdNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("new_repo_plan", getNewRepoPlan());
		this.hashColumns.put("new_scnr_id", getNewScnrId());
		this.hashColumns.put("fmecccd", getFmecccd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("toplnyr", getToplnyr());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("totoplnwk", getTotoplnwk());
		this.hashColumns.put("scnr_id", getScnrId());
		this.hashColumns.put("toecccd", getToecccd());
		this.hashColumns.put("fmtoplnwk", getFmtoplnwk());
		this.hashColumns.put("fmtype", getFmtype());
		this.hashColumns.put("totoplnyr", getTotoplnyr());
		this.hashColumns.put("fmtoplnyr", getFmtoplnyr());
		this.hashColumns.put("yyyyww", getYyyyww());
		this.hashColumns.put("fmplnyr", getFmplnyr());
		this.hashColumns.put("totype", getTotype());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("fmplnwk", getFmplnwk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntrtpsztype", "cntrtpsztype");
		this.hashFields.put("toplnwk", "toplnwk");
		this.hashFields.put("cntrtpszcd", "cntrtpszcd");
		this.hashFields.put("d5", "d5");
		this.hashFields.put("d4", "d4");
		this.hashFields.put("run_id_no", "runIdNo");
		this.hashFields.put("d7", "d7");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("new_repo_plan", "newRepoPlan");
		this.hashFields.put("new_scnr_id", "newScnrId");
		this.hashFields.put("fmecccd", "fmecccd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("d2", "d2");
		this.hashFields.put("toplnyr", "toplnyr");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("totoplnwk", "totoplnwk");
		this.hashFields.put("f2", "f2");
		this.hashFields.put("f4", "f4");
		this.hashFields.put("o2", "o2");
		this.hashFields.put("o4", "o4");
		this.hashFields.put("scnr_id", "scnrId");
		this.hashFields.put("toecccd", "toecccd");
		this.hashFields.put("fmtoplnwk", "fmtoplnwk");
		this.hashFields.put("fmtype", "fmtype");
		this.hashFields.put("totoplnyr", "totoplnyr");
		this.hashFields.put("fmtoplnyr", "fmtoplnyr");
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("fmplnyr", "fmplnyr");
		this.hashFields.put("totype", "totype");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("r2", "r2");
		this.hashFields.put("r5", "r5");
		this.hashFields.put("fmplnwk", "fmplnwk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrtpsztype
	 */
	public String getCntrtpsztype() {
		return this.cntrtpsztype;
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
	 * @return cntrtpszcd
	 */
	public String getCntrtpszcd() {
		return this.cntrtpszcd;
	}
	
	/**
	 * Column Info
	 * @return runIdNo
	 */
	public String getRunIdNo() {
		return this.runIdNo;
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
	 * @return newRepoPlan
	 */
	public String getNewRepoPlan() {
		return this.newRepoPlan;
	}
	
	/**
	 * Column Info
	 * @return newScnrId
	 */
	public String getNewScnrId() {
		return this.newScnrId;
	}
	
	/**
	 * Column Info
	 * @return fmecccd
	 */
	public String getFmecccd() {
		return this.fmecccd;
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
	 * @return toplnyr
	 */
	public String getToplnyr() {
		return this.toplnyr;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return totoplnwk
	 */
	public String getTotoplnwk() {
		return this.totoplnwk;
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
	 * @return toecccd
	 */
	public String getToecccd() {
		return this.toecccd;
	}
	
	/**
	 * Column Info
	 * @return fmtoplnwk
	 */
	public String getFmtoplnwk() {
		return this.fmtoplnwk;
	}
	
	/**
	 * Column Info
	 * @return fmtype
	 */
	public String getFmtype() {
		return this.fmtype;
	}
	
	/**
	 * Column Info
	 * @return totoplnyr
	 */
	public String getTotoplnyr() {
		return this.totoplnyr;
	}
	
	/**
	 * Column Info
	 * @return fmtoplnyr
	 */
	public String getFmtoplnyr() {
		return this.fmtoplnyr;
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
	 * @return fmplnyr
	 */
	public String getFmplnyr() {
		return this.fmplnyr;
	}
	
	/**
	 * Column Info
	 * @return totype
	 */
	public String getTotype() {
		return this.totype;
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
	 * @return fmplnwk
	 */
	public String getFmplnwk() {
		return this.fmplnwk;
	}
	

	/**
	 * Column Info
	 * @param cntrtpsztype
	 */
	public void setCntrtpsztype(String cntrtpsztype) {
		this.cntrtpsztype = cntrtpsztype;
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
	 * @param cntrtpszcd
	 */
	public void setCntrtpszcd(String cntrtpszcd) {
		this.cntrtpszcd = cntrtpszcd;
	}
	
	
	/**
	 * Column Info
	 * @param runIdNo
	 */
	public void setRunIdNo(String runIdNo) {
		this.runIdNo = runIdNo;
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
	 * @param newRepoPlan
	 */
	public void setNewRepoPlan(String newRepoPlan) {
		this.newRepoPlan = newRepoPlan;
	}
	
	/**
	 * Column Info
	 * @param newScnrId
	 */
	public void setNewScnrId(String newScnrId) {
		this.newScnrId = newScnrId;
	}
	
	/**
	 * Column Info
	 * @param fmecccd
	 */
	public void setFmecccd(String fmecccd) {
		this.fmecccd = fmecccd;
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
	 * @param toplnyr
	 */
	public void setToplnyr(String toplnyr) {
		this.toplnyr = toplnyr;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param totoplnwk
	 */
	public void setTotoplnwk(String totoplnwk) {
		this.totoplnwk = totoplnwk;
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
	 * @param toecccd
	 */
	public void setToecccd(String toecccd) {
		this.toecccd = toecccd;
	}
	
	/**
	 * Column Info
	 * @param fmtoplnwk
	 */
	public void setFmtoplnwk(String fmtoplnwk) {
		this.fmtoplnwk = fmtoplnwk;
	}
	
	/**
	 * Column Info
	 * @param fmtype
	 */
	public void setFmtype(String fmtype) {
		this.fmtype = fmtype;
	}
	
	/**
	 * Column Info
	 * @param totoplnyr
	 */
	public void setTotoplnyr(String totoplnyr) {
		this.totoplnyr = totoplnyr;
	}
	
	/**
	 * Column Info
	 * @param fmtoplnyr
	 */
	public void setFmtoplnyr(String fmtoplnyr) {
		this.fmtoplnyr = fmtoplnyr;
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
	 * @param fmplnyr
	 */
	public void setFmplnyr(String fmplnyr) {
		this.fmplnyr = fmplnyr;
	}
	
	/**
	 * Column Info
	 * @param totype
	 */
	public void setTotype(String totype) {
		this.totype = totype;
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
	 * @param fmplnwk
	 */
	public void setFmplnwk(String fmplnwk) {
		this.fmplnwk = fmplnwk;
	}
	
	
	/**
	 * @return the gapInfo
	 */
	public String[] getGapInfo() {
		return gapInfo;
	}

	/**
	 * @param gapInfo the gapInfo to set
	 */
	public void setGapInfo(String[] gapInfo) {
		this.gapInfo = gapInfo;
	}

	/**
	 * @return the maxInfo
	 */
	public String[] getMaxInfo() {
		return maxInfo;
	}

	/**
	 * @param maxInfo the maxInfo to set
	 */
	public void setMaxInfo(String[] maxInfo) {
		this.maxInfo = maxInfo;
	}

	
	/**
	 * @return the volInfo
	 */
	public String[] getVolInfo() {
		return volInfo;
	}

	/**
	 * @param volInfo the volInfo to set
	 */
	public void setVolInfo(String[] volInfo) {
		this.volInfo = volInfo;
	}
	
	public List<CommonVO> getCntrTpList() {
		return cntrTpList;
	}

	public void setCntrTpList(List<CommonVO> cntrTpList) {
		this.cntrTpList = cntrTpList;
	}
	

	public void addCntrTpList(CommonVO cntrTpsz) {
		this.cntrTpList.add(cntrTpsz);
	}


	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCntrtpsztype(JSPUtil.getParameter(request, "tpsz", ""));
		setToplnwk(JSPUtil.getParameter(request, "toPlnWk", ""));
		setCntrtpszcd(JSPUtil.getParameter(request, "cntrTpszCd", ""));
		setRunIdNo(JSPUtil.getParameter(request, "run_id_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setNewRepoPlan(JSPUtil.getParameter(request, "planID", ""));
		setNewScnrId(JSPUtil.getParameter(request, "new_scnr_id", ""));
		setFmecccd(JSPUtil.getParameter(request, "fmEccCd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setToplnyr(JSPUtil.getParameter(request, "toPlnYr", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setTotoplnwk(JSPUtil.getParameter(request, "toToPlnWk", ""));
		setScnrId(JSPUtil.getParameter(request, "scnr_id", ""));
		setToecccd(JSPUtil.getParameter(request, "toEccCd", ""));
		setFmtoplnwk(JSPUtil.getParameter(request, "fmToPlnWk", ""));
		setFmtype(JSPUtil.getParameter(request, "fmType", ""));
		setTotoplnyr(JSPUtil.getParameter(request, "toToPlnYr", ""));
		setFmtoplnyr(JSPUtil.getParameter(request, "fmToPlnYr", ""));
		setYyyyww(JSPUtil.getParameter(request, "yyyyww", ""));
		setFmplnyr(JSPUtil.getParameter(request, "fmPlnYr", ""));
		setTotype(JSPUtil.getParameter(request, "toType", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setFmplnwk(JSPUtil.getParameter(request, "fmPlnWk", ""));
		
		// TPsz 자동화  09.11.03 modify by ChungEunHo
		StringTokenizer tokenTpszcd = new StringTokenizer(this.cntrtpsztype, ",");
		while (tokenTpszcd.hasMoreTokens()) {
			CommonVO commonVO = new CommonVO();
			String TpSzText = tokenTpszcd.nextToken();
			String TpSzValue = JSPUtil.getParameter(request, TpSzText, "");
			commonVO.setField1(TpSzText);
			commonVO.setField2(TpSzValue);
			addCntrTpList(commonVO);
		}
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0010ConditionVO[]
	 */
	public EesEqr0010ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0010ConditionVO[]
	 */
	public EesEqr0010ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0010ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrtpsztype = (JSPUtil.getParameter(request, prefix	+ "cntrtpsztype", length));
			String[] toplnwk = (JSPUtil.getParameter(request, prefix	+ "toplnwk", length));
			String[] cntrtpszcd = (JSPUtil.getParameter(request, prefix	+ "cntrtpszcd", length));
			String[] runIdNo = (JSPUtil.getParameter(request, prefix	+ "run_id_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] newRepoPlan = (JSPUtil.getParameter(request, prefix	+ "new_repo_plan", length));
			String[] newScnrId = (JSPUtil.getParameter(request, prefix	+ "new_scnr_id", length));
			String[] fmecccd = (JSPUtil.getParameter(request, prefix	+ "fmecccd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] toplnyr = (JSPUtil.getParameter(request, prefix	+ "toplnyr", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] totoplnwk = (JSPUtil.getParameter(request, prefix	+ "totoplnwk", length));
			String[] scnrId = (JSPUtil.getParameter(request, prefix	+ "scnr_id", length));
			String[] toecccd = (JSPUtil.getParameter(request, prefix	+ "toecccd", length));
			String[] fmtoplnwk = (JSPUtil.getParameter(request, prefix	+ "fmtoplnwk", length));
			String[] fmtype = (JSPUtil.getParameter(request, prefix	+ "fmtype", length));
			String[] totoplnyr = (JSPUtil.getParameter(request, prefix	+ "totoplnyr", length));
			String[] fmtoplnyr = (JSPUtil.getParameter(request, prefix	+ "fmtoplnyr", length));
			String[] yyyyww = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] fmplnyr = (JSPUtil.getParameter(request, prefix	+ "fmplnyr", length));
			String[] totype = (JSPUtil.getParameter(request, prefix	+ "totype", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] fmplnwk = (JSPUtil.getParameter(request, prefix	+ "fmplnwk", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0010ConditionVO();
				if (cntrtpsztype[i] != null)
					model.setCntrtpsztype(cntrtpsztype[i]);
				if (toplnwk[i] != null)
					model.setToplnwk(toplnwk[i]);
				if (cntrtpszcd[i] != null)
					model.setCntrtpszcd(cntrtpszcd[i]);
				if (runIdNo[i] != null)
					model.setRunIdNo(runIdNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (newRepoPlan[i] != null)
					model.setNewRepoPlan(newRepoPlan[i]);
				if (newScnrId[i] != null)
					model.setNewScnrId(newScnrId[i]);
				if (fmecccd[i] != null)
					model.setFmecccd(fmecccd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (toplnyr[i] != null)
					model.setToplnyr(toplnyr[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (totoplnwk[i] != null)
					model.setTotoplnwk(totoplnwk[i]);
				if (scnrId[i] != null)
					model.setScnrId(scnrId[i]);
				if (toecccd[i] != null)
					model.setToecccd(toecccd[i]);
				if (fmtoplnwk[i] != null)
					model.setFmtoplnwk(fmtoplnwk[i]);
				if (fmtype[i] != null)
					model.setFmtype(fmtype[i]);
				if (totoplnyr[i] != null)
					model.setTotoplnyr(totoplnyr[i]);
				if (fmtoplnyr[i] != null)
					model.setFmtoplnyr(fmtoplnyr[i]);
				if (yyyyww[i] != null)
					model.setYyyyww(yyyyww[i]);
				if (fmplnyr[i] != null)
					model.setFmplnyr(fmplnyr[i]);
				if (totype[i] != null)
					model.setTotype(totype[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (fmplnwk[i] != null)
					model.setFmplnwk(fmplnwk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0010ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0010ConditionVO[]
	 */
	public EesEqr0010ConditionVO[] getEesEqr0010ConditionVOs(){
		EesEqr0010ConditionVO[] vos = (EesEqr0010ConditionVO[])models.toArray(new EesEqr0010ConditionVO[models.size()]);
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
		this.cntrtpsztype = this.cntrtpsztype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toplnwk = this.toplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtpszcd = this.cntrtpszcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.runIdNo = this.runIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newRepoPlan = this.newRepoPlan .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newScnrId = this.newScnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmecccd = this.fmecccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toplnyr = this.toplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totoplnwk = this.totoplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrId = this.scnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toecccd = this.toecccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtoplnwk = this.fmtoplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtype = this.fmtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totoplnyr = this.totoplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtoplnyr = this.fmtoplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww = this.yyyyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmplnyr = this.fmplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totype = this.totype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmplnwk = this.fmplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

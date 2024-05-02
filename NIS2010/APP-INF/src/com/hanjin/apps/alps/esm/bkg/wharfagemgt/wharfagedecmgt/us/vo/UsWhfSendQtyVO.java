/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsWhfSendQtyVO.java
*@FileTitle : UsWhfSendQtyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.09.14 김민정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo;

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
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsWhfSendQtyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsWhfSendQtyVO> models = new ArrayList<UsWhfSendQtyVO>();
	
	/* Column Info */
	private String utPrcTeus = null;
	/* Column Info */
	private String railRate = null;
	/* Column Info */
	private String railAmt = null;
	/* Column Info */
	private String tsRate = null;
	/* Column Info */
	private String localAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String whfAmt = null;
	/* Column Info */
	private String utPrc20ft = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usaWhfTrspTpCd = null;
	/* Column Info */
	private String railCount = null;
	/* Column Info */
	private String utPrcCont = null;
	/* Column Info */
	private String localCount = null;
	/* Column Info */
	private String cont = null;
	/* Column Info */
	private String teus = null;
	/* Column Info */
	private String ft45 = null;
	/* Column Info */
	private String utPrc45ft = null;
	/* Column Info */
	private String tsAmt = null;
	/* Column Info */
	private String ft40 = null;
	/* Column Info */
	private String ft20 = null;
	/* Column Info */
	private String localRate = null;
	/* Column Info */
	private String tsCount = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String utPrc40ft = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsWhfSendQtyVO() {}

	public UsWhfSendQtyVO(String ibflag, String pagerows, String seq, String localCount, String localRate, String localAmt, String railCount, String railRate, String railAmt, String tsCount, String tsRate, String tsAmt, String ft20, String ft40, String ft45, String cont, String teus, String whfAmt, String fullMtyCd, String usaWhfTrspTpCd, String utPrc20ft, String utPrc40ft, String utPrc45ft, String utPrcCont, String utPrcTeus) {
		this.utPrcTeus = utPrcTeus;
		this.railRate = railRate;
		this.railAmt = railAmt;
		this.tsRate = tsRate;
		this.localAmt = localAmt;
		this.pagerows = pagerows;
		this.whfAmt = whfAmt;
		this.utPrc20ft = utPrc20ft;
		this.ibflag = ibflag;
		this.usaWhfTrspTpCd = usaWhfTrspTpCd;
		this.railCount = railCount;
		this.utPrcCont = utPrcCont;
		this.localCount = localCount;
		this.cont = cont;
		this.teus = teus;
		this.ft45 = ft45;
		this.utPrc45ft = utPrc45ft;
		this.tsAmt = tsAmt;
		this.ft40 = ft40;
		this.ft20 = ft20;
		this.localRate = localRate;
		this.tsCount = tsCount;
		this.seq = seq;
		this.fullMtyCd = fullMtyCd;
		this.utPrc40ft = utPrc40ft;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ut_prc_teus", getUtPrcTeus());
		this.hashColumns.put("rail_rate", getRailRate());
		this.hashColumns.put("rail_amt", getRailAmt());
		this.hashColumns.put("ts_rate", getTsRate());
		this.hashColumns.put("local_amt", getLocalAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("whf_amt", getWhfAmt());
		this.hashColumns.put("ut_prc_20ft", getUtPrc20ft());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usa_whf_trsp_tp_cd", getUsaWhfTrspTpCd());
		this.hashColumns.put("rail_count", getRailCount());
		this.hashColumns.put("ut_prc_cont", getUtPrcCont());
		this.hashColumns.put("local_count", getLocalCount());
		this.hashColumns.put("cont", getCont());
		this.hashColumns.put("teus", getTeus());
		this.hashColumns.put("ft45", getFt45());
		this.hashColumns.put("ut_prc_45ft", getUtPrc45ft());
		this.hashColumns.put("ts_amt", getTsAmt());
		this.hashColumns.put("ft40", getFt40());
		this.hashColumns.put("ft20", getFt20());
		this.hashColumns.put("local_rate", getLocalRate());
		this.hashColumns.put("ts_count", getTsCount());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("ut_prc_40ft", getUtPrc40ft());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ut_prc_teus", "utPrcTeus");
		this.hashFields.put("rail_rate", "railRate");
		this.hashFields.put("rail_amt", "railAmt");
		this.hashFields.put("ts_rate", "tsRate");
		this.hashFields.put("local_amt", "localAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("whf_amt", "whfAmt");
		this.hashFields.put("ut_prc_20ft", "utPrc20ft");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usa_whf_trsp_tp_cd", "usaWhfTrspTpCd");
		this.hashFields.put("rail_count", "railCount");
		this.hashFields.put("ut_prc_cont", "utPrcCont");
		this.hashFields.put("local_count", "localCount");
		this.hashFields.put("cont", "cont");
		this.hashFields.put("teus", "teus");
		this.hashFields.put("ft45", "ft45");
		this.hashFields.put("ut_prc_45ft", "utPrc45ft");
		this.hashFields.put("ts_amt", "tsAmt");
		this.hashFields.put("ft40", "ft40");
		this.hashFields.put("ft20", "ft20");
		this.hashFields.put("local_rate", "localRate");
		this.hashFields.put("ts_count", "tsCount");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("ut_prc_40ft", "utPrc40ft");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return utPrcTeus
	 */
	public String getUtPrcTeus() {
		return this.utPrcTeus;
	}
	
	/**
	 * Column Info
	 * @return railRate
	 */
	public String getRailRate() {
		return this.railRate;
	}
	
	/**
	 * Column Info
	 * @return railAmt
	 */
	public String getRailAmt() {
		return this.railAmt;
	}
	
	/**
	 * Column Info
	 * @return tsRate
	 */
	public String getTsRate() {
		return this.tsRate;
	}
	
	/**
	 * Column Info
	 * @return localAmt
	 */
	public String getLocalAmt() {
		return this.localAmt;
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
	 * @return whfAmt
	 */
	public String getWhfAmt() {
		return this.whfAmt;
	}
	
	/**
	 * Column Info
	 * @return utPrc20ft
	 */
	public String getUtPrc20ft() {
		return this.utPrc20ft;
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
	 * @return usaWhfTrspTpCd
	 */
	public String getUsaWhfTrspTpCd() {
		return this.usaWhfTrspTpCd;
	}
	
	/**
	 * Column Info
	 * @return railCount
	 */
	public String getRailCount() {
		return this.railCount;
	}
	
	/**
	 * Column Info
	 * @return utPrcCont
	 */
	public String getUtPrcCont() {
		return this.utPrcCont;
	}
	
	/**
	 * Column Info
	 * @return localCount
	 */
	public String getLocalCount() {
		return this.localCount;
	}
	
	/**
	 * Column Info
	 * @return cont
	 */
	public String getCont() {
		return this.cont;
	}
	
	/**
	 * Column Info
	 * @return teus
	 */
	public String getTeus() {
		return this.teus;
	}
	
	/**
	 * Column Info
	 * @return ft45
	 */
	public String getFt45() {
		return this.ft45;
	}
	
	/**
	 * Column Info
	 * @return utPrc45ft
	 */
	public String getUtPrc45ft() {
		return this.utPrc45ft;
	}
	
	/**
	 * Column Info
	 * @return tsAmt
	 */
	public String getTsAmt() {
		return this.tsAmt;
	}
	
	/**
	 * Column Info
	 * @return ft40
	 */
	public String getFt40() {
		return this.ft40;
	}
	
	/**
	 * Column Info
	 * @return ft20
	 */
	public String getFt20() {
		return this.ft20;
	}
	
	/**
	 * Column Info
	 * @return localRate
	 */
	public String getLocalRate() {
		return this.localRate;
	}
	
	/**
	 * Column Info
	 * @return tsCount
	 */
	public String getTsCount() {
		return this.tsCount;
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
	 * @return fullMtyCd
	 */
	public String getFullMtyCd() {
		return this.fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @return utPrc40ft
	 */
	public String getUtPrc40ft() {
		return this.utPrc40ft;
	}
	

	/**
	 * Column Info
	 * @param utPrcTeus
	 */
	public void setUtPrcTeus(String utPrcTeus) {
		this.utPrcTeus = utPrcTeus;
	}
	
	/**
	 * Column Info
	 * @param railRate
	 */
	public void setRailRate(String railRate) {
		this.railRate = railRate;
	}
	
	/**
	 * Column Info
	 * @param railAmt
	 */
	public void setRailAmt(String railAmt) {
		this.railAmt = railAmt;
	}
	
	/**
	 * Column Info
	 * @param tsRate
	 */
	public void setTsRate(String tsRate) {
		this.tsRate = tsRate;
	}
	
	/**
	 * Column Info
	 * @param localAmt
	 */
	public void setLocalAmt(String localAmt) {
		this.localAmt = localAmt;
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
	 * @param whfAmt
	 */
	public void setWhfAmt(String whfAmt) {
		this.whfAmt = whfAmt;
	}
	
	/**
	 * Column Info
	 * @param utPrc20ft
	 */
	public void setUtPrc20ft(String utPrc20ft) {
		this.utPrc20ft = utPrc20ft;
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
	 * @param usaWhfTrspTpCd
	 */
	public void setUsaWhfTrspTpCd(String usaWhfTrspTpCd) {
		this.usaWhfTrspTpCd = usaWhfTrspTpCd;
	}
	
	/**
	 * Column Info
	 * @param railCount
	 */
	public void setRailCount(String railCount) {
		this.railCount = railCount;
	}
	
	/**
	 * Column Info
	 * @param utPrcCont
	 */
	public void setUtPrcCont(String utPrcCont) {
		this.utPrcCont = utPrcCont;
	}
	
	/**
	 * Column Info
	 * @param localCount
	 */
	public void setLocalCount(String localCount) {
		this.localCount = localCount;
	}
	
	/**
	 * Column Info
	 * @param cont
	 */
	public void setCont(String cont) {
		this.cont = cont;
	}
	
	/**
	 * Column Info
	 * @param teus
	 */
	public void setTeus(String teus) {
		this.teus = teus;
	}
	
	/**
	 * Column Info
	 * @param ft45
	 */
	public void setFt45(String ft45) {
		this.ft45 = ft45;
	}
	
	/**
	 * Column Info
	 * @param utPrc45ft
	 */
	public void setUtPrc45ft(String utPrc45ft) {
		this.utPrc45ft = utPrc45ft;
	}
	
	/**
	 * Column Info
	 * @param tsAmt
	 */
	public void setTsAmt(String tsAmt) {
		this.tsAmt = tsAmt;
	}
	
	/**
	 * Column Info
	 * @param ft40
	 */
	public void setFt40(String ft40) {
		this.ft40 = ft40;
	}
	
	/**
	 * Column Info
	 * @param ft20
	 */
	public void setFt20(String ft20) {
		this.ft20 = ft20;
	}
	
	/**
	 * Column Info
	 * @param localRate
	 */
	public void setLocalRate(String localRate) {
		this.localRate = localRate;
	}
	
	/**
	 * Column Info
	 * @param tsCount
	 */
	public void setTsCount(String tsCount) {
		this.tsCount = tsCount;
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
	 * @param fullMtyCd
	 */
	public void setFullMtyCd(String fullMtyCd) {
		this.fullMtyCd = fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @param utPrc40ft
	 */
	public void setUtPrc40ft(String utPrc40ft) {
		this.utPrc40ft = utPrc40ft;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUtPrcTeus(JSPUtil.getParameter(request, "ut_prc_teus", ""));
		setRailRate(JSPUtil.getParameter(request, "rail_rate", ""));
		setRailAmt(JSPUtil.getParameter(request, "rail_amt", ""));
		setTsRate(JSPUtil.getParameter(request, "ts_rate", ""));
		setLocalAmt(JSPUtil.getParameter(request, "local_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setWhfAmt(JSPUtil.getParameter(request, "whf_amt", ""));
		setUtPrc20ft(JSPUtil.getParameter(request, "ut_prc_20ft", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUsaWhfTrspTpCd(JSPUtil.getParameter(request, "usa_whf_trsp_tp_cd", ""));
		setRailCount(JSPUtil.getParameter(request, "rail_count", ""));
		setUtPrcCont(JSPUtil.getParameter(request, "ut_prc_cont", ""));
		setLocalCount(JSPUtil.getParameter(request, "local_count", ""));
		setCont(JSPUtil.getParameter(request, "cont", ""));
		setTeus(JSPUtil.getParameter(request, "teus", ""));
		setFt45(JSPUtil.getParameter(request, "ft45", ""));
		setUtPrc45ft(JSPUtil.getParameter(request, "ut_prc_45ft", ""));
		setTsAmt(JSPUtil.getParameter(request, "ts_amt", ""));
		setFt40(JSPUtil.getParameter(request, "ft40", ""));
		setFt20(JSPUtil.getParameter(request, "ft20", ""));
		setLocalRate(JSPUtil.getParameter(request, "local_rate", ""));
		setTsCount(JSPUtil.getParameter(request, "ts_count", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setFullMtyCd(JSPUtil.getParameter(request, "full_mty_cd", ""));
		setUtPrc40ft(JSPUtil.getParameter(request, "ut_prc_40ft", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsWhfSendQtyVO[]
	 */
	public UsWhfSendQtyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsWhfSendQtyVO[]
	 */
	public UsWhfSendQtyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsWhfSendQtyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] utPrcTeus = (JSPUtil.getParameter(request, prefix	+ "ut_prc_teus", length));
			String[] railRate = (JSPUtil.getParameter(request, prefix	+ "rail_rate", length));
			String[] railAmt = (JSPUtil.getParameter(request, prefix	+ "rail_amt", length));
			String[] tsRate = (JSPUtil.getParameter(request, prefix	+ "ts_rate", length));
			String[] localAmt = (JSPUtil.getParameter(request, prefix	+ "local_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] whfAmt = (JSPUtil.getParameter(request, prefix	+ "whf_amt", length));
			String[] utPrc20ft = (JSPUtil.getParameter(request, prefix	+ "ut_prc_20ft", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usaWhfTrspTpCd = (JSPUtil.getParameter(request, prefix	+ "usa_whf_trsp_tp_cd", length));
			String[] railCount = (JSPUtil.getParameter(request, prefix	+ "rail_count", length));
			String[] utPrcCont = (JSPUtil.getParameter(request, prefix	+ "ut_prc_cont", length));
			String[] localCount = (JSPUtil.getParameter(request, prefix	+ "local_count", length));
			String[] cont = (JSPUtil.getParameter(request, prefix	+ "cont", length));
			String[] teus = (JSPUtil.getParameter(request, prefix	+ "teus", length));
			String[] ft45 = (JSPUtil.getParameter(request, prefix	+ "ft45", length));
			String[] utPrc45ft = (JSPUtil.getParameter(request, prefix	+ "ut_prc_45ft", length));
			String[] tsAmt = (JSPUtil.getParameter(request, prefix	+ "ts_amt", length));
			String[] ft40 = (JSPUtil.getParameter(request, prefix	+ "ft40", length));
			String[] ft20 = (JSPUtil.getParameter(request, prefix	+ "ft20", length));
			String[] localRate = (JSPUtil.getParameter(request, prefix	+ "local_rate", length));
			String[] tsCount = (JSPUtil.getParameter(request, prefix	+ "ts_count", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] utPrc40ft = (JSPUtil.getParameter(request, prefix	+ "ut_prc_40ft", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsWhfSendQtyVO();
				if (utPrcTeus[i] != null)
					model.setUtPrcTeus(utPrcTeus[i]);
				if (railRate[i] != null)
					model.setRailRate(railRate[i]);
				if (railAmt[i] != null)
					model.setRailAmt(railAmt[i]);
				if (tsRate[i] != null)
					model.setTsRate(tsRate[i]);
				if (localAmt[i] != null)
					model.setLocalAmt(localAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (whfAmt[i] != null)
					model.setWhfAmt(whfAmt[i]);
				if (utPrc20ft[i] != null)
					model.setUtPrc20ft(utPrc20ft[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usaWhfTrspTpCd[i] != null)
					model.setUsaWhfTrspTpCd(usaWhfTrspTpCd[i]);
				if (railCount[i] != null)
					model.setRailCount(railCount[i]);
				if (utPrcCont[i] != null)
					model.setUtPrcCont(utPrcCont[i]);
				if (localCount[i] != null)
					model.setLocalCount(localCount[i]);
				if (cont[i] != null)
					model.setCont(cont[i]);
				if (teus[i] != null)
					model.setTeus(teus[i]);
				if (ft45[i] != null)
					model.setFt45(ft45[i]);
				if (utPrc45ft[i] != null)
					model.setUtPrc45ft(utPrc45ft[i]);
				if (tsAmt[i] != null)
					model.setTsAmt(tsAmt[i]);
				if (ft40[i] != null)
					model.setFt40(ft40[i]);
				if (ft20[i] != null)
					model.setFt20(ft20[i]);
				if (localRate[i] != null)
					model.setLocalRate(localRate[i]);
				if (tsCount[i] != null)
					model.setTsCount(tsCount[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (utPrc40ft[i] != null)
					model.setUtPrc40ft(utPrc40ft[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsWhfSendQtyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsWhfSendQtyVO[]
	 */
	public UsWhfSendQtyVO[] getUsWhfSendQtyVOs(){
		UsWhfSendQtyVO[] vos = (UsWhfSendQtyVO[])models.toArray(new UsWhfSendQtyVO[models.size()]);
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
		this.utPrcTeus = this.utPrcTeus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railRate = this.railRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railAmt = this.railAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsRate = this.tsRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localAmt = this.localAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfAmt = this.whfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.utPrc20ft = this.utPrc20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaWhfTrspTpCd = this.usaWhfTrspTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railCount = this.railCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.utPrcCont = this.utPrcCont .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localCount = this.localCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cont = this.cont .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teus = this.teus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ft45 = this.ft45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.utPrc45ft = this.utPrc45ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsAmt = this.tsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ft40 = this.ft40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ft20 = this.ft20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localRate = this.localRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsCount = this.tsCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.utPrc40ft = this.utPrc40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

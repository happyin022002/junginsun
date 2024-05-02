/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsWhfPortRtVO.java
*@FileTitle : UsWhfPortRtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.08.28 김민정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfPortRtVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsWhfPortRtVO extends WhfPortRtVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsWhfPortRtVO> models = new ArrayList<UsWhfPortRtVO>();
	
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String usaWhfExptFlg = null;
	/* Column Info */
	private String ft45 = null;
	/* Column Info */
	private String localPrc = null;
	/* Column Info */
	private String ft40 = null;
	/* Column Info */
	private String usaWhfRatUtCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ft20 = null;
	/* Column Info */
	private String tsPrc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String railPrc = null;
	/* Column Info */
	private String usaWhfTrspTpCd = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String whfDcRt = null;
	/* Column Info */
	private String cont = null;
	/* Column Info */
	private String teus = null;
	/* Column Info */
	private String bound = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsWhfPortRtVO() {}

	public UsWhfPortRtVO(String ibflag, String pagerows, String seq, String ft20, String ft40, String ft45, String cont, String teus, String fullMtyCd, String usaWhfTrspTpCd, String port, String bound, String effDt, String localPrc, String railPrc, String tsPrc, String usaWhfExptFlg, String usaWhfRatUtCd, String whfDcRt) {
		this.port = port;
		this.usaWhfExptFlg = usaWhfExptFlg;
		this.ft45 = ft45;
		this.localPrc = localPrc;
		this.ft40 = ft40;
		this.usaWhfRatUtCd = usaWhfRatUtCd;
		this.pagerows = pagerows;
		this.ft20 = ft20;
		this.tsPrc = tsPrc;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.railPrc = railPrc;
		this.usaWhfTrspTpCd = usaWhfTrspTpCd;
		this.seq = seq;
		this.fullMtyCd = fullMtyCd;
		this.whfDcRt = whfDcRt;
		this.cont = cont;
		this.teus = teus;
		this.bound = bound;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("usa_whf_expt_flg", getUsaWhfExptFlg());
		this.hashColumns.put("ft45", getFt45());
		this.hashColumns.put("local_prc", getLocalPrc());
		this.hashColumns.put("ft40", getFt40());
		this.hashColumns.put("usa_whf_rat_ut_cd", getUsaWhfRatUtCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ft20", getFt20());
		this.hashColumns.put("ts_prc", getTsPrc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("rail_prc", getRailPrc());
		this.hashColumns.put("usa_whf_trsp_tp_cd", getUsaWhfTrspTpCd());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("whf_dc_rt", getWhfDcRt());
		this.hashColumns.put("cont", getCont());
		this.hashColumns.put("teus", getTeus());
		this.hashColumns.put("bound", getBound());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("port", "port");
		this.hashFields.put("usa_whf_expt_flg", "usaWhfExptFlg");
		this.hashFields.put("ft45", "ft45");
		this.hashFields.put("local_prc", "localPrc");
		this.hashFields.put("ft40", "ft40");
		this.hashFields.put("usa_whf_rat_ut_cd", "usaWhfRatUtCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ft20", "ft20");
		this.hashFields.put("ts_prc", "tsPrc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("rail_prc", "railPrc");
		this.hashFields.put("usa_whf_trsp_tp_cd", "usaWhfTrspTpCd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("whf_dc_rt", "whfDcRt");
		this.hashFields.put("cont", "cont");
		this.hashFields.put("teus", "teus");
		this.hashFields.put("bound", "bound");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return port
	 */
	public String getPort() {
		return this.port;
	}
	
	/**
	 * Column Info
	 * @return usaWhfExptFlg
	 */
	public String getUsaWhfExptFlg() {
		return this.usaWhfExptFlg;
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
	 * @return localPrc
	 */
	public String getLocalPrc() {
		return this.localPrc;
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
	 * @return usaWhfRatUtCd
	 */
	public String getUsaWhfRatUtCd() {
		return this.usaWhfRatUtCd;
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
	 * @return ft20
	 */
	public String getFt20() {
		return this.ft20;
	}
	
	/**
	 * Column Info
	 * @return tsPrc
	 */
	public String getTsPrc() {
		return this.tsPrc;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return railPrc
	 */
	public String getRailPrc() {
		return this.railPrc;
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
	 * @return whfDcRt
	 */
	public String getWhfDcRt() {
		return this.whfDcRt;
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
	 * @return bound
	 */
	public String getBound() {
		return this.bound;
	}
	

	/**
	 * Column Info
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Column Info
	 * @param usaWhfExptFlg
	 */
	public void setUsaWhfExptFlg(String usaWhfExptFlg) {
		this.usaWhfExptFlg = usaWhfExptFlg;
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
	 * @param localPrc
	 */
	public void setLocalPrc(String localPrc) {
		this.localPrc = localPrc;
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
	 * @param usaWhfRatUtCd
	 */
	public void setUsaWhfRatUtCd(String usaWhfRatUtCd) {
		this.usaWhfRatUtCd = usaWhfRatUtCd;
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
	 * @param ft20
	 */
	public void setFt20(String ft20) {
		this.ft20 = ft20;
	}
	
	/**
	 * Column Info
	 * @param tsPrc
	 */
	public void setTsPrc(String tsPrc) {
		this.tsPrc = tsPrc;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param railPrc
	 */
	public void setRailPrc(String railPrc) {
		this.railPrc = railPrc;
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
	 * @param whfDcRt
	 */
	public void setWhfDcRt(String whfDcRt) {
		this.whfDcRt = whfDcRt;
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
	 * @param bound
	 */
	public void setBound(String bound) {
		this.bound = bound;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPort(JSPUtil.getParameter(request, "port", ""));
		setUsaWhfExptFlg(JSPUtil.getParameter(request, "usa_whf_expt_flg", ""));
		setFt45(JSPUtil.getParameter(request, "ft45", ""));
		setLocalPrc(JSPUtil.getParameter(request, "local_prc", ""));
		setFt40(JSPUtil.getParameter(request, "ft40", ""));
		setUsaWhfRatUtCd(JSPUtil.getParameter(request, "usa_whf_rat_ut_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFt20(JSPUtil.getParameter(request, "ft20", ""));
		setTsPrc(JSPUtil.getParameter(request, "ts_prc", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setRailPrc(JSPUtil.getParameter(request, "rail_prc", ""));
		setUsaWhfTrspTpCd(JSPUtil.getParameter(request, "usa_whf_trsp_tp_cd", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setFullMtyCd(JSPUtil.getParameter(request, "full_mty_cd", ""));
		setWhfDcRt(JSPUtil.getParameter(request, "whf_dc_rt", ""));
		setCont(JSPUtil.getParameter(request, "cont", ""));
		setTeus(JSPUtil.getParameter(request, "teus", ""));
		setBound(JSPUtil.getParameter(request, "bound", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsWhfPortRtVO[]
	 */
	public UsWhfPortRtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsWhfPortRtVO[]
	 */
	public UsWhfPortRtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsWhfPortRtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] usaWhfExptFlg = (JSPUtil.getParameter(request, prefix	+ "usa_whf_expt_flg", length));
			String[] ft45 = (JSPUtil.getParameter(request, prefix	+ "ft45", length));
			String[] localPrc = (JSPUtil.getParameter(request, prefix	+ "local_prc", length));
			String[] ft40 = (JSPUtil.getParameter(request, prefix	+ "ft40", length));
			String[] usaWhfRatUtCd = (JSPUtil.getParameter(request, prefix	+ "usa_whf_rat_ut_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ft20 = (JSPUtil.getParameter(request, prefix	+ "ft20", length));
			String[] tsPrc = (JSPUtil.getParameter(request, prefix	+ "ts_prc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] railPrc = (JSPUtil.getParameter(request, prefix	+ "rail_prc", length));
			String[] usaWhfTrspTpCd = (JSPUtil.getParameter(request, prefix	+ "usa_whf_trsp_tp_cd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] whfDcRt = (JSPUtil.getParameter(request, prefix	+ "whf_dc_rt", length));
			String[] cont = (JSPUtil.getParameter(request, prefix	+ "cont", length));
			String[] teus = (JSPUtil.getParameter(request, prefix	+ "teus", length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsWhfPortRtVO();
				if (port[i] != null)
					model.setPort(port[i]);
				if (usaWhfExptFlg[i] != null)
					model.setUsaWhfExptFlg(usaWhfExptFlg[i]);
				if (ft45[i] != null)
					model.setFt45(ft45[i]);
				if (localPrc[i] != null)
					model.setLocalPrc(localPrc[i]);
				if (ft40[i] != null)
					model.setFt40(ft40[i]);
				if (usaWhfRatUtCd[i] != null)
					model.setUsaWhfRatUtCd(usaWhfRatUtCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ft20[i] != null)
					model.setFt20(ft20[i]);
				if (tsPrc[i] != null)
					model.setTsPrc(tsPrc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (railPrc[i] != null)
					model.setRailPrc(railPrc[i]);
				if (usaWhfTrspTpCd[i] != null)
					model.setUsaWhfTrspTpCd(usaWhfTrspTpCd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (whfDcRt[i] != null)
					model.setWhfDcRt(whfDcRt[i]);
				if (cont[i] != null)
					model.setCont(cont[i]);
				if (teus[i] != null)
					model.setTeus(teus[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsWhfPortRtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsWhfPortRtVO[]
	 */
	public UsWhfPortRtVO[] getUsWhfPortRtVOs(){
		UsWhfPortRtVO[] vos = (UsWhfPortRtVO[])models.toArray(new UsWhfPortRtVO[models.size()]);
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
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaWhfExptFlg = this.usaWhfExptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ft45 = this.ft45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localPrc = this.localPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ft40 = this.ft40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaWhfRatUtCd = this.usaWhfRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ft20 = this.ft20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPrc = this.tsPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railPrc = this.railPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaWhfTrspTpCd = this.usaWhfTrspTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDcRt = this.whfDcRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cont = this.cont .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teus = this.teus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SlotInternalPricingVO.java
*@FileTitle : SlotInternalPricingVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2009.09.25 임옥영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.coa.stdunitcost.sltint.vo;

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
 * @author 임옥영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SlotInternalPricingVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SlotInternalPricingVO> models = new ArrayList<SlotInternalPricingVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rtSeq = null;	
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String fmCntCd = null;
	/* Column Info */
	private String fmPortCd = null;
	/* Column Info */
	private String toCntCd = null;
	/* Column Info */
	private String toPortCd = null;	
	/* Column Info */
	private String cgoTpCd = null;
	/* Column Info */
	private String cntr20ftRtAmt = null;
	/* Column Info */
	private String cntr40ftRtAmt = null;
	/* Column Info */
	private String cntrHcRtAmt = null;
	/* Column Info */
	private String cntr45ftRtAmt = null;
	/* Column Info */
	private String effFmYrmon = null;
	/* Column Info */
	private String effToYrmon = null;
	/* Column Info */
	private String creUsrId = null;	
	/* Column Info */
	private String creDt = null;	
	/* Column Info */
	private String updUsrId = null;	
	/* Column Info */
	private String updDt = null;	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SlotInternalPricingVO() {}

	public SlotInternalPricingVO(String pagerows, 
								 String ibflag, 
								 String rtSeq, 
			                     String slanCd, 
			                     String trdCd, 
			                     String subTrdCd, 
			                     String fmCntCd, 
			                     String fmPortCd, 
			                     String toCntCd, 
			                     String toPortCd,			                     
			                     String cgoTpCd,
			                     String cntr20ftRtAmt,
			                     String cntr40ftRtAmt, 
			                     String cntrHcRtAmt, 
			                     String cntr45ftRtAmt, 
			                     String effFmYrmon, 
			                     String effToYrmon,
			                     String creUsrId, 
			                     String creDt, 
			                     String updUsrId, 
			                     String updDt) {
		
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.rtSeq = rtSeq;
		this.slanCd = slanCd;
		this.trdCd = trdCd;
		this.subTrdCd = subTrdCd;
		this.fmCntCd = fmCntCd;
		this.fmPortCd = fmPortCd;
		this.toCntCd = toCntCd;
		this.toPortCd = toPortCd;		
		this.cgoTpCd = cgoTpCd;
		this.cntr20ftRtAmt = cntr20ftRtAmt;
		this.cntr40ftRtAmt = cntr40ftRtAmt;
		this.cntrHcRtAmt = cntrHcRtAmt;
		this.cntr45ftRtAmt = cntr45ftRtAmt;		
		this.effFmYrmon = effFmYrmon;
		this.effToYrmon = effToYrmon;		
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rt_seq", getrtSeq());
		this.hashColumns.put("slan_cd", getslanCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("sub_trd_cd", getsubTrdCd());
		this.hashColumns.put("fm_cnt_cd", getfmCntCd());
		this.hashColumns.put("fm_port_cd", getfmPortCd());
		this.hashColumns.put("to_cnt_cd", gettoCntCd());
		this.hashColumns.put("to_port_cd", gettoPortCd());
		this.hashColumns.put("cgo_tp_cd", getcgoTpCd());
		this.hashColumns.put("cntr_20ft_rt_amt", getcntr20ftRtAmt());
		this.hashColumns.put("cntr_40ft_rt_amt", getcntr40ftRtAmt());
		this.hashColumns.put("cntr_hc_rt_amt", getcntrHcRtAmt());
		this.hashColumns.put("cntr_45ft_rt_amt", getcntr45ftRtAmt());
		this.hashColumns.put("eff_fm_yrmon", geteffFmYrmon());	
		this.hashColumns.put("eff_to_yrmon", geteffToYrmon());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());	
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rt_seq", "rtSeq");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("fm_cnt_cd", "fmCntCd");
		this.hashFields.put("fm_port_cd", "fmPortCd");
		this.hashFields.put("to_cnt_cd", "toCntCd");
		this.hashFields.put("to_port_cd", "toPortCd");		
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("cntr_20ft_rt_amt", "cntr20ftRtAmt");
		this.hashFields.put("cntr_40ft_rt_amt", "cntr40ftRtAmt");
		this.hashFields.put("cntr_hc_rt_amt", "cntrHcRtAmt");
		this.hashFields.put("cntr_45ft_rt_amt", "cntr45ftRtAmt");
		this.hashFields.put("eff_fm_yrmon", "effFmYrmon");
		this.hashFields.put("eff_to_yrmon", "effToYrmon");		
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		
		return this.hashFields;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * VO Data Value( seq )
	 * @return rtSeq
	 */
	public String getrtSeq() {
		return this.rtSeq;
	}	
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getslanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getsubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return fmCntCd
	 */
	public String getfmCntCd() {
		return this.fmCntCd;
	}
	
	/**
	 * Column Info
	 * @return fmPortCd
	 */
	public String getfmPortCd() {
		return this.fmPortCd;
	}
	
	/**
	 * Column Info
	 * @return toCntCd
	 */
	public String gettoCntCd() {
		return this.toCntCd;
	}
	
	/**
	 * Column Info
	 * @return toPortCd
	 */
	public String gettoPortCd() {
		return this.toPortCd;
	}	
	
	/**
	 * Column Info
	 * @return cgoTpCd
	 */
	public String getcgoTpCd() {
		return this.cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return cntr20ftRtAmt
	 */
	public String getcntr20ftRtAmt() {
		return this.cntr20ftRtAmt;
	}	
	
	/**
	 * Column Info
	 * @return cntr40ftRtAmt
	 */
	public String getcntr40ftRtAmt() {
		return this.cntr40ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @return cntrHcRtAmt
	 */
	public String getcntrHcRtAmt() {
		return this.cntrHcRtAmt;
	}
	
	/**
	 * Column Info
	 * @return cntr45ftRtAmt
	 */
	public String getcntr45ftRtAmt() {
		return this.cntr45ftRtAmt;
	}	
	
	/**
	 * Column Info
	 * @return effFmYrmon
	 */
	public String geteffFmYrmon() {
		return this.effFmYrmon;
	}
	
	/**
	 * Column Info
	 * @return effToYrmon
	 */
	public String geteffToYrmon() {
		return this.effToYrmon;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}	
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}	
	
	//------------------------------------------------ get end	
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}	
	
	/**
	 * VO Data Value( seq )
	 * @param rtSeq
	 */
	public void setrtSeq(String rtSeq) {
		this.rtSeq = rtSeq;
	}		
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setslanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setsubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param fmCntCd
	 */
	public void setfmCntCd(String fmCntCd) {
		this.fmCntCd = fmCntCd;
	}
	
	/**
	 * Column Info
	 * @param fmPortCd
	 */
	public void setfmPortCd(String fmPortCd) {
		this.fmPortCd = fmPortCd;
	}	
	
	/**
	 * Column Info
	 * @param toCntCd
	 */
	public void settoCntCd(String toCntCd) {
		this.toCntCd = toCntCd;
	}
	
	/**
	 * Column Info
	 * @param toPortCd
	 */
	public void settoPortCd(String toPortCd) {
		this.toPortCd = toPortCd;
	}		
	
	/**
	 * Column Info
	 * @param cgoTpCd
	 */
	public void setcgoTpCd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param cntr20ftRtAmt
	 */
	public void setcntr20ftRtAmt(String cntr20ftRtAmt) {
		this.cntr20ftRtAmt = cntr20ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @param cntr40ftRtAmt
	 */
	public void setcntr40ftRtAmt(String cntr40ftRtAmt) {
		this.cntr40ftRtAmt = cntr40ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @param cntrHcRtAmt
	 */
	public void setcntrHcRtAmt(String cntrHcRtAmt) {
		this.cntrHcRtAmt = cntrHcRtAmt;
	}	
	
	/**
	 * Column Info
	 * @param cntr45ftRtAmt
	 */
	public void setcntr45ftRtAmt(String cntr45ftRtAmt) {
		this.cntr45ftRtAmt = cntr45ftRtAmt;
	}	
	
	/**
	 * Column Info
	 * @param effFmYrmon
	 */
	public void seteffFmYrmon(String effFmYrmon) {
		this.effFmYrmon = effFmYrmon;
	}
	
	/**
	 * Column Info
	 * @param effToYrmon
	 */
	public void seteffToYrmon(String effToYrmon) {
		this.effToYrmon = effToYrmon;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}	
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}	
	
	//------------------------------------------------ set end	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setrtSeq(JSPUtil.getParameter(request, "rt_seq", "")); 
		setslanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", "")); 
		setsubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
		setfmCntCd(JSPUtil.getParameter(request, "fm_cnt_cd", ""));		
		setfmPortCd(JSPUtil.getParameter(request, "fm_port_cd", ""));
		settoCntCd(JSPUtil.getParameter(request, "to_cnt_cd", ""));		
		settoPortCd(JSPUtil.getParameter(request, "to_port_cd", ""));
		setcgoTpCd(JSPUtil.getParameter(request, "cgo_tp_cd", ""));
		setcntr20ftRtAmt(JSPUtil.getParameter(request, "cntr_20ft_rt_amt", ""));
		setcntr40ftRtAmt(JSPUtil.getParameter(request, "cntr_40ft_rt_amt", ""));
		setcntrHcRtAmt(JSPUtil.getParameter(request, "cntr_hc_rt_amt", ""));
		setcntr45ftRtAmt(JSPUtil.getParameter(request, "cntr_45ft_rt_amt", ""));		
		seteffFmYrmon(JSPUtil.getParameter(request, "eff_fm_yrmon", ""));
		seteffFmYrmon(JSPUtil.getParameter(request, "eff_to_yrmon", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SlotInternalPricingVO[]
	 */
	public SlotInternalPricingVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SlotInternalPricingVO[]
	 */
	public SlotInternalPricingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SlotInternalPricingVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rtSeq = (JSPUtil.getParameter(request, prefix	+ "rt_seq", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] fmCntCd = (JSPUtil.getParameter(request, prefix	+ "fm_cnt_cd", length));			
			String[] fmPortCd = (JSPUtil.getParameter(request, prefix	+ "fm_port_cd", length));
			String[] toCntCd = (JSPUtil.getParameter(request, prefix	+ "to_cnt_cd", length));			
			String[] toPortCd = (JSPUtil.getParameter(request, prefix	+ "to_port_cd", length));			
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));			
			String[] cntr20ftRtAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_20ft_rt_amt", length));
			String[] cntr40ftRtAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_40ft_rt_amt", length));
			String[] cntrHcRtAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_hc_rt_amt", length));
			String[] cntr45ftRtAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_45ft_rt_amt", length));
			String[] effFmYrmon = (JSPUtil.getParameter(request, prefix	+ "eff_fm_yrmon", length));
			String[] effToYrmon = (JSPUtil.getParameter(request, prefix	+ "eff_to_yrmon", length));			
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SlotInternalPricingVO();

				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rtSeq[i] != null)
					model.setrtSeq(rtSeq[i]);					
				if (slanCd[i] != null)
					model.setslanCd(slanCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (subTrdCd[i] != null)
					model.setsubTrdCd(subTrdCd[i]);
				if (fmCntCd[i] != null)
					model.setfmCntCd(fmCntCd[i]);
				if (fmPortCd[i] != null)
					model.setfmPortCd(fmPortCd[i]);
				if (toCntCd[i] != null)
					model.settoCntCd(toCntCd[i]);
				if (toPortCd[i] != null)
					model.settoPortCd(toPortCd[i]);
				if (cgoTpCd[i] != null)
					model.setcgoTpCd(cgoTpCd[i]);
				if (cntr20ftRtAmt[i] != null)
					model.setcntr20ftRtAmt(cntr20ftRtAmt[i]);				
				if (cntr40ftRtAmt[i] != null)
					model.setcntr40ftRtAmt(cntr40ftRtAmt[i]);
				if (cntrHcRtAmt[i] != null)
					model.setcntrHcRtAmt(cntrHcRtAmt[i]);
				if (cntr45ftRtAmt[i] != null)
					model.setcntr45ftRtAmt(cntr45ftRtAmt[i]);
				if (effFmYrmon[i] != null)
					model.seteffFmYrmon(effFmYrmon[i]);
				if (effToYrmon[i] != null)
					model.seteffToYrmon(effToYrmon[i]);				
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);				
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);	
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);				
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSlotInternalPricingVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SlotInternalPricingVO[]
	 */
	public SlotInternalPricingVO[] getSlotInternalPricingVOs(){
		SlotInternalPricingVO[] vos = (SlotInternalPricingVO[])models.toArray(new SlotInternalPricingVO[models.size()]);
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
		
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSeq = this.rtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmCntCd = this.fmCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.fmPortCd = this.fmPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCntCd = this.toCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.toPortCd = this.toPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr20ftRtAmt = this.cntr20ftRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr40ftRtAmt = this.cntr40ftRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHcRtAmt = this.cntrHcRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr45ftRtAmt = this.cntr45ftRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.effFmYrmon = this.effFmYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effToYrmon = this.effToYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

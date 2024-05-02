/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomStndHirVO.java
*@FileTitle : CustomStndHirVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.05.18 최우석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 최우석
 * @see
 * @since J2EE 1.5
 */

public class CustomStndHirVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomStndHirVO> models = new ArrayList<CustomStndHirVO>();
	
	/* Column Info */
	private String saveType = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String stnd14tonHirAmt = null;
	/* Column Info */
	private String mktRtAplyFlg1 = null;
	/* Column Info */
	private String hirRtN1stAmt = null;
	/* Column Info */
	private String teu14tonRtAmt = null;
	/* Column Info */
	private String stndMaxHirAmt = null;
	/* Column Info */
	private String hirRtN2ndAmt = null;
	/* Column Info */
	private String diffStnd14tonHirAmt = null;
	/* Column Info */
	private String maxTeuRtAmt = null;
	/* Column Info */
	private String bse14tonVslCapa = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String vslCntCd = null;
	/* Column Info */
	private String hbYrmon = null;
	/* Column Info */
	private String diffStndMaxHirAmt = null;
	/* Column Info */
	private String vslDzndCapa = null;
	/* Column Info */
	private String fletCtrtTpCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String mktRtAplyFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String fletCtrtNo = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String vslKrnNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomStndHirVO() {}

	public CustomStndHirVO(String ibflag, String pagerows, String fletCtrtNo, String hbYrmon, String vslCd, String fletCtrtTpCd, String vslEngNm, String vslKrnNm, String vslCntCd, String mktRtAplyFlg, String mktRtAplyFlg1, String vslDzndCapa, String bse14tonVslCapa, String hirRtN1stAmt, String hirRtN2ndAmt, String maxTeuRtAmt, String stndMaxHirAmt, String diffStndMaxHirAmt, String teu14tonRtAmt, String stnd14tonHirAmt, String diffStnd14tonHirAmt, String creUsrId, String updUsrId, String saveType) {
		this.saveType = saveType;
		this.ibflag = ibflag;
		this.stnd14tonHirAmt = stnd14tonHirAmt;
		this.mktRtAplyFlg1 = mktRtAplyFlg1;
		this.hirRtN1stAmt = hirRtN1stAmt;
		this.teu14tonRtAmt = teu14tonRtAmt;
		this.stndMaxHirAmt = stndMaxHirAmt;
		this.hirRtN2ndAmt = hirRtN2ndAmt;
		this.diffStnd14tonHirAmt = diffStnd14tonHirAmt;
		this.maxTeuRtAmt = maxTeuRtAmt;
		this.bse14tonVslCapa = bse14tonVslCapa;
		this.updUsrId = updUsrId;
		this.vslCntCd = vslCntCd;
		this.hbYrmon = hbYrmon;
		this.diffStndMaxHirAmt = diffStndMaxHirAmt;
		this.vslDzndCapa = vslDzndCapa;
		this.fletCtrtTpCd = fletCtrtTpCd;
		this.vslCd = vslCd;
		this.mktRtAplyFlg = mktRtAplyFlg;
		this.creUsrId = creUsrId;
		this.fletCtrtNo = fletCtrtNo;
		this.vslEngNm = vslEngNm;
		this.vslKrnNm = vslKrnNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("save_type", getSaveType());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("stnd_14ton_hir_amt", getStnd14tonHirAmt());
		this.hashColumns.put("mkt_rt_aply_flg1", getMktRtAplyFlg1());
		this.hashColumns.put("hir_rt_n1st_amt", getHirRtN1stAmt());
		this.hashColumns.put("teu_14ton_rt_amt", getTeu14tonRtAmt());
		this.hashColumns.put("stnd_max_hir_amt", getStndMaxHirAmt());
		this.hashColumns.put("hir_rt_n2nd_amt", getHirRtN2ndAmt());
		this.hashColumns.put("diff_stnd_14ton_hir_amt", getDiffStnd14tonHirAmt());
		this.hashColumns.put("max_teu_rt_amt", getMaxTeuRtAmt());
		this.hashColumns.put("bse_14ton_vsl_capa", getBse14tonVslCapa());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("vsl_cnt_cd", getVslCntCd());
		this.hashColumns.put("hb_yrmon", getHbYrmon());
		this.hashColumns.put("diff_stnd_max_hir_amt", getDiffStndMaxHirAmt());
		this.hashColumns.put("vsl_dznd_capa", getVslDzndCapa());
		this.hashColumns.put("flet_ctrt_tp_cd", getFletCtrtTpCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("mkt_rt_aply_flg", getMktRtAplyFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("vsl_krn_nm", getVslKrnNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("save_type", "saveType");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("stnd_14ton_hir_amt", "stnd14tonHirAmt");
		this.hashFields.put("mkt_rt_aply_flg1", "mktRtAplyFlg1");
		this.hashFields.put("hir_rt_n1st_amt", "hirRtN1stAmt");
		this.hashFields.put("teu_14ton_rt_amt", "teu14tonRtAmt");
		this.hashFields.put("stnd_max_hir_amt", "stndMaxHirAmt");
		this.hashFields.put("hir_rt_n2nd_amt", "hirRtN2ndAmt");
		this.hashFields.put("diff_stnd_14ton_hir_amt", "diffStnd14tonHirAmt");
		this.hashFields.put("max_teu_rt_amt", "maxTeuRtAmt");
		this.hashFields.put("bse_14ton_vsl_capa", "bse14tonVslCapa");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("vsl_cnt_cd", "vslCntCd");
		this.hashFields.put("hb_yrmon", "hbYrmon");
		this.hashFields.put("diff_stnd_max_hir_amt", "diffStndMaxHirAmt");
		this.hashFields.put("vsl_dznd_capa", "vslDzndCapa");
		this.hashFields.put("flet_ctrt_tp_cd", "fletCtrtTpCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("mkt_rt_aply_flg", "mktRtAplyFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("vsl_krn_nm", "vslKrnNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getSaveType() {
		return this.saveType;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getStnd14tonHirAmt() {
		return this.stnd14tonHirAmt;
	}
	public String getMktRtAplyFlg1() {
		return this.mktRtAplyFlg1;
	}
	public String getHirRtN1stAmt() {
		return this.hirRtN1stAmt;
	}
	public String getTeu14tonRtAmt() {
		return this.teu14tonRtAmt;
	}
	public String getStndMaxHirAmt() {
		return this.stndMaxHirAmt;
	}
	public String getHirRtN2ndAmt() {
		return this.hirRtN2ndAmt;
	}
	public String getDiffStnd14tonHirAmt() {
		return this.diffStnd14tonHirAmt;
	}
	public String getMaxTeuRtAmt() {
		return this.maxTeuRtAmt;
	}
	public String getBse14tonVslCapa() {
		return this.bse14tonVslCapa;
	}
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getVslCntCd() {
		return this.vslCntCd;
	}
	public String getHbYrmon() {
		return this.hbYrmon;
	}
	public String getDiffStndMaxHirAmt() {
		return this.diffStndMaxHirAmt;
	}
	public String getVslDzndCapa() {
		return this.vslDzndCapa;
	}
	public String getFletCtrtTpCd() {
		return this.fletCtrtTpCd;
	}
	public String getVslCd() {
		return this.vslCd;
	}
	public String getMktRtAplyFlg() {
		return this.mktRtAplyFlg;
	}
	public String getCreUsrId() {
		return this.creUsrId;
	}
	public String getFletCtrtNo() {
		return this.fletCtrtNo;
	}
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	public String getVslKrnNm() {
		return this.vslKrnNm;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setSaveType(String saveType) {
		this.saveType = saveType;
		//this.saveType=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setStnd14tonHirAmt(String stnd14tonHirAmt) {
		this.stnd14tonHirAmt = stnd14tonHirAmt;
		//this.stnd14tonHirAmt=true;
	}
	public void setMktRtAplyFlg1(String mktRtAplyFlg1) {
		this.mktRtAplyFlg1 = mktRtAplyFlg1;
		//this.mktRtAplyFlg1=true;
	}
	public void setHirRtN1stAmt(String hirRtN1stAmt) {
		this.hirRtN1stAmt = hirRtN1stAmt;
		//this.hirRtN1stAmt=true;
	}
	public void setTeu14tonRtAmt(String teu14tonRtAmt) {
		this.teu14tonRtAmt = teu14tonRtAmt;
		//this.teu14tonRtAmt=true;
	}
	public void setStndMaxHirAmt(String stndMaxHirAmt) {
		this.stndMaxHirAmt = stndMaxHirAmt;
		//this.stndMaxHirAmt=true;
	}
	public void setHirRtN2ndAmt(String hirRtN2ndAmt) {
		this.hirRtN2ndAmt = hirRtN2ndAmt;
		//this.hirRtN2ndAmt=true;
	}
	public void setDiffStnd14tonHirAmt(String diffStnd14tonHirAmt) {
		this.diffStnd14tonHirAmt = diffStnd14tonHirAmt;
		//this.diffStnd14tonHirAmt=true;
	}
	public void setMaxTeuRtAmt(String maxTeuRtAmt) {
		this.maxTeuRtAmt = maxTeuRtAmt;
		//this.maxTeuRtAmt=true;
	}
	public void setBse14tonVslCapa(String bse14tonVslCapa) {
		this.bse14tonVslCapa = bse14tonVslCapa;
		//this.bse14tonVslCapa=true;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setVslCntCd(String vslCntCd) {
		this.vslCntCd = vslCntCd;
		//this.vslCntCd=true;
	}
	public void setHbYrmon(String hbYrmon) {
		this.hbYrmon = hbYrmon;
		//this.hbYrmon=true;
	}
	public void setDiffStndMaxHirAmt(String diffStndMaxHirAmt) {
		this.diffStndMaxHirAmt = diffStndMaxHirAmt;
		//this.diffStndMaxHirAmt=true;
	}
	public void setVslDzndCapa(String vslDzndCapa) {
		this.vslDzndCapa = vslDzndCapa;
		//this.vslDzndCapa=true;
	}
	public void setFletCtrtTpCd(String fletCtrtTpCd) {
		this.fletCtrtTpCd = fletCtrtTpCd;
		//this.fletCtrtTpCd=true;
	}
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
		//this.vslCd=true;
	}
	public void setMktRtAplyFlg(String mktRtAplyFlg) {
		this.mktRtAplyFlg = mktRtAplyFlg;
		//this.mktRtAplyFlg=true;
	}
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		//this.creUsrId=true;
	}
	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
		//this.fletCtrtNo=true;
	}
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
		//this.vslEngNm=true;
	}
	public void setVslKrnNm(String vslKrnNm) {
		this.vslKrnNm = vslKrnNm;
		//this.vslKrnNm=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setSaveType(JSPUtil.getParameter(request, "saveType", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setStnd14tonHirAmt(JSPUtil.getParameter(request, "stnd_14ton_hir_amt", ""));
		setMktRtAplyFlg1(JSPUtil.getParameter(request, "mkt_rt_aply_flg1", ""));
		setHirRtN1stAmt(JSPUtil.getParameter(request, "hir_rt_n1st_amt", ""));
		setTeu14tonRtAmt(JSPUtil.getParameter(request, "teu_14ton_rt_amt", ""));
		setStndMaxHirAmt(JSPUtil.getParameter(request, "stnd_max_hir_amt", ""));
		setHirRtN2ndAmt(JSPUtil.getParameter(request, "hir_rt_n2nd_amt", ""));
		setDiffStnd14tonHirAmt(JSPUtil.getParameter(request, "diff_stnd_14ton_hir_amt", ""));
		setMaxTeuRtAmt(JSPUtil.getParameter(request, "max_teu_rt_amt", ""));
		setBse14tonVslCapa(JSPUtil.getParameter(request, "bse_14ton_vsl_capa", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setVslCntCd(JSPUtil.getParameter(request, "vsl_cnt_cd", ""));
		setHbYrmon(JSPUtil.getParameter(request, "hb_yrmon", ""));
		setDiffStndMaxHirAmt(JSPUtil.getParameter(request, "diff_stnd_max_hir_amt", ""));
		setVslDzndCapa(JSPUtil.getParameter(request, "vsl_dznd_capa", ""));
		setFletCtrtTpCd(JSPUtil.getParameter(request, "flet_ctrt_tp_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setMktRtAplyFlg(JSPUtil.getParameter(request, "mkt_rt_aply_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setVslKrnNm(JSPUtil.getParameter(request, "vsl_krn_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public CustomStndHirVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CustomStndHirVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomStndHirVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] saveType = (JSPUtil.getParameter(request, prefix	+ "save_type".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] stnd14tonHirAmt = (JSPUtil.getParameter(request, prefix	+ "stnd_14ton_hir_amt".trim(), length));
			String[] mktRtAplyFlg1 = (JSPUtil.getParameter(request, prefix	+ "mkt_rt_aply_flg1".trim(), length));
			String[] hirRtN1stAmt = (JSPUtil.getParameter(request, prefix	+ "hir_rt_n1st_amt".trim(), length));
			String[] teu14tonRtAmt = (JSPUtil.getParameter(request, prefix	+ "teu_14ton_rt_amt".trim(), length));
			String[] stndMaxHirAmt = (JSPUtil.getParameter(request, prefix	+ "stnd_max_hir_amt".trim(), length));
			String[] hirRtN2ndAmt = (JSPUtil.getParameter(request, prefix	+ "hir_rt_n2nd_amt".trim(), length));
			String[] diffStnd14tonHirAmt = (JSPUtil.getParameter(request, prefix	+ "diff_stnd_14ton_hir_amt".trim(), length));
			String[] maxTeuRtAmt = (JSPUtil.getParameter(request, prefix	+ "max_teu_rt_amt".trim(), length));
			String[] bse14tonVslCapa = (JSPUtil.getParameter(request, prefix	+ "bse_14ton_vsl_capa".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] vslCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cnt_cd".trim(), length));
			String[] hbYrmon = (JSPUtil.getParameter(request, prefix	+ "hb_yrmon".trim(), length));
			String[] diffStndMaxHirAmt = (JSPUtil.getParameter(request, prefix	+ "diff_stnd_max_hir_amt".trim(), length));
			String[] vslDzndCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_dznd_capa".trim(), length));
			String[] fletCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_tp_cd".trim(), length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] mktRtAplyFlg = (JSPUtil.getParameter(request, prefix	+ "mkt_rt_aply_flg".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no".trim(), length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm".trim(), length));
			String[] vslKrnNm = (JSPUtil.getParameter(request, prefix	+ "vsl_krn_nm".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomStndHirVO();
				if (saveType[i] != null)
					model.setSaveType(saveType[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (stnd14tonHirAmt[i] != null)
					model.setStnd14tonHirAmt(stnd14tonHirAmt[i]);
				if (mktRtAplyFlg1[i] != null)
					model.setMktRtAplyFlg1(mktRtAplyFlg1[i]);
				if (hirRtN1stAmt[i] != null)
					model.setHirRtN1stAmt(hirRtN1stAmt[i]);
				if (teu14tonRtAmt[i] != null)
					model.setTeu14tonRtAmt(teu14tonRtAmt[i]);
				if (stndMaxHirAmt[i] != null)
					model.setStndMaxHirAmt(stndMaxHirAmt[i]);
				if (hirRtN2ndAmt[i] != null)
					model.setHirRtN2ndAmt(hirRtN2ndAmt[i]);
				if (diffStnd14tonHirAmt[i] != null)
					model.setDiffStnd14tonHirAmt(diffStnd14tonHirAmt[i]);
				if (maxTeuRtAmt[i] != null)
					model.setMaxTeuRtAmt(maxTeuRtAmt[i]);
				if (bse14tonVslCapa[i] != null)
					model.setBse14tonVslCapa(bse14tonVslCapa[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (vslCntCd[i] != null)
					model.setVslCntCd(vslCntCd[i]);
				if (hbYrmon[i] != null)
					model.setHbYrmon(hbYrmon[i]);
				if (diffStndMaxHirAmt[i] != null)
					model.setDiffStndMaxHirAmt(diffStndMaxHirAmt[i]);
				if (vslDzndCapa[i] != null)
					model.setVslDzndCapa(vslDzndCapa[i]);
				if (fletCtrtTpCd[i] != null)
					model.setFletCtrtTpCd(fletCtrtTpCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (mktRtAplyFlg[i] != null)
					model.setMktRtAplyFlg(mktRtAplyFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (vslKrnNm[i] != null)
					model.setVslKrnNm(vslKrnNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getCustomStndHirVOs();
	}

	public CustomStndHirVO[] getCustomStndHirVOs(){
		CustomStndHirVO[] vos = (CustomStndHirVO[])models.toArray(new CustomStndHirVO[models.size()]);
		return vos;
	}
	
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
		} catch (Exception ex) {}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.saveType = this.saveType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stnd14tonHirAmt = this.stnd14tonHirAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mktRtAplyFlg1 = this.mktRtAplyFlg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hirRtN1stAmt = this.hirRtN1stAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu14tonRtAmt = this.teu14tonRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndMaxHirAmt = this.stndMaxHirAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hirRtN2ndAmt = this.hirRtN2ndAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffStnd14tonHirAmt = this.diffStnd14tonHirAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxTeuRtAmt = this.maxTeuRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bse14tonVslCapa = this.bse14tonVslCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCntCd = this.vslCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hbYrmon = this.hbYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffStndMaxHirAmt = this.diffStndMaxHirAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDzndCapa = this.vslDzndCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtTpCd = this.fletCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mktRtAplyFlg = this.mktRtAplyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslKrnNm = this.vslKrnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

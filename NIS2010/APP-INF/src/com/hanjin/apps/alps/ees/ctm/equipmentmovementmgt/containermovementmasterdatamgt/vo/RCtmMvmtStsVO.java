/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RCtmMvmtStsVO.java
*@FileTitle : RCtmMvmtStsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.04.27 우경민
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * TBL : CTM_MVMT_STS<br>
 * - searchMVMTStatusList 조회 처리 <br>
 * - searchLogicsServiceProvider에서 호출. Vender List<br>
 *
 * @see 추가(Tabel_Template CVS UPDATE)
 * @author 우경민
 * @since J2EE 1.5
 */
public class RCtmMvmtStsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<RCtmMvmtStsVO> models = new ArrayList<RCtmMvmtStsVO>();

	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String mvmtStsNm = null;
	/* Column Info */
	private String destYdFlg = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	/* Log출력 */
	private Logger log = Logger.getLogger("org.apache.log4j.Logger");

	/* 생성자 */
	public RCtmMvmtStsVO() {}

	/* 생성자 */
	public RCtmMvmtStsVO(String ibflag, String pagerows, String mvmtStsCd, String mvmtStsNm, String destYdFlg, String ioBndCd) {
		this.ibflag = ibflag;
		this.mvmtStsNm = mvmtStsNm;
		this.destYdFlg = destYdFlg;
		this.ioBndCd = ioBndCd;
		this.mvmtStsCd = mvmtStsCd;
		this.pagerows = pagerows;
	}

	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mvmt_sts_nm", getMvmtStsNm());
		this.hashColumns.put("dest_yd_flg", getDestYdFlg());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mvmt_sts_nm", "mvmtStsNm");
		this.hashFields.put("dest_yd_flg", "destYdFlg");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	public String getIbflag() {
		return this.ibflag;
	}
	public String getMvmtStsNm() {
		return this.mvmtStsNm;
	}
	public String getDestYdFlg() {
		return this.destYdFlg;
	}
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	public String getMvmtStsCd() {
		return this.mvmtStsCd;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setMvmtStsNm(String mvmtStsNm) {
		this.mvmtStsNm = mvmtStsNm;
		//this.mvmtStsNm=true;
	}
	public void setDestYdFlg(String destYdFlg) {
		this.destYdFlg = destYdFlg;
		//this.destYdFlg=true;
	}
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
		//this.ioBndCd=true;
	}
	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
		//this.mvmtStsCd=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMvmtStsNm(JSPUtil.getParameter(request, "mvmt_sts_nm", ""));
		setDestYdFlg(JSPUtil.getParameter(request, "dest_yd_flg", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, "mvmt_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public RCtmMvmtStsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public RCtmMvmtStsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RCtmMvmtStsVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] mvmtStsNm = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_nm".trim(), length));
			String[] destYdFlg = (JSPUtil.getParameter(request, prefix	+ "dest_yd_flg".trim(), length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd".trim(), length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new RCtmMvmtStsVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mvmtStsNm[i] != null)
					model.setMvmtStsNm(mvmtStsNm[i]);
				if (destYdFlg[i] != null)
					model.setDestYdFlg(destYdFlg[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {log.error("err " + e.toString(), e);}
		return getRCtmMvmtStsVOs();
	}

	public RCtmMvmtStsVO[] getRCtmMvmtStsVOs(){
		RCtmMvmtStsVO[] vos = (RCtmMvmtStsVO[])models.toArray(new RCtmMvmtStsVO[models.size()]);
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
		} catch (Exception ex) {log.error("err " + ex.toString(), ex);}
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsNm = this.mvmtStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destYdFlg = this.destYdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

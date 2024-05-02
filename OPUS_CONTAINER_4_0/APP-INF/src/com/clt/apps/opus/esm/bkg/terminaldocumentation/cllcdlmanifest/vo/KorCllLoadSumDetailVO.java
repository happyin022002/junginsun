/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCllLoadSumDetailVO.java
*@FileTitle : KorCllLoadSumDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier :
*@LastVersion : 1.0
* 2009.08.21
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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

public class KorCllLoadSumDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorCllLoadSumDetailVO> models = new ArrayList<KorCllLoadSumDetailVO>();

	/* Column Info */
	private String ts45 = null;
	/* Column Info */
	private String gubunCd3 = null;
	/* Column Info */
	private String gubunCd2 = null;
	/* Column Info */
	private String local40h = null;
	/* Column Info */
	private String wgtMt = null;
	/* Column Info */
	private String mty45 = null;
	/* Column Info */
	private String ts20 = null;
	/* Column Info */
	private String mty20 = null;
	/* Column Info */
	private String orderGubun = null;
	/* Column Info */
	private String local20 = null;
	/* Column Info */
	private String gubunCd = null;
	/* Column Info */
	private String sum20 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sum45 = null;
	/* Column Info */
	private String local45 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sum40h = null;
	/* Column Info */
	private String mty40h = null;
	/* Column Info */
	private String ts40h = null;
	/* Column Info */
	private String sum40 = null;
	/* Column Info */
	private String mty40 = null;
	/* Column Info */
	private String local40 = null;
	/* Column Info */
	private String ts40 = null;
	/* Column Info */
	private String vgmMt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorCllLoadSumDetailVO() {}

	public KorCllLoadSumDetailVO(String ibflag, String pagerows, String gubunCd, String gubunCd2, String gubunCd3, String orderGubun, String local40h, String local40, String local20, String local45, String ts40h, String ts40, String ts20, String ts45, String mty40h, String mty40, String mty20, String mty45, String sum40h, String sum40, String sum20, String sum45, String wgtMt, String vgmMt) {
		this.ts45 = ts45;
		this.gubunCd3 = gubunCd3;
		this.gubunCd2 = gubunCd2;
		this.local40h = local40h;
		this.wgtMt = wgtMt;
		this.mty45 = mty45;
		this.ts20 = ts20;
		this.mty20 = mty20;
		this.orderGubun = orderGubun;
		this.local20 = local20;
		this.gubunCd = gubunCd;
		this.sum20 = sum20;
		this.pagerows = pagerows;
		this.sum45 = sum45;
		this.local45 = local45;
		this.ibflag = ibflag;
		this.sum40h = sum40h;
		this.mty40h = mty40h;
		this.ts40h = ts40h;
		this.sum40 = sum40;
		this.mty40 = mty40;
		this.local40 = local40;
		this.ts40 = ts40;
		this.vgmMt = vgmMt;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ts_45", getTs45());
		this.hashColumns.put("gubun_cd3", getGubunCd3());
		this.hashColumns.put("gubun_cd2", getGubunCd2());
		this.hashColumns.put("local_40h", getLocal40h());
		this.hashColumns.put("wgt_mt", getWgtMt());
		this.hashColumns.put("mty_45", getMty45());
		this.hashColumns.put("ts_20", getTs20());
		this.hashColumns.put("mty_20", getMty20());
		this.hashColumns.put("order_gubun", getOrderGubun());
		this.hashColumns.put("local_20", getLocal20());
		this.hashColumns.put("gubun_cd", getGubunCd());
		this.hashColumns.put("sum_20", getSum20());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sum_45", getSum45());
		this.hashColumns.put("local_45", getLocal45());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sum_40h", getSum40h());
		this.hashColumns.put("mty_40h", getMty40h());
		this.hashColumns.put("ts_40h", getTs40h());
		this.hashColumns.put("sum_40", getSum40());
		this.hashColumns.put("mty_40", getMty40());
		this.hashColumns.put("local_40", getLocal40());
		this.hashColumns.put("ts_40", getTs40());
		this.hashColumns.put("vgm_mt", getVgmMt());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ts_45", "ts45");
		this.hashFields.put("gubun_cd3", "gubunCd3");
		this.hashFields.put("gubun_cd2", "gubunCd2");
		this.hashFields.put("local_40h", "local40h");
		this.hashFields.put("wgt_mt", "wgtMt");
		this.hashFields.put("mty_45", "mty45");
		this.hashFields.put("ts_20", "ts20");
		this.hashFields.put("mty_20", "mty20");
		this.hashFields.put("order_gubun", "orderGubun");
		this.hashFields.put("local_20", "local20");
		this.hashFields.put("gubun_cd", "gubunCd");
		this.hashFields.put("sum_20", "sum20");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sum_45", "sum45");
		this.hashFields.put("local_45", "local45");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sum_40h", "sum40h");
		this.hashFields.put("mty_40h", "mty40h");
		this.hashFields.put("ts_40h", "ts40h");
		this.hashFields.put("sum_40", "sum40");
		this.hashFields.put("mty_40", "mty40");
		this.hashFields.put("local_40", "local40");
		this.hashFields.put("ts_40", "ts40");
		this.hashFields.put("vgm_mt", "vgmMt");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return ts45
	 */
	public String getTs45() {
		return this.ts45;
	}

	/**
	 * Column Info
	 * @return gubunCd3
	 */
	public String getGubunCd3() {
		return this.gubunCd3;
	}

	/**
	 * Column Info
	 * @return gubunCd2
	 */
	public String getGubunCd2() {
		return this.gubunCd2;
	}

	/**
	 * Column Info
	 * @return local40h
	 */
	public String getLocal40h() {
		return this.local40h;
	}

	/**
	 * Column Info
	 * @return wgtMt
	 */
	public String getWgtMt() {
		return this.wgtMt;
	}

	/**
	 * Column Info
	 * @return mty45
	 */
	public String getMty45() {
		return this.mty45;
	}

	/**
	 * Column Info
	 * @return ts20
	 */
	public String getTs20() {
		return this.ts20;
	}

	/**
	 * Column Info
	 * @return mty20
	 */
	public String getMty20() {
		return this.mty20;
	}

	/**
	 * Column Info
	 * @return orderGubun
	 */
	public String getOrderGubun() {
		return this.orderGubun;
	}

	/**
	 * Column Info
	 * @return local20
	 */
	public String getLocal20() {
		return this.local20;
	}

	/**
	 * Column Info
	 * @return gubunCd
	 */
	public String getGubunCd() {
		return this.gubunCd;
	}

	/**
	 * Column Info
	 * @return sum20
	 */
	public String getSum20() {
		return this.sum20;
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
	 * @return sum45
	 */
	public String getSum45() {
		return this.sum45;
	}

	/**
	 * Column Info
	 * @return local45
	 */
	public String getLocal45() {
		return this.local45;
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
	 * @return sum40h
	 */
	public String getSum40h() {
		return this.sum40h;
	}

	/**
	 * Column Info
	 * @return mty40h
	 */
	public String getMty40h() {
		return this.mty40h;
	}

	/**
	 * Column Info
	 * @return ts40h
	 */
	public String getTs40h() {
		return this.ts40h;
	}

	/**
	 * Column Info
	 * @return sum40
	 */
	public String getSum40() {
		return this.sum40;
	}

	/**
	 * Column Info
	 * @return mty40
	 */
	public String getMty40() {
		return this.mty40;
	}

	/**
	 * Column Info
	 * @return local40
	 */
	public String getLocal40() {
		return this.local40;
	}

	/**
	 * Column Info
	 * @return ts40
	 */
	public String getTs40() {
		return this.ts40;
	}
	
	/**
	 * Column Info
	 * @return vgmMt
	 */
	public String getVgmMt() {
		return this.vgmMt;
	}


	/**
	 * Column Info
	 * @param ts45
	 */
	public void setTs45(String ts45) {
		this.ts45 = ts45;
	}

	/**
	 * Column Info
	 * @param gubunCd3
	 */
	public void setGubunCd3(String gubunCd3) {
		this.gubunCd3 = gubunCd3;
	}

	/**
	 * Column Info
	 * @param gubunCd2
	 */
	public void setGubunCd2(String gubunCd2) {
		this.gubunCd2 = gubunCd2;
	}

	/**
	 * Column Info
	 * @param local40h
	 */
	public void setLocal40h(String local40h) {
		this.local40h = local40h;
	}

	/**
	 * Column Info
	 * @param wgtMt
	 */
	public void setWgtMt(String wgtMt) {
		this.wgtMt = wgtMt;
	}

	/**
	 * Column Info
	 * @param mty45
	 */
	public void setMty45(String mty45) {
		this.mty45 = mty45;
	}

	/**
	 * Column Info
	 * @param ts20
	 */
	public void setTs20(String ts20) {
		this.ts20 = ts20;
	}

	/**
	 * Column Info
	 * @param mty20
	 */
	public void setMty20(String mty20) {
		this.mty20 = mty20;
	}

	/**
	 * Column Info
	 * @param orderGubun
	 */
	public void setOrderGubun(String orderGubun) {
		this.orderGubun = orderGubun;
	}

	/**
	 * Column Info
	 * @param local20
	 */
	public void setLocal20(String local20) {
		this.local20 = local20;
	}

	/**
	 * Column Info
	 * @param gubunCd
	 */
	public void setGubunCd(String gubunCd) {
		this.gubunCd = gubunCd;
	}

	/**
	 * Column Info
	 * @param sum20
	 */
	public void setSum20(String sum20) {
		this.sum20 = sum20;
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
	 * @param sum45
	 */
	public void setSum45(String sum45) {
		this.sum45 = sum45;
	}

	/**
	 * Column Info
	 * @param local45
	 */
	public void setLocal45(String local45) {
		this.local45 = local45;
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
	 * @param sum40h
	 */
	public void setSum40h(String sum40h) {
		this.sum40h = sum40h;
	}

	/**
	 * Column Info
	 * @param mty40h
	 */
	public void setMty40h(String mty40h) {
		this.mty40h = mty40h;
	}

	/**
	 * Column Info
	 * @param ts40h
	 */
	public void setTs40h(String ts40h) {
		this.ts40h = ts40h;
	}

	/**
	 * Column Info
	 * @param sum40
	 */
	public void setSum40(String sum40) {
		this.sum40 = sum40;
	}

	/**
	 * Column Info
	 * @param mty40
	 */
	public void setMty40(String mty40) {
		this.mty40 = mty40;
	}

	/**
	 * Column Info
	 * @param local40
	 */
	public void setLocal40(String local40) {
		this.local40 = local40;
	}

	/**
	 * Column Info
	 * @param ts40
	 */
	public void setTs40(String ts40) {
		this.ts40 = ts40;
	}
	
	/**
	 * Column Info
	 * @param vgmMt
	 */
	public void setVgmMt(String vgmMt) {
		this.vgmMt = vgmMt;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTs45(JSPUtil.getParameter(request, "ts_45", ""));
		setGubunCd3(JSPUtil.getParameter(request, "gubun_cd3", ""));
		setGubunCd2(JSPUtil.getParameter(request, "gubun_cd2", ""));
		setLocal40h(JSPUtil.getParameter(request, "local_40h", ""));
		setWgtMt(JSPUtil.getParameter(request, "wgt_mt", ""));
		setMty45(JSPUtil.getParameter(request, "mty_45", ""));
		setTs20(JSPUtil.getParameter(request, "ts_20", ""));
		setMty20(JSPUtil.getParameter(request, "mty_20", ""));
		setOrderGubun(JSPUtil.getParameter(request, "order_gubun", ""));
		setLocal20(JSPUtil.getParameter(request, "local_20", ""));
		setGubunCd(JSPUtil.getParameter(request, "gubun_cd", ""));
		setSum20(JSPUtil.getParameter(request, "sum_20", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSum45(JSPUtil.getParameter(request, "sum_45", ""));
		setLocal45(JSPUtil.getParameter(request, "local_45", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSum40h(JSPUtil.getParameter(request, "sum_40h", ""));
		setMty40h(JSPUtil.getParameter(request, "mty_40h", ""));
		setTs40h(JSPUtil.getParameter(request, "ts_40h", ""));
		setSum40(JSPUtil.getParameter(request, "sum_40", ""));
		setMty40(JSPUtil.getParameter(request, "mty_40", ""));
		setLocal40(JSPUtil.getParameter(request, "local_40", ""));
		setTs40(JSPUtil.getParameter(request, "ts_40", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorCllLoadSumDetailVO[]
	 */
	public KorCllLoadSumDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorCllLoadSumDetailVO[]
	 */
	public KorCllLoadSumDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorCllLoadSumDetailVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ts45 = (JSPUtil.getParameter(request, prefix	+ "ts_45", length));
			String[] gubunCd3 = (JSPUtil.getParameter(request, prefix	+ "gubun_cd3", length));
			String[] gubunCd2 = (JSPUtil.getParameter(request, prefix	+ "gubun_cd2", length));
			String[] local40h = (JSPUtil.getParameter(request, prefix	+ "local_40h", length));
			String[] wgtMt = (JSPUtil.getParameter(request, prefix	+ "wgt_mt", length));
			String[] mty45 = (JSPUtil.getParameter(request, prefix	+ "mty_45", length));
			String[] ts20 = (JSPUtil.getParameter(request, prefix	+ "ts_20", length));
			String[] mty20 = (JSPUtil.getParameter(request, prefix	+ "mty_20", length));
			String[] orderGubun = (JSPUtil.getParameter(request, prefix	+ "order_gubun", length));
			String[] local20 = (JSPUtil.getParameter(request, prefix	+ "local_20", length));
			String[] gubunCd = (JSPUtil.getParameter(request, prefix	+ "gubun_cd", length));
			String[] sum20 = (JSPUtil.getParameter(request, prefix	+ "sum_20", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sum45 = (JSPUtil.getParameter(request, prefix	+ "sum_45", length));
			String[] local45 = (JSPUtil.getParameter(request, prefix	+ "local_45", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sum40h = (JSPUtil.getParameter(request, prefix	+ "sum_40h", length));
			String[] mty40h = (JSPUtil.getParameter(request, prefix	+ "mty_40h", length));
			String[] ts40h = (JSPUtil.getParameter(request, prefix	+ "ts_40h", length));
			String[] sum40 = (JSPUtil.getParameter(request, prefix	+ "sum_40", length));
			String[] mty40 = (JSPUtil.getParameter(request, prefix	+ "mty_40", length));
			String[] local40 = (JSPUtil.getParameter(request, prefix	+ "local_40", length));
			String[] ts40 = (JSPUtil.getParameter(request, prefix	+ "ts_40", length));
			String[] vgmMt = (JSPUtil.getParameter(request, prefix	+ "vgm_40", length));

			for (int i = 0; i < length; i++) {
				model = new KorCllLoadSumDetailVO();
				if (ts45[i] != null)
					model.setTs45(ts45[i]);
				if (gubunCd3[i] != null)
					model.setGubunCd3(gubunCd3[i]);
				if (gubunCd2[i] != null)
					model.setGubunCd2(gubunCd2[i]);
				if (local40h[i] != null)
					model.setLocal40h(local40h[i]);
				if (wgtMt[i] != null)
					model.setWgtMt(wgtMt[i]);
				if (mty45[i] != null)
					model.setMty45(mty45[i]);
				if (ts20[i] != null)
					model.setTs20(ts20[i]);
				if (mty20[i] != null)
					model.setMty20(mty20[i]);
				if (orderGubun[i] != null)
					model.setOrderGubun(orderGubun[i]);
				if (local20[i] != null)
					model.setLocal20(local20[i]);
				if (gubunCd[i] != null)
					model.setGubunCd(gubunCd[i]);
				if (sum20[i] != null)
					model.setSum20(sum20[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sum45[i] != null)
					model.setSum45(sum45[i]);
				if (local45[i] != null)
					model.setLocal45(local45[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sum40h[i] != null)
					model.setSum40h(sum40h[i]);
				if (mty40h[i] != null)
					model.setMty40h(mty40h[i]);
				if (ts40h[i] != null)
					model.setTs40h(ts40h[i]);
				if (sum40[i] != null)
					model.setSum40(sum40[i]);
				if (mty40[i] != null)
					model.setMty40(mty40[i]);
				if (local40[i] != null)
					model.setLocal40(local40[i]);
				if (ts40[i] != null)
					model.setTs40(ts40[i]);
				if (vgmMt[i] != null)
					model.setVgmMt(vgmMt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorCllLoadSumDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorCllLoadSumDetailVO[]
	 */
	public KorCllLoadSumDetailVO[] getKorCllLoadSumDetailVOs(){
		KorCllLoadSumDetailVO[] vos = (KorCllLoadSumDetailVO[])models.toArray(new KorCllLoadSumDetailVO[models.size()]);
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
		this.ts45 = this.ts45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubunCd3 = this.gubunCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubunCd2 = this.gubunCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.local40h = this.local40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtMt = this.wgtMt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mty45 = this.mty45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts20 = this.ts20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mty20 = this.mty20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderGubun = this.orderGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.local20 = this.local20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubunCd = this.gubunCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sum20 = this.sum20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sum45 = this.sum45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.local45 = this.local45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sum40h = this.sum40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mty40h = this.mty40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts40h = this.ts40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sum40 = this.sum40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mty40 = this.mty40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.local40 = this.local40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts40 = this.ts40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmMt = this.vgmMt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TurnAroundTimeInGeneralVO.java
 *@FileTitle : TurnAroundTimeInGeneralVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.19
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2009.05.19 박광석 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo;

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
 * @author 박광석
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class TurnAroundTimeInGeneralVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<TurnAroundTimeInGeneralVO> models = new ArrayList<TurnAroundTimeInGeneralVO>();

	/* Column Info */
	private String total = null;
	/* Column Info */
	private String obfulllandtime = null;
	/* Column Info */
	private String mtyseatime = null;
	/* Column Info */
	private String fullseatime = null;
	/* Column Info */
	private String tslandtime = null;
	/* Column Info */
	private String tsseatime = null;
	/* Column Info */
	private String mtylandtime = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntrvolume = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String ibfulllandtime = null;
	/* Column Info */
	private String boundcode = null;
	/* Column Info */
	private String tradecode = null;
	/* Column Info */
	private String loccode2 = null;
	/* Column Info */
	private String lanecode = null;
	/* Column Info */
	private String loccode1 = null;
	/* Column Info */
	private String tpsz = null;
	/* Column Info */
	private String eq = null;

	/* Table Column name으로 맴버변수 value 담는다 */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* Table Column name으로 맴버변수 name 담는다 */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public TurnAroundTimeInGeneralVO() {
	}

	/**
	 * 
	 * @param ibflag
	 * @param pagerows
	 * @param tradecode
	 * @param boundcode
	 * @param lanecode
	 * @param total
	 * @param obfulllandtime
	 * @param fullseatime
	 * @param ibfulllandtime
	 * @param mtylandtime
	 * @param mtyseatime
	 * @param cntrvolume
	 * @param loccode1
	 * @param loccode2
	 * @param tpsz
	 */
	public TurnAroundTimeInGeneralVO(String ibflag, String pagerows, String tradecode, String boundcode,
			String lanecode, String total, String obfulllandtime, String fullseatime, String ibfulllandtime,
			String mtylandtime, String mtyseatime, String cntrvolume, String loccode1, String loccode2, String tpsz,
			String tsseatime, String tslandtime, String eq) {
		this.total = total;
		this.obfulllandtime = obfulllandtime;
		this.mtyseatime = mtyseatime;
		this.fullseatime = fullseatime;
		this.mtylandtime = mtylandtime;
		this.pagerows = pagerows;
		this.cntrvolume = cntrvolume;
		this.ibflag = ibflag;
		this.ibfulllandtime = ibfulllandtime;
		this.boundcode = boundcode;
		this.tradecode = tradecode;
		this.loccode2 = loccode2;
		this.lanecode = lanecode;
		this.loccode1 = loccode1;
		this.tpsz = tpsz;
		this.tsseatime = tsseatime;
		this.tslandtime = tslandtime;
		this.eq = eq;
	}

	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("obfulllandtime", getObfulllandtime());
		this.hashColumns.put("mtyseatime", getMtyseatime());
		this.hashColumns.put("fullseatime", getFullseatime());
		this.hashColumns.put("mtylandtime", getMtylandtime());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntrvolume", getCntrvolume());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ibfulllandtime", getIbfulllandtime());
		this.hashColumns.put("boundcode", getBoundcode());
		this.hashColumns.put("tradecode", getTradecode());
		this.hashColumns.put("loccode2", getLoccode2());
		this.hashColumns.put("lanecode", getLanecode());
		this.hashColumns.put("loccode1", getLoccode1());
		this.hashColumns.put("tpsz", getTpsz());
		this.hashColumns.put("tsseatime", getTsseatime());
		this.hashColumns.put("tslandtime", getTslandtime());
		this.hashColumns.put("eq", getEq());
		return this.hashColumns;
	}

	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("total", "total");
		this.hashFields.put("obfulllandtime", "obfulllandtime");
		this.hashFields.put("mtyseatime", "mtyseatime");
		this.hashFields.put("fullseatime", "fullseatime");
		this.hashFields.put("mtylandtime", "mtylandtime");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntrvolume", "cntrvolume");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ibfulllandtime", "ibfulllandtime");
		this.hashFields.put("boundcode", "boundcode");
		this.hashFields.put("tradecode", "tradecode");
		this.hashFields.put("loccode2", "loccode2");
		this.hashFields.put("lanecode", "lanecode");
		this.hashFields.put("loccode1", "loccode1");
		this.hashFields.put("tpsz", "tpsz");
		this.hashFields.put("tsseatime", "tsseatime");
		this.hashFields.put("tslandtime", "tslandtime");
		this.hashFields.put("eq", "eq");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * 
	 * @return total
	 */
	public String getTotal() {
		return this.total;
	}

	public String getEq() {
		return eq;
	}

	public void setEq(String eq) {
		this.eq = eq;
	}

	public String getTpsz() {
		return tpsz;
	}

	public void setTpsz(String tpsz) {
		this.tpsz = tpsz;
	}

	public String getTsseatime() {
		return tsseatime;
	}

	public void setTsseatime(String tsseatime) {
		this.tsseatime = tsseatime;
	}

	public String getTslandtime() {
		return tslandtime;
	}

	public void setTslandtime(String tslandtime) {
		this.tslandtime = tslandtime;
	}

	/**
	 * Column Info
	 * 
	 * @return obfulllandtime
	 */
	public String getObfulllandtime() {
		return this.obfulllandtime;
	}

	/**
	 * Column Info
	 * 
	 * @return mtyseatime
	 */
	public String getMtyseatime() {
		return this.mtyseatime;
	}

	/**
	 * Column Info
	 * 
	 * @return fullseatime
	 */
	public String getFullseatime() {
		return this.fullseatime;
	}

	/**
	 * Column Info
	 * 
	 * @return mtylandtime
	 */
	public String getMtylandtime() {
		return this.mtylandtime;
	}

	/**
	 * Page Number
	 * 
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @return cntrvolume
	 */
	public String getCntrvolume() {
		return this.cntrvolume;
	}

	/**
	 * Status
	 * 
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @return ibfulllandtime
	 */
	public String getIbfulllandtime() {
		return this.ibfulllandtime;
	}

	/**
	 * Column Info
	 * 
	 * @return boundcode
	 */
	public String getBoundcode() {
		return this.boundcode;
	}

	/**
	 * Column Info
	 * 
	 * @return tradecode
	 */
	public String getTradecode() {
		return this.tradecode;
	}

	/**
	 * Column Info
	 * 
	 * @return loccode2
	 */
	public String getLoccode2() {
		return this.loccode2;
	}

	/**
	 * Column Info
	 * 
	 * @return lanecode
	 */
	public String getLanecode() {
		return this.lanecode;
	}

	/**
	 * Column Info
	 * 
	 * @return loccode1
	 */
	public String getLoccode1() {
		return this.loccode1;
	}

	/**
	 * Column Info
	 * 
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
	}

	/**
	 * Column Info
	 * 
	 * @param obfulllandtime
	 */
	public void setObfulllandtime(String obfulllandtime) {
		this.obfulllandtime = obfulllandtime;
	}

	/**
	 * Column Info
	 * 
	 * @param mtyseatime
	 */
	public void setMtyseatime(String mtyseatime) {
		this.mtyseatime = mtyseatime;
	}

	/**
	 * Column Info
	 * 
	 * @param fullseatime
	 */
	public void setFullseatime(String fullseatime) {
		this.fullseatime = fullseatime;
	}

	/**
	 * Column Info
	 * 
	 * @param mtylandtime
	 */
	public void setMtylandtime(String mtylandtime) {
		this.mtylandtime = mtylandtime;
	}

	/**
	 * Page Number
	 * 
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @param cntrvolume
	 */
	public void setCntrvolume(String cntrvolume) {
		this.cntrvolume = cntrvolume;
	}

	/**
	 * Status
	 * 
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @param ibfulllandtime
	 */
	public void setIbfulllandtime(String ibfulllandtime) {
		this.ibfulllandtime = ibfulllandtime;
	}

	/**
	 * Column Info
	 * 
	 * @param boundcode
	 */
	public void setBoundcode(String boundcode) {
		this.boundcode = boundcode;
	}

	/**
	 * Column Info
	 * 
	 * @param tradecode
	 */
	public void setTradecode(String tradecode) {
		this.tradecode = tradecode;
	}

	/**
	 * Column Info
	 * 
	 * @param loccode2
	 */
	public void setLoccode2(String loccode2) {
		this.loccode2 = loccode2;
	}

	/**
	 * Column Info
	 * 
	 * @param lanecode
	 */
	public void setLanecode(String lanecode) {
		this.lanecode = lanecode;
	}

	/**
	 * Column Info
	 * 
	 * @param loccode1
	 */
	public void setLoccode1(String loccode1) {
		this.loccode1 = loccode1;
	}

	/**
	 * Request 넘어온 단건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTotal(JSPUtil.getParameter(request, "total", ""));
		setObfulllandtime(JSPUtil.getParameter(request, "obfulllandtime", ""));
		setMtyseatime(JSPUtil.getParameter(request, "mtyseatime", ""));
		setFullseatime(JSPUtil.getParameter(request, "fullseatime", ""));
		setMtylandtime(JSPUtil.getParameter(request, "mtylandtime", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCntrvolume(JSPUtil.getParameter(request, "cntrvolume", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setIbfulllandtime(JSPUtil.getParameter(request, "ibfulllandtime", ""));
		setBoundcode(JSPUtil.getParameter(request, "boundcode", ""));
		setTradecode(JSPUtil.getParameter(request, "tradecode", ""));
		setLoccode2(JSPUtil.getParameter(request, "loccode2", ""));
		setLanecode(JSPUtil.getParameter(request, "lanecode", ""));
		setLoccode1(JSPUtil.getParameter(request, "loccode1", ""));
		setTpsz(JSPUtil.getParameter(request, "tpsz", ""));
		setTsseatime(JSPUtil.getParameter(request, "tsseatime", ""));
		setTslandtime(JSPUtil.getParameter(request, "tslandtime", ""));
		setEq(JSPUtil.getParameter(request, "eq", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * 
	 * @param request
	 * @return TurnAroundTimeInGeneralVO[]
	 */
	public TurnAroundTimeInGeneralVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 * @param prefix
	 * @return TurnAroundTimeInGeneralVO[]
	 */
	public TurnAroundTimeInGeneralVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TurnAroundTimeInGeneralVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] total = (JSPUtil.getParameter(request, prefix + "total".trim(), length));
			String[] obfulllandtime = (JSPUtil.getParameter(request, prefix + "obfulllandtime".trim(), length));
			String[] mtyseatime = (JSPUtil.getParameter(request, prefix + "mtyseatime".trim(), length));
			String[] fullseatime = (JSPUtil.getParameter(request, prefix + "fullseatime".trim(), length));
			String[] mtylandtime = (JSPUtil.getParameter(request, prefix + "mtylandtime".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));
			String[] cntrvolume = (JSPUtil.getParameter(request, prefix + "cntrvolume".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
			String[] ibfulllandtime = (JSPUtil.getParameter(request, prefix + "ibfulllandtime".trim(), length));
			String[] boundcode = (JSPUtil.getParameter(request, prefix + "boundcode".trim(), length));
			String[] tradecode = (JSPUtil.getParameter(request, prefix + "tradecode".trim(), length));
			String[] loccode2 = (JSPUtil.getParameter(request, prefix + "loccode2".trim(), length));
			String[] lanecode = (JSPUtil.getParameter(request, prefix + "lanecode".trim(), length));
			String[] loccode1 = (JSPUtil.getParameter(request, prefix + "loccode1".trim(), length));
			String[] tpsz = (JSPUtil.getParameter(request, prefix + "tpsz".trim(), length));
			String[] tsseatime = (JSPUtil.getParameter(request, prefix + "tsseatime".trim(), length));
			String[] tslandtime = (JSPUtil.getParameter(request, prefix + "tslandtime".trim(), length));
			String[] eq = (JSPUtil.getParameter(request, prefix + "eq".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new TurnAroundTimeInGeneralVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (obfulllandtime[i] != null)
					model.setObfulllandtime(obfulllandtime[i]);
				if (mtyseatime[i] != null)
					model.setMtyseatime(mtyseatime[i]);
				if (fullseatime[i] != null)
					model.setFullseatime(fullseatime[i]);
				if (mtylandtime[i] != null)
					model.setMtylandtime(mtylandtime[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrvolume[i] != null)
					model.setCntrvolume(cntrvolume[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ibfulllandtime[i] != null)
					model.setIbfulllandtime(ibfulllandtime[i]);
				if (boundcode[i] != null)
					model.setBoundcode(boundcode[i]);
				if (tradecode[i] != null)
					model.setTradecode(tradecode[i]);
				if (loccode2[i] != null)
					model.setLoccode2(loccode2[i]);
				if (lanecode[i] != null)
					model.setLanecode(lanecode[i]);
				if (loccode1[i] != null)
					model.setLoccode1(loccode1[i]);
				if (tpsz[i] != null)
					model.setTpsz(tpsz[i]);
				if (tsseatime[i] != null)
					model.setTsseatime(tsseatime[i]);
				if (tslandtime[i] != null)
					model.setTslandtime(tslandtime[i]);
				if (eq[i] != null)
					model.setEq(eq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTurnAroundTimeInGeneralVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다
	 * 
	 * @return TurnAroundTimeInGeneralVO[]
	 */
	public TurnAroundTimeInGeneralVO[] getTurnAroundTimeInGeneralVOs() {
		TurnAroundTimeInGeneralVO[] vos = (TurnAroundTimeInGeneralVO[]) models
				.toArray(new TurnAroundTimeInGeneralVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try {
			for (int i = 0; i < field.length; i++) {
				String[] arr = null;
				arr = getField(field, i);
				if (arr != null) {
					for (int j = 0; j < arr.length; j++) {
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
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다
	 * 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try {
			arr = (String[]) field[i].get(this);
		} catch (Exception ex) {
			arr = getFieldCatct(field, i, arr);
		}
		return arr;
	}

	/**
	 * getField 에서 catch문에 대한 로직
	 * 
	 * @param field
	 * @param i
	 * @param arr
	 * @return arr
	 */
	private String[] getFieldCatct(Field[] field, int i, String[] arr) {
		try {
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		} catch (IllegalAccessException e) {
			return null;
		}
		return arr;
	}

	/**
	 * DataFormat 설정
	 */
	public void unDataFormat() {
		this.total = this.total.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obfulllandtime = this.obfulllandtime.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "")
				.replaceAll(":", "");
		this.mtyseatime = this.mtyseatime.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":",
				"");
		this.fullseatime = this.fullseatime.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":",
				"");
		this.mtylandtime = this.mtylandtime.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":",
				"");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrvolume = this.cntrvolume.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":",
				"");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibfulllandtime = this.ibfulllandtime.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "")
				.replaceAll(":", "");
		this.boundcode = this.boundcode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tradecode = this.tradecode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loccode2 = this.loccode2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lanecode = this.lanecode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loccode1 = this.loccode1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsz = this.tpsz.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsseatime = this.tsseatime.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tslandtime = this.tslandtime.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":",
				"");
		this.eq = this.eq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

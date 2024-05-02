/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : KorCllSpclStowRqstDetail3VO.java
*@FileTitle : KorCllSpclStowRqstDetail3VO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.25
*@LastModifier : Hannah Lee
*@LastVersion : 1.1
* 2013.01.18 조정민 
* 1.0 Creation
* 1.1 2014.07.25 Hannah Lee
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 조정민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorCllSpclStowRqstDetail3VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorCllSpclStowRqstDetail3VO> models = new ArrayList<KorCllSpclStowRqstDetail3VO>();
	
	/* Column Info */
	private String ut40 = null;
	/* Column Info */
	private String olbp45 = null;
	/* Column Info */
	private String ut20 = null;
	/* Column Info */
	private String utab45 = null;
	/* Column Info */
	private String ud45 = null;
	/* Column Info */
	private String ts20 = null;
	/* Column Info */
	private String blckStwgCd = null;
	/* Column Info */
	private String pcod40h = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ud40h = null;
	/* Column Info */
	private String uw20 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ts40h = null;
	/* Column Info */
	private String udab40h = null;
	/* Column Info */
	private String uw45 = null;
	/* Column Info */
	private String ud40 = null;
	/* Column Info */
	private String utab40h = null;
	/* Column Info */
	private String ts40 = null;
	/* Column Info */
	private String ud20 = null;
	/* Column Info */
	private String olbp40h = null;
	/* Column Info */
	private String uw40 = null;
	/* Column Info */
	private String ts45 = null;
	/* Column Info */
	private String gubunCd3 = null;
	/* Column Info */
	private String udab20 = null;
	/* Column Info */
	private String udab40 = null;
	/* Column Info */
	private String uw40h = null;
	/* Column Info */
	private String utab20 = null;
	/* Column Info */
	private String pcod40 = null;
	/* Column Info */
	private String olbp40 = null;
	/* Column Info */
	private String olbp20 = null;
	/* Column Info */
	private String ut40h = null;
	/* Column Info */
	private String utab40 = null;
	/* Column Info */
	private String ut45 = null;
	/* Column Info */
	private String udab45 = null;
	/* Column Info */
	private String pcod20 = null;
	/* Column Info */
	private String pcod45 = null;
	/* Column Info */
	private String udmx40h = null;
	/* Column Info */
	private String udmx20 = null;
	/* Column Info */
	private String udmx40 = null;
	/* Column Info */
	private String udmx45 = null;
	
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorCllSpclStowRqstDetail3VO() {}

	public KorCllSpclStowRqstDetail3VO(String ibflag, String pagerows, String gubunCd3, String blckStwgCd, String pcod20, String pcod40, String pcod40h, String pcod45, String ts20, String ts40, String ts40h, String ts45, String olbp20, String olbp40, String olbp40h, String olbp45, String ud20, String ud40, String ud40h, String ud45, String udab20, String udab40, String udab40h, String udab45, String ut20, String ut40, String ut40h, String ut45, String utab20, String utab40, String utab40h, String utab45, String uw20, String uw40, String uw40h, String uw45, String udmx20, String udmx40, String udmx40h, String udmx45 ) {
		this.ut40 = ut40;
		this.olbp45 = olbp45;
		this.ut20 = ut20;
		this.utab45 = utab45;
		this.ud45 = ud45;
		this.ts20 = ts20;
		this.blckStwgCd = blckStwgCd;
		this.pcod40h = pcod40h;
		this.pagerows = pagerows;
		this.ud40h = ud40h;
		this.uw20 = uw20;
		this.ibflag = ibflag;
		this.ts40h = ts40h;
		this.udab40h = udab40h;
		this.uw45 = uw45;
		this.ud40 = ud40;
		this.utab40h = utab40h;
		this.ts40 = ts40;
		this.ud20 = ud20;
		this.olbp40h = olbp40h;
		this.uw40 = uw40;
		this.ts45 = ts45;
		this.gubunCd3 = gubunCd3;
		this.udab20 = udab20;
		this.udab40 = udab40;
		this.uw40h = uw40h;
		this.utab20 = utab20;
		this.pcod40 = pcod40;
		this.olbp40 = olbp40;
		this.olbp20 = olbp20;
		this.ut40h = ut40h;
		this.utab40 = utab40;
		this.ut45 = ut45;
		this.udab45 = udab45;
		this.pcod20 = pcod20;
		this.pcod45 = pcod45;
		this.udmx20 = udmx20;
		this.udmx40 = udmx40;
		this.udmx40h = udmx40h;
		this.udmx45 = udmx45; 
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ut_40", getUt40());
		this.hashColumns.put("olbp_45", getolbp45());
		this.hashColumns.put("ut_20", getUt20());
		this.hashColumns.put("utab_45", getUtab45());
		this.hashColumns.put("ud_45", getUd45());
		this.hashColumns.put("ts_20", getTs20());
		this.hashColumns.put("blck_stwg_cd", getBlckStwgCd());
		this.hashColumns.put("pcod_40h", getPcod40h());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ud_40h", getUd40h());
		this.hashColumns.put("uw_20", getUw20());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ts_40h", getTs40h());
		this.hashColumns.put("udab_40h", getUdab40h());
		this.hashColumns.put("uw_45", getUw45());
		this.hashColumns.put("ud_40", getUd40());
		this.hashColumns.put("utab_40h", getUtab40h());
		this.hashColumns.put("ts_40", getTs40());
		this.hashColumns.put("ud_20", getUd20());
		this.hashColumns.put("olbp_40h", getolbp40h());
		this.hashColumns.put("uw_40", getUw40());
		this.hashColumns.put("ts_45", getTs45());
		this.hashColumns.put("gubun_cd3", getGubunCd3());
		this.hashColumns.put("udab_20", getUdab20());
		this.hashColumns.put("udab_40", getUdab40());
		this.hashColumns.put("uw_40h", getUw40h());
		this.hashColumns.put("utab_20", getUtab20());
		this.hashColumns.put("pcod_40", getPcod40());
		this.hashColumns.put("olbp_40", getolbp40());
		this.hashColumns.put("olbp_20", getolbp20());
		this.hashColumns.put("ut_40h", getUt40h());
		this.hashColumns.put("utab_40", getUtab40());
		this.hashColumns.put("ut_45", getUt45());
		this.hashColumns.put("udab_45", getUdab45());
		this.hashColumns.put("pcod_20", getPcod20());
		this.hashColumns.put("pcod_45", getPcod45());
		this.hashColumns.put("udmx_20", getUdmx20());
		this.hashColumns.put("udmx_40", getUdmx40());
		this.hashColumns.put("udmx_40h", getUdmx40h());
		this.hashColumns.put("udmx_45", getUdmx45());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ut_40", "ut40");
		this.hashFields.put("olbp_45", "olbp45");
		this.hashFields.put("ut_20", "ut20");
		this.hashFields.put("utab_45", "utab45");
		this.hashFields.put("ud_45", "ud45");
		this.hashFields.put("ts_20", "ts20");
		this.hashFields.put("blck_stwg_cd", "blckStwgCd");
		this.hashFields.put("pcod_40h", "pcod40h");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ud_40h", "ud40h");
		this.hashFields.put("uw_20", "uw20");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ts_40h", "ts40h");
		this.hashFields.put("udab_40h", "udab40h");
		this.hashFields.put("uw_45", "uw45");
		this.hashFields.put("ud_40", "ud40");
		this.hashFields.put("utab_40h", "utab40h");
		this.hashFields.put("ts_40", "ts40");
		this.hashFields.put("ud_20", "ud20");
		this.hashFields.put("olbp_40h", "olbp40h");
		this.hashFields.put("uw_40", "uw40");
		this.hashFields.put("ts_45", "ts45");
		this.hashFields.put("gubun_cd3", "gubunCd3");
		this.hashFields.put("udab_20", "udab20");
		this.hashFields.put("udab_40", "udab40");
		this.hashFields.put("uw_40h", "uw40h");
		this.hashFields.put("utab_20", "utab20");
		this.hashFields.put("pcod_40", "pcod40");
		this.hashFields.put("olbp_40", "olbp40");
		this.hashFields.put("olbp_20", "olbp20");
		this.hashFields.put("ut_40h", "ut40h");
		this.hashFields.put("utab_40", "utab40");
		this.hashFields.put("ut_45", "ut45");
		this.hashFields.put("udab_45", "udab45");
		this.hashFields.put("pcod_20", "pcod20");
		this.hashFields.put("pcod_45", "pcod45");
		this.hashFields.put("udmx_20", "udmx20");
		this.hashFields.put("udmx_40", "udmx40");
		this.hashFields.put("udmx_40h", "udmx40h");
		this.hashFields.put("udmx_45", "udmx45");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ut40
	 */
	public String getUt40() {
		return this.ut40;
	}
	
	/**
	 * Column Info
	 * @return olbp45
	 */
	public String getolbp45() {
		return this.olbp45;
	}
	
	/**
	 * Column Info
	 * @return ut20
	 */
	public String getUt20() {
		return this.ut20;
	}
	
	/**
	 * Column Info
	 * @return utab45
	 */
	public String getUtab45() {
		return this.utab45;
	}
	
	/**
	 * Column Info
	 * @return ud45
	 */
	public String getUd45() {
		return this.ud45;
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
	 * @return blckStwgCd
	 */
	public String getBlckStwgCd() {
		return this.blckStwgCd;
	}
	
	/**
	 * Column Info
	 * @return pcod40h
	 */
	public String getPcod40h() {
		return this.pcod40h;
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
	 * @return ud40h
	 */
	public String getUd40h() {
		return this.ud40h;
	}
	
	/**
	 * Column Info
	 * @return uw20
	 */
	public String getUw20() {
		return this.uw20;
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
	 * @return ts40h
	 */
	public String getTs40h() {
		return this.ts40h;
	}
	
	/**
	 * Column Info
	 * @return udab40h
	 */
	public String getUdab40h() {
		return this.udab40h;
	}
	
	/**
	 * Column Info
	 * @return uw45
	 */
	public String getUw45() {
		return this.uw45;
	}
	
	/**
	 * Column Info
	 * @return ud40
	 */
	public String getUd40() {
		return this.ud40;
	}
	
	/**
	 * Column Info
	 * @return utab40h
	 */
	public String getUtab40h() {
		return this.utab40h;
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
	 * @return ud20
	 */
	public String getUd20() {
		return this.ud20;
	}
	
	/**
	 * Column Info
	 * @return olbp40h
	 */
	public String getolbp40h() {
		return this.olbp40h;
	}
	
	/**
	 * Column Info
	 * @return uw40
	 */
	public String getUw40() {
		return this.uw40;
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
	 * @return udab20
	 */
	public String getUdab20() {
		return this.udab20;
	}
	
	/**
	 * Column Info
	 * @return udab40
	 */
	public String getUdab40() {
		return this.udab40;
	}
	
	/**
	 * Column Info
	 * @return uw40h
	 */
	public String getUw40h() {
		return this.uw40h;
	}
	
	/**
	 * Column Info
	 * @return utab20
	 */
	public String getUtab20() {
		return this.utab20;
	}
	
	/**
	 * Column Info
	 * @return pcod40
	 */
	public String getPcod40() {
		return this.pcod40;
	}
	
	/**
	 * Column Info
	 * @return olbp40
	 */
	public String getolbp40() {
		return this.olbp40;
	}
	
	/**
	 * Column Info
	 * @return olbp20
	 */
	public String getolbp20() {
		return this.olbp20;
	}
	
	/**
	 * Column Info
	 * @return ut40h
	 */
	public String getUt40h() {
		return this.ut40h;
	}
	
	/**
	 * Column Info
	 * @return utab40
	 */
	public String getUtab40() {
		return this.utab40;
	}
	
	/**
	 * Column Info
	 * @return ut45
	 */
	public String getUt45() {
		return this.ut45;
	}
	
	/**
	 * Column Info
	 * @return udab45
	 */
	public String getUdab45() {
		return this.udab45;
	}
	
	/**
	 * Column Info
	 * @return pcod20
	 */
	public String getPcod20() {
		return this.pcod20;
	}
	
	/**
	 * Column Info
	 * @return pcod45
	 */
	public String getPcod45() {
		return this.pcod45;
	}
	

	/**
	 * Column Info
	 * @return udmx20
	 */
	public String getUdmx20() {
		return this.udmx20;
	}
	
	/**
	 * Column Info
	 * @return udmx40
	 */
	public String getUdmx40() {
		return this.udmx40;
	}
	
	/**
	 * Column Info
	 * @return udmx40h
	 */
	public String getUdmx40h() {
		return this.udmx40h;
	}
	
	/**
	 * Column Info
	 * @return udmx45
	 */
	public String getUdmx45() {
		return this.udmx45;
	}
	
	
	/**
	 * Column Info
	 * @param ut40
	 */
	public void setUt40(String ut40) {
		this.ut40 = ut40;
	}
	
	/**
	 * Column Info
	 * @param olbp45
	 */
	public void setolbp45(String olbp45) {
		this.olbp45 = olbp45;
	}
	
	/**
	 * Column Info
	 * @param ut20
	 */
	public void setUt20(String ut20) {
		this.ut20 = ut20;
	}
	
	/**
	 * Column Info
	 * @param utab45
	 */
	public void setUtab45(String utab45) {
		this.utab45 = utab45;
	}
	
	/**
	 * Column Info
	 * @param ud45
	 */
	public void setUd45(String ud45) {
		this.ud45 = ud45;
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
	 * @param blckStwgCd
	 */
	public void setBlckStwgCd(String blckStwgCd) {
		this.blckStwgCd = blckStwgCd;
	}
	
	/**
	 * Column Info
	 * @param pcod40h
	 */
	public void setPcod40h(String pcod40h) {
		this.pcod40h = pcod40h;
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
	 * @param ud40h
	 */
	public void setUd40h(String ud40h) {
		this.ud40h = ud40h;
	}
	
	/**
	 * Column Info
	 * @param uw20
	 */
	public void setUw20(String uw20) {
		this.uw20 = uw20;
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
	 * @param ts40h
	 */
	public void setTs40h(String ts40h) {
		this.ts40h = ts40h;
	}
	
	/**
	 * Column Info
	 * @param udab40h
	 */
	public void setUdab40h(String udab40h) {
		this.udab40h = udab40h;
	}
	
	/**
	 * Column Info
	 * @param uw45
	 */
	public void setUw45(String uw45) {
		this.uw45 = uw45;
	}
	
	/**
	 * Column Info
	 * @param ud40
	 */
	public void setUd40(String ud40) {
		this.ud40 = ud40;
	}
	
	/**
	 * Column Info
	 * @param utab40h
	 */
	public void setUtab40h(String utab40h) {
		this.utab40h = utab40h;
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
	 * @param ud20
	 */
	public void setUd20(String ud20) {
		this.ud20 = ud20;
	}
	
	/**
	 * Column Info
	 * @param olbp40h
	 */
	public void setolbp40h(String olbp40h) {
		this.olbp40h = olbp40h;
	}
	
	/**
	 * Column Info
	 * @param uw40
	 */
	public void setUw40(String uw40) {
		this.uw40 = uw40;
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
	 * @param udab20
	 */
	public void setUdab20(String udab20) {
		this.udab20 = udab20;
	}
	
	/**
	 * Column Info
	 * @param udab40
	 */
	public void setUdab40(String udab40) {
		this.udab40 = udab40;
	}
	
	/**
	 * Column Info
	 * @param uw40h
	 */
	public void setUw40h(String uw40h) {
		this.uw40h = uw40h;
	}
	
	/**
	 * Column Info
	 * @param utab20
	 */
	public void setUtab20(String utab20) {
		this.utab20 = utab20;
	}
	
	/**
	 * Column Info
	 * @param pcod40
	 */
	public void setPcod40(String pcod40) {
		this.pcod40 = pcod40;
	}
	
	/**
	 * Column Info
	 * @param olbp40
	 */
	public void setolbp40(String olbp40) {
		this.olbp40 = olbp40;
	}
	
	/**
	 * Column Info
	 * @param olbp20
	 */
	public void setolbp20(String olbp20) {
		this.olbp20 = olbp20;
	}
	
	/**
	 * Column Info
	 * @param ut40h
	 */
	public void setUt40h(String ut40h) {
		this.ut40h = ut40h;
	}
	
	/**
	 * Column Info
	 * @param utab40
	 */
	public void setUtab40(String utab40) {
		this.utab40 = utab40;
	}
	
	/**
	 * Column Info
	 * @param ut45
	 */
	public void setUt45(String ut45) {
		this.ut45 = ut45;
	}
	
	/**
	 * Column Info
	 * @param udab45
	 */
	public void setUdab45(String udab45) {
		this.udab45 = udab45;
	}
	
	/**
	 * Column Info
	 * @param pcod20
	 */
	public void setPcod20(String pcod20) {
		this.pcod20 = pcod20;
	}
	
	/**
	 * Column Info
	 * @param pcod45
	 */
	public void setPcod45(String pcod45) {
		this.pcod45 = pcod45;
	}
	
	/**
	 * Column Info
	 * @param udmx20
	 */
	public void setUdmx20(String udmx20) {
		this.udmx20 = udmx20;
	}
	
	/**
	 * Column Info
	 * @param udmx40
	 */
	public void setUdmx40(String udmx40) {
		this.udmx40 = udmx40;
	}
	
	/**
	 * Column Info
	 * @param udmx40
	 */
	public void setUdmx40h(String udmx40h) {
		this.udmx40h = udmx40h;
	}
	
	/**
	 * Column Info
	 * @param udmx45
	 */
	public void setUdmx45(String udmx45) {
		this.udmx45 = udmx45;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setUt40(JSPUtil.getParameter(request, prefix + "ut_40", ""));
		setolbp45(JSPUtil.getParameter(request, prefix + "olbp_45", ""));
		setUt20(JSPUtil.getParameter(request, prefix + "ut_20", ""));
		setUtab45(JSPUtil.getParameter(request, prefix + "utab_45", ""));
		setUd45(JSPUtil.getParameter(request, prefix + "ud_45", ""));
		setTs20(JSPUtil.getParameter(request, prefix + "ts_20", ""));
		setBlckStwgCd(JSPUtil.getParameter(request, prefix + "blck_stwg_cd", ""));
		setPcod40h(JSPUtil.getParameter(request, prefix + "pcod_40h", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setUd40h(JSPUtil.getParameter(request, prefix + "ud_40h", ""));
		setUw20(JSPUtil.getParameter(request, prefix + "uw_20", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTs40h(JSPUtil.getParameter(request, prefix + "ts_40h", ""));
		setUdab40h(JSPUtil.getParameter(request, prefix + "udab_40h", ""));
		setUw45(JSPUtil.getParameter(request, prefix + "uw_45", ""));
		setUd40(JSPUtil.getParameter(request, prefix + "ud_40", ""));
		setUtab40h(JSPUtil.getParameter(request, prefix + "utab_40h", ""));
		setTs40(JSPUtil.getParameter(request, prefix + "ts_40", ""));
		setUd20(JSPUtil.getParameter(request, prefix + "ud_20", ""));
		setolbp40h(JSPUtil.getParameter(request, prefix + "olbp_40h", ""));
		setUw40(JSPUtil.getParameter(request, prefix + "uw_40", ""));
		setTs45(JSPUtil.getParameter(request, prefix + "ts_45", ""));
		setGubunCd3(JSPUtil.getParameter(request, prefix + "gubun_cd3", ""));
		setUdab20(JSPUtil.getParameter(request, prefix + "udab_20", ""));
		setUdab40(JSPUtil.getParameter(request, prefix + "udab_40", ""));
		setUw40h(JSPUtil.getParameter(request, prefix + "uw_40h", ""));
		setUtab20(JSPUtil.getParameter(request, prefix + "utab_20", ""));
		setPcod40(JSPUtil.getParameter(request, prefix + "pcod_40", ""));
		setolbp40(JSPUtil.getParameter(request, prefix + "olbp_40", ""));
		setolbp20(JSPUtil.getParameter(request, prefix + "olbp_20", ""));
		setUt40h(JSPUtil.getParameter(request, prefix + "ut_40h", ""));
		setUtab40(JSPUtil.getParameter(request, prefix + "utab_40", ""));
		setUt45(JSPUtil.getParameter(request, prefix + "ut_45", ""));
		setUdab45(JSPUtil.getParameter(request, prefix + "udab_45", ""));
		setPcod20(JSPUtil.getParameter(request, prefix + "pcod_20", ""));
		setPcod45(JSPUtil.getParameter(request, prefix + "pcod_45", ""));
		setUdmx20(JSPUtil.getParameter(request, prefix + "udmx_20", ""));
		setUdmx40(JSPUtil.getParameter(request, prefix + "udmx_40", ""));
		setUdmx40h(JSPUtil.getParameter(request, prefix + "udmx_40h", ""));
		setUdmx45(JSPUtil.getParameter(request, prefix + "udmx_45", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorCllSpclStowRqstDetail3VO[]
	 */
	public KorCllSpclStowRqstDetail3VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorCllSpclStowRqstDetail3VO[]
	 */
	public KorCllSpclStowRqstDetail3VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorCllSpclStowRqstDetail3VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ut40 = (JSPUtil.getParameter(request, prefix	+ "ut_40", length));
			String[] olbp45 = (JSPUtil.getParameter(request, prefix	+ "olbp_45", length));
			String[] ut20 = (JSPUtil.getParameter(request, prefix	+ "ut_20", length));
			String[] utab45 = (JSPUtil.getParameter(request, prefix	+ "utab_45", length));
			String[] ud45 = (JSPUtil.getParameter(request, prefix	+ "ud_45", length));
			String[] ts20 = (JSPUtil.getParameter(request, prefix	+ "ts_20", length));
			String[] blckStwgCd = (JSPUtil.getParameter(request, prefix	+ "blck_stwg_cd", length));
			String[] pcod40h = (JSPUtil.getParameter(request, prefix	+ "pcod_40h", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ud40h = (JSPUtil.getParameter(request, prefix	+ "ud_40h", length));
			String[] uw20 = (JSPUtil.getParameter(request, prefix	+ "uw_20", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ts40h = (JSPUtil.getParameter(request, prefix	+ "ts_40h", length));
			String[] udab40h = (JSPUtil.getParameter(request, prefix	+ "udab_40h", length));
			String[] uw45 = (JSPUtil.getParameter(request, prefix	+ "uw_45", length));
			String[] ud40 = (JSPUtil.getParameter(request, prefix	+ "ud_40", length));
			String[] utab40h = (JSPUtil.getParameter(request, prefix	+ "utab_40h", length));
			String[] ts40 = (JSPUtil.getParameter(request, prefix	+ "ts_40", length));
			String[] ud20 = (JSPUtil.getParameter(request, prefix	+ "ud_20", length));
			String[] olbp40h = (JSPUtil.getParameter(request, prefix	+ "olbp_40h", length));
			String[] uw40 = (JSPUtil.getParameter(request, prefix	+ "uw_40", length));
			String[] ts45 = (JSPUtil.getParameter(request, prefix	+ "ts_45", length));
			String[] gubunCd3 = (JSPUtil.getParameter(request, prefix	+ "gubun_cd3", length));
			String[] udab20 = (JSPUtil.getParameter(request, prefix	+ "udab_20", length));
			String[] udab40 = (JSPUtil.getParameter(request, prefix	+ "udab_40", length));
			String[] uw40h = (JSPUtil.getParameter(request, prefix	+ "uw_40h", length));
			String[] utab20 = (JSPUtil.getParameter(request, prefix	+ "utab_20", length));
			String[] pcod40 = (JSPUtil.getParameter(request, prefix	+ "pcod_40", length));
			String[] olbp40 = (JSPUtil.getParameter(request, prefix	+ "olbp_40", length));
			String[] olbp20 = (JSPUtil.getParameter(request, prefix	+ "olbp_20", length));
			String[] ut40h = (JSPUtil.getParameter(request, prefix	+ "ut_40h", length));
			String[] utab40 = (JSPUtil.getParameter(request, prefix	+ "utab_40", length));
			String[] ut45 = (JSPUtil.getParameter(request, prefix	+ "ut_45", length));
			String[] udab45 = (JSPUtil.getParameter(request, prefix	+ "udab_45", length));
			String[] pcod20 = (JSPUtil.getParameter(request, prefix	+ "pcod_20", length));
			String[] pcod45 = (JSPUtil.getParameter(request, prefix	+ "pcod_45", length));
			String[] udmx20 = (JSPUtil.getParameter(request, prefix	+ "udmx_20", length));
			String[] udmx40 = (JSPUtil.getParameter(request, prefix	+ "udmx_40", length));
			String[] udmx40h = (JSPUtil.getParameter(request, prefix + "udmx_40h", length));
			String[] udmx45 = (JSPUtil.getParameter(request, prefix	+ "udmx_45", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorCllSpclStowRqstDetail3VO();
				if (ut40[i] != null)
					model.setUt40(ut40[i]);
				if (olbp45[i] != null)
					model.setolbp45(olbp45[i]);
				if (ut20[i] != null)
					model.setUt20(ut20[i]);
				if (utab45[i] != null)
					model.setUtab45(utab45[i]);
				if (ud45[i] != null)
					model.setUd45(ud45[i]);
				if (ts20[i] != null)
					model.setTs20(ts20[i]);
				if (blckStwgCd[i] != null)
					model.setBlckStwgCd(blckStwgCd[i]);
				if (pcod40h[i] != null)
					model.setPcod40h(pcod40h[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ud40h[i] != null)
					model.setUd40h(ud40h[i]);
				if (uw20[i] != null)
					model.setUw20(uw20[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ts40h[i] != null)
					model.setTs40h(ts40h[i]);
				if (udab40h[i] != null)
					model.setUdab40h(udab40h[i]);
				if (uw45[i] != null)
					model.setUw45(uw45[i]);
				if (ud40[i] != null)
					model.setUd40(ud40[i]);
				if (utab40h[i] != null)
					model.setUtab40h(utab40h[i]);
				if (ts40[i] != null)
					model.setTs40(ts40[i]);
				if (ud20[i] != null)
					model.setUd20(ud20[i]);
				if (olbp40h[i] != null)
					model.setolbp40h(olbp40h[i]);
				if (uw40[i] != null)
					model.setUw40(uw40[i]);
				if (ts45[i] != null)
					model.setTs45(ts45[i]);
				if (gubunCd3[i] != null)
					model.setGubunCd3(gubunCd3[i]);
				if (udab20[i] != null)
					model.setUdab20(udab20[i]);
				if (udab40[i] != null)
					model.setUdab40(udab40[i]);
				if (uw40h[i] != null)
					model.setUw40h(uw40h[i]);
				if (utab20[i] != null)
					model.setUtab20(utab20[i]);
				if (pcod40[i] != null)
					model.setPcod40(pcod40[i]);
				if (olbp40[i] != null)
					model.setolbp40(olbp40[i]);
				if (olbp20[i] != null)
					model.setolbp20(olbp20[i]);
				if (ut40h[i] != null)
					model.setUt40h(ut40h[i]);
				if (utab40[i] != null)
					model.setUtab40(utab40[i]);
				if (ut45[i] != null)
					model.setUt45(ut45[i]);
				if (udab45[i] != null)
					model.setUdab45(udab45[i]);
				if (pcod20[i] != null)
					model.setPcod20(pcod20[i]);
				if (pcod45[i] != null)
					model.setPcod45(pcod45[i]);
				if (udmx20[i] != null)
					model.setUdmx20(udmx20[i]);
				if (udmx40[i] != null)
					model.setUdmx40(udmx40[i]);
				if (udmx40h[i] != null)
					model.setUdmx40h(udmx40h[i]);
				if (udmx45[i] != null)
					model.setUdmx45(udmx45[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorCllSpclStowRqstDetail3VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorCllSpclStowRqstDetail3VO[]
	 */
	public KorCllSpclStowRqstDetail3VO[] getKorCllSpclStowRqstDetail3VOs(){
		KorCllSpclStowRqstDetail3VO[] vos = (KorCllSpclStowRqstDetail3VO[])models.toArray(new KorCllSpclStowRqstDetail3VO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.ut40 = this.ut40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.olbp45 = this.olbp45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ut20 = this.ut20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.utab45 = this.utab45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ud45 = this.ud45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts20 = this.ts20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blckStwgCd = this.blckStwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcod40h = this.pcod40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ud40h = this.ud40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uw20 = this.uw20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts40h = this.ts40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udab40h = this.udab40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uw45 = this.uw45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ud40 = this.ud40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.utab40h = this.utab40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts40 = this.ts40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ud20 = this.ud20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.olbp40h = this.olbp40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uw40 = this.uw40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts45 = this.ts45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubunCd3 = this.gubunCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udab20 = this.udab20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udab40 = this.udab40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uw40h = this.uw40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.utab20 = this.utab20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcod40 = this.pcod40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.olbp40 = this.olbp40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.olbp20 = this.olbp20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ut40h = this.ut40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.utab40 = this.utab40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ut45 = this.ut45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udab45 = this.udab45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcod20 = this.pcod20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcod45 = this.pcod45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udmx20 = this.udmx20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udmx40 = this.udmx40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udmx40h = this.udmx40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udmx45 = this.udmx45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

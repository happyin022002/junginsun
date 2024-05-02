package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

public class CHSScExceptionINVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;

	private Collection<CHSScExceptionINVO> models = new ArrayList<CHSScExceptionINVO>();
	private String scc4 = null;
	private String scc3 = null;
	private String scFmDt = null;
	private String scc6 = null;
	private String scc5 = null;
	private String scc8 = null;
	private String scc7 = null;
	private String scc9 = null;
	private String pagerows = null;
	private String scc26 = null;
	private String scc25 = null;
	private String locCd = null;
	private String scc24 = null;
	private String scc23 = null;
	private String scc22 = null;
	private String scc21 = null;
	private String scNo = null;
	private String scc20 = null;
	private String sccSortTp = null;
	private String scc29 = null;
	private String scc28 = null;
	private String scc27 = null;
	private String scc63 = null;
	private String scCustNm = null;
	private String scc64 = null;
	private String scc65 = null;
	private String scCustNo = null;
	private String scc35 = null;
	private String scc34 = null;
	private String scc37 = null;
	private String scc36 = null;
	private String scc60 = null;
	private String scc31 = null;
	private String scc30 = null;
	private String scc62 = null;
	private String scc33 = null;
	private String scc61 = null;
	private String scc32 = null;
	private String scc39 = null;
	private String scc38 = null;
	private String scc40 = null;
	private String scc44 = null;
	private String scSortTp = null;
	private String scc43 = null;
	private String ibflag = null;
	private String scc42 = null;
	private String scc41 = null;
	private String scc48 = null;
	private String scc47 = null;
	private String scc46 = null;
	private String scc45 = null;
	private String scc49 = null;
	private String scToDt = null;
	private String scc50 = null;
	private String scc51 = null;
	private String scc53 = null;
	private String scc16 = null;
	private String scc52 = null;
	private String scc17 = null;
	private String scLocTcnt = null;
	private String scc55 = null;
	private String scc18 = null;
	private String scc54 = null;
	private String scc19 = null;
	private String scc57 = null;
	private String scc56 = null;
	private String scc59 = null;
	private String scc58 = null;
	private String scc2 = null;
	private String scc1 = null;
	private String scc10 = null;
	private String scc11 = null;
	private String scc12 = null;
	private String scc13 = null;
	private String scc14 = null;
	private String scc15 = null;
	private String effDt = null;
	private String expDt = null;
	private String ftFlg = null;

	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CHSScExceptionINVO() {}

	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("scc4", getScc4());
		this.hashColumns.put("scc3", getScc3());
		this.hashColumns.put("sc_fm_dt", getScFmDt());
		this.hashColumns.put("scc6", getScc6());
		this.hashColumns.put("scc5", getScc5());
		this.hashColumns.put("scc8", getScc8());
		this.hashColumns.put("scc7", getScc7());
		this.hashColumns.put("scc9", getScc9());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("scc26", getScc26());
		this.hashColumns.put("scc25", getScc25());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("scc24", getScc24());
		this.hashColumns.put("scc23", getScc23());
		this.hashColumns.put("scc22", getScc22());
		this.hashColumns.put("scc21", getScc21());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("scc20", getScc20());
		this.hashColumns.put("scc_sort_tp", getSccSortTp());
		this.hashColumns.put("scc29", getScc29());
		this.hashColumns.put("scc28", getScc28());
		this.hashColumns.put("scc27", getScc27());
		this.hashColumns.put("scc63", getScc63());
		this.hashColumns.put("sc_cust_nm", getScCustNm());
		this.hashColumns.put("scc64", getScc64());
		this.hashColumns.put("scc65", getScc65());
		this.hashColumns.put("sc_cust_no", getScCustNo());
		this.hashColumns.put("scc35", getScc35());
		this.hashColumns.put("scc34", getScc34());
		this.hashColumns.put("scc37", getScc37());
		this.hashColumns.put("scc36", getScc36());
		this.hashColumns.put("scc60", getScc60());
		this.hashColumns.put("scc31", getScc31());
		this.hashColumns.put("scc30", getScc30());
		this.hashColumns.put("scc62", getScc62());
		this.hashColumns.put("scc33", getScc33());
		this.hashColumns.put("scc61", getScc61());
		this.hashColumns.put("scc32", getScc32());
		this.hashColumns.put("scc39", getScc39());
		this.hashColumns.put("scc38", getScc38());
		this.hashColumns.put("scc40", getScc40());
		this.hashColumns.put("scc44", getScc44());
		this.hashColumns.put("sc_sort_tp", getScSortTp());
		this.hashColumns.put("scc43", getScc43());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("scc42", getScc42());
		this.hashColumns.put("scc41", getScc41());
		this.hashColumns.put("scc48", getScc48());
		this.hashColumns.put("scc47", getScc47());
		this.hashColumns.put("scc46", getScc46());
		this.hashColumns.put("scc45", getScc45());
		this.hashColumns.put("scc49", getScc49());
		this.hashColumns.put("sc_to_dt", getScToDt());
		this.hashColumns.put("scc50", getScc50());
		this.hashColumns.put("scc51", getScc51());
		this.hashColumns.put("scc53", getScc53());
		this.hashColumns.put("scc16", getScc16());
		this.hashColumns.put("scc52", getScc52());
		this.hashColumns.put("scc17", getScc17());
		this.hashColumns.put("sc_loc_tcnt", getScLocTcnt());
		this.hashColumns.put("scc55", getScc55());
		this.hashColumns.put("scc18", getScc18());
		this.hashColumns.put("scc54", getScc54());
		this.hashColumns.put("scc19", getScc19());
		this.hashColumns.put("scc57", getScc57());
		this.hashColumns.put("scc56", getScc56());
		this.hashColumns.put("scc59", getScc59());
		this.hashColumns.put("scc58", getScc58());
		this.hashColumns.put("scc2", getScc2());
		this.hashColumns.put("scc1", getScc1());
		this.hashColumns.put("scc10", getScc10());
		this.hashColumns.put("scc11", getScc11());
		this.hashColumns.put("scc12", getScc12());
		this.hashColumns.put("scc13", getScc13());
		this.hashColumns.put("scc14", getScc14());
		this.hashColumns.put("scc15", getScc15());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("ft_flg", getFtFlg());
		return this.hashColumns;
	}

	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("scc4", "scc4");
		this.hashFields.put("scc3", "scc3");
		this.hashFields.put("sc_fm_dt", "scFmDt");
		this.hashFields.put("scc6", "scc6");
		this.hashFields.put("scc5", "scc5");
		this.hashFields.put("scc8", "scc8");
		this.hashFields.put("scc7", "scc7");
		this.hashFields.put("scc9", "scc9");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("scc26", "scc26");
		this.hashFields.put("scc25", "scc25");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("scc24", "scc24");
		this.hashFields.put("scc23", "scc23");
		this.hashFields.put("scc22", "scc22");
		this.hashFields.put("scc21", "scc21");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("scc20", "scc20");
		this.hashFields.put("scc_sort_tp", "sccSortTp");
		this.hashFields.put("scc29", "scc29");
		this.hashFields.put("scc28", "scc28");
		this.hashFields.put("scc27", "scc27");
		this.hashFields.put("scc63", "scc63");
		this.hashFields.put("sc_cust_nm", "scCustNm");
		this.hashFields.put("scc64", "scc64");
		this.hashFields.put("scc65", "scc65");
		this.hashFields.put("sc_cust_no", "scCustNo");
		this.hashFields.put("scc35", "scc35");
		this.hashFields.put("scc34", "scc34");
		this.hashFields.put("scc37", "scc37");
		this.hashFields.put("scc36", "scc36");
		this.hashFields.put("scc60", "scc60");
		this.hashFields.put("scc31", "scc31");
		this.hashFields.put("scc30", "scc30");
		this.hashFields.put("scc62", "scc62");
		this.hashFields.put("scc33", "scc33");
		this.hashFields.put("scc61", "scc61");
		this.hashFields.put("scc32", "scc32");
		this.hashFields.put("scc39", "scc39");
		this.hashFields.put("scc38", "scc38");
		this.hashFields.put("scc40", "scc40");
		this.hashFields.put("scc44", "scc44");
		this.hashFields.put("sc_sort_tp", "scSortTp");
		this.hashFields.put("scc43", "scc43");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("scc42", "scc42");
		this.hashFields.put("scc41", "scc41");
		this.hashFields.put("scc48", "scc48");
		this.hashFields.put("scc47", "scc47");
		this.hashFields.put("scc46", "scc46");
		this.hashFields.put("scc45", "scc45");
		this.hashFields.put("scc49", "scc49");
		this.hashFields.put("sc_to_dt", "scToDt");
		this.hashFields.put("scc50", "scc50");
		this.hashFields.put("scc51", "scc51");
		this.hashFields.put("scc53", "scc53");
		this.hashFields.put("scc16", "scc16");
		this.hashFields.put("scc52", "scc52");
		this.hashFields.put("scc17", "scc17");
		this.hashFields.put("sc_loc_tcnt", "scLocTcnt");
		this.hashFields.put("scc55", "scc55");
		this.hashFields.put("scc18", "scc18");
		this.hashFields.put("scc54", "scc54");
		this.hashFields.put("scc19", "scc19");
		this.hashFields.put("scc57", "scc57");
		this.hashFields.put("scc56", "scc56");
		this.hashFields.put("scc59", "scc59");
		this.hashFields.put("scc58", "scc58");
		this.hashFields.put("scc2", "scc2");
		this.hashFields.put("scc1", "scc1");
		this.hashFields.put("scc10", "scc10");
		this.hashFields.put("scc11", "scc11");
		this.hashFields.put("scc12", "scc12");
		this.hashFields.put("scc13", "scc13");
		this.hashFields.put("scc14", "scc14");
		this.hashFields.put("scc15", "scc15");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("ft_flg", "ftFlg");
		return this.hashFields;
	}
	public String getScc4() {
		return this.scc4;
	}

	public String getScc3() {
		return this.scc3;
	}

	public String getScFmDt() {
		return this.scFmDt;
	}

	public String getScc6() {
		return this.scc6;
	}

	public String getScc5() {
		return this.scc5;
	}

	public String getScc8() {
		return this.scc8;
	}

	public String getScc7() {
		return this.scc7;
	}

	public String getScc9() {
		return this.scc9;
	}

	public String getPagerows() {
		return this.pagerows;
	}

	public String getScc26() {
		return this.scc26;
	}

	public String getScc25() {
		return this.scc25;
	}

	public String getLocCd() {
		return this.locCd;
	}

	public String getScc24() {
		return this.scc24;
	}

	public String getScc23() {
		return this.scc23;
	}

	public String getScc22() {
		return this.scc22;
	}

	public String getScc21() {
		return this.scc21;
	}

	public String getScNo() {
		return this.scNo;
	}

	public String getScc20() {
		return this.scc20;
	}

	public String getSccSortTp() {
		return this.sccSortTp;
	}

	public String getScc29() {
		return this.scc29;
	}

	public String getScc28() {
		return this.scc28;
	}

	public String getScc27() {
		return this.scc27;
	}

	public String getScc63() {
		return this.scc63;
	}

	public String getScCustNm() {
		return this.scCustNm;
	}

	public String getScc64() {
		return this.scc64;
	}

	public String getScc65() {
		return this.scc65;
	}

	public String getScCustNo() {
		return this.scCustNo;
	}

	public String getScc35() {
		return this.scc35;
	}

	public String getScc34() {
		return this.scc34;
	}

	public String getScc37() {
		return this.scc37;
	}

	public String getScc36() {
		return this.scc36;
	}

	public String getScc60() {
		return this.scc60;
	}

	public String getScc31() {
		return this.scc31;
	}

	public String getScc30() {
		return this.scc30;
	}

	public String getScc62() {
		return this.scc62;
	}

	public String getScc33() {
		return this.scc33;
	}

	public String getScc61() {
		return this.scc61;
	}

	public String getScc32() {
		return this.scc32;
	}

	public String getScc39() {
		return this.scc39;
	}

	public String getScc38() {
		return this.scc38;
	}

	public String getScc40() {
		return this.scc40;
	}

	public String getScc44() {
		return this.scc44;
	}

	public String getScSortTp() {
		return this.scSortTp;
	}

	public String getScc43() {
		return this.scc43;
	}

	public String getIbflag() {
		return this.ibflag;
	}

	public String getScc42() {
		return this.scc42;
	}

	public String getScc41() {
		return this.scc41;
	}

	public String getScc48() {
		return this.scc48;
	}

	public String getScc47() {
		return this.scc47;
	}

	public String getScc46() {
		return this.scc46;
	}

	public String getScc45() {
		return this.scc45;
	}

	public String getScc49() {
		return this.scc49;
	}

	public String getScToDt() {
		return this.scToDt;
	}

	public String getScc50() {
		return this.scc50;
	}

	public String getScc51() {
		return this.scc51;
	}

	public String getScc53() {
		return this.scc53;
	}

	public String getScc16() {
		return this.scc16;
	}

	public String getScc52() {
		return this.scc52;
	}

	public String getScc17() {
		return this.scc17;
	}

	public String getScLocTcnt() {
		return this.scLocTcnt;
	}

	public String getScc55() {
		return this.scc55;
	}

	public String getScc18() {
		return this.scc18;
	}

	public String getScc54() {
		return this.scc54;
	}

	public String getScc19() {
		return this.scc19;
	}

	public String getScc57() {
		return this.scc57;
	}

	public String getScc56() {
		return this.scc56;
	}

	public String getScc59() {
		return this.scc59;
	}

	public String getScc58() {
		return this.scc58;
	}

	public String getScc2() {
		return this.scc2;
	}

	public String getScc1() {
		return this.scc1;
	}

	public String getScc10() {
		return this.scc10;
	}

	public String getScc11() {
		return this.scc11;
	}

	public String getScc12() {
		return this.scc12;
	}

	public String getScc13() {
		return this.scc13;
	}

	public String getScc14() {
		return this.scc14;
	}

	public String getScc15() {
		return this.scc15;
	}

	public String getEffDt() {
		return this.effDt;
	}

	public String getExpDt() {
		return this.expDt;
	}

	public String getFtFlg() {
		return this.ftFlg;
	}

	public void setScc4(String scc4) {
		this.scc4 = scc4;
	}

	public void setScc3(String scc3) {
		this.scc3 = scc3;
	}

	public void setScFmDt(String scFmDt) {
		this.scFmDt = scFmDt;
	}

	public void setScc6(String scc6) {
		this.scc6 = scc6;
	}

	public void setScc5(String scc5) {
		this.scc5 = scc5;
	}

	public void setScc8(String scc8) {
		this.scc8 = scc8;
	}

	public void setScc7(String scc7) {
		this.scc7 = scc7;
	}

	public void setScc9(String scc9) {
		this.scc9 = scc9;
	}

	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	public void setScc26(String scc26) {
		this.scc26 = scc26;
	}

	public void setScc25(String scc25) {
		this.scc25 = scc25;
	}

	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}

	public void setScc24(String scc24) {
		this.scc24 = scc24;
	}

	public void setScc23(String scc23) {
		this.scc23 = scc23;
	}

	public void setScc22(String scc22) {
		this.scc22 = scc22;
	}

	public void setScc21(String scc21) {
		this.scc21 = scc21;
	}

	public void setScNo(String scNo) {
		this.scNo = scNo;
	}

	public void setScc20(String scc20) {
		this.scc20 = scc20;
	}

	public void setSccSortTp(String sccSortTp) {
		this.sccSortTp = sccSortTp;
	}

	public void setScc29(String scc29) {
		this.scc29 = scc29;
	}

	public void setScc28(String scc28) {
		this.scc28 = scc28;
	}

	public void setScc27(String scc27) {
		this.scc27 = scc27;
	}

	public void setScc63(String scc63) {
		this.scc63 = scc63;
	}

	public void setScCustNm(String scCustNm) {
		this.scCustNm = scCustNm;
	}

	public void setScc64(String scc64) {
		this.scc64 = scc64;
	}

	public void setScc65(String scc65) {
		this.scc65 = scc65;
	}

	public void setScCustNo(String scCustNo) {
		this.scCustNo = scCustNo;
	}

	public void setScc35(String scc35) {
		this.scc35 = scc35;
	}

	public void setScc34(String scc34) {
		this.scc34 = scc34;
	}

	public void setScc37(String scc37) {
		this.scc37 = scc37;
	}

	public void setScc36(String scc36) {
		this.scc36 = scc36;
	}

	public void setScc60(String scc60) {
		this.scc60 = scc60;
	}

	public void setScc31(String scc31) {
		this.scc31 = scc31;
	}

	public void setScc30(String scc30) {
		this.scc30 = scc30;
	}

	public void setScc62(String scc62) {
		this.scc62 = scc62;
	}

	public void setScc33(String scc33) {
		this.scc33 = scc33;
	}

	public void setScc61(String scc61) {
		this.scc61 = scc61;
	}

	public void setScc32(String scc32) {
		this.scc32 = scc32;
	}

	public void setScc39(String scc39) {
		this.scc39 = scc39;
	}

	public void setScc38(String scc38) {
		this.scc38 = scc38;
	}

	public void setScc40(String scc40) {
		this.scc40 = scc40;
	}

	public void setScc44(String scc44) {
		this.scc44 = scc44;
	}

	public void setScSortTp(String scSortTp) {
		this.scSortTp = scSortTp;
	}

	public void setScc43(String scc43) {
		this.scc43 = scc43;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	public void setScc42(String scc42) {
		this.scc42 = scc42;
	}

	public void setScc41(String scc41) {
		this.scc41 = scc41;
	}

	public void setScc48(String scc48) {
		this.scc48 = scc48;
	}

	public void setScc47(String scc47) {
		this.scc47 = scc47;
	}

	public void setScc46(String scc46) {
		this.scc46 = scc46;
	}

	public void setScc45(String scc45) {
		this.scc45 = scc45;
	}

	public void setScc49(String scc49) {
		this.scc49 = scc49;
	}

	public void setScToDt(String scToDt) {
		this.scToDt = scToDt;
	}

	public void setScc50(String scc50) {
		this.scc50 = scc50;
	}

	public void setScc51(String scc51) {
		this.scc51 = scc51;
	}

	public void setScc53(String scc53) {
		this.scc53 = scc53;
	}

	public void setScc16(String scc16) {
		this.scc16 = scc16;
	}

	public void setScc52(String scc52) {
		this.scc52 = scc52;
	}

	public void setScc17(String scc17) {
		this.scc17 = scc17;
	}

	public void setScLocTcnt(String scLocTcnt) {
		this.scLocTcnt = scLocTcnt;
	}

	public void setScc55(String scc55) {
		this.scc55 = scc55;
	}

	public void setScc18(String scc18) {
		this.scc18 = scc18;
	}

	public void setScc54(String scc54) {
		this.scc54 = scc54;
	}

	public void setScc19(String scc19) {
		this.scc19 = scc19;
	}

	public void setScc57(String scc57) {
		this.scc57 = scc57;
	}

	public void setScc56(String scc56) {
		this.scc56 = scc56;
	}

	public void setScc59(String scc59) {
		this.scc59 = scc59;
	}

	public void setScc58(String scc58) {
		this.scc58 = scc58;
	}

	public void setScc2(String scc2) {
		this.scc2 = scc2;
	}

	public void setScc1(String scc1) {
		this.scc1 = scc1;
	}

	public void setScc10(String scc10) {
		this.scc10 = scc10;
	}

	public void setScc11(String scc11) {
		this.scc11 = scc11;
	}

	public void setScc12(String scc12) {
		this.scc12 = scc12;
	}

	public void setScc13(String scc13) {
		this.scc13 = scc13;
	}

	public void setScc14(String scc14) {
		this.scc14 = scc14;
	}

	public void setScc15(String scc15) {
		this.scc15 = scc15;
	}

	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}

	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}

	public void setFtFlg(String ftFlg) {
		this.ftFlg = ftFlg;
	}

	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	public void fromRequest(HttpServletRequest request, String prefix) {
		setScc4(JSPUtil.getParameter(request, prefix + "scc4", ""));
		setScc3(JSPUtil.getParameter(request, prefix + "scc3", ""));
		setScFmDt(JSPUtil.getParameter(request, prefix + "sc_fm_dt", ""));
		setScc6(JSPUtil.getParameter(request, prefix + "scc6", ""));
		setScc5(JSPUtil.getParameter(request, prefix + "scc5", ""));
		setScc8(JSPUtil.getParameter(request, prefix + "scc8", ""));
		setScc7(JSPUtil.getParameter(request, prefix + "scc7", ""));
		setScc9(JSPUtil.getParameter(request, prefix + "scc9", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setScc26(JSPUtil.getParameter(request, prefix + "scc26", ""));
		setScc25(JSPUtil.getParameter(request, prefix + "scc25", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setScc24(JSPUtil.getParameter(request, prefix + "scc24", ""));
		setScc23(JSPUtil.getParameter(request, prefix + "scc23", ""));
		setScc22(JSPUtil.getParameter(request, prefix + "scc22", ""));
		setScc21(JSPUtil.getParameter(request, prefix + "scc21", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setScc20(JSPUtil.getParameter(request, prefix + "scc20", ""));
		setSccSortTp(JSPUtil.getParameter(request, prefix + "scc_sort_tp", ""));
		setScc29(JSPUtil.getParameter(request, prefix + "scc29", ""));
		setScc28(JSPUtil.getParameter(request, prefix + "scc28", ""));
		setScc27(JSPUtil.getParameter(request, prefix + "scc27", ""));
		setScc63(JSPUtil.getParameter(request, prefix + "scc63", ""));
		setScCustNm(JSPUtil.getParameter(request, prefix + "sc_cust_nm", ""));
		setScc64(JSPUtil.getParameter(request, prefix + "scc64", ""));
		setScc65(JSPUtil.getParameter(request, prefix + "scc65", ""));
		setScCustNo(JSPUtil.getParameter(request, prefix + "sc_cust_no", ""));
		setScc35(JSPUtil.getParameter(request, prefix + "scc35", ""));
		setScc34(JSPUtil.getParameter(request, prefix + "scc34", ""));
		setScc37(JSPUtil.getParameter(request, prefix + "scc37", ""));
		setScc36(JSPUtil.getParameter(request, prefix + "scc36", ""));
		setScc60(JSPUtil.getParameter(request, prefix + "scc60", ""));
		setScc31(JSPUtil.getParameter(request, prefix + "scc31", ""));
		setScc30(JSPUtil.getParameter(request, prefix + "scc30", ""));
		setScc62(JSPUtil.getParameter(request, prefix + "scc62", ""));
		setScc33(JSPUtil.getParameter(request, prefix + "scc33", ""));
		setScc61(JSPUtil.getParameter(request, prefix + "scc61", ""));
		setScc32(JSPUtil.getParameter(request, prefix + "scc32", ""));
		setScc39(JSPUtil.getParameter(request, prefix + "scc39", ""));
		setScc38(JSPUtil.getParameter(request, prefix + "scc38", ""));
		setScc40(JSPUtil.getParameter(request, prefix + "scc40", ""));
		setScc44(JSPUtil.getParameter(request, prefix + "scc44", ""));
		setScSortTp(JSPUtil.getParameter(request, prefix + "sc_sort_tp", ""));
		setScc43(JSPUtil.getParameter(request, prefix + "scc43", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setScc42(JSPUtil.getParameter(request, prefix + "scc42", ""));
		setScc41(JSPUtil.getParameter(request, prefix + "scc41", ""));
		setScc48(JSPUtil.getParameter(request, prefix + "scc48", ""));
		setScc47(JSPUtil.getParameter(request, prefix + "scc47", ""));
		setScc46(JSPUtil.getParameter(request, prefix + "scc46", ""));
		setScc45(JSPUtil.getParameter(request, prefix + "scc45", ""));
		setScc49(JSPUtil.getParameter(request, prefix + "scc49", ""));
		setScToDt(JSPUtil.getParameter(request, prefix + "sc_to_dt", ""));
		setScc50(JSPUtil.getParameter(request, prefix + "scc50", ""));
		setScc51(JSPUtil.getParameter(request, prefix + "scc51", ""));
		setScc53(JSPUtil.getParameter(request, prefix + "scc53", ""));
		setScc16(JSPUtil.getParameter(request, prefix + "scc16", ""));
		setScc52(JSPUtil.getParameter(request, prefix + "scc52", ""));
		setScc17(JSPUtil.getParameter(request, prefix + "scc17", ""));
		setScLocTcnt(JSPUtil.getParameter(request, prefix + "sc_loc_tcnt", ""));
		setScc55(JSPUtil.getParameter(request, prefix + "scc55", ""));
		setScc18(JSPUtil.getParameter(request, prefix + "scc18", ""));
		setScc54(JSPUtil.getParameter(request, prefix + "scc54", ""));
		setScc19(JSPUtil.getParameter(request, prefix + "scc19", ""));
		setScc57(JSPUtil.getParameter(request, prefix + "scc57", ""));
		setScc56(JSPUtil.getParameter(request, prefix + "scc56", ""));
		setScc59(JSPUtil.getParameter(request, prefix + "scc59", ""));
		setScc58(JSPUtil.getParameter(request, prefix + "scc58", ""));
		setScc2(JSPUtil.getParameter(request, prefix + "scc2", ""));
		setScc1(JSPUtil.getParameter(request, prefix + "scc1", ""));
		setScc10(JSPUtil.getParameter(request, prefix + "scc10", ""));
		setScc11(JSPUtil.getParameter(request, prefix + "scc11", ""));
		setScc12(JSPUtil.getParameter(request, prefix + "scc12", ""));
		setScc13(JSPUtil.getParameter(request, prefix + "scc13", ""));
		setScc14(JSPUtil.getParameter(request, prefix + "scc14", ""));
		setScc15(JSPUtil.getParameter(request, prefix + "scc15", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setFtFlg(JSPUtil.getParameter(request, prefix + "ft_flg", ""));
	}

	public CHSScExceptionINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CHSScExceptionINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSScExceptionINVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if(tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] scc4 = (JSPUtil.getParameter(request, prefix	+ "scc4", length));
			String[] scc3 = (JSPUtil.getParameter(request, prefix	+ "scc3", length));
			String[] scFmDt = (JSPUtil.getParameter(request, prefix	+ "sc_fm_dt", length));
			String[] scc6 = (JSPUtil.getParameter(request, prefix	+ "scc6", length));
			String[] scc5 = (JSPUtil.getParameter(request, prefix	+ "scc5", length));
			String[] scc8 = (JSPUtil.getParameter(request, prefix	+ "scc8", length));
			String[] scc7 = (JSPUtil.getParameter(request, prefix	+ "scc7", length));
			String[] scc9 = (JSPUtil.getParameter(request, prefix	+ "scc9", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] scc26 = (JSPUtil.getParameter(request, prefix	+ "scc26", length));
			String[] scc25 = (JSPUtil.getParameter(request, prefix	+ "scc25", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] scc24 = (JSPUtil.getParameter(request, prefix	+ "scc24", length));
			String[] scc23 = (JSPUtil.getParameter(request, prefix	+ "scc23", length));
			String[] scc22 = (JSPUtil.getParameter(request, prefix	+ "scc22", length));
			String[] scc21 = (JSPUtil.getParameter(request, prefix	+ "scc21", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] scc20 = (JSPUtil.getParameter(request, prefix	+ "scc20", length));
			String[] sccSortTp = (JSPUtil.getParameter(request, prefix	+ "scc_sort_tp", length));
			String[] scc29 = (JSPUtil.getParameter(request, prefix	+ "scc29", length));
			String[] scc28 = (JSPUtil.getParameter(request, prefix	+ "scc28", length));
			String[] scc27 = (JSPUtil.getParameter(request, prefix	+ "scc27", length));
			String[] scc63 = (JSPUtil.getParameter(request, prefix	+ "scc63", length));
			String[] scCustNm = (JSPUtil.getParameter(request, prefix	+ "sc_cust_nm", length));
			String[] scc64 = (JSPUtil.getParameter(request, prefix	+ "scc64", length));
			String[] scc65 = (JSPUtil.getParameter(request, prefix	+ "scc65", length));
			String[] scCustNo = (JSPUtil.getParameter(request, prefix	+ "sc_cust_no", length));
			String[] scc35 = (JSPUtil.getParameter(request, prefix	+ "scc35", length));
			String[] scc34 = (JSPUtil.getParameter(request, prefix	+ "scc34", length));
			String[] scc37 = (JSPUtil.getParameter(request, prefix	+ "scc37", length));
			String[] scc36 = (JSPUtil.getParameter(request, prefix	+ "scc36", length));
			String[] scc60 = (JSPUtil.getParameter(request, prefix	+ "scc60", length));
			String[] scc31 = (JSPUtil.getParameter(request, prefix	+ "scc31", length));
			String[] scc30 = (JSPUtil.getParameter(request, prefix	+ "scc30", length));
			String[] scc62 = (JSPUtil.getParameter(request, prefix	+ "scc62", length));
			String[] scc33 = (JSPUtil.getParameter(request, prefix	+ "scc33", length));
			String[] scc61 = (JSPUtil.getParameter(request, prefix	+ "scc61", length));
			String[] scc32 = (JSPUtil.getParameter(request, prefix	+ "scc32", length));
			String[] scc39 = (JSPUtil.getParameter(request, prefix	+ "scc39", length));
			String[] scc38 = (JSPUtil.getParameter(request, prefix	+ "scc38", length));
			String[] scc40 = (JSPUtil.getParameter(request, prefix	+ "scc40", length));
			String[] scc44 = (JSPUtil.getParameter(request, prefix	+ "scc44", length));
			String[] scSortTp = (JSPUtil.getParameter(request, prefix	+ "sc_sort_tp", length));
			String[] scc43 = (JSPUtil.getParameter(request, prefix	+ "scc43", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] scc42 = (JSPUtil.getParameter(request, prefix	+ "scc42", length));
			String[] scc41 = (JSPUtil.getParameter(request, prefix	+ "scc41", length));
			String[] scc48 = (JSPUtil.getParameter(request, prefix	+ "scc48", length));
			String[] scc47 = (JSPUtil.getParameter(request, prefix	+ "scc47", length));
			String[] scc46 = (JSPUtil.getParameter(request, prefix	+ "scc46", length));
			String[] scc45 = (JSPUtil.getParameter(request, prefix	+ "scc45", length));
			String[] scc49 = (JSPUtil.getParameter(request, prefix	+ "scc49", length));
			String[] scToDt = (JSPUtil.getParameter(request, prefix	+ "sc_to_dt", length));
			String[] scc50 = (JSPUtil.getParameter(request, prefix	+ "scc50", length));
			String[] scc51 = (JSPUtil.getParameter(request, prefix	+ "scc51", length));
			String[] scc53 = (JSPUtil.getParameter(request, prefix	+ "scc53", length));
			String[] scc16 = (JSPUtil.getParameter(request, prefix	+ "scc16", length));
			String[] scc52 = (JSPUtil.getParameter(request, prefix	+ "scc52", length));
			String[] scc17 = (JSPUtil.getParameter(request, prefix	+ "scc17", length));
			String[] scLocTcnt = (JSPUtil.getParameter(request, prefix	+ "sc_loc_tcnt", length));
			String[] scc55 = (JSPUtil.getParameter(request, prefix	+ "scc55", length));
			String[] scc18 = (JSPUtil.getParameter(request, prefix	+ "scc18", length));
			String[] scc54 = (JSPUtil.getParameter(request, prefix	+ "scc54", length));
			String[] scc19 = (JSPUtil.getParameter(request, prefix	+ "scc19", length));
			String[] scc57 = (JSPUtil.getParameter(request, prefix	+ "scc57", length));
			String[] scc56 = (JSPUtil.getParameter(request, prefix	+ "scc56", length));
			String[] scc59 = (JSPUtil.getParameter(request, prefix	+ "scc59", length));
			String[] scc58 = (JSPUtil.getParameter(request, prefix	+ "scc58", length));
			String[] scc2 = (JSPUtil.getParameter(request, prefix	+ "scc2", length));
			String[] scc1 = (JSPUtil.getParameter(request, prefix	+ "scc1", length));
			String[] scc10 = (JSPUtil.getParameter(request, prefix	+ "scc10", length));
			String[] scc11 = (JSPUtil.getParameter(request, prefix	+ "scc11", length));
			String[] scc12 = (JSPUtil.getParameter(request, prefix	+ "scc12", length));
			String[] scc13 = (JSPUtil.getParameter(request, prefix	+ "scc13", length));
			String[] scc14 = (JSPUtil.getParameter(request, prefix	+ "scc14", length));
			String[] scc15 = (JSPUtil.getParameter(request, prefix	+ "scc15", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] ftFlg = (JSPUtil.getParameter(request, prefix	+ "ft_flg", length));
			for (int i = 0; i < length; i++) {
				model = new CHSScExceptionINVO();
				if (scc4[i] != null)
					model.setScc4(scc4[i]);
				if (scc3[i] != null)
					model.setScc3(scc3[i]);
				if (scFmDt[i] != null)
					model.setScFmDt(scFmDt[i]);
				if (scc6[i] != null)
					model.setScc6(scc6[i]);
				if (scc5[i] != null)
					model.setScc5(scc5[i]);
				if (scc8[i] != null)
					model.setScc8(scc8[i]);
				if (scc7[i] != null)
					model.setScc7(scc7[i]);
				if (scc9[i] != null)
					model.setScc9(scc9[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (scc26[i] != null)
					model.setScc26(scc26[i]);
				if (scc25[i] != null)
					model.setScc25(scc25[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (scc24[i] != null)
					model.setScc24(scc24[i]);
				if (scc23[i] != null)
					model.setScc23(scc23[i]);
				if (scc22[i] != null)
					model.setScc22(scc22[i]);
				if (scc21[i] != null)
					model.setScc21(scc21[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (scc20[i] != null)
					model.setScc20(scc20[i]);
				if (sccSortTp[i] != null)
					model.setSccSortTp(sccSortTp[i]);
				if (scc29[i] != null)
					model.setScc29(scc29[i]);
				if (scc28[i] != null)
					model.setScc28(scc28[i]);
				if (scc27[i] != null)
					model.setScc27(scc27[i]);
				if (scc63[i] != null)
					model.setScc63(scc63[i]);
				if (scCustNm[i] != null)
					model.setScCustNm(scCustNm[i]);
				if (scc64[i] != null)
					model.setScc64(scc64[i]);
				if (scc65[i] != null)
					model.setScc65(scc65[i]);
				if (scCustNo[i] != null)
					model.setScCustNo(scCustNo[i]);
				if (scc35[i] != null)
					model.setScc35(scc35[i]);
				if (scc34[i] != null)
					model.setScc34(scc34[i]);
				if (scc37[i] != null)
					model.setScc37(scc37[i]);
				if (scc36[i] != null)
					model.setScc36(scc36[i]);
				if (scc60[i] != null)
					model.setScc60(scc60[i]);
				if (scc31[i] != null)
					model.setScc31(scc31[i]);
				if (scc30[i] != null)
					model.setScc30(scc30[i]);
				if (scc62[i] != null)
					model.setScc62(scc62[i]);
				if (scc33[i] != null)
					model.setScc33(scc33[i]);
				if (scc61[i] != null)
					model.setScc61(scc61[i]);
				if (scc32[i] != null)
					model.setScc32(scc32[i]);
				if (scc39[i] != null)
					model.setScc39(scc39[i]);
				if (scc38[i] != null)
					model.setScc38(scc38[i]);
				if (scc40[i] != null)
					model.setScc40(scc40[i]);
				if (scc44[i] != null)
					model.setScc44(scc44[i]);
				if (scSortTp[i] != null)
					model.setScSortTp(scSortTp[i]);
				if (scc43[i] != null)
					model.setScc43(scc43[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (scc42[i] != null)
					model.setScc42(scc42[i]);
				if (scc41[i] != null)
					model.setScc41(scc41[i]);
				if (scc48[i] != null)
					model.setScc48(scc48[i]);
				if (scc47[i] != null)
					model.setScc47(scc47[i]);
				if (scc46[i] != null)
					model.setScc46(scc46[i]);
				if (scc45[i] != null)
					model.setScc45(scc45[i]);
				if (scc49[i] != null)
					model.setScc49(scc49[i]);
				if (scToDt[i] != null)
					model.setScToDt(scToDt[i]);
				if (scc50[i] != null)
					model.setScc50(scc50[i]);
				if (scc51[i] != null)
					model.setScc51(scc51[i]);
				if (scc53[i] != null)
					model.setScc53(scc53[i]);
				if (scc16[i] != null)
					model.setScc16(scc16[i]);
				if (scc52[i] != null)
					model.setScc52(scc52[i]);
				if (scc17[i] != null)
					model.setScc17(scc17[i]);
				if (scLocTcnt[i] != null)
					model.setScLocTcnt(scLocTcnt[i]);
				if (scc55[i] != null)
					model.setScc55(scc55[i]);
				if (scc18[i] != null)
					model.setScc18(scc18[i]);
				if (scc54[i] != null)
					model.setScc54(scc54[i]);
				if (scc19[i] != null)
					model.setScc19(scc19[i]);
				if (scc57[i] != null)
					model.setScc57(scc57[i]);
				if (scc56[i] != null)
					model.setScc56(scc56[i]);
				if (scc59[i] != null)
					model.setScc59(scc59[i]);
				if (scc58[i] != null)
					model.setScc58(scc58[i]);
				if (scc2[i] != null)
					model.setScc2(scc2[i]);
				if (scc1[i] != null)
					model.setScc1(scc1[i]);
				if (scc10[i] != null)
					model.setScc10(scc10[i]);
				if (scc11[i] != null)
					model.setScc11(scc11[i]);
				if (scc12[i] != null)
					model.setScc12(scc12[i]);
				if (scc13[i] != null)
					model.setScc13(scc13[i]);
				if (scc14[i] != null)
					model.setScc14(scc14[i]);
				if (scc15[i] != null)
					model.setScc15(scc15[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (ftFlg[i] != null)
					model.setFtFlg(ftFlg[i]);
				models.add(model);
			}
		 } catch (Exception e) {
			return null;
		}
		return getCHSScExceptionINVOs();
	}

	public CHSScExceptionINVO[] getCHSScExceptionINVOs(){
		CHSScExceptionINVO[] vos = (CHSScExceptionINVO[])models.toArray(new CHSScExceptionINVO[models.size()]);
		return vos;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}

	public void unDataFormat(){
		this.scc4 = this.scc4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc3 = this.scc3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scFmDt = this.scFmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc6 = this.scc6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc5 = this.scc5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc8 = this.scc8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc7 = this.scc7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc9 = this.scc9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc26 = this.scc26.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc25 = this.scc25.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc24 = this.scc24.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc23 = this.scc23.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc22 = this.scc22.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc21 = this.scc21.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc20 = this.scc20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccSortTp = this.sccSortTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc29 = this.scc29.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc28 = this.scc28.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc27 = this.scc27.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc63 = this.scc63.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scCustNm = this.scCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc64 = this.scc64.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc65 = this.scc65.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scCustNo = this.scCustNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc35 = this.scc35.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc34 = this.scc34.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc37 = this.scc37.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc36 = this.scc36.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc60 = this.scc60.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc31 = this.scc31.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc30 = this.scc30.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc62 = this.scc62.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc33 = this.scc33.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc61 = this.scc61.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc32 = this.scc32.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc39 = this.scc39.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc38 = this.scc38.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc40 = this.scc40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc44 = this.scc44.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scSortTp = this.scSortTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc43 = this.scc43.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc42 = this.scc42.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc41 = this.scc41.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc48 = this.scc48.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc47 = this.scc47.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc46 = this.scc46.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc45 = this.scc45.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc49 = this.scc49.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scToDt = this.scToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc50 = this.scc50.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc51 = this.scc51.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc53 = this.scc53.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc16 = this.scc16.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc52 = this.scc52.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc17 = this.scc17.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scLocTcnt = this.scLocTcnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc55 = this.scc55.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc18 = this.scc18.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc54 = this.scc54.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc19 = this.scc19.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc57 = this.scc57.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc56 = this.scc56.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc59 = this.scc59.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc58 = this.scc58.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc2 = this.scc2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc1 = this.scc1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc10 = this.scc10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc11 = this.scc11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc12 = this.scc12.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc13 = this.scc13.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc14 = this.scc14.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc15 = this.scc15.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftFlg = this.ftFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
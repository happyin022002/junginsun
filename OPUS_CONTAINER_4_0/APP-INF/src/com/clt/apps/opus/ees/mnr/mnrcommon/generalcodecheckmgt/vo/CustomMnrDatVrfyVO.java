/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomMnrDatVrfyVO.java
*@FileTitle : CustomMnrDatVrfyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.10.05 박명신 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrDatVrfyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrDatVrfyVO> models = new ArrayList<CustomMnrDatVrfyVO>();
	
	/* Column Info */
	private String inpMsg2 = null;
	/* Column Info */
	private String inpMsg3 = null;
	/* Column Info */
	private String tempValue9 = null;
	/* Column Info */
	private String inpMsg4 = null;
	/* Column Info */
	private String inpMsg5 = null;
	/* Column Info */
	private String tempValue7 = null;
	/* Column Info */
	private String tempValue8 = null;
	/* Column Info */
	private String tempValue5 = null;
	/* Column Info */
	private String tempValue6 = null;
	/* Column Info */
	private String inpMsg1 = null;
	/* Column Info */
	private String tempValue3 = null;
	/* Column Info */
	private String tempValue4 = null;
	/* Column Info */
	private String tempValue1 = null;
	/* Column Info */
	private String tempValue2 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String inpMsg48 = null;
	/* Column Info */
	private String inpMsg49 = null;
	/* Column Info */
	private String inpMsg46 = null;
	/* Column Info */
	private String inpMsg47 = null;
	/* Column Info */
	private String inpMsg44 = null;
	/* Column Info */
	private String inpMsg45 = null;
	/* Column Info */
	private String inpMsg42 = null;
	/* Column Info */
	private String inpMsg43 = null;
	/* Column Info */
	private String inpMsg40 = null;
	/* Column Info */
	private String inpMsg41 = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String inpMsg10 = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String inpMsg12 = null;
	/* Column Info */
	private String inpMsg11 = null;
	/* Column Info */
	private String inpMsg18 = null;
	/* Column Info */
	private String inpMsg17 = null;
	/* Column Info */
	private String inpMsg19 = null;
	/* Column Info */
	private String inpMsg9 = null;
	/* Column Info */
	private String inpMsg14 = null;
	/* Column Info */
	private String inpMsg50 = null;
	/* Column Info */
	private String inpMsg8 = null;
	/* Column Info */
	private String inpMsg13 = null;
	/* Column Info */
	private String inpMsg16 = null;
	/* Column Info */
	private String inpMsg7 = null;
	/* Column Info */
	private String tmpDtlSeq = null;
	/* Column Info */
	private String inpMsg15 = null;
	/* Column Info */
	private String inpMsg6 = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String tmpSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inpMsg23 = null;
	/* Column Info */
	private String inpMsg22 = null;
	/* Column Info */
	private String inpMsg21 = null;
	/* Column Info */
	private String inpMsg20 = null;
	/* Column Info */
	private String inpMsg27 = null;
	/* Column Info */
	private String inpMsg26 = null;
	/* Column Info */
	private String tempValue10 = null;
	/* Column Info */
	private String inpMsg25 = null;
	/* Column Info */
	private String inpMsg24 = null;
	/* Column Info */
	private String inpMsg29 = null;
	/* Column Info */
	private String inpMsg28 = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String inpMsg30 = null;
	/* Column Info */
	private String inpMsg32 = null;
	/* Column Info */
	private String inpMsg31 = null;
	/* Column Info */
	private String inpMsg34 = null;
	/* Column Info */
	private String inpMsg33 = null;
	/* Column Info */
	private String checkbox = null;
	/* Column Info */
	private String inpMsg36 = null;
	/* Column Info */
	private String inpMsg35 = null;
	/* Column Info */
	private String inpMsg38 = null;
	/* Column Info */
	private String inpMsg37 = null;
	/* Column Info */
	private String inpMsg39 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomMnrDatVrfyVO() {}

	public CustomMnrDatVrfyVO(String ibflag, String pagerows, String inpMsg2, String inpMsg3, String tempValue9, String inpMsg4, String inpMsg5, String tempValue7, String tempValue8, String tempValue5, String tempValue6, String inpMsg1, String tempValue3, String tempValue4, String tempValue1, String tempValue2, String inpMsg40, String updUsrId, String inpMsg10, String inpMsg12, String creUsrId, String inpMsg11, String inpMsg18, String inpMsg17, String inpMsg19, String inpMsg9, String inpMsg14, String inpMsg8, String inpMsg13, String inpMsg16, String inpMsg7, String tmpDtlSeq, String inpMsg15, String inpMsg6, String creDt, String tmpSeq, String inpMsg23, String inpMsg22, String inpMsg21, String inpMsg20, String inpMsg27, String inpMsg26, String tempValue10, String inpMsg25, String inpMsg24, String inpMsg29, String inpMsg28, String updDt, String inpMsg30, String inpMsg32, String inpMsg31, String inpMsg34, String inpMsg33, String inpMsg36, String checkbox, String inpMsg35, String inpMsg38, String inpMsg37, String inpMsg39, String inpMsg41, String inpMsg42, String inpMsg43, String inpMsg44, String inpMsg45, String inpMsg46, String inpMsg47, String inpMsg48, String inpMsg49, String inpMsg50) {
		this.inpMsg2 = inpMsg2;
		this.inpMsg3 = inpMsg3;
		this.tempValue9 = tempValue9;
		this.inpMsg4 = inpMsg4;
		this.inpMsg5 = inpMsg5;
		this.tempValue7 = tempValue7;
		this.tempValue8 = tempValue8;
		this.tempValue5 = tempValue5;
		this.tempValue6 = tempValue6;
		this.inpMsg1 = inpMsg1;
		this.tempValue3 = tempValue3;
		this.tempValue4 = tempValue4;
		this.tempValue1 = tempValue1;
		this.tempValue2 = tempValue2;
		this.pagerows = pagerows;
		this.inpMsg48 = inpMsg48;
		this.inpMsg49 = inpMsg49;
		this.inpMsg46 = inpMsg46;
		this.inpMsg47 = inpMsg47;
		this.inpMsg44 = inpMsg44;
		this.inpMsg45 = inpMsg45;
		this.inpMsg42 = inpMsg42;
		this.inpMsg43 = inpMsg43;
		this.inpMsg40 = inpMsg40;
		this.inpMsg41 = inpMsg41;
		this.updUsrId = updUsrId;
		this.inpMsg10 = inpMsg10;
		this.creUsrId = creUsrId;
		this.inpMsg12 = inpMsg12;
		this.inpMsg11 = inpMsg11;
		this.inpMsg18 = inpMsg18;
		this.inpMsg17 = inpMsg17;
		this.inpMsg19 = inpMsg19;
		this.inpMsg9 = inpMsg9;
		this.inpMsg14 = inpMsg14;
		this.inpMsg50 = inpMsg50;
		this.inpMsg8 = inpMsg8;
		this.inpMsg13 = inpMsg13;
		this.inpMsg16 = inpMsg16;
		this.inpMsg7 = inpMsg7;
		this.tmpDtlSeq = tmpDtlSeq;
		this.inpMsg15 = inpMsg15;
		this.inpMsg6 = inpMsg6;
		this.creDt = creDt;
		this.tmpSeq = tmpSeq;
		this.ibflag = ibflag;
		this.inpMsg23 = inpMsg23;
		this.inpMsg22 = inpMsg22;
		this.inpMsg21 = inpMsg21;
		this.inpMsg20 = inpMsg20;
		this.inpMsg27 = inpMsg27;
		this.inpMsg26 = inpMsg26;
		this.tempValue10 = tempValue10;
		this.inpMsg25 = inpMsg25;
		this.inpMsg24 = inpMsg24;
		this.inpMsg29 = inpMsg29;
		this.inpMsg28 = inpMsg28;
		this.updDt = updDt;
		this.inpMsg30 = inpMsg30;
		this.inpMsg32 = inpMsg32;
		this.inpMsg31 = inpMsg31;
		this.inpMsg34 = inpMsg34;
		this.inpMsg33 = inpMsg33;
		this.checkbox = checkbox;
		this.inpMsg36 = inpMsg36;
		this.inpMsg35 = inpMsg35;
		this.inpMsg38 = inpMsg38;
		this.inpMsg37 = inpMsg37;
		this.inpMsg39 = inpMsg39;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inp_msg2", getInpMsg2());
		this.hashColumns.put("inp_msg3", getInpMsg3());
		this.hashColumns.put("temp_value9", getTempValue9());
		this.hashColumns.put("inp_msg4", getInpMsg4());
		this.hashColumns.put("inp_msg5", getInpMsg5());
		this.hashColumns.put("temp_value7", getTempValue7());
		this.hashColumns.put("temp_value8", getTempValue8());
		this.hashColumns.put("temp_value5", getTempValue5());
		this.hashColumns.put("temp_value6", getTempValue6());
		this.hashColumns.put("inp_msg1", getInpMsg1());
		this.hashColumns.put("temp_value3", getTempValue3());
		this.hashColumns.put("temp_value4", getTempValue4());
		this.hashColumns.put("temp_value1", getTempValue1());
		this.hashColumns.put("temp_value2", getTempValue2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inp_msg48", getInpMsg48());
		this.hashColumns.put("inp_msg49", getInpMsg49());
		this.hashColumns.put("inp_msg46", getInpMsg46());
		this.hashColumns.put("inp_msg47", getInpMsg47());
		this.hashColumns.put("inp_msg44", getInpMsg44());
		this.hashColumns.put("inp_msg45", getInpMsg45());
		this.hashColumns.put("inp_msg42", getInpMsg42());
		this.hashColumns.put("inp_msg43", getInpMsg43());
		this.hashColumns.put("inp_msg40", getInpMsg40());
		this.hashColumns.put("inp_msg41", getInpMsg41());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("inp_msg10", getInpMsg10());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("inp_msg12", getInpMsg12());
		this.hashColumns.put("inp_msg11", getInpMsg11());
		this.hashColumns.put("inp_msg18", getInpMsg18());
		this.hashColumns.put("inp_msg17", getInpMsg17());
		this.hashColumns.put("inp_msg19", getInpMsg19());
		this.hashColumns.put("inp_msg9", getInpMsg9());
		this.hashColumns.put("inp_msg14", getInpMsg14());
		this.hashColumns.put("inp_msg50", getInpMsg50());
		this.hashColumns.put("inp_msg8", getInpMsg8());
		this.hashColumns.put("inp_msg13", getInpMsg13());
		this.hashColumns.put("inp_msg16", getInpMsg16());
		this.hashColumns.put("inp_msg7", getInpMsg7());
		this.hashColumns.put("tmp_dtl_seq", getTmpDtlSeq());
		this.hashColumns.put("inp_msg15", getInpMsg15());
		this.hashColumns.put("inp_msg6", getInpMsg6());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("tmp_seq", getTmpSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inp_msg23", getInpMsg23());
		this.hashColumns.put("inp_msg22", getInpMsg22());
		this.hashColumns.put("inp_msg21", getInpMsg21());
		this.hashColumns.put("inp_msg20", getInpMsg20());
		this.hashColumns.put("inp_msg27", getInpMsg27());
		this.hashColumns.put("inp_msg26", getInpMsg26());
		this.hashColumns.put("temp_value10", getTempValue10());
		this.hashColumns.put("inp_msg25", getInpMsg25());
		this.hashColumns.put("inp_msg24", getInpMsg24());
		this.hashColumns.put("inp_msg29", getInpMsg29());
		this.hashColumns.put("inp_msg28", getInpMsg28());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("inp_msg30", getInpMsg30());
		this.hashColumns.put("inp_msg32", getInpMsg32());
		this.hashColumns.put("inp_msg31", getInpMsg31());
		this.hashColumns.put("inp_msg34", getInpMsg34());
		this.hashColumns.put("inp_msg33", getInpMsg33());
		this.hashColumns.put("checkbox", getCheckbox());
		this.hashColumns.put("inp_msg36", getInpMsg36());
		this.hashColumns.put("inp_msg35", getInpMsg35());
		this.hashColumns.put("inp_msg38", getInpMsg38());
		this.hashColumns.put("inp_msg37", getInpMsg37());
		this.hashColumns.put("inp_msg39", getInpMsg39());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inp_msg2", "inpMsg2");
		this.hashFields.put("inp_msg3", "inpMsg3");
		this.hashFields.put("temp_value9", "tempValue9");
		this.hashFields.put("inp_msg4", "inpMsg4");
		this.hashFields.put("inp_msg5", "inpMsg5");
		this.hashFields.put("temp_value7", "tempValue7");
		this.hashFields.put("temp_value8", "tempValue8");
		this.hashFields.put("temp_value5", "tempValue5");
		this.hashFields.put("temp_value6", "tempValue6");
		this.hashFields.put("inp_msg1", "inpMsg1");
		this.hashFields.put("temp_value3", "tempValue3");
		this.hashFields.put("temp_value4", "tempValue4");
		this.hashFields.put("temp_value1", "tempValue1");
		this.hashFields.put("temp_value2", "tempValue2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inp_msg48", "inpMsg48");
		this.hashFields.put("inp_msg49", "inpMsg49");
		this.hashFields.put("inp_msg46", "inpMsg46");
		this.hashFields.put("inp_msg47", "inpMsg47");
		this.hashFields.put("inp_msg44", "inpMsg44");
		this.hashFields.put("inp_msg45", "inpMsg45");
		this.hashFields.put("inp_msg42", "inpMsg42");
		this.hashFields.put("inp_msg43", "inpMsg43");
		this.hashFields.put("inp_msg40", "inpMsg40");
		this.hashFields.put("inp_msg41", "inpMsg41");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("inp_msg10", "inpMsg10");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("inp_msg12", "inpMsg12");
		this.hashFields.put("inp_msg11", "inpMsg11");
		this.hashFields.put("inp_msg18", "inpMsg18");
		this.hashFields.put("inp_msg17", "inpMsg17");
		this.hashFields.put("inp_msg19", "inpMsg19");
		this.hashFields.put("inp_msg9", "inpMsg9");
		this.hashFields.put("inp_msg14", "inpMsg14");
		this.hashFields.put("inp_msg50", "inpMsg50");
		this.hashFields.put("inp_msg8", "inpMsg8");
		this.hashFields.put("inp_msg13", "inpMsg13");
		this.hashFields.put("inp_msg16", "inpMsg16");
		this.hashFields.put("inp_msg7", "inpMsg7");
		this.hashFields.put("tmp_dtl_seq", "tmpDtlSeq");
		this.hashFields.put("inp_msg15", "inpMsg15");
		this.hashFields.put("inp_msg6", "inpMsg6");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("tmp_seq", "tmpSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inp_msg23", "inpMsg23");
		this.hashFields.put("inp_msg22", "inpMsg22");
		this.hashFields.put("inp_msg21", "inpMsg21");
		this.hashFields.put("inp_msg20", "inpMsg20");
		this.hashFields.put("inp_msg27", "inpMsg27");
		this.hashFields.put("inp_msg26", "inpMsg26");
		this.hashFields.put("temp_value10", "tempValue10");
		this.hashFields.put("inp_msg25", "inpMsg25");
		this.hashFields.put("inp_msg24", "inpMsg24");
		this.hashFields.put("inp_msg29", "inpMsg29");
		this.hashFields.put("inp_msg28", "inpMsg28");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("inp_msg30", "inpMsg30");
		this.hashFields.put("inp_msg32", "inpMsg32");
		this.hashFields.put("inp_msg31", "inpMsg31");
		this.hashFields.put("inp_msg34", "inpMsg34");
		this.hashFields.put("inp_msg33", "inpMsg33");
		this.hashFields.put("checkbox", "checkbox");
		this.hashFields.put("inp_msg36", "inpMsg36");
		this.hashFields.put("inp_msg35", "inpMsg35");
		this.hashFields.put("inp_msg38", "inpMsg38");
		this.hashFields.put("inp_msg37", "inpMsg37");
		this.hashFields.put("inp_msg39", "inpMsg39");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inpMsg2
	 */
	public String getInpMsg2() {
		return this.inpMsg2;
	}
	
	/**
	 * Column Info
	 * @return inpMsg3
	 */
	public String getInpMsg3() {
		return this.inpMsg3;
	}
	
	/**
	 * Column Info
	 * @return tempValue9
	 */
	public String getTempValue9() {
		return this.tempValue9;
	}
	
	/**
	 * Column Info
	 * @return inpMsg4
	 */
	public String getInpMsg4() {
		return this.inpMsg4;
	}
	
	/**
	 * Column Info
	 * @return inpMsg5
	 */
	public String getInpMsg5() {
		return this.inpMsg5;
	}
	
	/**
	 * Column Info
	 * @return tempValue7
	 */
	public String getTempValue7() {
		return this.tempValue7;
	}
	
	/**
	 * Column Info
	 * @return tempValue8
	 */
	public String getTempValue8() {
		return this.tempValue8;
	}
	
	/**
	 * Column Info
	 * @return tempValue5
	 */
	public String getTempValue5() {
		return this.tempValue5;
	}
	
	/**
	 * Column Info
	 * @return tempValue6
	 */
	public String getTempValue6() {
		return this.tempValue6;
	}
	
	/**
	 * Column Info
	 * @return inpMsg1
	 */
	public String getInpMsg1() {
		return this.inpMsg1;
	}
	
	/**
	 * Column Info
	 * @return tempValue3
	 */
	public String getTempValue3() {
		return this.tempValue3;
	}
	
	/**
	 * Column Info
	 * @return tempValue4
	 */
	public String getTempValue4() {
		return this.tempValue4;
	}
	
	/**
	 * Column Info
	 * @return tempValue1
	 */
	public String getTempValue1() {
		return this.tempValue1;
	}
	
	/**
	 * Column Info
	 * @return tempValue2
	 */
	public String getTempValue2() {
		return this.tempValue2;
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
	 * @return inpMsg48
	 */
	public String getInpMsg48() {
		return this.inpMsg48;
	}
	
	/**
	 * Column Info
	 * @return inpMsg49
	 */
	public String getInpMsg49() {
		return this.inpMsg49;
	}
	
	/**
	 * Column Info
	 * @return inpMsg46
	 */
	public String getInpMsg46() {
		return this.inpMsg46;
	}
	
	/**
	 * Column Info
	 * @return inpMsg47
	 */
	public String getInpMsg47() {
		return this.inpMsg47;
	}
	
	/**
	 * Column Info
	 * @return inpMsg44
	 */
	public String getInpMsg44() {
		return this.inpMsg44;
	}
	
	/**
	 * Column Info
	 * @return inpMsg45
	 */
	public String getInpMsg45() {
		return this.inpMsg45;
	}
	
	/**
	 * Column Info
	 * @return inpMsg42
	 */
	public String getInpMsg42() {
		return this.inpMsg42;
	}
	
	/**
	 * Column Info
	 * @return inpMsg43
	 */
	public String getInpMsg43() {
		return this.inpMsg43;
	}
	
	/**
	 * Column Info
	 * @return inpMsg40
	 */
	public String getInpMsg40() {
		return this.inpMsg40;
	}
	
	/**
	 * Column Info
	 * @return inpMsg41
	 */
	public String getInpMsg41() {
		return this.inpMsg41;
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
	 * @return inpMsg10
	 */
	public String getInpMsg10() {
		return this.inpMsg10;
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
	 * @return inpMsg12
	 */
	public String getInpMsg12() {
		return this.inpMsg12;
	}
	
	/**
	 * Column Info
	 * @return inpMsg11
	 */
	public String getInpMsg11() {
		return this.inpMsg11;
	}
	
	/**
	 * Column Info
	 * @return inpMsg18
	 */
	public String getInpMsg18() {
		return this.inpMsg18;
	}
	
	/**
	 * Column Info
	 * @return inpMsg17
	 */
	public String getInpMsg17() {
		return this.inpMsg17;
	}
	
	/**
	 * Column Info
	 * @return inpMsg19
	 */
	public String getInpMsg19() {
		return this.inpMsg19;
	}
	
	/**
	 * Column Info
	 * @return inpMsg9
	 */
	public String getInpMsg9() {
		return this.inpMsg9;
	}
	
	/**
	 * Column Info
	 * @return inpMsg14
	 */
	public String getInpMsg14() {
		return this.inpMsg14;
	}
	
	/**
	 * Column Info
	 * @return inpMsg50
	 */
	public String getInpMsg50() {
		return this.inpMsg50;
	}
	
	/**
	 * Column Info
	 * @return inpMsg8
	 */
	public String getInpMsg8() {
		return this.inpMsg8;
	}
	
	/**
	 * Column Info
	 * @return inpMsg13
	 */
	public String getInpMsg13() {
		return this.inpMsg13;
	}
	
	/**
	 * Column Info
	 * @return inpMsg16
	 */
	public String getInpMsg16() {
		return this.inpMsg16;
	}
	
	/**
	 * Column Info
	 * @return inpMsg7
	 */
	public String getInpMsg7() {
		return this.inpMsg7;
	}
	
	/**
	 * Column Info
	 * @return tmpDtlSeq
	 */
	public String getTmpDtlSeq() {
		return this.tmpDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return inpMsg15
	 */
	public String getInpMsg15() {
		return this.inpMsg15;
	}
	
	/**
	 * Column Info
	 * @return inpMsg6
	 */
	public String getInpMsg6() {
		return this.inpMsg6;
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
	 * @return tmpSeq
	 */
	public String getTmpSeq() {
		return this.tmpSeq;
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
	 * @return inpMsg23
	 */
	public String getInpMsg23() {
		return this.inpMsg23;
	}
	
	/**
	 * Column Info
	 * @return inpMsg22
	 */
	public String getInpMsg22() {
		return this.inpMsg22;
	}
	
	/**
	 * Column Info
	 * @return inpMsg21
	 */
	public String getInpMsg21() {
		return this.inpMsg21;
	}
	
	/**
	 * Column Info
	 * @return inpMsg20
	 */
	public String getInpMsg20() {
		return this.inpMsg20;
	}
	
	/**
	 * Column Info
	 * @return inpMsg27
	 */
	public String getInpMsg27() {
		return this.inpMsg27;
	}
	
	/**
	 * Column Info
	 * @return inpMsg26
	 */
	public String getInpMsg26() {
		return this.inpMsg26;
	}
	
	/**
	 * Column Info
	 * @return tempValue10
	 */
	public String getTempValue10() {
		return this.tempValue10;
	}
	
	/**
	 * Column Info
	 * @return inpMsg25
	 */
	public String getInpMsg25() {
		return this.inpMsg25;
	}
	
	/**
	 * Column Info
	 * @return inpMsg24
	 */
	public String getInpMsg24() {
		return this.inpMsg24;
	}
	
	/**
	 * Column Info
	 * @return inpMsg29
	 */
	public String getInpMsg29() {
		return this.inpMsg29;
	}
	
	/**
	 * Column Info
	 * @return inpMsg28
	 */
	public String getInpMsg28() {
		return this.inpMsg28;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return inpMsg30
	 */
	public String getInpMsg30() {
		return this.inpMsg30;
	}
	
	/**
	 * Column Info
	 * @return inpMsg32
	 */
	public String getInpMsg32() {
		return this.inpMsg32;
	}
	
	/**
	 * Column Info
	 * @return inpMsg31
	 */
	public String getInpMsg31() {
		return this.inpMsg31;
	}
	
	/**
	 * Column Info
	 * @return inpMsg34
	 */
	public String getInpMsg34() {
		return this.inpMsg34;
	}
	
	/**
	 * Column Info
	 * @return inpMsg33
	 */
	public String getInpMsg33() {
		return this.inpMsg33;
	}
	
	/**
	 * Column Info
	 * @return checkbox
	 */
	public String getCheckbox() {
		return this.checkbox;
	}
	
	/**
	 * Column Info
	 * @return inpMsg36
	 */
	public String getInpMsg36() {
		return this.inpMsg36;
	}
	
	/**
	 * Column Info
	 * @return inpMsg35
	 */
	public String getInpMsg35() {
		return this.inpMsg35;
	}
	
	/**
	 * Column Info
	 * @return inpMsg38
	 */
	public String getInpMsg38() {
		return this.inpMsg38;
	}
	
	/**
	 * Column Info
	 * @return inpMsg37
	 */
	public String getInpMsg37() {
		return this.inpMsg37;
	}
	
	/**
	 * Column Info
	 * @return inpMsg39
	 */
	public String getInpMsg39() {
		return this.inpMsg39;
	}
	

	/**
	 * Column Info
	 * @param inpMsg2
	 */
	public void setInpMsg2(String inpMsg2) {
		this.inpMsg2 = inpMsg2;
	}
	
	/**
	 * Column Info
	 * @param inpMsg3
	 */
	public void setInpMsg3(String inpMsg3) {
		this.inpMsg3 = inpMsg3;
	}
	
	/**
	 * Column Info
	 * @param tempValue9
	 */
	public void setTempValue9(String tempValue9) {
		this.tempValue9 = tempValue9;
	}
	
	/**
	 * Column Info
	 * @param inpMsg4
	 */
	public void setInpMsg4(String inpMsg4) {
		this.inpMsg4 = inpMsg4;
	}
	
	/**
	 * Column Info
	 * @param inpMsg5
	 */
	public void setInpMsg5(String inpMsg5) {
		this.inpMsg5 = inpMsg5;
	}
	
	/**
	 * Column Info
	 * @param tempValue7
	 */
	public void setTempValue7(String tempValue7) {
		this.tempValue7 = tempValue7;
	}
	
	/**
	 * Column Info
	 * @param tempValue8
	 */
	public void setTempValue8(String tempValue8) {
		this.tempValue8 = tempValue8;
	}
	
	/**
	 * Column Info
	 * @param tempValue5
	 */
	public void setTempValue5(String tempValue5) {
		this.tempValue5 = tempValue5;
	}
	
	/**
	 * Column Info
	 * @param tempValue6
	 */
	public void setTempValue6(String tempValue6) {
		this.tempValue6 = tempValue6;
	}
	
	/**
	 * Column Info
	 * @param inpMsg1
	 */
	public void setInpMsg1(String inpMsg1) {
		this.inpMsg1 = inpMsg1;
	}
	
	/**
	 * Column Info
	 * @param tempValue3
	 */
	public void setTempValue3(String tempValue3) {
		this.tempValue3 = tempValue3;
	}
	
	/**
	 * Column Info
	 * @param tempValue4
	 */
	public void setTempValue4(String tempValue4) {
		this.tempValue4 = tempValue4;
	}
	
	/**
	 * Column Info
	 * @param tempValue1
	 */
	public void setTempValue1(String tempValue1) {
		this.tempValue1 = tempValue1;
	}
	
	/**
	 * Column Info
	 * @param tempValue2
	 */
	public void setTempValue2(String tempValue2) {
		this.tempValue2 = tempValue2;
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
	 * @param inpMsg48
	 */
	public void setInpMsg48(String inpMsg48) {
		this.inpMsg48 = inpMsg48;
	}
	
	/**
	 * Column Info
	 * @param inpMsg49
	 */
	public void setInpMsg49(String inpMsg49) {
		this.inpMsg49 = inpMsg49;
	}
	
	/**
	 * Column Info
	 * @param inpMsg46
	 */
	public void setInpMsg46(String inpMsg46) {
		this.inpMsg46 = inpMsg46;
	}
	
	/**
	 * Column Info
	 * @param inpMsg47
	 */
	public void setInpMsg47(String inpMsg47) {
		this.inpMsg47 = inpMsg47;
	}
	
	/**
	 * Column Info
	 * @param inpMsg44
	 */
	public void setInpMsg44(String inpMsg44) {
		this.inpMsg44 = inpMsg44;
	}
	
	/**
	 * Column Info
	 * @param inpMsg45
	 */
	public void setInpMsg45(String inpMsg45) {
		this.inpMsg45 = inpMsg45;
	}
	
	/**
	 * Column Info
	 * @param inpMsg42
	 */
	public void setInpMsg42(String inpMsg42) {
		this.inpMsg42 = inpMsg42;
	}
	
	/**
	 * Column Info
	 * @param inpMsg43
	 */
	public void setInpMsg43(String inpMsg43) {
		this.inpMsg43 = inpMsg43;
	}
	
	/**
	 * Column Info
	 * @param inpMsg40
	 */
	public void setInpMsg40(String inpMsg40) {
		this.inpMsg40 = inpMsg40;
	}
	
	/**
	 * Column Info
	 * @param inpMsg41
	 */
	public void setInpMsg41(String inpMsg41) {
		this.inpMsg41 = inpMsg41;
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
	 * @param inpMsg10
	 */
	public void setInpMsg10(String inpMsg10) {
		this.inpMsg10 = inpMsg10;
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
	 * @param inpMsg12
	 */
	public void setInpMsg12(String inpMsg12) {
		this.inpMsg12 = inpMsg12;
	}
	
	/**
	 * Column Info
	 * @param inpMsg11
	 */
	public void setInpMsg11(String inpMsg11) {
		this.inpMsg11 = inpMsg11;
	}
	
	/**
	 * Column Info
	 * @param inpMsg18
	 */
	public void setInpMsg18(String inpMsg18) {
		this.inpMsg18 = inpMsg18;
	}
	
	/**
	 * Column Info
	 * @param inpMsg17
	 */
	public void setInpMsg17(String inpMsg17) {
		this.inpMsg17 = inpMsg17;
	}
	
	/**
	 * Column Info
	 * @param inpMsg19
	 */
	public void setInpMsg19(String inpMsg19) {
		this.inpMsg19 = inpMsg19;
	}
	
	/**
	 * Column Info
	 * @param inpMsg9
	 */
	public void setInpMsg9(String inpMsg9) {
		this.inpMsg9 = inpMsg9;
	}
	
	/**
	 * Column Info
	 * @param inpMsg14
	 */
	public void setInpMsg14(String inpMsg14) {
		this.inpMsg14 = inpMsg14;
	}
	
	/**
	 * Column Info
	 * @param inpMsg50
	 */
	public void setInpMsg50(String inpMsg50) {
		this.inpMsg50 = inpMsg50;
	}
	
	/**
	 * Column Info
	 * @param inpMsg8
	 */
	public void setInpMsg8(String inpMsg8) {
		this.inpMsg8 = inpMsg8;
	}
	
	/**
	 * Column Info
	 * @param inpMsg13
	 */
	public void setInpMsg13(String inpMsg13) {
		this.inpMsg13 = inpMsg13;
	}
	
	/**
	 * Column Info
	 * @param inpMsg16
	 */
	public void setInpMsg16(String inpMsg16) {
		this.inpMsg16 = inpMsg16;
	}
	
	/**
	 * Column Info
	 * @param inpMsg7
	 */
	public void setInpMsg7(String inpMsg7) {
		this.inpMsg7 = inpMsg7;
	}
	
	/**
	 * Column Info
	 * @param tmpDtlSeq
	 */
	public void setTmpDtlSeq(String tmpDtlSeq) {
		this.tmpDtlSeq = tmpDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param inpMsg15
	 */
	public void setInpMsg15(String inpMsg15) {
		this.inpMsg15 = inpMsg15;
	}
	
	/**
	 * Column Info
	 * @param inpMsg6
	 */
	public void setInpMsg6(String inpMsg6) {
		this.inpMsg6 = inpMsg6;
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
	 * @param tmpSeq
	 */
	public void setTmpSeq(String tmpSeq) {
		this.tmpSeq = tmpSeq;
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
	 * @param inpMsg23
	 */
	public void setInpMsg23(String inpMsg23) {
		this.inpMsg23 = inpMsg23;
	}
	
	/**
	 * Column Info
	 * @param inpMsg22
	 */
	public void setInpMsg22(String inpMsg22) {
		this.inpMsg22 = inpMsg22;
	}
	
	/**
	 * Column Info
	 * @param inpMsg21
	 */
	public void setInpMsg21(String inpMsg21) {
		this.inpMsg21 = inpMsg21;
	}
	
	/**
	 * Column Info
	 * @param inpMsg20
	 */
	public void setInpMsg20(String inpMsg20) {
		this.inpMsg20 = inpMsg20;
	}
	
	/**
	 * Column Info
	 * @param inpMsg27
	 */
	public void setInpMsg27(String inpMsg27) {
		this.inpMsg27 = inpMsg27;
	}
	
	/**
	 * Column Info
	 * @param inpMsg26
	 */
	public void setInpMsg26(String inpMsg26) {
		this.inpMsg26 = inpMsg26;
	}
	
	/**
	 * Column Info
	 * @param tempValue10
	 */
	public void setTempValue10(String tempValue10) {
		this.tempValue10 = tempValue10;
	}
	
	/**
	 * Column Info
	 * @param inpMsg25
	 */
	public void setInpMsg25(String inpMsg25) {
		this.inpMsg25 = inpMsg25;
	}
	
	/**
	 * Column Info
	 * @param inpMsg24
	 */
	public void setInpMsg24(String inpMsg24) {
		this.inpMsg24 = inpMsg24;
	}
	
	/**
	 * Column Info
	 * @param inpMsg29
	 */
	public void setInpMsg29(String inpMsg29) {
		this.inpMsg29 = inpMsg29;
	}
	
	/**
	 * Column Info
	 * @param inpMsg28
	 */
	public void setInpMsg28(String inpMsg28) {
		this.inpMsg28 = inpMsg28;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param inpMsg30
	 */
	public void setInpMsg30(String inpMsg30) {
		this.inpMsg30 = inpMsg30;
	}
	
	/**
	 * Column Info
	 * @param inpMsg32
	 */
	public void setInpMsg32(String inpMsg32) {
		this.inpMsg32 = inpMsg32;
	}
	
	/**
	 * Column Info
	 * @param inpMsg31
	 */
	public void setInpMsg31(String inpMsg31) {
		this.inpMsg31 = inpMsg31;
	}
	
	/**
	 * Column Info
	 * @param inpMsg34
	 */
	public void setInpMsg34(String inpMsg34) {
		this.inpMsg34 = inpMsg34;
	}
	
	/**
	 * Column Info
	 * @param inpMsg33
	 */
	public void setInpMsg33(String inpMsg33) {
		this.inpMsg33 = inpMsg33;
	}
	
	/**
	 * Column Info
	 * @param checkbox
	 */
	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}
	
	/**
	 * Column Info
	 * @param inpMsg36
	 */
	public void setInpMsg36(String inpMsg36) {
		this.inpMsg36 = inpMsg36;
	}
	
	/**
	 * Column Info
	 * @param inpMsg35
	 */
	public void setInpMsg35(String inpMsg35) {
		this.inpMsg35 = inpMsg35;
	}
	
	/**
	 * Column Info
	 * @param inpMsg38
	 */
	public void setInpMsg38(String inpMsg38) {
		this.inpMsg38 = inpMsg38;
	}
	
	/**
	 * Column Info
	 * @param inpMsg37
	 */
	public void setInpMsg37(String inpMsg37) {
		this.inpMsg37 = inpMsg37;
	}
	
	/**
	 * Column Info
	 * @param inpMsg39
	 */
	public void setInpMsg39(String inpMsg39) {
		this.inpMsg39 = inpMsg39;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setInpMsg2(JSPUtil.getParameter(request, "inp_msg2", ""));
		setInpMsg3(JSPUtil.getParameter(request, "inp_msg3", ""));
		setTempValue9(JSPUtil.getParameter(request, "temp_value9", ""));
		setInpMsg4(JSPUtil.getParameter(request, "inp_msg4", ""));
		setInpMsg5(JSPUtil.getParameter(request, "inp_msg5", ""));
		setTempValue7(JSPUtil.getParameter(request, "temp_value7", ""));
		setTempValue8(JSPUtil.getParameter(request, "temp_value8", ""));
		setTempValue5(JSPUtil.getParameter(request, "temp_value5", ""));
		setTempValue6(JSPUtil.getParameter(request, "temp_value6", ""));
		setInpMsg1(JSPUtil.getParameter(request, "inp_msg1", ""));
		setTempValue3(JSPUtil.getParameter(request, "temp_value3", ""));
		setTempValue4(JSPUtil.getParameter(request, "temp_value4", ""));
		setTempValue1(JSPUtil.getParameter(request, "temp_value1", ""));
		setTempValue2(JSPUtil.getParameter(request, "temp_value2", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInpMsg48(JSPUtil.getParameter(request, "inp_msg48", ""));
		setInpMsg49(JSPUtil.getParameter(request, "inp_msg49", ""));
		setInpMsg46(JSPUtil.getParameter(request, "inp_msg46", ""));
		setInpMsg47(JSPUtil.getParameter(request, "inp_msg47", ""));
		setInpMsg44(JSPUtil.getParameter(request, "inp_msg44", ""));
		setInpMsg45(JSPUtil.getParameter(request, "inp_msg45", ""));
		setInpMsg42(JSPUtil.getParameter(request, "inp_msg42", ""));
		setInpMsg43(JSPUtil.getParameter(request, "inp_msg43", ""));
		setInpMsg40(JSPUtil.getParameter(request, "inp_msg40", ""));
		setInpMsg41(JSPUtil.getParameter(request, "inp_msg41", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setInpMsg10(JSPUtil.getParameter(request, "inp_msg10", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setInpMsg12(JSPUtil.getParameter(request, "inp_msg12", ""));
		setInpMsg11(JSPUtil.getParameter(request, "inp_msg11", ""));
		setInpMsg18(JSPUtil.getParameter(request, "inp_msg18", ""));
		setInpMsg17(JSPUtil.getParameter(request, "inp_msg17", ""));
		setInpMsg19(JSPUtil.getParameter(request, "inp_msg19", ""));
		setInpMsg9(JSPUtil.getParameter(request, "inp_msg9", ""));
		setInpMsg14(JSPUtil.getParameter(request, "inp_msg14", ""));
		setInpMsg50(JSPUtil.getParameter(request, "inp_msg50", ""));
		setInpMsg8(JSPUtil.getParameter(request, "inp_msg8", ""));
		setInpMsg13(JSPUtil.getParameter(request, "inp_msg13", ""));
		setInpMsg16(JSPUtil.getParameter(request, "inp_msg16", ""));
		setInpMsg7(JSPUtil.getParameter(request, "inp_msg7", ""));
		setTmpDtlSeq(JSPUtil.getParameter(request, "tmp_dtl_seq", ""));
		setInpMsg15(JSPUtil.getParameter(request, "inp_msg15", ""));
		setInpMsg6(JSPUtil.getParameter(request, "inp_msg6", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setTmpSeq(JSPUtil.getParameter(request, "tmp_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInpMsg23(JSPUtil.getParameter(request, "inp_msg23", ""));
		setInpMsg22(JSPUtil.getParameter(request, "inp_msg22", ""));
		setInpMsg21(JSPUtil.getParameter(request, "inp_msg21", ""));
		setInpMsg20(JSPUtil.getParameter(request, "inp_msg20", ""));
		setInpMsg27(JSPUtil.getParameter(request, "inp_msg27", ""));
		setInpMsg26(JSPUtil.getParameter(request, "inp_msg26", ""));
		setTempValue10(JSPUtil.getParameter(request, "temp_value10", ""));
		setInpMsg25(JSPUtil.getParameter(request, "inp_msg25", ""));
		setInpMsg24(JSPUtil.getParameter(request, "inp_msg24", ""));
		setInpMsg29(JSPUtil.getParameter(request, "inp_msg29", ""));
		setInpMsg28(JSPUtil.getParameter(request, "inp_msg28", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setInpMsg30(JSPUtil.getParameter(request, "inp_msg30", ""));
		setInpMsg32(JSPUtil.getParameter(request, "inp_msg32", ""));
		setInpMsg31(JSPUtil.getParameter(request, "inp_msg31", ""));
		setInpMsg34(JSPUtil.getParameter(request, "inp_msg34", ""));
		setInpMsg33(JSPUtil.getParameter(request, "inp_msg33", ""));
		setCheckbox(JSPUtil.getParameter(request, "checkbox", ""));
		setInpMsg36(JSPUtil.getParameter(request, "inp_msg36", ""));
		setInpMsg35(JSPUtil.getParameter(request, "inp_msg35", ""));
		setInpMsg38(JSPUtil.getParameter(request, "inp_msg38", ""));
		setInpMsg37(JSPUtil.getParameter(request, "inp_msg37", ""));
		setInpMsg39(JSPUtil.getParameter(request, "inp_msg39", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrDatVrfyVO[]
	 */
	public CustomMnrDatVrfyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrDatVrfyVO[]
	 */
	public CustomMnrDatVrfyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrDatVrfyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inpMsg2 = (JSPUtil.getParameter(request, prefix	+ "inp_msg2", length));
			String[] inpMsg3 = (JSPUtil.getParameter(request, prefix	+ "inp_msg3", length));
			String[] tempValue9 = (JSPUtil.getParameter(request, prefix	+ "temp_value9", length));
			String[] inpMsg4 = (JSPUtil.getParameter(request, prefix	+ "inp_msg4", length));
			String[] inpMsg5 = (JSPUtil.getParameter(request, prefix	+ "inp_msg5", length));
			String[] tempValue7 = (JSPUtil.getParameter(request, prefix	+ "temp_value7", length));
			String[] tempValue8 = (JSPUtil.getParameter(request, prefix	+ "temp_value8", length));
			String[] tempValue5 = (JSPUtil.getParameter(request, prefix	+ "temp_value5", length));
			String[] tempValue6 = (JSPUtil.getParameter(request, prefix	+ "temp_value6", length));
			String[] inpMsg1 = (JSPUtil.getParameter(request, prefix	+ "inp_msg1", length));
			String[] tempValue3 = (JSPUtil.getParameter(request, prefix	+ "temp_value3", length));
			String[] tempValue4 = (JSPUtil.getParameter(request, prefix	+ "temp_value4", length));
			String[] tempValue1 = (JSPUtil.getParameter(request, prefix	+ "temp_value1", length));
			String[] tempValue2 = (JSPUtil.getParameter(request, prefix	+ "temp_value2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] inpMsg48 = (JSPUtil.getParameter(request, prefix	+ "inp_msg48", length));
			String[] inpMsg49 = (JSPUtil.getParameter(request, prefix	+ "inp_msg49", length));
			String[] inpMsg46 = (JSPUtil.getParameter(request, prefix	+ "inp_msg46", length));
			String[] inpMsg47 = (JSPUtil.getParameter(request, prefix	+ "inp_msg47", length));
			String[] inpMsg44 = (JSPUtil.getParameter(request, prefix	+ "inp_msg44", length));
			String[] inpMsg45 = (JSPUtil.getParameter(request, prefix	+ "inp_msg45", length));
			String[] inpMsg42 = (JSPUtil.getParameter(request, prefix	+ "inp_msg42", length));
			String[] inpMsg43 = (JSPUtil.getParameter(request, prefix	+ "inp_msg43", length));
			String[] inpMsg40 = (JSPUtil.getParameter(request, prefix	+ "inp_msg40", length));
			String[] inpMsg41 = (JSPUtil.getParameter(request, prefix	+ "inp_msg41", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] inpMsg10 = (JSPUtil.getParameter(request, prefix	+ "inp_msg10", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] inpMsg12 = (JSPUtil.getParameter(request, prefix	+ "inp_msg12", length));
			String[] inpMsg11 = (JSPUtil.getParameter(request, prefix	+ "inp_msg11", length));
			String[] inpMsg18 = (JSPUtil.getParameter(request, prefix	+ "inp_msg18", length));
			String[] inpMsg17 = (JSPUtil.getParameter(request, prefix	+ "inp_msg17", length));
			String[] inpMsg19 = (JSPUtil.getParameter(request, prefix	+ "inp_msg19", length));
			String[] inpMsg9 = (JSPUtil.getParameter(request, prefix	+ "inp_msg9", length));
			String[] inpMsg14 = (JSPUtil.getParameter(request, prefix	+ "inp_msg14", length));
			String[] inpMsg50 = (JSPUtil.getParameter(request, prefix	+ "inp_msg50", length));
			String[] inpMsg8 = (JSPUtil.getParameter(request, prefix	+ "inp_msg8", length));
			String[] inpMsg13 = (JSPUtil.getParameter(request, prefix	+ "inp_msg13", length));
			String[] inpMsg16 = (JSPUtil.getParameter(request, prefix	+ "inp_msg16", length));
			String[] inpMsg7 = (JSPUtil.getParameter(request, prefix	+ "inp_msg7", length));
			String[] tmpDtlSeq = (JSPUtil.getParameter(request, prefix	+ "tmp_dtl_seq", length));
			String[] inpMsg15 = (JSPUtil.getParameter(request, prefix	+ "inp_msg15", length));
			String[] inpMsg6 = (JSPUtil.getParameter(request, prefix	+ "inp_msg6", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] tmpSeq = (JSPUtil.getParameter(request, prefix	+ "tmp_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inpMsg23 = (JSPUtil.getParameter(request, prefix	+ "inp_msg23", length));
			String[] inpMsg22 = (JSPUtil.getParameter(request, prefix	+ "inp_msg22", length));
			String[] inpMsg21 = (JSPUtil.getParameter(request, prefix	+ "inp_msg21", length));
			String[] inpMsg20 = (JSPUtil.getParameter(request, prefix	+ "inp_msg20", length));
			String[] inpMsg27 = (JSPUtil.getParameter(request, prefix	+ "inp_msg27", length));
			String[] inpMsg26 = (JSPUtil.getParameter(request, prefix	+ "inp_msg26", length));
			String[] tempValue10 = (JSPUtil.getParameter(request, prefix	+ "temp_value10", length));
			String[] inpMsg25 = (JSPUtil.getParameter(request, prefix	+ "inp_msg25", length));
			String[] inpMsg24 = (JSPUtil.getParameter(request, prefix	+ "inp_msg24", length));
			String[] inpMsg29 = (JSPUtil.getParameter(request, prefix	+ "inp_msg29", length));
			String[] inpMsg28 = (JSPUtil.getParameter(request, prefix	+ "inp_msg28", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] inpMsg30 = (JSPUtil.getParameter(request, prefix	+ "inp_msg30", length));
			String[] inpMsg32 = (JSPUtil.getParameter(request, prefix	+ "inp_msg32", length));
			String[] inpMsg31 = (JSPUtil.getParameter(request, prefix	+ "inp_msg31", length));
			String[] inpMsg34 = (JSPUtil.getParameter(request, prefix	+ "inp_msg34", length));
			String[] inpMsg33 = (JSPUtil.getParameter(request, prefix	+ "inp_msg33", length));
			String[] checkbox = (JSPUtil.getParameter(request, prefix	+ "checkbox", length));
			String[] inpMsg36 = (JSPUtil.getParameter(request, prefix	+ "inp_msg36", length));
			String[] inpMsg35 = (JSPUtil.getParameter(request, prefix	+ "inp_msg35", length));
			String[] inpMsg38 = (JSPUtil.getParameter(request, prefix	+ "inp_msg38", length));
			String[] inpMsg37 = (JSPUtil.getParameter(request, prefix	+ "inp_msg37", length));
			String[] inpMsg39 = (JSPUtil.getParameter(request, prefix	+ "inp_msg39", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrDatVrfyVO();
				if (inpMsg2[i] != null)
					model.setInpMsg2(inpMsg2[i]);
				if (inpMsg3[i] != null)
					model.setInpMsg3(inpMsg3[i]);
				if (tempValue9[i] != null)
					model.setTempValue9(tempValue9[i]);
				if (inpMsg4[i] != null)
					model.setInpMsg4(inpMsg4[i]);
				if (inpMsg5[i] != null)
					model.setInpMsg5(inpMsg5[i]);
				if (tempValue7[i] != null)
					model.setTempValue7(tempValue7[i]);
				if (tempValue8[i] != null)
					model.setTempValue8(tempValue8[i]);
				if (tempValue5[i] != null)
					model.setTempValue5(tempValue5[i]);
				if (tempValue6[i] != null)
					model.setTempValue6(tempValue6[i]);
				if (inpMsg1[i] != null)
					model.setInpMsg1(inpMsg1[i]);
				if (tempValue3[i] != null)
					model.setTempValue3(tempValue3[i]);
				if (tempValue4[i] != null)
					model.setTempValue4(tempValue4[i]);
				if (tempValue1[i] != null)
					model.setTempValue1(tempValue1[i]);
				if (tempValue2[i] != null)
					model.setTempValue2(tempValue2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (inpMsg48[i] != null)
					model.setInpMsg48(inpMsg48[i]);
				if (inpMsg49[i] != null)
					model.setInpMsg49(inpMsg49[i]);
				if (inpMsg46[i] != null)
					model.setInpMsg46(inpMsg46[i]);
				if (inpMsg47[i] != null)
					model.setInpMsg47(inpMsg47[i]);
				if (inpMsg44[i] != null)
					model.setInpMsg44(inpMsg44[i]);
				if (inpMsg45[i] != null)
					model.setInpMsg45(inpMsg45[i]);
				if (inpMsg42[i] != null)
					model.setInpMsg42(inpMsg42[i]);
				if (inpMsg43[i] != null)
					model.setInpMsg43(inpMsg43[i]);
				if (inpMsg40[i] != null)
					model.setInpMsg40(inpMsg40[i]);
				if (inpMsg41[i] != null)
					model.setInpMsg41(inpMsg41[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (inpMsg10[i] != null)
					model.setInpMsg10(inpMsg10[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (inpMsg12[i] != null)
					model.setInpMsg12(inpMsg12[i]);
				if (inpMsg11[i] != null)
					model.setInpMsg11(inpMsg11[i]);
				if (inpMsg18[i] != null)
					model.setInpMsg18(inpMsg18[i]);
				if (inpMsg17[i] != null)
					model.setInpMsg17(inpMsg17[i]);
				if (inpMsg19[i] != null)
					model.setInpMsg19(inpMsg19[i]);
				if (inpMsg9[i] != null)
					model.setInpMsg9(inpMsg9[i]);
				if (inpMsg14[i] != null)
					model.setInpMsg14(inpMsg14[i]);
				if (inpMsg50[i] != null)
					model.setInpMsg50(inpMsg50[i]);
				if (inpMsg8[i] != null)
					model.setInpMsg8(inpMsg8[i]);
				if (inpMsg13[i] != null)
					model.setInpMsg13(inpMsg13[i]);
				if (inpMsg16[i] != null)
					model.setInpMsg16(inpMsg16[i]);
				if (inpMsg7[i] != null)
					model.setInpMsg7(inpMsg7[i]);
				if (tmpDtlSeq[i] != null)
					model.setTmpDtlSeq(tmpDtlSeq[i]);
				if (inpMsg15[i] != null)
					model.setInpMsg15(inpMsg15[i]);
				if (inpMsg6[i] != null)
					model.setInpMsg6(inpMsg6[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (tmpSeq[i] != null)
					model.setTmpSeq(tmpSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inpMsg23[i] != null)
					model.setInpMsg23(inpMsg23[i]);
				if (inpMsg22[i] != null)
					model.setInpMsg22(inpMsg22[i]);
				if (inpMsg21[i] != null)
					model.setInpMsg21(inpMsg21[i]);
				if (inpMsg20[i] != null)
					model.setInpMsg20(inpMsg20[i]);
				if (inpMsg27[i] != null)
					model.setInpMsg27(inpMsg27[i]);
				if (inpMsg26[i] != null)
					model.setInpMsg26(inpMsg26[i]);
				if (tempValue10[i] != null)
					model.setTempValue10(tempValue10[i]);
				if (inpMsg25[i] != null)
					model.setInpMsg25(inpMsg25[i]);
				if (inpMsg24[i] != null)
					model.setInpMsg24(inpMsg24[i]);
				if (inpMsg29[i] != null)
					model.setInpMsg29(inpMsg29[i]);
				if (inpMsg28[i] != null)
					model.setInpMsg28(inpMsg28[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (inpMsg30[i] != null)
					model.setInpMsg30(inpMsg30[i]);
				if (inpMsg32[i] != null)
					model.setInpMsg32(inpMsg32[i]);
				if (inpMsg31[i] != null)
					model.setInpMsg31(inpMsg31[i]);
				if (inpMsg34[i] != null)
					model.setInpMsg34(inpMsg34[i]);
				if (inpMsg33[i] != null)
					model.setInpMsg33(inpMsg33[i]);
				if (checkbox[i] != null)
					model.setCheckbox(checkbox[i]);
				if (inpMsg36[i] != null)
					model.setInpMsg36(inpMsg36[i]);
				if (inpMsg35[i] != null)
					model.setInpMsg35(inpMsg35[i]);
				if (inpMsg38[i] != null)
					model.setInpMsg38(inpMsg38[i]);
				if (inpMsg37[i] != null)
					model.setInpMsg37(inpMsg37[i]);
				if (inpMsg39[i] != null)
					model.setInpMsg39(inpMsg39[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrDatVrfyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrDatVrfyVO[]
	 */
	public CustomMnrDatVrfyVO[] getCustomMnrDatVrfyVOs(){
		CustomMnrDatVrfyVO[] vos = (CustomMnrDatVrfyVO[])models.toArray(new CustomMnrDatVrfyVO[models.size()]);
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
		this.inpMsg2 = this.inpMsg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg3 = this.inpMsg3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempValue9 = this.tempValue9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg4 = this.inpMsg4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg5 = this.inpMsg5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempValue7 = this.tempValue7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempValue8 = this.tempValue8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempValue5 = this.tempValue5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempValue6 = this.tempValue6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg1 = this.inpMsg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempValue3 = this.tempValue3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempValue4 = this.tempValue4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempValue1 = this.tempValue1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempValue2 = this.tempValue2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg48 = this.inpMsg48 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg49 = this.inpMsg49 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg46 = this.inpMsg46 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg47 = this.inpMsg47 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg44 = this.inpMsg44 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg45 = this.inpMsg45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg42 = this.inpMsg42 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg43 = this.inpMsg43 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg40 = this.inpMsg40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg41 = this.inpMsg41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg10 = this.inpMsg10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg12 = this.inpMsg12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg11 = this.inpMsg11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg18 = this.inpMsg18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg17 = this.inpMsg17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg19 = this.inpMsg19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg9 = this.inpMsg9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg14 = this.inpMsg14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg50 = this.inpMsg50 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg8 = this.inpMsg8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg13 = this.inpMsg13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg16 = this.inpMsg16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg7 = this.inpMsg7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpDtlSeq = this.tmpDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg15 = this.inpMsg15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg6 = this.inpMsg6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpSeq = this.tmpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg23 = this.inpMsg23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg22 = this.inpMsg22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg21 = this.inpMsg21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg20 = this.inpMsg20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg27 = this.inpMsg27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg26 = this.inpMsg26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempValue10 = this.tempValue10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg25 = this.inpMsg25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg24 = this.inpMsg24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg29 = this.inpMsg29 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg28 = this.inpMsg28 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg30 = this.inpMsg30 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg32 = this.inpMsg32 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg31 = this.inpMsg31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg34 = this.inpMsg34 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg33 = this.inpMsg33 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkbox = this.checkbox .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg36 = this.inpMsg36 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg35 = this.inpMsg35 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg38 = this.inpMsg38 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg37 = this.inpMsg37 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg39 = this.inpMsg39 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

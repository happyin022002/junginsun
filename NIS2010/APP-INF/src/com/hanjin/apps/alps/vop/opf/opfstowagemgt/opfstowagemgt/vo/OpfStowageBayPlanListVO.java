/*=========================================================
*@FileName : OpfStowageBayPlanListVO.java
*Copyright(c) 2013 CyberLogitec
*@FileTitle : OpfStowageBayPlanListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.03
*@LastModifier : 김도현
*@LastVersion : 1.0
* 2015.06.03 김도현 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.vo;

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
 * @author 김도현
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OpfStowageBayPlanListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OpfStowageBayPlanListVO> models = new ArrayList<OpfStowageBayPlanListVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String onTrNmF = null;
	/* Column Info */
	private String onTrNmB = null;
	/* Column Info */
	private String onRow0 = null;
	/* Column Info */
	private String onRow1 = null;
	/* Column Info */
	private String onRow2 = null;
	/* Column Info */
	private String onRow3 = null;
	/* Column Info */
	private String onRow4 = null;
	/* Column Info */
	private String onRow5 = null;
	/* Column Info */
	private String onRow6 = null;
	/* Column Info */
	private String onRow7 = null;
	/* Column Info */
	private String onRow8 = null;
	/* Column Info */
	private String onRow9 = null;
	/* Column Info */
	private String onRow10 = null;
	/* Column Info */
	private String onRow11 = null;
	/* Column Info */
	private String onRow12= null;
	/* Column Info */
	private String onRow13= null;
	/* Column Info */
	private String onRow14 = null;
	/* Column Info */
	private String onRow15 = null;
	/* Column Info */
	private String onRow16 = null;
	/* Column Info */
	private String onRow17 = null;
	/* Column Info */
	private String onRow18 = null;
	/* Column Info */
	private String underTrNmF = null;
	/* Column Info */
	private String underTrNmB = null;
	/* Column Info */
	private String underRow0 = null;
	/* Column Info */
	private String underRow1 = null;
	/* Column Info */
	private String underRow2 = null;
	/* Column Info */
	private String underRow3 = null;
	/* Column Info */
	private String underRow4 = null;
	/* Column Info */
	private String underRow5 = null;
	/* Column Info */
	private String underRow6 = null;
	/* Column Info */
	private String underRow7 = null;
	/* Column Info */
	private String underRow8 = null;
	/* Column Info */
	private String underRow9 = null;
	/* Column Info */
	private String underRow10 = null;
	/* Column Info */
	private String underRow11 = null;
	/* Column Info */
	private String underRow12 = null;
	/* Column Info */
	private String underRow13 = null;
	/* Column Info */
	private String underRow14 = null;
	/* Column Info */
	private String underRow15 = null;
	/* Column Info */
	private String underRow16 = null;
	/* Column Info */
	private String underRow17 = null;
	/* Column Info */
	private String underRow18= null;
	/* Column Info */
	private String dhTp = null;
	/* Column Info */
	private	String htchCvr0  = null;
	/* Column Info */
	private	String htchCvr1  = null;
	/* Column Info */
	private	String htchCvr2  = null;
	/* Column Info */
	private	String htchCvr3  = null;
	/* Column Info */
	private	String htchCvr4  = null;
	/* Column Info */
	private	String htchCvr5  = null;
	/* Column Info */
	private	String htchCvr6  = null;
	/* Column Info */
	private	String htchCvr7  = null;
	/* Column Info */
	private	String htchCvr8  = null;
	/* Column Info */
	private	String htchCvr9  = null;
	/* Column Info */
	private	String htchCvr10 = null;
	/* Column Info */
	private	String htchCvr11 = null;
	/* Column Info */
	private	String htchCvr12 = null;
	/* Column Info */
	private	String htchCvr13 = null;
	/* Column Info */
	private	String htchCvr14 = null;
	/* Column Info */
	private	String htchCvr15 = null;
	/* Column Info */
	private	String htchCvr16 = null;
	/* Column Info */
	private	String htchCvr17 = null;
	/* Column Info */
	private	String htchCvr18 = null;
	/* Column Info */
	private	String htchCvr19 = null;
	/* Column Info */
	private	String htchCvr20 = null;
	/* Column Info */
	private	String htchCvr21 = null;
	/* Column Info */
	private	String htchCvr22 = null;
	/* Column Info */
	private	String htchCvr23 = null;
	/* Column Info */
	private	String htchCvr24 = null;
	/* Column Info */
	private	String htchCvr25 = null;
	/* Column Info */
	private	String htchCvr26 = null;
	/* Column Info */
	private	String htchCvr27 = null;
	/* Column Info */
	private	String htchCvr28 = null;
	/* Column Info */
	private	String htchCvr29 = null;
	/* Column Info */
	private	String htchCvr30 = null;
	/* Column Info */
	private	String htchCvr31 = null;
	/* Column Info */
	private	String htchCvr32 = null;
	/* Column Info */
	private	String htchCvr33 = null;
	/* Column Info */
	private	String htchCvr34 = null;
	/* Column Info */
	private	String htchCvr35 = null;
	/* Column Info */
	private	String htchCvr36 = null;
	/* Column Info */
	private	String htchCvr37 = null;
	/* Column Info */
	private	String htchCvr38 = null;
	/* Column Info */
	private	String htchCvr39 = null;
	/* Column Info */
	private	String htchCvr40 = null;
	/* Column Info */
	private	String htchCvr41 = null;
	/* Column Info */
	private	String htchCvr42 = null;
	/* Column Info */
	private	String htchCvr43 = null;
	/* Column Info */
	private	String htchCvr44 = null;
	/* Column Info */
	private	String htchCvr45 = null;
	/* Column Info */
	private	String htchCvr46 = null;
	/* Column Info */
	private	String htchCvr47 = null;
	/* Column Info */
	private	String htchCvr48 = null;
	/* Column Info */
	private	String htchCvr49 = null;
	/* Column Info */
	private	String htchCvr50 = null;
	/* Column Info */
	private	String htchCvr51 = null;
	/* Column Info */
	private	String htchCvr52 = null;
	/* Column Info */
	private	String htchCvr53 = null;
	/* Column Info */
	private	String htchCvr54 = null;
	/* Column Info */
	private	String htchCvr55 = null;
	/* Column Info */
	private	String htchCvr56 = null;
	/* Column Info */
	private	String htchCvr57 = null;
	/* Column Info */
	private	String htchCvr58 = null;
	/* Column Info */
	private	String htchCvr59 = null;
	/* Column Info */
	private	String htchCvr60 = null;
	/* Column Info */
	private	String htchCvr61 = null;
	/* Column Info */
	private	String htchCvr62 = null;
	/* Column Info */
	private	String htchCvr63 = null;
	/* Column Info */
	private	String htchCvr64 = null;
	/* Column Info */
	private	String htchCvr65 = null;
	/* Column Info */
	private	String htchCvr66 = null;
	/* Column Info */
	private	String htchCvr67 = null;
	/* Column Info */
	private	String htchCvr68 = null;
	/* Column Info */
	private	String htchCvr69 = null;
	/* Column Info */
	private	String htchCvr70 = null;
	/* Column Info */
	private	String htchCvr71 = null;
	/* Column Info */
	private	String htchCvr72 = null;
	/* Column Info */
	private	String htchCvr73 = null;
	/* Column Info */
	private	String htchCvr74 = null;
	/* Column Info */
	private	String htchCvr75 = null;
	/* Column Info */
	private	String bayIdx = null;
	/* Column Info */
	private	String vslCd = null;
	/* Column Info */
	private	String skdVoyNo = null;
	/* Column Info */
	private	String skdDirCd = null;
	/* Column Info */
	private	String cntrId = null;
	/* Column Info */
	private	String portCd = null;
	/* Column Info */
	private	String vvdPortGb = null;
	/* Column Info */
	private	String etaFrDt = null;
	/* Column Info */
	private	String etaToDt = null;
	/* Column Info */
	private	String cntrBayIdx = null;
	/* Column Info */
	private	String portNm = null;
	/* Column Info */
	private	String portColor = null;
	/* Column Info */
	private	String vpsEtaDt = null;
	/* Column Info */
	private	String onBoardMsg = null;
	/* Column Info */
	private	String callInd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OpfStowageBayPlanListVO() {}

	public OpfStowageBayPlanListVO(String ibflag, String pagerows, String vvd, String bkgNo, String onTrNmF, String onTrNmB, String onRow0, String onRow1, String onRow2, String onRow3, String onRow4, String onRow5, String onRow6, String onRow7, String onRow8, String onRow9, String onRow10, String onRow11, String onRow12, String onRow13, String onRow14, String onRow15, String onRow16, String onRow17, String onRow18, String underTrNmF, String underTrNmB, String underRow0, String underRow1, String underRow2, String underRow3, String underRow4, String underRow5, String underRow6, String underRow7, String underRow8, String underRow9, String underRow10, String underRow11, String underRow12, String underRow13, String underRow14, String underRow15, String underRow16, String underRow17, String underRow18, String dhTp, String htchCvr0, String htchCvr1, String htchCvr2, String htchCvr3, String htchCvr4, String htchCvr5, String htchCvr6, String htchCvr7, String htchCvr8, String htchCvr9, String htchCvr10, String htchCvr11, String htchCvr12, String htchCvr13, String htchCvr14, String htchCvr15, String htchCvr16, String htchCvr17, String htchCvr18, String htchCvr19, String htchCvr20, String htchCvr21, String htchCvr22, String htchCvr23, String htchCvr24, String htchCvr25, String htchCvr26, String htchCvr27, String htchCvr28, String htchCvr29, String htchCvr30, String htchCvr31, String htchCvr32, String htchCvr33, String htchCvr34, String htchCvr35, String htchCvr36, String htchCvr37, String htchCvr38, String htchCvr39, String htchCvr40, String htchCvr41, String htchCvr42, String htchCvr43, String htchCvr44, String htchCvr45, String htchCvr46, String htchCvr47, String htchCvr48, String htchCvr49, String htchCvr50, String htchCvr51, String htchCvr52, String htchCvr53, String htchCvr54, String htchCvr55, String htchCvr56, String htchCvr57, String htchCvr58, String htchCvr59, String htchCvr60, String htchCvr61, String htchCvr62, String htchCvr63, String htchCvr64, String htchCvr65, String htchCvr66, String htchCvr67, String htchCvr68, String htchCvr69, String htchCvr70, String htchCvr71, String htchCvr72, String htchCvr73, String htchCvr74, String htchCvr75, String bayIdx, String vslCd, String skdVoyNo, String skdDirCd, String cntrId, String portCd, String vvdPortGb, String etaFrDt, String etaToDt, String cntrBayIdx, String portNm, String portColor, String vpsEtaDt, String onBoardMsg, String callInd) {
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.vvd = vvd;
		this.bkgNo = bkgNo;
		this.onTrNmF = onTrNmF;
		this.onTrNmB = onTrNmB;
		this.onRow0 = onRow0;
		this.onRow1 = onRow1;
		this.onRow2 = onRow2;
		this.onRow3 = onRow3;
		this.onRow4 = onRow4;
		this.onRow5 = onRow5;
		this.onRow6 = onRow6;
		this.onRow7 = onRow7;
		this.onRow8 = onRow8;
		this.onRow9 = onRow9;
		this.onRow10 = onRow10;
		this.onRow11 = onRow11;
		this.onRow12 = onRow12;
		this.onRow13 = onRow13;
		this.onRow14 = onRow14;
		this.onRow15 = onRow15;
		this.onRow16 = onRow16;
		this.onRow17 = onRow17;
		this.onRow18 = onRow18;
		this.underTrNmF = underTrNmF;
		this.underTrNmB = underTrNmB;
		this.underRow0 = underRow0;
		this.underRow1 = underRow1;
		this.underRow2 = underRow2;
		this.underRow3 = underRow3;
		this.underRow4 = underRow4;
		this.underRow5 = underRow5;
		this.underRow6 = underRow6;
		this.underRow7 = underRow7;
		this.underRow8 = underRow8;
		this.underRow9 = underRow9;
		this.underRow10 = underRow10;
		this.underRow11 = underRow11;
		this.underRow12 = underRow12;
		this.underRow13 = underRow13;
		this.underRow14 = underRow14;
		this.underRow15 = underRow15;
		this.underRow16 = underRow16;
		this.underRow17 = underRow17;
		this.underRow18 = underRow18;
		this.dhTp = dhTp;
		this.htchCvr0 	= htchCvr0;
		this.htchCvr1	= htchCvr1;
		this.htchCvr2	= htchCvr2;
		this.htchCvr3	= htchCvr3;
		this.htchCvr4	= htchCvr4;
		this.htchCvr5	= htchCvr5;
		this.htchCvr6	= htchCvr6;
		this.htchCvr7	= htchCvr7;
		this.htchCvr8	= htchCvr8;
		this.htchCvr9	= htchCvr9;
		this.htchCvr10	= htchCvr10;
		this.htchCvr11	= htchCvr11;
		this.htchCvr12	= htchCvr12;
		this.htchCvr13	= htchCvr13;
		this.htchCvr14	= htchCvr14;
		this.htchCvr15	= htchCvr15;
		this.htchCvr16	= htchCvr16;
		this.htchCvr17	= htchCvr17;
		this.htchCvr18	= htchCvr18;
		this.htchCvr19	= htchCvr19;
		this.htchCvr20	= htchCvr20;
		this.htchCvr21	= htchCvr21;
		this.htchCvr22	= htchCvr22;
		this.htchCvr23	= htchCvr23;
		this.htchCvr24	= htchCvr24;
		this.htchCvr25	= htchCvr25;
		this.htchCvr26	= htchCvr26;
		this.htchCvr27	= htchCvr27;
		this.htchCvr28	= htchCvr28;
		this.htchCvr29	= htchCvr29;
		this.htchCvr30	= htchCvr30;
		this.htchCvr31	= htchCvr31;
		this.htchCvr32	= htchCvr32;
		this.htchCvr33	= htchCvr33;
		this.htchCvr34	= htchCvr34;
		this.htchCvr35	= htchCvr35;
		this.htchCvr36	= htchCvr36;
		this.htchCvr37	= htchCvr37;
		this.htchCvr38	= htchCvr38;
		this.htchCvr39	= htchCvr39;
		this.htchCvr40	= htchCvr40;
		this.htchCvr41	= htchCvr41;
		this.htchCvr42	= htchCvr42;
		this.htchCvr43	= htchCvr43;
		this.htchCvr44	= htchCvr44;
		this.htchCvr45	= htchCvr45;
		this.htchCvr46	= htchCvr46;
		this.htchCvr47	= htchCvr47;
		this.htchCvr48	= htchCvr48;
		this.htchCvr49	= htchCvr49;
		this.htchCvr50	= htchCvr50;
		this.htchCvr51	= htchCvr51;
		this.htchCvr52	= htchCvr52;
		this.htchCvr53	= htchCvr53;
		this.htchCvr54	= htchCvr54;
		this.htchCvr55	= htchCvr55;
		this.htchCvr56	= htchCvr56;
		this.htchCvr57	= htchCvr57;
		this.htchCvr58	= htchCvr58;
		this.htchCvr59	= htchCvr59;
		this.htchCvr60	= htchCvr60;
		this.htchCvr61	= htchCvr61;
		this.htchCvr62	= htchCvr62;
		this.htchCvr63	= htchCvr63;
		this.htchCvr64	= htchCvr64;
		this.htchCvr65	= htchCvr65;
		this.htchCvr66	= htchCvr66;
		this.htchCvr67	= htchCvr67;
		this.htchCvr68	= htchCvr68;
		this.htchCvr69	= htchCvr69;
		this.htchCvr70	= htchCvr70;
		this.htchCvr71	= htchCvr71;		
		this.htchCvr72	= htchCvr72;		
		this.htchCvr73	= htchCvr73;		
		this.htchCvr74	= htchCvr74;		
		this.htchCvr75	= htchCvr75;		
		this.bayIdx	= bayIdx;		
		this.vslCd	= vslCd;		
		this.skdVoyNo	= skdVoyNo;		
		this.skdDirCd	= skdDirCd;		
		this.cntrId	= cntrId;		
		this.portCd	= portCd;		
		this.vvdPortGb	= vvdPortGb;		
		this.etaFrDt	= etaFrDt;		
		this.etaToDt	= etaToDt;		
		this.cntrBayIdx	= cntrBayIdx;		
		this.portNm	= portNm;		
		this.portColor	= portColor;		
		this.vpsEtaDt	= vpsEtaDt;		
		this.onBoardMsg	= onBoardMsg;		
		this.callInd	= callInd;		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("on_tr_nm_f", getOnTrNmF());
		this.hashColumns.put("on_tr_nm_b", getOnTrNmB());
		this.hashColumns.put("on_row_0", getOnRow0());
		this.hashColumns.put("on_row_1", getOnRow1());
		this.hashColumns.put("on_row_2", getOnRow2());
		this.hashColumns.put("on_row_3", getOnRow3());
		this.hashColumns.put("on_row_4", getOnRow4());
		this.hashColumns.put("on_row_5", getOnRow5());
		this.hashColumns.put("on_row_6", getOnRow6());
		this.hashColumns.put("on_row_7", getOnRow7());
		this.hashColumns.put("on_row_8", getOnRow8());
		this.hashColumns.put("on_row_9", getOnRow9());
		this.hashColumns.put("on_row_10", getOnRow10());
		this.hashColumns.put("on_row_11", getOnRow11());
		this.hashColumns.put("on_row_12", getOnRow12());
		this.hashColumns.put("on_row_13", getOnRow13());
		this.hashColumns.put("on_row_14", getOnRow14());
		this.hashColumns.put("on_row_15", getOnRow15());
		this.hashColumns.put("on_row_16", getOnRow16());
		this.hashColumns.put("on_row_17", getOnRow17());
		this.hashColumns.put("on_row_18", getOnRow18());
		this.hashColumns.put("under_tr_nm_f", getUnderTrNmF());
		this.hashColumns.put("under_tr_nm_b", getUnderTrNmB());
		this.hashColumns.put("under_row_0", getUnderRow0());
		this.hashColumns.put("under_row_1", getUnderRow1());
		this.hashColumns.put("under_row_2", getUnderRow2());
		this.hashColumns.put("under_row_3", getUnderRow3());
		this.hashColumns.put("under_row_4", getUnderRow4());
		this.hashColumns.put("under_row_5", getUnderRow5());
		this.hashColumns.put("under_row_6", getUnderRow6());
		this.hashColumns.put("under_row_7", getUnderRow7());
		this.hashColumns.put("under_row_8", getUnderRow8());
		this.hashColumns.put("under_row_9", getUnderRow9());
		this.hashColumns.put("under_row_10", getUnderRow10());
		this.hashColumns.put("under_row_11", getUnderRow11());
		this.hashColumns.put("under_row_12", getUnderRow12());
		this.hashColumns.put("under_row_13", getUnderRow13());
		this.hashColumns.put("under_row_14", getUnderRow14());
		this.hashColumns.put("under_row_15", getUnderRow15());
		this.hashColumns.put("under_row_16", getUnderRow16());
		this.hashColumns.put("under_row_17", getUnderRow17());
		this.hashColumns.put("under_row_18", getUnderRow18());
		this.hashColumns.put("dh_tp", getDhTp());
		this.hashColumns.put("htch_cvr_0", getHtchCvr0());
		this.hashColumns.put("htch_cvr_1", getHtchCvr1());
		this.hashColumns.put("htch_cvr_2", getHtchCvr2());
		this.hashColumns.put("htch_cvr_3", getHtchCvr3());
		this.hashColumns.put("htch_cvr_4", getHtchCvr4());
		this.hashColumns.put("htch_cvr_5", getHtchCvr5());
		this.hashColumns.put("htch_cvr_6", getHtchCvr6());
		this.hashColumns.put("htch_cvr_7", getHtchCvr7());
		this.hashColumns.put("htch_cvr_8", getHtchCvr8());
		this.hashColumns.put("htch_cvr_9", getHtchCvr9());
		this.hashColumns.put("htch_cvr_10", getHtchCvr10());
		this.hashColumns.put("htch_cvr_11", getHtchCvr11());
		this.hashColumns.put("htch_cvr_12", getHtchCvr12());
		this.hashColumns.put("htch_cvr_13", getHtchCvr13());
		this.hashColumns.put("htch_cvr_14", getHtchCvr14());
		this.hashColumns.put("htch_cvr_15", getHtchCvr15());
		this.hashColumns.put("htch_cvr_16", getHtchCvr16());
		this.hashColumns.put("htch_cvr_17", getHtchCvr17());
		this.hashColumns.put("htch_cvr_18", getHtchCvr18());
		this.hashColumns.put("htch_cvr_19", getHtchCvr19());
		this.hashColumns.put("htch_cvr_20", getHtchCvr20());
		this.hashColumns.put("htch_cvr_21", getHtchCvr21());
		this.hashColumns.put("htch_cvr_22", getHtchCvr22());
		this.hashColumns.put("htch_cvr_23", getHtchCvr23());
		this.hashColumns.put("htch_cvr_24", getHtchCvr24());
		this.hashColumns.put("htch_cvr_25", getHtchCvr25());
		this.hashColumns.put("htch_cvr_26", getHtchCvr26());
		this.hashColumns.put("htch_cvr_27", getHtchCvr27());
		this.hashColumns.put("htch_cvr_28", getHtchCvr28());
		this.hashColumns.put("htch_cvr_29", getHtchCvr29());
		this.hashColumns.put("htch_cvr_30", getHtchCvr30());
		this.hashColumns.put("htch_cvr_31", getHtchCvr31());
		this.hashColumns.put("htch_cvr_32", getHtchCvr32());
		this.hashColumns.put("htch_cvr_33", getHtchCvr33());
		this.hashColumns.put("htch_cvr_34", getHtchCvr34());
		this.hashColumns.put("htch_cvr_35", getHtchCvr35());
		this.hashColumns.put("htch_cvr_36", getHtchCvr36());
		this.hashColumns.put("htch_cvr_37", getHtchCvr37());
		this.hashColumns.put("htch_cvr_38", getHtchCvr38());
		this.hashColumns.put("htch_cvr_39", getHtchCvr39());
		this.hashColumns.put("htch_cvr_40", getHtchCvr40());
		this.hashColumns.put("htch_cvr_41", getHtchCvr41());
		this.hashColumns.put("htch_cvr_42", getHtchCvr42());
		this.hashColumns.put("htch_cvr_43", getHtchCvr43());
		this.hashColumns.put("htch_cvr_44", getHtchCvr44());
		this.hashColumns.put("htch_cvr_45", getHtchCvr45());
		this.hashColumns.put("htch_cvr_46", getHtchCvr46());
		this.hashColumns.put("htch_cvr_47", getHtchCvr47());
		this.hashColumns.put("htch_cvr_48", getHtchCvr48());
		this.hashColumns.put("htch_cvr_49", getHtchCvr49());
		this.hashColumns.put("htch_cvr_50", getHtchCvr50());
		this.hashColumns.put("htch_cvr_51", getHtchCvr51());
		this.hashColumns.put("htch_cvr_52", getHtchCvr52());
		this.hashColumns.put("htch_cvr_53", getHtchCvr53());
		this.hashColumns.put("htch_cvr_54", getHtchCvr54());
		this.hashColumns.put("htch_cvr_55", getHtchCvr55());
		this.hashColumns.put("htch_cvr_56", getHtchCvr56());
		this.hashColumns.put("htch_cvr_57", getHtchCvr57());
		this.hashColumns.put("htch_cvr_58", getHtchCvr58());
		this.hashColumns.put("htch_cvr_59", getHtchCvr59());
		this.hashColumns.put("htch_cvr_60", getHtchCvr60());
		this.hashColumns.put("htch_cvr_61", getHtchCvr61());
		this.hashColumns.put("htch_cvr_62", getHtchCvr62());
		this.hashColumns.put("htch_cvr_63", getHtchCvr63());
		this.hashColumns.put("htch_cvr_64", getHtchCvr64());
		this.hashColumns.put("htch_cvr_65", getHtchCvr65());
		this.hashColumns.put("htch_cvr_66", getHtchCvr66());
		this.hashColumns.put("htch_cvr_67", getHtchCvr67());
		this.hashColumns.put("htch_cvr_68", getHtchCvr68());
		this.hashColumns.put("htch_cvr_69", getHtchCvr69());
		this.hashColumns.put("htch_cvr_70", getHtchCvr70());
		this.hashColumns.put("htch_cvr_71", getHtchCvr71());
		this.hashColumns.put("htch_cvr_72", getHtchCvr72());
		this.hashColumns.put("htch_cvr_73", getHtchCvr73());
		this.hashColumns.put("htch_cvr_74", getHtchCvr74());
		this.hashColumns.put("htch_cvr_75", getHtchCvr75());
		this.hashColumns.put("bay_idx", getBayIdx());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cntr_id", getCntrId());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("vvd_port_gb", getVvdPortGb());
		this.hashColumns.put("eta_fr_dt", getEtaFrDt());
		this.hashColumns.put("eta_to_dt", getEtaToDt());
		this.hashColumns.put("cntr_bay_idx", getCntrBayIdx());
		this.hashColumns.put("port_nm", getPortNm());
		this.hashColumns.put("port_color", getPortColor());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("on_board_msg", getOnBoardMsg());
		this.hashColumns.put("call_ind", getCallInd());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cod_sts_cd", "codStsCd");
		this.hashFields.put("old_pod", "oldPod");
		this.hashFields.put("aprv_rjct_id", "aprvRjctId");
		this.hashFields.put("requested_date", "requestedDate");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cod_rqst_seq", "codRqstSeq");
		this.hashFields.put("cod_rhnd_port_cd", "codRhndPortCd");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("cod_rqst_rsn_cd", "codRqstRsnCd");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("new_skd_voy_no", "newSkdVoyNo");
		this.hashFields.put("cod_rhnd_port_yd_cd", "codRhndPortYdCd");
		this.hashFields.put("new_vsl_cd", "newVslCd");
		this.hashFields.put("cod_rqst_ofc_cd", "codRqstOfcCd");
		this.hashFields.put("rhnd_pord_eta_dt", "rhndPordEtaDt");
		this.hashFields.put("first_react_date", "firstReactDate");
		this.hashFields.put("new_skd_dir_cd", "newSkdDirCd");
		this.hashFields.put("pod_eta_dt", "podEtaDt");
		this.hashFields.put("old_del", "oldDel");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("old_pol", "oldPol");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("new_pod", "newPod");
		this.hashFields.put("act_dept_yn", "actDeptYn");
		this.hashFields.put("elapsed_day", "elapsedDay");
		this.hashFields.put("cod_email_send_yn", "codEmailSendYn");
		this.hashFields.put("new_pol", "newPol");
		this.hashFields.put("new_del", "newDel");
		this.hashFields.put("on_tr_nm_f", "onTrNmF");
		this.hashFields.put("on_tr_nm_b", "onTrNmB");
		this.hashFields.put("on_row_0", "onRow0");
		this.hashFields.put("on_row_1", "onRow1");
		this.hashFields.put("on_row_2", "onRow2");
		this.hashFields.put("on_row_3", "onRow3");
		this.hashFields.put("on_row_4", "onRow4");
		this.hashFields.put("on_row_5", "onRow5");
		this.hashFields.put("on_row_6", "onRow6");
		this.hashFields.put("on_row_7", "onRow7");
		this.hashFields.put("on_row_8", "onRow8");
		this.hashFields.put("on_row_9", "onRow9");
		this.hashFields.put("on_row_10", "onRow10");
		this.hashFields.put("on_row_11", "onRow11");
		this.hashFields.put("on_row_12", "onRow12");
		this.hashFields.put("on_row_13", "onRow13");
		this.hashFields.put("on_row_14", "onRow14");
		this.hashFields.put("on_row_15", "onRow15");
		this.hashFields.put("on_row_16", "onRow16");
		this.hashFields.put("on_row_17", "onRow17");
		this.hashFields.put("on_row_18", "onRow18");
		this.hashFields.put("under_tr_nm_f", "underTrNmF");
		this.hashFields.put("under_tr_nm_b", "underTrNmB");
		this.hashFields.put("under_row_0", "underRow0");
		this.hashFields.put("under_row_1", "underRow1");
		this.hashFields.put("under_row_2", "underRow2");
		this.hashFields.put("under_row_3", "underRow3");
		this.hashFields.put("under_row_4", "underRow4");
		this.hashFields.put("under_row_5", "underRow5");
		this.hashFields.put("under_row_6", "underRow6");
		this.hashFields.put("under_row_7", "underRow7");
		this.hashFields.put("under_row_8", "underRow8");
		this.hashFields.put("under_row_9", "underRow9");
		this.hashFields.put("under_row_10", "underRow10");
		this.hashFields.put("under_row_11", "underRow11");
		this.hashFields.put("under_row_12", "underRow12");
		this.hashFields.put("under_row_13", "underRow13");
		this.hashFields.put("under_row_14", "underRow14");
		this.hashFields.put("under_row_15", "underRow15");
		this.hashFields.put("under_row_16", "underRow16");
		this.hashFields.put("under_row_17", "underRow17");
		this.hashFields.put("under_row_18", "underRow18");
		this.hashFields.put("dh_tp", "dhTp");
		this.hashFields.put("htch_cvr_0", "htchCvr0");
		this.hashFields.put("htch_cvr_1", "htchCvr1");
		this.hashFields.put("htch_cvr_2", "htchCvr2");
		this.hashFields.put("htch_cvr_3", "htchCvr3");
		this.hashFields.put("htch_cvr_4", "htchCvr4");
		this.hashFields.put("htch_cvr_5", "htchCvr5");
		this.hashFields.put("htch_cvr_6", "htchCvr6");
		this.hashFields.put("htch_cvr_7", "htchCvr7");
		this.hashFields.put("htch_cvr_8", "htchCvr8");
		this.hashFields.put("htch_cvr_9", "htchCvr9");
		this.hashFields.put("htch_cvr_10", "htchCvr10");
		this.hashFields.put("htch_cvr_11", "htchCvr11");
		this.hashFields.put("htch_cvr_12", "htchCvr12");
		this.hashFields.put("htch_cvr_13", "htchCvr13");
		this.hashFields.put("htch_cvr_14", "htchCvr14");
		this.hashFields.put("htch_cvr_15", "htchCvr15");
		this.hashFields.put("htch_cvr_16", "htchCvr16");
		this.hashFields.put("htch_cvr_17", "htchCvr17");
		this.hashFields.put("htch_cvr_18", "htchCvr18");
		this.hashFields.put("htch_cvr_19", "htchCvr19");
		this.hashFields.put("htch_cvr_20", "htchCvr20");
		this.hashFields.put("htch_cvr_21", "htchCvr21");
		this.hashFields.put("htch_cvr_22", "htchCvr22");
		this.hashFields.put("htch_cvr_23", "htchCvr23");
		this.hashFields.put("htch_cvr_24", "htchCvr24");
		this.hashFields.put("htch_cvr_25", "htchCvr25");
		this.hashFields.put("htch_cvr_26", "htchCvr26");
		this.hashFields.put("htch_cvr_27", "htchCvr27");
		this.hashFields.put("htch_cvr_28", "htchCvr28");
		this.hashFields.put("htch_cvr_29", "htchCvr29");
		this.hashFields.put("htch_cvr_30", "htchCvr30");
		this.hashFields.put("htch_cvr_31", "htchCvr31");
		this.hashFields.put("htch_cvr_32", "htchCvr32");
		this.hashFields.put("htch_cvr_33", "htchCvr33");
		this.hashFields.put("htch_cvr_34", "htchCvr34");
		this.hashFields.put("htch_cvr_35", "htchCvr35");
		this.hashFields.put("htch_cvr_36", "htchCvr36");
		this.hashFields.put("htch_cvr_37", "htchCvr37");
		this.hashFields.put("htch_cvr_38", "htchCvr38");
		this.hashFields.put("htch_cvr_39", "htchCvr39");
		this.hashFields.put("htch_cvr_40", "htchCvr40");
		this.hashFields.put("htch_cvr_41", "htchCvr41");
		this.hashFields.put("htch_cvr_42", "htchCvr42");
		this.hashFields.put("htch_cvr_43", "htchCvr43");
		this.hashFields.put("htch_cvr_44", "htchCvr44");
		this.hashFields.put("htch_cvr_45", "htchCvr45");
		this.hashFields.put("htch_cvr_46", "htchCvr46");
		this.hashFields.put("htch_cvr_47", "htchCvr47");
		this.hashFields.put("htch_cvr_48", "htchCvr48");
		this.hashFields.put("htch_cvr_49", "htchCvr49");
		this.hashFields.put("htch_cvr_50", "htchCvr50");
		this.hashFields.put("htch_cvr_51", "htchCvr51");
		this.hashFields.put("htch_cvr_52", "htchCvr52");
		this.hashFields.put("htch_cvr_53", "htchCvr53");
		this.hashFields.put("htch_cvr_54", "htchCvr54");
		this.hashFields.put("htch_cvr_55", "htchCvr55");
		this.hashFields.put("htch_cvr_56", "htchCvr56");
		this.hashFields.put("htch_cvr_57", "htchCvr57");
		this.hashFields.put("htch_cvr_58", "htchCvr58");
		this.hashFields.put("htch_cvr_59", "htchCvr59");
		this.hashFields.put("htch_cvr_60", "htchCvr60");
		this.hashFields.put("htch_cvr_61", "htchCvr61");
		this.hashFields.put("htch_cvr_62", "htchCvr62");
		this.hashFields.put("htch_cvr_63", "htchCvr63");
		this.hashFields.put("htch_cvr_64", "htchCvr64");
		this.hashFields.put("htch_cvr_65", "htchCvr65");
		this.hashFields.put("htch_cvr_66", "htchCvr66");
		this.hashFields.put("htch_cvr_67", "htchCvr67");
		this.hashFields.put("htch_cvr_68", "htchCvr68");
		this.hashFields.put("htch_cvr_69", "htchCvr69");
		this.hashFields.put("htch_cvr_70", "htchCvr70");
		this.hashFields.put("htch_cvr_71", "htchCvr71");
		this.hashFields.put("htch_cvr_72", "htchCvr72");
		this.hashFields.put("htch_cvr_73", "htchCvr73");
		this.hashFields.put("htch_cvr_74", "htchCvr74");
		this.hashFields.put("htch_cvr_75", "htchCvr75");
		this.hashFields.put("bay_idx", "bayIdx");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cntr_id", "cntrId");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("vvd_port_gb", "vvdPortGb");
		this.hashFields.put("eta_fr_dt", "etaFrDt");
		this.hashFields.put("eta_to_dt", "etaToDt");
		this.hashFields.put("cntr_bay_idx", "cntrBayIdx");
		this.hashFields.put("port_nm", "portNm");
		this.hashFields.put("port_color", "portColor");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("on_board_msg", "onBoardMsg");
		this.hashFields.put("call_ind", "callInd");
		return this.hashFields;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	public String getPagerows() {
		return pagerows;
	}
	
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	public String getIbflag() {
		return ibflag;
	}
	
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	public String getVvd() {
		return vvd;
	}
	
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	public String getBkgNo() {
		return bkgNo;
	}
	
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public String getOnTrNmF() {
		return onTrNmF;
	}

	public void setOnTrNmF(String onTrNmF) {
		this.onTrNmF = onTrNmF;
	}

	public String getOnRow0() {
		return onRow0;
	}
	
	public void setOnRow0(String onRow0) {
		this.onRow0 = onRow0;
	}
	
	public String getOnRow1() {
		return onRow1;
	}
	
	public void setOnRow1(String onRow1) {
		this.onRow1 = onRow1;
	}
	
	public String getOnRow2() {
		return onRow2;
	}
	
	public void setOnRow2(String onRow2) {
		this.onRow2 = onRow2;
	}
	
	public String getOnRow3() {
		return onRow3;
	}
	
	public void setOnRow3(String onRow3) {
		this.onRow3 = onRow3;
	}
	
	public String getOnRow4() {
		return onRow4;
	}
	
	public void setOnRow4(String onRow4) {
		this.onRow4 = onRow4;
	}
	
	public String getOnRow5() {
		return onRow5;
	}
	
	public void setOnRow5(String onRow5) {
		this.onRow5 = onRow5;
	}
	
	public String getOnRow6() {
		return onRow6;
	}
	
	public void setOnRow6(String onRow6) {
		this.onRow6 = onRow6;
	}
	
	public String getOnRow7() {
		return onRow7;
	}
	
	public void setOnRow7(String onRow7) {
		this.onRow7 = onRow7;
	}
	
	public String getOnRow8() {
		return onRow8;
	}
	
	public void setOnRow8(String onRow8) {
		this.onRow8 = onRow8;
	}
	
	public String getOnRow9() {
		return onRow9;
	}
	
	public void setOnRow9(String onRow9) {
		this.onRow9 = onRow9;
	}
	
	public String getOnRow10() {
		return onRow10;
	}
	
	public void setOnRow10(String onRow10) {
		this.onRow10 = onRow10;
	}
	
	public String getOnRow11() {
		return onRow11;
	}
	
	public void setOnRow11(String onRow11) {
		this.onRow11 = onRow11;
	}
	
	public String getOnRow12() {
		return onRow12;
	}
	
	public void setOnRow12(String onRow12) {
		this.onRow12 = onRow12;
	}
	
	public String getOnRow13() {
		return onRow13;
	}
	
	public void setOnRow13(String onRow13) {
		this.onRow13 = onRow13;
	}
	
	public String getOnRow14() {
		return onRow14;
	}
	
	public void setOnRow14(String onRow14) {
		this.onRow14 = onRow14;
	}
	
	public String getOnRow15() {
		return onRow15;
	}
	
	public void setOnRow15(String onRow15) {
		this.onRow15 = onRow15;
	}
	
	public String getOnRow16() {
		return onRow16;
	}
	
	public void setOnRow16(String onRow16) {
		this.onRow16 = onRow16;
	}
	
	public String getOnRow17() {
		return onRow17;
	}
	
	public void setOnRow17(String onRow17) {
		this.onRow17 = onRow17;
	}
	
	public String getOnRow18() {
		return onRow18;
	}
	
	public void setOnRow18(String onRow18) {
		this.onRow18 = onRow18;
	}

	public String getUnderTrNmB() {
		return underTrNmB;
	}

	public void setUnderTrNmB(String underTrNmB) {
		this.underTrNmB = underTrNmB;
	}
	
	public String getUnderRow0() {
		return underRow0;
	}

	public void setUnderRow0(String underRow0) {
		this.underRow0 = underRow0;
	}

	public String getUnderRow1() {
		return underRow1;
	}

	public void setUnderRow1(String underRow1) {
		this.underRow1 = underRow1;
	}

	public String getUnderRow2() {
		return underRow2;
	}

	public void setUnderRow2(String underRow2) {
		this.underRow2 = underRow2;
	}

	public String getUnderRow3() {
		return underRow3;
	}

	public void setUnderRow3(String underRow3) {
		this.underRow3 = underRow3;
	}

	public String getUnderRow4() {
		return underRow4;
	}

	public void setUnderRow4(String underRow4) {
		this.underRow4 = underRow4;
	}

	public String getUnderRow5() {
		return underRow5;
	}

	public void setUnderRow5(String underRow5) {
		this.underRow5 = underRow5;
	}

	public String getUnderRow6() {
		return underRow6;
	}

	public void setUnderRow6(String underRow6) {
		this.underRow6 = underRow6;
	}

	public String getUnderRow7() {
		return underRow7;
	}

	public void setUnderRow7(String underRow7) {
		this.underRow7 = underRow7;
	}

	public String getUnderRow9() {
		return underRow9;
	}

	public void setUnderRow9(String underRow9) {
		this.underRow9 = underRow9;
	}

	public String getUnderRow8() {
		return underRow8;
	}

	public void setUnderRow8(String underRow8) {
		this.underRow8 = underRow8;
	}

	public String getUnderRow10() {
		return underRow10;
	}

	public void setUnderRow10(String underRow10) {
		this.underRow10 = underRow10;
	}

	public String getUnderRow11() {
		return underRow11;
	}

	public void setUnderRow11(String underRow11) {
		this.underRow11 = underRow11;
	}

	public String getUnderRow12() {
		return underRow12;
	}

	public void setUnderRow12(String underRow12) {
		this.underRow12 = underRow12;
	}

	public String getUnderRow13() {
		return underRow13;
	}

	public void setUnderRow13(String underRow13) {
		this.underRow13 = underRow13;
	}

	public String getUnderRow14() {
		return underRow14;
	}

	public void setUnderRow14(String underRow14) {
		this.underRow14 = underRow14;
	}

	public String getUnderRow15() {
		return underRow15;
	}

	public void setUnderRow15(String underRow15) {
		this.underRow15 = underRow15;
	}

	public String getUnderRow16() {
		return underRow16;
	}

	public void setUnderRow16(String underRow16) {
		this.underRow16 = underRow16;
	}

	public String getUnderRow17() {
		return underRow17;
	}

	public void setUnderRow17(String underRow17) {
		this.underRow17 = underRow17;
	}

	public String getUnderRow18() {
		return underRow18;
	}

	public void setUnderRow18(String underRow18) {
		this.underRow18 = underRow18;
	}

	public String getDhTp() {
		return dhTp;
	}

	public void setDhTp(String dhTp) {
		this.dhTp = dhTp;
	}

	public String getHtchCvr0() {
		return htchCvr0;
	}

	public void setHtchCvr0(String htchCvr0) {
		this.htchCvr0 = htchCvr0;
	}

	public String getHtchCvr1() {
		return htchCvr1;
	}

	public void setHtchCvr1(String htchCvr1) {
		this.htchCvr1 = htchCvr1;
	}

	public String getHtchCvr2() {
		return htchCvr2;
	}

	public void setHtchCvr2(String htchCvr2) {
		this.htchCvr2 = htchCvr2;
	}

	public String getHtchCvr3() {
		return htchCvr3;
	}

	public void setHtchCvr3(String htchCvr3) {
		this.htchCvr3 = htchCvr3;
	}

	public String getHtchCvr4() {
		return htchCvr4;
	}

	public void setHtchCvr4(String htchCvr4) {
		this.htchCvr4 = htchCvr4;
	}

	public String getHtchCvr5() {
		return htchCvr5;
	}

	public void setHtchCvr5(String htchCvr5) {
		this.htchCvr5 = htchCvr5;
	}

	public String getHtchCvr6() {
		return htchCvr6;
	}

	public void setHtchCvr6(String htchCvr6) {
		this.htchCvr6 = htchCvr6;
	}

	public String getHtchCvr7() {
		return htchCvr7;
	}

	public void setHtchCvr7(String htchCvr7) {
		this.htchCvr7 = htchCvr7;
	}

	public String getHtchCvr8() {
		return htchCvr8;
	}

	public void setHtchCvr8(String htchCvr8) {
		this.htchCvr8 = htchCvr8;
	}

	public String getHtchCvr9() {
		return htchCvr9;
	}

	public void setHtchCvr9(String htchCvr9) {
		this.htchCvr9 = htchCvr9;
	}

	public String getHtchCvr10() {
		return htchCvr10;
	}

	public void setHtchCvr10(String htchCvr10) {
		this.htchCvr10 = htchCvr10;
	}

	public String getHtchCvr11() {
		return htchCvr11;
	}

	public void setHtchCvr11(String htchCvr11) {
		this.htchCvr11 = htchCvr11;
	}

	public String getHtchCvr12() {
		return htchCvr12;
	}

	public void setHtchCvr12(String htchCvr12) {
		this.htchCvr12 = htchCvr12;
	}

	public String getHtchCvr13() {
		return htchCvr13;
	}

	public void setHtchCvr13(String htchCvr13) {
		this.htchCvr13 = htchCvr13;
	}

	public String getHtchCvr14() {
		return htchCvr14;
	}

	public void setHtchCvr14(String htchCvr14) {
		this.htchCvr14 = htchCvr14;
	}

	public String getHtchCvr15() {
		return htchCvr15;
	}

	public void setHtchCvr15(String htchCvr15) {
		this.htchCvr15 = htchCvr15;
	}

	public String getHtchCvr16() {
		return htchCvr16;
	}

	public void setHtchCvr16(String htchCvr16) {
		this.htchCvr16 = htchCvr16;
	}

	public String getHtchCvr17() {
		return htchCvr17;
	}

	public void setHtchCvr17(String htchCvr17) {
		this.htchCvr17 = htchCvr17;
	}

	public String getHtchCvr18() {
		return htchCvr18;
	}

	public void setHtchCvr18(String htchCvr18) {
		this.htchCvr18 = htchCvr18;
	}

	public String getHtchCvr19() {
		return htchCvr19;
	}

	public void setHtchCvr19(String htchCvr19) {
		this.htchCvr19 = htchCvr19;
	}

	public String getHtchCvr20() {
		return htchCvr20;
	}

	public void setHtchCvr20(String htchCvr20) {
		this.htchCvr20 = htchCvr20;
	}

	public String getHtchCvr21() {
		return htchCvr21;
	}

	public void setHtchCvr21(String htchCvr21) {
		this.htchCvr21 = htchCvr21;
	}

	public String getHtchCvr22() {
		return htchCvr22;
	}

	public void setHtchCvr22(String htchCvr22) {
		this.htchCvr22 = htchCvr22;
	}

	public String getHtchCvr23() {
		return htchCvr23;
	}

	public void setHtchCvr23(String htchCvr23) {
		this.htchCvr23 = htchCvr23;
	}

	public String getHtchCvr24() {
		return htchCvr24;
	}

	public void setHtchCvr24(String htchCvr24) {
		this.htchCvr24 = htchCvr24;
	}

	public String getHtchCvr25() {
		return htchCvr25;
	}

	public void setHtchCvr25(String htchCvr25) {
		this.htchCvr25 = htchCvr25;
	}

	public String getHtchCvr26() {
		return htchCvr26;
	}

	public void setHtchCvr26(String htchCvr26) {
		this.htchCvr26 = htchCvr26;
	}

	public String getHtchCvr27() {
		return htchCvr27;
	}

	public void setHtchCvr27(String htchCvr27) {
		this.htchCvr27 = htchCvr27;
	}

	public String getHtchCvr28() {
		return htchCvr28;
	}

	public void setHtchCvr28(String htchCvr28) {
		this.htchCvr28 = htchCvr28;
	}

	public String getHtchCvr29() {
		return htchCvr29;
	}

	public void setHtchCvr29(String htchCvr29) {
		this.htchCvr29 = htchCvr29;
	}

	public String getHtchCvr30() {
		return htchCvr30;
	}

	public void setHtchCvr30(String htchCvr30) {
		this.htchCvr30 = htchCvr30;
	}

	public String getHtchCvr31() {
		return htchCvr31;
	}

	public void setHtchCvr31(String htchCvr31) {
		this.htchCvr31 = htchCvr31;
	}

	public String getHtchCvr32() {
		return htchCvr32;
	}

	public void setHtchCvr32(String htchCvr32) {
		this.htchCvr32 = htchCvr32;
	}

	public String getHtchCvr33() {
		return htchCvr33;
	}

	public void setHtchCvr33(String htchCvr33) {
		this.htchCvr33 = htchCvr33;
	}

	public String getHtchCvr34() {
		return htchCvr34;
	}

	public void setHtchCvr34(String htchCvr34) {
		this.htchCvr34 = htchCvr34;
	}

	public String getHtchCvr35() {
		return htchCvr35;
	}

	public void setHtchCvr35(String htchCvr35) {
		this.htchCvr35 = htchCvr35;
	}

	public String getHtchCvr36() {
		return htchCvr36;
	}

	public void setHtchCvr36(String htchCvr36) {
		this.htchCvr36 = htchCvr36;
	}

	public String getHtchCvr37() {
		return htchCvr37;
	}

	public void setHtchCvr37(String htchCvr37) {
		this.htchCvr37 = htchCvr37;
	}

	public String getHtchCvr38() {
		return htchCvr38;
	}

	public void setHtchCvr38(String htchCvr38) {
		this.htchCvr38 = htchCvr38;
	}

	public String getHtchCvr39() {
		return htchCvr39;
	}

	public void setHtchCvr39(String htchCvr39) {
		this.htchCvr39 = htchCvr39;
	}

	public String getHtchCvr40() {
		return htchCvr40;
	}

	public void setHtchCvr40(String htchCvr40) {
		this.htchCvr40 = htchCvr40;
	}

	public String getHtchCvr41() {
		return htchCvr41;
	}

	public void setHtchCvr41(String htchCvr41) {
		this.htchCvr41 = htchCvr41;
	}

	public String getHtchCvr42() {
		return htchCvr42;
	}

	public void setHtchCvr42(String htchCvr42) {
		this.htchCvr42 = htchCvr42;
	}

	public String getHtchCvr43() {
		return htchCvr43;
	}

	public void setHtchCvr43(String htchCvr43) {
		this.htchCvr43 = htchCvr43;
	}

	public String getHtchCvr44() {
		return htchCvr44;
	}

	public void setHtchCvr44(String htchCvr44) {
		this.htchCvr44 = htchCvr44;
	}

	public String getHtchCvr45() {
		return htchCvr45;
	}

	public void setHtchCvr45(String htchCvr45) {
		this.htchCvr45 = htchCvr45;
	}

	public String getHtchCvr46() {
		return htchCvr46;
	}

	public void setHtchCvr46(String htchCvr46) {
		this.htchCvr46 = htchCvr46;
	}

	public String getHtchCvr47() {
		return htchCvr47;
	}

	public void setHtchCvr47(String htchCvr47) {
		this.htchCvr47 = htchCvr47;
	}

	public String getHtchCvr48() {
		return htchCvr48;
	}

	public void setHtchCvr48(String htchCvr48) {
		this.htchCvr48 = htchCvr48;
	}

	public String getHtchCvr49() {
		return htchCvr49;
	}

	public void setHtchCvr49(String htchCvr49) {
		this.htchCvr49 = htchCvr49;
	}

	public String getHtchCvr50() {
		return htchCvr50;
	}

	public void setHtchCvr50(String htchCvr50) {
		this.htchCvr50 = htchCvr50;
	}

	public String getHtchCvr51() {
		return htchCvr51;
	}

	public void setHtchCvr51(String htchCvr51) {
		this.htchCvr51 = htchCvr51;
	}

	public String getHtchCvr52() {
		return htchCvr52;
	}

	public void setHtchCvr52(String htchCvr52) {
		this.htchCvr52 = htchCvr52;
	}

	public String getHtchCvr53() {
		return htchCvr53;
	}

	public void setHtchCvr53(String htchCvr53) {
		this.htchCvr53 = htchCvr53;
	}

	public String getHtchCvr54() {
		return htchCvr54;
	}

	public void setHtchCvr54(String htchCvr54) {
		this.htchCvr54 = htchCvr54;
	}

	public String getHtchCvr55() {
		return htchCvr55;
	}

	public void setHtchCvr55(String htchCvr55) {
		this.htchCvr55 = htchCvr55;
	}

	public String getHtchCvr56() {
		return htchCvr56;
	}

	public void setHtchCvr56(String htchCvr56) {
		this.htchCvr56 = htchCvr56;
	}

	public String getHtchCvr57() {
		return htchCvr57;
	}

	public void setHtchCvr57(String htchCvr57) {
		this.htchCvr57 = htchCvr57;
	}

	public String getHtchCvr58() {
		return htchCvr58;
	}

	public void setHtchCvr58(String htchCvr58) {
		this.htchCvr58 = htchCvr58;
	}

	public String getHtchCvr59() {
		return htchCvr59;
	}

	public void setHtchCvr59(String htchCvr59) {
		this.htchCvr59 = htchCvr59;
	}

	public String getHtchCvr60() {
		return htchCvr60;
	}

	public void setHtchCvr60(String htchCvr60) {
		this.htchCvr60 = htchCvr60;
	}

	public String getHtchCvr61() {
		return htchCvr61;
	}

	public void setHtchCvr61(String htchCvr61) {
		this.htchCvr61 = htchCvr61;
	}

	public String getHtchCvr62() {
		return htchCvr62;
	}

	public void setHtchCvr62(String htchCvr62) {
		this.htchCvr62 = htchCvr62;
	}

	public String getHtchCvr63() {
		return htchCvr63;
	}

	public void setHtchCvr63(String htchCvr63) {
		this.htchCvr63 = htchCvr63;
	}

	public String getHtchCvr64() {
		return htchCvr64;
	}

	public void setHtchCvr64(String htchCvr64) {
		this.htchCvr64 = htchCvr64;
	}

	public String getHtchCvr65() {
		return htchCvr65;
	}

	public void setHtchCvr65(String htchCvr65) {
		this.htchCvr65 = htchCvr65;
	}

	public String getHtchCvr66() {
		return htchCvr66;
	}

	public void setHtchCvr66(String htchCvr66) {
		this.htchCvr66 = htchCvr66;
	}

	public String getHtchCvr67() {
		return htchCvr67;
	}

	public void setHtchCvr67(String htchCvr67) {
		this.htchCvr67 = htchCvr67;
	}

	public String getHtchCvr68() {
		return htchCvr68;
	}

	public void setHtchCvr68(String htchCvr68) {
		this.htchCvr68 = htchCvr68;
	}

	public String getHtchCvr69() {
		return htchCvr69;
	}

	public void setHtchCvr69(String htchCvr69) {
		this.htchCvr69 = htchCvr69;
	}

	public String getHtchCvr70() {
		return htchCvr70;
	}

	public void setHtchCvr70(String htchCvr70) {
		this.htchCvr70 = htchCvr70;
	}

	public String getHtchCvr71() {
		return htchCvr71;
	}

	public void setHtchCvr71(String htchCvr71) {
		this.htchCvr71 = htchCvr71;
	}

	public String getHtchCvr72() {
		return htchCvr72;
	}

	public void setHtchCvr72(String htchCvr72) {
		this.htchCvr72 = htchCvr72;
	}

	public String getHtchCvr73() {
		return htchCvr73;
	}

	public void setHtchCvr73(String htchCvr73) {
		this.htchCvr73 = htchCvr73;
	}

	public String getHtchCvr74() {
		return htchCvr74;
	}

	public void setHtchCvr74(String htchCvr74) {
		this.htchCvr74 = htchCvr74;
	}

	public String getHtchCvr75() {
		return htchCvr75;
	}

	public void setHtchCvr75(String htchCvr75) {
		this.htchCvr75 = htchCvr75;
	}

	public String getBayIdx() {
		return bayIdx;
	}

	public void setBayIdx(String bayIdx) {
		this.bayIdx = bayIdx;
	}

	public String getVslCd() {
		return vslCd;
	}

	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	public String getSkdVoyNo() {
		return skdVoyNo;
	}

	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}

	public String getSkdDirCd() {
		return skdDirCd;
	}

	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}

	public String getCntrId() {
		return cntrId;
	}

	public void setCntrId(String cntrId) {
		this.cntrId = cntrId;
	}

	public String getOnTrNmB() {
		return onTrNmB;
	}

	public void setOnTrNmB(String onTrNmB) {
		this.onTrNmB = onTrNmB;
	}

	public String getUnderTrNmF() {
		return underTrNmF;
	}

	public void setUnderTrNmF(String underTrNmF) {
		this.underTrNmF = underTrNmF;
	}

	public String getPortCd() {
		return portCd;
	}

	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}

	public String getVvdPortGb() {
		return vvdPortGb;
	}

	public void setVvdPortGb(String vvdPortGb) {
		this.vvdPortGb = vvdPortGb;
	}

	public String getEtaFrDt() {
		return etaFrDt;
	}

	public void setEtaFrDt(String etaFrDt) {
		this.etaFrDt = etaFrDt;
	}

	public String getEtaToDt() {
		return etaToDt;
	}

	public void setEtaToDt(String etaToDt) {
		this.etaToDt = etaToDt;
	}

	public String getCntrBayIdx() {
		return cntrBayIdx;
	}

	public void setCntrBayIdx(String cntrBayIdx) {
		this.cntrBayIdx = cntrBayIdx;
	}

	public String getPortNm() {
		return portNm;
	}

	public void setPortNm(String portNm) {
		this.portNm = portNm;
	}

	public String getPortColor() {
		return portColor;
	}

	public void setPortColor(String portColor) {
		this.portColor = portColor;
	}
	
	public String getVpsEtaDt() {
		return vpsEtaDt;
	}

	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
	}
	
	public String getOnBoardMsg() {
		return onBoardMsg;
	}

	public void setOnBoardMsg(String onBoardMsg) {
		this.onBoardMsg = onBoardMsg;
	}
	
	public String getCallInd() {
		return callInd;
	}

	public void setCallInd(String callInd) {
		this.callInd = callInd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setOnTrNmF(JSPUtil.getParameter(request, prefix + "on_tr_nm_f", ""));
		setOnTrNmB(JSPUtil.getParameter(request, prefix + "on_tr_nm_b", ""));
		setOnRow0(JSPUtil.getParameter(request, prefix + "on_row_0", ""));
		setOnRow1(JSPUtil.getParameter(request, prefix + "on_row_1", ""));
		setOnRow2(JSPUtil.getParameter(request, prefix + "on_row_2", ""));
		setOnRow3(JSPUtil.getParameter(request, prefix + "on_row_3", ""));
		setOnRow4(JSPUtil.getParameter(request, prefix + "on_row_4", ""));
		setOnRow5(JSPUtil.getParameter(request, prefix + "on_row_5", ""));
		setOnRow6(JSPUtil.getParameter(request, prefix + "on_row_6", ""));
		setOnRow7(JSPUtil.getParameter(request, prefix + "on_row_7", ""));
		setOnRow8(JSPUtil.getParameter(request, prefix + "on_row_8", ""));
		setOnRow9(JSPUtil.getParameter(request, prefix + "on_row_9", ""));
		setOnRow10(JSPUtil.getParameter(request, prefix + "on_row_10", ""));
		setOnRow11(JSPUtil.getParameter(request, prefix + "on_row_11", ""));
		setOnRow12(JSPUtil.getParameter(request, prefix + "on_row_12", ""));
		setOnRow13(JSPUtil.getParameter(request, prefix + "on_row_13", ""));
		setOnRow14(JSPUtil.getParameter(request, prefix + "on_row_14", ""));
		setOnRow15(JSPUtil.getParameter(request, prefix + "on_row_15", ""));
		setOnRow16(JSPUtil.getParameter(request, prefix + "on_row_16", ""));
		setOnRow17(JSPUtil.getParameter(request, prefix + "on_row_17", ""));
		setOnRow18(JSPUtil.getParameter(request, prefix + "on_row_18", ""));
		setUnderTrNmF(JSPUtil.getParameter(request, prefix + "under_tr_nm_f", ""));
		setUnderTrNmB(JSPUtil.getParameter(request, prefix + "under_tr_nm_b", ""));
		setUnderRow1(JSPUtil.getParameter(request, prefix + "under_row_1", ""));
		setUnderRow0(JSPUtil.getParameter(request, prefix + "under_row_0", ""));
		setUnderRow2(JSPUtil.getParameter(request, prefix + "under_row_2", ""));
		setUnderRow3(JSPUtil.getParameter(request, prefix + "under_row_3", ""));
		setUnderRow4(JSPUtil.getParameter(request, prefix + "under_row_4", ""));
		setUnderRow5(JSPUtil.getParameter(request, prefix + "under_row_5", ""));
		setUnderRow6(JSPUtil.getParameter(request, prefix + "under_row_6", ""));
		setUnderRow7(JSPUtil.getParameter(request, prefix + "under_row_7", ""));
		setUnderRow8(JSPUtil.getParameter(request, prefix + "under_row_8", ""));
		setUnderRow9(JSPUtil.getParameter(request, prefix + "under_row_9", ""));
		setUnderRow10(JSPUtil.getParameter(request, prefix + "under_row_10", ""));
		setUnderRow11(JSPUtil.getParameter(request, prefix + "under_row_11", ""));
		setUnderRow12(JSPUtil.getParameter(request, prefix + "under_row_12", ""));
		setUnderRow13(JSPUtil.getParameter(request, prefix + "under_row_13", ""));
		setUnderRow14(JSPUtil.getParameter(request, prefix + "under_row_14", ""));
		setUnderRow15(JSPUtil.getParameter(request, prefix + "under_row_15", ""));
		setUnderRow16(JSPUtil.getParameter(request, prefix + "under_row_16", ""));
		setUnderRow17(JSPUtil.getParameter(request, prefix + "under_row_17", ""));
		setUnderRow18(JSPUtil.getParameter(request, prefix + "under_row_18", ""));
		setDhTp(JSPUtil.getParameter(request, prefix + "dh_tp", ""));
		setHtchCvr0(JSPUtil.getParameter(request, prefix + "htch_cvr_0", ""));
		setHtchCvr1(JSPUtil.getParameter(request, prefix + "htch_cvr_1", ""));
		setHtchCvr2(JSPUtil.getParameter(request, prefix + "htch_cvr_2", ""));
		setHtchCvr3(JSPUtil.getParameter(request, prefix + "htch_cvr_3", ""));
		setHtchCvr4(JSPUtil.getParameter(request, prefix + "htch_cvr_4", ""));
		setHtchCvr5(JSPUtil.getParameter(request, prefix + "htch_cvr_5", ""));
		setHtchCvr6(JSPUtil.getParameter(request, prefix + "htch_cvr_6", ""));
		setHtchCvr7(JSPUtil.getParameter(request, prefix + "htch_cvr_7", ""));
		setHtchCvr8(JSPUtil.getParameter(request, prefix + "htch_cvr_8", ""));
		setHtchCvr9(JSPUtil.getParameter(request, prefix + "htch_cvr_9", ""));
		setHtchCvr10(JSPUtil.getParameter(request, prefix + "htch_cvr_10", ""));
		setHtchCvr11(JSPUtil.getParameter(request, prefix + "htch_cvr_11", ""));
		setHtchCvr12(JSPUtil.getParameter(request, prefix + "htch_cvr_12", ""));
		setHtchCvr13(JSPUtil.getParameter(request, prefix + "htch_cvr_13", ""));
		setHtchCvr14(JSPUtil.getParameter(request, prefix + "htch_cvr_14", ""));
		setHtchCvr15(JSPUtil.getParameter(request, prefix + "htch_cvr_15", ""));
		setHtchCvr16(JSPUtil.getParameter(request, prefix + "htch_cvr_16", ""));
		setHtchCvr17(JSPUtil.getParameter(request, prefix + "htch_cvr_17", ""));
		setHtchCvr18(JSPUtil.getParameter(request, prefix + "htch_cvr_18", ""));
		setHtchCvr19(JSPUtil.getParameter(request, prefix + "htch_cvr_19", ""));
		setHtchCvr20(JSPUtil.getParameter(request, prefix + "htch_cvr_20", ""));
		setHtchCvr21(JSPUtil.getParameter(request, prefix + "htch_cvr_21", ""));
		setHtchCvr22(JSPUtil.getParameter(request, prefix + "htch_cvr_22", ""));
		setHtchCvr23(JSPUtil.getParameter(request, prefix + "htch_cvr_23", ""));
		setHtchCvr24(JSPUtil.getParameter(request, prefix + "htch_cvr_24", ""));
		setHtchCvr25(JSPUtil.getParameter(request, prefix + "htch_cvr_25", ""));
		setHtchCvr26(JSPUtil.getParameter(request, prefix + "htch_cvr_26", ""));
		setHtchCvr27(JSPUtil.getParameter(request, prefix + "htch_cvr_27", ""));
		setHtchCvr28(JSPUtil.getParameter(request, prefix + "htch_cvr_28", ""));
		setHtchCvr29(JSPUtil.getParameter(request, prefix + "htch_cvr_29", ""));
		setHtchCvr30(JSPUtil.getParameter(request, prefix + "htch_cvr_30", ""));
		setHtchCvr31(JSPUtil.getParameter(request, prefix + "htch_cvr_31", ""));
		setHtchCvr32(JSPUtil.getParameter(request, prefix + "htch_cvr_32", ""));
		setHtchCvr33(JSPUtil.getParameter(request, prefix + "htch_cvr_33", ""));
		setHtchCvr34(JSPUtil.getParameter(request, prefix + "htch_cvr_34", ""));
		setHtchCvr35(JSPUtil.getParameter(request, prefix + "htch_cvr_35", ""));
		setHtchCvr36(JSPUtil.getParameter(request, prefix + "htch_cvr_36", ""));
		setHtchCvr37(JSPUtil.getParameter(request, prefix + "htch_cvr_37", ""));
		setHtchCvr38(JSPUtil.getParameter(request, prefix + "htch_cvr_38", ""));
		setHtchCvr39(JSPUtil.getParameter(request, prefix + "htch_cvr_39", ""));
		setHtchCvr40(JSPUtil.getParameter(request, prefix + "htch_cvr_40", ""));
		setHtchCvr41(JSPUtil.getParameter(request, prefix + "htch_cvr_41", ""));
		setHtchCvr42(JSPUtil.getParameter(request, prefix + "htch_cvr_42", ""));
		setHtchCvr43(JSPUtil.getParameter(request, prefix + "htch_cvr_43", ""));
		setHtchCvr44(JSPUtil.getParameter(request, prefix + "htch_cvr_44", ""));
		setHtchCvr45(JSPUtil.getParameter(request, prefix + "htch_cvr_45", ""));
		setHtchCvr46(JSPUtil.getParameter(request, prefix + "htch_cvr_46", ""));
		setHtchCvr47(JSPUtil.getParameter(request, prefix + "htch_cvr_47", ""));
		setHtchCvr48(JSPUtil.getParameter(request, prefix + "htch_cvr_48", ""));
		setHtchCvr49(JSPUtil.getParameter(request, prefix + "htch_cvr_49", ""));
		setHtchCvr50(JSPUtil.getParameter(request, prefix + "htch_cvr_50", ""));
		setHtchCvr51(JSPUtil.getParameter(request, prefix + "htch_cvr_51", ""));
		setHtchCvr52(JSPUtil.getParameter(request, prefix + "htch_cvr_52", ""));
		setHtchCvr53(JSPUtil.getParameter(request, prefix + "htch_cvr_53", ""));
		setHtchCvr54(JSPUtil.getParameter(request, prefix + "htch_cvr_54", ""));
		setHtchCvr55(JSPUtil.getParameter(request, prefix + "htch_cvr_55", ""));
		setHtchCvr56(JSPUtil.getParameter(request, prefix + "htch_cvr_56", ""));
		setHtchCvr57(JSPUtil.getParameter(request, prefix + "htch_cvr_57", ""));
		setHtchCvr58(JSPUtil.getParameter(request, prefix + "htch_cvr_58", ""));
		setHtchCvr59(JSPUtil.getParameter(request, prefix + "htch_cvr_59", ""));
		setHtchCvr60(JSPUtil.getParameter(request, prefix + "htch_cvr_60", ""));
		setHtchCvr61(JSPUtil.getParameter(request, prefix + "htch_cvr_61", ""));
		setHtchCvr62(JSPUtil.getParameter(request, prefix + "htch_cvr_62", ""));
		setHtchCvr63(JSPUtil.getParameter(request, prefix + "htch_cvr_63", ""));
		setHtchCvr64(JSPUtil.getParameter(request, prefix + "htch_cvr_64", ""));
		setHtchCvr65(JSPUtil.getParameter(request, prefix + "htch_cvr_65", ""));
		setHtchCvr66(JSPUtil.getParameter(request, prefix + "htch_cvr_66", ""));
		setHtchCvr67(JSPUtil.getParameter(request, prefix + "htch_cvr_67", ""));
		setHtchCvr68(JSPUtil.getParameter(request, prefix + "htch_cvr_68", ""));
		setHtchCvr69(JSPUtil.getParameter(request, prefix + "htch_cvr_69", ""));
		setHtchCvr70(JSPUtil.getParameter(request, prefix + "htch_cvr_70", ""));
		setHtchCvr71(JSPUtil.getParameter(request, prefix + "htch_cvr_71", ""));
		setHtchCvr72(JSPUtil.getParameter(request, prefix + "htch_cvr_72", ""));
		setHtchCvr73(JSPUtil.getParameter(request, prefix + "htch_cvr_73", ""));
		setHtchCvr74(JSPUtil.getParameter(request, prefix + "htch_cvr_74", ""));
		setHtchCvr75(JSPUtil.getParameter(request, prefix + "htch_cvr_75", ""));
		setBayIdx(JSPUtil.getParameter(request, prefix + "bay_idx", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCntrId(JSPUtil.getParameter(request, prefix + "cntr_id", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setVvdPortGb(JSPUtil.getParameter(request, prefix + "vvd_port_gb", ""));
		setEtaFrDt(JSPUtil.getParameter(request, prefix + "eta_fr_dt", ""));
		setEtaToDt(JSPUtil.getParameter(request, prefix + "eta_to_dt", ""));
		setCntrBayIdx(JSPUtil.getParameter(request, prefix + "cntr_bay_idx", ""));
		setPortNm(JSPUtil.getParameter(request, prefix + "port_nm", ""));
		setPortColor(JSPUtil.getParameter(request, prefix + "port_color", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setOnBoardMsg(JSPUtil.getParameter(request, prefix + "on_board_msg", ""));
		setCallInd(JSPUtil.getParameter(request, prefix + "call_ind", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OpfStowageBayPlanListVO[]
	 */
	public OpfStowageBayPlanListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OpfStowageBayPlanListVO[]
	 */
	public OpfStowageBayPlanListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OpfStowageBayPlanListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] onTrNmF = (JSPUtil.getParameter(request, prefix	+ "on_tr_nm_f", length));
			String[] onTrNmB = (JSPUtil.getParameter(request, prefix	+ "on_tr_nm_b", length));
			String[] onRow0 = (JSPUtil.getParameter(request, prefix	+ "on_row_0", length));
			String[] onRow1 = (JSPUtil.getParameter(request, prefix	+ "on_row_1", length));
			String[] onRow2 = (JSPUtil.getParameter(request, prefix	+ "on_row_2", length));
			String[] onRow3 = (JSPUtil.getParameter(request, prefix	+ "on_row_3", length));
			String[] onRow4 = (JSPUtil.getParameter(request, prefix	+ "on_row_4", length));
			String[] onRow5 = (JSPUtil.getParameter(request, prefix	+ "on_row_5", length));
			String[] onRow6 = (JSPUtil.getParameter(request, prefix	+ "on_row_6", length));
			String[] onRow7 = (JSPUtil.getParameter(request, prefix	+ "on_row_7", length));
			String[] onRow8 = (JSPUtil.getParameter(request, prefix	+ "on_row_8", length));
			String[] onRow9 = (JSPUtil.getParameter(request, prefix	+ "on_row_9", length));
			String[] onRow10 = (JSPUtil.getParameter(request, prefix	+ "on_row_10", length));
			String[] onRow11 = (JSPUtil.getParameter(request, prefix	+ "on_row_11", length));
			String[] onRow12 = (JSPUtil.getParameter(request, prefix	+ "on_row_12", length));
			String[] onRow13 = (JSPUtil.getParameter(request, prefix	+ "on_row_13", length));
			String[] onRow14 = (JSPUtil.getParameter(request, prefix	+ "on_row_14", length));
			String[] onRow15 = (JSPUtil.getParameter(request, prefix	+ "on_row_15", length));
			String[] onRow16 = (JSPUtil.getParameter(request, prefix	+ "on_row_16", length));
			String[] onRow17 = (JSPUtil.getParameter(request, prefix	+ "on_row_17", length));
			String[] onRow18 = (JSPUtil.getParameter(request, prefix	+ "on_row_18", length));
			String[] underTrNmF = (JSPUtil.getParameter(request, prefix	+ "under_tr_nm_f", length));
			String[] underTrNmB = (JSPUtil.getParameter(request, prefix	+ "under_tr_nm_b", length));
			String[] underRow1 = (JSPUtil.getParameter(request, prefix	+ "under_row_1", length));
			String[] underRow0 = (JSPUtil.getParameter(request, prefix	+ "under_row_0", length));
			String[] underRow2 = (JSPUtil.getParameter(request, prefix	+ "under_row_2", length));
			String[] underRow3 = (JSPUtil.getParameter(request, prefix	+ "under_row_3", length));
			String[] underRow4 = (JSPUtil.getParameter(request, prefix	+ "under_row_4", length));
			String[] underRow5 = (JSPUtil.getParameter(request, prefix	+ "under_row_5", length));
			String[] underRow6 = (JSPUtil.getParameter(request, prefix	+ "under_row_6", length));
			String[] underRow7 = (JSPUtil.getParameter(request, prefix	+ "under_row_7", length));
			String[] underRow8 = (JSPUtil.getParameter(request, prefix	+ "under_row_8", length));
			String[] underRow9 = (JSPUtil.getParameter(request, prefix	+ "under_row_9", length));
			String[] underRow10 = (JSPUtil.getParameter(request, prefix	+ "under_row_10", length));
			String[] underRow11 = (JSPUtil.getParameter(request, prefix	+ "under_row_11", length));
			String[] underRow12 = (JSPUtil.getParameter(request, prefix	+ "under_row_12", length));
			String[] underRow13 = (JSPUtil.getParameter(request, prefix	+ "under_row_13", length));
			String[] underRow14 = (JSPUtil.getParameter(request, prefix	+ "under_row_14", length));
			String[] underRow15 = (JSPUtil.getParameter(request, prefix	+ "under_row_15", length));
			String[] underRow16 = (JSPUtil.getParameter(request, prefix	+ "under_row_16", length));
			String[] underRow17 = (JSPUtil.getParameter(request, prefix	+ "under_row_17", length));
			String[] underRow18 = (JSPUtil.getParameter(request, prefix	+ "under_row_18", length));
			String[] dhTp = (JSPUtil.getParameter(request, prefix	+ "dh_tp", length));
			String[] htchCvr0  = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_0", length));
			String[] htchCvr1  = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_1", length));
			String[] htchCvr2  = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_2", length));
			String[] htchCvr3  = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_3", length));
			String[] htchCvr4  = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_4", length));
			String[] htchCvr5  = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_5", length));
			String[] htchCvr6  = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_6", length));
			String[] htchCvr7  = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_7", length));
			String[] htchCvr8  = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_8", length));
			String[] htchCvr9  = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_9", length));
			String[] htchCvr10 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_10", length));
			String[] htchCvr11 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_11", length));
			String[] htchCvr12 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_12", length));
			String[] htchCvr13 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_13", length));
			String[] htchCvr14 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_14", length));
			String[] htchCvr15 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_15", length));
			String[] htchCvr16 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_16", length));
			String[] htchCvr17 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_17", length));
			String[] htchCvr18 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_18", length));
			String[] htchCvr19 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_19", length));
			String[] htchCvr20 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_20", length));
			String[] htchCvr21 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_21", length));
			String[] htchCvr22 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_22", length));
			String[] htchCvr23 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_23", length));
			String[] htchCvr24 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_24", length));
			String[] htchCvr25 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_25", length));
			String[] htchCvr26 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_26", length));
			String[] htchCvr27 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_27", length));
			String[] htchCvr28 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_28", length));
			String[] htchCvr29 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_29", length));
			String[] htchCvr30 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_30", length));
			String[] htchCvr31 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_31", length));
			String[] htchCvr32 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_32", length));
			String[] htchCvr33 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_33", length));
			String[] htchCvr34 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_34", length));
			String[] htchCvr35 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_35", length));
			String[] htchCvr36 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_36", length));
			String[] htchCvr37 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_37", length));
			String[] htchCvr38 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_38", length));
			String[] htchCvr39 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_39", length));
			String[] htchCvr40 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_40", length));
			String[] htchCvr41 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_41", length));
			String[] htchCvr42 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_42", length));
			String[] htchCvr43 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_43", length));
			String[] htchCvr44 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_44", length));
			String[] htchCvr45 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_45", length));
			String[] htchCvr46 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_46", length));
			String[] htchCvr47 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_47", length));
			String[] htchCvr48 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_48", length));
			String[] htchCvr49 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_49", length));
			String[] htchCvr50 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_50", length));
			String[] htchCvr51 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_51", length));
			String[] htchCvr52 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_52", length));
			String[] htchCvr53 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_53", length));
			String[] htchCvr54 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_54", length));
			String[] htchCvr55 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_55", length));
			String[] htchCvr56 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_56", length));
			String[] htchCvr57 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_57", length));
			String[] htchCvr58 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_58", length));
			String[] htchCvr59 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_59", length));
			String[] htchCvr60 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_60", length));
			String[] htchCvr61 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_61", length));
			String[] htchCvr62 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_62", length));
			String[] htchCvr63 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_63", length));
			String[] htchCvr64 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_64", length));
			String[] htchCvr65 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_65", length));
			String[] htchCvr66 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_66", length));
			String[] htchCvr67 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_67", length));
			String[] htchCvr68 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_68", length));
			String[] htchCvr69 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_69", length));
			String[] htchCvr70 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_70", length));
			String[] htchCvr71 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_71", length));
			String[] htchCvr72 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_72", length));
			String[] htchCvr73 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_73", length));
			String[] htchCvr74 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_74", length));
			String[] htchCvr75 = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_75", length));
			String[] bayIdx = (JSPUtil.getParameter(request, prefix	+ "bay_idx", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] cntrId = (JSPUtil.getParameter(request, prefix	+ "cntr_id", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] vvdPortGb = (JSPUtil.getParameter(request, prefix	+ "vvd_port_gb", length));
			String[] etaFrDt = (JSPUtil.getParameter(request, prefix	+ "eta_fr_dt", length));
			String[] etaToDt = (JSPUtil.getParameter(request, prefix	+ "eta_to_dt", length));
			String[] cntrBayIdx = (JSPUtil.getParameter(request, prefix	+ "cntr_bay_idx", length));
			String[] portNm = (JSPUtil.getParameter(request, prefix	+ "port_nm", length));
			String[] portColor = (JSPUtil.getParameter(request, prefix	+ "port_color", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] onBoardMsg = (JSPUtil.getParameter(request, prefix	+ "on_board_msg", length));
			String[] callInd = (JSPUtil.getParameter(request, prefix	+ "call_ind", length));
			
			for (int i = 0; i < length; i++) {
				model = new OpfStowageBayPlanListVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (onTrNmF[i] != null)
					model.setOnTrNmF(onTrNmF[i]);
				if (onTrNmB[i] != null)
					model.setOnTrNmB(onTrNmB[i]);
				if (onRow0[i] != null)
					model.setOnRow0(onRow0[i]);
				if (onRow1[i] != null)
					model.setOnRow1(onRow1[i]);
				if (onRow2[i] != null)
					model.setOnRow2(onRow2[i]);
				if (onRow3[i] != null)
					model.setOnRow3(onRow3[i]);
				if (onRow4[i] != null)
					model.setOnRow4(onRow4[i]);
				if (onRow5[i] != null)
					model.setOnRow5(onRow5[i]);
				if (onRow6[i] != null)
					model.setOnRow6(onRow6[i]);
				if (onRow7[i] != null)
					model.setOnRow7(onRow7[i]);
				if (onRow8[i] != null)
					model.setOnRow8(onRow8[i]);
				if (onRow9[i] != null)
					model.setOnRow9(onRow9[i]);
				if (onRow10[i] != null)
					model.setOnRow10(onRow10[i]);
				if (onRow11[i] != null)
					model.setOnRow11(onRow11[i]);
				if (onRow12[i] != null)
					model.setOnRow12(onRow12[i]);
				if (onRow13[i] != null)
					model.setOnRow13(onRow13[i]);
				if (onRow14[i] != null)
					model.setOnRow14(onRow14[i]);
				if (onRow15[i] != null)
					model.setOnRow15(onRow15[i]);
				if (onRow16[i] != null)
					model.setOnRow16(onRow16[i]);
				if (onRow17[i] != null)
					model.setOnRow17(onRow17[i]);
				if (onRow18[i] != null)
					model.setOnRow18(onRow18[i]);
				if (underTrNmF[i] != null)
					model.setUnderTrNmF(underTrNmF[i]);
				if (underTrNmB[i] != null)
					model.setUnderTrNmB(underTrNmB[i]);
				if (underRow0[i] != null)
					model.setUnderRow0(underRow0[i]);
				if (underRow1[i] != null)
					model.setUnderRow1(underRow1[i]);
				if (underRow2[i] != null)
					model.setUnderRow2(underRow2[i]);
				if (underRow3[i] != null)
					model.setUnderRow3(underRow3[i]);
				if (underRow4[i] != null)
					model.setUnderRow4(underRow4[i]);
				if (underRow5[i] != null)
					model.setUnderRow5(underRow5[i]);
				if (underRow6[i] != null)
					model.setUnderRow6(underRow6[i]);
				if (underRow7[i] != null)
					model.setUnderRow7(underRow7[i]);
				if (underRow8[i] != null)
					model.setUnderRow8(underRow8[i]);
				if (underRow9[i] != null)
					model.setUnderRow9(underRow9[i]);
				if (underRow10[i] != null)
					model.setUnderRow10(underRow10[i]);
				if (underRow11[i] != null)
					model.setUnderRow11(underRow11[i]);
				if (underRow12[i] != null)
					model.setUnderRow12(underRow12[i]);
				if (underRow13[i] != null)
					model.setUnderRow13(underRow13[i]);
				if (underRow14[i] != null)
					model.setUnderRow14(underRow14[i]);
				if (underRow15[i] != null)
					model.setUnderRow15(underRow15[i]);
				if (underRow16[i] != null)
					model.setUnderRow16(underRow16[i]);
				if (underRow17[i] != null)
					model.setUnderRow17(underRow17[i]);
				if (underRow18[i] != null)
					model.setUnderRow18(underRow18[i]);
				if (dhTp[i] != null)
					model.setDhTp(dhTp[i]);
				if (htchCvr0[i] != null)
					model.setHtchCvr0(htchCvr0[i]);
				if (htchCvr1[i] != null)
					model.setHtchCvr1(htchCvr1[i]);
				if (htchCvr2[i] != null)
					model.setHtchCvr2(htchCvr2[i]);
				if (htchCvr3[i] != null)
					model.setHtchCvr3(htchCvr3[i]);
				if (htchCvr4[i] != null)
					model.setHtchCvr4(htchCvr4[i]);
				if (htchCvr5[i] != null)
					model.setHtchCvr5(htchCvr5[i]);
				if (htchCvr6[i] != null)
					model.setHtchCvr6(htchCvr6[i]);
				if (htchCvr7[i] != null)
					model.setHtchCvr7(htchCvr7[i]);
				if (htchCvr8[i] != null)
					model.setHtchCvr8(htchCvr8[i]);
				if (htchCvr9[i] != null)
					model.setHtchCvr9(htchCvr9[i]);
				if (htchCvr10[i] != null)
					model.setHtchCvr10(htchCvr10[i]);
				if (htchCvr11[i] != null)
					model.setHtchCvr11(htchCvr11[i]);
				if (htchCvr12[i] != null)
					model.setHtchCvr12(htchCvr12[i]);
				if (htchCvr13[i] != null)
					model.setHtchCvr13(htchCvr13[i]);
				if (htchCvr14[i] != null)
					model.setHtchCvr14(htchCvr14[i]);
				if (htchCvr15[i] != null)
					model.setHtchCvr15(htchCvr15[i]);
				if (htchCvr16[i] != null)
					model.setHtchCvr16(htchCvr16[i]);
				if (htchCvr17[i] != null)
					model.setHtchCvr17(htchCvr17[i]);
				if (htchCvr18[i] != null)
					model.setHtchCvr18(htchCvr18[i]);
				if (htchCvr19[i] != null)
					model.setHtchCvr19(htchCvr19[i]);
				if (htchCvr20[i] != null)
					model.setHtchCvr20(htchCvr20[i]);
				if (htchCvr21[i] != null)
					model.setHtchCvr21(htchCvr21[i]);
				if (htchCvr22[i] != null)
					model.setHtchCvr22(htchCvr22[i]);
				if (htchCvr23[i] != null)
					model.setHtchCvr23(htchCvr23[i]);
				if (htchCvr24[i] != null)
					model.setHtchCvr24(htchCvr24[i]);
				if (htchCvr25[i] != null)
					model.setHtchCvr25(htchCvr25[i]);
				if (htchCvr26[i] != null)
					model.setHtchCvr26(htchCvr26[i]);
				if (htchCvr27[i] != null)
					model.setHtchCvr27(htchCvr27[i]);
				if (htchCvr28[i] != null)
					model.setHtchCvr28(htchCvr28[i]);
				if (htchCvr29[i] != null)
					model.setHtchCvr29(htchCvr29[i]);
				if (htchCvr30[i] != null)
					model.setHtchCvr30(htchCvr30[i]);
				if (htchCvr31[i] != null)
					model.setHtchCvr31(htchCvr31[i]);
				if (htchCvr32[i] != null)
					model.setHtchCvr32(htchCvr32[i]);
				if (htchCvr33[i] != null)
					model.setHtchCvr33(htchCvr33[i]);
				if (htchCvr34[i] != null)
					model.setHtchCvr34(htchCvr34[i]);
				if (htchCvr35[i] != null)
					model.setHtchCvr35(htchCvr35[i]);
				if (htchCvr36[i] != null)
					model.setHtchCvr36(htchCvr36[i]);
				if (htchCvr37[i] != null)
					model.setHtchCvr37(htchCvr37[i]);
				if (htchCvr38[i] != null)
					model.setHtchCvr38(htchCvr38[i]);
				if (htchCvr39[i] != null)
					model.setHtchCvr39(htchCvr39[i]);
				if (htchCvr40[i] != null)
					model.setHtchCvr40(htchCvr40[i]);
				if (htchCvr41[i] != null)
					model.setHtchCvr41(htchCvr41[i]);
				if (htchCvr42[i] != null)
					model.setHtchCvr42(htchCvr42[i]);
				if (htchCvr43[i] != null)
					model.setHtchCvr43(htchCvr43[i]);
				if (htchCvr44[i] != null)
					model.setHtchCvr44(htchCvr44[i]);
				if (htchCvr45[i] != null)
					model.setHtchCvr45(htchCvr45[i]);
				if (htchCvr46[i] != null)
					model.setHtchCvr46(htchCvr46[i]);
				if (htchCvr47[i] != null)
					model.setHtchCvr47(htchCvr47[i]);
				if (htchCvr48[i] != null)
					model.setHtchCvr48(htchCvr48[i]);
				if (htchCvr49[i] != null)
					model.setHtchCvr49(htchCvr49[i]);
				if (htchCvr50[i] != null)
					model.setHtchCvr50(htchCvr50[i]);
				if (htchCvr51[i] != null)
					model.setHtchCvr51(htchCvr51[i]);
				if (htchCvr52[i] != null)
					model.setHtchCvr52(htchCvr52[i]);
				if (htchCvr53[i] != null)
					model.setHtchCvr53(htchCvr53[i]);
				if (htchCvr54[i] != null)
					model.setHtchCvr54(htchCvr54[i]);
				if (htchCvr55[i] != null)
					model.setHtchCvr55(htchCvr55[i]);
				if (htchCvr56[i] != null)
					model.setHtchCvr56(htchCvr56[i]);
				if (htchCvr57[i] != null)
					model.setHtchCvr57(htchCvr57[i]);
				if (htchCvr58[i] != null)
					model.setHtchCvr58(htchCvr58[i]);
				if (htchCvr59[i] != null)
					model.setHtchCvr59(htchCvr59[i]);
				if (htchCvr60[i] != null)
					model.setHtchCvr60(htchCvr60[i]);
				if (htchCvr61[i] != null)
					model.setHtchCvr61(htchCvr61[i]);
				if (htchCvr62[i] != null)
					model.setHtchCvr62(htchCvr62[i]);
				if (htchCvr63[i] != null)
					model.setHtchCvr63(htchCvr63[i]);
				if (htchCvr64[i] != null)
					model.setHtchCvr64(htchCvr64[i]);
				if (htchCvr65[i] != null)
					model.setHtchCvr65(htchCvr65[i]);
				if (htchCvr66[i] != null)
					model.setHtchCvr66(htchCvr66[i]);
				if (htchCvr67[i] != null)
					model.setHtchCvr67(htchCvr67[i]);
				if (htchCvr68[i] != null)
					model.setHtchCvr68(htchCvr68[i]);
				if (htchCvr69[i] != null)
					model.setHtchCvr69(htchCvr69[i]);
				if (htchCvr70[i] != null)
					model.setHtchCvr70(htchCvr70[i]);
				if (htchCvr71[i] != null)
					model.setHtchCvr71(htchCvr71[i]);
				if (htchCvr72[i] != null)
					model.setHtchCvr72(htchCvr72[i]);
				if (htchCvr73[i] != null)
					model.setHtchCvr73(htchCvr73[i]);
				if (htchCvr74[i] != null)
					model.setHtchCvr74(htchCvr74[i]);
				if (htchCvr75[i] != null)
					model.setHtchCvr75(htchCvr75[i]);
				if (bayIdx[i] != null)
					model.setBayIdx(bayIdx[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (cntrId[i] != null)
					model.setCntrId(cntrId[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (vvdPortGb[i] != null)
					model.setVvdPortGb(vvdPortGb[i]);
				if (etaFrDt[i] != null)
					model.setEtaFrDt(etaFrDt[i]);
				if (etaToDt[i] != null)
					model.setEtaToDt(etaToDt[i]);
				if (cntrBayIdx[i] != null)
					model.setCntrBayIdx(cntrBayIdx[i]);
				if (portNm[i] != null)
					model.setPortNm(portNm[i]);
				if (portColor[i] != null)
					model.setPortColor(portColor[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (onBoardMsg[i] != null)
					model.setOnBoardMsg(onBoardMsg[i]);
				if (callInd[i] != null)
					model.setCallInd(callInd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOpfStowageBayPlanListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OpfStowageBayPlanListVO[]
	 */
	public OpfStowageBayPlanListVO[] getOpfStowageBayPlanListVOs(){
		OpfStowageBayPlanListVO[] vos = (OpfStowageBayPlanListVO[])models.toArray(new OpfStowageBayPlanListVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onTrNmF = this.onTrNmF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onTrNmB = this.onTrNmB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onRow0 = this.onRow0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onRow1 = this.onRow1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onRow2 = this.onRow2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onRow3 = this.onRow3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onRow4 = this.onRow4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onRow5 = this.onRow5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onRow6 = this.onRow6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onRow7 = this.onRow7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onRow8 = this.onRow8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onRow9 = this.onRow9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onRow10 = this.onRow10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onRow11 = this.onRow11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onRow12 = this.onRow12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onRow13 = this.onRow13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onRow14 = this.onRow14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onRow15 = this.onRow15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onRow16 = this.onRow16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onRow17 = this.onRow17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onRow18 = this.onRow18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.underTrNmF = this.underTrNmF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.underTrNmB = this.underTrNmB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.underRow0 = this.underRow0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.underRow1 = this.underRow1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.underRow2 = this.underRow2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.underRow3 = this.underRow3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.underRow4 = this.underRow4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.underRow5 = this.underRow5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.underRow6 = this.underRow6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.underRow7 = this.underRow7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.underRow8 = this.underRow8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.underRow9 = this.underRow9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.underRow10 = this.underRow10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.underRow11 = this.underRow11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.underRow12 = this.underRow12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.underRow13 = this.underRow13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.underRow14 = this.underRow14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.underRow15 = this.underRow15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.underRow16 = this.underRow16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.underRow17 = this.underRow17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.underRow18 = this.underRow18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dhTp = this.dhTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr0 = this.htchCvr0.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr1 = this.htchCvr1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr2 = this.htchCvr2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr3 = this.htchCvr3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr4 = this.htchCvr4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr5 = this.htchCvr5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr6 = this.htchCvr6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr7 = this.htchCvr7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr8 = this.htchCvr8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr9 = this.htchCvr9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr10 = this.htchCvr10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr11 = this.htchCvr11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr12 = this.htchCvr12.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr13 = this.htchCvr13.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr14 = this.htchCvr14.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr15 = this.htchCvr15.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr16 = this.htchCvr16.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr17 = this.htchCvr17.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr18 = this.htchCvr18.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr19 = this.htchCvr19.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr20 = this.htchCvr20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr21 = this.htchCvr21.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr22 = this.htchCvr22.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr23 = this.htchCvr23.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr24 = this.htchCvr24.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr25 = this.htchCvr25.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr26 = this.htchCvr26.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr27 = this.htchCvr27.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr28 = this.htchCvr28.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr29 = this.htchCvr29.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr30 = this.htchCvr30.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr31 = this.htchCvr31.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr32 = this.htchCvr32.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr33 = this.htchCvr33.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr34 = this.htchCvr34.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr35 = this.htchCvr35.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr36 = this.htchCvr36.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr37 = this.htchCvr37.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr38 = this.htchCvr38.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr39 = this.htchCvr39.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr40 = this.htchCvr40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr41 = this.htchCvr41.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr42 = this.htchCvr42.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr43 = this.htchCvr43.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr44 = this.htchCvr44.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr45 = this.htchCvr45.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr46 = this.htchCvr46.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr47 = this.htchCvr47.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr48 = this.htchCvr48.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr49 = this.htchCvr49.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr50 = this.htchCvr50.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr51 = this.htchCvr51.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr52 = this.htchCvr52.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr53 = this.htchCvr53.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr54 = this.htchCvr54.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr55 = this.htchCvr55.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr56 = this.htchCvr56.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr57 = this.htchCvr57.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr58 = this.htchCvr58.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr59 = this.htchCvr59.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr60 = this.htchCvr60.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr61 = this.htchCvr61.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr62 = this.htchCvr62.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr63 = this.htchCvr63.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr64 = this.htchCvr64.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr65 = this.htchCvr65.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr66 = this.htchCvr66.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr67 = this.htchCvr67.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr68 = this.htchCvr68.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr69 = this.htchCvr69.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr70 = this.htchCvr70.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr71 = this.htchCvr71.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr72 = this.htchCvr72.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr73 = this.htchCvr73.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr74 = this.htchCvr74.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvr75 = this.htchCvr75.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bayIdx = this.bayIdx.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrId = this.cntrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPortGb = this.vvdPortGb.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaFrDt = this.etaFrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaToDt = this.etaToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrBayIdx = this.cntrBayIdx.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portNm = this.portNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portColor = this.portColor.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onBoardMsg = this.onBoardMsg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callInd = this.callInd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
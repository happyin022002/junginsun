/*=========================================================
*Copyright(c) 2015 CyberLogitec 
*@FileName : JapanManifestListEmptyBlInfoVO.java
*@FileTitle : JapanManifestListEmptyBlInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.17  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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

public class JapanManifestListEmptyBlInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<JapanManifestListEmptyBlInfoVO> models = new ArrayList<JapanManifestListEmptyBlInfoVO>();
	
	/* Column Info */
	private String cneeCd = null;
	/* Column Info */
	private String ntfy1Addr1 = null;
	/* Column Info */
	private String ntfy1Addr2 = null;
	/* Column Info */
	private String shprNm1 = null;
	/* Column Info */
	private String ntfy1Addr3 = null;
	/* Column Info */
	private String ntfy1Addr4 = null;
	/* Column Info */
	private String shprNm2 = null;
	/* Column Info */
	private String ntfy1CntCd = null;
	/* Column Info */
	private String ntfy2Addr1 = null;
	/* Column Info */
	private String ntfy2PhnNo = null;
	/* Column Info */
	private String ntfy2Addr2 = null;
	/* Column Info */
	private String ntfy2Addr3 = null;
	/* Column Info */
	private String ntfy2Addr4 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cneeCntCd = null;
	/* Column Info */
	private String data51 = null;
	/* Column Info */
	private String data52 = null;
	/* Column Info */
	private String data50 = null;
	/* Column Info */
	private String data55 = null;
	/* Column Info */
	private String data56 = null;
	/* Column Info */
	private String data53 = null;
	/* Column Info */
	private String data54 = null;
	/* Column Info */
	private String data59 = null;
	/* Column Info */
	private String data57 = null;
	/* Column Info */
	private String shprCd = null;
	/* Column Info */
	private String data58 = null;
	/* Column Info */
	private String data70 = null;
	/* Column Info */
	private String data72 = null;
	/* Column Info */
	private String data71 = null;
	/* Column Info */
	private String data74 = null;
	/* Column Info */
	private String data73 = null;
	/* Column Info */
	private String data76 = null;
	/* Column Info */
	private String shprCntCd = null;
	/* Column Info */
	private String data75 = null;
	/* Column Info */
	private String data78 = null;
	/* Column Info */
	private String ntfy1Nm2 = null;
	/* Column Info */
	private String data77 = null;
	/* Column Info */
	private String ntfy1Nm1 = null;
	/* Column Info */
	private String data79 = null;
	/* Column Info */
	private String ntfy2Nm2 = null;
	/* Column Info */
	private String ntfy2Cd = null;
	/* Column Info */
	private String ntfy2Nm1 = null;
	/* Column Info */
	private String ntfy2CntCd = null;
	/* Column Info */
	private String data60 = null;
	/* Column Info */
	private String data61 = null;
	/* Column Info */
	private String data62 = null;
	/* Column Info */
	private String data63 = null;
	/* Column Info */
	private String data64 = null;
	/* Column Info */
	private String inVvdCd = null;
	/* Column Info */
	private String data65 = null;
	/* Column Info */
	private String data66 = null;
	/* Column Info */
	private String data67 = null;
	/* Column Info */
	private String data68 = null;
	/* Column Info */
	private String data69 = null;
	/* Column Info */
	private String jpTmlVslNo = null;
	/* Column Info */
	private String cyOprCd = null;
	/* Column Info */
	private String inCallSgnNo = null;
	/* Column Info */
	private String shprPostId = null;
	/* Column Info */
	private String ntfy2PostId = null;
	/* Column Info */
	private String cneePhnNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cneePostId = null;
	/* Column Info */
	private String ntfy1PostId = null;
	/* Column Info */
	private String ntfy1Cd = null;
	/* Column Info */
	private String cneeAddr4 = null;
	/* Column Info */
	private String shprPhnNo = null;
	/* Column Info */
	private String cneeNm1 = null;
	/* Column Info */
	private String cneeNm2 = null;
	/* Column Info */
	private String data06 = null;
	/* Column Info */
	private String ntfy1PhnNo = null;
	/* Column Info */
	private String data07 = null;
	/* Column Info */
	private String cneeAddr1 = null;
	/* Column Info */
	private String cneeAddr2 = null;
	/* Column Info */
	private String cneeAddr3 = null;
	/* Column Info */
	private String data03 = null;
	/* Column Info */
	private String data02 = null;
	/* Column Info */
	private String data05 = null;
	/* Column Info */
	private String data04 = null;
	/* Column Info */
	private String data01 = null;
	/* Column Info */
	private String shprAddr2 = null;
	/* Column Info */
	private String shprAddr3 = null;
	/* Column Info */
	private String data48 = null;
	/* Column Info */
	private String data49 = null;
	/* Column Info */
	private String shprAddr1 = null;
	/* Column Info */
	private String shprAddr4 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public JapanManifestListEmptyBlInfoVO() {}

	public JapanManifestListEmptyBlInfoVO(String ibflag, String pagerows, String inCallSgnNo, String inVvdCd, String jpTmlVslNo, String cyOprCd, String data01, String data02, String data03, String data04, String data05, String data06, String data07, String shprCd, String shprNm1, String shprNm2, String shprAddr1, String shprAddr2, String shprAddr3, String shprAddr4, String shprPostId, String shprCntCd, String shprPhnNo, String cneeCd, String cneeNm1, String cneeNm2, String cneeAddr1, String cneeAddr2, String cneeAddr3, String cneeAddr4, String cneePostId, String cneeCntCd, String cneePhnNo, String ntfy1Cd, String ntfy1Nm1, String ntfy1Nm2, String ntfy1Addr1, String ntfy1Addr2, String ntfy1Addr3, String ntfy1Addr4, String ntfy1PostId, String ntfy1CntCd, String ntfy1PhnNo, String ntfy2Cd, String ntfy2Nm1, String ntfy2Nm2, String ntfy2Addr1, String ntfy2Addr2, String ntfy2Addr3, String ntfy2Addr4, String ntfy2PostId, String ntfy2CntCd, String ntfy2PhnNo, String data48, String data49, String data50, String data51, String data52, String data53, String data54, String data55, String data56, String data57, String data58, String data59, String data60, String data61, String data62, String data63, String data64, String data65, String data66, String data67, String data68, String data69, String data70, String data71, String data72, String data73, String data74, String data75, String data76, String data77, String data78, String data79) {
		this.cneeCd = cneeCd;
		this.ntfy1Addr1 = ntfy1Addr1;
		this.ntfy1Addr2 = ntfy1Addr2;
		this.shprNm1 = shprNm1;
		this.ntfy1Addr3 = ntfy1Addr3;
		this.ntfy1Addr4 = ntfy1Addr4;
		this.shprNm2 = shprNm2;
		this.ntfy1CntCd = ntfy1CntCd;
		this.ntfy2Addr1 = ntfy2Addr1;
		this.ntfy2PhnNo = ntfy2PhnNo;
		this.ntfy2Addr2 = ntfy2Addr2;
		this.ntfy2Addr3 = ntfy2Addr3;
		this.ntfy2Addr4 = ntfy2Addr4;
		this.pagerows = pagerows;
		this.cneeCntCd = cneeCntCd;
		this.data51 = data51;
		this.data52 = data52;
		this.data50 = data50;
		this.data55 = data55;
		this.data56 = data56;
		this.data53 = data53;
		this.data54 = data54;
		this.data59 = data59;
		this.data57 = data57;
		this.shprCd = shprCd;
		this.data58 = data58;
		this.data70 = data70;
		this.data72 = data72;
		this.data71 = data71;
		this.data74 = data74;
		this.data73 = data73;
		this.data76 = data76;
		this.shprCntCd = shprCntCd;
		this.data75 = data75;
		this.data78 = data78;
		this.ntfy1Nm2 = ntfy1Nm2;
		this.data77 = data77;
		this.ntfy1Nm1 = ntfy1Nm1;
		this.data79 = data79;
		this.ntfy2Nm2 = ntfy2Nm2;
		this.ntfy2Cd = ntfy2Cd;
		this.ntfy2Nm1 = ntfy2Nm1;
		this.ntfy2CntCd = ntfy2CntCd;
		this.data60 = data60;
		this.data61 = data61;
		this.data62 = data62;
		this.data63 = data63;
		this.data64 = data64;
		this.inVvdCd = inVvdCd;
		this.data65 = data65;
		this.data66 = data66;
		this.data67 = data67;
		this.data68 = data68;
		this.data69 = data69;
		this.jpTmlVslNo = jpTmlVslNo;
		this.cyOprCd = cyOprCd;
		this.inCallSgnNo = inCallSgnNo;
		this.shprPostId = shprPostId;
		this.ntfy2PostId = ntfy2PostId;
		this.cneePhnNo = cneePhnNo;
		this.ibflag = ibflag;
		this.cneePostId = cneePostId;
		this.ntfy1PostId = ntfy1PostId;
		this.ntfy1Cd = ntfy1Cd;
		this.cneeAddr4 = cneeAddr4;
		this.shprPhnNo = shprPhnNo;
		this.cneeNm1 = cneeNm1;
		this.cneeNm2 = cneeNm2;
		this.data06 = data06;
		this.ntfy1PhnNo = ntfy1PhnNo;
		this.data07 = data07;
		this.cneeAddr1 = cneeAddr1;
		this.cneeAddr2 = cneeAddr2;
		this.cneeAddr3 = cneeAddr3;
		this.data03 = data03;
		this.data02 = data02;
		this.data05 = data05;
		this.data04 = data04;
		this.data01 = data01;
		this.shprAddr2 = shprAddr2;
		this.shprAddr3 = shprAddr3;
		this.data48 = data48;
		this.data49 = data49;
		this.shprAddr1 = shprAddr1;
		this.shprAddr4 = shprAddr4;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cnee_cd", getCneeCd());
		this.hashColumns.put("ntfy1_addr1", getNtfy1Addr1());
		this.hashColumns.put("ntfy1_addr2", getNtfy1Addr2());
		this.hashColumns.put("shpr_nm1", getShprNm1());
		this.hashColumns.put("ntfy1_addr3", getNtfy1Addr3());
		this.hashColumns.put("ntfy1_addr4", getNtfy1Addr4());
		this.hashColumns.put("shpr_nm2", getShprNm2());
		this.hashColumns.put("ntfy1_cnt_cd", getNtfy1CntCd());
		this.hashColumns.put("ntfy2_addr1", getNtfy2Addr1());
		this.hashColumns.put("ntfy2_phn_no", getNtfy2PhnNo());
		this.hashColumns.put("ntfy2_addr2", getNtfy2Addr2());
		this.hashColumns.put("ntfy2_addr3", getNtfy2Addr3());
		this.hashColumns.put("ntfy2_addr4", getNtfy2Addr4());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnee_cnt_cd", getCneeCntCd());
		this.hashColumns.put("data51", getData51());
		this.hashColumns.put("data52", getData52());
		this.hashColumns.put("data50", getData50());
		this.hashColumns.put("data55", getData55());
		this.hashColumns.put("data56", getData56());
		this.hashColumns.put("data53", getData53());
		this.hashColumns.put("data54", getData54());
		this.hashColumns.put("data59", getData59());
		this.hashColumns.put("data57", getData57());
		this.hashColumns.put("shpr_cd", getShprCd());
		this.hashColumns.put("data58", getData58());
		this.hashColumns.put("data70", getData70());
		this.hashColumns.put("data72", getData72());
		this.hashColumns.put("data71", getData71());
		this.hashColumns.put("data74", getData74());
		this.hashColumns.put("data73", getData73());
		this.hashColumns.put("data76", getData76());
		this.hashColumns.put("shpr_cnt_cd", getShprCntCd());
		this.hashColumns.put("data75", getData75());
		this.hashColumns.put("data78", getData78());
		this.hashColumns.put("ntfy1_nm2", getNtfy1Nm2());
		this.hashColumns.put("data77", getData77());
		this.hashColumns.put("ntfy1_nm1", getNtfy1Nm1());
		this.hashColumns.put("data79", getData79());
		this.hashColumns.put("ntfy2_nm2", getNtfy2Nm2());
		this.hashColumns.put("ntfy2_cd", getNtfy2Cd());
		this.hashColumns.put("ntfy2_nm1", getNtfy2Nm1());
		this.hashColumns.put("ntfy2_cnt_cd", getNtfy2CntCd());
		this.hashColumns.put("data60", getData60());
		this.hashColumns.put("data61", getData61());
		this.hashColumns.put("data62", getData62());
		this.hashColumns.put("data63", getData63());
		this.hashColumns.put("data64", getData64());
		this.hashColumns.put("in_vvd_cd", getInVvdCd());
		this.hashColumns.put("data65", getData65());
		this.hashColumns.put("data66", getData66());
		this.hashColumns.put("data67", getData67());
		this.hashColumns.put("data68", getData68());
		this.hashColumns.put("data69", getData69());
		this.hashColumns.put("jp_tml_vsl_no", getJpTmlVslNo());
		this.hashColumns.put("cy_opr_cd", getCyOprCd());
		this.hashColumns.put("in_call_sgn_no", getInCallSgnNo());
		this.hashColumns.put("shpr_post_id", getShprPostId());
		this.hashColumns.put("ntfy2_post_id", getNtfy2PostId());
		this.hashColumns.put("cnee_phn_no", getCneePhnNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnee_post_id", getCneePostId());
		this.hashColumns.put("ntfy1_post_id", getNtfy1PostId());
		this.hashColumns.put("ntfy1_cd", getNtfy1Cd());
		this.hashColumns.put("cnee_addr4", getCneeAddr4());
		this.hashColumns.put("shpr_phn_no", getShprPhnNo());
		this.hashColumns.put("cnee_nm1", getCneeNm1());
		this.hashColumns.put("cnee_nm2", getCneeNm2());
		this.hashColumns.put("data06", getData06());
		this.hashColumns.put("ntfy1_phn_no", getNtfy1PhnNo());
		this.hashColumns.put("data07", getData07());
		this.hashColumns.put("cnee_addr1", getCneeAddr1());
		this.hashColumns.put("cnee_addr2", getCneeAddr2());
		this.hashColumns.put("cnee_addr3", getCneeAddr3());
		this.hashColumns.put("data03", getData03());
		this.hashColumns.put("data02", getData02());
		this.hashColumns.put("data05", getData05());
		this.hashColumns.put("data04", getData04());
		this.hashColumns.put("data01", getData01());
		this.hashColumns.put("shpr_addr2", getShprAddr2());
		this.hashColumns.put("shpr_addr3", getShprAddr3());
		this.hashColumns.put("data48", getData48());
		this.hashColumns.put("data49", getData49());
		this.hashColumns.put("shpr_addr1", getShprAddr1());
		this.hashColumns.put("shpr_addr4", getShprAddr4());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cnee_cd", "cneeCd");
		this.hashFields.put("ntfy1_addr1", "ntfy1Addr1");
		this.hashFields.put("ntfy1_addr2", "ntfy1Addr2");
		this.hashFields.put("shpr_nm1", "shprNm1");
		this.hashFields.put("ntfy1_addr3", "ntfy1Addr3");
		this.hashFields.put("ntfy1_addr4", "ntfy1Addr4");
		this.hashFields.put("shpr_nm2", "shprNm2");
		this.hashFields.put("ntfy1_cnt_cd", "ntfy1CntCd");
		this.hashFields.put("ntfy2_addr1", "ntfy2Addr1");
		this.hashFields.put("ntfy2_phn_no", "ntfy2PhnNo");
		this.hashFields.put("ntfy2_addr2", "ntfy2Addr2");
		this.hashFields.put("ntfy2_addr3", "ntfy2Addr3");
		this.hashFields.put("ntfy2_addr4", "ntfy2Addr4");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnee_cnt_cd", "cneeCntCd");
		this.hashFields.put("data51", "data51");
		this.hashFields.put("data52", "data52");
		this.hashFields.put("data50", "data50");
		this.hashFields.put("data55", "data55");
		this.hashFields.put("data56", "data56");
		this.hashFields.put("data53", "data53");
		this.hashFields.put("data54", "data54");
		this.hashFields.put("data59", "data59");
		this.hashFields.put("data57", "data57");
		this.hashFields.put("shpr_cd", "shprCd");
		this.hashFields.put("data58", "data58");
		this.hashFields.put("data70", "data70");
		this.hashFields.put("data72", "data72");
		this.hashFields.put("data71", "data71");
		this.hashFields.put("data74", "data74");
		this.hashFields.put("data73", "data73");
		this.hashFields.put("data76", "data76");
		this.hashFields.put("shpr_cnt_cd", "shprCntCd");
		this.hashFields.put("data75", "data75");
		this.hashFields.put("data78", "data78");
		this.hashFields.put("ntfy1_nm2", "ntfy1Nm2");
		this.hashFields.put("data77", "data77");
		this.hashFields.put("ntfy1_nm1", "ntfy1Nm1");
		this.hashFields.put("data79", "data79");
		this.hashFields.put("ntfy2_nm2", "ntfy2Nm2");
		this.hashFields.put("ntfy2_cd", "ntfy2Cd");
		this.hashFields.put("ntfy2_nm1", "ntfy2Nm1");
		this.hashFields.put("ntfy2_cnt_cd", "ntfy2CntCd");
		this.hashFields.put("data60", "data60");
		this.hashFields.put("data61", "data61");
		this.hashFields.put("data62", "data62");
		this.hashFields.put("data63", "data63");
		this.hashFields.put("data64", "data64");
		this.hashFields.put("in_vvd_cd", "inVvdCd");
		this.hashFields.put("data65", "data65");
		this.hashFields.put("data66", "data66");
		this.hashFields.put("data67", "data67");
		this.hashFields.put("data68", "data68");
		this.hashFields.put("data69", "data69");
		this.hashFields.put("jp_tml_vsl_no", "jpTmlVslNo");
		this.hashFields.put("cy_opr_cd", "cyOprCd");
		this.hashFields.put("in_call_sgn_no", "inCallSgnNo");
		this.hashFields.put("shpr_post_id", "shprPostId");
		this.hashFields.put("ntfy2_post_id", "ntfy2PostId");
		this.hashFields.put("cnee_phn_no", "cneePhnNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnee_post_id", "cneePostId");
		this.hashFields.put("ntfy1_post_id", "ntfy1PostId");
		this.hashFields.put("ntfy1_cd", "ntfy1Cd");
		this.hashFields.put("cnee_addr4", "cneeAddr4");
		this.hashFields.put("shpr_phn_no", "shprPhnNo");
		this.hashFields.put("cnee_nm1", "cneeNm1");
		this.hashFields.put("cnee_nm2", "cneeNm2");
		this.hashFields.put("data06", "data06");
		this.hashFields.put("ntfy1_phn_no", "ntfy1PhnNo");
		this.hashFields.put("data07", "data07");
		this.hashFields.put("cnee_addr1", "cneeAddr1");
		this.hashFields.put("cnee_addr2", "cneeAddr2");
		this.hashFields.put("cnee_addr3", "cneeAddr3");
		this.hashFields.put("data03", "data03");
		this.hashFields.put("data02", "data02");
		this.hashFields.put("data05", "data05");
		this.hashFields.put("data04", "data04");
		this.hashFields.put("data01", "data01");
		this.hashFields.put("shpr_addr2", "shprAddr2");
		this.hashFields.put("shpr_addr3", "shprAddr3");
		this.hashFields.put("data48", "data48");
		this.hashFields.put("data49", "data49");
		this.hashFields.put("shpr_addr1", "shprAddr1");
		this.hashFields.put("shpr_addr4", "shprAddr4");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cneeCd
	 */
	public String getCneeCd() {
		return this.cneeCd;
	}
	
	/**
	 * Column Info
	 * @return ntfy1Addr1
	 */
	public String getNtfy1Addr1() {
		return this.ntfy1Addr1;
	}
	
	/**
	 * Column Info
	 * @return ntfy1Addr2
	 */
	public String getNtfy1Addr2() {
		return this.ntfy1Addr2;
	}
	
	/**
	 * Column Info
	 * @return shprNm1
	 */
	public String getShprNm1() {
		return this.shprNm1;
	}
	
	/**
	 * Column Info
	 * @return ntfy1Addr3
	 */
	public String getNtfy1Addr3() {
		return this.ntfy1Addr3;
	}
	
	/**
	 * Column Info
	 * @return ntfy1Addr4
	 */
	public String getNtfy1Addr4() {
		return this.ntfy1Addr4;
	}
	
	/**
	 * Column Info
	 * @return shprNm2
	 */
	public String getShprNm2() {
		return this.shprNm2;
	}
	
	/**
	 * Column Info
	 * @return ntfy1CntCd
	 */
	public String getNtfy1CntCd() {
		return this.ntfy1CntCd;
	}
	
	/**
	 * Column Info
	 * @return ntfy2Addr1
	 */
	public String getNtfy2Addr1() {
		return this.ntfy2Addr1;
	}
	
	/**
	 * Column Info
	 * @return ntfy2PhnNo
	 */
	public String getNtfy2PhnNo() {
		return this.ntfy2PhnNo;
	}
	
	/**
	 * Column Info
	 * @return ntfy2Addr2
	 */
	public String getNtfy2Addr2() {
		return this.ntfy2Addr2;
	}
	
	/**
	 * Column Info
	 * @return ntfy2Addr3
	 */
	public String getNtfy2Addr3() {
		return this.ntfy2Addr3;
	}
	
	/**
	 * Column Info
	 * @return ntfy2Addr4
	 */
	public String getNtfy2Addr4() {
		return this.ntfy2Addr4;
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
	 * @return cneeCntCd
	 */
	public String getCneeCntCd() {
		return this.cneeCntCd;
	}
	
	/**
	 * Column Info
	 * @return data51
	 */
	public String getData51() {
		return this.data51;
	}
	
	/**
	 * Column Info
	 * @return data52
	 */
	public String getData52() {
		return this.data52;
	}
	
	/**
	 * Column Info
	 * @return data50
	 */
	public String getData50() {
		return this.data50;
	}
	
	/**
	 * Column Info
	 * @return data55
	 */
	public String getData55() {
		return this.data55;
	}
	
	/**
	 * Column Info
	 * @return data56
	 */
	public String getData56() {
		return this.data56;
	}
	
	/**
	 * Column Info
	 * @return data53
	 */
	public String getData53() {
		return this.data53;
	}
	
	/**
	 * Column Info
	 * @return data54
	 */
	public String getData54() {
		return this.data54;
	}
	
	/**
	 * Column Info
	 * @return data59
	 */
	public String getData59() {
		return this.data59;
	}
	
	/**
	 * Column Info
	 * @return data57
	 */
	public String getData57() {
		return this.data57;
	}
	
	/**
	 * Column Info
	 * @return shprCd
	 */
	public String getShprCd() {
		return this.shprCd;
	}
	
	/**
	 * Column Info
	 * @return data58
	 */
	public String getData58() {
		return this.data58;
	}
	
	/**
	 * Column Info
	 * @return data70
	 */
	public String getData70() {
		return this.data70;
	}
	
	/**
	 * Column Info
	 * @return data72
	 */
	public String getData72() {
		return this.data72;
	}
	
	/**
	 * Column Info
	 * @return data71
	 */
	public String getData71() {
		return this.data71;
	}
	
	/**
	 * Column Info
	 * @return data74
	 */
	public String getData74() {
		return this.data74;
	}
	
	/**
	 * Column Info
	 * @return data73
	 */
	public String getData73() {
		return this.data73;
	}
	
	/**
	 * Column Info
	 * @return data76
	 */
	public String getData76() {
		return this.data76;
	}
	
	/**
	 * Column Info
	 * @return shprCntCd
	 */
	public String getShprCntCd() {
		return this.shprCntCd;
	}
	
	/**
	 * Column Info
	 * @return data75
	 */
	public String getData75() {
		return this.data75;
	}
	
	/**
	 * Column Info
	 * @return data78
	 */
	public String getData78() {
		return this.data78;
	}
	
	/**
	 * Column Info
	 * @return ntfy1Nm2
	 */
	public String getNtfy1Nm2() {
		return this.ntfy1Nm2;
	}
	
	/**
	 * Column Info
	 * @return data77
	 */
	public String getData77() {
		return this.data77;
	}
	
	/**
	 * Column Info
	 * @return ntfy1Nm1
	 */
	public String getNtfy1Nm1() {
		return this.ntfy1Nm1;
	}
	
	/**
	 * Column Info
	 * @return data79
	 */
	public String getData79() {
		return this.data79;
	}
	
	/**
	 * Column Info
	 * @return ntfy2Nm2
	 */
	public String getNtfy2Nm2() {
		return this.ntfy2Nm2;
	}
	
	/**
	 * Column Info
	 * @return ntfy2Cd
	 */
	public String getNtfy2Cd() {
		return this.ntfy2Cd;
	}
	
	/**
	 * Column Info
	 * @return ntfy2Nm1
	 */
	public String getNtfy2Nm1() {
		return this.ntfy2Nm1;
	}
	
	/**
	 * Column Info
	 * @return ntfy2CntCd
	 */
	public String getNtfy2CntCd() {
		return this.ntfy2CntCd;
	}
	
	/**
	 * Column Info
	 * @return data60
	 */
	public String getData60() {
		return this.data60;
	}
	
	/**
	 * Column Info
	 * @return data61
	 */
	public String getData61() {
		return this.data61;
	}
	
	/**
	 * Column Info
	 * @return data62
	 */
	public String getData62() {
		return this.data62;
	}
	
	/**
	 * Column Info
	 * @return data63
	 */
	public String getData63() {
		return this.data63;
	}
	
	/**
	 * Column Info
	 * @return data64
	 */
	public String getData64() {
		return this.data64;
	}
	
	/**
	 * Column Info
	 * @return inVvdCd
	 */
	public String getInVvdCd() {
		return this.inVvdCd;
	}
	
	/**
	 * Column Info
	 * @return data65
	 */
	public String getData65() {
		return this.data65;
	}
	
	/**
	 * Column Info
	 * @return data66
	 */
	public String getData66() {
		return this.data66;
	}
	
	/**
	 * Column Info
	 * @return data67
	 */
	public String getData67() {
		return this.data67;
	}
	
	/**
	 * Column Info
	 * @return data68
	 */
	public String getData68() {
		return this.data68;
	}
	
	/**
	 * Column Info
	 * @return data69
	 */
	public String getData69() {
		return this.data69;
	}
	
	/**
	 * Column Info
	 * @return jpTmlVslNo
	 */
	public String getJpTmlVslNo() {
		return this.jpTmlVslNo;
	}
	
	/**
	 * Column Info
	 * @return cyOprCd
	 */
	public String getCyOprCd() {
		return this.cyOprCd;
	}
	
	/**
	 * Column Info
	 * @return inCallSgnNo
	 */
	public String getInCallSgnNo() {
		return this.inCallSgnNo;
	}
	
	/**
	 * Column Info
	 * @return shprPostId
	 */
	public String getShprPostId() {
		return this.shprPostId;
	}
	
	/**
	 * Column Info
	 * @return ntfy2PostId
	 */
	public String getNtfy2PostId() {
		return this.ntfy2PostId;
	}
	
	/**
	 * Column Info
	 * @return cneePhnNo
	 */
	public String getCneePhnNo() {
		return this.cneePhnNo;
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
	 * @return cneePostId
	 */
	public String getCneePostId() {
		return this.cneePostId;
	}
	
	/**
	 * Column Info
	 * @return ntfy1PostId
	 */
	public String getNtfy1PostId() {
		return this.ntfy1PostId;
	}
	
	/**
	 * Column Info
	 * @return ntfy1Cd
	 */
	public String getNtfy1Cd() {
		return this.ntfy1Cd;
	}
	
	/**
	 * Column Info
	 * @return cneeAddr4
	 */
	public String getCneeAddr4() {
		return this.cneeAddr4;
	}
	
	/**
	 * Column Info
	 * @return shprPhnNo
	 */
	public String getShprPhnNo() {
		return this.shprPhnNo;
	}
	
	/**
	 * Column Info
	 * @return cneeNm1
	 */
	public String getCneeNm1() {
		return this.cneeNm1;
	}
	
	/**
	 * Column Info
	 * @return cneeNm2
	 */
	public String getCneeNm2() {
		return this.cneeNm2;
	}
	
	/**
	 * Column Info
	 * @return data06
	 */
	public String getData06() {
		return this.data06;
	}
	
	/**
	 * Column Info
	 * @return ntfy1PhnNo
	 */
	public String getNtfy1PhnNo() {
		return this.ntfy1PhnNo;
	}
	
	/**
	 * Column Info
	 * @return data07
	 */
	public String getData07() {
		return this.data07;
	}
	
	/**
	 * Column Info
	 * @return cneeAddr1
	 */
	public String getCneeAddr1() {
		return this.cneeAddr1;
	}
	
	/**
	 * Column Info
	 * @return cneeAddr2
	 */
	public String getCneeAddr2() {
		return this.cneeAddr2;
	}
	
	/**
	 * Column Info
	 * @return cneeAddr3
	 */
	public String getCneeAddr3() {
		return this.cneeAddr3;
	}
	
	/**
	 * Column Info
	 * @return data03
	 */
	public String getData03() {
		return this.data03;
	}
	
	/**
	 * Column Info
	 * @return data02
	 */
	public String getData02() {
		return this.data02;
	}
	
	/**
	 * Column Info
	 * @return data05
	 */
	public String getData05() {
		return this.data05;
	}
	
	/**
	 * Column Info
	 * @return data04
	 */
	public String getData04() {
		return this.data04;
	}
	
	/**
	 * Column Info
	 * @return data01
	 */
	public String getData01() {
		return this.data01;
	}
	
	/**
	 * Column Info
	 * @return shprAddr2
	 */
	public String getShprAddr2() {
		return this.shprAddr2;
	}
	
	/**
	 * Column Info
	 * @return shprAddr3
	 */
	public String getShprAddr3() {
		return this.shprAddr3;
	}
	
	/**
	 * Column Info
	 * @return data48
	 */
	public String getData48() {
		return this.data48;
	}
	
	/**
	 * Column Info
	 * @return data49
	 */
	public String getData49() {
		return this.data49;
	}
	
	/**
	 * Column Info
	 * @return shprAddr1
	 */
	public String getShprAddr1() {
		return this.shprAddr1;
	}
	
	/**
	 * Column Info
	 * @return shprAddr4
	 */
	public String getShprAddr4() {
		return this.shprAddr4;
	}
	

	/**
	 * Column Info
	 * @param cneeCd
	 */
	public void setCneeCd(String cneeCd) {
		this.cneeCd = cneeCd;
	}
	
	/**
	 * Column Info
	 * @param ntfy1Addr1
	 */
	public void setNtfy1Addr1(String ntfy1Addr1) {
		this.ntfy1Addr1 = ntfy1Addr1;
	}
	
	/**
	 * Column Info
	 * @param ntfy1Addr2
	 */
	public void setNtfy1Addr2(String ntfy1Addr2) {
		this.ntfy1Addr2 = ntfy1Addr2;
	}
	
	/**
	 * Column Info
	 * @param shprNm1
	 */
	public void setShprNm1(String shprNm1) {
		this.shprNm1 = shprNm1;
	}
	
	/**
	 * Column Info
	 * @param ntfy1Addr3
	 */
	public void setNtfy1Addr3(String ntfy1Addr3) {
		this.ntfy1Addr3 = ntfy1Addr3;
	}
	
	/**
	 * Column Info
	 * @param ntfy1Addr4
	 */
	public void setNtfy1Addr4(String ntfy1Addr4) {
		this.ntfy1Addr4 = ntfy1Addr4;
	}
	
	/**
	 * Column Info
	 * @param shprNm2
	 */
	public void setShprNm2(String shprNm2) {
		this.shprNm2 = shprNm2;
	}
	
	/**
	 * Column Info
	 * @param ntfy1CntCd
	 */
	public void setNtfy1CntCd(String ntfy1CntCd) {
		this.ntfy1CntCd = ntfy1CntCd;
	}
	
	/**
	 * Column Info
	 * @param ntfy2Addr1
	 */
	public void setNtfy2Addr1(String ntfy2Addr1) {
		this.ntfy2Addr1 = ntfy2Addr1;
	}
	
	/**
	 * Column Info
	 * @param ntfy2PhnNo
	 */
	public void setNtfy2PhnNo(String ntfy2PhnNo) {
		this.ntfy2PhnNo = ntfy2PhnNo;
	}
	
	/**
	 * Column Info
	 * @param ntfy2Addr2
	 */
	public void setNtfy2Addr2(String ntfy2Addr2) {
		this.ntfy2Addr2 = ntfy2Addr2;
	}
	
	/**
	 * Column Info
	 * @param ntfy2Addr3
	 */
	public void setNtfy2Addr3(String ntfy2Addr3) {
		this.ntfy2Addr3 = ntfy2Addr3;
	}
	
	/**
	 * Column Info
	 * @param ntfy2Addr4
	 */
	public void setNtfy2Addr4(String ntfy2Addr4) {
		this.ntfy2Addr4 = ntfy2Addr4;
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
	 * @param cneeCntCd
	 */
	public void setCneeCntCd(String cneeCntCd) {
		this.cneeCntCd = cneeCntCd;
	}
	
	/**
	 * Column Info
	 * @param data51
	 */
	public void setData51(String data51) {
		this.data51 = data51;
	}
	
	/**
	 * Column Info
	 * @param data52
	 */
	public void setData52(String data52) {
		this.data52 = data52;
	}
	
	/**
	 * Column Info
	 * @param data50
	 */
	public void setData50(String data50) {
		this.data50 = data50;
	}
	
	/**
	 * Column Info
	 * @param data55
	 */
	public void setData55(String data55) {
		this.data55 = data55;
	}
	
	/**
	 * Column Info
	 * @param data56
	 */
	public void setData56(String data56) {
		this.data56 = data56;
	}
	
	/**
	 * Column Info
	 * @param data53
	 */
	public void setData53(String data53) {
		this.data53 = data53;
	}
	
	/**
	 * Column Info
	 * @param data54
	 */
	public void setData54(String data54) {
		this.data54 = data54;
	}
	
	/**
	 * Column Info
	 * @param data59
	 */
	public void setData59(String data59) {
		this.data59 = data59;
	}
	
	/**
	 * Column Info
	 * @param data57
	 */
	public void setData57(String data57) {
		this.data57 = data57;
	}
	
	/**
	 * Column Info
	 * @param shprCd
	 */
	public void setShprCd(String shprCd) {
		this.shprCd = shprCd;
	}
	
	/**
	 * Column Info
	 * @param data58
	 */
	public void setData58(String data58) {
		this.data58 = data58;
	}
	
	/**
	 * Column Info
	 * @param data70
	 */
	public void setData70(String data70) {
		this.data70 = data70;
	}
	
	/**
	 * Column Info
	 * @param data72
	 */
	public void setData72(String data72) {
		this.data72 = data72;
	}
	
	/**
	 * Column Info
	 * @param data71
	 */
	public void setData71(String data71) {
		this.data71 = data71;
	}
	
	/**
	 * Column Info
	 * @param data74
	 */
	public void setData74(String data74) {
		this.data74 = data74;
	}
	
	/**
	 * Column Info
	 * @param data73
	 */
	public void setData73(String data73) {
		this.data73 = data73;
	}
	
	/**
	 * Column Info
	 * @param data76
	 */
	public void setData76(String data76) {
		this.data76 = data76;
	}
	
	/**
	 * Column Info
	 * @param shprCntCd
	 */
	public void setShprCntCd(String shprCntCd) {
		this.shprCntCd = shprCntCd;
	}
	
	/**
	 * Column Info
	 * @param data75
	 */
	public void setData75(String data75) {
		this.data75 = data75;
	}
	
	/**
	 * Column Info
	 * @param data78
	 */
	public void setData78(String data78) {
		this.data78 = data78;
	}
	
	/**
	 * Column Info
	 * @param ntfy1Nm2
	 */
	public void setNtfy1Nm2(String ntfy1Nm2) {
		this.ntfy1Nm2 = ntfy1Nm2;
	}
	
	/**
	 * Column Info
	 * @param data77
	 */
	public void setData77(String data77) {
		this.data77 = data77;
	}
	
	/**
	 * Column Info
	 * @param ntfy1Nm1
	 */
	public void setNtfy1Nm1(String ntfy1Nm1) {
		this.ntfy1Nm1 = ntfy1Nm1;
	}
	
	/**
	 * Column Info
	 * @param data79
	 */
	public void setData79(String data79) {
		this.data79 = data79;
	}
	
	/**
	 * Column Info
	 * @param ntfy2Nm2
	 */
	public void setNtfy2Nm2(String ntfy2Nm2) {
		this.ntfy2Nm2 = ntfy2Nm2;
	}
	
	/**
	 * Column Info
	 * @param ntfy2Cd
	 */
	public void setNtfy2Cd(String ntfy2Cd) {
		this.ntfy2Cd = ntfy2Cd;
	}
	
	/**
	 * Column Info
	 * @param ntfy2Nm1
	 */
	public void setNtfy2Nm1(String ntfy2Nm1) {
		this.ntfy2Nm1 = ntfy2Nm1;
	}
	
	/**
	 * Column Info
	 * @param ntfy2CntCd
	 */
	public void setNtfy2CntCd(String ntfy2CntCd) {
		this.ntfy2CntCd = ntfy2CntCd;
	}
	
	/**
	 * Column Info
	 * @param data60
	 */
	public void setData60(String data60) {
		this.data60 = data60;
	}
	
	/**
	 * Column Info
	 * @param data61
	 */
	public void setData61(String data61) {
		this.data61 = data61;
	}
	
	/**
	 * Column Info
	 * @param data62
	 */
	public void setData62(String data62) {
		this.data62 = data62;
	}
	
	/**
	 * Column Info
	 * @param data63
	 */
	public void setData63(String data63) {
		this.data63 = data63;
	}
	
	/**
	 * Column Info
	 * @param data64
	 */
	public void setData64(String data64) {
		this.data64 = data64;
	}
	
	/**
	 * Column Info
	 * @param inVvdCd
	 */
	public void setInVvdCd(String inVvdCd) {
		this.inVvdCd = inVvdCd;
	}
	
	/**
	 * Column Info
	 * @param data65
	 */
	public void setData65(String data65) {
		this.data65 = data65;
	}
	
	/**
	 * Column Info
	 * @param data66
	 */
	public void setData66(String data66) {
		this.data66 = data66;
	}
	
	/**
	 * Column Info
	 * @param data67
	 */
	public void setData67(String data67) {
		this.data67 = data67;
	}
	
	/**
	 * Column Info
	 * @param data68
	 */
	public void setData68(String data68) {
		this.data68 = data68;
	}
	
	/**
	 * Column Info
	 * @param data69
	 */
	public void setData69(String data69) {
		this.data69 = data69;
	}
	
	/**
	 * Column Info
	 * @param jpTmlVslNo
	 */
	public void setJpTmlVslNo(String jpTmlVslNo) {
		this.jpTmlVslNo = jpTmlVslNo;
	}
	
	/**
	 * Column Info
	 * @param cyOprCd
	 */
	public void setCyOprCd(String cyOprCd) {
		this.cyOprCd = cyOprCd;
	}
	
	/**
	 * Column Info
	 * @param inCallSgnNo
	 */
	public void setInCallSgnNo(String inCallSgnNo) {
		this.inCallSgnNo = inCallSgnNo;
	}
	
	/**
	 * Column Info
	 * @param shprPostId
	 */
	public void setShprPostId(String shprPostId) {
		this.shprPostId = shprPostId;
	}
	
	/**
	 * Column Info
	 * @param ntfy2PostId
	 */
	public void setNtfy2PostId(String ntfy2PostId) {
		this.ntfy2PostId = ntfy2PostId;
	}
	
	/**
	 * Column Info
	 * @param cneePhnNo
	 */
	public void setCneePhnNo(String cneePhnNo) {
		this.cneePhnNo = cneePhnNo;
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
	 * @param cneePostId
	 */
	public void setCneePostId(String cneePostId) {
		this.cneePostId = cneePostId;
	}
	
	/**
	 * Column Info
	 * @param ntfy1PostId
	 */
	public void setNtfy1PostId(String ntfy1PostId) {
		this.ntfy1PostId = ntfy1PostId;
	}
	
	/**
	 * Column Info
	 * @param ntfy1Cd
	 */
	public void setNtfy1Cd(String ntfy1Cd) {
		this.ntfy1Cd = ntfy1Cd;
	}
	
	/**
	 * Column Info
	 * @param cneeAddr4
	 */
	public void setCneeAddr4(String cneeAddr4) {
		this.cneeAddr4 = cneeAddr4;
	}
	
	/**
	 * Column Info
	 * @param shprPhnNo
	 */
	public void setShprPhnNo(String shprPhnNo) {
		this.shprPhnNo = shprPhnNo;
	}
	
	/**
	 * Column Info
	 * @param cneeNm1
	 */
	public void setCneeNm1(String cneeNm1) {
		this.cneeNm1 = cneeNm1;
	}
	
	/**
	 * Column Info
	 * @param cneeNm2
	 */
	public void setCneeNm2(String cneeNm2) {
		this.cneeNm2 = cneeNm2;
	}
	
	/**
	 * Column Info
	 * @param data06
	 */
	public void setData06(String data06) {
		this.data06 = data06;
	}
	
	/**
	 * Column Info
	 * @param ntfy1PhnNo
	 */
	public void setNtfy1PhnNo(String ntfy1PhnNo) {
		this.ntfy1PhnNo = ntfy1PhnNo;
	}
	
	/**
	 * Column Info
	 * @param data07
	 */
	public void setData07(String data07) {
		this.data07 = data07;
	}
	
	/**
	 * Column Info
	 * @param cneeAddr1
	 */
	public void setCneeAddr1(String cneeAddr1) {
		this.cneeAddr1 = cneeAddr1;
	}
	
	/**
	 * Column Info
	 * @param cneeAddr2
	 */
	public void setCneeAddr2(String cneeAddr2) {
		this.cneeAddr2 = cneeAddr2;
	}
	
	/**
	 * Column Info
	 * @param cneeAddr3
	 */
	public void setCneeAddr3(String cneeAddr3) {
		this.cneeAddr3 = cneeAddr3;
	}
	
	/**
	 * Column Info
	 * @param data03
	 */
	public void setData03(String data03) {
		this.data03 = data03;
	}
	
	/**
	 * Column Info
	 * @param data02
	 */
	public void setData02(String data02) {
		this.data02 = data02;
	}
	
	/**
	 * Column Info
	 * @param data05
	 */
	public void setData05(String data05) {
		this.data05 = data05;
	}
	
	/**
	 * Column Info
	 * @param data04
	 */
	public void setData04(String data04) {
		this.data04 = data04;
	}
	
	/**
	 * Column Info
	 * @param data01
	 */
	public void setData01(String data01) {
		this.data01 = data01;
	}
	
	/**
	 * Column Info
	 * @param shprAddr2
	 */
	public void setShprAddr2(String shprAddr2) {
		this.shprAddr2 = shprAddr2;
	}
	
	/**
	 * Column Info
	 * @param shprAddr3
	 */
	public void setShprAddr3(String shprAddr3) {
		this.shprAddr3 = shprAddr3;
	}
	
	/**
	 * Column Info
	 * @param data48
	 */
	public void setData48(String data48) {
		this.data48 = data48;
	}
	
	/**
	 * Column Info
	 * @param data49
	 */
	public void setData49(String data49) {
		this.data49 = data49;
	}
	
	/**
	 * Column Info
	 * @param shprAddr1
	 */
	public void setShprAddr1(String shprAddr1) {
		this.shprAddr1 = shprAddr1;
	}
	
	/**
	 * Column Info
	 * @param shprAddr4
	 */
	public void setShprAddr4(String shprAddr4) {
		this.shprAddr4 = shprAddr4;
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
		setCneeCd(JSPUtil.getParameter(request, prefix + "cnee_cd", ""));
		setNtfy1Addr1(JSPUtil.getParameter(request, prefix + "ntfy1_addr1", ""));
		setNtfy1Addr2(JSPUtil.getParameter(request, prefix + "ntfy1_addr2", ""));
		setShprNm1(JSPUtil.getParameter(request, prefix + "shpr_nm1", ""));
		setNtfy1Addr3(JSPUtil.getParameter(request, prefix + "ntfy1_addr3", ""));
		setNtfy1Addr4(JSPUtil.getParameter(request, prefix + "ntfy1_addr4", ""));
		setShprNm2(JSPUtil.getParameter(request, prefix + "shpr_nm2", ""));
		setNtfy1CntCd(JSPUtil.getParameter(request, prefix + "ntfy1_cnt_cd", ""));
		setNtfy2Addr1(JSPUtil.getParameter(request, prefix + "ntfy2_addr1", ""));
		setNtfy2PhnNo(JSPUtil.getParameter(request, prefix + "ntfy2_phn_no", ""));
		setNtfy2Addr2(JSPUtil.getParameter(request, prefix + "ntfy2_addr2", ""));
		setNtfy2Addr3(JSPUtil.getParameter(request, prefix + "ntfy2_addr3", ""));
		setNtfy2Addr4(JSPUtil.getParameter(request, prefix + "ntfy2_addr4", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCneeCntCd(JSPUtil.getParameter(request, prefix + "cnee_cnt_cd", ""));
		setData51(JSPUtil.getParameter(request, prefix + "data51", ""));
		setData52(JSPUtil.getParameter(request, prefix + "data52", ""));
		setData50(JSPUtil.getParameter(request, prefix + "data50", ""));
		setData55(JSPUtil.getParameter(request, prefix + "data55", ""));
		setData56(JSPUtil.getParameter(request, prefix + "data56", ""));
		setData53(JSPUtil.getParameter(request, prefix + "data53", ""));
		setData54(JSPUtil.getParameter(request, prefix + "data54", ""));
		setData59(JSPUtil.getParameter(request, prefix + "data59", ""));
		setData57(JSPUtil.getParameter(request, prefix + "data57", ""));
		setShprCd(JSPUtil.getParameter(request, prefix + "shpr_cd", ""));
		setData58(JSPUtil.getParameter(request, prefix + "data58", ""));
		setData70(JSPUtil.getParameter(request, prefix + "data70", ""));
		setData72(JSPUtil.getParameter(request, prefix + "data72", ""));
		setData71(JSPUtil.getParameter(request, prefix + "data71", ""));
		setData74(JSPUtil.getParameter(request, prefix + "data74", ""));
		setData73(JSPUtil.getParameter(request, prefix + "data73", ""));
		setData76(JSPUtil.getParameter(request, prefix + "data76", ""));
		setShprCntCd(JSPUtil.getParameter(request, prefix + "shpr_cnt_cd", ""));
		setData75(JSPUtil.getParameter(request, prefix + "data75", ""));
		setData78(JSPUtil.getParameter(request, prefix + "data78", ""));
		setNtfy1Nm2(JSPUtil.getParameter(request, prefix + "ntfy1_nm2", ""));
		setData77(JSPUtil.getParameter(request, prefix + "data77", ""));
		setNtfy1Nm1(JSPUtil.getParameter(request, prefix + "ntfy1_nm1", ""));
		setData79(JSPUtil.getParameter(request, prefix + "data79", ""));
		setNtfy2Nm2(JSPUtil.getParameter(request, prefix + "ntfy2_nm2", ""));
		setNtfy2Cd(JSPUtil.getParameter(request, prefix + "ntfy2_cd", ""));
		setNtfy2Nm1(JSPUtil.getParameter(request, prefix + "ntfy2_nm1", ""));
		setNtfy2CntCd(JSPUtil.getParameter(request, prefix + "ntfy2_cnt_cd", ""));
		setData60(JSPUtil.getParameter(request, prefix + "data60", ""));
		setData61(JSPUtil.getParameter(request, prefix + "data61", ""));
		setData62(JSPUtil.getParameter(request, prefix + "data62", ""));
		setData63(JSPUtil.getParameter(request, prefix + "data63", ""));
		setData64(JSPUtil.getParameter(request, prefix + "data64", ""));
		setInVvdCd(JSPUtil.getParameter(request, prefix + "in_vvd_cd", ""));
		setData65(JSPUtil.getParameter(request, prefix + "data65", ""));
		setData66(JSPUtil.getParameter(request, prefix + "data66", ""));
		setData67(JSPUtil.getParameter(request, prefix + "data67", ""));
		setData68(JSPUtil.getParameter(request, prefix + "data68", ""));
		setData69(JSPUtil.getParameter(request, prefix + "data69", ""));
		setJpTmlVslNo(JSPUtil.getParameter(request, prefix + "jp_tml_vsl_no", ""));
		setCyOprCd(JSPUtil.getParameter(request, prefix + "cy_opr_cd", ""));
		setInCallSgnNo(JSPUtil.getParameter(request, prefix + "in_call_sgn_no", ""));
		setShprPostId(JSPUtil.getParameter(request, prefix + "shpr_post_id", ""));
		setNtfy2PostId(JSPUtil.getParameter(request, prefix + "ntfy2_post_id", ""));
		setCneePhnNo(JSPUtil.getParameter(request, prefix + "cnee_phn_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCneePostId(JSPUtil.getParameter(request, prefix + "cnee_post_id", ""));
		setNtfy1PostId(JSPUtil.getParameter(request, prefix + "ntfy1_post_id", ""));
		setNtfy1Cd(JSPUtil.getParameter(request, prefix + "ntfy1_cd", ""));
		setCneeAddr4(JSPUtil.getParameter(request, prefix + "cnee_addr4", ""));
		setShprPhnNo(JSPUtil.getParameter(request, prefix + "shpr_phn_no", ""));
		setCneeNm1(JSPUtil.getParameter(request, prefix + "cnee_nm1", ""));
		setCneeNm2(JSPUtil.getParameter(request, prefix + "cnee_nm2", ""));
		setData06(JSPUtil.getParameter(request, prefix + "data06", ""));
		setNtfy1PhnNo(JSPUtil.getParameter(request, prefix + "ntfy1_phn_no", ""));
		setData07(JSPUtil.getParameter(request, prefix + "data07", ""));
		setCneeAddr1(JSPUtil.getParameter(request, prefix + "cnee_addr1", ""));
		setCneeAddr2(JSPUtil.getParameter(request, prefix + "cnee_addr2", ""));
		setCneeAddr3(JSPUtil.getParameter(request, prefix + "cnee_addr3", ""));
		setData03(JSPUtil.getParameter(request, prefix + "data03", ""));
		setData02(JSPUtil.getParameter(request, prefix + "data02", ""));
		setData05(JSPUtil.getParameter(request, prefix + "data05", ""));
		setData04(JSPUtil.getParameter(request, prefix + "data04", ""));
		setData01(JSPUtil.getParameter(request, prefix + "data01", ""));
		setShprAddr2(JSPUtil.getParameter(request, prefix + "shpr_addr2", ""));
		setShprAddr3(JSPUtil.getParameter(request, prefix + "shpr_addr3", ""));
		setData48(JSPUtil.getParameter(request, prefix + "data48", ""));
		setData49(JSPUtil.getParameter(request, prefix + "data49", ""));
		setShprAddr1(JSPUtil.getParameter(request, prefix + "shpr_addr1", ""));
		setShprAddr4(JSPUtil.getParameter(request, prefix + "shpr_addr4", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapanManifestListEmptyBlInfoVO[]
	 */
	public JapanManifestListEmptyBlInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JapanManifestListEmptyBlInfoVO[]
	 */
	public JapanManifestListEmptyBlInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapanManifestListEmptyBlInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cneeCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cd", length));
			String[] ntfy1Addr1 = (JSPUtil.getParameter(request, prefix	+ "ntfy1_addr1", length));
			String[] ntfy1Addr2 = (JSPUtil.getParameter(request, prefix	+ "ntfy1_addr2", length));
			String[] shprNm1 = (JSPUtil.getParameter(request, prefix	+ "shpr_nm1", length));
			String[] ntfy1Addr3 = (JSPUtil.getParameter(request, prefix	+ "ntfy1_addr3", length));
			String[] ntfy1Addr4 = (JSPUtil.getParameter(request, prefix	+ "ntfy1_addr4", length));
			String[] shprNm2 = (JSPUtil.getParameter(request, prefix	+ "shpr_nm2", length));
			String[] ntfy1CntCd = (JSPUtil.getParameter(request, prefix	+ "ntfy1_cnt_cd", length));
			String[] ntfy2Addr1 = (JSPUtil.getParameter(request, prefix	+ "ntfy2_addr1", length));
			String[] ntfy2PhnNo = (JSPUtil.getParameter(request, prefix	+ "ntfy2_phn_no", length));
			String[] ntfy2Addr2 = (JSPUtil.getParameter(request, prefix	+ "ntfy2_addr2", length));
			String[] ntfy2Addr3 = (JSPUtil.getParameter(request, prefix	+ "ntfy2_addr3", length));
			String[] ntfy2Addr4 = (JSPUtil.getParameter(request, prefix	+ "ntfy2_addr4", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cneeCntCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cnt_cd", length));
			String[] data51 = (JSPUtil.getParameter(request, prefix	+ "data51", length));
			String[] data52 = (JSPUtil.getParameter(request, prefix	+ "data52", length));
			String[] data50 = (JSPUtil.getParameter(request, prefix	+ "data50", length));
			String[] data55 = (JSPUtil.getParameter(request, prefix	+ "data55", length));
			String[] data56 = (JSPUtil.getParameter(request, prefix	+ "data56", length));
			String[] data53 = (JSPUtil.getParameter(request, prefix	+ "data53", length));
			String[] data54 = (JSPUtil.getParameter(request, prefix	+ "data54", length));
			String[] data59 = (JSPUtil.getParameter(request, prefix	+ "data59", length));
			String[] data57 = (JSPUtil.getParameter(request, prefix	+ "data57", length));
			String[] shprCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cd", length));
			String[] data58 = (JSPUtil.getParameter(request, prefix	+ "data58", length));
			String[] data70 = (JSPUtil.getParameter(request, prefix	+ "data70", length));
			String[] data72 = (JSPUtil.getParameter(request, prefix	+ "data72", length));
			String[] data71 = (JSPUtil.getParameter(request, prefix	+ "data71", length));
			String[] data74 = (JSPUtil.getParameter(request, prefix	+ "data74", length));
			String[] data73 = (JSPUtil.getParameter(request, prefix	+ "data73", length));
			String[] data76 = (JSPUtil.getParameter(request, prefix	+ "data76", length));
			String[] shprCntCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_cd", length));
			String[] data75 = (JSPUtil.getParameter(request, prefix	+ "data75", length));
			String[] data78 = (JSPUtil.getParameter(request, prefix	+ "data78", length));
			String[] ntfy1Nm2 = (JSPUtil.getParameter(request, prefix	+ "ntfy1_nm2", length));
			String[] data77 = (JSPUtil.getParameter(request, prefix	+ "data77", length));
			String[] ntfy1Nm1 = (JSPUtil.getParameter(request, prefix	+ "ntfy1_nm1", length));
			String[] data79 = (JSPUtil.getParameter(request, prefix	+ "data79", length));
			String[] ntfy2Nm2 = (JSPUtil.getParameter(request, prefix	+ "ntfy2_nm2", length));
			String[] ntfy2Cd = (JSPUtil.getParameter(request, prefix	+ "ntfy2_cd", length));
			String[] ntfy2Nm1 = (JSPUtil.getParameter(request, prefix	+ "ntfy2_nm1", length));
			String[] ntfy2CntCd = (JSPUtil.getParameter(request, prefix	+ "ntfy2_cnt_cd", length));
			String[] data60 = (JSPUtil.getParameter(request, prefix	+ "data60", length));
			String[] data61 = (JSPUtil.getParameter(request, prefix	+ "data61", length));
			String[] data62 = (JSPUtil.getParameter(request, prefix	+ "data62", length));
			String[] data63 = (JSPUtil.getParameter(request, prefix	+ "data63", length));
			String[] data64 = (JSPUtil.getParameter(request, prefix	+ "data64", length));
			String[] inVvdCd = (JSPUtil.getParameter(request, prefix	+ "in_vvd_cd", length));
			String[] data65 = (JSPUtil.getParameter(request, prefix	+ "data65", length));
			String[] data66 = (JSPUtil.getParameter(request, prefix	+ "data66", length));
			String[] data67 = (JSPUtil.getParameter(request, prefix	+ "data67", length));
			String[] data68 = (JSPUtil.getParameter(request, prefix	+ "data68", length));
			String[] data69 = (JSPUtil.getParameter(request, prefix	+ "data69", length));
			String[] jpTmlVslNo = (JSPUtil.getParameter(request, prefix	+ "jp_tml_vsl_no", length));
			String[] cyOprCd = (JSPUtil.getParameter(request, prefix	+ "cy_opr_cd", length));
			String[] inCallSgnNo = (JSPUtil.getParameter(request, prefix	+ "in_call_sgn_no", length));
			String[] shprPostId = (JSPUtil.getParameter(request, prefix	+ "shpr_post_id", length));
			String[] ntfy2PostId = (JSPUtil.getParameter(request, prefix	+ "ntfy2_post_id", length));
			String[] cneePhnNo = (JSPUtil.getParameter(request, prefix	+ "cnee_phn_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cneePostId = (JSPUtil.getParameter(request, prefix	+ "cnee_post_id", length));
			String[] ntfy1PostId = (JSPUtil.getParameter(request, prefix	+ "ntfy1_post_id", length));
			String[] ntfy1Cd = (JSPUtil.getParameter(request, prefix	+ "ntfy1_cd", length));
			String[] cneeAddr4 = (JSPUtil.getParameter(request, prefix	+ "cnee_addr4", length));
			String[] shprPhnNo = (JSPUtil.getParameter(request, prefix	+ "shpr_phn_no", length));
			String[] cneeNm1 = (JSPUtil.getParameter(request, prefix	+ "cnee_nm1", length));
			String[] cneeNm2 = (JSPUtil.getParameter(request, prefix	+ "cnee_nm2", length));
			String[] data06 = (JSPUtil.getParameter(request, prefix	+ "data06", length));
			String[] ntfy1PhnNo = (JSPUtil.getParameter(request, prefix	+ "ntfy1_phn_no", length));
			String[] data07 = (JSPUtil.getParameter(request, prefix	+ "data07", length));
			String[] cneeAddr1 = (JSPUtil.getParameter(request, prefix	+ "cnee_addr1", length));
			String[] cneeAddr2 = (JSPUtil.getParameter(request, prefix	+ "cnee_addr2", length));
			String[] cneeAddr3 = (JSPUtil.getParameter(request, prefix	+ "cnee_addr3", length));
			String[] data03 = (JSPUtil.getParameter(request, prefix	+ "data03", length));
			String[] data02 = (JSPUtil.getParameter(request, prefix	+ "data02", length));
			String[] data05 = (JSPUtil.getParameter(request, prefix	+ "data05", length));
			String[] data04 = (JSPUtil.getParameter(request, prefix	+ "data04", length));
			String[] data01 = (JSPUtil.getParameter(request, prefix	+ "data01", length));
			String[] shprAddr2 = (JSPUtil.getParameter(request, prefix	+ "shpr_addr2", length));
			String[] shprAddr3 = (JSPUtil.getParameter(request, prefix	+ "shpr_addr3", length));
			String[] data48 = (JSPUtil.getParameter(request, prefix	+ "data48", length));
			String[] data49 = (JSPUtil.getParameter(request, prefix	+ "data49", length));
			String[] shprAddr1 = (JSPUtil.getParameter(request, prefix	+ "shpr_addr1", length));
			String[] shprAddr4 = (JSPUtil.getParameter(request, prefix	+ "shpr_addr4", length));
			
			for (int i = 0; i < length; i++) {
				model = new JapanManifestListEmptyBlInfoVO();
				if (cneeCd[i] != null)
					model.setCneeCd(cneeCd[i]);
				if (ntfy1Addr1[i] != null)
					model.setNtfy1Addr1(ntfy1Addr1[i]);
				if (ntfy1Addr2[i] != null)
					model.setNtfy1Addr2(ntfy1Addr2[i]);
				if (shprNm1[i] != null)
					model.setShprNm1(shprNm1[i]);
				if (ntfy1Addr3[i] != null)
					model.setNtfy1Addr3(ntfy1Addr3[i]);
				if (ntfy1Addr4[i] != null)
					model.setNtfy1Addr4(ntfy1Addr4[i]);
				if (shprNm2[i] != null)
					model.setShprNm2(shprNm2[i]);
				if (ntfy1CntCd[i] != null)
					model.setNtfy1CntCd(ntfy1CntCd[i]);
				if (ntfy2Addr1[i] != null)
					model.setNtfy2Addr1(ntfy2Addr1[i]);
				if (ntfy2PhnNo[i] != null)
					model.setNtfy2PhnNo(ntfy2PhnNo[i]);
				if (ntfy2Addr2[i] != null)
					model.setNtfy2Addr2(ntfy2Addr2[i]);
				if (ntfy2Addr3[i] != null)
					model.setNtfy2Addr3(ntfy2Addr3[i]);
				if (ntfy2Addr4[i] != null)
					model.setNtfy2Addr4(ntfy2Addr4[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cneeCntCd[i] != null)
					model.setCneeCntCd(cneeCntCd[i]);
				if (data51[i] != null)
					model.setData51(data51[i]);
				if (data52[i] != null)
					model.setData52(data52[i]);
				if (data50[i] != null)
					model.setData50(data50[i]);
				if (data55[i] != null)
					model.setData55(data55[i]);
				if (data56[i] != null)
					model.setData56(data56[i]);
				if (data53[i] != null)
					model.setData53(data53[i]);
				if (data54[i] != null)
					model.setData54(data54[i]);
				if (data59[i] != null)
					model.setData59(data59[i]);
				if (data57[i] != null)
					model.setData57(data57[i]);
				if (shprCd[i] != null)
					model.setShprCd(shprCd[i]);
				if (data58[i] != null)
					model.setData58(data58[i]);
				if (data70[i] != null)
					model.setData70(data70[i]);
				if (data72[i] != null)
					model.setData72(data72[i]);
				if (data71[i] != null)
					model.setData71(data71[i]);
				if (data74[i] != null)
					model.setData74(data74[i]);
				if (data73[i] != null)
					model.setData73(data73[i]);
				if (data76[i] != null)
					model.setData76(data76[i]);
				if (shprCntCd[i] != null)
					model.setShprCntCd(shprCntCd[i]);
				if (data75[i] != null)
					model.setData75(data75[i]);
				if (data78[i] != null)
					model.setData78(data78[i]);
				if (ntfy1Nm2[i] != null)
					model.setNtfy1Nm2(ntfy1Nm2[i]);
				if (data77[i] != null)
					model.setData77(data77[i]);
				if (ntfy1Nm1[i] != null)
					model.setNtfy1Nm1(ntfy1Nm1[i]);
				if (data79[i] != null)
					model.setData79(data79[i]);
				if (ntfy2Nm2[i] != null)
					model.setNtfy2Nm2(ntfy2Nm2[i]);
				if (ntfy2Cd[i] != null)
					model.setNtfy2Cd(ntfy2Cd[i]);
				if (ntfy2Nm1[i] != null)
					model.setNtfy2Nm1(ntfy2Nm1[i]);
				if (ntfy2CntCd[i] != null)
					model.setNtfy2CntCd(ntfy2CntCd[i]);
				if (data60[i] != null)
					model.setData60(data60[i]);
				if (data61[i] != null)
					model.setData61(data61[i]);
				if (data62[i] != null)
					model.setData62(data62[i]);
				if (data63[i] != null)
					model.setData63(data63[i]);
				if (data64[i] != null)
					model.setData64(data64[i]);
				if (inVvdCd[i] != null)
					model.setInVvdCd(inVvdCd[i]);
				if (data65[i] != null)
					model.setData65(data65[i]);
				if (data66[i] != null)
					model.setData66(data66[i]);
				if (data67[i] != null)
					model.setData67(data67[i]);
				if (data68[i] != null)
					model.setData68(data68[i]);
				if (data69[i] != null)
					model.setData69(data69[i]);
				if (jpTmlVslNo[i] != null)
					model.setJpTmlVslNo(jpTmlVslNo[i]);
				if (cyOprCd[i] != null)
					model.setCyOprCd(cyOprCd[i]);
				if (inCallSgnNo[i] != null)
					model.setInCallSgnNo(inCallSgnNo[i]);
				if (shprPostId[i] != null)
					model.setShprPostId(shprPostId[i]);
				if (ntfy2PostId[i] != null)
					model.setNtfy2PostId(ntfy2PostId[i]);
				if (cneePhnNo[i] != null)
					model.setCneePhnNo(cneePhnNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cneePostId[i] != null)
					model.setCneePostId(cneePostId[i]);
				if (ntfy1PostId[i] != null)
					model.setNtfy1PostId(ntfy1PostId[i]);
				if (ntfy1Cd[i] != null)
					model.setNtfy1Cd(ntfy1Cd[i]);
				if (cneeAddr4[i] != null)
					model.setCneeAddr4(cneeAddr4[i]);
				if (shprPhnNo[i] != null)
					model.setShprPhnNo(shprPhnNo[i]);
				if (cneeNm1[i] != null)
					model.setCneeNm1(cneeNm1[i]);
				if (cneeNm2[i] != null)
					model.setCneeNm2(cneeNm2[i]);
				if (data06[i] != null)
					model.setData06(data06[i]);
				if (ntfy1PhnNo[i] != null)
					model.setNtfy1PhnNo(ntfy1PhnNo[i]);
				if (data07[i] != null)
					model.setData07(data07[i]);
				if (cneeAddr1[i] != null)
					model.setCneeAddr1(cneeAddr1[i]);
				if (cneeAddr2[i] != null)
					model.setCneeAddr2(cneeAddr2[i]);
				if (cneeAddr3[i] != null)
					model.setCneeAddr3(cneeAddr3[i]);
				if (data03[i] != null)
					model.setData03(data03[i]);
				if (data02[i] != null)
					model.setData02(data02[i]);
				if (data05[i] != null)
					model.setData05(data05[i]);
				if (data04[i] != null)
					model.setData04(data04[i]);
				if (data01[i] != null)
					model.setData01(data01[i]);
				if (shprAddr2[i] != null)
					model.setShprAddr2(shprAddr2[i]);
				if (shprAddr3[i] != null)
					model.setShprAddr3(shprAddr3[i]);
				if (data48[i] != null)
					model.setData48(data48[i]);
				if (data49[i] != null)
					model.setData49(data49[i]);
				if (shprAddr1[i] != null)
					model.setShprAddr1(shprAddr1[i]);
				if (shprAddr4[i] != null)
					model.setShprAddr4(shprAddr4[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapanManifestListEmptyBlInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapanManifestListEmptyBlInfoVO[]
	 */
	public JapanManifestListEmptyBlInfoVO[] getJapanManifestListEmptyBlInfoVOs(){
		JapanManifestListEmptyBlInfoVO[] vos = (JapanManifestListEmptyBlInfoVO[])models.toArray(new JapanManifestListEmptyBlInfoVO[models.size()]);
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
		this.cneeCd = this.cneeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy1Addr1 = this.ntfy1Addr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy1Addr2 = this.ntfy1Addr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm1 = this.shprNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy1Addr3 = this.ntfy1Addr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy1Addr4 = this.ntfy1Addr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm2 = this.shprNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy1CntCd = this.ntfy1CntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2Addr1 = this.ntfy2Addr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2PhnNo = this.ntfy2PhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2Addr2 = this.ntfy2Addr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2Addr3 = this.ntfy2Addr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2Addr4 = this.ntfy2Addr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCntCd = this.cneeCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data51 = this.data51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data52 = this.data52 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data50 = this.data50 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data55 = this.data55 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data56 = this.data56 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data53 = this.data53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data54 = this.data54 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data59 = this.data59 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data57 = this.data57 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCd = this.shprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data58 = this.data58 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data70 = this.data70 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data72 = this.data72 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data71 = this.data71 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data74 = this.data74 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data73 = this.data73 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data76 = this.data76 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntCd = this.shprCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data75 = this.data75 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data78 = this.data78 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy1Nm2 = this.ntfy1Nm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data77 = this.data77 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy1Nm1 = this.ntfy1Nm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data79 = this.data79 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2Nm2 = this.ntfy2Nm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2Cd = this.ntfy2Cd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2Nm1 = this.ntfy2Nm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2CntCd = this.ntfy2CntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data60 = this.data60 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data61 = this.data61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data62 = this.data62 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data63 = this.data63 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data64 = this.data64 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVvdCd = this.inVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data65 = this.data65 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data66 = this.data66 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data67 = this.data67 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data68 = this.data68 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data69 = this.data69 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpTmlVslNo = this.jpTmlVslNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cyOprCd = this.cyOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCallSgnNo = this.inCallSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprPostId = this.shprPostId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2PostId = this.ntfy2PostId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneePhnNo = this.cneePhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneePostId = this.cneePostId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy1PostId = this.ntfy1PostId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy1Cd = this.ntfy1Cd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddr4 = this.cneeAddr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprPhnNo = this.shprPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm1 = this.cneeNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm2 = this.cneeNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data06 = this.data06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy1PhnNo = this.ntfy1PhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data07 = this.data07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddr1 = this.cneeAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddr2 = this.cneeAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddr3 = this.cneeAddr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data03 = this.data03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data02 = this.data02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data05 = this.data05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data04 = this.data04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data01 = this.data01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddr2 = this.shprAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddr3 = this.shprAddr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data48 = this.data48 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data49 = this.data49 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddr1 = this.shprAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddr4 = this.shprAddr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

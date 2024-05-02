/*=========================================================
*Copyright(c) 2015 CyberLogitec 
*@FileName : JapanManifestListBlCustInfoVO.java
*@FileTitle : JapanManifestListBlCustInfoVO
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

public class JapanManifestListBlCustInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<JapanManifestListBlCustInfoVO> models = new ArrayList<JapanManifestListBlCustInfoVO>();
	
	/* Column Info */
	private String ntfy1Addr1 = null;
	/* Column Info */
	private String cneeCd = null;
	/* Column Info */
	private String ntfy1Addr2 = null;
	/* Column Info */
	private String ntfy1Addr3 = null;
	/* Column Info */
	private String shprNm1 = null;
	/* Column Info */
	private String ntfy1Addr4 = null;
	/* Column Info */
	private String ntfy1CntCd = null;
	/* Column Info */
	private String shprNm2 = null;
	/* Column Info */
	private String ntfy2Addr1 = null;
	/* Column Info */
	private String ntfy2PhnNo = null;
	/* Column Info */
	private String ntfy2Addr2 = null;
	/* Column Info */
	private String ntfy2Addr3 = null;
	/* Column Info */
	private String shprPostId = null;
	/* Column Info */
	private String ntfy2Addr4 = null;
	/* Column Info */
	private String ntfy2PostId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cneeCntCd = null;
	/* Column Info */
	private String cneePhnNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cneePostId = null;
	/* Column Info */
	private String ntfy1PostId = null;
	/* Column Info */
	private String shprCd = null;
	/* Column Info */
	private String ntfy1Cd = null;
	/* Column Info */
	private String cneeAddr4 = null;
	/* Column Info */
	private String shprPhnNo = null;
	/* Column Info */
	private String cneeNm1 = null;
	/* Column Info */
	private String shprCntCd = null;
	/* Column Info */
	private String cneeNm2 = null;
	/* Column Info */
	private String ntfy1Nm2 = null;
	/* Column Info */
	private String ntfy1Nm1 = null;
	/* Column Info */
	private String ntfy1PhnNo = null;
	/* Column Info */
	private String ntfy2Nm2 = null;
	/* Column Info */
	private String cneeAddr1 = null;
	/* Column Info */
	private String ntfy2Nm1 = null;
	/* Column Info */
	private String ntfy2Cd = null;
	/* Column Info */
	private String cneeAddr2 = null;
	/* Column Info */
	private String ntfy2CntCd = null;
	/* Column Info */
	private String cneeAddr3 = null;
	/* Column Info */
	private String shprAddr2 = null;
	/* Column Info */
	private String shprAddr3 = null;
	/* Column Info */
	private String shprAddr1 = null;
	/* Column Info */
	private String shprAddr4 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public JapanManifestListBlCustInfoVO() {}

	public JapanManifestListBlCustInfoVO(String ibflag, String pagerows, String shprCd, String shprNm1, String shprNm2, String shprAddr1, String shprAddr2, String shprAddr3, String shprAddr4, String shprPostId, String shprCntCd, String shprPhnNo, String cneeCd, String cneeNm1, String cneeNm2, String cneeAddr1, String cneeAddr2, String cneeAddr3, String cneeAddr4, String cneePostId, String cneeCntCd, String cneePhnNo, String ntfy1Cd, String ntfy1Nm1, String ntfy1Nm2, String ntfy1Addr1, String ntfy1Addr2, String ntfy1Addr3, String ntfy1Addr4, String ntfy1PostId, String ntfy1CntCd, String ntfy1PhnNo, String ntfy2Cd, String ntfy2Nm1, String ntfy2Nm2, String ntfy2Addr1, String ntfy2Addr2, String ntfy2Addr3, String ntfy2Addr4, String ntfy2PostId, String ntfy2CntCd, String ntfy2PhnNo) {
		this.ntfy1Addr1 = ntfy1Addr1;
		this.cneeCd = cneeCd;
		this.ntfy1Addr2 = ntfy1Addr2;
		this.ntfy1Addr3 = ntfy1Addr3;
		this.shprNm1 = shprNm1;
		this.ntfy1Addr4 = ntfy1Addr4;
		this.ntfy1CntCd = ntfy1CntCd;
		this.shprNm2 = shprNm2;
		this.ntfy2Addr1 = ntfy2Addr1;
		this.ntfy2PhnNo = ntfy2PhnNo;
		this.ntfy2Addr2 = ntfy2Addr2;
		this.ntfy2Addr3 = ntfy2Addr3;
		this.shprPostId = shprPostId;
		this.ntfy2Addr4 = ntfy2Addr4;
		this.ntfy2PostId = ntfy2PostId;
		this.pagerows = pagerows;
		this.cneeCntCd = cneeCntCd;
		this.cneePhnNo = cneePhnNo;
		this.ibflag = ibflag;
		this.cneePostId = cneePostId;
		this.ntfy1PostId = ntfy1PostId;
		this.shprCd = shprCd;
		this.ntfy1Cd = ntfy1Cd;
		this.cneeAddr4 = cneeAddr4;
		this.shprPhnNo = shprPhnNo;
		this.cneeNm1 = cneeNm1;
		this.shprCntCd = shprCntCd;
		this.cneeNm2 = cneeNm2;
		this.ntfy1Nm2 = ntfy1Nm2;
		this.ntfy1Nm1 = ntfy1Nm1;
		this.ntfy1PhnNo = ntfy1PhnNo;
		this.ntfy2Nm2 = ntfy2Nm2;
		this.cneeAddr1 = cneeAddr1;
		this.ntfy2Nm1 = ntfy2Nm1;
		this.ntfy2Cd = ntfy2Cd;
		this.cneeAddr2 = cneeAddr2;
		this.ntfy2CntCd = ntfy2CntCd;
		this.cneeAddr3 = cneeAddr3;
		this.shprAddr2 = shprAddr2;
		this.shprAddr3 = shprAddr3;
		this.shprAddr1 = shprAddr1;
		this.shprAddr4 = shprAddr4;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ntfy1_addr1", getNtfy1Addr1());
		this.hashColumns.put("cnee_cd", getCneeCd());
		this.hashColumns.put("ntfy1_addr2", getNtfy1Addr2());
		this.hashColumns.put("ntfy1_addr3", getNtfy1Addr3());
		this.hashColumns.put("shpr_nm1", getShprNm1());
		this.hashColumns.put("ntfy1_addr4", getNtfy1Addr4());
		this.hashColumns.put("ntfy1_cnt_cd", getNtfy1CntCd());
		this.hashColumns.put("shpr_nm2", getShprNm2());
		this.hashColumns.put("ntfy2_addr1", getNtfy2Addr1());
		this.hashColumns.put("ntfy2_phn_no", getNtfy2PhnNo());
		this.hashColumns.put("ntfy2_addr2", getNtfy2Addr2());
		this.hashColumns.put("ntfy2_addr3", getNtfy2Addr3());
		this.hashColumns.put("shpr_post_id", getShprPostId());
		this.hashColumns.put("ntfy2_addr4", getNtfy2Addr4());
		this.hashColumns.put("ntfy2_post_id", getNtfy2PostId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnee_cnt_cd", getCneeCntCd());
		this.hashColumns.put("cnee_phn_no", getCneePhnNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnee_post_id", getCneePostId());
		this.hashColumns.put("ntfy1_post_id", getNtfy1PostId());
		this.hashColumns.put("shpr_cd", getShprCd());
		this.hashColumns.put("ntfy1_cd", getNtfy1Cd());
		this.hashColumns.put("cnee_addr4", getCneeAddr4());
		this.hashColumns.put("shpr_phn_no", getShprPhnNo());
		this.hashColumns.put("cnee_nm1", getCneeNm1());
		this.hashColumns.put("shpr_cnt_cd", getShprCntCd());
		this.hashColumns.put("cnee_nm2", getCneeNm2());
		this.hashColumns.put("ntfy1_nm2", getNtfy1Nm2());
		this.hashColumns.put("ntfy1_nm1", getNtfy1Nm1());
		this.hashColumns.put("ntfy1_phn_no", getNtfy1PhnNo());
		this.hashColumns.put("ntfy2_nm2", getNtfy2Nm2());
		this.hashColumns.put("cnee_addr1", getCneeAddr1());
		this.hashColumns.put("ntfy2_nm1", getNtfy2Nm1());
		this.hashColumns.put("ntfy2_cd", getNtfy2Cd());
		this.hashColumns.put("cnee_addr2", getCneeAddr2());
		this.hashColumns.put("ntfy2_cnt_cd", getNtfy2CntCd());
		this.hashColumns.put("cnee_addr3", getCneeAddr3());
		this.hashColumns.put("shpr_addr2", getShprAddr2());
		this.hashColumns.put("shpr_addr3", getShprAddr3());
		this.hashColumns.put("shpr_addr1", getShprAddr1());
		this.hashColumns.put("shpr_addr4", getShprAddr4());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ntfy1_addr1", "ntfy1Addr1");
		this.hashFields.put("cnee_cd", "cneeCd");
		this.hashFields.put("ntfy1_addr2", "ntfy1Addr2");
		this.hashFields.put("ntfy1_addr3", "ntfy1Addr3");
		this.hashFields.put("shpr_nm1", "shprNm1");
		this.hashFields.put("ntfy1_addr4", "ntfy1Addr4");
		this.hashFields.put("ntfy1_cnt_cd", "ntfy1CntCd");
		this.hashFields.put("shpr_nm2", "shprNm2");
		this.hashFields.put("ntfy2_addr1", "ntfy2Addr1");
		this.hashFields.put("ntfy2_phn_no", "ntfy2PhnNo");
		this.hashFields.put("ntfy2_addr2", "ntfy2Addr2");
		this.hashFields.put("ntfy2_addr3", "ntfy2Addr3");
		this.hashFields.put("shpr_post_id", "shprPostId");
		this.hashFields.put("ntfy2_addr4", "ntfy2Addr4");
		this.hashFields.put("ntfy2_post_id", "ntfy2PostId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnee_cnt_cd", "cneeCntCd");
		this.hashFields.put("cnee_phn_no", "cneePhnNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnee_post_id", "cneePostId");
		this.hashFields.put("ntfy1_post_id", "ntfy1PostId");
		this.hashFields.put("shpr_cd", "shprCd");
		this.hashFields.put("ntfy1_cd", "ntfy1Cd");
		this.hashFields.put("cnee_addr4", "cneeAddr4");
		this.hashFields.put("shpr_phn_no", "shprPhnNo");
		this.hashFields.put("cnee_nm1", "cneeNm1");
		this.hashFields.put("shpr_cnt_cd", "shprCntCd");
		this.hashFields.put("cnee_nm2", "cneeNm2");
		this.hashFields.put("ntfy1_nm2", "ntfy1Nm2");
		this.hashFields.put("ntfy1_nm1", "ntfy1Nm1");
		this.hashFields.put("ntfy1_phn_no", "ntfy1PhnNo");
		this.hashFields.put("ntfy2_nm2", "ntfy2Nm2");
		this.hashFields.put("cnee_addr1", "cneeAddr1");
		this.hashFields.put("ntfy2_nm1", "ntfy2Nm1");
		this.hashFields.put("ntfy2_cd", "ntfy2Cd");
		this.hashFields.put("cnee_addr2", "cneeAddr2");
		this.hashFields.put("ntfy2_cnt_cd", "ntfy2CntCd");
		this.hashFields.put("cnee_addr3", "cneeAddr3");
		this.hashFields.put("shpr_addr2", "shprAddr2");
		this.hashFields.put("shpr_addr3", "shprAddr3");
		this.hashFields.put("shpr_addr1", "shprAddr1");
		this.hashFields.put("shpr_addr4", "shprAddr4");
		return this.hashFields;
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
	 * @return cneeCd
	 */
	public String getCneeCd() {
		return this.cneeCd;
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
	 * @return ntfy1Addr3
	 */
	public String getNtfy1Addr3() {
		return this.ntfy1Addr3;
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
	 * @return ntfy1Addr4
	 */
	public String getNtfy1Addr4() {
		return this.ntfy1Addr4;
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
	 * @return shprNm2
	 */
	public String getShprNm2() {
		return this.shprNm2;
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
	 * @return shprPostId
	 */
	public String getShprPostId() {
		return this.shprPostId;
	}
	
	/**
	 * Column Info
	 * @return ntfy2Addr4
	 */
	public String getNtfy2Addr4() {
		return this.ntfy2Addr4;
	}
	
	/**
	 * Column Info
	 * @return ntfy2PostId
	 */
	public String getNtfy2PostId() {
		return this.ntfy2PostId;
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
	 * @return shprCd
	 */
	public String getShprCd() {
		return this.shprCd;
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
	 * @return shprCntCd
	 */
	public String getShprCntCd() {
		return this.shprCntCd;
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
	 * @return ntfy1Nm2
	 */
	public String getNtfy1Nm2() {
		return this.ntfy1Nm2;
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
	 * @return ntfy1PhnNo
	 */
	public String getNtfy1PhnNo() {
		return this.ntfy1PhnNo;
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
	 * @return cneeAddr1
	 */
	public String getCneeAddr1() {
		return this.cneeAddr1;
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
	 * @return ntfy2Cd
	 */
	public String getNtfy2Cd() {
		return this.ntfy2Cd;
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
	 * @return ntfy2CntCd
	 */
	public String getNtfy2CntCd() {
		return this.ntfy2CntCd;
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
	 * @param ntfy1Addr1
	 */
	public void setNtfy1Addr1(String ntfy1Addr1) {
		this.ntfy1Addr1 = ntfy1Addr1;
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
	 * @param ntfy1Addr2
	 */
	public void setNtfy1Addr2(String ntfy1Addr2) {
		this.ntfy1Addr2 = ntfy1Addr2;
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
	 * @param shprNm1
	 */
	public void setShprNm1(String shprNm1) {
		this.shprNm1 = shprNm1;
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
	 * @param ntfy1CntCd
	 */
	public void setNtfy1CntCd(String ntfy1CntCd) {
		this.ntfy1CntCd = ntfy1CntCd;
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
	 * @param shprPostId
	 */
	public void setShprPostId(String shprPostId) {
		this.shprPostId = shprPostId;
	}
	
	/**
	 * Column Info
	 * @param ntfy2Addr4
	 */
	public void setNtfy2Addr4(String ntfy2Addr4) {
		this.ntfy2Addr4 = ntfy2Addr4;
	}
	
	/**
	 * Column Info
	 * @param ntfy2PostId
	 */
	public void setNtfy2PostId(String ntfy2PostId) {
		this.ntfy2PostId = ntfy2PostId;
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
	 * @param shprCd
	 */
	public void setShprCd(String shprCd) {
		this.shprCd = shprCd;
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
	 * @param shprCntCd
	 */
	public void setShprCntCd(String shprCntCd) {
		this.shprCntCd = shprCntCd;
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
	 * @param ntfy1Nm2
	 */
	public void setNtfy1Nm2(String ntfy1Nm2) {
		this.ntfy1Nm2 = ntfy1Nm2;
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
	 * @param ntfy1PhnNo
	 */
	public void setNtfy1PhnNo(String ntfy1PhnNo) {
		this.ntfy1PhnNo = ntfy1PhnNo;
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
	 * @param cneeAddr1
	 */
	public void setCneeAddr1(String cneeAddr1) {
		this.cneeAddr1 = cneeAddr1;
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
	 * @param ntfy2Cd
	 */
	public void setNtfy2Cd(String ntfy2Cd) {
		this.ntfy2Cd = ntfy2Cd;
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
	 * @param ntfy2CntCd
	 */
	public void setNtfy2CntCd(String ntfy2CntCd) {
		this.ntfy2CntCd = ntfy2CntCd;
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
		setNtfy1Addr1(JSPUtil.getParameter(request, prefix + "ntfy1_addr1", ""));
		setCneeCd(JSPUtil.getParameter(request, prefix + "cnee_cd", ""));
		setNtfy1Addr2(JSPUtil.getParameter(request, prefix + "ntfy1_addr2", ""));
		setNtfy1Addr3(JSPUtil.getParameter(request, prefix + "ntfy1_addr3", ""));
		setShprNm1(JSPUtil.getParameter(request, prefix + "shpr_nm1", ""));
		setNtfy1Addr4(JSPUtil.getParameter(request, prefix + "ntfy1_addr4", ""));
		setNtfy1CntCd(JSPUtil.getParameter(request, prefix + "ntfy1_cnt_cd", ""));
		setShprNm2(JSPUtil.getParameter(request, prefix + "shpr_nm2", ""));
		setNtfy2Addr1(JSPUtil.getParameter(request, prefix + "ntfy2_addr1", ""));
		setNtfy2PhnNo(JSPUtil.getParameter(request, prefix + "ntfy2_phn_no", ""));
		setNtfy2Addr2(JSPUtil.getParameter(request, prefix + "ntfy2_addr2", ""));
		setNtfy2Addr3(JSPUtil.getParameter(request, prefix + "ntfy2_addr3", ""));
		setShprPostId(JSPUtil.getParameter(request, prefix + "shpr_post_id", ""));
		setNtfy2Addr4(JSPUtil.getParameter(request, prefix + "ntfy2_addr4", ""));
		setNtfy2PostId(JSPUtil.getParameter(request, prefix + "ntfy2_post_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCneeCntCd(JSPUtil.getParameter(request, prefix + "cnee_cnt_cd", ""));
		setCneePhnNo(JSPUtil.getParameter(request, prefix + "cnee_phn_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCneePostId(JSPUtil.getParameter(request, prefix + "cnee_post_id", ""));
		setNtfy1PostId(JSPUtil.getParameter(request, prefix + "ntfy1_post_id", ""));
		setShprCd(JSPUtil.getParameter(request, prefix + "shpr_cd", ""));
		setNtfy1Cd(JSPUtil.getParameter(request, prefix + "ntfy1_cd", ""));
		setCneeAddr4(JSPUtil.getParameter(request, prefix + "cnee_addr4", ""));
		setShprPhnNo(JSPUtil.getParameter(request, prefix + "shpr_phn_no", ""));
		setCneeNm1(JSPUtil.getParameter(request, prefix + "cnee_nm1", ""));
		setShprCntCd(JSPUtil.getParameter(request, prefix + "shpr_cnt_cd", ""));
		setCneeNm2(JSPUtil.getParameter(request, prefix + "cnee_nm2", ""));
		setNtfy1Nm2(JSPUtil.getParameter(request, prefix + "ntfy1_nm2", ""));
		setNtfy1Nm1(JSPUtil.getParameter(request, prefix + "ntfy1_nm1", ""));
		setNtfy1PhnNo(JSPUtil.getParameter(request, prefix + "ntfy1_phn_no", ""));
		setNtfy2Nm2(JSPUtil.getParameter(request, prefix + "ntfy2_nm2", ""));
		setCneeAddr1(JSPUtil.getParameter(request, prefix + "cnee_addr1", ""));
		setNtfy2Nm1(JSPUtil.getParameter(request, prefix + "ntfy2_nm1", ""));
		setNtfy2Cd(JSPUtil.getParameter(request, prefix + "ntfy2_cd", ""));
		setCneeAddr2(JSPUtil.getParameter(request, prefix + "cnee_addr2", ""));
		setNtfy2CntCd(JSPUtil.getParameter(request, prefix + "ntfy2_cnt_cd", ""));
		setCneeAddr3(JSPUtil.getParameter(request, prefix + "cnee_addr3", ""));
		setShprAddr2(JSPUtil.getParameter(request, prefix + "shpr_addr2", ""));
		setShprAddr3(JSPUtil.getParameter(request, prefix + "shpr_addr3", ""));
		setShprAddr1(JSPUtil.getParameter(request, prefix + "shpr_addr1", ""));
		setShprAddr4(JSPUtil.getParameter(request, prefix + "shpr_addr4", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapanManifestListBlCustInfoVO[]
	 */
	public JapanManifestListBlCustInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JapanManifestListBlCustInfoVO[]
	 */
	public JapanManifestListBlCustInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapanManifestListBlCustInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ntfy1Addr1 = (JSPUtil.getParameter(request, prefix	+ "ntfy1_addr1", length));
			String[] cneeCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cd", length));
			String[] ntfy1Addr2 = (JSPUtil.getParameter(request, prefix	+ "ntfy1_addr2", length));
			String[] ntfy1Addr3 = (JSPUtil.getParameter(request, prefix	+ "ntfy1_addr3", length));
			String[] shprNm1 = (JSPUtil.getParameter(request, prefix	+ "shpr_nm1", length));
			String[] ntfy1Addr4 = (JSPUtil.getParameter(request, prefix	+ "ntfy1_addr4", length));
			String[] ntfy1CntCd = (JSPUtil.getParameter(request, prefix	+ "ntfy1_cnt_cd", length));
			String[] shprNm2 = (JSPUtil.getParameter(request, prefix	+ "shpr_nm2", length));
			String[] ntfy2Addr1 = (JSPUtil.getParameter(request, prefix	+ "ntfy2_addr1", length));
			String[] ntfy2PhnNo = (JSPUtil.getParameter(request, prefix	+ "ntfy2_phn_no", length));
			String[] ntfy2Addr2 = (JSPUtil.getParameter(request, prefix	+ "ntfy2_addr2", length));
			String[] ntfy2Addr3 = (JSPUtil.getParameter(request, prefix	+ "ntfy2_addr3", length));
			String[] shprPostId = (JSPUtil.getParameter(request, prefix	+ "shpr_post_id", length));
			String[] ntfy2Addr4 = (JSPUtil.getParameter(request, prefix	+ "ntfy2_addr4", length));
			String[] ntfy2PostId = (JSPUtil.getParameter(request, prefix	+ "ntfy2_post_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cneeCntCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cnt_cd", length));
			String[] cneePhnNo = (JSPUtil.getParameter(request, prefix	+ "cnee_phn_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cneePostId = (JSPUtil.getParameter(request, prefix	+ "cnee_post_id", length));
			String[] ntfy1PostId = (JSPUtil.getParameter(request, prefix	+ "ntfy1_post_id", length));
			String[] shprCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cd", length));
			String[] ntfy1Cd = (JSPUtil.getParameter(request, prefix	+ "ntfy1_cd", length));
			String[] cneeAddr4 = (JSPUtil.getParameter(request, prefix	+ "cnee_addr4", length));
			String[] shprPhnNo = (JSPUtil.getParameter(request, prefix	+ "shpr_phn_no", length));
			String[] cneeNm1 = (JSPUtil.getParameter(request, prefix	+ "cnee_nm1", length));
			String[] shprCntCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_cd", length));
			String[] cneeNm2 = (JSPUtil.getParameter(request, prefix	+ "cnee_nm2", length));
			String[] ntfy1Nm2 = (JSPUtil.getParameter(request, prefix	+ "ntfy1_nm2", length));
			String[] ntfy1Nm1 = (JSPUtil.getParameter(request, prefix	+ "ntfy1_nm1", length));
			String[] ntfy1PhnNo = (JSPUtil.getParameter(request, prefix	+ "ntfy1_phn_no", length));
			String[] ntfy2Nm2 = (JSPUtil.getParameter(request, prefix	+ "ntfy2_nm2", length));
			String[] cneeAddr1 = (JSPUtil.getParameter(request, prefix	+ "cnee_addr1", length));
			String[] ntfy2Nm1 = (JSPUtil.getParameter(request, prefix	+ "ntfy2_nm1", length));
			String[] ntfy2Cd = (JSPUtil.getParameter(request, prefix	+ "ntfy2_cd", length));
			String[] cneeAddr2 = (JSPUtil.getParameter(request, prefix	+ "cnee_addr2", length));
			String[] ntfy2CntCd = (JSPUtil.getParameter(request, prefix	+ "ntfy2_cnt_cd", length));
			String[] cneeAddr3 = (JSPUtil.getParameter(request, prefix	+ "cnee_addr3", length));
			String[] shprAddr2 = (JSPUtil.getParameter(request, prefix	+ "shpr_addr2", length));
			String[] shprAddr3 = (JSPUtil.getParameter(request, prefix	+ "shpr_addr3", length));
			String[] shprAddr1 = (JSPUtil.getParameter(request, prefix	+ "shpr_addr1", length));
			String[] shprAddr4 = (JSPUtil.getParameter(request, prefix	+ "shpr_addr4", length));
			
			for (int i = 0; i < length; i++) {
				model = new JapanManifestListBlCustInfoVO();
				if (ntfy1Addr1[i] != null)
					model.setNtfy1Addr1(ntfy1Addr1[i]);
				if (cneeCd[i] != null)
					model.setCneeCd(cneeCd[i]);
				if (ntfy1Addr2[i] != null)
					model.setNtfy1Addr2(ntfy1Addr2[i]);
				if (ntfy1Addr3[i] != null)
					model.setNtfy1Addr3(ntfy1Addr3[i]);
				if (shprNm1[i] != null)
					model.setShprNm1(shprNm1[i]);
				if (ntfy1Addr4[i] != null)
					model.setNtfy1Addr4(ntfy1Addr4[i]);
				if (ntfy1CntCd[i] != null)
					model.setNtfy1CntCd(ntfy1CntCd[i]);
				if (shprNm2[i] != null)
					model.setShprNm2(shprNm2[i]);
				if (ntfy2Addr1[i] != null)
					model.setNtfy2Addr1(ntfy2Addr1[i]);
				if (ntfy2PhnNo[i] != null)
					model.setNtfy2PhnNo(ntfy2PhnNo[i]);
				if (ntfy2Addr2[i] != null)
					model.setNtfy2Addr2(ntfy2Addr2[i]);
				if (ntfy2Addr3[i] != null)
					model.setNtfy2Addr3(ntfy2Addr3[i]);
				if (shprPostId[i] != null)
					model.setShprPostId(shprPostId[i]);
				if (ntfy2Addr4[i] != null)
					model.setNtfy2Addr4(ntfy2Addr4[i]);
				if (ntfy2PostId[i] != null)
					model.setNtfy2PostId(ntfy2PostId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cneeCntCd[i] != null)
					model.setCneeCntCd(cneeCntCd[i]);
				if (cneePhnNo[i] != null)
					model.setCneePhnNo(cneePhnNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cneePostId[i] != null)
					model.setCneePostId(cneePostId[i]);
				if (ntfy1PostId[i] != null)
					model.setNtfy1PostId(ntfy1PostId[i]);
				if (shprCd[i] != null)
					model.setShprCd(shprCd[i]);
				if (ntfy1Cd[i] != null)
					model.setNtfy1Cd(ntfy1Cd[i]);
				if (cneeAddr4[i] != null)
					model.setCneeAddr4(cneeAddr4[i]);
				if (shprPhnNo[i] != null)
					model.setShprPhnNo(shprPhnNo[i]);
				if (cneeNm1[i] != null)
					model.setCneeNm1(cneeNm1[i]);
				if (shprCntCd[i] != null)
					model.setShprCntCd(shprCntCd[i]);
				if (cneeNm2[i] != null)
					model.setCneeNm2(cneeNm2[i]);
				if (ntfy1Nm2[i] != null)
					model.setNtfy1Nm2(ntfy1Nm2[i]);
				if (ntfy1Nm1[i] != null)
					model.setNtfy1Nm1(ntfy1Nm1[i]);
				if (ntfy1PhnNo[i] != null)
					model.setNtfy1PhnNo(ntfy1PhnNo[i]);
				if (ntfy2Nm2[i] != null)
					model.setNtfy2Nm2(ntfy2Nm2[i]);
				if (cneeAddr1[i] != null)
					model.setCneeAddr1(cneeAddr1[i]);
				if (ntfy2Nm1[i] != null)
					model.setNtfy2Nm1(ntfy2Nm1[i]);
				if (ntfy2Cd[i] != null)
					model.setNtfy2Cd(ntfy2Cd[i]);
				if (cneeAddr2[i] != null)
					model.setCneeAddr2(cneeAddr2[i]);
				if (ntfy2CntCd[i] != null)
					model.setNtfy2CntCd(ntfy2CntCd[i]);
				if (cneeAddr3[i] != null)
					model.setCneeAddr3(cneeAddr3[i]);
				if (shprAddr2[i] != null)
					model.setShprAddr2(shprAddr2[i]);
				if (shprAddr3[i] != null)
					model.setShprAddr3(shprAddr3[i]);
				if (shprAddr1[i] != null)
					model.setShprAddr1(shprAddr1[i]);
				if (shprAddr4[i] != null)
					model.setShprAddr4(shprAddr4[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapanManifestListBlCustInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapanManifestListBlCustInfoVO[]
	 */
	public JapanManifestListBlCustInfoVO[] getJapanManifestListBlCustInfoVOs(){
		JapanManifestListBlCustInfoVO[] vos = (JapanManifestListBlCustInfoVO[])models.toArray(new JapanManifestListBlCustInfoVO[models.size()]);
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
		this.ntfy1Addr1 = this.ntfy1Addr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCd = this.cneeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy1Addr2 = this.ntfy1Addr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy1Addr3 = this.ntfy1Addr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm1 = this.shprNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy1Addr4 = this.ntfy1Addr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy1CntCd = this.ntfy1CntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm2 = this.shprNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2Addr1 = this.ntfy2Addr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2PhnNo = this.ntfy2PhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2Addr2 = this.ntfy2Addr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2Addr3 = this.ntfy2Addr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprPostId = this.shprPostId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2Addr4 = this.ntfy2Addr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2PostId = this.ntfy2PostId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCntCd = this.cneeCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneePhnNo = this.cneePhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneePostId = this.cneePostId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy1PostId = this.ntfy1PostId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCd = this.shprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy1Cd = this.ntfy1Cd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddr4 = this.cneeAddr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprPhnNo = this.shprPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm1 = this.cneeNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntCd = this.shprCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm2 = this.cneeNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy1Nm2 = this.ntfy1Nm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy1Nm1 = this.ntfy1Nm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy1PhnNo = this.ntfy1PhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2Nm2 = this.ntfy2Nm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddr1 = this.cneeAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2Nm1 = this.ntfy2Nm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2Cd = this.ntfy2Cd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddr2 = this.cneeAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2CntCd = this.ntfy2CntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddr3 = this.cneeAddr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddr2 = this.shprAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddr3 = this.shprAddr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddr1 = this.shprAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddr4 = this.shprAddr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

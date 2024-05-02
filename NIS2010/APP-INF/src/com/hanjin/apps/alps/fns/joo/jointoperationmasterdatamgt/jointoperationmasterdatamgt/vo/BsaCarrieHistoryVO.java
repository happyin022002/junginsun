/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BsaCarrieHistoryVO.java
*@FileTitle : BsaCarrieHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.16
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.09.16 최덕우 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo;

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
 * @author 최덕우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BsaCarrieHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BsaCarrieHistoryVO> models = new ArrayList<BsaCarrieHistoryVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String joAddCrrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String joAddCrrCd10 = null;
	/* Column Info */
	private String joBsaAddRefSeq10 = null;
	/* Column Info */
	private String oldJoAddCrrCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String joBsaAddRefSeq9 = null;
	/* Column Info */
	private String joBsaAddRefSeq8 = null;
	/* Column Info */
	private String joBsaAddRefSeq7 = null;
	/* Column Info */
	private String joBsaAddRefSeq6 = null;
	/* Column Info */
	private String joBsaAddRefSeq5 = null;
	/* Column Info */
	private String joBsaAddRefSeq4 = null;
	/* Column Info */
	private String joBsaAddRefSeq3 = null;
	/* Column Info */
	private String joBsaAddRefSeq2 = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String joBsaAddRefSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String joBsaAddRefSeq1 = null;
	/* Column Info */
	private String bsa = null;
	/* Column Info */
	private String joAddCrrCd8 = null;
	/* Column Info */
	private String udpFlg = null;
	/* Column Info */
	private String joAddCrrCd9 = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vvdPort = null;
	/* Column Info */
	private String creDtTo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bsa9 = null;
	/* Column Info */
	private String oldJoAddCrrCd9 = null;
	/* Column Info */
	private String bsa8 = null;
	/* Column Info */
	private String oldJoAddCrrCd8 = null;
	/* Column Info */
	private String oldJoAddCrrCd7 = null;
	/* Column Info */
	private String joAddCrrCd3 = null;
	/* Column Info */
	private String oldJoAddCrrCd6 = null;
	/* Column Info */
	private String bsa5 = null;
	/* Column Info */
	private String oldJoAddCrrCd5 = null;
	/* Column Info */
	private String bsa4 = null;
	/* Column Info */
	private String joAddCrrCd2 = null;
	/* Column Info */
	private String oldJoAddCrrCd4 = null;
	/* Column Info */
	private String bsa7 = null;
	/* Column Info */
	private String joAddCrrCd1 = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String oldJoAddCrrCd3 = null;
	/* Column Info */
	private String bsa6 = null;
	/* Column Info */
	private String oldJoAddCrrCd2 = null;
	/* Column Info */
	private String bsa1 = null;
	/* Column Info */
	private String joAddCrrCd7 = null;
	/* Column Info */
	private String joAddCrrCd6 = null;
	/* Column Info */
	private String oldJoAddCrrCd1 = null;
	/* Column Info */
	private String bsa3 = null;
	/* Column Info */
	private String joAddCrrCd5 = null;
	/* Column Info */
	private String joAddCrrCd4 = null;
	/* Column Info */
	private String bsa2 = null;
	/* Column Info */
	private String bsa10 = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String joVerFlg = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String portSeq = null;
	/* Column Info */
	private String oldJoAddCrrCd10 = null;
	/* Column Info */
	private String updUsrNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BsaCarrieHistoryVO() {}

	public BsaCarrieHistoryVO(String ibflag, String pagerows, String oldJoAddCrrCd2, String oldJoAddCrrCd3, String oldJoAddCrrCd1, String oldJoAddCrrCd6, String joBsaAddRefSeq10, String oldJoAddCrrCd7, String oldJoAddCrrCd4, String oldJoAddCrrCd5, String oldJoAddCrrCd8, String oldJoAddCrrCd9, String updUsrId, String joBsaAddRefSeq9, String joBsaAddRefSeq8, String joBsaAddRefSeq7, String joBsaAddRefSeq6, String joBsaAddRefSeq5, String joBsaAddRefSeq4, String joBsaAddRefSeq3, String joBsaAddRefSeq2, String joBsaAddRefSeq, String creUsrId, String bsa, String joBsaAddRefSeq1, String udpFlg, String creDt, String creDtTo, String joAddCrrCd10, String oldJoAddCrrCd, String bsa9, String bsa8, String bsa5, String bsa4, String bsa7, String bsa6, String bsa1, String bsa3, String bsa2, String joAddCrrCd9, String joAddCrrCd7, String joAddCrrCd8, String bsa10, String oldJoAddCrrCd10, String joAddCrrCd1, String joAddCrrCd, String joAddCrrCd2, String joVerFlg, String joAddCrrCd5, String joAddCrrCd6, String joAddCrrCd3, String joAddCrrCd4, String updUsrNm, String vslCd, String skdVoyNo, String skdDirCd, String portCd, String portSeq, String vvdPort, String joCrrCd) {
		this.vslCd = vslCd;
		this.joAddCrrCd = joAddCrrCd;
		this.pagerows = pagerows;
		this.joAddCrrCd10 = joAddCrrCd10;
		this.joBsaAddRefSeq10 = joBsaAddRefSeq10;
		this.oldJoAddCrrCd = oldJoAddCrrCd;
		this.updUsrId = updUsrId;
		this.joBsaAddRefSeq9 = joBsaAddRefSeq9;
		this.joBsaAddRefSeq8 = joBsaAddRefSeq8;
		this.joBsaAddRefSeq7 = joBsaAddRefSeq7;
		this.joBsaAddRefSeq6 = joBsaAddRefSeq6;
		this.joBsaAddRefSeq5 = joBsaAddRefSeq5;
		this.joBsaAddRefSeq4 = joBsaAddRefSeq4;
		this.joBsaAddRefSeq3 = joBsaAddRefSeq3;
		this.joBsaAddRefSeq2 = joBsaAddRefSeq2;
		this.skdVoyNo = skdVoyNo;
		this.joBsaAddRefSeq = joBsaAddRefSeq;
		this.creUsrId = creUsrId;
		this.joBsaAddRefSeq1 = joBsaAddRefSeq1;
		this.bsa = bsa;
		this.joAddCrrCd8 = joAddCrrCd8;
		this.udpFlg = udpFlg;
		this.joAddCrrCd9 = joAddCrrCd9;
		this.creDt = creDt;
		this.vvdPort = vvdPort;
		this.creDtTo = creDtTo;
		this.ibflag = ibflag;
		this.bsa9 = bsa9;
		this.oldJoAddCrrCd9 = oldJoAddCrrCd9;
		this.bsa8 = bsa8;
		this.oldJoAddCrrCd8 = oldJoAddCrrCd8;
		this.oldJoAddCrrCd7 = oldJoAddCrrCd7;
		this.joAddCrrCd3 = joAddCrrCd3;
		this.oldJoAddCrrCd6 = oldJoAddCrrCd6;
		this.bsa5 = bsa5;
		this.oldJoAddCrrCd5 = oldJoAddCrrCd5;
		this.bsa4 = bsa4;
		this.joAddCrrCd2 = joAddCrrCd2;
		this.oldJoAddCrrCd4 = oldJoAddCrrCd4;
		this.bsa7 = bsa7;
		this.joAddCrrCd1 = joAddCrrCd1;
		this.portCd = portCd;
		this.oldJoAddCrrCd3 = oldJoAddCrrCd3;
		this.bsa6 = bsa6;
		this.oldJoAddCrrCd2 = oldJoAddCrrCd2;
		this.bsa1 = bsa1;
		this.joAddCrrCd7 = joAddCrrCd7;
		this.joAddCrrCd6 = joAddCrrCd6;
		this.oldJoAddCrrCd1 = oldJoAddCrrCd1;
		this.bsa3 = bsa3;
		this.joAddCrrCd5 = joAddCrrCd5;
		this.joAddCrrCd4 = joAddCrrCd4;
		this.bsa2 = bsa2;
		this.bsa10 = bsa10;
		this.joCrrCd = joCrrCd;
		this.joVerFlg = joVerFlg;
		this.skdDirCd = skdDirCd;
		this.portSeq = portSeq;
		this.oldJoAddCrrCd10 = oldJoAddCrrCd10;
		this.updUsrNm = updUsrNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("jo_add_crr_cd", getJoAddCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("jo_add_crr_cd10", getJoAddCrrCd10());
		this.hashColumns.put("jo_bsa_add_ref_seq10", getJoBsaAddRefSeq10());
		this.hashColumns.put("old_jo_add_crr_cd", getOldJoAddCrrCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("jo_bsa_add_ref_seq9", getJoBsaAddRefSeq9());
		this.hashColumns.put("jo_bsa_add_ref_seq8", getJoBsaAddRefSeq8());
		this.hashColumns.put("jo_bsa_add_ref_seq7", getJoBsaAddRefSeq7());
		this.hashColumns.put("jo_bsa_add_ref_seq6", getJoBsaAddRefSeq6());
		this.hashColumns.put("jo_bsa_add_ref_seq5", getJoBsaAddRefSeq5());
		this.hashColumns.put("jo_bsa_add_ref_seq4", getJoBsaAddRefSeq4());
		this.hashColumns.put("jo_bsa_add_ref_seq3", getJoBsaAddRefSeq3());
		this.hashColumns.put("jo_bsa_add_ref_seq2", getJoBsaAddRefSeq2());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("jo_bsa_add_ref_seq", getJoBsaAddRefSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("jo_bsa_add_ref_seq1", getJoBsaAddRefSeq1());
		this.hashColumns.put("bsa", getBsa());
		this.hashColumns.put("jo_add_crr_cd8", getJoAddCrrCd8());
		this.hashColumns.put("udp_flg", getUdpFlg());
		this.hashColumns.put("jo_add_crr_cd9", getJoAddCrrCd9());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vvd_port", getVvdPort());
		this.hashColumns.put("cre_dt_to", getCreDtTo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bsa9", getBsa9());
		this.hashColumns.put("old_jo_add_crr_cd9", getOldJoAddCrrCd9());
		this.hashColumns.put("bsa8", getBsa8());
		this.hashColumns.put("old_jo_add_crr_cd8", getOldJoAddCrrCd8());
		this.hashColumns.put("old_jo_add_crr_cd7", getOldJoAddCrrCd7());
		this.hashColumns.put("jo_add_crr_cd3", getJoAddCrrCd3());
		this.hashColumns.put("old_jo_add_crr_cd6", getOldJoAddCrrCd6());
		this.hashColumns.put("bsa5", getBsa5());
		this.hashColumns.put("old_jo_add_crr_cd5", getOldJoAddCrrCd5());
		this.hashColumns.put("bsa4", getBsa4());
		this.hashColumns.put("jo_add_crr_cd2", getJoAddCrrCd2());
		this.hashColumns.put("old_jo_add_crr_cd4", getOldJoAddCrrCd4());
		this.hashColumns.put("bsa7", getBsa7());
		this.hashColumns.put("jo_add_crr_cd1", getJoAddCrrCd1());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("old_jo_add_crr_cd3", getOldJoAddCrrCd3());
		this.hashColumns.put("bsa6", getBsa6());
		this.hashColumns.put("old_jo_add_crr_cd2", getOldJoAddCrrCd2());
		this.hashColumns.put("bsa1", getBsa1());
		this.hashColumns.put("jo_add_crr_cd7", getJoAddCrrCd7());
		this.hashColumns.put("jo_add_crr_cd6", getJoAddCrrCd6());
		this.hashColumns.put("old_jo_add_crr_cd1", getOldJoAddCrrCd1());
		this.hashColumns.put("bsa3", getBsa3());
		this.hashColumns.put("jo_add_crr_cd5", getJoAddCrrCd5());
		this.hashColumns.put("jo_add_crr_cd4", getJoAddCrrCd4());
		this.hashColumns.put("bsa2", getBsa2());
		this.hashColumns.put("bsa10", getBsa10());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("jo_ver_flg", getJoVerFlg());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("port_seq", getPortSeq());
		this.hashColumns.put("old_jo_add_crr_cd10", getOldJoAddCrrCd10());
		this.hashColumns.put("upd_usr_nm", getUpdUsrNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("jo_add_crr_cd", "joAddCrrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("jo_add_crr_cd10", "joAddCrrCd10");
		this.hashFields.put("jo_bsa_add_ref_seq10", "joBsaAddRefSeq10");
		this.hashFields.put("old_jo_add_crr_cd", "oldJoAddCrrCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("jo_bsa_add_ref_seq9", "joBsaAddRefSeq9");
		this.hashFields.put("jo_bsa_add_ref_seq8", "joBsaAddRefSeq8");
		this.hashFields.put("jo_bsa_add_ref_seq7", "joBsaAddRefSeq7");
		this.hashFields.put("jo_bsa_add_ref_seq6", "joBsaAddRefSeq6");
		this.hashFields.put("jo_bsa_add_ref_seq5", "joBsaAddRefSeq5");
		this.hashFields.put("jo_bsa_add_ref_seq4", "joBsaAddRefSeq4");
		this.hashFields.put("jo_bsa_add_ref_seq3", "joBsaAddRefSeq3");
		this.hashFields.put("jo_bsa_add_ref_seq2", "joBsaAddRefSeq2");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("jo_bsa_add_ref_seq", "joBsaAddRefSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("jo_bsa_add_ref_seq1", "joBsaAddRefSeq1");
		this.hashFields.put("bsa", "bsa");
		this.hashFields.put("jo_add_crr_cd8", "joAddCrrCd8");
		this.hashFields.put("udp_flg", "udpFlg");
		this.hashFields.put("jo_add_crr_cd9", "joAddCrrCd9");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vvd_port", "vvdPort");
		this.hashFields.put("cre_dt_to", "creDtTo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bsa9", "bsa9");
		this.hashFields.put("old_jo_add_crr_cd9", "oldJoAddCrrCd9");
		this.hashFields.put("bsa8", "bsa8");
		this.hashFields.put("old_jo_add_crr_cd8", "oldJoAddCrrCd8");
		this.hashFields.put("old_jo_add_crr_cd7", "oldJoAddCrrCd7");
		this.hashFields.put("jo_add_crr_cd3", "joAddCrrCd3");
		this.hashFields.put("old_jo_add_crr_cd6", "oldJoAddCrrCd6");
		this.hashFields.put("bsa5", "bsa5");
		this.hashFields.put("old_jo_add_crr_cd5", "oldJoAddCrrCd5");
		this.hashFields.put("bsa4", "bsa4");
		this.hashFields.put("jo_add_crr_cd2", "joAddCrrCd2");
		this.hashFields.put("old_jo_add_crr_cd4", "oldJoAddCrrCd4");
		this.hashFields.put("bsa7", "bsa7");
		this.hashFields.put("jo_add_crr_cd1", "joAddCrrCd1");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("old_jo_add_crr_cd3", "oldJoAddCrrCd3");
		this.hashFields.put("bsa6", "bsa6");
		this.hashFields.put("old_jo_add_crr_cd2", "oldJoAddCrrCd2");
		this.hashFields.put("bsa1", "bsa1");
		this.hashFields.put("jo_add_crr_cd7", "joAddCrrCd7");
		this.hashFields.put("jo_add_crr_cd6", "joAddCrrCd6");
		this.hashFields.put("old_jo_add_crr_cd1", "oldJoAddCrrCd1");
		this.hashFields.put("bsa3", "bsa3");
		this.hashFields.put("jo_add_crr_cd5", "joAddCrrCd5");
		this.hashFields.put("jo_add_crr_cd4", "joAddCrrCd4");
		this.hashFields.put("bsa2", "bsa2");
		this.hashFields.put("bsa10", "bsa10");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("jo_ver_flg", "joVerFlg");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("port_seq", "portSeq");
		this.hashFields.put("old_jo_add_crr_cd10", "oldJoAddCrrCd10");
		this.hashFields.put("upd_usr_nm", "updUsrNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return joAddCrrCd
	 */
	public String getJoAddCrrCd() {
		return this.joAddCrrCd;
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
	 * @return joAddCrrCd10
	 */
	public String getJoAddCrrCd10() {
		return this.joAddCrrCd10;
	}
	
	/**
	 * Column Info
	 * @return joBsaAddRefSeq10
	 */
	public String getJoBsaAddRefSeq10() {
		return this.joBsaAddRefSeq10;
	}
	
	/**
	 * Column Info
	 * @return oldJoAddCrrCd
	 */
	public String getOldJoAddCrrCd() {
		return this.oldJoAddCrrCd;
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
	 * @return joBsaAddRefSeq9
	 */
	public String getJoBsaAddRefSeq9() {
		return this.joBsaAddRefSeq9;
	}
	
	/**
	 * Column Info
	 * @return joBsaAddRefSeq8
	 */
	public String getJoBsaAddRefSeq8() {
		return this.joBsaAddRefSeq8;
	}
	
	/**
	 * Column Info
	 * @return joBsaAddRefSeq7
	 */
	public String getJoBsaAddRefSeq7() {
		return this.joBsaAddRefSeq7;
	}
	
	/**
	 * Column Info
	 * @return joBsaAddRefSeq6
	 */
	public String getJoBsaAddRefSeq6() {
		return this.joBsaAddRefSeq6;
	}
	
	/**
	 * Column Info
	 * @return joBsaAddRefSeq5
	 */
	public String getJoBsaAddRefSeq5() {
		return this.joBsaAddRefSeq5;
	}
	
	/**
	 * Column Info
	 * @return joBsaAddRefSeq4
	 */
	public String getJoBsaAddRefSeq4() {
		return this.joBsaAddRefSeq4;
	}
	
	/**
	 * Column Info
	 * @return joBsaAddRefSeq3
	 */
	public String getJoBsaAddRefSeq3() {
		return this.joBsaAddRefSeq3;
	}
	
	/**
	 * Column Info
	 * @return joBsaAddRefSeq2
	 */
	public String getJoBsaAddRefSeq2() {
		return this.joBsaAddRefSeq2;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return joBsaAddRefSeq
	 */
	public String getJoBsaAddRefSeq() {
		return this.joBsaAddRefSeq;
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
	 * @return joBsaAddRefSeq1
	 */
	public String getJoBsaAddRefSeq1() {
		return this.joBsaAddRefSeq1;
	}
	
	/**
	 * Column Info
	 * @return bsa
	 */
	public String getBsa() {
		return this.bsa;
	}
	
	/**
	 * Column Info
	 * @return joAddCrrCd8
	 */
	public String getJoAddCrrCd8() {
		return this.joAddCrrCd8;
	}
	
	/**
	 * Column Info
	 * @return udpFlg
	 */
	public String getUdpFlg() {
		return this.udpFlg;
	}
	
	/**
	 * Column Info
	 * @return joAddCrrCd9
	 */
	public String getJoAddCrrCd9() {
		return this.joAddCrrCd9;
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
	 * @return vvdPort
	 */
	public String getVvdPort() {
		return this.vvdPort;
	}
	
	/**
	 * Column Info
	 * @return creDtTo
	 */
	public String getCreDtTo() {
		return this.creDtTo;
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
	 * @return bsa9
	 */
	public String getBsa9() {
		return this.bsa9;
	}
	
	/**
	 * Column Info
	 * @return oldJoAddCrrCd9
	 */
	public String getOldJoAddCrrCd9() {
		return this.oldJoAddCrrCd9;
	}
	
	/**
	 * Column Info
	 * @return bsa8
	 */
	public String getBsa8() {
		return this.bsa8;
	}
	
	/**
	 * Column Info
	 * @return oldJoAddCrrCd8
	 */
	public String getOldJoAddCrrCd8() {
		return this.oldJoAddCrrCd8;
	}
	
	/**
	 * Column Info
	 * @return oldJoAddCrrCd7
	 */
	public String getOldJoAddCrrCd7() {
		return this.oldJoAddCrrCd7;
	}
	
	/**
	 * Column Info
	 * @return joAddCrrCd3
	 */
	public String getJoAddCrrCd3() {
		return this.joAddCrrCd3;
	}
	
	/**
	 * Column Info
	 * @return oldJoAddCrrCd6
	 */
	public String getOldJoAddCrrCd6() {
		return this.oldJoAddCrrCd6;
	}
	
	/**
	 * Column Info
	 * @return bsa5
	 */
	public String getBsa5() {
		return this.bsa5;
	}
	
	/**
	 * Column Info
	 * @return oldJoAddCrrCd5
	 */
	public String getOldJoAddCrrCd5() {
		return this.oldJoAddCrrCd5;
	}
	
	/**
	 * Column Info
	 * @return bsa4
	 */
	public String getBsa4() {
		return this.bsa4;
	}
	
	/**
	 * Column Info
	 * @return joAddCrrCd2
	 */
	public String getJoAddCrrCd2() {
		return this.joAddCrrCd2;
	}
	
	/**
	 * Column Info
	 * @return oldJoAddCrrCd4
	 */
	public String getOldJoAddCrrCd4() {
		return this.oldJoAddCrrCd4;
	}
	
	/**
	 * Column Info
	 * @return bsa7
	 */
	public String getBsa7() {
		return this.bsa7;
	}
	
	/**
	 * Column Info
	 * @return joAddCrrCd1
	 */
	public String getJoAddCrrCd1() {
		return this.joAddCrrCd1;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return oldJoAddCrrCd3
	 */
	public String getOldJoAddCrrCd3() {
		return this.oldJoAddCrrCd3;
	}
	
	/**
	 * Column Info
	 * @return bsa6
	 */
	public String getBsa6() {
		return this.bsa6;
	}
	
	/**
	 * Column Info
	 * @return oldJoAddCrrCd2
	 */
	public String getOldJoAddCrrCd2() {
		return this.oldJoAddCrrCd2;
	}
	
	/**
	 * Column Info
	 * @return bsa1
	 */
	public String getBsa1() {
		return this.bsa1;
	}
	
	/**
	 * Column Info
	 * @return joAddCrrCd7
	 */
	public String getJoAddCrrCd7() {
		return this.joAddCrrCd7;
	}
	
	/**
	 * Column Info
	 * @return joAddCrrCd6
	 */
	public String getJoAddCrrCd6() {
		return this.joAddCrrCd6;
	}
	
	/**
	 * Column Info
	 * @return oldJoAddCrrCd1
	 */
	public String getOldJoAddCrrCd1() {
		return this.oldJoAddCrrCd1;
	}
	
	/**
	 * Column Info
	 * @return bsa3
	 */
	public String getBsa3() {
		return this.bsa3;
	}
	
	/**
	 * Column Info
	 * @return joAddCrrCd5
	 */
	public String getJoAddCrrCd5() {
		return this.joAddCrrCd5;
	}
	
	/**
	 * Column Info
	 * @return joAddCrrCd4
	 */
	public String getJoAddCrrCd4() {
		return this.joAddCrrCd4;
	}
	
	/**
	 * Column Info
	 * @return bsa2
	 */
	public String getBsa2() {
		return this.bsa2;
	}
	
	/**
	 * Column Info
	 * @return bsa10
	 */
	public String getBsa10() {
		return this.bsa10;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd
	 */
	public String getJoCrrCd() {
		return this.joCrrCd;
	}
	
	/**
	 * Column Info
	 * @return joVerFlg
	 */
	public String getJoVerFlg() {
		return this.joVerFlg;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return portSeq
	 */
	public String getPortSeq() {
		return this.portSeq;
	}
	
	/**
	 * Column Info
	 * @return oldJoAddCrrCd10
	 */
	public String getOldJoAddCrrCd10() {
		return this.oldJoAddCrrCd10;
	}
	
	/**
	 * Column Info
	 * @return updUsrNm
	 */
	public String getUpdUsrNm() {
		return this.updUsrNm;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param joAddCrrCd
	 */
	public void setJoAddCrrCd(String joAddCrrCd) {
		this.joAddCrrCd = joAddCrrCd;
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
	 * @param joAddCrrCd10
	 */
	public void setJoAddCrrCd10(String joAddCrrCd10) {
		this.joAddCrrCd10 = joAddCrrCd10;
	}
	
	/**
	 * Column Info
	 * @param joBsaAddRefSeq10
	 */
	public void setJoBsaAddRefSeq10(String joBsaAddRefSeq10) {
		this.joBsaAddRefSeq10 = joBsaAddRefSeq10;
	}
	
	/**
	 * Column Info
	 * @param oldJoAddCrrCd
	 */
	public void setOldJoAddCrrCd(String oldJoAddCrrCd) {
		this.oldJoAddCrrCd = oldJoAddCrrCd;
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
	 * @param joBsaAddRefSeq9
	 */
	public void setJoBsaAddRefSeq9(String joBsaAddRefSeq9) {
		this.joBsaAddRefSeq9 = joBsaAddRefSeq9;
	}
	
	/**
	 * Column Info
	 * @param joBsaAddRefSeq8
	 */
	public void setJoBsaAddRefSeq8(String joBsaAddRefSeq8) {
		this.joBsaAddRefSeq8 = joBsaAddRefSeq8;
	}
	
	/**
	 * Column Info
	 * @param joBsaAddRefSeq7
	 */
	public void setJoBsaAddRefSeq7(String joBsaAddRefSeq7) {
		this.joBsaAddRefSeq7 = joBsaAddRefSeq7;
	}
	
	/**
	 * Column Info
	 * @param joBsaAddRefSeq6
	 */
	public void setJoBsaAddRefSeq6(String joBsaAddRefSeq6) {
		this.joBsaAddRefSeq6 = joBsaAddRefSeq6;
	}
	
	/**
	 * Column Info
	 * @param joBsaAddRefSeq5
	 */
	public void setJoBsaAddRefSeq5(String joBsaAddRefSeq5) {
		this.joBsaAddRefSeq5 = joBsaAddRefSeq5;
	}
	
	/**
	 * Column Info
	 * @param joBsaAddRefSeq4
	 */
	public void setJoBsaAddRefSeq4(String joBsaAddRefSeq4) {
		this.joBsaAddRefSeq4 = joBsaAddRefSeq4;
	}
	
	/**
	 * Column Info
	 * @param joBsaAddRefSeq3
	 */
	public void setJoBsaAddRefSeq3(String joBsaAddRefSeq3) {
		this.joBsaAddRefSeq3 = joBsaAddRefSeq3;
	}
	
	/**
	 * Column Info
	 * @param joBsaAddRefSeq2
	 */
	public void setJoBsaAddRefSeq2(String joBsaAddRefSeq2) {
		this.joBsaAddRefSeq2 = joBsaAddRefSeq2;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param joBsaAddRefSeq
	 */
	public void setJoBsaAddRefSeq(String joBsaAddRefSeq) {
		this.joBsaAddRefSeq = joBsaAddRefSeq;
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
	 * @param joBsaAddRefSeq1
	 */
	public void setJoBsaAddRefSeq1(String joBsaAddRefSeq1) {
		this.joBsaAddRefSeq1 = joBsaAddRefSeq1;
	}
	
	/**
	 * Column Info
	 * @param bsa
	 */
	public void setBsa(String bsa) {
		this.bsa = bsa;
	}
	
	/**
	 * Column Info
	 * @param joAddCrrCd8
	 */
	public void setJoAddCrrCd8(String joAddCrrCd8) {
		this.joAddCrrCd8 = joAddCrrCd8;
	}
	
	/**
	 * Column Info
	 * @param udpFlg
	 */
	public void setUdpFlg(String udpFlg) {
		this.udpFlg = udpFlg;
	}
	
	/**
	 * Column Info
	 * @param joAddCrrCd9
	 */
	public void setJoAddCrrCd9(String joAddCrrCd9) {
		this.joAddCrrCd9 = joAddCrrCd9;
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
	 * @param vvdPort
	 */
	public void setVvdPort(String vvdPort) {
		this.vvdPort = vvdPort;
	}
	
	/**
	 * Column Info
	 * @param creDtTo
	 */
	public void setCreDtTo(String creDtTo) {
		this.creDtTo = creDtTo;
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
	 * @param bsa9
	 */
	public void setBsa9(String bsa9) {
		this.bsa9 = bsa9;
	}
	
	/**
	 * Column Info
	 * @param oldJoAddCrrCd9
	 */
	public void setOldJoAddCrrCd9(String oldJoAddCrrCd9) {
		this.oldJoAddCrrCd9 = oldJoAddCrrCd9;
	}
	
	/**
	 * Column Info
	 * @param bsa8
	 */
	public void setBsa8(String bsa8) {
		this.bsa8 = bsa8;
	}
	
	/**
	 * Column Info
	 * @param oldJoAddCrrCd8
	 */
	public void setOldJoAddCrrCd8(String oldJoAddCrrCd8) {
		this.oldJoAddCrrCd8 = oldJoAddCrrCd8;
	}
	
	/**
	 * Column Info
	 * @param oldJoAddCrrCd7
	 */
	public void setOldJoAddCrrCd7(String oldJoAddCrrCd7) {
		this.oldJoAddCrrCd7 = oldJoAddCrrCd7;
	}
	
	/**
	 * Column Info
	 * @param joAddCrrCd3
	 */
	public void setJoAddCrrCd3(String joAddCrrCd3) {
		this.joAddCrrCd3 = joAddCrrCd3;
	}
	
	/**
	 * Column Info
	 * @param oldJoAddCrrCd6
	 */
	public void setOldJoAddCrrCd6(String oldJoAddCrrCd6) {
		this.oldJoAddCrrCd6 = oldJoAddCrrCd6;
	}
	
	/**
	 * Column Info
	 * @param bsa5
	 */
	public void setBsa5(String bsa5) {
		this.bsa5 = bsa5;
	}
	
	/**
	 * Column Info
	 * @param oldJoAddCrrCd5
	 */
	public void setOldJoAddCrrCd5(String oldJoAddCrrCd5) {
		this.oldJoAddCrrCd5 = oldJoAddCrrCd5;
	}
	
	/**
	 * Column Info
	 * @param bsa4
	 */
	public void setBsa4(String bsa4) {
		this.bsa4 = bsa4;
	}
	
	/**
	 * Column Info
	 * @param joAddCrrCd2
	 */
	public void setJoAddCrrCd2(String joAddCrrCd2) {
		this.joAddCrrCd2 = joAddCrrCd2;
	}
	
	/**
	 * Column Info
	 * @param oldJoAddCrrCd4
	 */
	public void setOldJoAddCrrCd4(String oldJoAddCrrCd4) {
		this.oldJoAddCrrCd4 = oldJoAddCrrCd4;
	}
	
	/**
	 * Column Info
	 * @param bsa7
	 */
	public void setBsa7(String bsa7) {
		this.bsa7 = bsa7;
	}
	
	/**
	 * Column Info
	 * @param joAddCrrCd1
	 */
	public void setJoAddCrrCd1(String joAddCrrCd1) {
		this.joAddCrrCd1 = joAddCrrCd1;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param oldJoAddCrrCd3
	 */
	public void setOldJoAddCrrCd3(String oldJoAddCrrCd3) {
		this.oldJoAddCrrCd3 = oldJoAddCrrCd3;
	}
	
	/**
	 * Column Info
	 * @param bsa6
	 */
	public void setBsa6(String bsa6) {
		this.bsa6 = bsa6;
	}
	
	/**
	 * Column Info
	 * @param oldJoAddCrrCd2
	 */
	public void setOldJoAddCrrCd2(String oldJoAddCrrCd2) {
		this.oldJoAddCrrCd2 = oldJoAddCrrCd2;
	}
	
	/**
	 * Column Info
	 * @param bsa1
	 */
	public void setBsa1(String bsa1) {
		this.bsa1 = bsa1;
	}
	
	/**
	 * Column Info
	 * @param joAddCrrCd7
	 */
	public void setJoAddCrrCd7(String joAddCrrCd7) {
		this.joAddCrrCd7 = joAddCrrCd7;
	}
	
	/**
	 * Column Info
	 * @param joAddCrrCd6
	 */
	public void setJoAddCrrCd6(String joAddCrrCd6) {
		this.joAddCrrCd6 = joAddCrrCd6;
	}
	
	/**
	 * Column Info
	 * @param oldJoAddCrrCd1
	 */
	public void setOldJoAddCrrCd1(String oldJoAddCrrCd1) {
		this.oldJoAddCrrCd1 = oldJoAddCrrCd1;
	}
	
	/**
	 * Column Info
	 * @param bsa3
	 */
	public void setBsa3(String bsa3) {
		this.bsa3 = bsa3;
	}
	
	/**
	 * Column Info
	 * @param joAddCrrCd5
	 */
	public void setJoAddCrrCd5(String joAddCrrCd5) {
		this.joAddCrrCd5 = joAddCrrCd5;
	}
	
	/**
	 * Column Info
	 * @param joAddCrrCd4
	 */
	public void setJoAddCrrCd4(String joAddCrrCd4) {
		this.joAddCrrCd4 = joAddCrrCd4;
	}
	
	/**
	 * Column Info
	 * @param bsa2
	 */
	public void setBsa2(String bsa2) {
		this.bsa2 = bsa2;
	}
	
	/**
	 * Column Info
	 * @param bsa10
	 */
	public void setBsa10(String bsa10) {
		this.bsa10 = bsa10;
	}
	
	/**
	 * Column Info
	 * @param joCrrCd
	 */
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
	}
	
	/**
	 * Column Info
	 * @param joVerFlg
	 */
	public void setJoVerFlg(String joVerFlg) {
		this.joVerFlg = joVerFlg;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param portSeq
	 */
	public void setPortSeq(String portSeq) {
		this.portSeq = portSeq;
	}
	
	/**
	 * Column Info
	 * @param oldJoAddCrrCd10
	 */
	public void setOldJoAddCrrCd10(String oldJoAddCrrCd10) {
		this.oldJoAddCrrCd10 = oldJoAddCrrCd10;
	}
	
	/**
	 * Column Info
	 * @param updUsrNm
	 */
	public void setUpdUsrNm(String updUsrNm) {
		this.updUsrNm = updUsrNm;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setJoAddCrrCd(JSPUtil.getParameter(request, prefix + "jo_add_crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setJoAddCrrCd10(JSPUtil.getParameter(request, prefix + "jo_add_crr_cd10", ""));
		setJoBsaAddRefSeq10(JSPUtil.getParameter(request, prefix + "jo_bsa_add_ref_seq10", ""));
		setOldJoAddCrrCd(JSPUtil.getParameter(request, prefix + "old_jo_add_crr_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setJoBsaAddRefSeq9(JSPUtil.getParameter(request, prefix + "jo_bsa_add_ref_seq9", ""));
		setJoBsaAddRefSeq8(JSPUtil.getParameter(request, prefix + "jo_bsa_add_ref_seq8", ""));
		setJoBsaAddRefSeq7(JSPUtil.getParameter(request, prefix + "jo_bsa_add_ref_seq7", ""));
		setJoBsaAddRefSeq6(JSPUtil.getParameter(request, prefix + "jo_bsa_add_ref_seq6", ""));
		setJoBsaAddRefSeq5(JSPUtil.getParameter(request, prefix + "jo_bsa_add_ref_seq5", ""));
		setJoBsaAddRefSeq4(JSPUtil.getParameter(request, prefix + "jo_bsa_add_ref_seq4", ""));
		setJoBsaAddRefSeq3(JSPUtil.getParameter(request, prefix + "jo_bsa_add_ref_seq3", ""));
		setJoBsaAddRefSeq2(JSPUtil.getParameter(request, prefix + "jo_bsa_add_ref_seq2", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setJoBsaAddRefSeq(JSPUtil.getParameter(request, prefix + "jo_bsa_add_ref_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setJoBsaAddRefSeq1(JSPUtil.getParameter(request, prefix + "jo_bsa_add_ref_seq1", ""));
		setBsa(JSPUtil.getParameter(request, prefix + "bsa", ""));
		setJoAddCrrCd8(JSPUtil.getParameter(request, prefix + "jo_add_crr_cd8", ""));
		setUdpFlg(JSPUtil.getParameter(request, prefix + "udp_flg", ""));
		setJoAddCrrCd9(JSPUtil.getParameter(request, prefix + "jo_add_crr_cd9", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setVvdPort(JSPUtil.getParameter(request, prefix + "vvd_port", ""));
		setCreDtTo(JSPUtil.getParameter(request, prefix + "cre_dt_to", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBsa9(JSPUtil.getParameter(request, prefix + "bsa9", ""));
		setOldJoAddCrrCd9(JSPUtil.getParameter(request, prefix + "old_jo_add_crr_cd9", ""));
		setBsa8(JSPUtil.getParameter(request, prefix + "bsa8", ""));
		setOldJoAddCrrCd8(JSPUtil.getParameter(request, prefix + "old_jo_add_crr_cd8", ""));
		setOldJoAddCrrCd7(JSPUtil.getParameter(request, prefix + "old_jo_add_crr_cd7", ""));
		setJoAddCrrCd3(JSPUtil.getParameter(request, prefix + "jo_add_crr_cd3", ""));
		setOldJoAddCrrCd6(JSPUtil.getParameter(request, prefix + "old_jo_add_crr_cd6", ""));
		setBsa5(JSPUtil.getParameter(request, prefix + "bsa5", ""));
		setOldJoAddCrrCd5(JSPUtil.getParameter(request, prefix + "old_jo_add_crr_cd5", ""));
		setBsa4(JSPUtil.getParameter(request, prefix + "bsa4", ""));
		setJoAddCrrCd2(JSPUtil.getParameter(request, prefix + "jo_add_crr_cd2", ""));
		setOldJoAddCrrCd4(JSPUtil.getParameter(request, prefix + "old_jo_add_crr_cd4", ""));
		setBsa7(JSPUtil.getParameter(request, prefix + "bsa7", ""));
		setJoAddCrrCd1(JSPUtil.getParameter(request, prefix + "jo_add_crr_cd1", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setOldJoAddCrrCd3(JSPUtil.getParameter(request, prefix + "old_jo_add_crr_cd3", ""));
		setBsa6(JSPUtil.getParameter(request, prefix + "bsa6", ""));
		setOldJoAddCrrCd2(JSPUtil.getParameter(request, prefix + "old_jo_add_crr_cd2", ""));
		setBsa1(JSPUtil.getParameter(request, prefix + "bsa1", ""));
		setJoAddCrrCd7(JSPUtil.getParameter(request, prefix + "jo_add_crr_cd7", ""));
		setJoAddCrrCd6(JSPUtil.getParameter(request, prefix + "jo_add_crr_cd6", ""));
		setOldJoAddCrrCd1(JSPUtil.getParameter(request, prefix + "old_jo_add_crr_cd1", ""));
		setBsa3(JSPUtil.getParameter(request, prefix + "bsa3", ""));
		setJoAddCrrCd5(JSPUtil.getParameter(request, prefix + "jo_add_crr_cd5", ""));
		setJoAddCrrCd4(JSPUtil.getParameter(request, prefix + "jo_add_crr_cd4", ""));
		setBsa2(JSPUtil.getParameter(request, prefix + "bsa2", ""));
		setBsa10(JSPUtil.getParameter(request, prefix + "bsa10", ""));
		setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_cd", ""));
		setJoVerFlg(JSPUtil.getParameter(request, prefix + "jo_ver_flg", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPortSeq(JSPUtil.getParameter(request, prefix + "port_seq", ""));
		setOldJoAddCrrCd10(JSPUtil.getParameter(request, prefix + "old_jo_add_crr_cd10", ""));
		setUpdUsrNm(JSPUtil.getParameter(request, prefix + "upd_usr_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BsaCarrieHistoryVO[]
	 */
	public BsaCarrieHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BsaCarrieHistoryVO[]
	 */
	public BsaCarrieHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BsaCarrieHistoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] joAddCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_add_crr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] joAddCrrCd10 = (JSPUtil.getParameter(request, prefix	+ "jo_add_crr_cd10", length));
			String[] joBsaAddRefSeq10 = (JSPUtil.getParameter(request, prefix	+ "jo_bsa_add_ref_seq10", length));
			String[] oldJoAddCrrCd = (JSPUtil.getParameter(request, prefix	+ "old_jo_add_crr_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] joBsaAddRefSeq9 = (JSPUtil.getParameter(request, prefix	+ "jo_bsa_add_ref_seq9", length));
			String[] joBsaAddRefSeq8 = (JSPUtil.getParameter(request, prefix	+ "jo_bsa_add_ref_seq8", length));
			String[] joBsaAddRefSeq7 = (JSPUtil.getParameter(request, prefix	+ "jo_bsa_add_ref_seq7", length));
			String[] joBsaAddRefSeq6 = (JSPUtil.getParameter(request, prefix	+ "jo_bsa_add_ref_seq6", length));
			String[] joBsaAddRefSeq5 = (JSPUtil.getParameter(request, prefix	+ "jo_bsa_add_ref_seq5", length));
			String[] joBsaAddRefSeq4 = (JSPUtil.getParameter(request, prefix	+ "jo_bsa_add_ref_seq4", length));
			String[] joBsaAddRefSeq3 = (JSPUtil.getParameter(request, prefix	+ "jo_bsa_add_ref_seq3", length));
			String[] joBsaAddRefSeq2 = (JSPUtil.getParameter(request, prefix	+ "jo_bsa_add_ref_seq2", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] joBsaAddRefSeq = (JSPUtil.getParameter(request, prefix	+ "jo_bsa_add_ref_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] joBsaAddRefSeq1 = (JSPUtil.getParameter(request, prefix	+ "jo_bsa_add_ref_seq1", length));
			String[] bsa = (JSPUtil.getParameter(request, prefix	+ "bsa", length));
			String[] joAddCrrCd8 = (JSPUtil.getParameter(request, prefix	+ "jo_add_crr_cd8", length));
			String[] udpFlg = (JSPUtil.getParameter(request, prefix	+ "udp_flg", length));
			String[] joAddCrrCd9 = (JSPUtil.getParameter(request, prefix	+ "jo_add_crr_cd9", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vvdPort = (JSPUtil.getParameter(request, prefix	+ "vvd_port", length));
			String[] creDtTo = (JSPUtil.getParameter(request, prefix	+ "cre_dt_to", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bsa9 = (JSPUtil.getParameter(request, prefix	+ "bsa9", length));
			String[] oldJoAddCrrCd9 = (JSPUtil.getParameter(request, prefix	+ "old_jo_add_crr_cd9", length));
			String[] bsa8 = (JSPUtil.getParameter(request, prefix	+ "bsa8", length));
			String[] oldJoAddCrrCd8 = (JSPUtil.getParameter(request, prefix	+ "old_jo_add_crr_cd8", length));
			String[] oldJoAddCrrCd7 = (JSPUtil.getParameter(request, prefix	+ "old_jo_add_crr_cd7", length));
			String[] joAddCrrCd3 = (JSPUtil.getParameter(request, prefix	+ "jo_add_crr_cd3", length));
			String[] oldJoAddCrrCd6 = (JSPUtil.getParameter(request, prefix	+ "old_jo_add_crr_cd6", length));
			String[] bsa5 = (JSPUtil.getParameter(request, prefix	+ "bsa5", length));
			String[] oldJoAddCrrCd5 = (JSPUtil.getParameter(request, prefix	+ "old_jo_add_crr_cd5", length));
			String[] bsa4 = (JSPUtil.getParameter(request, prefix	+ "bsa4", length));
			String[] joAddCrrCd2 = (JSPUtil.getParameter(request, prefix	+ "jo_add_crr_cd2", length));
			String[] oldJoAddCrrCd4 = (JSPUtil.getParameter(request, prefix	+ "old_jo_add_crr_cd4", length));
			String[] bsa7 = (JSPUtil.getParameter(request, prefix	+ "bsa7", length));
			String[] joAddCrrCd1 = (JSPUtil.getParameter(request, prefix	+ "jo_add_crr_cd1", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] oldJoAddCrrCd3 = (JSPUtil.getParameter(request, prefix	+ "old_jo_add_crr_cd3", length));
			String[] bsa6 = (JSPUtil.getParameter(request, prefix	+ "bsa6", length));
			String[] oldJoAddCrrCd2 = (JSPUtil.getParameter(request, prefix	+ "old_jo_add_crr_cd2", length));
			String[] bsa1 = (JSPUtil.getParameter(request, prefix	+ "bsa1", length));
			String[] joAddCrrCd7 = (JSPUtil.getParameter(request, prefix	+ "jo_add_crr_cd7", length));
			String[] joAddCrrCd6 = (JSPUtil.getParameter(request, prefix	+ "jo_add_crr_cd6", length));
			String[] oldJoAddCrrCd1 = (JSPUtil.getParameter(request, prefix	+ "old_jo_add_crr_cd1", length));
			String[] bsa3 = (JSPUtil.getParameter(request, prefix	+ "bsa3", length));
			String[] joAddCrrCd5 = (JSPUtil.getParameter(request, prefix	+ "jo_add_crr_cd5", length));
			String[] joAddCrrCd4 = (JSPUtil.getParameter(request, prefix	+ "jo_add_crr_cd4", length));
			String[] bsa2 = (JSPUtil.getParameter(request, prefix	+ "bsa2", length));
			String[] bsa10 = (JSPUtil.getParameter(request, prefix	+ "bsa10", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] joVerFlg = (JSPUtil.getParameter(request, prefix	+ "jo_ver_flg", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] portSeq = (JSPUtil.getParameter(request, prefix	+ "port_seq", length));
			String[] oldJoAddCrrCd10 = (JSPUtil.getParameter(request, prefix	+ "old_jo_add_crr_cd10", length));
			String[] updUsrNm = (JSPUtil.getParameter(request, prefix	+ "upd_usr_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new BsaCarrieHistoryVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (joAddCrrCd[i] != null)
					model.setJoAddCrrCd(joAddCrrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (joAddCrrCd10[i] != null)
					model.setJoAddCrrCd10(joAddCrrCd10[i]);
				if (joBsaAddRefSeq10[i] != null)
					model.setJoBsaAddRefSeq10(joBsaAddRefSeq10[i]);
				if (oldJoAddCrrCd[i] != null)
					model.setOldJoAddCrrCd(oldJoAddCrrCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (joBsaAddRefSeq9[i] != null)
					model.setJoBsaAddRefSeq9(joBsaAddRefSeq9[i]);
				if (joBsaAddRefSeq8[i] != null)
					model.setJoBsaAddRefSeq8(joBsaAddRefSeq8[i]);
				if (joBsaAddRefSeq7[i] != null)
					model.setJoBsaAddRefSeq7(joBsaAddRefSeq7[i]);
				if (joBsaAddRefSeq6[i] != null)
					model.setJoBsaAddRefSeq6(joBsaAddRefSeq6[i]);
				if (joBsaAddRefSeq5[i] != null)
					model.setJoBsaAddRefSeq5(joBsaAddRefSeq5[i]);
				if (joBsaAddRefSeq4[i] != null)
					model.setJoBsaAddRefSeq4(joBsaAddRefSeq4[i]);
				if (joBsaAddRefSeq3[i] != null)
					model.setJoBsaAddRefSeq3(joBsaAddRefSeq3[i]);
				if (joBsaAddRefSeq2[i] != null)
					model.setJoBsaAddRefSeq2(joBsaAddRefSeq2[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (joBsaAddRefSeq[i] != null)
					model.setJoBsaAddRefSeq(joBsaAddRefSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (joBsaAddRefSeq1[i] != null)
					model.setJoBsaAddRefSeq1(joBsaAddRefSeq1[i]);
				if (bsa[i] != null)
					model.setBsa(bsa[i]);
				if (joAddCrrCd8[i] != null)
					model.setJoAddCrrCd8(joAddCrrCd8[i]);
				if (udpFlg[i] != null)
					model.setUdpFlg(udpFlg[i]);
				if (joAddCrrCd9[i] != null)
					model.setJoAddCrrCd9(joAddCrrCd9[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vvdPort[i] != null)
					model.setVvdPort(vvdPort[i]);
				if (creDtTo[i] != null)
					model.setCreDtTo(creDtTo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bsa9[i] != null)
					model.setBsa9(bsa9[i]);
				if (oldJoAddCrrCd9[i] != null)
					model.setOldJoAddCrrCd9(oldJoAddCrrCd9[i]);
				if (bsa8[i] != null)
					model.setBsa8(bsa8[i]);
				if (oldJoAddCrrCd8[i] != null)
					model.setOldJoAddCrrCd8(oldJoAddCrrCd8[i]);
				if (oldJoAddCrrCd7[i] != null)
					model.setOldJoAddCrrCd7(oldJoAddCrrCd7[i]);
				if (joAddCrrCd3[i] != null)
					model.setJoAddCrrCd3(joAddCrrCd3[i]);
				if (oldJoAddCrrCd6[i] != null)
					model.setOldJoAddCrrCd6(oldJoAddCrrCd6[i]);
				if (bsa5[i] != null)
					model.setBsa5(bsa5[i]);
				if (oldJoAddCrrCd5[i] != null)
					model.setOldJoAddCrrCd5(oldJoAddCrrCd5[i]);
				if (bsa4[i] != null)
					model.setBsa4(bsa4[i]);
				if (joAddCrrCd2[i] != null)
					model.setJoAddCrrCd2(joAddCrrCd2[i]);
				if (oldJoAddCrrCd4[i] != null)
					model.setOldJoAddCrrCd4(oldJoAddCrrCd4[i]);
				if (bsa7[i] != null)
					model.setBsa7(bsa7[i]);
				if (joAddCrrCd1[i] != null)
					model.setJoAddCrrCd1(joAddCrrCd1[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (oldJoAddCrrCd3[i] != null)
					model.setOldJoAddCrrCd3(oldJoAddCrrCd3[i]);
				if (bsa6[i] != null)
					model.setBsa6(bsa6[i]);
				if (oldJoAddCrrCd2[i] != null)
					model.setOldJoAddCrrCd2(oldJoAddCrrCd2[i]);
				if (bsa1[i] != null)
					model.setBsa1(bsa1[i]);
				if (joAddCrrCd7[i] != null)
					model.setJoAddCrrCd7(joAddCrrCd7[i]);
				if (joAddCrrCd6[i] != null)
					model.setJoAddCrrCd6(joAddCrrCd6[i]);
				if (oldJoAddCrrCd1[i] != null)
					model.setOldJoAddCrrCd1(oldJoAddCrrCd1[i]);
				if (bsa3[i] != null)
					model.setBsa3(bsa3[i]);
				if (joAddCrrCd5[i] != null)
					model.setJoAddCrrCd5(joAddCrrCd5[i]);
				if (joAddCrrCd4[i] != null)
					model.setJoAddCrrCd4(joAddCrrCd4[i]);
				if (bsa2[i] != null)
					model.setBsa2(bsa2[i]);
				if (bsa10[i] != null)
					model.setBsa10(bsa10[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (joVerFlg[i] != null)
					model.setJoVerFlg(joVerFlg[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (portSeq[i] != null)
					model.setPortSeq(portSeq[i]);
				if (oldJoAddCrrCd10[i] != null)
					model.setOldJoAddCrrCd10(oldJoAddCrrCd10[i]);
				if (updUsrNm[i] != null)
					model.setUpdUsrNm(updUsrNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBsaCarrieHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BsaCarrieHistoryVO[]
	 */
	public BsaCarrieHistoryVO[] getBsaCarrieHistoryVOs(){
		BsaCarrieHistoryVO[] vos = (BsaCarrieHistoryVO[])models.toArray(new BsaCarrieHistoryVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joAddCrrCd = this.joAddCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joAddCrrCd10 = this.joAddCrrCd10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBsaAddRefSeq10 = this.joBsaAddRefSeq10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldJoAddCrrCd = this.oldJoAddCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBsaAddRefSeq9 = this.joBsaAddRefSeq9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBsaAddRefSeq8 = this.joBsaAddRefSeq8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBsaAddRefSeq7 = this.joBsaAddRefSeq7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBsaAddRefSeq6 = this.joBsaAddRefSeq6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBsaAddRefSeq5 = this.joBsaAddRefSeq5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBsaAddRefSeq4 = this.joBsaAddRefSeq4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBsaAddRefSeq3 = this.joBsaAddRefSeq3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBsaAddRefSeq2 = this.joBsaAddRefSeq2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBsaAddRefSeq = this.joBsaAddRefSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBsaAddRefSeq1 = this.joBsaAddRefSeq1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa = this.bsa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joAddCrrCd8 = this.joAddCrrCd8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udpFlg = this.udpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joAddCrrCd9 = this.joAddCrrCd9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPort = this.vvdPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDtTo = this.creDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa9 = this.bsa9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldJoAddCrrCd9 = this.oldJoAddCrrCd9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa8 = this.bsa8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldJoAddCrrCd8 = this.oldJoAddCrrCd8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldJoAddCrrCd7 = this.oldJoAddCrrCd7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joAddCrrCd3 = this.joAddCrrCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldJoAddCrrCd6 = this.oldJoAddCrrCd6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa5 = this.bsa5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldJoAddCrrCd5 = this.oldJoAddCrrCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa4 = this.bsa4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joAddCrrCd2 = this.joAddCrrCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldJoAddCrrCd4 = this.oldJoAddCrrCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa7 = this.bsa7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joAddCrrCd1 = this.joAddCrrCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldJoAddCrrCd3 = this.oldJoAddCrrCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa6 = this.bsa6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldJoAddCrrCd2 = this.oldJoAddCrrCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa1 = this.bsa1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joAddCrrCd7 = this.joAddCrrCd7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joAddCrrCd6 = this.joAddCrrCd6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldJoAddCrrCd1 = this.oldJoAddCrrCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa3 = this.bsa3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joAddCrrCd5 = this.joAddCrrCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joAddCrrCd4 = this.joAddCrrCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa2 = this.bsa2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa10 = this.bsa10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joVerFlg = this.joVerFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSeq = this.portSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldJoAddCrrCd10 = this.oldJoAddCrrCd10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrNm = this.updUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

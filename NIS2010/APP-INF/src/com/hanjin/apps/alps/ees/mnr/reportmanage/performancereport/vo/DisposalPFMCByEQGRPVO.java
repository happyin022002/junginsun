/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DisposalPFMCByEQGRPVO.java
*@FileTitle : DisposalPFMCByEQGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.21
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2010.01.21 함형석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo;

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
 * @author 함형석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DisposalPFMCByEQGRPVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DisposalPFMCByEQGRPVO> models = new ArrayList<DisposalPFMCByEQGRPVO>();
	
	/* Column Info */
	private String ts09Q = null;
	/* Column Info */
	private String ts09P = null;
	/* Column Info */
	private String buyerCd = null;
	/* Column Info */
	private String ts19P = null;
	/* Column Info */
	private String ts19Q = null;
	/* Column Info */
	private String ts10Q = null;
	/* Column Info */
	private String ts10P = null;
	/* Column Info */
	private String ts24Q = null;
	/* Column Info */
	private String type = null;
	/* Column Info */
	private String ts04P = null;
	/* Column Info */
	private String ts05P = null;
	/* Column Info */
	private String ts05Q = null;
	/* Column Info */
	private String ts04Q = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ts20P = null;
	/* Column Info */
	private String ts14Q = null;
	/* Column Info */
	private String ts14P = null;
	/* Column Info */
	private String ts20Q = null;
	/* Column Info */
	private String ts24P = null;
	/* Column Info */
	private String type2 = null;
	/* Column Info */
	private String ts28P = null;
	/* Column Info */
	private String ts28Q = null;
	/* Column Info */
	private String buyerNm = null;
	/* Column Info */
	private String rhq = null;
	/* Column Info */
	private String ts06P = null;
	/* Column Info */
	private String ts30Q = null;
	/* Column Info */
	private String ts23Q = null;
	/* Column Info */
	private String ts23P = null;
	/* Column Info */
	private String ts30P = null;
	/* Column Info */
	private String ts03Q = null;
	/* Column Info */
	private String ts03P = null;
	/* Column Info */
	private String ts13Q = null;
	/* Column Info */
	private String ts06Q = null;
	/* Column Info */
	private String ts13P = null;
	/* Column Info */
	private String ts29Q = null;
	/* Column Info */
	private String ts29P = null;
	/* Column Info */
	private String ts27Q = null;
	/* Column Info */
	private String ts27P = null;
	/* Column Info */
	private String ts12Q = null;
	/* Column Info */
	private String ts12P = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String ts17P = null;
	/* Column Info */
	private String ts17Q = null;
	/* Column Info */
	private String ts02P = null;
	/* Column Info */
	private String ts22P = null;
	/* Column Info */
	private String ts07P = null;
	/* Column Info */
	private String ts22Q = null;
	/* Column Info */
	private String ts07Q = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String title = null;
	/* Column Info */
	private String ts02Q = null;
	/* Column Info */
	private String ts16Q = null;
	/* Column Info */
	private String ts16P = null;
	/* Column Info */
	private String ts26P = null;
	/* Column Info */
	private String ts26Q = null;
	/* Column Info */
	private String ts18P = null;
	/* Column Info */
	private String ts18Q = null;
	/* Column Info */
	private String ts11Q = null;
	/* Column Info */
	private String ts11P = null;
	/* Column Info */
	private String ts21Q = null;
	/* Column Info */
	private String ts08Q = null;
	/* Column Info */
	private String ts21P = null;
	/* Column Info */
	private String ts08P = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String ts15Q = null;
	/* Column Info */
	private String ts15P = null;
	/* Column Info */
	private String ts01P = null;
	/* Column Info */
	private String ts01Q = null;
	/* Column Info */
	private String ts25Q = null;
	/* Column Info */
	private String ts25P = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DisposalPFMCByEQGRPVO() {}

	public DisposalPFMCByEQGRPVO(String ibflag, String pagerows, String ts09Q, String ts09P, String ts19P, String ts19Q, String ts10Q, String ts10P, String ts24Q, String type, String ts04P, String ts05P, String ts05Q, String ts04Q, String ts20P, String ts14Q, String ts14P, String ts20Q, String ts24P, String type2, String ts28P, String ts28Q, String rhq, String ts06P, String ts30Q, String ts23Q, String ts23P, String ts30P, String ts03Q, String ts03P, String ts13Q, String ts06Q, String ts13P, String ts29Q, String ts29P, String ts27Q, String ts27P, String ts12Q, String ts12P, String currCd, String ts17P, String ts17Q, String ts02P, String ts22P, String ts07P, String ts22Q, String ts07Q, String title, String ts16Q, String ts02Q, String ts16P, String ts26P, String ts26Q, String ts18P, String ts11Q, String ts18Q, String ts11P, String ts08Q, String ts21Q, String ts21P, String ts08P, String ofcCd, String ts15Q, String ts01P, String ts15P, String ts01Q, String ts25Q, String ts25P, String buyerCd, String buyerNm) {
		this.ts09Q = ts09Q;
		this.ts09P = ts09P;
		this.buyerCd = buyerCd;
		this.ts19P = ts19P;
		this.ts19Q = ts19Q;
		this.ts10Q = ts10Q;
		this.ts10P = ts10P;
		this.ts24Q = ts24Q;
		this.type = type;
		this.ts04P = ts04P;
		this.ts05P = ts05P;
		this.ts05Q = ts05Q;
		this.ts04Q = ts04Q;
		this.pagerows = pagerows;
		this.ts20P = ts20P;
		this.ts14Q = ts14Q;
		this.ts14P = ts14P;
		this.ts20Q = ts20Q;
		this.ts24P = ts24P;
		this.type2 = type2;
		this.ts28P = ts28P;
		this.ts28Q = ts28Q;
		this.buyerNm = buyerNm;
		this.rhq = rhq;
		this.ts06P = ts06P;
		this.ts30Q = ts30Q;
		this.ts23Q = ts23Q;
		this.ts23P = ts23P;
		this.ts30P = ts30P;
		this.ts03Q = ts03Q;
		this.ts03P = ts03P;
		this.ts13Q = ts13Q;
		this.ts06Q = ts06Q;
		this.ts13P = ts13P;
		this.ts29Q = ts29Q;
		this.ts29P = ts29P;
		this.ts27Q = ts27Q;
		this.ts27P = ts27P;
		this.ts12Q = ts12Q;
		this.ts12P = ts12P;
		this.currCd = currCd;
		this.ts17P = ts17P;
		this.ts17Q = ts17Q;
		this.ts02P = ts02P;
		this.ts22P = ts22P;
		this.ts07P = ts07P;
		this.ts22Q = ts22Q;
		this.ts07Q = ts07Q;
		this.ibflag = ibflag;
		this.title = title;
		this.ts02Q = ts02Q;
		this.ts16Q = ts16Q;
		this.ts16P = ts16P;
		this.ts26P = ts26P;
		this.ts26Q = ts26Q;
		this.ts18P = ts18P;
		this.ts18Q = ts18Q;
		this.ts11Q = ts11Q;
		this.ts11P = ts11P;
		this.ts21Q = ts21Q;
		this.ts08Q = ts08Q;
		this.ts21P = ts21P;
		this.ts08P = ts08P;
		this.ofcCd = ofcCd;
		this.ts15Q = ts15Q;
		this.ts15P = ts15P;
		this.ts01P = ts01P;
		this.ts01Q = ts01Q;
		this.ts25Q = ts25Q;
		this.ts25P = ts25P;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ts09_q", getTs09Q());
		this.hashColumns.put("ts09_p", getTs09P());
		this.hashColumns.put("buyer_cd", getBuyerCd());
		this.hashColumns.put("ts19_p", getTs19P());
		this.hashColumns.put("ts19_q", getTs19Q());
		this.hashColumns.put("ts10_q", getTs10Q());
		this.hashColumns.put("ts10_p", getTs10P());
		this.hashColumns.put("ts24_q", getTs24Q());
		this.hashColumns.put("type", getType());
		this.hashColumns.put("ts04_p", getTs04P());
		this.hashColumns.put("ts05_p", getTs05P());
		this.hashColumns.put("ts05_q", getTs05Q());
		this.hashColumns.put("ts04_q", getTs04Q());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ts20_p", getTs20P());
		this.hashColumns.put("ts14_q", getTs14Q());
		this.hashColumns.put("ts14_p", getTs14P());
		this.hashColumns.put("ts20_q", getTs20Q());
		this.hashColumns.put("ts24_p", getTs24P());
		this.hashColumns.put("type2", getType2());
		this.hashColumns.put("ts28_p", getTs28P());
		this.hashColumns.put("ts28_q", getTs28Q());
		this.hashColumns.put("buyer_nm", getBuyerNm());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("ts06_p", getTs06P());
		this.hashColumns.put("ts30_q", getTs30Q());
		this.hashColumns.put("ts23_q", getTs23Q());
		this.hashColumns.put("ts23_p", getTs23P());
		this.hashColumns.put("ts30_p", getTs30P());
		this.hashColumns.put("ts03_q", getTs03Q());
		this.hashColumns.put("ts03_p", getTs03P());
		this.hashColumns.put("ts13_q", getTs13Q());
		this.hashColumns.put("ts06_q", getTs06Q());
		this.hashColumns.put("ts13_p", getTs13P());
		this.hashColumns.put("ts29_q", getTs29Q());
		this.hashColumns.put("ts29_p", getTs29P());
		this.hashColumns.put("ts27_q", getTs27Q());
		this.hashColumns.put("ts27_p", getTs27P());
		this.hashColumns.put("ts12_q", getTs12Q());
		this.hashColumns.put("ts12_p", getTs12P());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("ts17_p", getTs17P());
		this.hashColumns.put("ts17_q", getTs17Q());
		this.hashColumns.put("ts02_p", getTs02P());
		this.hashColumns.put("ts22_p", getTs22P());
		this.hashColumns.put("ts07_p", getTs07P());
		this.hashColumns.put("ts22_q", getTs22Q());
		this.hashColumns.put("ts07_q", getTs07Q());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("title", getTitle());
		this.hashColumns.put("ts02_q", getTs02Q());
		this.hashColumns.put("ts16_q", getTs16Q());
		this.hashColumns.put("ts16_p", getTs16P());
		this.hashColumns.put("ts26_p", getTs26P());
		this.hashColumns.put("ts26_q", getTs26Q());
		this.hashColumns.put("ts18_p", getTs18P());
		this.hashColumns.put("ts18_q", getTs18Q());
		this.hashColumns.put("ts11_q", getTs11Q());
		this.hashColumns.put("ts11_p", getTs11P());
		this.hashColumns.put("ts21_q", getTs21Q());
		this.hashColumns.put("ts08_q", getTs08Q());
		this.hashColumns.put("ts21_p", getTs21P());
		this.hashColumns.put("ts08_p", getTs08P());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ts15_q", getTs15Q());
		this.hashColumns.put("ts15_p", getTs15P());
		this.hashColumns.put("ts01_p", getTs01P());
		this.hashColumns.put("ts01_q", getTs01Q());
		this.hashColumns.put("ts25_q", getTs25Q());
		this.hashColumns.put("ts25_p", getTs25P());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ts09_q", "ts09Q");
		this.hashFields.put("ts09_p", "ts09P");
		this.hashFields.put("buyer_cd", "buyerCd");
		this.hashFields.put("ts19_p", "ts19P");
		this.hashFields.put("ts19_q", "ts19Q");
		this.hashFields.put("ts10_q", "ts10Q");
		this.hashFields.put("ts10_p", "ts10P");
		this.hashFields.put("ts24_q", "ts24Q");
		this.hashFields.put("type", "type");
		this.hashFields.put("ts04_p", "ts04P");
		this.hashFields.put("ts05_p", "ts05P");
		this.hashFields.put("ts05_q", "ts05Q");
		this.hashFields.put("ts04_q", "ts04Q");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ts20_p", "ts20P");
		this.hashFields.put("ts14_q", "ts14Q");
		this.hashFields.put("ts14_p", "ts14P");
		this.hashFields.put("ts20_q", "ts20Q");
		this.hashFields.put("ts24_p", "ts24P");
		this.hashFields.put("type2", "type2");
		this.hashFields.put("ts28_p", "ts28P");
		this.hashFields.put("ts28_q", "ts28Q");
		this.hashFields.put("buyer_nm", "buyerNm");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("ts06_p", "ts06P");
		this.hashFields.put("ts30_q", "ts30Q");
		this.hashFields.put("ts23_q", "ts23Q");
		this.hashFields.put("ts23_p", "ts23P");
		this.hashFields.put("ts30_p", "ts30P");
		this.hashFields.put("ts03_q", "ts03Q");
		this.hashFields.put("ts03_p", "ts03P");
		this.hashFields.put("ts13_q", "ts13Q");
		this.hashFields.put("ts06_q", "ts06Q");
		this.hashFields.put("ts13_p", "ts13P");
		this.hashFields.put("ts29_q", "ts29Q");
		this.hashFields.put("ts29_p", "ts29P");
		this.hashFields.put("ts27_q", "ts27Q");
		this.hashFields.put("ts27_p", "ts27P");
		this.hashFields.put("ts12_q", "ts12Q");
		this.hashFields.put("ts12_p", "ts12P");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("ts17_p", "ts17P");
		this.hashFields.put("ts17_q", "ts17Q");
		this.hashFields.put("ts02_p", "ts02P");
		this.hashFields.put("ts22_p", "ts22P");
		this.hashFields.put("ts07_p", "ts07P");
		this.hashFields.put("ts22_q", "ts22Q");
		this.hashFields.put("ts07_q", "ts07Q");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("title", "title");
		this.hashFields.put("ts02_q", "ts02Q");
		this.hashFields.put("ts16_q", "ts16Q");
		this.hashFields.put("ts16_p", "ts16P");
		this.hashFields.put("ts26_p", "ts26P");
		this.hashFields.put("ts26_q", "ts26Q");
		this.hashFields.put("ts18_p", "ts18P");
		this.hashFields.put("ts18_q", "ts18Q");
		this.hashFields.put("ts11_q", "ts11Q");
		this.hashFields.put("ts11_p", "ts11P");
		this.hashFields.put("ts21_q", "ts21Q");
		this.hashFields.put("ts08_q", "ts08Q");
		this.hashFields.put("ts21_p", "ts21P");
		this.hashFields.put("ts08_p", "ts08P");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ts15_q", "ts15Q");
		this.hashFields.put("ts15_p", "ts15P");
		this.hashFields.put("ts01_p", "ts01P");
		this.hashFields.put("ts01_q", "ts01Q");
		this.hashFields.put("ts25_q", "ts25Q");
		this.hashFields.put("ts25_p", "ts25P");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ts09Q
	 */
	public String getTs09Q() {
		return this.ts09Q;
	}
	
	/**
	 * Column Info
	 * @return ts09P
	 */
	public String getTs09P() {
		return this.ts09P;
	}
	
	/**
	 * Column Info
	 * @return buyerCd
	 */
	public String getBuyerCd() {
		return this.buyerCd;
	}
	
	/**
	 * Column Info
	 * @return ts19P
	 */
	public String getTs19P() {
		return this.ts19P;
	}
	
	/**
	 * Column Info
	 * @return ts19Q
	 */
	public String getTs19Q() {
		return this.ts19Q;
	}
	
	/**
	 * Column Info
	 * @return ts10Q
	 */
	public String getTs10Q() {
		return this.ts10Q;
	}
	
	/**
	 * Column Info
	 * @return ts10P
	 */
	public String getTs10P() {
		return this.ts10P;
	}
	
	/**
	 * Column Info
	 * @return ts24Q
	 */
	public String getTs24Q() {
		return this.ts24Q;
	}
	
	/**
	 * Column Info
	 * @return type
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Column Info
	 * @return ts04P
	 */
	public String getTs04P() {
		return this.ts04P;
	}
	
	/**
	 * Column Info
	 * @return ts05P
	 */
	public String getTs05P() {
		return this.ts05P;
	}
	
	/**
	 * Column Info
	 * @return ts05Q
	 */
	public String getTs05Q() {
		return this.ts05Q;
	}
	
	/**
	 * Column Info
	 * @return ts04Q
	 */
	public String getTs04Q() {
		return this.ts04Q;
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
	 * @return ts20P
	 */
	public String getTs20P() {
		return this.ts20P;
	}
	
	/**
	 * Column Info
	 * @return ts14Q
	 */
	public String getTs14Q() {
		return this.ts14Q;
	}
	
	/**
	 * Column Info
	 * @return ts14P
	 */
	public String getTs14P() {
		return this.ts14P;
	}
	
	/**
	 * Column Info
	 * @return ts20Q
	 */
	public String getTs20Q() {
		return this.ts20Q;
	}
	
	/**
	 * Column Info
	 * @return ts24P
	 */
	public String getTs24P() {
		return this.ts24P;
	}
	
	/**
	 * Column Info
	 * @return type2
	 */
	public String getType2() {
		return this.type2;
	}
	
	/**
	 * Column Info
	 * @return ts28P
	 */
	public String getTs28P() {
		return this.ts28P;
	}
	
	/**
	 * Column Info
	 * @return ts28Q
	 */
	public String getTs28Q() {
		return this.ts28Q;
	}
	
	/**
	 * Column Info
	 * @return buyerNm
	 */
	public String getBuyerNm() {
		return this.buyerNm;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}
	
	/**
	 * Column Info
	 * @return ts06P
	 */
	public String getTs06P() {
		return this.ts06P;
	}
	
	/**
	 * Column Info
	 * @return ts30Q
	 */
	public String getTs30Q() {
		return this.ts30Q;
	}
	
	/**
	 * Column Info
	 * @return ts23Q
	 */
	public String getTs23Q() {
		return this.ts23Q;
	}
	
	/**
	 * Column Info
	 * @return ts23P
	 */
	public String getTs23P() {
		return this.ts23P;
	}
	
	/**
	 * Column Info
	 * @return ts30P
	 */
	public String getTs30P() {
		return this.ts30P;
	}
	
	/**
	 * Column Info
	 * @return ts03Q
	 */
	public String getTs03Q() {
		return this.ts03Q;
	}
	
	/**
	 * Column Info
	 * @return ts03P
	 */
	public String getTs03P() {
		return this.ts03P;
	}
	
	/**
	 * Column Info
	 * @return ts13Q
	 */
	public String getTs13Q() {
		return this.ts13Q;
	}
	
	/**
	 * Column Info
	 * @return ts06Q
	 */
	public String getTs06Q() {
		return this.ts06Q;
	}
	
	/**
	 * Column Info
	 * @return ts13P
	 */
	public String getTs13P() {
		return this.ts13P;
	}
	
	/**
	 * Column Info
	 * @return ts29Q
	 */
	public String getTs29Q() {
		return this.ts29Q;
	}
	
	/**
	 * Column Info
	 * @return ts29P
	 */
	public String getTs29P() {
		return this.ts29P;
	}
	
	/**
	 * Column Info
	 * @return ts27Q
	 */
	public String getTs27Q() {
		return this.ts27Q;
	}
	
	/**
	 * Column Info
	 * @return ts27P
	 */
	public String getTs27P() {
		return this.ts27P;
	}
	
	/**
	 * Column Info
	 * @return ts12Q
	 */
	public String getTs12Q() {
		return this.ts12Q;
	}
	
	/**
	 * Column Info
	 * @return ts12P
	 */
	public String getTs12P() {
		return this.ts12P;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return ts17P
	 */
	public String getTs17P() {
		return this.ts17P;
	}
	
	/**
	 * Column Info
	 * @return ts17Q
	 */
	public String getTs17Q() {
		return this.ts17Q;
	}
	
	/**
	 * Column Info
	 * @return ts02P
	 */
	public String getTs02P() {
		return this.ts02P;
	}
	
	/**
	 * Column Info
	 * @return ts22P
	 */
	public String getTs22P() {
		return this.ts22P;
	}
	
	/**
	 * Column Info
	 * @return ts07P
	 */
	public String getTs07P() {
		return this.ts07P;
	}
	
	/**
	 * Column Info
	 * @return ts22Q
	 */
	public String getTs22Q() {
		return this.ts22Q;
	}
	
	/**
	 * Column Info
	 * @return ts07Q
	 */
	public String getTs07Q() {
		return this.ts07Q;
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
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Column Info
	 * @return ts02Q
	 */
	public String getTs02Q() {
		return this.ts02Q;
	}
	
	/**
	 * Column Info
	 * @return ts16Q
	 */
	public String getTs16Q() {
		return this.ts16Q;
	}
	
	/**
	 * Column Info
	 * @return ts16P
	 */
	public String getTs16P() {
		return this.ts16P;
	}
	
	/**
	 * Column Info
	 * @return ts26P
	 */
	public String getTs26P() {
		return this.ts26P;
	}
	
	/**
	 * Column Info
	 * @return ts26Q
	 */
	public String getTs26Q() {
		return this.ts26Q;
	}
	
	/**
	 * Column Info
	 * @return ts18P
	 */
	public String getTs18P() {
		return this.ts18P;
	}
	
	/**
	 * Column Info
	 * @return ts18Q
	 */
	public String getTs18Q() {
		return this.ts18Q;
	}
	
	/**
	 * Column Info
	 * @return ts11Q
	 */
	public String getTs11Q() {
		return this.ts11Q;
	}
	
	/**
	 * Column Info
	 * @return ts11P
	 */
	public String getTs11P() {
		return this.ts11P;
	}
	
	/**
	 * Column Info
	 * @return ts21Q
	 */
	public String getTs21Q() {
		return this.ts21Q;
	}
	
	/**
	 * Column Info
	 * @return ts08Q
	 */
	public String getTs08Q() {
		return this.ts08Q;
	}
	
	/**
	 * Column Info
	 * @return ts21P
	 */
	public String getTs21P() {
		return this.ts21P;
	}
	
	/**
	 * Column Info
	 * @return ts08P
	 */
	public String getTs08P() {
		return this.ts08P;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return ts15Q
	 */
	public String getTs15Q() {
		return this.ts15Q;
	}
	
	/**
	 * Column Info
	 * @return ts15P
	 */
	public String getTs15P() {
		return this.ts15P;
	}
	
	/**
	 * Column Info
	 * @return ts01P
	 */
	public String getTs01P() {
		return this.ts01P;
	}
	
	/**
	 * Column Info
	 * @return ts01Q
	 */
	public String getTs01Q() {
		return this.ts01Q;
	}
	
	/**
	 * Column Info
	 * @return ts25Q
	 */
	public String getTs25Q() {
		return this.ts25Q;
	}
	
	/**
	 * Column Info
	 * @return ts25P
	 */
	public String getTs25P() {
		return this.ts25P;
	}
	

	/**
	 * Column Info
	 * @param ts09Q
	 */
	public void setTs09Q(String ts09Q) {
		this.ts09Q = ts09Q;
	}
	
	/**
	 * Column Info
	 * @param ts09P
	 */
	public void setTs09P(String ts09P) {
		this.ts09P = ts09P;
	}
	
	/**
	 * Column Info
	 * @param buyerCd
	 */
	public void setBuyerCd(String buyerCd) {
		this.buyerCd = buyerCd;
	}
	
	/**
	 * Column Info
	 * @param ts19P
	 */
	public void setTs19P(String ts19P) {
		this.ts19P = ts19P;
	}
	
	/**
	 * Column Info
	 * @param ts19Q
	 */
	public void setTs19Q(String ts19Q) {
		this.ts19Q = ts19Q;
	}
	
	/**
	 * Column Info
	 * @param ts10Q
	 */
	public void setTs10Q(String ts10Q) {
		this.ts10Q = ts10Q;
	}
	
	/**
	 * Column Info
	 * @param ts10P
	 */
	public void setTs10P(String ts10P) {
		this.ts10P = ts10P;
	}
	
	/**
	 * Column Info
	 * @param ts24Q
	 */
	public void setTs24Q(String ts24Q) {
		this.ts24Q = ts24Q;
	}
	
	/**
	 * Column Info
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Column Info
	 * @param ts04P
	 */
	public void setTs04P(String ts04P) {
		this.ts04P = ts04P;
	}
	
	/**
	 * Column Info
	 * @param ts05P
	 */
	public void setTs05P(String ts05P) {
		this.ts05P = ts05P;
	}
	
	/**
	 * Column Info
	 * @param ts05Q
	 */
	public void setTs05Q(String ts05Q) {
		this.ts05Q = ts05Q;
	}
	
	/**
	 * Column Info
	 * @param ts04Q
	 */
	public void setTs04Q(String ts04Q) {
		this.ts04Q = ts04Q;
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
	 * @param ts20P
	 */
	public void setTs20P(String ts20P) {
		this.ts20P = ts20P;
	}
	
	/**
	 * Column Info
	 * @param ts14Q
	 */
	public void setTs14Q(String ts14Q) {
		this.ts14Q = ts14Q;
	}
	
	/**
	 * Column Info
	 * @param ts14P
	 */
	public void setTs14P(String ts14P) {
		this.ts14P = ts14P;
	}
	
	/**
	 * Column Info
	 * @param ts20Q
	 */
	public void setTs20Q(String ts20Q) {
		this.ts20Q = ts20Q;
	}
	
	/**
	 * Column Info
	 * @param ts24P
	 */
	public void setTs24P(String ts24P) {
		this.ts24P = ts24P;
	}
	
	/**
	 * Column Info
	 * @param type2
	 */
	public void setType2(String type2) {
		this.type2 = type2;
	}
	
	/**
	 * Column Info
	 * @param ts28P
	 */
	public void setTs28P(String ts28P) {
		this.ts28P = ts28P;
	}
	
	/**
	 * Column Info
	 * @param ts28Q
	 */
	public void setTs28Q(String ts28Q) {
		this.ts28Q = ts28Q;
	}
	
	/**
	 * Column Info
	 * @param buyerNm
	 */
	public void setBuyerNm(String buyerNm) {
		this.buyerNm = buyerNm;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
	}
	
	/**
	 * Column Info
	 * @param ts06P
	 */
	public void setTs06P(String ts06P) {
		this.ts06P = ts06P;
	}
	
	/**
	 * Column Info
	 * @param ts30Q
	 */
	public void setTs30Q(String ts30Q) {
		this.ts30Q = ts30Q;
	}
	
	/**
	 * Column Info
	 * @param ts23Q
	 */
	public void setTs23Q(String ts23Q) {
		this.ts23Q = ts23Q;
	}
	
	/**
	 * Column Info
	 * @param ts23P
	 */
	public void setTs23P(String ts23P) {
		this.ts23P = ts23P;
	}
	
	/**
	 * Column Info
	 * @param ts30P
	 */
	public void setTs30P(String ts30P) {
		this.ts30P = ts30P;
	}
	
	/**
	 * Column Info
	 * @param ts03Q
	 */
	public void setTs03Q(String ts03Q) {
		this.ts03Q = ts03Q;
	}
	
	/**
	 * Column Info
	 * @param ts03P
	 */
	public void setTs03P(String ts03P) {
		this.ts03P = ts03P;
	}
	
	/**
	 * Column Info
	 * @param ts13Q
	 */
	public void setTs13Q(String ts13Q) {
		this.ts13Q = ts13Q;
	}
	
	/**
	 * Column Info
	 * @param ts06Q
	 */
	public void setTs06Q(String ts06Q) {
		this.ts06Q = ts06Q;
	}
	
	/**
	 * Column Info
	 * @param ts13P
	 */
	public void setTs13P(String ts13P) {
		this.ts13P = ts13P;
	}
	
	/**
	 * Column Info
	 * @param ts29Q
	 */
	public void setTs29Q(String ts29Q) {
		this.ts29Q = ts29Q;
	}
	
	/**
	 * Column Info
	 * @param ts29P
	 */
	public void setTs29P(String ts29P) {
		this.ts29P = ts29P;
	}
	
	/**
	 * Column Info
	 * @param ts27Q
	 */
	public void setTs27Q(String ts27Q) {
		this.ts27Q = ts27Q;
	}
	
	/**
	 * Column Info
	 * @param ts27P
	 */
	public void setTs27P(String ts27P) {
		this.ts27P = ts27P;
	}
	
	/**
	 * Column Info
	 * @param ts12Q
	 */
	public void setTs12Q(String ts12Q) {
		this.ts12Q = ts12Q;
	}
	
	/**
	 * Column Info
	 * @param ts12P
	 */
	public void setTs12P(String ts12P) {
		this.ts12P = ts12P;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param ts17P
	 */
	public void setTs17P(String ts17P) {
		this.ts17P = ts17P;
	}
	
	/**
	 * Column Info
	 * @param ts17Q
	 */
	public void setTs17Q(String ts17Q) {
		this.ts17Q = ts17Q;
	}
	
	/**
	 * Column Info
	 * @param ts02P
	 */
	public void setTs02P(String ts02P) {
		this.ts02P = ts02P;
	}
	
	/**
	 * Column Info
	 * @param ts22P
	 */
	public void setTs22P(String ts22P) {
		this.ts22P = ts22P;
	}
	
	/**
	 * Column Info
	 * @param ts07P
	 */
	public void setTs07P(String ts07P) {
		this.ts07P = ts07P;
	}
	
	/**
	 * Column Info
	 * @param ts22Q
	 */
	public void setTs22Q(String ts22Q) {
		this.ts22Q = ts22Q;
	}
	
	/**
	 * Column Info
	 * @param ts07Q
	 */
	public void setTs07Q(String ts07Q) {
		this.ts07Q = ts07Q;
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
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Column Info
	 * @param ts02Q
	 */
	public void setTs02Q(String ts02Q) {
		this.ts02Q = ts02Q;
	}
	
	/**
	 * Column Info
	 * @param ts16Q
	 */
	public void setTs16Q(String ts16Q) {
		this.ts16Q = ts16Q;
	}
	
	/**
	 * Column Info
	 * @param ts16P
	 */
	public void setTs16P(String ts16P) {
		this.ts16P = ts16P;
	}
	
	/**
	 * Column Info
	 * @param ts26P
	 */
	public void setTs26P(String ts26P) {
		this.ts26P = ts26P;
	}
	
	/**
	 * Column Info
	 * @param ts26Q
	 */
	public void setTs26Q(String ts26Q) {
		this.ts26Q = ts26Q;
	}
	
	/**
	 * Column Info
	 * @param ts18P
	 */
	public void setTs18P(String ts18P) {
		this.ts18P = ts18P;
	}
	
	/**
	 * Column Info
	 * @param ts18Q
	 */
	public void setTs18Q(String ts18Q) {
		this.ts18Q = ts18Q;
	}
	
	/**
	 * Column Info
	 * @param ts11Q
	 */
	public void setTs11Q(String ts11Q) {
		this.ts11Q = ts11Q;
	}
	
	/**
	 * Column Info
	 * @param ts11P
	 */
	public void setTs11P(String ts11P) {
		this.ts11P = ts11P;
	}
	
	/**
	 * Column Info
	 * @param ts21Q
	 */
	public void setTs21Q(String ts21Q) {
		this.ts21Q = ts21Q;
	}
	
	/**
	 * Column Info
	 * @param ts08Q
	 */
	public void setTs08Q(String ts08Q) {
		this.ts08Q = ts08Q;
	}
	
	/**
	 * Column Info
	 * @param ts21P
	 */
	public void setTs21P(String ts21P) {
		this.ts21P = ts21P;
	}
	
	/**
	 * Column Info
	 * @param ts08P
	 */
	public void setTs08P(String ts08P) {
		this.ts08P = ts08P;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param ts15Q
	 */
	public void setTs15Q(String ts15Q) {
		this.ts15Q = ts15Q;
	}
	
	/**
	 * Column Info
	 * @param ts15P
	 */
	public void setTs15P(String ts15P) {
		this.ts15P = ts15P;
	}
	
	/**
	 * Column Info
	 * @param ts01P
	 */
	public void setTs01P(String ts01P) {
		this.ts01P = ts01P;
	}
	
	/**
	 * Column Info
	 * @param ts01Q
	 */
	public void setTs01Q(String ts01Q) {
		this.ts01Q = ts01Q;
	}
	
	/**
	 * Column Info
	 * @param ts25Q
	 */
	public void setTs25Q(String ts25Q) {
		this.ts25Q = ts25Q;
	}
	
	/**
	 * Column Info
	 * @param ts25P
	 */
	public void setTs25P(String ts25P) {
		this.ts25P = ts25P;
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
		setTs09Q(JSPUtil.getParameter(request, prefix + "ts09_q", ""));
		setTs09P(JSPUtil.getParameter(request, prefix + "ts09_p", ""));
		setBuyerCd(JSPUtil.getParameter(request, prefix + "buyer_cd", ""));
		setTs19P(JSPUtil.getParameter(request, prefix + "ts19_p", ""));
		setTs19Q(JSPUtil.getParameter(request, prefix + "ts19_q", ""));
		setTs10Q(JSPUtil.getParameter(request, prefix + "ts10_q", ""));
		setTs10P(JSPUtil.getParameter(request, prefix + "ts10_p", ""));
		setTs24Q(JSPUtil.getParameter(request, prefix + "ts24_q", ""));
		setType(JSPUtil.getParameter(request, prefix + "type", ""));
		setTs04P(JSPUtil.getParameter(request, prefix + "ts04_p", ""));
		setTs05P(JSPUtil.getParameter(request, prefix + "ts05_p", ""));
		setTs05Q(JSPUtil.getParameter(request, prefix + "ts05_q", ""));
		setTs04Q(JSPUtil.getParameter(request, prefix + "ts04_q", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTs20P(JSPUtil.getParameter(request, prefix + "ts20_p", ""));
		setTs14Q(JSPUtil.getParameter(request, prefix + "ts14_q", ""));
		setTs14P(JSPUtil.getParameter(request, prefix + "ts14_p", ""));
		setTs20Q(JSPUtil.getParameter(request, prefix + "ts20_q", ""));
		setTs24P(JSPUtil.getParameter(request, prefix + "ts24_p", ""));
		setType2(JSPUtil.getParameter(request, prefix + "type2", ""));
		setTs28P(JSPUtil.getParameter(request, prefix + "ts28_p", ""));
		setTs28Q(JSPUtil.getParameter(request, prefix + "ts28_q", ""));
		setBuyerNm(JSPUtil.getParameter(request, prefix + "buyer_nm", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
		setTs06P(JSPUtil.getParameter(request, prefix + "ts06_p", ""));
		setTs30Q(JSPUtil.getParameter(request, prefix + "ts30_q", ""));
		setTs23Q(JSPUtil.getParameter(request, prefix + "ts23_q", ""));
		setTs23P(JSPUtil.getParameter(request, prefix + "ts23_p", ""));
		setTs30P(JSPUtil.getParameter(request, prefix + "ts30_p", ""));
		setTs03Q(JSPUtil.getParameter(request, prefix + "ts03_q", ""));
		setTs03P(JSPUtil.getParameter(request, prefix + "ts03_p", ""));
		setTs13Q(JSPUtil.getParameter(request, prefix + "ts13_q", ""));
		setTs06Q(JSPUtil.getParameter(request, prefix + "ts06_q", ""));
		setTs13P(JSPUtil.getParameter(request, prefix + "ts13_p", ""));
		setTs29Q(JSPUtil.getParameter(request, prefix + "ts29_q", ""));
		setTs29P(JSPUtil.getParameter(request, prefix + "ts29_p", ""));
		setTs27Q(JSPUtil.getParameter(request, prefix + "ts27_q", ""));
		setTs27P(JSPUtil.getParameter(request, prefix + "ts27_p", ""));
		setTs12Q(JSPUtil.getParameter(request, prefix + "ts12_q", ""));
		setTs12P(JSPUtil.getParameter(request, prefix + "ts12_p", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setTs17P(JSPUtil.getParameter(request, prefix + "ts17_p", ""));
		setTs17Q(JSPUtil.getParameter(request, prefix + "ts17_q", ""));
		setTs02P(JSPUtil.getParameter(request, prefix + "ts02_p", ""));
		setTs22P(JSPUtil.getParameter(request, prefix + "ts22_p", ""));
		setTs07P(JSPUtil.getParameter(request, prefix + "ts07_p", ""));
		setTs22Q(JSPUtil.getParameter(request, prefix + "ts22_q", ""));
		setTs07Q(JSPUtil.getParameter(request, prefix + "ts07_q", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTitle(JSPUtil.getParameter(request, prefix + "title", ""));
		setTs02Q(JSPUtil.getParameter(request, prefix + "ts02_q", ""));
		setTs16Q(JSPUtil.getParameter(request, prefix + "ts16_q", ""));
		setTs16P(JSPUtil.getParameter(request, prefix + "ts16_p", ""));
		setTs26P(JSPUtil.getParameter(request, prefix + "ts26_p", ""));
		setTs26Q(JSPUtil.getParameter(request, prefix + "ts26_q", ""));
		setTs18P(JSPUtil.getParameter(request, prefix + "ts18_p", ""));
		setTs18Q(JSPUtil.getParameter(request, prefix + "ts18_q", ""));
		setTs11Q(JSPUtil.getParameter(request, prefix + "ts11_q", ""));
		setTs11P(JSPUtil.getParameter(request, prefix + "ts11_p", ""));
		setTs21Q(JSPUtil.getParameter(request, prefix + "ts21_q", ""));
		setTs08Q(JSPUtil.getParameter(request, prefix + "ts08_q", ""));
		setTs21P(JSPUtil.getParameter(request, prefix + "ts21_p", ""));
		setTs08P(JSPUtil.getParameter(request, prefix + "ts08_p", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setTs15Q(JSPUtil.getParameter(request, prefix + "ts15_q", ""));
		setTs15P(JSPUtil.getParameter(request, prefix + "ts15_p", ""));
		setTs01P(JSPUtil.getParameter(request, prefix + "ts01_p", ""));
		setTs01Q(JSPUtil.getParameter(request, prefix + "ts01_q", ""));
		setTs25Q(JSPUtil.getParameter(request, prefix + "ts25_q", ""));
		setTs25P(JSPUtil.getParameter(request, prefix + "ts25_p", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DisposalPFMCByEQGRPVO[]
	 */
	public DisposalPFMCByEQGRPVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DisposalPFMCByEQGRPVO[]
	 */
	public DisposalPFMCByEQGRPVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DisposalPFMCByEQGRPVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ts09Q = (JSPUtil.getParameter(request, prefix	+ "ts09_q", length));
			String[] ts09P = (JSPUtil.getParameter(request, prefix	+ "ts09_p", length));
			String[] buyerCd = (JSPUtil.getParameter(request, prefix	+ "buyer_cd", length));
			String[] ts19P = (JSPUtil.getParameter(request, prefix	+ "ts19_p", length));
			String[] ts19Q = (JSPUtil.getParameter(request, prefix	+ "ts19_q", length));
			String[] ts10Q = (JSPUtil.getParameter(request, prefix	+ "ts10_q", length));
			String[] ts10P = (JSPUtil.getParameter(request, prefix	+ "ts10_p", length));
			String[] ts24Q = (JSPUtil.getParameter(request, prefix	+ "ts24_q", length));
			String[] type = (JSPUtil.getParameter(request, prefix	+ "type", length));
			String[] ts04P = (JSPUtil.getParameter(request, prefix	+ "ts04_p", length));
			String[] ts05P = (JSPUtil.getParameter(request, prefix	+ "ts05_p", length));
			String[] ts05Q = (JSPUtil.getParameter(request, prefix	+ "ts05_q", length));
			String[] ts04Q = (JSPUtil.getParameter(request, prefix	+ "ts04_q", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ts20P = (JSPUtil.getParameter(request, prefix	+ "ts20_p", length));
			String[] ts14Q = (JSPUtil.getParameter(request, prefix	+ "ts14_q", length));
			String[] ts14P = (JSPUtil.getParameter(request, prefix	+ "ts14_p", length));
			String[] ts20Q = (JSPUtil.getParameter(request, prefix	+ "ts20_q", length));
			String[] ts24P = (JSPUtil.getParameter(request, prefix	+ "ts24_p", length));
			String[] type2 = (JSPUtil.getParameter(request, prefix	+ "type2", length));
			String[] ts28P = (JSPUtil.getParameter(request, prefix	+ "ts28_p", length));
			String[] ts28Q = (JSPUtil.getParameter(request, prefix	+ "ts28_q", length));
			String[] buyerNm = (JSPUtil.getParameter(request, prefix	+ "buyer_nm", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] ts06P = (JSPUtil.getParameter(request, prefix	+ "ts06_p", length));
			String[] ts30Q = (JSPUtil.getParameter(request, prefix	+ "ts30_q", length));
			String[] ts23Q = (JSPUtil.getParameter(request, prefix	+ "ts23_q", length));
			String[] ts23P = (JSPUtil.getParameter(request, prefix	+ "ts23_p", length));
			String[] ts30P = (JSPUtil.getParameter(request, prefix	+ "ts30_p", length));
			String[] ts03Q = (JSPUtil.getParameter(request, prefix	+ "ts03_q", length));
			String[] ts03P = (JSPUtil.getParameter(request, prefix	+ "ts03_p", length));
			String[] ts13Q = (JSPUtil.getParameter(request, prefix	+ "ts13_q", length));
			String[] ts06Q = (JSPUtil.getParameter(request, prefix	+ "ts06_q", length));
			String[] ts13P = (JSPUtil.getParameter(request, prefix	+ "ts13_p", length));
			String[] ts29Q = (JSPUtil.getParameter(request, prefix	+ "ts29_q", length));
			String[] ts29P = (JSPUtil.getParameter(request, prefix	+ "ts29_p", length));
			String[] ts27Q = (JSPUtil.getParameter(request, prefix	+ "ts27_q", length));
			String[] ts27P = (JSPUtil.getParameter(request, prefix	+ "ts27_p", length));
			String[] ts12Q = (JSPUtil.getParameter(request, prefix	+ "ts12_q", length));
			String[] ts12P = (JSPUtil.getParameter(request, prefix	+ "ts12_p", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] ts17P = (JSPUtil.getParameter(request, prefix	+ "ts17_p", length));
			String[] ts17Q = (JSPUtil.getParameter(request, prefix	+ "ts17_q", length));
			String[] ts02P = (JSPUtil.getParameter(request, prefix	+ "ts02_p", length));
			String[] ts22P = (JSPUtil.getParameter(request, prefix	+ "ts22_p", length));
			String[] ts07P = (JSPUtil.getParameter(request, prefix	+ "ts07_p", length));
			String[] ts22Q = (JSPUtil.getParameter(request, prefix	+ "ts22_q", length));
			String[] ts07Q = (JSPUtil.getParameter(request, prefix	+ "ts07_q", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] title = (JSPUtil.getParameter(request, prefix	+ "title", length));
			String[] ts02Q = (JSPUtil.getParameter(request, prefix	+ "ts02_q", length));
			String[] ts16Q = (JSPUtil.getParameter(request, prefix	+ "ts16_q", length));
			String[] ts16P = (JSPUtil.getParameter(request, prefix	+ "ts16_p", length));
			String[] ts26P = (JSPUtil.getParameter(request, prefix	+ "ts26_p", length));
			String[] ts26Q = (JSPUtil.getParameter(request, prefix	+ "ts26_q", length));
			String[] ts18P = (JSPUtil.getParameter(request, prefix	+ "ts18_p", length));
			String[] ts18Q = (JSPUtil.getParameter(request, prefix	+ "ts18_q", length));
			String[] ts11Q = (JSPUtil.getParameter(request, prefix	+ "ts11_q", length));
			String[] ts11P = (JSPUtil.getParameter(request, prefix	+ "ts11_p", length));
			String[] ts21Q = (JSPUtil.getParameter(request, prefix	+ "ts21_q", length));
			String[] ts08Q = (JSPUtil.getParameter(request, prefix	+ "ts08_q", length));
			String[] ts21P = (JSPUtil.getParameter(request, prefix	+ "ts21_p", length));
			String[] ts08P = (JSPUtil.getParameter(request, prefix	+ "ts08_p", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ts15Q = (JSPUtil.getParameter(request, prefix	+ "ts15_q", length));
			String[] ts15P = (JSPUtil.getParameter(request, prefix	+ "ts15_p", length));
			String[] ts01P = (JSPUtil.getParameter(request, prefix	+ "ts01_p", length));
			String[] ts01Q = (JSPUtil.getParameter(request, prefix	+ "ts01_q", length));
			String[] ts25Q = (JSPUtil.getParameter(request, prefix	+ "ts25_q", length));
			String[] ts25P = (JSPUtil.getParameter(request, prefix	+ "ts25_p", length));
			
			for (int i = 0; i < length; i++) {
				model = new DisposalPFMCByEQGRPVO();
				if (ts09Q[i] != null)
					model.setTs09Q(ts09Q[i]);
				if (ts09P[i] != null)
					model.setTs09P(ts09P[i]);
				if (buyerCd[i] != null)
					model.setBuyerCd(buyerCd[i]);
				if (ts19P[i] != null)
					model.setTs19P(ts19P[i]);
				if (ts19Q[i] != null)
					model.setTs19Q(ts19Q[i]);
				if (ts10Q[i] != null)
					model.setTs10Q(ts10Q[i]);
				if (ts10P[i] != null)
					model.setTs10P(ts10P[i]);
				if (ts24Q[i] != null)
					model.setTs24Q(ts24Q[i]);
				if (type[i] != null)
					model.setType(type[i]);
				if (ts04P[i] != null)
					model.setTs04P(ts04P[i]);
				if (ts05P[i] != null)
					model.setTs05P(ts05P[i]);
				if (ts05Q[i] != null)
					model.setTs05Q(ts05Q[i]);
				if (ts04Q[i] != null)
					model.setTs04Q(ts04Q[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ts20P[i] != null)
					model.setTs20P(ts20P[i]);
				if (ts14Q[i] != null)
					model.setTs14Q(ts14Q[i]);
				if (ts14P[i] != null)
					model.setTs14P(ts14P[i]);
				if (ts20Q[i] != null)
					model.setTs20Q(ts20Q[i]);
				if (ts24P[i] != null)
					model.setTs24P(ts24P[i]);
				if (type2[i] != null)
					model.setType2(type2[i]);
				if (ts28P[i] != null)
					model.setTs28P(ts28P[i]);
				if (ts28Q[i] != null)
					model.setTs28Q(ts28Q[i]);
				if (buyerNm[i] != null)
					model.setBuyerNm(buyerNm[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (ts06P[i] != null)
					model.setTs06P(ts06P[i]);
				if (ts30Q[i] != null)
					model.setTs30Q(ts30Q[i]);
				if (ts23Q[i] != null)
					model.setTs23Q(ts23Q[i]);
				if (ts23P[i] != null)
					model.setTs23P(ts23P[i]);
				if (ts30P[i] != null)
					model.setTs30P(ts30P[i]);
				if (ts03Q[i] != null)
					model.setTs03Q(ts03Q[i]);
				if (ts03P[i] != null)
					model.setTs03P(ts03P[i]);
				if (ts13Q[i] != null)
					model.setTs13Q(ts13Q[i]);
				if (ts06Q[i] != null)
					model.setTs06Q(ts06Q[i]);
				if (ts13P[i] != null)
					model.setTs13P(ts13P[i]);
				if (ts29Q[i] != null)
					model.setTs29Q(ts29Q[i]);
				if (ts29P[i] != null)
					model.setTs29P(ts29P[i]);
				if (ts27Q[i] != null)
					model.setTs27Q(ts27Q[i]);
				if (ts27P[i] != null)
					model.setTs27P(ts27P[i]);
				if (ts12Q[i] != null)
					model.setTs12Q(ts12Q[i]);
				if (ts12P[i] != null)
					model.setTs12P(ts12P[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (ts17P[i] != null)
					model.setTs17P(ts17P[i]);
				if (ts17Q[i] != null)
					model.setTs17Q(ts17Q[i]);
				if (ts02P[i] != null)
					model.setTs02P(ts02P[i]);
				if (ts22P[i] != null)
					model.setTs22P(ts22P[i]);
				if (ts07P[i] != null)
					model.setTs07P(ts07P[i]);
				if (ts22Q[i] != null)
					model.setTs22Q(ts22Q[i]);
				if (ts07Q[i] != null)
					model.setTs07Q(ts07Q[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (title[i] != null)
					model.setTitle(title[i]);
				if (ts02Q[i] != null)
					model.setTs02Q(ts02Q[i]);
				if (ts16Q[i] != null)
					model.setTs16Q(ts16Q[i]);
				if (ts16P[i] != null)
					model.setTs16P(ts16P[i]);
				if (ts26P[i] != null)
					model.setTs26P(ts26P[i]);
				if (ts26Q[i] != null)
					model.setTs26Q(ts26Q[i]);
				if (ts18P[i] != null)
					model.setTs18P(ts18P[i]);
				if (ts18Q[i] != null)
					model.setTs18Q(ts18Q[i]);
				if (ts11Q[i] != null)
					model.setTs11Q(ts11Q[i]);
				if (ts11P[i] != null)
					model.setTs11P(ts11P[i]);
				if (ts21Q[i] != null)
					model.setTs21Q(ts21Q[i]);
				if (ts08Q[i] != null)
					model.setTs08Q(ts08Q[i]);
				if (ts21P[i] != null)
					model.setTs21P(ts21P[i]);
				if (ts08P[i] != null)
					model.setTs08P(ts08P[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ts15Q[i] != null)
					model.setTs15Q(ts15Q[i]);
				if (ts15P[i] != null)
					model.setTs15P(ts15P[i]);
				if (ts01P[i] != null)
					model.setTs01P(ts01P[i]);
				if (ts01Q[i] != null)
					model.setTs01Q(ts01Q[i]);
				if (ts25Q[i] != null)
					model.setTs25Q(ts25Q[i]);
				if (ts25P[i] != null)
					model.setTs25P(ts25P[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDisposalPFMCByEQGRPVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DisposalPFMCByEQGRPVO[]
	 */
	public DisposalPFMCByEQGRPVO[] getDisposalPFMCByEQGRPVOs(){
		DisposalPFMCByEQGRPVO[] vos = (DisposalPFMCByEQGRPVO[])models.toArray(new DisposalPFMCByEQGRPVO[models.size()]);
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
		this.ts09Q = this.ts09Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts09P = this.ts09P .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buyerCd = this.buyerCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts19P = this.ts19P .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts19Q = this.ts19Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts10Q = this.ts10Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts10P = this.ts10P .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts24Q = this.ts24Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type = this.type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts04P = this.ts04P .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts05P = this.ts05P .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts05Q = this.ts05Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts04Q = this.ts04Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts20P = this.ts20P .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts14Q = this.ts14Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts14P = this.ts14P .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts20Q = this.ts20Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts24P = this.ts24P .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type2 = this.type2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts28P = this.ts28P .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts28Q = this.ts28Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buyerNm = this.buyerNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts06P = this.ts06P .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts30Q = this.ts30Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts23Q = this.ts23Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts23P = this.ts23P .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts30P = this.ts30P .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts03Q = this.ts03Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts03P = this.ts03P .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts13Q = this.ts13Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts06Q = this.ts06Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts13P = this.ts13P .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts29Q = this.ts29Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts29P = this.ts29P .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts27Q = this.ts27Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts27P = this.ts27P .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts12Q = this.ts12Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts12P = this.ts12P .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts17P = this.ts17P .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts17Q = this.ts17Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts02P = this.ts02P .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts22P = this.ts22P .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts07P = this.ts07P .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts22Q = this.ts22Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts07Q = this.ts07Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.title = this.title .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts02Q = this.ts02Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts16Q = this.ts16Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts16P = this.ts16P .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts26P = this.ts26P .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts26Q = this.ts26Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts18P = this.ts18P .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts18Q = this.ts18Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts11Q = this.ts11Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts11P = this.ts11P .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts21Q = this.ts21Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts08Q = this.ts08Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts21P = this.ts21P .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts08P = this.ts08P .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts15Q = this.ts15Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts15P = this.ts15P .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts01P = this.ts01P .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts01Q = this.ts01Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts25Q = this.ts25Q .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts25P = this.ts25P .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

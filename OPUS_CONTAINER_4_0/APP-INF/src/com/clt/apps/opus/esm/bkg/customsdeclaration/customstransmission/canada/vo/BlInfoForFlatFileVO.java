/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BlInfoForFlatFileVO.java
*@FileTitle : BlInfoForFlatFileVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.24  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo;

import java.lang.reflect.Field;
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

public class BlInfoForFlatFileVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BlInfoForFlatFileVO> models = new ArrayList<BlInfoForFlatFileVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String blrefno = null;
	/* Column Info */
	private String dellcity = null;
	/* Column Info */
	private String custofcd = null;
	/* Column Info */
	private String cneezip = null;
	/* Column Info */
	private String dellstat = null;
	/* Column Info */
	private String poletd = null;
	/* Column Info */
	private String fpoa = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String poletl = null;
	/* Column Info */
	private String ntfyname = null;
	/* Column Info */
	private String terminal = null;
	/* Column Info */
	private String cstmsAckKeyNo = null;
	/* Column Info */
	private String delname = null;
	/* Column Info */
	private String custofco = null;
	/* Column Info */
	private String cneectry = null;
	/* Column Info */
	private String cneestat = null;
	/* Column Info */
	private String shprzip = null;
	/* Column Info */
	private String ntfystat = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String vcrepno = null;
	/* Column Info */
	private String shprctry = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String porcode = null;
	/* Column Info */
	private String cneecity = null;
	/* Column Info */
	private String shprstat = null;
	/* Column Info */
	private String dellyardcd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String delcode = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String blpod = null;
	/* Column Info */
	private String ntfycity = null;
	/* Column Info */
	private String dellname2 = null;
	/* Column Info */
	private String blnbr = null;
	/* Column Info */
	private String ntfyzip = null;
	/* Column Info */
	private String comment1 = null;
	/* Column Info */
	private String mfNo = null;
	/* Column Info */
	private String vslname = null;
	/* Column Info */
	private String cneeaddr = null;
	/* Column Info */
	private String bltrans = null;
	/* Column Info */
	private String blpol = null;
	/* Column Info */
	private String blseq = null;
	/* Column Info */
	private String shprcity = null;
	/* Column Info */
	private String toOrder = null;
	/* Column Info */
	private String cstmsMfTpCd = null;
	/* Column Info */
	private String shprname = null;
	/* Column Info */
	private String dellzip = null;
	/* Column Info */
	private String locgood = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String porname = null;
	/* Column Info */
	private String oldOfcd = null;
	/* Column Info */
	private String polname = null;
	/* Column Info */
	private String smtrind = null;
	/* Column Info */
	private String ntfyctry = null;
	/* Column Info */
	private String delladdr = null;
	/* Column Info */
	private String cneename = null;
	/* Column Info */
	private String dellname = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String dellctry = null;
	/* Column Info */
	private String shpraddr = null;
	/* Column Info */
	private String blrepno = null;
	/* Column Info */
	private String hubLocCd = null;
	/* Column Info */
	private String ntfyaddr = null;
	/* Column Info */
	private String porstat = null;
	/* Column Info */
	private String delstat = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BlInfoForFlatFileVO() {}

	public BlInfoForFlatFileVO(String ibflag, String pagerows, String bkgNo, String blseq, String bltrans, String status, String blrepno, String blnbr, String blrefno, String vcrepno, String smtrind, String vslname, String vvd, String terminal, String blpol, String poletd, String blpod, String poletl, String toOrder, String shprname, String shpraddr, String shprcity, String shprstat, String shprctry, String shprzip, String cneename, String cneeaddr, String cneecity, String cneestat, String cneectry, String cneezip, String ntfyname, String ntfyaddr, String ntfycity, String ntfystat, String ntfyctry, String ntfyzip, String dellyardcd, String dellname, String dellname2, String delladdr, String dellcity, String dellstat, String dellctry, String dellzip, String porname, String polname, String porcode, String delname, String locgood, String delcode, String comment1, String cstmsMfTpCd, String vslCd, String skdVoyNo, String skdDirCd, String cstmsAckKeyNo, String hubLocCd, String fpoa, String custofco, String custofcd, String oldOfcd, String mfNo, String porstat, String delstat) {
		this.vslCd = vslCd;
		this.blrefno = blrefno;
		this.dellcity = dellcity;
		this.custofcd = custofcd;
		this.cneezip = cneezip;
		this.dellstat = dellstat;
		this.poletd = poletd;
		this.fpoa = fpoa;
		this.pagerows = pagerows;
		this.poletl = poletl;
		this.ntfyname = ntfyname;
		this.terminal = terminal;
		this.cstmsAckKeyNo = cstmsAckKeyNo;
		this.delname = delname;
		this.custofco = custofco;
		this.cneectry = cneectry;
		this.cneestat = cneestat;
		this.shprzip = shprzip;
		this.ntfystat = ntfystat;
		this.status = status;
		this.vcrepno = vcrepno;
		this.shprctry = shprctry;
		this.skdVoyNo = skdVoyNo;
		this.porcode = porcode;
		this.cneecity = cneecity;
		this.shprstat = shprstat;
		this.dellyardcd = dellyardcd;
		this.vvd = vvd;
		this.delcode = delcode;
		this.bkgNo = bkgNo;
		this.blpod = blpod;
		this.ntfycity = ntfycity;
		this.dellname2 = dellname2;
		this.blnbr = blnbr;
		this.ntfyzip = ntfyzip;
		this.comment1 = comment1;
		this.mfNo = mfNo;
		this.vslname = vslname;
		this.cneeaddr = cneeaddr;
		this.bltrans = bltrans;
		this.blpol = blpol;
		this.blseq = blseq;
		this.shprcity = shprcity;
		this.toOrder = toOrder;
		this.cstmsMfTpCd = cstmsMfTpCd;
		this.shprname = shprname;
		this.dellzip = dellzip;
		this.locgood = locgood;
		this.ibflag = ibflag;
		this.porname = porname;
		this.oldOfcd = oldOfcd;
		this.polname = polname;
		this.smtrind = smtrind;
		this.ntfyctry = ntfyctry;
		this.delladdr = delladdr;
		this.cneename = cneename;
		this.dellname = dellname;
		this.skdDirCd = skdDirCd;
		this.dellctry = dellctry;
		this.shpraddr = shpraddr;
		this.blrepno = blrepno;
		this.hubLocCd = hubLocCd;
		this.ntfyaddr = ntfyaddr;
		this.porstat = porstat;
		this.delstat = delstat;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("blrefno", getBlrefno());
		this.hashColumns.put("dellcity", getDellcity());
		this.hashColumns.put("custofcd", getCustofcd());
		this.hashColumns.put("cneezip", getCneezip());
		this.hashColumns.put("dellstat", getDellstat());
		this.hashColumns.put("poletd", getPoletd());
		this.hashColumns.put("fpoa", getFpoa());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("poletl", getPoletl());
		this.hashColumns.put("ntfyname", getNtfyname());
		this.hashColumns.put("terminal", getTerminal());
		this.hashColumns.put("cstms_ack_key_no", getCstmsAckKeyNo());
		this.hashColumns.put("delname", getDelname());
		this.hashColumns.put("custofco", getCustofco());
		this.hashColumns.put("cneectry", getCneectry());
		this.hashColumns.put("cneestat", getCneestat());
		this.hashColumns.put("shprzip", getShprzip());
		this.hashColumns.put("ntfystat", getNtfystat());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("vcrepno", getVcrepno());
		this.hashColumns.put("shprctry", getShprctry());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("porcode", getPorcode());
		this.hashColumns.put("cneecity", getCneecity());
		this.hashColumns.put("shprstat", getShprstat());
		this.hashColumns.put("dellyardcd", getDellyardcd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("delcode", getDelcode());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("blpod", getBlpod());
		this.hashColumns.put("ntfycity", getNtfycity());
		this.hashColumns.put("dellname2", getDellname2());
		this.hashColumns.put("blnbr", getBlnbr());
		this.hashColumns.put("ntfyzip", getNtfyzip());
		this.hashColumns.put("comment1", getComment1());
		this.hashColumns.put("mf_no", getMfNo());
		this.hashColumns.put("vslname", getVslname());
		this.hashColumns.put("cneeaddr", getCneeaddr());
		this.hashColumns.put("bltrans", getBltrans());
		this.hashColumns.put("blpol", getBlpol());
		this.hashColumns.put("blseq", getBlseq());
		this.hashColumns.put("shprcity", getShprcity());
		this.hashColumns.put("to_order", getToOrder());
		this.hashColumns.put("cstms_mf_tp_cd", getCstmsMfTpCd());
		this.hashColumns.put("shprname", getShprname());
		this.hashColumns.put("dellzip", getDellzip());
		this.hashColumns.put("locgood", getLocgood());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("porname", getPorname());
		this.hashColumns.put("old_ofcd", getOldOfcd());
		this.hashColumns.put("polname", getPolname());
		this.hashColumns.put("smtrind", getSmtrind());
		this.hashColumns.put("ntfyctry", getNtfyctry());
		this.hashColumns.put("delladdr", getDelladdr());
		this.hashColumns.put("cneename", getCneename());
		this.hashColumns.put("dellname", getDellname());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("dellctry", getDellctry());
		this.hashColumns.put("shpraddr", getShpraddr());
		this.hashColumns.put("blrepno", getBlrepno());
		this.hashColumns.put("hub_loc_cd", getHubLocCd());
		this.hashColumns.put("ntfyaddr", getNtfyaddr());
		this.hashColumns.put("delstat", getPorstat());
		this.hashColumns.put("delstat", getDelstat());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("blrefno", "blrefno");
		this.hashFields.put("dellcity", "dellcity");
		this.hashFields.put("custofcd", "custofcd");
		this.hashFields.put("cneezip", "cneezip");
		this.hashFields.put("dellstat", "dellstat");
		this.hashFields.put("poletd", "poletd");
		this.hashFields.put("fpoa", "fpoa");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("poletl", "poletl");
		this.hashFields.put("ntfyname", "ntfyname");
		this.hashFields.put("terminal", "terminal");
		this.hashFields.put("cstms_ack_key_no", "cstmsAckKeyNo");
		this.hashFields.put("delname", "delname");
		this.hashFields.put("custofco", "custofco");
		this.hashFields.put("cneectry", "cneectry");
		this.hashFields.put("cneestat", "cneestat");
		this.hashFields.put("shprzip", "shprzip");
		this.hashFields.put("ntfystat", "ntfystat");
		this.hashFields.put("status", "status");
		this.hashFields.put("vcrepno", "vcrepno");
		this.hashFields.put("shprctry", "shprctry");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("porcode", "porcode");
		this.hashFields.put("cneecity", "cneecity");
		this.hashFields.put("shprstat", "shprstat");
		this.hashFields.put("dellyardcd", "dellyardcd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("delcode", "delcode");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("blpod", "blpod");
		this.hashFields.put("ntfycity", "ntfycity");
		this.hashFields.put("dellname2", "dellname2");
		this.hashFields.put("blnbr", "blnbr");
		this.hashFields.put("ntfyzip", "ntfyzip");
		this.hashFields.put("comment1", "comment1");
		this.hashFields.put("mf_no", "mfNo");
		this.hashFields.put("vslname", "vslname");
		this.hashFields.put("cneeaddr", "cneeaddr");
		this.hashFields.put("bltrans", "bltrans");
		this.hashFields.put("blpol", "blpol");
		this.hashFields.put("blseq", "blseq");
		this.hashFields.put("shprcity", "shprcity");
		this.hashFields.put("to_order", "toOrder");
		this.hashFields.put("cstms_mf_tp_cd", "cstmsMfTpCd");
		this.hashFields.put("shprname", "shprname");
		this.hashFields.put("dellzip", "dellzip");
		this.hashFields.put("locgood", "locgood");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("porname", "porname");
		this.hashFields.put("old_ofcd", "oldOfcd");
		this.hashFields.put("polname", "polname");
		this.hashFields.put("smtrind", "smtrind");
		this.hashFields.put("ntfyctry", "ntfyctry");
		this.hashFields.put("delladdr", "delladdr");
		this.hashFields.put("cneename", "cneename");
		this.hashFields.put("dellname", "dellname");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("dellctry", "dellctry");
		this.hashFields.put("shpraddr", "shpraddr");
		this.hashFields.put("blrepno", "blrepno");
		this.hashFields.put("hub_loc_cd", "hubLocCd");
		this.hashFields.put("ntfyaddr", "ntfyaddr");
		this.hashFields.put("porstat", "porstat");
		this.hashFields.put("delstat", "delstat");
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
	 * @return blrefno
	 */
	public String getBlrefno() {
		return this.blrefno;
	}
	
	/**
	 * Column Info
	 * @return dellcity
	 */
	public String getDellcity() {
		return this.dellcity;
	}
	
	/**
	 * Column Info
	 * @return custofcd
	 */
	public String getCustofcd() {
		return this.custofcd;
	}
	
	/**
	 * Column Info
	 * @return cneezip
	 */
	public String getCneezip() {
		return this.cneezip;
	}
	
	/**
	 * Column Info
	 * @return dellstat
	 */
	public String getDellstat() {
		return this.dellstat;
	}
	
	/**
	 * Column Info
	 * @return poletd
	 */
	public String getPoletd() {
		return this.poletd;
	}
	
	/**
	 * Column Info
	 * @return fpoa
	 */
	public String getFpoa() {
		return this.fpoa;
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
	 * @return poletl
	 */
	public String getPoletl() {
		return this.poletl;
	}
	
	/**
	 * Column Info
	 * @return ntfyname
	 */
	public String getNtfyname() {
		return this.ntfyname;
	}
	
	/**
	 * Column Info
	 * @return terminal
	 */
	public String getTerminal() {
		return this.terminal;
	}
	
	/**
	 * Column Info
	 * @return cstmsAckKeyNo
	 */
	public String getCstmsAckKeyNo() {
		return this.cstmsAckKeyNo;
	}
	
	/**
	 * Column Info
	 * @return delname
	 */
	public String getDelname() {
		return this.delname;
	}
	
	/**
	 * Column Info
	 * @return custofco
	 */
	public String getCustofco() {
		return this.custofco;
	}
	
	/**
	 * Column Info
	 * @return cneectry
	 */
	public String getCneectry() {
		return this.cneectry;
	}
	
	/**
	 * Column Info
	 * @return cneestat
	 */
	public String getCneestat() {
		return this.cneestat;
	}
	
	/**
	 * Column Info
	 * @return shprzip
	 */
	public String getShprzip() {
		return this.shprzip;
	}
	
	/**
	 * Column Info
	 * @return ntfystat
	 */
	public String getNtfystat() {
		return this.ntfystat;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return vcrepno
	 */
	public String getVcrepno() {
		return this.vcrepno;
	}
	
	/**
	 * Column Info
	 * @return shprctry
	 */
	public String getShprctry() {
		return this.shprctry;
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
	 * @return porcode
	 */
	public String getPorcode() {
		return this.porcode;
	}
	
	/**
	 * Column Info
	 * @return cneecity
	 */
	public String getCneecity() {
		return this.cneecity;
	}
	
	/**
	 * Column Info
	 * @return shprstat
	 */
	public String getShprstat() {
		return this.shprstat;
	}
	
	/**
	 * Column Info
	 * @return dellyardcd
	 */
	public String getDellyardcd() {
		return this.dellyardcd;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return delcode
	 */
	public String getDelcode() {
		return this.delcode;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return blpod
	 */
	public String getBlpod() {
		return this.blpod;
	}
	
	/**
	 * Column Info
	 * @return ntfycity
	 */
	public String getNtfycity() {
		return this.ntfycity;
	}
	
	/**
	 * Column Info
	 * @return dellname2
	 */
	public String getDellname2() {
		return this.dellname2;
	}
	
	/**
	 * Column Info
	 * @return blnbr
	 */
	public String getBlnbr() {
		return this.blnbr;
	}
	
	/**
	 * Column Info
	 * @return ntfyzip
	 */
	public String getNtfyzip() {
		return this.ntfyzip;
	}
	
	/**
	 * Column Info
	 * @return comment1
	 */
	public String getComment1() {
		return this.comment1;
	}
	
	/**
	 * Column Info
	 * @return mfNo
	 */
	public String getMfNo() {
		return this.mfNo;
	}
	
	/**
	 * Column Info
	 * @return vslname
	 */
	public String getVslname() {
		return this.vslname;
	}
	
	/**
	 * Column Info
	 * @return cneeaddr
	 */
	public String getCneeaddr() {
		return this.cneeaddr;
	}
	
	/**
	 * Column Info
	 * @return bltrans
	 */
	public String getBltrans() {
		return this.bltrans;
	}
	
	/**
	 * Column Info
	 * @return blpol
	 */
	public String getBlpol() {
		return this.blpol;
	}
	
	/**
	 * Column Info
	 * @return blseq
	 */
	public String getBlseq() {
		return this.blseq;
	}
	
	/**
	 * Column Info
	 * @return shprcity
	 */
	public String getShprcity() {
		return this.shprcity;
	}
	
	/**
	 * Column Info
	 * @return toOrder
	 */
	public String getToOrder() {
		return this.toOrder;
	}
	
	/**
	 * Column Info
	 * @return cstmsMfTpCd
	 */
	public String getCstmsMfTpCd() {
		return this.cstmsMfTpCd;
	}
	
	/**
	 * Column Info
	 * @return shprname
	 */
	public String getShprname() {
		return this.shprname;
	}
	
	/**
	 * Column Info
	 * @return dellzip
	 */
	public String getDellzip() {
		return this.dellzip;
	}
	
	/**
	 * Column Info
	 * @return locgood
	 */
	public String getLocgood() {
		return this.locgood;
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
	 * @return porname
	 */
	public String getPorname() {
		return this.porname;
	}
	
	/**
	 * Column Info
	 * @return oldOfcd
	 */
	public String getOldOfcd() {
		return this.oldOfcd;
	}
	
	/**
	 * Column Info
	 * @return polname
	 */
	public String getPolname() {
		return this.polname;
	}
	
	/**
	 * Column Info
	 * @return smtrind
	 */
	public String getSmtrind() {
		return this.smtrind;
	}
	
	/**
	 * Column Info
	 * @return ntfyctry
	 */
	public String getNtfyctry() {
		return this.ntfyctry;
	}
	
	/**
	 * Column Info
	 * @return delladdr
	 */
	public String getDelladdr() {
		return this.delladdr;
	}
	
	/**
	 * Column Info
	 * @return cneename
	 */
	public String getCneename() {
		return this.cneename;
	}
	
	/**
	 * Column Info
	 * @return dellname
	 */
	public String getDellname() {
		return this.dellname;
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
	 * @return dellctry
	 */
	public String getDellctry() {
		return this.dellctry;
	}
	
	/**
	 * Column Info
	 * @return shpraddr
	 */
	public String getShpraddr() {
		return this.shpraddr;
	}
	
	/**
	 * Column Info
	 * @return blrepno
	 */
	public String getBlrepno() {
		return this.blrepno;
	}
	
	/**
	 * Column Info
	 * @return hubLocCd
	 */
	public String getHubLocCd() {
		return this.hubLocCd;
	}
	
	/**
	 * Column Info
	 * @return ntfyaddr
	 */
	public String getNtfyaddr() {
		return this.ntfyaddr;
	}
	
	/**
	 * Column Info
	 * @return porstat
	 */
	public String getPorstat() {
		return this.porstat;
	}
	
	/**
	 * Column Info
	 * @return delstat
	 */
	public String getDelstat() {
		return this.delstat;
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
	 * @param blrefno
	 */
	public void setBlrefno(String blrefno) {
		this.blrefno = blrefno;
	}
	
	/**
	 * Column Info
	 * @param dellcity
	 */
	public void setDellcity(String dellcity) {
		this.dellcity = dellcity;
	}
	
	/**
	 * Column Info
	 * @param custofcd
	 */
	public void setCustofcd(String custofcd) {
		this.custofcd = custofcd;
	}
	
	/**
	 * Column Info
	 * @param cneezip
	 */
	public void setCneezip(String cneezip) {
		this.cneezip = cneezip;
	}
	
	/**
	 * Column Info
	 * @param dellstat
	 */
	public void setDellstat(String dellstat) {
		this.dellstat = dellstat;
	}
	
	/**
	 * Column Info
	 * @param poletd
	 */
	public void setPoletd(String poletd) {
		this.poletd = poletd;
	}
	
	/**
	 * Column Info
	 * @param fpoa
	 */
	public void setFpoa(String fpoa) {
		this.fpoa = fpoa;
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
	 * @param poletl
	 */
	public void setPoletl(String poletl) {
		this.poletl = poletl;
	}
	
	/**
	 * Column Info
	 * @param ntfyname
	 */
	public void setNtfyname(String ntfyname) {
		this.ntfyname = ntfyname;
	}
	
	/**
	 * Column Info
	 * @param terminal
	 */
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
	
	/**
	 * Column Info
	 * @param cstmsAckKeyNo
	 */
	public void setCstmsAckKeyNo(String cstmsAckKeyNo) {
		this.cstmsAckKeyNo = cstmsAckKeyNo;
	}
	
	/**
	 * Column Info
	 * @param delname
	 */
	public void setDelname(String delname) {
		this.delname = delname;
	}
	
	/**
	 * Column Info
	 * @param custofco
	 */
	public void setCustofco(String custofco) {
		this.custofco = custofco;
	}
	
	/**
	 * Column Info
	 * @param cneectry
	 */
	public void setCneectry(String cneectry) {
		this.cneectry = cneectry;
	}
	
	/**
	 * Column Info
	 * @param cneestat
	 */
	public void setCneestat(String cneestat) {
		this.cneestat = cneestat;
	}
	
	/**
	 * Column Info
	 * @param shprzip
	 */
	public void setShprzip(String shprzip) {
		this.shprzip = shprzip;
	}
	
	/**
	 * Column Info
	 * @param ntfystat
	 */
	public void setNtfystat(String ntfystat) {
		this.ntfystat = ntfystat;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param vcrepno
	 */
	public void setVcrepno(String vcrepno) {
		this.vcrepno = vcrepno;
	}
	
	/**
	 * Column Info
	 * @param shprctry
	 */
	public void setShprctry(String shprctry) {
		this.shprctry = shprctry;
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
	 * @param porcode
	 */
	public void setPorcode(String porcode) {
		this.porcode = porcode;
	}
	
	/**
	 * Column Info
	 * @param cneecity
	 */
	public void setCneecity(String cneecity) {
		this.cneecity = cneecity;
	}
	
	/**
	 * Column Info
	 * @param shprstat
	 */
	public void setShprstat(String shprstat) {
		this.shprstat = shprstat;
	}
	
	/**
	 * Column Info
	 * @param dellyardcd
	 */
	public void setDellyardcd(String dellyardcd) {
		this.dellyardcd = dellyardcd;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param delcode
	 */
	public void setDelcode(String delcode) {
		this.delcode = delcode;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param blpod
	 */
	public void setBlpod(String blpod) {
		this.blpod = blpod;
	}
	
	/**
	 * Column Info
	 * @param ntfycity
	 */
	public void setNtfycity(String ntfycity) {
		this.ntfycity = ntfycity;
	}
	
	/**
	 * Column Info
	 * @param dellname2
	 */
	public void setDellname2(String dellname2) {
		this.dellname2 = dellname2;
	}
	
	/**
	 * Column Info
	 * @param blnbr
	 */
	public void setBlnbr(String blnbr) {
		this.blnbr = blnbr;
	}
	
	/**
	 * Column Info
	 * @param ntfyzip
	 */
	public void setNtfyzip(String ntfyzip) {
		this.ntfyzip = ntfyzip;
	}
	
	/**
	 * Column Info
	 * @param comment1
	 */
	public void setComment1(String comment1) {
		this.comment1 = comment1;
	}
	
	/**
	 * Column Info
	 * @param mfNo
	 */
	public void setMfNo(String mfNo) {
		this.mfNo = mfNo;
	}
	
	/**
	 * Column Info
	 * @param vslname
	 */
	public void setVslname(String vslname) {
		this.vslname = vslname;
	}
	
	/**
	 * Column Info
	 * @param cneeaddr
	 */
	public void setCneeaddr(String cneeaddr) {
		this.cneeaddr = cneeaddr;
	}
	
	/**
	 * Column Info
	 * @param bltrans
	 */
	public void setBltrans(String bltrans) {
		this.bltrans = bltrans;
	}
	
	/**
	 * Column Info
	 * @param blpol
	 */
	public void setBlpol(String blpol) {
		this.blpol = blpol;
	}
	
	/**
	 * Column Info
	 * @param blseq
	 */
	public void setBlseq(String blseq) {
		this.blseq = blseq;
	}
	
	/**
	 * Column Info
	 * @param shprcity
	 */
	public void setShprcity(String shprcity) {
		this.shprcity = shprcity;
	}
	
	/**
	 * Column Info
	 * @param toOrder
	 */
	public void setToOrder(String toOrder) {
		this.toOrder = toOrder;
	}
	
	/**
	 * Column Info
	 * @param cstmsMfTpCd
	 */
	public void setCstmsMfTpCd(String cstmsMfTpCd) {
		this.cstmsMfTpCd = cstmsMfTpCd;
	}
	
	/**
	 * Column Info
	 * @param shprname
	 */
	public void setShprname(String shprname) {
		this.shprname = shprname;
	}
	
	/**
	 * Column Info
	 * @param dellzip
	 */
	public void setDellzip(String dellzip) {
		this.dellzip = dellzip;
	}
	
	/**
	 * Column Info
	 * @param locgood
	 */
	public void setLocgood(String locgood) {
		this.locgood = locgood;
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
	 * @param porname
	 */
	public void setPorname(String porname) {
		this.porname = porname;
	}
	
	/**
	 * Column Info
	 * @param oldOfcd
	 */
	public void setOldOfcd(String oldOfcd) {
		this.oldOfcd = oldOfcd;
	}
	
	/**
	 * Column Info
	 * @param polname
	 */
	public void setPolname(String polname) {
		this.polname = polname;
	}
	
	/**
	 * Column Info
	 * @param smtrind
	 */
	public void setSmtrind(String smtrind) {
		this.smtrind = smtrind;
	}
	
	/**
	 * Column Info
	 * @param ntfyctry
	 */
	public void setNtfyctry(String ntfyctry) {
		this.ntfyctry = ntfyctry;
	}
	
	/**
	 * Column Info
	 * @param delladdr
	 */
	public void setDelladdr(String delladdr) {
		this.delladdr = delladdr;
	}
	
	/**
	 * Column Info
	 * @param cneename
	 */
	public void setCneename(String cneename) {
		this.cneename = cneename;
	}
	
	/**
	 * Column Info
	 * @param dellname
	 */
	public void setDellname(String dellname) {
		this.dellname = dellname;
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
	 * @param dellctry
	 */
	public void setDellctry(String dellctry) {
		this.dellctry = dellctry;
	}
	
	/**
	 * Column Info
	 * @param shpraddr
	 */
	public void setShpraddr(String shpraddr) {
		this.shpraddr = shpraddr;
	}
	
	/**
	 * Column Info
	 * @param blrepno
	 */
	public void setBlrepno(String blrepno) {
		this.blrepno = blrepno;
	}
	
	/**
	 * Column Info
	 * @param hubLocCd
	 */
	public void setHubLocCd(String hubLocCd) {
		this.hubLocCd = hubLocCd;
	}
	
	/**
	 * Column Info
	 * @param ntfyaddr
	 */
	public void setNtfyaddr(String ntfyaddr) {
		this.ntfyaddr = ntfyaddr;
	}
	
	/**
	 * Column Info
	 * @param porstat
	 */
	public void setPorstat(String porstat) {
		this.porstat = porstat;
	}
	
	/**
	 * Column Info
	 * @param delstat
	 */
	public void setDelstat(String delstat) {
		this.delstat = delstat;
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
		setBlrefno(JSPUtil.getParameter(request, prefix + "blrefno", ""));
		setDellcity(JSPUtil.getParameter(request, prefix + "dellcity", ""));
		setCustofcd(JSPUtil.getParameter(request, prefix + "custofcd", ""));
		setCneezip(JSPUtil.getParameter(request, prefix + "cneezip", ""));
		setDellstat(JSPUtil.getParameter(request, prefix + "dellstat", ""));
		setPoletd(JSPUtil.getParameter(request, prefix + "poletd", ""));
		setFpoa(JSPUtil.getParameter(request, prefix + "fpoa", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPoletl(JSPUtil.getParameter(request, prefix + "poletl", ""));
		setNtfyname(JSPUtil.getParameter(request, prefix + "ntfyname", ""));
		setTerminal(JSPUtil.getParameter(request, prefix + "terminal", ""));
		setCstmsAckKeyNo(JSPUtil.getParameter(request, prefix + "cstms_ack_key_no", ""));
		setDelname(JSPUtil.getParameter(request, prefix + "delname", ""));
		setCustofco(JSPUtil.getParameter(request, prefix + "custofco", ""));
		setCneectry(JSPUtil.getParameter(request, prefix + "cneectry", ""));
		setCneestat(JSPUtil.getParameter(request, prefix + "cneestat", ""));
		setShprzip(JSPUtil.getParameter(request, prefix + "shprzip", ""));
		setNtfystat(JSPUtil.getParameter(request, prefix + "ntfystat", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setVcrepno(JSPUtil.getParameter(request, prefix + "vcrepno", ""));
		setShprctry(JSPUtil.getParameter(request, prefix + "shprctry", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setPorcode(JSPUtil.getParameter(request, prefix + "porcode", ""));
		setCneecity(JSPUtil.getParameter(request, prefix + "cneecity", ""));
		setShprstat(JSPUtil.getParameter(request, prefix + "shprstat", ""));
		setDellyardcd(JSPUtil.getParameter(request, prefix + "dellyardcd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setDelcode(JSPUtil.getParameter(request, prefix + "delcode", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setBlpod(JSPUtil.getParameter(request, prefix + "blpod", ""));
		setNtfycity(JSPUtil.getParameter(request, prefix + "ntfycity", ""));
		setDellname2(JSPUtil.getParameter(request, prefix + "dellname2", ""));
		setBlnbr(JSPUtil.getParameter(request, prefix + "blnbr", ""));
		setNtfyzip(JSPUtil.getParameter(request, prefix + "ntfyzip", ""));
		setComment1(JSPUtil.getParameter(request, prefix + "comment1", ""));
		setMfNo(JSPUtil.getParameter(request, prefix + "mf_no", ""));
		setVslname(JSPUtil.getParameter(request, prefix + "vslname", ""));
		setCneeaddr(JSPUtil.getParameter(request, prefix + "cneeaddr", ""));
		setBltrans(JSPUtil.getParameter(request, prefix + "bltrans", ""));
		setBlpol(JSPUtil.getParameter(request, prefix + "blpol", ""));
		setBlseq(JSPUtil.getParameter(request, prefix + "blseq", ""));
		setShprcity(JSPUtil.getParameter(request, prefix + "shprcity", ""));
		setToOrder(JSPUtil.getParameter(request, prefix + "to_order", ""));
		setCstmsMfTpCd(JSPUtil.getParameter(request, prefix + "cstms_mf_tp_cd", ""));
		setShprname(JSPUtil.getParameter(request, prefix + "shprname", ""));
		setDellzip(JSPUtil.getParameter(request, prefix + "dellzip", ""));
		setLocgood(JSPUtil.getParameter(request, prefix + "locgood", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPorname(JSPUtil.getParameter(request, prefix + "porname", ""));
		setOldOfcd(JSPUtil.getParameter(request, prefix + "old_ofcd", ""));
		setPolname(JSPUtil.getParameter(request, prefix + "polname", ""));
		setSmtrind(JSPUtil.getParameter(request, prefix + "smtrind", ""));
		setNtfyctry(JSPUtil.getParameter(request, prefix + "ntfyctry", ""));
		setDelladdr(JSPUtil.getParameter(request, prefix + "delladdr", ""));
		setCneename(JSPUtil.getParameter(request, prefix + "cneename", ""));
		setDellname(JSPUtil.getParameter(request, prefix + "dellname", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setDellctry(JSPUtil.getParameter(request, prefix + "dellctry", ""));
		setShpraddr(JSPUtil.getParameter(request, prefix + "shpraddr", ""));
		setBlrepno(JSPUtil.getParameter(request, prefix + "blrepno", ""));
		setHubLocCd(JSPUtil.getParameter(request, prefix + "hub_loc_cd", ""));
		setNtfyaddr(JSPUtil.getParameter(request, prefix + "ntfyaddr", ""));
		setPorstat(JSPUtil.getParameter(request, prefix + "porstat", ""));
		setDelstat(JSPUtil.getParameter(request, prefix + "delstat", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BlInfoForFlatFileVO[]
	 */
	public BlInfoForFlatFileVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BlInfoForFlatFileVO[]
	 */
	public BlInfoForFlatFileVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BlInfoForFlatFileVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] blrefno = (JSPUtil.getParameter(request, prefix	+ "blrefno", length));
			String[] dellcity = (JSPUtil.getParameter(request, prefix	+ "dellcity", length));
			String[] custofcd = (JSPUtil.getParameter(request, prefix	+ "custofcd", length));
			String[] cneezip = (JSPUtil.getParameter(request, prefix	+ "cneezip", length));
			String[] dellstat = (JSPUtil.getParameter(request, prefix	+ "dellstat", length));
			String[] poletd = (JSPUtil.getParameter(request, prefix	+ "poletd", length));
			String[] fpoa = (JSPUtil.getParameter(request, prefix	+ "fpoa", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] poletl = (JSPUtil.getParameter(request, prefix	+ "poletl", length));
			String[] ntfyname = (JSPUtil.getParameter(request, prefix	+ "ntfyname", length));
			String[] terminal = (JSPUtil.getParameter(request, prefix	+ "terminal", length));
			String[] cstmsAckKeyNo = (JSPUtil.getParameter(request, prefix	+ "cstms_ack_key_no", length));
			String[] delname = (JSPUtil.getParameter(request, prefix	+ "delname", length));
			String[] custofco = (JSPUtil.getParameter(request, prefix	+ "custofco", length));
			String[] cneectry = (JSPUtil.getParameter(request, prefix	+ "cneectry", length));
			String[] cneestat = (JSPUtil.getParameter(request, prefix	+ "cneestat", length));
			String[] shprzip = (JSPUtil.getParameter(request, prefix	+ "shprzip", length));
			String[] ntfystat = (JSPUtil.getParameter(request, prefix	+ "ntfystat", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] vcrepno = (JSPUtil.getParameter(request, prefix	+ "vcrepno", length));
			String[] shprctry = (JSPUtil.getParameter(request, prefix	+ "shprctry", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] porcode = (JSPUtil.getParameter(request, prefix	+ "porcode", length));
			String[] cneecity = (JSPUtil.getParameter(request, prefix	+ "cneecity", length));
			String[] shprstat = (JSPUtil.getParameter(request, prefix	+ "shprstat", length));
			String[] dellyardcd = (JSPUtil.getParameter(request, prefix	+ "dellyardcd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] delcode = (JSPUtil.getParameter(request, prefix	+ "delcode", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] blpod = (JSPUtil.getParameter(request, prefix	+ "blpod", length));
			String[] ntfycity = (JSPUtil.getParameter(request, prefix	+ "ntfycity", length));
			String[] dellname2 = (JSPUtil.getParameter(request, prefix	+ "dellname2", length));
			String[] blnbr = (JSPUtil.getParameter(request, prefix	+ "blnbr", length));
			String[] ntfyzip = (JSPUtil.getParameter(request, prefix	+ "ntfyzip", length));
			String[] comment1 = (JSPUtil.getParameter(request, prefix	+ "comment1", length));
			String[] mfNo = (JSPUtil.getParameter(request, prefix	+ "mf_no", length));
			String[] vslname = (JSPUtil.getParameter(request, prefix	+ "vslname", length));
			String[] cneeaddr = (JSPUtil.getParameter(request, prefix	+ "cneeaddr", length));
			String[] bltrans = (JSPUtil.getParameter(request, prefix	+ "bltrans", length));
			String[] blpol = (JSPUtil.getParameter(request, prefix	+ "blpol", length));
			String[] blseq = (JSPUtil.getParameter(request, prefix	+ "blseq", length));
			String[] shprcity = (JSPUtil.getParameter(request, prefix	+ "shprcity", length));
			String[] toOrder = (JSPUtil.getParameter(request, prefix	+ "to_order", length));
			String[] cstmsMfTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_mf_tp_cd", length));
			String[] shprname = (JSPUtil.getParameter(request, prefix	+ "shprname", length));
			String[] dellzip = (JSPUtil.getParameter(request, prefix	+ "dellzip", length));
			String[] locgood = (JSPUtil.getParameter(request, prefix	+ "locgood", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] porname = (JSPUtil.getParameter(request, prefix	+ "porname", length));
			String[] oldOfcd = (JSPUtil.getParameter(request, prefix	+ "old_ofcd", length));
			String[] polname = (JSPUtil.getParameter(request, prefix	+ "polname", length));
			String[] smtrind = (JSPUtil.getParameter(request, prefix	+ "smtrind", length));
			String[] ntfyctry = (JSPUtil.getParameter(request, prefix	+ "ntfyctry", length));
			String[] delladdr = (JSPUtil.getParameter(request, prefix	+ "delladdr", length));
			String[] cneename = (JSPUtil.getParameter(request, prefix	+ "cneename", length));
			String[] dellname = (JSPUtil.getParameter(request, prefix	+ "dellname", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] dellctry = (JSPUtil.getParameter(request, prefix	+ "dellctry", length));
			String[] shpraddr = (JSPUtil.getParameter(request, prefix	+ "shpraddr", length));
			String[] blrepno = (JSPUtil.getParameter(request, prefix	+ "blrepno", length));
			String[] hubLocCd = (JSPUtil.getParameter(request, prefix	+ "hub_loc_cd", length));
			String[] ntfyaddr = (JSPUtil.getParameter(request, prefix	+ "ntfyaddr", length));
			String[] porstat = (JSPUtil.getParameter(request, prefix	+ "porstat", length));
			String[] delstat = (JSPUtil.getParameter(request, prefix	+ "delstat", length));
			
			for (int i = 0; i < length; i++) {
				model = new BlInfoForFlatFileVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (blrefno[i] != null)
					model.setBlrefno(blrefno[i]);
				if (dellcity[i] != null)
					model.setDellcity(dellcity[i]);
				if (custofcd[i] != null)
					model.setCustofcd(custofcd[i]);
				if (cneezip[i] != null)
					model.setCneezip(cneezip[i]);
				if (dellstat[i] != null)
					model.setDellstat(dellstat[i]);
				if (poletd[i] != null)
					model.setPoletd(poletd[i]);
				if (fpoa[i] != null)
					model.setFpoa(fpoa[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (poletl[i] != null)
					model.setPoletl(poletl[i]);
				if (ntfyname[i] != null)
					model.setNtfyname(ntfyname[i]);
				if (terminal[i] != null)
					model.setTerminal(terminal[i]);
				if (cstmsAckKeyNo[i] != null)
					model.setCstmsAckKeyNo(cstmsAckKeyNo[i]);
				if (delname[i] != null)
					model.setDelname(delname[i]);
				if (custofco[i] != null)
					model.setCustofco(custofco[i]);
				if (cneectry[i] != null)
					model.setCneectry(cneectry[i]);
				if (cneestat[i] != null)
					model.setCneestat(cneestat[i]);
				if (shprzip[i] != null)
					model.setShprzip(shprzip[i]);
				if (ntfystat[i] != null)
					model.setNtfystat(ntfystat[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (vcrepno[i] != null)
					model.setVcrepno(vcrepno[i]);
				if (shprctry[i] != null)
					model.setShprctry(shprctry[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (porcode[i] != null)
					model.setPorcode(porcode[i]);
				if (cneecity[i] != null)
					model.setCneecity(cneecity[i]);
				if (shprstat[i] != null)
					model.setShprstat(shprstat[i]);
				if (dellyardcd[i] != null)
					model.setDellyardcd(dellyardcd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (delcode[i] != null)
					model.setDelcode(delcode[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (blpod[i] != null)
					model.setBlpod(blpod[i]);
				if (ntfycity[i] != null)
					model.setNtfycity(ntfycity[i]);
				if (dellname2[i] != null)
					model.setDellname2(dellname2[i]);
				if (blnbr[i] != null)
					model.setBlnbr(blnbr[i]);
				if (ntfyzip[i] != null)
					model.setNtfyzip(ntfyzip[i]);
				if (comment1[i] != null)
					model.setComment1(comment1[i]);
				if (mfNo[i] != null)
					model.setMfNo(mfNo[i]);
				if (vslname[i] != null)
					model.setVslname(vslname[i]);
				if (cneeaddr[i] != null)
					model.setCneeaddr(cneeaddr[i]);
				if (bltrans[i] != null)
					model.setBltrans(bltrans[i]);
				if (blpol[i] != null)
					model.setBlpol(blpol[i]);
				if (blseq[i] != null)
					model.setBlseq(blseq[i]);
				if (shprcity[i] != null)
					model.setShprcity(shprcity[i]);
				if (toOrder[i] != null)
					model.setToOrder(toOrder[i]);
				if (cstmsMfTpCd[i] != null)
					model.setCstmsMfTpCd(cstmsMfTpCd[i]);
				if (shprname[i] != null)
					model.setShprname(shprname[i]);
				if (dellzip[i] != null)
					model.setDellzip(dellzip[i]);
				if (locgood[i] != null)
					model.setLocgood(locgood[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (porname[i] != null)
					model.setPorname(porname[i]);
				if (oldOfcd[i] != null)
					model.setOldOfcd(oldOfcd[i]);
				if (polname[i] != null)
					model.setPolname(polname[i]);
				if (smtrind[i] != null)
					model.setSmtrind(smtrind[i]);
				if (ntfyctry[i] != null)
					model.setNtfyctry(ntfyctry[i]);
				if (delladdr[i] != null)
					model.setDelladdr(delladdr[i]);
				if (cneename[i] != null)
					model.setCneename(cneename[i]);
				if (dellname[i] != null)
					model.setDellname(dellname[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (dellctry[i] != null)
					model.setDellctry(dellctry[i]);
				if (shpraddr[i] != null)
					model.setShpraddr(shpraddr[i]);
				if (blrepno[i] != null)
					model.setBlrepno(blrepno[i]);
				if (hubLocCd[i] != null)
					model.setHubLocCd(hubLocCd[i]);
				if (ntfyaddr[i] != null)
					model.setNtfyaddr(ntfyaddr[i]);
				if (porstat[i] != null)
					model.setPorstat(porstat[i]);
				if (delstat[i] != null)
					model.setDelstat(delstat[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBlInfoForFlatFileVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlInfoForFlatFileVO[]
	 */
	public BlInfoForFlatFileVO[] getBlInfoForFlatFileVOs(){
		BlInfoForFlatFileVO[] vos = (BlInfoForFlatFileVO[])models.toArray(new BlInfoForFlatFileVO[models.size()]);
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
		this.blrefno = this.blrefno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dellcity = this.dellcity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custofcd = this.custofcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneezip = this.cneezip .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dellstat = this.dellstat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poletd = this.poletd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fpoa = this.fpoa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poletl = this.poletl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyname = this.ntfyname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.terminal = this.terminal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsAckKeyNo = this.cstmsAckKeyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delname = this.delname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custofco = this.custofco .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneectry = this.cneectry .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneestat = this.cneestat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprzip = this.shprzip .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfystat = this.ntfystat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vcrepno = this.vcrepno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprctry = this.shprctry .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porcode = this.porcode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneecity = this.cneecity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprstat = this.shprstat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dellyardcd = this.dellyardcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delcode = this.delcode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpod = this.blpod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfycity = this.ntfycity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dellname2 = this.dellname2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blnbr = this.blnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyzip = this.ntfyzip .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comment1 = this.comment1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfNo = this.mfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslname = this.vslname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeaddr = this.cneeaddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bltrans = this.bltrans .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpol = this.blpol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blseq = this.blseq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprcity = this.shprcity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toOrder = this.toOrder .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsMfTpCd = this.cstmsMfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprname = this.shprname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dellzip = this.dellzip .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locgood = this.locgood .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porname = this.porname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldOfcd = this.oldOfcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polname = this.polname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smtrind = this.smtrind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyctry = this.ntfyctry .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delladdr = this.delladdr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneename = this.cneename .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dellname = this.dellname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dellctry = this.dellctry .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpraddr = this.shpraddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blrepno = this.blrepno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubLocCd = this.hubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyaddr = this.ntfyaddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porstat = this.porstat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delstat = this.delstat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

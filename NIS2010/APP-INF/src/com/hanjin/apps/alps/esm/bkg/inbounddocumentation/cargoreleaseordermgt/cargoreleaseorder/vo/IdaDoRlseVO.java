/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : IdaDoRlseVO.java
 *@FileTitle : IdaDoRlseVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.10.05
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.10.05  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class IdaDoRlseVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<IdaDoRlseVO>  models =	new	ArrayList<IdaDoRlseVO>();


	/*	Column Info	*/
	private  String	 oblCngFlg   =  null;
	/*	Column Info	*/
	private  String	 idaDoVtyDt   =  null;
	/*	Column Info	*/
	private  String	 idaImpGenMfNo   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 doHldFlg   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 doCngEvntCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 idaDoDmdtPayTpCd   =  null;
	/*	Column Info	*/
	private  String	 interRmk   =  null;
	/*	Column Info	*/
	private  String	 otrDocCgorFlg   =  null;
	/*	Column Info	*/
	private  String	 blOtrDocRcvCd   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 doNoSplit   =  null;
	/*	Column Info	*/
	private  String	 evntOfcCd   =  null;
	/*	Column Info	*/
	private  String	 doSplitFlg   =  null;
	/*	Column Info	*/
	private  String	 rlseSeq   =  null;
	/*	Column Info	*/
	private  String	 idaBlEntrRcvFlg   =  null;
	/*	Column Info	*/
	private  String	 crntCtnt   =  null;
	/*	Column Info	*/
	private  String	 idaCstmsAsgnLineNo   =  null;
	/*	Column Info	*/
	private  String	 oblRdemKnt   =  null;
	/*	Column Info	*/
	private  String	 idaCgorOrdYr   =  null;
	/*	Column Info	*/
	private  String	 doNo   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 preCtnt   =  null;
	/*	Column Info	*/
	private  String	 idaDoYdCd   =  null;
	/*	Column Info	*/
	private  String	 cgorRmk   =  null;
	/*	Column Info	*/
	private  String	 cfsEml   =  null;
	/*	Column Info	*/
	private  String	 mtyYdEml   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public IdaDoRlseVO(){}

	public IdaDoRlseVO(String oblCngFlg,String idaDoVtyDt,String idaImpGenMfNo,String blNo,String doHldFlg,String pagerows,String doCngEvntCd,String ibflag,String idaDoDmdtPayTpCd,String interRmk,String otrDocCgorFlg,String blOtrDocRcvCd,String updUsrId,String doNoSplit,String evntOfcCd,String doSplitFlg,String rlseSeq,String idaBlEntrRcvFlg,String crntCtnt,String idaCstmsAsgnLineNo,String oblRdemKnt,String idaCgorOrdYr,String doNo,String bkgNo,String creUsrId,String preCtnt,String idaDoYdCd,String cgorRmk,String cfsEml,String mtyYdEml)	{
		this.oblCngFlg  = oblCngFlg ;
		this.idaDoVtyDt  = idaDoVtyDt ;
		this.idaImpGenMfNo  = idaImpGenMfNo ;
		this.blNo  = blNo ;
		this.doHldFlg  = doHldFlg ;
		this.pagerows  = pagerows ;
		this.doCngEvntCd  = doCngEvntCd ;
		this.ibflag  = ibflag ;
		this.idaDoDmdtPayTpCd  = idaDoDmdtPayTpCd ;
		this.interRmk  = interRmk ;
		this.otrDocCgorFlg  = otrDocCgorFlg ;
		this.blOtrDocRcvCd  = blOtrDocRcvCd ;
		this.updUsrId  = updUsrId ;
		this.doNoSplit  = doNoSplit ;
		this.evntOfcCd  = evntOfcCd ;
		this.doSplitFlg  = doSplitFlg ;
		this.rlseSeq  = rlseSeq ;
		this.idaBlEntrRcvFlg  = idaBlEntrRcvFlg ;
		this.crntCtnt  = crntCtnt ;
		this.idaCstmsAsgnLineNo  = idaCstmsAsgnLineNo ;
		this.oblRdemKnt  = oblRdemKnt ;
		this.idaCgorOrdYr  = idaCgorOrdYr ;
		this.doNo  = doNo ;
		this.bkgNo  = bkgNo ;
		this.creUsrId  = creUsrId ;
		this.preCtnt  = preCtnt ;
		this.idaDoYdCd  = idaDoYdCd ;
		this.cgorRmk  = cgorRmk ;
		this.cfsEml  = cfsEml ;
		this.mtyYdEml  = mtyYdEml ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("obl_cng_flg", getOblCngFlg());		
		this.hashColumns.put("ida_do_vty_dt", getIdaDoVtyDt());		
		this.hashColumns.put("ida_imp_gen_mf_no", getIdaImpGenMfNo());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("do_hld_flg", getDoHldFlg());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("do_cng_evnt_cd", getDoCngEvntCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("ida_do_dmdt_pay_tp_cd", getIdaDoDmdtPayTpCd());		
		this.hashColumns.put("inter_rmk", getInterRmk());		
		this.hashColumns.put("otr_doc_cgor_flg", getOtrDocCgorFlg());		
		this.hashColumns.put("bl_otr_doc_rcv_cd", getBlOtrDocRcvCd());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("do_no_split", getDoNoSplit());		
		this.hashColumns.put("evnt_ofc_cd", getEvntOfcCd());		
		this.hashColumns.put("do_split_flg", getDoSplitFlg());		
		this.hashColumns.put("rlse_seq", getRlseSeq());		
		this.hashColumns.put("ida_bl_entr_rcv_flg", getIdaBlEntrRcvFlg());		
		this.hashColumns.put("crnt_ctnt", getCrntCtnt());		
		this.hashColumns.put("ida_cstms_asgn_line_no", getIdaCstmsAsgnLineNo());		
		this.hashColumns.put("obl_rdem_knt", getOblRdemKnt());		
		this.hashColumns.put("ida_cgor_ord_yr", getIdaCgorOrdYr());		
		this.hashColumns.put("do_no", getDoNo());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("pre_ctnt", getPreCtnt());		
		this.hashColumns.put("ida_do_yd_cd", getIdaDoYdCd());		
		this.hashColumns.put("cgor_rmk", getCgorRmk());		
		this.hashColumns.put("cfs_eml", getCfsEml());		
		this.hashColumns.put("mty_yd_eml", getMtyYdEml());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("obl_cng_flg", "oblCngFlg");
		this.hashFields.put("ida_do_vty_dt", "idaDoVtyDt");
		this.hashFields.put("ida_imp_gen_mf_no", "idaImpGenMfNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("do_hld_flg", "doHldFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("do_cng_evnt_cd", "doCngEvntCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ida_do_dmdt_pay_tp_cd", "idaDoDmdtPayTpCd");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("otr_doc_cgor_flg", "otrDocCgorFlg");
		this.hashFields.put("bl_otr_doc_rcv_cd", "blOtrDocRcvCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("do_no_split", "doNoSplit");
		this.hashFields.put("evnt_ofc_cd", "evntOfcCd");
		this.hashFields.put("do_split_flg", "doSplitFlg");
		this.hashFields.put("rlse_seq", "rlseSeq");
		this.hashFields.put("ida_bl_entr_rcv_flg", "idaBlEntrRcvFlg");
		this.hashFields.put("crnt_ctnt", "crntCtnt");
		this.hashFields.put("ida_cstms_asgn_line_no", "idaCstmsAsgnLineNo");
		this.hashFields.put("obl_rdem_knt", "oblRdemKnt");
		this.hashFields.put("ida_cgor_ord_yr", "idaCgorOrdYr");
		this.hashFields.put("do_no", "doNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pre_ctnt", "preCtnt");
		this.hashFields.put("ida_do_yd_cd", "idaDoYdCd");
		this.hashFields.put("cgor_rmk", "cgorRmk");
		this.hashFields.put("cfs_eml", "cfsEml");
		this.hashFields.put("mty_yd_eml", "mtyYdEml");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  oblCngFlg
	*/
	public void	setOblCngFlg( String	oblCngFlg ) {
		this.oblCngFlg =	oblCngFlg;
	}
 
	/**
	 * Column Info
	 * @return	oblCngFlg
	 */
	 public	 String	getOblCngFlg() {
		 return	this.oblCngFlg;
	 } 
 	/**
	* Column Info
	* @param  idaDoVtyDt
	*/
	public void	setIdaDoVtyDt( String	idaDoVtyDt ) {
		this.idaDoVtyDt =	idaDoVtyDt;
	}
 
	/**
	 * Column Info
	 * @return	idaDoVtyDt
	 */
	 public	 String	getIdaDoVtyDt() {
		 return	this.idaDoVtyDt;
	 } 
 	/**
	* Column Info
	* @param  idaImpGenMfNo
	*/
	public void	setIdaImpGenMfNo( String	idaImpGenMfNo ) {
		this.idaImpGenMfNo =	idaImpGenMfNo;
	}
 
	/**
	 * Column Info
	 * @return	idaImpGenMfNo
	 */
	 public	 String	getIdaImpGenMfNo() {
		 return	this.idaImpGenMfNo;
	 } 
 	/**
	* Column Info
	* @param  blNo
	*/
	public void	setBlNo( String	blNo ) {
		this.blNo =	blNo;
	}
 
	/**
	 * Column Info
	 * @return	blNo
	 */
	 public	 String	getBlNo() {
		 return	this.blNo;
	 } 
 	/**
	* Column Info
	* @param  doHldFlg
	*/
	public void	setDoHldFlg( String	doHldFlg ) {
		this.doHldFlg =	doHldFlg;
	}
 
	/**
	 * Column Info
	 * @return	doHldFlg
	 */
	 public	 String	getDoHldFlg() {
		 return	this.doHldFlg;
	 } 
 	/**
	* Column Info
	* @param  pagerows
	*/
	public void	setPagerows( String	pagerows ) {
		this.pagerows =	pagerows;
	}
 
	/**
	 * Column Info
	 * @return	pagerows
	 */
	 public	 String	getPagerows() {
		 return	this.pagerows;
	 } 
 	/**
	* Column Info
	* @param  doCngEvntCd
	*/
	public void	setDoCngEvntCd( String	doCngEvntCd ) {
		this.doCngEvntCd =	doCngEvntCd;
	}
 
	/**
	 * Column Info
	 * @return	doCngEvntCd
	 */
	 public	 String	getDoCngEvntCd() {
		 return	this.doCngEvntCd;
	 } 
 	/**
	* Column Info
	* @param  ibflag
	*/
	public void	setIbflag( String	ibflag ) {
		this.ibflag =	ibflag;
	}
 
	/**
	 * Column Info
	 * @return	ibflag
	 */
	 public	 String	getIbflag() {
		 return	this.ibflag;
	 } 
 	/**
	* Column Info
	* @param  idaDoDmdtPayTpCd
	*/
	public void	setIdaDoDmdtPayTpCd( String	idaDoDmdtPayTpCd ) {
		this.idaDoDmdtPayTpCd =	idaDoDmdtPayTpCd;
	}
 
	/**
	 * Column Info
	 * @return	idaDoDmdtPayTpCd
	 */
	 public	 String	getIdaDoDmdtPayTpCd() {
		 return	this.idaDoDmdtPayTpCd;
	 } 
 	/**
	* Column Info
	* @param  interRmk
	*/
	public void	setInterRmk( String	interRmk ) {
		this.interRmk =	interRmk;
	}
 
	/**
	 * Column Info
	 * @return	interRmk
	 */
	 public	 String	getInterRmk() {
		 return	this.interRmk;
	 } 
 	/**
	* Column Info
	* @param  otrDocCgorFlg
	*/
	public void	setOtrDocCgorFlg( String	otrDocCgorFlg ) {
		this.otrDocCgorFlg =	otrDocCgorFlg;
	}
 
	/**
	 * Column Info
	 * @return	otrDocCgorFlg
	 */
	 public	 String	getOtrDocCgorFlg() {
		 return	this.otrDocCgorFlg;
	 } 
 	/**
	* Column Info
	* @param  blOtrDocRcvCd
	*/
	public void	setBlOtrDocRcvCd( String	blOtrDocRcvCd ) {
		this.blOtrDocRcvCd =	blOtrDocRcvCd;
	}
 
	/**
	 * Column Info
	 * @return	blOtrDocRcvCd
	 */
	 public	 String	getBlOtrDocRcvCd() {
		 return	this.blOtrDocRcvCd;
	 } 
 	/**
	* Column Info
	* @param  updUsrId
	*/
	public void	setUpdUsrId( String	updUsrId ) {
		this.updUsrId =	updUsrId;
	}
 
	/**
	 * Column Info
	 * @return	updUsrId
	 */
	 public	 String	getUpdUsrId() {
		 return	this.updUsrId;
	 } 
 	/**
	* Column Info
	* @param  doNoSplit
	*/
	public void	setDoNoSplit( String	doNoSplit ) {
		this.doNoSplit =	doNoSplit;
	}
 
	/**
	 * Column Info
	 * @return	doNoSplit
	 */
	 public	 String	getDoNoSplit() {
		 return	this.doNoSplit;
	 } 
 	/**
	* Column Info
	* @param  evntOfcCd
	*/
	public void	setEvntOfcCd( String	evntOfcCd ) {
		this.evntOfcCd =	evntOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	evntOfcCd
	 */
	 public	 String	getEvntOfcCd() {
		 return	this.evntOfcCd;
	 } 
 	/**
	* Column Info
	* @param  doSplitFlg
	*/
	public void	setDoSplitFlg( String	doSplitFlg ) {
		this.doSplitFlg =	doSplitFlg;
	}
 
	/**
	 * Column Info
	 * @return	doSplitFlg
	 */
	 public	 String	getDoSplitFlg() {
		 return	this.doSplitFlg;
	 } 
 	/**
	* Column Info
	* @param  rlseSeq
	*/
	public void	setRlseSeq( String	rlseSeq ) {
		this.rlseSeq =	rlseSeq;
	}
 
	/**
	 * Column Info
	 * @return	rlseSeq
	 */
	 public	 String	getRlseSeq() {
		 return	this.rlseSeq;
	 } 
 	/**
	* Column Info
	* @param  idaBlEntrRcvFlg
	*/
	public void	setIdaBlEntrRcvFlg( String	idaBlEntrRcvFlg ) {
		this.idaBlEntrRcvFlg =	idaBlEntrRcvFlg;
	}
 
	/**
	 * Column Info
	 * @return	idaBlEntrRcvFlg
	 */
	 public	 String	getIdaBlEntrRcvFlg() {
		 return	this.idaBlEntrRcvFlg;
	 } 
 	/**
	* Column Info
	* @param  crntCtnt
	*/
	public void	setCrntCtnt( String	crntCtnt ) {
		this.crntCtnt =	crntCtnt;
	}
 
	/**
	 * Column Info
	 * @return	crntCtnt
	 */
	 public	 String	getCrntCtnt() {
		 return	this.crntCtnt;
	 } 
 	/**
	* Column Info
	* @param  idaCstmsAsgnLineNo
	*/
	public void	setIdaCstmsAsgnLineNo( String	idaCstmsAsgnLineNo ) {
		this.idaCstmsAsgnLineNo =	idaCstmsAsgnLineNo;
	}
 
	/**
	 * Column Info
	 * @return	idaCstmsAsgnLineNo
	 */
	 public	 String	getIdaCstmsAsgnLineNo() {
		 return	this.idaCstmsAsgnLineNo;
	 } 
 	/**
	* Column Info
	* @param  oblRdemKnt
	*/
	public void	setOblRdemKnt( String	oblRdemKnt ) {
		this.oblRdemKnt =	oblRdemKnt;
	}
 
	/**
	 * Column Info
	 * @return	oblRdemKnt
	 */
	 public	 String	getOblRdemKnt() {
		 return	this.oblRdemKnt;
	 } 
 	/**
	* Column Info
	* @param  idaCgorOrdYr
	*/
	public void	setIdaCgorOrdYr( String	idaCgorOrdYr ) {
		this.idaCgorOrdYr =	idaCgorOrdYr;
	}
 
	/**
	 * Column Info
	 * @return	idaCgorOrdYr
	 */
	 public	 String	getIdaCgorOrdYr() {
		 return	this.idaCgorOrdYr;
	 } 
 	/**
	* Column Info
	* @param  doNo
	*/
	public void	setDoNo( String	doNo ) {
		this.doNo =	doNo;
	}
 
	/**
	 * Column Info
	 * @return	doNo
	 */
	 public	 String	getDoNo() {
		 return	this.doNo;
	 } 
 	/**
	* Column Info
	* @param  bkgNo
	*/
	public void	setBkgNo( String	bkgNo ) {
		this.bkgNo =	bkgNo;
	}
 
	/**
	 * Column Info
	 * @return	bkgNo
	 */
	 public	 String	getBkgNo() {
		 return	this.bkgNo;
	 } 
 	/**
	* Column Info
	* @param  creUsrId
	*/
	public void	setCreUsrId( String	creUsrId ) {
		this.creUsrId =	creUsrId;
	}
 
	/**
	 * Column Info
	 * @return	creUsrId
	 */
	 public	 String	getCreUsrId() {
		 return	this.creUsrId;
	 } 
 	/**
	* Column Info
	* @param  preCtnt
	*/
	public void	setPreCtnt( String	preCtnt ) {
		this.preCtnt =	preCtnt;
	}
 
	/**
	 * Column Info
	 * @return	preCtnt
	 */
	 public	 String	getPreCtnt() {
		 return	this.preCtnt;
	 } 
 	/**
	* Column Info
	* @param  idaDoYdCd
	*/
	public void	setIdaDoYdCd( String	idaDoYdCd ) {
		this.idaDoYdCd =	idaDoYdCd;
	}
 
	/**
	 * Column Info
	 * @return	idaDoYdCd
	 */
	 public	 String	getIdaDoYdCd() {
		 return	this.idaDoYdCd;
	 } 
 	/**
	* Column Info
	* @param  cgorRmk
	*/
	public void	setCgorRmk( String	cgorRmk ) {
		this.cgorRmk =	cgorRmk;
	}
 
	/**
	 * Column Info
	 * @return	cgorRmk
	 */
	 public	 String	getCgorRmk() {
		 return	this.cgorRmk;
	 } 
 	/**
	* Column Info
	* @param  cfsEml
	*/
	public void	setCfsEml( String	cfsEml ) {
		this.cfsEml =	cfsEml;
	}
 
	/**
	 * Column Info
	 * @return	cfsEml
	 */
	 public	 String	getCfsEml() {
		 return	this.cfsEml;
	 } 
 	/**
	* Column Info
	* @param  mtyYdEml
	*/
	public void	setMtyYdEml( String	mtyYdEml ) {
		this.mtyYdEml =	mtyYdEml;
	}
 
	/**
	 * Column Info
	 * @return	mtyYdEml
	 */
	 public	 String	getMtyYdEml() {
		 return	this.mtyYdEml;
	 } 

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setOblCngFlg(JSPUtil.getParameter(request,	prefix + "obl_cng_flg", ""));
		setIdaDoVtyDt(JSPUtil.getParameter(request,	prefix + "ida_do_vty_dt", ""));
		setIdaImpGenMfNo(JSPUtil.getParameter(request,	prefix + "ida_imp_gen_mf_no", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setDoHldFlg(JSPUtil.getParameter(request,	prefix + "do_hld_flg", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setDoCngEvntCd(JSPUtil.getParameter(request,	prefix + "do_cng_evnt_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setIdaDoDmdtPayTpCd(JSPUtil.getParameter(request,	prefix + "ida_do_dmdt_pay_tp_cd", ""));
		setInterRmk(JSPUtil.getParameter(request,	prefix + "inter_rmk", ""));
		setOtrDocCgorFlg(JSPUtil.getParameter(request,	prefix + "otr_doc_cgor_flg", ""));
		setBlOtrDocRcvCd(JSPUtil.getParameter(request,	prefix + "bl_otr_doc_rcv_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setDoNoSplit(JSPUtil.getParameter(request,	prefix + "do_no_split", ""));
		setEvntOfcCd(JSPUtil.getParameter(request,	prefix + "evnt_ofc_cd", ""));
		setDoSplitFlg(JSPUtil.getParameter(request,	prefix + "do_split_flg", ""));
		setRlseSeq(JSPUtil.getParameter(request,	prefix + "rlse_seq", ""));
		setIdaBlEntrRcvFlg(JSPUtil.getParameter(request,	prefix + "ida_bl_entr_rcv_flg", ""));
		setCrntCtnt(JSPUtil.getParameter(request,	prefix + "crnt_ctnt", ""));
		setIdaCstmsAsgnLineNo(JSPUtil.getParameter(request,	prefix + "ida_cstms_asgn_line_no", ""));
		setOblRdemKnt(JSPUtil.getParameter(request,	prefix + "obl_rdem_knt", ""));
		setIdaCgorOrdYr(JSPUtil.getParameter(request,	prefix + "ida_cgor_ord_yr", ""));
		setDoNo(JSPUtil.getParameter(request,	prefix + "do_no", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setPreCtnt(JSPUtil.getParameter(request,	prefix + "pre_ctnt", ""));
		setIdaDoYdCd(JSPUtil.getParameter(request,	prefix + "ida_do_yd_cd", ""));
		setCgorRmk(JSPUtil.getParameter(request,	prefix + "cgor_rmk", ""));
		setCfsEml(JSPUtil.getParameter(request,	prefix + "cfs_eml", ""));
		setMtyYdEml(JSPUtil.getParameter(request,	prefix + "mty_yd_eml", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IdaDoRlseVO[]
	 */
	public IdaDoRlseVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return IdaDoRlseVO[]
	 */
	public IdaDoRlseVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		IdaDoRlseVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] oblCngFlg =	(JSPUtil.getParameter(request, prefix +	"obl_cng_flg".trim(),	length));
				String[] idaDoVtyDt =	(JSPUtil.getParameter(request, prefix +	"ida_do_vty_dt".trim(),	length));
				String[] idaImpGenMfNo =	(JSPUtil.getParameter(request, prefix +	"ida_imp_gen_mf_no".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] doHldFlg =	(JSPUtil.getParameter(request, prefix +	"do_hld_flg".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] doCngEvntCd =	(JSPUtil.getParameter(request, prefix +	"do_cng_evnt_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] idaDoDmdtPayTpCd =	(JSPUtil.getParameter(request, prefix +	"ida_do_dmdt_pay_tp_cd".trim(),	length));
				String[] interRmk =	(JSPUtil.getParameter(request, prefix +	"inter_rmk".trim(),	length));
				String[] otrDocCgorFlg =	(JSPUtil.getParameter(request, prefix +	"otr_doc_cgor_flg".trim(),	length));
				String[] blOtrDocRcvCd =	(JSPUtil.getParameter(request, prefix +	"bl_otr_doc_rcv_cd".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] doNoSplit =	(JSPUtil.getParameter(request, prefix +	"do_no_split".trim(),	length));
				String[] evntOfcCd =	(JSPUtil.getParameter(request, prefix +	"evnt_ofc_cd".trim(),	length));
				String[] doSplitFlg =	(JSPUtil.getParameter(request, prefix +	"do_split_flg".trim(),	length));
				String[] rlseSeq =	(JSPUtil.getParameter(request, prefix +	"rlse_seq".trim(),	length));
				String[] idaBlEntrRcvFlg =	(JSPUtil.getParameter(request, prefix +	"ida_bl_entr_rcv_flg".trim(),	length));
				String[] crntCtnt =	(JSPUtil.getParameter(request, prefix +	"crnt_ctnt".trim(),	length));
				String[] idaCstmsAsgnLineNo =	(JSPUtil.getParameter(request, prefix +	"ida_cstms_asgn_line_no".trim(),	length));
				String[] oblRdemKnt =	(JSPUtil.getParameter(request, prefix +	"obl_rdem_knt".trim(),	length));
				String[] idaCgorOrdYr =	(JSPUtil.getParameter(request, prefix +	"ida_cgor_ord_yr".trim(),	length));
				String[] doNo =	(JSPUtil.getParameter(request, prefix +	"do_no".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] preCtnt =	(JSPUtil.getParameter(request, prefix +	"pre_ctnt".trim(),	length));
				String[] idaDoYdCd =	(JSPUtil.getParameter(request, prefix +	"ida_do_yd_cd".trim(),	length));
				String[] cgorRmk =	(JSPUtil.getParameter(request, prefix +	"cgor_rmk".trim(),	length));
				String[] cfsEml =	(JSPUtil.getParameter(request, prefix +	"cfs_eml".trim(),	length));
				String[] mtyYdEml =	(JSPUtil.getParameter(request, prefix +	"mty_yd_eml".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	IdaDoRlseVO();
						if ( oblCngFlg[i] !=	null)
						model.setOblCngFlg( oblCngFlg[i]);
						if ( idaDoVtyDt[i] !=	null)
						model.setIdaDoVtyDt( idaDoVtyDt[i]);
						if ( idaImpGenMfNo[i] !=	null)
						model.setIdaImpGenMfNo( idaImpGenMfNo[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( doHldFlg[i] !=	null)
						model.setDoHldFlg( doHldFlg[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( doCngEvntCd[i] !=	null)
						model.setDoCngEvntCd( doCngEvntCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( idaDoDmdtPayTpCd[i] !=	null)
						model.setIdaDoDmdtPayTpCd( idaDoDmdtPayTpCd[i]);
						if ( interRmk[i] !=	null)
						model.setInterRmk( interRmk[i]);
						if ( otrDocCgorFlg[i] !=	null)
						model.setOtrDocCgorFlg( otrDocCgorFlg[i]);
						if ( blOtrDocRcvCd[i] !=	null)
						model.setBlOtrDocRcvCd( blOtrDocRcvCd[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( doNoSplit[i] !=	null)
						model.setDoNoSplit( doNoSplit[i]);
						if ( evntOfcCd[i] !=	null)
						model.setEvntOfcCd( evntOfcCd[i]);
						if ( doSplitFlg[i] !=	null)
						model.setDoSplitFlg( doSplitFlg[i]);
						if ( rlseSeq[i] !=	null)
						model.setRlseSeq( rlseSeq[i]);
						if ( idaBlEntrRcvFlg[i] !=	null)
						model.setIdaBlEntrRcvFlg( idaBlEntrRcvFlg[i]);
						if ( crntCtnt[i] !=	null)
						model.setCrntCtnt( crntCtnt[i]);
						if ( idaCstmsAsgnLineNo[i] !=	null)
						model.setIdaCstmsAsgnLineNo( idaCstmsAsgnLineNo[i]);
						if ( oblRdemKnt[i] !=	null)
						model.setOblRdemKnt( oblRdemKnt[i]);
						if ( idaCgorOrdYr[i] !=	null)
						model.setIdaCgorOrdYr( idaCgorOrdYr[i]);
						if ( doNo[i] !=	null)
						model.setDoNo( doNo[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( preCtnt[i] !=	null)
						model.setPreCtnt( preCtnt[i]);
						if ( idaDoYdCd[i] !=	null)
						model.setIdaDoYdCd( idaDoYdCd[i]);
						if ( cgorRmk[i] !=	null)
						model.setCgorRmk( cgorRmk[i]);
						if ( cfsEml[i] !=	null)
						model.setCfsEml( cfsEml[i]);
						if ( mtyYdEml[i] !=	null)
						model.setMtyYdEml( mtyYdEml[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getIdaDoRlseVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return IdaDoRlseVO[]
	 */
	public IdaDoRlseVO[]	 getIdaDoRlseVOs(){
		IdaDoRlseVO[] vos = (IdaDoRlseVO[])models.toArray(new	IdaDoRlseVO[models.size()]);
		return vos;
		}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String  toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}
	

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void	unDataFormat(){
		this.oblCngFlg =	this.oblCngFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaDoVtyDt =	this.idaDoVtyDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaImpGenMfNo =	this.idaImpGenMfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doHldFlg =	this.doHldFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doCngEvntCd =	this.doCngEvntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaDoDmdtPayTpCd =	this.idaDoDmdtPayTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk =	this.interRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrDocCgorFlg =	this.otrDocCgorFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blOtrDocRcvCd =	this.blOtrDocRcvCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doNoSplit =	this.doNoSplit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntOfcCd =	this.evntOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doSplitFlg =	this.doSplitFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseSeq =	this.rlseSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaBlEntrRcvFlg =	this.idaBlEntrRcvFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntCtnt =	this.crntCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaCstmsAsgnLineNo =	this.idaCstmsAsgnLineNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemKnt =	this.oblRdemKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaCgorOrdYr =	this.idaCgorOrdYr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doNo =	this.doNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCtnt =	this.preCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaDoYdCd =	this.idaDoYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgorRmk =	this.cgorRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfsEml =	this.cfsEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyYdEml =	this.mtyYdEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}
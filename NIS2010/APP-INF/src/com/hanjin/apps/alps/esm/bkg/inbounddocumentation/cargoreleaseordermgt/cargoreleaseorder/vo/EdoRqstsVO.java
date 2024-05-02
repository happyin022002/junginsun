/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : EdoRqstsVO.java
 *@FileTitle : EdoRqstsVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.06.14
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.06.14  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
public class EdoRqstsVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<EdoRqstsVO>  models =	new	ArrayList<EdoRqstsVO>();


	/*	Column Info	*/
	private  String	 edoRqstSeq5jn   =  null;
	/*	Column Info	*/
	private  String	 ibdtEdoRctDt   =  null;
	/*	Column Info	*/
	private  String	 rqstEdoIssDt   =  null;
	/*	Column Info	*/
	private  String	 edoRqstSeq5jm   =  null;
	/*	Column Info	*/
	private  String	 edoFuncCd   =  null;
	/*	Column Info	*/
	private  String	 ibdtEdoAckCd   =  null;
	/*	Column Info	*/
	private  String	 edoTpCd   =  null;
	/*	Column Info	*/
	private  String	 seltEdoAckCd   =  null;
	/*	Column Info	*/
	private  String	 ptyNm   =  null;
	/*	Column Info	*/
	private  String	 ptyFlg   =  null;
	/*	Column Info	*/
	private  String	 vslArrDt   =  null;
	/*	Column Info	*/
	private  String	 edoRqstSeq5jk   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 hndlOfcCd   =  null;
	/*	Column Info	*/
	private  String	 doEdoRctLocCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 vvd   =  null;
	/*	Column Info	*/
	private  String	 seltEdoRctDt   =  null;
	/*	Column Info	*/
	private  String	 seltEdoAprDt   =  null;
	/*	Column Info	*/
	private  String	 seltEdoAprUsrId   =  null;
	/*	Column Info	*/
	private  String	 podCd   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 edoRqstNo   =  null;
	/*	Column Info	*/
	private  String	 doEdoAckCd   =  null;
	/*	Column Info	*/
	private  String	 doEdoRctDt   =  null;
	/*	Column Info	*/
	private  String	 deltUsrId   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 delCd   =  null;
	/*	Column Info	*/
	private  String	 whNm   =  null;
	/*	Column Info	*/
	private  String	 edoRvwFlg   =  null;
	/*	Column Info	*/
	private  String	 edoRvwUsrId   =  null;
	/*	Column Info	*/
	private  String	 rqstNo   =  null;
	/*	Column Info	*/
	private  String	 rlseFlg   =  null;
	/*	Column Info	*/
	private  String	 deTermCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpCd   =  null;
	/*	Column Info	*/
	private  String	 blTpCd   =  null;
	/*	Column Info	*/
	private  String	 doRlseUsrId   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public EdoRqstsVO(){}

	public EdoRqstsVO(String edoRqstSeq5jn,String ibdtEdoRctDt,String rqstEdoIssDt,String edoRqstSeq5jm,String edoFuncCd,String ibdtEdoAckCd,String edoTpCd,String seltEdoAckCd,String ptyNm,String ptyFlg,String vslArrDt,String edoRqstSeq5jk,String blNo,String hndlOfcCd,String doEdoRctLocCd,String pagerows,String vvd,String seltEdoRctDt,String seltEdoAprDt,String seltEdoAprUsrId,String podCd,String bkgNo,String ibflag,String edoRqstNo,String doEdoAckCd,String doEdoRctDt,String deltUsrId,String updUsrId,String delCd,String whNm,String edoRvwFlg,String edoRvwUsrId,String rqstNo,String rlseFlg,String deTermCd,String cntrTpCd,String blTpCd,String doRlseUsrId)	{
		this.edoRqstSeq5jn  = edoRqstSeq5jn ;
		this.ibdtEdoRctDt  = ibdtEdoRctDt ;
		this.rqstEdoIssDt  = rqstEdoIssDt ;
		this.edoRqstSeq5jm  = edoRqstSeq5jm ;
		this.edoFuncCd  = edoFuncCd ;
		this.ibdtEdoAckCd  = ibdtEdoAckCd ;
		this.edoTpCd  = edoTpCd ;
		this.seltEdoAckCd  = seltEdoAckCd ;
		this.ptyNm  = ptyNm ;
		this.ptyFlg  = ptyFlg ;
		this.vslArrDt  = vslArrDt ;
		this.edoRqstSeq5jk  = edoRqstSeq5jk ;
		this.blNo  = blNo ;
		this.hndlOfcCd  = hndlOfcCd ;
		this.doEdoRctLocCd  = doEdoRctLocCd ;
		this.pagerows  = pagerows ;
		this.vvd  = vvd ;
		this.seltEdoRctDt  = seltEdoRctDt ;
		this.seltEdoAprDt  = seltEdoAprDt ;
		this.seltEdoAprUsrId  = seltEdoAprUsrId ;
		this.podCd  = podCd ;
		this.bkgNo  = bkgNo ;
		this.ibflag  = ibflag ;
		this.edoRqstNo  = edoRqstNo ;
		this.doEdoAckCd  = doEdoAckCd ;
		this.doEdoRctDt  = doEdoRctDt ;
		this.deltUsrId  = deltUsrId ;
		this.updUsrId  = updUsrId ;
		this.delCd  = delCd ;
		this.whNm  = whNm ;
		this.edoRvwFlg  = edoRvwFlg ;
		this.edoRvwUsrId  = edoRvwUsrId ;
		this.rqstNo  = rqstNo ;
		this.rlseFlg  = rlseFlg ;
		this.deTermCd  = deTermCd ;
		this.cntrTpCd  = cntrTpCd ;
		this.blTpCd  = blTpCd ;
		this.doRlseUsrId  = doRlseUsrId ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("edo_rqst_seq_5jn", getEdoRqstSeq5jn());		
		this.hashColumns.put("ibdt_edo_rct_dt", getIbdtEdoRctDt());		
		this.hashColumns.put("rqst_edo_iss_dt", getRqstEdoIssDt());		
		this.hashColumns.put("edo_rqst_seq_5jm", getEdoRqstSeq5jm());		
		this.hashColumns.put("edo_func_cd", getEdoFuncCd());		
		this.hashColumns.put("ibdt_edo_ack_cd", getIbdtEdoAckCd());		
		this.hashColumns.put("edo_tp_cd", getEdoTpCd());		
		this.hashColumns.put("selt_edo_ack_cd", getSeltEdoAckCd());		
		this.hashColumns.put("pty_nm", getPtyNm());		
		this.hashColumns.put("pty_flg", getPtyFlg());		
		this.hashColumns.put("vsl_arr_dt", getVslArrDt());		
		this.hashColumns.put("edo_rqst_seq_5jk", getEdoRqstSeq5jk());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("hndl_ofc_cd", getHndlOfcCd());		
		this.hashColumns.put("do_edo_rct_loc_cd", getDoEdoRctLocCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("vvd", getVvd());		
		this.hashColumns.put("selt_edo_rct_dt", getSeltEdoRctDt());		
		this.hashColumns.put("selt_edo_apr_dt", getSeltEdoAprDt());		
		this.hashColumns.put("selt_edo_apr_usr_id", getSeltEdoAprUsrId());		
		this.hashColumns.put("pod_cd", getPodCd());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("edo_rqst_no", getEdoRqstNo());		
		this.hashColumns.put("do_edo_ack_cd", getDoEdoAckCd());		
		this.hashColumns.put("do_edo_rct_dt", getDoEdoRctDt());		
		this.hashColumns.put("delt_usr_id", getDeltUsrId());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("del_cd", getDelCd());		
		this.hashColumns.put("wh_nm", getWhNm());		
		this.hashColumns.put("edo_rvw_flg", getEdoRvwFlg());		
		this.hashColumns.put("edo_rvw_usr_id", getEdoRvwUsrId());		
		this.hashColumns.put("rqst_no", getRqstNo());		
		this.hashColumns.put("rlse_flg", getRlseFlg());		
		this.hashColumns.put("de_term_cd", getDeTermCd());		
		this.hashColumns.put("cntr_tp_cd", getCntrTpCd());		
		this.hashColumns.put("bl_tp_cd", getBlTpCd());		
		this.hashColumns.put("do_rlse_usr_id", getDoRlseUsrId());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("edo_rqst_seq_5jn", "edoRqstSeq5jn");
		this.hashFields.put("ibdt_edo_rct_dt", "ibdtEdoRctDt");
		this.hashFields.put("rqst_edo_iss_dt", "rqstEdoIssDt");
		this.hashFields.put("edo_rqst_seq_5jm", "edoRqstSeq5jm");
		this.hashFields.put("edo_func_cd", "edoFuncCd");
		this.hashFields.put("ibdt_edo_ack_cd", "ibdtEdoAckCd");
		this.hashFields.put("edo_tp_cd", "edoTpCd");
		this.hashFields.put("selt_edo_ack_cd", "seltEdoAckCd");
		this.hashFields.put("pty_nm", "ptyNm");
		this.hashFields.put("pty_flg", "ptyFlg");
		this.hashFields.put("vsl_arr_dt", "vslArrDt");
		this.hashFields.put("edo_rqst_seq_5jk", "edoRqstSeq5jk");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("hndl_ofc_cd", "hndlOfcCd");
		this.hashFields.put("do_edo_rct_loc_cd", "doEdoRctLocCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("selt_edo_rct_dt", "seltEdoRctDt");
		this.hashFields.put("selt_edo_apr_dt", "seltEdoAprDt");
		this.hashFields.put("selt_edo_apr_usr_id", "seltEdoAprUsrId");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("edo_rqst_no", "edoRqstNo");
		this.hashFields.put("do_edo_ack_cd", "doEdoAckCd");
		this.hashFields.put("do_edo_rct_dt", "doEdoRctDt");
		this.hashFields.put("delt_usr_id", "deltUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("wh_nm", "whNm");
		this.hashFields.put("edo_rvw_flg", "edoRvwFlg");
		this.hashFields.put("edo_rvw_usr_id", "edoRvwUsrId");
		this.hashFields.put("rqst_no", "rqstNo");
		this.hashFields.put("rlse_flg", "rlseFlg");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("cntr_tp_cd", "cntrTpCd");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("do_rlse_usr_id", "doRlseUsrId");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  edoRqstSeq5jn
	*/
	public void	setEdoRqstSeq5jn( String	edoRqstSeq5jn ) {
		this.edoRqstSeq5jn =	edoRqstSeq5jn;
	}
 
	/**
	 * Column Info
	 * @return	edoRqstSeq5jn
	 */
	 public	 String	getEdoRqstSeq5jn() {
		 return	this.edoRqstSeq5jn;
	 } 
 	/**
	* Column Info
	* @param  ibdtEdoRctDt
	*/
	public void	setIbdtEdoRctDt( String	ibdtEdoRctDt ) {
		this.ibdtEdoRctDt =	ibdtEdoRctDt;
	}
 
	/**
	 * Column Info
	 * @return	ibdtEdoRctDt
	 */
	 public	 String	getIbdtEdoRctDt() {
		 return	this.ibdtEdoRctDt;
	 } 
 	/**
	* Column Info
	* @param  rqstEdoIssDt
	*/
	public void	setRqstEdoIssDt( String	rqstEdoIssDt ) {
		this.rqstEdoIssDt =	rqstEdoIssDt;
	}
 
	/**
	 * Column Info
	 * @return	rqstEdoIssDt
	 */
	 public	 String	getRqstEdoIssDt() {
		 return	this.rqstEdoIssDt;
	 } 
 	/**
	* Column Info
	* @param  edoRqstSeq5jm
	*/
	public void	setEdoRqstSeq5jm( String	edoRqstSeq5jm ) {
		this.edoRqstSeq5jm =	edoRqstSeq5jm;
	}
 
	/**
	 * Column Info
	 * @return	edoRqstSeq5jm
	 */
	 public	 String	getEdoRqstSeq5jm() {
		 return	this.edoRqstSeq5jm;
	 } 
 	/**
	* Column Info
	* @param  edoFuncCd
	*/
	public void	setEdoFuncCd( String	edoFuncCd ) {
		this.edoFuncCd =	edoFuncCd;
	}
 
	/**
	 * Column Info
	 * @return	edoFuncCd
	 */
	 public	 String	getEdoFuncCd() {
		 return	this.edoFuncCd;
	 } 
 	/**
	* Column Info
	* @param  ibdtEdoAckCd
	*/
	public void	setIbdtEdoAckCd( String	ibdtEdoAckCd ) {
		this.ibdtEdoAckCd =	ibdtEdoAckCd;
	}
 
	/**
	 * Column Info
	 * @return	ibdtEdoAckCd
	 */
	 public	 String	getIbdtEdoAckCd() {
		 return	this.ibdtEdoAckCd;
	 } 
 	/**
	* Column Info
	* @param  edoTpCd
	*/
	public void	setEdoTpCd( String	edoTpCd ) {
		this.edoTpCd =	edoTpCd;
	}
 
	/**
	 * Column Info
	 * @return	edoTpCd
	 */
	 public	 String	getEdoTpCd() {
		 return	this.edoTpCd;
	 } 
 	/**
	* Column Info
	* @param  seltEdoAckCd
	*/
	public void	setSeltEdoAckCd( String	seltEdoAckCd ) {
		this.seltEdoAckCd =	seltEdoAckCd;
	}
 
	/**
	 * Column Info
	 * @return	seltEdoAckCd
	 */
	 public	 String	getSeltEdoAckCd() {
		 return	this.seltEdoAckCd;
	 } 
 	/**
	* Column Info
	* @param  ptyNm
	*/
	public void	setPtyNm( String	ptyNm ) {
		this.ptyNm =	ptyNm;
	}
 
	/**
	 * Column Info
	 * @return	ptyNm
	 */
	 public	 String	getPtyNm() {
		 return	this.ptyNm;
	 } 
 	/**
	* Column Info
	* @param  ptyFlg
	*/
	public void	setPtyFlg( String	ptyFlg ) {
		this.ptyFlg =	ptyFlg;
	}
 
	/**
	 * Column Info
	 * @return	ptyFlg
	 */
	 public	 String	getPtyFlg() {
		 return	this.ptyFlg;
	 } 
 	/**
	* Column Info
	* @param  vslArrDt
	*/
	public void	setVslArrDt( String	vslArrDt ) {
		this.vslArrDt =	vslArrDt;
	}
 
	/**
	 * Column Info
	 * @return	vslArrDt
	 */
	 public	 String	getVslArrDt() {
		 return	this.vslArrDt;
	 } 
 	/**
	* Column Info
	* @param  edoRqstSeq5jk
	*/
	public void	setEdoRqstSeq5jk( String	edoRqstSeq5jk ) {
		this.edoRqstSeq5jk =	edoRqstSeq5jk;
	}
 
	/**
	 * Column Info
	 * @return	edoRqstSeq5jk
	 */
	 public	 String	getEdoRqstSeq5jk() {
		 return	this.edoRqstSeq5jk;
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
	* @param  hndlOfcCd
	*/
	public void	setHndlOfcCd( String	hndlOfcCd ) {
		this.hndlOfcCd =	hndlOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	hndlOfcCd
	 */
	 public	 String	getHndlOfcCd() {
		 return	this.hndlOfcCd;
	 } 
 	/**
	* Column Info
	* @param  doEdoRctLocCd
	*/
	public void	setDoEdoRctLocCd( String	doEdoRctLocCd ) {
		this.doEdoRctLocCd =	doEdoRctLocCd;
	}
 
	/**
	 * Column Info
	 * @return	doEdoRctLocCd
	 */
	 public	 String	getDoEdoRctLocCd() {
		 return	this.doEdoRctLocCd;
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
	* @param  vvd
	*/
	public void	setVvd( String	vvd ) {
		this.vvd =	vvd;
	}
 
	/**
	 * Column Info
	 * @return	vvd
	 */
	 public	 String	getVvd() {
		 return	this.vvd;
	 } 
 	/**
	* Column Info
	* @param  seltEdoRctDt
	*/
	public void	setSeltEdoRctDt( String	seltEdoRctDt ) {
		this.seltEdoRctDt =	seltEdoRctDt;
	}
 
	/**
	 * Column Info
	 * @return	seltEdoRctDt
	 */
	 public	 String	getSeltEdoRctDt() {
		 return	this.seltEdoRctDt;
	 } 
 	/**
	* Column Info
	* @param  seltEdoAprDt
	*/
	public void	setSeltEdoAprDt( String	seltEdoAprDt ) {
		this.seltEdoAprDt =	seltEdoAprDt;
	}
 
	/**
	 * Column Info
	 * @return	seltEdoAprDt
	 */
	 public	 String	getSeltEdoAprDt() {
		 return	this.seltEdoAprDt;
	 } 
 	/**
	* Column Info
	* @param  seltEdoAprUsrId
	*/
	public void	setSeltEdoAprUsrId( String	seltEdoAprUsrId ) {
		this.seltEdoAprUsrId =	seltEdoAprUsrId;
	}
 
	/**
	 * Column Info
	 * @return	seltEdoAprUsrId
	 */
	 public	 String	getSeltEdoAprUsrId() {
		 return	this.seltEdoAprUsrId;
	 } 
 	/**
	* Column Info
	* @param  podCd
	*/
	public void	setPodCd( String	podCd ) {
		this.podCd =	podCd;
	}
 
	/**
	 * Column Info
	 * @return	podCd
	 */
	 public	 String	getPodCd() {
		 return	this.podCd;
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
	* @param  edoRqstNo
	*/
	public void	setEdoRqstNo( String	edoRqstNo ) {
		this.edoRqstNo =	edoRqstNo;
	}
 
	/**
	 * Column Info
	 * @return	edoRqstNo
	 */
	 public	 String	getEdoRqstNo() {
		 return	this.edoRqstNo;
	 } 
 	/**
	* Column Info
	* @param  doEdoAckCd
	*/
	public void	setDoEdoAckCd( String	doEdoAckCd ) {
		this.doEdoAckCd =	doEdoAckCd;
	}
 
	/**
	 * Column Info
	 * @return	doEdoAckCd
	 */
	 public	 String	getDoEdoAckCd() {
		 return	this.doEdoAckCd;
	 } 
 	/**
	* Column Info
	* @param  doEdoRctDt
	*/
	public void	setDoEdoRctDt( String	doEdoRctDt ) {
		this.doEdoRctDt =	doEdoRctDt;
	}
 
	/**
	 * Column Info
	 * @return	doEdoRctDt
	 */
	 public	 String	getDoEdoRctDt() {
		 return	this.doEdoRctDt;
	 } 
 	/**
	* Column Info
	* @param  deltUsrId
	*/
	public void	setDeltUsrId( String	deltUsrId ) {
		this.deltUsrId =	deltUsrId;
	}
 
	/**
	 * Column Info
	 * @return	deltUsrId
	 */
	 public	 String	getDeltUsrId() {
		 return	this.deltUsrId;
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
	* @param  delCd
	*/
	public void	setDelCd( String	delCd ) {
		this.delCd =	delCd;
	}
 
	/**
	 * Column Info
	 * @return	delCd
	 */
	 public	 String	getDelCd() {
		 return	this.delCd;
	 } 
 	/**
	* Column Info
	* @param  whNm
	*/
	public void	setWhNm( String	whNm ) {
		this.whNm =	whNm;
	}
 
	/**
	 * Column Info
	 * @return	whNm
	 */
	 public	 String	getWhNm() {
		 return	this.whNm;
	 } 
 	/**
	* Column Info
	* @param  edoRvwFlg
	*/
	public void	setEdoRvwFlg( String	edoRvwFlg ) {
		this.edoRvwFlg =	edoRvwFlg;
	}
 
	/**
	 * Column Info
	 * @return	edoRvwFlg
	 */
	 public	 String	getEdoRvwFlg() {
		 return	this.edoRvwFlg;
	 } 
 	/**
	* Column Info
	* @param  edoRvwUsrId
	*/
	public void	setEdoRvwUsrId( String	edoRvwUsrId ) {
		this.edoRvwUsrId =	edoRvwUsrId;
	}
 
	/**
	 * Column Info
	 * @return	edoRvwUsrId
	 */
	 public	 String	getEdoRvwUsrId() {
		 return	this.edoRvwUsrId;
	 } 
 	/**
	* Column Info
	* @param  rqstNo
	*/
	public void	setRqstNo( String	rqstNo ) {
		this.rqstNo =	rqstNo;
	}
 
	/**
	 * Column Info
	 * @return	rqstNo
	 */
	 public	 String	getRqstNo() {
		 return	this.rqstNo;
	 } 
 	/**
	* Column Info
	* @param  rlseFlg
	*/
	public void	setRlseFlg( String	rlseFlg ) {
		this.rlseFlg =	rlseFlg;
	}
 
	/**
	 * Column Info
	 * @return	rlseFlg
	 */
	 public	 String	getRlseFlg() {
		 return	this.rlseFlg;
	 } 
 	/**
	* Column Info
	* @param  deTermCd
	*/
	public void	setDeTermCd( String	deTermCd ) {
		this.deTermCd =	deTermCd;
	}
 
	/**
	 * Column Info
	 * @return	deTermCd
	 */
	 public	 String	getDeTermCd() {
		 return	this.deTermCd;
	 } 
 	/**
	* Column Info
	* @param  cntrTpCd
	*/
	public void	setCntrTpCd( String	cntrTpCd ) {
		this.cntrTpCd =	cntrTpCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpCd
	 */
	 public	 String	getCntrTpCd() {
		 return	this.cntrTpCd;
	 } 
 	/**
	* Column Info
	* @param  blTpCd
	*/
	public void	setBlTpCd( String	blTpCd ) {
		this.blTpCd =	blTpCd;
	}
 
	/**
	 * Column Info
	 * @return	blTpCd
	 */
	 public	 String	getBlTpCd() {
		 return	this.blTpCd;
	 } 
 	/**
	* Column Info
	* @param  doRlseUsrId
	*/
	public void	setDoRlseUsrId( String	doRlseUsrId ) {
		this.doRlseUsrId =	doRlseUsrId;
	}
 
	/**
	 * Column Info
	 * @return	doRlseUsrId
	 */
	 public	 String	getDoRlseUsrId() {
		 return	this.doRlseUsrId;
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
		setEdoRqstSeq5jn(JSPUtil.getParameter(request,	prefix + "edo_rqst_seq_5jn", ""));
		setIbdtEdoRctDt(JSPUtil.getParameter(request,	prefix + "ibdt_edo_rct_dt", ""));
		setRqstEdoIssDt(JSPUtil.getParameter(request,	prefix + "rqst_edo_iss_dt", ""));
		setEdoRqstSeq5jm(JSPUtil.getParameter(request,	prefix + "edo_rqst_seq_5jm", ""));
		setEdoFuncCd(JSPUtil.getParameter(request,	prefix + "edo_func_cd", ""));
		setIbdtEdoAckCd(JSPUtil.getParameter(request,	prefix + "ibdt_edo_ack_cd", ""));
		setEdoTpCd(JSPUtil.getParameter(request,	prefix + "edo_tp_cd", ""));
		setSeltEdoAckCd(JSPUtil.getParameter(request,	prefix + "selt_edo_ack_cd", ""));
		setPtyNm(JSPUtil.getParameter(request,	prefix + "pty_nm", ""));
		setPtyFlg(JSPUtil.getParameter(request,	prefix + "pty_flg", ""));
		setVslArrDt(JSPUtil.getParameter(request,	prefix + "vsl_arr_dt", ""));
		setEdoRqstSeq5jk(JSPUtil.getParameter(request,	prefix + "edo_rqst_seq_5jk", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setHndlOfcCd(JSPUtil.getParameter(request,	prefix + "hndl_ofc_cd", ""));
		setDoEdoRctLocCd(JSPUtil.getParameter(request,	prefix + "do_edo_rct_loc_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request,	prefix + "vvd", ""));
		setSeltEdoRctDt(JSPUtil.getParameter(request,	prefix + "selt_edo_rct_dt", ""));
		setSeltEdoAprDt(JSPUtil.getParameter(request,	prefix + "selt_edo_apr_dt", ""));
		setSeltEdoAprUsrId(JSPUtil.getParameter(request,	prefix + "selt_edo_apr_usr_id", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setEdoRqstNo(JSPUtil.getParameter(request,	prefix + "edo_rqst_no", ""));
		setDoEdoAckCd(JSPUtil.getParameter(request,	prefix + "do_edo_ack_cd", ""));
		setDoEdoRctDt(JSPUtil.getParameter(request,	prefix + "do_edo_rct_dt", ""));
		setDeltUsrId(JSPUtil.getParameter(request,	prefix + "delt_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setDelCd(JSPUtil.getParameter(request,	prefix + "del_cd", ""));
		setWhNm(JSPUtil.getParameter(request,	prefix + "wh_nm", ""));
		setEdoRvwFlg(JSPUtil.getParameter(request,	prefix + "edo_rvw_flg", ""));
		setEdoRvwUsrId(JSPUtil.getParameter(request,	prefix + "edo_rvw_usr_id", ""));
		setRqstNo(JSPUtil.getParameter(request,	prefix + "rqst_no", ""));
		setRlseFlg(JSPUtil.getParameter(request,	prefix + "rlse_flg", ""));
		setDeTermCd(JSPUtil.getParameter(request,	prefix + "de_term_cd", ""));
		setCntrTpCd(JSPUtil.getParameter(request,	prefix + "cntr_tp_cd", ""));
		setBlTpCd(JSPUtil.getParameter(request,	prefix + "bl_tp_cd", ""));
		setDoRlseUsrId(JSPUtil.getParameter(request,	prefix + "do_rlse_usr_id", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EdoRqstsVO[]
	 */
	public EdoRqstsVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return EdoRqstsVO[]
	 */
	public EdoRqstsVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		EdoRqstsVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] edoRqstSeq5jn =	(JSPUtil.getParameter(request, prefix +	"edo_rqst_seq_5jn".trim(),	length));
				String[] ibdtEdoRctDt =	(JSPUtil.getParameter(request, prefix +	"ibdt_edo_rct_dt".trim(),	length));
				String[] rqstEdoIssDt =	(JSPUtil.getParameter(request, prefix +	"rqst_edo_iss_dt".trim(),	length));
				String[] edoRqstSeq5jm =	(JSPUtil.getParameter(request, prefix +	"edo_rqst_seq_5jm".trim(),	length));
				String[] edoFuncCd =	(JSPUtil.getParameter(request, prefix +	"edo_func_cd".trim(),	length));
				String[] ibdtEdoAckCd =	(JSPUtil.getParameter(request, prefix +	"ibdt_edo_ack_cd".trim(),	length));
				String[] edoTpCd =	(JSPUtil.getParameter(request, prefix +	"edo_tp_cd".trim(),	length));
				String[] seltEdoAckCd =	(JSPUtil.getParameter(request, prefix +	"selt_edo_ack_cd".trim(),	length));
				String[] ptyNm =	(JSPUtil.getParameter(request, prefix +	"pty_nm".trim(),	length));
				String[] ptyFlg =	(JSPUtil.getParameter(request, prefix +	"pty_flg".trim(),	length));
				String[] vslArrDt =	(JSPUtil.getParameter(request, prefix +	"vsl_arr_dt".trim(),	length));
				String[] edoRqstSeq5jk =	(JSPUtil.getParameter(request, prefix +	"edo_rqst_seq_5jk".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] hndlOfcCd =	(JSPUtil.getParameter(request, prefix +	"hndl_ofc_cd".trim(),	length));
				String[] doEdoRctLocCd =	(JSPUtil.getParameter(request, prefix +	"do_edo_rct_loc_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] vvd =	(JSPUtil.getParameter(request, prefix +	"vvd".trim(),	length));
				String[] seltEdoRctDt =	(JSPUtil.getParameter(request, prefix +	"selt_edo_rct_dt".trim(),	length));
				String[] seltEdoAprDt =	(JSPUtil.getParameter(request, prefix +	"selt_edo_apr_dt".trim(),	length));
				String[] seltEdoAprUsrId =	(JSPUtil.getParameter(request, prefix +	"selt_edo_apr_usr_id".trim(),	length));
				String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] edoRqstNo =	(JSPUtil.getParameter(request, prefix +	"edo_rqst_no".trim(),	length));
				String[] doEdoAckCd =	(JSPUtil.getParameter(request, prefix +	"do_edo_ack_cd".trim(),	length));
				String[] doEdoRctDt =	(JSPUtil.getParameter(request, prefix +	"do_edo_rct_dt".trim(),	length));
				String[] deltUsrId =	(JSPUtil.getParameter(request, prefix +	"delt_usr_id".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] delCd =	(JSPUtil.getParameter(request, prefix +	"del_cd".trim(),	length));
				String[] whNm =	(JSPUtil.getParameter(request, prefix +	"wh_nm".trim(),	length));
				String[] edoRvwFlg =	(JSPUtil.getParameter(request, prefix +	"edo_rvw_flg".trim(),	length));
				String[] edoRvwUsrId =	(JSPUtil.getParameter(request, prefix +	"edo_rvw_usr_id".trim(),	length));
				String[] rqstNo =	(JSPUtil.getParameter(request, prefix +	"rqst_no".trim(),	length));
				String[] rlseFlg =	(JSPUtil.getParameter(request, prefix +	"rlse_flg".trim(),	length));
				String[] deTermCd =	(JSPUtil.getParameter(request, prefix +	"de_term_cd".trim(),	length));
				String[] cntrTpCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tp_cd".trim(),	length));
				String[] blTpCd =	(JSPUtil.getParameter(request, prefix +	"bl_tp_cd".trim(),	length));
				String[] doRlseUsrId =	(JSPUtil.getParameter(request, prefix +	"do_rlse_usr_id".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	EdoRqstsVO();
						if ( edoRqstSeq5jn[i] !=	null)
						model.setEdoRqstSeq5jn( edoRqstSeq5jn[i]);
						if ( ibdtEdoRctDt[i] !=	null)
						model.setIbdtEdoRctDt( ibdtEdoRctDt[i]);
						if ( rqstEdoIssDt[i] !=	null)
						model.setRqstEdoIssDt( rqstEdoIssDt[i]);
						if ( edoRqstSeq5jm[i] !=	null)
						model.setEdoRqstSeq5jm( edoRqstSeq5jm[i]);
						if ( edoFuncCd[i] !=	null)
						model.setEdoFuncCd( edoFuncCd[i]);
						if ( ibdtEdoAckCd[i] !=	null)
						model.setIbdtEdoAckCd( ibdtEdoAckCd[i]);
						if ( edoTpCd[i] !=	null)
						model.setEdoTpCd( edoTpCd[i]);
						if ( seltEdoAckCd[i] !=	null)
						model.setSeltEdoAckCd( seltEdoAckCd[i]);
						if ( ptyNm[i] !=	null)
						model.setPtyNm( ptyNm[i]);
						if ( ptyFlg[i] !=	null)
						model.setPtyFlg( ptyFlg[i]);
						if ( vslArrDt[i] !=	null)
						model.setVslArrDt( vslArrDt[i]);
						if ( edoRqstSeq5jk[i] !=	null)
						model.setEdoRqstSeq5jk( edoRqstSeq5jk[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( hndlOfcCd[i] !=	null)
						model.setHndlOfcCd( hndlOfcCd[i]);
						if ( doEdoRctLocCd[i] !=	null)
						model.setDoEdoRctLocCd( doEdoRctLocCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( vvd[i] !=	null)
						model.setVvd( vvd[i]);
						if ( seltEdoRctDt[i] !=	null)
						model.setSeltEdoRctDt( seltEdoRctDt[i]);
						if ( seltEdoAprDt[i] !=	null)
						model.setSeltEdoAprDt( seltEdoAprDt[i]);
						if ( seltEdoAprUsrId[i] !=	null)
						model.setSeltEdoAprUsrId( seltEdoAprUsrId[i]);
						if ( podCd[i] !=	null)
						model.setPodCd( podCd[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( edoRqstNo[i] !=	null)
						model.setEdoRqstNo( edoRqstNo[i]);
						if ( doEdoAckCd[i] !=	null)
						model.setDoEdoAckCd( doEdoAckCd[i]);
						if ( doEdoRctDt[i] !=	null)
						model.setDoEdoRctDt( doEdoRctDt[i]);
						if ( deltUsrId[i] !=	null)
						model.setDeltUsrId( deltUsrId[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( delCd[i] !=	null)
						model.setDelCd( delCd[i]);
						if ( whNm[i] !=	null)
						model.setWhNm( whNm[i]);
						if ( edoRvwFlg[i] !=	null)
						model.setEdoRvwFlg( edoRvwFlg[i]);
						if ( edoRvwUsrId[i] !=	null)
						model.setEdoRvwUsrId( edoRvwUsrId[i]);
						if ( rqstNo[i] !=	null)
						model.setRqstNo( rqstNo[i]);
						if ( rlseFlg[i] !=	null)
						model.setRlseFlg( rlseFlg[i]);
						if ( deTermCd[i] !=	null)
						model.setDeTermCd( deTermCd[i]);
						if ( cntrTpCd[i] !=	null)
						model.setCntrTpCd( cntrTpCd[i]);
						if ( blTpCd[i] !=	null)
						model.setBlTpCd( blTpCd[i]);
						if ( doRlseUsrId[i] !=	null)
						model.setDoRlseUsrId( doRlseUsrId[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getEdoRqstsVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return EdoRqstsVO[]
	 */
	public EdoRqstsVO[]	 getEdoRqstsVOs(){
		EdoRqstsVO[] vos = (EdoRqstsVO[])models.toArray(new	EdoRqstsVO[models.size()]);
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
		this.edoRqstSeq5jn =	this.edoRqstSeq5jn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdtEdoRctDt =	this.ibdtEdoRctDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstEdoIssDt =	this.rqstEdoIssDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoRqstSeq5jm =	this.edoRqstSeq5jm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoFuncCd =	this.edoFuncCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdtEdoAckCd =	this.ibdtEdoAckCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoTpCd =	this.edoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seltEdoAckCd =	this.seltEdoAckCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyNm =	this.ptyNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyFlg =	this.ptyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslArrDt =	this.vslArrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoRqstSeq5jk =	this.edoRqstSeq5jk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hndlOfcCd =	this.hndlOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doEdoRctLocCd =	this.doEdoRctLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd =	this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seltEdoRctDt =	this.seltEdoRctDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seltEdoAprDt =	this.seltEdoAprDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seltEdoAprUsrId =	this.seltEdoAprUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoRqstNo =	this.edoRqstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doEdoAckCd =	this.doEdoAckCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doEdoRctDt =	this.doEdoRctDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltUsrId =	this.deltUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd =	this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whNm =	this.whNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoRvwFlg =	this.edoRvwFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoRvwUsrId =	this.edoRvwUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstNo =	this.rqstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseFlg =	this.rlseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd =	this.deTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpCd =	this.cntrTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd =	this.blTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doRlseUsrId =	this.doRlseUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}
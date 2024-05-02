/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : EesEqr0045ConditionVO.java
 *@FileTitle : EesEqr0045ConditionVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.01.22
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.01.22  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo;

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
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class EesEqr0045ConditionVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<EesEqr0045ConditionVO>  models =	new	ArrayList<EesEqr0045ConditionVO>();


	/*	Column Info	*/
	private  String	 scnrseq   =  null;
	/*	Column Info	*/
	private  String	 planidnormk   =  null;
	/*	Column Info	*/
	private  String	 scnrweek   =  null;
	/*	Column Info	*/
	private  String	 scnrId   =  null;
	/*	Column Info	*/
	private  String	 status   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 repoPlnId   =  null;
	/*	Column Info	*/
	private  String	 planidflag   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 repoweek   =  null;
	/*	Column Info	*/
	private  String	 reposeq   =  null;
	/*	Column Info	*/
	private  String	 repo_pln   =  null;
	/*	Column Info	*/
	private  String	 fm_rcc_cd   =  null;
	/*	Column Info	*/
	private  String	 fm_lcc_cd   =  null;
	/*	Column Info	*/
	private  String	 fm_ecc_cd   =  null;
	/*	Column Info	*/
	private  String	 fm_loc_cd   =  null;
	/*	Column Info	*/
	private  String	 fm_yard_cd   =  null;
	/*	Column Info	*/
	private  String	 s_lane_cd   =  null;
	/*	Column Info	*/
	private  String	 to_rcc_cd   =  null;
	/*	Column Info	*/
	private  String	 to_lcc_cd   =  null;
	/*	Column Info	*/
	private  String	 to_ecc_cd   =  null;
	/*	Column Info	*/
	private  String	 to_loc_cd   =  null;
	/*	Column Info	*/
	private  String	 to_yard_cd   =  null;
	/*	Column Info	*/
	private  String	 vvd_cd   =  null;
	/*	Column Info	*/
	private  String	 emt_bkg_no   =  null;
	/*	Column Info	*/
	private  String	 so_no   =  null;
	/*	Column Info	*/
	private  String	 usr_id   =  null;
	/*	Column Info	*/
	private  String	 repo_syear   =  null;
	/*	Column Info	*/
	private  String	 repo_sweek   =  null;
	/*	Column Info	*/
	private  String	 repo_eyear   =  null;
	/*	Column Info	*/
	private  String	 repo_eweek   =  null;
	/*	Column Info	*/
	private  String	 cbx_rcc_cd   =  null;
	/*	Column Info	*/
	private  String	 cbx_lcc_cd   =  null;
	/*	Column Info	*/
	private  String	 cbx_ecc_cd   =  null;
	/*	Column Info	*/
	private  String	 cbx_loc_cd   =  null;
	/*	Column Info	*/
	private  String	 cbx_yard_cd   =  null;
	/*	Column Info	*/
	private  String	 cbx_emt_bkg_no   =  null;
	/*	Column Info	*/
	private  String	 cbx_vvd_cd   =  null;
	/*	Column Info	*/
	private  String	 cbx_so_no   =  null;
	/*	Column Info	*/
	private  String	 repo_pln_seq   =  null;
	/*	Column Info	*/
	private  String	 ref_id   =  null;
	/*	Column Info	*/
	private  String	 cbx_ref_id   =  null;
	/*	Column Info	*/
	private  String	 cbx_ep_tp_cd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public EesEqr0045ConditionVO(){}

	public EesEqr0045ConditionVO(String scnrseq,String planidnormk,String scnrweek,String scnrId,String status,String pagerows,String repoPlnId,String planidflag,String creUsrId,String ibflag,String repoweek,String reposeq,String repo_pln,String fm_rcc_cd,String fm_lcc_cd,String fm_ecc_cd,String fm_loc_cd,String fm_yard_cd,String s_lane_cd,String to_rcc_cd,String to_lcc_cd,String to_ecc_cd,String to_loc_cd,String to_yard_cd,String vvd_cd,String emt_bkg_no,String so_no,String usr_id,String repo_syear,String repo_sweek,String repo_eyear,String repo_eweek,String cbx_rcc_cd,String cbx_lcc_cd,String cbx_ecc_cd,String cbx_loc_cd,String cbx_yard_cd,String cbx_emt_bkg_no,String cbx_vvd_cd,String cbx_so_no,String repo_pln_seq,String ref_id,String cbx_ref_id,String cbx_ep_tp_cd)	{
		this.scnrseq  = scnrseq ;
		this.planidnormk  = planidnormk ;
		this.scnrweek  = scnrweek ;
		this.scnrId  = scnrId ;
		this.status  = status ;
		this.pagerows  = pagerows ;
		this.repoPlnId  = repoPlnId ;
		this.planidflag  = planidflag ;
		this.creUsrId  = creUsrId ;
		this.ibflag  = ibflag ;
		this.repoweek  = repoweek ;
		this.reposeq  = reposeq ;
		this.repo_pln  = repo_pln ;
		this.fm_rcc_cd  = fm_rcc_cd ;
		this.fm_lcc_cd  = fm_lcc_cd ;
		this.fm_ecc_cd  = fm_ecc_cd ;
		this.fm_loc_cd  = fm_loc_cd ;
		this.fm_yard_cd  = fm_yard_cd ;
		this.s_lane_cd  = s_lane_cd ;
		this.to_rcc_cd  = to_rcc_cd ;
		this.to_lcc_cd  = to_lcc_cd ;
		this.to_ecc_cd  = to_ecc_cd ;
		this.to_loc_cd  = to_loc_cd ;
		this.to_yard_cd  = to_yard_cd ;
		this.vvd_cd  = vvd_cd ;
		this.emt_bkg_no  = emt_bkg_no ;
		this.so_no  = so_no ;
		this.usr_id  = usr_id ;
		this.repo_syear  = repo_syear ;
		this.repo_sweek  = repo_sweek ;
		this.repo_eyear  = repo_eyear ;
		this.repo_eweek  = repo_eweek ;
		this.cbx_rcc_cd  = cbx_rcc_cd ;
		this.cbx_lcc_cd  = cbx_lcc_cd ;
		this.cbx_ecc_cd  = cbx_ecc_cd ;
		this.cbx_loc_cd  = cbx_loc_cd ;
		this.cbx_yard_cd  = cbx_yard_cd ;
		this.cbx_emt_bkg_no  = cbx_emt_bkg_no ;
		this.cbx_vvd_cd  = cbx_vvd_cd ;
		this.cbx_so_no  = cbx_so_no ;
		this.repo_pln_seq  = repo_pln_seq ;
		this.ref_id  = ref_id ;
		this.cbx_ref_id  = cbx_ref_id ;
		this.cbx_ep_tp_cd  = cbx_ep_tp_cd ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("scnrseq", getScnrseq());		
		this.hashColumns.put("planidnormk", getPlanidnormk());		
		this.hashColumns.put("scnrweek", getScnrweek());		
		this.hashColumns.put("scnr_id", getScnrId());		
		this.hashColumns.put("status", getStatus());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("repo_pln_id", getRepoPlnId());		
		this.hashColumns.put("planidflag", getPlanidflag());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("repoweek", getRepoweek());		
		this.hashColumns.put("reposeq", getReposeq());		
		this.hashColumns.put("repo_pln", getRepo_pln());		
		this.hashColumns.put("fm_rcc_cd", getFm_rcc_cd());		
		this.hashColumns.put("fm_lcc_cd", getFm_lcc_cd());		
		this.hashColumns.put("fm_ecc_cd", getFm_ecc_cd());		
		this.hashColumns.put("fm_loc_cd", getFm_loc_cd());		
		this.hashColumns.put("fm_yard_cd", getFm_yard_cd());		
		this.hashColumns.put("s_lane_cd", getS_lane_cd());		
		this.hashColumns.put("to_rcc_cd", getTo_rcc_cd());		
		this.hashColumns.put("to_lcc_cd", getTo_lcc_cd());		
		this.hashColumns.put("to_ecc_cd", getTo_ecc_cd());		
		this.hashColumns.put("to_loc_cd", getTo_loc_cd());		
		this.hashColumns.put("to_yard_cd", getTo_yard_cd());		
		this.hashColumns.put("vvd_cd", getVvd_cd());		
		this.hashColumns.put("emt_bkg_no", getEmt_bkg_no());		
		this.hashColumns.put("so_no", getSo_no());		
		this.hashColumns.put("usr_id", getUsr_id());		
		this.hashColumns.put("repo_syear", getRepo_syear());		
		this.hashColumns.put("repo_sweek", getRepo_sweek());		
		this.hashColumns.put("repo_eyear", getRepo_eyear());		
		this.hashColumns.put("repo_eweek", getRepo_eweek());		
		this.hashColumns.put("cbx_rcc_cd", getCbx_rcc_cd());		
		this.hashColumns.put("cbx_lcc_cd", getCbx_lcc_cd());		
		this.hashColumns.put("cbx_ecc_cd", getCbx_ecc_cd());		
		this.hashColumns.put("cbx_loc_cd", getCbx_loc_cd());		
		this.hashColumns.put("cbx_yard_cd", getCbx_yard_cd());		
		this.hashColumns.put("cbx_emt_bkg_no", getCbx_emt_bkg_no());		
		this.hashColumns.put("cbx_vvd_cd", getCbx_vvd_cd());		
		this.hashColumns.put("cbx_so_no", getCbx_so_no());		
		this.hashColumns.put("repo_pln_seq", getRepo_pln_seq());		
		this.hashColumns.put("ref_id", getRef_id());		
		this.hashColumns.put("cbx_ref_id", getCbx_ref_id());		
		this.hashColumns.put("cbx_ep_tp_cd", getCbx_ep_tp_cd());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("scnrseq", "scnrseq");
		this.hashFields.put("planidnormk", "planidnormk");
		this.hashFields.put("scnrweek", "scnrweek");
		this.hashFields.put("scnr_id", "scnrId");
		this.hashFields.put("status", "status");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("planidflag", "planidflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("repoweek", "repoweek");
		this.hashFields.put("reposeq", "reposeq");
		this.hashFields.put("repo_pln", "repo_pln");
		this.hashFields.put("fm_rcc_cd", "fm_rcc_cd");
		this.hashFields.put("fm_lcc_cd", "fm_lcc_cd");
		this.hashFields.put("fm_ecc_cd", "fm_ecc_cd");
		this.hashFields.put("fm_loc_cd", "fm_loc_cd");
		this.hashFields.put("fm_yard_cd", "fm_yard_cd");
		this.hashFields.put("s_lane_cd", "s_lane_cd");
		this.hashFields.put("to_rcc_cd", "to_rcc_cd");
		this.hashFields.put("to_lcc_cd", "to_lcc_cd");
		this.hashFields.put("to_ecc_cd", "to_ecc_cd");
		this.hashFields.put("to_loc_cd", "to_loc_cd");
		this.hashFields.put("to_yard_cd", "to_yard_cd");
		this.hashFields.put("vvd_cd", "vvd_cd");
		this.hashFields.put("emt_bkg_no", "emt_bkg_no");
		this.hashFields.put("so_no", "so_no");
		this.hashFields.put("usr_id", "usr_id");
		this.hashFields.put("repo_syear", "repo_syear");
		this.hashFields.put("repo_sweek", "repo_sweek");
		this.hashFields.put("repo_eyear", "repo_eyear");
		this.hashFields.put("repo_eweek", "repo_eweek");
		this.hashFields.put("cbx_rcc_cd", "cbx_rcc_cd");
		this.hashFields.put("cbx_lcc_cd", "cbx_lcc_cd");
		this.hashFields.put("cbx_ecc_cd", "cbx_ecc_cd");
		this.hashFields.put("cbx_loc_cd", "cbx_loc_cd");
		this.hashFields.put("cbx_yard_cd", "cbx_yard_cd");
		this.hashFields.put("cbx_emt_bkg_no", "cbx_emt_bkg_no");
		this.hashFields.put("cbx_vvd_cd", "cbx_vvd_cd");
		this.hashFields.put("cbx_so_no", "cbx_so_no");
		this.hashFields.put("repo_pln_seq", "repo_pln_seq");
		this.hashFields.put("ref_id", "ref_id");
		this.hashFields.put("cbx_ref_id", "cbx_ref_id");
		this.hashFields.put("cbx_ep_tp_cd", "cbx_ep_tp_cd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  scnrseq
	*/
	public void	setScnrseq( String	scnrseq ) {
		this.scnrseq =	scnrseq;
	}
 
	/**
	 * Column Info
	 * @return	scnrseq
	 */
	 public	 String	getScnrseq() {
		 return	this.scnrseq;
	 } 
 	/**
	* Column Info
	* @param  planidnormk
	*/
	public void	setPlanidnormk( String	planidnormk ) {
		this.planidnormk =	planidnormk;
	}
 
	/**
	 * Column Info
	 * @return	planidnormk
	 */
	 public	 String	getPlanidnormk() {
		 return	this.planidnormk;
	 } 
 	/**
	* Column Info
	* @param  scnrweek
	*/
	public void	setScnrweek( String	scnrweek ) {
		this.scnrweek =	scnrweek;
	}
 
	/**
	 * Column Info
	 * @return	scnrweek
	 */
	 public	 String	getScnrweek() {
		 return	this.scnrweek;
	 } 
 	/**
	* Column Info
	* @param  scnrId
	*/
	public void	setScnrId( String	scnrId ) {
		this.scnrId =	scnrId;
	}
 
	/**
	 * Column Info
	 * @return	scnrId
	 */
	 public	 String	getScnrId() {
		 return	this.scnrId;
	 } 
 	/**
	* Column Info
	* @param  status
	*/
	public void	setStatus( String	status ) {
		this.status =	status;
	}
 
	/**
	 * Column Info
	 * @return	status
	 */
	 public	 String	getStatus() {
		 return	this.status;
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
	* @param  repoPlnId
	*/
	public void	setRepoPlnId( String	repoPlnId ) {
		this.repoPlnId =	repoPlnId;
	}
 
	/**
	 * Column Info
	 * @return	repoPlnId
	 */
	 public	 String	getRepoPlnId() {
		 return	this.repoPlnId;
	 } 
 	/**
	* Column Info
	* @param  planidflag
	*/
	public void	setPlanidflag( String	planidflag ) {
		this.planidflag =	planidflag;
	}
 
	/**
	 * Column Info
	 * @return	planidflag
	 */
	 public	 String	getPlanidflag() {
		 return	this.planidflag;
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
	* @param  repoweek
	*/
	public void	setRepoweek( String	repoweek ) {
		this.repoweek =	repoweek;
	}
 
	/**
	 * Column Info
	 * @return	repoweek
	 */
	 public	 String	getRepoweek() {
		 return	this.repoweek;
	 } 
 	/**
	* Column Info
	* @param  reposeq
	*/
	public void	setReposeq( String	reposeq ) {
		this.reposeq =	reposeq;
	}
 
	/**
	 * Column Info
	 * @return	reposeq
	 */
	 public	 String	getReposeq() {
		 return	this.reposeq;
	 } 
 	/**
	* Column Info
	* @param  repo_pln
	*/
	public void	setRepo_pln( String	repo_pln ) {
		this.repo_pln =	repo_pln;
	}
 
	/**
	 * Column Info
	 * @return	repo_pln
	 */
	 public	 String	getRepo_pln() {
		 return	this.repo_pln;
	 } 
 	/**
	* Column Info
	* @param  fm_rcc_cd
	*/
	public void	setFm_rcc_cd( String	fm_rcc_cd ) {
		this.fm_rcc_cd =	fm_rcc_cd;
	}
 
	/**
	 * Column Info
	 * @return	fm_rcc_cd
	 */
	 public	 String	getFm_rcc_cd() {
		 return	this.fm_rcc_cd;
	 } 
 	/**
	* Column Info
	* @param  fm_lcc_cd
	*/
	public void	setFm_lcc_cd( String	fm_lcc_cd ) {
		this.fm_lcc_cd =	fm_lcc_cd;
	}
 
	/**
	 * Column Info
	 * @return	fm_lcc_cd
	 */
	 public	 String	getFm_lcc_cd() {
		 return	this.fm_lcc_cd;
	 } 
 	/**
	* Column Info
	* @param  fm_ecc_cd
	*/
	public void	setFm_ecc_cd( String	fm_ecc_cd ) {
		this.fm_ecc_cd =	fm_ecc_cd;
	}
 
	/**
	 * Column Info
	 * @return	fm_ecc_cd
	 */
	 public	 String	getFm_ecc_cd() {
		 return	this.fm_ecc_cd;
	 } 
 	/**
	* Column Info
	* @param  fm_loc_cd
	*/
	public void	setFm_loc_cd( String	fm_loc_cd ) {
		this.fm_loc_cd =	fm_loc_cd;
	}
 
	/**
	 * Column Info
	 * @return	fm_loc_cd
	 */
	 public	 String	getFm_loc_cd() {
		 return	this.fm_loc_cd;
	 } 
 	/**
	* Column Info
	* @param  fm_yard_cd
	*/
	public void	setFm_yard_cd( String	fm_yard_cd ) {
		this.fm_yard_cd =	fm_yard_cd;
	}
 
	/**
	 * Column Info
	 * @return	fm_yard_cd
	 */
	 public	 String	getFm_yard_cd() {
		 return	this.fm_yard_cd;
	 } 
 	/**
	* Column Info
	* @param  s_lane_cd
	*/
	public void	setS_lane_cd( String	s_lane_cd ) {
		this.s_lane_cd =	s_lane_cd;
	}
 
	/**
	 * Column Info
	 * @return	s_lane_cd
	 */
	 public	 String	getS_lane_cd() {
		 return	this.s_lane_cd;
	 } 
 	/**
	* Column Info
	* @param  to_rcc_cd
	*/
	public void	setTo_rcc_cd( String	to_rcc_cd ) {
		this.to_rcc_cd =	to_rcc_cd;
	}
 
	/**
	 * Column Info
	 * @return	to_rcc_cd
	 */
	 public	 String	getTo_rcc_cd() {
		 return	this.to_rcc_cd;
	 } 
 	/**
	* Column Info
	* @param  to_lcc_cd
	*/
	public void	setTo_lcc_cd( String	to_lcc_cd ) {
		this.to_lcc_cd =	to_lcc_cd;
	}
 
	/**
	 * Column Info
	 * @return	to_lcc_cd
	 */
	 public	 String	getTo_lcc_cd() {
		 return	this.to_lcc_cd;
	 } 
 	/**
	* Column Info
	* @param  to_ecc_cd
	*/
	public void	setTo_ecc_cd( String	to_ecc_cd ) {
		this.to_ecc_cd =	to_ecc_cd;
	}
 
	/**
	 * Column Info
	 * @return	to_ecc_cd
	 */
	 public	 String	getTo_ecc_cd() {
		 return	this.to_ecc_cd;
	 } 
 	/**
	* Column Info
	* @param  to_loc_cd
	*/
	public void	setTo_loc_cd( String	to_loc_cd ) {
		this.to_loc_cd =	to_loc_cd;
	}
 
	/**
	 * Column Info
	 * @return	to_loc_cd
	 */
	 public	 String	getTo_loc_cd() {
		 return	this.to_loc_cd;
	 } 
 	/**
	* Column Info
	* @param  to_yard_cd
	*/
	public void	setTo_yard_cd( String	to_yard_cd ) {
		this.to_yard_cd =	to_yard_cd;
	}
 
	/**
	 * Column Info
	 * @return	to_yard_cd
	 */
	 public	 String	getTo_yard_cd() {
		 return	this.to_yard_cd;
	 } 
 	/**
	* Column Info
	* @param  vvd_cd
	*/
	public void	setVvd_cd( String	vvd_cd ) {
		this.vvd_cd =	vvd_cd;
	}
 
	/**
	 * Column Info
	 * @return	vvd_cd
	 */
	 public	 String	getVvd_cd() {
		 return	this.vvd_cd;
	 } 
 	/**
	* Column Info
	* @param  emt_bkg_no
	*/
	public void	setEmt_bkg_no( String	emt_bkg_no ) {
		this.emt_bkg_no =	emt_bkg_no;
	}
 
	/**
	 * Column Info
	 * @return	emt_bkg_no
	 */
	 public	 String	getEmt_bkg_no() {
		 return	this.emt_bkg_no;
	 } 
 	/**
	* Column Info
	* @param  so_no
	*/
	public void	setSo_no( String	so_no ) {
		this.so_no =	so_no;
	}
 
	/**
	 * Column Info
	 * @return	so_no
	 */
	 public	 String	getSo_no() {
		 return	this.so_no;
	 } 
 	/**
	* Column Info
	* @param  usr_id
	*/
	public void	setUsr_id( String	usr_id ) {
		this.usr_id =	usr_id;
	}
 
	/**
	 * Column Info
	 * @return	usr_id
	 */
	 public	 String	getUsr_id() {
		 return	this.usr_id;
	 } 
 	/**
	* Column Info
	* @param  repo_syear
	*/
	public void	setRepo_syear( String	repo_syear ) {
		this.repo_syear =	repo_syear;
	}
 
	/**
	 * Column Info
	 * @return	repo_syear
	 */
	 public	 String	getRepo_syear() {
		 return	this.repo_syear;
	 } 
 	/**
	* Column Info
	* @param  repo_sweek
	*/
	public void	setRepo_sweek( String	repo_sweek ) {
		this.repo_sweek =	repo_sweek;
	}
 
	/**
	 * Column Info
	 * @return	repo_sweek
	 */
	 public	 String	getRepo_sweek() {
		 return	this.repo_sweek;
	 } 
 	/**
	* Column Info
	* @param  repo_eyear
	*/
	public void	setRepo_eyear( String	repo_eyear ) {
		this.repo_eyear =	repo_eyear;
	}
 
	/**
	 * Column Info
	 * @return	repo_eyear
	 */
	 public	 String	getRepo_eyear() {
		 return	this.repo_eyear;
	 } 
 	/**
	* Column Info
	* @param  repo_eweek
	*/
	public void	setRepo_eweek( String	repo_eweek ) {
		this.repo_eweek =	repo_eweek;
	}
 
	/**
	 * Column Info
	 * @return	repo_eweek
	 */
	 public	 String	getRepo_eweek() {
		 return	this.repo_eweek;
	 } 
 	/**
	* Column Info
	* @param  cbx_rcc_cd
	*/
	public void	setCbx_rcc_cd( String	cbx_rcc_cd ) {
		this.cbx_rcc_cd =	cbx_rcc_cd;
	}
 
	/**
	 * Column Info
	 * @return	cbx_rcc_cd
	 */
	 public	 String	getCbx_rcc_cd() {
		 return	this.cbx_rcc_cd;
	 } 
 	/**
	* Column Info
	* @param  cbx_lcc_cd
	*/
	public void	setCbx_lcc_cd( String	cbx_lcc_cd ) {
		this.cbx_lcc_cd =	cbx_lcc_cd;
	}
 
	/**
	 * Column Info
	 * @return	cbx_lcc_cd
	 */
	 public	 String	getCbx_lcc_cd() {
		 return	this.cbx_lcc_cd;
	 } 
 	/**
	* Column Info
	* @param  cbx_ecc_cd
	*/
	public void	setCbx_ecc_cd( String	cbx_ecc_cd ) {
		this.cbx_ecc_cd =	cbx_ecc_cd;
	}
 
	/**
	 * Column Info
	 * @return	cbx_ecc_cd
	 */
	 public	 String	getCbx_ecc_cd() {
		 return	this.cbx_ecc_cd;
	 } 
 	/**
	* Column Info
	* @param  cbx_loc_cd
	*/
	public void	setCbx_loc_cd( String	cbx_loc_cd ) {
		this.cbx_loc_cd =	cbx_loc_cd;
	}
 
	/**
	 * Column Info
	 * @return	cbx_loc_cd
	 */
	 public	 String	getCbx_loc_cd() {
		 return	this.cbx_loc_cd;
	 } 
 	/**
	* Column Info
	* @param  cbx_yard_cd
	*/
	public void	setCbx_yard_cd( String	cbx_yard_cd ) {
		this.cbx_yard_cd =	cbx_yard_cd;
	}
 
	/**
	 * Column Info
	 * @return	cbx_yard_cd
	 */
	 public	 String	getCbx_yard_cd() {
		 return	this.cbx_yard_cd;
	 } 
 	/**
	* Column Info
	* @param  cbx_emt_bkg_no
	*/
	public void	setCbx_emt_bkg_no( String	cbx_emt_bkg_no ) {
		this.cbx_emt_bkg_no =	cbx_emt_bkg_no;
	}
 
	/**
	 * Column Info
	 * @return	cbx_emt_bkg_no
	 */
	 public	 String	getCbx_emt_bkg_no() {
		 return	this.cbx_emt_bkg_no;
	 } 
 	/**
	* Column Info
	* @param  cbx_vvd_cd
	*/
	public void	setCbx_vvd_cd( String	cbx_vvd_cd ) {
		this.cbx_vvd_cd =	cbx_vvd_cd;
	}
 
	/**
	 * Column Info
	 * @return	cbx_vvd_cd
	 */
	 public	 String	getCbx_vvd_cd() {
		 return	this.cbx_vvd_cd;
	 } 
 	/**
	* Column Info
	* @param  cbx_so_no
	*/
	public void	setCbx_so_no( String	cbx_so_no ) {
		this.cbx_so_no =	cbx_so_no;
	}
 
	/**
	 * Column Info
	 * @return	cbx_so_no
	 */
	 public	 String	getCbx_so_no() {
		 return	this.cbx_so_no;
	 } 
 	/**
	* Column Info
	* @param  repo_pln_seq
	*/
	public void	setRepo_pln_seq( String	repo_pln_seq ) {
		this.repo_pln_seq =	repo_pln_seq;
	}
 
	/**
	 * Column Info
	 * @return	repo_pln_seq
	 */
	 public	 String	getRepo_pln_seq() {
		 return	this.repo_pln_seq;
	 } 
 	/**
	* Column Info
	* @param  ref_id
	*/
	public void	setRef_id( String	ref_id ) {
		this.ref_id =	ref_id;
	}
 
	/**
	 * Column Info
	 * @return	ref_id
	 */
	 public	 String	getRef_id() {
		 return	this.ref_id;
	 } 
 	/**
	* Column Info
	* @param  cbx_ref_id
	*/
	public void	setCbx_ref_id( String	cbx_ref_id ) {
		this.cbx_ref_id =	cbx_ref_id;
	}
 
	/**
	 * Column Info
	 * @return	cbx_ref_id
	 */
	 public	 String	getCbx_ref_id() {
		 return	this.cbx_ref_id;
	 } 
 	/**
	* Column Info
	* @param  cbx_ep_tp_cd
	*/
	public void	setCbx_ep_tp_cd( String	cbx_ep_tp_cd ) {
		this.cbx_ep_tp_cd =	cbx_ep_tp_cd;
	}
 
	/**
	 * Column Info
	 * @return	cbx_ep_tp_cd
	 */
	 public	 String	getCbx_ep_tp_cd() {
		 return	this.cbx_ep_tp_cd;
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
		setScnrseq(JSPUtil.getParameter(request,	prefix + "scnrseq", ""));
		setPlanidnormk(JSPUtil.getParameter(request,	prefix + "planidnormk", ""));
		setScnrweek(JSPUtil.getParameter(request,	prefix + "scnrweek", ""));
		setScnrId(JSPUtil.getParameter(request,	prefix + "scnr_id", ""));
		setStatus(JSPUtil.getParameter(request,	prefix + "status", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setRepoPlnId(JSPUtil.getParameter(request,	prefix + "repo_pln_id", ""));
		setPlanidflag(JSPUtil.getParameter(request,	prefix + "planidflag", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setRepoweek(JSPUtil.getParameter(request,	prefix + "repoweek", ""));
		setReposeq(JSPUtil.getParameter(request,	prefix + "reposeq", ""));
		setRepo_pln(JSPUtil.getParameter(request,	prefix + "repo_pln", ""));
		setFm_rcc_cd(JSPUtil.getParameter(request,	prefix + "fm_rcc_cd", ""));
		setFm_lcc_cd(JSPUtil.getParameter(request,	prefix + "fm_lcc_cd", ""));
		setFm_ecc_cd(JSPUtil.getParameter(request,	prefix + "fm_ecc_cd", ""));
		setFm_loc_cd(JSPUtil.getParameter(request,	prefix + "fm_loc_cd", ""));
		setFm_yard_cd(JSPUtil.getParameter(request,	prefix + "fm_yard_cd", ""));
		setS_lane_cd(JSPUtil.getParameter(request,	prefix + "s_lane_cd", ""));
		setTo_rcc_cd(JSPUtil.getParameter(request,	prefix + "to_rcc_cd", ""));
		setTo_lcc_cd(JSPUtil.getParameter(request,	prefix + "to_lcc_cd", ""));
		setTo_ecc_cd(JSPUtil.getParameter(request,	prefix + "to_ecc_cd", ""));
		setTo_loc_cd(JSPUtil.getParameter(request,	prefix + "to_loc_cd", ""));
		setTo_yard_cd(JSPUtil.getParameter(request,	prefix + "to_yard_cd", ""));
		setVvd_cd(JSPUtil.getParameter(request,	prefix + "vvd_cd", ""));
		setEmt_bkg_no(JSPUtil.getParameter(request,	prefix + "emt_bkg_no", ""));
		setSo_no(JSPUtil.getParameter(request,	prefix + "so_no", ""));
		setUsr_id(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setRepo_syear(JSPUtil.getParameter(request,	prefix + "repo_syear", ""));
		setRepo_sweek(JSPUtil.getParameter(request,	prefix + "repo_sweek", ""));
		setRepo_eyear(JSPUtil.getParameter(request,	prefix + "repo_eyear", ""));
		setRepo_eweek(JSPUtil.getParameter(request,	prefix + "repo_eweek", ""));
		setCbx_rcc_cd(JSPUtil.getParameter(request,	prefix + "cbx_rcc_cd", ""));
		setCbx_lcc_cd(JSPUtil.getParameter(request,	prefix + "cbx_lcc_cd", ""));
		setCbx_ecc_cd(JSPUtil.getParameter(request,	prefix + "cbx_ecc_cd", ""));
		setCbx_loc_cd(JSPUtil.getParameter(request,	prefix + "cbx_loc_cd", ""));
		setCbx_yard_cd(JSPUtil.getParameter(request,	prefix + "cbx_yard_cd", ""));
		setCbx_emt_bkg_no(JSPUtil.getParameter(request,	prefix + "cbx_emt_bkg_no", ""));
		setCbx_vvd_cd(JSPUtil.getParameter(request,	prefix + "cbx_vvd_cd", ""));
		setCbx_so_no(JSPUtil.getParameter(request,	prefix + "cbx_so_no", ""));
		setRepo_pln_seq(JSPUtil.getParameter(request,	prefix + "repo_pln_seq", ""));
		setRef_id(JSPUtil.getParameter(request,	prefix + "ref_id", ""));
		setCbx_ref_id(JSPUtil.getParameter(request,	prefix + "cbx_ref_id", ""));
		setCbx_ep_tp_cd(JSPUtil.getParameter(request,	prefix + "cbx_ep_tp_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0045ConditionVO[]
	 */
	public EesEqr0045ConditionVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return EesEqr0045ConditionVO[]
	 */
	public EesEqr0045ConditionVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		EesEqr0045ConditionVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] scnrseq =	(JSPUtil.getParameter(request, prefix +	"scnrseq".trim(),	length));
				String[] planidnormk =	(JSPUtil.getParameter(request, prefix +	"planidnormk".trim(),	length));
				String[] scnrweek =	(JSPUtil.getParameter(request, prefix +	"scnrweek".trim(),	length));
				String[] scnrId =	(JSPUtil.getParameter(request, prefix +	"scnr_id".trim(),	length));
				String[] status =	(JSPUtil.getParameter(request, prefix +	"status".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] repoPlnId =	(JSPUtil.getParameter(request, prefix +	"repo_pln_id".trim(),	length));
				String[] planidflag =	(JSPUtil.getParameter(request, prefix +	"planidflag".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] repoweek =	(JSPUtil.getParameter(request, prefix +	"repoweek".trim(),	length));
				String[] reposeq =	(JSPUtil.getParameter(request, prefix +	"reposeq".trim(),	length));
				String[] repo_pln =	(JSPUtil.getParameter(request, prefix +	"repo_pln".trim(),	length));
				String[] fm_rcc_cd =	(JSPUtil.getParameter(request, prefix +	"fm_rcc_cd".trim(),	length));
				String[] fm_lcc_cd =	(JSPUtil.getParameter(request, prefix +	"fm_lcc_cd".trim(),	length));
				String[] fm_ecc_cd =	(JSPUtil.getParameter(request, prefix +	"fm_ecc_cd".trim(),	length));
				String[] fm_loc_cd =	(JSPUtil.getParameter(request, prefix +	"fm_loc_cd".trim(),	length));
				String[] fm_yard_cd =	(JSPUtil.getParameter(request, prefix +	"fm_yard_cd".trim(),	length));
				String[] s_lane_cd =	(JSPUtil.getParameter(request, prefix +	"s_lane_cd".trim(),	length));
				String[] to_rcc_cd =	(JSPUtil.getParameter(request, prefix +	"to_rcc_cd".trim(),	length));
				String[] to_lcc_cd =	(JSPUtil.getParameter(request, prefix +	"to_lcc_cd".trim(),	length));
				String[] to_ecc_cd =	(JSPUtil.getParameter(request, prefix +	"to_ecc_cd".trim(),	length));
				String[] to_loc_cd =	(JSPUtil.getParameter(request, prefix +	"to_loc_cd".trim(),	length));
				String[] to_yard_cd =	(JSPUtil.getParameter(request, prefix +	"to_yard_cd".trim(),	length));
				String[] vvd_cd =	(JSPUtil.getParameter(request, prefix +	"vvd_cd".trim(),	length));
				String[] emt_bkg_no =	(JSPUtil.getParameter(request, prefix +	"emt_bkg_no".trim(),	length));
				String[] so_no =	(JSPUtil.getParameter(request, prefix +	"so_no".trim(),	length));
				String[] usr_id =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] repo_syear =	(JSPUtil.getParameter(request, prefix +	"repo_syear".trim(),	length));
				String[] repo_sweek =	(JSPUtil.getParameter(request, prefix +	"repo_sweek".trim(),	length));
				String[] repo_eyear =	(JSPUtil.getParameter(request, prefix +	"repo_eyear".trim(),	length));
				String[] repo_eweek =	(JSPUtil.getParameter(request, prefix +	"repo_eweek".trim(),	length));
				String[] cbx_rcc_cd =	(JSPUtil.getParameter(request, prefix +	"cbx_rcc_cd".trim(),	length));
				String[] cbx_lcc_cd =	(JSPUtil.getParameter(request, prefix +	"cbx_lcc_cd".trim(),	length));
				String[] cbx_ecc_cd =	(JSPUtil.getParameter(request, prefix +	"cbx_ecc_cd".trim(),	length));
				String[] cbx_loc_cd =	(JSPUtil.getParameter(request, prefix +	"cbx_loc_cd".trim(),	length));
				String[] cbx_yard_cd =	(JSPUtil.getParameter(request, prefix +	"cbx_yard_cd".trim(),	length));
				String[] cbx_emt_bkg_no =	(JSPUtil.getParameter(request, prefix +	"cbx_emt_bkg_no".trim(),	length));
				String[] cbx_vvd_cd =	(JSPUtil.getParameter(request, prefix +	"cbx_vvd_cd".trim(),	length));
				String[] cbx_so_no =	(JSPUtil.getParameter(request, prefix +	"cbx_so_no".trim(),	length));
				String[] repo_pln_seq =	(JSPUtil.getParameter(request, prefix +	"repo_pln_seq".trim(),	length));
				String[] ref_id =	(JSPUtil.getParameter(request, prefix +	"ref_id".trim(),	length));
				String[] cbx_ref_id =	(JSPUtil.getParameter(request, prefix +	"cbx_ref_id".trim(),	length));
				String[] cbx_ep_tp_cd =	(JSPUtil.getParameter(request, prefix +	"cbx_ep_tp_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	EesEqr0045ConditionVO();
						if ( scnrseq[i] !=	null)
						model.setScnrseq( scnrseq[i]);
						if ( planidnormk[i] !=	null)
						model.setPlanidnormk( planidnormk[i]);
						if ( scnrweek[i] !=	null)
						model.setScnrweek( scnrweek[i]);
						if ( scnrId[i] !=	null)
						model.setScnrId( scnrId[i]);
						if ( status[i] !=	null)
						model.setStatus( status[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( repoPlnId[i] !=	null)
						model.setRepoPlnId( repoPlnId[i]);
						if ( planidflag[i] !=	null)
						model.setPlanidflag( planidflag[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( repoweek[i] !=	null)
						model.setRepoweek( repoweek[i]);
						if ( reposeq[i] !=	null)
						model.setReposeq( reposeq[i]);
						if ( repo_pln[i] !=	null)
						model.setRepo_pln( repo_pln[i]);
						if ( fm_rcc_cd[i] !=	null)
						model.setFm_rcc_cd( fm_rcc_cd[i]);
						if ( fm_lcc_cd[i] !=	null)
						model.setFm_lcc_cd( fm_lcc_cd[i]);
						if ( fm_ecc_cd[i] !=	null)
						model.setFm_ecc_cd( fm_ecc_cd[i]);
						if ( fm_loc_cd[i] !=	null)
						model.setFm_loc_cd( fm_loc_cd[i]);
						if ( fm_yard_cd[i] !=	null)
						model.setFm_yard_cd( fm_yard_cd[i]);
						if ( s_lane_cd[i] !=	null)
						model.setS_lane_cd( s_lane_cd[i]);
						if ( to_rcc_cd[i] !=	null)
						model.setTo_rcc_cd( to_rcc_cd[i]);
						if ( to_lcc_cd[i] !=	null)
						model.setTo_lcc_cd( to_lcc_cd[i]);
						if ( to_ecc_cd[i] !=	null)
						model.setTo_ecc_cd( to_ecc_cd[i]);
						if ( to_loc_cd[i] !=	null)
						model.setTo_loc_cd( to_loc_cd[i]);
						if ( to_yard_cd[i] !=	null)
						model.setTo_yard_cd( to_yard_cd[i]);
						if ( vvd_cd[i] !=	null)
						model.setVvd_cd( vvd_cd[i]);
						if ( emt_bkg_no[i] !=	null)
						model.setEmt_bkg_no( emt_bkg_no[i]);
						if ( so_no[i] !=	null)
						model.setSo_no( so_no[i]);
						if ( usr_id[i] !=	null)
						model.setUsr_id( usr_id[i]);
						if ( repo_syear[i] !=	null)
						model.setRepo_syear( repo_syear[i]);
						if ( repo_sweek[i] !=	null)
						model.setRepo_sweek( repo_sweek[i]);
						if ( repo_eyear[i] !=	null)
						model.setRepo_eyear( repo_eyear[i]);
						if ( repo_eweek[i] !=	null)
						model.setRepo_eweek( repo_eweek[i]);
						if ( cbx_rcc_cd[i] !=	null)
						model.setCbx_rcc_cd( cbx_rcc_cd[i]);
						if ( cbx_lcc_cd[i] !=	null)
						model.setCbx_lcc_cd( cbx_lcc_cd[i]);
						if ( cbx_ecc_cd[i] !=	null)
						model.setCbx_ecc_cd( cbx_ecc_cd[i]);
						if ( cbx_loc_cd[i] !=	null)
						model.setCbx_loc_cd( cbx_loc_cd[i]);
						if ( cbx_yard_cd[i] !=	null)
						model.setCbx_yard_cd( cbx_yard_cd[i]);
						if ( cbx_emt_bkg_no[i] !=	null)
						model.setCbx_emt_bkg_no( cbx_emt_bkg_no[i]);
						if ( cbx_vvd_cd[i] !=	null)
						model.setCbx_vvd_cd( cbx_vvd_cd[i]);
						if ( cbx_so_no[i] !=	null)
						model.setCbx_so_no( cbx_so_no[i]);
						if ( repo_pln_seq[i] !=	null)
						model.setRepo_pln_seq( repo_pln_seq[i]);
						if ( ref_id[i] !=	null)
						model.setRef_id( ref_id[i]);
						if ( cbx_ref_id[i] !=	null)
						model.setCbx_ref_id( cbx_ref_id[i]);
						if ( cbx_ep_tp_cd[i] !=	null)
						model.setCbx_ep_tp_cd( cbx_ep_tp_cd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getEesEqr0045ConditionVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return EesEqr0045ConditionVO[]
	 */
	public EesEqr0045ConditionVO[]	 getEesEqr0045ConditionVOs(){
		EesEqr0045ConditionVO[] vos = (EesEqr0045ConditionVO[])models.toArray(new	EesEqr0045ConditionVO[models.size()]);
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
		this.scnrseq =	this.scnrseq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.planidnormk =	this.planidnormk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrweek =	this.scnrweek.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrId =	this.scnrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status =	this.status.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId =	this.repoPlnId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.planidflag =	this.planidflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoweek =	this.repoweek.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reposeq =	this.reposeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repo_pln =	this.repo_pln.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fm_rcc_cd =	this.fm_rcc_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fm_lcc_cd =	this.fm_lcc_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fm_ecc_cd =	this.fm_ecc_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fm_loc_cd =	this.fm_loc_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fm_yard_cd =	this.fm_yard_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s_lane_cd =	this.s_lane_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.to_rcc_cd =	this.to_rcc_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.to_lcc_cd =	this.to_lcc_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.to_ecc_cd =	this.to_ecc_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.to_loc_cd =	this.to_loc_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.to_yard_cd =	this.to_yard_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd_cd =	this.vvd_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emt_bkg_no =	this.emt_bkg_no.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.so_no =	this.so_no.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usr_id =	this.usr_id.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repo_syear =	this.repo_syear.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repo_sweek =	this.repo_sweek.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repo_eyear =	this.repo_eyear.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repo_eweek =	this.repo_eweek.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbx_rcc_cd =	this.cbx_rcc_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbx_lcc_cd =	this.cbx_lcc_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbx_ecc_cd =	this.cbx_ecc_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbx_loc_cd =	this.cbx_loc_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbx_yard_cd =	this.cbx_yard_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbx_emt_bkg_no =	this.cbx_emt_bkg_no.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbx_vvd_cd =	this.cbx_vvd_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbx_so_no =	this.cbx_so_no.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repo_pln_seq =	this.repo_pln_seq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ref_id =	this.ref_id.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbx_ref_id =	this.cbx_ref_id.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbx_ep_tp_cd =	this.cbx_ep_tp_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : COPSearchDBDAOSearchTargetCOPInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.10
*@LastModifier : 
*@LastVersion : 1.0
* 2013.06.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class COPSearchDBDAOSearchTargetCOPInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTargetCOPInfoList
	  * </pre>
	  */
	public COPSearchDBDAOSearchTargetCOPInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound_name",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copmanage.copsearch.integration").append("\n"); 
		query.append("FileName : COPSearchDBDAOSearchTargetCOPInfoListRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT A.COP_NO COP_NO" ).append("\n"); 
		query.append("     , MAX(decode(substr(cntr_no,5),'0000000','',cntr_no)) cntr_no " ).append("\n"); 
		query.append("     , MAX(act_nm) act_nm " ).append("\n"); 
		query.append("     , MAX(nod_cd) nod_cd " ).append("\n"); 
		query.append("     , MAX(act_dt) act_dt " ).append("\n"); 
		query.append("	 , MAX(SUBSTR(sce_cop_dlv_dt_fnc(a.cop_no,bkg_no),1, INSTR(sce_cop_dlv_dt_fnc(a.cop_no,bkg_no),'#')-1)) planed_dt  " ).append("\n"); 
		query.append("	 , MAX(SUBSTR(sce_cop_dlv_dt_fnc(a.cop_no,bkg_no),INSTR(sce_cop_dlv_dt_fnc(a.cop_no,bkg_no),'#')+1)) est_dt		" ).append("\n"); 
		query.append("	 ,0 estm_cost" ).append("\n"); 
		query.append("	 ,@[bound_name] bnd_vskd_seq_cd" ).append("\n"); 
		query.append("	 --, max(a.cost_act_grp_seq)cost_act_grp_seq" ).append("\n"); 
		query.append("	 , MAX(pctl_no)pctl_no" ).append("\n"); 
		query.append("	 , MAX(cop_sub_sts_cd) cop_sub_sts_cd" ).append("\n"); 
		query.append("	 --, max(MAX_GRP_SEQ) MAX_GRP_SEQ" ).append("\n"); 
		query.append("	 , MAX(max_dtl_seq) max_dtl_seq " ).append("\n"); 
		query.append("     , '' pctl_no " ).append("\n"); 
		query.append("     , '' org_nod_cd_val 																				" ).append("\n"); 
		query.append("     , '' est_dlv_tm                                                       							" ).append("\n"); 
		query.append("     , '' est_tot_cost                                                                         	" ).append("\n"); 
		query.append("   	 , '' item_cnt                          	" ).append("\n"); 
		query.append("	 , ''  item_max_cnt 			" ).append("\n"); 
		query.append("	 , '' io_bnd_cd   																																		" ).append("\n"); 
		query.append("	 , '' inlnd_rout_cmb_flg  " ).append("\n"); 
		query.append("     , '' location" ).append("\n"); 
		query.append("     , '' act_sts_cd" ).append("\n"); 
		query.append("     , max(bkg_no) bkg_no" ).append("\n"); 
		query.append("     , max(cop_sts_cd) cop_sts_cd" ).append("\n"); 
		query.append("FROM ( " ).append("\n"); 
		query.append("	  SELECT a.cop_no" ).append("\n"); 
		query.append("	       , bkg_no" ).append("\n"); 
		query.append("	       , cntr_no " ).append("\n"); 
		query.append("	       , act_nm " ).append("\n"); 
		query.append("	       , nod_cd " ).append("\n"); 
		query.append("	       , TO_CHAR(act_dt ,'YYYY-MM-DD HH24:MI') act_dt " ).append("\n"); 
		query.append("	  	   , SUBSTR(sce_cop_dlv_dt_fnc(a.cop_no,bkg_no),1, INSTR(sce_cop_dlv_dt_fnc(a.cop_no,bkg_no),'#')-1) planed_dt " ).append("\n"); 
		query.append("		   , SUBSTR(sce_cop_dlv_dt_fnc(a.cop_no,bkg_no),INSTR(sce_cop_dlv_dt_fnc(a.cop_no,bkg_no),'#')+1) est_dt	" ).append("\n"); 
		query.append("		   , '' bnd_vskd_seq_cd" ).append("\n"); 
		query.append("		   --, A.cost_act_grp_seq" ).append("\n"); 
		query.append("		   , pctl_no" ).append("\n"); 
		query.append("		   , cop_sub_sts_cd" ).append("\n"); 
		query.append("		   , max_dtl_seq " ).append("\n"); 
		query.append("           , cop_sts_cd" ).append("\n"); 
		query.append("	   FROM ( " ).append("\n"); 
		query.append("		     SELECT a.cop_no " ).append("\n"); 
		query.append("		          , a.bkg_no " ).append("\n"); 
		query.append("		          , a.pctl_no " ).append("\n"); 
		query.append("		          , a.cntr_no " ).append("\n"); 
		query.append("		          , c.act_nm " ).append("\n"); 
		query.append("		          , b.nod_cd " ).append("\n"); 
		query.append("			      , b.act_dt " ).append("\n"); 
		query.append("			      , b.act_sts_cd " ).append("\n"); 
		query.append("			      , b.cop_dtl_seq " ).append("\n"); 
		query.append("			      , MAX(B.cop_dtl_seq) OVER(PARTITION BY b.cop_no) max_dtl_seq" ).append("\n"); 
		query.append("			      , a.cop_sub_sts_cd " ).append("\n"); 
		query.append("                  , a.cop_sts_cd" ).append("\n"); 
		query.append("		       FROM sce_cop_hdr a " ).append("\n"); 
		query.append("		          , sce_cop_dtl b  " ).append("\n"); 
		query.append("		          , mdm_activity c--, SCE_COP_GRP D--" ).append("\n"); 
		query.append("		      WHERE a.cop_no = b.cop_no " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             	AND a.cop_no IN (" ).append("\n"); 
		query.append("	                              #foreach($ele IN ${cop_no})" ).append("\n"); 
		query.append("		                              #if($velocityCount == 1 ) " ).append("\n"); 
		query.append("			                             ($ele)" ).append("\n"); 
		query.append("		                              #else " ).append("\n"); 
		query.append("			                             ,($ele) " ).append("\n"); 
		query.append("	                                  #end " ).append("\n"); 
		query.append("	                              #end" ).append("\n"); 
		query.append("	                             )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		        AND b.act_cd = c.act_cd " ).append("\n"); 
		query.append("		        AND b.act_sts_cd = 'C' " ).append("\n"); 
		query.append("		      UNION " ).append("\n"); 
		query.append("		     SELECT a.cop_no " ).append("\n"); 
		query.append("		          , a.bkg_no " ).append("\n"); 
		query.append("		          , a.pctl_no " ).append("\n"); 
		query.append("		          , a.cntr_no " ).append("\n"); 
		query.append("		          , c.act_nm " ).append("\n"); 
		query.append("		          , b.nod_cd" ).append("\n"); 
		query.append("			      , b.act_dt " ).append("\n"); 
		query.append("			      , b.act_sts_cd " ).append("\n"); 
		query.append("			      , b.cop_dtl_seq " ).append("\n"); 
		query.append("			      , MAX(b.cop_dtl_seq) OVER(PARTITION BY b.cop_no) max_dtl_seq" ).append("\n"); 
		query.append("			      , a.cop_sub_sts_cd " ).append("\n"); 
		query.append("                  , a.cop_sts_cd" ).append("\n"); 
		query.append("		       FROM sce_cop_hdr a " ).append("\n"); 
		query.append("		          , sce_cop_dtl b  " ).append("\n"); 
		query.append("		          , mdm_activity c" ).append("\n"); 
		query.append("		      WHERE a.cop_no = b.cop_no " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	            AND a.cop_no IN (" ).append("\n"); 
		query.append("	                             #foreach($ele IN ${cop_no})" ).append("\n"); 
		query.append("		                            #if($velocityCount == 1 ) " ).append("\n"); 
		query.append("			                           ($ele)" ).append("\n"); 
		query.append("		                            #else " ).append("\n"); 
		query.append("		                            	,($ele) " ).append("\n"); 
		query.append("	                            	#end " ).append("\n"); 
		query.append("	                              #end" ).append("\n"); 
		query.append("	                             )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		        AND b.act_cd = c.act_cd " ).append("\n"); 
		query.append("		        AND b.cop_dtl_seq IN (" ).append("\n"); 
		query.append("			                          SELECT MAX(cop_dtl_seq) " ).append("\n"); 
		query.append("			                            FROM sce_cop_hdr a, sce_cop_dtl b" ).append("\n"); 
		query.append("			                           WHERE 1 = 1 " ).append("\n"); 
		query.append("                                         AND A.COP_SUB_STS_CD = 'R'" ).append("\n"); 
		query.append("                                         AND a.cop_no = b.cop_no" ).append("\n"); 
		query.append("	                                     AND a.cop_no IN (" ).append("\n"); 
		query.append("	                                          #foreach($ele IN ${cop_no})" ).append("\n"); 
		query.append("		                                         #if($velocityCount == 1 ) " ).append("\n"); 
		query.append("			                                         ($ele)" ).append("\n"); 
		query.append("		                                         #else " ).append("\n"); 
		query.append("		                                         	,($ele) " ).append("\n"); 
		query.append("		                                         #end " ).append("\n"); 
		query.append("	                                          #end" ).append("\n"); 
		query.append("	                                          )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		                             ) " ).append("\n"); 
		query.append("		        AND a.cop_sub_sts_cd = 'R' " ).append("\n"); 
		query.append("	        ) a " ).append("\n"); 
		query.append("	 ORDER BY cop_no " ).append("\n"); 
		query.append("     )a " ).append("\n"); 
		query.append("GROUP BY cop_no" ).append("\n"); 

	}
}
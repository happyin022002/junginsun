/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CsScreenDBDAOsearchUsCntrMvntDtlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.13
*@LastModifier : 윤한
*@LastVersion : 1.0
* 2010.05.13 윤한
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CsScreenDBDAOsearchUsCntrMvntDtlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * US I/B CS Screen에서 B/L No 기준으로 Estimate + Actual Container Movement Detail 정보를 조회한다.
	  * </pre>
	  */
	public CsScreenDBDAOsearchUsCntrMvntDtlInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration").append("\n"); 
		query.append("FileName : CsScreenDBDAOsearchUsCntrMvntDtlInfoRSQL").append("\n"); 
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
		query.append("select cntr_no        " ).append("\n"); 
		query.append("      ,cntr_tpsz_cd   " ).append("\n"); 
		query.append("      ,mvmt_sts_nm    " ).append("\n"); 
		query.append("      ,mvmt_evnt_dt   " ).append("\n"); 
		query.append("      ,org_yd_cd      " ).append("\n"); 
		query.append("      ,dest_yd_cd     " ).append("\n"); 
		query.append("      ,cntr_seal_no   " ).append("\n"); 
		query.append("      ,chss_no        " ).append("\n"); 
		query.append("      ,fcar_no        " ).append("\n"); 
		query.append("      ,pkup_no        " ).append("\n"); 
		query.append("      ,trn_no         " ).append("\n"); 
		query.append("      ,wbl_no         " ).append("\n"); 
		query.append("      ,edi_msg" ).append("\n"); 
		query.append("from       " ).append("\n"); 
		query.append("(       " ).append("\n"); 
		query.append("        select mvnt.cntr_no                                     as cntr_no" ).append("\n"); 
		query.append("              ,mvnt.cntr_tpsz_cd                                as cntr_tpsz_cd" ).append("\n"); 
		query.append("              ,sts.mvmt_sts_nm                                  as mvmt_sts_nm" ).append("\n"); 
		query.append("              ,to_char(mvnt.cnmv_evnt_dt, 'yyyy/mm/dd hh24:mi') as mvmt_evnt_dt" ).append("\n"); 
		query.append("              ,mvnt.org_yd_cd                                   as org_yd_cd" ).append("\n"); 
		query.append("              ,mvnt.dest_yd_cd                                  as dest_yd_cd" ).append("\n"); 
		query.append("              ,mvnt.cntr_seal_no                                as cntr_seal_no" ).append("\n"); 
		query.append("              ,mvnt.chss_no                                     as chss_no" ).append("\n"); 
		query.append("              ,''                                               as fcar_no" ).append("\n"); 
		query.append("              ,mvnt.pkup_no                                     as pkup_no" ).append("\n"); 
		query.append("              ,''                                               as trn_no" ).append("\n"); 
		query.append("              ,mvnt.wbl_no                                      as wbl_no" ).append("\n"); 
		query.append("              ,mvnt.mvmt_edi_msg_tp_id                          as edi_msg  " ).append("\n"); 
		query.append("         from ctm_movement mvnt" ).append("\n"); 
		query.append("             ,mdm_mvmt_sts sts" ).append("\n"); 
		query.append("        where mvnt.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("          and mvnt.cntr_no in ( select cntr_no" ).append("\n"); 
		query.append("                                from bkg_container" ).append("\n"); 
		query.append("                                where bkg_no      = @[bkg_no])" ).append("\n"); 
		query.append("          and mvnt.mvmt_edi_msg_tp_id'322'" ).append("\n"); 
		query.append("          and mvnt.mvmt_sts_cd = sts.mvmt_sts_cd " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("       SELECT mvnt.cntr_no                                     as cntr_no" ).append("\n"); 
		query.append("             ,mvnt.cntr_tpsz_cd                                as cntr_tpsz_cd" ).append("\n"); 
		query.append("             ,cs.clm_sght_abbr_nm                              as mvmt_sts_nm" ).append("\n"); 
		query.append("             ,to_char(cl.arr_dt, 'yyyy/mm/dd hh24:mi')         as mvmt_evnt_dt" ).append("\n"); 
		query.append("             , cl.arr_loc_nm||cl.arr_ste_cd                    as org_yd_cd" ).append("\n"); 
		query.append("             , cl.dep_loc_nm||cl.dep_ste_cd                    as dest_yd_cd" ).append("\n"); 
		query.append("             ,''                                               as cntr_seal_no" ).append("\n"); 
		query.append("             ,''                                               as chss_no" ).append("\n"); 
		query.append("             , cl.fcar_no                                      as fcar_no" ).append("\n"); 
		query.append("             ,''                                               as pkup_no" ).append("\n"); 
		query.append("             , cl.trn_no                                       as trn_no" ).append("\n"); 
		query.append("             ,''                                               as wbl_no" ).append("\n"); 
		query.append("             , 'CLM'                                           as mvmt_sts_cd" ).append("\n"); 
		query.append("         FROM ctm_movement mvnt, " ).append("\n"); 
		query.append("              sce_clm cl, " ).append("\n"); 
		query.append("              sce_clm_sght cs  " ).append("\n"); 
		query.append("        WHERE mvnt.bkg_no      = @[bkg_no]" ).append("\n"); 
		query.append("          and mvnt.cntr_no     in (select cntr_no" ).append("\n"); 
		query.append("                                   from bkg_container" ).append("\n"); 
		query.append("                                  where bkg_no      = @[bkg_no])" ).append("\n"); 
		query.append("          and mvnt.cntr_no     = cl.cntr_no" ).append("\n"); 
		query.append("          and mvnt.cnmv_yr     = cl.cnmv_yr" ).append("\n"); 
		query.append("          and mvnt.cnmv_id_no  = cl.cnmv_id_no" ).append("\n"); 
		query.append("          and mvnt.cnmv_seq    = cl.clm_seq" ).append("\n"); 
		query.append("          and cl.clm_sght_cd = cs.clm_sght_cd " ).append("\n"); 
		query.append(") order by  cntr_no, mvmt_evnt_dt desc" ).append("\n"); 

	}
}
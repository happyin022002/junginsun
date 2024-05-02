/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : COPSearchDBDAOSearchTargetCOPInfoList2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.02
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.02 
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

public class COPSearchDBDAOSearchTargetCOPInfoList2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTargetCOPInfoList2
	  * </pre>
	  */
	public COPSearchDBDAOSearchTargetCOPInfoList2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copmanage.copsearch.integration").append("\n"); 
		query.append("FileName : COPSearchDBDAOSearchTargetCOPInfoList2RSQL").append("\n"); 
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
		query.append("SELECT /*+ ORDERED USE_NL(MAIN MST DTL) */ main.pctl_no, main.ROUT_PLN_CD , REPLACE(main.org_nod_cd_val,'->','/') org_nod_cd_val" ).append("\n"); 
		query.append("     --, sce_cop_dlv_dt_cost_fnc('','',SUM(ttl_tztm_hrs),'TIME') est_dlv_tm" ).append("\n"); 
		query.append("     --, sce_cop_dlv_dt_cost_fnc('','',SUM(coa.estm_uc_amt),'COST') est_tot_cost" ).append("\n"); 
		query.append("     ,(SELECT TO_CHAR(MAX(estm_dt),'yyyy-MM-dd hh24:mi') est_dlv_tm" ).append("\n"); 
		query.append("         FROM (" ).append("\n"); 
		query.append("                SELECT LAG(estm_dt, 2) OVER (PARTITION BY a.cop_no ORDER BY a.cop_no,a.cop_dtl_seq) estm_dt" ).append("\n"); 
		query.append("                  FROM sce_cop_dtl A" ).append("\n"); 
		query.append("                 WHERE A.cop_no = @[cop_no]" ).append("\n"); 
		query.append("      ) ) EST_DLV_TM" ).append("\n"); 
		query.append("     , 0 est_tot_cost" ).append("\n"); 
		query.append("   	 , LENGTH(REPLACE(main.org_nod_cd_val,'->','/'))-LENGTH(REPLACE(REPLACE(main.org_nod_cd_val,'->',''),'/',''))+1 item_cnt" ).append("\n"); 
		query.append("	 , MAX(LENGTH(REPLACE(main.org_nod_cd_val,'->','/'))-LENGTH(REPLACE(REPLACE(main.org_nod_cd_val,'->',''),'/',''))) OVER ()+1  item_max_cnt" ).append("\n"); 
		query.append("	 , @[io_bnd_cd] AS io_bnd_cd" ).append("\n"); 
		query.append("	 , max(dtl.inlnd_rout_cmb_flg) inlnd_rout_cmb_flg" ).append("\n"); 
		query.append("	 , NVL(( select INLND_ROUT_TMP_FLG" ).append("\n"); 
		query.append("	       from prd_inlnd_rout_mst inmst" ).append("\n"); 
		query.append("	      where inmst.ROUT_ORG_NOD_CD  = dtl.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("            and inmst.ROUT_DEST_NOD_CD = dtl.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("            and inmst.ROUT_SEQ         = dtl.ROUT_SEQ" ).append("\n"); 
		query.append("            AND inmst.PCTL_IO_BND_CD   = dtl.pctl_io_bnd_cd ),'N') INLND_ROUT_TMP_FLG" ).append("\n"); 
		query.append(" FROM (																			" ).append("\n"); 
		query.append("       SELECT  pctl_no, ROUT_PLN_CD , SUBSTR(MAX(SYS_CONNECT_BY_PATH(ORG_NOD_CD_VAL,'/')),2) org_nod_cd_val" ).append("\n"); 
		query.append("         FROM (" ).append("\n"); 
		query.append("		        SELECT pctl_no" ).append("\n"); 
		query.append("                     , ROUT_PLN_CD" ).append("\n"); 
		query.append("                     , org_nod_cd || DECODE(nod_lnk_div_cd, 'L', '->' || intg_cd_val_dp_desc ||'->' || VNDR_LGL_ENG_NM ) || '->' || NVL(AGMT_REF_NO, '-') org_nod_cd_val" ).append("\n"); 
		query.append("			         , ROW_NUMBER() OVER(PARTITION BY pctl_no ORDER BY pctl_seq) grp_seq" ).append("\n"); 
		query.append("			         , COUNT(pctl_no) OVER(PARTITION BY pctl_no) grp_cnt " ).append("\n"); 
		query.append("			         , '' cost_act_grp_seq" ).append("\n"); 
		query.append("     			FROM (" ).append("\n"); 
		query.append("                       SELECT /*+ USE_NL(A B C) */ " ).append("\n"); 
		query.append("							  a.pctl_no" ).append("\n"); 
		query.append("                            , b.pctl_seq " ).append("\n"); 
		query.append("                            , b.org_nod_cd " ).append("\n"); 
		query.append("                            , b.dest_nod_cd " ).append("\n"); 
		query.append("                            , b.nod_lnk_div_cd " ).append("\n"); 
		query.append("                            , b.trsp_mod_cd" ).append("\n"); 
		query.append("                            , intg_cd_val_dp_desc " ).append("\n"); 
		query.append("                            , REPLACE(VNDR_LGL_ENG_NM , '/', ' ') AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                            , ROW_NUMBER() OVER(PARTITION BY a.pctl_no ORDER BY pctl_seq) grp_seq" ).append("\n"); 
		query.append("                            , COUNT(a.pctl_no) OVER(PARTITION BY a.pctl_no) grp_cnt" ).append("\n"); 
		query.append("							, ROUT_PLN_CD --0903 add" ).append("\n"); 
		query.append("                            , h.AGMT_REF_NO --0903 add" ).append("\n"); 
		query.append("                         FROM prd_prod_ctl_mst a " ).append("\n"); 
		query.append("                            , prd_prod_ctl_rout_dtl b" ).append("\n"); 
		query.append("                            , TRS_AGMT_HDR h" ).append("\n"); 
		query.append("                         	,(" ).append("\n"); 
		query.append("                         	   SELECT intg_cd_val_ctnt, intg_cd_val_dp_desc" ).append("\n"); 
		query.append("                         	     FROM com_intg_cd_dtl" ).append("\n"); 
		query.append("                         	    WHERE intg_cd_id = 'CD00277'" ).append("\n"); 
		query.append("                         	  ) C" ).append("\n"); 
		query.append("                            , MDM_VENDOR  M" ).append("\n"); 
		query.append("                            , PRD_INLND_ROUT_MST C --0903 add" ).append("\n"); 
		query.append("                        WHERE a.pctl_no = b.pctl_no" ).append("\n"); 
		query.append("                          and b.trsp_mod_cd = c.intg_cd_val_ctnt(+)" ).append("\n"); 
		query.append("                          AND a.pctl_no LIKE  SUBSTR(@[pctl_no],1,16) ||'%'" ).append("\n"); 
		query.append("                          AND b.pctl_io_bnd_cd = @[io_bnd_cd] " ).append("\n"); 
		query.append("                          AND b.N1ST_VNDR_SEQ = M.VNDR_SEQ(+)" ).append("\n"); 
		query.append("                          AND b.ROUT_ORG_NOD_CD = c.ROUT_ORG_NOD_CD --0903 add" ).append("\n"); 
		query.append("                          AND b.ROUT_DEST_NOD_CD = c.ROUT_DEST_NOD_CD --0903 add" ).append("\n"); 
		query.append("                          AND b.ROUT_SEQ = c.ROUT_SEQ --0903 add" ).append("\n"); 
		query.append("                          AND b.TRSP_AGMT_OFC_CTY_CD = h.TRSP_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                          AND b.TRSP_AGMT_SEQ = h.TRSP_AGMT_SEQ(+)" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("     			WHERE  nod_lnk_div_cd = DECODE(grp_seq,grp_cnt, 'N','L')" ).append("\n"); 
		query.append("     		  )" ).append("\n"); 
		query.append("      	WHERE grp_seq = grp_cnt " ).append("\n"); 
		query.append("      	      START WITH GRP_SEQ = 1    CONNECT BY PRIOR grp_seq = grp_seq - 1 AND prior pctl_no = pctl_no" ).append("\n"); 
		query.append("        GROUP BY pctl_no ,ROUT_PLN_CD " ).append("\n"); 
		query.append("      ) main" ).append("\n"); 
		query.append("      , prd_prod_ctl_mst mst" ).append("\n"); 
		query.append("      --, coa_com_cost_para coa " ).append("\n"); 
		query.append("      , prd_prod_ctl_rout_dtl dtl" ).append("\n"); 
		query.append(" WHERE main.pctl_no = mst.pctl_no" ).append("\n"); 
		query.append("   --AND dtl.pctl_no = coa.pctl_no(+)" ).append("\n"); 
		query.append("   AND main.pctl_no = dtl.pctl_no" ).append("\n"); 
		query.append("   AND DTL.pctl_io_bnd_cd = @[io_bnd_cd]" ).append("\n"); 
		query.append("  -- AND coa.cost_act_grp_seq(+) = dtl.cost_act_grp_seq" ).append("\n"); 
		query.append(" GROUP BY main.pctl_no" ).append("\n"); 
		query.append("     , main.ROUT_PLN_CD" ).append("\n"); 
		query.append("     , main.org_nod_cd_val" ).append("\n"); 
		query.append("	 , dtl.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("   	 , dtl.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("     , dtl.ROUT_SEQ" ).append("\n"); 
		query.append("     , DTL.pctl_io_bnd_cd" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SurchargeDBDAOPriScgRtCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.surcharge.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurchargeDBDAOPriScgRtCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SurchargeDBDAOPriScgRtRSQL의 총Row수(paging)
	  * </pre>
	  */
	public SurchargeDBDAOPriScgRtCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_esvc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.surcharge.surcharge.integration").append("\n"); 
		query.append("FileName : SurchargeDBDAOPriScgRtCountRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1)" ).append("\n"); 
		query.append("FROM PRI_SCG_RT A" ).append("\n"); 
		query.append("#if (${por_def_cd} != '')" ).append("\n"); 
		query.append("     , (SELECT POR_DEF_CD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT DISTINCT(LOC_CD) AS POR_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[por_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[por_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(RGN_CD) AS POR_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[por_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[por_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(CNT_CD) AS POR_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[por_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[por_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION " ).append("\n"); 
		query.append("                SELECT 'NULL' AS POR_DEF_CD" ).append("\n"); 
		query.append("                  FROM DUAL" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("         SELECT SCG_GRP_LOC_CD" ).append("\n"); 
		query.append("          FROM PRI_SCG_GRP_LOC" ).append("\n"); 
		query.append("         WHERE SCG_GRP_LOC_CD = @[por_def_cd]" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("         SELECT A1.SCG_GRP_LOC_CD AS POR_DEF_CD" ).append("\n"); 
		query.append("          FROM PRI_SCG_GRP_LOC A1" ).append("\n"); 
		query.append("             , (" ).append("\n"); 
		query.append("                SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("                     , CHG_CD" ).append("\n"); 
		query.append("                     , GRP_LOC_SEQ" ).append("\n"); 
		query.append("                  FROM PRI_SCG_GRP_LOC_DTL A" ).append("\n"); 
		query.append("                     , (SELECT POR_DEF_CD" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT DISTINCT(LOC_CD) AS POR_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[por_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[por_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(RGN_CD) AS POR_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[por_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[por_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(CNT_CD) AS POR_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[por_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[por_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                       ) B" ).append("\n"); 
		query.append("                  WHERE A.DTL_LOC_DEF_CD = B.POR_DEF_CD" ).append("\n"); 
		query.append("				 #if (${svc_scp_cd} != '') " ).append("\n"); 
		query.append("				   AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("				 #end" ).append("\n"); 
		query.append("				 #if (${chg_cd} != '') " ).append("\n"); 
		query.append("                   AND A.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("				 #end" ).append("\n"); 
		query.append("               ) B1" ).append("\n"); 
		query.append("         WHERE A1.SVC_SCP_CD = B1.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND A1.CHG_CD = B1.CHG_CD" ).append("\n"); 
		query.append("           AND A1.GRP_LOC_SEQ = B1.GRP_LOC_SEQ" ).append("\n"); 
		query.append("           AND A1.DELT_FLG = 'N'      " ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_def_cd} != '')" ).append("\n"); 
		query.append("     , (SELECT POL_DEF_CD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT DISTINCT(LOC_CD) AS POL_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[pol_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pol_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(RGN_CD) AS POL_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[pol_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pol_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(CNT_CD) AS POL_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[pol_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pol_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION " ).append("\n"); 
		query.append("                SELECT 'NULL' AS POL_DEF_CD" ).append("\n"); 
		query.append("                  FROM DUAL" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("         SELECT SCG_GRP_LOC_CD" ).append("\n"); 
		query.append("          FROM PRI_SCG_GRP_LOC" ).append("\n"); 
		query.append("         WHERE SCG_GRP_LOC_CD = @[pol_def_cd]" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("         SELECT A1.SCG_GRP_LOC_CD AS POL_DEF_CD" ).append("\n"); 
		query.append("          FROM PRI_SCG_GRP_LOC A1" ).append("\n"); 
		query.append("             , (" ).append("\n"); 
		query.append("                SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("                     , CHG_CD" ).append("\n"); 
		query.append("                     , GRP_LOC_SEQ" ).append("\n"); 
		query.append("                  FROM PRI_SCG_GRP_LOC_DTL A" ).append("\n"); 
		query.append("                     , (SELECT POL_DEF_CD" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT DISTINCT(LOC_CD) AS POL_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[pol_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pol_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(RGN_CD) AS POL_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[pol_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pol_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(CNT_CD) AS POL_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[pol_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pol_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                       ) B" ).append("\n"); 
		query.append("                  WHERE A.DTL_LOC_DEF_CD = B.POL_DEF_CD" ).append("\n"); 
		query.append("				 #if (${svc_scp_cd} != '') " ).append("\n"); 
		query.append("				   AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("				 #end" ).append("\n"); 
		query.append("				 #if (${chg_cd} != '') " ).append("\n"); 
		query.append("                   AND A.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("				 #end" ).append("\n"); 
		query.append("               ) B1" ).append("\n"); 
		query.append("         WHERE A1.SVC_SCP_CD = B1.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND A1.CHG_CD = B1.CHG_CD" ).append("\n"); 
		query.append("           AND A1.GRP_LOC_SEQ = B1.GRP_LOC_SEQ" ).append("\n"); 
		query.append("           AND A1.DELT_FLG = 'N'      " ).append("\n"); 
		query.append("       ) C" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_def_cd} != '')" ).append("\n"); 
		query.append("     , (SELECT POD_DEF_CD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT DISTINCT(LOC_CD) AS POD_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[pod_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pod_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(RGN_CD) AS POD_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[pod_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pod_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(CNT_CD) AS POD_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[pod_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pod_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION " ).append("\n"); 
		query.append("                SELECT 'NULL' AS POD_DEF_CD" ).append("\n"); 
		query.append("                  FROM DUAL" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("         SELECT SCG_GRP_LOC_CD" ).append("\n"); 
		query.append("          FROM PRI_SCG_GRP_LOC" ).append("\n"); 
		query.append("         WHERE SCG_GRP_LOC_CD = @[pod_def_cd]" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("         SELECT A1.SCG_GRP_LOC_CD AS POD_DEF_CD" ).append("\n"); 
		query.append("          FROM PRI_SCG_GRP_LOC A1" ).append("\n"); 
		query.append("             , (" ).append("\n"); 
		query.append("                SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("                     , CHG_CD" ).append("\n"); 
		query.append("                     , GRP_LOC_SEQ" ).append("\n"); 
		query.append("                  FROM PRI_SCG_GRP_LOC_DTL A" ).append("\n"); 
		query.append("                     , (SELECT POD_DEF_CD" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT DISTINCT(LOC_CD) AS POD_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[pod_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pod_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(RGN_CD) AS POD_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[pod_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pod_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(CNT_CD) AS POD_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[pod_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pod_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                       ) B" ).append("\n"); 
		query.append("                  WHERE A.DTL_LOC_DEF_CD = B.POD_DEF_CD" ).append("\n"); 
		query.append("				 #if (${svc_scp_cd} != '') " ).append("\n"); 
		query.append("				   AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("				 #end" ).append("\n"); 
		query.append("				 #if (${chg_cd} != '') " ).append("\n"); 
		query.append("                   AND A.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("				 #end" ).append("\n"); 
		query.append("               ) B1" ).append("\n"); 
		query.append("         WHERE A1.SVC_SCP_CD = B1.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND A1.CHG_CD = B1.CHG_CD" ).append("\n"); 
		query.append("           AND A1.GRP_LOC_SEQ = B1.GRP_LOC_SEQ" ).append("\n"); 
		query.append("           AND A1.DELT_FLG = 'N'      " ).append("\n"); 
		query.append("       ) D" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_def_cd} != '')" ).append("\n"); 
		query.append("     , (SELECT DEL_DEF_CD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT DISTINCT(LOC_CD) AS DEL_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[del_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[del_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(RGN_CD) AS DEL_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[del_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[del_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(CNT_CD) AS DEL_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[del_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[del_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION " ).append("\n"); 
		query.append("                SELECT 'NULL' AS DEL_DEF_CD" ).append("\n"); 
		query.append("                  FROM DUAL" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("         SELECT SCG_GRP_LOC_CD" ).append("\n"); 
		query.append("          FROM PRI_SCG_GRP_LOC" ).append("\n"); 
		query.append("         WHERE SCG_GRP_LOC_CD = @[del_def_cd]" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("         SELECT A1.SCG_GRP_LOC_CD AS DEL_DEF_CD" ).append("\n"); 
		query.append("          FROM PRI_SCG_GRP_LOC A1" ).append("\n"); 
		query.append("             , (" ).append("\n"); 
		query.append("                SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("                     , CHG_CD" ).append("\n"); 
		query.append("                     , GRP_LOC_SEQ" ).append("\n"); 
		query.append("                  FROM PRI_SCG_GRP_LOC_DTL A" ).append("\n"); 
		query.append("                     , (SELECT DEL_DEF_CD" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT DISTINCT(LOC_CD) AS DEL_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[del_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[del_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(RGN_CD) AS DEL_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[del_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[del_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(CNT_CD) AS DEL_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[del_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[del_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                       ) B" ).append("\n"); 
		query.append("                 WHERE A.DTL_LOC_DEF_CD = B.DEL_DEF_CD" ).append("\n"); 
		query.append("				 #if (${svc_scp_cd} != '') " ).append("\n"); 
		query.append("				   AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("				 #end" ).append("\n"); 
		query.append("				 #if (${chg_cd} != '') " ).append("\n"); 
		query.append("                   AND A.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("				 #end" ).append("\n"); 
		query.append("               ) B1" ).append("\n"); 
		query.append("         WHERE A1.SVC_SCP_CD = B1.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND A1.CHG_CD = B1.CHG_CD" ).append("\n"); 
		query.append("           AND A1.GRP_LOC_SEQ = B1.GRP_LOC_SEQ" ).append("\n"); 
		query.append("           AND A1.DELT_FLG = 'N'      " ).append("\n"); 
		query.append("       ) E" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_sz_cd} != '')" ).append("\n"); 
		query.append("   , PRI_RAT_UT F" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("WHERE A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '') " ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chg_cd} != '') " ).append("\n"); 
		query.append("AND	A.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_def_cd} != '') " ).append("\n"); 
		query.append("   AND NVL(A.POR_DEF_CD, 'NULL') = B.POR_DEF_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_def_cd} != '') " ).append("\n"); 
		query.append("   AND NVL(A.POL_DEF_CD, 'NULL') = C.POL_DEF_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_def_cd} != '') " ).append("\n"); 
		query.append("   AND NVL(A.POD_DEF_CD, 'NULL') = D.POD_DEF_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_def_cd} != '')" ).append("\n"); 
		query.append("   AND NVL(A.DEL_DEF_CD, 'NULL') = E.DEL_DEF_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prc_rcv_term_cd} != '')" ).append("\n"); 
		query.append("AND	NVL(A.PRC_RCV_TERM_CD, 'NULL') IN (@[prc_rcv_term_cd], 'NULL')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prc_de_term_cd} != '')" ).append("\n"); 
		query.append("AND	NVL(A.PRC_DE_TERM_CD, 'NULL') IN (@[prc_de_term_cd], 'NULL')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eff_dt} != '')" ).append("\n"); 
		query.append("AND	TO_DATE(REPLACE(@[eff_dt],'-',''), 'YYYYMMDD') BETWEEN A.EFF_DT AND A.EXP_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${upd_dt} != '')" ).append("\n"); 
		query.append("AND	A.UPD_DT BETWEEN TO_DATE(REPLACE(@[upd_dt],'-','')||'000000', 'YYYYMMDDHH24MISS') AND TO_DATE(REPLACE(@[upd_dt],'-','')||'235959', 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prc_cgo_tp_cd} != '')" ).append("\n"); 
		query.append("AND	NVL(A.PRC_CGO_TP_CD, 'NULL') IN (@[prc_cgo_tp_cd], 'NULL')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scg_imdg_clss_cd} != '')" ).append("\n"); 
		query.append("AND NVL(A.SCG_IMDG_CLSS_CD, 'NULL') IN (@[scg_imdg_clss_cd], 'NULL')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rat_ut_cd} != '')" ).append("\n"); 
		query.append("AND A.RAT_UT_CD IN (" ).append("\n"); 
		query.append("					SELECT   @[rat_ut_cd] RAT_UT_CD FROM DUAL" ).append("\n"); 
		query.append("#if (${is_num} == 'Y')" ).append("\n"); 
		query.append("					UNION" ).append("\n"); 
		query.append("					SELECT   RAT_UT_CD" ).append("\n"); 
		query.append("					FROM     PRI_RAT_UT" ).append("\n"); 
		query.append("					WHERE    CNTR_SZ_CD = (SELECT   CNTR_SZ_CD" ).append("\n"); 
		query.append("                       					   FROM     PRI_RAT_UT" ).append("\n"); 
		query.append("                       					   WHERE    RAT_UT_CD = @[rat_ut_cd])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("					UNION" ).append("\n"); 
		query.append("					SELECT RAT_UT_CD" ).append("\n"); 
		query.append("					FROM(" ).append("\n"); 
		query.append("						SELECT   RAT_UT_CD, RANK() OVER (ORDER BY RAT_UT_CD) RNUM" ).append("\n"); 
		query.append("						FROM     PRI_RAT_UT" ).append("\n"); 
		query.append("						WHERE    CNTR_SZ_CD = (SELECT   CNTR_SZ_CD" ).append("\n"); 
		query.append("                       					   		FROM     PRI_RAT_UT" ).append("\n"); 
		query.append("                       					  		 WHERE    RAT_UT_CD = @[rat_ut_cd])" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("					WHERE RNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("					UNION ALL" ).append("\n"); 
		query.append("					SELECT   RAT_UT_CD" ).append("\n"); 
		query.append("					FROM     PRI_RAT_UT" ).append("\n"); 
		query.append("					WHERE    CNTR_SZ_CD IS NULL" ).append("\n"); 
		query.append("     				AND (SELECT   CNTR_SZ_CD" ).append("\n"); 
		query.append("          				 FROM     PRI_RAT_UT" ).append("\n"); 
		query.append("          				 WHERE    RAT_UT_CD = @[rat_ut_cd]) IS NOT NULL" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_sz_cd} != '')" ).append("\n"); 
		query.append("AND F.CNTR_SZ_CD = @[cntr_sz_cd]" ).append("\n"); 
		query.append("AND F.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A.RAT_UT_CD = F.RAT_UT_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("AND A.VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${wdr_flg} == '')" ).append("\n"); 
		query.append("AND A.WDR_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${type_cd} == 'L')" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD IN" ).append("\n"); 
		query.append("				(" ).append("\n"); 
		query.append("				SELECT   A.SVC_SCP_CD" ).append("\n"); 
		query.append("				FROM     MDM_SVC_SCP A" ).append("\n"); 
		query.append("        			   ,(SELECT   DISTINCT (B.SVC_SCP_CD) AS SVC_SCP_CD" ).append("\n"); 
		query.append("          				 FROM     MDM_LOCATION A, MDM_SVC_SCP_LMT B" ).append("\n"); 
		query.append("          				 WHERE    A.LOC_CD = @[por_def_cd]" ).append("\n"); 
		query.append("               			 AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("               			 AND B.RGN_CD = A.RGN_CD" ).append("\n"); 
		query.append("               		  	 AND B.ORG_DEST_CD = 'O'" ).append("\n"); 
		query.append("               			 AND B.DELT_FLG = 'N') O" ).append("\n"); 
		query.append("        			   ,(SELECT   DISTINCT (B.SVC_SCP_CD) AS SVC_SCP_CD" ).append("\n"); 
		query.append("          				 FROM     MDM_LOCATION A, MDM_SVC_SCP_LMT B" ).append("\n"); 
		query.append("          				 WHERE    A.LOC_CD = @[del_def_cd]" ).append("\n"); 
		query.append("               			 AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("               			 AND B.RGN_CD = A.RGN_CD" ).append("\n"); 
		query.append("               			 AND B.ORG_DEST_CD = 'D'" ).append("\n"); 
		query.append("               			 AND B.DELT_FLG = 'N') D" ).append("\n"); 
		query.append("				WHERE    A.SVC_SCP_CD = O.SVC_SCP_CD" ).append("\n"); 
		query.append("     			AND O.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append("     			AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("#elseif(${type_cd} == 'R')" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD IN" ).append("\n"); 
		query.append("				(" ).append("\n"); 
		query.append("                SELECT   A.SVC_SCP_CD" ).append("\n"); 
		query.append("                FROM     MDM_SVC_SCP A" ).append("\n"); 
		query.append("                        ,(SELECT   DISTINCT (SVC_SCP_CD) AS SVC_SCP_CD" ).append("\n"); 
		query.append("                          FROM     MDM_SVC_SCP_LMT" ).append("\n"); 
		query.append("                          WHERE    RGN_CD = @[por_def_cd]" ).append("\n"); 
		query.append("                               AND ORG_DEST_CD = 'O'" ).append("\n"); 
		query.append("                               AND DELT_FLG = 'N') O" ).append("\n"); 
		query.append("                        ,(SELECT   DISTINCT (SVC_SCP_CD) AS SVC_SCP_CD" ).append("\n"); 
		query.append("                          FROM     MDM_SVC_SCP_LMT" ).append("\n"); 
		query.append("                          WHERE    RGN_CD = @[del_def_cd]" ).append("\n"); 
		query.append("                               AND ORG_DEST_CD = 'D'" ).append("\n"); 
		query.append("                               AND DELT_FLG = 'N') D" ).append("\n"); 
		query.append("                WHERE    A.SVC_SCP_CD = O.SVC_SCP_CD" ).append("\n"); 
		query.append("                     AND O.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append("                     AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("#elseif (${type_cd} == 'C')" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD IN" ).append("\n"); 
		query.append("				(				" ).append("\n"); 
		query.append("				SELECT   A.SVC_SCP_CD" ).append("\n"); 
		query.append("                FROM     MDM_SVC_SCP A" ).append("\n"); 
		query.append("                        ,(SELECT   DISTINCT (C.SVC_SCP_CD) AS SVC_SCP_CD" ).append("\n"); 
		query.append("                          FROM     MDM_COUNTRY A, MDM_REGION B, MDM_SVC_SCP_LMT C" ).append("\n"); 
		query.append("                          WHERE    A.CNT_CD = @[por_def_cd]" ).append("\n"); 
		query.append("                               AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               AND B.CNT_CD = A.CNT_CD" ).append("\n"); 
		query.append("                               AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               AND C.RGN_CD = B.RGN_CD" ).append("\n"); 
		query.append("                               AND C.ORG_DEST_CD = 'O'" ).append("\n"); 
		query.append("                               AND C.DELT_FLG = 'N') O" ).append("\n"); 
		query.append("                        ,(SELECT   DISTINCT (C.SVC_SCP_CD) AS SVC_SCP_CD" ).append("\n"); 
		query.append("                          FROM     MDM_COUNTRY A, MDM_REGION B, MDM_SVC_SCP_LMT C" ).append("\n"); 
		query.append("                          WHERE    A.CNT_CD = @[del_def_cd]" ).append("\n"); 
		query.append("                               AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               AND B.CNT_CD = A.CNT_CD" ).append("\n"); 
		query.append("                               AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               AND C.RGN_CD = B.RGN_CD" ).append("\n"); 
		query.append("                               AND C.ORG_DEST_CD = 'D'" ).append("\n"); 
		query.append("                               AND C.DELT_FLG = 'N') D" ).append("\n"); 
		query.append("                WHERE    A.SVC_SCP_CD = O.SVC_SCP_CD" ).append("\n"); 
		query.append("                     AND O.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append("                     AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_esvc_tp_cd} != '')" ).append("\n"); 
		query.append("AND NVL(A.BKG_ESVC_TP_CD, 'NULL') IN (@[bkg_esvc_tp_cd], 'NULL')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
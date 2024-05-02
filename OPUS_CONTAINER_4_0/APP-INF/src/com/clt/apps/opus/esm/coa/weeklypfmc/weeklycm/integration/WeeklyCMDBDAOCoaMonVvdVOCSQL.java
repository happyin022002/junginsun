/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WeeklyCMDBDAOCoaMonVvdVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.09
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2011.03.09 전윤주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun-ju Jeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOCoaMonVvdVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *   A: IF Only 일때 COA_MON_VVD Insert
	  * </pre>
	  */
	public WeeklyCMDBDAOCoaMonVvdVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_fm_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_lodg_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOCoaMonVvdVOCSQL").append("\n"); 
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
		query.append("INSERT INTO COA_MON_VVD												" ).append("\n"); 
		query.append("      ( TRD_CD           ,RLANE_CD             ,IOC_CD					 " ).append("\n"); 
		query.append("       ,VSL_CD           ,SKD_VOY_NO           ,DIR_CD					 " ).append("\n"); 
		query.append("       ,VVD_SEQ          ,COST_YRMON           ,COST_WK				 " ).append("\n"); 
		query.append("       ,SLAN_CD														 " ).append("\n"); 
		query.append("       ,LST_LODG_PORT_ETD_DT											 " ).append("\n"); 
		query.append("       ,N1ST_LODG_PORT_ETD_DT											 " ).append("\n"); 
		query.append("       ,LST_LODG_PORT_CD ,BKG_TTL_QTY          ,IOC_RULE_DESC			 " ).append("\n"); 
		query.append("       ,CO_BSA_RTO      ,CHTR_BSA_RTO         ,VVD_BSA_CAPA			 " ).append("\n"); 
		query.append("       ,WKY_TGT_FLG      ,MON_TGT_FLG          ,SUB_TRD_CD				 " ).append("\n"); 
		query.append("       ,DELT_FLG         ,CRE_USR_ID           ,CRE_DT					 " ).append("\n"); 
		query.append("       ,UPD_USR_ID       ,UPD_DT	           ,WKY_MNL_FLG          )	 " ).append("\n"); 
		query.append("SELECT  @[trd_cd]        ,@[rlane_cd]          ,LANE.IOC_CD			 " ).append("\n"); 
		query.append("       ,SKD.VSL_CD       ,SKD.SKD_VOY_NO       ,SKD.SKD_DIR_CD			 " ).append("\n"); 
		query.append("       ,NULL             ,@[f_cost_yr]||@[f_cost_fm_mon] " ).append("\n"); 
		query.append("       ,WK.COST_WK			 " ).append("\n"); 
		query.append("       ,LANE.SLAN_CD				 " ).append("\n"); 
		query.append("       ,SKD.VPS_ETD_DT													 " ).append("\n"); 
		query.append("       ,(SELECT MIN(VPS_ETD_DT)     /* VVD의 최초 출발한 시각	*/		 " ).append("\n"); 
		query.append("           FROM  VSK_VSL_PORT_SKD										 " ).append("\n"); 
		query.append("          WHERE  VSL_CD     = SKD.VSL_CD								 " ).append("\n"); 
		query.append("            AND  SKD_VOY_NO = SKD.SKD_VOY_NO							 " ).append("\n"); 
		query.append("            AND  SKD_DIR_CD = SKD.SKD_DIR_CD							 " ).append("\n"); 
		query.append("            AND  NVL(SKD_CNG_STS_CD,'*') <> 'S')							 " ).append("\n"); 
		query.append("       ,SKD.VPS_PORT_CD  ,0                    ,'IF Only'				 " ).append("\n"); 
		query.append("       ,0                ,0                    ,0                       " ).append("\n"); 
		query.append("       ,'Y'              ,'Y'                  ,LANE.SUB_TRD_CD		 " ).append("\n"); 
		query.append("       ,'N'              ,@[cre_usr_id]		   ,SYSDATE				 " ).append("\n"); 
		query.append("       ,@[upd_usr_id]	 ,SYSDATE	           ,'M'					 " ).append("\n"); 
		query.append("  FROM    (SELECT  VSL_CD     /* VVD의 지정포트의 정보 (여러포트가 나올수 있기때문에 최출출발시각의 포트일시로 지정) */" ).append("\n"); 
		query.append("                  ,SKD_VOY_NO											 " ).append("\n"); 
		query.append("                  ,SKD_DIR_CD											 " ).append("\n"); 
		query.append("                  ,VPS_PORT_CD											 " ).append("\n"); 
		query.append("                  ,VPS_ETD_DT											 " ).append("\n"); 
		query.append("                  ,SKD_CNG_STS_CD											 " ).append("\n"); 
		query.append("             FROM  VSK_VSL_PORT_SKD										 " ).append("\n"); 
		query.append("            WHERE  VSL_CD           = @[vsl_cd]									 " ).append("\n"); 
		query.append("              AND  SKD_VOY_NO       = @[skd_voy_no]								 " ).append("\n"); 
		query.append("              AND  SKD_DIR_CD       = @[dir_cd]									 " ).append("\n"); 
		query.append("              AND  VPS_PORT_CD      = @[lst_lodg_port_cd]									 " ).append("\n"); 
		query.append("              AND  CLPT_IND_SEQ     = (SELECT MIN(CLPT_IND_SEQ)			 " ).append("\n"); 
		query.append("                                         FROM  VSK_VSL_PORT_SKD			 " ).append("\n"); 
		query.append("                                        WHERE  VSL_CD           = @[vsl_cd]	 " ).append("\n"); 
		query.append("                                          AND  SKD_VOY_NO       = @[skd_voy_no]		 " ).append("\n"); 
		query.append("                                          AND  SKD_DIR_CD       = @[dir_cd]	 " ).append("\n"); 
		query.append("                                          AND  VPS_PORT_CD      = @[lst_lodg_port_cd])  ) SKD 			" ).append("\n"); 
		query.append("       ,COA_LANE_RGST    LANE											 " ).append("\n"); 
		query.append("       ,COA_WK_PRD       WK											 " ).append("\n"); 
		query.append("  WHERE LANE.RLANE_CD   = @[rlane_cd]												 " ).append("\n"); 
		query.append("    AND LANE.DIR_CD     = @[dir_cd]												 " ).append("\n"); 
		query.append("    AND LANE.TRD_CD     = @[trd_cd]												 " ).append("\n"); 
		query.append("    AND LANE.IOC_CD     = @[ioc_cd]															" ).append("\n"); 
		query.append("    AND SKD.VSL_CD      = @[vsl_cd]												 " ).append("\n"); 
		query.append("    AND SKD.SKD_VOY_NO  = @[skd_voy_no]												 " ).append("\n"); 
		query.append("    AND SKD.SKD_DIR_CD  = @[dir_cd]												" ).append("\n"); 
		query.append("    AND SKD.VPS_PORT_CD = @[lst_lodg_port_cd]												 " ).append("\n"); 
		query.append("    AND WK.COST_YR      = @[f_cost_yr]								 " ).append("\n"); 
		query.append("    AND TO_CHAR(SKD.VPS_ETD_DT,'YYYYMMDD') BETWEEN SLS_FM_DT AND SLS_TO_DT" ).append("\n"); 
		query.append("    AND NOT EXISTS (SELECT 'Y'											" ).append("\n"); 
		query.append("                      FROM COA_MON_VVD									 " ).append("\n"); 
		query.append("                     WHERE TRD_CD     = @[trd_cd]								 " ).append("\n"); 
		query.append("                       AND RLANE_CD   = @[rlane_cd]								  " ).append("\n"); 
		query.append("                       AND IOC_CD     = @[ioc_cd]											" ).append("\n"); 
		query.append("                       AND VSL_CD     = @[vsl_cd]								 " ).append("\n"); 
		query.append("                       AND SKD_VOY_NO = @[skd_voy_no]								 " ).append("\n"); 
		query.append("                       AND DIR_CD     = @[dir_cd] )" ).append("\n"); 

	}
}
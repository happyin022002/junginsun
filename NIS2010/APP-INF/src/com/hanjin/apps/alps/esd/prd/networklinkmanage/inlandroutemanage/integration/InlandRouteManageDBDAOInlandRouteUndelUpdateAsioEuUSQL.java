/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : InlandRouteManageDBDAOInlandRouteUndelUpdateAsioEuUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.28
*@LastModifier : 
*@LastVersion : 1.0
* 2013.06.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRouteManageDBDAOInlandRouteUndelUpdateAsioEuUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InlandRouteUndelUpdateAsioEu
	  * 유럽조건 죄외
	  *              WHEN (SELECT CONTI_CD FROM MDM_SUBCONTINENT WHERE SCONTI_CD = (SELECT SCONTI_CD FROM MDM_COUNTRY WHERE CNT_CD = SUBSTR(ROUT_ORG_NOD_CD, 1,2)))  <> 'E' THEN 'N'
	  *              WHEN (SELECT CONTI_CD FROM MDM_SUBCONTINENT WHERE SCONTI_CD = (SELECT SCONTI_CD FROM MDM_COUNTRY WHERE CNT_CD = SUBSTR(ROUT_DEST_NOD_CD, 1,2))) <> 'E' THEN 'N'
	  * </pre>
	  */
	public InlandRouteManageDBDAOInlandRouteUndelUpdateAsioEuUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("altn_optm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_chk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_rout_incl_sttl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_rout_optm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_rout_tmp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prio_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration").append("\n"); 
		query.append("FileName : InlandRouteManageDBDAOInlandRouteUndelUpdateAsioEuUSQL").append("\n"); 
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
		query.append("UPDATE prd_inlnd_rout_mst m        " ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("prio_seq = nvl(to_number(@[prio_seq]),0)" ).append("\n"); 
		query.append(", inlnd_rout_bkg_flg = decode(@[bkg_chk],'1','Y','N') " ).append("\n"); 
		query.append(",  delt_flg='N'" ).append("\n"); 
		query.append(", INLND_ROUT_TMP_FLG = decode(@[inlnd_rout_tmp_flg],'1','Y','N')" ).append("\n"); 
		query.append(", INLND_ROUT_INCL_STTL_FLG = decode(@[inlnd_rout_incl_sttl_flg],'1','Y','N')" ).append("\n"); 
		query.append(", INLND_ROUT_OPTM_FLG = CASE WHEN PCTL_IO_BND_CD = 'B' THEN 'N'" ).append("\n"); 
		query.append("             WHEN 0 = (SELECT COUNT(1) FROM PRD_INLND_ROUT_MST T WHERE T.ROUT_ORG_NOD_CD = M.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                        AND T.ROUT_DEST_NOD_CD = M.ROUT_DEST_NOD_CD AND T.PCTL_IO_BND_CD = M.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("                        AND T.ROUT_SEQ <> M.ROUT_SEQ AND NVL(T.DELT_FLG,'N') = 'N' AND ROWNUM = 1)" ).append("\n"); 
		query.append("                 THEN 'Y'" ).append("\n"); 
		query.append("             WHEN @[inlnd_rout_optm_flg] IN ('1', 'Y') THEN 'Y'" ).append("\n"); 
		query.append("             ELSE 'N' END" ).append("\n"); 
		query.append(", altn_optm_flg = " ).append("\n"); 
		query.append("        CASE WHEN PCTL_IO_BND_CD IN ('B', 'M') THEN 'N'" ).append("\n"); 
		query.append("             WHEN SUBSTR(ROUT_ORG_NOD_CD, 1,5) = SUBSTR(ROUT_DEST_NOD_CD, 1,5) -- TERMINAL SHUTTLE DOES NOT ALLOW OPTIMUM" ).append("\n"); 
		query.append("                  AND (SELECT NOD_TP_CD FROM PRD_NODE WHERE NOD_CD = ROUT_ORG_NOD_CD) <> 'Z'" ).append("\n"); 
		query.append("                  AND (SELECT NOD_TP_CD FROM PRD_NODE WHERE NOD_CD = ROUT_DEST_NOD_CD) <> 'Z' THEN 'N' " ).append("\n"); 
		query.append("             WHEN @[altn_optm_flg] IN ('1', 'Y') THEN 'Y'" ).append("\n"); 
		query.append("             ELSE 'N'" ).append("\n"); 
		query.append("        END  " ).append("\n"); 
		query.append(",CRE_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append(", CRE_OFC_CD= @[cre_ofc_cd]" ).append("\n"); 
		query.append(",  CRE_DT = SYSDATE                " ).append("\n"); 
		query.append("WHERE m.rout_org_nod_cd = @[rout_org_nod_cd]       " ).append("\n"); 
		query.append("     AND m.rout_dest_nod_cd = @[rout_dest_nod_cd] " ).append("\n"); 
		query.append("     AND m.rout_seq = @[rout_seq]" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SurchargeGroupCommodityDBDAOPriComGrpCmdtDtlVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.surchargegroupcommodity.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurchargeGroupCommodityDBDAOPriComGrpCmdtDtlVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * commodity detail select
	  * 
	  * * History
	  * 2015.06.19 전지예 [CHM-201536236] [Surcharge Commodity Group Creation] Non-Cargo NOS 체크박스 삽입
	  * 2016.02.04 전지예 [CHM-201640066] TPW Non-Cargo NOS 체크 권한 로직 부여 Request by Hye-In Ahn
	  * </pre>
	  */
	public SurchargeGroupCommodityDBDAOPriComGrpCmdtDtlVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("scg_grp_cmdt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.surcharge.surchargegroupcommodity.integration").append("\n"); 
		query.append("FileName : SurchargeGroupCommodityDBDAOPriComGrpCmdtDtlVORSQL").append("\n"); 
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
		query.append("SELECT A.SVC_SCP_CD" ).append("\n"); 
		query.append("     , A.CHG_CD" ).append("\n"); 
		query.append("     , A.SCG_GRP_CMDT_SEQ" ).append("\n"); 
		query.append("     , A.SCG_GRP_CMDT_DTL_SEQ" ).append("\n"); 
		query.append("     , A.CMDT_CD" ).append("\n"); 
		query.append("     , NON_CGO_NOS_FLG" ).append("\n"); 
		query.append("     , TO_CHAR(A.EFF_DT,'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("     , TO_CHAR(A.EXP_DT,'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append("     , A.CRE_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(A.CRE_DT,'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("     , A.UPD_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(A.UPD_DT,'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("     , NVL(B.CMDT_NM,'') AS CMDT_DES" ).append("\n"); 
		query.append("     , NON_CGO_NOS_AUTH" ).append("\n"); 
		query.append("FROM PRI_SCG_GRP_CMDT_DTL A" ).append("\n"); 
		query.append("   , MDM_COMMODITY B" ).append("\n"); 
		query.append("   , (" ).append("\n"); 
		query.append("        SELECT CASE WHEN MAX(USR_AUTH) = 'Y' AND MAX(OFC_AUTH) = 'Y' THEN 'Y' ELSE 'N' END AS NON_CGO_NOS_AUTH" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("            SELECT 'Y' USR_AUTH, 'N' AS OFC_AUTH" ).append("\n"); 
		query.append("              FROM PRI_AUTHORIZATION" ).append("\n"); 
		query.append("             WHERE PRC_CTRT_TP_CD = 'S'  -- S:S/C" ).append("\n"); 
		query.append("               AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("               AND USR_ID = @[usr_id]" ).append("\n"); 
		query.append("            UNION" ).append("\n"); 
		query.append("            SELECT 'N' USR_AUTH, CASE @[ofc_cd] WHEN 'NYCRA' THEN 'Y' WHEN 'NYCRAS' THEN 'Y' ELSE 'N' END AS OFC_AUTH" ).append("\n"); 
		query.append("              FROM DUAL" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("WHERE A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   A.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("AND   A.SCG_GRP_CMDT_SEQ = @[scg_grp_cmdt_seq]" ).append("\n"); 
		query.append("AND   A.CMDT_CD = B.CMDT_CD(+)" ).append("\n"); 
		query.append("ORDER BY A.CMDT_CD" ).append("\n"); 

	}
}
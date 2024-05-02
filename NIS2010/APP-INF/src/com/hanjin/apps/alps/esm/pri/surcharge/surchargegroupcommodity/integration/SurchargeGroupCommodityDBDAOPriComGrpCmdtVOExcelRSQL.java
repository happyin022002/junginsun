/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SurchargeGroupCommodityDBDAOPriComGrpCmdtVOExcelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.19 
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

public class SurchargeGroupCommodityDBDAOPriComGrpCmdtVOExcelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 전체 GroupCommodity 엑셀 조회
	  * 
	  * * History
	  * 2015.06.19 전지예 [CHM-201536236] [Surcharge Commodity Group Creation] Non-Cargo NOS 체크박스 삽입
	  * </pre>
	  */
	public SurchargeGroupCommodityDBDAOPriComGrpCmdtVOExcelRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.surcharge.surchargegroupcommodity.integration").append("\n"); 
		query.append("FileName : SurchargeGroupCommodityDBDAOPriComGrpCmdtVOExcelRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	A1.SVC_SCP_CD" ).append("\n"); 
		query.append(",	A1.CHG_CD" ).append("\n"); 
		query.append(",	A1.SCG_GRP_CMDT_SEQ" ).append("\n"); 
		query.append(",	A1.SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append(",	A1.SCG_GRP_CMDT_DESC" ).append("\n"); 
		query.append(",	A1.DELT_FLG" ).append("\n"); 
		query.append("--,	A1.CRE_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(A1.CRE_DT,'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("--,   A1.UPD_USR_ID" ).append("\n"); 
		query.append("--,	TO_CHAR(A1.UPD_DT,'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("--,   B1.SVC_SCP_CD" ).append("\n"); 
		query.append("--,   B1.CHG_CD" ).append("\n"); 
		query.append("--,   B1.SCG_GRP_CMDT_SEQ" ).append("\n"); 
		query.append("--,   B1.SCG_GRP_CMDT_DTL_SEQ" ).append("\n"); 
		query.append(",   B1.CMDT_CD" ).append("\n"); 
		query.append(",   B1.NON_CGO_NOS_FLG" ).append("\n"); 
		query.append(",   B1.EFF_DT" ).append("\n"); 
		query.append("--,   B1.EXP_DT" ).append("\n"); 
		query.append("--,   B1.CRE_USR_ID" ).append("\n"); 
		query.append("--,   B1.CRE_DT" ).append("\n"); 
		query.append("--,   B1.UPD_USR_ID" ).append("\n"); 
		query.append(",   B1.UPD_DT" ).append("\n"); 
		query.append(",   B1.CMDT_DES" ).append("\n"); 
		query.append("FROM PRI_SCG_GRP_CMDT A1," ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("      SELECT" ).append("\n"); 
		query.append("             A.SVC_SCP_CD" ).append("\n"); 
		query.append("        ,    A.CHG_CD" ).append("\n"); 
		query.append("        ,    A.SCG_GRP_CMDT_SEQ" ).append("\n"); 
		query.append("        ,    A.SCG_GRP_CMDT_DTL_SEQ" ).append("\n"); 
		query.append("        ,    A.CMDT_CD" ).append("\n"); 
		query.append("        ,    NON_CGO_NOS_FLG" ).append("\n"); 
		query.append("        ,    TO_CHAR(A.EFF_DT,'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("        ,    TO_CHAR(A.EXP_DT,'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append("        ,    A.CRE_USR_ID" ).append("\n"); 
		query.append("        ,    TO_CHAR(A.CRE_DT,'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("        ,    A.UPD_USR_ID" ).append("\n"); 
		query.append("        ,    TO_CHAR(A.UPD_DT,'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("        ,   NVL(B.CMDT_NM,'') AS CMDT_DES" ).append("\n"); 
		query.append("        FROM PRI_SCG_GRP_CMDT_DTL A," ).append("\n"); 
		query.append("             MDM_COMMODITY B" ).append("\n"); 
		query.append("        WHERE A.CMDT_CD = B.CMDT_CD(+)" ).append("\n"); 
		query.append("     ) B1" ).append("\n"); 
		query.append("WHERE	1=1" ).append("\n"); 
		query.append("AND     A1.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND	    A1.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("--AND     A1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND     A1.SVC_SCP_CD = B1.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND	    A1.CHG_CD = B1.CHG_CD(+)" ).append("\n"); 
		query.append("AND     A1.SCG_GRP_CMDT_SEQ = B1.SCG_GRP_CMDT_SEQ(+)" ).append("\n"); 
		query.append("ORDER BY A1.SCG_GRP_CMDT_CD, B1.CHG_CD" ).append("\n"); 

	}
}
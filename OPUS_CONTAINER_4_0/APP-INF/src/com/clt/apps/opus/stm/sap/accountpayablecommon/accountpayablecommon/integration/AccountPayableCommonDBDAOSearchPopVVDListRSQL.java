/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountPayableCommonDBDAOSearchPopVVDListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableCommonDBDAOSearchPopVVDListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조건을 기준으로 재무 항차에 등록된 VVD 정보 조회
	  * </pre>
	  */
	public AccountPayableCommonDBDAOSearchPopVVDListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOSearchPopVVDListRSQL").append("\n"); 
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
		query.append("SELECT  VVD_CD, VVD_DESC" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT VSL_CD || SKD_VOY_NO || SKD_DIR_CD || RLANE_DIR_CD AS VVD_CD," ).append("\n"); 
		query.append("               REV_YRMON || SLAN_CD || REV_PORT_CD AS VVD_DESC" ).append("\n"); 
		query.append("        FROM   AR_MST_REV_VVD" ).append("\n"); 
		query.append("#if (${vvd_type} == 'ACT')" ).append("\n"); 
		query.append("    #if (${acct_cd} != '')  " ).append("\n"); 
		query.append("        WHERE  COM_VVD_FLG <> 'Y'" ).append("\n"); 
		query.append("        AND    NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("        UNION  ALL" ).append("\n"); 
		query.append("        SELECT VSL_CD || SKD_VOY_NO || SKD_DIR_CD || RLANE_DIR_CD AS VVD_CD," ).append("\n"); 
		query.append("               REV_YRMON || SLAN_CD || REV_PORT_CD AS VVD_DESC" ).append("\n"); 
		query.append("        FROM   AR_MST_REV_VVD" ).append("\n"); 
		query.append("        WHERE  COM_VVD_FLG IN (CASE WHEN (SELECT  COUNT(SLD.LU_CD) AS ACCT_CNT FROM SCO_LU_HDR SLH, SCO_LU_DTL SLD" ).append("\n"); 
		query.append("                                          WHERE   SLH.LU_TP_CD = SLD.LU_TP_CD AND SLH.LU_TP_CD = 'COMMON VVD ACCOUNT'" ).append("\n"); 
		query.append("                                          AND     NVL(SLD.ENBL_FLG, 'Y') = 'Y' AND NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE" ).append("\n"); 
		query.append("                                          AND     SLH.LU_APPL_CD = 'SAP' AND SLD.LU_CD = @[acct_cd]) >= 1 THEN  'Y' END)" ).append("\n"); 
		query.append("        AND    NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("    #else   " ).append("\n"); 
		query.append("        WHERE  COM_VVD_FLG <> 'Y'" ).append("\n"); 
		query.append("        AND    NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        WHERE  NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  SLD.lU_CD       AS VVD_CD" ).append("\n"); 
		query.append("              , SLD.LU_DESC     AS VVD_DESC" ).append("\n"); 
		query.append("        FROM    SCO_LU_HDR SLH" ).append("\n"); 
		query.append("              , SCO_LU_DTL SLD" ).append("\n"); 
		query.append("        WHERE   SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("        AND     SLH.LU_TP_CD = 'GL VVD'" ).append("\n"); 
		query.append("        AND     NVL(SLD.ENBL_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("        AND     NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE" ).append("\n"); 
		query.append("        AND     SLH.LU_APPL_CD = 'SCO'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("  AND UPPER(VVD_CD) LIKE UPPER(@[vvd_cd]) || '%'  " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
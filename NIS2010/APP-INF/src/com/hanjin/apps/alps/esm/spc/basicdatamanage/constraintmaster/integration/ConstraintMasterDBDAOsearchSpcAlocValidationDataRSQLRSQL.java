/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ConstraintMasterDBDAOsearchSpcAlocValidationDataRSQLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintMasterDBDAOsearchSpcAlocValidationDataRSQLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 시트 입력값 체크
	  * </pre>
	  */
	public ConstraintMasterDBDAOsearchSpcAlocValidationDataRSQLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("val_value",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("val_value2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("val_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration").append("\n"); 
		query.append("FileName : ConstraintMasterDBDAOsearchSpcAlocValidationDataRSQLRSQL").append("\n"); 
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
		query.append("#if (${val_type} == 'CARRIER NAME') " ).append("\n"); 
		query.append(" SELECT CRR_CD AS LOC_CD" ).append("\n"); 
		query.append("       ,CRR_NM " ).append("\n"); 
		query.append("    FROM MDM_CARRIER" ).append("\n"); 
		query.append("    WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${crr_cd} != '') " ).append("\n"); 
		query.append("    AND UPPER(CRR_CD) = UPPER(@[crr_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${crr_nm} != '') " ).append("\n"); 
		query.append("    AND UPPER(CRR_NM) LIKE UPPER('%'||@[crr_nm]||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("SELECT SUM(VAL_CNT) VAL_CNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT  COUNT(*) VAL_CNT" ).append("\n"); 
		query.append("    FROM    MDM_VSL_SVC_LANE_DIR" ).append("\n"); 
		query.append("    WHERE   VSL_SLAN_CD = @[val_value]" ).append("\n"); 
		query.append("    AND     DELT_FLG    = 'N' " ).append("\n"); 
		query.append("    AND     'LANE' = @[val_type]" ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("    SELECT  COUNT(*)" ).append("\n"); 
		query.append("    FROM    MDM_VSL_SVC_LANE_DIR" ).append("\n"); 
		query.append("    WHERE   VSL_SLAN_DIR_CD = @[val_value]" ).append("\n"); 
		query.append("    AND     DELT_FLG    = 'N'   " ).append("\n"); 
		query.append("    AND     'BOUND' = @[val_type]" ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("    SELECT  COUNT(*)" ).append("\n"); 
		query.append("    FROM    MDM_COMMODITY" ).append("\n"); 
		query.append("    WHERE   CMDT_CD = TRIM(TO_CHAR(@[val_value],'000000')) " ).append("\n"); 
		query.append("    AND     DELT_FLG    = 'N'  " ).append("\n"); 
		query.append("    AND     'COMMODITY' = @[val_type]" ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("    SELECT  COUNT(*)" ).append("\n"); 
		query.append("    FROM    PRI_SCG_GRP_CMDT PSC" ).append("\n"); 
		query.append("    WHERE   PSC.SVC_SCP_CD = 'TPW'" ).append("\n"); 
		query.append("    AND     PSC.CHG_CD = 'GRI'" ).append("\n"); 
		query.append("    AND     PSC.SCG_GRP_CMDT_SEQ = @[val_value]" ).append("\n"); 
		query.append("    AND     'GRP_COMMODITY' = @[val_type]" ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) " ).append("\n"); 
		query.append("    FROM PRI_SP_HDR HD, PRI_SP_MN MN" ).append("\n"); 
		query.append("    WHERE HD.SC_NO =@[val_value] /* SC_NO */" ).append("\n"); 
		query.append("    AND HD.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("    AND MN.PROP_STS_CD ='F'" ).append("\n"); 
		query.append("    AND 'SC NO' = @[val_type]" ).append("\n"); 
		query.append("    AND MN.AMDT_SEQ IN " ).append("\n"); 
		query.append("    		( SELECT AMDT_SEQ FROM PRI_SP_MN K WHERE K.PROP_NO = MN.PROP_NO AND PROP_STS_CD ='F')" ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*)" ).append("\n"); 
		query.append("    FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("    WHERE DELT_FLG='N'" ).append("\n"); 
		query.append("    AND CNTR_TPSZ_CD = DECODE(@[val_value],'ALL',CNTR_TPSZ_CD,@[val_value])" ).append("\n"); 
		query.append("    AND 'CNTR TPSZ' = @[val_type]" ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*)" ).append("\n"); 
		query.append("    FROM MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("    WHERE CUST_CNT_CD = SUBSTR(@[val_value],1,2)" ).append("\n"); 
		query.append("    AND CUST_SEQ = SUBSTR(@[val_value],3)" ).append("\n"); 
		query.append("    AND NVL(NMD_CUST_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("    AND CNTR_DIV_FLG = 'Y'" ).append("\n"); 
		query.append("    AND 'CUSTOMER' = @[val_type]" ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*)" ).append("\n"); 
		query.append("    FROM MDM_CUST_PERF_GRP" ).append("\n"); 
		query.append("    WHERE CUST_GRP_ID = @[val_value]" ).append("\n"); 
		query.append("    AND NVL(DELT_FLG , 'N') = 'N'" ).append("\n"); 
		query.append("    AND 'CUST_GRP_ID' = @[val_type]" ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*)" ).append("\n"); 
		query.append("    FROM MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("    WHERE CUST_CNT_CD = SUBSTR(@[val_value],1,2)" ).append("\n"); 
		query.append("    AND CUST_SEQ = SUBSTR(@[val_value],3)" ).append("\n"); 
		query.append("    AND NVL(NMD_CUST_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("    AND CNTR_DIV_FLG = 'Y'" ).append("\n"); 
		query.append("	AND NVL(CUST_GRP_ID,'*') = NVL(@[val_value2],NVL(CUST_GRP_ID,'*'))" ).append("\n"); 
		query.append("    AND 'CUSTOMER_GRP' = @[val_type]" ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*)" ).append("\n"); 
		query.append("    FROM MDM_LOCATION" ).append("\n"); 
		query.append("    WHERE DELT_FLG='N'" ).append("\n"); 
		query.append("    AND LOC_CD = @[val_value]" ).append("\n"); 
		query.append("    AND ('Location' = @[val_type] OR 'Location/Node' = @[val_type])  " ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*)" ).append("\n"); 
		query.append("    FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("    WHERE DELT_FLG='N'" ).append("\n"); 
		query.append("    AND SCC_CD = @[val_value]" ).append("\n"); 
		query.append("    AND 'SCC' = @[val_type]" ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*)" ).append("\n"); 
		query.append("    FROM MDM_YARD " ).append("\n"); 
		query.append("    WHERE YD_CD = @[val_value]" ).append("\n"); 
		query.append("    AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("    AND ('NODE' = @[val_type] OR 'Location/Node' = @[val_type])" ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*)" ).append("\n"); 
		query.append("    FROM PRI_RP_HDR " ).append("\n"); 
		query.append("    WHERE RFA_NO = @[val_value]" ).append("\n"); 
		query.append("    AND  'RFA NO' = @[val_type]" ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*)" ).append("\n"); 
		query.append("    FROM MDM_COUNTRY MC" ).append("\n"); 
		query.append("    WHERE MC.CNT_CD = @[val_value]" ).append("\n"); 
		query.append("    AND MC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("    AND 'CNT' = @[val_type]" ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*)" ).append("\n"); 
		query.append("    FROM MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("    WHERE CUST_CNT_CD = SUBSTR(@[val_value],1,2)" ).append("\n"); 
		query.append("    AND CUST_SEQ = SUBSTR(@[val_value],3)" ).append("\n"); 
		query.append("    AND NVL(NMD_CUST_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("    AND CNTR_DIV_FLG = 'Y'" ).append("\n"); 
		query.append("    AND 'Actual_Customer' = @[val_type]" ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("	SELECT COUNT(*)" ).append("\n"); 
		query.append("	  FROM MAS_LANE_RGST " ).append("\n"); 
		query.append("	 WHERE TRD_CD = CASE  " ).append("\n"); 
		query.append("	               	WHEN null IS NULL AND @[val_value] IS NULL " ).append("\n"); 
		query.append("    	             THEN '' " ).append("\n"); 
		query.append("  	                WHEN null IS NULL AND @[val_value] IS NOT NULL " ).append("\n"); 
		query.append("                     THEN TRD_CD " ).append("\n"); 
		query.append("  	                ELSE null" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("       AND SUB_TRD_CD = NVL(@[val_value],SUB_TRD_CD) " ).append("\n"); 
		query.append("       AND NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*)" ).append("\n"); 
		query.append("    FROM MDM_CARRIER" ).append("\n"); 
		query.append("    WHERE DELT_FLG= 'N'" ).append("\n"); 
		query.append("    AND CRR_CD = @[val_value]" ).append("\n"); 
		query.append("    AND 'CARRIER' = @[val_type]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
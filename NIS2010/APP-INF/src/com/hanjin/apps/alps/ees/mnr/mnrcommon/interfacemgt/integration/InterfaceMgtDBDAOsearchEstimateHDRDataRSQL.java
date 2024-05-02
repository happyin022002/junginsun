/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : InterfaceMgtDBDAOsearchEstimateHDRDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOsearchEstimateHDRDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InterfaceMgtDBDAOsearchEstimateHDRDataRSQL
	  * </pre>
	  */
	public InterfaceMgtDBDAOsearchEstimateHDRDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_ord_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_ord_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOsearchEstimateHDRDataRSQL").append("\n"); 
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
		query.append("SELECT   RPAD(MAX((" ).append("\n"); 
		query.append("                    SELECT   DECODE(CSAG.SYS_AREA_GRP_ID, 'CHN', 'CNSHASMCA'" ).append("\n"); 
		query.append("                                                        , 'SWA', 'SGSINSMCA'" ).append("\n"); 
		query.append("                                                        , 'EUR', 'DEHAMSMCA'" ).append("\n"); 
		query.append("                                                        , 'USA', 'USEWRSMCB'" ).append("\n"); 
		query.append("                                                        , 'KRSELSMCA'" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("                    FROM     MDM_ORGANIZATION MO, COM_SYS_AREA_GRP_ID CSAG" ).append("\n"); 
		query.append("                    WHERE    1 = 1" ).append("\n"); 
		query.append("                    AND      A.COST_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("                    AND      SUBSTR(MO.LOC_CD, 1, 2) = CSAG.CNT_CD" ).append("\n"); 
		query.append("                    AND      CSAG.CO_IND_CD = 'H'" ).append("\n"); 
		query.append("                    AND      ROWNUM = 1" ).append("\n"); 
		query.append("         )), 20, ' ')" ).append("\n"); 
		query.append("         || RPAD(@[edi_id], 20, ' ')" ).append("\n"); 
		query.append("         || 'WORDER    '" ).append("\n"); 
		query.append("         || RPAD(MAX((" ).append("\n"); 
		query.append("                    SELECT   CSAG.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                    FROM     MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                           , COM_SYS_AREA_GRP_ID CSAG" ).append("\n"); 
		query.append("                    WHERE    1 = 1" ).append("\n"); 
		query.append("                    AND      A.COST_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("                    AND      SUBSTR(MO.LOC_CD, 1, 2) = CSAG.CNT_CD" ).append("\n"); 
		query.append("                    AND      CSAG.CO_IND_CD = 'H'" ).append("\n"); 
		query.append("                    AND      ROWNUM = 1" ).append("\n"); 
		query.append("            ))" ).append("\n"); 
		query.append("         || TO_CHAR(SYSDATE, 'YYMMDD')||ROUND(DBMS_RANDOM.VALUE(1111, 9999), 0), 20, ' ') AS MSG_ID" ).append("\n"); 
		query.append("       , MAX(A.MNR_ORD_OFC_CTY_CD||A.MNR_ORD_SEQ) AS ORD_NO" ).append("\n"); 
		query.append("       , A.RPR_RQST_VER_NO AS MSG_RVS_NO" ).append("\n"); 
		query.append("       , MAX(A.RQST_REF_NO) AS REF_NO" ).append("\n"); 
		query.append("       , MAX(A.EQ_KND_CD) AS EQ_TYPE" ).append("\n"); 
		query.append("       , MAX(SUBSTR(A.RQST_EQ_NO, 1, 4)) AS EQ_PREFIX" ).append("\n"); 
		query.append("       , MAX(SUBSTR(A.RQST_EQ_NO, 5)) AS EQ_NO" ).append("\n"); 
		query.append("       , MAX(A.COST_OFC_CD) AS HJS_OFC_CD" ).append("\n"); 
		query.append("       , @[user_nm] AS AUTH_SENDOR" ).append("\n"); 
		query.append("       , @[edi_id] AS VENDOR_EDI_ADDR" ).append("\n"); 
		query.append("       , '' AS SPCF_RECPT" ).append("\n"); 
		query.append("       , TO_CHAR(SYSDATE, 'YYYYMMDD') AS ACT_TRANS_DT" ).append("\n"); 
		query.append("       , MAX(TO_CHAR(A.RQST_DT, 'YYYYMMDD')) AS ORD_DT" ).append("\n"); 
		query.append("       , MAX(MNR_COMMON_PKG.MNR_CONV_TPSZ_FNC(A.EQ_KND_CD, A.EQ_TPSZ_CD)) AS EQ_TPSZ" ).append("\n"); 
		query.append("       , MAX(A.CURR_CD) AS CUR_CD" ).append("\n"); 
		query.append("       , SUM(B.LBR_COST_AMT) AS LAB_TOT" ).append("\n"); 
		query.append("       , SUM(B.MTRL_COST_AMT) AS MAT_TOT" ).append("\n"); 
		query.append("       , 0 AS HAN_TOT" ).append("\n"); 
		query.append("       , 0 AS TAX" ).append("\n"); 
		query.append("       , MAX(A.MNR_WRK_AMT) AS TOT_INV_AMT" ).append("\n"); 
		query.append("       , @[edi_id] AS EDI_ID" ).append("\n"); 
		query.append("       , REPLACE(MAX(A.MNR_RPR_RMK), CHR(13)||CHR(10), ' ') AS REMARK" ).append("\n"); 
		query.append("       , MAX(A.MNR_WRK_AMT) AS ORD_GRND_TOT" ).append("\n"); 
		query.append("       , '' AS DPP_CUR" ).append("\n"); 
		query.append("       , '' AS DPP" ).append("\n"); 
		query.append("FROM     MNR_RPR_RQST_HDR A" ).append("\n"); 
		query.append("       , MNR_RPR_RQST_DTL B" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      A.RQST_EQ_NO = B.RQST_EQ_NO" ).append("\n"); 
		query.append("AND      A.RPR_RQST_SEQ = B.RPR_RQST_SEQ" ).append("\n"); 
		query.append("AND      A.RPR_RQST_VER_NO = B.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("AND      A.RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("AND      A.MNR_ORD_OFC_CTY_CD = @[mnr_ord_ofc_cty_cd]" ).append("\n"); 
		query.append("AND      A.MNR_ORD_SEQ = @[mnr_ord_seq]" ).append("\n"); 
		query.append("GROUP BY A.RQST_EQ_NO" ).append("\n"); 
		query.append("       , A.RPR_RQST_SEQ" ).append("\n"); 
		query.append("       , A.RPR_RQST_VER_NO" ).append("\n"); 

	}
}
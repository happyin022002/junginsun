/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpaceControlInquiryDBDAOSearchSpaceControlInquiryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceControlInquiryDBDAOSearchSpaceControlInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Allocation History
	  * 2016.05.12 SPC_GET_HC_RT_BSA_FNC : SKD_VOY_NO parm 추가
	  * </pre>
	  */
	public SpaceControlInquiryDBDAOSearchSpaceControlInquiryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnl_aloc_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sales_office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpaceControlInquiryDBDAOSearchSpaceControlInquiryListRSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT * FROM (" ).append("\n"); 
		query.append("SELECT TO_CHAR(A.ALOC_GDT, 'YYYY-MM-DD HH24:MI:SS')          AS ALOC_GDT," ).append("\n"); 
		query.append("         DECODE(B.USR_NM, '', '*'||A.ALOC_USR_ID, B.USR_NM) AS USER_NM ," ).append("\n"); 
		query.append("         A.SLS_OFC_CD AS SLS_OFC_CD," ).append("\n"); 
		query.append("         DECODE(A.POL_YD_CD, '0000000', '+', A.POL_YD_CD)   AS POL_YD_CD," ).append("\n"); 
		query.append("         DECODE(A.POD_YD_CD, '0000000', DECODE(A.POL_YD_CD, '0000000', '+', DECODE(A.POD_YD_CD, '0000000', '+', A.POD_YD_CD)), A.POD_YD_CD) AS POD_YD_CD," ).append("\n"); 
		query.append("         A.ALOC_LOD_QTY        AS ALOC_LOD_QTY       ," ).append("\n"); 
		query.append("         A.ALOC_40FT_HC_QTY    AS ALOC_40FT_HC_QTY   ," ).append("\n"); 
		query.append("         A.ALOC_45FT_HC_QTY    AS ALOC_45FT_HC_QTY   ," ).append("\n"); 
		query.append("         A.ALOC_53FT_QTY       AS ALOC_53FT_QTY      ," ).append("\n"); 
		query.append("         A.ALOC_RF_QTY         AS ALOC_RF_QTY        ," ).append("\n"); 
		query.append("         A.ALOC_TTL_WGT        AS ALOC_TTL_WGT       ," ).append("\n"); 
		query.append("         NVL(A.FCAST_TTL_QTY, 0) + NVL(A.FCAST_40FT_HC_QTY, 0) * SPC_GET_HC_RT_BSA_FNC(A.TRD_CD ,A.RLANE_CD ,A.SKD_DIR_CD ,A.VSL_CD , A.SKD_VOY_NO, 'D5') + NVL(A.FCAST_45FT_HC_QTY, 0) * SPC_GET_HC_RT_BSA_FNC(A.TRD_CD ,A.RLANE_CD ,A.SKD_DIR_CD ,A.VSL_CD , A.SKD_VOY_NO, 'D7') + NVL(A.FCAST_53FT_QTY, 0) * 2 AS FCAST_TTL_TEU_QTY," ).append("\n"); 
		query.append("         A.FCAST_TTL_QTY       AS FCAST_TTL_QTY      ," ).append("\n"); 
		query.append("         A.FCAST_40FT_HC_QTY   AS FCAST_40FT_HC_QTY  ," ).append("\n"); 
		query.append("         A.FCAST_45FT_HC_QTY   AS FCAST_45FT_HC_QTY  ," ).append("\n"); 
		query.append("         A.FCAST_53FT_QTY      AS FCAST_53FT_QTY     ," ).append("\n"); 
		query.append("         A.FCAST_RF_QTY        AS FCAST_RF_QTY       ," ).append("\n"); 
		query.append("         A.FCAST_TTL_WGT       AS FCAST_TTL_WGT      ," ).append("\n"); 
		query.append("         A.USD_BKG_TTL_QTY     AS USD_BKG_TTL_QTY    ," ).append("\n"); 
		query.append("         A.USD_BKG_20FT_QTY    AS USD_BKG_20FT_QTY   ," ).append("\n"); 
		query.append("         A.USD_BKG_40FT_QTY    AS USD_BKG_40FT_QTY   ," ).append("\n"); 
		query.append("         A.USD_BKG_40FT_HC_QTY AS USD_BKG_40FT_HC_QTY," ).append("\n"); 
		query.append("         A.USD_BKG_45FT_HC_QTY AS USD_BKG_45FT_HC_QTY," ).append("\n"); 
		query.append("         A.USD_BKG_53FT_QTY    AS USD_BKG_53FT_QTY   ," ).append("\n"); 
		query.append("         A.USD_BKG_RF_QTY      AS USD_BKG_RF_QTY     ," ).append("\n"); 
		query.append("         A.USD_BKG_TTL_WGT     AS USD_BKG_TTL_WGT    ," ).append("\n"); 
		query.append("         DECODE(A.POL_YD_CD, '0000000', DECODE(A.POD_YD_CD, '0000000', 1, 2), DECODE(A.POD_YD_CD, '0000000', 2, 3)) AS LVL " ).append("\n"); 
		query.append("    FROM SPC_ALOC_HIS A," ).append("\n"); 
		query.append("         COM_USER     B" ).append("\n"); 
		query.append("   WHERE A.VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("     AND A.SKD_VOY_NO   = @[skd_voy_no]" ).append("\n"); 
		query.append("     AND A.SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ioc} == 'NYCHQ')" ).append("\n"); 
		query.append("     AND A.IOC_TS_CD    = 'T'" ).append("\n"); 
		query.append("     AND A.SLS_RHQ_CD = 'NYCHQ' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ioc} == 'LONHQ')" ).append("\n"); 
		query.append("     AND A.IOC_TS_CD    = 'T'" ).append("\n"); 
		query.append("     AND A.SLS_RHQ_CD = 'LONHQ' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ioc} == 'I' || ${ioc} == 'O' || ${ioc} == 'T')" ).append("\n"); 
		query.append("     AND A.IOC_TS_CD    = @[ioc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cond1} == 'TRUE')" ).append("\n"); 
		query.append("     AND A.SLS_OFC_CD   = @[sales_office]" ).append("\n"); 
		query.append("     AND A.MNL_ALOC_RMK = @[mnl_aloc_rmk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("#if (${cond2} == 'TRUE')" ).append("\n"); 
		query.append("     AND A.SLS_OFC_CD   = @[sub_office]" ).append("\n"); 
		query.append("     AND A.MNL_ALOC_RMK = @[mnl_aloc_rmk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cond3} == 'TRUE')" ).append("\n"); 
		query.append("     AND A.SLS_OFC_CD   = @[sub_office]" ).append("\n"); 
		query.append("     AND A.MNL_ALOC_RMK = @[mnl_aloc_rmk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     AND A.ALOC_USR_ID  = B.USR_ID(+))" ).append("\n"); 
		query.append("ORDER BY ALOC_GDT DESC," ).append("\n"); 
		query.append("         POL_YD_CD    ," ).append("\n"); 
		query.append("         POD_YD_CD" ).append("\n"); 

	}
}
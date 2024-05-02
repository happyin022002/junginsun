/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisMovementHistoryDBDAOsearchCHSMovementHistoryDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMovementHistoryDBDAOsearchCHSMovementHistoryDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChassisMovementHistoryDBDAOsearchCHSMovementHistoryDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("str_mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.integration").append("\n"); 
		query.append("FileName : ChassisMovementHistoryDBDAOsearchCHSMovementHistoryDataRSQL").append("\n"); 
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
		query.append("SELECT AAA.*" ).append("\n"); 
		query.append("  FROM (SELECT ROWNUM AS NO, AA.*" ).append("\n"); 
		query.append("          FROM (SELECT B.MVMT_STS_CD," ).append("\n"); 
		query.append("                       TO_CHAR(B.MVMT_DT, 'YYYY-MM-DD HH24:MI') MVMT_DT," ).append("\n"); 
		query.append("                       B.YD_CD," ).append("\n"); 
		query.append("                       B.DEST_YD_CD," ).append("\n"); 
		query.append("                       B.CNTR_NO," ).append("\n"); 
		query.append("                       DECODE(I.CNTR_NO, NULL, DECODE(B.CHSS_OWNR_CO_CD, 'H', 'OWN', 'OTHER'), COM_CONSTANTMGR_PKG.COM_GETCOMPANYCODE_FNC()) CNTR_OWNR_CO_CD," ).append("\n"); 
		query.append("                       B.DIFF_RMK," ).append("\n"); 
		query.append("                       TO_CHAR(B.CRE_DT, 'YYYY-MM-DD HH24:MI') CRE_DT," ).append("\n"); 
		query.append("                       B.CRE_USR_ID," ).append("\n"); 
		query.append("                       C.OFC_CD CRE_OFC_CD," ).append("\n"); 
		query.append("                       C.USR_NM CRE_USR_NM," ).append("\n"); 
		query.append("                       TO_CHAR(B.UPD_DT, 'YYYY-MM-DD HH24:MI') UPD_DT," ).append("\n"); 
		query.append("                       B.UPD_USR_ID," ).append("\n"); 
		query.append("                       D.OFC_CD UPD_OFC_CD," ).append("\n"); 
		query.append("                       D.USR_NM UPD_USR_NM," ).append("\n"); 
		query.append("                       B.VNDR_SEQ," ).append("\n"); 
		query.append("                       E.VNDR_ABBR_NM," ).append("\n"); 
		query.append("                       B.MGST_NO MG_SET_NO," ).append("\n"); 
		query.append("                       B.CNMV_YR," ).append("\n"); 
		query.append("                       B.CNMV_ID_NO" ).append("\n"); 
		query.append("                  FROM CGM_EQUIPMENT A," ).append("\n"); 
		query.append("                       CGM_CHSS_MVMT_HIS B," ).append("\n"); 
		query.append("                       COM_USER C," ).append("\n"); 
		query.append("                       COM_USER D," ).append("\n"); 
		query.append("                       MDM_VENDOR E," ).append("\n"); 
		query.append("                       MST_CONTAINER I" ).append("\n"); 
		query.append("                 WHERE A.EQ_KND_CD='Z'" ).append("\n"); 
		query.append("                   AND A.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("                   AND A.EQ_NO = B.CHSS_NO" ).append("\n"); 
		query.append("                   AND B.CNTR_NO = I.CNTR_NO(+)" ).append("\n"); 
		query.append("                   AND B.CRE_USR_ID = C.USR_ID(+)" ).append("\n"); 
		query.append("                   AND B.UPD_USR_ID = D.USR_ID(+)" ).append("\n"); 
		query.append("                   AND B.VNDR_SEQ = E.VNDR_SEQ (+) " ).append("\n"); 
		query.append("#if ( ${str_mvmt_dt} != '' )" ).append("\n"); 
		query.append("                   AND B.MVMT_DT BETWEEN TO_DATE(@[str_mvmt_dt], 'YYYY-MM-DD') AND TO_DATE(@[end_mvmt_dt], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT 'CCM' MVMT_STS_CD," ).append("\n"); 
		query.append("                       TO_CHAR(H.MVMT_DT, 'YYYY-MM-DD HH24:MI') MVMT_DT," ).append("\n"); 
		query.append("                       H.YD_CD," ).append("\n"); 
		query.append("                       '' DEST_YD_CD," ).append("\n"); 
		query.append("                       H.CNTR_NO," ).append("\n"); 
		query.append("                       H.CHSS_USE_CO_NM CNTR_OWNR_CO_CD," ).append("\n"); 
		query.append("                       DECODE(H.CNTR_NO, NULL, H.VNDR_NM, H.VNDR_NM || ' ~ ' || H.CNTR_NO) DIFF_RMK," ).append("\n"); 
		query.append("                       TO_CHAR(H.CRE_DT, 'YYYY-MM-DD HH24:MI') CRE_DT," ).append("\n"); 
		query.append("                       H.CRE_USR_ID," ).append("\n"); 
		query.append("                       SUBSTR(H.CHSS_POOL_CD, 1, 6) CRE_OFC_CD," ).append("\n"); 
		query.append("                       (SELECT CHSS_POOL_NM FROM CGM_CHSS_POOL WHERE CHSS_POOL_CD = H.CHSS_POOL_CD) CRE_USR_NM," ).append("\n"); 
		query.append("                       TO_CHAR(H.UPD_DT, 'YYYY-MM-DD HH24:MI') UPD_DT," ).append("\n"); 
		query.append("                       H.UPD_USR_ID," ).append("\n"); 
		query.append("                       SUBSTR(H.CHSS_POOL_CD, 1, 6) UPD_OFC_CD," ).append("\n"); 
		query.append("                       (SELECT CHSS_POOL_NM FROM CGM_CHSS_POOL WHERE CHSS_POOL_CD = H.CHSS_POOL_CD) UPD_USR_NM," ).append("\n"); 
		query.append("                       NULL VNDR_SEQ," ).append("\n"); 
		query.append("                       H.VNDR_NM VNDR_ABBR_NM," ).append("\n"); 
		query.append("                       H.MGST_NO MG_SET_NO," ).append("\n"); 
		query.append("                       '' CNMV_YR," ).append("\n"); 
		query.append("                       NULL CNMV_ID_NO" ).append("\n"); 
		query.append("                  FROM CGM_EQUIPMENT A," ).append("\n"); 
		query.append("                       CGM_POOL_MVMT_HIS H" ).append("\n"); 
		query.append("                 WHERE A.EQ_KND_CD='Z'" ).append("\n"); 
		query.append("                   AND A.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("                   AND A.EQ_NO = H.CHSS_NO " ).append("\n"); 
		query.append("#if ( ${str_mvmt_dt} != '' )" ).append("\n"); 
		query.append("                   AND H.MVMT_DT BETWEEN TO_DATE(@[str_mvmt_dt], 'YYYY-MM-DD') AND TO_DATE(@[end_mvmt_dt], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                 ORDER BY MVMT_DT, CNMV_YR, CNMV_ID_NO) AA" ).append("\n"); 
		query.append("                 ) AAA " ).append("\n"); 
		query.append("#if ( ${str_mvmt_dt} == '' )" ).append("\n"); 
		query.append("  WHERE AAA.NO < 301 " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
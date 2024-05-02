/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchJapDorEdiHistoryByTransRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchJapDorEdiHistoryByTransRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchJapDorEdiHistoryByTransRSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flat_file",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("grp_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchJapDorEdiHistoryByTransRSQL").append("\n"); 
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
		query.append("SELECT  BKG_NO                     AS BKG_NO" ).append("\n"); 
		query.append("      ,''                          AS HIS_SEQ" ).append("\n"); 
		query.append("      ,'E'                         AS NTC_VIA_CD" ).append("\n"); 
		query.append("      ,'DO'                        AS NTC_KND_CD" ).append("\n"); 
		query.append("      ,''                          AS CNTR_NO" ).append("\n"); 
		query.append("      ,''                          AS AGN_CD" ).append("\n"); 
		query.append("      ,''                          AS NTC_FOM_CD" ).append("\n"); 
		query.append("      ,''                          AS NTC_SEQ" ).append("\n"); 
		query.append("      ,''                          AS BKG_CUST_TP_CD" ).append("\n"); 
		query.append("      ,''                          AS CUST_CNTC_TP_CD" ).append("\n"); 
		query.append("      ,''                          AS NTC_FAX_NO" ).append("\n"); 
		query.append("      ,''                          AS NTC_EML" ).append("\n"); 
		query.append("      ,''                          AS SND_ID" ).append("\n"); 
		query.append("      ,'JANCUS'                    AS EDI_ID" ).append("\n"); 
		query.append("      ,'DOR'                       AS DO_EDI_TP_CD" ).append("\n"); 
		query.append("      ,''                          AS ESVC_GRP_CD" ).append("\n"); 
		query.append("      ,''                          AS BKG_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("      ,''                          AS TML_NTC_SND_STS_CD" ).append("\n"); 
		query.append("      ,''                          AS CGOR_RCVR_TP_CD" ).append("\n"); 
		query.append("      ,''                          AS CGOR_STS_CD" ).append("\n"); 
		query.append("      ,'N'                         AS FRT_HDN_FLG" ).append("\n"); 
		query.append("      ,'N'                         AS FRT_ALL_FLG" ).append("\n"); 
		query.append("      ,'N'                         AS FRT_CLT_FLG" ).append("\n"); 
		query.append("      ,'N'                         AS FRT_PPD_FLG" ).append("\n"); 
		query.append("      ,'N'                         AS FRT_CHG_FLG" ).append("\n"); 
		query.append("      ,'N'                         AS FRT_ARR_FLG" ).append("\n"); 
		query.append("      ,@[ofc_cd]                   AS SND_OFC_CD" ).append("\n"); 
		query.append("      ,@[usr_id]                   AS SND_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',sysdate,GLOBALDATE_PKG.GET_LOCCD_FNC(@[ofc_cd]) ),'YYYYMMDD HH24MISS')      AS SND_RQST_DT" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("      ,'1'                         AS SND_RTY_KNT" ).append("\n"); 
		query.append("      ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',sysdate,GLOBALDATE_PKG.GET_LOCCD_FNC(@[ofc_cd]) ),'YYYYMMDD HH24MISS')      AS SND_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ,@[flat_file]               AS DIFF_RMK" ).append("\n"); 
		query.append("      ,'N'                         AS CUST_CNTC_AMD_FLG" ).append("\n"); 
		query.append("      ,'N'                         AS DP_HDN_FLG" ).append("\n"); 
		query.append("      ,@[cre_usr_id]               AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,TO_DATE(SYSDATE, 'YYYY/MM/DD HH24MISS') AS CRE_DT" ).append("\n"); 
		query.append("      ,@[upd_usr_id]                           AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,TO_DATE(SYSDATE, 'YYYY/MM/DD HH24MISS') AS UPD_DT   " ).append("\n"); 
		query.append("FROM   BKG_JP_DO_IF" ).append("\n"); 
		query.append("WHERE  JP_DO_GRP_NO =  @[grp_no]   -- 전송 대상 그룹핑으로 묶인 B/L" ).append("\n"); 
		query.append("AND    JP_DO_SND_STS_CD = 'T'" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingMasterMgtDBDAOBkgEdiGrpUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOBkgEdiGrpUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgEdiGrp
	  * </pre>
	  */
	public BookingMasterMgtDBDAOBkgEdiGrpUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("esvc_grp_delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_trd_prnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mchn_trd_prnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("esvc_grp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("esvc_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("co_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOBkgEdiGrpUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_EDI_GRP TA" ).append("\n"); 
		query.append("USING ( SELECT @[esvc_grp_cd] AS ESVC_GRP_CD," ).append("\n"); 
		query.append("               SUBSTRB(@[co_cd],1,1) AS CO_CD," ).append("\n"); 
		query.append("               @[esvc_grp_nm] AS ESVC_GRP_NM," ).append("\n"); 
		query.append("               @[cust_trd_prnr_id] AS CUST_TRD_PRNR_ID," ).append("\n"); 
		query.append("               @[mchn_trd_prnr_id] AS MCHN_TRD_PRNR_ID," ).append("\n"); 
		query.append("               @[esvc_grp_delt_flg] AS ESVC_GRP_DELT_FLG" ).append("\n"); 
		query.append("        FROM   DUAL ) TB" ).append("\n"); 
		query.append("ON    ( TA.ESVC_GRP_CD = TB.ESVC_GRP_CD" ).append("\n"); 
		query.append("        AND TA.CO_CD = TB.CO_CD )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("      UPDATE SET" ).append("\n"); 
		query.append("             ESVC_GRP_NM       = TB.ESVC_GRP_NM," ).append("\n"); 
		query.append("             CUST_TRD_PRNR_ID  = TB.CUST_TRD_PRNR_ID," ).append("\n"); 
		query.append("             MCHN_TRD_PRNR_ID  = TB.MCHN_TRD_PRNR_ID," ).append("\n"); 
		query.append("             ESVC_GRP_DELT_FLG = DECODE(TB.ESVC_GRP_DELT_FLG,'1','Y','Y','Y','N')," ).append("\n"); 
		query.append("             UPD_USR_ID        = 'System'," ).append("\n"); 
		query.append("             UPD_DT            = SYSDATE      " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("      INSERT ( ESVC_GRP_CD,      CO_CD," ).append("\n"); 
		query.append("               ESVC_GRP_NM,      CUST_TRD_PRNR_ID," ).append("\n"); 
		query.append("               MCHN_TRD_PRNR_ID, ESVC_GRP_DELT_FLG, " ).append("\n"); 
		query.append("               CRE_USR_ID,       CRE_DT," ).append("\n"); 
		query.append("               UPD_USR_ID,       UPD_DT )" ).append("\n"); 
		query.append("      VALUES ( TB.ESVC_GRP_CD,      TB.CO_CD," ).append("\n"); 
		query.append("               TB.ESVC_GRP_NM,      TB.CUST_TRD_PRNR_ID," ).append("\n"); 
		query.append("               TB.MCHN_TRD_PRNR_ID, DECODE(TB.ESVC_GRP_DELT_FLG,'1','Y','Y','Y','N')," ).append("\n"); 
		query.append("               'System', SYSDATE," ).append("\n"); 
		query.append("               'System', SYSDATE )" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchEuDoNtcSndHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.16 
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

public class CargoReleaseOrderDBDAOsearchEuDoNtcSndHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEuDoNtcSndHistory
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchEuDoNtcSndHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_eml",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ntc_via_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("do_no_split",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("do_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchEuDoNtcSndHistoryRSQL").append("\n"); 
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
		query.append("SELECT BKGM.BKG_NO                                                  AS BKG_NO" ).append("\n"); 
		query.append(",NULL                                                         AS HIS_SEQ" ).append("\n"); 
		query.append(",@[ntc_via_cd]                                                AS NTC_VIA_CD" ).append("\n"); 
		query.append(",'DO'                                                         AS NTC_KND_CD" ).append("\n"); 
		query.append(",NULL                                                         AS CNTR_NO" ).append("\n"); 
		query.append(",NULL                                                         AS AGN_CD" ).append("\n"); 
		query.append(",NULL                                                         AS NTC_FOM_CD" ).append("\n"); 
		query.append(",NULL                                                         AS NTC_SEQ" ).append("\n"); 
		query.append(",BCST.BKG_CUST_TP_CD                                          AS BKG_CUST_TP_CD" ).append("\n"); 
		query.append(",NULL                                                         AS CUST_CNTC_TP_CD" ).append("\n"); 
		query.append(",decode(@[ntc_via_cd],'F',@[ntc_fax_no],NULL)                 AS NTC_FAX_NO" ).append("\n"); 
		query.append(",decode(@[ntc_via_cd],'E',@[ntc_eml],NULL)                    AS NTC_EML" ).append("\n"); 
		query.append(",@[snd_id]                                                    AS SND_ID" ).append("\n"); 
		query.append(",NULL                                                         AS EDI_ID   -- 수신 ID" ).append("\n"); 
		query.append(",NULL                                                         AS DO_EDI_TP_CD   -- 수신 ID" ).append("\n"); 
		query.append(",NULL                                                         AS ESVC_GRP_CD" ).append("\n"); 
		query.append(",NULL                                                         AS BKG_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append(",NULL                                                         AS TML_NTC_SND_STS_CD" ).append("\n"); 
		query.append(",NULL                                                         AS CGOR_RCVR_TP_CD" ).append("\n"); 
		query.append(",NULL                                                         AS CGOR_STS_CD" ).append("\n"); 
		query.append(",'N'                                                          AS FRT_HDN_FLG" ).append("\n"); 
		query.append(",'N'                                                          AS FRT_ALL_FLG" ).append("\n"); 
		query.append(",'N'                                                          AS FRT_CLT_FLG" ).append("\n"); 
		query.append(",'N'                                                          AS FRT_PPD_FLG" ).append("\n"); 
		query.append(",'N'                                                          AS FRT_CHG_FLG" ).append("\n"); 
		query.append(",'N'                                                          AS FRT_ARR_FLG" ).append("\n"); 
		query.append(",@[ofc_cd]                                                    AS SND_OFC_CD" ).append("\n"); 
		query.append(",@[usr_id]                                                    AS SND_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',sysdate,GLOBALDATE_PKG.GET_LOCCD_FNC(@[ofc_cd]) ), 'YYYYMMDD HH24MISS')      AS SND_RQST_DT" ).append("\n"); 
		query.append(",NULL                                                        AS SND_RTY_KNT" ).append("\n"); 
		query.append(",NULL                                                        AS SND_DT" ).append("\n"); 
		query.append(",NULL                                                        AS SND_GDT" ).append("\n"); 
		query.append(",NULL                                                        AS DIFF_RMK" ).append("\n"); 
		query.append(",NULL                                                        AS CUST_CNTC_AMD_FLG" ).append("\n"); 
		query.append(",NULL                                                        AS DP_HDN_FLG" ).append("\n"); 
		query.append(",@[cre_usr_id]                                               AS CRE_USR_ID" ).append("\n"); 
		query.append(",SYSDATE                                                     AS CRE_DT" ).append("\n"); 
		query.append(",@[upd_usr_id]                                               AS UPD_USR_ID" ).append("\n"); 
		query.append(",SYSDATE                                                     AS UPD_DT" ).append("\n"); 
		query.append("FROM BKG_DO       BDO," ).append("\n"); 
		query.append("BKG_BOOKING  BKGM," ).append("\n"); 
		query.append("BKG_CUSTOMER BCST" ).append("\n"); 
		query.append("WHERE DO_NO               = @[do_no]" ).append("\n"); 
		query.append("AND DO_NO_SPLIT         = @[do_no_split]" ).append("\n"); 
		query.append("AND BKGM.BKG_NO         = BDO.BKG_NO" ).append("\n"); 
		query.append("AND BCST.BKG_NO         = BKGM.BKG_NO" ).append("\n"); 
		query.append("AND BCST.BKG_CUST_TP_CD = DECODE(BKGM.CUST_TO_ORD_FLG,'Y','N','C')" ).append("\n"); 

	}
}
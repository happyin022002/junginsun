/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchJapDorEdiHistoryByCancelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 윤윤한
*@LastVersion : 1.0
* 2010.01.08 윤윤한
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YYN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchJapDorEdiHistoryByCancelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchJapDorEdiHistoryByCancelRSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchJapDorEdiHistoryByCancelRSQL").append("\n"); 
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
		query.append("SELECT @[bkg_no]               AS BKG_NO" ).append("\n"); 
		query.append(", ''                      AS HIS_SEQ" ).append("\n"); 
		query.append(", 'E'                     AS NTC_VIA_CD -- F:FAX M:EMAIL E:EDI" ).append("\n"); 
		query.append(", 'DO'                    AS NTC_KND_CD" ).append("\n"); 
		query.append(", ''                      AS CNTR_NO" ).append("\n"); 
		query.append(", ''                      AS AGN_CD" ).append("\n"); 
		query.append(", ''                      AS NTC_FOM_CD" ).append("\n"); 
		query.append(", ''                      AS NTC_SEQ" ).append("\n"); 
		query.append(", ''                      AS BKG_CUST_TP_CD" ).append("\n"); 
		query.append(", ''                      AS CUST_CNTC_TP_CD" ).append("\n"); 
		query.append(", ''                      AS NTC_FAX_NO" ).append("\n"); 
		query.append(", ''                      AS NTC_EML" ).append("\n"); 
		query.append(", ''                      AS SND_ID" ).append("\n"); 
		query.append("--, 'ALPSBKG_UBIZHJS_NACCS' AS EDI_ID 컬럼길이 20" ).append("\n"); 
		query.append(", ''                      AS ESVC_GRP_CD" ).append("\n"); 
		query.append(", ''                      AS BKG_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append(", ''                      AS TML_NTC_SND_STS_CD" ).append("\n"); 
		query.append(", ''                      AS CGOR_RCVR_TP_CD" ).append("\n"); 
		query.append(", ''                      AS CGOR_STS_CD" ).append("\n"); 
		query.append(", ''                      AS FRT_HDN_FLG" ).append("\n"); 
		query.append(", ''                      AS FRT_ALL_FLG" ).append("\n"); 
		query.append(",  ''                     AS FRT_CLT_FLG" ).append("\n"); 
		query.append(", ''                      AS FRT_PPD_FLG" ).append("\n"); 
		query.append(", ''                      AS FRT_CHG_FLG" ).append("\n"); 
		query.append(", ''                      AS FRT_ARR_FLG" ).append("\n"); 
		query.append(", @[ofc_cd]               AS SND_OFC_CD" ).append("\n"); 
		query.append(", @[usr_id]               AS SND_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',sysdate,GLOBALDATE_PKG.GET_LOCCD_FNC(@[ofc_cd]) ),'YYYYMMDD HH24MISS') AS SND_RQST_DT" ).append("\n"); 
		query.append(", '1'                     AS SND_RTY_KNT" ).append("\n"); 
		query.append(", TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',sysdate,GLOBALDATE_PKG.GET_LOCCD_FNC(@[ofc_cd]) ),'YYYYMMDD HH24MISS') AS SND_DT" ).append("\n"); 
		query.append(", ''                      AS DIFF_RMK" ).append("\n"); 
		query.append(", ''                      AS CUST_CNTC_AMD_FLG" ).append("\n"); 
		query.append(", ''                      AS DP_HDN_FLG" ).append("\n"); 
		query.append(", @[cre_usr_id]           AS CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE                 AS CRE_DT" ).append("\n"); 
		query.append(", @[upd_usr_id]           AS UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE                 AS UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchKorEdiHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchKorEdiHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Kor D/O EDI 이력을 저장하기 위한 정보를 조회한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchKorEdiHistoryRSQL(){
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
		params.put("do_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("edi_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchKorEdiHistoryRSQL").append("\n"); 
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
		query.append("SELECT @[bkg_no]                     AS BKG_NO" ).append("\n"); 
		query.append("     , NULL                          AS HIS_SEQ" ).append("\n"); 
		query.append("     , 'E'                           AS NTC_VIA_CD" ).append("\n"); 
		query.append("     , 'DO'                          AS NTC_KND_CD" ).append("\n"); 
		query.append("     , NULL                          AS CNTR_NO" ).append("\n"); 
		query.append("     , NULL                          AS AGN_CD" ).append("\n"); 
		query.append("     , NULL                          AS NTC_FOM_CD" ).append("\n"); 
		query.append("     , NULL                          AS NTC_SEQ" ).append("\n"); 
		query.append("     , NULL                          AS BKG_CUST_TP_CD" ).append("\n"); 
		query.append("     , NULL                          AS CUST_CNTC_TP_CD" ).append("\n"); 
		query.append("     , NULL                          AS NTC_FAX_NO" ).append("\n"); 
		query.append("     , NULL                          AS NTC_EML" ).append("\n"); 
		query.append("     , NULL                          AS SND_ID" ).append("\n"); 
		query.append("     , @[edi_id]                     AS EDI_ID   -- 수신 ID" ).append("\n"); 
		query.append("     , @[do_type]                    AS DO_EDI_TP_CD   -- 수신 ID" ).append("\n"); 
		query.append("     , NULL                          AS ESVC_GRP_CD" ).append("\n"); 
		query.append("     , @[edi_snd_rslt_cd]            AS BKG_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("     , NULL                          AS TML_NTC_SND_STS_CD" ).append("\n"); 
		query.append("     , NULL                          AS CGOR_RCVR_TP_CD" ).append("\n"); 
		query.append("     , NULL                          AS CGOR_STS_CD" ).append("\n"); 
		query.append("     , 'N'                           AS FRT_HDN_FLG" ).append("\n"); 
		query.append("     , 'N'                           AS FRT_ALL_FLG" ).append("\n"); 
		query.append("     , 'N'                           AS FRT_CLT_FLG" ).append("\n"); 
		query.append("     , 'N'                           AS FRT_PPD_FLG" ).append("\n"); 
		query.append("     , 'N'                           AS FRT_CHG_FLG" ).append("\n"); 
		query.append("     , 'N'                           AS FRT_ARR_FLG" ).append("\n"); 
		query.append("     , @[ofc_cd]                     AS SND_OFC_CD" ).append("\n"); 
		query.append("     , @[usr_id]                     AS SND_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR( GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]) ,'YYYYMMDD HH24MISS')  AS SND_RQST_DT" ).append("\n"); 
		query.append("     , TO_CHAR( GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC,TO_DATE(sysdate, 'YYYY/MM/DD HH24MISS'), 'GMT' ),'YYYYMMDD HH24MISS')    AS SND_RQST_GDT" ).append("\n"); 
		query.append("     , NULL                         AS SND_RTY_KNT" ).append("\n"); 
		query.append("     , TO_CHAR( GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]) ,'YYYYMMDD HH24MISS') AS SND_DT " ).append("\n"); 
		query.append("     , TO_CHAR( GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC,TO_DATE(sysdate, 'YYYY/MM/DD HH24MISS'), 'GMT' ),'YYYYMMDD HH24MISS')    AS SND_GDT " ).append("\n"); 
		query.append("     , NULL                          AS DIFF_RMK" ).append("\n"); 
		query.append("     , NULL                          AS CUST_CNTC_AMD_FLG" ).append("\n"); 
		query.append("     , 'N'                           AS DP_HDN_FLG" ).append("\n"); 
		query.append("     , @[cre_usr_id]                 AS CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE                       AS CRE_DT" ).append("\n"); 
		query.append("     , @[upd_usr_id]                 AS UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE                       AS UPD_DT   " ).append("\n"); 
		query.append(" FROM DUAL" ).append("\n"); 

	}
}
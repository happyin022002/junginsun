/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PickUpNoticeDBDAOaddPkupNtcPkupNoByPkupNtcByBkgNoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.11
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PickUpNoticeDBDAOaddPkupNtcPkupNoByPkupNtcByBkgNoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public PickUpNoticeDBDAOaddPkupNtcPkupNoByPkupNtcByBkgNoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_seq",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOaddPkupNtcPkupNoByPkupNtcByBkgNoCSQL").append("\n"); 
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
		query.append("/* 삭제됨!!!!" ).append("\n"); 
		query.append("INSERT INTO BKG_PKUP_NTC_PKUP_NO" ).append("\n"); 
		query.append("       (BKG_NO" ).append("\n"); 
		query.append("       ,CNTR_NO" ).append("\n"); 
		query.append("       ,OFC_CD" ).append("\n"); 
		query.append("       ,BL_NO" ).append("\n"); 
		query.append("       ,VSL_CD" ).append("\n"); 
		query.append("       ,SKD_VOY_NO" ).append("\n"); 
		query.append("       ,SKD_DIR_CD" ).append("\n"); 
		query.append("       ,POD_CD" ).append("\n"); 
		query.append("       ,DEL_CD" ).append("\n"); 
		query.append("       ,DE_TERM_CD" ).append("\n"); 
		query.append("       ,RAIL_ORG_LOC_CD" ).append("\n"); 
		query.append("       ,RAIL_DEST_LOC_CD" ).append("\n"); 
		query.append("       ,IBD_TRSP_HUB_CD" ).append("\n"); 
		query.append("       ,PKUP_YD_CD" ).append("\n"); 
		query.append("       ,PKUP_NO" ).append("\n"); 
		query.append("       ,PKUP_AVAL_DT" ).append("\n"); 
		query.append("       ,LST_FREE_DT" ).append("\n"); 
		query.append("       ,RTN_YD_CD" ).append("\n"); 
		query.append("       ,UNI_PCF_IND_FLG" ).append("\n"); 
		query.append("       ,CAN_PCF_IND_FLG" ).append("\n"); 
		query.append("       ,PKUP_NTC_IND_CD" ).append("\n"); 
		query.append("       ,PKUP_NTC_SND_KNT" ).append("\n"); 
		query.append("       ,STOP_USR_ID" ).append("\n"); 
		query.append("       ,STOP_DT" ).append("\n"); 
		query.append("       ,PKUP_CRE_DT" ).append("\n"); 
		query.append("       ,PKUP_CRE_USR_ID" ).append("\n"); 
		query.append("       ,PKUP_UPD_DT" ).append("\n"); 
		query.append("       ,PKUP_UPD_USR_ID" ).append("\n"); 
		query.append("       ,DELT_FLG" ).append("\n"); 
		query.append("       ,PKUP_DELT_DT" ).append("\n"); 
		query.append("       ,PKUP_DELT_USR_ID" ).append("\n"); 
		query.append("       ,CRE_USR_ID" ).append("\n"); 
		query.append("       ,CRE_DT" ).append("\n"); 
		query.append("       ,UPD_USR_ID" ).append("\n"); 
		query.append("       ,UPD_DT" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("SELECT BPN.BKG_NO" ).append("\n"); 
		query.append("      ,BPN.CNTR_NO" ).append("\n"); 
		query.append("      ,LOC.EQ_CTRL_OFC_CD -- DEL의 EQ CONTROL OFFICE" ).append("\n"); 
		query.append("      ,BKG.BL_NO" ).append("\n"); 
		query.append("      ,BKG.VSL_CD" ).append("\n"); 
		query.append("      ,BKG.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,BKG.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,BKG.POD_CD" ).append("\n"); 
		query.append("      ,BKG.DEL_CD" ).append("\n"); 
		query.append("      ,BKG.DE_TERM_CD" ).append("\n"); 
		query.append("      ,SUBSTR(TRB.FM_NOD_CD, 1, 5) -- RAIL_ORG_LOC_CD," ).append("\n"); 
		query.append("      ,SUBSTR(TRB.TO_NOD_CD, 1, 5) -- RAIL_DEST_LOC_CD," ).append("\n"); 
		query.append("      ,BPN.IBD_TRSP_HUB_CD" ).append("\n"); 
		query.append("      ,BPN.PKUP_YD_CD" ).append("\n"); 
		query.append("      ,BPN.PKUP_NO" ).append("\n"); 
		query.append("      ,BPN.PKUP_AVAL_DT" ).append("\n"); 
		query.append("      ,BPN.LST_FREE_DT" ).append("\n"); 
		query.append("      ,BPN.RTN_YD_CD" ).append("\n"); 
		query.append("      ,'N' AS UNI_PCF_IND_FLG" ).append("\n"); 
		query.append("      ,'N' AS CAN_PCF_IND_FLG" ).append("\n"); 
		query.append("      ,NULL AS PKUP_NTC_IND_CD" ).append("\n"); 
		query.append("      ,NULL AS PKUP_NTC_SND_KNT" ).append("\n"); 
		query.append("      ,NULL AS STOP_USR_ID" ).append("\n"); 
		query.append("      ,NULL AS STOP_DT" ).append("\n"); 
		query.append("      ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(LOC.EQ_CTRL_OFC_CD) AS PKUP_CRE_DT" ).append("\n"); 
		query.append("      ,@[usr_id] AS PKUP_CRE_USR_ID" ).append("\n"); 
		query.append("      ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(LOC.EQ_CTRL_OFC_CD) AS PKUP_UPD_DT" ).append("\n"); 
		query.append("      ,@[usr_id] AS PKUP_UPD_USR_ID" ).append("\n"); 
		query.append("      ,'N' AS DELT_FLG" ).append("\n"); 
		query.append("      ,NULL AS PKUP_DELT_DT" ).append("\n"); 
		query.append("      ,NULL AS PKUP_DELT_USR_ID" ).append("\n"); 
		query.append("      ,@[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("      ,@[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("  FROM BKG_PKUP_NTC          BPN" ).append("\n"); 
		query.append("      ,TRS_TRSP_RAIL_BIL_ORD TRB" ).append("\n"); 
		query.append("      ,BKG_BOOKING           BKG" ).append("\n"); 
		query.append("      ,MDM_LOCATION          LOC" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND BPN.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("   AND BPN.NTC_SEQ = @[ntc_seq]" ).append("\n"); 
		query.append("   AND TRB.TRSP_SO_OFC_CTY_CD(+) = BPN.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND TRB.TRSP_SO_SEQ(+)        = BPN.TRSP_SO_SEQ" ).append("\n"); 
		query.append("   AND BKG.BKG_NO             = BPN.BKG_NO" ).append("\n"); 
		query.append("   AND LOC.LOC_CD             = BKG.DEL_CD" ).append("\n"); 
		query.append("*/" ).append("\n"); 

	}
}
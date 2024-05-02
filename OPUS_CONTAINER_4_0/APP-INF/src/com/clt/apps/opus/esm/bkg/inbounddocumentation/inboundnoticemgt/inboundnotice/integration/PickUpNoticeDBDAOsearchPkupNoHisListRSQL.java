/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PickUpNoticeDBDAOsearchPkupNoHisListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.27 
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

public class PickUpNoticeDBDAOsearchPkupNoHisListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public PickUpNoticeDBDAOsearchPkupNoHisListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOsearchPkupNoHisListRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("        	   BKG_NO" ).append("\n"); 
		query.append("        	  ,CNTR_NO" ).append("\n"); 
		query.append("        	  ,OFC_CD" ).append("\n"); 
		query.append("        	  ,BL_NO" ).append("\n"); 
		query.append("        	  ,VSL_CD" ).append("\n"); 
		query.append("        	  ,SKD_VOY_NO" ).append("\n"); 
		query.append("        	  ,SKD_DIR_CD" ).append("\n"); 
		query.append("        	  ,POD_CD" ).append("\n"); 
		query.append("        	  ,DEL_CD" ).append("\n"); 
		query.append("        	  ,DE_TERM_CD" ).append("\n"); 
		query.append("        	  ,RAIL_DEST_LOC_CD" ).append("\n"); 
		query.append("        	  ,IBD_TRSP_HUB_CD" ).append("\n"); 
		query.append("        	  ,PKUP_YD_CD" ).append("\n"); 
		query.append("        	  ,PKUP_NO" ).append("\n"); 
		query.append("        	  ,TO_CHAR(PKUP_AVAL_DT, 'YYYY-MM-DD HH24:MI') PKUP_AVAL_DT" ).append("\n"); 
		query.append("        	  ,TO_CHAR(LST_FREE_DT, 'YYYY-MM-DD HH24:MI')  LST_FREE_DT" ).append("\n"); 
		query.append("        	  ,RTN_YD_CD" ).append("\n"); 
		query.append("        	  ,PKUP_CRE_DT" ).append("\n"); 
		query.append("        	  ,DECODE(PKUP_CRE_USR_ID,'BAT_BKG_019','EDI',PKUP_CRE_USR_ID) AS PKUP_CRE_USR_ID" ).append("\n"); 
		query.append("        	  ,PKUP_UPD_DT" ).append("\n"); 
		query.append("        	  ,DECODE(PKUP_UPD_USR_ID,'BAT_BKG_019','EDI',PKUP_UPD_USR_ID) As PKUP_UPD_USR_ID" ).append("\n"); 
		query.append("        	  ,DELT_FLG" ).append("\n"); 
		query.append("        	  ,PKUP_DELT_DT" ).append("\n"); 
		query.append("        	  ,PKUP_DELT_USR_ID" ).append("\n"); 
		query.append("        	  ,PKUP_DELT_RSN" ).append("\n"); 
		query.append("        	  ,RAIL_ARR_DT" ).append("\n"); 
		query.append("        	  ,RAIL_DEP_DT" ).append("\n"); 
		query.append("        	  ,PKUP_MNL_UPLD_FLG" ).append("\n"); 
		query.append("        	  ,CRE_USR_ID" ).append("\n"); 
		query.append("        	  ,CRE_DT" ).append("\n"); 
		query.append("        	  ,UPD_USR_ID" ).append("\n"); 
		query.append("        	  ,UPD_DT" ).append("\n"); 
		query.append("          FROM BKG_PKUP_NTC_PKUP_NO_HIS" ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("           AND OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("        	   BKG_NO" ).append("\n"); 
		query.append("        	  ,CNTR_NO" ).append("\n"); 
		query.append("        	  ,OFC_CD" ).append("\n"); 
		query.append("        	  ,BL_NO" ).append("\n"); 
		query.append("        	  ,VSL_CD" ).append("\n"); 
		query.append("        	  ,SKD_VOY_NO" ).append("\n"); 
		query.append("        	  ,SKD_DIR_CD" ).append("\n"); 
		query.append("        	  ,POD_CD" ).append("\n"); 
		query.append("        	  ,DEL_CD" ).append("\n"); 
		query.append("        	  ,DE_TERM_CD" ).append("\n"); 
		query.append("        	  ,RAIL_DEST_LOC_CD" ).append("\n"); 
		query.append("        	  ,IBD_TRSP_HUB_CD" ).append("\n"); 
		query.append("        	  ,PKUP_YD_CD" ).append("\n"); 
		query.append("        	  ,PKUP_NO" ).append("\n"); 
		query.append("        	  ,TO_CHAR(PKUP_AVAL_DT, 'YYYY-MM-DD HH24:MI') PKUP_AVAL_DT" ).append("\n"); 
		query.append("        	  ,TO_CHAR(LST_FREE_DT, 'YYYY-MM-DD HH24:MI')  LST_FREE_DT" ).append("\n"); 
		query.append("        	  ,RTN_YD_CD" ).append("\n"); 
		query.append("        	  ,PKUP_CRE_DT" ).append("\n"); 
		query.append("        	  ,DECODE(PKUP_CRE_USR_ID,'BAT_BKG_019','EDI',PKUP_CRE_USR_ID) AS PKUP_CRE_USR_ID" ).append("\n"); 
		query.append("        	  ,PKUP_UPD_DT" ).append("\n"); 
		query.append("        	  ,DECODE(PKUP_UPD_USR_ID,'BAT_BKG_019','EDI',PKUP_UPD_USR_ID) As PKUP_UPD_USR_ID" ).append("\n"); 
		query.append("        	  ,DELT_FLG" ).append("\n"); 
		query.append("        	  ,PKUP_DELT_DT" ).append("\n"); 
		query.append("        	  ,PKUP_DELT_USR_ID" ).append("\n"); 
		query.append("        	  ,'' AS PKUP_DELT_RSN" ).append("\n"); 
		query.append("        	  ,RAIL_ARR_DT" ).append("\n"); 
		query.append("        	  ,RAIL_DEP_DT" ).append("\n"); 
		query.append("        	  ,PKUP_MNL_UPLD_FLG" ).append("\n"); 
		query.append("        	  ,CRE_USR_ID" ).append("\n"); 
		query.append("        	  ,CRE_DT" ).append("\n"); 
		query.append("        	  ,UPD_USR_ID" ).append("\n"); 
		query.append("        	  ,UPD_DT" ).append("\n"); 
		query.append("          FROM BKG_PKUP_NTC_PKUP_NO" ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("           AND OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("  ORDER BY UPD_DT" ).append("\n"); 

	}
}
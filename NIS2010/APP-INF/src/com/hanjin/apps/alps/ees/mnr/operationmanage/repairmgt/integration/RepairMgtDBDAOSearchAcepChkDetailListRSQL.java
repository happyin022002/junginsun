/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : RepairMgtDBDAOSearchAcepChkDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2018.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOSearchAcepChkDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ACEP Check Detail List 조회
	  * </pre>
	  */
	public RepairMgtDBDAOSearchAcepChkDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ord_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mnr_ord_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rpr_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOSearchAcepChkDetailListRSQL").append("\n"); 
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
		query.append("SELECT   AC.ACEP_SEQ" ).append("\n"); 
		query.append("       , NVL(AC.ACEP_DTL_SEQ, ITM.HRD_CDG_ID_SEQ) AS ACEP_DTL_SEQ" ).append("\n"); 
		query.append("       , NVL(AC.INSP_ITM_NO, ITM.ATTR_CTNT1) AS INSP_ITM_NO" ).append("\n"); 
		query.append("       , NVL(AC.INSP_ITM_NM, ITM.ATTR_CTNT2) AS INSP_ITM_NM" ).append("\n"); 
		query.append("#if (${mnr_ord_seq} != '')" ).append("\n"); 
		query.append("       , NVL(AC.ACEP_CHK,'1') AS ACEP_CHK" ).append("\n"); 
		query.append("       , NVL(AC.ACEP_UNCHK,'0') AS ACEP_UNCHK" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       , NVL(AC.ACEP_CHK,'0') AS ACEP_CHK" ).append("\n"); 
		query.append("       , NVL(AC.ACEP_UNCHK,'1') AS ACEP_UNCHK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       , NVL(AC.CRE_USR_ID,@[cre_usr_id]) AS CRE_USR_ID" ).append("\n"); 
		query.append("       , NVL(AC.CRE_DT,SYSDATE) AS CRE_DT" ).append("\n"); 
		query.append("       , NVL(AC.UPD_USR_ID,@[upd_usr_id]) AS UPD_USR_ID" ).append("\n"); 
		query.append("       , NVL(AC.UPD_DT,SYSDATE) AS UPD_DT" ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("#if (${mnr_wo_tp_cd} == 'EST')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           SELECT   AD.ACEP_SEQ" ).append("\n"); 
		query.append("                  , AD.ACEP_DTL_SEQ" ).append("\n"); 
		query.append("                  , AD.INSP_ITM_NO" ).append("\n"); 
		query.append("                  , AD.INSP_ITM_NM" ).append("\n"); 
		query.append("                  , CASE WHEN AD.INSP_CHK_FLG = 'Y' THEN '1' ELSE '0' END AS ACEP_CHK" ).append("\n"); 
		query.append("                  , CASE WHEN AD.INSP_CHK_FLG = 'Y' THEN '0' ELSE '1' END AS ACEP_UNCHK" ).append("\n"); 
		query.append("                  , AD.CRE_USR_ID" ).append("\n"); 
		query.append("                  , AD.CRE_DT" ).append("\n"); 
		query.append("                  , AD.UPD_USR_ID" ).append("\n"); 
		query.append("                  , AD.UPD_DT" ).append("\n"); 
		query.append("           FROM     MNR_RPR_RQST_HDR EM" ).append("\n"); 
		query.append("                  , MNR_ACEP_CHK_LIST_HDR AM" ).append("\n"); 
		query.append("                  , MNR_ACEP_CHK_LIST_DTL AD" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      EM.RQST_EQ_NO = AM.EQ_NO(+)" ).append("\n"); 
		query.append("           AND      EM.RPR_RQST_SEQ = AM.RPR_RQST_SEQ(+)" ).append("\n"); 
		query.append("           AND      AM.ACEP_SEQ = AD.ACEP_SEQ(+)" ).append("\n"); 
		query.append("           AND      EM.RQST_EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("           AND      EM.RPR_RQST_SEQ = @[rpr_rqst_seq]" ).append("\n"); 
		query.append("           AND      EM.RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${mnr_wo_tp_cd} == 'SPL')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           SELECT   AD.ACEP_SEQ" ).append("\n"); 
		query.append("                  , AD.ACEP_DTL_SEQ" ).append("\n"); 
		query.append("                  , AD.INSP_ITM_NO" ).append("\n"); 
		query.append("                  , AD.INSP_ITM_NM" ).append("\n"); 
		query.append("                  , CASE WHEN AD.INSP_CHK_FLG = 'Y' THEN '1' ELSE '0' END AS ACEP_CHK" ).append("\n"); 
		query.append("                  , CASE WHEN AD.INSP_CHK_FLG = 'Y' THEN '0' ELSE '1' END AS ACEP_UNCHK" ).append("\n"); 
		query.append("                  , AD.CRE_USR_ID" ).append("\n"); 
		query.append("                  , AD.CRE_DT" ).append("\n"); 
		query.append("                  , AD.UPD_USR_ID" ).append("\n"); 
		query.append("                  , AD.UPD_DT" ).append("\n"); 
		query.append("           FROM     MNR_ORD_HDR OM" ).append("\n"); 
		query.append("                  , MNR_ORD_DTL OD" ).append("\n"); 
		query.append("                  , MNR_ACEP_CHK_LIST_HDR AM" ).append("\n"); 
		query.append("                  , MNR_ACEP_CHK_LIST_DTL AD" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      OM.MNR_ORD_OFC_CTY_CD = OD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND      OM.MNR_ORD_SEQ = OD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("           AND      OD.EQ_NO = AM.EQ_NO(+)" ).append("\n"); 
		query.append("           AND      OD.MNR_ORD_OFC_CTY_CD = AM.MNR_ORD_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("           AND      OD.MNR_ORD_SEQ = AM.MNR_ORD_SEQ(+)" ).append("\n"); 
		query.append("           AND      AM.ACEP_SEQ = AD.ACEP_SEQ(+)" ).append("\n"); 
		query.append("           AND      OD.MNR_ORD_OFC_CTY_CD = @[mnr_ord_ofc_cty_cd]" ).append("\n"); 
		query.append("           AND      OD.MNR_ORD_SEQ = @[mnr_ord_seq]" ).append("\n"); 
		query.append("           AND      OD.ORD_DTL_SEQ = @[ord_dtl_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         ) AC" ).append("\n"); 
		query.append("       , MNR_HRD_CDG_CTNT ITM" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      ITM.ATTR_CTNT1 = TO_CHAR(AC.INSP_ITM_NO(+))" ).append("\n"); 
		query.append("AND      ITM.HRD_CDG_ID = 'ACEP_INSP_ITM'" ).append("\n"); 
		query.append("AND      ITM.ATTR_CTNT10 = 'Y'" ).append("\n"); 
		query.append("ORDER BY TO_NUMBER(ITM.ATTR_CTNT9)" ).append("\n"); 

	}
}
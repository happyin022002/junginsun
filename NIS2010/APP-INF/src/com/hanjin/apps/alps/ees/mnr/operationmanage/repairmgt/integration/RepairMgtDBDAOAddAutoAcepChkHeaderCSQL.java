/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : RepairMgtDBDAOAddAutoAcepChkHeaderCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.24
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.24 
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

public class RepairMgtDBDAOAddAutoAcepChkHeaderCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Acep Check List Header Auto Insert
	  * </pre>
	  */
	public RepairMgtDBDAOAddAutoAcepChkHeaderCSQL(){
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
		params.put("acep_seq",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_wo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOAddAutoAcepChkHeaderCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_ACEP_CHK_LIST_HDR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("         ACEP_SEQ" ).append("\n"); 
		query.append("       , MNR_WO_TP_CD" ).append("\n"); 
		query.append("       , EQ_NO" ).append("\n"); 
		query.append("       , RPR_RQST_SEQ" ).append("\n"); 
		query.append("       , MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("       , MNR_ORD_SEQ" ).append("\n"); 
		query.append("       , ORD_DTL_SEQ" ).append("\n"); 
		query.append("       , INSP_YD_CD" ).append("\n"); 
		query.append("       , LST_INSP_DT" ).append("\n"); 
		query.append("       , INSP_DT" ).append("\n"); 
		query.append("       , CRE_USR_ID" ).append("\n"); 
		query.append("       , CRE_DT" ).append("\n"); 
		query.append("       , UPD_USR_ID" ).append("\n"); 
		query.append("       , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${mnr_wo_tp_cd} == 'EST')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT   @[acep_seq] AS ACEP_SEQ" ).append("\n"); 
		query.append("       , @[mnr_wo_tp_cd] AS MNR_WO_TP_CD" ).append("\n"); 
		query.append("       , EM.RQST_EQ_NO" ).append("\n"); 
		query.append("       , EM.RPR_RQST_SEQ" ).append("\n"); 
		query.append("       , NULL AS MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("       , NULL AS MNR_ORD_SEQ" ).append("\n"); 
		query.append("       , NULL AS ORD_DTL_SEQ" ).append("\n"); 
		query.append("       , EM.RPR_YD_CD AS INSP_YD_CD" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   /*+ INDEX_DESC(OD XAK6MNR_ORD_DTL) */" ).append("\n"); 
		query.append("                    TO_CHAR(OD.RPR_RSLT_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("           FROM     MNR_ORD_DTL OD" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      OD.EQ_NO = EM.RQST_EQ_NO" ).append("\n"); 
		query.append("           AND      OD.CRE_DT < NVL(EM.RPR_RSLT_DT, EM.CRE_DT)" ).append("\n"); 
		query.append("           AND      ROWNUM = 1" ).append("\n"); 
		query.append("         ) AS LST_INSP_DT" ).append("\n"); 
		query.append("       , TO_CHAR(RQST_DT,'YYYYMMDD') AS INSP_DT" ).append("\n"); 
		query.append("       , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("       , SYSDATE" ).append("\n"); 
		query.append("       , @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("       , SYSDATE" ).append("\n"); 
		query.append("FROM     MNR_RPR_RQST_HDR EM" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      EM.RQST_EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("AND      EM.RPR_RQST_SEQ = @[rpr_rqst_seq]" ).append("\n"); 
		query.append("AND      EM.RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("AND      ROWNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT   @[acep_seq] AS ACEP_SEQ" ).append("\n"); 
		query.append("       , OM.MNR_WO_TP_CD" ).append("\n"); 
		query.append("       , OD.EQ_NO" ).append("\n"); 
		query.append("       , NULL AS RPR_RQST_SEQ" ).append("\n"); 
		query.append("       , OD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("       , OD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("       , OD.ORD_DTL_SEQ" ).append("\n"); 
		query.append("       , OD.YD_CD AS INSP_YD_CD" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   /*+ INDEX_DESC(OD XAK6MNR_ORD_DTL) */" ).append("\n"); 
		query.append("                    TO_CHAR(BD.RPR_RSLT_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("           FROM     MNR_ORD_DTL BD" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      BD.EQ_NO = OD.EQ_NO" ).append("\n"); 
		query.append("           AND      BD.CRE_DT < TRUNC(SYSDATE)" ).append("\n"); 
		query.append("           AND      ROWNUM = 1" ).append("\n"); 
		query.append("         ) AS LST_INSP_DT" ).append("\n"); 
		query.append("       , TO_CHAR(OD.RPR_RSLT_DT,'YYYYMMDD') AS INSP_DT" ).append("\n"); 
		query.append("       , OD.CRE_USR_ID" ).append("\n"); 
		query.append("       , SYSDATE" ).append("\n"); 
		query.append("       , OD.UPD_USR_ID" ).append("\n"); 
		query.append("       , SYSDATE" ).append("\n"); 
		query.append("FROM     MNR_ORD_DTL OD" ).append("\n"); 
		query.append("       , MNR_ORD_HDR OM" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      OD.MNR_ORD_OFC_CTY_CD = OM.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND      OD.MNR_ORD_SEQ = OM.MNR_ORD_SEQ" ).append("\n"); 
		query.append("AND      OM.MNR_WO_TP_CD IN ('SPL')" ).append("\n"); 
		query.append("AND      OD.MNR_ORD_OFC_CTY_CD = @[mnr_ord_ofc_cty_cd]" ).append("\n"); 
		query.append("AND      OD.MNR_ORD_SEQ = @[mnr_ord_seq]" ).append("\n"); 
		query.append("AND      OD.ORD_DTL_SEQ = @[ord_dtl_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
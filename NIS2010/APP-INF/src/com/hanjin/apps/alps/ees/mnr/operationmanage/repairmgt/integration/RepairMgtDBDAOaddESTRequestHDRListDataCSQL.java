/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : RepairMgtDBDAOaddESTRequestHDRListDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.12.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.12.20 
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

public class RepairMgtDBDAOaddESTRequestHDRListDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addESTRequestHDRListData
	  * </pre>
	  */
	public RepairMgtDBDAOaddESTRequestHDRListDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_inp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOaddESTRequestHDRListDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_RPR_RQST_HDR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("         RQST_EQ_NO" ).append("\n"); 
		query.append("       , RPR_RQST_SEQ" ).append("\n"); 
		query.append("       , RPR_RQST_VER_NO" ).append("\n"); 
		query.append("       , RPR_RQST_LST_VER_FLG" ).append("\n"); 
		query.append("       , EQ_KND_CD" ).append("\n"); 
		query.append("       , EQ_TPSZ_CD" ).append("\n"); 
		query.append("       , VNDR_SEQ" ).append("\n"); 
		query.append("       , RPR_STS_CD" ).append("\n"); 
		query.append("       , RPR_DTL_STS_CD" ).append("\n"); 
		query.append("       , RQST_REF_NO" ).append("\n"); 
		query.append("       , MNR_INP_TP_CD" ).append("\n"); 
		query.append("       , COST_OFC_CD" ).append("\n"); 
		query.append("       , RQST_DT" ).append("\n"); 
		query.append("       , RQST_USR_ID" ).append("\n"); 
		query.append("       , MNR_MEAS_UT_CD" ).append("\n"); 
		query.append("       , APRO_OFC_CD" ).append("\n"); 
		query.append("       , APRO_DT" ).append("\n"); 
		query.append("       , APRO_USR_ID" ).append("\n"); 
		query.append("       , RPR_OFFH_FLG" ).append("\n"); 
		query.append("       , RPR_RSLT_DT" ).append("\n"); 
		query.append("       , CURR_CD" ).append("\n"); 
		query.append("       , RPR_YD_CD" ).append("\n"); 
		query.append("       , EQ_DMG_DT" ).append("\n"); 
		query.append("       , EQ_DMG_TP_CD" ).append("\n"); 
		query.append("       , RPR_WRK_TP_CD" ).append("\n"); 
		query.append("       , MNR_EDI_NM" ).append("\n"); 
		query.append("       , N3PTY_FLG" ).append("\n"); 
		query.append("       , IF_TRC_SEQ" ).append("\n"); 
		query.append("       , MNR_AGMT_AMT" ).append("\n"); 
		query.append("       , MNR_WRK_AMT" ).append("\n"); 
		query.append("       , N3PTY_BIL_TTL_AMT" ).append("\n"); 
		query.append("       , DISP_FLG" ).append("\n"); 
		query.append("       , DISP_NO" ).append("\n"); 
		query.append("       , DISP_DTL_SEQ" ).append("\n"); 
		query.append("       , FILE_SEQ" ).append("\n"); 
		query.append("       , MNR_RPR_RMK" ).append("\n"); 
		query.append("       , EDI_ID" ).append("\n"); 
		query.append("       , MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("       , MNR_ORD_SEQ" ).append("\n"); 
		query.append("       , AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("       , AGMT_SEQ" ).append("\n"); 
		query.append("       , AGMT_VER_NO" ).append("\n"); 
		query.append("       , RPR_RQST_TMP_SEQ" ).append("\n"); 
		query.append("       , RPR_RQST_TMP_VER_NO" ).append("\n"); 
		query.append("       , MNR_WARR_FLG" ).append("\n"); 
		query.append("       , RCT_RPR_FLG" ).append("\n"); 
		query.append("       , VRFY_RSLT_RMK" ).append("\n"); 
		query.append("       , CRE_USR_ID" ).append("\n"); 
		query.append("       , CRE_DT" ).append("\n"); 
		query.append("       , UPD_USR_ID" ).append("\n"); 
		query.append("       , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT   MRH.RQST_EQ_NO" ).append("\n"); 
		query.append("       , MRH.RPR_RQST_SEQ" ).append("\n"); 
		query.append("       , MRH.RPR_RQST_VER_NO + 1" ).append("\n"); 
		query.append("       , 'Y'" ).append("\n"); 
		query.append("       , MES.EQ_TYPE" ).append("\n"); 
		query.append("       , MES.EQ_TPSZ_CD" ).append("\n"); 
		query.append("       , MRH.VNDR_SEQ" ).append("\n"); 
		query.append("       , @[rpr_sts_cd]" ).append("\n"); 
		query.append("       , MRH.RPR_DTL_STS_CD" ).append("\n"); 
		query.append("       , MRH.RQST_REF_NO" ).append("\n"); 
		query.append("       , @[mnr_inp_tp_cd]" ).append("\n"); 
		query.append("       , MRH.COST_OFC_CD" ).append("\n"); 
		query.append("       , MRH.RQST_DT" ).append("\n"); 
		query.append("       , @[rqst_usr_id]" ).append("\n"); 
		query.append("       , MRH.MNR_MEAS_UT_CD" ).append("\n"); 
		query.append("       , CASE WHEN NVL(MRH.RCT_RPR_FLG,'N') = 'Y' THEN ( SELECT MNR_CD_ID FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'HOOFC' AND ROWNUM = 1 ) ELSE MRH.APRO_OFC_CD END" ).append("\n"); 
		query.append("       , MRH.APRO_DT" ).append("\n"); 
		query.append("       , MRH.APRO_USR_ID" ).append("\n"); 
		query.append("       , MRH.RPR_OFFH_FLG" ).append("\n"); 
		query.append("       , MRH.RPR_RSLT_DT" ).append("\n"); 
		query.append("       , MRH.CURR_CD" ).append("\n"); 
		query.append("       , MRH.RPR_YD_CD" ).append("\n"); 
		query.append("       , MRH.EQ_DMG_DT" ).append("\n"); 
		query.append("       , MRH.EQ_DMG_TP_CD" ).append("\n"); 
		query.append("       , MRH.RPR_WRK_TP_CD" ).append("\n"); 
		query.append("       , MRH.MNR_EDI_NM" ).append("\n"); 
		query.append("       , MRH.N3PTY_FLG" ).append("\n"); 
		query.append("       , MRH.IF_TRC_SEQ" ).append("\n"); 
		query.append("       , MRH.MNR_AGMT_AMT" ).append("\n"); 
		query.append("       , MRH.MNR_WRK_AMT" ).append("\n"); 
		query.append("       , MRH.N3PTY_BIL_TTL_AMT" ).append("\n"); 
		query.append("       , MRH.DISP_FLG" ).append("\n"); 
		query.append("       , MRH.DISP_NO" ).append("\n"); 
		query.append("       , MRH.DISP_DTL_SEQ" ).append("\n"); 
		query.append("       , MRH.FILE_SEQ" ).append("\n"); 
		query.append("       , MRH.MNR_RPR_RMK" ).append("\n"); 
		query.append("       , MRH.EDI_ID" ).append("\n"); 
		query.append("       , MRH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("       , MRH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("       , MRH.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("       , MRH.AGMT_SEQ" ).append("\n"); 
		query.append("       , MRH.AGMT_VER_NO" ).append("\n"); 
		query.append("       , MRH.RPR_RQST_TMP_SEQ" ).append("\n"); 
		query.append("       , MRH.RPR_RQST_TMP_VER_NO" ).append("\n"); 
		query.append("       , CASE WHEN (" ).append("\n"); 
		query.append("                     SELECT   COUNT(*)" ).append("\n"); 
		query.append("                     FROM     MNR_EQ_RNG_STS RS" ).append("\n"); 
		query.append("                     WHERE    1 = 1" ).append("\n"); 
		query.append("                     AND      RS.MNR_GRP_TP_CD = 'RPR'" ).append("\n"); 
		query.append("                     AND      RS.LOT_EQ_PFX_CD = SUBSTRB(@[rqst_eq_no],1,4)" ).append("\n"); 
		query.append("                     AND      RS.FM_SER_NO <= SUBSTRB(@[rqst_eq_no], 5, LENGTH(@[rqst_eq_no]) -1)" ).append("\n"); 
		query.append("                     AND      RS.TO_SER_NO >= SUBSTRB(@[rqst_eq_no], 5, LENGTH(@[rqst_eq_no]) -1)" ).append("\n"); 
		query.append("                     AND      SYSDATE BETWEEN RS.FM_WARR_DT AND RS.TO_WARR_DT + 0.99999" ).append("\n"); 
		query.append("                     AND      ROWNUM = 1" ).append("\n"); 
		query.append("                   ) > 0 THEN 'Y'" ).append("\n"); 
		query.append("              ELSE 'N'" ).append("\n"); 
		query.append("         END" ).append("\n"); 
		query.append("       , NVL(MRH.RCT_RPR_FLG,'N') AS RCT_RPR_FLG" ).append("\n"); 
		query.append("       , MRH.VRFY_RSLT_RMK" ).append("\n"); 
		query.append("       , @[rqst_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("       , SYSDATE" ).append("\n"); 
		query.append("       , @[rqst_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("       , SYSDATE" ).append("\n"); 
		query.append("FROM     MNR_RPR_RQST_HDR MRH" ).append("\n"); 
		query.append("       , MNR_EQ_STS_V MES" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      MRH.RQST_EQ_NO = MES.EQ_NO" ).append("\n"); 
		query.append("AND      MRH.RQST_EQ_NO = @[rqst_eq_no]" ).append("\n"); 
		query.append("AND      MRH.RPR_RQST_SEQ = @[rpr_rqst_seq]" ).append("\n"); 
		query.append("AND      MRH.RPR_RQST_VER_NO = @[rpr_rqst_ver_no]" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOSearchBeforeBookingListByDateUserIDRCVRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAExceptionTariffMgtDBDAOSearchBeforeBookingListByDateUserIDRCVRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DEM/DET Adjustment Request & Approval Status 조회(RFA, DATE, Received)용 쿼리
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOSearchBeforeBookingListByDateUserIDRCVRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOSearchBeforeBookingListByDateUserIDRCVRSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT 'TO' AS TO_CC" ).append("\n"); 
		query.append(",	RFA_TRF.RFA_EXPT_DAR_NO AS DAR_NO" ).append("\n"); 
		query.append(",	LPAD(RFA_TRF.RFA_EXPT_VER_SEQ, 3, '0') AS VER_NO" ).append("\n"); 
		query.append(",	RFA_TRF.RFA_EXPT_APRO_NO AS APVL_NO" ).append("\n"); 
		query.append(",	CD_DTL.INTG_CD_VAL_DP_DESC AS STATUS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${group_by} == 'CVRG')" ).append("\n"); 
		query.append(",	RFA_TRF_DTL.RFA_RQST_DTL_SEQ AS DTL_SEQ" ).append("\n"); 
		query.append(",   RFA_TRF_DTL.DMDT_TRF_CD" ).append("\n"); 
		query.append(",	RFA_CVRG.CVRG_CMB_SEQ AS CVRG_SEQ" ).append("\n"); 
		query.append(",	RFA_CVRG.CVRG_CNT_CD AS CNT_CD" ).append("\n"); 
		query.append(",	CASE" ).append("\n"); 
		query.append("WHEN SUBSTR(RFA_CVRG.CVRG_CNT_CD, 1, 2) IN ('CA', 'US')" ).append("\n"); 
		query.append("THEN RFA_CVRG.CVRG_STE_CD" ).append("\n"); 
		query.append("ELSE RFA_CVRG.CVRG_RGN_CD" ).append("\n"); 
		query.append("END AS RGN_CD" ).append("\n"); 
		query.append(",	RFA_CVRG.CVRG_LOC_CD AS LOC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",   RFA_TRF_PROG.PROG_OFC_CD AS REQ_OFC_CD" ).append("\n"); 
		query.append(",	DECODE(RFA_TRF.DMDT_EXPT_RQST_STS_CD, 'C', '', RFA_TRF_PROG2.PROG_OFC_CD) AS APRO_OFC_CD" ).append("\n"); 
		query.append(",   TO_CHAR(RFA_TRF.UPD_DT, 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append(",   RP_HDR.RFA_NO" ).append("\n"); 
		query.append(",   RP_HDR.PROP_NO" ).append("\n"); 
		query.append(",   RP_MN.CTRT_CUST_CNT_CD || LPAD(RP_MN.CTRT_CUST_SEQ, 6, '0') CUST_CD" ).append("\n"); 
		query.append(",   CUST.CUST_LGL_ENG_NM CUST_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    DMT_RFA_EXPT_TRF RFA_TRF" ).append("\n"); 
		query.append(",   DMT_RFA_EXPT_TRF_PROG RFA_TRF_PROG" ).append("\n"); 
		query.append(",   DMT_RFA_EXPT_TRF_PROG RFA_TRF_PROG2" ).append("\n"); 
		query.append(",	PRI_RP_HDR RP_HDR" ).append("\n"); 
		query.append(",	PRI_RP_MN RP_MN" ).append("\n"); 
		query.append(",	DMT_RFA_EXPT_TRF_DTL RFA_TRF_DTL" ).append("\n"); 
		query.append("#if(${group_by} == 'CVRG')" ).append("\n"); 
		query.append(",	DMT_RFA_EXPT_CVRG_CMB RFA_CVRG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	COM_INTG_CD_DTL CD_DTL" ).append("\n"); 
		query.append(",   MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE   RFA_TRF.RFA_EXPT_DAR_NO = RFA_TRF_PROG.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND RFA_TRF.RFA_EXPT_MAPG_SEQ = RFA_TRF_PROG.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("AND RFA_TRF.RFA_EXPT_VER_SEQ = RFA_TRF_PROG.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND	RFA_TRF.RFA_EXPT_DAR_NO = RFA_TRF_PROG2.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND RFA_TRF.RFA_EXPT_MAPG_SEQ = RFA_TRF_PROG2.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("AND RFA_TRF.RFA_EXPT_VER_SEQ = RFA_TRF_PROG2.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND RFA_TRF.DMDT_EXPT_RQST_STS_CD IN ('A', 'C', 'J', 'O')" ).append("\n"); 
		query.append("AND RFA_TRF.UPD_DT BETWEEN TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("AND RFA_TRF_PROG.PROG_SEQ =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  /*+ INDEX_DESC(DMT_RFA_EXPT_TRF_PROG XPKDMT_RFA_EXPT_TRF_PROG) */ PROG_SEQ" ).append("\n"); 
		query.append("FROM    DMT_RFA_EXPT_TRF_PROG" ).append("\n"); 
		query.append("WHERE   RFA_EXPT_DAR_NO = RFA_TRF_PROG.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND RFA_EXPT_MAPG_SEQ = RFA_TRF_PROG.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("AND RFA_EXPT_VER_SEQ = RFA_TRF_PROG.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND DMDT_EXPT_RQST_STS_CD = 'R'" ).append("\n"); 
		query.append("AND	ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND RFA_TRF_PROG.PROG_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("AND RFA_TRF_PROG2.PROG_SEQ =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  /*+ INDEX_DESC(DMT_RFA_EXPT_TRF_PROG XPKDMT_RFA_EXPT_TRF_PROG) */ PROG_SEQ" ).append("\n"); 
		query.append("FROM    DMT_RFA_EXPT_TRF_PROG" ).append("\n"); 
		query.append("WHERE   RFA_EXPT_DAR_NO = RFA_TRF_PROG2.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND RFA_EXPT_MAPG_SEQ = RFA_TRF_PROG2.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("AND RFA_EXPT_VER_SEQ = RFA_TRF_PROG2.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND DMDT_EXPT_RQST_STS_CD IN ('A', 'C', 'J', 'O')" ).append("\n"); 
		query.append("AND	ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND	RFA_TRF.PROP_NO = RP_HDR.PROP_NO" ).append("\n"); 
		query.append("AND RP_HDR.PROP_NO = RP_MN.PROP_NO" ).append("\n"); 
		query.append("AND RP_MN.AMDT_SEQ =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	/*+ INDEX_DESC(PRI_RP_MN XPKPRI_RP_MN) */ AMDT_SEQ" ).append("\n"); 
		query.append("FROM	PRI_RP_MN" ).append("\n"); 
		query.append("WHERE	PROP_NO = RP_MN.PROP_NO" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cust_cd} != '')" ).append("\n"); 
		query.append("AND RP_MN.CTRT_CUST_CNT_CD = SUBSTR(@[cust_cd], 0, 2) AND RP_MN.CTRT_CUST_SEQ = SUBSTR(@[cust_cd], 3)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND RP_MN.CTRT_CUST_CNT_CD = CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("AND RP_MN.CTRT_CUST_SEQ = CUST.CUST_SEQ" ).append("\n"); 
		query.append("AND RFA_TRF.RFA_EXPT_DAR_NO = RFA_TRF_DTL.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND RFA_TRF.RFA_EXPT_MAPG_SEQ = RFA_TRF_DTL.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("AND RFA_TRF.RFA_EXPT_VER_SEQ = RFA_TRF_DTL.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND RFA_TRF_DTL.DMDT_TRF_CD IN (" ).append("\n"); 
		query.append("#foreach( $trf_cd in ${trf_cd_list} )" ).append("\n"); 
		query.append("#if($velocityCount < $trf_cd_list.size()) '$trf_cd', #else '$trf_cd' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${group_by} == 'CVRG')" ).append("\n"); 
		query.append("AND RFA_TRF_DTL.RFA_EXPT_DAR_NO = RFA_CVRG.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND RFA_TRF_DTL.RFA_EXPT_MAPG_SEQ = RFA_CVRG.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("AND RFA_TRF_DTL.RFA_EXPT_VER_SEQ = RFA_CVRG.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND RFA_TRF_DTL.RFA_RQST_DTL_SEQ = RFA_CVRG.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("AND RFA_CVRG.CVRG_CMB_SEQ =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	/*+ INDEX_ASC(DMT_RFA_EXPT_CVRG_CMB XPKDMT_RFA_EXPT_CVRG_CMB) */ CVRG_CMB_SEQ" ).append("\n"); 
		query.append("FROM	DMT_RFA_EXPT_CVRG_CMB" ).append("\n"); 
		query.append("WHERE	RFA_EXPT_DAR_NO = RFA_CVRG.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND	RFA_EXPT_MAPG_SEQ = RFA_CVRG.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("AND RFA_EXPT_VER_SEQ = RFA_CVRG.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND RFA_RQST_DTL_SEQ = RFA_CVRG.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND RFA_TRF.DMDT_EXPT_RQST_STS_CD = CD_DTL.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND CD_DTL.INTG_CD_ID = 'CD02069'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY UPD_DT, DAR_NO #if(${group_by} == 'CVRG'),	DTL_SEQ, CVRG_SEQ#end" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOSearchSCTariffListByDateUserIDRCVRSQL.java
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

public class RFAExceptionTariffMgtDBDAOSearchSCTariffListByDateUserIDRCVRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DEM/DET Adjustment Request & Approval Status 조회(SC, DATE, Received)용 쿼리
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOSearchSCTariffListByDateUserIDRCVRSQL(){
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
		query.append("FileName : RFAExceptionTariffMgtDBDAOSearchSCTariffListByDateUserIDRCVRSQL").append("\n"); 
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
		query.append("SELECT	DISTINCT 'TO' AS TO_CC" ).append("\n"); 
		query.append(",	SP_HDR.SC_NO" ).append("\n"); 
		query.append(",	LPAD(SC_VER.SC_EXPT_VER_SEQ, 3, '0') AS VER_NO" ).append("\n"); 
		query.append(",	CD_DTL.INTG_CD_VAL_DP_DESC AS STATUS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${group_by} == 'CVRG')" ).append("\n"); 
		query.append(",	SC_GRP.SC_EXPT_GRP_SEQ AS GRP_SEQ" ).append("\n"); 
		query.append(",   SC_GRP.DMDT_TRF_CD" ).append("\n"); 
		query.append(",	SC_CVRG.CVRG_SEQ" ).append("\n"); 
		query.append(",	SC_CVRG.CNT_CD" ).append("\n"); 
		query.append(",	CASE" ).append("\n"); 
		query.append("WHEN SUBSTR(SC_CVRG.CNT_CD, 1, 2) IN ('CA', 'US')" ).append("\n"); 
		query.append("THEN SC_CVRG.STE_CD" ).append("\n"); 
		query.append("ELSE SC_CVRG.RGN_CD" ).append("\n"); 
		query.append("END AS RGN_CD" ).append("\n"); 
		query.append(",	SC_CVRG.LOC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",   SC_VER_PROG.PROG_OFC_CD AS REQ_OFC_CD" ).append("\n"); 
		query.append(",   DECODE(SC_VER.DMDT_EXPT_VER_STS_CD, 'D', '', SC_VER_PROG2.PROG_OFC_CD) AS APRO_OFC_CD" ).append("\n"); 
		query.append(",   TO_CHAR(SC_VER_PROG.PROG_DT, 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append(",   SC_VER.PROP_NO" ).append("\n"); 
		query.append(",   SP_PTY.CUST_CNT_CD || LPAD(SP_PTY.CUST_SEQ, 6, '0') AS CUST_CD" ).append("\n"); 
		query.append(",   CUST.CUST_LGL_ENG_NM AS CUST_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	DMT_SC_EXPT_VER SC_VER" ).append("\n"); 
		query.append(",	DMT_SC_EXPT_VER_PROG SC_VER_PROG" ).append("\n"); 
		query.append(",	DMT_SC_EXPT_VER_PROG SC_VER_PROG2" ).append("\n"); 
		query.append(",	DMT_SC_EXPT_GRP SC_GRP" ).append("\n"); 
		query.append("#if(${group_by} == 'CVRG')" ).append("\n"); 
		query.append(",	DMT_SC_EXPT_CVRG SC_CVRG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	PRI_SP_HDR SP_HDR" ).append("\n"); 
		query.append(",	PRI_SP_MN SP_MN" ).append("\n"); 
		query.append(",	PRI_SP_CTRT_PTY	SP_PTY" ).append("\n"); 
		query.append(",	COM_INTG_CD_DTL CD_DTL" ).append("\n"); 
		query.append(",   MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	SC_VER.PROP_NO = SC_VER_PROG.PROP_NO" ).append("\n"); 
		query.append("AND	SC_VER.SC_EXPT_VER_SEQ = SC_VER_PROG.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND SC_VER.PROP_NO = SC_VER_PROG2.PROP_NO" ).append("\n"); 
		query.append("AND	SC_VER.SC_EXPT_VER_SEQ = SC_VER_PROG2.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND SC_VER.DMDT_EXPT_VER_STS_CD IN ('A', 'D', 'L')" ).append("\n"); 
		query.append("AND SC_VER.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND SC_VER.UPD_DT BETWEEN TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("AND SC_VER_PROG.PROG_SEQ =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  /*+ INDEX_DESC(DMT_SC_EXPT_VER_PROG XPKDMT_SC_EXPT_VER_PROG) */ PROG_SEQ" ).append("\n"); 
		query.append("FROM    DMT_SC_EXPT_VER_PROG" ).append("\n"); 
		query.append("WHERE   PROP_NO = SC_VER_PROG.PROP_NO" ).append("\n"); 
		query.append("AND SC_EXPT_VER_SEQ = SC_VER_PROG.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND DMDT_EXPT_VER_STS_CD = 'R'" ).append("\n"); 
		query.append("AND	ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND SC_VER_PROG.PROG_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("AND SC_VER_PROG2.PROG_SEQ =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  /*+ INDEX_DESC(DMT_SC_EXPT_VER_PROG XPKDMT_SC_EXPT_VER_PROG) */ PROG_SEQ" ).append("\n"); 
		query.append("FROM    DMT_SC_EXPT_VER_PROG" ).append("\n"); 
		query.append("WHERE   PROP_NO = SC_VER_PROG2.PROP_NO" ).append("\n"); 
		query.append("AND SC_EXPT_VER_SEQ = SC_VER_PROG2.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND DMDT_EXPT_VER_STS_CD IN ('A', 'D', 'L')" ).append("\n"); 
		query.append("AND	ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND	SC_VER.PROP_NO = SP_HDR.PROP_NO" ).append("\n"); 
		query.append("AND SP_HDR.PROP_NO = SP_MN.PROP_NO" ).append("\n"); 
		query.append("AND SP_MN.AMDT_SEQ =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	/*+ INDEX_DESC(PRI_SP_MN XPKPRI_SP_MN) */ AMDT_SEQ" ).append("\n"); 
		query.append("FROM	PRI_SP_MN" ).append("\n"); 
		query.append("WHERE	PROP_NO = SP_MN.PROP_NO" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND SP_MN.PROP_NO = SP_PTY.PROP_NO" ).append("\n"); 
		query.append("AND SP_MN.AMDT_SEQ = SP_PTY.AMDT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cust_cd} != '')" ).append("\n"); 
		query.append("AND SP_PTY.CUST_CNT_CD = SUBSTR(@[cust_cd], 0, 2) AND SP_PTY.CUST_SEQ = SUBSTR(@[cust_cd], 3)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND SP_PTY.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("AND SP_PTY.CUST_CNT_CD = CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("AND SP_PTY.CUST_SEQ = CUST.CUST_SEQ" ).append("\n"); 
		query.append("AND SC_VER.PROP_NO = SC_GRP.PROP_NO" ).append("\n"); 
		query.append("AND SC_VER.SC_EXPT_VER_SEQ = SC_GRP.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND SC_GRP.DMDT_TRF_CD IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("#foreach( $trf_cd in ${trf_cd_list} )" ).append("\n"); 
		query.append("#if($velocityCount < $trf_cd_list.size()) '$trf_cd', #else '$trf_cd' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${group_by} == 'CVRG')" ).append("\n"); 
		query.append("AND SC_GRP.PROP_NO = SC_CVRG.PROP_NO" ).append("\n"); 
		query.append("AND SC_GRP.SC_EXPT_VER_SEQ = SC_CVRG.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND SC_GRP.SC_EXPT_GRP_SEQ = SC_CVRG.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND SC_VER.DMDT_EXPT_VER_STS_CD = CD_DTL.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND CD_DTL.INTG_CD_ID = 'CD01972'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY UPD_DT, PROP_NO #if(${group_by} == 'CVRG'), GRP_SEQ,	CVRG_SEQ #end" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TariffMgtDBDAOsearchDefaultRepairTariffDetailDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.10.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.10.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffMgtDBDAOsearchDefaultRepairTariffDetailDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public TariffMgtDBDAOsearchDefaultRepairTariffDetailDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.integration").append("\n"); 
		query.append("FileName : TariffMgtDBDAOsearchDefaultRepairTariffDetailDataRSQL").append("\n"); 
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
		query.append("SELECT   'NEW' AS TRF_NO" ).append("\n"); 
		query.append("       , A.TRF_DTL_SEQ" ).append("\n"); 
		query.append("       , A.COST_GRP_CD" ).append("\n"); 
		query.append("       , A.EQ_CMPO_CD" ).append("\n"); 
		query.append("       , A.EQ_RPR_CD" ).append("\n"); 
		query.append("       , A.TRF_DIV_CD" ).append("\n"); 
		query.append("       , A.TRF_OPT_CD" ).append("\n"); 
		query.append("       , A.DTL_DESC" ).append("\n"); 
		query.append("       , A.FM_RNG_SZ_NO" ).append("\n"); 
		query.append("       , MNR_COMMON_PKG.MNR_CONV_MEASURE_FNC(A.VOL_TP_CD, B.MNR_MEAS_UT_CD, A.FM_RNG_SZ_NO, 'INC') AS INCH_FM" ).append("\n"); 
		query.append("       , MNR_COMMON_PKG.MNR_CONV_MEASURE_FNC(A.VOL_TP_CD, B.MNR_MEAS_UT_CD, A.FM_RNG_SZ_NO, 'CMT') AS CM_FM" ).append("\n"); 
		query.append("       , A.TO_RNG_SZ_NO" ).append("\n"); 
		query.append("       , MNR_COMMON_PKG.MNR_CONV_MEASURE_FNC(A.VOL_TP_CD, B.MNR_MEAS_UT_CD, A.TO_RNG_SZ_NO, 'INC') AS INCH_TO" ).append("\n"); 
		query.append("       , MNR_COMMON_PKG.MNR_CONV_MEASURE_FNC(A.VOL_TP_CD, B.MNR_MEAS_UT_CD, A.TO_RNG_SZ_NO, 'CMT') AS CM_TO" ).append("\n"); 
		query.append("       , A.MNR_RNG_TP_CD" ).append("\n"); 
		query.append("       , A.MNR_RNG_TP_CD AS MNR_RNG_TP_CD_VIEW" ).append("\n"); 
		query.append("       , A.VOL_TP_CD" ).append("\n"); 
		query.append("       , A.VOL_TP_CD AS VOL_TP_CD_VIEW" ).append("\n"); 
		query.append("       , A.RPR_QTY" ).append("\n"); 
		query.append("       , A.RPR_SZ_NO" ).append("\n"); 
		query.append("       , MNR_COMMON_PKG.MNR_CONV_MEASURE_FNC(A.VOL_TP_CD, B.MNR_MEAS_UT_CD, A.RPR_SZ_NO, 'INC') AS INCH_SIZE" ).append("\n"); 
		query.append("       , MNR_COMMON_PKG.MNR_CONV_MEASURE_FNC(A.VOL_TP_CD, B.MNR_MEAS_UT_CD, A.RPR_SZ_NO, 'CMT') AS CM_SIZE" ).append("\n"); 
		query.append("       , A.RPR_LBR_HRS" ).append("\n"); 
		query.append("       , A.MTRL_COST_AMT" ).append("\n"); 
		query.append("       , A.XCH_MTRL_COST_AMT" ).append("\n"); 
		query.append("       , A.MTRL_RECO_AMT" ).append("\n"); 
		query.append("       , A.MNR_VRFY_TP_CD" ).append("\n"); 
		query.append("       , A.MAPG_RSLT_CD" ).append("\n"); 
		query.append("       , A.DTL_RMK" ).append("\n"); 
		query.append("       , A.CRE_USR_ID" ).append("\n"); 
		query.append("       , TO_CHAR(A.CRE_DT, 'yyyy-mm-dd') AS CRE_DT" ).append("\n"); 
		query.append("       , A.UPD_USR_ID" ).append("\n"); 
		query.append("       , TO_CHAR(A.UPD_DT, 'yyyy-mm-dd') AS UPD_DT" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   SUBSTR(MAX(DECODE(SUBSTR(A.COST_GRP_CD, 2, 2)||G2.EQ_PRNT_CMPO_CD, 'RDK1', '5'||G2.EQ_CMPO_NM" ).append("\n"); 
		query.append("                                                                                     , 'RDK4', '4'||G2.EQ_CMPO_NM" ).append("\n"); 
		query.append("                                                                                     , 'RDK5', '3'||G2.EQ_CMPO_NM" ).append("\n"); 
		query.append("                                                                                     , 'RDK6', '2'||G2.EQ_CMPO_NM" ).append("\n"); 
		query.append("                                                                                     , 'DSK1', '5'||G2.EQ_CMPO_NM" ).append("\n"); 
		query.append("                                                                                     , 'DSK4', '4'||G2.EQ_CMPO_NM" ).append("\n"); 
		query.append("                                                                                     , 'DSK5', '3'||G2.EQ_CMPO_NM" ).append("\n"); 
		query.append("                                                                                     , 'DSK6', '2'||G2.EQ_CMPO_NM" ).append("\n"); 
		query.append("                                                                                     , 'RRK6', '5'||G2.EQ_CMPO_NM" ).append("\n"); 
		query.append("                                                                                     , 'RRK5', '4'||G2.EQ_CMPO_NM" ).append("\n"); 
		query.append("                                                                                     , 'RRK4', '3'||G2.EQ_CMPO_NM" ).append("\n"); 
		query.append("                                                                                     , 'RRK1', '2'||G2.EQ_CMPO_NM" ).append("\n"); 
		query.append("                                                                                     ,         '1'||G2.EQ_CMPO_NM" ).append("\n"); 
		query.append("                    )), 2)" ).append("\n"); 
		query.append("           FROM     MNR_EQ_CMPO_CD G3, MNR_EQ_CMPO_CD G2" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      G3.EQ_CMPO_GRP_TP_CD = 3" ).append("\n"); 
		query.append("           AND      G2.EQ_CMPO_GRP_TP_CD = 2" ).append("\n"); 
		query.append("           AND      G3.EQ_PRNT_CMPO_CD = G2.EQ_CMPO_CD" ).append("\n"); 
		query.append("           AND      G3.EQ_CMPO_CD = A.EQ_CMPO_CD" ).append("\n"); 
		query.append("           GROUP BY G3.EQ_CMPO_CD					   					   " ).append("\n"); 
		query.append("         ) AS EQ_CMPO_UP_CD" ).append("\n"); 
		query.append("       , A.TRF_NO AS STD_TRF_NO		" ).append("\n"); 
		query.append("FROM     MNR_RPR_TRF_DTL A" ).append("\n"); 
		query.append("       , MNR_RPR_TRF_HDR B  " ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      A.COST_GRP_CD = @[cost_grp_cd]" ).append("\n"); 
		query.append("AND      A.TRF_NO = B.TRF_NO" ).append("\n"); 
		query.append("AND      B.MNR_TRF_KND_CD = 'STD'" ).append("\n"); 
		query.append("AND      B.MNR_TRF_STS_CD = 'HA'" ).append("\n"); 
		query.append("AND      B.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND      B.EFF_DT =" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("           SELECT   MAX(C.EFF_DT)" ).append("\n"); 
		query.append("           FROM     MNR_RPR_TRF_HDR C" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      C.MNR_TRF_KND_CD = 'STD'" ).append("\n"); 
		query.append("           AND      C.MNR_TRF_STS_CD = 'HA'" ).append("\n"); 
		query.append("           AND      TO_CHAR(C.EFF_DT,'YYYYMMDD') <= TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("           AND      C.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}
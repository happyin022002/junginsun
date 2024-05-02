/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOUpdateWorkOrderPreviewScgDtlFuelRtoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOUpdateWorkOrderPreviewScgDtlFuelRtoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrderPreviewDBDAOUpdateWorkOrderPreviewScgDtlFuelRto
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOUpdateWorkOrderPreviewScgDtlFuelRtoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration ").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOUpdateWorkOrderPreviewScgDtlFuelRtoUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_SCG_DTL T" ).append("\n"); 
		query.append("   SET T.FUEL_RTO =" ).append("\n"); 
		query.append("       (SELECT DECODE(AGMT_SCG_RT_DIV_CD, 'F', '0', 'R', FUEL_SURCHARGE_RATE_OR_PERCENT, '') FUEL_SURCHARGE_RATE_OR_PERCENT" ).append("\n"); 
		query.append("          FROM (SELECT E.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                      ,E.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                      ,E.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                      ,C.TRSP_SCG_CD" ).append("\n"); 
		query.append("                      ,CASE" ).append("\n"); 
		query.append("                         WHEN E.TRSP_AGMT_EQ_TP_SZ_CD IS NULL THEN 9" ).append("\n"); 
		query.append("                         WHEN E.TRSP_AGMT_EQ_TP_SZ_CD = 'ALAL' THEN 4" ).append("\n"); 
		query.append("                         WHEN E.TRSP_AGMT_EQ_TP_SZ_CD LIKE '%AL%' THEN 2" ).append("\n"); 
		query.append("                         WHEN E.TRSP_AGMT_EQ_TP_SZ_CD = O.EQ_TPSZ_CD THEN 1" ).append("\n"); 
		query.append("                         ELSE 3" ).append("\n"); 
		query.append("                       END EQ_TPSZ_PRIOR_ORDER" ).append("\n"); 
		query.append("                      ,E.CURR_CD AS LOCAL_SCG_CURR_CD_OR_PERCENT" ).append("\n"); 
		query.append("                      ,NVL(E.TRSP_ONE_WY_RT, E.TRSP_RND_RT) FUEL_SURCHARGE_RATE_OR_PERCENT" ).append("\n"); 
		query.append("                      ,E.AGMT_SCG_RT_DIV_CD" ).append("\n"); 
		query.append("                      ,C.TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append("                      ,E.TRSP_AGMT_SCG_RT_SEQ" ).append("\n"); 
		query.append("                      ,B.TRSP_BND_CD" ).append("\n"); 
		query.append("                      ,B.SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("                  FROM TRS_AGMT_APLY_VNDR A" ).append("\n"); 
		query.append("                      ,TRS_AGMT_RT_TP     B" ).append("\n"); 
		query.append("                      ,TRS_AGMT_SCG_NOD   C" ).append("\n"); 
		query.append("                      ,TRS_AGMT_SCG_RT    E" ).append("\n"); 
		query.append("                      ,TRS_TRSP_SVC_ORD   O" ).append("\n"); 
		query.append("                 WHERE O.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("                   AND O.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("                   AND A.TRSP_AGMT_OFC_CTY_CD = B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND A.TRSP_AGMT_SEQ = B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                   AND B.TRSP_AGMT_OFC_CTY_CD = C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND B.TRSP_AGMT_SEQ = C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                   AND B.TRSP_AGMT_RT_TP_SER_NO = C.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                   AND C.TRSP_AGMT_OFC_CTY_CD = E.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND C.TRSP_AGMT_SEQ = E.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                   AND C.TRSP_AGMT_RT_TP_SER_NO = E.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("                   AND C.TRSP_AGMT_SCG_NOD_SEQ = E.TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append("                   AND B.TRSP_AGMT_OFC_CTY_CD = O.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND B.TRSP_AGMT_SEQ = O.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                   AND C.TRSP_SCG_CD IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                          WHERE INTG_CD_ID = 'CD30002'" ).append("\n"); 
		query.append("                                            AND INTG_CD_VAL_CTNT IN ('SCFAAL', 'SCFCAL'))" ).append("\n"); 
		query.append("                   AND E.EQ_KND_CD = O.EQ_KND_CD" ).append("\n"); 
		query.append("                   AND DECODE(O.EQ_KND_CD, 'USRAIL', '0', A.VNDR_SEQ) = DECODE(O.EQ_KND_CD, 'USRAIL', '0', O.VNDR_SEQ)" ).append("\n"); 
		query.append("                   AND C.AGMT_ROUT_ALL_FLG = CASE" ).append("\n"); 
		query.append("                         WHEN C.FM_NOD_CD = '0000000' AND C.TO_NOD_CD = '0000000' THEN  'Y'" ).append("\n"); 
		query.append("                         ELSE 'N'" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("                   AND C.FM_NOD_CD = CASE" ).append("\n"); 
		query.append("                         WHEN C.TRSP_SCG_CD = 'SCFAAL' THEN '0000000'" ).append("\n"); 
		query.append("                         ELSE DECODE(LENGTH(C.FM_NOD_CD), 7, O.FM_NOD_CD, 5, SUBSTR(O.FM_NOD_CD, 1, 5))" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("                   AND C.VIA_NOD_CD = CASE" ).append("\n"); 
		query.append("                         WHEN C.TRSP_SCG_CD = 'SCFAAL' THEN '0000000'" ).append("\n"); 
		query.append("                         ELSE NVL(DECODE(LENGTH(C.VIA_NOD_CD), 7, O.VIA_NOD_CD, 5, SUBSTR(O.VIA_NOD_CD, 1, 5)), '0000000')" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("                   AND C.DOR_NOD_CD = CASE" ).append("\n"); 
		query.append("                         WHEN C.TRSP_SCG_CD = 'SCFAAL' THEN '0000000'" ).append("\n"); 
		query.append("                         ELSE NVL(DECODE(LENGTH(C.DOR_NOD_CD), 7, O.DOR_NOD_CD, 5, SUBSTR(O.DOR_NOD_CD, 1, 5)), '0000000')" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("                   AND C.TO_NOD_CD = CASE" ).append("\n"); 
		query.append("                         WHEN C.TRSP_SCG_CD = 'SCFAAL' THEN '0000000'" ).append("\n"); 
		query.append("                         ELSE DECODE(LENGTH(C.TO_NOD_CD), 7, O.TO_NOD_CD, 5, SUBSTR(O.TO_NOD_CD, 1, 5))" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("                   AND E.EFF_FM_DT <= O.CRE_DT" ).append("\n"); 
		query.append("                   AND E.EFF_TO_DT >= O.CRE_DT" ).append("\n"); 
		query.append("                   AND CASE" ).append("\n"); 
		query.append("                         WHEN C.TRSP_SCG_CD = 'SCOWAL' THEN TRS_COMMON_PKG.GET_CONV_WGT_TO_KG_FNC(E.WGT_MEAS_UT_CD, E.TO_WGT)" ).append("\n"); 
		query.append("                         ELSE 1" ).append("\n"); 
		query.append("                       END > CASE" ).append("\n"); 
		query.append("                         WHEN C.TRSP_SCG_CD = 'SCOWAL' THEN TRS_COMMON_PKG.GET_CONV_WGT_TO_KG_FNC(O.WGT_MEAS_UT_CD, O.CNTR_WGT)" ).append("\n"); 
		query.append("                         ELSE 0" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("                   AND E.TRSP_AGMT_EQ_TP_SZ_CD IN (O.EQ_TPSZ_CD, SUBSTR(O.EQ_TPSZ_CD, 1, 1) || 'AL', 'AL' || SUBSTR(O.EQ_TPSZ_CD, 2, 1), 'ALAL')" ).append("\n"); 
		query.append("                   AND CASE" ).append("\n"); 
		query.append("                         WHEN O.TRSP_CRR_MOD_CD IN ('WD', 'WT', 'TW', 'WR', 'RW') AND O.TRSP_BND_CD = 'T' THEN DECODE(B.TRSP_BND_CD, NULL, 'T', 'A', 'T', B.TRSP_BND_CD)" ).append("\n"); 
		query.append("                         ELSE 'T'" ).append("\n"); 
		query.append("                       END = 'T'" ).append("\n"); 
		query.append("                   AND (B.SPCL_CGO_CNTR_TP_CD IS NULL OR CASE" ).append("\n"); 
		query.append("                         WHEN O.SPCL_CGO_CNTR_TP_CD IS NULL THEN B.SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("                         ELSE O.SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("                       END = B.SPCL_CGO_CNTR_TP_CD)" ).append("\n"); 
		query.append("                 ORDER BY C.TRSP_SCG_CD DESC" ).append("\n"); 
		query.append("                         ,EQ_TPSZ_PRIOR_ORDER ASC" ).append("\n"); 
		query.append("                         ,B.CMDT_GRP_CD ASC" ).append("\n"); 
		query.append("                         ,LENGTH(DECODE(C.FM_NOD_CD, '0000000', 'N/A', C.FM_NOD_CD)) DESC" ).append("\n"); 
		query.append("                         ,LENGTH(DECODE(C.VIA_NOD_CD, '0000000', 'N/A', C.VIA_NOD_CD)) DESC" ).append("\n"); 
		query.append("                         ,LENGTH(DECODE(C.DOR_NOD_CD, '0000000', 'N/A', C.DOR_NOD_CD)) DESC" ).append("\n"); 
		query.append("                         ,LENGTH(DECODE(C.TO_NOD_CD, '0000000', 'N/A', C.TO_NOD_CD)) DESC" ).append("\n"); 
		query.append("                         ,CASE" ).append("\n"); 
		query.append("                            WHEN O.TRSP_CRR_MOD_CD IN ('WD', 'WT', 'TW', 'WR', 'RW') AND O.TRSP_BND_CD = 'T' THEN B.TRSP_BND_CD" ).append("\n"); 
		query.append("                            ELSE NULL" ).append("\n"); 
		query.append("                          END DESC" ).append("\n"); 
		query.append("                         ,B.SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("                         ,E.TRSP_AGMT_SCG_RT_SEQ DESC" ).append("\n"); 
		query.append("                         ,NVL(E.TRSP_ONE_WY_RT, E.TRSP_RND_RT))" ).append("\n"); 
		query.append("         WHERE ROWNUM = 1)" ).append("\n"); 
		query.append(" WHERE TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("   AND SUBSTR(T.LGS_COST_CD, 3, 2) = 'FU'" ).append("\n"); 

	}
}
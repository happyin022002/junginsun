/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCReportDBDAORsltSearchSCPerformanceDetailSumRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltSearchSCPerformanceDetailSumRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * sc performance detail sum
	  * </pre>
	  */
	public SCReportDBDAORsltSearchSCPerformanceDetailSumRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_obrd_dt_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_obrd_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltSearchSCPerformanceDetailSumRSQL").append("\n"); 
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
		query.append("WITH" ).append("\n"); 
		query.append("SC AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  NVL(MQ.FNL_MQC_QTY, 0) FNL_MQC_QTY ," ).append("\n"); 
		query.append("        DU.CTRT_EFF_DT                     ," ).append("\n"); 
		query.append("        DU.CTRT_EXP_DT                     ," ).append("\n"); 
		query.append("        NVL(" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  SUM( BQ.OP_CNTR_QTY * ( SELECT PRI_SC_FEU_CONV(BK.SVC_SCP_CD, BQ.CNTR_TPSZ_CD) FROM DUAL) )" ).append("\n"); 
		query.append("        FROM    BKG_BOOKING       BK  ," ).append("\n"); 
		query.append("                BKG_QUANTITY      BQ  ," ).append("\n"); 
		query.append("                BKG_VVD           BV  ," ).append("\n"); 
		query.append("                VSK_VSL_PORT_SKD  PS" ).append("\n"); 
		query.append("        WHERE   BQ.BKG_NO       = BK.BKG_NO" ).append("\n"); 
		query.append("        AND     BV.BKG_NO       = BK.BKG_NO" ).append("\n"); 
		query.append("        AND     NOT EXISTS  (" ).append("\n"); 
		query.append("                            SELECT  'X'" ).append("\n"); 
		query.append("                            FROM    BKG_VVD A" ).append("\n"); 
		query.append("                            WHERE   A.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("                            AND     A.VSL_PRE_PST_CD||A.VSL_SEQ < BV.VSL_PRE_PST_CD||BV.VSL_SEQ" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("        AND     PS.VSL_CD       = BV.VSL_CD" ).append("\n"); 
		query.append("        AND     PS.SKD_VOY_NO   = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND     PS.SKD_DIR_CD   = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND     PS.VPS_PORT_CD  = BV.POL_CD" ).append("\n"); 
		query.append("        AND     PS.CLPT_IND_SEQ = BV.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("        AND     BK.SC_NO        = SH.SC_NO" ).append("\n"); 
		query.append("        AND     BK.BKG_STS_CD   = 'F'" ).append("\n"); 
		query.append("        AND     PS.VPS_ETD_DT   <= TO_DATE(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC, SYSDATE, BK.POL_CD))" ).append("\n"); 
		query.append("        #if (${bl_obrd_dt_from} != '')" ).append("\n"); 
		query.append("        AND     PS.VPS_ETD_DT   >= TO_DATE(@[bl_obrd_dt_from], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${bl_obrd_dt_to} != '')" ).append("\n"); 
		query.append("        AND     PS.VPS_ETD_DT   <= TO_DATE (@[bl_obrd_dt_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        AND     BQ.CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("        ), 0) OP_CNTR_QTY" ).append("\n"); 
		query.append("FROM    PRI_SP_HDR  SH  ," ).append("\n"); 
		query.append("        PRI_SP_MN   SM  ," ).append("\n"); 
		query.append("        PRI_SP_DUR  DU  ," ).append("\n"); 
		query.append("        PRI_SP_MQC  MQ" ).append("\n"); 
		query.append("WHERE   SM.PROP_NO  = SH.PROP_NO" ).append("\n"); 
		query.append("AND     SM.AMDT_SEQ = (" ).append("\n"); 
		query.append("                       SELECT   MAX(A.AMDT_SEQ)" ).append("\n"); 
		query.append("                       FROM     PRI_SP_MN   A" ).append("\n"); 
		query.append("                       WHERE    A.PROP_NO     = SH.PROP_NO" ).append("\n"); 
		query.append("                       AND      A.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("AND     DU.PROP_NO   = SM.PROP_NO" ).append("\n"); 
		query.append("AND     DU.AMDT_SEQ  = SM.AMDT_SEQ" ).append("\n"); 
		query.append("AND     MQ.PROP_NO   = SM.PROP_NO" ).append("\n"); 
		query.append("AND     MQ.AMDT_SEQ  = SM.AMDT_SEQ" ).append("\n"); 
		query.append("AND     SH.SC_NO     = @[sc_no]  -- S/C No" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  ROUND(FNL_MQC_QTY, 0) AS FNL_MQC_QTY," ).append("\n"); 
		query.append("        ROUND(OP_CNTR_QTY, 1) AS OP_CNTR_QTY," ).append("\n"); 
		query.append("        ROUND(DECODE(FNL_MQC_QTY, 0, 0, OP_CNTR_QTY * 100 / FNL_MQC_QTY), 1) AS MQC_PERF ," ).append("\n"); 
		query.append("        ROUND(DECODE(FNL_MQC_QTY, 0, 0, OP_CNTR_QTY * 100 / ( FNL_MQC_QTY * FLOOR(LEAST(SYSDATE, CTRT_EXP_DT) - CTRT_EFF_DT + 1) / FLOOR(CTRT_EXP_DT - CTRT_EFF_DT + 1) ) ), 1) AS PRO_RT_MQC_PERF" ).append("\n"); 
		query.append("        ,'' AS SC_NO" ).append("\n"); 
		query.append("        ,'' AS BL_OBRD_DT_FROM" ).append("\n"); 
		query.append("        ,'' AS BL_OBRD_DT_TO" ).append("\n"); 
		query.append("FROM    SC" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCReportDBDAORsltSearchSCBlListRSQL.java
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

public class SCReportDBDAORsltSearchSCBlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * sc performance summary - view bl
	  * </pre>
	  */
	public SCReportDBDAORsltSearchSCBlListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltSearchSCBlListRSQL").append("\n"); 
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
		query.append("SELECT  BK.BL_NO  ," ).append("\n"); 
		query.append("        BK.VVD    ," ).append("\n"); 
		query.append("        (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER MC WHERE MC.CUST_CNT_CD = BK.S_CUST_CNT_CD AND MC.CUST_SEQ = BK.S_CUST_SEQ AND MC.CNTR_DIV_FLG = 'Y') S_CUST_NM ," ).append("\n"); 
		query.append("        (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER MC WHERE MC.CUST_CNT_CD = BK.C_CUST_CNT_CD AND MC.CUST_SEQ = BK.C_CUST_SEQ AND MC.CNTR_DIV_FLG = 'Y') C_CUST_NM ," ).append("\n"); 
		query.append("        (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER MC WHERE MC.CUST_CNT_CD = BK.N_CUST_CNT_CD AND MC.CUST_SEQ = BK.N_CUST_SEQ AND MC.CNTR_DIV_FLG = 'Y') N_CUST_NM ," ).append("\n"); 
		query.append("        (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER MC WHERE MC.CUST_CNT_CD = BK.F_CUST_CNT_CD AND MC.CUST_SEQ = BK.F_CUST_SEQ AND MC.CNTR_DIV_FLG = 'Y') F_CUST_NM ," ).append("\n"); 
		query.append("        (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER MC WHERE MC.CUST_CNT_CD = BK.A_CUST_CNT_CD AND MC.CUST_SEQ = BK.A_CUST_SEQ AND MC.CNTR_DIV_FLG = 'Y') A_CUST_NM ," ).append("\n"); 
		query.append("        BK.POR_CD ," ).append("\n"); 
		query.append("        BK.POL_CD ," ).append("\n"); 
		query.append("        BK.POD_CD ," ).append("\n"); 
		query.append("        BK.DEL_CD ," ).append("\n"); 
		query.append("        TO_CHAR(BB.BL_OBRD_DT,'YYYY-MM-DD') BL_OBRD_DT  ," ).append("\n"); 
		query.append("        TRIM(TO_CHAR(BC.CNTR_VOL_QTY * PRI_SC_FEU_CONV(BK.SVC_SCP_CD, BC.CNTR_TPSZ_CD), '999,999,999,999,990.999')) OP_CNTR_QTY ," ).append("\n"); 
		query.append("        BC.CNTR_NO," ).append("\n"); 
		query.append("        BC.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("        TRIM(TO_CHAR(BC.CNTR_VOL_QTY, '999,999,999,999,990.99')) CNTR_VOL_QTY ," ).append("\n"); 
		query.append("        ''  SC_NO           ," ).append("\n"); 
		query.append("        ''  SVC_SCP_CD      ," ).append("\n"); 
		query.append("        ''  BL_OBRD_DT_FROM ," ).append("\n"); 
		query.append("        ''  BL_OBRD_DT_TO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  BKG_NO      ," ).append("\n"); 
		query.append("                BL_NO       ," ).append("\n"); 
		query.append("                VVD         ," ).append("\n"); 
		query.append("                POR_CD      ," ).append("\n"); 
		query.append("                POL_CD      ," ).append("\n"); 
		query.append("                POD_CD      ," ).append("\n"); 
		query.append("                DEL_CD      ," ).append("\n"); 
		query.append("                SVC_SCP_CD  ," ).append("\n"); 
		query.append("                MIN(DECODE(BK.BKG_CUST_TP_CD, 'S', BK.CUST_CNT_CD)) AS S_CUST_CNT_CD," ).append("\n"); 
		query.append("                MIN(DECODE(BK.BKG_CUST_TP_CD, 'S', BK.CUST_SEQ))    AS S_CUST_SEQ," ).append("\n"); 
		query.append("                MIN(DECODE(BK.BKG_CUST_TP_CD, 'C', BK.CUST_CNT_CD)) AS C_CUST_CNT_CD," ).append("\n"); 
		query.append("                MIN(DECODE(BK.BKG_CUST_TP_CD, 'C', BK.CUST_SEQ))    AS C_CUST_SEQ," ).append("\n"); 
		query.append("                MIN(DECODE(BK.BKG_CUST_TP_CD, 'N', BK.CUST_CNT_CD)) AS N_CUST_CNT_CD," ).append("\n"); 
		query.append("                MIN(DECODE(BK.BKG_CUST_TP_CD, 'N', BK.CUST_SEQ))    AS N_CUST_SEQ," ).append("\n"); 
		query.append("                MIN(DECODE(BK.BKG_CUST_TP_CD, 'F', BK.CUST_CNT_CD)) AS F_CUST_CNT_CD," ).append("\n"); 
		query.append("                MIN(DECODE(BK.BKG_CUST_TP_CD, 'F', BK.CUST_SEQ))    AS F_CUST_SEQ," ).append("\n"); 
		query.append("                MIN(DECODE(BK.BKG_CUST_TP_CD, 'A', BK.CUST_CNT_CD)) AS A_CUST_CNT_CD," ).append("\n"); 
		query.append("                MIN(DECODE(BK.BKG_CUST_TP_CD, 'A', BK.CUST_SEQ))    AS A_CUST_SEQ" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  BK.BKG_NO         ," ).append("\n"); 
		query.append("                        BK.BL_NO          ," ).append("\n"); 
		query.append("                        BK.VSL_CD || BK.SKD_VOY_NO || BK.SKD_DIR_CD VVD ," ).append("\n"); 
		query.append("                        BK.POR_CD         ," ).append("\n"); 
		query.append("                        BK.POL_CD         ," ).append("\n"); 
		query.append("                        BK.POD_CD         ," ).append("\n"); 
		query.append("                        BK.DEL_CD         ," ).append("\n"); 
		query.append("                        BK.SVC_SCP_CD     ," ).append("\n"); 
		query.append("                        BC.BKG_CUST_TP_CD ," ).append("\n"); 
		query.append("                        BC.CUST_CNT_CD    ," ).append("\n"); 
		query.append("                        BC.CUST_SEQ" ).append("\n"); 
		query.append("                FROM    BKG_BOOKING   BK  ," ).append("\n"); 
		query.append("                        BKG_CUSTOMER  BC" ).append("\n"); 
		query.append("                WHERE   BK.BKG_NO     = BC.BKG_NO(+)" ).append("\n"); 
		query.append("                AND     BK.BKG_STS_CD = 'F'" ).append("\n"); 
		query.append("                AND     BK.SC_NO      = @[sc_no] -- S/C No" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                #if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("                AND     BK.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("               ) BK" ).append("\n"); 
		query.append("        GROUP BY" ).append("\n"); 
		query.append("                BKG_NO    ," ).append("\n"); 
		query.append("                BL_NO     ," ).append("\n"); 
		query.append("                VVD       ," ).append("\n"); 
		query.append("                POR_CD    ," ).append("\n"); 
		query.append("                POL_CD    ," ).append("\n"); 
		query.append("                POD_CD    ," ).append("\n"); 
		query.append("                DEL_CD    ," ).append("\n"); 
		query.append("                SVC_SCP_CD" ).append("\n"); 
		query.append("        ) BK              ," ).append("\n"); 
		query.append("        BKG_BL_DOC  BB    ," ).append("\n"); 
		query.append("        BKG_VVD     BV    ," ).append("\n"); 
		query.append("        VSK_VSL_PORT_SKD  PS," ).append("\n"); 
		query.append("        BKG_CONTAINER BC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE   BB.BKG_NO       = BK.BKG_NO" ).append("\n"); 
		query.append("AND     BV.BKG_NO       = BK.BKG_NO" ).append("\n"); 
		query.append("AND     NOT EXISTS  (" ).append("\n"); 
		query.append("                    SELECT  'X'" ).append("\n"); 
		query.append("                    FROM    BKG_VVD A" ).append("\n"); 
		query.append("                    WHERE   A.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("                    AND     A.VSL_PRE_PST_CD||A.VSL_SEQ < BV.VSL_PRE_PST_CD||BV.VSL_SEQ" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("AND     PS.VSL_CD       = BV.VSL_CD" ).append("\n"); 
		query.append("AND     PS.SKD_VOY_NO   = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     PS.SKD_DIR_CD   = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     PS.VPS_PORT_CD  = BV.POL_CD" ).append("\n"); 
		query.append("AND     PS.CLPT_IND_SEQ = BV.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND     BC.BKG_NO(+)       = BK.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     PS.VPS_ETD_DT <= TO_DATE(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC, SYSDATE, BK.POL_CD))" ).append("\n"); 
		query.append("#if (${bl_obrd_dt_from} != '')" ).append("\n"); 
		query.append("AND     PS.VPS_ETD_DT >= TO_DATE(@[bl_obrd_dt_from], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_obrd_dt_to} != '')" ).append("\n"); 
		query.append("AND     PS.VPS_ETD_DT <= TO_DATE (@[bl_obrd_dt_to], 'YYYY-MM-DD') + 0.99999 /* 0.99999 는 23시 59분 59초를 의미 */  -- Period" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("        BK.BL_NO" ).append("\n"); 

	}
}
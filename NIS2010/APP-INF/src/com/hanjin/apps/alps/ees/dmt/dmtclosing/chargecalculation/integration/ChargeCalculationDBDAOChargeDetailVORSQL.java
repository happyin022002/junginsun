/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChargeCalculationDBDAOChargeDetailVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lim Chang Bin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOChargeDetailVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Charge의 Amount들을 조회한다
	  * </pre>
	  */
	public ChargeCalculationDBDAOChargeDetailVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_chg_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOChargeDetailVORSQL").append("\n"); 
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
		query.append("SELECT	C.DMDT_TRF_CD		," ).append("\n"); 
		query.append("		B.BKG_NO			," ).append("\n"); 
		query.append("		B.BL_NO				," ).append("\n"); 
		query.append("		B.BKG_CNTR_QTY		," ).append("\n"); 
		query.append("		C.CNTR_NO			," ).append("\n"); 
		query.append("		B.CNTR_TPSZ_CD		," ).append("\n"); 
		query.append("		DECODE( DECODE(C.ACT_CNT_CD,'00','',C.ACT_CNT_CD) || TO_CHAR(C.ACT_CUST_SEQ, 'FM000000')" ).append("\n"); 
		query.append("			,'000000' , NULL, DECODE(C.ACT_CNT_CD,'00','',C.ACT_CNT_CD) || TO_CHAR(C.ACT_CUST_SEQ, 'FM000000')) PAYER_CD," ).append("\n"); 
		query.append("		C.FT_DYS    		," ).append("\n"); 
		query.append("		C.FX_FT_OVR_DYS		," ).append("\n"); 
		query.append("		C.ORG_FT_OVR_DYS	," ).append("\n"); 
		query.append("		C.SC_RFA_EXPT_OVR_DYS," ).append("\n"); 
		query.append("		C.AFT_EXPT_OVR_DYS	," ).append("\n"); 
		query.append("		C.BZC_TRF_CURR_CD	," ).append("\n"); 
		query.append("		C.ORG_CHG_AMT		," ).append("\n"); 
		query.append("		C.SC_RFA_EXPT_AMT	," ).append("\n"); 
		query.append("		C.SC_RFA_AMT," ).append("\n"); 
		query.append("		C.AFT_EXPT_AMT," ).append("\n"); 
		query.append("		C.AFT_EXPT_DC_AMT	," ).append("\n"); 
		query.append("		C.BIL_AMT      		," ).append("\n"); 
		query.append("		C.DMDT_TRF_APLY_TP_CD," ).append("\n"); 
		query.append("		C.BZC_TRF_SEQ		," ).append("\n"); 
		query.append("		NVL(C.BZC_DMDT_DE_TERM_CD, 'N') AS BZC_DMDT_DE_TERM_CD	," ).append("\n"); 
		query.append("		C.BZC_TRF_GRP_SEQ	," ).append("\n"); 
		query.append("		TO_CHAR(C.BZC_TRF_APLY_DT, 'YYYYMMDD') BZC_TRF_APLY_DT," ).append("\n"); 
		query.append("		C.RFA_EXPT_DAR_NO	," ).append("\n"); 
		query.append("		C.RFA_EXPT_MAPG_SEQ ," ).append("\n"); 
		query.append("		C.RFA_EXPT_VER_SEQ	," ).append("\n"); 
		query.append("		C.RFA_RQST_DTL_SEQ	," ).append("\n"); 
		query.append("		C.RFA_EXPT_APRO_NO	," ).append("\n"); 
		query.append("		C.AFT_EXPT_APRO_NO	," ).append("\n"); 
		query.append("		C.AFT_EXPT_DAR_NO	," ).append("\n"); 
		query.append("		C.AFT_EXPT_ADJ_SEQ  ," ).append("\n"); 
		query.append("		C.SC_NO				," ).append("\n"); 
		query.append("		C.SC_EXPT_VER_SEQ   ," ).append("\n"); 
		query.append("		C.SC_EXPT_GRP_SEQ	," ).append("\n"); 
		query.append("		TO_CHAR(C.SC_RFA_EXPT_APLY_DT, 'YYYYMMDD') SC_RFA_EXPT_APLY_DT," ).append("\n"); 
		query.append("		C.CMDT_CD			," ).append("\n"); 
		query.append("		C.CMDT_TRF_SEQ		,	" ).append("\n"); 
		query.append("		TO_CHAR(C.CMDT_EXPT_APLY_DT, 'YYYYMMDD') CMDT_EXPT_APLY_DT," ).append("\n"); 
		query.append("		C.CMDT_OVR_DYS		," ).append("\n"); 
		query.append("		C.CMDT_EXPT_AMT		," ).append("\n"); 
		query.append("		TO_CHAR(C.TO_MVMT_DT, 'YYYYMMDD') TO_MVMT_DT," ).append("\n"); 
		query.append("		C.OFC_TRNS_FLG," ).append("\n"); 
		query.append("		C.CXL_BKG_CHG_FLG," ).append("\n"); 
		query.append("		C.DUL_TP_EXPT_FLG," ).append("\n"); 
		query.append("        C.FM_MVMT_YD_CD," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  S.FT_DYS" ).append("\n"); 
		query.append("        FROM    DMT_TRF_FREE_TM S" ).append("\n"); 
		query.append("        WHERE   S.SYS_AREA_GRP_ID 	= C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("        AND     S.DMDT_TRF_CD 		= C.DMDT_TRF_CD" ).append("\n"); 
		query.append("        AND     S.TRF_SEQ 			= C.BZC_TRF_SEQ" ).append("\n"); 
		query.append("        AND     S.DMDT_DE_TERM_CD   = NVL(C.BZC_DMDT_DE_TERM_CD, 'N')" ).append("\n"); 
		query.append("        AND     S.TRF_GRP_SEQ 		= C.BZC_TRF_GRP_SEQ" ).append("\n"); 
		query.append("        AND    (   (    S.FT_FM_QTY <= B.BKG_CNTR_QTY  AND S.FT_TO_QTY = 0)" ).append("\n"); 
		query.append("                OR (    S.FT_FM_QTY <= B.BKG_CNTR_QTY  AND S.FT_TO_QTY IS NULL)" ).append("\n"); 
		query.append("                OR (    S.FT_FM_QTY <= B.BKG_CNTR_QTY  AND S.FT_TO_QTY >= B.BKG_CNTR_QTY)" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("        ) AS BZC_FT_DYS" ).append("\n"); 
		query.append("#if (${est_mk} == 'P')" ).append("\n"); 
		query.append("FROM	DMT_CHG_PRE_CALC_BKG_CNTR	B," ).append("\n"); 
		query.append("        DMT_CHG_PRE_CALC			C" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("FROM	DMT_CHG_BKG_CNTR	B," ).append("\n"); 
		query.append("		DMT_CHG_CALC    	C" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	B.SYS_AREA_GRP_ID	=	C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND     B.CNTR_NO			=	C.CNTR_NO" ).append("\n"); 
		query.append("AND		B.CNTR_CYC_NO		=	C.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND     C.SYS_AREA_GRP_ID	=	@[svr_id]" ).append("\n"); 
		query.append("AND		C.CNTR_NO			=	@[cntr_no]" ).append("\n"); 
		query.append("AND		C.CNTR_CYC_NO		=	@[cntr_cyc_no]" ).append("\n"); 
		query.append("AND		C.DMDT_TRF_CD		=	@[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND		C.DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND		C.CHG_SEQ			=	@[chg_seq]" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DemandNoteSendDBDAOSearchChargeBookingInvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.02
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2011.09.02 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HwangHyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemandNoteSendDBDAOSearchChargeBookingInvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Creation & Issue - Booking
	  * </pre>
	  */
	public DemandNoteSendDBDAOSearchChargeBookingInvoiceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_chg_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.integration").append("\n"); 
		query.append("FileName : DemandNoteSendDBDAOSearchChargeBookingInvoiceRSQL").append("\n"); 
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
		query.append("SELECT A.SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append(", A.BL_NO" ).append("\n"); 
		query.append(", A.BKG_NO" ).append("\n"); 
		query.append(", B.DMDT_TRF_CD" ).append("\n"); 
		query.append(", B.OFC_CD" ).append("\n"); 
		query.append(", A.SC_NO" ).append("\n"); 
		query.append(", A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append(", A.POR_CD" ).append("\n"); 
		query.append(", A.POL_CD" ).append("\n"); 
		query.append(", A.POD_CD" ).append("\n"); 
		query.append(", A.DEL_CD" ).append("\n"); 
		query.append(", (SELECT RCV_TERM_CD FROM BKG_BOOKING WHERE BKG_NO = A.BKG_NO)||'/'||(SELECT DE_TERM_CD FROM BKG_BOOKING WHERE BKG_NO = A.BKG_NO) AS RD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", B.BZC_TRF_CURR_CD 						AS CHG_CURR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", (SELECT AR_CURR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[ofc_cd]) AS INV_CURR_CD" ).append("\n"); 
		query.append(", @[s_chg_type] 							AS CHG_TYPE" ).append("\n"); 
		query.append(", A.RFA_NO" ).append("\n"); 
		query.append(", MAX(B.ACT_CNT_CD||LPAD(B.ACT_CUST_SEQ,6,'0')) 	AS PAYER_CD" ).append("\n"); 
		query.append(", MAX(LPAD(B.VNDR_SEQ,6,'0')) AS TRUCKER_CD" ).append("\n"); 
		query.append(", SUM(NVL(B.ORG_CHG_AMT,0)) 				AS MN_ORG_CHG_AMT" ).append("\n"); 
		query.append(", SUM(NVL(B.SC_RFA_EXPT_AMT,0)) 			AS DMDT_EXPT_AMT" ).append("\n"); 
		query.append(", SUM(NVL(B.AFT_EXPT_DC_AMT,0)) 			AS CHG_DC_AMT" ).append("\n"); 
		query.append(", SUM(NVL(B.BIL_AMT,0)) 					AS MN_BIL_AMT" ).append("\n"); 
		query.append(", COUNT(A.CNTR_NO) 							AS CNTR_CNT" ).append("\n"); 
		query.append("FROM DMT_CHG_BKG_CNTR A, DMT_CHG_CALC B, COM_SYS_AREA_GRP_ID D" ).append("\n"); 
		query.append("WHERE A.CNTR_NO     = B.CNTR_NO" ).append("\n"); 
		query.append("AND A.CNTR_CYC_NO = B.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND B.OFC_CD	  = @[s_ofc_cd]" ).append("\n"); 
		query.append("AND A.BKG_NO      = @[s_bkg_no]" ).append("\n"); 
		query.append("--AND B.DMDT_CHG_STS_CD = 'C'" ).append("\n"); 
		query.append("AND B.DMDT_CHG_STS_CD IN (" ).append("\n"); 
		query.append("#foreach( $dmdt_chg_sts_cd in ${dmdt_chg_sts_cd_list})" ).append("\n"); 
		query.append("#if($velocityCount < $dmdt_chg_sts_cd_list.size())" ).append("\n"); 
		query.append("'$dmdt_chg_sts_cd'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$dmdt_chg_sts_cd'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND B.DMDT_TRF_CD 		= @[s_dmdt_trf_cd]" ).append("\n"); 
		query.append("AND (							-- OFC_TRNS_FLG 상태에 따라 쿼리가 달라짐" ).append("\n"); 
		query.append("(	NVL(B.OFC_TRNS_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("AND D.SYS_AREA_GRP_ID = A.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("--AND D.CNT_CD = SUBSTR(B.FM_MVMT_YD_CD,1,2)" ).append("\n"); 
		query.append("AND D.CNT_CD = (SELECT SUBSTR(LOC_CD,1,2)" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = B.OFC_CD)" ).append("\n"); 
		query.append("AND CO_IND_CD = 'H'" ).append("\n"); 
		query.append("AND DECODE(B.OFC_TRNS_RHQ_CNG_FLG, 'Y', B.SYS_AREA_GRP_ID, A.SYS_AREA_GRP_ID)=B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("NVL(B.OFC_TRNS_FLG,'N') = 'N'" ).append("\n"); 
		query.append("AND D.CNT_CD = (SELECT SUBSTR(LOC_CD,1,2)" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = B.OFC_CD)" ).append("\n"); 
		query.append("AND CO_IND_CD = 'H'" ).append("\n"); 
		query.append("AND A.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY A.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(", A.BL_NO" ).append("\n"); 
		query.append(", A.BKG_NO" ).append("\n"); 
		query.append(", B.DMDT_TRF_CD" ).append("\n"); 
		query.append(", B.OFC_CD" ).append("\n"); 
		query.append(", A.SC_NO" ).append("\n"); 
		query.append(", A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD" ).append("\n"); 
		query.append(", A.POR_CD" ).append("\n"); 
		query.append(", A.POL_CD" ).append("\n"); 
		query.append(", A.POD_CD" ).append("\n"); 
		query.append(", A.DEL_CD" ).append("\n"); 
		query.append("--	, A.BKG_RCV_TERM_CD||'/'||A.BKG_DE_TERM_CD" ).append("\n"); 
		query.append(", B.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append(", A.RFA_NO" ).append("\n"); 

	}
}
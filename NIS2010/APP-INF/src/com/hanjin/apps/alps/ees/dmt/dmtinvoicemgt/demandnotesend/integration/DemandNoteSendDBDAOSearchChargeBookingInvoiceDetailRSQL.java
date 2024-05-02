/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DemandNoteSendDBDAOSearchChargeBookingInvoiceDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lim Chang Bin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemandNoteSendDBDAOSearchChargeBookingInvoiceDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Creation & Issue - Booking
	  * </pre>
	  */
	public DemandNoteSendDBDAOSearchChargeBookingInvoiceDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("s_dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.integration").append("\n"); 
		query.append("FileName : DemandNoteSendDBDAOSearchChargeBookingInvoiceDetailRSQL").append("\n"); 
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
		query.append("SELECT    A.CNTR_NO" ).append("\n"); 
		query.append("        , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , TO_CHAR(B.FM_MVMT_DT, 'YYYY-MM-DD') AS FM_MVMT_DT" ).append("\n"); 
		query.append("        , TO_CHAR(B.TO_MVMT_DT, 'YYYY-MM-DD') AS TO_MVMT_DT" ).append("\n"); 
		query.append("        , TO_CHAR(B.FT_CMNC_DT, 'YYYY-MM-DD') AS FT_CMNC_DT" ).append("\n"); 
		query.append("        , TO_CHAR(B.FT_END_DT , 'YYYY-MM-DD') AS FT_END_DT" ).append("\n"); 
		query.append("        , B.FT_DYS" ).append("\n"); 
		query.append("        , B.FX_FT_OVR_DYS" ).append("\n"); 
		query.append("        , B.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("        , B.ORG_CHG_AMT" ).append("\n"); 
		query.append("        , NVL(B.SC_RFA_EXPT_AMT,0) AS EXPT_AMT" ).append("\n"); 
		query.append("        , B.AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("        , B.BIL_AMT" ).append("\n"); 
		query.append("        , DECODE(B.CHG_SEQ,'1','G','B') AS GB" ).append("\n"); 
		query.append("        , B.SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append("        , B.CNTR_CYC_NO" ).append("\n"); 
		query.append("        , B.DMDT_TRF_CD" ).append("\n"); 
		query.append("        , B.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("        , B.CHG_SEQ" ).append("\n"); 
		query.append("        , B.BZC_TRF_SEQ" ).append("\n"); 
		query.append("        , NVL(B.BZC_DMDT_DE_TERM_CD, 'N') AS BZC_DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("        , B.BZC_TRF_GRP_SEQ" ).append("\n"); 
		query.append("        , B.DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("        , B.ORG_FT_OVR_DYS" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        , B.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("        , B.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("        , B.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("        , B.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("        , A.SC_NO" ).append("\n"); 
		query.append("        , B.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("        , B.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("        , B.DMDT_TRF_APLY_TP_CD" ).append("\n"); 
		query.append("        , NVL(B.CMDT_EXPT_AMT,0) AS CMDT_EXPT_AMT" ).append("\n"); 
		query.append("        , B.OFC_TRNS_FLG" ).append("\n"); 
		query.append("        , A.BKG_NO" ).append("\n"); 
		query.append("        , B.FM_MVMT_YD_CD" ).append("\n"); 
		query.append("        , TO_CHAR(B.BZC_TRF_APLY_DT    , 'YYYY-MM-DD')    AS BZC_TRF_APLY_DT" ).append("\n"); 
		query.append("        , TO_CHAR(B.SC_RFA_EXPT_APLY_DT, 'YYYY-MM-DD')    AS SC_RFA_EXPT_APLY_DT" ).append("\n"); 
		query.append("FROM    DMT_CHG_BKG_CNTR    A," ).append("\n"); 
		query.append("        DMT_CHG_CALC        B" ).append("\n"); 
		query.append("WHERE   A.SYS_AREA_GRP_ID 	= B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND     A.CNTR_NO 		    = B.CNTR_NO" ).append("\n"); 
		query.append("AND     A.CNTR_CYC_NO 	    = B.CNTR_CYC_NO" ).append("\n"); 
		query.append("##AND B.DMDT_CHG_STS_CD = 'C'" ).append("\n"); 
		query.append("AND     B.DMDT_CHG_STS_CD IN (" ).append("\n"); 
		query.append("    #foreach( $dmdt_chg_sts_cd in ${dmdt_chg_sts_cd_list}) " ).append("\n"); 
		query.append("        #if($velocityCount < $dmdt_chg_sts_cd_list.size()) " ).append("\n"); 
		query.append("           '$dmdt_chg_sts_cd', " ).append("\n"); 
		query.append("        #else " ).append("\n"); 
		query.append("           '$dmdt_chg_sts_cd' " ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("AND     B.DMDT_TRF_CD 	 = @[s_dmdt_trf_cd]" ).append("\n"); 
		query.append("AND     A.BKG_NO 		 = @[s_bkg_no]" ).append("\n"); 
		query.append("AND     B.OFC_CD 		 = @[s_ofc_cd]" ).append("\n"); 
		query.append("#if (${s_chg_type} == '1') " ).append("\n"); 
		query.append("AND	    B.CHG_SEQ		 = 1" ).append("\n"); 
		query.append("#elseif (${s_chg_type} == '2') " ).append("\n"); 
		query.append("AND	    B.CHG_SEQ		<> 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
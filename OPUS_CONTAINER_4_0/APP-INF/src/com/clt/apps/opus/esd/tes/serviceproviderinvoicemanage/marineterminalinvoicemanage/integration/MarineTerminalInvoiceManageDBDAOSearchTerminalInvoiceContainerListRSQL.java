/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceContainerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceContainerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTerminalInvoiceContainerList
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceContainerListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vrfy_rslt_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceContainerListRSQL").append("\n"); 
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
		query.append("SELECT    TML_SO_OFC_CTY_CD                                                                                 " ).append("\n"); 
		query.append(" 			,TML_SO_SEQ                                                                                       " ).append("\n"); 
		query.append(" 			,TML_SO_CNTR_LIST_SEQ                                                                             " ).append("\n"); 
		query.append(" 			,VRFY_RSLT_IND_CD                                                                                 " ).append("\n"); 
		query.append(" 			,MODI_FLG                                                                                         " ).append("\n"); 
		query.append(" 			,DSCR_IND_CD                                                                                      " ).append("\n"); 
		query.append("           ,DECODE(TES_GET_COMCODENAME_FNC('CD00823',DSCR_IND_CD),NULL,'',TES_GET_COMCODENAME_FNC('CD00823',DSCR_IND_CD))  DSCR_IND_NM	" ).append("\n"); 
		query.append(" 			,RVIS_IND_FLG                                                                                     " ).append("\n"); 
		query.append("			,VSL_CD														                                      " ).append("\n"); 
		query.append("			,SKD_VOY_NO													                                      " ).append("\n"); 
		query.append("			,SKD_DIR_CD													                                      " ).append("\n"); 
		query.append(" 			,IO_BND_CD                                                                                        " ).append("\n"); 
		query.append(" 			,IOC_CD " ).append("\n"); 
		query.append("			,DECODE(SUB_TRD_CD,'O','OTH','','',SUB_TRD_CD) SUB_TRD_CD                                                                                          " ).append("\n"); 
		query.append(" 			,LANE_CD                                                                                          " ).append("\n"); 
		query.append(" 			,LANE_CD                                 LANE_CD2                                                 " ).append("\n"); 
		query.append(" 			,TO_CHAR(ATB_DT,'YYYY-MM-DD')            ATB_DT                                                   " ).append("\n"); 
		query.append(" 			,CNTR_NO                                                                                          " ).append("\n"); 
		query.append(" 			,CNTR_TPSZ_CD                                                                                     " ).append("\n"); 
		query.append(" 			,CNTR_STY_CD                                                                                      " ).append("\n"); 
		query.append(" 			,LOCL_TS_IND_CD                                                                                   " ).append("\n"); 
		query.append(" 			,SAM_LOCL_TS_IND_CD                                                                               " ).append("\n"); 
		query.append(" 			,SUBSTR(RCVDE_TERM_IND_CD,0,1)||'/'||SUBSTR(RCVDE_TERM_IND_CD,2,1)  RCVDE_TERM_IND_CD             " ).append("\n"); 
		query.append(" 			,PRE_YD_CD                                                                                        " ).append("\n"); 
		query.append(" 			,TO_CHAR(MVMT_GATE_IN_DT,'YYYY-MM-DD')   MVMT_GATE_IN_DT                                          " ).append("\n"); 
		query.append(" 			,TO_CHAR(INV_GATE_IN_DT,'YYYY-MM-DD')    INV_GATE_IN_DT                                           " ).append("\n"); 
		query.append(" 			,GATE_IN_TD_DYS                                                                                   " ).append("\n"); 
		query.append(" 			,MVMT_GATE_OUT_DT                                                                                 " ).append("\n"); 
		query.append(" 			,INV_GATE_OUT_DT                                                                                  " ).append("\n"); 
		query.append(" 			,GATE_OUT_TD_DYS                                                                                  " ).append("\n"); 
		query.append(" 			,MVMT_STAY_DYS                                                                                    " ).append("\n"); 
		query.append(" 			,INV_STAY_DYS                                                                                     " ).append("\n"); 
		query.append(" 			,STAY_DIFF_DYS                                                                                    " ).append("\n"); 
		query.append(" 			,DCGO_CLSS_CD                                                                                     " ).append("\n"); 
		query.append(" 			,BB_CGO_FLG                                                                                       " ).append("\n"); 
		query.append(" 			,TO_CHAR(WRK_DT,'YYYY-MM-DD')            WRK_DT                                                   " ).append("\n"); 
		query.append(" 			,TO_CHAR(CLM_DT,'YYYY-MM-DD')            CLM_DT                                                   " ).append("\n"); 
		query.append(" 			,TO_CHAR(RAIL_BIL_DT,'YYYY-MM-DD')       RAIL_BIL_DT                                              " ).append("\n"); 
		query.append(" 			--,DECODE( CNTR_STY_CD, 'F', BKG_NO, '' )	 AS BKG_NO_CON " ).append("\n"); 
		query.append("			,BKG_NO AS BKG_NO_CON                            " ).append("\n"); 
		query.append(" 			,BKG_NO                                                                                           " ).append("\n"); 
		query.append(" 			--,BKG_NO_SPLIT                                                                                     " ).append("\n"); 
		query.append(" 			,BL_NO                                                                                            " ).append("\n"); 
		query.append(" 			--,BL_NO_TP                                                                                         " ).append("\n"); 
		query.append(" 			--,BL_NO_CHK                                                                                        " ).append("\n"); 
		query.append(" 			,DSCR_RSN                                                                                         " ).append("\n"); 
		query.append(" 			,HNDL_RSLT_RMK                                                                                    " ).append("\n"); 
		query.append(" 			,CNTR_RMK                                                                                         " ).append("\n"); 
		query.append(" 			,VSL_CD||SKD_VOY_NO||SKD_DIR_CD 		VVD                                                       " ).append("\n"); 
		query.append(" 			,DSCR_DTL_IND_CD                                                                                  " ).append("\n"); 
		query.append(" 			,TML_TRNS_MOD_CD                                                                                  " ).append("\n"); 
		query.append(" 			,AWK_CGO_FLG                                                                                      " ).append("\n"); 
		query.append(" 			,RC_FLG                                                                                           " ).append("\n"); 
		query.append(" FROM  TES_TML_SO_CNTR_LIST                                                                              	  " ).append("\n"); 
		query.append(" WHERE TML_SO_OFC_CTY_CD =  @[tml_so_ofc_cty_cd]                                     		                                      " ).append("\n"); 
		query.append(" AND	TML_SO_SEQ        = @[tml_so_seq]                                        	                                      " ).append("\n"); 
		query.append(" AND	VRFY_RSLT_IND_CD  = @[vrfy_rslt_ind_cd]                                        	                                      " ).append("\n"); 
		query.append(" AND	VSL_CD        	  = SUBSTR(@[vvd], 1, 4)                                        	                          " ).append("\n"); 
		query.append(" AND	SKD_VOY_NO        = SUBSTR(@[vvd], 5, 4)                                        	                          " ).append("\n"); 
		query.append(" AND	SKD_DIR_CD        = SUBSTR(@[vvd], 9, 1)                                        	                          " ).append("\n"); 
		query.append(" AND	UPPER(IO_BND_CD)  = @[io_bnd_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vrfyresult} == 'CO') " ).append("\n"); 
		query.append("order by  cntr_tpsz_cd, cntr_sty_cd, io_bnd_cd, dcgo_clss_cd, wrk_dt, ioc_cd, tml_trns_mod_cd, locl_ts_ind_cd, cntr_no" ).append("\n"); 
		query.append("#elseif (${vrfyresult} == 'DC') " ).append("\n"); 
		query.append("order by  dscr_ind_cd, cntr_tpsz_cd, cntr_sty_cd, io_bnd_cd, dcgo_clss_cd, wrk_dt, ioc_cd, tml_trns_mod_cd, locl_ts_ind_cd, cntr_no" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
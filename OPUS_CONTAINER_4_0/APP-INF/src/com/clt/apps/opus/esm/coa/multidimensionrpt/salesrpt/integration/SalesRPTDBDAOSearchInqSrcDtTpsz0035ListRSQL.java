/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SalesRPTDBDAOSearchInqSrcDtTpsz0035ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRPTDBDAOSearchInqSrcDtTpsz0035ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inquiry by Source Data
	  * @SJH.20140814 : COA_BKG_EXPN_DTL_WK -> COA_BKG_EXPN_DTL
	  * </pre>
	  */
	public SalesRPTDBDAOSearchInqSrcDtTpsz0035ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rep_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_lvl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sls_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_usr_ofc_lvl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_usa_bkg_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_shpr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rev_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_taa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_sts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rev_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.integration").append("\n"); 
		query.append("FileName : SalesRPTDBDAOSearchInqSrcDtTpsz0035ListRSQL").append("\n"); 
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
		query.append("#if(${f_excel} =='Y')" ).append("\n"); 
		query.append("SELECT   'R.MONTH'  COST_YRMON" ).append("\n"); 
		query.append("  , 'S.MONTH' SLS_YRMON" ).append("\n"); 
		query.append("  , 'WEEK'  COST_WK" ).append("\n"); 
		query.append("  , 'BKG NO'  BKG_NO" ).append("\n"); 
		query.append("  , 'BL NO'  BL_NO" ).append("\n"); 
		query.append("  , 'TRADE'  TRD_CD" ).append("\n"); 
		query.append("  , 'R.LANE'  RLANE_CD" ).append("\n"); 
		query.append("  , 'IOC'  IOC_CD" ).append("\n"); 
		query.append("  , 'REV VVD'  R_VVD" ).append("\n"); 
		query.append("  , 'DIR'  DIR_CD" ).append("\n"); 
		query.append("  , 'C.RHQ'  C_RHQ" ).append("\n"); 
		query.append("  , 'C.AD'  C_AD" ).append("\n"); 
		query.append("  , 'C.OFC'  C_OFC" ).append("\n"); 
		query.append("  , 'C.S.REP'  CSREP_CD" ).append("\n"); 
		query.append("  , 'L.RHQ'  L_RHQ" ).append("\n"); 
		query.append("  , 'L.AD'  L_AD" ).append("\n"); 
		query.append("  , 'L.OFC'  L_OFC" ).append("\n"); 
		query.append("  , 'L.REP'  LREP_CD" ).append("\n"); 
		query.append("  , 'BKG OFC'  BKG_OFC_CD" ).append("\n"); 
		query.append("  , 'BKG STS'  BKG_STS_CD" ).append("\n"); 
		query.append("  , 'USA MODE'  USA_MODE" ).append("\n"); 
		query.append("  , 'BKG POR'  BKG_POR_CD" ).append("\n"); 
		query.append("  , 'BKG POL'  BKG_POL_CD" ).append("\n"); 
		query.append("  , 'BKG POD'  BKG_POD_CD" ).append("\n"); 
		query.append("  , 'BKG DEL'  BKG_DEL_CD" ).append("\n"); 
		query.append("  , 'RCV TERM'  BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("  , 'DEL TERM'  BKG_DE_TERM_CD" ).append("\n"); 
		query.append("  , 'REP CMDT CD'  REP_CMDT_CD" ).append("\n"); 
		query.append("  , 'REP CMDT DESC'  REP_CMDT_NM" ).append("\n"); 
		query.append("  , 'CMDT CD'  CMDT_CD" ).append("\n"); 
		query.append("  , 'CMDT DESC'  CMDT_NM" ).append("\n"); 
		query.append("  , 'TRADE1'  N1ST_TRD_CD" ).append("\n"); 
		query.append("  , 'TRADE2'  N2ND_TRD_CD" ).append("\n"); 
		query.append("  , 'TRADE3'  N3RD_TRD_CD" ).append("\n"); 
		query.append("  , 'TRADE4'  N4TH_TRD_CD" ).append("\n"); 
		query.append("  , 'Lane1'  N1ST_RLANE_CD" ).append("\n"); 
		query.append("  , 'Lane2'  N2ND_RLANE_CD" ).append("\n"); 
		query.append("  , 'Lane3'  N3RD_RLANE_CD" ).append("\n"); 
		query.append("  , 'Lane4'  N4TH_RLANE_CD" ).append("\n"); 
		query.append("  , 'VVD1'  N1ST_FINC_VVD_CD" ).append("\n"); 
		query.append("  , 'VVD2'  N2ND_FINC_VVD_CD" ).append("\n"); 
		query.append("  , 'VVD3'  N3RD_FINC_VVD_CD" ).append("\n"); 
		query.append("  , 'VVD4'  N4TH_FINC_VVD_CD" ).append("\n"); 
		query.append("  , 'POL1'  N1ST_POL_CD" ).append("\n"); 
		query.append("  , 'POL2'  N2ND_POL_CD" ).append("\n"); 
		query.append("  , 'POL3'  N3RD_POL_CD" ).append("\n"); 
		query.append("  , 'POL4'  N4TH_POL_CD" ).append("\n"); 
		query.append("  , 'POD1'  N1ST_POD_CD" ).append("\n"); 
		query.append("  , 'POD2'  N2ND_POD_CD" ).append("\n"); 
		query.append("  , 'POD3'  N3RD_POD_CD" ).append("\n"); 
		query.append("  , 'POD4'  N4TH_POD_CD" ).append("\n"); 
		query.append("  , 'SC NO'  SC_NO" ).append("\n"); 
		query.append("  , 'RFA NO'  RFA_NO" ).append("\n"); 
		query.append("  , 'NVOCC'  NVOCC" ).append("\n"); 
		query.append("  , 'CUST TP'  CUST_TP" ).append("\n"); 
		query.append("  , 'SC/RFC CUST CD'  SC_CUST_CD" ).append("\n"); 
		query.append("  , 'SC/RFC CUST NM'  SC_CUST_NM" ).append("\n"); 
		query.append("  , 'BKG SHPR_CD'  SHPR_CD" ).append("\n"); 
		query.append("  , 'BKG SHPR_NM'  SHPR_NM" ).append("\n"); 
		query.append("  , 'B/L SHPR TP'  BL_SHPR_TP" ).append("\n"); 
		query.append("  , 'B/L SHPR NM'  BL_SHPR_NM" ).append("\n"); 
		query.append("  , 'CNEE CD'  CNEE_CD" ).append("\n"); 
		query.append("  , 'CNEE NM'  CNEE_NM" ).append("\n"); 
		query.append("  , 'NOTIFY CD'  NTFY_CD" ).append("\n"); 
		query.append("  , 'NOTIFY NM'  NTFY_NM" ).append("\n"); 
		query.append("  , 'PRD CCT'  PPD_CCT" ).append("\n"); 
		query.append("  , 'BL ON BOARD DT'  BL_ONBOARD_DT" ).append("\n"); 
		query.append("  , 'CGO RCV DT'  CGO_RCV_DT" ).append("\n"); 
		query.append("  , 'SOC'  SOC" ).append("\n"); 
		query.append("  , 'REV MT'  REV_MT" ).append("\n"); 
		query.append("  , 'RC'  RC									--SJH.20141112.ADD" ).append("\n"); 
		query.append("  , 'DG'  DG" ).append("\n"); 
		query.append("  , 'BB'  BB" ).append("\n"); 
		query.append("  , 'AK'  AK" ).append("\n"); 
		query.append("  , 'WEIGHT'  WEIGHT" ).append("\n"); 
		query.append("  , 'UNIT'  UNIT" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  #foreach($key in ${allcols}) " ).append("\n"); 
		query.append("    ,'FR_$key' REV_$key" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("  ,'FR_REV_TTL' TOT_FR_REV_TPSZ" ).append("\n"); 
		query.append("  ,'MISC_REV_TTL' TOT_MISC_REV_TPSZ" ).append("\n"); 
		query.append("  ,'REV_TTL' TOT_REV_TPSZ" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  #foreach($key in ${allcols}) " ).append("\n"); 
		query.append("    ,'LOAD_$key' QTY_$key" ).append("\n"); 
		query.append("  #end  " ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("  ,'LOAD_TTL(TEU)' TOT_QTY" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	--SJH.20141112.MOD,ADD" ).append("\n"); 
		query.append("	#foreach($key in ${allcols}) " ).append("\n"); 
		query.append("    ,'CM_COST_$key(EPP A)' CM_COST_A_$key" ).append("\n"); 
		query.append("  	#end" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("	  ,'CM Cost Total(EPP A)'	CM_COST_TOTAL_A" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#foreach($key in ${allcols}) " ).append("\n"); 
		query.append("    ,'CM_$key(EPP A)' CM_A_$key" ).append("\n"); 
		query.append("  	#end					" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("	  ,'CM Total(EPP A)'	CM_TOTAL_A" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#foreach($key in ${allcols}) " ).append("\n"); 
		query.append("    ,'CM_COST_$key(EPP B)' CM_COST_B_$key" ).append("\n"); 
		query.append("  	#end" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("	  ,'CM Cost Total(EPP B)'	CM_COST_TOTAL_B" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#foreach($key in ${allcols}) " ).append("\n"); 
		query.append("    ,'CM_$key(EPP B)' CM_B_$key" ).append("\n"); 
		query.append("  	#end					" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("	  ,'CM Total(EPP B)'	CM_TOTAL_B" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("  FROM DUAL 			" ).append("\n"); 
		query.append("  UNION ALL 			" ).append("\n"); 
		query.append("#end		" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("SELECT  " ).append("\n"); 
		query.append("   A2.COST_YRMON  " ).append("\n"); 
		query.append("  ,A2.SLS_YRMON  " ).append("\n"); 
		query.append("  ,A2.COST_WK  " ).append("\n"); 
		query.append("  ,A2.BKG_NO         AS BKG_NO  " ).append("\n"); 
		query.append("  ,A2.BL_NO || A2.BL_NO_TP || A2.BL_NO_CHK AS BL_NO  			" ).append("\n"); 
		query.append("  ,A2.TRD_CD  " ).append("\n"); 
		query.append("  ,A2.RLANE_CD  " ).append("\n"); 
		query.append("  ,A2.IOC_CD  " ).append("\n"); 
		query.append("  ,A2.VSL_CD || A2.SKD_VOY_NO || A2.DIR_CD  AS R_VVD  " ).append("\n"); 
		query.append("  ,A2.DIR_CD  " ).append("\n"); 
		query.append("  ,A2.CTRT_HQ_OFC_CD                        AS C_RHQ " ).append("\n"); 
		query.append("  ,A2.CTRT_RGN_OFC_CD                       AS C_AD " ).append("\n"); 
		query.append("  ,A2.CTRT_OFC_CD                           AS C_OFC " ).append("\n"); 
		query.append("  ,A2.CTRT_SREP_CD                          AS CSREP_CD " ).append("\n"); 
		query.append("  ,A2.RHQ_CD                                AS L_RHQ " ).append("\n"); 
		query.append("  ,A2.RGN_OFC_CD                            AS L_AD " ).append("\n"); 
		query.append("  ,A2.SLS_OFC_CD                            AS L_OFC " ).append("\n"); 
		query.append("  ,A2.SREP_CD                               AS LREP_CD  " ).append("\n"); 
		query.append("  ,A2.BKG_OFC_CD  " ).append("\n"); 
		query.append("  ,A2.BKG_STS_CD  " ).append("\n"); 
		query.append("  ,A2.USA_BKG_MOD_CD                        AS USA_MODE " ).append("\n"); 
		query.append("  ,A2.BKG_POR_CD  " ).append("\n"); 
		query.append("  ,A2.BKG_POL_CD  " ).append("\n"); 
		query.append("  ,A2.BKG_POD_CD  " ).append("\n"); 
		query.append("  ,A2.BKG_DEL_CD  " ).append("\n"); 
		query.append("  ,A2.BKG_RCV_TERM_CD  " ).append("\n"); 
		query.append("  ,A2.BKG_DE_TERM_CD  " ).append("\n"); 
		query.append("  ,A2.REP_CMDT_CD  " ).append("\n"); 
		query.append("  ,A5.REP_CMDT_NM     " ).append("\n"); 
		query.append("  ,A2.CMDT_CD " ).append("\n"); 
		query.append("  ,A3.CMDT_NM  " ).append("\n"); 
		query.append("  ,A2.N1ST_TRD_CD  " ).append("\n"); 
		query.append("  ,A2.N2ND_TRD_CD  " ).append("\n"); 
		query.append("  ,A2.N3RD_TRD_CD  " ).append("\n"); 
		query.append("  ,A2.N4TH_TRD_CD  " ).append("\n"); 
		query.append("  ,A2.N1ST_RLANE_CD " ).append("\n"); 
		query.append("  ,A2.N2ND_RLANE_CD " ).append("\n"); 
		query.append("  ,A2.N3RD_RLANE_CD " ).append("\n"); 
		query.append("  ,A2.N4TH_RLANE_CD  " ).append("\n"); 
		query.append("  ,A2.N1ST_FINC_VVD_CD " ).append("\n"); 
		query.append("  ,A2.N2ND_FINC_VVD_CD " ).append("\n"); 
		query.append("  ,A2.N3RD_FINC_VVD_CD " ).append("\n"); 
		query.append("  ,A2.N4TH_FINC_VVD_CD  " ).append("\n"); 
		query.append("  ,A2.N1ST_POL_CD " ).append("\n"); 
		query.append("  ,A2.N2ND_POL_CD " ).append("\n"); 
		query.append("  ,A2.N3RD_POL_CD " ).append("\n"); 
		query.append("  ,A2.N4TH_POL_CD  " ).append("\n"); 
		query.append("  ,A2.N1ST_POD_CD " ).append("\n"); 
		query.append("  ,A2.N2ND_POD_CD " ).append("\n"); 
		query.append("  ,A2.N3RD_POD_CD " ).append("\n"); 
		query.append("  ,A2.N4TH_POD_CD  " ).append("\n"); 
		query.append("  ,A2.SC_NO  " ).append("\n"); 
		query.append("  ,A2.RFA_NO  " ).append("\n"); 
		query.append("  ,DECODE(A2.CUST_TP_CD,'N','Y','N')                                           AS NVOCC " ).append("\n"); 
		query.append("  ,A2.AGMT_CUST_TP_CD                                      AS CUST_TP  " ).append("\n"); 
		query.append("  ,A2.AGMT_CNT_CD || TO_CHAR(LPAD(DECODE(A2.AGMT_CUST_SEQ,0,'',A2.AGMT_CUST_SEQ),6,'0'))  AS SC_CUST_CD  " ).append("\n"); 
		query.append("  ,(   " ).append("\n"); 
		query.append("    SELECT CUST_LGL_ENG_NM   " ).append("\n"); 
		query.append("      FROM MDM_CUSTOMER B1   " ).append("\n"); 
		query.append("     WHERE A2.AGMT_CNT_CD   = B1.CUST_CNT_CD(+)   " ).append("\n"); 
		query.append("       AND A2.AGMT_CUST_SEQ = B1.CUST_SEQ(+)   " ).append("\n"); 
		query.append("  ) AS SC_CUST_NM   " ).append("\n"); 
		query.append("  ,A2.SHPR_CNT_CD || TO_CHAR(LPAD(DECODE(A2.SHPR_CUST_SEQ,0,'',A2.SHPR_CUST_SEQ),6,'0'))      AS SHPR_CD   " ).append("\n"); 
		query.append("  ,(   " ).append("\n"); 
		query.append("    SELECT CUST_LGL_ENG_NM   " ).append("\n"); 
		query.append("      FROM MDM_CUSTOMER B1   " ).append("\n"); 
		query.append("     WHERE A2.SHPR_CNT_CD   = B1.CUST_CNT_CD(+)   " ).append("\n"); 
		query.append("       AND A2.SHPR_CUST_SEQ = B1.CUST_SEQ(+)   " ).append("\n"); 
		query.append("  ) AS SHPR_NM   " ).append("\n"); 
		query.append("  ,A2.CUST_TP_CD										   AS BL_SHPR_TP" ).append("\n"); 
		query.append("  ,A2.SHPR_NM                                              AS BL_SHPR_NM  " ).append("\n"); 
		query.append("  ,A2.CNEE_CNT_CD || TO_CHAR(LPAD(DECODE(A2.CNEE_CUST_SEQ,0,'',A2.CNEE_CUST_SEQ),6,'0')) AS CNEE_CD  " ).append("\n"); 
		query.append("  ,(   " ).append("\n"); 
		query.append("    SELECT CUST_LGL_ENG_NM   " ).append("\n"); 
		query.append("      FROM MDM_CUSTOMER B1   " ).append("\n"); 
		query.append("     WHERE A2.CNEE_CNT_CD   = B1.CUST_CNT_CD(+)   " ).append("\n"); 
		query.append("       AND A2.CNEE_CUST_SEQ = B1.CUST_SEQ(+)   " ).append("\n"); 
		query.append("  ) AS CNEE_NM  /*CNEE*/   " ).append("\n"); 
		query.append("  ,A2.NTFY_CNT_CD || TO_CHAR(LPAD(DECODE(A2.NTFY_CUST_SEQ,0,'',A2.NTFY_CUST_SEQ),6,'0')) AS NTFY_CD " ).append("\n"); 
		query.append("  ,(   " ).append("\n"); 
		query.append("    SELECT CUST_LGL_ENG_NM   " ).append("\n"); 
		query.append("      FROM MDM_CUSTOMER B1   " ).append("\n"); 
		query.append("     WHERE A2.NTFY_CNT_CD   = B1.CUST_CNT_CD(+)   " ).append("\n"); 
		query.append("       AND A2.NTFY_CUST_SEQ = B1.CUST_SEQ(+)   " ).append("\n"); 
		query.append("  ) AS NTFY_NM   " ).append("\n"); 
		query.append("  ,A2.OFT_TP_CD                                            AS PPD_CCT " ).append("\n"); 
		query.append("  ,TO_CHAR(A2.OBRD_DT,'YYYY-MM-DD')                        AS BL_ONBOARD_DT  " ).append("\n"); 
		query.append("  ,TO_CHAR(A2.CNTR_RCV_DT,'YYYY-MM-DD')                    AS CGO_RCV_DT  " ).append("\n"); 
		query.append("  ,A2.SOC_FLG                                              AS SOC " ).append("\n"); 
		query.append("  ,DECODE(A2.BKG_CGO_TP_CD, 'R', 'Y', 'N')                 AS REV_MT " ).append("\n"); 
		query.append("  ,NVL(A2.SPCL_RC_FLG, 'N')                                AS RC 		--SJH.20141112.ADD" ).append("\n"); 
		query.append("  ,NVL(A2.SPCL_DG_CGO_FLG, 'N')                            AS DG " ).append("\n"); 
		query.append("  ,NVL(A2.SPCL_BB_CGO_FLG, 'N')                            AS BB  " ).append("\n"); 
		query.append("  ,NVL(A2.SPCL_AWK_CGO_FLG, 'N')                           AS AK " ).append("\n"); 
		query.append("  ,TO_CHAR(A2.BKG_CGO_WGT)                                 AS WEIGHT " ).append("\n"); 
		query.append("  ,A2.BKG_WGT_TP_CD                                        AS UNIT " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("  #foreach($key in ${allcols}) " ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(DECODE(A2.SPCL_CNTR_TPSZ_CD, '$key',  A2.BKG_REV+A2.BKG_OFT_REV)))      AS REV_$key" ).append("\n"); 
		query.append("  #end		" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.BKG_REV+A2.BKG_OFT_REV))                                           AS TOT_FR_REV_TPSZ " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.BKG_MISC_REV+A2.SCR_CHG_REV))                                      AS TOT_MISC_REV_TPSZ " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.BKG_REV+A2.BKG_OFT_REV+A2.BKG_MISC_REV+A2.SCR_CHG_REV))            AS TOT_REV_TPSZ " ).append("\n"); 
		query.append("  		" ).append("\n"); 
		query.append("	#foreach($key in ${allcols}) " ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(DECODE(A2.SPCL_CNTR_TPSZ_CD, '$key',  A2.BKG_QTY)))  AS QTY_$key" ).append("\n"); 
		query.append("  #end	" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(DECODE(SUBSTR(A2.SPCL_CNTR_TPSZ_CD,-1),'2',A2.BKG_QTY,A2.BKG_QTY*2))) AS TOT_QTY" ).append("\n"); 
		query.append("    --SJH.20141112.ADD,MOD" ).append("\n"); 
		query.append("  	#foreach($key in ${allcols}) " ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(DECODE(A2.SPCL_CNTR_TPSZ_CD, '$key', A2.PA_CM_COST_TTL_AMT))) AS CM_COST_A_$key" ).append("\n"); 
		query.append("  	#end	" ).append("\n"); 
		query.append("	,TO_CHAR(SUM(A2.PA_CM_COST_TTL_AMT))  AS CM_COST_TOTAL_A" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#foreach($key in ${allcols}) " ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(DECODE(A2.SPCL_CNTR_TPSZ_CD, '$key',  A2.BKG_REV+A2.BKG_OFT_REV+A2.BKG_MISC_REV+A2.SCR_CHG_REV - A2.PA_CM_COST_TTL_AMT))) AS CM_A_$key" ).append("\n"); 
		query.append("  	#end		        " ).append("\n"); 
		query.append("	,TO_CHAR(SUM(A2.BKG_REV+A2.BKG_OFT_REV+A2.BKG_MISC_REV+A2.SCR_CHG_REV - A2.PA_CM_COST_TTL_AMT))  AS CM_TOTAL_A	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  	#foreach($key in ${allcols}) " ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(DECODE(A2.SPCL_CNTR_TPSZ_CD, '$key', A2.PA_CM_COST_TTL_AMT2))) AS CM_COST_B_$key" ).append("\n"); 
		query.append("  	#end	" ).append("\n"); 
		query.append("	,TO_CHAR(SUM(A2.PA_CM_COST_TTL_AMT2))  AS CM_COST_TOTAL_B" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#foreach($key in ${allcols}) " ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(DECODE(A2.SPCL_CNTR_TPSZ_CD, '$key',  A2.BKG_REV+A2.BKG_OFT_REV+A2.BKG_MISC_REV+A2.SCR_CHG_REV - A2.PA_CM_COST_TTL_AMT2))) AS CM_B_$key" ).append("\n"); 
		query.append("  	#end		        " ).append("\n"); 
		query.append("	,TO_CHAR(SUM(A2.BKG_REV+A2.BKG_OFT_REV+A2.BKG_MISC_REV+A2.SCR_CHG_REV - A2.PA_CM_COST_TTL_AMT2))  AS CM_TOTAL_B" ).append("\n"); 
		query.append("					   " ).append("\n"); 
		query.append("FROM   " ).append("\n"); 
		query.append("   #if(${f_chkprd} =='M')" ).append("\n"); 
		query.append("    	COA_BKG_EXPN_DTL A2" ).append("\n"); 
		query.append("   #elseif (${f_chkprd} =='W')" ).append("\n"); 
		query.append("    	COA_BKG_EXPN_DTL A2 " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ,COA_OFC_LVL A4 " ).append("\n"); 
		query.append("  ,MDM_COMMODITY A3     " ).append("\n"); 
		query.append("  ,MDM_REP_CMDT A5 " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  #if(${f_chkprd} =='M')" ).append("\n"); 
		query.append("    AND A2.COST_YRMON  = @[f_year]||@[f_mon] " ).append("\n"); 
		query.append("    AND A2.COST_YRMON  BETWEEN A4.OFC_APLY_FM_YRMON AND A4.OFC_APLY_TO_YRMON    " ).append("\n"); 
		query.append("  #elseif (${f_chkprd} =='W')" ).append("\n"); 
		query.append("    AND SUBSTR(A2.SLS_YRMON,1,4)||A2.COST_WK BETWEEN @[f_year]||@[f_fm_wk] AND @[f_year]||@[f_to_wk]" ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("    #if(${f_sls_mon} !='')" ).append("\n"); 
		query.append("    	AND A2.SLS_YRMON = @[f_year]||@[f_sls_mon]   " ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    AND A2.SLS_YRMON     BETWEEN A4.OFC_APLY_FM_YRMON AND A4.OFC_APLY_TO_YRMON    " ).append("\n"); 
		query.append("  #end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if(${f_ofc_vw} =='C')	" ).append("\n"); 
		query.append("	AND A2.AGMT_SGN_OFC_CD = A4.OFC_CD" ).append("\n"); 
		query.append("  #elseif (${f_ofc_vw} =='L')	" ).append("\n"); 
		query.append("	AND A2.SLS_OFC_CD = A4.OFC_CD" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("	AND 1 = 0" ).append("\n"); 
		query.append("  #end	" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  AND A2.CMDT_CD       = A3.CMDT_CD(+)  " ).append("\n"); 
		query.append("  AND A2.REP_CMDT_CD   = A5.REP_CMDT_CD(+) " ).append("\n"); 
		query.append("  AND NVL(A2.DELT_FLG, 'N')      = 'N' " ).append("\n"); 
		query.append("  AND A2.BKG_STS_CD    IN ('F','S',DECODE(@[f_bkg_sts],'Y', 'W')) " ).append("\n"); 
		query.append("  AND A2.BKG_CGO_TP_CD <> 'P' " ).append("\n"); 
		query.append("  AND A2.BL_NO_TP      IN ('M','0')   " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("  #if(${f_ofc_cd} !='')" ).append("\n"); 
		query.append("    #if(${f_excl_sts} =='')" ).append("\n"); 
		query.append("      AND DECODE(@[f_ofc_lvl],'1',A4.OFC_N1ST_LVL_CD,'2',A4.OFC_N2ND_LVL_CD,'3',A4.OFC_N3RD_LVL_CD,'4',A4.OFC_N4TH_LVL_CD,'5',A4.OFC_N5TH_LVL_CD,'6',A4.OFC_N6TH_LVL_CD,'7',A4.OFC_N7TH_LVL_CD) = @[f_ofc_cd]" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("      AND A4.OFC_CD = @[f_ofc_cd] " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("  #else			" ).append("\n"); 
		query.append("    AND DECODE(@[f_usr_ofc_lvl],'1',A4.OFC_N1ST_LVL_CD,'2',A4.OFC_N2ND_LVL_CD,'3',A4.OFC_N3RD_LVL_CD,'4',A4.OFC_N4TH_LVL_CD,'5',A4.OFC_N5TH_LVL_CD,'6',A4.OFC_N6TH_LVL_CD,'7',A4.OFC_N7TH_LVL_CD) IN (@[f_usr_ofc_cd], DECODE(SUBSTR(@[f_usr_ofc_cd], 1, 4), 'SHAA', 'SINWA', '')) " ).append("\n"); 
		query.append("  #end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if(${f_ofc_lvl}=='6' || ${f_ofc_lvl}=='7')" ).append("\n"); 
		query.append("    AND A4.OFC_LVL = @[f_ofc_lvl]" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("    AND A4.OFC_LVL < '9'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  #if(${f_vsl_cd} !='')" ).append("\n"); 
		query.append("    AND A2.VSL_CD  = @[f_vsl_cd] " ).append("\n"); 
		query.append("  #end  " ).append("\n"); 
		query.append("  #if(${f_skd_voy_no} !='')" ).append("\n"); 
		query.append("    AND A2.SKD_VOY_NO     = @[f_skd_voy_no] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_skd_dir_cd} !='')" ).append("\n"); 
		query.append("    AND A2.DIR_CD         = @[f_skd_dir_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_trd_cd} !='')" ).append("\n"); 
		query.append("    AND A2.TRD_CD         = @[f_trd_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_rlane_cd} !='')" ).append("\n"); 
		query.append("    AND A2.RLANE_CD       = @[f_rlane_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_ioc_cd} !='')" ).append("\n"); 
		query.append("    AND A2.IOC_CD         = @[f_ioc_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_dir_cd} !='')" ).append("\n"); 
		query.append("    AND A2.DIR_CD         = @[f_dir_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_bkg_por_cd} !='')" ).append("\n"); 
		query.append("    AND A2.BKG_POR_CD     LIKE @[f_bkg_por_cd] || '%' " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_rev_pol_cd} !='')" ).append("\n"); 
		query.append("    AND A2.REV_POL_CD     LIKE @[f_rev_pol_cd] || '%' " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_rev_pod_cd} !='')" ).append("\n"); 
		query.append("    AND A2.REV_POD_CD     LIKE @[f_rev_pod_cd] || '%' " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_bkg_del_cd} !='')" ).append("\n"); 
		query.append("    AND A2.BKG_DEL_CD     LIKE @[f_bkg_del_cd] || '%' " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_shpr_cd} !='')" ).append("\n"); 
		query.append("    AND A2.SHPR_CNT_CD||A2.SHPR_CUST_SEQ = @[f_shpr_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_sc_no} !='')" ).append("\n"); 
		query.append("    AND A2.SC_NO          = @[f_sc_no] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_taa_no} !='')" ).append("\n"); 
		query.append("    AND A2.TAA_NO          = @[f_taa_no] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_rfa_no} !='')" ).append("\n"); 
		query.append("    AND A2.RFA_NO         = @[f_rfa_no] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_rep_cmdt_cd} !='')" ).append("\n"); 
		query.append("    AND A2.REP_CMDT_CD    = @[f_rep_cmdt_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_usa_bkg_mod_cd} !='')" ).append("\n"); 
		query.append("    AND A2.USA_BKG_MOD_CD = @[f_usa_bkg_mod_cd] " ).append("\n"); 
		query.append("  #end	" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("GROUP BY " ).append("\n"); 
		query.append("   A2.COST_YRMON " ).append("\n"); 
		query.append("  ,A2.SLS_YRMON  " ).append("\n"); 
		query.append("  ,A2.COST_WK " ).append("\n"); 
		query.append("  ,A2.BKG_NO " ).append("\n"); 
		query.append("  ,A2.BL_NO || A2.BL_NO_TP || A2.BL_NO_CHK" ).append("\n"); 
		query.append("  ,A2.TRD_CD  " ).append("\n"); 
		query.append("  ,A2.RLANE_CD  " ).append("\n"); 
		query.append("  ,A2.IOC_CD  " ).append("\n"); 
		query.append("  ,A2.VSL_CD || A2.SKD_VOY_NO || A2.DIR_CD  " ).append("\n"); 
		query.append("  ,A2.DIR_CD  " ).append("\n"); 
		query.append("  ,A2.CTRT_HQ_OFC_CD  " ).append("\n"); 
		query.append("  ,A2.CTRT_RGN_OFC_CD  " ).append("\n"); 
		query.append("  ,A2.CTRT_OFC_CD " ).append("\n"); 
		query.append("  ,A2.CTRT_SREP_CD  " ).append("\n"); 
		query.append("  ,A2.RHQ_CD  " ).append("\n"); 
		query.append("  ,A2.RGN_OFC_CD  " ).append("\n"); 
		query.append("  ,A2.SLS_OFC_CD  " ).append("\n"); 
		query.append("  ,A2.SREP_CD " ).append("\n"); 
		query.append("  ,A2.BKG_OFC_CD   " ).append("\n"); 
		query.append("  ,A2.BKG_STS_CD   " ).append("\n"); 
		query.append("  ,A2.USA_BKG_MOD_CD  " ).append("\n"); 
		query.append("  ,A2.BKG_POR_CD  " ).append("\n"); 
		query.append("  ,A2.BKG_POL_CD  " ).append("\n"); 
		query.append("  ,A2.BKG_POD_CD  " ).append("\n"); 
		query.append("  ,A2.BKG_DEL_CD  " ).append("\n"); 
		query.append("  ,A2.BKG_RCV_TERM_CD  " ).append("\n"); 
		query.append("  ,A2.BKG_DE_TERM_CD  " ).append("\n"); 
		query.append("  ,A2.REP_CMDT_CD /*4400*/  " ).append("\n"); 
		query.append("  ,A5.REP_CMDT_NM  " ).append("\n"); 
		query.append("  ,A2.CMDT_CD  " ).append("\n"); 
		query.append("  ,A3.CMDT_NM  " ).append("\n"); 
		query.append("  ,A2.N1ST_TRD_CD   " ).append("\n"); 
		query.append("  ,A2.N2ND_TRD_CD   " ).append("\n"); 
		query.append("  ,A2.N3RD_TRD_CD   " ).append("\n"); 
		query.append("  ,A2.N4TH_TRD_CD   " ).append("\n"); 
		query.append("  ,A2.N1ST_RLANE_CD  " ).append("\n"); 
		query.append("  ,A2.N2ND_RLANE_CD  " ).append("\n"); 
		query.append("  ,A2.N3RD_RLANE_CD  " ).append("\n"); 
		query.append("  ,A2.N4TH_RLANE_CD  " ).append("\n"); 
		query.append("  ,A2.N1ST_FINC_VVD_CD  " ).append("\n"); 
		query.append("  ,A2.N2ND_FINC_VVD_CD  " ).append("\n"); 
		query.append("  ,A2.N3RD_FINC_VVD_CD  " ).append("\n"); 
		query.append("  ,A2.N4TH_FINC_VVD_CD  " ).append("\n"); 
		query.append("  ,A2.N1ST_POL_CD  " ).append("\n"); 
		query.append("  ,A2.N2ND_POL_CD  " ).append("\n"); 
		query.append("  ,A2.N3RD_POL_CD  " ).append("\n"); 
		query.append("  ,A2.N4TH_POL_CD  " ).append("\n"); 
		query.append("  ,A2.N1ST_POD_CD  " ).append("\n"); 
		query.append("  ,A2.N2ND_POD_CD  " ).append("\n"); 
		query.append("  ,A2.N3RD_POD_CD  " ).append("\n"); 
		query.append("  ,A2.N4TH_POD_CD   " ).append("\n"); 
		query.append("  ,A2.SC_NO " ).append("\n"); 
		query.append("  ,A2.RFA_NO " ).append("\n"); 
		query.append("  ,DECODE(A2.CUST_TP_CD,'N','Y','N')" ).append("\n"); 
		query.append("  ,A2.AGMT_CUST_TP_CD  " ).append("\n"); 
		query.append("  ,A2.SC_RFA_HLD_CNT_CD || TO_CHAR(LPAD(DECODE(A2.SC_RFA_HLD_CUST_SEQ,0,'',A2.SC_RFA_HLD_CUST_SEQ),6,'0'))   /*SC_CUSTOMER CD  */" ).append("\n"); 
		query.append("  ,A2.AGMT_CNT_CD   " ).append("\n"); 
		query.append("  ,A2.AGMT_CUST_SEQ   " ).append("\n"); 
		query.append("  ,A2.SHPR_CNT_CD || TO_CHAR(LPAD(DECODE(A2.SHPR_CUST_SEQ,0,'',A2.SHPR_CUST_SEQ),6,'0')) /*SHPR_CD   */" ).append("\n"); 
		query.append("  ,A2.SHPR_CNT_CD   " ).append("\n"); 
		query.append("  ,A2.SHPR_CUST_SEQ" ).append("\n"); 
		query.append("  ,A2.CUST_TP_CD   " ).append("\n"); 
		query.append("  ,A2.SHPR_NM /*BL_SHPR_NM */" ).append("\n"); 
		query.append("  ,A2.CNEE_CNT_CD || TO_CHAR(LPAD(DECODE(A2.CNEE_CUST_SEQ,0,'',A2.CNEE_CUST_SEQ),6,'0')) /*CNEE_CD*/" ).append("\n"); 
		query.append("  ,A2.CNEE_CNT_CD   " ).append("\n"); 
		query.append("  ,A2.CNEE_CUST_SEQ  " ).append("\n"); 
		query.append("  ,A2.NTFY_CNT_CD || TO_CHAR(LPAD(DECODE(A2.NTFY_CUST_SEQ,0,'',A2.NTFY_CUST_SEQ),6,'0')) /*NTFY_CD */" ).append("\n"); 
		query.append("  ,A2.NTFY_CNT_CD   " ).append("\n"); 
		query.append("  ,A2.NTFY_CUST_SEQ   " ).append("\n"); 
		query.append("  ,A2.OFT_TP_CD  /*PPD_CCT*/" ).append("\n"); 
		query.append("  ,TO_CHAR(A2.OBRD_DT,'YYYY-MM-DD') /*BL_ONBOARD_DT */" ).append("\n"); 
		query.append("  ,TO_CHAR(A2.CNTR_RCV_DT,'YYYY-MM-DD') /*CGO_RCV_DT */" ).append("\n"); 
		query.append("  ,A2.SOC_FLG  " ).append("\n"); 
		query.append("  ,DECODE(A2.BKG_CGO_TP_CD, 'R', 'Y', 'N')  " ).append("\n"); 
		query.append("  ,NVL(A2.SPCL_RC_FLG, 'N')       -- SJH.20141112.ADD" ).append("\n"); 
		query.append("  ,NVL(A2.SPCL_DG_CGO_FLG, 'N') " ).append("\n"); 
		query.append("  ,NVL(A2.SPCL_BB_CGO_FLG, 'N') " ).append("\n"); 
		query.append("  ,NVL(A2.SPCL_AWK_CGO_FLG, 'N') " ).append("\n"); 
		query.append("  ,TO_CHAR(A2.BKG_CGO_WGT) " ).append("\n"); 
		query.append("  ,A2.BKG_WGT_TP_CD" ).append("\n"); 

	}
}
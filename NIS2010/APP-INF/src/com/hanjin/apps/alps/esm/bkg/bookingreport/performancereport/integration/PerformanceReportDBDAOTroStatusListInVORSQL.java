/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PerformanceReportDBDAOTroStatusListInVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOTroStatusListInVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PerformanceReportDBDAOTroStatusListInVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_staff",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pup_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pup_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOTroStatusListInVORSQL").append("\n"); 
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
		query.append("SELECT   ROWNUM RNUM" ).append("\n"); 
		query.append(",	BKG_NO        " ).append("\n"); 
		query.append(",	TRO_SEQ       " ).append("\n"); 
		query.append(",	TRO_SUB_SEQ   " ).append("\n"); 
		query.append(",	ACT_SHPR_NM   " ).append("\n"); 
		query.append(",	CNTC_PSON_NM  " ).append("\n"); 
		query.append(",	DOR_LOC_CD    " ).append("\n"); 
		query.append(",	TEU_A         " ).append("\n"); 
		query.append(",	TEU_B         " ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD  " ).append("\n"); 
		query.append(",	TRO_QTY       " ).append("\n"); 
		query.append(",	DOR_ARR_DT    " ).append("\n"); 
		query.append(",	PKUP_LOC_CD   " ).append("\n"); 
		query.append(",	RTN_LOC_CD    " ).append("\n"); 
		query.append(",	RCV_TERM_CD   " ).append("\n"); 
		query.append(",	RQST_DT       " ).append("\n"); 
		query.append(",	DIFF_RMK      " ).append("\n"); 
		query.append(",	POR_CD        " ).append("\n"); 
		query.append(",	POL_CD        " ).append("\n"); 
		query.append(",	POD_CD        " ).append("\n"); 
		query.append(",	DEL_CD        " ).append("\n"); 
		query.append(",	SLAN_CD       " ).append("\n"); 
		query.append(",	VVD_CD        " ).append("\n"); 
		query.append(",	EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append(",	BKG_OFC_CD    " ).append("\n"); 
		query.append(",	OWNR_TRK_FLG  " ).append("\n"); 
		query.append(",	CUST_CNT_CD   " ).append("\n"); 
		query.append(",	CUST_SEQ      " ).append("\n"); 
		query.append(",	PKUP_YD_CD    " ).append("\n"); 
		query.append(",	DOC_USR_ID    " ).append("\n"); 
		query.append(",	BKG_DT_FR     " ).append("\n"); 
		query.append(",	BKG_DT_TO     " ).append("\n"); 
		query.append(",	BKG_STS_CD    " ).append("\n"); 
		query.append(",	TRO_DT_FR     " ).append("\n"); 
		query.append(",	TRO_DT_TO     " ).append("\n"); 
		query.append(",	PUP_DT_FR     " ).append("\n"); 
		query.append(",	PUP_DT_TO     " ).append("\n"); 
		query.append(",	BKG_STAFF     " ).append("\n"); 
		query.append(",	DCGO_FLG      " ).append("\n"); 
		query.append(",	AWK_CGO_FLG   " ).append("\n"); 
		query.append(",	BB_CGO_FLG    " ).append("\n"); 
		query.append(",	RD_CGO_FLG    " ).append("\n"); 
		query.append(",	RC_FLG    " ).append("\n"); 
		query.append(",	SO_FLG    " ).append("\n"); 
		query.append(",	ZONE_CODE     " ).append("\n"); 
		query.append(",	H_LINE_TYPE   " ).append("\n"); 
		query.append(",	D_LINE_TYPE   " ).append("\n"); 
		query.append(",	MDST          " ).append("\n"); 
		query.append(",	IO_BND_CD     " ).append("\n"); 
		query.append(",	D2            " ).append("\n"); 
		query.append(",	D4            " ).append("\n"); 
		query.append(",	D5            " ).append("\n"); 
		query.append(",	D7            " ).append("\n"); 
		query.append(",	D8            " ).append("\n"); 
		query.append(",	D9            " ).append("\n"); 
		query.append(",	DW            " ).append("\n"); 
		query.append(",	DX            " ).append("\n"); 
		query.append(",	R2            " ).append("\n"); 
		query.append(",	R4            " ).append("\n"); 
		query.append(",	R5            " ).append("\n"); 
		query.append(",	F2            " ).append("\n"); 
		query.append(",	F4            " ).append("\n"); 
		query.append(",	F5            " ).append("\n"); 
		query.append(",	O2            " ).append("\n"); 
		query.append(",	O4            " ).append("\n"); 
		query.append(",	O5            " ).append("\n"); 
		query.append(",	S2            " ).append("\n"); 
		query.append(",	S4            " ).append("\n"); 
		query.append(",	T2            " ).append("\n"); 
		query.append(",	T4            " ).append("\n"); 
		query.append(",	A2            " ).append("\n"); 
		query.append(",	A4" ).append("\n"); 
		query.append(",	A5            " ).append("\n"); 
		query.append(",	P2            " ).append("\n"); 
		query.append(",	P4            " ).append("\n"); 
		query.append(",	Z2            " ).append("\n"); 
		query.append(",	Z4            " ).append("\n"); 
		query.append(",	TOT_SUM       " ).append("\n"); 
		query.append(",       STR  || (SELECT     'SubTotal : ' || BKG_JOIN_FNC(CURSOR(SELECT TROD2.CNTR_TPSZ_CD || '-'|| SUM(TROD2.TRO_QTY) TRO_QTY" ).append("\n"); 
		query.append("                                                             FROM  BKG_BOOKING VB2" ).append("\n"); 
		query.append("                                                               ,   BKG_TRO   TRO2" ).append("\n"); 
		query.append("                                                               ,   BKG_TRO_DTL TROD2" ).append("\n"); 
		query.append("                                                            WHERE  1=1" ).append("\n"); 
		query.append("                                                            AND    TRO2.BKG_NO = TROD2.BKG_NO(+)" ).append("\n"); 
		query.append("                                                            AND    TRO2.TRO_SEQ = TROD2.TRO_SEQ(+)" ).append("\n"); 
		query.append("                                                            AND    TRO2.IO_BND_CD = TROD2.IO_BND_CD(+)" ).append("\n"); 
		query.append("                                                            AND    TRO2.RTN_TRO_FLG = TROD2.RTN_TRO_FLG(+)" ).append("\n"); 
		query.append("                                                            AND    VB2.BKG_NO = TRO2.BKG_NO(+)" ).append("\n"); 
		query.append("                                                            AND    VB2.SLAN_CD = T.SLAN_CD" ).append("\n"); 
		query.append("                                                            AND    VB2.VSL_CD  = T.VSL_CD  --CMLB0039E" ).append("\n"); 
		query.append("                                                            AND    VB2.SKD_VOY_NO = T.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                            AND    VB2.SKD_DIR_CD =  T.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                            AND    TROD2.DOR_ARR_DT =  TO_DATE( T.DOR_ARR_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                                            AND    NVL(TROD2.PKUP_YD_CD,' ') =  NVL(T.PKUP_YD_CD,' ')" ).append("\n"); 
		query.append("                                                            GROUP BY TROD2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                            ORDER BY TROD2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                           )" ).append("\n"); 
		query.append("                                                    )" ).append("\n"); 
		query.append("		FROM DUAL" ).append("\n"); 
		query.append("       ) SUBGROUP_TITLE" ).append("\n"); 
		query.append(",	CUST_NM" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT /*+ RULE */ " ).append("\n"); 
		query.append("		VB.BKG_NO" ).append("\n"); 
		query.append(",	    TRO.TRO_SEQ" ).append("\n"); 
		query.append(",	    TROD.TRO_SUB_SEQ                 " ).append("\n"); 
		query.append(",	    TRO.ACT_SHPR_NM                    " ).append("\n"); 
		query.append(", 	   	TRO.CNTC_PSON_NM || TRO.CNTC_PHN_NO CNTC_PSON_NM    " ).append("\n"); 
		query.append(",	    TRO.DOR_LOC_CD                         " ).append("\n"); 
		query.append(",	    SUM(DECODE(GREATEST(2,SUBSTR(BQ.CNTR_TPSZ_CD,2,1)),2,NVL(BQ.OP_CNTR_QTY,0),0)) TEU_A" ).append("\n"); 
		query.append(", 	   	SUM(DECODE(GREATEST(2,SUBSTR(BQ.CNTR_TPSZ_CD,2,1)),2,0,NVL(BQ.OP_CNTR_QTY,0))) TEU_B" ).append("\n"); 
		query.append(",	    TROD.CNTR_TPSZ_CD                                   " ).append("\n"); 
		query.append(",	    TROD.TRO_QTY                                          " ).append("\n"); 
		query.append(",	    TO_CHAR(TROD.DOR_ARR_DT,'YYYY-MM-DD')  DOR_ARR_DT       " ).append("\n"); 
		query.append(",	    TROD.PKUP_YD_CD PKUP_LOC_CD      " ).append("\n"); 
		query.append(",	    TROD.RTN_YD_CD  RTN_LOC_CD        " ).append("\n"); 
		query.append(",	    TRO.RCV_TERM_CD                                       " ).append("\n"); 
		query.append(",       TRO.SO_FLG                                            " ).append("\n"); 
		query.append(",	    TO_CHAR(TRO.RQST_DT,'YYYY-MM-DD')  RQST_DT " ).append("\n"); 
		query.append(",	    Translate(NVL(TRO.DIFF_RMK,' '),chr(13)||chr(10),' ') DIFF_RMK                              " ).append("\n"); 
		query.append(",	    VB.POR_CD" ).append("\n"); 
		query.append(",	    VB.POL_CD" ).append("\n"); 
		query.append(",	    VB.POD_CD" ).append("\n"); 
		query.append(",	    VB.DEL_CD" ).append("\n"); 
		query.append(",	    VB.SLAN_CD                                 " ).append("\n"); 
		query.append(",	    VB.VSL_CD||VB.SKD_VOY_NO||VB.SKD_DIR_CD    VVD_CD" ).append("\n"); 
		query.append(",      	VB.VSL_CD" ).append("\n"); 
		query.append(",     	VB.SKD_VOY_NO" ).append("\n"); 
		query.append(",      	VB.SKD_DIR_CD" ).append("\n"); 
		query.append(",	    VB.EQ_CTRL_OFC_CD   --EQ OFFICE                      " ).append("\n"); 
		query.append(",	    VB.BKG_OFC_CD                            " ).append("\n"); 
		query.append(",	    TRO.OWNR_TRK_FLG   " ).append("\n"); 
		query.append(",      ''   CUST_CNT_CD" ).append("\n"); 
		query.append(",      ''   CUST_SEQ  " ).append("\n"); 
		query.append(",	   ''   CUST_NM " ).append("\n"); 
		query.append(",      ''   PKUP_YD_CD" ).append("\n"); 
		query.append(",      ''   DOC_USR_ID    --BKG Staff    " ).append("\n"); 
		query.append(",	   ''   BKG_DT_FR" ).append("\n"); 
		query.append(",	   ''   BKG_DT_TO" ).append("\n"); 
		query.append(",	   ''   BKG_STS_CD  " ).append("\n"); 
		query.append(",	   ''   TRO_DT_FR    " ).append("\n"); 
		query.append(",	   ''   TRO_DT_TO  " ).append("\n"); 
		query.append(",	   ''   PUP_DT_FR    " ).append("\n"); 
		query.append(",	   ''   PUP_DT_TO  " ).append("\n"); 
		query.append(",	   ''   BKG_STAFF    " ).append("\n"); 
		query.append(",      ''   DCGO_FLG" ).append("\n"); 
		query.append(",      '' 	AWK_CGO_FLG" ).append("\n"); 
		query.append(",      '' 	BB_CGO_FLG" ).append("\n"); 
		query.append(",      '' 	RD_CGO_FLG" ).append("\n"); 
		query.append(",      '' 	RC_FLG" ).append("\n"); 
		query.append(",	   ''   ZONE_CODE" ).append("\n"); 
		query.append(",	   'H'   H_LINE_TYPE" ).append("\n"); 
		query.append(",	   'D'   D_LINE_TYPE" ).append("\n"); 
		query.append(",	   ''    MDST" ).append("\n"); 
		query.append(",	   ''    IO_BND_CD" ).append("\n"); 
		query.append(",      SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD,'D2',TROD.TRO_QTY)),0)) D2" ).append("\n"); 
		query.append(",	   SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD,'D4',TROD.TRO_QTY)),0)) D4" ).append("\n"); 
		query.append(",	   SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD,'D5',TROD.TRO_QTY)),0)) D5" ).append("\n"); 
		query.append(",	   SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD,'D7',TROD.TRO_QTY)),0)) D7" ).append("\n"); 
		query.append(",	   SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD,'D8',TROD.TRO_QTY)),0)) D8" ).append("\n"); 
		query.append(",	   SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD,'D9',TROD.TRO_QTY)),0)) D9" ).append("\n"); 
		query.append(",	   SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD,'DW',TROD.TRO_QTY)),0)) DW" ).append("\n"); 
		query.append(",	   SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD,'DX',TROD.TRO_QTY)),0)) DX" ).append("\n"); 
		query.append(",	   SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD,'R2',TROD.TRO_QTY)),0)) R2" ).append("\n"); 
		query.append(",	   SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD,'R4',TROD.TRO_QTY)),0)) R4" ).append("\n"); 
		query.append(",	   SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD,'R5',TROD.TRO_QTY)),0)) R5" ).append("\n"); 
		query.append(",	   SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD,'F2',TROD.TRO_QTY)),0)) F2" ).append("\n"); 
		query.append(",	   SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD,'F4',TROD.TRO_QTY)),0)) F4" ).append("\n"); 
		query.append(",	   SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD,'F5',TROD.TRO_QTY)),0)) F5" ).append("\n"); 
		query.append(",      SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD,'O2',TROD.TRO_QTY)),0)) O2" ).append("\n"); 
		query.append(",	   SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD,'O4',TROD.TRO_QTY)),0)) O4" ).append("\n"); 
		query.append(",	   SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD,'O5',TROD.TRO_QTY)),0)) O5" ).append("\n"); 
		query.append(",	   SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD,'S2',TROD.TRO_QTY)),0)) S2" ).append("\n"); 
		query.append(",	   SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD,'S4',TROD.TRO_QTY)),0)) S4" ).append("\n"); 
		query.append(",	   SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD,'T2',TROD.TRO_QTY)),0)) T2" ).append("\n"); 
		query.append(",	   SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD,'T4',TROD.TRO_QTY)),0)) T4" ).append("\n"); 
		query.append(",	   SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD,'A2',TROD.TRO_QTY)),0)) A2" ).append("\n"); 
		query.append(",	   SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD,'A4',TROD.TRO_QTY)),0)) A4" ).append("\n"); 
		query.append(",	   SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD,'A5',TROD.TRO_QTY)),0)) A5" ).append("\n"); 
		query.append(",	   SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD,'P2',TROD.TRO_QTY)),0)) P2" ).append("\n"); 
		query.append(",	   SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD,'P4',TROD.TRO_QTY)),0)) P4" ).append("\n"); 
		query.append(",	   SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD,'Z2',TROD.TRO_QTY)),0)) Z2" ).append("\n"); 
		query.append(",	   SUM(NVL(GREATEST(DECODE(BQ.CNTR_TPSZ_CD,'Z4',TROD.TRO_QTY)),0)) Z4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	   '0' TOT_SUM" ).append("\n"); 
		query.append(",    'Lane : ' || VB.SLAN_CD || '	Trunk VVD : ' || VB.VSL_CD||VB.SKD_VOY_NO||VB.SKD_DIR_CD || '	P/UP Date : ' || TO_CHAR(TROD.DOR_ARR_DT,'YYYY-MM-DD') || '	P/UP Yard : ' ||  TROD.PKUP_YD_CD STR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	 (SELECT  /*+ ORDERED USE_NL(VB BC TRO) */" ).append("\n"); 
		query.append("              VB.ROWID   BKG_RID," ).append("\n"); 
		query.append("              TRO.ROWID  TRO_RID" ).append("\n"); 
		query.append("      FROM    BKG_BOOKING  VB," ).append("\n"); 
		query.append("              BKG_CUSTOMER BC,      " ).append("\n"); 
		query.append("              BKG_TRO      TRO" ).append("\n"); 
		query.append("      WHERE   VB.BKG_NO = TRO.BKG_NO(+)" ).append("\n"); 
		query.append("      AND     VB.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("      AND     BC.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("#if (${bkg_dt_fr} != '') " ).append("\n"); 
		query.append("	  AND     VB.BKG_CRE_DT > TO_DATE(@[bkg_dt_fr],'YYYY-MM-DD') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_dt_to} != '') " ).append("\n"); 
		query.append("	  AND 	  VB.BKG_CRE_DT <= TO_DATE(@[bkg_dt_to],'YYYY-MM-DD') + 0.99999     --BKG Date" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND     TRO.CXL_FLG    =  'N'" ).append("\n"); 
		query.append("      AND     TRO.IO_BND_CD =   NVL(@[io_bnd_cd],'O')" ).append("\n"); 
		query.append("#if (${vvd_cd} != '') " ).append("\n"); 
		query.append("	  AND   	VB.VSL_CD      =  SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("      AND   	VB.SKD_VOY_NO  =  SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("      AND   	VB.SKD_DIR_CD  =  SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       )  A" ).append("\n"); 
		query.append(",		BKG_BOOKING VB " ).append("\n"); 
		query.append(",	     BKG_TRO   TRO " ).append("\n"); 
		query.append(",	     BKG_QUANTITY  BQ  " ).append("\n"); 
		query.append(",	     BKG_TRO_DTL TROD " ).append("\n"); 
		query.append(",        MAS_RGST_BKG MAS" ).append("\n"); 
		query.append("WHERE 	A.BKG_RID = VB.ROWID" ).append("\n"); 
		query.append("AND     A.TRO_RID = TRO.ROWID" ).append("\n"); 
		query.append("AND		TRO.BKG_NO = TROD.BKG_NO(+)" ).append("\n"); 
		query.append("AND   	TRO.TRO_SEQ = TROD.TRO_SEQ(+)  " ).append("\n"); 
		query.append("AND     TRO.IO_BND_CD = TROD.IO_BND_CD(+)" ).append("\n"); 
		query.append("AND     TRO.RTN_TRO_FLG = TROD.RTN_TRO_FLG(+)" ).append("\n"); 
		query.append("AND   	VB.BKG_NO   = BQ.BKG_NO" ).append("\n"); 
		query.append("AND   	VB.BKG_NO = TRO.BKG_NO(+) " ).append("\n"); 
		query.append("AND   	TRO.CXL_FLG    =  'N'  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("AND   	VB.BKG_NO      =  @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != '') " ).append("\n"); 
		query.append("AND     TRO.IO_BND_CD =   @[io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_sts_cd} != '') " ).append("\n"); 
		query.append("	--AND VB.BKG_STS_CD  IN (${bkg_sts_cd})" ).append("\n"); 
		query.append("	AND VB.BKG_STS_CD  IN (SELECT * FROM table(BKG_SPLIT_FNC(@[bkg_sts_cd])))" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd_cd} != '') " ).append("\n"); 
		query.append("AND   	VB.VSL_CD      =  SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("AND   	VB.SKD_VOY_NO  =  SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("AND   	VB.SKD_DIR_CD  =  SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--IPT : POR과 DEL이 같은 Continent 일 경우  OCN : POR과 DEL이 다른 Continent 일 경우" ).append("\n"); 
		query.append("AND     VB.BKG_NO = MAS.BKG_NO" ).append("\n"); 
		query.append("#if (${zone_code} != '') " ).append("\n"); 
		query.append("	#if (${zone_code} == 'I') " ).append("\n"); 
		query.append("--AND  SUBSTR(VB.ORG_SCONTI_CD,1,1) = SUBSTR(VB.DEST_SCONTI_CD,1,1)  --  IPT" ).append("\n"); 
		query.append("AND     MAS.IOC_CD = 'I'" ).append("\n"); 
		query.append("	#elseif (${zone_code} == 'O') " ).append("\n"); 
		query.append("--AND  SUBSTR(VB.ORG_SCONTI_CD,1,1) != SUBSTR(VB.DEST_SCONTI_CD,1,1)  -- OCN" ).append("\n"); 
		query.append("AND     MAS.IOC_CD = 'O'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND   	EXISTS (SELECT 'X' FROM BKG_CUSTOMER BC " ).append("\n"); 
		query.append("				WHERE 	BC.BKG_NO  = VB.BKG_NO " ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '') " ).append("\n"); 
		query.append("				AND 	BC.CUST_CNT_CD = @[cust_cnt_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '') 				" ).append("\n"); 
		query.append("				AND 	CUST_SEQ= @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_nm} != '') " ).append("\n"); 
		query.append("				AND 	CUST_NM like @[cust_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${io_bnd_cd} == 'O') " ).append("\n"); 
		query.append("				AND BKG_CUST_TP_CD='S'" ).append("\n"); 
		query.append("#elseif (${io_bnd_cd} == 'I') " ).append("\n"); 
		query.append("				AND BKG_CUST_TP_CD='C'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("#if (${pkup_loc_cd} != '') " ).append("\n"); 
		query.append("	#if (${pkup_yd_cd} != '') " ).append("\n"); 
		query.append("		AND   	TROD.PKUP_YD_CD  = @[pkup_loc_cd] || NVL(@[pkup_yd_cd],'') " ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("		AND   	TROD.PKUP_LOC_CD  LIKE @[pkup_loc_cd] || '%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#elseif (${pkup_yd_cd} != '') " ).append("\n"); 
		query.append("	AND   	TROD.PKUP_LOC_CD   LIKE NVL(@[pkup_loc_cd],'') ||  NVL(@[pkup_yd_cd],'')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_dt_fr} != '') " ).append("\n"); 
		query.append("AND   	VB.BKG_CRE_DT > TO_DATE(@[bkg_dt_fr],'YYYY-MM-DD') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_dt_to} != '') " ).append("\n"); 
		query.append("AND 	VB.BKG_CRE_DT <= TO_DATE(@[bkg_dt_to],'YYYY-MM-DD') + 0.99999     --BKG Date" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${tro_dt_fr} != '') " ).append("\n"); 
		query.append("AND   	TRO.RQST_DT >= TO_DATE(@[tro_dt_fr],'YYYY-MM-DD') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${tro_dt_to} != '') " ).append("\n"); 
		query.append("AND   	TRO.RQST_DT <= TO_DATE(@[tro_dt_to],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pup_dt_fr} != '') " ).append("\n"); 
		query.append("AND   	TROD.DOR_ARR_DT >= TO_DATE(@[pup_dt_fr],'YYYY-MM-DD') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pup_dt_to} != '') " ).append("\n"); 
		query.append("AND   	TROD.DOR_ARR_DT <= TO_DATE(@[pup_dt_to],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("AND   	VB.BKG_OFC_CD    = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${slan_cd} != '') " ).append("\n"); 
		query.append("AND   	VB.SLAN_CD       = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_staff} != '') " ).append("\n"); 
		query.append("AND   	VB.DOC_USR_ID = @[bkg_staff]		--BKG Staff" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("AND   	VB.POL_CD        = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eq_ctrl_ofc_cd} != '') " ).append("\n"); 
		query.append("AND   	VB.EQ_CTRL_OFC_CD = @[eq_ctrl_ofc_cd]  --EQ OFFICE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${dcgo_flg} !=''||${rc_flg} !=''||${awk_cgo_flg} !=''||${bb_cgo_flg} !=''||${so_flg} !='')" ).append("\n"); 
		query.append("AND (1=2 " ).append("\n"); 
		query.append("#if (${dcgo_flg} == 'DG')" ).append("\n"); 
		query.append("	OR VB.DCGO_FLG ='Y' --Special DG   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rc_flg} == 'RF') " ).append("\n"); 
		query.append("	OR VB.RC_FLG = 'Y'		--Special RF  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${awk_cgo_flg} == 'AK') " ).append("\n"); 
		query.append("	OR VB.AWK_CGO_FLG = 'Y'	--Special AK  " ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("#if (${bb_cgo_flg} == 'BB') " ).append("\n"); 
		query.append("	OR VB.BB_CGO_FLG = 'Y'	--Special BB  " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${so_flg} == 'Y') " ).append("\n"); 
		query.append("	OR TRO.SO_FLG       = @[so_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY  'Lane : ' || VB.SLAN_CD || ' Trunk VVD : ' || VB.VSL_CD||VB.SKD_VOY_NO||VB.SKD_DIR_CD || ' P/UP Date : ' || TO_CHAR(TROD.DOR_ARR_DT,'YYYY-MM-DD') || ' P/UP Yard : ' || TROD.PKUP_YD_CD" ).append("\n"); 
		query.append(",	    VB.SLAN_CD,VB.VSL_CD ,VB.SKD_VOY_NO,VB.SKD_DIR_CD,TROD.DOR_ARR_DT" ).append("\n"); 
		query.append(",	    VB.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	     TRO.TRO_SEQ" ).append("\n"); 
		query.append(",	     TROD.TRO_SUB_SEQ                 " ).append("\n"); 
		query.append(",	     TRO.ACT_SHPR_NM                    " ).append("\n"); 
		query.append(", 	   	 TRO.CNTC_PSON_NM || TRO.CNTC_PHN_NO " ).append("\n"); 
		query.append(",	     TRO.DOR_LOC_CD                         " ).append("\n"); 
		query.append(",	     TROD.CNTR_TPSZ_CD                                   " ).append("\n"); 
		query.append(",	     TROD.TRO_QTY                                          " ).append("\n"); 
		query.append(",	     TO_CHAR(TROD.DOR_ARR_DT,'YYYY-MM-DD')      " ).append("\n"); 
		query.append(",	     TROD.PKUP_YD_CD " ).append("\n"); 
		query.append(",	     TROD.RTN_YD_CD " ).append("\n"); 
		query.append(",	     TRO.RCV_TERM_CD                                       " ).append("\n"); 
		query.append(",      	 TRO.SO_FLG                                            " ).append("\n"); 
		query.append(",	     TO_CHAR(TRO.RQST_DT,'YYYY-MM-DD') " ).append("\n"); 
		query.append(",	     Translate(NVL(TRO.DIFF_RMK,' '),chr(13)||chr(10),' ')                           " ).append("\n"); 
		query.append(",	     VB.POR_CD" ).append("\n"); 
		query.append(",	     VB.POL_CD" ).append("\n"); 
		query.append(",	     VB.POD_CD" ).append("\n"); 
		query.append(",	     VB.DEL_CD" ).append("\n"); 
		query.append(",	     VB.SLAN_CD                                 " ).append("\n"); 
		query.append(",	     VB.VSL_CD||VB.SKD_VOY_NO||VB.SKD_DIR_CD " ).append("\n"); 
		query.append(",	     VB.EQ_CTRL_OFC_CD                         " ).append("\n"); 
		query.append(",	     VB.BKG_OFC_CD                            " ).append("\n"); 
		query.append(",	     TRO.OWNR_TRK_FLG" ).append("\n"); 
		query.append("ORDER BY 'Lane : ' || VB.SLAN_CD || ' Trunk VVD : ' || VB.VSL_CD||VB.SKD_VOY_NO||VB.SKD_DIR_CD || ' P/UP Date : ' || TO_CHAR(TROD.DOR_ARR_DT,'YYYY-MM-DD') || ' P/UP Yard : ' || TROD.PKUP_YD_CD" ).append("\n"); 
		query.append(",	    VB.BKG_NO" ).append("\n"); 
		query.append(",	     TRO.TRO_SEQ" ).append("\n"); 
		query.append(",	     TROD.TRO_SUB_SEQ                 " ).append("\n"); 
		query.append(",	     TRO.ACT_SHPR_NM                    " ).append("\n"); 
		query.append(", 	   	 TRO.CNTC_PSON_NM || TRO.CNTC_PHN_NO " ).append("\n"); 
		query.append(",	     TRO.DOR_LOC_CD                         " ).append("\n"); 
		query.append(",	     TROD.CNTR_TPSZ_CD  " ).append("\n"); 
		query.append(") T" ).append("\n"); 

	}
}
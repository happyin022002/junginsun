/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StatusReportDBDAOsearchWarningReportListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOsearchWarningReportListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StatusReportDBDAOsearchWarningReportListRSQL
	  * </pre>
	  */
	public StatusReportDBDAOsearchWarningReportListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trunk_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("board_from_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("warn_cust_b",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eta_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("warn_cust_c",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("warn_cust_i",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_local",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eta_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("board_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("warn_cust_s",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("c_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("warn_cust_y",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_local",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("l_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("warn_cargo_p",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("warn_cargo_m",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_ts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_ts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOsearchWarningReportListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("--BV.POL_CD, BV.POD_CD," ).append("\n"); 
		query.append("BB.BKG_NO" ).append("\n"); 
		query.append(",BLCK_KW_TP_CD,BLCK_KW_TP_SEQ" ).append("\n"); 
		query.append(",BB.BL_NO" ).append("\n"); 
		query.append(",BB.OB_SLS_OFC_CD" ).append("\n"); 
		query.append(",BB.CTRT_OFC_CD" ).append("\n"); 
		query.append(",OP_CNTR_QTY" ).append("\n"); 
		query.append(",INTER_XTER_RMK_KW_NM" ).append("\n"); 
		query.append(",SHPR_SEQ" ).append("\n"); 
		query.append(",FWRD_SEQ" ).append("\n"); 
		query.append(",CNEE_SEQ" ).append("\n"); 
		query.append(",BM.POR_CD" ).append("\n"); 
		query.append(",BM.POL_CD" ).append("\n"); 
		query.append(",BM.POD_CD" ).append("\n"); 
		query.append(",BM.DEL_CD" ).append("\n"); 
		query.append(",BM.CMDT_CD" ).append("\n"); 
		query.append(",BM.CSTMS_DESC_KW_NM" ).append("\n"); 
		query.append(",BM.CMDT_DESC_KW_NM" ).append("\n"); 
		query.append(",BM.CUST_DESC_KW_NM" ).append("\n"); 
		query.append(",BM.CNTR_MF_GDS_DESC_KW_NM" ).append("\n"); 
		query.append(",REPLACE(BM.SHPR_KW_NM ,CHR(13)||CHR(10),' ')SHPR_NAME" ).append("\n"); 
		query.append(",REPLACE(BM.FWRD_KW_NM ,CHR(13)||CHR(10),' ')FFDR_NAME" ).append("\n"); 
		query.append(",REPLACE(BM.CNEE_KW_NM ,CHR(13)||CHR(10),' ')CNEE_NAME" ).append("\n"); 
		query.append(", NVL(DECODE(BM.SHPR_CNT_CD||BM.SHPR_SEQ,'',' ',SUBSTR(BM.SHPR_CNT_CD||BM.SHPR_SEQ,1,2)||LTRIM(TO_CHAR(SUBSTR(BM.SHPR_CNT_CD||BM.SHPR_SEQ,3),'000000'))),' ') AS SHIPPER" ).append("\n"); 
		query.append(", NVL(DECODE(BM.FWRD_CNT_CD||BM.FWRD_SEQ,'',' ',SUBSTR(BM.FWRD_CNT_CD||BM.FWRD_SEQ,1,2)||LTRIM(TO_CHAR(SUBSTR(BM.FWRD_CNT_CD||BM.FWRD_SEQ,3),'000000'))),' ') AS FFDR" ).append("\n"); 
		query.append(", NVL(DECODE(BM.CNEE_CNT_CD||BM.CNEE_SEQ,'',' ',SUBSTR(BM.CNEE_CNT_CD||BM.CNEE_SEQ,1,2)||LTRIM(TO_CHAR(SUBSTR(BM.CNEE_CNT_CD||BM.CNEE_SEQ,3),'000000'))),' ') AS CONSIGNEE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--,REPLACE(S.CUST_NM ,CHR(13)||CHR(10),' ')SHPR_NAME" ).append("\n"); 
		query.append("--,REPLACE(F.CUST_NM ,CHR(13)||CHR(10),' ')FFDR_NAME" ).append("\n"); 
		query.append("--,REPLACE(C.CUST_NM ,CHR(13)||CHR(10),' ')CNEE_NAME" ).append("\n"); 
		query.append("--, NVL(DECODE(S.CUST_CNT_CD||S.CUST_SEQ,'',' ',SUBSTR(S.CUST_CNT_CD||S.CUST_SEQ,1,2)||LTRIM(TO_CHAR(SUBSTR(S.CUST_CNT_CD||S.CUST_SEQ,3),'000000'))),' ') AS SHIPPER" ).append("\n"); 
		query.append("--, NVL(DECODE(F.CUST_CNT_CD||F.CUST_SEQ,'',' ',SUBSTR(F.CUST_CNT_CD||F.CUST_SEQ,1,2)||LTRIM(TO_CHAR(SUBSTR(F.CUST_CNT_CD||F.CUST_SEQ,3),'000000'))),' ') AS FFDR" ).append("\n"); 
		query.append("--, NVL(DECODE(C.CUST_CNT_CD||C.CUST_SEQ,'',' ',SUBSTR(C.CUST_CNT_CD||C.CUST_SEQ,1,2)||LTRIM(TO_CHAR(SUBSTR(C.CUST_CNT_CD||C.CUST_SEQ,3),'000000'))),' ') AS CONSIGNEE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM BKG_BOOKING BB " ).append("\n"); 
		query.append(", BKG_VVD BV" ).append("\n"); 
		query.append(", BKG_BLCK_LIST_MNTR BM " ).append("\n"); 
		query.append(", BKG_CUSTOMER S" ).append("\n"); 
		query.append(", BKG_CUSTOMER F" ).append("\n"); 
		query.append(", BKG_CUSTOMER C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("-----------------------------------------------------------------------------1st vvd etd--" ).append("\n"); 
		query.append("#if (${board_from_dt} != '')" ).append("\n"); 
		query.append("AND bm.bkg_no --bb.BKG_NO" ).append("\n"); 
		query.append(" IN ( SELECT DISTINCT BKG.BKG_NO" ).append("\n"); 
		query.append("		FROM BKG_VVD VVD, BKG_BOOKING BKG" ).append("\n"); 
		query.append("	   WHERE ( VVD.VSL_CD,VVD.SKD_VOY_NO,VVD.SKD_DIR_CD,VVD.POL_CD,VVD.POL_CLPT_IND_SEQ ) IN" ).append("\n"); 
		query.append("            		     ( SELECT A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD,A.VPS_PORT_CD,A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("            				 FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("            				WHERE A.VPS_ETD_DT >= TO_DATE(@[board_from_dt] , 'YYYY-MM-DD')" ).append("\n"); 
		query.append("            				  AND A.VPS_ETD_DT <= TO_DATE(@[board_to_dt] , 'YYYY-MM-DD') +0.99999)" ).append("\n"); 
		query.append("		 AND BB.BKG_NO  = BKG.BKG_NO" ).append("\n"); 
		query.append("		 AND VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("		 AND VVD.POL_CD = BKG.POL_CD" ).append("\n"); 
		query.append("		 AND ( VVD.VSL_PRE_PST_CD, VVD.VSL_SEQ) IN ( ('S',1),('T',0) )" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-----------------------------------------------------------------------------last vvd eta--" ).append("\n"); 
		query.append("#if (${eta_from_dt} != '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND bm.bkg_no  --bb.BKG_NO" ).append("\n"); 
		query.append(" IN ( SELECT DISTINCT BKG.BKG_NO" ).append("\n"); 
		query.append("		FROM BKG_VVD VVD, BKG_BOOKING BKG" ).append("\n"); 
		query.append("	   WHERE ( VVD.VSL_CD,VVD.SKD_VOY_NO,VVD.SKD_DIR_CD,VVD.POD_CD,VVD.POD_CLPT_IND_SEQ ) IN" ).append("\n"); 
		query.append("		     ( SELECT A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD,A.VPS_PORT_CD,A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("				 FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("				WHERE A.VPS_ETA_DT >= TO_DATE(@[eta_from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("				  AND A.VPS_ETA_DT <= TO_DATE(@[eta_to_dt], 'YYYY-MM-DD') +0.99999)" ).append("\n"); 
		query.append("		 AND BB.BKG_NO  = BKG.BKG_NO" ).append("\n"); 
		query.append("		 AND VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("		 AND VVD.POD_CD = BKG.POD_CD" ).append("\n"); 
		query.append("		 AND VVD.VSL_PRE_PST_CD IN ('T','U')" ).append("\n"); 
		query.append("		 AND (VVD.VSL_PRE_PST_CD, VVD.VSL_SEQ) = (SELECT /*+ INDEX_DESC (VVD2 XPKBKG_VVD) */ VVD2.VSL_PRE_PST_CD, VVD2.VSL_SEQ" ).append("\n"); 
		query.append("													 FROM BKG_VVD VVD2" ).append("\n"); 
		query.append("													WHERE VVD2.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("													  AND VVD2.VSL_PRE_PST_CD IN ('T','U')" ).append("\n"); 
		query.append("													  AND ROWNUM = 1)" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("----------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("and bb.bkg_no = bm.bkg_no " ).append("\n"); 
		query.append("AND S.BKG_CUST_TP_CD ='S'" ).append("\n"); 
		query.append("AND BB.BKG_NO = S.BKG_NO" ).append("\n"); 
		query.append("AND F.BKG_CUST_TP_CD(+) ='F'" ).append("\n"); 
		query.append("AND BB.BKG_NO = F.BKG_NO(+)" ).append("\n"); 
		query.append("AND C.BKG_CUST_TP_CD ='C'" ).append("\n"); 
		query.append("AND BB.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND NVL(BB.NEW_CUST_APRO_FLG,'X') = DECODE(@[warn_cust_s],'S','Y',NVL(BB.NEW_CUST_APRO_FLG,'X'))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("and bb.bkg_no = bv.bkg_no" ).append("\n"); 
		query.append("AND     nvl(bv.VSL_CD ,'X')     = decode(@[vvd_cd] , null, nvl(bv.VSL_CD,'X'), SUBSTR(@[vvd_cd] , 1, 4))" ).append("\n"); 
		query.append("AND     nvl(bv.SKD_VOY_NO ,'X') = decode(@[vvd_cd] , null, nvl(bv.SKD_VOY_NO,'X'),  SUBSTR(@[vvd_cd] , 5, 4))" ).append("\n"); 
		query.append("AND     nvl(bv.SKD_DIR_CD ,'X') = decode(@[vvd_cd] , null, nvl(bv.SKD_DIR_CD,'X'), SUBSTR(@[vvd_cd] , 9, 1))" ).append("\n"); 
		query.append("and     bv.VSL_PRE_PST_CD = case" ).append("\n"); 
		query.append("                                when @[trunk_flag] ='Y' then 'T'      /* trunk flag */" ).append("\n"); 
		query.append("                                when length(@[lane_cd]) > 0 then 'T'  /* lane */" ).append("\n"); 
		query.append("                                else bv.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                            end  /* trunk flag */" ).append("\n"); 
		query.append("and bv.SLAN_CD = nvl(@[lane_cd] , bv.SLAN_CD )/* lane */" ).append("\n"); 
		query.append("and bv.SKD_DIR_CD = nvl(@[dir_cd], bv.SKD_DIR_CD )  /*dir */" ).append("\n"); 
		query.append("--------------POL 처리 --------------------------------------------------------" ).append("\n"); 
		query.append("and bv.pol_cd LIKE nvl(@[pol_cd], bv.pol_cd)||'%' /*pol*/" ).append("\n"); 
		query.append("and bv.pol_cd = decode(@[pol_local] ,'Y',bb.pol_cd, bv.pol_cd )/*pol_local*/" ).append("\n"); 
		query.append("and 'Y' = case when @[pol_ts] = 'Y' then " ).append("\n"); 
		query.append("            case when  instr(bb.pol_cd, bv.pol_cd ) = 0 then 'Y'" ).append("\n"); 
		query.append("                 else 'N'" ).append("\n"); 
		query.append("            end" ).append("\n"); 
		query.append("          else 'Y'" ).append("\n"); 
		query.append("          end /* pol_ts */" ).append("\n"); 
		query.append("AND SUBSTR(bv.POL_YD_CD,-2) = nvl(@[pol_yard_cd],SUBSTR(bv.POL_YD_CD,-2)) /* pol_yard_cd */" ).append("\n"); 
		query.append("--------------POD 처리 --------------------------------------------------------" ).append("\n"); 
		query.append("and bv.pod_cd like nvl(@[pod_cd], bv.pod_cd)||'%' /*pod*/" ).append("\n"); 
		query.append("and bv.pod_cd = decode(@[pod_local] ,'Y',bb.pod_cd, bv.pod_cd )/*pod_local*/" ).append("\n"); 
		query.append("and 'Y' = case when @[pod_ts] = 'Y' then " ).append("\n"); 
		query.append("            case when  instr(bb.pod_cd, bv.pod_cd ) = 0 then 'Y'" ).append("\n"); 
		query.append("                 else 'N'" ).append("\n"); 
		query.append("            end" ).append("\n"); 
		query.append("          else 'Y'" ).append("\n"); 
		query.append("          end /* pod_ts */          " ).append("\n"); 
		query.append("AND SUBSTR(bv.POD_YD_CD,-2) = nvl(@[pod_yard_cd], SUBSTR(bv.POD_YD_CD,-2))/* pod_yard_cd*/" ).append("\n"); 
		query.append("-----------------------------------------------------------------------POR,DEL --------" ).append("\n"); 
		query.append("and bb.POR_CD like nvl(@[por_cd], bb.por_cd)||'%' /* por_cd */" ).append("\n"); 
		query.append("and bb.del_cd like nvl(@[del_cd], bb.del_cd)||'%'  /* del_cd */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-----------------------------------------------------------------------------bkg create date--" ).append("\n"); 
		query.append("#if (${bkg_from_dt} != '')" ).append("\n"); 
		query.append("/* bkg_from_dt    */" ).append("\n"); 
		query.append("AND BB.BKG_CRE_DT >= TO_DATE(@[bkg_from_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_to_dt} != '')" ).append("\n"); 
		query.append("/* bkg_to_dt      */" ).append("\n"); 
		query.append("AND BB.BKG_CRE_DT <= TO_DATE(@[bkg_to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                           " ).append("\n"); 
		query.append("#if (${b_ofc_cd} != '')" ).append("\n"); 
		query.append("/* b_ofc_cd       *//* b_ofc_cd_sub   */" ).append("\n"); 
		query.append("#if(${b_ofc_cd_sub} != '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" AND BB.BKG_OFC_CD IN ( ${b_ofc_cd_sub} )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" AND BB.BKG_OFC_CD IN ( ${b_ofc_cd} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${l_ofc_cd} != '')" ).append("\n"); 
		query.append("/* l_ofc_cd *//* l_ofc_cd_sub */" ).append("\n"); 
		query.append("#if(${l_ofc_cd_sub} != '')" ).append("\n"); 
		query.append(" AND BB.OB_SLS_OFC_CD   IN ( SELECT OFC_N8TH_LVL_CD" ).append("\n"); 
		query.append("                              FROM   DMT_OFC_LVL_V" ).append("\n"); 
		query.append("                              WHERE @[l_ofc_cd] IN (OFC_N1ST_LVL_CD, OFC_N2ND_LVL_CD, OFC_N3RD_LVL_CD, OFC_N4TH_LVL_CD," ).append("\n"); 
		query.append("                                                    OFC_N5TH_LVL_CD, OFC_N6TH_LVL_CD, OFC_N7TH_LVL_CD, OFC_N8TH_LVL_CD)" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" AND BB.OB_SLS_OFC_CD = @[l_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${c_ofc_cd} != '')" ).append("\n"); 
		query.append("/* c_ofc_cd *//* c_ofc_cd_sub */" ).append("\n"); 
		query.append("#if(${c_ofc_cd_sub} != '')" ).append("\n"); 
		query.append(" AND BB.CTRT_OFC_CD   IN ( SELECT OFC_N8TH_LVL_CD" ).append("\n"); 
		query.append("                         FROM   DMT_OFC_LVL_V" ).append("\n"); 
		query.append("                         WHERE @[c_ofc_cd] IN (OFC_N1ST_LVL_CD, OFC_N2ND_LVL_CD, OFC_N3RD_LVL_CD, OFC_N4TH_LVL_CD," ).append("\n"); 
		query.append("                                                    OFC_N5TH_LVL_CD, OFC_N6TH_LVL_CD, OFC_N7TH_LVL_CD, OFC_N8TH_LVL_CD)" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" AND BB.CTRT_OFC_CD = @[c_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND BLCK_KW_TP_CD IN (" ).append("\n"); 
		query.append("		DECODE(@[warn_cust_b],'B','BLA','')," ).append("\n"); 
		query.append("        DECODE(@[warn_cust_y],'Y','YEL','')," ).append("\n"); 
		query.append("        DECODE(@[warn_cust_c],'C','CAL','')," ).append("\n"); 
		query.append("        DECODE(@[warn_cust_i],'I','SAN','')," ).append("\n"); 
		query.append("        DECODE(@[warn_cargo_p],'P','POT','')," ).append("\n"); 
		query.append("        DECODE(@[warn_cargo_m],'M','MIS','')," ).append("\n"); 
		query.append("	    DECODE(@[warn_cust_b], NULL, " ).append("\n"); 
		query.append("							   DECODE(@[warn_cust_y], NULL," ).append("\n"); 
		query.append("							   DECODE(@[warn_cust_c], NULL," ).append("\n"); 
		query.append("                               DECODE(@[warn_cargo_p], NULL," ).append("\n"); 
		query.append("                               DECODE(@[warn_cust_i], NULL," ).append("\n"); 
		query.append("                               DECODE(@[warn_cargo_m], NULL, BLCK_KW_TP_CD))))))  	" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY BB.BKG_NO,BLCK_KW_TP_CD,BLCK_KW_TP_SEQ" ).append("\n"); 

	}
}
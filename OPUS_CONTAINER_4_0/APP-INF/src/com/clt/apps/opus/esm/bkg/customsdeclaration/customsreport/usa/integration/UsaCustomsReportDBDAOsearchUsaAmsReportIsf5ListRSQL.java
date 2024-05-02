/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : UsaCustomsReportDBDAOsearchUsaAmsReportIsf5ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.03
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsReportDBDAOsearchUsaAmsReportIsf5ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 0041 Ams Report(ISF5) 조회. 생성 VO명 : UsaAmsReportIsf5ListVO
	  * </pre>
	  */
	public UsaCustomsReportDBDAOsearchUsaAmsReportIsf5ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hub",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ams_file_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mbl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tot",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("b_stf",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("l_rep",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsReportDBDAOsearchUsaAmsReportIsf5ListRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("#if (${mbl_no} == '' && ${ams_file_no} == '' " ).append("\n"); 
		query.append("    && ${date_search} != '' && ${cust_arr_exp} != '' && ${fromd} != '' && ${tod} != '')" ).append("\n"); 
		query.append("        SELECT BL.*" ).append("\n"); 
		query.append("              ,REPLACE(REPLACE(REPLACE(CU.CUST_NM, CHR(13)||CHR(10),' '), CHR(13), ' '), CHR(10), ' ') AS CUST_NM" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT BL.CNT_CD" ).append("\n"); 
		query.append("                      ,BKG.BKG_NO" ).append("\n"); 
		query.append("                      ,BKG.BL_NO AS MBL_NO" ).append("\n"); 
		query.append("                      ,BL.BL_NO AS AMS_FILE_NO" ).append("\n"); 
		query.append("                      ,DECODE(BL.MF_NO, NULL, NVL(BL.CSTMS_FILE_TP_CD, BKG.USA_CSTMS_FILE_CD),'0') AS FILER" ).append("\n"); 
		query.append("                      ,DECODE(BL.MF_NO, NULL, 'M', 'H') AS MH" ).append("\n"); 
		query.append("                      ,BL.CSTMS_POL_CD AS POL_CD" ).append("\n"); 
		query.append("                      ,BL.CSTMS_POD_CD AS POD_CD" ).append("\n"); 
		query.append("                      ,DECODE(LG.ISF_ACT_CD, 'A','ADD','R','REPLACE','D','DELETE') AS ISF_ACT_CD" ).append("\n"); 
		query.append("                      ,LG.ISF_RSLT_CD" ).append("\n"); 
		query.append("                      ,CD.INTG_CD_VAL_DESC AS ISF_RSLT_DESC" ).append("\n"); 
		query.append("                      ,DECODE(LG.ISF_RSLT_CD, NULL, '', '01', LG.ISF_RMK, 'ISF Accepted') AS ISF_RMK" ).append("\n"); 
		query.append("                      ,TO_CHAR(LG.SND_DT, 'YYYY-MM-DD HH24:MI:SS') AS SND_DT" ).append("\n"); 
		query.append("                      ,TO_CHAR(LG.RCV_DT, 'YYYY-MM-DD HH24:MI:SS') AS RCV_DT" ).append("\n"); 
		query.append("                      ,BL.VSL_CD || BL.SKD_VOY_NO || BL.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY BL.BL_NO ORDER BY SND_DT DESC) RNUM" ).append("\n"); 
		query.append("                      ,DECODE(BL.MF_NO, NULL, DECODE(BKG.CUST_TO_ORD_FLG, 'Y', 'N', 'C'), 'C') AS BKG_CUST_TP_CD" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_ADV_BL BL" ).append("\n"); 
		query.append("                      ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("                      ,BKG_CSTMS_ADV_STWG_SND_LOG LG" ).append("\n"); 
		query.append("                      ,COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("                 WHERE BL.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                   AND BL.CNT_CD = 'US'" ).append("\n"); 
		query.append("                   AND BL.BL_NO = LG.BL_NO" ).append("\n"); 
		query.append("                   AND LG.SND_PROC_ID = 'ISF'" ).append("\n"); 
		query.append("                   AND LG.ISF_RSLT_CD = CD.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("                   AND CD.INTG_CD_ID(+) = 'CD02524'" ).append("\n"); 
		query.append("                    #if (${cust_arr_exp} == 'SND')" ).append("\n"); 
		query.append("                   		AND LG.STWG_SND_ID >= REPLACE(@[fromd] , '-', '')" ).append("\n"); 
		query.append("                   		AND LG.STWG_SND_ID <= REPLACE(@[tod] , '-', '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        AND LG.SND_DT" ).append("\n"); 
		query.append("                            BETWEEN TO_DATE(REPLACE(@[fromd], '-', '') || REPLACE(@[fromt], ':', '') ,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                            AND TO_DATE(REPLACE(@[tod], '-', '')   || REPLACE(@[tot], ':', '')   ,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                    #elseif (${cust_arr_exp} == 'RCV')" ).append("\n"); 
		query.append("                        AND LG.RCV_DT" ).append("\n"); 
		query.append("                            BETWEEN TO_DATE(REPLACE(@[fromd], '-', '') || REPLACE(@[fromt], ':', '') ,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                            AND TO_DATE(REPLACE(@[tod], '-', '')   || REPLACE(@[tot], ':', '')   ,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                    #if (${vvd} != '')" ).append("\n"); 
		query.append("                        AND BL.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                        AND BL.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                        AND BL.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${pol} != '')" ).append("\n"); 
		query.append("                        AND BL.CSTMS_POL_CD = @[pol]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${pod} != '')" ).append("\n"); 
		query.append("                        AND BL.CSTMS_POD_CD = @[pod]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("	                #if (${del} != '')" ).append("\n"); 
		query.append("    	                AND BL.DEL_CD = @[del]" ).append("\n"); 
		query.append("        	        #end" ).append("\n"); 
		query.append("                    #if (${hub} != '')" ).append("\n"); 
		query.append("                        AND BL.HUB_LOC_CD = @[hub]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${eq_ofc} != '')" ).append("\n"); 
		query.append("                        AND BKG.EQ_CTRL_OFC_CD = @[eq_ofc]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${b_stf} != '')" ).append("\n"); 
		query.append("                        AND BKG.DOC_USR_ID = @[b_stf]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${l_rep} != '')" ).append("\n"); 
		query.append("                        AND BKG.OB_SREP_CD = @[l_rep]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${rcv_term_cd} != '')" ).append("\n"); 
		query.append("                        AND BKG.RCV_TERM_CD = @[rcv_term_cd]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${de_term_cd} != '')" ).append("\n"); 
		query.append("                        AND BKG.DE_TERM_CD = @[de_term_cd]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("               )BL" ).append("\n"); 
		query.append("              ,BKG_CSTMS_ADV_CUST CU" ).append("\n"); 
		query.append("         WHERE BL.CNT_CD = CU.CNT_CD(+)" ).append("\n"); 
		query.append("           AND BL.AMS_FILE_NO = CU.BL_NO(+)" ).append("\n"); 
		query.append("           AND BL.BKG_CUST_TP_CD = CU.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        SELECT BKG.BKG_NO" ).append("\n"); 
		query.append("              ,BKG.MBL_NO" ).append("\n"); 
		query.append("              ,BKG.AMS_FILE_NO" ).append("\n"); 
		query.append("              ,BKG.FILER" ).append("\n"); 
		query.append("              ,BKG.MH" ).append("\n"); 
		query.append("              ,BKG.CSTMS_POL_CD AS POL_CD" ).append("\n"); 
		query.append("              ,BKG.CSTMS_POD_CD AS POD_CD" ).append("\n"); 
		query.append("              ,BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("              ,BKG.CUST_NM" ).append("\n"); 
		query.append("              ,DECODE(LG.ISF_ACT_CD, 'A','ADD','R','REPLACE','D','DELETE') AS ISF_ACT_CD" ).append("\n"); 
		query.append("              ,LG.ISF_RSLT_CD" ).append("\n"); 
		query.append("              ,CD.INTG_CD_VAL_DESC AS ISF_RSLT_DESC" ).append("\n"); 
		query.append("              ,DECODE(LG.ISF_RSLT_CD, NULL, '', '01', LG.ISF_RMK, 'ISF Accepted') AS ISF_RMK" ).append("\n"); 
		query.append("              ,TO_CHAR(LG.SND_DT, 'YYYY-MM-DD HH24:MI:SS') AS SND_DT" ).append("\n"); 
		query.append("              ,TO_CHAR(LG.RCV_DT, 'YYYY-MM-DD HH24:MI:SS') AS RCV_DT" ).append("\n"); 
		query.append("              ,ROW_NUMBER() OVER(PARTITION BY BKG.AMS_FILE_NO ORDER BY LG.SND_DT DESC) RNUM" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT BKG.BKG_NO" ).append("\n"); 
		query.append("                      ,BKG.BL_NO AS MBL_NO" ).append("\n"); 
		query.append("                      ,BKG.BL_NO AS AMS_FILE_NO" ).append("\n"); 
		query.append("                      ,BKG.USA_CSTMS_FILE_CD AS FILER" ).append("\n"); 
		query.append("                      ,'M' AS MH" ).append("\n"); 
		query.append("                      ,BKG.POL_CD" ).append("\n"); 
		query.append("                      ,BKG.POD_CD" ).append("\n"); 
		query.append("                      ,BKG.DEL_CD" ).append("\n"); 
		query.append("                      ,BKG.USA_CSTMS_FILE_CD" ).append("\n"); 
		query.append("                      ,BKG.BKG_STS_CD" ).append("\n"); 
		query.append("                      ,VVD.POL_CD AS CSTMS_POL_CD" ).append("\n"); 
		query.append("                      ,VVD.POD_CD AS CSTMS_POD_CD" ).append("\n"); 
		query.append("                      ,VVD.VSL_CD" ).append("\n"); 
		query.append("                      ,VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                      ,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                      ,REPLACE(REPLACE(REPLACE(C.CUST_NM, CHR(13)||CHR(10),' '), CHR(13), ' '), CHR(10), ' ') AS CUST_NM" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("                      ,BKG_VVD VVD" ).append("\n"); 
		query.append("                      ,BKG_CUSTOMER C" ).append("\n"); 
		query.append("                 WHERE BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                   AND BKG.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("                   AND C.BKG_CUST_TP_CD(+) = DECODE(BKG.CUST_TO_ORD_FLG, 'Y', 'N', 'C')" ).append("\n"); 
		query.append("                #if (${mbl_no} != '')" ).append("\n"); 
		query.append("                        AND BKG.BL_NO = @[mbl_no]" ).append("\n"); 
		query.append("                        AND VVD.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                        AND VVD.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                        AND VVD.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                    #if (${ams_file_no} != '')" ).append("\n"); 
		query.append("                        AND BKG.BL_NO = @[ams_file_no]" ).append("\n"); 
		query.append("                        AND VVD.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                        AND VVD.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                        AND VVD.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        #if (${vvd} != '')" ).append("\n"); 
		query.append("                            AND VVD.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                            AND VVD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                            AND VVD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${pol} != '')" ).append("\n"); 
		query.append("                            AND VVD.POL_CD = @[pol]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${pod} != '')" ).append("\n"); 
		query.append("                            AND VVD.POD_CD = @[pod]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT BKG.BKG_NO" ).append("\n"); 
		query.append("                      ,BKG.BL_NO AS MBL_NO" ).append("\n"); 
		query.append("                      ,HBL.CNTR_MF_NO AS AMS_FILE_NO" ).append("\n"); 
		query.append("                      ,'0' AS FILER" ).append("\n"); 
		query.append("                      ,'H' AS MH" ).append("\n"); 
		query.append("                      ,BKG.POL_CD" ).append("\n"); 
		query.append("                      ,BKG.POD_CD" ).append("\n"); 
		query.append("                      ,BKG.DEL_CD" ).append("\n"); 
		query.append("                      ,BKG.USA_CSTMS_FILE_CD" ).append("\n"); 
		query.append("                      ,BKG.BKG_STS_CD" ).append("\n"); 
		query.append("                      ,VVD.POL_CD AS CSTMS_POL_CD" ).append("\n"); 
		query.append("                      ,VVD.POD_CD AS CSTMS_POD_CD" ).append("\n"); 
		query.append("                      ,VVD.VSL_CD" ).append("\n"); 
		query.append("                      ,VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                      ,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                      ,REPLACE(REPLACE(REPLACE(C.CUST_NM, CHR(13)||CHR(10),' '), CHR(13), ' '), CHR(10), ' ') AS CUST_NM" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("                      ,BKG_VVD VVD" ).append("\n"); 
		query.append("                      ,BKG_HBL HBL" ).append("\n"); 
		query.append("                      ,BKG_HBL_CUST C" ).append("\n"); 
		query.append("                 WHERE BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                   AND BKG.BKG_NO = HBL.BKG_NO" ).append("\n"); 
		query.append("                   AND HBL.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("                   AND HBL.HBL_SEQ = C.HBL_SEQ(+)" ).append("\n"); 
		query.append("                   AND C.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("                   AND BKG.USA_CSTMS_FILE_CD = '1'" ).append("\n"); 
		query.append("                #if (${mbl_no} != '')" ).append("\n"); 
		query.append("                        AND BKG.BL_NO = @[mbl_no]" ).append("\n"); 
		query.append("                        AND VVD.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                        AND VVD.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                        AND VVD.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                    #if (${ams_file_no} != '')" ).append("\n"); 
		query.append("                        AND HBL.CNTR_MF_NO = @[ams_file_no]" ).append("\n"); 
		query.append("                        AND VVD.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                        AND VVD.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                        AND VVD.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        #if (${vvd} != '')" ).append("\n"); 
		query.append("                            AND VVD.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                            AND VVD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                            AND VVD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${pol} != '')" ).append("\n"); 
		query.append("                            AND VVD.POL_CD = @[pol]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${pod} != '')" ).append("\n"); 
		query.append("                            AND VVD.POD_CD = @[pod]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("               )BKG" ).append("\n"); 
		query.append("              ,BKG_CSTMS_ADV_STWG_SND_LOG LG" ).append("\n"); 
		query.append("              ,COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("              ,VSK_VSL_PORT_SKD VSL" ).append("\n"); 
		query.append("         WHERE BKG.AMS_FILE_NO = LG.BL_NO(+)" ).append("\n"); 
		query.append("           AND LG.SND_PROC_ID(+) = 'ISF'" ).append("\n"); 
		query.append("           AND LG.ISF_RSLT_CD = CD.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("           AND CD.INTG_CD_ID(+) = 'CD02524'" ).append("\n"); 
		query.append("           AND BKG.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("           AND BKG.SKD_VOY_NO = VSL.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND BKG.SKD_DIR_CD = VSL.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND BKG.CSTMS_POD_CD = VSL.VPS_PORT_CD" ).append("\n"); 
		query.append("           AND VSL.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("           AND VSL.CLPT_SEQ >= @[clpt_seq]" ).append("\n"); 
		query.append("           AND BKG.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("           AND BKG.MBL_NO IS NOT NULL" ).append("\n"); 
		query.append("           AND BKG.AMS_FILE_NO IS NOT NULL" ).append("\n"); 
		query.append("           AND (" ).append("\n"); 
		query.append("               (BKG.POD_CD LIKE 'US%' AND BKG.DEL_CD NOT LIKE 'US%')" ).append("\n"); 
		query.append("               OR" ).append("\n"); 
		query.append("               (BKG.POD_CD NOT LIKE 'US%' AND VSL.CLPT_SEQ > @[clpt_seq])" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("           AND DECODE(BKG.MH, 'M', BKG.USA_CSTMS_FILE_CD, 'HBL') NOT IN ('1')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ) TB" ).append("\n"); 
		query.append(" WHERE TB.RNUM = 1" ).append("\n"); 

	}
}
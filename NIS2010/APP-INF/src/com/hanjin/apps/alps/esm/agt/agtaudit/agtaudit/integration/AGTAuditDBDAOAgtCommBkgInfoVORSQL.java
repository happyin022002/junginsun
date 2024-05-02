/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDBDAOAgtCommBkgInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.12
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2010.07.12 추경원
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyung-won Chu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOAgtCommBkgInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public AGTAuditDBDAOAgtCommBkgInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
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
		params.put("s_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_apro_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
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
		params.put("s_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOAgtCommBkgInfoVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("LIS.PAGEROWSTOT," ).append("\n"); 
		query.append("LIS.BL_NO," ).append("\n"); 
		query.append("LIS.BKG_NO," ).append("\n"); 
		query.append("LIS.IO_BND_CD," ).append("\n"); 
		query.append("LIS.COMM_VVD," ).append("\n"); 
		query.append("LIS.SAIL_ARR_DT," ).append("\n"); 
		query.append("LIS.POR_CD," ).append("\n"); 
		query.append("LIS.POL_CD," ).append("\n"); 
		query.append("LIS.POD_CD," ).append("\n"); 
		query.append("LIS.DEL_CD," ).append("\n"); 
		query.append("LIS.TEU_FEU," ).append("\n"); 
		query.append("LIS.FAC_AMT," ).append("\n"); 
		query.append("LIS.COM_I," ).append("\n"); 
		query.append("LIS.COM_II," ).append("\n"); 
		query.append("LIS.BROKERAGE_AMT," ).append("\n"); 
		query.append("LIS.CHF_AMT," ).append("\n"); 
		query.append("LIS.TS_AMT," ).append("\n"); 
		query.append("LIS.TR_AMT," ).append("\n"); 
		query.append("LIS.SOC_AMT," ).append("\n"); 
		query.append("LIS.CROSS_AMT," ).append("\n"); 
		query.append("LIS.DOC_AMT," ).append("\n"); 
		query.append("LIS.DDCT_AMT," ).append("\n"); 
		query.append("LIS.USD_AMT," ).append("\n"); 
		query.append("LIS.CURR_CD," ).append("\n"); 
		query.append("LIS.CALC_DT," ).append("\n"); 
		query.append("LIS.RQST_DT," ).append("\n"); 
		query.append("LIS.APRO_DT," ).append("\n"); 
		query.append("LIS.IF_DT," ).append("\n"); 
		query.append("LIS.PPD_FRT_AMT," ).append("\n"); 
		query.append("LIS.CLT_FRT_AMT," ).append("\n"); 
		query.append("LIS.PPD_OTR_AMT," ).append("\n"); 
		query.append("LIS.CLT_OTR_AMT," ).append("\n"); 
		query.append("LIS.NET_AMT," ).append("\n"); 
		query.append("LIS.GROSS_AMT," ).append("\n"); 
		query.append("LIS.PYMT_AMT," ).append("\n"); 
		query.append("LIS.FF_CD," ).append("\n"); 
		query.append("LIS.FF_NAME," ).append("\n"); 
		query.append("LIS.FF_ADDR," ).append("\n"); 
		query.append("LIS.BRO_ADDR1," ).append("\n"); 
		query.append("LIS.BRO_ADDR2," ).append("\n"); 
		query.append("LIS.BRO_ADDR3," ).append("\n"); 
		query.append("LIS.BRO_ADDR4," ).append("\n"); 
		query.append("LIS.BRO_ADDR5," ).append("\n"); 
		query.append("LIS.BRO_ADDR6," ).append("\n"); 
		query.append("LIS.PAN_CODE," ).append("\n"); 
		query.append("LIS.TRD_CD," ).append("\n"); 
		query.append("LIS.RLANE_CD," ).append("\n"); 
		query.append("LIS.DIR_CD," ).append("\n"); 
		query.append("LIS.TEU," ).append("\n"); 
		query.append("LIS.FEU," ).append("\n"); 
		query.append("LIS.COMM_APRO_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT /*+ PARALLEL(AGN, 16) */" ).append("\n"); 
		query.append("#if(${col_nm}!='')" ).append("\n"); 
		query.append("DENSE_RANK () OVER (order BY ${col_nm}) AS RANK," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("DENSE_RANK () OVER (order BY 1)         AS RANK," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("COUNT (1) OVER()                        AS PAGEROWSTOT," ).append("\n"); 
		query.append("MAX (INF.BL_NO)                           AS BL_NO," ).append("\n"); 
		query.append("MAX (AGN.BKG_NO)                          AS BKG_NO," ).append("\n"); 
		query.append("MAX (AGN.IO_BND_CD)                       AS IO_BND_CD," ).append("\n"); 
		query.append("MAX (CONCAT (CONCAT (AGN.COMM_VSL_CD, AGN.COMM_SKD_VOY_NO), AGN.COMM_SKD_DIR_CD)) AS COMM_VVD," ).append("\n"); 
		query.append("MAX (TO_CHAR (TO_DATE (SAIL_ARR_DT, 'YYYYMMDD'), 'YYYY-MM-DD'))             AS SAIL_ARR_DT," ).append("\n"); 
		query.append("MAX (INF.BKG_POR_CD)                          AS POR_CD," ).append("\n"); 
		query.append("MAX (INF.BKG_POL_CD)                          AS POL_CD," ).append("\n"); 
		query.append("MAX (INF.BKG_POD_CD)                          AS POD_CD," ).append("\n"); 
		query.append("MAX (INF.BKG_DEL_CD)                          AS DEL_CD," ).append("\n"); 
		query.append("NVL" ).append("\n"); 
		query.append("( MAX" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SUM (DECODE (SUBSTR (CNTR_TPSZ_CD, 2, 1), '2', OP_CNTR_QTY, 0))" ).append("\n"); 
		query.append("FROM BKG_QUANTITY" ).append("\n"); 
		query.append("WHERE BKG_NO = AGN.BKG_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", 0" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("|| '/'" ).append("\n"); 
		query.append("|| NVL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("MAX" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SUM (DECODE (SUBSTR (CNTR_TPSZ_CD, 2, 1), '2', 0, OP_CNTR_QTY))" ).append("\n"); 
		query.append("FROM BKG_QUANTITY" ).append("\n"); 
		query.append("WHERE BKG_NO = AGN.BKG_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", 0" ).append("\n"); 
		query.append(") AS TEU_FEU," ).append("\n"); 
		query.append("TO_CHAR" ).append("\n"); 
		query.append("( NVL" ).append("\n"); 
		query.append("( SUM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ACT_COMM_AMT" ).append("\n"); 
		query.append("FROM AGT_FAC_COMM" ).append("\n"); 
		query.append("WHERE BKG_NO = AGN.BKG_NO" ).append("\n"); 
		query.append("AND FAC_SEQ =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT /*+INDEX_DESC(X XPKAGT_FAC_COMM) */" ).append("\n"); 
		query.append("X.FAC_SEQ" ).append("\n"); 
		query.append("FROM AGT_FAC_COMM X" ).append("\n"); 
		query.append("WHERE ROWNUM < 2" ).append("\n"); 
		query.append("AND X.BKG_NO = AGN.BKG_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", 0" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", '999,999,999,999,990.99'" ).append("\n"); 
		query.append(") AS FAC_AMT," ).append("\n"); 
		query.append("TO_CHAR (NVL (SUM (DECODE (AGN.AC_TP_CD, 'G', AGN.ACT_IF_COMM_AMT, 0 )), 0), '999,999,999,999,990.99') AS COM_I," ).append("\n"); 
		query.append("TO_CHAR (NVL (SUM (DECODE (AGN.AC_TP_CD, 'N', AGN.ACT_IF_COMM_AMT, 0 )), 0), '999,999,999,999,990.99') AS COM_II," ).append("\n"); 
		query.append("TO_CHAR (NVL (SUM (DECODE (AGN.AC_TP_CD, 'K', AGN.ACT_IF_COMM_AMT, 0 )), 0), '999,999,999,999,990.99') AS BROKERAGE_AMT," ).append("\n"); 
		query.append("TO_CHAR (NVL (SUM (DECODE (AGN.AC_TP_CD, 'H', AGN.ACT_IF_COMM_AMT, 0 )), 0), '999,999,999,999,990.99') AS CHF_AMT," ).append("\n"); 
		query.append("TO_CHAR (NVL (SUM (DECODE (AGN.AC_TP_CD, 'S', AGN.ACT_IF_COMM_AMT, 0 )), 0), '999,999,999,999,990.99') AS TS_AMT," ).append("\n"); 
		query.append("TO_CHAR (NVL (SUM (DECODE (AGN.AC_TP_CD, 'R', AGN.ACT_IF_COMM_AMT, 0 )), 0), '999,999,999,999,990.99') AS TR_AMT," ).append("\n"); 
		query.append("TO_CHAR (NVL (SUM (DECODE (AGN.AC_TP_CD, 'O', AGN.ACT_IF_COMM_AMT, 0 )), 0), '999,999,999,999,990.99') AS SOC_AMT," ).append("\n"); 
		query.append("TO_CHAR (NVL (SUM (DECODE (AGN.AC_TP_CD, 'C', AGN.ACT_IF_COMM_AMT, 0 )), 0), '999,999,999,999,990.99') AS CROSS_AMT," ).append("\n"); 
		query.append("TO_CHAR (NVL (SUM (DECODE (AGN.AC_TP_CD, 'D', AGN.ACT_IF_COMM_AMT, 0 )), 0), '999,999,999,999,990.99') AS DOC_AMT," ).append("\n"); 
		query.append("TO_CHAR (NVL (MAX (AGN.CHG_DDCT_AMT + AGN.FDRG_DDCT_AMT + AGN.HLG_DDCT_AMT), 0), '999,999,999,999,990.99') AS DDCT_AMT," ).append("\n"); 
		query.append("TO_CHAR (NVL (SUM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("DECODE (AGN.AC_TP_CD, 'G', AGN.ACT_IF_COMM_AMT, 0)" ).append("\n"); 
		query.append("+ DECODE (AGN.AC_TP_CD, 'N', AGN.ACT_IF_COMM_AMT, 0)" ).append("\n"); 
		query.append("+ DECODE (AGN.AC_TP_CD, 'K', AGN.ACT_IF_COMM_AMT, 0)" ).append("\n"); 
		query.append("+ DECODE (AGN.AC_TP_CD, 'H', AGN.ACT_IF_COMM_AMT, 0)" ).append("\n"); 
		query.append("+ DECODE (AGN.AC_TP_CD, 'S', AGN.ACT_IF_COMM_AMT, 0)" ).append("\n"); 
		query.append("+ DECODE (AGN.AC_TP_CD, 'R', AGN.ACT_IF_COMM_AMT, 0)" ).append("\n"); 
		query.append("+ DECODE (AGN.AC_TP_CD, 'O', AGN.ACT_IF_COMM_AMT, 0)" ).append("\n"); 
		query.append("+ DECODE (AGN.AC_TP_CD, 'T', AGN.ACT_IF_COMM_AMT, 0)" ).append("\n"); 
		query.append("+ DECODE (AGN.AC_TP_CD, 'C', AGN.ACT_IF_COMM_AMT, 0)" ).append("\n"); 
		query.append("+ DECODE (AGN.AC_TP_CD, 'D', AGN.ACT_IF_COMM_AMT, 0)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", 0), '999,999,999,999,990.99')                               AS USD_AMT," ).append("\n"); 
		query.append("MAX (AGN.CURR_CD)                                             AS CURR_CD," ).append("\n"); 
		query.append("MAX (TO_CHAR (AGN.CRE_DT, 'YYYY-MM-DD'))                      AS CALC_DT," ).append("\n"); 
		query.append("MAX (TO_CHAR (AGN.AC_RQST_DT, 'YYYY-MM-DD'))                  AS RQST_DT," ).append("\n"); 
		query.append("MAX (TO_CHAR (AGN.AC_APRO_DT, 'YYYY-MM-DD'))                  AS APRO_DT," ).append("\n"); 
		query.append("MAX (TO_CHAR (AGN.AC_IF_DT, 'YYYY-MM-DD'))                    AS IF_DT," ).append("\n"); 
		query.append("TO_CHAR (MAX (INF.BKG_PPD_FRT_AMT), '999,999,999,999,990.99') AS PPD_FRT_AMT," ).append("\n"); 
		query.append("TO_CHAR (MAX (INF.BKG_CLT_FRT_AMT), '999,999,999,999,990.99') AS CLT_FRT_AMT," ).append("\n"); 
		query.append("TO_CHAR (MAX (INF.BKG_PPD_OTR_AMT), '999,999,999,999,990.99') AS PPD_OTR_AMT," ).append("\n"); 
		query.append("TO_CHAR (MAX (INF.BKG_CLT_OTR_AMT), '999,999,999,999,990.99') AS CLT_OTR_AMT," ).append("\n"); 
		query.append("TO_CHAR (MAX ( INF.BKG_PPD_FRT_AMT + INF.BKG_CLT_FRT_AMT), '999,999,999,999,990.99') AS NET_AMT," ).append("\n"); 
		query.append("TO_CHAR (MAX ( INF.BKG_PPD_FRT_AMT + INF.BKG_PPD_OTR_AMT + INF.BKG_CLT_FRT_AMT + INF.BKG_CLT_OTR_AMT), '999,999,999,999,990.99') AS GROSS_AMT," ).append("\n"); 
		query.append("TO_CHAR" ).append("\n"); 
		query.append("( NVL" ).append("\n"); 
		query.append("( SUM" ).append("\n"); 
		query.append("( DECODE (AGN.AC_TP_CD, 'G', AGN.ACT_IF_LOCL_COMM_AMT, 0)" ).append("\n"); 
		query.append("+ DECODE (AGN.AC_TP_CD, 'N', AGN.ACT_IF_LOCL_COMM_AMT, 0)" ).append("\n"); 
		query.append("+ DECODE (AGN.AC_TP_CD, 'K', AGN.ACT_IF_LOCL_COMM_AMT, 0)" ).append("\n"); 
		query.append("+ DECODE (AGN.AC_TP_CD, 'H', AGN.ACT_IF_LOCL_COMM_AMT, 0)" ).append("\n"); 
		query.append("+ DECODE (AGN.AC_TP_CD, 'S', AGN.ACT_IF_LOCL_COMM_AMT, 0)" ).append("\n"); 
		query.append("+ DECODE (AGN.AC_TP_CD, 'R', AGN.ACT_IF_LOCL_COMM_AMT, 0)" ).append("\n"); 
		query.append("+ DECODE (AGN.AC_TP_CD, 'O', AGN.ACT_IF_LOCL_COMM_AMT, 0)" ).append("\n"); 
		query.append("+ DECODE (AGN.AC_TP_CD, 'T', AGN.ACT_IF_LOCL_COMM_AMT, 0)" ).append("\n"); 
		query.append("+ DECODE (AGN.AC_TP_CD, 'C', AGN.ACT_IF_LOCL_COMM_AMT, 0)" ).append("\n"); 
		query.append("+ DECODE (AGN.AC_TP_CD, 'D', AGN.ACT_IF_LOCL_COMM_AMT, 0)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", 0" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", '999,999,999,999,990.99'" ).append("\n"); 
		query.append(")                                            AS PYMT_AMT," ).append("\n"); 
		query.append("MAX (INF.FRT_FWRD_CNT_CD)" ).append("\n"); 
		query.append("|| TO_CHAR (MAX (INF.FRT_FWRD_SEQ), 'FM000000') AS FF_CD," ).append("\n"); 
		query.append("MAX" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("CASE 'BOMBB'" ).append("\n"); 
		query.append("WHEN AGN.AR_OFC_CD" ).append("\n"); 
		query.append("THEN NVL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("E.CUST_NM" ).append("\n"); 
		query.append("FROM BKG_CUSTOMER E" ).append("\n"); 
		query.append("WHERE INF.BKG_NO             = E.BKG_NO" ).append("\n"); 
		query.append("AND E.BKG_CUST_TP_CD     = 'B'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("E.CUST_NM" ).append("\n"); 
		query.append("FROM BKG_CUSTOMER E" ).append("\n"); 
		query.append("WHERE INF.BKG_NO             = E.BKG_NO" ).append("\n"); 
		query.append("AND E.BKG_CUST_TP_CD     = 'F'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("NVL(D.CUST_LOCL_LANG_NM, D.CUST_LGL_ENG_NM)" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER      D," ).append("\n"); 
		query.append("BKG_CUSTOMER      E" ).append("\n"); 
		query.append("WHERE INF.FRT_FWRD_CNT_CD    = D.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND INF.FRT_FWRD_SEQ       = D.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND INF.BKG_NO             = E.BKG_NO(+)" ).append("\n"); 
		query.append("AND INF.FRT_FWRD_CNT_CD    = NVL (E.CUST_CNT_CD(+),'*')" ).append("\n"); 
		query.append("AND INF.FRT_FWRD_SEQ       = E.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND E.BKG_CUST_TP_CD(+)  = 'F'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(") AS FF_NAME," ).append("\n"); 
		query.append("MAX" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("E.CUST_ADDR" ).append("\n"); 
		query.append("FROM BKG_CUSTOMER      E" ).append("\n"); 
		query.append("WHERE INF.BKG_NO             = E.BKG_NO" ).append("\n"); 
		query.append("AND INF.FRT_FWRD_CNT_CD    = NVL(E.CUST_CNT_CD,'*')" ).append("\n"); 
		query.append("AND INF.FRT_FWRD_SEQ       = E.CUST_SEQ" ).append("\n"); 
		query.append("AND E.BKG_CUST_TP_CD     = 'F'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") AS FF_ADDR," ).append("\n"); 
		query.append("MAX" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC (CUST_ADDR, 1)" ).append("\n"); 
		query.append("FROM   BKG_CUSTOMER" ).append("\n"); 
		query.append("WHERE  BKG_NO = AGN.BKG_NO" ).append("\n"); 
		query.append("AND    BKG_CUST_TP_CD = 'B'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") AS BRO_ADDR1," ).append("\n"); 
		query.append("MAX" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(CUST_ADDR, 2)" ).append("\n"); 
		query.append("FROM BKG_CUSTOMER" ).append("\n"); 
		query.append("WHERE BKG_NO = AGN.BKG_NO" ).append("\n"); 
		query.append("AND BKG_CUST_TP_CD = 'B'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") AS BRO_ADDR2," ).append("\n"); 
		query.append("MAX" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(CUST_ADDR, 3)" ).append("\n"); 
		query.append("FROM BKG_CUSTOMER" ).append("\n"); 
		query.append("WHERE BKG_NO = AGN.BKG_NO" ).append("\n"); 
		query.append("AND BKG_CUST_TP_CD = 'B'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") AS BRO_ADDR3," ).append("\n"); 
		query.append("MAX" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(CUST_ADDR, 4)" ).append("\n"); 
		query.append("FROM   BKG_CUSTOMER" ).append("\n"); 
		query.append("WHERE  BKG_NO = AGN.BKG_NO" ).append("\n"); 
		query.append("AND    BKG_CUST_TP_CD = 'B')) AS BRO_ADDR4," ).append("\n"); 
		query.append("MAX" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(CUST_ADDR, 5)" ).append("\n"); 
		query.append("FROM   BKG_CUSTOMER" ).append("\n"); 
		query.append("WHERE  BKG_NO = AGN.BKG_NO" ).append("\n"); 
		query.append("AND    BKG_CUST_TP_CD = 'B')) AS BRO_ADDR5," ).append("\n"); 
		query.append("MAX" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(CUST_ADDR, 6)" ).append("\n"); 
		query.append("FROM   BKG_CUSTOMER" ).append("\n"); 
		query.append("WHERE  BKG_NO = AGN.BKG_NO" ).append("\n"); 
		query.append("AND    BKG_CUST_TP_CD = 'B')) AS BRO_ADDR6," ).append("\n"); 
		query.append("MAX((" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("BRF.CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("FROM BKG_REFERENCE     BRF" ).append("\n"); 
		query.append("WHERE BRF.BKG_REF_TP_CD = 'BRKN'" ).append("\n"); 
		query.append("AND BRF.BKG_NO        = AGN.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("))                          AS PAN_CODE," ).append("\n"); 
		query.append("MAX (INF.TRD_CD)           AS TRD_CD," ).append("\n"); 
		query.append("MAX (INF.RLANE_CD)         AS RLANE_CD," ).append("\n"); 
		query.append("MAX (AGN.COMM_SKD_DIR_CD)  AS DIR_CD," ).append("\n"); 
		query.append("NVL" ).append("\n"); 
		query.append("( MAX" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SUM (DECODE (SUBSTR (CNTR_TPSZ_CD, 2, 1), '2', OP_CNTR_QTY, 0))" ).append("\n"); 
		query.append("FROM BKG_QUANTITY" ).append("\n"); 
		query.append("WHERE BKG_NO = AGN.BKG_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", 0" ).append("\n"); 
		query.append(") AS TEU," ).append("\n"); 
		query.append("NVL" ).append("\n"); 
		query.append("( MAX" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SUM (DECODE (SUBSTR (CNTR_TPSZ_CD, 2, 1), '2', 0, OP_CNTR_QTY))" ).append("\n"); 
		query.append("FROM BKG_QUANTITY" ).append("\n"); 
		query.append("WHERE BKG_NO = AGN.BKG_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", 0" ).append("\n"); 
		query.append(") AS FEU," ).append("\n"); 
		query.append("MAX (AGN.COMM_APRO_NO) AS COMM_APRO_NO" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM      AGN," ).append("\n"); 
		query.append("AGT_COMM_BKG_INFO INF" ).append("\n"); 
		query.append("WHERE AGN.CRE_USR_ID        != 'COST'" ).append("\n"); 
		query.append("AND AGN.BKG_NO             = AGN.BKG_NO" ).append("\n"); 
		query.append("AND AGN.BKG_NO             = INF.BKG_NO" ).append("\n"); 
		query.append("AND AGN.AC_SEQ             = AGN.AC_SEQ" ).append("\n"); 
		query.append("#if (${agn_cd} != '')" ).append("\n"); 
		query.append("AND AGN.AGN_CD             = @[agn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ar_ofc_cd} != '')" ).append("\n"); 
		query.append("AND AGN.AR_OFC_CD          = @[ar_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_trd_cd} != '')" ).append("\n"); 
		query.append("AND INF.TRD_CD             = @[s_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_rlane_cd} != '')" ).append("\n"); 
		query.append("AND INF.RLANE_CD           = @[s_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_dir_cd} != '')" ).append("\n"); 
		query.append("AND AGN.COMM_SKD_DIR_CD    = @[s_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND AGN.AC_TP_CD" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("'G', 'N', 'K', 'H', 'S', 'R', 'O', 'T', 'C', 'D'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND AGN.IO_BND_CD" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("CASE @[io_bnd_cd]" ).append("\n"); 
		query.append("WHEN 'O'" ).append("\n"); 
		query.append("THEN 'O'" ).append("\n"); 
		query.append("WHEN 'I'" ).append("\n"); 
		query.append("THEN 'I'" ).append("\n"); 
		query.append("ELSE AGN.IO_BND_CD" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${comm_vvd} != '')" ).append("\n"); 
		query.append("AND CONCAT (CONCAT (AGN.COMM_VSL_CD, AGN.COMM_SKD_VOY_NO), AGN.COMM_SKD_DIR_CD) = @[comm_vvd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("AND INF.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ob_sls_ofc_cd} != '')" ).append("\n"); 
		query.append("AND INF.SLS_OFC_CD = @[ob_sls_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd} != '')" ).append("\n"); 
		query.append("AND INF.BKG_POR_CD = @[por_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("AND INF.BKG_POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("AND INF.BKG_POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("AND INF.BKG_DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("AND INF.BL_NO IN ( ${bl_no} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${comm_apro_no} != '')" ).append("\n"); 
		query.append("AND AGN.COMM_APRO_NO LIKE '%'||@[comm_apro_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_no} != '')" ).append("\n"); 
		query.append("AND AGN.INV_NO       LIKE '%'||@[inv_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sts_option} == 'C')" ).append("\n"); 
		query.append("AND AGN.COMM_PROC_STS_CD" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("'CS', 'CE', 'IC', 'CA'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND AGN.CRE_DT" ).append("\n"); 
		query.append("BETWEEN TO_DATE (REPLACE(@[search_dt_fr],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("AND TO_DATE (REPLACE(@[search_dt_to],'-',''), 'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("#elseif (${sts_option} == 'R')" ).append("\n"); 
		query.append("AND AGN.COMM_PROC_STS_CD IN ( 'RS','RM' )" ).append("\n"); 
		query.append("AND AGN.AC_RQST_DT" ).append("\n"); 
		query.append("BETWEEN TO_DATE (REPLACE(@[search_dt_fr],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("AND TO_DATE (REPLACE(@[search_dt_to],'-',''), 'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("#elseif (${sts_option} == 'A')" ).append("\n"); 
		query.append("AND AGN.COMM_PROC_STS_CD IN ( 'AS' )" ).append("\n"); 
		query.append("AND AGN.AC_APRO_DT" ).append("\n"); 
		query.append("BETWEEN TO_DATE (REPLACE(@[search_dt_fr],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("AND TO_DATE (REPLACE(@[search_dt_to],'-',''), 'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("#elseif (${sts_option} == 'I')" ).append("\n"); 
		query.append("AND AGN.COMM_PROC_STS_CD IN ( 'IF' )" ).append("\n"); 
		query.append("AND AGN.AC_IF_DT" ).append("\n"); 
		query.append("BETWEEN TO_DATE (REPLACE(@[search_dt_fr],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("AND TO_DATE (REPLACE(@[search_dt_to],'-',''), 'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${col_nm} != '')" ).append("\n"); 
		query.append("GROUP BY ${col_nm}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") LIS" ).append("\n"); 
		query.append("WHERE LIS.RANK" ).append("\n"); 
		query.append("BETWEEN (NVL (@[pagerows], 1) - 1) * ${pagerowsper} + 1" ).append("\n"); 
		query.append("AND (NVL (@[pagerows], 1) - 1) * ${pagerowsper} + ${pagerowsper}" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchFullCntrRlseOrderListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchFullCntrRlseOrderListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchFullCntrRlseOrderList
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchFullCntrRlseOrderListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_option",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sent_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_del",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_do_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchFullCntrRlseOrderListRSQL").append("\n"); 
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
		query.append("SELECT  BL_NO                               " ).append("\n"); 
		query.append("       ,BKG_NO   " ).append("\n"); 
		query.append("       ,BKG_CGO_TP_CD                           " ).append("\n"); 
		query.append("       ,VVD " ).append("\n"); 
		query.append("       ,POL_CD" ).append("\n"); 
		query.append("       ,POD_CD " ).append("\n"); 
		query.append("       ,CNTR_NO " ).append("\n"); 
		query.append("       ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,DE_TERM_CD " ).append("\n"); 
		query.append("       ,YD_CD       -- 'Y' 이면 Uncheck       " ).append("\n"); 
		query.append("       ,SVR_ID" ).append("\n"); 
		query.append("       ,ERR       -- 'Y' 이면 Uncheck    " ).append("\n"); 
		query.append("       ,CUST_NM" ).append("\n"); 
		query.append("       ,SENT_FLG  -- Sent " ).append("\n"); 
		query.append("       ,FAX_NO         " ).append("\n"); 
		query.append("       ,YD_NM         " ).append("\n"); 
		query.append("       ,YD_EML         " ).append("\n"); 
		query.append("       ,PHN_NO         " ).append("\n"); 
		query.append("       ,VSL_NM         " ).append("\n"); 
		query.append("       ,LOC_NM        " ).append("\n"); 
		query.append("       ,DO_NO_YN         " ).append("\n"); 
		query.append("       ,CXL_FLG         " ).append("\n"); 
		query.append("       ,DO_NO         " ).append("\n"); 
		query.append("       ,DIFF_RMK         " ).append("\n"); 
		query.append("       ,DO_ISS_DT" ).append("\n"); 
		query.append("       ,CASE WHEN SUBSTR(POD_CD,1,2) = 'BE' OR SUBSTR(POD_CD,1,2) = 'NL'OR SUBSTR(POD_CD,1,2) = 'DE' THEN LTRIM(TO_CHAR(nisadm.BKG_PIN_NB_SEQ.nextval,'0009')) " ).append("\n"); 
		query.append("             ELSE NULL END AS PIN_NO" ).append("\n"); 
		query.append("       ,MSG_ACPT_REF_NO" ).append("\n"); 
		query.append("       ,DEL_CD " ).append("\n"); 
		query.append("       ,CUST AS FRT_FWRD_CD" ).append("\n"); 
		query.append("       ,CUST AS PTY_TO_INV_CD" ).append("\n"); 
		query.append("       ,CNTR_RTN_YD_CD AS MT_RET_CY_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	SELECT MST.BL_NO                               " ).append("\n"); 
		query.append("	       ,MST.BKG_NO   " ).append("\n"); 
		query.append("	       ,MST.BKG_CGO_TP_CD                           " ).append("\n"); 
		query.append("	       ,MST.VVD " ).append("\n"); 
		query.append("	       ,MST.POL_CD" ).append("\n"); 
		query.append("	       ,MST.POD_CD " ).append("\n"); 
		query.append("	       ,MST.DEL_CD " ).append("\n"); 
		query.append("	       ,MST.CNTR_NO " ).append("\n"); 
		query.append("	       ,MST.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	       ,MST.DE_TERM_CD " ).append("\n"); 
		query.append("	       ,DECODE(MST.SVR_ID,MST.USR_SVR_ID,MST.CRNT_YD_CD,'')  AS YD_CD       -- 'Y' 이면 Uncheck       " ).append("\n"); 
		query.append("	       ,MST.SVR_ID" ).append("\n"); 
		query.append("	       ,DECODE(MST.SVR_ID,MST.USR_SVR_ID,'0','1')                            AS ERR       -- 'Y' 이면 Uncheck    " ).append("\n"); 
		query.append("	       ,REPLACE(NVL(FORD.CUST_NM, MST.CUST_NM), CHR(13)||CHR(10), ' ')       AS CUST_NM" ).append("\n"); 
		query.append("	       ,DECODE( NVL(FORD.CGOR_MZD_CD,'N') ,'E','Y'" ).append("\n"); 
		query.append("	                                          ,'F','Y'" ).append("\n"); 
		query.append("	                                          ,'M','Y'" ).append("\n"); 
		query.append("	                                          ,'N')                              AS SENT_FLG  -- Sent " ).append("\n"); 
		query.append("	       ,MST.FAX_NO         " ).append("\n"); 
		query.append("	       ,MST.YD_NM         " ).append("\n"); 
		query.append("	       ,MST.YD_EML         " ).append("\n"); 
		query.append("	       ,MST.PHN_NO         " ).append("\n"); 
		query.append("	       ,MST.VSL_NM         " ).append("\n"); 
		query.append("	       ,MST.LOC_NM        " ).append("\n"); 
		query.append("	       ,MST.DO_NO_YN         " ).append("\n"); 
		query.append("	       ,MST.CXL_FLG         " ).append("\n"); 
		query.append("	       ,MST.DO_NO         " ).append("\n"); 
		query.append("	       ,MST.DIFF_RMK         " ).append("\n"); 
		query.append("	       ,MST.DO_ISS_DT	       " ).append("\n"); 
		query.append("	       ," ).append("\n"); 
		query.append("	        ( " ).append("\n"); 
		query.append("    	      SELECT RSV.MSG_ACPT_REF_NO " ).append("\n"); 
		query.append(" 				FROM BKG_CSTMS_EUR_DG_RCV RSV" ).append("\n"); 
		query.append(" 			  WHERE RSV.EUR_EDI_MSG_TP_ID='CTA'" ).append("\n"); 
		query.append("              AND   RSV.BL_NO LIKE SUBSTR(MST.BL_NO,1,10)||'%' " ).append("\n"); 
		query.append("              AND   RSV.CNTR_NO = MST.CNTR_NO " ).append("\n"); 
		query.append("              AND   RSV.MSG_ACPT_REF_NO IS NOT NULL" ).append("\n"); 
		query.append(" 			  AND   ROWNUM = 1" ).append("\n"); 
		query.append("            ) AS MSG_ACPT_REF_NO" ).append("\n"); 
		query.append("			,MST.CNTR_RTN_YD_CD" ).append("\n"); 
		query.append("            ,MST.CUST" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("	     SELECT BKG.BL_NO                                          AS BL_NO" ).append("\n"); 
		query.append("	         , BKG.BKG_NO                                          AS BKG_NO" ).append("\n"); 
		query.append("	         , BKG.BKG_CGO_TP_CD                                   AS BKG_CGO_TP_CD" ).append("\n"); 
		query.append("	         , BVVD.VSL_CD||BVVD.SKD_VOY_NO||BVVD.SKD_DIR_CD       AS VVD" ).append("\n"); 
		query.append("	         , BKG.POL_CD                                          AS POL_CD" ).append("\n"); 
		query.append("	         , BVVD.POD_CD                                         AS POD_CD" ).append("\n"); 
		query.append("	         , BKG.DEL_CD                                         AS DEL_CD" ).append("\n"); 
		query.append("	         , BCNTR.CNTR_NO                                       AS CNTR_NO" ).append("\n"); 
		query.append("	         , BCNTR.CNTR_TPSZ_CD                                  AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	         , BKG.DE_TERM_CD                                      AS DE_TERM_CD" ).append("\n"); 
		query.append("	         , CNTR.CRNT_YD_CD                                     AS CRNT_YD_CD   -- 화면상에 YD_CD" ).append("\n"); 
		query.append("	         , CNTR.SYS_AREA_GRP_ID                                AS SVR_ID" ).append("\n"); 
		query.append("	         , BCUST.CUST_NM                                       AS CUST_NM" ).append("\n"); 
		query.append("	         , (SELECT /*+ INDEX_DESC (ORD XPKBKG_FULL_CGO_RLSE_ORD) */ ORD.RLSE_ORD_SEQ " ).append("\n"); 
		query.append("	            FROM BKG_FULL_CGO_RLSE_ORD ORD " ).append("\n"); 
		query.append("	            WHERE ORD.BKG_NO = BCNTR.BKG_NO " ).append("\n"); 
		query.append("	            AND   ORD.CNTR_NO = BCNTR.CNTR_NO" ).append("\n"); 
		query.append("	            AND   ROWNUM = 1)                                  AS MAX_RLSE_SEQ  " ).append("\n"); 
		query.append("	         , YD.FAX_NO                                           AS FAX_NO" ).append("\n"); 
		query.append("	         , YD.YD_NM                                            AS YD_NM" ).append("\n"); 
		query.append("	         , YD.YD_EML                                           AS YD_EML" ).append("\n"); 
		query.append("	         , YD.PHN_NO                                           AS PHN_NO" ).append("\n"); 
		query.append("	         , VSL.VSL_ENG_NM                                      AS VSL_NM" ).append("\n"); 
		query.append("	         , LOC.LOC_NM                                          AS LOC_NM" ).append("\n"); 
		query.append("	         , DECODE( NVL(DDTL.RLSE_STS_CD,'N'),'N','N','Y')      AS DO_NO_YN" ).append("\n"); 
		query.append("	         , 'N'                                                 AS CXL_FLG" ).append("\n"); 
		query.append("	         , NVL(BDO.DO_NO || BDO.DO_NO_SPLIT,'')                AS DO_NO" ).append("\n"); 
		query.append("	         , BDO.DO_PRN_RMK                                      AS DIFF_RMK" ).append("\n"); 
		query.append("	         , TO_CHAR(DDTL.EVNT_DT,'YYYY-MM-DD HH24:MI')       AS DO_ISS_DT" ).append("\n"); 
		query.append("	         , (SELECT SYS_AREA_GRP_ID " ).append("\n"); 
		query.append("	            FROM COM_SYS_AREA_GRP_ID " ).append("\n"); 
		query.append("	            WHERE  CNT_CD= @[cnt_cd]  " ).append("\n"); 
		query.append("	               AND CO_IND_CD='H' " ).append("\n"); 
		query.append("	               AND SVR_USD_FLG='Y' )                           AS USR_SVR_ID" ).append("\n"); 
		query.append("              , (SELECT TRO.CNTR_RTN_YD_CD  AS CNTR_RTN_YD_CD " ).append("\n"); 
		query.append("	              FROM BKG_EUR_TRO TRO" ).append("\n"); 
		query.append("	              WHERE 1=1" ).append("\n"); 
		query.append("	                AND TRO.BKG_NO  = BCNTR.BKG_NO" ).append("\n"); 
		query.append("                    AND TRO.CNTR_NO  = BCNTR.CNTR_NO" ).append("\n"); 
		query.append("                    AND TRO.CXL_FLG  = 'N'" ).append("\n"); 
		query.append("                    AND ROWNUM = 1) AS CNTR_RTN_YD_CD" ).append("\n"); 
		query.append("             , ( SELECT ACT_CUST_CNT_CD || TO_CHAR (ACT_CUST_SEQ, 'FM000000') CUST" ).append("\n"); 
		query.append("                    FROM   INV_AR_MN" ).append("\n"); 
		query.append("                    WHERE  AR_IF_NO = (SELECT MAX (AR_IF_NO) IF_NO" ).append("\n"); 
		query.append("                                       FROM   INV_AR_MN" ).append("\n"); 
		query.append("                                       WHERE  BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("                                        AND BL_SRC_NO = @[in_bl_no]" ).append("\n"); 
		query.append("                                        AND AR_OFC_CD = (SELECT AR_OFC_CD" ).append("\n"); 
		query.append("                                                            FROM(" ).append("\n"); 
		query.append("                                                                SELECT DISTINCT A.AR_OFC_CD," ).append("\n"); 
		query.append("                                                                  DECODE(B.AR_OFC_CD, A.AR_OFC_CD, 0, 1) OFCSEQ," ).append("\n"); 
		query.append("                                                                  C.INV_DUP_FLG" ).append("\n"); 
		query.append("                                                                FROM INV_AR_MN A," ).append("\n"); 
		query.append("                                                                  MDM_ORGANIZATION B," ).append("\n"); 
		query.append("                                                                  INV_AR_STUP_OFC C" ).append("\n"); 
		query.append("                                                                WHERE A.BL_SRC_NO = @[in_bl_no]" ).append("\n"); 
		query.append("                                                                  AND A.AR_OFC_CD IN (" ).append("\n"); 
		query.append("                                                                    SELECT AR_OFC_CD" ).append("\n"); 
		query.append("                                                                    FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                                    WHERE AR_HD_QTR_OFC_CD = (" ).append("\n"); 
		query.append("                                                                        SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                                                                        FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                                        WHERE OFC_CD = @[usr_ofc_cd])" ).append("\n"); 
		query.append("                                                                      AND OFC_CD = AR_OFC_CD )" ).append("\n"); 
		query.append("                                                                  AND B.OFC_CD = @[usr_ofc_cd]" ).append("\n"); 
		query.append("                                                                  AND A.AR_OFC_CD = C.AR_OFC_CD (+)" ).append("\n"); 
		query.append("                                                                  AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("																  ORDER BY OFCSEQ)" ).append("\n"); 
		query.append("															WHERE ROWNUM = 1" ).append("\n"); 
		query.append("                                                            )" ).append("\n"); 
		query.append("                                                                                        AND NVL (INV_DELT_DIV_CD, 'N') <> 'Y')) AS CUST" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	      FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("	         , BKG_VVD BVVD" ).append("\n"); 
		query.append("	         , BKG_CONTAINER BCNTR" ).append("\n"); 
		query.append("	         , MST_CONTAINER CNTR" ).append("\n"); 
		query.append("	         , BKG_CUSTOMER BCUST" ).append("\n"); 
		query.append("	         , MDM_YARD YD" ).append("\n"); 
		query.append("	         , MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("	         , MDM_LOCATION LOC" ).append("\n"); 
		query.append("	         , BKG_EDI_YD EY" ).append("\n"); 
		query.append("	         , BKG_DO_CNTR DCNTR" ).append("\n"); 
		query.append("	         , BKG_DO_DTL  DDTL" ).append("\n"); 
		query.append("	         , BKG_DO BDO" ).append("\n"); 
		query.append("	     WHERE @[in_option] = 'BL'" ).append("\n"); 
		query.append("	       AND BKG.BL_NO            = @[in_bl_no]" ).append("\n"); 
		query.append("	       AND BCNTR.BKG_NO         = BKG.BKG_NO" ).append("\n"); 
		query.append("	#if ( ${in_cntr_no} != '' )" ).append("\n"); 
		query.append("	       AND BCNTR.CNTR_NO LIKE @[in_cntr_no]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	       AND BVVD.BKG_NO          = BKG.BKG_NO" ).append("\n"); 
		query.append("	    --   AND BVVD.POD_CD          = BKG.POD_CD" ).append("\n"); 
		query.append("	       AND BVVD.VSL_PRE_PST_CD  = 'T'       " ).append("\n"); 
		query.append("	       AND BCUST.BKG_NO         = BKG.BKG_NO " ).append("\n"); 
		query.append("	       AND BCUST.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("	       AND VSL.VSL_CD           = BVVD.VSL_CD" ).append("\n"); 
		query.append("	       AND LOC.LOC_CD           = BVVD.POL_CD  " ).append("\n"); 
		query.append("	       AND DCNTR.BKG_NO(+)      = BCNTR.BKG_NO         " ).append("\n"); 
		query.append("	       AND DCNTR.CNTR_NO(+)     = BCNTR.CNTR_NO      " ).append("\n"); 
		query.append("	       AND BDO.BKG_NO(+)        = DCNTR.BKG_NO" ).append("\n"); 
		query.append("	       AND BDO.RLSE_SEQ(+)      = DCNTR.RLSE_SEQ" ).append("\n"); 
		query.append("	       AND DDTL.BKG_NO(+)       = BDO.BKG_NO " ).append("\n"); 
		query.append("	       AND DDTL.RLSE_SEQ(+)     = BDO.RLSE_SEQ        " ).append("\n"); 
		query.append("	       AND DDTL.RLSE_STS_CD(+)  = 'R'   " ).append("\n"); 
		query.append("	       AND CNTR.CNTR_NO         = BCNTR.CNTR_NO    " ).append("\n"); 
		query.append("	       AND YD.YD_CD(+)          = CNTR.CRNT_YD_CD        " ).append("\n"); 
		query.append("	       AND EY.YD_CD(+)          = YD.YD_CD        " ).append("\n"); 
		query.append("	       AND EY.FULL_RLSE_EDI_CD(+) = '1'" ).append("\n"); 
		query.append("	   UNION ALL" ).append("\n"); 
		query.append("	   SELECT BKG.BL_NO                                            AS BL_NO" ).append("\n"); 
		query.append("	         , BKG.BKG_NO                                          AS BKG_NO" ).append("\n"); 
		query.append("	         , BKG.BKG_CGO_TP_CD                                   AS BKG_CGO_TP_CD" ).append("\n"); 
		query.append("	         , BVVD.VSL_CD||BVVD.SKD_VOY_NO||BVVD.SKD_DIR_CD       AS VVD" ).append("\n"); 
		query.append("	         , BKG.POL_CD                                          AS POL_CD" ).append("\n"); 
		query.append("	         , BVVD.POD_CD                                         AS POD_CD" ).append("\n"); 
		query.append("	         , BKG.DEL_CD                                         AS DEL_CD" ).append("\n"); 
		query.append("	         , BCNTR.CNTR_NO                                       AS CNTR_NO" ).append("\n"); 
		query.append("	         , BCNTR.CNTR_TPSZ_CD                                  AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	         , BKG.DE_TERM_CD                                      AS DE_TERM_CD" ).append("\n"); 
		query.append("	         , CNTR.CRNT_YD_CD                                     AS CRNT_YD_CD   -- 화면상에 YD_CD" ).append("\n"); 
		query.append("	         , CNTR.SYS_AREA_GRP_ID                                AS SVR_ID" ).append("\n"); 
		query.append("	         , BCUST.CUST_NM                                       AS CUST_NM" ).append("\n"); 
		query.append("	         ,(SELECT /*+ INDEX_DESC (ORD XPKBKG_FULL_CGO_RLSE_ORD) */ ORD.RLSE_ORD_SEQ " ).append("\n"); 
		query.append("	           FROM BKG_FULL_CGO_RLSE_ORD ORD " ).append("\n"); 
		query.append("	           WHERE ORD.BKG_NO = BCNTR.BKG_NO " ).append("\n"); 
		query.append("	           AND   ORD.CNTR_NO = BCNTR.CNTR_NO" ).append("\n"); 
		query.append("	           AND   ROWNUM = 1)                                   AS  MAX_RLSE_SEQ  " ).append("\n"); 
		query.append("	         , YD.FAX_NO                                           AS FAX_NO" ).append("\n"); 
		query.append("	         , YD.YD_NM                                            AS YD_NM" ).append("\n"); 
		query.append("	         , YD.YD_EML                                           AS YD_EML" ).append("\n"); 
		query.append("	         , YD.PHN_NO                                           AS PHN_NO" ).append("\n"); 
		query.append("	         , VSL.VSL_ENG_NM                                      AS VSL_NM" ).append("\n"); 
		query.append("	         , LOC.LOC_NM                                          AS LOC_NM" ).append("\n"); 
		query.append("	         , DECODE( NVL(DDTL.RLSE_STS_CD,'N'),'N','N','Y')      AS DO_NO_YN" ).append("\n"); 
		query.append("	         , 'N'                                                 AS CXL_FLG" ).append("\n"); 
		query.append("	         , NVL(BDO.DO_NO || BDO.DO_NO_SPLIT,'')                AS DO_NO" ).append("\n"); 
		query.append("	         , BDO.DO_PRN_RMK                                      AS DIFF_RMK" ).append("\n"); 
		query.append("	         , TO_CHAR(DDTL.EVNT_DT,'YYYY-MM-DD HH24:MI')          AS DO_ISS_DT" ).append("\n"); 
		query.append("	         ,(SELECT SYS_AREA_GRP_ID " ).append("\n"); 
		query.append("	            FROM COM_SYS_AREA_GRP_ID " ).append("\n"); 
		query.append("	            WHERE  CNT_CD = @[cnt_cd] " ).append("\n"); 
		query.append("	               AND CO_IND_CD='H' " ).append("\n"); 
		query.append("	               AND SVR_USD_FLG='Y' )                           AS  USR_SVR_ID" ).append("\n"); 
		query.append("             , (SELECT TRO.CNTR_RTN_YD_CD  AS CNTR_RTN_YD_CD " ).append("\n"); 
		query.append("	              FROM BKG_EUR_TRO TRO" ).append("\n"); 
		query.append("	              WHERE 1=1" ).append("\n"); 
		query.append("	                AND TRO.BKG_NO  = BCNTR.BKG_NO" ).append("\n"); 
		query.append("                    AND TRO.CNTR_NO  = BCNTR.CNTR_NO" ).append("\n"); 
		query.append("                    AND TRO.CXL_FLG  = 'N'" ).append("\n"); 
		query.append("                    AND ROWNUM = 1)  AS CNTR_RTN_YD_CD" ).append("\n"); 
		query.append("			, (SELECT ACT_CUST_CNT_CD || TO_CHAR (ACT_CUST_SEQ, 'FM000000') AS CUST" ).append("\n"); 
		query.append("        		 FROM   INV_AR_MN MN" ).append("\n"); 
		query.append("        		WHERE 1=1" ).append("\n"); 
		query.append("          		  AND  MN.BL_SRC_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("          		  AND  AR_IF_NO = (SELECT MAX (AR_IF_NO) IF_NO" ).append("\n"); 
		query.append("                           FROM   INV_AR_MN A" ).append("\n"); 
		query.append("                           WHERE  BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("                            AND A.BL_SRC_NO = MN.BKG_NO" ).append("\n"); 
		query.append("                            AND AR_OFC_CD = (SELECT DISTINCT A.AR_OFC_CD" ).append("\n"); 
		query.append("                                                    FROM INV_AR_MN A," ).append("\n"); 
		query.append("                                                      MDM_ORGANIZATION B," ).append("\n"); 
		query.append("                                                      INV_AR_STUP_OFC C" ).append("\n"); 
		query.append("                                                    WHERE A.BL_SRC_NO = MN.BKG_NO" ).append("\n"); 
		query.append("                                                      AND A.AR_OFC_CD IN (" ).append("\n"); 
		query.append("                                                                            SELECT AR_OFC_CD" ).append("\n"); 
		query.append("                                                                            FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                                            WHERE AR_HD_QTR_OFC_CD = (" ).append("\n"); 
		query.append("                                                                                SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                                                                                FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                                                WHERE OFC_CD = @[usr_ofc_cd])" ).append("\n"); 
		query.append("                                                                              AND OFC_CD = AR_OFC_CD )" ).append("\n"); 
		query.append("                                                      AND B.OFC_CD = @[usr_ofc_cd]" ).append("\n"); 
		query.append("                                                      AND A.AR_OFC_CD = C.AR_OFC_CD (+)" ).append("\n"); 
		query.append("                                                      AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("                                                      AND ROWNUM = 1 )" ).append("\n"); 
		query.append("                                                      " ).append("\n"); 
		query.append("                            AND NVL (INV_DELT_DIV_CD, 'N') <> 'Y')) AS CUST" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	      FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("	         , BKG_VVD BVVD" ).append("\n"); 
		query.append("	         , BKG_CONTAINER BCNTR" ).append("\n"); 
		query.append("	         , MST_CONTAINER CNTR" ).append("\n"); 
		query.append("	         , BKG_CUSTOMER BCUST" ).append("\n"); 
		query.append("	         , MDM_YARD YD" ).append("\n"); 
		query.append("	         , MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("	         , MDM_LOCATION LOC" ).append("\n"); 
		query.append("	         , BKG_EDI_YD EY" ).append("\n"); 
		query.append("	         , BKG_DO_CNTR DCNTR" ).append("\n"); 
		query.append("	         , BKG_DO_DTL  DDTL" ).append("\n"); 
		query.append("	         , BKG_DO BDO" ).append("\n"); 
		query.append("	     WHERE 'VVD'               =  @[in_option]" ).append("\n"); 
		query.append("	       AND BVVD.VSL_CD         = SUBSTR(@[in_vvd], 1, 4)" ).append("\n"); 
		query.append("	       AND BVVD.SKD_VOY_NO     = SUBSTR(@[in_vvd], 5, 4)" ).append("\n"); 
		query.append("	       AND BVVD.SKD_DIR_CD     = SUBSTR(@[in_vvd], 9, 1)     " ).append("\n"); 
		query.append("	       AND BVVD.VSL_PRE_PST_CD = 'T'       " ).append("\n"); 
		query.append("	       AND BVVD.POD_CD         = @[in_pod] " ).append("\n"); 
		query.append("	       AND BCNTR.BKG_NO        = BVVD.BKG_NO " ).append("\n"); 
		query.append("	#if ( ${in_cntr_no} != '' )" ).append("\n"); 
		query.append("	       AND BCNTR.CNTR_NO LIKE  @[in_cntr_no]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	       AND BKG.BKG_NO           = BVVD.BKG_NO " ).append("\n"); 
		query.append("	       AND BKG.BKG_STS_CD       IN ('W', 'F')" ).append("\n"); 
		query.append("	       " ).append("\n"); 
		query.append("	       " ).append("\n"); 
		query.append("	#if ( ${in_del} != '' )" ).append("\n"); 
		query.append("	       AND BKG.DEL_CD  like @[in_del]||'%' " ).append("\n"); 
		query.append("	       " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	       AND BCUST.BKG_NO         = BVVD.BKG_NO " ).append("\n"); 
		query.append("	       AND BCUST.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("	       AND DCNTR.BKG_NO(+)      = BCNTR.BKG_NO " ).append("\n"); 
		query.append("	       AND DCNTR.CNTR_NO(+)     = BCNTR.CNTR_NO   " ).append("\n"); 
		query.append("	       AND BDO.BKG_NO(+)        = DCNTR.BKG_NO" ).append("\n"); 
		query.append("	       AND BDO.RLSE_SEQ(+)      = DCNTR.RLSE_SEQ" ).append("\n"); 
		query.append("	       AND DDTL.BKG_NO(+)       = DCNTR.BKG_NO " ).append("\n"); 
		query.append("	       AND DDTL.RLSE_SEQ(+)     = DCNTR.RLSE_SEQ " ).append("\n"); 
		query.append("	       AND DDTL.RLSE_STS_CD(+)  = 'R'      " ).append("\n"); 
		query.append("	       AND VSL.VSL_CD           = BVVD.VSL_CD " ).append("\n"); 
		query.append("	       AND LOC.LOC_CD           = BVVD.POL_CD " ).append("\n"); 
		query.append("	       AND CNTR.CNTR_NO         = BCNTR.CNTR_NO " ).append("\n"); 
		query.append("	       AND YD.YD_CD(+)          = CNTR.CRNT_YD_CD     " ).append("\n"); 
		query.append("	       AND EY.YD_CD(+)          = YD.YD_CD " ).append("\n"); 
		query.append("	       AND EY.FULL_RLSE_EDI_CD(+) = '1'" ).append("\n"); 
		query.append("	) MST, BKG_FULL_CGO_RLSE_ORD FORD" ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("	#if ( ${in_do_no} != '')" ).append("\n"); 
		query.append("	  AND DO_NO_YN = @[in_do_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	AND FORD.BKG_NO(+)            = MST.BKG_NO" ).append("\n"); 
		query.append("	AND FORD.CNTR_NO(+)           = MST.CNTR_NO" ).append("\n"); 
		query.append("	AND FORD.RLSE_ORD_SEQ(+)      = MST.MAX_RLSE_SEQ" ).append("\n"); 
		query.append("	#if ( ${sent_flg} != 'A')" ).append("\n"); 
		query.append("	AND DECODE( NVL(FORD.CGOR_MZD_CD,'N') ,'E','Y'" ).append("\n"); 
		query.append("	                                      ,'F','Y'" ).append("\n"); 
		query.append("	                                      ,'M','Y'" ).append("\n"); 
		query.append("	                                      ,'N')    = @[sent_flg]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	ORDER BY MST.BL_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
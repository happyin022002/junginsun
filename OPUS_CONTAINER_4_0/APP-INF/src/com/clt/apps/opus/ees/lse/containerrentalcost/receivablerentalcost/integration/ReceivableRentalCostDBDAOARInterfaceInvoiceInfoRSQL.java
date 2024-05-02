/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ReceivableRentalCostDBDAOARInterfaceInvoiceInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.31
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.03.31 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceivableRentalCostDBDAOARInterfaceInvoiceInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice 자료의 AR Interface Main 정보를 조회합니다.
	  * </pre>
	  */
	public ReceivableRentalCostDBDAOARInterfaceInvoiceInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("inv_isu_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.integration").append("\n"); 
		query.append("FileName : ReceivableRentalCostDBDAOARInterfaceInvoiceInfoRSQL").append("\n"); 
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
		query.append("SELECT  P.INV_NO AS BL_SRC_NO," ).append("\n"); 
		query.append("        P.INV_NO AS INV_SRC_NO," ).append("\n"); 
		query.append("        P.VNDR_CNT_CD AS CUST_CNT_CD,                     " ).append("\n"); 
		query.append("        P.CUST_SEQ AS CUST_SEQ,                         " ).append("\n"); 
		query.append("        P.AR_OFC_CD AS OFC_CD,                     " ).append("\n"); 
		query.append("        'LSE' AS IF_SRC_CD,                     " ).append("\n"); 
		query.append("        'CNTC' AS VSL_CD,                       " ).append("\n"); 
		query.append("		--TO_CHAR(A.GL_EFF_DT, 'YYMM') AS SKD_VOY_NO, " ).append("\n"); 
		query.append("        SUBSTR(B.QTY_YRMON, 3, 6) AS SKD_VOY_NO," ).append("\n"); 
		query.append("        'M' AS SKD_DIR_CD,                 " ).append("\n"); 
		query.append("        'OTH' AS SVC_SCP_CD,                  " ).append("\n"); 
		query.append("		--TO_CHAR(LAST_DAY(A.GL_EFF_DT), 'YYYYMMDD') AS SAIL_DT," ).append("\n"); 
		query.append("        TO_CHAR(LAST_DAY(TO_DATE(B.QTY_YRMON, 'YYYYMM')), 'YYYYMMDD') AS SAIL_DT," ).append("\n"); 
		query.append("        TO_CHAR(SYSDATE,'YYYYMMDD') AS SAIL_ARR_DT,         " ).append("\n"); 
		query.append("        P.INV_DUE_DT AS DUE_DT, " ).append("\n"); 
		query.append("       	TO_CHAR(A.GL_EFF_DT, 'YYYYMMDD') AS GL_EFF_DT," ).append("\n"); 
		query.append("        'CNT' AS SLAN_CD," ).append("\n"); 
		query.append("        'O' AS IO_BND_CD," ).append("\n"); 
		query.append("        'CNTC' AS TRNK_VSL_CD," ).append("\n"); 
		query.append("		--TO_CHAR(A.GL_EFF_DT, 'YYMM') AS TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("        SUBSTR(B.QTY_YRMON, 3, 6) AS TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("        'M' AS TRNK_SKD_DIR_CD, " ).append("\n"); 
		query.append("        P.LOC_CD AS POR_CD,    " ).append("\n"); 
		query.append("        P.LOC_CD AS POL_CD,    " ).append("\n"); 
		query.append("        P.LOC_CD AS POD_CD,    " ).append("\n"); 
		query.append("        P.LOC_CD AS DEL_CD,    " ).append("\n"); 
		query.append("        NVL(B.BKG_TEU_QTY, 0) AS BKG_TEU_QTY," ).append("\n"); 
		query.append("        NVL(B.BKG_FEU_QTY, 0) AS BKG_FEU_QTY," ).append("\n"); 
		query.append("        P.INV_NO AS INV_REF_NO," ).append("\n"); 
		query.append("        P.CRE_USR_ID AS CRE_USR_ID," ).append("\n"); 
		query.append("        SYSDATE AS CRE_DT," ).append("\n"); 
		query.append("        P.CRE_USR_ID AS UPD_USR_ID," ).append("\n"); 
		query.append("        SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM   (SELECT  @[inv_no]     AS INV_NO," ).append("\n"); 
		query.append("	            @[cost_yrmon] AS COST_YRMON,                        " ).append("\n"); 
		query.append("    	        @[inv_due_dt] AS INV_DUE_DT," ).append("\n"); 
		query.append("        	    @[cre_usr_id] AS CRE_USR_ID," ).append("\n"); 
		query.append("	            A.OFC_CD, " ).append("\n"); 
		query.append("				A.LOC_CD, " ).append("\n"); 
		query.append("				A.AR_OFC_CD, " ).append("\n"); 
		query.append("				@[cust_cnt_cd] AS VNDR_CNT_CD," ).append("\n"); 
		query.append("				@[cust_seq]    AS CUST_SEQ" ).append("\n"); 
		query.append("	    FROM    MDM_ORGANIZATION A" ).append("\n"); 
		query.append("    	WHERE   A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("		) P," ).append("\n"); 
		query.append("	   (SELECT  DECODE(CLZ_STS_CD, 'O', ISU_GL_DT, 'C', MIN_GL_DT) AS GL_EFF_DT" ).append("\n"); 
		query.append("        FROM   (SELECT  A.CLZ_STS_CD, TO_DATE(@[inv_isu_dt], 'YYYYMMDD') AS ISU_GL_DT, " ).append("\n"); 
		query.append("                        TO_DATE(MIN(B.EFF_YRMON||'01') OVER(),'YYYYMMDD') AS MIN_GL_DT " ).append("\n"); 
		query.append("                FROM    AP_PERIOD A," ).append("\n"); 
		query.append("                        AP_PERIOD B                        " ).append("\n"); 
		query.append("                WHERE   A.SYS_DIV_CD = B.SYS_DIV_CD" ).append("\n"); 
		query.append("                AND     A.AR_AP_DIV_CD = B.AR_AP_DIV_CD" ).append("\n"); 
		query.append("                AND     A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("                AND     A.SYS_DIV_CD = 33" ).append("\n"); 
		query.append("                AND     A.AR_AP_DIV_CD = 'R'" ).append("\n"); 
		query.append("                AND     A.OFC_CD IN (SELECT  DECODE(ROWNUM,1, AR_OFC_CD, AR_HD_QTR_OFC_CD)    " ).append("\n"); 
		query.append("                                     FROM    MDM_ORGANIZATION," ).append("\n"); 
		query.append("                                            (SELECT LEVEL  FROM  DUAL" ).append("\n"); 
		query.append("                                             CONNECT BY LEVEL <= 2)" ).append("\n"); 
		query.append("                                     WHERE   OFC_CD = @[ofc_cd]) " ).append("\n"); 
		query.append("                AND     A.EFF_YRMON  = TO_CHAR(TO_DATE(@[inv_isu_dt], 'YYYYMMDD'), 'YYYYMM')" ).append("\n"); 
		query.append("                AND     B.EFF_YRMON >= TO_CHAR(TO_DATE(@[inv_isu_dt], 'YYYYMMDD'), 'YYYYMM')" ).append("\n"); 
		query.append("                AND     B.CLZ_STS_CD = 'O'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        WHERE   ROWNUM = 1" ).append("\n"); 
		query.append("		) A," ).append("\n"); 
		query.append("       (SELECT  SUM(CASE WHEN SUBSTR(B.CNTR_TPSZ_CD, 2)  = '2' " ).append("\n"); 
		query.append("						 THEN COUNT(DISTINCT B.CNTR_NO) END) BKG_TEU_QTY," ).append("\n"); 
		query.append("                SUM(CASE WHEN SUBSTR(B.CNTR_TPSZ_CD, 2) <> '2' " ).append("\n"); 
		query.append("					     THEN COUNT(DISTINCT B.CNTR_NO) END) BKG_FEU_QTY," ).append("\n"); 
		query.append("                MAX(A.QTY_YRMON) AS QTY_YRMON        " ).append("\n"); 
		query.append("        FROM    LSE_RCV_RNTL_CHG A," ).append("\n"); 
		query.append("                LSE_RCV_RNTL_CHG_DTL B" ).append("\n"); 
		query.append("        WHERE   A.COST_YRMON = B.COST_YRMON" ).append("\n"); 
		query.append("        AND     A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND     A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("        AND     A.RCV_RNTL_SEQ = B.RCV_RNTL_SEQ" ).append("\n"); 
		query.append("        AND     A.COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("        AND		A.INV_NO = @[inv_no]      " ).append("\n"); 
		query.append("#if (${rcv_rntl_seq} != '')" ).append("\n"); 
		query.append("		AND     A.RCV_RNTL_SEQ IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${rcv_rntl_no_seq})" ).append("\n"); 
		query.append("		#if($velocityCount < $rcv_rntl_no_seq.size())" ).append("\n"); 
		query.append("			'$key'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("        GROUP BY A.QTY_YRMON, B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		) B" ).append("\n"); 

	}
}
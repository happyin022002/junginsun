/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BLDocumentationBLDBDAOSearchPoExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOSearchPoExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLDocumentationBLDBDAOSearchPoExistRSQL
	  * </pre>
	  */
	public BLDocumentationBLDBDAOSearchPoExistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOSearchPoExistRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(MAX(SYS_CONNECT_BY_PATH(ITEM,',')),2) AS PATH_ITEM" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT *" ).append("\n"); 
		query.append("      FROM " ).append("\n"); 
		query.append("        (SELECT ITEM" ).append("\n"); 
		query.append("              ,CASE WHEN ITEM = 'POB' THEN DECODE((SELECT COUNT(*) FROM BKG_REFERENCE WHERE BKG_NO = @[bkg_no] AND BKG_REF_TP_CD = 'BKPO' AND CUST_REF_NO_CTNT IS NOT NULL),0,'N','Y')" ).append("\n"); 
		query.append("                    WHEN ITEM = 'POC' THEN DECODE((SELECT COUNT(*) FROM BKG_REFERENCE WHERE BKG_NO = @[bkg_no] AND BKG_REF_TP_CD = 'CTPO' AND CUST_REF_NO_CTNT IS NOT NULL),CNTR_CNT,'Y','N')" ).append("\n"); 
		query.append("                    WHEN ITEM = 'POM' THEN (SELECT DECODE(COUNT(*),0,'Y','N')" ).append("\n"); 
		query.append("                                               FROM (" ).append("\n"); 
		query.append("                                                    SELECT CON.CNTR_NO" ).append("\n"); 
		query.append("                                                    FROM BKG_REF_DTL DTL" ).append("\n"); 
		query.append("                                                      ,BKG_CONTAINER CON" ).append("\n"); 
		query.append("                                                    WHERE CON.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                                    AND CON.BKG_NO = DTL.BKG_NO(+)" ).append("\n"); 
		query.append("                                                    AND CON.CNTR_NO = DTL.CNTR_NO(+)" ).append("\n"); 
		query.append("                                                    GROUP BY CON.CNTR_NO" ).append("\n"); 
		query.append("                                                    HAVING SUM(DECODE(DTL.PO_NO,'',0,1)) = 0))" ).append("\n"); 
		query.append("                   WHEN ITEM = 'INV' THEN DECODE((SELECT COUNT(*) FROM BKG_REFERENCE WHERE BKG_NO = @[bkg_no] AND BKG_REF_TP_CD = 'HINV' AND CUST_REF_NO_CTNT IS NOT NULL),0,'N','Y')" ).append("\n"); 
		query.append("                   WHEN ITEM = 'DPT' THEN DECODE((SELECT COUNT(*) FROM BKG_REFERENCE WHERE BKG_NO = @[bkg_no] AND BKG_REF_TP_CD = 'HPDP' AND CUST_REF_NO_CTNT IS NOT NULL),0,'N','Y')" ).append("\n"); 
		query.append("                   WHEN ITEM = 'LCN' THEN DECODE((SELECT COUNT(*) FROM BKG_REFERENCE WHERE BKG_NO = @[bkg_no] AND BKG_REF_TP_CD = 'LCNO' AND CUST_REF_NO_CTNT IS NOT NULL),0,'N','Y')" ).append("\n"); 
		query.append("                   WHEN ITEM = 'SHP' THEN DECODE((SELECT COUNT(*) FROM BKG_REF_DTL WHERE BKG_NO = @[bkg_no] AND DE_NO IS NOT NULL),0,'N','Y')" ).append("\n"); 
		query.append("                   WHEN ITEM = 'PRT' THEN DECODE((SELECT COUNT(*) FROM BKG_REF_DTL WHERE BKG_NO = @[bkg_no] AND PRT_NO IS NOT NULL),0,'N','Y')" ).append("\n"); 
		query.append("                   WHEN ITEM = 'INC' THEN DECODE((SELECT COUNT(*) FROM BKG_REFERENCE WHERE BKG_NO = @[bkg_no] AND BKG_REF_TP_CD = 'INCO' AND CUST_REF_NO_CTNT IS NOT NULL),0,'N','Y')           " ).append("\n"); 
		query.append("                   END AS DATA_EXIST_FLG" ).append("\n"); 
		query.append("              ,ROWNUM AS RID" ).append("\n"); 
		query.append("          FROM" ).append("\n"); 
		query.append("        (SELECT DISTINCT DTL.BKG_MDT_ITM_CD AS ITEM " ).append("\n"); 
		query.append("                        ,(SELECT COUNT(*) FROM BKG_CONTAINER WHERE BKG_NO = @[bkg_no]) as CNTR_CNT" ).append("\n"); 
		query.append("                          FROM (SELECT MDT_ITM_SEQ" ).append("\n"); 
		query.append("                                  FROM (SELECT A1.BKG_NO " ).append("\n"); 
		query.append("                                              ,DECODE(A2.BKG_CUST_TP_CD, 'S', 'SH'" ).append("\n"); 
		query.append("                                                                       , 'C', 'CN'" ).append("\n"); 
		query.append("                                                                       , 'N', 'NT'" ).append("\n"); 
		query.append("                                                                       , '') AS MDT_CUST_TP_CD                               " ).append("\n"); 
		query.append("                                              ,NVL(A2.CUST_CNT_CD, '0') AS CUST_CNT_CD" ).append("\n"); 
		query.append("                                              ,NVL(A2.CUST_SEQ, '0') AS CUST_SEQ" ).append("\n"); 
		query.append("                                              ,NVL(A1.SC_NO, '0') AS SC_NO" ).append("\n"); 
		query.append("                                              ,NVL(A1.RFA_NO, '0') AS RFA_NO" ).append("\n"); 
		query.append("                                              ,NVL(A1.SVC_SCP_CD, '0') AS SVC_SCP_CD" ).append("\n"); 
		query.append("                                              ,NVL(A1.POR_CD, '0') AS POR_CD" ).append("\n"); 
		query.append("                                              ,NVL(A1.POL_CD, '0') AS POL_CD" ).append("\n"); 
		query.append("                                              ,NVL(A1.POD_CD, '0') AS POD_CD" ).append("\n"); 
		query.append("                                              ,NVL(A1.DEL_CD, '0') AS DEL_CD" ).append("\n"); 
		query.append("                                              ,NVL(A3.CUST_GRP_ID, '0') AS CUST_GRP_ID" ).append("\n"); 
		query.append("                                          FROM BKG_BOOKING A1" ).append("\n"); 
		query.append("                                              ,BKG_CUSTOMER A2" ).append("\n"); 
		query.append("                                              ,MDM_CUSTOMER A3" ).append("\n"); 
		query.append("                                         WHERE A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("                                           AND A1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                           AND A2.BKG_CUST_TP_CD IN ('S','C','N')" ).append("\n"); 
		query.append("                                           AND A2.CUST_CNT_CD = A3.CUST_CNT_CD" ).append("\n"); 
		query.append("                                           AND A2.CUST_SEQ = A3.CUST_SEQ" ).append("\n"); 
		query.append("                                       ) B1" ).append("\n"); 
		query.append("                                      ,(SELECT MDT_ITM_SEQ" ).append("\n"); 
		query.append("                                              ,DECODE(CUST_GRP_ID, 'G',  CUST_GRP_ID||'-'||CUST_CNT_CD||LPAD(CUST_SEQ,6,0)) AS CUST_GRP_ID" ).append("\n"); 
		query.append("                                              ,MDT_CUST_TP_CD" ).append("\n"); 
		query.append("                                              ,CUST_CNT_CD" ).append("\n"); 
		query.append("                                              ,CUST_SEQ" ).append("\n"); 
		query.append("                                              ,SC_NO" ).append("\n"); 
		query.append("                                              ,RFA_NO" ).append("\n"); 
		query.append("                                              ,SVC_SCP_CD" ).append("\n"); 
		query.append("                                              ,POR_CD" ).append("\n"); 
		query.append("                                              ,POL_CD" ).append("\n"); 
		query.append("                                              ,POD_CD" ).append("\n"); 
		query.append("                                              ,DEL_CD" ).append("\n"); 
		query.append("                                          FROM BKG_MDT_ITM" ).append("\n"); 
		query.append("                                       ) B2" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                   AND B1.MDT_CUST_TP_CD = DECODE(B2.MDT_CUST_TP_CD, 'Al', B1.MDT_CUST_TP_CD, B2.MDT_CUST_TP_CD) " ).append("\n"); 
		query.append("                                   AND B1.CUST_GRP_ID = NVL(B2.CUST_GRP_ID, B1.CUST_GRP_ID)" ).append("\n"); 
		query.append("                                   AND B1.CUST_CNT_CD = NVL(B2.CUST_CNT_CD, B1.CUST_CNT_CD)" ).append("\n"); 
		query.append("                                   AND B1.CUST_SEQ = NVL(B2.CUST_SEQ, B1.CUST_SEQ)" ).append("\n"); 
		query.append("                                   AND B1.SC_NO = NVL(B2.SC_NO, B1.SC_NO)" ).append("\n"); 
		query.append("                                   AND B1.RFA_NO = NVL(B2.RFA_NO, B1.RFA_NO)" ).append("\n"); 
		query.append("                                   AND B1.SVC_SCP_CD = NVL(B2.SVC_SCP_CD, B1.SVC_SCP_CD)" ).append("\n"); 
		query.append("                                   AND B1.POR_CD LIKE B2.POR_CD || '%'" ).append("\n"); 
		query.append("                                   AND B1.POL_CD LIKE B2.POL_CD || '%'" ).append("\n"); 
		query.append("                                   AND B1.POD_CD LIKE B2.POD_CD || '%'" ).append("\n"); 
		query.append("                                   AND B1.DEL_CD LIKE B2.DEL_CD || '%'" ).append("\n"); 
		query.append("                               ) ITM, BKG_MDT_ITM_DTL DTL " ).append("\n"); 
		query.append("                         WHERE ITM.MDT_ITM_SEQ = DTL.MDT_ITM_SEQ" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    WHERE DATA_EXIST_FLG = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("START WITH RID =  1" ).append("\n"); 
		query.append("CONNECT BY PRIOR RID + 1 = RID" ).append("\n"); 

	}
}
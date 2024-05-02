/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchBlIssNoteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchBlIssNoteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BL Issue note list조회
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchBlIssNoteRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchBlIssNoteRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT B2.MDT_CUST_TP_CD" ).append("\n"); 
		query.append("               ,B2.CUST_CNT_CD" ).append("\n"); 
		query.append("               ,B2.SC_NO" ).append("\n"); 
		query.append("               ,B2.RFA_NO" ).append("\n"); 
		query.append("               ,B2.POR_CD" ).append("\n"); 
		query.append("               ,B2.POL_CD" ).append("\n"); 
		query.append("               ,B2.POD_CD" ).append("\n"); 
		query.append("               ,B2.DEL_CD" ).append("\n"); 
		query.append("               ,LPAD(B2.CUST_SEQ,6,'0') AS CUST_SEQ" ).append("\n"); 
		query.append("               ,B2.BL_ISS_NOTE_CTNT" ).append("\n"); 
		query.append("FROM (SELECT A1.BKG_NO" ).append("\n"); 
		query.append("            ,DECODE(A2.BKG_CUST_TP_CD, 'S', 'SH'" ).append("\n"); 
		query.append("            , 'C', 'CN'" ).append("\n"); 
		query.append("            , 'N', 'NT'" ).append("\n"); 
		query.append("            , '') AS MDT_CUST_TP_CD" ).append("\n"); 
		query.append("            ,NVL(A2.CUST_CNT_CD, '0') AS CUST_CNT_CD" ).append("\n"); 
		query.append("            ,NVL(A2.CUST_SEQ, '0') AS CUST_SEQ" ).append("\n"); 
		query.append("            ,NVL(A1.SC_NO, '0') AS SC_NO" ).append("\n"); 
		query.append("            ,NVL(A1.RFA_NO, '0') AS RFA_NO" ).append("\n"); 
		query.append("            ,NVL(A1.SVC_SCP_CD, '0') AS SVC_SCP_CD" ).append("\n"); 
		query.append("            ,NVL(A1.POR_CD, '0') AS POR_CD" ).append("\n"); 
		query.append("            ,NVL(A1.POL_CD, '0') AS POL_CD" ).append("\n"); 
		query.append("            ,NVL(A1.POD_CD, '0') AS POD_CD" ).append("\n"); 
		query.append("            ,NVL(A1.DEL_CD, '0') AS DEL_CD" ).append("\n"); 
		query.append("            ,NVL(A3.CUST_GRP_ID, '0') AS CUST_GRP_ID" ).append("\n"); 
		query.append("            FROM BKG_BOOKING A1" ).append("\n"); 
		query.append("            ,BKG_CUSTOMER A2" ).append("\n"); 
		query.append("            ,MDM_CUSTOMER A3" ).append("\n"); 
		query.append("            WHERE A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("            AND A1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND A2.BKG_CUST_TP_CD IN ('S','C','N')" ).append("\n"); 
		query.append("            AND A2.CUST_CNT_CD = A3.CUST_CNT_CD" ).append("\n"); 
		query.append("            AND A2.CUST_SEQ = A3.CUST_SEQ" ).append("\n"); 
		query.append("    ) B1" ).append("\n"); 
		query.append("    ,(SELECT MDT_ITM_SEQ" ).append("\n"); 
		query.append("            ,DECODE(CUST_GRP_ID, 'G',  CUST_GRP_ID||'-'||CUST_CNT_CD||LPAD(CUST_SEQ,6,0)) AS CUST_GRP_ID" ).append("\n"); 
		query.append("            ,MDT_CUST_TP_CD" ).append("\n"); 
		query.append("            ,CUST_CNT_CD" ).append("\n"); 
		query.append("            ,CUST_SEQ" ).append("\n"); 
		query.append("            ,SC_NO" ).append("\n"); 
		query.append("            ,RFA_NO" ).append("\n"); 
		query.append("            ,SVC_SCP_CD" ).append("\n"); 
		query.append("            ,POR_CD" ).append("\n"); 
		query.append("            ,POL_CD" ).append("\n"); 
		query.append("            ,POD_CD" ).append("\n"); 
		query.append("            ,DEL_CD" ).append("\n"); 
		query.append("            ,BL_ISS_NOTE_CTNT" ).append("\n"); 
		query.append("            FROM BKG_MDT_ITM" ).append("\n"); 
		query.append("    ) B2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND B1.MDT_CUST_TP_CD = DECODE(B2.MDT_CUST_TP_CD, 'Al', B1.MDT_CUST_TP_CD, B2.MDT_CUST_TP_CD)" ).append("\n"); 
		query.append("AND B1.CUST_GRP_ID = NVL(B2.CUST_GRP_ID, B1.CUST_GRP_ID)" ).append("\n"); 
		query.append("AND B1.CUST_CNT_CD = NVL(B2.CUST_CNT_CD, B1.CUST_CNT_CD)" ).append("\n"); 
		query.append("AND B1.CUST_SEQ = NVL(B2.CUST_SEQ, B1.CUST_SEQ)" ).append("\n"); 
		query.append("AND B1.SC_NO = NVL(B2.SC_NO, B1.SC_NO)" ).append("\n"); 
		query.append("AND B1.RFA_NO = NVL(B2.RFA_NO, B1.RFA_NO)" ).append("\n"); 
		query.append("AND B1.SVC_SCP_CD = NVL(B2.SVC_SCP_CD, B1.SVC_SCP_CD)" ).append("\n"); 
		query.append("AND B1.POR_CD LIKE B2.POR_CD || '%'" ).append("\n"); 
		query.append("AND B1.POL_CD LIKE B2.POL_CD || '%'" ).append("\n"); 
		query.append("AND B1.POD_CD LIKE B2.POD_CD || '%'" ).append("\n"); 
		query.append("AND B1.DEL_CD LIKE B2.DEL_CD || '%'" ).append("\n"); 
		query.append("AND B2.BL_ISS_NOTE_CTNT IS NOT NULL" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderIssueDBDAOSearchCntInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.29
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.02.29 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderIssueDBDAOSearchCntInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 미주 Customer Nominated Trucker 조회
	  * </pre>
	  */
	public WorkOrderIssueDBDAOSearchCntInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FM_NOD_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TO_NOD_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("SC_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_BND_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("RFA_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("DOR_NOD_CD",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.integration").append("\n"); 
		query.append("FileName : WorkOrderIssueDBDAOSearchCntInfoRSQL").append("\n"); 
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
		query.append("SELECT X.VNDR_SEQ           VNDR_SEQ" ).append("\n"); 
		query.append("      ,(SELECT A.VNDR_LGL_ENG_NM  FROM MDM_VENDOR A WHERE A.VNDR_SEQ = X.VNDR_SEQ)   VNDR_NM" ).append("\n"); 
		query.append("      ,X.CTRT_CUST_CNT_CD   CUST_CNT_CD" ).append("\n"); 
		query.append("      ,X.CTRT_CUST_SEQ      CUST_SEQ" ).append("\n"); 
		query.append("      ,X.CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("  FROM TRS_CUST_NOMI_TRKR X" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND X.PRC_CTRT_TP_CD = DECODE(@[SC_NO],'','R','S')" ).append("\n"); 
		query.append("   AND X.PRC_CTRT_NO = NVL(@[SC_NO],@[RFA_NO])" ).append("\n"); 
		query.append("   AND X.IO_BND_CD = @[TRSP_BND_CD]" ).append("\n"); 
		query.append("   AND X.ORG_NOD_CD = CASE WHEN @[TRSP_BND_CD] = 'I' AND LENGTH(X.ORG_NOD_CD)= 5 THEN SUBSTR(@[FM_NOD_CD],1,5)" ).append("\n"); 
		query.append("                           WHEN @[TRSP_BND_CD] = 'I' AND LENGTH(X.ORG_NOD_CD)= 7 THEN @[FM_NOD_CD]" ).append("\n"); 
		query.append("                           WHEN @[TRSP_BND_CD] = 'O' AND LENGTH(X.ORG_NOD_CD)= 5 THEN SUBSTR(@[DOR_NOD_CD],1,5)" ).append("\n"); 
		query.append("                           WHEN @[TRSP_BND_CD] = 'O' AND LENGTH(X.ORG_NOD_CD)= 7 THEN @[DOR_NOD_CD]" ).append("\n"); 
		query.append("                       END " ).append("\n"); 
		query.append("   AND X.DEST_NOD_CD = CASE WHEN @[TRSP_BND_CD] = 'I' AND LENGTH(X.DEST_NOD_CD)= 5 THEN SUBSTR(@[DOR_NOD_CD],1,5)" ).append("\n"); 
		query.append("                            WHEN @[TRSP_BND_CD] = 'I' AND LENGTH(X.DEST_NOD_CD)= 7 THEN @[DOR_NOD_CD]" ).append("\n"); 
		query.append("                            WHEN @[TRSP_BND_CD] = 'O' AND LENGTH(X.DEST_NOD_CD)= 5 THEN SUBSTR(@[TO_NOD_CD],1,5)" ).append("\n"); 
		query.append("                            WHEN @[TRSP_BND_CD] = 'O' AND LENGTH(X.DEST_NOD_CD)= 7 THEN @[TO_NOD_CD]" ).append("\n"); 
		query.append("                        END " ).append("\n"); 
		query.append("   AND X.DISP_STS_CD = '03'" ).append("\n"); 
		query.append("   AND ROWNUM =1" ).append("\n"); 

	}
}
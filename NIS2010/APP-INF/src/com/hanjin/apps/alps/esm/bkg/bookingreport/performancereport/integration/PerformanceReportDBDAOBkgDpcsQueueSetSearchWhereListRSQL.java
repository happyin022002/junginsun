/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PerformanceReportDBDAOBkgDpcsQueueSetSearchWhereListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.10 
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

public class PerformanceReportDBDAOBkgDpcsQueueSetSearchWhereListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PerformanceReportDBDAOBkgDpcsQueueSetSearchWhereListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOBkgDpcsQueueSetSearchWhereListRSQL").append("\n"); 
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
		query.append("SELECT BKG_JOIN_FNC( CURSOR(" ).append("\n"); 
		query.append("SELECT DECODE(ROWNUM,1,'AND (', 'OR ') || '(1=1 ' || " ).append("\n"); 
		query.append("  DECODE(ORG_CNT_CD,        NULL,' ', ' AND ''' || ORG_CNT_CD || ''' IN (POR.CNT_CD, POL.CNT_CD)') || " ).append("\n"); 
		query.append("  DECODE(POL_CD,            NULL,' ', ' AND B.POL_CD = ''' || POL_CD || '''') ||" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("  DECODE(DEL_CONTI_CD,      NULL,' ', ' AND NVL(DEL.CONTI_CD,POD.CONTI_CD) ' ||" ).append("\n"); 
		query.append("                                        ' IN (''' || DECODE(DEL_CONTI_CD,  'E', 'F'',''E', DEL_CONTI_CD) || ''')') ||" ).append("\n"); 
		query.append("  DECODE(HNDL_OFC_CD,       NULL,' ', ' AND XTER.HNDL_OFC_CD = ''' || HNDL_OFC_CD || '''') ||   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  DECODE(CUST_CNT_CD,       NULL,' ', ' AND DECODE('''||SRCH.BKG_CUST_TP_CD||''', ''F'', F.BKG_CUST_TP_CD, ''C'', C.BKG_CUST_TP_CD, S.BKG_CUST_TP_CD) = '''||SRCH.CUST_CNT_CD||'''')||" ).append("\n"); 
		query.append("  DECODE(CUST_SEQ, 0, ' ',  NULL,' ', ' AND DECODE('''||SRCH.BKG_CUST_TP_CD||''', ''F'', F.CUST_SEQ, ''C'', C.CUST_SEQ, S.CUST_SEQ) = '''||SRCH.CUST_SEQ||'''')||" ).append("\n"); 
		query.append("  DECODE(CUST_NM,       	NULL,' ', ' AND DECODE('''||SRCH.BKG_CUST_TP_CD||''', ''F'', F.CUST_NM,  ''C'', C.CUST_NM,  S.CUST_NM)  LIKE '''||SRCH.CUST_NM||'%''')||" ).append("\n"); 
		query.append("  DECODE(SLAN_CD,           NULL,' ', ' AND VVD.SLAN_CD = ''' || SLAN_CD || '''') || " ).append("\n"); 
		query.append("  DECODE(SREP_CD,           NULL,' ', ' AND NVL(B.OB_SREP_CD, XTER.SREP_CD)  = ''' || SREP_CD ||'''')||" ).append("\n"); 
		query.append("  ')' CUST_NM" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("FROM BKG_XTER_SRCH_SET SRCH" ).append("\n"); 
		query.append("WHERE USR_ID = @[usr_id]" ).append("\n"); 
		query.append("AND SET_SLCT_FLG = 'Y'" ).append("\n"); 
		query.append("AND DOC_TP_CD = 'D'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",'\n'" ).append("\n"); 
		query.append(") FROM DUAL" ).append("\n"); 

	}
}
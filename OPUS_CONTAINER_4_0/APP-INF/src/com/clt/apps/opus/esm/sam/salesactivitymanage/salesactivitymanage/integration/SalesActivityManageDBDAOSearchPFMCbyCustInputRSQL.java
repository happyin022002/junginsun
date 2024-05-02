/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SalesActivityManageDBDAOSearchPFMCbyCustInputRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.22
*@LastModifier : 이관샨 
*@LastVersion : 1.0
* 2011.07.22 이관샨 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Kuan Sian
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesActivityManageDBDAOSearchPFMCbyCustInputRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Performance by Customer 조회
	  * </pre>
	  */
	public SalesActivityManageDBDAOSearchPFMCbyCustInputRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sales_rep",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sales_office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.integration").append("\n"); 
		query.append("FileName : SalesActivityManageDBDAOSearchPFMCbyCustInputRSQL").append("\n"); 
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
		query.append("WITH SAM09 AS(" ).append("\n"); 
		query.append("	SELECT A.BKG_NO" ).append("\n"); 
		query.append("      			  ,TO_CHAR(A.BKG_CRE_DT, 'YYYY-MM-DD') BKG_CRE_DT" ).append("\n"); 
		query.append("      			  ,E.CUST_CNT_CD||TRIM(TO_CHAR(E.CUST_SEQ,'099999')) CUST_CD" ).append("\n"); 
		query.append("     			  ,A.CMDT_CD" ).append("\n"); 
		query.append("    			  ,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("     			  ,A.POR_CD" ).append("\n"); 
		query.append("   			      ,A.POL_CD" ).append("\n"); 
		query.append("   			      ,A.POD_CD" ).append("\n"); 
		query.append("     			  ,A.DEL_CD" ).append("\n"); 
		query.append("    			  ,A.BKG_STS_CD" ).append("\n"); 
		query.append("    			  ,A.OB_SREP_CD SREP_CD" ).append("\n"); 
		query.append("     			  ,C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     			  ,C.OP_CNTR_QTY" ).append("\n"); 
		query.append("	  			" ).append("\n"); 
		query.append("			  FROM BKG_BOOKING A" ).append("\n"); 
		query.append("   				  ,MDM_CUSTOMER B" ).append("\n"); 
		query.append("    			  ,BKG_QUANTITY C" ).append("\n"); 
		query.append("    			  ,MDM_SLS_REP D" ).append("\n"); 
		query.append("   				  ,BKG_CUSTOMER E" ).append("\n"); 
		query.append("			WHERE 1=1" ).append("\n"); 
		query.append("			AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("			AND D.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("			AND B.SREP_CD = D.SREP_CD" ).append("\n"); 
		query.append("			AND B.CUST_CNT_CD = E.CUST_CNT_CD" ).append("\n"); 
		query.append("			AND B.CUST_SEQ = E.CUST_SEQ" ).append("\n"); 
		query.append("			AND A.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if(${sales_office} != '')" ).append("\n"); 
		query.append("			AND D.OFC_CD = @[sales_office]" ).append("\n"); 
		query.append("			#end   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if(${from_date} != '' && ${to_date} != '') " ).append("\n"); 
		query.append("			AND A.BKG_CRE_DT BETWEEN TO_DATE(@[from_date],'YYYY/MM/DD') AND TO_DATE(@[to_date],'YYYY/MM/DD')" ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if(${sales_rep} != '')" ).append("\n"); 
		query.append("			AND B.SREP_CD = @[sales_rep]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if(${cust_cd} != '')" ).append("\n"); 
		query.append("			AND B.CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("			AND B.CUST_SEQ = SUBSTR(@[cust_cd],3,6)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("      ,BKG_CRE_DT" ).append("\n"); 
		query.append("      ,CUST_CD" ).append("\n"); 
		query.append("      ,CMDT_CD" ).append("\n"); 
		query.append("      ,VVD" ).append("\n"); 
		query.append("      ,POR_CD" ).append("\n"); 
		query.append("      ,POL_CD" ).append("\n"); 
		query.append("      ,POD_CD" ).append("\n"); 
		query.append("      ,DEL_CD" ).append("\n"); 
		query.append("      ,BKG_STS_CD" ).append("\n"); 
		query.append("      ,SREP_CD" ).append("\n"); 
		query.append("      ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,OP_CNTR_QTY" ).append("\n"); 
		query.append("	  ,TOTAL_BKG" ).append("\n"); 
		query.append("  FROM SAM09, (SELECT COUNT(DISTINCT BKG_NO) TOTAL_BKG" ).append("\n"); 
		query.append(" 			     FROM SAM09)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}
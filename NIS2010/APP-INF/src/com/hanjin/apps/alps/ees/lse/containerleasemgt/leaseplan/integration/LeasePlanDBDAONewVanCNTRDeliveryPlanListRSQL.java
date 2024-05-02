/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LeasePlanDBDAONewVanCNTRDeliveryPlanListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.02
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.12.02 남궁진호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author NamKoong JinHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeasePlanDBDAONewVanCNTRDeliveryPlanListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 신조장비(OW/LP/OL) 계획목록을 조회한다.
	  * 2010.12.01 박명신 [CHM-201007443-01] REF_NO 항목 추가
	  * </pre>
	  */
	public LeasePlanDBDAONewVanCNTRDeliveryPlanListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.integration").append("\n"); 
		query.append("FileName : LeasePlanDBDAONewVanCNTRDeliveryPlanListRSQL").append("\n"); 
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
		query.append("SELECT  SEQ_NO, PLN_YRMON, PLN_YR, PLN_MON, PLN_SEQ," ).append("\n"); 
		query.append("        NEW_VAN_YRMON, MFT_VNDR_SEQ, DEL_CD, CNTR_TPSZ_CD," ).append("\n"); 
		query.append("    	AGMT_CTY_CD, AGMT_SEQ, REF_NO,LSTM_CD, DE_QTY," ).append("\n"); 
		query.append("    	CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT, PLN_RMK" ).append("\n"); 
		query.append("FROM   (SELECT	ROW_NUMBER() OVER (ORDER BY A.PLN_YRMON, A.AGMT_CTY_CD, A.AGMT_SEQ, B.REF_NO,A.LSTM_CD,  " ).append("\n"); 
		query.append("                	A.MFT_VNDR_SEQ, A.DEL_CD, A.CNTR_TPSZ_CD, A.NEW_VAN_YRMON, A.DE_QTY DESC) AS SEQ_NO," ).append("\n"); 
		query.append("            	A.PLN_YRMON," ).append("\n"); 
		query.append("            	TO_CHAR(TO_DATE(A.PLN_YRMON,'YYYYMM'), 'YYYY') AS PLN_YR," ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(A.PLN_YRMON,'YYYYMM'), 'MM') AS PLN_MON," ).append("\n"); 
		query.append("            	A.PLN_SEQ, A.NEW_VAN_YRMON, A.MFT_VNDR_SEQ, A.DEL_CD," ).append("\n"); 
		query.append("            	A.CNTR_TPSZ_CD, A.AGMT_CTY_CD, A.AGMT_SEQ,B.REF_NO, A.LSTM_CD, A.DE_QTY," ).append("\n"); 
		query.append("            	A.CRE_USR_ID, A.CRE_DT, A.UPD_USR_ID, A.UPD_DT, A.PLN_RMK" ).append("\n"); 
		query.append("    	FROM    LSE_NEW_VAN_DE_PLN A," ).append("\n"); 
		query.append("			    LSE_AGREEMENT B" ).append("\n"); 
		query.append("    	WHERE	1 = 1" ).append("\n"); 
		query.append("		 AND A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("         AND A.AGMT_SEQ =B.AGMT_SEQ" ).append("\n"); 
		query.append("	#if (${pln_yrmon} != '') " ).append("\n"); 
		query.append("		AND		A.PLN_YRMON = @[pln_yrmon]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		)    " ).append("\n"); 
		query.append("#if (${startno} != '') " ).append("\n"); 
		query.append("WHERE 	SEQ_NO BETWEEN @[startno] AND @[endno]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
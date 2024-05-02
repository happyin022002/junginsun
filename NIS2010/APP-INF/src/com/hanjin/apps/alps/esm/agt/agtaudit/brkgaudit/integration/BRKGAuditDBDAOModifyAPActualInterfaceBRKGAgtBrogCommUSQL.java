/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BRKGAuditDBDAOModifyAPActualInterfaceBRKGAgtBrogCommUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.19 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BRKGAuditDBDAOModifyAPActualInterfaceBRKGAgtBrogCommUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AGT_BROG_COMM UPDATE
	  * </pre>
	  */
	public BRKGAuditDBDAOModifyAPActualInterfaceBRKGAgtBrogCommUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ap_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fwdr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.integration").append("\n"); 
		query.append("FileName : BRKGAuditDBDAOModifyAPActualInterfaceBRKGAgtBrogCommUSQL").append("\n"); 
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
		query.append("UPDATE AGT_BROG_COMM" ).append("\n"); 
		query.append("SET CSR_NO = @[csr_no]  --//:CSRNO" ).append("\n"); 
		query.append("WHERE (BKG_NO, BROG_SEQ) IN (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.BKG_NO," ).append("\n"); 
		query.append("A.BROG_SEQ" ).append("\n"); 
		query.append("FROM AGT_BROG_COMM A, AGT_COMM_BKG_INFO B" ).append("\n"); 
		query.append("WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND B.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("AND A.CRE_USR_ID != 'COST'" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = @[vndr_seq]  --//:VNDRSEQ" ).append("\n"); 
		query.append("AND A.FRT_FWRD_CNT_CD || TO_CHAR (A.FRT_FWRD_SEQ, 'FM000000') = @[fwdr]  --//:FWDR" ).append("\n"); 
		query.append("AND A.AP_OFC_CD = @[ap_ofc_cd]  --//:APOFC" ).append("\n"); 
		query.append("--// 2008.10.06 권상준 SQL 튜닝" ).append("\n"); 
		query.append("#if (${sts_option} == '1')" ).append("\n"); 
		query.append("AND A.VSL_DEP_DT BETWEEN TO_DATE(REPLACE(@[search_dt_fr], '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(@[search_dt_to], '-'), 'YYYYMMDD')+0.999999--//:STSOPT,:FRDATE,:TODATE" ).append("\n"); 
		query.append("#elseif (${sts_option} == '0')" ).append("\n"); 
		query.append("AND A.CRE_DT BETWEEN TO_DATE(REPLACE(@[search_dt_fr], '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(@[search_dt_to], '-'), 'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.COMM_PROC_STS_CD IN ('CS', 'CM', 'CA')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
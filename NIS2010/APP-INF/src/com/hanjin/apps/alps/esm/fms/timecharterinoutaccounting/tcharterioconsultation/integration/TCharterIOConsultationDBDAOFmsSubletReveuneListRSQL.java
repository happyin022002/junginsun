/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOFmsSubletReveuneListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOFmsSubletReveuneListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sublet Revenue Inquiry Master Select
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOFmsSubletReveuneListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOFmsSubletReveuneListRSQL").append("\n"); 
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
		query.append("SELECT B.TO_INV_NO," ).append("\n"); 
		query.append("(B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD || B.REV_DIR_CD) VVD_CD," ).append("\n"); 
		query.append("B.CSR_CURR_CD," ).append("\n"); 
		query.append("B.CSR_AMT," ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("DECODE(SUM(CASE WHEN ACCT_CD IN ('110811','110711') THEN B.CSR_AMT ELSE 0 END),0,NULL," ).append("\n"); 
		query.append("SUM(CASE WHEN ACCT_CD IN ('110811','110711') THEN B.CSR_AMT ELSE 0 END)) CSR_AMT," ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("B.CSR_DESC" ).append("\n"); 
		query.append("FROM FMS_CONSULTATION A," ).append("\n"); 
		query.append("FMS_CSUL_SLP B" ).append("\n"); 
		query.append("WHERE A.SLP_TP_CD = B.SLP_TP_CD" ).append("\n"); 
		query.append("AND A.SLP_FUNC_CD = B.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND A.SLP_OFC_CD = B.SLP_OFC_CD" ).append("\n"); 
		query.append("AND A.SLP_ISS_DT = B.SLP_ISS_DT" ).append("\n"); 
		query.append("AND A.SLP_SER_NO = B.SLP_SER_NO" ).append("\n"); 
		query.append("AND A.CXL_FLG = 'N'" ).append("\n"); 
		query.append("AND A.SLP_TP_CD = '20'" ).append("\n"); 
		query.append("AND A.SLP_FUNC_CD = 'T'" ).append("\n"); 
		query.append("#if(${flet_ctrt_no} != '')" ).append("\n"); 
		query.append("AND A.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vvd_cd} != '')" ).append("\n"); 
		query.append("AND B.vsl_cd = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("AND B.skd_voy_no = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("AND B.skd_dir_cd = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("AND B.rev_dir_cd = SUBSTR(@[vvd_cd],10,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${to_inv_no} != '')" ).append("\n"); 
		query.append("AND B.TO_INV_NO = @[to_inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND B.TO_INV_NO IS NOT NULL" ).append("\n"); 
		query.append("AND B.ACCT_CD IN ('110811','110711')" ).append("\n"); 
		query.append("--GROUP BY B.TO_INV_NO, (B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD || B.REV_DIR_CD), B.CSR_CURR_CD, B.CSR_DESC" ).append("\n"); 
		query.append("ORDER BY B.TO_INV_NO" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CanalTransitFeeEstimateDBDAOsearchInvoiceSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.08.14 김진일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Ihl
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CanalTransitFeeEstimateDBDAOsearchInvoiceSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchInvoiceSeq
	  * </pre>
	  */
	public CanalTransitFeeEstimateDBDAOsearchInvoiceSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnl_tz_bztp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.integration").append("\n"); 
		query.append("FileName : CanalTransitFeeEstimateDBDAOsearchInvoiceSeqRSQL").append("\n"); 
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
		query.append("SELECT   MAX (prefix) || MAX (mxno) invoice_no" ).append("\n"); 
		query.append("FROM   (SELECT   NULL prefix," ).append("\n"); 
		query.append("LTRIM(TO_CHAR (" ).append("\n"); 
		query.append("NVL (MAX (SUBSTR (INV_NO, LENGTH (INV_NO) - 1))," ).append("\n"); 
		query.append("0)" ).append("\n"); 
		query.append("+ 1," ).append("\n"); 
		query.append("'00'" ).append("\n"); 
		query.append("))" ).append("\n"); 
		query.append("mxno" ).append("\n"); 
		query.append("FROM   pso_charge T1," ).append("\n"); 
		query.append("(SELECT   DECODE (VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("NULL, ' '," ).append("\n"); 
		query.append("SUBSTR (VNDR_LGL_ENG_NM, 1, 1))" ).append("\n"); 
		query.append("|| '-'" ).append("\n"); 
		query.append("|| @[vvd]" ).append("\n"); 
		query.append("|| decode(@[cnl_tz_bztp_cd], 'E', '-ADV-', 'I', '-INV-')" ).append("\n"); 
		query.append("prefix" ).append("\n"); 
		query.append("FROM   mdm_vendor" ).append("\n"); 
		query.append("WHERE   vndr_seq = @[vndr_seq]) T2" ).append("\n"); 
		query.append("WHERE   T1.INV_NO LIKE T2.prefix || '%'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   DECODE (VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("NULL, ' '," ).append("\n"); 
		query.append("SUBSTR (VNDR_LGL_ENG_NM, 1, 1))" ).append("\n"); 
		query.append("|| '-'" ).append("\n"); 
		query.append("|| @[vvd]" ).append("\n"); 
		query.append("|| decode(@[cnl_tz_bztp_cd], 'E', '-ADV-', 'I', '-INV-')," ).append("\n"); 
		query.append("NULL" ).append("\n"); 
		query.append("FROM   mdm_vendor" ).append("\n"); 
		query.append("WHERE   vndr_seq = @[vndr_seq])" ).append("\n"); 

	}
}
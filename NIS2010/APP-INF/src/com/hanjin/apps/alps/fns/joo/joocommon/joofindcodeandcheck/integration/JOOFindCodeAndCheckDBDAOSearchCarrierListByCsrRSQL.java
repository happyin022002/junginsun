/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOSearchCarrierListByCsrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.15
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2016.07.15 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAOSearchCarrierListByCsrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 20160712 HongSeongPil 최초생성
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOSearchCarrierListByCsrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOSearchCarrierListByCsrRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT JO_CRR_CD CODE" ).append("\n"); 
		query.append("     , JO_CRR_CD NAME" ).append("\n"); 
		query.append("  FROM JOO_STL_CMB A" ).append("\n"); 
		query.append("WHERE EXISTS (" ).append("\n"); 
		query.append("       SELECT 'X'" ).append("\n"); 
		query.append("         FROM JOO_CSR B" ).append("\n"); 
		query.append("        WHERE A.SLP_TP_CD = B.SLP_TP_CD" ).append("\n"); 
		query.append("          AND A.SLP_FUNC_CD = B.SLP_FUNC_CD" ).append("\n"); 
		query.append("          AND A.SLP_OFC_CD = B.SLP_OFC_CD" ).append("\n"); 
		query.append("          AND A.SLP_ISS_DT = B.SLP_ISS_DT" ).append("\n"); 
		query.append("          AND A.SLP_SER_NO = B.SLP_SER_NO" ).append("\n"); 
		query.append("          AND B.CXL_FLG     = 'N'" ).append("\n"); 
		query.append("#if (${csr_no} != '')" ).append("\n"); 
		query.append("          AND B.SLP_TP_CD   = SUBSTR(@[csr_no], 1,2)" ).append("\n"); 
		query.append("          AND B.SLP_FUNC_CD = SUBSTR(@[csr_no], 3,1)" ).append("\n"); 
		query.append("          AND B.SLP_OFC_CD  = DECODE(LENGTH(@[csr_no]),20,SUBSTR(@[csr_no],4,6),SUBSTR(@[csr_no],4,5))" ).append("\n"); 
		query.append("          AND B.SLP_ISS_DT  = TO_CHAR(TO_DATE(DECODE(LENGTH(@[csr_no]),20,SUBSTR(@[csr_no],10,6),SUBSTR(@[csr_no],9,6)),'RRMMDD'),'YYYYMMDD')" ).append("\n"); 
		query.append("          AND B.SLP_SER_NO  = DECODE(LENGTH(@[csr_no]),20,SUBSTR(@[csr_no],16),SUBSTR(@[csr_no],15))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${gubun} == '0')" ).append("\n"); 
		query.append("          AND B.SLP_ISS_DT  >= REPLACE(@[fr_dt],'-','')" ).append("\n"); 
		query.append("          AND B.SLP_ISS_DT  <= REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("	#elseif(${gubun} == '1')" ).append("\n"); 
		query.append("          AND B.EFF_DT  >= TO_DATE(REPLACE(@[fr_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("          AND B.EFF_DT  <= TO_DATE(REPLACE(@[to_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${slp_ofc_cd} != '')" ).append("\n"); 
		query.append("          AND (B.SLP_OFC_CD = @[slp_ofc_cd] OR B.SLP_ISS_OFC_CD  = @[slp_ofc_cd])" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY A.JO_CRR_CD" ).append("\n"); 

	}
}
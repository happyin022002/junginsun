/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CustMainDBDAOCustomerListByNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.30
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustMainDBDAOCustomerListByNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Dup check
	  * </pre>
	  */
	public CustMainDBDAOCustomerListByNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sam.custmanage.custmain.integration").append("\n"); 
		query.append("FileName : CustMainDBDAOCustomerListByNameRSQL").append("\n"); 
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
		query.append("SELECT C.CUST_CNT_CD||LPAD(C.CUST_SEQ, 6,'0') AS CUST_CNT_CD" ).append("\n"); 
		query.append("     , C.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("     ,(SELECT D.BZET_ADDR FROM MDM_CUST_ADDR D" ).append("\n"); 
		query.append("       WHERE D.CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("       AND   D.CUST_SEQ    = C.CUST_SEQ " ).append("\n"); 
		query.append("       AND   D.ADDR_TP_CD = 1" ).append("\n"); 
		query.append("       AND   D.PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("       AND   ROWNUM = 1 ) AS BZET_ADDR" ).append("\n"); 
		query.append("     , C.LOC_CD " ).append("\n"); 
		query.append("     , C.CUST_RGST_NO" ).append("\n"); 
		query.append("     , C.OFC_CD" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER C" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("AND C.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${match_rule} == 'I')" ).append("\n"); 
		query.append("AND  UPPER(REPLACE(TRIM(C.CUST_LGL_ENG_NM),' ','')) like '%'||UPPER(REPLACE(DECODE(instr(@[cust_nm], ' ',1,2), 0, TRIM(@[cust_nm]), TRIM(SUBSTR(@[cust_nm], 1, instr(@[cust_nm], ' ',1,2)))),' ',''))||'%'" ).append("\n"); 
		query.append("#elseif (${match_rule} == 'E')" ).append("\n"); 
		query.append("AND  UPPER(REPLACE(TRIM(C.CUST_LGL_ENG_NM),' ','')) = UPPER(REPLACE(TRIM(@[cust_nm]),' ',''))" ).append("\n"); 
		query.append("#elseif (${match_rule} == 'S')" ).append("\n"); 
		query.append("AND  UPPER(REPLACE(TRIM(C.CUST_LGL_ENG_NM),' ','')) like UPPER(REPLACE(DECODE(instr(@[cust_nm], ' ',1,2), 0, TRIM(@[cust_nm]), TRIM(SUBSTR(@[cust_nm], 1, instr(@[cust_nm], ' ',1,2)))),' ',''))||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("AND  C.LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND C.DELT_FLG <>'Y'" ).append("\n"); 
		query.append("AND ROWNUM < 5001" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTCommDBDAODeductionTotalVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.04
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.04.04 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTCommDBDAODeductionTotalVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_AGT_0012 화면의 Total 조회
	  * </pre>
	  */
	public AGTCommDBDAODeductionTotalVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTCommDBDAODeductionTotalVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("CHG_AMT" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'1' SEQ," ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("SUM(ROUND(CHG_AMT,2)) AS CHG_AMT" ).append("\n"); 
		query.append("FROM BKG_CHG_RT" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND FRT_INCL_XCLD_DIV_CD =	'N'" ).append("\n"); 
		query.append("GROUP BY CURR_CD" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'2' SEQ," ).append("\n"); 
		query.append("'Gross Rev(USD)' AS CURR," ).append("\n"); 
		query.append("ROUND(SUM(A.CHG_AMT/DECODE(A.CURR_CD,'USD',1,NVL(B.USD_LOCL_XCH_RT,0))),2)  AS CHG_AMT_RT" ).append("\n"); 
		query.append("FROM 	BKG_CHG_RT A," ).append("\n"); 
		query.append("GL_MON_XCH_RT B," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DECODE(SIGN(TO_NUMBER(NVL(MAX(SUBSTR(SAIL_ARR_DT,1,6)),TO_CHAR(SYSDATE,'YYYYMM')))-TO_NUMBER(TO_CHAR(SYSDATE,'YYYYMM'))),1,TO_CHAR(ADD_MONTHS(TO_DATE(MAX(SAIL_ARR_DT),'YYYYMMDD'),-1),'YYYYMM'), NVL(MAX(SUBSTR(SAIL_ARR_DT,1,6)),TO_CHAR(SYSDATE,'YYYYMM'))) AS SA_DT" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND AC_SEQ = @[ac_seq]" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("WHERE A.BKG_NO			= @[bkg_no]" ).append("\n"); 
		query.append("AND A.FRT_INCL_XCLD_DIV_CD	= 'N'" ).append("\n"); 
		query.append("AND A.CURR_CD		= B.CURR_CD" ).append("\n"); 
		query.append("AND B.ACCT_XCH_RT_YRMON = C.SA_DT" ).append("\n"); 
		query.append("AND B.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("ORDER BY SEQ ASC" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
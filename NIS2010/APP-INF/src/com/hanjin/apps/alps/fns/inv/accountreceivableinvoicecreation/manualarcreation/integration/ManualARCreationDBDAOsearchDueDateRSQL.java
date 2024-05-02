/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ManualARCreationDBDAOsearchDueDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualARCreationDBDAOsearchDueDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Due Date 가져오기
	  * </pre>
	  */
	public ManualARCreationDBDAOsearchDueDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sa_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration").append("\n"); 
		query.append("FileName : ManualARCreationDBDAOsearchDueDateRSQL").append("\n"); 
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
		query.append("#if (${cust_cnt_cd} == '' || ${cust_seq} == '')" ).append("\n"); 
		query.append("SELECT  DECODE(@[bnd], 'I'," ).append("\n"); 
		query.append("               TO_CHAR(TO_DATE(@[sa_dt], 'YYYY-MM-DD') + NVL(IB_CR_TERM_DYS,0), 'YYYY-MM-DD')," ).append("\n"); 
		query.append("               TO_CHAR(TO_DATE(@[sa_dt], 'YYYY-MM-DD') + NVL(OB_CR_TERM_DYS,0), 'YYYY-MM-DD')) DUE_DT" ).append("\n"); 
		query.append("FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE  OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND    DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("SELECT  " ).append("\n"); 
		query.append("        DECODE(A.CR_FLG, 'Y'," ).append("\n"); 
		query.append("              DECODE(@[bnd], 'I'," ).append("\n"); 
		query.append("                     TO_CHAR(TO_DATE(@[sa_dt], 'YYYY-MM-DD') + DECODE(NVL(A.IB_CR_TERM_DYS,0),0, NVL(B.IB_CR_TERM_DYS,0),NVL(A.IB_CR_TERM_DYS,0))," ).append("\n"); 
		query.append("                             'YYYY-MM-DD')," ).append("\n"); 
		query.append("                     TO_CHAR(TO_DATE(@[sa_dt], 'YYYY-MM-DD') + DECODE(NVL(A.OB_CR_TERM_DYS,0),0, NVL(B.OB_CR_TERM_DYS,0),NVL(A.OB_CR_TERM_DYS,0))," ).append("\n"); 
		query.append("                             'YYYY-MM-DD'))," ).append("\n"); 
		query.append("              DECODE(@[bnd], 'I'," ).append("\n"); 
		query.append("                     TO_CHAR(TO_DATE(@[sa_dt], 'YYYY-MM-DD') + NVL(B.IB_CR_TERM_DYS,0)," ).append("\n"); 
		query.append("                             'YYYY-MM-DD')," ).append("\n"); 
		query.append("                     TO_CHAR(TO_DATE(@[sa_dt], 'YYYY-MM-DD') + NVL(B.OB_CR_TERM_DYS,0)," ).append("\n"); 
		query.append("                             'YYYY-MM-DD'))" ).append("\n"); 
		query.append("        ) DUE_DT" ).append("\n"); 
		query.append("FROM   MDM_CR_CUST A, MDM_ORGANIZATION B, MDM_CUSTOMER C" ).append("\n"); 
		query.append("WHERE  C.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND    C.CUST_SEQ = CASE WHEN REGEXP_INSTR(@[cust_seq], '[[:alpha:]]', 1, 1) = 0 THEN" ).append("\n"); 
		query.append("                         TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                         -999999" ).append("\n"); 
		query.append("                    END " ).append("\n"); 
		query.append("AND    REPLACE(@[sa_dt],'-','') BETWEEN A.CR_ST_DT(+) AND A.CR_END_DT(+)" ).append("\n"); 
		query.append("AND    C.CUST_CNT_CD = A.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND    C.CUST_SEQ = A.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND    B.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
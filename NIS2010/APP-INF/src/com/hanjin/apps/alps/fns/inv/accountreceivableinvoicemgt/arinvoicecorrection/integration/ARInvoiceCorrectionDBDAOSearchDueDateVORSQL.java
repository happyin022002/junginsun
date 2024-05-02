/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOSearchDueDateVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.11.20 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOSearchDueDateVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ARInvoiceCorrectionDBDAO::searchDueDate ( dueInputVo )
	  * return DueDateVO
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOSearchDueDateVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOSearchDueDateVORSQL").append("\n"); 
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
		query.append("SELECT DECODE(DECODE(@[bnd], 'I', NVL(A.IB_CR_TERM_DYS,0),  NVL(A.OB_CR_TERM_DYS,0)),0,'N', NVL(A.CR_FLG,'N')) CR_FLG," ).append("\n"); 
		query.append("DECODE(A.CR_FLG, 'Y'," ).append("\n"); 
		query.append("DECODE(@[bnd], 'I'," ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(REPLACE(@[sa_dt],'-',''), 'YYYYMMDD') + DECODE(NVL(A.IB_CR_TERM_DYS,0),0, NVL(B.IB_CR_TERM_DYS,0),NVL(A.IB_CR_TERM_DYS,0))," ).append("\n"); 
		query.append("'YYYYMMDD')," ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(REPLACE(@[sa_dt],'-',''), 'YYYYMMDD') + DECODE(NVL(A.OB_CR_TERM_DYS,0),0, NVL(B.OB_CR_TERM_DYS,0),NVL(A.OB_CR_TERM_DYS,0))," ).append("\n"); 
		query.append("'YYYYMMDD'))," ).append("\n"); 
		query.append("DECODE(@[bnd], 'I'," ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(REPLACE(@[sa_dt],'-',''), 'YYYYMMDD') + NVL(B.IB_CR_TERM_DYS,0)," ).append("\n"); 
		query.append("'yyyymmdd')," ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(REPLACE(@[sa_dt],'-',''), 'YYYYMMDD') + NVL(B.OB_CR_TERM_DYS,0)," ).append("\n"); 
		query.append("'yyyymmdd'))) DUE_DATE ," ).append("\n"); 
		query.append("DECODE(@[bnd], 'I',  DECODE(NVL(A.IB_CR_TERM_DYS,0),0,NVL(B.IB_CR_TERM_DYS,0),NVL(A.IB_CR_TERM_DYS,0)), DECODE(NVL(A.OB_CR_TERM_DYS,0),0, NVL(B.OB_CR_TERM_DYS,0), NVL(A.OB_CR_TERM_DYS,0))) CR_TERM_DYS" ).append("\n"); 
		query.append("FROM   MDM_CR_CUST A, MDM_ORGANIZATION B, MDM_CUSTOMER C" ).append("\n"); 
		query.append("WHERE  C.CUST_CNT_CD =  @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND    C.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("AND    REPLACE(@[sa_dt],'-','') BETWEEN A.CR_ST_DT(+) AND A.CR_END_DT(+)" ).append("\n"); 
		query.append("AND    C.CUST_CNT_CD = A.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND    C.CUST_SEQ = A.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND    B.OFC_CD = @[ofc_cd]" ).append("\n"); 

	}
}
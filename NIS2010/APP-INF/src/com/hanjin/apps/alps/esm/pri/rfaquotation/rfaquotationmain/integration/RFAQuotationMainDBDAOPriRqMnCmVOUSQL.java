/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAQuotationMainDBDAOPriRqMnCmVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.09
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.12.09 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAQuotationMainDBDAOPriRqMnCmVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public RFAQuotationMainDBDAOPriRqMnCmVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.integration").append("\n"); 
		query.append("FileName : RFAQuotationMainDBDAOPriRqMnCmVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_RQ_MN" ).append("\n"); 
		query.append("SET ESTM_CM_AMT = (" ).append("\n"); 
		query.append("SELECT SUM( CR.PRS_ESTM_LOD_QTY * DECODE(U.CNTR_SZ_CD,'2',CR.PRS_ESTM_RESPB_CMPB_AMT,CR.PRS_ESTM_RESPB_CMPB_AMT/2) )" ).append("\n"); 
		query.append("FROM PRI_RQ_RT_CMDT_ROUT CR" ).append("\n"); 
		query.append(", PRI_RAT_UT U" ).append("\n"); 
		query.append("WHERE CR.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND CR.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND CR.PRS_RAT_UT_CD = U.RAT_UT_CD(+)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE	QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND	QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}
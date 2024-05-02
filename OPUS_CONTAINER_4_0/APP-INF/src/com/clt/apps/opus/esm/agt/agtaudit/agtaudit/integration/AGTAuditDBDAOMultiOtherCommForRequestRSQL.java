/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDBDAOMultiOtherCommForRequestRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.19 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOMultiOtherCommForRequestRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiOtherCommForRequest
	  * </pre>
	  */
	public AGTAuditDBDAOMultiOtherCommForRequestRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_stnd_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOMultiOtherCommForRequestRSQL").append("\n"); 
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
		query.append("B.BKG_NO," ).append("\n"); 
		query.append("A.OFC_CD," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("CASE A.VVD_COM_LVL" ).append("\n"); 
		query.append("WHEN '1'" ).append("\n"); 
		query.append("THEN B.VVD_LVL_FLG1" ).append("\n"); 
		query.append("WHEN '2'" ).append("\n"); 
		query.append("THEN B.VVD_LVL_FLG2" ).append("\n"); 
		query.append("WHEN '3'" ).append("\n"); 
		query.append("THEN B.VVD_LVL_FLG3" ).append("\n"); 
		query.append("WHEN '4'" ).append("\n"); 
		query.append("THEN B.VVD_LVL_FLG4" ).append("\n"); 
		query.append("WHEN '5'" ).append("\n"); 
		query.append("THEN B.VVD_LVL_FLG5" ).append("\n"); 
		query.append("WHEN '6'" ).append("\n"); 
		query.append("THEN B.VVD_LVL_FLG6" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END AS VVD_CHK_YN" ).append("\n"); 
		query.append("FROM AR_MST_REV_VVD A," ).append("\n"); 
		query.append("MDM_ACCOUNT    B" ).append("\n"); 
		query.append("WHERE A.VSL_CD      = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO  = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD  = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND B.ACCT_CD     = @[comm_stnd_cost_cd]" ).append("\n"); 
		query.append(") AS VVD_CHK_YN" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("SUBSTR(@[ofc_cd],0,3)" ).append("\n"); 
		query.append("|| SUBSTR(REPLACE(@[comm_yrmon],'-',''),3,4)" ).append("\n"); 
		query.append("|| TO_CHAR(NVL(TO_NUMBER(SUBSTR(MAX(BKG_NO),8))+1,1),'FM0000') BKG_NO" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM" ).append("\n"); 
		query.append("WHERE BKG_NO LIKE SUBSTR(@[ofc_cd],0,3)||SUBSTR(REPLACE(@[comm_yrmon],'-',''),3,4)||'%'" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}
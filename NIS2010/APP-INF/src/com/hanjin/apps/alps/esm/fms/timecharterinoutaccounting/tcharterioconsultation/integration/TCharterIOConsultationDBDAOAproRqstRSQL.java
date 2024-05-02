/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOAproRqstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.01 
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

public class TCharterIOConsultationDBDAOAproRqstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOAproRqstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOAproRqstRSQL").append("\n"); 
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
		query.append("    A.APRO_RQST_NO," ).append("\n"); 
		query.append("    B.CSR_NO," ).append("\n"); 
		query.append("    C.APRO_RQST_SEQ," ).append("\n"); 
		query.append("    A.APSTS_CD," ).append("\n"); 
		query.append("    NVL(C.APSTS_CD, 'P') AS P_APSTS_CD," ).append("\n"); 
		query.append("    CASE WHEN C.APRO_RQST_SEQ = (" ).append("\n"); 
		query.append("                   SELECT /*+INDEX_DESC(X XPKCOM_APRO_RQST_ROUT)*/" ).append("\n"); 
		query.append("                          X.APRO_RQST_SEQ" ).append("\n"); 
		query.append("                   FROM   COM_APRO_RQST_ROUT X" ).append("\n"); 
		query.append("                   WHERE  X.APRO_RQST_NO = C.APRO_RQST_NO" ).append("\n"); 
		query.append("                   AND    X.DELT_FLG     = 'N'" ).append("\n"); 
		query.append("                   AND    ROWNUM = 1)" ).append("\n"); 
		query.append("         THEN 'Y' ELSE 'N'" ).append("\n"); 
		query.append("    END AS LST_APRO_FLG" ).append("\n"); 
		query.append("FROM COM_APRO_RQST_HDR  A," ).append("\n"); 
		query.append("    COM_APRO_CSR_DTL   B," ).append("\n"); 
		query.append("    COM_APRO_RQST_ROUT C" ).append("\n"); 
		query.append("WHERE NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND NVL(B.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND NVL(C.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND A.SUB_SYS_CD         = 'FMS'" ).append("\n"); 
		query.append("AND NVL(A.APSTS_CD,'P')  = 'P'" ).append("\n"); 
		query.append("AND NVL(C.APSTS_CD,'P')  = 'P'" ).append("\n"); 
		query.append("AND A.APRO_RQST_NO  = B.APRO_RQST_NO" ).append("\n"); 
		query.append("AND A.APRO_RQST_NO  = C.APRO_RQST_NO" ).append("\n"); 
		query.append("AND A.CRNT_APRO_SEQ = C.APRO_RQST_SEQ" ).append("\n"); 
		query.append("AND C.APRO_USR_ID   = @[usr_id]" ).append("\n"); 
		query.append("AND B.CSR_NO        = @[csr_no]" ).append("\n"); 

	}
}
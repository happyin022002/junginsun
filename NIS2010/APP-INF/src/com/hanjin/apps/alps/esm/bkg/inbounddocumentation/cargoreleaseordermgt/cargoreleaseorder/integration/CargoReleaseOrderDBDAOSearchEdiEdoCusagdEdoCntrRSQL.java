/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchEdiEdoCusagdEdoCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchEdiEdoCusagdEdoCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDO 요청으로접수된 CONTAINER 정보를 조회한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchEdiEdoCusagdEdoCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchEdiEdoCusagdEdoCntrRSQL").append("\n"); 
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
		query.append("SELECT '{E_CNTR'                        || CHR(10)" ).append("\n"); 
		query.append("      ||'CNTR_NO:'      || CNTR_NO      || CHR(10)" ).append("\n"); 
		query.append("      ||'CNTRTS_CD:'    || CNTR_TPSZ_CD || CHR(10)" ).append("\n"); 
		query.append("      ||'}E_CNTR'                       || CHR(10)  AS EDI_CUSAGD_CNTR" ).append("\n"); 
		query.append("  FROM BKG_EDO_CNTR  A" ).append("\n"); 
		query.append("     , BKG_EDO_MST   B" ).append("\n"); 
		query.append("     ,( SELECT @[rqst_no]                 AS EDO_RQST_NO" ).append("\n"); 
		query.append("            ,nvl(Max(EDO_RQST_SEQ), 1)    AS EDO_RQST_SEQ" ).append("\n"); 
		query.append("       FROM BKG_EDO_MST" ).append("\n"); 
		query.append("       WHERE EDO_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("         AND EDO_TP_CD   = @[edo_tp_cd]" ).append("\n"); 
		query.append("     ) C" ).append("\n"); 
		query.append(" WHERE A.EDO_RQST_NO  = C.EDO_RQST_NO" ).append("\n"); 
		query.append("   AND A.EDO_RQST_SEQ = C.EDO_RQST_SEQ" ).append("\n"); 
		query.append("   AND B.EDO_RQST_NO  = C.EDO_RQST_NO" ).append("\n"); 
		query.append("   AND B.EDO_RQST_SEQ = C.EDO_RQST_SEQ" ).append("\n"); 

	}
}
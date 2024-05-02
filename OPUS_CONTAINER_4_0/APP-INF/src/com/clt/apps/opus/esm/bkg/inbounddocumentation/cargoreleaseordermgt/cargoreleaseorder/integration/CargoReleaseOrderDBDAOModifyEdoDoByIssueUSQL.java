/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOModifyEdoDoByIssueUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOModifyEdoDoByIssueUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI로  DO 발급신청 승인정보를 전송 한 후  관련 정보를 Update 한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOModifyEdoDoByIssueUSQL(){
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
		params.put("edo_iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOModifyEdoDoByIssueUSQL").append("\n"); 
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
		query.append("UPDATE BKG_EDO_DO" ).append("\n"); 
		query.append("SET EDO_ISS_OFC_CD  = @[edo_iss_ofc_cd]" ).append("\n"); 
		query.append("WHERE EDO_RQST_NO     = @[rqst_no]" ).append("\n"); 
		query.append("AND EDO_RQST_SEQ    = ( SELECT EDO_RQST_SEQ" ).append("\n"); 
		query.append("FROM BKG_EDO_MST" ).append("\n"); 
		query.append("WHERE EDO_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("AND EDO_TP_CD   = @[edo_tp_cd]" ).append("\n"); 
		query.append("AND VTY_FLG     = 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
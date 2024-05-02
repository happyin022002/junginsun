/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchEdiEdoCusagdEdoPtyTrspRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.04 
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

public class CargoReleaseOrderDBDAOSearchEdiEdoCusagdEdoPtyTrspRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DO발급요청서, 자가운송신청서, 보세운송요청동의서 관련 Party(업체정보)를 조회한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchEdiEdoCusagdEdoPtyTrspRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchEdiEdoCusagdEdoPtyTrspRSQL").append("\n"); 
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
		query.append("SELECT  '{E_PARTY'                               || CHR(10)" ).append("\n"); 
		query.append("     || 'EP_TP:'       || TRSP.EDO_PTY_CD        || CHR(10)" ).append("\n"); 
		query.append("     || 'EP_REG_CD:'   || TRSP.PTY_RGST_NO       || CHR(10)" ).append("\n"); 
		query.append("     || 'EP_C_NM:'     || ''                     || CHR(10)" ).append("\n"); 
		query.append("     || 'EP_REP_NM:'   || ''                     || CHR(10)" ).append("\n"); 
		query.append("     || 'EP_TEL_NO:'   || ''                     || CHR(10)" ).append("\n"); 
		query.append("     || 'EP_NM1:'      || TRSP.PTY_NM1           || CHR(10)" ).append("\n"); 
		query.append("     || 'EP_NM2:'      || TRSP.PTY_NM2           || CHR(10)" ).append("\n"); 
		query.append("     || 'EP_ADDR1:'    || TRSP.PTY_ADDR1         || CHR(10)" ).append("\n"); 
		query.append("     || 'EP_ADDR2:'    || TRSP.PTY_ADDR2         || CHR(10)" ).append("\n"); 
		query.append("     || 'EP_ADDR3:'    || TRSP.PTY_ADDR3         || CHR(10)" ).append("\n"); 
		query.append("     || '}E_PARTY'                               || CHR(10)" ).append("\n"); 
		query.append("      AS EDI_GENRES_PTY_TRSP" ).append("\n"); 
		query.append("FROM BKG_EDO_PTY_TRSP TRSP " ).append("\n"); 
		query.append("    ,( SELECT @[rqst_no]                 AS EDO_RQST_NO" ).append("\n"); 
		query.append("            ,nvl(Max(EDO_RQST_SEQ), 1)   AS EDO_RQST_SEQ" ).append("\n"); 
		query.append("       FROM BKG_EDO_MST" ).append("\n"); 
		query.append("       WHERE EDO_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("         AND EDO_TP_CD   = @[edo_tp_cd]" ).append("\n"); 
		query.append("     ) EDO" ).append("\n"); 
		query.append("WHERE TRSP.EDO_RQST_NO  = EDO.EDO_RQST_NO" ).append("\n"); 
		query.append("  AND TRSP.EDO_RQST_SEQ = EDO.EDO_RQST_SEQ" ).append("\n"); 

	}
}
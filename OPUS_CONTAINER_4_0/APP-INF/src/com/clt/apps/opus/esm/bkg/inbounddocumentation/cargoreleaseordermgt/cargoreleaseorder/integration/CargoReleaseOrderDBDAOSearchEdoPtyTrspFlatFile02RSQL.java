/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchEdoPtyTrspFlatFile02RSQL.java
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

public class CargoReleaseOrderDBDAOSearchEdoPtyTrspFlatFile02RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI 전송을 위한 수하주 정보를 조회한다
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchEdoPtyTrspFlatFile02RSQL(){
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
		params.put("edo_pty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchEdoPtyTrspFlatFile02RSQL").append("\n"); 
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
		query.append("SELECT 'EP_TP:'   || EDO_PTY_CD ||'\\n'" ).append("\n"); 
		query.append("|| 'EP_NM1:'  || PTY_NM1    ||'\\n'" ).append("\n"); 
		query.append("|| 'EP_NM2:'  || PTY_NM2    ||'\\n'" ).append("\n"); 
		query.append("|| 'EP_ADDR1:'|| PTY_ADDR1  ||'\\n'" ).append("\n"); 
		query.append("|| 'EP_ADDR2:'|| PTY_ADDR2  ||'\\n'" ).append("\n"); 
		query.append("|| 'EP_ADDR3:'|| PTY_ADDR3  ||'\\n'" ).append("\n"); 
		query.append("FROM BKG_EDO_PTY_TRSP A" ).append("\n"); 
		query.append(", BKG_EDO_MST      B" ).append("\n"); 
		query.append("WHERE A.EDO_RQST_NO  = B.EDO_RQST_NO" ).append("\n"); 
		query.append("AND A.EDO_RQST_SEQ = B.EDO_RQST_SEQ" ).append("\n"); 
		query.append("AND A.EDO_RQST_NO  = @[rqst_no]" ).append("\n"); 
		query.append("AND B.VTY_FLG      = 'Y'" ).append("\n"); 
		query.append("AND B.EDO_TP_CD    = @[edo_tp_cd]" ).append("\n"); 
		query.append("AND EDO_PTY_CD     = @[edo_pty_cd]" ).append("\n"); 

	}
}
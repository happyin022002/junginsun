/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchEdoMstFlatFile02RSQL.java
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

public class CargoReleaseOrderDBDAOSearchEdoMstFlatFile02RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * D/O 발급 시 Flat파일 생성을 위한 E-D/O 마스터 정보를 조회한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchEdoMstFlatFile02RSQL(){
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
		params.put("edo_rjct_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchEdoMstFlatFile02RSQL").append("\n"); 
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
		query.append("SELECT  'MSG_REQ_NO:'||EDO_RQST_NO||'\\n'" ).append("\n"); 
		query.append("|| 'MSG_REQ_FLAG:'||DECODE(EDO_ACK_CD,NULL, '9','35')||'\\n'" ).append("\n"); 
		query.append("|| 'MSG_TP_FLAG:'||EDO_TP_CD||'\\n'" ).append("\n"); 
		query.append("|| 'MSG_ACK_TP:'||'A'||'\\n'" ).append("\n"); 
		query.append("|| 'MSG_ACK_DT:'||TO_CHAR(EDO_RCT_DT, 'YYYYMMDDHH24MISS')||'\\n'" ).append("\n"); 
		query.append("|| 'MSG_R_REASON:'||@[edo_rjct_rsn]||'\\n'" ).append("\n"); 
		query.append("AS FLAT_FILE" ).append("\n"); 
		query.append("FROM BKG_EDO_MST" ).append("\n"); 
		query.append("WHERE VTY_FLG ='Y'" ).append("\n"); 
		query.append("AND EDO_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("AND EDO_TP_CD   = @[edo_tp_cd]" ).append("\n"); 

	}
}
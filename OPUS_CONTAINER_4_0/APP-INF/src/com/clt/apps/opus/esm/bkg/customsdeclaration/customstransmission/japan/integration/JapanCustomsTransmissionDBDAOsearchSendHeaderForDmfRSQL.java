/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JapanCustomsTransmissionDBDAOsearchSendHeaderForDmfRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanCustomsTransmissionDBDAOsearchSendHeaderForDmfRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSendHeaderForDmf
	  * </pre>
	  */
	public JapanCustomsTransmissionDBDAOsearchSendHeaderForDmfRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("send_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vessel_info",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.integration").append("\n"); 
		query.append("FileName : JapanCustomsTransmissionDBDAOsearchSendHeaderForDmfRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	'JANCUS'||RPAD(@[in_vvd_cd],9,' ')||RPAD(@[in_pod_cd],5,' ')||" ).append("\n"); 
		query.append("	RPAD(@[ofc_cd],6,' ')||RPAD(UPPER(@[usr_id]),10,' ')||" ).append("\n"); 
		query.append("	SUBSTR(LTRIM(TO_CHAR(BKG_CSTM_EDI_SEQ.NEXTVAL,'000009'),' '),2)||" ).append("\n"); 
		query.append("	TO_CHAR(TO_DATE(@[send_dt], 'YYYY-MM-DD HH24:MI:SS'), 'yyyymmddhh24miss')||" ).append("\n"); 
		query.append("	RPAD('DMF',5,' ')||'                    ' HEADER," ).append("\n"); 
		query.append("	'   '||RPAD('DMF',5,' ')||" ).append("\n"); 
		query.append("	RPAD(' ',21,' ')||" ).append("\n"); 
		query.append("	'     '||'Z26'||  -- USER" ).append("\n"); 
		query.append("	'3LQ2NZYK'||    -- PW" ).append("\n"); 
		query.append("	RPAD(' ',174,' ')||" ).append("\n"); 
		query.append("	RPAD(' ',26,' ')||" ).append("\n"); 
		query.append("	RPAD(' ',8,' ')||" ).append("\n"); 
		query.append("    UPPER(RPAD(@[usr_id],10,' '))||    --RPAD(' ',10,' ')||" ).append("\n"); 
		query.append("	RPAD(' ',100,' ')||" ).append("\n"); 
		query.append("	RPAD(' ',1,' ')||" ).append("\n"); 
		query.append("	'2'||" ).append("\n"); 
		query.append("	RPAD(' ',27,' ')||" ).append("\n"); 
		query.append("	LPAD((length(@[vessel_info]) + 400),6,'0') HEADER2" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	DUAL" ).append("\n"); 

	}
}
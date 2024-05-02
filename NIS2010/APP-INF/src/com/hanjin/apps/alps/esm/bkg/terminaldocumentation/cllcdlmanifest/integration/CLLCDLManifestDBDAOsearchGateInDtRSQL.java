/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchGateInDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.09.29 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEUN GMIN KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchGateInDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchGateInDt
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchGateInDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchGateInDtRSQL").append("\n"); 
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
		query.append("#if (${in_list_type} == 'L' )" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("nvl(ORG_YD_CD,' ') ORG_YD_CD," ).append("\n"); 
		query.append("to_char(CNMV_EVNT_DT,'YYYY-MM-DD HH24:MI:SS') CNMV_EVNT_DT" ).append("\n"); 
		query.append("FROM	CTM_MOVEMENT" ).append("\n"); 
		query.append("WHERE	CNTR_NO = @[in_cntr_no]" ).append("\n"); 
		query.append("AND	CNMV_YR = to_char(sysdate,'YYYY')" ).append("\n"); 
		query.append("AND	CNMV_SEQ	=	( 	SELECT	max(CNMV_SEQ)" ).append("\n"); 
		query.append("FROM	CTM_MOVEMENT" ).append("\n"); 
		query.append("WHERE	CNTR_NO = @[in_cntr_no]" ).append("\n"); 
		query.append("AND	MVMT_STS_CD = 'OC'" ).append("\n"); 
		query.append("AND	CNMV_YR = to_char(sysdate,'YYYY')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("nvl(DEST_YD_CD,NVL(ORG_YD_CD,' ')) ORG_YD_CD," ).append("\n"); 
		query.append("to_char(CNMV_EVNT_DT,'YYYY-MM-DD HH24:MI:SS') CNMV_EVNT_DT" ).append("\n"); 
		query.append("FROM	CTM_MOVEMENT" ).append("\n"); 
		query.append("WHERE	CNTR_NO = @[in_cntr_no]" ).append("\n"); 
		query.append("AND	CNMV_YR	= to_char(sysdate,'YYYY')" ).append("\n"); 
		query.append("AND	CNMV_SEQ	=	( 	SELECT	max(CNMV_SEQ)" ).append("\n"); 
		query.append("FROM	CTM_MOVEMENT" ).append("\n"); 
		query.append("WHERE	CNTR_NO = @[in_cntr_no]" ).append("\n"); 
		query.append("AND	MVMT_STS_CD = 'IC'" ).append("\n"); 
		query.append("AND	CNMV_YR = to_char(sysdate,'YYYY')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
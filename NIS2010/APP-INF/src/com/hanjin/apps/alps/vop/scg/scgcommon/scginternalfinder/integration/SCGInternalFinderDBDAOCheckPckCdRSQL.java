/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SCGInternalFinderDBDAOCheckPckCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.04
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.06.04 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jongkyu Weon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGInternalFinderDBDAOCheckPckCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckPckCd
	  * </pre>
	  */
	public SCGInternalFinderDBDAOCheckPckCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_pck_instr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.integration").append("\n"); 
		query.append("FileName : SCGInternalFinderDBDAOCheckPckCdRSQL").append("\n"); 
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
		query.append("	IMDG_PCK_INSTR_CD " ).append("\n"); 
		query.append(",	MAX(IMDG_PCK_INSTR_SEQ)+1 AS IMDG_PCK_INSTR_SEQ " ).append("\n"); 
		query.append(",	MAX(IMDG_PCK_INSTR_SEQ) AS PCK_CD_SEQ_MAX " ).append("\n"); 
		query.append(",	MIN(IMDG_PCK_INSTR_SEQ) AS PCK_CD_SEQ_MIN " ).append("\n"); 
		query.append(",	COUNT(IMDG_PCK_INSTR_SEQ) AS PCK_CD_SEQ_CNT" ).append("\n"); 
		query.append(",   SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM SCG_PCK_INSTR" ).append("\n"); 
		query.append("WHERE	IMDG_PCK_INSTR_CD = @[imdg_pck_instr_cd]" ).append("\n"); 
		query.append("GROUP BY IMDG_PCK_INSTR_CD" ).append("\n"); 

	}
}
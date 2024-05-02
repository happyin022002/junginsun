/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SCGExternalFinderDBDAOMdmCntrTpSzVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGExternalFinderDBDAOMdmCntrTpSzVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TPSZ 코드 목록 조회
	  * </pre>
	  */
	public SCGExternalFinderDBDAOMdmCntrTpSzVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.integration").append("\n"); 
		query.append("FileName : SCGExternalFinderDBDAOMdmCntrTpSzVORSQL").append("\n"); 
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
		query.append("	   CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , CNTR_SZ_CD" ).append("\n"); 
		query.append("     , CNTR_TP_CD" ).append("\n"); 
		query.append("     , CNTR_TPSZ_DESC" ).append("\n"); 
		query.append("     , CNTR_TPSZ_ISO_CD" ).append("\n"); 
		query.append(" FROM  MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '') " ).append("\n"); 
		query.append("   AND  CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--  #21391 관련 Half Height CNTR TP SZ 적용을 위한 DELF_FLG 조건 주석처리" ).append("\n"); 
		query.append("--  AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY RPT_DP_SEQ" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PRICommonDBDAOPrsBatchLogUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.08
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.04.08 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOPrsBatchLogUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Approval Office list
	  * </pre>
	  */
	public PRICommonDBDAOPrsBatchLogUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("para_info_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prs_bat_err_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prs_bat_err_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pgm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAOPrsBatchLogUSQL").append("\n"); 
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
		query.append("UPDATE	PRI_PRS_BAT" ).append("\n"); 
		query.append("   SET	PRS_BAT_ERR_VAL = @[prs_bat_err_val]," ).append("\n"); 
		query.append("   		PRS_BAT_ERR_DESC = @[prs_bat_err_desc]," ).append("\n"); 
		query.append("   		UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE	PGM_NO = @[pgm_no]" ).append("\n"); 
		query.append("   AND	PARA_INFO_CTNT = @[para_info_ctnt]" ).append("\n"); 
		query.append("   AND	PRS_BAT_SEQ	= ( SELECT MAX( PRS_BAT_SEQ ) FROM PRI_PRS_BAT WHERE  PGM_NO =  @[pgm_no] AND PARA_INFO_CTNT = @[para_info_ctnt] )" ).append("\n"); 
		query.append("    	" ).append("\n"); 

	}
}
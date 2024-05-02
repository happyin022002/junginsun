/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOSearchVolumeAccumulatedMethodRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.09.25 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalAgreementManageDBDAOSearchVolumeAccumulatedMethodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Volume Accumulate Method
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOSearchVolumeAccumulatedMethodRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("accm_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAOSearchVolumeAccumulatedMethodRSQL").append("\n"); 
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
		query.append("SELECT	LPAD(vndr_seq, 6, '0') VNDR_SEQ" ).append("\n"); 
		query.append(", accm_seq" ).append("\n"); 
		query.append(", ctrt_ofc_cd" ).append("\n"); 
		query.append(", accm_fm_dt" ).append("\n"); 
		query.append(", accm_to_dt" ).append("\n"); 
		query.append(", tml_accm_ut_cd" ).append("\n"); 
		query.append(", cre_usr_id" ).append("\n"); 
		query.append(", TO_CHAR(cre_dt, 'YYYYMMDDHH24MISS') CRE_DT" ).append("\n"); 
		query.append(", upd_usr_id" ).append("\n"); 
		query.append(", TO_CHAR(upd_dt, 'YYYYMMDDHH24MISS') UPD_DT" ).append("\n"); 
		query.append(", TO_CHAR(locl_cre_dt, 'YYYYMMDDHH24MISS') LOCL_CRE_DT" ).append("\n"); 
		query.append(", TO_CHAR(locl_upd_dt, 'YYYYMMDDHH24MISS') LOCL_UPD_DT" ).append("\n"); 
		query.append("FROM	TES_TML_SO_ACCM_MZD" ).append("\n"); 
		query.append("WHERE	1	= 1" ).append("\n"); 
		query.append("AND		vndr_seq	= TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("AND		accm_seq	= TO_NUMBER(@[accm_seq])" ).append("\n"); 

	}
}
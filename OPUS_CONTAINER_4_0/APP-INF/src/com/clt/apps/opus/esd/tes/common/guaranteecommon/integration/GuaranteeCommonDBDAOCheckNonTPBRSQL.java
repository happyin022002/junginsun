/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GuaranteeCommonDBDAOCheckNonTPBRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.12.01 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.common.guaranteecommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GuaranteeCommonDBDAOCheckNonTPBRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NON TPB 확인
	  * </pre>
	  */
	public GuaranteeCommonDBDAOCheckNonTPBRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gnte_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.common.guaranteecommon.integration ").append("\n"); 
		query.append("FileName : GuaranteeCommonDBDAOCheckNonTPBRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("GNTE_NO" ).append("\n"); 
		query.append(", TML_GNTE_CNTR_LIST_SEQ" ).append("\n"); 
		query.append(", CNTR_NO" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", BKG_NO" ).append("\n"); 
		query.append(", BL_NO" ).append("\n"); 
		query.append(", VVD_CD" ).append("\n"); 
		query.append(", SC_NO" ).append("\n"); 
		query.append(", FM_DT" ).append("\n"); 
		query.append(", TO_DT" ).append("\n"); 
		query.append(", GNTE_AMT" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", GNTE_PROC_TP_CD" ).append("\n"); 
		query.append(", IRR_NO" ).append("\n"); 
		query.append(", TML_IF_SEQ" ).append("\n"); 
		query.append(", TML_IF_OFC_CD" ).append("\n"); 
		query.append("FROM    TES_GNTE_CNTR_LIST" ).append("\n"); 
		query.append("WHERE   1   = 1" ).append("\n"); 
		query.append("AND     GNTE_NO = @[gnte_no]" ).append("\n"); 

	}
}
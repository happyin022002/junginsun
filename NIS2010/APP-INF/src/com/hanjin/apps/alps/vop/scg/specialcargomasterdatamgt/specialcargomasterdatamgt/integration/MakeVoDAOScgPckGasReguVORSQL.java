/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MakeVoDAOScgPckGasReguVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.05
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.06.05 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jongkyu Weon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MakeVoDAOScgPckGasReguVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public MakeVoDAOScgPckGasReguVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : MakeVoDAOScgPckGasReguVORSQL").append("\n"); 
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
		query.append(" '' AS GAS_TP_CD                   " ).append("\n"); 
		query.append(",'' AS IMDG_PCK_INSTR_CD           " ).append("\n"); 
		query.append(",'' AS IMDG_PCK_INSTR_SEQ          " ).append("\n"); 
		query.append(",'' AS IMDG_UN_NO                  " ).append("\n"); 
		query.append(",'' AS CLND_BDL_CHK_FLG            " ).append("\n"); 
		query.append(",'' AS CLND_CHK_FLG" ).append("\n"); 
		query.append(",'' AS GAS_FILL_RTO                " ).append("\n"); 
		query.append(",'' AS GAS_SPCL_PCK_PROVI_N1ST_CTNT" ).append("\n"); 
		query.append(",'' AS GAS_SPCL_PCK_PROVI_N2ND_CTNT" ).append("\n"); 
		query.append(",'' AS GAS_SPCL_PCK_PROVI_N3RD_CTNT" ).append("\n"); 
		query.append(",'' AS GAS_SPCL_PCK_PROVI_N4TH_CTNT" ).append("\n"); 
		query.append(",'' AS LC50_VAL                    " ).append("\n"); 
		query.append(",'' AS MAX_WRK_PRSS                " ).append("\n"); 
		query.append(",'' AS MEGC_CHK_FLG                " ).append("\n"); 
		query.append(",'' AS PCK_REF_CD                  " ).append("\n"); 
		query.append(",'' AS PRSS_DRM_CHK_FLG            " ).append("\n"); 
		query.append(",'' AS REF_DIV_NO                  " ).append("\n"); 
		query.append(",'' AS TEST_PRD_YR                 " ).append("\n"); 
		query.append(",'' AS TST_PRSS                    " ).append("\n"); 
		query.append(",'' AS TUBE_CHK_FLG" ).append("\n"); 
		query.append(",'' AS PRP_SHP_NM   --" ).append("\n"); 
		query.append(",'' AS DELT_FLG" ).append("\n"); 
		query.append(",'' AS CRE_DT                      " ).append("\n"); 
		query.append(",'' AS CRE_USR_ID             " ).append("\n"); 
		query.append(",'' AS UPD_DT                      " ).append("\n"); 
		query.append(",'' AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}
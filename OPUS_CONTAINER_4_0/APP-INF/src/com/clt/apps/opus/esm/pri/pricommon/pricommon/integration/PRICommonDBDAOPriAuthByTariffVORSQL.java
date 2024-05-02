/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PRICommonDBDAOPriAuthByTariffVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.17
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.12.17 박성수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungsoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOPriAuthByTariffVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Auth조회
	  * </pre>
	  */
	public PRICommonDBDAOPriAuthByTariffVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAOPriAuthByTariffVORSQL").append("\n"); 
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
		query.append("PRC_CTRT_TP_CD" ).append("\n"); 
		query.append(",	SVC_SCP_CD" ).append("\n"); 
		query.append(",	USR_ID" ).append("\n"); 
		query.append(",	EFF_DT" ).append("\n"); 
		query.append(",	EXP_DT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append("FROM PRI_AUTHORIZATION A" ).append("\n"); 
		query.append("WHERE	PRC_CTRT_TP_CD = @[etc1]" ).append("\n"); 
		query.append("AND	USR_ID = @[etc2]" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("FROM PRI_SVC_SCP_TRF S" ).append("\n"); 
		query.append("WHERE S.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND TRF_PFX_CD = @[etc3]" ).append("\n"); 
		query.append("AND TRF_NO = @[etc4])" ).append("\n"); 
		query.append("AND TO_CHAR(SYSDATE, 'YYYYMMDD') BETWEEN TO_CHAR(EFF_DT, 'YYYYMMDD') AND TO_CHAR(EXP_DT, 'YYYYMMDD')" ).append("\n"); 

	}
}
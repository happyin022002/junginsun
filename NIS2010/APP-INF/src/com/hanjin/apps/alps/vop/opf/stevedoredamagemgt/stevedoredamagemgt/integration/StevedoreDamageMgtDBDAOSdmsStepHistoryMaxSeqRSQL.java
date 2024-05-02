/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOSdmsStepHistoryMaxSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.09.10 이선영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SunyoungLee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StevedoreDamageMgtDBDAOSdmsStepHistoryMaxSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SdmsStepHistoryMaxSeq Select Query
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOSdmsStepHistoryMaxSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_proc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration").append("\n"); 
		query.append("FileName : StevedoreDamageMgtDBDAOSdmsStepHistoryMaxSeqRSQL").append("\n"); 
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
		query.append("SELECT STV_DMG_PROC_CD" ).append("\n"); 
		query.append(",STV_DMG_CRNT_PROC_STS_CD" ).append("\n"); 
		query.append(",(SELECT MAX(STV_DMG_STEP_HIS_SEQ)+1 FROM OPF_STV_DMG_STEP_HIS" ).append("\n"); 
		query.append("WHERE STV_DMG_NO = A.STV_DMG_NO) AS STV_DMG_STEP_HIS_SEQ" ).append("\n"); 
		query.append("FROM  OPF_STV_DMG_STEP_HIS A" ).append("\n"); 
		query.append("WHERE STV_DMG_NO = @[stv_dmg_no]" ).append("\n"); 
		query.append("AND   STV_DMG_STEP_HIS_SEQ = (SELECT MAX(STV_DMG_STEP_HIS_SEQ) FROM OPF_STV_DMG_STEP_HIS" ).append("\n"); 
		query.append("WHERE STV_DMG_NO = A.STV_DMG_NO" ).append("\n"); 
		query.append("AND STV_DMG_PROC_CD = @[stv_dmg_proc_cd])" ).append("\n"); 

	}
}
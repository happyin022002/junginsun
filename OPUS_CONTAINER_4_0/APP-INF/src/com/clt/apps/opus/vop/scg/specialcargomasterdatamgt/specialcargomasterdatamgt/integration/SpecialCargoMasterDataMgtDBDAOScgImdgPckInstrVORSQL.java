/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOScgImdgPckInstrVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.08.18 김현욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Hyun Uk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoMasterDataMgtDBDAOScgImdgPckInstrVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Packing Instructions/Provisions (Creation) 의 조회
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOScgImdgPckInstrVORSQL(){
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
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOScgImdgPckInstrVORSQL").append("\n"); 
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
		query.append("IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append(",	IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append(",	FILE_SAV_ID" ).append("\n"); 
		query.append(",	FILE_NM" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(CRE_DT,'YYYYMMDD') AS CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(UPD_DT,'YYYYMMDD') AS UPD_DT" ).append("\n"); 
		query.append(",	IMDG_PCK_INSTR_CD AS OLD_IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append(",   '' FILE_SET_YN" ).append("\n"); 
		query.append("FROM SCG_IMDG_PCK_INSTR" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${imdg_pck_instr_cd} != '')" ).append("\n"); 
		query.append("AND IMDG_PCK_INSTR_CD LIKE @[imdg_pck_instr_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY IMDG_PCK_INSTR_CD" ).append("\n"); 

	}
}
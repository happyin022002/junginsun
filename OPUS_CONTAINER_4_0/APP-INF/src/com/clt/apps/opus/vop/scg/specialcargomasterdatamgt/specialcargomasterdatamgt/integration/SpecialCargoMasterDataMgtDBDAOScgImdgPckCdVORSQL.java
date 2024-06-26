/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOScgImdgPckCdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoMasterDataMgtDBDAOScgImdgPckCdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Packaging Code (Creation) 조회   
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOScgImdgPckCdVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_pck_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_pck_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOScgImdgPckCdVORSQL").append("\n"); 
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
		query.append("	IMDG_PCK_CD" ).append("\n"); 
		query.append(",	IMDG_PCK_DESC" ).append("\n"); 
		query.append(",	IMDG_PCK_TP_CD" ).append("\n"); 
		query.append("--,	NVL(DELT_FLG,'N') AS DELT_FLG" ).append("\n"); 
		query.append(",	DELT_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT " ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append("FROM SCG_IMDG_PCK_CD" ).append("\n"); 
		query.append("WHERE	1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${imdg_pck_cd} != '') " ).append("\n"); 
		query.append("AND INSTR( IMDG_PCK_CD, @[imdg_pck_cd] ) > 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_pck_tp_cd} != '') " ).append("\n"); 
		query.append("AND  IMDG_PCK_TP_CD = @[imdg_pck_tp_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_pck_desc} != '') " ).append("\n"); 
		query.append(" AND INSTR( IMDG_PCK_DESC, @[imdg_pck_desc]) >0 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY DELT_FLG, IMDG_PCK_CD" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOScgImdgPckGrpVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.06.08 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dohyoung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoMasterDataMgtDBDAOScgImdgPckGrpVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Packing Group (Creation) 조회
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOScgImdgPckGrpVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_pck_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append(",	PCK_DGR_NM" ).append("\n"); 
		query.append(",	FLSH_PNT_TEMP_CTNT" ).append("\n"); 
		query.append(",	INIT_BOIL_PNT_TEMP_CTNT" ).append("\n"); 
		query.append(",	DRP_HGT_CTNT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append("FROM SCG_IMDG_PCK_GRP" ).append("\n"); 
		query.append("WHERE	1 = 1" ).append("\n"); 
		query.append("#if (${imdg_pck_grp_cd} != '')" ).append("\n"); 
		query.append("AND IMDG_PCK_GRP_CD = @[imdg_pck_grp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY IMDG_PCK_GRP_CD" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOScgImdgPckGrpVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}
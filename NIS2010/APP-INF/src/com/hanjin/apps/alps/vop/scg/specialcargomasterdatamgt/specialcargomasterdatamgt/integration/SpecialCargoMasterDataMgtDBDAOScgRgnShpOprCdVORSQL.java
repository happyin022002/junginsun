/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOScgRgnShpOprCdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoMasterDataMgtDBDAOScgRgnShpOprCdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPCL CGO RSO (Creation) 조회
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOScgRgnShpOprCdVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_shp_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOScgRgnShpOprCdVORSQL").append("\n"); 
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
		query.append("	RGN_SHP_OPR_CD" ).append("\n"); 
		query.append(",	RGN_SHP_OPR_ABBR_DESC" ).append("\n"); 
		query.append(",	RGN_SHP_OPR_DESC" ).append("\n"); 
		query.append(",	NVL(DELT_FLG,'N') AS DELT_FLG" ).append("\n"); 
		query.append(",   RGN_SHP_OPR_RHQ_CD1" ).append("\n"); 
		query.append(",   RGN_SHP_OPR_RHQ_CD2" ).append("\n"); 
		query.append(",   RGN_SHP_OPR_RHQ_CD3" ).append("\n"); 
		query.append(",   RGN_SHP_OPR_RHQ_CD4" ).append("\n"); 
		query.append(",   RGN_SHP_OPR_RHQ_CD5" ).append("\n"); 
		query.append(",   RGN_SHP_OPR_RHQ_CD6" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append("FROM SCG_RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("WHERE	1 = 1" ).append("\n"); 
		query.append("#if (${delt_flg} != '') " ).append("\n"); 
		query.append("AND NVL(DELT_FLG,'N') = @[delt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rgn_shp_opr_cd} != '') " ).append("\n"); 
		query.append("AND RGN_SHP_OPR_CD = @[rgn_shp_opr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY RGN_SHP_OPR_CD" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TonnageTaxOutputMasterDataMgtDBDAOVesselVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.17
*@LastModifier : 
*@LastVersion : 1.0
* 2012.09.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TonnageTaxOutputMasterDataMgtDBDAOVesselVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TonnageTaxOutputMasterDataMgtDBDAOVesselVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.integration").append("\n"); 
		query.append("FileName : TonnageTaxOutputMasterDataMgtDBDAOVesselVOCSQL").append("\n"); 
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
		query.append("INSERT INTO TOT_VESSEL (" ).append("\n"); 
		query.append("    STL_YR, VSL_CD, VSL_SEQ, TONG_FLET_TP_CD, CTRT_ST_DT, CTRT_END_DT" ).append("\n"); 
		query.append("    , LDB_CAPA_QTY, DELT_FLG, VSL_RMK" ).append("\n"); 
		query.append("    , CRE_DT, CRE_USR_ID, UPD_DT, UPD_USR_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    @[stl_yr], VSL_CD, VSL_SEQ, TONG_FLET_TP_CD, CTRT_ST_DT, CTRT_END_DT" ).append("\n"); 
		query.append("    , LDB_CAPA_QTY, DELT_FLG, VSL_RMK" ).append("\n"); 
		query.append("    , sysdate, @[cre_usr_id], sysdate, @[cre_usr_id]" ).append("\n"); 
		query.append("FROM TOT_VESSEL" ).append("\n"); 
		query.append("WHERE STL_YR = TO_CHAR(TO_NUMBER(@[stl_yr])-1)" ).append("\n"); 
		query.append("	AND	DELT_FLG = 'N'" ).append("\n"); 

	}
}
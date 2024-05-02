/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OfficeMappingDBDAOSearchConfirmedDataOfLaneOfficePairRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OfficeMappingDBDAOSearchConfirmedDataOfLaneOfficePairRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sector-Office Relation Setting for IAS Sector(ESM_SQM_0204)에서 Active컬럼을 unchecked하려고 할 때 해당 pair의 확정 데이터가 생성되어 있는 것이 있는지 확인하는 쿼리
	  * 20160114 [CHM-201539389] Lane Office Inactive 불가하도록 비활성화 로직 변경
	  * </pre>
	  */
	public OfficeMappingDBDAOSearchConfirmedDataOfLaneOfficePairRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.integration").append("\n"); 
		query.append("FileName : OfficeMappingDBDAOSearchConfirmedDataOfLaneOfficePairRSQL").append("\n"); 
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
		query.append("select * from sqm_cfm_qta" ).append("\n"); 
		query.append("  where BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("  AND BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append("  AND OFC_VW_CD = SUBSTR(@[ofc_vw_cd], 0, 1)" ).append("\n"); 
		query.append("  AND RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("  AND DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("  AND RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("  AND RGN_OFC_CD = @[rgn_ofc_cd]" ).append("\n"); 
		query.append("  AND ROWNUM < 2" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BasicDataDBDAOSearchMdmVslSvcLaneDirRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.basicdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BasicDataDBDAOSearchMdmVslSvcLaneDirRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [POL POD Pair for IAS Sector Add List]의 MDM Lane Direction을 [조회]합니다.
	  * </pre>
	  */
	public BasicDataDBDAOSearchMdmVslSvcLaneDirRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.datamanage.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOSearchMdmVslSvcLaneDirRSQL").append("\n"); 
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
		query.append("SELECT A2.VSL_SLAN_DIR_CD DIR_CD" ).append("\n"); 
		query.append("FROM CSQ_QTA_LANE_MGMT A1, MDM_VSL_SVC_LANE_DIR A2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A1.TRD_CD     	= @[f_trd_cd]" ).append("\n"); 
		query.append("AND A1.SUB_TRD_CD 	= @[f_sub_trd_cd]" ).append("\n"); 
		query.append("AND A1.RLANE_CD   	= @[f_rlane_cd]" ).append("\n"); 
		query.append("AND A1.BSE_TP_CD  	= @[f_bse_tp_cd]" ).append("\n"); 
		query.append("AND A1.BSE_YR     	= @[f_bse_yr]" ).append("\n"); 
		query.append("AND A1.BSE_QTR_CD 	= @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("AND A1.CSQ_ACT_FLG  = 'Y'  -- FIX" ).append("\n"); 
		query.append("AND A2.DELT_FLG     = 'N'  -- FIX" ).append("\n"); 
		query.append("AND SUBSTR(A1.RLANE_CD,0,3) = A2.VSL_SLAN_CD" ).append("\n"); 

	}
}
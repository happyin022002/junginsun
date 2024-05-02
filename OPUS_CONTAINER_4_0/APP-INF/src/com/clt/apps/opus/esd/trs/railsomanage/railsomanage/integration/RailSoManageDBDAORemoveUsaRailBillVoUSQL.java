/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailSoManageDBDAORemoveUsaRailBillVoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.09.11 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAORemoveUsaRailBillVoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 SO를 SO 마스터 테이블에 Delete 상태로 수정 SQL
	  * </pre>
	  */
	public RailSoManageDBDAORemoveUsaRailBillVoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sctrlOfcCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration").append("\n"); 
		query.append("FileName : RailSoManageDBDAORemoveUsaRailBillVoUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("#if(${trspRqstBkgFlg} == 'Y')" ).append("\n"); 
		query.append("TRSP_RQST_BKG_FLG = 'Y'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("TRSP_RQST_BKG_FLG = null," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("DELT_FLG = 'Y'," ).append("\n"); 
		query.append("UPD_USR_ID = @[user_id]," ).append("\n"); 
		query.append("LOCL_UPD_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[sctrlOfcCd])," ).append("\n"); 
		query.append("LOG_UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 

	}
}
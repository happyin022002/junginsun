/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OfficeMappingDBDAOUpdateRhqOfcMappingUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.officemapping.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OfficeMappingDBDAOUpdateRhqOfcMappingUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RHQ별 산하의 판매목표 수립 대상인 Office 정보 삭제
	  * </pre>
	  */
	public OfficeMappingDBDAOUpdateRhqOfcMappingUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.datamanage.officemapping.integration").append("\n"); 
		query.append("FileName : OfficeMappingDBDAOUpdateRhqOfcMappingUSQL").append("\n"); 
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
		query.append("UPDATE CSQ_QTA_OFC" ).append("\n"); 
		query.append("   SET DELT_FLG    = @[delt_flg]" ).append("\n"); 
		query.append("      ,UPD_USR_ID  = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT      = SYSDATE " ).append("\n"); 
		query.append(" WHERE RGN_OFC_CD  = @[rgn_ofc_cd]" ).append("\n"); 
		query.append("   AND RHQ_CD      = @[rhq_cd]" ).append("\n"); 

	}
}
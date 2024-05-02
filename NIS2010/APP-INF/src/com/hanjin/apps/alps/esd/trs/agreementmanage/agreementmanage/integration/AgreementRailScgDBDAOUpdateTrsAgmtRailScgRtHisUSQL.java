/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AgreementRailScgDBDAOUpdateTrsAgmtRailScgRtHisUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.11
*@LastModifier : 민정호
*@LastVersion : 1.1
* 2011.05.02 민정호
* 1.0 Creation
* 
* 1.1 2011.05.11 민정호 [CHM-201110223] USER 에 의한 AGMT HISTORY 관리를 위한 기능 추가요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min Jung Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementRailScgDBDAOUpdateTrsAgmtRailScgRtHisUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AgreementRailScgDBDAOUpdateTrsAgmtRailScgRtHisUSQL
	  * </pre>
	  */
	public AgreementRailScgDBDAOUpdateTrsAgmtRailScgRtHisUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_rt_his_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("USR_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_scg_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("UPD_USR_ID",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementRailScgDBDAOUpdateTrsAgmtRailScgRtHisUSQL").append("\n"); 
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
		query.append("UPDATE TRS_AGMT_RAIL_SCG_RT_HIS" ).append("\n"); 
		query.append("SET DELT_FLG = @[delt_flg]," ).append("\n"); 
		query.append("UPD_USR_ID = @[UPD_USR_ID]," ).append("\n"); 
		query.append("UPD_DT = SYSDATE," ).append("\n"); 
		query.append("LOCL_UPD_DT = globaldate_pkg.time_local_ofc_fnc(@[USR_OFC_CD])" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND TRSP_AGMT_SCG_SEQ	 = @[trsp_agmt_scg_seq]" ).append("\n"); 
		query.append("AND TRSP_AGMT_RT_HIS_SEQ = @[trsp_agmt_rt_his_seq]" ).append("\n"); 

	}
}
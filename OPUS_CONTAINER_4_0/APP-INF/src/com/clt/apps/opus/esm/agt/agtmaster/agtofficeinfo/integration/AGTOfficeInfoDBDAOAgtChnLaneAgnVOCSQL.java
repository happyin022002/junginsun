/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTOfficeInfoDBDAOAgtChnLaneAgnVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.02.19 박성진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtmaster.agtofficeinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTOfficeInfoDBDAOAgtChnLaneAgnVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public AGTOfficeInfoDBDAOAgtChnLaneAgnVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_finc_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtmaster.agtofficeinfo.integration").append("\n"); 
		query.append("FileName : AGTOfficeInfoDBDAOAgtChnLaneAgnVOCSQL").append("\n"); 
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
		query.append("INSERT INTO AGT_CHN_LANE_AGN (" ).append("\n"); 
		query.append("POD_CD," ).append("\n"); 
		query.append("SLAN_CD," ).append("\n"); 
		query.append("AGN_CD," ).append("\n"); 
		query.append("AGN_CUST_CNT_CD," ).append("\n"); 
		query.append("AGN_CUST_SEQ," ).append("\n"); 
		query.append("AGN_FINC_OFC_CD," ).append("\n"); 
		query.append("AGN_VNDR_CNT_CD," ).append("\n"); 
		query.append("AGN_VNDR_SEQ," ).append("\n"); 
		query.append("DELT_FLG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT)" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("@[pod_cd]" ).append("\n"); 
		query.append(",	@[slan_cd]" ).append("\n"); 
		query.append(",	@[agn_cd]" ).append("\n"); 
		query.append(",	@[agn_cnt_cd]" ).append("\n"); 
		query.append(",	@[agn_cust_seq]" ).append("\n"); 
		query.append(",	@[agn_finc_ofc_cd]" ).append("\n"); 
		query.append(",	(SELECT VNDR_CNT_CD FROM MDM_VENDOR WHERE VNDR_SEQ = @[agn_vndr_seq]) --Hidden value 이므로 자동으로 입력" ).append("\n"); 
		query.append(",	@[agn_vndr_seq]" ).append("\n"); 
		query.append(",	@[delt_flg]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE)" ).append("\n"); 

	}
}
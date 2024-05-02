/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortInformationMgtDBDAOPortInformationMgtVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.05.27 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortInformationMgtDBDAOPortInformationMgtVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PortInformationMgtDBDAOPortInformationMgtVOCSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("alsd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brth_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_drft_dpth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brth_dpth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("plt_mnvr_tm_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chnl_dpth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("at_drft_dpth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("plt_mnvr_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnvr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("turn_bsn_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ad_len",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("INSERT INTO VSK_PORT_MNVR (" ).append("\n"); 
		query.append("YD_CD" ).append("\n"); 
		query.append(",	ALSD_CD" ).append("\n"); 
		query.append(",	CHNL_DPTH" ).append("\n"); 
		query.append(",	BRTH_DPTH" ).append("\n"); 
		query.append(",	AT_DRFT_DPTH" ).append("\n"); 
		query.append(",	MAX_DRFT_DPTH" ).append("\n"); 
		query.append(",	AD_LEN" ).append("\n"); 
		query.append(",	BRTH_LEN" ).append("\n"); 
		query.append(",	TURN_BSN_LEN" ).append("\n"); 
		query.append(",	PLT_MNVR_DIST" ).append("\n"); 
		query.append(",	PLT_MNVR_TM_HRS" ).append("\n"); 
		query.append(",	MNVR_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[yd_cd]" ).append("\n"); 
		query.append(",	@[alsd_cd]" ).append("\n"); 
		query.append(",	@[chnl_dpth]" ).append("\n"); 
		query.append(",	@[brth_dpth]" ).append("\n"); 
		query.append(",	@[at_drft_dpth]" ).append("\n"); 
		query.append(",	@[max_drft_dpth]" ).append("\n"); 
		query.append(",	@[ad_len]" ).append("\n"); 
		query.append(",	@[brth_len]" ).append("\n"); 
		query.append(",	@[turn_bsn_len]" ).append("\n"); 
		query.append(",	@[plt_mnvr_dist]" ).append("\n"); 
		query.append(",	@[plt_mnvr_tm_hrs]" ).append("\n"); 
		query.append(",	@[mnvr_rmk]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.vop.vsk.vesseloperationsupportmgt.portinformationmgt.integration").append("\n"); 
		query.append("FileName : PortInformationMgtDBDAOPortInformationMgtVOCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}
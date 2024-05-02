/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OceanLinkBackEndDBDAOOceanLinkDeleteManualPfTzTmUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanLinkBackEndDBDAOOceanLinkDeleteManualPfTzTmUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Ocean Link를 Delete했을 때, prd_pf_tz_tm 의 dlt_flg를 변경한다.
	  * </pre>
	  */
	public OceanLinkBackEndDBDAOOceanLinkDeleteManualPfTzTmUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("podprot",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dircd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lanecd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnk_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("polprot",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.integration").append("\n"); 
		query.append("FileName : OceanLinkBackEndDBDAOOceanLinkDeleteManualPfTzTmUSQL").append("\n"); 
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
		query.append("UPDATE PRD_PF_TZ_TM  " ).append("\n"); 
		query.append("SET DELT_FLG= 'Y' , " ).append("\n"); 
		query.append("    UPD_OFC_CD =@[cre_ofc_cd] , " ).append("\n"); 
		query.append("    UPD_USR_ID =@[upd_usr_id] , " ).append("\n"); 
		query.append("    UPD_DT = SYSDATE," ).append("\n"); 
		query.append("    LNK_RMK = @[upd_usr_id]||' has deleted on '||TO_CHAR(SYSDATE,'Mon-DD,YYYY', 'NLS_DATE_LANGUAGE=ENGLISH')||' : '|| @[lnk_rmk]" ).append("\n"); 
		query.append("WHERE VSL_SLAN_CD= @[lanecd]  " ).append("\n"); 
		query.append("AND FM_PORT_CD= @[polprot]  " ).append("\n"); 
		query.append("AND TO_PORT_CD= @[podprot]" ).append("\n"); 
		query.append("AND SKD_DIR_CD= @[dircd]" ).append("\n"); 
		query.append("AND OCN_LNK_MNL_FLG = 'Y'" ).append("\n"); 

	}
}
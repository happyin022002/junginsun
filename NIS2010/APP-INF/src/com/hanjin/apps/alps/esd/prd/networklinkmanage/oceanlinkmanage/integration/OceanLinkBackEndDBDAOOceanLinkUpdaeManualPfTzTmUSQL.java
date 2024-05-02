/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : OceanLinkBackEndDBDAOOceanLinkUpdaeManualPfTzTmUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.05
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2011.08.05 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanLinkBackEndDBDAOOceanLinkUpdaeManualPfTzTmUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 정보 수정시, prd_pf_tz_tm에 해당 정보를 업데이트한다.
	  * </pre>
	  */
	public OceanLinkBackEndDBDAOOceanLinkUpdaeManualPfTzTmUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmt_tztm_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("poletb",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("podetb",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dircd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("poletd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("podetd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.integration").append("\n"); 
		query.append("FileName : OceanLinkBackEndDBDAOOceanLinkUpdaeManualPfTzTmUSQL").append("\n"); 
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
		query.append("UPDATE prd_pf_tz_TM  " ).append("\n"); 
		query.append("   SET SKD_DIR_CD= @[dircd] , " ).append("\n"); 
		query.append("       FM_PORT_ETB_DY_CD= @[poletb] , " ).append("\n"); 
		query.append("       FM_PORT_ETD_DY_CD= @[poletd] , " ).append("\n"); 
		query.append("       TO_PORT_ETB_DY_CD= @[podetb] , " ).append("\n"); 
		query.append("       TO_PORT_ETD_DY_CD= @[podetd] , " ).append("\n"); 
		query.append("       TZTM_HRS= TO_NUMBER(@[fmt_tztm_hrs]) , " ).append("\n"); 
		query.append("       UPD_OFC_CD =@[cre_ofc_cd] , " ).append("\n"); 
		query.append("       UPD_USR_ID =@[upd_usr_id] , " ).append("\n"); 
		query.append("       UPD_DT = sysdate ," ).append("\n"); 
		query.append("       LNK_RMK = case when nvl(DELT_FLG,'N') = 'N' THEN @[lnk_rmk]" ).append("\n"); 
		query.append("                      else @[upd_usr_id]||' has created on '||TO_CHAR(SYSDATE,'Mon-DD,YYYY', 'NLS_DATE_LANGUAGE=ENGLISH')||' : '|| @[lnk_rmk]" ).append("\n"); 
		query.append("                 END ," ).append("\n"); 
		query.append("       DELT_FLG = 'N'" ).append("\n"); 
		query.append("WHERE VSL_SLAN_CD= @[lanecd]  " ).append("\n"); 
		query.append("AND FM_PORT_CD= @[polprot]  " ).append("\n"); 
		query.append("AND TO_PORT_CD= @[podprot]" ).append("\n"); 

	}
}
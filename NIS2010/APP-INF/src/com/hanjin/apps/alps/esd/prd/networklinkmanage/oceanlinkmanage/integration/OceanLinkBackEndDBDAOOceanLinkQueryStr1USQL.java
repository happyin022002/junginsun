/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : OceanLinkBackEndDBDAOOceanLinkQueryStr1USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.03
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2011.08.03 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanLinkBackEndDBDAOOceanLinkQueryStr1USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * HQ Link에 해당하는 Direct Ocean Route를 수정한다.
	  * </pre>
	  */
	public OceanLinkBackEndDBDAOOceanLinkQueryStr1USQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibflag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("remark",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lanecd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.integration ").append("\n"); 
		query.append("FileName : OceanLinkBackEndDBDAOOceanLinkQueryStr1USQL").append("\n"); 
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
		query.append("UPDATE PRD_OCN_ROUT" ).append("\n"); 
		query.append("SET UPD_IND_CD    = DECODE(@[ibflag],'D', 'D', 'S') ," ).append("\n"); 
		query.append("    OCN_ROUT_UPD_DT  = sysdate," ).append("\n"); 
		query.append("	UPD_OFC_CD    = @[cre_ofc_cd]," ).append("\n"); 
		query.append("	UPD_USR_ID    = @[upd_usr_id]," ).append("\n"); 
		query.append("    OCN_ROUT_RMK  = REPLACE(REPLACE(REPLACE(@[remark], CHR(34)),CHR(9),' '), CHR(13)||CHR(10),' ')," ).append("\n"); 
		query.append("    OCN_ROUT_PRIO_CD = DECODE(@[ibflag], 'D', OCN_ROUT_PRIO_CD, '1')," ).append("\n"); 
		query.append("    OCN_ROUT_PRIO_CNG_FLG = 'N'," ).append("\n"); 
		query.append("    OCN_ROUT_USR_RMK = DECODE(@[ibflag], 'D', OCN_ROUT_USR_RMK, NULL)" ).append("\n"); 
		query.append("WHERE N1ST_POL_CD   = RTRIM(@[polprot])" ).append("\n"); 
		query.append("AND N1ST_POD_CD   = RTRIM(@[podprot])" ).append("\n"); 
		query.append("AND TS_IND_CD     =  'D'" ).append("\n"); 
		query.append("AND N1ST_LANE_CD  = RTRIM(@[lanecd])" ).append("\n"); 
		query.append("AND N1ST_LANE_FDR_FLG = 'N'" ).append("\n"); 

	}
}
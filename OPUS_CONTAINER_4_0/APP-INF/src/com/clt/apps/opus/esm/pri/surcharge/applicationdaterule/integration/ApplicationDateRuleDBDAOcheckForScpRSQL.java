/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ApplicationDateRuleDBDAOcheckForScpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.16
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.05.16 조정민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.applicationdaterule.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApplicationDateRuleDBDAOcheckForScpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 로케이션이 scope내에 region에 속하는지 확인하는 벨리데이션
	  * </pre>
	  */
	public ApplicationDateRuleDBDAOcheckForScpRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_location",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.surcharge.applicationdaterule.integration ").append("\n"); 
		query.append("FileName : ApplicationDateRuleDBDAOcheckForScpRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*)" ).append("\n"); 
		query.append("  FROM MDM_SVC_SCP_LMT LMT" ).append("\n"); 
		query.append("      ,MDM_LOCATION LOC" ).append("\n"); 
		query.append(" WHERE LOC.LOC_CD = @[chk_location]" ).append("\n"); 
		query.append("   AND LMT.RGN_CD = LOC.RGN_CD" ).append("\n"); 
		query.append("   AND LMT.SVC_SCP_CD = @[chk_scp_cd]" ).append("\n"); 
		query.append("   AND LMT.ORG_DEST_CD = DECODE(@[chk_flg],'1','O','D')" ).append("\n"); 

	}
}
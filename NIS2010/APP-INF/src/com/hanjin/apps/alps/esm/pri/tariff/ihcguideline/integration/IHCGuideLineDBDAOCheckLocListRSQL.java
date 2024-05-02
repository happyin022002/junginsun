/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : IHCGuideLineDBDAOCheckLocListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.23
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2013.04.23 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IHCGuideLineDBDAOCheckLocListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Location이 해당 scope에 존재하는 location 인지 확인한다.
	  * </pre>
	  */
	public IHCGuideLineDBDAOCheckLocListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration").append("\n"); 
		query.append("FileName : IHCGuideLineDBDAOCheckLocListRSQL").append("\n"); 
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
		query.append("SELECT A.LOC_CD" ).append("\n"); 
		query.append("  FROM MDM_LOCATION A" ).append("\n"); 
		query.append(" WHERE A.LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("                 FROM MDM_SVC_SCP_LMT S" ).append("\n"); 
		query.append("                WHERE S.RGN_CD = A.RGN_CD" ).append("\n"); 
		query.append("                  AND S.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                  AND S.ORG_DEST_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("                  AND S.DELT_FLG = 'N')" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OptimizeddistancemgtDBDAOModifyYardGroupUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OptimizeddistancemgtDBDAOModifyYardGroupUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 Port관련 Gourp의 정보를 Update한다.
	  * </pre>
	  */
	public OptimizeddistancemgtDBDAOModifyYardGroupUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.integration").append("\n"); 
		query.append("FileName : OptimizeddistancemgtDBDAOModifyYardGroupUSQL").append("\n"); 
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
		query.append("MERGE  INTO  VSK_YD_GRP" ).append("\n"); 
		query.append("USING  DUAL  ON" ).append("\n"); 
		query.append("(    " ).append("\n"); 
		query.append("    1=1" ).append("\n"); 
		query.append("    AND    YD_CD = @[yd_cd]	" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("  UPDATE SET" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  YD_GRP_ID  = @[yd_grp_id]" ).append("\n"); 
		query.append("    , UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("    , UPD_DT     = sysdate" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("  INSERT" ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("      YD_CD" ).append("\n"); 
		query.append("    , YD_GRP_ID" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("  VALUES" ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("	  @[yd_cd]" ).append("\n"); 
		query.append("	, @[yd_grp_id]" ).append("\n"); 
		query.append("	, @[usr_id]" ).append("\n"); 
		query.append("    , sysdate" ).append("\n"); 
		query.append("	, @[usr_id]" ).append("\n"); 
		query.append("    , sysdate" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}
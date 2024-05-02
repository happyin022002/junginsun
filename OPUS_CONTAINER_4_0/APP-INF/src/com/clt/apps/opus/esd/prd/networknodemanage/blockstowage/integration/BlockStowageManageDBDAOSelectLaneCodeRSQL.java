/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BlockStowageManageDBDAOSelectLaneCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 노승배
*@LastVersion : 1.0
* 2009.08.14 노승배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.blockstowage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Noh Seung Bae
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlockStowageManageDBDAOSelectLaneCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SelectLaneCode
	  * </pre>
	  */
	public BlockStowageManageDBDAOSelectLaneCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networknodemanage.blockstowage.integration ").append("\n"); 
		query.append("FileName : BlockStowageManageDBDAOSelectLaneCodeRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN LNK_KNT=1 THEN N1ST_LANE_CD" ).append("\n"); 
		query.append("WHEN LNK_KNT=2 THEN N2ND_LANE_CD" ).append("\n"); 
		query.append("WHEN LNK_KNT=3 THEN N3RD_LANE_CD" ).append("\n"); 
		query.append("WHEN LNK_KNT=4 THEN N4TH_LANE_CD" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END lane_code" ).append("\n"); 
		query.append("FROM PRD_OCN_ROUT" ).append("\n"); 
		query.append("WHERE DEST_LOC_CD = @[pod_code]" ).append("\n"); 

	}
}
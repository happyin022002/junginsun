/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BlockStowageManageDBDAOSelectCodeInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.blockstowage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlockStowageManageDBDAOSelectCodeInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SelectCodeInquiry
	  * </pre>
	  */
	public BlockStowageManageDBDAOSelectCodeInquiryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bs_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hub_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networknodemanage.blockstowage.integration").append("\n"); 
		query.append("FileName : BlockStowageManageDBDAOSelectCodeInquiryRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A.PORT_CD PORT_CODE, A.VSL_SLAN_CD LANE_CODE, A.HUB_LOC_CD HUB_CODE, A.BLCK_STWG_CD BS_CODE, SUBSTR(B.ROUT_DEST_NOD_CD, 0, 5) DEST" ).append("\n"); 
		query.append("  FROM PRD_BLCK_STWG A, PRD_INLND_ROUT_MST B" ).append("\n"); 
		query.append(" WHERE A.PORT_CD = @[port_code]" ).append("\n"); 
		query.append("   AND A.VSL_SLAN_CD = @[lane_code]" ).append("\n"); 
		query.append("   AND A.PORT_CD = SUBSTR(B.ROUT_ORG_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("   AND A.HUB_LOC_CD = DECODE(SUBSTR(B.HUB_NOD_CD, 1, 5), NULL, SUBSTR(B.ROUT_ORG_NOD_CD, 1, 5), SUBSTR(B.HUB_NOD_CD, 1, 5))" ).append("\n"); 
		query.append("   AND B.INLND_ROUT_BKG_FLG = 'Y'" ).append("\n"); 
		query.append("   AND NVL(B.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("   AND A.HUB_LOC_CD LIKE @[hub_code] || '%'" ).append("\n"); 
		query.append("   AND A.BLCK_STWG_CD LIKE @[bs_code] || '%'" ).append("\n"); 
		query.append("   AND B.ROUT_DEST_NOD_CD LIKE @[dest] || '%'" ).append("\n"); 
		query.append("   AND B.PCTL_IO_BND_CD = 'I'" ).append("\n"); 

	}
}
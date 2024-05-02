/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAOSearchSpaceAllocationControlFlagListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.24
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2011.02.24 최윤성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpacecontrolinquiryDBDAOSearchSpaceAllocationControlFlagListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public SpacecontrolinquiryDBDAOSearchSpaceAllocationControlFlagListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpacecontrolinquiryDBDAOSearchSpaceAllocationControlFlagListVORSQL").append("\n"); 
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
		query.append("SELECT NVL(MIN(T.CTRL_LVL_CD)     , 'L') AS POL_POD," ).append("\n"); 
		query.append("       NVL(MIN(T.CTRL_40FT_HC_FLG), 'N') AS HC40   ," ).append("\n"); 
		query.append("       NVL(MIN(T.CTRL_45FT_HC_FLG), 'N') AS HC45   ," ).append("\n"); 
		query.append("       NVL(MIN(T.CTRL_53FT_FLG),    'N') AS FT53   ," ).append("\n"); 
		query.append("       NVL(MIN(T.CTRL_RF_FLG)     , 'N') AS REEFER ," ).append("\n"); 
		query.append("       NVL(MIN(T.CTRL_WGT_FLG)    , 'N') AS WEIGHT ," ).append("\n"); 
		query.append("       NVL(MIN(T.CTRL_SPC_FLG)    , 'N') AS VOLUME" ).append("\n"); 
		query.append("  FROM SPC_ALOC_CTRL_OPT T" ).append("\n"); 
		query.append(" WHERE T.RLANE_CD   = @[lane]" ).append("\n"); 
		query.append("   AND T.DIR_CD     = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND T.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("   AND T.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND T.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 

	}
}
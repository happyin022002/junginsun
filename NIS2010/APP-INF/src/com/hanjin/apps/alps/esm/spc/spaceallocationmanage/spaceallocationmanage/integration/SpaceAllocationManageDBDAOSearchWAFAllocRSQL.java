/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOSearchWAFAllocRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.10
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2014.12.10 신자영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHIN JA YOUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOSearchWAFAllocRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WAFIE노선 Allocation 을 조회한다.
	  * History-----------------------------------
	  * 20110.08.12 [CHM-201112741-01] Control by HO/RHQ 화면 보완 2차 - SLS_OFC_CD가 HAMRU,NYCRA로 Allocation된 내용을 조회
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOSearchWAFAllocRSQL(){
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
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOSearchWAFAllocRSQL").append("\n"); 
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
		query.append("SELECT  RLANE_CD" ).append("\n"); 
		query.append("      , DIR_CD" ).append("\n"); 
		query.append("      , VSL_CD" ).append("\n"); 
		query.append("      , SKD_VOY_NO" ).append("\n"); 
		query.append("      , SKD_DIR_CD" ).append("\n"); 
		query.append("      , SLS_OFC_CD" ).append("\n"); 
		query.append("      , POL_YD_CD AS POL_CD" ).append("\n"); 
		query.append("      , POD_YD_CD AS POD_CD" ).append("\n"); 
		query.append("      , TS_FLG" ).append("\n"); 
		query.append("      , MNL_FLG" ).append("\n"); 
		query.append("      , TRD_CD" ).append("\n"); 
		query.append("      , SUB_TRD_CD" ).append("\n"); 
		query.append("      , REP_TRD_CD" ).append("\n"); 
		query.append("      , REP_SUB_TRD_CD" ).append("\n"); 
		query.append("      , DECODE(TS_FLG,'Y','T',IOC_CD) IOC_CD" ).append("\n"); 
		query.append("      , ASGN_TTL_QTY" ).append("\n"); 
		query.append("      , ASGN_TTL_WGT" ).append("\n"); 
		query.append("      , ASGN_40FT_HC_QTY" ).append("\n"); 
		query.append("      , ASGN_45FT_HC_QTY" ).append("\n"); 
		query.append("      , ASGN_53FT_QTY" ).append("\n"); 
		query.append("      , ASGN_RF_QTY" ).append("\n"); 
		query.append("      , DEST_LOC_CD AS DEL_CD" ).append("\n"); 
		query.append("      , ASGN_20FT_DRY_QTY" ).append("\n"); 
		query.append("      , ASGN_40FT_DRY_QTY" ).append("\n"); 
		query.append("      , ASGN_RD_QTY" ).append("\n"); 
		query.append("      , CUST_CNT_CD" ).append("\n"); 
		query.append("      , CUST_SEQ" ).append("\n"); 
		query.append("	  , CTRT_NO " ).append("\n"); 
		query.append("      , USA_BKG_MOD_CD" ).append("\n"); 
		query.append("  FROM  SPC_ALOC_POL_POD" ).append("\n"); 
		query.append(" WHERE  1=1" ).append("\n"); 
		query.append("   AND  RLANE_CD   = @[lane]" ).append("\n"); 
		query.append("   AND  DIR_CD     = @[bound]" ).append("\n"); 
		query.append("   AND  VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("   AND  SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND  SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND  SLS_OFC_CD IN ('HAMRU', 'NYCRA')" ).append("\n"); 
		query.append("   -- AND	POL_YD_CD  = 'XXXXXXX'" ).append("\n"); 
		query.append("   AND	DEST_LOC_CD  = 'XXXXX'" ).append("\n"); 

	}
}

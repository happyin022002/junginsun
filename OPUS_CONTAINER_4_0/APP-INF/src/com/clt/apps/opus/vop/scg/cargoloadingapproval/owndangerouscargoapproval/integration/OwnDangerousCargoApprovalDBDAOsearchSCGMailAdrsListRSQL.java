/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOsearchSCGMailAdrsListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOsearchSCGMailAdrsListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSCGMailAdrsList
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOsearchSCGMailAdrsListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_shp_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOsearchSCGMailAdrsListRSQL").append("\n"); 
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
		query.append("SELECT CNTC_PSON_EML_CTNT" ).append("\n"); 
		query.append("  FROM SCG_CNTC_PNT" ).append("\n"); 
		query.append(" WHERE RGN_SHP_OPR_CD = @[rgn_shp_opr_cd]" ).append("\n"); 
		query.append("   AND CRR_CD = @[crr_cd]" ).append("\n"); 
		query.append("   AND SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("   AND SPCL_CGO_CATE_CD = @[spcl_cgo_cate_cd]--'DG'" ).append("\n"); 
		query.append("   AND CNTC_PSON_EML_CTNT IS NOT NULL" ).append("\n"); 
		query.append("   AND DELT_FLG != 'Y'              " ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}
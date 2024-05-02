/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintMasterDBDAOSearchSetFormList2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.30
*@LastModifier : Arie
*@LastVersion : 1.0
* 2015.03.30 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintMasterDBDAOSearchSetFormList2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 셀렉트박스 선택시 spc_rpt_fom 조회
	  * </pre>
	  */
	public ConstraintMasterDBDAOSearchSetFormList2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpt_fom_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pgm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpt_fom_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration").append("\n"); 
		query.append("FileName : ConstraintMasterDBDAOSearchSetFormList2RSQL").append("\n"); 
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
		query.append("SELECT MST.PGM_NO       AS PGM_NO," ).append("\n"); 
		query.append("       MST.RPT_FOM_DESC AS RPT_FOM_DESC," ).append("\n"); 
		query.append("       DTL.DP_SEQ       AS DP_SEQ," ).append("\n"); 
		query.append("       DTL.COL_NM       AS COL_NM," ).append("\n"); 
		query.append("       DTL.DP_NM        AS DP_NM," ).append("\n"); 
		query.append("	   MST.RPT_FOM_NO AS RPT_FOM_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM SPC_RPT_FOM MST, SPC_RPT_FOM_DTL DTL" ).append("\n"); 
		query.append(" WHERE MST.CRE_USR_ID = DTL.CRE_USR_ID(+)" ).append("\n"); 
		query.append("   AND MST.PGM_NO = DTL.PGM_NO(+)" ).append("\n"); 
		query.append("   AND MST.RPT_FOM_NO = DTL.RPT_FOM_NO" ).append("\n"); 
		query.append("   AND MST.RPT_FOM_NO = @[rpt_fom_no]" ).append("\n"); 
		query.append("   AND MST.PGM_NO = @[pgm]" ).append("\n"); 
		query.append("   AND MST.CRE_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("   AND MST.RPT_FOM_NM = @[rpt_fom_nm]" ).append("\n"); 
		query.append(" ORDER BY DP_SEQ" ).append("\n"); 

	}
}
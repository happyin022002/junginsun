/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WeeklyCMDBDAOAddOnewayBkgCostCalcCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.21
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2015.05.21 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOAddOnewayBkgCostCalcCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ONEWAY 삭제된 BKG번호를 일배치 테이블에 INSERT(재계산을 위해)
	  * </pre>
	  */
	public WeeklyCMDBDAOAddOnewayBkgCostCalcCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOAddOnewayBkgCostCalcCSQL").append("\n"); 
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
		query.append("MERGE INTO MAS_BKG_COST_CALC A" ).append("\n"); 
		query.append("USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  SELECT @[bkg_no] BKG_NO" ).append("\n"); 
		query.append("        ,'E' MAS_BAT_CD" ).append("\n"); 
		query.append("        ,2 MAS_BAT_SEQ" ).append("\n"); 
		query.append("        ,'ONE WAY BKG CALCEL' MAS_BAT_RMK" ).append("\n"); 
		query.append("        ,0 MAS_MNL_BAT_SEQ" ).append("\n"); 
		query.append("        ,'MAS_ONEWAY' CRE_USR_ID" ).append("\n"); 
		query.append("        ,'MAS_ONEWAY' UPD_USR_ID" ).append("\n"); 
		query.append("    FROM DUAL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON (A.BKG_NO = B.BKG_NO)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("  UPDATE SET A.MAS_BAT_CD = B.MAS_BAT_CD" ).append("\n"); 
		query.append("            ,A.MAS_BAT_SEQ = B.MAS_BAT_SEQ" ).append("\n"); 
		query.append("            ,A.MAS_BAT_DT = SYSDATE" ).append("\n"); 
		query.append("            ,A.MAS_BAT_RMK = B.MAS_BAT_RMK" ).append("\n"); 
		query.append("            ,A.MAS_MNL_BAT_SEQ = B.MAS_MNL_BAT_SEQ" ).append("\n"); 
		query.append("            ,A.CRE_USR_ID = B.CRE_USR_ID" ).append("\n"); 
		query.append("            ,A.CRE_DT = SYSDATE" ).append("\n"); 
		query.append("            ,A.UPD_USR_ID = B.UPD_USR_ID" ).append("\n"); 
		query.append("            ,A.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("  INSERT (BKG_NO, MAS_BAT_CD, MAS_BAT_SEQ, MAS_BAT_DT, MAS_BAT_RMK, MAS_MNL_BAT_CD, MAS_MNL_BAT_SEQ, MAS_MNL_BAT_DT, MAS_MNL_BAT_RMK, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("  VALUES (@[bkg_no], 'E', 2, SYSDATE, 'ONE WAY BKG CALCEL', NULL, 0, NULL, NULL, 'MAS_ONEWAY', SYSDATE, 'MAS_ONEWAY', SYSDATE)" ).append("\n"); 

	}
}
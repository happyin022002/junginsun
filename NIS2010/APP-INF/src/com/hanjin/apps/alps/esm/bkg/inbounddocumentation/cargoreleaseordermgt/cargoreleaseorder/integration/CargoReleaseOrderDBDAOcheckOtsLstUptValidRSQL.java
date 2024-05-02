/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOcheckOtsLstUptValidRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.03
*@LastModifier : 윤한
*@LastVersion : 1.0
* 2010.09.03 윤한
* 1.0 Creation

 --------------------------------------------------------------------------------------
* History
* 2010.09.06 이지영 [CHM-201005721-01] [ESM-BKG] VVD별 OTS 미수금 수신
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOcheckOtsLstUptValidRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkOtsLstUptValid
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOcheckOtsLstUptValidRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_tj_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOcheckOtsLstUptValidRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN NVL(@[ots_tj_seq],0) " ).append("\n"); 
		query.append("                 > OTS_TJ_SEQ  THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 'N' END  AS CHK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("     SELECT NVL(MAX(OTS_TJ_SEQ),0) AS OTS_TJ_SEQ" ).append("\n"); 
		query.append("     FROM BKG_OUTSTANDING OTS" ).append("\n"); 
		query.append("     WHERE LST_UPD_CHK_DT IS NOT NULL" ).append("\n"); 
		query.append("     AND   OFC_CD    = @[ofc_cd]" ).append("\n"); 
		query.append("     AND   CLT_BL_NO = @[clt_bl_no]" ).append("\n"); 
		query.append("     AND   INV_NO    = @[inv_no]" ).append("\n"); 
		query.append("     AND ROWNUM = 1" ).append("\n"); 
		query.append(") A" ).append("\n"); 

	}
}
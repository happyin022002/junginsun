/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchOblInterSerNoCheckInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchOblInterSerNoCheckInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WEB B/L Printed : Serial Number 조회
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchOblInterSerNoCheckInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchOblInterSerNoCheckInfoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("  NVL((SELECT OBL_INTER_SER_NO" ).append("\n"); 
		query.append("         FROM BKG_INET_BL_PRN_AUTH A" ).append("\n"); 
		query.append("        WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("          AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("          AND A.INFO_SEQ IN (" ).append("\n"); 
		query.append("              SELECT MAX(INFO_SEQ)" ).append("\n"); 
		query.append("                FROM BKG_INET_BL_PRN_AUTH X" ).append("\n"); 
		query.append("               WHERE X.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                 AND X.DELT_FLG = 'N')),'') OBL_INTER_SER_NO," ).append("\n"); 
		query.append("  NVL((SELECT OBL_INTER_SER_NO_CHK_USR_ID FROM  BKG_DO_REF WHERE BKG_NO = @[bkg_no]),'') OBL_INTER_SER_NO_CHK_USR_ID ," ).append("\n"); 
		query.append("  NVL((SELECT TO_CHAR(OBL_INTER_SER_NO_CHK_DT,'YYYY-MM-DD HH24:MI') FROM  BKG_DO_REF WHERE BKG_NO = @[bkg_no]),'') AS OBL_INTER_SER_NO_CHK_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ManualARCreationDBDAOsearchBlckChgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.03
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.12.03 Do Soon Choi
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do Soon Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualARCreationDBDAOsearchBlckChgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ManualARCreationDBDAOsearchBlckChgRSQL
	  * </pre>
	  */
	public ManualARCreationDBDAOsearchBlckChgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration").append("\n"); 
		query.append("FileName : ManualARCreationDBDAOsearchBlckChgRSQL").append("\n"); 
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
		query.append("SELECT CHG_CD" ).append("\n"); 
		query.append("  FROM INV_AR_MISC_BLCK_CHG A" ).append("\n"); 
		query.append(" WHERE A.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("   AND A.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append(" UNION  " ).append("\n"); 
		query.append("SELECT B.CHG_CD" ).append("\n"); 
		query.append("  FROM INV_AR_LOCL_CHG B" ).append("\n"); 
		query.append(" WHERE B.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("   AND B.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 1 FROM INV_AR_STUP_OFC WHERE AR_OFC_CD = B.AR_OFC_CD AND MRI_LOCL_CHG_APLY_FLG ='Y')" ).append("\n"); 

	}
}
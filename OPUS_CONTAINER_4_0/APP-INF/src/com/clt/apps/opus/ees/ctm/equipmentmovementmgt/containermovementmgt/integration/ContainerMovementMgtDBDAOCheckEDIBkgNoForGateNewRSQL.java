/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOCheckEDIBkgNoForGateNewRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOCheckEDIBkgNoForGateNewRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckEDIBkgNoForGateNew
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOCheckEDIBkgNoForGateNewRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_number",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_number",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOCheckEDIBkgNoForGateNewRSQL").append("\n"); 
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
		query.append("SELECT 1" ).append("\n"); 
		query.append("  FROM BKG_BOOKING" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND BKG_NO = NVL(@[bkg_number],@[bl_number])" ).append("\n"); 
		query.append("   AND BKG_CGO_TP_CD IN ('P', 'R')" ).append("\n"); 

	}
}
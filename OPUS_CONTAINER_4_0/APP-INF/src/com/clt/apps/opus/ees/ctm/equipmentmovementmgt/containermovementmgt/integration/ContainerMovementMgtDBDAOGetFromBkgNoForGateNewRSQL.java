/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOGetFromBkgNoForGateNewRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOGetFromBkgNoForGateNewRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetFromBkgNoForGateNew
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOGetFromBkgNoForGateNewRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration ").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOGetFromBkgNoForGateNewRSQL").append("\n"); 
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
		query.append("SELECT NVL (BKG_NO, '') AS FROM_BKG" ).append("\n"); 
		query.append("  FROM BKG_BOOKING" ).append("\n"); 
		query.append(" WHERE TO_BKG_NO = @[bkg_number]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT NVL (BKG_NO, '') AS FROM_BKG" ).append("\n"); 
		query.append("  FROM CTM_BOOKING" ).append("\n"); 
		query.append(" WHERE TO_BKG_NO = @[bkg_number]" ).append("\n"); 

	}
}
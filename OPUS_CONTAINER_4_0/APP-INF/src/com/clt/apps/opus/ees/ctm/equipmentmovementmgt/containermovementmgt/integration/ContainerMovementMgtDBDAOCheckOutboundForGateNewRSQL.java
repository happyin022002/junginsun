/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOCheckOutboundForGateNewRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.01 
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

public class ContainerMovementMgtDBDAOCheckOutboundForGateNewRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckOutboundForGateNew
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOCheckOutboundForGateNewRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOCheckOutboundForGateNewRSQL").append("\n"); 
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
		query.append("  FROM BKG_BOOKING BB" ).append("\n"); 
		query.append(" WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND (SUBSTR(BB.POR_CD, 1, 2) = SUBSTR(@[org_yd_cd], 1, 2) OR SUBSTR(BB.POL_CD, 1, 2) = SUBSTR(@[org_yd_cd], 1, 2))" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 1" ).append("\n"); 
		query.append("  FROM CTM_BOOKING BB" ).append("\n"); 
		query.append(" WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND (SUBSTR(BB.POR_CD, 1, 2) = SUBSTR(@[org_yd_cd], 1, 2) OR SUBSTR(BB.POL_CD, 1, 2) = SUBSTR(@[org_yd_cd], 1, 2))" ).append("\n"); 

	}
}
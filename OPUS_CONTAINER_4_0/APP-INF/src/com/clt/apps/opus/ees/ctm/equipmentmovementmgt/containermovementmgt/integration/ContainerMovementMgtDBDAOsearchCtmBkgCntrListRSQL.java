/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOsearchCtmBkgCntrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.09 
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

public class ContainerMovementMgtDBDAOsearchCtmBkgCntrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SEARCH CTM BOOKING CONTAINER LIST BY CONTAINER
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOsearchCtmBkgCntrListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_bkgno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_cntrno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOsearchCtmBkgCntrListRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1) FIND" ).append("\n"); 
		query.append("  FROM CTM_BKG_CNTR CNT, CTM_BOOKING BKG" ).append("\n"); 
		query.append(" WHERE CNT.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("   AND NVL(BKG.BKG_STS_CD,' ') <> 'S'" ).append("\n"); 
		query.append("   AND NVL(BKG.BKG_STS_CD,' ') <> 'X'" ).append("\n"); 
		query.append("   AND CNT.CNTR_NO LIKE @[p_cntrno]||'%'" ).append("\n"); 
		query.append("   AND CNT.BKG_NO = @[p_bkgno]" ).append("\n"); 

	}
}
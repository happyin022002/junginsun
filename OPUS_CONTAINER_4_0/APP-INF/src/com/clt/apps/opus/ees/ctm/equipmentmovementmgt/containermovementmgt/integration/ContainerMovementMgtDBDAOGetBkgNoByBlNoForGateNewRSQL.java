/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOGetBkgNoByBlNoForGateNewRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.13
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.01.13 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOGetBkgNoByBlNoForGateNewRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BL 번호만 넘어 왔을 때 BL번호로 Bkg 번호를 조회한다
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOGetBkgNoByBlNoForGateNewRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOGetBkgNoByBlNoForGateNewRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("       NVL (BKG_STS_CD, '') AS BKG_STS_CD" ).append("\n"); 
		query.append("  FROM BKG_BOOKING" ).append("\n"); 
		query.append(" WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("       NVL (BKG_STS_CD, '') AS BKG_STS_CD" ).append("\n"); 
		query.append("  FROM CTM_BOOKING" ).append("\n"); 
		query.append(" WHERE BL_NO = @[bl_no]" ).append("\n"); 

	}
}
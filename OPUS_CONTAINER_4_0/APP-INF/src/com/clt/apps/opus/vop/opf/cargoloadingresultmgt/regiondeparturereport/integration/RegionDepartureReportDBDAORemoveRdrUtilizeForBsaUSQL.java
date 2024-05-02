/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RegionDepartureReportDBDAORemoveRdrUtilizeForBsaUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RegionDepartureReportDBDAORemoveRdrUtilizeForBsaUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * HC45에서 전체 삭제시 Rdr Utilize의 내용은 Clear 한다.
	  * VVD별, REGION CLEAR
	  * </pre>
	  */
	public RegionDepartureReportDBDAORemoveRdrUtilizeForBsaUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("region",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("update_user",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration").append("\n"); 
		query.append("FileName : RegionDepartureReportDBDAORemoveRdrUtilizeForBsaUSQL").append("\n"); 
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
		query.append("UPDATE RDR_UTILIZE" ).append("\n"); 
		query.append("  SET  SLOT_QTY     = CASE WHEN TYPE IN ('3', 'H', 'L')  THEN NULL ELSE SLOT_QTY END" ).append("\n"); 
		query.append(",      SLOT_HC20    = CASE WHEN TYPE  = 'F'  THEN NULL ELSE TO_CHAR(SLOT_HC20)  END" ).append("\n"); 
		query.append(",      SLOT_HC      = CASE WHEN TYPE  = 'F'  THEN NULL ELSE TO_CHAR(SLOT_HC)    END" ).append("\n"); 
		query.append(",      SLOT_45      = CASE WHEN TYPE  = 'F'  THEN NULL ELSE TO_CHAR(SLOT_45)    END" ).append("\n"); 
		query.append(",      UPDATE_USER  = @[update_user]" ).append("\n"); 
		query.append(",      UPDATE_TIME  = SYSDATE" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("      VSL_CD =   @[vsl_cd]" ).append("\n"); 
		query.append("  AND VOY_NO =   @[voy_no]" ).append("\n"); 
		query.append("  AND DIR_CD =   @[dir_cd]" ).append("\n"); 
		query.append("  AND REGION =   @[region]" ).append("\n"); 
		query.append("  AND TYPE   IN ('3', 'H', 'L', 'F') --3,H,L, 20H, 40H, 45, F:에 LOAD물량." ).append("\n"); 

	}
}
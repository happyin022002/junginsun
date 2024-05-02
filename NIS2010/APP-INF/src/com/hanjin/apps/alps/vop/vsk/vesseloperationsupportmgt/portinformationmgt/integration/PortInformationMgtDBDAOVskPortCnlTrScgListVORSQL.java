/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PortInformationMgtDBDAOVskPortCnlTrScgListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortInformationMgtDBDAOVskPortCnlTrScgListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SKD_DIR_CD 추가 -- 2014.06.16
	  * </pre>
	  */
	public PortInformationMgtDBDAOVskPortCnlTrScgListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.integration").append("\n"); 
		query.append("FileName : PortInformationMgtDBDAOVskPortCnlTrScgListVORSQL").append("\n"); 
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
		query.append("SELECT LOC_CD" ).append("\n"); 
		query.append(",	SKD_DIR_CD " ).append("\n"); 
		query.append(",      MAX(DECODE(TR_SEQ, 1, TR_SCG_RTO, '')) AS VSL_TR_NO1" ).append("\n"); 
		query.append(",      MAX(DECODE(TR_SEQ, 2, TR_SCG_RTO, '')) AS VSL_TR_NO2" ).append("\n"); 
		query.append(",      MAX(DECODE(TR_SEQ, 3, TR_SCG_RTO, '')) AS VSL_TR_NO3" ).append("\n"); 
		query.append(",      MAX(DECODE(TR_SEQ, 4, TR_SCG_RTO, '')) AS VSL_TR_NO4" ).append("\n"); 
		query.append(",      MAX(DECODE(TR_SEQ, 5, TR_SCG_RTO, '')) AS VSL_TR_NO5" ).append("\n"); 
		query.append(",      MAX(DECODE(TR_SEQ, 6, TR_SCG_RTO, '')) AS VSL_TR_NO6" ).append("\n"); 
		query.append(",      MAX(DECODE(TR_SEQ, 7, TR_SCG_RTO, '')) AS VSL_TR_NO7" ).append("\n"); 
		query.append(",      MAX(DECODE(TR_SEQ, 8, TR_SCG_RTO, '')) AS VSL_TR_NO8" ).append("\n"); 
		query.append(",      MAX(DECODE(TR_SEQ, 9, TR_SCG_RTO, '')) AS VSL_TR_NO9" ).append("\n"); 
		query.append("  FROM VSK_PORT_CNL_TR_SCG" ).append("\n"); 
		query.append(" WHERE LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append(" GROUP BY LOC_CD, SKD_DIR_CD" ).append("\n"); 

	}
}
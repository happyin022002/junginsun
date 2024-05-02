/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : USA214CntrTrackingManageDBDAOUsa214CntrTrackingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.02
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2009.12.02 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.usa214cntrtrackingmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USA214CntrTrackingManageDBDAOUsa214CntrTrackingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Usa214CntrTracking 조회
	  * </pre>
	  */
	public USA214CntrTrackingManageDBDAOUsa214CntrTrackingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.common.usa214cntrtrackingmanage.integration ").append("\n"); 
		query.append("FileName : USA214CntrTrackingManageDBDAOUsa214CntrTrackingRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("BKG_CNTR.CNTR_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append(",BKG_CONTAINER BKG_CNTR" ).append("\n"); 
		query.append("WHERE SO.BKG_NO          = BKG_CNTR.BKG_NO" ).append("\n"); 
		query.append("AND SO.TRSP_SO_OFC_CTY_CD = SUBSTR(@[so_no],1,3)" ).append("\n"); 
		query.append("AND SO.TRSP_SO_SEQ        = SUBSTR(@[so_no],4)" ).append("\n"); 
		query.append("AND BKG_CNTR.CNTR_NO      = @[cntr_no]" ).append("\n"); 
		query.append("AND SO.COST_ACT_GRP_CD        LIKE 'OD%'" ).append("\n"); 
		query.append("AND SO.EQ_NO           IS NULL" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}
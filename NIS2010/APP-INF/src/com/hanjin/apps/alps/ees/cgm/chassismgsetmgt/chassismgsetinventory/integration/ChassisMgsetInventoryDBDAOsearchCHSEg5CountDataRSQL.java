/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOsearchCHSEg5CountDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.09.25 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Shung, Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInventoryDBDAOsearchCHSEg5CountDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20090811 1111 start
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOsearchCHSEg5CountDataRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOsearchCHSEg5CountDataRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("b.yd_cd AS YD_CD," ).append("\n"); 
		query.append("NVL((select t1.eg5_pre_knt_qty from cgm_chss_utl_eg5_knt t1 where b.yd_cd = t1.yd_cd),0) AS EG5_PRE_KNT_QTY" ).append("\n"); 
		query.append("from MDM_LOCATION  a, MDM_YARD b" ).append("\n"); 
		query.append("where  a.scc_cd = @[loc_cd]" ).append("\n"); 
		query.append("AND b.loc_cd = a.loc_cd" ).append("\n"); 
		query.append("AND A.delt_flg = 'N'" ).append("\n"); 
		query.append("AND b.delt_flg = 'N'" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomerEdiDBDAOSearchVesselSkdCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.28
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.01.28 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee YounJung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerEdiDBDAOSearchVesselSkdCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchVesselSkdCnt
	  * </pre>
	  */
	public CustomerEdiDBDAOSearchVesselSkdCntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edate_hidden",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sdate_hidden",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration ").append("\n"); 
		query.append("FileName : CustomerEdiDBDAOSearchVesselSkdCntRSQL").append("\n"); 
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
		query.append("COUNT(1)" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${etdeta} != '' && ${etdeta} == 'D')" ).append("\n"); 
		query.append("#set($table_ = 'VPS_ETD_DT' )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#set($table_ = 'VPS_ETA_DT' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sdate_hidden} != '' || ${edate_hidden} != '' )" ).append("\n"); 
		query.append("AND $table_ BETWEEN TO_DATE( NVL( @[sdate_hidden], '1900-01-01'), 'YYYY-MM-DD' ) AND TO_DATE( NVL( @[edate_hidden], '9999-12-31'), 'YYYY-MM-DD' )  + 0.9999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${vvd_cd} != '')" ).append("\n"); 
		query.append("AND VSL_CD || SKD_VOY_NO || SKD_DIR_CD LIKE '%${vvd_cd}%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${loc_cd} != '')" ).append("\n"); 
		query.append("AND VPS_PORT_CD LIKE '%${loc_cd}%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${lane_cd} != '')" ).append("\n"); 
		query.append("AND SLAN_CD LIKE '%${lane_cd}%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND NVL(SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("AND CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("ORDER BY SLAN_CD , VSL_CD || SKD_VOY_NO || SKD_DIR_CD , TO_NUMBER(CLPT_SEQ)" ).append("\n"); 

	}
}
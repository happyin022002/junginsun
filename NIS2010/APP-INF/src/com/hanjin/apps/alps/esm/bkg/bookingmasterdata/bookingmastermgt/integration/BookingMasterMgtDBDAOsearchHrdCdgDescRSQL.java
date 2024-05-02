/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BookingMasterMgtDBDAOsearchHrdCdgDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.27
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.08.27 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOsearchHrdCdgDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * HrdCdgDesc 테이블에서 select한다.
	  * </pre>
	  */
	public BookingMasterMgtDBDAOsearchHrdCdgDescRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hrd_cdg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hrd_cdg_desc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOsearchHrdCdgDescRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("HRD_CDG_ID," ).append("\n"); 
		query.append("HRD_CDG_DESC," ).append("\n"); 
		query.append("ATTR_NM1," ).append("\n"); 
		query.append("ATTR_NM2," ).append("\n"); 
		query.append("ATTR_NM3," ).append("\n"); 
		query.append("ATTR_NM4," ).append("\n"); 
		query.append("ATTR_NM5," ).append("\n"); 
		query.append("ATTR_NM6," ).append("\n"); 
		query.append("ATTR_NM7," ).append("\n"); 
		query.append("ATTR_NM8," ).append("\n"); 
		query.append("ATTR_NM9," ).append("\n"); 
		query.append("ATTR_NM10" ).append("\n"); 
		query.append("FROM BKG_HRD_CDG_DESC" ).append("\n"); 
		query.append("where 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${hrd_cdg_id}!='')" ).append("\n"); 
		query.append("	AND UPPER(HRD_CDG_ID) LIKE UPPER('%'||@[hrd_cdg_id]||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${hrd_cdg_desc}!='')" ).append("\n"); 
		query.append("	AND UPPER(HRD_CDG_DESC) LIKE UPPER('%'||@[hrd_cdg_desc]||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY HRD_CDG_ID" ).append("\n"); 

	}
}
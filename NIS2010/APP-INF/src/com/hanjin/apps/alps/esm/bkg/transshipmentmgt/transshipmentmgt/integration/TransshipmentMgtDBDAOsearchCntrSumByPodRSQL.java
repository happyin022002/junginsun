/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransshipmentMgtDBDAOsearchCntrSumByPodRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.06.19 최영희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Yeoung Hee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransshipmentMgtDBDAOsearchCntrSumByPodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public TransshipmentMgtDBDAOsearchCntrSumByPodRSQL(){
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
		query.append("select vvd.pod_cd" ).append("\n"); 
		query.append(", SUM(DECODE(SUBSTR(cntr.cntr_tpsz_cd, 2, 1), '2', 1, 0)) ft20" ).append("\n"); 
		query.append(", SUM(DECODE(SUBSTR(cntr.cntr_tpsz_cd, 2, 1), '2', 0, 1)) ft40" ).append("\n"); 
		query.append("from bkg_booking bk, bkg_vvd vvd, bkg_container cntr" ).append("\n"); 
		query.append("where bk.bkg_no       = vvd.bkg_no" ).append("\n"); 
		query.append("and bk.bkg_no       = cntr.bkg_no" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${loc_cd} !='')" ).append("\n"); 
		query.append("and vvd.pod_cd      = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bl_no_list} != '')" ).append("\n"); 
		query.append("and bk.bl_no in(" ).append("\n"); 
		query.append("#foreach($blno IN ${bl_no_list})" ).append("\n"); 
		query.append("#if($velocityCount < $bl_no_list.size())" ).append("\n"); 
		query.append("'$blno'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$blno'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("group by vvd.pod_cd" ).append("\n"); 
		query.append("order by vvd.pod_cd" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration").append("\n"); 
		query.append("FileName : TransshipmentMgtDBDAOsearchCntrSumByPodRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}
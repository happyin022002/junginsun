/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PendingListDBDAOSearchOfcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.soinquiry.pendinglist.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PendingListDBDAOSearchOfcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pending List Ofc Search
	  * </pre>
	  */
	public PendingListDBDAOSearchOfcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hid_rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.soinquiry.pendinglist.integration ").append("\n"); 
		query.append("FileName : PendingListDBDAOSearchOfcRSQL").append("\n"); 
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
		query.append("ofc_cd" ).append("\n"); 
		query.append("FROM  MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE ofc_knd_cd > 1" ).append("\n"); 
		query.append("AND delt_flg = 'N'" ).append("\n"); 
		query.append("START WITH ofc_cd IN" ).append("\n"); 
		query.append("(SELECT ofc_cd FROM  mdm_organization" ).append("\n"); 
		query.append("WHERE ofc_knd_cd = 3" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${hid_rhq} == 'ALL')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND PRNT_OFC_CD = @[hid_rhq] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("CONNECT BY prior ofc_cd = PRNT_OFC_CD" ).append("\n"); 

	}
}
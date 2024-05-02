/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOSearchBkgNoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.05.03 이호선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOSearchBkgNoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * get bkg_no 1, 2, 3
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOSearchBkgNoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOSearchBkgNoDataRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT DECODE(RN,1,BKG_NO) BKG_NO, UPD_DT" ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("    ( " ).append("\n"); 
		query.append("        SELECT A.BKG_NO, A.UPD_DT, ROW_NUMBER() OVER(PARTITION BY A.BKG_NO ORDER BY A.UPD_DT DESC) RN " ).append("\n"); 
		query.append("        FROM CTM_MOVEMENT A" ).append("\n"); 
		query.append("        WHERE 1 = 1 " ).append("\n"); 
		query.append("        AND A.CNTR_NO = MST_COMMON_PKG.MST_CNTR_NO_FNC(@[cntr_no])" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    ORDER BY UPD_DT DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE LENGTH(BKG_NO) > 0" ).append("\n"); 
		query.append("AND ROWNUM < 4" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CopDetailReceiveDBDAOCheckEurBndForCSMRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOCheckEurBndForCSMRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * check Europe Bound for CSM
	  * </pre>
	  */
	public CopDetailReceiveDBDAOCheckEurBndForCSMRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOCheckEurBndForCSMRSQL").append("\n"); 
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
		query.append("SELECT 'EU_BOUND'" ).append("\n"); 
		query.append("FROM BKG_BOOKING B, MDM_COUNTRY M" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND M.CNT_CD IN (SUBSTR(B.POR_CD,1,2), SUBSTR(B.POL_CD,1,2), SUBSTR(B.POD_CD,1,2), SUBSTR(B.DEL_CD,1,2))" ).append("\n"); 
		query.append("AND EU_CNT_FLG = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'EU_BOUND'" ).append("\n"); 
		query.append("FROM BKG_BOOKING B, BKG_VVD V, MDM_COUNTRY M" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND B.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("AND M.CNT_CD IN (SUBSTR(V.POL_CD,1,2), SUBSTR(V.POD_CD,1,2))" ).append("\n"); 
		query.append("AND EU_CNT_FLG = 'Y'" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchUS322ModerateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.25
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.01.25 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchUS322ModerateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchUS322Moderate
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchUS322ModerateRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchUS322ModerateRSQL").append("\n"); 
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
		query.append("SELECT a.cntr_no,a.bkg_no" ).append("\n"); 
		query.append("FROM SCE_COP_HDR A," ).append("\n"); 
		query.append("(SELECT /*+ INDEX_DESC(SCE_COP_HDR XAK3SCE_COP_HDR) */" ).append("\n"); 
		query.append("CNTR_NO,TRNK_VSL_CD,TRNK_SKD_VOY_NO,TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("FROM SCE_COP_HDR" ).append("\n"); 
		query.append("WHERE CNTR_NO LIKE @[cntr_no]" ).append("\n"); 
		query.append("AND COP_STS_CD IN('C','T')" ).append("\n"); 
		query.append("AND ROWNUM = 1 ) B" ).append("\n"); 
		query.append("WHERE A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("AND A.TRNK_VSL_CD = B.TRNK_VSL_CD" ).append("\n"); 
		query.append("AND A.TRNK_SKD_VOY_NO = B.TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.TRNK_SKD_DIR_CD = B.TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.COP_STS_CD IN ('C','T')" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}
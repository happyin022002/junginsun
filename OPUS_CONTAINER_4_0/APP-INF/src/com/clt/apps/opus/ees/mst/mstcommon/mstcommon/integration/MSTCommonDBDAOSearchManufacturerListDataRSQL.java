/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MSTCommonDBDAOSearchManufacturerListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.mstcommon.mstcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MSTCommonDBDAOSearchManufacturerListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MST Common Manufacturer Select
	  * </pre>
	  */
	public MSTCommonDBDAOSearchManufacturerListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.mstcommon.mstcommon.integration").append("\n"); 
		query.append("FileName : MSTCommonDBDAOSearchManufacturerListDataRSQL").append("\n"); 
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
		query.append("SELECT MST_COMMON_PKG.MST_VNDR_SEQ_CONV_FNC(B.VNDR_SEQ) CODE ,NVL(B.VNDR_ABBR_NM,VNDR_LGL_ENG_NM) CODE_NM" ).append("\n"); 
		query.append("FROM MDM_CNTR_VNDR_CLSS A, " ).append("\n"); 
		query.append("     MDM_VENDOR B" ).append("\n"); 
		query.append("WHERE A.CNTR_VNDR_SVC_CD ='MFR'" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("AND NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND NVL(B.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("#if(${vndr_seq} != '')" ).append("\n"); 
		query.append("AND B.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY CODE_NM" ).append("\n"); 

	}
}